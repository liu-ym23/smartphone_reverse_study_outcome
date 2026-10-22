package rx.internal.util.unsafe;

/* loaded from: classes2.dex */
public abstract class c extends a {

    /* renamed from: g, reason: collision with root package name */
    public static final long f14112g;

    /* renamed from: h, reason: collision with root package name */
    public static final int f14113h;

    /* renamed from: f, reason: collision with root package name */
    public final long[] f14114f;

    static {
        if (8 != v.f14123a.arrayIndexScale(long[].class)) {
            throw new IllegalStateException("Unexpected long[] element size");
        }
        f14113h = a.f14107c + 3;
        f14112g = r0.arrayBaseOffset(long[].class) + (32 << (r3 - r2));
    }

    public c(int i4) {
        super(i4);
        int i5 = (int) (this.f14110a + 1);
        this.f14114f = new long[(i5 << a.f14107c) + 64];
        for (long j4 = 0; j4 < i5; j4++) {
            h(this.f14114f, f14112g + ((this.f14110a & j4) << f14113h), j4);
        }
    }

    public static long g(long[] jArr, long j4) {
        return v.f14123a.getLongVolatile(jArr, j4);
    }

    public static void h(long[] jArr, long j4, long j5) {
        v.f14123a.putOrderedLong(jArr, j4, j5);
    }
}
