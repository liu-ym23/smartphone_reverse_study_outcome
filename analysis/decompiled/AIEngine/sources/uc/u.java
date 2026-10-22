package uc;

import mb.y;
import rc.d;
import rc.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class u implements pc.a<t> {

    /* renamed from: a, reason: collision with root package name */
    public static final u f13227a = new u();

    /* renamed from: b, reason: collision with root package name */
    public static final rc.f f13228b;

    static {
        d.i kind = d.i.f11785a;
        rc.e[] eVarArr = new rc.e[0];
        kotlin.jvm.internal.g.f(kind, "kind");
        if (gc.q.t0("kotlinx.serialization.json.JsonPrimitive")) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        if (kind.equals(j.a.f11801a)) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
        }
        rc.a aVar = new rc.a("kotlinx.serialization.json.JsonPrimitive");
        lb.n nVar = lb.n.f10413a;
        f13228b = new rc.f("kotlinx.serialization.json.JsonPrimitive", kind, aVar.f11771c.size(), mb.l.q0(eVarArr), aVar);
    }

    @Override // pc.c
    public final void a(vc.k kVar, Object obj) {
        t value = (t) obj;
        kotlin.jvm.internal.g.f(value, "value");
        jd.b.b(kVar);
        if (value instanceof p) {
            kVar.q(q.f13219a, p.INSTANCE);
        } else {
            kVar.q(n.f13216a, (m) value);
        }
    }

    @Override // pc.a
    public final Object b(sc.d dVar) {
        g gVarG = jd.b.d(dVar).g();
        if (gVarG instanceof t) {
            return (t) gVarG;
        }
        throw y.b(-1, gVarG.toString(), "Unexpected JSON element, expected JsonPrimitive, had " + kotlin.jvm.internal.i.a(gVarG.getClass()));
    }

    @Override // pc.c
    public final rc.e d() {
        return f13228b;
    }
}
