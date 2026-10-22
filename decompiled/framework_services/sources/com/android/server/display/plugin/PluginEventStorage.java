package com.android.server.display.plugin;

import android.util.IndentingPrintWriter;
import com.android.internal.util.RingBuffer;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class PluginEventStorage {
    private static final int MAX_TIME_FRAMES = 10;
    private static final long MIN_EVENT_DELAY = 500;
    private static final long TIME_FRAME_LENGTH = 60000;
    private static final SimpleDateFormat sDateFormat = null;
    private final Map<PluginType<?>, EventCounter> mCounters;
    private final Map<PluginType<?>, Long> mEventTimes;
    RingBuffer<TimeFrame> mEvents;
    private long mTimeFrameStart;

    private static class EventCounter {
        private int mEventCounter;
        private int mFastEventCounter;

        /* JADX INFO: renamed from: -$$Nest$mdump, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4142$$Nest$mdump(EventCounter r0, PrintWriter r1) {
            r0.dump(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mincrease, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4143$$Nest$mincrease(EventCounter r0, long r1, long r3) {
            r0.increase(r1, r3);
        }

        /* synthetic */ EventCounter(PluginEventStorageIA r1) {
            this();
        }

        private EventCounter() {
            this.mEventCounter = 0;
            this.mFastEventCounter = 0;
        }

        private void increase(long timestamp, long previousTimestamp) {
            this.mEventCounter++;
            if ((timestamp - previousTimestamp) >= 500) goto L6;
            this.mFastEventCounter++;
            return;
        }

        private void dump(PrintWriter pw) {
            pw.append("Count:").append(String.valueOf(this.mEventCounter)).append("; Fast:").append(String.valueOf(this.mFastEventCounter));
        }
    }

    static class TimeFrame {
        private final Map<PluginType<?>, EventCounter> mCounters;
        private final long mEnd;
        private final long mStart;

        /* synthetic */ TimeFrame(long r1, long r3, Map r5, PluginEventStorageIA r6) {
            this(r1, r3, r5);
        }

        /* synthetic */ TimeFrame(PluginEventStorageIA r1) {
            this();
        }

        private TimeFrame() {
            this(0, 0, Map.of());
        }

        private TimeFrame(long start, long end, Map<PluginType<?>, EventCounter> counters) {
            this.mStart = start;
            this.mEnd = end;
            this.mCounters = new HashMap(counters);
        }

        void dump(PrintWriter pw) {
            pw.append("TimeFrame:[").append(PluginEventStorage.m4141$$Nest$sfgetsDateFormat().format(new Date(this.mStart))).append(" - ").append(PluginEventStorage.m4141$$Nest$sfgetsDateFormat().format(new Date(this.mEnd))).println("]:");
            IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "    ");
            if (this.mCounters.isEmpty() == false) goto L5;
            ipw.println("NO EVENTS");
            return;
        L5:
            Iterator<Map.Entry<PluginType<?>, EventCounter>> r1 = this.mCounters.entrySet().iterator();
        L7:
            if (r1.hasNext() == false) goto L11;
            Map.Entry<PluginType<?>, EventCounter> entry = r1.next();
            ipw.append(entry.getKey().mName).append(" -> {");
            EventCounter.m4142$$Nest$mdump(entry.getValue(), ipw);
            ipw.println("}");
            goto L7
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$g-ur3r5bXUmhjeSEVRG2XcfrL-0, reason: not valid java name */
    public static /* synthetic */ TimeFrame m4140$r8$lambda$gur3r5bXUmhjeSEVRG2XcfrL0() {
        return new TimeFrame(null);
    }

    public static /* synthetic */ TimeFrame[] $r8$lambda$q0WELSZlIUwnm3Ijsgi3PBSm79k(int r0) {
        return lambda$new$0(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsDateFormat, reason: not valid java name */
    static /* bridge */ /* synthetic */ SimpleDateFormat m4141$$Nest$sfgetsDateFormat() {
        return sDateFormat;
    }

    PluginEventStorage() {
        this.mEvents = new RingBuffer(new PluginEventStorage$$ExternalSyntheticLambda0(), new PluginEventStorage$$ExternalSyntheticLambda1(), 10);
        this.mEventTimes = new HashMap();
        this.mTimeFrameStart = 0;
        this.mCounters = new HashMap();
    }

    static {
        sDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
    }

    private static /* synthetic */ TimeFrame[] lambda$new$0(int x$0) {
        return new TimeFrame[x$0];
    }

    <T> void onValueUpdated(PluginType<T> type) {
        long eventTime = System.currentTimeMillis();
        if ((eventTime - 60000) <= this.mTimeFrameStart) goto L5;
        closeCurrentTimeFrame();
        this.mTimeFrameStart = eventTime;
    L5:
        updateCurrentTimeFrame(type, eventTime);
    }

    private void closeCurrentTimeFrame() {
        if (this.mCounters.isEmpty() == true) goto L6;
        this.mEvents.append(new TimeFrame(this.mTimeFrameStart, this.mTimeFrameStart + 60000, this.mCounters, null));
        this.mCounters.clear();
        return;
    }

    private <T> void updateCurrentTimeFrame(PluginType<T> type, long eventTime) {
        EventCounter counter = this.mCounters.get(type);
        long previousTimestamp = this.mEventTimes.getOrDefault(type, 0L).longValue();
        if (counter != null) goto L5;
        counter = new EventCounter(null);
        this.mCounters.put(type, counter);
    L5:
        EventCounter.m4143$$Nest$mincrease(counter, eventTime, previousTimestamp);
        this.mEventTimes.put(type, Long.valueOf(eventTime));
    }

    List<TimeFrame> getTimeFrames() {
        List<TimeFrame> timeFrames = new ArrayList(Arrays.stream((TimeFrame[]) this.mEvents.toArray()).toList());
        timeFrames.add(new TimeFrame(this.mTimeFrameStart, System.currentTimeMillis(), this.mCounters, null));
        return timeFrames;
    }
}
