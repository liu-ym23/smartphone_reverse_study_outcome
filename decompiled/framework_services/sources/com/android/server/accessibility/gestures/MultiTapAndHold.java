package com.android.server.accessibility.gestures;

import android.content.Context;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public class MultiTapAndHold extends MultiTap {
    public MultiTapAndHold(Context context, int taps, int gesture, GestureMatcher.StateChangeListener listener) {
        super(context, taps, gesture, listener);
    }

    public MultiTapAndHold(Context context, int taps, int gesture, int multiTapTimeout, GestureMatcher.StateChangeListener listener) {
        super(context, taps, gesture, multiTapTimeout, listener);
    }

    @Override // com.android.server.accessibility.gestures.MultiTap, com.android.server.accessibility.gestures.GestureMatcher
    protected void onDown(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        super.onDown(event, rawEvent, policyFlags);
        if ((this.mCurrentTaps + 1) != this.mTargetTaps) goto L6;
        completeAfterLongPressTimeout(event, rawEvent, policyFlags);
        return;
    }

    @Override // com.android.server.accessibility.gestures.MultiTap, com.android.server.accessibility.gestures.GestureMatcher
    protected void onUp(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        super.onUp(event, rawEvent, policyFlags);
    }

    @Override // com.android.server.accessibility.gestures.MultiTap, com.android.server.accessibility.gestures.GestureMatcher
    public String getGestureName() {
        switch(this.mTargetTaps) {
            case 2: goto L8;
            case 3: goto L6;
            default: goto L5;
        };
    L6:
        return "Triple Tap and Hold";
    L8:
        return "Double Tap and Hold";
    L5:
        return Integer.toString(this.mTargetTaps) + " Taps and Hold";
    }
}
