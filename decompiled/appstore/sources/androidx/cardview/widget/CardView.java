package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.cardview.R$attr;
import androidx.cardview.R$color;
import androidx.cardview.R$style;
import androidx.cardview.R$styleable;

/* JADX INFO: loaded from: classes.dex */
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

    public class a implements CardViewDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Drawable f1165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CardView f1166b;

        public a(CardView r10) {
            this.f1166b = r10;
        }

        @Override // androidx.cardview.widget.CardViewDelegate
        public Drawable getCardBackground() {
            return this.f1165a;
        }

        @Override // androidx.cardview.widget.CardViewDelegate
        public View getCardView() {
            return this.f1166b;
        }

        @Override // androidx.cardview.widget.CardViewDelegate
        public boolean getPreventCornerOverlap() {
            return this.f1166b.getPreventCornerOverlap();
        }

        @Override // androidx.cardview.widget.CardViewDelegate
        public boolean getUseCompatPadding() {
            return this.f1166b.getUseCompatPadding();
        }

        @Override // androidx.cardview.widget.CardViewDelegate
        public void setCardBackground(Drawable r10) {
            this.f1165a = r10;
            this.f1166b.setBackgroundDrawable(r10);
        }

        @Override // androidx.cardview.widget.CardViewDelegate
        public void setMinWidthHeightInternal(int r10, int r11) {
            CardView r12 = this.f1166b;
            if (r10 <= r12.mUserSetMinWidth) goto L5;
            CardView.access$101(r12, r10);
        L5:
            CardView r13 = this.f1166b;
            if (r11 <= r13.mUserSetMinHeight) goto L9;
            CardView.access$201(r13, r11);
            return;
        }

        @Override // androidx.cardview.widget.CardViewDelegate
        public void setShadowPadding(int r10, int r11, int r12, int r13) {
            this.f1166b.mShadowBounds.set(r10, r11, r12, r13);
            CardView r14 = this.f1166b;
            Rect r15 = r14.mContentPadding;
            CardView.access$001(r14, r10 + r15.left, r11 + r15.top, r12 + r15.right, r13 + r15.bottom);
        }
    }

    static {
        COLOR_BACKGROUND_ATTR = new int[]{R.attr.colorBackground};
        androidx.cardview.widget.a r10 = new androidx.cardview.widget.a();
        IMPL = r10;
        r10.initStatic();
    }

    public CardView(@NonNull Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ void access$001(CardView r10, int r11, int r12, int r13, int r14) {
        super.setPadding(r11, r12, r13, r14);
    }

    public static /* synthetic */ void access$101(CardView r10, int r11) {
        super.setMinimumWidth(r11);
    }

    public static /* synthetic */ void access$201(CardView r10, int r11) {
        super.setMinimumHeight(r11);
    }

    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return IMPL.getBackgroundColor(this.mCardViewDelegate);
    }

    public float getCardElevation() {
        return IMPL.getElevation(this.mCardViewDelegate);
    }

    @Px
    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    @Px
    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    @Px
    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    @Px
    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public float getMaxCardElevation() {
        return IMPL.getMaxElevation(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public float getRadius() {
        return IMPL.getRadius(this.mCardViewDelegate);
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        CardViewImpl r12 = IMPL;
        if ((r12 instanceof androidx.cardview.widget.a) == true) goto L15;
        int r13 = View.MeasureSpec.getMode(r10);
        if (r13 == Integer.MIN_VALUE) goto L8;
        if (r13 == 1073741824) goto L8;
    L9:
        int r14 = View.MeasureSpec.getMode(r11);
        if (r14 == Integer.MIN_VALUE) goto L13;
        if (r14 == 1073741824) goto L13;
    L14:
        super.onMeasure(r10, r11);
        return;
    L13:
        r11 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r12.getMinHeight(this.mCardViewDelegate)), View.MeasureSpec.getSize(r11)), r14);
    L8:
        r10 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r12.getMinWidth(this.mCardViewDelegate)), View.MeasureSpec.getSize(r10)), r13);
        goto L9
    L15:
        super.onMeasure(r10, r11);
    }

    public void setCardBackgroundColor(@ColorInt int r10) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, ColorStateList.valueOf(r10));
    }

    public void setCardElevation(float r10) {
        IMPL.setElevation(this.mCardViewDelegate, r10);
    }

    public void setContentPadding(int r10, int r11, int r12, int r13) {
        this.mContentPadding.set(r10, r11, r12, r13);
        IMPL.updatePadding(this.mCardViewDelegate);
    }

    public void setMaxCardElevation(float r10) {
        IMPL.setMaxElevation(this.mCardViewDelegate, r10);
    }

    @Override // android.view.View
    public void setMinimumHeight(int r10) {
        this.mUserSetMinHeight = r10;
        super.setMinimumHeight(r10);
    }

    @Override // android.view.View
    public void setMinimumWidth(int r10) {
        this.mUserSetMinWidth = r10;
        super.setMinimumWidth(r10);
    }

    @Override // android.view.View
    public void setPadding(int r10, int r11, int r12, int r13) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int r10, int r11, int r12, int r13) {
    }

    public void setPreventCornerOverlap(boolean r10) {
        if (r10 == this.mPreventCornerOverlap) goto L6;
        this.mPreventCornerOverlap = r10;
        IMPL.onPreventCornerOverlapChanged(this.mCardViewDelegate);
        return;
    }

    public void setRadius(float r10) {
        IMPL.setRadius(this.mCardViewDelegate, r10);
    }

    public void setUseCompatPadding(boolean r10) {
        if (this.mCompatPadding == r10) goto L6;
        this.mCompatPadding = r10;
        IMPL.onCompatPaddingChanged(this.mCardViewDelegate);
        return;
    }

    public CardView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R$attr.cardViewStyle);
    }

    public void setCardBackgroundColor(@Nullable ColorStateList r10) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, r10);
    }

    public CardView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        Rect r13 = new Rect();
        this.mContentPadding = r13;
        this.mShadowBounds = new Rect();
        a r14 = new a(this);
        this.mCardViewDelegate = r14;
        TypedArray r15 = r10.obtainStyledAttributes(r11, R$styleable.CardView, r12, R$style.CardView);
        int r16 = R$styleable.CardView_cardBackgroundColor;
        if (r15.hasValue(r16) == false) goto L6;
        ColorStateList r17 = r15.getColorStateList(r16);
    L5:
        ColorStateList r18 = r17;
        float r19 = r15.getDimension(R$styleable.CardView_cardCornerRadius, 0.0f);
        float r20 = r15.getDimension(R$styleable.CardView_cardElevation, 0.0f);
        float r110 = r15.getDimension(R$styleable.CardView_cardMaxElevation, 0.0f);
        this.mCompatPadding = r15.getBoolean(R$styleable.CardView_cardUseCompatPadding, false);
        this.mPreventCornerOverlap = r15.getBoolean(R$styleable.CardView_cardPreventCornerOverlap, true);
        int r21 = r15.getDimensionPixelSize(R$styleable.CardView_contentPadding, 0);
        r13.left = r15.getDimensionPixelSize(R$styleable.CardView_contentPaddingLeft, r21);
        r13.top = r15.getDimensionPixelSize(R$styleable.CardView_contentPaddingTop, r21);
        r13.right = r15.getDimensionPixelSize(R$styleable.CardView_contentPaddingRight, r21);
        r13.bottom = r15.getDimensionPixelSize(R$styleable.CardView_contentPaddingBottom, r21);
        if (r20 <= r110) goto L14;
        float r22 = r20;
    L15:
        this.mUserSetMinWidth = r15.getDimensionPixelSize(R$styleable.CardView_android_minWidth, 0);
        this.mUserSetMinHeight = r15.getDimensionPixelSize(R$styleable.CardView_android_minHeight, 0);
        r15.recycle();
        IMPL.initialize(r14, r10, r18, r19, r20, r22);
        return;
    L14:
        r22 = r110;
        goto L15
    L6:
        TypedArray r111 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
        int r23 = r111.getColor(0, 0);
        r111.recycle();
        float[] r112 = new float[3];
        Color.colorToHSV(r23, r112);
        if (r112[2] <= 0.5f) goto L9;
        int r113 = getResources().getColor(R$color.cardview_light_background);
    L10:
        r17 = ColorStateList.valueOf(r113);
        goto L5
    L9:
        r113 = getResources().getColor(R$color.cardview_dark_background);
        goto L10
    }
}
