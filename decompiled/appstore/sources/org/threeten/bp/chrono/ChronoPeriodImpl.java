package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.http.message.TokenParser;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* JADX INFO: loaded from: classes4.dex */
final class ChronoPeriodImpl extends c implements Serializable {
    private static final long serialVersionUID = 275618735781L;
    private final e chronology;
    private final int days;
    private final int months;
    private final int years;

    public ChronoPeriodImpl(e r10, int r11, int r12, int r13) {
        this.chronology = r10;
        this.years = r11;
        this.months = r12;
        this.days = r13;
    }

    @Override // org.threeten.bp.temporal.TemporalAmount
    public Temporal addTo(Temporal r10) {
        ig.d.h(r10, "temporal");
        e r11 = (e) r10.query(org.threeten.bp.temporal.b.a());
        if (r11 != null) goto L5;
    L9:
        int r12 = this.years;
        if (r12 == 0) goto L12;
        r10 = r10.plus(r12, ChronoUnit.YEARS);
    L12:
        int r13 = this.months;
        if (r13 == 0) goto L15;
        r10 = r10.plus(r13, ChronoUnit.MONTHS);
    L15:
        int r14 = this.days;
        if (r14 != 0) goto L18;
        return r10;
    L18:
        return r10.plus(r14, ChronoUnit.DAYS);
    L5:
        if (this.chronology.equals(r11) == true) goto L9;
        throw new DateTimeException("Invalid chronology, required: " + this.chronology.getId() + ", but was: " + r11.getId());
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ChronoPeriodImpl) == false) goto L18;
        ChronoPeriodImpl r11 = (ChronoPeriodImpl) r10;
        if (this.years != r11.years) goto L17;
        if (this.months != r11.months) goto L17;
        if (this.days != r11.days) goto L17;
        if (this.chronology.equals(r11.chronology) == false) goto L17;
        return true;
    L17:
        return false;
    L18:
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
        return this.chronology;
    }

    @Override // org.threeten.bp.chrono.c, org.threeten.bp.temporal.TemporalAmount
    public List<TemporalUnit> getUnits() {
        return Collections.unmodifiableList(Arrays.asList(new TemporalUnit[]{ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS}));
    }

    public int hashCode() {
        return ((this.chronology.hashCode() + Integer.rotateLeft(this.years, 16)) + Integer.rotateLeft(this.months, 8)) + this.days;
    }

    public c minus(TemporalAmount r10) {
        if ((r10 instanceof ChronoPeriodImpl) == false) goto L9;
        ChronoPeriodImpl r11 = (ChronoPeriodImpl) r10;
        if (r11.getChronology().equals(getChronology()) == false) goto L9;
        return new ChronoPeriodImpl(this.chronology, ig.d.n(this.years, r11.years), ig.d.n(this.months, r11.months), ig.d.n(this.days, r11.days));
    L9:
        throw new DateTimeException("Unable to subtract amount: " + r10);
    }

    @Override // org.threeten.bp.chrono.c
    public c multipliedBy(int r10) {
        return new ChronoPeriodImpl(this.chronology, ig.d.k(this.years, r10), ig.d.k(this.months, r10), ig.d.k(this.days, r10));
    }

    public c normalized() {
        e r10 = this.chronology;
        ChronoField r11 = ChronoField.MONTH_OF_YEAR;
        if (r10.range(r11).isFixed() == false) goto L6;
        long r12 = (this.chronology.range(r11).getMaximum() - this.chronology.range(r11).getMinimum()) + 1;
        long r13 = (((long) this.years) * r12) + ((long) this.months);
        int r14 = ig.d.p(r13 / r12);
        int r15 = ig.d.p(r13 % r12);
        return new ChronoPeriodImpl(this.chronology, r14, r15, this.days);
    L6:
        return this;
    }

    public c plus(TemporalAmount r10) {
        if ((r10 instanceof ChronoPeriodImpl) == false) goto L9;
        ChronoPeriodImpl r11 = (ChronoPeriodImpl) r10;
        if (r11.getChronology().equals(getChronology()) == false) goto L9;
        return new ChronoPeriodImpl(this.chronology, ig.d.i(this.years, r11.years), ig.d.i(this.months, r11.months), ig.d.i(this.days, r11.days));
    L9:
        throw new DateTimeException("Unable to add amount: " + r10);
    }

    @Override // org.threeten.bp.temporal.TemporalAmount
    public Temporal subtractFrom(Temporal r10) {
        ig.d.h(r10, "temporal");
        e r11 = (e) r10.query(org.threeten.bp.temporal.b.a());
        if (r11 != null) goto L5;
    L9:
        int r12 = this.years;
        if (r12 == 0) goto L12;
        r10 = r10.minus(r12, ChronoUnit.YEARS);
    L12:
        int r13 = this.months;
        if (r13 == 0) goto L15;
        r10 = r10.minus(r13, ChronoUnit.MONTHS);
    L15:
        int r14 = this.days;
        if (r14 != 0) goto L18;
        return r10;
    L18:
        return r10.minus(r14, ChronoUnit.DAYS);
    L5:
        if (this.chronology.equals(r11) == true) goto L9;
        throw new DateTimeException("Invalid chronology, required: " + this.chronology.getId() + ", but was: " + r11.getId());
    }

    public String toString() {
        if (isZero() == true) goto L5;
        StringBuilder r10 = new StringBuilder();
        r10.append(this.chronology);
        r10.append(TokenParser.SP);
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
    L5:
        return this.chronology + " P0D";
    }
}
