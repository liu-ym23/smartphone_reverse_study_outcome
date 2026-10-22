package rx.internal.util.unsafe;

/* JADX INFO: loaded from: classes4.dex */
public abstract class o extends k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f24442f = 0;
    private volatile long producerIndex;

    static {
        f24442f = e0.a(o.class, "producerIndex");
    }

    public o(int r10) {
        super(r10);
    }

    public final long h() {
        return this.producerIndex;
    }

    public final void i(long r10) {
        e0.f24434a.putOrderedLong(this, f24442f, r10);
    }
}
