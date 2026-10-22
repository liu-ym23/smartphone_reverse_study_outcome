package w;

import java.util.ArrayList;
import java.util.Iterator;
import v.C0943c;
import v.C0944d;
import v.C0945e;

/* renamed from: w.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0957c extends p {

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f15742k;

    /* renamed from: l, reason: collision with root package name */
    public int f15743l;

    public C0957c(int i4, C0944d c0944d) {
        C0944d c0944d2;
        super(c0944d);
        this.f15742k = new ArrayList();
        this.f15790f = i4;
        C0944d c0944d3 = this.f15786b;
        C0944d c0944dN = c0944d3.n(i4);
        while (true) {
            c0944d2 = c0944d3;
            c0944d3 = c0944dN;
            if (c0944d3 == null) {
                break;
            } else {
                c0944dN = c0944d3.n(this.f15790f);
            }
        }
        this.f15786b = c0944d2;
        int i5 = this.f15790f;
        p pVar = i5 == 0 ? c0944d2.f15555d : i5 == 1 ? c0944d2.f15557e : null;
        ArrayList arrayList = this.f15742k;
        arrayList.add(pVar);
        C0944d c0944dM = c0944d2.m(this.f15790f);
        while (c0944dM != null) {
            int i6 = this.f15790f;
            arrayList.add(i6 == 0 ? c0944dM.f15555d : i6 == 1 ? c0944dM.f15557e : null);
            c0944dM = c0944dM.m(this.f15790f);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            p pVar2 = (p) it.next();
            int i7 = this.f15790f;
            if (i7 == 0) {
                pVar2.f15786b.f15551b = this;
            } else if (i7 == 1) {
                pVar2.f15786b.f15553c = this;
            }
        }
        if (this.f15790f == 0 && ((C0945e) this.f15786b.T).f15607v0 && arrayList.size() > 1) {
            this.f15786b = ((p) arrayList.get(arrayList.size() - 1)).f15786b;
        }
        this.f15743l = this.f15790f == 0 ? this.f15786b.f15566i0 : this.f15786b.f15568j0;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0153  */
    @Override // w.InterfaceC0958d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(w.InterfaceC0958d r27) {
        /*
            Method dump skipped, instructions count: 967
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w.C0957c.a(w.d):void");
    }

    @Override // w.p
    public final void d() {
        ArrayList arrayList = this.f15742k;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((p) it.next()).d();
        }
        int size = arrayList.size();
        if (size < 1) {
            return;
        }
        C0944d c0944d = ((p) arrayList.get(0)).f15786b;
        C0944d c0944d2 = ((p) arrayList.get(size - 1)).f15786b;
        int i4 = this.f15790f;
        C0960f c0960f = this.f15793i;
        C0960f c0960f2 = this.f15792h;
        if (i4 == 0) {
            C0943c c0943c = c0944d.f15532I;
            C0943c c0943c2 = c0944d2.f15534K;
            C0960f c0960fI = p.i(c0943c, 0);
            int iE = c0943c.e();
            C0944d c0944dM = m();
            if (c0944dM != null) {
                iE = c0944dM.f15532I.e();
            }
            if (c0960fI != null) {
                p.b(c0960f2, c0960fI, iE);
            }
            C0960f c0960fI2 = p.i(c0943c2, 0);
            int iE2 = c0943c2.e();
            C0944d c0944dN = n();
            if (c0944dN != null) {
                iE2 = c0944dN.f15534K.e();
            }
            if (c0960fI2 != null) {
                p.b(c0960f, c0960fI2, -iE2);
            }
        } else {
            C0943c c0943c3 = c0944d.f15533J;
            C0943c c0943c4 = c0944d2.f15535L;
            C0960f c0960fI3 = p.i(c0943c3, 1);
            int iE3 = c0943c3.e();
            C0944d c0944dM2 = m();
            if (c0944dM2 != null) {
                iE3 = c0944dM2.f15533J.e();
            }
            if (c0960fI3 != null) {
                p.b(c0960f2, c0960fI3, iE3);
            }
            C0960f c0960fI4 = p.i(c0943c4, 1);
            int iE4 = c0943c4.e();
            C0944d c0944dN2 = n();
            if (c0944dN2 != null) {
                iE4 = c0944dN2.f15535L.e();
            }
            if (c0960fI4 != null) {
                p.b(c0960f, c0960fI4, -iE4);
            }
        }
        c0960f2.f15752a = this;
        c0960f.f15752a = this;
    }

    @Override // w.p
    public final void e() {
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f15742k;
            if (i4 >= arrayList.size()) {
                return;
            }
            ((p) arrayList.get(i4)).e();
            i4++;
        }
    }

    @Override // w.p
    public final void f() {
        this.f15787c = null;
        Iterator it = this.f15742k.iterator();
        while (it.hasNext()) {
            ((p) it.next()).f();
        }
    }

    @Override // w.p
    public final long j() {
        ArrayList arrayList = this.f15742k;
        int size = arrayList.size();
        long j4 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            j4 = r4.f15793i.f15757f + ((p) arrayList.get(i4)).j() + j4 + r4.f15792h.f15757f;
        }
        return j4;
    }

    @Override // w.p
    public final boolean k() {
        ArrayList arrayList = this.f15742k;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (!((p) arrayList.get(i4)).k()) {
                return false;
            }
        }
        return true;
    }

    public final C0944d m() {
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f15742k;
            if (i4 >= arrayList.size()) {
                return null;
            }
            C0944d c0944d = ((p) arrayList.get(i4)).f15786b;
            if (c0944d.f15562g0 != 8) {
                return c0944d;
            }
            i4++;
        }
    }

    public final C0944d n() {
        ArrayList arrayList = this.f15742k;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            C0944d c0944d = ((p) arrayList.get(size)).f15786b;
            if (c0944d.f15562g0 != 8) {
                return c0944d;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.f15790f == 0 ? "horizontal : " : "vertical : ");
        Iterator it = this.f15742k.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            sb.append("<");
            sb.append(pVar);
            sb.append("> ");
        }
        return sb.toString();
    }
}
