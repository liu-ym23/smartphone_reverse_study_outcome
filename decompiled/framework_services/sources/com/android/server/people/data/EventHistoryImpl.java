package com.android.server.people.data;

import android.net.Uri;
import android.os.FileUtils;
import android.util.ArrayMap;
import android.util.Slog;
import android.util.SparseArray;
import android.util.proto.ProtoInputStream;
import android.util.proto.ProtoOutputStream;
import com.android.server.cpu.CpuInfoReader$$ExternalSyntheticLambda2;
import com.google.android.collect.Lists;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
class EventHistoryImpl implements EventHistory {
    private static final String EVENTS_DIR = "events";
    private static final String INDEXES_DIR = "indexes";
    private static final long MAX_EVENTS_AGE = 14400000;
    private static final long PRUNE_OLD_EVENTS_DELAY = 900000;
    private final SparseArray<EventIndex> mEventIndexArray;
    private final EventIndexesProtoDiskReadWriter mEventIndexesProtoDiskReadWriter;
    private final EventsProtoDiskReadWriter mEventsProtoDiskReadWriter;
    private final Injector mInjector;
    private long mLastPruneTime;
    private final EventList mRecentEvents;
    private final File mRootDir;
    private final ScheduledExecutorService mScheduledExecutorService;

    private static class EventIndexesProtoDiskReadWriter extends AbstractProtoDiskReadWriter<SparseArray<EventIndex>> {
        private static final String INDEXES_FILE = "index";
        private static final String TAG = null;

        public static /* synthetic */ void $r8$lambda$FxIQcEIXaWsRtkNjw4hiXGO_AYA(ProtoOutputStream r0, SparseArray r1) {
            lambda$protoStreamWriter$0(r0, r1);
        }

        public static /* synthetic */ SparseArray $r8$lambda$L6Dwp6Ys_3xuchRMGT2oqlN9TNs(ProtoInputStream r0) {
            return lambda$protoStreamReader$1(r0);
        }

        static {
            TAG = EventIndexesProtoDiskReadWriter.class.getSimpleName();
        }

        EventIndexesProtoDiskReadWriter(File rootDir, ScheduledExecutorService scheduledExecutorService) {
            super(rootDir, scheduledExecutorService);
            rootDir.mkdirs();
        }

        @Override // com.android.server.people.data.AbstractProtoDiskReadWriter
        AbstractProtoDiskReadWriter.ProtoStreamWriter<SparseArray<EventIndex>> protoStreamWriter() {
            return new EventHistoryImpl$EventIndexesProtoDiskReadWriter$$ExternalSyntheticLambda1();
        }

        private static /* synthetic */ void lambda$protoStreamWriter$0(ProtoOutputStream protoOutputStream, SparseArray data) {
            int i = 0;
        L4:
            if (i >= data.size()) goto L7;
            int eventType = data.keyAt(i);
            EventIndex index = (EventIndex) data.valueAt(i);
            long token = protoOutputStream.start(2246267895809L);
            protoOutputStream.write(1120986464257L, eventType);
            long indexToken = protoOutputStream.start(1146756268034L);
            index.writeToProto(protoOutputStream);
            protoOutputStream.end(indexToken);
            protoOutputStream.end(token);
            i = i + 1;
            goto L4
        }

        @Override // com.android.server.people.data.AbstractProtoDiskReadWriter
        AbstractProtoDiskReadWriter.ProtoStreamReader<SparseArray<EventIndex>> protoStreamReader() {
            return new EventHistoryImpl$EventIndexesProtoDiskReadWriter$$ExternalSyntheticLambda0();
        }

        private static /* synthetic */ SparseArray lambda$protoStreamReader$1(ProtoInputStream protoInputStream) {
            SparseArray<EventIndex> results = new SparseArray();
        L23:
            if (protoInputStream.nextField() == (-1)) goto L22;
            if (protoInputStream.getFieldNumber() != 1) goto L23;
            long token = protoInputStream.start(2246267895809L);     // Catch: IOException -> L14
            int eventType = 0;
            EventIndex index = EventIndex.EMPTY;     // Catch: IOException -> L14
        L10:
            if (protoInputStream.nextField() == (-1)) goto L18;
            switch(protoInputStream.getFieldNumber()) {
                case 1: goto L17;
                case 2: goto L16;
                default: goto L13;
            };     // Catch: IOException -> L14
        L16:
            long indexToken = protoInputStream.start(1146756268034L);     // Catch: IOException -> L14
            index = EventIndex.readFromProto(protoInputStream);     // Catch: IOException -> L14
            protoInputStream.end(indexToken);     // Catch: IOException -> L14
            goto L10
        L17:
            eventType = protoInputStream.readInt(1120986464257L);     // Catch: IOException -> L14
            goto L10
        L13:
            Slog.w(TAG, "Could not read undefined field: " + protoInputStream.getFieldNumber());     // Catch: IOException -> L14
            goto L10
        L18:
            results.append(eventType, index);     // Catch: IOException -> L14
            protoInputStream.end(token);     // Catch: IOException -> L14
        L22:
            return results;
        L14:
            e = move-exception;
            Slog.e(TAG, "Failed to read protobuf input stream.", e);
            goto L22
        }

        void scheduleIndexesSave(SparseArray<EventIndex> indexes) {
            scheduleSave("index", indexes);
        }

        void saveIndexesImmediately(SparseArray<EventIndex> indexes) {
            saveImmediately("index", indexes);
        }

        SparseArray<EventIndex> loadIndexesFromDisk() {
            return read("index");
        }

        void deleteIndexesFile() {
            delete("index");
        }
    }

    private static class EventsProtoDiskReadWriter extends AbstractProtoDiskReadWriter<EventList> {
        private static final String RECENT_FILE = "recent";
        private static final String TAG = null;

        /* JADX INFO: renamed from: $r8$lambda$3ofo6a7WNbKcUX64XOJ9k1-xak4, reason: not valid java name */
        public static /* synthetic */ EventList m6556$r8$lambda$3ofo6a7WNbKcUX64XOJ9k1xak4(ProtoInputStream r0) {
            return lambda$protoStreamReader$1(r0);
        }

        /* JADX INFO: renamed from: $r8$lambda$ad-xyMVgVsHZUYJ07pG90jJy5Bs, reason: not valid java name */
        public static /* synthetic */ void m6557$r8$lambda$adxyMVgVsHZUYJ07pG90jJy5Bs(ProtoOutputStream r0, EventList r1) {
            lambda$protoStreamWriter$0(r0, r1);
        }

        static {
            TAG = EventsProtoDiskReadWriter.class.getSimpleName();
        }

        EventsProtoDiskReadWriter(File rootDir, ScheduledExecutorService scheduledExecutorService) {
            super(rootDir, scheduledExecutorService);
            rootDir.mkdirs();
        }

        @Override // com.android.server.people.data.AbstractProtoDiskReadWriter
        AbstractProtoDiskReadWriter.ProtoStreamWriter<EventList> protoStreamWriter() {
            return new EventHistoryImpl$EventsProtoDiskReadWriter$$ExternalSyntheticLambda0();
        }

        private static /* synthetic */ void lambda$protoStreamWriter$0(ProtoOutputStream protoOutputStream, EventList data) {
            Iterator<Event> r0 = data.getAllEvents().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            Event event = r0.next();
            long token = protoOutputStream.start(2246267895809L);
            event.writeToProto(protoOutputStream);
            protoOutputStream.end(token);
            goto L4
        }

        @Override // com.android.server.people.data.AbstractProtoDiskReadWriter
        AbstractProtoDiskReadWriter.ProtoStreamReader<EventList> protoStreamReader() {
            return new EventHistoryImpl$EventsProtoDiskReadWriter$$ExternalSyntheticLambda1();
        }

        private static /* synthetic */ EventList lambda$protoStreamReader$1(ProtoInputStream protoInputStream) {
            List<Event> results = Lists.newArrayList();
        L16:
        L10:
            e = move-exception;
            Slog.e(TAG, "Failed to read protobuf input stream.", e);
        L14:
            EventList eventList = new EventList();
            eventList.addAll(results);
            return eventList;
        L4:
            if (protoInputStream.nextField() == (-1)) goto L14;
            if (protoInputStream.getFieldNumber() != 1) goto L16;
            long token = protoInputStream.start(2246267895809L);     // Catch: IOException -> L10
            Event event = Event.readFromProto(protoInputStream);     // Catch: IOException -> L10
            protoInputStream.end(token);     // Catch: IOException -> L10
            results.add(event);     // Catch: IOException -> L10
            goto L16
        }

        void scheduleEventsSave(EventList recentEvents) {
            scheduleSave(RECENT_FILE, recentEvents);
        }

        void saveEventsImmediately(EventList recentEvents) {
            saveImmediately(RECENT_FILE, recentEvents);
        }

        EventList loadRecentEventsFromDisk() {
            return read(RECENT_FILE);
        }

        void deleteRecentEventsFile() {
            delete(RECENT_FILE);
        }
    }

    static class Injector {
        Injector() {
        }

        EventIndex createEventIndex() {
            return new EventIndex();
        }

        long currentTimeMillis() {
            return System.currentTimeMillis();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$hAiy-YwVfvqOWISrmcvCHvZADVg, reason: not valid java name */
    public static /* synthetic */ void m6555$r8$lambda$hAiyYwVfvqOWISrmcvCHvZADVg(EventHistoryImpl r0) {
        r0.lambda$loadFromDisk$1();
    }

    public static /* synthetic */ boolean $r8$lambda$nQTxefT1kWveqCuO85tnZPddb28(File r0, String r1) {
        return lambda$eventHistoriesImplFromDisk$0(r0, r1);
    }

    EventHistoryImpl(File rootDir, ScheduledExecutorService scheduledExecutorService) {
        this(new Injector(), rootDir, scheduledExecutorService);
    }

    EventHistoryImpl(Injector injector, File rootDir, ScheduledExecutorService scheduledExecutorService) {
        this.mEventIndexArray = new SparseArray();
        this.mRecentEvents = new EventList();
        this.mInjector = injector;
        this.mScheduledExecutorService = scheduledExecutorService;
        this.mLastPruneTime = injector.currentTimeMillis();
        this.mRootDir = rootDir;
        File eventsDir = new File(this.mRootDir, EVENTS_DIR);
        this.mEventsProtoDiskReadWriter = new EventsProtoDiskReadWriter(eventsDir, this.mScheduledExecutorService);
        File indexesDir = new File(this.mRootDir, INDEXES_DIR);
        this.mEventIndexesProtoDiskReadWriter = new EventIndexesProtoDiskReadWriter(indexesDir, scheduledExecutorService);
    }

    static Map<String, EventHistoryImpl> eventHistoriesImplFromDisk(File categoryDir, ScheduledExecutorService scheduledExecutorService) {
        return eventHistoriesImplFromDisk(new Injector(), categoryDir, scheduledExecutorService);
    }

    static Map<String, EventHistoryImpl> eventHistoriesImplFromDisk(Injector injector, File categoryDir, ScheduledExecutorService scheduledExecutorService) {
        Map<String, EventHistoryImpl> results = new ArrayMap();
        File[] keyDirs = categoryDir.listFiles(new CpuInfoReader$$ExternalSyntheticLambda2());
        if (keyDirs != null) goto L5;
        return results;
    L5:
        int r2 = keyDirs.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L13;
        File keyDir = keyDirs[r3];
        File[] dirContents = keyDir.listFiles(new EventHistoryImpl$$ExternalSyntheticLambda1());
        if (dirContents == null) goto L12;
        if (dirContents.length != 2) goto L12;
        EventHistoryImpl eventHistory = new EventHistoryImpl(injector, keyDir, scheduledExecutorService);
        eventHistory.loadFromDisk();
        results.put(Uri.decode(keyDir.getName()), eventHistory);
    L12:
        r3 = r3 + 1;
        goto L6
    L13:
        return results;
    }

    private static /* synthetic */ boolean lambda$eventHistoriesImplFromDisk$0(File dir, String name) {
        if (EVENTS_DIR.equals(name) == false) goto L5;
    L8:
        return true;
    L5:
        if (INDEXES_DIR.equals(name) == true) goto L8;
        return false;
    }

    synchronized void loadFromDisk() {
        monitor-enter(this);
        this.mScheduledExecutorService.execute(new EventHistoryImpl$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$loadFromDisk$1() {
        monitor-enter(this);
        EventList diskEvents = this.mEventsProtoDiskReadWriter.loadRecentEventsFromDisk();     // Catch: Throwable -> L6
        if (diskEvents == null) goto L8;
        diskEvents.removeOldEvents(this.mInjector.currentTimeMillis() - 14400000);     // Catch: Throwable -> L6
        this.mRecentEvents.addAll(diskEvents.getAllEvents());     // Catch: Throwable -> L6
    L8:
        SparseArray<EventIndex> diskIndexes = this.mEventIndexesProtoDiskReadWriter.loadIndexesFromDisk();     // Catch: Throwable -> L6
        if (diskIndexes == null) goto L14;
        int i = 0;
    L12:
        if (i >= diskIndexes.size()) goto L14;
        this.mEventIndexArray.put(diskIndexes.keyAt(i), diskIndexes.valueAt(i));     // Catch: Throwable -> L6
        i = i + 1;     // Catch: Throwable -> L6
    L14:
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void saveToDisk() {
        monitor-enter(this);
        this.mEventsProtoDiskReadWriter.saveEventsImmediately(this.mRecentEvents);     // Catch: Throwable -> L6
        this.mEventIndexesProtoDiskReadWriter.saveIndexesImmediately(this.mEventIndexArray);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.people.data.EventHistory
    public synchronized EventIndex getEventIndex(int eventType) {
        monitor-enter(this);
        EventIndex eventIndex = this.mEventIndexArray.get(eventType);     // Catch: Throwable -> L6
        if (eventIndex == null) goto L8;
        EventIndex r1 = new EventIndex(eventIndex);     // Catch: Throwable -> L6
    L9:
        monitor-exit(this);
        return r1;
    L8:
        r1 = this.mInjector.createEventIndex();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.people.data.EventHistory
    public synchronized EventIndex getEventIndex(Set<Integer> eventTypes) {
        monitor-enter(this);
        EventIndex combined = this.mInjector.createEventIndex();     // Catch: Throwable -> L10
        Iterator<Integer> r1 = eventTypes.iterator();     // Catch: Throwable -> L10
    L5:
        if (r1.hasNext() == false) goto L13;
        int eventType = r1.next().intValue();     // Catch: Throwable -> L10
        EventIndex eventIndex = this.mEventIndexArray.get(eventType);     // Catch: Throwable -> L10
        if (eventIndex == null) goto L5;
        combined = EventIndex.combine(combined, eventIndex);     // Catch: Throwable -> L10
        goto L5
    L13:
        monitor-exit(this);
        return combined;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.people.data.EventHistory
    public synchronized List<Event> queryEvents(Set<Integer> eventTypes, long startTime, long endTime) {
        monitor-enter(this);
        List<Event> r7 = this.mRecentEvents.queryEvents(eventTypes, startTime, endTime);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r7;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void addEvent(Event event) {
        monitor-enter(this);
        pruneOldEvents();     // Catch: Throwable -> L6
        addEventInMemory(event);     // Catch: Throwable -> L6
        this.mEventsProtoDiskReadWriter.scheduleEventsSave(this.mRecentEvents);     // Catch: Throwable -> L6
        this.mEventIndexesProtoDiskReadWriter.scheduleIndexesSave(this.mEventIndexArray);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void onDestroy() {
        monitor-enter(this);
        this.mEventIndexArray.clear();     // Catch: Throwable -> L6
        this.mRecentEvents.clear();     // Catch: Throwable -> L6
        this.mEventsProtoDiskReadWriter.deleteRecentEventsFile();     // Catch: Throwable -> L6
        this.mEventIndexesProtoDiskReadWriter.deleteIndexesFile();     // Catch: Throwable -> L6
        FileUtils.deleteContentsAndDir(this.mRootDir);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void pruneOldEvents() {
        monitor-enter(this);
        long currentTime = this.mInjector.currentTimeMillis();     // Catch: Throwable -> L7
        if ((currentTime - this.mLastPruneTime) <= 900000) goto L9;
        this.mRecentEvents.removeOldEvents(currentTime - 14400000);     // Catch: Throwable -> L7
        this.mLastPruneTime = currentTime;     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private synchronized void addEventInMemory(Event event) {
        monitor-enter(this);
        EventIndex eventIndex = this.mEventIndexArray.get(event.getType());     // Catch: Throwable -> L6
        if (eventIndex != null) goto L8;
        eventIndex = this.mInjector.createEventIndex();     // Catch: Throwable -> L6
        this.mEventIndexArray.put(event.getType(), eventIndex);     // Catch: Throwable -> L6
    L8:
        eventIndex.addEvent(event.getTimestamp());     // Catch: Throwable -> L6
        this.mRecentEvents.add(event);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
