package com.android.server.job.controllers;

import android.app.job.JobInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.telephony.TelephonyManager;
import android.telephony.UiccSlotMapping;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.IntArray;
import android.util.KeyValueListParser;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseArrayMap;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.util.SparseSetArray;
import android.util.TimeUtils;
import com.android.server.AppSchedulingModuleThread;
import com.android.server.DeviceIdleInternal;
import com.android.server.LocalServices;
import com.android.server.alarm.HeartbeatStats;
import com.android.server.job.JobSchedulerService;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.utils.AlarmQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public final class FlexibilityController extends StateController {
    private static final boolean DEBUG = false;
    static final int FLEXIBLE_CONSTRAINTS = 268435463;
    private static final int JOB_SPECIFIC_FLEXIBLE_CONSTRAINTS = 268435456;
    private static final int MSG_CHECK_ALL_JOBS = 0;
    private static final int MSG_CHECK_JOBS = 1;
    private static final int MSG_CHECK_PACKAGES = 2;
    private static final long NO_LIFECYCLE_END = Long.MAX_VALUE;
    static final int SYSTEM_WIDE_FLEXIBLE_CONSTRAINTS = 7;
    private static final String TAG = "JobScheduler.Flex";
    private int mAppliedConstraints;
    private long mDeadlineProximityLimitMs;
    private SparseLongArray mFallbackFlexibilityAdditionalScoreTimeFactors;
    private long mFallbackFlexibilityDeadlineMs;
    private SparseIntArray mFallbackFlexibilityDeadlineScores;
    private SparseLongArray mFallbackFlexibilityDeadlines;
    final FcConfig mFcConfig;
    final FlexibilityAlarmQueue mFlexibilityAlarmQueue;
    private boolean mFlexibilityEnabled;
    final FlexibilityTracker mFlexibilityTracker;
    private final FcHandler mHandler;
    private final SparseArrayMap<String, JobScoreTracker> mJobScoreTrackers;
    private final ArraySet<JobStatus> mJobsToCheck;
    private final SparseLongArray mLastSeenConstraintTimesElapsed;
    private boolean mLocalOverride;
    private long mMaxRescheduledDeadline;
    private long mMinTimeBetweenFlexibilityAlarmsMs;
    private final ArraySet<String> mPackagesToCheck;
    private SparseArray<int[]> mPercentsToDropConstraints;
    final PrefetchController.PrefetchChangedListener mPrefetchChangedListener;
    final PrefetchController mPrefetchController;
    final SparseArrayMap<String, Long> mPrefetchLifeCycleStart;
    private long mRescheduledJobDeadline;
    int mSatisfiedFlexibleConstraints;
    private final SpecialAppTracker mSpecialAppTracker;
    private final int mSupportedFlexConstraints;
    private long mUnseenConstraintGracePeriodMs;

    class FcConfig {
        static final int DEFAULT_APPLIED_CONSTRAINTS = 0;
        static final long DEFAULT_DEADLINE_PROXIMITY_LIMIT_MS = 900000;
        static final SparseLongArray DEFAULT_FALLBACK_FLEXIBILITY_DEADLINES = null;
        static final SparseLongArray DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_ADDITIONAL_SCORE_TIME_FACTORS = null;
        static final long DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_MS = 86400000;
        static final SparseIntArray DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_SCORES = null;
        private static final long DEFAULT_MAX_RESCHEDULED_DEADLINE_MS = 86400000;
        private static final long DEFAULT_MIN_TIME_BETWEEN_FLEXIBILITY_ALARMS_MS = 60000;
        static final SparseArray<int[]> DEFAULT_PERCENTS_TO_DROP_FLEXIBLE_CONSTRAINTS = null;
        private static final long DEFAULT_RESCHEDULED_JOB_DEADLINE_MS = 3600000;
        static final long DEFAULT_UNSEEN_CONSTRAINT_GRACE_PERIOD_MS = 259200000;
        private static final String FC_CONFIG_PREFIX = "fc_";
        static final String KEY_APPLIED_CONSTRAINTS = "fc_applied_constraints";
        static final String KEY_DEADLINE_PROXIMITY_LIMIT = "fc_flexibility_deadline_proximity_limit_ms";
        static final String KEY_FALLBACK_FLEXIBILITY_DEADLINE = "fc_fallback_flexibility_deadline_ms";
        static final String KEY_FALLBACK_FLEXIBILITY_DEADLINES = "fc_fallback_flexibility_deadlines";
        static final String KEY_FALLBACK_FLEXIBILITY_DEADLINE_ADDITIONAL_SCORE_TIME_FACTORS = "fc_fallback_flexibility_deadline_additional_score_time_factors";
        static final String KEY_FALLBACK_FLEXIBILITY_DEADLINE_SCORES = "fc_fallback_flexibility_deadline_scores";
        static final String KEY_MAX_RESCHEDULED_DEADLINE_MS = "fc_max_rescheduled_deadline_ms";
        static final String KEY_MIN_TIME_BETWEEN_FLEXIBILITY_ALARMS_MS = "fc_min_time_between_flexibility_alarms_ms";
        static final String KEY_PERCENTS_TO_DROP_FLEXIBLE_CONSTRAINTS = "fc_percents_to_drop_flexible_constraints";
        static final String KEY_RESCHEDULED_JOB_DEADLINE_MS = "fc_rescheduled_job_deadline_ms";
        static final String KEY_UNSEEN_CONSTRAINT_GRACE_PERIOD_MS = "fc_unseen_constraint_grace_period_ms";
        public int APPLIED_CONSTRAINTS;
        public long DEADLINE_PROXIMITY_LIMIT_MS;
        public final SparseLongArray FALLBACK_FLEXIBILITY_DEADLINES;
        public final SparseLongArray FALLBACK_FLEXIBILITY_DEADLINE_ADDITIONAL_SCORE_TIME_FACTORS;
        public long FALLBACK_FLEXIBILITY_DEADLINE_MS;
        public final SparseIntArray FALLBACK_FLEXIBILITY_DEADLINE_SCORES;
        public long MAX_RESCHEDULED_DEADLINE_MS;
        public long MIN_TIME_BETWEEN_FLEXIBILITY_ALARMS_MS;
        public SparseArray<int[]> PERCENTS_TO_DROP_FLEXIBLE_CONSTRAINTS;
        public long RESCHEDULED_JOB_DEADLINE_MS;
        public long UNSEEN_CONSTRAINT_GRACE_PERIOD_MS;
        private boolean mShouldReevaluateConstraints;
        final /* synthetic */ FlexibilityController this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmShouldReevaluateConstraints, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m4975$$Nest$fgetmShouldReevaluateConstraints(FcConfig r0) {
            return r0.mShouldReevaluateConstraints;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmShouldReevaluateConstraints, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4976$$Nest$fputmShouldReevaluateConstraints(FcConfig r0, boolean r1) {
            r0.mShouldReevaluateConstraints = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4977$$Nest$mdump(FcConfig r0, IndentingPrintWriter r1) {
            r0.dump(r1);
        }

        static {
            DEFAULT_FALLBACK_FLEXIBILITY_DEADLINES = new SparseLongArray();
            DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_SCORES = new SparseIntArray();
            DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_ADDITIONAL_SCORE_TIME_FACTORS = new SparseLongArray();
            DEFAULT_PERCENTS_TO_DROP_FLEXIBLE_CONSTRAINTS = new SparseArray();
            DEFAULT_FALLBACK_FLEXIBILITY_DEADLINES.put(500, 3600000);
            DEFAULT_FALLBACK_FLEXIBILITY_DEADLINES.put(400, 21600000);
            DEFAULT_FALLBACK_FLEXIBILITY_DEADLINES.put(300, 43200000);
            DEFAULT_FALLBACK_FLEXIBILITY_DEADLINES.put(200, 86400000);
            DEFAULT_FALLBACK_FLEXIBILITY_DEADLINES.put(100, 172800000);
            DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_SCORES.put(500, 5);
            DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_SCORES.put(400, 4);
            DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_SCORES.put(300, 3);
            DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_SCORES.put(200, 2);
            DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_SCORES.put(100, 1);
            DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_ADDITIONAL_SCORE_TIME_FACTORS.put(500, 0);
            DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_ADDITIONAL_SCORE_TIME_FACTORS.put(400, 180000);
            DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_ADDITIONAL_SCORE_TIME_FACTORS.put(300, 120000);
            DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_ADDITIONAL_SCORE_TIME_FACTORS.put(200, 60000);
            DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_ADDITIONAL_SCORE_TIME_FACTORS.put(100, 60000);
            DEFAULT_PERCENTS_TO_DROP_FLEXIBLE_CONSTRAINTS.put(500, new int[]{1, 2, 3, 4});
            DEFAULT_PERCENTS_TO_DROP_FLEXIBLE_CONSTRAINTS.put(400, new int[]{33, 50, 60, 75});
            DEFAULT_PERCENTS_TO_DROP_FLEXIBLE_CONSTRAINTS.put(300, new int[]{50, 60, 70, 80});
            DEFAULT_PERCENTS_TO_DROP_FLEXIBLE_CONSTRAINTS.put(200, new int[]{50, 60, 70, 80});
            DEFAULT_PERCENTS_TO_DROP_FLEXIBLE_CONSTRAINTS.put(100, new int[]{55, 65, 75, 85});
        }

        FcConfig(FlexibilityController this$0) {
            this.this$0 = this$0;
            this.mShouldReevaluateConstraints = false;
            this.APPLIED_CONSTRAINTS = 0;
            this.DEADLINE_PROXIMITY_LIMIT_MS = 900000;
            this.FALLBACK_FLEXIBILITY_DEADLINE_MS = 86400000;
            this.MIN_TIME_BETWEEN_FLEXIBILITY_ALARMS_MS = 60000;
            this.PERCENTS_TO_DROP_FLEXIBLE_CONSTRAINTS = new SparseArray();
            this.RESCHEDULED_JOB_DEADLINE_MS = 3600000;
            this.MAX_RESCHEDULED_DEADLINE_MS = 86400000;
            this.UNSEEN_CONSTRAINT_GRACE_PERIOD_MS = DEFAULT_UNSEEN_CONSTRAINT_GRACE_PERIOD_MS;
            this.FALLBACK_FLEXIBILITY_DEADLINES = new SparseLongArray();
            this.FALLBACK_FLEXIBILITY_DEADLINE_SCORES = new SparseIntArray();
            this.FALLBACK_FLEXIBILITY_DEADLINE_ADDITIONAL_SCORE_TIME_FACTORS = new SparseLongArray();
            int i = 0;
        L4:
            if (i >= DEFAULT_FALLBACK_FLEXIBILITY_DEADLINES.size()) goto L6;
            this.FALLBACK_FLEXIBILITY_DEADLINES.put(DEFAULT_FALLBACK_FLEXIBILITY_DEADLINES.keyAt(i), DEFAULT_FALLBACK_FLEXIBILITY_DEADLINES.valueAt(i));
            i = i + 1;
            goto L4
        L6:
            int i2 = 0;
        L8:
            if (i2 >= DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_SCORES.size()) goto L10;
            this.FALLBACK_FLEXIBILITY_DEADLINE_SCORES.put(DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_SCORES.keyAt(i2), DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_SCORES.valueAt(i2));
            i2 = i2 + 1;
            goto L8
        L10:
            int i3 = 0;
        L12:
            if (i3 >= DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_ADDITIONAL_SCORE_TIME_FACTORS.size()) goto L14;
            this.FALLBACK_FLEXIBILITY_DEADLINE_ADDITIONAL_SCORE_TIME_FACTORS.put(DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_ADDITIONAL_SCORE_TIME_FACTORS.keyAt(i3), DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_ADDITIONAL_SCORE_TIME_FACTORS.valueAt(i3));
            i3 = i3 + 1;
            goto L12
        L14:
            int i4 = 0;
        L16:
            if (i4 >= DEFAULT_PERCENTS_TO_DROP_FLEXIBLE_CONSTRAINTS.size()) goto L19;
            this.PERCENTS_TO_DROP_FLEXIBLE_CONSTRAINTS.put(DEFAULT_PERCENTS_TO_DROP_FLEXIBLE_CONSTRAINTS.keyAt(i4), DEFAULT_PERCENTS_TO_DROP_FLEXIBLE_CONSTRAINTS.valueAt(i4));
            i4 = i4 + 1;
            goto L16
        }

        public void processConstantLocked(DeviceConfig.Properties properties, String key) {
            switch(key.hashCode()) {
                case -2004789501: goto L36;
                case -1573718613: goto L33;
                case -790107353: goto L30;
                case -540379004: goto L27;
                case 100307866: goto L24;
                case 581236233: goto L21;
                case 659395101: goto L18;
                case 746985028: goto L15;
                case 1815875441: goto L12;
                case 1821391602: goto L9;
                case 1906562988: goto L6;
                default: goto L38;
            };
        L38:
            byte r0 = -1;
        L40:
            switch(r0) {
                case 0: goto L72;
                case 1: goto L69;
                case 2: goto L66;
                case 3: goto L63;
                case 4: goto L60;
                case 5: goto L58;
                case 6: goto L55;
                case 7: goto L52;
                case 8: goto L48;
                case 9: goto L45;
                case 10: goto L43;
                default: goto L101;
            };
        L45:
            this.UNSEEN_CONSTRAINT_GRACE_PERIOD_MS = properties.getLong(key, DEFAULT_UNSEEN_CONSTRAINT_GRACE_PERIOD_MS);
            if (FlexibilityController.m4960$$Nest$fgetmUnseenConstraintGracePeriodMs(this.this$0) == this.UNSEEN_CONSTRAINT_GRACE_PERIOD_MS) goto L81;
            FlexibilityController.m4972$$Nest$fputmUnseenConstraintGracePeriodMs(this.this$0, this.UNSEEN_CONSTRAINT_GRACE_PERIOD_MS);
            this.mShouldReevaluateConstraints = true;
            return;
        L81:
            return;
        L48:
            this.MIN_TIME_BETWEEN_FLEXIBILITY_ALARMS_MS = properties.getLong(key, 60000);
            if (FlexibilityController.m4955$$Nest$fgetmMinTimeBetweenFlexibilityAlarmsMs(this.this$0) == this.MIN_TIME_BETWEEN_FLEXIBILITY_ALARMS_MS) goto L83;
            FlexibilityController.m4969$$Nest$fputmMinTimeBetweenFlexibilityAlarmsMs(this.this$0, this.MIN_TIME_BETWEEN_FLEXIBILITY_ALARMS_MS);
            this.this$0.mFlexibilityAlarmQueue.setMinTimeBetweenAlarmsMs(this.MIN_TIME_BETWEEN_FLEXIBILITY_ALARMS_MS);
            this.mShouldReevaluateConstraints = true;
            return;
        L83:
            return;
        L60:
            this.FALLBACK_FLEXIBILITY_DEADLINE_MS = properties.getLong(key, 86400000);
            if (FlexibilityController.m4950$$Nest$fgetmFallbackFlexibilityDeadlineMs(this.this$0) == this.FALLBACK_FLEXIBILITY_DEADLINE_MS) goto L91;
            FlexibilityController.m4964$$Nest$fputmFallbackFlexibilityDeadlineMs(this.this$0, this.FALLBACK_FLEXIBILITY_DEADLINE_MS);
            return;
        L91:
            return;
        L63:
            this.DEADLINE_PROXIMITY_LIMIT_MS = properties.getLong(key, 900000);
            if (FlexibilityController.m4949$$Nest$fgetmDeadlineProximityLimitMs(this.this$0) == this.DEADLINE_PROXIMITY_LIMIT_MS) goto L93;
            FlexibilityController.m4962$$Nest$fputmDeadlineProximityLimitMs(this.this$0, this.DEADLINE_PROXIMITY_LIMIT_MS);
            this.mShouldReevaluateConstraints = true;
            return;
        L93:
            return;
        L66:
            this.MAX_RESCHEDULED_DEADLINE_MS = properties.getLong(key, 86400000);
            if (FlexibilityController.m4954$$Nest$fgetmMaxRescheduledDeadline(this.this$0) == this.MAX_RESCHEDULED_DEADLINE_MS) goto L95;
            FlexibilityController.m4968$$Nest$fputmMaxRescheduledDeadline(this.this$0, this.MAX_RESCHEDULED_DEADLINE_MS);
            this.mShouldReevaluateConstraints = true;
            return;
        L95:
            return;
        L69:
            this.RESCHEDULED_JOB_DEADLINE_MS = properties.getLong(key, 3600000);
            if (FlexibilityController.m4957$$Nest$fgetmRescheduledJobDeadline(this.this$0) == this.RESCHEDULED_JOB_DEADLINE_MS) goto L97;
            FlexibilityController.m4971$$Nest$fputmRescheduledJobDeadline(this.this$0, this.RESCHEDULED_JOB_DEADLINE_MS);
            this.mShouldReevaluateConstraints = true;
            return;
        L97:
            return;
        L72:
            this.APPLIED_CONSTRAINTS = properties.getInt(key, 0) & FlexibilityController.m4959$$Nest$fgetmSupportedFlexConstraints(this.this$0);
            if (FlexibilityController.m4948$$Nest$fgetmAppliedConstraints(this.this$0) == this.APPLIED_CONSTRAINTS) goto L99;
            FlexibilityController.m4961$$Nest$fputmAppliedConstraints(this.this$0, this.APPLIED_CONSTRAINTS);
            this.mShouldReevaluateConstraints = true;
            if (FlexibilityController.m4948$$Nest$fgetmAppliedConstraints(this.this$0) == 0) goto L77;
            FlexibilityController.m4967$$Nest$fputmFlexibilityEnabled(this.this$0, true);
            this.this$0.mPrefetchController.registerPrefetchChangedListener(this.this$0.mPrefetchChangedListener);
            SpecialAppTracker.m4986$$Nest$mstartTracking(FlexibilityController.m4958$$Nest$fgetmSpecialAppTracker(this.this$0));
            return;
        L77:
            FlexibilityController.m4967$$Nest$fputmFlexibilityEnabled(this.this$0, false);
            this.this$0.mPrefetchController.unRegisterPrefetchChangedListener(this.this$0.mPrefetchChangedListener);
            SpecialAppTracker.m4987$$Nest$mstopTracking(FlexibilityController.m4958$$Nest$fgetmSpecialAppTracker(this.this$0));
            return;
        L99:
            return;
        L101:
            return;
        L43:
            if (parsePercentToDropKeyValueString(properties.getString(key, null), this.PERCENTS_TO_DROP_FLEXIBLE_CONSTRAINTS, DEFAULT_PERCENTS_TO_DROP_FLEXIBLE_CONSTRAINTS) == false) goto L79;
            FlexibilityController.m4970$$Nest$fputmPercentsToDropConstraints(this.this$0, this.PERCENTS_TO_DROP_FLEXIBLE_CONSTRAINTS);
            this.mShouldReevaluateConstraints = true;
            return;
        L79:
            return;
        L52:
            if (parsePriorityToLongKeyValueString(properties.getString(key, null), this.FALLBACK_FLEXIBILITY_DEADLINE_ADDITIONAL_SCORE_TIME_FACTORS, DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_ADDITIONAL_SCORE_TIME_FACTORS) == false) goto L85;
            FlexibilityController.m4963$$Nest$fputmFallbackFlexibilityAdditionalScoreTimeFactors(this.this$0, this.FALLBACK_FLEXIBILITY_DEADLINE_ADDITIONAL_SCORE_TIME_FACTORS);
            this.mShouldReevaluateConstraints = true;
            return;
        L85:
            return;
        L55:
            if (parsePriorityToIntKeyValueString(properties.getString(key, null), this.FALLBACK_FLEXIBILITY_DEADLINE_SCORES, DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_SCORES) == false) goto L87;
            FlexibilityController.m4965$$Nest$fputmFallbackFlexibilityDeadlineScores(this.this$0, this.FALLBACK_FLEXIBILITY_DEADLINE_SCORES);
            this.mShouldReevaluateConstraints = true;
            return;
        L87:
            return;
        L58:
            if (parsePriorityToLongKeyValueString(properties.getString(key, null), this.FALLBACK_FLEXIBILITY_DEADLINES, DEFAULT_FALLBACK_FLEXIBILITY_DEADLINES) == false) goto L89;
            FlexibilityController.m4966$$Nest$fputmFallbackFlexibilityDeadlines(this.this$0, this.FALLBACK_FLEXIBILITY_DEADLINES);
            this.mShouldReevaluateConstraints = true;
            return;
        L89:
            return;
        L6:
            if (key.equals(KEY_FALLBACK_FLEXIBILITY_DEADLINE) == false) goto L38;
            r0 = 4;
            goto L40
        L9:
            if (key.equals(KEY_APPLIED_CONSTRAINTS) == false) goto L38;
            r0 = 0;
            goto L40
        L12:
            if (key.equals(KEY_FALLBACK_FLEXIBILITY_DEADLINE_ADDITIONAL_SCORE_TIME_FACTORS) == false) goto L38;
            r0 = 7;
            goto L40
        L15:
            if (key.equals(KEY_UNSEEN_CONSTRAINT_GRACE_PERIOD_MS) == false) goto L38;
            r0 = 9;
            goto L40
        L18:
            if (key.equals(KEY_PERCENTS_TO_DROP_FLEXIBLE_CONSTRAINTS) == false) goto L38;
            r0 = 10;
            goto L40
        L21:
            if (key.equals(KEY_DEADLINE_PROXIMITY_LIMIT) == false) goto L38;
            r0 = 3;
            goto L40
        L24:
            if (key.equals(KEY_FALLBACK_FLEXIBILITY_DEADLINES) == false) goto L38;
            r0 = 5;
            goto L40
        L27:
            if (key.equals(KEY_RESCHEDULED_JOB_DEADLINE_MS) == false) goto L38;
            r0 = 1;
            goto L40
        L30:
            if (key.equals(KEY_FALLBACK_FLEXIBILITY_DEADLINE_SCORES) == false) goto L38;
            r0 = 6;
            goto L40
        L33:
            if (key.equals(KEY_MAX_RESCHEDULED_DEADLINE_MS) == false) goto L38;
            r0 = 2;
            goto L40
        L36:
            if (key.equals(KEY_MIN_TIME_BETWEEN_FLEXIBILITY_ALARMS_MS) == false) goto L38;
            r0 = 8;
            goto L40
        }

        private boolean parsePercentToDropKeyValueString(String s, SparseArray<int[]> into, SparseArray<int[]> defaults) {
            KeyValueListParser priorityParser = new KeyValueListParser(',');
            priorityParser.setString(s);     // Catch: IllegalArgumentException -> L5
        L7:
            int[] oldMax = into.get(500);
            int[] oldHigh = into.get(400);
            int[] oldDefault = into.get(300);
            int[] oldLow = into.get(200);
            int[] oldMin = into.get(100);
            int[] newMax = parsePercentToDropString(priorityParser.getString(String.valueOf(500), null));
            int[] newHigh = parsePercentToDropString(priorityParser.getString(String.valueOf(400), null));
            int[] newDefault = parsePercentToDropString(priorityParser.getString(String.valueOf(300), null));
            int[] newLow = parsePercentToDropString(priorityParser.getString(String.valueOf(200), null));
            int[] r0 = parsePercentToDropString(priorityParser.getString(String.valueOf(100), null));
            if (newMax != null) goto L10;
            int r5 = 500;
            int[] newMin = defaults.get(500);
        L11:
            into.put(r5, newMin);
            if (newHigh != null) goto L14;
            int r1 = 400;
            int[] r6 = defaults.get(400);
        L15:
            into.put(r1, r6);
            if (newDefault != null) goto L18;
            int r2 = 300;
            int[] r7 = defaults.get(300);
        L19:
            into.put(r2, r7);
            if (newLow != null) goto L22;
            int r3 = 200;
            int[] r8 = defaults.get(200);
        L23:
            into.put(r3, r8);
            if (r0 != 0) goto L26;
            int r4 = 100;
            int[] r9 = defaults.get(100);
        L27:
            into.put(r4, r9);
            if (Arrays.equals(oldMax, into.get(500)) == true) goto L30;
        L39:
            return true;
        L30:
            if (Arrays.equals(oldHigh, into.get(400)) == false) goto L39;
            if (Arrays.equals(oldDefault, into.get(300)) == false) goto L39;
            if (Arrays.equals(oldLow, into.get(200)) == false) goto L39;
            if (Arrays.equals(oldMin, into.get(100)) == false) goto L39;
            return false;
        L26:
            r4 = 100;
            r9 = r0;
            goto L27
        L22:
            r3 = 200;
            r8 = newLow;
            goto L23
        L18:
            r2 = 300;
            r7 = newDefault;
            goto L19
        L14:
            r1 = 400;
            r6 = newHigh;
            goto L15
        L10:
            r5 = 500;
            newMin = newMax;
        L5:
            e = move-exception;
            Slog.wtf(FlexibilityController.TAG, "Bad percent to drop key value string given", e);
            priorityParser.setString(null);
            goto L7
        }

        private int[] parsePercentToDropString(String s) {
            if (s != null) goto L5;
        L28:
            return null;
        L5:
            if (s.isEmpty() == true) goto L28;
            String[] dropPercentString = s.split("\\|");
            int[] dropPercentInt = new int[Integer.bitCount(FlexibilityController.FLEXIBLE_CONSTRAINTS)];
            if (dropPercentInt.length == dropPercentString.length) goto L10;
            return null;
        L10:
            int prevPercent = 0;
            int i = 0;
        L12:
            if (i >= dropPercentString.length) goto L27;
            dropPercentInt[i] = Integer.parseInt(dropPercentString[i]);     // Catch: NumberFormatException -> L23
            if (dropPercentInt[i] < prevPercent) goto L16;
            if (dropPercentInt[i] > 100) goto L20;
            prevPercent = dropPercentInt[i];
            i = i + 1;
            goto L12
        L20:
            Slog.e(FlexibilityController.TAG, "Found % over 100");
            return null;
        L16:
            Slog.wtf(FlexibilityController.TAG, "Percents to drop constraints were not in increasing order.");
            return null;
        L23:
            ex = move-exception;
            Slog.e(FlexibilityController.TAG, "Provided string was improperly formatted.", ex);
            return null;
        L27:
            return dropPercentInt;
        }

        private boolean parsePriorityToIntKeyValueString(String s, SparseIntArray into, SparseIntArray defaults) {
            KeyValueListParser parser = new KeyValueListParser(',');
            parser.setString(s);     // Catch: IllegalArgumentException -> L5
        L7:
            int oldMax = into.get(500);
            int oldHigh = into.get(400);
            int oldDefault = into.get(300);
            int oldLow = into.get(200);
            int oldMin = into.get(100);
            int newMax = parser.getInt(String.valueOf(500), defaults.get(500));
            int newHigh = parser.getInt(String.valueOf(400), defaults.get(400));
            int newDefault = parser.getInt(String.valueOf(300), defaults.get(300));
            int newLow = parser.getInt(String.valueOf(200), defaults.get(200));
            int newMin = parser.getInt(String.valueOf(100), defaults.get(100));
            into.put(500, newMax);
            into.put(400, newHigh);
            into.put(300, newDefault);
            into.put(200, newLow);
            into.put(100, newMin);
            if (oldMax != newMax) goto L15;
            if (oldHigh != newHigh) goto L15;
            if (oldDefault != newDefault) goto L15;
            if (oldLow != newLow) goto L15;
            if (oldMin != newMin) goto L15;
            return false;
        L15:
            return true;
        L5:
            e = move-exception;
            Slog.wtf(FlexibilityController.TAG, "Bad string given", e);
            parser.setString(null);
            goto L7
        }

        private boolean parsePriorityToLongKeyValueString(String s, SparseLongArray into, SparseLongArray defaults) {
            KeyValueListParser parser = new KeyValueListParser(',');
            parser.setString(s);     // Catch: IllegalArgumentException -> L5
        L7:
            long oldMax = into.get(500);
            long oldHigh = into.get(400);
            long oldDefault = into.get(300);
            long oldLow = into.get(200);
            long oldMin = into.get(100);
            long newMax = parser.getLong(String.valueOf(500), defaults.get(500));
            long newHigh = parser.getLong(String.valueOf(400), defaults.get(400));
            long newDefault = parser.getLong(String.valueOf(300), defaults.get(300));
            long newLow = parser.getLong(String.valueOf(200), defaults.get(200));
            long newMin = parser.getLong(String.valueOf(100), defaults.get(100));
            into.put(500, newMax);
            into.put(400, newHigh);
            into.put(300, newDefault);
            into.put(200, newLow);
            into.put(100, newMin);
            if (oldMax == newMax) goto L10;
        L19:
            return true;
        L10:
            if (oldHigh != newHigh) goto L19;
            if (oldDefault != newDefault) goto L19;
            if (oldLow != newLow) goto L19;
            if (oldMin != newMin) goto L19;
            return false;
        L5:
            e = move-exception;
            Slog.wtf(FlexibilityController.TAG, "Bad string given", e);
            parser.setString(null);
            goto L7
        }

        private void dump(IndentingPrintWriter pw) {
            pw.println();
            pw.print(FlexibilityController.class.getSimpleName());
            pw.println(":");
            pw.increaseIndent();
            pw.print(KEY_APPLIED_CONSTRAINTS, Integer.valueOf(this.APPLIED_CONSTRAINTS));
            pw.print("(");
            if (this.APPLIED_CONSTRAINTS == 0) goto L5;
            JobStatus.dumpConstraints(pw, this.APPLIED_CONSTRAINTS);
        L6:
            pw.println(")");
            pw.print(KEY_DEADLINE_PROXIMITY_LIMIT, Long.valueOf(this.DEADLINE_PROXIMITY_LIMIT_MS)).println();
            pw.print(KEY_FALLBACK_FLEXIBILITY_DEADLINE, Long.valueOf(this.FALLBACK_FLEXIBILITY_DEADLINE_MS)).println();
            pw.print(KEY_FALLBACK_FLEXIBILITY_DEADLINES, this.FALLBACK_FLEXIBILITY_DEADLINES).println();
            pw.print(KEY_FALLBACK_FLEXIBILITY_DEADLINE_SCORES, this.FALLBACK_FLEXIBILITY_DEADLINE_SCORES).println();
            pw.print(KEY_FALLBACK_FLEXIBILITY_DEADLINE_ADDITIONAL_SCORE_TIME_FACTORS, this.FALLBACK_FLEXIBILITY_DEADLINE_ADDITIONAL_SCORE_TIME_FACTORS).println();
            pw.print(KEY_MIN_TIME_BETWEEN_FLEXIBILITY_ALARMS_MS, Long.valueOf(this.MIN_TIME_BETWEEN_FLEXIBILITY_ALARMS_MS)).println();
            pw.print(KEY_PERCENTS_TO_DROP_FLEXIBLE_CONSTRAINTS, this.PERCENTS_TO_DROP_FLEXIBLE_CONSTRAINTS).println();
            pw.print(KEY_RESCHEDULED_JOB_DEADLINE_MS, Long.valueOf(this.RESCHEDULED_JOB_DEADLINE_MS)).println();
            pw.print(KEY_MAX_RESCHEDULED_DEADLINE_MS, Long.valueOf(this.MAX_RESCHEDULED_DEADLINE_MS)).println();
            pw.print(KEY_UNSEEN_CONSTRAINT_GRACE_PERIOD_MS, Long.valueOf(this.UNSEEN_CONSTRAINT_GRACE_PERIOD_MS)).println();
            pw.decreaseIndent();
            return;
        L5:
            pw.print("nothing");
            goto L6
        }
    }

    private class FcHandler extends Handler {
        final /* synthetic */ FlexibilityController this$0;

        public static /* synthetic */ boolean $r8$lambda$5CvPVqmgOUfjOuy9DIWNcoGKJmo(FcHandler r0, JobStatus r1) {
            return r0.lambda$handleMessage$0(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$yWWuwRoUvOTH-mThpIBxsAo7feI, reason: not valid java name */
        public static /* synthetic */ void m4978$r8$lambda$yWWuwRoUvOTHmThpIBxsAo7feI(FcHandler r0, long r1, ArraySet r3, JobStatus r4) {
            r0.lambda$handleMessage$1(r1, r3, r4);
        }

        FcHandler(FlexibilityController r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 0: goto L36;
                case 1: goto L16;
                case 2: goto L5;
                default: goto L75;
            };
        L5:
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            final long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();     // Catch: Throwable -> L10
            final ArraySet<JobStatus> changedJobs = new ArraySet();     // Catch: Throwable -> L10
            this.this$0.mService.getJobStore().forEachJob(new FlexibilityController$FcHandler$$ExternalSyntheticLambda0(this), new FlexibilityController$FcHandler$$ExternalSyntheticLambda1(this, nowElapsed, changedJobs));     // Catch: Throwable -> L10
            FlexibilityController.m4956$$Nest$fgetmPackagesToCheck(this.this$0).clear();     // Catch: Throwable -> L10
            if (changedJobs.size() <= 0) goto L12;
            this.this$0.mStateChangedListener.onControllerStateChanged(changedJobs);     // Catch: Throwable -> L10
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        L16:
            Object r1 = this.this$0.mLock;
            monitor-enter(r1);
            long nowElapsed2 = JobSchedulerService.sElapsedRealtimeClock.millis();     // Catch: Throwable -> L23
            ArraySet<JobStatus> changedJobs2 = new ArraySet();     // Catch: Throwable -> L23
            int i = FlexibilityController.m4953$$Nest$fgetmJobsToCheck(this.this$0).size() - 1;     // Catch: Throwable -> L23
        L19:
            if (i < 0) goto L29;
            JobStatus js = (JobStatus) FlexibilityController.m4953$$Nest$fgetmJobsToCheck(this.this$0).valueAt(i);     // Catch: Throwable -> L23
            if (FlexibilityController.m4974$$Nest$sfgetDEBUG() == false) goto L26;
            Slog.d(FlexibilityController.TAG, "Checking on " + js.toShortString());     // Catch: Throwable -> L23
        L26:
            if (js.setFlexibilityConstraintSatisfied(nowElapsed2, this.this$0.isFlexibilitySatisfiedLocked(js)) == false) goto L28;
            changedJobs2.add(js);     // Catch: Throwable -> L23
        L28:
            i = i - 1;     // Catch: Throwable -> L23
            goto L19
        L29:
            FlexibilityController.m4953$$Nest$fgetmJobsToCheck(this.this$0).clear();     // Catch: Throwable -> L23
            if (changedJobs2.size() <= 0) goto L32;
            this.this$0.mStateChangedListener.onControllerStateChanged(changedJobs2);     // Catch: Throwable -> L23
        L32:
            monitor-exit(r1);     // Catch: Throwable -> L23
            return;
        L23:
            th = move-exception;
            throw th;
        L36:
            removeMessages(0);
            Object r2 = this.this$0.mLock;
            monitor-enter(r2);
            FlexibilityController.m4953$$Nest$fgetmJobsToCheck(this.this$0).clear();     // Catch: Throwable -> L48
            FlexibilityController.m4956$$Nest$fgetmPackagesToCheck(this.this$0).clear();     // Catch: Throwable -> L48
            long nowElapsed3 = JobSchedulerService.sElapsedRealtimeClock.millis();     // Catch: Throwable -> L48
            ArraySet<JobStatus> changedJobs3 = new ArraySet();     // Catch: Throwable -> L48
            int numAppliedSystemWideConstraints = Integer.bitCount(FlexibilityController.m4948$$Nest$fgetmAppliedConstraints(this.this$0) & 7);     // Catch: Throwable -> L48
            int o = 0;
        L39:
            if (o > numAppliedSystemWideConstraints) goto L52;
            ArraySet<JobStatus> jobsByNumConstraints = this.this$0.mFlexibilityTracker.getJobsByNumRequiredConstraints(o);     // Catch: Throwable -> L48
            if (jobsByNumConstraints == null) goto L51;
            int i2 = 0;
        L44:
            if (i2 >= jobsByNumConstraints.size()) goto L51;
            JobStatus js2 = jobsByNumConstraints.valueAt(i2);     // Catch: Throwable -> L48
            if (js2.setFlexibilityConstraintSatisfied(nowElapsed3, this.this$0.isFlexibilitySatisfiedLocked(js2)) == false) goto L50;
            changedJobs3.add(js2);     // Catch: Throwable -> L48
        L50:
            i2 = i2 + 1;     // Catch: Throwable -> L48
        L51:
            o = o + 1;     // Catch: Throwable -> L48
            goto L39
        L52:
            int o2 = changedJobs3.size();     // Catch: Throwable -> L48
            if (o2 <= 0) goto L55;
            this.this$0.mStateChangedListener.onControllerStateChanged(changedJobs3);     // Catch: Throwable -> L48
        L55:
            monitor-exit(r2);     // Catch: Throwable -> L48
            return;
        L48:
            th = move-exception;
            throw th;
        }

        private /* synthetic */ boolean lambda$handleMessage$0(JobStatus js) {
            if (FlexibilityController.m4956$$Nest$fgetmPackagesToCheck(this.this$0).contains(js.getSourcePackageName()) == false) goto L5;
        L8:
            return true;
        L5:
            if (FlexibilityController.m4956$$Nest$fgetmPackagesToCheck(this.this$0).contains(js.getCallingPackageName()) == true) goto L8;
            return false;
        }

        private /* synthetic */ void lambda$handleMessage$1(long nowElapsed, ArraySet changedJobs, JobStatus js) {
            if (FlexibilityController.m4974$$Nest$sfgetDEBUG() == false) goto L6;
            Slog.d(FlexibilityController.TAG, "Checking on " + js.toShortString());
        L6:
            if (js.setFlexibilityConstraintSatisfied(nowElapsed, this.this$0.isFlexibilitySatisfiedLocked(js)) == false) goto L9;
            changedJobs.add(js);
            return;
        }
    }

    class FlexibilityAlarmQueue extends AlarmQueue<JobStatus> {
        final /* synthetic */ FlexibilityController this$0;

        /* synthetic */ FlexibilityAlarmQueue(FlexibilityController r1, Context r2, Looper r3, FlexibilityControllerIA r4) {
            this(r1, r2, r3);
        }

        @Override // com.android.server.utils.AlarmQueue
        protected /* bridge */ /* synthetic */ boolean isForUser(JobStatus r1, int r2) {
            return isForUser2(r1, r2);
        }

        private FlexibilityAlarmQueue(FlexibilityController this$0, Context context, Looper looper) {
            this.this$0 = this$0;
            super(context, looper, "*job.flexibility_check*", "Flexible Constraint Check", true, FlexibilityController.m4955$$Nest$fgetmMinTimeBetweenFlexibilityAlarmsMs(this$0));
        }

        /* JADX INFO: renamed from: isForUser, reason: avoid collision after fix types in other method */
        protected boolean isForUser2(JobStatus js, int userId) {
            if (js.getSourceUserId() != userId) goto L5;
            return true;
        L5:
            return false;
        }

        public void scheduleDropNumConstraintsAlarm(JobStatus js, long nowElapsed) {
            Object r8 = this.this$0.mLock;
            monitor-enter(r8);
            long earliest = this.this$0.getLifeCycleBeginningElapsedLocked(js);     // Catch: Throwable -> L43
            long latest = this.this$0.getLifeCycleEndElapsedLocked(js, nowElapsed, earliest);     // Catch: Throwable -> L41
            if (latest > earliest) goto L14;
            Slog.wtf(FlexibilityController.TAG, "Got invalid latest when scheduling alarm. prefetch=" + js.getJob().isPrefetch() + " periodic=" + js.getJob().isPeriodic());     // Catch: Throwable -> L12
            this.this$0.mFlexibilityTracker.setNumDroppedFlexibleConstraints(js, js.getNumAppliedFlexibleConstraints());     // Catch: Throwable -> L12
            FlexibilityController.m4953$$Nest$fgetmJobsToCheck(this.this$0).add(js);     // Catch: Throwable -> L12
            FlexibilityController.m4952$$Nest$fgetmHandler(this.this$0).sendEmptyMessage(1);     // Catch: Throwable -> L12
            monitor-exit(r8);     // Catch: Throwable -> L12
            return;
        L14:
            long nextTimeElapsed = this.this$0.getNextConstraintDropTimeElapsedLocked(js, earliest, latest);     // Catch: Throwable -> L12
            if (FlexibilityController.m4974$$Nest$sfgetDEBUG() == false) goto L18;
            Slog.d(FlexibilityController.TAG, "scheduleDropNumConstraintsAlarm: " + js.toShortString() + " numApplied: " + js.getNumAppliedFlexibleConstraints() + " numRequired: " + js.getNumRequiredFlexibleConstraints() + " numSatisfied: " + Integer.bitCount(this.this$0.mSatisfiedFlexibleConstraints & this.this$0.getRelevantAppliedConstraintsLocked(js)) + " curTime: " + nowElapsed + " earliest: " + earliest + " latest: " + latest + " nextTime: " + nextTimeElapsed);     // Catch: Throwable -> L12
        L18:
            if ((latest - nowElapsed) >= FlexibilityController.m4949$$Nest$fgetmDeadlineProximityLimitMs(this.this$0)) goto L26;
            if (FlexibilityController.m4974$$Nest$sfgetDEBUG() == false) goto L22;
            Slog.d(FlexibilityController.TAG, "deadline proximity met: " + js);     // Catch: Throwable -> L12
        L22:
            this.this$0.mFlexibilityTracker.setNumDroppedFlexibleConstraints(js, js.getNumAppliedFlexibleConstraints());     // Catch: Throwable -> L12
            FlexibilityController.m4953$$Nest$fgetmJobsToCheck(this.this$0).add(js);     // Catch: Throwable -> L12
            FlexibilityController.m4952$$Nest$fgetmHandler(this.this$0).sendEmptyMessage(1);     // Catch: Throwable -> L12
            monitor-exit(r8);     // Catch: Throwable -> L12
            return;
        L26:
            if (nextTimeElapsed != Long.MAX_VALUE) goto L31;
            removeAlarmForKey(js);     // Catch: Throwable -> L12
            monitor-exit(r8);     // Catch: Throwable -> L12
            return;
        L31:
            if ((latest - nextTimeElapsed) <= FlexibilityController.m4949$$Nest$fgetmDeadlineProximityLimitMs(this.this$0)) goto L33;
            addAlarm(js, nextTimeElapsed);     // Catch: Throwable -> L12
            monitor-exit(r8);     // Catch: Throwable -> L12
            return;
        L33:
            if (FlexibilityController.m4974$$Nest$sfgetDEBUG() == false) goto L35;
            Slog.d(FlexibilityController.TAG, "last alarm set: " + js);     // Catch: Throwable -> L12
        L35:
            addAlarm(js, latest - FlexibilityController.m4949$$Nest$fgetmDeadlineProximityLimitMs(this.this$0));     // Catch: Throwable -> L12
            monitor-exit(r8);     // Catch: Throwable -> L12
            return;
        L41:
            th = th;
        L45:
            monitor-exit(r8);     // Catch: Throwable -> L12
            throw th;
        L43:
            th = th;
        L12:
            th = th;
            goto L45
        }

        @Override // com.android.server.utils.AlarmQueue
        protected void processExpiredAlarms(ArraySet<JobStatus> expired) {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
            ArraySet<JobStatus> changedJobs = new ArraySet();     // Catch: Throwable -> L10
            long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();     // Catch: Throwable -> L10
            int i = 0;
        L6:
            if (i >= expired.size()) goto L19;
            JobStatus js = expired.valueAt(i);     // Catch: Throwable -> L10
            if (FlexibilityController.m4974$$Nest$sfgetDEBUG() == false) goto L12;
            Slog.d(FlexibilityController.TAG, "Alarm fired for " + js.toShortString());     // Catch: Throwable -> L10
        L12:
            this.this$0.mFlexibilityTracker.calculateNumDroppedConstraints(js, nowElapsed);     // Catch: Throwable -> L10
            if (js.getNumRequiredFlexibleConstraints() <= 0) goto L16;
            scheduleDropNumConstraintsAlarm(js, nowElapsed);     // Catch: Throwable -> L10
        L16:
            if (js.setFlexibilityConstraintSatisfied(nowElapsed, this.this$0.isFlexibilitySatisfiedLocked(js)) == false) goto L18;
            changedJobs.add(js);     // Catch: Throwable -> L10
        L18:
            i = i + 1;     // Catch: Throwable -> L10
            goto L6
        L19:
            this.this$0.mStateChangedListener.onControllerStateChanged(changedJobs);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    class FlexibilityTracker {
        final ArrayList<ArraySet<JobStatus>> mTrackedJobs;
        final /* synthetic */ FlexibilityController this$0;

        FlexibilityTracker(FlexibilityController this$0, int numFlexibleConstraints) {
            this.this$0 = this$0;
            this.mTrackedJobs = new ArrayList();
            int i = 0;
        L3:
            if (i > numFlexibleConstraints) goto L6;
            this.mTrackedJobs.add(new ArraySet());
            i = i + 1;
            goto L3
        }

        public ArraySet<JobStatus> getJobsByNumRequiredConstraints(int numRequired) {
            if (numRequired <= this.mTrackedJobs.size()) goto L7;
            Slog.wtfStack(FlexibilityController.TAG, "Asked for a larger number of constraints than exists.");
            return null;
        L7:
            return this.mTrackedJobs.get(numRequired);
        }

        public void add(JobStatus js) {
            if (js.getNumRequiredFlexibleConstraints() >= 0) goto L5;
            return;
        L5:
            this.mTrackedJobs.get(js.getNumRequiredFlexibleConstraints()).add(js);
        }

        public void remove(JobStatus js) {
            this.mTrackedJobs.get(js.getNumRequiredFlexibleConstraints()).remove(js);
        }

        public void updateFlexibleConstraints(JobStatus js, long nowElapsed) {
            int prevNumRequired = js.getNumRequiredFlexibleConstraints();
            int numAppliedConstraints = Integer.bitCount(this.this$0.getRelevantAppliedConstraintsLocked(js));
            js.setNumAppliedFlexibleConstraints(numAppliedConstraints);
            int[] percentsToDropConstraints = FlexibilityController.m4973$$Nest$mgetPercentsToDropConstraints(this.this$0, js.getEffectivePriority());
            int curPercent = this.this$0.getCurPercentOfLifecycleLocked(js, nowElapsed);
            int toDrop = 0;
            int i = 0;
        L3:
            if (i >= numAppliedConstraints) goto L8;
            if (curPercent < percentsToDropConstraints[i]) goto L7;
            toDrop = toDrop + 1;
        L7:
            i = i + 1;
            goto L3
        L8:
            js.setNumDroppedFlexibleConstraints(toDrop);
            if (prevNumRequired != js.getNumRequiredFlexibleConstraints()) goto L11;
            return;
        L11:
            this.mTrackedJobs.get(prevNumRequired).remove(js);
            add(js);
        }

        public void calculateNumDroppedConstraints(JobStatus js, long nowElapsed) {
            int curPercent = this.this$0.getCurPercentOfLifecycleLocked(js, nowElapsed);
            int toDrop = 0;
            int jsMaxFlexibleConstraints = js.getNumAppliedFlexibleConstraints();
            int[] percentsToDropConstraints = FlexibilityController.m4973$$Nest$mgetPercentsToDropConstraints(this.this$0, js.getEffectivePriority());
            int i = 0;
        L3:
            if (i >= jsMaxFlexibleConstraints) goto L8;
            if (curPercent < percentsToDropConstraints[i]) goto L7;
            toDrop = toDrop + 1;
        L7:
            i = i + 1;
            goto L3
        L8:
            setNumDroppedFlexibleConstraints(js, toDrop);
        }

        public ArrayList<ArraySet<JobStatus>> getArrayList() {
            return this.mTrackedJobs;
        }

        public void setNumDroppedFlexibleConstraints(JobStatus js, int numDropped) {
            if (numDropped == js.getNumDroppedFlexibleConstraints()) goto L6;
            remove(js);
            js.setNumDroppedFlexibleConstraints(numDropped);
            add(js);
            return;
        }

        public int size() {
            return this.mTrackedJobs.size();
        }

        public void dump(IndentingPrintWriter pw, Predicate<JobStatus> predicate, long nowElapsed) {
            int i = 0;
        L4:
            if (i >= this.mTrackedJobs.size()) goto L15;
            ArraySet<JobStatus> jobs = this.mTrackedJobs.get(i);
            int j = 0;
        L7:
            if (j >= jobs.size()) goto L13;
            JobStatus js = jobs.valueAt(j);
            if (predicate.test(js) == true) goto L11;
            long nowElapsed2 = nowElapsed;
        L12:
            j = j + 1;
            nowElapsed = nowElapsed2;
            goto L7
        L11:
            js.printUniqueId(pw);
            pw.print(" from ");
            UserHandle.formatUid(pw, js.getSourceUid());
            pw.print("-> Num Required Constraints: ");
            pw.print(js.getNumRequiredFlexibleConstraints());
            pw.print(", lifecycle=[");
            long earliest = this.this$0.getLifeCycleBeginningElapsedLocked(js);
            pw.print(earliest);
            pw.print(", (");
            pw.print(this.this$0.getCurPercentOfLifecycleLocked(js, nowElapsed));
            pw.print("%), ");
            nowElapsed2 = nowElapsed;
            pw.print(this.this$0.getLifeCycleEndElapsedLocked(js, nowElapsed2, earliest));
            pw.print("]");
            pw.println();
            goto L12
        L13:
            i = i + 1;
            goto L4
        }
    }

    private static class JobScoreTracker {
        private static final long MAX_TIME_WINDOW_MS = 86400000;
        private static final int NUM_SCORE_BUCKETS = 24;
        private int mCachedScore;
        private long mCachedScoreExpirationTimeElapsed;
        private int mScoreBucketIndex;
        private final JobScoreBucket[] mScoreBuckets;

        private static class JobScoreBucket {
            public int score;
            public long startTimeElapsed;

            /* JADX INFO: renamed from: -$$Nest$mreset, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m4979$$Nest$mreset(JobScoreBucket r0) {
                r0.reset();
            }

            /* synthetic */ JobScoreBucket(FlexibilityControllerIA r1) {
                this();
            }

            private JobScoreBucket() {
            }

            private void reset() {
                this.startTimeElapsed = 0;
                this.score = 0;
            }
        }

        /* synthetic */ JobScoreTracker(FlexibilityControllerIA r1) {
            this();
        }

        private JobScoreTracker() {
            this.mScoreBuckets = new JobScoreBucket[24];
            this.mScoreBucketIndex = 0;
        }

        public void addScore(int add, long nowElapsed) {
            JobScoreBucket bucket = this.mScoreBuckets[this.mScoreBucketIndex];
            if (bucket != null) goto L6;
            bucket = new JobScoreBucket(null);
            bucket.startTimeElapsed = nowElapsed;
            this.mScoreBuckets[this.mScoreBucketIndex] = bucket;
            this.mCachedScoreExpirationTimeElapsed = Math.min(this.mCachedScoreExpirationTimeElapsed, 86400000 + nowElapsed);
        L12:
            bucket.score += add;
            this.mCachedScore += add;
            return;
        L6:
            if (bucket.startTimeElapsed >= (nowElapsed - 86400000)) goto L9;
            JobScoreBucket.m4979$$Nest$mreset(bucket);
            bucket.startTimeElapsed = nowElapsed;
            this.mCachedScoreExpirationTimeElapsed = nowElapsed;
            goto L12
        L9:
            if (bucket.startTimeElapsed >= (nowElapsed - 3600000)) goto L12;
            this.mScoreBucketIndex = (this.mScoreBucketIndex + 1) % 24;
            addScore(add, nowElapsed);
        }

        public int getScore(long nowElapsed) {
            if (nowElapsed < this.mCachedScoreExpirationTimeElapsed) goto L5;
            int score = 0;
            long earliestElapsed = nowElapsed - 86400000;
            long earliestValidBucketTimeElapsed = Long.MAX_VALUE;
            JobScoreBucket[] r7 = this.mScoreBuckets;
            int r8 = r7.length;
            int r9 = 0;
        L7:
            if (r9 >= r8) goto L16;
            JobScoreBucket bucket = r7[r9];
            if (bucket == null) goto L15;
            if (bucket.startTimeElapsed < earliestElapsed) goto L15;
            score = score + bucket.score;
            if (earliestValidBucketTimeElapsed <= bucket.startTimeElapsed) goto L15;
            earliestValidBucketTimeElapsed = bucket.startTimeElapsed;
        L15:
            r9 = r9 + 1;
            goto L7
        L16:
            this.mCachedScore = score;
            this.mCachedScoreExpirationTimeElapsed = 86400000 + earliestValidBucketTimeElapsed;
            return score;
        L5:
            return this.mCachedScore;
        }

        public void dump(IndentingPrintWriter pw, long nowElapsed) {
            pw.print("{");
            boolean printed = false;
            int x = 0;
        L4:
            if (x >= this.mScoreBuckets.length) goto L14;
            int idx = ((this.mScoreBucketIndex + 1) + x) % this.mScoreBuckets.length;
            JobScoreBucket jsb = this.mScoreBuckets[idx];
            if (jsb == null) goto L13;
            if (jsb.startTimeElapsed == 0) goto L13;
            if (printed == false) goto L12;
            pw.print(", ");
        L12:
            TimeUtils.formatDuration(jsb.startTimeElapsed, nowElapsed, pw);
            pw.print("=");
            pw.print(jsb.score);
            printed = true;
        L13:
            x = x + 1;
            goto L4
        L14:
            pw.print("}");
        }
    }

    private class SpecialAppTracker {
        private final BroadcastReceiver mBroadcastReceiver;
        private final SparseSetArray<String> mCarrierPrivilegedApps;
        private final SparseArray<LogicalIndexCarrierPrivilegesCallback> mCarrierPrivilegedCallbacks;
        private DeviceIdleInternal mDeviceIdleInternal;
        private final boolean mHasFeatureTelephonySubscription;
        private final ArraySet<String> mPowerAllowlistedApps;
        private final Object mSatLock;
        private final SparseSetArray<String> mSpecialApps;
        private TelephonyManager mTelephonyManager;
        final /* synthetic */ FlexibilityController this$0;

        /* JADX INFO: renamed from: com.android.server.job.controllers.FlexibilityController$SpecialAppTracker$1, reason: invalid class name */
        class AnonymousClass1 extends BroadcastReceiver {
            final /* synthetic */ SpecialAppTracker this$1;

            /* JADX INFO: renamed from: $r8$lambda$Hgjj75vw81McR-idN_pmXrZVdXg, reason: not valid java name */
            public static /* synthetic */ void m4991$r8$lambda$Hgjj75vw81McRidN_pmXrZVdXg(SpecialAppTracker r0) {
                SpecialAppTracker.m4989$$Nest$mupdatePowerAllowlistCache(r0);
            }

            AnonymousClass1(SpecialAppTracker this$1) {
                this.this$1 = this$1;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String r0 = intent.getAction();
                switch(r0.hashCode()) {
                    case -65633567: goto L9;
                    case 1093296680: goto L6;
                    default: goto L11;
                };
            L11:
                byte r1 = -1;
            L12:
                switch(r1) {
                    case 0: goto L15;
                    case 1: goto L14;
                    default: goto L18;
                };
            L14:
                FcHandler r2 = FlexibilityController.m4952$$Nest$fgetmHandler(this.this$1.this$0);
                final SpecialAppTracker r3 = this.this$1;
                r2.post(new FlexibilityController$SpecialAppTracker$1$$ExternalSyntheticLambda0(r3));
                return;
            L15:
                SpecialAppTracker.m4988$$Nest$mupdateCarrierPrivilegedCallbackRegistration(this.this$1);
                return;
            L18:
                return;
            L6:
                if (r0.equals("android.telephony.action.MULTI_SIM_CONFIG_CHANGED") == false) goto L11;
                r1 = 0;
                goto L12
            L9:
                if (r0.equals("android.os.action.POWER_SAVE_WHITELIST_CHANGED") == false) goto L11;
                r1 = 1;
                goto L12
            }
        }

        class LogicalIndexCarrierPrivilegesCallback implements TelephonyManager.CarrierPrivilegesCallback {
            public final int logicalIndex;
            final /* synthetic */ SpecialAppTracker this$1;

            LogicalIndexCarrierPrivilegesCallback(SpecialAppTracker this$1, int logicalIndex) {
                this.this$1 = this$1;
                this.logicalIndex = logicalIndex;
            }

            public void onCarrierPrivilegesChanged(Set<String> privilegedPackageNames, Set<Integer> privilegedUids) {
                ArraySet<String> changedPkgs = new ArraySet();
                Object r1 = SpecialAppTracker.m4982$$Nest$fgetmSatLock(this.this$1);
                monitor-enter(r1);
                ArraySet<String> oldPrivilegedSet = SpecialAppTracker.m4981$$Nest$fgetmCarrierPrivilegedApps(this.this$1).get(this.logicalIndex);     // Catch: Throwable -> L7
                if (oldPrivilegedSet == null) goto L9;
                changedPkgs.addAll(oldPrivilegedSet);     // Catch: Throwable -> L7
                SpecialAppTracker.m4981$$Nest$fgetmCarrierPrivilegedApps(this.this$1).remove(this.logicalIndex);     // Catch: Throwable -> L7
            L9:
                Iterator<String> r3 = privilegedPackageNames.iterator();     // Catch: Throwable -> L7
            L11:
                if (r3.hasNext() == false) goto L16;
                String pkgName = r3.next();     // Catch: Throwable -> L7
                SpecialAppTracker.m4981$$Nest$fgetmCarrierPrivilegedApps(this.this$1).add(this.logicalIndex, pkgName);     // Catch: Throwable -> L7
                if (changedPkgs.remove(pkgName) == true) goto L11;
                changedPkgs.add(pkgName);     // Catch: Throwable -> L7
                goto L11
            L16:
                monitor-exit(r1);     // Catch: Throwable -> L7
                SpecialAppTracker.m4990$$Nest$mupdateSpecialAppSetUnlocked(this.this$1, -1, changedPkgs);
                return;
            L7:
                th = move-exception;
                throw th;
            }
        }

        /* JADX INFO: renamed from: $r8$lambda$Hgjj75vw81McR-idN_pmXrZVdXg, reason: not valid java name */
        public static /* synthetic */ void m4980$r8$lambda$Hgjj75vw81McRidN_pmXrZVdXg(SpecialAppTracker r0) {
            r0.updatePowerAllowlistCache();
        }

        public static /* synthetic */ void $r8$lambda$ua4qG40yzc13AARwXkAlGGgPDk0(SpecialAppTracker r0) {
            r0.updateCarrierPrivilegedCallbackRegistration();
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCarrierPrivilegedApps, reason: not valid java name */
        static /* bridge */ /* synthetic */ SparseSetArray m4981$$Nest$fgetmCarrierPrivilegedApps(SpecialAppTracker r0) {
            return r0.mCarrierPrivilegedApps;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSatLock, reason: not valid java name */
        static /* bridge */ /* synthetic */ Object m4982$$Nest$fgetmSatLock(SpecialAppTracker r0) {
            return r0.mSatLock;
        }

        /* JADX INFO: renamed from: -$$Nest$monAppRemoved, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4983$$Nest$monAppRemoved(SpecialAppTracker r0, int r1, String r2) {
            r0.onAppRemoved(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$monSystemServicesReady, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4984$$Nest$monSystemServicesReady(SpecialAppTracker r0) {
            r0.onSystemServicesReady();
        }

        /* JADX INFO: renamed from: -$$Nest$monUserRemoved, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4985$$Nest$monUserRemoved(SpecialAppTracker r0, int r1) {
            r0.onUserRemoved(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mstartTracking, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4986$$Nest$mstartTracking(SpecialAppTracker r0) {
            r0.startTracking();
        }

        /* JADX INFO: renamed from: -$$Nest$mstopTracking, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4987$$Nest$mstopTracking(SpecialAppTracker r0) {
            r0.stopTracking();
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateCarrierPrivilegedCallbackRegistration, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4988$$Nest$mupdateCarrierPrivilegedCallbackRegistration(SpecialAppTracker r0) {
            r0.updateCarrierPrivilegedCallbackRegistration();
        }

        /* JADX INFO: renamed from: -$$Nest$mupdatePowerAllowlistCache, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4989$$Nest$mupdatePowerAllowlistCache(SpecialAppTracker r0) {
            r0.updatePowerAllowlistCache();
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateSpecialAppSetUnlocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4990$$Nest$mupdateSpecialAppSetUnlocked(SpecialAppTracker r0, int r1, ArraySet r2) {
            r0.updateSpecialAppSetUnlocked(r1, r2);
        }

        SpecialAppTracker(FlexibilityController r2) {
            this.this$0 = r2;
            this.mSatLock = new Object();
            this.mSpecialApps = new SparseSetArray();
            this.mCarrierPrivilegedApps = new SparseSetArray();
            this.mCarrierPrivilegedCallbacks = new SparseArray();
            this.mPowerAllowlistedApps = new ArraySet();
            this.mBroadcastReceiver = new AnonymousClass1(this);
            this.mHasFeatureTelephonySubscription = r2.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.subscription");
        }

        public boolean isSpecialApp(int userId, String packageName) {
            Object r0 = this.mSatLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mSpecialApps.contains(-1, packageName) == false) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return true;
        L11:
            if (this.mSpecialApps.contains(userId, packageName) == false) goto L14;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return true;
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return false;
        }

        private boolean isSpecialAppInternal(int userId, String packageName) {
            Object r0 = this.mSatLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mPowerAllowlistedApps.contains(packageName) == false) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return true;
        L10:
            int l = this.mCarrierPrivilegedApps.size() - 1;     // Catch: Throwable -> L8
        L11:
            if (l < 0) goto L18;
            if (this.mCarrierPrivilegedApps.contains(this.mCarrierPrivilegedApps.keyAt(l), packageName) == true) goto L14;
            l = l - 1;     // Catch: Throwable -> L8
            goto L11
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return true;
        L18:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return false;
        }

        private void onAppRemoved(int userId, String packageName) {
            Object r0 = this.mSatLock;
            monitor-enter(r0);
            this.mSpecialApps.remove(userId, packageName);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void onSystemServicesReady() {
            this.mDeviceIdleInternal = (DeviceIdleInternal) LocalServices.getService(DeviceIdleInternal.class);
            this.mTelephonyManager = (TelephonyManager) this.this$0.mContext.getSystemService(TelephonyManager.class);
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (FlexibilityController.m4951$$Nest$fgetmFlexibilityEnabled(this.this$0) == false) goto L9;
            FlexibilityController.m4952$$Nest$fgetmHandler(this.this$0).post(new FlexibilityController$SpecialAppTracker$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L7
            FlexibilityController.m4952$$Nest$fgetmHandler(this.this$0).post(new FlexibilityController$SpecialAppTracker$$ExternalSyntheticLambda1(this));     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        private void onUserRemoved(int userId) {
            Object r0 = this.mSatLock;
            monitor-enter(r0);
            this.mSpecialApps.remove(userId);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void startTracking() {
            IntentFilter filter = new IntentFilter("android.os.action.POWER_SAVE_WHITELIST_CHANGED");
            if (this.mHasFeatureTelephonySubscription == false) goto L5;
            filter.addAction("android.telephony.action.MULTI_SIM_CONFIG_CHANGED");
            updateCarrierPrivilegedCallbackRegistration();
        L5:
            this.this$0.mContext.registerReceiver(this.mBroadcastReceiver, filter);
            updatePowerAllowlistCache();
        }

        private void stopTracking() {
            this.this$0.mContext.unregisterReceiver(this.mBroadcastReceiver);
            Object r0 = this.mSatLock;
            monitor-enter(r0);
            this.mCarrierPrivilegedApps.clear();     // Catch: Throwable -> L7
            this.mPowerAllowlistedApps.clear();     // Catch: Throwable -> L7
            this.mSpecialApps.clear();     // Catch: Throwable -> L7
            int i = this.mCarrierPrivilegedCallbacks.size() - 1;     // Catch: Throwable -> L7
        L5:
            if (i < 0) goto L9;
            this.mTelephonyManager.unregisterCarrierPrivilegesCallback(this.mCarrierPrivilegedCallbacks.valueAt(i));     // Catch: Throwable -> L7
            i = i - 1;     // Catch: Throwable -> L7
            goto L5
        L9:
            this.mCarrierPrivilegedCallbacks.clear();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void updateCarrierPrivilegedCallbackRegistration() {
            if (this.mTelephonyManager != null) goto L6;
            return;
        L6:
            if (this.mHasFeatureTelephonySubscription == true) goto L8;
            return;
        L8:
            Collection<UiccSlotMapping> simSlotMapping = this.mTelephonyManager.getSimSlotMapping();
            ArraySet<String> changedPkgs = new ArraySet();
            Object r2 = this.mSatLock;
            monitor-enter(r2);
            IntArray callbacksToRemove = new IntArray();     // Catch: Throwable -> L13
            int i = this.mCarrierPrivilegedCallbacks.size() - 1;     // Catch: Throwable -> L13
        L11:
            if (i < 0) goto L15;
            callbacksToRemove.add(this.mCarrierPrivilegedCallbacks.keyAt(i));     // Catch: Throwable -> L13
            i = i - 1;     // Catch: Throwable -> L13
            goto L11
        L15:
            Iterator<UiccSlotMapping> r4 = simSlotMapping.iterator();     // Catch: Throwable -> L13
        L17:
            if (r4.hasNext() == false) goto L28;
            UiccSlotMapping mapping = r4.next();     // Catch: Throwable -> L13
            int logicalIndex = mapping.getLogicalSlotIndex();     // Catch: Throwable -> L13
            if (this.mCarrierPrivilegedCallbacks.contains(logicalIndex) == true) goto L20;
            LogicalIndexCarrierPrivilegesCallback callback = new LogicalIndexCarrierPrivilegesCallback(this, logicalIndex);     // Catch: Throwable -> L13
            this.mCarrierPrivilegedCallbacks.put(logicalIndex, callback);     // Catch: Throwable -> L13
            this.mTelephonyManager.registerCarrierPrivilegesCallback(logicalIndex, AppSchedulingModuleThread.getExecutor(), callback);     // Catch: Throwable -> L13
            goto L17
        L20:
            int i2 = callbacksToRemove.size() - 1;     // Catch: Throwable -> L13
        L21:
            if (i2 < 0) goto L17;
            if (callbacksToRemove.get(i2) == logicalIndex) goto L24;
            i2 = i2 - 1;     // Catch: Throwable -> L13
            goto L21
        L24:
            callbacksToRemove.remove(i2);     // Catch: Throwable -> L13
            goto L17
        L28:
            int i3 = callbacksToRemove.size() - 1;     // Catch: Throwable -> L13
        L29:
            if (i3 < 0) goto L32;
            int logicalIndex2 = callbacksToRemove.get(i3);     // Catch: Throwable -> L13
            this.mTelephonyManager.unregisterCarrierPrivilegesCallback(this.mCarrierPrivilegedCallbacks.get(logicalIndex2));     // Catch: Throwable -> L13
            this.mCarrierPrivilegedCallbacks.remove(logicalIndex2);     // Catch: Throwable -> L13
            changedPkgs.addAll(this.mCarrierPrivilegedApps.get(logicalIndex2));     // Catch: Throwable -> L13
            this.mCarrierPrivilegedApps.remove(logicalIndex2);     // Catch: Throwable -> L13
            i3 = i3 - 1;     // Catch: Throwable -> L13
            goto L29
        L32:
            monitor-exit(r2);     // Catch: Throwable -> L13
            updateSpecialAppSetUnlocked(-1, changedPkgs);
            return;
        L13:
            th = move-exception;
            throw th;
        }

        private void updateSpecialAppSetUnlocked(int userId, ArraySet<String> pkgs) {
            if (Thread.holdsLock(this.mSatLock) == true) goto L38;
            if (pkgs.size() != 0) goto L7;
            return;
        L7:
            ArraySet<String> changedPkgs = new ArraySet();
            Object r1 = this.mSatLock;
            monitor-enter(r1);
            int i = pkgs.size() - 1;     // Catch: Throwable -> L16
        L10:
            if (i < 0) goto L23;
            String pkgName = pkgs.valueAt(i);     // Catch: Throwable -> L16
            if (isSpecialAppInternal(userId, pkgName) == false) goto L19;
            if (this.mSpecialApps.add(userId, pkgName) == false) goto L21;
            changedPkgs.add(pkgName);     // Catch: Throwable -> L16
        L21:
            i = i - 1;     // Catch: Throwable -> L16
            goto L10
        L19:
            if (this.mSpecialApps.remove(userId, pkgName) == false) goto L21;
            changedPkgs.add(pkgName);     // Catch: Throwable -> L16
            goto L21
        L23:
            monitor-exit(r1);     // Catch: Throwable -> L16
            if (changedPkgs.size() <= 0) goto L34;
            Object r2 = this.this$0.mLock;
            monitor-enter(r2);
            FlexibilityController.m4956$$Nest$fgetmPackagesToCheck(this.this$0).addAll(changedPkgs);     // Catch: Throwable -> L31
            FlexibilityController.m4952$$Nest$fgetmHandler(this.this$0).sendEmptyMessage(2);     // Catch: Throwable -> L31
            monitor-exit(r2);     // Catch: Throwable -> L31
            return;
        L31:
            th = move-exception;
            throw th;
        L34:
            return;
        L16:
            th = move-exception;
            throw th;
        L38:
            throw new IllegalStateException("Must never hold local mSatLock");
        }

        private void updatePowerAllowlistCache() {
            if (this.mDeviceIdleInternal != null) goto L5;
            return;
        L5:
            String[] allowlistedPkgs = this.mDeviceIdleInternal.getFullPowerWhitelistExceptIdle();
            ArraySet<String> changedPkgs = new ArraySet();
            Object r2 = this.mSatLock;
            monitor-enter(r2);
            changedPkgs.addAll(this.mPowerAllowlistedApps);     // Catch: Throwable -> L12
            this.mPowerAllowlistedApps.clear();     // Catch: Throwable -> L12
            int r3 = allowlistedPkgs.length;     // Catch: Throwable -> L12
            int r4 = 0;
        L8:
            if (r4 >= r3) goto L15;
            String pkgName = allowlistedPkgs[r4];     // Catch: Throwable -> L12
            this.mPowerAllowlistedApps.add(pkgName);     // Catch: Throwable -> L12
            if (changedPkgs.remove(pkgName) == true) goto L14;
            changedPkgs.add(pkgName);     // Catch: Throwable -> L12
        L14:
            r4 = r4 + 1;     // Catch: Throwable -> L12
            goto L8
        L15:
            monitor-exit(r2);     // Catch: Throwable -> L12
            updateSpecialAppSetUnlocked(-1, changedPkgs);
            return;
        L12:
            th = move-exception;
            throw th;
        }

        public void dump(IndentingPrintWriter pw) {
            pw.println("Special apps:");
            pw.increaseIndent();
            Object r0 = this.mSatLock;
            monitor-enter(r0);
            int u = 0;
        L20:
        L8:
            th = move-exception;
            throw th;
        L6:
            if (u >= this.mSpecialApps.size()) goto L10;
            pw.print("User ");     // Catch: Throwable -> L8
            pw.print(this.mSpecialApps.keyAt(u));     // Catch: Throwable -> L8
            pw.print(": ");     // Catch: Throwable -> L8
            pw.println(this.mSpecialApps.valuesAt(u));     // Catch: Throwable -> L8
            u = u + 1;     // Catch: Throwable -> L8
            goto L20
        L10:
            pw.println();     // Catch: Throwable -> L8
            pw.println("Carrier privileged packages:");     // Catch: Throwable -> L8
            pw.increaseIndent();     // Catch: Throwable -> L8
            int i = 0;
        L12:
            if (i >= this.mCarrierPrivilegedApps.size()) goto L14;
            pw.print(this.mCarrierPrivilegedApps.keyAt(i));     // Catch: Throwable -> L8
            pw.print(": ");     // Catch: Throwable -> L8
            pw.println(this.mCarrierPrivilegedApps.valuesAt(i));     // Catch: Throwable -> L8
            i = i + 1;     // Catch: Throwable -> L8
            goto L12
        L14:
            pw.decreaseIndent();     // Catch: Throwable -> L8
            pw.println();     // Catch: Throwable -> L8
            pw.print("Power allowlisted packages: ");     // Catch: Throwable -> L8
            pw.println(this.mPowerAllowlistedApps);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            pw.decreaseIndent();
        }
    }

    public static /* synthetic */ void $r8$lambda$YQJO92vFNpo0nJ4tdJou4VReoHk(IndentingPrintWriter r0, long r1, int r3, String r4, JobScoreTracker r5) {
        lambda$dumpControllerStateLocked$1(r0, r1, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$wapJZa3NDuV9bludzPgh7HBifyk(FlexibilityController r0) {
        r0.lambda$onConstantsUpdatedLocked$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppliedConstraints, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4948$$Nest$fgetmAppliedConstraints(FlexibilityController r0) {
        return r0.mAppliedConstraints;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDeadlineProximityLimitMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m4949$$Nest$fgetmDeadlineProximityLimitMs(FlexibilityController r2) {
        return r2.mDeadlineProximityLimitMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFallbackFlexibilityDeadlineMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m4950$$Nest$fgetmFallbackFlexibilityDeadlineMs(FlexibilityController r2) {
        return r2.mFallbackFlexibilityDeadlineMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFlexibilityEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4951$$Nest$fgetmFlexibilityEnabled(FlexibilityController r0) {
        return r0.mFlexibilityEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ FcHandler m4952$$Nest$fgetmHandler(FlexibilityController r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmJobsToCheck, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArraySet m4953$$Nest$fgetmJobsToCheck(FlexibilityController r0) {
        return r0.mJobsToCheck;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMaxRescheduledDeadline, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m4954$$Nest$fgetmMaxRescheduledDeadline(FlexibilityController r2) {
        return r2.mMaxRescheduledDeadline;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMinTimeBetweenFlexibilityAlarmsMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m4955$$Nest$fgetmMinTimeBetweenFlexibilityAlarmsMs(FlexibilityController r2) {
        return r2.mMinTimeBetweenFlexibilityAlarmsMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackagesToCheck, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArraySet m4956$$Nest$fgetmPackagesToCheck(FlexibilityController r0) {
        return r0.mPackagesToCheck;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRescheduledJobDeadline, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m4957$$Nest$fgetmRescheduledJobDeadline(FlexibilityController r2) {
        return r2.mRescheduledJobDeadline;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSpecialAppTracker, reason: not valid java name */
    static /* bridge */ /* synthetic */ SpecialAppTracker m4958$$Nest$fgetmSpecialAppTracker(FlexibilityController r0) {
        return r0.mSpecialAppTracker;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSupportedFlexConstraints, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4959$$Nest$fgetmSupportedFlexConstraints(FlexibilityController r0) {
        return r0.mSupportedFlexConstraints;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUnseenConstraintGracePeriodMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m4960$$Nest$fgetmUnseenConstraintGracePeriodMs(FlexibilityController r2) {
        return r2.mUnseenConstraintGracePeriodMs;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAppliedConstraints, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4961$$Nest$fputmAppliedConstraints(FlexibilityController r0, int r1) {
        r0.mAppliedConstraints = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDeadlineProximityLimitMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4962$$Nest$fputmDeadlineProximityLimitMs(FlexibilityController r0, long r1) {
        r0.mDeadlineProximityLimitMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmFallbackFlexibilityAdditionalScoreTimeFactors, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4963$$Nest$fputmFallbackFlexibilityAdditionalScoreTimeFactors(FlexibilityController r0, SparseLongArray r1) {
        r0.mFallbackFlexibilityAdditionalScoreTimeFactors = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmFallbackFlexibilityDeadlineMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4964$$Nest$fputmFallbackFlexibilityDeadlineMs(FlexibilityController r0, long r1) {
        r0.mFallbackFlexibilityDeadlineMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmFallbackFlexibilityDeadlineScores, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4965$$Nest$fputmFallbackFlexibilityDeadlineScores(FlexibilityController r0, SparseIntArray r1) {
        r0.mFallbackFlexibilityDeadlineScores = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmFallbackFlexibilityDeadlines, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4966$$Nest$fputmFallbackFlexibilityDeadlines(FlexibilityController r0, SparseLongArray r1) {
        r0.mFallbackFlexibilityDeadlines = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmFlexibilityEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4967$$Nest$fputmFlexibilityEnabled(FlexibilityController r0, boolean r1) {
        r0.mFlexibilityEnabled = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmMaxRescheduledDeadline, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4968$$Nest$fputmMaxRescheduledDeadline(FlexibilityController r0, long r1) {
        r0.mMaxRescheduledDeadline = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmMinTimeBetweenFlexibilityAlarmsMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4969$$Nest$fputmMinTimeBetweenFlexibilityAlarmsMs(FlexibilityController r0, long r1) {
        r0.mMinTimeBetweenFlexibilityAlarmsMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPercentsToDropConstraints, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4970$$Nest$fputmPercentsToDropConstraints(FlexibilityController r0, SparseArray r1) {
        r0.mPercentsToDropConstraints = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRescheduledJobDeadline, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4971$$Nest$fputmRescheduledJobDeadline(FlexibilityController r0, long r1) {
        r0.mRescheduledJobDeadline = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmUnseenConstraintGracePeriodMs, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4972$$Nest$fputmUnseenConstraintGracePeriodMs(FlexibilityController r0, long r1) {
        r0.mUnseenConstraintGracePeriodMs = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetPercentsToDropConstraints, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m4973$$Nest$mgetPercentsToDropConstraints(FlexibilityController r0, int r1) {
        return r0.getPercentsToDropConstraints(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4974$$Nest$sfgetDEBUG() {
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

    public FlexibilityController(JobSchedulerService service, PrefetchController prefetchController) {
        super(service);
        this.mFallbackFlexibilityDeadlineMs = 86400000;
        this.mFallbackFlexibilityDeadlines = FcConfig.DEFAULT_FALLBACK_FLEXIBILITY_DEADLINES;
        this.mFallbackFlexibilityDeadlineScores = FcConfig.DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_SCORES;
        this.mFallbackFlexibilityAdditionalScoreTimeFactors = FcConfig.DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_ADDITIONAL_SCORE_TIME_FACTORS;
        this.mRescheduledJobDeadline = 3600000;
        this.mMaxRescheduledDeadline = 86400000;
        this.mUnseenConstraintGracePeriodMs = 259200000;
        boolean r0 = false;
        this.mAppliedConstraints = 0;
        this.mMinTimeBetweenFlexibilityAlarmsMs = 60000;
        this.mDeadlineProximityLimitMs = HeartbeatStats.MAX_NAT_TIME_MS;
        this.mLastSeenConstraintTimesElapsed = new SparseLongArray();
        this.mPrefetchLifeCycleStart = new SparseArrayMap();
        this.mPrefetchChangedListener = new AnonymousClass1(this);
        this.mJobScoreTrackers = new SparseArrayMap();
        this.mJobsToCheck = new ArraySet();
        this.mPackagesToCheck = new ArraySet();
        this.mHandler = new FcHandler(this, AppSchedulingModuleThread.get().getLooper());
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive") == false) goto L5;
    L8:
        this.mSupportedFlexConstraints = 0;
    L10:
        if ((this.mAppliedConstraints & this.mSupportedFlexConstraints) == 0) goto L12;
        r0 = true;
    L12:
        this.mFlexibilityEnabled = r0;
        this.mFlexibilityTracker = new FlexibilityTracker(this, Integer.bitCount(this.mSupportedFlexConstraints));
        this.mFcConfig = new FcConfig(this);
        this.mFlexibilityAlarmQueue = new FlexibilityAlarmQueue(this, this.mContext, AppSchedulingModuleThread.get().getLooper(), null);
        this.mPercentsToDropConstraints = FcConfig.DEFAULT_PERCENTS_TO_DROP_FLEXIBLE_CONSTRAINTS;
        this.mPrefetchController = prefetchController;
        this.mSpecialAppTracker = new SpecialAppTracker(this);
        if (this.mFlexibilityEnabled == false) goto L16;
        SpecialAppTracker.m4986$$Nest$mstartTracking(this.mSpecialAppTracker);
        return;
    L16:
        return;
    L5:
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.embedded") == true) goto L8;
        this.mSupportedFlexConstraints = FLEXIBLE_CONSTRAINTS;
        goto L10
    }

    @Override // com.android.server.job.controllers.StateController
    public void onSystemServicesReady() {
        SpecialAppTracker.m4984$$Nest$monSystemServicesReady(this.mSpecialAppTracker);
    }

    @Override // com.android.server.job.controllers.StateController
    public void startTrackingLocked() {
        if (this.mFlexibilityEnabled == false) goto L6;
        this.mPrefetchController.registerPrefetchChangedListener(this.mPrefetchChangedListener);
        return;
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStartTrackingJobLocked(JobStatus js, JobStatus lastJob) {
        if (js.hasFlexibilityConstraint() == false) goto L10;
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        if (this.mSupportedFlexConstraints != 0) goto L8;
        js.setFlexibilityConstraintSatisfied(nowElapsed, true);
        return;
    L8:
        js.setNumAppliedFlexibleConstraints(Integer.bitCount(getRelevantAppliedConstraintsLocked(js)));
        js.setFlexibilityConstraintSatisfied(nowElapsed, isFlexibilitySatisfiedLocked(js));
        this.mFlexibilityTracker.add(js);
        js.setTrackingController(128);
        this.mFlexibilityAlarmQueue.scheduleDropNumConstraintsAlarm(js, nowElapsed);
        return;
    }

    @Override // com.android.server.job.controllers.StateController
    public void prepareForExecutionLocked(JobStatus jobStatus) {
        if (jobStatus.lastEvaluatedBias != 40) goto L5;
        return;
    L5:
        int priority = jobStatus.getJob().getPriority();
        int score = this.mFallbackFlexibilityDeadlineScores.get(priority, FcConfig.DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_SCORES.get(priority, priority / 100));
        JobScoreTracker jobScoreTracker = (JobScoreTracker) this.mJobScoreTrackers.get(jobStatus.getSourceUid(), jobStatus.getSourcePackageName());
        if (jobScoreTracker != null) goto L8;
        jobScoreTracker = new JobScoreTracker(null);
        this.mJobScoreTrackers.add(jobStatus.getSourceUid(), jobStatus.getSourcePackageName(), jobScoreTracker);
    L8:
        jobScoreTracker.addScore(score, JobSchedulerService.sElapsedRealtimeClock.millis());
    }

    @Override // com.android.server.job.controllers.StateController
    public void unprepareFromExecutionLocked(JobStatus jobStatus) {
        if (jobStatus.lastEvaluatedBias != 40) goto L5;
        return;
    L5:
        JobScoreTracker jobScoreTracker = (JobScoreTracker) this.mJobScoreTrackers.get(jobStatus.getSourceUid(), jobStatus.getSourcePackageName());
        if (jobScoreTracker != null) goto L9;
        Slog.e(TAG, "Unprepared a job that didn't result in a score change");
        return;
    L9:
        int priority = jobStatus.getJob().getPriority();
        int score = this.mFallbackFlexibilityDeadlineScores.get(priority, FcConfig.DEFAULT_FALLBACK_FLEXIBILITY_DEADLINE_SCORES.get(priority, priority / 100));
        jobScoreTracker.addScore(-score, JobSchedulerService.sElapsedRealtimeClock.millis());
    }

    @Override // com.android.server.job.controllers.StateController
    public void maybeStopTrackingJobLocked(JobStatus js, JobStatus incomingJob) {
        if (js.clearTrackingController(128) == false) goto L5;
        this.mFlexibilityAlarmQueue.removeAlarmForKey(js);
        this.mFlexibilityTracker.remove(js);
    L5:
        this.mJobsToCheck.remove(js);
    }

    @Override // com.android.server.job.controllers.StateController
    public void onAppRemovedLocked(String packageName, int uid) {
        int userId = UserHandle.getUserId(uid);
        this.mPrefetchLifeCycleStart.delete(userId, packageName);
        this.mJobScoreTrackers.delete(uid, packageName);
        SpecialAppTracker.m4983$$Nest$monAppRemoved(this.mSpecialAppTracker, userId, packageName);
        int i = this.mJobsToCheck.size() - 1;
    L3:
        if (i < 0) goto L15;
        JobStatus js = this.mJobsToCheck.valueAt(i);
        if (js.getSourceUid() != uid) goto L9;
        if (js.getSourcePackageName().equals(packageName) == false) goto L9;
    L12:
        this.mJobsToCheck.removeAt(i);
    L13:
        i = i - 1;
    L9:
        if (js.getUid() != uid) goto L13;
        if (js.getCallingPackageName().equals(packageName) == false) goto L13;
    }

    @Override // com.android.server.job.controllers.StateController
    public void onUserRemovedLocked(int userId) {
        this.mPrefetchLifeCycleStart.delete(userId);
        SpecialAppTracker.m4985$$Nest$monUserRemoved(this.mSpecialAppTracker, userId);
        int u = this.mJobScoreTrackers.numMaps() - 1;
    L3:
        if (u < 0) goto L8;
        int uid = this.mJobScoreTrackers.keyAt(u);
        if (UserHandle.getUserId(uid) != userId) goto L7;
        this.mJobScoreTrackers.deleteAt(u);
    L7:
        u = u - 1;
        goto L3
    L8:
        int i = this.mJobsToCheck.size() - 1;
    L9:
        if (i < 0) goto L17;
        JobStatus js = this.mJobsToCheck.valueAt(i);
        if (UserHandle.getUserId(js.getSourceUid()) != userId) goto L13;
    L14:
        this.mJobsToCheck.removeAt(i);
    L15:
        i = i - 1;
        goto L9
    L13:
        if (UserHandle.getUserId(js.getUid()) != userId) goto L15;
    }

    boolean isEnabled() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = this.mFlexibilityEnabled;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean isFlexibilitySatisfiedLocked(JobStatus js) {
        if (this.mFlexibilityEnabled == true) goto L5;
    L20:
        return true;
    L5:
        if (this.mService.getUidBias(js.getSourceUid()) == 40) goto L20;
        if (this.mService.getUidBias(js.getSourceUid()) < 30) goto L11;
        if (js.getEffectivePriority() >= 300) goto L20;
    L11:
        if (js.getEffectivePriority() < 300) goto L15;
        if (this.mSpecialAppTracker.isSpecialApp(js.getSourceUserId(), js.getSourcePackageName()) == true) goto L20;
    L15:
        if (hasEnoughSatisfiedConstraintsLocked(js) == true) goto L20;
        if (this.mService.isCurrentlyRunningLocked(js) == true) goto L20;
        return false;
    }

    int getRelevantAppliedConstraintsLocked(JobStatus js) {
        if (js.canApplyTransportAffinities() == false) goto L5;
        int r0 = 268435456;
    L6:
        int relevantConstraints = r0 | 7;
        return this.mAppliedConstraints & relevantConstraints;
    L5:
        r0 = 0;
        goto L6
    }

    boolean hasEnoughSatisfiedConstraintsLocked(JobStatus js) {
        int r1 = this.mSatisfiedFlexibleConstraints & this.mAppliedConstraints;
        if (js.areTransportAffinitiesSatisfied() == false) goto L5;
        int r2 = 268435456;
    L6:
        int satisfiedConstraints = r1 & (r2 | 7);
        int numSatisfied = Integer.bitCount(satisfiedConstraints);
        if (numSatisfied < js.getNumRequiredFlexibleConstraints()) goto L9;
        return true;
    L9:
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        if (nowElapsed >= this.mUnseenConstraintGracePeriodMs) goto L12;
        return false;
    L12:
        int irrelevantConstraints = ~getRelevantAppliedConstraintsLocked(js);
        int i = this.mLastSeenConstraintTimesElapsed.size() - 1;
    L13:
        if (i < 0) goto L27;
        int constraints = this.mLastSeenConstraintTimesElapsed.keyAt(i);
        if ((constraints & irrelevantConstraints) != 0) goto L25;
        long lastSeenElapsed = this.mLastSeenConstraintTimesElapsed.valueAt(i);
        if ((nowElapsed - lastSeenElapsed) > this.mUnseenConstraintGracePeriodMs) goto L20;
        boolean seenRecently = true;
    L22:
        if (Integer.bitCount(constraints) <= numSatisfied) goto L25;
        if (seenRecently == false) goto L25;
        return false;
    L20:
        seenRecently = false;
    L25:
        i = i - 1;
        goto L13
    L27:
        return true;
    L5:
        r2 = 0;
        goto L6
    }

    void setConstraintSatisfied(int constraint, boolean state, long nowElapsed) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if ((this.mSatisfiedFlexibleConstraints & constraint) == 0) goto L7;
        boolean old = true;
    L8:
        if (old != state) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L14:
        if (DEBUG == false) goto L16;
        Slog.d(TAG, "setConstraintSatisfied:  constraint: " + constraint + " state: " + state);     // Catch: Throwable -> L11
    L16:
        this.mLastSeenConstraintTimesElapsed.put(this.mSatisfiedFlexibleConstraints, nowElapsed);     // Catch: Throwable -> L11
        if (state == true) goto L19;
        this.mLastSeenConstraintTimesElapsed.put(constraint, nowElapsed);     // Catch: Throwable -> L11
    L19:
        int r3 = this.mSatisfiedFlexibleConstraints & (~constraint);     // Catch: Throwable -> L11
        if (state == false) goto L22;
        int r4 = constraint;
    L23:
        this.mSatisfiedFlexibleConstraints = r3 | r4;     // Catch: Throwable -> L11
        if ((268435456 & constraint) == 0) goto L28;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L28:
        if (this.mFlexibilityEnabled == false) goto L30;
        this.mHandler.obtainMessage(0).sendToTarget();     // Catch: Throwable -> L11
    L30:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L22:
        r4 = 0;
        goto L23
    L7:
        old = false;
        goto L8
    }

    boolean isConstraintSatisfied(int constraint) {
        if ((this.mSatisfiedFlexibleConstraints & constraint) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    long getLifeCycleBeginningElapsedLocked(JobStatus js) {
        if (js.getEarliestRunTime() != 0) goto L5;
        long earliestRuntime = js.enqueueTime;
    L7:
        if (js.getJob().isPeriodic() == false) goto L12;
        if (js.getNumPreviousAttempts() != 0) goto L12;
        long truePeriodicStartTimeElapsed = js.getLatestRunTimeElapsed() - js.getJob().getFlexMillis();
        earliestRuntime = (earliestRuntime + truePeriodicStartTimeElapsed) / 2;
    L12:
        if (js.getJob().isPrefetch() == false) goto L18;
        long estimatedLaunchTime = this.mPrefetchController.getNextEstimatedLaunchTimeLocked(js);
        long prefetchWindowStart = ((Long) this.mPrefetchLifeCycleStart.getOrDefault(js.getSourceUserId(), js.getSourcePackageName(), 0L)).longValue();
        if (estimatedLaunchTime == Long.MAX_VALUE) goto L17;
        prefetchWindowStart = Math.max(prefetchWindowStart, estimatedLaunchTime - this.mPrefetchController.getLaunchTimeThresholdMs());
    L17:
        return Math.max(prefetchWindowStart, earliestRuntime);
    L18:
        return earliestRuntime;
    L5:
        earliestRuntime = js.getEarliestRunTime();
        goto L7
    }

    int getScoreLocked(int uid, String pkgName, long nowElapsed) {
        JobScoreTracker scoreTracker = (JobScoreTracker) this.mJobScoreTrackers.get(uid, pkgName);
        if (scoreTracker != null) goto L6;
        return 0;
    L6:
        return scoreTracker.getScore(nowElapsed);
    }

    long getLifeCycleEndElapsedLocked(JobStatus js, long nowElapsed, long earliest) {
        if (js.getJob().isPrefetch() == false) goto L14;
        long estimatedLaunchTime = this.mPrefetchController.getNextEstimatedLaunchTimeLocked(js);
        if (js.getLatestRunTimeElapsed() == Long.MAX_VALUE) goto L9;
        return Math.min(estimatedLaunchTime - this.mConstants.PREFETCH_FORCE_BATCH_RELAX_THRESHOLD_MS, js.getLatestRunTimeElapsed());
    L9:
        if (estimatedLaunchTime != Long.MAX_VALUE) goto L11;
        return Long.MAX_VALUE;
    L11:
        return estimatedLaunchTime - this.mConstants.PREFETCH_FORCE_BATCH_RELAX_THRESHOLD_MS;
    L14:
        if (js.getNumPreviousAttempts() > 1) goto L16;
        int jobPriority = js.getEffectivePriority();
        int jobScore = getScoreLocked(js.getSourceUid(), js.getSourcePackageName(), nowElapsed);
        long fallbackDurationMs = Math.min(this.mFallbackFlexibilityDeadlineMs * 3, this.mFallbackFlexibilityDeadlines.get(jobPriority, this.mFallbackFlexibilityDeadlineMs) + (this.mFallbackFlexibilityAdditionalScoreTimeFactors.get(jobPriority, 60000) * ((long) jobScore)));
        long fallbackDeadlineMs = earliest + fallbackDurationMs;
        if (js.getLatestRunTimeElapsed() != Long.MAX_VALUE) goto L21;
        return fallbackDeadlineMs;
    L21:
        return Math.max(fallbackDeadlineMs, js.getLatestRunTimeElapsed());
    L16:
        return earliest + Math.min((long) Math.scalb(this.mRescheduledJobDeadline, js.getNumPreviousAttempts() - 2), this.mMaxRescheduledDeadline);
    }

    int getCurPercentOfLifecycleLocked(JobStatus js, long nowElapsed) {
        long earliest = getLifeCycleBeginningElapsedLocked(js);
        long latest = getLifeCycleEndElapsedLocked(js, nowElapsed, earliest);
        if (latest != Long.MAX_VALUE) goto L5;
        return 0;
    L5:
        if (earliest < nowElapsed) goto L8;
        return 0;
    L8:
        if (nowElapsed <= latest) goto L10;
        return 100;
    L10:
        if (latest == earliest) goto L18;
        int percentInTime = (int) (((nowElapsed - earliest) * 100) / (latest - earliest));
        return percentInTime;
    L18:
        return 100;
    }

    long getNextConstraintDropTimeElapsedLocked(JobStatus js) {
        long earliest = getLifeCycleBeginningElapsedLocked(js);
        long latest = getLifeCycleEndElapsedLocked(js, JobSchedulerService.sElapsedRealtimeClock.millis(), earliest);
        return getNextConstraintDropTimeElapsedLocked(js, earliest, latest);
    }

    long getNextConstraintDropTimeElapsedLocked(JobStatus js, long earliest, long latest) {
        int[] percentsToDropConstraints = getPercentsToDropConstraints(js.getEffectivePriority());
        if (latest != Long.MAX_VALUE) goto L5;
    L9:
        return Long.MAX_VALUE;
    L5:
        if (js.getNumDroppedFlexibleConstraints() == percentsToDropConstraints.length) goto L9;
        int percent = percentsToDropConstraints[js.getNumDroppedFlexibleConstraints()];
        long percentInTime = ((latest - earliest) * ((long) percent)) / 100;
        return earliest + percentInTime;
    }

    private int[] getPercentsToDropConstraints(int priority) {
        int[] percentsToDropConstraints = this.mPercentsToDropConstraints.get(priority);
        if (percentsToDropConstraints != null) goto L6;
        Slog.wtf(TAG, "No %-to-drop for priority " + JobInfo.getPriorityString(priority));
        return new int[]{50, 60, 70, 80};
    L6:
        return percentsToDropConstraints;
    }

    @Override // com.android.server.job.controllers.StateController
    public void onUidBiasChangedLocked(int uid, int prevBias, int newBias) {
        if (prevBias >= 30) goto L6;
        if (newBias >= 30) goto L6;
        return;
    L6:
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        ArraySet<JobStatus> jobsByUid = this.mService.getJobStore().getJobsBySourceUid(uid);
        boolean hasPrefetch = false;
        int i = 0;
    L8:
        if (i >= jobsByUid.size()) goto L14;
        JobStatus js = jobsByUid.valueAt(i);
        if (js.hasFlexibilityConstraint() == false) goto L12;
        js.setFlexibilityConstraintSatisfied(nowElapsed, isFlexibilitySatisfiedLocked(js));
        hasPrefetch = hasPrefetch | js.getJob().isPrefetch();
    L12:
        i = i + 1;
        goto L8
    L14:
        if (hasPrefetch == true) goto L16;
        return;
    L16:
        if (prevBias != 40) goto L29;
        int userId = UserHandle.getUserId(uid);
        ArraySet<String> pkgs = this.mService.getPackagesForUidLocked(uid);
        if (pkgs != null) goto L20;
        return;
    L20:
        int i2 = 0;
    L22:
        if (i2 >= pkgs.size()) goto L30;
        String pkg = pkgs.valueAt(i2);
        this.mPrefetchLifeCycleStart.add(userId, pkg, Long.valueOf(Math.max(((Long) this.mPrefetchLifeCycleStart.getOrDefault(userId, pkg, 0L)).longValue(), nowElapsed)));
        i2 = i2 + 1;
        goto L22
    L30:
        return;
    }

    @Override // com.android.server.job.controllers.StateController
    public void onConstantsUpdatedLocked() {
        if (FcConfig.m4975$$Nest$fgetmShouldReevaluateConstraints(this.mFcConfig) == false) goto L6;
        AppSchedulingModuleThread.getHandler().post(new FlexibilityController$$ExternalSyntheticLambda1(this));
        return;
    }

    private /* synthetic */ void lambda$onConstantsUpdatedLocked$0() {
        ArraySet<JobStatus> changedJobs = new ArraySet();
        Object r1 = this.mLock;
        monitor-enter(r1);
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();     // Catch: Throwable -> L12
        int j = 0;
    L6:
        if (j >= this.mFlexibilityTracker.size()) goto L17;
        ArraySet<JobStatus> jobs = this.mFlexibilityTracker.getJobsByNumRequiredConstraints(j);     // Catch: Throwable -> L12
        int i = jobs.size() - 1;     // Catch: Throwable -> L12
    L8:
        if (i < 0) goto L15;
        JobStatus js = jobs.valueAt(i);     // Catch: Throwable -> L12
        this.mFlexibilityTracker.updateFlexibleConstraints(js, nowElapsed);     // Catch: Throwable -> L12
        this.mFlexibilityAlarmQueue.scheduleDropNumConstraintsAlarm(js, nowElapsed);     // Catch: Throwable -> L12
        if (js.setFlexibilityConstraintSatisfied(nowElapsed, isFlexibilitySatisfiedLocked(js)) == false) goto L14;
        changedJobs.add(js);     // Catch: Throwable -> L12
    L14:
        i = i - 1;     // Catch: Throwable -> L12
        goto L8
    L15:
        j = j + 1;     // Catch: Throwable -> L12
        goto L6
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L12
        if (changedJobs.size() <= 0) goto L30;
        this.mStateChangedListener.onControllerStateChanged(changedJobs);
        return;
    L30:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.job.controllers.StateController
    public void prepareForUpdatedConstantsLocked() {
        FcConfig.m4976$$Nest$fputmShouldReevaluateConstraints(this.mFcConfig, false);
    }

    @Override // com.android.server.job.controllers.StateController
    public void processConstantLocked(DeviceConfig.Properties properties, String key) {
        this.mFcConfig.processConstantLocked(properties, key);
    }

    FcConfig getFcConfig() {
        return this.mFcConfig;
    }

    public void setLocalPolicyForTesting(boolean override, int appliedConstraints) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mLocalOverride != override) goto L12;
        if (this.mAppliedConstraints != appliedConstraints) goto L12;
        boolean recheckJobs = false;
    L13:
        this.mLocalOverride = override;     // Catch: Throwable -> L10
        if (this.mLocalOverride == false) goto L16;
        this.mAppliedConstraints = appliedConstraints;     // Catch: Throwable -> L10
    L17:
        if (recheckJobs == false) goto L19;
        this.mHandler.obtainMessage(0).sendToTarget();     // Catch: Throwable -> L10
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L16:
        this.mAppliedConstraints = this.mFcConfig.APPLIED_CONSTRAINTS;     // Catch: Throwable -> L10
    L12:
        recheckJobs = true;
        goto L13
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpConstants(IndentingPrintWriter pw) {
        FcConfig.m4977$$Nest$mdump(this.mFcConfig, pw);
    }

    @Override // com.android.server.job.controllers.StateController
    public void dumpControllerStateLocked(final IndentingPrintWriter pw, Predicate<JobStatus> predicate) {
        if (this.mLocalOverride == false) goto L5;
        pw.println("Local override active");
    L5:
        pw.print("Applied Flexible Constraints:");
        JobStatus.dumpConstraints(pw, this.mAppliedConstraints);
        pw.println();
        pw.print("Satisfied Flexible Constraints:");
        JobStatus.dumpConstraints(pw, this.mSatisfiedFlexibleConstraints);
        pw.println();
        pw.println();
        final long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        pw.println("Time since constraint combos last seen:");
        pw.increaseIndent();
        int i = 0;
    L7:
        if (i >= this.mLastSeenConstraintTimesElapsed.size()) goto L17;
        int constraints = this.mLastSeenConstraintTimesElapsed.keyAt(i);
        if (constraints != this.mSatisfiedFlexibleConstraints) goto L11;
        pw.print("0ms");
    L12:
        pw.print(":");
        if (constraints == 0) goto L15;
        JobStatus.dumpConstraints(pw, constraints);
    L16:
        pw.println();
        i = i + 1;
        goto L7
    L15:
        pw.print(" none");
        goto L16
    L11:
        TimeUtils.formatDuration(this.mLastSeenConstraintTimesElapsed.valueAt(i), nowElapsed, pw);
        goto L12
    L17:
        pw.decreaseIndent();
        pw.println();
        this.mSpecialAppTracker.dump(pw);
        pw.println();
        this.mFlexibilityTracker.dump(pw, predicate, nowElapsed);
        pw.println();
        pw.println("Job scores:");
        pw.increaseIndent();
        this.mJobScoreTrackers.forEach(new FlexibilityController$$ExternalSyntheticLambda0(pw, nowElapsed));
        pw.decreaseIndent();
        pw.println();
        this.mFlexibilityAlarmQueue.dump(pw);
    }

    private static /* synthetic */ void lambda$dumpControllerStateLocked$1(IndentingPrintWriter pw, long nowElapsed, int uid, String pkgName, JobScoreTracker jobScoreTracker) {
        pw.print(uid);
        pw.print(SliceClientPermissions.SliceAuthority.DELIMITER);
        pw.print(pkgName);
        pw.print(": ");
        jobScoreTracker.dump(pw, nowElapsed);
        pw.println();
    }
}
