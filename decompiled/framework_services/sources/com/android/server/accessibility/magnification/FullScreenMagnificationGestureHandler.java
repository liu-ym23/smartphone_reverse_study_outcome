package com.android.server.accessibility.magnification;

import android.R;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.util.MathUtils;
import android.util.Slog;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.android.modules.expresslog.Histogram;
import com.android.server.accessibility.AccessibilityTraceManager;
import com.android.server.accessibility.gestures.GestureUtils;
import com.android.server.usb.descriptors.UsbACInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FullScreenMagnificationGestureHandler extends MagnificationGestureHandler {
    private static final boolean DEBUG_DETECTING = false;
    private static final boolean DEBUG_PANNING_SCALING = false;
    private static final boolean DEBUG_STATE_TRANSITIONS = false;
    private static final float MAX_SCALE = 0.0f;
    private static final float MIN_SCALE = 1.0f;
    static final int OVERSCROLL_LEFT_EDGE = 1;
    static final int OVERSCROLL_NONE = 0;
    static final int OVERSCROLL_RIGHT_EDGE = 2;
    static final int OVERSCROLL_VERTICAL_EDGE = 3;
    State mCurrentState;
    final DelegatingState mDelegatingState;
    final DetectingState mDetectingState;
    final FullScreenMagnificationController mFullScreenMagnificationController;
    private final FullScreenMagnificationVibrationHelper mFullScreenMagnificationVibrationHelper;
    private final boolean mIsWatch;
    private final FullScreenMagnificationController.MagnificationInfoChangedCallback mMagnificationInfoChangedCallback;
    private final MagnificationLogger mMagnificationLogger;
    private final int mMaximumVelocity;
    private final int mMinimumVelocity;
    private final MouseEventHandler mMouseEventHandler;
    final OneFingerPanningSettingsProvider mOneFingerPanningSettingsProvider;
    private final float mOverscrollEdgeSlop;
    final OverscrollHandler mOverscrollHandler;
    final PanningScalingState mPanningScalingState;
    State mPreviousState;
    private final WindowMagnificationPromptController mPromptController;
    private final ScreenStateReceiver mScreenStateReceiver;
    final SinglePanningState mSinglePanningState;
    private VelocityTracker mVelocityTracker;
    final ViewportDraggingState mViewportDraggingState;

    final class DelegatingState implements State {
        public long mLastDelegatedDownEventTime;
        final /* synthetic */ FullScreenMagnificationGestureHandler this$0;

        DelegatingState(FullScreenMagnificationGestureHandler this$0) {
            this.this$0 = this$0;
        }

        @Override // com.android.server.accessibility.magnification.FullScreenMagnificationGestureHandler.State
        public void onMotionEvent(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
            switch(event.getActionMasked()) {
                case 0: goto L6;
                case 1: goto L5;
                case 2: goto L8;
                case 3: goto L5;
                default: goto L8;
            };
        L5:
            this.this$0.transitionTo(this.this$0.mDetectingState);
            goto L8
        L6:
            this.this$0.transitionTo(this.this$0.mDelegatingState);
            this.mLastDelegatedDownEventTime = event.getDownTime();
        L8:
            if (this.this$0.getNext() == null) goto L11;
            event.setDownTime(this.mLastDelegatedDownEventTime);
            this.this$0.dispatchTransformedEvent(event, rawEvent, policyFlags);
            return;
        }
    }

    class DetectingState implements State, Handler.Callback {
        private static final Histogram HISTOGRAM_FIRST_INTERVAL = null;
        private static final Histogram HISTOGRAM_SECOND_INTERVAL = null;
        private static final int MESSAGE_ON_TRIPLE_TAP_AND_HOLD = 1;
        private static final int MESSAGE_TRANSITION_TO_DELEGATING_STATE = 2;
        private static final int MESSAGE_TRANSITION_TO_PANNINGSCALING_STATE = 3;
        private MotionEventInfo mDelayedEventQueue;
        private PointF mFirstPointerDownLocation;
        Handler mHandler;
        private long mLastDetectingDownEventTime;
        private MotionEvent mLastDown;
        private MotionEvent mLastUp;
        final int mLongTapMinDelay;
        final int mMultiTapMaxDelay;
        final int mMultiTapMaxDistance;
        private MotionEvent mPreLastDown;
        private MotionEvent mPreLastUp;
        private PointF mSecondPointerDownLocation;
        boolean mShortcutTriggered;
        final int mSwipeMinDistance;
        final TwoFingerDoubleTapHandler mTwoFingerDoubleTapHandler;
        final /* synthetic */ FullScreenMagnificationGestureHandler this$0;

        final class TwoFingerDoubleTapHandler {
            private static final int TWO_FINGER_GESTURE_MAX_TAPS = 2;
            private int mCompletedTapCount;
            private boolean mIsTwoFingerCountReached;
            final /* synthetic */ DetectingState this$1;

            /* JADX INFO: renamed from: -$$Nest$fputmCompletedTapCount, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m815$$Nest$fputmCompletedTapCount(TwoFingerDoubleTapHandler r0, int r1) {
                r0.mCompletedTapCount = r1;
            }

            /* JADX INFO: renamed from: -$$Nest$monMove, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m816$$Nest$monMove(TwoFingerDoubleTapHandler r0, MotionEvent r1) {
                r0.onMove(r1);
            }

            /* JADX INFO: renamed from: -$$Nest$monPointerDown, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m817$$Nest$monPointerDown(TwoFingerDoubleTapHandler r0, MotionEvent r1) {
                r0.onPointerDown(r1);
            }

            /* JADX INFO: renamed from: -$$Nest$monPointerUp, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m818$$Nest$monPointerUp(TwoFingerDoubleTapHandler r0) {
                r0.onPointerUp();
            }

            /* JADX INFO: renamed from: -$$Nest$monUp, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m819$$Nest$monUp(TwoFingerDoubleTapHandler r0, MotionEvent r1) {
                r0.onUp(r1);
            }

            /* JADX INFO: renamed from: -$$Nest$mshouldLogTwoFingerDoubleTap, reason: not valid java name */
            static /* bridge */ /* synthetic */ boolean m820$$Nest$mshouldLogTwoFingerDoubleTap(TwoFingerDoubleTapHandler r0) {
                return r0.shouldLogTwoFingerDoubleTap();
            }

            TwoFingerDoubleTapHandler(DetectingState this$1) {
                this.this$1 = this$1;
                this.mCompletedTapCount = 0;
                this.mIsTwoFingerCountReached = false;
            }

            private void onPointerDown(MotionEvent event) {
                if (this.this$1.this$0.mDetectTwoFingerTripleTap == true) goto L5;
            L7:
                boolean r0 = false;
            L8:
                this.mIsTwoFingerCountReached = r0;
                this.this$1.mHandler.removeMessages(2);
                if (event.getPointerCount() == 2) goto L11;
                this.this$1.transitionToDelegatingStateAndClear();
                return;
            L11:
                if (isMultiFingerMultiTapTriggered(1, event) == false) goto L14;
                this.this$1.afterLongTapTimeoutTransitionToDraggingState(event);
                return;
            L14:
                if (this.this$1.this$0.mDetectTwoFingerTripleTap == false) goto L17;
                this.this$1.afterMultiTapTimeoutTransitionToDelegatingState();
            L17:
                if (this.this$1.isActivated() == false) goto L22;
                this.this$1.storePointerDownLocation(DetectingState.m813$$Nest$fgetmSecondPointerDownLocation(this.this$1), event);
                this.this$1.mHandler.sendEmptyMessageDelayed(3, ViewConfiguration.getTapTimeout());
                return;
            L22:
                return;
            L5:
                if (event.getPointerCount() != 2) goto L7;
                r0 = true;
                goto L8
            }

            private void onMove(MotionEvent event) {
                if (this.this$1.isFingerDown() == false) goto L45;
                if (GestureUtils.distance(DetectingState.m811$$Nest$fgetmLastDown(this.this$1), event) <= this.this$1.mSwipeMinDistance) goto L45;
                if (this.this$1.isMultiTapTriggered(2) == false) goto L12;
                if (event.getPointerCount() != 1) goto L12;
                this.this$1.transitionToViewportDraggingStateAndClear(event);
                return;
            L12:
                if (isMultiFingerMultiTapTriggered(1, event) == false) goto L17;
                if (event.getPointerCount() != 2) goto L17;
                this.this$1.transitionToViewportDraggingStateAndClear(event);
                return;
            L17:
                if (this.this$1.isActivated() == false) goto L27;
                if (event.getPointerCount() != 2) goto L27;
                if (this.this$1.this$0.mOverscrollHandler != null) goto L23;
            L25:
                this.this$1.transitToPanningScalingStateAndClear();
                return;
            L23:
                if (FullScreenMagnificationGestureHandler.m799$$Nest$moverscrollState(this.this$1.this$0, event, DetectingState.m810$$Nest$fgetmFirstPointerDownLocation(this.this$1)) != 3) goto L25;
                this.this$1.transitionToDelegatingStateAndClear();
                return;
            L27:
                if (this.this$1.this$0.mOneFingerPanningSettingsProvider.isOneFingerPanningEnabled() == false) goto L42;
                if (this.this$1.isActivated() == false) goto L42;
                if (event.getPointerCount() != 1) goto L42;
                if (this.this$1.this$0.mOverscrollHandler == null) goto L38;
                if (FullScreenMagnificationGestureHandler.m799$$Nest$moverscrollState(this.this$1.this$0, event, DetectingState.m810$$Nest$fgetmFirstPointerDownLocation(this.this$1)) != 3) goto L38;
                this.this$1.transitionToDelegatingStateAndClear();
                return;
            L38:
                if (FullScreenMagnificationGestureHandler.m799$$Nest$moverscrollState(this.this$1.this$0, event, DetectingState.m810$$Nest$fgetmFirstPointerDownLocation(this.this$1)) == 0) goto L40;
                this.this$1.transitionToDelegatingStateAndClear();
                return;
            L40:
                this.this$1.transitToSinglePanningStateAndClear();
                return;
            L42:
                if (this.mIsTwoFingerCountReached == true) goto L59;
                this.this$1.transitionToDelegatingStateAndClear();
                return;
            L59:
                return;
            L45:
                if (this.this$1.isActivated() == true) goto L47;
                return;
            L47:
                if (this.this$1.pointerDownValid(DetectingState.m813$$Nest$fgetmSecondPointerDownLocation(this.this$1)) == true) goto L49;
                return;
            L49:
                if (GestureUtils.distanceClosestPointerToPoint(DetectingState.m813$$Nest$fgetmSecondPointerDownLocation(this.this$1), event) <= this.this$1.mSwipeMinDistance) goto L63;
                this.this$1.storePointerDownLocation(DetectingState.m813$$Nest$fgetmSecondPointerDownLocation(this.this$1), event);
                this.this$1.mHandler.sendEmptyMessageDelayed(3, ViewConfiguration.getTapTimeout());
                return;
            }

            private void onPointerUp() {
                if (this.mIsTwoFingerCountReached == true) goto L6;
                this.this$1.transitionToDelegatingStateAndClear();
                return;
            }

            private void onUp(MotionEvent event) {
                if (this.this$1.this$0.mFullScreenMagnificationController.magnificationRegionContains(this.this$1.this$0.mDisplayId, event.getX(), event.getY()) == true) goto L6;
                this.this$1.transitionToDelegatingStateAndClear();
                return;
            L6:
                if (isMultiFingerMultiTapTriggered(2, event) == false) goto L9;
                this.this$1.onTripleTap(event);
                return;
            L9:
                if (this.this$1.isMultiTapTriggered(3) == false) goto L12;
                this.this$1.onTripleTap(event);
                return;
            L12:
                if (this.this$1.isFingerDown() == true) goto L14;
                return;
            L14:
                if (this.this$1.timeBetween(DetectingState.m811$$Nest$fgetmLastDown(this.this$1), DetectingState.m812$$Nest$fgetmLastUp(this.this$1)) >= this.this$1.mLongTapMinDelay) goto L18;
                if (GestureUtils.distance(DetectingState.m811$$Nest$fgetmLastDown(this.this$1), DetectingState.m812$$Nest$fgetmLastUp(this.this$1)) >= this.this$1.mSwipeMinDistance) goto L18;
                return;
            L18:
                if (this.mCompletedTapCount != 0) goto L26;
                this.this$1.transitionToDelegatingStateAndClear();
                return;
            }

            private boolean isMultiFingerMultiTapTriggered(int targetTapCount, MotionEvent event) {
                if (event.getActionMasked() != 1) goto L8;
                if (this.mIsTwoFingerCountReached == false) goto L8;
                this.mCompletedTapCount++;
                this.mIsTwoFingerCountReached = false;
            L8:
                if (this.this$1.this$0.mDetectTwoFingerTripleTap == false) goto L13;
                if (this.mCompletedTapCount <= 1) goto L13;
                boolean enabled = !this.this$1.isActivated();
                FullScreenMagnificationGestureHandler.m792$$Nest$fgetmMagnificationLogger(this.this$1.this$0).logMagnificationTwoFingerTripleTap(enabled);
            L13:
                if (this.this$1.this$0.mDetectTwoFingerTripleTap == true) goto L15;
                return false;
            L15:
                if (this.mCompletedTapCount == targetTapCount) goto L17;
                return false;
            L17:
                return true;
            }

            private boolean shouldLogTwoFingerDoubleTap() {
                if (this.mCompletedTapCount == 1) goto L7;
                return false;
            L7:
                return true;
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDelayedEventQueue, reason: not valid java name */
        static /* bridge */ /* synthetic */ MotionEventInfo m809$$Nest$fgetmDelayedEventQueue(DetectingState r0) {
            return r0.mDelayedEventQueue;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmFirstPointerDownLocation, reason: not valid java name */
        static /* bridge */ /* synthetic */ PointF m810$$Nest$fgetmFirstPointerDownLocation(DetectingState r0) {
            return r0.mFirstPointerDownLocation;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLastDown, reason: not valid java name */
        static /* bridge */ /* synthetic */ MotionEvent m811$$Nest$fgetmLastDown(DetectingState r0) {
            return r0.mLastDown;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLastUp, reason: not valid java name */
        static /* bridge */ /* synthetic */ MotionEvent m812$$Nest$fgetmLastUp(DetectingState r0) {
            return r0.mLastUp;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSecondPointerDownLocation, reason: not valid java name */
        static /* bridge */ /* synthetic */ PointF m813$$Nest$fgetmSecondPointerDownLocation(DetectingState r0) {
            return r0.mSecondPointerDownLocation;
        }

        /* JADX INFO: renamed from: -$$Nest$misShortcutTriggered, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m814$$Nest$misShortcutTriggered(DetectingState r0) {
            return r0.isShortcutTriggered();
        }

        static {
            HISTOGRAM_FIRST_INTERVAL = new Histogram("accessibility.value_full_triple_tap_first_interval", new Histogram.UniformOptions(25, 0.0f, 250.0f));
            HISTOGRAM_SECOND_INTERVAL = new Histogram("accessibility.value_full_triple_tap_second_interval", new Histogram.UniformOptions(25, 0.0f, 250.0f));
        }

        DetectingState(FullScreenMagnificationGestureHandler this$0, Context context) {
            this.this$0 = this$0;
            this.mFirstPointerDownLocation = new PointF(Float.NaN, Float.NaN);
            this.mSecondPointerDownLocation = new PointF(Float.NaN, Float.NaN);
            this.mHandler = new Handler(Looper.getMainLooper(), this);
            this.mLongTapMinDelay = ViewConfiguration.getLongPressTimeout();
            this.mMultiTapMaxDelay = MagnificationGestureMatcher.getMagnificationMultiTapTimeout(context);
            this.mSwipeMinDistance = ViewConfiguration.get(context).getScaledTouchSlop();
            this.mMultiTapMaxDistance = ViewConfiguration.get(context).getScaledDoubleTapSlop();
            this.mTwoFingerDoubleTapHandler = null;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int type = message.what;
            switch(type) {
                case 1: goto L8;
                case 2: goto L7;
                case 3: goto L6;
                default: goto L5;
            };
        L6:
            transitToPanningScalingStateAndClear();
            return true;
        L7:
            transitionToDelegatingStateAndClear();
            return true;
        L8:
            MotionEvent down = (MotionEvent) message.obj;
            transitionToViewportDraggingStateAndClear(down);
            down.recycle();
            return true;
        L5:
            throw new IllegalArgumentException("Unknown message type: " + type);
        }

        @Override // com.android.server.accessibility.magnification.FullScreenMagnificationGestureHandler.State
        public void onMotionEvent(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
            cacheDelayedMotionEvent(event, rawEvent, policyFlags);
            switch(event.getActionMasked()) {
                case 0: goto L79;
                case 1: goto L63;
                case 2: goto L19;
                case 3: goto L127;
                case 4: goto L127;
                case 5: goto L10;
                case 6: goto L6;
                default: goto L127;
            };
        L63:
            this.mHandler.removeMessages(1);
            if (this.mTwoFingerDoubleTapHandler == null) goto L67;
            this.mHandler.removeMessages(3);
            TwoFingerDoubleTapHandler.m819$$Nest$monUp(this.mTwoFingerDoubleTapHandler, event);
            return;
        L67:
            if (this.this$0.mFullScreenMagnificationController.magnificationRegionContains(this.this$0.mDisplayId, event.getX(), event.getY()) == true) goto L70;
            transitionToDelegatingStateAndClear();
            return;
        L70:
            if (isMultiTapTriggered(3) == false) goto L73;
            onTripleTap(event);
            return;
        L73:
            if (isFingerDown() == true) goto L75;
            return;
        L75:
            if (timeBetween(this.mLastDown, this.mLastUp) < this.mLongTapMinDelay) goto L77;
        L78:
            transitionToDelegatingStateAndClear();
            return;
        L77:
            if (GestureUtils.distance(this.mLastDown, this.mLastUp) >= this.mSwipeMinDistance) goto L78;
            return;
        L79:
            this.mLastDetectingDownEventTime = event.getDownTime();
            this.mHandler.removeMessages(2);
            this.mFirstPointerDownLocation.set(event.getX(), event.getY());
            if (this.this$0.mFullScreenMagnificationController.magnificationRegionContains(this.this$0.mDisplayId, event.getX(), event.getY()) == true) goto L83;
            transitionToDelegatingStateAndClear();
            return;
        L83:
            if (isMultiTapTriggered(2) == false) goto L86;
            afterLongTapTimeoutTransitionToDraggingState(event);
            return;
        L86:
            if (isTapOutOfDistanceSlop() == false) goto L89;
            transitionToDelegatingStateAndClear();
            return;
        L89:
            if (this.this$0.mDetectSingleFingerTripleTap == false) goto L91;
        L98:
            afterMultiTapTimeoutTransitionToDelegatingState();
            return;
        L91:
            if (this.mTwoFingerDoubleTapHandler == null) goto L95;
            if (this.this$0.mDetectTwoFingerTripleTap == true) goto L98;
        L95:
            if (isActivated() == true) goto L98;
            transitionToDelegatingStateAndClear();
            return;
        L127:
            return;
        L6:
            if (this.mTwoFingerDoubleTapHandler == null) goto L8;
            TwoFingerDoubleTapHandler.m818$$Nest$monPointerUp(this.mTwoFingerDoubleTapHandler);
            return;
        L8:
            transitionToDelegatingStateAndClear();
            return;
        L10:
            if (this.mTwoFingerDoubleTapHandler == null) goto L13;
            TwoFingerDoubleTapHandler.m817$$Nest$monPointerDown(this.mTwoFingerDoubleTapHandler, event);
            return;
        L13:
            if (isActivated() == true) goto L15;
        L17:
            transitionToDelegatingStateAndClear();
            return;
        L15:
            if (event.getPointerCount() != 2) goto L17;
            storePointerDownLocation(this.mSecondPointerDownLocation, event);
            this.mHandler.sendEmptyMessageDelayed(3, ViewConfiguration.getTapTimeout());
            return;
        L19:
            if (this.mTwoFingerDoubleTapHandler == null) goto L22;
            TwoFingerDoubleTapHandler.m816$$Nest$monMove(this.mTwoFingerDoubleTapHandler, event);
            return;
        L22:
            if (isFingerDown() == false) goto L57;
            if (GestureUtils.distance(this.mLastDown, event) <= this.mSwipeMinDistance) goto L57;
            if (isMultiTapTriggered(2) == false) goto L31;
            if (event.getPointerCount() != 1) goto L31;
            transitionToViewportDraggingStateAndClear(event);
            return;
        L31:
            if (isActivated() == false) goto L41;
            if (event.getPointerCount() != 2) goto L41;
            if (this.this$0.mOverscrollHandler != null) goto L37;
        L39:
            transitToPanningScalingStateAndClear();
            return;
        L37:
            if (FullScreenMagnificationGestureHandler.m799$$Nest$moverscrollState(this.this$0, event, this.mFirstPointerDownLocation) != 3) goto L39;
            transitionToDelegatingStateAndClear();
            return;
        L41:
            if (this.this$0.mOneFingerPanningSettingsProvider.isOneFingerPanningEnabled() == true) goto L43;
        L55:
            transitionToDelegatingStateAndClear();
            return;
        L43:
            if (isActivated() == false) goto L55;
            if (event.getPointerCount() != 1) goto L55;
            if (this.this$0.mOverscrollHandler == null) goto L52;
            if (FullScreenMagnificationGestureHandler.m799$$Nest$moverscrollState(this.this$0, event, this.mFirstPointerDownLocation) != 3) goto L52;
            transitionToDelegatingStateAndClear();
            return;
        L52:
            if (FullScreenMagnificationGestureHandler.m799$$Nest$moverscrollState(this.this$0, event, this.mFirstPointerDownLocation) == 0) goto L54;
            transitionToDelegatingStateAndClear();
            return;
        L54:
            transitToSinglePanningStateAndClear();
            return;
        L57:
            if (isActivated() == true) goto L59;
            return;
        L59:
            if (pointerDownValid(this.mSecondPointerDownLocation) == true) goto L61;
            return;
        L61:
            if (GestureUtils.distanceClosestPointerToPoint(this.mSecondPointerDownLocation, event) <= this.mSwipeMinDistance) goto L115;
            transitToPanningScalingStateAndClear();
            return;
        }

        protected void storePointerDownLocation(PointF pointerDownLocation, MotionEvent event) {
            int index = event.getActionIndex();
            pointerDownLocation.set(event.getX(index), event.getY(index));
        }

        protected boolean pointerDownValid(PointF pointerDownLocation) {
            if (Float.isNaN(pointerDownLocation.x) == true) goto L5;
        L8:
            return true;
        L5:
            if (Float.isNaN(pointerDownLocation.y) == false) goto L8;
            return false;
        }

        protected void transitToPanningScalingStateAndClear() {
            this.this$0.transitionTo(this.this$0.mPanningScalingState);
            clear();
        }

        protected void transitToSinglePanningStateAndClear() {
            this.this$0.transitionTo(this.this$0.mSinglePanningState);
            clear();
        }

        public boolean isMultiTapTriggered(int numTaps) {
            if (this.mShortcutTriggered == false) goto L9;
            if ((tapCount() + 2) >= numTaps) goto L7;
            return false;
        L7:
            return true;
        L9:
            if (this.this$0.mDetectSingleFingerTripleTap == true) goto L11;
        L17:
            boolean multitapTriggered = false;
        L19:
            if (multitapTriggered == false) goto L24;
            if (numTaps <= 2) goto L24;
            boolean enabled = !isActivated();
            FullScreenMagnificationGestureHandler.m792$$Nest$fgetmMagnificationLogger(this.this$0).logMagnificationTripleTap(enabled);
            List<Long> intervals = intervalsOf(this.mDelayedEventQueue, 1);
            if (intervals.size() < 2) goto L24;
            HISTOGRAM_FIRST_INTERVAL.logSample(intervals.get(0).longValue());
            HISTOGRAM_SECOND_INTERVAL.logSample(intervals.get(1).longValue());
        L24:
            return multitapTriggered;
        L11:
            if (tapCount() < numTaps) goto L17;
            if (isMultiTap(this.mPreLastDown, this.mLastDown) == false) goto L17;
            if (isMultiTap(this.mPreLastUp, this.mLastUp) == false) goto L17;
            multitapTriggered = true;
            goto L19
        }

        private boolean isMultiTap(MotionEvent first, MotionEvent second) {
            return GestureUtils.isMultiTap(first, second, this.mMultiTapMaxDelay, this.mMultiTapMaxDistance);
        }

        public boolean isFingerDown() {
            if (this.mLastDown == null) goto L5;
            return true;
        L5:
            return false;
        }

        protected long timeBetween(MotionEvent a, MotionEvent b) {
            if (a != null) goto L7;
            if (b != null) goto L7;
            return 0;
        L7:
            return Math.abs(timeOf(a) - timeOf(b));
        }

        private long timeOf(MotionEvent event) {
            if (event != null) goto L6;
            return Long.MIN_VALUE;
        L6:
            return event.getEventTime();
        }

        public List<Long> intervalsOf(MotionEventInfo info, int eventType) {
            return MotionEventInfo.intervalsOf(info, eventType);
        }

        public int tapCount() {
            return MotionEventInfo.countOf(this.mDelayedEventQueue, 1);
        }

        public void afterMultiTapTimeoutTransitionToDelegatingState() {
            this.mHandler.sendEmptyMessageDelayed(2, this.mMultiTapMaxDelay);
        }

        public void afterLongTapTimeoutTransitionToDraggingState(MotionEvent event) {
            this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1, MotionEvent.obtain(event)), ViewConfiguration.getLongPressTimeout());
        }

        @Override // com.android.server.accessibility.magnification.FullScreenMagnificationGestureHandler.State
        public void clear() {
            if (this.mTwoFingerDoubleTapHandler == null) goto L5;
            TwoFingerDoubleTapHandler.m815$$Nest$fputmCompletedTapCount(this.mTwoFingerDoubleTapHandler, 0);
        L5:
            setShortcutTriggered(false);
            removePendingDelayedMessages();
            clearDelayedMotionEvents();
            this.mFirstPointerDownLocation.set(Float.NaN, Float.NaN);
            this.mSecondPointerDownLocation.set(Float.NaN, Float.NaN);
        }

        protected void removePendingDelayedMessages() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
        }

        protected void cacheDelayedMotionEvent(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
            if (event.isFromSource(UsbACInterface.FORMAT_II_AC3) == true) goto L6;
            return;
        L6:
            if (event.getActionMasked() != 0) goto L9;
            this.mPreLastDown = this.mLastDown;
            this.mLastDown = MotionEvent.obtain(event);
        L11:
            MotionEventInfo info = MotionEventInfo.obtain(event, rawEvent, policyFlags);
            if (this.mDelayedEventQueue != null) goto L14;
            this.mDelayedEventQueue = info;
            return;
        L14:
            MotionEventInfo tail = this.mDelayedEventQueue;
        L16:
            if (MotionEventInfo.m821$$Nest$fgetmNext(tail) == null) goto L18;
            tail = MotionEventInfo.m821$$Nest$fgetmNext(tail);
            goto L16
        L18:
            MotionEventInfo.m822$$Nest$fputmNext(tail, info);
            return;
        L9:
            if (event.getActionMasked() != 1) goto L11;
            this.mPreLastUp = this.mLastUp;
            this.mLastUp = MotionEvent.obtain(event);
            goto L11
        }

        protected void sendDelayedMotionEvents() {
            if (this.mDelayedEventQueue != null) goto L5;
            return;
        L5:
            long offset = Math.min(SystemClock.uptimeMillis() - this.mLastDetectingDownEventTime, this.mMultiTapMaxDelay);
        L6:
            MotionEventInfo info = this.mDelayedEventQueue;
            this.mDelayedEventQueue = MotionEventInfo.m821$$Nest$fgetmNext(info);
            info.event.setDownTime(info.event.getDownTime() + offset);
            FullScreenMagnificationGestureHandler.m794$$Nest$mhandleTouchEventWith(this.this$0, this.this$0.mDelegatingState, info.event, info.rawEvent, info.policyFlags);
            info.recycle();
            if (this.mDelayedEventQueue != null) goto L6;
        }

        protected void clearDelayedMotionEvents() {
        L3:
            if (this.mDelayedEventQueue == null) goto L5;
            MotionEventInfo info = this.mDelayedEventQueue;
            this.mDelayedEventQueue = MotionEventInfo.m821$$Nest$fgetmNext(info);
            info.recycle();
            goto L3
        L5:
            this.mPreLastDown = null;
            this.mPreLastUp = null;
            this.mLastDown = null;
            this.mLastUp = null;
        }

        void transitionToDelegatingStateAndClear() {
            if (this.mTwoFingerDoubleTapHandler == null) goto L5;
            TwoFingerDoubleTapHandler.m815$$Nest$fputmCompletedTapCount(this.mTwoFingerDoubleTapHandler, 0);
        L5:
            this.this$0.transitionTo(this.this$0.mDelegatingState);
            sendDelayedMotionEvents();
            removePendingDelayedMessages();
            this.mFirstPointerDownLocation.set(Float.NaN, Float.NaN);
            this.mSecondPointerDownLocation.set(Float.NaN, Float.NaN);
        }

        protected void onTripleTap(MotionEvent up) {
            if (FullScreenMagnificationGestureHandler.m805$$Nest$sfgetDEBUG_DETECTING() == false) goto L6;
            Slog.i(this.this$0.mLogTag, "onTripleTap(); delayed: " + MotionEventInfo.toString(this.mDelayedEventQueue));
        L6:
            if (isActivated() == true) goto L8;
        L11:
            FullScreenMagnificationGestureHandler.m793$$Nest$fgetmPromptController(this.this$0).showNotificationIfNeeded();
            FullScreenMagnificationGestureHandler.m803$$Nest$mzoomOn(this.this$0, up.getX(), up.getY());
        L12:
            clear();
            return;
        L8:
            if (this.mShortcutTriggered == true) goto L11;
            FullScreenMagnificationGestureHandler.m802$$Nest$mzoomOff(this.this$0);
            goto L12
        }

        protected boolean isActivated() {
            return this.this$0.mFullScreenMagnificationController.isActivated(this.this$0.mDisplayId);
        }

        void transitionToViewportDraggingStateAndClear(MotionEvent down) {
            if (FullScreenMagnificationGestureHandler.m805$$Nest$sfgetDEBUG_DETECTING() == false) goto L5;
            Slog.i(this.this$0.mLogTag, "onTripleTapAndHold()");
        L5:
            boolean shortcutTriggered = this.mShortcutTriggered;
            if (shortcutTriggered == true) goto L13;
            boolean enabled = !isActivated();
            if (this.mTwoFingerDoubleTapHandler != null) goto L10;
        L12:
            FullScreenMagnificationGestureHandler.m792$$Nest$fgetmMagnificationLogger(this.this$0).logMagnificationTripleTap(enabled);
            goto L13
        L10:
            if (TwoFingerDoubleTapHandler.m820$$Nest$mshouldLogTwoFingerDoubleTap(this.mTwoFingerDoubleTapHandler) == false) goto L12;
            FullScreenMagnificationGestureHandler.m792$$Nest$fgetmMagnificationLogger(this.this$0).logMagnificationTwoFingerTripleTap(enabled);
        L13:
            clear();
            this.this$0.mViewportDraggingState.prepareForZoomInTemporary(shortcutTriggered);
            FullScreenMagnificationGestureHandler.m801$$Nest$mzoomInTemporary(this.this$0, down.getX(), down.getY(), shortcutTriggered);
            this.this$0.transitionTo(this.this$0.mViewportDraggingState);
        }

        public String toString() {
            return "DetectingState{tapCount()=" + tapCount() + ", mShortcutTriggered=" + this.mShortcutTriggered + ", mDelayedEventQueue=" + MotionEventInfo.toString(this.mDelayedEventQueue) + '}';
        }

        void toggleShortcutTriggered() {
            setShortcutTriggered(!this.mShortcutTriggered);
        }

        void setShortcutTriggered(boolean state) {
            if (this.mShortcutTriggered != state) goto L6;
            return;
        L6:
            if (FullScreenMagnificationGestureHandler.m805$$Nest$sfgetDEBUG_DETECTING() == false) goto L8;
            Slog.i(this.this$0.mLogTag, "setShortcutTriggered(" + state + ")");
        L8:
            this.mShortcutTriggered = state;
        }

        private boolean isShortcutTriggered() {
            return this.mShortcutTriggered;
        }

        boolean isTapOutOfDistanceSlop() {
            if (this.this$0.mDetectSingleFingerTripleTap == true) goto L6;
            return false;
        L6:
            if (this.mPreLastDown != null) goto L8;
        L23:
            return false;
        L8:
            if (this.mLastDown == null) goto L23;
            if (GestureUtils.distance(this.mPreLastDown, this.mLastDown) <= this.mMultiTapMaxDistance) goto L13;
            boolean outOfDistanceSlop = true;
        L15:
            if (tapCount() <= 0) goto L18;
            return outOfDistanceSlop;
        L18:
            if (outOfDistanceSlop == true) goto L20;
        L22:
            return false;
        L20:
            if (GestureUtils.isTimedOut(this.mPreLastDown, this.mLastDown, this.mMultiTapMaxDelay) == true) goto L22;
            return true;
        L13:
            outOfDistanceSlop = false;
            goto L15
        }
    }

    private static class GestureException extends Exception {
        GestureException(String message) {
            super(message);
        }
    }

    interface MagnificationLogger {
        void logMagnificationTripleTap(boolean r1);

        void logMagnificationTwoFingerTripleTap(boolean r1);
    }

    public static final class MotionEventInfo {
        private static final int MAX_POOL_SIZE = 10;
        private static final Object sLock = null;
        private static MotionEventInfo sPool;
        private static int sPoolSize;
        public MotionEvent event;
        private boolean mInPool;
        private MotionEventInfo mNext;
        public int policyFlags;
        public MotionEvent rawEvent;

        /* JADX INFO: renamed from: -$$Nest$fgetmNext, reason: not valid java name */
        static /* bridge */ /* synthetic */ MotionEventInfo m821$$Nest$fgetmNext(MotionEventInfo r0) {
            return r0.mNext;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmNext, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m822$$Nest$fputmNext(MotionEventInfo r0, MotionEventInfo r1) {
            r0.mNext = r1;
        }

        public MotionEventInfo() {
        }

        static {
            sLock = new Object();
        }

        public static MotionEventInfo obtain(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
            Object r0 = sLock;
            monitor-enter(r0);
            MotionEventInfo info = obtainInternal();     // Catch: Throwable -> L7
            info.initialize(event, rawEvent, policyFlags);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return info;
        L7:
            th = move-exception;
            throw th;
        }

        private static MotionEventInfo obtainInternal() {
            if (sPoolSize <= 0) goto L6;
            sPoolSize--;
            MotionEventInfo info = sPool;
            sPool = info.mNext;
            info.mNext = null;
            info.mInPool = false;
            return info;
        L6:
            return new MotionEventInfo();
        }

        private void initialize(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
            this.event = MotionEvent.obtain(event);
            this.rawEvent = MotionEvent.obtain(rawEvent);
            this.policyFlags = policyFlags;
        }

        public void recycle() {
            Object r0 = sLock;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mInPool == true) goto L14;
            clear();     // Catch: Throwable -> L9
            if (sPoolSize >= 10) goto L11;
            sPoolSize++;     // Catch: Throwable -> L9
            this.mNext = sPool;     // Catch: Throwable -> L9
            sPool = this;     // Catch: Throwable -> L9
            this.mInPool = true;     // Catch: Throwable -> L9
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L14:
            throw new IllegalStateException("Already recycled.");     // Catch: Throwable -> L9
        }

        public MotionEventInfo getNext() {
            return this.mNext;
        }

        public void setNext(MotionEventInfo info) {
            this.mNext = info;
        }

        private void clear() {
            this.event = FullScreenMagnificationGestureHandler.m808$$Nest$smrecycleAndNullify(this.event);
            this.rawEvent = FullScreenMagnificationGestureHandler.m808$$Nest$smrecycleAndNullify(this.rawEvent);
            this.policyFlags = 0;
        }

        static int countOf(MotionEventInfo info, int eventType) {
            int r0 = 0;
            if (info != null) goto L6;
            return 0;
        L6:
            if (info.event.getAction() != eventType) goto L9;
            r0 = 1;
        L9:
            return r0 + countOf(info.mNext, eventType);
        }

        static List<Long> intervalsOf(MotionEventInfo info, int eventType) {
            List<Long> intervals = new ArrayList();
            MotionEventInfo current = info;
            MotionEventInfo previous = null;
        L3:
            if (current == null) goto L10;
            if (current.event.getAction() != eventType) goto L9;
            if (previous == null) goto L8;
            intervals.add(Long.valueOf(current.event.getDownTime() - previous.event.getDownTime()));
        L8:
            previous = current;
        L9:
            current = current.mNext;
            goto L3
        L10:
            return intervals;
        }

        public static String toString(MotionEventInfo info) {
            if (info != null) goto L6;
            return "";
        L6:
            return MotionEvent.actionToString(info.event.getAction()).replace("ACTION_", "") + " " + toString(info.mNext);
        }
    }

    final class OverscrollHandler {
        private boolean mEdgeCooldown;
        int mOverscrollState;
        private final PointF mPivotEdge;
        private final PointF mReachedEdgeCoord;
        final /* synthetic */ FullScreenMagnificationGestureHandler this$0;

        /* JADX INFO: renamed from: -$$Nest$mclearEdgeState, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m823$$Nest$mclearEdgeState(OverscrollHandler r0) {
            r0.clearEdgeState();
        }

        /* JADX INFO: renamed from: -$$Nest$monScrollStateChanged, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m824$$Nest$monScrollStateChanged(OverscrollHandler r0, MotionEvent r1, MotionEvent r2) {
            r0.onScrollStateChanged(r1, r2);
        }

        /* JADX INFO: renamed from: -$$Nest$msetScaleAndCenterToEdgeIfNeeded, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m825$$Nest$msetScaleAndCenterToEdgeIfNeeded(OverscrollHandler r0) {
            r0.setScaleAndCenterToEdgeIfNeeded();
        }

        OverscrollHandler(FullScreenMagnificationGestureHandler this$0) {
            this.this$0 = this$0;
            this.mOverscrollState = 0;
            this.mPivotEdge = new PointF(Float.NaN, Float.NaN);
            this.mReachedEdgeCoord = new PointF(Float.NaN, Float.NaN);
            this.mEdgeCooldown = false;
        }

        protected boolean warpEffectReset(MotionEvent second) {
            float scale = calculateOverscrollScale(second);
            if (scale >= 0.0f) goto L5;
            return false;
        L5:
            this.this$0.mFullScreenMagnificationController.setScaleAndCenter(this.this$0.mDisplayId, scale, this.mPivotEdge.x, this.mPivotEdge.y, true, true, 0);
            if (scale != 1.0f) goto L9;
            return true;
        L9:
            return false;
        }

        private float calculateOverscrollScale(MotionEvent second) {
            float overshootDistX = second.getX() - this.mReachedEdgeCoord.x;
            if (this.mOverscrollState != 1) goto L7;
            if (overshootDistX >= 0.0f) goto L7;
        L10:
            clearEdgeState();
            return -1.0f;
        L7:
            if (this.mOverscrollState == 2) goto L9;
        L12:
            float overshootDistY = second.getY() - this.mReachedEdgeCoord.y;
            float overshootDist = (float) Math.hypot(Math.abs(overshootDistX), Math.abs(overshootDistY));
            Rect bounds = new Rect();
            this.this$0.mFullScreenMagnificationController.getMagnificationBounds(this.this$0.mDisplayId, bounds);
            float overShootFraction = overshootDist / bounds.width();
            float minDist = bounds.width() * 0.05f;
            if (this.mEdgeCooldown == true) goto L15;
        L17:
            float scale = (1.0f - overShootFraction) * getSensitivityScale();
            return MathUtils.constrain(scale, 1.0f, this.this$0.mFullScreenMagnificationController.getPersistedScale(this.this$0.mDisplayId));
        L15:
            if (overshootDist <= minDist) goto L17;
            this.mEdgeCooldown = false;
            goto L17
        L9:
            if (overshootDistX <= 0.0f) goto L12;
            goto L10
        }

        private float getSensitivityScale() {
            float magnificationScale = this.this$0.mFullScreenMagnificationController.getPersistedScale(this.this$0.mDisplayId);
            if (magnificationScale >= 1.7f) goto L6;
            float sensitivityFactor = 1.0f;
        L22:
            return magnificationScale * sensitivityFactor;
        L6:
            if (magnificationScale >= 2.0f) goto L9;
            sensitivityFactor = 1.0f;
            goto L22
        L9:
            if (magnificationScale >= 2.2f) goto L12;
            sensitivityFactor = 0.95f;
            goto L22
        L12:
            if (magnificationScale >= 2.5f) goto L15;
            sensitivityFactor = 1.1f;
            goto L22
        L15:
            if (magnificationScale >= 2.7f) goto L18;
            sensitivityFactor = 1.3f;
            goto L22
        L18:
            if (magnificationScale >= 3.0f) goto L20;
            sensitivityFactor = 1.0f;
            goto L22
        L20:
            sensitivityFactor = 1.0f;
            goto L22
        }

        private void vibrateIfNeeded(MotionEvent event) {
            if (this.mOverscrollState == 0) goto L6;
            return;
        L6:
            if (FullScreenMagnificationGestureHandler.m795$$Nest$misAtLeftEdge(this.this$0) == true) goto L10;
            if (FullScreenMagnificationGestureHandler.m796$$Nest$misAtRightEdge(this.this$0) == true) goto L10;
            return;
        L10:
            if (this.mEdgeCooldown == true) goto L14;
            FullScreenMagnificationGestureHandler.m790$$Nest$fgetmFullScreenMagnificationVibrationHelper(this.this$0).vibrateIfSettingEnabled();
            return;
        }

        private void setPivotEdge(MotionEvent event) {
            if (FullScreenMagnificationGestureHandler.m800$$Nest$mpointerValid(this.this$0, this.mPivotEdge) == true) goto L12;
            Rect bounds = new Rect();
            this.this$0.mFullScreenMagnificationController.getMagnificationBounds(this.this$0.mDisplayId, bounds);
            if (this.mOverscrollState != 1) goto L8;
            this.mPivotEdge.set(bounds.left, this.this$0.mFullScreenMagnificationController.getCenterY(this.this$0.mDisplayId));
        L10:
            this.mReachedEdgeCoord.set(event.getX(), event.getY());
            this.mEdgeCooldown = true;
            return;
        L8:
            if (this.mOverscrollState != 2) goto L10;
            this.mPivotEdge.set(bounds.right, this.this$0.mFullScreenMagnificationController.getCenterY(this.this$0.mDisplayId));
            goto L10
        }

        private void onScrollStateChanged(MotionEvent first, MotionEvent second) {
            if (this.this$0.mFullScreenMagnificationController.isAtEdge(this.this$0.mDisplayId) == false) goto L6;
            vibrateIfNeeded(second);
            setPivotEdge(second);
        L6:
            switch(this.mOverscrollState) {
                case 0: goto L10;
                case 1: goto L9;
                case 2: goto L9;
                case 3: goto L8;
                default: goto L7;
            };
        L7:
            Slog.d(this.this$0.mLogTag, "Invalid overscroll state");
            return;
        L8:
            onVerticalOverscroll();
            return;
        L9:
            onHorizontalOverscroll(second);
            return;
        L10:
            onNoOverscroll(first, second);
        }

        public void onNoOverscroll(MotionEvent first, MotionEvent second) {
            this.mOverscrollState = FullScreenMagnificationGestureHandler.m799$$Nest$moverscrollState(this.this$0, second, new PointF(first.getX(), first.getY()));
        }

        public void onVerticalOverscroll() {
            clearEdgeState();
            this.this$0.transitionTo(this.this$0.mDelegatingState);
        }

        public void onHorizontalOverscroll(MotionEvent second) {
            boolean reset = warpEffectReset(second);
            if (reset == false) goto L6;
            this.this$0.mFullScreenMagnificationController.reset(this.this$0.mDisplayId, true);
            clearEdgeState();
            this.this$0.transitionTo(this.this$0.mDelegatingState);
            return;
        }

        private void setScaleAndCenterToEdgeIfNeeded() {
            if (this.mOverscrollState != 1) goto L5;
        L6:
            this.this$0.mFullScreenMagnificationController.setScaleAndCenter(this.this$0.mDisplayId, this.this$0.mFullScreenMagnificationController.getPersistedScale(this.this$0.mDisplayId), this.mPivotEdge.x, this.mPivotEdge.y, true, 0);
            return;
        L5:
            if (this.mOverscrollState == 2) goto L6;
        }

        private void clearEdgeState() {
            this.mOverscrollState = 0;
            this.mPivotEdge.set(Float.NaN, Float.NaN);
            this.mReachedEdgeCoord.set(Float.NaN, Float.NaN);
            this.mEdgeCooldown = false;
        }

        public String toString() {
            return "OverscrollHandler {mOverscrollState=" + this.mOverscrollState + "mPivotEdge.x=" + this.mPivotEdge.x + "mPivotEdge.y=" + this.mPivotEdge.y + "mReachedEdgeCoord.x=" + this.mReachedEdgeCoord.x + "mReachedEdgeCoord.y=" + this.mReachedEdgeCoord.y + "mEdgeCooldown=" + this.mEdgeCooldown + "}";
        }
    }

    public @interface OverscrollState {
    }

    final class PanningScalingState extends GestureDetector.SimpleOnGestureListener implements ScaleGestureDetector.OnScaleGestureListener, State {
        static final float CHECK_DETECTING_PASS_PERSISTED_SCALE_THRESHOLD = 0.2f;
        static final float PASSING_PERSISTED_SCALE_THRESHOLD = 0.01f;
        private final Context mContext;
        boolean mDetectingPassPersistedScale;
        float mInitialScaleFactor;
        private final ScaleGestureDetector mScaleGestureDetector;
        boolean mScaling;
        final float mScalingThreshold;
        private final GestureDetector mScrollGestureDetector;
        final /* synthetic */ FullScreenMagnificationGestureHandler this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmScaleGestureDetector, reason: not valid java name */
        static /* bridge */ /* synthetic */ ScaleGestureDetector m826$$Nest$fgetmScaleGestureDetector(PanningScalingState r0) {
            return r0.mScaleGestureDetector;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmScrollGestureDetector, reason: not valid java name */
        static /* bridge */ /* synthetic */ GestureDetector m827$$Nest$fgetmScrollGestureDetector(PanningScalingState r0) {
            return r0.mScrollGestureDetector;
        }

        PanningScalingState(FullScreenMagnificationGestureHandler this$0, Context context) {
            this.this$0 = this$0;
            this.mInitialScaleFactor = -1.0f;
            TypedValue scaleValue = new TypedValue();
            context.getResources().getValue(R.dimen.expanded_group_conversation_message_padding, scaleValue, false);
            this.mContext = context;
            this.mScalingThreshold = scaleValue.getFloat();
            this.mScaleGestureDetector = new ScaleGestureDetector(context, this, Handler.getMain());
            this.mScaleGestureDetector.setQuickScaleEnabled(false);
            this.mScrollGestureDetector = new GestureDetector(context, this, Handler.getMain());
            this.mScrollGestureDetector.setIsLongpressEnabled(false);
        }

        @Override // com.android.server.accessibility.magnification.FullScreenMagnificationGestureHandler.State
        public void onMotionEvent(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
            int action = event.getActionMasked();
            if (action != 6) goto L13;
            if (event.getPointerCount() != 2) goto L13;
            if (this.this$0.mPreviousState != this.this$0.mViewportDraggingState) goto L13;
            if (this.this$0.mOverscrollHandler == null) goto L11;
            OverscrollHandler.m825$$Nest$msetScaleAndCenterToEdgeIfNeeded(this.this$0.mOverscrollHandler);
            OverscrollHandler.m823$$Nest$mclearEdgeState(this.this$0.mOverscrollHandler);
        L11:
            persistScaleAndTransitionTo(this.this$0.mViewportDraggingState);
            return;
        L13:
            if (action != 1) goto L15;
        L16:
            FullScreenMagnificationGestureHandler.m798$$Nest$monPanningFinished(this.this$0, event);
            if (this.this$0.mOverscrollHandler == null) goto L19;
            OverscrollHandler.m825$$Nest$msetScaleAndCenterToEdgeIfNeeded(this.this$0.mOverscrollHandler);
            OverscrollHandler.m823$$Nest$mclearEdgeState(this.this$0.mOverscrollHandler);
        L19:
            persistScaleAndTransitionTo(this.this$0.mDetectingState);
            return;
        L15:
            if (action == 3) goto L16;
        }

        void prepareForState() {
            checkShouldDetectPassPersistedScale();
        }

        private void checkShouldDetectPassPersistedScale() {
            if (this.mDetectingPassPersistedScale == false) goto L5;
            return;
        L5:
            float currentScale = this.this$0.mFullScreenMagnificationController.getScale(this.this$0.mDisplayId);
            float persistedScale = this.this$0.mFullScreenMagnificationController.getPersistedScale(this.this$0.mDisplayId);
            if ((Math.abs(currentScale - persistedScale) / persistedScale) < 0.2f) goto L8;
            boolean r2 = true;
        L9:
            this.mDetectingPassPersistedScale = r2;
            return;
        L8:
            r2 = false;
            goto L9
        }

        public void persistScaleAndTransitionTo(State state) {
            if (FullScreenMagnificationGestureHandler.m791$$Nest$fgetmIsWatch(this.this$0) == true) goto L5;
            this.this$0.mFullScreenMagnificationController.persistScale(this.this$0.mDisplayId);
        L5:
            clear();
            this.this$0.transitionTo(state);
        }

        void setScaleAndClearIfNeeded(float scale, float pivotX, float pivotY) {
            if (this.mDetectingPassPersistedScale == false) goto L10;
            float persistedScale = this.this$0.mFullScreenMagnificationController.getPersistedScale(this.this$0.mDisplayId);
            if ((Math.abs(scale - persistedScale) / persistedScale) >= 0.01f) goto L10;
            Vibrator vibrator = (Vibrator) this.mContext.getSystemService(Vibrator.class);
            if (vibrator == null) goto L9;
            vibrator.vibrate(VibrationEffect.createPredefined(2));
        L9:
            clear();
            float scale2 = persistedScale;
        L12:
            if (FullScreenMagnificationGestureHandler.m806$$Nest$sfgetDEBUG_PANNING_SCALING() == false) goto L14;
            Slog.i(this.this$0.mLogTag, "Scaled content to: " + scale2 + "x");
        L14:
            this.this$0.mFullScreenMagnificationController.setScale(this.this$0.mDisplayId, scale2, pivotX, pivotY, true, false, 0);
            checkShouldDetectPassPersistedScale();
            return;
        L10:
            scale2 = scale;
            goto L12
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent first, MotionEvent second, float distanceX, float distanceY) {
            if (this.this$0.mCurrentState == this.this$0.mPanningScalingState) goto L6;
            return true;
        L6:
            if (FullScreenMagnificationGestureHandler.m806$$Nest$sfgetDEBUG_PANNING_SCALING() == false) goto L8;
            Slog.i(this.this$0.mLogTag, "Panned content by scrollX: " + distanceX + " scrollY: " + distanceY);
        L8:
            FullScreenMagnificationGestureHandler.m797$$Nest$monPan(this.this$0, second);
            this.this$0.mFullScreenMagnificationController.offsetMagnifiedRegion(this.this$0.mDisplayId, distanceX, distanceY, 0);
            if (this.this$0.mOverscrollHandler == null) goto L11;
            OverscrollHandler.m824$$Nest$monScrollStateChanged(this.this$0.mOverscrollHandler, first, second);
        L11:
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector detector) {
            boolean r1 = true;
            if (this.mScaling == false) goto L5;
            float initialScale = this.this$0.mFullScreenMagnificationController.getScale(this.this$0.mDisplayId);
            float targetScale = detector.getScaleFactor() * initialScale;
            if (targetScale <= FullScreenMagnificationGestureHandler.m807$$Nest$sfgetMAX_SCALE()) goto L20;
            if (targetScale <= initialScale) goto L20;
            float scale = FullScreenMagnificationGestureHandler.m807$$Nest$sfgetMAX_SCALE();
        L25:
            setScaleAndClearIfNeeded(scale, detector.getFocusX(), detector.getFocusY());
            return true;
        L20:
            if (targetScale < 1.0f) goto L22;
        L24:
            scale = targetScale;
            goto L25
        L22:
            if (targetScale >= initialScale) goto L24;
            scale = 1.0f;
            goto L25
        L5:
            if (this.mInitialScaleFactor >= 0.0f) goto L8;
            this.mInitialScaleFactor = detector.getScaleFactor();
            return false;
        L8:
            float deltaScale = detector.getScaleFactor() - this.mInitialScaleFactor;
            if (Math.abs(deltaScale) > this.mScalingThreshold) goto L12;
            r1 = false;
        L12:
            this.mScaling = r1;
            return this.mScaling;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            if (this.this$0.mCurrentState != this.this$0.mPanningScalingState) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector detector) {
            clear();
        }

        @Override // com.android.server.accessibility.magnification.FullScreenMagnificationGestureHandler.State
        public void clear() {
            this.mInitialScaleFactor = -1.0f;
            this.mScaling = false;
            this.mDetectingPassPersistedScale = false;
        }

        public String toString() {
            return "PanningScalingState{mInitialScaleFactor=" + this.mInitialScaleFactor + ", mScaling=" + this.mScaling + '}';
        }
    }

    private static class ScreenStateReceiver extends BroadcastReceiver {
        private static final String TAG = null;
        private final Context mContext;
        private final FullScreenMagnificationGestureHandler mGestureHandler;

        static {
            TAG = ScreenStateReceiver.class.getName();
        }

        ScreenStateReceiver(Context context, FullScreenMagnificationGestureHandler gestureHandler) {
            this.mContext = context;
            this.mGestureHandler = gestureHandler;
        }

        public void register() {
            this.mContext.registerReceiver(this, new IntentFilter("android.intent.action.SCREEN_OFF"));
        }

        public void unregister() {
            this.mContext.unregisterReceiver(this);     // Catch: IllegalArgumentException -> L4
            return;
        L4:
            exception = move-exception;
            Slog.e(TAG, "Failed to unregister receiver: " + exception);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            this.mGestureHandler.mDetectingState.setShortcutTriggered(false);
        }
    }

    final class SinglePanningState extends GestureDetector.SimpleOnGestureListener implements State {
        private MotionEventInfo mEvent;
        private final GestureDetector mScrollGestureDetector;
        final /* synthetic */ FullScreenMagnificationGestureHandler this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmScrollGestureDetector, reason: not valid java name */
        static /* bridge */ /* synthetic */ GestureDetector m828$$Nest$fgetmScrollGestureDetector(SinglePanningState r0) {
            return r0.mScrollGestureDetector;
        }

        SinglePanningState(FullScreenMagnificationGestureHandler this$0, Context context) {
            this.this$0 = this$0;
            this.mScrollGestureDetector = new GestureDetector(context, this, Handler.getMain());
            this.mScrollGestureDetector.setIsLongpressEnabled(false);
        }

        @Override // com.android.server.accessibility.magnification.FullScreenMagnificationGestureHandler.State
        public void onMotionEvent(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
            int action = event.getActionMasked();
            switch(action) {
                case 1: goto L5;
                case 2: goto L11;
                case 3: goto L7;
                default: goto L11;
            };
        L5:
            FullScreenMagnificationGestureHandler.m798$$Nest$monPanningFinished(this.this$0, event);
            goto L7
        L11:
            return;
        L7:
            if (this.this$0.mOverscrollHandler == null) goto L9;
            OverscrollHandler.m825$$Nest$msetScaleAndCenterToEdgeIfNeeded(this.this$0.mOverscrollHandler);
            OverscrollHandler.m823$$Nest$mclearEdgeState(this.this$0.mOverscrollHandler);
        L9:
            this.this$0.transitionTo(this.this$0.mDetectingState);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent first, MotionEvent second, float distanceX, float distanceY) {
            if (this.this$0.mCurrentState == this.this$0.mSinglePanningState) goto L5;
            return true;
        L5:
            FullScreenMagnificationGestureHandler.m797$$Nest$monPan(this.this$0, second);
            this.this$0.mFullScreenMagnificationController.offsetMagnifiedRegion(this.this$0.mDisplayId, distanceX, distanceY, 0);
            if (FullScreenMagnificationGestureHandler.m806$$Nest$sfgetDEBUG_PANNING_SCALING() == false) goto L9;
            Slog.i(this.this$0.mLogTag, "SinglePanningState Panned content by scrollX: " + distanceX + " scrollY: " + distanceY + " isAtEdge: " + this.this$0.mFullScreenMagnificationController.isAtEdge(this.this$0.mDisplayId));
        L9:
            if (this.this$0.mOverscrollHandler == null) goto L11;
            OverscrollHandler.m824$$Nest$monScrollStateChanged(this.this$0.mOverscrollHandler, first, second);
        L11:
            return true;
        }

        public String toString() {
            return "SinglePanningState{isEdgeOfView=" + this.this$0.mFullScreenMagnificationController.isAtEdge(this.this$0.mDisplayId);
        }
    }

    interface State {
        void onMotionEvent(MotionEvent r1, MotionEvent r2, int r3) throws GestureException;

        default void clear() {
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

    class ViewportDraggingState implements State {
        protected boolean mLastMoveOutsideMagnifiedRegion;
        protected float mScaleToRecoverAfterDraggingEnd;
        final /* synthetic */ FullScreenMagnificationGestureHandler this$0;

        ViewportDraggingState(FullScreenMagnificationGestureHandler this$0) {
            this.this$0 = this$0;
            this.mScaleToRecoverAfterDraggingEnd = Float.NaN;
        }

        @Override // com.android.server.accessibility.magnification.FullScreenMagnificationGestureHandler.State
        public void onMotionEvent(MotionEvent event, MotionEvent rawEvent, int policyFlags) throws GestureException {
            int action = event.getActionMasked();
            switch(action) {
                case 0: goto L24;
                case 1: goto L18;
                case 2: goto L9;
                case 3: goto L18;
                case 4: goto L26;
                case 5: goto L7;
                case 6: goto L6;
                default: goto L26;
            };
        L7:
            clearAndTransitToPanningScalingState();
            return;
        L26:
            return;
        L6:
            throw new GestureException("Unexpected event type: " + MotionEvent.actionToString(action));
        L9:
            if (event.getPointerCount() != 1) goto L16;
            float eventX = event.getX();
            float eventY = event.getY();
            if (this.this$0.mFullScreenMagnificationController.magnificationRegionContains(this.this$0.mDisplayId, eventX, eventY) == false) goto L13;
            this.this$0.mFullScreenMagnificationController.setCenter(this.this$0.mDisplayId, eventX, eventY, this.mLastMoveOutsideMagnifiedRegion, 0);
            this.mLastMoveOutsideMagnifiedRegion = false;
            return;
        L13:
            this.mLastMoveOutsideMagnifiedRegion = true;
            return;
        L16:
            throw new GestureException("Should have one pointer down.");
        L18:
            if (this.mScaleToRecoverAfterDraggingEnd < 1.0f) goto L20;
            FullScreenMagnificationGestureHandler.m804$$Nest$mzoomToScale(this.this$0, this.mScaleToRecoverAfterDraggingEnd, event.getX(), event.getY());
        L21:
            clear();
            this.mScaleToRecoverAfterDraggingEnd = Float.NaN;
            this.this$0.transitionTo(this.this$0.mDetectingState);
            return;
        L20:
            FullScreenMagnificationGestureHandler.m802$$Nest$mzoomOff(this.this$0);
            goto L21
        L24:
            throw new GestureException("Unexpected event type: " + MotionEvent.actionToString(action));
        }

        private boolean isAlwaysOnMagnificationEnabled() {
            return this.this$0.mFullScreenMagnificationController.isAlwaysOnMagnificationEnabled();
        }

        public void prepareForZoomInTemporary(boolean shortcutTriggered) {
            if (this.this$0.mFullScreenMagnificationController.isActivated(this.this$0.mDisplayId) == false) goto L7;
            if (shortcutTriggered == false) goto L6;
            boolean shouldRecoverAfterDraggingEnd = isAlwaysOnMagnificationEnabled();
        L8:
            if (shouldRecoverAfterDraggingEnd == false) goto L10;
            float r1 = this.this$0.mFullScreenMagnificationController.getScale(this.this$0.mDisplayId);
        L11:
            this.mScaleToRecoverAfterDraggingEnd = r1;
            return;
        L10:
            r1 = Float.NaN;
            goto L11
        L6:
            shouldRecoverAfterDraggingEnd = true;
            goto L8
        L7:
            shouldRecoverAfterDraggingEnd = false;
            goto L8
        }

        protected void clearAndTransitToPanningScalingState() {
            float scaleToRecovery = this.mScaleToRecoverAfterDraggingEnd;
            clear();
            this.mScaleToRecoverAfterDraggingEnd = scaleToRecovery;
            this.this$0.transitionTo(this.this$0.mPanningScalingState);
        }

        @Override // com.android.server.accessibility.magnification.FullScreenMagnificationGestureHandler.State
        public void clear() {
            this.mLastMoveOutsideMagnifiedRegion = false;
            this.mScaleToRecoverAfterDraggingEnd = Float.NaN;
        }

        public String toString() {
            return "ViewportDraggingState{mScaleToRecoverAfterDraggingEnd=" + this.mScaleToRecoverAfterDraggingEnd + ", mLastMoveOutsideMagnifiedRegion=" + this.mLastMoveOutsideMagnifiedRegion + '}';
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFullScreenMagnificationVibrationHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ FullScreenMagnificationVibrationHelper m790$$Nest$fgetmFullScreenMagnificationVibrationHelper(FullScreenMagnificationGestureHandler r0) {
        return r0.mFullScreenMagnificationVibrationHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsWatch, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m791$$Nest$fgetmIsWatch(FullScreenMagnificationGestureHandler r0) {
        return r0.mIsWatch;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMagnificationLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ MagnificationLogger m792$$Nest$fgetmMagnificationLogger(FullScreenMagnificationGestureHandler r0) {
        return r0.mMagnificationLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPromptController, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowMagnificationPromptController m793$$Nest$fgetmPromptController(FullScreenMagnificationGestureHandler r0) {
        return r0.mPromptController;
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleTouchEventWith, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m794$$Nest$mhandleTouchEventWith(FullScreenMagnificationGestureHandler r0, State r1, MotionEvent r2, MotionEvent r3, int r4) {
        r0.handleTouchEventWith(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$misAtLeftEdge, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m795$$Nest$misAtLeftEdge(FullScreenMagnificationGestureHandler r0) {
        return r0.isAtLeftEdge();
    }

    /* JADX INFO: renamed from: -$$Nest$misAtRightEdge, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m796$$Nest$misAtRightEdge(FullScreenMagnificationGestureHandler r0) {
        return r0.isAtRightEdge();
    }

    /* JADX INFO: renamed from: -$$Nest$monPan, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m797$$Nest$monPan(FullScreenMagnificationGestureHandler r0, MotionEvent r1) {
        r0.onPan(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monPanningFinished, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m798$$Nest$monPanningFinished(FullScreenMagnificationGestureHandler r0, MotionEvent r1) {
        r0.onPanningFinished(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$moverscrollState, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m799$$Nest$moverscrollState(FullScreenMagnificationGestureHandler r0, MotionEvent r1, PointF r2) {
        return r0.overscrollState(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mpointerValid, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m800$$Nest$mpointerValid(FullScreenMagnificationGestureHandler r0, PointF r1) {
        return r0.pointerValid(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mzoomInTemporary, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m801$$Nest$mzoomInTemporary(FullScreenMagnificationGestureHandler r0, float r1, float r2, boolean r3) {
        r0.zoomInTemporary(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mzoomOff, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m802$$Nest$mzoomOff(FullScreenMagnificationGestureHandler r0) {
        r0.zoomOff();
    }

    /* JADX INFO: renamed from: -$$Nest$mzoomOn, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m803$$Nest$mzoomOn(FullScreenMagnificationGestureHandler r0, float r1, float r2) {
        r0.zoomOn(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mzoomToScale, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m804$$Nest$mzoomToScale(FullScreenMagnificationGestureHandler r0, float r1, float r2, float r3) {
        r0.zoomToScale(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG_DETECTING, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m805$$Nest$sfgetDEBUG_DETECTING() {
        return DEBUG_DETECTING;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG_PANNING_SCALING, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m806$$Nest$sfgetDEBUG_PANNING_SCALING() {
        return DEBUG_PANNING_SCALING;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetMAX_SCALE, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m807$$Nest$sfgetMAX_SCALE() {
        return MAX_SCALE;
    }

    /* JADX INFO: renamed from: -$$Nest$smrecycleAndNullify, reason: not valid java name */
    static /* bridge */ /* synthetic */ MotionEvent m808$$Nest$smrecycleAndNullify(MotionEvent r0) {
        return recycleAndNullify(r0);
    }

    static {
        DEBUG_STATE_TRANSITIONS = MagnificationGestureHandler.DEBUG_ALL | false;
        DEBUG_DETECTING = MagnificationGestureHandler.DEBUG_ALL | false;
        DEBUG_PANNING_SCALING = MagnificationGestureHandler.DEBUG_ALL | false;
        MAX_SCALE = MagnificationScaleProvider.MAX_SCALE;
    }

    public FullScreenMagnificationGestureHandler(Context context, FullScreenMagnificationController fullScreenMagnificationController, AccessibilityTraceManager trace, MagnificationGestureHandler.Callback callback, boolean detectSingleFingerTripleTap, boolean detectTwoFingerTripleTap, boolean detectShortcutTrigger, WindowMagnificationPromptController promptController, int displayId, FullScreenMagnificationVibrationHelper fullScreenMagnificationVibrationHelper) {
        this(context, fullScreenMagnificationController, trace, callback, detectSingleFingerTripleTap, detectTwoFingerTripleTap, detectShortcutTrigger, promptController, displayId, fullScreenMagnificationVibrationHelper, null, ViewConfiguration.get(context), new OneFingerPanningSettingsProvider(context, false));
    }

    FullScreenMagnificationGestureHandler(Context context, FullScreenMagnificationController fullScreenMagnificationController, AccessibilityTraceManager trace, MagnificationGestureHandler.Callback callback, boolean detectSingleFingerTripleTap, boolean detectTwoFingerTripleTap, boolean detectShortcutTrigger, WindowMagnificationPromptController promptController, int displayId, FullScreenMagnificationVibrationHelper fullScreenMagnificationVibrationHelper, MagnificationLogger magnificationLogger, ViewConfiguration viewConfiguration, OneFingerPanningSettingsProvider oneFingerPanningSettingsProvider) {
        super(displayId, detectSingleFingerTripleTap, detectTwoFingerTripleTap, detectShortcutTrigger, trace, callback);
        if (MagnificationGestureHandler.DEBUG_ALL == false) goto L6;
        Log.i(this.mLogTag, "FullScreenMagnificationGestureHandler(detectSingleFingerTripleTap = " + detectSingleFingerTripleTap + ", detectTwoFingerTripleTap = " + detectTwoFingerTripleTap + ", detectShortcutTrigger = " + detectShortcutTrigger + ")");
    L6:
        this.mMinimumVelocity = 0;
        this.mMaximumVelocity = 0;
        this.mFullScreenMagnificationController = fullScreenMagnificationController;
        this.mMagnificationInfoChangedCallback = new AnonymousClass1(this);
        this.mFullScreenMagnificationController.addInfoChangedCallback(this.mMagnificationInfoChangedCallback);
        this.mPromptController = promptController;
        if (magnificationLogger == null) goto L9;
        this.mMagnificationLogger = magnificationLogger;
    L10:
        this.mDelegatingState = new DelegatingState(this);
        this.mDetectingState = new DetectingState(this, context);
        this.mViewportDraggingState = new ViewportDraggingState(this);
        this.mPanningScalingState = new PanningScalingState(this, context);
        this.mSinglePanningState = new SinglePanningState(this, context);
        this.mFullScreenMagnificationVibrationHelper = fullScreenMagnificationVibrationHelper;
        this.mOneFingerPanningSettingsProvider = oneFingerPanningSettingsProvider;
        boolean overscrollHandlerSupported = context.getResources().getBoolean(R.bool.config_enable_puk_unlock_screen);
        if (overscrollHandlerSupported == false) goto L13;
        OverscrollHandler r10 = new OverscrollHandler(this);
    L14:
        this.mOverscrollHandler = r10;
        this.mOverscrollEdgeSlop = context.getResources().getDimensionPixelSize(R.dimen.accessibility_fullscreen_magnification_gesture_edge_slop);
        this.mIsWatch = context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
        this.mMouseEventHandler = new MouseEventHandler(this.mFullScreenMagnificationController);
        if (this.mDetectShortcutTrigger == false) goto L17;
        this.mScreenStateReceiver = new ScreenStateReceiver(context, this);
        this.mScreenStateReceiver.register();
    L18:
        transitionTo(this.mDetectingState);
        return;
    L17:
        this.mScreenStateReceiver = null;
        goto L18
    L13:
        r10 = null;
        goto L14
    L9:
        this.mMagnificationLogger = new AnonymousClass2(this);
        goto L10
    }

    @Override // com.android.server.accessibility.magnification.MagnificationGestureHandler
    void onMotionEventInternal(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (event.getSource() == 4098) goto L5;
        return;
    L5:
        if (event.getActionMasked() != 0) goto L7;
        cancelFling();
    L7:
        handleTouchEventWith(this.mCurrentState, event, rawEvent, policyFlags);
    }

    @Override // com.android.server.accessibility.magnification.MagnificationGestureHandler
    void handleMouseOrStylusEvent(MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        if (this.mMouseEventHandler != null) goto L5;
        return;
    L5:
        if (this.mFullScreenMagnificationController.isActivated(this.mDisplayId) == false) goto L10;
        this.mMouseEventHandler.onEvent(event, this.mDisplayId);
        return;
    }

    private void handleTouchEventWith(State stateHandler, MotionEvent event, MotionEvent rawEvent, int policyFlags) {
        PanningScalingState.m827$$Nest$fgetmScrollGestureDetector(this.mPanningScalingState).onTouchEvent(event);
        PanningScalingState.m826$$Nest$fgetmScaleGestureDetector(this.mPanningScalingState).onTouchEvent(event);
        SinglePanningState.m828$$Nest$fgetmScrollGestureDetector(this.mSinglePanningState).onTouchEvent(event);
        stateHandler.onMotionEvent(event, rawEvent, policyFlags);     // Catch: GestureException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(this.mLogTag, "Error processing motion event", e);
        clearAndTransitionToStateDetecting();
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public void clearEvents(int inputSource) {
        if (inputSource != 4098) goto L5;
        clearAndTransitionToStateDetecting();
    L5:
        super.clearEvents(inputSource);
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public void onDestroy() {
        if (DEBUG_STATE_TRANSITIONS == false) goto L5;
        Slog.i(this.mLogTag, "onDestroy(); delayed = " + MotionEventInfo.toString(DetectingState.m809$$Nest$fgetmDelayedEventQueue(this.mDetectingState)));
    L5:
        this.mOneFingerPanningSettingsProvider.unregister();
        if (this.mScreenStateReceiver == null) goto L8;
        this.mScreenStateReceiver.unregister();
    L8:
        this.mPromptController.onDestroy();
        this.mFullScreenMagnificationController.resetIfNeeded(this.mDisplayId, 0);
        this.mFullScreenMagnificationController.removeInfoChangedCallback(this.mMagnificationInfoChangedCallback);
        clearAndTransitionToStateDetecting();
    }

    @Override // com.android.server.accessibility.magnification.MagnificationGestureHandler
    public void handleShortcutTriggered() {
        boolean isActivated = this.mFullScreenMagnificationController.isActivated(this.mDisplayId);
        if (isActivated == false) goto L5;
        zoomOff();
        clearAndTransitionToStateDetecting();
    L7:
        if (DetectingState.m814$$Nest$misShortcutTriggered(this.mDetectingState) == false) goto L10;
        this.mPromptController.showNotificationIfNeeded();
        zoomToScale(1.0f, Float.NaN, Float.NaN);
        return;
    L10:
        return;
    L5:
        this.mDetectingState.toggleShortcutTriggered();
        goto L7
    }

    @Override // com.android.server.accessibility.magnification.MagnificationGestureHandler
    public int getMode() {
        return 1;
    }

    void clearAndTransitionToStateDetecting() {
        this.mCurrentState = this.mDetectingState;
        this.mDetectingState.clear();
        this.mViewportDraggingState.clear();
        this.mPanningScalingState.clear();
    }

    void transitionTo(State state) {
        if (DEBUG_STATE_TRANSITIONS == false) goto L5;
        Slog.i(this.mLogTag, (State.nameOf(this.mCurrentState) + " -> " + State.nameOf(state) + " at " + Arrays.asList((StackTraceElement[]) Arrays.copyOfRange(new RuntimeException().getStackTrace(), 1, 5))).replace(getClass().getName(), ""));
    L5:
        this.mPreviousState = this.mCurrentState;
        if (state != this.mPanningScalingState) goto L8;
        this.mPanningScalingState.prepareForState();
    L8:
        this.mCurrentState = state;
    }

    private void zoomInTemporary(float centerX, float centerY, boolean shortcutTriggered) {
        float currentScale = this.mFullScreenMagnificationController.getScale(this.mDisplayId);
        float persistedScale = MathUtils.constrain(this.mFullScreenMagnificationController.getPersistedScale(this.mDisplayId), 1.0f, MAX_SCALE);
        boolean isActivated = this.mFullScreenMagnificationController.isActivated(this.mDisplayId);
        boolean isZoomedOutFromService = this.mFullScreenMagnificationController.isZoomedOutFromService(this.mDisplayId);
        if (isActivated == false) goto L8;
        if (shortcutTriggered == true) goto L8;
        if (isZoomedOutFromService == true) goto L8;
        boolean zoomInWithPersistedScale = false;
    L9:
        if (zoomInWithPersistedScale == false) goto L11;
        float scale = persistedScale;
    L12:
        zoomToScale(scale, centerX, centerY);
        return;
    L11:
        scale = 1.0f + currentScale;
    L8:
        zoomInWithPersistedScale = true;
        goto L9
    }

    private void zoomOn(float centerX, float centerY) {
        if (DEBUG_DETECTING == false) goto L5;
        Slog.i(this.mLogTag, "zoomOn(" + centerX + ", " + centerY + ")");
    L5:
        float scale = MathUtils.constrain(this.mFullScreenMagnificationController.getPersistedScale(this.mDisplayId), 1.0f, MAX_SCALE);
        zoomToScale(scale, centerX, centerY);
    }

    private void zoomToScale(float scale, float centerX, float centerY) {
        float scale2 = MathUtils.constrain(scale, 1.0f, MAX_SCALE);
        this.mFullScreenMagnificationController.setScaleAndCenter(this.mDisplayId, scale2, centerX, centerY, true, 0);
    }

    private void zoomOff() {
        if (DEBUG_DETECTING == false) goto L5;
        Slog.i(this.mLogTag, "zoomOff()");
    L5:
        this.mFullScreenMagnificationController.reset(this.mDisplayId, true);
    }

    private static MotionEvent recycleAndNullify(MotionEvent event) {
        if (event == null) goto L6;
        event.recycle();
        return null;
    L6:
        return null;
    }

    public String toString() {
        return "MagnificationGesture{mDetectingState=" + this.mDetectingState + ", mDelegatingState=" + this.mDelegatingState + ", mMagnifiedInteractionState=" + this.mPanningScalingState + ", mViewportDraggingState=" + this.mViewportDraggingState + ", mSinglePanningState=" + this.mSinglePanningState + ", mDetectSingleFingerTripleTap=" + this.mDetectSingleFingerTripleTap + ", mDetectShortcutTrigger=" + this.mDetectShortcutTrigger + ", mCurrentState=" + State.nameOf(this.mCurrentState) + ", mPreviousState=" + State.nameOf(this.mPreviousState) + ", mMagnificationController=" + this.mFullScreenMagnificationController + ", mDisplayId=" + this.mDisplayId + ", mIsSinglePanningEnabled=" + this.mOneFingerPanningSettingsProvider.isOneFingerPanningEnabled() + ", mOverscrollHandler=" + this.mOverscrollHandler + '}';
    }

    private int overscrollState(MotionEvent event, PointF firstPointerDownLocation) {
        if (pointerValid(firstPointerDownLocation) == true) goto L5;
        return 0;
    L5:
        float dX = event.getX() - firstPointerDownLocation.x;
        float dY = event.getY() - firstPointerDownLocation.y;
        if (isAtLeftEdge() == false) goto L12;
        if (isScrollingLeft(dX, dY) == false) goto L12;
        return 1;
    L12:
        if (isAtRightEdge() == false) goto L18;
        if (isScrollingRight(dX, dY) == false) goto L18;
        return 2;
    L18:
        if (isAtTopEdge() == false) goto L22;
        if (isScrollingUp(dX, dY) == false) goto L22;
        return 3;
    L22:
        if (isAtBottomEdge() == true) goto L24;
    L27:
        return 0;
    L24:
        if (isScrollingDown(dX, dY) == false) goto L27;
        return 3;
    }

    private boolean isAtLeftEdge() {
        return this.mFullScreenMagnificationController.isAtLeftEdge(this.mDisplayId, this.mOverscrollEdgeSlop);
    }

    private static boolean isScrollingLeft(float dX, float dY) {
        if (Math.abs(dX) > Math.abs(dY)) goto L5;
    L7:
        return false;
    L5:
        if (dX <= 0.0f) goto L7;
        return true;
    }

    private boolean isAtRightEdge() {
        return this.mFullScreenMagnificationController.isAtRightEdge(this.mDisplayId, this.mOverscrollEdgeSlop);
    }

    private static boolean isScrollingRight(float dX, float dY) {
        if (Math.abs(dX) > Math.abs(dY)) goto L5;
    L7:
        return false;
    L5:
        if (dX >= 0.0f) goto L7;
        return true;
    }

    private boolean isAtTopEdge() {
        return this.mFullScreenMagnificationController.isAtTopEdge(this.mDisplayId, this.mOverscrollEdgeSlop);
    }

    private static boolean isScrollingUp(float dX, float dY) {
        if (Math.abs(dX) < Math.abs(dY)) goto L5;
    L7:
        return false;
    L5:
        if (dY <= 0.0f) goto L7;
        return true;
    }

    private boolean isAtBottomEdge() {
        return this.mFullScreenMagnificationController.isAtBottomEdge(this.mDisplayId, this.mOverscrollEdgeSlop);
    }

    private static boolean isScrollingDown(float dX, float dY) {
        if (Math.abs(dX) < Math.abs(dY)) goto L5;
    L7:
        return false;
    L5:
        if (dY >= 0.0f) goto L7;
        return true;
    }

    private boolean pointerValid(PointF pointerDownLocation) {
        if (Float.isNaN(pointerDownLocation.x) == true) goto L5;
    L8:
        return true;
    L5:
        if (Float.isNaN(pointerDownLocation.y) == false) goto L8;
        return false;
    }

    private void onPan(MotionEvent event) {
    }

    private void onPanningFinished(MotionEvent event) {
    }

    private void cancelFling() {
    }
}
