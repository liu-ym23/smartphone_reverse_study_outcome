package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: SpecialEffectsController.java */
/* JADX INFO: loaded from: classes.dex */
abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ArrayList<b> f1882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayList<b> f1883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f1884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f1885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ViewGroup f1886e;

    /* JADX INFO: renamed from: androidx.fragment.app.t$3, reason: invalid class name */
    /* JADX INFO: compiled from: SpecialEffectsController.java */
    static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1891a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f1892b = null;

        static {
            int[] r0 = new int[b.a.values().length];
            f1892b = r0;
            r0[b.a.f1901b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L23:
            f1892b[b.a.f1902c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L27:
            f1892b[b.a.f1900a.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            int[] r3 = new int[b.EnumC0056b.values().length];
            f1891a = r3;
            r3[b.EnumC0056b.f1904a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L33:
            f1891a[b.EnumC0056b.f1905b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L21:
            f1891a[b.EnumC0056b.f1906c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L25:
            f1891a[b.EnumC0056b.f1907d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
            return;
        }
    }

    /* JADX INFO: compiled from: SpecialEffectsController.java */
    private static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final k f1893a;

        a(b.EnumC0056b r2, b.a r3, k r4, androidx.core.os.f r5) {
            super(r2, r3, r4.a(), r5);
            this.f1893a = r4;
        }

        @Override // androidx.fragment.app.t.b
        void a() {
            if (d() != b.a.f1901b) goto L19;
            Fragment r0 = this.f1893a.a();
            View r1 = r0.mView.findFocus();
            if (r1 == null) goto L9;
            r0.setFocusedView(r1);
            if (FragmentManager.a(2) == false) goto L9;
            a("FragmentManager", "requestFocus: Saved focused view " + r1 + " for Fragment " + r0);
        L9:
            View r2 = e().requireView();
            if (r2.getParent() != null) goto L13;
            this.f1893a.s();
            r2.setAlpha(0.0f);
        L13:
            if (r2.getAlpha() == 0.0f) goto L15;
        L17:
            r2.setAlpha(r0.getPostOnViewCreatedAlpha());
            return;
        L15:
            if (r2.getVisibility() != 0) goto L17;
            r2.setVisibility(4);
            goto L17
        }

        @Override // androidx.fragment.app.t.b
        public void b() {
            super.b();
            this.f1893a.c();
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.v(r1, r2);
        }
    }

    /* JADX INFO: compiled from: SpecialEffectsController.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private EnumC0056b f1894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private a f1895b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Fragment f1896c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<Runnable> f1897d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final HashSet<androidx.core.os.f> f1898e;
        private boolean f;
        private boolean g;

        /* JADX INFO: compiled from: SpecialEffectsController.java */
        static final enum a extends Enum<a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f1900a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final a f1901b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final a f1902c = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private static final /* synthetic */ a[] f1903d = null;

            private a(String r1, int r2) {
                super(r1, r2);
            }

            public static a valueOf(String r2) {
                return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
            }

            public static a[] values() {
                return (a[]) ZeusTransformUtils.preCheckCast(f1903d.clone(), a[].class, "com.obric.aiagent.plugin");
            }

            static {
                a r0 = new a("NONE", 0);
                f1900a = r0;
                a r1 = new a("ADDING", 1);
                f1901b = r1;
                a r3 = new a("REMOVING", 2);
                f1902c = r3;
                f1903d = new a[]{r0, r1, r3};
            }
        }

        /* JADX INFO: renamed from: androidx.fragment.app.t$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SpecialEffectsController.java */
        static final enum EnumC0056b extends Enum<EnumC0056b> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final EnumC0056b f1904a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final EnumC0056b f1905b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final EnumC0056b f1906c = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final EnumC0056b f1907d = null;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private static final /* synthetic */ EnumC0056b[] f1908e = null;

            private EnumC0056b(String r1, int r2) {
                super(r1, r2);
            }

            public static EnumC0056b valueOf(String r2) {
                return (EnumC0056b) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0056b.class, r2), EnumC0056b.class, "com.obric.aiagent.plugin");
            }

            public static EnumC0056b[] values() {
                return (EnumC0056b[]) ZeusTransformUtils.preCheckCast(f1908e.clone(), EnumC0056b[].class, "com.obric.aiagent.plugin");
            }

            static {
                EnumC0056b r0 = new EnumC0056b("REMOVED", 0);
                f1904a = r0;
                EnumC0056b r1 = new EnumC0056b("VISIBLE", 1);
                f1905b = r1;
                EnumC0056b r3 = new EnumC0056b("GONE", 2);
                f1906c = r3;
                EnumC0056b r5 = new EnumC0056b("INVISIBLE", 3);
                f1907d = r5;
                f1908e = new EnumC0056b[]{r0, r1, r3, r5};
            }

            static EnumC0056b a(View r2) {
                if (r2.getAlpha() != 0.0f) goto L9;
                if (r2.getVisibility() != 0) goto L9;
                return f1907d;
            L9:
                return a(r2.getVisibility());
            }

            static EnumC0056b a(int r3) {
                if (r3 == 0) goto L14;
                if (r3 == 4) goto L12;
                if (r3 != 8) goto L10;
                return f1906c;
            L10:
                throw new IllegalArgumentException("Unknown visibility " + r3);
            L12:
                return f1907d;
            L14:
                return f1905b;
            }

            void b(View r5) {
                int r4 = AnonymousClass3.f1891a[ordinal()];
                if (r4 != 1) goto L5;
                ViewGroup r6 = (ViewGroup) ZeusTransformUtils.preCheckCast(r5.getParent(), ViewGroup.class, "com.obric.aiagent.plugin");
                if (r6 != null) goto L26;
                return;
            L26:
                if (FragmentManager.a(2) == false) goto L28;
                a("FragmentManager", "SpecialEffectsController: Removing view " + r5 + " from container " + r6);
            L28:
                r6.removeView(r5);
                return;
            L5:
                if (r4 == 2) goto L20;
                if (r4 == 3) goto L16;
                if (r4 == 4) goto L12;
                return;
            L12:
                if (FragmentManager.a(2) == false) goto L14;
                a("FragmentManager", "SpecialEffectsController: Setting view " + r5 + " to INVISIBLE");
            L14:
                r5.setVisibility(4);
                return;
            L16:
                if (FragmentManager.a(2) == false) goto L18;
                a("FragmentManager", "SpecialEffectsController: Setting view " + r5 + " to GONE");
            L18:
                r5.setVisibility(8);
                return;
            L20:
                if (FragmentManager.a(2) == false) goto L22;
                a("FragmentManager", "SpecialEffectsController: Setting view " + r5 + " to VISIBLE");
            L22:
                r5.setVisibility(0);
            }

            @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
            public static int a(String r1, String r2) {
                if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
                return 0;
            L5:
                return Log.v(r1, r2);
            }
        }

        void a() {
        }

        b(EnumC0056b r2, a r3, Fragment r4, androidx.core.os.f r5) {
            this.f1897d = new ArrayList();
            this.f1898e = new HashSet();
            this.f = false;
            this.g = false;
            this.f1894a = r2;
            this.f1895b = r3;
            this.f1896c = r4;
            r5.a(new AnonymousClass1(this));
        }

        public EnumC0056b c() {
            return this.f1894a;
        }

        a d() {
            return this.f1895b;
        }

        public final Fragment e() {
            return this.f1896c;
        }

        final boolean f() {
            return this.f;
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f1894a + "} {mLifecycleImpact = " + this.f1895b + "} {mFragment = " + this.f1896c + "}";
        }

        final void g() {
            if (f() == false) goto L5;
            return;
        L5:
            this.f = true;
            if (this.f1898e.isEmpty() == false) goto L8;
            b();
            return;
        L8:
            Iterator r3 = new ArrayList(this.f1898e).iterator();
        L10:
            if (r3.hasNext() == false) goto L14;
            ((androidx.core.os.f) ZeusTransformUtils.preCheckCast(r3.next(), androidx.core.os.f.class, "com.obric.aiagent.plugin")).b();
            goto L10
        }

        final void a(EnumC0056b r6, a r7) {
            int r8 = AnonymousClass3.f1892b[r7.ordinal()];
            if (r8 == 1) goto L20;
            if (r8 == 2) goto L16;
            if (r8 == 3) goto L10;
            return;
        L10:
            if (this.f1894a != EnumC0056b.f1904a) goto L12;
            return;
        L12:
            if (FragmentManager.a(2) == false) goto L14;
            b("FragmentManager", "SpecialEffectsController: For fragment " + this.f1896c + " mFinalState = " + this.f1894a + " -> " + r6 + ". ");
        L14:
            this.f1894a = r6;
            return;
        L16:
            if (FragmentManager.a(2) == false) goto L18;
            b("FragmentManager", "SpecialEffectsController: For fragment " + this.f1896c + " mFinalState = " + this.f1894a + " -> REMOVED. mLifecycleImpact  = " + this.f1895b + " to REMOVING.");
        L18:
            this.f1894a = EnumC0056b.f1904a;
            this.f1895b = a.f1902c;
            return;
        L20:
            if (this.f1894a == EnumC0056b.f1904a) goto L22;
            return;
        L22:
            if (FragmentManager.a(2) == false) goto L24;
            b("FragmentManager", "SpecialEffectsController: For fragment " + this.f1896c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f1895b + " to ADDING.");
        L24:
            this.f1894a = EnumC0056b.f1905b;
            this.f1895b = a.f1901b;
        }

        final void a(Runnable r3) {
            Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
            this.f1897d.add(r4);
        }

        public final void a(androidx.core.os.f r1) {
            a();
            this.f1898e.add(r1);
        }

        public final void b(androidx.core.os.f r2) {
            if (this.f1898e.remove(r2) == true) goto L5;
            return;
        L5:
            if (this.f1898e.isEmpty() == false) goto L9;
            b();
            return;
        }

        final boolean h() {
            return this.g;
        }

        public void b() {
            if (this.g == false) goto L6;
            return;
        L6:
            if (FragmentManager.a(2) == false) goto L8;
            b("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
        L8:
            this.g = true;
            Iterator<Runnable> r3 = this.f1897d.iterator();
        L10:
            if (r3.hasNext() == false) goto L12;
            ((Runnable) ZeusTransformUtils.preCheckCast(r3.next(), Runnable.class, "com.obric.aiagent.plugin")).run();
            goto L10
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int b(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.v(r1, r2);
        }
    }

    abstract void a(List<b> r1, boolean r2);

    static t a(ViewGroup r0, FragmentManager r1) {
        return a(r0, r1.E());
    }

    static t a(ViewGroup r6, u r7) {
        u r8 = (u) ZeusTransformUtils.wrapperContextForParams(r7, u.class, "com.obric.aiagent.plugin");
        Object r1 = r6.getTag(ZeusTransformUtils.mapRes(R.id.special_effects_controller_view_tag, DbHelper.COL_ID, "special_effects_controller_view_tag"));
        if (ZeusTransformUtils.instanceOf(r1, t.class) == true) goto L5;
        t r9 = r8.a(r6);
        r6.setTag(ZeusTransformUtils.mapRes(R.id.special_effects_controller_view_tag, DbHelper.COL_ID, "special_effects_controller_view_tag"), r9);
        return r9;
    L5:
        return (t) ZeusTransformUtils.preCheckCast(r1, t.class, "com.obric.aiagent.plugin");
    }

    t(ViewGroup r2) {
        this.f1882a = new ArrayList();
        this.f1883b = new ArrayList();
        this.f1884c = false;
        this.f1885d = false;
        this.f1886e = r2;
    }

    public ViewGroup a() {
        return this.f1886e;
    }

    b.a a(k r2) {
        b r0 = a(r2.a());
        if (r0 == null) goto L5;
        b.a r1 = r0.d();
    L6:
        b r3 = b(r2.a());
        if (r3 == null) goto L13;
        if (r1 == null) goto L12;
        if (r1 != b.a.f1900a) goto L13;
    L12:
        return r3.d();
    L13:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    private b a(Fragment r4) {
        Iterator<b> r3 = this.f1882a.iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.aiagent.plugin");
        if (r0.e().equals(r4) == false) goto L4;
        if (r0.f() == true) goto L4;
        return r0;
    L10:
        return null;
    }

    private b b(Fragment r4) {
        Iterator<b> r3 = this.f1883b.iterator();
    L4:
        if (r3.hasNext() == false) goto L10;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.aiagent.plugin");
        if (r0.e().equals(r4) == false) goto L4;
        if (r0.f() == true) goto L4;
        return r0;
    L10:
        return null;
    }

    void a(b.EnumC0056b r3, k r4) {
        if (FragmentManager.a(2) == false) goto L5;
        b("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + r4.a());
    L5:
        a(r3, b.a.f1901b, r4);
    }

    void b(k r3) {
        if (FragmentManager.a(2) == false) goto L5;
        b("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + r3.a());
    L5:
        a(b.EnumC0056b.f1905b, b.a.f1900a, r3);
    }

    void c(k r3) {
        if (FragmentManager.a(2) == false) goto L5;
        b("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + r3.a());
    L5:
        a(b.EnumC0056b.f1906c, b.a.f1900a, r3);
    }

    void d(k r3) {
        if (FragmentManager.a(2) == false) goto L5;
        b("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + r3.a());
    L5:
        a(b.EnumC0056b.f1904a, b.a.f1902c, r3);
    }

    private void a(b.EnumC0056b r4, b.a r5, k r6) {
        ArrayList<b> r0 = this.f1882a;
        monitor-enter(r0);
        androidx.core.os.f r1 = new androidx.core.os.f();     // Catch: Throwable -> L12
        b r2 = a(r6.a());     // Catch: Throwable -> L12
        if (r2 == null) goto L9;
        r2.a(r4, r5);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L9:
        final a r3 = new a(r4, r5, r6, r1);     // Catch: Throwable -> L12
        this.f1882a.add(r3);     // Catch: Throwable -> L12
        r3.a(new AnonymousClass1(this, r3));     // Catch: Throwable -> L12
        r3.a(new AnonymousClass2(this, r3));     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    void a(boolean r1) {
        this.f1884c = r1;
    }

    void b() {
        ArrayList<b> r0 = this.f1882a;
        monitor-enter(r0);
        f();     // Catch: Throwable -> L14
        this.f1885d = false;     // Catch: Throwable -> L14
        int r1 = this.f1882a.size() - 1;     // Catch: Throwable -> L14
    L5:
        if (r1 < 0) goto L12;
        b r2 = (b) ZeusTransformUtils.preCheckCast(this.f1882a.get(r1), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        b.EnumC0056b r3 = b.EnumC0056b.a(r2.e().mView);     // Catch: Throwable -> L14
        if (r2.c() != b.EnumC0056b.f1905b) goto L11;
        if (r3 == b.EnumC0056b.f1905b) goto L11;
        this.f1885d = r2.e().isPostponed();     // Catch: Throwable -> L14
    L11:
        r1 = r1 - 1;     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    void c() {
        if (this.f1885d == false) goto L6;
        this.f1885d = false;
        d();
        return;
    }

    void d() {
        if (this.f1885d == false) goto L6;
        return;
    L6:
        if (ViewCompat.I(this.f1886e) == true) goto L9;
        e();
        this.f1884c = false;
        return;
    L9:
        ArrayList<b> r0 = this.f1882a;
        monitor-enter(r0);
    L29:
        th = move-exception;
        throw th;
    L12:
        if (this.f1882a.isEmpty() == true) goto L27;
        ArrayList r2 = new ArrayList(this.f1883b);     // Catch: Throwable -> L29
        this.f1883b.clear();     // Catch: Throwable -> L29
        Iterator r3 = r2.iterator();     // Catch: Throwable -> L29
    L15:
        if (r3.hasNext() == false) goto L22;
        b r4 = (b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        if (FragmentManager.a(2) == false) goto L19;
        b("FragmentManager", "SpecialEffectsController: Cancelling operation " + r4);     // Catch: Throwable -> L29
    L19:
        r4.g();     // Catch: Throwable -> L29
        if (r4.h() == true) goto L15;
        this.f1883b.add(r4);     // Catch: Throwable -> L29
        goto L15
    L22:
        f();     // Catch: Throwable -> L29
        ArrayList r5 = new ArrayList(this.f1882a);     // Catch: Throwable -> L29
        this.f1882a.clear();     // Catch: Throwable -> L29
        this.f1883b.addAll(r5);     // Catch: Throwable -> L29
        Iterator r6 = r5.iterator();     // Catch: Throwable -> L29
    L24:
        if (r6.hasNext() == false) goto L26;
        ((b) ZeusTransformUtils.preCheckCast(r6.next(), b.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L29
        goto L24
    L26:
        a(r5, this.f1884c);     // Catch: Throwable -> L29
        this.f1884c = false;     // Catch: Throwable -> L29
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L29
    }

    void e() {
        boolean r0 = ViewCompat.I(this.f1886e);
        ArrayList<b> r1 = this.f1882a;
        monitor-enter(r1);
        f();     // Catch: Throwable -> L32
        Iterator<b> r2 = this.f1882a.iterator();     // Catch: Throwable -> L32
    L6:
        if (r2.hasNext() == false) goto L8;
        ((b) ZeusTransformUtils.preCheckCast(r2.next(), b.class, "com.obric.aiagent.plugin")).a();     // Catch: Throwable -> L32
        goto L6
    L8:
        Iterator r3 = new ArrayList(this.f1883b).iterator();     // Catch: Throwable -> L32
    L10:
        if (r3.hasNext() == false) goto L19;
        b r4 = (b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        if (FragmentManager.a(2) == false) goto L18;
        StringBuilder r5 = new StringBuilder().append("SpecialEffectsController: ");     // Catch: Throwable -> L32
        if (r0 == false) goto L16;
        String r6 = "";
    L17:
        b("FragmentManager", r5.append(r6).append("Cancelling running operation ").append(r4).toString());     // Catch: Throwable -> L32
        goto L18
    L16:
        r6 = "Container " + this.f1886e + " is not attached to window. ";     // Catch: Throwable -> L32
    L18:
        r4.g();     // Catch: Throwable -> L32
        goto L10
    L19:
        Iterator r7 = new ArrayList(this.f1882a).iterator();     // Catch: Throwable -> L32
    L21:
        if (r7.hasNext() == false) goto L30;
        b r8 = (b) ZeusTransformUtils.preCheckCast(r7.next(), b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L32
        if (FragmentManager.a(2) == false) goto L29;
        StringBuilder r9 = new StringBuilder().append("SpecialEffectsController: ");     // Catch: Throwable -> L32
        if (r0 == false) goto L27;
        String r10 = "";
    L28:
        b("FragmentManager", r9.append(r10).append("Cancelling pending operation ").append(r8).toString());     // Catch: Throwable -> L32
        goto L29
    L27:
        r10 = "Container " + this.f1886e + " is not attached to window. ";     // Catch: Throwable -> L32
    L29:
        r8.g();     // Catch: Throwable -> L32
        goto L21
    L30:
        monitor-exit(r1);     // Catch: Throwable -> L32
        return;
    L32:
        th = move-exception;
        throw th;
    }

    private void f() {
        Iterator<b> r3 = this.f1882a.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r3.next(), b.class, "com.obric.aiagent.plugin");
        if (r0.d() != b.a.f1901b) goto L4;
        r0.a(b.EnumC0056b.a(r0.e().requireView().getVisibility()), b.a.f1900a);
        goto L4
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }
}
