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
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d extends ig.b implements Temporal, Comparable {
    private static Comparator<d> INSTANT_COMPARATOR;

    public static class a implements Comparator {
        public a() {
        }

        public int a(d r10, d r11) {
            int r12 = ig.d.b(r10.toEpochSecond(), r11.toEpochSecond());
            if (r12 == 0) goto L5;
            return r12;
        L5:
            return ig.d.b(r10.toLocalTime().toNanoOfDay(), r11.toLocalTime().toNanoOfDay());
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((d) r10, (d) r11);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23096a = null;

        static {
            int[] r10 = new int[ChronoField.values().length];
            f23096a = r10;
            r10[ChronoField.INSTANT_SECONDS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f23096a[ChronoField.OFFSET_SECONDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static {
        INSTANT_COMPARATOR = new a();
    }

    public d() {
    }

    public static d from(TemporalAccessor r10) {
        ig.d.h(r10, "temporal");
        if ((r10 instanceof d) == true) goto L5;
        e r11 = (e) r10.query(org.threeten.bp.temporal.b.a());
        if (r11 == null) goto L11;
        return r11.zonedDateTime(r10);
    L11:
        throw new DateTimeException("No Chronology found to create ChronoZonedDateTime: " + r10.getClass());
    L5:
        return (d) r10;
    }

    public static Comparator<d> timeLineOrder() {
        return INSTANT_COMPARATOR;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r10) {
        return compareTo((d) r10);
    }

    public String format(DateTimeFormatter r10) {
        ig.d.h(r10, "formatter");
        return r10.d(this);
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L15;
        int r11 = b.f23096a[((ChronoField) r10).ordinal()];
        if (r11 == 1) goto L13;
        if (r11 == 2) goto L11;
        return toLocalDateTime().get(r10);
    L11:
        return getOffset().getTotalSeconds();
    L13:
        throw new UnsupportedTemporalTypeException("Field too large for an int: " + r10);
    L15:
        return super.get(r10);
    }

    public e getChronology() {
        return toLocalDate().getChronology();
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L15;
        int r11 = b.f23096a[((ChronoField) r10).ordinal()];
        if (r11 == 1) goto L13;
        if (r11 == 2) goto L11;
        return toLocalDateTime().getLong(r10);
    L11:
        return getOffset().getTotalSeconds();
    L13:
        return toEpochSecond();
    L15:
        return r10.getFrom(this);
    }

    public abstract ZoneOffset getOffset();

    public abstract ZoneId getZone();

    public boolean isAfter(d r10) {
        long r11 = toEpochSecond();
        long r12 = r10.toEpochSecond();
        if (r11 > r12) goto L9;
        if (r11 == r12) goto L6;
    L8:
        return false;
    L6:
        if (toLocalTime().getNano() <= r10.toLocalTime().getNano()) goto L8;
    L9:
        return true;
    }

    public boolean isBefore(d r10) {
        long r11 = toEpochSecond();
        long r12 = r10.toEpochSecond();
        if (r11 < r12) goto L9;
        if (r11 == r12) goto L6;
    L8:
        return false;
    L6:
        if (toLocalTime().getNano() >= r10.toLocalTime().getNano()) goto L8;
    L9:
        return true;
    }

    public boolean isEqual(d r10) {
        if (toEpochSecond() == r10.toEpochSecond()) goto L5;
    L7:
        return false;
    L5:
        if (toLocalTime().getNano() != r10.toLocalTime().getNano()) goto L7;
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
        if (r10 == org.threeten.bp.temporal.b.g()) goto L30;
        if (r10 == org.threeten.bp.temporal.b.f()) goto L30;
        if (r10 != org.threeten.bp.temporal.b.a()) goto L12;
        return (R) toLocalDate().getChronology();
    L12:
        if (r10 != org.threeten.bp.temporal.b.e()) goto L16;
        return (R) ChronoUnit.NANOS;
    L16:
        if (r10 != org.threeten.bp.temporal.b.d()) goto L20;
        return (R) getOffset();
    L20:
        if (r10 != org.threeten.bp.temporal.b.b()) goto L24;
        return (R) LocalDate.ofEpochDay(toLocalDate().toEpochDay());
    L24:
        if (r10 != org.threeten.bp.temporal.b.c()) goto L28;
        return (R) toLocalTime();
    L28:
        return (R) super.query(r10);
    L30:
        return (R) getZone();
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L14;
        if (r10 == ChronoField.INSTANT_SECONDS) goto L12;
        if (r10 == ChronoField.OFFSET_SECONDS) goto L12;
        return toLocalDateTime().range(r10);
    L12:
        return r10.range();
    L14:
        return r10.rangeRefinedBy(this);
    }

    public long toEpochSecond() {
        return ((toLocalDate().toEpochDay() * 86400) + ((long) toLocalTime().toSecondOfDay())) - ((long) getOffset().getTotalSeconds());
    }

    public Instant toInstant() {
        return Instant.ofEpochSecond(toEpochSecond(), toLocalTime().getNano());
    }

    public org.threeten.bp.chrono.a toLocalDate() {
        return toLocalDateTime().toLocalDate();
    }

    public abstract org.threeten.bp.chrono.b toLocalDateTime();

    public LocalTime toLocalTime() {
        return toLocalDateTime().toLocalTime();
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalAdjuster r10) {
        return with(r10);
    }

    public abstract d withZoneSameInstant(ZoneId r10);

    public abstract d withZoneSameLocal(ZoneId r10);

    public int compareTo(d r10) {
        int r11 = ig.d.b(toEpochSecond(), r10.toEpochSecond());
        if (r11 != 0) goto L12;
        int r12 = toLocalTime().getNano() - r10.toLocalTime().getNano();
        if (r12 != 0) goto L13;
        int r13 = toLocalDateTime().compareTo(r10.toLocalDateTime());
        if (r13 != 0) goto L14;
        int r14 = getZone().getId().compareTo(r10.getZone().getId());
        if (r14 == 0) goto L11;
        return r14;
    L11:
        return toLocalDate().getChronology().compareTo(r10.toLocalDate().getChronology());
    L14:
        return r13;
    L13:
        return r12;
    L12:
        return r11;
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(TemporalAmount r10) {
        return minus(r10);
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public d plus(TemporalAmount r10) {
        return toLocalDate().getChronology().ensureChronoZonedDateTime(super.plus(r10));
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public d with(TemporalAdjuster r10) {
        return toLocalDate().getChronology().ensureChronoZonedDateTime(super.with(r10));
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public d minus(TemporalAmount r10) {
        return toLocalDate().getChronology().ensureChronoZonedDateTime(super.minus(r10));
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public d minus(long r10, TemporalUnit r11) {
        return toLocalDate().getChronology().ensureChronoZonedDateTime(super.minus(r10, r11));
    }
}
