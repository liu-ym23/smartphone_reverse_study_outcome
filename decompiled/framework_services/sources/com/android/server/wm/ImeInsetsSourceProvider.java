package com.android.server.wm;

import android.graphics.Rect;
import android.os.IBinder;
import android.os.Trace;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import android.view.InsetsSource;
import android.view.InsetsSourceControl;
import android.view.WindowInsets;
import android.view.inputmethod.ImeTracker;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
final class ImeInsetsSourceProvider extends InsetsSourceProvider {
    private static final String TAG = null;
    private boolean mFrozen;
    private boolean mGivenInsetsReady;
    private InsetsControlTarget mImeRequester;
    private boolean mImeShowing;
    private boolean mLastDrawn;
    private final InsetsSource mLastSource;
    private boolean mServerVisible;
    private ImeTracker.Token mStatsToken;

    public static /* synthetic */ void $r8$lambda$0bLR65BJCQP9gy7MdQKZ14IPtuU(ImeTracker.Token r0, WindowManagerInternal.OnImeRequestedChangedListener r1, IBinder r2, boolean r3) {
        lambda$invokeOnImeRequestedChangedListener$0(r0, r1, r2, r3);
    }

    static {
        TAG = ImeInsetsSourceProvider.class.getSimpleName();
    }

    ImeInsetsSourceProvider(InsetsSource source, InsetsStateController stateController, DisplayContent displayContent) {
        super(source, stateController, displayContent);
        this.mLastSource = new InsetsSource(InsetsSource.ID_IME, WindowInsets.Type.ime());
        this.mGivenInsetsReady = false;
        this.mLastDrawn = false;
    }

    @Override // com.android.server.wm.InsetsSourceProvider
    void onPostLayout() {
        boolean wasSourceVisible = this.mSource.isVisible();
        super.onPostLayout();
        if (wasSourceVisible == this.mSource.isVisible()) goto L6;
        this.mDisplayContent.setLayoutNeeded();
    L6:
        if (this.mWindowContainer == null) goto L8;
        WindowState ws = this.mWindowContainer.asWindowState();
    L10:
        if (ws != null) goto L12;
    L14:
        boolean givenInsetsPending = false;
    L15:
        if (ws != null) goto L17;
    L19:
        boolean r6 = false;
    L20:
        this.mLastDrawn = r6;
        if (this.mGivenInsetsReady == false) goto L23;
    L31:
        if (wasSourceVisible == true) goto L33;
    L41:
        if (wasSourceVisible == true) goto L43;
        return;
    L43:
        if (isServerVisible() == false) goto L45;
        return;
    L45:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_IME_enabled[0] == false) goto L47;
        String protoLogParam0 = String.valueOf(isImeShowing());
        String protoLogParam1 = String.valueOf(this.mControlTarget);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_IME, -2976295883537435491L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L47:
        setImeShowing(false);
        return;
    L33:
        if (isServerVisible() == false) goto L41;
        if (this.mGivenInsetsReady == false) goto L41;
        if (givenInsetsPending == false) goto L41;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_IME_enabled[3] == false) goto L40;
        String protoLogParam2 = String.valueOf(this.mControlTarget);
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_IME, -9006513919776967685L, 0, new Object[]{protoLogParam2});
    L40:
        ImeTracker.forLogging().onCancelled(this.mStatsToken, 50);
        this.mStatsToken = null;
        return;
    L23:
        if (isServerVisible() == false) goto L31;
        if (givenInsetsPending == true) goto L31;
        if (this.mControlTarget == null) goto L31;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_IME_enabled[0] == false) goto L30;
        String protoLogParam3 = String.valueOf(this.mControlTarget);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_IME, 5397052278022092054L, 0, new Object[]{protoLogParam3});
    L30:
        this.mGivenInsetsReady = true;
        ImeTracker.forLogging().onProgress(this.mStatsToken, 50);
        this.mStateController.notifyControlChanged(this.mControlTarget, this);
        setImeShowing(true);
        return;
    L17:
        if (ws.isDrawn() == false) goto L19;
        r6 = true;
        goto L20
    L12:
        if (ws.mGivenInsetsPending == false) goto L14;
        givenInsetsPending = true;
        goto L15
    L8:
        ws = null;
        goto L10
    }

    ImeTracker.Token getAndClearStatsToken() {
        ImeTracker.Token statsToken = this.mStatsToken;
        this.mStatsToken = null;
        return statsToken;
    }

    @Override // com.android.server.wm.InsetsSourceProvider
    protected boolean isLeashReadyForDispatching() {
        if (this.mWindowContainer == null) goto L5;
        WindowState ws = this.mWindowContainer.asWindowState();
    L7:
        if (ws != null) goto L9;
    L11:
        boolean isDrawn = false;
    L13:
        if (super.isLeashReadyForDispatching() == true) goto L15;
        return false;
    L15:
        if (isServerVisible() == false) goto L23;
        if (isDrawn == true) goto L18;
        return false;
    L18:
        if (this.mGivenInsetsReady == true) goto L21;
        return false;
    L21:
        return true;
    L23:
        return false;
    L9:
        if (ws.isDrawn() == false) goto L11;
        isDrawn = true;
        goto L13
    L5:
        ws = null;
        goto L7
    }

    @Override // com.android.server.wm.InsetsSourceProvider
    protected boolean isSurfaceVisible() {
        boolean isSurfaceVisible = super.isSurfaceVisible();
        if (getExt().shouldSkipImeSurfaceVisible() == false) goto L5;
        return false;
    L5:
        WindowState windowState = this.mWindowContainer.asWindowState();
        if (this.mControl == null) goto L20;
        if (windowState == null) goto L20;
        boolean isDrawn = windowState.isDrawn();
        if (isServerVisible() == true) goto L17;
        if (isSurfaceVisible == false) goto L17;
        if (isDrawn == true) goto L13;
        return false;
    L13:
        if (windowState.mGivenInsetsPending == true) goto L22;
        return true;
    L22:
        return false;
    L17:
        if (this.mLastDrawn == false) goto L20;
        if (isDrawn == true) goto L20;
        return false;
    L20:
        return isSurfaceVisible;
    }

    @Override // com.android.server.wm.InsetsSourceProvider
    InsetsSourceControl getControl(InsetsControlTarget target) {
        InsetsSourceControl control = super.getControl(target);
        if (control == null) goto L21;
        if (target == null) goto L21;
        if (target.getWindow() == null) goto L21;
        WindowState targetWin = target.getWindow();
        Task task = targetWin.getTask();
        StartingData startingData = null;
        if (task == null) goto L14;
        startingData = targetWin.mActivityRecord.mStartingData;
        if (startingData != null) goto L14;
        WindowState startingWin = task.topStartingWindow();
        if (startingWin == null) goto L14;
        startingData = startingWin.mStartingData;
    L14:
        if (startingData != null) goto L16;
    L18:
        boolean r6 = false;
    L19:
        control.setSkipAnimationOnce(r6);
        goto L21
    L16:
        if (startingData.hasImeSurface() == false) goto L18;
        r6 = true;
    L21:
        if (control != null) goto L23;
    L31:
        return control;
    L23:
        if (control.getLeash() == null) goto L31;
        ImeTracker.Token statsToken = getAndClearStatsToken();
        if (statsToken == null) goto L27;
    L30:
        ImeTracker.forLogging().onProgress(statsToken, 55);
        control.setImeStatsToken(statsToken);
        goto L31
    L27:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_IME_enabled[3] == false) goto L29;
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_IME, -6978103356330723631L, 0, null);
    L29:
        statsToken = ImeTracker.forLogging().onStart(1, 6, 46, false);
        goto L30
    }

    @Override // com.android.server.wm.InsetsSourceProvider
    void setClientVisible(boolean clientVisible) {
        boolean wasClientVisible = isClientVisible();
        super.setClientVisible(clientVisible);
        if (wasClientVisible == false) goto L5;
        return;
    L5:
        if (isClientVisible() == false) goto L15;
        InsetsControlTarget imeControlTarget = getControlTarget();
        if (imeControlTarget != null) goto L9;
        return;
    L9:
        if (imeControlTarget.getWindow() != null) goto L11;
        return;
    L11:
        if (imeControlTarget.getWindow().mActivityRecord != null) goto L18;
        this.mDisplayContent.assignWindowLayers(false);
        return;
    L18:
        return;
    }

    @Override // com.android.server.wm.InsetsSourceProvider
    void setServerVisible(boolean serverVisible) {
        if (this.mServerVisible == serverVisible) goto L10;
        this.mServerVisible = serverVisible;
        if (serverVisible == true) goto L10;
        if (this.mFrozen == true) goto L10;
        this.mGivenInsetsReady = false;
        updateControlForTarget(this.mControlTarget, true, null);
    L10:
        if (this.mFrozen == true) goto L13;
        super.setServerVisible(serverVisible);
        return;
    }

    void setFrozen(boolean frozen) {
        if (this.mFrozen != frozen) goto L5;
        return;
    L5:
        this.mFrozen = frozen;
        if (frozen == true) goto L9;
        super.setServerVisible(this.mServerVisible);
        return;
    }

    @Override // com.android.server.wm.InsetsSourceProvider
    void updateSourceFrame(Rect frame) {
        super.updateSourceFrame(frame);
        onSourceChanged();
    }

    @Override // com.android.server.wm.InsetsSourceProvider
    protected void updateVisibility() {
        boolean oldVisibility = this.mSource.isVisible();
        super.updateVisibility();
        if (this.mSource.isVisible() == false) goto L8;
        if (oldVisibility == true) goto L8;
        if (this.mControlTarget == null) goto L8;
        reportImeDrawnForOrganizerIfNeeded(this.mControlTarget);
    L8:
        onSourceChanged();
    }

    @Override // com.android.server.wm.InsetsSourceProvider
    void updateControlForTarget(InsetsControlTarget target, boolean force, ImeTracker.Token statsToken) {
        if (target != null) goto L4;
    L6:
        super.updateControlForTarget(target, force, statsToken);
        if (target == null) goto L19;
        if (target != this.mControlTarget) goto L19;
        InputTarget imeInputTarget = this.mDisplayContent.getImeInputTarget();
        if (imeInputTarget == target) goto L16;
        if (imeInputTarget == null) goto L16;
        if (imeInputTarget.isRequestedVisible(WindowInsets.Type.ime()) == target.isRequestedVisible(WindowInsets.Type.ime())) goto L16;
        reportImeInputTargetStateToControlTarget(imeInputTarget, target, statsToken);
        return;
    L16:
        invokeOnImeRequestedChangedListener(target, statsToken);
        return;
    L19:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_IME_enabled[3] == false) goto L22;
        String protoLogParam0 = String.valueOf(target);
        String protoLogParam1 = String.valueOf(this.mControlTarget);
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_IME, 4504289575796095544L, 0, new Object[]{protoLogParam0, protoLogParam1});
        return;
    L22:
        return;
    L4:
        if (target.getWindow() == null) goto L6;
        target = target.getWindow().getImeControlTarget();
        goto L6
    }

    @Override // com.android.server.wm.InsetsSourceProvider
    protected boolean updateClientVisibility(InsetsTarget caller, ImeTracker.Token statsToken) {
        InsetsControlTarget controlTarget = getControlTarget();
        if (caller != controlTarget) goto L5;
        boolean changed = super.updateClientVisibility(caller, statsToken);
        if (changed == false) goto L15;
        ImeTracker.forLogging().onProgress(statsToken, 67);
        invokeOnImeRequestedChangedListener(controlTarget, statsToken);
    L16:
        return changed;
    L15:
        ImeTracker.forLogging().onCancelled(statsToken, 67);
        goto L16
    L5:
        if (isImeInputTarget(caller) == false) goto L8;
        reportImeInputTargetStateToControlTarget(caller, controlTarget, statsToken);
    L11:
        return false;
    L8:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_IME_enabled[3] == false) goto L10;
        String protoLogParam0 = String.valueOf(caller);
        String protoLogParam1 = String.valueOf(this.mDisplayContent.getImeInputTarget());
        String protoLogParam2 = String.valueOf(caller.isRequestedVisible(WindowInsets.Type.ime()));
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_IME, 4168975913755817225L, 0, new Object[]{protoLogParam0, protoLogParam1, protoLogParam2});
    L10:
        ImeTracker.forLogging().onFailed(statsToken, 67);
        goto L11
    }

    void onInputTargetChanged(InputTarget target) {
        if (target == null) goto L14;
        InsetsControlTarget imeControlTarget = getControlTarget();
        if (target == imeControlTarget) goto L15;
        boolean imeVisible = target.isRequestedVisible(WindowInsets.Type.ime());
        ImeTracker r2 = ImeTracker.forLogging();
        if (imeVisible == false) goto L8;
        int r3 = 1;
    L9:
        if (imeVisible == false) goto L11;
        int r4 = 56;
    L12:
        ImeTracker.Token statsToken = r2.onStart(r3, 6, r4, false);
        reportImeInputTargetStateToControlTarget(target, imeControlTarget, statsToken);
        return;
    L11:
        r4 = 57;
        goto L12
    L8:
        r3 = 2;
        goto L9
    L15:
        return;
    }

    private void reportImeInputTargetStateToControlTarget(InsetsTarget imeInsetsTarget, InsetsControlTarget controlTarget, ImeTracker.Token statsToken) {
        boolean imeVisible = imeInsetsTarget.isRequestedVisible(WindowInsets.Type.ime());
        if (controlTarget == null) goto L6;
        ImeTracker.forLogging().onProgress(statsToken, 49);
        controlTarget.setImeInputTargetRequestedVisibility(imeVisible, statsToken);
        return;
    L6:
        if ((imeInsetsTarget instanceof InsetsControlTarget) == false) goto L14;
        InsetsControlTarget controlTarget2 = this.mDisplayContent.getImeHostOrFallback(((InsetsControlTarget) imeInsetsTarget).getWindow());
        if (controlTarget2 == null) goto L11;
        if (controlTarget2 == imeInsetsTarget) goto L11;
        ImeTracker.forLogging().onProgress(statsToken, 49);
        controlTarget2.setImeInputTargetRequestedVisibility(imeVisible, statsToken);
        invokeOnImeRequestedChangedListener((InsetsControlTarget) imeInsetsTarget, statsToken);
        return;
    L11:
        ImeTracker.forLogging().onFailed(statsToken, 49);
        return;
    }

    private void invokeOnImeRequestedChangedListener(InsetsControlTarget controlTarget, ImeTracker.Token statsToken) {
        final WindowManagerInternal.OnImeRequestedChangedListener imeListener = this.mDisplayContent.mWmService.mOnImeRequestedChangedListener;
        if (imeListener != null) goto L5;
        ImeTracker.forLogging().onFailed(statsToken, 60);
        return;
    L5:
        if (controlTarget == null) goto L27;
        int r5 = 1;
        if (controlTarget.isRequestedVisible(WindowInsets.Type.ime()) == true) goto L11;
        if (0 != 0) goto L11;
        final boolean imeVisible = false;
    L12:
        if (statsToken == null) goto L14;
        final ImeTracker.Token finalStatsToken = statsToken;
    L20:
        if (controlTarget.getWindowToken() == null) goto L23;
        final IBinder windowToken = controlTarget.getWindowToken();
    L26:
        ImeTracker.forLogging().onProgress(finalStatsToken, 63);
        this.mDisplayContent.mWmService.mH.post(new ImeInsetsSourceProvider$$ExternalSyntheticLambda0(finalStatsToken, imeListener, windowToken, imeVisible));
        return;
    L23:
        if (this.mDisplayContent.getImeInputTarget() == null) goto L25;
        windowToken = this.mDisplayContent.getImeInputTarget().getWindowToken();
        goto L26
    L25:
        windowToken = null;
        goto L26
    L14:
        ImeTracker r6 = ImeTracker.forLogging();
        if (imeVisible == true) goto L18;
        r5 = 2;
    L18:
        finalStatsToken = r6.onStart(r5, 6, 59, false);
    L11:
        imeVisible = true;
        goto L12
    L27:
        ImeTracker.forLogging().onFailed(statsToken, 63);
    }

    private static /* synthetic */ void lambda$invokeOnImeRequestedChangedListener$0(ImeTracker.Token finalStatsToken, WindowManagerInternal.OnImeRequestedChangedListener imeListener, IBinder windowToken, boolean imeVisible) {
        ImeTracker.forLogging().onProgress(finalStatsToken, 64);
        imeListener.onImeRequestedChanged(windowToken, imeVisible, finalStatsToken);
    }

    @Override // com.android.server.wm.InsetsSourceProvider
    void onAnimatingTypesChanged(InsetsControlTarget caller, ImeTracker.Token statsToken) {
    }

    private void reportImeDrawnForOrganizerIfNeeded(InsetsControlTarget caller) {
        WindowState callerWindow = caller.getWindow();
        if (callerWindow != null) goto L6;
        return;
    L6:
        if (this.mWindowContainer.asWindowState() == null) goto L8;
        WindowToken imeToken = this.mWindowContainer.asWindowState().mToken;
    L9:
        AsyncRotationController rotationController = this.mDisplayContent.getAsyncRotationController();
        if (rotationController != null) goto L12;
    L14:
        if (imeToken != null) goto L16;
    L18:
        reportImeDrawnForOrganizer(caller);
        return;
    L16:
        if (imeToken.isSelfAnimating(0, 64) == false) goto L18;
        return;
    L12:
        if (rotationController.isTargetToken(imeToken) == false) goto L14;
        return;
    L8:
        imeToken = null;
        goto L9
    }

    private void reportImeDrawnForOrganizer(InsetsControlTarget caller) {
        WindowState callerWindow = caller.getWindow();
        if (callerWindow != null) goto L5;
        return;
    L5:
        if (callerWindow.getTask() != null) goto L8;
        return;
    L8:
        if (callerWindow.getTask().isOrganized() == false) goto L12;
        this.mWindowContainer.mWmService.mAtmService.mTaskOrganizerController.reportImeDrawnOnTask(caller.getWindow().getTask());
        return;
    }

    void reportImeDrawnForOrganizer() {
        InsetsControlTarget imeControlTarget = getControlTarget();
        if (imeControlTarget == null) goto L6;
        reportImeDrawnForOrganizer(imeControlTarget);
        return;
    }

    private void onSourceChanged() {
        if (this.mLastSource.equals(this.mSource) == false) goto L5;
        return;
    L5:
        this.mLastSource.set(this.mSource);
        this.mDisplayContent.mWmService.mH.obtainMessage(41, this.mDisplayContent).sendToTarget();
    }

    void scheduleShowImePostLayout(InsetsControlTarget imeTarget, ImeTracker.Token statsToken) {
        if (this.mImeRequester != null) goto L5;
        Trace.asyncTraceBegin(32, "WMS.showImePostLayout", 0);
    L6:
        boolean targetChanged = isTargetChangedWithinActivity(imeTarget);
        this.mImeRequester = imeTarget;
        this.mStatsToken = statsToken;
        if (targetChanged == false) goto L14;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_IME_enabled[0] == false) goto L11;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_IME, -786355099910065121L, 0, null);
    L11:
        checkAndStartShowImePostLayout();
        return;
    L14:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_IME_enabled[0] == true) goto L16;
    L20:
        this.mDisplayContent.mWmService.requestTraversal();
        return;
    L16:
        if (this.mImeRequester.getWindow() != null) goto L18;
        Object r2 = this.mImeRequester;
    L19:
        String protoLogParam0 = String.valueOf(r2);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_IME, 2634707843050913730L, 0, new Object[]{protoLogParam0});
        goto L20
    L18:
        r2 = this.mImeRequester.getWindow().getName();
        goto L19
    L5:
        logIsScheduledAndReadyToShowIme(false);
        ImeTracker.forLogging().onCancelled(this.mStatsToken, 18);
        goto L6
    }

    void checkAndStartShowImePostLayout() {
        if (isScheduledAndReadyToShowIme() == true) goto L6;
        return;
    L6:
        if (this.mControl != null) goto L8;
        return;
    L8:
        if (this.mControl.getLeash() != null) goto L10;
        return;
    L10:
        if (this.mControlTarget.getWindow() != null) goto L12;
        return;
    L12:
        if (this.mControlTarget.getWindow().mGivenInsetsPending == true) goto L18;
        int displayId = this.mDisplayContent.getDisplayId();
        this.mControlTarget.notifyInsetsControlChanged(displayId);
        return;
    }

    void abortShowImePostLayout() {
        if (this.mImeRequester != null) goto L6;
        return;
    L6:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_IME_enabled[0] == false) goto L8;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_IME, -6529782994356455131L, 0, null);
    L8:
        Trace.asyncTraceEnd(32, "WMS.showImePostLayout", 0);
        logIsScheduledAndReadyToShowIme(true);
        ImeTracker.forLogging().onFailed(this.mStatsToken, 43);
        resetShowImePostLayout();
    }

    private void resetShowImePostLayout() {
        this.mImeRequester = null;
        this.mStatsToken = null;
    }

    boolean isScheduledAndReadyToShowIme() {
        if (this.mImeRequester != null) goto L6;
        return false;
    L6:
        if (this.mServerVisible == true) goto L8;
    L57:
        return false;
    L8:
        if (this.mFrozen == true) goto L57;
        if (this.mWindowContainer != null) goto L13;
        return false;
    L13:
        WindowState windowState = this.mWindowContainer.asWindowState();
        if (windowState == null) goto L56;
        if (windowState.isDrawn() == true) goto L18;
    L54:
        return false;
    L18:
        if (windowState.mGivenInsetsPending == true) goto L54;
        InsetsControlTarget dcTarget = this.mDisplayContent.getImeTarget(0);
        if (dcTarget != null) goto L23;
        return false;
    L23:
        InsetsControlTarget controlTarget = getControlTarget();
        if (controlTarget != null) goto L27;
        return false;
    L27:
        if (controlTarget == this.mDisplayContent.getImeTarget(2)) goto L30;
        return false;
    L30:
        if (this.mStateController.hasPendingControls(controlTarget) == false) goto L33;
        return false;
    L33:
        if (getLeash(controlTarget) != null) goto L36;
        return false;
    L36:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_IME_enabled[0] == false) goto L43;
        String protoLogParam0 = String.valueOf(dcTarget.getWindow().getName());
        if (this.mImeRequester.getWindow() != null) goto L40;
        Object r5 = this.mImeRequester;
    L41:
        String protoLogParam1 = String.valueOf(r5);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_IME, -6629998049460863403L, 0, new Object[]{protoLogParam0, protoLogParam1});
        goto L43
    L40:
        r5 = this.mImeRequester.getWindow().getName();
    L43:
        if (isImeLayeringTarget(this.mImeRequester, dcTarget) == false) goto L45;
    L52:
        return true;
    L45:
        if (isAboveImeLayeringTarget(this.mImeRequester, dcTarget) == true) goto L52;
        if (isImeFallbackTarget(this.mImeRequester) == true) goto L52;
        if (isImeInputTarget(this.mImeRequester) == true) goto L52;
        if (sameAsImeControlTarget(this.mImeRequester) == true) goto L52;
        return false;
    L56:
        throw new IllegalArgumentException("IME insets must be provided by a window.");
    }

    void receiveImeStatsToken(boolean visible, ImeTracker.Token statsToken) {
        if (this.mStatsToken == null) goto L6;
        logIsScheduledAndReadyToShowIme(!visible);
    L6:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_IME_enabled[0] == false) goto L9;
        String protoLogParam0 = String.valueOf(visible);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_IME, -3621505756666186421L, 0, new Object[]{protoLogParam0});
    L9:
        if (visible == false) goto L11;
        ImeTracker.forLogging().onCancelled(this.mStatsToken, 43);
        this.mStatsToken = statsToken;
        return;
    L11:
        ImeTracker.forLogging().onFailed(this.mStatsToken, 43);
        this.mStatsToken = null;
    }

    private void logIsScheduledAndReadyToShowIme(boolean aborted) {
        if (this.mWindowContainer == null) goto L5;
        WindowState windowState = this.mWindowContainer.asWindowState();
    L6:
        boolean hasLeash = false;
        InsetsControlTarget dcTarget = this.mDisplayContent.getImeTarget(0);
        InsetsControlTarget controlTarget = getControlTarget();
        StringBuilder sb = new StringBuilder();
        sb.append("showImePostLayout ");
        if (aborted == false) goto L9;
        String r5 = "aborted";
    L10:
        sb.append(r5);
        sb.append(", isScheduledAndReadyToShowIme: ");
        sb.append(isScheduledAndReadyToShowIme());
        sb.append(", mImeRequester: ");
        sb.append(this.mImeRequester);
        sb.append(", serverVisible: ");
        sb.append(this.mServerVisible);
        sb.append(", frozen: ");
        sb.append(this.mFrozen);
        sb.append(", mWindowContainer is: ");
        String r6 = "null";
        if (this.mWindowContainer == null) goto L13;
        String r7 = "non-null";
    L14:
        sb.append(r7);
        sb.append(", windowState: ");
        sb.append(windowState);
        if (windowState == null) goto L17;
        sb.append(", isDrawn: ");
        sb.append(windowState.isDrawn());
        sb.append(", mGivenInsetsPending: ");
        sb.append(windowState.mGivenInsetsPending);
    L17:
        sb.append(", dcTarget: ");
        sb.append(dcTarget);
        sb.append(", controlTarget: ");
        sb.append(controlTarget);
        if (this.mImeRequester == null) goto L39;
        if (dcTarget == null) goto L39;
        if (controlTarget == null) goto L39;
        sb.append("\n");
        sb.append("controlTarget == DisplayContent.controlTarget: ");
        if (controlTarget != this.mDisplayContent.getImeTarget(2)) goto L24;
        boolean r8 = true;
    L25:
        sb.append(r8);
        sb.append(", hasPendingControls: ");
        sb.append(this.mStateController.hasPendingControls(controlTarget));
        if (getLeash(controlTarget) == null) goto L28;
        hasLeash = true;
    L28:
        sb.append(", leash is: ");
        if (hasLeash == false) goto L31;
        String r9 = "non-null";
    L32:
        sb.append(r9);
        if (hasLeash == true) goto L38;
        sb.append(", control is: ");
        if (this.mControl == null) goto L37;
        r6 = "non-null";
    L37:
        sb.append(r6);
        sb.append(", mIsLeashInitialized: ");
        sb.append(this.mIsLeashInitialized);
    L38:
        sb.append(", isImeLayeringTarget: ");
        sb.append(isImeLayeringTarget(this.mImeRequester, dcTarget));
        sb.append(", isAboveImeLayeringTarget: ");
        sb.append(isAboveImeLayeringTarget(this.mImeRequester, dcTarget));
        sb.append(", isImeFallbackTarget: ");
        sb.append(isImeFallbackTarget(this.mImeRequester));
        sb.append(", isImeInputTarget: ");
        sb.append(isImeInputTarget(this.mImeRequester));
        sb.append(", sameAsImeControlTarget: ");
        sb.append(sameAsImeControlTarget(this.mImeRequester));
        goto L39
    L31:
        r9 = "null";
        goto L32
    L24:
        r8 = false;
    L39:
        Slog.d(TAG, sb.toString());
        return;
    L13:
        r7 = "null";
        goto L14
    L9:
        r5 = "cancelled";
        goto L10
    L5:
        windowState = null;
        goto L6
    }

    private static boolean isImeLayeringTarget(InsetsControlTarget target, InsetsControlTarget dcTarget) {
        if (isImeTargetWindowClosing(dcTarget.getWindow()) == true) goto L6;
        if (target != dcTarget) goto L6;
        return true;
    L6:
        return false;
    }

    private static boolean isAboveImeLayeringTarget(InsetsControlTarget target, InsetsControlTarget dcTarget) {
        if (target.getWindow() != null) goto L5;
    L9:
        return false;
    L5:
        if (dcTarget.getWindow().getParentWindow() != target) goto L9;
        if (dcTarget.getWindow().mSubLayer <= target.getWindow().mSubLayer) goto L9;
        return true;
    }

    private boolean isImeFallbackTarget(InsetsControlTarget target) {
        if (target != this.mDisplayContent.getImeFallback()) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isImeInputTarget(InsetsTarget target) {
        if (target != this.mDisplayContent.getImeInputTarget()) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean sameAsImeControlTarget(InsetsControlTarget target) {
        InsetsControlTarget controlTarget = getControlTarget();
        if (controlTarget == target) goto L5;
    L9:
        return false;
    L5:
        if (target.getWindow() != null) goto L7;
    L8:
        return true;
    L7:
        if (isImeTargetWindowClosing(target.getWindow()) == true) goto L9;
        goto L8
    }

    private static boolean isImeTargetWindowClosing(WindowState win) {
        if (win.mAnimatingExit == false) goto L5;
    L14:
        return true;
    L5:
        if (win.mActivityRecord != null) goto L7;
    L13:
        return false;
    L7:
        if (win.mActivityRecord.isInTransition() == false) goto L11;
        if (win.mActivityRecord.isVisibleRequested() == false) goto L14;
    L11:
        if (win.mActivityRecord.willCloseOrEnterPip() == false) goto L13;
        goto L13
    }

    private boolean isTargetChangedWithinActivity(InsetsControlTarget target) {
        if (target.getWindow() != null) goto L6;
        return false;
    L6:
        if (this.mImeRequester != target) goto L8;
        return false;
    L8:
        if (this.mImeRequester != null) goto L10;
        return false;
    L10:
        if (this.mImeRequester.getWindow() != null) goto L12;
        return false;
    L12:
        if (this.mImeRequester.getWindow().mActivityRecord != target.getWindow().mActivityRecord) goto L19;
        return true;
    L19:
        return false;
    }

    @Override // com.android.server.wm.InsetsSourceProvider
    public void dump(PrintWriter pw, String prefix) {
        super.dump(pw, prefix);
        String prefix2 = prefix + "  ";
        pw.print(prefix2);
        pw.print("mImeShowing=");
        pw.print(this.mImeShowing);
        pw.print(" mLastDrawn=");
        pw.print(this.mLastDrawn);
        if (this.mImeRequester == null) goto L5;
        pw.print(prefix2);
        pw.print("showImePostLayout pending for mImeRequester=");
        pw.print(this.mImeRequester);
        pw.println();
    L6:
        pw.println();
        return;
    L5:
        pw.print(prefix2);
        pw.print("showImePostLayout not scheduled, mImeRequester=null");
        pw.println();
        goto L6
    }

    @Override // com.android.server.wm.InsetsSourceProvider
    void dumpDebug(ProtoOutputStream proto, long fieldId, int logLevel) {
        long token = proto.start(fieldId);
        super.dumpDebug(proto, 1146756268033L, logLevel);
        if (this.mImeRequester == null) goto L5;
        WindowState imeRequesterWindow = this.mImeRequester.getWindow();
    L6:
        if (imeRequesterWindow == null) goto L8;
        imeRequesterWindow.writeIdentifierToProto(proto, 1146756268036L);
    L8:
        proto.end(token);
        return;
    L5:
        imeRequesterWindow = null;
        goto L6
    }

    public void setImeShowing(boolean imeShowing) {
        this.mImeShowing = imeShowing;
    }

    public boolean isImeShowing() {
        return this.mImeShowing;
    }
}
