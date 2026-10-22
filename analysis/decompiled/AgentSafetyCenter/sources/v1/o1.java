package v1;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o1 {

    /* renamed from: a, reason: collision with root package name */
    public final a2.k f14519a;

    /* renamed from: b, reason: collision with root package name */
    public final p.v f14520b;

    public o1(a2.p pVar, p.j jVar) {
        this.f14519a = pVar.f88d;
        this.f14520b = new p.v(a2.p.j(4, pVar).size());
        List listJ = a2.p.j(4, pVar);
        int size = listJ.size();
        for (int i = 0; i < size; i++) {
            a2.p pVar2 = (a2.p) listJ.get(i);
            if (jVar.a(pVar2.f91g)) {
                this.f14520b.a(pVar2.f91g);
            }
        }
    }
}
