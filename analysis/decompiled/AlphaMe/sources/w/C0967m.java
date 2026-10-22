package w;

import com.stepos.alphame.utils.Property;
import v.C0943c;
import v.C0944d;
import v.InterfaceC0949i;

/* renamed from: w.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0967m extends p {

    /* renamed from: k, reason: collision with root package name */
    public C0960f f15769k;

    /* renamed from: l, reason: collision with root package name */
    public C0955a f15770l;

    @Override // w.InterfaceC0958d
    public final void a(InterfaceC0958d interfaceC0958d) {
        float f4;
        float f5;
        float f6;
        int i4;
        if (t.h.a(this.f15794j) == 3) {
            C0944d c0944d = this.f15786b;
            l(c0944d.f15533J, c0944d.f15535L, 1);
            return;
        }
        C0961g c0961g = this.f15789e;
        if (c0961g.f15754c && !c0961g.f15761j && this.f15788d == 3) {
            C0944d c0944d2 = this.f15786b;
            int i5 = c0944d2.f15583s;
            if (i5 == 2) {
                C0944d c0944d3 = c0944d2.T;
                if (c0944d3 != null) {
                    if (c0944d3.f15557e.f15789e.f15761j) {
                        c0961g.d((int) ((r5.f15758g * c0944d2.f15590z) + 0.5f));
                    }
                }
            } else if (i5 == 3) {
                C0961g c0961g2 = c0944d2.f15555d.f15789e;
                if (c0961g2.f15761j) {
                    int i6 = c0944d2.f15546X;
                    if (i6 == -1) {
                        f4 = c0961g2.f15758g;
                        f5 = c0944d2.f15545W;
                    } else if (i6 == 0) {
                        f6 = c0961g2.f15758g * c0944d2.f15545W;
                        i4 = (int) (f6 + 0.5f);
                        c0961g.d(i4);
                    } else if (i6 != 1) {
                        i4 = 0;
                        c0961g.d(i4);
                    } else {
                        f4 = c0961g2.f15758g;
                        f5 = c0944d2.f15545W;
                    }
                    f6 = f4 / f5;
                    i4 = (int) (f6 + 0.5f);
                    c0961g.d(i4);
                }
            }
        }
        C0960f c0960f = this.f15792h;
        if (c0960f.f15754c) {
            C0960f c0960f2 = this.f15793i;
            if (c0960f2.f15754c) {
                if (c0960f.f15761j && c0960f2.f15761j && c0961g.f15761j) {
                    return;
                }
                if (!c0961g.f15761j && this.f15788d == 3) {
                    C0944d c0944d4 = this.f15786b;
                    if (c0944d4.f15582r == 0 && !c0944d4.z()) {
                        C0960f c0960f3 = (C0960f) c0960f.f15763l.get(0);
                        C0960f c0960f4 = (C0960f) c0960f2.f15763l.get(0);
                        int i7 = c0960f3.f15758g + c0960f.f15757f;
                        int i8 = c0960f4.f15758g + c0960f2.f15757f;
                        c0960f.d(i7);
                        c0960f2.d(i8);
                        c0961g.d(i8 - i7);
                        return;
                    }
                }
                if (!c0961g.f15761j && this.f15788d == 3 && this.f15785a == 1 && c0960f.f15763l.size() > 0 && c0960f2.f15763l.size() > 0) {
                    C0960f c0960f5 = (C0960f) c0960f.f15763l.get(0);
                    int i9 = (((C0960f) c0960f2.f15763l.get(0)).f15758g + c0960f2.f15757f) - (c0960f5.f15758g + c0960f.f15757f);
                    int i10 = c0961g.f15764m;
                    if (i9 < i10) {
                        c0961g.d(i9);
                    } else {
                        c0961g.d(i10);
                    }
                }
                if (c0961g.f15761j && c0960f.f15763l.size() > 0 && c0960f2.f15763l.size() > 0) {
                    C0960f c0960f6 = (C0960f) c0960f.f15763l.get(0);
                    C0960f c0960f7 = (C0960f) c0960f2.f15763l.get(0);
                    int i11 = c0960f6.f15758g;
                    int i12 = c0960f.f15757f + i11;
                    int i13 = c0960f7.f15758g;
                    int i14 = c0960f2.f15757f + i13;
                    float f7 = this.f15786b.f15558e0;
                    if (c0960f6 == c0960f7) {
                        f7 = 0.5f;
                    } else {
                        i11 = i12;
                        i13 = i14;
                    }
                    c0960f.d((int) ((((i13 - i11) - c0961g.f15758g) * f7) + i11 + 0.5f));
                    c0960f2.d(c0960f.f15758g + c0961g.f15758g);
                }
            }
        }
    }

    @Override // w.p
    public final void d() {
        C0944d c0944d;
        C0944d c0944d2;
        C0944d c0944d3;
        C0944d c0944d4;
        C0944d c0944d5 = this.f15786b;
        boolean z4 = c0944d5.f15549a;
        C0961g c0961g = this.f15789e;
        if (z4) {
            c0961g.d(c0944d5.l());
        }
        boolean z5 = c0961g.f15761j;
        C0960f c0960f = this.f15793i;
        C0960f c0960f2 = this.f15792h;
        if (!z5) {
            C0944d c0944d6 = this.f15786b;
            this.f15788d = c0944d6.f15580p0[1];
            if (c0944d6.f15528E) {
                this.f15770l = new C0955a(this);
            }
            int i4 = this.f15788d;
            if (i4 != 3) {
                if (i4 == 4 && (c0944d4 = this.f15786b.T) != null && c0944d4.f15580p0[1] == 1) {
                    int iL = (c0944d4.l() - this.f15786b.f15533J.e()) - this.f15786b.f15535L.e();
                    p.b(c0960f2, c0944d4.f15557e.f15792h, this.f15786b.f15533J.e());
                    p.b(c0960f, c0944d4.f15557e.f15793i, -this.f15786b.f15535L.e());
                    c0961g.d(iL);
                    return;
                }
                if (i4 == 1) {
                    c0961g.d(this.f15786b.l());
                }
            }
        } else if (this.f15788d == 4 && (c0944d2 = (c0944d = this.f15786b).T) != null && c0944d2.f15580p0[1] == 1) {
            p.b(c0960f2, c0944d2.f15557e.f15792h, c0944d.f15533J.e());
            p.b(c0960f, c0944d2.f15557e.f15793i, -this.f15786b.f15535L.e());
            return;
        }
        boolean z6 = c0961g.f15761j;
        C0960f c0960f3 = this.f15769k;
        if (z6) {
            C0944d c0944d7 = this.f15786b;
            if (c0944d7.f15549a) {
                C0943c[] c0943cArr = c0944d7.f15540Q;
                C0943c c0943c = c0943cArr[2];
                C0943c c0943c2 = c0943c.f15520f;
                if (c0943c2 != null && c0943cArr[3].f15520f != null) {
                    if (c0944d7.z()) {
                        c0960f2.f15757f = this.f15786b.f15540Q[2].e();
                        c0960f.f15757f = -this.f15786b.f15540Q[3].e();
                    } else {
                        C0960f c0960fH = p.h(this.f15786b.f15540Q[2]);
                        if (c0960fH != null) {
                            p.b(c0960f2, c0960fH, this.f15786b.f15540Q[2].e());
                        }
                        C0960f c0960fH2 = p.h(this.f15786b.f15540Q[3]);
                        if (c0960fH2 != null) {
                            p.b(c0960f, c0960fH2, -this.f15786b.f15540Q[3].e());
                        }
                        c0960f2.f15753b = true;
                        c0960f.f15753b = true;
                    }
                    C0944d c0944d8 = this.f15786b;
                    if (c0944d8.f15528E) {
                        p.b(c0960f3, c0960f2, c0944d8.f15550a0);
                        return;
                    }
                    return;
                }
                if (c0943c2 != null) {
                    C0960f c0960fH3 = p.h(c0943c);
                    if (c0960fH3 != null) {
                        p.b(c0960f2, c0960fH3, this.f15786b.f15540Q[2].e());
                        p.b(c0960f, c0960f2, c0961g.f15758g);
                        C0944d c0944d9 = this.f15786b;
                        if (c0944d9.f15528E) {
                            p.b(c0960f3, c0960f2, c0944d9.f15550a0);
                            return;
                        }
                        return;
                    }
                    return;
                }
                C0943c c0943c3 = c0943cArr[3];
                if (c0943c3.f15520f != null) {
                    C0960f c0960fH4 = p.h(c0943c3);
                    if (c0960fH4 != null) {
                        p.b(c0960f, c0960fH4, -this.f15786b.f15540Q[3].e());
                        p.b(c0960f2, c0960f, -c0961g.f15758g);
                    }
                    C0944d c0944d10 = this.f15786b;
                    if (c0944d10.f15528E) {
                        p.b(c0960f3, c0960f2, c0944d10.f15550a0);
                        return;
                    }
                    return;
                }
                C0943c c0943c4 = c0943cArr[4];
                if (c0943c4.f15520f != null) {
                    C0960f c0960fH5 = p.h(c0943c4);
                    if (c0960fH5 != null) {
                        p.b(c0960f3, c0960fH5, 0);
                        p.b(c0960f2, c0960f3, -this.f15786b.f15550a0);
                        p.b(c0960f, c0960f2, c0961g.f15758g);
                        return;
                    }
                    return;
                }
                if ((c0944d7 instanceof InterfaceC0949i) || c0944d7.T == null || c0944d7.j(7).f15520f != null) {
                    return;
                }
                C0944d c0944d11 = this.f15786b;
                p.b(c0960f2, c0944d11.T.f15557e.f15792h, c0944d11.t());
                p.b(c0960f, c0960f2, c0961g.f15758g);
                C0944d c0944d12 = this.f15786b;
                if (c0944d12.f15528E) {
                    p.b(c0960f3, c0960f2, c0944d12.f15550a0);
                    return;
                }
                return;
            }
        }
        if (z6 || this.f15788d != 3) {
            c0961g.b(this);
        } else {
            C0944d c0944d13 = this.f15786b;
            int i5 = c0944d13.f15583s;
            if (i5 == 2) {
                C0944d c0944d14 = c0944d13.T;
                if (c0944d14 != null) {
                    C0961g c0961g2 = c0944d14.f15557e.f15789e;
                    c0961g.f15763l.add(c0961g2);
                    c0961g2.f15762k.add(c0961g);
                    c0961g.f15753b = true;
                    c0961g.f15762k.add(c0960f2);
                    c0961g.f15762k.add(c0960f);
                }
            } else if (i5 == 3 && !c0944d13.z()) {
                C0944d c0944d15 = this.f15786b;
                if (c0944d15.f15582r != 3) {
                    C0961g c0961g3 = c0944d15.f15555d.f15789e;
                    c0961g.f15763l.add(c0961g3);
                    c0961g3.f15762k.add(c0961g);
                    c0961g.f15753b = true;
                    c0961g.f15762k.add(c0960f2);
                    c0961g.f15762k.add(c0960f);
                }
            }
        }
        C0944d c0944d16 = this.f15786b;
        C0943c[] c0943cArr2 = c0944d16.f15540Q;
        C0943c c0943c5 = c0943cArr2[2];
        C0943c c0943c6 = c0943c5.f15520f;
        if (c0943c6 != null && c0943cArr2[3].f15520f != null) {
            if (c0944d16.z()) {
                c0960f2.f15757f = this.f15786b.f15540Q[2].e();
                c0960f.f15757f = -this.f15786b.f15540Q[3].e();
            } else {
                C0960f c0960fH6 = p.h(this.f15786b.f15540Q[2]);
                C0960f c0960fH7 = p.h(this.f15786b.f15540Q[3]);
                if (c0960fH6 != null) {
                    c0960fH6.b(this);
                }
                if (c0960fH7 != null) {
                    c0960fH7.b(this);
                }
                this.f15794j = 4;
            }
            if (this.f15786b.f15528E) {
                c(c0960f3, c0960f2, 1, this.f15770l);
            }
        } else if (c0943c6 != null) {
            C0960f c0960fH8 = p.h(c0943c5);
            if (c0960fH8 != null) {
                p.b(c0960f2, c0960fH8, this.f15786b.f15540Q[2].e());
                c(c0960f, c0960f2, 1, c0961g);
                if (this.f15786b.f15528E) {
                    c(c0960f3, c0960f2, 1, this.f15770l);
                }
                if (this.f15788d == 3) {
                    C0944d c0944d17 = this.f15786b;
                    if (c0944d17.f15545W > Property.DEFAULT_FLOAT_VALUE) {
                        C0965k c0965k = c0944d17.f15555d;
                        if (c0965k.f15788d == 3) {
                            c0965k.f15789e.f15762k.add(c0961g);
                            c0961g.f15763l.add(this.f15786b.f15555d.f15789e);
                            c0961g.f15752a = this;
                        }
                    }
                }
            }
        } else {
            C0943c c0943c7 = c0943cArr2[3];
            if (c0943c7.f15520f != null) {
                C0960f c0960fH9 = p.h(c0943c7);
                if (c0960fH9 != null) {
                    p.b(c0960f, c0960fH9, -this.f15786b.f15540Q[3].e());
                    c(c0960f2, c0960f, -1, c0961g);
                    if (this.f15786b.f15528E) {
                        c(c0960f3, c0960f2, 1, this.f15770l);
                    }
                }
            } else {
                C0943c c0943c8 = c0943cArr2[4];
                if (c0943c8.f15520f != null) {
                    C0960f c0960fH10 = p.h(c0943c8);
                    if (c0960fH10 != null) {
                        p.b(c0960f3, c0960fH10, 0);
                        c(c0960f2, c0960f3, -1, this.f15770l);
                        c(c0960f, c0960f2, 1, c0961g);
                    }
                } else if (!(c0944d16 instanceof InterfaceC0949i) && (c0944d3 = c0944d16.T) != null) {
                    p.b(c0960f2, c0944d3.f15557e.f15792h, c0944d16.t());
                    c(c0960f, c0960f2, 1, c0961g);
                    if (this.f15786b.f15528E) {
                        c(c0960f3, c0960f2, 1, this.f15770l);
                    }
                    if (this.f15788d == 3) {
                        C0944d c0944d18 = this.f15786b;
                        if (c0944d18.f15545W > Property.DEFAULT_FLOAT_VALUE) {
                            C0965k c0965k2 = c0944d18.f15555d;
                            if (c0965k2.f15788d == 3) {
                                c0965k2.f15789e.f15762k.add(c0961g);
                                c0961g.f15763l.add(this.f15786b.f15555d.f15789e);
                                c0961g.f15752a = this;
                            }
                        }
                    }
                }
            }
        }
        if (c0961g.f15763l.size() == 0) {
            c0961g.f15754c = true;
        }
    }

    @Override // w.p
    public final void e() {
        C0960f c0960f = this.f15792h;
        if (c0960f.f15761j) {
            this.f15786b.f15548Z = c0960f.f15758g;
        }
    }

    @Override // w.p
    public final void f() {
        this.f15787c = null;
        this.f15792h.c();
        this.f15793i.c();
        this.f15769k.c();
        this.f15789e.c();
        this.f15791g = false;
    }

    @Override // w.p
    public final boolean k() {
        return this.f15788d != 3 || this.f15786b.f15583s == 0;
    }

    public final void m() {
        this.f15791g = false;
        C0960f c0960f = this.f15792h;
        c0960f.c();
        c0960f.f15761j = false;
        C0960f c0960f2 = this.f15793i;
        c0960f2.c();
        c0960f2.f15761j = false;
        C0960f c0960f3 = this.f15769k;
        c0960f3.c();
        c0960f3.f15761j = false;
        this.f15789e.f15761j = false;
    }

    public final String toString() {
        return "VerticalRun " + this.f15786b.f15564h0;
    }
}
