package com.android.server.accessibility.gestures;

import android.accessibilityservice.AccessibilityGestureEvent;
import android.content.Context;
import android.graphics.Region;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Slog;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.android.server.ISmtResourceControl;
import com.android.server.accessibility.AccessibilityManagerService;
import com.android.server.accessibility.BaseEventStreamTransformation;
import com.android.server.accessibility.EventStreamTransformation;
import com.android.server.usb.descriptors.UsbACInterface;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TouchExplorer extends BaseEventStreamTransformation implements GestureManifold.Listener {
    static final boolean DEBUG = false;
    private static final float EDGE_SWIPE_HEIGHT_CM = 0.25f;
    private static final int EXIT_GESTURE_DETECTION_TIMEOUT = 2000;
    private static final String LOG_TAG = "TouchExplorer";
    private static final float MAX_DRAGGING_ANGLE_COS = 0.52532196f;
    private final AccessibilityManagerService mAms;
    private final Context mContext;
    private final int mDetermineUserIntentTimeout;
    private final EventDispatcher mDispatcher;
    private int mDisplayId;
    private final int mDoubleTapSlop;
    private int mDraggingPointerId;
    private final float mEdgeSwipeHeightPixels;
    private final ExitGestureDetectionModeDelayed mExitGestureDetectionModeDelayed;
    private Region mGestureDetectionPassthroughRegion;
    private final GestureManifold mGestureDetector;
    private final Handler mHandler;
    private final TouchState.ReceivedPointerTracker mReceivedPointerTracker;
    private final SendHoverEnterAndMoveDelayed mSendHoverEnterAndMoveDelayed;
    private final SendHoverExitDelayed mSendHoverExitDelayed;
    private final SendAccessibilityEventDelayed mSendTouchExplorationEndDelayed;
    private final SendAccessibilityEventDelayed mSendTouchInteractionEndDelayed;
    private TouchState mState;
    private Region mTouchExplorationPassthroughRegion;
    private final int mTouchSlop;

    private final class ExitGestureDetectionModeDelayed implements Runnable {
        final /* synthetic */ TouchExplorer this$0;

        /* synthetic */ ExitGestureDetectionModeDelayed(TouchExplorer r1, TouchExplorerIA r2) {
            this(r1);
        }

        private ExitGestureDetectionModeDelayed(TouchExplorer r1) {
            this.this$0 = r1;
        }

        public void post() {
            TouchExplorer.m757$$Nest$fgetmHandler(this.this$0).postDelayed(this, ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME);
        }

        public void cancel() {
            TouchExplorer.m757$$Nest$fgetmHandler(this.this$0).removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            TouchExplorer.m755$$Nest$fgetmDispatcher(this.this$0).sendAccessibilityEvent(524288);
            TouchExplorer.m762$$Nest$mclear(this.this$0);
        }
    }

    private class SendAccessibilityEventDelayed implements Runnable {
        private final int mDelay;
        private final int mEventType;
        final /* synthetic */ TouchExplorer this$0;

        public SendAccessibilityEventDelayed(TouchExplorer r1, int eventType, int delay) {
            this.this$0 = r1;
            this.mEventType = eventType;
            this.mDelay = delay;
        }

        public void cancel() {
            TouchExplorer.m757$$Nest$fgetmHandler(this.this$0).removeCallbacks(this);
        }

        public void post() {
            TouchExplorer.m757$$Nest$fgetmHandler(this.this$0).postDelayed(this, this.mDelay);
        }

        public boolean isPending() {
            return TouchExplorer.m757$$Nest$fgetmHandler(this.this$0).hasCallbacks(this);
        }

        public void forceSendAndRemove() {
            if (isPending() == false) goto L6;
            run();
            cancel();
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            TouchExplorer.m755$$Nest$fgetmDispatcher(this.this$0).sendAccessibilityEvent(this.mEventType);
        }
    }

    class SendHoverEnterAndMoveDelayed implements Runnable {
        private final String LOG_TAG_SEND_HOVER_DELAYED;
        private final List<MotionEvent> mEvents;
        private int mPointerIdBits;
        private int mPolicyFlags;
        private final List<MotionEvent> mRawEvents;
        final /* synthetic */ TouchExplorer this$0;

        /* JADX INFO: renamed from: -$$Nest$mclear, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m764$$Nest$mclear(SendHoverEnterAndMoveDelayed r0) {
            r0.clear();
        }

        /* JADX INFO: renamed from: -$$Nest$misPending, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m765$$Nest$misPending(SendHoverEnterAndMoveDelayed r0) {
            return r0.isPending();
        }

        SendHoverEnterAndMoveDelayed(TouchExplorer this$0) {
            this.this$0 = this$0;
            this.LOG_TAG_SEND_HOVER_DELAYED = "SendHoverEnterAndMoveDelayed";
            this.mEvents = new ArrayList();
            this.mRawEvents = new ArrayList();
        }

        public void post(MotionEvent event, MotionEvent rawEvent, int pointerIdBits, int policyFlags) {
            cancel();
            addEvent(event, rawEvent);
            this.mPointerIdBits = pointerIdBits;
            this.mPolicyFlags = policyFlags;
            TouchExplorer.m757$$Nest$fgetmHandler(this.this$0).postDelayed(this, TouchExplorer.m754$$Nest$fgetmDetermineUserIntentTimeout(this.this$0));
        }

        public void addEvent(MotionEvent event, MotionEvent rawEvent) {
            this.mEvents.add(MotionEvent.obtain(event));
            this.mRawEvents.add(MotionEvent.obtain(rawEvent));
        }

        public void cancel() {
            if (isPending() == false) goto L6;
            TouchExplorer.m757$$Nest$fgetmHandler(this.this$0).removeCallbacks(this);
            clear();
            return;
        }

        public void repost() {
            if (isPending() == false) goto L6;
            TouchExplorer.m757$$Nest$fgetmHandler(this.this$0).removeCallbacks(this);
            TouchExplorer.m757$$Nest$fgetmHandler(this.this$0).postDelayed(this, TouchExplorer.m754$$Nest$fgetmDetermineUserIntentTimeout(this.this$0));
            return;
        }

        private boolean isPending() {
            return TouchExplorer.m757$$Nest$fgetmHandler(this.this$0).hasCallbacks(this);
        }

        private void clear() {
            this.mPointerIdBits = -1;
            this.mPolicyFlags = 0;
            int eventCount = this.mEvents.size();
            int i = eventCount - 1;
        L3:
            if (i < 0) goto L5;
            this.mEvents.remove(i).recycle();
            i = i - 1;
            goto L3
        L5:
            int rawEventcount = this.mRawEvents.size();
            int i2 = rawEventcount - 1;
        L6:
            if (i2 < 0) goto L9;
            this.mRawEvents.remove(i2).recycle();
            i2 = i2 - 1;
            goto L6
        }

        public void forceSendAndRemove() {
            if (isPending() == false) goto L6;
            run();
            cancel();
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TouchExplorer.m758$$Nest$fgetmReceivedPointerTracker(this.this$0).getReceivedPointerDownCount() <= 1) goto L7;
            Slog.e(TouchExplorer.LOG_TAG, "Attempted touch exploration with " + TouchExplorer.m758$$Nest$fgetmReceivedPointerTracker(this.this$0).getReceivedPointerDownCount() + " pointers down.");
            return;
        L7:
            if (this.mEvents.size() != 0) goto L9;
            return;
        L9:
            this.this$0.sendHoverExitAndTouchExplorationGestureEndIfNeeded(this.mPolicyFlags);
            TouchExplorer.m755$$Nest$fgetmDispatcher(this.this$0).sendAccessibilityEvent(512);
            if (this.this$0.isSendMotionEventsEnabled() == false) goto L13;
            AccessibilityGestureEvent gestureEvent = new AccessibilityGestureEvent(-2, TouchExplorer.m761$$Nest$fgetmState(this.this$0).getLastReceivedEvent().getDisplayId(), TouchExplorer.m756$$Nest$fgetmGestureDetector(this.this$0).getMotionEvents());
            TouchExplorer.m763$$Nest$mdispatchGesture(this.this$0, gestureEvent);
        L13:
            if (this.mEvents.isEmpty() == false) goto L15;
        L25:
            clear();
            return;
        L15:
            if (this.mRawEvents.isEmpty() == true) goto L25;
            TouchExplorer.m755$$Nest$fgetmDispatcher(this.this$0).sendMotionEvent(this.mEvents.get(0), 9, this.mRawEvents.get(0), this.mPointerIdBits, this.mPolicyFlags);
            if (TouchExplorer.DEBUG == false) goto L19;
            Slog.d("SendHoverEnterAndMoveDelayed", "Injecting motion event: ACTION_HOVER_ENTER");
        L19:
            int eventCount = this.mEvents.size();
            int i = 1;
        L20:
            if (i >= eventCount) goto L25;
            TouchExplorer.m755$$Nest$fgetmDispatcher(this.this$0).sendMotionEvent(this.mEvents.get(i), 7, this.mRawEvents.get(i), this.mPointerIdBits, this.mPolicyFlags);
            if (TouchExplorer.DEBUG == false) goto L24;
            Slog.d("SendHoverEnterAndMoveDelayed", "Injecting motion event: ACTION_HOVER_MOVE");
        L24:
            i = i + 1;
            goto L20
        }

        public void setPointerIdBits(int pointerIdBits) {
            this.mPointerIdBits = pointerIdBits;
        }

        public void setPolicyFlags(int policyFlags) {
            this.mPolicyFlags = policyFlags;
        }
    }

    class SendHoverExitDelayed implements Runnable {
        private final String LOG_TAG_SEND_HOVER_DELAYED;
        private int mPointerIdBits;
        private int mPolicyFlags;
        private MotionEvent mPrototype;
        private MotionEvent mRawEvent;
        final /* synthetic */ TouchExplorer this$0;

        /* JADX INFO: renamed from: -$$Nest$misPending, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m766$$Nest$misPending(SendHoverExitDelayed r0) {
            return r0.isPending();
        }

        SendHoverExitDelayed(TouchExplorer this$0) {
            this.this$0 = this$0;
            this.LOG_TAG_SEND_HOVER_DELAYED = "SendHoverExitDelayed";
        }

        public void post(MotionEvent prototype, MotionEvent rawEvent, int pointerIdBits, int policyFlags) {
            cancel();
            this.mPrototype = MotionEvent.obtain(prototype);
            this.mRawEvent = MotionEvent.obtain(rawEvent);
            this.mPointerIdBits = pointerIdBits;
            this.mPolicyFlags = policyFlags;
            TouchExplorer.m757$$Nest$fgetmHandler(this.this$0).postDelayed(this, TouchExplorer.m754$$Nest$fgetmDetermineUserIntentTimeout(this.this$0));
        }

        public void cancel() {
            if (isPending() == false) goto L6;
            TouchExplorer.m757$$Nest$fgetmHandler(this.this$0).removeCallbacks(this);
            clear();
            return;
        }

        private boolean isPending() {
            return TouchExplorer.m757$$Nest$fgetmHandler(this.this$0).hasCallbacks(this);
        }

        private void clear() {
            if (this.mPrototype == null) goto L6;
            this.mPrototype.recycle();
        L6:
            if (this.mRawEvent == null) goto L8;
            this.mRawEvent.recycle();
        L8:
            this.mPrototype = null;
            this.mRawEvent = null;
            this.mPointerIdBits = -1;
            this.mPolicyFlags = 0;
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
            Slog.d("SendHoverExitDelayed", "Injecting motion event: ACTION_HOVER_EXIT");
        L5:
            TouchExplorer.m755$$Nest$fgetmDispatcher(this.this$0).sendMotionEvent(this.mPrototype, 10, this.mRawEvent, this.mPointerIdBits, this.mPolicyFlags);
            if (TouchExplorer.m759$$Nest$fgetmSendTouchExplorationEndDelayed(this.this$0).isPending() == true) goto L9;
            TouchExplorer.m759$$Nest$fgetmSendTouchExplorationEndDelayed(this.this$0).cancel();
            TouchExplorer.m759$$Nest$fgetmSendTouchExplorationEndDelayed(this.this$0).post();
        L9:
            if (TouchExplorer.m760$$Nest$fgetmSendTouchInteractionEndDelayed(this.this$0).isPending() == false) goto L11;
            TouchExplorer.m760$$Nest$fgetmSendTouchInteractionEndDelayed(this.this$0).cancel();
            TouchExplorer.m760$$Nest$fgetmSendTouchInteractionEndDelayed(this.this$0).post();
        L11:
            clear();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDetermineUserIntentTimeout, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m754$$Nest$fgetmDetermineUserIntentTimeout(TouchExplorer r0) {
        return r0.mDetermineUserIntentTimeout;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDispatcher, reason: not valid java name */
    static /* bridge */ /* synthetic */ EventDispatcher m755$$Nest$fgetmDispatcher(TouchExplorer r0) {
        return r0.mDispatcher;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGestureDetector, reason: not valid java name */
    static /* bridge */ /* synthetic */ GestureManifold m756$$Nest$fgetmGestureDetector(TouchExplorer r0) {
        return r0.mGestureDetector;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m757$$Nest$fgetmHandler(TouchExplorer r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmReceivedPointerTracker, reason: not valid java name */
    static /* bridge */ /* synthetic */ TouchState.ReceivedPointerTracker m758$$Nest$fgetmReceivedPointerTracker(TouchExplorer r0) {
        return r0.mReceivedPointerTracker;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSendTouchExplorationEndDelayed, reason: not valid java name */
    static /* bridge */ /* synthetic */ SendAccessibilityEventDelayed m759$$Nest$fgetmSendTouchExplorationEndDelayed(TouchExplorer r0) {
        return r0.mSendTouchExplorationEndDelayed;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSendTouchInteractionEndDelayed, reason: not valid java name */
    static /* bridge */ /* synthetic */ SendAccessibilityEventDelayed m760$$Nest$fgetmSendTouchInteractionEndDelayed(TouchExplorer r0) {
        return r0.mSendTouchInteractionEndDelayed;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmState, reason: not valid java name */
    static /* bridge */ /* synthetic */ TouchState m761$$Nest$fgetmState(TouchExplorer r0) {
        return r0.mState;
    }

    /* JADX INFO: renamed from: -$$Nest$mclear, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m762$$Nest$mclear(TouchExplorer r0) {
        r0.clear();
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchGesture, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m763$$Nest$mdispatchGesture(TouchExplorer r0, AccessibilityGestureEvent r1) {
        r0.dispatchGesture(r1);
    }

    static {
        DEBUG = Log.isLoggable(LOG_TAG, 3);
    }

    public TouchExplorer(Context context, AccessibilityManagerService service) {
        this(context, service, null);
    }

    public TouchExplorer(Context context, AccessibilityManagerService service, GestureManifold detector) {
        this(context, service, detector, new Handler(context.getMainLooper()));
    }

    TouchExplorer(Context context, AccessibilityManagerService service, GestureManifold detector, Handler mainHandler) {
        this.mDisplayId = -1;
        this.mContext = context;
        this.mDisplayId = context.getDisplayId();
        this.mAms = service;
        this.mState = new TouchState(this.mDisplayId, this.mAms);
        this.mReceivedPointerTracker = this.mState.getReceivedPointerTracker();
        this.mDispatcher = new EventDispatcher(context, this.mAms, super.getNext(), this.mState);
        this.mDetermineUserIntentTimeout = ViewConfiguration.getDoubleTapTimeout();
        this.mDoubleTapSlop = ViewConfiguration.get(context).getScaledDoubleTapSlop();
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        DisplayMetrics metrics = this.mContext.getResources().getDisplayMetrics();
        this.mEdgeSwipeHeightPixels = (metrics.ydpi / GestureUtils.CM_PER_INCH) * EDGE_SWIPE_HEIGHT_CM;
        this.mHandler = mainHandler;
        this.mExitGestureDetectionModeDelayed = new ExitGestureDetectionModeDelayed(this, null);
        this.mSendHoverEnterAndMoveDelayed = new SendHoverEnterAndMoveDelayed(this);
        this.mSendHoverExitDelayed = new SendHoverExitDelayed(this);
        this.mSendTouchExplorationEndDelayed = new SendAccessibilityEventDelayed(this, 1024, this.mDetermineUserIntentTimeout);
        this.mSendTouchInteractionEndDelayed = new SendAccessibilityEventDelayed(this, 2097152, this.mDetermineUserIntentTimeout);
        if (detector != null) goto L5;
        this.mGestureDetector = new GestureManifold(context, this, this.mState, this.mHandler);
    L6:
        this.mGestureDetectionPassthroughRegion = new Region();
        this.mTouchExplorationPassthroughRegion = new Region();
        return;
    L5:
        this.mGestureDetector = detector;
        goto L6
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public void clearEvents(int inputSource) {
        if (inputSource != 4098) goto L5;
        clear();
    L5:
        super.clearEvents(inputSource);
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public void onDestroy() {
        clear();
    }

    private void clear() {
        MotionEvent event = this.mState.getLastReceivedEvent();
        if (event == null) goto L6;
        clear(event, 33554432);
        return;
    }

    private void clear(MotionEvent event, int policyFlags) {
        sendHoverExitAndTouchExplorationGestureEndIfNeeded(policyFlags);
        this.mDraggingPointerId = -1;
        this.mDispatcher.sendUpForInjectedDownPointers(event, policyFlags);
        this.mSendHoverEnterAndMoveDelayed.cancel();
        this.mSendHoverExitDelayed.cancel();
        this.mExitGestureDetectionModeDelayed.cancel();
        this.mSendTouchExplorationEndDelayed.cancel();
        this.mSendTouchInteractionEndDelayed.cancel();
        this.mGestureDetector.clear();
        this.mDispatcher.clear();
        this.mState.clear();
        this.mAms.onTouchInteractionEnd();
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public void onMotionEvent(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (event.isFromSource(UsbACInterface.FORMAT_II_AC3) == true) goto L44;
        super.onMotionEvent(event, rawEvent, policyFlags);
        return;
    L44:
        checkForMalformedEvent(event);     // Catch: IllegalArgumentException -> L41
        checkForMalformedEvent(rawEvent);     // Catch: IllegalArgumentException -> L41
        if (DEBUG == false) goto L10;
        Slog.d(LOG_TAG, "Received event: " + event + ", policyFlags=0x" + Integer.toHexString(policyFlags));
        Slog.d(LOG_TAG, this.mState.toString());
    L10:
        this.mState.onReceivedMotionEvent(event, rawEvent, policyFlags);
        if (shouldPerformGestureDetection(event) == false) goto L16;
        if (this.mGestureDetector.onMotionEvent(event, rawEvent, policyFlags) == false) goto L16;
        return;
    L16:
        if (event.getActionMasked() != 3) goto L20;
        clear(event, policyFlags);
        return;
    L20:
        if (this.mState.isClear() == false) goto L23;
        handleMotionEventStateClear(event, rawEvent, policyFlags);
        return;
    L23:
        if (this.mState.isTouchInteracting() == false) goto L26;
        handleMotionEventStateTouchInteracting(event, rawEvent, policyFlags);
        return;
    L26:
        if (this.mState.isTouchExploring() == false) goto L29;
        handleMotionEventStateTouchExploring(event, rawEvent, policyFlags);
        return;
    L29:
        if (this.mState.isDragging() == false) goto L32;
        handleMotionEventStateDragging(event, rawEvent, policyFlags);
        return;
    L32:
        if (this.mState.isDelegating() == false) goto L35;
        handleMotionEventStateDelegating(event, rawEvent, policyFlags);
        return;
    L35:
        if (this.mState.isGestureDetecting() == false) goto L39;
        this.mSendTouchInteractionEndDelayed.cancel();
        if (this.mState.isServiceDetectingGestures() == false) goto L51;
        this.mAms.sendMotionEventToListeningServices(rawEvent);
        return;
    L51:
        return;
    L39:
        Slog.e(LOG_TAG, "Illegal state: " + this.mState);
        clear(event, policyFlags);
        return;
    L41:
        e = move-exception;
        Slog.e(LOG_TAG, "Ignoring malformed event: " + event.toString(), e);
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if (DEBUG == false) goto L5;
        Slog.v(LOG_TAG, "Received A11y Event. event=" + event);
    L5:
        int eventType = event.getEventType();
        if (eventType != 256) goto L8;
        sendsPendingA11yEventsIfNeeded();
    L8:
        this.mState.onReceivedAccessibilityEvent(event);
        super.onAccessibilityEvent(event);
    }

    private void sendsPendingA11yEventsIfNeeded() {
        if (SendHoverExitDelayed.m766$$Nest$misPending(this.mSendHoverExitDelayed) == false) goto L6;
        return;
    L6:
        if (this.mSendTouchExplorationEndDelayed.isPending() == false) goto L9;
        this.mSendTouchExplorationEndDelayed.cancel();
        this.mDispatcher.sendAccessibilityEvent(1024);
    L9:
        if (this.mSendTouchInteractionEndDelayed.isPending() == false) goto L12;
        this.mSendTouchInteractionEndDelayed.cancel();
        this.mDispatcher.sendAccessibilityEvent(2097152);
        return;
    }

    @Override // com.android.server.accessibility.gestures.GestureManifold.Listener
    public void onDoubleTapAndHold(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (DEBUG == false) goto L6;
        Slog.i(LOG_TAG, "Double tap and hold. event=" + event + ";rawEvent=" + rawEvent + ";policyFlags=" + policyFlags);
    L6:
        if (this.mDispatcher.longPressWithTouchEvents(event, policyFlags) == false) goto L12;
        sendHoverExitAndTouchExplorationGestureEndIfNeeded(policyFlags);
        if (isSendMotionEventsEnabled() == false) goto L10;
        AccessibilityGestureEvent gestureEvent = new AccessibilityGestureEvent(18, this.mDisplayId, this.mGestureDetector.getMotionEvents());
        dispatchGesture(gestureEvent);
    L10:
        this.mState.startDelegating();
        return;
    }

    @Override // com.android.server.accessibility.gestures.GestureManifold.Listener
    public boolean onDoubleTap(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (DEBUG == false) goto L5;
        Slog.i(LOG_TAG, "Double tap. event=" + event + ";rawEvent=" + rawEvent + ";policyFlags=" + policyFlags);
    L5:
        this.mAms.onTouchInteractionEnd();
        this.mSendHoverEnterAndMoveDelayed.cancel();
        this.mSendHoverExitDelayed.cancel();
        if (isSendMotionEventsEnabled() == false) goto L9;
        AccessibilityGestureEvent gestureEvent = new AccessibilityGestureEvent(17, this.mDisplayId, this.mGestureDetector.getMotionEvents());
        dispatchGesture(gestureEvent);
    L9:
        if (this.mSendTouchExplorationEndDelayed.isPending() == false) goto L11;
        this.mSendTouchExplorationEndDelayed.forceSendAndRemove();
    L11:
        this.mDispatcher.sendAccessibilityEvent(2097152);
        this.mSendTouchInteractionEndDelayed.cancel();
        if (this.mAms.performActionOnAccessibilityFocusedItem(AccessibilityNodeInfo.AccessibilityAction.ACTION_CLICK) == true) goto L18;
        Slog.e(LOG_TAG, "ACTION_CLICK failed. Dispatching motion events to simulate click.");
        if (event == null) goto L17;
        if (rawEvent == null) goto L17;
        this.mDispatcher.clickWithTouchEvents(event, rawEvent, policyFlags);
    L17:
        return true;
    L18:
        return true;
    }

    public void onDoubleTap() {
        MotionEvent event = this.mState.getLastReceivedEvent();
        MotionEvent rawEvent = this.mState.getLastReceivedRawEvent();
        int policyFlags = this.mState.getLastReceivedPolicyFlags();
        onDoubleTap(event, rawEvent, policyFlags);
    }

    public void onDoubleTapAndHold() {
        MotionEvent event = this.mState.getLastReceivedEvent();
        MotionEvent rawEvent = this.mState.getLastReceivedRawEvent();
        int policyFlags = this.mState.getLastReceivedPolicyFlags();
        onDoubleTapAndHold(event, rawEvent, policyFlags);
    }

    @Override // com.android.server.accessibility.gestures.GestureManifold.Listener
    public boolean onGestureStarted() {
        if (DEBUG == false) goto L5;
        Slog.i(LOG_TAG, "Gesture started.");
    L5:
        this.mSendHoverEnterAndMoveDelayed.cancel();
        this.mSendHoverExitDelayed.cancel();
        this.mExitGestureDetectionModeDelayed.post();
        this.mDispatcher.sendAccessibilityEvent(262144);
        return false;
    }

    @Override // com.android.server.accessibility.gestures.GestureManifold.Listener
    public boolean onGestureCompleted(AccessibilityGestureEvent gestureEvent) {
        if (DEBUG == false) goto L5;
        Slog.i(LOG_TAG, "Gesture completed. gestureEvent=" + gestureEvent);
    L5:
        endGestureDetection(true);
        this.mSendTouchInteractionEndDelayed.cancel();
        dispatchGesture(gestureEvent);
        return true;
    }

    @Override // com.android.server.accessibility.gestures.GestureManifold.Listener
    public boolean onGestureCancelled(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (DEBUG == false) goto L5;
        Slog.i(LOG_TAG, "Gesture cancelled. event=" + event + ";rawEvent=" + rawEvent + ";policyFlags=" + policyFlags);
    L5:
        boolean r1 = false;
        if (this.mState.isGestureDetecting() == false) goto L13;
        if (event.getActionMasked() != 1) goto L10;
        r1 = true;
    L10:
        endGestureDetection(r1);
        return true;
    L13:
        if (this.mState.isTouchExploring() == false) goto L21;
        if (event.getActionMasked() != 2) goto L21;
        int pointerId = this.mReceivedPointerTracker.getPrimaryPointerId();
        int pointerIdBits = 1 << pointerId;
        this.mSendHoverEnterAndMoveDelayed.addEvent(event, rawEvent);
        this.mSendHoverEnterAndMoveDelayed.forceSendAndRemove();
        this.mSendHoverExitDelayed.cancel();
        this.mDispatcher.sendMotionEvent(event, 7, rawEvent, pointerIdBits, policyFlags);
        return true;
    L21:
        if (isSendMotionEventsEnabled() == false) goto L23;
        AccessibilityGestureEvent gestureEvent = new AccessibilityGestureEvent(0, this.mDisplayId, this.mGestureDetector.getMotionEvents());
        dispatchGesture(gestureEvent);
    L23:
        return false;
    }

    private void handleMotionEventStateClear(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        switch(event.getActionMasked()) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        handleActionDown(event, rawEvent, policyFlags);
        return;
    }

    private void handleActionDown(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        this.mAms.onTouchInteractionStart();
        this.mSendHoverEnterAndMoveDelayed.cancel();
        SendHoverEnterAndMoveDelayed.m764$$Nest$mclear(this.mSendHoverEnterAndMoveDelayed);
        this.mSendHoverExitDelayed.cancel();
        sendHoverExitAndTouchExplorationGestureEndIfNeeded(policyFlags);
        if (this.mState.isClear() == true) goto L5;
        MotionEvent rawEvent2 = rawEvent;
        this.mSendTouchInteractionEndDelayed.cancel();
    L20:
        if (this.mState.isServiceDetectingGestures() == false) goto L23;
        this.mAms.sendMotionEventToListeningServices(rawEvent2);
        return;
    L23:
        return;
    L5:
        if (SendHoverEnterAndMoveDelayed.m765$$Nest$misPending(this.mSendHoverEnterAndMoveDelayed) == true) goto L11;
        int pointerId = this.mReceivedPointerTracker.getPrimaryPointerId();
        int pointerIdBits = 1 << pointerId;
        if (this.mState.isServiceDetectingGestures() == false) goto L9;
        this.mSendHoverEnterAndMoveDelayed.setPointerIdBits(pointerIdBits);
        this.mSendHoverEnterAndMoveDelayed.setPolicyFlags(policyFlags);
        this.mSendHoverEnterAndMoveDelayed.addEvent(event, rawEvent);
    L12:
        this.mSendTouchExplorationEndDelayed.forceSendAndRemove();
        this.mSendTouchInteractionEndDelayed.forceSendAndRemove();
        this.mDispatcher.sendAccessibilityEvent(1048576);
        if (this.mTouchExplorationPassthroughRegion.contains((int) event.getX(), (int) event.getY()) == false) goto L15;
        this.mState.startDelegating();
        MotionEvent event2 = MotionEvent.obtainNoHistory(event);
        rawEvent2 = rawEvent;
        this.mDispatcher.sendMotionEvent(event2, event2.getAction(), rawEvent2, -1, policyFlags);
        this.mSendHoverEnterAndMoveDelayed.cancel();
        goto L20
    L15:
        rawEvent2 = rawEvent;
        if (this.mGestureDetectionPassthroughRegion.contains((int) event.getX(), (int) event.getY()) == false) goto L20;
        this.mSendHoverEnterAndMoveDelayed.forceSendAndRemove();
        goto L20
    L9:
        this.mSendHoverEnterAndMoveDelayed.post(event, rawEvent, pointerIdBits, policyFlags);
        goto L12
    L11:
        this.mSendHoverEnterAndMoveDelayed.addEvent(event, rawEvent);
        goto L12
    }

    private void handleMotionEventStateTouchInteracting(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        switch(event.getActionMasked()) {
            case 0: goto L11;
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L18;
            case 4: goto L18;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L18;
        };
    L8:
        handleActionPointerDown(event, rawEvent, policyFlags);
        return;
    L9:
        handleActionMoveStateTouchInteracting(event, rawEvent, policyFlags);
        return;
    L10:
        handleActionUp(event, rawEvent, policyFlags);
        return;
    L11:
        this.mSendTouchInteractionEndDelayed.cancel();
        handleActionDown(event, rawEvent, policyFlags);
        return;
    L18:
        return;
    L6:
        if (this.mState.isServiceDetectingGestures() == false) goto L13;
        this.mAms.sendMotionEventToListeningServices(rawEvent);
        return;
    }

    private void handleMotionEventStateTouchExploring(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        switch(event.getActionMasked()) {
            case 0: goto L9;
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L14;
            case 4: goto L14;
            case 5: goto L6;
            case 6: goto L14;
            default: goto L14;
        };
    L6:
        handleActionPointerDown(event, rawEvent, policyFlags);
        return;
    L7:
        handleActionMoveStateTouchExploring(event, rawEvent, policyFlags);
        return;
    L8:
        handleActionUp(event, rawEvent, policyFlags);
        return;
    L9:
        handleActionDownStateTouchExploring(event, rawEvent, policyFlags);
        return;
    }

    private void handleActionPointerDown(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (SendHoverEnterAndMoveDelayed.m765$$Nest$misPending(this.mSendHoverEnterAndMoveDelayed) == false) goto L5;
        this.mSendHoverEnterAndMoveDelayed.cancel();
        this.mSendHoverExitDelayed.cancel();
    L7:
        if (this.mState.isServiceDetectingGestures() == false) goto L10;
        this.mAms.sendMotionEventToListeningServices(rawEvent);
        return;
    L10:
        return;
    L5:
        sendHoverExitAndTouchExplorationGestureEndIfNeeded(policyFlags);
        goto L7
    }

    private void handleActionMoveStateTouchInteracting(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        int pointerId = this.mReceivedPointerTracker.getPrimaryPointerId();
        int pointerIndex = event.findPointerIndex(pointerId);
        int r2 = 1;
        int pointerIdBits = 1 << pointerId;
        if (this.mState.isServiceDetectingGestures() == false) goto L7;
        this.mAms.sendMotionEventToListeningServices(rawEvent);
        this.mSendHoverEnterAndMoveDelayed.addEvent(event, rawEvent);
        return;
    L7:
        switch(event.getPointerCount()) {
            case 1: goto L71;
            case 2: goto L34;
            default: goto L9;
        };
    L71:
        int pointerIdBits2 = pointerIdBits;
        if (SendHoverEnterAndMoveDelayed.m765$$Nest$misPending(this.mSendHoverEnterAndMoveDelayed) == false) goto L75;
        this.mSendHoverEnterAndMoveDelayed.addEvent(event, rawEvent);
    L75:
        return;
    L9:
        if (this.mGestureDetector.isMultiFingerGesturesEnabled() == false) goto L30;
        if (this.mGestureDetector.isTwoFingerPassthroughEnabled() == true) goto L13;
        pointerIdBits2 = pointerIdBits;
        goto L75
    L13:
        if (event.getPointerCount() == 3) goto L15;
        pointerIdBits2 = pointerIdBits;
        goto L75
    L15:
        if (allPointersDownOnBottomEdge(event) == true) goto L17;
        pointerIdBits2 = pointerIdBits;
        goto L75
    L17:
        if (DEBUG == false) goto L20;
        Slog.d(LOG_TAG, "Three-finger edge swipe detected.");
    L20:
        if (isSendMotionEventsEnabled() == false) goto L22;
        AccessibilityGestureEvent gestureEvent = new AccessibilityGestureEvent(-1, this.mDisplayId, this.mGestureDetector.getMotionEvents());
        dispatchGesture(gestureEvent);
    L22:
        this.mState.startDelegating();
        if (this.mState.isTouchExploring() == false) goto L25;
        this.mDispatcher.sendDownForAllNotInjectedPointers(event, policyFlags);
        pointerIdBits2 = pointerIdBits;
        goto L75
    L25:
        this.mDispatcher.sendDownForAllNotInjectedPointersWithOriginalDown(event, policyFlags);
        pointerIdBits2 = pointerIdBits;
        goto L75
    L30:
        if (isSendMotionEventsEnabled() == false) goto L32;
        AccessibilityGestureEvent gestureEvent2 = new AccessibilityGestureEvent(-1, this.mDisplayId, this.mGestureDetector.getMotionEvents());
        dispatchGesture(gestureEvent2);
    L32:
        this.mState.startDelegating();
        this.mDispatcher.sendDownForAllNotInjectedPointers(MotionEvent.obtainNoHistory(event), policyFlags);
        return;
    L34:
        if (this.mGestureDetector.isMultiFingerGesturesEnabled() == true) goto L36;
    L38:
        this.mSendHoverEnterAndMoveDelayed.cancel();
        this.mSendHoverExitDelayed.cancel();
        if (this.mGestureDetector.isMultiFingerGesturesEnabled() == true) goto L41;
        int r17 = 1;
        int pointerIdBits3 = pointerIdBits;
    L57:
        MotionEvent event2 = MotionEvent.obtainNoHistory(event);
        if (isDraggingGesture(event2) == false) goto L68;
        if (isSendMotionEventsEnabled() == false) goto L62;
        AccessibilityGestureEvent gestureEvent3 = new AccessibilityGestureEvent(-1, this.mDisplayId, this.mGestureDetector.getMotionEvents());
        dispatchGesture(gestureEvent3);
    L62:
        computeDraggingPointerIdIfNeeded(event2);
        int pointerIdBits4 = r17 << this.mDraggingPointerId;
        event2.setEdgeFlags(this.mReceivedPointerTracker.getLastReceivedDownEdgeFlags());
        MotionEvent downEvent = computeDownEventForDrag(event2);
        if (downEvent == null) goto L65;
        this.mDispatcher.sendMotionEvent(downEvent, 0, rawEvent, pointerIdBits4, policyFlags);
        MotionEvent event3 = event2;
        this.mDispatcher.sendMotionEvent(event3, 2, rawEvent, pointerIdBits4, policyFlags);
    L66:
        this.mState.startDragging();
        return;
    L65:
        event3 = event2;
        this.mDispatcher.sendMotionEvent(event3, 0, rawEvent, pointerIdBits4, policyFlags);
        goto L66
    L68:
        if (isSendMotionEventsEnabled() == false) goto L70;
        AccessibilityGestureEvent gestureEvent4 = new AccessibilityGestureEvent(-1, this.mDisplayId, this.mGestureDetector.getMotionEvents());
        dispatchGesture(gestureEvent4);
    L70:
        this.mState.startDelegating();
        this.mDispatcher.sendDownForAllNotInjectedPointers(event2, policyFlags);
        return;
    L41:
        if (this.mGestureDetector.isTwoFingerPassthroughEnabled() == false) goto L55;
        if (pointerIndex >= 0) goto L44;
        return;
    L44:
        int index = 0;
    L46:
        if (index >= event.getPointerCount()) goto L54;
        int id = event.getPointerId(index);
        if (this.mReceivedPointerTracker.isReceivedPointerDown(id) == true) goto L50;
        Slog.e(LOG_TAG, "Invalid pointer id: " + id);
    L50:
        float deltaX = this.mReceivedPointerTracker.getReceivedPointerDownX(id) - rawEvent.getX(index);
        float deltaY = this.mReceivedPointerTracker.getReceivedPointerDownY(id) - rawEvent.getY(index);
        int r18 = r2;
        int pointerIdBits5 = pointerIdBits;
        double moveDelta = Math.hypot(deltaX, deltaY);
        if (moveDelta < (this.mTouchSlop * 2)) goto L52;
        index = index + 1;
        pointerIdBits = pointerIdBits5;
        r2 = r18;
        goto L46
    L52:
        return;
    L54:
        r17 = r2;
        pointerIdBits3 = pointerIdBits;
        goto L57
    L55:
        r17 = 1;
        pointerIdBits3 = pointerIdBits;
        goto L57
    L36:
        if (this.mGestureDetector.isTwoFingerPassthroughEnabled() == true) goto L38;
    }

    private void handleActionUp(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (this.mState.isServiceDetectingGestures() == true) goto L5;
    L7:
        this.mAms.onTouchInteractionEnd();
        int pointerId = event.getPointerId(event.getActionIndex());
        int pointerIdBits = 1 << pointerId;
        if (SendHoverEnterAndMoveDelayed.m765$$Nest$misPending(this.mSendHoverEnterAndMoveDelayed) == false) goto L10;
        this.mSendHoverEnterAndMoveDelayed.repost();
        this.mSendHoverExitDelayed.post(event, rawEvent, pointerIdBits, policyFlags);
    L12:
        if (this.mSendTouchInteractionEndDelayed.isPending() == true) goto L15;
        this.mSendTouchInteractionEndDelayed.post();
        return;
    L15:
        return;
    L10:
        sendHoverExitAndTouchExplorationGestureEndIfNeeded(policyFlags);
        goto L12
    L5:
        if (this.mState.isTouchInteracting() == false) goto L7;
        this.mAms.sendMotionEventToListeningServices(rawEvent);
        goto L7
    }

    private void handleActionDownStateTouchExploring(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        this.mSendTouchExplorationEndDelayed.cancel();
        this.mSendTouchInteractionEndDelayed.cancel();
        sendTouchExplorationGestureStartAndHoverEnterIfNeeded(policyFlags);
    }

    private void handleActionMoveStateTouchExploring(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        int pointerId = this.mReceivedPointerTracker.getPrimaryPointerId();
        int pointerIdBits = 1 << pointerId;
        int pointerIndex = event.findPointerIndex(pointerId);
        switch(event.getPointerCount()) {
            case 1: goto L26;
            case 2: goto L13;
            default: goto L5;
        };
    L26:
        sendTouchExplorationGestureStartAndHoverEnterIfNeeded(policyFlags);
        this.mDispatcher.sendMotionEvent(event, 7, rawEvent, pointerIdBits, policyFlags);
        return;
    L5:
        if (this.mGestureDetector.isMultiFingerGesturesEnabled() == false) goto L8;
        return;
    L8:
        if (SendHoverEnterAndMoveDelayed.m765$$Nest$misPending(this.mSendHoverEnterAndMoveDelayed) == false) goto L10;
        this.mSendHoverEnterAndMoveDelayed.cancel();
        this.mSendHoverExitDelayed.cancel();
    L11:
        handleActionMoveStateTouchInteracting(event, rawEvent, policyFlags);
        return;
    L10:
        sendHoverExitAndTouchExplorationGestureEndIfNeeded(policyFlags);
        goto L11
    L13:
        if (this.mGestureDetector.isMultiFingerGesturesEnabled() == false) goto L18;
        if (this.mGestureDetector.isTwoFingerPassthroughEnabled() == true) goto L18;
        return;
    L18:
        if (SendHoverEnterAndMoveDelayed.m765$$Nest$misPending(this.mSendHoverEnterAndMoveDelayed) == false) goto L20;
        this.mSendHoverEnterAndMoveDelayed.cancel();
        this.mSendHoverExitDelayed.cancel();
    L20:
        if (pointerIndex >= 0) goto L22;
        return;
    L22:
        float deltaX = this.mReceivedPointerTracker.getReceivedPointerDownX(pointerId) - rawEvent.getX(pointerIndex);
        float deltaY = this.mReceivedPointerTracker.getReceivedPointerDownY(pointerId) - rawEvent.getY(pointerIndex);
        double moveDelta = Math.hypot(deltaX, deltaY);
        if (moveDelta <= this.mDoubleTapSlop) goto L25;
        handleActionMoveStateTouchInteracting(event, rawEvent, policyFlags);
        return;
    L25:
        sendHoverExitAndTouchExplorationGestureEndIfNeeded(policyFlags);
    }

    private void handleMotionEventStateDragging(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (this.mGestureDetector.isMultiFingerGesturesEnabled() == false) goto L8;
        if (this.mGestureDetector.isTwoFingerPassthroughEnabled() == true) goto L8;
        return;
    L8:
        if (event.findPointerIndex(this.mDraggingPointerId) != (-1)) goto L10;
        Slog.e(LOG_TAG, "mDraggingPointerId doesn't match any pointers on current event. mDraggingPointerId: " + Integer.toString(this.mDraggingPointerId) + ", Event: " + event);
        this.mDraggingPointerId = -1;
        int pointerIdBits = 0;
    L11:
        int pointerIdBits2 = event.getActionMasked();
        switch(pointerIdBits2) {
            case 0: goto L48;
            case 1: goto L42;
            case 2: goto L23;
            case 3: goto L13;
            case 4: goto L13;
            case 5: goto L15;
            case 6: goto L14;
            default: goto L13;
        };
    L13:
        MotionEvent event2 = event;
    L47:
        return;
    L14:
        this.mDraggingPointerId = -1;
        event2 = event;
        this.mDispatcher.sendMotionEvent(event2, 1, rawEvent, pointerIdBits, policyFlags);
        goto L47
    L15:
        event2 = event;
        if (this.mDraggingPointerId == (-1)) goto L19;
        this.mDispatcher.sendMotionEvent(event2, 1, rawEvent, pointerIdBits, policyFlags);
    L19:
        if (this.mState.isServiceDetectingGestures() == false) goto L22;
        this.mAms.sendMotionEventToListeningServices(rawEvent);
        return;
    L22:
        this.mState.startDelegating();
        this.mDispatcher.sendDownForAllNotInjectedPointers(event2, policyFlags);
        goto L47
    L23:
        event2 = event;
        if (this.mDraggingPointerId == (-1)) goto L47;
        if (this.mState.isServiceDetectingGestures() == false) goto L31;
        this.mAms.sendMotionEventToListeningServices(rawEvent);
        computeDraggingPointerIdIfNeeded(event2);
        this.mDispatcher.sendMotionEvent(event2, 2, rawEvent, pointerIdBits, policyFlags);
        return;
    L31:
        switch(event2.getPointerCount()) {
            case 1: goto L47;
            case 2: goto L38;
            default: goto L33;
        };
    L33:
        if (this.mState.isServiceDetectingGestures() == false) goto L36;
        this.mAms.sendMotionEventToListeningServices(rawEvent);
        return;
    L36:
        this.mState.startDelegating();
        this.mDraggingPointerId = -1;
        MotionEvent event3 = MotionEvent.obtainNoHistory(event2);
        this.mDispatcher.sendMotionEvent(event3, 1, rawEvent, pointerIdBits, policyFlags);
        this.mDispatcher.sendDownForAllNotInjectedPointers(event3, policyFlags);
        return;
    L38:
        if (isDraggingGesture(event2) == false) goto L40;
        computeDraggingPointerIdIfNeeded(event2);
        this.mDispatcher.sendMotionEvent(event2, 2, rawEvent, pointerIdBits, policyFlags);
        goto L47
    L40:
        this.mState.startDelegating();
        this.mDraggingPointerId = -1;
        MotionEvent event4 = MotionEvent.obtainNoHistory(event2);
        this.mDispatcher.sendMotionEvent(event4, 1, rawEvent, pointerIdBits, policyFlags);
        this.mDispatcher.sendDownForAllNotInjectedPointers(event4, policyFlags);
        return;
    L42:
        event2 = event;
        if (event2.getPointerId(GestureUtils.getActionIndex(event2)) != this.mDraggingPointerId) goto L45;
        this.mDraggingPointerId = -1;
        this.mDispatcher.sendMotionEvent(event2, 1, rawEvent, pointerIdBits, policyFlags);
    L45:
        this.mAms.onTouchInteractionEnd();
        this.mDispatcher.sendAccessibilityEvent(2097152);
        goto L47
    L48:
        Slog.e(LOG_TAG, "Dragging state can be reached only if two pointers are already down");
        clear(event, policyFlags);
        return;
    L10:
        int pointerIdBits3 = 1 << this.mDraggingPointerId;
        pointerIdBits = pointerIdBits3;
        goto L11
    }

    private void handleMotionEventStateDelegating(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        switch(event.getActionMasked()) {
            case 0: goto L7;
            case 1: goto L5;
            default: goto L4;
        };
    L4:
        this.mDispatcher.sendMotionEvent(event, event.getAction(), rawEvent, -1, policyFlags);
        return;
    L5:
        this.mDispatcher.sendMotionEvent(event, event.getAction(), rawEvent, -1, policyFlags);
        this.mAms.onTouchInteractionEnd();
        this.mDispatcher.clear();
        this.mDispatcher.sendAccessibilityEvent(2097152);
        return;
    L7:
        Slog.e(LOG_TAG, "Delegating state can only be reached if there is at least one pointer down!");
        clear(event, policyFlags);
    }

    private void endGestureDetection(boolean interactionEnd) {
        this.mAms.onTouchInteractionEnd();
        this.mDispatcher.sendAccessibilityEvent(524288);
        if (interactionEnd == false) goto L5;
        this.mDispatcher.sendAccessibilityEvent(2097152);
    L5:
        this.mExitGestureDetectionModeDelayed.cancel();
    }

    void sendHoverExitAndTouchExplorationGestureEndIfNeeded(int policyFlags) {
        MotionEvent event = this.mState.getLastInjectedHoverEvent();
        if (event == null) goto L11;
        if (event.getActionMasked() == 10) goto L11;
        int pointerIdBits = event.getPointerIdBits();
        if (this.mSendTouchExplorationEndDelayed.isPending() == true) goto L9;
        this.mSendTouchExplorationEndDelayed.post();
    L9:
        this.mDispatcher.sendMotionEvent(event, 10, this.mState.getLastReceivedRawEvent(), pointerIdBits, policyFlags);
        return;
    }

    private void sendTouchExplorationGestureStartAndHoverEnterIfNeeded(int policyFlags) {
        if (this.mState.isTouchExploring() == true) goto L5;
        this.mDispatcher.sendAccessibilityEvent(512);
    L5:
        MotionEvent event = this.mState.getLastInjectedHoverEvent();
        if (event == null) goto L11;
        if (event.getActionMasked() != 10) goto L11;
        int pointerIdBits = event.getPointerIdBits();
        this.mDispatcher.sendMotionEvent(event, 9, this.mState.getLastReceivedRawEvent(), pointerIdBits, policyFlags);
        return;
    }

    private boolean isDraggingGesture(MotionEvent event) {
        float firstPtrX = event.getX(0);
        float firstPtrY = event.getY(0);
        float secondPtrX = event.getX(1);
        float secondPtrY = event.getY(1);
        float firstPtrDownX = this.mReceivedPointerTracker.getReceivedPointerDownX(0);
        float firstPtrDownY = this.mReceivedPointerTracker.getReceivedPointerDownY(0);
        float secondPtrDownX = this.mReceivedPointerTracker.getReceivedPointerDownX(1);
        float secondPtrDownY = this.mReceivedPointerTracker.getReceivedPointerDownY(1);
        return GestureUtils.isDraggingGesture(firstPtrDownX, firstPtrDownY, secondPtrDownX, secondPtrDownY, firstPtrX, firstPtrY, secondPtrX, secondPtrY, MAX_DRAGGING_ANGLE_COS);
    }

    private void computeDraggingPointerIdIfNeeded(MotionEvent event) {
        if (event.getPointerCount() == 2) goto L7;
        this.mDraggingPointerId = -1;
        return;
    L7:
        if (this.mDraggingPointerId == (-1)) goto L11;
        int pointerIndex = event.findPointerIndex(this.mDraggingPointerId);
        if (event.findPointerIndex(pointerIndex) < 0) goto L11;
        return;
    L11:
        float firstPtrX = event.getX(0);
        float firstPtrY = event.getY(0);
        int firstPtrId = event.getPointerId(0);
        float secondPtrX = event.getX(1);
        float secondPtrY = event.getY(1);
        int secondPtrId = event.getPointerId(1);
        if (getDistanceToClosestEdge(firstPtrX, firstPtrY) >= getDistanceToClosestEdge(secondPtrX, secondPtrY)) goto L14;
        int r6 = firstPtrId;
    L15:
        this.mDraggingPointerId = r6;
        return;
    L14:
        r6 = secondPtrId;
        goto L15
    }

    private float getDistanceToClosestEdge(float x, float y) {
        long width = this.mContext.getResources().getDisplayMetrics().widthPixels;
        long height = this.mContext.getResources().getDisplayMetrics().heightPixels;
        if (x >= (width - x)) goto L5;
        float distance = x;
    L7:
        if (distance <= y) goto L10;
        distance = y;
    L10:
        if (distance <= (height - y)) goto L13;
        float distance2 = height - y;
        return distance2;
    L13:
        return distance;
    L5:
        distance = width - x;
        goto L7
    }

    private MotionEvent computeDownEventForDrag(MotionEvent event) {
        if (this.mState.isTouchExploring() == false) goto L5;
        return null;
    L5:
        if (this.mDraggingPointerId == (-1)) goto L12;
        if (event == null) goto L13;
        float x = this.mReceivedPointerTracker.getReceivedPointerDownX(this.mDraggingPointerId);
        float y = this.mReceivedPointerTracker.getReceivedPointerDownY(this.mDraggingPointerId);
        long time = this.mReceivedPointerTracker.getReceivedPointerDownTime(this.mDraggingPointerId);
        MotionEvent.PointerCoords[] coords = {new MotionEvent.PointerCoords()};
        coords[0].x = x;
        coords[0].y = y;
        MotionEvent.PointerProperties[] properties = {new MotionEvent.PointerProperties()};
        properties[0].id = this.mDraggingPointerId;
        properties[0].toolType = 1;
        MotionEvent downEvent = MotionEvent.obtain(time, time, 0, 1, properties, coords, event.getMetaState(), event.getButtonState(), event.getXPrecision(), event.getYPrecision(), event.getDeviceId(), event.getEdgeFlags(), event.getSource(), event.getFlags());
        event.setDownTime(time);
        return downEvent;
    L13:
        return null;
    L12:
        return null;
    }

    private boolean allPointersDownOnBottomEdge(MotionEvent event) {
        long screenHeight = this.mContext.getResources().getDisplayMetrics().heightPixels;
        int i = 0;
    L4:
        if (i >= event.getPointerCount()) goto L13;
        int pointerId = event.getPointerId(i);
        float pointerDownY = this.mReceivedPointerTracker.getReceivedPointerDownY(pointerId);
        if (pointerDownY < (screenHeight - this.mEdgeSwipeHeightPixels)) goto L8;
        i = i + 1;
        goto L4
    L8:
        if (DEBUG == false) goto L17;
        Slog.d(LOG_TAG, "The pointer is not on the bottom edge" + pointerDownY);
        return false;
    L17:
        return false;
    L13:
        return true;
    }

    public TouchState getState() {
        return this.mState;
    }

    @Override // com.android.server.accessibility.BaseEventStreamTransformation, com.android.server.accessibility.EventStreamTransformation
    public void setNext(EventStreamTransformation next) {
        this.mDispatcher.setReceiver(next);
        super.setNext(next);
    }

    public void setServiceHandlesDoubleTap(boolean mode) {
        this.mGestureDetector.setServiceHandlesDoubleTap(mode);
    }

    public void setMultiFingerGesturesEnabled(boolean enabled) {
        this.mGestureDetector.setMultiFingerGesturesEnabled(enabled);
    }

    public void setTwoFingerPassthroughEnabled(boolean enabled) {
        this.mGestureDetector.setTwoFingerPassthroughEnabled(enabled);
    }

    public void setGestureDetectionPassthroughRegion(Region region) {
        this.mGestureDetectionPassthroughRegion = region;
    }

    public void setTouchExplorationPassthroughRegion(Region region) {
        this.mTouchExplorationPassthroughRegion = region;
    }

    public void setSendMotionEventsEnabled(boolean mode) {
        this.mGestureDetector.setSendMotionEventsEnabled(mode);
    }

    public boolean isSendMotionEventsEnabled() {
        return this.mGestureDetector.isSendMotionEventsEnabled();
    }

    public void setServiceDetectsGestures(boolean mode) {
        this.mState.setServiceDetectsGestures(mode);
    }

    private boolean shouldPerformGestureDetection(MotionEvent event) {
        if (this.mState.isServiceDetectingGestures() == false) goto L6;
        return false;
    L6:
        if (this.mState.isDelegating() == false) goto L8;
    L19:
        return false;
    L8:
        if (this.mState.isDragging() == true) goto L19;
        if (event.getActionMasked() != 0) goto L17;
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (this.mTouchExplorationPassthroughRegion.contains(x, y) == false) goto L15;
    L16:
        return false;
    L15:
        if (this.mGestureDetectionPassthroughRegion.contains(x, y) == true) goto L16;
        return true;
    L17:
        return true;
    }

    public void requestTouchExploration() {
        if (DEBUG == false) goto L6;
        Slog.d(LOG_TAG, "Starting touch explorer from service.");
    L6:
        if (this.mState.isServiceDetectingGestures() == true) goto L8;
        return;
    L8:
        if (this.mState.isTouchInteracting() == false) goto L22;
        this.mHandler.removeCallbacks(this.mSendHoverEnterAndMoveDelayed);
        int pointerId = this.mReceivedPointerTracker.getPrimaryPointerId();
        if (pointerId != (-1)) goto L14;
        MotionEvent event = this.mState.getLastReceivedEvent();
        if (event == null) goto L14;
        pointerId = event.getPointerId(0);
    L14:
        if (pointerId != (-1)) goto L17;
        Slog.e(LOG_TAG, "Unable to find a valid pointer for touch exploration.");
        return;
    L17:
        sendHoverExitAndTouchExplorationGestureEndIfNeeded(pointerId);
        int pointerIdBits = 1 << pointerId;
        int policyFlags = this.mState.getLastReceivedPolicyFlags();
        this.mSendHoverEnterAndMoveDelayed.setPointerIdBits(pointerIdBits);
        this.mSendHoverEnterAndMoveDelayed.setPolicyFlags(policyFlags);
        this.mSendHoverEnterAndMoveDelayed.run();
        SendHoverEnterAndMoveDelayed.m764$$Nest$mclear(this.mSendHoverEnterAndMoveDelayed);
        if (this.mReceivedPointerTracker.getReceivedPointerDownCount() != 0) goto L23;
        sendHoverExitAndTouchExplorationGestureEndIfNeeded(policyFlags);
        return;
    L23:
        return;
    }

    public void requestDragging(int pointerId) {
        if (this.mState.isServiceDetectingGestures() == true) goto L5;
        return;
    L5:
        if (pointerId >= 0) goto L7;
    L36:
        Slog.e(LOG_TAG, "Trying to drag with invalid pointer: " + pointerId);
        return;
    L7:
        if (pointerId > 32) goto L36;
        if (this.mReceivedPointerTracker.isReceivedPointerDown(pointerId) == false) goto L36;
        if (this.mState.isTouchExploring() == false) goto L20;
        if (SendHoverExitDelayed.m766$$Nest$misPending(this.mSendHoverExitDelayed) == false) goto L17;
        this.mSendHoverExitDelayed.forceSendAndRemove();
    L17:
        if (this.mSendTouchExplorationEndDelayed.isPending() == false) goto L20;
        this.mSendTouchExplorationEndDelayed.forceSendAndRemove();
    L20:
        if (this.mState.isTouchInteracting() == true) goto L23;
        Slog.e(LOG_TAG, "Error: Trying to drag from " + TouchState.getStateSymbolicName(this.mState.getState()));
        return;
    L23:
        this.mDraggingPointerId = pointerId;
        if (DEBUG == false) goto L26;
        Slog.d(LOG_TAG, "Drag requested on pointer " + this.mDraggingPointerId);
    L26:
        MotionEvent event = this.mState.getLastReceivedEvent();
        MotionEvent rawEvent = this.mState.getLastReceivedRawEvent();
        if (event == null) goto L34;
        if (rawEvent == null) goto L34;
        int policyFlags = this.mState.getLastReceivedPolicyFlags();
        int pointerIdBits = 1 << this.mDraggingPointerId;
        event.setEdgeFlags(this.mReceivedPointerTracker.getLastReceivedDownEdgeFlags());
        MotionEvent downEvent = computeDownEventForDrag(event);
        this.mState.startDragging();
        if (downEvent == null) goto L33;
        this.mDispatcher.sendMotionEvent(downEvent, 0, rawEvent, pointerIdBits, policyFlags);
        this.mDispatcher.sendMotionEvent(event, 2, rawEvent, pointerIdBits, policyFlags);
        return;
    L33:
        this.mDispatcher.sendMotionEvent(event, 0, rawEvent, pointerIdBits, policyFlags);
        return;
    L34:
        Slog.e(LOG_TAG, "Unable to start dragging: unable to get last event.");
    }

    public void requestDelegating() {
        if (this.mState.isServiceDetectingGestures() == true) goto L5;
        return;
    L5:
        if (this.mState.isTouchExploring() == false) goto L13;
        if (SendHoverExitDelayed.m766$$Nest$misPending(this.mSendHoverExitDelayed) == false) goto L10;
        this.mSendHoverExitDelayed.forceSendAndRemove();
    L10:
        if (this.mSendTouchExplorationEndDelayed.isPending() == false) goto L13;
        this.mSendTouchExplorationEndDelayed.forceSendAndRemove();
    L13:
        if (this.mState.isTouchInteracting() == false) goto L15;
    L18:
        MotionEvent event = this.mState.getLastReceivedEvent();
        MotionEvent rawEvent = this.mState.getLastReceivedRawEvent();
        if (event == null) goto L26;
        if (rawEvent == null) goto L26;
        int policyFlags = this.mState.getLastReceivedPolicyFlags();
        if (this.mState.isDragging() == false) goto L25;
        int pointerIdBits = 1 << this.mDraggingPointerId;
        this.mDispatcher.sendMotionEvent(event, 1, rawEvent, pointerIdBits, policyFlags);
    L25:
        this.mState.startDelegating();
        this.mDispatcher.sendDownForAllNotInjectedPointers(event, policyFlags);
        return;
    L26:
        Slog.d(LOG_TAG, "Unable to start delegating: unable to get last received event.");
        return;
    L15:
        if (this.mState.isDragging() == true) goto L18;
        Slog.e(LOG_TAG, "Error: Trying to delegate from " + TouchState.getStateSymbolicName(this.mState.getState()));
    }

    private static void checkForMalformedEvent(MotionEvent event) {
        if (event.getPointerCount() < 0) goto L25;
        int i = 0;
    L6:
        if (i >= event.getPointerCount()) goto L23;
        event.getPointerId(i);     // Catch: Exception -> L16
        float x = event.getX(i);     // Catch: Exception -> L16
        float y = event.getY(i);     // Catch: Exception -> L16
        if (Float.isNaN(x) == true) goto L19;
        if (Float.isNaN(y) == true) goto L19;
        if (x < 0.0f) goto L19;
        if (y < 0.0f) goto L19;
        i = i + 1;     // Catch: Exception -> L16
    L19:
        throw new IllegalArgumentException("Invalid coordinates: (" + x + ", " + y + ")");     // Catch: Exception -> L16
    L16:
        e = move-exception;
        throw new IllegalArgumentException("Encountered exception getting details of pointer " + i + " / " + event.getPointerCount(), e);
    L23:
        return;
    L25:
        throw new IllegalArgumentException("Invalid pointer count: " + event.getPointerCount());
    }

    private void dispatchGesture(AccessibilityGestureEvent gestureEvent) {
        if (DEBUG == false) goto L5;
        Slog.d(LOG_TAG, "Dispatching gesture event:" + gestureEvent.toString());
    L5:
        this.mAms.onGesture(gestureEvent);
    }

    public String toString() {
        return "TouchExplorer { mTouchState: " + this.mState + ", mDetermineUserIntentTimeout: " + this.mDetermineUserIntentTimeout + ", mDoubleTapSlop: " + this.mDoubleTapSlop + ", mDraggingPointerId: " + this.mDraggingPointerId + " }";
    }

    void setHasResetInputDispatcherState(boolean value) {
        this.mState.setHasResetInputDispatcherState(value);
    }
}
