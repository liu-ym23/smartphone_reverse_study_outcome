package com.android.server.job.controllers;

import android.app.AlarmManager;
import android.os.UserHandle;
import android.os.WorkSource;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.Slog;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import com.android.modules.expresslog.Counter;
import com.android.server.AppSchedulingModuleThread;
import com.android.server.am.HostingRecord;
import com.android.server.job.JobSchedulerService;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public final class TimeController extends StateController {
    private static final boolean DEBUG = false;
    static final long DELAY_COALESCE_TIME_MS = 30000;
    private static final String TAG = "JobScheduler.Time";
    private final String DEADLINE_TAG;
    private final String DELAY_TAG;
    private AlarmManager mAlarmService;
    private final AlarmManager.OnAlarmListener mDeadlineExpiredListener;
    private volatile long mLastFiredDelayExpiredElapsedMillis;
    private long mNextDelayExpiredElapsedMillis;
    private final AlarmManager.OnAlarmListener mNextDelayExpiredListener;
    private long mNextJobExpiredElapsedMillis;
    private final PriorityQueue<JobStatus> mTrackedJobs;

    /* JADX INFO: renamed from: -$$Nest$fputmLastFiredDelayExpiredElapsedMillis, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5091$$Nest$fputmLastFiredDelayExpiredElapsedMillis(TimeController r0, long r1) {
        r0.mLastFiredDelayExpiredElapsedMillis = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5092$$Nest$sfgetDEBUG() {
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

    public TimeController(JobSchedulerService service) {
        super(service);
        this.DEADLINE_TAG = "*job.deadline*";
        this.DELAY_TAG = "*job.delay*";
        this.mAlarmService = null;
        this.mTrackedJobs = new PriorityQueue(new AnonymousClass1(this));
        this.mDeadlineExpiredListener = new AnonymousClass2(this);
        this.mNextDelayExpiredListener = new AnonymousClass3(this);
        this.mNextJobExpiredElapsedMillis = Long.MAX_VALUE;
        this.mNextDelayExpiredElapsedMillis = Long.MAX_VALUE;
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStartTrackingJobLocked(JobStatus job, JobStatus lastJob) {
        if (job.hasTimingDelayConstraint() == false) goto L5;
    L6:
        maybeStopTrackingJobLocked(job, null);
        long nowElapsedMillis = JobSchedulerService.sElapsedRealtimeClock.millis();
        if (job.hasDeadlineConstraint() == false) goto L12;
        if (evaluateDeadlineConstraint(job, nowElapsedMillis) == false) goto L12;
        return;
    L12:
        if (job.hasTimingDelayConstraint() == true) goto L14;
    L18:
        this.mTrackedJobs.add(job);
        job.setTrackingController(32);
        WorkSource ws = this.mService.deriveWorkSource(job.getSourceUid(), job.getSourcePackageName());
        if (job.hasTimingDelayConstraint() == false) goto L24;
        if (wouldBeReadyWithConstraintLocked(job, Integer.MIN_VALUE) == false) goto L24;
        maybeUpdateDelayAlarmLocked(job.getEarliestRunTime(), ws);
    L24:
        if (job.hasDeadlineConstraint() == true) goto L26;
        return;
    L26:
        if (wouldBeReadyWithConstraintLocked(job, 1073741824) == false) goto L31;
        maybeUpdateDeadlineAlarmLocked(job.getLatestRunTimeElapsed(), ws);
        return;
    L31:
        return;
    L14:
        if (evaluateTimingDelayConstraint(job, nowElapsedMillis) == false) goto L18;
        if (job.hasDeadlineConstraint() == true) goto L18;
        return;
    L5:
        if (job.hasDeadlineConstraint() == true) goto L6;
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStopTrackingJobLocked(JobStatus job, JobStatus incomingJob) {
        if (job.clearTrackingController(32) == true) goto L5;
        return;
    L5:
        if (this.mTrackedJobs.remove(job) == false) goto L9;
        checkExpiredDelaysAndResetAlarm();
        checkExpiredDeadlinesAndResetAlarm();
        return;
    }

    @Override // com.android.server.job.controllers.StateController
    public void evaluateStateLocked(JobStatus job) {
        long nowElapsedMillis = JobSchedulerService.sElapsedRealtimeClock.millis();
        if (job.hasDeadlineConstraint() == false) goto L18;
        if (job.isConstraintSatisfied(1073741824) == true) goto L18;
        if (job.getLatestRunTimeElapsed() > this.mNextJobExpiredElapsedMillis) goto L18;
        if (evaluateDeadlineConstraint(job, nowElapsedMillis) == false) goto L15;
        if (job.isReady() == false) goto L13;
        this.mStateChangedListener.onRunJobNow(job);
    L13:
        this.mTrackedJobs.remove(job);
        Counter.logIncrement("job_scheduler.value_job_scheduler_job_deadline_expired_counter");
        goto L18
    L15:
        if (wouldBeReadyWithConstraintLocked(job, 1073741824) == false) goto L18;
        setDeadlineExpiredAlarmLocked(job.getLatestRunTimeElapsed(), this.mService.deriveWorkSource(job.getSourceUid(), job.getSourcePackageName()));
    L18:
        if (job.hasTimingDelayConstraint() == true) goto L20;
        return;
    L20:
        if (job.isConstraintSatisfied(Integer.MIN_VALUE) == false) goto L22;
        return;
    L22:
        if (job.getEarliestRunTime() <= this.mNextDelayExpiredElapsedMillis) goto L24;
        return;
    L24:
        if (evaluateTimingDelayConstraint(job, nowElapsedMillis) == false) goto L29;
        if (canStopTrackingJobLocked(job) == false) goto L35;
        this.mTrackedJobs.remove(job);
        return;
    L35:
        return;
    L29:
        if (wouldBeReadyWithConstraintLocked(job, Integer.MIN_VALUE) == false) goto L37;
        setDelayExpiredAlarmLocked(job.getEarliestRunTime(), this.mService.deriveWorkSource(job.getSourceUid(), job.getSourcePackageName()));
        return;
    }

    @Override // com.android.server.job.controllers.StateController
    public void reevaluateStateLocked(int uid) {
        checkExpiredDeadlinesAndResetAlarm();
        checkExpiredDelaysAndResetAlarm();
    }

    private boolean canStopTrackingJobLocked(JobStatus job) {
        if (job.hasTimingDelayConstraint() == false) goto L7;
        if (job.isConstraintSatisfied(Integer.MIN_VALUE) == true) goto L7;
    L11:
        return false;
    L7:
        if (job.hasDeadlineConstraint() == true) goto L9;
    L12:
        return true;
    L9:
        if (job.isConstraintSatisfied(1073741824) == false) goto L11;
        goto L11
    }

    private void ensureAlarmServiceLocked() {
        if (this.mAlarmService != null) goto L6;
        this.mAlarmService = (AlarmManager) this.mContext.getSystemService(HostingRecord.TRIGGER_TYPE_ALARM);
        return;
    }

    void checkExpiredDeadlinesAndResetAlarm() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long nextExpiryTime = Long.MAX_VALUE;
        int nextExpiryUid = 0;
        String nextExpiryPackageName = null;
        long nowElapsedMillis = JobSchedulerService.sElapsedRealtimeClock.millis();     // Catch: Throwable -> L16
        Iterator<JobStatus> it = this.mTrackedJobs.iterator();     // Catch: Throwable -> L16
    L7:
        if (it.hasNext() == false) goto L25;
        JobStatus job = it.next();     // Catch: Throwable -> L16
        if (job.hasDeadlineConstraint() == false) goto L7;
        if (evaluateDeadlineConstraint(job, nowElapsedMillis) == true) goto L14;
        if (wouldBeReadyWithConstraintLocked(job, 1073741824) == true) goto L24;
        if (DEBUG == false) goto L7;
        Slog.i(TAG, "Skipping " + job + " because deadline won't make it ready.");     // Catch: Throwable -> L16
        goto L7
    L24:
        nextExpiryTime = job.getLatestRunTimeElapsed();     // Catch: Throwable -> L16
        nextExpiryUid = job.getSourceUid();     // Catch: Throwable -> L16
        nextExpiryPackageName = job.getSourcePackageName();     // Catch: Throwable -> L16
        goto L25
    L14:
        if (job.isReady() == false) goto L18;
        this.mStateChangedListener.onRunJobNow(job);     // Catch: Throwable -> L16
    L18:
        Counter.logIncrement("job_scheduler.value_job_scheduler_job_deadline_expired_counter");     // Catch: Throwable -> L16
        it.remove();     // Catch: Throwable -> L16
    L25:
        setDeadlineExpiredAlarmLocked(nextExpiryTime, this.mService.deriveWorkSource(nextExpiryUid, nextExpiryPackageName));     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private boolean evaluateDeadlineConstraint(JobStatus job, long nowElapsedMillis) {
        long jobDeadline = job.getLatestRunTimeElapsed();
        if (jobDeadline <= nowElapsedMillis) goto L5;
        return false;
    L5:
        if (job.hasTimingDelayConstraint() == false) goto L7;
        job.setTimingDelayConstraintSatisfied(nowElapsedMillis, true);
    L7:
        job.setDeadlineConstraintSatisfied(nowElapsedMillis, true);
        return true;
    }

    void checkExpiredDelaysAndResetAlarm() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long nextDelayTime = Long.MAX_VALUE;
        int nextDelayUid = 0;
        String nextDelayPackageName = null;
        ArraySet<JobStatus> changedJobs = new ArraySet();     // Catch: Throwable -> L16
        Iterator<JobStatus> it = this.mTrackedJobs.iterator();     // Catch: Throwable -> L16
        long nowElapsedMillis = JobSchedulerService.sElapsedRealtimeClock.millis();     // Catch: Throwable -> L16
    L7:
        if (it.hasNext() == false) goto L29;
        JobStatus job = it.next();     // Catch: Throwable -> L16
        if (job.hasTimingDelayConstraint() == false) goto L7;
        if (evaluateTimingDelayConstraint(job, nowElapsedMillis) == true) goto L14;
        if (wouldBeReadyWithConstraintLocked(job, Integer.MIN_VALUE) == true) goto L24;
        if (DEBUG == false) goto L7;
        Slog.i(TAG, "Skipping " + job + " because delay won't make it ready.");     // Catch: Throwable -> L16
        goto L7
    L24:
        long jobDelayTime = job.getEarliestRunTime();     // Catch: Throwable -> L16
        if (nextDelayTime <= jobDelayTime) goto L7;
        nextDelayTime = jobDelayTime;
        int nextDelayUid2 = job.getSourceUid();     // Catch: Throwable -> L16
        nextDelayPackageName = job.getSourcePackageName();     // Catch: Throwable -> L16
        nextDelayUid = nextDelayUid2;
        goto L7
    L14:
        if (canStopTrackingJobLocked(job) == false) goto L18;
        it.remove();     // Catch: Throwable -> L16
    L18:
        changedJobs.add(job);     // Catch: Throwable -> L16
        goto L7
    L29:
        if (changedJobs.size() <= 0) goto L31;
        this.mStateChangedListener.onControllerStateChanged(changedJobs);     // Catch: Throwable -> L16
    L31:
        setDelayExpiredAlarmLocked(nextDelayTime, this.mService.deriveWorkSource(nextDelayUid, nextDelayPackageName));     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private boolean evaluateTimingDelayConstraint(JobStatus job, long nowElapsedMillis) {
        long jobDelayTime = job.getEarliestRunTime();
        if (jobDelayTime > nowElapsedMillis) goto L6;
        job.setTimingDelayConstraintSatisfied(nowElapsedMillis, true);
        return true;
    L6:
        return false;
    }

    private void maybeUpdateDelayAlarmLocked(long delayExpiredElapsed, WorkSource ws) {
        if (delayExpiredElapsed >= this.mNextDelayExpiredElapsedMillis) goto L6;
        setDelayExpiredAlarmLocked(delayExpiredElapsed, ws);
        return;
    }

    private void maybeUpdateDeadlineAlarmLocked(long deadlineExpiredElapsed, WorkSource ws) {
        if (deadlineExpiredElapsed >= this.mNextJobExpiredElapsedMillis) goto L6;
        setDeadlineExpiredAlarmLocked(deadlineExpiredElapsed, ws);
        return;
    }

    private void setDelayExpiredAlarmLocked(long alarmTimeElapsedMillis, WorkSource ws) {
        long alarmTimeElapsedMillis2 = maybeAdjustAlarmTime(Math.max(alarmTimeElapsedMillis, this.mLastFiredDelayExpiredElapsedMillis + 30000));
        if (this.mNextDelayExpiredElapsedMillis != alarmTimeElapsedMillis2) goto L5;
        return;
    L5:
        this.mNextDelayExpiredElapsedMillis = alarmTimeElapsedMillis2;
        updateAlarmWithListenerLocked("*job.delay*", 3, this.mNextDelayExpiredListener, this.mNextDelayExpiredElapsedMillis, ws);
    }

    private void setDeadlineExpiredAlarmLocked(long alarmTimeElapsedMillis, WorkSource ws) {
        long alarmTimeElapsedMillis2 = maybeAdjustAlarmTime(alarmTimeElapsedMillis);
        if (this.mNextJobExpiredElapsedMillis != alarmTimeElapsedMillis2) goto L5;
        return;
    L5:
        this.mNextJobExpiredElapsedMillis = alarmTimeElapsedMillis2;
        updateAlarmWithListenerLocked("*job.deadline*", 2, this.mDeadlineExpiredListener, this.mNextJobExpiredElapsedMillis, ws);
    }

    private long maybeAdjustAlarmTime(long proposedAlarmTimeElapsedMillis) {
        return Math.max(proposedAlarmTimeElapsedMillis, JobSchedulerService.sElapsedRealtimeClock.millis());
    }

    private void updateAlarmWithListenerLocked(String tag, int alarmType, AlarmManager.OnAlarmListener listener, long alarmTimeElapsed, WorkSource ws) {
        ensureAlarmServiceLocked();
        if (alarmTimeElapsed != Long.MAX_VALUE) goto L6;
        this.mAlarmService.cancel(listener);
        return;
    L6:
        if (DEBUG == false) goto L8;
        Slog.d(TAG, "Setting " + tag + " for: " + alarmTimeElapsed);
    L8:
        this.mAlarmService.set(alarmType, alarmTimeElapsed, -1, 0, tag, listener, AppSchedulingModuleThread.getHandler(), ws);
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpControllerStateLocked(IndentingPrintWriter pw, Predicate<JobStatus> predicate) {
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        pw.println("Elapsed clock: " + nowElapsed);
        pw.print("Next delay alarm in ");
        TimeUtils.formatDuration(this.mNextDelayExpiredElapsedMillis, nowElapsed, pw);
        pw.println();
        pw.print("Last delay alarm fired @ ");
        TimeUtils.formatDuration(nowElapsed, this.mLastFiredDelayExpiredElapsedMillis, pw);
        pw.println();
        pw.print("Next deadline alarm in ");
        TimeUtils.formatDuration(this.mNextJobExpiredElapsedMillis, nowElapsed, pw);
        pw.println();
        pw.println();
        Iterator<JobStatus> r2 = this.mTrackedJobs.iterator();
    L4:
        if (r2.hasNext() == false) goto L17;
        JobStatus ts = r2.next();
        if (predicate.test(ts) == false) goto L4;
        pw.print("#");
        ts.printUniqueId(pw);
        pw.print(" from ");
        UserHandle.formatUid(pw, ts.getSourceUid());
        pw.print(": Delay=");
        if (ts.hasTimingDelayConstraint() == false) goto L11;
        TimeUtils.formatDuration(ts.getEarliestRunTime(), nowElapsed, pw);
    L12:
        pw.print(", Deadline=");
        if (ts.hasDeadlineConstraint() == false) goto L15;
        TimeUtils.formatDuration(ts.getLatestRunTimeElapsed(), nowElapsed, pw);
    L16:
        pw.println();
        goto L4
    L15:
        pw.print("N/A");
        goto L16
    L11:
        pw.print("N/A");
        goto L12
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpControllerStateLocked(ProtoOutputStream proto, long fieldId, Predicate<JobStatus> predicate) {
        long token = proto.start(fieldId);
        long mToken = proto.start(1146756268040L);
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        proto.write(1112396529665L, nowElapsed);
        proto.write(1112396529666L, this.mNextDelayExpiredElapsedMillis - nowElapsed);
        proto.write(1112396529667L, this.mNextJobExpiredElapsedMillis - nowElapsed);
        Iterator<JobStatus> r8 = this.mTrackedJobs.iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        JobStatus ts = r8.next();
        if (predicate.test(ts) == false) goto L4;
        long tsToken = proto.start(2246267895812L);
        ts.writeToShortProto(proto, 1146756268033L);
        proto.write(1133871366147L, ts.hasTimingDelayConstraint());
        long nowElapsed2 = nowElapsed;
        proto.write(1112396529668L, ts.getEarliestRunTime() - nowElapsed);
        proto.write(1133871366149L, ts.hasDeadlineConstraint());
        proto.write(1112396529670L, ts.getLatestRunTimeElapsed() - nowElapsed2);
        proto.end(tsToken);
        nowElapsed = nowElapsed2;
        goto L4
    L9:
        proto.end(mToken);
        proto.end(token);
    }
}
