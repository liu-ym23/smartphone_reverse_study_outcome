package org.threeten.bp.jdk8;

import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DefaultInterfaceTemporalAccessor implements TemporalAccessor {
    public DefaultInterfaceTemporalAccessor() {
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r3) {
        if ((r3 instanceof ChronoField) == false) goto L11;
        if (isSupported(r3) == false) goto L9;
        return r3.range();
    L9:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r3);
    L11:
        return r3.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r4) {
        return range(r4).checkValidIntValue(getLong(r4), r4);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r2) {
        if (r2 != TemporalQueries.zoneId()) goto L5;
        return null;
    L5:
        if (r2 != TemporalQueries.chronology()) goto L7;
        return null;
    L7:
        if (r2 != TemporalQueries.precision()) goto L10;
        return null;
    L10:
        return r2.queryFrom(this);
    }
}
