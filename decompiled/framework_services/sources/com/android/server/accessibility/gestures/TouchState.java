package com.android.server.accessibility.gestures;

import android.util.Slog;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import com.android.server.accessibility.AccessibilityManagerService;

/* JADX INFO: loaded from: classes.dex */
public class TouchState {
    public static final int ALL_POINTER_ID_BITS = -1;
    private static final String LOG_TAG = "TouchState";
    public static final int MAX_POINTER_COUNT = 32;
    public static final int STATE_CLEAR = 0;
    public static final int STATE_DELEGATING = 4;
    public static final int STATE_DRAGGING = 3;
    public static final int STATE_GESTURE_DETECTING = 5;
    public static final int STATE_TOUCH_EXPLORING = 2;
    public static final int STATE_TOUCH_INTERACTING = 1;
    private AccessibilityManagerService mAms;
    private int mDisplayId;
    private boolean mHasResetInputDispatcherState;
    private int mInjectedPointersDown;
    private long mLastInjectedDownEventTime;
    private MotionEvent mLastInjectedHoverEvent;
    private MotionEvent mLastInjectedHoverEventForClick;
    private MotionEvent mLastReceivedEvent;
    int mLastReceivedPolicyFlags;
    private MotionEvent mLastReceivedRawEvent;
    private int mLastTouchedWindowId;
    public final ReceivedPointerTracker mReceivedPointerTracker;
    private boolean mServiceDetectsGestures;
    private boolean mServiceDetectsGesturesRequested;
    private int mState;

    class PointerDownInfo {
        private long mTime;
        private float mX;
        private float mY;

        /* JADX INFO: renamed from: -$$Nest$fgetmTime, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m767$$Nest$fgetmTime(PointerDownInfo r2) {
            return r2.mTime;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmX, reason: not valid java name */
        static /* bridge */ /* synthetic */ float m768$$Nest$fgetmX(PointerDownInfo r0) {
            return r0.mX;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmY, reason: not valid java name */
        static /* bridge */ /* synthetic */ float m769$$Nest$fgetmY(PointerDownInfo r0) {
            return r0.mY;
        }

        PointerDownInfo(TouchState this$0) {
        }

        public void set(float x, float y, long time) {
            this.mX = x;
            this.mY = y;
            this.mTime = time;
        }

        public void clear() {
            this.mX = 0.0f;
            this.mY = 0.0f;
            this.mTime = 0;
        }
    }

    class ReceivedPointerTracker {
        private static final String LOG_TAG_RECEIVED_POINTER_TRACKER = "ReceivedPointerTracker";
        private int mLastReceivedDownEdgeFlags;
        private int mPrimaryPointerId;
        private final PointerDownInfo[] mReceivedPointers;
        public int mReceivedPointersDown;
        final /* synthetic */ TouchState this$0;

        ReceivedPointerTracker(TouchState this$0) {
            this.this$0 = this$0;
            this.mReceivedPointers = new PointerDownInfo[32];
            clear();
        }

        public void clear() {
            this.mReceivedPointersDown = 0;
            this.mPrimaryPointerId = 0;
            int i = 0;
        L4:
            if (i >= 32) goto L7;
            this.mReceivedPointers[i] = new PointerDownInfo(this.this$0);
            i = i + 1;
            goto L4
        }

        public void onMotionEvent(MotionEvent event) {
            int action = event.getActionMasked();
            switch(action) {
                case 0: goto L8;
                case 1: goto L7;
                case 2: goto L10;
                case 3: goto L10;
                case 4: goto L10;
                case 5: goto L6;
                case 6: goto L5;
                default: goto L10;
            };
        L5:
            handleReceivedPointerUp(event.getActionIndex(), event);
            goto L10
        L6:
            handleReceivedPointerDown(event.getActionIndex(), event);
            goto L10
        L7:
            handleReceivedPointerUp(event.getActionIndex(), event);
            goto L10
        L8:
            handleReceivedPointerDown(event.getActionIndex(), event);
        L10:
            if (TouchExplorer.DEBUG == false) goto L13;
            Slog.i(LOG_TAG_RECEIVED_POINTER_TRACKER, "Received pointer:\n" + toString());
            return;
        }

        public int getReceivedPointerDownCount() {
            return Integer.bitCount(this.mReceivedPointersDown);
        }

        public boolean isReceivedPointerDown(int pointerId) {
            int pointerFlag = 1 << pointerId;
            if ((this.mReceivedPointersDown & pointerFlag) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public float getReceivedPointerDownX(int pointerId) {
            return PointerDownInfo.m768$$Nest$fgetmX(this.mReceivedPointers[pointerId]);
        }

        public float getReceivedPointerDownY(int pointerId) {
            return PointerDownInfo.m769$$Nest$fgetmY(this.mReceivedPointers[pointerId]);
        }

        public long getReceivedPointerDownTime(int pointerId) {
            return PointerDownInfo.m767$$Nest$fgetmTime(this.mReceivedPointers[pointerId]);
        }

        public int getPrimaryPointerId() {
            if (this.mPrimaryPointerId != (-1)) goto L6;
            this.mPrimaryPointerId = findPrimaryPointerId();
        L6:
            return this.mPrimaryPointerId;
        }

        public int getLastReceivedDownEdgeFlags() {
            return this.mLastReceivedDownEdgeFlags;
        }

        private void handleReceivedPointerDown(int pointerIndex, MotionEvent event) {
            int pointerId = event.getPointerId(pointerIndex);
            int pointerFlag = 1 << pointerId;
            this.mLastReceivedDownEdgeFlags = event.getEdgeFlags();
            this.mReceivedPointersDown |= pointerFlag;
            this.mReceivedPointers[pointerId].set(event.getX(pointerIndex), event.getY(pointerIndex), event.getEventTime());
            if (event.getActionMasked() != 0) goto L6;
            this.mPrimaryPointerId = pointerId;
            return;
        }

        private void handleReceivedPointerUp(int pointerIndex, MotionEvent event) {
            int pointerId = event.getPointerId(pointerIndex);
            int pointerFlag = 1 << pointerId;
            this.mReceivedPointersDown &= ~pointerFlag;
            this.mReceivedPointers[pointerId].clear();
            if (this.mPrimaryPointerId != pointerId) goto L6;
            this.mPrimaryPointerId = -1;
            return;
        }

        private int findPrimaryPointerId() {
            int primaryPointerId = -1;
            long minDownTime = Long.MAX_VALUE;
            int pointerIdBits = this.mReceivedPointersDown;
        L3:
            if (pointerIdBits <= 0) goto L8;
            int pointerId = Integer.numberOfTrailingZeros(pointerIdBits);
            pointerIdBits = pointerIdBits & (~(1 << pointerId));
            long downPointerTime = PointerDownInfo.m767$$Nest$fgetmTime(this.mReceivedPointers[pointerId]);
            if (downPointerTime >= minDownTime) goto L3;
            minDownTime = downPointerTime;
            primaryPointerId = pointerId;
            goto L3
        L8:
            return primaryPointerId;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("=========================");
            builder.append("\nDown pointers #");
            builder.append(getReceivedPointerDownCount());
            builder.append(" [ ");
            int i = 0;
        L4:
            if (i >= 32) goto L9;
            if (isReceivedPointerDown(i) == false) goto L8;
            builder.append(i);
            builder.append(" ");
        L8:
            i = i + 1;
            goto L4
        L9:
            builder.append("]");
            builder.append("\nPrimary pointer id [ ");
            builder.append(getPrimaryPointerId());
            builder.append(" ]");
            builder.append("\n=========================");
            return builder.toString();
        }
    }

    public @interface State {
    }

    public TouchState(int displayId, AccessibilityManagerService ams) {
        this.mState = 0;
        this.mServiceDetectsGestures = false;
        this.mServiceDetectsGesturesRequested = false;
        this.mDisplayId = -1;
        this.mDisplayId = displayId;
        this.mAms = ams;
        this.mReceivedPointerTracker = new ReceivedPointerTracker(this);
    }

    public void clear() {
        setState(0);
        this.mServiceDetectsGestures = this.mServiceDetectsGesturesRequested;
        if (this.mLastReceivedEvent == null) goto L5;
        this.mLastReceivedEvent.recycle();
        this.mLastReceivedEvent = null;
    L5:
        this.mReceivedPointerTracker.clear();
        this.mInjectedPointersDown = 0;
    }

    public void onReceivedMotionEvent(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (isClear() == false) goto L8;
        if (event.getActionMasked() != 0) goto L8;
        clear();
    L8:
        if (this.mLastReceivedEvent == null) goto L11;
        this.mLastReceivedEvent.recycle();
    L11:
        if (this.mLastReceivedRawEvent == null) goto L13;
        this.mLastReceivedRawEvent.recycle();
    L13:
        this.mLastReceivedEvent = MotionEvent.obtain(event);
        this.mLastReceivedRawEvent = MotionEvent.obtain(rawEvent);
        this.mLastReceivedPolicyFlags = policyFlags;
        this.mReceivedPointerTracker.onMotionEvent(rawEvent);
    }

    public void onInjectedMotionEvent(MotionEvent event) {
        int action = event.getActionMasked();
        int pointerId = event.getPointerId(event.getActionIndex());
        int pointerFlag = 1 << pointerId;
        switch(action) {
            case 0: goto L19;
            case 1: goto L16;
            case 2: goto L21;
            case 3: goto L21;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L16;
            case 7: goto L13;
            case 8: goto L21;
            case 9: goto L13;
            case 10: goto L6;
            default: goto L21;
        };
    L16:
        this.mInjectedPointersDown &= ~pointerFlag;
        if (this.mInjectedPointersDown != 0) goto L21;
        this.mLastInjectedDownEventTime = 0;
        goto L21
    L19:
        this.mInjectedPointersDown |= pointerFlag;
        this.mLastInjectedDownEventTime = event.getDownTime();
        goto L21
    L6:
        if (this.mLastInjectedHoverEvent == null) goto L8;
        this.mLastInjectedHoverEvent.recycle();
    L8:
        this.mLastInjectedHoverEvent = MotionEvent.obtain(event);
        if (this.mLastInjectedHoverEventForClick == null) goto L11;
        this.mLastInjectedHoverEventForClick.recycle();
    L11:
        this.mLastInjectedHoverEventForClick = MotionEvent.obtain(event);
        goto L21
    L13:
        if (this.mLastInjectedHoverEvent == null) goto L15;
        this.mLastInjectedHoverEvent.recycle();
    L15:
        this.mLastInjectedHoverEvent = MotionEvent.obtain(event);
    L21:
        if (TouchExplorer.DEBUG == false) goto L24;
        Slog.i(LOG_TAG, "Injected pointer:\n" + toString());
        return;
    }

    public void onReceivedAccessibilityEvent(AccessibilityEvent event) {
        switch(event.getEventType()) {
            case 32: goto L8;
            case 128: goto L6;
            case 256: goto L6;
            case 32768: goto L8;
            case 2097152: goto L5;
            default: goto L14;
        };
    L5:
        this.mAms.moveNonProxyTopFocusedDisplayToTopIfNeeded();
        return;
    L6:
        this.mLastTouchedWindowId = event.getWindowId();
        return;
    L14:
        return;
    L8:
        if (this.mLastInjectedHoverEventForClick == null) goto L10;
        this.mLastInjectedHoverEventForClick.recycle();
        this.mLastInjectedHoverEventForClick = null;
    L10:
        this.mLastTouchedWindowId = -1;
    }

    public void onInjectedAccessibilityEvent(int type) {
        switch(type) {
            case 512: goto L9;
            case 1024: goto L8;
            case 262144: goto L7;
            case 524288: goto L6;
            case 1048576: goto L5;
            case 2097152: goto L4;
            default: goto L16;
        };
    L4:
        setState(0);
        return;
    L5:
        startTouchInteracting();
        return;
    L6:
        clear();
        return;
    L7:
        startGestureDetecting();
        return;
    L8:
        startTouchInteracting();
        return;
    L9:
        startTouchExploring();
        return;
    }

    public int getState() {
        return this.mState;
    }

    public void setState(int state) {
        if (this.mState != state) goto L6;
        return;
    L6:
        if (TouchExplorer.DEBUG == false) goto L8;
        Slog.i(LOG_TAG, getStateSymbolicName(this.mState) + "->" + getStateSymbolicName(state));
    L8:
        this.mState = state;
        if (this.mServiceDetectsGestures == false) goto L12;
        this.mAms.onTouchStateChanged(this.mDisplayId, state);
        return;
    }

    public boolean isTouchExploring() {
        if (this.mState != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public void startTouchExploring() {
        setState(2);
    }

    public boolean isDelegating() {
        if (this.mState != 4) goto L5;
        return true;
    L5:
        return false;
    }

    public void startDelegating() {
        setState(4);
    }

    public boolean isGestureDetecting() {
        if (this.mState != 5) goto L5;
        return true;
    L5:
        return false;
    }

    public void startGestureDetecting() {
        setState(5);
    }

    public boolean isDragging() {
        if (this.mState != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public void startDragging() {
        setState(3);
    }

    public boolean isTouchInteracting() {
        if (this.mState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void startTouchInteracting() {
        setState(1);
    }

    public boolean isClear() {
        if (this.mState != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "TouchState { mState: " + getStateSymbolicName(this.mState) + " }";
    }

    public static String getStateSymbolicName(int state) {
        switch(state) {
            case 0: goto L15;
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L5;
            default: goto L4;
        };
    L5:
        return "STATE_GESTURE_DETECTING";
    L7:
        return "STATE_DELEGATING";
    L9:
        return "STATE_DRAGGING";
    L11:
        return "STATE_TOUCH_EXPLORING";
    L13:
        return "STATE_TOUCH_INTERACTING";
    L15:
        return "STATE_CLEAR";
    L4:
        return "Unknown state: " + state;
    }

    public ReceivedPointerTracker getReceivedPointerTracker() {
        return this.mReceivedPointerTracker;
    }

    public MotionEvent getLastReceivedEvent() {
        return this.mLastReceivedEvent;
    }

    public int getLastReceivedPolicyFlags() {
        return this.mLastReceivedPolicyFlags;
    }

    public MotionEvent getLastReceivedRawEvent() {
        return this.mLastReceivedRawEvent;
    }

    public MotionEvent getLastInjectedHoverEvent() {
        return this.mLastInjectedHoverEvent;
    }

    public long getLastInjectedDownEventTime() {
        return this.mLastInjectedDownEventTime;
    }

    boolean hasResetInputDispatcherState() {
        return this.mHasResetInputDispatcherState;
    }

    void setHasResetInputDispatcherState(boolean value) {
        this.mHasResetInputDispatcherState = value;
    }

    public int getLastTouchedWindowId() {
        return this.mLastTouchedWindowId;
    }

    public int getInjectedPointerDownCount() {
        return Integer.bitCount(this.mInjectedPointersDown);
    }

    public int getInjectedPointersDown() {
        return this.mInjectedPointersDown;
    }

    public boolean isInjectedPointerDown(int pointerId) {
        int pointerFlag = 1 << pointerId;
        if ((this.mInjectedPointersDown & pointerFlag) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public MotionEvent getLastInjectedHoverEventForClick() {
        return this.mLastInjectedHoverEventForClick;
    }

    public boolean isServiceDetectingGestures() {
        return this.mServiceDetectsGestures;
    }

    public void setServiceDetectsGestures(boolean mode) {
        if (TouchExplorer.DEBUG == false) goto L5;
        Slog.d(LOG_TAG, "serviceDetectsGestures: " + mode);
    L5:
        this.mServiceDetectsGesturesRequested = mode;
    }
}
