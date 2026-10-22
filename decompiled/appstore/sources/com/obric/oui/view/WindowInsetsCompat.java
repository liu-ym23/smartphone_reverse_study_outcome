package com.obric.oui.view;

import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class WindowInsetsCompat {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WindowInsetsCompat f17628b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f17629a;

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
            return 7;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f17630a;

        public a() {
            this.f17630a = new c();
        }

        public WindowInsetsCompat a() {
            return this.f17630a.b();
        }
    }

    public static class b extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WindowInsets.Builder f17631c;

        public b() {
            this.f17631c = new WindowInsets.Builder();
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.d
        public WindowInsetsCompat b() {
            a();
            WindowInsetsCompat r10 = WindowInsetsCompat.m(this.f17631c.build());
            r10.i(this.f17633b);
            return r10;
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.d
        public void c(vd.b r10) {
            this.f17631c.setMandatorySystemGestureInsets(r10.d());
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.d
        public void d(vd.b r10) {
            this.f17631c.setSystemGestureInsets(r10.d());
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.d
        public void e(vd.b r10) {
            this.f17631c.setSystemWindowInsets(r10.d());
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.d
        public void f(vd.b r10) {
            this.f17631c.setTappableElementInsets(r10.d());
        }
    }

    public static class c extends b {
        public c() {
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WindowInsetsCompat f17632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public vd.b[] f17633b;

        public d() {
            this(new WindowInsetsCompat(null));
        }

        public final void a() {
            vd.b[] r10 = this.f17633b;
            if (r10 == null) goto L22;
            vd.b r11 = r10[Type.b(1)];
            vd.b r12 = this.f17633b[Type.b(2)];
            if (r11 == null) goto L8;
            if (r12 == null) goto L8;
            e(vd.b.a(r11, r12));
        L12:
            vd.b r13 = this.f17633b[Type.b(16)];
            if (r13 == null) goto L15;
            d(r13);
        L15:
            vd.b r14 = this.f17633b[Type.b(32)];
            if (r14 == null) goto L18;
            c(r14);
        L18:
            vd.b r15 = this.f17633b[Type.b(64)];
            if (r15 == null) goto L23;
            f(r15);
            return;
        L23:
            return;
        L8:
            if (r11 == null) goto L10;
            e(r11);
            goto L12
        L10:
            if (r12 == null) goto L12;
            e(r12);
            goto L12
        }

        public abstract WindowInsetsCompat b();

        public abstract void c(vd.b r10);

        public abstract void d(vd.b r10);

        public abstract void e(vd.b r10);

        public abstract void f(vd.b r10);

        public d(WindowInsetsCompat r10) {
            this.f17632a = r10;
        }
    }

    public static class e extends j {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WindowInsets f17634c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public vd.b[] f17635d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public vd.b f17636e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public WindowInsetsCompat f17637f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public vd.b f17638g;

        static {
        }

        public e(WindowInsetsCompat r10, WindowInsets r11) {
            super(r10);
            this.f17636e = null;
            this.f17634c = r11;
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.j
        public void d(View r10) {
            vd.b r11 = v(r10);
            if (r11 != null) goto L5;
            r11 = vd.b.f25226e;
        L5:
            q(r11);
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.j
        public void e(WindowInsetsCompat r10) {
            r10.k(this.f17637f);
            r10.j(this.f17638g);
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.j
        public boolean equals(Object r10) {
            if (super.equals(r10) == true) goto L7;
            return false;
        L7:
            return Objects.equals(this.f17638g, ((e) r10).f17638g);
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.j
        public vd.b g(int r10) {
            return s(r10, false);
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.j
        public vd.b h(int r10) {
            return s(r10, true);
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.j
        public final vd.b l() {
            if (this.f17636e != null) goto L6;
            this.f17636e = vd.b.b(this.f17634c.getSystemWindowInsetLeft(), this.f17634c.getSystemWindowInsetTop(), this.f17634c.getSystemWindowInsetRight(), this.f17634c.getSystemWindowInsetBottom());
        L6:
            return this.f17636e;
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.j
        public boolean o() {
            return this.f17634c.isRound();
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.j
        public void p(vd.b[] r10) {
            this.f17635d = r10;
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.j
        public void q(vd.b r10) {
            this.f17638g = r10;
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.j
        public void r(WindowInsetsCompat r10) {
            this.f17637f = r10;
        }

        public final vd.b s(int r10, boolean r11) {
            vd.b r12 = vd.b.f25226e;
            int r13 = 1;
        L4:
            if (r13 > 256) goto L10;
            if ((r10 & r13) == 0) goto L9;
            r12 = vd.b.a(r12, t(r13, r11));
        L9:
            r13 = r13 << 1;
            goto L4
        L10:
            return r12;
        }

        public vd.b t(int r10, boolean r11) {
            if (r10 == 1) goto L63;
            vd.b r12 = null;
            if (r10 != 2) goto L7;
            if (r11 == false) goto L55;
            vd.b r13 = u();
            vd.b r14 = j();
            return vd.b.b(Math.max(r13.f25227a, r14.f25227a), 0, Math.max(r13.f25229c, r14.f25229c), Math.max(r13.f25230d, r14.f25230d));
        L55:
            vd.b r15 = l();
            WindowInsetsCompat r16 = this.f17637f;
            if (r16 == null) goto L58;
            r12 = r16.h();
        L58:
            int r17 = r15.f25230d;
            if (r12 == null) goto L62;
            r17 = Math.min(r17, r12.f25230d);
        L62:
            return vd.b.b(r15.f25227a, 0, r15.f25229c, r17);
        L7:
            if (r10 != 8) goto L9;
            vd.b[] r18 = this.f17635d;
            if (r18 == null) goto L36;
            r12 = r18[Type.b(8)];
        L36:
            if (r12 == null) goto L38;
            return r12;
        L38:
            vd.b r19 = l();
            vd.b r20 = u();
            int r21 = r19.f25230d;
            if (r21 > r20.f25230d) goto L41;
            vd.b r22 = this.f17638g;
            if (r22 == null) goto L51;
            if (r22.equals(vd.b.f25226e) == true) goto L51;
            int r23 = this.f17638g.f25230d;
            if (r23 <= r20.f25230d) goto L51;
            return vd.b.b(0, 0, 0, r23);
        L51:
            return vd.b.f25226e;
        L41:
            return vd.b.b(0, 0, 0, r21);
        L9:
            if (r10 == 16) goto L32;
            if (r10 == 32) goto L30;
            if (r10 == 64) goto L28;
            if (r10 != 128) goto L17;
            WindowInsetsCompat r24 = this.f17637f;
            if (r24 == null) goto L21;
            vd.a r25 = r24.e();
        L22:
            if (r25 == null) goto L26;
            return vd.b.b(r25.b(), r25.d(), r25.c(), r25.a());
        L26:
            return vd.b.f25226e;
        L21:
            r25 = f();
            goto L22
        L17:
            return vd.b.f25226e;
        L28:
            return m();
        L30:
            return i();
        L32:
            return k();
        L63:
            if (r11 == false) goto L67;
            return vd.b.b(0, Math.max(u().f25228b, l().f25228b), 0, 0);
        L67:
            return vd.b.b(0, l().f25228b, 0, 0);
        }

        public final vd.b u() {
            WindowInsetsCompat r10 = this.f17637f;
            if (r10 == null) goto L7;
            return r10.h();
        L7:
            return vd.b.f25226e;
        }

        public final vd.b v(View r10) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        public e(WindowInsetsCompat r10, e r11) {
            this(r10, new WindowInsets(r11.f17634c));
        }
    }

    public static class f extends e {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public vd.b f17639h;

        public f(WindowInsetsCompat r10, WindowInsets r11) {
            super(r10, r11);
            this.f17639h = null;
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.j
        public WindowInsetsCompat b() {
            return WindowInsetsCompat.m(this.f17634c.consumeStableInsets());
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.j
        public WindowInsetsCompat c() {
            return WindowInsetsCompat.m(this.f17634c.consumeSystemWindowInsets());
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.j
        public final vd.b j() {
            if (this.f17639h != null) goto L6;
            this.f17639h = vd.b.b(this.f17634c.getStableInsetLeft(), this.f17634c.getStableInsetTop(), this.f17634c.getStableInsetRight(), this.f17634c.getStableInsetBottom());
        L6:
            return this.f17639h;
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.j
        public boolean n() {
            return this.f17634c.isConsumed();
        }

        public f(WindowInsetsCompat r10, f r11) {
            super(r10, r11);
            this.f17639h = null;
            this.f17639h = r11.f17639h;
        }
    }

    public static class g extends f {
        public g(WindowInsetsCompat r10, WindowInsets r11) {
            super(r10, r11);
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.j
        public WindowInsetsCompat a() {
            return WindowInsetsCompat.m(this.f17634c.consumeDisplayCutout());
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.e, com.obric.oui.view.WindowInsetsCompat.j
        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof g) == true) goto L8;
            return false;
        L8:
            g r11 = (g) r10;
            if (Objects.equals(this.f17634c, r11.f17634c) == false) goto L14;
            if (Objects.equals(this.f17638g, r11.f17638g) == false) goto L14;
            return true;
        L14:
            return false;
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.j
        public vd.a f() {
            return vd.a.e(this.f17634c.getDisplayCutout());
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.j
        public int hashCode() {
            return this.f17634c.hashCode();
        }

        public g(WindowInsetsCompat r10, g r11) {
            super(r10, r11);
        }
    }

    public static class h extends g {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public vd.b f17640i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public vd.b f17641j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public vd.b f17642k;

        public h(WindowInsetsCompat r10, WindowInsets r11) {
            super(r10, r11);
            this.f17640i = null;
            this.f17641j = null;
            this.f17642k = null;
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.j
        public vd.b i() {
            if (this.f17641j != null) goto L6;
            this.f17641j = vd.b.c(this.f17634c.getMandatorySystemGestureInsets());
        L6:
            return this.f17641j;
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.j
        public vd.b k() {
            if (this.f17640i != null) goto L6;
            this.f17640i = vd.b.c(this.f17634c.getSystemGestureInsets());
        L6:
            return this.f17640i;
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.j
        public vd.b m() {
            if (this.f17642k != null) goto L6;
            this.f17642k = vd.b.c(this.f17634c.getTappableElementInsets());
        L6:
            return this.f17642k;
        }

        public h(WindowInsetsCompat r10, h r11) {
            super(r10, r11);
            this.f17640i = null;
            this.f17641j = null;
            this.f17642k = null;
        }
    }

    public static class i extends h {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final WindowInsetsCompat f17643l = null;

        static {
            f17643l = WindowInsetsCompat.m(WindowInsets.CONSUMED);
        }

        public i(WindowInsetsCompat r10, WindowInsets r11) {
            super(r10, r11);
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.e, com.obric.oui.view.WindowInsetsCompat.j
        public final void d(View r10) {
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.e, com.obric.oui.view.WindowInsetsCompat.j
        public vd.b g(int r10) {
            return vd.b.c(this.f17634c.getInsets(k.a(r10)));
        }

        @Override // com.obric.oui.view.WindowInsetsCompat.e, com.obric.oui.view.WindowInsetsCompat.j
        public vd.b h(int r10) {
            return vd.b.c(this.f17634c.getInsetsIgnoringVisibility(k.a(r10)));
        }

        public i(WindowInsetsCompat r10, i r11) {
            super(r10, r11);
        }
    }

    public static class j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final WindowInsetsCompat f17644b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WindowInsetsCompat f17645a;

        static {
            f17644b = new a().a().a().b().c();
        }

        public j(WindowInsetsCompat r10) {
            this.f17645a = r10;
        }

        public WindowInsetsCompat a() {
            return this.f17645a;
        }

        public WindowInsetsCompat b() {
            return this.f17645a;
        }

        public WindowInsetsCompat c() {
            return this.f17645a;
        }

        public void d(View r10) {
        }

        public void e(WindowInsetsCompat r10) {
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof j) == true) goto L8;
            return false;
        L8:
            j r11 = (j) r10;
            if (o() != r11.o()) goto L20;
            if (n() != r11.n()) goto L20;
            if (androidx.core.util.b.a(l(), r11.l()) == false) goto L20;
            if (androidx.core.util.b.a(j(), r11.j()) == false) goto L20;
            if (androidx.core.util.b.a(f(), r11.f()) == false) goto L20;
            return true;
        L20:
            return false;
        }

        public vd.a f() {
            return null;
        }

        public vd.b g(int r10) {
            return vd.b.f25226e;
        }

        public vd.b h(int r10) {
            if ((r10 & 8) != 0) goto L7;
            return vd.b.f25226e;
        L7:
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        public int hashCode() {
            return androidx.core.util.b.b(new Object[]{Boolean.valueOf(o()), Boolean.valueOf(n()), l(), j(), f()});
        }

        public vd.b i() {
            return l();
        }

        public vd.b j() {
            return vd.b.f25226e;
        }

        public vd.b k() {
            return l();
        }

        public vd.b l() {
            return vd.b.f25226e;
        }

        public vd.b m() {
            return l();
        }

        public boolean n() {
            return false;
        }

        public boolean o() {
            return false;
        }

        public void p(vd.b[] r10) {
        }

        public void q(vd.b r10) {
        }

        public void r(WindowInsetsCompat r10) {
        }
    }

    public static final class k {
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
        f17628b = i.f17643l;
    }

    public WindowInsetsCompat(WindowInsets r10) {
        this.f17629a = new i(this, r10);
    }

    public static WindowInsetsCompat m(WindowInsets r10) {
        return n(r10, null);
    }

    public static WindowInsetsCompat n(WindowInsets r10, View r11) {
        WindowInsetsCompat r12 = new WindowInsetsCompat((WindowInsets) androidx.core.util.e.g(r10));
        if (r11 != null) goto L5;
    L7:
        return r12;
    L5:
        if (r11.isAttachedToWindow() == false) goto L7;
        r12.k(ViewCompat.a(r11));
        r12.d(r11.getRootView());
        goto L7
    }

    public WindowInsetsCompat a() {
        return this.f17629a.a();
    }

    public WindowInsetsCompat b() {
        return this.f17629a.b();
    }

    public WindowInsetsCompat c() {
        return this.f17629a.c();
    }

    public void d(View r10) {
        this.f17629a.d(r10);
    }

    public vd.a e() {
        return this.f17629a.f();
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof WindowInsetsCompat) == true) goto L10;
        return false;
    L10:
        return androidx.core.util.b.a(this.f17629a, ((WindowInsetsCompat) r10).f17629a);
    }

    public vd.b f(int r10) {
        return this.f17629a.g(r10);
    }

    public vd.b g(int r10) {
        return this.f17629a.h(r10);
    }

    public vd.b h() {
        return this.f17629a.j();
    }

    public int hashCode() {
        j r10 = this.f17629a;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.hashCode();
    }

    public void i(vd.b[] r10) {
        this.f17629a.p(r10);
    }

    public void j(vd.b r10) {
        this.f17629a.q(r10);
    }

    public void k(WindowInsetsCompat r10) {
        this.f17629a.r(r10);
    }

    public WindowInsets l() {
        j r10 = this.f17629a;
        if ((r10 instanceof e) == true) goto L7;
        return null;
    L7:
        return ((e) r10).f17634c;
    }

    public WindowInsetsCompat(WindowInsetsCompat r10) {
        if (r10 == null) goto L21;
        j r11 = r10.f17629a;
        if ((r11 instanceof i) == false) goto L8;
        this.f17629a = new i(this, (i) r11);
    L20:
        r11.e(this);
        return;
    L8:
        if ((r11 instanceof h) == false) goto L11;
        this.f17629a = new h(this, (h) r11);
        goto L20
    L11:
        if ((r11 instanceof g) == false) goto L14;
        this.f17629a = new g(this, (g) r11);
        goto L20
    L14:
        if ((r11 instanceof f) == false) goto L17;
        this.f17629a = new f(this, (f) r11);
        goto L20
    L17:
        if ((r11 instanceof e) == false) goto L19;
        this.f17629a = new e(this, (e) r11);
        goto L20
    L19:
        this.f17629a = new j(this);
        goto L20
    L21:
        this.f17629a = new j(this);
    }
}
