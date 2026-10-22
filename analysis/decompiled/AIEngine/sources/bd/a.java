package bd;

import ad.t;
import sd.e0;
import sd.f0;
import sd.z;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends t implements e0 {

    /* renamed from: b, reason: collision with root package name */
    public final ad.l f3216b;

    /* renamed from: c, reason: collision with root package name */
    public final long f3217c;

    public a(ad.l lVar, long j10) {
        this.f3216b = lVar;
        this.f3217c = j10;
    }

    @Override // ad.t
    public final long a() {
        return this.f3217c;
    }

    @Override // ad.t
    public final ad.l o() {
        return this.f3216b;
    }

    @Override // sd.e0
    public final long read(sd.e sink, long j10) {
        kotlin.jvm.internal.g.f(sink, "sink");
        throw new IllegalStateException("Unreadable ResponseBody! These Response objects have bodies that are stripped:\n * Response.cacheResponse\n * Response.networkResponse\n * Response.priorResponse\n * EventSourceListener\n * WebSocketListener\n(It is safe to call contentType() and contentLength() on these response bodies.)");
    }

    @Override // sd.e0
    public final f0 timeout() {
        return f0.f11935d;
    }

    @Override // ad.t
    public final sd.h w() {
        return new z(this);
    }

    @Override // ad.t, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
