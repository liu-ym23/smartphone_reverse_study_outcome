package com.android.server.usage;

import android.app.usage.ConfigurationStats;
import android.app.usage.EventList;
import android.app.usage.EventStats;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStats;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.proto.ProtoInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class IntervalStats {
    public static final int CURRENT_MAJOR_VERSION = 1;
    public static final int CURRENT_MINOR_VERSION = 1;
    private static final String TAG = "IntervalStats";
    public Configuration activeConfiguration;
    public long beginTime;
    public final ArrayMap<Configuration, ConfigurationStats> configurations;
    public long endTime;
    public final EventList events;
    public final EventTracker interactiveTracker;
    public final EventTracker keyguardHiddenTracker;
    public final EventTracker keyguardShownTracker;
    public long lastTimeSaved;
    public final ArraySet<String> mStringCache;
    public int majorVersion;
    public int minorVersion;
    public final EventTracker nonInteractiveTracker;
    public final ArrayMap<String, UsageStats> packageStats;
    public final SparseArray<UsageStats> packageStatsObfuscated;

    public static final class EventTracker {
        public int count;
        public long curStartTime;
        public long duration;
        public long lastEventTime;

        public EventTracker() {
        }

        public void commitTime(long timeStamp) {
            if (this.curStartTime == 0) goto L6;
            this.duration += timeStamp - this.curStartTime;
            this.curStartTime = 0;
            return;
        }

        public void update(long timeStamp) {
            if (this.curStartTime != 0) goto L5;
            this.count++;
        L5:
            commitTime(timeStamp);
            this.curStartTime = timeStamp;
            this.lastEventTime = timeStamp;
        }

        void addToEventStats(List<EventStats> out, int event, long beginTime, long endTime) {
            if (this.count == 0) goto L5;
        L6:
            EventStats ev = new EventStats();
            ev.mEventType = event;
            ev.mCount = this.count;
            ev.mTotalTime = this.duration;
            ev.mLastEventTime = this.lastEventTime;
            ev.mBeginTimeStamp = beginTime;
            ev.mEndTimeStamp = endTime;
            out.add(ev);
            return;
        L5:
            if (this.duration != 0) goto L6;
        }
    }

    public IntervalStats() {
        this.majorVersion = 1;
        this.minorVersion = 1;
        this.interactiveTracker = new EventTracker();
        this.nonInteractiveTracker = new EventTracker();
        this.keyguardShownTracker = new EventTracker();
        this.keyguardHiddenTracker = new EventTracker();
        this.packageStats = new ArrayMap();
        this.packageStatsObfuscated = new SparseArray();
        this.configurations = new ArrayMap();
        this.events = new EventList();
        this.mStringCache = new ArraySet();
    }

    UsageStats getOrCreateUsageStats(String packageName) {
        UsageStats usageStats = this.packageStats.get(packageName);
        if (usageStats != null) goto L6;
        UsageStats usageStats2 = new UsageStats();
        usageStats2.mPackageName = getCachedStringRef(packageName);
        usageStats2.mBeginTimeStamp = this.beginTime;
        usageStats2.mEndTimeStamp = this.endTime;
        this.packageStats.put(usageStats2.mPackageName, usageStats2);
        return usageStats2;
    L6:
        return usageStats;
    }

    ConfigurationStats getOrCreateConfigurationStats(Configuration config) {
        ConfigurationStats configStats = this.configurations.get(config);
        if (configStats != null) goto L6;
        ConfigurationStats configStats2 = new ConfigurationStats();
        configStats2.mBeginTimeStamp = this.beginTime;
        configStats2.mEndTimeStamp = this.endTime;
        configStats2.mConfiguration = config;
        this.configurations.put(config, configStats2);
        return configStats2;
    L6:
        return configStats;
    }

    UsageEvents.Event buildEvent(String packageName, String className) {
        UsageEvents.Event event = new UsageEvents.Event();
        event.mPackage = getCachedStringRef(packageName);
        if (className == null) goto L5;
        event.mClass = getCachedStringRef(className);
    L5:
        return event;
    }

    UsageEvents.Event buildEvent(ProtoInputStream parser, List<String> stringPool) throws IOException {
        UsageEvents.Event event = new UsageEvents.Event();
    L4:
        switch(parser.nextField()) {
            case -1: goto L24;
            case 0: goto L4;
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L4;
            case 11: goto L12;
            case 12: goto L11;
            case 13: goto L10;
            case 14: goto L9;
            case 15: goto L8;
            case 16: goto L7;
            case 17: goto L6;
            default: goto L4;
        };
    L6:
        event.mLocusId = getCachedStringRef(stringPool.get(parser.readInt(1120986464273L) - 1));
        goto L4
    L7:
        event.mTaskRootClass = getCachedStringRef(stringPool.get(parser.readInt(1120986464272L) - 1));
        goto L4
    L8:
        event.mTaskRootPackage = getCachedStringRef(stringPool.get(parser.readInt(1120986464271L) - 1));
        goto L4
    L9:
        event.mInstanceId = parser.readInt(1120986464270L);
        goto L4
    L10:
        event.mNotificationChannelId = getCachedStringRef(stringPool.get(parser.readInt(1120986464269L) - 1));
        goto L4
    L11:
        event.mNotificationChannelId = parser.readString(1138166333452L);
        goto L4
    L12:
        event.mBucketAndReason = parser.readInt(1120986464267L);
        goto L4
    L13:
        event.mShortcutId = parser.readString(1138166333449L).intern();
        goto L4
    L14:
        event.mConfiguration = new Configuration();
        event.mConfiguration.readFromProto(parser, 1146756268040L);
        goto L4
    L15:
        event.mEventType = parser.readInt(1120986464263L);
        goto L4
    L16:
        event.mFlags = parser.readInt(1120986464262L);
        goto L4
    L17:
        event.mTimeStamp = this.beginTime + parser.readLong(1112396529669L);
        goto L4
    L18:
        event.mClass = getCachedStringRef(stringPool.get(parser.readInt(1120986464260L) - 1));
        goto L4
    L19:
        event.mClass = getCachedStringRef(parser.readString(1138166333443L));
        goto L4
    L20:
        event.mPackage = getCachedStringRef(stringPool.get(parser.readInt(1120986464258L) - 1));
        goto L4
    L21:
        event.mPackage = getCachedStringRef(parser.readString(1138166333441L));
        goto L4
    L24:
        switch(event.mEventType) {
            case 5: goto L36;
            case 8: goto L33;
            case 12: goto L30;
            case 30: goto L27;
            default: goto L38;
        };
    L38:
        return event;
    L27:
        if (event.mLocusId != null) goto L38;
        event.mLocusId = "";
        goto L38
    L30:
        if (event.mNotificationChannelId != null) goto L38;
        event.mNotificationChannelId = "";
        goto L38
    L33:
        if (event.mShortcutId != null) goto L38;
        event.mShortcutId = "";
        goto L38
    L36:
        if (event.mConfiguration != null) goto L38;
        event.mConfiguration = new Configuration();
        goto L38
    }

    private boolean isStatefulEvent(int eventType) {
        switch(eventType) {
            case 1: goto L5;
            case 2: goto L5;
            case 3: goto L5;
            case 4: goto L5;
            case 19: goto L5;
            case 20: goto L5;
            case 21: goto L5;
            case 22: goto L5;
            case 23: goto L5;
            case 26: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }

    private boolean isUserVisibleEvent(int eventType) {
        if (eventType != 6) goto L5;
    L7:
        return false;
    L5:
        if (eventType == 11) goto L7;
        return true;
    }

    public void update(String packageName, String className, long timeStamp, int eventType, int instanceId) {
        if (eventType == 26) goto L9;
        if (eventType == 25) goto L9;
        UsageStats usageStats = getOrCreateUsageStats(packageName);
        timeStamp = timeStamp;
        usageStats.update(className, timeStamp, eventType, instanceId);
    L14:
        if (timeStamp <= this.endTime) goto L18;
        this.endTime = timeStamp;
        return;
    L18:
        return;
    L9:
        int size = this.packageStats.size();
        int i = 0;
    L10:
        if (i >= size) goto L14;
        UsageStats usageStats2 = this.packageStats.valueAt(i);
        int eventType2 = eventType;
        int instanceId2 = instanceId;
        long timeStamp2 = timeStamp;
        usageStats2.update(null, timeStamp2, eventType2, instanceId2);
        timeStamp = timeStamp2;
        eventType = eventType2;
        instanceId = instanceId2;
        i = i + 1;
        goto L10
    }

    public void addEvent(UsageEvents.Event event) {
        event.mPackage = getCachedStringRef(event.mPackage);
        if (event.mClass == null) goto L6;
        event.mClass = getCachedStringRef(event.mClass);
    L6:
        if (event.mTaskRootPackage == null) goto L9;
        event.mTaskRootPackage = getCachedStringRef(event.mTaskRootPackage);
    L9:
        if (event.mTaskRootClass == null) goto L12;
        event.mTaskRootClass = getCachedStringRef(event.mTaskRootClass);
    L12:
        if (event.mEventType != 12) goto L14;
        event.mNotificationChannelId = getCachedStringRef(event.mNotificationChannelId);
    L14:
        this.events.insert(event);
        if (event.mTimeStamp <= this.endTime) goto L18;
        this.endTime = event.mTimeStamp;
        return;
    }

    void updateChooserCounts(String packageName, String category, String action) {
        UsageStats usageStats = getOrCreateUsageStats(packageName);
        if (usageStats.mChooserCounts != null) goto L5;
        usageStats.mChooserCounts = new ArrayMap();
    L5:
        int idx = usageStats.mChooserCounts.indexOfKey(action);
        if (idx >= 0) goto L8;
        ArrayMap<String, Integer> chooserCounts = new ArrayMap();
        usageStats.mChooserCounts.put(action, chooserCounts);
    L9:
        int currentCount = chooserCounts.getOrDefault(category, 0).intValue();
        chooserCounts.put(category, Integer.valueOf(currentCount + 1));
        return;
    L8:
        ArrayMap<String, Integer> chooserCounts2 = usageStats.mChooserCounts;
        chooserCounts = (ArrayMap) chooserCounts2.valueAt(idx);
        goto L9
    }

    void updateConfigurationStats(Configuration config, long timeStamp) {
        if (this.activeConfiguration == null) goto L5;
        ConfigurationStats activeStats = this.configurations.get(this.activeConfiguration);
        activeStats.mTotalTimeActive += timeStamp - activeStats.mLastTimeActive;
        activeStats.mLastTimeActive = timeStamp - 1;
    L5:
        if (config == null) goto L8;
        ConfigurationStats configStats = getOrCreateConfigurationStats(config);
        configStats.mLastTimeActive = timeStamp;
        configStats.mActivationCount++;
        this.activeConfiguration = configStats.mConfiguration;
    L8:
        if (timeStamp <= this.endTime) goto L11;
        this.endTime = timeStamp;
        return;
    }

    void incrementAppLaunchCount(String packageName) {
        UsageStats usageStats = getOrCreateUsageStats(packageName);
        usageStats.mAppLaunchCount++;
    }

    void commitTime(long timeStamp) {
        this.interactiveTracker.commitTime(timeStamp);
        this.nonInteractiveTracker.commitTime(timeStamp);
        this.keyguardShownTracker.commitTime(timeStamp);
        this.keyguardHiddenTracker.commitTime(timeStamp);
    }

    void updateScreenInteractive(long timeStamp) {
        this.interactiveTracker.update(timeStamp);
        this.nonInteractiveTracker.commitTime(timeStamp);
    }

    void updateScreenNonInteractive(long timeStamp) {
        this.nonInteractiveTracker.update(timeStamp);
        this.interactiveTracker.commitTime(timeStamp);
    }

    void updateKeyguardShown(long timeStamp) {
        this.keyguardShownTracker.update(timeStamp);
        this.keyguardHiddenTracker.commitTime(timeStamp);
    }

    void updateKeyguardHidden(long timeStamp) {
        this.keyguardHiddenTracker.update(timeStamp);
        this.keyguardShownTracker.commitTime(timeStamp);
    }

    void addEventStatsTo(List<EventStats> out) {
        this.interactiveTracker.addToEventStats(out, 15, this.beginTime, this.endTime);
        this.nonInteractiveTracker.addToEventStats(out, 16, this.beginTime, this.endTime);
        this.keyguardShownTracker.addToEventStats(out, 17, this.beginTime, this.endTime);
        this.keyguardHiddenTracker.addToEventStats(out, 18, this.beginTime, this.endTime);
    }

    private String getCachedStringRef(String str) {
        int index = this.mStringCache.indexOf(str);
        if (index >= 0) goto L7;
        this.mStringCache.add(str);
        return str;
    L7:
        return this.mStringCache.valueAt(index);
    }

    void upgradeIfNeeded() {
        if (this.majorVersion < 1) goto L5;
        return;
    L5:
        this.majorVersion = 1;
    }

    private boolean deobfuscateUsageStats(PackagesTokenData packagesTokenData) {
        boolean dataOmitted = false;
        ArraySet<Integer> omittedTokens = new ArraySet();
        int usageStatsSize = this.packageStatsObfuscated.size();
        int statsIndex = 0;
    L3:
        if (statsIndex >= usageStatsSize) goto L23;
        int packageToken = this.packageStatsObfuscated.keyAt(statsIndex);
        UsageStats usageStats = this.packageStatsObfuscated.valueAt(statsIndex);
        usageStats.mPackageName = packagesTokenData.getPackageString(packageToken);
        if (usageStats.mPackageName != null) goto L7;
        omittedTokens.add(Integer.valueOf(packageToken));
        dataOmitted = true;
        ArraySet<Integer> omittedTokens2 = omittedTokens;
    L22:
        statsIndex = statsIndex + 1;
        omittedTokens = omittedTokens2;
        goto L3
    L7:
        int chooserActionsSize = usageStats.mChooserCountsObfuscated.size();
        int actionIndex = 0;
    L8:
        if (actionIndex >= chooserActionsSize) goto L21;
        ArrayMap<String, Integer> categoryCountsMap = new ArrayMap();
        int actionToken = usageStats.mChooserCountsObfuscated.keyAt(actionIndex);
        String action = packagesTokenData.getString(packageToken, actionToken);
        if (action != null) goto L12;
        boolean dataOmitted2 = dataOmitted;
        ArraySet<Integer> omittedTokens3 = omittedTokens;
    L20:
        actionIndex = actionIndex + 1;
        packagesTokenData = packagesTokenData;
        dataOmitted = dataOmitted2;
        omittedTokens = omittedTokens3;
        goto L8
    L12:
        SparseIntArray categoryCounts = (SparseIntArray) usageStats.mChooserCountsObfuscated.valueAt(actionIndex);
        int categoriesSize = categoryCounts.size();
        int categoryIndex = 0;
    L13:
        if (categoryIndex >= categoriesSize) goto L19;
        boolean dataOmitted3 = dataOmitted;
        int categoryToken = categoryCounts.keyAt(categoryIndex);
        ArraySet<Integer> omittedTokens4 = omittedTokens;
        String category = packagesTokenData.getString(packageToken, categoryToken);
        if (category == null) goto L18;
        categoryCountsMap.put(category, Integer.valueOf(categoryCounts.valueAt(categoryIndex)));
    L18:
        categoryIndex = categoryIndex + 1;
        packagesTokenData = packagesTokenData;
        dataOmitted = dataOmitted3;
        omittedTokens = omittedTokens4;
        goto L13
    L19:
        dataOmitted2 = dataOmitted;
        omittedTokens3 = omittedTokens;
        usageStats.mChooserCounts.put(action, categoryCountsMap);
        goto L20
    L21:
        omittedTokens2 = omittedTokens;
        this.packageStats.put(usageStats.mPackageName, usageStats);
        dataOmitted = dataOmitted;
        goto L22
    L23:
        boolean dataOmitted4 = dataOmitted;
        ArraySet<Integer> omittedTokens5 = omittedTokens;
        if (dataOmitted4 == false) goto L26;
        Slog.d(TAG, "Unable to parse usage stats packages: " + Arrays.toString(omittedTokens5.toArray()));
    L26:
        return dataOmitted4;
    }

    private boolean deobfuscateEvents(PackagesTokenData packagesTokenData) {
        boolean dataOmitted = false;
        ArraySet<Integer> omittedTokens = new ArraySet();
        int i = this.events.size();
    L3:
        i = i - 1;
        if (i < 0) goto L43;
        UsageEvents.Event event = this.events.get(i);
        int packageToken = event.mPackageToken;
        event.mPackage = packagesTokenData.getPackageString(packageToken);
        if (event.mPackage != null) goto L9;
        omittedTokens.add(Integer.valueOf(packageToken));
        this.events.remove(i);
        dataOmitted = true;
        goto L3
    L9:
        if (event.mClassToken == (-1)) goto L12;
        event.mClass = packagesTokenData.getString(packageToken, event.mClassToken);
    L12:
        if (event.mTaskRootPackageToken == (-1)) goto L15;
        event.mTaskRootPackage = packagesTokenData.getString(packageToken, event.mTaskRootPackageToken);
    L15:
        if (event.mTaskRootClassToken == (-1)) goto L18;
        event.mTaskRootClass = packagesTokenData.getString(packageToken, event.mTaskRootClassToken);
    L18:
        switch(event.mEventType) {
            case 5: goto L39;
            case 7: goto L30;
            case 8: goto L26;
            case 12: goto L23;
            case 30: goto L20;
            default: goto L3;
        };
    L20:
        event.mLocusId = packagesTokenData.getString(packageToken, event.mLocusIdToken);
        if (event.mLocusId != null) goto L3;
        Slog.v(TAG, "Unable to parse locus " + event.mLocusIdToken + " for package " + packageToken);
        this.events.remove(i);
        dataOmitted = true;
        goto L3
    L23:
        event.mNotificationChannelId = packagesTokenData.getString(packageToken, event.mNotificationChannelIdToken);
        if (event.mNotificationChannelId != null) goto L3;
        Slog.v(TAG, "Unable to parse notification channel " + event.mNotificationChannelIdToken + " for package " + packageToken);
        this.events.remove(i);
        dataOmitted = true;
        goto L3
    L26:
        event.mShortcutId = packagesTokenData.getString(packageToken, event.mShortcutIdToken);
        if (event.mShortcutId != null) goto L3;
        Slog.v(TAG, "Unable to parse shortcut " + event.mShortcutIdToken + " for package " + packageToken);
        this.events.remove(i);
        dataOmitted = true;
        goto L3
    L30:
        if (event.mUserInteractionExtrasToken == null) goto L3;
        String category = packagesTokenData.getString(packageToken, event.mUserInteractionExtrasToken.mCategoryToken);
        String action = packagesTokenData.getString(packageToken, event.mUserInteractionExtrasToken.mActionToken);
        if (TextUtils.isEmpty(category) == false) goto L34;
    L37:
        this.events.remove(i);
        dataOmitted = true;
        goto L3
    L34:
        if (TextUtils.isEmpty(action) == true) goto L37;
        event.mExtras = new PersistableBundle();
        event.mExtras.putString("android.app.usage.extra.EVENT_CATEGORY", category);
        event.mExtras.putString("android.app.usage.extra.EVENT_ACTION", action);
        event.mUserInteractionExtrasToken = null;
        goto L3
    L39:
        if (event.mConfiguration != null) goto L3;
        event.mConfiguration = new Configuration();
        goto L3
    L43:
        if (dataOmitted == false) goto L45;
        Slog.d(TAG, "Unable to parse event packages: " + Arrays.toString(omittedTokens.toArray()));
    L45:
        return dataOmitted;
    }

    public boolean deobfuscateData(PackagesTokenData packagesTokenData) {
        boolean statsOmitted = deobfuscateUsageStats(packagesTokenData);
        boolean eventsOmitted = deobfuscateEvents(packagesTokenData);
        if (statsOmitted == true) goto L7;
        if (eventsOmitted == true) goto L7;
        return false;
    L7:
        return true;
    }

    private void obfuscateUsageStatsData(PackagesTokenData packagesTokenData) {
        int usageStatsSize = this.packageStats.size();
        int statsIndex = 0;
    L3:
        if (statsIndex >= usageStatsSize) goto L23;
        String packageName = this.packageStats.keyAt(statsIndex);
        UsageStats usageStats = this.packageStats.valueAt(statsIndex);
        if (usageStats != null) goto L7;
        int usageStatsSize2 = usageStatsSize;
    L21:
        statsIndex = statsIndex + 1;
        usageStatsSize = usageStatsSize2;
        goto L3
    L7:
        int packageToken = packagesTokenData.getPackageTokenOrAdd(packageName, usageStats.mEndTimeStamp);
        if (packageToken != (-1)) goto L10;
        usageStatsSize2 = usageStatsSize;
        goto L21
    L10:
        usageStats.mPackageToken = packageToken;
        int chooserActionsSize = usageStats.mChooserCounts.size();
        int actionIndex = 0;
    L11:
        if (actionIndex >= chooserActionsSize) goto L20;
        String action = (String) usageStats.mChooserCounts.keyAt(actionIndex);
        ArrayMap<String, Integer> categoriesMap = (ArrayMap) usageStats.mChooserCounts.valueAt(actionIndex);
        if (categoriesMap != null) goto L15;
        int usageStatsSize3 = usageStatsSize;
    L19:
        actionIndex = actionIndex + 1;
        usageStatsSize = usageStatsSize3;
        goto L11
    L15:
        SparseIntArray categoryCounts = new SparseIntArray();
        int categoriesSize = categoriesMap.size();
        int categoryIndex = 0;
    L16:
        if (categoryIndex >= categoriesSize) goto L18;
        String category = categoriesMap.keyAt(categoryIndex);
        int categoryToken = packagesTokenData.getTokenOrAdd(packageToken, packageName, category);
        int usageStatsSize4 = usageStatsSize;
        int usageStatsSize5 = categoriesMap.valueAt(categoryIndex).intValue();
        categoryCounts.put(categoryToken, usageStatsSize5);
        categoryIndex = categoryIndex + 1;
        usageStatsSize = usageStatsSize4;
        goto L16
    L18:
        usageStatsSize3 = usageStatsSize;
        int actionToken = packagesTokenData.getTokenOrAdd(packageToken, packageName, action);
        usageStats.mChooserCountsObfuscated.put(actionToken, categoryCounts);
        goto L19
    L20:
        usageStatsSize2 = usageStatsSize;
        this.packageStatsObfuscated.put(packageToken, usageStats);
        goto L21
    }

    private void obfuscateEventsData(PackagesTokenData packagesTokenData) {
        int i = this.events.size() - 1;
    L3:
        if (i < 0) goto L42;
        UsageEvents.Event event = this.events.get(i);
        if (event == null) goto L40;
        int packageToken = packagesTokenData.getPackageTokenOrAdd(event.mPackage, event.mTimeStamp);
        if (packageToken != (-1)) goto L10;
        this.events.remove(i);
        goto L40
    L10:
        event.mPackageToken = packageToken;
        if (TextUtils.isEmpty(event.mClass) == true) goto L14;
        event.mClassToken = packagesTokenData.getTokenOrAdd(packageToken, event.mPackage, event.mClass);
    L14:
        if (TextUtils.isEmpty(event.mTaskRootPackage) == true) goto L17;
        event.mTaskRootPackageToken = packagesTokenData.getTokenOrAdd(packageToken, event.mPackage, event.mTaskRootPackage);
    L17:
        if (TextUtils.isEmpty(event.mTaskRootClass) == true) goto L20;
        event.mTaskRootClassToken = packagesTokenData.getTokenOrAdd(packageToken, event.mPackage, event.mTaskRootClass);
    L20:
        switch(event.mEventType) {
            case 7: goto L32;
            case 8: goto L29;
            case 12: goto L26;
            case 30: goto L23;
            default: goto L40;
        };
    L23:
        if (TextUtils.isEmpty(event.mLocusId) == true) goto L40;
        event.mLocusIdToken = packagesTokenData.getTokenOrAdd(packageToken, event.mPackage, event.mLocusId);
        goto L40
    L26:
        if (TextUtils.isEmpty(event.mNotificationChannelId) == true) goto L40;
        event.mNotificationChannelIdToken = packagesTokenData.getTokenOrAdd(packageToken, event.mPackage, event.mNotificationChannelId);
        goto L40
    L29:
        if (TextUtils.isEmpty(event.mShortcutId) == true) goto L40;
        event.mShortcutIdToken = packagesTokenData.getTokenOrAdd(packageToken, event.mPackage, event.mShortcutId);
        goto L40
    L32:
        if (event.mExtras == null) goto L40;
        if (event.mExtras.size() == 0) goto L40;
        String category = event.mExtras.getString("android.app.usage.extra.EVENT_CATEGORY");
        String action = event.mExtras.getString("android.app.usage.extra.EVENT_ACTION");
        if (TextUtils.isEmpty(category) == true) goto L40;
        if (TextUtils.isEmpty(action) == true) goto L40;
        event.mUserInteractionExtrasToken = new UsageEvents.Event.UserInteractionEventExtrasToken();
        event.mUserInteractionExtrasToken.mCategoryToken = packagesTokenData.getTokenOrAdd(packageToken, event.mPackage, category);
        event.mUserInteractionExtrasToken.mActionToken = packagesTokenData.getTokenOrAdd(packageToken, event.mPackage, action);
    L40:
        i = i - 1;
        goto L3
    }

    public void obfuscateData(PackagesTokenData packagesTokenData) {
        obfuscateUsageStatsData(packagesTokenData);
        obfuscateEventsData(packagesTokenData);
    }
}
