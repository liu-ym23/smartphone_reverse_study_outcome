package X8;

import d9.AbstractC1380a;
import d9.AbstractC1383d;
import d9.C1382c;
import d9.C1390k;
import d9.C1396q;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.EmptyList;

/* loaded from: classes4.dex */
public final class H extends AbstractC1383d {
    public static final O2.a b = new O2.a(4);
    public static final H c = new H(EmptyList.f4893a);

    public H(List list) {
        this.f4305a = C1390k.f4310a;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0276g c0276g = (C0276g) it.next();
            c0276g.getClass();
            String strL = kotlin.jvm.internal.m.f4928a.b(C0276g.class).l();
            kotlin.jvm.internal.k.c(strL);
            int iO = b.o(strL);
            int iB = this.f4305a.b();
            if (iB != 0) {
                if (iB == 1) {
                    AbstractC1380a abstractC1380a = this.f4305a;
                    kotlin.jvm.internal.k.d(abstractC1380a, "null cannot be cast to non-null type org.jetbrains.kotlin.util.OneElementArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
                    C1396q c1396q = (C1396q) abstractC1380a;
                    int i = c1396q.b;
                    if (i == iO) {
                        this.f4305a = new C1396q(iO, c0276g);
                    } else {
                        C1382c c1382c = new C1382c();
                        c1382c.f4304a = new Object[20];
                        c1382c.b = 0;
                        this.f4305a = c1382c;
                        c1382c.e(i, c1396q.f4315a);
                    }
                }
                this.f4305a.e(iO, c0276g);
            } else {
                this.f4305a = new C1396q(iO, c0276g);
            }
        }
    }
}
