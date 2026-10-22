package org.threeten.bp.temporal;

/* JADX INFO: loaded from: classes4.dex */
public interface TemporalAccessor {
    int get(TemporalField r10);

    long getLong(TemporalField r10);

    boolean isSupported(TemporalField r10);

    <R> R query(TemporalQuery<R> r10);

    ValueRange range(TemporalField r10);
}
