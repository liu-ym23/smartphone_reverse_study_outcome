package ie;

import java.io.IOException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class t extends ad.h0 {

    /* renamed from: f, reason: collision with root package name */
    public ad.h0 f6077f;

    /* renamed from: g, reason: collision with root package name */
    public od.c0 f6078g;

    /* renamed from: h, reason: collision with root package name */
    public IOException f6079h;

    @Override // ad.h0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f6077f.close();
    }

    @Override // ad.h0
    public final long d() {
        return this.f6077f.d();
    }

    @Override // ad.h0
    public final ad.s e() {
        return this.f6077f.e();
    }

    @Override // ad.h0
    public final od.k g() {
        return this.f6078g;
    }
}
