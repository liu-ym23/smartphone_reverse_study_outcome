package rx.internal.util.unsafe;

/* JADX INFO: loaded from: classes4.dex */
public abstract class p extends n {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f24443h;

    public p(int r10) {
        super(r10);
    }

    public final long l() {
        return this.f24443h;
    }

    public final void m(long r10) {
        this.f24443h = r10;
    }
}
