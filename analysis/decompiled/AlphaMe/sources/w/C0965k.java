package w;

import v.C0943c;
import v.C0944d;
import v.InterfaceC0949i;

/* renamed from: w.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0965k extends p {

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f15766k = new int[2];

    public static void m(int[] iArr, int i4, int i5, int i6, int i7, float f4, int i8) {
        int i9 = i5 - i4;
        int i10 = i7 - i6;
        if (i8 != -1) {
            if (i8 == 0) {
                iArr[0] = (int) ((i10 * f4) + 0.5f);
                iArr[1] = i10;
                return;
            } else {
                if (i8 != 1) {
                    return;
                }
                iArr[0] = i9;
                iArr[1] = (int) ((i9 * f4) + 0.5f);
                return;
            }
        }
        int i11 = (int) ((i10 * f4) + 0.5f);
        int i12 = (int) ((i9 / f4) + 0.5f);
        if (i11 <= i9) {
            iArr[0] = i11;
            iArr[1] = i10;
        } else if (i12 <= i10) {
            iArr[0] = i9;
            iArr[1] = i12;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0267  */
    @Override // w.InterfaceC0958d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(w.InterfaceC0958d r24) {
        /*
            Method dump skipped, instructions count: 907
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w.C0965k.a(w.d):void");
    }

    @Override // w.p
    public final void d() {
        C0944d c0944d;
        C0944d c0944d2;
        int i4;
        C0944d c0944d3;
        C0944d c0944d4;
        int i5;
        C0944d c0944d5 = this.f15786b;
        boolean z4 = c0944d5.f15549a;
        C0961g c0961g = this.f15789e;
        if (z4) {
            c0961g.d(c0944d5.r());
        }
        boolean z5 = c0961g.f15761j;
        C0960f c0960f = this.f15793i;
        C0960f c0960f2 = this.f15792h;
        if (!z5) {
            C0944d c0944d6 = this.f15786b;
            int i6 = c0944d6.f15580p0[0];
            this.f15788d = i6;
            if (i6 != 3) {
                if (i6 == 4 && (c0944d4 = c0944d6.T) != null && ((i5 = c0944d4.f15580p0[0]) == 1 || i5 == 4)) {
                    int iR = (c0944d4.r() - this.f15786b.f15532I.e()) - this.f15786b.f15534K.e();
                    p.b(c0960f2, c0944d4.f15555d.f15792h, this.f15786b.f15532I.e());
                    p.b(c0960f, c0944d4.f15555d.f15793i, -this.f15786b.f15534K.e());
                    c0961g.d(iR);
                    return;
                }
                if (i6 == 1) {
                    c0961g.d(c0944d6.r());
                }
            }
        } else if (this.f15788d == 4 && (c0944d2 = (c0944d = this.f15786b).T) != null && ((i4 = c0944d2.f15580p0[0]) == 1 || i4 == 4)) {
            p.b(c0960f2, c0944d2.f15555d.f15792h, c0944d.f15532I.e());
            p.b(c0960f, c0944d2.f15555d.f15793i, -this.f15786b.f15534K.e());
            return;
        }
        if (c0961g.f15761j) {
            C0944d c0944d7 = this.f15786b;
            if (c0944d7.f15549a) {
                C0943c[] c0943cArr = c0944d7.f15540Q;
                C0943c c0943c = c0943cArr[0];
                C0943c c0943c2 = c0943c.f15520f;
                if (c0943c2 != null && c0943cArr[1].f15520f != null) {
                    if (c0944d7.y()) {
                        c0960f2.f15757f = this.f15786b.f15540Q[0].e();
                        c0960f.f15757f = -this.f15786b.f15540Q[1].e();
                        return;
                    }
                    C0960f c0960fH = p.h(this.f15786b.f15540Q[0]);
                    if (c0960fH != null) {
                        p.b(c0960f2, c0960fH, this.f15786b.f15540Q[0].e());
                    }
                    C0960f c0960fH2 = p.h(this.f15786b.f15540Q[1]);
                    if (c0960fH2 != null) {
                        p.b(c0960f, c0960fH2, -this.f15786b.f15540Q[1].e());
                    }
                    c0960f2.f15753b = true;
                    c0960f.f15753b = true;
                    return;
                }
                if (c0943c2 != null) {
                    C0960f c0960fH3 = p.h(c0943c);
                    if (c0960fH3 != null) {
                        p.b(c0960f2, c0960fH3, this.f15786b.f15540Q[0].e());
                        p.b(c0960f, c0960f2, c0961g.f15758g);
                        return;
                    }
                    return;
                }
                C0943c c0943c3 = c0943cArr[1];
                if (c0943c3.f15520f != null) {
                    C0960f c0960fH4 = p.h(c0943c3);
                    if (c0960fH4 != null) {
                        p.b(c0960f, c0960fH4, -this.f15786b.f15540Q[1].e());
                        p.b(c0960f2, c0960f, -c0961g.f15758g);
                        return;
                    }
                    return;
                }
                if ((c0944d7 instanceof InterfaceC0949i) || c0944d7.T == null || c0944d7.j(7).f15520f != null) {
                    return;
                }
                C0944d c0944d8 = this.f15786b;
                p.b(c0960f2, c0944d8.T.f15555d.f15792h, c0944d8.s());
                p.b(c0960f, c0960f2, c0961g.f15758g);
                return;
            }
        }
        if (this.f15788d == 3) {
            C0944d c0944d9 = this.f15786b;
            int i7 = c0944d9.f15582r;
            if (i7 == 2) {
                C0944d c0944d10 = c0944d9.T;
                if (c0944d10 != null) {
                    C0961g c0961g2 = c0944d10.f15557e.f15789e;
                    c0961g.f15763l.add(c0961g2);
                    c0961g2.f15762k.add(c0961g);
                    c0961g.f15753b = true;
                    c0961g.f15762k.add(c0960f2);
                    c0961g.f15762k.add(c0960f);
                }
            } else if (i7 == 3) {
                if (c0944d9.f15583s == 3) {
                    c0960f2.f15752a = this;
                    c0960f.f15752a = this;
                    C0967m c0967m = c0944d9.f15557e;
                    c0967m.f15792h.f15752a = this;
                    c0967m.f15793i.f15752a = this;
                    c0961g.f15752a = this;
                    if (c0944d9.z()) {
                        c0961g.f15763l.add(this.f15786b.f15557e.f15789e);
                        this.f15786b.f15557e.f15789e.f15762k.add(c0961g);
                        C0967m c0967m2 = this.f15786b.f15557e;
                        c0967m2.f15789e.f15752a = this;
                        c0961g.f15763l.add(c0967m2.f15792h);
                        c0961g.f15763l.add(this.f15786b.f15557e.f15793i);
                        this.f15786b.f15557e.f15792h.f15762k.add(c0961g);
                        this.f15786b.f15557e.f15793i.f15762k.add(c0961g);
                    } else if (this.f15786b.y()) {
                        this.f15786b.f15557e.f15789e.f15763l.add(c0961g);
                        c0961g.f15762k.add(this.f15786b.f15557e.f15789e);
                    } else {
                        this.f15786b.f15557e.f15789e.f15763l.add(c0961g);
                    }
                } else {
                    C0961g c0961g3 = c0944d9.f15557e.f15789e;
                    c0961g.f15763l.add(c0961g3);
                    c0961g3.f15762k.add(c0961g);
                    this.f15786b.f15557e.f15792h.f15762k.add(c0961g);
                    this.f15786b.f15557e.f15793i.f15762k.add(c0961g);
                    c0961g.f15753b = true;
                    c0961g.f15762k.add(c0960f2);
                    c0961g.f15762k.add(c0960f);
                    c0960f2.f15763l.add(c0961g);
                    c0960f.f15763l.add(c0961g);
                }
            }
        }
        C0944d c0944d11 = this.f15786b;
        C0943c[] c0943cArr2 = c0944d11.f15540Q;
        C0943c c0943c4 = c0943cArr2[0];
        C0943c c0943c5 = c0943c4.f15520f;
        if (c0943c5 != null && c0943cArr2[1].f15520f != null) {
            if (c0944d11.y()) {
                c0960f2.f15757f = this.f15786b.f15540Q[0].e();
                c0960f.f15757f = -this.f15786b.f15540Q[1].e();
                return;
            }
            C0960f c0960fH5 = p.h(this.f15786b.f15540Q[0]);
            C0960f c0960fH6 = p.h(this.f15786b.f15540Q[1]);
            if (c0960fH5 != null) {
                c0960fH5.b(this);
            }
            if (c0960fH6 != null) {
                c0960fH6.b(this);
            }
            this.f15794j = 4;
            return;
        }
        if (c0943c5 != null) {
            C0960f c0960fH7 = p.h(c0943c4);
            if (c0960fH7 != null) {
                p.b(c0960f2, c0960fH7, this.f15786b.f15540Q[0].e());
                c(c0960f, c0960f2, 1, c0961g);
                return;
            }
            return;
        }
        C0943c c0943c6 = c0943cArr2[1];
        if (c0943c6.f15520f != null) {
            C0960f c0960fH8 = p.h(c0943c6);
            if (c0960fH8 != null) {
                p.b(c0960f, c0960fH8, -this.f15786b.f15540Q[1].e());
                c(c0960f2, c0960f, -1, c0961g);
                return;
            }
            return;
        }
        if ((c0944d11 instanceof InterfaceC0949i) || (c0944d3 = c0944d11.T) == null) {
            return;
        }
        p.b(c0960f2, c0944d3.f15555d.f15792h, c0944d11.s());
        c(c0960f, c0960f2, 1, c0961g);
    }

    @Override // w.p
    public final void e() {
        C0960f c0960f = this.f15792h;
        if (c0960f.f15761j) {
            this.f15786b.f15547Y = c0960f.f15758g;
        }
    }

    @Override // w.p
    public final void f() {
        this.f15787c = null;
        this.f15792h.c();
        this.f15793i.c();
        this.f15789e.c();
        this.f15791g = false;
    }

    @Override // w.p
    public final boolean k() {
        return this.f15788d != 3 || this.f15786b.f15582r == 0;
    }

    public final void n() {
        this.f15791g = false;
        C0960f c0960f = this.f15792h;
        c0960f.c();
        c0960f.f15761j = false;
        C0960f c0960f2 = this.f15793i;
        c0960f2.c();
        c0960f2.f15761j = false;
        this.f15789e.f15761j = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.f15786b.f15564h0;
    }
}
