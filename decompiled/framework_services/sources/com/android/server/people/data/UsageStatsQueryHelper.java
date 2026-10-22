package com.android.server.people.data;

import android.app.usage.UsageEvents;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManagerInternal;
import android.content.ComponentName;
import android.content.LocusId;
import android.util.ArrayMap;
import com.android.server.LocalServices;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
class UsageStatsQueryHelper {
    private final Map<ComponentName, UsageEvents.Event> mConvoStartEvents;
    private final EventListener mEventListener;
    private long mLastEventTimestamp;
    private final Function<String, PackageData> mPackageDataGetter;
    private final UsageStatsManagerInternal mUsageStatsManagerInternal;
    private final int mUserId;

    interface EventListener {
        void onEvent(PackageData r1, ConversationInfo r2, Event r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$6bCySXa5wmagIaqXkr4gJ-ju1TI, reason: not valid java name */
    public static /* synthetic */ AppUsageStatsData m6561$r8$lambda$6bCySXa5wmagIaqXkr4gJju1TI(String r0) {
        return lambda$queryAppUsageStats$0(r0);
    }

    UsageStatsQueryHelper(int userId, Function<String, PackageData> packageDataGetter, EventListener eventListener) {
        this.mConvoStartEvents = new ArrayMap();
        this.mUsageStatsManagerInternal = getUsageStatsManagerInternal();
        this.mUserId = userId;
        this.mPackageDataGetter = packageDataGetter;
        this.mEventListener = eventListener;
    }

    boolean querySince(long sinceTime) {
        UsageEvents usageEvents = this.mUsageStatsManagerInternal.queryEventsForUser(this.mUserId, sinceTime, System.currentTimeMillis(), 0);
        if (usageEvents != null) goto L6;
        return false;
    L6:
        boolean hasEvents = false;
    L8:
        if (usageEvents.hasNextEvent() == false) goto L26;
        UsageEvents.Event e = new UsageEvents.Event();
        usageEvents.getNextEvent(e);
        hasEvents = true;
        this.mLastEventTimestamp = Math.max(this.mLastEventTimestamp, e.getTimeStamp());
        String packageName = e.getPackageName();
        PackageData packageData = this.mPackageDataGetter.apply(packageName);
        if (packageData == null) goto L8;
        switch(e.getEventType()) {
            case 2: goto L24;
            case 8: goto L23;
            case 23: goto L24;
            case 24: goto L24;
            case 30: goto L15;
            default: goto L8;
        };
    L15:
        onInAppConversationEnded(packageData, e);
        if (e.getLocusId() == null) goto L18;
        LocusId locusId = new LocusId(e.getLocusId());
    L19:
        if (locusId == null) goto L8;
        if (packageData.getConversationStore().getConversationByLocusId(locusId) == null) goto L8;
        ComponentName activityName = new ComponentName(packageName, e.getClassName());
        this.mConvoStartEvents.put(activityName, e);
        goto L8
    L18:
        locusId = null;
        goto L19
    L23:
        addEventByShortcutId(packageData, e.getShortcutId(), new Event(e.getTimeStamp(), 1));
        goto L8
    L24:
        onInAppConversationEnded(packageData, e);
        goto L8
    L26:
        return hasEvents;
    }

    long getLastEventTimestamp() {
        return this.mLastEventTimestamp;
    }

    static List<UsageEvents.Event> queryAppMovingToForegroundEvents(int userId, long startTime, long endTime) {
        List<UsageEvents.Event> res = new ArrayList();
        UsageEvents usageEvents = getUsageStatsManagerInternal().queryEventsForUser(userId, startTime, endTime, 10);
        if (usageEvents != null) goto L6;
        return res;
    L6:
        if (usageEvents.hasNextEvent() == false) goto L11;
        UsageEvents.Event e = new UsageEvents.Event();
        usageEvents.getNextEvent(e);
        if (e.getEventType() != 1) goto L6;
        res.add(e);
        goto L6
    L11:
        return res;
    }

    static Map<String, AppUsageStatsData> queryAppUsageStats(int userId, long startTime, long endTime, Set<String> packageNameFilter) {
        List<UsageStats> stats = getUsageStatsManagerInternal().queryUsageStatsForUser(userId, 4, startTime, endTime, false);
        Map<String, AppUsageStatsData> aggregatedStats = new ArrayMap();
        if (stats != null) goto L5;
        return aggregatedStats;
    L5:
        Iterator<UsageStats> r10 = stats.iterator();
    L7:
        if (r10.hasNext() == false) goto L12;
        UsageStats stat = r10.next();
        String packageName = stat.getPackageName();
        if (packageNameFilter.contains(packageName) == false) goto L7;
        AppUsageStatsData packageStats = aggregatedStats.computeIfAbsent(packageName, new UsageStatsQueryHelper$$ExternalSyntheticLambda0());
        packageStats.incrementChosenCountBy(sumChooserCounts(stat.mChooserCounts));
        packageStats.incrementLaunchCountBy(stat.getAppLaunchCount());
        goto L7
    L12:
        return aggregatedStats;
    }

    private static /* synthetic */ AppUsageStatsData lambda$queryAppUsageStats$0(String key) {
        return new AppUsageStatsData();
    }

    private static int sumChooserCounts(ArrayMap<String, ArrayMap<String, Integer>> chooserCounts) {
        int sum = 0;
        if (chooserCounts != null) goto L5;
        return 0;
    L5:
        int chooserCountsSize = chooserCounts.size();
        int i = 0;
    L6:
        if (i >= chooserCountsSize) goto L15;
        ArrayMap<String, Integer> counts = chooserCounts.valueAt(i);
        if (counts == null) goto L13;
        int annotationSize = counts.size();
        int j = 0;
    L11:
        if (j >= annotationSize) goto L13;
        sum = sum + counts.valueAt(j).intValue();
        j = j + 1;
    L13:
        i = i + 1;
        goto L6
    L15:
        return sum;
    }

    private void onInAppConversationEnded(PackageData packageData, UsageEvents.Event endEvent) {
        ComponentName activityName = new ComponentName(endEvent.getPackageName(), endEvent.getClassName());
        UsageEvents.Event startEvent = this.mConvoStartEvents.remove(activityName);
        if (startEvent != null) goto L5;
        return;
    L5:
        if (startEvent.getTimeStamp() >= endEvent.getTimeStamp()) goto L10;
        long durationMillis = endEvent.getTimeStamp() - startEvent.getTimeStamp();
        Event event = new Event.Builder(startEvent.getTimeStamp(), 13).setDurationSeconds((int) (durationMillis / 1000)).build();
        addEventByLocusId(packageData, new LocusId(startEvent.getLocusId()), event);
        return;
    }

    private void addEventByShortcutId(PackageData packageData, String shortcutId, Event event) {
        ConversationInfo conversationInfo = packageData.getConversationStore().getConversation(shortcutId);
        if (conversationInfo != null) goto L5;
        return;
    L5:
        EventHistoryImpl eventHistory = packageData.getEventStore().getOrCreateEventHistory(0, shortcutId);
        eventHistory.addEvent(event);
        this.mEventListener.onEvent(packageData, conversationInfo, event);
    }

    private void addEventByLocusId(PackageData packageData, LocusId locusId, Event event) {
        ConversationInfo conversationInfo = packageData.getConversationStore().getConversationByLocusId(locusId);
        if (conversationInfo != null) goto L5;
        return;
    L5:
        EventHistoryImpl eventHistory = packageData.getEventStore().getOrCreateEventHistory(1, locusId.getId());
        eventHistory.addEvent(event);
        this.mEventListener.onEvent(packageData, conversationInfo, event);
    }

    private static UsageStatsManagerInternal getUsageStatsManagerInternal() {
        return (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class);
    }
}
