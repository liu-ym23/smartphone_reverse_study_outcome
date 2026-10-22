package com.android.server.am;

import android.app.StackTrace;
import android.util.Slog;

/* JADX INFO: loaded from: classes.dex */
class OomAdjusterDebugLogger {
    private static final int MISC_CLEAR_LAST_BG_TIME = 11;
    private static final int MISC_SCHEDULE_IDLE_UIDS_MSG_1 = 1;
    private static final int MISC_SCHEDULE_IDLE_UIDS_MSG_2 = 2;
    private static final int MISC_SCHEDULE_IDLE_UIDS_MSG_3 = 3;
    private static final int MISC_SET_LAST_BG_TIME = 10;
    private static final String STACK_TRACE_TAG = "am_stack";
    private final ActivityManagerConstants mConstants;
    private final OomAdjuster mOomAdjuster;

    OomAdjusterDebugLogger(OomAdjuster oomAdjuster, ActivityManagerConstants constants) {
        this.mOomAdjuster = oomAdjuster;
        this.mConstants = constants;
    }

    boolean shouldLog(int uid) {
        return this.mConstants.shouldDebugUidForProcState(uid);
    }

    private void maybeLogStacktrace(String msg) {
        if (this.mConstants.mEnableProcStateStacktrace == true) goto L5;
        return;
    L5:
        Slog.i(STACK_TRACE_TAG, msg + ": " + OomAdjuster.oomAdjReasonToString(this.mOomAdjuster.mLastReason), new StackTrace("Called here"));
    }

    private void maybeSleep(int millis) {
        if (millis != 0) goto L9;
        return;
    L9:
        Thread.sleep(millis);     // Catch: InterruptedException -> L7
        return;
    }

    void logUidStateChanged(int uid, int uidstate, int olduidstate, int capability, int oldcapability, int flags) {
        EventLogTags.writeAmUidStateChanged(uid, this.mOomAdjuster.mAdjSeq, uidstate, olduidstate, capability, oldcapability, flags, OomAdjuster.oomAdjReasonToString(this.mOomAdjuster.mLastReason));
        maybeLogStacktrace("uidStateChanged");
        maybeSleep(this.mConstants.mProcStateDebugSetUidStateDelay);
    }

    void logProcStateChanged(int uid, int pid, int procstate, int oldprocstate, int oomadj, int oldoomadj) {
        EventLogTags.writeAmProcStateChanged(uid, pid, this.mOomAdjuster.mAdjSeq, procstate, oldprocstate, oomadj, oldoomadj, OomAdjuster.oomAdjReasonToString(this.mOomAdjuster.mLastReason));
        maybeLogStacktrace("procStateChanged");
        maybeSleep(this.mConstants.mProcStateDebugSetProcStateDelay);
    }

    void logScheduleUidIdle1(int uid, long delay) {
        EventLogTags.writeAmOomAdjMisc(1, uid, 0, this.mOomAdjuster.mAdjSeq, (int) delay, 0, "");
    }

    void logScheduleUidIdle2(int uid, int pid, long delay) {
        EventLogTags.writeAmOomAdjMisc(2, uid, pid, this.mOomAdjuster.mAdjSeq, (int) delay, 0, "");
    }

    void logScheduleUidIdle3(long delay) {
        EventLogTags.writeAmOomAdjMisc(3, 0, 0, this.mOomAdjuster.mAdjSeq, (int) delay, 0, "");
    }

    void logSetLastBackgroundTime(int uid, long time) {
        EventLogTags.writeAmOomAdjMisc(10, uid, 0, this.mOomAdjuster.mAdjSeq, (int) time, 0, OomAdjuster.oomAdjReasonToString(this.mOomAdjuster.mLastReason));
    }

    void logClearLastBackgroundTime(int uid) {
        EventLogTags.writeAmOomAdjMisc(11, uid, 0, this.mOomAdjuster.mAdjSeq, 0, 0, OomAdjuster.oomAdjReasonToString(this.mOomAdjuster.mLastReason));
    }
}
