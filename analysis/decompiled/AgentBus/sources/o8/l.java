package o8;

import f8.l0;

/* loaded from: classes.dex */
public final class l implements h9.g {
    @Override // h9.g
    public final int a(f8.b bVar, f8.b bVar2, f8.e eVar) {
        q7.k.e(bVar, "superDescriptor");
        q7.k.e(bVar2, "subDescriptor");
        if (!(bVar2 instanceof l0) || !(bVar instanceof l0)) {
            return 4;
        }
        l0 l0Var = (l0) bVar2;
        l0 l0Var2 = (l0) bVar;
        if (!q7.k.a(l0Var.getName(), l0Var2.getName())) {
            return 4;
        }
        if (nb.i.E(l0Var) && nb.i.E(l0Var2)) {
            return 1;
        }
        return (nb.i.E(l0Var) || nb.i.E(l0Var2)) ? 3 : 4;
    }

    @Override // h9.g
    public final int b() {
        return 3;
    }
}
