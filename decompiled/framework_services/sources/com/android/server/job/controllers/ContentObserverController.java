package com.android.server.job.controllers;

import android.app.job.JobInfo;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import com.android.server.AppSchedulingModuleThread;
import com.android.server.job.JobSchedulerService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public final class ContentObserverController extends StateController {
    private static final boolean DEBUG = false;
    private static final int MAX_URIS_REPORTED = 50;
    private static final String TAG = "JobScheduler.ContentObserver";
    private static final int URIS_URGENT_THRESHOLD = 40;
    final Handler mHandler;
    final SparseArray<ArrayMap<JobInfo.TriggerContentUri, ObserverInstance>> mObservers;
    private final ArraySet<JobStatus> mTrackedTasks;

    final class JobInstance {
        ArraySet<String> mChangedAuthorities;
        ArraySet<Uri> mChangedUris;
        final Runnable mExecuteRunner;
        final JobStatus mJobStatus;
        final ArrayList<ObserverInstance> mMyObservers;
        final Runnable mTimeoutRunner;
        boolean mTriggerPending;
        final /* synthetic */ ContentObserverController this$0;

        JobInstance(ContentObserverController this$0, JobStatus jobStatus) {
            this.this$0 = this$0;
            this.mMyObservers = new ArrayList();
            this.mJobStatus = jobStatus;
            this.mExecuteRunner = new TriggerRunnable(this);
            this.mTimeoutRunner = new TriggerRunnable(this);
            JobInfo.TriggerContentUri[] uris = jobStatus.getJob().getTriggerContentUris();
            int sourceUserId = jobStatus.getSourceUserId();
            ArrayMap<JobInfo.TriggerContentUri, ObserverInstance> observersOfUser = this$0.mObservers.get(sourceUserId);
            if (observersOfUser != null) goto L5;
            observersOfUser = new ArrayMap();
            this$0.mObservers.put(sourceUserId, observersOfUser);
        L5:
            if (uris == null) goto L27;
            int r6 = uris.length;
            int r8 = 0;
        L8:
            if (r8 >= r6) goto L32;
            JobInfo.TriggerContentUri uri = uris[r8];
            ObserverInstance obs = observersOfUser.get(uri);
            if (obs != null) goto L20;
            obs = new ObserverInstance(this$0, this$0.mHandler, uri, jobStatus.getSourceUserId());
            observersOfUser.put(uri, obs);
            if ((uri.getFlags() & 1) == 0) goto L14;
            boolean andDescendants = true;
        L16:
            if (ContentObserverController.m4936$$Nest$sfgetDEBUG() == false) goto L18;
            Slog.v(ContentObserverController.TAG, "New observer " + obs + " for " + uri.getUri() + " andDescendants=" + andDescendants + " sourceUserId=" + sourceUserId);
        L18:
            this$0.mContext.getContentResolver().registerContentObserver(uri.getUri(), andDescendants, obs, sourceUserId);
        L26:
            obs.mJobs.add(this);
            this.mMyObservers.add(obs);
            r8 = r8 + 1;
            goto L8
        L14:
            andDescendants = false;
            goto L16
        L20:
            if (ContentObserverController.m4936$$Nest$sfgetDEBUG() == false) goto L26;
            if ((uri.getFlags() & 1) == 0) goto L24;
            boolean andDescendants2 = true;
        L25:
            Slog.v(ContentObserverController.TAG, "Reusing existing observer " + obs + " for " + uri.getUri() + " andDescendants=" + andDescendants2);
            goto L26
        L24:
            andDescendants2 = false;
            goto L25
        L32:
            return;
        }

        void trigger() {
            boolean reportChange = false;
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.mTriggerPending == false) goto L12;
            long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();     // Catch: Throwable -> L10
            if (this.mJobStatus.setContentTriggerConstraintSatisfied(nowElapsed, true) == false) goto L9;
            reportChange = true;
        L9:
            unscheduleLocked();     // Catch: Throwable -> L10
        L12:
            monitor-exit(r1);     // Catch: Throwable -> L10
            if (reportChange == false) goto L20;
            ArraySet<JobStatus> changedJob = new ArraySet();
            changedJob.add(this.mJobStatus);
            this.this$0.mStateChangedListener.onControllerStateChanged(changedJob);
            return;
        }

        void scheduleLocked() {
            if (this.mTriggerPending == true) goto L5;
            this.mTriggerPending = true;
            this.this$0.mHandler.postDelayed(this.mTimeoutRunner, this.mJobStatus.getTriggerContentMaxDelay());
        L5:
            this.this$0.mHandler.removeCallbacks(this.mExecuteRunner);
            if (this.mChangedUris.size() < 40) goto L8;
            this.this$0.mHandler.post(this.mExecuteRunner);
            return;
        L8:
            this.this$0.mHandler.postDelayed(this.mExecuteRunner, this.mJobStatus.getTriggerContentUpdateDelay());
        }

        void unscheduleLocked() {
            if (this.mTriggerPending == false) goto L6;
            this.this$0.mHandler.removeCallbacks(this.mExecuteRunner);
            this.this$0.mHandler.removeCallbacks(this.mTimeoutRunner);
            this.mTriggerPending = false;
            return;
        }

        void detachLocked() {
            int N = this.mMyObservers.size();
            int i = 0;
        L3:
            if (i >= N) goto L14;
            ObserverInstance obs = this.mMyObservers.get(i);
            obs.mJobs.remove(this);
            if (obs.mJobs.size() != 0) goto L12;
            if (ContentObserverController.m4936$$Nest$sfgetDEBUG() == false) goto L9;
            Slog.i(ContentObserverController.TAG, "Unregistering observer " + obs + " for " + obs.mUri.getUri());
        L9:
            this.this$0.mContext.getContentResolver().unregisterContentObserver(obs);
            ArrayMap<JobInfo.TriggerContentUri, ObserverInstance> observerOfUser = this.this$0.mObservers.get(obs.mUserId);
            if (observerOfUser == null) goto L12;
            observerOfUser.remove(obs.mUri);
        L12:
            i = i + 1;
            goto L3
        }
    }

    final class ObserverInstance extends ContentObserver {
        final ArraySet<JobInstance> mJobs;
        final JobInfo.TriggerContentUri mUri;
        final int mUserId;
        final /* synthetic */ ContentObserverController this$0;

        public ObserverInstance(ContentObserverController this$0, Handler handler, JobInfo.TriggerContentUri uri, int userId) {
            this.this$0 = this$0;
            super(handler);
            this.mJobs = new ArraySet();
            this.mUri = uri;
            this.mUserId = userId;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            if (ContentObserverController.m4936$$Nest$sfgetDEBUG() == false) goto L5;
            Slog.i(ContentObserverController.TAG, "onChange(self=" + selfChange + ") for " + uri + " when mUri=" + this.mUri + " mUserId=" + this.mUserId);
        L5:
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            int N = this.mJobs.size();     // Catch: Throwable -> L12
            int i = 0;
        L8:
            if (i >= N) goto L22;
            JobInstance inst = this.mJobs.valueAt(i);     // Catch: Throwable -> L12
            if (inst.mChangedUris != null) goto L15;
            inst.mChangedUris = new ArraySet();     // Catch: Throwable -> L12
        L15:
            if (inst.mChangedUris.size() >= 50) goto L18;
            inst.mChangedUris.add(uri);     // Catch: Throwable -> L12
        L18:
            if (inst.mChangedAuthorities != null) goto L20;
            inst.mChangedAuthorities = new ArraySet();     // Catch: Throwable -> L12
        L20:
            inst.mChangedAuthorities.add(uri.getAuthority());     // Catch: Throwable -> L12
            inst.scheduleLocked();     // Catch: Throwable -> L12
            i = i + 1;     // Catch: Throwable -> L12
            goto L8
        L22:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    static final class TriggerRunnable implements Runnable {
        final JobInstance mInstance;

        TriggerRunnable(JobInstance instance) {
            this.mInstance = instance;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mInstance.trigger();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4936$$Nest$sfgetDEBUG() {
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

    public ContentObserverController(JobSchedulerService service) {
        super(service);
        this.mTrackedTasks = new ArraySet();
        this.mObservers = new SparseArray();
        this.mHandler = new Handler(AppSchedulingModuleThread.get().getLooper());
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStartTrackingJobLocked(JobStatus taskStatus, JobStatus lastJob) {
        if (taskStatus.hasContentTriggerConstraint() == false) goto L32;
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        if (taskStatus.contentObserverJobInstance != null) goto L8;
        taskStatus.contentObserverJobInstance = new JobInstance(this, taskStatus);
    L8:
        if (DEBUG == false) goto L10;
        Slog.i(TAG, "Tracking content-trigger job " + taskStatus);
    L10:
        this.mTrackedTasks.add(taskStatus);
        taskStatus.setTrackingController(4);
        boolean havePendingUris = false;
        if (taskStatus.contentObserverJobInstance.mChangedAuthorities == null) goto L14;
        havePendingUris = true;
    L14:
        if (taskStatus.changedAuthorities == null) goto L31;
        havePendingUris = true;
        if (taskStatus.contentObserverJobInstance.mChangedAuthorities != null) goto L18;
        taskStatus.contentObserverJobInstance.mChangedAuthorities = new ArraySet();
    L18:
        Iterator<String> r4 = taskStatus.changedAuthorities.iterator();
    L20:
        if (r4.hasNext() == false) goto L23;
        String auth = r4.next();
        taskStatus.contentObserverJobInstance.mChangedAuthorities.add(auth);
        goto L20
    L23:
        if (taskStatus.changedUris == null) goto L31;
        if (taskStatus.contentObserverJobInstance.mChangedUris != null) goto L27;
        taskStatus.contentObserverJobInstance.mChangedUris = new ArraySet();
    L27:
        Iterator<Uri> r5 = taskStatus.changedUris.iterator();
    L29:
        if (r5.hasNext() == false) goto L31;
        Uri uri = r5.next();
        taskStatus.contentObserverJobInstance.mChangedUris.add(uri);
    L31:
        taskStatus.changedAuthorities = null;
        taskStatus.changedUris = null;
        taskStatus.setContentTriggerConstraintSatisfied(nowElapsed, havePendingUris);
    L32:
        if (lastJob != null) goto L34;
        return;
    L34:
        if (lastJob.contentObserverJobInstance == null) goto L40;
        lastJob.contentObserverJobInstance.detachLocked();
        lastJob.contentObserverJobInstance = null;
        return;
    }

    @Override // com.android.server.job.controllers.StateController
    public void prepareForExecutionLocked(JobStatus taskStatus) {
        if (taskStatus.hasContentTriggerConstraint() == true) goto L5;
        return;
    L5:
        if (taskStatus.contentObserverJobInstance == null) goto L9;
        taskStatus.changedUris = taskStatus.contentObserverJobInstance.mChangedUris;
        taskStatus.changedAuthorities = taskStatus.contentObserverJobInstance.mChangedAuthorities;
        taskStatus.contentObserverJobInstance.mChangedUris = null;
        taskStatus.contentObserverJobInstance.mChangedAuthorities = null;
        return;
    }

    @Override // com.android.server.job.controllers.StateController
    public void unprepareFromExecutionLocked(JobStatus taskStatus) {
        if (taskStatus.hasContentTriggerConstraint() == true) goto L5;
        return;
    L5:
        if (taskStatus.contentObserverJobInstance != null) goto L7;
        return;
    L7:
        if (taskStatus.contentObserverJobInstance.mChangedUris != null) goto L9;
        JobInstance r0 = taskStatus.contentObserverJobInstance;
        r0.mChangedUris = taskStatus.changedUris;
    L11:
        if (taskStatus.contentObserverJobInstance.mChangedAuthorities != null) goto L13;
        JobInstance r1 = taskStatus.contentObserverJobInstance;
        r1.mChangedAuthorities = taskStatus.changedAuthorities;
    L14:
        taskStatus.changedUris = null;
        taskStatus.changedAuthorities = null;
        return;
    L13:
        taskStatus.contentObserverJobInstance.mChangedAuthorities.addAll(taskStatus.changedAuthorities);
        goto L14
    L9:
        taskStatus.contentObserverJobInstance.mChangedUris.addAll(taskStatus.changedUris);
        goto L11
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStopTrackingJobLocked(JobStatus taskStatus, JobStatus incomingJob) {
        if (taskStatus.clearTrackingController(4) == false) goto L21;
        this.mTrackedTasks.remove(taskStatus);
        if (taskStatus.contentObserverJobInstance == null) goto L18;
        taskStatus.contentObserverJobInstance.unscheduleLocked();
        if (incomingJob != null) goto L9;
        taskStatus.contentObserverJobInstance.detachLocked();
        taskStatus.contentObserverJobInstance = null;
        goto L18
    L9:
        if (taskStatus.contentObserverJobInstance == null) goto L18;
        if (taskStatus.contentObserverJobInstance.mChangedAuthorities == null) goto L18;
        if (incomingJob.contentObserverJobInstance != null) goto L15;
        incomingJob.contentObserverJobInstance = new JobInstance(this, incomingJob);
    L15:
        incomingJob.contentObserverJobInstance.mChangedAuthorities = taskStatus.contentObserverJobInstance.mChangedAuthorities;
        incomingJob.contentObserverJobInstance.mChangedUris = taskStatus.contentObserverJobInstance.mChangedUris;
        taskStatus.contentObserverJobInstance.mChangedAuthorities = null;
        taskStatus.contentObserverJobInstance.mChangedUris = null;
    L18:
        if (DEBUG == false) goto L22;
        Slog.i(TAG, "No longer tracking job " + taskStatus);
        return;
    L22:
        return;
    }

    @Override // com.android.server.job.controllers.StateController
    public void rescheduleForFailureLocked(JobStatus newJob, JobStatus failureToReschedule) {
        if (failureToReschedule.hasContentTriggerConstraint() == true) goto L5;
        return;
    L5:
        if (newJob.hasContentTriggerConstraint() == false) goto L9;
        newJob.changedAuthorities = failureToReschedule.changedAuthorities;
        newJob.changedUris = failureToReschedule.changedUris;
        return;
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpControllerStateLocked(IndentingPrintWriter pw, Predicate<JobStatus> predicate) {
        ContentObserverController r0 = this;
        Predicate<JobStatus> r2 = predicate;
        int i = 0;
    L4:
        if (i >= r0.mTrackedTasks.size()) goto L10;
        JobStatus js = r0.mTrackedTasks.valueAt(i);
        if (r2.test(js) == false) goto L9;
        pw.print("#");
        js.printUniqueId(pw);
        pw.print(" from ");
        UserHandle.formatUid(pw, js.getSourceUid());
        pw.println();
    L9:
        i = i + 1;
        goto L4
    L10:
        pw.println();
        int N = r0.mObservers.size();
        if (N <= 0) goto L50;
        pw.println("Observers:");
        pw.increaseIndent();
        int userIdx = 0;
    L13:
        if (userIdx >= N) goto L48;
        int userId = r0.mObservers.keyAt(userIdx);
        ArrayMap<JobInfo.TriggerContentUri, ObserverInstance> observersOfUser = r0.mObservers.get(userId);
        int numbOfObserversPerUser = observersOfUser.size();
        int observerIdx = 0;
    L15:
        if (observerIdx >= numbOfObserversPerUser) goto L47;
        ObserverInstance obs = observersOfUser.valueAt(observerIdx);
        int M = obs.mJobs.size();
        boolean shouldDump = false;
        int j = 0;
    L17:
        if (j >= M) goto L22;
        if (r2.test(obs.mJobs.valueAt(j).mJobStatus) == true) goto L20;
        j = j + 1;
        goto L17
    L20:
        shouldDump = true;
    L22:
        if (shouldDump == true) goto L24;
        int N2 = N;
    L46:
        observerIdx = observerIdx + 1;
        r2 = predicate;
        N = N2;
        goto L15
    L24:
        JobInfo.TriggerContentUri trigger = observersOfUser.keyAt(observerIdx);
        pw.print(trigger.getUri());
        pw.print(" 0x");
        pw.print(Integer.toHexString(trigger.getFlags()));
        pw.print(" (");
        pw.print(System.identityHashCode(obs));
        pw.println("):");
        pw.increaseIndent();
        pw.println("Jobs:");
        pw.increaseIndent();
        int j2 = 0;
    L25:
        if (j2 >= M) goto L45;
        JobInstance inst = obs.mJobs.valueAt(j2);
        pw.print("#");
        JobInfo.TriggerContentUri trigger2 = trigger;
        inst.mJobStatus.printUniqueId(pw);
        pw.print(" from ");
        UserHandle.formatUid(pw, inst.mJobStatus.getSourceUid());
        if (inst.mChangedAuthorities == null) goto L43;
        pw.println(":");
        pw.increaseIndent();
        if (inst.mTriggerPending == false) goto L32;
        pw.print("Trigger pending: update=");
        TimeUtils.formatDuration(inst.mJobStatus.getTriggerContentUpdateDelay(), pw);
        pw.print(", max=");
        TimeUtils.formatDuration(inst.mJobStatus.getTriggerContentMaxDelay(), pw);
        pw.println();
    L32:
        pw.println("Changed Authorities:");
        int k = 0;
    L34:
        if (k >= inst.mChangedAuthorities.size()) goto L37;
        pw.println(inst.mChangedAuthorities.valueAt(k));
        k = k + 1;
        goto L34
    L37:
        if (inst.mChangedUris == null) goto L42;
        pw.println("          Changed URIs:");
        int k2 = 0;
    L40:
        if (k2 >= inst.mChangedUris.size()) goto L42;
        pw.println(inst.mChangedUris.valueAt(k2));
        k2 = k2 + 1;
    L42:
        pw.decreaseIndent();
    L44:
        j2 = j2 + 1;
        trigger = trigger2;
        N = N;
        goto L25
    L43:
        N = N;
        pw.println();
        goto L44
    L45:
        N2 = N;
        pw.decreaseIndent();
        pw.decreaseIndent();
        goto L46
    L47:
        userIdx = userIdx + 1;
        r0 = this;
        r2 = predicate;
        goto L13
    L48:
        pw.decreaseIndent();
        return;
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpControllerStateLocked(ProtoOutputStream proto, long fieldId, Predicate<JobStatus> predicate) {
        ContentObserverController r0 = this;
        Predicate<JobStatus> r2 = predicate;
        long token = proto.start(fieldId);
        long mToken = proto.start(1146756268036L);
        int i = 0;
    L4:
        if (i >= r0.mTrackedTasks.size()) goto L10;
        JobStatus js = r0.mTrackedTasks.valueAt(i);
        if (r2.test(js) == false) goto L9;
        long jsToken = proto.start(2246267895809L);
        js.writeToShortProto(proto, 1146756268033L);
        proto.write(1120986464258L, js.getSourceUid());
        proto.end(jsToken);
    L9:
        i = i + 1;
        goto L4
    L10:
        int n = r0.mObservers.size();
        int userIdx = 0;
    L11:
        if (userIdx >= n) goto L54;
        long oToken = proto.start(2246267895810L);
        int userId = r0.mObservers.keyAt(userIdx);
        proto.write(1120986464257L, userId);
        ArrayMap<JobInfo.TriggerContentUri, ObserverInstance> observersOfUser = r0.mObservers.get(userId);
        int numbOfObserversPerUser = observersOfUser.size();
        int observerIdx = 0;
    L13:
        if (observerIdx >= numbOfObserversPerUser) goto L53;
        ObserverInstance obs = observersOfUser.valueAt(observerIdx);
        int m = obs.mJobs.size();
        boolean shouldDump = false;
        int n2 = n;
        int n3 = 0;
    L15:
        if (n3 >= m) goto L20;
        int userIdx2 = userIdx;
        int j = n3;
        if (r2.test(obs.mJobs.valueAt(n3).mJobStatus) == true) goto L18;
        n3 = j + 1;
        userIdx = userIdx2;
        goto L15
    L18:
        shouldDump = true;
    L21:
        if (shouldDump == true) goto L23;
        ArrayMap<JobInfo.TriggerContentUri, ObserverInstance> observersOfUser2 = observersOfUser;
        int numbOfObserversPerUser2 = numbOfObserversPerUser;
        int observerIdx2 = observerIdx;
    L52:
        observerIdx = observerIdx2 + 1;
        r2 = predicate;
        token = token;
        userIdx = userIdx2;
        n = n2;
        observersOfUser = observersOfUser2;
        numbOfObserversPerUser = numbOfObserversPerUser2;
        goto L13
    L23:
        long tToken = proto.start(2246267895810L);
        JobInfo.TriggerContentUri trigger = observersOfUser.keyAt(observerIdx);
        Uri u = trigger.getUri();
        if (u == null) goto L27;
        proto.write(1138166333441L, u.toString());
    L27:
        proto.write(1120986464258L, trigger.getFlags());
        int observerIdx3 = 0;
    L28:
        if (observerIdx3 >= m) goto L51;
        long jToken = proto.start(2246267895811L);
        int m2 = m;
        JobInstance inst = obs.mJobs.valueAt(observerIdx3);
        int j2 = observerIdx3;
        ArrayMap<JobInfo.TriggerContentUri, ObserverInstance> observersOfUser3 = observersOfUser;
        int numbOfObserversPerUser3 = numbOfObserversPerUser;
        inst.mJobStatus.writeToShortProto(proto, 1146756268033L);
        proto.write(1120986464258L, inst.mJobStatus.getSourceUid());
        if (inst.mChangedAuthorities != null) goto L33;
        proto.end(jToken);
        observerIdx = observerIdx;
        obs = obs;
    L50:
        observerIdx = observerIdx;
        observersOfUser = observersOfUser3;
        numbOfObserversPerUser = numbOfObserversPerUser3;
        obs = obs;
        observerIdx3 = j2 + 1;
        m = m2;
        goto L28
    L33:
        if (inst.mTriggerPending == false) goto L36;
        proto.write(1112396529667L, inst.mJobStatus.getTriggerContentUpdateDelay());
        proto.write(1112396529668L, inst.mJobStatus.getTriggerContentMaxDelay());
    L36:
        int k = 0;
    L38:
        if (k >= inst.mChangedAuthorities.size()) goto L41;
        proto.write(2237677961221L, inst.mChangedAuthorities.valueAt(k));
        k = k + 1;
        goto L38
    L41:
        if (inst.mChangedUris == null) goto L49;
        int k2 = 0;
    L44:
        if (k2 >= inst.mChangedUris.size()) goto L49;
        Uri u2 = inst.mChangedUris.valueAt(k2);
        if (u2 == null) goto L48;
        proto.write(2237677961222L, u2.toString());
    L48:
        k2 = k2 + 1;
    L49:
        proto.end(jToken);
        goto L50
    L51:
        observersOfUser2 = observersOfUser;
        numbOfObserversPerUser2 = numbOfObserversPerUser;
        observerIdx2 = observerIdx;
        proto.end(tToken);
        goto L52
    L20:
        userIdx2 = userIdx;
        goto L21
    L53:
        proto.end(oToken);
        userIdx = userIdx + 1;
        r0 = this;
        r2 = predicate;
        token = token;
        goto L11
    L54:
        proto.end(mToken);
        proto.end(token);
    }
}
