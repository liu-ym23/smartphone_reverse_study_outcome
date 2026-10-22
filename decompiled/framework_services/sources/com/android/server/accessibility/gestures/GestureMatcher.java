package com.android.server.accessibility.gestures;

import android.os.Handler;
import android.util.Slog;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public abstract class GestureMatcher {
    public static final int STATE_CLEAR = 0;
    public static final int STATE_GESTURE_CANCELED = 3;
    public static final int STATE_GESTURE_COMPLETED = 2;
    public static final int STATE_GESTURE_STARTED = 1;
    protected final DelayedTransition mDelayedTransition;
    private final int mGestureId;
    private final Handler mHandler;
    private StateChangeListener mListener;
    private int mState;

    protected final class DelayedTransition implements Runnable {
        private static final String LOG_TAG = "GestureMatcher.DelayedTransition";
        MotionEvent mEvent;
        int mPolicyFlags;
        MotionEvent mRawEvent;
        int mTargetState;
        final /* synthetic */ GestureMatcher this$0;

        protected DelayedTransition(GestureMatcher this$0) {
            this.this$0 = this$0;
        }

        public void cancel() {
            if (TouchExplorer.DEBUG == true) goto L5;
        L7:
            GestureMatcher.m752$$Nest$fgetmHandler(this.this$0).removeCallbacks(this);
            recycleEvent();
            return;
        L5:
            if (isPending() == false) goto L7;
            Slog.d(LOG_TAG, this.this$0.getGestureName() + ": canceling delayed transition to " + GestureMatcher.getStateSymbolicName(this.mTargetState));
            goto L7
        }

        public void post(int state, long delay, MotionEvent event, MotionEvent rawEvent, int policyFlags) {
            recycleEvent();
            this.mTargetState = state;
            this.mEvent = event.copy();
            this.mRawEvent = rawEvent.copy();
            this.mPolicyFlags = policyFlags;
            GestureMatcher.m752$$Nest$fgetmHandler(this.this$0).postDelayed(this, delay);
            if (TouchExplorer.DEBUG == false) goto L6;
            Slog.d(LOG_TAG, this.this$0.getGestureName() + ": posting delayed transition to " + GestureMatcher.getStateSymbolicName(this.mTargetState));
            return;
        }

        public boolean isPending() {
            return GestureMatcher.m752$$Nest$fgetmHandler(this.this$0).hasCallbacks(this);
        }

        public void forceSendAndRemove() {
            if (isPending() == false) goto L6;
            run();
            cancel();
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TouchExplorer.DEBUG == false) goto L5;
            Slog.d(LOG_TAG, this.this$0.getGestureName() + ": executing delayed transition to " + GestureMatcher.getStateSymbolicName(this.mTargetState));
        L5:
            GestureMatcher.m753$$Nest$msetState(this.this$0, this.mTargetState, this.mEvent, this.mRawEvent, this.mPolicyFlags);
            recycleEvent();
        }

        private void recycleEvent() {
            if (this.mEvent != null) goto L5;
            return;
        L5:
            if (this.mRawEvent == null) goto L10;
            this.mEvent.recycle();
            this.mRawEvent.recycle();
            this.mEvent = null;
            this.mRawEvent = null;
            return;
        }
    }

    public @interface State {
    }

    public interface StateChangeListener {
        void onStateChanged(int r1, int r2, MotionEvent r3, MotionEvent r4, int r5);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m752$$Nest$fgetmHandler(GestureMatcher r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$msetState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m753$$Nest$msetState(GestureMatcher r0, int r1, MotionEvent r2, MotionEvent r3, int r4) {
        r0.setState(r1, r2, r3, r4);
    }

    protected abstract String getGestureName();

    protected GestureMatcher(int gestureId, Handler handler, StateChangeListener listener) {
        this.mState = 0;
        this.mGestureId = gestureId;
        this.mHandler = handler;
        this.mDelayedTransition = new DelayedTransition(this);
        this.mListener = listener;
    }

    public void clear() {
        this.mState = 0;
        cancelPendingTransitions();
    }

    public final int getState() {
        return this.mState;
    }

    private void setState(int state, MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        this.mState = state;
        cancelPendingTransitions();
        if (this.mListener == null) goto L6;
        this.mListener.onStateChanged(this.mGestureId, this.mState, event, rawEvent, policyFlags);
        return;
    }

    protected final void startGesture(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        setState(1, event, rawEvent, policyFlags);
    }

    protected final void cancelGesture(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        setState(3, event, rawEvent, policyFlags);
    }

    protected final void completeGesture(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        setState(2, event, rawEvent, policyFlags);
    }

    public final void setListener(StateChangeListener listener) {
        this.mListener = listener;
    }

    public int getGestureId() {
        return this.mGestureId;
    }

    public final int onMotionEvent(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (this.mState == 3) goto L18;
        if (this.mState == 2) goto L18;
        switch(event.getActionMasked()) {
            case 0: goto L14;
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L11;
            case 6: goto L10;
            default: goto L9;
        };
    L9:
        setState(3, event, rawEvent, policyFlags);
    L16:
        return this.mState;
    L10:
        onPointerUp(event, rawEvent, policyFlags);
        goto L16
    L11:
        onPointerDown(event, rawEvent, policyFlags);
        goto L16
    L12:
        onMove(event, rawEvent, policyFlags);
        goto L16
    L13:
        onUp(event, rawEvent, policyFlags);
        goto L16
    L14:
        onDown(event, rawEvent, policyFlags);
    L18:
        return this.mState;
    }

    protected void onDown(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
    }

    protected void onPointerDown(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
    }

    protected void onMove(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
    }

    protected void onPointerUp(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
    }

    protected void onUp(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
    }

    protected void cancelAfterTapTimeout(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        cancelAfter(ViewConfiguration.getTapTimeout(), event, rawEvent, policyFlags);
    }

    protected final void cancelAfterDoubleTapTimeout(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        cancelAfter(ViewConfiguration.getDoubleTapTimeout(), event, rawEvent, policyFlags);
    }

    protected final void cancelAfter(long timeout, MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        this.mDelayedTransition.cancel();
        this.mDelayedTransition.post(3, timeout, event, rawEvent, policyFlags);
    }

    protected final void cancelPendingTransitions() {
        this.mDelayedTransition.cancel();
    }

    protected final void completeAfterLongPressTimeout(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        completeAfter(ViewConfiguration.getLongPressTimeout(), event, rawEvent, policyFlags);
    }

    protected final void completeAfterTapTimeout(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        completeAfter(ViewConfiguration.getTapTimeout(), event, rawEvent, policyFlags);
    }

    protected final void completeAfter(long timeout, MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        this.mDelayedTransition.cancel();
        this.mDelayedTransition.post(2, timeout, event, rawEvent, policyFlags);
    }

    protected final void completeAfterDoubleTapTimeout(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        completeAfter(ViewConfiguration.getDoubleTapTimeout(), event, rawEvent, policyFlags);
    }

    static String getStateSymbolicName(int state) {
        switch(state) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L4;
        };
    L5:
        return "STATE_GESTURE_CANCELED";
    L7:
        return "STATE_GESTURE_COMPLETED";
    L9:
        return "STATE_GESTURE_STARTED";
    L11:
        return "STATE_CLEAR";
    L4:
        return "Unknown state: " + state;
    }

    public String toString() {
        return getGestureName() + ":" + getStateSymbolicName(this.mState);
    }
}
