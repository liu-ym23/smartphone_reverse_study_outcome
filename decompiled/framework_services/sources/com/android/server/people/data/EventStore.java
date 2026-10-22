package com.android.server.people.data;

import android.net.Uri;
import android.util.ArrayMap;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
class EventStore {
    static final int CATEGORY_CALL = 2;
    static final int CATEGORY_CLASS_BASED = 4;
    static final int CATEGORY_LOCUS_ID_BASED = 1;
    static final int CATEGORY_SHORTCUT_BASED = 0;
    static final int CATEGORY_SMS = 3;
    private final List<Map<String, EventHistoryImpl>> mEventHistoryMaps;
    private final List<File> mEventsCategoryDirs;
    private final ScheduledExecutorService mScheduledExecutorService;

    @Retention(RetentionPolicy.SOURCE)
    @interface EventCategory {
    }

    public static /* synthetic */ EventHistoryImpl $r8$lambda$yojDA_SA_GEKX7l8MlonV0IEO3A(EventStore r0, int r1, String r2, String r3) {
        return r0.lambda$getOrCreateEventHistory$0(r1, r2, r3);
    }

    EventStore(File packageDir, ScheduledExecutorService scheduledExecutorService) {
        this.mEventHistoryMaps = new ArrayList();
        this.mEventsCategoryDirs = new ArrayList();
        this.mEventHistoryMaps.add(0, new ArrayMap());
        this.mEventHistoryMaps.add(1, new ArrayMap());
        this.mEventHistoryMaps.add(2, new ArrayMap());
        this.mEventHistoryMaps.add(3, new ArrayMap());
        this.mEventHistoryMaps.add(4, new ArrayMap());
        File eventDir = new File(packageDir, "event");
        this.mEventsCategoryDirs.add(0, new File(eventDir, "shortcut"));
        this.mEventsCategoryDirs.add(1, new File(eventDir, "locus"));
        this.mEventsCategoryDirs.add(2, new File(eventDir, "call"));
        this.mEventsCategoryDirs.add(3, new File(eventDir, "sms"));
        this.mEventsCategoryDirs.add(4, new File(eventDir, "class"));
        this.mScheduledExecutorService = scheduledExecutorService;
    }

    synchronized void loadFromDisk() {
        monitor-enter(this);
        int category = 0;
    L15:
    L8:
        th = move-exception;
        throw th;
    L5:
        if (category >= this.mEventsCategoryDirs.size()) goto L11;
        File categoryDir = this.mEventsCategoryDirs.get(category);     // Catch: Throwable -> L8
        Map<String, EventHistoryImpl> existingEventHistoriesImpl = EventHistoryImpl.eventHistoriesImplFromDisk(categoryDir, this.mScheduledExecutorService);     // Catch: Throwable -> L8
        this.mEventHistoryMaps.get(category).putAll(existingEventHistoriesImpl);     // Catch: Throwable -> L8
        category = category + 1;
        goto L15
    L11:
        monitor-exit(this);
    }

    synchronized void saveToDisk() {
        monitor-enter(this);
        Iterator<Map<String, EventHistoryImpl>> r0 = this.mEventHistoryMaps.iterator();     // Catch: Throwable -> L11
    L5:
        if (r0.hasNext() == false) goto L14;
        Map<String, EventHistoryImpl> map = r0.next();     // Catch: Throwable -> L11
        Iterator<EventHistoryImpl> r2 = map.values().iterator();     // Catch: Throwable -> L11
    L8:
        if (r2.hasNext() == false) goto L5;
        EventHistoryImpl eventHistory = r2.next();     // Catch: Throwable -> L11
        eventHistory.saveToDisk();     // Catch: Throwable -> L11
        goto L8
    L14:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    synchronized EventHistory getEventHistory(int category, String key) {
        monitor-enter(this);
        EventHistoryImpl r0 = this.mEventHistoryMaps.get(category).get(key);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized EventHistoryImpl getOrCreateEventHistory(final int category, final String key) {
        monitor-enter(this);
        EventHistoryImpl r0 = this.mEventHistoryMaps.get(category).computeIfAbsent(key, new EventStore$$ExternalSyntheticLambda0(this, category, key));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ EventHistoryImpl lambda$getOrCreateEventHistory$0(int category, String key, String k) {
        return new EventHistoryImpl(new File(this.mEventsCategoryDirs.get(category), Uri.encode(key)), this.mScheduledExecutorService);
    }

    synchronized void deleteEventHistory(int category, String key) {
        monitor-enter(this);
        EventHistoryImpl eventHistory = this.mEventHistoryMaps.get(category).remove(key);     // Catch: Throwable -> L7
        if (eventHistory == null) goto L9;
        eventHistory.onDestroy();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    synchronized void deleteEventHistories(int category) {
        monitor-enter(this);
        Iterator<EventHistoryImpl> r0 = this.mEventHistoryMaps.get(category).values().iterator();     // Catch: Throwable -> L7
    L5:
        if (r0.hasNext() == false) goto L9;
        EventHistoryImpl eventHistory = r0.next();     // Catch: Throwable -> L7
        eventHistory.onDestroy();     // Catch: Throwable -> L7
        goto L5
    L9:
        this.mEventHistoryMaps.get(category).clear();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    synchronized void pruneOldEvents() {
        monitor-enter(this);
        Iterator<Map<String, EventHistoryImpl>> r0 = this.mEventHistoryMaps.iterator();     // Catch: Throwable -> L11
    L5:
        if (r0.hasNext() == false) goto L14;
        Map<String, EventHistoryImpl> map = r0.next();     // Catch: Throwable -> L11
        Iterator<EventHistoryImpl> r2 = map.values().iterator();     // Catch: Throwable -> L11
    L8:
        if (r2.hasNext() == false) goto L5;
        EventHistoryImpl eventHistory = r2.next();     // Catch: Throwable -> L11
        eventHistory.pruneOldEvents();     // Catch: Throwable -> L11
        goto L8
    L14:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    synchronized void pruneOrphanEventHistories(int category, Predicate<String> keyChecker) {
        monitor-enter(this);
        Set<String> keys = this.mEventHistoryMaps.get(category).keySet();     // Catch: Throwable -> L9
        List<String> keysToDelete = new ArrayList();     // Catch: Throwable -> L9
        Iterator<String> r2 = keys.iterator();     // Catch: Throwable -> L9
    L5:
        if (r2.hasNext() == false) goto L12;
        String key = r2.next();     // Catch: Throwable -> L9
        if (keyChecker.test(key) == true) goto L5;
        keysToDelete.add(key);     // Catch: Throwable -> L9
        goto L5
    L12:
        Map<String, EventHistoryImpl> eventHistoryMap = this.mEventHistoryMaps.get(category);     // Catch: Throwable -> L9
        Iterator<String> r3 = keysToDelete.iterator();     // Catch: Throwable -> L9
    L13:
        if (r3.hasNext() == false) goto L19;
        EventHistoryImpl eventHistory = eventHistoryMap.remove(r3.next());     // Catch: Throwable -> L9
        if (eventHistory == null) goto L13;
        eventHistory.onDestroy();     // Catch: Throwable -> L9
        goto L13
    L19:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    synchronized void onDestroy() {
        monitor-enter(this);
        Iterator<Map<String, EventHistoryImpl>> r0 = this.mEventHistoryMaps.iterator();     // Catch: Throwable -> L11
    L5:
        if (r0.hasNext() == false) goto L14;
        Map<String, EventHistoryImpl> map = r0.next();     // Catch: Throwable -> L11
        Iterator<EventHistoryImpl> r2 = map.values().iterator();     // Catch: Throwable -> L11
    L8:
        if (r2.hasNext() == false) goto L5;
        EventHistoryImpl eventHistory = r2.next();     // Catch: Throwable -> L11
        eventHistory.onDestroy();     // Catch: Throwable -> L11
        goto L8
    L14:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
