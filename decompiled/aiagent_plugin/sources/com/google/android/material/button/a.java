package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.core.view.ViewCompat;
import com.google.android.material.color.b;
import com.google.android.material.g.c;
import com.google.android.material.internal.r;
import com.google.android.material.ripple.RippleDrawableCompat;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.m;
import com.google.android.material.shape.q;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MaterialButtonHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f13275a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f13276b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MaterialButton f13277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private m f13278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f13279e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private PorterDuff.Mode k;
    private ColorStateList l;
    private ColorStateList m;
    private ColorStateList n;
    private Drawable o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private LayerDrawable t;
    private int u;

    static {
        boolean r1 = true;
        if (Build.VERSION.SDK_INT < 21) goto L5;
        boolean r0 = true;
    L6:
        f13275a = r0;
        if (Build.VERSION.SDK_INT >= 21) goto L9;
    L11:
        r1 = false;
    L12:
        f13276b = r1;
        return;
    L9:
        if (Build.VERSION.SDK_INT > 22) goto L11;
    L5:
        r0 = false;
        goto L6
    }

    a(MaterialButton r2, m r3) {
        this.p = false;
        this.q = false;
        this.r = false;
        this.f13277c = r2;
        this.f13278d = r3;
    }

    void a(TypedArray r8) {
        this.f13279e = r8.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.MaterialButton_android_insetLeft, "styleable", "MaterialButton_android_insetLeft"), 0);
        this.f = r8.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.MaterialButton_android_insetRight, "styleable", "MaterialButton_android_insetRight"), 0);
        this.g = r8.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.MaterialButton_android_insetTop, "styleable", "MaterialButton_android_insetTop"), 0);
        this.h = r8.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.MaterialButton_android_insetBottom, "styleable", "MaterialButton_android_insetBottom"), 0);
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.MaterialButton_cornerRadius, "styleable", "MaterialButton_cornerRadius")) == false) goto L5;
        int r0 = r8.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.MaterialButton_cornerRadius, "styleable", "MaterialButton_cornerRadius"), -1);
        this.i = r0;
        a(this.f13278d.a(r0));
        this.r = true;
    L5:
        this.j = r8.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.MaterialButton_strokeWidth, "styleable", "MaterialButton_strokeWidth"), 0);
        this.k = r.a(r8.getInt(ZeusTransformUtils.mapRes(R.styleable.MaterialButton_backgroundTintMode, "styleable", "MaterialButton_backgroundTintMode"), -1), PorterDuff.Mode.SRC_IN);
        this.l = c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13277c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r8, ZeusTransformUtils.mapRes(R.styleable.MaterialButton_backgroundTint, "styleable", "MaterialButton_backgroundTint"));
        this.m = c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13277c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r8, ZeusTransformUtils.mapRes(R.styleable.MaterialButton_strokeColor, "styleable", "MaterialButton_strokeColor"));
        this.n = c.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13277c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r8, ZeusTransformUtils.mapRes(R.styleable.MaterialButton_rippleColor, "styleable", "MaterialButton_rippleColor"));
        this.s = r8.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MaterialButton_android_checkable, "styleable", "MaterialButton_android_checkable"), false);
        this.u = r8.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.MaterialButton_elevation, "styleable", "MaterialButton_elevation"), 0);
        int r1 = ViewCompat.l(this.f13277c);
        int r2 = this.f13277c.getPaddingTop();
        int r3 = ViewCompat.m(this.f13277c);
        int r4 = this.f13277c.getPaddingBottom();
        if (r8.hasValue(ZeusTransformUtils.mapRes(R.styleable.MaterialButton_android_background, "styleable", "MaterialButton_android_background")) == false) goto L8;
        a();
    L9:
        ViewCompat.b(this.f13277c, r1 + this.f13279e, r2 + this.g, r3 + this.f, r4 + this.h);
        return;
    L8:
        o();
        goto L9
    }

    private void o() {
        this.f13277c.setInternalBackground(p());
        MaterialShapeDrawable r0 = i();
        if (r0 == null) goto L6;
        r0.setElevation(this.u);
        return;
    }

    void a() {
        this.q = true;
        this.f13277c.setSupportBackgroundTintList(this.l);
        this.f13277c.setSupportBackgroundTintMode(this.k);
    }

    boolean b() {
        return this.q;
    }

    private InsetDrawable a(Drawable r8) {
        return new InsetDrawable(r8, this.f13279e, this.g, this.f, this.h);
    }

    void a(ColorStateList r2) {
        if (this.l == r2) goto L8;
        this.l = r2;
        if (i() == null) goto L9;
        androidx.core.graphics.drawable.a.a(i(), this.l);
        return;
    L9:
        return;
    }

    ColorStateList c() {
        return this.l;
    }

    void a(PorterDuff.Mode r2) {
        if (this.k == r2) goto L10;
        this.k = r2;
        if (i() != null) goto L7;
        return;
    L7:
        if (this.k == null) goto L12;
        androidx.core.graphics.drawable.a.a(i(), this.k);
        return;
    L12:
        return;
    }

    PorterDuff.Mode d() {
        return this.k;
    }

    void a(boolean r1) {
        this.p = r1;
        q();
    }

    private Drawable p() {
        MaterialShapeDrawable r0 = new MaterialShapeDrawable(this.f13278d);
        r0.initializeElevationOverlay((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13277c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        androidx.core.graphics.drawable.a.a(r0, this.l);
        PorterDuff.Mode r1 = this.k;
        if (r1 == null) goto L5;
        androidx.core.graphics.drawable.a.a(r0, r1);
    L5:
        r0.setStroke(this.j, this.m);
        MaterialShapeDrawable r2 = new MaterialShapeDrawable(this.f13278d);
        r2.setTint(0);
        float r3 = this.j;
        if (this.p == false) goto L8;
        int r4 = b.a(this.f13277c, ZeusTransformUtils.mapRes(R.attr.colorSurface, "attr", "colorSurface"));
    L9:
        r2.setStroke(r3, r4);
        if (f13275a == false) goto L13;
        MaterialShapeDrawable r5 = new MaterialShapeDrawable(this.f13278d);
        this.o = r5;
        androidx.core.graphics.drawable.a.a(r5, -1);
        RippleDrawable r6 = new RippleDrawable(com.google.android.material.ripple.a.b(this.n), a(new LayerDrawable(new Drawable[]{r2, r0})), this.o);
        this.t = r6;
        return r6;
    L13:
        RippleDrawableCompat r7 = new RippleDrawableCompat(this.f13278d);
        this.o = r7;
        androidx.core.graphics.drawable.a.a(r7, com.google.android.material.ripple.a.b(this.n));
        LayerDrawable r8 = new LayerDrawable(new Drawable[]{r2, r0, this.o});
        this.t = r8;
        return a(r8);
    L8:
        r4 = 0;
        goto L9
    }

    void a(int r5, int r6) {
        Drawable r0 = this.o;
        if (r0 == null) goto L6;
        r0.setBounds(this.f13279e, this.g, r6 - this.f, r5 - this.h);
        return;
    }

    void a(int r2) {
        if (i() == null) goto L6;
        i().setTint(r2);
        return;
    }

    void b(ColorStateList r5) {
        if (this.n == r5) goto L14;
        this.n = r5;
        boolean r0 = f13275a;
        if (r0 == true) goto L7;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        if (ZeusTransformUtils.instanceOf(this.f13277c.getBackground(), RippleDrawableCompat.class) == false) goto L17;
        ((RippleDrawableCompat) ZeusTransformUtils.preCheckCast(this.f13277c.getBackground(), RippleDrawableCompat.class, "com.obric.aiagent.plugin")).setTintList(com.google.android.material.ripple.a.b(r5));
        return;
    L17:
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(this.f13277c.getBackground(), RippleDrawable.class) == false) goto L9;
        ((RippleDrawable) ZeusTransformUtils.preCheckCast(this.f13277c.getBackground(), RippleDrawable.class, "com.obric.aiagent.plugin")).setColor(com.google.android.material.ripple.a.b(r5));
        return;
    }

    ColorStateList e() {
        return this.n;
    }

    void c(ColorStateList r2) {
        if (this.m == r2) goto L6;
        this.m = r2;
        q();
        return;
    }

    ColorStateList f() {
        return this.m;
    }

    void b(int r2) {
        if (this.j == r2) goto L6;
        this.j = r2;
        q();
        return;
    }

    int g() {
        return this.j;
    }

    private void q() {
        MaterialShapeDrawable r0 = i();
        MaterialShapeDrawable r1 = r();
        if (r0 == null) goto L12;
        r0.setStroke(this.j, this.m);
        if (r1 == null) goto L13;
        float r2 = this.j;
        if (this.p == false) goto L9;
        int r5 = b.a(this.f13277c, ZeusTransformUtils.mapRes(R.attr.colorSurface, "attr", "colorSurface"));
    L10:
        r1.setStroke(r2, r5);
        return;
    L9:
        r5 = 0;
        goto L10
    L13:
        return;
    }

    void c(int r2) {
        if (this.r == true) goto L5;
    L6:
        this.i = r2;
        this.r = true;
        a(this.f13278d.a(r2));
        return;
    L5:
        if (this.i != r2) goto L6;
    }

    int h() {
        return this.i;
    }

    private MaterialShapeDrawable c(boolean r3) {
        LayerDrawable r0 = this.t;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.getNumberOfLayers() > 0) goto L7;
        return null;
    L7:
        if (f13275a == false) goto L11;
        return (MaterialShapeDrawable) ZeusTransformUtils.preCheckCast(((LayerDrawable) ZeusTransformUtils.preCheckCast(((InsetDrawable) ZeusTransformUtils.preCheckCast(this.t.getDrawable(0), InsetDrawable.class, "com.obric.aiagent.plugin")).getDrawable(), LayerDrawable.class, "com.obric.aiagent.plugin")).getDrawable(!r3 ? 1 : 0), MaterialShapeDrawable.class, "com.obric.aiagent.plugin");
    L11:
        return (MaterialShapeDrawable) ZeusTransformUtils.preCheckCast(this.t.getDrawable(!r3 ? 1 : 0), MaterialShapeDrawable.class, "com.obric.aiagent.plugin");
    }

    MaterialShapeDrawable i() {
        return c(false);
    }

    void b(boolean r1) {
        this.s = r1;
    }

    boolean j() {
        return this.s;
    }

    private MaterialShapeDrawable r() {
        return c(true);
    }

    private void b(m r4) {
        if (f13276b == false) goto L8;
        if (this.q == true) goto L8;
        int r5 = ViewCompat.l(this.f13277c);
        int r0 = this.f13277c.getPaddingTop();
        int r1 = ViewCompat.m(this.f13277c);
        int r2 = this.f13277c.getPaddingBottom();
        o();
        ViewCompat.b(this.f13277c, r5, r0, r1, r2);
        return;
    L8:
        if (i() == null) goto L11;
        i().setShapeAppearanceModel(r4);
    L11:
        if (r() == null) goto L14;
        r().setShapeAppearanceModel(r4);
    L14:
        if (k() == null) goto L18;
        k().setShapeAppearanceModel(r4);
        return;
    }

    public q k() {
        LayerDrawable r0 = this.t;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.getNumberOfLayers() > 1) goto L7;
        return null;
    L7:
        if (this.t.getNumberOfLayers() <= 2) goto L11;
        return (q) ZeusTransformUtils.preCheckCast(this.t.getDrawable(2), q.class, "com.obric.aiagent.plugin");
    L11:
        return (q) ZeusTransformUtils.preCheckCast(this.t.getDrawable(1), q.class, "com.obric.aiagent.plugin");
    }

    void a(m r1) {
        this.f13278d = r1;
        b(r1);
    }

    m l() {
        return this.f13278d;
    }

    public void d(int r2) {
        b(this.g, r2);
    }

    public int m() {
        return this.h;
    }

    public void e(int r2) {
        b(r2, this.h);
    }

    private void b(int r8, int r9) {
        int r0 = ViewCompat.l(this.f13277c);
        int r1 = this.f13277c.getPaddingTop();
        int r2 = ViewCompat.m(this.f13277c);
        int r3 = this.f13277c.getPaddingBottom();
        int r4 = this.g;
        int r5 = this.h;
        this.h = r9;
        this.g = r8;
        if (this.q == true) goto L5;
        o();
    L5:
        ViewCompat.b(this.f13277c, r0, (r1 + r8) - r4, r2, (r3 + r9) - r5);
    }

    public int n() {
        return this.g;
    }
}
