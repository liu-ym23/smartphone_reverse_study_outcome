package v9;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class i0 extends ba.d {

    /* renamed from: g, reason: collision with root package name */
    public static final nb.f f10557g = new nb.f(10);

    /* renamed from: h, reason: collision with root package name */
    public static final i0 f10558h = new i0(d7.z.f2978f);

    public i0(List list) {
        this.f1594f = ba.l.f1613f;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            gVar.getClass();
            int iA = f10557g.A(q7.w.f8821a.b(g.class));
            int iA2 = this.f1594f.a();
            if (iA2 != 0) {
                if (iA2 == 1) {
                    ba.a aVar = this.f1594f;
                    q7.k.c(aVar, "null cannot be cast to non-null type org.jetbrains.kotlin.util.OneElementArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
                    ba.s sVar = (ba.s) aVar;
                    int i2 = sVar.f1628g;
                    if (i2 == iA) {
                        this.f1594f = new ba.s(iA, gVar);
                    } else {
                        ba.c cVar = new ba.c();
                        cVar.f1592f = new Object[20];
                        cVar.f1593g = 0;
                        this.f1594f = cVar;
                        cVar.f(i2, sVar.f1627f);
                    }
                }
                this.f1594f.f(iA, gVar);
            } else {
                this.f1594f = new ba.s(iA, gVar);
            }
        }
    }
}
