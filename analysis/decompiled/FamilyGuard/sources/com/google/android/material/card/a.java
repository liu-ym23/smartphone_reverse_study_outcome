package com.google.android.material.card;

import a1.C0409b;
import a1.C0417j;
import android.R;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import h.C0744a;
import p.C0905a;
import t1.l;
import t1.o;

/* loaded from: classes.dex */
public class a extends C0905a implements Checkable, o {

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f12468k = {R.attr.state_checkable};

    /* renamed from: l, reason: collision with root package name */
    private static final int[] f12469l = {R.attr.state_checked};

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f12470m = {C0409b.f6706P};

    /* renamed from: n, reason: collision with root package name */
    private static final int f12471n = C0417j.f6924o;

    /* renamed from: h, reason: collision with root package name */
    private boolean f12472h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f12473i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f12474j;

    /* renamed from: com.google.android.material.card.a$a, reason: collision with other inner class name */
    public interface InterfaceC0160a {
    }

    private void d() {
        throw null;
    }

    private RectF getBoundsAsRectF() {
        new RectF();
        throw null;
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        return this.f12474j;
    }

    @Override // p.C0905a
    public ColorStateList getCardBackgroundColor() {
        throw null;
    }

    public ColorStateList getCardForegroundColor() {
        throw null;
    }

    float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        throw null;
    }

    public int getCheckedIconGravity() {
        throw null;
    }

    public int getCheckedIconMargin() {
        throw null;
    }

    public int getCheckedIconSize() {
        throw null;
    }

    public ColorStateList getCheckedIconTint() {
        throw null;
    }

    @Override // p.C0905a
    public int getContentPaddingBottom() {
        throw null;
    }

    @Override // p.C0905a
    public int getContentPaddingLeft() {
        throw null;
    }

    @Override // p.C0905a
    public int getContentPaddingRight() {
        throw null;
    }

    @Override // p.C0905a
    public int getContentPaddingTop() {
        throw null;
    }

    public float getProgress() {
        throw null;
    }

    @Override // p.C0905a
    public float getRadius() {
        throw null;
    }

    public ColorStateList getRippleColor() {
        throw null;
    }

    public l getShapeAppearanceModel() {
        throw null;
    }

    @Deprecated
    public int getStrokeColor() {
        throw null;
    }

    public ColorStateList getStrokeColorStateList() {
        throw null;
    }

    public int getStrokeWidth() {
        throw null;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f12473i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i5) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i5 + 3);
        if (e()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f12468k);
        }
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f12469l);
        }
        if (f()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f12470m);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(e());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // p.C0905a, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        getMeasuredWidth();
        getMeasuredHeight();
        throw null;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f12472h) {
            throw null;
        }
    }

    void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // p.C0905a
    public void setCardBackgroundColor(int i5) {
        ColorStateList.valueOf(i5);
        throw null;
    }

    @Override // p.C0905a
    public void setCardElevation(float f5) {
        super.setCardElevation(f5);
        throw null;
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setCheckable(boolean z5) {
        throw null;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z5) {
        if (this.f12473i != z5) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        throw null;
    }

    public void setCheckedIconGravity(int i5) {
        throw null;
    }

    public void setCheckedIconMargin(int i5) {
        throw null;
    }

    public void setCheckedIconMarginResource(int i5) throws Resources.NotFoundException {
        if (i5 == -1) {
            return;
        }
        getResources().getDimensionPixelSize(i5);
        throw null;
    }

    public void setCheckedIconResource(int i5) {
        C0744a.b(getContext(), i5);
        throw null;
    }

    public void setCheckedIconSize(int i5) {
        throw null;
    }

    public void setCheckedIconSizeResource(int i5) throws Resources.NotFoundException {
        if (i5 == 0) {
            return;
        }
        getResources().getDimensionPixelSize(i5);
        throw null;
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        throw null;
    }

    @Override // android.view.View
    public void setClickable(boolean z5) {
        super.setClickable(z5);
    }

    public void setDragged(boolean z5) {
        if (this.f12474j != z5) {
            this.f12474j = z5;
            refreshDrawableState();
            d();
            invalidate();
        }
    }

    @Override // p.C0905a
    public void setMaxCardElevation(float f5) {
        super.setMaxCardElevation(f5);
        throw null;
    }

    public void setOnCheckedChangeListener(InterfaceC0160a interfaceC0160a) {
    }

    @Override // p.C0905a
    public void setPreventCornerOverlap(boolean z5) {
        super.setPreventCornerOverlap(z5);
        throw null;
    }

    public void setProgress(float f5) {
        throw null;
    }

    @Override // p.C0905a
    public void setRadius(float f5) {
        super.setRadius(f5);
        throw null;
    }

    public void setRippleColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setRippleColorResource(int i5) {
        C0744a.a(getContext(), i5);
        throw null;
    }

    @Override // t1.o
    public void setShapeAppearanceModel(l lVar) {
        setClipToOutline(lVar.v(getBoundsAsRectF()));
        throw null;
    }

    public void setStrokeColor(int i5) {
        setStrokeColor(ColorStateList.valueOf(i5));
    }

    public void setStrokeWidth(int i5) {
        throw null;
    }

    @Override // p.C0905a
    public void setUseCompatPadding(boolean z5) {
        super.setUseCompatPadding(z5);
        throw null;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (e() && isEnabled()) {
            this.f12473i = !this.f12473i;
            refreshDrawableState();
            d();
            throw null;
        }
    }

    @Override // p.C0905a
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        throw null;
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        throw null;
    }
}
