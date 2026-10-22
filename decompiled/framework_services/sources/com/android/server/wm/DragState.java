package com.android.server.wm;

import android.animation.Animator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Binder;
import android.os.IBinder;
import android.os.InputConstants;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.os.Trace;
import android.os.UserHandle;
import android.util.Slog;
import android.view.Display;
import android.view.DragEvent;
import android.view.InputApplicationHandle;
import android.view.InputChannel;
import android.view.InputWindowHandle;
import android.view.SurfaceControl;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.view.IDragAndDropPermissions;
import com.android.server.LocalServices;
import com.android.server.pm.UserManagerInternal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: loaded from: classes3.dex */
class DragState {
    private static final String ANIMATED_PROPERTY_ALPHA = "alpha";
    private static final String ANIMATED_PROPERTY_SCALE = "scale";
    private static final String ANIMATED_PROPERTY_X = "x";
    private static final String ANIMATED_PROPERTY_Y = "y";
    private static final float DIFFERENT_DISPLAY_RETURN_ANIMATION_SCALE = 0.75f;
    private static final int DRAG_FLAGS_URI_ACCESS = 3;
    private static final int DRAG_FLAGS_URI_PERMISSIONS = 195;
    private static final long MAX_ANIMATION_DURATION_MS = 375;
    private static final long MIN_ANIMATION_DURATION_MS = 195;
    float mAnimatedScale;
    volatile boolean mAnimationCompleted;
    private ValueAnimator mAnimator;
    int mCallingTaskIdToHide;
    boolean mCrossProfileCopyAllowed;
    private final Interpolator mCubicEaseOutInterpolator;
    DisplayContent mCurrentDisplayContent;
    float mCurrentDisplayX;
    float mCurrentDisplayY;
    ClipData mData;
    ClipDescription mDataDescription;
    private final Point mDisplaySize;
    final DragDropController mDragDropController;
    private boolean mDragInProgress;
    boolean mDragResult;
    int mFlags;
    InputInterceptor mInputInterceptor;
    SurfaceControl mInputSurface;
    private boolean mIsClosing;
    IBinder mLocalWin;
    ArrayList<WindowState> mNotifiedWindows;
    int mPid;
    boolean mRelinquishDragSurfaceToDropTarget;
    final WindowManagerService mService;
    int mSourceUserId;
    float mStartDragAlpha;
    DisplayContent mStartDragDisplayContent;
    float mStartDragDisplayX;
    float mStartDragDisplayY;
    SurfaceControl mSurfaceControl;
    float mThumbOffsetX;
    float mThumbOffsetY;
    private final Rect mTmpClipRect;
    IBinder mToken;
    final SurfaceControl.Transaction mTransaction;
    int mUid;
    DragEvent mUnhandledDropEvent;

    private class AnimationListener implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
        final /* synthetic */ DragState this$0;

        /* synthetic */ AnimationListener(DragState r1, DragStateIA r2) {
            this(r1);
        }

        private AnimationListener(DragState r1) {
            this.this$0 = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            SurfaceControl.Transaction transaction = this.this$0.mService.mTransactionFactory.get();
            transaction.setPosition(this.this$0.mSurfaceControl, ((Float) animation.getAnimatedValue(DragState.ANIMATED_PROPERTY_X)).floatValue(), ((Float) animation.getAnimatedValue(DragState.ANIMATED_PROPERTY_Y)).floatValue());     // Catch: Throwable -> L6
            transaction.setAlpha(this.this$0.mSurfaceControl, ((Float) animation.getAnimatedValue(DragState.ANIMATED_PROPERTY_ALPHA)).floatValue());     // Catch: Throwable -> L6
            transaction.setMatrix(this.this$0.mSurfaceControl, ((Float) animation.getAnimatedValue(DragState.ANIMATED_PROPERTY_SCALE)).floatValue(), 0.0f, 0.0f, ((Float) animation.getAnimatedValue(DragState.ANIMATED_PROPERTY_SCALE)).floatValue());     // Catch: Throwable -> L6
            transaction.apply();     // Catch: Throwable -> L6
            transaction.close();
            return;
        L6:
            th = move-exception;
            if (transaction == null) goto L18;
            transaction.close();     // Catch: Throwable -> L11
            throw th;
        L11:
            th = move-exception;
            th.addSuppressed(th);
            throw th;
        L18:
            throw th;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.this$0.mAnimationCompleted = true;
            this.this$0.mDragDropController.sendHandlerMessage(2, null);
        }
    }

    class InputInterceptor {
        InputChannel mClientChannel;
        InputApplicationHandle mDragApplicationHandle;
        InputWindowHandle mDragWindowHandle;
        DragInputEventReceiver mInputEventReceiver;
        final /* synthetic */ DragState this$0;

        public static /* synthetic */ void $r8$lambda$XcWAA2A07k3lMjRqf6cMWjB5Sy8(DisplayContent r0) {
            lambda$new$0(r0);
        }

        /* JADX INFO: renamed from: $r8$lambda$_i4aN9DKrJWpXguOJEa99H8f2-E, reason: not valid java name */
        public static /* synthetic */ void m9987$r8$lambda$_i4aN9DKrJWpXguOJEa99H8f2E(DisplayContent r0) {
            lambda$tearDown$1(r0);
        }

        InputInterceptor(DragState this$0, Display display) {
            this.this$0 = this$0;
            this.mClientChannel = this$0.mService.mInputManager.createInputChannel("drag");
            this.mInputEventReceiver = new DragInputEventReceiver(this.mClientChannel, this$0.mService.mH.getLooper(), this$0.mDragDropController);
            this.mDragApplicationHandle = new InputApplicationHandle(new Binder(), "drag", InputConstants.DEFAULT_DISPATCHING_TIMEOUT_MILLIS);
            this.mDragWindowHandle = new InputWindowHandle(this.mDragApplicationHandle, display.getDisplayId());
            this.mDragWindowHandle.name = "drag";
            this.mDragWindowHandle.token = this.mClientChannel.getToken();
            this.mDragWindowHandle.layoutParamsType = 2016;
            this.mDragWindowHandle.dispatchingTimeoutMillis = InputConstants.DEFAULT_DISPATCHING_TIMEOUT_MILLIS;
            this.mDragWindowHandle.ownerPid = WindowManagerService.MY_PID;
            this.mDragWindowHandle.ownerUid = WindowManagerService.MY_UID;
            this.mDragWindowHandle.scaleFactor = 1.0f;
            this.mDragWindowHandle.touchableRegion.setEmpty();
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[0] == false) goto L5;
            ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_ORIENTATION, 7928129513685401229L, 0, null);
        L5:
            this$0.mService.mRoot.forAllDisplays(new DragState$InputInterceptor$$ExternalSyntheticLambda0());
        }

        private static /* synthetic */ void lambda$new$0(DisplayContent dc) {
            dc.getDisplayRotation().pause();
        }

        void tearDown() {
            this.this$0.mService.mInputManager.removeInputChannel(this.mClientChannel.getToken());
            this.mInputEventReceiver.dispose();
            this.mInputEventReceiver = null;
            this.mClientChannel.dispose();
            this.mClientChannel = null;
            this.mDragWindowHandle = null;
            this.mDragApplicationHandle = null;
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[0] == false) goto L5;
            ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_ORIENTATION, 8231481023986546563L, 0, null);
        L5:
            this.this$0.mService.mRoot.forAllDisplays(new DragState$InputInterceptor$$ExternalSyntheticLambda1());
        }

        private static /* synthetic */ void lambda$tearDown$1(DisplayContent dc) {
            dc.getDisplayRotation().resume();
        }
    }

    public static /* synthetic */ void $r8$lambda$MlPZji_R9BXfQU8PSK0J4X2swSs(ValueAnimator r0) {
        lambda$createCancelAnimationLocked$3(r0);
    }

    public static /* synthetic */ void $r8$lambda$P9DIUXjyorEY8LWyHYsvoeb7Zm4(CompletableFuture r0) {
        lambda$showInputSurface$0(r0);
    }

    public static /* synthetic */ void $r8$lambda$RZgNOGYZMNjrQ_9TyJK9tLnFLeg(DragState r0, float r1, float r2, boolean r3, WindowState r4) {
        r0.lambda$broadcastDragStartedLocked$1(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$VKHOxpMDX4IY28xXIQdDb165VGM(ValueAnimator r0) {
        lambda$createReturnAnimationLocked$2(r0);
    }

    DragState(WindowManagerService service, DragDropController controller, IBinder token, SurfaceControl surface, int flags, IBinder localWin) {
        this.mAnimatedScale = 1.0f;
        this.mAnimationCompleted = false;
        this.mCubicEaseOutInterpolator = new DecelerateInterpolator(1.5f);
        this.mDisplaySize = new Point();
        this.mTmpClipRect = new Rect();
        this.mService = service;
        this.mDragDropController = controller;
        this.mToken = token;
        this.mSurfaceControl = surface;
        this.mFlags = flags;
        this.mLocalWin = localWin;
        this.mNotifiedWindows = new ArrayList();
        this.mTransaction = service.mTransactionFactory.get();
    }

    boolean isClosing() {
        return this.mIsClosing;
    }

    private CompletableFuture<Void> showInputSurface() {
        if (this.mInputSurface != null) goto L5;
        this.mInputSurface = this.mService.makeSurfaceBuilder().setContainerLayer().setName("Drag and Drop Input Consumer").setCallsite("DragState.showInputSurface").setParent(this.mCurrentDisplayContent.getOverlayLayer()).build();
    L5:
        InputWindowHandle h = getInputWindowHandle();
        if (h != null) goto L9;
        Slog.w("WindowManager", "Drag is in progress but there is no drag window handle.");
        return CompletableFuture.completedFuture(null);
    L9:
        this.mTmpClipRect.set(0, 0, this.mDisplaySize.x, this.mDisplaySize.y);
        h.setTrustedOverlay(this.mTransaction, this.mInputSurface, true);
        this.mTransaction.show(this.mInputSurface).setInputWindowInfo(this.mInputSurface, h).setLayer(this.mInputSurface, Integer.MAX_VALUE).setCrop(this.mInputSurface, this.mTmpClipRect);
        final CompletableFuture<Void> result = new CompletableFuture();
        this.mTransaction.addWindowInfosReportedListener(new DragState$$ExternalSyntheticLambda1(result)).apply();
        return result;
    }

    private static /* synthetic */ void lambda$showInputSurface$0(CompletableFuture result) {
        result.complete(null);
    }

    void closeLocked() {
        this.mIsClosing = true;
        if (this.mInputInterceptor == null) goto L9;
        if (WindowManagerDebugConfig.DEBUG_DRAG == false) goto L7;
        Slog.d("WindowManager", "Unregistering drag input channel");
    L7:
        this.mDragDropController.sendHandlerMessage(1, this.mInputInterceptor);
        this.mInputInterceptor = null;
    L9:
        if (this.mDragInProgress == false) goto L38;
        if (WindowManagerDebugConfig.DEBUG_DRAG == false) goto L13;
        Slog.d("WindowManager", "Broadcasting DRAG_ENDED");
    L13:
        Iterator<WindowState> r0 = this.mNotifiedWindows.iterator();
    L15:
        if (r0.hasNext() == false) goto L36;
        WindowState ws = r0.next();
        float inWindowX = 0.0f;
        float inWindowY = 0.0f;
        boolean includeDragSurface = false;
        if (this.mDragResult == false) goto L19;
    L23:
        DragEvent event = obtainDragEndedEvent(inWindowX, inWindowY, includeDragSurface);
        if (WindowManagerDebugConfig.DEBUG_DRAG == false) goto L29;
        Slog.d("WindowManager", "Sending DRAG_ENDED to " + ws);     // Catch: RemoteException -> L27
    L29:
        ws.mClient.dispatchDragEvent(event);     // Catch: RemoteException -> L27
    L33:
        if (WindowManagerService.MY_PID == ws.mSession.mPid) goto L15;
        event.recycle();
    L31:
        Slog.w("WindowManager", "Unable to drag-end window " + ws);
        goto L33
    L19:
        if (ws.mSession.mPid != this.mPid) goto L23;
        inWindowX = ws.translateToWindowX(this.mCurrentDisplayX);
        inWindowY = ws.translateToWindowY(this.mCurrentDisplayY);
        if (relinquishDragSurfaceToDragSource() == false) goto L23;
        includeDragSurface = true;
        goto L23
    L36:
        this.mNotifiedWindows.clear();
        this.mDragInProgress = false;
        Trace.instant(32, "DragDropController#DRAG_ENDED");
    L38:
        if (this.mInputSurface == null) goto L41;
        this.mTransaction.remove(this.mInputSurface).apply();
        this.mInputSurface = null;
    L41:
        if (this.mSurfaceControl == null) goto L50;
        if (this.mRelinquishDragSurfaceToDropTarget == false) goto L45;
    L47:
        this.mDragDropController.sendTimeoutMessage(3, this.mSurfaceControl, 5000);
    L48:
        this.mSurfaceControl = null;
        goto L50
    L45:
        if (relinquishDragSurfaceToDragSource() == true) goto L47;
        this.mTransaction.remove(this.mSurfaceControl).apply();
    L50:
        if (this.mAnimator != null) goto L52;
    L54:
        this.mFlags = 0;
        this.mLocalWin = null;
        this.mToken = null;
        this.mData = null;
        this.mThumbOffsetY = 0.0f;
        this.mThumbOffsetX = 0.0f;
        this.mNotifiedWindows = null;
        if (this.mUnhandledDropEvent == null) goto L57;
        this.mUnhandledDropEvent.recycle();
        this.mUnhandledDropEvent = null;
    L57:
        this.mDragDropController.onDragStateClosedLocked(this);
        return;
    L52:
        if (this.mAnimationCompleted == true) goto L54;
        Slog.wtf("WindowManager", "Unexpectedly destroying mSurfaceControl while animation is running");
        goto L54
    }

    private DragEvent createUnhandledDropEvent(float inDisplayX, float inDisplayY) {
        return obtainDragEvent(3, inDisplayX, inDisplayY, this.mDataDescription, this.mData, true, true, null);
    }

    private DragEvent createDropEvent(float inWindowX, float inWindowY, WindowState touchedWin) {
        int targetUserId = UserHandle.getUserId(touchedWin.getOwningUid());
        if ((this.mFlags & 256) != 0) goto L5;
    L9:
        IDragAndDropPermissions r8 = null;
    L11:
        if (this.mSourceUserId != targetUserId) goto L13;
    L15:
        boolean targetInterceptsGlobalDrag = targetInterceptsGlobalDrag(touchedWin);
        return obtainDragEvent(3, inWindowX, inWindowY, this.mDataDescription, this.mData, targetInterceptsGlobalDrag, targetInterceptsGlobalDrag, r8);
    L13:
        if (this.mData == null) goto L15;
        this.mData.fixUris(this.mSourceUserId);
        goto L15
    L5:
        if ((this.mFlags & 3) == 0) goto L9;
        if (this.mData == null) goto L9;
        r8 = new DragAndDropPermissionsHandler(this.mService.mGlobalLock, this.mData, this.mUid, touchedWin.getOwningPackage(), this.mFlags & 195, this.mSourceUserId, targetUserId);
        goto L11
    }

    boolean reportDropWindowLock(IBinder token, float inWindowX, float inWindowY) {
        if (this.mAnimator == null) goto L13;
        return false;
    L13:
        Trace.traceBegin(32, "DragDropController#DROP");     // Catch: Throwable -> L10
        boolean r2 = reportDropWindowLockInner(token, inWindowX, inWindowY);     // Catch: Throwable -> L10
        Trace.traceEnd(32);
        return r2;
    L10:
        th = move-exception;
        Trace.traceEnd(32);
        throw th;
    }

    private boolean reportDropWindowLockInner(IBinder token, float inWindowX, float inWindowY) {
        if (this.mAnimator == null) goto L5;
        return false;
    L5:
        WindowState touchedWin = this.mService.mInputToWindowMap.get(token);
        if (isWindowNotified(touchedWin) == true) goto L16;
        DragEvent unhandledDropEvent = createUnhandledDropEvent(inWindowX, inWindowY);
        if (this.mDragDropController.notifyUnhandledDrop(unhandledDropEvent, "unhandled-drop") == false) goto L10;
        return true;
    L10:
        Trace.traceBegin(32, "DragDropController#noWindow");
        endDragLocked(false, false);
        if (WindowManagerDebugConfig.DEBUG_DRAG == false) goto L13;
        Slog.d("WindowManager", "Drop outside a valid window " + touchedWin);
    L13:
        Trace.traceEnd(32);
        return false;
    L16:
        if (WindowManagerDebugConfig.DEBUG_DRAG == false) goto L18;
        Slog.d("WindowManager", "Sending DROP to " + touchedWin);
    L18:
        DragEvent unhandledDropEvent2 = createUnhandledDropEvent(touchedWin.getBounds().left + inWindowX, touchedWin.getBounds().top + inWindowY);
        IBinder clientToken = touchedWin.mClient.asBinder();
        DragEvent event = createDropEvent(inWindowX, inWindowY, touchedWin);
        Trace.traceBegin(32, "DragDropController#dispatchDrop");     // Catch: Throwable -> L25 RemoteException -> L27
        touchedWin.mClient.dispatchDragEvent(event);     // Catch: Throwable -> L25 RemoteException -> L27
        this.mDragDropController.sendTimeoutMessage(0, clientToken, 5000);     // Catch: Throwable -> L25 RemoteException -> L27
        goto L28
    L21:
        if (WindowManagerService.MY_PID == touchedWin.mSession.mPid) goto L23;
        event.recycle();
    L23:
        Trace.traceEnd(32);
        this.mToken = clientToken;
        this.mUnhandledDropEvent = unhandledDropEvent2;
        return true;
    L25:
        th = move-exception;
        if (WindowManagerService.MY_PID == touchedWin.mSession.mPid) goto L37;
        event.recycle();
    L37:
        Trace.traceEnd(32);
        throw th;
    L28:
        Slog.w("WindowManager", "can't send drop notification to win " + touchedWin);     // Catch: Throwable -> L25
        endDragLocked(false, false);     // Catch: Throwable -> L25
        if (WindowManagerService.MY_PID == touchedWin.mSession.mPid) goto L32;
        event.recycle();
    L32:
        Trace.traceEnd(32);
        return false;
    }

    InputWindowHandle getInputWindowHandle() {
        if (this.mInputInterceptor != null) goto L6;
        return null;
    L6:
        return this.mInputInterceptor.mDragWindowHandle;
    }

    IBinder getInputToken() {
        if (this.mInputInterceptor != null) goto L5;
        return null;
    L5:
        if (this.mInputInterceptor.mClientChannel != null) goto L8;
        return null;
    L8:
        return this.mInputInterceptor.mClientChannel.getToken();
    }

    CompletableFuture<Void> register(Display display) {
        display.getRealSize(this.mDisplaySize);
        if (WindowManagerDebugConfig.DEBUG_DRAG == false) goto L6;
        Slog.d("WindowManager", "Registering drag input channel");
    L6:
        if (this.mInputInterceptor == null) goto L9;
        Slog.e("WindowManager", "Duplicate register of drag input channel");
        return CompletableFuture.completedFuture(null);
    L9:
        this.mInputInterceptor = new InputInterceptor(this, display);
        return showInputSurface();
    }

    void broadcastDragStartedLocked(final float touchX, final float touchY) {
        Trace.instant(32, "DragDropController#DRAG_STARTED");
        this.mCurrentDisplayX = touchX;
        this.mStartDragDisplayX = touchX;
        this.mCurrentDisplayY = touchY;
        this.mStartDragDisplayY = touchY;
        if (this.mData == null) goto L5;
        ClipDescription r0 = this.mData.getDescription();
    L6:
        this.mDataDescription = r0;
        this.mNotifiedWindows.clear();
        this.mDragInProgress = true;
        this.mSourceUserId = UserHandle.getUserId(this.mUid);
        UserManagerInternal userManager = (UserManagerInternal) LocalServices.getService(UserManagerInternal.class);
        this.mCrossProfileCopyAllowed = true ^ userManager.getUserRestriction(this.mSourceUserId, "no_cross_profile_copy_paste");
        if (WindowManagerDebugConfig.DEBUG_DRAG == false) goto L9;
        Slog.d("WindowManager", "Broadcasting DRAG_STARTED at (" + touchX + ", " + touchY + ")");
    L9:
        final boolean containsAppExtras = containsApplicationExtras(this.mDataDescription);
        this.mService.mRoot.forAllWindows(new DragState$$ExternalSyntheticLambda0(this, touchX, touchY, containsAppExtras), false);
        return;
    L5:
        r0 = null;
        goto L6
    }

    private /* synthetic */ void lambda$broadcastDragStartedLocked$1(float touchX, float touchY, boolean containsAppExtras, WindowState w) {
        sendDragStartedLocked(w, touchX, touchY, containsAppExtras);
    }

    private void sendDragStartedLocked(WindowState newWin, float touchX, float touchY, boolean containsAppExtras) {
        boolean interceptsGlobalDrag = targetInterceptsGlobalDrag(newWin);
        if (this.mDragInProgress == false) goto L43;
        if (isValidDropTarget(newWin, containsAppExtras, interceptsGlobalDrag) == false) goto L50;
        if (WindowManagerDebugConfig.DEBUG_DRAG == false) goto L9;
        Slog.d("WindowManager", "Sending DRAG_STARTED to new window " + newWin);
    L9:
        ClipData data = null;
        if (interceptsGlobalDrag == true) goto L12;
    L20:
        ClipData data2 = data;
        if (data2 == null) goto L24;
        ClipDescription r0 = data2.getDescription();
    L23:
        ClipDescription description = r0;
        PointF relativeToWindowCoords = new PointF(newWin.translateToWindowX(touchX), newWin.translateToWindowY(touchY));
        DragEvent event = obtainDragEvent(1, relativeToWindowCoords.x, relativeToWindowCoords.y, description, data2, false, true, null);
        newWin.mClient.dispatchDragEvent(event);     // Catch: Throwable -> L30 RemoteException -> L32
        this.mNotifiedWindows.add(newWin);     // Catch: Throwable -> L30 RemoteException -> L32
        goto L33
    L28:
        if (WindowManagerService.MY_PID == newWin.mSession.mPid) goto L47;
    L29:
        event.recycle();
        return;
    L47:
        return;
    L30:
        th = move-exception;
        if (WindowManagerService.MY_PID == newWin.mSession.mPid) goto L40;
        event.recycle();
    L40:
        throw th;
    L33:
        Slog.w("WindowManager", "Unable to drag-start window " + newWin);     // Catch: Throwable -> L30
        if (WindowManagerService.MY_PID != newWin.mSession.mPid) goto L29;
        return;
    L24:
        r0 = this.mDataDescription;
        goto L23
    L12:
        if (this.mData == null) goto L20;
        data = this.mData.copyForTransferWithActivityInfo();
        if (data.getDescription().getExtras() == null) goto L16;
        PersistableBundle extras = data.getDescription().getExtras();
    L17:
        extras.putInt("android.intent.extra.HIDE_DRAG_SOURCE_TASK_ID", this.mCallingTaskIdToHide);
        data.getDescription().setExtras(extras);
        if (WindowManagerDebugConfig.DEBUG_DRAG == false) goto L20;
        Slog.d("WindowManager", "Adding EXTRA_HIDE_DRAG_SOURCE_TASK_ID=" + this.mCallingTaskIdToHide);
        goto L20
    L16:
        extras = new PersistableBundle();
        goto L17
    L50:
        return;
    }

    private boolean containsApplicationExtras(ClipDescription desc) {
        if (desc != null) goto L6;
        return false;
    L6:
        if (desc.hasMimeType("application/vnd.android.activity") == false) goto L8;
    L11:
        return true;
    L8:
        if (desc.hasMimeType("application/vnd.android.shortcut") == true) goto L11;
        if (desc.hasMimeType("application/vnd.android.task") == true) goto L11;
        return false;
    }

    private boolean isValidDropTarget(WindowState targetWin, boolean containsAppExtras, boolean interceptsGlobalDrag) {
        if (targetWin != null) goto L6;
        return false;
    L6:
        if (this.mLocalWin != targetWin.mClient.asBinder()) goto L8;
        boolean isLocalWindow = true;
    L9:
        if (isLocalWindow == true) goto L14;
        if (interceptsGlobalDrag == true) goto L14;
        if (containsAppExtras == false) goto L14;
        return false;
    L14:
        if (targetWin.isPotentialDragTarget(interceptsGlobalDrag) == true) goto L17;
        return false;
    L17:
        if ((this.mFlags & 4096) == 0) goto L19;
        boolean isGlobalSameAppDrag = true;
    L21:
        if ((this.mFlags & 256) == 0) goto L23;
        boolean isGlobalDrag = true;
    L24:
        if (isGlobalDrag == true) goto L28;
        if (isGlobalSameAppDrag == true) goto L28;
        boolean isAnyGlobalDrag = false;
    L29:
        if (isAnyGlobalDrag == true) goto L31;
    L32:
        if (isLocalWindow == true) goto L34;
        return false;
    L34:
        if (isGlobalSameAppDrag == false) goto L39;
        if (interceptsGlobalDrag == true) goto L39;
        if (this.mUid == targetWin.getUid()) goto L39;
        return false;
    L39:
        if (interceptsGlobalDrag == true) goto L45;
        if (this.mCrossProfileCopyAllowed == true) goto L45;
        if (this.mSourceUserId == UserHandle.getUserId(targetWin.getOwningUid())) goto L45;
        return false;
    L45:
        return true;
    L31:
        if (targetWindowSupportsGlobalDrag(targetWin) == true) goto L34;
    L28:
        isAnyGlobalDrag = true;
        goto L29
    L23:
        isGlobalDrag = false;
        goto L24
    L19:
        isGlobalSameAppDrag = false;
        goto L21
    L8:
        isLocalWindow = false;
        goto L9
    }

    private boolean targetWindowSupportsGlobalDrag(WindowState targetWin) {
        if (targetWin.mActivityRecord != null) goto L5;
    L8:
        return true;
    L5:
        if (targetWin.mActivityRecord.mTargetSdk >= 24) goto L8;
        return false;
    }

    public boolean targetInterceptsGlobalDrag(WindowState targetWin) {
        if (targetWin != null) goto L6;
        return false;
    L6:
        if ((targetWin.mAttrs.privateFlags & Integer.MIN_VALUE) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    void sendDragStartedIfNeededLocked(WindowState newWin) {
        if (this.mDragInProgress == true) goto L5;
        return;
    L5:
        if (isWindowNotified(newWin) == false) goto L7;
        return;
    L7:
        sendDragStartedLocked(newWin, this.mCurrentDisplayX, this.mCurrentDisplayY, containsApplicationExtras(this.mDataDescription));
    }

    boolean isWindowNotified(WindowState newWin) {
        Iterator<WindowState> r0 = this.mNotifiedWindows.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        WindowState ws = r0.next();
        if (ws != newWin) goto L4;
        return true;
    L10:
        return false;
    }

    void endDragLocked(boolean dropConsumed, boolean relinquishDragSurfaceToDropTarget) {
        this.mDragResult = dropConsumed;
        this.mRelinquishDragSurfaceToDropTarget = relinquishDragSurfaceToDropTarget;
        if (this.mAnimator == null) goto L6;
        return;
    L6:
        if (this.mDragResult == false) goto L8;
    L13:
        closeLocked();
        return;
    L8:
        if (isAccessibilityDragDrop() == true) goto L13;
        if (relinquishDragSurfaceToDragSource() == true) goto L13;
        this.mAnimator = createReturnAnimationLocked();
    }

    void cancelDragLocked(boolean skipAnimation) {
        if (this.mAnimator == null) goto L6;
        return;
    L6:
        if (this.mDragInProgress == false) goto L13;
        if (skipAnimation == true) goto L13;
        if (isAccessibilityDragDrop() == true) goto L13;
        this.mAnimator = createCancelAnimationLocked();
        return;
    L13:
        closeLocked();
    }

    void updateDragSurfaceLocked(boolean keepHandling, int displayId, float displayX, float displayY) {
        if (this.mAnimator == null) goto L5;
        return;
    L5:
        this.mCurrentDisplayX = displayX;
        this.mCurrentDisplayY = displayY;
        DisplayContent lastSetDisplayContent = this.mCurrentDisplayContent;
        if (keepHandling == true) goto L9;
        return;
    L9:
        if (WindowManagerDebugConfig.SHOW_LIGHT_TRANSACTIONS == false) goto L11;
        Slog.i("WindowManager", ">>> OPEN TRANSACTION notifyMoveLocked");
    L11:
        if (0 == 0) goto L17;
        this.mAnimatedScale = (this.mAnimatedScale * this.mCurrentDisplayContent.mBaseDisplayDensity) / lastSetDisplayContent.mBaseDisplayDensity;
        this.mThumbOffsetX = (this.mThumbOffsetX * this.mCurrentDisplayContent.mBaseDisplayDensity) / lastSetDisplayContent.mBaseDisplayDensity;
        this.mThumbOffsetY = (this.mThumbOffsetY * this.mCurrentDisplayContent.mBaseDisplayDensity) / lastSetDisplayContent.mBaseDisplayDensity;
        this.mTransaction.reparent(this.mSurfaceControl, this.mCurrentDisplayContent.getSurfaceControl());
        this.mTransaction.setScale(this.mSurfaceControl, this.mAnimatedScale, this.mAnimatedScale);
        InputWindowHandle inputWindowHandle = getInputWindowHandle();
        if (inputWindowHandle != null) goto L16;
        Slog.w("WindowManager", "Drag is in progress but there is no drag window handle.");
        return;
    L16:
        inputWindowHandle.displayId = displayId;
        this.mTransaction.setInputWindowInfo(this.mInputSurface, inputWindowHandle);
    L17:
        this.mTransaction.setPosition(this.mSurfaceControl, displayX - this.mThumbOffsetX, displayY - this.mThumbOffsetY).apply();
        if (ProtoLogImpl_798997914.Cache.WM_SHOW_TRANSACTIONS_enabled[2] == false) goto L21;
        String protoLogParam0 = String.valueOf(this.mSurfaceControl);
        long protoLogParam1 = displayId;
        long protoLogParam2 = (int) (displayX - this.mThumbOffsetX);
        long protoLogParam3 = (int) (displayY - this.mThumbOffsetY);
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_SHOW_TRANSACTIONS, -1868190388992724887L, 84, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1), Long.valueOf(protoLogParam2), Long.valueOf(protoLogParam3)});
        return;
    }

    private DragEvent obtainDragEndedEvent(float x, float y, boolean includeDragSurface) {
        return obtainDragEvent(4, x, y, null, null, includeDragSurface, true, null, this.mDragResult);
    }

    private DragEvent obtainDragEvent(int action, float x, float y, ClipDescription description, ClipData data, boolean includeDragSurface, boolean includeDragFlags, IDragAndDropPermissions dragAndDropPermissions) {
        return obtainDragEvent(action, x, y, description, data, includeDragSurface, includeDragFlags, dragAndDropPermissions, false);
    }

    private DragEvent obtainDragEvent(int action, float x, float y, ClipDescription description, ClipData data, boolean includeDragSurface, boolean includeDragFlags, IDragAndDropPermissions dragAndDropPermissions, boolean dragResult) {
        float r3 = this.mThumbOffsetX;
        float r4 = this.mThumbOffsetY;
        int r5 = this.mCurrentDisplayContent.getDisplayId();
        if (includeDragFlags == false) goto L6;
        int r0 = this.mFlags;
    L5:
        int r6 = r0;
        if (includeDragSurface == false) goto L10;
        SurfaceControl r1 = this.mSurfaceControl;
    L12:
        return DragEvent.obtain(action, x, y, r3, r4, r5, r6, null, description, data, r1, dragAndDropPermissions, dragResult);
    L10:
        r1 = null;
        goto L12
    L6:
        r0 = 0;
        goto L5
    }

    private ValueAnimator createReturnAnimationLocked() {
        if (this.mCallingTaskIdToHide == (-1)) goto L5;
        final ValueAnimator animator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(ANIMATED_PROPERTY_X, new float[]{this.mCurrentDisplayX, this.mCurrentDisplayX}), PropertyValuesHolder.ofFloat(ANIMATED_PROPERTY_Y, new float[]{this.mCurrentDisplayY, this.mCurrentDisplayY}), PropertyValuesHolder.ofFloat(ANIMATED_PROPERTY_SCALE, new float[]{this.mAnimatedScale, this.mAnimatedScale}), PropertyValuesHolder.ofFloat(ANIMATED_PROPERTY_ALPHA, new float[]{this.mStartDragAlpha, 0.0f})});
        long duration = MIN_ANIMATION_DURATION_MS;
    L6:
        AnimationListener listener = new AnimationListener(this, null);
        animator.setDuration(duration);
        animator.setInterpolator(this.mCubicEaseOutInterpolator);
        animator.addListener(listener);
        animator.addUpdateListener(listener);
        this.mService.mAnimationHandler.post(new DragState$$ExternalSyntheticLambda2(animator));
        return animator;
    L5:
        animator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(ANIMATED_PROPERTY_X, new float[]{this.mCurrentDisplayX - this.mThumbOffsetX, this.mStartDragDisplayX - this.mThumbOffsetX}), PropertyValuesHolder.ofFloat(ANIMATED_PROPERTY_Y, new float[]{this.mCurrentDisplayY - this.mThumbOffsetY, this.mStartDragDisplayY - this.mThumbOffsetY}), PropertyValuesHolder.ofFloat(ANIMATED_PROPERTY_SCALE, new float[]{this.mAnimatedScale, this.mAnimatedScale}), PropertyValuesHolder.ofFloat(ANIMATED_PROPERTY_ALPHA, new float[]{this.mStartDragAlpha, this.mStartDragAlpha / 2.0f})});
        float translateX = this.mStartDragDisplayX - this.mCurrentDisplayX;
        float translateY = this.mStartDragDisplayY - this.mCurrentDisplayY;
        double travelDistance = Math.sqrt((translateX * translateX) + (translateY * translateY));
        double displayDiagonal = Math.sqrt((this.mDisplaySize.x * this.mDisplaySize.x) + (this.mDisplaySize.y * this.mDisplaySize.y));
        duration = ((long) ((travelDistance / displayDiagonal) * 180.0d)) + MIN_ANIMATION_DURATION_MS;
        goto L6
    }

    private static /* synthetic */ void lambda$createReturnAnimationLocked$2(ValueAnimator animator) {
        animator.start();
    }

    private ValueAnimator createCancelAnimationLocked() {
        if (this.mCallingTaskIdToHide == (-1)) goto L5;
        final ValueAnimator animator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(ANIMATED_PROPERTY_X, new float[]{this.mCurrentDisplayX, this.mCurrentDisplayX}), PropertyValuesHolder.ofFloat(ANIMATED_PROPERTY_Y, new float[]{this.mCurrentDisplayY, this.mCurrentDisplayY}), PropertyValuesHolder.ofFloat(ANIMATED_PROPERTY_SCALE, new float[]{this.mAnimatedScale, this.mAnimatedScale}), PropertyValuesHolder.ofFloat(ANIMATED_PROPERTY_ALPHA, new float[]{this.mStartDragAlpha, 0.0f})});
    L6:
        AnimationListener listener = new AnimationListener(this, null);
        animator.setDuration(MIN_ANIMATION_DURATION_MS);
        animator.setInterpolator(this.mCubicEaseOutInterpolator);
        animator.addListener(listener);
        animator.addUpdateListener(listener);
        this.mService.mAnimationHandler.post(new DragState$$ExternalSyntheticLambda3(animator));
        return animator;
    L5:
        animator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(ANIMATED_PROPERTY_X, new float[]{this.mCurrentDisplayX - this.mThumbOffsetX, this.mCurrentDisplayX}), PropertyValuesHolder.ofFloat(ANIMATED_PROPERTY_Y, new float[]{this.mCurrentDisplayY - this.mThumbOffsetY, this.mCurrentDisplayY}), PropertyValuesHolder.ofFloat(ANIMATED_PROPERTY_SCALE, new float[]{this.mAnimatedScale, 0.0f}), PropertyValuesHolder.ofFloat(ANIMATED_PROPERTY_ALPHA, new float[]{this.mStartDragAlpha, 0.0f})});
        goto L6
    }

    private static /* synthetic */ void lambda$createCancelAnimationLocked$3(ValueAnimator animator) {
        animator.start();
    }

    boolean isAccessibilityDragDrop() {
        if ((this.mFlags & 1024) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean relinquishDragSurfaceToDragSource() {
        if ((this.mFlags & 2048) == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
