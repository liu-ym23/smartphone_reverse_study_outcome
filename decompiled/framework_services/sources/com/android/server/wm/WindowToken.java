package com.android.server.wm;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Debug;
import android.os.IBinder;
import android.util.proto.ProtoOutputStream;
import android.view.DisplayInfo;
import android.view.IExtWindowManager;
import android.view.InsetsState;
import android.view.SurfaceControl;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.server.common.Constants;
import com.android.server.dispatcher.SystemWindowManagerEventDispatcher;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
class WindowToken extends WindowContainer<WindowState> {
    private static final String TAG = "WindowManager";
    private boolean mClientVisible;
    private SurfaceControl mFixedRotationTransformLeash;
    private FixedRotationTransformState mFixedRotationTransformState;
    private final boolean mFromClientToken;
    boolean mIsExiting;
    final Bundle mOptions;
    final boolean mOwnerCanManageAppTokens;
    boolean mPersistOnEmpty;
    final boolean mRoundedCornerOverlay;
    private final Comparator<WindowState> mWindowComparator;
    boolean paused;
    String stringName;
    final IBinder token;
    final int windowType;

    static class Builder {
        private DisplayContent mDisplayContent;
        private boolean mFromClientToken;
        private Bundle mOptions;
        private boolean mOwnerCanManageAppTokens;
        private boolean mPersistOnEmpty;
        private boolean mRoundedCornerOverlay;
        private final WindowManagerService mService;
        private final IBinder mToken;
        private final int mType;

        Builder(WindowManagerService service, IBinder token, int type) {
            this.mService = service;
            this.mToken = token;
            this.mType = type;
        }

        Builder setPersistOnEmpty(boolean persistOnEmpty) {
            this.mPersistOnEmpty = persistOnEmpty;
            return this;
        }

        Builder setDisplayContent(DisplayContent dc) {
            this.mDisplayContent = dc;
            return this;
        }

        Builder setOwnerCanManageAppTokens(boolean ownerCanManageAppTokens) {
            this.mOwnerCanManageAppTokens = ownerCanManageAppTokens;
            return this;
        }

        Builder setRoundedCornerOverlay(boolean roundedCornerOverlay) {
            this.mRoundedCornerOverlay = roundedCornerOverlay;
            return this;
        }

        Builder setFromClientToken(boolean fromClientToken) {
            this.mFromClientToken = fromClientToken;
            return this;
        }

        Builder setOptions(Bundle options) {
            this.mOptions = options;
            return this;
        }

        WindowToken build() {
            return new WindowToken(this.mService, this.mToken, this.mType, this.mPersistOnEmpty, this.mDisplayContent, this.mOwnerCanManageAppTokens, this.mRoundedCornerOverlay, this.mFromClientToken, this.mOptions);
        }
    }

    private static class FixedRotationTransformState {
        final ArrayList<WindowToken> mAssociatedTokens;
        final DisplayFrames mDisplayFrames;
        final DisplayInfo mDisplayInfo;
        boolean mIsTransforming;
        final Configuration mRotatedOverrideConfiguration;

        FixedRotationTransformState(DisplayInfo rotatedDisplayInfo, DisplayFrames rotatedDisplayFrames, Configuration rotatedConfig) {
            this.mAssociatedTokens = new ArrayList(3);
            this.mIsTransforming = true;
            this.mDisplayInfo = rotatedDisplayInfo;
            this.mDisplayFrames = rotatedDisplayFrames;
            this.mRotatedOverrideConfiguration = rotatedConfig;
        }

        void resetTransform() {
            int i = this.mAssociatedTokens.size() - 1;
        L3:
            if (i < 0) goto L6;
            this.mAssociatedTokens.get(i).removeFixedRotationLeash();
            i = i - 1;
            goto L3
        }

        void disassociate(WindowToken token) {
            this.mAssociatedTokens.remove(token);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-pSQy6fdr3VlGcmvSVCsObZoXyQ, reason: not valid java name */
    public static /* synthetic */ void m10481$r8$lambda$pSQy6fdr3VlGcmvSVCsObZoXyQ(WindowToken r0, boolean r1, WindowState r2) {
        r0.lambda$setInsetsFrozen$1(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$nGO-xASDAxBQTRuMNfGImeCJxk0, reason: not valid java name */
    public static /* synthetic */ int m10482$r8$lambda$nGOxASDAxBQTRuMNfGImeCJxk0(WindowToken r0, WindowState r1, WindowState r2) {
        return r0.lambda$new$0(r1, r2);
    }

    private /* synthetic */ int lambda$new$0(WindowState newWindow, WindowState existingWindow) {
        if (newWindow.mToken != this) goto L14;
        if (existingWindow.mToken != this) goto L12;
        if (isFirstChildWindowGreaterThanSecond(newWindow, existingWindow) == false) goto L9;
        return 1;
    L9:
        return -1;
    L12:
        throw new IllegalArgumentException("existingWindow=" + existingWindow + " is not a child of token=" + this);
    L14:
        throw new IllegalArgumentException("newWindow=" + newWindow + " is not a child of token=" + this);
    }

    protected WindowToken(WindowManagerService service, IBinder _token, int type, boolean persistOnEmpty, DisplayContent dc, boolean ownerCanManageAppTokens) {
        this(service, _token, type, persistOnEmpty, dc, ownerCanManageAppTokens, false, false, null);
    }

    protected WindowToken(WindowManagerService service, IBinder _token, int type, boolean persistOnEmpty, DisplayContent dc, boolean ownerCanManageAppTokens, boolean roundedCornerOverlay, boolean fromClientToken, Bundle options) {
        super(service);
        this.paused = false;
        this.mWindowComparator = new WindowToken$$ExternalSyntheticLambda0(this);
        this.token = _token;
        this.windowType = type;
        this.mOptions = options;
        this.mPersistOnEmpty = persistOnEmpty;
        this.mOwnerCanManageAppTokens = ownerCanManageAppTokens;
        this.mRoundedCornerOverlay = roundedCornerOverlay;
        this.mFromClientToken = fromClientToken;
        if (dc == null) goto L6;
        dc.addWindowToken(this.token, this);
        return;
    }

    void removeAllWindowsIfPossible() {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L12;
        WindowState win = (WindowState) this.mChildren.get(i);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_MOVEMENT_enabled[3] == false) goto L7;
        String protoLogParam0 = String.valueOf(win);
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_WINDOW_MOVEMENT, 8174298531248485625L, 0, new Object[]{protoLogParam0});
    L7:
        win.removeIfPossible();
        if (i <= this.mChildren.size()) goto L10;
        i = this.mChildren.size();
    L10:
        i = i - 1;
        goto L3
    }

    void setExiting(boolean animateExit) {
        if (isEmpty() == false) goto L6;
        super.removeImmediately();
        return;
    L6:
        this.mPersistOnEmpty = false;
        if (isVisible() == true) goto L9;
        return;
    L9:
        int count = this.mChildren.size();
        boolean changed = false;
        int i = 0;
    L10:
        if (i >= count) goto L13;
        WindowState win = (WindowState) this.mChildren.get(i);
        changed = changed | win.onSetAppExiting(animateExit);
        i = i + 1;
        goto L10
    L13:
        if (changed == false) goto L17;
        this.mWmService.mWindowPlacerLocked.performSurfacePlacement();
        this.mWmService.updateFocusedWindowLocked(0, false);
        return;
    }

    @Override // com.android.server.wm.WindowContainer
    void removeIfPossible() {
        if (this.mTransitionController.isPlayingTarget(this) == false) goto L6;
        this.mIsExiting = true;
        return;
    L6:
        this.mIsExiting = false;
        removeAllWindowsIfPossible();
        removeImmediately();
    }

    @Override // com.android.server.wm.WindowContainer
    boolean handleCompleteDeferredRemoval() {
        if (this.mIsExiting == false) goto L6;
        removeIfPossible();
    L6:
        return super.handleCompleteDeferredRemoval();
    }

    float getCompatScale() {
        return this.mDisplayContent.mCompatibleScreenScale;
    }

    boolean hasSizeCompatBounds() {
        return false;
    }

    protected boolean isFirstChildWindowGreaterThanSecond(WindowState newWindow, WindowState existingWindow) {
        if (newWindow.mBaseLayer < existingWindow.mBaseLayer) goto L5;
        return true;
    L5:
        return false;
    }

    void addWindow(WindowState win) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_enabled[0] == false) goto L6;
        String protoLogParam0 = String.valueOf(win);
        String protoLogParam1 = String.valueOf(Debug.getCallers(5));
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_FOCUS, 2740931087734487464L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L6:
        if (win.isChildWindow() == false) goto L9;
        return;
    L9:
        if (this.mSurfaceControl != null) goto L12;
        createSurfaceControl(true);
        reassignLayer(getSyncTransaction());
    L12:
        if (this.mChildren.contains(win) == false) goto L14;
        return;
    L14:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[1] == false) goto L16;
        String protoLogParam2 = String.valueOf(win);
        String protoLogParam3 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, 2382798629637143561L, 0, new Object[]{protoLogParam2, protoLogParam3});
    L16:
        addChild(win, this.mWindowComparator);
        this.mWmService.mWindowsChanged = true;
        if (Constants.ENABLE_GAME_ASSIST == true) goto L19;
        return;
    L19:
        if (this.mDisplayContent.getDisplayId() == 0) goto L21;
        return;
    L21:
        if (getChildCount() == 1) goto L23;
        return;
    L23:
        if (asActivityRecord() != null) goto L30;
        WindowState w = (WindowState) this.mChildren.get(0);
        String packageName = w.getOwningPackage();
        SystemWindowManagerEventDispatcher.getInstance().notifySystemWindowChanged(true, this.windowType, packageName, w.mAttrs, w.mAttrs.type);
        return;
    }

    @Override // com.android.server.wm.WindowContainer
    void createSurfaceControl(boolean force) {
        if (this.mFromClientToken == false) goto L5;
        if (force == true) goto L5;
        return;
    L5:
        super.createSurfaceControl(force);
    }

    boolean isEmpty() {
        return this.mChildren.isEmpty();
    }

    boolean windowsCanBeWallpaperTarget() {
        int j = this.mChildren.size() - 1;
    L3:
        if (j < 0) goto L8;
        WindowState w = (WindowState) this.mChildren.get(j);
        if (w.hasWallpaper() == true) goto L6;
        j = j - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    @Override // com.android.server.wm.WindowContainer
    void removeImmediately() {
        if (this.mDisplayContent == null) goto L5;
        this.mDisplayContent.removeWindowToken(this.token, true);
    L5:
        super.removeImmediately();
    }

    @Override // com.android.server.wm.WindowContainer
    void onDisplayChanged(DisplayContent dc) {
        if (dc.getWindowToken(this.token) != null) goto L5;
        dc.reParentWindowToken(this);
    L5:
        super.onDisplayChanged(dc);
    }

    @Override // com.android.server.wm.WindowContainer
    void assignLayer(SurfaceControl.Transaction t, int layer) {
        if (this.mRoundedCornerOverlay == false) goto L5;
        super.assignLayer(t, 1073741826);
        return;
    L5:
        super.assignLayer(t, layer);
    }

    @Override // com.android.server.wm.WindowContainer
    SurfaceControl.Builder makeSurface() {
        SurfaceControl.Builder builder = super.makeSurface();
        if (this.mRoundedCornerOverlay == false) goto L5;
        builder.setParent(null);
    L5:
        return builder;
    }

    boolean isClientVisible() {
        return this.mClientVisible;
    }

    void setClientVisible(boolean clientVisible) {
        if (this.mClientVisible != clientVisible) goto L6;
        return;
    L6:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_APP_TRANSITIONS_enabled[1] == false) goto L8;
        String protoLogParam0 = String.valueOf(this);
        String protoLogParam2 = String.valueOf(Debug.getCallers(5));
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_APP_TRANSITIONS, -7314975896738778749L, 12, new Object[]{protoLogParam0, Boolean.valueOf(clientVisible), protoLogParam2});
    L8:
        this.mClientVisible = clientVisible;
        sendAppVisibilityToClients();
    }

    boolean hasFixedRotationTransform() {
        if (this.mFixedRotationTransformState == null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean hasFixedRotationTransform(WindowToken token) {
        if (this.mFixedRotationTransformState == null) goto L11;
        if (token == null) goto L11;
        if (this != token) goto L8;
    L9:
        return true;
    L8:
        if (this.mFixedRotationTransformState == token.mFixedRotationTransformState) goto L9;
        return false;
    L11:
        return false;
    }

    boolean isFinishingFixedRotationTransform() {
        if (this.mFixedRotationTransformState != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mFixedRotationTransformState.mIsTransforming == true) goto L7;
        return true;
    }

    boolean isFixedRotationTransforming() {
        if (this.mFixedRotationTransformState != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mFixedRotationTransformState.mIsTransforming == false) goto L7;
        return true;
    }

    DisplayInfo getFixedRotationTransformDisplayInfo() {
        if (IExtWindowManager.isIsland(this.windowType) == false) goto L7;
        return getDisplayContent().getExt().getFixedRotatedDisplayInfo();
    L7:
        if (isFixedRotationTransforming() == true) goto L11;
        return null;
    L11:
        return this.mFixedRotationTransformState.mDisplayInfo;
    }

    DisplayFrames getFixedRotationTransformDisplayFrames() {
        if (IExtWindowManager.isIsland(this.windowType) == false) goto L7;
        return getDisplayContent().getExt().getFixedRotatedDisplayFrames();
    L7:
        if (isFixedRotationTransforming() == true) goto L11;
        return null;
    L11:
        return this.mFixedRotationTransformState.mDisplayFrames;
    }

    Rect getFixedRotationTransformMaxBounds() {
        if (IExtWindowManager.isIsland(this.windowType) == false) goto L7;
        return getDisplayContent().getExt().getFixedRotatedOverrideConfiguration().windowConfiguration.getMaxBounds();
    L7:
        if (isFixedRotationTransforming() == true) goto L11;
        return null;
    L11:
        return this.mFixedRotationTransformState.mRotatedOverrideConfiguration.windowConfiguration.getMaxBounds();
    }

    Rect getFixedRotationTransformDisplayBounds() {
        if (IExtWindowManager.isIsland(this.windowType) == false) goto L7;
        return getDisplayContent().getExt().getFixedRotatedOverrideConfiguration().windowConfiguration.getBounds();
    L7:
        if (isFixedRotationTransforming() == true) goto L11;
        return null;
    L11:
        return this.mFixedRotationTransformState.mRotatedOverrideConfiguration.windowConfiguration.getBounds();
    }

    InsetsState getFixedRotationTransformInsetsState() {
        if (IExtWindowManager.isIsland(this.windowType) == false) goto L7;
        return getDisplayContent().getExt().getFixedRotatedDisplayFrames().mInsetsState;
    L7:
        if (isFixedRotationTransforming() == true) goto L11;
        return null;
    L11:
        return this.mFixedRotationTransformState.mDisplayFrames.mInsetsState;
    }

    void applyFixedRotationTransform(DisplayInfo info, DisplayFrames displayFrames, Configuration config) {
        if (this.mFixedRotationTransformState == null) goto L5;
        this.mFixedRotationTransformState.disassociate(this);
    L5:
        this.mFixedRotationTransformState = new FixedRotationTransformState(info, displayFrames, new Configuration(config));
        this.mFixedRotationTransformState.mAssociatedTokens.add(this);
        this.mDisplayContent.getDisplayPolicy().simulateLayoutDisplay(displayFrames);
        onFixedRotationStatePrepared();
    }

    void linkFixedRotationTransform(WindowToken other) {
        FixedRotationTransformState fixedRotationState = other.mFixedRotationTransformState;
        if (fixedRotationState != null) goto L5;
        return;
    L5:
        if (this.mFixedRotationTransformState != fixedRotationState) goto L8;
        return;
    L8:
        if (this.mFixedRotationTransformState == null) goto L10;
        this.mFixedRotationTransformState.disassociate(this);
    L10:
        this.mFixedRotationTransformState = fixedRotationState;
        fixedRotationState.mAssociatedTokens.add(this);
        onFixedRotationStatePrepared();
    }

    private void onFixedRotationStatePrepared() {
        onConfigurationChanged(getParent().getConfiguration());
        ActivityRecord r = asActivityRecord();
        if (r != null) goto L5;
        return;
    L5:
        if (r.hasProcess() == false) goto L9;
        r.app.registerActivityConfigurationListener(r);
        return;
    }

    boolean hasAnimatingFixedRotationTransition() {
        if (this.mFixedRotationTransformState != null) goto L5;
        return false;
    L5:
        int i = this.mFixedRotationTransformState.mAssociatedTokens.size() - 1;
    L6:
        if (i < 0) goto L16;
        ActivityRecord r = this.mFixedRotationTransformState.mAssociatedTokens.get(i).asActivityRecord();
        if (r == null) goto L14;
        if (r.inTransitionSelfOrParent() == false) goto L14;
        if (r.mDisplayContent.inTransition() == true) goto L14;
        return true;
    L14:
        i = i - 1;
        goto L6
    L16:
        return false;
    }

    void finishFixedRotationTransform() {
        finishFixedRotationTransform(null);
    }

    void finishFixedRotationTransform(Runnable applyDisplayRotation) {
        FixedRotationTransformState state = this.mFixedRotationTransformState;
        if (state != null) goto L5;
        return;
    L5:
        state.resetTransform();
        state.mIsTransforming = false;
        if (applyDisplayRotation == null) goto L8;
        applyDisplayRotation.run();
    L8:
        int i = state.mAssociatedTokens.size() - 1;
    L9:
        if (i < 0) goto L15;
        WindowToken token = state.mAssociatedTokens.get(i);
        token.mFixedRotationTransformState = null;
        if (applyDisplayRotation != null) goto L13;
        token.cancelFixedRotationTransform();
    L13:
        i = i - 1;
        goto L9
    }

    private void cancelFixedRotationTransform() {
        WindowContainer<?> parent = getParent();
        if (parent != null) goto L6;
        return;
    L6:
        if (this.mTransitionController.isShellTransitionsEnabled() == true) goto L8;
    L15:
        int originalRotation = getWindowConfiguration().getRotation();
        onConfigurationChanged(parent.getConfiguration());
        onCancelFixedRotationTransform(originalRotation);
        return;
    L8:
        if (asActivityRecord() == null) goto L15;
        if (isVisible() == false) goto L15;
        Transition transition = this.mTransitionController.getCollectingTransition();
        if (transition != null) goto L14;
        transition = this.mTransitionController.requestStartTransition(this.mTransitionController.createTransition(6), null, null, null);
    L14:
        transition.collect(this);
        transition.collectVisibleChange(this);
        transition.setReady(this.mDisplayContent, true);
        goto L15
    }

    SurfaceControl getOrCreateFixedRotationLeash(SurfaceControl.Transaction t) {
        if (this.mTransitionController.isShellTransitionsEnabled() == true) goto L5;
        return null;
    L5:
        int rotation = getRelativeDisplayRotation();
        if (rotation != 0) goto L10;
        return this.mFixedRotationTransformLeash;
    L10:
        if (this.mFixedRotationTransformLeash == null) goto L14;
        return this.mFixedRotationTransformLeash;
    L14:
        if (ActivityTaskManagerService.isPip2ExperimentEnabled() == true) goto L16;
    L20:
        SurfaceControl leash = makeSurface().setContainerLayer().setParent(getParentSurfaceControl()).setName(getSurfaceControl() + " - rotation-leash").setHidden(false).setCallsite("WindowToken.getOrCreateFixedRotationLeash").build();
        t.setPosition(leash, (float) this.mLastSurfacePosition.x, (float) this.mLastSurfacePosition.y);
        t.reparent(getSurfaceControl(), leash);
        this.mDisplayContent.setFixedTransformHint(getPendingTransaction(), leash, getWindowConfiguration().getDisplayRotation());
        this.mFixedRotationTransformLeash = leash;
        updateSurfaceRotation(t, rotation, this.mFixedRotationTransformLeash);
        return this.mFixedRotationTransformLeash;
    L16:
        if (asActivityRecord() == null) goto L20;
        if (this.mTransitionController.getWindowingModeAtStart(asActivityRecord()) != 2) goto L20;
        return null;
    }

    SurfaceControl getFixedRotationLeash() {
        return this.mFixedRotationTransformLeash;
    }

    void removeFixedRotationLeash() {
        if (this.mFixedRotationTransformLeash != null) goto L5;
        return;
    L5:
        SurfaceControl.Transaction t = getSyncTransaction();
        if (this.mSurfaceControl == null) goto L8;
        t.reparent(this.mSurfaceControl, getParentSurfaceControl());
    L8:
        t.remove(this.mFixedRotationTransformLeash);
        this.mFixedRotationTransformLeash = null;
    }

    void onCancelFixedRotationTransform(int originalDisplayRotation) {
    }

    @Override // com.android.server.wm.ConfigurationContainer
    void resolveOverrideConfiguration(Configuration newParentConfig) {
        super.resolveOverrideConfiguration(newParentConfig);
        if (isFixedRotationTransforming() == false) goto L6;
        getResolvedOverrideConfiguration().updateFrom(this.mFixedRotationTransformState.mRotatedOverrideConfiguration);
    L6:
        if (asActivityRecord() != null) goto L11;
        WindowState win = getTopChild();
        if (win == null) goto L11;
        Configuration resolvedConfig = getResolvedOverrideConfiguration();
        win.applySizeOverride(newParentConfig, resolvedConfig);
    L11:
        if (IExtWindowManager.isIsland(this.windowType) == false) goto L13;
        getResolvedOverrideConfiguration().updateFrom(getDisplayContent().getExt().getFixedRotatedOverrideConfiguration());
    L13:
        getExtWindowContainer().updateResolvedOverrideConfiguration(newParentConfig);
    }

    @Override // com.android.server.wm.WindowContainer
    void updateSurfacePosition(SurfaceControl.Transaction t) {
        ActivityRecord r = asActivityRecord();
        if (r != null) goto L5;
    L7:
        super.updateSurfacePosition(t);
        if (IExtWindowManager.isIsland(this.windowType) == true) goto L10;
        return;
    L10:
        if (this.mSurfaceControl != null) goto L12;
        return;
    L12:
        if (this.mDisplayContent == null) goto L17;
        t.setMatrix(this.mSurfaceControl, this.mDisplayContent.getExt().getFixedRotatedMatrix(this.mLastSurfacePosition.x, this.mLastSurfacePosition.y), IExtDisplayContent.mFloat9);
        return;
    L17:
        return;
    L5:
        if (r.isConfigurationDispatchPaused() == false) goto L7;
    }

    @Override // com.android.server.wm.WindowContainer
    protected void updateSurfaceRotation(SurfaceControl.Transaction t, int deltaRotation, SurfaceControl positionLeash) {
        ActivityRecord r = asActivityRecord();
        if (r == null) goto L9;
        Task rootTask = r.getRootTask();
        if (rootTask == null) goto L9;
        if (this.mTransitionController.getWindowingModeAtStart(rootTask) != 2) goto L9;
        return;
    L9:
        super.updateSurfaceRotation(t, deltaRotation, positionLeash);
    }

    @Override // com.android.server.wm.WindowContainer
    void resetSurfacePositionForAnimationLeash(SurfaceControl.Transaction t) {
        if (isFixedRotationTransforming() == true) goto L6;
        super.resetSurfacePositionForAnimationLeash(t);
        return;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean prepareSync() {
        if (this.mDisplayContent == null) goto L11;
        if (this.mDisplayContent.isRotationChanging() == false) goto L11;
        if (AsyncRotationController.canBeAsync(this) == false) goto L11;
        return false;
    L11:
        return super.prepareSync();
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.ConfigurationContainer
    public void dumpDebug(ProtoOutputStream proto, long fieldId, int logLevel) {
        if (logLevel == 2) goto L5;
    L7:
        long token = proto.start(fieldId);
        super.dumpDebug(proto, 1146756268033L, logLevel);
        proto.write(1120986464258L, System.identityHashCode(this));
        proto.write(1133871366150L, this.paused);
        proto.end(token);
        return;
    L5:
        if (isVisible() == true) goto L7;
    }

    @Override // com.android.server.wm.WindowContainer
    long getProtoFieldId() {
        return 1146756268039L;
    }

    @Override // com.android.server.wm.WindowContainer
    void dump(PrintWriter pw, String prefix, boolean dumpAll) {
        super.dump(pw, prefix, dumpAll);
        pw.print(prefix);
        pw.print("windows=");
        pw.println(this.mChildren);
        pw.print(prefix);
        pw.print("windowType=");
        pw.print(this.windowType);
        pw.println();
        if (hasFixedRotationTransform() == false) goto L6;
        pw.print(prefix);
        pw.print("fixedRotationConfig=");
        pw.println(this.mFixedRotationTransformState.mRotatedOverrideConfiguration);
    L6:
        if (this.mIsExiting == false) goto L9;
        pw.print(prefix);
        pw.println("isExiting=true");
        return;
    }

    public String toString() {
        if (this.stringName != null) goto L6;
        this.stringName = "WindowToken{" + Integer.toHexString(System.identityHashCode(this)) + " type=" + this.windowType + " " + this.token + "}";
    L6:
        return this.stringName;
    }

    @Override // com.android.server.wm.ConfigurationContainer
    String getName() {
        return toString();
    }

    @Override // com.android.server.wm.WindowContainer
    WindowToken asWindowToken() {
        return this;
    }

    int getWindowLayerFromType() {
        return this.mWmService.mPolicy.getWindowLayerFromTypeLw(this.windowType, this.mOwnerCanManageAppTokens, this.mRoundedCornerOverlay);
    }

    boolean isFromClient() {
        return this.mFromClientToken;
    }

    void setInsetsFrozen(final boolean freeze) {
        forAllWindows(new WindowToken$$ExternalSyntheticLambda1(this, freeze), true);
    }

    private /* synthetic */ void lambda$setInsetsFrozen$1(boolean freeze, WindowState w) {
        if (w.mToken != this) goto L8;
        if (freeze == false) goto L6;
        w.freezeInsetsState();
        return;
    L6:
        w.clearFrozenInsetsState();
        return;
    }

    @Override // com.android.server.wm.WindowContainer
    int getWindowType() {
        return this.windowType;
    }

    public WindowTokenSysEx getWindowTokenSysEx() {
        return (WindowTokenSysEx) getSmtEx();
    }
}
