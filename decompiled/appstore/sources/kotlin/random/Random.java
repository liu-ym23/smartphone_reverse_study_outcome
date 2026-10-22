package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Random {

    @NotNull
    public static final Default Default = null;

    @NotNull
    private static final Random defaultRandom = null;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0019H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "defaultRandom", "nextBits", "", "bitCount", "nextBoolean", "", "nextBytes", "", "array", "fromIndex", "toIndex", "size", "nextDouble", "", "until", "from", "nextFloat", "", "nextInt", "nextLong", "", "writeReplace", "", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Default extends Random implements Serializable {

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\bÂ\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/random/Random$Default$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "serialVersionUID", "", "readResolve", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Serialized implements Serializable {

            @NotNull
            public static final Serialized INSTANCE = null;
            private static final long serialVersionUID = 0;

            static {
                INSTANCE = new Serialized();
            }

            private Serialized() {
            }

            private final Object readResolve() {
                return Random.Default;
            }
        }

        public /* synthetic */ Default(DefaultConstructorMarker r10) {
            this();
        }

        private final Object writeReplace() {
            return Serialized.INSTANCE;
        }

        @Override // kotlin.random.Random
        public int nextBits(int r10) {
            return Random.access$getDefaultRandom$cp().nextBits(r10);
        }

        @Override // kotlin.random.Random
        public boolean nextBoolean() {
            return Random.access$getDefaultRandom$cp().nextBoolean();
        }

        @Override // kotlin.random.Random
        @NotNull
        public byte[] nextBytes(@NotNull byte[] r10) {
            q.g(r10, "array");
            return Random.access$getDefaultRandom$cp().nextBytes(r10);
        }

        @Override // kotlin.random.Random
        public double nextDouble() {
            return Random.access$getDefaultRandom$cp().nextDouble();
        }

        @Override // kotlin.random.Random
        public float nextFloat() {
            return Random.access$getDefaultRandom$cp().nextFloat();
        }

        @Override // kotlin.random.Random
        public int nextInt() {
            return Random.access$getDefaultRandom$cp().nextInt();
        }

        @Override // kotlin.random.Random
        public long nextLong() {
            return Random.access$getDefaultRandom$cp().nextLong();
        }

        private Default() {
        }

        @Override // kotlin.random.Random
        @NotNull
        public byte[] nextBytes(int r10) {
            return Random.access$getDefaultRandom$cp().nextBytes(r10);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double r10) {
            return Random.access$getDefaultRandom$cp().nextDouble(r10);
        }

        @Override // kotlin.random.Random
        public int nextInt(int r10) {
            return Random.access$getDefaultRandom$cp().nextInt(r10);
        }

        @Override // kotlin.random.Random
        public long nextLong(long r10) {
            return Random.access$getDefaultRandom$cp().nextLong(r10);
        }

        @Override // kotlin.random.Random
        @NotNull
        public byte[] nextBytes(@NotNull byte[] r10, int r11, int r12) {
            q.g(r10, "array");
            return Random.access$getDefaultRandom$cp().nextBytes(r10, r11, r12);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double r10, double r11) {
            return Random.access$getDefaultRandom$cp().nextDouble(r10, r11);
        }

        @Override // kotlin.random.Random
        public int nextInt(int r10, int r11) {
            return Random.access$getDefaultRandom$cp().nextInt(r10, r11);
        }

        @Override // kotlin.random.Random
        public long nextLong(long r10, long r11) {
            return Random.access$getDefaultRandom$cp().nextLong(r10, r11);
        }
    }

    static {
        Default = new Default(null);
        defaultRandom = uf.b.f24937a.b();
    }

    public Random() {
    }

    public static final /* synthetic */ Random access$getDefaultRandom$cp() {
        return defaultRandom;
    }

    public static /* synthetic */ byte[] nextBytes$default(Random r10, byte[] r11, int r12, int r13, int r14, Object r15) {
        if (r15 != null) goto L12;
        if ((r14 & 2) == 0) goto L7;
        r12 = 0;
    L7:
        if ((r14 & 4) == 0) goto L10;
        r13 = r11.length;
    L10:
        return r10.nextBytes(r11, r12, r13);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
    }

    public abstract int nextBits(int r10);

    public boolean nextBoolean() {
        if (nextBits(1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    @NotNull
    public byte[] nextBytes(@NotNull byte[] r10, int r11, int r12) {
        q.g(r10, "array");
        int r13 = 0;
        if (new bg.c(0, r10.length).f(r11) == false) goto L17;
        if (new bg.c(0, r10.length).f(r12) == false) goto L17;
        if (r11 > r12) goto L15;
        int r14 = (r12 - r11) / 4;
        int r15 = 0;
    L8:
        if (r15 >= r14) goto L10;
        int r16 = nextInt();
        r10[r11] = (byte) r16;
        r10[r11 + 1] = (byte) (r16 >>> 8);
        r10[r11 + 2] = (byte) (r16 >>> 16);
        r10[r11 + 3] = (byte) (r16 >>> 24);
        r11 = r11 + 4;
        r15 = r15 + 1;
        goto L8
    L10:
        int r17 = r12 - r11;
        int r18 = nextBits(r17 * 8);
    L11:
        if (r13 >= r17) goto L13;
        r10[r11 + r13] = (byte) (r18 >>> (r13 * 8));
        r13 = r13 + 1;
        goto L11
    L13:
        return r10;
    L15:
        throw new IllegalArgumentException(("fromIndex (" + r11 + ") must be not greater than toIndex (" + r12 + ").").toString());
    L17:
        throw new IllegalArgumentException(("fromIndex (" + r11 + ") or toIndex (" + r12 + ") are out of range: 0.." + r10.length + '.').toString());
    }

    public double nextDouble() {
        return c.a(nextBits(26), nextBits(27));
    }

    public float nextFloat() {
        return nextBits(24) / 1.6777216E7f;
    }

    public abstract int nextInt();

    public int nextInt(int r10) {
        return nextInt(0, r10);
    }

    public long nextLong() {
        return (((long) nextInt()) << 32) + ((long) nextInt());
    }

    public double nextDouble(double r10) {
        return nextDouble(0.0d, r10);
    }

    public int nextInt(int r10, int r11) {
        d.c(r10, r11);
        int r12 = r11 - r10;
        if (r12 > 0) goto L12;
        if (r12 == Integer.MIN_VALUE) goto L12;
    L7:
        int r13 = nextInt();
        if (r10 > r13) goto L7;
        if (r13 >= r11) goto L7;
        return r13;
    L12:
        if (((-r12) & r12) != r12) goto L14;
        int r14 = nextBits(d.e(r12));
    L18:
        return r10 + r14;
    L14:
        int r15 = nextInt() >>> 1;
        int r16 = r15 % r12;
        if (((r15 - r16) + (r12 - 1)) < 0) goto L14;
        r14 = r16;
        goto L18
    }

    public long nextLong(long r10) {
        return nextLong(0, r10);
    }

    public double nextDouble(double r10, double r11) {
        d.b(r10, r11);
        double r12 = r11 - r10;
        if (Double.isInfinite(r12) == true) goto L5;
    L13:
        double r13 = r10 + (nextDouble() * r12);
    L15:
        if (r13 >= r11) goto L17;
        return r13;
    L17:
        return Math.nextAfter(r11, Double.NEGATIVE_INFINITY);
    L5:
        if (Double.isInfinite(r10) == true) goto L13;
        if (Double.isNaN(r10) == true) goto L13;
        if (Double.isInfinite(r11) == true) goto L13;
        if (Double.isNaN(r11) == true) goto L13;
        double r14 = 2;
        double r15 = nextDouble() * ((r11 / r14) - (r10 / r14));
        r13 = (r10 + r15) + r15;
        goto L15
    }

    public long nextLong(long r10, long r12) {
        d.d(r10, r12);
        long r11 = r12 - r10;
        if (r11 > 0) goto L5;
    L18:
        long r13 = nextLong();
        if (r10 > r13) goto L18;
        if (r13 >= r12) goto L18;
        return r13;
    L5:
        if (((-r11) & r11) != r11) goto L13;
        int r14 = (int) r11;
        int r15 = (int) (r11 >>> 32);
        if (r14 == 0) goto L10;
        int r16 = nextBits(d.e(r14));
    L9:
        long r17 = ((long) r16) & 4294967295L;
    L17:
        return r10 + r17;
    L10:
        if (r15 != 1) goto L12;
        r16 = nextInt();
        goto L9
    L12:
        r17 = (((long) nextBits(d.e(r15))) << 32) + (((long) nextInt()) & 4294967295L);
    L13:
        long r18 = nextLong() >>> 1;
        long r19 = r18 % r11;
        if (((r18 - r19) + (r11 - 1)) < 0) goto L13;
        r17 = r19;
        goto L17
    }

    @NotNull
    public byte[] nextBytes(@NotNull byte[] r10) {
        q.g(r10, "array");
        return nextBytes(r10, 0, r10.length);
    }

    @NotNull
    public byte[] nextBytes(int r10) {
        return nextBytes(new byte[r10]);
    }
}
