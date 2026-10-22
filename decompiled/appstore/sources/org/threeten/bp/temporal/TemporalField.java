package org.threeten.bp.temporal;

import java.util.Locale;
import java.util.Map;
import org.threeten.bp.format.ResolverStyle;

/* JADX INFO: loaded from: classes4.dex */
public interface TemporalField {
    <R extends Temporal> R adjustInto(R r10, long r11);

    TemporalUnit getBaseUnit();

    String getDisplayName(Locale r10);

    long getFrom(TemporalAccessor r10);

    TemporalUnit getRangeUnit();

    boolean isDateBased();

    boolean isSupportedBy(TemporalAccessor r10);

    boolean isTimeBased();

    ValueRange range();

    ValueRange rangeRefinedBy(TemporalAccessor r10);

    TemporalAccessor resolve(Map<TemporalField, Long> r10, TemporalAccessor r11, ResolverStyle r12);
}
