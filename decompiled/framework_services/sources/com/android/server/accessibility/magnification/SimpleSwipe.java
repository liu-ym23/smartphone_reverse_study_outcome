package com.android.server.accessibility.magnification;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.android.server.accessibility.gestures.GestureMatcher;
import com.android.server.accessibility.gestures.GestureUtils;

/* JADX INFO: loaded from: classes.dex */
class SimpleSwipe extends GestureMatcher {
    private final int mDetectionDurationMillis;
    private MotionEvent mLastDown;
    private final int mSwipeMinDistance;

    SimpleSwipe(Context context) {
        super(102, new Handler(context.getMainLooper()), null);
        this.mSwipeMinDistance = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mDetectionDurationMillis = MagnificationGestureMatcher.getMagnificationMultiTapTimeout(context);
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onDown(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        this.mLastDown = MotionEvent.obtain(event);
        cancelAfter(this.mDetectionDurationMillis, event, rawEvent, policyFlags);
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onPointerDown(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        cancelGesture(event, rawEvent, policyFlags);
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onMove(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (gestureMatched(event, rawEvent, policyFlags) == false) goto L6;
        completeGesture(event, rawEvent, policyFlags);
        return;
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected void onUp(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (gestureMatched(event, rawEvent, policyFlags) == false) goto L5;
        completeGesture(event, rawEvent, policyFlags);
        return;
    L5:
        cancelGesture(event, rawEvent, policyFlags);
    }

    private boolean gestureMatched(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (this.mLastDown != null) goto L5;
    L7:
        return false;
    L5:
        if (GestureUtils.distance(this.mLastDown, event) <= this.mSwipeMinDistance) goto L7;
        return true;
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    public void clear() {
        if (this.mLastDown == null) goto L5;
        this.mLastDown.recycle();
    L5:
        this.mLastDown = null;
        super.clear();
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher
    protected String getGestureName() {
        return getClass().getSimpleName();
    }
}
