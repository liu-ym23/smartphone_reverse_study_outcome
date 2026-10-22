package com.android.server.job;

import android.app.job.JobParameters;
import android.os.UserHandle;
import android.text.format.DateFormat;
import android.util.ArrayMap;
import android.util.IndentingPrintWriter;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import com.android.internal.util.jobs.RingBufferIndices;
import com.android.server.job.controllers.JobStatus;
import com.android.server.pm.verify.domain.DomainVerificationPersistence;
import com.android.server.slice.SliceClientPermissions;

/* JADX INFO: loaded from: classes2.dex */
public final class JobPackageTracker {
    static final long BATCHING_TIME = 1800000;
    private static final int EVENT_BUFFER_SIZE = 100;
    public static final int EVENT_CMD_MASK = 255;
    public static final int EVENT_NULL = 0;
    public static final int EVENT_START_JOB = 1;
    public static final int EVENT_START_PERIODIC_JOB = 3;
    public static final int EVENT_STOP_JOB = 2;
    public static final int EVENT_STOP_PERIODIC_JOB = 4;
    public static final int EVENT_STOP_REASON_MASK = 65280;
    public static final int EVENT_STOP_REASON_SHIFT = 8;
    static final int NUM_HISTORY = 5;
    DataSet mCurDataSet;
    private final int[] mEventCmds;
    private final RingBufferIndices mEventIndices;
    private final int[] mEventJobIds;
    private final String[] mEventReasons;
    private final String[] mEventTags;
    private final long[] mEventTimes;
    private final int[] mEventUids;
    DataSet[] mLastDataSets;

    static final class DataSet {
        final SparseArray<ArrayMap<String, PackageEntry>> mEntries;
        int mMaxFgActive;
        int mMaxTotalActive;
        final long mStartClockTime;
        final long mStartElapsedTime;
        final long mStartUptimeTime;
        long mSummedTime;

        public DataSet(DataSet otherTimes) {
            this.mEntries = new SparseArray();
            this.mStartUptimeTime = otherTimes.mStartUptimeTime;
            this.mStartElapsedTime = otherTimes.mStartElapsedTime;
            this.mStartClockTime = otherTimes.mStartClockTime;
        }

        public DataSet() {
            this.mEntries = new SparseArray();
            this.mStartUptimeTime = JobSchedulerService.sUptimeMillisClock.millis();
            this.mStartElapsedTime = JobSchedulerService.sElapsedRealtimeClock.millis();
            this.mStartClockTime = JobSchedulerService.sSystemClock.millis();
        }

        private PackageEntry getOrCreateEntry(int uid, String pkg) {
            ArrayMap<String, PackageEntry> uidMap = this.mEntries.get(uid);
            if (uidMap != null) goto L5;
            uidMap = new ArrayMap();
            this.mEntries.put(uid, uidMap);
        L5:
            PackageEntry entry = uidMap.get(pkg);
            if (entry != null) goto L9;
            PackageEntry entry2 = new PackageEntry();
            uidMap.put(pkg, entry2);
            return entry2;
        L9:
            return entry;
        }

        public PackageEntry getEntry(int uid, String pkg) {
            ArrayMap<String, PackageEntry> uidMap = this.mEntries.get(uid);
            if (uidMap != null) goto L7;
            return null;
        L7:
            return uidMap.get(pkg);
        }

        long getTotalTime(long now) {
            if (this.mSummedTime <= 0) goto L7;
            return this.mSummedTime;
        L7:
            return now - this.mStartUptimeTime;
        }

        void incPending(int uid, String pkg, long now) {
            PackageEntry pe = getOrCreateEntry(uid, pkg);
            if (pe.pendingNesting != 0) goto L5;
            pe.pendingStartTime = now;
            pe.pendingCount++;
        L5:
            pe.pendingNesting++;
        }

        void decPending(int uid, String pkg, long now) {
            PackageEntry pe = getOrCreateEntry(uid, pkg);
            if (pe.pendingNesting != 1) goto L5;
            pe.pastPendingTime += now - pe.pendingStartTime;
        L5:
            pe.pendingNesting--;
        }

        void incActive(int uid, String pkg, long now) {
            PackageEntry pe = getOrCreateEntry(uid, pkg);
            if (pe.activeNesting != 0) goto L5;
            pe.activeStartTime = now;
            pe.activeCount++;
        L5:
            pe.activeNesting++;
        }

        void decActive(int uid, String pkg, long now, int stopReason) {
            PackageEntry pe = getOrCreateEntry(uid, pkg);
            if (pe.activeNesting != 1) goto L5;
            pe.pastActiveTime += now - pe.activeStartTime;
        L5:
            pe.activeNesting--;
            int count = pe.stopReasons.get(stopReason, 0);
            pe.stopReasons.put(stopReason, count + 1);
        }

        void incActiveTop(int uid, String pkg, long now) {
            PackageEntry pe = getOrCreateEntry(uid, pkg);
            if (pe.activeTopNesting != 0) goto L5;
            pe.activeTopStartTime = now;
            pe.activeTopCount++;
        L5:
            pe.activeTopNesting++;
        }

        void decActiveTop(int uid, String pkg, long now, int stopReason) {
            PackageEntry pe = getOrCreateEntry(uid, pkg);
            if (pe.activeTopNesting != 1) goto L5;
            pe.pastActiveTopTime += now - pe.activeTopStartTime;
        L5:
            pe.activeTopNesting--;
            int count = pe.stopReasons.get(stopReason, 0);
            pe.stopReasons.put(stopReason, count + 1);
        }

        void finish(DataSet next, long now) {
            int i = this.mEntries.size() - 1;
        L3:
            if (i < 0) goto L24;
            ArrayMap<String, PackageEntry> uidMap = this.mEntries.valueAt(i);
            int j = uidMap.size() - 1;
        L5:
            if (j < 0) goto L22;
            PackageEntry pe = uidMap.valueAt(j);
            if (pe.activeNesting <= 0) goto L9;
        L12:
            PackageEntry nextPe = next.getOrCreateEntry(this.mEntries.keyAt(i), uidMap.keyAt(j));
            nextPe.activeStartTime = now;
            nextPe.activeNesting = pe.activeNesting;
            nextPe.activeTopStartTime = now;
            nextPe.activeTopNesting = pe.activeTopNesting;
            nextPe.pendingStartTime = now;
            nextPe.pendingNesting = pe.pendingNesting;
            if (pe.activeNesting <= 0) goto L16;
            pe.pastActiveTime += now - pe.activeStartTime;
            pe.activeNesting = 0;
        L16:
            if (pe.activeTopNesting <= 0) goto L19;
            pe.pastActiveTopTime += now - pe.activeTopStartTime;
            pe.activeTopNesting = 0;
        L19:
            if (pe.pendingNesting <= 0) goto L21;
            pe.pastPendingTime += now - pe.pendingStartTime;
            pe.pendingNesting = 0;
        L21:
            j = j - 1;
            goto L5
        L9:
            if (pe.activeTopNesting > 0) goto L12;
            if (pe.pendingNesting <= 0) goto L21;
        L22:
            i = i - 1;
            goto L3
        }

        void addTo(DataSet out, long now) {
            out.mSummedTime += getTotalTime(now);
            int i = this.mEntries.size() - 1;
        L3:
            if (i < 0) goto L20;
            ArrayMap<String, PackageEntry> uidMap = this.mEntries.valueAt(i);
            int j = uidMap.size() - 1;
        L5:
            if (j < 0) goto L19;
            PackageEntry pe = uidMap.valueAt(j);
            PackageEntry outPe = out.getOrCreateEntry(this.mEntries.keyAt(i), uidMap.keyAt(j));
            outPe.pastActiveTime += pe.pastActiveTime;
            outPe.activeCount += pe.activeCount;
            outPe.pastActiveTopTime += pe.pastActiveTopTime;
            outPe.activeTopCount += pe.activeTopCount;
            outPe.pastPendingTime += pe.pastPendingTime;
            outPe.pendingCount += pe.pendingCount;
            if (pe.activeNesting <= 0) goto L10;
            outPe.pastActiveTime += now - pe.activeStartTime;
            outPe.hadActive = true;
        L10:
            if (pe.activeTopNesting <= 0) goto L13;
            outPe.pastActiveTopTime += now - pe.activeTopStartTime;
            outPe.hadActiveTop = true;
        L13:
            if (pe.pendingNesting <= 0) goto L15;
            outPe.pastPendingTime += now - pe.pendingStartTime;
            outPe.hadPending = true;
        L15:
            int k = pe.stopReasons.size() - 1;
        L16:
            if (k < 0) goto L18;
            int type = pe.stopReasons.keyAt(k);
            outPe.stopReasons.put(type, outPe.stopReasons.get(type, 0) + pe.stopReasons.valueAt(k));
            k = k - 1;
            goto L16
        L18:
            j = j - 1;
            goto L5
        L19:
            i = i - 1;
            goto L3
        L20:
            int i2 = this.mMaxTotalActive;
            if (i2 <= out.mMaxTotalActive) goto L24;
            out.mMaxTotalActive = this.mMaxTotalActive;
        L24:
            if (this.mMaxFgActive <= out.mMaxFgActive) goto L30;
            out.mMaxFgActive = this.mMaxFgActive;
            return;
        }

        boolean printDuration(IndentingPrintWriter pw, long period, long duration, int count, String suffix) {
            float fraction = duration / period;
            int percent = (int) ((100.0f * fraction) + 0.5f);
            if (percent <= 0) goto L6;
            pw.print(percent);
            pw.print("% ");
            pw.print(count);
            pw.print("x ");
            pw.print(suffix);
            return true;
        L6:
            if (count <= 0) goto L9;
            pw.print(count);
            pw.print("x ");
            pw.print(suffix);
            return true;
        L9:
            return false;
        }

        void dump(IndentingPrintWriter pw, String header, long now, long nowElapsed, int filterAppId) {
            DataSet r0 = this;
            long period = r0.getTotalTime(now);
            pw.print(header);
            pw.print(" at ");
            pw.print(DateFormat.format("yyyy-MM-dd-HH-mm-ss", r0.mStartClockTime).toString());
            pw.print(" (");
            TimeUtils.formatDuration(r0.mStartElapsedTime, nowElapsed, pw);
            pw.print(") over ");
            TimeUtils.formatDuration(period, pw);
            pw.println(":");
            pw.increaseIndent();
            pw.print("Max concurrency: ");
            pw.print(r0.mMaxTotalActive);
            pw.print(" total, ");
            pw.print(r0.mMaxFgActive);
            pw.println(" foreground");
            pw.println();
            int NE = r0.mEntries.size();
            int i = 0;
        L3:
            if (i >= NE) goto L44;
            int uid = r0.mEntries.keyAt(i);
            if (filterAppId != (-1)) goto L7;
        L9:
            ArrayMap<String, PackageEntry> uidMap = r0.mEntries.valueAt(i);
            int NP = uidMap.size();
            int j = 0;
        L10:
            if (j >= NP) goto L43;
            PackageEntry pe = uidMap.valueAt(j);
            UserHandle.formatUid(pw, uid);
            pw.print(" / ");
            pw.print(uidMap.keyAt(j));
            pw.println(":");
            pw.increaseIndent();
            int uid2 = uid;
            ArrayMap<String, PackageEntry> uidMap2 = uidMap;
            long r4 = pe.getPendingTime(now);
            int NP2 = NP;
            int NP3 = pe.pendingCount;
            int j2 = j;
            if (printDuration(pw, period, r4, NP3, "pending") == false) goto L15;
            pw.print(" ");
        L15:
            if (printDuration(pw, period, pe.getActiveTime(now), pe.activeCount, DomainVerificationPersistence.TAG_ACTIVE) == false) goto L17;
            pw.print(" ");
        L17:
            printDuration(pw, period, pe.getActiveTopTime(now), pe.activeTopCount, "active-top");
            if (pe.pendingNesting <= 0) goto L20;
        L21:
            pw.print(" (pending)");
        L23:
            if (pe.activeNesting <= 0) goto L25;
        L26:
            pw.print(" (active)");
        L28:
            if (pe.activeTopNesting <= 0) goto L30;
        L31:
            pw.print(" (active-top)");
        L32:
            pw.println();
            if (pe.stopReasons.size() <= 0) goto L41;
            int k = 0;
        L36:
            if (k >= pe.stopReasons.size()) goto L40;
            if (k <= 0) goto L39;
            pw.print(", ");
        L39:
            pw.print(pe.stopReasons.valueAt(k));
            pw.print("x ");
            pw.print(JobParameters.getInternalReasonCodeDescription(pe.stopReasons.keyAt(k)));
            k = k + 1;
            goto L36
        L40:
            pw.println();
        L41:
            pw.decreaseIndent();
            j = j2 + 1;
            uid = uid2;
            uidMap = uidMap2;
            NP = NP2;
            goto L10
        L30:
            if (pe.hadActiveTop == false) goto L32;
        L25:
            if (pe.hadActive == false) goto L28;
        L20:
            if (pe.hadPending == false) goto L23;
        L43:
            i = i + 1;
            r0 = this;
            goto L3
        L7:
            if (filterAppId == UserHandle.getAppId(uid)) goto L9;
        L44:
            pw.decreaseIndent();
        }

        private void printPackageEntryState(ProtoOutputStream proto, long fieldId, long duration, int count) {
            long token = proto.start(fieldId);
            proto.write(1112396529665L, duration);
            proto.write(1120986464258L, count);
            proto.end(token);
        }

        void dump(ProtoOutputStream proto, long fieldId, long now, long nowElapsed, int filterUid) {
            DataSet r0 = this;
            ProtoOutputStream r1 = proto;
            long r7 = now;
            long token = proto.start(fieldId);
            long period = r0.getTotalTime(r7);
            r1.write(1112396529665L, r0.mStartClockTime);
            r1.write(1112396529666L, nowElapsed - r0.mStartElapsedTime);
            r1.write(1112396529667L, period);
            int NE = r0.mEntries.size();
            int i = 0;
        L3:
            if (i >= NE) goto L37;
            int uid = r0.mEntries.keyAt(i);
            if (filterUid != (-1)) goto L7;
        L9:
            ArrayMap<String, PackageEntry> uidMap = r0.mEntries.valueAt(i);
            int NP = uidMap.size();
            int j = 0;
        L10:
            if (j >= NP) goto L35;
            long period2 = period;
            long peToken = r1.start(2246267895812L);
            PackageEntry pe = uidMap.valueAt(j);
            int NE2 = NE;
            int i2 = i;
            r1.write(1120986464257L, uid);
            int uid2 = uid;
            ArrayMap<String, PackageEntry> uidMap2 = uidMap;
            r1.write(1138166333442L, uidMap.keyAt(j));
            int NP2 = NP;
            int j2 = j;
            r0.printPackageEntryState(r1, 1146756268035L, pe.getPendingTime(r7), pe.pendingCount);
            r0 = this;
            r1 = proto;
            r0.printPackageEntryState(r1, 1146756268036L, pe.getActiveTime(r7), pe.activeCount);
            r0.printPackageEntryState(r1, 1146756268037L, pe.getActiveTopTime(r7), pe.activeTopCount);
            boolean r3 = false;
            if (pe.pendingNesting <= 0) goto L14;
        L17:
            boolean r2 = true;
        L18:
            r1.write(1133871366150L, r2);
            if (pe.activeNesting <= 0) goto L21;
        L24:
            boolean r4 = true;
        L25:
            r1.write(1133871366151L, r4);
            if (pe.activeTopNesting <= 0) goto L28;
        L29:
            r3 = true;
        L30:
            r1.write(1133871366152L, r3);
            int k = 0;
        L32:
            if (k >= pe.stopReasons.size()) goto L34;
            long srcToken = r1.start(2246267895817L);
            r1.write(1159641169921L, pe.stopReasons.keyAt(k));
            r1.write(1120986464258L, pe.stopReasons.valueAt(k));
            r1.end(srcToken);
            k = k + 1;
            goto L32
        L34:
            r1.end(peToken);
            j = j2 + 1;
            r7 = now;
            uid = uid2;
            period = period2;
            NE = NE2;
            i = i2;
            uidMap = uidMap2;
            NP = NP2;
            goto L10
        L28:
            if (pe.hadActiveTop == false) goto L30;
        L21:
            if (pe.hadActive == true) goto L24;
            r4 = false;
            goto L25
        L14:
            if (pe.hadPending == true) goto L17;
            r2 = false;
            goto L18
        L35:
            long period3 = period;
            int NE3 = NE;
            int i3 = i;
        L36:
            i = i3 + 1;
            r7 = now;
            period = period3;
            NE = NE3;
            goto L3
        L7:
            if (filterUid == UserHandle.getAppId(uid)) goto L9;
            period3 = period;
            NE3 = NE;
            i3 = i;
            goto L36
        L37:
            r1.write(1120986464261L, r0.mMaxTotalActive);
            r1.write(1120986464262L, r0.mMaxFgActive);
            r1.end(token);
        }
    }

    static final class PackageEntry {
        int activeCount;
        int activeNesting;
        long activeStartTime;
        int activeTopCount;
        int activeTopNesting;
        long activeTopStartTime;
        boolean hadActive;
        boolean hadActiveTop;
        boolean hadPending;
        long pastActiveTime;
        long pastActiveTopTime;
        long pastPendingTime;
        int pendingCount;
        int pendingNesting;
        long pendingStartTime;
        final SparseIntArray stopReasons;

        PackageEntry() {
            this.stopReasons = new SparseIntArray();
        }

        public long getActiveTime(long now) {
            long time = this.pastActiveTime;
            if (this.activeNesting > 0) goto L5;
            return time;
        L5:
            return time + (now - this.activeStartTime);
        }

        public long getActiveTopTime(long now) {
            long time = this.pastActiveTopTime;
            if (this.activeTopNesting > 0) goto L5;
            return time;
        L5:
            return time + (now - this.activeTopStartTime);
        }

        public long getPendingTime(long now) {
            long time = this.pastPendingTime;
            if (this.pendingNesting > 0) goto L5;
            return time;
        L5:
            return time + (now - this.pendingStartTime);
        }
    }

    public JobPackageTracker() {
        this.mEventIndices = new RingBufferIndices(100);
        this.mEventCmds = new int[100];
        this.mEventTimes = new long[100];
        this.mEventUids = new int[100];
        this.mEventTags = new String[100];
        this.mEventJobIds = new int[100];
        this.mEventReasons = new String[100];
        this.mCurDataSet = new DataSet();
        this.mLastDataSets = new DataSet[5];
    }

    public void addEvent(int cmd, int uid, String tag, int jobId, int stopReason, String debugReason) {
        int index = this.mEventIndices.add();
        this.mEventCmds[index] = ((stopReason << 8) & EVENT_STOP_REASON_MASK) | cmd;
        this.mEventTimes[index] = JobSchedulerService.sElapsedRealtimeClock.millis();
        this.mEventUids[index] = uid;
        this.mEventTags[index] = tag;
        this.mEventJobIds[index] = jobId;
        this.mEventReasons[index] = debugReason;
    }

    void rebatchIfNeeded(long now) {
        long totalTime = this.mCurDataSet.getTotalTime(now);
        if (totalTime <= 1800000) goto L6;
        DataSet last = this.mCurDataSet;
        last.mSummedTime = totalTime;
        this.mCurDataSet = new DataSet();
        last.finish(this.mCurDataSet, now);
        System.arraycopy(this.mLastDataSets, 0, this.mLastDataSets, 1, this.mLastDataSets.length - 1);
        this.mLastDataSets[0] = last;
        return;
    }

    public void notePending(JobStatus job) {
        long now = JobSchedulerService.sUptimeMillisClock.millis();
        job.madePending = now;
        rebatchIfNeeded(now);
        this.mCurDataSet.incPending(job.getSourceUid(), job.getSourcePackageName(), now);
    }

    public void noteNonpending(JobStatus job) {
        long now = JobSchedulerService.sUptimeMillisClock.millis();
        this.mCurDataSet.decPending(job.getSourceUid(), job.getSourcePackageName(), now);
        rebatchIfNeeded(now);
    }

    public void noteActive(JobStatus job) {
        long now = JobSchedulerService.sUptimeMillisClock.millis();
        job.madeActive = now;
        rebatchIfNeeded(now);
        if (job.lastEvaluatedBias < 40) goto L5;
        this.mCurDataSet.incActiveTop(job.getSourceUid(), job.getSourcePackageName(), now);
    L7:
        if (job.getJob().isPeriodic() == false) goto L10;
        int r2 = 3;
    L9:
        int r4 = r2;
        addEvent(r4, job.getSourceUid(), job.getBatteryName(), job.getJobId(), 0, null);
        return;
    L10:
        r2 = 1;
        goto L9
    L5:
        this.mCurDataSet.incActive(job.getSourceUid(), job.getSourcePackageName(), now);
        goto L7
    }

    public void noteInactive(JobStatus job, int stopReason, String debugReason) {
        long now = JobSchedulerService.sUptimeMillisClock.millis();
        if (job.lastEvaluatedBias < 40) goto L5;
        this.mCurDataSet.decActiveTop(job.getSourceUid(), job.getSourcePackageName(), now, stopReason);
    L6:
        rebatchIfNeeded(now);
        if (job.getJob().isPeriodic() == false) goto L9;
        int r1 = 4;
    L10:
        addEvent(r1, job.getSourceUid(), job.getBatteryName(), job.getJobId(), stopReason, debugReason);
        return;
    L9:
        r1 = 2;
        goto L10
    L5:
        this.mCurDataSet.decActive(job.getSourceUid(), job.getSourcePackageName(), now, stopReason);
        goto L6
    }

    public void noteConcurrency(int totalActive, int fgActive) {
        if (totalActive <= this.mCurDataSet.mMaxTotalActive) goto L6;
        this.mCurDataSet.mMaxTotalActive = totalActive;
    L6:
        if (fgActive <= this.mCurDataSet.mMaxFgActive) goto L9;
        this.mCurDataSet.mMaxFgActive = fgActive;
        return;
    }

    public float getLoadFactor(JobStatus job) {
        int uid = job.getSourceUid();
        String pkg = job.getSourcePackageName();
        PackageEntry cur = this.mCurDataSet.getEntry(uid, pkg);
        if (this.mLastDataSets[0] == null) goto L5;
        PackageEntry last = this.mLastDataSets[0].getEntry(uid, pkg);
    L6:
        if (cur != null) goto L10;
        if (last != null) goto L10;
        return 0.0f;
    L10:
        long now = JobSchedulerService.sUptimeMillisClock.millis();
        long time = 0;
        if (cur == null) goto L13;
        time = 0 + (cur.getActiveTime(now) + cur.getPendingTime(now));
    L13:
        long period = this.mCurDataSet.getTotalTime(now);
        if (last == null) goto L17;
        time = time + (last.getActiveTime(now) + last.getPendingTime(now));
        period = period + this.mLastDataSets[0].getTotalTime(now);
    L17:
        return time / period;
    L5:
        last = null;
        goto L6
    }

    void dump(IndentingPrintWriter pw, int filterAppId) {
        long now = JobSchedulerService.sUptimeMillisClock.millis();
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        if (this.mLastDataSets[0] == null) goto L5;
        DataSet total = new DataSet(this.mLastDataSets[0]);
        this.mLastDataSets[0].addTo(total, now);
    L6:
        this.mCurDataSet.addTo(total, now);
        int i = 1;
    L8:
        if (i >= this.mLastDataSets.length) goto L14;
        if (this.mLastDataSets[i] == null) goto L12;
        IndentingPrintWriter pw2 = pw;
        int filterAppId2 = filterAppId;
        this.mLastDataSets[i].dump(pw2, "Historical stats", now, nowElapsed, filterAppId2);
        pw2.println();
    L13:
        i = i + 1;
        pw = pw2;
        filterAppId = filterAppId2;
        goto L8
    L12:
        pw2 = pw;
        filterAppId2 = filterAppId;
        goto L13
    L14:
        total.dump(pw, "Current stats", now, nowElapsed, filterAppId);
        return;
    L5:
        total = new DataSet(this.mCurDataSet);
        goto L6
    }

    public void dump(ProtoOutputStream proto, long fieldId, int filterUid) {
        long token = proto.start(fieldId);
        long now = JobSchedulerService.sUptimeMillisClock.millis();
        long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
        if (this.mLastDataSets[0] == null) goto L5;
        DataSet total = new DataSet(this.mLastDataSets[0]);
        this.mLastDataSets[0].addTo(total, now);
    L6:
        this.mCurDataSet.addTo(total, now);
        int i = 1;
    L8:
        if (i >= this.mLastDataSets.length) goto L13;
        if (this.mLastDataSets[i] == null) goto L12;
        this.mLastDataSets[i].dump(proto, 2246267895809L, now, nowElapsed, filterUid);
    L12:
        i = i + 1;
        goto L8
    L13:
        total.dump(proto, 1146756268034L, now, nowElapsed, filterUid);
        proto.end(token);
        return;
    L5:
        total = new DataSet(this.mCurDataSet);
        goto L6
    }

    boolean dumpHistory(IndentingPrintWriter pw, int filterAppId) {
        int size = this.mEventIndices.size();
        if (size > 0) goto L6;
        return false;
    L6:
        pw.increaseIndent();
        pw.println("Job history:");
        pw.decreaseIndent();
        long now = JobSchedulerService.sElapsedRealtimeClock.millis();
        int i = 0;
    L7:
        if (i >= size) goto L32;
        int index = this.mEventIndices.indexOf(i);
        int uid = this.mEventUids[index];
        if (filterAppId != (-1)) goto L11;
    L13:
        int cmd = this.mEventCmds[index] & 255;
        if (cmd == 0) goto L31;
        switch(cmd) {
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            default: goto L17;
        };
    L17:
        String label = "     ??";
    L22:
        TimeUtils.formatDuration(this.mEventTimes[index] - now, pw, 19);
        pw.print(" ");
        pw.print(label);
        pw.print(": #");
        UserHandle.formatUid(pw, uid);
        pw.print(SliceClientPermissions.SliceAuthority.DELIMITER);
        pw.print(this.mEventJobIds[index]);
        pw.print(" ");
        pw.print(this.mEventTags[index]);
        if (cmd != 2) goto L25;
    L26:
        pw.print(" ");
        String reason = this.mEventReasons[index];
        if (reason == null) goto L29;
        pw.print(this.mEventReasons[index]);
    L30:
        pw.println();
        goto L31
    L29:
        pw.print(JobParameters.getInternalReasonCodeDescription((this.mEventCmds[index] & EVENT_STOP_REASON_MASK) >> 8));
        goto L30
    L25:
        if (cmd != 4) goto L30;
    L18:
        label = " STOP-P";
        goto L22
    L19:
        label = "START-P";
        goto L22
    L20:
        label = "   STOP";
        goto L22
    L21:
        label = "  START";
    L31:
        i = i + 1;
        goto L7
    L11:
        if (filterAppId == UserHandle.getAppId(uid)) goto L13;
    L32:
        return true;
    }

    public void dumpHistory(ProtoOutputStream proto, long fieldId, int filterUid) {
        int size = this.mEventIndices.size();
        if (size != 0) goto L5;
        return;
    L5:
        long token = proto.start(fieldId);
        long now = JobSchedulerService.sElapsedRealtimeClock.millis();
        int i = 0;
    L6:
        if (i >= size) goto L22;
        int index = this.mEventIndices.indexOf(i);
        int uid = this.mEventUids[index];
        if (filterUid != (-1)) goto L10;
    L12:
        int cmd = this.mEventCmds[index] & 255;
        if (cmd == 0) goto L21;
        long heToken = proto.start(2246267895809L);
        proto.write(1159641169921L, cmd);
        proto.write(1112396529666L, now - this.mEventTimes[index]);
        proto.write(1120986464259L, uid);
        proto.write(1120986464260L, this.mEventJobIds[index]);
        proto.write(1138166333445L, this.mEventTags[index]);
        if (cmd != 2) goto L18;
    L19:
        proto.write(1159641169926L, (this.mEventCmds[index] & EVENT_STOP_REASON_MASK) >> 8);
    L20:
        proto.end(heToken);
        goto L21
    L18:
        if (cmd != 4) goto L20;
    L21:
        i = i + 1;
        size = size;
        goto L6
    L10:
        if (filterUid == UserHandle.getAppId(uid)) goto L12;
    L22:
        proto.end(token);
    }
}
