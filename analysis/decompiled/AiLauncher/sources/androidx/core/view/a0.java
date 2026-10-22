package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;

/* loaded from: classes.dex */
public class a0 {

    /* renamed from: b, reason: collision with root package name */
    public static final a0 f13159b = m.f13176n;

    /* renamed from: a, reason: collision with root package name */
    public final n f13160a;

    public static class c extends b {
        public c() {
        }

        public c(a0 a0Var) {
            super(a0Var);
        }
    }

    public static class d extends c {
        public d() {
        }

        public d(a0 a0Var) {
            super(a0Var);
        }
    }

    public static class e extends d {
        public e() {
        }

        @Override // androidx.core.view.a0.f
        public void c(int i10, t0.e eVar) {
            this.f13162c.setInsets(q.a(i10), eVar.d());
        }

        public e(a0 a0Var) {
            super(a0Var);
        }
    }

    public static class f {

        /* renamed from: a, reason: collision with root package name */
        public final a0 f13163a;

        /* renamed from: b, reason: collision with root package name */
        public t0.e[] f13164b;

        public f() {
            this(new a0((a0) null));
        }

        public final void a() {
            t0.e[] eVarArr = this.f13164b;
            if (eVarArr != null) {
                t0.e eVarF = eVarArr[o.c(1)];
                t0.e eVarF2 = this.f13164b[o.c(2)];
                if (eVarF2 == null) {
                    eVarF2 = this.f13163a.f(2);
                }
                if (eVarF == null) {
                    eVarF = this.f13163a.f(1);
                }
                g(t0.e.a(eVarF, eVarF2));
                t0.e eVar = this.f13164b[o.c(16)];
                if (eVar != null) {
                    f(eVar);
                }
                t0.e eVar2 = this.f13164b[o.c(32)];
                if (eVar2 != null) {
                    d(eVar2);
                }
                t0.e eVar3 = this.f13164b[o.c(64)];
                if (eVar3 != null) {
                    h(eVar3);
                }
            }
        }

        public a0 b() {
            throw null;
        }

        public void c(int i10, t0.e eVar) {
            throw null;
        }

        public void d(t0.e eVar) {
            throw null;
        }

        public void e(t0.e eVar) {
            throw null;
        }

        public void f(t0.e eVar) {
            throw null;
        }

        public void g(t0.e eVar) {
            throw null;
        }

        public void h(t0.e eVar) {
            throw null;
        }

        public f(a0 a0Var) {
            this.f13163a = a0Var;
        }
    }

    public static class i extends h {
        public i(a0 a0Var, WindowInsets windowInsets) {
            super(a0Var, windowInsets);
        }

        @Override // androidx.core.view.a0.n
        public a0 a() {
            return a0.y(this.f13165c.consumeDisplayCutout());
        }

        @Override // androidx.core.view.a0.g, androidx.core.view.a0.n
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof i)) {
                return false;
            }
            i iVar = (i) obj;
            return Objects.equals(this.f13165c, iVar.f13165c) && Objects.equals(this.f13169g, iVar.f13169g) && g.A(this.f13170h, iVar.f13170h);
        }

        @Override // androidx.core.view.a0.n
        public C1320h f() {
            return C1320h.e(this.f13165c.getDisplayCutout());
        }

        @Override // androidx.core.view.a0.n
        public int hashCode() {
            return this.f13165c.hashCode();
        }

        public i(a0 a0Var, i iVar) {
            super(a0Var, iVar);
        }
    }

    public static class k extends j {

        /* renamed from: m, reason: collision with root package name */
        public static final a0 f13175m = a0.y(WindowInsets.CONSUMED);

        public k(a0 a0Var, WindowInsets windowInsets) {
            super(a0Var, windowInsets);
        }

        @Override // androidx.core.view.a0.g, androidx.core.view.a0.n
        public final void d(View view) {
        }

        @Override // androidx.core.view.a0.g, androidx.core.view.a0.n
        public t0.e g(int i10) {
            return t0.e.c(this.f13165c.getInsets(p.a(i10)));
        }

        @Override // androidx.core.view.a0.g, androidx.core.view.a0.n
        public t0.e h(int i10) {
            return t0.e.c(this.f13165c.getInsetsIgnoringVisibility(p.a(i10)));
        }

        @Override // androidx.core.view.a0.g, androidx.core.view.a0.n
        public boolean q(int i10) {
            return this.f13165c.isVisible(p.a(i10));
        }

        public k(a0 a0Var, k kVar) {
            super(a0Var, kVar);
        }
    }

    public static class l extends k {
        public l(a0 a0Var, WindowInsets windowInsets) {
            super(a0Var, windowInsets);
        }

        public l(a0 a0Var, l lVar) {
            super(a0Var, lVar);
        }
    }

    public static class m extends l {

        /* renamed from: n, reason: collision with root package name */
        public static final a0 f13176n = a0.y(WindowInsets.CONSUMED);

        public m(a0 a0Var, WindowInsets windowInsets) {
            super(a0Var, windowInsets);
        }

        @Override // androidx.core.view.a0.k, androidx.core.view.a0.g, androidx.core.view.a0.n
        public t0.e g(int i10) {
            return t0.e.c(this.f13165c.getInsets(q.a(i10)));
        }

        @Override // androidx.core.view.a0.k, androidx.core.view.a0.g, androidx.core.view.a0.n
        public t0.e h(int i10) {
            return t0.e.c(this.f13165c.getInsetsIgnoringVisibility(q.a(i10)));
        }

        @Override // androidx.core.view.a0.k, androidx.core.view.a0.g, androidx.core.view.a0.n
        public boolean q(int i10) {
            return this.f13165c.isVisible(q.a(i10));
        }

        public m(a0 a0Var, m mVar) {
            super(a0Var, mVar);
        }
    }

    public static class n {

        /* renamed from: b, reason: collision with root package name */
        public static final a0 f13177b = new a().a().a().b().c();

        /* renamed from: a, reason: collision with root package name */
        public final a0 f13178a;

        public n(a0 a0Var) {
            this.f13178a = a0Var;
        }

        public a0 a() {
            return this.f13178a;
        }

        public a0 b() {
            return this.f13178a;
        }

        public a0 c() {
            return this.f13178a;
        }

        public void d(View view) {
        }

        public void e(a0 a0Var) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof n)) {
                return false;
            }
            n nVar = (n) obj;
            return p() == nVar.p() && o() == nVar.o() && B0.c.a(l(), nVar.l()) && B0.c.a(j(), nVar.j()) && B0.c.a(f(), nVar.f());
        }

        public C1320h f() {
            return null;
        }

        public t0.e g(int i10) {
            return t0.e.f41976e;
        }

        public t0.e h(int i10) {
            if ((i10 & 8) == 0) {
                return t0.e.f41976e;
            }
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        public int hashCode() {
            return B0.c.b(Boolean.valueOf(p()), Boolean.valueOf(o()), l(), j(), f());
        }

        public t0.e i() {
            return l();
        }

        public t0.e j() {
            return t0.e.f41976e;
        }

        public t0.e k() {
            return l();
        }

        public t0.e l() {
            return t0.e.f41976e;
        }

        public t0.e m() {
            return l();
        }

        public a0 n(int i10, int i11, int i12, int i13) {
            return f13177b;
        }

        public boolean o() {
            return false;
        }

        public boolean p() {
            return false;
        }

        public boolean q(int i10) {
            return true;
        }

        public void r(t0.e[] eVarArr) {
        }

        public void s(t0.e eVar) {
        }

        public void t(a0 a0Var) {
        }

        public void u(int i10) {
        }
    }

    public static final class o {
        public static int a() {
            return 128;
        }

        public static int b() {
            return 8;
        }

        public static int c(int i10) {
            if (i10 == 1) {
                return 0;
            }
            if (i10 == 2) {
                return 1;
            }
            if (i10 == 4) {
                return 2;
            }
            if (i10 == 8) {
                return 3;
            }
            if (i10 == 16) {
                return 4;
            }
            if (i10 == 32) {
                return 5;
            }
            if (i10 == 64) {
                return 6;
            }
            if (i10 == 128) {
                return 7;
            }
            if (i10 == 256) {
                return 8;
            }
            if (i10 == 512) {
                return 9;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i10);
        }

        public static int d() {
            return 32;
        }

        public static int e() {
            return 2;
        }

        public static int f() {
            return 1;
        }

        public static int g() {
            return 519;
        }

        public static int h() {
            return 16;
        }

        public static int i() {
            return 64;
        }
    }

    public static final class p {
        public static int a(int i10) {
            int iStatusBars;
            int i11 = 0;
            for (int i12 = 1; i12 <= 512; i12 <<= 1) {
                if ((i10 & i12) != 0) {
                    if (i12 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i12 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i12 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i12 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i12 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i12 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i12 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i12 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i11 |= iStatusBars;
                }
            }
            return i11;
        }
    }

    public static final class q {
        public static int a(int i10) {
            int iStatusBars;
            int i11 = 0;
            for (int i12 = 1; i12 <= 512; i12 <<= 1) {
                if ((i10 & i12) != 0) {
                    if (i12 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i12 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i12 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i12 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i12 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i12 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i12 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i12 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    } else if (i12 == 512) {
                        iStatusBars = WindowInsets.Type.systemOverlays();
                    }
                    i11 |= iStatusBars;
                }
            }
            return i11;
        }
    }

    public a0(WindowInsets windowInsets) {
        this.f13160a = new m(this, windowInsets);
    }

    public static t0.e p(t0.e eVar, int i10, int i11, int i12, int i13) {
        int iMax = Math.max(0, eVar.f41977a - i10);
        int iMax2 = Math.max(0, eVar.f41978b - i11);
        int iMax3 = Math.max(0, eVar.f41979c - i12);
        int iMax4 = Math.max(0, eVar.f41980d - i13);
        return (iMax == i10 && iMax2 == i11 && iMax3 == i12 && iMax4 == i13) ? eVar : t0.e.b(iMax, iMax2, iMax3, iMax4);
    }

    public static a0 y(WindowInsets windowInsets) {
        return z(windowInsets, null);
    }

    public static a0 z(WindowInsets windowInsets, View view) {
        a0 a0Var = new a0((WindowInsets) B0.h.f(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            a0Var.v(N.B(view));
            a0Var.d(view.getRootView());
            a0Var.w(view.getWindowSystemUiVisibility());
        }
        return a0Var;
    }

    @Deprecated
    public a0 a() {
        return this.f13160a.a();
    }

    @Deprecated
    public a0 b() {
        return this.f13160a.b();
    }

    @Deprecated
    public a0 c() {
        return this.f13160a.c();
    }

    public void d(View view) {
        this.f13160a.d(view);
    }

    public C1320h e() {
        return this.f13160a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a0) {
            return B0.c.a(this.f13160a, ((a0) obj).f13160a);
        }
        return false;
    }

    public t0.e f(int i10) {
        return this.f13160a.g(i10);
    }

    public t0.e g(int i10) {
        return this.f13160a.h(i10);
    }

    @Deprecated
    public t0.e h() {
        return this.f13160a.j();
    }

    public int hashCode() {
        n nVar = this.f13160a;
        if (nVar == null) {
            return 0;
        }
        return nVar.hashCode();
    }

    @Deprecated
    public t0.e i() {
        return this.f13160a.k();
    }

    @Deprecated
    public int j() {
        return this.f13160a.l().f41980d;
    }

    @Deprecated
    public int k() {
        return this.f13160a.l().f41977a;
    }

    @Deprecated
    public int l() {
        return this.f13160a.l().f41979c;
    }

    @Deprecated
    public int m() {
        return this.f13160a.l().f41978b;
    }

    @Deprecated
    public boolean n() {
        return !this.f13160a.l().equals(t0.e.f41976e);
    }

    public a0 o(int i10, int i11, int i12, int i13) {
        return this.f13160a.n(i10, i11, i12, i13);
    }

    public boolean q() {
        return this.f13160a.o();
    }

    public boolean r(int i10) {
        return this.f13160a.q(i10);
    }

    @Deprecated
    public a0 s(int i10, int i11, int i12, int i13) {
        return new a(this).d(t0.e.b(i10, i11, i12, i13)).a();
    }

    public void t(t0.e[] eVarArr) {
        this.f13160a.r(eVarArr);
    }

    public void u(t0.e eVar) {
        this.f13160a.s(eVar);
    }

    public void v(a0 a0Var) {
        this.f13160a.t(a0Var);
    }

    public void w(int i10) {
        this.f13160a.u(i10);
    }

    public WindowInsets x() {
        n nVar = this.f13160a;
        if (nVar instanceof g) {
            return ((g) nVar).f13165c;
        }
        return null;
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final f f13161a;

        public a() {
            this.f13161a = new e();
        }

        public a0 a() {
            return this.f13161a.b();
        }

        public a b(int i10, t0.e eVar) {
            this.f13161a.c(i10, eVar);
            return this;
        }

        @Deprecated
        public a c(t0.e eVar) {
            this.f13161a.e(eVar);
            return this;
        }

        @Deprecated
        public a d(t0.e eVar) {
            this.f13161a.g(eVar);
            return this;
        }

        public a(a0 a0Var) {
            this.f13161a = new e(a0Var);
        }
    }

    public static class b extends f {

        /* renamed from: c, reason: collision with root package name */
        public final WindowInsets.Builder f13162c;

        public b() {
            this.f13162c = new WindowInsets.Builder();
        }

        @Override // androidx.core.view.a0.f
        public a0 b() {
            a();
            a0 a0VarY = a0.y(this.f13162c.build());
            a0VarY.t(this.f13164b);
            return a0VarY;
        }

        @Override // androidx.core.view.a0.f
        public void d(t0.e eVar) {
            this.f13162c.setMandatorySystemGestureInsets(eVar.d());
        }

        @Override // androidx.core.view.a0.f
        public void e(t0.e eVar) {
            this.f13162c.setStableInsets(eVar.d());
        }

        @Override // androidx.core.view.a0.f
        public void f(t0.e eVar) {
            this.f13162c.setSystemGestureInsets(eVar.d());
        }

        @Override // androidx.core.view.a0.f
        public void g(t0.e eVar) {
            this.f13162c.setSystemWindowInsets(eVar.d());
        }

        @Override // androidx.core.view.a0.f
        public void h(t0.e eVar) {
            this.f13162c.setTappableElementInsets(eVar.d());
        }

        public b(a0 a0Var) {
            WindowInsets.Builder builder;
            super(a0Var);
            WindowInsets windowInsetsX = a0Var.x();
            if (windowInsetsX != null) {
                builder = new WindowInsets.Builder(windowInsetsX);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f13162c = builder;
        }
    }

    public static class h extends g {

        /* renamed from: i, reason: collision with root package name */
        public t0.e f13171i;

        public h(a0 a0Var, WindowInsets windowInsets) {
            super(a0Var, windowInsets);
            this.f13171i = null;
        }

        @Override // androidx.core.view.a0.n
        public a0 b() {
            return a0.y(this.f13165c.consumeStableInsets());
        }

        @Override // androidx.core.view.a0.n
        public a0 c() {
            return a0.y(this.f13165c.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.a0.n
        public final t0.e j() {
            if (this.f13171i == null) {
                this.f13171i = t0.e.b(this.f13165c.getStableInsetLeft(), this.f13165c.getStableInsetTop(), this.f13165c.getStableInsetRight(), this.f13165c.getStableInsetBottom());
            }
            return this.f13171i;
        }

        @Override // androidx.core.view.a0.n
        public boolean o() {
            return this.f13165c.isConsumed();
        }

        public h(a0 a0Var, h hVar) {
            super(a0Var, hVar);
            this.f13171i = null;
            this.f13171i = hVar.f13171i;
        }
    }

    public static class g extends n {

        /* renamed from: c, reason: collision with root package name */
        public final WindowInsets f13165c;

        /* renamed from: d, reason: collision with root package name */
        public t0.e[] f13166d;

        /* renamed from: e, reason: collision with root package name */
        public t0.e f13167e;

        /* renamed from: f, reason: collision with root package name */
        public a0 f13168f;

        /* renamed from: g, reason: collision with root package name */
        public t0.e f13169g;

        /* renamed from: h, reason: collision with root package name */
        public int f13170h;

        public g(a0 a0Var, WindowInsets windowInsets) {
            super(a0Var);
            this.f13167e = null;
            this.f13165c = windowInsets;
        }

        public static boolean A(int i10, int i11) {
            return (i10 & 6) == (i11 & 6);
        }

        @SuppressLint({"WrongConstant"})
        private t0.e v(int i10, boolean z10) {
            t0.e eVarA = t0.e.f41976e;
            for (int i11 = 1; i11 <= 512; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    eVarA = t0.e.a(eVarA, w(i11, z10));
                }
            }
            return eVarA;
        }

        private t0.e x() {
            a0 a0Var = this.f13168f;
            return a0Var != null ? a0Var.h() : t0.e.f41976e;
        }

        private t0.e y(View view) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @Override // androidx.core.view.a0.n
        public void d(View view) {
            t0.e eVarY = y(view);
            if (eVarY == null) {
                eVarY = t0.e.f41976e;
            }
            s(eVarY);
        }

        @Override // androidx.core.view.a0.n
        public void e(a0 a0Var) {
            a0Var.v(this.f13168f);
            a0Var.u(this.f13169g);
            a0Var.w(this.f13170h);
        }

        @Override // androidx.core.view.a0.n
        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            g gVar = (g) obj;
            return Objects.equals(this.f13169g, gVar.f13169g) && A(this.f13170h, gVar.f13170h);
        }

        @Override // androidx.core.view.a0.n
        public t0.e g(int i10) {
            return v(i10, false);
        }

        @Override // androidx.core.view.a0.n
        public t0.e h(int i10) {
            return v(i10, true);
        }

        @Override // androidx.core.view.a0.n
        public final t0.e l() {
            if (this.f13167e == null) {
                this.f13167e = t0.e.b(this.f13165c.getSystemWindowInsetLeft(), this.f13165c.getSystemWindowInsetTop(), this.f13165c.getSystemWindowInsetRight(), this.f13165c.getSystemWindowInsetBottom());
            }
            return this.f13167e;
        }

        @Override // androidx.core.view.a0.n
        public a0 n(int i10, int i11, int i12, int i13) {
            a aVar = new a(a0.y(this.f13165c));
            aVar.d(a0.p(l(), i10, i11, i12, i13));
            aVar.c(a0.p(j(), i10, i11, i12, i13));
            return aVar.a();
        }

        @Override // androidx.core.view.a0.n
        public boolean p() {
            return this.f13165c.isRound();
        }

        @Override // androidx.core.view.a0.n
        @SuppressLint({"WrongConstant"})
        public boolean q(int i10) {
            for (int i11 = 1; i11 <= 512; i11 <<= 1) {
                if ((i10 & i11) != 0 && !z(i11)) {
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.core.view.a0.n
        public void r(t0.e[] eVarArr) {
            this.f13166d = eVarArr;
        }

        @Override // androidx.core.view.a0.n
        public void s(t0.e eVar) {
            this.f13169g = eVar;
        }

        @Override // androidx.core.view.a0.n
        public void t(a0 a0Var) {
            this.f13168f = a0Var;
        }

        @Override // androidx.core.view.a0.n
        public void u(int i10) {
            this.f13170h = i10;
        }

        public t0.e w(int i10, boolean z10) {
            t0.e eVarH;
            int i11;
            if (i10 == 1) {
                return z10 ? t0.e.b(0, Math.max(x().f41978b, l().f41978b), 0, 0) : (this.f13170h & 4) != 0 ? t0.e.f41976e : t0.e.b(0, l().f41978b, 0, 0);
            }
            if (i10 == 2) {
                if (z10) {
                    t0.e eVarX = x();
                    t0.e eVarJ = j();
                    return t0.e.b(Math.max(eVarX.f41977a, eVarJ.f41977a), 0, Math.max(eVarX.f41979c, eVarJ.f41979c), Math.max(eVarX.f41980d, eVarJ.f41980d));
                }
                if ((this.f13170h & 2) != 0) {
                    return t0.e.f41976e;
                }
                t0.e eVarL = l();
                a0 a0Var = this.f13168f;
                eVarH = a0Var != null ? a0Var.h() : null;
                int iMin = eVarL.f41980d;
                if (eVarH != null) {
                    iMin = Math.min(iMin, eVarH.f41980d);
                }
                return t0.e.b(eVarL.f41977a, 0, eVarL.f41979c, iMin);
            }
            if (i10 != 8) {
                if (i10 == 16) {
                    return k();
                }
                if (i10 == 32) {
                    return i();
                }
                if (i10 == 64) {
                    return m();
                }
                if (i10 != 128) {
                    return t0.e.f41976e;
                }
                a0 a0Var2 = this.f13168f;
                C1320h c1320hE = a0Var2 != null ? a0Var2.e() : f();
                return c1320hE != null ? t0.e.b(c1320hE.b(), c1320hE.d(), c1320hE.c(), c1320hE.a()) : t0.e.f41976e;
            }
            t0.e[] eVarArr = this.f13166d;
            eVarH = eVarArr != null ? eVarArr[o.c(8)] : null;
            if (eVarH != null) {
                return eVarH;
            }
            t0.e eVarL2 = l();
            t0.e eVarX2 = x();
            int i12 = eVarL2.f41980d;
            if (i12 > eVarX2.f41980d) {
                return t0.e.b(0, 0, 0, i12);
            }
            t0.e eVar = this.f13169g;
            return (eVar == null || eVar.equals(t0.e.f41976e) || (i11 = this.f13169g.f41980d) <= eVarX2.f41980d) ? t0.e.f41976e : t0.e.b(0, 0, 0, i11);
        }

        public boolean z(int i10) {
            if (i10 != 1 && i10 != 2) {
                if (i10 == 4) {
                    return false;
                }
                if (i10 != 8 && i10 != 128) {
                    return true;
                }
            }
            return !w(i10, false).equals(t0.e.f41976e);
        }

        public g(a0 a0Var, g gVar) {
            this(a0Var, new WindowInsets(gVar.f13165c));
        }
    }

    public a0(a0 a0Var) {
        if (a0Var != null) {
            n nVar = a0Var.f13160a;
            if (nVar instanceof m) {
                this.f13160a = new m(this, (m) nVar);
            } else if (nVar instanceof l) {
                this.f13160a = new l(this, (l) nVar);
            } else if (nVar instanceof k) {
                this.f13160a = new k(this, (k) nVar);
            } else if (nVar instanceof j) {
                this.f13160a = new j(this, (j) nVar);
            } else if (nVar instanceof i) {
                this.f13160a = new i(this, (i) nVar);
            } else if (nVar instanceof h) {
                this.f13160a = new h(this, (h) nVar);
            } else if (nVar instanceof g) {
                this.f13160a = new g(this, (g) nVar);
            } else {
                this.f13160a = new n(this);
            }
            nVar.e(this);
            return;
        }
        this.f13160a = new n(this);
    }

    public static class j extends i {

        /* renamed from: j, reason: collision with root package name */
        public t0.e f13172j;

        /* renamed from: k, reason: collision with root package name */
        public t0.e f13173k;

        /* renamed from: l, reason: collision with root package name */
        public t0.e f13174l;

        public j(a0 a0Var, WindowInsets windowInsets) {
            super(a0Var, windowInsets);
            this.f13172j = null;
            this.f13173k = null;
            this.f13174l = null;
        }

        @Override // androidx.core.view.a0.n
        public t0.e i() {
            if (this.f13173k == null) {
                this.f13173k = t0.e.c(this.f13165c.getMandatorySystemGestureInsets());
            }
            return this.f13173k;
        }

        @Override // androidx.core.view.a0.n
        public t0.e k() {
            if (this.f13172j == null) {
                this.f13172j = t0.e.c(this.f13165c.getSystemGestureInsets());
            }
            return this.f13172j;
        }

        @Override // androidx.core.view.a0.n
        public t0.e m() {
            if (this.f13174l == null) {
                this.f13174l = t0.e.c(this.f13165c.getTappableElementInsets());
            }
            return this.f13174l;
        }

        @Override // androidx.core.view.a0.g, androidx.core.view.a0.n
        public a0 n(int i10, int i11, int i12, int i13) {
            return a0.y(this.f13165c.inset(i10, i11, i12, i13));
        }

        public j(a0 a0Var, j jVar) {
            super(a0Var, jVar);
            this.f13172j = null;
            this.f13173k = null;
            this.f13174l = null;
        }
    }
}
