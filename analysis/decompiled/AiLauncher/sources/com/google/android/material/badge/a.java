package com.google.android.material.badge;

import W2.c;
import W2.d;
import Z2.h;
import Z2.l;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.p;
import com.google.android.material.internal.r;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;

/* loaded from: classes2.dex */
public class a extends Drawable implements p.b {

    /* renamed from: n, reason: collision with root package name */
    public static final int f20301n = R$style.Widget_MaterialComponents_Badge;

    /* renamed from: o, reason: collision with root package name */
    public static final int f20302o = R$attr.badgeStyle;

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f20303a;

    /* renamed from: b, reason: collision with root package name */
    public final h f20304b;

    /* renamed from: c, reason: collision with root package name */
    public final p f20305c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f20306d;

    /* renamed from: e, reason: collision with root package name */
    public final BadgeState f20307e;

    /* renamed from: f, reason: collision with root package name */
    public float f20308f;

    /* renamed from: g, reason: collision with root package name */
    public float f20309g;

    /* renamed from: h, reason: collision with root package name */
    public int f20310h;

    /* renamed from: i, reason: collision with root package name */
    public float f20311i;

    /* renamed from: j, reason: collision with root package name */
    public float f20312j;

    /* renamed from: k, reason: collision with root package name */
    public float f20313k;

    /* renamed from: l, reason: collision with root package name */
    public WeakReference<View> f20314l;

    /* renamed from: m, reason: collision with root package name */
    public WeakReference<FrameLayout> f20315m;

    public a(Context context, int i10, int i11, int i12, BadgeState.State state) {
        this.f20303a = new WeakReference<>(context);
        r.c(context);
        this.f20306d = new Rect();
        p pVar = new p(this);
        this.f20305c = pVar;
        pVar.g().setTextAlign(Paint.Align.CENTER);
        BadgeState badgeState = new BadgeState(context, i10, i11, i12, state);
        this.f20307e = badgeState;
        this.f20304b = new h(l.b(context, y() ? badgeState.m() : badgeState.i(), y() ? badgeState.l() : badgeState.h()).m());
        K();
    }

    public static void L(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    public static a e(Context context) {
        return new a(context, 0, f20302o, f20301n, null);
    }

    public boolean A() {
        return this.f20307e.D();
    }

    public final void B() {
        this.f20305c.g().setAlpha(getAlpha());
        invalidateSelf();
    }

    public final void C() {
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(this.f20307e.e());
        if (this.f20304b.B() != colorStateListValueOf) {
            this.f20304b.g0(colorStateListValueOf);
            invalidateSelf();
        }
    }

    public final void D() {
        this.f20305c.l(true);
        F();
        N();
        invalidateSelf();
    }

    public final void E() {
        WeakReference<View> weakReference = this.f20314l;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = this.f20314l.get();
        WeakReference<FrameLayout> weakReference2 = this.f20315m;
        M(view, weakReference2 != null ? weakReference2.get() : null);
    }

    public final void F() {
        Context context = this.f20303a.get();
        if (context == null) {
            return;
        }
        this.f20304b.setShapeAppearanceModel(l.b(context, y() ? this.f20307e.m() : this.f20307e.i(), y() ? this.f20307e.l() : this.f20307e.h()).m());
        invalidateSelf();
    }

    public final void G() {
        d dVar;
        Context context = this.f20303a.get();
        if (context == null || this.f20305c.e() == (dVar = new d(context, this.f20307e.z()))) {
            return;
        }
        this.f20305c.k(dVar, context);
        H();
        N();
        invalidateSelf();
    }

    public final void H() {
        this.f20305c.g().setColor(this.f20307e.j());
        invalidateSelf();
    }

    public final void I() {
        O();
        this.f20305c.l(true);
        N();
        invalidateSelf();
    }

    public final void J() {
        setVisible(this.f20307e.F(), false);
    }

    public final void K() {
        F();
        G();
        I();
        D();
        B();
        C();
        H();
        E();
        N();
        J();
    }

    public void M(View view, FrameLayout frameLayout) {
        this.f20314l = new WeakReference<>(view);
        this.f20315m = new WeakReference<>(frameLayout);
        L(view);
        N();
        invalidateSelf();
    }

    public final void N() {
        Context context = this.f20303a.get();
        WeakReference<View> weakReference = this.f20314l;
        View view = weakReference != null ? weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.f20306d);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        WeakReference<FrameLayout> weakReference2 = this.f20315m;
        FrameLayout frameLayout = weakReference2 != null ? weakReference2.get() : null;
        if (frameLayout != null) {
            frameLayout.offsetDescendantRectToMyCoords(view, rect2);
        }
        d(rect2, view);
        b.d(this.f20306d, this.f20308f, this.f20309g, this.f20312j, this.f20313k);
        float f10 = this.f20311i;
        if (f10 != -1.0f) {
            this.f20304b.c0(f10);
        }
        if (rect.equals(this.f20306d)) {
            return;
        }
        this.f20304b.setBounds(this.f20306d);
    }

    public final void O() {
        if (m() != -2) {
            this.f20310h = ((int) Math.pow(10.0d, m() - 1.0d)) - 1;
        } else {
            this.f20310h = n();
        }
    }

    @Override // com.google.android.material.internal.p.b
    public void a() {
        invalidateSelf();
    }

    public final void b(View view) {
        ViewParent viewParentJ = j();
        if (viewParentJ == null) {
            viewParentJ = view.getParent();
        }
        if ((viewParentJ instanceof View) && (viewParentJ.getParent() instanceof View)) {
            c(view, (View) viewParentJ.getParent());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.ViewParent] */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.view.ViewParent] */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final void c(View view, View view2) {
        float y10;
        float x10;
        View parent;
        boolean z10;
        FrameLayout frameLayoutJ = j();
        if (frameLayoutJ == null) {
            float y11 = view.getY();
            x10 = view.getX();
            parent = view.getParent();
            y10 = y11;
        } else {
            y10 = 0.0f;
            x10 = 0.0f;
            parent = frameLayoutJ;
        }
        while (true) {
            z10 = parent instanceof View;
            if (!z10 || parent == view2) {
                break;
            }
            ViewParent parent2 = parent.getParent();
            if (!(parent2 instanceof ViewGroup) || ((ViewGroup) parent2).getClipChildren()) {
                break;
            }
            View view3 = parent;
            y10 += view3.getY();
            x10 += view3.getX();
            parent = parent.getParent();
        }
        if (z10) {
            float fV = v(y10);
            float fL = l(x10);
            View view4 = parent;
            float fH = h(view4.getHeight(), y10);
            float fR = r(view4.getWidth(), x10);
            if (fV < 0.0f) {
                this.f20309g += Math.abs(fV);
            }
            if (fL < 0.0f) {
                this.f20308f += Math.abs(fL);
            }
            if (fH > 0.0f) {
                this.f20309g -= Math.abs(fH);
            }
            if (fR > 0.0f) {
                this.f20308f -= Math.abs(fR);
            }
        }
    }

    public final void d(Rect rect, View view) {
        float f10 = y() ? this.f20307e.f20292d : this.f20307e.f20291c;
        this.f20311i = f10;
        if (f10 != -1.0f) {
            this.f20312j = f10;
            this.f20313k = f10;
        } else {
            this.f20312j = Math.round((y() ? this.f20307e.f20295g : this.f20307e.f20293e) / 2.0f);
            this.f20313k = Math.round((y() ? this.f20307e.f20296h : this.f20307e.f20294f) / 2.0f);
        }
        if (y()) {
            String strG = g();
            this.f20312j = Math.max(this.f20312j, (this.f20305c.h(strG) / 2.0f) + this.f20307e.g());
            float fMax = Math.max(this.f20313k, (this.f20305c.f(strG) / 2.0f) + this.f20307e.k());
            this.f20313k = fMax;
            this.f20312j = Math.max(this.f20312j, fMax);
        }
        int iX = x();
        int iF = this.f20307e.f();
        if (iF == 8388691 || iF == 8388693) {
            this.f20309g = rect.bottom - iX;
        } else {
            this.f20309g = rect.top + iX;
        }
        int iW = w();
        int iF2 = this.f20307e.f();
        if (iF2 == 8388659 || iF2 == 8388691) {
            this.f20308f = this.f20307e.f20300l == 0 ? view.getLayoutDirection() == 0 ? (rect.left + this.f20312j) - ((this.f20313k * 2.0f) - iW) : (rect.right - this.f20312j) + ((this.f20313k * 2.0f) - iW) : view.getLayoutDirection() == 0 ? (rect.left - this.f20312j) + iW : (rect.right + this.f20312j) - iW;
        } else {
            this.f20308f = this.f20307e.f20300l == 0 ? view.getLayoutDirection() == 0 ? (rect.right + this.f20312j) - iW : (rect.left - this.f20312j) + iW : view.getLayoutDirection() == 0 ? (rect.right - this.f20312j) + ((this.f20313k * 2.0f) - iW) : (rect.left + this.f20312j) - ((this.f20313k * 2.0f) - iW);
        }
        if (this.f20307e.E()) {
            b(view);
        } else {
            c(view, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.f20304b.draw(canvas);
        if (y()) {
            f(canvas);
        }
    }

    public final void f(Canvas canvas) {
        String strG = g();
        if (strG != null) {
            Rect rect = new Rect();
            this.f20305c.g().getTextBounds(strG, 0, strG.length(), rect);
            float fExactCenterY = this.f20309g - rect.exactCenterY();
            canvas.drawText(strG, this.f20308f, rect.bottom <= 0 ? (int) fExactCenterY : Math.round(fExactCenterY), this.f20305c.g());
        }
    }

    public final String g() {
        if (A()) {
            return t();
        }
        if (z()) {
            return p();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f20307e.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f20306d.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f20306d.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final float h(float f10, float f11) {
        return ((this.f20309g + this.f20313k) - f10) + f11;
    }

    public CharSequence i() {
        if (isVisible()) {
            return A() ? u() : z() ? q() : k();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    public FrameLayout j() {
        WeakReference<FrameLayout> weakReference = this.f20315m;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final CharSequence k() {
        return this.f20307e.p();
    }

    public final float l(float f10) {
        return (this.f20308f - this.f20312j) + f10;
    }

    public int m() {
        return this.f20307e.u();
    }

    public int n() {
        return this.f20307e.v();
    }

    public int o() {
        if (this.f20307e.C()) {
            return this.f20307e.w();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.p.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public final String p() {
        if (this.f20310h == -2 || o() <= this.f20310h) {
            return NumberFormat.getInstance(this.f20307e.x()).format(o());
        }
        Context context = this.f20303a.get();
        return context == null ? "" : String.format(this.f20307e.x(), context.getString(R$string.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(this.f20310h), "+");
    }

    public final String q() {
        Context context;
        if (this.f20307e.q() == 0 || (context = this.f20303a.get()) == null) {
            return null;
        }
        return (this.f20310h == -2 || o() <= this.f20310h) ? context.getResources().getQuantityString(this.f20307e.q(), o(), Integer.valueOf(o())) : context.getString(this.f20307e.n(), Integer.valueOf(this.f20310h));
    }

    public final float r(float f10, float f11) {
        return ((this.f20308f + this.f20312j) - f10) + f11;
    }

    public String s() {
        return this.f20307e.y();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f20307e.H(i10);
        B();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public final String t() {
        String strS = s();
        int iM = m();
        if (iM == -2 || strS == null || strS.length() <= iM) {
            return strS;
        }
        Context context = this.f20303a.get();
        if (context == null) {
            return "";
        }
        return String.format(context.getString(R$string.m3_exceed_max_badge_text_suffix), strS.substring(0, iM - 1), "…");
    }

    public final CharSequence u() {
        CharSequence charSequenceO = this.f20307e.o();
        return charSequenceO != null ? charSequenceO : s();
    }

    public final float v(float f10) {
        return (this.f20309g - this.f20313k) + f10;
    }

    public final int w() {
        int iR = y() ? this.f20307e.r() : this.f20307e.s();
        if (this.f20307e.f20299k == 1) {
            iR += y() ? this.f20307e.f20298j : this.f20307e.f20297i;
        }
        return iR + this.f20307e.b();
    }

    public final int x() {
        int iB = this.f20307e.B();
        if (y()) {
            iB = this.f20307e.A();
            Context context = this.f20303a.get();
            if (context != null) {
                iB = E2.a.c(iB, iB - this.f20307e.t(), E2.a.b(0.0f, 1.0f, 0.3f, 1.0f, c.e(context) - 1.0f));
            }
        }
        if (this.f20307e.f20299k == 0) {
            iB -= Math.round(this.f20313k);
        }
        return iB + this.f20307e.c();
    }

    public final boolean y() {
        return A() || z();
    }

    public boolean z() {
        return !this.f20307e.D() && this.f20307e.C();
    }
}
