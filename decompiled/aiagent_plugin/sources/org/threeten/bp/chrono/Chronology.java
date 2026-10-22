package org.threeten.bp.chrono;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Chronology implements Comparable<Chronology> {
    private static final ConcurrentHashMap<String, Chronology> CHRONOS_BY_ID = null;
    private static final ConcurrentHashMap<String, Chronology> CHRONOS_BY_TYPE = null;
    public static final TemporalQuery<Chronology> FROM = null;
    private static final Method LOCALE_METHOD = null;

    public abstract ChronoLocalDate date(int r1, int r2, int r3);

    public abstract ChronoLocalDate date(TemporalAccessor r1);

    public abstract ChronoLocalDate dateEpochDay(long r1);

    public abstract ChronoLocalDate dateYearDay(int r1, int r2);

    public abstract Era eraOf(int r1);

    public abstract List<Era> eras();

    public abstract String getCalendarType();

    public abstract String getId();

    public abstract boolean isLeapYear(long r1);

    public abstract int prolepticYear(Era r1, int r2);

    public abstract ValueRange range(ChronoField r1);

    public abstract ChronoLocalDate resolveDate(Map<TemporalField, Long> r1, ResolverStyle r2);

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Chronology r3) {
        return compareTo2((Chronology) ZeusTransformUtils.preCheckCast(r3, Chronology.class, "com.obric.aiagent.plugin"));
    }

    static {
        FROM = new AnonymousClass1();
        CHRONOS_BY_ID = new ConcurrentHashMap();
        CHRONOS_BY_TYPE = new ConcurrentHashMap();
        Method r0 = Locale.class.getMethod("getUnicodeLocaleType", new Class[]{String.class});     // Catch: Throwable -> L5
    L6:
        LOCALE_METHOD = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    public static Chronology from(TemporalAccessor r2) {
        TemporalAccessor r3 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r2, TemporalAccessor.class, "com.obric.aiagent.plugin");
        Jdk8Methods.requireNonNull(r3, "temporal");
        Chronology r4 = (Chronology) ZeusTransformUtils.preCheckCast(r3.query(TemporalQueries.chronology()), Chronology.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        return r4;
    L6:
        return IsoChronology.INSTANCE;
    }

    public static Chronology ofLocale(Locale r6) {
        init();
        Jdk8Methods.requireNonNull(r6, "locale");
        Method r0 = LOCALE_METHOD;
        if (r0 == null) goto L8;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r0.invoke(r6, new Object[]{"ca"}), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
    L11:
        if (r7 == null) goto L23;
        if ("iso".equals(r7) == true) goto L23;
        if ("iso8601".equals(r7) == true) goto L23;
        Chronology r1 = (Chronology) ZeusTransformUtils.preCheckCast(CHRONOS_BY_TYPE.get(r7), Chronology.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L21;
        return r1;
    L21:
        throw new DateTimeException("Unknown calendar system: " + r7);
    L23:
        return IsoChronology.INSTANCE;
    L10:
        r7 = "iso";
        goto L11
    L8:
        if (r6.equals(JapaneseChronology.LOCALE) == false) goto L10;
        r7 = "japanese";
        goto L11
    }

    public static Chronology of(String r3) {
        init();
        Chronology r1 = (Chronology) ZeusTransformUtils.preCheckCast(CHRONOS_BY_ID.get(r3), Chronology.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        Chronology r0 = (Chronology) ZeusTransformUtils.preCheckCast(CHRONOS_BY_TYPE.get(r3), Chronology.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L9;
        return r0;
    L9:
        throw new DateTimeException("Unknown chronology: " + r3);
    }

    public static Set<Chronology> getAvailableChronologies() {
        init();
        return new HashSet(CHRONOS_BY_ID.values());
    }

    private static void init() {
        ConcurrentHashMap<String, Chronology> r1 = CHRONOS_BY_ID;
        if (r1.isEmpty() == false) goto L10;
        register(IsoChronology.INSTANCE);
        register(ThaiBuddhistChronology.INSTANCE);
        register(MinguoChronology.INSTANCE);
        register(JapaneseChronology.INSTANCE);
        register(HijrahChronology.INSTANCE);
        r1.putIfAbsent("Hijrah", HijrahChronology.INSTANCE);
        CHRONOS_BY_TYPE.putIfAbsent("islamic", HijrahChronology.INSTANCE);
        Iterator r2 = ServiceLoader.load(Chronology.class, Chronology.class.getClassLoader()).iterator();
    L6:
        if (r2.hasNext() == false) goto L16;
        Chronology r3 = (Chronology) ZeusTransformUtils.preCheckCast(r2.next(), Chronology.class, "com.obric.aiagent.plugin");
        CHRONOS_BY_ID.putIfAbsent(r3.getId(), r3);
        String r4 = r3.getCalendarType();
        if (r4 == null) goto L6;
        CHRONOS_BY_TYPE.putIfAbsent(r4, r3);
        goto L6
    L16:
        return;
    }

    private static void register(Chronology r2) {
        CHRONOS_BY_ID.putIfAbsent(r2.getId(), r2);
        String r0 = r2.getCalendarType();
        if (r0 == null) goto L6;
        CHRONOS_BY_TYPE.putIfAbsent(r0, r2);
        return;
    }

    public Chronology() {
    }

    <D extends ChronoLocalDate> D ensureChronoLocalDate(Temporal r4) {
        D r5 = (D) ZeusTransformUtils.preCheckCast((Temporal) ZeusTransformUtils.wrapperContextForParams(r4, Temporal.class, "com.obric.aiagent.plugin"), ChronoLocalDate.class, "com.obric.aiagent.plugin");
        if (equals(r5.getChronology()) == false) goto L6;
        return r5;
    L6:
        throw new ClassCastException("Chrono mismatch, expected: " + getId() + ", actual: " + r5.getChronology().getId());
    }

    <D extends ChronoLocalDate> ChronoLocalDateTimeImpl<D> ensureChronoLocalDateTime(Temporal r4) {
        ChronoLocalDateTimeImpl<D> r5 = (ChronoLocalDateTimeImpl) ZeusTransformUtils.preCheckCast((Temporal) ZeusTransformUtils.wrapperContextForParams(r4, Temporal.class, "com.obric.aiagent.plugin"), ChronoLocalDateTimeImpl.class, "com.obric.aiagent.plugin");
        if (equals(r5.toLocalDate().getChronology()) == false) goto L6;
        return r5;
    L6:
        throw new ClassCastException("Chrono mismatch, required: " + getId() + ", supplied: " + r5.toLocalDate().getChronology().getId());
    }

    <D extends ChronoLocalDate> ChronoZonedDateTimeImpl<D> ensureChronoZonedDateTime(Temporal r4) {
        ChronoZonedDateTimeImpl<D> r5 = (ChronoZonedDateTimeImpl) ZeusTransformUtils.preCheckCast((Temporal) ZeusTransformUtils.wrapperContextForParams(r4, Temporal.class, "com.obric.aiagent.plugin"), ChronoZonedDateTimeImpl.class, "com.obric.aiagent.plugin");
        if (equals(r5.toLocalDate().getChronology()) == false) goto L6;
        return r5;
    L6:
        throw new ClassCastException("Chrono mismatch, required: " + getId() + ", supplied: " + r5.toLocalDate().getChronology().getId());
    }

    public ChronoLocalDate date(Era r3, int r4, int r5, int r6) {
        return date(prolepticYear((Era) ZeusTransformUtils.wrapperContextForParams(r3, Era.class, "com.obric.aiagent.plugin"), r4), r5, r6);
    }

    public ChronoLocalDate dateYearDay(Era r3, int r4, int r5) {
        return dateYearDay(prolepticYear((Era) ZeusTransformUtils.wrapperContextForParams(r3, Era.class, "com.obric.aiagent.plugin"), r4), r5);
    }

    public ChronoLocalDate dateNow() {
        return dateNow(Clock.systemDefaultZone());
    }

    public ChronoLocalDate dateNow(ZoneId r1) {
        return dateNow(Clock.system(r1));
    }

    public ChronoLocalDate dateNow(Clock r2) {
        Jdk8Methods.requireNonNull(r2, "clock");
        return date(LocalDate.now(r2));
    }

    public ChronoLocalDateTime<?> localDateTime(TemporalAccessor r4) {
        TemporalAccessor r5 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r4, TemporalAccessor.class, "com.obric.aiagent.plugin");
        return date(r5).atTime(LocalTime.from(r5));
    L5:
        e = move-exception;
        throw new DateTimeException("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + r5.getClass(), e);
    }

    public ChronoZonedDateTime<?> zonedDateTime(TemporalAccessor r4) {
        TemporalAccessor r5 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r4, TemporalAccessor.class, "com.obric.aiagent.plugin");
        ZoneId r0 = ZoneId.from(r5);     // Catch: DateTimeException -> L8
        return zonedDateTime(Instant.from(r5), r0);
    L7:
        return ChronoZonedDateTimeImpl.ofBest(ensureChronoLocalDateTime(localDateTime(r5)), r0, null);
    L8:
        e = move-exception;
        throw new DateTimeException("Unable to obtain ChronoZonedDateTime from TemporalAccessor: " + r5.getClass(), e);
    }

    public ChronoZonedDateTime<?> zonedDateTime(Instant r1, ZoneId r2) {
        return ChronoZonedDateTimeImpl.ofInstant(this, r1, r2);
    }

    public ChronoPeriod period(int r2, int r3, int r4) {
        return new ChronoPeriodImpl(this, r2, r3, r4);
    }

    public String getDisplayName(TextStyle r2, Locale r3) {
        return new DateTimeFormatterBuilder().appendChronologyText(r2).toFormatter(r3).format(new AnonymousClass2(this));
    }

    void updateResolveMap(Map<TemporalField, Long> r3, ChronoField r4, long r5) {
        Map r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        Long r6 = (Long) ZeusTransformUtils.preCheckCast(r2.get(r4), Long.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
    L9:
        r2.put(r4, Long.valueOf(r5));
        return;
    L5:
        if (r6.longValue() == r5) goto L9;
        throw new DateTimeException("Invalid state, field: " + r4 + " " + r6 + " conflicts with " + r4 + " " + r5);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Chronology r1) {
        return getId().compareTo(r1.getId());
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Chronology.class) == true) goto L8;
        return false;
    L8:
        if (compareTo2((Chronology) ZeusTransformUtils.preCheckCast(r5, Chronology.class, "com.obric.aiagent.plugin")) != 0) goto L11;
        return true;
    L11:
        return false;
    }

    public int hashCode() {
        int r0 = getClass().hashCode();
        return getId().hashCode() ^ r0;
    }

    public String toString() {
        return getId();
    }

    private Object writeReplace() {
        return new Ser((byte) 11, this);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    void writeExternal(DataOutput r3) {
        ((DataOutput) ZeusTransformUtils.wrapperContextForParams(r3, DataOutput.class, "com.obric.aiagent.plugin")).writeUTF(getId());
    }

    static Chronology readExternal(DataInput r2) {
        return of(((DataInput) ZeusTransformUtils.wrapperContextForParams(r2, DataInput.class, "com.obric.aiagent.plugin")).readUTF());
    }
}
