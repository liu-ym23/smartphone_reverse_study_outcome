package com.android.server.accessibility.magnification;

import android.util.Log;
import android.util.Slog;
import android.view.MotionEvent;
import com.android.server.accessibility.gestures.GestureMatcher;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class MagnificationGesturesObserver implements GesturesObserver.Listener {
    private static final boolean DBG = false;
    private static final String LOG_TAG = "MagnificationGesturesObserver";
    private final Callback mCallback;
    private List<MotionEventInfo> mDelayedEventQueue;
    private final GesturesObserver mGesturesObserver;
    private long mLastDownEventTime;
    private MotionEvent mLastEvent;

    interface Callback {
        void onGestureCancelled(long r1, List<MotionEventInfo> r3, MotionEvent r4);

        void onGestureCompleted(int r1, long r2, List<MotionEventInfo> r4, MotionEvent r5);

        boolean shouldStopDetection(MotionEvent r1);
    }

    static {
        DBG = Log.isLoggable(LOG_TAG, 3);
    }

    MagnificationGesturesObserver(Callback callback, GestureMatcher... matchers) {
        this.mLastDownEventTime = 0;
        this.mGesturesObserver = new GesturesObserver(this, matchers);
        this.mCallback = callback;
    }

    boolean onMotionEvent(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (DBG == false) goto L5;
        Slog.d(LOG_TAG, "DetectGesture: event = " + event);
    L5:
        cacheDelayedMotionEvent(event, rawEvent, policyFlags);
        if (this.mCallback.shouldStopDetection(event) == false) goto L10;
        notifyDetectionCancel();
        return false;
    L10:
        if (event.getActionMasked() != 0) goto L13;
        this.mLastDownEventTime = event.getDownTime();
    L13:
        return this.mGesturesObserver.onMotionEvent(event, rawEvent, policyFlags);
    }

    @Override // com.android.server.accessibility.magnification.GesturesObserver.Listener
    public void onGestureCompleted(int gestureId, MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (DBG == false) goto L5;
        Slog.d(LOG_TAG, "onGestureCompleted: " + MagnificationGestureMatcher.gestureIdToString(gestureId) + " event = " + event);
    L5:
        List<MotionEventInfo> delayEventQueue = this.mDelayedEventQueue;
        this.mDelayedEventQueue = null;
        this.mCallback.onGestureCompleted(gestureId, this.mLastDownEventTime, delayEventQueue, event);
        clear();
    }

    @Override // com.android.server.accessibility.magnification.GesturesObserver.Listener
    public void onGestureCancelled(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (DBG == false) goto L5;
        Slog.d(LOG_TAG, "onGestureCancelled:  event = " + event);
    L5:
        notifyDetectionCancel();
    }

    private void notifyDetectionCancel() {
        List<MotionEventInfo> delayEventQueue = this.mDelayedEventQueue;
        this.mDelayedEventQueue = null;
        this.mCallback.onGestureCancelled(this.mLastDownEventTime, delayEventQueue, this.mLastEvent);
        clear();
    }

    private void clear() {
        if (DBG == false) goto L5;
        Slog.d(LOG_TAG, "clear:" + this.mDelayedEventQueue);
    L5:
        recycleLastEvent();
        this.mLastDownEventTime = 0;
        if (this.mDelayedEventQueue == null) goto L14;
        Iterator<MotionEventInfo> r0 = this.mDelayedEventQueue.iterator();
    L9:
        if (r0.hasNext() == false) goto L11;
        MotionEventInfo eventInfo2 = r0.next();
        eventInfo2.recycle();
        goto L9
    L11:
        this.mDelayedEventQueue.clear();
        this.mDelayedEventQueue = null;
        return;
    }

    private void recycleLastEvent() {
        if (this.mLastEvent != null) goto L5;
        return;
    L5:
        this.mLastEvent.recycle();
        this.mLastEvent = null;
    }

    private void cacheDelayedMotionEvent(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        this.mLastEvent = MotionEvent.obtain(event);
        MotionEventInfo info = MotionEventInfo.obtain(event, rawEvent, policyFlags);
        if (this.mDelayedEventQueue != null) goto L5;
        this.mDelayedEventQueue = new LinkedList();
    L5:
        this.mDelayedEventQueue.add(info);
    }

    public String toString() {
        return "MagnificationGesturesObserver{mDelayedEventQueue=" + this.mDelayedEventQueue + '}';
    }
}
