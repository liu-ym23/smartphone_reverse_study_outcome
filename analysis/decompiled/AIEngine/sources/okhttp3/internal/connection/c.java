package okhttp3.internal.connection;

import mb.k;
import okhttp3.internal.connection.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements h {

    /* renamed from: a, reason: collision with root package name */
    public final f f11039a;

    public c(f fVar) {
        this.f11039a = fVar;
    }

    @Override // okhttp3.internal.connection.h
    public final okhttp3.a a() {
        return this.f11039a.f11077j;
    }

    @Override // okhttp3.internal.connection.h
    public final k<h.b> b() {
        return this.f11039a.f11083p;
    }

    @Override // okhttp3.internal.connection.h
    public final h.b c() {
        return this.f11039a.f();
    }

    @Override // okhttp3.internal.connection.h
    public final boolean d(okhttp3.g url) {
        kotlin.jvm.internal.g.f(url, "url");
        return this.f11039a.d(url);
    }

    @Override // okhttp3.internal.connection.h
    public final boolean e(ed.g gVar) {
        return this.f11039a.e(gVar);
    }

    @Override // okhttp3.internal.connection.h
    public final boolean isCanceled() {
        return this.f11039a.f11079l.isCanceled();
    }
}
