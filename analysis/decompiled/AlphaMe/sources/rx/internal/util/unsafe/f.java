package rx.internal.util.unsafe;

/* loaded from: classes2.dex */
public abstract class f extends h {

    /* renamed from: j, reason: collision with root package name */
    public static final long f14115j = v.a(f.class, "consumerIndex");
    private volatile long consumerIndex;

    public final boolean o(long j4, long j5) {
        return v.f14123a.compareAndSwapLong(this, f14115j, j4, j5);
    }

    public final long p() {
        return this.consumerIndex;
    }
}
