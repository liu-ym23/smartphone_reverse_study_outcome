package com.android.server.accessibility.gestures;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
class SecondFingerMultiTap extends GestureMatcher {
    float mBaseX;
    float mBaseY;
    int mCurrentTaps;
    int mDoubleTapSlop;
    int mDoubleTapTimeout;
    int mSecondFingerPointerId;
    int mTapTimeout;
    final int mTargetTaps;
    int mTouchSlop;

    SecondFingerMultiTap(Context context, int taps, int gesture, GestureMatcher.StateChangeListener listener) {
        super(gesture, new Handler(context.getMainLooper()), listener);
        this.mTargetTaps = taps;
        this.mDoubleTapSlop = ViewConfiguration.get(context).getScaledDoubleTapSlop();
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mTapTimeout = ViewConfiguration.getTapTimeout();
        this.mDoubleTapTimeout = ViewConfiguration.getDoubleTapTimeout();
        clear();
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    public void clear() {
        this.mCurrentTaps = 0;
        this.mBaseX = Float.NaN;
        this.mBaseY = Float.NaN;
        this.mSecondFingerPointerId = -1;
        super.clear();
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onPointerDown(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (event.getPointerCount() <= 2) goto L6;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L6:
        int index = GestureUtils.getActionIndex(event);
        this.mSecondFingerPointerId = event.getPointerId(index);
        cancelAfterTapTimeout(event, rawEvent, policyFlags);
        if (Float.isNaN(this.mBaseX) == false) goto L12;
        if (Float.isNaN(this.mBaseY) == false) goto L12;
        this.mBaseX = event.getX();
        this.mBaseY = event.getY();
    L12:
        if (isSecondFingerInsideSlop(rawEvent, this.mDoubleTapSlop) == true) goto L14;
        cancelGesture(event, rawEvent, policyFlags);
    L14:
        this.mBaseX = event.getX();
        this.mBaseY = event.getY();
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onPointerUp(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (event.getPointerCount() <= 2) goto L6;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L6:
        cancelAfterDoubleTapTimeout(event, rawEvent, policyFlags);
        if (isSecondFingerInsideSlop(rawEvent, this.mTouchSlop) == true) goto L10;
        cancelGesture(event, rawEvent, policyFlags);
    L10:
        if (getState() != 1) goto L12;
    L15:
        this.mCurrentTaps++;
        if (this.mCurrentTaps != this.mTargetTaps) goto L19;
        completeGesture(event, rawEvent, policyFlags);
        return;
    L19:
        cancelAfterDoubleTapTimeout(event, rawEvent, policyFlags);
        return;
    L12:
        if (getState() == 0) goto L15;
        cancelGesture(event, rawEvent, policyFlags);
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onMove(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        switch(event.getPointerCount()) {
            case 1: goto L12;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L12:
        return;
    L6:
        if (isSecondFingerInsideSlop(rawEvent, this.mTouchSlop) == true) goto L10;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onUp(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
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
        return "Second Finger Triple Tap";
    L8:
        return "Second Finger Double Tap";
    L5:
        return "Second Finger " + Integer.toString(this.mTargetTaps) + " Taps";
    }

    private boolean isSecondFingerInsideSlop(MotionEvent rawEvent, int slop) {
        int pointerIndex = rawEvent.findPointerIndex(this.mSecondFingerPointerId);
        if (pointerIndex != (-1)) goto L5;
        return false;
    L5:
        float deltaX = this.mBaseX - rawEvent.getX(pointerIndex);
        float deltaY = this.mBaseY - rawEvent.getY(pointerIndex);
        if (deltaX == 0.0f) goto L8;
    L10:
        double moveDelta = Math.hypot(deltaX, deltaY);
        if (moveDelta <= slop) goto L13;
        return false;
    L13:
        return true;
    L8:
        if (deltaY != 0.0f) goto L10;
        return true;
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    public String toString() {
        return super.toString() + ", Taps:" + this.mCurrentTaps + ", mBaseX: " + Float.toString(this.mBaseX) + ", mBaseY: " + Float.toString(this.mBaseY);
    }
}
