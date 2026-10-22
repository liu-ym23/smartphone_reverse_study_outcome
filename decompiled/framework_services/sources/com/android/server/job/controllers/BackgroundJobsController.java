package com.android.server.job.controllers;

import android.app.ActivityManagerInternal;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArrayMap;
import android.util.proto.ProtoOutputStream;
import com.android.server.AppStateTracker;
import com.android.server.AppStateTrackerImpl;
import com.android.server.LocalServices;
import com.android.server.job.JobSchedulerService;
import com.android.server.job.JobStore;
import com.android.server.pm.Settings;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public final class BackgroundJobsController extends StateController {
    private static final boolean DEBUG = false;
    static final int KNOWN_ACTIVE = 1;
    static final int KNOWN_INACTIVE = 2;
    private static final String TAG = "JobScheduler.Background";
    static final int UNKNOWN = 0;
    private final ActivityManagerInternal mActivityManagerInternal;
    private final AppStateTrackerImpl mAppStateTracker;
    private final BroadcastReceiver mBroadcastReceiver;
    private final AppStateTrackerImpl.Listener mForceAppStandbyListener;
    private final PackageManagerInternal mPackageManagerInternal;
    private final SparseArrayMap<String, Boolean> mPackageStoppedState;
    private final UpdateJobFunctor mUpdateJobFunctor;

    private final class UpdateJobFunctor implements Consumer<JobStatus> {
        int mActiveState;
        final ArraySet<JobStatus> mChangedJobs;
        int mCheckedCount;
        int mTotalCount;
        long mUpdateTimeElapsed;
        final /* synthetic */ BackgroundJobsController this$0;

        /* synthetic */ UpdateJobFunctor(BackgroundJobsController r1, BackgroundJobsControllerIA r2) {
            this(r1);
        }

        private UpdateJobFunctor(BackgroundJobsController r3) {
            this.this$0 = r3;
            this.mChangedJobs = new ArraySet();
            this.mTotalCount = 0;
            this.mCheckedCount = 0;
            this.mUpdateTimeElapsed = 0;
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(JobStatus r1) {
            accept2(r1);
        }

        void prepare(int newActiveState) {
            this.mActiveState = newActiveState;
            this.mUpdateTimeElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
            this.mChangedJobs.clear();
            this.mTotalCount = 0;
            this.mCheckedCount = 0;
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(JobStatus jobStatus) {
            this.mTotalCount++;
            this.mCheckedCount++;
            if (this.this$0.updateSingleJobRestrictionLocked(jobStatus, this.mUpdateTimeElapsed, this.mActiveState) == false) goto L6;
            this.mChangedJobs.add(jobStatus);
            return;
        }
    }

    public static /* synthetic */ void $r8$lambda$RWtzo_6p8GUe3TNtxmH0UJG13vc(BackgroundJobsController r0, IndentingPrintWriter r1, JobStatus r2) {
        r0.lambda$dumpControllerStateLocked$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$Z6pz3eqxw7lk4VJOX7BpNtK64F8(IndentingPrintWriter r0, int r1, String r2, Boolean r3) {
        lambda$dumpControllerStateLocked$0(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$fTLCaXNJppl0gWUjiU1nDjaOmfA(BackgroundJobsController r0, ProtoOutputStream r1, JobStatus r2) {
        r0.lambda$dumpControllerStateLocked$2(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageStoppedState, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArrayMap m4899$$Nest$fgetmPackageStoppedState(BackgroundJobsController r0) {
        return r0.mPackageStoppedState;
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateAllJobRestrictionsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4900$$Nest$mupdateAllJobRestrictionsLocked(BackgroundJobsController r0) {
        r0.updateAllJobRestrictionsLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateJobRestrictionsForUidLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4901$$Nest$mupdateJobRestrictionsForUidLocked(BackgroundJobsController r0, int r1, boolean r2) {
        r0.updateJobRestrictionsForUidLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateJobRestrictionsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4902$$Nest$mupdateJobRestrictionsLocked(BackgroundJobsController r0, int r1, int r2) {
        r0.updateJobRestrictionsLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4903$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    static {
        if (JobSchedulerService.DEBUG == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        DEBUG = r0;
        return;
    L5:
        if (Log.isLoggable(TAG, 3) == true) goto L8;
        r0 = false;
        goto L9
    }

    public BackgroundJobsController(JobSchedulerService service) {
        super(service);
        this.mPackageStoppedState = new SparseArrayMap();
        this.mUpdateJobFunctor = new UpdateJobFunctor(this, null);
        this.mBroadcastReceiver = new AnonymousClass1(this);
        this.mForceAppStandbyListener = new AnonymousClass2(this);
        ActivityManagerInternal r0 = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        r0.getClass();
        this.mActivityManagerInternal = r0;
        AppStateTracker r1 = (AppStateTracker) LocalServices.getService(AppStateTracker.class);
        r1.getClass();
        this.mAppStateTracker = (AppStateTrackerImpl) r1;
        this.mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
    }

    @Override // com.android.server.job.controllers.StateController
    public void startTrackingLocked() {
        this.mAppStateTracker.addListener(this.mForceAppStandbyListener);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PACKAGE_RESTARTED");
        filter.addAction("android.intent.action.PACKAGE_UNSTOPPED");
        filter.addDataScheme(Settings.ATTR_PACKAGE);
        this.mContext.registerReceiverAsUser(this.mBroadcastReceiver, UserHandle.ALL, filter, null, null);
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStartTrackingJobLocked(JobStatus jobStatus, JobStatus lastJob) {
        updateSingleJobRestrictionLocked(jobStatus, JobSchedulerService.sElapsedRealtimeClock.millis(), 0);
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStopTrackingJobLocked(JobStatus jobStatus, JobStatus incomingJob) {
    }

    @Override // com.android.server.job.controllers.StateController
    public void evaluateStateLocked(JobStatus jobStatus) {
        if (jobStatus.isRequestedExpeditedJob() == false) goto L6;
        updateSingleJobRestrictionLocked(jobStatus, JobSchedulerService.sElapsedRealtimeClock.millis(), 0);
        return;
    }

    @Override // com.android.server.job.controllers.StateController
    public void onAppRemovedLocked(String packageName, int uid) {
        this.mPackageStoppedState.delete(uid, packageName);
    }

    @Override // com.android.server.job.controllers.StateController
    public void onUserRemovedLocked(int userId) {
        int u = this.mPackageStoppedState.numMaps() - 1;
    L3:
        if (u < 0) goto L9;
        int uid = this.mPackageStoppedState.keyAt(u);
        if (UserHandle.getUserId(uid) != userId) goto L7;
        this.mPackageStoppedState.deleteAt(u);
    L7:
        u = u - 1;
        goto L3
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpControllerStateLocked(final IndentingPrintWriter pw, Predicate<JobStatus> predicate) {
        pw.println("Aconfig flags:");
        pw.increaseIndent();
        pw.print("android.content.pm.stay_stopped", true);
        pw.println();
        pw.decreaseIndent();
        pw.println();
        this.mAppStateTracker.dump(pw);
        pw.println();
        pw.println("Stopped packages:");
        pw.increaseIndent();
        this.mPackageStoppedState.forEach(new BackgroundJobsController$$ExternalSyntheticLambda0(pw));
        pw.println();
        this.mService.getJobStore().forEachJob(predicate, new BackgroundJobsController$$ExternalSyntheticLambda1(this, pw));
    }

    private static /* synthetic */ void lambda$dumpControllerStateLocked$0(IndentingPrintWriter pw, int uid, String pkgName, Boolean isStopped) {
        pw.print(uid);
        pw.print(":");
        pw.print(pkgName);
        pw.print("=");
        pw.println(isStopped);
    }

    private /* synthetic */ void lambda$dumpControllerStateLocked$1(IndentingPrintWriter pw, JobStatus jobStatus) {
        int uid = jobStatus.getSourceUid();
        String sourcePkg = jobStatus.getSourcePackageName();
        pw.print("#");
        jobStatus.printUniqueId(pw);
        pw.print(" from ");
        UserHandle.formatUid(pw, uid);
        if (this.mAppStateTracker.isUidActive(uid) == false) goto L5;
        String r2 = " active";
    L6:
        pw.print(r2);
        if (this.mAppStateTracker.isUidPowerSaveExempt(uid) == false) goto L9;
    L10:
        pw.print(", exempted");
    L11:
        pw.print(": ");
        pw.print(sourcePkg);
        pw.print(" [RUN_ANY_IN_BACKGROUND ");
        if (this.mAppStateTracker.isRunAnyInBackgroundAppOpsAllowed(uid, sourcePkg) == false) goto L14;
        String r3 = "allowed]";
    L15:
        pw.print(r3);
        if ((jobStatus.satisfiedConstraints & 4194304) == 0) goto L18;
        pw.println(" RUNNABLE");
        return;
    L18:
        pw.println(" WAITING");
        return;
    L14:
        r3 = "disallowed]";
        goto L15
    L9:
        if (this.mAppStateTracker.isUidTempPowerSaveExempt(uid) == false) goto L11;
    L5:
        r2 = " idle";
        goto L6
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpControllerStateLocked(final ProtoOutputStream proto, long fieldId, Predicate<JobStatus> predicate) {
        long token = proto.start(fieldId);
        long mToken = proto.start(1146756268033L);
        this.mAppStateTracker.dumpProto(proto, 1146756268033L);
        this.mService.getJobStore().forEachJob(predicate, new BackgroundJobsController$$ExternalSyntheticLambda2(this, proto));
        proto.end(mToken);
        proto.end(token);
    }

    private /* synthetic */ void lambda$dumpControllerStateLocked$2(ProtoOutputStream proto, JobStatus jobStatus) {
        long jsToken = proto.start(2246267895810L);
        jobStatus.writeToShortProto(proto, 1146756268033L);
        int sourceUid = jobStatus.getSourceUid();
        proto.write(1120986464258L, sourceUid);
        String sourcePkg = jobStatus.getSourcePackageName();
        proto.write(1138166333443L, sourcePkg);
        proto.write(1133871366148L, this.mAppStateTracker.isUidActive(sourceUid));
        boolean r5 = true;
        if (this.mAppStateTracker.isUidPowerSaveExempt(sourceUid) == false) goto L5;
    L8:
        boolean r4 = true;
    L9:
        proto.write(1133871366149L, r4);
        proto.write(1133871366150L, this.mAppStateTracker.isRunAnyInBackgroundAppOpsAllowed(sourceUid, sourcePkg));
        if ((jobStatus.satisfiedConstraints & 4194304) != 0) goto L13;
        r5 = false;
    L13:
        proto.write(1133871366151L, r5);
        proto.end(jsToken);
        return;
    L5:
        if (this.mAppStateTracker.isUidTempPowerSaveExempt(sourceUid) == true) goto L8;
        r4 = false;
        goto L9
    }

    private void updateAllJobRestrictionsLocked() {
        updateJobRestrictionsLocked(-1, 0);
    }

    private void updateJobRestrictionsForUidLocked(int uid, boolean isActive) {
        if (isActive == false) goto L4;
        int r0 = 1;
    L5:
        updateJobRestrictionsLocked(uid, r0);
        return;
    L4:
        r0 = 2;
        goto L5
    }

    private void updateJobRestrictionsLocked(int filterUid, int newActiveState) {
        this.mUpdateJobFunctor.prepare(newActiveState);
        long time = 0;
        if (DEBUG == false) goto L5;
        long start = SystemClock.elapsedRealtimeNanos();
    L6:
        JobStore store = this.mService.getJobStore();
        if (filterUid <= 0) goto L9;
        store.forEachJobForSourceUid(filterUid, this.mUpdateJobFunctor);
    L11:
        if (DEBUG == false) goto L14;
        time = SystemClock.elapsedRealtimeNanos() - start;
    L14:
        if (DEBUG == false) goto L17;
        Slog.d(TAG, String.format("Job status updated: %d/%d checked/total jobs, %d us", new Object[]{Integer.valueOf(this.mUpdateJobFunctor.mCheckedCount), Integer.valueOf(this.mUpdateJobFunctor.mTotalCount), Long.valueOf(time / 1000)}));
    L17:
        if (this.mUpdateJobFunctor.mChangedJobs.size() <= 0) goto L20;
        this.mStateChangedListener.onControllerStateChanged(this.mUpdateJobFunctor.mChangedJobs);
        return;
    L20:
        return;
    L9:
        store.forEachJob(this.mUpdateJobFunctor);
        goto L11
    L5:
        start = 0;
        goto L6
    }

    private boolean isPackageStoppedLocked(String packageName, int uid) {
        if (this.mPackageStoppedState.contains(uid, packageName) == true) goto L5;
        boolean isStopped = this.mPackageManagerInternal.isPackageStopped(packageName, uid);     // Catch: PackageManager.NameNotFoundException -> L9
        if (DEBUG == false) goto L11;
        Slog.d(TAG, "Pulled stopped state of " + packageName + " (" + uid + "): " + isStopped);     // Catch: PackageManager.NameNotFoundException -> L9
    L11:
        this.mPackageStoppedState.add(uid, packageName, Boolean.valueOf(isStopped));     // Catch: PackageManager.NameNotFoundException -> L9
        return isStopped;
    L13:
        Slog.e(TAG, "Couldn't determine stopped state for unknown package: " + packageName);
        return false;
    L5:
        return ((Boolean) this.mPackageStoppedState.get(uid, packageName)).booleanValue();
    }

    boolean updateSingleJobRestrictionLocked(JobStatus jobStatus, long nowElapsed, int activeState) {
        int uid = jobStatus.getSourceUid();
        String packageName = jobStatus.getSourcePackageName();
        boolean isSourcePkgStopped = isPackageStoppedLocked(jobStatus.getSourcePackageName(), jobStatus.getSourceUid());
        if (jobStatus.isProxyJob() == true) goto L5;
        boolean isCallingPkgStopped = isSourcePkgStopped;
    L6:
        boolean isActive = false;
        if (isCallingPkgStopped == true) goto L11;
        if (isSourcePkgStopped == true) goto L11;
        boolean isStopped = false;
    L13:
        if (isStopped == false) goto L15;
    L20:
        boolean isUserBgRestricted = true;
    L22:
        if (jobStatus.startedWithForegroundFlag == false) goto L27;
        if (isUserBgRestricted == false) goto L27;
        if (this.mService.getUidProcState(uid) <= 5) goto L27;
        boolean shouldStopImmediately = true;
    L29:
        if (isStopped == true) goto L34;
        if (shouldStopImmediately == true) goto L34;
        if (this.mAppStateTracker.areJobsRestricted(uid, packageName, jobStatus.canRunInBatterySaver()) == true) goto L34;
        boolean canRun = true;
    L36:
        if (activeState != 0) goto L38;
        isActive = this.mAppStateTracker.isUidActive(uid);
    L40:
        if (isActive == true) goto L42;
    L44:
        boolean didChange = jobStatus.setBackgroundNotRestrictedConstraintSatisfied(nowElapsed, canRun, isUserBgRestricted);
        return didChange | jobStatus.setUidActive(isActive);
    L42:
        if (jobStatus.getStandbyBucket() != 4) goto L44;
        jobStatus.maybeLogBucketMismatch();
        goto L44
    L38:
        if (activeState != 1) goto L40;
        isActive = true;
    L34:
        canRun = false;
    L27:
        shouldStopImmediately = false;
        goto L29
    L15:
        if (this.mActivityManagerInternal.isBgAutoRestrictedBucketFeatureFlagEnabled() == false) goto L17;
    L19:
        isUserBgRestricted = false;
        goto L22
    L17:
        if (this.mAppStateTracker.isRunAnyInBackgroundAppOpsAllowed(uid, packageName) == true) goto L19;
    L11:
        isStopped = true;
        goto L13
    L5:
        isCallingPkgStopped = isPackageStoppedLocked(jobStatus.getCallingPackageName(), jobStatus.getUid());
        goto L6
    }
}
