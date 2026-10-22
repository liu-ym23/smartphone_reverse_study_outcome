package rx.internal.util.unsafe;

/* loaded from: classes2.dex */
public abstract class k extends m {

    /* renamed from: g, reason: collision with root package name */
    public static final long f14117g = v.a(k.class, "consumerIndex");
    private volatile long consumerIndex;

    public final boolean i(long j4, long j5) {
        return v.f14123a.compareAndSwapLong(this, f14117g, j4, j5);
    }

    public final long j() {
        return this.consumerIndex;
    }
}
