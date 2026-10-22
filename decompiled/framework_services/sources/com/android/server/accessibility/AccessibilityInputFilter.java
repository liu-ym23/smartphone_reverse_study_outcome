package com.android.server.accessibility;

import android.content.Context;
import android.graphics.Region;
import android.hardware.input.InputManager;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.Display;
import android.view.InputEvent;
import android.view.InputFilter;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import com.android.server.LocalServices;
import com.android.server.accessibility.autoclick.AutoclickController;
import com.android.server.accessibility.gestures.TouchExplorer;
import com.android.server.accessibility.magnification.FullScreenMagnificationController;
import com.android.server.accessibility.magnification.FullScreenMagnificationGestureHandler;
import com.android.server.accessibility.magnification.FullScreenMagnificationVibrationHelper;
import com.android.server.accessibility.magnification.MagnificationGestureHandler;
import com.android.server.accessibility.magnification.MagnificationKeyHandler;
import com.android.server.accessibility.magnification.WindowMagnificationGestureHandler;
import com.android.server.accessibility.magnification.WindowMagnificationPromptController;
import com.android.server.policy.WindowManagerPolicy;
import com.android.server.usb.descriptors.UsbACInterface;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes.dex */
class AccessibilityInputFilter extends InputFilter implements EventStreamTransformation {
    private static final boolean DEBUG = false;
    static final int FEATURES_AFFECTING_MOTION_EVENTS = 7131;
    static final int FLAG_FEATURE_AUTOCLICK = 8;
    static final int FLAG_FEATURE_CONTROL_SCREEN_MAGNIFIER = 32;
    static final int FLAG_FEATURE_FILTER_KEY_EVENTS = 4;
    static final int FLAG_FEATURE_INJECT_MOTION_EVENTS = 16;
    static final int FLAG_FEATURE_INTERCEPT_GENERIC_MOTION_EVENTS = 2048;
    static final int FLAG_FEATURE_MAGNIFICATION_SINGLE_FINGER_TRIPLE_TAP = 1;
    static final int FLAG_FEATURE_MAGNIFICATION_TWO_FINGER_TRIPLE_TAP = 4096;
    static final int FLAG_FEATURE_MOUSE_KEYS = 8192;
    static final int FLAG_FEATURE_TOUCH_EXPLORATION = 2;
    static final int FLAG_FEATURE_TRIGGERED_SCREEN_MAGNIFIER = 64;
    static final int FLAG_REQUEST_2_FINGER_PASSTHROUGH = 512;
    static final int FLAG_REQUEST_MULTI_FINGER_GESTURES = 256;
    static final int FLAG_SEND_MOTION_EVENTS = 1024;
    static final int FLAG_SERVICE_HANDLES_DOUBLE_TAP = 128;
    private static final String TAG = "A11yInputFilter";
    private final AccessibilityManagerService mAms;
    private AutoclickController mAutoclickController;
    private int mCombinedGenericMotionEventSources;
    private int mCombinedMotionEventObservedSources;
    private final Context mContext;
    private int mEnabledFeatures;
    private final SparseArray<EventStreamTransformation> mEventHandler;
    private GenericMotionEventStreamState mGenericMotionEventStreamState;
    private boolean mInstalled;
    private KeyboardInterceptor mKeyboardInterceptor;
    private EventStreamState mKeyboardStreamState;
    private MotionEvent mLastActiveDeviceMotionEvent;
    private final SparseArray<MagnificationGestureHandler> mMagnificationGestureHandler;
    private MagnificationKeyHandler mMagnificationKeyHandler;
    private final SparseArray<MotionEventInjector> mMotionEventInjectors;
    private MouseKeysInterceptor mMouseKeysInterceptor;
    private final SparseArray<EventStreamState> mMouseStreamStates;
    private final PowerManager mPm;
    private SparseArray<Boolean> mServiceDetectsGestures;
    private final SparseArray<TouchExplorer> mTouchExplorer;
    private final SparseArray<EventStreamState> mTouchScreenStreamStates;
    private int mUserId;

    private static class EventStreamState {
        private int mSource;

        EventStreamState() {
            this.mSource = -1;
        }

        public boolean updateInputSource(int source) {
            if (this.mSource != source) goto L6;
            return false;
        L6:
            reset();
            this.mSource = source;
            return true;
        }

        public boolean inputSourceValid() {
            if (this.mSource < 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void reset() {
            this.mSource = -1;
        }

        public boolean shouldProcessScroll() {
            return false;
        }

        public boolean shouldProcessMotionEvent(MotionEvent event) {
            return false;
        }

        public boolean shouldProcessKeyEvent(KeyEvent event) {
            return false;
        }
    }

    private class GenericMotionEventStreamState extends EventStreamState {
        final /* synthetic */ AccessibilityInputFilter this$0;

        /* synthetic */ GenericMotionEventStreamState(AccessibilityInputFilter r1, AccessibilityInputFilterIA r2) {
            this(r1);
        }

        private GenericMotionEventStreamState(AccessibilityInputFilter r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.accessibility.AccessibilityInputFilter.EventStreamState
        public boolean shouldProcessMotionEvent(MotionEvent event) {
            return AccessibilityInputFilter.m543$$Nest$manyServiceWantsGenericMotionEvent(this.this$0, event);
        }

        @Override // com.android.server.accessibility.AccessibilityInputFilter.EventStreamState
        public boolean shouldProcessScroll() {
            return true;
        }
    }

    private static class KeyboardEventStreamState extends EventStreamState {
        private SparseBooleanArray mEventSequenceStartedMap;

        public KeyboardEventStreamState() {
            this.mEventSequenceStartedMap = new SparseBooleanArray();
            reset();
        }

        @Override // com.android.server.accessibility.AccessibilityInputFilter.EventStreamState
        public final void reset() {
            super.reset();
            this.mEventSequenceStartedMap.clear();
        }

        @Override // com.android.server.accessibility.AccessibilityInputFilter.EventStreamState
        public boolean updateInputSource(int deviceId) {
            return false;
        }

        @Override // com.android.server.accessibility.AccessibilityInputFilter.EventStreamState
        public boolean inputSourceValid() {
            return true;
        }

        @Override // com.android.server.accessibility.AccessibilityInputFilter.EventStreamState
        public final boolean shouldProcessKeyEvent(KeyEvent event) {
            int deviceId = event.getDeviceId();
            boolean shouldProcess = false;
            if (this.mEventSequenceStartedMap.get(deviceId, false) == false) goto L6;
            return true;
        L6:
            if (event.getAction() != 0) goto L8;
            shouldProcess = true;
        L8:
            this.mEventSequenceStartedMap.put(deviceId, shouldProcess);
            return shouldProcess;
        }
    }

    private static class MouseEventStreamState extends EventStreamState {
        private boolean mMotionSequenceStarted;

        public MouseEventStreamState() {
            reset();
        }

        @Override // com.android.server.accessibility.AccessibilityInputFilter.EventStreamState
        public final void reset() {
            super.reset();
            this.mMotionSequenceStarted = false;
        }

        @Override // com.android.server.accessibility.AccessibilityInputFilter.EventStreamState
        public final boolean shouldProcessScroll() {
            return true;
        }

        @Override // com.android.server.accessibility.AccessibilityInputFilter.EventStreamState
        public final boolean shouldProcessMotionEvent(MotionEvent event) {
            boolean r1 = true;
            if (this.mMotionSequenceStarted == false) goto L5;
            return true;
        L5:
            int action = event.getActionMasked();
            if (action != 0) goto L8;
        L11:
            this.mMotionSequenceStarted = r1;
            return this.mMotionSequenceStarted;
        L8:
            if (action == 7) goto L11;
            r1 = false;
            goto L11
        }
    }

    private static class TouchScreenEventStreamState extends EventStreamState {
        private boolean mHoverSequenceStarted;
        private boolean mTouchSequenceStarted;

        public TouchScreenEventStreamState() {
            reset();
        }

        @Override // com.android.server.accessibility.AccessibilityInputFilter.EventStreamState
        public final void reset() {
            super.reset();
            this.mTouchSequenceStarted = false;
            this.mHoverSequenceStarted = false;
        }

        @Override // com.android.server.accessibility.AccessibilityInputFilter.EventStreamState
        public final boolean shouldProcessMotionEvent(MotionEvent event) {
            boolean r1 = false;
            if (event.isTouchEvent() == false) goto L13;
            if (this.mTouchSequenceStarted == false) goto L8;
            return true;
        L8:
            if (event.getActionMasked() != 0) goto L10;
            r1 = true;
        L10:
            this.mTouchSequenceStarted = r1;
            return this.mTouchSequenceStarted;
        L13:
            if (this.mHoverSequenceStarted == false) goto L16;
            return true;
        L16:
            if (event.getActionMasked() != 9) goto L18;
            r1 = true;
        L18:
            this.mHoverSequenceStarted = r1;
            return this.mHoverSequenceStarted;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAms, reason: not valid java name */
    static /* bridge */ /* synthetic */ AccessibilityManagerService m542$$Nest$fgetmAms(AccessibilityInputFilter r0) {
        return r0.mAms;
    }

    /* JADX INFO: renamed from: -$$Nest$manyServiceWantsGenericMotionEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m543$$Nest$manyServiceWantsGenericMotionEvent(AccessibilityInputFilter r0, MotionEvent r1) {
        return r0.anyServiceWantsGenericMotionEvent(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$manyServiceWantsToObserveMotionEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m544$$Nest$manyServiceWantsToObserveMotionEvent(AccessibilityInputFilter r0, MotionEvent r1) {
        return r0.anyServiceWantsToObserveMotionEvent(r1);
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    private static MotionEvent cancelMotion(MotionEvent event) {
        if (event.getActionMasked() == 3) goto L32;
        if (event.getActionMasked() == 10) goto L32;
        if (event.getActionMasked() == 1) goto L32;
        if (event.getActionMasked() != 9) goto L11;
    L14:
        int action = 10;
    L16:
        if (event.getActionMasked() != 6) goto L18;
        int pointerCount = event.getPointerCount() - 1;
    L19:
        MotionEvent.PointerProperties[] properties = new MotionEvent.PointerProperties[pointerCount];
        MotionEvent.PointerCoords[] coords = new MotionEvent.PointerCoords[pointerCount];
        int newPointerIndex = 0;
        int i = 0;
    L21:
        if (i >= event.getPointerCount()) goto L30;
        if (event.getActionMasked() == 6) goto L25;
    L27:
        MotionEvent.PointerCoords c = new MotionEvent.PointerCoords();
        c.x = event.getX(i);
        c.y = event.getY(i);
        coords[newPointerIndex] = c;
        MotionEvent.PointerProperties p = new MotionEvent.PointerProperties();
        p.id = event.getPointerId(i);
        p.toolType = event.getToolType(i);
        properties[newPointerIndex] = p;
        newPointerIndex = newPointerIndex + 1;
    L28:
        i = i + 1;
        goto L21
    L25:
        if (event.getActionIndex() != i) goto L27;
    L30:
        return MotionEvent.obtain(event.getDownTime(), SystemClock.uptimeMillis(), action, pointerCount, properties, coords, event.getMetaState(), event.getButtonState(), event.getXPrecision(), event.getYPrecision(), event.getDeviceId(), event.getEdgeFlags(), event.getSource(), event.getDisplayId(), event.getFlags(), event.getClassification());
    L18:
        int pointerCount2 = event.getPointerCount();
        pointerCount = pointerCount2;
        goto L19
    L11:
        if (event.getActionMasked() == 7) goto L14;
        action = 3;
    L32:
        throw new IllegalArgumentException("Can't cancel " + event);
    }

    AccessibilityInputFilter(Context context, AccessibilityManagerService service) {
        this(context, service, new SparseArray(0));
    }

    AccessibilityInputFilter(Context context, AccessibilityManagerService service, SparseArray<EventStreamTransformation> eventHandler) {
        super(context.getMainLooper());
        this.mTouchExplorer = new SparseArray(0);
        this.mMagnificationGestureHandler = new SparseArray(0);
        this.mMotionEventInjectors = new SparseArray(0);
        this.mServiceDetectsGestures = new SparseArray();
        this.mMouseStreamStates = new SparseArray(0);
        this.mTouchScreenStreamStates = new SparseArray(0);
        this.mCombinedGenericMotionEventSources = 0;
        this.mCombinedMotionEventObservedSources = 0;
        this.mLastActiveDeviceMotionEvent = null;
        this.mContext = context;
        this.mAms = service;
        this.mPm = (PowerManager) context.getSystemService("power");
        this.mEventHandler = eventHandler;
    }

    public void onInstalled() {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Accessibility input filter installed.");
    L5:
        this.mInstalled = true;
        disableFeatures();
        enableFeatures();
        this.mAms.onInputFilterInstalled(true);
        super.onInstalled();
    }

    public void onUninstalled() {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Accessibility input filter uninstalled.");
    L5:
        this.mInstalled = false;
        disableFeatures();
        this.mAms.onInputFilterInstalled(false);
        super.onUninstalled();
    }

    void onDisplayAdded(Display display) {
        enableFeaturesForDisplayIfInstalled(display);
    }

    void onDisplayRemoved(int displayId) {
        disableFeaturesForDisplayIfInstalled(displayId);
    }

    public void onInputEvent(InputEvent event, int policyFlags) {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "Received event: " + event + ", policyFlags=0x" + Integer.toHexString(policyFlags));
    L6:
        if (this.mAms.getTraceManager().isA11yTracingEnabledForTypes(4096) == false) goto L8;
        this.mAms.getTraceManager().logTrace("A11yInputFilter.onInputEvent", 4096, "event=" + event + ";policyFlags=" + policyFlags);
    L8:
        onInputEventInternal(event, policyFlags);
    }

    private void onInputEventInternal(InputEvent event, int policyFlags) {
        if (this.mEventHandler.size() == 0) goto L5;
        EventStreamState state = getEventStreamState(event);
        if (state != null) goto L13;
        super.onInputEvent(event, policyFlags);
        return;
    L13:
        int eventSource = event.getSource();
        int displayId = event.getDisplayId();
        if ((1073741824 & policyFlags) != 0) goto L21;
        if (DEBUG == false) goto L18;
        Slog.d(TAG, "Not processing event " + event);
    L18:
        super.onInputEvent(event, policyFlags);
        return;
    L21:
        if (state.updateInputSource(event.getSource()) == false) goto L24;
        clearEventStreamHandler(displayId, eventSource);
    L24:
        if (state.inputSourceValid() == true) goto L28;
        super.onInputEvent(event, policyFlags);
        return;
    L28:
        if ((event instanceof MotionEvent) == false) goto L35;
        if ((this.mEnabledFeatures & FEATURES_AFFECTING_MOTION_EVENTS) == 0) goto L33;
        MotionEvent motionEvent = (MotionEvent) event;
        processMotionEvent(state, motionEvent, policyFlags);
        return;
    L33:
        super.onInputEvent(event, policyFlags);
        return;
    L35:
        if ((event instanceof KeyEvent) == false) goto L39;
        KeyEvent keyEvent = (KeyEvent) event;
        processKeyEvent(state, keyEvent, policyFlags);
        return;
    L39:
        return;
    L5:
        if (DEBUG == false) goto L7;
        Slog.d(TAG, "No mEventHandler for event " + event);
    L7:
        super.onInputEvent(event, policyFlags);
    }

    private EventStreamState getEventStreamState(InputEvent event) {
        AccessibilityInputFilterIA r1 = null;
        if ((event instanceof MotionEvent) == false) goto L26;
        int displayId = event.getDisplayId();
        if (this.mGenericMotionEventStreamState != null) goto L8;
        this.mGenericMotionEventStreamState = new GenericMotionEventStreamState(this, r1);
    L8:
        if (this.mGenericMotionEventStreamState.shouldProcessMotionEvent((MotionEvent) event) == false) goto L12;
        return this.mGenericMotionEventStreamState;
    L12:
        if (event.isFromSource(UsbACInterface.FORMAT_II_AC3) == false) goto L18;
        EventStreamState touchScreenStreamState = this.mTouchScreenStreamStates.get(displayId);
        if (touchScreenStreamState != null) goto L35;
        EventStreamState touchScreenStreamState2 = new TouchScreenEventStreamState();
        this.mTouchScreenStreamStates.put(displayId, touchScreenStreamState2);
        return touchScreenStreamState2;
    L35:
        return touchScreenStreamState;
    L18:
        if (event.isFromSource(UsbACInterface.FORMAT_III_IEC1937_MPEG1_Layer1) == false) goto L34;
        EventStreamState mouseStreamState = this.mMouseStreamStates.get(displayId);
        if (mouseStreamState != null) goto L36;
        EventStreamState mouseStreamState2 = new MouseEventStreamState();
        this.mMouseStreamStates.put(displayId, mouseStreamState2);
        return mouseStreamState2;
    L36:
        return mouseStreamState;
    L34:
        return null;
    L26:
        if ((event instanceof KeyEvent) == false) goto L34;
        if (event.isFromSource(257) == false) goto L34;
        if (this.mKeyboardStreamState != null) goto L33;
        this.mKeyboardStreamState = new KeyboardEventStreamState();
    L33:
        return this.mKeyboardStreamState;
    }

    private void clearEventStreamHandler(int displayId, int eventSource) {
        EventStreamTransformation eventHandler = this.mEventHandler.get(displayId);
        if (eventHandler == null) goto L6;
        eventHandler.clearEvents(eventSource);
        return;
    }

    boolean shouldProcessMultiDeviceEvent(InputEvent event, int policyFlags) {
        if ((event instanceof MotionEvent) == false) goto L38;
        MotionEvent motion = (MotionEvent) event;
        if (motion.isFromSource(2) == true) goto L7;
    L37:
        return true;
    L7:
        if (motion.getAction() == 8) goto L37;
        if (this.mLastActiveDeviceMotionEvent != null) goto L12;
    L14:
        boolean eventIsFromCurrentDevice = false;
    L15:
        int actionMasked = motion.getActionMasked();
        switch(actionMasked) {
            case 0: goto L31;
            case 1: goto L26;
            case 2: goto L22;
            case 3: goto L26;
            case 4: goto L18;
            case 5: goto L22;
            case 6: goto L22;
            case 7: goto L31;
            case 8: goto L18;
            case 9: goto L31;
            case 10: goto L26;
            default: goto L18;
        };
    L22:
        if (eventIsFromCurrentDevice == false) goto L25;
        this.mLastActiveDeviceMotionEvent = MotionEvent.obtain(motion);
        return true;
    L25:
        return false;
    L26:
        if (eventIsFromCurrentDevice == false) goto L29;
        this.mLastActiveDeviceMotionEvent = null;
        return true;
    L29:
        return false;
    L18:
        if (this.mLastActiveDeviceMotionEvent == null) goto L38;
        if (event.getDeviceId() == this.mLastActiveDeviceMotionEvent.getDeviceId()) goto L38;
        return false;
    L31:
        if (this.mLastActiveDeviceMotionEvent != null) goto L33;
    L35:
        MotionEvent canceled = MotionEvent.obtain(motion);
        this.mLastActiveDeviceMotionEvent = canceled;
        return true;
    L33:
        if (this.mLastActiveDeviceMotionEvent.getDeviceId() == motion.getDeviceId()) goto L35;
        MotionEvent canceled2 = cancelMotion(this.mLastActiveDeviceMotionEvent);
        onInputEventInternal(canceled2, policyFlags);
        goto L35
    L12:
        if (this.mLastActiveDeviceMotionEvent.getDeviceId() != motion.getDeviceId()) goto L14;
        eventIsFromCurrentDevice = true;
    L38:
        return true;
    }

    private void processMotionEvent(EventStreamState state, MotionEvent event, int policyFlags) {
        if (state.shouldProcessScroll() == true) goto L9;
        if (event.getActionMasked() != 8) goto L9;
        super.onInputEvent(event, policyFlags);
        return;
    L9:
        if (state.shouldProcessMotionEvent(event) == true) goto L11;
        return;
    L11:
        handleMotionEvent(event, policyFlags);
    }

    private void processKeyEvent(EventStreamState state, KeyEvent event, int policyFlags) {
        if (state.shouldProcessKeyEvent(event) == true) goto L10;
        if (DEBUG == false) goto L7;
        Slog.d(TAG, "processKeyEvent: not processing: " + event);
    L7:
        super.onInputEvent(event, policyFlags);
        return;
    L10:
        if (DEBUG == false) goto L12;
        Slog.d(TAG, "processKeyEvent: " + event);
    L12:
        this.mEventHandler.get(0).onKeyEvent(event, policyFlags);
    }

    private void handleMotionEvent(MotionEvent event, int policyFlags) {
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "Handling motion event: " + event + ", policyFlags: " + policyFlags);
    L5:
        int r3 = 0;
        this.mPm.userActivity(event.getEventTime(), false);
        MotionEvent transformedEvent = MotionEvent.obtain(event);
        int displayId = event.getDisplayId();
        SparseArray<EventStreamTransformation> r2 = this.mEventHandler;
        if (isDisplayIdValid(displayId) == false) goto L8;
        r3 = displayId;
    L8:
        EventStreamTransformation eventStreamTransformation = r2.get(r3);
        if (eventStreamTransformation == null) goto L11;
        eventStreamTransformation.onMotionEvent(transformedEvent, event, policyFlags);
    L11:
        transformedEvent.recycle();
    }

    private boolean isDisplayIdValid(int displayId) {
        if (this.mEventHandler.get(displayId) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public void onMotionEvent(MotionEvent transformedEvent, MotionEvent rawEvent, int policyFlags) {
        if (this.mInstalled == true) goto L6;
        Slog.w(TAG, "onMotionEvent called before input filter installed!");
        return;
    L6:
        sendInputEvent(transformedEvent, policyFlags);
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public void onKeyEvent(KeyEvent event, int policyFlags) {
        if (this.mInstalled == true) goto L6;
        Slog.w(TAG, "onKeyEvent called before input filter installed!");
        return;
    L6:
        sendInputEvent(event, policyFlags);
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public void onAccessibilityEvent(AccessibilityEvent event) {
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public void setNext(EventStreamTransformation sink) {
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public EventStreamTransformation getNext() {
        return null;
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public void clearEvents(int inputSource) {
    }

    void setUserAndEnabledFeatures(int userId, int enabledFeatures) {
        if (DEBUG == false) goto L6;
        Slog.i(TAG, "setUserAndEnabledFeatures(userId = " + userId + ", enabledFeatures = 0x" + Integer.toHexString(enabledFeatures) + ")");
    L6:
        if (this.mEnabledFeatures != enabledFeatures) goto L11;
        if (this.mUserId != userId) goto L11;
        return;
    L11:
        if (this.mInstalled == false) goto L13;
        disableFeatures();
    L13:
        this.mUserId = userId;
        this.mEnabledFeatures = enabledFeatures;
        if (this.mInstalled == false) goto L17;
        enableFeatures();
        return;
    }

    void notifyAccessibilityEvent(AccessibilityEvent event) {
        int i = 0;
    L4:
        if (i >= this.mEventHandler.size()) goto L10;
        EventStreamTransformation eventHandler = this.mEventHandler.valueAt(i);
        if (eventHandler == null) goto L8;
        eventHandler.onAccessibilityEvent(event);
    L8:
        i = i + 1;
        goto L4
    }

    void notifyMagnificationShortcutTriggered(int displayId) {
        if (this.mMagnificationGestureHandler.size() == 0) goto L8;
        MagnificationGestureHandler handler = this.mMagnificationGestureHandler.get(displayId);
        if (handler == null) goto L9;
        handler.notifyShortcutTriggered();
        return;
    L9:
        return;
    }

    private void enableFeatures() {
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "enableFeatures()");
    L5:
        resetAllStreamState();
        ArrayList<Display> displaysList = this.mAms.getValidDisplayList();
        int i = displaysList.size() - 1;
    L6:
        if (i < 0) goto L8;
        enableFeaturesForDisplay(displaysList.get(i));
        i = i - 1;
        goto L6
    L8:
        enableDisplayIndependentFeatures();
    }

    private void enableFeaturesForDisplay(Display display) {
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "enableFeaturesForDisplay() : display Id = " + display.getDisplayId());
    L5:
        Context displayContext = this.mContext.createDisplayContext(display);
        int displayId = display.getDisplayId();
        if (this.mAms.isDisplayProxyed(displayId) == false) goto L9;
        return;
    L9:
        if (this.mServiceDetectsGestures.contains(displayId) == true) goto L12;
        this.mServiceDetectsGestures.put(displayId, false);
    L12:
        if ((this.mEnabledFeatures & 8) == 0) goto L18;
        if (this.mAutoclickController != null) goto L16;
        this.mAutoclickController = new AutoclickController(this.mContext, this.mUserId, this.mAms.getTraceManager());
    L16:
        addFirstEventHandler(displayId, this.mAutoclickController);
    L18:
        if ((this.mEnabledFeatures & 2) == 0) goto L33;
        TouchExplorer explorer = new TouchExplorer(displayContext, this.mAms);
        if ((this.mEnabledFeatures & 128) == 0) goto L23;
        explorer.setServiceHandlesDoubleTap(true);
    L23:
        if ((this.mEnabledFeatures & 256) == 0) goto L26;
        explorer.setMultiFingerGesturesEnabled(true);
    L26:
        if ((this.mEnabledFeatures & 512) == 0) goto L29;
        explorer.setTwoFingerPassthroughEnabled(true);
    L29:
        if ((this.mEnabledFeatures & 1024) == 0) goto L31;
        explorer.setSendMotionEventsEnabled(true);
    L31:
        explorer.setServiceDetectsGestures(this.mServiceDetectsGestures.get(displayId).booleanValue());
        addFirstEventHandler(displayId, explorer);
        this.mTouchExplorer.put(displayId, explorer);
    L33:
        if ((this.mEnabledFeatures & 2048) == 0) goto L36;
        addFirstEventHandler(displayId, new AnonymousClass1(this));
    L36:
        if (isAnyMagnificationEnabled() == false) goto L39;
        MagnificationGestureHandler magnificationGestureHandler = createMagnificationGestureHandler(displayId, displayContext);
        addFirstEventHandler(displayId, magnificationGestureHandler);
        this.mMagnificationGestureHandler.put(displayId, magnificationGestureHandler);
    L39:
        if ((this.mEnabledFeatures & 16) == 0) goto L42;
        MotionEventInjector injector = new MotionEventInjector(this.mContext.getMainLooper(), this.mAms.getTraceManager());
        addFirstEventHandler(displayId, injector);
        this.mMotionEventInjectors.put(displayId, injector);
        return;
    }

    private void enableDisplayIndependentFeatures() {
        if ((this.mEnabledFeatures & 16) == 0) goto L6;
        this.mAms.setMotionEventInjectors(this.mMotionEventInjectors);
    L6:
        if ((this.mEnabledFeatures & 4) == 0) goto L9;
        this.mKeyboardInterceptor = new KeyboardInterceptor(this.mAms, (WindowManagerPolicy) LocalServices.getService(WindowManagerPolicy.class));
        addFirstEventHandler(0, this.mKeyboardInterceptor);
    L9:
        if ((this.mEnabledFeatures & 8192) == 0) goto L12;
        AccessibilityManagerService r2 = this.mAms;
        InputManager r3 = (InputManager) this.mContext.getSystemService(InputManager.class);
        r3.getClass();
        this.mMouseKeysInterceptor = new MouseKeysInterceptor(r2, r3, Looper.myLooper(), 0);
        addFirstEventHandler(0, this.mMouseKeysInterceptor);
    L12:
        if (isAnyMagnificationEnabled() == false) goto L15;
        this.mMagnificationKeyHandler = new MagnificationKeyHandler(this.mAms.getMagnificationController());
        addFirstEventHandler(0, this.mMagnificationKeyHandler);
        return;
    }

    private boolean isAnyMagnificationEnabled() {
        if ((this.mEnabledFeatures & 32) == 0) goto L5;
        return true;
    L5:
        if ((this.mEnabledFeatures & 1) == 0) goto L7;
        return true;
    L7:
        if ((this.mEnabledFeatures & 4096) == 0) goto L9;
        return true;
    L9:
        if ((this.mEnabledFeatures & 64) != 0) goto L16;
        return false;
    L16:
        return true;
    }

    private void addFirstEventHandler(int displayId, EventStreamTransformation handler) {
        EventStreamTransformation eventHandler = this.mEventHandler.get(displayId);
        if (eventHandler == null) goto L5;
        handler.setNext(eventHandler);
    L6:
        this.mEventHandler.put(displayId, handler);
        return;
    L5:
        handler.setNext(this);
        goto L6
    }

    private void disableFeatures() {
        ArrayList<Display> displaysList = this.mAms.getValidDisplayList();
        int i = displaysList.size() - 1;
    L3:
        if (i < 0) goto L5;
        disableFeaturesForDisplay(displaysList.get(i).getDisplayId());
        i = i - 1;
        goto L3
    L5:
        this.mAms.setMotionEventInjectors(null);
        disableDisplayIndependentFeatures();
        resetAllStreamState();
    }

    private void disableFeaturesForDisplay(int displayId) {
        if (DEBUG == false) goto L5;
        Slog.i(TAG, "disableFeaturesForDisplay() : display Id = " + displayId);
    L5:
        MotionEventInjector injector = this.mMotionEventInjectors.get(displayId);
        if (injector == null) goto L8;
        injector.onDestroy();
        this.mMotionEventInjectors.remove(displayId);
    L8:
        TouchExplorer explorer = this.mTouchExplorer.get(displayId);
        if (explorer == null) goto L11;
        explorer.onDestroy();
        this.mTouchExplorer.remove(displayId);
    L11:
        MagnificationGestureHandler handler = this.mMagnificationGestureHandler.get(displayId);
        if (handler == null) goto L14;
        handler.onDestroy();
        this.mMagnificationGestureHandler.remove(displayId);
    L14:
        EventStreamTransformation eventStreamTransformation = this.mEventHandler.get(displayId);
        if (eventStreamTransformation == null) goto L18;
        this.mEventHandler.remove(displayId);
        return;
    }

    void enableFeaturesForDisplayIfInstalled(Display display) {
        if (this.mInstalled == false) goto L6;
        resetStreamStateForDisplay(display.getDisplayId());
        enableFeaturesForDisplay(display);
        return;
    }

    void disableFeaturesForDisplayIfInstalled(int displayId) {
        if (this.mInstalled == false) goto L6;
        disableFeaturesForDisplay(displayId);
        resetStreamStateForDisplay(displayId);
        return;
    }

    private void disableDisplayIndependentFeatures() {
        if (this.mAutoclickController == null) goto L6;
        this.mAutoclickController.onDestroy();
        this.mAutoclickController = null;
    L6:
        if (this.mKeyboardInterceptor == null) goto L9;
        this.mKeyboardInterceptor.onDestroy();
        this.mKeyboardInterceptor = null;
    L9:
        if (this.mMouseKeysInterceptor == null) goto L12;
        this.mMouseKeysInterceptor.onDestroy();
        this.mMouseKeysInterceptor = null;
    L12:
        if (this.mMagnificationKeyHandler == null) goto L15;
        this.mMagnificationKeyHandler.onDestroy();
        this.mMagnificationKeyHandler = null;
        return;
    }

    private MagnificationGestureHandler createMagnificationGestureHandler(int displayId, Context displayContext) {
        if ((this.mEnabledFeatures & 1) == 0) goto L5;
        boolean r2 = true;
    L6:
        boolean detectControlGestures = r2;
        if ((this.mEnabledFeatures & 4096) == 0) goto L9;
        boolean detectTwoFingerTripleTap = true;
    L11:
        if ((this.mEnabledFeatures & 64) == 0) goto L13;
        boolean triggerable = true;
    L15:
        if (this.mAms.getMagnificationMode(displayId) != 2) goto L17;
        MagnificationGestureHandler magnificationGestureHandler = new WindowMagnificationGestureHandler(displayContext.createWindowContext(2039, null), this.mAms.getMagnificationConnectionManager(), this.mAms.getTraceManager(), this.mAms.getMagnificationController(), detectControlGestures, detectTwoFingerTripleTap, triggerable, displayId);
        return magnificationGestureHandler;
    L17:
        Context uiContext = displayContext.createWindowContext(2027, null);
        FullScreenMagnificationVibrationHelper fullScreenMagnificationVibrationHelper = new FullScreenMagnificationVibrationHelper(uiContext);
        FullScreenMagnificationController controller = this.mAms.getMagnificationController().getFullScreenMagnificationController();
        MagnificationGestureHandler magnificationGestureHandler2 = new FullScreenMagnificationGestureHandler(uiContext, controller, this.mAms.getTraceManager(), this.mAms.getMagnificationController(), detectControlGestures, detectTwoFingerTripleTap, triggerable, new WindowMagnificationPromptController(displayContext, this.mUserId), displayId, fullScreenMagnificationVibrationHelper);
        return magnificationGestureHandler2;
    L13:
        triggerable = false;
        goto L15
    L9:
        detectTwoFingerTripleTap = false;
        goto L11
    L5:
        r2 = false;
        goto L6
    }

    void resetAllStreamState() {
        ArrayList<Display> displaysList = this.mAms.getValidDisplayList();
        int i = displaysList.size() - 1;
    L3:
        if (i < 0) goto L6;
        resetStreamStateForDisplay(displaysList.get(i).getDisplayId());
        i = i - 1;
        goto L3
    L6:
        if (this.mKeyboardStreamState == null) goto L10;
        this.mKeyboardStreamState.reset();
        return;
    }

    void resetStreamStateForDisplay(int displayId) {
        EventStreamState touchScreenStreamState = this.mTouchScreenStreamStates.get(displayId);
        if (touchScreenStreamState == null) goto L5;
        touchScreenStreamState.reset();
        this.mTouchScreenStreamStates.remove(displayId);
    L5:
        EventStreamState mouseStreamState = this.mMouseStreamStates.get(displayId);
        if (mouseStreamState == null) goto L9;
        mouseStreamState.reset();
        this.mMouseStreamStates.remove(displayId);
        return;
    }

    @Override // com.android.server.accessibility.EventStreamTransformation
    public void onDestroy() {
    }

    public void refreshMagnificationMode(Display display) {
        int displayId = display.getDisplayId();
        MagnificationGestureHandler magnificationGestureHandler = this.mMagnificationGestureHandler.get(displayId);
        if (magnificationGestureHandler != null) goto L6;
        return;
    L6:
        if (magnificationGestureHandler.getMode() != this.mAms.getMagnificationMode(displayId)) goto L8;
        return;
    L8:
        magnificationGestureHandler.onDestroy();
        MagnificationGestureHandler currentMagnificationGestureHandler = createMagnificationGestureHandler(displayId, this.mContext.createDisplayContext(display));
        switchEventStreamTransformation(displayId, magnificationGestureHandler, currentMagnificationGestureHandler);
        this.mMagnificationGestureHandler.put(displayId, currentMagnificationGestureHandler);
    }

    private void switchEventStreamTransformation(int displayId, EventStreamTransformation oldStreamTransformation, EventStreamTransformation currentStreamTransformation) {
        EventStreamTransformation eventStreamTransformation = this.mEventHandler.get(displayId);
        if (eventStreamTransformation != null) goto L5;
        return;
    L5:
        if (eventStreamTransformation != oldStreamTransformation) goto L7;
        currentStreamTransformation.setNext(oldStreamTransformation.getNext());
        this.mEventHandler.put(displayId, currentStreamTransformation);
        return;
    L7:
        if (eventStreamTransformation == null) goto L16;
        if (eventStreamTransformation.getNext() == oldStreamTransformation) goto L10;
        eventStreamTransformation = eventStreamTransformation.getNext();
        goto L7
    L10:
        eventStreamTransformation.setNext(currentStreamTransformation);
        currentStreamTransformation.setNext(oldStreamTransformation.getNext());
        return;
    }

    private boolean anyServiceWantsGenericMotionEvent(MotionEvent event) {
        boolean isTouchEvent = event.isFromSource(UsbACInterface.FORMAT_II_AC3);
        if (isTouchEvent == true) goto L5;
    L7:
        int eventSourceWithoutClass = event.getSource() & (-256);
        if ((this.mCombinedGenericMotionEventSources & eventSourceWithoutClass) == 0) goto L11;
        return true;
    L11:
        return false;
    L5:
        if (canShareGenericTouchEvent() == true) goto L7;
        return false;
    }

    private boolean anyServiceWantsToObserveMotionEvent(MotionEvent event) {
        int eventSourceWithoutClass = event.getSource() & (-256);
        if ((this.mCombinedMotionEventObservedSources & eventSourceWithoutClass) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean canShareGenericTouchEvent() {
        if ((this.mCombinedMotionEventObservedSources & UsbACInterface.FORMAT_II_AC3) == 0) goto L6;
        return true;
    L6:
        if ((this.mEnabledFeatures & 2) != 0) goto L8;
        return true;
    L8:
        return false;
    }

    public void setCombinedGenericMotionEventSources(int sources) {
        this.mCombinedGenericMotionEventSources = sources;
    }

    public void setCombinedMotionEventObservedSources(int sources) {
        this.mCombinedMotionEventObservedSources = sources;
    }

    public void setGestureDetectionPassthroughRegion(int displayId, Region region) {
        if (region != null) goto L4;
        return;
    L4:
        if (this.mTouchExplorer.contains(displayId) == false) goto L8;
        this.mTouchExplorer.get(displayId).setGestureDetectionPassthroughRegion(region);
        return;
    }

    public void setTouchExplorationPassthroughRegion(int displayId, Region region) {
        if (region != null) goto L4;
        return;
    L4:
        if (this.mTouchExplorer.contains(displayId) == false) goto L8;
        this.mTouchExplorer.get(displayId).setTouchExplorationPassthroughRegion(region);
        return;
    }

    public void setServiceDetectsGesturesEnabled(int displayId, boolean mode) {
        if (this.mTouchExplorer.contains(displayId) == false) goto L5;
        this.mTouchExplorer.get(displayId).setServiceDetectsGestures(mode);
    L5:
        this.mServiceDetectsGestures.put(displayId, Boolean.valueOf(mode));
    }

    public void resetServiceDetectsGestures() {
        this.mServiceDetectsGestures.clear();
    }

    public void requestTouchExploration(int displayId) {
        if (this.mTouchExplorer.contains(displayId) == false) goto L6;
        this.mTouchExplorer.get(displayId).requestTouchExploration();
        return;
    }

    public void requestDragging(int displayId, int pointerId) {
        if (this.mTouchExplorer.contains(displayId) == false) goto L6;
        this.mTouchExplorer.get(displayId).requestDragging(pointerId);
        return;
    }

    public void requestDelegating(int displayId) {
        if (this.mTouchExplorer.contains(displayId) == false) goto L6;
        this.mTouchExplorer.get(displayId).requestDelegating();
        return;
    }

    public void onDoubleTap(int displayId) {
        if (this.mTouchExplorer.contains(displayId) == false) goto L6;
        this.mTouchExplorer.get(displayId).onDoubleTap();
        return;
    }

    public void onDoubleTapAndHold(int displayId) {
        if (this.mTouchExplorer.contains(displayId) == false) goto L6;
        this.mTouchExplorer.get(displayId).onDoubleTapAndHold();
        return;
    }

    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (this.mEventHandler != null) goto L5;
        return;
    L5:
        pw.append("A11yInputFilter Info : ");
        pw.println();
        ArrayList<Display> displaysList = this.mAms.getValidDisplayList();
        int i = 0;
    L7:
        if (i >= displaysList.size()) goto L34;
        int displayId = displaysList.get(i).getDisplayId();
        EventStreamTransformation next = this.mEventHandler.get(displayId);
        if (next == null) goto L32;
        pw.append("Enabled features of Display [");
        pw.append(Integer.toString(displayId));
        pw.append("] = ");
        StringJoiner joiner = new StringJoiner(",", "[", "]");
    L11:
        if (next == null) goto L31;
        if ((next instanceof MagnificationGestureHandler) == false) goto L16;
        joiner.add("MagnificationGesture");
    L30:
        next = next.getNext();
        goto L11
    L16:
        if ((next instanceof KeyboardInterceptor) == false) goto L19;
        joiner.add("KeyboardInterceptor");
        goto L30
    L19:
        if ((next instanceof TouchExplorer) == false) goto L22;
        joiner.add("TouchExplorer");
        goto L30
    L22:
        if ((next instanceof AutoclickController) == false) goto L25;
        joiner.add("AutoclickController");
        goto L30
    L25:
        if ((next instanceof MotionEventInjector) == false) goto L28;
        joiner.add("MotionEventInjector");
        goto L30
    L28:
        if ((next instanceof MagnificationKeyHandler) == false) goto L30;
        joiner.add("MagnificationKeyHandler");
        goto L30
    L31:
        pw.append(joiner.toString());
    L32:
        pw.println();
        i = i + 1;
        goto L7
    }
}
