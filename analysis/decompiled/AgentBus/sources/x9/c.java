package x9;

import f8.i0;
import f8.l;
import f8.x;
import f8.z;
import java.util.Collection;
import java.util.List;
import q7.k;

/* loaded from: classes.dex */
public final class c implements z {

    /* renamed from: f, reason: collision with root package name */
    public static final c f11286f = new c();

    /* renamed from: g, reason: collision with root package name */
    public static final e9.f f11287g = e9.f.g("<Error module>");

    /* renamed from: h, reason: collision with root package name */
    public static final d7.z f11288h = d7.z.f2978f;

    /* renamed from: i, reason: collision with root package name */
    public static final c8.e f11289i;

    static {
        c8.e eVar = c8.e.f1994f;
        f11289i = c8.e.f1994f;
    }

    @Override // f8.j
    public final Object P(l lVar, Object obj) {
        return null;
    }

    @Override // f8.z
    public final List W() {
        return f11288h;
    }

    @Override // f8.j
    public final f8.j a() {
        return this;
    }

    @Override // f8.z
    public final boolean g0(z zVar) {
        k.e(zVar, "targetModule");
        return false;
    }

    @Override // g8.a
    public final g8.j getAnnotations() {
        return g8.h.f3888a;
    }

    @Override // f8.j
    public final e9.f getName() {
        return f11287g;
    }

    @Override // f8.z
    public final Collection j(e9.c cVar, p7.k kVar) {
        k.e(cVar, "fqName");
        k.e(kVar, "nameFilter");
        return d7.z.f2978f;
    }

    @Override // f8.z
    public final c8.h n() {
        return f11289i;
    }

    @Override // f8.j
    public final f8.j p() {
        return null;
    }

    @Override // f8.z
    public final Object s0(x xVar) {
        k.e(xVar, "capability");
        return null;
    }

    @Override // f8.z
    public final i0 z(e9.c cVar) {
        k.e(cVar, "fqName");
        throw new IllegalStateException("Should not be called!");
    }
}
