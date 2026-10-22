package com.android.server.pm;

import android.app.ActivityManager;
import android.app.ActivityThread;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.IPackageManager;
import android.content.pm.PackageInstaller;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.util.Slog;
import com.android.internal.util.IndentingPrintWriter;
import com.android.internal.util.Preconditions;
import com.android.server.storage.DiskStatsFileLogger;
import com.android.server.usage.UnixCalendar;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class GentleUpdateHelper {
    private static final int JOB_ID = 235306967;
    private static final long PENDING_CHECK_MILLIS = 0;
    private static final String TAG = "GentleUpdateHelper";
    private final AppStateHelper mAppStateHelper;
    private final Context mContext;
    private final Handler mHandler;
    private boolean mHasPendingIdleJob;
    private final ArrayDeque<PendingInstallConstraintsCheck> mPendingChecks;
    private final ArrayList<CompletableFuture<Boolean>> mPendingIdleFutures;

    private static class PendingInstallConstraintsCheck {
        public final PackageInstaller.InstallConstraints constraints;
        public final CompletableFuture<PackageInstaller.InstallConstraintsResult> future;
        private final long mFinishTime;
        public final List<String> packageNames;

        PendingInstallConstraintsCheck(List<String> packageNames, PackageInstaller.InstallConstraints constraints, CompletableFuture<PackageInstaller.InstallConstraintsResult> future, long timeoutMillis) {
            this.packageNames = packageNames;
            this.constraints = constraints;
            this.future = future;
            long timeoutMillis2 = Math.max(0, Math.min(UnixCalendar.WEEK_IN_MILLIS, timeoutMillis));
            this.mFinishTime = SystemClock.elapsedRealtime() + timeoutMillis2;
        }

        public boolean isTimedOut() {
            if (SystemClock.elapsedRealtime() < this.mFinishTime) goto L5;
            return true;
        L5:
            return false;
        }

        public long getRemainingTimeMillis() {
            long timeout = this.mFinishTime - SystemClock.elapsedRealtime();
            return Math.max(timeout, 0);
        }

        void dump(IndentingPrintWriter pw) {
            pw.printPair(DiskStatsFileLogger.PACKAGE_NAMES_KEY, this.packageNames);
            pw.println();
            pw.printPair("finishTime", Long.valueOf(this.mFinishTime));
            pw.println();
            pw.printPair("constraints notInCallRequired", Boolean.valueOf(this.constraints.isNotInCallRequired()));
            pw.println();
            pw.printPair("constraints deviceIdleRequired", Boolean.valueOf(this.constraints.isDeviceIdleRequired()));
            pw.println();
            pw.printPair("constraints appNotForegroundRequired", Boolean.valueOf(this.constraints.isAppNotForegroundRequired()));
            pw.println();
            pw.printPair("constraints appNotInteractingRequired", Boolean.valueOf(this.constraints.isAppNotInteractingRequired()));
            pw.println();
            pw.printPair("constraints appNotTopVisibleRequired", Boolean.valueOf(this.constraints.isAppNotTopVisibleRequired()));
        }
    }

    public static class Service extends JobService {
        public static /* synthetic */ void $r8$lambda$RvfCcJzAVZaVQw7GbyiD953K7XA(GentleUpdateHelper r0) {
            GentleUpdateHelper.m6650$$Nest$mrunIdleJob(r0);
        }

        public Service() {
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters params) {
            PackageInstallerService pis = ActivityThread.getPackageManager().getPackageInstaller();     // Catch: Exception -> L4
            final GentleUpdateHelper helper = pis.getGentleUpdateHelper();     // Catch: Exception -> L4
            Handler r2 = GentleUpdateHelper.m6649$$Nest$fgetmHandler(helper);     // Catch: Exception -> L4
            helper.getClass();     // Catch: Exception -> L4
            r2.post(new GentleUpdateHelper$Service$$ExternalSyntheticLambda0(helper));     // Catch: Exception -> L4
            return false;
        L4:
            e = move-exception;
            Slog.e(GentleUpdateHelper.TAG, "Failed to get PackageInstallerService", e);
            return false;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters params) {
            return false;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$9Vy9TsTEIaX26UUSrPw3MGLRU-s, reason: not valid java name */
    public static /* synthetic */ void m6647$r8$lambda$9Vy9TsTEIaX26UUSrPw3MGLRUs(GentleUpdateHelper r0, String r1, int r2) {
        r0.lambda$onUidImportance$4(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$JQiy908NuzFx59XC1nxYVaiXKqM(GentleUpdateHelper r0, int r1, int r2) {
        r0.onUidImportance(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$RvfCcJzAVZaVQw7GbyiD953K7XA(GentleUpdateHelper r0) {
        r0.runIdleJob();
    }

    public static /* synthetic */ void $r8$lambda$c3S7ZIxSTh3_d2qaNxWey4Smpfk(GentleUpdateHelper r0, PendingInstallConstraintsCheck r1, Boolean r2) {
        r0.lambda$checkInstallConstraints$1(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$j4wmpf-DZ6NznKBGUWFthYWvRvs, reason: not valid java name */
    public static /* synthetic */ void m6648$r8$lambda$j4wmpfDZ6NznKBGUWFthYWvRvs(GentleUpdateHelper r0, PendingInstallConstraintsCheck r1) {
        r0.lambda$checkInstallConstraints$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$pT0l_BxTLvguapszfDk8qc1pX3k(CompletableFuture r0) {
        lambda$checkDeviceIdle$3(r0);
    }

    public static /* synthetic */ void $r8$lambda$timDlQpczGIL2XwB9jNPajqEyc0(GentleUpdateHelper r0, List r1, PackageInstaller.InstallConstraints r2, CompletableFuture r3, long r4) {
        r0.lambda$checkInstallConstraints$2(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m6649$$Nest$fgetmHandler(GentleUpdateHelper r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$mrunIdleJob, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6650$$Nest$mrunIdleJob(GentleUpdateHelper r0) {
        r0.runIdleJob();
    }

    static {
        PENDING_CHECK_MILLIS = TimeUnit.SECONDS.toMillis(10);
    }

    GentleUpdateHelper(Context context, Looper looper, AppStateHelper appStateHelper) {
        this.mPendingChecks = new ArrayDeque();
        this.mPendingIdleFutures = new ArrayList();
        this.mContext = context;
        this.mHandler = new Handler(looper);
        this.mAppStateHelper = appStateHelper;
    }

    void systemReady() {
        ActivityManager am = (ActivityManager) this.mContext.getSystemService(ActivityManager.class);
        am.addOnUidImportanceListener(new GentleUpdateHelper$$ExternalSyntheticLambda5(this), 100);
        am.addOnUidImportanceListener(new GentleUpdateHelper$$ExternalSyntheticLambda5(this), 125);
    }

    CompletableFuture<PackageInstaller.InstallConstraintsResult> checkInstallConstraints(final List<String> packageNames, final PackageInstaller.InstallConstraints constraints, final long timeoutMillis) {
        final CompletableFuture<PackageInstaller.InstallConstraintsResult> resultFuture = new CompletableFuture();
        this.mHandler.post(new GentleUpdateHelper$$ExternalSyntheticLambda6(this, packageNames, constraints, resultFuture, timeoutMillis));
        return resultFuture;
    }

    private /* synthetic */ void lambda$checkInstallConstraints$2(List packageNames, PackageInstaller.InstallConstraints constraints, CompletableFuture resultFuture, long timeoutMillis) {
        final PendingInstallConstraintsCheck pendingCheck = new PendingInstallConstraintsCheck(packageNames, constraints, resultFuture, timeoutMillis);
        if (constraints.isDeviceIdleRequired() == false) goto L5;
        CompletableFuture<Boolean> deviceIdleFuture = checkDeviceIdle();
    L6:
        deviceIdleFuture.thenAccept(new GentleUpdateHelper$$ExternalSyntheticLambda2(this, pendingCheck));
        return;
    L5:
        deviceIdleFuture = CompletableFuture.completedFuture(false);
        goto L6
    }

    private /* synthetic */ void lambda$checkInstallConstraints$1(final PendingInstallConstraintsCheck pendingCheck, Boolean isIdle) {
        Preconditions.checkState(this.mHandler.getLooper().isCurrentThread());
        if (processPendingCheck(pendingCheck, isIdle.booleanValue()) == true) goto L6;
        this.mPendingChecks.add(pendingCheck);
        scheduleIdleJob();
        this.mHandler.postDelayed(new GentleUpdateHelper$$ExternalSyntheticLambda3(this, pendingCheck), pendingCheck.getRemainingTimeMillis());
        return;
    }

    private /* synthetic */ void lambda$checkInstallConstraints$0(PendingInstallConstraintsCheck pendingCheck) {
        processPendingCheck(pendingCheck, false);
    }

    private CompletableFuture<Boolean> checkDeviceIdle() {
        final CompletableFuture<Boolean> future = new CompletableFuture();
        this.mPendingIdleFutures.add(future);
        scheduleIdleJob();
        this.mHandler.postDelayed(new GentleUpdateHelper$$ExternalSyntheticLambda1(future), PENDING_CHECK_MILLIS);
        return future;
    }

    private static /* synthetic */ void lambda$checkDeviceIdle$3(CompletableFuture future) {
        future.complete(false);
    }

    private void scheduleIdleJob() {
        boolean isIdle = SystemProperties.getBoolean("debug.pm.gentle_update_test.is_idle", false);
        if (isIdle == false) goto L7;
        this.mHandler.post(new GentleUpdateHelper$$ExternalSyntheticLambda4(this));
        return;
    L7:
        if (this.mHasPendingIdleJob == false) goto L9;
        return;
    L9:
        this.mHasPendingIdleJob = true;
        ComponentName componentName = new ComponentName(this.mContext.getPackageName(), Service.class.getName());
        JobInfo jobInfo = new JobInfo.Builder(JOB_ID, componentName).setRequiresDeviceIdle(true).build();
        JobScheduler jobScheduler = (JobScheduler) this.mContext.getSystemService(JobScheduler.class);
        jobScheduler.schedule(jobInfo);
    }

    private void runIdleJob() {
        this.mHasPendingIdleJob = false;
        processPendingChecksInIdle();
        Iterator<CompletableFuture<Boolean>> r0 = this.mPendingIdleFutures.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        CompletableFuture<Boolean> f = r0.next();
        f.complete(true);
        goto L4
    L6:
        this.mPendingIdleFutures.clear();
    }

    private boolean areConstraintsSatisfied(List<String> packageNames, PackageInstaller.InstallConstraints constraints, boolean isIdle) {
        if (constraints.isDeviceIdleRequired() == false) goto L6;
        if (isIdle == true) goto L6;
    L22:
        return false;
    L6:
        if (constraints.isAppNotForegroundRequired() == false) goto L10;
        if (this.mAppStateHelper.hasForegroundApp(packageNames) == true) goto L22;
    L10:
        if (constraints.isAppNotInteractingRequired() == false) goto L14;
        if (this.mAppStateHelper.hasInteractingApp(packageNames) == true) goto L22;
    L14:
        if (constraints.isAppNotTopVisibleRequired() == false) goto L18;
        if (this.mAppStateHelper.hasTopVisibleApp(packageNames) == true) goto L22;
    L18:
        if (constraints.isNotInCallRequired() == true) goto L20;
    L23:
        return true;
    L20:
        if (this.mAppStateHelper.isInCall() == true) goto L22;
        goto L22
    }

    private boolean processPendingCheck(PendingInstallConstraintsCheck pendingCheck, boolean isIdle) {
        CompletableFuture<PackageInstaller.InstallConstraintsResult> future = pendingCheck.future;
        if (future.isDone() == false) goto L5;
        return true;
    L5:
        PackageInstaller.InstallConstraints constraints = pendingCheck.constraints;
        List<String> packageNames = this.mAppStateHelper.getDependencyPackages(pendingCheck.packageNames);
        boolean satisfied = areConstraintsSatisfied(packageNames, constraints, isIdle);
        if (satisfied == false) goto L8;
    L12:
        future.complete(new PackageInstaller.InstallConstraintsResult(satisfied));
        return true;
    L8:
        if (pendingCheck.isTimedOut() == true) goto L12;
        return false;
    }

    private void processPendingChecksInIdle() {
        int size = this.mPendingChecks.size();
        int i = 0;
    L3:
        if (i >= size) goto L9;
        PendingInstallConstraintsCheck pendingCheck = this.mPendingChecks.remove();
        if (processPendingCheck(pendingCheck, true) == true) goto L7;
        this.mPendingChecks.add(pendingCheck);
    L7:
        i = i + 1;
        goto L3
    L9:
        if (this.mPendingChecks.isEmpty() == true) goto L15;
        scheduleIdleJob();
        return;
    }

    private void onUidImportance(String packageName, int importance) {
        int size = this.mPendingChecks.size();
        int i = 0;
    L3:
        if (i >= size) goto L11;
        PendingInstallConstraintsCheck pendingCheck = this.mPendingChecks.remove();
        List<String> dependencyPackages = this.mAppStateHelper.getDependencyPackages(pendingCheck.packageNames);
        if (dependencyPackages.contains(packageName) == true) goto L7;
    L8:
        this.mPendingChecks.add(pendingCheck);
    L9:
        i = i + 1;
        goto L3
    L7:
        if (processPendingCheck(pendingCheck, false) == true) goto L9;
    L11:
        if (this.mPendingChecks.isEmpty() == true) goto L17;
        scheduleIdleJob();
        return;
    }

    private void onUidImportance(int uid, final int importance) {
        IPackageManager pm = ActivityThread.getPackageManager();
        final String packageName = pm.getNameForUid(uid);     // Catch: RemoteException -> L5
        this.mHandler.post(new GentleUpdateHelper$$ExternalSyntheticLambda0(this, packageName, importance));     // Catch: RemoteException -> L5
        return;
    }

    private /* synthetic */ void lambda$onUidImportance$4(String packageName, int importance) {
        onUidImportance(packageName, importance);
    }

    void dump(IndentingPrintWriter pw) {
        pw.println("Gentle update with constraints info:");
        pw.increaseIndent();
        pw.printPair("hasPendingIdleJob", Boolean.valueOf(this.mHasPendingIdleJob));
        pw.println();
        pw.printPair("Num of PendingIdleFutures", Integer.valueOf(this.mPendingIdleFutures.size()));
        pw.println();
        ArrayDeque<PendingInstallConstraintsCheck> pendingChecks = this.mPendingChecks.clone();
        int size = pendingChecks.size();
        pw.printPair("Num of PendingChecks", Integer.valueOf(size));
        pw.println();
        pw.increaseIndent();
        int i = 0;
    L3:
        if (i >= size) goto L6;
        pw.print(i);
        pw.print(":");
        PendingInstallConstraintsCheck pendingInstallConstraintsCheck = pendingChecks.remove();
        pendingInstallConstraintsCheck.dump(pw);
        pw.println();
        i = i + 1;
        goto L3
    }
}
