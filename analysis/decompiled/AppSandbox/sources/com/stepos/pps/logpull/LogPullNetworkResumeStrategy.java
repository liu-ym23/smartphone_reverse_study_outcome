package com.stepos.pps.logpull;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.util.Log;

/* loaded from: classes.dex */
public class LogPullNetworkResumeStrategy {
    private static final String TAG = "LogPull.Net";
    private ConnectivityManager.NetworkCallback callback;
    private final ConnectivityManager cm;
    private volatile boolean wifiValidated = false;
    private volatile boolean nonWifiValidated = false;

    public interface Callback {
        void onLost();

        void onNonWifiValidated();

        void onWifiValidated();
    }

    public LogPullNetworkResumeStrategy(Context context) {
        this.cm = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
    }

    public void startMonitoring(final Callback callback) {
        if (this.cm == null) {
            Log.w(TAG, "ConnectivityManager 不可用");
            return;
        }
        stopMonitoring();
        refreshSnapshot();
        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.stepos.pps.logpull.LogPullNetworkResumeStrategy.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                LogPullNetworkResumeStrategy.this.evaluate(networkCapabilities, callback);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                LogPullNetworkResumeStrategy.this.wifiValidated = false;
                LogPullNetworkResumeStrategy.this.nonWifiValidated = false;
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onLost();
                }
            }
        };
        this.callback = networkCallback;
        try {
            this.cm.registerDefaultNetworkCallback(networkCallback);
        } catch (Exception e) {
            Log.e(TAG, "registerDefaultNetworkCallback 失败", e);
            this.callback = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void evaluate(NetworkCapabilities networkCapabilities, Callback callback) {
        boolean z = false;
        boolean z2 = networkCapabilities != null && networkCapabilities.hasCapability(16) && networkCapabilities.hasCapability(12);
        boolean z3 = z2 && networkCapabilities.hasTransport(1);
        boolean z4 = z2 && !z3;
        boolean z5 = z3 && !this.wifiValidated;
        if (z4 && !this.nonWifiValidated) {
            z = true;
        }
        this.wifiValidated = z3;
        this.nonWifiValidated = z4;
        if (callback == null) {
            return;
        }
        if (z5) {
            Log.i(TAG, "WiFi 有效网络就绪 → 触发续传");
            callback.onWifiValidated();
        } else if (z) {
            Log.i(TAG, "非 WiFi 有效网络就绪 → 询问上传方式");
            callback.onNonWifiValidated();
        }
    }

    private void refreshSnapshot() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        boolean z = false;
        this.wifiValidated = false;
        this.nonWifiValidated = false;
        ConnectivityManager connectivityManager = this.cm;
        if (connectivityManager == null || (activeNetwork = connectivityManager.getActiveNetwork()) == null || (networkCapabilities = this.cm.getNetworkCapabilities(activeNetwork)) == null) {
            return;
        }
        boolean z2 = networkCapabilities.hasCapability(16) && networkCapabilities.hasCapability(12);
        boolean z3 = z2 && networkCapabilities.hasTransport(1);
        this.wifiValidated = z3;
        if (z2 && !z3) {
            z = true;
        }
        this.nonWifiValidated = z;
    }

    public boolean hasValidatedWifi() {
        refreshSnapshot();
        return this.wifiValidated;
    }

    public boolean hasValidatedNonWifi() {
        refreshSnapshot();
        return this.nonWifiValidated;
    }

    public void stopMonitoring() {
        ConnectivityManager.NetworkCallback networkCallback;
        ConnectivityManager connectivityManager = this.cm;
        if (connectivityManager != null && (networkCallback = this.callback) != null) {
            try {
                connectivityManager.unregisterNetworkCallback(networkCallback);
            } catch (Exception unused) {
            }
        }
        this.callback = null;
    }
}
