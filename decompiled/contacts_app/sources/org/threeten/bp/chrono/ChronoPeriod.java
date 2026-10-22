package org.threeten.bp.chrono;

import java.util.Iterator;
import java.util.List;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalUnit;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ChronoPeriod implements TemporalAmount {
    @Override // org.threeten.bp.temporal.TemporalAmount
    public abstract Temporal addTo(Temporal r1);

    public abstract boolean equals(Object r1);

    @Override // org.threeten.bp.temporal.TemporalAmount
    public abstract long get(TemporalUnit r1);

    public abstract Chronology getChronology();

    @Override // org.threeten.bp.temporal.TemporalAmount
    public abstract List<TemporalUnit> getUnits();

    public abstract int hashCode();

    public abstract ChronoPeriod minus(TemporalAmount r1);

    public abstract ChronoPeriod multipliedBy(int r1);

    public abstract ChronoPeriod normalized();

    public abstract ChronoPeriod plus(TemporalAmount r1);

    @Override // org.threeten.bp.temporal.TemporalAmount
    public abstract Temporal subtractFrom(Temporal r1);

    public abstract String toString();

    public ChronoPeriod() {
    }

    public static ChronoPeriod between(ChronoLocalDate r1, ChronoLocalDate r2) {
        Jdk8Methods.requireNonNull(r1, "startDateInclusive");
        Jdk8Methods.requireNonNull(r2, "endDateExclusive");
        return r1.until(r2);
    }

    public boolean isZero() {
        Iterator<TemporalUnit> r0 = getUnits().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (get(r0.next()) == 0) goto L4;
        return false;
    L9:
        return true;
    }

    public boolean isNegative() {
        Iterator<TemporalUnit> r0 = getUnits().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (get(r0.next()) >= 0) goto L4;
        return true;
    L9:
        return false;
    }

    public ChronoPeriod negated() {
        return multipliedBy(-1);
    }
}
