package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes2.dex */
class CardViewBaseImpl implements CardViewImpl {
    final RectF mCornerRect;

    @Override // androidx.cardview.widget.CardViewImpl
    public void onCompatPaddingChanged(CardViewDelegate r100) {
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void initStatic() {
        RoundRectDrawableWithShadow.sRoundRectHelper = new AnonymousClass1(this);
    }

    public CardViewBaseImpl() {
        this.mCornerRect = new RectF();
    }

    private RoundRectDrawableWithShadow getShadowBackground(CardViewDelegate r100) {
        return (RoundRectDrawableWithShadow) r100.getCardBackground();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public ColorStateList getBackgroundColor(CardViewDelegate r100) {
        return getShadowBackground(r100).getColor();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getElevation(CardViewDelegate r100) {
        return getShadowBackground(r100).getShadowSize();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMaxElevation(CardViewDelegate r100) {
        return getShadowBackground(r100).getMaxShadowSize();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinHeight(CardViewDelegate r100) {
        return getShadowBackground(r100).getMinHeight();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinWidth(CardViewDelegate r100) {
        return getShadowBackground(r100).getMinWidth();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getRadius(CardViewDelegate r100) {
        return getShadowBackground(r100).getCornerRadius();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onPreventCornerOverlapChanged(CardViewDelegate r100) {
        getShadowBackground(r100).setAddPaddingForCorners(r100.getPreventCornerOverlap());
        updatePadding(r100);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void updatePadding(CardViewDelegate r100) {
        Rect r101 = new Rect();
        getShadowBackground(r100).getMaxShadowAndCornerPadding(r101);
        r100.setMinWidthHeightInternal((int) Math.ceil(getMinWidth(r100)), (int) Math.ceil(getMinHeight(r100)));
        r100.setShadowPadding(r101.left, r101.top, r101.right, r101.bottom);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setBackgroundColor(CardViewDelegate r100, ColorStateList r101) {
        getShadowBackground(r100).setColor(r101);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setElevation(CardViewDelegate r100, float r101) {
        getShadowBackground(r100).setShadowSize(r101);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setMaxElevation(CardViewDelegate r100, float r101) {
        getShadowBackground(r100).setMaxShadowSize(r101);
        updatePadding(r100);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setRadius(CardViewDelegate r100, float r101) {
        getShadowBackground(r100).setCornerRadius(r101);
        updatePadding(r100);
    }

    private RoundRectDrawableWithShadow createBackground(Context r100, ColorStateList r101, float r110, float r111, float r112) {
        return new RoundRectDrawableWithShadow(r100.getResources(), r101, r110, r111, r112);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void initialize(CardViewDelegate r100, Context r101, ColorStateList r102, float r110, float r111, float r112) {
        RoundRectDrawableWithShadow r103 = createBackground(r101, r102, r110, r111, r112);
        r103.setAddPaddingForCorners(r100.getPreventCornerOverlap());
        r100.setCardBackground(r103);
        updatePadding(r100);
    }
}
