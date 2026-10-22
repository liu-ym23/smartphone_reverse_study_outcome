package kotlin.random;

import com.autonavi.aps.amapapi.config.Const;
import i9.C4179b;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import t9.C5526c;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\n\b'\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lkotlin/random/Random;", "", "<init>", "()V", "", "bitCount", Const.INTENT_KEY_PKGNAME, "(I)I", "f", "()I", "until", Const.INTENT_KEY_BACKGROUND_COMMAND, "from", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(II)I", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()J", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(J)J", "k", "(JJ)J", "", "e", "()F", "", "array", "fromIndex", "toIndex", Const.INTENT_KEY_UMID, "([BII)[B", "c", "([B)[B", Const.INTENT_KEY_APIKEY, "Default", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class Random {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    public static final Random f34842b = C4179b.f33080a.b();

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001.B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\r\u001a\u00020\f2\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0012J\u001f\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b&\u0010'J'\u0010*\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000fH\u0016¢\u0006\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "<init>", "()V", "", "writeReplace", "()Ljava/lang/Object;", "Ljava/io/ObjectInputStream;", "Lkotlin/internal/ReadObjectParameterType;", "input", "LY8/t;", "readObject", "(Ljava/io/ObjectInputStream;)V", "", "bitCount", Const.INTENT_KEY_PKGNAME, "(I)I", "f", "()I", "until", Const.INTENT_KEY_BACKGROUND_COMMAND, "from", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(II)I", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()J", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(J)J", "k", "(JJ)J", "", "e", "()F", "", "array", "c", "([B)[B", "fromIndex", "toIndex", Const.INTENT_KEY_UMID, "([BII)[B", "defaultRandom", "Lkotlin/random/Random;", "Serialized", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: kotlin.random.Random$Default, reason: from kotlin metadata */
    public static final class Companion extends Random implements Serializable {

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/random/Random$Default$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "<init>", "()V", "", "readResolve", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: kotlin.random.Random$Default$Serialized */
        public static final class Serialized implements Serializable {

            /* renamed from: a, reason: collision with root package name */
            public static final Serialized f34843a = new Serialized();

            private Serialized() {
            }

            private final Object readResolve() {
                return Random.INSTANCE;
            }
        }

        public /* synthetic */ Companion(i iVar) {
            this();
        }

        private final void readObject(ObjectInputStream input) throws InvalidObjectException {
            throw new InvalidObjectException("Deserialization is supported via proxy only");
        }

        private final Object writeReplace() {
            return Serialized.f34843a;
        }

        @Override // kotlin.random.Random
        public int b(int bitCount) {
            return Random.f34842b.b(bitCount);
        }

        @Override // kotlin.random.Random
        public byte[] c(byte[] array) {
            p.i(array, "array");
            return Random.f34842b.c(array);
        }

        @Override // kotlin.random.Random
        public byte[] d(byte[] array, int fromIndex, int toIndex) {
            p.i(array, "array");
            return Random.f34842b.d(array, fromIndex, toIndex);
        }

        @Override // kotlin.random.Random
        public float e() {
            return Random.f34842b.e();
        }

        @Override // kotlin.random.Random
        public int f() {
            return Random.f34842b.f();
        }

        @Override // kotlin.random.Random
        public int g(int until) {
            return Random.f34842b.g(until);
        }

        @Override // kotlin.random.Random
        public int h(int from, int until) {
            return Random.f34842b.h(from, until);
        }

        @Override // kotlin.random.Random
        public long i() {
            return Random.f34842b.i();
        }

        @Override // kotlin.random.Random
        public long j(long until) {
            return Random.f34842b.j(until);
        }

        @Override // kotlin.random.Random
        public long k(long from, long until) {
            return Random.f34842b.k(from, until);
        }

        private Companion() {
        }
    }

    public abstract int b(int bitCount);

    public byte[] c(byte[] array) {
        p.i(array, "array");
        return d(array, 0, array.length);
    }

    public byte[] d(byte[] array, int fromIndex, int toIndex) {
        p.i(array, "array");
        if (fromIndex < 0 || fromIndex > array.length || toIndex < 0 || toIndex > array.length) {
            throw new IllegalArgumentException(("fromIndex (" + fromIndex + ") or toIndex (" + toIndex + ") are out of range: 0.." + array.length + '.').toString());
        }
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException(("fromIndex (" + fromIndex + ") must be not greater than toIndex (" + toIndex + ").").toString());
        }
        int i10 = (toIndex - fromIndex) / 4;
        for (int i11 = 0; i11 < i10; i11++) {
            int iF = f();
            array[fromIndex] = (byte) iF;
            array[fromIndex + 1] = (byte) (iF >>> 8);
            array[fromIndex + 2] = (byte) (iF >>> 16);
            array[fromIndex + 3] = (byte) (iF >>> 24);
            fromIndex += 4;
        }
        int i12 = toIndex - fromIndex;
        int iB = b(i12 * 8);
        for (int i13 = 0; i13 < i12; i13++) {
            array[fromIndex + i13] = (byte) (iB >>> (i13 * 8));
        }
        return array;
    }

    public float e() {
        return b(24) / 1.6777216E7f;
    }

    public int f() {
        return b(32);
    }

    public int g(int until) {
        return h(0, until);
    }

    public int h(int from, int until) {
        int iF;
        int i10;
        int iB;
        C5526c.c(from, until);
        int i11 = until - from;
        if (i11 > 0 || i11 == Integer.MIN_VALUE) {
            if (((-i11) & i11) == i11) {
                iB = b(C5526c.e(i11));
            } else {
                do {
                    iF = f() >>> 1;
                    i10 = iF % i11;
                } while ((iF - i10) + (i11 - 1) < 0);
                iB = i10;
            }
            return from + iB;
        }
        while (true) {
            int iF2 = f();
            if (from <= iF2 && iF2 < until) {
                return iF2;
            }
        }
    }

    public long i() {
        return (f() << 32) + f();
    }

    public long j(long until) {
        return k(0L, until);
    }

    public long k(long from, long until) {
        long jI;
        long j10;
        long jB;
        int iF;
        C5526c.d(from, until);
        long j11 = until - from;
        if (j11 > 0) {
            if (((-j11) & j11) == j11) {
                int i10 = (int) j11;
                int i11 = (int) (j11 >>> 32);
                if (i10 != 0) {
                    iF = b(C5526c.e(i10));
                } else if (i11 == 1) {
                    iF = f();
                } else {
                    jB = (b(C5526c.e(i11)) << 32) + (f() & 4294967295L);
                }
                jB = iF & 4294967295L;
            } else {
                do {
                    jI = i() >>> 1;
                    j10 = jI % j11;
                } while ((jI - j10) + (j11 - 1) < 0);
                jB = j10;
            }
            return from + jB;
        }
        while (true) {
            long jI2 = i();
            if (from <= jI2 && jI2 < until) {
                return jI2;
            }
        }
    }
}
