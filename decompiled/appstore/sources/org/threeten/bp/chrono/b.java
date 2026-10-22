package org.threeten.bp.chrono;

import java.util.Comparator;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b extends ig.b implements Temporal, TemporalAdjuster, Comparable {
    private static final Comparator<b> DATE_TIME_COMPARATOR = null;

    public static class a implements Comparator {
        public a() {
        }

        public int a(b r10, b r11) {
            int r12 = ig.d.b(r10.toLocalDate().toEpochDay(), r11.toLocalDate().toEpochDay());
            if (r12 == 0) goto L5;
            return r12;
        L5:
            return ig.d.b(r10.toLocalTime().toNanoOfDay(), r11.toLocalTime().toNanoOfDay());
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((b) r10, (b) r11);
        }
    }

    static {
        DATE_TIME_COMPARATOR = new a();
    }

    public b() {
    }

    public static b from(TemporalAccessor r10) {
        ig.d.h(r10, "temporal");
        if ((r10 instanceof b) == true) goto L5;
        e r11 = (e) r10.query(org.threeten.bp.temporal.b.a());
        if (r11 == null) goto L11;
        return r11.localDateTime(r10);
    L11:
        throw new DateTimeException("No Chronology found to create ChronoLocalDateTime: " + r10.getClass());
    L5:
        return (b) r10;
    }

    public static Comparator<b> timeLineOrder() {
        return DATE_TIME_COMPARATOR;
    }

    public Temporal adjustInto(Temporal r10) {
        return r10.with(ChronoField.EPOCH_DAY, toLocalDate().toEpochDay()).with(ChronoField.NANO_OF_DAY, toLocalTime().toNanoOfDay());
    }

    public abstract d atZone(ZoneId r10);

    public /* bridge */ /* synthetic */ int compareTo(Object r10) {
        return compareTo((b) r10);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof b) == true) goto L8;
        return false;
    L8:
        if (compareTo((b) r10) != 0) goto L11;
        return true;
    L11:
        return false;
    }

    public String format(DateTimeFormatter r10) {
        ig.d.h(r10, "formatter");
        return r10.d(this);
    }

    public e getChronology() {
        return toLocalDate().getChronology();
    }

    public int hashCode() {
        int r10 = toLocalDate().hashCode();
        return toLocalTime().hashCode() ^ r10;
    }

    public boolean isAfter(b r10) {
        long r11 = toLocalDate().toEpochDay();
        long r12 = r10.toLocalDate().toEpochDay();
        if (r11 > r12) goto L9;
        if (r11 == r12) goto L6;
    L8:
        return false;
    L6:
        if (toLocalTime().toNanoOfDay() <= r10.toLocalTime().toNanoOfDay()) goto L8;
    L9:
        return true;
    }

    public boolean isBefore(b r10) {
        long r11 = toLocalDate().toEpochDay();
        long r12 = r10.toLocalDate().toEpochDay();
        if (r11 < r12) goto L9;
        if (r11 == r12) goto L6;
    L8:
        return false;
    L6:
        if (toLocalTime().toNanoOfDay() >= r10.toLocalTime().toNanoOfDay()) goto L8;
    L9:
        return true;
    }

    public boolean isEqual(b r10) {
        if (toLocalTime().toNanoOfDay() == r10.toLocalTime().toNanoOfDay()) goto L5;
    L7:
        return false;
    L5:
        if (toLocalDate().toEpochDay() != r10.toLocalDate().toEpochDay()) goto L7;
        return true;
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(long r10, TemporalUnit r11) {
        return minus(r10, r11);
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(TemporalAmount r10) {
        return plus(r10);
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r10) {
        if (r10 != org.threeten.bp.temporal.b.a()) goto L7;
        return (R) getChronology();
    L7:
        if (r10 != org.threeten.bp.temporal.b.e()) goto L11;
        return (R) ChronoUnit.NANOS;
    L11:
        if (r10 != org.threeten.bp.temporal.b.b()) goto L15;
        return (R) LocalDate.ofEpochDay(toLocalDate().toEpochDay());
    L15:
        if (r10 != org.threeten.bp.temporal.b.c()) goto L19;
        return (R) toLocalTime();
    L19:
        if (r10 != org.threeten.bp.temporal.b.f()) goto L21;
        return null;
    L21:
        if (r10 != org.threeten.bp.temporal.b.g()) goto L23;
        return null;
    L23:
        if (r10 != org.threeten.bp.temporal.b.d()) goto L26;
        return null;
    L26:
        return (R) super.query(r10);
    }

    public long toEpochSecond(ZoneOffset r10) {
        ig.d.h(r10, "offset");
        return ((toLocalDate().toEpochDay() * 86400) + ((long) toLocalTime().toSecondOfDay())) - ((long) r10.getTotalSeconds());
    }

    public Instant toInstant(ZoneOffset r10) {
        return Instant.ofEpochSecond(toEpochSecond(r10), toLocalTime().getNano());
    }

    public abstract org.threeten.bp.chrono.a toLocalDate();

    public abstract LocalTime toLocalTime();

    public String toString() {
        return toLocalDate().toString() + 'T' + toLocalTime().toString();
    }

    public int compareTo(b r10) {
        int r11 = toLocalDate().compareTo(r10.toLocalDate());
        if (r11 != 0) goto L8;
        int r12 = toLocalTime().compareTo2(r10.toLocalTime());
        if (r12 == 0) goto L7;
        return r12;
    L7:
        return getChronology().compareTo(r10.getChronology());
    L8:
        return r11;
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(TemporalAmount r10) {
        return minus(r10);
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public b plus(TemporalAmount r10) {
        return toLocalDate().getChronology().ensureChronoLocalDateTime(super.plus(r10));
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public b minus(TemporalAmount r10) {
        return toLocalDate().getChronology().ensureChronoLocalDateTime(super.minus(r10));
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public b minus(long r10, TemporalUnit r11) {
        return toLocalDate().getChronology().ensureChronoLocalDateTime(super.minus(r10, r11));
    }
}
