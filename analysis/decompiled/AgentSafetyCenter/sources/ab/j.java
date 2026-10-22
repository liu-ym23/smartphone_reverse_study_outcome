package ab;

import aa.r;
import aa.t;
import aa.u;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f418a = new j();

    public static h a(j jVar, y9.b bVar, float f5, int i) {
        Float fValueOf = Float.valueOf(30.0f);
        float f10 = (i & 4) != 0 ? 1.0f : 0.5f;
        bVar.getClass();
        aa.f fVar = new aa.f();
        bVar.f16034b.invoke(fVar, Float.valueOf(f5));
        u uVar = new u();
        bVar.f16035c.invoke(uVar, Float.valueOf(f5));
        r rVar = new r();
        bVar.f16036d.invoke(rVar, Float.valueOf(f5));
        t tVar = new t();
        bVar.f16037e.invoke(tVar, Float.valueOf(f5));
        aa.d dVar = new aa.d();
        bVar.f16038f.invoke(dVar, Float.valueOf(f5));
        rVar.f360e *= f10;
        tVar.f363c = fValueOf.floatValue();
        h hVar = new h();
        hVar.f412a = fVar;
        hVar.f413b = uVar;
        hVar.f414c = rVar;
        hVar.f415d = tVar;
        hVar.f416e = dVar;
        VarHandle.storeStoreFence();
        return hVar;
    }
}
