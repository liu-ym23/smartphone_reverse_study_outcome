package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class WindowInsetsCompat {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WindowInsetsCompat f2706b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f2707a;

    public static final class Type {

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface InsetsType {
        }

        public static int a() {
            return 8;
        }

        public static int b(int r10) {
            if (r10 != 1) goto L5;
            return 0;
        L5:
            if (r10 != 2) goto L7;
            return 1;
        L7:
            if (r10 != 4) goto L9;
            return 2;
        L9:
            if (r10 != 8) goto L11;
            return 3;
        L11:
            if (r10 != 16) goto L13;
            return 4;
        L13:
            if (r10 != 32) goto L15;
            return 5;
        L15:
            if (r10 != 64) goto L17;
            return 6;
        L17:
            if (r10 != 128) goto L19;
            return 7;
        L19:
            if (r10 != 256) goto L22;
            return 8;
        L22:
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + r10);
        }

        public static int c() {
            return 1;
        }

        public static int d() {
            return 7;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static Field f2708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static Field f2709b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static Field f2710c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static boolean f2711d;

        static {
            Field r10 = View.class.getDeclaredField("mAttachInfo");     // Catch: ReflectiveOperationException -> L4
            f2708a = r10;     // Catch: ReflectiveOperationException -> L4
            r10.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            Class<?> r11 = Class.forName("android.view.View$AttachInfo");     // Catch: ReflectiveOperationException -> L4
            Field r12 = r11.getDeclaredField("mStableInsets");     // Catch: ReflectiveOperationException -> L4
            f2709b = r12;     // Catch: ReflectiveOperationException -> L4
            r12.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            Field r13 = r11.getDeclaredField("mContentInsets");     // Catch: ReflectiveOperationException -> L4
            f2710c = r13;     // Catch: ReflectiveOperationException -> L4
            r13.setAccessible(true);     // Catch: ReflectiveOperationException -> L4
            f2711d = true;     // Catch: ReflectiveOperationException -> L4
            return;
        L4:
            e = move-exception;
            Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
        }

        public static WindowInsetsCompat a(View r10) {
            if (f2711d == true) goto L5;
        L17:
            return null;
        L5:
            if (r10.isAttachedToWindow() == false) goto L17;
            Object r11 = f2708a.get(r10.getRootView());     // Catch: IllegalAccessException -> L15
            if (r11 == null) goto L17;
            Rect r12 = (Rect) f2709b.get(r11);     // Catch: IllegalAccessException -> L15
            Rect r13 = (Rect) f2710c.get(r11);     // Catch: IllegalAccessException -> L15
            if (r12 == null) goto L17;
            if (r13 == null) goto L17;
            WindowInsetsCompat r14 = new b().b(androidx.core.graphics.e.c(r12)).c(androidx.core.graphics.e.c(r13)).a();     // Catch: IllegalAccessException -> L15
            r14.w(r14);     // Catch: IllegalAccessException -> L15
            r14.d(r10.getRootView());     // Catch: IllegalAccessException -> L15
            return r14;
        L15:
            e = move-exception;
            Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e.getMessage(), e);
            goto L17
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f2712a;

        public b() {
            this.f2712a = new d();
        }

        public WindowInsetsCompat a() {
            return this.f2712a.b();
        }

        public b b(androidx.core.graphics.e r10) {
            this.f2712a.d(r10);
            return this;
        }

        public b c(androidx.core.graphics.e r10) {
            this.f2712a.f(r10);
            return this;
        }

        public b(WindowInsetsCompat r10) {
            this.f2712a = new d(r10);
        }
    }

    public static class c extends e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WindowInsets.Builder f2713c;

        public c() {
            this.f2713c = new WindowInsets.Builder();
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        @NonNull
        public WindowInsetsCompat b() {
            a();
            WindowInsetsCompat r10 = WindowInsetsCompat.y(this.f2713c.build());
            r10.u(this.f2715b);
            return r10;
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        public void c(@NonNull androidx.core.graphics.e r10) {
            this.f2713c.setMandatorySystemGestureInsets(r10.e());
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        public void d(@NonNull androidx.core.graphics.e r10) {
            this.f2713c.setStableInsets(r10.e());
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        public void e(@NonNull androidx.core.graphics.e r10) {
            this.f2713c.setSystemGestureInsets(r10.e());
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        public void f(@NonNull androidx.core.graphics.e r10) {
            this.f2713c.setSystemWindowInsets(r10.e());
        }

        @Override // androidx.core.view.WindowInsetsCompat.e
        public void g(@NonNull androidx.core.graphics.e r10) {
            this.f2713c.setTappableElementInsets(r10.e());
        }

        public c(@NonNull WindowInsetsCompat r10) {
            super(r10);
            WindowInsets r11 = r10.x();
            if (r11 == null) goto L5;
            WindowInsets.Builder r12 = new WindowInsets.Builder(r11);
        L6:
            this.f2713c = r12;
            return;
        L5:
            r12 = new WindowInsets.Builder();
            goto L6
        }
    }

    public static class d extends c {
        public d() {
        }

        public d(@NonNull WindowInsetsCompat r10) {
            super(r10);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WindowInsetsCompat f2714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public androidx.core.graphics.e[] f2715b;

        public e() {
            this(new WindowInsetsCompat(null));
        }

        public final void a() {
            androidx.core.graphics.e[] r10 = this.f2715b;
            if (r10 == null) goto L19;
            androidx.core.graphics.e r11 = r10[Type.b(1)];
            androidx.core.graphics.e r12 = this.f2715b[Type.b(2)];
            if (r12 != null) goto L7;
            r12 = this.f2714a.f(2);
        L7:
            if (r11 != null) goto L9;
            r11 = this.f2714a.f(1);
        L9:
            f(androidx.core.graphics.e.a(r11, r12));
            androidx.core.graphics.e r13 = this.f2715b[Type.b(16)];
            if (r13 == null) goto L12;
            e(r13);
        L12:
            androidx.core.graphics.e r14 = this.f2715b[Type.b(32)];
            if (r14 == null) goto L15;
            c(r14);
        L15:
            androidx.core.graphics.e r15 = this.f2715b[Type.b(64)];
            if (r15 == null) goto L20;
            g(r15);
            return;
        L20:
            return;
        }

        @NonNull
        public abstract WindowInsetsCompat b();

        public abstract void c(@NonNull androidx.core.graphics.e r10);

        public abstract void d(@NonNull androidx.core.graphics.e r10);

        public abstract void e(@NonNull androidx.core.graphics.e r10);

        public abstract void f(@NonNull androidx.core.graphics.e r10);

        public abstract void g(@NonNull androidx.core.graphics.e r10);

        public e(@NonNull WindowInsetsCompat r10) {
            this.f2714a = r10;
        }
    }

    public static class f extends k {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WindowInsets f2716c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public androidx.core.graphics.e[] f2717d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public androidx.core.graphics.e f2718e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public WindowInsetsCompat f2719f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public androidx.core.graphics.e f2720g;

        static {
        }

        public f(@NonNull WindowInsetsCompat r10, @NonNull WindowInsets r11) {
            super(r10);
            this.f2718e = null;
            this.f2716c = r11;
        }

        @NonNull
        @SuppressLint({"WrongConstant"})
        private androidx.core.graphics.e t(int r10, boolean r11) {
            androidx.core.graphics.e r12 = androidx.core.graphics.e.f2555e;
            int r13 = 1;
        L4:
            if (r13 > 256) goto L10;
            if ((r10 & r13) == 0) goto L9;
            r12 = androidx.core.graphics.e.a(r12, u(r13, r11));
        L9:
            r13 = r13 << 1;
            goto L4
        L10:
            return r12;
        }

        private androidx.core.graphics.e v() {
            WindowInsetsCompat r10 = this.f2719f;
            if (r10 == null) goto L7;
            return r10.h();
        L7:
            return androidx.core.graphics.e.f2555e;
        }

        @Nullable
        private androidx.core.graphics.e w(@NonNull View r10) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        public void d(@NonNull View r10) {
            androidx.core.graphics.e r11 = w(r10);
            if (r11 != null) goto L5;
            r11 = androidx.core.graphics.e.f2555e;
        L5:
            r(r11);
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        public void e(@NonNull WindowInsetsCompat r10) {
            r10.w(this.f2719f);
            r10.v(this.f2720g);
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        public boolean equals(Object r10) {
            if (super.equals(r10) == true) goto L7;
            return false;
        L7:
            return Objects.equals(this.f2720g, ((f) r10).f2720g);
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public androidx.core.graphics.e g(int r10) {
            return t(r10, false);
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public final androidx.core.graphics.e k() {
            if (this.f2718e != null) goto L6;
            this.f2718e = androidx.core.graphics.e.b(this.f2716c.getSystemWindowInsetLeft(), this.f2716c.getSystemWindowInsetTop(), this.f2716c.getSystemWindowInsetRight(), this.f2716c.getSystemWindowInsetBottom());
        L6:
            return this.f2718e;
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public WindowInsetsCompat m(int r10, int r11, int r12, int r13) {
            b r14 = new b(WindowInsetsCompat.y(this.f2716c));
            r14.c(WindowInsetsCompat.q(k(), r10, r11, r12, r13));
            r14.b(WindowInsetsCompat.q(i(), r10, r11, r12, r13));
            return r14.a();
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        public boolean o() {
            return this.f2716c.isRound();
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        @SuppressLint({"WrongConstant"})
        public boolean p(int r10) {
            int r11 = 1;
        L4:
            if (r11 > 256) goto L13;
            if ((r10 & r11) == 0) goto L12;
            if (x(r11) == true) goto L12;
            return false;
        L12:
            r11 = r11 << 1;
            goto L4
        L13:
            return true;
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        public void q(androidx.core.graphics.e[] r10) {
            this.f2717d = r10;
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        public void r(@NonNull androidx.core.graphics.e r10) {
            this.f2720g = r10;
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        public void s(@Nullable WindowInsetsCompat r10) {
            this.f2719f = r10;
        }

        @NonNull
        public androidx.core.graphics.e u(int r10, boolean r11) {
            if (r10 == 1) goto L63;
            androidx.core.graphics.e r12 = null;
            if (r10 != 2) goto L7;
            if (r11 == false) goto L55;
            androidx.core.graphics.e r13 = v();
            androidx.core.graphics.e r14 = i();
            return androidx.core.graphics.e.b(Math.max(r13.f2556a, r14.f2556a), 0, Math.max(r13.f2558c, r14.f2558c), Math.max(r13.f2559d, r14.f2559d));
        L55:
            androidx.core.graphics.e r15 = k();
            WindowInsetsCompat r16 = this.f2719f;
            if (r16 == null) goto L58;
            r12 = r16.h();
        L58:
            int r17 = r15.f2559d;
            if (r12 == null) goto L62;
            r17 = Math.min(r17, r12.f2559d);
        L62:
            return androidx.core.graphics.e.b(r15.f2556a, 0, r15.f2558c, r17);
        L7:
            if (r10 != 8) goto L9;
            androidx.core.graphics.e[] r18 = this.f2717d;
            if (r18 == null) goto L36;
            r12 = r18[Type.b(8)];
        L36:
            if (r12 == null) goto L38;
            return r12;
        L38:
            androidx.core.graphics.e r19 = k();
            androidx.core.graphics.e r20 = v();
            int r21 = r19.f2559d;
            if (r21 > r20.f2559d) goto L41;
            androidx.core.graphics.e r22 = this.f2720g;
            if (r22 == null) goto L51;
            if (r22.equals(androidx.core.graphics.e.f2555e) == true) goto L51;
            int r23 = this.f2720g.f2559d;
            if (r23 <= r20.f2559d) goto L51;
            return androidx.core.graphics.e.b(0, 0, 0, r23);
        L51:
            return androidx.core.graphics.e.f2555e;
        L41:
            return androidx.core.graphics.e.b(0, 0, 0, r21);
        L9:
            if (r10 == 16) goto L32;
            if (r10 == 32) goto L30;
            if (r10 == 64) goto L28;
            if (r10 != 128) goto L17;
            WindowInsetsCompat r24 = this.f2719f;
            if (r24 == null) goto L21;
            androidx.core.view.b r25 = r24.e();
        L22:
            if (r25 == null) goto L26;
            return androidx.core.graphics.e.b(r25.b(), r25.d(), r25.c(), r25.a());
        L26:
            return androidx.core.graphics.e.f2555e;
        L21:
            r25 = f();
            goto L22
        L17:
            return androidx.core.graphics.e.f2555e;
        L28:
            return l();
        L30:
            return h();
        L32:
            return j();
        L63:
            if (r11 == false) goto L67;
            return androidx.core.graphics.e.b(0, Math.max(v().f2557b, k().f2557b), 0, 0);
        L67:
            return androidx.core.graphics.e.b(0, k().f2557b, 0, 0);
        }

        public boolean x(int r10) {
            if (r10 == 1) goto L15;
            if (r10 == 2) goto L15;
            if (r10 != 4) goto L9;
            return false;
        L9:
            if (r10 == 8) goto L15;
            if (r10 == 128) goto L15;
            return true;
        L15:
            return !u(r10, false).equals(androidx.core.graphics.e.f2555e);
        }

        public f(@NonNull WindowInsetsCompat r10, @NonNull f r11) {
            this(r10, new WindowInsets(r11.f2716c));
        }
    }

    public static class g extends f {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public androidx.core.graphics.e f2721h;

        public g(@NonNull WindowInsetsCompat r10, @NonNull WindowInsets r11) {
            super(r10, r11);
            this.f2721h = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public WindowInsetsCompat b() {
            return WindowInsetsCompat.y(this.f2716c.consumeStableInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public WindowInsetsCompat c() {
            return WindowInsetsCompat.y(this.f2716c.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public final androidx.core.graphics.e i() {
            if (this.f2721h != null) goto L6;
            this.f2721h = androidx.core.graphics.e.b(this.f2716c.getStableInsetLeft(), this.f2716c.getStableInsetTop(), this.f2716c.getStableInsetRight(), this.f2716c.getStableInsetBottom());
        L6:
            return this.f2721h;
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        public boolean n() {
            return this.f2716c.isConsumed();
        }

        public g(@NonNull WindowInsetsCompat r10, @NonNull g r11) {
            super(r10, r11);
            this.f2721h = null;
            this.f2721h = r11.f2721h;
        }
    }

    public static class h extends g {
        public h(@NonNull WindowInsetsCompat r10, @NonNull WindowInsets r11) {
            super(r10, r11);
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public WindowInsetsCompat a() {
            return WindowInsetsCompat.y(this.f2716c.consumeDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.f, androidx.core.view.WindowInsetsCompat.k
        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof h) == true) goto L8;
            return false;
        L8:
            h r11 = (h) r10;
            if (Objects.equals(this.f2716c, r11.f2716c) == false) goto L14;
            if (Objects.equals(this.f2720g, r11.f2720g) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        @Nullable
        public androidx.core.view.b f() {
            return androidx.core.view.b.e(this.f2716c.getDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        public int hashCode() {
            return this.f2716c.hashCode();
        }

        public h(@NonNull WindowInsetsCompat r10, @NonNull h r11) {
            super(r10, r11);
        }
    }

    public static class i extends h {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public androidx.core.graphics.e f2722i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public androidx.core.graphics.e f2723j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public androidx.core.graphics.e f2724k;

        public i(@NonNull WindowInsetsCompat r10, @NonNull WindowInsets r11) {
            super(r10, r11);
            this.f2722i = null;
            this.f2723j = null;
            this.f2724k = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public androidx.core.graphics.e h() {
            if (this.f2723j != null) goto L6;
            this.f2723j = androidx.core.graphics.e.d(this.f2716c.getMandatorySystemGestureInsets());
        L6:
            return this.f2723j;
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public androidx.core.graphics.e j() {
            if (this.f2722i != null) goto L6;
            this.f2722i = androidx.core.graphics.e.d(this.f2716c.getSystemGestureInsets());
        L6:
            return this.f2722i;
        }

        @Override // androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public androidx.core.graphics.e l() {
            if (this.f2724k != null) goto L6;
            this.f2724k = androidx.core.graphics.e.d(this.f2716c.getTappableElementInsets());
        L6:
            return this.f2724k;
        }

        @Override // androidx.core.view.WindowInsetsCompat.f, androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public WindowInsetsCompat m(int r10, int r11, int r12, int r13) {
            return WindowInsetsCompat.y(this.f2716c.inset(r10, r11, r12, r13));
        }

        public i(@NonNull WindowInsetsCompat r10, @NonNull i r11) {
            super(r10, r11);
            this.f2722i = null;
            this.f2723j = null;
            this.f2724k = null;
        }
    }

    public static class j extends i {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final WindowInsetsCompat f2725l = null;

        static {
            f2725l = WindowInsetsCompat.y(WindowInsets.CONSUMED);
        }

        public j(@NonNull WindowInsetsCompat r10, @NonNull WindowInsets r11) {
            super(r10, r11);
        }

        @Override // androidx.core.view.WindowInsetsCompat.f, androidx.core.view.WindowInsetsCompat.k
        public final void d(@NonNull View r10) {
        }

        @Override // androidx.core.view.WindowInsetsCompat.f, androidx.core.view.WindowInsetsCompat.k
        @NonNull
        public androidx.core.graphics.e g(int r10) {
            return androidx.core.graphics.e.d(this.f2716c.getInsets(l.a(r10)));
        }

        @Override // androidx.core.view.WindowInsetsCompat.f, androidx.core.view.WindowInsetsCompat.k
        public boolean p(int r10) {
            return this.f2716c.isVisible(l.a(r10));
        }

        public j(@NonNull WindowInsetsCompat r10, @NonNull j r11) {
            super(r10, r11);
        }
    }

    public static class k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final WindowInsetsCompat f2726b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WindowInsetsCompat f2727a;

        static {
            f2726b = new b().a().a().b().c();
        }

        public k(@NonNull WindowInsetsCompat r10) {
            this.f2727a = r10;
        }

        @NonNull
        public WindowInsetsCompat a() {
            return this.f2727a;
        }

        @NonNull
        public WindowInsetsCompat b() {
            return this.f2727a;
        }

        @NonNull
        public WindowInsetsCompat c() {
            return this.f2727a;
        }

        public void d(@NonNull View r10) {
        }

        public void e(@NonNull WindowInsetsCompat r10) {
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof k) == true) goto L8;
            return false;
        L8:
            k r11 = (k) r10;
            if (o() != r11.o()) goto L20;
            if (n() != r11.n()) goto L20;
            if (androidx.core.util.b.a(k(), r11.k()) == false) goto L20;
            if (androidx.core.util.b.a(i(), r11.i()) == false) goto L20;
            if (androidx.core.util.b.a(f(), r11.f()) == false) goto L20;
            return true;
        L20:
            return false;
        }

        @Nullable
        public androidx.core.view.b f() {
            return null;
        }

        @NonNull
        public androidx.core.graphics.e g(int r10) {
            return androidx.core.graphics.e.f2555e;
        }

        @NonNull
        public androidx.core.graphics.e h() {
            return k();
        }

        public int hashCode() {
            return androidx.core.util.b.b(new Object[]{Boolean.valueOf(o()), Boolean.valueOf(n()), k(), i(), f()});
        }

        @NonNull
        public androidx.core.graphics.e i() {
            return androidx.core.graphics.e.f2555e;
        }

        @NonNull
        public androidx.core.graphics.e j() {
            return k();
        }

        @NonNull
        public androidx.core.graphics.e k() {
            return androidx.core.graphics.e.f2555e;
        }

        @NonNull
        public androidx.core.graphics.e l() {
            return k();
        }

        @NonNull
        public WindowInsetsCompat m(int r10, int r11, int r12, int r13) {
            return f2726b;
        }

        public boolean n() {
            return false;
        }

        public boolean o() {
            return false;
        }

        public boolean p(int r10) {
            return true;
        }

        public void q(androidx.core.graphics.e[] r10) {
        }

        public void r(@NonNull androidx.core.graphics.e r10) {
        }

        public void s(@Nullable WindowInsetsCompat r10) {
        }
    }

    public static final class l {
        public static int a(int r10) {
            int r11 = 0;
            int r12 = 1;
        L4:
            if (r12 > 256) goto L33;
            if ((r10 & r12) == 0) goto L32;
            if (r12 != 1) goto L9;
            int r13 = WindowInsets.Type.statusBars();
        L24:
            r11 = r11 | r13;
            goto L32
        L9:
            if (r12 != 2) goto L11;
            r13 = WindowInsets.Type.navigationBars();
            goto L24
        L11:
            if (r12 != 4) goto L13;
            r13 = WindowInsets.Type.captionBar();
            goto L24
        L13:
            if (r12 != 8) goto L15;
            r13 = WindowInsets.Type.ime();
            goto L24
        L15:
            if (r12 != 16) goto L17;
            r13 = WindowInsets.Type.systemGestures();
            goto L24
        L17:
            if (r12 != 32) goto L19;
            r13 = WindowInsets.Type.mandatorySystemGestures();
            goto L24
        L19:
            if (r12 != 64) goto L21;
            r13 = WindowInsets.Type.tappableElement();
            goto L24
        L21:
            if (r12 != 128) goto L32;
            r13 = WindowInsets.Type.displayCutout();
        L32:
            r12 = r12 << 1;
            goto L4
        L33:
            return r11;
        }
    }

    static {
        f2706b = j.f2725l;
    }

    public WindowInsetsCompat(WindowInsets r10) {
        this.f2707a = new j(this, r10);
    }

    public static androidx.core.graphics.e q(androidx.core.graphics.e r10, int r11, int r12, int r13, int r14) {
        int r15 = Math.max(0, r10.f2556a - r11);
        int r16 = Math.max(0, r10.f2557b - r12);
        int r17 = Math.max(0, r10.f2558c - r13);
        int r18 = Math.max(0, r10.f2559d - r14);
        if (r15 != r11) goto L9;
        if (r16 != r12) goto L9;
        if (r17 != r13) goto L9;
        if (r18 != r14) goto L9;
        return r10;
    L9:
        return androidx.core.graphics.e.b(r15, r16, r17, r18);
    }

    public static WindowInsetsCompat y(WindowInsets r10) {
        return z(r10, null);
    }

    public static WindowInsetsCompat z(WindowInsets r10, View r11) {
        WindowInsetsCompat r12 = new WindowInsetsCompat((WindowInsets) androidx.core.util.e.g(r10));
        if (r11 != null) goto L5;
    L7:
        return r12;
    L5:
        if (ViewCompat.S(r11) == false) goto L7;
        r12.w(ViewCompat.H(r11));
        r12.d(r11.getRootView());
        goto L7
    }

    public WindowInsetsCompat a() {
        return this.f2707a.a();
    }

    public WindowInsetsCompat b() {
        return this.f2707a.b();
    }

    public WindowInsetsCompat c() {
        return this.f2707a.c();
    }

    public void d(View r10) {
        this.f2707a.d(r10);
    }

    public androidx.core.view.b e() {
        return this.f2707a.f();
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof WindowInsetsCompat) == true) goto L10;
        return false;
    L10:
        return androidx.core.util.b.a(this.f2707a, ((WindowInsetsCompat) r10).f2707a);
    }

    public androidx.core.graphics.e f(int r10) {
        return this.f2707a.g(r10);
    }

    public androidx.core.graphics.e g() {
        return this.f2707a.h();
    }

    public androidx.core.graphics.e h() {
        return this.f2707a.i();
    }

    public int hashCode() {
        k r10 = this.f2707a;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.hashCode();
    }

    public androidx.core.graphics.e i() {
        return this.f2707a.j();
    }

    public int j() {
        return this.f2707a.k().f2559d;
    }

    public int k() {
        return this.f2707a.k().f2556a;
    }

    public int l() {
        return this.f2707a.k().f2558c;
    }

    public int m() {
        return this.f2707a.k().f2557b;
    }

    public androidx.core.graphics.e n() {
        return this.f2707a.k();
    }

    public boolean o() {
        return !this.f2707a.k().equals(androidx.core.graphics.e.f2555e);
    }

    public WindowInsetsCompat p(int r10, int r11, int r12, int r13) {
        return this.f2707a.m(r10, r11, r12, r13);
    }

    public boolean r() {
        return this.f2707a.n();
    }

    public boolean s(int r10) {
        return this.f2707a.p(r10);
    }

    public WindowInsetsCompat t(int r10, int r11, int r12, int r13) {
        return new b(this).c(androidx.core.graphics.e.b(r10, r11, r12, r13)).a();
    }

    public void u(androidx.core.graphics.e[] r10) {
        this.f2707a.q(r10);
    }

    public void v(androidx.core.graphics.e r10) {
        this.f2707a.r(r10);
    }

    public void w(WindowInsetsCompat r10) {
        this.f2707a.s(r10);
    }

    public WindowInsets x() {
        k r10 = this.f2707a;
        if ((r10 instanceof f) == true) goto L7;
        return null;
    L7:
        return ((f) r10).f2716c;
    }

    public WindowInsetsCompat(WindowInsetsCompat r10) {
        if (r10 == null) goto L21;
        k r11 = r10.f2707a;
        if ((r11 instanceof j) == false) goto L8;
        this.f2707a = new j(this, (j) r11);
    L20:
        r11.e(this);
        return;
    L8:
        if ((r11 instanceof i) == false) goto L11;
        this.f2707a = new i(this, (i) r11);
        goto L20
    L11:
        if ((r11 instanceof h) == false) goto L14;
        this.f2707a = new h(this, (h) r11);
        goto L20
    L14:
        if ((r11 instanceof g) == false) goto L17;
        this.f2707a = new g(this, (g) r11);
        goto L20
    L17:
        if ((r11 instanceof f) == false) goto L19;
        this.f2707a = new f(this, (f) r11);
        goto L20
    L19:
        this.f2707a = new k(this);
        goto L20
    L21:
        this.f2707a = new k(this);
    }
}
