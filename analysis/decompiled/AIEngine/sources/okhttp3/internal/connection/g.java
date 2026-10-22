package okhttp3.internal.connection;

import okhttp3.internal.connection.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g implements h.b {

    /* renamed from: a, reason: collision with root package name */
    public final ed.g f11084a;

    public g(ed.g gVar) {
        this.f11084a = gVar;
    }

    @Override // okhttp3.internal.connection.h.b
    public final ed.g a() {
        return this.f11084a;
    }

    @Override // okhttp3.internal.connection.h.b
    public final h.a c() {
        throw new IllegalStateException("already connected");
    }

    @Override // okhttp3.internal.connection.h.b, fd.d.a
    public final void cancel() {
        throw new IllegalStateException("unexpected cancel");
    }

    @Override // okhttp3.internal.connection.h.b
    public final h.b e() {
        throw new IllegalStateException("unexpected retry");
    }

    @Override // okhttp3.internal.connection.h.b
    public final h.a g() {
        throw new IllegalStateException("already connected");
    }

    @Override // okhttp3.internal.connection.h.b
    public final boolean isReady() {
        return true;
    }
}
