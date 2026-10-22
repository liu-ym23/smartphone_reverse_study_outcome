package rx.internal.util.unsafe;

/* loaded from: classes2.dex */
public abstract class n extends l {

    /* renamed from: f, reason: collision with root package name */
    public static final long f14118f = v.a(n.class, "producerIndex");
    private volatile long producerIndex;

    public final long g() {
        return this.producerIndex;
    }

    public final void h(long j4) {
        v.f14123a.putOrderedLong(this, f14118f, j4);
    }
}
