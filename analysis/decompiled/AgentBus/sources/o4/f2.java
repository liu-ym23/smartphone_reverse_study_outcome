package o4;

import androidx.lifecycle.p;
import androidx.lifecycle.v;

/* loaded from: classes.dex */
public final /* synthetic */ class f2 implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f7363f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f7364g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f7365h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f7366i;

    public /* synthetic */ f2(Object obj, Object obj2, Object obj3, int i2) {
        this.f7363f = i2;
        this.f7364g = obj;
        this.f7365h = obj2;
        this.f7366i = obj3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.lifecycle.u, z2.b] */
    @Override // p7.k
    public final Object invoke(Object obj) {
        switch (this.f7363f) {
            case 0:
                t2 t2Var = (t2) this.f7364g;
                String str = (String) this.f7365h;
                String str2 = (String) this.f7366i;
                q7.k.e((String) obj, "it");
                return ia.d0.s(t2Var.f7604c, null, null, new p2(t2Var, str, str2, (g7.d) null), 3);
            default:
                androidx.lifecycle.v vVar = (androidx.lifecycle.v) this.f7364g;
                final z2.e eVar = (z2.e) this.f7365h;
                final p7.k kVar = (p7.k) this.f7366i;
                final q7.v vVar2 = new q7.v();
                ?? r22 = new androidx.lifecycle.t() { // from class: z2.b
                    @Override // androidx.lifecycle.t
                    public final void b(v vVar3, p pVar) {
                        int i2 = d.$EnumSwitchMapping$0[pVar.ordinal()];
                        q7.v vVar4 = vVar2;
                        if (i2 == 1) {
                            vVar4.f8820f = kVar.invoke(eVar);
                        } else {
                            if (i2 != 2) {
                                return;
                            }
                            d.c cVar = (d.c) vVar4.f8820f;
                            if (cVar != null) {
                                cVar.a();
                            }
                            vVar4.f8820f = null;
                        }
                    }
                };
                vVar.a().a(r22);
                return new z2.c(vVar, r22, vVar2);
        }
    }
}
