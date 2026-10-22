package com.android.server.usage;

import android.app.usage.ConfigurationStats;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStats;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.proto.ProtoInputStream;
import android.util.proto.ProtoOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
final class UsageStatsProtoV2 {
    private static final long ONE_HOUR_MS = 0;
    private static final String TAG = "UsageStatsProtoV2";

    static {
        ONE_HOUR_MS = TimeUnit.HOURS.toMillis(1);
    }

    private UsageStatsProtoV2() {
    }

    private static UsageStats parseUsageStats(ProtoInputStream proto, long beginTime) throws IOException {
        UsageStats stats = new UsageStats();
    L4:
        switch(proto.nextField()) {
            case -1: goto L21;
            case 0: goto L4;
            case 1: goto L19;
            case 2: goto L4;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L4;
            case 6: goto L16;
            case 7: goto L22;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L7;
            case 12: goto L6;
            default: goto L4;
        };
    L6:
        stats.mLastTimeComponentUsed = proto.readLong(1112396529676L) + beginTime;
        goto L4
    L7:
        stats.mTotalTimeVisible = proto.readLong(1112396529675L);
        goto L4
    L8:
        stats.mLastTimeVisible = proto.readLong(1112396529674L) + beginTime;
        goto L4
    L9:
        stats.mTotalTimeForegroundServiceUsed = proto.readLong(1112396529673L);
        goto L4
    L10:
        stats.mLastTimeForegroundServiceUsed = proto.readLong(1112396529672L) + beginTime;
        goto L4
    L22:
        long token = proto.start(2246267895815L);     // Catch: IOException -> L14
        loadChooserCounts(proto, stats);     // Catch: IOException -> L14
        proto.end(token);     // Catch: IOException -> L14
    L15:
        Slog.e(TAG, "Unable to read chooser counts for " + stats.mPackageToken);
        goto L4
    L16:
        stats.mAppLaunchCount = proto.readInt(1120986464262L);
        goto L4
    L17:
        stats.mTotalTimeInForeground = proto.readLong(1112396529668L);
        goto L4
    L18:
        stats.mLastTimeUsed = proto.readLong(1112396529667L) + beginTime;
        goto L4
    L19:
        stats.mPackageToken = proto.readInt(1120986464257L) - 1;
        goto L4
    L21:
        return stats;
    }

    private static void loadCountAndTime(ProtoInputStream proto, long fieldId, IntervalStats.EventTracker tracker) {
        long token = proto.start(fieldId);     // Catch: IOException -> L7
    L4:
        switch(proto.nextField()) {
            case -1: goto L11;
            case 0: goto L4;
            case 1: goto L9;
            case 2: goto L6;
            default: goto L4;
        };     // Catch: IOException -> L7
    L6:
        tracker.duration = proto.readLong(1112396529666L);     // Catch: IOException -> L7
        goto L4
    L9:
        tracker.count = proto.readInt(1120986464257L);     // Catch: IOException -> L7
        goto L4
    L11:
        proto.end(token);     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        Slog.e(TAG, "Unable to read event tracker " + fieldId, e);
    }

    private static void loadChooserCounts(ProtoInputStream proto, UsageStats usageStats) throws IOException {
        if (proto.nextField(1120986464257L) == false) goto L7;
        int actionToken = proto.readInt(1120986464257L) - 1;
        SparseIntArray counts = (SparseIntArray) usageStats.mChooserCountsObfuscated.get(actionToken);
        if (counts != null) goto L9;
        counts = new SparseIntArray();
        usageStats.mChooserCountsObfuscated.put(actionToken, counts);
    L9:
        switch(proto.nextField()) {
            case -1: goto L14;
            case 0: goto L9;
            case 1: goto L12;
            case 2: goto L11;
            default: goto L9;
        };
    L11:
        long token = proto.start(2246267895810L);
        loadCountsForAction(proto, counts);
        proto.end(token);
        goto L9
    L12:
        usageStats.mChooserCountsObfuscated.put(proto.readInt(1120986464257L) - 1, counts);
        goto L9
    L14:
        return;
    L7:
        counts = new SparseIntArray();
        goto L9
    }

    private static void loadCountsForAction(ProtoInputStream proto, SparseIntArray counts) throws IOException {
        int categoryToken = -1;
        int count = 0;
    L4:
        switch(proto.nextField()) {
            case -1: goto L10;
            case 0: goto L4;
            case 1: goto L7;
            case 2: goto L6;
            default: goto L4;
        };
    L6:
        count = proto.readInt(1120986464258L);
        goto L4
    L7:
        int categoryToken2 = proto.readInt(1120986464257L) - 1;
        categoryToken = categoryToken2;
        goto L4
    L10:
        if (categoryToken == (-1)) goto L20;
        counts.put(categoryToken, count);
        return;
    }

    private static void loadConfigStats(ProtoInputStream proto, IntervalStats stats) throws IOException {
        boolean configActive = false;
        Configuration config = new Configuration();
        ConfigurationStats configStats = new ConfigurationStats();
        if (proto.nextField(1146756268033L) == false) goto L6;
        config.readFromProto(proto, 1146756268033L);
        configStats = stats.getOrCreateConfigurationStats(config);
    L6:
        switch(proto.nextField()) {
            case -1: goto L14;
            case 0: goto L6;
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            default: goto L6;
        };
    L8:
        configActive = proto.readBoolean(1133871366149L);
        goto L6
    L9:
        configStats.mActivationCount = proto.readInt(1120986464260L);
        goto L6
    L10:
        configStats.mTotalTimeActive = proto.readLong(1112396529667L);
        goto L6
    L11:
        configStats.mLastTimeActive = stats.beginTime + proto.readLong(1112396529666L);
        goto L6
    L12:
        config.readFromProto(proto, 1146756268033L);
        ConfigurationStats temp = stats.getOrCreateConfigurationStats(config);
        temp.mLastTimeActive = configStats.mLastTimeActive;
        temp.mTotalTimeActive = configStats.mTotalTimeActive;
        temp.mActivationCount = configStats.mActivationCount;
        configStats = temp;
        goto L6
    L14:
        if (configActive == false) goto L31;
        stats.activeConfiguration = configStats.mConfiguration;
        return;
    }

    private static UsageEvents.Event parseEvent(ProtoInputStream proto, long beginTime) throws IOException {
        UsageEvents.Event event = new UsageEvents.Event();
    L4:
        switch(proto.nextField()) {
            case -1: goto L26;
            case 0: goto L4;
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L15;
            case 10: goto L14;
            case 11: goto L13;
            case 12: goto L12;
            case 13: goto L11;
            case 14: goto L30;
            default: goto L4;
        };
    L30:
        long interactionExtrasToken = proto.start(1146756268046L);     // Catch: IOException -> L9
        event.mUserInteractionExtrasToken = parseUserInteractionEventExtras(proto);     // Catch: IOException -> L9
        proto.end(interactionExtrasToken);     // Catch: IOException -> L9
    L9:
        e = move-exception;
        Slog.e(TAG, "Unable to read some user interaction extras from proto.", e);
        goto L4
    L11:
        event.mLocusIdToken = proto.readInt(1120986464269L) - 1;
        goto L4
    L12:
        event.mTaskRootClassToken = proto.readInt(1120986464268L) - 1;
        goto L4
    L13:
        event.mTaskRootPackageToken = proto.readInt(1120986464267L) - 1;
        goto L4
    L14:
        event.mInstanceId = proto.readInt(1120986464266L);
        goto L4
    L15:
        event.mNotificationChannelIdToken = proto.readInt(1120986464265L) - 1;
        goto L4
    L16:
        event.mBucketAndReason = proto.readInt(1120986464264L);
        goto L4
    L17:
        event.mShortcutIdToken = proto.readInt(1120986464263L) - 1;
        goto L4
    L18:
        event.mConfiguration = new Configuration();
        event.mConfiguration.readFromProto(proto, 1146756268038L);
        goto L4
    L19:
        event.mEventType = proto.readInt(1120986464261L);
        goto L4
    L20:
        event.mFlags = proto.readInt(1120986464260L);
        goto L4
    L21:
        event.mTimeStamp = proto.readLong(1112396529667L) + beginTime;
        goto L4
    L22:
        event.mClassToken = proto.readInt(1120986464258L) - 1;
        goto L4
    L23:
        event.mPackageToken = proto.readInt(1120986464257L) - 1;
        goto L4
    L26:
        if (event.mPackageToken != (-1)) goto L29;
        return null;
    L29:
        return event;
    }

    static void writeOffsetTimestamp(ProtoOutputStream proto, long fieldId, long timestamp, long beginTime) {
        long rolloverGracePeriod = beginTime - ONE_HOUR_MS;
        if (timestamp <= rolloverGracePeriod) goto L6;
        proto.write(fieldId, getOffsetTimestamp(timestamp, beginTime));
        return;
    }

    static long getOffsetTimestamp(long timestamp, long offset) {
        long offsetTimestamp = timestamp - offset;
        if (offsetTimestamp != 0) goto L6;
        return 1 + offsetTimestamp;
    L6:
        return offsetTimestamp;
    }

    private static void writeUsageStats(ProtoOutputStream proto, long beginTime, UsageStats stats) throws IllegalArgumentException {
        proto.write(1120986464257L, stats.mPackageToken + 1);
        writeOffsetTimestamp(proto, 1112396529667L, stats.mLastTimeUsed, beginTime);
        proto.write(1112396529668L, stats.mTotalTimeInForeground);
        writeOffsetTimestamp(proto, 1112396529672L, stats.mLastTimeForegroundServiceUsed, beginTime);
        proto.write(1112396529673L, stats.mTotalTimeForegroundServiceUsed);
        writeOffsetTimestamp(proto, 1112396529674L, stats.mLastTimeVisible, beginTime);
        proto.write(1112396529675L, stats.mTotalTimeVisible);
        writeOffsetTimestamp(proto, 1112396529676L, stats.mLastTimeComponentUsed, beginTime);
        proto.write(1120986464262L, stats.mAppLaunchCount);
        writeChooserCounts(proto, stats);     // Catch: IllegalArgumentException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Unable to write chooser counts for " + stats.mPackageName, e);
    }

    private static void writeCountAndTime(ProtoOutputStream proto, long fieldId, int count, long time) throws IllegalArgumentException {
        long token = proto.start(fieldId);
        proto.write(1120986464257L, count);
        proto.write(1112396529666L, time);
        proto.end(token);
    }

    private static void writeChooserCounts(ProtoOutputStream proto, UsageStats stats) throws IllegalArgumentException {
        if (stats != null) goto L4;
        return;
    L4:
        if (stats.mChooserCountsObfuscated.size() == 0) goto L22;
        int chooserCountSize = stats.mChooserCountsObfuscated.size();
        int i = 0;
    L7:
        if (i >= chooserCountSize) goto L16;
        int action = stats.mChooserCountsObfuscated.keyAt(i);
        SparseIntArray counts = (SparseIntArray) stats.mChooserCountsObfuscated.valueAt(i);
        if (counts == null) goto L14;
        if (counts.size() == 0) goto L14;
        long token = proto.start(2246267895815L);
        proto.write(1120986464257L, action + 1);
        writeCountsForAction(proto, counts);
        proto.end(token);
    L14:
        i = i + 1;
        goto L7
    L16:
        return;
    }

    private static void writeCountsForAction(ProtoOutputStream proto, SparseIntArray counts) throws IllegalArgumentException {
        int countsSize = counts.size();
        int i = 0;
    L3:
        if (i >= countsSize) goto L10;
        int category = counts.keyAt(i);
        int count = counts.valueAt(i);
        if (count <= 0) goto L8;
        long token = proto.start(2246267895810L);
        proto.write(1120986464257L, category + 1);
        proto.write(1120986464258L, count);
        proto.end(token);
    L8:
        i = i + 1;
        goto L3
    }

    private static void writeConfigStats(ProtoOutputStream proto, long statsBeginTime, ConfigurationStats configStats, boolean isActive) throws IllegalArgumentException {
        configStats.mConfiguration.dumpDebug(proto, 1146756268033L);
        writeOffsetTimestamp(proto, 1112396529666L, configStats.mLastTimeActive, statsBeginTime);
        proto.write(1112396529667L, configStats.mTotalTimeActive);
        proto.write(1120986464260L, configStats.mActivationCount);
        proto.write(1133871366149L, isActive);
    }

    private static void writeEvent(ProtoOutputStream proto, long statsBeginTime, UsageEvents.Event event) throws IOException, IllegalArgumentException {
        proto.write(1120986464257L, event.mPackageToken + 1);
        if (event.mClassToken == (-1)) goto L5;
        proto.write(1120986464258L, event.mClassToken + 1);
    L5:
        writeOffsetTimestamp(proto, 1112396529667L, event.mTimeStamp, statsBeginTime);
        proto.write(1120986464260L, event.mFlags);
        proto.write(1120986464261L, event.mEventType);
        proto.write(1120986464266L, event.mInstanceId);
        if (event.mTaskRootPackageToken == (-1)) goto L9;
        proto.write(1120986464267L, event.mTaskRootPackageToken + 1);
    L9:
        if (event.mTaskRootClassToken == (-1)) goto L12;
        proto.write(1120986464268L, event.mTaskRootClassToken + 1);
    L12:
        switch(event.mEventType) {
            case 5: goto L30;
            case 7: goto L27;
            case 8: goto L24;
            case 11: goto L21;
            case 12: goto L18;
            case 30: goto L15;
            default: goto L44;
        };
    L44:
        return;
    L15:
        if (event.mLocusIdToken == (-1)) goto L33;
        proto.write(1120986464269L, event.mLocusIdToken + 1);
        return;
    L33:
        return;
    L18:
        if (event.mNotificationChannelIdToken == (-1)) goto L35;
        proto.write(1120986464265L, event.mNotificationChannelIdToken + 1);
        return;
    L35:
        return;
    L21:
        if (event.mBucketAndReason == 0) goto L37;
        proto.write(1120986464264L, event.mBucketAndReason);
        return;
    L37:
        return;
    L24:
        if (event.mShortcutIdToken == (-1)) goto L39;
        proto.write(1120986464263L, event.mShortcutIdToken + 1);
        return;
    L39:
        return;
    L27:
        if (event.mUserInteractionExtrasToken == null) goto L41;
        writeUserInteractionEventExtras(proto, 1146756268046L, event.mUserInteractionExtrasToken);
        return;
    L41:
        return;
    L30:
        if (event.mConfiguration == null) goto L43;
        event.mConfiguration.dumpDebug(proto, 1146756268038L);
        return;
    }

    public static void read(InputStream in, IntervalStats stats, boolean skipEvents) throws IOException {
        ProtoInputStream proto = new ProtoInputStream(in);
    L4:
        switch(proto.nextField()) {
            case -1: goto L39;
            case 1: goto L37;
            case 2: goto L36;
            case 3: goto L35;
            case 10: goto L34;
            case 11: goto L33;
            case 12: goto L32;
            case 13: goto L31;
            case 20: goto L44;
            case 21: goto L48;
            case 22: goto L6;
            default: goto L4;
        };
    L6:
        if (skipEvents == true) goto L4;
        long eventsToken = proto.start(2246267895830L);     // Catch: IOException -> L13
        UsageEvents.Event event = parseEvent(proto, stats.beginTime);     // Catch: IOException -> L13
        proto.end(eventsToken);     // Catch: IOException -> L13
        if (event == null) goto L4;
        stats.events.insert(event);     // Catch: IOException -> L13
    L13:
        e = move-exception;
        Slog.e(TAG, "Unable to read some events from proto.", e);
        goto L4
    L48:
        long configsToken = proto.start(2246267895829L);     // Catch: IOException -> L20
        loadConfigStats(proto, stats);     // Catch: IOException -> L20
        proto.end(configsToken);     // Catch: IOException -> L20
    L20:
        e = move-exception;
        Slog.e(TAG, "Unable to read some configuration stats from proto.", e);
        goto L4
    L44:
        long packagesToken = proto.start(2246267895828L);     // Catch: IOException -> L27
        UsageStats usageStats = parseUsageStats(proto, stats.beginTime);     // Catch: IOException -> L27
        proto.end(packagesToken);     // Catch: IOException -> L27
        if (usageStats.mPackageToken == (-1)) goto L4;
        stats.packageStatsObfuscated.put(usageStats.mPackageToken, usageStats);     // Catch: IOException -> L27
    L27:
        e = move-exception;
        Slog.e(TAG, "Unable to read some usage stats from proto.", e);
        goto L4
    L31:
        loadCountAndTime(proto, 1146756268045L, stats.keyguardHiddenTracker);
        goto L4
    L32:
        loadCountAndTime(proto, 1146756268044L, stats.keyguardShownTracker);
        goto L4
    L33:
        loadCountAndTime(proto, 1146756268043L, stats.nonInteractiveTracker);
        goto L4
    L34:
        loadCountAndTime(proto, 1146756268042L, stats.interactiveTracker);
        goto L4
    L35:
        stats.minorVersion = proto.readInt(1120986464259L);
        goto L4
    L36:
        stats.majorVersion = proto.readInt(1120986464258L);
        goto L4
    L37:
        stats.endTime = stats.beginTime + proto.readLong(1112396529665L);
        goto L4
    L39:
        int usageStatsSize = stats.packageStatsObfuscated.size();
        int i = 0;
    L40:
        if (i >= usageStatsSize) goto L43;
        UsageStats usageStats2 = stats.packageStatsObfuscated.valueAt(i);
        usageStats2.mBeginTimeStamp = stats.beginTime;
        usageStats2.mEndTimeStamp = stats.endTime;
        i = i + 1;
        goto L40
    }

    public static void write(OutputStream out, IntervalStats stats) throws IOException, IllegalArgumentException {
        ProtoOutputStream proto = new ProtoOutputStream(out);
        proto.write(1112396529665L, getOffsetTimestamp(stats.endTime, stats.beginTime));
        proto.write(1120986464258L, stats.majorVersion);
        proto.write(1120986464259L, stats.minorVersion);
        writeCountAndTime(proto, 1146756268042L, stats.interactiveTracker.count, stats.interactiveTracker.duration);     // Catch: IllegalArgumentException -> L5
        writeCountAndTime(proto, 1146756268043L, stats.nonInteractiveTracker.count, stats.nonInteractiveTracker.duration);     // Catch: IllegalArgumentException -> L5
        writeCountAndTime(proto, 1146756268044L, stats.keyguardShownTracker.count, stats.keyguardShownTracker.duration);     // Catch: IllegalArgumentException -> L5
        writeCountAndTime(proto, 1146756268045L, stats.keyguardHiddenTracker.count, stats.keyguardHiddenTracker.duration);     // Catch: IllegalArgumentException -> L5
    L7:
        int statsCount = stats.packageStatsObfuscated.size();
        int i = 0;
    L8:
        if (i >= statsCount) goto L15;
        long token = proto.start(2246267895828L);     // Catch: IllegalArgumentException -> L12
        writeUsageStats(proto, stats.beginTime, stats.packageStatsObfuscated.valueAt(i));     // Catch: IllegalArgumentException -> L12
        proto.end(token);     // Catch: IllegalArgumentException -> L12
    L14:
        i = i + 1;
    L12:
        e = move-exception;
        Slog.e(TAG, "Unable to write some usage stats to proto.", e);
        goto L14
    L15:
        int configCount = stats.configurations.size();
        int i2 = 0;
    L16:
        if (i2 >= configCount) goto L23;
        boolean active = stats.activeConfiguration.equals(stats.configurations.keyAt(i2));
        long token2 = proto.start(2246267895829L);     // Catch: IllegalArgumentException -> L20
        writeConfigStats(proto, stats.beginTime, stats.configurations.valueAt(i2), active);     // Catch: IllegalArgumentException -> L20
        proto.end(token2);     // Catch: IllegalArgumentException -> L20
    L22:
        i2 = i2 + 1;
    L20:
        e = move-exception;
        Slog.e(TAG, "Unable to write some configuration stats to proto.", e);
        goto L22
    L23:
        int eventCount = stats.events.size();
        int i3 = 0;
    L24:
        if (i3 >= eventCount) goto L31;
        long token3 = proto.start(2246267895830L);     // Catch: IllegalArgumentException -> L28
        writeEvent(proto, stats.beginTime, stats.events.get(i3));     // Catch: IllegalArgumentException -> L28
        proto.end(token3);     // Catch: IllegalArgumentException -> L28
    L30:
        i3 = i3 + 1;
    L28:
        e = move-exception;
        Slog.e(TAG, "Unable to write some events to proto.", e);
        goto L30
    L31:
        proto.flush();
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Unable to write some interval stats trackers to proto.", e);
        goto L7
    }

    private static void loadPackagesMap(ProtoInputStream proto, SparseArray<ArrayList<String>> tokensToPackagesMap) throws IOException {
        int key = -1;
        ArrayList<String> strings = new ArrayList();
    L4:
        switch(proto.nextField()) {
            case -1: goto L10;
            case 0: goto L4;
            case 1: goto L7;
            case 2: goto L6;
            default: goto L4;
        };
    L6:
        strings.add(proto.readString(2237677961218L));
        goto L4
    L7:
        int key2 = proto.readInt(1120986464257L) - 1;
        key = key2;
        goto L4
    L10:
        if (key == (-1)) goto L20;
        tokensToPackagesMap.put(key, strings);
        return;
    }

    static void readObfuscatedData(InputStream in, PackagesTokenData packagesTokenData) throws IOException {
        ProtoInputStream proto = new ProtoInputStream(in);
    L4:
        switch(proto.nextField()) {
            case -1: goto L9;
            case 0: goto L4;
            case 1: goto L7;
            case 2: goto L6;
            default: goto L4;
        };
    L6:
        long token = proto.start(2246267895810L);
        loadPackagesMap(proto, packagesTokenData.tokensToPackagesMap);
        proto.end(token);
        goto L4
    L7:
        packagesTokenData.counter = proto.readInt(1120986464257L);
        goto L4
    }

    static void writeObfuscatedData(OutputStream out, PackagesTokenData packagesTokenData) throws IOException, IllegalArgumentException {
        ProtoOutputStream proto = new ProtoOutputStream(out);
        proto.write(1120986464257L, packagesTokenData.counter);
        int mapSize = packagesTokenData.tokensToPackagesMap.size();
        int i = 0;
    L3:
        if (i >= mapSize) goto L8;
        long token = proto.start(2246267895810L);
        int packageToken = packagesTokenData.tokensToPackagesMap.keyAt(i);
        proto.write(1120986464257L, packageToken + 1);
        ArrayList<String> strings = packagesTokenData.tokensToPackagesMap.valueAt(i);
        int listSize = strings.size();
        int j = 0;
    L5:
        if (j >= listSize) goto L7;
        proto.write(2237677961218L, strings.get(j));
        j = j + 1;
        goto L5
    L7:
        proto.end(token);
        i = i + 1;
        goto L3
    L8:
        proto.flush();
    }

    private static UsageEvents.Event parsePendingEvent(ProtoInputStream proto) throws IOException {
        UsageEvents.Event event = new UsageEvents.Event();
    L4:
        switch(proto.nextField()) {
            case -1: goto L21;
            case 0: goto L4;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            case 13: goto L4;
            case 14: goto L6;
            default: goto L4;
        };
    L6:
        event.mExtras = parsePendingEventExtras(proto, 1151051235342L);
        goto L4
    L7:
        event.mTaskRootClass = proto.readString(1138166333452L);
        goto L4
    L8:
        event.mTaskRootPackage = proto.readString(1138166333451L);
        goto L4
    L9:
        event.mInstanceId = proto.readInt(1120986464266L);
        goto L4
    L10:
        event.mNotificationChannelId = proto.readString(1138166333449L);
        goto L4
    L11:
        event.mBucketAndReason = proto.readInt(1120986464264L);
        goto L4
    L12:
        event.mShortcutId = proto.readString(1138166333447L);
        goto L4
    L13:
        event.mConfiguration = new Configuration();
        event.mConfiguration.readFromProto(proto, 1146756268038L);
        goto L4
    L14:
        event.mEventType = proto.readInt(1120986464261L);
        goto L4
    L15:
        event.mFlags = proto.readInt(1120986464260L);
        goto L4
    L16:
        event.mTimeStamp = proto.readLong(1112396529667L);
        goto L4
    L17:
        event.mClass = proto.readString(1138166333442L);
        goto L4
    L18:
        event.mPackage = proto.readString(1138166333441L);
        goto L4
    L21:
        switch(event.mEventType) {
            case 5: goto L30;
            case 8: goto L27;
            case 12: goto L24;
            default: goto L33;
        };
    L24:
        if (event.mNotificationChannelId != null) goto L33;
        event.mNotificationChannelId = "";
        goto L33
    L27:
        if (event.mShortcutId != null) goto L33;
        event.mShortcutId = "";
        goto L33
    L30:
        if (event.mConfiguration != null) goto L33;
        event.mConfiguration = new Configuration();
    L33:
        if (event.mPackage != null) goto L36;
        return null;
    L36:
        return event;
    }

    static void readPendingEvents(InputStream in, LinkedList<UsageEvents.Event> events) throws IOException {
        ProtoInputStream proto = new ProtoInputStream(in);
    L4:
        switch(proto.nextField()) {
            case -1: goto L16;
            case 23: goto L17;
            default: goto L4;
        };
    L17:
        long token = proto.start(2246267895831L);     // Catch: IOException -> L11
        UsageEvents.Event event = parsePendingEvent(proto);     // Catch: IOException -> L11
        proto.end(token);     // Catch: IOException -> L11
        if (event == null) goto L4;
        events.add(event);     // Catch: IOException -> L11
    L11:
        e = move-exception;
        Slog.e(TAG, "Unable to parse some pending events from proto.", e);
        goto L4
    }

    private static void writePendingEvent(ProtoOutputStream proto, UsageEvents.Event event) throws IOException, IllegalArgumentException {
        proto.write(1138166333441L, event.mPackage);
        if (event.mClass == null) goto L5;
        proto.write(1138166333442L, event.mClass);
    L5:
        proto.write(1112396529667L, event.mTimeStamp);
        proto.write(1120986464260L, event.mFlags);
        proto.write(1120986464261L, event.mEventType);
        proto.write(1120986464266L, event.mInstanceId);
        if (event.mTaskRootPackage == null) goto L9;
        proto.write(1138166333451L, event.mTaskRootPackage);
    L9:
        if (event.mTaskRootClass == null) goto L12;
        proto.write(1138166333452L, event.mTaskRootClass);
    L12:
        switch(event.mEventType) {
            case 5: goto L29;
            case 6: goto L42;
            case 7: goto L24;
            case 8: goto L21;
            case 9: goto L42;
            case 10: goto L42;
            case 11: goto L18;
            case 12: goto L15;
            default: goto L42;
        };
    L42:
        return;
    L15:
        if (event.mNotificationChannelId == null) goto L32;
        proto.write(1138166333449L, event.mNotificationChannelId);
        return;
    L32:
        return;
    L18:
        if (event.mBucketAndReason == 0) goto L34;
        proto.write(1120986464264L, event.mBucketAndReason);
        return;
    L34:
        return;
    L21:
        if (event.mShortcutId == null) goto L36;
        proto.write(1138166333447L, event.mShortcutId);
        return;
    L36:
        return;
    L24:
        if (event.mExtras != null) goto L26;
        return;
    L26:
        if (event.mExtras.size() == 0) goto L39;
        writePendingEventExtras(proto, 1151051235342L, event.mExtras);
        return;
    L39:
        return;
    L29:
        if (event.mConfiguration == null) goto L41;
        event.mConfiguration.dumpDebug(proto, 1146756268038L);
        return;
    }

    static void writePendingEvents(OutputStream out, LinkedList<UsageEvents.Event> events) throws IOException, IllegalArgumentException {
        ProtoOutputStream proto = new ProtoOutputStream(out);
        int eventCount = events.size();
        int i = 0;
    L3:
        if (i >= eventCount) goto L10;
        long token = proto.start(2246267895831L);     // Catch: IllegalArgumentException -> L7
        writePendingEvent(proto, events.get(i));     // Catch: IllegalArgumentException -> L7
        proto.end(token);     // Catch: IllegalArgumentException -> L7
    L9:
        i = i + 1;
    L7:
        e = move-exception;
        Slog.e(TAG, "Unable to write some pending events to proto.", e);
        goto L9
    L10:
        proto.flush();
    }

    private static Pair<String, Long> parseGlobalComponentUsage(ProtoInputStream proto) throws IOException {
        String packageName = "";
        long time = 0;
    L4:
        switch(proto.nextField()) {
            case -1: goto L10;
            case 0: goto L4;
            case 1: goto L7;
            case 2: goto L6;
            default: goto L4;
        };
    L6:
        time = proto.readLong(1112396529666L);
        goto L4
    L7:
        packageName = proto.readString(1138166333441L);
        goto L4
    L10:
        return new Pair(packageName, Long.valueOf(time));
    }

    static void readGlobalComponentUsage(InputStream in, Map<String, Long> lastTimeComponentUsedGlobal) throws IOException {
        ProtoInputStream proto = new ProtoInputStream(in);
    L4:
        switch(proto.nextField()) {
            case -1: goto L18;
            case 24: goto L19;
            default: goto L4;
        };
    L19:
        long token = proto.start(2246267895832L);     // Catch: IOException -> L13
        Pair<String, Long> usage = parseGlobalComponentUsage(proto);     // Catch: IOException -> L13
        proto.end(token);     // Catch: IOException -> L13
        if (((String) usage.first).isEmpty() == true) goto L4;
        if (((Long) usage.second).longValue() <= 0) goto L4;
        lastTimeComponentUsedGlobal.put((String) usage.first, (Long) usage.second);     // Catch: IOException -> L13
    L13:
        e = move-exception;
        Slog.e(TAG, "Unable to parse some package usage from proto.", e);
        goto L4
    }

    static void writeGlobalComponentUsage(OutputStream out, Map<String, Long> lastTimeComponentUsedGlobal) {
        ProtoOutputStream proto = new ProtoOutputStream(out);
        Map.Entry<String, Long>[] entries = (Map.Entry[]) lastTimeComponentUsedGlobal.entrySet().toArray();
        int size = entries.length;
        int i = 0;
    L3:
        if (i >= size) goto L10;
        if (entries[i].getValue().longValue() <= 0) goto L8;
        long token = proto.start(2246267895832L);
        proto.write(1138166333441L, entries[i].getKey());
        proto.write(1112396529666L, entries[i].getValue().longValue());
        proto.end(token);
    L8:
        i = i + 1;
        goto L3
    }

    private static UsageEvents.Event.UserInteractionEventExtrasToken parseUserInteractionEventExtras(ProtoInputStream proto) throws IOException {
        UsageEvents.Event.UserInteractionEventExtrasToken interactionExtrasToken = new UsageEvents.Event.UserInteractionEventExtrasToken();
    L4:
        switch(proto.nextField()) {
            case -1: goto L9;
            case 0: goto L4;
            case 1: goto L7;
            case 2: goto L6;
            default: goto L4;
        };
    L6:
        interactionExtrasToken.mActionToken = proto.readInt(1120986464258L) - 1;
        goto L4
    L7:
        interactionExtrasToken.mCategoryToken = proto.readInt(1120986464257L) - 1;
        goto L4
    L9:
        return interactionExtrasToken;
    }

    static void writeUserInteractionEventExtras(ProtoOutputStream proto, long fieldId, UsageEvents.Event.UserInteractionEventExtrasToken interactionExtras) {
        long token = proto.start(fieldId);
        proto.write(1120986464257L, interactionExtras.mCategoryToken + 1);
        proto.write(1120986464258L, interactionExtras.mActionToken + 1);
        proto.end(token);
    }

    private static PersistableBundle parsePendingEventExtras(ProtoInputStream proto, long fieldId) throws IOException {
        return PersistableBundle.readFromStream(new ByteArrayInputStream(proto.readBytes(fieldId)));
    }

    static void writePendingEventExtras(ProtoOutputStream proto, long fieldId, PersistableBundle eventExtras) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        eventExtras.writeToStream(baos);
        proto.write(fieldId, baos.toByteArray());
    }
}
