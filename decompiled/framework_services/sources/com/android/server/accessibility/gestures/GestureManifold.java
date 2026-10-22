package com.android.server.accessibility.gestures;

import android.accessibilityservice.AccessibilityGestureEvent;
import android.content.Context;
import android.os.Handler;
import android.util.Slog;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GestureManifold implements GestureMatcher.StateChangeListener {
    private static final String LOG_TAG = "GestureManifold";
    private final Context mContext;
    private List<MotionEvent> mEvents;
    private final List<GestureMatcher> mGestures;
    private final Handler mHandler;
    private Listener mListener;
    private final List<GestureMatcher> mMultiFingerGestures;
    boolean mMultiFingerGesturesEnabled;
    private boolean mSendMotionEventsEnabled;
    private boolean mServiceHandlesDoubleTap;
    private TouchState mState;
    private boolean mTwoFingerPassthroughEnabled;
    private final List<GestureMatcher> mTwoFingerSwipes;

    public interface Listener {
        boolean onDoubleTap(MotionEvent r1, MotionEvent r2, int r3);

        void onDoubleTapAndHold(MotionEvent r1, MotionEvent r2, int r3);

        boolean onGestureCancelled(MotionEvent r1, MotionEvent r2, int r3);

        boolean onGestureCompleted(AccessibilityGestureEvent r1);

        boolean onGestureStarted();
    }

    public GestureManifold(Context context, Listener listener, TouchState state, Handler handler) {
        this.mGestures = new ArrayList();
        this.mServiceHandlesDoubleTap = false;
        this.mSendMotionEventsEnabled = false;
        this.mMultiFingerGestures = new ArrayList();
        this.mTwoFingerSwipes = new ArrayList();
        this.mEvents = new ArrayList();
        this.mContext = context;
        this.mHandler = handler;
        this.mListener = listener;
        this.mState = state;
        this.mMultiFingerGesturesEnabled = false;
        this.mTwoFingerPassthroughEnabled = false;
        this.mGestures.add(new MultiTap(context, 2, 17, this));
        this.mGestures.add(new MultiTapAndHold(context, 2, 18, this));
        this.mGestures.add(new SecondFingerMultiTap(context, 2, 17, this));
        this.mGestures.add(new Swipe(context, 1, 4, this));
        this.mGestures.add(new Swipe(context, 0, 3, this));
        this.mGestures.add(new Swipe(context, 2, 1, this));
        this.mGestures.add(new Swipe(context, 3, 2, this));
        this.mGestures.add(new Swipe(context, 0, 1, 5, this));
        this.mGestures.add(new Swipe(context, 0, 2, 9, this));
        this.mGestures.add(new Swipe(context, 0, 3, 10, this));
        this.mGestures.add(new Swipe(context, 1, 2, 11, this));
        this.mGestures.add(new Swipe(context, 1, 3, 12, this));
        this.mGestures.add(new Swipe(context, 1, 0, 6, this));
        this.mGestures.add(new Swipe(context, 3, 2, 8, this));
        this.mGestures.add(new Swipe(context, 3, 0, 15, this));
        this.mGestures.add(new Swipe(context, 3, 1, 16, this));
        this.mGestures.add(new Swipe(context, 2, 3, 7, this));
        this.mGestures.add(new Swipe(context, 2, 0, 13, this));
        this.mGestures.add(new Swipe(context, 2, 1, 14, this));
        this.mMultiFingerGestures.add(new MultiFingerMultiTap(this.mContext, 2, 1, 19, this));
        this.mMultiFingerGestures.add(new MultiFingerMultiTap(this.mContext, 2, 2, 20, this));
        this.mMultiFingerGestures.add(new MultiFingerMultiTapAndHold(this.mContext, 2, 2, 40, this));
        this.mMultiFingerGestures.add(new MultiFingerMultiTap(this.mContext, 2, 3, 21, this));
        this.mMultiFingerGestures.add(new MultiFingerMultiTapAndHold(this.mContext, 2, 3, 43, this));
        this.mMultiFingerGestures.add(new MultiFingerMultiTap(this.mContext, 3, 1, 22, this));
        this.mMultiFingerGestures.add(new MultiFingerMultiTap(this.mContext, 3, 2, 23, this));
        this.mMultiFingerGestures.add(new MultiFingerMultiTapAndHold(this.mContext, 3, 1, 44, this));
        this.mMultiFingerGestures.add(new MultiFingerMultiTapAndHold(this.mContext, 3, 2, 41, this));
        this.mMultiFingerGestures.add(new MultiFingerMultiTap(this.mContext, 3, 3, 24, this));
        this.mMultiFingerGestures.add(new MultiFingerMultiTapAndHold(this.mContext, 3, 3, 45, this));
        this.mMultiFingerGestures.add(new MultiFingerMultiTap(this.mContext, 3, 3, 24, this));
        this.mMultiFingerGestures.add(new MultiFingerMultiTap(this.mContext, 4, 1, 37, this));
        this.mMultiFingerGestures.add(new MultiFingerMultiTap(this.mContext, 4, 2, 38, this));
        this.mMultiFingerGestures.add(new MultiFingerMultiTapAndHold(this.mContext, 4, 2, 42, this));
        this.mMultiFingerGestures.add(new MultiFingerMultiTap(this.mContext, 4, 3, 39, this));
        this.mTwoFingerSwipes.add(new MultiFingerSwipe(context, 2, 3, 26, this));
        this.mTwoFingerSwipes.add(new MultiFingerSwipe(context, 2, 0, 27, this));
        this.mTwoFingerSwipes.add(new MultiFingerSwipe(context, 2, 1, 28, this));
        this.mTwoFingerSwipes.add(new MultiFingerSwipe(context, 2, 2, 25, this));
        this.mMultiFingerGestures.addAll(this.mTwoFingerSwipes);
        this.mMultiFingerGestures.add(new MultiFingerSwipe(context, 3, 3, 30, this));
        this.mMultiFingerGestures.add(new MultiFingerSwipe(context, 3, 0, 31, this));
        this.mMultiFingerGestures.add(new MultiFingerSwipe(context, 3, 1, 32, this));
        this.mMultiFingerGestures.add(new MultiFingerSwipe(context, 3, 2, 29, this));
        this.mMultiFingerGestures.add(new MultiFingerSwipe(context, 4, 3, 34, this));
        this.mMultiFingerGestures.add(new MultiFingerSwipe(context, 4, 0, 35, this));
        this.mMultiFingerGestures.add(new MultiFingerSwipe(context, 4, 1, 36, this));
        this.mMultiFingerGestures.add(new MultiFingerSwipe(context, 4, 2, 33, this));
    }

    public boolean onMotionEvent(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (this.mState.isClear() == false) goto L9;
        if (event.getActionMasked() != 0) goto L7;
        clear();
        goto L9
    L7:
        return false;
    L9:
        if (this.mSendMotionEventsEnabled == false) goto L11;
        this.mEvents.add(MotionEvent.obtainNoHistory(rawEvent));
    L11:
        Iterator<GestureMatcher> r0 = this.mGestures.iterator();
    L13:
        if (r0.hasNext() == false) goto L27;
        GestureMatcher matcher = r0.next();
        if (matcher.getState() == 3) goto L13;
        if (TouchExplorer.DEBUG == false) goto L19;
        Slog.d(LOG_TAG, matcher.toString());
    L19:
        matcher.onMotionEvent(event, rawEvent, policyFlags);
        if (TouchExplorer.DEBUG == false) goto L23;
        Slog.d(LOG_TAG, matcher.toString());
    L23:
        if (matcher.getState() != 2) goto L13;
        return true;
    L27:
        return false;
    }

    public void clear() {
        Iterator<GestureMatcher> r0 = this.mGestures.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        GestureMatcher matcher = r0.next();
        matcher.clear();
        goto L4
    L7:
        if (this.mEvents != null) goto L9;
        return;
    L9:
        if (this.mEvents.size() <= 0) goto L14;
        this.mEvents.remove(0).recycle();
        goto L9
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher.StateChangeListener
    public void onStateChanged(int gestureId, int state, MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (state != 1) goto L16;
        if (this.mState.isGestureDetecting() == true) goto L16;
        if (gestureId == 17) goto L13;
        if (gestureId == 18) goto L13;
        this.mListener.onGestureStarted();
        return;
    L13:
        if (this.mServiceHandlesDoubleTap == false) goto L38;
        this.mListener.onGestureStarted();
        return;
    L38:
        return;
    L16:
        if (state != 2) goto L19;
        onGestureCompleted(gestureId, event, rawEvent, policyFlags);
        return;
    L19:
        if (state == 3) goto L21;
        return;
    L21:
        if (this.mState.isGestureDetecting() == false) goto L42;
        Iterator<GestureMatcher> r1 = this.mGestures.iterator();
    L24:
        if (r1.hasNext() == false) goto L30;
        GestureMatcher matcher = r1.next();
        if (matcher.getState() != 1) goto L24;
        return;
    L30:
        if (TouchExplorer.DEBUG == false) goto L32;
        Slog.d(LOG_TAG, "Cancelling.");
    L32:
        this.mListener.onGestureCancelled(event, rawEvent, policyFlags);
        return;
    }

    private void onGestureCompleted(int gestureId, MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        switch(gestureId) {
            case 17: goto L9;
            case 18: goto L5;
            default: goto L3;
        };
    L3:
        AccessibilityGestureEvent gestureEvent = new AccessibilityGestureEvent(gestureId, event.getDisplayId(), this.mEvents);
        this.mListener.onGestureCompleted(gestureEvent);
    L12:
        clear();
        return;
    L5:
        if (this.mServiceHandlesDoubleTap == false) goto L7;
        AccessibilityGestureEvent gestureEvent2 = new AccessibilityGestureEvent(gestureId, event.getDisplayId(), this.mEvents);
        this.mListener.onGestureCompleted(gestureEvent2);
        goto L12
    L7:
        this.mListener.onDoubleTapAndHold(event, rawEvent, policyFlags);
        goto L12
    L9:
        if (this.mServiceHandlesDoubleTap == false) goto L11;
        AccessibilityGestureEvent gestureEvent3 = new AccessibilityGestureEvent(gestureId, event.getDisplayId(), this.mEvents);
        this.mListener.onGestureCompleted(gestureEvent3);
        goto L12
    L11:
        this.mListener.onDoubleTap(event, rawEvent, policyFlags);
        goto L12
    }

    public boolean isMultiFingerGesturesEnabled() {
        return this.mMultiFingerGesturesEnabled;
    }

    public void setMultiFingerGesturesEnabled(boolean mode) {
        if (this.mMultiFingerGesturesEnabled == mode) goto L9;
        this.mMultiFingerGesturesEnabled = mode;
        if (mode == false) goto L7;
        this.mGestures.addAll(this.mMultiFingerGestures);
        return;
    L7:
        this.mGestures.removeAll(this.mMultiFingerGestures);
        return;
    }

    public boolean isTwoFingerPassthroughEnabled() {
        return this.mTwoFingerPassthroughEnabled;
    }

    public void setTwoFingerPassthroughEnabled(boolean mode) {
        if (this.mTwoFingerPassthroughEnabled == mode) goto L11;
        this.mTwoFingerPassthroughEnabled = mode;
        if (mode == true) goto L9;
        this.mMultiFingerGestures.addAll(this.mTwoFingerSwipes);
        if (this.mMultiFingerGesturesEnabled == false) goto L12;
        this.mGestures.addAll(this.mTwoFingerSwipes);
        return;
    L12:
        return;
    L9:
        this.mMultiFingerGestures.removeAll(this.mTwoFingerSwipes);
        this.mGestures.removeAll(this.mTwoFingerSwipes);
        return;
    }

    public void setServiceHandlesDoubleTap(boolean mode) {
        this.mServiceHandlesDoubleTap = mode;
    }

    public boolean isServiceHandlesDoubleTapEnabled() {
        return this.mServiceHandlesDoubleTap;
    }

    public void setSendMotionEventsEnabled(boolean mode) {
        this.mSendMotionEventsEnabled = mode;
        if (mode == false) goto L5;
        return;
    L5:
        if (this.mEvents.size() <= 0) goto L9;
        this.mEvents.remove(0).recycle();
        goto L5
    }

    public boolean isSendMotionEventsEnabled() {
        return this.mSendMotionEventsEnabled;
    }

    public List<MotionEvent> getMotionEvents() {
        return this.mEvents;
    }
}
