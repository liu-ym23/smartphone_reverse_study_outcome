package ig;

import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c implements TemporalAccessor {
    public c() {
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r10) {
        return range(r10).checkValidIntValue(getLong(r10), r10);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public Object query(TemporalQuery r10) {
        if (r10 != org.threeten.bp.temporal.b.g()) goto L5;
        return null;
    L5:
        if (r10 != org.threeten.bp.temporal.b.a()) goto L7;
        return null;
    L7:
        if (r10 != org.threeten.bp.temporal.b.e()) goto L10;
        return null;
    L10:
        return r10.queryFrom(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L11;
        if (isSupported(r10) == false) goto L9;
        return r10.range();
    L9:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    L11:
        return r10.rangeRefinedBy(this);
    }
}
