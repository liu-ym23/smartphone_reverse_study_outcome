package od;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class p implements g0 {

    /* renamed from: c, reason: collision with root package name */
    public g0 f9479c;

    @Override // od.g0
    public final k0 b() {
        return this.f9479c.b();
    }

    @Override // od.g0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f9479c.close();
    }

    @Override // od.g0
    public void f(i iVar, long j10) {
        iVar.getClass();
        this.f9479c.f(iVar, j10);
    }

    @Override // od.g0, java.io.Flushable
    public void flush() {
        this.f9479c.flush();
    }

    public final String toString() {
        return getClass().getSimpleName() + '(' + this.f9479c + ')';
    }
}
