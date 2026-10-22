package com.android.server.usage;

import android.app.usage.AppStandbyInfo;
import android.app.usage.UsageStatsManager;
import android.os.PowerAdvisorInternal;
import android.os.SystemClock;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseLongArray;
import android.util.TimeUtils;
import android.util.Xml;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.jobs.CollectionUtils;
import com.android.internal.util.jobs.FastXmlSerializer;
import com.android.internal.util.jobs.XmlUtils;
import com.android.server.LocalServices;
import com.android.server.job.JobPackageTracker;
import com.android.server.voiceinteraction.DatabaseHelper;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import libcore.io.IoUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class AppIdleHistory {
    static final String APP_IDLE_FILENAME = "app_idle_stats.xml";
    private static final String ATTR_BUCKET = "bucket";
    private static final String ATTR_BUCKETING_REASON = "bucketReason";
    private static final String ATTR_BUCKET_ACTIVE_TIMEOUT_TIME = "activeTimeoutTime";
    private static final String ATTR_BUCKET_WORKING_SET_TIMEOUT_TIME = "workingSetTimeoutTime";
    private static final String ATTR_CURRENT_BUCKET = "appLimitBucket";
    private static final String ATTR_ELAPSED_IDLE = "elapsedIdleTime";
    private static final String ATTR_EXPIRY_TIME = "expiry";
    private static final String ATTR_LAST_PREDICTED_TIME = "lastPredictedTime";
    private static final String ATTR_LAST_RESTRICTION_ATTEMPT_ELAPSED = "lastRestrictionAttemptElapsedTime";
    private static final String ATTR_LAST_RESTRICTION_ATTEMPT_REASON = "lastRestrictionAttemptReason";
    private static final String ATTR_LAST_RUN_JOB_TIME = "lastJobRunTime";
    private static final String ATTR_LAST_USED_BY_USER_ELAPSED = "lastUsedByUserElapsedTime";
    private static final String ATTR_NAME = "name";
    private static final String ATTR_NEXT_ESTIMATED_APP_LAUNCH_TIME = "nextEstimatedAppLaunchTime";
    private static final String ATTR_SCREEN_IDLE = "screenIdleTime";
    private static final String ATTR_VERSION = "version";
    private static final boolean DEBUG = false;
    static final int IDLE_BUCKET_CUTOFF = 40;
    private static final long ONE_MINUTE = 60000;
    static final long RESTORE_TO_RARE_APPS_LIST_EXPIRY = 172800000;
    static final int STANDBY_BUCKET_UNKNOWN = -1;
    private static final String TAG = "AppIdleHistory";
    private static final String TAG_BUCKET_EXPIRY_TIMES = "expiryTimes";
    private static final String TAG_ITEM = "item";
    private static final String TAG_PACKAGE = "package";
    private static final String TAG_PACKAGES = "packages";
    private static final int XML_VERSION_ADD_BUCKET_EXPIRY_TIMES = 1;
    private static final int XML_VERSION_CURRENT = 1;
    private static final int XML_VERSION_INITIAL = 0;
    private long mElapsedDuration;
    private long mElapsedSnapshot;
    private SparseArray<ArrayMap<String, AppUsageHistory>> mIdleHistory;
    private PowerAdvisorInternal mPowerAdvisorInternal;
    private boolean mScreenOn;
    private long mScreenOnDuration;
    private long mScreenOnSnapshot;
    private final File mStorageDir;

    static class AppUsageHistory {
        SparseLongArray bucketExpiryTimesMs;
        int bucketingReason;
        int currentBucket;
        int lastInformedBucket;
        long lastJobRunTime;
        int lastPredictedBucket;
        long lastPredictedTime;
        long lastRestrictAttemptElapsedTime;
        int lastRestrictReason;
        long lastUsedByUserElapsedTime;
        long lastUsedElapsedTime;
        long lastUsedScreenTime;
        long nextEstimatedLaunchTime;

        AppUsageHistory() {
            this.lastPredictedBucket = -1;
        }
    }

    AppIdleHistory(File storageDir, long elapsedRealtime) {
        this.mIdleHistory = new SparseArray();
        this.mElapsedSnapshot = elapsedRealtime;
        this.mScreenOnSnapshot = elapsedRealtime;
        this.mStorageDir = storageDir;
        readScreenOnTime();
        this.mPowerAdvisorInternal = (PowerAdvisorInternal) LocalServices.getService(PowerAdvisorInternal.class);
    }

    public void updateDisplay(boolean screenOn, long elapsedRealtime) {
        if (screenOn != this.mScreenOn) goto L5;
        return;
    L5:
        this.mScreenOn = screenOn;
        if (this.mScreenOn == false) goto L8;
        this.mScreenOnSnapshot = elapsedRealtime;
        return;
    L8:
        this.mScreenOnDuration += elapsedRealtime - this.mScreenOnSnapshot;
        this.mElapsedDuration += elapsedRealtime - this.mElapsedSnapshot;
        this.mElapsedSnapshot = elapsedRealtime;
    }

    public long getScreenOnTime(long elapsedRealtime) {
        long screenOnTime = this.mScreenOnDuration;
        if (this.mScreenOn == true) goto L5;
        return screenOnTime;
    L5:
        return screenOnTime + (elapsedRealtime - this.mScreenOnSnapshot);
    }

    File getScreenOnTimeFile() {
        return new File(this.mStorageDir, "screen_on_time");
    }

    private void readScreenOnTime() {
        File screenOnTimeFile = getScreenOnTimeFile();
        if (screenOnTimeFile.exists() == true) goto L10;
        writeScreenOnTime();
        return;
    L10:
        BufferedReader reader = new BufferedReader(new FileReader(screenOnTimeFile));     // Catch: Throwable -> L6
        this.mScreenOnDuration = Long.parseLong(reader.readLine());     // Catch: Throwable -> L6
        this.mElapsedDuration = Long.parseLong(reader.readLine());     // Catch: Throwable -> L6
        reader.close();     // Catch: Throwable -> L6
        return;
    }

    private void writeScreenOnTime() {
        AtomicFile screenOnTimeFile = new AtomicFile(getScreenOnTimeFile());
        FileOutputStream fos = null;
        fos = screenOnTimeFile.startWrite();     // Catch: IOException -> L5
        fos.write((Long.toString(this.mScreenOnDuration) + "\n" + Long.toString(this.mElapsedDuration) + "\n").getBytes());     // Catch: IOException -> L5
        screenOnTimeFile.finishWrite(fos);     // Catch: IOException -> L5
        return;
    L6:
        screenOnTimeFile.failWrite(fos);
    }

    public void writeAppIdleDurations() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.mElapsedDuration += elapsedRealtime - this.mElapsedSnapshot;
        this.mElapsedSnapshot = elapsedRealtime;
        writeScreenOnTime();
    }

    private File getRestoreToRareAppsListFile(int userId) {
        return new File(getUserDirectory(userId), "restore_to_rare_apps_list");
    }

    public ArraySet<String> readRestoreToRareAppsList(int userId) {
        File restoreToRareAppsListFile = getRestoreToRareAppsListFile(userId);
        if (restoreToRareAppsListFile.exists() == true) goto L32;
        return null;
    L32:
        BufferedReader reader = new BufferedReader(new FileReader(restoreToRareAppsListFile));     // Catch: Throwable -> L11
        ArraySet<String> appsList = new ArraySet();     // Catch: Throwable -> L13
        long restoreTime = Long.parseLong(reader.readLine());     // Catch: Throwable -> L13
        if ((System.currentTimeMillis() - restoreTime) <= RESTORE_TO_RARE_APPS_LIST_EXPIRY) goto L15;
        reader.close();     // Catch: Throwable -> L13
        restoreToRareAppsListFile.delete();     // Catch: Throwable -> L13
        reader.close();     // Catch: Throwable -> L11 Throwable -> L11
        return null;
    L15:
        String pkgName = reader.readLine();     // Catch: Throwable -> L13
        if (pkgName == null) goto L20;
        appsList.add(pkgName);     // Catch: Throwable -> L13
        goto L15
    L20:
        reader.close();     // Catch: Throwable -> L11 Throwable -> L11
        return appsList;
    L13:
        th = move-exception;
        reader.close();     // Catch: Throwable -> L24
    L26:
        throw th;     // Catch: Throwable -> L11 Throwable -> L11
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L11 Throwable -> L11
        goto L26
    L28:
        return null;
    }

    public void writeRestoreToRareAppsList(int userId, ArraySet<String> restoreAppsToRare) {
        File fileHandle = getRestoreToRareAppsListFile(userId);
        if (fileHandle.exists() == false) goto L5;
        return;
    L5:
        AtomicFile restoreToRareAppsListFile = new AtomicFile(fileHandle);
        FileOutputStream fos = null;
        fos = restoreToRareAppsListFile.startWrite();     // Catch: IOException -> L10
        StringBuilder sb = new StringBuilder();     // Catch: IOException -> L10
        sb.append(System.currentTimeMillis());     // Catch: IOException -> L10
        sb.append("\n");     // Catch: IOException -> L10
        Iterator<String> r5 = restoreAppsToRare.iterator();     // Catch: IOException -> L10
    L8:
        if (r5.hasNext() == false) goto L12;
        String pkgName = r5.next();     // Catch: IOException -> L10
        sb.append(pkgName);     // Catch: IOException -> L10
        sb.append("\n");     // Catch: IOException -> L10
        goto L8
    L12:
        fos.write(sb.toString().getBytes());     // Catch: IOException -> L10
        restoreToRareAppsListFile.finishWrite(fos);     // Catch: IOException -> L10
        return;
    L14:
        restoreToRareAppsListFile.failWrite(fos);
    }

    AppUsageHistory reportUsage(AppUsageHistory appUsageHistory, String packageName, int userId, int newBucket, int usageReason, long nowElapsedRealtimeMs, long expiryElapsedRealtimeMs) {
        int newBucket2 = newBucket;
        int bucketingReason = usageReason | 768;
        boolean isUserUsage = AppStandbyController.isUserUsage(bucketingReason);
        if (appUsageHistory.currentBucket != 45) goto L9;
        if (isUserUsage == true) goto L9;
        if ((appUsageHistory.bucketingReason & JobPackageTracker.EVENT_STOP_REASON_MASK) == 512) goto L9;
        newBucket2 = 45;
        bucketingReason = appUsageHistory.bucketingReason;
    L15:
        if (nowElapsedRealtimeMs == 0) goto L21;
        appUsageHistory.lastUsedElapsedTime = this.mElapsedDuration + (nowElapsedRealtimeMs - this.mElapsedSnapshot);
        if (isUserUsage == false) goto L19;
        appUsageHistory.lastUsedByUserElapsedTime = appUsageHistory.lastUsedElapsedTime;
    L19:
        appUsageHistory.lastUsedScreenTime = getScreenOnTime(nowElapsedRealtimeMs);
    L21:
        if (appUsageHistory.currentBucket < newBucket2) goto L28;
        if (appUsageHistory.currentBucket <= newBucket2) goto L26;
        appUsageHistory.currentBucket = newBucket2;
        logAppStandbyBucketChanged(packageName, userId, newBucket2, bucketingReason);
    L26:
        appUsageHistory.bucketingReason = bucketingReason;
    L28:
        return appUsageHistory;
    L9:
        if (expiryElapsedRealtimeMs <= nowElapsedRealtimeMs) goto L15;
        long expiryTimeMs = getElapsedTime(expiryElapsedRealtimeMs);
        if (appUsageHistory.bucketExpiryTimesMs != null) goto L13;
        appUsageHistory.bucketExpiryTimesMs = new SparseLongArray();
    L13:
        long currentExpiryTimeMs = appUsageHistory.bucketExpiryTimesMs.get(newBucket2);
        appUsageHistory.bucketExpiryTimesMs.put(newBucket2, Math.max(expiryTimeMs, currentExpiryTimeMs));
        removeElapsedExpiryTimes(appUsageHistory, getElapsedTime(nowElapsedRealtimeMs));
        goto L15
    }

    private void removeElapsedExpiryTimes(AppUsageHistory appUsageHistory, long elapsedTimeMs) {
        if (appUsageHistory.bucketExpiryTimesMs != null) goto L5;
        return;
    L5:
        int i = appUsageHistory.bucketExpiryTimesMs.size() - 1;
    L6:
        if (i < 0) goto L12;
        if (appUsageHistory.bucketExpiryTimesMs.valueAt(i) >= elapsedTimeMs) goto L10;
        appUsageHistory.bucketExpiryTimesMs.removeAt(i);
    L10:
        i = i - 1;
        goto L6
    }

    public AppUsageHistory reportUsage(String packageName, int userId, int newBucket, int usageReason, long nowElapsedRealtimeMs, long expiryElapsedRealtimeMs) {
        ArrayMap<String, AppUsageHistory> userHistory = getUserHistory(userId);
        AppUsageHistory history = getPackageHistory(userHistory, packageName, nowElapsedRealtimeMs, true);
        return reportUsage(history, packageName, userId, newBucket, usageReason, nowElapsedRealtimeMs, expiryElapsedRealtimeMs);
    }

    private ArrayMap<String, AppUsageHistory> getUserHistory(int userId) {
        ArrayMap<String, AppUsageHistory> userHistory = this.mIdleHistory.get(userId);
        if (userHistory != null) goto L6;
        ArrayMap<String, AppUsageHistory> userHistory2 = new ArrayMap();
        this.mIdleHistory.put(userId, userHistory2);
        readAppIdleTimes(userId, userHistory2);
        return userHistory2;
    L6:
        return userHistory;
    }

    private AppUsageHistory getPackageHistory(ArrayMap<String, AppUsageHistory> userHistory, String packageName, long elapsedRealtime, boolean create) {
        AppUsageHistory appUsageHistory = userHistory.get(packageName);
        if (appUsageHistory != null) goto L7;
        if (create == false) goto L8;
        AppUsageHistory appUsageHistory2 = new AppUsageHistory();
        appUsageHistory2.lastUsedByUserElapsedTime = -2147483648L;
        appUsageHistory2.lastUsedElapsedTime = -2147483648L;
        appUsageHistory2.lastUsedScreenTime = -2147483648L;
        appUsageHistory2.lastPredictedTime = -2147483648L;
        appUsageHistory2.currentBucket = 50;
        appUsageHistory2.bucketingReason = 256;
        appUsageHistory2.lastInformedBucket = -1;
        appUsageHistory2.lastJobRunTime = Long.MIN_VALUE;
        userHistory.put(packageName, appUsageHistory2);
        return appUsageHistory2;
    L8:
        return appUsageHistory;
    L7:
        return appUsageHistory;
    }

    public void onUserRemoved(int userId) {
        this.mIdleHistory.remove(userId);
    }

    public boolean isIdle(String packageName, int userId, long elapsedRealtime) {
        ArrayMap<String, AppUsageHistory> userHistory = getUserHistory(userId);
        AppUsageHistory appUsageHistory = getPackageHistory(userHistory, packageName, elapsedRealtime, true);
        if (appUsageHistory.currentBucket < 40) goto L5;
        return true;
    L5:
        return false;
    }

    public AppUsageHistory getAppUsageHistory(String packageName, int userId, long elapsedRealtime) {
        ArrayMap<String, AppUsageHistory> userHistory = getUserHistory(userId);
        AppUsageHistory appUsageHistory = getPackageHistory(userHistory, packageName, elapsedRealtime, true);
        return appUsageHistory;
    }

    public void setAppStandbyBucket(String packageName, int userId, long elapsedRealtime, int bucket, int reason) {
        setAppStandbyBucket(packageName, userId, elapsedRealtime, bucket, reason, false);
    }

    public void setAppStandbyBucket(String packageName, int userId, long elapsedRealtime, int bucket, int reason, boolean resetExpiryTimes) {
        ArrayMap<String, AppUsageHistory> userHistory = getUserHistory(userId);
        AppUsageHistory appUsageHistory = getPackageHistory(userHistory, packageName, elapsedRealtime, true);
        if (appUsageHistory.currentBucket == bucket) goto L5;
        boolean changed = true;
    L6:
        appUsageHistory.currentBucket = bucket;
        appUsageHistory.bucketingReason = reason;
        long elapsed = getElapsedTime(elapsedRealtime);
        if ((65280 & reason) != 1280) goto L9;
        appUsageHistory.lastPredictedTime = elapsed;
        appUsageHistory.lastPredictedBucket = bucket;
    L9:
        if (resetExpiryTimes == true) goto L11;
    L13:
        if (changed == false) goto L16;
        logAppStandbyBucketChanged(packageName, userId, bucket, reason);
        return;
    L16:
        return;
    L11:
        if (appUsageHistory.bucketExpiryTimesMs == null) goto L13;
        appUsageHistory.bucketExpiryTimesMs.clear();
        goto L13
    L5:
        changed = false;
        goto L6
    }

    public void updateLastPrediction(AppUsageHistory app, long elapsedTimeAdjusted, int bucket) {
        app.lastPredictedTime = elapsedTimeAdjusted;
        app.lastPredictedBucket = bucket;
    }

    public void setEstimatedLaunchTime(String packageName, int userId, long nowElapsed, long launchTime) {
        ArrayMap<String, AppUsageHistory> userHistory = getUserHistory(userId);
        AppUsageHistory appUsageHistory = getPackageHistory(userHistory, packageName, nowElapsed, true);
        appUsageHistory.nextEstimatedLaunchTime = launchTime;
    }

    public void setLastJobRunTime(String packageName, int userId, long elapsedRealtime) {
        ArrayMap<String, AppUsageHistory> userHistory = getUserHistory(userId);
        AppUsageHistory appUsageHistory = getPackageHistory(userHistory, packageName, elapsedRealtime, true);
        appUsageHistory.lastJobRunTime = getElapsedTime(elapsedRealtime);
    }

    void noteRestrictionAttempt(String packageName, int userId, long elapsedRealtime, int reason) {
        ArrayMap<String, AppUsageHistory> userHistory = getUserHistory(userId);
        AppUsageHistory appUsageHistory = getPackageHistory(userHistory, packageName, elapsedRealtime, true);
        appUsageHistory.lastRestrictAttemptElapsedTime = getElapsedTime(elapsedRealtime);
        appUsageHistory.lastRestrictReason = reason;
    }

    public long getEstimatedLaunchTime(String packageName, int userId, long nowElapsed) {
        ArrayMap<String, AppUsageHistory> userHistory = getUserHistory(userId);
        AppUsageHistory appUsageHistory = getPackageHistory(userHistory, packageName, nowElapsed, false);
        if (appUsageHistory != null) goto L5;
        return Long.MAX_VALUE;
    L5:
        if (appUsageHistory.nextEstimatedLaunchTime >= System.currentTimeMillis()) goto L8;
        return Long.MAX_VALUE;
    L8:
        return appUsageHistory.nextEstimatedLaunchTime;
    }

    public long getTimeSinceLastJobRun(String packageName, int userId, long elapsedRealtime) {
        ArrayMap<String, AppUsageHistory> userHistory = getUserHistory(userId);
        AppUsageHistory appUsageHistory = getPackageHistory(userHistory, packageName, elapsedRealtime, false);
        if (appUsageHistory != null) goto L5;
        return Long.MAX_VALUE;
    L5:
        if (appUsageHistory.lastJobRunTime != Long.MIN_VALUE) goto L8;
        return Long.MAX_VALUE;
    L8:
        return getElapsedTime(elapsedRealtime) - appUsageHistory.lastJobRunTime;
    }

    public long getTimeSinceLastUsedByUser(String packageName, int userId, long elapsedRealtime) {
        ArrayMap<String, AppUsageHistory> userHistory = getUserHistory(userId);
        AppUsageHistory appUsageHistory = getPackageHistory(userHistory, packageName, elapsedRealtime, false);
        if (appUsageHistory != null) goto L5;
        return Long.MAX_VALUE;
    L5:
        if (appUsageHistory.lastUsedByUserElapsedTime != Long.MIN_VALUE) goto L7;
        return Long.MAX_VALUE;
    L7:
        if (appUsageHistory.lastUsedByUserElapsedTime > 0) goto L10;
        return Long.MAX_VALUE;
    L10:
        return getElapsedTime(elapsedRealtime) - appUsageHistory.lastUsedByUserElapsedTime;
    }

    public int getAppStandbyBucket(String packageName, int userId, long elapsedRealtime) {
        ArrayMap<String, AppUsageHistory> userHistory = getUserHistory(userId);
        AppUsageHistory appUsageHistory = getPackageHistory(userHistory, packageName, elapsedRealtime, false);
        if (appUsageHistory != null) goto L6;
        return 50;
    L6:
        return appUsageHistory.currentBucket;
    }

    public ArrayList<AppStandbyInfo> getAppStandbyBuckets(int userId, boolean appIdleEnabled) {
        ArrayMap<String, AppUsageHistory> userHistory = getUserHistory(userId);
        int size = userHistory.size();
        ArrayList<AppStandbyInfo> buckets = new ArrayList(size);
        int i = 0;
    L3:
        if (i >= size) goto L10;
        String r5 = userHistory.keyAt(i);
        if (appIdleEnabled == false) goto L7;
        int r6 = userHistory.valueAt(i).currentBucket;
    L8:
        buckets.add(new AppStandbyInfo(r5, r6));
        i = i + 1;
        goto L3
    L7:
        r6 = 10;
        goto L8
    L10:
        return buckets;
    }

    public int getAppStandbyReason(String packageName, int userId, long elapsedRealtime) {
        ArrayMap<String, AppUsageHistory> userHistory = getUserHistory(userId);
        AppUsageHistory appUsageHistory = getPackageHistory(userHistory, packageName, elapsedRealtime, false);
        if (appUsageHistory != null) goto L7;
        return 0;
    L7:
        return appUsageHistory.bucketingReason;
    }

    public long getElapsedTime(long elapsedRealtime) {
        return (elapsedRealtime - this.mElapsedSnapshot) + this.mElapsedDuration;
    }

    public int setIdle(String packageName, int userId, boolean idle, long elapsedRealtime) {
        if (idle == false) goto L12;
        AppUsageHistory appHistory = getAppUsageHistory(packageName, userId, elapsedRealtime);
        if (appHistory.bucketExpiryTimesMs == null) goto L11;
        int i = appHistory.bucketExpiryTimesMs.size() - 1;
    L6:
        if (i < 0) goto L11;
        if (appHistory.bucketExpiryTimesMs.keyAt(i) >= 40) goto L10;
        appHistory.bucketExpiryTimesMs.removeAt(i);
    L10:
        i = i - 1;
    L11:
        int newBucket = 40;
        int reason = 1024;
    L13:
        setAppStandbyBucket(packageName, userId, elapsedRealtime, newBucket, reason, false);
        return newBucket;
    L12:
        newBucket = 10;
        reason = 771;
        goto L13
    }

    public void clearUsage(String packageName, int userId) {
        ArrayMap<String, AppUsageHistory> userHistory = getUserHistory(userId);
        userHistory.remove(packageName);
    }

    boolean shouldInformListeners(String packageName, int userId, long elapsedRealtime, int bucket) {
        ArrayMap<String, AppUsageHistory> userHistory = getUserHistory(userId);
        AppUsageHistory appUsageHistory = getPackageHistory(userHistory, packageName, elapsedRealtime, true);
        if (appUsageHistory.lastInformedBucket == bucket) goto L6;
        appUsageHistory.lastInformedBucket = bucket;
        return true;
    L6:
        return false;
    }

    int getThresholdIndex(String packageName, int userId, long elapsedRealtime, long[] screenTimeThresholds, long[] elapsedTimeThresholds) {
        ArrayMap<String, AppUsageHistory> userHistory = getUserHistory(userId);
        AppUsageHistory appUsageHistory = getPackageHistory(userHistory, packageName, elapsedRealtime, false);
        if (appUsageHistory == null) goto L15;
        if (appUsageHistory.lastUsedElapsedTime < 0) goto L15;
        long r7 = getScreenOnTime(elapsedRealtime) - appUsageHistory.lastUsedScreenTime;
        long r9 = getElapsedTime(elapsedRealtime) - appUsageHistory.lastUsedElapsedTime;
        long elapsedDelta = (getElapsedTime(elapsedRealtime) - appUsageHistory.lastUsedElapsedTime) + this.mPowerAdvisorInternal.getAdjustUsedElapsedTime(userId, packageName);
        int i = screenTimeThresholds.length - 1;
    L7:
        if (i < 0) goto L12;
        if (elapsedDelta >= elapsedTimeThresholds[i]) goto L10;
        i = i - 1;
        goto L7
    L10:
        return i;
    L12:
        return 0;
    L15:
        return -1;
    }

    private void logAppStandbyBucketChanged(String packageName, int userId, int bucket, int reason) {
        FrameworkStatsLog.write(258, packageName, userId, bucket, reason & JobPackageTracker.EVENT_STOP_REASON_MASK, reason & 255);
    }

    long getBucketExpiryTimeMs(String packageName, int userId, int bucket, long elapsedRealtimeMs) {
        ArrayMap<String, AppUsageHistory> userHistory = getUserHistory(userId);
        AppUsageHistory appUsageHistory = getPackageHistory(userHistory, packageName, elapsedRealtimeMs, false);
        if (appUsageHistory != null) goto L5;
    L9:
        return 0;
    L5:
        if (appUsageHistory.bucketExpiryTimesMs == null) goto L9;
        return appUsageHistory.bucketExpiryTimesMs.get(bucket, 0);
    }

    private File getUserDirectory(int userId) {
        return new File(new File(this.mStorageDir, DatabaseHelper.SoundModelContract.KEY_USERS), Integer.toString(userId));
    }

    File getUserFile(int userId) {
        return new File(getUserDirectory(userId), APP_IDLE_FILENAME);
    }

    void clearLastUsedTimestamps(String packageName, int userId) {
        ArrayMap<String, AppUsageHistory> userHistory = getUserHistory(userId);
        AppUsageHistory appUsageHistory = getPackageHistory(userHistory, packageName, SystemClock.elapsedRealtime(), false);
        if (appUsageHistory == null) goto L6;
        appUsageHistory.lastUsedByUserElapsedTime = -2147483648L;
        appUsageHistory.lastUsedElapsedTime = -2147483648L;
        appUsageHistory.lastUsedScreenTime = -2147483648L;
        return;
    }

    public boolean userFileExists(int userId) {
        return getUserFile(userId).exists();
    }

    private void readAppIdleTimes(int userId, ArrayMap<String, AppUsageHistory> userHistory) {
        FileInputStream fis = null;
        AtomicFile appIdleFile = new AtomicFile(getUserFile(userId));     // Catch: Throwable -> L15 Throwable -> L17 FileNotFoundException -> L19
        fis = appIdleFile.openRead();     // Catch: Throwable -> L15 Throwable -> L17 FileNotFoundException -> L19
        XmlPullParser parser = Xml.newPullParser();     // Catch: Throwable -> L74 Throwable -> L76 FileNotFoundException -> L78
        parser.setInput(fis, StandardCharsets.UTF_8.name());     // Catch: Throwable -> L74 Throwable -> L76 FileNotFoundException -> L78
    L6:
        int type = parser.next();     // Catch: Throwable -> L74 Throwable -> L76 FileNotFoundException -> L78
        int r9 = 1;
        int r10 = 2;
        if (type == 2) goto L11;
        if (type != 1) goto L6;
    L11:
        if (type == 2) goto L22;
        Slog.e(TAG, "Unable to read app idle file for user " + userId);     // Catch: Throwable -> L15 Throwable -> L17 Throwable -> L17 FileNotFoundException -> L19
        IoUtils.closeQuietly(fis);
        return;
    L22:
        if (parser.getName().equals(TAG_PACKAGES) == true) goto L25;
        IoUtils.closeQuietly(fis);
        return;
    L25:
        int version = getIntValue(parser, ATTR_VERSION, 0);     // Catch: Throwable -> L74 Throwable -> L76 Throwable -> L76 FileNotFoundException -> L78
    L26:
        int type2 = parser.next();     // Catch: Throwable -> L74 Throwable -> L76 Throwable -> L76 FileNotFoundException -> L78
        if (type2 == r9) goto L84;
        if (type2 != r10) goto L82;
        String name = parser.getName();     // Catch: Throwable -> L74 Throwable -> L76 Throwable -> L76 FileNotFoundException -> L78
        if (name.equals("package") == false) goto L80;
        String packageName = parser.getAttributeValue(null, "name");     // Catch: Throwable -> L74 Throwable -> L76 Throwable -> L76 FileNotFoundException -> L78
        AppUsageHistory appUsageHistory = new AppUsageHistory();     // Catch: Throwable -> L74 Throwable -> L76 Throwable -> L76 FileNotFoundException -> L78
        appUsageHistory.lastUsedElapsedTime = Long.parseLong(parser.getAttributeValue(null, ATTR_ELAPSED_IDLE));     // Catch: Throwable -> L74 Throwable -> L76 Throwable -> L76 FileNotFoundException -> L78
        appUsageHistory.lastUsedByUserElapsedTime = getLongValue(parser, ATTR_LAST_USED_BY_USER_ELAPSED, appUsageHistory.lastUsedElapsedTime);     // Catch: Throwable -> L74 Throwable -> L76 Throwable -> L76 FileNotFoundException -> L78
        appUsageHistory.lastUsedScreenTime = Long.parseLong(parser.getAttributeValue(null, ATTR_SCREEN_IDLE));     // Catch: Throwable -> L74 Throwable -> L76 Throwable -> L76 FileNotFoundException -> L78
        appUsageHistory.lastPredictedTime = getLongValue(parser, ATTR_LAST_PREDICTED_TIME, 0);     // Catch: Throwable -> L74 Throwable -> L76 Throwable -> L76 FileNotFoundException -> L78
        String currentBucketString = parser.getAttributeValue(null, ATTR_CURRENT_BUCKET);     // Catch: Throwable -> L74 Throwable -> L76 Throwable -> L76 FileNotFoundException -> L78
        if (currentBucketString != null) goto L34;
        int r0 = 10;
    L35:
        appUsageHistory.currentBucket = r0;     // Catch: Throwable -> L74 Throwable -> L76 Throwable -> L76 FileNotFoundException -> L78
        String bucketingReason = parser.getAttributeValue(null, ATTR_BUCKETING_REASON);     // Catch: Throwable -> L74 Throwable -> L76 Throwable -> L76 FileNotFoundException -> L78
        appUsageHistory.lastJobRunTime = getLongValue(parser, ATTR_LAST_RUN_JOB_TIME, Long.MIN_VALUE);     // Catch: Throwable -> L74 Throwable -> L76 Throwable -> L76 FileNotFoundException -> L78
        appUsageHistory.bucketingReason = 256;     // Catch: Throwable -> L74 Throwable -> L76 Throwable -> L76 FileNotFoundException -> L78
        if (bucketingReason == null) goto L43;
        appUsageHistory.bucketingReason = Integer.parseInt(bucketingReason, 16);     // Catch: Throwable -> L15 Throwable -> L17 Throwable -> L17 FileNotFoundException -> L19 NumberFormatException -> L40
    L40:
        nfe = move-exception;
        Slog.wtf(TAG, "Unable to read bucketing reason", nfe);     // Catch: Throwable -> L15 Throwable -> L17 Throwable -> L17 FileNotFoundException -> L19
    L43:
        FileInputStream fis2 = fis;
        AtomicFile appIdleFile2 = appIdleFile;
        appUsageHistory.lastRestrictAttemptElapsedTime = getLongValue(parser, ATTR_LAST_RESTRICTION_ATTEMPT_ELAPSED, 0);     // Catch: Throwable -> L50 Throwable -> L52 FileNotFoundException -> L54
        String lastRestrictReason = parser.getAttributeValue(null, ATTR_LAST_RESTRICTION_ATTEMPT_REASON);     // Catch: Throwable -> L50 Throwable -> L52 FileNotFoundException -> L54
        goto L55
    L46:
        if (lastRestrictReason != null) goto L95;
    L58:
        appUsageHistory.nextEstimatedLaunchTime = getLongValue(parser, ATTR_NEXT_ESTIMATED_APP_LAUNCH_TIME, 0);     // Catch: Throwable -> L50 Throwable -> L52 Throwable -> L52 FileNotFoundException -> L54
        appUsageHistory.lastInformedBucket = appUsageHistory.currentBucket;     // Catch: Throwable -> L50 Throwable -> L52 Throwable -> L52 FileNotFoundException -> L54
        userHistory.put(packageName, appUsageHistory);     // Catch: Throwable -> L50 Throwable -> L52 Throwable -> L52 FileNotFoundException -> L54
        if (version < 1) goto L68;
        int outerDepth = parser.getDepth();     // Catch: Throwable -> L50 Throwable -> L52 Throwable -> L52 FileNotFoundException -> L54
    L62:
        if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L83;
        if (TAG_BUCKET_EXPIRY_TIMES.equals(parser.getName()) == false) goto L62;
        readBucketExpiryTimes(parser, appUsageHistory);     // Catch: Throwable -> L50 Throwable -> L52 Throwable -> L52 FileNotFoundException -> L54
    L83:
        fis = fis2;
        appIdleFile = appIdleFile2;
        r9 = 1;
        r10 = 2;
        goto L26
    L68:
        long bucketActiveTimeoutTime = getLongValue(parser, ATTR_BUCKET_ACTIVE_TIMEOUT_TIME, 0);     // Catch: Throwable -> L50 Throwable -> L52 Throwable -> L52 FileNotFoundException -> L54
        long bucketWorkingSetTimeoutTime = getLongValue(parser, ATTR_BUCKET_WORKING_SET_TIMEOUT_TIME, 0);     // Catch: Throwable -> L50 Throwable -> L52 Throwable -> L52 FileNotFoundException -> L54
        if (bucketActiveTimeoutTime == 0) goto L71;
    L72:
        insertBucketExpiryTime(appUsageHistory, 10, bucketActiveTimeoutTime);     // Catch: Throwable -> L50 Throwable -> L52 Throwable -> L52 FileNotFoundException -> L54
        insertBucketExpiryTime(appUsageHistory, 20, bucketWorkingSetTimeoutTime);     // Catch: Throwable -> L50 Throwable -> L52 Throwable -> L52 FileNotFoundException -> L54
        goto L83
    L71:
        if (bucketWorkingSetTimeoutTime == 0) goto L83;
    L95:
        appUsageHistory.lastRestrictReason = Integer.parseInt(lastRestrictReason, 16);     // Catch: Throwable -> L50 Throwable -> L52 Throwable -> L52 FileNotFoundException -> L54 NumberFormatException -> L56
    L56:
        nfe = move-exception;
        Slog.wtf(TAG, "Unable to read last restrict reason", nfe);     // Catch: Throwable -> L50 Throwable -> L52 Throwable -> L52 FileNotFoundException -> L54
    L52:
        e = e;
        fis = fis2;
    L86:
        Slog.e(TAG, "Unable to read app idle file for user " + userId, e);     // Catch: Throwable -> L15
        IoUtils.closeQuietly(fis);
        return;
    L50:
        th = th;
        fis = fis2;
    L92:
        IoUtils.closeQuietly(fis);
        throw th;
    L55:
        fis = fis2;
        goto L89
    L34:
        r0 = Integer.parseInt(currentBucketString);     // Catch: Throwable -> L74 Throwable -> L76 Throwable -> L76 FileNotFoundException -> L78
        goto L35
    L80:
        fis2 = fis;
        appIdleFile2 = appIdleFile;
        goto L83
    L82:
        fis2 = fis;
        appIdleFile2 = appIdleFile;
        goto L83
    L84:
        IoUtils.closeQuietly(fis);
        return;
    L76:
        e = e;
    L74:
        th = th;
    L17:
        e = e;
    L89:
        Slog.d(TAG, "App idle file for user " + userId + " does not exist");     // Catch: Throwable -> L15
        IoUtils.closeQuietly(fis);
        return;
    L15:
        th = th;
        goto L92
    }

    private void readBucketExpiryTimes(XmlPullParser parser, AppUsageHistory appUsageHistory) throws IOException, XmlPullParserException {
        int depth = parser.getDepth();
    L4:
        if (XmlUtils.nextElementWithin(parser, depth) == false) goto L11;
        if ("item".equals(parser.getName()) == false) goto L4;
        int bucket = getIntValue(parser, ATTR_BUCKET, -1);
        if (bucket == (-1)) goto L9;
        long expiryTimeMs = getLongValue(parser, ATTR_EXPIRY_TIME, 0);
        insertBucketExpiryTime(appUsageHistory, bucket, expiryTimeMs);
        goto L4
    L9:
        Slog.e(TAG, "Error reading the buckets expiry times");
        goto L4
    }

    private void insertBucketExpiryTime(AppUsageHistory appUsageHistory, int bucket, long expiryTimeMs) {
        if (expiryTimeMs != 0) goto L6;
        return;
    L6:
        if (appUsageHistory.bucketExpiryTimesMs != null) goto L8;
        appUsageHistory.bucketExpiryTimesMs = new SparseLongArray();
    L8:
        appUsageHistory.bucketExpiryTimesMs.put(bucket, expiryTimeMs);
    }

    private long getLongValue(XmlPullParser parser, String attrName, long defValue) {
        String value = parser.getAttributeValue(null, attrName);
        if (value != null) goto L6;
        return defValue;
    L6:
        return Long.parseLong(value);
    }

    private int getIntValue(XmlPullParser parser, String attrName, int defValue) {
        String value = parser.getAttributeValue(null, attrName);
        if (value != null) goto L6;
        return defValue;
    L6:
        return Integer.parseInt(value);
    }

    public void writeAppIdleTimes(long elapsedRealtimeMs) {
        int size = this.mIdleHistory.size();
        int i = 0;
    L3:
        if (i >= size) goto L6;
        writeAppIdleTimes(this.mIdleHistory.keyAt(i), elapsedRealtimeMs);
        i = i + 1;
        goto L3
    }

    public void writeAppIdleTimes(int userId, long elapsedRealtimeMs) {
        FileOutputStream fos = null;
        AtomicFile appIdleFile = new AtomicFile(getUserFile(userId));
        fos = appIdleFile.startWrite();     // Catch: Exception -> L37
        BufferedOutputStream bos = new BufferedOutputStream(fos);     // Catch: Exception -> L37
        FastXmlSerializer xml = new FastXmlSerializer();     // Catch: Exception -> L37
        xml.setOutput(bos, StandardCharsets.UTF_8.name());     // Catch: Exception -> L37
        xml.startDocument(null, true);     // Catch: Exception -> L37
        xml.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);     // Catch: Exception -> L37
        xml.startTag(null, TAG_PACKAGES);     // Catch: Exception -> L37
        xml.attribute(null, ATTR_VERSION, String.valueOf(1));     // Catch: Exception -> L37
        long elapsedTimeMs = getElapsedTime(elapsedRealtimeMs);     // Catch: Exception -> L11
        ArrayMap<String, AppUsageHistory> userHistory = getUserHistory(userId);     // Catch: Exception -> L11
        int N = userHistory.size();     // Catch: Exception -> L11
        int i = 0;
    L6:
        BufferedOutputStream bos2 = bos;
        N = N;
        if (i >= N) goto L35;
        String packageName = userHistory.keyAt(i);     // Catch: Exception -> L11
        if (packageName != null) goto L13;
        Slog.w(TAG, "Skipping App Idle write for unexpected null package");     // Catch: Exception -> L11
    L34:
        i = i + 1;     // Catch: Exception -> L11
        bos = bos2;
        userHistory = userHistory;
        goto L6
    L13:
        AppUsageHistory history = userHistory.valueAt(i);     // Catch: Exception -> L11
        xml.startTag(null, "package");     // Catch: Exception -> L11
        xml.attribute(null, "name", packageName);     // Catch: Exception -> L11
        xml.attribute(null, ATTR_ELAPSED_IDLE, Long.toString(history.lastUsedElapsedTime));     // Catch: Exception -> L11
        xml.attribute(null, ATTR_LAST_USED_BY_USER_ELAPSED, Long.toString(history.lastUsedByUserElapsedTime));     // Catch: Exception -> L11
        xml.attribute(null, ATTR_SCREEN_IDLE, Long.toString(history.lastUsedScreenTime));     // Catch: Exception -> L11
        xml.attribute(null, ATTR_LAST_PREDICTED_TIME, Long.toString(history.lastPredictedTime));     // Catch: Exception -> L11
        xml.attribute(null, ATTR_CURRENT_BUCKET, Integer.toString(history.currentBucket));     // Catch: Exception -> L11
        xml.attribute(null, ATTR_BUCKETING_REASON, Integer.toHexString(history.bucketingReason));     // Catch: Exception -> L11
        if (history.lastJobRunTime == Long.MIN_VALUE) goto L17;
        xml.attribute(null, ATTR_LAST_RUN_JOB_TIME, Long.toString(history.lastJobRunTime));     // Catch: Exception -> L11
    L17:
        if (history.lastRestrictAttemptElapsedTime <= 0) goto L19;
        xml.attribute(null, ATTR_LAST_RESTRICTION_ATTEMPT_ELAPSED, Long.toString(history.lastRestrictAttemptElapsedTime));     // Catch: Exception -> L11
    L19:
        xml.attribute(null, ATTR_LAST_RESTRICTION_ATTEMPT_REASON, Integer.toHexString(history.lastRestrictReason));     // Catch: Exception -> L11
        if (history.nextEstimatedLaunchTime <= 0) goto L23;
        xml.attribute(null, ATTR_NEXT_ESTIMATED_APP_LAUNCH_TIME, Long.toString(history.nextEstimatedLaunchTime));     // Catch: Exception -> L11
    L23:
        if (history.bucketExpiryTimesMs == null) goto L33;
        xml.startTag(null, TAG_BUCKET_EXPIRY_TIMES);     // Catch: Exception -> L11
        int size = history.bucketExpiryTimesMs.size();     // Catch: Exception -> L11
        int j = 0;
    L25:
        if (j >= size) goto L31;
        long expiryTimeMs = history.bucketExpiryTimesMs.valueAt(j);     // Catch: Exception -> L11
        if (expiryTimeMs < elapsedTimeMs) goto L30;
        int bucket = history.bucketExpiryTimesMs.keyAt(j);     // Catch: Exception -> L11
        xml.startTag(null, "item");     // Catch: Exception -> L11
        xml.attribute(null, ATTR_BUCKET, String.valueOf(bucket));     // Catch: Exception -> L11
        xml.attribute(null, ATTR_EXPIRY_TIME, String.valueOf(expiryTimeMs));     // Catch: Exception -> L11
        xml.endTag(null, "item");     // Catch: Exception -> L11
    L30:
        j = j + 1;     // Catch: Exception -> L11
        history = history;
        size = size;
        goto L25
    L31:
        xml.endTag(null, TAG_BUCKET_EXPIRY_TIMES);     // Catch: Exception -> L11
    L33:
        xml.endTag(null, "package");     // Catch: Exception -> L11
        goto L34
    L35:
        xml.endTag(null, TAG_PACKAGES);     // Catch: Exception -> L11
        xml.endDocument();     // Catch: Exception -> L11
        appIdleFile.finishWrite(fos);     // Catch: Exception -> L11
        return;
    L11:
        e = e;
    L39:
        appIdleFile.failWrite(fos);
        Slog.e(TAG, "Error writing app idle file for user " + userId, e);
        return;
    L37:
        e = e;
        goto L39
    }

    public void dumpUsers(IndentingPrintWriter idpw, int[] userIds, List<String> pkgs) {
        int numUsers = userIds.length;
        int i = 0;
    L3:
        if (i >= numUsers) goto L6;
        idpw.println();
        dumpUser(idpw, userIds[i], pkgs);
        i = i + 1;
        goto L3
    }

    private void dumpUser(IndentingPrintWriter idpw, int userId, List<String> pkgs) {
        AppIdleHistory r0 = this;
        idpw.print("User ");
        idpw.print(userId);
        idpw.println(" App Standby States:");
        idpw.increaseIndent();
        ArrayMap<String, AppUsageHistory> userHistory = r0.mIdleHistory.get(userId);
        long now = System.currentTimeMillis();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long totalElapsedTime = r0.getElapsedTime(elapsedRealtime);
        r0.getScreenOnTime(elapsedRealtime);
        if (userHistory != null) goto L5;
        return;
    L5:
        int P = userHistory.size();
        int p = 0;
    L6:
        if (p >= P) goto L25;
        String packageName = userHistory.keyAt(p);
        AppUsageHistory appUsageHistory = userHistory.valueAt(p);
        if (CollectionUtils.isEmpty(pkgs) == true) goto L12;
        ArrayMap<String, AppUsageHistory> userHistory2 = userHistory;
        if (pkgs.contains(packageName) == true) goto L13;
        long now2 = now;
    L24:
        p = p + 1;
        userHistory = userHistory2;
        now = now2;
    L13:
        StringBuilder r1 = new StringBuilder();
        r1.append("package=");
        r1.append(packageName);
        idpw.print(r1.toString());
        idpw.print(" u=" + userId);
        idpw.print(" bucket=" + appUsageHistory.currentBucket + " reason=" + UsageStatsManager.reasonToString(appUsageHistory.bucketingReason));
        idpw.print(" used=");
        totalElapsedTime = totalElapsedTime;
        now2 = now;
        printLastActionElapsedTime(idpw, totalElapsedTime, appUsageHistory.lastUsedElapsedTime);
        idpw.print(" usedByUser=");
        printLastActionElapsedTime(idpw, totalElapsedTime, appUsageHistory.lastUsedByUserElapsedTime);
        idpw.print(" usedScr=");
        printLastActionElapsedTime(idpw, totalElapsedTime, appUsageHistory.lastUsedScreenTime);
        idpw.print(" lastPred=");
        r0 = this;
        r0.printLastActionElapsedTime(idpw, totalElapsedTime, appUsageHistory.lastPredictedTime);
        r0.dumpBucketExpiryTimes(idpw, appUsageHistory, totalElapsedTime);
        idpw.print(" lastJob=");
        TimeUtils.formatDuration(totalElapsedTime - appUsageHistory.lastJobRunTime, idpw);
        idpw.print(" lastInformedBucket=" + appUsageHistory.lastInformedBucket);
        if (appUsageHistory.lastRestrictAttemptElapsedTime <= 0) goto L17;
        idpw.print(" lastRestrictAttempt=");
        TimeUtils.formatDuration(totalElapsedTime - appUsageHistory.lastRestrictAttemptElapsedTime, idpw);
        idpw.print(" lastRestrictReason=" + UsageStatsManager.reasonToString(appUsageHistory.lastRestrictReason));
    L17:
        if (appUsageHistory.nextEstimatedLaunchTime <= 0) goto L19;
        idpw.print(" nextEstimatedLaunchTime=");
        TimeUtils.formatDuration(appUsageHistory.nextEstimatedLaunchTime - now2, idpw);
    L19:
        StringBuilder r4 = new StringBuilder();
        r4.append(" idle=");
        if (r0.isIdle(packageName, userId, elapsedRealtime) == false) goto L22;
        String r5 = "y";
    L23:
        r4.append(r5);
        idpw.print(r4.toString());
        idpw.println();
        goto L24
    L22:
        r5 = "n";
        goto L23
    L12:
        userHistory2 = userHistory;
        goto L13
    L25:
        idpw.println();
        idpw.print("totalElapsedTime=");
        TimeUtils.formatDuration(r0.getElapsedTime(elapsedRealtime), idpw);
        idpw.println();
        idpw.print("totalScreenOnTime=");
        TimeUtils.formatDuration(r0.getScreenOnTime(elapsedRealtime), idpw);
        idpw.println();
        idpw.decreaseIndent();
    }

    private void printLastActionElapsedTime(IndentingPrintWriter idpw, long totalElapsedTimeMS, long lastActionTimeMs) {
        if (lastActionTimeMs >= 0) goto L5;
        idpw.print("<uninitialized>");
        return;
    L5:
        TimeUtils.formatDuration(totalElapsedTimeMS - lastActionTimeMs, idpw);
    }

    private void dumpBucketExpiryTimes(IndentingPrintWriter idpw, AppUsageHistory appUsageHistory, long totalElapsedTimeMs) {
        idpw.print(" expiryTimes=");
        if (appUsageHistory.bucketExpiryTimesMs != null) goto L5;
    L15:
        idpw.print("<none>");
        return;
    L5:
        if (appUsageHistory.bucketExpiryTimesMs.size() == 0) goto L15;
        idpw.print("(");
        int size = appUsageHistory.bucketExpiryTimesMs.size();
        int i = 0;
    L8:
        if (i >= size) goto L13;
        int bucket = appUsageHistory.bucketExpiryTimesMs.keyAt(i);
        long expiryTimeMs = appUsageHistory.bucketExpiryTimesMs.valueAt(i);
        if (i == 0) goto L12;
        idpw.print(",");
    L12:
        idpw.print(bucket + ":");
        TimeUtils.formatDuration(totalElapsedTimeMs - expiryTimeMs, idpw);
        i = i + 1;
        goto L8
    L13:
        idpw.print(")");
    }
}
