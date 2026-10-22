package Tb;

import Yb.AbstractC1128b;
import Yb.t;
import Yb.w;
import ac.AbstractC1280a;
import ac.C1282c;
import ac.InterfaceC1287h;

/* loaded from: classes5.dex */
public class p extends AbstractC1280a {

    /* renamed from: a, reason: collision with root package name */
    public final t f6009a = new t();

    /* renamed from: b, reason: collision with root package name */
    public int f6010b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6011c;

    public p(int i10) {
        this.f6010b = i10;
    }

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public boolean a() {
        return true;
    }

    @Override // ac.InterfaceC1283d
    public C1282c d(InterfaceC1287h interfaceC1287h) {
        if (!interfaceC1287h.a()) {
            return interfaceC1287h.d() >= this.f6010b ? C1282c.a(interfaceC1287h.c() + this.f6010b) : C1282c.d();
        }
        if (this.f6009a.c() == null) {
            return C1282c.d();
        }
        AbstractC1128b abstractC1128bE = interfaceC1287h.f().e();
        this.f6011c = (abstractC1128bE instanceof w) || (abstractC1128bE instanceof t);
        return C1282c.b(interfaceC1287h.e());
    }

    @Override // ac.InterfaceC1283d
    public AbstractC1128b e() {
        return this.f6009a;
    }

    @Override // ac.AbstractC1280a, ac.InterfaceC1283d
    public boolean h(AbstractC1128b abstractC1128b) {
        if (!this.f6011c) {
            return true;
        }
        AbstractC1128b abstractC1128bF = this.f6009a.f();
        if (!(abstractC1128bF instanceof Yb.s)) {
            return true;
        }
        ((Yb.s) abstractC1128bF).o(false);
        return true;
    }
}
