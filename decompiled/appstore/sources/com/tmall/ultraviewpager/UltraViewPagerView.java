package com.tmall.ultraviewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedanceos.common.network.ads.AdsReportManager;
import com.google.common.primitives.Ints;
import com.tmall.ultraviewpager.transformer.UltraVerticalTransformer;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.structure.cell.BannerCell;

/* JADX INFO: loaded from: classes4.dex */
public class UltraViewPagerView extends ViewPager implements UltraViewPagerAdapter.UltraViewPagerCenterListener {
    private boolean autoMeasureHeight;
    private int constrainLength;
    private boolean enableLoop;
    private int itemMarginBottom;
    private int itemMarginLeft;
    private int itemMarginRight;
    private int itemMarginTop;
    private double itemRatio;
    private float multiScrRatio;
    private boolean needsMeasurePage;
    private UltraViewPagerAdapter pagerAdapter;
    private float ratio;
    private UltraViewPager.ScrollMode scrollMode;

    public UltraViewPagerView(Context r10) {
        super(r10);
        this.multiScrRatio = Float.NaN;
        this.itemRatio = Double.NaN;
        this.ratio = Float.NaN;
        this.scrollMode = UltraViewPager.ScrollMode.HORIZONTAL;
        init(r10, null);
    }

    private int convertDp2Px(Context r10, float r11) {
        return (int) TypedValue.applyDimension(1, r11, r10.getResources().getDisplayMetrics());
    }

    private void init(Context r10, AttributeSet r11) {
        setClipChildren(false);
        setOverScrollMode(2);
    }

    private MotionEvent swapTouchEvent(MotionEvent r10) {
        float r11 = getWidth();
        float r12 = getHeight();
        r10.setLocation((r10.getY() / r12) * r11, (r10.getX() / r11) * r12);
        return r10;
    }

    @Override // com.tmall.ultraviewpager.UltraViewPagerAdapter.UltraViewPagerCenterListener
    public void center() {
        setCurrentItem(0);
    }

    public int getConstrainLength() {
        return this.constrainLength;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public int getCurrentItem() {
        UltraViewPagerAdapter r10 = this.pagerAdapter;
        if (r10 == null) goto L9;
        if (r10.getCount() == 0) goto L9;
        return super.getCurrentItem() % this.pagerAdapter.getRealCount();
    L9:
        return super.getCurrentItem();
    }

    public int getCurrentItemFake() {
        return super.getCurrentItem();
    }

    public float getRatio() {
        return this.ratio;
    }

    public UltraViewPager.ScrollMode getScrollMode() {
        return this.scrollMode;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        if (this.scrollMode != UltraViewPager.ScrollMode.VERTICAL) goto L7;
        boolean r11 = super.onInterceptTouchEvent(swapTouchEvent(r10));
        swapTouchEvent(r10);
        return r11;
    L7:
        return super.onInterceptTouchEvent(r10);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        onMeasurePage(r10, r11);
    }

    public void onMeasurePage(int r11, int r12) {
        View r10 = this.pagerAdapter.getViewAtPosition(getCurrentItem());
        if (r10 != null) goto L5;
        r10 = getChildAt(0);
    L5:
        if (r10 != null) goto L7;
        return;
    L7:
        int r13 = 0;
    L9:
        if (r13 >= getChildCount()) goto L20;
        View r14 = getChildAt(r13);
        if (r14.getPaddingLeft() == this.itemMarginLeft) goto L13;
    L18:
        r14.setPadding(this.itemMarginLeft, this.itemMarginTop, this.itemMarginRight, this.itemMarginBottom);
    L19:
        r13 = r13 + 1;
        goto L9
    L13:
        if (r14.getPaddingTop() != this.itemMarginTop) goto L18;
        if (r14.getPaddingRight() != this.itemMarginRight) goto L18;
        if (r14.getPaddingBottom() == this.itemMarginBottom) goto L19;
    L20:
        ViewGroup.LayoutParams r15 = r10.getLayoutParams();
        int r16 = ViewGroup.getChildMeasureSpec(r11, 0, r15.width);
        int r17 = ViewGroup.getChildMeasureSpec(r12, 0, r15.height);
        int r18 = (int) (((View.MeasureSpec.getSize(r16) - getPaddingLeft()) - getPaddingRight()) * this.pagerAdapter.getPageWidth(getCurrentItem()));
        int r19 = (View.MeasureSpec.getSize(r17) - getPaddingTop()) - getPaddingBottom();
        if (this.needsMeasurePage == false) goto L79;
        if (r18 != 0) goto L26;
        if (r19 != 0) goto L26;
        return;
    L26:
        if (Double.isNaN(this.itemRatio) == true) goto L30;
        int r110 = (int) (((double) r18) / this.itemRatio);
        int r20 = getChildCount();
        int r21 = 0;
    L28:
        if (r21 >= r20) goto L38;
        getChildAt(r21).measure(View.MeasureSpec.makeMeasureSpec(r18, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(r110, Ints.MAX_POWER_OF_TWO));
        r21 = r21 + 1;
    L38:
        if (this.scrollMode != UltraViewPager.ScrollMode.HORIZONTAL) goto L40;
        boolean r111 = true;
    L41:
        int r22 = (this.itemMarginLeft + r10.getMeasuredWidth()) + this.itemMarginRight;
        int r23 = (this.itemMarginTop + r10.getMeasuredHeight()) + this.itemMarginBottom;
        if (Float.isNaN(this.ratio) == true) goto L47;
        int r24 = View.MeasureSpec.makeMeasureSpec((int) (getMeasuredWidth() / this.ratio), Ints.MAX_POWER_OF_TWO);
        setMeasuredDimension(r11, r24);
        int r112 = getChildCount();
        int r25 = 0;
    L44:
        if (r25 >= r112) goto L57;
        getChildAt(r25).measure(View.MeasureSpec.makeMeasureSpec(r22, Ints.MAX_POWER_OF_TWO), r24);
        r25 = r25 + 1;
    L57:
        if (this.pagerAdapter.isEnableMultiScr() == true) goto L59;
        return;
    L59:
        if (r111 == false) goto L61;
        int r113 = getMeasuredWidth();
    L62:
        if (r111 == false) goto L64;
        int r114 = r10.getMeasuredWidth();
    L65:
        if (r114 <= 0) goto L80;
        this.needsMeasurePage = false;
        int r26 = r113 - r114;
        if (getPageMargin() != 0) goto L69;
        setPageMargin(-r26);
    L69:
        setOffscreenPageLimit(((int) Math.ceil(r113 / r114)) + 1);
        requestLayout();
        return;
    L80:
        return;
    L64:
        r114 = r10.getMeasuredHeight();
        goto L65
    L61:
        r113 = getMeasuredHeight();
        goto L62
    L47:
        if (this.autoMeasureHeight == false) goto L57;
        if (r111 == false) goto L50;
        this.constrainLength = View.MeasureSpec.makeMeasureSpec(r23, Ints.MAX_POWER_OF_TWO);
        setMeasuredDimension(getMeasuredWidth(), r23);
    L52:
        if (r23 != (this.itemMarginTop + this.itemMarginBottom)) goto L54;
        boolean r115 = true;
    L55:
        this.needsMeasurePage = r115;
        goto L57
    L54:
        r115 = false;
        goto L55
    L50:
        this.constrainLength = View.MeasureSpec.makeMeasureSpec(r22, Ints.MAX_POWER_OF_TWO);
        setMeasuredDimension(r22, getMeasuredHeight());
        goto L52
    L40:
        r111 = false;
        goto L41
    L30:
        int r27 = getChildCount();
        int r28 = 0;
    L31:
        if (r28 >= r27) goto L38;
        View r29 = getChildAt(r28);
        if (this.pagerAdapter.getPageWidth(getCurrentItem()) == 1.0f) goto L35;
        r29.measure(View.MeasureSpec.makeMeasureSpec(r18, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(0, 0));
    L36:
        r28 = r28 + 1;
        goto L31
    L35:
        r29.measure(r16, r17);
        goto L36
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        this.needsMeasurePage = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
    L8:
        return true;
    L3:
        if (this.scrollMode != UltraViewPager.ScrollMode.VERTICAL) goto L7;
        return super.onTouchEvent(swapTouchEvent(r10));
    L7:
        return super.onTouchEvent(r10);
    }

    @Override // com.tmall.ultraviewpager.UltraViewPagerAdapter.UltraViewPagerCenterListener
    public void resetPosition() {
        setCurrentItem(getCurrentItem());
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter r10) {
        if (r10 == null) goto L4;
        UltraViewPagerAdapter r11 = new UltraViewPagerAdapter(r10);
        this.pagerAdapter = r11;
        r11.setCenterListener(this);
        this.pagerAdapter.setEnableLoop(this.enableLoop);
        this.pagerAdapter.setMultiScrRatio(this.multiScrRatio);
        this.needsMeasurePage = true;
        this.constrainLength = 0;
        super.setAdapter(this.pagerAdapter);
        return;
    L4:
        super.setAdapter(r10);
    }

    public void setAutoMeasureHeight(boolean r10) {
        this.autoMeasureHeight = r10;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int r10) {
        setCurrentItem(r10, false);
    }

    public void setCurrentItemFake(int r10, boolean r11) {
        super.setCurrentItem(r10, r11);
        if ((this.pagerAdapter.getAdapter() instanceof BannerCell.BannerAdapter) == false) goto L5;
        BaseCell r12 = ((BannerCell.BannerAdapter) this.pagerAdapter.getAdapter()).getItemCell(getCurrentItem());
        AdsReportManager.h().m(r12);
        return;
    L5:
        this.pagerAdapter.getAdapter();
    }

    public void setEnableLoop(boolean r10) {
        this.enableLoop = r10;
        UltraViewPagerAdapter r11 = this.pagerAdapter;
        if (r11 == null) goto L6;
        r11.setEnableLoop(r10);
        return;
    }

    public void setItemMargin(int r10, int r11, int r12, int r13) {
        this.itemMarginLeft = r10;
        this.itemMarginTop = r11;
        this.itemMarginRight = r12;
        this.itemMarginBottom = r13;
    }

    public void setItemRatio(double r10) {
        this.itemRatio = r10;
    }

    public void setMultiScreen(float r10) {
        this.multiScrRatio = r10;
        UltraViewPagerAdapter r11 = this.pagerAdapter;
        if (r11 == null) goto L5;
        r11.setMultiScrRatio(r10);
        this.needsMeasurePage = true;
    L5:
        float r12 = (1.0f - r10) * getResources().getDisplayMetrics().widthPixels;
        if (this.scrollMode != UltraViewPager.ScrollMode.VERTICAL) goto L8;
        setPageMargin((int) r12);
        return;
    L8:
        setPageMargin((int) (-(r12 + convertDp2Px(getContext(), 1.0f))));
    }

    public void setRatio(float r10) {
        this.ratio = r10;
    }

    public void setScrollMode(UltraViewPager.ScrollMode r10) {
        this.scrollMode = r10;
        if (r10 != UltraViewPager.ScrollMode.VERTICAL) goto L6;
        setPageTransformer(false, new UltraVerticalTransformer());
        return;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int r10, boolean r11) {
        if (this.pagerAdapter.getCount() != 0) goto L5;
    L7:
        setCurrentItemFake(r10, r11);
        return;
    L5:
        if (this.pagerAdapter.isEnableLoop() == false) goto L7;
        int r12 = this.pagerAdapter.getCount() / 2;
        r10 = (r10 % this.pagerAdapter.getRealCount()) + r12;
        goto L7
    }

    public UltraViewPagerView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.multiScrRatio = Float.NaN;
        this.itemRatio = Double.NaN;
        this.ratio = Float.NaN;
        this.scrollMode = UltraViewPager.ScrollMode.HORIZONTAL;
        init(r10, r11);
    }
}
