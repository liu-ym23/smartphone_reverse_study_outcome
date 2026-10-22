package com.stepos.launcher.assistant.slidepanel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes.dex */
public class OverlayPageIndicatorView extends View {
    private static final float DOT_RADIUS_DP = 3.0f;
    private static final float DOT_SPACE_DP = 10.0f;
    private static final float OVERLAY_BAR_HEIGHT_DP = 2.0f;
    private static final float OVERLAY_BAR_RADIUS_DP = 2.0f;
    private static final float PROGRESS_EPSILON = 1.0E-4f;
    private int mActivePage;
    private final Paint mDotPaint;
    private float mDotRadius;
    private float mDotSpace;
    private int mIndicatorColor;
    private float mOverlayBarHeight;
    private float mOverlayBarRadius;
    private float mOverlayProgress;
    private int mPageCount;
    private int mScrollColor;
    private final RectF mScrollRect;
    private final RectF mTmpRect;

    public OverlayPageIndicatorView(Context context) {
        this(context, null);
    }

    private float calcHeight() {
        return this.mDotRadius * 2.0f;
    }

    private float calcWidth() {
        int i10 = this.mPageCount;
        if (i10 <= 0) {
            return 0.0f;
        }
        return (i10 * this.mDotRadius * 2.0f) + (Math.max(0, i10 - 1) * this.mDotSpace);
    }

    private static float clamp(float f10) {
        return Math.max(0.0f, Math.min(1.0f, f10));
    }

    private void drawOverlayIcon(Canvas canvas, float f10, float f11) {
        float f12 = this.mDotRadius;
        float f13 = f10 - f12;
        float f14 = f11 - f12;
        this.mTmpRect.set(f13, f14, (f12 * 2.0f) + f13, this.mOverlayBarHeight + f14);
        RectF rectF = this.mTmpRect;
        float f15 = this.mOverlayBarRadius;
        canvas.drawRoundRect(rectF, f15, f15, this.mDotPaint);
        float f16 = this.mOverlayBarHeight;
        float f17 = this.mDotRadius;
        float f18 = f14 + ((f17 * 2.0f) - (f16 * 2.0f)) + f16;
        this.mTmpRect.set(f13, f18, (f17 * 2.0f) + f13, f16 + f18);
        RectF rectF2 = this.mTmpRect;
        float f19 = this.mOverlayBarRadius;
        canvas.drawRoundRect(rectF2, f19, f19, this.mDotPaint);
    }

    private void drawScrollHighlight(Canvas canvas, float[] fArr, float f10) {
        if (this.mPageCount <= 0) {
            return;
        }
        float f11 = this.mOverlayProgress;
        float f12 = this.mDotRadius;
        float f13 = f10 - f12;
        float f14 = f10 + f12;
        int pageDotCount = getPageDotCount();
        if (pageDotCount <= 0 || f11 >= 1.0f) {
            float f15 = fArr[0];
            this.mScrollRect.set(f15 - f12, f13, f15 + f12, f14);
        } else if (f11 <= 0.0f) {
            float f16 = fArr[Math.min(Math.max(this.mActivePage, 0), pageDotCount - 1) + 1];
            this.mScrollRect.set(f16 - f12, f13, f16 + f12, f14);
        } else {
            float f17 = fArr[1];
            float f18 = fArr[0];
            float f19 = f11 * 2.0f;
            if (f11 < 0.5f) {
                float f20 = f17 + f12;
                this.mScrollRect.set((f20 - ((f17 - f18) * f19)) - (2.0f * f12), f13, f20, f14);
            } else {
                float f21 = f18 - f12;
                this.mScrollRect.set(f21, f13, ((f17 - f18) * (2.0f - f19)) + f21 + (2.0f * f12), f14);
            }
        }
        this.mDotPaint.setColor(this.mScrollColor);
        canvas.drawRoundRect(this.mScrollRect, f12, f12, this.mDotPaint);
    }

    private int getPageDotCount() {
        return Math.max(0, this.mPageCount - 1);
    }

    private static int withAlpha(int i10, float f10) {
        return Color.argb(Math.round(f10 * Color.alpha(i10)), Color.red(i10), Color.green(i10), Color.blue(i10));
    }

    public boolean applyState(Bundle bundle) {
        return applyState(bundle, true);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mPageCount <= 0) {
            return;
        }
        float width = (getWidth() - calcWidth()) / 2.0f;
        float height = getHeight() / 2.0f;
        float[] fArr = new float[this.mPageCount];
        for (int i10 = 0; i10 < this.mPageCount; i10++) {
            float f10 = this.mDotRadius;
            fArr[i10] = width + f10;
            width += (f10 * 2.0f) + this.mDotSpace;
        }
        this.mDotPaint.setColor(withAlpha(this.mIndicatorColor, 0.35f));
        for (int i11 = 0; i11 < this.mPageCount; i11++) {
            if (i11 == 0) {
                drawOverlayIcon(canvas, fArr[i11], height);
            } else {
                canvas.drawCircle(fArr[i11], height, this.mDotRadius, this.mDotPaint);
            }
        }
        drawScrollHighlight(canvas, fArr, height);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        setMeasuredDimension(View.resolveSize((int) Math.ceil(calcWidth()), i10), View.resolveSize((int) Math.ceil(calcHeight()), i11));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void setOverlayProgress(float f10) {
        float fClamp = clamp(f10);
        if (Math.abs(fClamp - this.mOverlayProgress) < PROGRESS_EPSILON) {
            return;
        }
        this.mOverlayProgress = fClamp;
        invalidate();
    }

    public OverlayPageIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint(1);
        this.mDotPaint = paint;
        this.mScrollRect = new RectF();
        this.mTmpRect = new RectF();
        this.mIndicatorColor = -1;
        this.mScrollColor = -1;
        float f10 = getResources().getDisplayMetrics().density;
        this.mDotRadius = 3.0f * f10;
        this.mDotSpace = 10.0f * f10;
        float f11 = f10 * 2.0f;
        this.mOverlayBarHeight = f11;
        this.mOverlayBarRadius = f11;
        paint.setStyle(Paint.Style.FILL);
        setClickable(false);
        setFocusable(false);
        setImportantForAccessibility(2);
    }

    public boolean applyState(Bundle bundle, boolean z10) {
        boolean z11;
        int i10;
        int i11;
        int iMax;
        int iMax2;
        if (bundle == null) {
            return false;
        }
        boolean z12 = true;
        if (!bundle.containsKey(OverlayIndicatorState.KEY_PAGE_COUNT) || (iMax2 = Math.max(0, bundle.getInt(OverlayIndicatorState.KEY_PAGE_COUNT))) == this.mPageCount) {
            z11 = false;
        } else {
            this.mPageCount = iMax2;
            z11 = true;
        }
        boolean z13 = z11;
        if (bundle.containsKey(OverlayIndicatorState.KEY_ACTIVE_PAGE) && (iMax = Math.max(0, bundle.getInt(OverlayIndicatorState.KEY_ACTIVE_PAGE))) != this.mActivePage) {
            this.mActivePage = iMax;
            z13 = true;
        }
        if (z10 && bundle.containsKey(OverlayIndicatorState.KEY_OVERLAY_PROGRESS)) {
            float fClamp = clamp(bundle.getFloat(OverlayIndicatorState.KEY_OVERLAY_PROGRESS));
            if (Math.abs(fClamp - this.mOverlayProgress) >= PROGRESS_EPSILON) {
                this.mOverlayProgress = fClamp;
                z13 = true;
            }
        }
        if (bundle.containsKey(OverlayIndicatorState.KEY_INDICATOR_COLOR) && (i11 = bundle.getInt(OverlayIndicatorState.KEY_INDICATOR_COLOR)) != this.mIndicatorColor) {
            this.mIndicatorColor = i11;
            z13 = true;
        }
        if (!bundle.containsKey(OverlayIndicatorState.KEY_SCROLL_COLOR) || (i10 = bundle.getInt(OverlayIndicatorState.KEY_SCROLL_COLOR)) == this.mScrollColor) {
            z12 = z13;
        } else {
            this.mScrollColor = i10;
        }
        if (z11) {
            requestLayout();
            return z11;
        }
        if (z12) {
            invalidate();
        }
        return z11;
    }
}
