package com.facebook.shimmer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ShimmerFrameLayout extends FrameLayout {
    private final Paint mContentPaint;
    private final ShimmerDrawable mShimmerDrawable;
    private boolean mShowShimmer;

    public ShimmerFrameLayout(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        super(r4);
        this.mContentPaint = new Paint();
        this.mShimmerDrawable = new ShimmerDrawable();
        this.mShowShimmer = true;
        init(r4, null);
    }

    public ShimmerFrameLayout(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r5, r6);
        this.mContentPaint = new Paint();
        this.mShimmerDrawable = new ShimmerDrawable();
        this.mShowShimmer = true;
        init(r5, r6);
    }

    public ShimmerFrameLayout(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r6, r7, r5);
        this.mContentPaint = new Paint();
        this.mShimmerDrawable = new ShimmerDrawable();
        this.mShowShimmer = true;
        init(r6, r7);
    }

    public ShimmerFrameLayout(Context r3, AttributeSet r4, int r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r7, r8, r5, r6);
        this.mContentPaint = new Paint();
        this.mShimmerDrawable = new ShimmerDrawable();
        this.mShowShimmer = true;
        init(r7, r8);
    }

    private void init(Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        setWillNotDraw(false);
        this.mShimmerDrawable.setCallback(this);
        if (r8 != null) goto L6;
        setShimmer(new a.C0264a().c());
        return;
    L6:
        TypedArray r9 = r7.obtainStyledAttributes(r8, R.styleable.ShimmerFrameLayout, 0, 0);
    L16:
        th = move-exception;
        r9.recycle();
        throw th;
    L8:
        if (r9.hasValue(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_colored, "styleable", "ShimmerFrameLayout_shimmer_colored")) == true) goto L10;
    L12:
        a.b r10 = new a.C0264a();     // Catch: Throwable -> L16
    L13:
        setShimmer(r10.a(r9).c());     // Catch: Throwable -> L16
        r9.recycle();
        return;
    L10:
        if (r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.ShimmerFrameLayout_shimmer_colored, "styleable", "ShimmerFrameLayout_shimmer_colored"), false) == false) goto L12;
        r10 = new a.c();     // Catch: Throwable -> L16
        goto L13
    }

    public ShimmerFrameLayout setShimmer(a r2) {
        this.mShimmerDrawable.setShimmer(r2);
        if (r2 != null) goto L5;
    L7:
        setLayerType(0, null);
    L8:
        return this;
    L5:
        if (r2.o == false) goto L7;
        setLayerType(2, this.mContentPaint);
        goto L8
    }

    public void startShimmer() {
        this.mShimmerDrawable.startShimmer();
    }

    public void stopShimmer() {
        this.mShimmerDrawable.stopShimmer();
    }

    public boolean isShimmerStarted() {
        return this.mShimmerDrawable.isShimmerStarted();
    }

    public void showShimmer(boolean r2) {
        if (this.mShowShimmer == false) goto L5;
        return;
    L5:
        this.mShowShimmer = true;
        if (r2 == false) goto L9;
        startShimmer();
        return;
    }

    public void hideShimmer() {
        if (this.mShowShimmer == true) goto L5;
        return;
    L5:
        stopShimmer();
        this.mShowShimmer = false;
        invalidate();
    }

    public boolean isShimmerVisible() {
        return this.mShowShimmer;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        int r6 = getWidth();
        int r7 = getHeight();
        this.mShimmerDrawable.setBounds(0, 0, r6, r7);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mShimmerDrawable.maybeStartShimmer();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopShimmer();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r2) {
        super.dispatchDraw(r2);
        if (this.mShowShimmer == false) goto L6;
        this.mShimmerDrawable.draw(r2);
        return;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable r2) {
        if (super.verifyDrawable(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (r2 == this.mShimmerDrawable) goto L8;
        return false;
    }
}
