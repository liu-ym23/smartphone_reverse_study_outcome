package com.bytedanceos.common.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.bytedanceos.common.R$id;
import java.util.concurrent.atomic.AtomicBoolean;
import tc.f;

/* JADX INFO: loaded from: classes2.dex */
public class AppDetailScrollView extends VerticalScrollView {
    private final float mDurationFactor;
    private final float mFactor;
    private ViewGroup mHeaderView;
    private float mLastAlpha;
    private float mLastFontSize;
    private float mMaxContentViewBottom;
    private float mMaxContentViewTop;
    private float mMaxHeight;
    private float mMaxIconHeight;
    private float mMaxNameSize;
    private final float mMaxValue;
    private float mMinContentViewTop;
    private float mMinHeight;
    private float mMinIconHeight;
    private float mMinNameSize;
    private float mMoveOffset;
    private ScrollChangedCallBack mScrollChangedCallBack;
    private boolean mScrollToGameTab;
    private ValueAnimator mValueAnimator;
    private AtomicBoolean mZoomInView;

    public interface ScrollChangedCallBack {
        void onScroll(int r10, int r11, int r12, int r13);
    }

    public AppDetailScrollView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mFactor = 1.5f;
        this.mMaxValue = 1.0f;
        this.mDurationFactor = 1.33f;
        this.mMoveOffset = 10.0f;
        this.mMaxHeight = 0.0f;
        this.mMinHeight = 0.0f;
        this.mMaxIconHeight = 0.0f;
        this.mMinIconHeight = 0.0f;
        this.mMaxContentViewTop = 0.0f;
        this.mMinContentViewTop = 0.0f;
        this.mMaxContentViewBottom = 0.0f;
        this.mMaxNameSize = 0.0f;
        this.mMinNameSize = 0.0f;
        this.mLastAlpha = 0.0f;
        this.mLastFontSize = 0.0f;
        this.mValueAnimator = null;
        this.mZoomInView = new AtomicBoolean(true);
    }

    public static /* synthetic */ ViewGroup access$000(AppDetailScrollView r10) {
        return r10.mHeaderView;
    }

    public static /* synthetic */ float access$100(AppDetailScrollView r10) {
        return r10.mMinHeight;
    }

    public static /* synthetic */ float access$1000(AppDetailScrollView r10) {
        return r10.mLastFontSize;
    }

    public static /* synthetic */ float access$1002(AppDetailScrollView r10, float r11) {
        r10.mLastFontSize = r11;
        return r11;
    }

    public static /* synthetic */ float access$1100(AppDetailScrollView r10) {
        return r10.mLastAlpha;
    }

    public static /* synthetic */ float access$1102(AppDetailScrollView r10, float r11) {
        r10.mLastAlpha = r11;
        return r11;
    }

    public static /* synthetic */ float access$200(AppDetailScrollView r10) {
        return r10.mMaxHeight;
    }

    public static /* synthetic */ float access$300(AppDetailScrollView r10) {
        return r10.mMinContentViewTop;
    }

    public static /* synthetic */ float access$400(AppDetailScrollView r10) {
        return r10.mMaxContentViewTop;
    }

    public static /* synthetic */ float access$500(AppDetailScrollView r10) {
        return r10.mMaxContentViewBottom;
    }

    public static /* synthetic */ float access$600(AppDetailScrollView r10) {
        return r10.mMinIconHeight;
    }

    public static /* synthetic */ float access$700(AppDetailScrollView r10) {
        return r10.mMaxIconHeight;
    }

    public static /* synthetic */ float access$800(AppDetailScrollView r10) {
        return r10.mMinNameSize;
    }

    public static /* synthetic */ float access$900(AppDetailScrollView r10) {
        return r10.mMaxNameSize;
    }

    private void initParams() {
        if (this.mMaxHeight != 0.0f) goto L6;
        this.mMaxHeight = f.i(128);
    L6:
        if (this.mMinHeight != 0.0f) goto L9;
        this.mMinHeight = f.i(56);
    L9:
        if (this.mMaxIconHeight != 0.0f) goto L12;
        this.mMaxIconHeight = f.i(64);
    L12:
        if (this.mMinIconHeight != 0.0f) goto L15;
        this.mMinIconHeight = f.i(40);
    L15:
        if (this.mMaxContentViewTop != 0.0f) goto L18;
        this.mMaxContentViewTop = f.i(12);
    L18:
        if (this.mMinContentViewTop != 0.0f) goto L21;
        this.mMinContentViewTop = f.i(8);
    L21:
        if (this.mMaxContentViewBottom != 0.0f) goto L24;
        this.mMaxContentViewBottom = f.i(8);
    L24:
        if (this.mMaxNameSize != 0.0f) goto L27;
        this.mMaxNameSize = f.i(20);
    L27:
        if (this.mMinNameSize != 0.0f) goto L30;
        this.mMinNameSize = f.i(14);
        return;
    }

    private void resetHeaderView(int r10, int r11) {
        if (r10 > r11) goto L4;
    L6:
        if (r10 < r11) goto L8;
        return;
    L8:
        if (r10 > this.mMoveOffset) goto L13;
        zoomHeaderView(true);
        return;
    L13:
        return;
    L4:
        if (r10 < ((this.mMaxHeight - this.mMinHeight) - this.mMoveOffset)) goto L6;
        zoomHeaderView(false);
    }

    private void scrollToGameTab() {
        this.mScrollToGameTab = false;
        View r10 = findViewById(R$id.appinfo_gift_pack);
        if (r10 == null) goto L6;
        scrollTo(0, r10.getTop());
        return;
    }

    private void zoomHeaderView(final boolean r10) {
        if (this.mZoomInView.get() == r10) goto L11;
        ValueAnimator r11 = this.mValueAnimator;
        if (r11 != null) goto L7;
    L9:
        initParams();
        this.mZoomInView.set(r10);
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.mValueAnimator = r12;
        r12.setDuration(300);
        this.mValueAnimator.setInterpolator(new DecelerateInterpolator(1.5f));
        this.mValueAnimator.addUpdateListener(new AnonymousClass1(this, r10));
        this.mValueAnimator.start();
        return;
    L7:
        if (r11.isRunning() == false) goto L9;
        return;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        if (this.mScrollToGameTab == false) goto L7;
        if (r10 == false) goto L8;
        scrollToGameTab();
        return;
    L8:
        return;
    }

    @Override // com.bytedanceos.common.ui.widget.VerticalScrollView, android.view.View
    public void onScrollChanged(int r10, int r11, int r12, int r13) {
        super.onScrollChanged(r10, r11, r12, r13);
        if (this.mScrollToGameTab == false) goto L5;
        return;
    L5:
        ScrollChangedCallBack r14 = this.mScrollChangedCallBack;
        if (r14 == null) goto L8;
        r14.onScroll(r10, r11, r12, r13);
    L8:
        if (r13 >= 0) goto L10;
        return;
    L10:
        if (this.mHeaderView == null) goto L14;
        resetHeaderView(r11, r13);
        return;
    }

    public void setHeaderView(ViewGroup r10) {
        this.mHeaderView = r10;
    }

    public void setScrollCallBack(ScrollChangedCallBack r10) {
        this.mScrollChangedCallBack = r10;
    }

    public void setScrollToGameTab(boolean r10) {
        this.mScrollToGameTab = r10;
    }
}
