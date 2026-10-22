package com.android.server.accessibility.magnification;

import android.util.Log;
import android.util.Slog;
import android.view.MotionEvent;
import com.android.server.accessibility.AccessibilityTraceManager;
import com.android.server.accessibility.BaseEventStreamTransformation;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public abstract class MagnificationGestureHandler extends BaseEventStreamTransformation {
    protected static final boolean DEBUG_ALL = false;
    protected static final boolean DEBUG_EVENT_STREAM = false;
    protected final Callback mCallback;
    private final Queue<MotionEvent> mDebugInputEventHistory;
    private final Queue<MotionEvent> mDebugOutputEventHistory;
    protected final boolean mDetectShortcutTrigger;
    protected final boolean mDetectSingleFingerTripleTap;
    protected final boolean mDetectTwoFingerTripleTap;
    protected final int mDisplayId;
    protected final String mLogTag;
    private final AccessibilityTraceManager mTrace;

    public interface Callback {
        void onTouchInteractionEnd(int r1, int r2);

        void onTouchInteractionStart(int r1, int r2);
    }

    public abstract int getMode();

    abstract void handleMouseOrStylusEvent(MotionEvent r1, MotionEvent r2, int r3);

    abstract void handleShortcutTriggered();

    abstract void onMotionEventInternal(MotionEvent r1, MotionEvent r2, int r3);

    static {
        DEBUG_ALL = Log.isLoggable("MagnificationGestureHandler", 3);
        DEBUG_EVENT_STREAM = DEBUG_ALL | false;
    }

    protected MagnificationGestureHandler(int displayId, boolean detectSingleFingerTripleTap, boolean detectTwoFingerTripleTap, boolean detectShortcutTrigger, AccessibilityTraceManager trace, Callback callback) {
        this.mLogTag = getClass().getSimpleName();
        this.mDisplayId = displayId;
        this.mDetectSingleFingerTripleTap = detectSingleFingerTripleTap;
        this.mDetectTwoFingerTripleTap = false;
        this.mDetectShortcutTrigger = detectShortcutTrigger;
        this.mTrace = trace;
        this.mCallback = callback;
        ArrayDeque r1 = null;
        if (DEBUG_EVENT_STREAM == false) goto L5;
        ArrayDeque r0 = new ArrayDeque();
    L6:
        this.mDebugInputEventHistory = r0;
        if (DEBUG_EVENT_STREAM == false) goto L9;
        r1 = new ArrayDeque();
    L9:
        this.mDebugOutputEventHistory = r1;
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public final void onMotionEvent(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (DEBUG_ALL == false) goto L6;
        Slog.i(this.mLogTag, "onMotionEvent(" + event + ")");
    L6:
        if (this.mTrace.isA11yTracingEnabledForTypes(12288) == false) goto L9;
        this.mTrace.logTrace("MagnificationGestureHandler.onMotionEvent", 12288, "event=" + event + ";rawEvent=" + rawEvent + ";policyFlags=" + policyFlags);
    L9:
        if (DEBUG_EVENT_STREAM == false) goto L12;
        storeEventInto(this.mDebugInputEventHistory, event);
    L12:
        switch(event.getSource()) {
            case 4098: goto L18;
            case 8194: goto L15;
            case 16386: goto L15;
            default: goto L28;
        };
    L28:
        dispatchTransformedEvent(event, rawEvent, policyFlags);
        return;
    L15:
        if (magnificationShortcutExists() == false) goto L28;
        handleMouseOrStylusEvent(event, rawEvent, policyFlags);
        goto L28
    L18:
        if (magnificationShortcutExists() == false) goto L28;
        onMotionEventInternal(event, rawEvent, policyFlags);
        int action = event.getAction();
        if (action != 0) goto L23;
        this.mCallback.onTouchInteractionStart(this.mDisplayId, getMode());
        return;
    L23:
        if (action != 1) goto L25;
    L26:
        this.mCallback.onTouchInteractionEnd(this.mDisplayId, getMode());
        return;
    L25:
        if (action == 3) goto L26;
    }

    private boolean magnificationShortcutExists() {
        if (this.mDetectSingleFingerTripleTap == false) goto L5;
    L10:
        return true;
    L5:
        if (this.mDetectTwoFingerTripleTap == true) goto L10;
        if (this.mDetectShortcutTrigger == true) goto L10;
        return false;
    }

    final void dispatchTransformedEvent(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (DEBUG_EVENT_STREAM == false) goto L10;
        storeEventInto(this.mDebugOutputEventHistory, event);
        super.onMotionEvent(event, rawEvent, policyFlags);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        throw new RuntimeException("Exception downstream following input events: " + this.mDebugInputEventHistory + "\nTransformed into output events: " + this.mDebugOutputEventHistory, e);
    L10:
        super.onMotionEvent(event, rawEvent, policyFlags);
    }

    private static void storeEventInto(Queue<MotionEvent> queue, MotionEvent event) {
        queue.add(MotionEvent.obtain(event));
    L4:
        if (queue.isEmpty() == true) goto L8;
        if ((event.getEventTime() - queue.peek().getEventTime()) <= 5000) goto L11;
        queue.remove().recycle();
        goto L4
    L11:
        return;
    }

    public void notifyShortcutTriggered() {
        if (DEBUG_ALL == false) goto L6;
        Slog.i(this.mLogTag, "notifyShortcutTriggered():");
    L6:
        if (this.mDetectShortcutTrigger == false) goto L9;
        handleShortcutTriggered();
        return;
    }
}
