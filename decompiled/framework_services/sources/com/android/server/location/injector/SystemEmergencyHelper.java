package com.android.server.location.injector;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import com.android.server.FgThread;

/* JADX INFO: loaded from: classes2.dex */
public class SystemEmergencyHelper extends EmergencyHelper {
    private final Context mContext;
    long mEmergencyCallEndRealtimeMs;
    private final EmergencyCallTelephonyCallback mEmergencyCallTelephonyCallback;
    boolean mIsInEmergencyCall;
    TelephonyManager mTelephonyManager;

    private class EmergencyCallTelephonyCallback extends TelephonyCallback implements TelephonyCallback.CallStateListener {
        final /* synthetic */ SystemEmergencyHelper this$0;

        EmergencyCallTelephonyCallback(SystemEmergencyHelper r1) {
            this.this$0 = r1;
        }

        @Override // android.telephony.TelephonyCallback.CallStateListener
        public void onCallStateChanged(int state) {
            if (state != 0) goto L14;
            SystemEmergencyHelper r0 = this.this$0;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L6:
            if (this.this$0.mIsInEmergencyCall == false) goto L10;
            SystemEmergencyHelper r1 = this.this$0;     // Catch: Throwable -> L8
            r1.mEmergencyCallEndRealtimeMs = SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
            this.this$0.mIsInEmergencyCall = false;     // Catch: Throwable -> L8
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L8
            this.this$0.dispatchEmergencyStateChanged();
            return;
        }
    }

    public SystemEmergencyHelper(Context context) {
        this.mEmergencyCallTelephonyCallback = new EmergencyCallTelephonyCallback(this);
        this.mEmergencyCallEndRealtimeMs = Long.MIN_VALUE;
        this.mContext = context;
    }

    public synchronized void onSystemReady() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mTelephonyManager == null) goto L7;
        monitor-exit(this);
        return;
    L7:
        TelephonyManager r0 = (TelephonyManager) this.mContext.getSystemService(TelephonyManager.class);     // Catch: Throwable -> L10
        r0.getClass();     // Catch: Throwable -> L10
        this.mTelephonyManager = r0;     // Catch: Throwable -> L10
        this.mTelephonyManager.registerTelephonyCallback(FgThread.getExecutor(), this.mEmergencyCallTelephonyCallback);     // Catch: Throwable -> L10
        this.mContext.registerReceiver(new AnonymousClass1(this), new IntentFilter("android.intent.action.NEW_OUTGOING_CALL"));     // Catch: Throwable -> L10
        this.mContext.registerReceiver(new AnonymousClass2(this), new IntentFilter("android.intent.action.EMERGENCY_CALLBACK_MODE_CHANGED"));     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    @Override // com.android.server.location.injector.EmergencyHelper
    public boolean isInEmergency(long extensionTimeMs) {
        monitor-enter(this);
        boolean r1 = false;
        if (this.mTelephonyManager != null) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L7
        return false;
    L10:
        if (this.mEmergencyCallEndRealtimeMs != Long.MIN_VALUE) goto L12;
    L14:
        boolean isInExtensionTime = false;
    L15:
        boolean emergencyCallbackMode = false;
        boolean emergencySmsMode = false;
        PackageManager pm = this.mContext.getPackageManager();     // Catch: Throwable -> L7
        if (pm.hasSystemFeature("android.hardware.telephony.calling") == false) goto L19;
        emergencyCallbackMode = this.mTelephonyManager.getEmergencyCallbackMode();     // Catch: Throwable -> L7
    L19:
        if (pm.hasSystemFeature("android.hardware.telephony.messaging") == false) goto L22;
        emergencySmsMode = this.mTelephonyManager.isInEmergencySmsMode();     // Catch: Throwable -> L7
    L22:
        if (this.mIsInEmergencyCall == true) goto L26;
        if (isInExtensionTime == true) goto L26;
        if (emergencyCallbackMode == true) goto L26;
        if (emergencySmsMode == true) goto L26;
    L27:
        monitor-exit(this);     // Catch: Throwable -> L7
        return r1;
    L26:
        r1 = true;
        goto L27
    L12:
        if ((SystemClock.elapsedRealtime() - this.mEmergencyCallEndRealtimeMs) >= extensionTimeMs) goto L14;
        isInExtensionTime = true;
    L7:
        th = move-exception;
        throw th;
    }
}
