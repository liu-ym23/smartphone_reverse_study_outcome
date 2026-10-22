package okhttp3.internal.connection;

import okhttp3.internal.connection.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements h.b {

    /* renamed from: a, reason: collision with root package name */
    public final h.a f11030a;

    public a(Throwable th) {
        this.f11030a = new h.a(this, null, th, 2);
    }

    @Override // okhttp3.internal.connection.h.b
    public final ed.g a() {
        throw new IllegalStateException("unexpected call");
    }

    @Override // okhttp3.internal.connection.h.b
    public final h.a c() {
        return this.f11030a;
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
        return this.f11030a;
    }

    @Override // okhttp3.internal.connection.h.b
    public final boolean isReady() {
        return false;
    }
}
