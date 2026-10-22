package qa;

import F9.InterfaceC0228f;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import m9.C1718k;

/* renamed from: qa.n, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1862n extends AbstractC1864p {
    public final /* synthetic */ int d;
    public final InterfaceC1854f e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1862n(K k, InterfaceC0228f interfaceC0228f, InterfaceC1859k interfaceC1859k, InterfaceC1854f interfaceC1854f, int i) {
        super(k, interfaceC0228f, interfaceC1859k);
        this.d = i;
        this.e = interfaceC1854f;
    }

    @Override // qa.AbstractC1864p
    public final Object a(v vVar, Object[] objArr) {
        int i = this.d;
        InterfaceC1854f interfaceC1854f = this.e;
        switch (i) {
            case 0:
                return interfaceC1854f.i(vVar);
            default:
                InterfaceC1852d interfaceC1852d = (InterfaceC1852d) interfaceC1854f.i(vVar);
                H7.c cVar = (H7.c) objArr[objArr.length - 1];
                try {
                    C1718k c1718k = new C1718k(1, U7.a.I(cVar));
                    c1718k.y();
                    c1718k.j(new r(interfaceC1852d, 2));
                    interfaceC1852d.g(new A0.b(c1718k, 7));
                    Object objX = c1718k.x();
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                    return objX;
                } catch (Exception e) {
                    retrofit2.a.c(e, cVar);
                    return CoroutineSingletons.f4909a;
                }
        }
    }
}
