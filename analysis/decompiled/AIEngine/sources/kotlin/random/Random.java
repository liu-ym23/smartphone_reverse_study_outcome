package kotlin.random;

import bc.a;
import java.io.Serializable;
import tb.b;
import vb.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class Random {

    /* renamed from: a, reason: collision with root package name */
    public static final Default f10088a = new Default(0);

    /* renamed from: b, reason: collision with root package name */
    public static final a f10089b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Default extends Random implements Serializable {

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static final class Serialized implements Serializable {

            /* renamed from: a, reason: collision with root package name */
            public static final Serialized f10090a = new Serialized();

            private Serialized() {
            }

            private final Object readResolve() {
                return Random.f10088a;
            }
        }

        public /* synthetic */ Default(int i10) {
            this();
        }

        private final Object writeReplace() {
            return Serialized.f10090a;
        }

        @Override // kotlin.random.Random
        public final int a(int i10) {
            return Random.f10089b.a(i10);
        }

        @Override // kotlin.random.Random
        public final int b() {
            return Random.f10089b.b();
        }

        @Override // kotlin.random.Random
        public final long c() {
            return Random.f10089b.c();
        }

        @Override // kotlin.random.Random
        public final long d(long j10, long j11) {
            return Random.f10089b.d(j10, j11);
        }

        private Default() {
        }
    }

    static {
        b.f12958a.getClass();
        Integer num = a.C0157a.f13491a;
        f10089b = (num == null || num.intValue() >= 34) ? new cc.a() : new bc.b();
    }

    public abstract int a(int i10);

    public abstract int b();

    public abstract long c();

    public long d(long j10, long j11) {
        long jC;
        long j12;
        long jA;
        int iB;
        if (j11 <= j10) {
            throw new IllegalArgumentException(("Random range is empty: [" + Long.valueOf(j10) + ", " + Long.valueOf(j11) + ").").toString());
        }
        long j13 = j11 - j10;
        if (j13 > 0) {
            if (((-j13) & j13) == j13) {
                int i10 = (int) j13;
                int i11 = (int) (j13 >>> 32);
                if (i10 != 0) {
                    iB = a(31 - Integer.numberOfLeadingZeros(i10));
                } else if (i11 == 1) {
                    iB = b();
                } else {
                    jA = (a(31 - Integer.numberOfLeadingZeros(i11)) << 32) + (b() & 4294967295L);
                }
                jA = iB & 4294967295L;
            } else {
                do {
                    jC = c() >>> 1;
                    j12 = jC % j13;
                } while ((j13 - 1) + (jC - j12) < 0);
                jA = j12;
            }
            return j10 + jA;
        }
        while (true) {
            long jC2 = c();
            if (j10 <= jC2 && jC2 < j11) {
                return jC2;
            }
        }
    }
}
