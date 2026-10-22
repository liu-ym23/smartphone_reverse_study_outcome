package yc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h implements tc.a {

    /* renamed from: a, reason: collision with root package name */
    public static final h f16107a = new h();

    /* renamed from: b, reason: collision with root package name */
    public static final vc.f f16108b;

    static {
        vc.f fVar;
        vc.b bVar = vc.b.f14873b;
        vc.e[] eVarArr = new vc.e[0];
        t0.d dVar = new t0.d(10);
        if (hc.h.g0("kotlinx.serialization.json.JsonElement")) {
            g5.f.s("Blank serial names are prohibited");
        } else {
            if (!bVar.equals(vc.g.f14891b)) {
                vc.a aVar = new vc.a("kotlinx.serialization.json.JsonElement");
                dVar.invoke(aVar);
                fVar = new vc.f("kotlinx.serialization.json.JsonElement", bVar, aVar.f14868b.size(), kb.k.u0(eVarArr), aVar);
                f16108b = fVar;
            }
            g5.f.s("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
        }
        fVar = null;
        f16108b = fVar;
    }

    @Override // tc.a
    public final vc.e getDescriptor() {
        return f16108b;
    }
}
