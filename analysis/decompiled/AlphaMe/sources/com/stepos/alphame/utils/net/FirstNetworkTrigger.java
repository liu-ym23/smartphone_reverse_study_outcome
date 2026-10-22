package com.stepos.alphame.utils.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.stepos.alphame.common.data.DataStoreManager;
import com.stepos.alphame.common.data.DataStorePreferences;
import com.stepos.alphame.utils.NetworkHelper;

/* loaded from: classes.dex */
public class FirstNetworkTrigger {
    private static final String KEY_FIRST_NETWORK_TRIGGER = "KEY_FIRST_NETWORK_TRIGGER";
    private ConnectivityManager mConnectivityManager;
    private final Context mContext;
    private DataStorePreferences mDataStore;
    private ConnectivityManager.NetworkCallback mNetworkCallback;

    public interface OnNetworkReadyListener {
        void onFirstNetworkReady();
    }

    public FirstNetworkTrigger(Context context) {
        this.mContext = context.getApplicationContext();
        DataStorePreferences dataStore = DataStoreManager.INSTANCE.getDataStore("personalPreference", context);
        this.mDataStore = dataStore;
        dataStore.putData(KEY_FIRST_NETWORK_TRIGGER, Boolean.FALSE);
    }

    private boolean isTriggered() {
        return ((Boolean) this.mDataStore.getData(KEY_FIRST_NETWORK_TRIGGER, Boolean.FALSE)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerAction(OnNetworkReadyListener onNetworkReadyListener) {
        if (isTriggered()) {
            return;
        }
        if (onNetworkReadyListener != null) {
            onNetworkReadyListener.onFirstNetworkReady();
            this.mDataStore.putData(KEY_FIRST_NETWORK_TRIGGER, Boolean.TRUE);
        }
        stopMonitor();
    }

    public void startMonitor(final OnNetworkReadyListener onNetworkReadyListener) {
        if (isTriggered()) {
            return;
        }
        if (NetworkHelper.isConnectionAvailable(this.mContext)) {
            triggerAction(onNetworkReadyListener);
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        this.mConnectivityManager = connectivityManager;
        if (connectivityManager == null) {
            return;
        }
        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.stepos.alphame.utils.net.FirstNetworkTrigger.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                super.onAvailable(network);
                NetworkCapabilities networkCapabilities = FirstNetworkTrigger.this.mConnectivityManager.getNetworkCapabilities(network);
                if (networkCapabilities == null || !networkCapabilities.hasCapability(12)) {
                    return;
                }
                FirstNetworkTrigger.this.triggerAction(onNetworkReadyListener);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                super.onCapabilitiesChanged(network, networkCapabilities);
                boolean zHasCapability = networkCapabilities.hasCapability(12);
                boolean zHasCapability2 = networkCapabilities.hasCapability(16);
                if (zHasCapability && zHasCapability2) {
                    FirstNetworkTrigger.this.triggerAction(onNetworkReadyListener);
                }
            }
        };
        this.mNetworkCallback = networkCallback;
        try {
            this.mConnectivityManager.registerDefaultNetworkCallback(networkCallback);
        } catch (Exception unused) {
        }
    }

    public void stopMonitor() {
        ConnectivityManager.NetworkCallback networkCallback;
        ConnectivityManager connectivityManager = this.mConnectivityManager;
        if (connectivityManager == null || (networkCallback = this.mNetworkCallback) == null) {
            return;
        }
        try {
            connectivityManager.unregisterNetworkCallback(networkCallback);
        } catch (Exception unused) {
        }
        this.mNetworkCallback = null;
    }
}
