package r;

import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f implements k0.k0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10273a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f10274b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f10275c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f10276d;

    public /* synthetic */ f(int i) {
        this.f10273a = i;
    }

    @Override // k0.k0
    public final void dispose() {
        switch (this.f10273a) {
            case 0:
                u0.q qVar = (u0.q) this.f10275c;
                Object obj = this.f10274b;
                qVar.remove(obj);
                ((n) this.f10276d).f10321c.k(obj);
                break;
            default:
                t0.e eVar = (t0.e) this.f10275c;
                p.f0 f0Var = eVar.f13114f;
                Object obj2 = this.f10274b;
                Object objK = f0Var.k(obj2);
                t0.j jVar = (t0.j) this.f10276d;
                if (objK == jVar) {
                    Map map = eVar.f13113c;
                    Map mapB = jVar.b();
                    if (!mapB.isEmpty()) {
                        map.put(obj2, mapB);
                        break;
                    } else {
                        map.remove(obj2);
                        break;
                    }
                }
                break;
        }
    }
}
