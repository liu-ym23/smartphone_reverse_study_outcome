package com.google.android.material.datepicker;

import a1.C0418k;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import q1.C0981c;
import t1.C1115h;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Rect f12661a;

    /* renamed from: b, reason: collision with root package name */
    private final ColorStateList f12662b;

    /* renamed from: c, reason: collision with root package name */
    private final ColorStateList f12663c;

    /* renamed from: d, reason: collision with root package name */
    private final ColorStateList f12664d;

    /* renamed from: e, reason: collision with root package name */
    private final int f12665e;

    /* renamed from: f, reason: collision with root package name */
    private final t1.l f12666f;

    private b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i5, t1.l lVar, Rect rect) {
        D.h.c(rect.left);
        D.h.c(rect.top);
        D.h.c(rect.right);
        D.h.c(rect.bottom);
        this.f12661a = rect;
        this.f12662b = colorStateList2;
        this.f12663c = colorStateList;
        this.f12664d = colorStateList3;
        this.f12665e = i5;
        this.f12666f = lVar;
    }

    static b a(Context context, int i5) throws Resources.NotFoundException {
        D.h.b(i5 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i5, C0418k.f6980H2);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(C0418k.f6986I2, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(C0418k.f6998K2, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(C0418k.f6992J2, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(C0418k.f7004L2, 0));
        ColorStateList colorStateListA = C0981c.a(context, typedArrayObtainStyledAttributes, C0418k.f7010M2);
        ColorStateList colorStateListA2 = C0981c.a(context, typedArrayObtainStyledAttributes, C0418k.f7040R2);
        ColorStateList colorStateListA3 = C0981c.a(context, typedArrayObtainStyledAttributes, C0418k.f7028P2);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0418k.f7034Q2, 0);
        t1.l lVarM = t1.l.b(context, typedArrayObtainStyledAttributes.getResourceId(C0418k.f7016N2, 0), typedArrayObtainStyledAttributes.getResourceId(C0418k.f7022O2, 0)).m();
        typedArrayObtainStyledAttributes.recycle();
        return new b(colorStateListA, colorStateListA2, colorStateListA3, dimensionPixelSize, lVarM, rect);
    }

    int b() {
        return this.f12661a.bottom;
    }

    int c() {
        return this.f12661a.top;
    }

    void d(TextView textView) {
        e(textView, null, null);
    }

    void e(TextView textView, ColorStateList colorStateList, ColorStateList colorStateList2) {
        C1115h c1115h = new C1115h();
        C1115h c1115h2 = new C1115h();
        c1115h.setShapeAppearanceModel(this.f12666f);
        c1115h2.setShapeAppearanceModel(this.f12666f);
        if (colorStateList == null) {
            colorStateList = this.f12663c;
        }
        c1115h.g0(colorStateList);
        c1115h.n0(this.f12665e, this.f12664d);
        if (colorStateList2 == null) {
            colorStateList2 = this.f12662b;
        }
        textView.setTextColor(colorStateList2);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f12662b.withAlpha(30), c1115h, c1115h2);
        Rect rect = this.f12661a;
        textView.setBackground(new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
