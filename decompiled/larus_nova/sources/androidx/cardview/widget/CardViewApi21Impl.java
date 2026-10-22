package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
class CardViewApi21Impl implements CardViewImpl {
    public CardViewApi21Impl() {
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void initStatic() {
    }

    private RoundRectDrawable getCardBackground(CardViewDelegate r100) {
        return (RoundRectDrawable) r100.getCardBackground();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public ColorStateList getBackgroundColor(CardViewDelegate r100) {
        return getCardBackground(r100).getColor();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getElevation(CardViewDelegate r100) {
        return r100.getCardView().getElevation();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMaxElevation(CardViewDelegate r100) {
        return getCardBackground(r100).getPadding();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinHeight(CardViewDelegate r100) {
        return getRadius(r100) * 2.0f;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinWidth(CardViewDelegate r100) {
        return getRadius(r100) * 2.0f;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getRadius(CardViewDelegate r100) {
        return getCardBackground(r100).getRadius();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onCompatPaddingChanged(CardViewDelegate r100) {
        setMaxElevation(r100, getMaxElevation(r100));
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onPreventCornerOverlapChanged(CardViewDelegate r100) {
        setMaxElevation(r100, getMaxElevation(r100));
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void updatePadding(CardViewDelegate r100) {
        if (r100.getUseCompatPadding() == true) goto L6;
        r100.setShadowPadding(0, 0, 0, 0);
        return;
    L6:
        float r101 = getMaxElevation(r100);
        float r102 = getRadius(r100);
        int r103 = (int) Math.ceil(RoundRectDrawableWithShadow.calculateHorizontalPadding(r101, r102, r100.getPreventCornerOverlap()));
        int r104 = (int) Math.ceil(RoundRectDrawableWithShadow.calculateVerticalPadding(r101, r102, r100.getPreventCornerOverlap()));
        r100.setShadowPadding(r103, r104, r103, r104);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setBackgroundColor(CardViewDelegate r100, ColorStateList r101) {
        getCardBackground(r100).setColor(r101);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setElevation(CardViewDelegate r100, float r101) {
        r100.getCardView().setElevation(r101);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setMaxElevation(CardViewDelegate r100, float r101) {
        getCardBackground(r100).setPadding(r101, r100.getUseCompatPadding(), r100.getPreventCornerOverlap());
        updatePadding(r100);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setRadius(CardViewDelegate r100, float r101) {
        getCardBackground(r100).setRadius(r101);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void initialize(CardViewDelegate r100, Context r101, ColorStateList r102, float r103, float r104, float r105) {
        r100.setCardBackground(new RoundRectDrawable(r102, r103));
        View r106 = r100.getCardView();
        r106.setClipToOutline(true);
        r106.setElevation(r104);
        setMaxElevation(r100, r105);
    }
}
