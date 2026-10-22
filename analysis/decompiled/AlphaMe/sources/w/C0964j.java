package w;

import java.util.Iterator;
import v.C0941a;
import v.C0944d;

/* renamed from: w.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0964j extends p {
    @Override // w.InterfaceC0958d
    public final void a(InterfaceC0958d interfaceC0958d) {
        C0941a c0941a = (C0941a) this.f15786b;
        int i4 = c0941a.f15494s0;
        C0960f c0960f = this.f15792h;
        Iterator it = c0960f.f15763l.iterator();
        int i5 = 0;
        int i6 = -1;
        while (it.hasNext()) {
            int i7 = ((C0960f) it.next()).f15758g;
            if (i6 == -1 || i7 < i6) {
                i6 = i7;
            }
            if (i5 < i7) {
                i5 = i7;
            }
        }
        if (i4 == 0 || i4 == 2) {
            c0960f.d(i6 + c0941a.f15496u0);
        } else {
            c0960f.d(i5 + c0941a.f15496u0);
        }
    }

    @Override // w.p
    public final void d() {
        C0944d c0944d = this.f15786b;
        if (c0944d instanceof C0941a) {
            C0960f c0960f = this.f15792h;
            c0960f.f15753b = true;
            C0941a c0941a = (C0941a) c0944d;
            int i4 = c0941a.f15494s0;
            boolean z4 = c0941a.f15495t0;
            int i5 = 0;
            if (i4 == 0) {
                c0960f.f15756e = 4;
                while (i5 < c0941a.f15672r0) {
                    C0944d c0944d2 = c0941a.f15671q0[i5];
                    if (z4 || c0944d2.f15562g0 != 8) {
                        C0960f c0960f2 = c0944d2.f15555d.f15792h;
                        c0960f2.f15762k.add(c0960f);
                        c0960f.f15763l.add(c0960f2);
                    }
                    i5++;
                }
                m(this.f15786b.f15555d.f15792h);
                m(this.f15786b.f15555d.f15793i);
                return;
            }
            if (i4 == 1) {
                c0960f.f15756e = 5;
                while (i5 < c0941a.f15672r0) {
                    C0944d c0944d3 = c0941a.f15671q0[i5];
                    if (z4 || c0944d3.f15562g0 != 8) {
                        C0960f c0960f3 = c0944d3.f15555d.f15793i;
                        c0960f3.f15762k.add(c0960f);
                        c0960f.f15763l.add(c0960f3);
                    }
                    i5++;
                }
                m(this.f15786b.f15555d.f15792h);
                m(this.f15786b.f15555d.f15793i);
                return;
            }
            if (i4 == 2) {
                c0960f.f15756e = 6;
                while (i5 < c0941a.f15672r0) {
                    C0944d c0944d4 = c0941a.f15671q0[i5];
                    if (z4 || c0944d4.f15562g0 != 8) {
                        C0960f c0960f4 = c0944d4.f15557e.f15792h;
                        c0960f4.f15762k.add(c0960f);
                        c0960f.f15763l.add(c0960f4);
                    }
                    i5++;
                }
                m(this.f15786b.f15557e.f15792h);
                m(this.f15786b.f15557e.f15793i);
                return;
            }
            if (i4 != 3) {
                return;
            }
            c0960f.f15756e = 7;
            while (i5 < c0941a.f15672r0) {
                C0944d c0944d5 = c0941a.f15671q0[i5];
                if (z4 || c0944d5.f15562g0 != 8) {
                    C0960f c0960f5 = c0944d5.f15557e.f15793i;
                    c0960f5.f15762k.add(c0960f);
                    c0960f.f15763l.add(c0960f5);
                }
                i5++;
            }
            m(this.f15786b.f15557e.f15792h);
            m(this.f15786b.f15557e.f15793i);
        }
    }

    @Override // w.p
    public final void e() {
        C0944d c0944d = this.f15786b;
        if (c0944d instanceof C0941a) {
            int i4 = ((C0941a) c0944d).f15494s0;
            C0960f c0960f = this.f15792h;
            if (i4 == 0 || i4 == 1) {
                c0944d.f15547Y = c0960f.f15758g;
            } else {
                c0944d.f15548Z = c0960f.f15758g;
            }
        }
    }

    @Override // w.p
    public final void f() {
        this.f15787c = null;
        this.f15792h.c();
    }

    @Override // w.p
    public final boolean k() {
        return false;
    }

    public final void m(C0960f c0960f) {
        C0960f c0960f2 = this.f15792h;
        c0960f2.f15762k.add(c0960f);
        c0960f.f15763l.add(c0960f2);
    }
}
