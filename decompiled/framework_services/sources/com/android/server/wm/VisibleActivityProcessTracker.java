package com.android.server.wm;

import android.util.ArrayMap;
import com.android.internal.os.BackgroundThread;
import java.io.PrintWriter;
import java.util.concurrent.Executor;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
class VisibleActivityProcessTracker {
    final ActivityTaskManagerService mAtms;
    final Executor mBgExecutor;
    private final ArrayMap<WindowProcessController, CpuTimeRecord> mProcMap;

    private class CpuTimeRecord implements Runnable {
        private long mCpuTime;
        private boolean mHasStartCpuTime;
        private final WindowProcessController mProc;
        boolean mShouldGetCpuTime;
        final /* synthetic */ VisibleActivityProcessTracker this$0;

        CpuTimeRecord(VisibleActivityProcessTracker r1, WindowProcessController wpc) {
            this.this$0 = r1;
            this.mProc = wpc;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mProc.getPid() != 0) goto L6;
            return;
        L6:
            if (this.mHasStartCpuTime == true) goto L8;
            this.mHasStartCpuTime = true;
            this.mCpuTime = this.mProc.getCpuTime();
            return;
        L8:
            long diff = this.mProc.getCpuTime() - this.mCpuTime;
            if (diff <= 0) goto L13;
            this.this$0.mAtms.mAmInternal.updateForegroundTimeIfOnBattery(this.mProc.mInfo.packageName, this.mProc.mInfo.uid, diff);
            return;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$7qjit-TSljK6tIf9w76rmuGqq6c, reason: not valid java name */
    public static /* synthetic */ boolean m10370$r8$lambda$7qjitTSljK6tIf9w76rmuGqq6c(WindowProcessController r0) {
        return lambda$hasVisibleNotPinnedActivity$0(r0);
    }

    VisibleActivityProcessTracker(ActivityTaskManagerService atms) {
        this.mProcMap = new ArrayMap();
        this.mBgExecutor = BackgroundThread.getExecutor();
        this.mAtms = atms;
    }

    void onAnyActivityVisible(WindowProcessController wpc) {
        CpuTimeRecord r = new CpuTimeRecord(this, wpc);
        ArrayMap<WindowProcessController, CpuTimeRecord> r1 = this.mProcMap;
        monitor-enter(r1);
        this.mProcMap.put(wpc, r);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        if (wpc.hasResumedActivity() == false) goto L15;
        r.mShouldGetCpuTime = true;
        this.mBgExecutor.execute(r);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void onAllActivitiesInvisible(WindowProcessController wpc) {
        CpuTimeRecord r = removeProcess(wpc);
        if (r != null) goto L5;
        return;
    L5:
        if (r.mShouldGetCpuTime == false) goto L9;
        this.mBgExecutor.execute(r);
        return;
    }

    void onActivityResumedWhileVisible(WindowProcessController wpc) {
        ArrayMap<WindowProcessController, CpuTimeRecord> r0 = this.mProcMap;
        monitor-enter(r0);
        CpuTimeRecord r = this.mProcMap.get(wpc);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        if (r != null) goto L8;
        return;
    L8:
        if (r.mShouldGetCpuTime == true) goto L17;
        r.mShouldGetCpuTime = true;
        this.mBgExecutor.execute(r);
        return;
    L17:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    boolean hasResumedActivity(int uid) {
        return match(uid, new VisibleActivityProcessTracker$$ExternalSyntheticLambda0());
    }

    boolean hasVisibleActivity(int uid) {
        return match(uid, WindowContainer.alwaysTruePredicate());
    }

    private static /* synthetic */ boolean lambda$hasVisibleNotPinnedActivity$0(WindowProcessController wpc) {
        return wpc.hasVisibleNotPinnedActivity();
    }

    boolean hasVisibleNotPinnedActivity(int uid) {
        return match(uid, new VisibleActivityProcessTracker$$ExternalSyntheticLambda1());
    }

    private boolean match(int uid, Predicate<WindowProcessController> predicate) {
        ArrayMap<WindowProcessController, CpuTimeRecord> r0 = this.mProcMap;
        monitor-enter(r0);
        int i = this.mProcMap.size() - 1;     // Catch: Throwable -> L12
    L5:
        if (i < 0) goto L16;
        WindowProcessController wpc = this.mProcMap.keyAt(i);     // Catch: Throwable -> L12
        if (wpc.mUid != uid) goto L14;
        if (predicate.test(wpc) == false) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L14:
        i = i - 1;     // Catch: Throwable -> L12
        goto L5
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    CpuTimeRecord removeProcess(WindowProcessController wpc) {
        ArrayMap<WindowProcessController, CpuTimeRecord> r0 = this.mProcMap;
        monitor-enter(r0);
        CpuTimeRecord r1 = this.mProcMap.remove(wpc);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    void dump(PrintWriter pw, String prefix) {
        pw.print(prefix + "VisibleActivityProcess:[");
        ArrayMap<WindowProcessController, CpuTimeRecord> r0 = this.mProcMap;
        monitor-enter(r0);
        int i = this.mProcMap.size() - 1;     // Catch: Throwable -> L7
    L5:
        if (i < 0) goto L10;
        pw.print(" " + this.mProcMap.keyAt(i));     // Catch: Throwable -> L7
        i = i + (-1);     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        pw.println("]");
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
