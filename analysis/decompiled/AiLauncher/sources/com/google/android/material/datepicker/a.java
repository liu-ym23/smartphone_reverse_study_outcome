package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import com.google.android.material.R$styleable;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f20761a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f20762b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorStateList f20763c;

    /* renamed from: d, reason: collision with root package name */
    public final ColorStateList f20764d;

    /* renamed from: e, reason: collision with root package name */
    public final int f20765e;

    /* renamed from: f, reason: collision with root package name */
    public final Z2.l f20766f;

    public a(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i10, Z2.l lVar, Rect rect) {
        B0.h.d(rect.left);
        B0.h.d(rect.top);
        B0.h.d(rect.right);
        B0.h.d(rect.bottom);
        this.f20761a = rect;
        this.f20762b = colorStateList2;
        this.f20763c = colorStateList;
        this.f20764d = colorStateList3;
        this.f20765e = i10;
        this.f20766f = lVar;
    }

    public static a a(Context context, int i10) throws Resources.NotFoundException {
        B0.h.b(i10 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i10, R$styleable.MaterialCalendarItem);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetLeft, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetTop, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetRight, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList colorStateListA = W2.c.a(context, typedArrayObtainStyledAttributes, R$styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList colorStateListA2 = W2.c.a(context, typedArrayObtainStyledAttributes, R$styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList colorStateListA3 = W2.c.a(context, typedArrayObtainStyledAttributes, R$styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        Z2.l lVarM = Z2.l.b(context, typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendarItem_itemShapeAppearance, 0), typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).m();
        typedArrayObtainStyledAttributes.recycle();
        return new a(colorStateListA, colorStateListA2, colorStateListA3, dimensionPixelSize, lVarM, rect);
    }

    public int b() {
        return this.f20761a.bottom;
    }

    public int c() {
        return this.f20761a.top;
    }

    public void d(TextView textView) {
        e(textView, null, null);
    }

    public void e(TextView textView, ColorStateList colorStateList, ColorStateList colorStateList2) {
        Z2.h hVar = new Z2.h();
        Z2.h hVar2 = new Z2.h();
        hVar.setShapeAppearanceModel(this.f20766f);
        hVar2.setShapeAppearanceModel(this.f20766f);
        if (colorStateList == null) {
            colorStateList = this.f20763c;
        }
        hVar.g0(colorStateList);
        hVar.n0(this.f20765e, this.f20764d);
        if (colorStateList2 == null) {
            colorStateList2 = this.f20762b;
        }
        textView.setTextColor(colorStateList2);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f20762b.withAlpha(30), hVar, hVar2);
        Rect rect = this.f20761a;
        textView.setBackground(new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
