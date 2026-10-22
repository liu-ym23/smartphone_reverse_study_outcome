package com.android.server.accessibility.magnification;

import android.view.MotionEvent;
import com.android.server.accessibility.gestures.GestureMatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class GesturesObserver implements GestureMatcher.StateChangeListener {
    private int mCancelledMatcherSize;
    private final List<GestureMatcher> mGestureMatchers;
    private final Listener mListener;
    private boolean mObserveStarted;
    private boolean mProcessMotionEvent;

    public interface Listener {
        void onGestureCancelled(MotionEvent r1, MotionEvent r2, int r3);

        void onGestureCompleted(int r1, MotionEvent r2, MotionEvent r3, int r4);
    }

    public GesturesObserver(Listener listener, GestureMatcher... matchers) {
        this.mGestureMatchers = new ArrayList();
        this.mObserveStarted = false;
        this.mProcessMotionEvent = false;
        this.mCancelledMatcherSize = 0;
        this.mListener = listener;
        int i = 0;
    L4:
        if (i >= matchers.length) goto L7;
        matchers[i].setListener(this);
        this.mGestureMatchers.add(matchers[i]);
        i = i + 1;
        goto L4
    }

    public boolean onMotionEvent(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (this.mObserveStarted == false) goto L5;
    L9:
        this.mProcessMotionEvent = true;
        int i = 0;
    L11:
        if (i >= this.mGestureMatchers.size()) goto L17;
        GestureMatcher matcher = this.mGestureMatchers.get(i);
        matcher.onMotionEvent(event, rawEvent, policyFlags);
        if (matcher.getState() == 2) goto L14;
        i = i + 1;
        goto L11
    L14:
        clear();
        this.mProcessMotionEvent = false;
        return true;
    L17:
        this.mProcessMotionEvent = false;
        return false;
    L5:
        if (event.getActionMasked() == 0) goto L8;
        this.mListener.onGestureCancelled(event, rawEvent, policyFlags);
        clear();
        return false;
    L8:
        this.mObserveStarted = true;
        goto L9
    }

    private void clear() {
        Iterator<GestureMatcher> r0 = this.mGestureMatchers.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        GestureMatcher matcher = r0.next();
        matcher.clear();
        goto L4
    L6:
        this.mCancelledMatcherSize = 0;
        this.mObserveStarted = false;
    }

    @Override // com.android.server.accessibility.gestures.GestureMatcher.StateChangeListener
    public void onStateChanged(int gestureId, int state, MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (state != 2) goto L8;
        this.mListener.onGestureCompleted(gestureId, event, rawEvent, policyFlags);
        if (this.mProcessMotionEvent == true) goto L13;
        clear();
        return;
    L13:
        return;
    L8:
        if (state != 3) goto L15;
        this.mCancelledMatcherSize++;
        if (this.mCancelledMatcherSize != this.mGestureMatchers.size()) goto L16;
        this.mListener.onGestureCancelled(event, rawEvent, policyFlags);
        clear();
        return;
    L16:
        return;
    }
}
