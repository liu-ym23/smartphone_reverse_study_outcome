package com.android.server.job;

import android.app.job.JobInfo;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Environment;
import android.os.Handler;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SystemConfigFileCommitEventLogger;
import android.util.Xml;
import com.android.internal.util.jobs.ArrayUtils;
import com.android.internal.util.jobs.BitUtils;
import com.android.modules.expresslog.Histogram;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.server.AppSchedulingModuleThread;
import com.android.server.IoThread;
import com.android.server.content.SyncJobService;
import com.android.server.job.controllers.JobStatus;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.Settings;
import com.android.server.power.teardown.swteardown.EventTeardownResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;
import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public final class JobStore {
    private static final int ALL_UIDS = -1;
    private static final boolean DEBUG = false;
    static final int INVALID_UID = -2;
    private static final int JOBS_FILE_VERSION = 1;
    static final String JOB_FILE_SPLIT_PREFIX = "jobs_";
    private static final long JOB_PERSIST_DELAY = 2000;
    private static final long SCHEDULED_JOB_HIGH_WATER_MARK_PERIOD_MS = 1800000;
    private static final Pattern SPLIT_FILE_PATTERN = null;
    private static final String TAG = "JobStore";
    private static final String XML_TAG_DEBUG_INFO = "debug-info";
    private static final String XML_TAG_DEBUG_TAG = "debug-tag";
    private static final String XML_TAG_EXTRAS = "extras";
    private static final String XML_TAG_JOB = "job";
    private static final String XML_TAG_JOB_INFO = "job-info";
    private static final String XML_TAG_JOB_WORK_ITEM = "job-work-item";
    private static final String XML_TAG_ONEOFF = "one-off";
    private static final String XML_TAG_PARAMS_CONSTRAINTS = "constraints";
    private static final String XML_TAG_PERIODIC = "periodic";
    private static final Histogram sScheduledJob30MinHighWaterMarkLogger = null;
    private static JobStore sSingleton;
    private static final Object sSingletonLock = null;
    final Context mContext;
    private int mCurrentJobSetSize;
    private final SystemConfigFileCommitEventLogger mEventLogger;
    private final Handler mIoHandler;
    private final File mJobFileDirectory;
    final JobSet mJobSet;
    private final AtomicFile mJobsFile;
    final Object mLock;
    private final SparseBooleanArray mPendingJobWriteUids;
    private JobSchedulerInternal.JobStorePersistStats mPersistInfo;
    private boolean mRtcGood;
    private int mScheduledJob30MinHighWaterMark;
    private final Runnable mScheduledJobHighWaterMarkLoggingRunnable;
    private boolean mSplitFileMigrationNeeded;
    private boolean mUseSplitFiles;
    private boolean mWriteInProgress;
    private final Runnable mWriteRunnable;
    final Object mWriteScheduleLock;
    private boolean mWriteScheduled;
    private final long mXmlTimestamp;

    public static final class JobSet {
        final SparseArray<ArraySet<JobStatus>> mJobs;
        final SparseArray<ArraySet<JobStatus>> mJobsPerSourceUid;

        public static /* synthetic */ boolean $r8$lambda$Ogrjy8cbnKakGMK8Ug9l_r3Ikrk(int[] r0, JobStatus r1) {
            return lambda$removeJobsOfUnlistedUsers$0(r0, r1);
        }

        public static /* synthetic */ boolean $r8$lambda$RA6YfP6IBdA_T2lAW98eyR1LWXw(int[] r0, JobStatus r1) {
            return lambda$removeJobsOfUnlistedUsers$1(r0, r1);
        }

        public JobSet() {
            this.mJobs = new SparseArray();
            this.mJobsPerSourceUid = new SparseArray();
        }

        public ArraySet<JobStatus> getJobsByUid(int uid) {
            ArraySet<JobStatus> matchingJobs = new ArraySet();
            getJobsByUid(uid, matchingJobs);
            return matchingJobs;
        }

        public void getJobsByUid(int uid, Set<JobStatus> insertInto) {
            ArraySet<JobStatus> jobs = this.mJobs.get(uid);
            if (jobs == null) goto L6;
            insertInto.addAll(jobs);
            return;
        }

        public ArraySet<JobStatus> getJobsBySourceUid(int sourceUid) {
            ArraySet<JobStatus> result = new ArraySet();
            getJobsBySourceUid(sourceUid, result);
            return result;
        }

        public void getJobsBySourceUid(int sourceUid, Set<JobStatus> insertInto) {
            ArraySet<JobStatus> jobs = this.mJobsPerSourceUid.get(sourceUid);
            if (jobs == null) goto L6;
            insertInto.addAll(jobs);
            return;
        }

        public boolean add(JobStatus job) {
            int uid = job.getUid();
            int sourceUid = job.getSourceUid();
            ArraySet<JobStatus> jobs = this.mJobs.get(uid);
            if (jobs != null) goto L5;
            jobs = new ArraySet();
            this.mJobs.put(uid, jobs);
        L5:
            ArraySet<JobStatus> jobsForSourceUid = this.mJobsPerSourceUid.get(sourceUid);
            if (jobsForSourceUid != null) goto L8;
            jobsForSourceUid = new ArraySet();
            this.mJobsPerSourceUid.put(sourceUid, jobsForSourceUid);
        L8:
            boolean added = jobs.add(job);
            boolean addedInSource = jobsForSourceUid.add(job);
            if (added == addedInSource) goto L11;
            Slog.wtf(JobStore.TAG, "mJobs and mJobsPerSourceUid mismatch; caller= " + added + " source= " + addedInSource);
        L11:
            if (added == true) goto L15;
            if (addedInSource == true) goto L15;
            return false;
        L15:
            return true;
        }

        public boolean remove(JobStatus job) {
            int uid = job.getUid();
            ArraySet<JobStatus> jobs = this.mJobs.get(uid);
            int sourceUid = job.getSourceUid();
            ArraySet<JobStatus> jobsForSourceUid = this.mJobsPerSourceUid.get(sourceUid);
            if (jobs != null) goto L5;
        L7:
            boolean didRemove = false;
        L8:
            if (jobsForSourceUid != null) goto L10;
        L12:
            boolean sourceRemove = false;
        L13:
            if (didRemove == sourceRemove) goto L15;
            Slog.wtf(JobStore.TAG, "Job presence mismatch; caller=" + didRemove + " source=" + sourceRemove);
        L15:
            if (didRemove == true) goto L19;
            if (sourceRemove == true) goto L19;
            return false;
        L19:
            if (jobs != null) goto L21;
        L23:
            if (jobsForSourceUid != null) goto L25;
        L27:
            return true;
        L25:
            if (jobsForSourceUid.size() != 0) goto L27;
            this.mJobsPerSourceUid.remove(sourceUid);
            goto L27
        L21:
            if (jobs.size() != 0) goto L23;
            this.mJobs.remove(uid);
            goto L23
        L10:
            if (jobsForSourceUid.remove(job) == false) goto L12;
            sourceRemove = true;
            goto L13
        L5:
            if (jobs.remove(job) == false) goto L7;
            didRemove = true;
            goto L8
        }

        public void removeJobsOfUnlistedUsers(final int[] keepUserIds) {
            Predicate<JobStatus> noSourceUser = new JobStore$JobSet$$ExternalSyntheticLambda0(keepUserIds);
            Predicate<JobStatus> noCallingUser = new JobStore$JobSet$$ExternalSyntheticLambda1(keepUserIds);
            removeAll(noSourceUser.or(noCallingUser));
        }

        private static /* synthetic */ boolean lambda$removeJobsOfUnlistedUsers$0(int[] keepUserIds, JobStatus job) {
            return !ArrayUtils.contains(keepUserIds, job.getSourceUserId());
        }

        private static /* synthetic */ boolean lambda$removeJobsOfUnlistedUsers$1(int[] keepUserIds, JobStatus job) {
            return !ArrayUtils.contains(keepUserIds, job.getUserId());
        }

        private void removeAll(Predicate<JobStatus> predicate) {
            int jobSetIndex = this.mJobs.size() - 1;
        L3:
            if (jobSetIndex < 0) goto L8;
            ArraySet<JobStatus> jobs = this.mJobs.valueAt(jobSetIndex);
            jobs.removeIf(predicate);
            if (jobs.size() != 0) goto L7;
            this.mJobs.removeAt(jobSetIndex);
        L7:
            jobSetIndex = jobSetIndex - 1;
            goto L3
        L8:
            int jobSetIndex2 = this.mJobsPerSourceUid.size() - 1;
        L9:
            if (jobSetIndex2 < 0) goto L15;
            ArraySet<JobStatus> jobs2 = this.mJobsPerSourceUid.valueAt(jobSetIndex2);
            jobs2.removeIf(predicate);
            if (jobs2.size() != 0) goto L13;
            this.mJobsPerSourceUid.removeAt(jobSetIndex2);
        L13:
            jobSetIndex2 = jobSetIndex2 - 1;
            goto L9
        }

        public boolean contains(JobStatus job) {
            int uid = job.getUid();
            ArraySet<JobStatus> jobs = this.mJobs.get(uid);
            if (jobs != null) goto L5;
        L7:
            return false;
        L5:
            if (jobs.contains(job) == false) goto L7;
            return true;
        }

        public JobStatus get(int uid, String namespace, int jobId) {
            ArraySet<JobStatus> jobs = this.mJobs.get(uid);
            if (jobs == null) goto L12;
            int i = jobs.size() - 1;
        L5:
            if (i < 0) goto L18;
            JobStatus job = jobs.valueAt(i);
            if (job.getJobId() != jobId) goto L11;
            if (Objects.equals(namespace, job.getNamespace()) == false) goto L11;
            return job;
        L11:
            i = i - 1;
            goto L5
        L18:
            return null;
        L12:
            return null;
        }

        public List<JobStatus> getAllJobs() {
            ArrayList<JobStatus> allJobs = new ArrayList(size());
            int i = this.mJobs.size() - 1;
        L3:
            if (i < 0) goto L11;
            ArraySet<JobStatus> jobs = this.mJobs.valueAt(i);
            if (jobs == null) goto L9;
            int j = jobs.size() - 1;
        L7:
            if (j < 0) goto L9;
            allJobs.add(jobs.valueAt(j));
            j = j - 1;
        L9:
            i = i - 1;
            goto L3
        L11:
            return allJobs;
        }

        public void clear() {
            this.mJobs.clear();
            this.mJobsPerSourceUid.clear();
        }

        public int size() {
            int total = 0;
            int i = this.mJobs.size() - 1;
        L3:
            if (i < 0) goto L6;
            total = total + this.mJobs.valueAt(i).size();
            i = i - 1;
            goto L3
        L6:
            return total;
        }

        public int countJobsForUid(int uid) {
            int total = 0;
            ArraySet<JobStatus> jobs = this.mJobs.get(uid);
            if (jobs == null) goto L10;
            int i = jobs.size() - 1;
        L5:
            if (i < 0) goto L10;
            JobStatus job = jobs.valueAt(i);
            if (job.getUid() != job.getSourceUid()) goto L9;
            total = total + 1;
        L9:
            i = i - 1;
        L10:
            return total;
        }

        public void forEachJob(Predicate<JobStatus> filterPredicate, Consumer<JobStatus> functor) {
            int uidIndex = this.mJobs.size() - 1;
        L3:
            if (uidIndex < 0) goto L16;
            ArraySet<JobStatus> jobs = this.mJobs.valueAt(uidIndex);
            if (jobs == null) goto L14;
            int i = jobs.size() - 1;
        L7:
            if (i < 0) goto L14;
            JobStatus jobStatus = jobs.valueAt(i);
            if (filterPredicate != null) goto L11;
        L12:
            functor.accept(jobStatus);
        L13:
            i = i - 1;
            goto L7
        L11:
            if (filterPredicate.test(jobStatus) == false) goto L13;
        L14:
            uidIndex = uidIndex - 1;
            goto L3
        }

        public void forEachJob(int callingUid, Consumer<JobStatus> functor) {
            ArraySet<JobStatus> jobs = this.mJobs.get(callingUid);
            if (jobs == null) goto L7;
            int i = jobs.size() - 1;
        L5:
            if (i < 0) goto L9;
            functor.accept(jobs.valueAt(i));
            i = i - 1;
            goto L5
        L9:
            return;
        }

        public void forEachJobForSourceUid(int sourceUid, Consumer<JobStatus> functor) {
            ArraySet<JobStatus> jobs = this.mJobsPerSourceUid.get(sourceUid);
            if (jobs == null) goto L7;
            int i = jobs.size() - 1;
        L5:
            if (i < 0) goto L9;
            functor.accept(jobs.valueAt(i));
            i = i - 1;
            goto L5
        L9:
            return;
        }
    }

    private final class ReadJobMapFromDiskRunnable implements Runnable {
        private final JobSet jobSet;
        private final CountDownLatch mCompletionLatch;
        private final boolean rtcGood;
        final /* synthetic */ JobStore this$0;

        ReadJobMapFromDiskRunnable(JobStore r2, JobSet jobSet, boolean rtcIsGood) {
            this(r2, jobSet, rtcIsGood, null);
        }

        ReadJobMapFromDiskRunnable(JobStore r1, JobSet jobSet, boolean rtcIsGood, CountDownLatch completionLatch) {
            this.this$0 = r1;
            this.jobSet = jobSet;
            this.rtcGood = rtcIsGood;
            this.mCompletionLatch = completionLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (JobStore.m4873$$Nest$fgetmJobFileDirectory(this.this$0).isDirectory() == true) goto L167;
            Slog.wtf(JobStore.TAG, "jobs directory isn't a directory O.O");
            JobStore.m4873$$Nest$fgetmJobFileDirectory(this.this$0).mkdirs();
            return;
        L167:
            File[] files = JobStore.m4873$$Nest$fgetmJobFileDirectory(this.this$0).listFiles();     // Catch: SecurityException -> L138
            if (files != null) goto L12;
            Slog.wtfStack(JobStore.TAG, "Couldn't get job file list");
            return;
        L12:
            long nowElapsed = JobSchedulerService.sElapsedRealtimeClock.millis();
            Object r10 = this.this$0.mLock;
            monitor-enter(r10);
            int r11 = files.length;     // Catch: Throwable -> L132
            int numDuplicates = 0;
            int numDuplicates2 = 0;
            int numSyncJobs = 0;
            int numSystemJobs = 0;
            int numJobs = 0;
            int numJobs2 = 0;
        L16:
            if (numJobs2 >= r11) goto L161;
            File file = files[numJobs2];     // Catch: Throwable -> L94
            if (file.getName().equals("jobs.xml") == false) goto L159;
        L24:
            AtomicFile aFile = JobStore.m4886$$Nest$mcreateJobFile(this.this$0, file);     // Catch: Throwable -> L94
            FileInputStream fis = aFile.openRead();     // Catch: Throwable -> L94 Exception -> L96 Throwable -> L100 FileNotFoundException -> L103
            goto L104
        L155:
            List<JobStatus> jobs = readJobMapImpl(fis, this.rtcGood, nowElapsed);     // Catch: Throwable -> L77
            if (jobs == null) goto L64;
            int r16 = numJobs2;
            int numJobs3 = 0;
        L31:
            int numJobs4 = numJobs;
            int numJobs5 = jobs.size();     // Catch: Throwable -> L61
            if (numJobs3 >= numJobs5) goto L63;
            JobStatus js = jobs.get(numJobs3);     // Catch: Throwable -> L61
            List<JobStatus> jobs2 = jobs;
            JobSet r0 = this.jobSet;     // Catch: Throwable -> L61
            int i = numJobs3;
            int i2 = js.getUid();     // Catch: Throwable -> L61
            int numSystemJobs2 = numSystemJobs;
            File[] files2 = files;
            JobStatus existingJob = r0.get(i2, js.getNamespace(), js.getJobId());     // Catch: Throwable -> L57
            if (existingJob == null) goto L41;
            numDuplicates = numDuplicates + 1;     // Catch: Throwable -> L57
            numJobs = numJobs4;
            numSystemJobs = numSystemJobs2;
        L54:
            numJobs3 = i + 1;
            jobs = jobs2;
            files = files2;
            goto L31
        L41:
            js.prepareLocked();     // Catch: Throwable -> L57
            js.enqueueTime = nowElapsed;     // Catch: Throwable -> L57
            this.jobSet.add(js);     // Catch: Throwable -> L57
            int numJobs6 = numJobs4 + 1;
            if (js.getUid() != 1000) goto L53;
            numSystemJobs = numSystemJobs2 + 1;
            if (JobStore.m4894$$Nest$smisSyncJob(js) == false) goto L50;
            numSyncJobs = numSyncJobs + 1;
            numJobs = numJobs6;
            goto L54
        L50:
            numJobs = numJobs6;
        L51:
            th = move-exception;
            numJobs4 = numJobs6;
            int numJobs7 = numSystemJobs;
            int numSystemJobs3 = numSyncJobs;
            Throwable r2 = th;
        L79:
            if (fis != null) goto L141;
        L93:
            throw r2;     // Catch: Throwable -> L84 Exception -> L86 Throwable -> L88 FileNotFoundException -> L90
        L88:
            e = e;
            int i3 = numJobs4;
        L102:
            Slog.wtf(JobStore.TAG, "Error in " + file.getName(), e);     // Catch: Throwable -> L68
        L107:
            if (JobStore.m4880$$Nest$fgetmUseSplitFiles(this.this$0) == false) goto L112;
            if (file.getName().startsWith(JobStore.JOB_FILE_SPLIT_PREFIX) == true) goto L114;
            numDuplicates2 = 1;
            numSyncJobs = numSystemJobs3;
            numSystemJobs = numJobs7;
            numJobs = i3;
        L115:
            numJobs2 = r16 + 1;
            files = files2;
        L114:
            numSyncJobs = numSystemJobs3;
            numSystemJobs = numJobs7;
            numJobs = i3;
            goto L115
        L112:
            if (file.getName().startsWith(JobStore.JOB_FILE_SPLIT_PREFIX) == false) goto L114;
            numDuplicates2 = 1;
            numSyncJobs = numSystemJobs3;
            numSystemJobs = numJobs7;
            numJobs = i3;
        L86:
            e = e;
            i3 = numJobs4;
        L143:
            Slog.wtf(JobStore.TAG, "Unexpected exception", e);     // Catch: Throwable -> L68
        L68:
            th = th;
        L149:
            monitor-exit(r10);     // Catch: Throwable -> L136
            throw th;
        L136:
            th = th;
        L84:
            th = th;
        L91:
            i3 = numJobs4;
        L105:
            Slog.e(JobStore.TAG, "Could not find jobs file: " + file.getName());     // Catch: Throwable -> L68
            goto L107
        L141:
            fis.close();     // Catch: Throwable -> L82
        L82:
            th = move-exception;
            r2.addSuppressed(th);     // Catch: Throwable -> L84 Exception -> L86 Throwable -> L88 FileNotFoundException -> L90
            goto L93
        L53:
            numJobs = numJobs6;
            numSystemJobs = numSystemJobs2;
        L55:
            th = move-exception;
            numJobs4 = numJobs6;
            numSystemJobs3 = numSyncJobs;
            numJobs7 = numSystemJobs2;
            r2 = th;
        L57:
            th = move-exception;
            r2 = th;
            numSystemJobs3 = numSyncJobs;
            numJobs7 = numSystemJobs2;
        L59:
            th = move-exception;
            files2 = files;
            r2 = th;
            numSystemJobs3 = numSyncJobs;
            numJobs7 = numSystemJobs2;
            goto L79
        L63:
            files2 = files;
            i3 = numJobs4;
            numJobs7 = numSystemJobs;
            numSystemJobs3 = numSyncJobs;
        L65:
            if (fis == null) goto L107;
            fis.close();     // Catch: Throwable -> L68 Exception -> L70 Throwable -> L72 FileNotFoundException -> L74
        L72:
            e = e;
        L70:
            e = e;
        L61:
            th = move-exception;
            int r20 = numSystemJobs;
            files2 = files;
            r2 = th;
            numSystemJobs3 = numSyncJobs;
            numJobs7 = r20;
            goto L79
        L64:
            r16 = numJobs2;
            files2 = files;
            i3 = numJobs;
            numJobs7 = numSystemJobs;
            numSystemJobs3 = numSyncJobs;
        L77:
            th = move-exception;
            r16 = numJobs2;
            files2 = files;
            r2 = th;
            numJobs4 = numJobs;
            numJobs7 = numSystemJobs;
            numSystemJobs3 = numSyncJobs;
        L100:
            e = e;
            r16 = numJobs2;
            files2 = files;
            i3 = numJobs;
            numJobs7 = numSystemJobs;
            numSystemJobs3 = numSyncJobs;
        L96:
            e = e;
            r16 = numJobs2;
            files2 = files;
            i3 = numJobs;
            numJobs7 = numSystemJobs;
            numSystemJobs3 = numSyncJobs;
        L104:
            r16 = numJobs2;
            files2 = files;
            i3 = numJobs;
            numJobs7 = numSystemJobs;
            numSystemJobs3 = numSyncJobs;
            goto L105
        L159:
            if (JobStore.m4891$$Nest$sfgetSPLIT_FILE_PATTERN().matcher(file.getName()).matches() == true) goto L24;
            r16 = numJobs2;
            files2 = files;
        L22:
            th = th;
        L94:
            th = th;
            goto L149
        L161:
        L120:
            th = th;
            goto L149
        L118:
            if (JobStore.m4876$$Nest$fgetmPersistInfo(this.this$0).countAllJobsLoaded >= 0) goto L122;
            JobStore.m4876$$Nest$fgetmPersistInfo(this.this$0).countAllJobsLoaded = numJobs;     // Catch: Throwable -> L120
            JobStore.m4876$$Nest$fgetmPersistInfo(this.this$0).countSystemServerJobsLoaded = numSystemJobs;     // Catch: Throwable -> L120
            JobStore.m4876$$Nest$fgetmPersistInfo(this.this$0).countSystemSyncManagerJobsLoaded = numSyncJobs;     // Catch: Throwable -> L120
        L122:
            monitor-exit(r10);     // Catch: Throwable -> L120
            Slog.i(JobStore.TAG, "Read " + numJobs + " jobs");
            if (numDuplicates2 == 0) goto L126;
            JobStore.m4889$$Nest$mmigrateJobFilesAsync(this.this$0);
        L126:
            if (numDuplicates <= 0) goto L128;
            Slog.wtf(JobStore.TAG, "Encountered " + numDuplicates + " duplicate persisted jobs");
        L128:
            JobStore.m4882$$Nest$fputmCurrentJobSetSize(this.this$0, numJobs);
            JobStore.m4883$$Nest$fputmScheduledJob30MinHighWaterMark(this.this$0, JobStore.m4871$$Nest$fgetmCurrentJobSetSize(this.this$0));
            JobStore.m4878$$Nest$fgetmScheduledJobHighWaterMarkLoggingRunnable(this.this$0).run();
            if (this.mCompletionLatch == null) goto L187;
            this.mCompletionLatch.countDown();
            return;
        L187:
            return;
        L132:
            th = th;
        L138:
            e = move-exception;
            Slog.wtf(JobStore.TAG, "Not allowed to read job file directory", e);
        }

        private static String intern(String val) {
            if (val != null) goto L5;
            return null;
        L5:
            return val.intern();
        }

        private List<JobStatus> readJobMapImpl(InputStream fis, boolean rtcIsGood, long nowElapsed) throws XmlPullParserException, IOException {
            TypedXmlPullParser parser = Xml.resolvePullParser(fis);
            int eventType = parser.getEventType();
        L4:
            if (eventType == 2) goto L8;
            if (eventType == 1) goto L8;
            eventType = parser.next();
            Slog.d(JobStore.TAG, "Start tag: " + parser.getName());
        L8:
            if (eventType == 1) goto L10;
            String tagName = parser.getName();
            if (JobStore.XML_TAG_JOB_INFO.equals(tagName) == false) goto L36;
            List<JobStatus> jobs = new ArrayList();
            int version = parser.getAttributeInt(null, "version");
            if (version > 1) goto L34;
            if (version < 0) goto L34;
            int eventType2 = parser.next();
            int eventType3 = eventType2;
        L20:
            if (eventType3 != 2) goto L31;
            String tagName2 = parser.getName();
            if ("job".equals(tagName2) == false) goto L31;
            int version2 = version;
            JobStatus persistedJob = restoreJobFromXml(rtcIsGood, parser, version2, nowElapsed);
            version = version2;
            if (persistedJob != null) goto L26;
            Slog.d(JobStore.TAG, "Error reading job from file.");
            goto L31
        L26:
            if (JobStore.m4890$$Nest$sfgetDEBUG() == false) goto L28;
            Slog.d(JobStore.TAG, "Read out " + persistedJob);
        L28:
            jobs.add(persistedJob);
        L31:
            eventType3 = parser.next();
            if (eventType3 != 1) goto L20;
            return jobs;
        L34:
            Slog.d(JobStore.TAG, "Invalid version number, aborting jobs file read.");
            return null;
        L36:
            return null;
        L10:
            if (JobStore.m4890$$Nest$sfgetDEBUG() == false) goto L12;
            Slog.d(JobStore.TAG, "No persisted jobs.");
        L12:
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v23, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r33v1, types: [com.android.server.job.controllers.JobStatus] */
        /* JADX WARN: Type inference failed for: r33v10 */
        /* JADX WARN: Type inference failed for: r33v11 */
        /* JADX WARN: Type inference failed for: r33v12 */
        /* JADX WARN: Type inference failed for: r33v13 */
        /* JADX WARN: Type inference failed for: r33v14 */
        /* JADX WARN: Type inference failed for: r33v15 */
        /* JADX WARN: Type inference failed for: r33v16, types: [com.android.server.job.controllers.JobStatus] */
        /* JADX WARN: Type inference failed for: r33v2, types: [com.android.server.job.controllers.JobStatus] */
        /* JADX WARN: Type inference failed for: r33v20 */
        /* JADX WARN: Type inference failed for: r33v21 */
        /* JADX WARN: Type inference failed for: r33v25 */
        /* JADX WARN: Type inference failed for: r33v26, types: [com.android.server.job.controllers.JobStatus] */
        /* JADX WARN: Type inference failed for: r33v27 */
        /* JADX WARN: Type inference failed for: r33v28 */
        /* JADX WARN: Type inference failed for: r33v29 */
        /* JADX WARN: Type inference failed for: r33v3, types: [com.android.server.job.controllers.JobStatus] */
        /* JADX WARN: Type inference failed for: r33v4, types: [com.android.server.job.controllers.JobStatus] */
        /* JADX WARN: Type inference failed for: r33v5, types: [com.android.server.job.controllers.JobStatus] */
        /* JADX WARN: Type inference failed for: r33v6 */
        /* JADX WARN: Type inference failed for: r33v7, types: [com.android.server.job.controllers.JobStatus] */
        /* JADX WARN: Type inference failed for: r33v8 */
        /* JADX WARN: Type inference failed for: r8v0 */
        /* JADX WARN: Type inference failed for: r8v1, types: [com.android.server.job.controllers.JobStatus, java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v11 */
        private JobStatus restoreJobFromXml(boolean r41, TypedXmlPullParser r42, int r43, long r44) throws XmlPullParserException, IOException {
            ?? r8 = 0;
            JobInfo.Builder r0 = buildBuilderFromXml(r42);     // Catch: NumberFormatException -> L9
            r0.setPersisted(true);     // Catch: NumberFormatException -> L9
            int r10 = Integer.parseInt(r42.getAttributeValue(null, "uid"));     // Catch: NumberFormatException -> L9
            if (r43 != 0) goto L11;
            String r1 = r42.getAttributeValue(null, "priority");     // Catch: NumberFormatException -> L9
            if (r1 == null) goto L18;
            r0.setBias(Integer.parseInt(r1));     // Catch: NumberFormatException -> L9
        L18:
            String r2 = r42.getAttributeValue(null, "flags");     // Catch: NumberFormatException -> L9
            if (r2 == null) goto L21;
            r0.setFlags(Integer.parseInt(r2));     // Catch: NumberFormatException -> L9
        L21:
            String r11 = r42.getAttributeValue(null, "internalFlags");     // Catch: NumberFormatException -> L9
            if (r11 == null) goto L25;
            int r30 = Integer.parseInt(r11);     // Catch: NumberFormatException -> L9
        L185:
            String r3 = r42.getAttributeValue(null, "sourceUserId");     // Catch: NumberFormatException -> L181
            if (r3 != null) goto L30;
            int r7 = -1;
        L29:
            int r15 = r7;
            String r9 = r42.getAttributeValue(null, "lastSuccessfulRunTime");     // Catch: NumberFormatException -> L181
            if (r9 != null) goto L34;
            long r23 = 0;
        L35:
            String r4 = r42.getAttributeValue(null, "lastFailedRunTime");     // Catch: NumberFormatException -> L181
            if (r4 != null) goto L38;
            long r25 = 0;
        L39:
            long r27 = r42.getAttributeLong(null, "cumulativeExecutionTime", 0);     // Catch: NumberFormatException -> L181
            String r12 = r42.getAttributeValue(null, "sourcePackageName");
            String r17 = intern(r42.getAttributeValue(null, "namespace"));
            String r18 = intern(r42.getAttributeValue(null, "sourceTag"));
        L41:
            int r13 = r42.next();
            if (r13 != 4) goto L44;
            r8 = 0;
            goto L41
        L44:
            if (r13 != 2) goto L179;
            if (JobStore.XML_TAG_PARAMS_CONSTRAINTS.equals(r42.getName()) == false) goto L215;
            buildConstraintsFromXml(r0, r42);     // Catch: IllegalArgumentException -> L166 IOException -> L169 XmlPullParserException -> L172 NumberFormatException -> L175
            r42.next();
        L50:
            int r14 = r42.next();
            if (r14 != 4) goto L52;
            r44 = r44;
            goto L50
        L52:
            if (r14 == 2) goto L54;
            return r8;
        L54:
            Pair<Long, Long> r16 = buildRtcExecutionTimesFromXml(r42);
            Pair r19 = JobStore.m4893$$Nest$smconvertRtcBoundsToElapsed(r16, r44);
            if (JobStore.XML_TAG_PERIODIC.equals(r42.getName()) == true) goto L189;
            ?? r33 = r8;
            r16 = r16;
            int r22 = r10;
            if (JobStore.XML_TAG_ONEOFF.equals(r42.getName()) == false) goto L161;
            if (((Long) r19.first).longValue() != 0) goto L187;
        L93:
            if (((Long) r19.second).longValue() == Long.MAX_VALUE) goto L97;
            r0.setOverrideDeadline(((Long) r19.second).longValue() - r44);     // Catch: NumberFormatException -> L91
        L97:
            Pair r5 = r19;
        L98:
            maybeBuildBackoffPolicyFromXml(r0, r42);
            r42.nextTag();
            ?? r34 = r33;
        L99:
            int r110 = r42.next();
            if (r110 != 4) goto L102;
            r34 = 0;
            goto L99
        L102:
            if (r110 != 2) goto L151;
            if (JobStore.XML_TAG_EXTRAS.equals(r42.getName()) == false) goto L151;
            PersistableBundle r6 = PersistableBundle.restoreFromXml(r42);     // Catch: IllegalArgumentException -> L146
            r0.setExtras(r6);     // Catch: IllegalArgumentException -> L146
            int r20 = r42.nextTag();
            if (r20 == 2) goto L110;
        L112:
            List<JobWorkItem> r21 = null;
        L114:
            if (r20 != 2) goto L199;
            if (JobStore.XML_TAG_DEBUG_INFO.equals(r42.getName()) == false) goto L199;
            r0.setTraceTag(r42.getAttributeValue(r34, "trace-tag"));     // Catch: Exception -> L119
        L121:
            r42.next();
            r0.addDebugTags(readDebugTagsFromXml(r42));
            r42.nextTag();
        L119:
            e = move-exception;
            Slog.wtf(JobStore.TAG, "Invalid trace tag persisted to disk", e);
        L199:
            JobInfo r111 = r0.build(false, false, false, false);     // Catch: Exception -> L143
            if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(r12) == false) goto L132;
            if (r6 == null) goto L132;
            if (r6.getBoolean("SyncManagerJob", false) == false) goto L132;
            r12 = r6.getString("owningPackage", r12);
            if (JobStore.m4890$$Nest$sfgetDEBUG() == false) goto L132;
            Slog.i(JobStore.TAG, "Fixing up sync job source package name from 'android' to '" + r12 + "'");
        L132:
            int r112 = JobSchedulerService.standbyBucketForPackage(r12, r15, r44);
            String r113 = intern(r12);
            long r114 = ((Long) r5.first).longValue();
            long r31 = ((Long) r5.second).longValue();
            if (r41 == false) goto L135;
            Pair<Long, Long> r29 = null;
        L136:
            JobStatus r115 = new JobStatus(r111, r22, r113, r15, r112, r17, r18, r114, r31, r23, r25, r27, r29, r30, 0);
            if (r21 == null) goto L142;
            int r24 = 0;
        L140:
            if (r24 >= r21.size()) goto L142;
            r115.enqueueWorkLocked(r21.get(r24));
            r24 = r24 + 1;
        L142:
            return r115;
        L135:
            r29 = r16;
        L143:
            e = move-exception;
            Slog.w(JobStore.TAG, "Unable to build job from XML, ignoring: " + r0.summarize(), e);
            return null;
        L110:
            if (JobStore.XML_TAG_JOB_WORK_ITEM.equals(r42.getName()) == false) goto L112;
            r21 = readJobWorkItemsFromXml(r42);
        L146:
            e = move-exception;
            Slog.e(JobStore.TAG, "Persisted extras contained invalid data", e);
            return r34;
        L151:
            if (JobStore.m4890$$Nest$sfgetDEBUG() == false) goto L216;
            Slog.d(JobStore.TAG, "Error reading extras, skipping.");
            return null;
        L216:
            return null;
        L187:
            r0.setMinimumLatency(((Long) r19.first).longValue() - r44);     // Catch: NumberFormatException -> L91
        L158:
            Slog.d(JobStore.TAG, "Error reading job execution criteria, skipping.");
            return null;
        L161:
            if (JobStore.m4890$$Nest$sfgetDEBUG() == false) goto L217;
            Slog.d(JobStore.TAG, "Invalid parameter tag, skipping - " + r42.getName());
            return null;
        L217:
            return null;
        L189:
            long r116 = Long.parseLong(r42.getAttributeValue(r8, "period"));     // Catch: NumberFormatException -> L80
            String r117 = r42.getAttributeValue(r8, "flex");     // Catch: NumberFormatException -> L80
            if (r117 != null) goto L207;
            long r118 = r116;
        L63:
            long r35 = r118;
            r22 = r10;
            r0.setPeriodic(r116, r35);     // Catch: NumberFormatException -> L76
            if (((Long) r19.second).longValue() <= ((r44 + r116) + r35)) goto L78;
            long r119 = (r44 + r35) + r116;     // Catch: NumberFormatException -> L76
            long r32 = r119 - r35;     // Catch: NumberFormatException -> L76
            ?? r36 = r8;
            Slog.w(JobStore.TAG, String.format("Periodic job for uid='%d' persisted run-time is too big [%s, %s]. Clamping to [%s,%s]", new Object[]{Integer.valueOf(r22), DateUtils.formatElapsedTime(((Long) r19.first).longValue() / 1000), DateUtils.formatElapsedTime(((Long) r19.second).longValue() / 1000), DateUtils.formatElapsedTime(r32 / 1000), DateUtils.formatElapsedTime(r119 / 1000)}));     // Catch: NumberFormatException -> L72
            r19 = Pair.create(Long.valueOf(r32), Long.valueOf(r119));     // Catch: NumberFormatException -> L72
            ?? r37 = r36;
        L79:
            r5 = r19;
            r33 = r37;
        L82:
            Slog.d(JobStore.TAG, "Error reading periodic execution criteria, skipping.");
            return r36;
        L78:
            r37 = r8;
        L77:
            r36 = r8;
            goto L82
        L207:
            r118 = Long.valueOf(r117).longValue();     // Catch: NumberFormatException -> L60
        L61:
            r36 = r8;
        L81:
            r36 = r8;
            goto L82
        L169:
            e = move-exception;
            ?? r38 = r8;
            Slog.d(JobStore.TAG, "Error I/O Exception.", e);
            return r38;
        L166:
            e = move-exception;
            ?? r39 = r8;
            Slog.e(JobStore.TAG, "Constraints contained invalid data", e);
            return r39;
        L172:
            e = move-exception;
            ?? r310 = r8;
            Slog.d(JobStore.TAG, "Error Parser Exception.", e);
            return r310;
        L176:
            ?? r311 = r8;
            Slog.d(JobStore.TAG, "Error reading constraints, skipping.");
            return r311;
        L215:
            return r8;
        L179:
            return r8;
        L38:
            r25 = Long.parseLong(r4);     // Catch: NumberFormatException -> L181
            goto L39
        L34:
            r23 = Long.parseLong(r9);     // Catch: NumberFormatException -> L181
            goto L35
        L30:
            r7 = Integer.parseInt(r3);     // Catch: NumberFormatException -> L181
            goto L29
        L25:
            r30 = 0;
            goto L185
        L11:
            if (r43 < 1) goto L18;
            String r26 = r42.getAttributeValue(null, "bias");     // Catch: NumberFormatException -> L9
            if (r26 == null) goto L15;
            r0.setBias(Integer.parseInt(r26));     // Catch: NumberFormatException -> L9
        L15:
            String r120 = r42.getAttributeValue(null, "priority");     // Catch: NumberFormatException -> L9
            if (r120 == null) goto L18;
            r0.setPriority(Integer.parseInt(r120));     // Catch: NumberFormatException -> L9
        L183:
            Slog.e(JobStore.TAG, "Error parsing job's required fields, skipping");
            return null;
        }

        private JobInfo.Builder buildBuilderFromXml(TypedXmlPullParser parser) throws XmlPullParserException {
            int jobId = parser.getAttributeInt(null, "jobid");
            String packageName = intern(parser.getAttributeValue(null, Settings.ATTR_PACKAGE));
            String className = intern(parser.getAttributeValue(null, "class"));
            ComponentName cname = new ComponentName(packageName, className);
            return new JobInfo.Builder(jobId, cname);
        }

        private void buildConstraintsFromXml(JobInfo.Builder jobBuilder, TypedXmlPullParser parser) throws XmlPullParserException, IOException {
            String netCapabilitiesLong = null;
            String netForbiddenCapabilitiesLong = null;
            String netTransportTypesLong = null;
            String netCapabilitiesIntArray = parser.getAttributeValue(null, "net-capabilities-csv");
            String netForbiddenCapabilitiesIntArray = parser.getAttributeValue(null, "net-forbidden-capabilities-csv");
            String netTransportTypesIntArray = parser.getAttributeValue(null, "net-transport-types-csv");
            if (netCapabilitiesIntArray == null) goto L5;
            if (netTransportTypesIntArray == null) goto L5;
        L6:
            int r9 = 0;
            if (netCapabilitiesIntArray == null) goto L19;
            if (netTransportTypesIntArray == null) goto L19;
            NetworkRequest.Builder builder = new NetworkRequest.Builder().clearCapabilities();
            int[] r12 = JobStore.stringToIntArray(netCapabilitiesIntArray);
            int r13 = r12.length;
            int r14 = 0;
        L10:
            if (r14 >= r13) goto L12;
            builder.addCapability(r12[r14]);
            r14 = r14 + 1;
            goto L10
        L12:
            int[] r15 = JobStore.stringToIntArray(netForbiddenCapabilitiesIntArray);
            int r16 = r15.length;
            int r17 = 0;
        L13:
            if (r17 >= r16) goto L15;
            builder.addForbiddenCapability(r15[r17]);
            r17 = r17 + 1;
            goto L13
        L15:
            int[] r18 = JobStore.stringToIntArray(netTransportTypesIntArray);
            int r19 = r18.length;
        L16:
            if (r9 >= r19) goto L18;
            builder.addTransportType(r18[r9]);
            r9 = r9 + 1;
            goto L16
        L18:
            jobBuilder.setRequiredNetwork(builder.build()).setEstimatedNetworkBytes(parser.getAttributeLong(null, "estimated-download-bytes", -1), parser.getAttributeLong(null, "estimated-upload-bytes", -1)).setMinimumNetworkChunkBytes(parser.getAttributeLong(null, "minimum-network-chunk-bytes", -1));
        L54:
            String val = parser.getAttributeValue(null, "idle");
            if (val == null) goto L57;
            boolean r110 = true;
            jobBuilder.setRequiresDeviceIdle(true);
        L58:
            String val2 = parser.getAttributeValue(null, EventTeardownResult.EVENT_CHARGING);
            if (val2 == null) goto L61;
            jobBuilder.setRequiresCharging(r110);
        L61:
            String val3 = parser.getAttributeValue(null, "battery-not-low");
            if (val3 == null) goto L64;
            jobBuilder.setRequiresBatteryNotLow(r110);
        L64:
            String val4 = parser.getAttributeValue(null, "storage-not-low");
            if (val4 == null) goto L80;
            jobBuilder.setRequiresStorageNotLow(r110);
            return;
        L80:
            return;
        L57:
            r110 = true;
        L19:
            String netCapabilitiesLong2 = netCapabilitiesLong;
            String netForbiddenCapabilitiesLong2 = netForbiddenCapabilitiesLong;
            if (netCapabilitiesLong2 == null) goto L42;
            if (netTransportTypesLong == null) goto L42;
            NetworkRequest.Builder builder2 = new NetworkRequest.Builder().clearCapabilities();
            int[] r10 = BitUtils.unpackBits(Long.parseLong(netCapabilitiesLong2));
            int r11 = r10.length;
            int r111 = 0;
        L24:
            if (r111 >= r11) goto L29;
            int capability = r10[r111];
            if (capability > 25) goto L28;
            builder2.addCapability(capability);
        L28:
            r111 = r111 + 1;
            goto L24
        L29:
            int[] r112 = BitUtils.unpackBits(Long.parseLong(netForbiddenCapabilitiesLong2));
            int r113 = r112.length;
            int r114 = 0;
        L30:
            if (r114 >= r113) goto L35;
            int forbiddenCapability = r112[r114];
            if (forbiddenCapability > 25) goto L34;
            builder2.addForbiddenCapability(forbiddenCapability);
        L34:
            r114 = r114 + 1;
            goto L30
        L35:
            int[] r115 = BitUtils.unpackBits(Long.parseLong(netTransportTypesLong));
            int r116 = r115.length;
        L36:
            if (r9 >= r116) goto L41;
            int transport = r115[r9];
            if (transport > 7) goto L40;
            builder2.addTransportType(transport);
        L40:
            r9 = r9 + 1;
            goto L36
        L41:
            jobBuilder.setRequiredNetwork(builder2.build());
        L42:
            String val5 = parser.getAttributeValue(null, "connectivity");
            if (val5 == null) goto L45;
            jobBuilder.setRequiredNetworkType(1);
        L45:
            String val6 = parser.getAttributeValue(null, "metered");
            if (val6 == null) goto L48;
            jobBuilder.setRequiredNetworkType(4);
        L48:
            String val7 = parser.getAttributeValue(null, "unmetered");
            if (val7 == null) goto L51;
            jobBuilder.setRequiredNetworkType(2);
        L51:
            String val8 = parser.getAttributeValue(null, "not-roaming");
            if (val8 == null) goto L54;
            jobBuilder.setRequiredNetworkType(3);
        L5:
            netCapabilitiesLong = parser.getAttributeValue(null, "net-capabilities");
            netForbiddenCapabilitiesLong = parser.getAttributeValue(null, "net-unwanted-capabilities");
            netTransportTypesLong = parser.getAttributeValue(null, "net-transport-types");
            goto L6
        }

        private void maybeBuildBackoffPolicyFromXml(JobInfo.Builder jobBuilder, XmlPullParser parser) {
            String val = parser.getAttributeValue(null, "initial-backoff");
            if (val == null) goto L6;
            long initialBackoff = Long.parseLong(val);
            int backoffPolicy = Integer.parseInt(parser.getAttributeValue(null, "backoff-policy"));
            jobBuilder.setBackoffCriteria(initialBackoff, backoffPolicy);
            return;
        }

        private Pair<Long, Long> buildRtcExecutionTimesFromXml(TypedXmlPullParser parser) {
            long earliestRunTimeRtc = parser.getAttributeLong(null, "delay", 0);
            long latestRunTimeRtc = parser.getAttributeLong(null, "deadline", Long.MAX_VALUE);
            return Pair.create(Long.valueOf(earliestRunTimeRtc), Long.valueOf(latestRunTimeRtc));
        }

        private List<JobWorkItem> readJobWorkItemsFromXml(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
            List<JobWorkItem> jobWorkItems = new ArrayList();
            int eventType = parser.getEventType();
        L4:
            if (eventType == 1) goto L17;
            String tagName = parser.getName();
            if (JobStore.XML_TAG_JOB_WORK_ITEM.equals(tagName) == false) goto L17;
            JobWorkItem jwi = readJobWorkItemFromXml(parser);     // Catch: Exception -> L12
            if (jwi == null) goto L16;
            jobWorkItems.add(jwi);     // Catch: Exception -> L12
        L16:
            eventType = parser.next();
        L12:
            e = move-exception;
            Slog.e(JobStore.TAG, "Problem with persisted JobWorkItem", e);
        L17:
            return jobWorkItems;
        }

        private JobWorkItem readJobWorkItemFromXml(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
            JobWorkItem.Builder jwiBuilder = new JobWorkItem.Builder();
            jwiBuilder.setDeliveryCount(parser.getAttributeInt(null, "delivery-count")).setEstimatedNetworkBytes(parser.getAttributeLong(null, "estimated-download-bytes", -1), parser.getAttributeLong(null, "estimated-upload-bytes", -1)).setMinimumNetworkChunkBytes(parser.getAttributeLong(null, "minimum-network-chunk-bytes", -1));
            parser.next();
            PersistableBundle extras = PersistableBundle.restoreFromXml(parser);     // Catch: IllegalArgumentException -> L9
            jwiBuilder.setExtras(extras);     // Catch: IllegalArgumentException -> L9
            return jwiBuilder.build();
        L6:
            e = move-exception;
            Slog.e(JobStore.TAG, "Invalid JobWorkItem", e);
            return null;
        L9:
            e = move-exception;
            Slog.e(JobStore.TAG, "Persisted extras contained invalid data", e);
            return null;
        }

        private Set<String> readDebugTagsFromXml(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
            Set<String> debugTags = new ArraySet();
            int eventType = parser.getEventType();
        L4:
            if (eventType == 1) goto L15;
            String tagName = parser.getName();
            if (JobStore.XML_TAG_DEBUG_TAG.equals(tagName) == false) goto L15;
            if (debugTags.size() >= 32) goto L14;
            String debugTag = JobInfo.validateDebugTag(parser.getAttributeValue(null, "tag"));     // Catch: Exception -> L12
            debugTags.add(debugTag);
        L12:
            e = move-exception;
            Slog.wtf(JobStore.TAG, "Invalid debug tag persisted to disk", e);
        L14:
            eventType = parser.next();
        L15:
            return debugTags;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$CUH2yIm-c34YKhc8Nam77Rkt44Q, reason: not valid java name */
    public static /* synthetic */ void m4870$r8$lambda$CUH2yImc34YKhc8Nam77Rkt44Q(long r0, ArrayList r2, ArrayList r3, JobStatus r4) {
        lambda$getRtcCorrectedJobsLocked$0(r0, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentJobSetSize, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4871$$Nest$fgetmCurrentJobSetSize(JobStore r0) {
        return r0.mCurrentJobSetSize;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEventLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ SystemConfigFileCommitEventLogger m4872$$Nest$fgetmEventLogger(JobStore r0) {
        return r0.mEventLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmJobFileDirectory, reason: not valid java name */
    static /* bridge */ /* synthetic */ File m4873$$Nest$fgetmJobFileDirectory(JobStore r0) {
        return r0.mJobFileDirectory;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmJobsFile, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicFile m4874$$Nest$fgetmJobsFile(JobStore r0) {
        return r0.mJobsFile;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPendingJobWriteUids, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseBooleanArray m4875$$Nest$fgetmPendingJobWriteUids(JobStore r0) {
        return r0.mPendingJobWriteUids;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPersistInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ JobSchedulerInternal.JobStorePersistStats m4876$$Nest$fgetmPersistInfo(JobStore r0) {
        return r0.mPersistInfo;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmScheduledJob30MinHighWaterMark, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4877$$Nest$fgetmScheduledJob30MinHighWaterMark(JobStore r0) {
        return r0.mScheduledJob30MinHighWaterMark;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmScheduledJobHighWaterMarkLoggingRunnable, reason: not valid java name */
    static /* bridge */ /* synthetic */ Runnable m4878$$Nest$fgetmScheduledJobHighWaterMarkLoggingRunnable(JobStore r0) {
        return r0.mScheduledJobHighWaterMarkLoggingRunnable;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSplitFileMigrationNeeded, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4879$$Nest$fgetmSplitFileMigrationNeeded(JobStore r0) {
        return r0.mSplitFileMigrationNeeded;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUseSplitFiles, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4880$$Nest$fgetmUseSplitFiles(JobStore r0) {
        return r0.mUseSplitFiles;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWriteInProgress, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4881$$Nest$fgetmWriteInProgress(JobStore r0) {
        return r0.mWriteInProgress;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCurrentJobSetSize, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4882$$Nest$fputmCurrentJobSetSize(JobStore r0, int r1) {
        r0.mCurrentJobSetSize = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmScheduledJob30MinHighWaterMark, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4883$$Nest$fputmScheduledJob30MinHighWaterMark(JobStore r0, int r1) {
        r0.mScheduledJob30MinHighWaterMark = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmWriteInProgress, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4884$$Nest$fputmWriteInProgress(JobStore r0, boolean r1) {
        r0.mWriteInProgress = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmWriteScheduled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4885$$Nest$fputmWriteScheduled(JobStore r0, boolean r1) {
        r0.mWriteScheduled = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mcreateJobFile, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicFile m4886$$Nest$mcreateJobFile(JobStore r0, File r1) {
        return r0.createJobFile(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcreateJobFile, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicFile m4887$$Nest$mcreateJobFile(JobStore r0, String r1) {
        return r0.createJobFile(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mmaybeWriteStatusToDiskAsync, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4888$$Nest$mmaybeWriteStatusToDiskAsync(JobStore r0) {
        r0.maybeWriteStatusToDiskAsync();
    }

    /* JADX INFO: renamed from: -$$Nest$mmigrateJobFilesAsync, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4889$$Nest$mmigrateJobFilesAsync(JobStore r0) {
        r0.migrateJobFilesAsync();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4890$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetSPLIT_FILE_PATTERN, reason: not valid java name */
    static /* bridge */ /* synthetic */ Pattern m4891$$Nest$sfgetSPLIT_FILE_PATTERN() {
        return SPLIT_FILE_PATTERN;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsScheduledJob30MinHighWaterMarkLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ Histogram m4892$$Nest$sfgetsScheduledJob30MinHighWaterMarkLogger() {
        return sScheduledJob30MinHighWaterMarkLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$smconvertRtcBoundsToElapsed, reason: not valid java name */
    static /* bridge */ /* synthetic */ Pair m4893$$Nest$smconvertRtcBoundsToElapsed(Pair r0, long r1) {
        return convertRtcBoundsToElapsed(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smisSyncJob, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4894$$Nest$smisSyncJob(JobStatus r0) {
        return isSyncJob(r0);
    }

    static {
        DEBUG = JobSchedulerService.DEBUG;
        SPLIT_FILE_PATTERN = Pattern.compile("^jobs_\\d+.xml$");
        sSingletonLock = new Object();
        sScheduledJob30MinHighWaterMarkLogger = new Histogram("job_scheduler.value_hist_scheduled_job_30_min_high_water_mark", new Histogram.ScaledRangeOptions(15, 1, 99.0f, 1.5f));
    }

    static JobStore get(JobSchedulerService jobManagerService) {
        Object r0 = sSingletonLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sSingleton != null) goto L9;
        sSingleton = new JobStore(jobManagerService.getContext(), jobManagerService.getLock(), Environment.getDataDirectory());     // Catch: Throwable -> L7
    L9:
        JobStore r1 = sSingleton;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    }

    public static JobStore initAndGetForTesting(Context context, File dataDir) {
        JobStore jobStoreUnderTest = new JobStore(context, new Object(), dataDir);
        jobStoreUnderTest.init();
        jobStoreUnderTest.clearForTesting();
        return jobStoreUnderTest;
    }

    private JobStore(Context context, Object lock, File dataDir) {
        this.mPendingJobWriteUids = new SparseBooleanArray();
        this.mIoHandler = IoThread.getHandler();
        boolean r0 = true;
        this.mUseSplitFiles = true;
        this.mPersistInfo = new JobSchedulerInternal.JobStorePersistStats();
        this.mCurrentJobSetSize = 0;
        this.mScheduledJob30MinHighWaterMark = 0;
        this.mScheduledJobHighWaterMarkLoggingRunnable = new AnonymousClass1(this);
        this.mWriteRunnable = new AnonymousClass2(this);
        this.mLock = lock;
        this.mWriteScheduleLock = new Object();
        this.mContext = context;
        File systemDir = new File(dataDir, "system");
        this.mJobFileDirectory = new File(systemDir, "job");
        this.mJobFileDirectory.mkdirs();
        this.mEventLogger = new SystemConfigFileCommitEventLogger("jobs");
        this.mJobsFile = createJobFile(new File(this.mJobFileDirectory, "jobs.xml"));
        this.mJobSet = new JobSet();
        if (this.mJobsFile.exists() == false) goto L5;
        long r3 = this.mJobsFile.getLastModifiedTime();
    L6:
        this.mXmlTimestamp = r3;
        if (JobSchedulerService.sSystemClock.millis() > this.mXmlTimestamp) goto L10;
        r0 = false;
    L10:
        this.mRtcGood = r0;
        AppSchedulingModuleThread.getHandler().postDelayed(this.mScheduledJobHighWaterMarkLoggingRunnable, 1800000);
        return;
    L5:
        r3 = this.mJobFileDirectory.lastModified();
        goto L6
    }

    private void init() {
        readJobMapFromDisk(this.mJobSet, this.mRtcGood);
    }

    void initAsync(CountDownLatch completionLatch) {
        this.mIoHandler.post(new ReadJobMapFromDiskRunnable(this, this.mJobSet, this.mRtcGood, completionLatch));
    }

    private AtomicFile createJobFile(String baseName) {
        return createJobFile(new File(this.mJobFileDirectory, baseName + ".xml"));
    }

    private AtomicFile createJobFile(File file) {
        return new AtomicFile(file, this.mEventLogger);
    }

    public boolean jobTimesInflatedValid() {
        return this.mRtcGood;
    }

    public boolean clockNowValidToInflate(long now) {
        if (now < this.mXmlTimestamp) goto L5;
        return true;
    L5:
        return false;
    }

    void runWorkAsync(Runnable r) {
        this.mIoHandler.post(r);
    }

    public void getRtcCorrectedJobsLocked(final ArrayList<JobStatus> toAdd, final ArrayList<JobStatus> toRemove) {
        final long elapsedNow = JobSchedulerService.sElapsedRealtimeClock.millis();
        forEachJob(new JobStore$$ExternalSyntheticLambda0(elapsedNow, toAdd, toRemove));
    }

    private static /* synthetic */ void lambda$getRtcCorrectedJobsLocked$0(long elapsedNow, ArrayList toAdd, ArrayList toRemove, JobStatus job) {
        Pair<Long, Long> utcTimes = job.getPersistedUtcTimes();
        if (utcTimes == null) goto L6;
        Pair<Long, Long> elapsedRuntimes = convertRtcBoundsToElapsed(utcTimes, elapsedNow);
        JobStatus newJob = new JobStatus(job, ((Long) elapsedRuntimes.first).longValue(), ((Long) elapsedRuntimes.second).longValue(), 0, 0, 0, job.getLastSuccessfulRunTime(), job.getLastFailedRunTime(), job.getCumulativeExecutionTimeMs());
        newJob.prepareLocked();
        toAdd.add(newJob);
        toRemove.add(job);
        return;
    }

    public void add(JobStatus jobStatus) {
        if (this.mJobSet.add(jobStatus) == false) goto L6;
        this.mCurrentJobSetSize++;
        maybeUpdateHighWaterMark();
    L6:
        if (jobStatus.isPersisted() == false) goto L9;
        this.mPendingJobWriteUids.put(jobStatus.getUid(), true);
        maybeWriteStatusToDiskAsync();
    L9:
        if (DEBUG == false) goto L12;
        Slog.d(TAG, "Added job status to store: " + jobStatus);
        return;
    }

    public void addForTesting(JobStatus jobStatus) {
        if (this.mJobSet.add(jobStatus) == false) goto L6;
        this.mCurrentJobSetSize++;
        maybeUpdateHighWaterMark();
    L6:
        if (jobStatus.isPersisted() == false) goto L9;
        this.mPendingJobWriteUids.put(jobStatus.getUid(), true);
        return;
    }

    boolean containsJob(JobStatus jobStatus) {
        return this.mJobSet.contains(jobStatus);
    }

    public int size() {
        return this.mJobSet.size();
    }

    public JobSchedulerInternal.JobStorePersistStats getPersistStats() {
        return this.mPersistInfo;
    }

    public int countJobsForUid(int uid) {
        return this.mJobSet.countJobsForUid(uid);
    }

    public boolean remove(JobStatus jobStatus, boolean removeFromPersisted) {
        boolean removed = this.mJobSet.remove(jobStatus);
        if (removed == false) goto L5;
        this.mCurrentJobSetSize--;
        if (removeFromPersisted == true) goto L12;
    L14:
        return removed;
    L12:
        if (jobStatus.isPersisted() == false) goto L14;
        this.mPendingJobWriteUids.put(jobStatus.getUid(), true);
        maybeWriteStatusToDiskAsync();
        goto L14
    L5:
        if (DEBUG == false) goto L15;
        Slog.d(TAG, "Couldn't remove job: didn't exist: " + jobStatus);
        return false;
    L15:
        return false;
    }

    public void removeForTesting(JobStatus jobStatus) {
        if (this.mJobSet.remove(jobStatus) == false) goto L6;
        this.mCurrentJobSetSize--;
    L6:
        if (jobStatus.isPersisted() == false) goto L9;
        this.mPendingJobWriteUids.put(jobStatus.getUid(), true);
        return;
    }

    public void removeJobsOfUnlistedUsers(int[] keepUserIds) {
        this.mJobSet.removeJobsOfUnlistedUsers(keepUserIds);
        this.mCurrentJobSetSize = this.mJobSet.size();
    }

    void touchJob(JobStatus jobStatus) {
        if (jobStatus.isPersisted() == true) goto L5;
        return;
    L5:
        this.mPendingJobWriteUids.put(jobStatus.getUid(), true);
        maybeWriteStatusToDiskAsync();
    }

    public void clear() {
        this.mJobSet.clear();
        this.mPendingJobWriteUids.put(-1, true);
        this.mCurrentJobSetSize = 0;
        maybeWriteStatusToDiskAsync();
    }

    public void clearForTesting() {
        this.mJobSet.clear();
        this.mPendingJobWriteUids.put(-1, true);
        this.mCurrentJobSetSize = 0;
    }

    void setUseSplitFiles(boolean useSplitFiles) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mUseSplitFiles == useSplitFiles) goto L9;
        this.mUseSplitFiles = useSplitFiles;     // Catch: Throwable -> L7
        migrateJobFilesAsync();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public void setUseSplitFilesForTesting(boolean useSplitFiles) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mUseSplitFiles == useSplitFiles) goto L7;
        boolean changed = true;
    L8:
        if (changed == false) goto L12;
        this.mUseSplitFiles = useSplitFiles;     // Catch: Throwable -> L10
        this.mPendingJobWriteUids.put(-1, true);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L10
        if (changed == false) goto L22;
        Object r1 = this.mWriteScheduleLock;
        monitor-enter(r1);
        this.mSplitFileMigrationNeeded = true;     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    L22:
        return;
    L7:
        changed = false;
        goto L8
    }

    public ArraySet<JobStatus> getJobsBySourceUid(int sourceUid) {
        return this.mJobSet.getJobsBySourceUid(sourceUid);
    }

    public void getJobsBySourceUid(int sourceUid, Set<JobStatus> insertInto) {
        this.mJobSet.getJobsBySourceUid(sourceUid, insertInto);
    }

    public ArraySet<JobStatus> getJobsByUid(int uid) {
        return this.mJobSet.getJobsByUid(uid);
    }

    public void getJobsByUid(int uid, Set<JobStatus> insertInto) {
        this.mJobSet.getJobsByUid(uid, insertInto);
    }

    public JobStatus getJobByUidAndJobId(int uid, String namespace, int jobId) {
        return this.mJobSet.get(uid, namespace, jobId);
    }

    public void forEachJob(Consumer<JobStatus> functor) {
        this.mJobSet.forEachJob(null, functor);
    }

    public void forEachJob(Predicate<JobStatus> filterPredicate, Consumer<JobStatus> functor) {
        this.mJobSet.forEachJob(filterPredicate, functor);
    }

    public void forEachJob(int uid, Consumer<JobStatus> functor) {
        this.mJobSet.forEachJob(uid, functor);
    }

    public void forEachJobForSourceUid(int sourceUid, Consumer<JobStatus> functor) {
        this.mJobSet.forEachJobForSourceUid(sourceUid, functor);
    }

    private void maybeUpdateHighWaterMark() {
        if (this.mScheduledJob30MinHighWaterMark >= this.mCurrentJobSetSize) goto L6;
        this.mScheduledJob30MinHighWaterMark = this.mCurrentJobSetSize;
        return;
    }

    private void migrateJobFilesAsync() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPendingJobWriteUids.put(-1, true);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        Object r1 = this.mWriteScheduleLock;
        monitor-enter(r1);
        this.mSplitFileMigrationNeeded = true;     // Catch: Throwable -> L11
        maybeWriteStatusToDiskAsync();     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        throw th;
    }

    private void maybeWriteStatusToDiskAsync() {
        Object r0 = this.mWriteScheduleLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mWriteScheduled == false) goto L7;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (DEBUG == false) goto L11;
        Slog.v(TAG, "Scheduling persist of jobs to disk.");     // Catch: Throwable -> L9
    L11:
        this.mIoHandler.postDelayed(this.mWriteRunnable, 2000);     // Catch: Throwable -> L9
        this.mWriteScheduled = true;     // Catch: Throwable -> L9
        goto L12
    }

    public void readJobMapFromDisk(JobSet jobSet, boolean rtcGood) {
        new ReadJobMapFromDiskRunnable(this, jobSet, rtcGood).run();
    }

    public void writeStatusToDiskForTesting() {
        Object r0 = this.mWriteScheduleLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mWriteScheduled == true) goto L12;
        this.mWriteScheduled = true;     // Catch: Throwable -> L9
        this.mWriteRunnable.run();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        throw new IllegalStateException("An asynchronous write is already scheduled.");     // Catch: Throwable -> L9
    }

    public boolean waitForWriteToCompleteForTesting(long maxWaitMillis) {
        long start = SystemClock.uptimeMillis();
        long end = start + maxWaitMillis;
        Object r4 = this.mWriteScheduleLock;
        monitor-enter(r4);
    L24:
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mWriteScheduled == true) goto L11;
        if (this.mWriteInProgress == true) goto L11;
    L19:
        monitor-exit(r4);     // Catch: Throwable -> L9
        return true;
    L11:
        long now = SystemClock.uptimeMillis();     // Catch: Throwable -> L9
        if (now >= end) goto L13;
        this.mWriteScheduleLock.wait((now - start) + maxWaitMillis);     // Catch: Throwable -> L9 InterruptedException -> L18
    L13:
        monitor-exit(r4);     // Catch: Throwable -> L9
        return false;
    }

    static String intArrayToString(int[] values) {
        StringJoiner sj = new StringJoiner(",");
        int r1 = values.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        int value = values[r2];
        sj.add(String.valueOf(value));
        r2 = r2 + 1;
        goto L3
    L6:
        return sj.toString();
    }

    static int[] stringToIntArray(String str) {
        if (TextUtils.isEmpty(str) == true) goto L5;
        String[] arr = str.split(",");
        int[] values = new int[arr.length];
        int i = 0;
    L8:
        if (i >= arr.length) goto L11;
        values[i] = Integer.parseInt(arr[i]);
        i = i + 1;
        goto L8
    L11:
        return values;
    L5:
        return new int[0];
    }

    static int extractUidFromJobFileName(File file) {
        String fileName = file.getName();
        if (fileName.startsWith(JOB_FILE_SPLIT_PREFIX) == true) goto L11;
    L10:
        return -2;
    L11:
        int subEnd = fileName.length() - 4;     // Catch: Exception -> L8
        int uid = Integer.parseInt(fileName.substring(JOB_FILE_SPLIT_PREFIX.length(), subEnd));     // Catch: Exception -> L8
        if (uid >= 0) goto L7;
        return -2;
    L7:
        return uid;
    L8:
        e = move-exception;
        Slog.e(TAG, "Unexpected file name format", e);
        goto L10
    }

    private static Pair<Long, Long> convertRtcBoundsToElapsed(Pair<Long, Long> rtcTimes, long nowElapsed) {
        long nowWallclock = JobSchedulerService.sSystemClock.millis();
        if (((Long) rtcTimes.first).longValue() <= 0) goto L5;
        long earliest = Math.max(((Long) rtcTimes.first).longValue() - nowWallclock, 0) + nowElapsed;
    L6:
        long latest = Long.MAX_VALUE;
        if (((Long) rtcTimes.second).longValue() >= Long.MAX_VALUE) goto L11;
        latest = nowElapsed + Math.max(((Long) rtcTimes.second).longValue() - nowWallclock, 0);
    L11:
        return Pair.create(Long.valueOf(earliest), Long.valueOf(latest));
    L5:
        earliest = 0;
        goto L6
    }

    private static boolean isSyncJob(JobStatus status) {
        return SyncJobService.class.getName().equals(status.getServiceComponent().getClassName());
    }
}
