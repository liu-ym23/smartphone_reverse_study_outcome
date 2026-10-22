package com.android.server.job.controllers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.UserHandle;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArrayMap;
import android.util.proto.ProtoOutputStream;
import com.android.server.job.JobSchedulerService;
import com.android.server.pm.Settings;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public class ComponentController extends StateController {
    private static final boolean DEBUG = false;
    private static final String TAG = "JobScheduler.Component";
    private final BroadcastReceiver mBroadcastReceiver;
    private final ComponentStateUpdateFunctor mComponentStateUpdateFunctor;
    private final SparseArrayMap<ComponentName, String> mServiceProcessCache;

    final class ComponentStateUpdateFunctor implements Consumer<JobStatus> {
        final ArraySet<JobStatus> mChangedJobs;
        final /* synthetic */ ComponentController this$0;

        /* JADX INFO: renamed from: -$$Nest$mreset, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4907$$Nest$mreset(ComponentStateUpdateFunctor r0) {
            r0.reset();
        }

        ComponentStateUpdateFunctor(ComponentController this$0) {
            this.this$0 = this$0;
            this.mChangedJobs = new ArraySet();
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(JobStatus r1) {
            accept2(r1);
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(JobStatus jobStatus) {
            if (ComponentController.m4904$$Nest$mupdateComponentEnabledStateLocked(this.this$0, jobStatus) == false) goto L6;
            this.mChangedJobs.add(jobStatus);
            return;
        }

        private void reset() {
            this.mChangedJobs.clear();
        }
    }

    public static /* synthetic */ boolean $r8$lambda$Ihgw2uYNtfHOLpc6wqk1mqIQyVY(int r0, String r1, JobStatus r2) {
        return lambda$updateComponentStateForPackage$0(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$M1UwXxQ2lQGkgK0HrVMJlW9dX54(int r0, JobStatus r1) {
        return lambda$updateComponentStateForUser$1(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateComponentEnabledStateLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4904$$Nest$mupdateComponentEnabledStateLocked(ComponentController r0, JobStatus r1) {
        return r0.updateComponentEnabledStateLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateComponentStateForPackage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4905$$Nest$mupdateComponentStateForPackage(ComponentController r0, int r1, String r2) {
        r0.updateComponentStateForPackage(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateComponentStateForUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4906$$Nest$mupdateComponentStateForUser(ComponentController r0, int r1) {
        r0.updateComponentStateForUser(r1);
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

    public ComponentController(JobSchedulerService service) {
        super(service);
        this.mBroadcastReceiver = new AnonymousClass1(this);
        this.mServiceProcessCache = new SparseArrayMap();
        this.mComponentStateUpdateFunctor = new ComponentStateUpdateFunctor(this);
    }

    @Override // com.android.server.job.controllers.StateController
    public void startTrackingLocked() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PACKAGE_ADDED");
        filter.addAction("android.intent.action.PACKAGE_CHANGED");
        filter.addDataScheme(Settings.ATTR_PACKAGE);
        this.mContext.registerReceiverAsUser(this.mBroadcastReceiver, UserHandle.ALL, filter, null, null);
        IntentFilter userFilter = new IntentFilter();
        userFilter.addAction("android.intent.action.USER_UNLOCKED");
        userFilter.addAction("android.intent.action.USER_STOPPED");
        this.mContext.registerReceiverAsUser(this.mBroadcastReceiver, UserHandle.ALL, userFilter, null, null);
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStartTrackingJobLocked(JobStatus jobStatus, JobStatus lastJob) {
        updateComponentEnabledStateLocked(jobStatus);
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStopTrackingJobLocked(JobStatus jobStatus, JobStatus incomingJob) {
    }

    @Override // com.android.server.job.controllers.StateController
    public void onAppRemovedLocked(String packageName, int uid) {
        clearComponentsForPackageLocked(UserHandle.getUserId(uid), packageName);
    }

    @Override // com.android.server.job.controllers.StateController
    public void onUserRemovedLocked(int userId) {
        this.mServiceProcessCache.delete(userId);
    }

    private String getServiceProcessLocked(JobStatus jobStatus) {
        ComponentName service = jobStatus.getServiceComponent();
        int userId = jobStatus.getUserId();
        if (this.mServiceProcessCache.contains(userId, service) == true) goto L5;
        ServiceInfo si = this.mContext.createContextAsUser(UserHandle.of(userId), 0).getPackageManager().getServiceInfo(service, 268435456);     // Catch: PackageManager.NameNotFoundException -> L8
    L13:
        if (si != null) goto L15;
        String processName = null;
    L16:
        this.mServiceProcessCache.add(userId, service, processName);
        return processName;
    L15:
        processName = si.processName;
    L10:
        if (this.mService.areUsersStartedLocked(jobStatus) == false) goto L12;
        Slog.e(TAG, "Job exists for non-existent package: " + service.getPackageName());
    L12:
        si = null;
        goto L13
    L5:
        return (String) this.mServiceProcessCache.get(userId, service);
    }

    private boolean updateComponentEnabledStateLocked(JobStatus jobStatus) {
        String processName = getServiceProcessLocked(jobStatus);
        if (DEBUG == false) goto L6;
        if (processName != null) goto L6;
        Slog.v(TAG, jobStatus.toShortString() + " component not present");
    L6:
        String ogProcess = jobStatus.serviceProcessName;
        jobStatus.serviceProcessName = processName;
        return !Objects.equals(ogProcess, processName);
    }

    private void clearComponentsForPackageLocked(int userId, String pkg) {
        int uIdx = this.mServiceProcessCache.indexOfKey(userId);
        int c = this.mServiceProcessCache.numElementsForKey(userId) - 1;
    L3:
        if (c < 0) goto L9;
        ComponentName cn = (ComponentName) this.mServiceProcessCache.keyAt(uIdx, c);
        if (cn.getPackageName().equals(pkg) == false) goto L7;
        this.mServiceProcessCache.delete(userId, cn);
    L7:
        c = c - 1;
        goto L3
    }

    private void updateComponentStateForPackage(final int userId, final String pkg) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        clearComponentsForPackageLocked(userId, pkg);     // Catch: Throwable -> L7
        updateComponentStatesLocked(new ComponentController$$ExternalSyntheticLambda0(userId, pkg));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$updateComponentStateForPackage$0(int userId, String pkg, JobStatus jobStatus) {
        if (jobStatus.getUserId() == userId) goto L5;
    L7:
        return false;
    L5:
        if (jobStatus.getServiceComponent().getPackageName().equals(pkg) == false) goto L7;
        return true;
    }

    private void updateComponentStateForUser(final int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mServiceProcessCache.delete(userId);     // Catch: Throwable -> L7
        updateComponentStatesLocked(new ComponentController$$ExternalSyntheticLambda1(userId));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$updateComponentStateForUser$1(int userId, JobStatus jobStatus) {
        if (jobStatus.getUserId() != userId) goto L5;
        return true;
    L5:
        return false;
    }

    private void updateComponentStatesLocked(Predicate<JobStatus> filter) {
        ComponentStateUpdateFunctor.m4907$$Nest$mreset(this.mComponentStateUpdateFunctor);
        this.mService.getJobStore().forEachJob(filter, this.mComponentStateUpdateFunctor);
        if (this.mComponentStateUpdateFunctor.mChangedJobs.size() <= 0) goto L6;
        this.mStateChangedListener.onControllerStateChanged(this.mComponentStateUpdateFunctor.mChangedJobs);
        return;
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpControllerStateLocked(IndentingPrintWriter pw, Predicate<JobStatus> predicate) {
        int u = 0;
    L4:
        if (u >= this.mServiceProcessCache.numMaps()) goto L11;
        int userId = this.mServiceProcessCache.keyAt(u);
        int p = 0;
    L7:
        if (p >= this.mServiceProcessCache.numElementsForKey(userId)) goto L9;
        ComponentName componentName = (ComponentName) this.mServiceProcessCache.keyAt(u, p);
        pw.print(userId);
        pw.print("-");
        pw.print(componentName);
        pw.print(": ");
        pw.print((String) this.mServiceProcessCache.valueAt(u, p));
        pw.println();
        p = p + 1;
        goto L7
    L9:
        u = u + 1;
        goto L4
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpControllerStateLocked(ProtoOutputStream proto, long fieldId, Predicate<JobStatus> predicate) {
    }
}
