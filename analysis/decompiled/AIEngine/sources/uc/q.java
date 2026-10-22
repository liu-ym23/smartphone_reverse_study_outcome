package uc;

import kotlinx.serialization.json.internal.JsonDecodingException;
import rc.i;
import rc.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class q implements pc.a<p> {

    /* renamed from: a, reason: collision with root package name */
    public static final q f13219a = new q();

    /* renamed from: b, reason: collision with root package name */
    public static final rc.f f13220b;

    static {
        i.b kind = i.b.f11800a;
        rc.e[] eVarArr = new rc.e[0];
        kotlin.jvm.internal.g.f(kind, "kind");
        if (gc.q.t0("kotlinx.serialization.json.JsonNull")) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        if (kind.equals(j.a.f11801a)) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
        }
        rc.a aVar = new rc.a("kotlinx.serialization.json.JsonNull");
        lb.n nVar = lb.n.f10413a;
        f13220b = new rc.f("kotlinx.serialization.json.JsonNull", kind, aVar.f11771c.size(), mb.l.q0(eVarArr), aVar);
    }

    @Override // pc.c
    public final void a(vc.k kVar, Object obj) {
        p value = (p) obj;
        kotlin.jvm.internal.g.f(value, "value");
        jd.b.b(kVar);
        kVar.k();
    }

    @Override // pc.a
    public final Object b(sc.d dVar) {
        jd.b.d(dVar);
        if (dVar.x()) {
            throw new JsonDecodingException("Expected 'null' literal");
        }
        return p.INSTANCE;
    }

    @Override // pc.c
    public final rc.e d() {
        return f13220b;
    }
}
