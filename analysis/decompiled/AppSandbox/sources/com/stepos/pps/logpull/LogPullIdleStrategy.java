package com.stepos.pps.logpull;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.BatteryManager;
import android.os.PowerManager;
import android.util.Log;

/* loaded from: classes.dex */
public class LogPullIdleStrategy {
    private static final String TAG = "LogPull.Idle";
    private IdleCallback callback;
    private final Context context;
    private BroadcastReceiver receiver;
    private volatile boolean isWifi = false;
    private volatile boolean isCharging = false;
    private volatile boolean isScreenOff = false;

    public interface IdleCallback {
        void onIdleConditionsLost();

        void onIdleConditionsMet();
    }

    public LogPullIdleStrategy(Context context) {
        this.context = context;
    }

    public void startMonitoring(IdleCallback idleCallback) {
        this.callback = idleCallback;
        checkCurrentState();
        registerReceivers();
    }

    public void stopMonitoring() {
        BroadcastReceiver broadcastReceiver = this.receiver;
        if (broadcastReceiver != null) {
            this.context.unregisterReceiver(broadcastReceiver);
            this.receiver = null;
        }
    }

    public boolean isAllConditionsMet() {
        checkCurrentState();
        return conditionsMetCached();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean conditionsMetCached() {
        return this.isWifi && this.isCharging && this.isScreenOff;
    }

    public boolean isWifi() {
        return this.isWifi;
    }

    public boolean isCharging() {
        return this.isCharging;
    }

    public boolean isScreenOff() {
        return this.isScreenOff;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkCurrentState() {
        Network activeNetwork;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.context.getSystemService("connectivity");
        if (connectivityManager != null && (activeNetwork = connectivityManager.getActiveNetwork()) != null) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            this.isWifi = networkCapabilities != null && networkCapabilities.hasTransport(1);
        }
        BatteryManager batteryManager = (BatteryManager) this.context.getSystemService("batterymanager");
        if (batteryManager != null) {
            this.isCharging = batteryManager.isCharging();
        }
        if (((PowerManager) this.context.getSystemService("power")) != null) {
            this.isScreenOff = !r0.isInteractive();
        }
    }

    private void registerReceivers() {
        this.receiver = new BroadcastReceiver() { // from class: com.stepos.pps.logpull.LogPullIdleStrategy.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (action == null) {
                    return;
                }
                boolean zConditionsMetCached = LogPullIdleStrategy.this.conditionsMetCached();
                action.hashCode();
                switch (action) {
                    case "android.intent.action.SCREEN_OFF":
                        LogPullIdleStrategy.this.isScreenOff = true;
                        break;
                    case "android.intent.action.ACTION_POWER_DISCONNECTED":
                        LogPullIdleStrategy.this.isCharging = false;
                        break;
                    case "android.intent.action.SCREEN_ON":
                        LogPullIdleStrategy.this.isScreenOff = false;
                        break;
                    case "android.net.conn.CONNECTIVITY_CHANGE":
                        LogPullIdleStrategy.this.checkCurrentState();
                        break;
                    case "android.intent.action.ACTION_POWER_CONNECTED":
                        LogPullIdleStrategy.this.isCharging = true;
                        break;
                }
                boolean zConditionsMetCached2 = LogPullIdleStrategy.this.conditionsMetCached();
                Log.i(LogPullIdleStrategy.TAG, "闲时条件变更: action=" + action + " wifi=" + LogPullIdleStrategy.this.isWifi + " charging=" + LogPullIdleStrategy.this.isCharging + " screenOff=" + LogPullIdleStrategy.this.isScreenOff + " previouslyMet=" + zConditionsMetCached + " nowMet=" + zConditionsMetCached2);
                if (LogPullIdleStrategy.this.callback != null) {
                    if (!zConditionsMetCached && zConditionsMetCached2) {
                        Log.i(LogPullIdleStrategy.TAG, "闲时条件全部满足");
                        LogPullIdleStrategy.this.callback.onIdleConditionsMet();
                    } else {
                        if (!zConditionsMetCached || zConditionsMetCached2) {
                            return;
                        }
                        Log.i(LogPullIdleStrategy.TAG, "闲时条件丢失");
                        LogPullIdleStrategy.this.callback.onIdleConditionsLost();
                    }
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.context.registerReceiver(this.receiver, intentFilter);
    }
}
