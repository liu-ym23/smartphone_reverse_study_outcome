package com.android.server.job.controllers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.UserHandle;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.server.job.JobSchedulerService;
import com.android.server.storage.DeviceStorageMonitorService;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public final class StorageController extends StateController {
    private static final boolean DEBUG = false;
    private static final String TAG = "JobScheduler.Storage";
    private final StorageTracker mStorageTracker;
    private final ArraySet<JobStatus> mTrackedTasks;

    public final class StorageTracker extends BroadcastReceiver {
        private int mLastStorageSeq;
        private boolean mStorageLow;
        final /* synthetic */ StorageController this$0;

        public StorageTracker(StorageController this$0) {
            this.this$0 = this$0;
            this.mLastStorageSeq = -1;
        }

        public void startTracking() {
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
            filter.addAction("android.intent.action.DEVICE_STORAGE_OK");
            this.this$0.mContext.registerReceiver(this, filter);
        }

        public boolean isStorageNotLow() {
            return !this.mStorageLow;
        }

        public int getSeq() {
            return this.mLastStorageSeq;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            onReceiveInternal(intent);
        }

        public void onReceiveInternal(Intent intent) {
            String action = intent.getAction();
            this.mLastStorageSeq = intent.getIntExtra(DeviceStorageMonitorService.EXTRA_SEQUENCE, this.mLastStorageSeq);
            if ("android.intent.action.DEVICE_STORAGE_LOW".equals(action) == false) goto L9;
            if (StorageController.m5090$$Nest$sfgetDEBUG() == false) goto L7;
            Slog.d(StorageController.TAG, "Available storage too low to do work. @ " + JobSchedulerService.sElapsedRealtimeClock.millis());
        L7:
            this.mStorageLow = true;
            StorageController.m5089$$Nest$mmaybeReportNewStorageState(this.this$0);
            return;
        L9:
            if ("android.intent.action.DEVICE_STORAGE_OK".equals(action) == true) goto L11;
            return;
        L11:
            if (StorageController.m5090$$Nest$sfgetDEBUG() == false) goto L13;
            Slog.d(StorageController.TAG, "Available storage high enough to do work. @ " + JobSchedulerService.sElapsedRealtimeClock.millis());
        L13:
            this.mStorageLow = false;
            StorageController.m5089$$Nest$mmaybeReportNewStorageState(this.this$0);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$mmaybeReportNewStorageState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5089$$Nest$mmaybeReportNewStorageState(StorageController r0) {
        r0.maybeReportNewStorageState();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5090$$Nest$sfgetDEBUG() {
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

    public StorageTracker getTracker() {
        return this.mStorageTracker;
    }

    public StorageController(JobSchedulerService service) {
        super(service);
        this.mTrackedTasks = new ArraySet();
        this.mStorageTracker = new StorageTracker(this);
    }

    @Override // com.android.server.job.controllers.StateController
    public void startTrackingLocked() {
        this.mStorageTracker.startTracking();
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStartTrackingJobLocked(JobStatus taskStatus, JobStatus lastJob) {
        if (taskStatus.hasStorageNotLowConstraint() == false) goto L6;
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        this.mTrackedTasks.add(taskStatus);
        taskStatus.setTrackingController(16);
        taskStatus.setStorageNotLowConstraintSatisfied(nowElapsed, this.mStorageTracker.isStorageNotLow());
        return;
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStopTrackingJobLocked(JobStatus taskStatus, JobStatus incomingJob) {
        if (taskStatus.clearTrackingController(16) == false) goto L6;
        this.mTrackedTasks.remove(taskStatus);
        return;
    }

    private void maybeReportNewStorageState() {
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        boolean storageNotLow = this.mStorageTracker.isStorageNotLow();
        boolean reportChange = false;
        Object r4 = this.mLock;
        monitor-enter(r4);
        int i = this.mTrackedTasks.size() - 1;     // Catch: Throwable -> L7
    L5:
        if (i < 0) goto L10;
        JobStatus ts = this.mTrackedTasks.valueAt(i);     // Catch: Throwable -> L7
        reportChange = reportChange | ts.setStorageNotLowConstraintSatisfied(nowElapsed, storageNotLow);     // Catch: Throwable -> L7
        i = i - 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r4);     // Catch: Throwable -> L7
        if (storageNotLow == false) goto L13;
        this.mStateChangedListener.onRunJobNow(null);
        return;
    L13:
        if (reportChange == false) goto L22;
        this.mStateChangedListener.onControllerStateChanged(this.mTrackedTasks);
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpControllerStateLocked(IndentingPrintWriter pw, Predicate<JobStatus> predicate) {
        pw.println("Not low: " + this.mStorageTracker.isStorageNotLow());
        pw.println("Sequence: " + this.mStorageTracker.getSeq());
        pw.println();
        int i = 0;
    L4:
        if (i >= this.mTrackedTasks.size()) goto L11;
        JobStatus js = this.mTrackedTasks.valueAt(i);
        if (predicate.test(js) == false) goto L9;
        pw.print("#");
        js.printUniqueId(pw);
        pw.print(" from ");
        UserHandle.formatUid(pw, js.getSourceUid());
        pw.println();
    L9:
        i = i + 1;
        goto L4
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpControllerStateLocked(ProtoOutputStream proto, long fieldId, Predicate<JobStatus> predicate) {
        long token = proto.start(fieldId);
        long mToken = proto.start(1146756268039L);
        proto.write(1133871366145L, this.mStorageTracker.isStorageNotLow());
        proto.write(1120986464258L, this.mStorageTracker.getSeq());
        int i = 0;
    L4:
        if (i >= this.mTrackedTasks.size()) goto L10;
        JobStatus js = this.mTrackedTasks.valueAt(i);
        if (predicate.test(js) == false) goto L9;
        long jsToken = proto.start(2246267895811L);
        js.writeToShortProto(proto, 1146756268033L);
        proto.write(1120986464258L, js.getSourceUid());
        proto.end(jsToken);
    L9:
        i = i + 1;
        goto L4
    L10:
        proto.end(mToken);
        proto.end(token);
    }
}
