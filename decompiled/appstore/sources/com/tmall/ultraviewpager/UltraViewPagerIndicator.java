package com.tmall.ultraviewpager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.bytedanceos.common.toolbox.c0;

/* JADX INFO: loaded from: classes4.dex */
public class UltraViewPagerIndicator extends View implements ViewPager.OnPageChangeListener, IUltraIndicatorBuilder {
    private static final int DEFAULT_RADIUS = 3;
    private boolean animateIndicator;
    float defaultRadius;
    private Bitmap focusBitmap;
    private int focusColor;
    private int gravity;
    private UltraViewPagerIndicatorListener indicatorBuildListener;
    private int indicatorPadding;
    private int marginBottom;
    private int marginLeft;
    private int marginRight;
    private int marginTop;
    private Bitmap normalBitmap;
    private int normalColor;
    private UltraViewPager.Orientation orientation;
    private ViewPager.OnPageChangeListener pageChangeListener;
    float pageOffset;
    private Paint paintFill;
    private Paint paintStroke;
    private int radius;
    private int scrollState;
    private UltraViewPagerView viewPager;

    public interface UltraViewPagerIndicatorListener {
        void build();
    }

    public UltraViewPagerIndicator(Context r10) {
        super(r10);
        this.orientation = UltraViewPager.Orientation.HORIZONTAL;
        init();
    }

    private float getItemHeight() {
        if (isDrawResIndicator() == true) goto L5;
        int r10 = this.radius;
        if (r10 != 0) goto L10;
        return this.defaultRadius;
    L10:
        return r10;
    L5:
        return Math.max(this.focusBitmap.getHeight(), this.normalBitmap.getHeight());
    }

    private float getItemWidth() {
        if (isDrawResIndicator() == true) goto L5;
        int r10 = this.radius;
        if (r10 != 0) goto L10;
        return this.defaultRadius;
    L10:
        return r10;
    L5:
        return Math.max(this.focusBitmap.getWidth(), this.normalBitmap.getWidth());
    }

    private void init() {
        Paint r10 = new Paint(1);
        this.paintStroke = r10;
        r10.setStyle(Paint.Style.STROKE);
        Paint r11 = new Paint(1);
        this.paintFill = r11;
        r11.setStyle(Paint.Style.FILL);
        this.defaultRadius = TypedValue.applyDimension(1, 3.0f, getResources().getDisplayMetrics());
    }

    private boolean isDrawResIndicator() {
        if (this.focusBitmap != null) goto L5;
    L7:
        return false;
    L5:
        if (this.normalBitmap == null) goto L7;
        return true;
    }

    @Override // com.tmall.ultraviewpager.IUltraIndicatorBuilder
    public void build() {
        UltraViewPagerIndicatorListener r10 = this.indicatorBuildListener;
        if (r10 == null) goto L6;
        r10.build();
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r19) {
        super.onDraw(r19);
        UltraViewPagerView r10 = this.viewPager;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getAdapter() == null) goto L96;
        int r11 = ((UltraViewPagerAdapter) this.viewPager.getAdapter()).getRealCount();
        if (r11 != 0) goto L10;
        return;
    L10:
        UltraViewPager.Orientation r12 = this.orientation;
        UltraViewPager.Orientation r13 = UltraViewPager.Orientation.HORIZONTAL;
        if (r12 != r13) goto L14;
        int r14 = this.viewPager.getWidth();
        int r15 = this.viewPager.getHeight();
        int r16 = getPaddingLeft() + this.marginLeft;
        int r17 = getPaddingRight() + this.marginRight;
        int r18 = getPaddingTop() + this.marginTop;
        int r20 = ((int) this.paintStroke.getStrokeWidth()) + getPaddingBottom();
        int r110 = this.marginBottom;
    L13:
        int r21 = r20 + r110;
        float r111 = getItemWidth();
        if (isDrawResIndicator() == false) goto L18;
        int r112 = 1;
    L20:
        if (this.indicatorPadding != 0) goto L22;
        this.indicatorPadding = (int) r111;
    L22:
        float r113 = r16;
        float r114 = r112 * r111;
        float r115 = (r11 - 1) * (this.indicatorPadding + r114);
        int r116 = this.gravity;
        float r117 = r18;
        int r118 = r116 & 7;
        int r119 = r116 & 112;
        if (r118 != 1) goto L25;
        r113 = (((r14 - r16) - r17) - r115) / 2.0f;
    L38:
        if (r119 != 16) goto L40;
        r117 = (((r15 - r21) - r18) - r111) / 2.0f;
    L52:
        if (r118 != 1) goto L55;
        if (r119 != 16) goto L55;
        r117 = (((r15 - r21) - r18) - r111) / 2.0f;
    L55:
        float r22 = this.radius;
        if (this.paintStroke.getStrokeWidth() <= 0.0f) goto L58;
        r22 = r22 - (this.paintStroke.getStrokeWidth() / 2.0f);
    L58:
        int r23 = 0;
    L59:
        if (r23 >= r11) goto L77;
        float r24 = (r23 * (this.indicatorPadding + r114)) + r113;
        if (this.orientation != UltraViewPager.Orientation.HORIZONTAL) goto L63;
        float r25 = r117;
    L65:
        if (isDrawResIndicator() == false) goto L71;
        if (r23 == this.viewPager.getCurrentItem()) goto L76;
        r19.drawBitmap(this.normalBitmap, r24, r25, this.paintFill);
    L76:
        r23 = r23 + 1;
        goto L59
    L71:
        if (this.paintFill.getAlpha() <= 0) goto L74;
        this.paintFill.setColor(this.normalColor);
        r19.drawCircle(r24, r25, r22, this.paintFill);
    L74:
        if (c0.f(r22, this.radius) == true) goto L76;
        r19.drawCircle(r24, r25, this.radius, this.paintStroke);
        goto L76
    L63:
        r25 = r24;
        r24 = r117;
        goto L65
    L77:
        float r26 = this.viewPager.getCurrentItem() * (r114 + this.indicatorPadding);
        if (this.animateIndicator == false) goto L81;
        r26 = r26 + (this.pageOffset * r111);
    L81:
        if (this.orientation != UltraViewPager.Orientation.HORIZONTAL) goto L83;
        float r120 = r113 + r26;
        float r27 = r117;
    L85:
        if (isDrawResIndicator() == false) goto L87;
        r19.drawBitmap(this.focusBitmap, r120, r27, this.paintStroke);
        return;
    L87:
        this.paintFill.setColor(this.focusColor);
        r19.drawCircle(r120, r27, this.radius, this.paintFill);
        return;
    L83:
        r27 = r113 + r26;
        r120 = r117;
        goto L85
    L40:
        if (r119 != 48) goto L42;
        r117 = r117 + r111;
        goto L52
    L42:
        if (r119 != 80) goto L52;
        if (this.orientation != r13) goto L48;
        r117 = (r15 - r21) - getItemHeight();
    L48:
        if (this.orientation != UltraViewPager.Orientation.VERTICAL) goto L52;
        r113 = (r14 - r17) - r115;
        goto L52
    L25:
        if (r118 != 3) goto L27;
        r113 = r113 + r111;
        goto L38
    L27:
        if (r118 != 5) goto L38;
        UltraViewPager.Orientation r28 = this.orientation;
        if (r28 != r13) goto L33;
        r113 = ((r14 - r17) - r115) - r111;
    L33:
        if (r28 != UltraViewPager.Orientation.VERTICAL) goto L38;
        r117 = (r15 - r21) - r111;
        goto L38
    L18:
        r112 = 2;
        goto L20
    L14:
        r14 = this.viewPager.getHeight();
        r15 = this.viewPager.getWidth();
        r16 = getPaddingTop() + this.marginTop;
        r17 = (((int) this.paintStroke.getStrokeWidth()) + getPaddingBottom()) + this.marginBottom;
        r18 = getPaddingLeft() + this.marginLeft;
        r20 = getPaddingRight();
        r110 = this.marginRight;
        goto L13
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int r10) {
        this.scrollState = r10;
        ViewPager.OnPageChangeListener r11 = this.pageChangeListener;
        if (r11 == null) goto L6;
        r11.onPageScrollStateChanged(r10);
        return;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int r10, float r11, int r12) {
        this.pageOffset = r11;
        invalidate();
        ViewPager.OnPageChangeListener r13 = this.pageChangeListener;
        if (r13 == null) goto L6;
        r13.onPageScrolled(r10, r11, r12);
        return;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int r10) {
        if (this.scrollState != 0) goto L5;
        invalidate();
    L5:
        ViewPager.OnPageChangeListener r11 = this.pageChangeListener;
        if (r11 == null) goto L9;
        r11.onPageSelected(r10);
        return;
    }

    @Override // com.tmall.ultraviewpager.IUltraIndicatorBuilder
    public IUltraIndicatorBuilder setFocusColor(int r10) {
        this.focusColor = r10;
        return this;
    }

    @Override // com.tmall.ultraviewpager.IUltraIndicatorBuilder
    public IUltraIndicatorBuilder setFocusIcon(Bitmap r10) {
        this.focusBitmap = r10;
        return this;
    }

    @Override // com.tmall.ultraviewpager.IUltraIndicatorBuilder
    public IUltraIndicatorBuilder setFocusResId(int r10) {
        this.focusBitmap = BitmapFactory.decodeResource(getResources(), r10);     // Catch: Exception -> L4
    L6:
        return this;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    @Override // com.tmall.ultraviewpager.IUltraIndicatorBuilder
    public IUltraIndicatorBuilder setGravity(int r10) {
        this.gravity = r10;
        return this;
    }

    public void setIndicatorBuildListener(UltraViewPagerIndicatorListener r10) {
        this.indicatorBuildListener = r10;
    }

    @Override // com.tmall.ultraviewpager.IUltraIndicatorBuilder
    public IUltraIndicatorBuilder setIndicatorPadding(int r10) {
        this.indicatorPadding = r10;
        return this;
    }

    @Override // com.tmall.ultraviewpager.IUltraIndicatorBuilder
    public IUltraIndicatorBuilder setMargin(int r10, int r11, int r12, int r13) {
        this.marginLeft = r10;
        this.marginTop = r11;
        this.marginRight = r12;
        this.marginBottom = r13;
        return this;
    }

    @Override // com.tmall.ultraviewpager.IUltraIndicatorBuilder
    public IUltraIndicatorBuilder setNormalColor(int r10) {
        this.normalColor = r10;
        return this;
    }

    @Override // com.tmall.ultraviewpager.IUltraIndicatorBuilder
    public IUltraIndicatorBuilder setNormalIcon(Bitmap r10) {
        this.normalBitmap = r10;
        return this;
    }

    @Override // com.tmall.ultraviewpager.IUltraIndicatorBuilder
    public IUltraIndicatorBuilder setNormalResId(int r10) {
        this.normalBitmap = BitmapFactory.decodeResource(getResources(), r10);     // Catch: Exception -> L4
    L6:
        return this;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    @Override // com.tmall.ultraviewpager.IUltraIndicatorBuilder
    public IUltraIndicatorBuilder setOrientation(UltraViewPager.Orientation r10) {
        this.orientation = r10;
        return this;
    }

    public void setPageChangeListener(ViewPager.OnPageChangeListener r10) {
        this.pageChangeListener = r10;
    }

    @Override // com.tmall.ultraviewpager.IUltraIndicatorBuilder
    public IUltraIndicatorBuilder setRadius(int r10) {
        this.radius = r10;
        return this;
    }

    @Override // com.tmall.ultraviewpager.IUltraIndicatorBuilder
    public IUltraIndicatorBuilder setStrokeColor(int r10) {
        this.paintStroke.setColor(r10);
        return this;
    }

    @Override // com.tmall.ultraviewpager.IUltraIndicatorBuilder
    public IUltraIndicatorBuilder setStrokeWidth(int r10) {
        this.paintStroke.setStrokeWidth(r10);
        return this;
    }

    public void setViewPager(UltraViewPagerView r10) {
        this.viewPager = r10;
        r10.setOnPageChangeListener(this);
    }

    public UltraViewPagerIndicator(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.orientation = UltraViewPager.Orientation.HORIZONTAL;
        init();
    }

    public UltraViewPagerIndicator(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.orientation = UltraViewPager.Orientation.HORIZONTAL;
        init();
    }
}
