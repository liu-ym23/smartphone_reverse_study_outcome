package com.android.server.wm;

import android.graphics.Insets;
import android.graphics.Point;
import android.graphics.Rect;
import android.pico.utils.ExtImplFactory;
import android.util.SparseArray;
import android.util.proto.ProtoOutputStream;
import android.view.InsetsSource;
import android.view.InsetsSourceControl;
import android.view.SurfaceControl;
import android.view.WindowInsets;
import android.view.inputmethod.ImeTracker;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.util.function.TriFunction;
import java.io.PrintWriter;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
class InsetsSourceProvider {
    private static final Rect EMPTY_RECT = null;
    private ControlAdapter mAdapter;
    private boolean mClientVisible;
    protected InsetsSourceControl mControl;
    protected InsetsControlTarget mControlTarget;
    private final boolean mControllable;
    private boolean mCropToProvidingInsets;
    protected final DisplayContent mDisplayContent;
    private IExtInsetsSourceProvider mExt;
    private final InsetsSourceControl mFakeControl;
    private InsetsControlTarget mFakeControlTarget;
    private int mFlagsFromFrameProvider;
    private int mFlagsFromServer;
    private TriFunction<DisplayFrames, WindowContainer, Rect, Integer> mFrameProvider;
    private boolean mHasPendingPosition;
    private Insets mInsetsHint;
    private boolean mInsetsHintStale;
    protected boolean mIsLeashInitialized;
    private final Rect mLastSourceFrame;
    private SparseArray<TriFunction<DisplayFrames, WindowContainer, Rect, Integer>> mOverrideFrameProviders;
    private final SparseArray<Rect> mOverrideFrames;
    private InsetsControlTarget mPendingControlTarget;
    private final Point mPosition;
    private boolean mSeamlessRotating;
    private boolean mServerVisible;
    private final Consumer<SurfaceControl.Transaction> mSetControlPositionConsumer;
    protected final InsetsSource mSource;
    private final Rect mSourceFrame;
    protected final InsetsStateController mStateController;
    private final Rect mTmpRect;
    protected WindowContainer mWindowContainer;

    private class ControlAdapter implements AnimationAdapter {
        private SurfaceControl mCapturedLeash;
        private final Point mSurfacePosition;
        final /* synthetic */ InsetsSourceProvider this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmCapturedLeash, reason: not valid java name */
        static /* bridge */ /* synthetic */ SurfaceControl m10018$$Nest$fgetmCapturedLeash(ControlAdapter r0) {
            return r0.mCapturedLeash;
        }

        ControlAdapter(InsetsSourceProvider r1, Point surfacePosition) {
            this.this$0 = r1;
            this.mSurfacePosition = surfacePosition;
        }

        @Override // com.android.server.wm.AnimationAdapter
        public boolean getShowWallpaper() {
            return false;
        }

        @Override // com.android.server.wm.AnimationAdapter
        public void startAnimation(SurfaceControl animationLeash, SurfaceControl.Transaction t, int type, SurfaceAnimator.OnAnimationFinishedCallback finishCallback) {
            if (this.this$0.mSource.getType() == WindowInsets.Type.ime()) goto L5;
        L5:
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_INSETS_enabled[2] == false) goto L7;
            String protoLogParam0 = String.valueOf(this.this$0.mSource);
            String protoLogParam1 = String.valueOf(this.this$0.mControlTarget);
            ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_WINDOW_INSETS, -8601070090234611338L, 0, new Object[]{protoLogParam0, protoLogParam1});
        L7:
            this.mCapturedLeash = animationLeash;
            t.setPosition(this.mCapturedLeash, this.mSurfacePosition.x, this.mSurfacePosition.y);
            if (InsetsSourceProvider.m10015$$Nest$fgetmCropToProvidingInsets(this.this$0) == false) goto L11;
            t.setWindowCrop(this.mCapturedLeash, InsetsSourceProvider.m10017$$Nest$mgetProvidingInsetsBoundsCropRect(this.this$0));
            return;
        }

        @Override // com.android.server.wm.AnimationAdapter
        public void onAnimationCancelled(SurfaceControl animationLeash) {
            if (InsetsSourceProvider.m10014$$Nest$fgetmAdapter(this.this$0) != this) goto L12;
            this.this$0.mStateController.notifyControlRevoked(this.this$0.mControlTarget, this.this$0);
            this.this$0.mStateController.notifySurfaceTransactionReady(this.this$0, 0, false);
            this.this$0.mControl = null;
            this.this$0.mControlTarget = null;
            InsetsSourceProvider.m10016$$Nest$fputmAdapter(this.this$0, null);
            InsetsSourceProvider r0 = this.this$0;
            if ((WindowInsets.Type.defaultVisible() & this.this$0.mSource.getType()) == 0) goto L7;
            boolean r1 = true;
        L8:
            r0.setClientVisible(r1);
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_INSETS_enabled[2] == false) goto L13;
            String protoLogParam0 = String.valueOf(this.this$0.mSource);
            String protoLogParam1 = String.valueOf(this.this$0.mControlTarget);
            ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_WINDOW_INSETS, -6857870589074001153L, 0, new Object[]{protoLogParam0, protoLogParam1});
            return;
        L13:
            return;
        L7:
            r1 = false;
            goto L8
        }

        @Override // com.android.server.wm.AnimationAdapter
        public long getDurationHint() {
            return 0;
        }

        @Override // com.android.server.wm.AnimationAdapter
        public long getStatusBarTransitionsStartTime() {
            return 0;
        }

        @Override // com.android.server.wm.AnimationAdapter
        public void dump(PrintWriter pw, String prefix) {
            pw.print(prefix + "ControlAdapter mCapturedLeash=");
            pw.print(this.mCapturedLeash);
            pw.println();
        }

        @Override // com.android.server.wm.AnimationAdapter
        public void dumpDebug(ProtoOutputStream proto) {
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$Dei2KOKOm-G-kdAHiqmNNHB9JPM, reason: not valid java name */
    public static /* synthetic */ void m10013$r8$lambda$Dei2KOKOmGkdAHiqmNNHB9JPM(InsetsSourceProvider r0, SurfaceControl.Transaction r1) {
        r0.lambda$new$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAdapter, reason: not valid java name */
    static /* bridge */ /* synthetic */ ControlAdapter m10014$$Nest$fgetmAdapter(InsetsSourceProvider r0) {
        return r0.mAdapter;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCropToProvidingInsets, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10015$$Nest$fgetmCropToProvidingInsets(InsetsSourceProvider r0) {
        return r0.mCropToProvidingInsets;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAdapter, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10016$$Nest$fputmAdapter(InsetsSourceProvider r0, ControlAdapter r1) {
        r0.mAdapter = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetProvidingInsetsBoundsCropRect, reason: not valid java name */
    static /* bridge */ /* synthetic */ Rect m10017$$Nest$mgetProvidingInsetsBoundsCropRect(InsetsSourceProvider r0) {
        return r0.getProvidingInsetsBoundsCropRect();
    }

    static {
        EMPTY_RECT = new Rect();
    }

    InsetsSourceProvider(InsetsSource source, InsetsStateController stateController, DisplayContent displayContent) {
        this.mTmpRect = new Rect();
        this.mPosition = new Point();
        this.mOverrideFrames = new SparseArray();
        this.mSourceFrame = new Rect();
        this.mLastSourceFrame = new Rect();
        this.mInsetsHint = Insets.NONE;
        boolean r0 = true;
        this.mInsetsHintStale = true;
        this.mCropToProvidingInsets = false;
        this.mExt = (IExtInsetsSourceProvider) ExtImplFactory.getImpl(IExtInsetsSourceProvider.class, new Object[]{this});
        if ((WindowInsets.Type.defaultVisible() & source.getType()) == 0) goto L5;
        boolean r2 = true;
    L6:
        this.mClientVisible = r2;
        this.mSource = source;
        this.mDisplayContent = displayContent;
        this.mStateController = stateController;
        this.mFakeControl = new InsetsSourceControl(source.getId(), source.getType(), null, false, new Point(), Insets.NONE);
        if ((InsetsPolicy.CONTROLLABLE_TYPES & source.getType()) != 0) goto L10;
        r0 = false;
    L10:
        this.mControllable = r0;
        this.mSetControlPositionConsumer = new InsetsSourceProvider$$ExternalSyntheticLambda0(this);
        return;
    L5:
        r2 = false;
        goto L6
    }

    private /* synthetic */ void lambda$new$0(SurfaceControl.Transaction t) {
        if (this.mControl != null) goto L5;
        return;
    L5:
        if (this.mControlTarget == null) goto L22;
        boolean changed = this.mControl.setSurfacePosition(this.mPosition.x, this.mPosition.y);
        SurfaceControl leash = this.mControl.getLeash();
        if (changed == false) goto L12;
        if (leash == null) goto L12;
        t.setPosition(leash, this.mPosition.x, this.mPosition.y);
    L12:
        if (this.mHasPendingPosition == false) goto L17;
        this.mHasPendingPosition = false;
        if (this.mPendingControlTarget == this.mControlTarget) goto L17;
        this.mStateController.notifyControlTargetChanged(this.mPendingControlTarget, this);
    L17:
        if ((changed | updateInsetsHint()) == false) goto L21;
        this.mStateController.notifyControlChanged(this.mControlTarget, this);
        return;
    L21:
        return;
    }

    private boolean updateInsetsHint() {
        Insets insetsHint = getInsetsHint();
        if (this.mControl.getInsetsHint().equals(insetsHint) == true) goto L6;
        this.mControl.setInsetsHint(insetsHint);
        return true;
    L6:
        return false;
    }

    InsetsSource getSource() {
        return this.mSource;
    }

    Rect getSourceFrame() {
        return this.mSourceFrame;
    }

    boolean isControllable() {
        return this.mControllable;
    }

    protected boolean isSurfaceVisible() {
        WindowState windowState = this.mWindowContainer.asWindowState();
        if (windowState == null) goto L11;
        if (windowState.wouldBeVisibleIfPolicyIgnored() == true) goto L7;
    L9:
        return false;
    L7:
        if (windowState.isVisibleByPolicy() == false) goto L9;
        return true;
    L11:
        return this.mWindowContainer.isVisibleRequested();
    }

    void setWindowContainer(WindowContainer windowContainer, TriFunction<DisplayFrames, WindowContainer, Rect, Integer> frameProvider, SparseArray<TriFunction<DisplayFrames, WindowContainer, Rect, Integer>> overrideFrameProviders) {
        if (this.mWindowContainer == null) goto L9;
        if (this.mControllable == false) goto L7;
        this.mWindowContainer.setControllableInsetProvider(null);
    L7:
        this.mWindowContainer.cancelAnimation();
        this.mWindowContainer.getInsetsSourceProviders().remove(this.mSource.getId());
        this.mSeamlessRotating = false;
        this.mHasPendingPosition = false;
    L9:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_INSETS_enabled[0] == false) goto L11;
        String protoLogParam0 = String.valueOf(windowContainer);
        String protoLogParam1 = String.valueOf(WindowInsets.Type.toString(this.mSource.getType()));
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_WINDOW_INSETS, 1522894362518893789L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L11:
        this.mWindowContainer = windowContainer;
        this.mFrameProvider = frameProvider;
        this.mOverrideFrames.clear();
        this.mOverrideFrameProviders = overrideFrameProviders;
        if (windowContainer != null) goto L14;
        setServerVisible(false);
        this.mSource.setVisibleFrame(null);
        this.mSource.setFlags(0, -1);
        this.mSourceFrame.setEmpty();
        return;
    L14:
        this.mWindowContainer.getInsetsSourceProviders().put(this.mSource.getId(), this);
        if (this.mControllable == false) goto L21;
        this.mWindowContainer.setControllableInsetProvider(this);
        if (this.mPendingControlTarget == this.mControlTarget) goto L22;
        this.mStateController.notifyControlTargetChanged(this.mPendingControlTarget, this);
        return;
    L22:
        return;
    }

    boolean setFlags(int flags, int mask) {
        this.mFlagsFromServer = (this.mFlagsFromServer & (~mask)) | (flags & mask);
        int mergedFlags = this.mFlagsFromFrameProvider | this.mFlagsFromServer;
        if (this.mSource.getFlags() == mergedFlags) goto L6;
        this.mSource.setFlags(mergedFlags);
        return true;
    L6:
        return false;
    }

    void updateSourceFrame(Rect frame) {
        if (this.mWindowContainer != null) goto L5;
        return;
    L5:
        WindowState win = this.mWindowContainer.asWindowState();
        if (win == null) goto L8;
        this.mSourceFrame.set(frame);
        if (this.mFrameProvider == null) goto L18;
        this.mFlagsFromFrameProvider = ((Integer) this.mFrameProvider.apply(this.mWindowContainer.getDisplayContent().mDisplayFrames, this.mWindowContainer, this.mSourceFrame)).intValue();
        this.mSource.setFlags(this.mFlagsFromFrameProvider | this.mFlagsFromServer);
    L18:
        updateSourceFrameForServerVisibility();
        if (this.mLastSourceFrame.equals(this.mSourceFrame) == true) goto L22;
        this.mLastSourceFrame.set(this.mSourceFrame);
        this.mInsetsHintStale = true;
    L22:
        if (this.mOverrideFrameProviders == null) goto L34;
        int i = this.mOverrideFrameProviders.size() - 1;
    L24:
        if (i < 0) goto L34;
        int windowType = this.mOverrideFrameProviders.keyAt(i);
        if (this.mOverrideFrames.contains(windowType) == false) goto L28;
        Rect overrideFrame = this.mOverrideFrames.get(windowType);
        overrideFrame.set(frame);
    L29:
        TriFunction<DisplayFrames, WindowContainer, Rect, Integer> provider = this.mOverrideFrameProviders.get(windowType);
        if (provider == null) goto L32;
        this.mOverrideFrameProviders.get(windowType).apply(this.mWindowContainer.getDisplayContent().mDisplayFrames, this.mWindowContainer, overrideFrame);
    L32:
        this.mOverrideFrames.put(windowType, overrideFrame);
        i = i - 1;
        goto L24
    L28:
        overrideFrame = new Rect(frame);
    L34:
        if (win.mGivenVisibleInsets.left == 0) goto L36;
    L43:
        this.mTmpRect.set(frame);
        this.mTmpRect.inset(win.mGivenVisibleInsets);
        this.mSource.setVisibleFrame(this.mTmpRect);
        return;
    L36:
        if (win.mGivenVisibleInsets.top != 0) goto L43;
        if (win.mGivenVisibleInsets.right != 0) goto L43;
        if (win.mGivenVisibleInsets.bottom != 0) goto L43;
        this.mSource.setVisibleFrame(null);
        return;
    L8:
        if (this.mServerVisible == false) goto L12;
        this.mTmpRect.set(this.mWindowContainer.getBounds());
        if (this.mFrameProvider == null) goto L13;
        this.mFrameProvider.apply(this.mWindowContainer.getDisplayContent().mDisplayFrames, this.mWindowContainer, this.mTmpRect);
    L13:
        this.mSource.setFrame(this.mTmpRect);
        this.mSource.setVisibleFrame(null);
        return;
    L12:
        this.mTmpRect.setEmpty();
        goto L13
    }

    private void updateSourceFrameForServerVisibility() {
        if (this.mServerVisible == false) goto L5;
        Rect frame = this.mSourceFrame;
    L7:
        if (this.mSource.getFrame().equals(frame) == false) goto L9;
        return;
    L9:
        this.mSource.setFrame(frame);
        if (this.mWindowContainer == null) goto L13;
        this.mSource.updateSideHint(this.mWindowContainer.getBounds());
        return;
    L13:
        return;
    L5:
        frame = EMPTY_RECT;
        goto L7
    }

    void onWindowContainerBoundsChanged() {
        this.mInsetsHintStale = true;
    }

    Insets getInsetsHint() {
        if (this.mServerVisible == false) goto L5;
        WindowState win = this.mWindowContainer.asWindowState();
        if (win == null) goto L13;
        if (win.mGivenInsetsPending == false) goto L13;
        return this.mInsetsHint;
    L13:
        if (this.mInsetsHintStale == false) goto L16;
        Rect bounds = this.mWindowContainer.getBounds();
        this.mInsetsHint = this.mSource.calculateInsets(bounds, true);
        this.mInsetsHintStale = false;
    L16:
        return this.mInsetsHint;
    L5:
        return this.mInsetsHint;
    }

    InsetsSource createSimulatedSource(DisplayFrames displayFrames, Rect frame) {
        InsetsSource source = new InsetsSource(this.mSource);
        this.mTmpRect.set(frame);
        if (this.mFrameProvider == null) goto L5;
        this.mFrameProvider.apply(displayFrames, this.mWindowContainer, this.mTmpRect);
    L5:
        source.setFrame(this.mTmpRect);
        source.setVisibleFrame(null);
        return source;
    }

    void onPostLayout() {
        if (this.mWindowContainer != null) goto L5;
        return;
    L5:
        WindowState windowState = this.mWindowContainer.asWindowState();
        boolean isServerVisible = isSurfaceVisible();
        if (this.mServerVisible == isServerVisible) goto L8;
        boolean serverVisibleChanged = true;
    L9:
        setServerVisible(isServerVisible);
        if (this.mControl != null) goto L12;
        return;
    L12:
        if (this.mControlTarget == null) goto L23;
        boolean positionChanged = updateInsetsControlPosition(windowState);
        if (positionChanged == false) goto L16;
        return;
    L16:
        if (this.mHasPendingPosition == false) goto L18;
        return;
    L18:
        if (updateInsetsHint() == false) goto L19;
    L19:
        if (serverVisibleChanged == false) goto L26;
        this.mStateController.notifyControlChanged(this.mControlTarget, this);
        return;
    L26:
        return;
    L23:
        return;
    L8:
        serverVisibleChanged = false;
        goto L9
    }

    boolean updateInsetsControlPosition(WindowState windowState) {
        if (this.mControl != null) goto L5;
        return false;
    L5:
        Point position = getWindowFrameSurfacePosition();
        if (this.mPosition.equals(position) == true) goto L25;
        this.mPosition.set(position);
        if (windowState != null) goto L10;
    L16:
        SurfaceControl.Transaction t = this.mWindowContainer.getSyncTransaction();
        if (windowState == null) goto L23;
        AsyncRotationController rotationController = this.mDisplayContent.getAsyncRotationController();
        if (rotationController == null) goto L23;
        SurfaceControl.Transaction drawT = rotationController.getDrawTransaction(windowState.mToken);
        if (drawT == null) goto L23;
        t = drawT;
    L23:
        this.mSetControlPositionConsumer.accept(t);
    L24:
        return true;
    L10:
        if (windowState.getWindowFrames().didFrameSizeChange() == false) goto L16;
        if (windowState.mWinAnimator.getShown() == false) goto L16;
        if (this.mWindowContainer.okToDisplay() == false) goto L16;
        this.mHasPendingPosition = true;
        windowState.applyWithNextDraw(this.mSetControlPositionConsumer);
        goto L24
    L25:
        return false;
    }

    private Point getWindowFrameSurfacePosition() {
        WindowState win = this.mWindowContainer.asWindowState();
        if (win != null) goto L5;
    L12:
        if (win == null) goto L14;
        Rect frame = win.getFrame();
    L15:
        Point position = new Point();
        this.mWindowContainer.transformFrameToSurfacePosition(frame.left, frame.top, position);
        return position;
    L14:
        frame = this.mWindowContainer.getBounds();
        goto L15
    L5:
        if (this.mControl == null) goto L12;
        AsyncRotationController controller = this.mDisplayContent.getAsyncRotationController();
        if (controller == null) goto L12;
        if (controller.shouldFreezeInsetsPosition(win) == false) goto L12;
        return this.mControl.getSurfacePosition();
    }

    void updateFakeControlTarget(InsetsControlTarget fakeTarget) {
        if (fakeTarget != this.mFakeControlTarget) goto L5;
        return;
    L5:
        this.mFakeControlTarget = fakeTarget;
    }

    void setCropToProvidingInsetsBounds(SurfaceControl.Transaction t) {
        this.mCropToProvidingInsets = true;
        if (this.mWindowContainer != null) goto L5;
        return;
    L5:
        if (this.mWindowContainer.mSurfaceAnimator.hasLeash() == false) goto L9;
        t.setWindowCrop(this.mWindowContainer.mSurfaceAnimator.mLeash, getProvidingInsetsBoundsCropRect());
        return;
    }

    void removeCropToProvidingInsetsBounds(SurfaceControl.Transaction t) {
        this.mCropToProvidingInsets = false;
        if (this.mWindowContainer != null) goto L5;
        return;
    L5:
        if (this.mWindowContainer.mSurfaceAnimator.hasLeash() == false) goto L9;
        t.setWindowCrop(this.mWindowContainer.mSurfaceAnimator.mLeash, null);
        return;
    }

    private Rect getProvidingInsetsBoundsCropRect() {
        if (this.mWindowContainer.asWindowState() == null) goto L5;
        Rect sourceWindowFrame = this.mWindowContainer.asWindowState().getFrame();
    L6:
        Rect insetFrame = getSource().getFrame();
        return new Rect(insetFrame.left - sourceWindowFrame.left, insetFrame.top - sourceWindowFrame.top, insetFrame.right - sourceWindowFrame.left, insetFrame.bottom - sourceWindowFrame.top);
    L5:
        sourceWindowFrame = this.mWindowContainer.getBounds();
        goto L6
    }

    void updateControlForTarget(InsetsControlTarget target, boolean force, ImeTracker.Token statsToken) {
        if (this.mSeamlessRotating == false) goto L5;
        return;
    L5:
        this.mPendingControlTarget = target;
        if (this.mWindowContainer == null) goto L11;
        if (this.mWindowContainer.getSurfaceControl() != null) goto L11;
        setWindowContainer(null, null, null);
    L11:
        if (this.mWindowContainer != null) goto L14;
        return;
    L14:
        if (target != this.mControlTarget) goto L18;
        if (force == true) goto L18;
        return;
    L18:
        if (this.mHasPendingPosition == false) goto L20;
        return;
    L20:
        boolean r0 = true;
        if (target != null) goto L28;
        this.mWindowContainer.cancelAnimation();
        if ((WindowInsets.Type.defaultVisible() & this.mSource.getType()) != 0) goto L26;
        r0 = false;
    L26:
        setClientVisible(r0);
        return;
    L28:
        boolean initiallyVisible = this.mClientVisible;
        Point surfacePosition = getWindowFrameSurfacePosition();
        this.mPosition.set(surfacePosition);
        this.mAdapter = new ControlAdapter(this, surfacePosition);
        if (this.mSource.getType() == WindowInsets.Type.ime()) goto L31;
        boolean initiallyVisible2 = initiallyVisible;
    L48:
        SurfaceControl.Transaction t = this.mWindowContainer.getSyncTransaction();
        this.mWindowContainer.startAnimation(t, this.mAdapter, !initiallyVisible2, 32);
        this.mIsLeashInitialized = false;
        SurfaceControl leash = ControlAdapter.m10018$$Nest$fgetmCapturedLeash(this.mAdapter);
        this.mControlTarget = target;
        updateVisibility();
        if (this.mSource.getType() == WindowInsets.Type.ime()) goto L50;
    L50:
        this.mControl = new InsetsSourceControl(this.mSource.getId(), this.mSource.getType(), leash, initiallyVisible2, surfacePosition, getInsetsHint());
        this.mStateController.notifySurfaceTransactionReady(this, getSurfaceTransactionId(leash), true);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_INSETS_enabled[0] == false) goto L54;
        String protoLogParam0 = String.valueOf(this.mControl);
        String protoLogParam1 = String.valueOf(this.mControlTarget);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_WINDOW_INSETS, 6243049416211184258L, 0, new Object[]{protoLogParam0, protoLogParam1});
        return;
    L54:
        return;
    L31:
        if (this.mClientVisible == true) goto L33;
    L45:
        boolean initiallyVisible3 = false;
    L46:
        setClientVisible(target.isRequestedVisible(WindowInsets.Type.ime()));
        initiallyVisible2 = initiallyVisible3;
        goto L48
    L33:
        if (this.mServerVisible == false) goto L45;
        WindowContainer imeParentWindow = this.mDisplayContent.getImeParentWindow();
        if (imeParentWindow != null) goto L37;
    L43:
        boolean initiallyVisible4 = false;
    L44:
        initiallyVisible3 = getExt().adjustImeInitialVisible(imeParentWindow, target, initiallyVisible4);
        goto L46
    L37:
        if (imeParentWindow.inTransitionSelfOrParent() == true) goto L43;
        if (imeParentWindow.isVisible() == false) goto L43;
        if (imeParentWindow.isVisibleRequested() == false) goto L43;
        initiallyVisible4 = true;
        goto L44
    }

    private long getSurfaceTransactionId(SurfaceControl leash) {
        if (leash != null) goto L6;
        return 0;
    L6:
        return leash.mNativeObject;
    }

    void onSurfaceTransactionCommitted(long id) {
        if (this.mIsLeashInitialized == false) goto L6;
        return;
    L6:
        if (this.mControl != null) goto L9;
        return;
    L9:
        if (id == getSurfaceTransactionId(this.mControl.getLeash())) goto L11;
        return;
    L11:
        this.mIsLeashInitialized = true;
        this.mStateController.notifySurfaceTransactionReady(this, 0, false);
    }

    void startSeamlessRotation() {
        if (this.mSeamlessRotating == true) goto L6;
        this.mSeamlessRotating = true;
        this.mWindowContainer.cancelAnimation();
        return;
    }

    void finishSeamlessRotation() {
        this.mSeamlessRotating = false;
    }

    boolean updateClientVisibility(InsetsTarget caller, ImeTracker.Token statsToken) {
        boolean requestedVisible = caller.isRequestedVisible(this.mSource.getType());
        if (caller == this.mControlTarget) goto L5;
        return false;
    L5:
        if (requestedVisible == this.mClientVisible) goto L11;
        setClientVisible(requestedVisible);
        return true;
    L11:
        return false;
    }

    void setClientVisible(boolean clientVisible) {
        if (this.mClientVisible != clientVisible) goto L5;
        return;
    L5:
        this.mClientVisible = clientVisible;
        if (this.mSource.getType() == WindowInsets.Type.ime()) goto L8;
    L10:
        updateVisibility();
        this.mDisplayContent.setLayoutNeeded();
        this.mDisplayContent.mWmService.mWindowPlacerLocked.requestTraversal();
        return;
    L8:
        if (this.mDisplayContent.getDisplayId() != 0) goto L10;
        this.mDisplayContent.mWmService.getExt().updateImeHidingState(false);
        goto L10
    }

    void setServerVisible(boolean serverVisible) {
        this.mServerVisible = serverVisible;
        updateSourceFrameForServerVisibility();
        updateVisibility();
    }

    protected void updateVisibility() {
        InsetsSource r0 = this.mSource;
        if (this.mServerVisible == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        r0.setVisible(r1);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_INSETS_enabled[0] == false) goto L12;
        String protoLogParam0 = String.valueOf(WindowInsets.Type.toString(this.mSource.getType()));
        String protoLogParam1 = String.valueOf(this.mServerVisible);
        String protoLogParam2 = String.valueOf(this.mClientVisible);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_WINDOW_INSETS, -8234068212532234206L, 0, new Object[]{protoLogParam0, protoLogParam1, protoLogParam2});
        return;
    L12:
        return;
    L5:
        if (this.mClientVisible == false) goto L7;
        r1 = true;
        goto L8
    }

    void onAnimatingTypesChanged(InsetsControlTarget caller, ImeTracker.Token statsToken) {
    }

    protected boolean isLeashReadyForDispatching() {
        return isLeashInitialized();
    }

    boolean isLeashInitialized() {
        return this.mIsLeashInitialized;
    }

    InsetsSourceControl getControl(InsetsControlTarget target) {
        if (target != this.mControlTarget) goto L21;
        InsetsPolicy insetsPolicy = this.mDisplayContent.getInsetsPolicy();
        if (this.mSource.getType() != WindowInsets.Type.navigationBars()) goto L13;
        if (insetsPolicy == null) goto L13;
        if (insetsPolicy.mExt == null) goto L13;
        if (insetsPolicy.mExt.shouldTreatNavigationBarHiddenForGestureNavigation() == false) goto L13;
        return null;
    L13:
        if (isLeashReadyForDispatching() == true) goto L19;
        if (this.mControl == null) goto L19;
        return new InsetsSourceControl(this.mControl.getId(), this.mControl.getType(), null, this.mControl.isInitiallyVisible(), this.mControl.getSurfacePosition(), this.mControl.getInsetsHint());
    L19:
        return this.mControl;
    L21:
        if (target == this.mFakeControlTarget) goto L23;
        return null;
    L23:
        return this.mFakeControl;
    }

    protected SurfaceControl getLeash(InsetsControlTarget target) {
        if (target == this.mControlTarget) goto L5;
    L9:
        return null;
    L5:
        if (this.mIsLeashInitialized == false) goto L9;
        if (this.mControl == null) goto L9;
        return this.mControl.getLeash();
    }

    InsetsControlTarget getControlTarget() {
        return this.mControlTarget;
    }

    InsetsControlTarget getFakeControlTarget() {
        return this.mFakeControlTarget;
    }

    boolean isServerVisible() {
        return this.mServerVisible;
    }

    boolean isClientVisible() {
        return this.mClientVisible;
    }

    boolean overridesFrame(int windowType) {
        return this.mOverrideFrames.contains(windowType);
    }

    Rect getOverriddenFrame(int windowType) {
        return this.mOverrideFrames.get(windowType);
    }

    public void dump(PrintWriter pw, String prefix) {
        pw.println(prefix + getClass().getSimpleName());
        String prefix2 = prefix + "  ";
        pw.print(prefix2 + "mSource=");
        this.mSource.dump("", pw);
        pw.print(prefix2 + "mSourceFrame=");
        pw.println(this.mSourceFrame);
        if (this.mOverrideFrames.size() <= 0) goto L6;
        pw.print(prefix2 + "mOverrideFrames=");
        pw.println(this.mOverrideFrames);
    L6:
        if (this.mControl == null) goto L9;
        pw.print(prefix2 + "mControl=");
        this.mControl.dump("", pw);
    L9:
        if (this.mControllable == false) goto L14;
        pw.print(prefix2 + "mInsetsHint=");
        pw.print(this.mInsetsHint);
        if (this.mInsetsHintStale == false) goto L13;
        pw.print(" stale");
    L13:
        pw.println();
    L14:
        pw.print(prefix2);
        pw.print("mIsLeashInitialized=");
        pw.print(this.mIsLeashInitialized);
        pw.print(" mHasPendingPosition=");
        pw.print(this.mHasPendingPosition);
        pw.println();
        if (this.mWindowContainer == null) goto L18;
        pw.print(prefix2 + "mWindowContainer=");
        pw.println(this.mWindowContainer);
    L18:
        if (this.mAdapter == null) goto L21;
        pw.print(prefix2 + "mAdapter=");
        this.mAdapter.dump(pw, "");
    L21:
        if (this.mControlTarget == null) goto L24;
        pw.print(prefix2 + "mControlTarget=");
        pw.println(this.mControlTarget);
    L24:
        if (this.mPendingControlTarget == this.mControlTarget) goto L27;
        pw.print(prefix2 + "mPendingControlTarget=");
        pw.println(this.mPendingControlTarget);
    L27:
        if (this.mFakeControlTarget == null) goto L30;
        pw.print(prefix2 + "mFakeControlTarget=");
        pw.println(this.mFakeControlTarget);
        return;
    }

    void dumpDebug(ProtoOutputStream proto, long fieldId, int logLevel) {
        long token = proto.start(fieldId);
        this.mSource.dumpDebug(proto, 1146756268033L);
        this.mTmpRect.dumpDebug(proto, 1146756268034L);
        this.mFakeControl.dumpDebug(proto, 1146756268035L);
        if (this.mControl == null) goto L6;
        this.mControl.dumpDebug(proto, 1146756268036L);
    L6:
        if (this.mControlTarget == null) goto L11;
        if (this.mControlTarget.getWindow() == null) goto L11;
        this.mControlTarget.getWindow().writeIdentifierToProto(proto, 1146756268049L);
    L11:
        if (this.mPendingControlTarget == null) goto L18;
        if (this.mPendingControlTarget == this.mControlTarget) goto L18;
        if (this.mPendingControlTarget.getWindow() == null) goto L18;
        this.mPendingControlTarget.getWindow().writeIdentifierToProto(proto, 1146756268050L);
    L18:
        if (this.mFakeControlTarget == null) goto L23;
        if (this.mFakeControlTarget.getWindow() == null) goto L23;
        this.mFakeControlTarget.getWindow().writeIdentifierToProto(proto, 1146756268051L);
    L23:
        if (this.mAdapter != null) goto L25;
    L27:
        proto.write(1133871366154L, isLeashReadyForDispatching());
        proto.write(1133871366155L, this.mClientVisible);
        proto.write(1133871366156L, this.mServerVisible);
        proto.write(1133871366157L, this.mSeamlessRotating);
        proto.write(1133871366159L, this.mControllable);
        if (this.mWindowContainer != null) goto L30;
    L32:
        this.mExt.dumpWriteProto(proto);
    L33:
        proto.end(token);
        return;
    L30:
        if (this.mWindowContainer.asWindowState() == null) goto L32;
        this.mWindowContainer.asWindowState().writeIdentifierToProto(proto, 1146756268052L);
        goto L33
    L25:
        if (ControlAdapter.m10018$$Nest$fgetmCapturedLeash(this.mAdapter) == null) goto L27;
        ControlAdapter.m10018$$Nest$fgetmCapturedLeash(this.mAdapter).dumpDebug(proto, 1146756268040L);
        goto L27
    }

    public IExtInsetsSourceProvider getExt() {
        return this.mExt;
    }
}
