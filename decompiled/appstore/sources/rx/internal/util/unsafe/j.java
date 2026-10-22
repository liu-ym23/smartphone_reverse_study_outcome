package rx.internal.util.unsafe;

/* JADX INFO: loaded from: classes4.dex */
public abstract class j extends l {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f24441g = 0;
    private volatile long consumerIndex;

    static {
        f24441g = e0.a(j.class, "consumerIndex");
    }

    public j(int r10) {
        super(r10);
    }

    public final boolean j(long r10, long r11) {
        return e0.f24434a.compareAndSwapLong(this, f24441g, r10, r11);
    }

    public final long k() {
        return this.consumerIndex;
    }
}
