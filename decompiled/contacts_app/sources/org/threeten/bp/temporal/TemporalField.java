package org.threeten.bp.temporal;

import java.util.Locale;
import java.util.Map;
import org.threeten.bp.format.ResolverStyle;

/* JADX INFO: loaded from: classes5.dex */
public interface TemporalField {
    <R extends Temporal> R adjustInto(R r1, long r2);

    TemporalUnit getBaseUnit();

    String getDisplayName(Locale r1);

    long getFrom(TemporalAccessor r1);

    TemporalUnit getRangeUnit();

    boolean isDateBased();

    boolean isSupportedBy(TemporalAccessor r1);

    boolean isTimeBased();

    ValueRange range();

    ValueRange rangeRefinedBy(TemporalAccessor r1);

    TemporalAccessor resolve(Map<TemporalField, Long> r1, TemporalAccessor r2, ResolverStyle r3);
}
