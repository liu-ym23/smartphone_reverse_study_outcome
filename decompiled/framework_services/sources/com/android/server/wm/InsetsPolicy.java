package com.android.server.wm;

import android.R;
import android.app.StatusBarManager;
import android.app.WindowConfiguration;
import android.content.ComponentName;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.IBinder;
import android.pico.utils.ExtImplFactory;
import android.pico.utils.Features;
import android.util.LostModeUtil;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Utils;
import android.view.InsetsController;
import android.view.InsetsFrameProvider;
import android.view.InsetsSource;
import android.view.InsetsState;
import android.view.SurfaceControl;
import android.view.SyncRtSurfaceTransactionApplier;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowManager;
import android.view.inputmethod.ImeTracker;
import android.view.inputmethod.InputMethodManager;
import com.android.server.LocalServices;
import com.android.server.common.Constants;
import com.android.server.common.IGameAssistSerivce;
import com.android.server.statusbar.StatusBarManagerInternal;
import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class InsetsPolicy {
    public static final int CONTROLLABLE_TYPES = 0;
    private final DisplayContent mDisplayContent;
    protected IExtInsetsPolicy mExt;
    private InsetsControlTarget mFakeNavControlTarget;
    private InsetsControlTarget mFakeStatusControlTarget;
    private WindowState mFocusedWin;
    private int mForcedShowingTypes;
    private final boolean mHideNavBarForKeyboard;
    private final BarWindow mNavBar;
    private final InsetsControlTarget mPermanentControlTarget;
    protected final DisplayPolicy mPolicy;
    private int mShowingTransientTypes;
    protected final InsetsStateController mStateController;
    private final BarWindow mStatusBar;
    private final InsetsControlTarget mTransientControlTarget;

    private class BarWindow {
        private final int mId;
        private int mState;
        final /* synthetic */ InsetsPolicy this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmState, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m10011$$Nest$fgetmState(BarWindow r0) {
            return r0.mState;
        }

        /* JADX INFO: renamed from: -$$Nest$mupdateVisibility, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10012$$Nest$mupdateVisibility(BarWindow r0, InsetsControlTarget r1, int r2) {
            r0.updateVisibility(r1, r2);
        }

        BarWindow(InsetsPolicy r1, int id) {
            this.this$0 = r1;
            this.mState = 0;
            this.mId = id;
        }

        private void updateVisibility(InsetsControlTarget controlTarget, int type) {
            boolean r1 = true;
            if (type != WindowInsets.Type.statusBars()) goto L17;
            if (controlTarget != null) goto L6;
        L9:
            int state = 0;
        L11:
            if (state == this.mState) goto L17;
            StringBuilder r3 = new StringBuilder();
            r3.append("updateVisibility: ");
            r3.append(controlTarget);
            r3.append(", visible: ");
            if (state != 0) goto L15;
            boolean r4 = true;
        L16:
            r3.append(r4);
            Slog.i("InsetPolicy", r3.toString());
            goto L17
        L15:
            r4 = false;
            goto L16
        L6:
            if (controlTarget.isRequestedVisible(type) == true) goto L9;
            state = 2;
        L17:
            if (controlTarget != null) goto L19;
        L22:
            setVisible(r1);
            return;
        L19:
            if (controlTarget.isRequestedVisible(type) == true) goto L22;
            r1 = false;
            goto L22
        }

        private void setVisible(boolean visible) {
            if (visible == false) goto L4;
            int state = 0;
        L6:
            if (this.mState == state) goto L21;
            this.mState = state;
            StatusBarManagerInternal statusBarManagerInternal = this.this$0.mPolicy.getStatusBarManagerInternal();
            if (statusBarManagerInternal == null) goto L11;
            statusBarManagerInternal.setWindowState(InsetsPolicy.m10010$$Nest$fgetmDisplayContent(this.this$0).getDisplayId(), this.mId, state);
        L11:
            if (Constants.ENABLE_GAME_ASSIST == true) goto L13;
            return;
        L13:
            if (InsetsPolicy.m10010$$Nest$fgetmDisplayContent(this.this$0).getDisplayId() == 0) goto L15;
            return;
        L15:
            if (1 != this.mId) goto L24;
            if (visible == false) goto L18;
            String actionName = "statusbar_show";
        L19:
            ((IGameAssistSerivce) LocalServices.getService(IGameAssistSerivce.class)).sendToGameAssistServices(actionName);
            return;
        L18:
            actionName = "statusbar_hide";
            goto L19
        L24:
            return;
        L21:
            return;
        L4:
            state = 2;
            goto L6
        }
    }

    private static class ControlTarget implements InsetsControlTarget, Runnable {
        private final Object mGlobalLock;
        private final Handler mHandler;
        private final InsetsController mInsetsController;
        private final String mName;
        private final InsetsState mState;
        private final InsetsStateController mStateController;

        ControlTarget(DisplayContent displayContent, String name) {
            this.mState = new InsetsState();
            this.mHandler = displayContent.mWmService.mH;
            this.mGlobalLock = displayContent.mWmService.mGlobalLock;
            this.mStateController = displayContent.getInsetsStateController();
            this.mInsetsController = new InsetsController(new Host(this.mHandler, name));
            this.mName = name;
        }

        @Override // com.android.server.wm.InsetsControlTarget
        public void notifyInsetsControlChanged(int displayId) {
            this.mHandler.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r0 = this.mGlobalLock;
            monitor-enter(r0);
            this.mState.set(this.mStateController.getRawInsetsState(), true);     // Catch: Throwable -> L7
            this.mInsetsController.onStateChanged(this.mState);     // Catch: Throwable -> L7
            this.mInsetsController.onControlsChanged(this.mStateController.getControlsForDispatch(this));     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public String toString() {
            return this.mName;
        }
    }

    private static class Host implements InsetsController.Host {
        private final Handler mHandler;
        private final String mName;
        private final float[] mTmpFloat9;

        Host(Handler handler, String name) {
            this.mTmpFloat9 = new float[9];
            this.mHandler = handler;
            this.mName = name;
        }

        public Handler getHandler() {
            return this.mHandler;
        }

        public void notifyInsetsChanged() {
        }

        public void dispatchWindowInsetsAnimationPrepare(WindowInsetsAnimation animation) {
        }

        public WindowInsetsAnimation.Bounds dispatchWindowInsetsAnimationStart(WindowInsetsAnimation animation, WindowInsetsAnimation.Bounds bounds) {
            return bounds;
        }

        public WindowInsets dispatchWindowInsetsAnimationProgress(WindowInsets insets, List<WindowInsetsAnimation> runningAnimations) {
            return insets;
        }

        public void dispatchWindowInsetsAnimationEnd(WindowInsetsAnimation animation) {
        }

        public void applySurfaceParams(SyncRtSurfaceTransactionApplier.SurfaceParams... p) {
            SurfaceControl.Transaction t = new SurfaceControl.Transaction();
            int i = p.length - 1;
        L3:
            if (i < 0) goto L5;
            SyncRtSurfaceTransactionApplier.applyParams(t, p[i], this.mTmpFloat9);
            i = i - 1;
            goto L3
        L5:
            t.apply();
            t.close();
        }

        public void updateRequestedVisibleTypes(int types, ImeTracker.Token statsToken) {
        }

        public boolean hasAnimationCallbacks() {
            return false;
        }

        public void setSystemBarsAppearance(int appearance, int mask) {
        }

        public int getSystemBarsAppearance() {
            return 0;
        }

        public void setSystemBarsBehavior(int behavior) {
        }

        public int getSystemBarsBehavior() {
            return 2;
        }

        public void releaseSurfaceControlFromRt(SurfaceControl surfaceControl) {
            surfaceControl.release();
        }

        public void addOnPreDrawRunnable(Runnable r) {
        }

        public void postInsetsAnimationCallback(Runnable r) {
        }

        public InputMethodManager getInputMethodManager() {
            return null;
        }

        public String getRootViewTitle() {
            return this.mName;
        }

        public int dipToPx(int dips) {
            return 0;
        }

        public IBinder getWindowToken() {
            return null;
        }

        public void forceRelayout() {
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayContent, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayContent m10010$$Nest$fgetmDisplayContent(InsetsPolicy r0) {
        return r0.mDisplayContent;
    }

    static {
        CONTROLLABLE_TYPES = (WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars()) | WindowInsets.Type.ime();
    }

    InsetsPolicy(InsetsStateController stateController, DisplayContent displayContent) {
        this.mStatusBar = new BarWindow(this, 1);
        this.mNavBar = new BarWindow(this, 2);
        this.mExt = (IExtInsetsPolicy) ExtImplFactory.getImpl(IExtInsetsPolicy.class, new Object[]{this});
        this.mStateController = stateController;
        this.mDisplayContent = displayContent;
        this.mPolicy = displayContent.getDisplayPolicy();
        Resources r = this.mPolicy.getContext().getResources();
        this.mHideNavBarForKeyboard = r.getBoolean(R.bool.config_intrusiveNotificationLed);
        this.mTransientControlTarget = new ControlTarget(displayContent, "TransientControlTarget");
        this.mPermanentControlTarget = new ControlTarget(displayContent, "PermanentControlTarget");
    }

    void updateBarControlTarget(WindowState focusedWin) {
        if (this.mFocusedWin == focusedWin) goto L5;
        abortTransient();
    L5:
        this.mFocusedWin = focusedWin;
        if (focusedWin == null) goto L8;
        int r1 = focusedWin.getRequestedVisibleTypes();
    L9:
        int[] requestedVisibleTypes = {r1};
        WindowState notificationShade = this.mPolicy.getNotificationShade();
        WindowState topApp = this.mPolicy.getTopFullscreenOpaqueWindow();
        this.mExt.updateStatusBarHidingTaskForHomeTransition(topApp, this.mPolicy.topAppHidesSystemBar(WindowInsets.Type.statusBars()), this.mShowingTransientTypes);
        InsetsControlTarget statusControlTarget = getStatusControlTarget(focusedWin, false, requestedVisibleTypes);
        InsetsControlTarget r6 = null;
        if (statusControlTarget != this.mTransientControlTarget) goto L12;
        InsetsControlTarget r5 = getStatusControlTarget(focusedWin, true, requestedVisibleTypes);
    L15:
        this.mFakeStatusControlTarget = r5;
        InsetsControlTarget navControlTarget = getNavControlTarget(focusedWin, false, requestedVisibleTypes);
        if (navControlTarget != this.mTransientControlTarget) goto L18;
        r6 = getNavControlTarget(focusedWin, true, requestedVisibleTypes);
    L21:
        this.mFakeNavControlTarget = r6;
        this.mStateController.onBarControlTargetChanged(statusControlTarget, this.mFakeStatusControlTarget, navControlTarget, this.mFakeNavControlTarget);
        if (statusControlTarget == this.mDisplayContent.mRemoteInsetsControlTarget) goto L24;
    L26:
        BarWindow.m10012$$Nest$mupdateVisibility(this.mStatusBar, statusControlTarget, WindowInsets.Type.statusBars());
        BarWindow.m10012$$Nest$mupdateVisibility(this.mNavBar, navControlTarget, WindowInsets.Type.navigationBars());
        return;
    L24:
        if (navControlTarget != this.mDisplayContent.mRemoteInsetsControlTarget) goto L26;
        notifyRemoteInsetsController(focusedWin, requestedVisibleTypes[0]);
        goto L26
    L18:
        if (navControlTarget != notificationShade) goto L21;
        r6 = getNavControlTarget(topApp, true, requestedVisibleTypes);
        goto L21
    L12:
        if (statusControlTarget != notificationShade) goto L14;
        r5 = getStatusControlTarget(topApp, true, requestedVisibleTypes);
        goto L15
    L14:
        r5 = null;
        goto L15
    L8:
        r1 = 0;
        goto L9
    }

    boolean hasHiddenSources(int types) {
        InsetsState state = this.mStateController.getRawInsetsState();
        int i = state.sourceSize() - 1;
    L3:
        if (i < 0) goto L13;
        InsetsSource source = state.sourceAt(i);
        if ((source.getType() & types) == 0) goto L12;
        if (source.getFrame().isEmpty() == true) goto L12;
        if (source.isVisible() == true) goto L12;
        return true;
    L12:
        i = i - 1;
        goto L3
    L13:
        return false;
    }

    void showTransient(int types, boolean isGestureOnSystemBar) {
        int showingTransientTypes = this.mShowingTransientTypes;
        InsetsState rawState = this.mStateController.getRawInsetsState();
        boolean lostMode = LostModeUtil.beingLostModeEnabled(this.mPolicy.getContext());
        boolean r4 = true;
        int i = rawState.sourceSize() - 1;
    L3:
        if (i < 0) goto L18;
        InsetsSource source = rawState.sourceAt(i);
        if (source.isVisible() == true) goto L17;
        int type = source.getType();
        if ((source.getType() & types) == 0) goto L17;
        if (lostMode == true) goto L12;
    L16:
        showingTransientTypes = showingTransientTypes | type;
        goto L17
    L12:
        if (type == WindowInsets.Type.statusBars()) goto L17;
        if (type != WindowInsets.Type.navigationBars()) goto L16;
    L17:
        i = i - 1;
        goto L3
    L18:
        int i2 = this.mShowingTransientTypes;
        if (i2 == showingTransientTypes) goto L35;
        this.mShowingTransientTypes = showingTransientTypes;
        StatusBarManagerInternal statusBarManagerInternal = this.mPolicy.getStatusBarManagerInternal();
        if (statusBarManagerInternal == null) goto L23;
        statusBarManagerInternal.showTransient(this.mDisplayContent.getDisplayId(), showingTransientTypes, isGestureOnSystemBar);
    L23:
        updateBarControlTarget(this.mFocusedWin);
        WindowState r5 = this.mFocusedWin;
        if (((WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars()) & showingTransientTypes) != 0) goto L27;
        r4 = false;
    L27:
        dispatchTransientSystemBarsVisibilityChanged(r5, r4, isGestureOnSystemBar);
        return;
    }

    InsetsControlTarget getTransientControlTarget() {
        return this.mTransientControlTarget;
    }

    InsetsControlTarget getPermanentControlTarget() {
        return this.mPermanentControlTarget;
    }

    void hideTransient() {
        if (this.mShowingTransientTypes != 0) goto L5;
        return;
    L5:
        dispatchTransientSystemBarsVisibilityChanged(this.mFocusedWin, false, false);
        this.mShowingTransientTypes = 0;
        updateBarControlTarget(this.mFocusedWin);
    }

    boolean isTransient(int type) {
        if ((this.mShowingTransientTypes & type) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    InsetsState adjustInsetsForWindow(WindowState target, InsetsState originalState, boolean includesTransient) {
        if (includesTransient == true) goto L4;
        InsetsState state = adjustVisibilityForFakeControllingSources(originalState);
    L5:
        boolean r1 = false;
        if (state != originalState) goto L8;
        boolean r3 = true;
    L9:
        InsetsState state2 = adjustVisibilityForIme(target, state, r3);
        DisplayPolicy r4 = this.mPolicy;
        if (state2 != originalState) goto L12;
        boolean r5 = true;
    L13:
        InsetsState state3 = r4.replaceInsetsSourcesIfNeeded(state2, r5);
        this.mPolicy.getObricExt().adjustInsetsForWindow(target, state3);
        InsetsState state4 = this.mPolicy.getExt().adjustInsetsForWindow(target, state3);
        WindowToken r6 = target.mToken;
        if (state4 != originalState) goto L17;
        r1 = true;
    L17:
        return adjustInsetsForRoundedCorners(r6, state4, r1);
    L12:
        r5 = false;
        goto L13
    L8:
        r3 = false;
        goto L9
    L4:
        state = originalState;
        goto L5
    }

    InsetsState adjustInsetsForWindow(WindowState target, InsetsState originalState) {
        return adjustInsetsForWindow(target, originalState, false);
    }

    void getInsetsForWindowMetrics(WindowToken token, InsetsState outInsetsState) {
        if (token != null) goto L4;
    L6:
        InsetsState srcState = this.mStateController.getRawInsetsState();
    L7:
        outInsetsState.set(srcState, true);
        int i = outInsetsState.sourceSize() - 1;
    L9:
        if (i < 0) goto L14;
        InsetsSource source = outInsetsState.sourceAt(i);
        if (isTransient(source.getType()) == false) goto L13;
        source.setVisible(false);
    L13:
        i = i - 1;
        goto L9
    L14:
        adjustInsetsForRoundedCorners(token, outInsetsState, false);
        if (token != null) goto L17;
        return;
    L17:
        if (token.hasSizeCompatBounds() == false) goto L24;
        outInsetsState.scale(1.0f / token.getCompatScale());
        return;
    L24:
        return;
    L4:
        if (token.isFixedRotationTransforming() == false) goto L6;
        srcState = token.getFixedRotationTransformInsetsState();
        goto L7
    }

    InsetsState enforceInsetsPolicyForTarget(WindowState target, InsetsState state) {
        WindowManager.LayoutParams attrs = target.mAttrs;
        if (attrs.type != 2011) goto L6;
        state = new InsetsState(state);
        state.removeSource(InsetsSource.ID_IME);
    L18:
        if (attrs.isFullscreen() == true) goto L20;
    L21:
        if (state != state) goto L23;
        state = new InsetsState(state);
    L23:
        int i = state.sourceSize() - 1;
    L24:
        if (i < 0) goto L29;
        if (state.sourceAt(i).getType() != WindowInsets.Type.captionBar()) goto L28;
        state.removeSourceAt(i);
    L28:
        i = i - 1;
    L29:
        SparseArray<InsetsSourceProvider> providers = this.mStateController.getSourceProviders();
        int windowType = attrs.type;
        int i2 = providers.size() - 1;
    L30:
        if (i2 < 0) goto L37;
        InsetsSourceProvider otherProvider = providers.valueAt(i2);
        if (otherProvider.overridesFrame(windowType) == false) goto L36;
        if (state != state) goto L35;
        state = new InsetsState(state);
    L35:
        InsetsSource override = new InsetsSource(otherProvider.getSource());
        override.setFrame(otherProvider.getOverriddenFrame(windowType));
        state.addSource(override);
    L36:
        i2 = i2 - 1;
        goto L30
    L37:
        int windowingMode = target.getWindowingMode();
        if (WindowConfiguration.isFloating(windowingMode) == false) goto L40;
    L43:
        int types = WindowInsets.Type.captionBar();
        if (windowingMode == 2) goto L53;
        if (this.mDisplayContent == null) goto L53;
        if (target != this.mDisplayContent.getImeInputTarget()) goto L53;
        if ((WindowInsets.Type.ime() & target.getRequestedVisibleTypes()) == 0) goto L53;
        types = types | WindowInsets.Type.ime();
    L53:
        if (Features.FEAT_QUICK_WIN == true) goto L55;
    L57:
        InsetsState newState = new InsetsState();
        newState.set(state, types);
        return newState;
    L55:
        if (windowingMode != 5) goto L57;
        types = types | WindowInsets.Type.statusBars();
        goto L57
    L40:
        if (windowingMode == 6) goto L42;
        return state;
    L42:
        if (target.isAlwaysOnTop() == true) goto L43;
        return state;
    L20:
        if (attrs.getFitInsetsTypes() == 0) goto L29;
    L6:
        if (attrs.providedInsets == null) goto L18;
        InsetsFrameProvider[] r2 = attrs.providedInsets;
        int r3 = r2.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L18;
        InsetsFrameProvider provider = r2[r4];
        if ((provider.getType() & WindowInsets.Type.systemBars()) == 0) goto L16;
        if (state != state) goto L15;
        state = new InsetsState(state);
    L15:
        state.removeSource(provider.getId());
    L16:
        r4 = r4 + 1;
        goto L9
    }

    private InsetsState adjustVisibilityForFakeControllingSources(InsetsState originalState) {
        if (this.mFakeStatusControlTarget == null) goto L5;
    L7:
        InsetsState state = originalState;
        int i = state.sourceSize() - 1;
    L8:
        if (i < 0) goto L11;
        InsetsSource source = state.sourceAt(i);
        state = adjustVisibilityForFakeControllingSource(adjustVisibilityForFakeControllingSource(state, WindowInsets.Type.statusBars(), source, this.mFakeStatusControlTarget), WindowInsets.Type.navigationBars(), source, this.mFakeNavControlTarget);
        i = i - 1;
        goto L8
    L11:
        return state;
    L5:
        if (this.mFakeNavControlTarget != null) goto L7;
        return originalState;
    }

    private static InsetsState adjustVisibilityForFakeControllingSource(InsetsState originalState, int type, InsetsSource source, InsetsControlTarget target) {
        if (source.getType() != type) goto L11;
        if (target == null) goto L11;
        boolean isRequestedVisible = target.isRequestedVisible(type);
        if (source.isVisible() != isRequestedVisible) goto L9;
        return originalState;
    L9:
        InsetsState state = new InsetsState(originalState);
        InsetsSource outSource = new InsetsSource(source);
        outSource.setVisible(isRequestedVisible);
        state.addSource(outSource);
        return state;
    L11:
        return originalState;
    }

    private InsetsState adjustVisibilityForIme(WindowState w, InsetsState originalState, boolean copyState) {
        if (w.mIsImWindow == false) goto L19;
        InsetsState state = originalState;
        boolean navVisible = !this.mHideNavBarForKeyboard;
        int i = originalState.sourceSize() - 1;
    L5:
        if (i < 0) goto L17;
        InsetsSource source = originalState.sourceAt(i);
        if (source.getType() != WindowInsets.Type.navigationBars()) goto L15;
        if (source.isVisible() == navVisible) goto L15;
        if (state != originalState) goto L14;
        if (copyState == false) goto L14;
        state = new InsetsState(originalState);
    L14:
        InsetsSource navSource = new InsetsSource(source);
        navSource.setVisible(navVisible);
        state.addSource(navSource);
    L15:
        i = i - 1;
        goto L5
    L17:
        return state;
    L19:
        if (w.mImeInsetsConsumed == false) goto L31;
        InsetsSource originalImeSource = originalState.peekSource(InsetsSource.ID_IME);
        if (originalImeSource != null) goto L23;
    L41:
        return originalState;
    L23:
        if (originalImeSource.isVisible() == false) goto L41;
        if (copyState == false) goto L26;
        InsetsState state2 = new InsetsState(originalState);
    L27:
        InsetsSource imeSource = new InsetsSource(originalImeSource);
        imeSource.setVisible(false);
        state2.addSource(imeSource);
        return state2;
    L26:
        state2 = originalState;
        goto L27
    L31:
        if ((w.mMergedExcludeInsetsTypes & WindowInsets.Type.ime()) == 0) goto L41;
        InsetsSource originalImeSource2 = originalState.peekSource(InsetsSource.ID_IME);
        if (originalImeSource2 == null) goto L41;
        if (originalImeSource2.isVisible() == false) goto L41;
        if (copyState == false) goto L38;
        InsetsState state3 = new InsetsState(originalState);
    L39:
        InsetsSource imeSource2 = new InsetsSource(originalImeSource2);
        imeSource2.setFrame(0, 0, 0, 0);
        imeSource2.setVisibleFrame(imeSource2.getFrame());
        state3.addSource(imeSource2);
        return state3;
    L38:
        state3 = originalState;
        goto L39
    }

    private InsetsState adjustInsetsForRoundedCorners(WindowToken token, InsetsState originalState, boolean copyState) {
        if (token == null) goto L19;
        ActivityRecord activityRecord = token.asActivityRecord();
        if (activityRecord == null) goto L6;
        Task task = activityRecord.getTask();
    L7:
        if (task == null) goto L19;
        if (task.getWindowConfiguration().tasksAreFloating() == true) goto L19;
        if (copyState == false) goto L12;
        InsetsState state = new InsetsState(originalState);
    L14:
        if (token.isFixedRotationTransforming() == false) goto L16;
        Rect r3 = token.getFixedRotationTransformDisplayBounds();
    L17:
        state.setRoundedCornerFrame(r3);
        return state;
    L16:
        r3 = task.getBounds();
        goto L17
    L12:
        state = originalState;
        goto L14
    L6:
        task = null;
    L19:
        return originalState;
    }

    void onRequestedVisibleTypesChanged(InsetsTarget caller, int changedTypes, ImeTracker.Token statsToken) {
        this.mPolicy.getObricExt().adjustImeInAuto(caller, changedTypes);
        this.mStateController.onRequestedVisibleTypesChanged(caller, changedTypes, statsToken);
        checkAbortTransient(caller);
        updateBarControlTarget(this.mFocusedWin);
    }

    private void checkAbortTransient(InsetsTarget caller) {
        if (this.mShowingTransientTypes != 0) goto L5;
        return;
    L5:
        boolean isImeVisible = this.mStateController.getImeSourceProvider().isClientVisible();
        int fakeControllingTypes = this.mStateController.getFakeControllingTypes(caller);
        int r2 = caller.getRequestedVisibleTypes() & fakeControllingTypes;
        if (isImeVisible == false) goto L8;
        int r3 = WindowInsets.Type.navigationBars();
    L9:
        int abortTypes = r2 | r3;
        this.mShowingTransientTypes &= ~abortTypes;
        if (abortTypes == 0) goto L15;
        this.mDisplayContent.setLayoutNeeded();
        this.mDisplayContent.mWmService.requestTraversal();
        StatusBarManagerInternal statusBarManager = this.mPolicy.getStatusBarManagerInternal();
        if (statusBarManager == null) goto L16;
        statusBarManager.abortTransient(this.mDisplayContent.getDisplayId(), abortTypes);
        return;
    L16:
        return;
    L15:
        return;
    L8:
        r3 = 0;
        goto L9
    }

    private void abortTransient() {
        if (this.mShowingTransientTypes != 0) goto L5;
        return;
    L5:
        StatusBarManagerInternal statusBarManager = this.mPolicy.getStatusBarManagerInternal();
        if (statusBarManager == null) goto L8;
        statusBarManager.abortTransient(this.mDisplayContent.getDisplayId(), this.mShowingTransientTypes);
    L8:
        this.mShowingTransientTypes = 0;
        this.mDisplayContent.setLayoutNeeded();
        this.mDisplayContent.mWmService.requestTraversal();
        dispatchTransientSystemBarsVisibilityChanged(this.mFocusedWin, false, false);
    }

    private InsetsControlTarget getStatusControlTarget(WindowState focusedWin, boolean fake, int[] requestedVisibleTypes) {
        InsetsControlTarget target = getStatusControlTargetInner(focusedWin, fake);
        if (remoteInsetsControllerControlsSystemBars(target) == false) goto L6;
        requestedVisibleTypes[0] = (requestedVisibleTypes[0] & (~WindowInsets.Type.statusBars())) | (target.getRequestedVisibleTypes() & WindowInsets.Type.statusBars());
        return this.mDisplayContent.mRemoteInsetsControlTarget;
    L6:
        return target;
    }

    private InsetsControlTarget getStatusControlTargetInner(WindowState focusedWin, boolean fake) {
        if (fake == false) goto L4;
    L7:
        WindowState notificationShade = this.mPolicy.getNotificationShade();
        if (focusedWin != notificationShade) goto L11;
        return focusedWin;
    L11:
        if (areTypesForciblyShowing(WindowInsets.Type.statusBars()) == false) goto L17;
        if (this.mPolicy.getExt().ignoreForceShowSystemBarsInLandscapeSplit() == true) goto L17;
        return this.mPermanentControlTarget;
    L17:
        if (this.mPolicy.areTypesForciblyShownTransiently(WindowInsets.Type.statusBars()) == false) goto L21;
        if (fake == true) goto L21;
        return this.mTransientControlTarget;
    L21:
        InsetsControlTarget splitTarget = this.mPolicy.getExt().getStatusControlTargetInLandscapeSplit(focusedWin);
        if (splitTarget == null) goto L24;
        return splitTarget;
    L24:
        InsetsControlTarget homeTransitionTopApp = this.mExt.getStatusControlTargetForHomeTransition(focusedWin, isTransient(WindowInsets.Type.statusBars()), this.mShowingTransientTypes, this.mDisplayContent);
        if (homeTransitionTopApp == null) goto L28;
        return homeTransitionTopApp;
    L28:
        if (canBeTopFullscreenOpaqueWindow(focusedWin) == true) goto L37;
        if (this.mPolicy.topAppHidesSystemBar(WindowInsets.Type.statusBars()) == false) goto L37;
        if (notificationShade == null) goto L35;
        if (notificationShade.canReceiveKeys() == true) goto L37;
    L35:
        return this.mPolicy.getTopFullscreenOpaqueWindow();
    L37:
        if (Features.FEAT_QUICK_WIN == false) goto L43;
        if (focusedWin == null) goto L43;
        if (focusedWin.inFreeformWindowingMode() == false) goto L43;
        return this.mPolicy.getTopFullscreenOpaqueWindow();
    L43:
        return focusedWin;
    L4:
        if (isTransient(WindowInsets.Type.statusBars()) == false) goto L7;
        return this.mTransientControlTarget;
    }

    private static boolean canBeTopFullscreenOpaqueWindow(WindowState win) {
        if (win != null) goto L5;
    L9:
        boolean nonAttachedAppWindow = false;
    L10:
        if (nonAttachedAppWindow == true) goto L12;
        return false;
    L12:
        if (win.mAttrs.isFullscreen() == true) goto L14;
        return false;
    L14:
        if (win.isFullyTransparent() == false) goto L16;
        return false;
    L16:
        if (win.inMultiWindowMode() == false) goto L19;
        return false;
    L19:
        return true;
    L5:
        if (win.mAttrs.type < 1) goto L9;
        if (win.mAttrs.type > 99) goto L9;
        nonAttachedAppWindow = true;
        goto L10
    }

    private InsetsControlTarget getNavControlTarget(WindowState focusedWin, boolean fake, int[] requestedVisibleTypes) {
        InsetsControlTarget target = getNavControlTargetInner(focusedWin, fake);
        if (remoteInsetsControllerControlsSystemBars(target) == false) goto L6;
        requestedVisibleTypes[0] = (requestedVisibleTypes[0] & (~WindowInsets.Type.navigationBars())) | (target.getRequestedVisibleTypes() & WindowInsets.Type.navigationBars());
        return this.mDisplayContent.mRemoteInsetsControlTarget;
    L6:
        return target;
    }

    private InsetsControlTarget getNavControlTargetInner(WindowState focusedWin, boolean fake) {
        if (Features.isBytedanceOsImeEnabled() == false) goto L9;
        if (focusedWin == null) goto L6;
        String r0 = focusedWin.getOwningPackage();
    L8:
        if (Utils.isXtsPkg(r0) == true) goto L9;
    L17:
        if (fake == true) goto L23;
        if (isTransient(WindowInsets.Type.navigationBars()) == false) goto L23;
        return this.mTransientControlTarget;
    L23:
        if (focusedWin != this.mPolicy.getNotificationShade()) goto L25;
        return focusedWin;
    L25:
        if (focusedWin == null) goto L32;
        InsetsSourceProvider provider = focusedWin.getControllableInsetProvider();
        if (provider == null) goto L32;
        if (provider.getSource().getType() != WindowInsets.Type.navigationBars()) goto L32;
        return focusedWin;
    L32:
        if (areTypesForciblyShowing(WindowInsets.Type.navigationBars()) == false) goto L36;
        return this.mPermanentControlTarget;
    L36:
        if (this.mPolicy.areTypesForciblyShownTransiently(WindowInsets.Type.navigationBars()) == false) goto L40;
        if (fake == true) goto L40;
        return this.mTransientControlTarget;
    L40:
        WindowState notificationShade = this.mPolicy.getNotificationShade();
        if (canBeTopFullscreenOpaqueWindow(focusedWin) == true) goto L50;
        if (this.mPolicy.topAppHidesSystemBar(WindowInsets.Type.navigationBars()) == false) goto L50;
        if (notificationShade == null) goto L48;
        if (notificationShade.canReceiveKeys() == true) goto L50;
    L48:
        return this.mPolicy.getTopFullscreenOpaqueWindow();
    L50:
        if (Features.FEAT_QUICK_WIN == false) goto L57;
        if (focusedWin == null) goto L57;
        if (focusedWin.inFreeformWindowingMode() == false) goto L57;
        return this.mPolicy.getTopFullscreenOpaqueWindow();
    L57:
        if (this.mDisplayContent.mWmService.getObricExt().isAssistWindow(focusedWin) == true) goto L59;
        return focusedWin;
    L59:
        return this.mPolicy.getTopFullscreenOpaqueWindow();
    L6:
        r0 = "";
    L9:
        WindowState imeWin = this.mDisplayContent.mInputMethodWindow;
        if (imeWin == null) goto L17;
        if (imeWin.isVisible() == false) goto L17;
        if (this.mHideNavBarForKeyboard == true) goto L17;
        return this.mPermanentControlTarget;
    }

    private void notifyRemoteInsetsController(WindowState win, int requestVisibleTypes) {
        if (win != null) goto L5;
        return;
    L5:
        if (win.mActivityRecord == null) goto L7;
        ComponentName component = win.mActivityRecord.mActivityComponent;
    L8:
        this.mDisplayContent.mRemoteInsetsControlTarget.topFocusedWindowChanged(component, requestVisibleTypes);
        return;
    L7:
        component = null;
        goto L8
    }

    boolean areTypesForciblyShowing(int types) {
        if ((this.mForcedShowingTypes & types) != types) goto L5;
        return true;
    L5:
        return false;
    }

    void updateSystemBars(WindowState win, boolean inSplitScreenMode, boolean inNonFullscreenFreeformMode) {
        int r0 = 0;
        if (inSplitScreenMode == true) goto L10;
        if (inNonFullscreenFreeformMode == true) goto L10;
        if (forceShowingNavigationBars(win) == false) goto L9;
        int r1 = WindowInsets.Type.navigationBars();
    L11:
        this.mForcedShowingTypes = r1;
        if (this.mDisplayContent != null) goto L14;
    L16:
        int r2 = this.mForcedShowingTypes;
        if (remoteInsetsControllerControlsSystemBars(win) == false) goto L20;
        r0 = WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars();
    L20:
        int forcedConsumingTypes = r0 | r2;
        if (this.mDisplayContent != null) goto L23;
    L25:
        this.mStateController.setForcedConsumingTypes(forcedConsumingTypes);
        updateBarControlTarget(win);
        return;
    L23:
        if (this.mDisplayContent.getExt().shouldSkipStatusBarForceShowingAndConsuming() == false) goto L25;
        forcedConsumingTypes = forcedConsumingTypes & (~WindowInsets.Type.statusBars());
        goto L25
    L14:
        if (this.mDisplayContent.getExt().shouldSkipStatusBarForceShowingAndConsuming() == false) goto L16;
        this.mForcedShowingTypes &= ~WindowInsets.Type.statusBars();
        goto L16
    L9:
        r1 = 0;
    L10:
        r1 = WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars();
        goto L11
    }

    private boolean forceShowingNavigationBars(WindowState win) {
        if (this.mPolicy.isForceShowNavigationBarEnabled() == false) goto L8;
        if (win == null) goto L8;
        if (win.getActivityType() != 1) goto L8;
        return true;
    L8:
        return false;
    }

    boolean remoteInsetsControllerControlsSystemBars(InsetsControlTarget target) {
        if ((target instanceof WindowState) == false) goto L19;
        WindowState win = (WindowState) target;
        if (this.mPolicy.isRemoteInsetsControllerControllingSystemBars() == true) goto L8;
        return false;
    L8:
        if (this.mDisplayContent != null) goto L10;
    L18:
        return false;
    L10:
        if (this.mDisplayContent.mRemoteInsetsControlTarget == null) goto L18;
        if (win.mAttrs.type >= 1) goto L15;
        return false;
    L15:
        if (win.mAttrs.type <= 99) goto L17;
        return false;
    L17:
        return true;
    L19:
        return false;
    }

    private void dispatchTransientSystemBarsVisibilityChanged(WindowState focusedWindow, boolean areVisible, boolean wereRevealedFromSwipeOnSystemBar) {
        if (focusedWindow != null) goto L4;
        return;
    L4:
        Task task = focusedWindow.getTask();
        if (task != null) goto L7;
        return;
    L7:
        int taskId = task.mTaskId;
        if (taskId == (-1)) goto L10;
        boolean isValidTaskId = true;
    L11:
        if (isValidTaskId == true) goto L13;
        return;
    L13:
        this.mDisplayContent.mWmService.mTaskSystemBarsListenerController.dispatchTransientSystemBarVisibilityChanged(taskId, areVisible, wereRevealedFromSwipeOnSystemBar);
        return;
    L10:
        isValidTaskId = false;
        goto L11
    }

    void dump(String prefix, PrintWriter pw) {
        pw.println(prefix + "InsetsPolicy");
        String prefix2 = prefix + "  ";
        pw.println(prefix2 + "status: " + StatusBarManager.windowStateToString(BarWindow.m10011$$Nest$fgetmState(this.mStatusBar)));
        pw.println(prefix2 + "nav: " + StatusBarManager.windowStateToString(BarWindow.m10011$$Nest$fgetmState(this.mNavBar)));
        if (this.mShowingTransientTypes == 0) goto L6;
        pw.println(prefix2 + "mShowingTransientTypes=" + WindowInsets.Type.toString(this.mShowingTransientTypes));
    L6:
        if (this.mForcedShowingTypes == 0) goto L9;
        pw.println(prefix2 + "mForcedShowingTypes=" + WindowInsets.Type.toString(this.mForcedShowingTypes));
        return;
    }
}
