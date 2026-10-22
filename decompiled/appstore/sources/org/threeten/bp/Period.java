package org.threeten.bp;

import ig.d;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.chrono.c;
import org.threeten.bp.chrono.e;
import org.threeten.bp.format.DateTimeParseException;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* JADX INFO: loaded from: classes4.dex */
public final class Period extends c implements Serializable {
    private static final Pattern PATTERN = null;
    public static final Period ZERO = null;
    private static final long serialVersionUID = -8290556941213247973L;
    private final int days;
    private final int months;
    private final int years;

    static {
        ZERO = new Period(0, 0, 0);
        PATTERN = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
    }

    private Period(int r10, int r11, int r12) {
        this.years = r10;
        this.months = r11;
        this.days = r12;
    }

    public static Period between(LocalDate r10, LocalDate r11) {
        return r10.until(r11);
    }

    private static Period create(int r10, int r11, int r12) {
        if (((r10 | r11) | r12) != 0) goto L7;
        return ZERO;
    L7:
        return new Period(r10, r11, r12);
    }

    public static Period from(TemporalAmount r10) {
        if ((r10 instanceof Period) == false) goto L7;
        return (Period) r10;
    L7:
        if ((r10 instanceof c) == true) goto L9;
    L13:
        d.h(r10, "amount");
        Iterator<TemporalUnit> r11 = r10.getUnits().iterator();
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
    L15:
        if (r11.hasNext() == false) goto L28;
        TemporalUnit r15 = r11.next();
        long r16 = r10.get(r15);
        if (r15 == ChronoUnit.YEARS) goto L18;
        if (r15 == ChronoUnit.MONTHS) goto L21;
        if (r15 != ChronoUnit.DAYS) goto L26;
        r14 = d.p(r16);
        goto L15
    L26:
        throw new DateTimeException("Unit must be Years, Months or Days, but was " + r15);
    L21:
        r13 = d.p(r16);
        goto L15
    L18:
        r12 = d.p(r16);
        goto L15
    L28:
        return create(r12, r13, r14);
    L9:
        if (IsoChronology.INSTANCE.equals(((c) r10).getChronology()) == true) goto L13;
        throw new DateTimeException("Period requires ISO chronology: " + r10);
    }

    public static Period of(int r10, int r11, int r12) {
        return create(r10, r11, r12);
    }

    public static Period ofDays(int r10) {
        return create(0, 0, r10);
    }

    public static Period ofMonths(int r10) {
        return create(0, r10, 0);
    }

    public static Period ofWeeks(int r10) {
        return create(0, 0, d.k(r10, 7));
    }

    public static Period ofYears(int r10) {
        return create(r10, 0, 0);
    }

    public static Period parse(CharSequence r10) {
        d.h(r10, "text");
        Matcher r11 = PATTERN.matcher(r10);
        if (r11.matches() == false) goto L18;
        int r12 = 1;
        if ("-".equals(r11.group(1)) == false) goto L7;
        r12 = -1;
    L7:
        String r13 = r11.group(2);
        String r14 = r11.group(3);
        String r15 = r11.group(4);
        String r16 = r11.group(5);
        if (r13 != null) goto L19;
        if (r14 != null) goto L19;
        if (r15 != null) goto L19;
        if (r16 == null) goto L18;
    L19:
        int r17 = parseNumber(r10, r13, r12);     // Catch: NumberFormatException -> L14
        int r18 = parseNumber(r10, r14, r12);     // Catch: NumberFormatException -> L14
        int r19 = parseNumber(r10, r15, r12);     // Catch: NumberFormatException -> L14
        return create(r17, r18, d.i(parseNumber(r10, r16, r12), d.k(r19, 7)));
    L14:
        e = move-exception;
        throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Period", r10, 0).initCause(e));
    L18:
        throw new DateTimeParseException("Text cannot be parsed to a Period", r10, 0);
    }

    private static int parseNumber(CharSequence r10, String r11, int r12) {
        if (r11 != null) goto L11;
        return 0;
    L11:
        return d.k(Integer.parseInt(r11), r12);
    L8:
        e = move-exception;
        throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Period", r10, 0).initCause(e));
    }

    private Object readResolve() {
        if (((this.years | this.months) | this.days) == 0) goto L5;
        return this;
    L5:
        return ZERO;
    }

    @Override // org.threeten.bp.temporal.TemporalAmount
    public Temporal addTo(Temporal r10) {
        d.h(r10, "temporal");
        int r11 = this.years;
        if (r11 != 0) goto L5;
        int r12 = this.months;
        if (r12 == 0) goto L11;
        r10 = r10.plus(r12, ChronoUnit.MONTHS);
    L11:
        int r13 = this.days;
        if (r13 != 0) goto L14;
        return r10;
    L14:
        return r10.plus(r13, ChronoUnit.DAYS);
    L5:
        if (this.months == 0) goto L7;
        r10 = r10.plus(toTotalMonths(), ChronoUnit.MONTHS);
        goto L11
    L7:
        r10 = r10.plus(r11, ChronoUnit.YEARS);
        goto L11
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof Period) == false) goto L16;
        Period r11 = (Period) r10;
        if (this.years != r11.years) goto L15;
        if (this.months != r11.months) goto L15;
        if (this.days != r11.days) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    @Override // org.threeten.bp.chrono.c, org.threeten.bp.temporal.TemporalAmount
    public long get(TemporalUnit r10) {
        if (r10 != ChronoUnit.YEARS) goto L8;
        int r11 = this.years;
    L6:
        return r11;
    L8:
        if (r10 != ChronoUnit.MONTHS) goto L11;
        r11 = this.months;
        goto L6
    L11:
        if (r10 != ChronoUnit.DAYS) goto L14;
        r11 = this.days;
        goto L6
    L14:
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + r10);
    }

    @Override // org.threeten.bp.chrono.c
    public e getChronology() {
        return IsoChronology.INSTANCE;
    }

    public int getDays() {
        return this.days;
    }

    public int getMonths() {
        return this.months;
    }

    @Override // org.threeten.bp.chrono.c, org.threeten.bp.temporal.TemporalAmount
    public List<TemporalUnit> getUnits() {
        return Collections.unmodifiableList(Arrays.asList(new ChronoUnit[]{ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS}));
    }

    public int getYears() {
        return this.years;
    }

    public int hashCode() {
        return (this.years + Integer.rotateLeft(this.months, 8)) + Integer.rotateLeft(this.days, 16);
    }

    @Override // org.threeten.bp.chrono.c
    public boolean isNegative() {
        if (this.years >= 0) goto L5;
    L10:
        return true;
    L5:
        if (this.months < 0) goto L10;
        if (this.days < 0) goto L10;
        return false;
    }

    @Override // org.threeten.bp.chrono.c
    public boolean isZero() {
        if (this != ZERO) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: minus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ c m63minus(TemporalAmount r10) {
        return minus(r10);
    }

    public Period minusDays(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        Period this = plusDays(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusDays(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public Period minusMonths(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        Period this = plusMonths(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusMonths(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public Period minusYears(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        Period this = plusYears(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusYears(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    @Override // org.threeten.bp.chrono.c
    public /* bridge */ /* synthetic */ c multipliedBy(int r10) {
        return multipliedBy(r10);
    }

    @Override // org.threeten.bp.chrono.c
    public /* bridge */ /* synthetic */ c negated() {
        return negated();
    }

    /* JADX INFO: renamed from: normalized, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ c m64normalized() {
        return normalized();
    }

    /* JADX INFO: renamed from: plus, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ c m65plus(TemporalAmount r10) {
        return plus(r10);
    }

    public Period plusDays(long r10) {
        if (r10 != 0) goto L6;
        return this;
    L6:
        return create(this.years, this.months, d.p(d.j(this.days, r10)));
    }

    public Period plusMonths(long r10) {
        if (r10 != 0) goto L6;
        return this;
    L6:
        return create(this.years, d.p(d.j(this.months, r10)), this.days);
    }

    public Period plusYears(long r10) {
        if (r10 != 0) goto L6;
        return this;
    L6:
        return create(d.p(d.j(this.years, r10)), this.months, this.days);
    }

    @Override // org.threeten.bp.temporal.TemporalAmount
    public Temporal subtractFrom(Temporal r10) {
        d.h(r10, "temporal");
        int r11 = this.years;
        if (r11 != 0) goto L5;
        int r12 = this.months;
        if (r12 == 0) goto L11;
        r10 = r10.minus(r12, ChronoUnit.MONTHS);
    L11:
        int r13 = this.days;
        if (r13 != 0) goto L14;
        return r10;
    L14:
        return r10.minus(r13, ChronoUnit.DAYS);
    L5:
        if (this.months == 0) goto L7;
        r10 = r10.minus(toTotalMonths(), ChronoUnit.MONTHS);
        goto L11
    L7:
        r10 = r10.minus(r11, ChronoUnit.YEARS);
        goto L11
    }

    public String toString() {
        if (this != ZERO) goto L6;
        return "P0D";
    L6:
        StringBuilder r10 = new StringBuilder();
        r10.append('P');
        int r11 = this.years;
        if (r11 == 0) goto L9;
        r10.append(r11);
        r10.append('Y');
    L9:
        int r12 = this.months;
        if (r12 == 0) goto L12;
        r10.append(r12);
        r10.append('M');
    L12:
        int r13 = this.days;
        if (r13 == 0) goto L16;
        r10.append(r13);
        r10.append('D');
    L16:
        return r10.toString();
    }

    public long toTotalMonths() {
        return (((long) this.years) * 12) + ((long) this.months);
    }

    public Period withDays(int r10) {
        if (r10 != this.days) goto L6;
        return this;
    L6:
        return create(this.years, this.months, r10);
    }

    public Period withMonths(int r10) {
        if (r10 != this.months) goto L6;
        return this;
    L6:
        return create(this.years, r10, this.days);
    }

    public Period withYears(int r10) {
        if (r10 != this.years) goto L6;
        return this;
    L6:
        return create(r10, this.months, this.days);
    }

    public Period minus(TemporalAmount r10) {
        Period r11 = from(r10);
        return create(d.n(this.years, r11.years), d.n(this.months, r11.months), d.n(this.days, r11.days));
    }

    @Override // org.threeten.bp.chrono.c
    public Period multipliedBy(int r10) {
        if (this != ZERO) goto L5;
        return this;
    L5:
        if (r10 != 1) goto L8;
        return this;
    L8:
        return create(d.k(this.years, r10), d.k(this.months, r10), d.k(this.days, r10));
    }

    @Override // org.threeten.bp.chrono.c
    public Period negated() {
        return multipliedBy(-1);
    }

    public Period normalized() {
        long r10 = toTotalMonths();
        long r11 = r10 / 12;
        int r12 = (int) (r10 % 12);
        if (r11 != this.years) goto L8;
        if (r12 != this.months) goto L8;
        return this;
    L8:
        return create(d.p(r11), r12, this.days);
    }

    public Period plus(TemporalAmount r10) {
        Period r11 = from(r10);
        return create(d.i(this.years, r11.years), d.i(this.months, r11.months), d.i(this.days, r11.days));
    }
}
