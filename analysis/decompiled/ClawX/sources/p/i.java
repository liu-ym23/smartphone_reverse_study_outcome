package p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i extends o {
    @Override // p.d
    public final void a(d dVar) {
        f fVar = this.f4639h;
        if (fVar.f4612c && !fVar.f4618j) {
            fVar.d((int) ((((f) fVar.f4620l.get(0)).f4615g * ((o.h) this.f4634b).f4287p0) + 0.5f));
        }
    }

    @Override // p.o
    public final void d() {
        o.d dVar = this.f4634b;
        o.h hVar = (o.h) dVar;
        int i8 = hVar.f4288q0;
        int i9 = hVar.f4289r0;
        int i10 = hVar.f4291t0;
        f fVar = this.f4639h;
        if (i10 == 1) {
            if (i8 != -1) {
                fVar.f4620l.add(dVar.S.d.f4639h);
                this.f4634b.S.d.f4639h.f4619k.add(fVar);
                fVar.f4614f = i8;
            } else if (i9 != -1) {
                fVar.f4620l.add(dVar.S.d.f4640i);
                this.f4634b.S.d.f4640i.f4619k.add(fVar);
                fVar.f4614f = -i9;
            } else {
                fVar.f4611b = true;
                fVar.f4620l.add(dVar.S.d.f4640i);
                this.f4634b.S.d.f4640i.f4619k.add(fVar);
            }
            m(this.f4634b.d.f4639h);
            m(this.f4634b.d.f4640i);
            return;
        }
        if (i8 != -1) {
            fVar.f4620l.add(dVar.S.f4219e.f4639h);
            this.f4634b.S.f4219e.f4639h.f4619k.add(fVar);
            fVar.f4614f = i8;
        } else if (i9 != -1) {
            fVar.f4620l.add(dVar.S.f4219e.f4640i);
            this.f4634b.S.f4219e.f4640i.f4619k.add(fVar);
            fVar.f4614f = -i9;
        } else {
            fVar.f4611b = true;
            fVar.f4620l.add(dVar.S.f4219e.f4640i);
            this.f4634b.S.f4219e.f4640i.f4619k.add(fVar);
        }
        m(this.f4634b.f4219e.f4639h);
        m(this.f4634b.f4219e.f4640i);
    }

    @Override // p.o
    public final void e() {
        o.d dVar = this.f4634b;
        int i8 = ((o.h) dVar).f4291t0;
        f fVar = this.f4639h;
        if (i8 == 1) {
            dVar.X = fVar.f4615g;
        } else {
            dVar.Y = fVar.f4615g;
        }
    }

    @Override // p.o
    public final void f() {
        this.f4639h.c();
    }

    @Override // p.o
    public final boolean k() {
        return false;
    }

    public final void m(f fVar) {
        f fVar2 = this.f4639h;
        fVar2.f4619k.add(fVar);
        fVar.f4620l.add(fVar2);
    }
}
