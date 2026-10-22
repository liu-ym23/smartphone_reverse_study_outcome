package Pb;

import Zb.d;
import cc.InterfaceC1510a;
import dc.InterfaceC3968b;
import dc.c;
import dc.d;

/* loaded from: classes5.dex */
public class b implements d.c, Ob.a, d.InterfaceC0390d {

    public class a implements c {
        public a() {
        }

        @Override // dc.c
        public InterfaceC1510a a(InterfaceC3968b interfaceC3968b) {
            return new Qb.c(interfaceC3968b);
        }
    }

    public static Ob.a c() {
        return new b();
    }

    @Override // dc.d.InterfaceC0390d
    public void a(d.b bVar) {
        bVar.e(new a());
    }

    @Override // Zb.d.c
    public void b(d.b bVar) {
        bVar.h(new Qb.a());
    }
}
