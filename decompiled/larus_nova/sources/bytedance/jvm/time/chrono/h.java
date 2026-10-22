package bytedance.jvm.time.chrono;

import bytedance.jvm.time.LocalTime;
import bytedance.jvm.time.ZoneId;
import bytedance.jvm.time.ZoneOffset;
import bytedance.jvm.time.chrono.c;
import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.m;

/* JADX INFO: loaded from: classes28.dex */
public interface h<D extends c> extends bytedance.jvm.time.temporal.b, Comparable<h<?>> {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21573a = null;

        static {
            int[] r100 = new int[ChronoField.values().length];
            f21573a = r100;
            r100[ChronoField.INSTANT_SECONDS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f21573a[ChronoField.OFFSET_SECONDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    int compareTo(h<?> r100);

    j getChronology();

    ZoneOffset getOffset();

    ZoneId getZone();

    @Override // bytedance.jvm.time.temporal.b
    h<D> minus(long r100, m r101);

    h<D> minus(bytedance.jvm.time.temporal.i r100);

    h<D> plus(bytedance.jvm.time.temporal.i r100);

    @Override // bytedance.jvm.time.temporal.b, bytedance.jvm.time.temporal.d
    <R> R query(bytedance.jvm.time.temporal.l<R> r100);

    long toEpochSecond();

    D toLocalDate();

    e<D> toLocalDateTime();

    LocalTime toLocalTime();

    @Override // bytedance.jvm.time.temporal.b
    h<D> with(bytedance.jvm.time.temporal.e r100);

    h<D> withZoneSameInstant(ZoneId r100);

    h<D> withZoneSameLocal(ZoneId r100);
}
