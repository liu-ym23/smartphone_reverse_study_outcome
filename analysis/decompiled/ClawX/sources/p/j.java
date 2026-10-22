package p;

import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j extends o {
    @Override // p.d
    public final void a(d dVar) {
        o.a aVar = (o.a) this.f4634b;
        int i8 = aVar.f4184r0;
        f fVar = this.f4639h;
        ArrayList arrayList = fVar.f4620l;
        int size = arrayList.size();
        int i9 = 0;
        int i10 = -1;
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            int i12 = ((f) obj).f4615g;
            if (i10 == -1 || i12 < i10) {
                i10 = i12;
            }
            if (i9 < i12) {
                i9 = i12;
            }
        }
        if (i8 == 0 || i8 == 2) {
            fVar.d(i10 + aVar.f4186t0);
        } else {
            fVar.d(i9 + aVar.f4186t0);
        }
    }

    @Override // p.o
    public final void d() {
        o.d dVar = this.f4634b;
        if (dVar instanceof o.a) {
            f fVar = this.f4639h;
            fVar.f4611b = true;
            ArrayList arrayList = fVar.f4620l;
            o.a aVar = (o.a) dVar;
            int i8 = aVar.f4184r0;
            boolean z = aVar.f4185s0;
            int i9 = 0;
            if (i8 == 0) {
                fVar.f4613e = 4;
                while (i9 < aVar.f4294q0) {
                    o.d dVar2 = aVar.f4293p0[i9];
                    if (z || dVar2.f4222f0 != 8) {
                        f fVar2 = dVar2.d.f4639h;
                        fVar2.f4619k.add(fVar);
                        arrayList.add(fVar2);
                    }
                    i9++;
                }
                m(this.f4634b.d.f4639h);
                m(this.f4634b.d.f4640i);
                return;
            }
            if (i8 == 1) {
                fVar.f4613e = 5;
                while (i9 < aVar.f4294q0) {
                    o.d dVar3 = aVar.f4293p0[i9];
                    if (z || dVar3.f4222f0 != 8) {
                        f fVar3 = dVar3.d.f4640i;
                        fVar3.f4619k.add(fVar);
                        arrayList.add(fVar3);
                    }
                    i9++;
                }
                m(this.f4634b.d.f4639h);
                m(this.f4634b.d.f4640i);
                return;
            }
            if (i8 == 2) {
                fVar.f4613e = 6;
                while (i9 < aVar.f4294q0) {
                    o.d dVar4 = aVar.f4293p0[i9];
                    if (z || dVar4.f4222f0 != 8) {
                        f fVar4 = dVar4.f4219e.f4639h;
                        fVar4.f4619k.add(fVar);
                        arrayList.add(fVar4);
                    }
                    i9++;
                }
                m(this.f4634b.f4219e.f4639h);
                m(this.f4634b.f4219e.f4640i);
                return;
            }
            if (i8 != 3) {
                return;
            }
            fVar.f4613e = 7;
            while (i9 < aVar.f4294q0) {
                o.d dVar5 = aVar.f4293p0[i9];
                if (z || dVar5.f4222f0 != 8) {
                    f fVar5 = dVar5.f4219e.f4640i;
                    fVar5.f4619k.add(fVar);
                    arrayList.add(fVar5);
                }
                i9++;
            }
            m(this.f4634b.f4219e.f4639h);
            m(this.f4634b.f4219e.f4640i);
        }
    }

    @Override // p.o
    public final void e() {
        o.d dVar = this.f4634b;
        if (dVar instanceof o.a) {
            int i8 = ((o.a) dVar).f4184r0;
            f fVar = this.f4639h;
            if (i8 == 0 || i8 == 1) {
                dVar.X = fVar.f4615g;
            } else {
                dVar.Y = fVar.f4615g;
            }
        }
    }

    @Override // p.o
    public final void f() {
        this.f4635c = null;
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
