package w;

import java.util.Iterator;
import v.C1177a;
import w.f;

/* loaded from: classes.dex */
class k extends p {
    public k(v.e eVar) {
        super(eVar);
    }

    private void q(f fVar) {
        this.f23476h.f23426k.add(fVar);
        fVar.f23427l.add(this.f23476h);
    }

    @Override // w.p, w.InterfaceC1198d
    public void a(InterfaceC1198d interfaceC1198d) {
        C1177a c1177a = (C1177a) this.f23470b;
        int iV1 = c1177a.v1();
        Iterator<f> it = this.f23476h.f23427l.iterator();
        int i5 = 0;
        int i6 = -1;
        while (it.hasNext()) {
            int i7 = it.next().f23422g;
            if (i6 == -1 || i7 < i6) {
                i6 = i7;
            }
            if (i5 < i7) {
                i5 = i7;
            }
        }
        if (iV1 == 0 || iV1 == 2) {
            this.f23476h.d(i6 + c1177a.w1());
        } else {
            this.f23476h.d(i5 + c1177a.w1());
        }
    }

    @Override // w.p
    void d() {
        v.e eVar = this.f23470b;
        if (eVar instanceof C1177a) {
            this.f23476h.f23417b = true;
            C1177a c1177a = (C1177a) eVar;
            int iV1 = c1177a.v1();
            boolean zU1 = c1177a.u1();
            int i5 = 0;
            if (iV1 == 0) {
                this.f23476h.f23420e = f.a.LEFT;
                while (i5 < c1177a.f23198M0) {
                    v.e eVar2 = c1177a.f23197L0[i5];
                    if (zU1 || eVar2.V() != 8) {
                        f fVar = eVar2.f23064e.f23476h;
                        fVar.f23426k.add(this.f23476h);
                        this.f23476h.f23427l.add(fVar);
                    }
                    i5++;
                }
                q(this.f23470b.f23064e.f23476h);
                q(this.f23470b.f23064e.f23477i);
                return;
            }
            if (iV1 == 1) {
                this.f23476h.f23420e = f.a.RIGHT;
                while (i5 < c1177a.f23198M0) {
                    v.e eVar3 = c1177a.f23197L0[i5];
                    if (zU1 || eVar3.V() != 8) {
                        f fVar2 = eVar3.f23064e.f23477i;
                        fVar2.f23426k.add(this.f23476h);
                        this.f23476h.f23427l.add(fVar2);
                    }
                    i5++;
                }
                q(this.f23470b.f23064e.f23476h);
                q(this.f23470b.f23064e.f23477i);
                return;
            }
            if (iV1 == 2) {
                this.f23476h.f23420e = f.a.TOP;
                while (i5 < c1177a.f23198M0) {
                    v.e eVar4 = c1177a.f23197L0[i5];
                    if (zU1 || eVar4.V() != 8) {
                        f fVar3 = eVar4.f23066f.f23476h;
                        fVar3.f23426k.add(this.f23476h);
                        this.f23476h.f23427l.add(fVar3);
                    }
                    i5++;
                }
                q(this.f23470b.f23066f.f23476h);
                q(this.f23470b.f23066f.f23477i);
                return;
            }
            if (iV1 != 3) {
                return;
            }
            this.f23476h.f23420e = f.a.BOTTOM;
            while (i5 < c1177a.f23198M0) {
                v.e eVar5 = c1177a.f23197L0[i5];
                if (zU1 || eVar5.V() != 8) {
                    f fVar4 = eVar5.f23066f.f23477i;
                    fVar4.f23426k.add(this.f23476h);
                    this.f23476h.f23427l.add(fVar4);
                }
                i5++;
            }
            q(this.f23470b.f23066f.f23476h);
            q(this.f23470b.f23066f.f23477i);
        }
    }

    @Override // w.p
    public void e() {
        v.e eVar = this.f23470b;
        if (eVar instanceof C1177a) {
            int iV1 = ((C1177a) eVar).v1();
            if (iV1 == 0 || iV1 == 1) {
                this.f23470b.m1(this.f23476h.f23422g);
            } else {
                this.f23470b.n1(this.f23476h.f23422g);
            }
        }
    }

    @Override // w.p
    void f() {
        this.f23471c = null;
        this.f23476h.c();
    }

    @Override // w.p
    boolean m() {
        return false;
    }
}
