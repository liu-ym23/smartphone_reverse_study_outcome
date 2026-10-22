package v0;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;
import java.util.WeakHashMap;
import v0.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m0 {

    /* renamed from: b, reason: collision with root package name */
    public static final m0 f13308b;

    /* renamed from: a, reason: collision with root package name */
    public final m f13309a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b extends a {
        public b() {
        }

        public b(m0 m0Var) {
            super(m0Var);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c extends b {
        public c() {
        }

        public c(m0 m0Var) {
            super(m0Var);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class d extends c {
        public d() {
        }

        public d(m0 m0Var) {
            super(m0Var);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final m0 f13311a;

        public e() {
            this(new m0((m0) null));
        }

        public m0 b() {
            throw null;
        }

        public void c(n0.b bVar) {
            throw null;
        }

        public void d(n0.b bVar) {
            throw null;
        }

        public void e(n0.b bVar) {
            throw null;
        }

        public void f(n0.b bVar) {
            throw null;
        }

        public void g(n0.b bVar) {
            throw null;
        }

        public e(m0 m0Var) {
            this.f13311a = m0Var;
        }

        public final void a() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class h extends g {
        public h(m0 m0Var, WindowInsets windowInsets) {
            super(m0Var, windowInsets);
        }

        @Override // v0.m0.m
        public m0 a() {
            return m0.h(null, this.f13312c.consumeDisplayCutout());
        }

        @Override // v0.m0.f, v0.m0.m
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return Objects.equals(this.f13312c, hVar.f13312c) && Objects.equals(this.f13316g, hVar.f13316g) && f.x(this.h, hVar.h);
        }

        @Override // v0.m0.m
        public v0.e f() {
            DisplayCutout displayCutout = this.f13312c.getDisplayCutout();
            if (displayCutout == null) {
                return null;
            }
            return new v0.e(displayCutout);
        }

        @Override // v0.m0.m
        public int hashCode() {
            return this.f13312c.hashCode();
        }

        public h(m0 m0Var, h hVar) {
            super(m0Var, hVar);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class j extends i {

        /* renamed from: m, reason: collision with root package name */
        public static final m0 f13321m = m0.h(null, WindowInsets.CONSUMED);

        public j(m0 m0Var, WindowInsets windowInsets) {
            super(m0Var, windowInsets);
        }

        @Override // v0.m0.f, v0.m0.m
        public n0.b g(int i10) {
            return n0.b.b(this.f13312c.getInsets(o.a(i10)));
        }

        public j(m0 m0Var, j jVar) {
            super(m0Var, jVar);
        }

        @Override // v0.m0.f, v0.m0.m
        public final void d(View view) {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class k extends j {
        public k(m0 m0Var, WindowInsets windowInsets) {
            super(m0Var, windowInsets);
        }

        public k(m0 m0Var, k kVar) {
            super(m0Var, kVar);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class l extends k {

        /* renamed from: n, reason: collision with root package name */
        public static final m0 f13322n = m0.h(null, WindowInsets.CONSUMED);

        public l(m0 m0Var, WindowInsets windowInsets) {
            super(m0Var, windowInsets);
        }

        @Override // v0.m0.j, v0.m0.f, v0.m0.m
        public n0.b g(int i10) {
            return n0.b.b(this.f13312c.getInsets(p.a(i10)));
        }

        public l(m0 m0Var, l lVar) {
            super(m0Var, lVar);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class n {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class o {
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

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
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
                    } else if (i12 == 512) {
                        iStatusBars = WindowInsets.Type.systemOverlays();
                    }
                    i11 |= iStatusBars;
                }
            }
            return i11;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 34) {
            f13308b = l.f13322n;
        } else {
            f13308b = j.f13321m;
        }
    }

    public m0(WindowInsets windowInsets) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 34) {
            this.f13309a = new l(this, windowInsets);
        } else if (i10 >= 31) {
            this.f13309a = new k(this, windowInsets);
        } else {
            this.f13309a = new j(this, windowInsets);
        }
    }

    public static n0.b e(n0.b bVar, int i10, int i11, int i12, int i13) {
        int iMax = Math.max(0, bVar.f10588a - i10);
        int iMax2 = Math.max(0, bVar.f10589b - i11);
        int iMax3 = Math.max(0, bVar.f10590c - i12);
        int iMax4 = Math.max(0, bVar.f10591d - i13);
        return (iMax == i10 && iMax2 == i11 && iMax3 == i12 && iMax4 == i13) ? bVar : n0.b.a(iMax, iMax2, iMax3, iMax4);
    }

    public static m0 h(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        m0 m0Var = new m0(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            WeakHashMap<View, h0> weakHashMap = e0.f13274a;
            m0 m0VarA = e0.e.a(view);
            m mVar = m0Var.f13309a;
            mVar.r(m0VarA);
            mVar.d(view.getRootView());
            mVar.s(view.getWindowSystemUiVisibility());
        }
        return m0Var;
    }

    @Deprecated
    public final int a() {
        return this.f13309a.k().f10591d;
    }

    @Deprecated
    public final int b() {
        return this.f13309a.k().f10588a;
    }

    @Deprecated
    public final int c() {
        return this.f13309a.k().f10590c;
    }

    @Deprecated
    public final int d() {
        return this.f13309a.k().f10589b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m0) {
            return Objects.equals(this.f13309a, ((m0) obj).f13309a);
        }
        return false;
    }

    @Deprecated
    public final m0 f(int i10, int i11, int i12, int i13) {
        int i14 = Build.VERSION.SDK_INT;
        e dVar = i14 >= 34 ? new d(this) : i14 >= 31 ? new c(this) : new b(this);
        dVar.f(n0.b.a(i10, i11, i12, i13));
        return dVar.b();
    }

    public final WindowInsets g() {
        m mVar = this.f13309a;
        if (mVar instanceof f) {
            return ((f) mVar).f13312c;
        }
        return null;
    }

    public final int hashCode() {
        m mVar = this.f13309a;
        if (mVar == null) {
            return 0;
        }
        return mVar.hashCode();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends e {

        /* renamed from: b, reason: collision with root package name */
        public final WindowInsets.Builder f13310b;

        public a() {
            this.f13310b = new WindowInsets.Builder();
        }

        @Override // v0.m0.e
        public m0 b() {
            a();
            m0 m0VarH = m0.h(null, this.f13310b.build());
            m0VarH.f13309a.p(null);
            return m0VarH;
        }

        @Override // v0.m0.e
        public void c(n0.b bVar) {
            this.f13310b.setMandatorySystemGestureInsets(bVar.c());
        }

        @Override // v0.m0.e
        public void d(n0.b bVar) {
            this.f13310b.setStableInsets(bVar.c());
        }

        @Override // v0.m0.e
        public void e(n0.b bVar) {
            this.f13310b.setSystemGestureInsets(bVar.c());
        }

        @Override // v0.m0.e
        public void f(n0.b bVar) {
            this.f13310b.setSystemWindowInsets(bVar.c());
        }

        @Override // v0.m0.e
        public void g(n0.b bVar) {
            this.f13310b.setTappableElementInsets(bVar.c());
        }

        public a(m0 m0Var) {
            WindowInsets.Builder builder;
            super(m0Var);
            WindowInsets windowInsetsG = m0Var.g();
            if (windowInsetsG != null) {
                builder = new WindowInsets.Builder(windowInsetsG);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f13310b = builder;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class g extends f {

        /* renamed from: i, reason: collision with root package name */
        public n0.b f13317i;

        public g(m0 m0Var, WindowInsets windowInsets) {
            super(m0Var, windowInsets);
            this.f13317i = null;
        }

        @Override // v0.m0.m
        public m0 b() {
            return m0.h(null, this.f13312c.consumeStableInsets());
        }

        @Override // v0.m0.m
        public m0 c() {
            return m0.h(null, this.f13312c.consumeSystemWindowInsets());
        }

        @Override // v0.m0.m
        public final n0.b i() {
            if (this.f13317i == null) {
                WindowInsets windowInsets = this.f13312c;
                this.f13317i = n0.b.a(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
            }
            return this.f13317i;
        }

        @Override // v0.m0.m
        public boolean n() {
            return this.f13312c.isConsumed();
        }

        public g(m0 m0Var, g gVar) {
            super(m0Var, gVar);
            this.f13317i = null;
            this.f13317i = gVar.f13317i;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class f extends m {

        /* renamed from: c, reason: collision with root package name */
        public final WindowInsets f13312c;

        /* renamed from: d, reason: collision with root package name */
        public n0.b[] f13313d;

        /* renamed from: e, reason: collision with root package name */
        public n0.b f13314e;

        /* renamed from: f, reason: collision with root package name */
        public m0 f13315f;

        /* renamed from: g, reason: collision with root package name */
        public n0.b f13316g;
        public int h;

        public f(m0 m0Var, WindowInsets windowInsets) {
            super(m0Var);
            this.f13314e = null;
            this.f13312c = windowInsets;
        }

        @SuppressLint({"WrongConstant"})
        private n0.b t(int i10, boolean z) {
            n0.b bVarA = n0.b.f10587e;
            for (int i11 = 1; i11 <= 512; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    n0.b bVarU = u(i11, z);
                    bVarA = n0.b.a(Math.max(bVarA.f10588a, bVarU.f10588a), Math.max(bVarA.f10589b, bVarU.f10589b), Math.max(bVarA.f10590c, bVarU.f10590c), Math.max(bVarA.f10591d, bVarU.f10591d));
                }
            }
            return bVarA;
        }

        private n0.b v() {
            m0 m0Var = this.f13315f;
            return m0Var != null ? m0Var.f13309a.i() : n0.b.f10587e;
        }

        private n0.b w(View view) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        public static boolean x(int i10, int i11) {
            return (i10 & 6) == (i11 & 6);
        }

        @Override // v0.m0.m
        public void d(View view) {
            n0.b bVarW = w(view);
            if (bVarW == null) {
                bVarW = n0.b.f10587e;
            }
            q(bVarW);
        }

        @Override // v0.m0.m
        public void e(m0 m0Var) {
            m0Var.f13309a.r(this.f13315f);
            n0.b bVar = this.f13316g;
            m mVar = m0Var.f13309a;
            mVar.q(bVar);
            mVar.s(this.h);
        }

        @Override // v0.m0.m
        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            f fVar = (f) obj;
            return Objects.equals(this.f13316g, fVar.f13316g) && x(this.h, fVar.h);
        }

        @Override // v0.m0.m
        public n0.b g(int i10) {
            return t(i10, false);
        }

        @Override // v0.m0.m
        public final n0.b k() {
            if (this.f13314e == null) {
                WindowInsets windowInsets = this.f13312c;
                this.f13314e = n0.b.a(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
            }
            return this.f13314e;
        }

        @Override // v0.m0.m
        public m0 m(int i10, int i11, int i12, int i13) {
            m0 m0VarH = m0.h(null, this.f13312c);
            int i14 = Build.VERSION.SDK_INT;
            e dVar = i14 >= 34 ? new d(m0VarH) : i14 >= 31 ? new c(m0VarH) : new b(m0VarH);
            dVar.f(m0.e(k(), i10, i11, i12, i13));
            dVar.d(m0.e(i(), i10, i11, i12, i13));
            return dVar.b();
        }

        @Override // v0.m0.m
        public boolean o() {
            return this.f13312c.isRound();
        }

        @Override // v0.m0.m
        public void p(n0.b[] bVarArr) {
            this.f13313d = bVarArr;
        }

        @Override // v0.m0.m
        public void q(n0.b bVar) {
            this.f13316g = bVar;
        }

        @Override // v0.m0.m
        public void r(m0 m0Var) {
            this.f13315f = m0Var;
        }

        @Override // v0.m0.m
        public void s(int i10) {
            this.h = i10;
        }

        public n0.b u(int i10, boolean z) {
            n0.b bVarI;
            int i11;
            n0.b bVar = n0.b.f10587e;
            if (i10 == 1) {
                return z ? n0.b.a(0, Math.max(v().f10589b, k().f10589b), 0, 0) : (this.h & 4) != 0 ? bVar : n0.b.a(0, k().f10589b, 0, 0);
            }
            if (i10 == 2) {
                if (z) {
                    n0.b bVarV = v();
                    n0.b bVarI2 = i();
                    return n0.b.a(Math.max(bVarV.f10588a, bVarI2.f10588a), 0, Math.max(bVarV.f10590c, bVarI2.f10590c), Math.max(bVarV.f10591d, bVarI2.f10591d));
                }
                if ((this.h & 2) != 0) {
                    return bVar;
                }
                n0.b bVarK = k();
                m0 m0Var = this.f13315f;
                bVarI = m0Var != null ? m0Var.f13309a.i() : null;
                int iMin = bVarK.f10591d;
                if (bVarI != null) {
                    iMin = Math.min(iMin, bVarI.f10591d);
                }
                return n0.b.a(bVarK.f10588a, 0, bVarK.f10590c, iMin);
            }
            if (i10 == 8) {
                n0.b[] bVarArr = this.f13313d;
                bVarI = bVarArr != null ? bVarArr[3] : null;
                if (bVarI != null) {
                    return bVarI;
                }
                n0.b bVarK2 = k();
                n0.b bVarV2 = v();
                int i12 = bVarK2.f10591d;
                if (i12 > bVarV2.f10591d) {
                    return n0.b.a(0, 0, 0, i12);
                }
                n0.b bVar2 = this.f13316g;
                return (bVar2 == null || bVar2.equals(bVar) || (i11 = this.f13316g.f10591d) <= bVarV2.f10591d) ? bVar : n0.b.a(0, 0, 0, i11);
            }
            if (i10 == 16) {
                return j();
            }
            if (i10 == 32) {
                return h();
            }
            if (i10 == 64) {
                return l();
            }
            if (i10 != 128) {
                return bVar;
            }
            m0 m0Var2 = this.f13315f;
            v0.e eVarF = m0Var2 != null ? m0Var2.f13309a.f() : f();
            if (eVarF == null) {
                return bVar;
            }
            DisplayCutout displayCutout = eVarF.f13273a;
            return n0.b.a(displayCutout.getSafeInsetLeft(), displayCutout.getSafeInsetTop(), displayCutout.getSafeInsetRight(), displayCutout.getSafeInsetBottom());
        }

        public f(m0 m0Var, f fVar) {
            this(m0Var, new WindowInsets(fVar.f13312c));
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class i extends h {

        /* renamed from: j, reason: collision with root package name */
        public n0.b f13318j;

        /* renamed from: k, reason: collision with root package name */
        public n0.b f13319k;

        /* renamed from: l, reason: collision with root package name */
        public n0.b f13320l;

        public i(m0 m0Var, WindowInsets windowInsets) {
            super(m0Var, windowInsets);
            this.f13318j = null;
            this.f13319k = null;
            this.f13320l = null;
        }

        @Override // v0.m0.m
        public n0.b h() {
            if (this.f13319k == null) {
                this.f13319k = n0.b.b(this.f13312c.getMandatorySystemGestureInsets());
            }
            return this.f13319k;
        }

        @Override // v0.m0.m
        public n0.b j() {
            if (this.f13318j == null) {
                this.f13318j = n0.b.b(this.f13312c.getSystemGestureInsets());
            }
            return this.f13318j;
        }

        @Override // v0.m0.m
        public n0.b l() {
            if (this.f13320l == null) {
                this.f13320l = n0.b.b(this.f13312c.getTappableElementInsets());
            }
            return this.f13320l;
        }

        @Override // v0.m0.f, v0.m0.m
        public m0 m(int i10, int i11, int i12, int i13) {
            return m0.h(null, this.f13312c.inset(i10, i11, i12, i13));
        }

        public i(m0 m0Var, i iVar) {
            super(m0Var, iVar);
            this.f13318j = null;
            this.f13319k = null;
            this.f13320l = null;
        }
    }

    public m0(m0 m0Var) {
        if (m0Var != null) {
            m mVar = m0Var.f13309a;
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 34 && (mVar instanceof l)) {
                this.f13309a = new l(this, (l) mVar);
            } else if (i10 >= 31 && (mVar instanceof k)) {
                this.f13309a = new k(this, (k) mVar);
            } else if (mVar instanceof j) {
                this.f13309a = new j(this, (j) mVar);
            } else if (mVar instanceof i) {
                this.f13309a = new i(this, (i) mVar);
            } else if (mVar instanceof h) {
                this.f13309a = new h(this, (h) mVar);
            } else if (mVar instanceof g) {
                this.f13309a = new g(this, (g) mVar);
            } else if (mVar instanceof f) {
                this.f13309a = new f(this, (f) mVar);
            } else {
                this.f13309a = new m(this);
            }
            mVar.e(this);
            return;
        }
        this.f13309a = new m(this);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class m {

        /* renamed from: b, reason: collision with root package name */
        public static final m0 f13323b;

        /* renamed from: a, reason: collision with root package name */
        public final m0 f13324a;

        static {
            int i10 = Build.VERSION.SDK_INT;
            f13323b = (i10 >= 34 ? new d() : i10 >= 31 ? new c() : new b()).b().f13309a.a().f13309a.b().f13309a.c();
        }

        public m(m0 m0Var) {
            this.f13324a = m0Var;
        }

        public m0 a() {
            return this.f13324a;
        }

        public m0 b() {
            return this.f13324a;
        }

        public m0 c() {
            return this.f13324a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof m)) {
                return false;
            }
            m mVar = (m) obj;
            return o() == mVar.o() && n() == mVar.n() && Objects.equals(k(), mVar.k()) && Objects.equals(i(), mVar.i()) && Objects.equals(f(), mVar.f());
        }

        public v0.e f() {
            return null;
        }

        public n0.b g(int i10) {
            return n0.b.f10587e;
        }

        public n0.b h() {
            return k();
        }

        public int hashCode() {
            return Objects.hash(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        public n0.b i() {
            return n0.b.f10587e;
        }

        public n0.b j() {
            return k();
        }

        public n0.b k() {
            return n0.b.f10587e;
        }

        public n0.b l() {
            return k();
        }

        public m0 m(int i10, int i11, int i12, int i13) {
            return f13323b;
        }

        public boolean n() {
            return false;
        }

        public boolean o() {
            return false;
        }

        public void d(View view) {
        }

        public void e(m0 m0Var) {
        }

        public void p(n0.b[] bVarArr) {
        }

        public void q(n0.b bVar) {
        }

        public void r(m0 m0Var) {
        }

        public void s(int i10) {
        }
    }
}
