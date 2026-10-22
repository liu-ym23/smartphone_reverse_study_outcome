package org.threeten.bp.temporal;

import org.threeten.bp.Duration;

/* JADX INFO: loaded from: classes4.dex */
public interface TemporalUnit {
    <R extends Temporal> R addTo(R r10, long r11);

    long between(Temporal r10, Temporal r11);

    Duration getDuration();

    boolean isDateBased();

    boolean isDurationEstimated();

    boolean isSupportedBy(Temporal r10);

    boolean isTimeBased();

    String toString();
}
