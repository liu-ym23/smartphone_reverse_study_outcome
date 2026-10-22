package com.android.server.usage;

import android.app.usage.ConfigurationStats;
import android.app.usage.EventList;
import android.app.usage.EventStats;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.format.DateUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.LongSparseArray;
import android.util.Slog;
import android.util.SparseArrayMap;
import android.util.SparseIntArray;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.CollectionUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.server.ISmtResourceControl;
import com.android.server.am.AssistDataRequester;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.Settings;
import com.android.server.policy.PhoneWindowManager;
import com.android.server.voiceinteraction.DatabaseHelper;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
class UserUsageStatsService {
    private static final boolean DEBUG = false;
    private static final long[] INTERVAL_LENGTH = null;
    private static final String TAG = "UsageStatsService";
    private static final UsageStatsDatabase.StatCombiner<ConfigurationStats> sConfigStatsCombiner = null;
    private static final SimpleDateFormat sDateFormat = null;
    private static final int sDateFormatFlags = 131093;
    private static final UsageStatsDatabase.StatCombiner<EventStats> sEventStatsCombiner = null;
    private static final UsageStatsDatabase.StatCombiner<UsageStats> sUsageStatsCombiner = null;
    private NBArkBaseHandler mArkBaseHandler;
    private HandlerThread mArkbaseUUssThread;
    private final SparseArrayMap<String, CachedEarlyEvents> mCachedEarlyEvents;
    private final Context mContext;
    private final IntervalStats[] mCurrentStats;
    private final UnixCalendar mDailyExpiryDate;
    private final UsageStatsDatabase mDatabase;
    private String mLastBackgroundedPackage;
    private final StatsUpdatedListener mListener;
    private final String mLogPrefix;
    private long mRealTimeSnapshot;
    private boolean mStatsChanged;
    private long mSystemTimeSnapshot;
    private long mUSSTimeChangeMoment;
    private final int mUserId;

    private static final class CachedEarlyEvents {
        public long eventTime;
        public List<UsageEvents.Event> events;
        public long searchBeginTime;

        /* synthetic */ CachedEarlyEvents(UserUsageStatsServiceIA r1) {
            this();
        }

        private CachedEarlyEvents() {
        }
    }

    interface StatsUpdatedListener {
        void onNewUpdate(int r1);

        void onStatsReloaded();

        void onStatsUpdated();
    }

    /* JADX INFO: renamed from: $r8$lambda$AR4Jje2JY6H4-p2jLdP0IyCqy_Y, reason: not valid java name */
    public static /* synthetic */ boolean m9145$r8$lambda$AR4Jje2JY6H4p2jLdP0IyCqy_Y(long r0, long r2, String r4, ArraySet r5, boolean r6, IntervalStats r7, boolean r8, List r9) {
        return lambda$queryEventsForPackage$1(r0, r2, r4, r5, r6, r7, r8, r9);
    }

    /* JADX INFO: renamed from: $r8$lambda$g-bl5VNBpy8gjNFALWiQqGzaU1A, reason: not valid java name */
    public static /* synthetic */ boolean m9146$r8$lambda$gbl5VNBpy8gjNFALWiQqGzaU1A(long r0, long r2, String r4, int r5, IntervalStats r6, boolean r7, List r8) {
        return lambda$queryEarliestEventsForPackage$2(r0, r2, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ boolean $r8$lambda$p0y5lz5q5TqvoITutDfa1s61KzA(long r0, long r2, ArraySet r4, ArraySet r5, int r6, IntervalStats r7, boolean r8, List r9) {
        return lambda$queryEarliestAppEvents$0(r0, r2, r4, r5, r6, r7, r8, r9);
    }

    static {
        sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        INTERVAL_LENGTH = new long[]{86400000, UnixCalendar.WEEK_IN_MILLIS, UnixCalendar.MONTH_IN_MILLIS, 31536000000L};
        sUsageStatsCombiner = new AnonymousClass1();
        sConfigStatsCombiner = new AnonymousClass2();
        sEventStatsCombiner = new AnonymousClass3();
    }

    UserUsageStatsService(Context context, int userId, File usageStatsDir, StatsUpdatedListener listener) {
        this.mStatsChanged = false;
        this.mCachedEarlyEvents = new SparseArrayMap();
        this.mContext = context;
        this.mDailyExpiryDate = new UnixCalendar(0);
        this.mDatabase = new UsageStatsDatabase(usageStatsDir);
        this.mCurrentStats = new IntervalStats[4];
        this.mListener = listener;
        this.mLogPrefix = "User[" + Integer.toString(userId) + "] ";
        this.mUserId = userId;
        this.mRealTimeSnapshot = SystemClock.elapsedRealtime();
        this.mSystemTimeSnapshot = System.currentTimeMillis();
    }

    void init(long currentTimeMillis, HashMap<String, Long> installedPackages, boolean deleteObsoleteData) {
        readPackageMappingsLocked(installedPackages, deleteObsoleteData);
        this.mDatabase.init(currentTimeMillis);
        if (this.mDatabase.wasUpgradePerformed() == false) goto L5;
        this.mDatabase.prunePackagesDataOnUpgrade(installedPackages);
    L5:
        int nullCount = 0;
        int i = 0;
    L7:
        if (i >= this.mCurrentStats.length) goto L13;
        this.mCurrentStats[i] = this.mDatabase.getLatestUsageStats(i);
        if (this.mCurrentStats[i] != null) goto L11;
        nullCount = nullCount + 1;
    L11:
        i = i + 1;
        goto L7
    L13:
        if (nullCount > 0) goto L15;
        updateRolloverDeadline();
    L19:
        IntervalStats currentDailyStats = this.mCurrentStats[0];
        if (currentDailyStats == null) goto L23;
        UsageEvents.Event shutdownEvent = new UsageEvents.Event(26, Math.max(currentDailyStats.lastTimeSaved, currentDailyStats.endTime));
        shutdownEvent.mPackage = PackageManagerService.PLATFORM_PACKAGE_NAME;
        currentDailyStats.addEvent(shutdownEvent);
        UsageEvents.Event startupEvent = new UsageEvents.Event(27, System.currentTimeMillis());
        startupEvent.mPackage = PackageManagerService.PLATFORM_PACKAGE_NAME;
        currentDailyStats.addEvent(startupEvent);
    L23:
        if (this.mDatabase.isNewUpdate() == false) goto L26;
        notifyNewUpdate();
    L26:
        if (NBArkBaseHandler.isArkBaseAppExist(this.mContext) == false) goto L32;
        initArkBaseThread();
        return;
    L32:
        return;
    L15:
        if (nullCount == this.mCurrentStats.length) goto L17;
        Slog.w(TAG, this.mLogPrefix + "Some stats have no latest available");
    L17:
        loadActiveStats(currentTimeMillis);
        goto L19
    }

    void userStopped() {
        persistActiveStats();
        this.mCachedEarlyEvents.clear();
        if (this.mArkBaseHandler == null) goto L6;
        this.mArkBaseHandler.removeCallbacksAndMessages(null);
    L6:
        if (this.mArkbaseUUssThread == null) goto L8;
        this.mArkbaseUUssThread.quitSafely();
    L8:
        this.mArkBaseHandler = null;
        this.mArkbaseUUssThread = null;
    }

    int onPackageRemoved(String packageName, long timeRemoved) {
        int i = this.mCachedEarlyEvents.numMaps() - 1;
    L3:
        if (i < 0) goto L6;
        int eventType = this.mCachedEarlyEvents.keyAt(i);
        this.mCachedEarlyEvents.delete(eventType, packageName);
        i = i - 1;
        goto L3
    L6:
        return this.mDatabase.onPackageRemoved(packageName, timeRemoved);
    }

    private void readPackageMappingsLocked(HashMap<String, Long> installedPackages, boolean deleteObsoleteData) {
        this.mDatabase.readMappingsLocked();
        if (this.mUserId == 0) goto L7;
        if (deleteObsoleteData == false) goto L8;
        updatePackageMappingsLocked(installedPackages);
        return;
    L8:
        return;
    }

    boolean updatePackageMappingsLocked(HashMap<String, Long> installedPackages) {
        if (ArrayUtils.isEmpty(installedPackages) == false) goto L5;
        return true;
    L5:
        long timeNow = System.currentTimeMillis();
        ArrayList<String> removedPackages = new ArrayList();
        int i = this.mDatabase.mPackagesTokenData.packagesToTokensMap.size() - 1;
    L6:
        if (i < 0) goto L12;
        String packageName = this.mDatabase.mPackagesTokenData.packagesToTokensMap.keyAt(i);
        if (installedPackages.containsKey(packageName) == true) goto L10;
        removedPackages.add(packageName);
    L10:
        i = i - 1;
        goto L6
    L12:
        if (removedPackages.isEmpty() == false) goto L14;
        return true;
    L14:
        int i2 = removedPackages.size() - 1;
    L15:
        if (i2 < 0) goto L23;
        this.mDatabase.mPackagesTokenData.removePackage(removedPackages.get(i2), timeNow);
        i2 = i2 - 1;
        goto L15
    L23:
        this.mDatabase.writeMappingsLocked();     // Catch: Exception -> L20
        return true;
    L21:
        Slog.w(TAG, "Unable to write updated package mappings file on service initialization.");
        return false;
    }

    boolean pruneUninstalledPackagesData() {
        return this.mDatabase.pruneUninstalledPackagesData();
    }

    private void onTimeChanged(long oldTime, long newTime) {
        this.mCachedEarlyEvents.clear();
        persistActiveStats();
        this.mDatabase.onTimeChanged(newTime - oldTime);
        loadActiveStats(newTime);
    }

    private long checkAndGetTimeLocked() {
        long actualSystemTime = System.currentTimeMillis();
        if (UsageStatsService.ENABLE_TIME_CHANGE_CORRECTION == true) goto L5;
        return actualSystemTime;
    L5:
        long actualRealtime = SystemClock.elapsedRealtime();
        long expectedSystemTime = (actualRealtime - this.mRealTimeSnapshot) + this.mSystemTimeSnapshot;
        long diffSystemTime = actualSystemTime - expectedSystemTime;
        if (Math.abs(diffSystemTime) <= ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME) goto L8;
        this.mUSSTimeChangeMoment = 0;
        Slog.i(TAG, this.mLogPrefix + "Time changed in by " + (diffSystemTime / 1000) + " seconds");
        onTimeChanged(expectedSystemTime, actualSystemTime);
        this.mRealTimeSnapshot = actualRealtime;
        this.mSystemTimeSnapshot = actualSystemTime;
    L8:
        return actualSystemTime;
    }

    private void convertToSystemTimeLocked(UsageEvents.Event event) {
        event.mTimeStamp = Math.max(0, event.mTimeStamp - this.mRealTimeSnapshot) + this.mSystemTimeSnapshot;
    }

    void reportEvent(UsageEvents.Event event) {
        if (event.mEventType == 7) goto L8;
        if (event.mEventType == 31) goto L8;
        checkAndGetTimeLocked();
        convertToSystemTimeLocked(event);
    L8:
        if (this.mUSSTimeChangeMoment <= 0) goto L12;
        long diffTime = System.currentTimeMillis() - this.mUSSTimeChangeMoment;
        if (diffTime <= ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME) goto L12;
        Slog.d(TAG, this.mLogPrefix + "reportEvent, reset mUSSTimeChangeMoment");
        this.mUSSTimeChangeMoment = 0;
    L12:
        long diffTime2 = event.mTimeStamp;
        if (diffTime2 < this.mDailyExpiryDate.getTimeInMillis()) goto L18;
        Slog.d(TAG, this.mLogPrefix + "reportEvent, mUSSTimeChangeMoment: " + this.mUSSTimeChangeMoment);
        if (this.mUSSTimeChangeMoment > 0) goto L18;
        rolloverStats(event.mTimeStamp);
    L18:
        IntervalStats currentDailyStats = this.mCurrentStats[0];
        Configuration newFullConfig = event.mConfiguration;
        if (event.mEventType != 5) goto L24;
        if (currentDailyStats.activeConfiguration == null) goto L24;
        event.mConfiguration = Configuration.generateDelta(currentDailyStats.activeConfiguration, newFullConfig);
    L24:
        if (event.mEventType != 6) goto L26;
    L36:
        boolean incrementAppLaunch = false;
        if (event.mEventType != 1) goto L44;
        if (event.mPackage != null) goto L41;
    L48:
        IntervalStats[] r4 = this.mCurrentStats;
        int r5 = r4.length;
        int r6 = 0;
    L49:
        if (r6 >= r5) goto L68;
        IntervalStats stats = r4[r6];
        switch(event.mEventType) {
            case 5: goto L66;
            case 9: goto L59;
            case 15: goto L58;
            case 16: goto L57;
            case 17: goto L56;
            case 18: goto L55;
            default: goto L52;
        };
    L52:
        stats.update(event.mPackage, event.getClassName(), event.mTimeStamp, event.mEventType, event.mInstanceId);
        if (incrementAppLaunch == false) goto L67;
        stats.incrementAppLaunchCount(event.mPackage);
    L67:
        r6 = r6 + 1;
        goto L49
    L55:
        stats.updateKeyguardHidden(event.mTimeStamp);
        goto L67
    L56:
        stats.updateKeyguardShown(event.mTimeStamp);
        goto L67
    L57:
        stats.updateScreenNonInteractive(event.mTimeStamp);
        goto L67
    L58:
        stats.updateScreenInteractive(event.mTimeStamp);
        goto L67
    L59:
        stats.updateChooserCounts(event.mPackage, event.mContentType, event.mAction);
        String[] annotations = event.mContentAnnotations;
        if (annotations == null) goto L67;
        int r9 = annotations.length;
        int r10 = 0;
    L63:
        if (r10 >= r9) goto L67;
        String annotation = annotations[r10];
        stats.updateChooserCounts(event.mPackage, annotation, event.mAction);
        r10 = r10 + 1;
        goto L63
    L66:
        stats.updateConfigurationStats(newFullConfig, event.mTimeStamp);
        goto L67
    L68:
        notifyStatsChanged();
        return;
    L41:
        if (event.mPackage.equals(this.mLastBackgroundedPackage) == true) goto L48;
        incrementAppLaunch = true;
        goto L48
    L44:
        if (event.mEventType != 2) goto L48;
        if (event.mPackage == null) goto L48;
        this.mLastBackgroundedPackage = event.mPackage;
        goto L48
    L26:
        if (event.mEventType == 24) goto L36;
        if (event.mEventType == 25) goto L36;
        if (event.mEventType == 26) goto L36;
        if (event.mEventType == 31) goto L36;
        currentDailyStats.addEvent(event);
        if (this.mArkBaseHandler == null) goto L36;
        this.mArkBaseHandler.extractEvents2ArkBase(event);
        goto L36
    }

    private static boolean validRange(long currentTime, long beginTime, long endTime) {
        if (beginTime <= currentTime) goto L5;
    L7:
        return false;
    L5:
        if (beginTime >= endTime) goto L7;
        return true;
    }

    private <T> List<T> queryStats(int intervalType, long beginTime, long endTime, UsageStatsDatabase.StatCombiner<T> combiner, boolean skipEvents) {
        if (intervalType != 4) goto L8;
        int intervalType2 = this.mDatabase.findBestFitBucket(beginTime, endTime);
        if (intervalType2 >= 0) goto L7;
        int intervalType3 = 0;
    L10:
        if (intervalType3 < 0) goto L27;
        if (intervalType3 >= this.mCurrentStats.length) goto L27;
        IntervalStats currentStats = this.mCurrentStats[intervalType3];
        if (beginTime < currentStats.endTime) goto L17;
        return null;
    L17:
        long truncatedEndTime = Math.min(currentStats.beginTime, endTime);
        List<T> results = this.mDatabase.queryUsageStats(intervalType3, beginTime, truncatedEndTime, combiner, skipEvents);
        if (beginTime >= currentStats.endTime) goto L25;
        if (endTime <= currentStats.beginTime) goto L25;
        if (results != null) goto L23;
        results = new ArrayList();
    L23:
        this.mDatabase.filterStats(currentStats);
        combiner.combine(currentStats, true, results);
    L25:
        return results;
    L27:
        return null;
    L7:
        intervalType3 = intervalType2;
        goto L10
    L8:
        intervalType3 = intervalType;
        goto L10
    }

    List<UsageStats> queryUsageStats(int bucketType, long beginTime, long endTime) {
        if (validRange(checkAndGetTimeLocked(), beginTime, endTime) == true) goto L7;
        return null;
    L7:
        return queryStats(bucketType, beginTime, endTime, sUsageStatsCombiner, true);
    }

    List<ConfigurationStats> queryConfigurationStats(int bucketType, long beginTime, long endTime) {
        if (validRange(checkAndGetTimeLocked(), beginTime, endTime) == true) goto L7;
        return null;
    L7:
        return queryStats(bucketType, beginTime, endTime, sConfigStatsCombiner, true);
    }

    List<EventStats> queryEventStats(int bucketType, long beginTime, long endTime) {
        if (validRange(checkAndGetTimeLocked(), beginTime, endTime) == true) goto L7;
        return null;
    L7:
        return queryStats(bucketType, beginTime, endTime, sEventStatsCombiner, true);
    }

    UsageEvents queryEvents(final long beginTime, final long endTime, final int flags, int[] eventTypeFilter, final ArraySet<String> pkgNameFilter) {
        if (validRange(checkAndGetTimeLocked(), beginTime, endTime) == true) goto L5;
        return null;
    L5:
        final boolean isQueryForAllEvents = ArrayUtils.isEmpty(eventTypeFilter);
        int r1 = 0;
        if (pkgNameFilter != null) goto L8;
    L11:
        final boolean isQueryForAllPackages = true;
    L12:
        final boolean[] queryEventFilter = new boolean[33];
        if (isQueryForAllEvents == true) goto L24;
        int r2 = eventTypeFilter.length;
    L16:
        if (r1 >= r2) goto L24;
        int eventType = eventTypeFilter[r1];
        if (eventType < 0) goto L23;
        if (eventType > 32) goto L23;
        queryEventFilter[eventType] = true;
        r1 = r1 + 1;
    L23:
        throw new IllegalArgumentException("invalid event type: " + eventType);
    L24:
        final ArraySet<String> names = new ArraySet();
        List<UsageEvents.Event> results = queryStats(0, beginTime, endTime, new AnonymousClass4(this, beginTime, endTime, isQueryForAllEvents, queryEventFilter, flags, isQueryForAllPackages, pkgNameFilter, names), false);
        if (results != null) goto L27;
    L31:
        return null;
    L27:
        if (results.isEmpty() == true) goto L31;
        String[] table = (String[]) names.toArray(new String[names.size()]);
        Arrays.sort(table);
        return new UsageEvents(results, table, true);
    L8:
        if (pkgNameFilter.isEmpty() == true) goto L11;
        isQueryForAllPackages = false;
        goto L12
    }

    UsageEvents queryEarliestAppEvents(final long beginTime, final long endTime, final int eventType) {
        if (validRange(checkAndGetTimeLocked(), beginTime, endTime) == true) goto L5;
        return null;
    L5:
        final ArraySet<String> names = new ArraySet();
        final ArraySet<String> eventSuccess = new ArraySet();
        List<UsageEvents.Event> results = queryStats(0, beginTime, endTime, new UserUsageStatsService$$ExternalSyntheticLambda1(beginTime, endTime, eventSuccess, names, eventType), false);
        if (results != null) goto L8;
    L12:
        return null;
    L8:
        if (results.isEmpty() == true) goto L12;
        String[] table = (String[]) names.toArray(new String[names.size()]);
        Arrays.sort(table);
        return new UsageEvents(results, table, false);
    }

    private static /* synthetic */ boolean lambda$queryEarliestAppEvents$0(long beginTime, long endTime, ArraySet eventSuccess, ArraySet names, int eventType, IntervalStats stats, boolean mutable, List accumulatedResult) {
        int startIndex = stats.events.firstIndexOnOrAfter(beginTime);
        int size = stats.events.size();
        int i = startIndex;
    L3:
        if (i >= size) goto L20;
        UsageEvents.Event event = stats.events.get(i);
        if (event.getTimeStamp() >= endTime) goto L6;
        if (event.getPackageName() == null) goto L19;
        if (eventSuccess.contains(event.getPackageName()) == true) goto L19;
        boolean firstEvent = names.add(event.getPackageName());
        if (event.getEventType() != eventType) goto L17;
        accumulatedResult.add(event);
        eventSuccess.add(event.getPackageName());
        goto L19
    L17:
        if (firstEvent == false) goto L19;
        accumulatedResult.add(event);
    L19:
        i = i + 1;
        goto L3
    L6:
        return false;
    L20:
        return true;
    }

    UsageEvents queryEventsForPackage(final long beginTime, final long endTime, final String packageName, final boolean includeTaskRoot) {
        if (validRange(checkAndGetTimeLocked(), beginTime, endTime) == true) goto L5;
        return null;
    L5:
        final ArraySet<String> names = new ArraySet();
        names.add(packageName);
        List<UsageEvents.Event> results = queryStats(0, beginTime, endTime, new UserUsageStatsService$$ExternalSyntheticLambda0(beginTime, endTime, packageName, names, includeTaskRoot), false);
        if (results != null) goto L8;
    L12:
        return null;
    L8:
        if (results.isEmpty() == true) goto L12;
        String[] table = (String[]) names.toArray(new String[names.size()]);
        Arrays.sort(table);
        return new UsageEvents(results, table, includeTaskRoot);
    }

    private static /* synthetic */ boolean lambda$queryEventsForPackage$1(long beginTime, long endTime, String packageName, ArraySet names, boolean includeTaskRoot, IntervalStats stats, boolean mutable, List accumulatedResult) {
        int startIndex = stats.events.firstIndexOnOrAfter(beginTime);
        int size = stats.events.size();
        int i = startIndex;
    L3:
        if (i >= size) goto L24;
        UsageEvents.Event event = stats.events.get(i);
        if (event.mTimeStamp >= endTime) goto L6;
        if (packageName.equals(event.mPackage) == false) goto L23;
        if (event.mClass == null) goto L14;
        names.add(event.mClass);
    L14:
        if (includeTaskRoot == true) goto L16;
    L18:
        if (includeTaskRoot == true) goto L20;
    L22:
        accumulatedResult.add(event);
        goto L23
    L20:
        if (event.mTaskRootClass == null) goto L22;
        names.add(event.mTaskRootClass);
        goto L22
    L16:
        if (event.mTaskRootPackage == null) goto L18;
        names.add(event.mTaskRootPackage);
    L23:
        i = i + 1;
        goto L3
    L6:
        return false;
    L24:
        return true;
    }

    UsageEvents queryEarliestEventsForPackage(long beginTime, final long endTime, final String packageName, final int eventType) {
        long currentTime = checkAndGetTimeLocked();
        UserUsageStatsServiceIA r12 = null;
        if (validRange(currentTime, beginTime, endTime) == true) goto L5;
        return null;
    L5:
        CachedEarlyEvents cachedEvents = (CachedEarlyEvents) this.mCachedEarlyEvents.get(eventType, packageName);
        if (cachedEvents != null) goto L8;
        CachedEarlyEvents cachedEvents2 = new CachedEarlyEvents(r12);
        cachedEvents2.searchBeginTime = beginTime;
        this.mCachedEarlyEvents.add(eventType, packageName, cachedEvents2);
        CachedEarlyEvents cachedEvents3 = cachedEvents2;
        long beginTime2 = beginTime;
    L32:
        final long beginTime3 = beginTime2;
        List<UsageEvents.Event> results = queryStats(0, beginTime3, endTime, new UserUsageStatsService$$ExternalSyntheticLambda2(beginTime3, endTime, packageName, eventType), false);
        if (results != null) goto L35;
    L39:
        cachedEvents3.eventTime = Math.min(currentTime, endTime);
        cachedEvents3.events = null;
        return null;
    L35:
        if (results.isEmpty() == true) goto L39;
        cachedEvents3.eventTime = results.get(results.size() - 1).getTimeStamp();
        cachedEvents3.events = results;
        return new UsageEvents(results, new String[]{packageName}, false);
    L8:
        if (cachedEvents.searchBeginTime <= beginTime) goto L10;
    L30:
        cachedEvents.searchBeginTime = beginTime;
        cachedEvents3 = cachedEvents;
        beginTime2 = beginTime;
        goto L32
    L10:
        if (beginTime > cachedEvents.eventTime) goto L30;
        if (cachedEvents.events != null) goto L14;
        int numEvents = 0;
    L16:
        if (numEvents == 0) goto L20;
        if (cachedEvents.events.get(numEvents - 1).getEventType() != eventType) goto L20;
    L23:
        if (cachedEvents.eventTime <= endTime) goto L25;
        return null;
    L25:
        if (cachedEvents.events != null) goto L28;
        return null;
    L28:
        return new UsageEvents(cachedEvents.events, new String[]{packageName}, false);
    L20:
        if (cachedEvents.eventTime >= endTime) goto L23;
        cachedEvents3 = cachedEvents;
        beginTime2 = Math.min(currentTime, cachedEvents.eventTime);
        goto L32
    L14:
        numEvents = cachedEvents.events.size();
        goto L16
    }

    private static /* synthetic */ boolean lambda$queryEarliestEventsForPackage$2(long finalBeginTime, long endTime, String packageName, int eventType, IntervalStats stats, boolean mutable, List accumulatedResult) {
        int startIndex = stats.events.firstIndexOnOrAfter(finalBeginTime);
        int size = stats.events.size();
        int i = startIndex;
    L3:
        if (i >= size) goto L18;
        UsageEvents.Event event = stats.events.get(i);
        if (event.getTimeStamp() >= endTime) goto L6;
        if (packageName.equals(event.getPackageName()) == false) goto L17;
        if (event.getEventType() == eventType) goto L12;
        if (accumulatedResult.size() != 0) goto L17;
        accumulatedResult.add(event);
        goto L17
    L12:
        accumulatedResult.add(event);
        return false;
    L17:
        i = i + 1;
        goto L3
    L6:
        return false;
    L18:
        return true;
    }

    void persistActiveStats() {
        if (this.mStatsChanged == false) goto L18;
        Slog.i(TAG, this.mLogPrefix + "Flushing usage stats to disk");
        this.mDatabase.obfuscateCurrentStats(this.mCurrentStats);     // Catch: IOException -> L9
        this.mDatabase.writeMappingsLocked();     // Catch: IOException -> L9
        int i = 0;
    L7:
        if (i >= this.mCurrentStats.length) goto L11;
        this.mDatabase.putUsageStats(i, this.mCurrentStats[i]);     // Catch: IOException -> L9
        i = i + 1;     // Catch: IOException -> L9
        goto L7
    L11:
        this.mStatsChanged = false;     // Catch: IOException -> L9
        return;
    L9:
        e = move-exception;
        Slog.e(TAG, this.mLogPrefix + "Failed to persist active stats", e);
        return;
    }

    private void rolloverStats(long currentTimeMillis) {
        long startTime = SystemClock.elapsedRealtime();
        Slog.i(TAG, this.mLogPrefix + "Rolling over usage stats");
        int r5 = 0;
        Configuration previousConfig = this.mCurrentStats[0].activeConfiguration;
        ArraySet<String> continuePkgs = new ArraySet();
        ArrayMap<String, SparseIntArray> continueActivity = new ArrayMap();
        ArrayMap<String, ArrayMap<String, Integer>> continueForegroundService = new ArrayMap();
        IntervalStats[] r9 = this.mCurrentStats;
        int r10 = r9.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L23;
        IntervalStats stat = r9[r11];
        int pkgCount = stat.packageStats.size();
        int i = 0;
    L6:
        if (i >= pkgCount) goto L22;
        UsageStats pkgStats = stat.packageStats.valueAt(i);
        int r21 = r5;
        if (pkgStats.mActivities.size() > 0) goto L14;
        if (pkgStats.mForegroundServices.isEmpty() == false) goto L14;
        startTime = startTime;
        pkgCount = pkgCount;
        i = i;
    L21:
        i = i + 1;
        pkgCount = pkgCount;
        r5 = r21;
        startTime = startTime;
    L14:
        if (pkgStats.mActivities.size() <= 0) goto L18;
        continueActivity.put(pkgStats.mPackageName, pkgStats.mActivities);
        stat.update(pkgStats.mPackageName, null, this.mDailyExpiryDate.getTimeInMillis() - 1, 3, 0);
    L18:
        if (pkgStats.mForegroundServices.isEmpty() == true) goto L20;
        continueForegroundService.put(pkgStats.mPackageName, pkgStats.mForegroundServices);
        stat.update(pkgStats.mPackageName, null, this.mDailyExpiryDate.getTimeInMillis() - 1, 22, 0);
    L20:
        continuePkgs.add(pkgStats.mPackageName);
        notifyStatsChanged();
        goto L21
    L22:
        stat.updateConfigurationStats(null, this.mDailyExpiryDate.getTimeInMillis() - 1);
        stat.commitTime(this.mDailyExpiryDate.getTimeInMillis() - 1);
        r11 = r11 + 1;
        startTime = startTime;
        goto L3
    L23:
        long startTime2 = startTime;
        int r22 = r5;
        persistActiveStats();
        this.mDatabase.prune(currentTimeMillis);
        loadActiveStats(currentTimeMillis);
        int continueCount = continuePkgs.size();
        int i2 = 0;
    L24:
        if (i2 >= continueCount) goto L42;
        String pkgName = continuePkgs.valueAt(i2);
        long beginTime = this.mCurrentStats[r22].beginTime;
        IntervalStats[] r6 = this.mCurrentStats;
        int r12 = r6.length;
        int r13 = r22;
    L26:
        if (r13 >= r12) goto L41;
        int r16 = r12;
        IntervalStats stat2 = r6[r13];
        if (continueActivity.containsKey(pkgName) == false) goto L33;
        SparseIntArray eventMap = continueActivity.get(pkgName);
        int size = eventMap.size();
        int i3 = 0;
    L30:
        if (i3 >= size) goto L32;
        stat2.update(pkgName, null, beginTime, eventMap.valueAt(i3), eventMap.keyAt(i3));
        i3 = i3 + 1;
        r16 = r16;
        eventMap = eventMap;
        goto L30
    L32:
        int r24 = r16;
    L35:
        if (continueForegroundService.containsKey(pkgName) == false) goto L40;
        ArrayMap<String, Integer> eventMap2 = continueForegroundService.get(pkgName);
        int size2 = eventMap2.size();
        int j = 0;
    L37:
        if (j >= size2) goto L40;
        stat2.update(pkgName, eventMap2.keyAt(j), beginTime, eventMap2.valueAt(j).intValue(), 0);
        j = j + 1;
    L40:
        stat2.updateConfigurationStats(previousConfig, beginTime);
        notifyStatsChanged();
        r13 = r13 + 1;
        continueCount = continueCount;
        i2 = i2;
        r12 = r24;
        goto L26
    L33:
        r24 = r16;
        goto L35
    L41:
        i2 = i2 + 1;
        goto L24
    L42:
        persistActiveStats();
        long totalTime = SystemClock.elapsedRealtime() - startTime2;
        Slog.i(TAG, this.mLogPrefix + "Rolling over usage stats complete. Took " + totalTime + " milliseconds");
    }

    private void notifyStatsChanged() {
        if (this.mStatsChanged == true) goto L6;
        this.mStatsChanged = true;
        this.mListener.onStatsUpdated();
        return;
    }

    private void notifyNewUpdate() {
        this.mListener.onNewUpdate(this.mUserId);
    }

    private void loadActiveStats(long currentTimeMillis) {
        int intervalType = 0;
    L4:
        if (intervalType >= this.mCurrentStats.length) goto L12;
        IntervalStats stats = this.mDatabase.getLatestUsageStats(intervalType);
        if (stats != null) goto L8;
    L10:
        this.mCurrentStats[intervalType] = new IntervalStats();
        this.mCurrentStats[intervalType].beginTime = currentTimeMillis;
        long r3 = 1 + currentTimeMillis;
        this.mCurrentStats[intervalType].endTime = r3;
    L11:
        intervalType = intervalType + 1;
        goto L4
    L8:
        if (currentTimeMillis >= (stats.beginTime + INTERVAL_LENGTH[intervalType])) goto L10;
        this.mCurrentStats[intervalType] = stats;
        goto L11
    L12:
        this.mStatsChanged = false;
        updateRolloverDeadline();
        this.mListener.onStatsReloaded();
    }

    private void updateRolloverDeadline() {
        this.mDailyExpiryDate.setTimeInMillis(this.mCurrentStats[0].beginTime);
        this.mDailyExpiryDate.addDays(1);
        Slog.i(TAG, this.mLogPrefix + "Rollover scheduled @ " + sDateFormat.format(Long.valueOf(this.mDailyExpiryDate.getTimeInMillis())) + "(" + this.mDailyExpiryDate.getTimeInMillis() + ")");
    }

    void checkin(final IndentingPrintWriter pw) {
        this.mDatabase.checkinDailyFiles(new AnonymousClass5(this, pw));
    }

    void dump(IndentingPrintWriter pw, List<String> pkgs) {
        dump(pw, pkgs, false);
    }

    void dump(IndentingPrintWriter pw, List<String> pkgs, boolean compact) {
        printLast24HrEvents(pw, !compact, pkgs);
        dumpNubia(pw, pkgs, compact);
        int interval = 0;
    L4:
        if (interval >= this.mCurrentStats.length) goto L7;
        pw.print("In-memory ");
        pw.print(intervalToString(interval));
        pw.println(" stats");
        printIntervalStats(pw, this.mCurrentStats[interval], !compact, true, pkgs);
        interval = interval + 1;
        goto L4
    L7:
        if (CollectionUtils.isEmpty(pkgs) == false) goto L11;
        this.mDatabase.dump(pw, compact);
        return;
    }

    void dumpDatabaseInfo(IndentingPrintWriter ipw) {
        this.mDatabase.dump(ipw, false);
    }

    void dumpMappings(IndentingPrintWriter ipw) {
        this.mDatabase.dumpMappings(ipw);
    }

    void deleteDataFor(String pkg) {
        this.mDatabase.deleteDataFor(pkg);
    }

    void dumpFile(IndentingPrintWriter ipw, String[] args) {
        if (args != null) goto L4;
    L35:
        int numIntervals = this.mDatabase.mSortedStatFiles.length;
        int interval = 0;
    L36:
        if (interval >= numIntervals) goto L46;
        ipw.println("interval=" + intervalToString(interval));
        ipw.increaseIndent();
        dumpFileDetailsForInterval(ipw, interval);
        ipw.decreaseIndent();
        interval = interval + 1;
        goto L36
    L46:
        return;
    L4:
        if (args.length == 0) goto L35;
        int intervalValue = stringToInterval(args[0]);     // Catch: NumberFormatException -> L11
        if (intervalValue != (-1)) goto L13;
        int interval2 = Integer.valueOf(args[0]).intValue();     // Catch: NumberFormatException -> L11
    L15:
        if (interval2 >= 0) goto L17;
    L31:
        ipw.println("the specified interval does not exist.");
        return;
    L17:
        if (interval2 >= this.mDatabase.mSortedStatFiles.length) goto L31;
        if (args.length != 1) goto L40;
        dumpFileDetailsForInterval(ipw, interval2);
        return;
    L40:
        long filename = Long.valueOf(args[1]).longValue();     // Catch: NumberFormatException -> L28
        IntervalStats stats = this.mDatabase.readIntervalStatsForFile(interval2, filename);
        if (stats != null) goto L27;
        ipw.println("the specified filename does not exist.");
        return;
    L27:
        dumpFileDetails(ipw, stats, Long.valueOf(args[1]).longValue());
        return;
    L29:
        ipw.println("invalid filename specified.");
        return;
    L13:
        interval2 = intervalValue;
    L33:
        ipw.println("invalid interval specified.");
    }

    private void dumpFileDetailsForInterval(IndentingPrintWriter ipw, int interval) {
        LongSparseArray<AtomicFile> files = this.mDatabase.mSortedStatFiles[interval];
        int numFiles = files.size();
        int i = 0;
    L3:
        if (i >= numFiles) goto L6;
        long filename = files.keyAt(i);
        IntervalStats stats = this.mDatabase.readIntervalStatsForFile(interval, filename);
        dumpFileDetails(ipw, stats, filename);
        ipw.println();
        i = i + 1;
        goto L3
    }

    private void dumpFileDetails(IndentingPrintWriter ipw, IntervalStats stats, long filename) {
        ipw.println("file=" + filename);
        ipw.increaseIndent();
        printIntervalStats(ipw, stats, false, false, null);
        ipw.decreaseIndent();
    }

    static String formatDateTime(long dateTime, boolean pretty) {
        if (pretty == false) goto L6;
        return "\"" + sDateFormat.format(Long.valueOf(dateTime)) + "\"";
    L6:
        return Long.toString(dateTime);
    }

    private String formatElapsedTime(long elapsedTime, boolean pretty) {
        if (pretty == false) goto L6;
        return "\"" + DateUtils.formatElapsedTime(elapsedTime / 1000) + "\"";
    L6:
        return Long.toString(elapsedTime);
    }

    static void printEvent(IndentingPrintWriter pw, UsageEvents.Event event, boolean prettyDates) {
        pw.printPair("time", formatDateTime(event.mTimeStamp, prettyDates));
        pw.printPair(DatabaseHelper.SoundModelContract.KEY_TYPE, eventToString(event.mEventType));
        pw.printPair(Settings.ATTR_PACKAGE, event.mPackage);
        if (event.mClass == null) goto L6;
        pw.printPair("class", event.mClass);
    L6:
        if (event.mConfiguration == null) goto L9;
        pw.printPair("config", Configuration.resourceQualifierString(event.mConfiguration));
    L9:
        if (event.mShortcutId == null) goto L12;
        pw.printPair("shortcutId", event.mShortcutId);
    L12:
        if (event.mEventType != 11) goto L15;
        pw.printPair("standbyBucket", Integer.valueOf(event.getAppStandbyBucket()));
        pw.printPair(PhoneWindowManager.SYSTEM_DIALOG_REASON_KEY, UsageStatsManager.reasonToString(event.getStandbyReason()));
    L22:
        if (event.getTaskRootPackageName() == null) goto L25;
        pw.printPair("taskRootPackage", event.getTaskRootPackageName());
    L25:
        if (event.getTaskRootClassName() == null) goto L28;
        pw.printPair("taskRootClass", event.getTaskRootClassName());
    L28:
        if (event.mNotificationChannelId == null) goto L31;
        pw.printPair("channelId", event.mNotificationChannelId);
    L31:
        if (event.mEventType == 7) goto L33;
    L35:
        pw.printHexPair("flags", event.mFlags);
        pw.println();
        return;
    L33:
        if (event.mExtras == null) goto L35;
        pw.print(event.mExtras.toString());
        goto L35
    L15:
        if (event.mEventType != 1) goto L17;
    L20:
        pw.printPair("instanceId", Integer.valueOf(event.getInstanceId()));
        goto L22
    L17:
        if (event.mEventType == 2) goto L20;
        if (event.mEventType != 23) goto L22;
        goto L20
    }

    void printLast24HrEvents(IndentingPrintWriter pw, boolean prettyDates, final List<String> pkgs) {
        final long endTime = System.currentTimeMillis();
        UnixCalendar yesterday = new UnixCalendar(endTime);
        yesterday.addDays(-1);
        final long beginTime = yesterday.getTimeInMillis();
        List<UsageEvents.Event> events = queryStats(0, beginTime, endTime, new AnonymousClass6(this, beginTime, endTime, pkgs), false);
        pw.print("Last 24 hour events (");
        if (prettyDates == false) goto L5;
        pw.printPair("timeRange", "\"" + DateUtils.formatDateRange(this.mContext, beginTime, endTime, sDateFormatFlags) + "\"");
    L6:
        pw.println(")");
        if (events == null) goto L15;
        pw.increaseIndent();
        Iterator<UsageEvents.Event> r0 = events.iterator();
    L10:
        if (r0.hasNext() == false) goto L12;
        UsageEvents.Event event = r0.next();
        printEvent(pw, event, prettyDates);
        goto L10
    L12:
        pw.decreaseIndent();
        return;
    L15:
        return;
    L5:
        pw.printPair("beginTime", Long.valueOf(beginTime));
        pw.printPair("endTime", Long.valueOf(endTime));
        goto L6
    }

    void printEventAggregation(IndentingPrintWriter pw, String label, IntervalStats.EventTracker tracker, boolean prettyDates) {
        if (tracker.count == 0) goto L5;
    L6:
        pw.print(label);
        pw.print(": ");
        pw.print(tracker.count);
        pw.print("x for ");
        pw.print(formatElapsedTime(tracker.duration, prettyDates));
        if (tracker.curStartTime == 0) goto L9;
        pw.print(" (now running, started at ");
        formatDateTime(tracker.curStartTime, prettyDates);
        pw.print(")");
    L9:
        pw.println();
        return;
    L5:
        if (tracker.duration != 0) goto L6;
    }

    void printIntervalStats(IndentingPrintWriter pw, IntervalStats stats, boolean prettyDates, boolean skipEvents, List<String> pkgs) {
        if (prettyDates == false) goto L5;
        pw.printPair("timeRange", "\"" + DateUtils.formatDateRange(this.mContext, stats.beginTime, stats.endTime, sDateFormatFlags) + "\"");
    L6:
        pw.println();
        pw.increaseIndent();
        pw.println("packages");
        pw.increaseIndent();
        ArrayMap<String, UsageStats> pkgStats = stats.packageStats;
        int pkgCount = pkgStats.size();
        int i = 0;
    L7:
        String r8 = Settings.ATTR_PACKAGE;
        if (i >= pkgCount) goto L16;
        UsageStats usageStats = pkgStats.valueAt(i);
        if (CollectionUtils.isEmpty(pkgs) == false) goto L12;
    L14:
        pw.printPair(Settings.ATTR_PACKAGE, usageStats.mPackageName);
        pw.printPair("totalTimeUsed", formatElapsedTime(usageStats.mTotalTimeInForeground, prettyDates));
        pw.printPair("lastTimeUsed", formatDateTime(usageStats.mLastTimeUsed, prettyDates));
        pw.printPair("totalTimeVisible", formatElapsedTime(usageStats.mTotalTimeVisible, prettyDates));
        pw.printPair("lastTimeVisible", formatDateTime(usageStats.mLastTimeVisible, prettyDates));
        pw.printPair("lastTimeComponentUsed", formatDateTime(usageStats.mLastTimeComponentUsed, prettyDates));
        pw.printPair("totalTimeFS", formatElapsedTime(usageStats.mTotalTimeForegroundServiceUsed, prettyDates));
        pw.printPair("lastTimeFS", formatDateTime(usageStats.mLastTimeForegroundServiceUsed, prettyDates));
        pw.printPair("appLaunchCount", Integer.valueOf(usageStats.mAppLaunchCount));
        pw.println();
    L15:
        i = i + 1;
        goto L7
    L12:
        if (pkgs.contains(usageStats.mPackageName) == true) goto L14;
    L16:
        pw.decreaseIndent();
        pw.println();
        pw.println("ChooserCounts");
        pw.increaseIndent();
        Iterator<UsageStats> r9 = pkgStats.values().iterator();
    L18:
        if (r9.hasNext() == false) goto L39;
        UsageStats usageStats2 = r9.next();
        if (CollectionUtils.isEmpty(pkgs) == true) goto L24;
        if (pkgs.contains(usageStats2.mPackageName) == false) goto L18;
    L24:
        pw.printPair(r8, usageStats2.mPackageName);
        if (usageStats2.mChooserCounts == null) goto L38;
        int chooserCountSize = usageStats2.mChooserCounts.size();
        int i2 = 0;
    L27:
        if (i2 >= chooserCountSize) goto L38;
        String action = (String) usageStats2.mChooserCounts.keyAt(i2);
        ArrayMap<String, Integer> counts = (ArrayMap) usageStats2.mChooserCounts.valueAt(i2);
        int annotationSize = counts.size();
        ArrayMap<String, UsageStats> pkgStats2 = pkgStats;
        int j = 0;
    L29:
        if (j >= annotationSize) goto L35;
        int pkgCount2 = pkgCount;
        String key = counts.keyAt(j);
        int count = counts.valueAt(j).intValue();
        if (count == 0) goto L34;
        pw.printPair("ChooserCounts", action + ":" + key + " is " + Integer.toString(count));
        pw.println();
    L34:
        j = j + 1;
        pkgCount = pkgCount2;
        r8 = r8;
        goto L29
    L35:
        i2 = i2 + 1;
        pkgStats = pkgStats2;
    L38:
        pw.println();
        pkgStats = pkgStats;
        pkgCount = pkgCount;
        r8 = r8;
        goto L18
    L39:
        pw.decreaseIndent();
        if (CollectionUtils.isEmpty(pkgs) == false) goto L45;
        pw.println("configurations");
        pw.increaseIndent();
        ArrayMap<Configuration, ConfigurationStats> configStats = stats.configurations;
        int configCount = configStats.size();
        int i3 = 0;
    L42:
        if (i3 >= configCount) goto L44;
        ConfigurationStats config = configStats.valueAt(i3);
        pw.printPair("config", Configuration.resourceQualifierString(config.mConfiguration));
        pw.printPair("totalTime", formatElapsedTime(config.mTotalTimeActive, prettyDates));
        pw.printPair("lastTime", formatDateTime(config.mLastTimeActive, prettyDates));
        pw.printPair(AssistDataRequester.KEY_RECEIVER_EXTRA_COUNT, Integer.valueOf(config.mActivationCount));
        pw.println();
        i3 = i3 + 1;
        goto L42
    L44:
        pw.decreaseIndent();
        pw.println("event aggregations");
        pw.increaseIndent();
        printEventAggregation(pw, "screen-interactive", stats.interactiveTracker, prettyDates);
        printEventAggregation(pw, "screen-non-interactive", stats.nonInteractiveTracker, prettyDates);
        printEventAggregation(pw, "keyguard-shown", stats.keyguardShownTracker, prettyDates);
        printEventAggregation(pw, "keyguard-hidden", stats.keyguardHiddenTracker, prettyDates);
        pw.decreaseIndent();
    L45:
        if (skipEvents == true) goto L60;
        pw.println("events");
        pw.increaseIndent();
        EventList events = stats.events;
        if (events == null) goto L49;
        int eventCount = events.size();
    L50:
        int i4 = 0;
    L51:
        if (i4 >= eventCount) goto L59;
        UsageEvents.Event event = events.get(i4);
        if (CollectionUtils.isEmpty(pkgs) == false) goto L55;
    L57:
        printEvent(pw, event, prettyDates);
    L58:
        i4 = i4 + 1;
        goto L51
    L55:
        if (pkgs.contains(event.mPackage) == true) goto L57;
    L59:
        pw.decreaseIndent();
        goto L60
    L49:
        eventCount = 0;
    L60:
        pw.decreaseIndent();
        return;
    L5:
        pw.printPair("beginTime", Long.valueOf(stats.beginTime));
        pw.printPair("endTime", Long.valueOf(stats.endTime));
        goto L6
    }

    public static String intervalToString(int interval) {
        switch(interval) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        return "?";
    L5:
        return "yearly";
    L7:
        return "monthly";
    L9:
        return "weekly";
    L11:
        return "daily";
    }

    private static int stringToInterval(String interval) {
        String r0 = interval.toLowerCase();
        switch(r0.hashCode()) {
            case -791707519: goto L15;
            case -734561654: goto L12;
            case 95346201: goto L9;
            case 1236635661: goto L6;
            default: goto L17;
        };
    L17:
        byte r1 = -1;
    L18:
        switch(r1) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            default: goto L19;
        };
    L19:
        return -1;
    L20:
        return 3;
    L21:
        return 2;
    L22:
        return 1;
    L23:
        return 0;
    L6:
        if (r0.equals("monthly") == false) goto L24;
        r1 = 2;
        goto L18
    L24:
        r1 = -1;
        goto L18
    L9:
        if (r0.equals("daily") == false) goto L25;
        r1 = 0;
        goto L18
    L25:
        r1 = -1;
        goto L18
    L12:
        if (r0.equals("yearly") == false) goto L26;
        r1 = 3;
        goto L18
    L26:
        r1 = -1;
        goto L18
    L15:
        if (r0.equals("weekly") == false) goto L27;
        r1 = 1;
        goto L18
    L27:
        r1 = -1;
        goto L18
    }

    static String eventToString(int eventType) {
        switch(eventType) {
            case 0: goto L63;
            case 1: goto L61;
            case 2: goto L59;
            case 3: goto L57;
            case 4: goto L55;
            case 5: goto L53;
            case 6: goto L51;
            case 7: goto L49;
            case 8: goto L47;
            case 9: goto L45;
            case 10: goto L43;
            case 11: goto L41;
            case 12: goto L39;
            case 13: goto L37;
            case 14: goto L35;
            case 15: goto L33;
            case 16: goto L31;
            case 17: goto L29;
            case 18: goto L27;
            case 19: goto L25;
            case 20: goto L23;
            case 21: goto L21;
            case 22: goto L19;
            case 23: goto L17;
            case 24: goto L4;
            case 25: goto L4;
            case 26: goto L15;
            case 27: goto L13;
            case 28: goto L11;
            case 29: goto L9;
            case 30: goto L7;
            case 31: goto L5;
            default: goto L4;
        };
    L5:
        return "APP_COMPONENT_USED";
    L7:
        return "LOCUS_ID_SET";
    L9:
        return "USER_STOPPED";
    L11:
        return "USER_UNLOCKED";
    L13:
        return "DEVICE_STARTUP";
    L15:
        return "DEVICE_SHUTDOWN";
    L17:
        return "ACTIVITY_STOPPED";
    L19:
        return "ROLLOVER_FOREGROUND_SERVICE";
    L21:
        return "CONTINUING_FOREGROUND_SERVICE";
    L23:
        return "FOREGROUND_SERVICE_STOP";
    L25:
        return "FOREGROUND_SERVICE_START";
    L27:
        return "KEYGUARD_HIDDEN";
    L29:
        return "KEYGUARD_SHOWN";
    L31:
        return "SCREEN_NON_INTERACTIVE";
    L33:
        return "SCREEN_INTERACTIVE";
    L35:
        return "SLICE_PINNED";
    L37:
        return "SLICE_PINNED_PRIV";
    L39:
        return "NOTIFICATION_INTERRUPTION";
    L41:
        return "STANDBY_BUCKET_CHANGED";
    L43:
        return "NOTIFICATION_SEEN";
    L45:
        return "CHOOSER_ACTION";
    L47:
        return "SHORTCUT_INVOCATION";
    L49:
        return "USER_INTERACTION";
    L51:
        return "SYSTEM_INTERACTION";
    L53:
        return "CONFIGURATION_CHANGE";
    L55:
        return "CONTINUE_PREVIOUS_DAY";
    L57:
        return "END_OF_DAY";
    L59:
        return "ACTIVITY_PAUSED";
    L61:
        return "ACTIVITY_RESUMED";
    L63:
        return "NONE";
    L4:
        return "UNKNOWN_TYPE_" + eventType;
    }

    byte[] getBackupPayload(String key) {
        checkAndGetTimeLocked();
        persistActiveStats();
        return this.mDatabase.getBackupPayload(key);
    }

    Set<String> applyRestoredPayload(String key, byte[] payload) {
        checkAndGetTimeLocked();
        return this.mDatabase.applyRestoredPayload(key, payload);
    }

    void systemTimeChangeMoment(long timeChangeMoment) {
        this.mUSSTimeChangeMoment = timeChangeMoment;
    }

    private void initArkBaseThread() {
        this.mArkbaseUUssThread = new HandlerThread("ArkbaseUUssThread");
        this.mArkbaseUUssThread.start();
        this.mArkBaseHandler = new NBArkBaseHandler(this.mContext, this.mArkbaseUUssThread.getLooper());
        this.mArkBaseHandler.sendEmptyMessage(2);
    }

    private void dumpNubia(IndentingPrintWriter pw, List<String> pkgs, boolean compact) {
        IntervalStats[] mIntervalStats = this.mDatabase.getIntervalStatsByType(0);
        pw.println("DailyEventStart-NUBIA");
        int r0 = mIntervalStats.length;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L9;
        IntervalStats intervalStats = mIntervalStats[r3];
        pw.print("DailyFile (");
        pw.printPair("timeRange", "\"" + DateUtils.formatDateRange(this.mContext, intervalStats.beginTime, intervalStats.endTime, sDateFormatFlags) + "\"");
        pw.println(")");
        EventList list = intervalStats.events;
        int i = 0;
    L6:
        if (i >= list.size()) goto L8;
        printEvent(pw, list.get(i), !compact);
        i = i + 1;
        goto L6
    L8:
        r3 = r3 + 1;
        goto L3
    L9:
        pw.println("DailyEventEnd-NUBIA");
        pw.println("DailyStatsStart-NUBIA");
        int r7 = mIntervalStats.length;
        int r8 = 0;
    L10:
        if (r8 >= r7) goto L12;
        IntervalStats intervalStats2 = mIntervalStats[r8];
        pw.print("DailyFile ");
        printIntervalStats(pw, intervalStats2, !compact, true, pkgs);
        r8 = r8 + 1;
        goto L10
    L12:
        pw.println("DailyStatsEnd-NUBIA");
    }
}
