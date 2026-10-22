package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public class CardView extends FrameLayout {
    private static final int[] COLOR_BACKGROUND_ATTR = null;
    private static final CardViewImpl IMPL = null;
    private final CardViewDelegate mCardViewDelegate;
    private boolean mCompatPadding;
    final Rect mContentPadding;
    private boolean mPreventCornerOverlap;
    final Rect mShadowBounds;
    int mUserSetMinHeight;
    int mUserSetMinWidth;

    static {
        COLOR_BACKGROUND_ATTR = new int[]{R.attr.colorBackground};
        CardViewApi21Impl r100 = new CardViewApi21Impl();
        IMPL = r100;
        r100.initStatic();
    }

    @Override // android.view.View
    public void setPadding(int r100, int r101, int r102, int r103) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int r100, int r101, int r102, int r103) {
    }

    public ColorStateList getCardBackgroundColor() {
        return IMPL.getBackgroundColor(this.mCardViewDelegate);
    }

    public float getCardElevation() {
        return IMPL.getElevation(this.mCardViewDelegate);
    }

    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public float getMaxCardElevation() {
        return IMPL.getMaxElevation(this.mCardViewDelegate);
    }

    public float getRadius() {
        return IMPL.getRadius(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    public CardView(Context r100) {
        this(r100, null);
    }

    public void setCardBackgroundColor(int r100) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, ColorStateList.valueOf(r100));
    }

    public void setCardElevation(float r100) {
        IMPL.setElevation(this.mCardViewDelegate, r100);
    }

    public void setMaxCardElevation(float r100) {
        IMPL.setMaxElevation(this.mCardViewDelegate, r100);
    }

    @Override // android.view.View
    public void setMinimumHeight(int r100) {
        this.mUserSetMinHeight = r100;
        super.setMinimumHeight(r100);
    }

    @Override // android.view.View
    public void setMinimumWidth(int r100) {
        this.mUserSetMinWidth = r100;
        super.setMinimumWidth(r100);
    }

    public void setPreventCornerOverlap(boolean r100) {
        if (r100 == this.mPreventCornerOverlap) goto L6;
        this.mPreventCornerOverlap = r100;
        IMPL.onPreventCornerOverlapChanged(this.mCardViewDelegate);
        return;
    }

    public void setRadius(float r100) {
        IMPL.setRadius(this.mCardViewDelegate, r100);
    }

    public void setUseCompatPadding(boolean r100) {
        if (this.mCompatPadding == r100) goto L6;
        this.mCompatPadding = r100;
        IMPL.onCompatPaddingChanged(this.mCardViewDelegate);
        return;
    }

    public void setCardBackgroundColor(ColorStateList r100) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, r100);
    }

    public CardView(Context r100, AttributeSet r101) {
        this(r100, r101, com.larus.nova.R.attr.cardViewStyle);
    }

    public static /* synthetic */ void access$101(CardView r100, int r101) {
        super.setMinimumWidth(r101);
    }

    public static /* synthetic */ void access$201(CardView r100, int r101) {
        super.setMinimumHeight(r101);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        CardViewImpl r102 = IMPL;
        if ((r102 instanceof CardViewApi21Impl) == true) goto L15;
        int r103 = View.MeasureSpec.getMode(r100);
        if (r103 == Integer.MIN_VALUE) goto L8;
        if (r103 == 1073741824) goto L8;
    L9:
        int r104 = View.MeasureSpec.getMode(r101);
        if (r104 == Integer.MIN_VALUE) goto L13;
        if (r104 == 1073741824) goto L13;
    L14:
        super.onMeasure(r100, r101);
        return;
    L13:
        r101 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r102.getMinHeight(this.mCardViewDelegate)), View.MeasureSpec.getSize(r101)), r104);
    L8:
        r100 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r102.getMinWidth(this.mCardViewDelegate)), View.MeasureSpec.getSize(r100)), r103);
        goto L9
    L15:
        super.onMeasure(r100, r101);
    }

    public CardView(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        Rect r100 = new Rect();
        this.mContentPadding = r100;
        this.mShadowBounds = new Rect();
        CardViewDelegate r101 = new AnonymousClass1(this);
        this.mCardViewDelegate = r101;
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{R.attr.minWidth, R.attr.minHeight, com.larus.nova.R.attr.cardBackgroundColor, com.larus.nova.R.attr.cardCornerRadius, com.larus.nova.R.attr.cardElevation, com.larus.nova.R.attr.cardMaxElevation, com.larus.nova.R.attr.cardPreventCornerOverlap, com.larus.nova.R.attr.cardUseCompatPadding, com.larus.nova.R.attr.contentPadding, com.larus.nova.R.attr.contentPaddingBottom, com.larus.nova.R.attr.contentPaddingLeft, com.larus.nova.R.attr.contentPaddingRight, com.larus.nova.R.attr.contentPaddingTop}, r112, com.larus.nova.R.style.CardView);
        if (r113.hasValue(2) == false) goto L6;
        ColorStateList r114 = r113.getColorStateList(2);
    L5:
        ColorStateList r102 = r114;
        float r103 = r113.getDimension(3, 0.0f);
        float r104 = r113.getDimension(4, 0.0f);
        float r115 = r113.getDimension(5, 0.0f);
        this.mCompatPadding = r113.getBoolean(7, false);
        this.mPreventCornerOverlap = r113.getBoolean(6, true);
        int r105 = r113.getDimensionPixelSize(8, 0);
        r100.left = r113.getDimensionPixelSize(10, r105);
        r100.top = r113.getDimensionPixelSize(12, r105);
        r100.right = r113.getDimensionPixelSize(11, r105);
        r100.bottom = r113.getDimensionPixelSize(9, r105);
        if (r104 <= r115) goto L14;
        float r106 = r104;
    L15:
        this.mUserSetMinWidth = r113.getDimensionPixelSize(0, 0);
        this.mUserSetMinHeight = r113.getDimensionPixelSize(1, 0);
        r113.recycle();
        IMPL.initialize(r101, r110, r102, r103, r104, r106);
        return;
    L14:
        r106 = r115;
        goto L15
    L6:
        TypedArray r107 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
        int r108 = r107.getColor(0, 0);
        r107.recycle();
        float[] r109 = new float[3];
        Color.colorToHSV(r108, r109);
        if (r109[2] <= 0.5f) goto L9;
        int r116 = getResources().getColor(com.larus.nova.R.color.cardview_light_background);
    L10:
        r114 = ColorStateList.valueOf(r116);
        goto L5
    L9:
        r116 = getResources().getColor(com.larus.nova.R.color.cardview_dark_background);
        goto L10
    }

    public void setContentPadding(int r100, int r101, int r102, int r103) {
        this.mContentPadding.set(r100, r101, r102, r103);
        IMPL.updatePadding(this.mCardViewDelegate);
    }

    public static /* synthetic */ void access$001(CardView r100, int r101, int r102, int r103, int r104) {
        super.setPadding(r101, r102, r103, r104);
    }
}
