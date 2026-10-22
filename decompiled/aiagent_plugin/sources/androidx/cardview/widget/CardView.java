package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class CardView extends FrameLayout {
    private static final int[] COLOR_BACKGROUND_ATTR = null;
    private static final e IMPL = null;
    private final d mCardViewDelegate;
    private boolean mCompatPadding;
    final Rect mContentPadding;
    private boolean mPreventCornerOverlap;
    final Rect mShadowBounds;
    int mUserSetMinHeight;
    int mUserSetMinWidth;

    @Override // android.view.View
    public void setPadding(int r1, int r2, int r3, int r4) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int r1, int r2, int r3, int r4) {
    }

    static /* synthetic */ void access$001(CardView r0, int r1, int r2, int r3, int r4) {
        super.setPadding(r1, r2, r3, r4);
    }

    static /* synthetic */ void access$101(CardView r0, int r1) {
        super.setMinimumWidth(r1);
    }

    static /* synthetic */ void access$201(CardView r0, int r1) {
        super.setMinimumHeight(r1);
    }

    static {
        COLOR_BACKGROUND_ATTR = new int[]{R.attr.colorBackground};
        if (Build.VERSION.SDK_INT < 21) goto L6;
        IMPL = new b();
    L9:
        IMPL.a();
        return;
    L6:
        if (Build.VERSION.SDK_INT < 17) goto L8;
        IMPL = new a();
        goto L9
    L8:
        IMPL = new c();
        goto L9
    }

    public CardView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public CardView(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.attr.cardViewStyle, "attr", "cardViewStyle"));
    }

    public CardView(Context r11, AttributeSet r12, int r13) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r4, r14, r13);
        Rect r15 = new Rect();
        this.mContentPadding = r15;
        this.mShadowBounds = new Rect();
        d r3 = new AnonymousClass1(this);
        this.mCardViewDelegate = r3;
        TypedArray r16 = r4.obtainStyledAttributes(r14, com.obric.aiagent.plugin.R.styleable.CardView, r13, ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.style.CardView, "style", "CardView"));
        if (r16.hasValue(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.CardView_cardBackgroundColor, "styleable", "CardView_cardBackgroundColor")) == false) goto L5;
        ColorStateList r17 = r16.getColorStateList(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.CardView_cardBackgroundColor, "styleable", "CardView_cardBackgroundColor"));
    L10:
        float r6 = r16.getDimension(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.CardView_cardCornerRadius, "styleable", "CardView_cardCornerRadius"), 0.0f);
        float r7 = r16.getDimension(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.CardView_cardElevation, "styleable", "CardView_cardElevation"), 0.0f);
        float r1 = r16.getDimension(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.CardView_cardMaxElevation, "styleable", "CardView_cardMaxElevation"), 0.0f);
        this.mCompatPadding = r16.getBoolean(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.CardView_cardUseCompatPadding, "styleable", "CardView_cardUseCompatPadding"), false);
        this.mPreventCornerOverlap = r16.getBoolean(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.CardView_cardPreventCornerOverlap, "styleable", "CardView_cardPreventCornerOverlap"), true);
        int r2 = r16.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.CardView_contentPadding, "styleable", "CardView_contentPadding"), 0);
        r15.left = r16.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.CardView_contentPaddingLeft, "styleable", "CardView_contentPaddingLeft"), r2);
        r15.top = r16.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.CardView_contentPaddingTop, "styleable", "CardView_contentPaddingTop"), r2);
        r15.right = r16.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.CardView_contentPaddingRight, "styleable", "CardView_contentPaddingRight"), r2);
        r15.bottom = r16.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.CardView_contentPaddingBottom, "styleable", "CardView_contentPaddingBottom"), r2);
        if (r7 <= r1) goto L13;
        float r8 = r7;
    L14:
        this.mUserSetMinWidth = r16.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.CardView_android_minWidth, "styleable", "CardView_android_minWidth"), 0);
        this.mUserSetMinHeight = r16.getDimensionPixelSize(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.CardView_android_minHeight, "styleable", "CardView_android_minHeight"), 0);
        r16.recycle();
        IMPL.a(r3, r4, r17, r6, r7, r8);
        return;
    L13:
        r8 = r1;
        goto L14
    L5:
        TypedArray r18 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
        int r5 = r18.getColor(0, 0);
        r18.recycle();
        float[] r19 = new float[3];
        Color.colorToHSV(r5, r19);
        if (r19[2] <= 0.5f) goto L8;
        int r110 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.color.cardview_light_background, "color", "cardview_light_background"));
    L9:
        r17 = ColorStateList.valueOf(r110);
        goto L10
    L8:
        r110 = ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.color.cardview_dark_background, "color", "cardview_dark_background"));
        goto L9
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    public void setUseCompatPadding(boolean r2) {
        if (this.mCompatPadding == r2) goto L6;
        this.mCompatPadding = r2;
        IMPL.g(this.mCardViewDelegate);
        return;
    }

    public void setContentPadding(int r2, int r3, int r4, int r5) {
        this.mContentPadding.set(r2, r3, r4, r5);
        IMPL.f(this.mCardViewDelegate);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r7, int r8) {
        e r0 = IMPL;
        if (ZeusTransformUtils.instanceOf(r0, b.class) == true) goto L15;
        int r1 = View.MeasureSpec.getMode(r7);
        if (r1 == Integer.MIN_VALUE) goto L8;
        if (r1 == 1073741824) goto L8;
    L9:
        int r2 = View.MeasureSpec.getMode(r8);
        if (r2 == Integer.MIN_VALUE) goto L13;
        if (r2 == 1073741824) goto L13;
    L14:
        super.onMeasure(r7, r8);
        return;
    L13:
        r8 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.c(this.mCardViewDelegate)), View.MeasureSpec.getSize(r8)), r2);
    L8:
        r7 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.b(this.mCardViewDelegate)), View.MeasureSpec.getSize(r7)), r1);
        goto L9
    L15:
        super.onMeasure(r7, r8);
    }

    @Override // android.view.View
    public void setMinimumWidth(int r1) {
        this.mUserSetMinWidth = r1;
        super.setMinimumWidth(r1);
    }

    @Override // android.view.View
    public void setMinimumHeight(int r1) {
        this.mUserSetMinHeight = r1;
        super.setMinimumHeight(r1);
    }

    public void setCardBackgroundColor(int r2) {
        IMPL.a(this.mCardViewDelegate, ColorStateList.valueOf(r2));
    }

    public void setCardBackgroundColor(ColorStateList r2) {
        IMPL.a(this.mCardViewDelegate, r2);
    }

    public ColorStateList getCardBackgroundColor() {
        return IMPL.i(this.mCardViewDelegate);
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

    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    public void setRadius(float r2) {
        IMPL.a(this.mCardViewDelegate, r2);
    }

    public float getRadius() {
        return IMPL.d(this.mCardViewDelegate);
    }

    public void setCardElevation(float r2) {
        IMPL.c(this.mCardViewDelegate, r2);
    }

    public float getCardElevation() {
        return IMPL.e(this.mCardViewDelegate);
    }

    public void setMaxCardElevation(float r2) {
        IMPL.b(this.mCardViewDelegate, r2);
    }

    public float getMaxCardElevation() {
        return IMPL.a(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public void setPreventCornerOverlap(boolean r2) {
        if (r2 == this.mPreventCornerOverlap) goto L6;
        this.mPreventCornerOverlap = r2;
        IMPL.h(this.mCardViewDelegate);
        return;
    }
}
