package w;

import v.C0943c;
import v.C0944d;

/* loaded from: classes.dex */
public abstract class p implements InterfaceC0958d {

    /* renamed from: a, reason: collision with root package name */
    public int f15785a;

    /* renamed from: b, reason: collision with root package name */
    public C0944d f15786b;

    /* renamed from: c, reason: collision with root package name */
    public C0966l f15787c;

    /* renamed from: d, reason: collision with root package name */
    public int f15788d;

    /* renamed from: e, reason: collision with root package name */
    public final C0961g f15789e = new C0961g(this);

    /* renamed from: f, reason: collision with root package name */
    public int f15790f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15791g = false;

    /* renamed from: h, reason: collision with root package name */
    public final C0960f f15792h = new C0960f(this);

    /* renamed from: i, reason: collision with root package name */
    public final C0960f f15793i = new C0960f(this);

    /* renamed from: j, reason: collision with root package name */
    public int f15794j = 1;

    public p(C0944d c0944d) {
        this.f15786b = c0944d;
    }

    public static void b(C0960f c0960f, C0960f c0960f2, int i4) {
        c0960f.f15763l.add(c0960f2);
        c0960f.f15757f = i4;
        c0960f2.f15762k.add(c0960f);
    }

    public static C0960f h(C0943c c0943c) {
        C0943c c0943c2 = c0943c.f15520f;
        if (c0943c2 == null) {
            return null;
        }
        int iA = t.h.a(c0943c2.f15519e);
        C0944d c0944d = c0943c2.f15518d;
        if (iA == 1) {
            return c0944d.f15555d.f15792h;
        }
        if (iA == 2) {
            return c0944d.f15557e.f15792h;
        }
        if (iA == 3) {
            return c0944d.f15555d.f15793i;
        }
        if (iA == 4) {
            return c0944d.f15557e.f15793i;
        }
        if (iA != 5) {
            return null;
        }
        return c0944d.f15557e.f15769k;
    }

    public static C0960f i(C0943c c0943c, int i4) {
        C0943c c0943c2 = c0943c.f15520f;
        if (c0943c2 == null) {
            return null;
        }
        C0944d c0944d = c0943c2.f15518d;
        p pVar = i4 == 0 ? c0944d.f15555d : c0944d.f15557e;
        int iA = t.h.a(c0943c2.f15519e);
        if (iA == 1 || iA == 2) {
            return pVar.f15792h;
        }
        if (iA == 3 || iA == 4) {
            return pVar.f15793i;
        }
        return null;
    }

    public final void c(C0960f c0960f, C0960f c0960f2, int i4, C0961g c0961g) {
        c0960f.f15763l.add(c0960f2);
        c0960f.f15763l.add(this.f15789e);
        c0960f.f15759h = i4;
        c0960f.f15760i = c0961g;
        c0960f2.f15762k.add(c0960f);
        c0961g.f15762k.add(c0960f);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i4, int i5) {
        int iMax;
        if (i5 == 0) {
            C0944d c0944d = this.f15786b;
            int i6 = c0944d.f15586v;
            iMax = Math.max(c0944d.f15585u, i4);
            if (i6 > 0) {
                iMax = Math.min(i6, i4);
            }
            if (iMax == i4) {
                return i4;
            }
        } else {
            C0944d c0944d2 = this.f15786b;
            int i7 = c0944d2.f15589y;
            iMax = Math.max(c0944d2.f15588x, i4);
            if (i7 > 0) {
                iMax = Math.min(i7, i4);
            }
            if (iMax == i4) {
                return i4;
            }
        }
        return iMax;
    }

    public long j() {
        if (this.f15789e.f15761j) {
            return r2.f15758g;
        }
        return 0L;
    }

    public abstract boolean k();

    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(v.C0943c r12, v.C0943c r13, int r14) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w.p.l(v.c, v.c, int):void");
    }
}
