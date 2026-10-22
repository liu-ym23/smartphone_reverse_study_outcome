package com.google.android.material.checkbox;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

/* loaded from: classes3.dex */
public final class a extends Animatable2Compat.AnimationCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f2379a;

    public a(c cVar) {
        this.f2379a = cVar;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
    public final void onAnimationEnd(Drawable drawable) {
        super.onAnimationEnd(drawable);
        ColorStateList colorStateList = this.f2379a.k;
        if (colorStateList != null) {
            drawable.setTintList(colorStateList);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
    public final void onAnimationStart(Drawable drawable) {
        super.onAnimationStart(drawable);
        c cVar = this.f2379a;
        ColorStateList colorStateList = cVar.k;
        if (colorStateList != null) {
            drawable.setTint(colorStateList.getColorForState(cVar.o, colorStateList.getDefaultColor()));
        }
    }
}
