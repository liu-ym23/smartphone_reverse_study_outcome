package com.obric.oui.view;

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
/* JADX INFO: loaded from: classes4.dex */
public class g {
    private static final String TAG = "WindowInsetsCompat";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f36827a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C1004g f36828b;

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Field f36829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static Field f36830b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static Field f36831c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static boolean f36832d;

        static {
            Field r0 = View.class.getDeclaredField("mAttachInfo");     // Catch: ReflectiveOperationException -> L4
            f36829a = r0;     // Catch: ReflectiveOperationException -> L4
            r0.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            Class r1 = ZeusTransformUtils.forName("android.view.View$AttachInfo", "com.obric.aiagent.plugin");     // Catch: ReflectiveOperationException -> L4
            Field r2 = r1.getDeclaredField("mStableInsets");     // Catch: ReflectiveOperationException -> L4
            f36830b = r2;     // Catch: ReflectiveOperationException -> L4
            r2.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            Field r3 = r1.getDeclaredField("mContentInsets");     // Catch: ReflectiveOperationException -> L4
            f36831c = r3;     // Catch: ReflectiveOperationException -> L4
            r3.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            f36832d = true;     // Catch: ReflectiveOperationException -> L4
            return;
        L4:
            e = move-exception;
            a(g.TAG, "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
        }

        public static g a(View r5) {
            if (f36832d == true) goto L5;
        L17:
            return null;
        L5:
            if (r5.isAttachedToWindow() == false) goto L17;
            Object r1 = f36829a.get(r5.getRootView());     // Catch: IllegalAccessException -> L15
            if (r1 == null) goto L17;
            Rect r3 = (Rect) ZeusTransformUtils.preCheckCast(f36830b.get(r1), Rect.class, "com.obric.aiagent.plugin");     // Catch: IllegalAccessException -> L15
            Rect r0 = (Rect) ZeusTransformUtils.preCheckCast(f36831c.get(r1), Rect.class, "com.obric.aiagent.plugin");     // Catch: IllegalAccessException -> L15
            if (r3 == null) goto L17;
            if (r0 == null) goto L17;
            g r2 = new b().b(com.obric.oui.view.b.a(r3)).a(com.obric.oui.view.b.a(r0)).a();     // Catch: IllegalAccessException -> L15
            r2.a(r2);     // Catch: IllegalAccessException -> L15
            r2.a(r5.getRootView());     // Catch: IllegalAccessException -> L15
            return r2;
        L15:
            e = move-exception;
            a(g.TAG, "Failed to get insets from AttachInfo. " + e.getMessage(), e);
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
        private final c f36833a;

        public b() {
            if (Build.VERSION.SDK_INT < 30) goto L6;
            this.f36833a = new f();
            return;
        L6:
            if (Build.VERSION.SDK_INT < 29) goto L9;
            this.f36833a = new e();
            return;
        L9:
            if (Build.VERSION.SDK_INT < 20) goto L11;
            this.f36833a = new d();
            return;
        L11:
            this.f36833a = new c();
        }

        public b(g r3) {
            if (Build.VERSION.SDK_INT < 30) goto L6;
            this.f36833a = new f(r3);
            return;
        L6:
            if (Build.VERSION.SDK_INT < 29) goto L9;
            this.f36833a = new e(r3);
            return;
        L9:
            if (Build.VERSION.SDK_INT < 20) goto L11;
            this.f36833a = new d(r3);
            return;
        L11:
            this.f36833a = new c(r3);
        }

        @Deprecated
        public b a(com.obric.oui.view.b r2) {
            this.f36833a.a(r2);
            return this;
        }

        public b a(int r2, com.obric.oui.view.b r3) {
            this.f36833a.a(r2, r3);
            return this;
        }

        @Deprecated
        public b b(com.obric.oui.view.b r2) {
            this.f36833a.e(r2);
            return this;
        }

        public g a() {
            return this.f36833a.b();
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.obric.oui.view.b[] f36834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g f36835b;

        void a(com.obric.oui.view.b r1) {
        }

        void b(com.obric.oui.view.b r1) {
        }

        void c(com.obric.oui.view.b r1) {
        }

        void d(com.obric.oui.view.b r1) {
        }

        void e(com.obric.oui.view.b r1) {
        }

        c() {
            this(new g((g) ZeusTransformUtils.preCheckCast(null, g.class, "com.obric.aiagent.plugin")));
        }

        c(g r1) {
            this.f36835b = r1;
        }

        void a(int r4, com.obric.oui.view.b r5) {
            if (this.f36834a != null) goto L5;
            this.f36834a = new com.obric.oui.view.b[9];
        L5:
            int r0 = 1;
        L7:
            if (r0 > 256) goto L13;
            if ((r4 & r0) == 0) goto L12;
            this.f36834a[m.a(r0)] = r5;
        L12:
            r0 = r0 << 1;
            goto L7
        }

        public final void a() {
            com.obric.oui.view.b[] r0 = this.f36834a;
            if (r0 == null) goto L22;
            com.obric.oui.view.b r1 = r0[m.a(1)];
            com.obric.oui.view.b r2 = this.f36834a[m.a(2)];
            if (r1 == null) goto L8;
            if (r2 == null) goto L8;
            a(com.obric.oui.view.b.a(r1, r2));
        L12:
            com.obric.oui.view.b r3 = this.f36834a[m.a(16)];
            if (r3 == null) goto L15;
            b(r3);
        L15:
            com.obric.oui.view.b r4 = this.f36834a[m.a(32)];
            if (r4 == null) goto L18;
            c(r4);
        L18:
            com.obric.oui.view.b r5 = this.f36834a[m.a(64)];
            if (r5 == null) goto L23;
            d(r5);
            return;
        L23:
            return;
        L8:
            if (r1 == null) goto L10;
            a(r1);
            goto L12
        L10:
            if (r2 == null) goto L12;
            a(r2);
            goto L12
        }

        g b() {
            a();
            return this.f36835b;
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class d extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static Field f36836b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static boolean f36837c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static Constructor<WindowInsets> f36838d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static boolean f36839e = false;
        private WindowInsets f;
        private com.obric.oui.view.b g;

        static {
        }

        d() {
            this.f = c();
        }

        d(g r1) {
            this.f = r1.g();
        }

        @Override // com.obric.oui.view.g.c
        void a(com.obric.oui.view.b r5) {
            WindowInsets r0 = this.f;
            if (r0 == null) goto L6;
            this.f = r0.replaceSystemWindowInsets(r5.f36821b, r5.f36822c, r5.f36823d, r5.f36824e);
            return;
        }

        @Override // com.obric.oui.view.g.c
        void e(com.obric.oui.view.b r1) {
            this.g = r1;
        }

        @Override // com.obric.oui.view.g.c
        g b() {
            a();
            g r0 = g.a(this.f);
            r0.a(this.f36834a);
            r0.a(this.g);
            return r0;
        }

        private static WindowInsets c() {
            if (f36837c == false) goto L31;
        L9:
            Field r0 = f36836b;
            if (r0 == null) goto L18;
            WindowInsets r1 = (WindowInsets) ZeusTransformUtils.preCheckCast(r0.get(null), WindowInsets.class, "com.obric.aiagent.plugin");     // Catch: ReflectiveOperationException -> L15
            if (r1 == null) goto L18;
            return new WindowInsets(r1);
        L15:
            e = move-exception;
            a(g.TAG, "Could not get value from WindowInsets.CONSUMED field", e);
        L18:
            if (f36839e == false) goto L35;
        L24:
            Constructor<WindowInsets> r2 = f36838d;
            if (r2 != null) goto L33;
        L30:
            return null;
        L33:
            return (WindowInsets) ZeusTransformUtils.preCheckCast(r2.newInstance(new Object[]{new Rect()}), WindowInsets.class, "com.obric.aiagent.plugin");
        L28:
            e = move-exception;
            a(g.TAG, "Could not invoke WindowInsets(Rect) constructor", e);
            goto L30
        L35:
            f36838d = WindowInsets.class.getConstructor(new Class[]{Rect.class});     // Catch: ReflectiveOperationException -> L21
        L23:
            f36839e = true;
        L21:
            e = move-exception;
            a(g.TAG, "Could not retrieve WindowInsets(Rect) constructor", e);
            goto L23
        L31:
            f36836b = WindowInsets.class.getDeclaredField("CONSUMED");     // Catch: ReflectiveOperationException -> L6
        L8:
            f36837c = true;
        L6:
            e = move-exception;
            a(g.TAG, "Could not retrieve WindowInsets.CONSUMED field", e);
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
        final WindowInsets.Builder f36840b;

        e() {
            this.f36840b = new WindowInsets.Builder();
        }

        e(g r2) {
            WindowInsets r3 = r2.g();
            if (r3 == null) goto L5;
            WindowInsets.Builder r0 = new WindowInsets.Builder(r3);
        L6:
            this.f36840b = r0;
            return;
        L5:
            r0 = new WindowInsets.Builder();
            goto L6
        }

        @Override // com.obric.oui.view.g.c
        void a(com.obric.oui.view.b r1) {
            this.f36840b.setSystemWindowInsets(r1.a());
        }

        @Override // com.obric.oui.view.g.c
        void b(com.obric.oui.view.b r1) {
            this.f36840b.setSystemGestureInsets(r1.a());
        }

        @Override // com.obric.oui.view.g.c
        void c(com.obric.oui.view.b r1) {
            this.f36840b.setMandatorySystemGestureInsets(r1.a());
        }

        @Override // com.obric.oui.view.g.c
        void d(com.obric.oui.view.b r1) {
            this.f36840b.setTappableElementInsets(r1.a());
        }

        @Override // com.obric.oui.view.g.c
        void e(com.obric.oui.view.b r1) {
            this.f36840b.setStableInsets(r1.a());
        }

        @Override // com.obric.oui.view.g.c
        g b() {
            a();
            g r0 = g.a(this.f36840b.build());
            r0.a(this.f36834a);
            return r0;
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class f extends e {
        f() {
        }

        f(g r1) {
            super(r1);
        }

        @Override // com.obric.oui.view.g.c
        void a(int r1, com.obric.oui.view.b r2) {
            this.f36840b.setInsets(n.a(r1), r2.a());
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.view.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class C1004g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final g f36841a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final g f36842b;

        void a(View r1) {
        }

        void a(com.obric.oui.view.b r1) {
        }

        void a(g r1) {
        }

        public void a(com.obric.oui.view.b[] r1) {
        }

        boolean a() {
            return false;
        }

        public void b(com.obric.oui.view.b r1) {
        }

        void b(g r1) {
        }

        boolean b() {
            return false;
        }

        com.obric.oui.view.a e() {
            return null;
        }

        static {
            f36841a = new b().a().d().b().a();
        }

        C1004g(g r1) {
            this.f36842b = r1;
        }

        g c() {
            return this.f36842b;
        }

        g d() {
            return this.f36842b;
        }

        g f() {
            return this.f36842b;
        }

        com.obric.oui.view.b g() {
            return com.obric.oui.view.b.f36820a;
        }

        com.obric.oui.view.b h() {
            return com.obric.oui.view.b.f36820a;
        }

        com.obric.oui.view.b i() {
            return g();
        }

        com.obric.oui.view.b j() {
            return g();
        }

        com.obric.oui.view.b k() {
            return g();
        }

        com.obric.oui.view.b a(int r1) {
            return com.obric.oui.view.b.f36820a;
        }

        com.obric.oui.view.b b(int r1) {
            if ((r1 & 8) != 0) goto L7;
            return com.obric.oui.view.b.f36820a;
        L7:
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C1004g.class) == true) goto L8;
            return false;
        L8:
            C1004g r6 = (C1004g) ZeusTransformUtils.preCheckCast(r5, C1004g.class, "com.obric.aiagent.plugin");
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
    private static class h extends C1004g {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static boolean f36843e = false;
        private static Method f;
        private static Class<?> g;
        private static Class<?> h;
        private static Field i;
        private static Field j;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final WindowInsets f36844c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        com.obric.oui.view.b f36845d;
        private com.obric.oui.view.b[] k;
        private com.obric.oui.view.b l;
        private g m;

        static {
        }

        h(g r1, WindowInsets r2) {
            super(r1);
            this.l = null;
            this.f36844c = r2;
        }

        h(g r2, h r3) {
            this(r2, new WindowInsets(r3.f36844c));
        }

        @Override // com.obric.oui.view.g.C1004g
        boolean a() {
            return this.f36844c.isRound();
        }

        @Override // com.obric.oui.view.g.C1004g
        public com.obric.oui.view.b a(int r2) {
            return b(r2, false);
        }

        @Override // com.obric.oui.view.g.C1004g
        public com.obric.oui.view.b b(int r2) {
            return b(r2, true);
        }

        private com.obric.oui.view.b b(int r4, boolean r5) {
            com.obric.oui.view.b r0 = com.obric.oui.view.b.f36820a;
            int r1 = 1;
        L4:
            if (r1 > 256) goto L10;
            if ((r4 & r1) == 0) goto L9;
            r0 = com.obric.oui.view.b.a(r0, a(r1, r5));
        L9:
            r1 = r1 << 1;
            goto L4
        L10:
            return r0;
        }

        public com.obric.oui.view.b a(int r4, boolean r5) {
            if (r4 == 1) goto L63;
            com.obric.oui.view.b r2 = null;
            if (r4 != 2) goto L7;
            if (r5 == false) goto L55;
            com.obric.oui.view.b r6 = l();
            com.obric.oui.view.b r3 = h();
            return com.obric.oui.view.b.a(Math.max(r6.f36821b, r3.f36821b), 0, Math.max(r6.f36823d, r3.f36823d), Math.max(r6.f36824e, r3.f36824e));
        L55:
            com.obric.oui.view.b r7 = g();
            g r8 = this.m;
            if (r8 == null) goto L58;
            r2 = r8.f();
        L58:
            int r9 = r7.f36824e;
            if (r2 == null) goto L62;
            r9 = Math.min(r9, r2.f36824e);
        L62:
            return com.obric.oui.view.b.a(r7.f36821b, 0, r7.f36823d, r9);
        L7:
            if (r4 != 8) goto L9;
            com.obric.oui.view.b[] r10 = this.k;
            if (r10 == null) goto L36;
            r2 = r10[m.a(8)];
        L36:
            if (r2 == null) goto L38;
            return r2;
        L38:
            com.obric.oui.view.b r11 = g();
            com.obric.oui.view.b r12 = l();
            if (r11.f36824e > r12.f36824e) goto L41;
            com.obric.oui.view.b r13 = this.f36845d;
            if (r13 == null) goto L51;
            if (r13.equals(com.obric.oui.view.b.f36820a) == true) goto L51;
            if (this.f36845d.f36824e <= r12.f36824e) goto L51;
            return com.obric.oui.view.b.a(0, 0, 0, this.f36845d.f36824e);
        L51:
            return com.obric.oui.view.b.f36820a;
        L41:
            return com.obric.oui.view.b.a(0, 0, 0, r11.f36824e);
        L9:
            if (r4 == 16) goto L32;
            if (r4 == 32) goto L30;
            if (r4 == 64) goto L28;
            if (r4 != 128) goto L17;
            g r14 = this.m;
            if (r14 == null) goto L21;
            com.obric.oui.view.a r15 = r14.c();
        L22:
            if (r15 == null) goto L26;
            return com.obric.oui.view.b.a(r15.c(), r15.a(), r15.d(), r15.b());
        L26:
            return com.obric.oui.view.b.f36820a;
        L21:
            r15 = e();
            goto L22
        L17:
            return com.obric.oui.view.b.f36820a;
        L28:
            return k();
        L30:
            return j();
        L32:
            return i();
        L63:
            if (r5 == false) goto L67;
            return com.obric.oui.view.b.a(0, Math.max(l().f36822c, g().f36822c), 0, 0);
        L67:
            return com.obric.oui.view.b.a(0, g().f36822c, 0, 0);
        }

        @Override // com.obric.oui.view.g.C1004g
        final com.obric.oui.view.b g() {
            if (this.l != null) goto L6;
            this.l = com.obric.oui.view.b.a(this.f36844c.getSystemWindowInsetLeft(), this.f36844c.getSystemWindowInsetTop(), this.f36844c.getSystemWindowInsetRight(), this.f36844c.getSystemWindowInsetBottom());
        L6:
            return this.l;
        }

        @Override // com.obric.oui.view.g.C1004g
        void b(g r2) {
            r2.a(this.m);
            r2.b(this.f36845d);
        }

        @Override // com.obric.oui.view.g.C1004g
        void a(g r1) {
            this.m = r1;
        }

        @Override // com.obric.oui.view.g.C1004g
        void a(com.obric.oui.view.b r1) {
            this.f36845d = r1;
        }

        private com.obric.oui.view.b l() {
            g r0 = this.m;
            if (r0 == null) goto L7;
            return r0.f();
        L7:
            return com.obric.oui.view.b.f36820a;
        }

        @Override // com.obric.oui.view.g.C1004g
        void a(View r1) {
            com.obric.oui.view.b r2 = b(r1);
            if (r2 != null) goto L5;
            r2 = com.obric.oui.view.b.f36820a;
        L5:
            a(r2);
        }

        private com.obric.oui.view.b b(View r4) {
            if (Build.VERSION.SDK_INT >= 30) goto L27;
            if (f36843e == true) goto L7;
            m();
        L7:
            Method r0 = f;
            if (r0 != null) goto L10;
        L25:
            return null;
        L10:
            if (h == null) goto L25;
            if (i == null) goto L25;
            Object r5 = r0.invoke(r4, new Object[0]);     // Catch: ReflectiveOperationException -> L23
            if (r5 != null) goto L19;
            a(g.TAG, "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());     // Catch: ReflectiveOperationException -> L23
            return null;
        L19:
            Rect r6 = (Rect) ZeusTransformUtils.preCheckCast(i.get(j.get(r5)), Rect.class, "com.obric.aiagent.plugin");     // Catch: ReflectiveOperationException -> L23
            if (r6 != null) goto L22;
            return null;
        L22:
            return com.obric.oui.view.b.a(r6);
        L23:
            e = move-exception;
            b(g.TAG, "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            goto L25
        L27:
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @Override // com.obric.oui.view.g.C1004g
        public void a(com.obric.oui.view.b[] r1) {
            this.k = r1;
        }

        private static void m() {
            f = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);     // Catch: ReflectiveOperationException -> L5
            g = ZeusTransformUtils.forName("android.view.ViewRootImpl", "com.obric.aiagent.plugin");     // Catch: ReflectiveOperationException -> L5
            Class<?> r0 = ZeusTransformUtils.forName("android.view.View$AttachInfo", "com.obric.aiagent.plugin");     // Catch: ReflectiveOperationException -> L5
            h = r0;     // Catch: ReflectiveOperationException -> L5
            i = r0.getDeclaredField("mVisibleInsets");     // Catch: ReflectiveOperationException -> L5
            j = g.getDeclaredField("mAttachInfo");     // Catch: ReflectiveOperationException -> L5
            i.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
            j.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
        L7:
            f36843e = true;
            return;
        L5:
            e = move-exception;
            b(g.TAG, "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            goto L7
        }

        @Override // com.obric.oui.view.g.C1004g
        public boolean equals(Object r3) {
            if (super.equals(r3) == true) goto L6;
            return false;
        L6:
            h r4 = (h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin");
            return Objects.equals(this.f36845d, r4.f36845d);
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
        private com.obric.oui.view.b f36846e;

        i(g r1, WindowInsets r2) {
            super(r1, r2);
            this.f36846e = null;
        }

        i(g r1, i r2) {
            super(r1, r2);
            this.f36846e = null;
            this.f36846e = r2.f36846e;
        }

        @Override // com.obric.oui.view.g.C1004g
        boolean b() {
            return this.f36844c.isConsumed();
        }

        @Override // com.obric.oui.view.g.C1004g
        g d() {
            return g.a(this.f36844c.consumeStableInsets());
        }

        @Override // com.obric.oui.view.g.C1004g
        g c() {
            return g.a(this.f36844c.consumeSystemWindowInsets());
        }

        @Override // com.obric.oui.view.g.C1004g
        final com.obric.oui.view.b h() {
            if (this.f36846e != null) goto L6;
            this.f36846e = com.obric.oui.view.b.a(this.f36844c.getStableInsetLeft(), this.f36844c.getStableInsetTop(), this.f36844c.getStableInsetRight(), this.f36844c.getStableInsetBottom());
        L6:
            return this.f36846e;
        }

        @Override // com.obric.oui.view.g.C1004g
        public void b(com.obric.oui.view.b r1) {
            this.f36846e = r1;
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class j extends i {
        j(g r1, WindowInsets r2) {
            super(r1, r2);
        }

        j(g r1, j r2) {
            super(r1, r2);
        }

        @Override // com.obric.oui.view.g.C1004g
        com.obric.oui.view.a e() {
            return com.obric.oui.view.a.a(this.f36844c.getDisplayCutout());
        }

        @Override // com.obric.oui.view.g.C1004g
        g f() {
            return g.a(this.f36844c.consumeDisplayCutout());
        }

        @Override // com.obric.oui.view.g.h, com.obric.oui.view.g.C1004g
        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
            return false;
        L8:
            j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin");
            if (Objects.equals(this.f36844c, r6.f36844c) == false) goto L14;
            if (Objects.equals(this.f36845d, r6.f36845d) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // com.obric.oui.view.g.C1004g
        public int hashCode() {
            return this.f36844c.hashCode();
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class k extends j {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private com.obric.oui.view.b f36847e;
        private com.obric.oui.view.b f;
        private com.obric.oui.view.b g;

        @Override // com.obric.oui.view.g.i, com.obric.oui.view.g.C1004g
        public void b(com.obric.oui.view.b r1) {
        }

        k(g r1, WindowInsets r2) {
            super(r1, r2);
            this.f36847e = null;
            this.f = null;
            this.g = null;
        }

        k(g r1, k r2) {
            super(r1, r2);
            this.f36847e = null;
            this.f = null;
            this.g = null;
        }

        @Override // com.obric.oui.view.g.C1004g
        com.obric.oui.view.b i() {
            if (this.f36847e != null) goto L6;
            this.f36847e = com.obric.oui.view.b.a(this.f36844c.getSystemGestureInsets());
        L6:
            return this.f36847e;
        }

        @Override // com.obric.oui.view.g.C1004g
        com.obric.oui.view.b j() {
            if (this.f != null) goto L6;
            this.f = com.obric.oui.view.b.a(this.f36844c.getMandatorySystemGestureInsets());
        L6:
            return this.f;
        }

        @Override // com.obric.oui.view.g.C1004g
        com.obric.oui.view.b k() {
            if (this.g != null) goto L6;
            this.g = com.obric.oui.view.b.a(this.f36844c.getTappableElementInsets());
        L6:
            return this.g;
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    private static class l extends k {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final g f36848e = null;

        @Override // com.obric.oui.view.g.h, com.obric.oui.view.g.C1004g
        final void a(View r1) {
        }

        static {
            f36848e = g.a(WindowInsets.CONSUMED);
        }

        l(g r1, WindowInsets r2) {
            super(r1, r2);
        }

        l(g r1, l r2) {
            super(r1, r2);
        }

        @Override // com.obric.oui.view.g.h, com.obric.oui.view.g.C1004g
        public com.obric.oui.view.b a(int r1) {
            return com.obric.oui.view.b.a(this.f36844c.getInsets(n.a(r1)));
        }

        @Override // com.obric.oui.view.g.h, com.obric.oui.view.g.C1004g
        public com.obric.oui.view.b b(int r1) {
            return com.obric.oui.view.b.a(this.f36844c.getInsetsIgnoringVisibility(n.a(r1)));
        }
    }

    /* JADX INFO: compiled from: WindowInsetsCompat.java */
    public static final class m {
        public static int a() {
            return 8;
        }

        public static int b() {
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
        f36827a = l.f36848e;
        return;
    L5:
        f36827a = C1004g.f36841a;
    }

    private g(WindowInsets r3) {
        if (Build.VERSION.SDK_INT < 30) goto L6;
        this.f36828b = new l(this, r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 29) goto L9;
        this.f36828b = new k(this, r3);
        return;
    L9:
        if (Build.VERSION.SDK_INT < 28) goto L12;
        this.f36828b = new j(this, r3);
        return;
    L12:
        if (Build.VERSION.SDK_INT < 21) goto L15;
        this.f36828b = new i(this, r3);
        return;
    L15:
        if (Build.VERSION.SDK_INT < 20) goto L17;
        this.f36828b = new h(this, r3);
        return;
    L17:
        this.f36828b = new C1004g(this);
    }

    public g(g r4) {
        if (r4 == null) goto L31;
        C1004g r5 = r4.f36828b;
        if (Build.VERSION.SDK_INT < 30) goto L10;
        if (ZeusTransformUtils.instanceOf(r5, l.class) == false) goto L10;
        this.f36828b = new l(this, (l) ZeusTransformUtils.preCheckCast(r5, l.class, "com.obric.aiagent.plugin"));
    L30:
        r5.b(this);
        return;
    L10:
        if (Build.VERSION.SDK_INT < 29) goto L15;
        if (ZeusTransformUtils.instanceOf(r5, k.class) == false) goto L15;
        this.f36828b = new k(this, (k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.aiagent.plugin"));
    L15:
        if (Build.VERSION.SDK_INT < 28) goto L20;
        if (ZeusTransformUtils.instanceOf(r5, j.class) == false) goto L20;
        this.f36828b = new j(this, (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin"));
    L20:
        if (Build.VERSION.SDK_INT < 21) goto L25;
        if (ZeusTransformUtils.instanceOf(r5, i.class) == false) goto L25;
        this.f36828b = new i(this, (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin"));
    L25:
        if (Build.VERSION.SDK_INT >= 20) goto L27;
    L29:
        this.f36828b = new C1004g(this);
        goto L30
    L27:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == false) goto L29;
        this.f36828b = new h(this, (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin"));
        goto L30
    L31:
        this.f36828b = new C1004g(this);
    }

    public static g a(WindowInsets r1) {
        return a(r1, null);
    }

    public static g a(WindowInsets r3, View r4) {
        g r0 = new g((WindowInsets) ZeusTransformUtils.preCheckCast(androidx.core.util.g.a(r3), WindowInsets.class, "com.obric.aiagent.plugin"));
        if (r4 != null) goto L5;
    L7:
        return r0;
    L5:
        if (r4.isAttachedToWindow() == false) goto L7;
        r0.a(ViewCompat.d(r4));
        r0.a(r4.getRootView());
        goto L7
    }

    @Deprecated
    public g a() {
        return this.f36828b.c();
    }

    @Deprecated
    public g b() {
        return this.f36828b.d();
    }

    public com.obric.oui.view.a c() {
        return this.f36828b.e();
    }

    @Deprecated
    public g d() {
        return this.f36828b.f();
    }

    @Deprecated
    public com.obric.oui.view.b e() {
        return this.f36828b.g();
    }

    @Deprecated
    public com.obric.oui.view.b f() {
        return this.f36828b.h();
    }

    public com.obric.oui.view.b a(int r1) {
        return this.f36828b.a(r1);
    }

    public com.obric.oui.view.b b(int r1) {
        return this.f36828b.b(r1);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, g.class) == true) goto L10;
        return false;
    L10:
        g r4 = (g) ZeusTransformUtils.preCheckCast(r3, g.class, "com.obric.aiagent.plugin");
        return androidx.core.util.d.a(this.f36828b, r4.f36828b);
    }

    public int hashCode() {
        C1004g r0 = this.f36828b;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public WindowInsets g() {
        if (ZeusTransformUtils.instanceOf(this.f36828b, h.class) == true) goto L7;
        return null;
    L7:
        return ((h) ZeusTransformUtils.preCheckCast(this.f36828b, h.class, "com.obric.aiagent.plugin")).f36844c;
    }

    static com.obric.oui.view.b a(com.obric.oui.view.b r5, int r6, int r7, int r8, int r9) {
        int r0 = Math.max(0, r5.f36821b - r6);
        int r2 = Math.max(0, r5.f36822c - r7);
        int r3 = Math.max(0, r5.f36823d - r8);
        int r1 = Math.max(0, r5.f36824e - r9);
        if (r0 != r6) goto L9;
        if (r2 != r7) goto L9;
        if (r3 != r8) goto L9;
        if (r1 != r9) goto L9;
        return r5;
    L9:
        return com.obric.oui.view.b.a(r0, r2, r3, r1);
    }

    void a(com.obric.oui.view.b[] r1) {
        this.f36828b.a(r1);
    }

    void a(com.obric.oui.view.b r1) {
        this.f36828b.b(r1);
    }

    void a(g r1) {
        this.f36828b.a(r1);
    }

    void b(com.obric.oui.view.b r1) {
        this.f36828b.a(r1);
    }

    void a(View r1) {
        this.f36828b.a(r1);
    }
}
