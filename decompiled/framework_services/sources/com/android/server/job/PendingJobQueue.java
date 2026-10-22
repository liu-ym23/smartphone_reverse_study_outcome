package com.android.server.job;

import android.util.ArraySet;
import android.util.Pools;
import android.util.SparseArray;
import com.android.server.job.controllers.JobStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes2.dex */
class PendingJobQueue {
    private final Pools.Pool<AppJobQueue> mAppJobQueuePool;
    private final SparseArray<AppJobQueue> mCurrentQueues;
    private boolean mNeedToResetIterators;
    private boolean mOptimizeIteration;
    private final PriorityQueue<AppJobQueue> mOrderedQueues;
    private int mPullCount;
    private int mSize;

    private static final class AppJobQueue {
        static final int NO_NEXT_OVERRIDE_STATE = -1;
        static final long NO_NEXT_TIMESTAMP = -1;
        private static final Pools.Pool<AdjustedJobStatus> mAdjustedJobStatusPool = null;
        private static final Comparator<AdjustedJobStatus> sJobComparator = null;
        private int mCurIndex;
        private final List<AdjustedJobStatus> mJobs;

        private static class AdjustedJobStatus {
            public long adjustedEnqueueTime;
            public JobStatus job;

            /* synthetic */ AdjustedJobStatus(PendingJobQueueIA r1) {
                this();
            }

            private AdjustedJobStatus() {
            }

            void clear() {
                this.adjustedEnqueueTime = 0;
                this.job = null;
            }
        }

        public static /* synthetic */ int $r8$lambda$g0OYYwC3jkCSkqvBk21tiP7tdvI(AdjustedJobStatus r0, AdjustedJobStatus r1) {
            return lambda$static$0(r0, r1);
        }

        /* synthetic */ AppJobQueue(PendingJobQueueIA r1) {
            this();
        }

        private AppJobQueue() {
            this.mJobs = new ArrayList();
            this.mCurIndex = 0;
        }

        static {
            sJobComparator = new PendingJobQueue$AppJobQueue$$ExternalSyntheticLambda0();
            mAdjustedJobStatusPool = new Pools.SimplePool(16);
        }

        private static /* synthetic */ int lambda$static$0(AdjustedJobStatus aj1, AdjustedJobStatus aj2) {
            if (aj1 != aj2) goto L5;
            return 0;
        L5:
            JobStatus job1 = aj1.job;
            JobStatus job2 = aj2.job;
            if (job1 != job2) goto L9;
            return 0;
        L9:
            if (job1.overrideState != job2.overrideState) goto L11;
            boolean job1UI = job1.getJob().isUserInitiated();
            boolean job2UI = job2.getJob().isUserInitiated();
            if (job1UI == job2UI) goto L17;
            if (job1UI == true) goto L16;
            return 1;
        L16:
            return -1;
        L17:
            boolean job1EJ = job1.isRequestedExpeditedJob();
            boolean job2EJ = job2.isRequestedExpeditedJob();
            if (job1EJ == job2EJ) goto L23;
            if (job1EJ == true) goto L21;
            return 1;
        L21:
            return -1;
        L23:
            if (Objects.equals(job1.getNamespace(), job2.getNamespace()) == false) goto L29;
            int job1Priority = job1.getEffectivePriority();
            int job2Priority = job2.getEffectivePriority();
            if (job1Priority == job2Priority) goto L29;
            return Integer.compare(job2Priority, job1Priority);
        L29:
            if (job1.lastEvaluatedBias == job2.lastEvaluatedBias) goto L33;
            return Integer.compare(job2.lastEvaluatedBias, job1.lastEvaluatedBias);
        L33:
            return Long.compare(job1.enqueueTime, job2.enqueueTime);
        L11:
            return Integer.compare(job2.overrideState, job1.overrideState);
        }

        void add(JobStatus jobStatus) {
            AdjustedJobStatus adjustedJobStatus = (AdjustedJobStatus) mAdjustedJobStatusPool.acquire();
            if (adjustedJobStatus != null) goto L5;
            adjustedJobStatus = new AdjustedJobStatus(null);
        L5:
            adjustedJobStatus.adjustedEnqueueTime = jobStatus.enqueueTime;
            adjustedJobStatus.job = jobStatus;
            int where = Collections.binarySearch(this.mJobs, adjustedJobStatus, sJobComparator);
            if (where >= 0) goto L8;
            where = ~where;
        L8:
            this.mJobs.add(where, adjustedJobStatus);
            if (where >= this.mCurIndex) goto L11;
            this.mCurIndex = where;
        L11:
            if (where <= 0) goto L13;
            long prevTimestamp = this.mJobs.get(where - 1).adjustedEnqueueTime;
            adjustedJobStatus.adjustedEnqueueTime = Math.max(prevTimestamp, adjustedJobStatus.adjustedEnqueueTime);
        L13:
            int numJobs = this.mJobs.size();
            if (where >= (numJobs - 1)) goto L21;
            int i = where;
        L16:
            if (i >= numJobs) goto L24;
            AdjustedJobStatus ajs = this.mJobs.get(i);
            if (adjustedJobStatus.adjustedEnqueueTime < ajs.adjustedEnqueueTime) goto L25;
            ajs.adjustedEnqueueTime = adjustedJobStatus.adjustedEnqueueTime;
            i = i + 1;
            goto L16
        L25:
            return;
        L24:
            return;
        }

        void addAll(List<JobStatus> jobs) {
            int earliestIndex = Integer.MAX_VALUE;
            int i = jobs.size() - 1;
        L3:
            if (i < 0) goto L14;
            JobStatus job = jobs.get(i);
            AdjustedJobStatus adjustedJobStatus = (AdjustedJobStatus) mAdjustedJobStatusPool.acquire();
            if (adjustedJobStatus != null) goto L7;
            adjustedJobStatus = new AdjustedJobStatus(null);
        L7:
            adjustedJobStatus.adjustedEnqueueTime = job.enqueueTime;
            adjustedJobStatus.job = job;
            int where = Collections.binarySearch(this.mJobs, adjustedJobStatus, sJobComparator);
            if (where >= 0) goto L10;
            where = ~where;
        L10:
            this.mJobs.add(where, adjustedJobStatus);
            if (where >= this.mCurIndex) goto L13;
            this.mCurIndex = where;
        L13:
            earliestIndex = Math.min(earliestIndex, where);
            i = i - 1;
            goto L3
        L14:
            int numJobs = this.mJobs.size();
            int i2 = Math.max(earliestIndex, 1);
        L15:
            if (i2 >= numJobs) goto L18;
            AdjustedJobStatus ajs = this.mJobs.get(i2);
            AdjustedJobStatus prev = this.mJobs.get(i2 - 1);
            ajs.adjustedEnqueueTime = Math.max(ajs.adjustedEnqueueTime, prev.adjustedEnqueueTime);
            i2 = i2 + 1;
            goto L15
        }

        void clear() {
            this.mJobs.clear();
            this.mCurIndex = 0;
        }

        boolean contains(JobStatus job) {
            if (indexOf(job) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        private int indexOf(JobStatus jobStatus) {
            int i = 0;
            int size = this.mJobs.size();
        L3:
            if (i >= size) goto L8;
            AdjustedJobStatus adjustedJobStatus = this.mJobs.get(i);
            if (adjustedJobStatus.job == jobStatus) goto L6;
            i = i + 1;
            goto L3
        L6:
            return i;
        L8:
            return -1;
        }

        JobStatus next() {
            if (this.mCurIndex < this.mJobs.size()) goto L6;
            return null;
        L6:
            List<AdjustedJobStatus> r0 = this.mJobs;
            int r1 = this.mCurIndex;
            this.mCurIndex = r1 + 1;
            return r0.get(r1).job;
        }

        int peekNextOverrideState() {
            if (this.mCurIndex < this.mJobs.size()) goto L7;
            return -1;
        L7:
            return this.mJobs.get(this.mCurIndex).job.overrideState;
        }

        long peekNextTimestamp() {
            if (this.mCurIndex < this.mJobs.size()) goto L7;
            return -1;
        L7:
            return this.mJobs.get(this.mCurIndex).adjustedEnqueueTime;
        }

        boolean remove(JobStatus jobStatus) {
            int idx = indexOf(jobStatus);
            if (idx >= 0) goto L6;
            return false;
        L6:
            AdjustedJobStatus adjustedJobStatus = this.mJobs.remove(idx);
            adjustedJobStatus.clear();
            mAdjustedJobStatusPool.release(adjustedJobStatus);
            if (idx >= this.mCurIndex) goto L9;
            this.mCurIndex--;
        L9:
            return true;
        }

        void resetIterator(long earliestEnqueueTime) {
            if (earliestEnqueueTime != 0) goto L5;
        L19:
            this.mCurIndex = 0;
            return;
        L5:
            if (this.mJobs.size() == 0) goto L19;
            int low = 0;
            int high = this.mJobs.size() - 1;
        L8:
            if (low >= high) goto L17;
            int mid = (low + high) >>> 1;
            AdjustedJobStatus midVal = this.mJobs.get(mid);
            if (midVal.adjustedEnqueueTime < earliestEnqueueTime) goto L11;
            if (midVal.adjustedEnqueueTime > earliestEnqueueTime) goto L14;
            high = mid;
            goto L8
        L14:
            high = mid - 1;
            goto L8
        L11:
            low = mid + 1;
            goto L8
        L17:
            this.mCurIndex = high;
        }

        int size() {
            return this.mJobs.size();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$M4BYHsJI5-OqL8hZ_zUrbsjiO-g, reason: not valid java name */
    public static /* synthetic */ int m4898$r8$lambda$M4BYHsJI5OqL8hZ_zUrbsjiOg(AppJobQueue r0, AppJobQueue r1) {
        return lambda$new$0(r0, r1);
    }

    PendingJobQueue() {
        this.mAppJobQueuePool = new Pools.SimplePool(8);
        this.mCurrentQueues = new SparseArray();
        this.mOrderedQueues = new PriorityQueue(new PendingJobQueue$$ExternalSyntheticLambda0());
        this.mSize = 0;
        this.mOptimizeIteration = true;
        this.mPullCount = 0;
        this.mNeedToResetIterators = false;
    }

    private static /* synthetic */ int lambda$new$0(AppJobQueue ajq1, AppJobQueue ajq2) {
        long t1 = ajq1.peekNextTimestamp();
        long t2 = ajq2.peekNextTimestamp();
        if (t1 != (-1)) goto L11;
        if (t2 != (-1)) goto L8;
        return 0;
    L8:
        return 1;
    L11:
        if (t2 != (-1)) goto L14;
        return -1;
    L14:
        int o1 = ajq1.peekNextOverrideState();
        int o2 = ajq2.peekNextOverrideState();
        if (o1 == o2) goto L19;
        return Integer.compare(o2, o1);
    L19:
        return Long.compare(t1, t2);
    }

    void add(JobStatus job) {
        AppJobQueue ajq = getAppJobQueue(job.getSourceUid(), true);
        long prevTimestamp = ajq.peekNextTimestamp();
        ajq.add(job);
        this.mSize++;
        if (prevTimestamp == ajq.peekNextTimestamp()) goto L6;
        this.mOrderedQueues.remove(ajq);
        this.mOrderedQueues.offer(ajq);
        return;
    }

    void addAll(ArraySet<JobStatus> jobs) {
        SparseArray<List<JobStatus>> jobsByUid = new SparseArray();
        int i = jobs.size() - 1;
    L3:
        if (i < 0) goto L8;
        JobStatus job = jobs.valueAt(i);
        List<JobStatus> appJobs = jobsByUid.get(job.getSourceUid());
        if (appJobs != null) goto L7;
        appJobs = new ArrayList();
        jobsByUid.put(job.getSourceUid(), appJobs);
    L7:
        appJobs.add(job);
        i = i - 1;
        goto L3
    L8:
        int i2 = jobsByUid.size();
        int i3 = i2 - 1;
    L9:
        if (i3 < 0) goto L11;
        AppJobQueue ajq = getAppJobQueue(jobsByUid.keyAt(i3), true);
        ajq.addAll(jobsByUid.valueAt(i3));
        i3 = i3 - 1;
        goto L9
    L11:
        int i4 = this.mSize;
        this.mSize = i4 + jobs.size();
        this.mOrderedQueues.clear();
    }

    void clear() {
        this.mSize = 0;
        int i = this.mCurrentQueues.size() - 1;
    L3:
        if (i < 0) goto L5;
        AppJobQueue ajq = this.mCurrentQueues.valueAt(i);
        ajq.clear();
        this.mAppJobQueuePool.release(ajq);
        i = i - 1;
        goto L3
    L5:
        this.mCurrentQueues.clear();
        this.mOrderedQueues.clear();
    }

    boolean contains(JobStatus job) {
        AppJobQueue ajq = this.mCurrentQueues.get(job.getSourceUid());
        if (ajq != null) goto L7;
        return false;
    L7:
        return ajq.contains(job);
    }

    private AppJobQueue getAppJobQueue(int uid, boolean create) {
        AppJobQueue ajq = this.mCurrentQueues.get(uid);
        if (ajq != null) goto L9;
        if (create == false) goto L9;
        ajq = (AppJobQueue) this.mAppJobQueuePool.acquire();
        if (ajq != null) goto L8;
        ajq = new AppJobQueue(null);
    L8:
        this.mCurrentQueues.put(uid, ajq);
    L9:
        return ajq;
    }

    JobStatus next() {
        if (this.mNeedToResetIterators == false) goto L9;
        this.mOrderedQueues.clear();
        int i = this.mCurrentQueues.size() - 1;
    L5:
        if (i < 0) goto L7;
        AppJobQueue ajq = this.mCurrentQueues.valueAt(i);
        ajq.resetIterator(0);
        this.mOrderedQueues.offer(ajq);
        i = i - 1;
        goto L5
    L7:
        this.mNeedToResetIterators = false;
        this.mPullCount = 0;
    L14:
        int numQueues = this.mOrderedQueues.size();
        if (numQueues != 0) goto L18;
        return null;
    L18:
        if (this.mOptimizeIteration == false) goto L20;
        int pullLimit = Math.min(3, ((numQueues - 1) >>> 2) + 1);
    L21:
        AppJobQueue earliestQueue = this.mOrderedQueues.peek();
        if (earliestQueue == null) goto L35;
        JobStatus job = earliestQueue.next();
        int r6 = this.mPullCount + 1;
        this.mPullCount = r6;
        if (r6 >= pullLimit) goto L30;
        if (job == null) goto L29;
        if (earliestQueue.peekNextOverrideState() != job.overrideState) goto L30;
    L29:
        if (earliestQueue.peekNextTimestamp() == (-1)) goto L30;
    L34:
        return job;
    L30:
        this.mOrderedQueues.poll();
        if (earliestQueue.peekNextTimestamp() == (-1)) goto L33;
        this.mOrderedQueues.offer(earliestQueue);
    L33:
        this.mPullCount = 0;
        goto L34
    L35:
        return null;
    L20:
        pullLimit = 1;
        goto L21
    L9:
        if (this.mOrderedQueues.size() != 0) goto L14;
        int i2 = this.mCurrentQueues.size() - 1;
    L11:
        if (i2 < 0) goto L13;
        this.mOrderedQueues.offer(this.mCurrentQueues.valueAt(i2));
        i2 = i2 - 1;
        goto L11
    L13:
        this.mPullCount = 0;
        goto L14
    }

    boolean remove(JobStatus job) {
        AppJobQueue ajq = getAppJobQueue(job.getSourceUid(), false);
        if (ajq != null) goto L5;
        return false;
    L5:
        long prevTimestamp = ajq.peekNextTimestamp();
        if (ajq.remove(job) == true) goto L8;
        return false;
    L8:
        this.mSize--;
        if (ajq.size() != 0) goto L12;
        this.mCurrentQueues.remove(job.getSourceUid());
        this.mOrderedQueues.remove(ajq);
        ajq.clear();
        this.mAppJobQueuePool.release(ajq);
    L14:
        return true;
    L12:
        if (prevTimestamp == ajq.peekNextTimestamp()) goto L14;
        this.mOrderedQueues.remove(ajq);
        this.mOrderedQueues.offer(ajq);
        goto L14
    }

    void resetIterator() {
        this.mNeedToResetIterators = true;
    }

    void setOptimizeIteration(boolean optimize) {
        this.mOptimizeIteration = optimize;
    }

    int size() {
        return this.mSize;
    }
}
