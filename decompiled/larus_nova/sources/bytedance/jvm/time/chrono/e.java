package bytedance.jvm.time.chrono;

import bytedance.jvm.time.LocalTime;
import bytedance.jvm.time.ZoneId;
import bytedance.jvm.time.ZoneOffset;
import bytedance.jvm.time.chrono.c;
import bytedance.jvm.time.temporal.m;

/* JADX INFO: loaded from: classes28.dex */
public interface e<D extends c> extends bytedance.jvm.time.temporal.b, bytedance.jvm.time.temporal.e, Comparable<e<?>> {
    h<D> atZone(ZoneId r100);

    int compareTo(e<?> r100);

    j getChronology();

    int hashCode();

    @Override // bytedance.jvm.time.temporal.b
    e<D> minus(long r100, m r101);

    e<D> minus(bytedance.jvm.time.temporal.i r100);

    e<D> plus(bytedance.jvm.time.temporal.i r100);

    @Override // bytedance.jvm.time.temporal.b, bytedance.jvm.time.temporal.d
    <R> R query(bytedance.jvm.time.temporal.l<R> r100);

    long toEpochSecond(ZoneOffset r100);

    D toLocalDate();

    LocalTime toLocalTime();

    String toString();
}
