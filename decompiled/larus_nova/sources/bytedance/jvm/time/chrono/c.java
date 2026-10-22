package bytedance.jvm.time.chrono;

import bytedance.jvm.time.LocalTime;
import bytedance.jvm.time.temporal.m;

/* JADX INFO: loaded from: classes28.dex */
public interface c extends bytedance.jvm.time.temporal.b, bytedance.jvm.time.temporal.e, Comparable<c> {
    e<?> atTime(LocalTime r100);

    int compareTo(c r100);

    boolean equals(Object r100);

    j getChronology();

    l getEra();

    int hashCode();

    boolean isLeapYear();

    @Override // bytedance.jvm.time.temporal.d
    boolean isSupported(bytedance.jvm.time.temporal.j r100);

    int lengthOfYear();

    @Override // bytedance.jvm.time.temporal.b
    c minus(long r100, m r101);

    @Override // bytedance.jvm.time.temporal.b
    c plus(long r100, m r101);

    c plus(bytedance.jvm.time.temporal.i r100);

    @Override // bytedance.jvm.time.temporal.b, bytedance.jvm.time.temporal.d
    <R> R query(bytedance.jvm.time.temporal.l<R> r100);

    long toEpochDay();

    String toString();

    @Override // bytedance.jvm.time.temporal.b
    long until(bytedance.jvm.time.temporal.b r100, m r101);

    @Override // bytedance.jvm.time.temporal.b
    c with(bytedance.jvm.time.temporal.e r100);

    @Override // bytedance.jvm.time.temporal.b
    c with(bytedance.jvm.time.temporal.j r100, long r101);
}
