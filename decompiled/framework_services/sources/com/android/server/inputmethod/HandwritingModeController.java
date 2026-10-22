package com.android.server.inputmethod;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManagerInternal;
import android.graphics.Region;
import android.hardware.input.InputManager;
import android.hardware.input.InputManagerGlobal;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Slog;
import android.view.BatchedInputEventReceiver;
import android.view.Choreographer;
import android.view.InputChannel;
import android.view.InputEvent;
import android.view.InputEventReceiver;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.SurfaceControl;
import com.android.server.LocalServices;
import com.android.server.input.InputManagerInternal;
import com.android.server.wm.WindowManagerInternal;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

/* JADX INFO: loaded from: classes2.dex */
final class HandwritingModeController {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long AFTER_STYLUS_UP_ALLOW_PERIOD_MS = 200;
    static final boolean DEBUG = false;
    private static final int EVENT_BUFFER_SIZE = 100;
    private static final long HANDWRITING_DELEGATION_IDLE_TIMEOUT_MS = 3000;
    private static final int LONG_EVENT_BUFFER_SIZE = 2000;
    public static final String TAG = null;
    private final Context mContext;
    private int mCurrentDisplayId;
    private int mCurrentRequestId;
    private String mDelegatePackageName;
    private boolean mDelegationConnectionlessFlow;
    private Handler mDelegationIdleTimeoutHandler;
    private Runnable mDelegationIdleTimeoutRunnable;
    private boolean mDelegatorFromDefaultHomePackage;
    private String mDelegatorPackageName;
    private final Runnable mDiscardDelegationTextRunnable;
    private ArrayList<MotionEvent> mHandwritingBuffer;
    private InputEventReceiver mHandwritingEventReceiver;
    private HandwritingEventReceiverSurface mHandwritingSurface;
    private Runnable mInkWindowInitRunnable;
    private final InputManagerInternal mInputManagerInternal;
    private final Looper mLooper;
    private final PackageManagerInternal mPackageManagerInternal;
    private boolean mRecordingGesture;
    private boolean mRecordingGestureAfterStylusUp;
    private final WindowManagerInternal mWindowManagerInternal;

    static final class HandwritingSession {
        private final InputChannel mHandwritingChannel;
        private final List<MotionEvent> mRecordedEvents;
        private final int mRequestId;

        /* synthetic */ HandwritingSession(int r1, InputChannel r2, List r3, HandwritingModeControllerIA r4) {
            this(r1, r2, r3);
        }

        private HandwritingSession(int requestId, InputChannel handwritingChannel, List<MotionEvent> recordedEvents) {
            this.mRequestId = requestId;
            this.mHandwritingChannel = handwritingChannel;
            this.mRecordedEvents = recordedEvents;
        }

        int getRequestId() {
            return this.mRequestId;
        }

        InputChannel getHandwritingChannel() {
            return this.mHandwritingChannel;
        }

        List<MotionEvent> getRecordedEvents() {
            return this.mRecordedEvents;
        }
    }

    public static /* synthetic */ boolean $r8$lambda$RpmsqgTEsdViILmxObrUZOUXU6I(HandwritingModeController r0, InputEvent r1) {
        return r0.onInputEvent(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$rI_-JXHQgynFcPJdS6ZZt3puFz4, reason: not valid java name */
    public static /* synthetic */ void m4635$r8$lambda$rI_JXHQgynFcPJdS6ZZt3puFz4(HandwritingModeController r0) {
        r0.lambda$scheduleHandwritingDelegationTimeout$0();
    }

    static {
        TAG = HandwritingModeController.class.getSimpleName();
    }

    HandwritingModeController(Context context, Looper uiThreadLooper, Runnable inkWindowInitRunnable, Runnable discardDelegationTextRunnable) {
        this.mContext = context;
        this.mLooper = uiThreadLooper;
        this.mCurrentDisplayId = -1;
        this.mInputManagerInternal = (InputManagerInternal) LocalServices.getService(InputManagerInternal.class);
        this.mWindowManagerInternal = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
        this.mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        this.mCurrentRequestId = 0;
        this.mInkWindowInitRunnable = inkWindowInitRunnable;
        this.mDiscardDelegationTextRunnable = discardDelegationTextRunnable;
    }

    void initializeHandwritingSpy(int displayId) {
        if (displayId != this.mCurrentDisplayId) goto L5;
        boolean r0 = true;
    L6:
        reset(r0);
        this.mCurrentDisplayId = displayId;
        if (this.mHandwritingBuffer != null) goto L9;
        this.mHandwritingBuffer = new ArrayList(getHandwritingBufferSize());
    L9:
        String name = "stylus-handwriting-event-receiver-" + displayId;
        InputChannel channel = this.mInputManagerInternal.createInputChannel(name);
        channel.getClass();
        if (this.mHandwritingSurface == null) goto L12;
        SurfaceControl surface = this.mHandwritingSurface.getSurface();
    L14:
        if (surface != null) goto L17;
        Slog.e(TAG, "Failed to create input surface");
        return;
    L17:
        this.mHandwritingSurface = new HandwritingEventReceiverSurface(this.mContext, name, displayId, surface, channel);
        this.mHandwritingEventReceiver = new BatchedInputEventReceiver.SimpleBatchedInputEventReceiver(channel.dup(), this.mLooper, Choreographer.getInstance(), new HandwritingModeController$$ExternalSyntheticLambda2(this));
        this.mCurrentRequestId++;
        return;
    L12:
        surface = this.mWindowManagerInternal.getHandwritingSurfaceForDisplay(displayId);
        goto L14
    L5:
        r0 = false;
        goto L6
    }

    OptionalInt getCurrentRequestId() {
        if (this.mHandwritingSurface != null) goto L7;
        Slog.e(TAG, "Cannot get requestId: Handwriting was not initialized.");
        return OptionalInt.empty();
    L7:
        return OptionalInt.of(this.mCurrentRequestId);
    }

    void setNotTouchable(boolean notTouchable) {
        if (getCurrentRequestId().isPresent() == true) goto L5;
        return;
    L5:
        this.mHandwritingSurface.setNotTouchable(notTouchable);
    }

    void setHandwritingTouchableRegion(Region region) {
        if (getCurrentRequestId().isPresent() == true) goto L5;
        return;
    L5:
        this.mHandwritingSurface.setTouchableRegion(region);
    }

    boolean isStylusGestureOngoing() {
        if (this.mRecordingGestureAfterStylusUp == false) goto L14;
        if (this.mHandwritingBuffer.isEmpty() == true) goto L14;
        MotionEvent lastEvent = this.mHandwritingBuffer.get(this.mHandwritingBuffer.size() - 1);
        if (lastEvent.getActionMasked() != 1) goto L14;
        if ((SystemClock.uptimeMillis() - lastEvent.getEventTime()) < AFTER_STYLUS_UP_ALLOW_PERIOD_MS) goto L15;
        return false;
    L15:
        return true;
    L14:
        return this.mRecordingGesture;
    }

    boolean hasOngoingStylusHandwritingSession() {
        if (this.mHandwritingSurface != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mHandwritingSurface.isIntercepting() == false) goto L7;
        return true;
    }

    void prepareStylusHandwritingDelegation(int userId, String delegatePackageName, String delegatorPackageName, boolean connectionless) {
        this.mDelegatePackageName = delegatePackageName;
        this.mDelegatorPackageName = delegatorPackageName;
        this.mDelegatorFromDefaultHomePackage = false;
        if (delegatorPackageName.equals(delegatePackageName) == true) goto L7;
        ComponentName defaultHomeActivity = this.mPackageManagerInternal.getDefaultHomeActivity(userId);
        if (defaultHomeActivity == null) goto L7;
        this.mDelegatorFromDefaultHomePackage = delegatorPackageName.equals(defaultHomeActivity.getPackageName());
    L7:
        this.mDelegationConnectionlessFlow = connectionless;
        if (connectionless == false) goto L10;
    L13:
        scheduleHandwritingDelegationTimeout();
        return;
    L10:
        if (this.mHandwritingBuffer != null) goto L12;
        this.mHandwritingBuffer = new ArrayList(getHandwritingBufferSize());
        goto L13
    L12:
        this.mHandwritingBuffer.ensureCapacity(getHandwritingBufferSize());
        goto L13
    }

    String getDelegatePackageName() {
        return this.mDelegatePackageName;
    }

    String getDelegatorPackageName() {
        return this.mDelegatorPackageName;
    }

    boolean isDelegatorFromDefaultHomePackage() {
        return this.mDelegatorFromDefaultHomePackage;
    }

    boolean isDelegationUsingConnectionlessFlow() {
        return this.mDelegationConnectionlessFlow;
    }

    private void scheduleHandwritingDelegationTimeout() {
        if (this.mDelegationIdleTimeoutHandler != null) goto L5;
        this.mDelegationIdleTimeoutHandler = new Handler(this.mLooper);
    L6:
        this.mDelegationIdleTimeoutRunnable = new HandwritingModeController$$ExternalSyntheticLambda0(this);
        this.mDelegationIdleTimeoutHandler.postDelayed(this.mDelegationIdleTimeoutRunnable, 3000);
        return;
    L5:
        this.mDelegationIdleTimeoutHandler.removeCallbacks(this.mDelegationIdleTimeoutRunnable);
        goto L6
    }

    private /* synthetic */ void lambda$scheduleHandwritingDelegationTimeout$0() {
        Slog.d(TAG, "Stylus handwriting delegation idle timed-out.");
        clearPendingHandwritingDelegation();
        if (this.mHandwritingBuffer == null) goto L6;
        this.mHandwritingBuffer.forEach(new HandwritingModeController$$ExternalSyntheticLambda1());
        this.mHandwritingBuffer.clear();
        this.mHandwritingBuffer.trimToSize();
        this.mHandwritingBuffer.ensureCapacity(getHandwritingBufferSize());
        return;
    }

    private int getHandwritingBufferSize() {
        if (this.mDelegatePackageName != null) goto L5;
        return 100;
    L5:
        if (this.mDelegatorPackageName == null) goto L10;
        return 2000;
    L10:
        return 100;
    }

    void clearPendingHandwritingDelegation() {
        if (this.mDelegationIdleTimeoutHandler == null) goto L5;
        this.mDelegationIdleTimeoutHandler.removeCallbacks(this.mDelegationIdleTimeoutRunnable);
        this.mDelegationIdleTimeoutHandler = null;
    L5:
        this.mDelegationIdleTimeoutRunnable = null;
        this.mDelegatorPackageName = null;
        this.mDelegatePackageName = null;
        this.mDelegatorFromDefaultHomePackage = false;
        if (this.mDelegationConnectionlessFlow == false) goto L9;
        this.mDelegationConnectionlessFlow = false;
        this.mDiscardDelegationTextRunnable.run();
        return;
    }

    HandwritingSession startHandwritingSession(int requestId, int imePid, int imeUid, IBinder focusedWindowToken) {
        clearPendingHandwritingDelegation();
        HandwritingModeControllerIA r1 = null;
        if (this.mHandwritingSurface != null) goto L7;
        Slog.e(TAG, "Cannot start handwriting session: Handwriting was not initialized.");
        return null;
    L7:
        if (requestId == this.mCurrentRequestId) goto L11;
        Slog.e(TAG, "Cannot start handwriting session: Invalid request id: " + requestId);
        return null;
    L11:
        if (isStylusGestureOngoing() == true) goto L14;
        Slog.e(TAG, "Cannot start handwriting session: No stylus gesture is being recorded.");
        return null;
    L14:
        this.mHandwritingEventReceiver.getClass();
        MotionEvent downEvent = this.mHandwritingBuffer.get(0);
        if (this.mWindowManagerInternal.isPointInsideWindow(focusedWindowToken, this.mCurrentDisplayId, downEvent.getRawX(), downEvent.getRawY()) == true) goto L18;
        Slog.e(TAG, "Cannot start handwriting session: Stylus gesture did not start inside the focused window.");
        return null;
    L18:
        InputManagerGlobal.getInstance().pilferPointers(this.mHandwritingSurface.getInputChannel().getToken());
        this.mHandwritingEventReceiver.dispose();
        this.mHandwritingEventReceiver = null;
        this.mRecordingGesture = false;
        this.mRecordingGestureAfterStylusUp = false;
        if (this.mHandwritingSurface.isIntercepting() == true) goto L23;
        this.mHandwritingSurface.startIntercepting(imePid, imeUid);
        InputManager r4 = (InputManager) this.mContext.getSystemService(InputManager.class);
        r4.getClass();
        r4.setPointerIcon(PointerIcon.getSystemIcon(this.mContext, 1), downEvent.getDisplayId(), downEvent.getDeviceId(), downEvent.getPointerId(0), this.mHandwritingSurface.getInputChannel().getToken());
        return new HandwritingSession(this.mCurrentRequestId, this.mHandwritingSurface.getInputChannel(), this.mHandwritingBuffer, r1);
    L23:
        throw new IllegalStateException("Handwriting surface should not be already intercepting.");
    }

    void reset() {
        reset(false);
    }

    void setInkWindowInitializer(Runnable inkWindowInitializer) {
        this.mInkWindowInitRunnable = inkWindowInitializer;
    }

    private void reset(boolean reinitializing) {
        if (this.mHandwritingEventReceiver == null) goto L6;
        this.mHandwritingEventReceiver.dispose();
        this.mHandwritingEventReceiver = null;
    L6:
        if (this.mHandwritingBuffer == null) goto L11;
        this.mHandwritingBuffer.forEach(new HandwritingModeController$$ExternalSyntheticLambda1());
        this.mHandwritingBuffer.clear();
        if (reinitializing == true) goto L11;
        this.mHandwritingBuffer = null;
    L11:
        if (this.mHandwritingSurface == null) goto L16;
        this.mHandwritingSurface.getInputChannel().dispose();
        if (reinitializing == true) goto L16;
        this.mHandwritingSurface.remove();
        this.mHandwritingSurface = null;
    L16:
        if (this.mDelegationConnectionlessFlow == true) goto L18;
        clearPendingHandwritingDelegation();
    L18:
        this.mRecordingGesture = false;
        this.mRecordingGestureAfterStylusUp = false;
    }

    private boolean onInputEvent(InputEvent ev) {
        if (this.mHandwritingEventReceiver == null) goto L18;
        if ((ev instanceof MotionEvent) == false) goto L15;
        MotionEvent event = (MotionEvent) ev;
        if (event.isStylusPointer() == true) goto L10;
        return false;
    L10:
        if (event.getDisplayId() == this.mCurrentDisplayId) goto L13;
        Slog.wtf(TAG, "Received stylus event associated with the incorrect display.");
        return false;
    L13:
        onStylusEvent(event);
        return true;
    L15:
        Slog.wtf(TAG, "Received non-motion event in stylus monitor.");
        return false;
    L18:
        throw new IllegalStateException("Input Event should not be processed when IME has the spy channel.");
    }

    private void onStylusEvent(MotionEvent event) {
        int action = event.getActionMasked();
        if (this.mInkWindowInitRunnable == null) goto L11;
        if (action != 9) goto L7;
    L8:
        this.mInkWindowInitRunnable.run();
        this.mInkWindowInitRunnable = null;
        return;
    L7:
        if (event.getAction() == 9) goto L8;
    L11:
        if (event.isHoverEvent() == false) goto L14;
        return;
    L14:
        if (TextUtils.isEmpty(this.mDelegatePackageName) == false) goto L16;
    L17:
        if (action != 1) goto L19;
    L20:
        this.mRecordingGesture = false;
        if (action != 1) goto L36;
        this.mRecordingGestureAfterStylusUp = true;
    L23:
        if (action != 0) goto L26;
        clearBufferIfRecordingAfterStylusUp();
        this.mRecordingGesture = true;
    L26:
        if (this.mRecordingGesture == true) goto L31;
        if (this.mRecordingGestureAfterStylusUp == true) goto L31;
        return;
    L31:
        if (this.mHandwritingBuffer.size() < getHandwritingBufferSize()) goto L34;
        this.mRecordingGesture = false;
        clearBufferIfRecordingAfterStylusUp();
        return;
    L34:
        this.mHandwritingBuffer.add(MotionEvent.obtain(event));
        return;
    L36:
        this.mHandwritingBuffer.clear();
        return;
    L19:
        if (action != 3) goto L23;
    L16:
        if (this.mDelegationConnectionlessFlow == false) goto L23;
        goto L17
    }

    private void clearBufferIfRecordingAfterStylusUp() {
        if (this.mRecordingGestureAfterStylusUp == false) goto L6;
        this.mHandwritingBuffer.clear();
        this.mRecordingGestureAfterStylusUp = false;
        return;
    }
}
