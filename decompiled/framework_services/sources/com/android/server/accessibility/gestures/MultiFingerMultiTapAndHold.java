package com.android.server.accessibility.gestures;

import android.content.Context;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public class MultiFingerMultiTapAndHold extends MultiFingerMultiTap {
    public MultiFingerMultiTapAndHold(Context context, int fingers, int taps, int gestureId, GestureMatcher.StateChangeListener listener) {
        super(context, fingers, taps, gestureId, listener);
    }

    @Override // com.android.server.accessibility.gestures.MultiFingerMultiTap, com.android.server.accessibility.gestures.GestureMatcher
    protected void onPointerDown(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        super.onPointerDown(event, rawEvent, policyFlags);
        if (this.mIsTargetFingerCountReached == true) goto L5;
        return;
    L5:
        if ((this.mCompletedTapCount + 1) != this.mTargetTapCount) goto L9;
        completeAfterLongPressTimeout(event, rawEvent, policyFlags);
        return;
    }

    @Override // com.android.server.accessibility.gestures.MultiFingerMultiTap, com.android.server.accessibility.gestures.GestureMatcher
    protected void onUp(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if ((this.mCompletedTapCount + 1) != this.mTargetTapCount) goto L5;
        cancelGesture(event, rawEvent, policyFlags);
        return;
    L5:
        super.onUp(event, rawEvent, policyFlags);
        cancelAfterDoubleTapTimeout(event, rawEvent, policyFlags);
    }

    @Override // com.android.server.accessibility.gestures.MultiFingerMultiTap, com.android.server.accessibility.gestures.GestureMatcher
    public String getGestureName() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.mTargetFingerCount);
        builder.append("-Finger ");
        if (this.mTargetTapCount != 1) goto L6;
        builder.append("Single");
    L14:
        builder.append(" Tap and hold");
        return builder.toString();
    L6:
        if (this.mTargetTapCount != 2) goto L9;
        builder.append("Double");
        goto L14
    L9:
        if (this.mTargetTapCount != 3) goto L12;
        builder.append("Triple");
        goto L14
    L12:
        if (this.mTargetTapCount <= 3) goto L14;
        builder.append(this.mTargetTapCount);
        goto L14
    }
}
