package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class DayViewDecorator implements Parcelable {
    public ColorStateList getBackgroundColor(Context context, int i10, int i11, int i12, boolean z, boolean z3) {
        return null;
    }

    public Drawable getCompoundDrawableBottom(Context context, int i10, int i11, int i12, boolean z, boolean z3) {
        return null;
    }

    public Drawable getCompoundDrawableLeft(Context context, int i10, int i11, int i12, boolean z, boolean z3) {
        return null;
    }

    public Drawable getCompoundDrawableRight(Context context, int i10, int i11, int i12, boolean z, boolean z3) {
        return null;
    }

    public Drawable getCompoundDrawableTop(Context context, int i10, int i11, int i12, boolean z, boolean z3) {
        return null;
    }

    public ColorStateList getTextColor(Context context, int i10, int i11, int i12, boolean z, boolean z3) {
        return null;
    }

    public void initialize(Context context) {
    }

    public CharSequence getContentDescription(Context context, int i10, int i11, int i12, boolean z, boolean z3, CharSequence charSequence) {
        return charSequence;
    }
}
