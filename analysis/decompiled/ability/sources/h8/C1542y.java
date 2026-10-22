package h8;

import java.util.List;

/* renamed from: h8.y, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1542y implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4591a;
    public final u1.d b;

    public /* synthetic */ C1542y(u1.d dVar, int i) {
        this.f4591a = i;
        this.b = dVar;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f4591a) {
            case 0:
                G8.c fqName = (G8.c) obj;
                kotlin.jvm.internal.k.f(fqName, "fqName");
                return new g8.k((InterfaceC1540w) this.b.c, fqName, 1);
            default:
                C1543z c1543z = (C1543z) obj;
                kotlin.jvm.internal.k.f(c1543z, "<destruct>");
                G8.b bVar = c1543z.f4592a;
                List list = c1543z.b;
                if (bVar.c) {
                    throw new UnsupportedOperationException("Unresolved local class: " + bVar);
                }
                G8.b bVarE = bVar.e();
                u1.d dVar = this.b;
                InterfaceC1523f interfaceC1523fS = bVarE != null ? dVar.S(bVarE, D7.v.w0(list, 1)) : (InterfaceC1523f) ((W8.e) dVar.d).invoke(bVar.f687a);
                boolean z10 = !bVar.b.e().d();
                W8.i iVar = (W8.i) dVar.b;
                G8.f fVarF = bVar.f();
                Integer num = (Integer) D7.v.C0(list);
                return new C1493A(iVar, interfaceC1523fS, fVarF, z10, num != null ? num.intValue() : 0);
        }
    }
}
