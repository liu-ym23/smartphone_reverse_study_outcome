package com.stepos.statsapp.v3.lib.plugin.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.stepos.statsapp.v3.lib.plugin.receiver.EnvironmentReceiver;
import com.stepos.statsapp.v3.lib.plugin.utils.IntervalTimer;
import com.stepos.statsapp.v3.lib.plugin.utils.NetInfoUtils;
import com.stepos.statsapp.v3.lib.plugin.utils.thread.GlobalExecutor;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class EnvironmentReceiver {
    public static final String CHANGE_NAME_NETWORKCONNECT = "CHANGE_NAME_NETWORKCONNECT";
    public static final String CHANGE_NAME_POWER = "CHANGE_NAME_POWER";
    private static final long NETWORK_JITTER_DELAY = 30000;
    private static final long POWER_JITTER_DELAY = 300000;
    private static final String TAG = "EnvironmentReceiver";
    private static EnvironmentReceiver mEnvironmentReceiver;
    private static final Object sLock = new Object();
    private List<IEnvListener> mEnvListeners = new ArrayList();
    private IntervalTimer mNetworkChangeTimer = new IntervalTimer(30000) { // from class: com.stepos.statsapp.v3.lib.plugin.receiver.EnvironmentReceiver.1
        @Override // com.stepos.statsapp.v3.lib.plugin.utils.IntervalTimer
        public void onTrigger() {
            for (IEnvListener iEnvListener : EnvironmentReceiver.this.mEnvListeners) {
                if (iEnvListener != null) {
                    iEnvListener.environmentChanged(EnvironmentReceiver.CHANGE_NAME_NETWORKCONNECT);
                }
            }
            EnvironmentReceiver.this.mNetworkChangeTimer.cancel();
        }
    };
    private IntervalTimer mPowerChangeTimer = new IntervalTimer(300000) { // from class: com.stepos.statsapp.v3.lib.plugin.receiver.EnvironmentReceiver.2
        @Override // com.stepos.statsapp.v3.lib.plugin.utils.IntervalTimer
        public void onTrigger() {
            for (IEnvListener iEnvListener : EnvironmentReceiver.this.mEnvListeners) {
                if (iEnvListener != null) {
                    iEnvListener.environmentChanged(EnvironmentReceiver.CHANGE_NAME_POWER);
                }
            }
            EnvironmentReceiver.this.mPowerChangeTimer.cancel();
        }
    };

    public interface IEnvListener {
        void environmentChanged(String str);
    }

    public class Receiver extends BroadcastReceiver {
        private Receiver() {
        }

        public static /* synthetic */ void a(Receiver receiver, Context context) {
            receiver.getClass();
            boolean zIsOnline = NetInfoUtils.isOnline(context);
            Logger.d(EnvironmentReceiver.TAG, "CONNECTIVITY_ACTION, isOnline = " + zIsOnline);
            if (zIsOnline) {
                EnvironmentReceiver.this.mNetworkChangeTimer.start();
            } else {
                EnvironmentReceiver.this.mNetworkChangeTimer.cancel();
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context context, Intent intent) {
            if ("android.intent.action.ACTION_POWER_CONNECTED".equals(intent.getAction())) {
                Logger.d(EnvironmentReceiver.TAG, "ACTION_POWER_CONNECTED, charging = true");
                EnvironmentReceiver.this.mPowerChangeTimer.start();
            } else if ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(intent.getAction())) {
                Logger.d(EnvironmentReceiver.TAG, "ACTION_POWER_DISCONNECTED, charging = false");
                EnvironmentReceiver.this.mPowerChangeTimer.cancel();
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                GlobalExecutor.execute(new Runnable() { // from class: com.stepos.statsapp.v3.lib.plugin.receiver.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        EnvironmentReceiver.Receiver.a(this.f30890a, context);
                    }
                });
            }
        }
    }

    private EnvironmentReceiver(Context context) {
        Receiver receiver = new Receiver();
        try {
            context.unregisterReceiver(receiver);
        } catch (Exception unused) {
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            context.registerReceiver(receiver, intentFilter);
        } catch (Exception e10) {
            Logger.w(TAG, "Exception: " + e10.toString() + " - Cause: " + e10.getCause());
        }
    }

    public static EnvironmentReceiver getInstance(Context context) {
        if (mEnvironmentReceiver == null) {
            synchronized (sLock) {
                try {
                    if (mEnvironmentReceiver == null) {
                        mEnvironmentReceiver = new EnvironmentReceiver(context);
                    }
                } finally {
                }
            }
        }
        return mEnvironmentReceiver;
    }

    public void addEnvListener(IEnvListener iEnvListener) {
        List<IEnvListener> list = this.mEnvListeners;
        if (list == null || iEnvListener == null) {
            return;
        }
        list.add(iEnvListener);
    }
}
