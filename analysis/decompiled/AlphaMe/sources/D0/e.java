package D0;

/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final h f381a;

    /* renamed from: b, reason: collision with root package name */
    public final D1.a f382b;

    public e(h hVar, D1.a aVar) {
        this.f381a = hVar;
        this.f382b = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f381a.f390a != this) {
            return;
        }
        if (h.f388f.h(this.f381a, this, h.f(this.f382b))) {
            h.c(this.f381a);
        }
    }
}
