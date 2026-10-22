package s8;

import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class y extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f9618g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ a0 f9619h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y(a0 a0Var, int i2) {
        super(0);
        this.f9618g = i2;
        this.f9619h = a0Var;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f9618g) {
            case 0:
                o9.f fVar = o9.f.f7910m;
                o9.n.f7934a.getClass();
                o9.k kVar = o9.k.f7927h;
                q7.k.e(fVar, "kindFilter");
                List list = fVar.f7917a;
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                boolean zA = fVar.a(o9.f.f7909l);
                a0 a0Var = this.f9619h;
                n8.c cVar = n8.c.f6880i;
                if (zA) {
                    for (e9.f fVar2 : a0Var.h(fVar, kVar)) {
                        kVar.invoke(fVar2);
                        ea.k.a(linkedHashSet, a0Var.b(fVar2, cVar));
                    }
                }
                if (fVar.a(o9.f.f7906i) && !list.contains(o9.b.f7895a)) {
                    for (e9.f fVar3 : a0Var.i(fVar, kVar)) {
                        kVar.invoke(fVar3);
                        linkedHashSet.addAll(a0Var.f(fVar3, cVar));
                    }
                }
                if (fVar.a(o9.f.f7907j) && !list.contains(o9.b.f7895a)) {
                    for (e9.f fVar4 : a0Var.o(fVar)) {
                        kVar.invoke(fVar4);
                        linkedHashSet.addAll(a0Var.a(fVar4, cVar));
                    }
                }
                return d7.r.m1(linkedHashSet);
            case 1:
                return this.f9619h.h(o9.f.f7912o, null);
            case 2:
                return this.f9619h.k();
            case 3:
                return this.f9619h.i(o9.f.f7913p, null);
            case 4:
                return this.f9619h.o(o9.f.f7914q);
            default:
                ((r8.a) this.f9619h.f9518b.f162f).f9009h.getClass();
                return null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(a0 a0Var, l8.u uVar, q8.f fVar) {
        super(0);
        this.f9618g = 5;
        this.f9619h = a0Var;
    }
}
