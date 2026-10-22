package androidx.core.view;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.util.Objects;

/* loaded from: classes.dex */
public class Y {

    /* renamed from: b, reason: collision with root package name */
    public static final Y f9771b = j.f9790l;

    /* renamed from: a, reason: collision with root package name */
    private final k f9772a;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        private static Field f9773a;

        /* renamed from: b, reason: collision with root package name */
        private static Field f9774b;

        /* renamed from: c, reason: collision with root package name */
        private static Field f9775c;

        /* renamed from: d, reason: collision with root package name */
        private static boolean f9776d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f9773a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f9774b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f9775c = declaredField3;
                declaredField3.setAccessible(true);
                f9776d = true;
            } catch (ReflectiveOperationException e6) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e6.getMessage(), e6);
            }
        }

        public static Y a(View view) throws IllegalAccessException, IllegalArgumentException {
            if (f9776d && view.isAttachedToWindow()) {
                try {
                    Object obj = f9773a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f9774b.get(obj);
                        Rect rect2 = (Rect) f9775c.get(obj);
                        if (rect != null && rect2 != null) {
                            Y yA = new b().b(androidx.core.graphics.b.c(rect)).c(androidx.core.graphics.b.c(rect2)).a();
                            yA.r(yA);
                            yA.d(view.getRootView());
                            return yA;
                        }
                    }
                } catch (IllegalAccessException e6) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e6.getMessage(), e6);
                }
            }
            return null;
        }
    }

    private static class d extends c {
        d() {
        }

        d(Y y5) {
            super(y5);
        }
    }

    private static class e {

        /* renamed from: a, reason: collision with root package name */
        private final Y f9779a;

        /* renamed from: b, reason: collision with root package name */
        androidx.core.graphics.b[] f9780b;

        e() {
            this(new Y((Y) null));
        }

        protected final void a() {
            androidx.core.graphics.b[] bVarArr = this.f9780b;
            if (bVarArr != null) {
                androidx.core.graphics.b bVarF = bVarArr[l.b(1)];
                androidx.core.graphics.b bVarF2 = this.f9780b[l.b(2)];
                if (bVarF2 == null) {
                    bVarF2 = this.f9779a.f(2);
                }
                if (bVarF == null) {
                    bVarF = this.f9779a.f(1);
                }
                f(androidx.core.graphics.b.a(bVarF, bVarF2));
                androidx.core.graphics.b bVar = this.f9780b[l.b(16)];
                if (bVar != null) {
                    e(bVar);
                }
                androidx.core.graphics.b bVar2 = this.f9780b[l.b(32)];
                if (bVar2 != null) {
                    c(bVar2);
                }
                androidx.core.graphics.b bVar3 = this.f9780b[l.b(64)];
                if (bVar3 != null) {
                    g(bVar3);
                }
            }
        }

        Y b() {
            throw null;
        }

        void c(androidx.core.graphics.b bVar) {
            throw null;
        }

        void d(androidx.core.graphics.b bVar) {
            throw null;
        }

        void e(androidx.core.graphics.b bVar) {
            throw null;
        }

        void f(androidx.core.graphics.b bVar) {
            throw null;
        }

        void g(androidx.core.graphics.b bVar) {
            throw null;
        }

        e(Y y5) {
            this.f9779a = y5;
        }
    }

    private static class h extends g {
        h(Y y5, WindowInsets windowInsets) {
            super(y5, windowInsets);
        }

        @Override // androidx.core.view.Y.k
        Y a() {
            return Y.t(this.f9781c.consumeDisplayCutout());
        }

        @Override // androidx.core.view.Y.f, androidx.core.view.Y.k
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return Objects.equals(this.f9781c, hVar.f9781c) && Objects.equals(this.f9785g, hVar.f9785g);
        }

        @Override // androidx.core.view.Y.k
        C0462g f() {
            return C0462g.e(this.f9781c.getDisplayCutout());
        }

        @Override // androidx.core.view.Y.k
        public int hashCode() {
            return this.f9781c.hashCode();
        }

        h(Y y5, h hVar) {
            super(y5, hVar);
        }
    }

    private static class j extends i {

        /* renamed from: l, reason: collision with root package name */
        static final Y f9790l = Y.t(WindowInsets.CONSUMED);

        j(Y y5, WindowInsets windowInsets) {
            super(y5, windowInsets);
        }

        @Override // androidx.core.view.Y.f, androidx.core.view.Y.k
        final void d(View view) {
        }

        @Override // androidx.core.view.Y.f, androidx.core.view.Y.k
        public androidx.core.graphics.b g(int i5) {
            return androidx.core.graphics.b.d(this.f9781c.getInsets(m.a(i5)));
        }

        j(Y y5, j jVar) {
            super(y5, jVar);
        }
    }

    private static class k {

        /* renamed from: b, reason: collision with root package name */
        static final Y f9791b = new b().a().a().b().c();

        /* renamed from: a, reason: collision with root package name */
        final Y f9792a;

        k(Y y5) {
            this.f9792a = y5;
        }

        Y a() {
            return this.f9792a;
        }

        Y b() {
            return this.f9792a;
        }

        Y c() {
            return this.f9792a;
        }

        void d(View view) {
        }

        void e(Y y5) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return o() == kVar.o() && n() == kVar.n() && D.c.a(k(), kVar.k()) && D.c.a(i(), kVar.i()) && D.c.a(f(), kVar.f());
        }

        C0462g f() {
            return null;
        }

        androidx.core.graphics.b g(int i5) {
            return androidx.core.graphics.b.f9641e;
        }

        androidx.core.graphics.b h() {
            return k();
        }

        public int hashCode() {
            return D.c.b(Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f());
        }

        androidx.core.graphics.b i() {
            return androidx.core.graphics.b.f9641e;
        }

        androidx.core.graphics.b j() {
            return k();
        }

        androidx.core.graphics.b k() {
            return androidx.core.graphics.b.f9641e;
        }

        androidx.core.graphics.b l() {
            return k();
        }

        Y m(int i5, int i6, int i7, int i8) {
            return f9791b;
        }

        boolean n() {
            return false;
        }

        boolean o() {
            return false;
        }

        public void p(androidx.core.graphics.b[] bVarArr) {
        }

        void q(androidx.core.graphics.b bVar) {
        }

        void r(Y y5) {
        }
    }

    public static final class l {
        public static int a() {
            return 8;
        }

        static int b(int i5) {
            if (i5 == 1) {
                return 0;
            }
            if (i5 == 2) {
                return 1;
            }
            if (i5 == 4) {
                return 2;
            }
            if (i5 == 8) {
                return 3;
            }
            if (i5 == 16) {
                return 4;
            }
            if (i5 == 32) {
                return 5;
            }
            if (i5 == 64) {
                return 6;
            }
            if (i5 == 128) {
                return 7;
            }
            if (i5 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i5);
        }

        public static int c() {
            return 32;
        }

        public static int d() {
            return 2;
        }

        public static int e() {
            return 1;
        }

        public static int f() {
            return 7;
        }
    }

    private static final class m {
        static int a(int i5) {
            int iStatusBars;
            int i6 = 0;
            for (int i7 = 1; i7 <= 256; i7 <<= 1) {
                if ((i5 & i7) != 0) {
                    if (i7 == 1) {
                        iStatusBars = WindowInsets.Type.statusBars();
                    } else if (i7 == 2) {
                        iStatusBars = WindowInsets.Type.navigationBars();
                    } else if (i7 == 4) {
                        iStatusBars = WindowInsets.Type.captionBar();
                    } else if (i7 == 8) {
                        iStatusBars = WindowInsets.Type.ime();
                    } else if (i7 == 16) {
                        iStatusBars = WindowInsets.Type.systemGestures();
                    } else if (i7 == 32) {
                        iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i7 == 64) {
                        iStatusBars = WindowInsets.Type.tappableElement();
                    } else if (i7 == 128) {
                        iStatusBars = WindowInsets.Type.displayCutout();
                    }
                    i6 |= iStatusBars;
                }
            }
            return i6;
        }
    }

    private Y(WindowInsets windowInsets) {
        this.f9772a = new j(this, windowInsets);
    }

    static androidx.core.graphics.b m(androidx.core.graphics.b bVar, int i5, int i6, int i7, int i8) {
        int iMax = Math.max(0, bVar.f9642a - i5);
        int iMax2 = Math.max(0, bVar.f9643b - i6);
        int iMax3 = Math.max(0, bVar.f9644c - i7);
        int iMax4 = Math.max(0, bVar.f9645d - i8);
        return (iMax == i5 && iMax2 == i6 && iMax3 == i7 && iMax4 == i8) ? bVar : androidx.core.graphics.b.b(iMax, iMax2, iMax3, iMax4);
    }

    public static Y t(WindowInsets windowInsets) {
        return u(windowInsets, null);
    }

    public static Y u(WindowInsets windowInsets, View view) {
        Y y5 = new Y((WindowInsets) D.h.e(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            y5.r(H.D(view));
            y5.d(view.getRootView());
        }
        return y5;
    }

    @Deprecated
    public Y a() {
        return this.f9772a.a();
    }

    @Deprecated
    public Y b() {
        return this.f9772a.b();
    }

    @Deprecated
    public Y c() {
        return this.f9772a.c();
    }

    void d(View view) {
        this.f9772a.d(view);
    }

    public C0462g e() {
        return this.f9772a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Y) {
            return D.c.a(this.f9772a, ((Y) obj).f9772a);
        }
        return false;
    }

    public androidx.core.graphics.b f(int i5) {
        return this.f9772a.g(i5);
    }

    @Deprecated
    public androidx.core.graphics.b g() {
        return this.f9772a.i();
    }

    @Deprecated
    public int h() {
        return this.f9772a.k().f9645d;
    }

    public int hashCode() {
        k kVar = this.f9772a;
        if (kVar == null) {
            return 0;
        }
        return kVar.hashCode();
    }

    @Deprecated
    public int i() {
        return this.f9772a.k().f9642a;
    }

    @Deprecated
    public int j() {
        return this.f9772a.k().f9644c;
    }

    @Deprecated
    public int k() {
        return this.f9772a.k().f9643b;
    }

    public Y l(int i5, int i6, int i7, int i8) {
        return this.f9772a.m(i5, i6, i7, i8);
    }

    public boolean n() {
        return this.f9772a.n();
    }

    @Deprecated
    public Y o(int i5, int i6, int i7, int i8) {
        return new b(this).c(androidx.core.graphics.b.b(i5, i6, i7, i8)).a();
    }

    void p(androidx.core.graphics.b[] bVarArr) {
        this.f9772a.p(bVarArr);
    }

    void q(androidx.core.graphics.b bVar) {
        this.f9772a.q(bVar);
    }

    void r(Y y5) {
        this.f9772a.r(y5);
    }

    public WindowInsets s() {
        k kVar = this.f9772a;
        if (kVar instanceof f) {
            return ((f) kVar).f9781c;
        }
        return null;
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final e f9777a;

        public b() {
            this.f9777a = new d();
        }

        public Y a() {
            return this.f9777a.b();
        }

        @Deprecated
        public b b(androidx.core.graphics.b bVar) {
            this.f9777a.d(bVar);
            return this;
        }

        @Deprecated
        public b c(androidx.core.graphics.b bVar) {
            this.f9777a.f(bVar);
            return this;
        }

        public b(Y y5) {
            this.f9777a = new d(y5);
        }
    }

    private static class c extends e {

        /* renamed from: c, reason: collision with root package name */
        final WindowInsets.Builder f9778c;

        c() {
            this.f9778c = new WindowInsets.Builder();
        }

        @Override // androidx.core.view.Y.e
        Y b() {
            a();
            Y yT = Y.t(this.f9778c.build());
            yT.p(this.f9780b);
            return yT;
        }

        @Override // androidx.core.view.Y.e
        void c(androidx.core.graphics.b bVar) {
            this.f9778c.setMandatorySystemGestureInsets(bVar.e());
        }

        @Override // androidx.core.view.Y.e
        void d(androidx.core.graphics.b bVar) {
            this.f9778c.setStableInsets(bVar.e());
        }

        @Override // androidx.core.view.Y.e
        void e(androidx.core.graphics.b bVar) {
            this.f9778c.setSystemGestureInsets(bVar.e());
        }

        @Override // androidx.core.view.Y.e
        void f(androidx.core.graphics.b bVar) {
            this.f9778c.setSystemWindowInsets(bVar.e());
        }

        @Override // androidx.core.view.Y.e
        void g(androidx.core.graphics.b bVar) {
            this.f9778c.setTappableElementInsets(bVar.e());
        }

        c(Y y5) {
            WindowInsets.Builder builder;
            super(y5);
            WindowInsets windowInsetsS = y5.s();
            if (windowInsetsS != null) {
                builder = new WindowInsets.Builder(windowInsetsS);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f9778c = builder;
        }
    }

    private static class g extends f {

        /* renamed from: h, reason: collision with root package name */
        private androidx.core.graphics.b f9786h;

        g(Y y5, WindowInsets windowInsets) {
            super(y5, windowInsets);
            this.f9786h = null;
        }

        @Override // androidx.core.view.Y.k
        Y b() {
            return Y.t(this.f9781c.consumeStableInsets());
        }

        @Override // androidx.core.view.Y.k
        Y c() {
            return Y.t(this.f9781c.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.Y.k
        final androidx.core.graphics.b i() {
            if (this.f9786h == null) {
                this.f9786h = androidx.core.graphics.b.b(this.f9781c.getStableInsetLeft(), this.f9781c.getStableInsetTop(), this.f9781c.getStableInsetRight(), this.f9781c.getStableInsetBottom());
            }
            return this.f9786h;
        }

        @Override // androidx.core.view.Y.k
        boolean n() {
            return this.f9781c.isConsumed();
        }

        g(Y y5, g gVar) {
            super(y5, gVar);
            this.f9786h = null;
            this.f9786h = gVar.f9786h;
        }
    }

    private static class f extends k {

        /* renamed from: c, reason: collision with root package name */
        final WindowInsets f9781c;

        /* renamed from: d, reason: collision with root package name */
        private androidx.core.graphics.b[] f9782d;

        /* renamed from: e, reason: collision with root package name */
        private androidx.core.graphics.b f9783e;

        /* renamed from: f, reason: collision with root package name */
        private Y f9784f;

        /* renamed from: g, reason: collision with root package name */
        androidx.core.graphics.b f9785g;

        f(Y y5, WindowInsets windowInsets) {
            super(y5);
            this.f9783e = null;
            this.f9781c = windowInsets;
        }

        private androidx.core.graphics.b s(int i5, boolean z5) {
            androidx.core.graphics.b bVarA = androidx.core.graphics.b.f9641e;
            for (int i6 = 1; i6 <= 256; i6 <<= 1) {
                if ((i5 & i6) != 0) {
                    bVarA = androidx.core.graphics.b.a(bVarA, t(i6, z5));
                }
            }
            return bVarA;
        }

        private androidx.core.graphics.b u() {
            Y y5 = this.f9784f;
            return y5 != null ? y5.g() : androidx.core.graphics.b.f9641e;
        }

        private androidx.core.graphics.b v(View view) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @Override // androidx.core.view.Y.k
        void d(View view) {
            androidx.core.graphics.b bVarV = v(view);
            if (bVarV == null) {
                bVarV = androidx.core.graphics.b.f9641e;
            }
            q(bVarV);
        }

        @Override // androidx.core.view.Y.k
        void e(Y y5) {
            y5.r(this.f9784f);
            y5.q(this.f9785g);
        }

        @Override // androidx.core.view.Y.k
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f9785g, ((f) obj).f9785g);
            }
            return false;
        }

        @Override // androidx.core.view.Y.k
        public androidx.core.graphics.b g(int i5) {
            return s(i5, false);
        }

        @Override // androidx.core.view.Y.k
        final androidx.core.graphics.b k() {
            if (this.f9783e == null) {
                this.f9783e = androidx.core.graphics.b.b(this.f9781c.getSystemWindowInsetLeft(), this.f9781c.getSystemWindowInsetTop(), this.f9781c.getSystemWindowInsetRight(), this.f9781c.getSystemWindowInsetBottom());
            }
            return this.f9783e;
        }

        @Override // androidx.core.view.Y.k
        Y m(int i5, int i6, int i7, int i8) {
            b bVar = new b(Y.t(this.f9781c));
            bVar.c(Y.m(k(), i5, i6, i7, i8));
            bVar.b(Y.m(i(), i5, i6, i7, i8));
            return bVar.a();
        }

        @Override // androidx.core.view.Y.k
        boolean o() {
            return this.f9781c.isRound();
        }

        @Override // androidx.core.view.Y.k
        public void p(androidx.core.graphics.b[] bVarArr) {
            this.f9782d = bVarArr;
        }

        @Override // androidx.core.view.Y.k
        void q(androidx.core.graphics.b bVar) {
            this.f9785g = bVar;
        }

        @Override // androidx.core.view.Y.k
        void r(Y y5) {
            this.f9784f = y5;
        }

        protected androidx.core.graphics.b t(int i5, boolean z5) {
            androidx.core.graphics.b bVarG;
            int i6;
            if (i5 == 1) {
                return z5 ? androidx.core.graphics.b.b(0, Math.max(u().f9643b, k().f9643b), 0, 0) : androidx.core.graphics.b.b(0, k().f9643b, 0, 0);
            }
            if (i5 == 2) {
                if (z5) {
                    androidx.core.graphics.b bVarU = u();
                    androidx.core.graphics.b bVarI = i();
                    return androidx.core.graphics.b.b(Math.max(bVarU.f9642a, bVarI.f9642a), 0, Math.max(bVarU.f9644c, bVarI.f9644c), Math.max(bVarU.f9645d, bVarI.f9645d));
                }
                androidx.core.graphics.b bVarK = k();
                Y y5 = this.f9784f;
                bVarG = y5 != null ? y5.g() : null;
                int iMin = bVarK.f9645d;
                if (bVarG != null) {
                    iMin = Math.min(iMin, bVarG.f9645d);
                }
                return androidx.core.graphics.b.b(bVarK.f9642a, 0, bVarK.f9644c, iMin);
            }
            if (i5 != 8) {
                if (i5 == 16) {
                    return j();
                }
                if (i5 == 32) {
                    return h();
                }
                if (i5 == 64) {
                    return l();
                }
                if (i5 != 128) {
                    return androidx.core.graphics.b.f9641e;
                }
                Y y6 = this.f9784f;
                C0462g c0462gE = y6 != null ? y6.e() : f();
                return c0462gE != null ? androidx.core.graphics.b.b(c0462gE.b(), c0462gE.d(), c0462gE.c(), c0462gE.a()) : androidx.core.graphics.b.f9641e;
            }
            androidx.core.graphics.b[] bVarArr = this.f9782d;
            bVarG = bVarArr != null ? bVarArr[l.b(8)] : null;
            if (bVarG != null) {
                return bVarG;
            }
            androidx.core.graphics.b bVarK2 = k();
            androidx.core.graphics.b bVarU2 = u();
            int i7 = bVarK2.f9645d;
            if (i7 > bVarU2.f9645d) {
                return androidx.core.graphics.b.b(0, 0, 0, i7);
            }
            androidx.core.graphics.b bVar = this.f9785g;
            return (bVar == null || bVar.equals(androidx.core.graphics.b.f9641e) || (i6 = this.f9785g.f9645d) <= bVarU2.f9645d) ? androidx.core.graphics.b.f9641e : androidx.core.graphics.b.b(0, 0, 0, i6);
        }

        f(Y y5, f fVar) {
            this(y5, new WindowInsets(fVar.f9781c));
        }
    }

    public Y(Y y5) {
        if (y5 != null) {
            k kVar = y5.f9772a;
            if (kVar instanceof j) {
                this.f9772a = new j(this, (j) kVar);
            } else if (kVar instanceof i) {
                this.f9772a = new i(this, (i) kVar);
            } else if (kVar instanceof h) {
                this.f9772a = new h(this, (h) kVar);
            } else if (kVar instanceof g) {
                this.f9772a = new g(this, (g) kVar);
            } else if (kVar instanceof f) {
                this.f9772a = new f(this, (f) kVar);
            } else {
                this.f9772a = new k(this);
            }
            kVar.e(this);
            return;
        }
        this.f9772a = new k(this);
    }

    private static class i extends h {

        /* renamed from: i, reason: collision with root package name */
        private androidx.core.graphics.b f9787i;

        /* renamed from: j, reason: collision with root package name */
        private androidx.core.graphics.b f9788j;

        /* renamed from: k, reason: collision with root package name */
        private androidx.core.graphics.b f9789k;

        i(Y y5, WindowInsets windowInsets) {
            super(y5, windowInsets);
            this.f9787i = null;
            this.f9788j = null;
            this.f9789k = null;
        }

        @Override // androidx.core.view.Y.k
        androidx.core.graphics.b h() {
            if (this.f9788j == null) {
                this.f9788j = androidx.core.graphics.b.d(this.f9781c.getMandatorySystemGestureInsets());
            }
            return this.f9788j;
        }

        @Override // androidx.core.view.Y.k
        androidx.core.graphics.b j() {
            if (this.f9787i == null) {
                this.f9787i = androidx.core.graphics.b.d(this.f9781c.getSystemGestureInsets());
            }
            return this.f9787i;
        }

        @Override // androidx.core.view.Y.k
        androidx.core.graphics.b l() {
            if (this.f9789k == null) {
                this.f9789k = androidx.core.graphics.b.d(this.f9781c.getTappableElementInsets());
            }
            return this.f9789k;
        }

        @Override // androidx.core.view.Y.f, androidx.core.view.Y.k
        Y m(int i5, int i6, int i7, int i8) {
            return Y.t(this.f9781c.inset(i5, i6, i7, i8));
        }

        i(Y y5, i iVar) {
            super(y5, iVar);
            this.f9787i = null;
            this.f9788j = null;
            this.f9789k = null;
        }
    }
}
