package com.google.android.material.card;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.view.ViewCompat;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.android.material.color.b;
import com.google.android.material.g.c;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.d;
import com.google.android.material.shape.e;
import com.google.android.material.shape.l;
import com.google.android.material.shape.m;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MaterialCardViewHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final double f13285a = 0.0d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Drawable f13286b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MaterialCardView f13287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f13288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MaterialShapeDrawable f13289e;
    private final MaterialShapeDrawable f;
    private int g;
    private int h;
    private int i;
    private int j;
    private Drawable k;
    private Drawable l;
    private ColorStateList m;
    private ColorStateList n;
    private m o;
    private ColorStateList p;
    private Drawable q;
    private LayerDrawable r;
    private MaterialShapeDrawable s;
    private MaterialShapeDrawable t;
    private boolean u;
    private boolean v;

    static {
        f13285a = Math.cos(Math.toRadians(45.0d));
        if (Build.VERSION.SDK_INT > 28) goto L5;
        ColorDrawable r0 = new ColorDrawable();
    L6:
        f13286b = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    public a(MaterialCardView r5, AttributeSet r6, int r7, int r8) {
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        this.f13288d = new Rect();
        this.u = false;
        this.f13287c = r5;
        MaterialShapeDrawable r0 = new MaterialShapeDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r9, r7, r8);
        this.f13289e = r0;
        r0.initializeElevationOverlay((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        r0.setShadowColor(-12303292);
        m.a r10 = r0.getShapeAppearanceModel().n();
        TypedArray r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(r9, R.styleable.CardView, r7, ZeusTransformUtils.mapRes(R.style.CardView, "style", "CardView"));
        if (r11.hasValue(ZeusTransformUtils.mapRes(R.styleable.CardView_cardCornerRadius, "styleable", "CardView_cardCornerRadius")) == false) goto L5;
        r10.a(r11.getDimension(ZeusTransformUtils.mapRes(R.styleable.CardView_cardCornerRadius, "styleable", "CardView_cardCornerRadius"), 0.0f));
    L5:
        this.f = new MaterialShapeDrawable();
        a(r10.a());
        r11.recycle();
    }

    void a(TypedArray r7) {
        ColorStateList r0 = c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13287c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7, ZeusTransformUtils.mapRes(R.styleable.MaterialCardView_strokeColor, "styleable", "MaterialCardView_strokeColor"));
        this.p = r0;
        if (r0 != null) goto L5;
        this.p = ColorStateList.valueOf(-1);
    L5:
        this.j = r7.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.MaterialCardView_strokeWidth, "styleable", "MaterialCardView_strokeWidth"), 0);
        boolean r1 = r7.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MaterialCardView_android_checkable, "styleable", "MaterialCardView_android_checkable"), false);
        this.v = r1;
        this.f13287c.setLongClickable(r1);
        this.n = c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13287c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7, ZeusTransformUtils.mapRes(R.styleable.MaterialCardView_checkedIconTint, "styleable", "MaterialCardView_checkedIconTint"));
        a(c.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13287c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7, ZeusTransformUtils.mapRes(R.styleable.MaterialCardView_checkedIcon, "styleable", "MaterialCardView_checkedIcon")));
        b(r7.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.MaterialCardView_checkedIconSize, "styleable", "MaterialCardView_checkedIconSize"), 0));
        c(r7.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.MaterialCardView_checkedIconMargin, "styleable", "MaterialCardView_checkedIconMargin"), 0));
        this.i = r7.getInteger(ZeusTransformUtils.mapRes(R.styleable.MaterialCardView_checkedIconGravity, "styleable", "MaterialCardView_checkedIconGravity"), 8388661);
        ColorStateList r2 = c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13287c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7, ZeusTransformUtils.mapRes(R.styleable.MaterialCardView_rippleColor, "styleable", "MaterialCardView_rippleColor"));
        this.m = r2;
        if (r2 != null) goto L8;
        this.m = ColorStateList.valueOf(b.a(this.f13287c, ZeusTransformUtils.mapRes(R.attr.colorControlHighlight, "attr", "colorControlHighlight")));
    L8:
        c(c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13287c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r7, ZeusTransformUtils.mapRes(R.styleable.MaterialCardView_cardForegroundColor, "styleable", "MaterialCardView_cardForegroundColor")));
        I();
        l();
        n();
        this.f13287c.setBackgroundInternal(c(this.f13289e));
        if (this.f13287c.isClickable() == false) goto L11;
        Drawable r8 = F();
    L12:
        this.k = r8;
        this.f13287c.setForeground(c(r8));
        return;
    L11:
        r8 = this.f;
        goto L12
    }

    boolean a() {
        return this.u;
    }

    void a(boolean r1) {
        this.u = r1;
    }

    void a(ColorStateList r2) {
        if (this.p != r2) goto L5;
        return;
    L5:
        this.p = r2;
        n();
    }

    int b() {
        ColorStateList r0 = this.p;
        if (r0 != null) goto L6;
        return -1;
    L6:
        return r0.getDefaultColor();
    }

    ColorStateList c() {
        return this.p;
    }

    void a(int r2) {
        if (r2 != this.j) goto L5;
        return;
    L5:
        this.j = r2;
        n();
    }

    int d() {
        return this.j;
    }

    MaterialShapeDrawable e() {
        return this.f13289e;
    }

    void b(ColorStateList r1) {
        this.f13289e.setFillColor(r1);
    }

    ColorStateList f() {
        return this.f13289e.getFillColor();
    }

    void c(ColorStateList r1) {
        MaterialShapeDrawable r0 = this.f;
        if (r1 != null) goto L5;
        r1 = ColorStateList.valueOf(0);
    L5:
        r0.setFillColor(r1);
    }

    ColorStateList g() {
        return this.f.getFillColor();
    }

    void a(int r2, int r3, int r4, int r5) {
        this.f13288d.set(r2, r3, r4, r5);
        o();
    }

    Rect h() {
        return this.f13288d;
    }

    void i() {
        Drawable r0 = this.k;
        if (this.f13287c.isClickable() == false) goto L5;
        Drawable r1 = F();
    L6:
        this.k = r1;
        if (r0 == r1) goto L10;
        b(r1);
        return;
    L10:
        return;
    L5:
        r1 = this.f;
        goto L6
    }

    void a(float r2) {
        a(this.o.a(r2));
        this.k.invalidateSelf();
        if (D() == false) goto L5;
    L6:
        o();
    L8:
        if (D() == false) goto L11;
        m();
        return;
    L11:
        return;
    L5:
        if (C() == false) goto L8;
        goto L6
    }

    float j() {
        return this.f13289e.getTopLeftCornerResolvedSize();
    }

    void b(float r2) {
        this.f13289e.setInterpolation(r2);
        MaterialShapeDrawable r0 = this.f;
        if (r0 == null) goto L5;
        r0.setInterpolation(r2);
    L5:
        MaterialShapeDrawable r1 = this.t;
        if (r1 == null) goto L9;
        r1.setInterpolation(r2);
        return;
    }

    float k() {
        return this.f13289e.getInterpolation();
    }

    void l() {
        this.f13289e.setElevation(this.f13287c.getCardElevation());
    }

    void m() {
        if (a() == true) goto L5;
        this.f13287c.setBackgroundInternal(c(this.f13289e));
    L5:
        this.f13287c.setForeground(c(this.k));
    }

    void n() {
        this.f.setStroke(this.j, this.p);
    }

    void o() {
        if (C() == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        float r1 = E();
    L12:
        int r2 = (int) (r1 - B());
        this.f13287c.setAncestorContentPadding(this.f13288d.left + r2, this.f13288d.top + r2, this.f13288d.right + r2, this.f13288d.bottom + r2);
        return;
    L11:
        r1 = 0.0f;
        goto L12
    L5:
        if (D() == true) goto L8;
        r0 = false;
        goto L9
    }

    void b(boolean r1) {
        this.v = r1;
    }

    boolean p() {
        return this.v;
    }

    void d(ColorStateList r1) {
        this.m = r1;
        I();
    }

    void e(ColorStateList r1) {
        this.n = r1;
        Drawable r0 = this.l;
        if (r0 == null) goto L6;
        androidx.core.graphics.drawable.a.a(r0, r1);
        return;
    }

    ColorStateList q() {
        return this.n;
    }

    ColorStateList r() {
        return this.m;
    }

    Drawable s() {
        return this.l;
    }

    void a(Drawable r4) {
        if (r4 == null) goto L4;
        Drawable r5 = androidx.core.graphics.drawable.a.g(r4).mutate();
        this.l = r5;
        androidx.core.graphics.drawable.a.a(r5, this.n);
        c(this.f13287c.isChecked());
    L5:
        LayerDrawable r6 = this.r;
        if (r6 == null) goto L9;
        r6.setDrawableByLayerId(ZeusTransformUtils.mapRes(R.id.mtrl_card_checked_layer_id, DbHelper.COL_ID, "mtrl_card_checked_layer_id"), this.l);
        return;
    L9:
        return;
    L4:
        this.l = f13286b;
        goto L5
    }

    int t() {
        return this.h;
    }

    void b(int r1) {
        this.h = r1;
    }

    int u() {
        return this.g;
    }

    void c(int r1) {
        this.g = r1;
    }

    void a(int r13, int r14) {
        if (this.r == null) goto L36;
        int r3 = 0;
        if (Build.VERSION.SDK_INT >= 21) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
    L13:
        int r4 = (int) Math.ceil(y() * 2.0f);
        r3 = (int) Math.ceil(z() * 2.0f);
        int r1 = r4;
    L15:
        if (K() == false) goto L17;
        int r2 = ((r13 - this.g) - this.h) - r3;
    L19:
        if (L() == false) goto L21;
        int r5 = this.g;
    L22:
        int r10 = r5;
        if (K() == false) goto L25;
        int r15 = this.g;
    L27:
        if (L() == false) goto L29;
        int r16 = ((r14 - this.g) - this.h) - r1;
    L30:
        int r8 = r16;
        if (ViewCompat.i(this.f13287c) != 1) goto L33;
        int r7 = r15;
        int r9 = r2;
    L34:
        this.r.setLayerInset(2, r7, r8, r9, r10);
        return;
    L33:
        r9 = r15;
        r7 = r2;
        goto L34
    L29:
        r16 = this.g;
        goto L30
    L25:
        r15 = ((r13 - this.g) - this.h) - r3;
        goto L27
    L21:
        r5 = ((r14 - this.g) - this.h) - r1;
        goto L22
    L17:
        r2 = this.g;
        goto L19
    L10:
        if (this.f13287c.getUseCompatPadding() == true) goto L13;
        r1 = 0;
        goto L15
    L7:
        r0 = false;
        goto L8
    }

    void v() {
        Drawable r0 = this.q;
        if (r0 == null) goto L6;
        Rect r1 = r0.getBounds();
        int r2 = r1.bottom;
        this.q.setBounds(r1.left, r1.top, r1.right, r2 - 1);
        this.q.setBounds(r1.left, r1.top, r1.right, r2);
        return;
    }

    void a(m r3) {
        this.o = r3;
        this.f13289e.setShapeAppearanceModel(r3);
        MaterialShapeDrawable r0 = this.f13289e;
        r0.setShadowBitmapDrawingEnable(!r0.isRoundRect());
        MaterialShapeDrawable r1 = this.f;
        if (r1 == null) goto L5;
        r1.setShapeAppearanceModel(r3);
    L5:
        MaterialShapeDrawable r2 = this.t;
        if (r2 == null) goto L8;
        r2.setShapeAppearanceModel(r3);
    L8:
        MaterialShapeDrawable r4 = this.s;
        if (r4 == null) goto L12;
        r4.setShapeAppearanceModel(r3);
        return;
    }

    m w() {
        return this.o;
    }

    private void b(Drawable r3) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
    L7:
        this.f13287c.setForeground(c(r3));
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(this.f13287c.getForeground(), InsetDrawable.class) == false) goto L7;
        ((InsetDrawable) ZeusTransformUtils.preCheckCast(this.f13287c.getForeground(), InsetDrawable.class, "com.obric.aiagent.plugin")).setDrawable(r3);
    }

    private Drawable c(final Drawable r10) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
    L11:
        int r1 = (int) Math.ceil(y());
        final int r7 = (int) Math.ceil(z());
        final int r8 = r1;
    L12:
        final int r5 = r7;
        final int r6 = r8;
        return new MaterialCardViewHelper$1(this, r10, r5, r6, r7, r8);
    L8:
        if (this.f13287c.getUseCompatPadding() == true) goto L11;
        r7 = 0;
        r8 = 0;
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    private float y() {
        float r0 = this.f13287c.getMaxCardElevation() * 1.5f;
        if (D() == false) goto L5;
        float r2 = E();
    L7:
        return r0 + r2;
    L5:
        r2 = 0.0f;
        goto L7
    }

    private float z() {
        float r0 = this.f13287c.getMaxCardElevation();
        if (D() == false) goto L5;
        float r2 = E();
    L7:
        return r0 + r2;
    L5:
        r2 = 0.0f;
        goto L7
    }

    private boolean A() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
    L7:
        return false;
    L5:
        if (this.f13289e.isRoundRect() == false) goto L7;
        return true;
    }

    private float B() {
        if (this.f13287c.getPreventCornerOverlap() == true) goto L5;
        return 0.0f;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L9;
        if (this.f13287c.getUseCompatPadding() == true) goto L9;
        return 0.0f;
    L9:
        return (float) ((1.0d - f13285a) * ((double) this.f13287c.getCardViewRadius()));
    }

    private boolean C() {
        if (this.f13287c.getPreventCornerOverlap() == true) goto L5;
    L7:
        return false;
    L5:
        if (A() == true) goto L7;
        return true;
    }

    private boolean D() {
        if (this.f13287c.getPreventCornerOverlap() == true) goto L5;
    L9:
        return false;
    L5:
        if (A() == false) goto L9;
        if (this.f13287c.getUseCompatPadding() == false) goto L9;
        return true;
    }

    private float E() {
        return Math.max(Math.max(a(this.o.b(), this.f13289e.getTopLeftCornerResolvedSize()), a(this.o.c(), this.f13289e.getTopRightCornerResolvedSize())), Math.max(a(this.o.d(), this.f13289e.getBottomRightCornerResolvedSize()), a(this.o.e(), this.f13289e.getBottomLeftCornerResolvedSize())));
    }

    private float a(d r3, float r4) {
        if (ZeusTransformUtils.instanceOf(r3, l.class) == false) goto L7;
        return (float) ((1.0d - f13285a) * ((double) r4));
    L7:
        if (ZeusTransformUtils.instanceOf(r3, e.class) == true) goto L9;
        return 0.0f;
    L9:
        return r4 / 2.0f;
    }

    private Drawable F() {
        if (this.q != null) goto L6;
        this.q = G();
    L6:
        if (this.r != null) goto L9;
        LayerDrawable r0 = new LayerDrawable(new Drawable[]{this.q, this.f, this.l});
        this.r = r0;
        r0.setId(2, ZeusTransformUtils.mapRes(R.id.mtrl_card_checked_layer_id, DbHelper.COL_ID, "mtrl_card_checked_layer_id"));
    L9:
        return this.r;
    }

    private Drawable G() {
        if (com.google.android.material.ripple.a.f13528a == false) goto L7;
        this.t = J();
        return new RippleDrawable(this.m, null, this.t);
    L7:
        return H();
    }

    private Drawable H() {
        StateListDrawable r0 = new StateListDrawable();
        MaterialShapeDrawable r1 = J();
        this.s = r1;
        r1.setFillColor(this.m);
        r0.addState(new int[]{android.R.attr.state_pressed}, this.s);
        return r0;
    }

    private void I() {
        if (com.google.android.material.ripple.a.f13528a == false) goto L7;
        Drawable r0 = this.q;
        if (r0 == null) goto L7;
        ((RippleDrawable) ZeusTransformUtils.preCheckCast(r0, RippleDrawable.class, "com.obric.aiagent.plugin")).setColor(this.m);
        return;
    L7:
        MaterialShapeDrawable r1 = this.s;
        if (r1 == null) goto L12;
        r1.setFillColor(this.m);
        return;
    }

    private MaterialShapeDrawable J() {
        return new MaterialShapeDrawable(this.o);
    }

    public void c(boolean r1) {
        Drawable r0 = this.l;
        if (r0 == null) goto L9;
        if (r1 == false) goto L6;
        int r2 = 255;
    L7:
        r0.setAlpha(r2);
        return;
    L6:
        r2 = 0;
        goto L7
    }

    int x() {
        return this.i;
    }

    void d(int r2) {
        this.i = r2;
        a(this.f13287c.getMeasuredWidth(), this.f13287c.getMeasuredHeight());
    }

    private boolean K() {
        if ((this.i & 8388613) != 8388613) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean L() {
        if ((this.i & 80) != 80) goto L5;
        return true;
    L5:
        return false;
    }
}
