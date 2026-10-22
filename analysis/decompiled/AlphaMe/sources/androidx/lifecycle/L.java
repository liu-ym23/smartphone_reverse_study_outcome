package androidx.lifecycle;

/* loaded from: classes.dex */
public final class L implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ P f3881a;

    public L(P p4) {
        this.f3881a = p4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        synchronized (this.f3881a.f3889a) {
            obj = this.f3881a.f3894f;
            this.f3881a.f3894f = P.f3888k;
        }
        this.f3881a.g(obj);
    }
}
