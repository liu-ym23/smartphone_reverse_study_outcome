package w;

/* loaded from: classes.dex */
class j extends p {
    public j(v.e eVar) {
        super(eVar);
        eVar.f23064e.f();
        eVar.f23066f.f();
        this.f23474f = ((v.h) eVar).s1();
    }

    private void q(f fVar) {
        this.f23476h.f23426k.add(fVar);
        fVar.f23427l.add(this.f23476h);
    }

    @Override // w.p, w.InterfaceC1198d
    public void a(InterfaceC1198d interfaceC1198d) {
        f fVar = this.f23476h;
        if (fVar.f23418c && !fVar.f23425j) {
            this.f23476h.d((int) ((fVar.f23427l.get(0).f23422g * ((v.h) this.f23470b).v1()) + 0.5f));
        }
    }

    @Override // w.p
    void d() {
        v.h hVar = (v.h) this.f23470b;
        int iT1 = hVar.t1();
        int iU1 = hVar.u1();
        hVar.v1();
        if (hVar.s1() == 1) {
            if (iT1 != -1) {
                this.f23476h.f23427l.add(this.f23470b.f23057a0.f23064e.f23476h);
                this.f23470b.f23057a0.f23064e.f23476h.f23426k.add(this.f23476h);
                this.f23476h.f23421f = iT1;
            } else if (iU1 != -1) {
                this.f23476h.f23427l.add(this.f23470b.f23057a0.f23064e.f23477i);
                this.f23470b.f23057a0.f23064e.f23477i.f23426k.add(this.f23476h);
                this.f23476h.f23421f = -iU1;
            } else {
                f fVar = this.f23476h;
                fVar.f23417b = true;
                fVar.f23427l.add(this.f23470b.f23057a0.f23064e.f23477i);
                this.f23470b.f23057a0.f23064e.f23477i.f23426k.add(this.f23476h);
            }
            q(this.f23470b.f23064e.f23476h);
            q(this.f23470b.f23064e.f23477i);
            return;
        }
        if (iT1 != -1) {
            this.f23476h.f23427l.add(this.f23470b.f23057a0.f23066f.f23476h);
            this.f23470b.f23057a0.f23066f.f23476h.f23426k.add(this.f23476h);
            this.f23476h.f23421f = iT1;
        } else if (iU1 != -1) {
            this.f23476h.f23427l.add(this.f23470b.f23057a0.f23066f.f23477i);
            this.f23470b.f23057a0.f23066f.f23477i.f23426k.add(this.f23476h);
            this.f23476h.f23421f = -iU1;
        } else {
            f fVar2 = this.f23476h;
            fVar2.f23417b = true;
            fVar2.f23427l.add(this.f23470b.f23057a0.f23066f.f23477i);
            this.f23470b.f23057a0.f23066f.f23477i.f23426k.add(this.f23476h);
        }
        q(this.f23470b.f23066f.f23476h);
        q(this.f23470b.f23066f.f23477i);
    }

    @Override // w.p
    public void e() {
        if (((v.h) this.f23470b).s1() == 1) {
            this.f23470b.m1(this.f23476h.f23422g);
        } else {
            this.f23470b.n1(this.f23476h.f23422g);
        }
    }

    @Override // w.p
    void f() {
        this.f23476h.c();
    }

    @Override // w.p
    boolean m() {
        return false;
    }
}
