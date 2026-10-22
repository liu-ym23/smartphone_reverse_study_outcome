package L4;

/* loaded from: classes.dex */
public abstract class i implements w {

    /* renamed from: a, reason: collision with root package name */
    private final w f3947a;

    public i(w wVar) {
        j4.k.h(wVar, "delegate");
        this.f3947a = wVar;
    }

    @Override // L4.w
    public z b() {
        return this.f3947a.b();
    }

    @Override // L4.w, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3947a.close();
    }

    @Override // L4.w, java.io.Flushable
    public void flush() {
        this.f3947a.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f3947a + ')';
    }

    @Override // L4.w
    public void y0(e eVar, long j5) {
        j4.k.h(eVar, "source");
        this.f3947a.y0(eVar, j5);
    }
}
