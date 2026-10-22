package com.android.server.wm;

import android.content.pm.ApplicationInfo;
import android.graphics.Region;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.os.StabTrace;
import android.os.SystemClock;
import android.os.Trace;
import android.os.UserHandle;
import android.util.EventLog;
import android.util.Slog;
import android.view.InputApplicationHandle;
import android.view.InputChannel;
import android.view.InputWindowHandle;
import android.view.SurfaceControl;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.input.InputManagerService;
import com.android.server.inputmethod.InputMethodManagerInternal;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
final class InputMonitor {
    private WeakReference<Task> mActiveRecentsLayerRef;
    private WeakReference<Task> mActiveRecentsTask;
    private final DisplayContent mDisplayContent;
    private int mDisplayHeight;
    private final int mDisplayId;
    private boolean mDisplayRemoved;
    private int mDisplayWidth;
    private final Handler mHandler;
    private final ArrayList<InputConsumerImpl> mInputConsumers;
    IBinder mInputFocus;
    long mInputFocusRequestTimeMillis;
    private final SurfaceControl.Transaction mInputTransaction;
    private final WindowManagerService mService;
    private final Region mTmpRegion;
    private final UpdateInputForAllWindowsConsumer mUpdateInputForAllWindowsConsumer;
    private final UpdateInputWindows mUpdateInputWindows;
    private boolean mUpdateInputWindowsImmediately;
    private boolean mUpdateInputWindowsNeeded;
    private boolean mUpdateInputWindowsPending;

    private final class UpdateInputForAllWindowsConsumer implements Consumer<WindowState> {
        private boolean mAddPipInputConsumerHandle;
        private boolean mAddRecentsAnimationInputConsumerHandle;
        private boolean mAddWallpaperInputConsumerHandle;
        private boolean mInDrag;
        InputConsumerImpl mPipInputConsumer;
        InputConsumerImpl mRecentsAnimationInputConsumer;
        InputConsumerImpl mWallpaperInputConsumer;
        final /* synthetic */ InputMonitor this$0;

        /* JADX INFO: renamed from: -$$Nest$mupdateInputWindows, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10009$$Nest$mupdateInputWindows(UpdateInputForAllWindowsConsumer r0, boolean r1) {
            r0.updateInputWindows(r1);
        }

        /* synthetic */ UpdateInputForAllWindowsConsumer(InputMonitor r1, InputMonitorIA r2) {
            this(r1);
        }

        private UpdateInputForAllWindowsConsumer(InputMonitor r1) {
            this.this$0 = r1;
        }

        @Override // java.util.function.Consumer
        public /* bridge */ /* synthetic */ void accept(WindowState r1) {
            accept2(r1);
        }

        private void updateInputWindows(boolean inDrag) {
            Trace.traceBegin(32, "updateInputWindows");
            if ("PREFETCH_APP".equals(InputMonitor.m9999$$Nest$fgetmDisplayContent(this.this$0).mDisplay.getName()) == false) goto L6;
            Trace.traceEnd(32);
            return;
        L6:
            this.mPipInputConsumer = this.this$0.getInputConsumer("pip_input_consumer");
            this.mWallpaperInputConsumer = this.this$0.getInputConsumer("wallpaper_input_consumer");
            this.mRecentsAnimationInputConsumer = this.this$0.getInputConsumer("recents_animation_input_consumer");
            if (this.mPipInputConsumer == null) goto L9;
            boolean r0 = true;
        L10:
            this.mAddPipInputConsumerHandle = r0;
            if (this.mWallpaperInputConsumer == null) goto L13;
            boolean r1 = true;
        L14:
            this.mAddWallpaperInputConsumerHandle = r1;
            if (this.mRecentsAnimationInputConsumer == null) goto L17;
            boolean r2 = true;
        L18:
            this.mAddRecentsAnimationInputConsumerHandle = r2;
            this.mInDrag = inDrag;
            this.this$0.resetInputConsumers(InputMonitor.m10001$$Nest$fgetmInputTransaction(this.this$0));
            Task activeRecents = (Task) InputMonitor.m10008$$Nest$smgetWeak(InputMonitor.m9998$$Nest$fgetmActiveRecentsTask(this.this$0));
            if (this.mAddRecentsAnimationInputConsumerHandle == false) goto L42;
            if (activeRecents == null) goto L42;
            if (activeRecents.getSurfaceControl() == null) goto L42;
            WindowContainer layer = (WindowContainer) InputMonitor.m10008$$Nest$smgetWeak(InputMonitor.m9997$$Nest$fgetmActiveRecentsLayerRef(this.this$0));
            if (layer == null) goto L26;
            WindowContainer layer2 = layer;
        L28:
            if (layer2.getSurfaceControl() == null) goto L42;
            this.mRecentsAnimationInputConsumer.mWindowHandle.touchableRegion.set(activeRecents.getBounds());
            TaskDisplayArea tda = activeRecents.getDisplayArea();
            if (tda != null) goto L32;
        L40:
            this.mRecentsAnimationInputConsumer.show(InputMonitor.m10001$$Nest$fgetmInputTransaction(this.this$0), layer2);
        L41:
            this.mAddRecentsAnimationInputConsumerHandle = false;
            goto L42
        L32:
            if (tda.getTopMostTask() == null) goto L40;
            if (tda.getTopMostTask().isActivityTypeHomeOrRecents() == true) goto L40;
            if (tda.getTopMostTask().inMultiWindowMode() == true) goto L40;
            if (tda.getTopMostTask() == layer2) goto L40;
            this.mRecentsAnimationInputConsumer.show(InputMonitor.m10001$$Nest$fgetmInputTransaction(this.this$0), tda.getTopMostTask());
            Slog.d("WindowManager", "recents input consumer relative to top most task: " + tda.getTopMostTask() + ", pre: " + layer2);
            goto L41
        L26:
            layer2 = activeRecents;
        L42:
            InputMonitor.m9999$$Nest$fgetmDisplayContent(this.this$0).forAllWindows(this, true);
            InputMonitor.m10007$$Nest$mupdateInputFocusRequest(this.this$0, this.mRecentsAnimationInputConsumer);
            if (InputMonitor.m10004$$Nest$fgetmUpdateInputWindowsImmediately(this.this$0) == true) goto L45;
            InputMonitor.m9999$$Nest$fgetmDisplayContent(this.this$0).getPendingTransaction().merge(InputMonitor.m10001$$Nest$fgetmInputTransaction(this.this$0));
            InputMonitor.m9999$$Nest$fgetmDisplayContent(this.this$0).scheduleAnimation();
        L45:
            Trace.traceEnd(32);
            return;
        L17:
            r2 = false;
            goto L18
        L13:
            r1 = false;
            goto L14
        L9:
            r0 = false;
            goto L10
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(WindowState w) {
            InputWindowHandleWrapper inputWindowHandle = w.mInputWindowHandle;
            if (w.mInputChannelToken == null) goto L35;
            if (w.mRemoved == true) goto L35;
            if (w.canReceiveTouchInput() == false) goto L35;
            if (w.inPinnedWindowingMode() == false) goto L17;
            if (this.mAddPipInputConsumerHandle == false) goto L17;
            Task rootTask = w.getTask().getRootTask();
            this.mPipInputConsumer.mWindowHandle.replaceTouchableRegionWithCrop(rootTask.getSurfaceControl());
            DisplayArea targetDA = rootTask.getDisplayArea();
            if (targetDA == null) goto L17;
            this.mPipInputConsumer.layout(InputMonitor.m10001$$Nest$fgetmInputTransaction(this.this$0), rootTask.getBounds());
            this.mPipInputConsumer.reparent(InputMonitor.m10001$$Nest$fgetmInputTransaction(this.this$0), targetDA);
            this.mPipInputConsumer.show(InputMonitor.m10001$$Nest$fgetmInputTransaction(this.this$0), 2147483646);
            this.mAddPipInputConsumerHandle = false;
        L17:
            if (this.mAddWallpaperInputConsumerHandle == false) goto L24;
            if (w.mAttrs.type != 2013) goto L24;
            if (w.isVisible() == false) goto L24;
            this.mWallpaperInputConsumer.mWindowHandle.replaceTouchableRegionWithCrop(null);
            this.mWallpaperInputConsumer.show(InputMonitor.m10001$$Nest$fgetmInputTransaction(this.this$0), w);
            this.mAddWallpaperInputConsumerHandle = false;
        L24:
            if (this.mInDrag == true) goto L26;
        L30:
            InputMonitor.m10002$$Nest$fgetmService(this.this$0).mKeyInterceptionInfoForToken.put(w.mInputChannelToken, w.getKeyInterceptionInfo());
            if (w.mWinAnimator.hasSurface() == false) goto L39;
            this.this$0.populateInputWindowHandle(inputWindowHandle, w);
            InputMonitor.setInputWindowInfoIfNeeded(InputMonitor.m10001$$Nest$fgetmInputTransaction(this.this$0), w.mWinAnimator.mSurfaceControl, inputWindowHandle);
            return;
        L39:
            return;
        L26:
            if (w.isVisible() == false) goto L30;
            if (w.getDisplayContent().isDefaultDisplay == false) goto L30;
            InputMonitor.m10002$$Nest$fgetmService(this.this$0).mDragDropController.sendDragStartedIfNeededLocked(w);
        L35:
            if (w.mWinAnimator.hasSurface() == false) goto L38;
            InputMonitor.populateOverlayInputInfo(inputWindowHandle, w);
            InputMonitor.setInputWindowInfoIfNeeded(InputMonitor.m10001$$Nest$fgetmInputTransaction(this.this$0), w.mWinAnimator.mSurfaceControl, inputWindowHandle);
            return;
        }
    }

    private class UpdateInputWindows implements Runnable {
        final /* synthetic */ InputMonitor this$0;

        /* synthetic */ UpdateInputWindows(InputMonitor r1, InputMonitorIA r2) {
            this(r1);
        }

        private UpdateInputWindows(InputMonitor r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            WindowManagerGlobalLock r0 = InputMonitor.m10002$$Nest$fgetmService(this.this$0).mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            InputMonitor.m10006$$Nest$fputmUpdateInputWindowsPending(this.this$0, false);     // Catch: Throwable -> L9
            InputMonitor.m10005$$Nest$fputmUpdateInputWindowsNeeded(this.this$0, false);     // Catch: Throwable -> L9
            if (InputMonitor.m10000$$Nest$fgetmDisplayRemoved(this.this$0) == false) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L11:
            boolean inDrag = InputMonitor.m10002$$Nest$fgetmService(this.this$0).mDragDropController.dragDropActiveLocked();     // Catch: Throwable -> L9
            UpdateInputForAllWindowsConsumer.m10009$$Nest$mupdateInputWindows(InputMonitor.m10003$$Nest$fgetmUpdateInputForAllWindowsConsumer(this.this$0), inDrag);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L9:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }
    }

    public static /* synthetic */ void $r8$lambda$rwaWEBUNPRPMnePQUvBFEBFeKKo(InputMonitor r0) {
        r0.lambda$onDisplayRemoved$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActiveRecentsLayerRef, reason: not valid java name */
    static /* bridge */ /* synthetic */ WeakReference m9997$$Nest$fgetmActiveRecentsLayerRef(InputMonitor r0) {
        return r0.mActiveRecentsLayerRef;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActiveRecentsTask, reason: not valid java name */
    static /* bridge */ /* synthetic */ WeakReference m9998$$Nest$fgetmActiveRecentsTask(InputMonitor r0) {
        return r0.mActiveRecentsTask;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayContent, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayContent m9999$$Nest$fgetmDisplayContent(InputMonitor r0) {
        return r0.mDisplayContent;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10000$$Nest$fgetmDisplayRemoved(InputMonitor r0) {
        return r0.mDisplayRemoved;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInputTransaction, reason: not valid java name */
    static /* bridge */ /* synthetic */ SurfaceControl.Transaction m10001$$Nest$fgetmInputTransaction(InputMonitor r0) {
        return r0.mInputTransaction;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerService m10002$$Nest$fgetmService(InputMonitor r0) {
        return r0.mService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUpdateInputForAllWindowsConsumer, reason: not valid java name */
    static /* bridge */ /* synthetic */ UpdateInputForAllWindowsConsumer m10003$$Nest$fgetmUpdateInputForAllWindowsConsumer(InputMonitor r0) {
        return r0.mUpdateInputForAllWindowsConsumer;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUpdateInputWindowsImmediately, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10004$$Nest$fgetmUpdateInputWindowsImmediately(InputMonitor r0) {
        return r0.mUpdateInputWindowsImmediately;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmUpdateInputWindowsNeeded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10005$$Nest$fputmUpdateInputWindowsNeeded(InputMonitor r0, boolean r1) {
        r0.mUpdateInputWindowsNeeded = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmUpdateInputWindowsPending, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10006$$Nest$fputmUpdateInputWindowsPending(InputMonitor r0, boolean r1) {
        r0.mUpdateInputWindowsPending = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateInputFocusRequest, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10007$$Nest$mupdateInputFocusRequest(InputMonitor r0, InputConsumerImpl r1) {
        r0.updateInputFocusRequest(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smgetWeak, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m10008$$Nest$smgetWeak(WeakReference r0) {
        return getWeak(r0);
    }

    InputMonitor(WindowManagerService service, DisplayContent displayContent) {
        InputMonitorIA r0 = null;
        this.mInputFocus = null;
        this.mInputFocusRequestTimeMillis = 0;
        this.mUpdateInputWindowsNeeded = true;
        this.mTmpRegion = new Region();
        this.mInputConsumers = new ArrayList();
        this.mActiveRecentsTask = null;
        this.mActiveRecentsLayerRef = null;
        this.mUpdateInputWindows = new UpdateInputWindows(this, r0);
        this.mService = service;
        this.mDisplayContent = displayContent;
        this.mDisplayId = displayContent.getDisplayId();
        this.mInputTransaction = this.mService.mTransactionFactory.get();
        this.mHandler = this.mService.mAnimationHandler;
        this.mUpdateInputForAllWindowsConsumer = new UpdateInputForAllWindowsConsumer(this, r0);
    }

    void onDisplayRemoved() {
        this.mHandler.removeCallbacks(this.mUpdateInputWindows);
        this.mService.mTransactionFactory.get().addWindowInfosReportedListener(new InputMonitor$$ExternalSyntheticLambda0(this)).apply();
        this.mDisplayRemoved = true;
    }

    private /* synthetic */ void lambda$onDisplayRemoved$0() {
        this.mService.mInputManager.onDisplayRemoved(this.mDisplayId);
    }

    private void addInputConsumer(InputConsumerImpl consumer) {
        this.mInputConsumers.add(consumer);
        consumer.linkToDeathRecipient();
        consumer.layout(this.mInputTransaction, this.mDisplayWidth, this.mDisplayHeight);
        updateInputWindowsLw(true);
    }

    boolean destroyInputConsumer(IBinder token) {
        int i = 0;
    L4:
        if (i >= this.mInputConsumers.size()) goto L12;
        InputConsumerImpl consumer = this.mInputConsumers.get(i);
        if (consumer == null) goto L11;
        if (consumer.mToken != token) goto L11;
        consumer.disposeChannelsLw(this.mInputTransaction);
        this.mInputConsumers.remove(consumer);
        updateInputWindowsLw(true);
        return true;
    L11:
        i = i + 1;
        goto L4
    L12:
        return false;
    }

    InputConsumerImpl getInputConsumer(String name) {
        int i = this.mInputConsumers.size() - 1;
    L3:
        if (i < 0) goto L8;
        InputConsumerImpl consumer = this.mInputConsumers.get(i);
        if (consumer.mName.equals(name) == true) goto L6;
        i = i - 1;
        goto L3
    L6:
        return consumer;
    L8:
        return null;
    }

    void layoutInputConsumers(int dw, int dh) {
        if (this.mDisplayWidth == dw) goto L5;
    L7:
        this.mDisplayWidth = dw;
        this.mDisplayHeight = dh;
        Trace.traceBegin(32, "layoutInputConsumer");     // Catch: Throwable -> L12
        int i = this.mInputConsumers.size() - 1;     // Catch: Throwable -> L12
    L9:
        if (i < 0) goto L14;
        this.mInputConsumers.get(i).layout(this.mInputTransaction, dw, dh);     // Catch: Throwable -> L12
        i = i - 1;
        goto L9
    L14:
        Trace.traceEnd(32);
        return;
    L12:
        th = move-exception;
        Trace.traceEnd(32);
        throw th;
    L5:
        if (this.mDisplayHeight != dh) goto L7;
    }

    void resetInputConsumers(SurfaceControl.Transaction t) {
        int i = this.mInputConsumers.size() - 1;
    L3:
        if (i < 0) goto L6;
        this.mInputConsumers.get(i).hide(t);
        i = i - 1;
        goto L3
    }

    void createInputConsumer(IBinder token, String name, InputChannel inputChannel, int clientPid, UserHandle clientUser) {
        InputConsumerImpl existingConsumer = getInputConsumer(name);
        if (existingConsumer != null) goto L5;
    L7:
        InputConsumerImpl consumer = new InputConsumerImpl(this.mService, token, name, inputChannel, clientPid, clientUser, this.mDisplayId, this.mInputTransaction);
        switch(name.hashCode()) {
            case -1525776435: goto L17;
            case 1024719987: goto L14;
            case 1415830696: goto L11;
            default: goto L19;
        };
    L19:
        byte r1 = -1;
    L20:
        switch(r1) {
            case 0: goto L25;
            case 1: goto L26;
            case 2: goto L23;
            default: goto L22;
        };
    L23:
        consumer.mWindowHandle.inputConfig &= -5;
        consumer.mWindowHandle.ownerPid = clientPid;
        consumer.mWindowHandle.ownerUid = Binder.getCallingUid();
        goto L26
    L25:
        consumer.mWindowHandle.inputConfig |= 32;
    L26:
        addInputConsumer(consumer);
        return;
    L22:
        throw new IllegalArgumentException("Illegal input consumer : " + name + ", display: " + this.mDisplayId);
    L11:
        if (name.equals("wallpaper_input_consumer") == false) goto L19;
        r1 = 0;
        goto L20
    L14:
        if (name.equals("pip_input_consumer") == false) goto L19;
        r1 = 1;
        goto L20
    L17:
        if (name.equals("recents_animation_input_consumer") == false) goto L19;
        r1 = 2;
        goto L20
    L5:
        if (existingConsumer.mClientUser.equals(clientUser) == false) goto L7;
        destroyInputConsumer(existingConsumer.mToken);
        Slog.w("WindowManager", "Replacing existing input consumer found with name: " + name + ", display: " + this.mDisplayId + ", user: " + clientUser);
        goto L7
    }

    void populateInputWindowHandle(InputWindowHandleWrapper inputWindowHandle, WindowState w) {
        SurfaceControl r1 = null;
        boolean hasWallpaper = false;
        if (w.mActivityRecord == null) goto L5;
        InputApplicationHandle r0 = w.mActivityRecord.getInputApplicationHandle(false);
    L6:
        inputWindowHandle.setInputApplicationHandle(r0);
        inputWindowHandle.setReverseDropCacheLevel(getReverseDropCacheLevel(w));
        inputWindowHandle.setToken(w.mInputChannelToken);
        inputWindowHandle.setDispatchingTimeoutMillis(w.getInputDispatchingTimeoutMillis());
        inputWindowHandle.setTouchOcclusionMode(w.getTouchOcclusionMode());
        if (w.mActivityRecord != null) goto L9;
    L11:
        boolean r2 = false;
    L12:
        inputWindowHandle.setPaused(r2);
        inputWindowHandle.setWindowToken(w.mClient.asBinder());
        inputWindowHandle.setName(w.getName());
        int flags = w.mAttrs.flags;
        if (w.mAttrs.isModal() == false) goto L15;
        flags = flags | 32;
    L15:
        inputWindowHandle.setLayoutParamsFlags(flags);
        inputWindowHandle.setInputConfigMasked(InputConfigAdapter.getInputConfigFromWindowParams(w.mAttrs.type, flags, w.mAttrs.inputFeatures), InputConfigAdapter.getMask());
        if (w.canReceiveKeys() == true) goto L18;
    L22:
        boolean focusable = false;
    L23:
        inputWindowHandle.setFocusable(focusable);
        if (this.mDisplayContent.mWallpaperController.isWallpaperTarget(w) == true) goto L26;
    L31:
        inputWindowHandle.setHasWallpaper(hasWallpaper);
        inputWindowHandle.setSurfaceInset(w.mAttrs.surfaceInsets.left);
        float r6 = 1.0f;
        if (w.mGlobalScale == 1.0f) goto L34;
        r6 = 1.0f / w.mGlobalScale;
    L34:
        inputWindowHandle.setScaleFactor(r6);
        boolean useSurfaceBoundsAsTouchRegion = false;
        SurfaceControl touchableRegionCrop = null;
        Task task = w.getTask();
        if (task != null) goto L37;
    L56:
        inputWindowHandle.setReplaceTouchableRegionWithCrop(useSurfaceBoundsAsTouchRegion);
        inputWindowHandle.setTouchableRegionCrop(touchableRegionCrop);
        if (useSurfaceBoundsAsTouchRegion == true) goto L60;
        w.getSurfaceTouchableRegion(this.mTmpRegion, w.mAttrs);
        inputWindowHandle.setTouchableRegion(this.mTmpRegion);
        return;
    L60:
        return;
    L37:
        if (task.isOrganized() == false) goto L52;
        if (task.getWindowingMode() == 1) goto L52;
        if (task.getWindowingMode() == 5) goto L52;
        if (w.mTouchableInsets == 3) goto L46;
        useSurfaceBoundsAsTouchRegion = true;
    L46:
        if (w.mAttrs.isModal() == false) goto L56;
        TaskFragment parent = w.getTaskFragment();
        if (parent == null) goto L50;
        r1 = parent.getSurfaceControl();
    L50:
        touchableRegionCrop = r1;
    L52:
        if (task.cropWindowsToRootTaskBounds() == false) goto L56;
        if (w.inFreeformWindowingMode() == true) goto L56;
        touchableRegionCrop = task.getRootTask().getSurfaceControl();
        goto L56
    L26:
        if (this.mService.mPolicy.isKeyguardShowing() == true) goto L31;
        if (w.mAttrs.areWallpaperTouchEventsEnabled() == false) goto L31;
        hasWallpaper = true;
        goto L31
    L18:
        if (this.mDisplayContent.hasOwnFocus() == false) goto L20;
    L21:
        focusable = true;
        goto L23
    L20:
        if (this.mDisplayContent.isOnTop() == false) goto L22;
    L9:
        if (w.mActivityRecord.paused == false) goto L11;
        r2 = true;
        goto L12
    L5:
        r0 = null;
        goto L6
    }

    private int getReverseDropCacheLevel(WindowState w) {
        if (w.mActivityRecord != null) goto L5;
    L7:
        ApplicationInfo info = null;
    L9:
        return SysOptBridge.getFactory().getReverseDropCacheFeatureConfig().getLevel(info);
    L5:
        if (w.mActivityRecord.info == null) goto L7;
        info = w.mActivityRecord.info.applicationInfo;
        goto L9
    }

    void setUpdateInputWindowsNeededLw() {
        this.mUpdateInputWindowsNeeded = true;
    }

    void updateInputWindowsLw(boolean force) {
        if (force == false) goto L4;
    L6:
        scheduleUpdateInputWindows();
        return;
    L4:
        if (this.mUpdateInputWindowsNeeded == true) goto L6;
    }

    private void scheduleUpdateInputWindows() {
        if (this.mDisplayRemoved == false) goto L6;
        return;
    L6:
        if (this.mUpdateInputWindowsPending == true) goto L9;
        this.mUpdateInputWindowsPending = true;
        this.mHandler.post(this.mUpdateInputWindows);
        return;
    }

    void updateInputWindowsImmediately(SurfaceControl.Transaction t) {
        this.mHandler.removeCallbacks(this.mUpdateInputWindows);
        this.mUpdateInputWindowsImmediately = true;
        this.mUpdateInputWindows.run();
        this.mUpdateInputWindowsImmediately = false;
        t.merge(this.mInputTransaction);
    }

    void setInputFocusLw(WindowState newWindow, boolean updateInputWindows) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_LIGHT_enabled[1] == false) goto L5;
        String protoLogParam0 = String.valueOf(newWindow);
        long protoLogParam1 = this.mDisplayId;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT, -8553129529717081823L, 4, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1)});
    L5:
        if (newWindow == null) goto L7;
        IBinder focus = newWindow.mInputChannelToken;
    L9:
        if (focus != this.mInputFocus) goto L12;
        return;
    L12:
        if (newWindow != null) goto L14;
    L16:
        setUpdateInputWindowsNeededLw();
        if (updateInputWindows == false) goto L20;
        updateInputWindowsLw(false);
        return;
    L20:
        return;
    L14:
        if (newWindow.canReceiveKeys() == false) goto L16;
        newWindow.mToken.paused = false;
        goto L16
    L7:
        focus = null;
        goto L9
    }

    void setActiveRecents(Task task, Task layer) {
        boolean wasActive = false;
        if (task != null) goto L5;
        boolean clear = true;
    L7:
        if (this.mActiveRecentsTask != null) goto L9;
    L11:
        WeakReference<Task> r1 = null;
        if (clear == false) goto L14;
        WeakReference<Task> r3 = null;
    L15:
        this.mActiveRecentsTask = r3;
        if (clear == true) goto L19;
        r1 = new WeakReference(layer);
    L19:
        this.mActiveRecentsLayerRef = r1;
        if (clear == false) goto L24;
        if (wasActive == false) goto L25;
        setUpdateInputWindowsNeededLw();
        return;
    L25:
        return;
    L24:
        return;
    L14:
        r3 = new WeakReference(task);
        goto L15
    L9:
        if (this.mActiveRecentsLayerRef == null) goto L11;
        wasActive = true;
        goto L11
    L5:
        clear = false;
        goto L7
    }

    private static <T> T getWeak(WeakReference<T> ref) {
        if (ref != null) goto L6;
        return null;
    L6:
        return ref.get();
    }

    private void updateInputFocusRequest(InputConsumerImpl recentsAnimationInputConsumer) {
        WindowState focus = this.mDisplayContent.mCurrentFocus;
        ActivityRecord app = null;
        if (recentsAnimationInputConsumer == null) goto L38;
        if (focus == null) goto L38;
        if (getWeak(this.mActiveRecentsTask) != null) goto L8;
    L12:
        boolean shouldApplyRecentsInputConsumer = false;
    L14:
        if (shouldApplyRecentsInputConsumer == false) goto L38;
        if (this.mInputFocus == recentsAnimationInputConsumer.mWindowHandle.token) goto L19;
        requestFocus(recentsAnimationInputConsumer.mWindowHandle.token, recentsAnimationInputConsumer.mName);
    L19:
        if (this.mDisplayContent.mInputMethodWindow != null) goto L21;
        return;
    L21:
        if (this.mDisplayContent.mInputMethodWindow.isVisible() == false) goto L71;
        boolean isImeAttachedToApp = this.mDisplayContent.isImeAttachedToApp();
        if (isImeAttachedToApp == true) goto L36;
        InputMethodManagerInternal inputMethodManagerInternal = (InputMethodManagerInternal) LocalServices.getService(InputMethodManagerInternal.class);
        if (inputMethodManagerInternal == null) goto L28;
        inputMethodManagerInternal.hideInputMethod(19, this.mDisplayContent.getDisplayId());
    L28:
        if (this.mDisplayContent.getImeInputTarget() == null) goto L31;
        app = this.mDisplayContent.getImeInputTarget().getActivityRecord();
    L31:
        if (app == null) goto L73;
        this.mDisplayContent.removeImeSurfaceImmediately();
        if (app.getTask() == null) goto L74;
        this.mDisplayContent.mAtmService.takeTaskSnapshot(app.getTask().mTaskId, true);
        return;
    L74:
        return;
    L73:
        return;
    L36:
        InputMethodManagerInternal.get().updateImeWindowStatus(true, this.mDisplayContent.getDisplayId());
        return;
    L71:
        return;
    L8:
        if (focus.inTransition() == false) goto L12;
        if (focus.isActivityTypeHomeOrRecents() == false) goto L12;
        shouldApplyRecentsInputConsumer = true;
    L38:
        if (focus == null) goto L40;
        IBinder focusToken = focus.mInputChannelToken;
    L41:
        if (focusToken != null) goto L59;
        if (recentsAnimationInputConsumer == null) goto L49;
        if (recentsAnimationInputConsumer.mWindowHandle == null) goto L49;
        if (this.mInputFocus != recentsAnimationInputConsumer.mWindowHandle.token) goto L49;
        return;
    L49:
        if (this.mDisplayContent.mFocusedApp != null) goto L51;
    L56:
        this.mInputFocus = null;
        return;
    L51:
        if (this.mInputFocus == null) goto L56;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_LIGHT_enabled[1] == false) goto L55;
        String protoLogParam0 = String.valueOf(this.mDisplayContent.mFocusedApp.getName());
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT, 4027486077547983902L, 0, new Object[]{protoLogParam0});
    L55:
        EventLog.writeEvent(62001, new Object[]{"Requesting to set focus to null window", "reason=UpdateInputWindows"});
        this.mInputTransaction.removeCurrentInputFocus(this.mDisplayId);
        goto L56
    L59:
        if (focus.mWinAnimator.hasSurface() == false) goto L66;
        if (focus.mInputWindowHandle.isFocusable() == false) goto L66;
        requestFocus(focusToken, focus.getName());
        return;
    L66:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_LIGHT_enabled[1] == false) goto L68;
        String protoLogParam1 = String.valueOf(focus);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT, -8537908614386667236L, 0, new Object[]{protoLogParam1});
    L68:
        this.mInputFocus = null;
        return;
    L40:
        focusToken = null;
        goto L41
    }

    private void requestFocus(IBinder focusToken, String windowName) {
        if (focusToken != this.mInputFocus) goto L6;
        return;
    L6:
        if (StabTrace.isEnable() == false) goto L8;
        long beginTime = Process.getCpuClocks();
        long beginTime2 = beginTime;
    L9:
        this.mInputFocus = focusToken;
        this.mInputFocusRequestTimeMillis = SystemClock.uptimeMillis();
        this.mInputTransaction.setFocusedWindow(this.mInputFocus, windowName, this.mDisplayId);
        EventLog.writeEvent(62001, new Object[]{"Focus request " + windowName, "reason=UpdateInputWindows"});
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_LIGHT_enabled[1] == false) goto L13;
        String protoLogParam0 = String.valueOf(windowName);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT, -6346673514571615151L, 0, new Object[]{protoLogParam0});
    L13:
        if (StabTrace.isEnable() == false) goto L16;
        StabTrace.traceInfo(1, "requestFocus:" + windowName, beginTime2, Process.getCpuClocks());
        return;
    L16:
        return;
    L8:
        beginTime2 = 0;
        goto L9
    }

    void setFocusedAppLw(ActivityRecord newApp) {
        InputManagerService r0 = this.mService.mInputManager;
        int r1 = this.mDisplayId;
        if (newApp == null) goto L5;
        InputApplicationHandle r2 = newApp.getInputApplicationHandle(true);
    L6:
        r0.setFocusedApplication(r1, r2);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public void pauseDispatchingLw(WindowToken window) {
        if (window.paused == false) goto L5;
        return;
    L5:
        if (WindowManagerDebugConfig.DEBUG_INPUT == false) goto L7;
        Slog.v("WindowManager", "Pausing WindowToken " + window);
    L7:
        window.paused = true;
        updateInputWindowsLw(true);
    }

    public void resumeDispatchingLw(WindowToken window) {
        if (window.paused == true) goto L5;
        return;
    L5:
        if (WindowManagerDebugConfig.DEBUG_INPUT == false) goto L7;
        Slog.v("WindowManager", "Resuming WindowToken " + window);
    L7:
        window.paused = false;
        updateInputWindowsLw(true);
    }

    void dump(PrintWriter pw, String prefix) {
        if (this.mInputConsumers.isEmpty() == true) goto L8;
        pw.println(prefix + "InputConsumers:");
        int i = 0;
    L6:
        if (i >= this.mInputConsumers.size()) goto L10;
        InputConsumerImpl consumer = this.mInputConsumers.get(i);
        consumer.dump(pw, consumer.mName, prefix);
        i = i + 1;
        goto L6
    L10:
        return;
    }

    static void setInputWindowInfoIfNeeded(SurfaceControl.Transaction t, SurfaceControl sc, InputWindowHandleWrapper inputWindowHandle) {
        if (WindowManagerDebugConfig.DEBUG_INPUT == false) goto L6;
        Slog.d("WindowManager", "Update InputWindowHandle: " + inputWindowHandle);
    L6:
        if (inputWindowHandle.isChanged() == false) goto L9;
        inputWindowHandle.applyChangesToSurface(t, sc);
        return;
    }

    static void populateOverlayInputInfo(InputWindowHandleWrapper inputWindowHandle, WindowState w) {
        populateOverlayInputInfo(inputWindowHandle);
        inputWindowHandle.setTouchOcclusionMode(w.getTouchOcclusionMode());
    }

    static void populateOverlayInputInfo(InputWindowHandleWrapper inputWindowHandle) {
        inputWindowHandle.setDispatchingTimeoutMillis(0);
        inputWindowHandle.setFocusable(false);
        inputWindowHandle.setToken(null);
        inputWindowHandle.setScaleFactor(1.0f);
        inputWindowHandle.setLayoutParamsType(2);
        inputWindowHandle.setInputConfigMasked(InputConfigAdapter.getInputConfigFromWindowParams(2, 16, 1), InputConfigAdapter.getMask());
        inputWindowHandle.clearTouchableRegion();
        inputWindowHandle.setTouchableRegionCrop(null);
    }

    static void setTrustedOverlayInputInfo(SurfaceControl sc, SurfaceControl.Transaction t, int displayId, String name) {
        InputWindowHandleWrapper inputWindowHandle = new InputWindowHandleWrapper(new InputWindowHandle(null, displayId));
        inputWindowHandle.setName(name);
        inputWindowHandle.setLayoutParamsType(2015);
        inputWindowHandle.setTrustedOverlay(t, sc, true);
        populateOverlayInputInfo(inputWindowHandle);
        setInputWindowInfoIfNeeded(t, sc, inputWindowHandle);
    }

    static boolean isTrustedOverlay(int type) {
        if (type != 2039) goto L5;
    L32:
        return true;
    L5:
        if (type == 2011) goto L32;
        if (type == 2012) goto L32;
        if (type == 2027) goto L32;
        if (type == 2000) goto L32;
        if (type == 2040) goto L32;
        if (type == 2019) goto L32;
        if (type == 2024) goto L32;
        if (type == 2015) goto L32;
        if (type == 2034) goto L32;
        if (type == 2032) goto L32;
        if (type == 2022) goto L32;
        if (type == 2031) goto L32;
        if (type == 2041) goto L32;
        return false;
    }
}
