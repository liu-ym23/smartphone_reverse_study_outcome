package org.threeten.bp.temporal;

/* JADX INFO: loaded from: classes4.dex */
public interface Temporal extends TemporalAccessor {
    boolean isSupported(TemporalUnit r10);

    Temporal minus(long r10, TemporalUnit r11);

    Temporal minus(TemporalAmount r10);

    Temporal plus(long r10, TemporalUnit r11);

    Temporal plus(TemporalAmount r10);

    long until(Temporal r10, TemporalUnit r11);

    Temporal with(TemporalAdjuster r10);

    Temporal with(TemporalField r10, long r11);
}
