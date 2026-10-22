package M0;

import k1.InterfaceC1619a;
import s2.C1912a;

/* loaded from: classes2.dex */
public final class a implements InterfaceC1619a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f952a;
    public final /* synthetic */ C1912a b;

    public /* synthetic */ a(C1912a c1912a, int i) {
        this.f952a = i;
        this.b = c1912a;
    }

    @Override // k1.InterfaceC1619a
    public final Object create() {
        switch (this.f952a) {
            case 0:
                this.b.getClass();
                return new h(0);
            case 1:
                this.b.getClass();
                return new g();
            case 2:
                this.b.getClass();
                return H.h.g;
            case 3:
                this.b.getClass();
                return J2.c.f865a.c;
            default:
                this.b.getClass();
                return new f();
        }
    }
}
