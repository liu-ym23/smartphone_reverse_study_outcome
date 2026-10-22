package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.m;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CalendarItemStyle.java */
/* JADX INFO: loaded from: classes2.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f13354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorStateList f13355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ColorStateList f13356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ColorStateList f13357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f13358e;
    private final m f;

    private a(ColorStateList r2, ColorStateList r3, ColorStateList r4, int r5, m r6, Rect r7) {
        androidx.core.util.g.a(r7.left);
        androidx.core.util.g.a(r7.top);
        androidx.core.util.g.a(r7.right);
        androidx.core.util.g.a(r7.bottom);
        this.f13354a = r7;
        this.f13355b = r3;
        this.f13356c = r2;
        this.f13357d = r4;
        this.f13358e = r5;
        this.f = r6;
    }

    static a a(Context r13, int r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        if (r14 == 0) goto L5;
        boolean r1 = true;
    L6:
        androidx.core.util.g.a(r1, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray r16 = r15.obtainStyledAttributes(r14, R.styleable.MaterialCalendarItem);
        Rect r12 = new Rect(r16.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendarItem_android_insetLeft, "styleable", "MaterialCalendarItem_android_insetLeft"), 0), r16.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendarItem_android_insetTop, "styleable", "MaterialCalendarItem_android_insetTop"), 0), r16.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendarItem_android_insetRight, "styleable", "MaterialCalendarItem_android_insetRight"), 0), r16.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendarItem_android_insetBottom, "styleable", "MaterialCalendarItem_android_insetBottom"), 0));
        ColorStateList r7 = com.google.android.material.g.c.a(r15, r16, ZeusTransformUtils.mapRes(R.styleable.MaterialCalendarItem_itemFillColor, "styleable", "MaterialCalendarItem_itemFillColor"));
        ColorStateList r8 = com.google.android.material.g.c.a(r15, r16, ZeusTransformUtils.mapRes(R.styleable.MaterialCalendarItem_itemTextColor, "styleable", "MaterialCalendarItem_itemTextColor"));
        ColorStateList r9 = com.google.android.material.g.c.a(r15, r16, ZeusTransformUtils.mapRes(R.styleable.MaterialCalendarItem_itemStrokeColor, "styleable", "MaterialCalendarItem_itemStrokeColor"));
        int r10 = r16.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendarItem_itemStrokeWidth, "styleable", "MaterialCalendarItem_itemStrokeWidth"), 0);
        m r11 = m.a(r15, r16.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendarItem_itemShapeAppearance, "styleable", "MaterialCalendarItem_itemShapeAppearance"), 0), r16.getResourceId(ZeusTransformUtils.mapRes(R.styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, "styleable", "MaterialCalendarItem_itemShapeAppearanceOverlay"), 0)).a();
        r16.recycle();
        return new a(r7, r8, r9, r10, r11, r12);
    L5:
        r1 = false;
        goto L6
    }

    void a(TextView r11) {
        MaterialShapeDrawable r0 = new MaterialShapeDrawable();
        MaterialShapeDrawable r1 = new MaterialShapeDrawable();
        r0.setShapeAppearanceModel(this.f);
        r1.setShapeAppearanceModel(this.f);
        r0.setFillColor(this.f13356c);
        r0.setStroke(this.f13358e, this.f13357d);
        r11.setTextColor(this.f13355b);
        if (Build.VERSION.SDK_INT < 21) goto L5;
        Drawable r5 = new RippleDrawable(this.f13355b.withAlpha(30), r0, r1);
    L6:
        ViewCompat.a(r11, new InsetDrawable(r5, this.f13354a.left, this.f13354a.top, this.f13354a.right, this.f13354a.bottom));
        return;
    L5:
        r5 = r0;
        goto L6
    }

    int a() {
        return this.f13354a.top;
    }

    int b() {
        return this.f13354a.bottom;
    }
}
