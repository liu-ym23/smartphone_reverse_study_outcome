package com.bytedanceos.common.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.TypedValue;
import android.view.View;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$color;
import com.bytedanceos.common.R$drawable;
import com.ttnet.org.chromium.net.NetError;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadProgressViewHelper {
    private static final int DEF_ALPHA_ANIM_DURATION = 300;
    private static int DEF_BACK_RING_WIDTH = 6;
    private static final float DEF_BACK_RING_WIDTH_DP = 2.0f;
    private static int DEF_FORE_RING_WIDTH = 4;
    private static final float DEF_FORE_RING_WIDTH_DP = 1.3333334f;
    private static int DEF_INNER_CIRCLE_RADIUS = 0;
    private static final int DEF_PROGRESS = 0;
    private static int DEF_VIEW_WIDTH = 0;
    private static final int MAX_ALPHA = 255;
    private static final int MIN_ALPHA = 0;
    public static final int STATE_PAUSED = 1;
    public static final int STATE_PROCESSING = 4;
    public static final int STATE_RESUMED = 2;
    public static final int STATE_RETRY = 3;
    private static int mBackProgressEndColor;
    private static int mBackProgressStartColor;
    private static Drawable mDownloadDrawable;
    private static int mFailedProgressColor;
    private static int mForeProgressEndColor;
    private static int mForeProgressStartColor;
    private static Drawable mPauseDrawable;
    private static Drawable mProcessingDrawable;
    private static Drawable mRetryDrawable;
    private final int DEFAULT_IMAGE_WIDTH;
    private final int DEFAULT_VIEW_WIDTH;
    private ValueAnimator mAlphaAnim;
    private long mAlphaAnimDuration;
    private RectF mArcRectF;
    private View mAttachedView;
    private Shader mBackProgressShader;
    private int mBackRingWidth;
    private int mCurrentState;
    private int mCurrentStateDrawableAlpha;
    private Shader mForeProgressShader;
    private int mForeRingWidth;
    private int mInnerCircleRadius;
    private int mLastState;
    private Paint mPaint;
    private int mProcessingDegree;
    private int mProgress;
    private int mWidth;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int currentState;
        int progress;

        static {
            CREATOR = new AnonymousClass1();
        }

        public /* synthetic */ SavedState(Parcel r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.progress);
            r10.writeInt(this.currentState);
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }

        private SavedState(Parcel r10) {
            super(r10);
            this.progress = r10.readInt();
            this.currentState = r10.readInt();
        }
    }

    static {
        DEF_INNER_CIRCLE_RADIUS = dp2px(15.0f);
        DEF_VIEW_WIDTH = dp2px(36.0f);
        DEF_BACK_RING_WIDTH = dp2px(2.0f);
        DEF_FORE_RING_WIDTH = dp2px(DEF_FORE_RING_WIDTH_DP);
        Resources r10 = BaseApplication.c().getResources();
        mForeProgressStartColor = r10.getColor(R$color.def_fore_progress_start_color);
        mForeProgressEndColor = r10.getColor(R$color.def_fore_progress_end_color);
        mBackProgressStartColor = r10.getColor(R$color.def_back_progress_start_color);
        mBackProgressEndColor = r10.getColor(R$color.def_back_progress_end_color);
        mFailedProgressColor = r10.getColor(R$color.def_failed_progress_color);
        mDownloadDrawable = r10.getDrawable(R$drawable.circular_progress_download);
        mPauseDrawable = r10.getDrawable(R$drawable.circular_progress_pause);
        mRetryDrawable = r10.getDrawable(R$drawable.circular_progress_redo);
        mProcessingDrawable = r10.getDrawable(R$drawable.circular_progress_processing);
    }

    public DownloadProgressViewHelper(Context r10, View r11) {
        this.mCurrentState = 1;
        this.mLastState = 1;
        this.mPaint = new Paint();
        this.mCurrentStateDrawableAlpha = 255;
        this.mAlphaAnimDuration = 300;
        this.mWidth = DEF_VIEW_WIDTH;
        this.DEFAULT_VIEW_WIDTH = 133;
        this.DEFAULT_IMAGE_WIDTH = 114;
        this.mAttachedView = r11;
        this.mInnerCircleRadius = DEF_INNER_CIRCLE_RADIUS;
        int r12 = DEF_FORE_RING_WIDTH;
        this.mForeRingWidth = r12;
        int r13 = DEF_BACK_RING_WIDTH;
        this.mBackRingWidth = r13;
        this.mProgress = 0;
        if (r13 < r12) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("the ring width should match mBackRingWidth >= mForeRingWidth, mBackRingWidth:" + this.mBackRingWidth + " mForeRingWidth:" + this.mForeRingWidth);
    }

    public static /* synthetic */ int access$002(DownloadProgressViewHelper r10, int r11) {
        r10.mCurrentStateDrawableAlpha = r11;
        return r11;
    }

    public static /* synthetic */ void access$100(DownloadProgressViewHelper r10) {
        r10.invalidate();
    }

    private void cancelAlphaAnim() {
        if (isAlphaAnimRunning() == false) goto L5;
        this.mAlphaAnim.cancel();
    L5:
        this.mCurrentStateDrawableAlpha = 255;
    }

    private static int dp2px(float r10) {
        float r11 = TypedValue.applyDimension(1, r10, BaseApplication.c().getResources().getDisplayMetrics());
        if (r11 < 0.0f) goto L5;
        float r12 = r11 + 0.9f;
    L7:
        return (int) r12;
    L5:
        r12 = r11 - 0.9f;
        goto L7
    }

    private Drawable getCurrentStateDrawable() {
        return getStateDrawable(this.mCurrentState);
    }

    private Drawable getLastStateDrawable() {
        return getStateDrawable(this.mLastState);
    }

    private int getProgress() {
        return this.mProgress;
    }

    private Drawable getStateDrawable(int r10) {
        if (r10 == 1) goto L15;
        if (r10 == 2) goto L19;
        if (r10 == 3) goto L18;
        if (r10 == 4) goto L17;
        return null;
    L17:
        return mProcessingDrawable;
    L18:
        return mRetryDrawable;
    L19:
        return mPauseDrawable;
    L15:
        return mDownloadDrawable;
    }

    private void invalidate() {
        View r10 = this.mAttachedView;
        if (r10 == null) goto L6;
        r10.invalidate();
        return;
    }

    private boolean isAlphaAnimRunning() {
        ValueAnimator r10 = this.mAlphaAnim;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isRunning() == false) goto L7;
        return true;
    }

    private void startShadowAlphaAnimation() {
        if (this.mAlphaAnimDuration > 0) goto L6;
        return;
    L6:
        if (this.mAlphaAnim != null) goto L9;
        ValueAnimator r10 = ValueAnimator.ofInt(new int[]{0, 255});
        this.mAlphaAnim = r10;
        r10.addUpdateListener(new AnonymousClass1(this));
        this.mAlphaAnim.setDuration(this.mAlphaAnimDuration);
    L9:
        if (isAlphaAnimRunning() == false) goto L11;
        cancelAlphaAnim();
    L11:
        this.mAlphaAnim.start();
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public int getLastState() {
        return this.mLastState;
    }

    public void onDetachedFromWindow() {
        cancelAlphaAnim();
    }

    public void onDraw(Canvas r15) {
        int r10 = this.mForeRingWidth;
        int r11 = this.mBackRingWidth;
        this.mPaint.reset();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(0);
        int r12 = this.mWidth;
        r15.drawRect(0.0f, 0.0f, r12, r12, this.mPaint);
        int r13 = this.mWidth;
        int r14 = r13 / 2;
        int r16 = r13 / 2;
        this.mPaint.setColor(-1);
        Drawable r17 = getLastStateDrawable();
        if (r17 != null) goto L5;
    L7:
        Drawable r18 = getCurrentStateDrawable();
        if (r18 == null) goto L25;
        int r19 = r18.getIntrinsicWidth();
        int r20 = r18.getIntrinsicHeight();
        if (this.mCurrentState == 4) goto L12;
    L14:
        int r21 = this.mWidth;
        r18.setBounds((r21 - r19) / 2, (r21 - r20) / 2, (r19 + r21) / 2, (r21 + r20) / 2);
    L15:
        r18.setAlpha(this.mCurrentStateDrawableAlpha);
        if (this.mCurrentState != 4) goto L20;
        int r22 = this.mProcessingDegree;
        int r23 = r22 + 5;
        this.mProcessingDegree = r23;
        if (r23 < 360) goto L21;
        this.mProcessingDegree = r22 + NetError.ERR_INCOMPLETE_CHUNKED_ENCODING;
    L21:
        r15.rotate(this.mProcessingDegree, r14, r16);
        r18.draw(r15);
        if (this.mCurrentState != 4) goto L25;
        invalidate();
        return;
    L20:
        this.mProcessingDegree = 0;
        goto L21
    L12:
        if (this.mWidth != 133) goto L14;
        r18.setBounds(9, 9, 123, 123);
    L25:
        float r24 = r11;
        this.mPaint.setStrokeWidth(r24);
        this.mPaint.setColor(Color.parseColor("#e6e6e6"));
        float r25 = r14;
        float r26 = r16;
        r15.drawCircle(r25, r26, this.mInnerCircleRadius, this.mPaint);
        float r27 = r10;
        this.mPaint.setStrokeWidth(r27);
        this.mPaint.setColor(Color.parseColor("#f2f2f2"));
        r15.drawCircle(r25, r26, this.mInnerCircleRadius, this.mPaint);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        if (this.mArcRectF != null) goto L28;
        int r28 = this.mInnerCircleRadius;
        this.mArcRectF = new RectF(r14 - r28, r16 - r28, r14 + r28, r28 + r16);
    L28:
        this.mPaint.setStrokeWidth(r24);
        if (this.mCurrentState != 3) goto L32;
        this.mPaint.setColor(mFailedProgressColor);
    L35:
        float r29 = (this.mProgress * 360.0f) / 100.0f;
        r15.drawArc(this.mArcRectF, -90.0f, r29, false, this.mPaint);
        this.mPaint.setStrokeWidth(r27);
        if (this.mCurrentState != 3) goto L39;
        this.mPaint.setColor(mFailedProgressColor);
    L42:
        r15.drawArc(this.mArcRectF, -90.0f, r29, false, this.mPaint);
        return;
    L39:
        if (this.mForeProgressShader != null) goto L41;
        int r30 = this.mInnerCircleRadius;
        int r31 = this.mForeRingWidth;
        this.mForeProgressShader = new LinearGradient(0.0f, (r16 - r30) - r31, 0.0f, (r16 + r30) + r31, mForeProgressStartColor, mForeProgressEndColor, Shader.TileMode.CLAMP);
    L41:
        this.mPaint.setShader(this.mForeProgressShader);
        goto L42
    L32:
        if (this.mBackProgressShader != null) goto L34;
        int r32 = this.mInnerCircleRadius;
        int r33 = this.mBackRingWidth;
        this.mBackProgressShader = new LinearGradient(0.0f, (r16 - r32) - r33, 0.0f, (r32 + r16) + r33, mBackProgressStartColor, mBackProgressEndColor, Shader.TileMode.CLAMP);
    L34:
        this.mPaint.setShader(this.mBackProgressShader);
        goto L35
    L5:
        if (this.mCurrentStateDrawableAlpha == 255) goto L7;
        int r34 = r17.getIntrinsicWidth();
        int r35 = r17.getIntrinsicHeight();
        int r36 = this.mWidth;
        r17.setBounds((r36 - r34) / 2, (r36 - r35) / 2, (r34 + r36) / 2, (r36 + r35) / 2);
        r17.setAlpha(255 - this.mCurrentStateDrawableAlpha);
        r17.draw(r15);
        goto L7
    }

    public void onRestoreInstanceState(SavedState r10) {
        setCurrentState(r10.currentState);
        setProgress(r10.progress);
    }

    public Parcelable onSaveInstanceState(Parcelable r10) {
        SavedState r11 = new SavedState(r10);
        r11.progress = this.mProgress;
        r11.currentState = this.mCurrentState;
        return r11;
    }

    public void setAlphaAnimationDuration(long r10) {
        this.mAlphaAnimDuration = r10;
    }

    public void setCurrentState(int r10) {
        if (r10 != 1) goto L5;
    L13:
        int r11 = this.mCurrentState;
        if (r11 != r10) goto L16;
        return;
    L16:
        this.mLastState = r11;
        this.mCurrentState = r10;
        startShadowAlphaAnimation();
        invalidate();
        return;
    L5:
        if (r10 == 2) goto L13;
        if (r10 == 3) goto L13;
        if (r10 == 4) goto L13;
        throw new IllegalArgumentException("invalid state value:" + r10);
    }

    public void setProgress(int r10) {
        if (this.mProgress != r10) goto L5;
        return;
    L5:
        this.mProgress = r10;
        invalidate();
    }

    public void setWidth(int r10) {
        this.mWidth = r10;
    }
}
