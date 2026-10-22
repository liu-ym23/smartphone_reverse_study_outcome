package rx.internal.util.unsafe;

/* loaded from: classes2.dex */
public abstract class i extends g {

    /* renamed from: i, reason: collision with root package name */
    public static final long f14116i = v.a(i.class, "producerIndex");
    private volatile long producerIndex;

    public final boolean i(long j4, long j5) {
        return v.f14123a.compareAndSwapLong(this, f14116i, j4, j5);
    }

    public final long j() {
        return this.producerIndex;
    }
}
