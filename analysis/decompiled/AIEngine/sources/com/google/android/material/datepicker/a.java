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
import mb.y;
import y4.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f4939a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f4940b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorStateList f4941c;

    /* renamed from: d, reason: collision with root package name */
    public final ColorStateList f4942d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4943e;

    /* renamed from: f, reason: collision with root package name */
    public final y4.j f4944f;

    public a(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i10, y4.j jVar, Rect rect) {
        y.m(rect.left);
        y.m(rect.top);
        y.m(rect.right);
        y.m(rect.bottom);
        this.f4939a = rect;
        this.f4940b = colorStateList2;
        this.f4941c = colorStateList;
        this.f4942d = colorStateList3;
        this.f4943e = i10;
        this.f4944f = jVar;
    }

    public static a a(int i10, Context context) throws Resources.NotFoundException {
        y.l("Cannot create a CalendarItemStyle with a styleResId of 0", i10 != 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i10, k4.a.r);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0));
        ColorStateList colorStateListA = w4.c.a(context, typedArrayObtainStyledAttributes, 4);
        ColorStateList colorStateListA2 = w4.c.a(context, typedArrayObtainStyledAttributes, 9);
        ColorStateList colorStateListA3 = w4.c.a(context, typedArrayObtainStyledAttributes, 7);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        y4.j jVarA = y4.j.a(context, typedArrayObtainStyledAttributes.getResourceId(5, 0), typedArrayObtainStyledAttributes.getResourceId(6, 0), new y4.a(0)).a();
        typedArrayObtainStyledAttributes.recycle();
        return new a(colorStateListA, colorStateListA2, colorStateListA3, dimensionPixelSize, jVarA, rect);
    }

    public final void b(TextView textView, ColorStateList colorStateList, ColorStateList colorStateList2) {
        y4.g gVar = new y4.g();
        y4.g gVar2 = new y4.g();
        y4.j jVar = this.f4944f;
        gVar.setShapeAppearanceModel(jVar);
        gVar2.setShapeAppearanceModel(jVar);
        if (colorStateList == null) {
            colorStateList = this.f4941c;
        }
        gVar.n(colorStateList);
        gVar.f14023b.f14053k = this.f4943e;
        gVar.invalidateSelf();
        g.c cVar = gVar.f14023b;
        ColorStateList colorStateList3 = cVar.f14048e;
        ColorStateList colorStateList4 = this.f4942d;
        if (colorStateList3 != colorStateList4) {
            cVar.f14048e = colorStateList4;
            gVar.onStateChange(gVar.getState());
        }
        ColorStateList colorStateList5 = this.f4940b;
        if (colorStateList2 == null) {
            colorStateList2 = colorStateList5;
        }
        textView.setTextColor(colorStateList2);
        RippleDrawable rippleDrawable = new RippleDrawable(colorStateList5.withAlpha(30), gVar, gVar2);
        Rect rect = this.f4939a;
        textView.setBackground(new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
