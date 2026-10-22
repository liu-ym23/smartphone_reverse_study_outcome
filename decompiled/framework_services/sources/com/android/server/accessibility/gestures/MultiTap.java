package com.android.server.accessibility.gestures;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public class MultiTap extends GestureMatcher {
    public static final int MAX_TAPS = 10;
    float mBaseX;
    float mBaseY;
    int mCurrentTaps;
    int mDoubleTapSlop;
    int mDoubleTapTimeout;
    int mTapTimeout;
    final int mTargetTaps;
    int mTouchSlop;

    public MultiTap(Context context, int taps, int gesture, GestureMatcher.StateChangeListener listener) {
        this(context, taps, gesture, ViewConfiguration.getDoubleTapTimeout(), listener);
    }

    public MultiTap(Context context, int taps, int gesture, int multiTapTimeout, GestureMatcher.StateChangeListener listener) {
        super(gesture, new Handler(context.getMainLooper()), listener);
        this.mTargetTaps = taps;
        this.mDoubleTapTimeout = multiTapTimeout;
        this.mDoubleTapSlop = ViewConfiguration.get(context).getScaledDoubleTapSlop();
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mTapTimeout = ViewConfiguration.getTapTimeout();
        clear();
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    public void clear() {
        this.mCurrentTaps = 0;
        this.mBaseX = Float.NaN;
        this.mBaseY = Float.NaN;
        super.clear();
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onDown(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        cancelAfterTapTimeout(event, rawEvent, policyFlags);
        if (Float.isNaN(this.mBaseX) == false) goto L8;
        if (Float.isNaN(this.mBaseY) == false) goto L8;
        this.mBaseX = event.getX();
        this.mBaseY = event.getY();
    L8:
        if (isInsideSlop(rawEvent, this.mDoubleTapSlop) == true) goto L10;
        cancelGesture(event, rawEvent, policyFlags);
    L10:
        this.mBaseX = event.getX();
        this.mBaseY = event.getY();
        if ((this.mCurrentTaps + 1) != this.mTargetTaps) goto L14;
        startGesture(event, rawEvent, policyFlags);
        return;
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onUp(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        cancelPendingTransitions();
        if (isInsideSlop(rawEvent, this.mTouchSlop) == true) goto L6;
        cancelGesture(event, rawEvent, policyFlags);
    L6:
        if (getState() != 1) goto L8;
    L11:
        this.mCurrentTaps++;
        if (this.mCurrentTaps != this.mTargetTaps) goto L15;
        completeGesture(event, rawEvent, policyFlags);
        return;
    L15:
        cancelAfterDoubleTapTimeout(event, rawEvent, policyFlags);
        return;
    L8:
        if (getState() == 0) goto L11;
        cancelGesture(event, rawEvent, policyFlags);
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onMove(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (isInsideSlop(rawEvent, this.mTouchSlop) == true) goto L6;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onPointerDown(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        cancelGesture(event, rawEvent, policyFlags);
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onPointerUp(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        cancelGesture(event, rawEvent, policyFlags);
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    public String getGestureName() {
        switch(this.mTargetTaps) {
            case 2: goto L8;
            case 3: goto L6;
            default: goto L5;
        };
    L6:
        return "Triple Tap";
    L8:
        return "Double Tap";
    L5:
        return Integer.toString(this.mTargetTaps) + " Taps";
    }

    private boolean isInsideSlop(MotionEvent rawEvent, int slop) {
        float deltaX = this.mBaseX - rawEvent.getX();
        float deltaY = this.mBaseY - rawEvent.getY();
        if (deltaX == 0.0f) goto L5;
    L7:
        double moveDelta = Math.hypot(deltaX, deltaY);
        if (moveDelta <= slop) goto L12;
        return false;
    L12:
        return true;
    L5:
        if (deltaY != 0.0f) goto L7;
        return true;
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    public String toString() {
        return super.toString() + ", Taps:" + this.mCurrentTaps + ", mBaseX: " + Float.toString(this.mBaseX) + ", mBaseY: " + Float.toString(this.mBaseY);
    }
}
