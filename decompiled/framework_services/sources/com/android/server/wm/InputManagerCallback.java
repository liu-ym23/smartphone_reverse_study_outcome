package com.android.server.wm;

import android.gui.StalledTransactionInfo;
import android.os.Debug;
import android.os.IBinder;
import android.os.Trace;
import android.util.Slog;
import android.util.SparseIntArray;
import android.view.InputApplicationHandle;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.SurfaceControl;
import com.android.internal.os.TimeoutRecord;
import com.android.internal.util.function.pooled.PooledLambda;
import com.android.server.SysOptBridge;
import com.android.server.input.InputManagerService;
import java.io.PrintWriter;
import java.util.OptionalInt;

/* JADX INFO: loaded from: classes3.dex */
final class InputManagerCallback implements InputManagerService.WindowManagerCallbacks {
    private static final String TAG = "WindowManager";
    private boolean mInputDevicesReady;
    private final Object mInputDevicesReadyMonitor;
    private boolean mInputDispatchEnabled;
    private boolean mInputDispatchFrozen;
    private String mInputFreezeReason;
    private SparseIntArray mLastInputConfigurationSources;
    private final WindowManagerService mService;

    /* JADX INFO: renamed from: $r8$lambda$ThltoToBcsDX3ERz41-pSRxb0qc, reason: not valid java name */
    public static /* synthetic */ void m9996$r8$lambda$ThltoToBcsDX3ERz41pSRxb0qc(InputManagerCallback r0, DisplayPolicy r1) {
        r0.lambda$notifyPointerLocationChanged$0(r1);
    }

    public InputManagerCallback(WindowManagerService service) {
        this.mInputDevicesReadyMonitor = new Object();
        this.mInputFreezeReason = null;
        this.mService = service;
    }

    @Override // com.android.server.input.InputManagerService.WindowManagerCallbacks
    public void notifyInputChannelBroken(IBinder token) {
        if (token != null) goto L4;
        return;
    L4:
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        WindowState windowState = this.mService.mInputToWindowMap.get(token);     // Catch: Throwable -> L9
        if (windowState == null) goto L11;
        Slog.i(TAG, "WINDOW DIED " + windowState);     // Catch: Throwable -> L9
        windowState.removeIfPossible();     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    @Override // com.android.server.input.InputManagerService.WindowManagerCallbacks
    public void notifyNoFocusedWindowAnr(InputApplicationHandle applicationHandle, String reason) {
        TimeoutRecord timeoutRecord = TimeoutRecord.forInputDispatchNoFocusedWindow(timeoutMessage(OptionalInt.empty(), "Application does not have a focused window"));
        if (reason.startsWith("Monitor ") == false) goto L6;
        SysOptBridge.getFactory().getInputManagerEx().monitorAnr(this.mService, applicationHandle, null, reason);
        return;
    L6:
        this.mService.mAnrController.notifyAppUnresponsive(applicationHandle, timeoutRecord);
    }

    @Override // com.android.server.input.InputManagerService.WindowManagerCallbacks
    public void notifyWindowUnresponsive(IBinder token, OptionalInt pid, String reason) {
        TimeoutRecord timeoutRecord = TimeoutRecord.forInputDispatchWindowUnresponsive(timeoutMessage(pid, reason));
        if (reason.startsWith("Monitor ") == false) goto L6;
        SysOptBridge.getFactory().getInputManagerEx().monitorAnr(token, pid, reason);
        return;
    L6:
        this.mService.mAnrController.notifyWindowUnresponsive(token, pid, timeoutRecord);
    }

    @Override // com.android.server.input.InputManagerService.WindowManagerCallbacks
    public void notifyWindowResponsive(IBinder token, OptionalInt pid) {
        this.mService.mAnrController.notifyWindowResponsive(token, pid);
    }

    @Override // com.android.server.input.InputManagerService.WindowManagerCallbacks
    public void notifyConfigurationChanged() {
        Trace.traceBegin(32, "notifyConfigurationChanged");
        boolean changed = updateLastInputConfigurationSources();
        if (changed == false) goto L5;
    L6:
        WindowManagerGlobalLock r3 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r3);
        Trace.traceBegin(32, "inputDeviceConfigChanged");     // Catch: Throwable -> L23
        this.mService.mRoot.forAllDisplays(new InputManagerCallback$$ExternalSyntheticLambda0());     // Catch: Throwable -> L23
        Trace.traceEnd(32);     // Catch: Throwable -> L23
        monitor-exit(r3);     // Catch: Throwable -> L23
        WindowManagerService.resetPriorityAfterLockedSection();
    L11:
        Object r4 = this.mInputDevicesReadyMonitor;
        monitor-enter(r4);
    L16:
        th = move-exception;
        throw th;
    L14:
        if (this.mInputDevicesReady == true) goto L18;
        this.mInputDevicesReady = true;     // Catch: Throwable -> L16
        this.mInputDevicesReadyMonitor.notifyAll();     // Catch: Throwable -> L16
    L18:
        monitor-exit(r4);     // Catch: Throwable -> L16
        Trace.traceEnd(32);
        return;
    L23:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mService.mDisplayEnabled == true) goto L11;
        goto L6
    }

    private boolean updateLastInputConfigurationSources() {
        InputDevice[] r0 = this.mService.mInputManager.getInputDevices();
        SparseIntArray r1 = new SparseIntArray(8);
        SparseIntArray r2 = this.mLastInputConfigurationSources;
        if (r2 != null) goto L5;
        boolean r4 = true;
    L6:
        int r5 = r0.length;
        int r6 = 0;
    L7:
        if (r6 >= r5) goto L20;
        InputDevice r7 = r0[r6];
        String r8 = r7.getDescriptor();
        if (r8 == null) goto L19;
        if (r7.isVirtual() == true) goto L19;
        int r9 = r8.hashCode();
        int r10 = (((((((r7.getSources() * 31) + r7.getKeyboardType()) * 31) + r7.getAssociatedDisplayId()) * 31) + (r7.isExternal() ? 1 : 0)) * 31) + (r7.isEnabled() ? 1 : 0);
        r1.put(r9, r10);
        if (r2 == null) goto L19;
        if (r4 == true) goto L19;
        if (r2.get(r9, 0) == r10) goto L19;
        r4 = true;
    L19:
        r6 = r6 + 1;
        goto L7
    L20:
        if (r2 != null) goto L22;
    L24:
        this.mLastInputConfigurationSources = r1;
        return r4;
    L22:
        if (r2.size() == r1.size()) goto L24;
        r4 = true;
        goto L24
    L5:
        r4 = false;
        goto L6
    }

    @Override // com.android.server.input.InputManagerService.WindowManagerCallbacks
    public void notifyPointerLocationChanged(boolean pointerLocationEnabled) {
        if (this.mService.mPointerLocationEnabled != pointerLocationEnabled) goto L5;
        return;
    L5:
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mService.mPointerLocationEnabled = pointerLocationEnabled;     // Catch: Throwable -> L11
        this.mService.mRoot.forAllDisplayPolicies(new InputManagerCallback$$ExternalSyntheticLambda1(this));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L11:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private /* synthetic */ void lambda$notifyPointerLocationChanged$0(DisplayPolicy p) {
        p.setPointerLocationEnabled(this.mService.mPointerLocationEnabled);
    }

    @Override // com.android.server.input.InputManagerService.WindowManagerCallbacks
    public void togglePowerAndAiKey(boolean enable) {
    }

    @Override // com.android.server.input.InputManagerInternal.LidSwitchCallback
    public void notifyLidSwitchChanged(long whenNanos, boolean lidOpen) {
        this.mService.mPolicy.notifyLidSwitchChanged(whenNanos, lidOpen);
    }

    @Override // com.android.server.input.InputManagerService.WindowManagerCallbacks
    public void notifyCameraLensCoverSwitchChanged(long whenNanos, boolean lensCovered) {
        this.mService.mPolicy.notifyCameraLensCoverSwitchChanged(whenNanos, lensCovered);
    }

    @Override // com.android.server.input.InputManagerService.WindowManagerCallbacks
    public int interceptKeyBeforeQueueing(KeyEvent event, int policyFlags) {
        return this.mService.mPolicy.interceptKeyBeforeQueueing(event, policyFlags);
    }

    @Override // com.android.server.input.InputManagerService.WindowManagerCallbacks
    public int interceptMotionBeforeQueueingNonInteractive(int displayId, int source, int action, long whenNanos, int policyFlags) {
        return this.mService.mPolicy.interceptMotionBeforeQueueingNonInteractive(displayId, source, action, whenNanos, policyFlags);
    }

    @Override // com.android.server.input.InputManagerService.WindowManagerCallbacks
    public long interceptKeyBeforeDispatching(IBinder focusedToken, KeyEvent event, int policyFlags) {
        return this.mService.mPolicy.interceptKeyBeforeDispatching(focusedToken, event, policyFlags);
    }

    @Override // com.android.server.input.InputManagerService.WindowManagerCallbacks
    public boolean interceptUnhandledKey(KeyEvent event, IBinder focusedToken) {
        return this.mService.mPolicy.interceptUnhandledKey(event, focusedToken);
    }

    @Override // com.android.server.input.InputManagerService.WindowManagerCallbacks
    public int getPointerLayer() {
        return (this.mService.mPolicy.getWindowLayerFromTypeLw(2018) * 10000) + 1000;
    }

    @Override // com.android.server.input.InputManagerService.WindowManagerCallbacks
    public int getPointerDisplayId() {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mService.mForceDesktopModeOnExternalDisplays == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return 0;
    L11:
        int firstExternalDisplayId = 0;
        int i = this.mService.mRoot.mChildren.size() - 1;     // Catch: Throwable -> L9
    L13:
        if (i < 0) goto L29;
        DisplayContent displayContent = (DisplayContent) this.mService.mRoot.mChildren.get(i);     // Catch: Throwable -> L9
        if (displayContent.getDisplayInfo().state != 1) goto L18;
    L27:
        i = i - 1;     // Catch: Throwable -> L9
        goto L13
    L18:
        if (displayContent.getWindowingMode() == 5) goto L19;
        if (firstExternalDisplayId != 0) goto L27;
        if (displayContent.getDisplayId() == 0) goto L27;
        firstExternalDisplayId = displayContent.getDisplayId();     // Catch: Throwable -> L9
        goto L27
    L19:
        int r3 = displayContent.getDisplayId();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return r3;
    L29:
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return firstExternalDisplayId;
    }

    @Override // com.android.server.input.InputManagerService.WindowManagerCallbacks
    public void onPointerDownOutsideFocus(IBinder touchedToken) {
        this.mService.mH.obtainMessage(62, touchedToken).sendToTarget();
    }

    @Override // com.android.server.input.InputManagerService.WindowManagerCallbacks
    public void notifyFocusChanged(IBinder oldToken, IBinder newToken) {
        WindowManagerService.H r0 = this.mService.mH;
        final WindowManagerService r1 = this.mService;
        r1.getClass();
        r0.sendMessage(PooledLambda.obtainMessage(new InputManagerCallback$$ExternalSyntheticLambda2(r1), oldToken, newToken));
    }

    @Override // com.android.server.input.InputManagerService.WindowManagerCallbacks
    public void notifyDropWindow(IBinder token, float x, float y) {
        WindowManagerService.H r0 = this.mService.mH;
        final DragDropController r1 = this.mService.mDragDropController;
        r1.getClass();
        r0.sendMessage(PooledLambda.obtainMessage(new InputManagerCallback$$ExternalSyntheticLambda3(r1), token, Float.valueOf(x), Float.valueOf(y)));
    }

    @Override // com.android.server.input.InputManagerService.WindowManagerCallbacks
    public SurfaceControl getParentSurfaceForPointers(int displayId) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent dc = this.mService.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L10
        if (dc != null) goto L12;
        Slog.e(TAG, "Failed to get parent surface for pointers on display " + displayId + " - DisplayContent not found.");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L12:
        SurfaceControl r2 = dc.getOverlayLayer();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return r2;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    @Override // com.android.server.input.InputManagerService.WindowManagerCallbacks
    public SurfaceControl createSurfaceForGestureMonitor(String name, int displayId) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        DisplayContent dc = this.mService.mRoot.getDisplayContent(displayId);     // Catch: Throwable -> L10
        if (dc != null) goto L12;
        Slog.e(TAG, "Failed to create a gesture monitor on display: " + displayId + " - DisplayContent not found.");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L12:
        SurfaceControl inputOverlay = dc.getInputOverlayLayer();     // Catch: Throwable -> L10
        if (inputOverlay != null) goto L18;
        Slog.e(TAG, "Failed to create a gesture monitor on display: " + displayId + " - Input overlay layer is not initialized.");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return null;
    L18:
        SurfaceControl r2 = this.mService.makeSurfaceBuilder().setContainerLayer().setName(name).setCallsite("createSurfaceForGestureMonitor").setParent(inputOverlay).setCallsite("InputManagerCallback.createSurfaceForGestureMonitor").build();     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return r2;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    @Override // com.android.server.input.InputManagerService.WindowManagerCallbacks
    public boolean isKeyguardLocked(int displayId) {
        WindowManagerGlobalLock r0 = this.mService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        boolean r1 = this.mService.mAtmService.mKeyguardController.isKeyguardLocked(displayId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return r1;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    public boolean waitForInputDevicesReady(long timeoutMillis) {
        Object r0 = this.mInputDevicesReadyMonitor;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mInputDevicesReady == false) goto L16;
    L11:
        boolean r1 = this.mInputDevicesReady;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r1;
    L16:
        this.mInputDevicesReadyMonitor.wait(timeoutMillis);     // Catch: Throwable -> L8 InterruptedException -> L10
        goto L11
    }

    public void freezeInputDispatchingLw() {
        if (this.mInputDispatchFrozen == false) goto L5;
        return;
    L5:
        if (WindowManagerDebugConfig.DEBUG_INPUT == false) goto L7;
        Slog.v(TAG, "Freezing input dispatching");
    L7:
        this.mInputDispatchFrozen = true;
        if (WindowManagerDebugConfig.DEBUG_INPUT == false) goto L10;
        this.mInputFreezeReason = Debug.getCallers(6);
    L10:
        updateInputDispatchModeLw();
    }

    public void thawInputDispatchingLw() {
        if (this.mInputDispatchFrozen == true) goto L5;
        return;
    L5:
        if (WindowManagerDebugConfig.DEBUG_INPUT == false) goto L7;
        Slog.v(TAG, "Thawing input dispatching");
    L7:
        this.mInputDispatchFrozen = false;
        this.mInputFreezeReason = null;
        updateInputDispatchModeLw();
    }

    public void setEventDispatchingLw(boolean enabled) {
        if (this.mInputDispatchEnabled != enabled) goto L5;
        return;
    L5:
        if (WindowManagerDebugConfig.DEBUG_INPUT == false) goto L7;
        Slog.v(TAG, "Setting event dispatching to " + enabled);
    L7:
        this.mInputDispatchEnabled = enabled;
        updateInputDispatchModeLw();
    }

    private void updateInputDispatchModeLw() {
        this.mService.mInputManager.setInputDispatchMode(this.mInputDispatchEnabled, this.mInputDispatchFrozen);
    }

    private String timeoutMessage(OptionalInt pid, String reason) {
        if (reason != null) goto L4;
        String message = "Input dispatching timed out.";
    L6:
        if (pid.isEmpty() == false) goto L8;
        return message;
    L8:
        StalledTransactionInfo stalledTransactionInfo = SurfaceControl.getStalledTransactionInfo(pid.getAsInt());
        if (stalledTransactionInfo != null) goto L12;
        return message;
    L12:
        return String.format("%s Buffer processing for the associated surface is stuck due to an unsignaled fence (window=%s, bufferId=0x%016X, frameNumber=%s). This potentially indicates a GPU hang.", new Object[]{message, stalledTransactionInfo.layerName, Long.valueOf(stalledTransactionInfo.bufferId), Long.valueOf(stalledTransactionInfo.frameNumber)});
    L4:
        message = String.format("Input dispatching timed out (%s).", new Object[]{reason});
        goto L6
    }

    void dump(PrintWriter pw, String prefix) {
        if (this.mInputFreezeReason == null) goto L6;
        pw.println(prefix + "mInputFreezeReason=" + this.mInputFreezeReason);
        return;
    }
}
