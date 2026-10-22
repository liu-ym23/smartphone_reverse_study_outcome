package com.android.server.wm;

import android.content.ClipData;
import android.hardware.display.DisplayTopology;
import android.hardware.input.InputManagerGlobal;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.Trace;
import android.util.Slog;
import android.view.DragEvent;
import android.view.IWindow;
import android.view.PointerIcon;
import android.view.SurfaceControl;
import android.view.accessibility.AccessibilityManager;
import android.window.IGlobalDragListener;
import com.android.server.usb.descriptors.UsbACInterface;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
class DragDropController {
    private static final int A11Y_DRAG_TIMEOUT_DEFAULT_MS = 60000;
    private static final float DRAG_SHADOW_ALPHA_TRANSPARENT = 0.7071f;
    static final long DRAG_TIMEOUT_MS = 5000;
    static final int MSG_ANIMATION_END = 2;
    static final int MSG_DRAG_END_TIMEOUT = 0;
    static final int MSG_REMOVE_DRAG_SURFACE_TIMEOUT = 3;
    static final int MSG_TEAR_DOWN_DRAG_AND_DROP_INPUT = 1;
    static final int MSG_UNHANDLED_DROP_LISTENER_TIMEOUT = 4;
    private AtomicReference<WindowManagerInternal.IDragDropCallback> mCallback;
    private final Consumer<DisplayTopology> mDisplayTopologyListener;
    private DragState mDragState;
    private IGlobalDragListener mGlobalDragListener;
    private final IBinder.DeathRecipient mGlobalDragListenerDeathRecipient;
    private final Handler mHandler;
    private WindowManagerService mService;

    private class DragHandler extends Handler {
        private final WindowManagerService mService;
        final /* synthetic */ DragDropController this$0;

        DragHandler(DragDropController r1, WindowManagerService service, Looper looper) {
            this.this$0 = r1;
            super(looper);
            this.mService = service;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 0: goto L54;
                case 1: goto L40;
                case 2: goto L23;
                case 3: goto L14;
                case 4: goto L5;
                default: goto L83;
            };
        L5:
            WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            this.this$0.onUnhandledDropCallback(false);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L14:
            WindowManagerGlobalLock r1 = this.mService.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r1);
            this.mService.mTransactionFactory.get().remove((SurfaceControl) msg.obj).apply();     // Catch: Throwable -> L19
            monitor-exit(r1);     // Catch: Throwable -> L19
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L19:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L23:
            WindowManagerGlobalLock r2 = this.mService.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r2);
        L31:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L26:
            if (DragDropController.m9985$$Nest$fgetmDragState(this.this$0) != null) goto L33;
            Slog.wtf("WindowManager", "mDragState unexpectedly became null while playing animation");     // Catch: Throwable -> L31
            monitor-exit(r2);     // Catch: Throwable -> L31
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L33:
            DragDropController.m9985$$Nest$fgetmDragState(this.this$0).closeLocked();     // Catch: Throwable -> L31
            monitor-exit(r2);     // Catch: Throwable -> L31
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L54:
            IBinder win = (IBinder) msg.obj;
            if (WindowManagerDebugConfig.DEBUG_DRAG == false) goto L57;
            Slog.w("WindowManager", "Timeout ending drag to win " + win);
        L57:
            WindowManagerGlobalLock r3 = this.mService.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r3);
        L62:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L60:
            if (DragDropController.m9985$$Nest$fgetmDragState(this.this$0) == null) goto L64;
            DragDropController.m9985$$Nest$fgetmDragState(this.this$0).endDragLocked(false, false);     // Catch: Throwable -> L62
        L64:
            monitor-exit(r3);     // Catch: Throwable -> L62
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L83:
            return;
        L40:
            if (WindowManagerDebugConfig.DEBUG_DRAG == false) goto L42;
            Slog.d("WindowManager", "Drag ending; tearing down input channel");
        L42:
            DragState.InputInterceptor interceptor = (DragState.InputInterceptor) msg.obj;
            if (interceptor != null) goto L45;
            return;
        L45:
            WindowManagerGlobalLock r4 = this.mService.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r4);
            interceptor.tearDown();     // Catch: Throwable -> L50
            monitor-exit(r4);     // Catch: Throwable -> L50
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L50:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDragState, reason: not valid java name */
    static /* bridge */ /* synthetic */ DragState m9985$$Nest$fgetmDragState(DragDropController r0) {
        return r0.mDragState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerService m9986$$Nest$fgetmService(DragDropController r0) {
        return r0.mService;
    }

    DragDropController(WindowManagerService service, Looper looper) {
        this.mDisplayTopologyListener = new DragDropController$$ExternalSyntheticLambda0(this);
        this.mGlobalDragListenerDeathRecipient = new AnonymousClass1(this);
        this.mCallback = new AtomicReference(new AnonymousClass2(this));
        this.mService = service;
        this.mHandler = new DragHandler(this, service, looper);
    }

    Handler getHandler() {
        return this.mHandler;
    }

    boolean dragDropActiveLocked() {
        if (this.mDragState != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mDragState.isClosing() == true) goto L7;
        return true;
    }

    boolean dragSurfaceRelinquishedToDropTarget() {
        if (this.mDragState != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mDragState.mRelinquishDragSurfaceToDropTarget == false) goto L7;
        return true;
    }

    void registerCallback(WindowManagerInternal.IDragDropCallback callback) {
        callback.getClass();
        this.mCallback.set(callback);
    }

    public void setGlobalDragListener(IGlobalDragListener listener) {
        if (this.mGlobalDragListener != null) goto L5;
    L7:
        this.mGlobalDragListener = listener;
        if (listener != null) goto L10;
        return;
    L10:
        if (listener.asBinder() == null) goto L19;
        this.mGlobalDragListener.asBinder().linkToDeath(this.mGlobalDragListenerDeathRecipient, 0);     // Catch: RemoteException -> L13
        return;
    L14:
        this.mGlobalDragListener = null;
        return;
    L19:
        return;
    L5:
        if (this.mGlobalDragListener.asBinder() == null) goto L7;
        this.mGlobalDragListener.asBinder().unlinkToDeath(this.mGlobalDragListenerDeathRecipient, 0);
        goto L7
    }

    void sendDragStartedIfNeededLocked(WindowState window) {
        this.mDragState.sendDragStartedIfNeededLocked(window);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v111, types: [android.view.SurfaceControl$Transaction] */
    /* JADX WARN: Type inference failed for: r0v121, types: [android.view.SurfaceControl$Transaction] */
    /* JADX WARN: Type inference failed for: r0v131, types: [android.view.SurfaceControl$Transaction] */
    /* JADX WARN: Type inference failed for: r0v24, types: [android.view.SurfaceControl$Transaction] */
    /* JADX WARN: Type inference failed for: r12v0, types: [android.view.SurfaceControl, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v25 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.view.SurfaceControl] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r3v26, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26, types: [com.android.server.wm.WindowManagerGlobalLock] */
    /* JADX WARN: Type inference failed for: r4v6, types: [android.view.SurfaceControl$Transaction] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9, types: [android.view.SurfaceControl] */
    IBinder performDrag(int r28, int r29, IWindow r30, int r31, SurfaceControl r32, int r33, int r34, int r35, float r36, float r37, float r38, float r39, ClipData r40) {
        WindowManagerGlobalLock r12 = r32;
        if (WindowManagerDebugConfig.DEBUG_DRAG == false) goto L5;
        Slog.d("WindowManager", "perform drag: win=" + r30 + " surface=" + r12 + " flags=0x" + Integer.toHexString(r31) + " data=" + r40 + " touch(" + r36 + "," + r37 + ") thumb center(" + r38 + "," + r39 + ")");
    L5:
        Binder r5 = new Binder();
        boolean r13 = this.mCallback.get().prePerformDrag(r30, r5, r33, r36, r37, r38, r39, r40);
        r12 = this.mService.mGlobalLock;     // Catch: Throwable -> L238
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L238
        monitor-enter(r12);     // Catch: Throwable -> L238
        if (r13 == true) goto L264;
        Slog.w("WindowManager", "IDragDropCallback rejects the performDrag request");     // Catch: Throwable -> L31
        if (r12 == 0) goto L28;
        SurfaceControl.Transaction r0 = this.mService.mTransactionFactory.get();     // Catch: Throwable -> L17
        r0.remove(r12);     // Catch: Throwable -> L19
        r0.apply();     // Catch: Throwable -> L19
        r0.close();     // Catch: Throwable -> L17
        goto L28
    L19:
        th = move-exception;
        if (r0 == 0) goto L301;
        r0.close();     // Catch: Throwable -> L24
    L304:
        throw th;     // Catch: Throwable -> L17
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L301:
        throw th;     // Catch: Throwable -> L17
    L28:
        monitor-exit(r12);     // Catch: Throwable -> L17
        WindowManagerService.resetPriorityAfterLockedSection();
        this.mCallback.get().postPerformDrag();
        return null;
    L264:
    L191:
        th = th;
        r12 = r12;
        ?? r1 = r12;
    L217:
        if (r1 == 0) goto L234;
        SurfaceControl.Transaction r4 = this.mService.mTransactionFactory.get();     // Catch: Throwable -> L222
        r4.remove(r1);     // Catch: Throwable -> L224
        r4.apply();     // Catch: Throwable -> L224
        r4.close();     // Catch: Throwable -> L222
        goto L234
    L224:
        th = move-exception;
        if (r4 == 0) goto L314;
        r4.close();     // Catch: Throwable -> L229
    L315:
        throw th;     // Catch: Throwable -> L222
    L229:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L222
        throw th;     // Catch: Throwable -> L222
    L314:
        throw th;     // Catch: Throwable -> L222
    L234:
        throw th;     // Catch: Throwable -> L222
    L34:
        if (dragDropActiveLocked() == false) goto L52;
        Slog.w("WindowManager", "Drag already in progress");     // Catch: Throwable -> L31
        if (r12 == 0) goto L49;
        SurfaceControl.Transaction r2 = this.mService.mTransactionFactory.get();     // Catch: Throwable -> L17
        r2.remove(r12);     // Catch: Throwable -> L42
        r2.apply();     // Catch: Throwable -> L42
        r2.close();     // Catch: Throwable -> L17
        goto L49
    L42:
        th = move-exception;
        if (r2 == 0) goto L302;
        r2.close();     // Catch: Throwable -> L47
    L305:
        throw th;     // Catch: Throwable -> L17
    L47:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L302:
        throw th;     // Catch: Throwable -> L17
    L49:
        monitor-exit(r12);     // Catch: Throwable -> L17
        WindowManagerService.resetPriorityAfterLockedSection();
        this.mCallback.get().postPerformDrag();
        return null;
    L52:
        WindowState r3 = this.mService.windowForClientLocked(null, r30, false);     // Catch: Throwable -> L191
        if (r3 != null) goto L55;
        ?? r6 = r12;
    L244:
        Slog.w("WindowManager", "Bad requesting window " + r30);     // Catch: Throwable -> L215
        if (r6 != 0) goto L272;
    L212:
        monitor-exit(r12);     // Catch: Throwable -> L201
        WindowManagerService.resetPriorityAfterLockedSection();
        this.mCallback.get().postPerformDrag();
        return 0;
    L272:
        SurfaceControl.Transaction r7 = this.mService.mTransactionFactory.get();     // Catch: Throwable -> L201
        r7.remove(r6);     // Catch: Throwable -> L203
        r7.apply();     // Catch: Throwable -> L203
        r7.close();     // Catch: Throwable -> L201
        goto L212
    L203:
        th = move-exception;
        if (r7 == 0) goto L312;
        r7.close();     // Catch: Throwable -> L208
    L313:
        throw th;     // Catch: Throwable -> L201
    L208:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L201
        throw th;     // Catch: Throwable -> L201
    L312:
        throw th;     // Catch: Throwable -> L201
    L201:
        th = th;
    L235:
        monitor-exit(r12);     // Catch: Throwable -> L222
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L154
        throw th;     // Catch: Throwable -> L154
    L215:
        th = th;
        r1 = r6;
        r12 = r12;
        goto L217
    L55:
        if (r3.canReceiveTouchInput() == true) goto L57;
        r6 = r12;
        goto L244
    L57:
        DisplayContent r8 = r3.getDisplayContent();     // Catch: Throwable -> L191
        if (r8 != null) goto L80;
        Slog.w("WindowManager", "display content is null");     // Catch: Throwable -> L31
        if (r12 == 0) goto L76;
        SurfaceControl.Transaction r9 = this.mService.mTransactionFactory.get();     // Catch: Throwable -> L17
        r9.remove(r12);     // Catch: Throwable -> L67
        r9.apply();     // Catch: Throwable -> L67
        r9.close();     // Catch: Throwable -> L17
        goto L76
    L67:
        th = move-exception;
        if (r9 == 0) goto L306;
        r9.close();     // Catch: Throwable -> L72
    L307:
        throw th;     // Catch: Throwable -> L17
    L72:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L306:
        throw th;     // Catch: Throwable -> L17
    L76:
        monitor-exit(r12);     // Catch: Throwable -> L17
        WindowManagerService.resetPriorityAfterLockedSection();
        this.mCallback.get().postPerformDrag();
        return null;
    L80:
        if ((r31 & 512) != 0) goto L82;
        float r10 = DRAG_SHADOW_ALPHA_TRANSPARENT;
    L83:
        float r18 = r10;
        IBinder r11 = r30.asBinder();     // Catch: Throwable -> L189
        r12 = r12;
        this.mDragState = new DragState(this.mService, this, new Binder(), r12, r31, r11);     // Catch: Throwable -> L187
        r1 = 0;
        r1 = 0;
        this.mDragState.mPid = r28;     // Catch: Throwable -> L91
        this.mDragState.mUid = r29;     // Catch: Throwable -> L91
        this.mDragState.mStartDragAlpha = r18;     // Catch: Throwable -> L91
        this.mDragState.mAnimatedScale = r3.mGlobalScale;     // Catch: Throwable -> L91
        this.mDragState.mToken = r5;     // Catch: Throwable -> L91
        this.mDragState.mStartDragDisplayContent = r8;     // Catch: Throwable -> L91
        this.mDragState.mCurrentDisplayContent = r8;     // Catch: Throwable -> L91
        this.mDragState.mData = r40;     // Catch: Throwable -> L91
        this.mDragState.mCallingTaskIdToHide = shouldMoveCallingTaskToBack(r3, r31);     // Catch: Throwable -> L91
        if (WindowManagerDebugConfig.DEBUG_DRAG == false) goto L95;
        Slog.d("WindowManager", "Calling task to hide=" + this.mDragState.mCallingTaskIdToHide);     // Catch: Throwable -> L91
    L95:
        if ((r31 & 1024) != 0) goto L246;
        CompletableFuture<Boolean> r14 = this.mCallback.get().registerInputChannel(this.mDragState, r8.getDisplay(), this.mService.mInputManager, r3.mInputChannelToken);     // Catch: Throwable -> L91
        if (0 != 0) goto L292;
    L114:
        monitor-exit(r12);     // Catch: Throwable -> L103
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L119
        boolean r15 = false;
        r15 = r14.get(DRAG_TIMEOUT_MS, TimeUnit.MILLISECONDS).booleanValue();     // Catch: Throwable -> L119 Exception -> L121
    L123:
        WindowManagerGlobalLock r16 = this.mService.mGlobalLock;     // Catch: Throwable -> L119
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L119
        monitor-enter(r16);     // Catch: Throwable -> L119
        if (r15 == true) goto L274;
        Slog.e("WindowManager", "Unable to transfer touch focus");     // Catch: Throwable -> L130
        this.mDragState.closeLocked();     // Catch: Throwable -> L130
        monitor-exit(r16);     // Catch: Throwable -> L130
        WindowManagerService.resetPriorityAfterLockedSection();
        this.mCallback.get().postPerformDrag();
        return null;
    L130:
        th = th;
    L160:
        monitor-exit(r16);     // Catch: Throwable -> L148
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L154
        throw th;     // Catch: Throwable -> L154
    L274:
        SurfaceControl r17 = this.mDragState.mSurfaceControl;     // Catch: Throwable -> L158
        this.mDragState.broadcastDragStartedLocked(r36, r37);     // Catch: Throwable -> L158
        if ((r33 & UsbACInterface.FORMAT_III_IEC1937_MPEG1_Layer1) != 8194) goto L270;
        InputManagerGlobal.getInstance().setPointerIcon(PointerIcon.getSystemIcon(this.mService.mContext, 1021), this.mDragState.mCurrentDisplayContent.getDisplayId(), r34, r35, this.mDragState.getInputToken());     // Catch: Throwable -> L138
    L138:
        th = th;
    L270:
        this.mDragState.mThumbOffsetX = r38;     // Catch: Throwable -> L156
        this.mDragState.mThumbOffsetY = r39;     // Catch: Throwable -> L156
        if (WindowManagerDebugConfig.SHOW_LIGHT_TRANSACTIONS == false) goto L143;
        Slog.i("WindowManager", ">>> OPEN TRANSACTION performDrag");     // Catch: Throwable -> L138
    L143:
        SurfaceControl.Transaction r19 = this.mDragState.mTransaction;     // Catch: Throwable -> L156
        r19.setAlpha(r17, this.mDragState.mStartDragAlpha);     // Catch: Throwable -> L156
        r19.show(r17);     // Catch: Throwable -> L156
        r8.reparentToOverlay(r19, r17);     // Catch: Throwable -> L156
        this.mDragState.updateDragSurfaceLocked(true, r8.getDisplayId(), r36, r37);     // Catch: Throwable -> L148
        if (WindowManagerDebugConfig.SHOW_LIGHT_TRANSACTIONS == false) goto L150;
        Slog.i("WindowManager", "<<< CLOSE TRANSACTION performDrag");     // Catch: Throwable -> L148
    L150:
        monitor-exit(r16);     // Catch: Throwable -> L148
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L154
        this.mCallback.get().postPerformDrag();
        return r5;
    L156:
        th = th;
    L158:
        th = th;
    L148:
        th = th;
        goto L160
    L121:
        e = move-exception;
        Slog.e("WindowManager", "Exception thrown while waiting for touch focus transfer", e);     // Catch: Throwable -> L119
    L119:
        th = th;
    L240:
        this.mCallback.get().postPerformDrag();
        throw th;
    L292:
        SurfaceControl.Transaction r20 = this.mService.mTransactionFactory.get();     // Catch: Throwable -> L103
        r20.remove(null);     // Catch: Throwable -> L105
        r20.apply();     // Catch: Throwable -> L105
        r20.close();     // Catch: Throwable -> L103
        goto L114
    L105:
        th = move-exception;
        if (r20 == null) goto L308;
        r20.close();     // Catch: Throwable -> L110
    L309:
        throw th;     // Catch: Throwable -> L103
    L110:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L103
        throw th;     // Catch: Throwable -> L103
    L308:
        throw th;     // Catch: Throwable -> L103
    L103:
        th = th;
        goto L235
    L246:
        this.mDragState.broadcastDragStartedLocked(r36, r37);     // Catch: Throwable -> L185
        sendTimeoutMessage(0, r3.mClient.asBinder(), getAccessibilityManager().getRecommendedTimeoutMillis(60000, 4));     // Catch: Throwable -> L185
        if (0 != 0) goto L273;
    L182:
        monitor-exit(r12);     // Catch: Throwable -> L171
        WindowManagerService.resetPriorityAfterLockedSection();
        this.mCallback.get().postPerformDrag();
        return r5;
    L273:
        SurfaceControl.Transaction r21 = this.mService.mTransactionFactory.get();     // Catch: Throwable -> L171
        r21.remove(null);     // Catch: Throwable -> L173
        r21.apply();     // Catch: Throwable -> L173
        r21.close();     // Catch: Throwable -> L171
        goto L182
    L173:
        th = move-exception;
        if (r21 == null) goto L310;
        r21.close();     // Catch: Throwable -> L178
    L311:
        throw th;     // Catch: Throwable -> L171
    L178:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L171
        throw th;     // Catch: Throwable -> L171
    L310:
        throw th;     // Catch: Throwable -> L171
    L171:
        th = th;
    L185:
        th = th;
        r12 = r12;
    L91:
        th = th;
        r12 = r12;
    L187:
        th = th;
        r1 = r12;
        r12 = r12;
    L189:
        th = th;
        r12 = r12;
        r1 = r12;
        goto L217
    L82:
        r10 = 1.0f;
    L17:
        th = th;
        r12 = r12;
    L154:
        th = th;
    L222:
        th = th;
    L31:
        th = th;
        r1 = r12;
        r12 = r12;
    L238:
        th = th;
        goto L240
    }

    void reportDropResult(IWindow window, boolean consumed) {
        IBinder token = window.asBinder();
        if (WindowManagerDebugConfig.DEBUG_DRAG == false) goto L5;
        Slog.d("WindowManager", "Drop result=" + consumed + " reported by " + token);
    L5:
        this.mCallback.get().preReportDropResult(window, consumed);
        WindowManagerGlobalLock r1 = this.mService.mGlobalLock;     // Catch: Throwable -> L52
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L52
        monitor-enter(r1);     // Catch: Throwable -> L52
    L14:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L52
        throw th;     // Catch: Throwable -> L52
    L9:
        if (this.mDragState != null) goto L17;
        Slog.w("WindowManager", "Drop result given but no drag in progress");     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();
        this.mCallback.get().postReportDropResult();
        return;
    L17:
        if (this.mDragState.mToken != token) goto L54;
        boolean isCrossWindowDrag = false;
        this.mHandler.removeMessages(0, window.asBinder());     // Catch: Throwable -> L14
        WindowState callingWin = this.mService.windowForClientLocked(null, window, false);     // Catch: Throwable -> L14
        if (callingWin != null) goto L24;
        Slog.w("WindowManager", "Bad result-reporting window " + window);     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();
        this.mCallback.get().postReportDropResult();
        return;
    L24:
        if (consumed == true) goto L31;
        if (notifyUnhandledDrop(this.mDragState.mUnhandledDropEvent, "window-drop") == false) goto L31;
        monitor-exit(r1);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();
        this.mCallback.get().postReportDropResult();
        return;
    L31:
        if (consumed == true) goto L33;
    L35:
        boolean relinquishDragSurfaceToDropTarget = false;
    L37:
        if (this.mDragState.mLocalWin.equals(token) == true) goto L39;
        isCrossWindowDrag = true;
    L39:
        this.mDragState.endDragLocked(consumed, relinquishDragSurfaceToDropTarget);     // Catch: Throwable -> L14
        Task droppedWindowTask = callingWin.getTask();     // Catch: Throwable -> L14
        if (this.mGlobalDragListener == null) goto L48;
        if (droppedWindowTask == null) goto L48;
        if (consumed == false) goto L48;
        if (isCrossWindowDrag == false) goto L48;
        this.mGlobalDragListener.onCrossWindowDrop(droppedWindowTask.getTaskInfo());     // Catch: Throwable -> L14 RemoteException -> L46
    L46:
        e = move-exception;
        Slog.e("WindowManager", "Failed to call global drag listener for cross-window drop", e);     // Catch: Throwable -> L14
    L48:
        monitor-exit(r1);     // Catch: Throwable -> L14
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L52
        this.mCallback.get().postReportDropResult();
        return;
    L33:
        if (this.mDragState.targetInterceptsGlobalDrag(callingWin) == false) goto L35;
        relinquishDragSurfaceToDropTarget = true;
        goto L37
    L54:
        Slog.w("WindowManager", "Invalid drop-result claim by " + window);     // Catch: Throwable -> L14
        throw new IllegalStateException("reportDropResult() by non-recipient");     // Catch: Throwable -> L14
    L52:
        th = move-exception;
        this.mCallback.get().postReportDropResult();
        throw th;
    }

    private int shouldMoveCallingTaskToBack(WindowState callingWin, int flags) {
        if ((flags & 16384) != 0) goto L5;
        return -1;
    L5:
        ActivityRecord callingActivity = callingWin.getActivityRecord();
        if (callingActivity != null) goto L8;
    L12:
        return -1;
    L8:
        if (callingActivity.getTask() == null) goto L12;
        return callingActivity.getTask().mTaskId;
    }

    boolean notifyUnhandledDrop(DragEvent dropEvent, String reason) {
        if ((this.mDragState.mFlags & 4352) != 0) goto L5;
        boolean isLocalDrag = true;
    L7:
        if ((this.mDragState.mFlags & 8192) == 0) goto L9;
        boolean shouldDelegateUnhandledDrag = true;
    L11:
        if (this.mGlobalDragListener == null) goto L25;
        if (shouldDelegateUnhandledDrag == false) goto L25;
        if (isLocalDrag == true) goto L25;
        final int traceCookie = new Random().nextInt();
        Trace.asyncTraceBegin(32, "DragDropController#notifyUnhandledDrop", traceCookie);
        if (WindowManagerDebugConfig.DEBUG_DRAG == false) goto L28;
        Slog.d("WindowManager", "Sending DROP to unhandled listener (" + reason + ")");
    L28:
        sendTimeoutMessage(4, null, DRAG_TIMEOUT_MS);     // Catch: RemoteException -> L21
        this.mGlobalDragListener.onUnhandledDrop(dropEvent, new AnonymousClass3(this, traceCookie));     // Catch: RemoteException -> L21
        return true;
    L21:
        e = move-exception;
        Slog.e("WindowManager", "Failed to call global drag listener for unhandled drop", e);
        return false;
    L25:
        if (WindowManagerDebugConfig.DEBUG_DRAG == false) goto L27;
        Slog.d("WindowManager", "Skipping unhandled listener (listener=" + this.mGlobalDragListener + ", flags=" + this.mDragState.mFlags + ")");
    L27:
        return false;
    L9:
        shouldDelegateUnhandledDrag = false;
        goto L11
    L5:
        isLocalDrag = false;
        goto L7
    }

    void onUnhandledDropCallback(boolean consumedByListener) {
        this.mHandler.removeMessages(4, null);
        this.mDragState.mDragResult = consumedByListener;
        this.mDragState.mRelinquishDragSurfaceToDropTarget = consumedByListener;
        this.mDragState.closeLocked();
    }

    boolean hasPendingUnhandledDropCallback() {
        return this.mHandler.hasMessages(4);
    }

    void cancelDragAndDrop(IBinder dragToken, boolean skipAnimation) {
        if (WindowManagerDebugConfig.DEBUG_DRAG == false) goto L5;
        Slog.d("WindowManager", "cancelDragAndDrop");
    L5:
        this.mCallback.get().preCancelDragAndDrop(dragToken);
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;     // Catch: Throwable -> L17
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L17
        monitor-enter(r0);     // Catch: Throwable -> L17
    L19:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L9:
        if (this.mDragState != null) goto L11;
        Slog.w("WindowManager", "cancelDragAndDrop() without prepareDrag()");     // Catch: Throwable -> L19
        throw new IllegalStateException("cancelDragAndDrop() without prepareDrag()");     // Catch: Throwable -> L19
    L11:
        if (this.mDragState.mToken != dragToken) goto L21;
        this.mDragState.mDragResult = false;     // Catch: Throwable -> L19
        this.mDragState.cancelDragLocked(skipAnimation);     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L17
        this.mCallback.get().postCancelDragAndDrop();
        return;
    L21:
        Slog.w("WindowManager", "cancelDragAndDrop() does not match prepareDrag()");     // Catch: Throwable -> L19
        throw new IllegalStateException("cancelDragAndDrop() does not match prepareDrag()");     // Catch: Throwable -> L19
    L17:
        th = move-exception;
        this.mCallback.get().postCancelDragAndDrop();
        throw th;
    }

    void handleDisplayTopologyChange(DisplayTopology unused) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mDragState != null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        if (WindowManagerDebugConfig.DEBUG_DRAG == false) goto L14;
        Slog.d("WindowManager", "DisplayTopology changed, cancelling DragAndDrop");     // Catch: Throwable -> L9
    L14:
        cancelDragAndDrop(this.mDragState.mToken, true);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
    }

    void handleMotionEvent(boolean keepHandling, int displayId, float newX, float newY) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (dragDropActiveLocked() == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L11:
        this.mDragState.updateDragSurfaceLocked(keepHandling, displayId, newX, newY);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
    }

    void dragRecipientEntered(IWindow window) {
        if (WindowManagerDebugConfig.DEBUG_DRAG == false) goto L5;
        Slog.d("WindowManager", "Drag into new candidate view @ " + window.asBinder());
    L5:
        this.mCallback.get().dragRecipientEntered(window);
    }

    void dragRecipientExited(IWindow window) {
        if (WindowManagerDebugConfig.DEBUG_DRAG == false) goto L5;
        Slog.d("WindowManager", "Drag from old candidate view @ " + window.asBinder());
    L5:
        this.mCallback.get().dragRecipientExited(window);
    }

    void sendHandlerMessage(int what, Object arg) {
        this.mHandler.obtainMessage(what, arg).sendToTarget();
    }

    void sendTimeoutMessage(int what, Object arg, long timeoutMs) {
        this.mHandler.removeMessages(what, arg);
        Message msg = this.mHandler.obtainMessage(what, arg);
        this.mHandler.sendMessageDelayed(msg, timeoutMs);
    }

    void onDragStateClosedLocked(DragState dragState) {
        if (this.mDragState == dragState) goto L6;
        Slog.wtf("WindowManager", "Unknown drag state is closed");
        return;
    L6:
        this.mDragState = null;
    }

    void reportDropWindow(IBinder token, float x, float y) {
        if (this.mDragState != null) goto L6;
        Slog.w("WindowManager", "Drag state is closed.");
        return;
    L6:
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mDragState.reportDropWindowLock(token, x, y);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L12:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    boolean dropForAccessibility(IWindow window, float x, float y) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        boolean isA11yEnabled = getAccessibilityManager().isEnabled();     // Catch: Throwable -> L9
        if (dragDropActiveLocked() == true) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L12:
        if (this.mDragState.isAccessibilityDragDrop() == false) goto L23;
        if (isA11yEnabled == false) goto L23;
        WindowState winState = this.mService.windowForClientLocked(null, window, false);     // Catch: Throwable -> L9
        if (this.mDragState.isWindowNotified(winState) == true) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L19:
        IBinder token = winState.mInputChannelToken;     // Catch: Throwable -> L9
        boolean r4 = this.mDragState.reportDropWindowLock(token, x, y);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return r4;
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return false;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    AccessibilityManager getAccessibilityManager() {
        return (AccessibilityManager) this.mService.mContext.getSystemService("accessibility");
    }
}
