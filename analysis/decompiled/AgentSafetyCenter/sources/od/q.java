package od;

import java.io.IOException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class q implements i0 {

    /* renamed from: c, reason: collision with root package name */
    public i0 f9480c;

    @Override // od.i0
    public final k0 b() {
        return this.f9480c.b();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f9480c.close();
    }

    @Override // od.i0
    public long l(i iVar, long j10) {
        iVar.getClass();
        return this.f9480c.l(iVar, j10);
    }

    public final String toString() {
        return getClass().getSimpleName() + '(' + this.f9480c + ')';
    }
}
