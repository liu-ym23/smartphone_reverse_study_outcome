package com.android.server.usage;

import android.app.usage.ConfigurationStats;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStats;
import android.content.res.Configuration;
import android.util.ArrayMap;
import android.util.Slog;
import android.util.proto.ProtoInputStream;
import android.util.proto.ProtoOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class UsageStatsProto {
    private static String TAG;

    static {
        TAG = "UsageStatsProto";
    }

    private UsageStatsProto() {
    }

    private static List<String> readStringPool(ProtoInputStream proto) throws IOException {
        long token = proto.start(1146756268034L);
        if (proto.nextField(1120986464257L) == false) goto L5;
        List<String> stringPool = new ArrayList(proto.readInt(1120986464257L));
    L7:
        if (proto.nextField() == (-1)) goto L13;
        switch(proto.getFieldNumber()) {
            case 2: goto L11;
            default: goto L7;
        };
    L11:
        stringPool.add(proto.readString(2237677961218L));
        goto L7
    L13:
        proto.end(token);
        return stringPool;
    L5:
        stringPool = new ArrayList();
        goto L7
    }

    private static void loadUsageStats(ProtoInputStream proto, long fieldId, IntervalStats statsOut, List<String> stringPool) throws IOException {
        long token = proto.start(fieldId);
        if (proto.nextField(1120986464258L) == false) goto L6;
        UsageStats stats = statsOut.getOrCreateUsageStats(stringPool.get(proto.readInt(1120986464258L) - 1));
    L10:
        if (proto.nextField() == (-1)) goto L31;
        switch(proto.getFieldNumber()) {
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L33;
            case 8: goto L18;
            case 9: goto L17;
            case 10: goto L16;
            case 11: goto L15;
            case 12: goto L14;
            default: goto L10;
        };
    L14:
        stats.mLastTimeComponentUsed = statsOut.beginTime + proto.readLong(1112396529676L);
        goto L10
    L15:
        stats.mTotalTimeVisible = proto.readLong(1112396529675L);
        goto L10
    L16:
        stats.mLastTimeVisible = statsOut.beginTime + proto.readLong(1112396529674L);
        goto L10
    L17:
        stats.mTotalTimeForegroundServiceUsed = proto.readLong(1112396529673L);
        goto L10
    L18:
        stats.mLastTimeForegroundServiceUsed = statsOut.beginTime + proto.readLong(1112396529672L);
        goto L10
    L33:
        long chooserToken = proto.start(2246267895815L);     // Catch: IOException -> L22
        loadChooserCounts(proto, stats);     // Catch: IOException -> L22
        proto.end(chooserToken);     // Catch: IOException -> L22
    L22:
        e = move-exception;
        Slog.e(TAG, "Unable to read chooser counts for " + stats.mPackageName, e);
        goto L10
    L24:
        stats.mAppLaunchCount = proto.readInt(1120986464262L);
        goto L10
    L25:
        stats.mLastEvent = proto.readInt(1120986464261L);
        goto L10
    L26:
        stats.mTotalTimeInForeground = proto.readLong(1112396529668L);
        goto L10
    L27:
        stats.mLastTimeUsed = statsOut.beginTime + proto.readLong(1112396529667L);
        goto L10
    L28:
        UsageStats tempPackageIndex = statsOut.getOrCreateUsageStats(stringPool.get(proto.readInt(1120986464258L) - 1));
        tempPackageIndex.mLastTimeUsed = stats.mLastTimeUsed;
        tempPackageIndex.mTotalTimeInForeground = stats.mTotalTimeInForeground;
        tempPackageIndex.mLastEvent = stats.mLastEvent;
        tempPackageIndex.mAppLaunchCount = stats.mAppLaunchCount;
        stats = tempPackageIndex;
        goto L10
    L29:
        UsageStats tempPackage = statsOut.getOrCreateUsageStats(proto.readString(1138166333441L));
        tempPackage.mLastTimeUsed = stats.mLastTimeUsed;
        tempPackage.mTotalTimeInForeground = stats.mTotalTimeInForeground;
        tempPackage.mLastEvent = stats.mLastEvent;
        tempPackage.mAppLaunchCount = stats.mAppLaunchCount;
        stats = tempPackage;
        goto L10
    L31:
        proto.end(token);
        return;
    L6:
        if (proto.nextField(1138166333441L) == false) goto L8;
        stats = statsOut.getOrCreateUsageStats(proto.readString(1138166333441L));
        goto L10
    L8:
        stats = new UsageStats();
        goto L10
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
        if (usageStats.mChooserCounts != null) goto L5;
        usageStats.mChooserCounts = new ArrayMap();
    L5:
        String action = null;
        if (proto.nextField(1138166333441L) == false) goto L10;
        action = proto.readString(1138166333441L);
        ArrayMap<String, Integer> counts = (ArrayMap) usageStats.mChooserCounts.get(action);
        if (counts != null) goto L12;
        counts = new ArrayMap();
        usageStats.mChooserCounts.put(action, counts);
    L12:
        switch(proto.nextField()) {
            case -1: goto L17;
            case 0: goto L12;
            case 1: goto L15;
            case 2: goto L12;
            case 3: goto L14;
            default: goto L12;
        };
    L14:
        long token = proto.start(2246267895811L);
        loadCountsForAction(proto, counts);
        proto.end(token);
        goto L17
    L15:
        action = proto.readString(1138166333441L);
        usageStats.mChooserCounts.put(action, counts);
    L17:
        if (action != null) goto L27;
        usageStats.mChooserCounts.put("", counts);
        return;
    L27:
        return;
    L10:
        counts = new ArrayMap();
        goto L12
    }

    private static void loadCountsForAction(ProtoInputStream proto, ArrayMap<String, Integer> counts) throws IOException {
        String category = null;
        int count = 0;
    L4:
        switch(proto.nextField()) {
            case -1: goto L9;
            case 0: goto L4;
            case 1: goto L7;
            case 2: goto L4;
            case 3: goto L6;
            default: goto L4;
        };
    L6:
        count = proto.readInt(1120986464259L);
        goto L4
    L7:
        category = proto.readString(1138166333441L);
        goto L4
    L9:
        if (category != null) goto L11;
        counts.put("", Integer.valueOf(count));
        return;
    L11:
        counts.put(category, Integer.valueOf(count));
    }

    private static void loadConfigStats(ProtoInputStream proto, long fieldId, IntervalStats statsOut) throws IOException {
        long token = proto.start(fieldId);
        boolean configActive = false;
        Configuration config = new Configuration();
        if (proto.nextField(1146756268033L) == false) goto L5;
        config.readFromProto(proto, 1146756268033L);
        ConfigurationStats configStats = statsOut.getOrCreateConfigurationStats(config);
    L7:
        switch(proto.nextField()) {
            case -1: goto L15;
            case 0: goto L7;
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            default: goto L7;
        };
    L9:
        configActive = proto.readBoolean(1133871366149L);
        goto L7
    L10:
        configStats.mActivationCount = proto.readInt(1120986464260L);
        goto L7
    L11:
        configStats.mTotalTimeActive = proto.readLong(1112396529667L);
        goto L7
    L12:
        configStats.mLastTimeActive = statsOut.beginTime + proto.readLong(1112396529666L);
        goto L7
    L13:
        config.readFromProto(proto, 1146756268033L);
        ConfigurationStats temp = statsOut.getOrCreateConfigurationStats(config);
        temp.mLastTimeActive = configStats.mLastTimeActive;
        temp.mTotalTimeActive = configStats.mTotalTimeActive;
        temp.mActivationCount = configStats.mActivationCount;
        configStats = temp;
        goto L7
    L15:
        if (configActive == false) goto L17;
        statsOut.activeConfiguration = configStats.mConfiguration;
    L17:
        proto.end(token);
        return;
    L5:
        configStats = new ConfigurationStats();
        goto L7
    }

    private static void loadEvent(ProtoInputStream proto, long fieldId, IntervalStats statsOut, List<String> stringPool) throws IOException {
        long token = proto.start(fieldId);
        UsageEvents.Event event = statsOut.buildEvent(proto, stringPool);
        proto.end(token);
        if (event.mPackage == null) goto L7;
        statsOut.events.insert(event);
        return;
    L7:
        throw new ProtocolException("no package field present");
    }

    private static void writeStringPool(ProtoOutputStream proto, IntervalStats stats) throws IllegalArgumentException {
        long token = proto.start(1146756268034L);
        int size = stats.mStringCache.size();
        proto.write(1120986464257L, size);
        int i = 0;
    L3:
        if (i >= size) goto L5;
        proto.write(2237677961218L, stats.mStringCache.valueAt(i));
        i = i + 1;
        goto L3
    L5:
        proto.end(token);
    }

    private static void writeUsageStats(ProtoOutputStream proto, long fieldId, IntervalStats stats, UsageStats usageStats) throws IllegalArgumentException {
        long token = proto.start(fieldId);
        int packageIndex = stats.mStringCache.indexOf(usageStats.mPackageName);
        if (packageIndex < 0) goto L5;
        proto.write(1120986464258L, packageIndex + 1);
    L6:
        UsageStatsProtoV2.writeOffsetTimestamp(proto, 1112396529667L, usageStats.mLastTimeUsed, stats.beginTime);
        proto.write(1112396529668L, usageStats.mTotalTimeInForeground);
        proto.write(1120986464261L, usageStats.mLastEvent);
        UsageStatsProtoV2.writeOffsetTimestamp(proto, 1112396529672L, usageStats.mLastTimeForegroundServiceUsed, stats.beginTime);
        proto.write(1112396529673L, usageStats.mTotalTimeForegroundServiceUsed);
        UsageStatsProtoV2.writeOffsetTimestamp(proto, 1112396529674L, usageStats.mLastTimeVisible, stats.beginTime);
        proto.write(1112396529675L, usageStats.mTotalTimeVisible);
        UsageStatsProtoV2.writeOffsetTimestamp(proto, 1112396529676L, usageStats.mLastTimeComponentUsed, stats.beginTime);
        proto.write(1120986464262L, usageStats.mAppLaunchCount);
        writeChooserCounts(proto, usageStats);     // Catch: IllegalArgumentException -> L9
    L11:
        proto.end(token);
        return;
    L9:
        e = move-exception;
        Slog.e(TAG, "Unable to write chooser counts for " + usageStats.mPackageName, e);
        goto L11
    L5:
        proto.write(1138166333441L, usageStats.mPackageName);
        goto L6
    }

    private static void writeCountAndTime(ProtoOutputStream proto, long fieldId, int count, long time) throws IllegalArgumentException {
        long token = proto.start(fieldId);
        proto.write(1120986464257L, count);
        proto.write(1112396529666L, time);
        proto.end(token);
    }

    private static void writeChooserCounts(ProtoOutputStream proto, UsageStats usageStats) throws IllegalArgumentException {
        if (usageStats != null) goto L4;
        return;
    L4:
        if (usageStats.mChooserCounts != null) goto L6;
        return;
    L6:
        if (usageStats.mChooserCounts.keySet().isEmpty() == true) goto L27;
        int chooserCountSize = usageStats.mChooserCounts.size();
        int i = 0;
    L9:
        if (i >= chooserCountSize) goto L19;
        String action = (String) usageStats.mChooserCounts.keyAt(i);
        ArrayMap<String, Integer> counts = (ArrayMap) usageStats.mChooserCounts.valueAt(i);
        if (action == null) goto L17;
        if (counts == null) goto L17;
        if (counts.isEmpty() == true) goto L17;
        long token = proto.start(2246267895815L);
        proto.write(1138166333441L, action);
        writeCountsForAction(proto, counts);
        proto.end(token);
    L17:
        i = i + 1;
        goto L9
    L19:
        return;
    }

    private static void writeCountsForAction(ProtoOutputStream proto, ArrayMap<String, Integer> counts) throws IllegalArgumentException {
        int countsSize = counts.size();
        int i = 0;
    L3:
        if (i >= countsSize) goto L9;
        String key = counts.keyAt(i);
        int count = counts.valueAt(i).intValue();
        if (count <= 0) goto L7;
        long token = proto.start(2246267895811L);
        proto.write(1138166333441L, key);
        proto.write(1120986464259L, count);
        proto.end(token);
    L7:
        i = i + 1;
        goto L3
    }

    private static void writeConfigStats(ProtoOutputStream proto, long fieldId, IntervalStats stats, ConfigurationStats configStats, boolean isActive) throws IllegalArgumentException {
        long token = proto.start(fieldId);
        configStats.mConfiguration.dumpDebug(proto, 1146756268033L);
        UsageStatsProtoV2.writeOffsetTimestamp(proto, 1112396529666L, configStats.mLastTimeActive, stats.beginTime);
        proto.write(1112396529667L, configStats.mTotalTimeActive);
        proto.write(1120986464260L, configStats.mActivationCount);
        proto.write(1133871366149L, isActive);
        proto.end(token);
    }

    private static void writeEvent(ProtoOutputStream proto, long fieldId, IntervalStats stats, UsageEvents.Event event) throws IllegalArgumentException {
        long token = proto.start(fieldId);
        int packageIndex = stats.mStringCache.indexOf(event.mPackage);
        if (packageIndex < 0) goto L5;
        proto.write(1120986464258L, packageIndex + 1);
    L7:
        if (event.mClass == null) goto L12;
        int classIndex = stats.mStringCache.indexOf(event.mClass);
        if (classIndex < 0) goto L11;
        proto.write(1120986464260L, classIndex + 1);
        goto L12
    L11:
        proto.write(1138166333443L, event.mClass);
    L12:
        UsageStatsProtoV2.writeOffsetTimestamp(proto, 1112396529669L, event.mTimeStamp, stats.beginTime);
        proto.write(1120986464262L, event.mFlags);
        proto.write(1120986464263L, event.mEventType);
        proto.write(1120986464270L, event.mInstanceId);
        if (event.mTaskRootPackage == null) goto L18;
        int taskRootPackageIndex = stats.mStringCache.indexOf(event.mTaskRootPackage);
        if (taskRootPackageIndex < 0) goto L18;
        proto.write(1120986464271L, taskRootPackageIndex + 1);
    L18:
        if (event.mTaskRootClass == null) goto L23;
        int taskRootClassIndex = stats.mStringCache.indexOf(event.mTaskRootClass);
        if (taskRootClassIndex < 0) goto L23;
        proto.write(1120986464272L, taskRootClassIndex + 1);
    L23:
        switch(event.mEventType) {
            case 5: goto L44;
            case 8: goto L41;
            case 11: goto L38;
            case 12: goto L31;
            case 30: goto L26;
            default: goto L46;
        };
    L46:
        proto.end(token);
        return;
    L26:
        if (event.mLocusId == null) goto L46;
        int locusIdIndex = stats.mStringCache.indexOf(event.mLocusId);
        if (locusIdIndex < 0) goto L46;
        proto.write(1120986464273L, locusIdIndex + 1);
        goto L46
    L31:
        if (event.mNotificationChannelId == null) goto L46;
        int channelIndex = stats.mStringCache.indexOf(event.mNotificationChannelId);
        if (channelIndex < 0) goto L35;
        proto.write(1120986464269L, channelIndex + 1);
        goto L46
    L35:
        proto.write(1138166333452L, event.mNotificationChannelId);
        goto L46
    L38:
        if (event.mBucketAndReason == 0) goto L46;
        proto.write(1120986464267L, event.mBucketAndReason);
        goto L46
    L41:
        if (event.mShortcutId == null) goto L46;
        proto.write(1138166333449L, event.mShortcutId);
        goto L46
    L44:
        if (event.mConfiguration == null) goto L46;
        event.mConfiguration.dumpDebug(proto, 1146756268040L);
        goto L46
    L5:
        proto.write(1138166333441L, event.mPackage);
        goto L7
    }

    public static void read(InputStream in, IntervalStats statsOut) throws IOException {
        ProtoInputStream proto = new ProtoInputStream(in);
        List<String> stringPool = null;
        statsOut.packageStats.clear();
        statsOut.configurations.clear();
        statsOut.activeConfiguration = null;
        statsOut.events.clear();
    L4:
        switch(proto.nextField()) {
            case -1: goto L33;
            case 1: goto L31;
            case 2: goto L39;
            case 3: goto L26;
            case 4: goto L25;
            case 10: goto L24;
            case 11: goto L23;
            case 12: goto L22;
            case 13: goto L21;
            case 20: goto L35;
            case 21: goto L37;
            case 22: goto L41;
            default: goto L4;
        };
    L39:
        stringPool = readStringPool(proto);     // Catch: IOException -> L29
        statsOut.mStringCache.addAll(stringPool);     // Catch: IOException -> L29
    L29:
        e = move-exception;
        Slog.e(TAG, "Unable to read string pool from proto.", e);
        goto L4
    L41:
        loadEvent(proto, 2246267895830L, statsOut, stringPool);     // Catch: IOException -> L9
    L9:
        e = move-exception;
        Slog.e(TAG, "Unable to read some events from proto.", e);
        goto L4
    L37:
        loadConfigStats(proto, 2246267895829L, statsOut);     // Catch: IOException -> L14
    L14:
        e = move-exception;
        Slog.e(TAG, "Unable to read some configuration stats from proto.", e);
        goto L4
    L35:
        loadUsageStats(proto, 2246267895828L, statsOut, stringPool);     // Catch: IOException -> L19
    L19:
        e = move-exception;
        Slog.e(TAG, "Unable to read some usage stats from proto.", e);
        goto L4
    L21:
        loadCountAndTime(proto, 1146756268045L, statsOut.keyguardHiddenTracker);
        goto L4
    L22:
        loadCountAndTime(proto, 1146756268044L, statsOut.keyguardShownTracker);
        goto L4
    L23:
        loadCountAndTime(proto, 1146756268043L, statsOut.nonInteractiveTracker);
        goto L4
    L24:
        loadCountAndTime(proto, 1146756268042L, statsOut.interactiveTracker);
        goto L4
    L25:
        statsOut.minorVersion = proto.readInt(1120986464260L);
        goto L4
    L26:
        statsOut.majorVersion = proto.readInt(1120986464259L);
        goto L4
    L31:
        statsOut.endTime = statsOut.beginTime + proto.readLong(1112396529665L);
        goto L4
    L33:
        statsOut.upgradeIfNeeded();
    }

    public static void write(OutputStream out, IntervalStats stats) throws IOException, IllegalArgumentException {
        ProtoOutputStream proto = new ProtoOutputStream(out);
        proto.write(1112396529665L, UsageStatsProtoV2.getOffsetTimestamp(stats.endTime, stats.beginTime));
        proto.write(1120986464259L, stats.majorVersion);
        proto.write(1120986464260L, stats.minorVersion);
        writeStringPool(proto, stats);     // Catch: IllegalArgumentException -> L5
    L50:
        writeCountAndTime(proto, 1146756268042L, stats.interactiveTracker.count, stats.interactiveTracker.duration);     // Catch: IllegalArgumentException -> L9
        writeCountAndTime(proto, 1146756268043L, stats.nonInteractiveTracker.count, stats.nonInteractiveTracker.duration);     // Catch: IllegalArgumentException -> L9
        writeCountAndTime(proto, 1146756268044L, stats.keyguardShownTracker.count, stats.keyguardShownTracker.duration);     // Catch: IllegalArgumentException -> L9
        writeCountAndTime(proto, 1146756268045L, stats.keyguardHiddenTracker.count, stats.keyguardHiddenTracker.duration);     // Catch: IllegalArgumentException -> L9
    L11:
        int statsCount = stats.packageStats.size();
        int i = 0;
    L12:
        if (i >= statsCount) goto L18;
        writeUsageStats(proto, 2246267895828L, stats, stats.packageStats.valueAt(i));     // Catch: IllegalArgumentException -> L15
    L17:
        i = i + 1;
    L15:
        e = move-exception;
        Slog.e(TAG, "Unable to write some usage stats to proto.", e);
        goto L17
    L18:
        int configCount = stats.configurations.size();
        int i2 = 0;
    L19:
        if (i2 >= configCount) goto L31;
        boolean active = stats.activeConfiguration.equals(stats.configurations.keyAt(i2));
        IntervalStats stats2 = stats;
        writeConfigStats(proto, 2246267895829L, stats2, stats.configurations.valueAt(i2), active);     // Catch: IllegalArgumentException -> L25
    L30:
        i2 = i2 + 1;
        stats = stats2;
    L25:
        e = move-exception;
        IllegalArgumentException e = e;
    L29:
        Slog.e(TAG, "Unable to write some configuration stats to proto.", e);
    L27:
        e = move-exception;
        stats2 = stats;
        e = e;
        goto L29
    L31:
        IntervalStats stats3 = stats;
        int eventCount = stats3.events.size();
        int i3 = 0;
    L32:
        if (i3 >= eventCount) goto L38;
        writeEvent(proto, 2246267895830L, stats3, stats3.events.get(i3));     // Catch: IllegalArgumentException -> L35
    L37:
        i3 = i3 + 1;
    L35:
        e = move-exception;
        Slog.e(TAG, "Unable to write some events to proto.", e);
        goto L37
    L38:
        proto.flush();
        return;
    L9:
        e = move-exception;
        Slog.e(TAG, "Unable to write some interval stats trackers to proto.", e);
    L5:
        e = move-exception;
        Slog.e(TAG, "Unable to write string pool to proto.", e);
        goto L50
    }
}
