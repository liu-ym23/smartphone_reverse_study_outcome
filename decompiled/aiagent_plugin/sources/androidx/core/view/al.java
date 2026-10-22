package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: WindowInsetsCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class al {
    private static final String TAG = "WindowInsetsCompat";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final al f1456a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f1457b;

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Field f1458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static Field f1459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static Field f1460c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static boolean f1461d;

        static {
            Field r0 = View.class.getDeclaredField("mAttachInfo");     // Catch: ReflectiveOperationException -> L4
            f1458a = r0;     // Catch: ReflectiveOperationException -> L4
            r0.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            Class r1 = ZeusTransformUtils.forName("android.view.View$AttachInfo", "com.obric.aiagent.plugin");     // Catch: ReflectiveOperationException -> L4
            Field r2 = r1.getDeclaredField("mStableInsets");     // Catch: ReflectiveOperationException -> L4
            f1459b = r2;     // Catch: ReflectiveOperationException -> L4
            r2.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            Field r3 = r1.getDeclaredField("mContentInsets");     // Catch: ReflectiveOperationException -> L4
            f1460c = r3;     // Catch: ReflectiveOperationException -> L4
            r3.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            f1461d = true;     // Catch: ReflectiveOperationException -> L4
            return;
        L4:
            e = move-exception;
            a(al.TAG, "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
        }

        public static al a(View r5) {
            if (f1461d == true) goto L5;
        L17:
            return null;
        L5:
            if (r5.isAttachedToWindow() == false) goto L17;
            Object r1 = f1458a.get(r5.getRootView());     // Catch: IllegalAccessException -> L15
            if (r1 == null) goto L17;
            Rect r3 = (Rect) ZeusTransformUtils.preCheckCast(f1459b.get(r1), Rect.class, "com.obric.aiagent.plugin");     // Catch: IllegalAccessException -> L15
            Rect r0 = (Rect) ZeusTransformUtils.preCheckCast(f1460c.get(r1), Rect.class, "com.obric.aiagent.plugin");     // Catch: IllegalAccessException -> L15
            if (r3 == null) goto L17;
            if (r0 == null) goto L17;
            al r2 = new b().b(androidx.core.graphics.g.a(r3)).a(androidx.core.graphics.g.a(r0)).a();     // Catch: IllegalAccessException -> L15
            r2.a(r2);     // Catch: IllegalAccessException -> L15
            r2.a(r5.getRootView());     // Catch: IllegalAccessException -> L15
            return r2;
        L15:
            e = move-exception;
            a(al.TAG, "Failed to get insets from AttachInfo. " + e.getMessage(), e);
            goto L17
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2, Throwable r3) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2, r3);
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f1462a;

        public b() {
            if (Build.VERSION.SDK_INT < 30) goto L6;
            this.f1462a = new f();
            return;
        L6:
            if (Build.VERSION.SDK_INT < 29) goto L9;
            this.f1462a = new e();
            return;
        L9:
            if (Build.VERSION.SDK_INT < 20) goto L11;
            this.f1462a = new d();
            return;
        L11:
            this.f1462a = new c();
        }

        public b(al r3) {
            if (Build.VERSION.SDK_INT < 30) goto L6;
            this.f1462a = new f(r3);
            return;
        L6:
            if (Build.VERSION.SDK_INT < 29) goto L9;
            this.f1462a = new e(r3);
            return;
        L9:
            if (Build.VERSION.SDK_INT < 20) goto L11;
            this.f1462a = new d(r3);
            return;
        L11:
            this.f1462a = new c(r3);
        }

        @Deprecated
        public b a(androidx.core.graphics.g r2) {
            this.f1462a.a(r2);
            return this;
        }

        public b a(int r2, androidx.core.graphics.g r3) {
            this.f1462a.a(r2, r3);
            return this;
        }

        @Deprecated
        public b b(androidx.core.graphics.g r2) {
            this.f1462a.e(r2);
            return this;
        }

        public al a() {
            return this.f1462a.b();
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        androidx.core.graphics.g[] f1463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final al f1464b;

        void a(androidx.core.graphics.g r1) {
        }

        void b(androidx.core.graphics.g r1) {
        }

        void c(androidx.core.graphics.g r1) {
        }

        void d(androidx.core.graphics.g r1) {
        }

        void e(androidx.core.graphics.g r1) {
        }

        c() {
            this(new al((al) ZeusTransformUtils.preCheckCast(null, al.class, "com.obric.aiagent.plugin")));
        }

        c(al r1) {
            this.f1464b = r1;
        }

        void a(int r4, androidx.core.graphics.g r5) {
            if (this.f1463a != null) goto L5;
            this.f1463a = new androidx.core.graphics.g[9];
        L5:
            int r0 = 1;
        L7:
            if (r0 > 256) goto L13;
            if ((r4 & r0) == 0) goto L12;
            this.f1463a[m.a(r0)] = r5;
        L12:
            r0 = r0 << 1;
            goto L7
        }

        public final void a() {
            androidx.core.graphics.g[] r0 = this.f1463a;
            if (r0 == null) goto L19;
            androidx.core.graphics.g r1 = r0[m.a(1)];
            androidx.core.graphics.g r2 = this.f1463a[m.a(2)];
            if (r2 != null) goto L7;
            r2 = this.f1464b.a(2);
        L7:
            if (r1 != null) goto L9;
            r1 = this.f1464b.a(1);
        L9:
            a(androidx.core.graphics.g.a(r1, r2));
            androidx.core.graphics.g r3 = this.f1463a[m.a(16)];
            if (r3 == null) goto L12;
            b(r3);
        L12:
            androidx.core.graphics.g r4 = this.f1463a[m.a(32)];
            if (r4 == null) goto L15;
            c(r4);
        L15:
            androidx.core.graphics.g r5 = this.f1463a[m.a(64)];
            if (r5 == null) goto L20;
            d(r5);
            return;
        L20:
            return;
        }

        al b() {
            a();
            return this.f1464b;
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class d extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static Field f1465b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static boolean f1466c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static Constructor<WindowInsets> f1467d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static boolean f1468e = false;
        private WindowInsets f;
        private androidx.core.graphics.g g;

        static {
        }

        d() {
            this.f = c();
        }

        d(al r1) {
            super(r1);
            this.f = r1.m();
        }

        @Override // androidx.core.view.al.c
        void a(androidx.core.graphics.g r5) {
            WindowInsets r0 = this.f;
            if (r0 == null) goto L6;
            this.f = r0.replaceSystemWindowInsets(r5.f1210b, r5.f1211c, r5.f1212d, r5.f1213e);
            return;
        }

        @Override // androidx.core.view.al.c
        void e(androidx.core.graphics.g r1) {
            this.g = r1;
        }

        @Override // androidx.core.view.al.c
        al b() {
            a();
            al r0 = al.a(this.f);
            r0.a(this.f1463a);
            r0.a(this.g);
            return r0;
        }

        private static WindowInsets c() {
            if (f1466c == false) goto L31;
        L9:
            Field r0 = f1465b;
            if (r0 == null) goto L18;
            WindowInsets r1 = (WindowInsets) ZeusTransformUtils.preCheckCast(r0.get(null), WindowInsets.class, "com.obric.aiagent.plugin");     // Catch: ReflectiveOperationException -> L15
            if (r1 == null) goto L18;
            return new WindowInsets(r1);
        L15:
            e = move-exception;
            a(al.TAG, "Could not get value from WindowInsets.CONSUMED field", e);
        L18:
            if (f1468e == false) goto L35;
        L24:
            Constructor<WindowInsets> r2 = f1467d;
            if (r2 != null) goto L33;
        L30:
            return null;
        L33:
            return (WindowInsets) ZeusTransformUtils.preCheckCast(r2.newInstance(new Object[]{new Rect()}), WindowInsets.class, "com.obric.aiagent.plugin");
        L28:
            e = move-exception;
            a(al.TAG, "Could not invoke WindowInsets(Rect) constructor", e);
            goto L30
        L35:
            f1467d = WindowInsets.class.getConstructor(new Class[]{Rect.class});     // Catch: ReflectiveOperationException -> L21
        L23:
            f1468e = true;
        L21:
            e = move-exception;
            a(al.TAG, "Could not retrieve WindowInsets(Rect) constructor", e);
            goto L23
        L31:
            f1465b = WindowInsets.class.getDeclaredField("CONSUMED");     // Catch: ReflectiveOperationException -> L6
        L8:
            f1466c = true;
        L6:
            e = move-exception;
            a(al.TAG, "Could not retrieve WindowInsets.CONSUMED field", e);
            goto L8
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2, Throwable r3) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.i(r1, r2, r3);
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class e extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final WindowInsets.Builder f1469b;

        e() {
            this.f1469b = new WindowInsets.Builder();
        }

        e(al r2) {
            super(r2);
            WindowInsets r3 = r2.m();
            if (r3 == null) goto L5;
            WindowInsets.Builder r0 = new WindowInsets.Builder(r3);
        L6:
            this.f1469b = r0;
            return;
        L5:
            r0 = new WindowInsets.Builder();
            goto L6
        }

        @Override // androidx.core.view.al.c
        void a(androidx.core.graphics.g r1) {
            this.f1469b.setSystemWindowInsets(r1.a());
        }

        @Override // androidx.core.view.al.c
        void b(androidx.core.graphics.g r1) {
            this.f1469b.setSystemGestureInsets(r1.a());
        }

        @Override // androidx.core.view.al.c
        void c(androidx.core.graphics.g r1) {
            this.f1469b.setMandatorySystemGestureInsets(r1.a());
        }

        @Override // androidx.core.view.al.c
        void d(androidx.core.graphics.g r1) {
            this.f1469b.setTappableElementInsets(r1.a());
        }

        @Override // androidx.core.view.al.c
        void e(androidx.core.graphics.g r1) {
            this.f1469b.setStableInsets(r1.a());
        }

        @Override // androidx.core.view.al.c
        al b() {
            a();
            al r0 = al.a(this.f1469b.build());
            r0.a(this.f1463a);
            return r0;
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class f extends e {
        f() {
        }

        f(al r1) {
            super(r1);
        }

        @Override // androidx.core.view.al.c
        void a(int r1, androidx.core.graphics.g r2) {
            this.f1469b.setInsets(n.a(r1), r2.a());
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final al f1470a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final al f1471b;

        void a(View r1) {
        }

        void a(androidx.core.graphics.g r1) {
        }

        void a(al r1) {
        }

        public void a(androidx.core.graphics.g[] r1) {
        }

        boolean a() {
            return false;
        }

        public void b(androidx.core.graphics.g r1) {
        }

        void b(al r1) {
        }

        boolean b() {
            return false;
        }

        boolean b(int r1) {
            return true;
        }

        androidx.core.view.c e() {
            return null;
        }

        static {
            f1470a = new b().a().j().h().g();
        }

        g(al r1) {
            this.f1471b = r1;
        }

        al c() {
            return this.f1471b;
        }

        al d() {
            return this.f1471b;
        }

        al f() {
            return this.f1471b;
        }

        androidx.core.graphics.g g() {
            return androidx.core.graphics.g.f1209a;
        }

        androidx.core.graphics.g h() {
            return androidx.core.graphics.g.f1209a;
        }

        androidx.core.graphics.g i() {
            return g();
        }

        androidx.core.graphics.g j() {
            return g();
        }

        androidx.core.graphics.g k() {
            return g();
        }

        al a(int r1, int r2, int r3, int r4) {
            return f1470a;
        }

        androidx.core.graphics.g a(int r1) {
            return androidx.core.graphics.g.f1209a;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
            return false;
        L8:
            g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
            if (a() != r6.a()) goto L20;
            if (b() != r6.b()) goto L20;
            if (androidx.core.util.d.a(g(), r6.g()) == false) goto L20;
            if (androidx.core.util.d.a(h(), r6.h()) == false) goto L20;
            if (androidx.core.util.d.a(e(), r6.e()) == false) goto L20;
            return true;
        L20:
            return false;
        }

        public int hashCode() {
            return androidx.core.util.d.a(new Object[]{Boolean.valueOf(a()), Boolean.valueOf(b()), g(), h(), e()});
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class h extends g {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static boolean f1472e = false;
        private static Method f;
        private static Class<?> g;
        private static Field h;
        private static Field i;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final WindowInsets f1473c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        androidx.core.graphics.g f1474d;
        private androidx.core.graphics.g[] j;
        private androidx.core.graphics.g k;
        private al l;

        static {
        }

        h(al r1, WindowInsets r2) {
            super(r1);
            this.k = null;
            this.f1473c = r2;
        }

        h(al r2, h r3) {
            this(r2, new WindowInsets(r3.f1473c));
        }

        @Override // androidx.core.view.al.g
        boolean a() {
            return this.f1473c.isRound();
        }

        @Override // androidx.core.view.al.g
        public androidx.core.graphics.g a(int r2) {
            return b(r2, false);
        }

        @Override // androidx.core.view.al.g
        boolean b(int r4) {
            int r1 = 1;
        L4:
            if (r1 > 256) goto L13;
            if ((r4 & r1) == 0) goto L12;
            if (c(r1) == true) goto L12;
            return false;
        L12:
            r1 = r1 << 1;
            goto L4
        L13:
            return true;
        }

        private androidx.core.graphics.g b(int r4, boolean r5) {
            androidx.core.graphics.g r0 = androidx.core.graphics.g.f1209a;
            int r1 = 1;
        L4:
            if (r1 > 256) goto L10;
            if ((r4 & r1) == 0) goto L9;
            r0 = androidx.core.graphics.g.a(r0, a(r1, r5));
        L9:
            r1 = r1 << 1;
            goto L4
        L10:
            return r0;
        }

        public androidx.core.graphics.g a(int r4, boolean r5) {
            if (r4 == 1) goto L63;
            androidx.core.graphics.g r2 = null;
            if (r4 != 2) goto L7;
            if (r5 == false) goto L55;
            androidx.core.graphics.g r6 = l();
            androidx.core.graphics.g r3 = h();
            return androidx.core.graphics.g.a(Math.max(r6.f1210b, r3.f1210b), 0, Math.max(r6.f1212d, r3.f1212d), Math.max(r6.f1213e, r3.f1213e));
        L55:
            androidx.core.graphics.g r7 = g();
            al r8 = this.l;
            if (r8 == null) goto L58;
            r2 = r8.k();
        L58:
            int r9 = r7.f1213e;
            if (r2 == null) goto L62;
            r9 = Math.min(r9, r2.f1213e);
        L62:
            return androidx.core.graphics.g.a(r7.f1210b, 0, r7.f1212d, r9);
        L7:
            if (r4 != 8) goto L9;
            androidx.core.graphics.g[] r10 = this.j;
            if (r10 == null) goto L36;
            r2 = r10[m.a(8)];
        L36:
            if (r2 == null) goto L38;
            return r2;
        L38:
            androidx.core.graphics.g r11 = g();
            androidx.core.graphics.g r12 = l();
            if (r11.f1213e > r12.f1213e) goto L41;
            androidx.core.graphics.g r13 = this.f1474d;
            if (r13 == null) goto L51;
            if (r13.equals(androidx.core.graphics.g.f1209a) == true) goto L51;
            if (this.f1474d.f1213e <= r12.f1213e) goto L51;
            return androidx.core.graphics.g.a(0, 0, 0, this.f1474d.f1213e);
        L51:
            return androidx.core.graphics.g.f1209a;
        L41:
            return androidx.core.graphics.g.a(0, 0, 0, r11.f1213e);
        L9:
            if (r4 == 16) goto L32;
            if (r4 == 32) goto L30;
            if (r4 == 64) goto L28;
            if (r4 != 128) goto L17;
            al r14 = this.l;
            if (r14 == null) goto L21;
            androidx.core.view.c r15 = r14.i();
        L22:
            if (r15 == null) goto L26;
            return androidx.core.graphics.g.a(r15.c(), r15.a(), r15.d(), r15.b());
        L26:
            return androidx.core.graphics.g.f1209a;
        L21:
            r15 = e();
            goto L22
        L17:
            return androidx.core.graphics.g.f1209a;
        L28:
            return k();
        L30:
            return j();
        L32:
            return i();
        L63:
            if (r5 == false) goto L67;
            return androidx.core.graphics.g.a(0, Math.max(l().f1211c, g().f1211c), 0, 0);
        L67:
            return androidx.core.graphics.g.a(0, g().f1211c, 0, 0);
        }

        public boolean c(int r4) {
            if (r4 == 1) goto L15;
            if (r4 == 2) goto L15;
            if (r4 != 4) goto L9;
            return false;
        L9:
            if (r4 == 8) goto L15;
            if (r4 == 128) goto L15;
            return true;
        L15:
            return !a(r4, false).equals(androidx.core.graphics.g.f1209a);
        }

        @Override // androidx.core.view.al.g
        final androidx.core.graphics.g g() {
            if (this.k != null) goto L6;
            this.k = androidx.core.graphics.g.a(this.f1473c.getSystemWindowInsetLeft(), this.f1473c.getSystemWindowInsetTop(), this.f1473c.getSystemWindowInsetRight(), this.f1473c.getSystemWindowInsetBottom());
        L6:
            return this.k;
        }

        @Override // androidx.core.view.al.g
        al a(int r3, int r4, int r5, int r6) {
            b r0 = new b(al.a(this.f1473c));
            r0.a(al.a(g(), r3, r4, r5, r6));
            r0.b(al.a(h(), r3, r4, r5, r6));
            return r0.a();
        }

        @Override // androidx.core.view.al.g
        void b(al r2) {
            r2.a(this.l);
            r2.b(this.f1474d);
        }

        @Override // androidx.core.view.al.g
        void a(al r1) {
            this.l = r1;
        }

        @Override // androidx.core.view.al.g
        void a(androidx.core.graphics.g r1) {
            this.f1474d = r1;
        }

        private androidx.core.graphics.g l() {
            al r0 = this.l;
            if (r0 == null) goto L7;
            return r0.k();
        L7:
            return androidx.core.graphics.g.f1209a;
        }

        @Override // androidx.core.view.al.g
        void a(View r1) {
            androidx.core.graphics.g r2 = b(r1);
            if (r2 != null) goto L5;
            r2 = androidx.core.graphics.g.f1209a;
        L5:
            a(r2);
        }

        private androidx.core.graphics.g b(View r4) {
            if (Build.VERSION.SDK_INT >= 30) goto L27;
            if (f1472e == true) goto L7;
            m();
        L7:
            Method r0 = f;
            if (r0 != null) goto L10;
        L25:
            return null;
        L10:
            if (g == null) goto L25;
            if (h == null) goto L25;
            Object r5 = r0.invoke(r4, new Object[0]);     // Catch: ReflectiveOperationException -> L23
            if (r5 != null) goto L19;
            a(al.TAG, "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());     // Catch: ReflectiveOperationException -> L23
            return null;
        L19:
            Rect r6 = (Rect) ZeusTransformUtils.preCheckCast(h.get(i.get(r5)), Rect.class, "com.obric.aiagent.plugin");     // Catch: ReflectiveOperationException -> L23
            if (r6 != null) goto L22;
            return null;
        L22:
            return androidx.core.graphics.g.a(r6);
        L23:
            e = move-exception;
            b(al.TAG, "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            goto L25
        L27:
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @Override // androidx.core.view.al.g
        public void a(androidx.core.graphics.g[] r1) {
            this.j = r1;
        }

        private static void m() {
            f = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);     // Catch: ReflectiveOperationException -> L5
            Class<?> r2 = ZeusTransformUtils.forName("android.view.View$AttachInfo", "com.obric.aiagent.plugin");     // Catch: ReflectiveOperationException -> L5
            g = r2;     // Catch: ReflectiveOperationException -> L5
            h = r2.getDeclaredField("mVisibleInsets");     // Catch: ReflectiveOperationException -> L5
            i = ZeusTransformUtils.forName("android.view.ViewRootImpl", "com.obric.aiagent.plugin").getDeclaredField("mAttachInfo");     // Catch: ReflectiveOperationException -> L5
            h.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
            i.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
        L7:
            f1472e = true;
            return;
        L5:
            e = move-exception;
            b(al.TAG, "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            goto L7
        }

        @Override // androidx.core.view.al.g
        public boolean equals(Object r3) {
            if (super.equals(r3) == true) goto L6;
            return false;
        L6:
            h r4 = (h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin");
            return Objects.equals(this.f1474d, r4.f1474d);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2, Throwable r3) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2, r3);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int b(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class i extends h {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private androidx.core.graphics.g f1475e;

        i(al r1, WindowInsets r2) {
            super(r1, r2);
            this.f1475e = null;
        }

        i(al r1, i r2) {
            super(r1, r2);
            this.f1475e = null;
            this.f1475e = r2.f1475e;
        }

        @Override // androidx.core.view.al.g
        boolean b() {
            return this.f1473c.isConsumed();
        }

        @Override // androidx.core.view.al.g
        al d() {
            return al.a(this.f1473c.consumeStableInsets());
        }

        @Override // androidx.core.view.al.g
        al c() {
            return al.a(this.f1473c.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.al.g
        final androidx.core.graphics.g h() {
            if (this.f1475e != null) goto L6;
            this.f1475e = androidx.core.graphics.g.a(this.f1473c.getStableInsetLeft(), this.f1473c.getStableInsetTop(), this.f1473c.getStableInsetRight(), this.f1473c.getStableInsetBottom());
        L6:
            return this.f1475e;
        }

        @Override // androidx.core.view.al.g
        public void b(androidx.core.graphics.g r1) {
            this.f1475e = r1;
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class j extends i {
        j(al r1, WindowInsets r2) {
            super(r1, r2);
        }

        j(al r1, j r2) {
            super(r1, r2);
        }

        @Override // androidx.core.view.al.g
        androidx.core.view.c e() {
            return androidx.core.view.c.a(this.f1473c.getDisplayCutout());
        }

        @Override // androidx.core.view.al.g
        al f() {
            return al.a(this.f1473c.consumeDisplayCutout());
        }

        @Override // androidx.core.view.al.h, androidx.core.view.al.g
        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
            return false;
        L8:
            j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin");
            if (Objects.equals(this.f1473c, r6.f1473c) == false) goto L14;
            if (Objects.equals(this.f1474d, r6.f1474d) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // androidx.core.view.al.g
        public int hashCode() {
            return this.f1473c.hashCode();
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class k extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private androidx.core.graphics.g f1476e;
        private androidx.core.graphics.g f;
        private androidx.core.graphics.g g;

        @Override // androidx.core.view.al.i, androidx.core.view.al.g
        public void b(androidx.core.graphics.g r1) {
        }

        k(al r1, WindowInsets r2) {
            super(r1, r2);
            this.f1476e = null;
            this.f = null;
            this.g = null;
        }

        k(al r1, k r2) {
            super(r1, r2);
            this.f1476e = null;
            this.f = null;
            this.g = null;
        }

        @Override // androidx.core.view.al.g
        androidx.core.graphics.g i() {
            if (this.f1476e != null) goto L6;
            this.f1476e = androidx.core.graphics.g.a(this.f1473c.getSystemGestureInsets());
        L6:
            return this.f1476e;
        }

        @Override // androidx.core.view.al.g
        androidx.core.graphics.g j() {
            if (this.f != null) goto L6;
            this.f = androidx.core.graphics.g.a(this.f1473c.getMandatorySystemGestureInsets());
        L6:
            return this.f;
        }

        @Override // androidx.core.view.al.g
        androidx.core.graphics.g k() {
            if (this.g != null) goto L6;
            this.g = androidx.core.graphics.g.a(this.f1473c.getTappableElementInsets());
        L6:
            return this.g;
        }

        @Override // androidx.core.view.al.h, androidx.core.view.al.g
        al a(int r1, int r2, int r3, int r4) {
            return al.a(this.f1473c.inset(r1, r2, r3, r4));
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class l extends k {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final al f1477e = null;

        @Override // androidx.core.view.al.h, androidx.core.view.al.g
        final void a(View r1) {
        }

        static {
            f1477e = al.a(WindowInsets.CONSUMED);
        }

        l(al r1, WindowInsets r2) {
            super(r1, r2);
        }

        l(al r1, l r2) {
            super(r1, r2);
        }

        @Override // androidx.core.view.al.h, androidx.core.view.al.g
        public androidx.core.graphics.g a(int r1) {
            return androidx.core.graphics.g.a(this.f1473c.getInsets(n.a(r1)));
        }

        @Override // androidx.core.view.al.h, androidx.core.view.al.g
        public boolean b(int r1) {
            return this.f1473c.isVisible(n.a(r1));
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    public static final class m {
        public static int a() {
            return 1;
        }

        public static int b() {
            return 2;
        }

        public static int c() {
            return 8;
        }

        public static int d() {
            return 32;
        }

        public static int e() {
            return 64;
        }

        public static int f() {
            return 7;
        }

        static int a(int r3) {
            if (r3 != 1) goto L5;
            return 0;
        L5:
            if (r3 != 2) goto L7;
            return 1;
        L7:
            if (r3 != 4) goto L9;
            return 2;
        L9:
            if (r3 != 8) goto L11;
            return 3;
        L11:
            if (r3 != 16) goto L13;
            return 4;
        L13:
            if (r3 != 32) goto L15;
            return 5;
        L15:
            if (r3 != 64) goto L17;
            return 6;
        L17:
            if (r3 != 128) goto L19;
            return 7;
        L19:
            if (r3 != 256) goto L22;
            return 8;
        L22:
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + r3);
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static final class n {
        static int a(int r4) {
            int r1 = 0;
            int r2 = 1;
        L4:
            if (r2 > 256) goto L33;
            if ((r4 & r2) == 0) goto L32;
            if (r2 != 1) goto L9;
            int r3 = WindowInsets.Type.statusBars();
        L31:
            r1 = r1 | r3;
            goto L32
        L9:
            if (r2 != 2) goto L11;
            r3 = WindowInsets.Type.navigationBars();
            goto L31
        L11:
            if (r2 != 4) goto L13;
            r3 = WindowInsets.Type.captionBar();
            goto L31
        L13:
            if (r2 != 8) goto L15;
            r3 = WindowInsets.Type.ime();
            goto L31
        L15:
            if (r2 != 16) goto L17;
            r3 = WindowInsets.Type.systemGestures();
            goto L31
        L17:
            if (r2 != 32) goto L19;
            r3 = WindowInsets.Type.mandatorySystemGestures();
            goto L31
        L19:
            if (r2 != 64) goto L21;
            r3 = WindowInsets.Type.tappableElement();
            goto L31
        L21:
            if (r2 != 128) goto L32;
            r3 = WindowInsets.Type.displayCutout();
        L32:
            r2 = r2 << 1;
            goto L4
        L33:
            return r1;
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        f1456a = l.f1477e;
        return;
    L5:
        f1456a = g.f1470a;
    }

    private al(WindowInsets r3) {
        if (Build.VERSION.SDK_INT < 30) goto L6;
        this.f1457b = new l(this, r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 29) goto L9;
        this.f1457b = new k(this, r3);
        return;
    L9:
        if (Build.VERSION.SDK_INT < 28) goto L12;
        this.f1457b = new j(this, r3);
        return;
    L12:
        if (Build.VERSION.SDK_INT < 21) goto L15;
        this.f1457b = new i(this, r3);
        return;
    L15:
        if (Build.VERSION.SDK_INT < 20) goto L17;
        this.f1457b = new h(this, r3);
        return;
    L17:
        this.f1457b = new g(this);
    }

    public al(al r4) {
        if (r4 == null) goto L31;
        g r5 = r4.f1457b;
        if (Build.VERSION.SDK_INT < 30) goto L10;
        if (ZeusTransformUtils.instanceOf(r5, l.class) == false) goto L10;
        this.f1457b = new l(this, (l) ZeusTransformUtils.preCheckCast(r5, l.class, "com.obric.aiagent.plugin"));
    L30:
        r5.b(this);
        return;
    L10:
        if (Build.VERSION.SDK_INT < 29) goto L15;
        if (ZeusTransformUtils.instanceOf(r5, k.class) == false) goto L15;
        this.f1457b = new k(this, (k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.aiagent.plugin"));
    L15:
        if (Build.VERSION.SDK_INT < 28) goto L20;
        if (ZeusTransformUtils.instanceOf(r5, j.class) == false) goto L20;
        this.f1457b = new j(this, (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin"));
    L20:
        if (Build.VERSION.SDK_INT < 21) goto L25;
        if (ZeusTransformUtils.instanceOf(r5, i.class) == false) goto L25;
        this.f1457b = new i(this, (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin"));
    L25:
        if (Build.VERSION.SDK_INT >= 20) goto L27;
    L29:
        this.f1457b = new g(this);
        goto L30
    L27:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == false) goto L29;
        this.f1457b = new h(this, (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin"));
        goto L30
    L31:
        this.f1457b = new g(this);
    }

    public static al a(WindowInsets r1) {
        return a(r1, null);
    }

    public static al a(WindowInsets r3, View r4) {
        al r0 = new al((WindowInsets) ZeusTransformUtils.preCheckCast(androidx.core.util.g.a(r3), WindowInsets.class, "com.obric.aiagent.plugin"));
        if (r4 != null) goto L5;
    L7:
        return r0;
    L5:
        if (ViewCompat.I(r4) == false) goto L7;
        r0.a(ViewCompat.w(r4));
        r0.a(r4.getRootView());
        goto L7
    }

    @Deprecated
    public int a() {
        return this.f1457b.g().f1210b;
    }

    @Deprecated
    public int b() {
        return this.f1457b.g().f1211c;
    }

    @Deprecated
    public int c() {
        return this.f1457b.g().f1212d;
    }

    @Deprecated
    public int d() {
        return this.f1457b.g().f1213e;
    }

    @Deprecated
    public boolean e() {
        return !this.f1457b.g().equals(androidx.core.graphics.g.f1209a);
    }

    public boolean f() {
        return this.f1457b.b();
    }

    @Deprecated
    public al g() {
        return this.f1457b.c();
    }

    @Deprecated
    public al a(int r2, int r3, int r4, int r5) {
        return new b(this).a(androidx.core.graphics.g.a(r2, r3, r4, r5)).a();
    }

    @Deprecated
    public al h() {
        return this.f1457b.d();
    }

    public androidx.core.view.c i() {
        return this.f1457b.e();
    }

    @Deprecated
    public al j() {
        return this.f1457b.f();
    }

    @Deprecated
    public androidx.core.graphics.g k() {
        return this.f1457b.h();
    }

    @Deprecated
    public androidx.core.graphics.g l() {
        return this.f1457b.i();
    }

    public al b(int r1, int r2, int r3, int r4) {
        return this.f1457b.a(r1, r2, r3, r4);
    }

    public androidx.core.graphics.g a(int r1) {
        return this.f1457b.a(r1);
    }

    public boolean b(int r1) {
        return this.f1457b.b(r1);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, al.class) == true) goto L10;
        return false;
    L10:
        al r4 = (al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.aiagent.plugin");
        return androidx.core.util.d.a(this.f1457b, r4.f1457b);
    }

    public int hashCode() {
        g r0 = this.f1457b;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public WindowInsets m() {
        if (ZeusTransformUtils.instanceOf(this.f1457b, h.class) == true) goto L7;
        return null;
    L7:
        return ((h) ZeusTransformUtils.preCheckCast(this.f1457b, h.class, "com.obric.aiagent.plugin")).f1473c;
    }

    static androidx.core.graphics.g a(androidx.core.graphics.g r5, int r6, int r7, int r8, int r9) {
        int r0 = Math.max(0, r5.f1210b - r6);
        int r2 = Math.max(0, r5.f1211c - r7);
        int r3 = Math.max(0, r5.f1212d - r8);
        int r1 = Math.max(0, r5.f1213e - r9);
        if (r0 != r6) goto L9;
        if (r2 != r7) goto L9;
        if (r3 != r8) goto L9;
        if (r1 != r9) goto L9;
        return r5;
    L9:
        return androidx.core.graphics.g.a(r0, r2, r3, r1);
    }

    void a(androidx.core.graphics.g[] r1) {
        this.f1457b.a(r1);
    }

    void a(androidx.core.graphics.g r1) {
        this.f1457b.b(r1);
    }

    void a(al r1) {
        this.f1457b.a(r1);
    }

    void b(androidx.core.graphics.g r1) {
        this.f1457b.a(r1);
    }

    void a(View r1) {
        this.f1457b.a(r1);
    }
}
