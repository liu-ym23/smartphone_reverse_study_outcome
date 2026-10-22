package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.core.util.e;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: loaded from: classes3.dex */
final class CalendarItemStyle {
    private final ColorStateList backgroundColor;

    @NonNull
    private final Rect insets;
    private final ShapeAppearanceModel itemShape;
    private final ColorStateList strokeColor;
    private final int strokeWidth;
    private final ColorStateList textColor;

    private CalendarItemStyle(ColorStateList r10, ColorStateList r11, ColorStateList r12, int r13, ShapeAppearanceModel r14, @NonNull Rect r15) {
        e.d(r15.left);
        e.d(r15.top);
        e.d(r15.right);
        e.d(r15.bottom);
        this.insets = r15;
        this.textColor = r11;
        this.backgroundColor = r10;
        this.strokeColor = r12;
        this.strokeWidth = r13;
        this.itemShape = r14;
    }

    @NonNull
    public static CalendarItemStyle create(@NonNull Context r12, @StyleRes int r13) {
        if (r13 == 0) goto L5;
        boolean r10 = true;
    L6:
        e.b(r10, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray r14 = r12.obtainStyledAttributes(r13, R.styleable.MaterialCalendarItem);
        Rect r11 = new Rect(r14.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetLeft, 0), r14.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetTop, 0), r14.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetRight, 0), r14.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList r15 = MaterialResources.getColorStateList(r12, r14, R.styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList r16 = MaterialResources.getColorStateList(r12, r14, R.styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList r17 = MaterialResources.getColorStateList(r12, r14, R.styleable.MaterialCalendarItem_itemStrokeColor);
        int r18 = r14.getDimensionPixelSize(R.styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        ShapeAppearanceModel r19 = ShapeAppearanceModel.builder(r12, r14.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearance, 0), r14.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).build();
        r14.recycle();
        return new CalendarItemStyle(r15, r16, r17, r18, r19, r11);
    L5:
        r10 = false;
        goto L6
    }

    public int getBottomInset() {
        return this.insets.bottom;
    }

    public int getLeftInset() {
        return this.insets.left;
    }

    public int getRightInset() {
        return this.insets.right;
    }

    public int getTopInset() {
        return this.insets.top;
    }

    public void styleItem(@NonNull TextView r10) {
        MaterialShapeDrawable r11 = new MaterialShapeDrawable();
        MaterialShapeDrawable r12 = new MaterialShapeDrawable();
        r11.setShapeAppearanceModel(this.itemShape);
        r12.setShapeAppearanceModel(this.itemShape);
        r11.setFillColor(this.backgroundColor);
        r11.setStroke(this.strokeWidth, this.strokeColor);
        r10.setTextColor(this.textColor);
        RippleDrawable r13 = new RippleDrawable(this.textColor.withAlpha(30), r11, r12);
        Rect r14 = this.insets;
        ViewCompat.t0(r10, new InsetDrawable(r13, r14.left, r14.top, r14.right, r14.bottom));
    }
}
