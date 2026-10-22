package com.android.server.accessibility.magnification;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
final class MotionEventInfo {
    public MotionEvent mEvent;
    public int mPolicyFlags;
    public MotionEvent mRawEvent;

    static MotionEventInfo obtain(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        return new MotionEventInfo(MotionEvent.obtain(event), MotionEvent.obtain(rawEvent), policyFlags);
    }

    MotionEventInfo(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        this.mEvent = event;
        this.mRawEvent = rawEvent;
        this.mPolicyFlags = policyFlags;
    }

    void recycle() {
        this.mEvent = recycleAndNullify(this.mEvent);
        this.mRawEvent = recycleAndNullify(this.mRawEvent);
    }

    public String toString() {
        return MotionEvent.actionToString(this.mEvent.getAction()).replace("ACTION_", "");
    }

    private static MotionEvent recycleAndNullify(MotionEvent event) {
        if (event == null) goto L6;
        event.recycle();
        return null;
    L6:
        return null;
    }
}
