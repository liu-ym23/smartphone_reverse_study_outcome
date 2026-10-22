package com.android.server.accessibility.magnification;

import android.R;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class MotionEventDispatcherDelegate {
    private static final boolean DBG = false;
    private static final String TAG = null;
    private final EventDispatcher mEventDispatcher;
    private long mLastDelegatedDownEventTime;
    private final int mMultiTapMaxDelay;

    interface EventDispatcher {
        void dispatchMotionEvent(MotionEvent r1, MotionEvent r2, int r3);
    }

    static {
        TAG = MotionEventDispatcherDelegate.class.getSimpleName();
        DBG = Log.isLoggable(TAG, 3);
    }

    MotionEventDispatcherDelegate(Context context, EventDispatcher eventDispatcher) {
        this.mEventDispatcher = eventDispatcher;
        this.mMultiTapMaxDelay = ViewConfiguration.getDoubleTapTimeout() + context.getResources().getInteger(R.integer.config_sideFpsToastTimeout);
    }

    void sendDelayedMotionEvents(List<MotionEventInfo> delayedEventQueue, long lastDetectingDownEventTime) {
        if (delayedEventQueue != null) goto L4;
        return;
    L4:
        long offset = Math.min(SystemClock.uptimeMillis() - lastDetectingDownEventTime, this.mMultiTapMaxDelay);
        Iterator<MotionEventInfo> r2 = delayedEventQueue.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        MotionEventInfo info = r2.next();
        info.mEvent.setDownTime(info.mEvent.getDownTime() + offset);
        dispatchMotionEvent(info.mEvent, info.mRawEvent, info.mPolicyFlags);
        info.recycle();
        goto L6
    }

    void dispatchMotionEvent(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (event.getActionMasked() != 0) goto L8;
        this.mLastDelegatedDownEventTime = event.getDownTime();
        if (DBG == false) goto L8;
        Log.d(TAG, "dispatchMotionEvent mLastDelegatedDownEventTime time = " + this.mLastDelegatedDownEventTime);
    L8:
        if (DBG == false) goto L10;
        Log.d(TAG, "dispatchMotionEvent original down time = " + event.getDownTime());
    L10:
        event.setDownTime(this.mLastDelegatedDownEventTime);
        this.mEventDispatcher.dispatchMotionEvent(event, rawEvent, policyFlags);
    }
}
