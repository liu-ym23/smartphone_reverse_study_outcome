package com.google.android.material.card;

import T2.c;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import c3.AbstractC0873c;
import com.google.android.material.internal.k;
import e3.InterfaceC1407A;
import e3.o;
import e3.p;
import g1.AbstractC1451a;
import i3.a;

/* loaded from: classes3.dex */
public class MaterialCardView extends CardView implements Checkable, InterfaceC1407A {
    public static final int[] e = {R.attr.state_checkable};
    public static final int[] f = {R.attr.state_checked};
    public static final int[] g = {com.stepos.ability.R.attr.state_dragged};

    /* renamed from: a, reason: collision with root package name */
    public final c f2377a;
    public final boolean b;
    public boolean c;
    public boolean d;

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        super(a.a(context, attributeSet, com.stepos.ability.R.attr.materialCardViewStyle, com.stepos.ability.R.style.Widget_MaterialComponents_CardView), attributeSet, com.stepos.ability.R.attr.materialCardViewStyle);
        this.c = false;
        this.d = false;
        this.b = true;
        TypedArray typedArrayD = k.d(getContext(), attributeSet, P2.a.f1078s, com.stepos.ability.R.attr.materialCardViewStyle, com.stepos.ability.R.style.Widget_MaterialComponents_CardView, new int[0]);
        c cVar = new c(this, attributeSet);
        this.f2377a = cVar;
        ColorStateList cardBackgroundColor = super.getCardBackgroundColor();
        e3.k kVar = cVar.c;
        kVar.q(cardBackgroundColor);
        cVar.b.set(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        cVar.l();
        MaterialCardView materialCardView = cVar.f1195a;
        ColorStateList colorStateListA = AbstractC0873c.a(materialCardView.getContext(), typedArrayD, 11);
        cVar.n = colorStateListA;
        if (colorStateListA == null) {
            cVar.n = ColorStateList.valueOf(-1);
        }
        cVar.h = typedArrayD.getDimensionPixelSize(12, 0);
        boolean z10 = typedArrayD.getBoolean(0, false);
        cVar.f1199s = z10;
        materialCardView.setLongClickable(z10);
        cVar.l = AbstractC0873c.a(materialCardView.getContext(), typedArrayD, 6);
        cVar.g(AbstractC0873c.c(materialCardView.getContext(), typedArrayD, 2));
        cVar.f = typedArrayD.getDimensionPixelSize(5, 0);
        cVar.e = typedArrayD.getDimensionPixelSize(4, 0);
        cVar.g = typedArrayD.getInteger(3, 8388661);
        ColorStateList colorStateListA2 = AbstractC0873c.a(materialCardView.getContext(), typedArrayD, 7);
        cVar.k = colorStateListA2;
        if (colorStateListA2 == null) {
            cVar.k = ColorStateList.valueOf(W2.a.a(androidx.appcompat.R.attr.colorControlHighlight, materialCardView));
        }
        ColorStateList colorStateListA3 = AbstractC0873c.a(materialCardView.getContext(), typedArrayD, 1);
        colorStateListA3 = colorStateListA3 == null ? ColorStateList.valueOf(0) : colorStateListA3;
        e3.k kVar2 = cVar.d;
        kVar2.q(colorStateListA3);
        RippleDrawable rippleDrawable = cVar.o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(cVar.k);
        }
        kVar.p(materialCardView.getCardElevation());
        float f7 = cVar.h;
        ColorStateList colorStateList = cVar.n;
        kVar2.b.k = f7;
        kVar2.invalidateSelf();
        kVar2.v(colorStateList);
        materialCardView.setBackgroundInternal(cVar.d(kVar));
        Drawable drawableC = cVar.j() ? cVar.c() : kVar2;
        cVar.i = drawableC;
        materialCardView.setForeground(cVar.d(drawableC));
        typedArrayD.recycle();
    }

    @NonNull
    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f2377a.c.getBounds());
        return rectF;
    }

    public final void a() {
        c cVar = this.f2377a;
        RippleDrawable rippleDrawable = cVar.o;
        if (rippleDrawable != null) {
            Rect bounds = rippleDrawable.getBounds();
            int i = bounds.bottom;
            cVar.o.setBounds(bounds.left, bounds.top, bounds.right, i - 1);
            cVar.o.setBounds(bounds.left, bounds.top, bounds.right, i);
        }
    }

    public final void b(int i, int i6, int i10, int i11) {
        super.setContentPadding(i, i6, i10, i11);
    }

    @Override // androidx.cardview.widget.CardView
    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return this.f2377a.c.b.d;
    }

    @NonNull
    public ColorStateList getCardForegroundColor() {
        return this.f2377a.d.b.d;
    }

    public float getCardViewRadius() {
        return super.getRadius();
    }

    @Nullable
    public Drawable getCheckedIcon() {
        return this.f2377a.f1196j;
    }

    public int getCheckedIconGravity() {
        return this.f2377a.g;
    }

    @Dimension
    public int getCheckedIconMargin() {
        return this.f2377a.e;
    }

    @Dimension
    public int getCheckedIconSize() {
        return this.f2377a.f;
    }

    @Nullable
    public ColorStateList getCheckedIconTint() {
        return this.f2377a.l;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.f2377a.b.bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.f2377a.b.left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.f2377a.b.right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.f2377a.b.top;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getProgress() {
        return this.f2377a.c.b.f4346j;
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.f2377a.c.k();
    }

    public ColorStateList getRippleColor() {
        return this.f2377a.k;
    }

    @NonNull
    public p getShapeAppearanceModel() {
        return this.f2377a.m;
    }

    @ColorInt
    @Deprecated
    public int getStrokeColor() {
        ColorStateList colorStateList = this.f2377a.n;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    @Nullable
    public ColorStateList getStrokeColorStateList() {
        return this.f2377a.n;
    }

    @Dimension
    public int getStrokeWidth() {
        return this.f2377a.h;
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c cVar = this.f2377a;
        cVar.k();
        AbstractC1451a.T(this, cVar.c);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 3);
        c cVar = this.f2377a;
        if (cVar != null && cVar.f1199s) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, e);
        }
        if (this.c) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f);
        }
        if (this.d) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, g);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(this.c);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        c cVar = this.f2377a;
        accessibilityNodeInfo.setCheckable(cVar != null && cVar.f1199s);
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(this.c);
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i6) {
        super.onMeasure(i, i6);
        this.f2377a.e(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.b) {
            c cVar = this.f2377a;
            if (!cVar.f1198r) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                cVar.f1198r = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@ColorInt int i) {
        this.f2377a.c.q(ColorStateList.valueOf(i));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f7) {
        super.setCardElevation(f7);
        c cVar = this.f2377a;
        cVar.c.p(cVar.f1195a.getCardElevation());
    }

    public void setCardForegroundColor(@Nullable ColorStateList colorStateList) {
        e3.k kVar = this.f2377a.d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        kVar.q(colorStateList);
    }

    public void setCheckable(boolean z10) {
        this.f2377a.f1199s = z10;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        if (this.c != z10) {
            toggle();
        }
    }

    public void setCheckedIcon(@Nullable Drawable drawable) {
        this.f2377a.g(drawable);
    }

    public void setCheckedIconGravity(int i) {
        c cVar = this.f2377a;
        if (cVar.g != i) {
            cVar.g = i;
            MaterialCardView materialCardView = cVar.f1195a;
            cVar.e(materialCardView.getMeasuredWidth(), materialCardView.getMeasuredHeight());
        }
    }

    public void setCheckedIconMargin(@Dimension int i) {
        this.f2377a.e = i;
    }

    public void setCheckedIconMarginResource(@DimenRes int i) {
        if (i != -1) {
            this.f2377a.e = getResources().getDimensionPixelSize(i);
        }
    }

    public void setCheckedIconResource(@DrawableRes int i) {
        this.f2377a.g(AppCompatResources.getDrawable(getContext(), i));
    }

    public void setCheckedIconSize(@Dimension int i) {
        this.f2377a.f = i;
    }

    public void setCheckedIconSizeResource(@DimenRes int i) {
        if (i != 0) {
            this.f2377a.f = getResources().getDimensionPixelSize(i);
        }
    }

    public void setCheckedIconTint(@Nullable ColorStateList colorStateList) {
        c cVar = this.f2377a;
        cVar.l = colorStateList;
        Drawable drawable = cVar.f1196j;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
    }

    @Override // android.view.View
    public void setClickable(boolean z10) {
        super.setClickable(z10);
        c cVar = this.f2377a;
        if (cVar != null) {
            cVar.k();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public final void setContentPadding(int i, int i6, int i10, int i11) {
        c cVar = this.f2377a;
        cVar.b.set(i, i6, i10, i11);
        cVar.l();
    }

    public void setDragged(boolean z10) {
        if (this.d != z10) {
            this.d = z10;
            refreshDrawableState();
            a();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f7) {
        super.setMaxCardElevation(f7);
        this.f2377a.m();
    }

    public void setOnCheckedChangeListener(@Nullable T2.a aVar) {
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z10) {
        super.setPreventCornerOverlap(z10);
        c cVar = this.f2377a;
        cVar.m();
        cVar.l();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f7) {
        c cVar = this.f2377a;
        cVar.c.r(f7);
        e3.k kVar = cVar.d;
        if (kVar != null) {
            kVar.r(f7);
        }
        e3.k kVar2 = cVar.f1197q;
        if (kVar2 != null) {
            kVar2.r(f7);
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f7) {
        super.setRadius(f7);
        c cVar = this.f2377a;
        o oVarF = cVar.m.f();
        oVarF.c(f7);
        cVar.h(oVarF.a());
        cVar.i.invalidateSelf();
        if (cVar.i() || (cVar.f1195a.getPreventCornerOverlap() && !cVar.c.n())) {
            cVar.l();
        }
        if (cVar.i()) {
            cVar.m();
        }
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        c cVar = this.f2377a;
        cVar.k = colorStateList;
        RippleDrawable rippleDrawable = cVar.o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(colorStateList);
        }
    }

    public void setRippleColorResource(@ColorRes int i) {
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), i);
        c cVar = this.f2377a;
        cVar.k = colorStateList;
        RippleDrawable rippleDrawable = cVar.o;
        if (rippleDrawable != null) {
            rippleDrawable.setColor(colorStateList);
        }
    }

    @Override // e3.InterfaceC1407A
    public void setShapeAppearanceModel(@NonNull p pVar) {
        setClipToOutline(pVar.e(getBoundsAsRectF()));
        this.f2377a.h(pVar);
    }

    public void setStrokeColor(@ColorInt int i) {
        setStrokeColor(ColorStateList.valueOf(i));
    }

    public void setStrokeWidth(@Dimension int i) {
        c cVar = this.f2377a;
        if (i != cVar.h) {
            cVar.h = i;
            e3.k kVar = cVar.d;
            ColorStateList colorStateList = cVar.n;
            kVar.b.k = i;
            kVar.invalidateSelf();
            kVar.v(colorStateList);
        }
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z10) {
        super.setUseCompatPadding(z10);
        c cVar = this.f2377a;
        cVar.m();
        cVar.l();
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        c cVar = this.f2377a;
        if (cVar != null && cVar.f1199s && isEnabled()) {
            this.c = !this.c;
            refreshDrawableState();
            a();
            cVar.f(this.c, true);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        c cVar = this.f2377a;
        if (cVar.n != colorStateList) {
            cVar.n = colorStateList;
            e3.k kVar = cVar.d;
            kVar.b.k = cVar.h;
            kVar.invalidateSelf();
            kVar.v(colorStateList);
        }
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        this.f2377a.c.q(colorStateList);
    }
}
