package com.android.server.accessibility.magnification;

import android.content.Context;
import android.os.Handler;
import android.util.MathUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.android.server.accessibility.gestures.GestureMatcher;

/* JADX INFO: loaded from: classes.dex */
final class TwoFingersDownOrSwipe extends GestureMatcher {
    private final int mDetectionDurationMillis;
    private final int mDoubleTapTimeout;
    private MotionEvent mFirstPointerDown;
    private MotionEvent mSecondPointerDown;
    private final int mSwipeMinDistance;

    TwoFingersDownOrSwipe(Context context) {
        super(101, new Handler(context.getMainLooper()), null);
        this.mDetectionDurationMillis = MagnificationGestureMatcher.getMagnificationMultiTapTimeout(context);
        this.mDoubleTapTimeout = ViewConfiguration.getDoubleTapTimeout();
        this.mSwipeMinDistance = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onDown(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        this.mFirstPointerDown = MotionEvent.obtain(event);
        cancelAfter(this.mDetectionDurationMillis, event, rawEvent, policyFlags);
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onPointerDown(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (this.mFirstPointerDown != null) goto L6;
        cancelGesture(event, rawEvent, policyFlags);
    L6:
        if (event.getPointerCount() != 2) goto L8;
        this.mSecondPointerDown = MotionEvent.obtain(event);
        completeAfter(this.mDoubleTapTimeout, event, rawEvent, policyFlags);
        return;
    L8:
        cancelGesture(event, rawEvent, policyFlags);
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onMove(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (this.mFirstPointerDown != null) goto L5;
        return;
    L5:
        if (this.mSecondPointerDown != null) goto L8;
        return;
    L8:
        if (distance(this.mFirstPointerDown, event) <= this.mSwipeMinDistance) goto L12;
        completeGesture(event, rawEvent, policyFlags);
        return;
    L12:
        if (distance(this.mSecondPointerDown, event) <= this.mSwipeMinDistance) goto L16;
        completeGesture(event, rawEvent, policyFlags);
        return;
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onPointerUp(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        cancelGesture(event, rawEvent, policyFlags);
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onUp(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        cancelGesture(event, rawEvent, policyFlags);
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    public void clear() {
        if (this.mFirstPointerDown == null) goto L6;
        this.mFirstPointerDown.recycle();
        this.mFirstPointerDown = null;
    L6:
        if (this.mSecondPointerDown == null) goto L8;
        this.mSecondPointerDown.recycle();
        this.mSecondPointerDown = null;
    L8:
        super.clear();
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected String getGestureName() {
        return getClass().getSimpleName();
    }

    private static double distance(MotionEvent downEvent, MotionEvent moveEvent) {
        int downActionIndex = downEvent.getActionIndex();
        int downPointerId = downEvent.getPointerId(downActionIndex);
        int moveActionIndex = moveEvent.findPointerIndex(downPointerId);
        if (moveActionIndex >= 0) goto L7;
        return -1.0d;
    L7:
        return MathUtils.dist(downEvent.getX(downActionIndex), downEvent.getY(downActionIndex), moveEvent.getX(moveActionIndex), moveEvent.getY(moveActionIndex));
    }
}
