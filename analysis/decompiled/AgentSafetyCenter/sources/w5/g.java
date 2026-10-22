package w5;

import java.io.Closeable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g implements Closeable {

    /* renamed from: c, reason: collision with root package name */
    public final c f15264c;

    public g(c cVar) {
        this.f15264c = cVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f15264c.close();
    }
}
