package uc;

import kotlin.NoWhenBranchMatchedException;
import rc.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i implements pc.a<g> {

    /* renamed from: a, reason: collision with root package name */
    public static final i f13211a = new i();

    /* renamed from: b, reason: collision with root package name */
    public static final rc.f f13212b = rc.h.a("kotlinx.serialization.json.JsonElement", c.a.f11776a, new rc.e[0], new o6.a(9));

    @Override // pc.c
    public final void a(vc.k kVar, Object obj) {
        g value = (g) obj;
        kotlin.jvm.internal.g.f(value, "value");
        jd.b.b(kVar);
        if (value instanceof t) {
            kVar.q(u.f13227a, value);
        } else if (value instanceof r) {
            kVar.q(s.f13222a, value);
        } else {
            if (!(value instanceof b)) {
                throw new NoWhenBranchMatchedException();
            }
            kVar.q(c.f13198a, value);
        }
    }

    @Override // pc.a
    public final Object b(sc.d dVar) {
        return jd.b.d(dVar).g();
    }

    @Override // pc.c
    public final rc.e d() {
        return f13212b;
    }
}
