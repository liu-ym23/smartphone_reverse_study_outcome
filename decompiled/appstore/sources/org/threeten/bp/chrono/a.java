package org.threeten.bp.chrono;

import java.util.Comparator;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
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

/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends ig.b implements Temporal, TemporalAdjuster, Comparable {
    private static final Comparator<a> DATE_COMPARATOR = null;

    /* JADX INFO: renamed from: org.threeten.bp.chrono.a$a, reason: collision with other inner class name */
    public static class C0332a implements Comparator {
        public C0332a() {
        }

        public int a(a r10, a r11) {
            return ig.d.b(r10.toEpochDay(), r11.toEpochDay());
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((a) r10, (a) r11);
        }
    }

    static {
        DATE_COMPARATOR = new C0332a();
    }

    public a() {
    }

    public static a from(TemporalAccessor r10) {
        ig.d.h(r10, "temporal");
        if ((r10 instanceof a) == true) goto L5;
        e r11 = (e) r10.query(org.threeten.bp.temporal.b.a());
        if (r11 == null) goto L11;
        return r11.date(r10);
    L11:
        throw new DateTimeException("No Chronology found to create ChronoLocalDate: " + r10.getClass());
    L5:
        return (a) r10;
    }

    public static Comparator<a> timeLineOrder() {
        return DATE_COMPARATOR;
    }

    public Temporal adjustInto(Temporal r10) {
        return r10.with(ChronoField.EPOCH_DAY, toEpochDay());
    }

    public abstract b atTime(LocalTime r10);

    public /* bridge */ /* synthetic */ int compareTo(Object r10) {
        return compareTo((a) r10);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof a) == true) goto L8;
        return false;
    L8:
        if (compareTo((a) r10) != 0) goto L11;
        return true;
    L11:
        return false;
    }

    public String format(DateTimeFormatter r10) {
        ig.d.h(r10, "formatter");
        return r10.d(this);
    }

    public abstract e getChronology();

    public Era getEra() {
        return getChronology().eraOf(get(ChronoField.ERA));
    }

    public int hashCode() {
        long r10 = toEpochDay();
        return getChronology().hashCode() ^ ((int) (r10 ^ (r10 >>> 32)));
    }

    public boolean isAfter(a r10) {
        if (toEpochDay() <= r10.toEpochDay()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBefore(a r10) {
        if (toEpochDay() >= r10.toEpochDay()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isEqual(a r10) {
        if (toEpochDay() != r10.toEpochDay()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLeapYear() {
        return getChronology().isLeapYear(getLong(ChronoField.YEAR));
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public boolean isSupported(TemporalField r10) {
        if ((r10 instanceof ChronoField) == true) goto L5;
        if (r10 != null) goto L8;
    L10:
        return false;
    L8:
        if (r10.isSupportedBy(this) == false) goto L10;
        return true;
    L5:
        return r10.isDateBased();
    }

    public abstract int lengthOfMonth();

    public int lengthOfYear() {
        if (isLeapYear() == false) goto L5;
        return 366;
    L5:
        return 365;
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(long r10, TemporalUnit r11) {
        return minus(r10, r11);
    }

    public abstract a plus(long r10, TemporalUnit r11);

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
        return (R) ChronoUnit.DAYS;
    L11:
        if (r10 != org.threeten.bp.temporal.b.b()) goto L15;
        return (R) LocalDate.ofEpochDay(toEpochDay());
    L15:
        if (r10 != org.threeten.bp.temporal.b.c()) goto L17;
        return null;
    L17:
        if (r10 != org.threeten.bp.temporal.b.f()) goto L19;
        return null;
    L19:
        if (r10 != org.threeten.bp.temporal.b.g()) goto L21;
        return null;
    L21:
        if (r10 != org.threeten.bp.temporal.b.d()) goto L24;
        return null;
    L24:
        return (R) super.query(r10);
    }

    public long toEpochDay() {
        return getLong(ChronoField.EPOCH_DAY);
    }

    public String toString() {
        long r10 = getLong(ChronoField.YEAR_OF_ERA);
        long r11 = getLong(ChronoField.MONTH_OF_YEAR);
        long r12 = getLong(ChronoField.DAY_OF_MONTH);
        StringBuilder r13 = new StringBuilder(30);
        r13.append(getChronology().toString());
        r13.append(" ");
        r13.append(getEra());
        r13.append(" ");
        r13.append(r10);
        String r14 = "-";
        if (r11 >= 10) goto L5;
        String r15 = "-0";
    L6:
        r13.append(r15);
        r13.append(r11);
        if (r12 >= 10) goto L9;
        r14 = "-0";
    L9:
        r13.append(r14);
        r13.append(r12);
        return r13.toString();
    L5:
        r15 = "-";
        goto L6
    }

    public abstract c until(a r10);

    public abstract a with(TemporalField r10, long r11);

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalAdjuster r10) {
        return with(r10);
    }

    public int compareTo(a r10) {
        int r11 = ig.d.b(toEpochDay(), r10.toEpochDay());
        if (r11 == 0) goto L5;
        return r11;
    L5:
        return getChronology().compareTo(r10.getChronology());
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(TemporalAmount r10) {
        return minus(r10);
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public a plus(TemporalAmount r10) {
        return getChronology().ensureChronoLocalDate(super.plus(r10));
    }

    public /* bridge */ /* synthetic */ Temporal with(TemporalField r10, long r11) {
        return with(r10, r11);
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public a minus(TemporalAmount r10) {
        return getChronology().ensureChronoLocalDate(super.minus(r10));
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public a with(TemporalAdjuster r10) {
        return getChronology().ensureChronoLocalDate(super.with(r10));
    }

    @Override // org.threeten.bp.temporal.Temporal
    public boolean isSupported(TemporalUnit r10) {
        if ((r10 instanceof ChronoUnit) == true) goto L5;
        if (r10 != null) goto L8;
    L10:
        return false;
    L8:
        if (r10.isSupportedBy(this) == false) goto L10;
        return true;
    L5:
        return r10.isDateBased();
    }

    @Override // ig.b, org.threeten.bp.temporal.Temporal
    public a minus(long r10, TemporalUnit r11) {
        return getChronology().ensureChronoLocalDate(super.minus(r10, r11));
    }
}
