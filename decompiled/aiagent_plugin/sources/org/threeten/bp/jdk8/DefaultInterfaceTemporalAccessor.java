package org.threeten.bp.jdk8;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.threeten.bp.ZoneId;
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
        TemporalField r4 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r3, TemporalField.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ChronoField.class) == false) goto L11;
        if (isSupported(r4) == false) goto L9;
        return r4.range();
    L9:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r4);
    L11:
        return r4.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public int get(TemporalField r4) {
        TemporalField r5 = (TemporalField) ZeusTransformUtils.wrapperContextForParams(r4, TemporalField.class, "com.obric.aiagent.plugin");
        return range(r5).checkValidIntValue(getLong(r5), r5);
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public <R> R query(TemporalQuery<R> r3) {
        TemporalQuery<ZoneId> r4 = (TemporalQuery) ZeusTransformUtils.wrapperContextForParams(r3, TemporalQuery.class, "com.obric.aiagent.plugin");
        if (r4 != TemporalQueries.zoneId()) goto L5;
        return null;
    L5:
        if (r4 != TemporalQueries.chronology()) goto L7;
        return null;
    L7:
        if (r4 != TemporalQueries.precision()) goto L10;
        return null;
    L10:
        return (R) r4.queryFrom(this);
    }
}
