package com.android.server.am;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.RemoteException;
import android.telephony.NetworkRegistrationInfo;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.android.internal.app.IBatteryStats;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.policy.PhoneWindowManager;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes.dex */
public class DataConnectionStats extends BroadcastReceiver {
    private static final boolean DEBUG = false;
    private static final String TAG = "DataConnectionStats";
    private final IBatteryStats mBatteryStats;
    private final Context mContext;
    private int mDataState;
    private final Handler mListenerHandler;
    private int mNrState;
    private final PhoneStateListener mPhoneStateListener;
    private ServiceState mServiceState;
    private SignalStrength mSignalStrength;
    private int mSimState;

    private static class PhoneStateListenerExecutor implements Executor {
        private final Handler mHandler;

        PhoneStateListenerExecutor(Handler handler) {
            this.mHandler = handler;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            if (this.mHandler.post(command) == false) goto L6;
            return;
        L6:
            throw new RejectedExecutionException(this.mHandler + " is shutting down");
        }
    }

    private class PhoneStateListenerImpl extends PhoneStateListener {
        final /* synthetic */ DataConnectionStats this$0;

        PhoneStateListenerImpl(DataConnectionStats r1, Executor executor) {
            this.this$0 = r1;
            super(executor);
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            DataConnectionStats.m1507$$Nest$fputmSignalStrength(this.this$0, signalStrength);
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(ServiceState state) {
            DataConnectionStats.m1506$$Nest$fputmServiceState(this.this$0, state);
            DataConnectionStats.m1505$$Nest$fputmNrState(this.this$0, state.getNrState());
            DataConnectionStats.m1508$$Nest$mnotePhoneDataConnectionState(this.this$0);
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int state, int networkType) {
            DataConnectionStats.m1504$$Nest$fputmDataState(this.this$0, state);
            DataConnectionStats.m1508$$Nest$mnotePhoneDataConnectionState(this.this$0);
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataActivity(int direction) {
            DataConnectionStats.m1508$$Nest$mnotePhoneDataConnectionState(this.this$0);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDataState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1504$$Nest$fputmDataState(DataConnectionStats r0, int r1) {
        r0.mDataState = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmNrState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1505$$Nest$fputmNrState(DataConnectionStats r0, int r1) {
        r0.mNrState = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmServiceState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1506$$Nest$fputmServiceState(DataConnectionStats r0, ServiceState r1) {
        r0.mServiceState = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmSignalStrength, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1507$$Nest$fputmSignalStrength(DataConnectionStats r0, SignalStrength r1) {
        r0.mSignalStrength = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mnotePhoneDataConnectionState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1508$$Nest$mnotePhoneDataConnectionState(DataConnectionStats r0) {
        r0.notePhoneDataConnectionState();
    }

    public DataConnectionStats(Context context, Handler listenerHandler) {
        this.mSimState = 5;
        this.mDataState = 0;
        this.mNrState = 0;
        this.mContext = context;
        this.mBatteryStats = BatteryStatsService.getService();
        this.mListenerHandler = listenerHandler;
        this.mPhoneStateListener = new PhoneStateListenerImpl(this, new PhoneStateListenerExecutor(listenerHandler));
    }

    public void startMonitoring() {
        TelephonyManager phone = (TelephonyManager) this.mContext.getSystemService(TelephonyManager.class);
        phone.listen(this.mPhoneStateListener, FrameworkStatsLog.DREAM_UI_EVENT_REPORTED);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.SIM_STATE_CHANGED");
        this.mContext.registerReceiver(this, filter, null, this.mListenerHandler);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("android.intent.action.SIM_STATE_CHANGED") == false) goto L6;
        updateSimState(intent);
        notePhoneDataConnectionState();
        return;
    }

    private void notePhoneDataConnectionState() {
        if (this.mServiceState != null) goto L6;
        return;
    L6:
        if (this.mSimState != 5) goto L8;
    L11:
        boolean r0 = true;
    L12:
        boolean simReadyOrUnknown = r0;
        if (simReadyOrUnknown == true) goto L17;
        if (isCdma() == true) goto L17;
    L21:
        boolean r4 = false;
    L22:
        boolean visible = r4;
        NetworkRegistrationInfo regInfo = this.mServiceState.getNetworkRegistrationInfo(2, 1);
        if (regInfo != null) goto L25;
        int networkType = 0;
    L32:
        this.mBatteryStats.notePhoneDataConnectionState(networkType, visible, this.mServiceState.getState(), this.mNrState, this.mServiceState.getNrFrequencyRange());     // Catch: RemoteException -> L29
        return;
    L29:
        e = move-exception;
        Log.w(TAG, "Error noting data connection state", e);
        return;
    L25:
        networkType = regInfo.getAccessNetworkTechnology();
    L17:
        if (hasService() == false) goto L21;
        if (this.mDataState != 2) goto L21;
        r4 = true;
        goto L22
    L8:
        if (this.mSimState == 0) goto L11;
        r0 = false;
        goto L12
    }

    private void updateSimState(Intent intent) {
        String stateExtra = intent.getStringExtra("ss");
        if ("ABSENT".equals(stateExtra) == false) goto L6;
        this.mSimState = 1;
        return;
    L6:
        if ("READY".equals(stateExtra) == false) goto L9;
        this.mSimState = 5;
        return;
    L9:
        if ("LOCKED".equals(stateExtra) == false) goto L18;
        String lockedReason = intent.getStringExtra(PhoneWindowManager.SYSTEM_DIALOG_REASON_KEY);
        if ("PIN".equals(lockedReason) == false) goto L14;
        this.mSimState = 2;
        return;
    L14:
        if ("PUK".equals(lockedReason) == false) goto L16;
        this.mSimState = 3;
        return;
    L16:
        this.mSimState = 4;
        return;
    L18:
        this.mSimState = 0;
    }

    private boolean isCdma() {
        if (this.mSignalStrength != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mSignalStrength.isGsm() == true) goto L7;
        return true;
    }

    private boolean hasService() {
        if (this.mServiceState != null) goto L5;
    L9:
        return false;
    L5:
        if (this.mServiceState.getState() == 1) goto L9;
        if (this.mServiceState.getState() == 3) goto L9;
        return true;
    }
}
