package org.threeten.bp.chrono;

import java.util.Iterator;
import java.util.List;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalUnit;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c implements TemporalAmount {
    public c() {
    }

    public static c between(a r10, a r11) {
        ig.d.h(r10, "startDateInclusive");
        ig.d.h(r11, "endDateExclusive");
        return r10.until(r11);
    }

    @Override // org.threeten.bp.temporal.TemporalAmount
    public abstract long get(TemporalUnit r10);

    public abstract e getChronology();

    @Override // org.threeten.bp.temporal.TemporalAmount
    public abstract List getUnits();

    public boolean isNegative() {
        Iterator r10 = getUnits().iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        if (get((TemporalUnit) r10.next()) >= 0) goto L4;
        return true;
    L9:
        return false;
    }

    public boolean isZero() {
        Iterator r10 = getUnits().iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        if (get((TemporalUnit) r10.next()) == 0) goto L4;
        return false;
    L9:
        return true;
    }

    public abstract c multipliedBy(int r10);

    public c negated() {
        return multipliedBy(-1);
    }
}
