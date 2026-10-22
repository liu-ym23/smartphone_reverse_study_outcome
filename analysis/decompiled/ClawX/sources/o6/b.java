package o6;

import c7.h;
import c7.v;
import c7.x;
import n6.o;
import n6.w;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends w implements v {

    /* renamed from: b, reason: collision with root package name */
    public final o f4324b;

    /* renamed from: c, reason: collision with root package name */
    public final long f4325c;

    public b(o oVar, long j4) {
        this.f4324b = oVar;
        this.f4325c = j4;
    }

    @Override // n6.w
    public final long a() {
        return this.f4325c;
    }

    @Override // n6.w
    public final o b() {
        return this.f4324b;
    }

    @Override // c7.v, c7.t
    public final x d() {
        return x.d;
    }

    @Override // n6.w
    public final h e() {
        return c7.b.b(this);
    }

    @Override // c7.v
    public final long h(long j4, c7.f fVar) {
        throw new IllegalStateException("Unreadable ResponseBody! These Response objects have bodies that are stripped:\n * Response.cacheResponse\n * Response.networkResponse\n * Response.priorResponse\n * EventSourceListener\n * WebSocketListener\n(It is safe to call contentType() and contentLength() on these response bodies.)");
    }

    @Override // n6.w, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
