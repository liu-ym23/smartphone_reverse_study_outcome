package com.android.server.people.data;

import android.text.format.DateFormat;
import android.util.Range;
import android.util.Slog;
import android.util.proto.ProtoInputStream;
import android.util.proto.ProtoOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class EventIndex {
    static final EventIndex EMPTY = null;
    private static final int RETENTION_DAYS = 63;
    private static final String TAG = null;
    private static final List<Function<Long, Range<Long>>> TIME_SLOT_FACTORIES = null;
    private static final int TIME_SLOT_FOUR_HOURS = 1;
    private static final int TIME_SLOT_ONE_DAY = 0;
    private static final int TIME_SLOT_ONE_HOUR = 2;
    private static final int TIME_SLOT_TWO_MINUTES = 3;
    private static final int TIME_SLOT_TYPES_COUNT = 4;
    private final long[] mEventBitmaps;
    private final Injector mInjector;
    private long mLastUpdatedTime;
    private final Object mLock;

    static class Injector {
        Injector() {
        }

        long currentTimeMillis() {
            return System.currentTimeMillis();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface TimeSlotType {
    }

    public static /* synthetic */ Range $r8$lambda$GriYeTuXvhUkjv8CQ4Gzo1J72Pc(long r0) {
        return createTwoMinutesLongTimeSlot(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$hXytj2aPq49uZ-ujQ7NyLid7a6w, reason: not valid java name */
    public static /* synthetic */ Range m6558$r8$lambda$hXytj2aPq49uZujQ7NyLid7a6w(long r0) {
        return createFourHoursLongTimeSlot(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$iEVp7Ev80Xr_TY0talTAgD-YoQ0, reason: not valid java name */
    public static /* synthetic */ Range m6559$r8$lambda$iEVp7Ev80Xr_TY0talTAgDYoQ0(long r0) {
        return createOneDayLongTimeSlot(r0);
    }

    public static /* synthetic */ Range $r8$lambda$jtkAExCrZ5GPS6qnqyJMNEoEM4I(long r0) {
        return createOneHourLongTimeSlot(r0);
    }

    static {
        TAG = EventIndex.class.getSimpleName();
        EMPTY = new EventIndex();
        TIME_SLOT_FACTORIES = Collections.unmodifiableList(Arrays.asList(new Function[]{new EventIndex$$ExternalSyntheticLambda0(), new EventIndex$$ExternalSyntheticLambda1(), new EventIndex$$ExternalSyntheticLambda2(), new EventIndex$$ExternalSyntheticLambda3()}));
    }

    static EventIndex combine(EventIndex lhs, EventIndex rhs) {
        if (lhs.mLastUpdatedTime >= rhs.mLastUpdatedTime) goto L5;
        EventIndex older = lhs;
    L7:
        if (lhs.mLastUpdatedTime < rhs.mLastUpdatedTime) goto L9;
        EventIndex younger = lhs;
    L10:
        EventIndex combined = new EventIndex(older);
        combined.updateEventBitmaps(younger.mLastUpdatedTime);
        int slotType = 0;
    L12:
        if (slotType >= 4) goto L15;
        long[] r4 = combined.mEventBitmaps;
        r4[slotType] = r4[slotType] | younger.mEventBitmaps[slotType];
        slotType = slotType + 1;
        goto L12
    L15:
        return combined;
    L9:
        younger = rhs;
        goto L10
    L5:
        older = rhs;
        goto L7
    }

    EventIndex() {
        this(new Injector());
    }

    EventIndex(EventIndex from) {
        this(from.mInjector, from.mEventBitmaps, from.mLastUpdatedTime);
    }

    EventIndex(Injector injector) {
        this(injector, new long[]{0, 0, 0, 0}, injector.currentTimeMillis());
    }

    private EventIndex(Injector injector, long[] eventBitmaps, long lastUpdatedTime) {
        this.mLock = new Object();
        this.mInjector = injector;
        this.mEventBitmaps = Arrays.copyOf(eventBitmaps, 4);
        this.mLastUpdatedTime = lastUpdatedTime;
    }

    public Range<Long> getMostRecentActiveTimeSlot() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int slotType = 3;
    L5:
        if (slotType < 0) goto L15;
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.mEventBitmaps[slotType] != 0) goto L9;
        slotType = slotType - 1;     // Catch: Throwable -> L12
        goto L5
    L9:
        Range<Long> lastTimeSlot = TIME_SLOT_FACTORIES.get(slotType).apply(Long.valueOf(this.mLastUpdatedTime));     // Catch: Throwable -> L12
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(this.mEventBitmaps[slotType]);     // Catch: Throwable -> L12
        long offset = getDuration(lastTimeSlot) * ((long) numberOfTrailingZeros);     // Catch: Throwable -> L12
        Range<Long> r6 = Range.create(Long.valueOf(((Long) lastTimeSlot.getLower()).longValue() - offset), Long.valueOf(((Long) lastTimeSlot.getUpper()).longValue() - offset));     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r6;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return null;
    }

    public List<Range<Long>> getActiveTimeSlots() {
        List<Range<Long>> activeTimeSlots = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        int slotType = 0;
    L6:
        if (slotType >= 4) goto L11;
        activeTimeSlots = combineTimeSlotLists(activeTimeSlots, getActiveTimeSlotsForType(slotType));     // Catch: Throwable -> L8
        slotType = slotType + 1;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L8
        Collections.reverse(activeTimeSlots);
        return activeTimeSlots;
    }

    public boolean isEmpty() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int slotType = 0;
    L6:
        if (slotType >= 4) goto L16;
    L12:
        th = move-exception;
        throw th;
    L8:
        if (this.mEventBitmaps[slotType] != 0) goto L9;
        slotType = slotType + 1;     // Catch: Throwable -> L12
        goto L6
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    }

    void addEvent(long eventTime) {
        if (EMPTY == this) goto L21;
        Object r0 = this.mLock;
        monitor-enter(r0);
        long currentTime = this.mInjector.currentTimeMillis();     // Catch: Throwable -> L12
        updateEventBitmaps(currentTime);     // Catch: Throwable -> L12
        int slotType = 0;
    L8:
        if (slotType >= 4) goto L16;
        int offset = diffTimeSlots(slotType, eventTime, currentTime);     // Catch: Throwable -> L12
        if (offset >= 64) goto L14;
        long[] r5 = this.mEventBitmaps;     // Catch: Throwable -> L12
        r5[slotType] = r5[slotType] | (1 << offset);     // Catch: Throwable -> L12
    L14:
        slotType = slotType + 1;     // Catch: Throwable -> L12
        goto L8
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L21:
        throw new IllegalStateException("EMPTY instance is immutable");
    }

    void update() {
        updateEventBitmaps(this.mInjector.currentTimeMillis());
    }

    public String toString() {
        return "EventIndex {perDayEventBitmap=0b" + Long.toBinaryString(this.mEventBitmaps[0]) + ", perFourHoursEventBitmap=0b" + Long.toBinaryString(this.mEventBitmaps[1]) + ", perHourEventBitmap=0b" + Long.toBinaryString(this.mEventBitmaps[2]) + ", perTwoMinutesEventBitmap=0b" + Long.toBinaryString(this.mEventBitmaps[3]) + ", lastUpdatedTime=" + DateFormat.format("yyyy-MM-dd HH:mm:ss", this.mLastUpdatedTime) + "}";
    }

    public boolean equals(Object obj) {
        if (this != obj) goto L6;
        return true;
    L6:
        if ((obj instanceof EventIndex) == true) goto L8;
        return false;
    L8:
        EventIndex other = (EventIndex) obj;
        if (this.mLastUpdatedTime != other.mLastUpdatedTime) goto L14;
        if (Arrays.equals(this.mEventBitmaps, other.mEventBitmaps) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Long.valueOf(this.mLastUpdatedTime), Integer.valueOf(Arrays.hashCode(this.mEventBitmaps))});
    }

    synchronized void writeToProto(ProtoOutputStream protoOutputStream) {
        monitor-enter(this);
        long[] r0 = this.mEventBitmaps;     // Catch: Throwable -> L6
        int r1 = r0.length;     // Catch: Throwable -> L6
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L8;
        long bitmap = r0[r2];     // Catch: Throwable -> L6
        protoOutputStream.write(2211908157441L, bitmap);     // Catch: Throwable -> L6
        r2 = r2 + 1;     // Catch: Throwable -> L6
        goto L4
    L8:
        protoOutputStream.write(1112396529666L, this.mLastUpdatedTime);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void updateEventBitmaps(long currentTimeMillis) {
        int slotType = 0;
    L4:
        if (slotType >= 4) goto L10;
        int offset = diffTimeSlots(slotType, this.mLastUpdatedTime, currentTimeMillis);
        if (offset >= 64) goto L8;
        long[] r2 = this.mEventBitmaps;
        r2[slotType] = r2[slotType] << offset;
    L9:
        slotType = slotType + 1;
        goto L4
    L8:
        this.mEventBitmaps[slotType] = 0;
        goto L9
    L10:
        long[] r1 = this.mEventBitmaps;
        r1[0] = r1[0] << 1;
        long[] r3 = this.mEventBitmaps;
        r3[0] = r3[0] >>> 1;
        this.mLastUpdatedTime = currentTimeMillis;
    }

    static EventIndex readFromProto(ProtoInputStream protoInputStream) throws IOException {
        int bitmapIndex = 0;
        long[] eventBitmaps = new long[4];
        long lastUpdated = 0;
    L4:
        if (protoInputStream.nextField() == (-1)) goto L11;
        switch(protoInputStream.getFieldNumber()) {
            case 1: goto L9;
            case 2: goto L8;
            default: goto L7;
        };
    L8:
        lastUpdated = protoInputStream.readLong(1112396529666L);
        goto L4
    L9:
        eventBitmaps[bitmapIndex] = protoInputStream.readLong(2211908157441L);
        bitmapIndex = bitmapIndex + 1;
        goto L4
    L7:
        Slog.e(TAG, "Could not read undefined field: " + protoInputStream.getFieldNumber());
        goto L4
    L11:
        return new EventIndex(new Injector(), eventBitmaps, lastUpdated);
    }

    private static LocalDateTime toLocalDateTime(long epochMilli) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(epochMilli), TimeZone.getDefault().toZoneId());
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.time.ZonedDateTime] */
    private static long toEpochMilli(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    private static long getDuration(Range<Long> timeSlot) {
        return ((Long) timeSlot.getUpper()).longValue() - ((Long) timeSlot.getLower()).longValue();
    }

    private static int diffTimeSlots(int timeSlotType, long fromTime, long toTime) {
        Function<Long, Range<Long>> timeSlotFactory = TIME_SLOT_FACTORIES.get(timeSlotType);
        Range<Long> fromSlot = timeSlotFactory.apply(Long.valueOf(fromTime));
        Range<Long> toSlot = timeSlotFactory.apply(Long.valueOf(toTime));
        return (int) ((((Long) toSlot.getLower()).longValue() - ((Long) fromSlot.getLower()).longValue()) / getDuration(fromSlot));
    }

    private List<Range<Long>> getActiveTimeSlotsForType(int timeSlotType) {
        long eventBitmap = this.mEventBitmaps[timeSlotType];
        Range<Long> latestTimeSlot = TIME_SLOT_FACTORIES.get(timeSlotType).apply(Long.valueOf(this.mLastUpdatedTime));
        long startTime = ((Long) latestTimeSlot.getLower()).longValue();
        long duration = getDuration(latestTimeSlot);
        List<Range<Long>> timeSlots = new ArrayList();
    L4:
        if (eventBitmap == 0) goto L12;
        int trailingZeros = Long.numberOfTrailingZeros(eventBitmap);
        if (trailingZeros <= 0) goto L9;
        startTime = startTime - (((long) trailingZeros) * duration);
        eventBitmap = eventBitmap >>> trailingZeros;
    L9:
        if (eventBitmap == 0) goto L4;
        timeSlots.add(Range.create(Long.valueOf(startTime), Long.valueOf(startTime + duration)));
        startTime = startTime - duration;
        eventBitmap = eventBitmap >>> 1;
        goto L4
    L12:
        return timeSlots;
    }

    private static List<Range<Long>> combineTimeSlotLists(List<Range<Long>> longerSlots, List<Range<Long>> shorterSlots) {
        List<Range<Long>> result = new ArrayList();
        int i = 0;
        int j = 0;
    L4:
        if (i >= longerSlots.size()) goto L16;
        if (j >= shorterSlots.size()) goto L16;
        Range<Long> longerSlot = longerSlots.get(i);
        Range<Long> shorterSlot = shorterSlots.get(j);
        if (longerSlot.contains(shorterSlot) == true) goto L9;
        if (((Long) longerSlot.getLower()).longValue() < ((Long) shorterSlot.getLower()).longValue()) goto L12;
        result.add(longerSlot);
        i = i + 1;
        goto L4
    L12:
        result.add(shorterSlot);
        j = j + 1;
        goto L4
    L9:
        result.add(shorterSlot);
        i = i + 1;
        j = j + 1;
    L16:
        if (i >= longerSlots.size()) goto L19;
        result.addAll(longerSlots.subList(i, longerSlots.size()));
    L21:
        return result;
    L19:
        if (j >= shorterSlots.size()) goto L21;
        result.addAll(shorterSlots.subList(j, shorterSlots.size()));
        goto L21
    }

    private static Range<Long> createOneDayLongTimeSlot(long time) {
        LocalDateTime beginTime = toLocalDateTime(time).truncatedTo(ChronoUnit.DAYS);
        return Range.create(Long.valueOf(toEpochMilli(beginTime)), Long.valueOf(toEpochMilli(beginTime.plusDays(1))));
    }

    private static Range<Long> createFourHoursLongTimeSlot(long time) {
        int hourOfDay = toLocalDateTime(time).getHour();
        LocalDateTime beginTime = toLocalDateTime(time).truncatedTo(ChronoUnit.HOURS).minusHours(hourOfDay % 4);
        return Range.create(Long.valueOf(toEpochMilli(beginTime)), Long.valueOf(toEpochMilli(beginTime.plusHours(4))));
    }

    private static Range<Long> createOneHourLongTimeSlot(long time) {
        LocalDateTime beginTime = toLocalDateTime(time).truncatedTo(ChronoUnit.HOURS);
        return Range.create(Long.valueOf(toEpochMilli(beginTime)), Long.valueOf(toEpochMilli(beginTime.plusHours(1))));
    }

    private static Range<Long> createTwoMinutesLongTimeSlot(long time) {
        int minuteOfHour = toLocalDateTime(time).getMinute();
        LocalDateTime beginTime = toLocalDateTime(time).truncatedTo(ChronoUnit.MINUTES).minusMinutes(minuteOfHour % 2);
        return Range.create(Long.valueOf(toEpochMilli(beginTime)), Long.valueOf(toEpochMilli(beginTime.plusMinutes(2))));
    }
}
