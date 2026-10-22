package y8;

import e9.f;
import x8.k;
import x8.l;

/* loaded from: classes.dex */
public final class c implements k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f11709f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ e f11710g;

    public /* synthetic */ c(e eVar, int i2) {
        this.f11709f = i2;
        this.f11710g = eVar;
    }

    private final void a(f fVar, Object obj) {
    }

    private final void c(f fVar, j9.f fVar2) {
    }

    private final void d(f fVar, j9.f fVar2) {
    }

    private final void f(f fVar, j9.f fVar2) {
    }

    private final void h() {
    }

    private final void i() {
    }

    private final void j() {
    }

    private final void m(f fVar, e9.b bVar, f fVar2) {
    }

    private final void n(f fVar, e9.b bVar, f fVar2) {
    }

    private final void o(f fVar, e9.b bVar, f fVar2) {
    }

    @Override // x8.k
    public final void b() {
        int i2 = this.f11709f;
    }

    @Override // x8.k
    public final void e(f fVar, Object obj) {
        switch (this.f11709f) {
            case 0:
                String strB = fVar.b();
                boolean zEquals = "k".equals(strB);
                e eVar = this.f11710g;
                if (!zEquals) {
                    if (!"mv".equals(strB)) {
                        if (!"xs".equals(strB)) {
                            if (!"xi".equals(strB)) {
                                "pn".equals(strB);
                                break;
                            } else if (obj instanceof Integer) {
                                eVar.f11717h = ((Integer) obj).intValue();
                                break;
                            }
                        } else if (obj instanceof String) {
                            String str = (String) obj;
                            if (!str.isEmpty()) {
                                eVar.f11716g = str;
                                break;
                            }
                        }
                    } else if (obj instanceof int[]) {
                        eVar.f11715f = (int[]) obj;
                        break;
                    }
                } else if (obj instanceof Integer) {
                    a aVar = (a) a.f11698g.get((Integer) obj);
                    if (aVar == null) {
                        aVar = a.UNKNOWN;
                    }
                    eVar.f11721l = aVar;
                    break;
                }
                break;
            case 1:
                break;
            default:
                String strB2 = fVar.b();
                boolean zEquals2 = "version".equals(strB2);
                e eVar2 = this.f11710g;
                if (!zEquals2) {
                    if ("multifileClassName".equals(strB2)) {
                        eVar2.f11716g = obj instanceof String ? (String) obj : null;
                        break;
                    }
                } else if (obj instanceof int[]) {
                    eVar2.f11715f = (int[]) obj;
                    break;
                }
                break;
        }
    }

    @Override // x8.k
    public final void g(f fVar, e9.b bVar, f fVar2) {
        int i2 = this.f11709f;
    }

    @Override // x8.k
    public final void k(f fVar, j9.f fVar2) {
        int i2 = this.f11709f;
    }

    @Override // x8.k
    public final l l(f fVar) {
        switch (this.f11709f) {
            case 0:
                String strB = fVar.b();
                if ("d1".equals(strB)) {
                    return new b(this, 0);
                }
                if ("d2".equals(strB)) {
                    return new b(this, 1);
                }
                return null;
            case 1:
                if ("b".equals(fVar.b())) {
                    return new b(this, 2);
                }
                return null;
            default:
                String strB2 = fVar.b();
                if ("data".equals(strB2) || "filePartClassNames".equals(strB2)) {
                    return new d(this, 0);
                }
                if ("strings".equals(strB2)) {
                    return new d(this, 1);
                }
                return null;
        }
    }

    @Override // x8.k
    public final k p(e9.b bVar, f fVar) {
        switch (this.f11709f) {
        }
        return null;
    }
}
