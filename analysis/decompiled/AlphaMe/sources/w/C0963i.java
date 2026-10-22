package w;

import v.C0944d;
import v.C0948h;

/* renamed from: w.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0963i extends p {
    @Override // w.InterfaceC0958d
    public final void a(InterfaceC0958d interfaceC0958d) {
        C0960f c0960f = this.f15792h;
        if (c0960f.f15754c && !c0960f.f15761j) {
            c0960f.d((int) ((((C0960f) c0960f.f15763l.get(0)).f15758g * ((C0948h) this.f15786b).f15665q0) + 0.5f));
        }
    }

    @Override // w.p
    public final void d() {
        C0944d c0944d = this.f15786b;
        C0948h c0948h = (C0948h) c0944d;
        int i4 = c0948h.f15666r0;
        int i5 = c0948h.f15667s0;
        int i6 = c0948h.f15669u0;
        C0960f c0960f = this.f15792h;
        if (i6 == 1) {
            if (i4 != -1) {
                c0960f.f15763l.add(c0944d.T.f15555d.f15792h);
                this.f15786b.T.f15555d.f15792h.f15762k.add(c0960f);
                c0960f.f15757f = i4;
            } else if (i5 != -1) {
                c0960f.f15763l.add(c0944d.T.f15555d.f15793i);
                this.f15786b.T.f15555d.f15793i.f15762k.add(c0960f);
                c0960f.f15757f = -i5;
            } else {
                c0960f.f15753b = true;
                c0960f.f15763l.add(c0944d.T.f15555d.f15793i);
                this.f15786b.T.f15555d.f15793i.f15762k.add(c0960f);
            }
            m(this.f15786b.f15555d.f15792h);
            m(this.f15786b.f15555d.f15793i);
            return;
        }
        if (i4 != -1) {
            c0960f.f15763l.add(c0944d.T.f15557e.f15792h);
            this.f15786b.T.f15557e.f15792h.f15762k.add(c0960f);
            c0960f.f15757f = i4;
        } else if (i5 != -1) {
            c0960f.f15763l.add(c0944d.T.f15557e.f15793i);
            this.f15786b.T.f15557e.f15793i.f15762k.add(c0960f);
            c0960f.f15757f = -i5;
        } else {
            c0960f.f15753b = true;
            c0960f.f15763l.add(c0944d.T.f15557e.f15793i);
            this.f15786b.T.f15557e.f15793i.f15762k.add(c0960f);
        }
        m(this.f15786b.f15557e.f15792h);
        m(this.f15786b.f15557e.f15793i);
    }

    @Override // w.p
    public final void e() {
        C0944d c0944d = this.f15786b;
        int i4 = ((C0948h) c0944d).f15669u0;
        C0960f c0960f = this.f15792h;
        if (i4 == 1) {
            c0944d.f15547Y = c0960f.f15758g;
        } else {
            c0944d.f15548Z = c0960f.f15758g;
        }
    }

    @Override // w.p
    public final void f() {
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
