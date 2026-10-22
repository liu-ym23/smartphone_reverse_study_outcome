package org.threeten.bp.chrono;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
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
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e implements Comparable {
    private static final ConcurrentHashMap<String, e> CHRONOS_BY_ID = null;
    private static final ConcurrentHashMap<String, e> CHRONOS_BY_TYPE = null;
    public static final TemporalQuery<e> FROM = null;
    private static final Method LOCALE_METHOD = null;

    public static class a implements TemporalQuery {
        public a() {
        }

        public e a(TemporalAccessor r10) {
            return e.from(r10);
        }

        @Override // org.threeten.bp.temporal.TemporalQuery
        public /* bridge */ /* synthetic */ Object queryFrom(TemporalAccessor r10) {
            return a(r10);
        }
    }

    public class b extends ig.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f23097a;

        public b(e r10) {
            this.f23097a = r10;
        }

        @Override // org.threeten.bp.temporal.TemporalAccessor
        public long getLong(TemporalField r10) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
        }

        @Override // org.threeten.bp.temporal.TemporalAccessor
        public boolean isSupported(TemporalField r10) {
            return false;
        }

        @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
        public Object query(TemporalQuery r10) {
            if (r10 != org.threeten.bp.temporal.b.a()) goto L7;
            return this.f23097a;
        L7:
            return super.query(r10);
        }
    }

    static {
        FROM = new a();
        CHRONOS_BY_ID = new ConcurrentHashMap();
        CHRONOS_BY_TYPE = new ConcurrentHashMap();
        Method r10 = Locale.class.getMethod("getUnicodeLocaleType", new Class[]{String.class});     // Catch: Throwable -> L5
    L6:
        LOCALE_METHOD = r10;
        return;
    L5:
        r10 = null;
        goto L6
    }

    public e() {
    }

    public static void a() {
        ConcurrentHashMap<String, e> r10 = CHRONOS_BY_ID;
        if (r10.isEmpty() == false) goto L10;
        b(IsoChronology.INSTANCE);
        b(ThaiBuddhistChronology.INSTANCE);
        b(MinguoChronology.INSTANCE);
        b(JapaneseChronology.INSTANCE);
        HijrahChronology r11 = HijrahChronology.INSTANCE;
        b(r11);
        r10.putIfAbsent("Hijrah", r11);
        CHRONOS_BY_TYPE.putIfAbsent("islamic", r11);
        Iterator r12 = ServiceLoader.load(e.class, e.class.getClassLoader()).iterator();
    L6:
        if (r12.hasNext() == false) goto L16;
        e r13 = (e) r12.next();
        CHRONOS_BY_ID.putIfAbsent(r13.getId(), r13);
        String r14 = r13.getCalendarType();
        if (r14 == null) goto L6;
        CHRONOS_BY_TYPE.putIfAbsent(r14, r13);
        goto L6
    L16:
        return;
    }

    public static void b(e r10) {
        CHRONOS_BY_ID.putIfAbsent(r10.getId(), r10);
        String r11 = r10.getCalendarType();
        if (r11 == null) goto L6;
        CHRONOS_BY_TYPE.putIfAbsent(r11, r10);
        return;
    }

    public static e from(TemporalAccessor r10) {
        ig.d.h(r10, "temporal");
        e r11 = (e) r10.query(org.threeten.bp.temporal.b.a());
        if (r11 == null) goto L6;
        return r11;
    L6:
        return IsoChronology.INSTANCE;
    }

    public static Set<e> getAvailableChronologies() {
        a();
        return new HashSet(CHRONOS_BY_ID.values());
    }

    public static e of(String r10) {
        a();
        e r11 = CHRONOS_BY_ID.get(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        e r12 = CHRONOS_BY_TYPE.get(r10);
        if (r12 == null) goto L9;
        return r12;
    L9:
        throw new DateTimeException("Unknown chronology: " + r10);
    }

    public static e ofLocale(Locale r10) {
        a();
        ig.d.h(r10, "locale");
        Method r11 = LOCALE_METHOD;
        if (r11 == null) goto L7;
        String r12 = (String) r11.invoke(r10, new Object[]{"ca"});     // Catch: Throwable -> L23
    L10:
        if (r12 == null) goto L22;
        if ("iso".equals(r12) == true) goto L22;
        if ("iso8601".equals(r12) == true) goto L22;
        e r13 = CHRONOS_BY_TYPE.get(r12);
        if (r13 == null) goto L20;
        return r13;
    L20:
        throw new DateTimeException("Unknown calendar system: " + r12);
    L22:
        return IsoChronology.INSTANCE;
    L9:
        r12 = "iso";
        goto L10
    L7:
        if (r10.equals(JapaneseChronology.LOCALE) == false) goto L9;
        r12 = "japanese";
        goto L10
    }

    public static e readExternal(DataInput r10) throws IOException {
        return of(r10.readUTF());
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r10) {
        return compareTo((e) r10);
    }

    public abstract org.threeten.bp.chrono.a date(int r10, int r11, int r12);

    public org.threeten.bp.chrono.a date(Era r10, int r11, int r12, int r13) {
        return date(prolepticYear(r10, r11), r12, r13);
    }

    public abstract org.threeten.bp.chrono.a date(TemporalAccessor r10);

    public abstract org.threeten.bp.chrono.a dateEpochDay(long r10);

    public org.threeten.bp.chrono.a dateNow() {
        return dateNow(Clock.systemDefaultZone());
    }

    public abstract org.threeten.bp.chrono.a dateYearDay(int r10, int r11);

    public org.threeten.bp.chrono.a dateYearDay(Era r10, int r11, int r12) {
        return dateYearDay(prolepticYear(r10, r11), r12);
    }

    public <D extends org.threeten.bp.chrono.a> D ensureChronoLocalDate(Temporal r10) {
        D r11 = (D) r10;
        if (equals(r11.getChronology()) == false) goto L6;
        return r11;
    L6:
        throw new ClassCastException("Chrono mismatch, expected: " + getId() + ", actual: " + r11.getChronology().getId());
    }

    public <D extends org.threeten.bp.chrono.a> ChronoLocalDateTimeImpl<D> ensureChronoLocalDateTime(Temporal r10) {
        ChronoLocalDateTimeImpl<D> r11 = (ChronoLocalDateTimeImpl) r10;
        if (equals(r11.toLocalDate().getChronology()) == false) goto L6;
        return r11;
    L6:
        throw new ClassCastException("Chrono mismatch, required: " + getId() + ", supplied: " + r11.toLocalDate().getChronology().getId());
    }

    public <D extends org.threeten.bp.chrono.a> ChronoZonedDateTimeImpl<D> ensureChronoZonedDateTime(Temporal r10) {
        ChronoZonedDateTimeImpl<D> r11 = (ChronoZonedDateTimeImpl) r10;
        if (equals(r11.toLocalDate().getChronology()) == false) goto L6;
        return r11;
    L6:
        throw new ClassCastException("Chrono mismatch, required: " + getId() + ", supplied: " + r11.toLocalDate().getChronology().getId());
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof e) == true) goto L8;
        return false;
    L8:
        if (compareTo((e) r10) != 0) goto L11;
        return true;
    L11:
        return false;
    }

    public abstract Era eraOf(int r10);

    public abstract String getCalendarType();

    public String getDisplayName(TextStyle r10, Locale r11) {
        return new DateTimeFormatterBuilder().b(r10).F(r11).d(new b(this));
    }

    public abstract String getId();

    public int hashCode() {
        int r10 = getClass().hashCode();
        return getId().hashCode() ^ r10;
    }

    public abstract boolean isLeapYear(long r10);

    public org.threeten.bp.chrono.b localDateTime(TemporalAccessor r10) {
        return date(r10).atTime(LocalTime.from(r10));
    L4:
        e = move-exception;
        throw new DateTimeException("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + r10.getClass(), e);
    }

    public c period(int r10, int r11, int r12) {
        return new ChronoPeriodImpl(this, r10, r11, r12);
    }

    public abstract int prolepticYear(Era r10, int r11);

    public abstract ValueRange range(ChronoField r10);

    public String toString() {
        return getId();
    }

    public void updateResolveMap(Map<TemporalField, Long> r10, ChronoField r11, long r12) {
        Long r13 = r10.get(r11);
        if (r13 != null) goto L5;
    L9:
        r10.put(r11, Long.valueOf(r12));
        return;
    L5:
        if (r13.longValue() == r12) goto L9;
        throw new DateTimeException("Invalid state, field: " + r11 + " " + r13 + " conflicts with " + r11 + " " + r12);
    }

    public void writeExternal(DataOutput r10) throws IOException {
        r10.writeUTF(getId());
    }

    public d zonedDateTime(TemporalAccessor r10) {
        ZoneId r11 = ZoneId.from(r10);     // Catch: DateTimeException -> L7
        return zonedDateTime(Instant.from(r10), r11);
    L6:
        return ChronoZonedDateTimeImpl.ofBest(ensureChronoLocalDateTime(localDateTime(r10)), r11, null);
    L7:
        e = move-exception;
        throw new DateTimeException("Unable to obtain ChronoZonedDateTime from TemporalAccessor: " + r10.getClass(), e);
    }

    public int compareTo(e r10) {
        return getId().compareTo(r10.getId());
    }

    public org.threeten.bp.chrono.a dateNow(ZoneId r10) {
        return dateNow(Clock.system(r10));
    }

    public org.threeten.bp.chrono.a dateNow(Clock r10) {
        ig.d.h(r10, "clock");
        return date(LocalDate.now(r10));
    }

    public d zonedDateTime(Instant r10, ZoneId r11) {
        return ChronoZonedDateTimeImpl.ofInstant(this, r10, r11);
    }
}
