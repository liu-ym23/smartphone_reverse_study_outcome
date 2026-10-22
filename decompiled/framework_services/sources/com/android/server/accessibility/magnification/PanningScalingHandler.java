package com.android.server.accessibility.magnification;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.util.Slog;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
class PanningScalingHandler extends GestureDetector.SimpleOnGestureListener implements ScaleGestureDetector.OnScaleGestureListener {
    private static final boolean DEBUG = false;
    private static final String TAG = "PanningScalingHandler";
    private final boolean mBlockScroll;
    private final int mDisplayId;
    private boolean mEnable;
    private float mInitialScaleFactor;
    private final MagnificationDelegate mMagnificationDelegate;
    private final float mMaxScale;
    private final float mMinScale;
    private final ScaleGestureDetector mScaleGestureDetector;
    private boolean mScaling;
    private final float mScalingThreshold;
    private final GestureDetector mScrollGestureDetector;

    interface MagnificationDelegate {
        float getScale(int r1);

        boolean processScroll(int r1, float r2, float r3);

        void setScale(int r1, float r2);
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    PanningScalingHandler(Context context, float maxScale, float minScale, boolean blockScroll, MagnificationDelegate magnificationDelegate) {
        this.mInitialScaleFactor = -1.0f;
        this.mDisplayId = context.getDisplayId();
        this.mMaxScale = maxScale;
        this.mMinScale = minScale;
        this.mBlockScroll = blockScroll;
        this.mScaleGestureDetector = new ScaleGestureDetector(context, ViewConfiguration.get(context).getScaledTouchSlop() * 2, 0, Handler.getMain(), this);
        this.mScrollGestureDetector = new GestureDetector(context, this, Handler.getMain());
        this.mScaleGestureDetector.setQuickScaleEnabled(false);
        this.mMagnificationDelegate = magnificationDelegate;
        TypedValue scaleValue = new TypedValue();
        context.getResources().getValue(R.dimen.expanded_group_conversation_message_padding, scaleValue, false);
        this.mScalingThreshold = scaleValue.getFloat();
    }

    void setEnabled(boolean enable) {
        clear();
        this.mEnable = enable;
    }

    void onTouchEvent(MotionEvent motionEvent) {
        this.mScaleGestureDetector.onTouchEvent(motionEvent);
        this.mScrollGestureDetector.onTouchEvent(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        if (this.mEnable == true) goto L5;
        return true;
    L5:
        if (this.mBlockScroll == false) goto L10;
        if (this.mScaling == false) goto L10;
        return true;
    L10:
        return this.mMagnificationDelegate.processScroll(this.mDisplayId, distanceX, distanceY);
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector detector) {
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "onScale: triggered ");
    L5:
        boolean r2 = true;
        if (this.mScaling == false) goto L8;
        float initialScale = this.mMagnificationDelegate.getScale(this.mDisplayId);
        float targetScale = detector.getScaleFactor() * initialScale;
        if (targetScale > this.mMaxScale) goto L20;
    L22:
        float scale = this.mMinScale;
        if (targetScale < scale) goto L25;
    L27:
        float scale2 = targetScale;
    L29:
        if (DEBUG == false) goto L31;
        Slog.i(TAG, "Scaled content to: " + scale2 + "x");
    L31:
        this.mMagnificationDelegate.setScale(this.mDisplayId, scale2);
        return true;
    L25:
        if (targetScale >= initialScale) goto L27;
        scale2 = this.mMinScale;
        goto L29
    L20:
        if (targetScale <= initialScale) goto L22;
        scale2 = this.mMaxScale;
        goto L29
    L8:
        if (this.mInitialScaleFactor >= 0.0f) goto L11;
        this.mInitialScaleFactor = detector.getScaleFactor();
        return false;
    L11:
        float deltaScale = detector.getScaleFactor() - this.mInitialScaleFactor;
        if (Math.abs(deltaScale) > this.mScalingThreshold) goto L15;
        r2 = false;
    L15:
        this.mScaling = r2;
        return this.mScaling;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        return this.mEnable;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector detector) {
        clear();
    }

    void clear() {
        this.mInitialScaleFactor = -1.0f;
        this.mScaling = false;
    }

    public String toString() {
        return "PanningScalingHandler{mInitialScaleFactor=" + this.mInitialScaleFactor + ", mScaling=" + this.mScaling + '}';
    }
}
