package x2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends n {
    @Override // x2.d
    public final void a(d dVar) {
        e eVar = this.f15565h;
        if (eVar.f15536c && !eVar.f15542j) {
            eVar.d((int) ((((e) eVar.f15544l.get(0)).f15540g * ((w2.g) this.f15559b).f15207p0) + 0.5f));
        }
    }

    @Override // x2.n
    public final void d() {
        w2.e eVar = this.f15559b;
        w2.g gVar = (w2.g) eVar;
        int i = gVar.f15208q0;
        int i3 = gVar.f15209r0;
        int i10 = gVar.f15211t0;
        e eVar2 = this.f15565h;
        if (i10 == 1) {
            if (i != -1) {
                eVar2.f15544l.add(eVar.S.f15164d.f15565h);
                this.f15559b.S.f15164d.f15565h.f15543k.add(eVar2);
                eVar2.f15539f = i;
            } else if (i3 != -1) {
                eVar2.f15544l.add(eVar.S.f15164d.i);
                this.f15559b.S.f15164d.i.f15543k.add(eVar2);
                eVar2.f15539f = -i3;
            } else {
                eVar2.f15535b = true;
                eVar2.f15544l.add(eVar.S.f15164d.i);
                this.f15559b.S.f15164d.i.f15543k.add(eVar2);
            }
            m(this.f15559b.f15164d.f15565h);
            m(this.f15559b.f15164d.i);
            return;
        }
        if (i != -1) {
            eVar2.f15544l.add(eVar.S.f15166e.f15565h);
            this.f15559b.S.f15166e.f15565h.f15543k.add(eVar2);
            eVar2.f15539f = i;
        } else if (i3 != -1) {
            eVar2.f15544l.add(eVar.S.f15166e.i);
            this.f15559b.S.f15166e.i.f15543k.add(eVar2);
            eVar2.f15539f = -i3;
        } else {
            eVar2.f15535b = true;
            eVar2.f15544l.add(eVar.S.f15166e.i);
            this.f15559b.S.f15166e.i.f15543k.add(eVar2);
        }
        m(this.f15559b.f15166e.f15565h);
        m(this.f15559b.f15166e.i);
    }

    @Override // x2.n
    public final void e() {
        w2.e eVar = this.f15559b;
        int i = ((w2.g) eVar).f15211t0;
        e eVar2 = this.f15565h;
        if (i == 1) {
            eVar.X = eVar2.f15540g;
        } else {
            eVar.Y = eVar2.f15540g;
        }
    }

    @Override // x2.n
    public final void f() {
        this.f15565h.c();
    }

    @Override // x2.n
    public final boolean k() {
        return false;
    }

    public final void m(e eVar) {
        e eVar2 = this.f15565h;
        eVar2.f15543k.add(eVar);
        eVar.f15544l.add(eVar2);
    }
}
