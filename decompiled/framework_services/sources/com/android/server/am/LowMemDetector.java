package com.android.server.am;

import android.os.Trace;
import com.android.server.SysOptBridge;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class LowMemDetector {
    public static final int ADJ_MEM_FACTOR_NOTHING = -1;
    public static final int MEM_PRESSURE_HIGH = 3;
    public static final int MEM_PRESSURE_LOW = 1;
    public static final int MEM_PRESSURE_MEDIUM = 2;
    public static final int MEM_PRESSURE_NONE = 0;
    private static final String TAG = "LowMemDetector";
    private final ActivityManagerService mAm;
    private boolean mAvailable;
    private final LowMemThread mLowMemThread;
    private int mPressureState;
    private final Object mPressureStateLock;

    private final class LowMemThread extends Thread {
        private boolean mIsTracingMemCriticalLow;
        final /* synthetic */ LowMemDetector this$0;

        LowMemThread(LowMemDetector r1) {
            this.this$0 = r1;
            super("LowMemThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
        L2:
            int newPressureState = LowMemDetector.m1519$$Nest$mwaitForPressure(this.this$0);
            if (newPressureState != 3) goto L5;
            boolean isCriticalLowMemory = true;
        L7:
            if (isCriticalLowMemory == true) goto L9;
        L11:
            if (isCriticalLowMemory == false) goto L13;
        L15:
            this.mIsTracingMemCriticalLow = isCriticalLowMemory;
            if (newPressureState == (-1)) goto L17;
            Object r2 = LowMemDetector.m1516$$Nest$fgetmPressureStateLock(this.this$0);
            monitor-enter(r2);
            LowMemDetector.m1518$$Nest$fputmPressureState(this.this$0, newPressureState);     // Catch: Throwable -> L24
            monitor-exit(r2);     // Catch: Throwable -> L24
            Trace.traceBegin(64, "pieperf_lmdt_lowmemdispatch");
            SysOptBridge.getFactory().getLowMemDetectorOptEx().dispatch(newPressureState);
            Trace.traceEnd(64);
            SysOptBridge.getFactory().getProcessGuard().onMemoryPsiEvent(newPressureState);
        L24:
            th = move-exception;
            throw th;
        L17:
            LowMemDetector.m1517$$Nest$fputmAvailable(this.this$0, false);
            return;
        L13:
            if (this.mIsTracingMemCriticalLow == false) goto L15;
            Trace.traceEnd(64);
            goto L15
        L9:
            if (this.mIsTracingMemCriticalLow == true) goto L11;
            Trace.traceBegin(64, "criticalLowMemory");
            goto L15
        L5:
            isCriticalLowMemory = false;
            goto L7
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MemFactor {
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPressureStateLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m1516$$Nest$fgetmPressureStateLock(LowMemDetector r0) {
        return r0.mPressureStateLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAvailable, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1517$$Nest$fputmAvailable(LowMemDetector r0, boolean r1) {
        r0.mAvailable = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPressureState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1518$$Nest$fputmPressureState(LowMemDetector r0, int r1) {
        r0.mPressureState = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mwaitForPressure, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m1519$$Nest$mwaitForPressure(LowMemDetector r0) {
        return r0.waitForPressure();
    }

    private native int init();

    private native int waitForPressure();

    LowMemDetector(ActivityManagerService am) {
        this.mPressureStateLock = new Object();
        this.mPressureState = 0;
        this.mAm = am;
        this.mLowMemThread = new LowMemThread(this);
        if (init() == 0) goto L5;
        this.mAvailable = false;
        return;
    L5:
        this.mAvailable = true;
        this.mLowMemThread.start();
    }

    public boolean isAvailable() {
        return this.mAvailable;
    }

    public int getMemFactor() {
        Object r0 = this.mPressureStateLock;
        monitor-enter(r0);
        int r1 = this.mPressureState;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
