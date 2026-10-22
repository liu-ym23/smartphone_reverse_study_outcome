package com.android.server.accessibility.magnification;

import android.content.Context;
import android.graphics.Point;
import android.os.SystemClock;
import android.util.MathUtils;
import android.util.Slog;
import android.view.Display;
import android.view.MotionEvent;
import com.android.internal.accessibility.util.AccessibilityStatsLogUtils;
import com.android.server.accessibility.AccessibilityTraceManager;
import com.android.server.accessibility.gestures.GestureMatcher;
import com.android.server.accessibility.gestures.MultiTap;
import com.android.server.accessibility.gestures.MultiTapAndHold;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WindowMagnificationGestureHandler extends MagnificationGestureHandler {
    private static final boolean DEBUG_DETECTING = false;
    private static final boolean DEBUG_STATE_TRANSITIONS = false;
    private static final float MAX_SCALE = 0.0f;
    private static final float MIN_SCALE = 1.0f;
    private final Context mContext;
    State mCurrentState;
    final DelegatingState mDelegatingState;
    final DetectingState mDetectingState;
    private final MagnificationConnectionManager mMagnificationConnectionManager;
    private MotionEventDispatcherDelegate mMotionEventDispatcherDelegate;
    final PanningScalingGestureState mObservePanningScalingState;
    State mPreviousState;
    private final Point mTempPoint;
    private long mTripleTapAndHoldStartedTime;
    final ViewportDraggingState mViewportDraggingState;

    final class DelegatingState implements State {
        private final MotionEventDispatcherDelegate mMotionEventDispatcherDelegate;
        final /* synthetic */ WindowMagnificationGestureHandler this$0;

        DelegatingState(WindowMagnificationGestureHandler this$0, MotionEventDispatcherDelegate motionEventDispatcherDelegate) {
            this.this$0 = this$0;
            this.mMotionEventDispatcherDelegate = motionEventDispatcherDelegate;
        }

        @Override // com.android.server.accessibility.magnification.WindowMagnificationGestureHandler.State
        public void onMotionEvent(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
            this.mMotionEventDispatcherDelegate.dispatchMotionEvent(event, rawEvent, policyFlags);
            switch(event.getActionMasked()) {
                case 1: goto L5;
                case 2: goto L7;
                case 3: goto L5;
                default: goto L7;
            };
        L5:
            WindowMagnificationGestureHandler.m870$$Nest$mtransitionTo(this.this$0, this.this$0.mDetectingState);
            return;
        }
    }

    final class DetectingState implements State, MagnificationGesturesObserver.Callback {
        private final MagnificationGesturesObserver mGesturesObserver;
        final /* synthetic */ WindowMagnificationGestureHandler this$0;

        DetectingState(WindowMagnificationGestureHandler this$0, Context context) {
            this.this$0 = this$0;
            if (this$0.mDetectSingleFingerTripleTap == false) goto L5;
            int r2 = 3;
        L7:
            if (this$0.mDetectSingleFingerTripleTap == false) goto L9;
            int r3 = 105;
        L10:
            MultiTap multiTap = new MultiTap(context, r2, r3, MagnificationGestureMatcher.getMagnificationMultiTapTimeout(WindowMagnificationGestureHandler.m866$$Nest$fgetmContext(this$0)), null);
            if (this$0.mDetectSingleFingerTripleTap == false) goto L13;
            int r4 = 3;
        L15:
            if (this$0.mDetectSingleFingerTripleTap == false) goto L17;
            int r5 = 106;
        L18:
            MultiTapAndHold multiTapAndHold = new MultiTapAndHold(context, r4, r5, MagnificationGestureMatcher.getMagnificationMultiTapTimeout(WindowMagnificationGestureHandler.m866$$Nest$fgetmContext(this$0)), null);
            this.mGesturesObserver = new MagnificationGesturesObserver(this, new GestureMatcher[]{new SimpleSwipe(context), multiTap, multiTapAndHold, new TwoFingersDownOrSwipe(context)});
            return;
        L17:
            r5 = 104;
            goto L18
        L13:
            r4 = 1;
            goto L15
        L9:
            r3 = 103;
            goto L10
        L5:
            r2 = 1;
            goto L7
        }

        @Override // com.android.server.accessibility.magnification.WindowMagnificationGestureHandler.State
        public void onMotionEvent(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
            this.mGesturesObserver.onMotionEvent(event, rawEvent, policyFlags);
        }

        public String toString() {
            return "DetectingState{mGestureTimeoutObserver=" + this.mGesturesObserver + '}';
        }

        @Override // com.android.server.accessibility.magnification.MagnificationGesturesObserver.Callback
        public boolean shouldStopDetection(MotionEvent motionEvent) {
            if (WindowMagnificationGestureHandler.m867$$Nest$fgetmMagnificationConnectionManager(this.this$0).isWindowMagnifierEnabled(this.this$0.mDisplayId) == false) goto L5;
        L9:
            return false;
        L5:
            if (this.this$0.mDetectSingleFingerTripleTap == true) goto L9;
            if (this.this$0.mDetectTwoFingerTripleTap == true) goto L8;
        L8:
            return true;
        }

        @Override // com.android.server.accessibility.magnification.MagnificationGesturesObserver.Callback
        public void onGestureCompleted(int gestureId, long lastDownEventTime, List<MotionEventInfo> delayedEventQueue, MotionEvent motionEvent) {
            if (WindowMagnificationGestureHandler.m871$$Nest$sfgetDEBUG_DETECTING() == false) goto L6;
            Slog.d(this.this$0.mLogTag, "onGestureDetected : gesture = " + MagnificationGestureMatcher.gestureIdToString(gestureId));
            Slog.d(this.this$0.mLogTag, "onGestureDetected : delayedEventQueue = " + delayedEventQueue);
        L6:
            if (gestureId != 101) goto L11;
            if (WindowMagnificationGestureHandler.m867$$Nest$fgetmMagnificationConnectionManager(this.this$0).pointersInWindow(this.this$0.mDisplayId, motionEvent) <= 0) goto L11;
            WindowMagnificationGestureHandler.m870$$Nest$mtransitionTo(this.this$0, this.this$0.mObservePanningScalingState);
            return;
        L11:
            if (gestureId != 105) goto L14;
            WindowMagnificationGestureHandler.m869$$Nest$monTripleTap(this.this$0, motionEvent);
            return;
        L14:
            if (gestureId != 106) goto L16;
            this.this$0.onTripleTapAndHold(motionEvent);
            return;
        L16:
            WindowMagnificationGestureHandler.m868$$Nest$fgetmMotionEventDispatcherDelegate(this.this$0).sendDelayedMotionEvents(delayedEventQueue, lastDownEventTime);
            changeToDelegateStateIfNeed(motionEvent);
        }

        @Override // com.android.server.accessibility.magnification.MagnificationGesturesObserver.Callback
        public void onGestureCancelled(long lastDownEventTime, List<MotionEventInfo> delayedEventQueue, MotionEvent motionEvent) {
            if (WindowMagnificationGestureHandler.m871$$Nest$sfgetDEBUG_DETECTING() == false) goto L5;
            Slog.d(this.this$0.mLogTag, "onGestureCancelled : delayedEventQueue = " + delayedEventQueue);
        L5:
            WindowMagnificationGestureHandler.m868$$Nest$fgetmMotionEventDispatcherDelegate(this.this$0).sendDelayedMotionEvents(delayedEventQueue, lastDownEventTime);
            changeToDelegateStateIfNeed(motionEvent);
        }

        private void changeToDelegateStateIfNeed(MotionEvent motionEvent) {
            if (motionEvent != null) goto L4;
        L8:
            WindowMagnificationGestureHandler.m870$$Nest$mtransitionTo(this.this$0, this.this$0.mDelegatingState);
            return;
        L4:
            if (motionEvent.getActionMasked() != 1) goto L6;
            return;
        L6:
            if (motionEvent.getActionMasked() != 3) goto L8;
        }
    }

    final class PanningScalingGestureState implements State {
        private final PanningScalingHandler mPanningScalingHandler;
        final /* synthetic */ WindowMagnificationGestureHandler this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmPanningScalingHandler, reason: not valid java name */
        static /* bridge */ /* synthetic */ PanningScalingHandler m872$$Nest$fgetmPanningScalingHandler(PanningScalingGestureState r0) {
            return r0.mPanningScalingHandler;
        }

        PanningScalingGestureState(WindowMagnificationGestureHandler this$0, PanningScalingHandler panningScalingHandler) {
            this.this$0 = this$0;
            this.mPanningScalingHandler = panningScalingHandler;
        }

        @Override // com.android.server.accessibility.magnification.WindowMagnificationGestureHandler.State
        public void onEnter() {
            this.mPanningScalingHandler.setEnabled(true);
        }

        @Override // com.android.server.accessibility.magnification.WindowMagnificationGestureHandler.State
        public void onExit() {
            this.mPanningScalingHandler.setEnabled(false);
            WindowMagnificationGestureHandler.m867$$Nest$fgetmMagnificationConnectionManager(this.this$0).persistScale(this.this$0.mDisplayId);
            clear();
        }

        @Override // com.android.server.accessibility.magnification.WindowMagnificationGestureHandler.State
        public void onMotionEvent(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
            int action = event.getActionMasked();
            if (action != 1) goto L5;
        L6:
            WindowMagnificationGestureHandler.m870$$Nest$mtransitionTo(this.this$0, this.this$0.mDetectingState);
            return;
        L5:
            if (action == 3) goto L6;
        }

        @Override // com.android.server.accessibility.magnification.WindowMagnificationGestureHandler.State
        public void clear() {
            this.mPanningScalingHandler.clear();
        }

        public String toString() {
            return "PanningScalingState{mPanningScalingHandler=" + this.mPanningScalingHandler + '}';
        }
    }

    interface State {
        void onMotionEvent(MotionEvent r1, MotionEvent r2, int r3);

        default void clear() {
        }

        default void onEnter() {
        }

        default void onExit() {
        }

        default String name() {
            return getClass().getSimpleName();
        }

        static String nameOf(State s) {
            if (s != null) goto L6;
            return "null";
        L6:
            return s.name();
        }
    }

    final class ViewportDraggingState implements State {
        boolean mEnabledBeforeDrag;
        private float mLastX;
        private float mLastY;
        final /* synthetic */ WindowMagnificationGestureHandler this$0;

        ViewportDraggingState(WindowMagnificationGestureHandler this$0) {
            this.this$0 = this$0;
            this.mLastX = Float.NaN;
            this.mLastY = Float.NaN;
        }

        @Override // com.android.server.accessibility.magnification.WindowMagnificationGestureHandler.State
        public void onMotionEvent(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
            int action = event.getActionMasked();
            switch(action) {
                case 1: goto L11;
                case 2: goto L6;
                case 3: goto L11;
                default: goto L14;
            };
        L11:
            this.this$0.releaseTripleTapAndHold();
            return;
        L14:
            return;
        L6:
            if (Float.isNaN(this.mLastX) == false) goto L8;
        L10:
            float offsetX = event.getX();
            this.mLastX = offsetX;
            this.mLastY = event.getY();
            return;
        L8:
            if (Float.isNaN(this.mLastY) == true) goto L10;
            float offsetX2 = event.getX() - this.mLastX;
            float offsetY = event.getY() - this.mLastY;
            WindowMagnificationGestureHandler.m867$$Nest$fgetmMagnificationConnectionManager(this.this$0).moveWindowMagnification(this.this$0.mDisplayId, offsetX2, offsetY);
            goto L10
        }

        @Override // com.android.server.accessibility.magnification.WindowMagnificationGestureHandler.State
        public void clear() {
            this.mLastX = Float.NaN;
            this.mLastY = Float.NaN;
        }

        @Override // com.android.server.accessibility.magnification.WindowMagnificationGestureHandler.State
        public void onExit() {
            clear();
        }

        public String toString() {
            return "ViewportDraggingState{mLastX=" + this.mLastX + ",mLastY=" + this.mLastY + '}';
        }
    }

    public static /* synthetic */ void $r8$lambda$KUdmCQWVJQRNDImpicXr09CRk3k(WindowMagnificationGestureHandler r0, MotionEvent r1, MotionEvent r2, int r3) {
        r0.lambda$new$0(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m866$$Nest$fgetmContext(WindowMagnificationGestureHandler r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMagnificationConnectionManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ MagnificationConnectionManager m867$$Nest$fgetmMagnificationConnectionManager(WindowMagnificationGestureHandler r0) {
        return r0.mMagnificationConnectionManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMotionEventDispatcherDelegate, reason: not valid java name */
    static /* bridge */ /* synthetic */ MotionEventDispatcherDelegate m868$$Nest$fgetmMotionEventDispatcherDelegate(WindowMagnificationGestureHandler r0) {
        return r0.mMotionEventDispatcherDelegate;
    }

    /* JADX INFO: renamed from: -$$Nest$monTripleTap, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m869$$Nest$monTripleTap(WindowMagnificationGestureHandler r0, MotionEvent r1) {
        r0.onTripleTap(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mtransitionTo, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m870$$Nest$mtransitionTo(WindowMagnificationGestureHandler r0, State r1) {
        r0.transitionTo(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG_DETECTING, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m871$$Nest$sfgetDEBUG_DETECTING() {
        return DEBUG_DETECTING;
    }

    static {
        DEBUG_STATE_TRANSITIONS = MagnificationGestureHandler.DEBUG_ALL | false;
        DEBUG_DETECTING = MagnificationGestureHandler.DEBUG_ALL | false;
        MAX_SCALE = MagnificationScaleProvider.MAX_SCALE;
    }

    public WindowMagnificationGestureHandler(Context context, MagnificationConnectionManager magnificationConnectionManager, AccessibilityTraceManager trace, MagnificationGestureHandler.Callback callback, boolean detectSingleFingerTripleTap, boolean detectTwoFingerTripleTap, boolean detectShortcutTrigger, int displayId) {
        super(displayId, detectSingleFingerTripleTap, detectTwoFingerTripleTap, detectShortcutTrigger, trace, callback);
        this.mTempPoint = new Point();
        this.mTripleTapAndHoldStartedTime = 0;
        if (MagnificationGestureHandler.DEBUG_ALL == false) goto L6;
        Slog.i(this.mLogTag, "WindowMagnificationGestureHandler() , displayId = " + displayId + ")");
    L6:
        this.mContext = context;
        this.mMagnificationConnectionManager = magnificationConnectionManager;
        this.mMotionEventDispatcherDelegate = new MotionEventDispatcherDelegate(context, new WindowMagnificationGestureHandler$$ExternalSyntheticLambda0(this));
        this.mDelegatingState = new DelegatingState(this, this.mMotionEventDispatcherDelegate);
        this.mDetectingState = new DetectingState(this, context);
        this.mViewportDraggingState = new ViewportDraggingState(this);
        this.mObservePanningScalingState = new PanningScalingGestureState(this, new PanningScalingHandler(context, MAX_SCALE, 1.0f, true, new AnonymousClass1(this)));
        transitionTo(this.mDetectingState);
    }

    private /* synthetic */ void lambda$new$0(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        dispatchTransformedEvent(event, rawEvent, policyFlags);
    }

    @Override // com.android.server.accessibility.magnification.MagnificationGestureHandler
    void handleMouseOrStylusEvent(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
    }

    @Override // com.android.server.accessibility.magnification.MagnificationGestureHandler
    void onMotionEventInternal(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (event.getSource() == 4098) goto L5;
        return;
    L5:
        PanningScalingGestureState.m872$$Nest$fgetmPanningScalingHandler(this.mObservePanningScalingState).onTouchEvent(event);
        this.mCurrentState.onMotionEvent(event, rawEvent, policyFlags);
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public void clearEvents(int inputSource) {
        if (inputSource != 4098) goto L5;
        resetToDetectState();
    L5:
        super.clearEvents(inputSource);
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public void onDestroy() {
        if (MagnificationGestureHandler.DEBUG_ALL == false) goto L5;
        Slog.i(this.mLogTag, "onDestroy(); delayed = " + this.mDetectingState.toString());
    L5:
        this.mMagnificationConnectionManager.disableWindowMagnification(this.mDisplayId, true);
        resetToDetectState();
    }

    @Override // com.android.server.accessibility.magnification.MagnificationGestureHandler
    public void handleShortcutTriggered() {
        Point screenSize = this.mTempPoint;
        getScreenSize(this.mTempPoint);
        toggleMagnification(screenSize.x / 2.0f, screenSize.y / 2.0f, 0);
    }

    private void getScreenSize(Point outSize) {
        Display display = this.mContext.getDisplay();
        display.getRealSize(outSize);
    }

    @Override // com.android.server.accessibility.magnification.MagnificationGestureHandler
    public int getMode() {
        return 2;
    }

    private void enableWindowMagnifier(float centerX, float centerY, int windowPosition) {
        if (MagnificationGestureHandler.DEBUG_ALL == false) goto L5;
        Slog.i(this.mLogTag, "enableWindowMagnifier :" + centerX + ", " + centerY + ", " + windowPosition);
    L5:
        float scale = MathUtils.constrain(this.mMagnificationConnectionManager.getPersistedScale(this.mDisplayId), 1.0f, MAX_SCALE);
        this.mMagnificationConnectionManager.enableWindowMagnification(this.mDisplayId, scale, centerX, centerY, windowPosition);
    }

    private void disableWindowMagnifier() {
        if (MagnificationGestureHandler.DEBUG_ALL == false) goto L5;
        Slog.i(this.mLogTag, "disableWindowMagnifier()");
    L5:
        this.mMagnificationConnectionManager.disableWindowMagnification(this.mDisplayId, false);
    }

    private void toggleMagnification(float centerX, float centerY, int windowPosition) {
        if (this.mMagnificationConnectionManager.isWindowMagnifierEnabled(this.mDisplayId) == false) goto L5;
        disableWindowMagnifier();
        return;
    L5:
        enableWindowMagnifier(centerX, centerY, windowPosition);
    }

    private void onTripleTap(MotionEvent up) {
        if (DEBUG_DETECTING == false) goto L5;
        Slog.i(this.mLogTag, "onTripleTap()");
    L5:
        toggleMagnification(up.getX(), up.getY(), 0);
    }

    void onTripleTapAndHold(MotionEvent up) {
        if (DEBUG_DETECTING == false) goto L5;
        Slog.i(this.mLogTag, "onTripleTapAndHold()");
    L5:
        ViewportDraggingState r0 = this.mViewportDraggingState;
        r0.mEnabledBeforeDrag = this.mMagnificationConnectionManager.isWindowMagnifierEnabled(this.mDisplayId);
        enableWindowMagnifier(up.getX(), up.getY(), 1);
        this.mTripleTapAndHoldStartedTime = SystemClock.uptimeMillis();
        transitionTo(this.mViewportDraggingState);
    }

    void releaseTripleTapAndHold() {
        if (this.mViewportDraggingState.mEnabledBeforeDrag == true) goto L5;
        this.mMagnificationConnectionManager.disableWindowMagnification(this.mDisplayId, true);
    L5:
        transitionTo(this.mDetectingState);
        if (this.mTripleTapAndHoldStartedTime == 0) goto L9;
        long duration = SystemClock.uptimeMillis() - this.mTripleTapAndHoldStartedTime;
        logMagnificationTripleTapAndHoldSession(duration);
        this.mTripleTapAndHoldStartedTime = 0;
        return;
    }

    void logMagnificationTripleTapAndHoldSession(long duration) {
        AccessibilityStatsLogUtils.logMagnificationTripleTapAndHoldSession(duration);
    }

    void resetToDetectState() {
        transitionTo(this.mDetectingState);
    }

    private void transitionTo(State state) {
        if (DEBUG_STATE_TRANSITIONS == false) goto L5;
        String r0 = this.mLogTag;
        StringBuilder r1 = new StringBuilder();
        r1.append("state transition: ");
        r1.append((State.nameOf(this.mCurrentState) + " -> " + State.nameOf(state) + " at " + Arrays.asList((StackTraceElement[]) Arrays.copyOfRange(new RuntimeException().getStackTrace(), 1, 5))).replace(getClass().getName(), ""));
        Slog.i(r0, r1.toString());
    L5:
        this.mPreviousState = this.mCurrentState;
        if (this.mPreviousState == null) goto L8;
        this.mPreviousState.onExit();
    L8:
        this.mCurrentState = state;
        if (this.mCurrentState == null) goto L12;
        this.mCurrentState.onEnter();
        return;
    }

    public String toString() {
        return "WindowMagnificationGestureHandler{mDetectingState=" + this.mDetectingState + ", mDelegatingState=" + this.mDelegatingState + ", mViewportDraggingState=" + this.mViewportDraggingState + ", mMagnifiedInteractionState=" + this.mObservePanningScalingState + ", mCurrentState=" + State.nameOf(this.mCurrentState) + ", mPreviousState=" + State.nameOf(this.mPreviousState) + ", mMagnificationConnectionManager=" + this.mMagnificationConnectionManager + ", mDisplayId=" + this.mDisplayId + '}';
    }
}
