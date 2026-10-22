package com.android.server.wm;

import android.R;
import android.app.AppOpsManager;
import android.app.admin.DevicePolicyCache;
import android.app.servertransaction.WindowStateInsetsControlChangeItem;
import android.app.servertransaction.WindowStateResizeItem;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.graphics.GraphicsProtos;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.hardware.audio.common.V2_0.AudioChannelMask;
import android.os.Binder;
import android.os.Debug;
import android.os.IBinder;
import android.os.InputConstants;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.Trace;
import android.os.WorkSource;
import android.pico.utils.ExtImplFactory;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.DisplayMetrics;
import android.util.MergedConfiguration;
import android.util.SequenceUtils;
import android.util.Slog;
import android.util.SparseArray;
import android.util.proto.ProtoOutputStream;
import android.view.DisplayInfo;
import android.view.IWindow;
import android.view.IWindowFocusObserver;
import android.view.IWindowId;
import android.view.InputApplicationHandle;
import android.view.InputChannel;
import android.view.InputWindowHandle;
import android.view.InsetsSource;
import android.view.InsetsSourceControl;
import android.view.InsetsState;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewDebug;
import android.view.WindowInfo;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.inputmethod.ImeTracker;
import android.window.ActivityWindowInfo;
import android.window.ClientWindowFrames;
import android.window.OnBackInvokedCallbackInfo;
import com.android.internal.policy.KeyInterceptionInfo;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.protolog.common.LogLevel;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.ToBooleanFunction;
import com.android.server.ApplicationFreezerHelperSmt;
import com.android.server.SysOptBridge;
import com.android.server.am.SysMonitorSvcBridge;
import com.android.server.common.Constants;
import com.android.server.dispatcher.SystemWindowManagerEventDispatcher;
import com.android.server.job.controllers.JobStatus;
import com.android.server.policy.WindowManagerPolicy;
import com.android.server.wm.utils.RegionUtils;
import com.obric.utils.ObricImplFactory;
import dalvik.annotation.optimization.NeverCompile;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
public class WindowState extends WindowContainer<WindowState> implements WindowManagerPolicy.WindowState, InsetsControlTarget, InputTarget {
    static final int BLAST_TIMEOUT_DURATION = 5000;
    static final int EXCLUSION_LEFT = 0;
    static final int EXCLUSION_RIGHT = 1;
    static final int EXIT_ANIMATING_TYPES = 17;
    static final int LEGACY_POLICY_VISIBILITY = 1;
    static final int MINIMUM_VISIBLE_HEIGHT_IN_DP = 32;
    static final int MINIMUM_VISIBLE_WIDTH_IN_DP = 48;
    private static final int POLICY_VISIBILITY_ALL = 3;
    static final int RESIZE_HANDLE_WIDTH_IN_DP = 30;
    static final String TAG = "WindowManager";
    private static final int VISIBLE_FOR_USER = 2;
    private static final StringBuilder sTmpSB = null;
    private static final Comparator<WindowState> sWindowSubLayerComparator = null;
    final InsetsState mAboveInsetsState;
    ActivityRecord mActivityRecord;
    boolean mAnimatingExit;
    private int mAnimatingTypes;
    final int mAppOp;
    private boolean mAppOpVisibility;
    final WindowManager.LayoutParams mAttrs;
    final int mBaseLayer;
    final IWindow mClient;
    float mCompatScale;
    final Context mContext;
    private long mCreateTime;
    boolean mDestroying;
    int mDisableFlags;
    private boolean mDragResizing;
    private boolean mDragResizingChangeReported;
    private final List<DrawHandler> mDrawHandlers;
    private PowerManager.WakeLock mDrawLock;
    private boolean mDrawnStateEvaluated;
    private final List<Rect> mExclusionRects;
    private IExtWindowState mExt;
    private RemoteCallbackList<IWindowFocusObserver> mFocusCallbacks;
    private boolean mForceHideNonSystemOverlayWindow;
    final boolean mForceSeamlesslyRotate;
    int mFrameRateSelectionPriority;
    RefreshRatePolicy.FrameRateVote mFrameRateVote;
    private InsetsState mFrozenInsetsState;
    final Rect mGivenContentInsets;
    boolean mGivenInsetsPending;
    final Region mGivenTouchableRegion;
    final Rect mGivenVisibleInsets;
    float mGlobalScale;
    float mHScale;
    boolean mHasSurface;
    boolean mHaveFrame;
    boolean mHidden;
    private boolean mHiddenWhileSuspended;
    boolean mImeInsetsConsumed;
    boolean mInRelayout;
    IBinder mInputChannelToken;
    final InputWindowHandleWrapper mInputWindowHandle;
    private boolean mInsetsAnimationRunning;
    float mInvGlobalScale;
    private boolean mIsChildWindow;
    private boolean mIsDimming;
    private final boolean mIsFloatingLayer;
    final boolean mIsImWindow;
    boolean mIsSurfacePositionPaused;
    final boolean mIsWallpaper;
    private final List<Rect> mKeepClearAreas;
    private KeyInterceptionInfo mKeyInterceptionInfo;
    private boolean mLastConfigReportedToClient;
    private final long[] mLastExclusionLogUptimeMillis;
    private final int[] mLastGrantedExclusionHeight;
    float mLastHScale;
    private final InsetsSourceControl.Array mLastReportedActiveControls;
    final ActivityWindowInfo mLastReportedActivityWindowInfo;
    private final MergedConfiguration mLastReportedConfiguration;
    private final ClientWindowFrames mLastReportedFrames;
    private final InsetsState mLastReportedInsetsState;
    private final int[] mLastRequestedExclusionHeight;
    private int mLastRequestedHeight;
    private int mLastRequestedWidth;
    private boolean mLastShownChangedReported;
    final Rect mLastSurfaceInsets;
    private CharSequence mLastTitle;
    float mLastVScale;
    int mLayer;
    final boolean mLayoutAttached;
    boolean mLayoutNeeded;
    int mLayoutSeq;
    boolean mLegacyPolicyVisibilityAfterAnim;
    SparseArray<InsetsSource> mMergedLocalInsetsSources;
    private boolean mMovedByResize;
    private IObricWindowState mObricExt;
    boolean mObscured;
    private OnBackInvokedCallbackInfo mOnBackInvokedCallbackInfo;
    private long mOrientationChangeRedrawRequestTime;
    final float mOverrideScale;
    final boolean mOwnerCanAddInternalSystemWindow;
    final int mOwnerUid;
    boolean mPermanentlyHidden;
    final WindowManagerPolicy mPolicy;
    private int mPolicyVisibility;
    int mPrepareSyncSeqId;
    private boolean mRedrawForSyncReported;
    boolean mRelayoutCalled;
    int mRelayoutSeq;
    boolean mRemoveOnExit;
    boolean mRemoved;
    int mRequestedHeight;
    private int mRequestedVisibleTypes;
    int mRequestedWidth;
    final Session mSession;
    private final Consumer<SurfaceControl.Transaction> mSetSurfacePositionConsumer;
    boolean mShouldScaleWallpaper;
    final int mShowUserId;
    StartingData mStartingData;
    private String mStringNameCache;
    final int mSubLayer;
    boolean mSurfacePlacementNeeded;
    final Point mSurfacePosition;
    private int mSurfaceTranslationY;
    int mSyncSeqId;
    private final Region mTapExcludeRegion;
    private final Configuration mTempConfiguration;
    final Matrix mTmpMatrix;
    final float[] mTmpMatrixArray;
    private final Point mTmpPoint;
    private final Rect mTmpRect;
    private final Region mTmpRegion;
    private final SurfaceControl.Transaction mTmpTransaction;
    WindowToken mToken;
    int mTouchableInsets;
    private final List<Rect> mUnrestrictedKeepClearAreas;
    float mVScale;
    int mViewVisibility;
    int mWallpaperDisplayOffsetX;
    int mWallpaperDisplayOffsetY;
    float mWallpaperScale;
    float mWallpaperX;
    float mWallpaperXStep;
    float mWallpaperY;
    float mWallpaperYStep;
    float mWallpaperZoomOut;
    private boolean mWasExiting;
    final WindowStateAnimator mWinAnimator;
    private final WindowFrames mWindowFrames;
    final WindowId mWindowId;
    boolean mWindowRemovalAllowed;
    int mXOffset;
    int mYOffset;

    class DrawHandler {
        Consumer<SurfaceControl.Transaction> mConsumer;
        int mSeqId;

        DrawHandler(WindowState this$0, int seqId, Consumer<SurfaceControl.Transaction> consumer) {
            this.mSeqId = seqId;
            this.mConsumer = consumer;
        }
    }

    private final class MoveAnimationSpec implements LocalAnimationAdapter.AnimationSpec {
        private final Point mCurrentPosition;
        private final long mDuration;
        private Point mFrom;
        private Interpolator mInterpolator;
        private Point mTo;

        /* synthetic */ MoveAnimationSpec(WindowState r1, int r2, int r3, int r4, int r5, WindowStateIA r6) {
            this(r1, r2, r3, r4, r5);
        }

        private MoveAnimationSpec(WindowState r4, int fromX, int fromY, int toX, int toY) {
            this.mFrom = new Point();
            this.mTo = new Point();
            this.mCurrentPosition = new Point();
            Animation anim = AnimationUtils.loadAnimation(r4.mContext, R.anim.resolver_close_anim);
            this.mDuration = (long) (anim.computeDurationHint() * r4.mWmService.getWindowAnimationScaleLocked());
            this.mInterpolator = anim.getInterpolator();
            this.mFrom.set(fromX, fromY);
            this.mTo.set(toX, toY);
            this.mCurrentPosition.set(fromX, fromY);
        }

        @Override // com.android.server.wm.LocalAnimationAdapter.AnimationSpec
        public long getDuration() {
            return this.mDuration;
        }

        @Override // com.android.server.wm.LocalAnimationAdapter.AnimationSpec
        public void apply(SurfaceControl.Transaction t, SurfaceControl leash, long currentPlayTime) {
            float fraction = getFraction(currentPlayTime);
            float v = this.mInterpolator.getInterpolation(fraction);
            this.mCurrentPosition.set(this.mFrom.x + ((int) ((this.mTo.x - this.mFrom.x) * v)), this.mFrom.y + ((int) ((this.mTo.y - this.mFrom.y) * v)));
            t.setPosition(leash, this.mCurrentPosition.x, this.mCurrentPosition.y);
        }

        Point getCurrentPosition() {
            return this.mCurrentPosition;
        }

        @Override // com.android.server.wm.LocalAnimationAdapter.AnimationSpec
        public Point getLeashPosition() {
            return this.mCurrentPosition;
        }

        @Override // com.android.server.wm.LocalAnimationAdapter.AnimationSpec
        public void dump(PrintWriter pw, String prefix) {
            pw.println(prefix + "from=" + this.mFrom + " to=" + this.mTo + " duration=" + this.mDuration);
        }

        @Override // com.android.server.wm.LocalAnimationAdapter.AnimationSpec
        public void dumpDebugInner(ProtoOutputStream proto) {
            long token = proto.start(1146756268034L);
            GraphicsProtos.dumpPointProto(this.mFrom, proto, 1146756268033L);
            GraphicsProtos.dumpPointProto(this.mTo, proto, 1146756268034L);
            proto.write(1112396529667L, this.mDuration);
            proto.end(token);
        }
    }

    static final class UpdateReportedVisibilityResults {
        boolean nowGone;
        int numDrawn;
        int numInteresting;
        int numVisible;

        UpdateReportedVisibilityResults() {
            this.nowGone = true;
        }

        void reset() {
            this.numInteresting = 0;
            this.numVisible = 0;
            this.numDrawn = 0;
            this.nowGone = true;
        }
    }

    private static final class WindowId extends IWindowId.Stub {
        private final WeakReference<WindowState> mOuter;

        /* synthetic */ WindowId(WindowState r1, WindowStateIA r2) {
            this(r1);
        }

        private WindowId(WindowState outer) {
            this.mOuter = new WeakReference(outer);
        }

        public void registerFocusObserver(IWindowFocusObserver observer) {
            WindowState outer = this.mOuter.get();
            if (outer == null) goto L6;
            outer.registerFocusObserver(observer);
            return;
        }

        public void unregisterFocusObserver(IWindowFocusObserver observer) {
            WindowState outer = this.mOuter.get();
            if (outer == null) goto L6;
            outer.unregisterFocusObserver(observer);
            return;
        }

        public boolean isFocused() {
            WindowState outer = this.mOuter.get();
            if (outer == null) goto L14;
            WindowManagerGlobalLock r1 = outer.mWmService.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r1);
            boolean r2 = outer.isFocused();     // Catch: Throwable -> L10
            monitor-exit(r1);     // Catch: Throwable -> L10
            WindowManagerService.resetPriorityAfterLockedSection();
            return r2;
        L10:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        L14:
            return false;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$1Dh42fMlKh0smzISa_42i-8OSNI, reason: not valid java name */
    public static /* synthetic */ void m10479$r8$lambda$1Dh42fMlKh0smzISa_42i8OSNI(InsetsState r0, ArraySet r1, SparseArray r2, WindowState r3) {
        lambda$updateAboveInsetsState$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$QQ19J5HQy2zH20YYKv231qLt20A(WindowState r0) {
        return lambda$removeIfPossible$1(r0);
    }

    public static /* synthetic */ void $r8$lambda$uQyra3OObpru_TLpWVa2wpurdwc(WindowState r0, SurfaceControl.Transaction r1) {
        r0.lambda$new$0(r1);
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public /* bridge */ /* synthetic */ void commitPendingTransaction() {
        super.commitPendingTransaction();
    }

    @Override // com.android.server.wm.WindowContainer
    public /* bridge */ /* synthetic */ int compareTo(WindowContainer r1) {
        return super.compareTo(r1);
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public /* bridge */ /* synthetic */ SurfaceControl getAnimationLeash() {
        return super.getAnimationLeash();
    }

    @Override // com.android.server.wm.WindowContainer
    public /* bridge */ /* synthetic */ IExtWindowContainer getExtWindowContainer() {
        return super.getExtWindowContainer();
    }

    @Override // com.android.server.wm.WindowContainer
    public /* bridge */ /* synthetic */ SparseArray getInsetsSourceProviders() {
        return super.getInsetsSourceProviders();
    }

    @Override // com.android.server.wm.WindowContainer
    public /* bridge */ /* synthetic */ IObricWindowContainer getObricExtWindowContainer() {
        return super.getObricExtWindowContainer();
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public /* bridge */ /* synthetic */ SurfaceControl getParentSurfaceControl() {
        return super.getParentSurfaceControl();
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public /* bridge */ /* synthetic */ SurfaceControl.Transaction getPendingTransaction() {
        return super.getPendingTransaction();
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public /* bridge */ /* synthetic */ SurfaceControl getSurfaceControl() {
        return super.getSurfaceControl();
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public /* bridge */ /* synthetic */ int getSurfaceHeight() {
        return super.getSurfaceHeight();
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public /* bridge */ /* synthetic */ int getSurfaceWidth() {
        return super.getSurfaceWidth();
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public /* bridge */ /* synthetic */ SurfaceControl.Transaction getSyncTransaction() {
        return super.getSyncTransaction();
    }

    @Override // com.android.server.wm.WindowContainer
    public /* bridge */ /* synthetic */ WindowContainerSysEx getWindowContainerSysEx() {
        return super.getWindowContainerSysEx();
    }

    @Override // com.android.server.wm.WindowContainer
    public /* bridge */ /* synthetic */ boolean hasInsetsSourceProvider() {
        return super.hasInsetsSourceProvider();
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public /* bridge */ /* synthetic */ SurfaceControl.Builder makeAnimationLeash() {
        return super.makeAnimationLeash();
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public /* bridge */ /* synthetic */ void onAnimationLeashLost(SurfaceControl.Transaction r1) {
        super.onAnimationLeashLost(r1);
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.ConfigurationContainer
    public /* bridge */ /* synthetic */ void onRequestedOverrideConfigurationChanged(Configuration r1) {
        super.onRequestedOverrideConfigurationChanged(r1);
    }

    static {
        sTmpSB = new StringBuilder();
        sWindowSubLayerComparator = new AnonymousClass1();
    }

    private /* synthetic */ void lambda$new$0(SurfaceControl.Transaction t) {
        if (this.mSurfaceControl != null) goto L5;
        return;
    L5:
        if (this.mSurfaceControl.isValid() == true) goto L7;
        return;
    L7:
        if (this.mSurfaceAnimator.hasLeash() == true) goto L12;
        t.setPosition(this.mSurfaceControl, this.mSurfacePosition.x, this.mSurfacePosition.y);
        return;
    }

    @Override // com.android.server.wm.WindowContainer
    WindowState asWindowState() {
        return this;
    }

    @Override // com.android.server.wm.InsetsControlTarget, com.android.server.wm.InsetsTarget
    public boolean isRequestedVisible(int types) {
        if ((this.mRequestedVisibleTypes & types) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.wm.InsetsControlTarget, com.android.server.wm.InsetsTarget
    public int getRequestedVisibleTypes() {
        return this.mRequestedVisibleTypes;
    }

    int setRequestedVisibleTypes(int requestedVisibleTypes) {
        int requestedVisibleTypes2 = getExt().adjustRequestedVisibleTypes(requestedVisibleTypes);
        if (this.mRequestedVisibleTypes == requestedVisibleTypes2) goto L6;
        int changedTypes = this.mRequestedVisibleTypes ^ requestedVisibleTypes2;
        this.mRequestedVisibleTypes = requestedVisibleTypes2;
        return changedTypes;
    L6:
        return 0;
    }

    int setRequestedVisibleTypes(int requestedVisibleTypes, int mask) {
        return setRequestedVisibleTypes((this.mRequestedVisibleTypes & (~mask)) | (requestedVisibleTypes & mask));
    }

    @Override // com.android.server.wm.InsetsControlTarget
    public int getAnimatingTypes() {
        return this.mAnimatingTypes;
    }

    @Override // com.android.server.wm.InsetsControlTarget
    public void setAnimatingTypes(int animatingTypes, ImeTracker.Token statsToken) {
        if (this.mAnimatingTypes != animatingTypes) goto L5;
        ImeTracker.forLogging().onFailed(statsToken, 73);
        return;
    L5:
        if (Trace.isTagEnabled(32) == false) goto L7;
        Trace.instant(32, TextUtils.formatSimple("%s: setAnimatingTypes(%s)", new Object[]{getName(), Integer.valueOf(animatingTypes)}));
    L7:
        if (animatingTypes == 0) goto L9;
        boolean r0 = true;
    L10:
        this.mInsetsAnimationRunning = r0;
        this.mWmService.scheduleAnimationLocked();
        this.mAnimatingTypes = animatingTypes;
        return;
    L9:
        r0 = false;
        goto L10
    }

    void freezeInsetsState() {
        if (this.mFrozenInsetsState != null) goto L6;
        this.mFrozenInsetsState = new InsetsState(getInsetsState(), true);
        return;
    }

    void clearFrozenInsetsState() {
        this.mFrozenInsetsState = null;
    }

    InsetsState getFrozenInsetsState() {
        return this.mFrozenInsetsState;
    }

    boolean isReadyToDispatchInsetsState() {
        if (this.mStartingData == null) goto L6;
        return false;
    L6:
        if (shouldCheckTokenVisibleRequested() == false) goto L8;
        boolean visible = isVisibleRequested();
    L9:
        if (visible == true) goto L11;
        return false;
    L11:
        if (this.mFrozenInsetsState != null) goto L15;
        return true;
    L15:
        return false;
    L8:
        visible = isVisible();
        goto L9
    }

    List<Rect> getSystemGestureExclusion() {
        return this.mExclusionRects;
    }

    boolean setSystemGestureExclusion(List<Rect> exclusionRects) {
        if (this.mExclusionRects.equals(exclusionRects) == false) goto L6;
        return false;
    L6:
        this.mExclusionRects.clear();
        this.mExclusionRects.addAll(exclusionRects);
        return true;
    }

    boolean isImplicitlyExcludingAllSystemGestures() {
        if (this.mAttrs.insetsFlags.behavior == 2) goto L5;
    L7:
        boolean stickyHideNav = false;
    L9:
        if (stickyHideNav == true) goto L11;
        return false;
    L11:
        if (this.mWmService.mConstants.mSystemGestureExcludedByPreQStickyImmersive == true) goto L13;
        return false;
    L13:
        if (this.mActivityRecord != null) goto L15;
        return false;
    L15:
        if (this.mActivityRecord.mTargetSdk < 29) goto L17;
        return false;
    L17:
        return true;
    L5:
        if (isRequestedVisible(WindowInsets.Type.navigationBars()) == true) goto L7;
        stickyHideNav = true;
        goto L9
    }

    void setLastExclusionHeights(int side, int requested, int granted) {
        if (this.mLastGrantedExclusionHeight[side] == granted) goto L5;
    L8:
        boolean changed = true;
    L9:
        if (changed == true) goto L11;
        return;
    L11:
        if (this.mLastShownChangedReported == false) goto L13;
        logExclusionRestrictions(side);
    L13:
        this.mLastGrantedExclusionHeight[side] = granted;
        this.mLastRequestedExclusionHeight[side] = requested;
        return;
    L5:
        if (this.mLastRequestedExclusionHeight[side] != requested) goto L8;
        changed = false;
        goto L9
    }

    void getKeepClearAreas(Collection<Rect> outRestricted, Collection<Rect> outUnrestricted) {
        Matrix tmpMatrix = new Matrix();
        float[] tmpFloat9 = new float[9];
        getKeepClearAreas(outRestricted, outUnrestricted, tmpMatrix, tmpFloat9);
    }

    void getKeepClearAreas(Collection<Rect> outRestricted, Collection<Rect> outUnrestricted, Matrix tmpMatrix, float[] float9) {
        outRestricted.addAll(getRectsInScreenSpace(this.mKeepClearAreas, tmpMatrix, float9));
        outUnrestricted.addAll(getRectsInScreenSpace(this.mUnrestrictedKeepClearAreas, tmpMatrix, float9));
    }

    List<Rect> getRectsInScreenSpace(List<Rect> rects, Matrix tmpMatrix, float[] float9) {
        getTransformationMatrix(float9, tmpMatrix);
        List<Rect> transformedRects = new ArrayList();
        RectF tmpRect = new RectF();
        Iterator<Rect> r2 = rects.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Rect r = r2.next();
        tmpRect.set(r);
        tmpMatrix.mapRect(tmpRect);
        Rect curr = new Rect();
        tmpRect.roundOut(curr);
        transformedRects.add(curr);
        goto L4
    L6:
        return transformedRects;
    }

    boolean setKeepClearAreas(List<Rect> restricted, List<Rect> unrestricted) {
        boolean newRestrictedAreas = !this.mKeepClearAreas.equals(restricted);
        boolean newUnrestrictedAreas = !this.mUnrestrictedKeepClearAreas.equals(unrestricted);
        if (newRestrictedAreas == true) goto L7;
        if (newUnrestrictedAreas == true) goto L7;
        return false;
    L7:
        if (newRestrictedAreas == false) goto L9;
        this.mKeepClearAreas.clear();
        this.mKeepClearAreas.addAll(restricted);
    L9:
        if (newUnrestrictedAreas == false) goto L11;
        this.mUnrestrictedKeepClearAreas.clear();
        this.mUnrestrictedKeepClearAreas.addAll(unrestricted);
    L11:
        return true;
    }

    void setOnBackInvokedCallbackInfo(OnBackInvokedCallbackInfo callbackInfo) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_BACK_PREVIEW_enabled[0] == false) goto L5;
        String protoLogParam0 = String.valueOf(this);
        String protoLogParam1 = String.valueOf(callbackInfo);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_BACK_PREVIEW, -7237767461056267619L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L5:
        this.mOnBackInvokedCallbackInfo = callbackInfo;
    }

    OnBackInvokedCallbackInfo getOnBackInvokedCallbackInfo() {
        return this.mOnBackInvokedCallbackInfo;
    }

    WindowState(WindowManagerService service, Session s, IWindow c, WindowToken token, WindowState parentWindow, int appOp, WindowManager.LayoutParams a, int viewVisibility, int ownerId, int showUserId, boolean ownerCanAddInternalSystemWindow) {
        super(service);
        this.mAttrs = new WindowManager.LayoutParams();
        this.mPolicyVisibility = 3;
        this.mLegacyPolicyVisibilityAfterAnim = true;
        this.mAppOpVisibility = true;
        this.mHidden = true;
        this.mDragResizingChangeReported = true;
        this.mRedrawForSyncReported = true;
        this.mCreateTime = System.currentTimeMillis();
        this.mSyncSeqId = 0;
        this.mPrepareSyncSeqId = 0;
        this.mRelayoutSeq = -1;
        this.mLayoutSeq = -1;
        this.mLastReportedConfiguration = new MergedConfiguration();
        this.mLastReportedFrames = new ClientWindowFrames();
        this.mLastReportedInsetsState = new InsetsState();
        this.mLastReportedActiveControls = new InsetsSourceControl.Array();
        this.mTempConfiguration = new Configuration();
        this.mGivenContentInsets = new Rect();
        this.mGivenVisibleInsets = new Rect();
        this.mGivenTouchableRegion = new Region();
        this.mTouchableInsets = 0;
        this.mGlobalScale = 1.0f;
        this.mInvGlobalScale = 1.0f;
        this.mCompatScale = 1.0f;
        this.mHScale = 1.0f;
        this.mVScale = 1.0f;
        this.mLastHScale = 1.0f;
        this.mLastVScale = 1.0f;
        this.mXOffset = 0;
        this.mYOffset = 0;
        this.mWallpaperScale = 1.0f;
        this.mTmpMatrix = new Matrix();
        this.mTmpMatrixArray = new float[9];
        this.mWindowFrames = new WindowFrames();
        this.mExclusionRects = new ArrayList();
        this.mKeepClearAreas = new ArrayList();
        this.mUnrestrictedKeepClearAreas = new ArrayList();
        this.mLastRequestedExclusionHeight = new int[]{0, 0};
        this.mLastGrantedExclusionHeight = new int[]{0, 0};
        this.mLastExclusionLogUptimeMillis = new long[]{0, 0};
        this.mWallpaperX = -1.0f;
        this.mWallpaperY = -1.0f;
        this.mWallpaperZoomOut = -1.0f;
        this.mWallpaperXStep = -1.0f;
        this.mWallpaperYStep = -1.0f;
        this.mWallpaperDisplayOffsetX = Integer.MIN_VALUE;
        this.mWallpaperDisplayOffsetY = Integer.MIN_VALUE;
        this.mHasSurface = false;
        this.mTmpRect = new Rect();
        this.mTmpPoint = new Point();
        this.mTmpRegion = new Region();
        this.mImeInsetsConsumed = false;
        this.mAboveInsetsState = new InsetsState();
        this.mMergedLocalInsetsSources = null;
        this.mLastSurfaceInsets = new Rect();
        this.mSurfacePosition = new Point();
        this.mTapExcludeRegion = new Region();
        this.mIsDimming = false;
        this.mRequestedVisibleTypes = WindowInsets.Type.defaultVisible();
        this.mAnimatingTypes = 0;
        this.mFrameRateSelectionPriority = -1;
        this.mFrameRateVote = new RefreshRatePolicy.FrameRateVote();
        this.mObricExt = (IObricWindowState) ObricImplFactory.getImpl(IObricWindowState.class, new Object[]{this});
        this.mDrawHandlers = new ArrayList();
        this.mSetSurfacePositionConsumer = new WindowState$$ExternalSyntheticLambda0(this);
        this.mExt = (IExtWindowState) ExtImplFactory.getImpl(IExtWindowState.class, new Object[]{this});
        this.mTmpTransaction = service.mTransactionFactory.get();
        this.mSession = s;
        this.mClient = c;
        this.mAppOp = appOp;
        this.mToken = token;
        this.mDisplayContent = token.mDisplayContent;
        this.mActivityRecord = this.mToken.asActivityRecord();
        this.mOwnerUid = ownerId;
        this.mShowUserId = showUserId;
        this.mOwnerCanAddInternalSystemWindow = ownerCanAddInternalSystemWindow;
        this.mWindowId = new WindowId(this, null);
        this.mAttrs.copyFrom(a);
        this.mLastSurfaceInsets.set(this.mAttrs.surfaceInsets);
        this.mViewVisibility = viewVisibility;
        this.mPolicy = this.mWmService.mPolicy;
        this.mContext = this.mWmService.mContext;
        this.mForceSeamlesslyRotate = token.mRoundedCornerOverlay;
        if (this.mActivityRecord == null) goto L5;
        ActivityWindowInfo r15 = new ActivityWindowInfo();
    L6:
        this.mLastReportedActivityWindowInfo = r15;
        if (this.mActivityRecord == null) goto L9;
        InputApplicationHandle r5 = this.mActivityRecord.getInputApplicationHandle(false);
    L10:
        this.mInputWindowHandle = new InputWindowHandleWrapper(new InputWindowHandle(r5, getDisplayId()));
        this.mInputWindowHandle.setFocusable(false);
        this.mInputWindowHandle.setOwnerPid(s.mPid);
        this.mInputWindowHandle.setOwnerUid(s.mUid);
        this.mInputWindowHandle.setName(getName());
        this.mInputWindowHandle.setPackageName(this.mAttrs.packageName);
        this.mInputWindowHandle.setGameApp(resolveGameAppForTouchFirstFrameEarlyVsync(this.mAttrs.packageName));
        this.mInputWindowHandle.setLayoutParamsType(this.mAttrs.type);
        if (WindowManagerDebugConfig.DEBUG == false) goto L14;
        Slog.v(TAG, "Window " + this + " client=" + c.asBinder() + " token=" + token + " (" + this.mAttrs.token + ") params=" + a);
    L14:
        if (this.mAttrs.type >= 1000) goto L16;
    L33:
        this.mBaseLayer = (this.mPolicy.getWindowLayerLw(this) * 10000) + 1000;
        this.mSubLayer = 0;
        this.mIsChildWindow = false;
        this.mLayoutAttached = false;
        if (this.mAttrs.type != 2011) goto L36;
    L39:
        boolean r6 = true;
    L40:
        this.mIsImWindow = r6;
        if (this.mAttrs.type != 2013) goto L43;
        boolean r7 = true;
    L44:
        this.mIsWallpaper = r7;
    L46:
        if (this.mIsImWindow == false) goto L48;
    L51:
        boolean r8 = true;
    L52:
        this.mIsFloatingLayer = r8;
        if (this.mActivityRecord != null) goto L55;
    L57:
        this.mWinAnimator = new WindowStateAnimator(this);
        this.mWinAnimator.mAlpha = a.alpha;
        this.mRequestedWidth = -1;
        this.mRequestedHeight = -1;
        this.mLastRequestedWidth = -1;
        this.mLastRequestedHeight = -1;
        this.mLayer = 0;
        this.mOverrideScale = this.mWmService.mAtmService.mCompatModePackages.getCompatScale(this.mAttrs.packageName, s.mUid);
        updateGlobalScale();
        if (this.mIsChildWindow == true) goto L60;
    L63:
        getExt().onInitCompleted();
        SysMonitorSvcBridge.getFactory().getAnrMonitor().notifyObjectCreate(this);
        return;
    L60:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[1] == false) goto L62;
        String protoLogParam0 = String.valueOf(this);
        String protoLogParam1 = String.valueOf(parentWindow);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, 8135615413833185273L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L62:
        parentWindow.addChild(this, sWindowSubLayerComparator);
        goto L63
    L55:
        if (this.mActivityRecord.mShowForAllUsers == false) goto L57;
        this.mAttrs.flags |= 524288;
        goto L57
    L48:
        if (this.mIsWallpaper == true) goto L51;
        r8 = false;
        goto L52
    L43:
        r7 = false;
        goto L44
    L36:
        if (this.mAttrs.type == 2012) goto L39;
        r6 = false;
        goto L40
    L16:
        if (this.mAttrs.type > 1999) goto L33;
        this.mBaseLayer = (this.mPolicy.getWindowLayerLw(parentWindow) * 10000) + 1000;
        this.mSubLayer = this.mPolicy.getSubWindowLayerFromTypeLw(a.type);
        this.mIsChildWindow = true;
        if (this.mAttrs.type == 1003) goto L20;
        boolean r9 = true;
    L21:
        this.mLayoutAttached = r9;
        if (parentWindow.mAttrs.type != 2011) goto L24;
    L27:
        boolean r10 = true;
    L28:
        this.mIsImWindow = r10;
        if (parentWindow.mAttrs.type != 2013) goto L31;
        boolean r11 = true;
    L32:
        this.mIsWallpaper = r11;
        goto L46
    L31:
        r11 = false;
        goto L32
    L24:
        if (parentWindow.mAttrs.type == 2012) goto L27;
        r10 = false;
        goto L28
    L20:
        r9 = false;
        goto L21
    L9:
        r5 = null;
        goto L10
    L5:
        r15 = null;
        goto L6
    }

    private boolean resolveGameAppForTouchFirstFrameEarlyVsync(String packageName) {
        if (TextUtils.isEmpty(packageName) == false) goto L10;
        return true;
    L10:
        return SysOptBridge.getFactory().getAppRecordManagerService().isGameApp(packageName);
    L7:
        e = move-exception;
        Slog.w(TAG, "resolveGameAppForTouchFirstFrameEarlyVsync failed for " + packageName, e);
        return true;
    }

    @Override // com.android.server.wm.WindowContainer
    void setInitialSurfaceControlProperties(SurfaceControl.Builder b) {
        super.setInitialSurfaceControlProperties(b);
        if (isWindowTrustedOverlay() == false) goto L5;
        getPendingTransaction().setTrustedOverlay(this.mSurfaceControl, true);
    L5:
        getPendingTransaction().setSecure(this.mSurfaceControl, isSecureLocked());
        boolean canOccludePresentation = !this.mSession.mCanAddInternalSystemWindow;
        getPendingTransaction().setCanOccludePresentation(this.mSurfaceControl, canOccludePresentation);
    }

    void updateTrustedOverlay() {
        this.mInputWindowHandle.setTrustedOverlay(getPendingTransaction(), this.mSurfaceControl, isWindowTrustedOverlay());
        this.mInputWindowHandle.forceChange();
    }

    boolean isWindowTrustedOverlay() {
        if (InputMonitor.isTrustedOverlay(this.mAttrs.type) == false) goto L5;
    L14:
        return true;
    L5:
        if ((this.mAttrs.privateFlags & 536870912) == 0) goto L9;
        if (this.mSession.mCanAddInternalSystemWindow == true) goto L14;
    L9:
        if ((this.mAttrs.privateFlags & 8) != 0) goto L11;
    L13:
        return false;
    L11:
        if (this.mSession.mCanCreateSystemApplicationOverlay == false) goto L13;
        goto L13
    }

    int getTouchOcclusionMode() {
        if (WindowManager.LayoutParams.isSystemAlertWindowType(this.mAttrs.type) == false) goto L6;
        return 1;
    L6:
        if (isAnimating(3, -1) == false) goto L8;
    L12:
        return 1;
    L8:
        if (inTransition() == true) goto L12;
        return 0;
    }

    void updateGlobalScale() {
        if (hasCompatScale() == true) goto L5;
        this.mCompatScale = 1.0f;
        this.mInvGlobalScale = 1.0f;
        this.mGlobalScale = 1.0f;
        return;
    L5:
        if (this.mOverrideScale != 1.0f) goto L7;
    L10:
        float r0 = this.mToken.getCompatScale();
    L11:
        this.mCompatScale = r0;
        this.mGlobalScale = this.mCompatScale * this.mOverrideScale;
        this.mInvGlobalScale = 1.0f / this.mGlobalScale;
        return;
    L7:
        if (this.mToken.hasSizeCompatBounds() == true) goto L10;
        r0 = 1.0f;
        goto L11
    }

    float getCompatScaleForClient() {
        if (this.mToken.hasSizeCompatBounds() == false) goto L6;
        return 1.0f;
    L6:
        return this.mCompatScale;
    }

    boolean hasCompatScale() {
        if (this.mAttrs.type != 3) goto L6;
        return false;
    L6:
        if (this.mWmService.mAtmService.mCompatModePackages.useLegacyScreenCompatMode(this.mSession.mProcess.mInfo.packageName) == false) goto L9;
        return true;
    L9:
        if (this.mActivityRecord == null) goto L13;
        if (this.mActivityRecord.hasSizeCompatBounds() == false) goto L13;
    L15:
        return true;
    L13:
        if (this.mOverrideScale != 1.0f) goto L15;
        return false;
    }

    boolean getDrawnStateEvaluated() {
        return this.mDrawnStateEvaluated;
    }

    void setDrawnStateEvaluated(boolean evaluated) {
        this.mDrawnStateEvaluated = evaluated;
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.ConfigurationContainer
    void onParentChanged(ConfigurationContainer newParent, ConfigurationContainer oldParent) {
        super.onParentChanged(newParent, oldParent);
        setDrawnStateEvaluated(false);
        getDisplayContent().reapplyMagnificationSpec();
    }

    int getOwningUid() {
        return this.mOwnerUid;
    }

    @Override // com.android.server.policy.WindowManagerPolicy.WindowState
    public String getOwningPackage() {
        return this.mAttrs.packageName;
    }

    @Override // com.android.server.policy.WindowManagerPolicy.WindowState
    public boolean canAddInternalSystemWindow() {
        return this.mOwnerCanAddInternalSystemWindow;
    }

    boolean skipLayout() {
        if (this.mActivityRecord != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mActivityRecord.mWaitForEnteringPinnedMode == false) goto L7;
        return true;
    }

    void setFrames(ClientWindowFrames clientWindowFrames, int requestedWidth, int requestedHeight) {
        WindowFrames windowFrames = this.mWindowFrames;
        this.mTmpRect.set(windowFrames.mParentFrame);
        windowFrames.mDisplayFrame.set(clientWindowFrames.displayFrame);
        windowFrames.mParentFrame.set(clientWindowFrames.parentFrame);
        windowFrames.mFrame.set(clientWindowFrames.frame);
        windowFrames.mCompatFrame.set(windowFrames.mFrame);
        if (this.mInvGlobalScale == 1.0f) goto L5;
        windowFrames.mCompatFrame.scale(this.mInvGlobalScale);
    L5:
        windowFrames.setParentFrameWasClippedByDisplayCutout(clientWindowFrames.isParentFrameClippedByDisplayCutout);
        windowFrames.mRelFrame.set(windowFrames.mFrame);
        WindowContainer<?> parent = getParent();
        int parentLeft = 0;
        int parentTop = 0;
        if (this.mIsChildWindow == false) goto L8;
        parentLeft = ((WindowState) parent).mWindowFrames.mFrame.left;
        parentTop = ((WindowState) parent).mWindowFrames.mFrame.top;
    L10:
        windowFrames.mRelFrame.offsetTo(windowFrames.mFrame.left - parentLeft, windowFrames.mFrame.top - parentTop);
        if (requestedWidth == this.mLastRequestedWidth) goto L13;
    L16:
        this.mLastRequestedWidth = requestedWidth;
        this.mLastRequestedHeight = requestedHeight;
        windowFrames.setContentChanged(true);
    L18:
        if (windowFrames.mFrame.equals(windowFrames.mLastFrame) == true) goto L20;
    L21:
        this.mWmService.mFrameChangingWindows.add(this);
    L23:
        if (this.mAttrs.type != 2034) goto L28;
        if (windowFrames.mFrame.equals(windowFrames.mLastFrame) == true) goto L28;
        this.mMovedByResize = true;
    L28:
        if (this.mIsWallpaper == false) goto L34;
        Rect lastFrame = windowFrames.mLastFrame;
        Rect frame = windowFrames.mFrame;
        if (lastFrame.width() == frame.width()) goto L32;
    L33:
        this.mDisplayContent.mWallpaperController.updateWallpaperOffset(this, false);
        goto L34
    L32:
        if (lastFrame.height() != frame.height()) goto L33;
    L34:
        updateSourceFrame(windowFrames.mFrame);
        if (this.mActivityRecord == null) goto L40;
        if (this.mIsChildWindow == true) goto L40;
        this.mActivityRecord.layoutLetterboxIfNeeded(this);
    L40:
        if (this.mHaveFrame == true) goto L42;
    L43:
        getExt().traceWindowFrame(getName(), !this.mHaveFrame, windowFrames.mFrame, this.mAttrs);
    L44:
        this.mSurfacePlacementNeeded = true;
        this.mHaveFrame = true;
        return;
    L42:
        if (windowFrames.mFrame.equals(windowFrames.mLastFrame) == true) goto L44;
    L20:
        if (windowFrames.mRelFrame.equals(windowFrames.mLastRelFrame) == true) goto L23;
    L13:
        if (requestedHeight != this.mLastRequestedHeight) goto L16;
        if (this.mTmpRect.equals(windowFrames.mParentFrame) == true) goto L18;
    L8:
        if (parent == null) goto L10;
        Rect parentBounds = parent.getBounds();
        parentLeft = parentBounds.left;
        parentTop = parentBounds.top;
        goto L10
    }

    void updateSourceFrame(Rect winFrame) {
        if (hasInsetsSourceProvider() == true) goto L6;
        return;
    L6:
        if (this.mGivenInsetsPending == false) goto L9;
        return;
    L9:
        if (this.mRelayoutCalled == true) goto L11;
        return;
    L11:
        SparseArray<InsetsSourceProvider> providers = getInsetsSourceProviders();
        int i = providers.size() - 1;
    L12:
        if (i < 0) goto L15;
        providers.valueAt(i).updateSourceFrame(winFrame);
        i = i - 1;
        goto L12
    }

    @Override // com.android.server.wm.ConfigurationContainer
    public Rect getBounds() {
        if (this.mToken.hasSizeCompatBounds() == false) goto L6;
        return this.mToken.getBounds();
    L6:
        return super.getBounds();
    }

    Rect getFrame() {
        return this.mWindowFrames.mFrame;
    }

    Rect getRelativeFrame() {
        return this.mWindowFrames.mRelFrame;
    }

    Rect getDisplayFrame() {
        return this.mWindowFrames.mDisplayFrame;
    }

    Rect getParentFrame() {
        return this.mWindowFrames.mParentFrame;
    }

    int getDisableFlags() {
        return this.mDisableFlags;
    }

    @Override // com.android.server.policy.WindowManagerPolicy.WindowState
    public int getBaseType() {
        return getTopParentWindow().mAttrs.type;
    }

    boolean setReportResizeHints() {
        return this.mWindowFrames.setReportResizeHints();
    }

    void updateResizingWindowIfNeeded() {
        boolean insetsChanged = this.mWindowFrames.hasInsetsChanged();
        if (this.mHasSurface == true) goto L5;
    L8:
        if (insetsChanged == true) goto L10;
        return;
    L10:
        WindowStateAnimator winAnimator = this.mWinAnimator;
        boolean didFrameInsetsChange = setReportResizeHints();
        if (this.mInRelayout == false) goto L13;
    L15:
        boolean configChanged = false;
    L17:
        if (WindowManagerDebugConfig.DEBUG_CONFIGURATION == false) goto L21;
        if (configChanged == false) goto L21;
        Slog.v(TAG, "Win " + this + " config changed: " + getConfiguration());
    L21:
        if (this.mDragResizingChangeReported == false) goto L23;
    L25:
        boolean dragResizingChanged = false;
    L27:
        if (this.mLayoutAttached == true) goto L29;
    L31:
        boolean attachedFrameChanged = false;
    L33:
        if (WindowManagerDebugConfig.DEBUG == false) goto L35;
        Slog.v(TAG, "Resizing " + this + ": configChanged=" + configChanged + " last=" + this.mWindowFrames.mLastFrame + " frame=" + this.mWindowFrames.mFrame);
    L35:
        if (didFrameInsetsChange == true) goto L41;
        if (configChanged == true) goto L41;
        if (dragResizingChanged == true) goto L41;
        if (attachedFrameChanged == true) goto L41;
        boolean contentChanged = false;
    L42:
        if (contentChanged == false) goto L44;
    L50:
        if (contentChanged == true) goto L57;
        if (insetsChanged == true) goto L57;
        if (shouldSendRedrawForSync() == true) goto L57;
        return;
    L57:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_RESIZE_enabled[1] == false) goto L60;
        String protoLogParam0 = String.valueOf(this);
        String protoLogParam1 = String.valueOf(this.mWindowFrames.getInsetsChangedInfo());
        boolean protoLogParam2 = configChanged;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_RESIZE, 8842744325264128950L, FrameworkStatsLog.BOOT_TIME_EVENT_ELAPSED_TIME_REPORTED, new Object[]{protoLogParam0, protoLogParam1, Boolean.valueOf(protoLogParam2), Boolean.valueOf(didFrameInsetsChange)});
    L60:
        consumeInsetsChange();
        onResizeHandled();
        if (configChanged == true) goto L64;
        if (dragResizingChanged == true) goto L64;
    L73:
        if (this.mWmService.mResizingWindows.contains(this) == false) goto L75;
        return;
    L75:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_RESIZE_enabled[1] == false) goto L77;
        String protoLogParam3 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_RESIZE, -8636590597069784069L, 0, new Object[]{protoLogParam3});
    L77:
        this.mWmService.mResizingWindows.add(this);
        return;
    L64:
        if (isVisibleRequested() == false) goto L73;
        winAnimator.mDrawState = 1;
        if (this.mActivityRecord == null) goto L73;
        this.mActivityRecord.clearAllDrawn();
        if (this.mAttrs.type != 3) goto L73;
        if (this.mActivityRecord.mStartingData == null) goto L73;
        this.mActivityRecord.mStartingData.mIsDisplayed = false;
        goto L73
    L44:
        if (this.mRedrawForSyncReported == true) goto L50;
        if (this.mPrepareSyncSeqId > 0) goto L50;
        if (this.mDrawHandlers.isEmpty() == false) goto L50;
        this.mRedrawForSyncReported = true;
    L41:
        contentChanged = true;
        goto L42
    L29:
        if (getParentWindow().frameChanged() == false) goto L31;
        attachedFrameChanged = true;
        goto L33
    L23:
        if (isDragResizeChanged() == false) goto L25;
        dragResizingChanged = true;
        goto L27
    L13:
        if (isLastConfigReportedToClient() == true) goto L15;
        configChanged = true;
        goto L17
    L5:
        if (getDisplayContent().mLayoutSeq != this.mLayoutSeq) goto L8;
        if (isGoneForLayout() == false) goto L10;
        goto L8
    }

    private boolean frameChanged() {
        return !this.mWindowFrames.mFrame.equals(this.mWindowFrames.mLastFrame);
    }

    @Override // com.android.server.wm.WindowContainer
    void onDisplayChanged(DisplayContent dc) {
        if (dc != null) goto L4;
    L10:
        super.onDisplayChanged(dc);
        if (dc != null) goto L13;
        return;
    L13:
        if (this.mInputWindowHandle.getDisplayId() == dc.getDisplayId()) goto L17;
        this.mLayoutSeq = dc.mLayoutSeq - 1;
        this.mInputWindowHandle.setDisplayId(dc.getDisplayId());
        return;
    L17:
        return;
    L4:
        if (this.mDisplayContent == null) goto L10;
        if (dc == this.mDisplayContent) goto L10;
        if (this.mDisplayContent.getImeInputTarget() != this) goto L10;
        dc.updateImeInputAndControlTarget(getImeInputTarget());
        this.mDisplayContent.setImeInputTarget(null);
        goto L10
    }

    DisplayFrames getDisplayFrames(DisplayFrames originalFrames) {
        DisplayFrames displayFrames = this.mToken.getFixedRotationTransformDisplayFrames();
        if (displayFrames == null) goto L5;
        return displayFrames;
    L5:
        return originalFrames;
    }

    DisplayInfo getDisplayInfo() {
        DisplayInfo displayInfo = this.mToken.getFixedRotationTransformDisplayInfo();
        if (displayInfo == null) goto L6;
        return displayInfo;
    L6:
        return getDisplayContent().getDisplayInfo();
    }

    @Override // com.android.server.wm.ConfigurationContainer
    public Rect getMaxBounds() {
        Rect maxBounds = this.mToken.getFixedRotationTransformMaxBounds();
        if (maxBounds == null) goto L6;
        return maxBounds;
    L6:
        return super.getMaxBounds();
    }

    InsetsState getInsetsState() {
        return getInsetsState(false);
    }

    InsetsState getInsetsState(boolean includeTransient) {
        InsetsState rotatedState = this.mToken.getFixedRotationTransformInsetsState();
        InsetsPolicy insetsPolicy = getDisplayContent().getInsetsPolicy();
        if (rotatedState == null) goto L7;
        return insetsPolicy.adjustInsetsForWindow(this, rotatedState);
    L7:
        if (this.mFrozenInsetsState == null) goto L9;
        InsetsState rawInsetsState = this.mFrozenInsetsState;
    L10:
        InsetsState insetsStateForWindow = insetsPolicy.enforceInsetsPolicyForTarget(this, rawInsetsState);
        return insetsPolicy.adjustInsetsForWindow(this, insetsStateForWindow, includeTransient);
    L9:
        rawInsetsState = getMergedInsetsState();
        goto L10
    }

    private InsetsState getMergedInsetsState() {
        if (this.mAttrs.receiveInsetsIgnoringZOrder == false) goto L5;
        InsetsState globalInsetsState = getDisplayContent().getInsetsStateController().getRawInsetsState();
    L7:
        if (this.mMergedLocalInsetsSources != null) goto L9;
        return globalInsetsState;
    L9:
        InsetsState mergedInsetsState = new InsetsState(globalInsetsState);
        int i = 0;
    L11:
        if (i >= this.mMergedLocalInsetsSources.size()) goto L14;
        mergedInsetsState.addSource(this.mMergedLocalInsetsSources.valueAt(i));
        i = i + 1;
        goto L11
    L14:
        return mergedInsetsState;
    L5:
        globalInsetsState = this.mAboveInsetsState;
        goto L7
    }

    InsetsState getCompatInsetsState() {
        InsetsState state = getInsetsState();
        if (this.mInvGlobalScale == 1.0f) goto L6;
        InsetsState state2 = new InsetsState(state, true);
        state2.scale(this.mInvGlobalScale);
        return state2;
    L6:
        return state;
    }

    InsetsState getInsetsStateWithVisibilityOverride() {
        InsetsState state = new InsetsState(getInsetsState(), true);
        int i = state.sourceSize() - 1;
    L3:
        if (i < 0) goto L9;
        InsetsSource source = state.sourceAt(i);
        boolean requestedVisible = isRequestedVisible(source.getType());
        if (source.isVisible() == requestedVisible) goto L7;
        source.setVisible(requestedVisible);
    L7:
        i = i - 1;
        goto L3
    L9:
        return state;
    }

    @Override // com.android.server.wm.InputTarget
    public int getDisplayId() {
        DisplayContent displayContent = getDisplayContent();
        if (displayContent != null) goto L7;
        return -1;
    L7:
        return displayContent.getDisplayId();
    }

    @Override // com.android.server.wm.InputTarget
    public WindowState getWindowState() {
        return this;
    }

    @Override // com.android.server.wm.InsetsControlTarget, com.android.server.wm.InsetsTarget
    public IBinder getWindowToken() {
        return this.mClient.asBinder();
    }

    @Override // com.android.server.wm.InputTarget
    public int getPid() {
        return this.mSession.mPid;
    }

    @Override // com.android.server.wm.InputTarget
    public int getUid() {
        return this.mSession.mUid;
    }

    Task getTask() {
        if (this.mActivityRecord != null) goto L7;
        return null;
    L7:
        return this.mActivityRecord.getTask();
    }

    TaskFragment getTaskFragment() {
        if (this.mActivityRecord != null) goto L7;
        return null;
    L7:
        return this.mActivityRecord.getTaskFragment();
    }

    void getVisibleBounds(Rect bounds) {
        Task task = getTask();
        if (task != null) goto L5;
    L7:
        boolean intersectWithRootTaskBounds = false;
    L8:
        bounds.setEmpty();
        this.mTmpRect.setEmpty();
        if (intersectWithRootTaskBounds == false) goto L14;
        Task rootTask = task.getRootTask();
        if (rootTask == null) goto L13;
        rootTask.getDimBounds(this.mTmpRect);
        goto L14
    L13:
        intersectWithRootTaskBounds = false;
    L14:
        bounds.set(this.mWindowFrames.mFrame);
        bounds.inset(getInsetsStateWithVisibilityOverride().calculateVisibleInsets(bounds, this.mAttrs.type, getActivityType(), this.mAttrs.softInputMode, this.mAttrs.flags));
        if (intersectWithRootTaskBounds == false) goto L18;
        bounds.intersect(this.mTmpRect);
        return;
    L18:
        return;
    L5:
        if (task.cropWindowsToRootTaskBounds() == false) goto L7;
        intersectWithRootTaskBounds = true;
        goto L8
    }

    public long getInputDispatchingTimeoutMillis() {
        if (this.mActivityRecord == null) goto L6;
        return this.mActivityRecord.mInputDispatchingTimeoutMillis;
    L6:
        return InputConstants.DEFAULT_DISPATCHING_TIMEOUT_MILLIS;
    }

    long getCreateTime() {
        return this.mCreateTime;
    }

    boolean hasAppShownWindows() {
        if (this.mActivityRecord != null) goto L5;
    L9:
        return false;
    L5:
        if (this.mActivityRecord.firstWindowDrawn == false) goto L7;
    L8:
        return true;
    L7:
        if (this.mActivityRecord.isStartingWindowDisplayed() == false) goto L9;
        goto L8
    }

    private boolean isVisibleByPolicyOrInsets() {
        if (isVisibleByPolicy() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.mControllableInsetProvider != null) goto L7;
    L8:
        return true;
    L7:
        if (this.mControllableInsetProvider.isClientVisible() == false) goto L9;
        goto L8
    }

    @Override // com.android.server.wm.WindowContainer
    boolean isVisible() {
        if (wouldBeVisibleIfPolicyIgnored() == true) goto L5;
    L7:
        return false;
    L5:
        if (isVisibleByPolicyOrInsets() == false) goto L7;
        return true;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean isVisibleRequested() {
        if (wouldBeVisibleRequestedIfPolicyIgnored() == true) goto L5;
    L7:
        boolean localVisibleRequested = false;
    L8:
        if (localVisibleRequested == true) goto L10;
    L13:
        return localVisibleRequested;
    L10:
        if (shouldCheckTokenVisibleRequested() == false) goto L13;
        return this.mToken.isVisibleRequested();
    L5:
        if (isVisibleByPolicyOrInsets() == false) goto L7;
        localVisibleRequested = true;
        goto L8
    }

    boolean shouldCheckTokenVisibleRequested() {
        if (this.mActivityRecord == null) goto L5;
    L8:
        return true;
    L5:
        if (this.mToken.asWallpaperToken() != null) goto L8;
        return false;
    }

    boolean isVisibleByPolicy() {
        if ((this.mPolicyVisibility & 3) != 3) goto L5;
        return true;
    L5:
        return false;
    }

    boolean providesDisplayDecorInsets() {
        if (this.mInsetsSourceProviders != null) goto L5;
        return false;
    L5:
        int decorInsetsTypes = this.mWmService.mConfigTypes | this.mWmService.mOverrideConfigTypes;
        int i = this.mInsetsSourceProviders.size() - 1;
    L6:
        if (i < 0) goto L12;
        InsetsSource source = this.mInsetsSourceProviders.valueAt(i).getSource();
        if ((source.getType() & decorInsetsTypes) != 0) goto L9;
        i = i - 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    void clearPolicyVisibilityFlag(int policyVisibilityFlag) {
        this.mPolicyVisibility &= ~policyVisibilityFlag;
        this.mWmService.scheduleAnimationLocked();
    }

    void setPolicyVisibilityFlag(int policyVisibilityFlag) {
        this.mPolicyVisibility |= policyVisibilityFlag;
        this.mWmService.scheduleAnimationLocked();
    }

    private boolean isLegacyPolicyVisibility() {
        if ((this.mPolicyVisibility & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    boolean wouldBeVisibleIfPolicyIgnored() {
        if (this.mHasSurface == true) goto L5;
    L20:
        return false;
    L5:
        if (isParentWindowHidden() == true) goto L20;
        if (this.mAnimatingExit == true) goto L20;
        if (this.mDestroying == true) goto L20;
        if (this.mToken.asWallpaperToken() == null) goto L14;
        boolean isWallpaper = true;
    L15:
        if (isWallpaper == false) goto L19;
        if (this.mToken.isVisible() == true) goto L19;
        return false;
    L19:
        return true;
    L14:
        isWallpaper = false;
        goto L15
    }

    private boolean wouldBeVisibleRequestedIfPolicyIgnored() {
        WindowState parent = getParentWindow();
        if (parent != null) goto L5;
    L7:
        boolean isParentHiddenRequested = false;
    L8:
        if (isParentHiddenRequested == false) goto L10;
    L24:
        return false;
    L10:
        if (this.mAnimatingExit == true) goto L24;
        if (this.mDestroying == true) goto L24;
        if (this.mToken.asWallpaperToken() == null) goto L17;
        boolean isWallpaper = true;
    L18:
        if (isWallpaper == true) goto L20;
        return true;
    L20:
        if (this.mToken.isVisibleRequested() == false) goto L23;
        return true;
    L23:
        return false;
    L17:
        isWallpaper = false;
        goto L18
    L5:
        if (parent.isVisibleRequested() == true) goto L7;
        isParentHiddenRequested = true;
        goto L8
    }

    boolean isVisibleNow() {
        if (this.mToken.isVisible() == true) goto L7;
        if (this.mAttrs.type == 3) goto L7;
    L9:
        return false;
    L7:
        if (isVisible() == false) goto L9;
        return true;
    }

    boolean isPotentialDragTarget(boolean targetInterceptsGlobalDrag) {
        if (targetInterceptsGlobalDrag == true) goto L6;
        if (isVisibleNow() == true) goto L6;
    L12:
        return false;
    L6:
        if (this.mRemoved == true) goto L12;
        if (this.mInputChannelToken == null) goto L12;
        if (this.mInputWindowHandle == null) goto L12;
        return true;
    }

    boolean isVisibleRequestedOrAdding() {
        ActivityRecord atoken = this.mActivityRecord;
        if (this.mHasSurface == true) goto L9;
        if (this.mRelayoutCalled == false) goto L7;
    L20:
        return false;
    L7:
        if (this.mViewVisibility != 0) goto L20;
    L9:
        if (isVisibleByPolicy() == false) goto L20;
        if (isParentWindowHidden() == true) goto L20;
        if (atoken == null) goto L16;
        if (atoken.isVisibleRequested() == false) goto L20;
    L16:
        if (this.mAnimatingExit == true) goto L20;
        if (this.mDestroying == true) goto L20;
        return true;
    }

    boolean isOnScreen() {
        if (this.mHasSurface == true) goto L5;
    L43:
        return false;
    L5:
        if (this.mDestroying == true) goto L43;
        if (isVisibleByPolicy() == false) goto L43;
        ActivityRecord atoken = this.mActivityRecord;
        if (atoken != null) goto L12;
        WallpaperWindowToken wtoken = this.mToken.asWallpaperToken();
        if (wtoken == null) goto L38;
        if (isParentWindowHidden() == false) goto L34;
        return false;
    L34:
        if (wtoken.isVisible() == true) goto L36;
        return false;
    L36:
        return true;
    L38:
        if (isParentWindowHidden() == false) goto L42;
        if (isAnimating(3) == true) goto L42;
        return false;
    L42:
        return true;
    L12:
        if (atoken.mStartingData == null) goto L19;
        if (this.mAttrs.type == 3) goto L19;
        if (atoken.mStartingData.mRemoveAfterTransaction != 3) goto L19;
        return false;
    L19:
        if (isStartingWindowAssociatedToTask() == false) goto L21;
        boolean isVisible = this.mStartingData.mAssociatedTask.isVisible();
    L23:
        if (isParentWindowHidden() == true) goto L26;
        if (isVisible == false) goto L26;
    L28:
        return true;
    L26:
        if (isAnimationRunningSelfOrParent() == true) goto L28;
        return false;
    L21:
        isVisible = atoken.isVisible();
        goto L23
    }

    boolean isDreamWindow() {
        if (this.mActivityRecord != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mActivityRecord.getActivityType() != 5) goto L7;
        return true;
    }

    boolean isSecureLocked() {
        if (this.mWmService.getDisableSecureWindows() == false) goto L7;
        return false;
    L7:
        if ((this.mAttrs.flags & 8192) == 0) goto L10;
        return true;
    L10:
        if (getDisplayInfo() == null) goto L18;
        if (ActivityStarterHook.CAR_DISPLAY_NAME2.equals(getDisplayInfo().name) == false) goto L14;
    L15:
        Slog.d(TAG, "this is car play, so is Secure");
        return !DevicePolicyCache.getInstance().isScreenCaptureAllowed(this.mShowUserId);
    L14:
        if (ActivityStarterHook.CAR_DISPLAY_NAME.equals(getDisplayInfo().name) == true) goto L15;
    L18:
        if (this.mWmService.mSensitiveContentPackages.shouldBlockScreenCaptureForApp(getOwningPackage(), getOwningUid(), getWindowToken()) == false) goto L21;
        return true;
    L21:
        return !DevicePolicyCache.getInstance().isScreenCaptureAllowed(this.mShowUserId);
    }

    boolean mightAffectAllDrawn() {
        if (this.mWinAnimator.mAttrType != 1) goto L5;
    L8:
        boolean isAppType = true;
    L10:
        if (isOnScreen() == true) goto L13;
        if (isAppType == true) goto L13;
        return false;
    L13:
        if (this.mAnimatingExit == false) goto L15;
        return false;
    L15:
        if (this.mDestroying == false) goto L17;
        return false;
    L17:
        return true;
    L5:
        if (this.mWinAnimator.mAttrType == 4) goto L8;
        isAppType = false;
        goto L10
    }

    boolean isInteresting() {
        if (this.mActivityRecord != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mViewVisibility != 0) goto L7;
        return true;
    }

    boolean isReadyForDisplay() {
        if (isParentWindowHidden() == false) goto L5;
    L7:
        boolean parentAndClientVisible = false;
    L9:
        if (this.mTransitionController.isShellTransitionsEnabled() == true) goto L26;
        if (this.mHasSurface == true) goto L13;
        return false;
    L13:
        if (isVisibleByPolicy() == true) goto L15;
        return false;
    L15:
        if (this.mDestroying == true) goto L41;
        if (parentAndClientVisible == false) goto L21;
        if (this.mToken.isVisible() == false) goto L21;
    L24:
        return true;
    L21:
        if (isAnimating(3) == true) goto L24;
        return false;
    L41:
        return false;
    L26:
        if (this.mHasSurface == true) goto L28;
        return false;
    L28:
        if (isVisibleByPolicy() == true) goto L30;
        return false;
    L30:
        if (this.mDestroying == false) goto L32;
        return false;
    L32:
        if (this.mToken.isVisible() == false) goto L46;
        if (parentAndClientVisible == true) goto L38;
        if (isAnimating(3) == true) goto L38;
        return false;
    L38:
        return true;
    L46:
        return false;
    L5:
        if (this.mViewVisibility != 0) goto L7;
        parentAndClientVisible = true;
        goto L9
    }

    boolean isFullyTransparent() {
        if (this.mAttrs.alpha != 0.0f) goto L5;
        return true;
    L5:
        return false;
    }

    boolean canAffectSystemUiFlags() {
        if (isFullyTransparent() == false) goto L6;
        return false;
    L6:
        if (this.mActivityRecord != null) goto L19;
        boolean shown = this.mWinAnimator.getShown();
        if (this.mAnimatingExit == false) goto L10;
    L13:
        boolean exiting = true;
    L14:
        if (shown == false) goto L26;
        if (exiting == false) goto L17;
        return false;
    L17:
        return true;
    L26:
        return false;
    L10:
        if (this.mDestroying == true) goto L13;
        exiting = false;
        goto L14
    L19:
        if (this.mActivityRecord.canAffectSystemUiFlags() == true) goto L21;
        return false;
    L21:
        if (this.mAttrs.type != 3) goto L25;
        if ((this.mStartingData instanceof SnapshotStartingData) == false) goto L25;
        return false;
    L25:
        return true;
    }

    boolean isDisplayed() {
        ActivityRecord atoken = this.mActivityRecord;
        if (isDrawn() == true) goto L5;
    L14:
        return false;
    L5:
        if (isVisibleByPolicy() == false) goto L14;
        if (isParentWindowHidden() == true) goto L12;
        if (atoken != null) goto L10;
    L13:
        return true;
    L10:
        if (atoken.isVisibleRequested() == true) goto L13;
    L12:
        if (isAnimationRunningSelfOrParent() == false) goto L14;
        goto L13
    }

    @Override // com.android.server.policy.WindowManagerPolicy.WindowState
    public boolean isAnimatingLw() {
        return isAnimating(3);
    }

    boolean isGoneForLayout() {
        ActivityRecord atoken = this.mActivityRecord;
        if (this.mViewVisibility != 8) goto L5;
    L24:
        return true;
    L5:
        if (this.mRelayoutCalled == false) goto L24;
        if (atoken == null) goto L8;
    L11:
        if (atoken == null) goto L15;
        if (atoken.isVisibleRequested() == false) goto L24;
    L15:
        if (isParentWindowGoneForLayout() == true) goto L24;
        if (this.mAnimatingExit == false) goto L21;
        if (isAnimatingLw() == false) goto L24;
    L21:
        if (this.mDestroying == true) goto L24;
        return false;
    L8:
        if (wouldBeVisibleIfPolicyIgnored() == false) goto L24;
        if (isVisibleByPolicy() == false) goto L24;
        goto L11
    }

    public boolean isDrawFinishedLw() {
        if (this.mHasSurface == true) goto L5;
    L13:
        return false;
    L5:
        if (this.mDestroying == true) goto L13;
        if (this.mWinAnimator.mDrawState != 2) goto L9;
    L12:
        return true;
    L9:
        if (this.mWinAnimator.mDrawState == 3) goto L12;
        if (this.mWinAnimator.mDrawState != 4) goto L13;
        goto L12
    }

    boolean isDrawn() {
        if (this.mHasSurface == true) goto L5;
    L11:
        return false;
    L5:
        if (this.mDestroying == true) goto L11;
        if (this.mWinAnimator.mDrawState != 3) goto L9;
    L10:
        return true;
    L9:
        if (this.mWinAnimator.mDrawState != 4) goto L11;
        goto L10
    }

    private boolean isOpaqueDrawn() {
        if (this.mToken.asWallpaperToken() == null) goto L5;
        boolean isWallpaper = true;
    L6:
        if (isWallpaper == false) goto L8;
    L10:
        if (isWallpaper == true) goto L12;
        return false;
    L12:
        if (this.mToken.isVisible() == true) goto L14;
        return false;
    L14:
        if (isDrawn() == true) goto L16;
        return false;
    L16:
        if (isAnimating(3) == false) goto L19;
        return false;
    L19:
        return true;
    L8:
        if (this.mAttrs.format == (-1)) goto L14;
    L5:
        isWallpaper = false;
        goto L6
    }

    void requestDrawIfNeeded(List<WindowState> outWaitingForDrawn) {
        if (isVisible() == true) goto L5;
        return;
    L5:
        WallpaperWindowToken wallpaperToken = this.mToken.asWallpaperToken();
        if (wallpaperToken == null) goto L12;
        if (wallpaperToken.hasVisibleNotDrawnWallpaper() == false) goto L32;
        outWaitingForDrawn.add(this);
        return;
    L32:
        return;
    L12:
        if (this.mActivityRecord == null) goto L28;
        if (this.mActivityRecord.isVisibleRequested() == true) goto L17;
        return;
    L17:
        if (this.mActivityRecord.allDrawn == false) goto L20;
        return;
    L20:
        if (this.mAttrs.type != 3) goto L25;
        if (isDrawn() == false) goto L30;
        return;
    L30:
        this.mWinAnimator.mDrawState = 1;
        forceReportingResized();
        outWaitingForDrawn.add(this);
        return;
    L25:
        if (this.mActivityRecord.mStartingWindow == null) goto L30;
        return;
    L28:
        if (this.mPolicy.isKeyguardHostWindow(this.mAttrs) == true) goto L30;
    }

    @Override // com.android.server.wm.WindowContainer
    void onMovedByResize() {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_RESIZE_enabled[0] == false) goto L5;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_RESIZE, 5236278969232209904L, 0, new Object[]{protoLogParam0});
    L5:
        this.mMovedByResize = true;
        super.onMovedByResize();
    }

    void onAppCommitInvisible() {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L6;
        ((WindowState) this.mChildren.get(i)).onAppCommitInvisible();
        i = i - 1;
        goto L3
    L6:
        if (this.mAttrs.type != 3) goto L8;
        return;
    L8:
        if (this.mWmService.mAccessibilityController.hasCallbacks() == true) goto L10;
        return;
    L10:
        if (isVisible() == false) goto L16;
        this.mWmService.mAccessibilityController.onWindowTransition(this, 2);
        return;
    }

    boolean onSetAppExiting(boolean animateExit) {
        DisplayContent displayContent = getDisplayContent();
        boolean changed = false;
        if (animateExit == true) goto L6;
        this.mPermanentlyHidden = true;
        hide(false, false);
    L6:
        if (isVisibleNow() == false) goto L14;
        if (animateExit == false) goto L14;
        this.mWinAnimator.applyAnimationLocked(2, false);
        if (this.mWmService.mAccessibilityController.hasCallbacks() == false) goto L11;
        this.mWmService.mAccessibilityController.onWindowTransition(this, 2);
    L11:
        changed = true;
        if (displayContent == null) goto L14;
        displayContent.setLayoutNeeded();
    L14:
        int i = this.mChildren.size() - 1;
    L15:
        if (i < 0) goto L18;
        WindowState c = (WindowState) this.mChildren.get(i);
        changed = changed | c.onSetAppExiting(animateExit);
        i = i - 1;
        goto L15
    L18:
        return changed;
    }

    @Override // com.android.server.wm.WindowContainer
    void onResize() {
        ArrayList<WindowState> resizingWindows = this.mWmService.mResizingWindows;
        if (this.mHasSurface == true) goto L5;
    L12:
        super.onResize();
        return;
    L5:
        if (isGoneForLayout() == true) goto L12;
        if (resizingWindows.contains(this) == true) goto L12;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_RESIZE_enabled[0] == false) goto L11;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_RESIZE, 1783521309242112490L, 0, new Object[]{protoLogParam0});
    L11:
        resizingWindows.add(this);
        goto L12
    }

    void handleWindowMovedIfNeeded() {
        if (hasMoved() == true) goto L5;
        return;
    L5:
        int left = this.mWindowFrames.mFrame.left;
        int top = this.mWindowFrames.mFrame.top;
        if (canPlayMoveAnimation() == false) goto L9;
        startMoveAnimation(left, top);
    L9:
        if (this.mWmService.mAccessibilityController.hasCallbacks() == false) goto L16;
        this.mWmService.mAccessibilityController.onSomeWindowResizedOrMoved(new int[]{getDisplayId()});
    L16:
        this.mClient.moved(left, top);     // Catch: RemoteException -> L13
    L14:
        this.mMovedByResize = false;
    }

    void notifyScreenRecordingState(boolean forceSdr) {
        this.mClient.onScreenRecordingStateChanged(forceSdr);     // Catch: RemoteException -> L4
        return;
    }

    private boolean canPlayMoveAnimation() {
        if (getTask() != null) goto L5;
        boolean hasMovementAnimation = getWindowConfiguration().hasMovementAnimations();
    L7:
        if (this.mToken.okToAnimate() == true) goto L9;
    L16:
        return false;
    L9:
        if ((this.mAttrs.privateFlags & 64) != 0) goto L16;
        if (isDragResizing() == true) goto L16;
        if (hasMovementAnimation == false) goto L16;
        if (this.mWinAnimator.mLastHidden == true) goto L16;
        return true;
    L5:
        hasMovementAnimation = getTask().getWindowConfiguration().hasMovementAnimations();
        goto L7
    }

    private boolean hasMoved() {
        if (this.mHasSurface == true) goto L5;
    L21:
        return false;
    L5:
        if (this.mWindowFrames.hasContentChanged() == true) goto L9;
        if (this.mMovedByResize == false) goto L21;
    L9:
        if (this.mAnimatingExit == true) goto L21;
        if (this.mWindowFrames.mRelFrame.top != this.mWindowFrames.mLastRelFrame.top) goto L15;
        if (this.mWindowFrames.mRelFrame.left == this.mWindowFrames.mLastRelFrame.left) goto L21;
    L15:
        if (this.mIsChildWindow == false) goto L19;
        if (getParentWindow().hasMoved() == true) goto L21;
    L19:
        if (this.mTransitionController.isCollecting() == true) goto L21;
        return true;
    }

    boolean isObscuringDisplay() {
        Task task = getTask();
        if (task == null) goto L8;
        if (task.fillsParent() == true) goto L8;
        return false;
    L8:
        if (isOpaqueDrawn() == true) goto L10;
        return false;
    L10:
        if (fillsDisplay() == false) goto L14;
        return true;
    L14:
        return false;
    }

    boolean fillsDisplay() {
        DisplayInfo displayInfo = getDisplayInfo();
        if (this.mWindowFrames.mFrame.left <= 0) goto L5;
    L11:
        return false;
    L5:
        if (this.mWindowFrames.mFrame.top > 0) goto L11;
        if (this.mWindowFrames.mFrame.right < displayInfo.appWidth) goto L11;
        if (this.mWindowFrames.mFrame.bottom < displayInfo.appHeight) goto L11;
        return true;
    }

    boolean matchesDisplayAreaBounds() {
        Rect rotatedDisplayBounds = this.mToken.getFixedRotationTransformDisplayBounds();
        if (rotatedDisplayBounds != null) goto L5;
        DisplayArea displayArea = getDisplayArea();
        if (displayArea != null) goto L11;
        return getDisplayContent().getBounds().equals(getBounds());
    L11:
        return displayArea.getBounds().equals(getBounds());
    L5:
        return rotatedDisplayBounds.equals(getBounds());
    }

    boolean isLastConfigReportedToClient() {
        return this.mLastConfigReportedToClient;
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.ConfigurationContainer
    public void onConfigurationChanged(Configuration newParentConfig) {
        if (getConfiguration().windowConfiguration.getWindowingMode() == newParentConfig.windowConfiguration.getWindowingMode()) goto L5;
        this.mExt.reportWindowModeChange(newParentConfig.windowConfiguration.getWindowingMode());
    L5:
        Configuration selfConfiguration = super.getConfiguration();
        this.mTempConfiguration.setTo(selfConfiguration);
        super.onConfigurationChanged(newParentConfig);
        int diff = selfConfiguration.diff(this.mTempConfiguration);
        if (diff == 0) goto L9;
        this.mLastConfigReportedToClient = false;
    L9:
        if (getDisplayContent().getImeInputTarget() == this) goto L14;
        if (isImeLayeringTarget() == true) goto L14;
        return;
    L14:
        if ((536870912 & diff) == 0) goto L25;
        this.mDisplayContent.updateImeControlTarget(isImeLayeringTarget());
        if (this.mStartingData != null) goto L18;
        return;
    L18:
        if (this.mStartingData.mAssociatedTask == null) goto L20;
        return;
    L20:
        if (this.mTempConfiguration.windowConfiguration.getRotation() == selfConfiguration.windowConfiguration.getRotation()) goto L22;
        return;
    L22:
        if (RegionUtils.sizeEquals(this.mTempConfiguration.windowConfiguration.getBounds(), getBounds()) == true) goto L29;
        this.mStartingData.mResizedFromTransfer = true;
        this.mActivityRecord.associateStartingWindowWithTaskIfNeeded();
        return;
    L29:
        return;
    }

    @Override // com.android.server.wm.WindowContainer
    void removeImmediately() {
        boolean needToSendNewConfiguration = false;
        if (this.mRemoved == true) goto L5;
        this.mRemoved = true;
        this.mWinAnimator.destroySurfaceLocked(getSyncTransaction());
        if (this.mDrawHandlers.isEmpty() == true) goto L11;
        this.mWmService.mH.removeMessages(64, this);
    L11:
        super.removeImmediately();
        DisplayContent dc = getDisplayContent();
        if (isImeOverlayLayeringTarget() == false) goto L15;
        this.mWmService.dispatchImeTargetOverlayVisibilityChanged(this.mClient.asBinder(), this.mAttrs.type, false, true, dc.getDisplayId());
    L15:
        if (isImeLayeringTarget() == false) goto L18;
        dc.removeImeSurfaceByTarget(this);
        dc.setImeLayeringTarget(null);
        dc.computeImeTarget(true);
    L18:
        if (dc.getImeInputTarget() != this) goto L23;
        if (inRelaunchingActivity() == true) goto L23;
        this.mWmService.dispatchImeInputTargetVisibilityChanged(this.mClient.asBinder(), false, true, dc.getDisplayId());
        dc.updateImeInputAndControlTarget(null);
    L23:
        if (Constants.ENABLE_GAME_ASSIST == false) goto L27;
        CharSequence title = getWindowTag().toString();
        if (title == null) goto L27;
        SystemWindowManagerEventDispatcher.getInstance().notifySystemWindowChanged(false, title.toString(), this.mAttrs.packageName, this.mAttrs.type);
    L27:
        boolean windowProvidesDisplayDecorInsets = providesDisplayDecorInsets();
        dc.getDisplayPolicy().removeWindowLw(this);
        disposeInputChannel();
        this.mOnBackInvokedCallbackInfo = null;
        this.mSession.onWindowRemoved(this);
        this.mWmService.postWindowRemoveCleanupLocked(this);
        if (((WindowStateSmtBase) getSmtEx()).isFrozenCallbackRegisterd == false) goto L30;
        ((WindowStateSmtBase) getSmtEx()).isFrozenCallbackRegisterd = false;
        ApplicationFreezerHelperSmt.unregisterFrozenCallbackByPidOnce(this.mSession.mPid, this.mSession.mUid, (WindowStateSmtBase) getSmtEx());
    L30:
        consumeInsetsChange();
        if (dc.getLastOrientationSource() == this) goto L33;
    L37:
        if (windowProvidesDisplayDecorInsets == false) goto L39;
        needToSendNewConfiguration = needToSendNewConfiguration | dc.getDisplayPolicy().updateDecorInsetsInfo();
    L39:
        if (needToSendNewConfiguration == false) goto L43;
        dc.sendNewConfiguration();
        return;
    L43:
        return;
    L33:
        if (dc.updateOrientation() == false) goto L37;
        needToSendNewConfiguration = true;
        goto L37
    L5:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[1] == false) goto L42;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, 1351053513466395411L, 0, new Object[]{protoLogParam0});
        return;
    }

    @Override // com.android.server.wm.WindowContainer
    void removeIfPossible() {
        this.mWindowRemovalAllowed = true;
        int r4 = 0;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[1] == false) goto L6;
        String protoLogParam0 = String.valueOf(this);
        String protoLogParam1 = String.valueOf(Debug.getCallers(5));
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, 3927343382258792268L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L6:
        if (this.mStartingData == null) goto L8;
        boolean startingWindow = true;
    L9:
        if (startingWindow == false) goto L18;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_STARTING_WINDOW_enabled[0] == false) goto L14;
        String protoLogParam2 = String.valueOf(this);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_STARTING_WINDOW, -4831815184899821371L, 0, new Object[]{protoLogParam2});
    L14:
        if (this.mActivityRecord == null) goto L16;
        this.mActivityRecord.forAllWindows(new WindowState$$ExternalSyntheticLambda2(), true);
    L16:
        this.mTransitionController.mTransitionTracer.logRemovingStartingWindow(this.mStartingData);
    L23:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_enabled[1] == false) goto L25;
        long protoLogParam3 = System.identityHashCode(this.mClient.asBinder());
        String protoLogParam4 = String.valueOf(this.mWinAnimator.mSurfaceControl);
        String protoLogParam5 = String.valueOf(Debug.getCallers(5));
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_FOCUS, -5803097884846965819L, 1, new Object[]{Long.valueOf(protoLogParam3), protoLogParam4, protoLogParam5});
    L25:
        DisplayContent displayContent = getDisplayContent();
        long origId = Binder.clearCallingIdentity();
        disposeInputChannel();     // Catch: Throwable -> L33
        this.mOnBackInvokedCallbackInfo = null;     // Catch: Throwable -> L33
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_APP_TRANSITIONS_enabled[1] == false) goto L38;
        String protoLogParam6 = String.valueOf(this);     // Catch: Throwable -> L33
        String protoLogParam7 = String.valueOf(this.mWinAnimator.mSurfaceControl);     // Catch: Throwable -> L33
        boolean protoLogParam8 = this.mAnimatingExit;     // Catch: Throwable -> L33
        boolean protoLogParam9 = this.mRemoveOnExit;     // Catch: Throwable -> L33
        boolean protoLogParam10 = this.mHasSurface;     // Catch: Throwable -> L33
        boolean protoLogParam11 = this.mWinAnimator.getShown();     // Catch: Throwable -> L33
        boolean protoLogParam12 = isAnimating(3);     // Catch: Throwable -> L33
        if (this.mActivityRecord != null) goto L31;
    L35:
        boolean r11 = false;
    L36:
        boolean protoLogParam13 = r11;
        String protoLogParam14 = String.valueOf(Debug.getCallers(6));     // Catch: Throwable -> L33
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_APP_TRANSITIONS, 2665646261733503081L, 65520, new Object[]{protoLogParam6, protoLogParam7, Boolean.valueOf(protoLogParam8), Boolean.valueOf(protoLogParam9), Boolean.valueOf(protoLogParam10), Boolean.valueOf(protoLogParam11), Boolean.valueOf(protoLogParam12), Boolean.valueOf(protoLogParam13), protoLogParam14});     // Catch: Throwable -> L33
        goto L38
    L31:
        if (this.mActivityRecord.isAnimating(3) == false) goto L35;
        r11 = true;
    L38:
        if (this.mHasSurface == true) goto L40;
    L107:
        removeImmediately();     // Catch: Throwable -> L33
        WindowManagerService r3 = this.mWmService;     // Catch: Throwable -> L33
        if (isFocused() == false) goto L111;
        r4 = 4;
    L111:
        r3.updateFocusedWindowLocked(r4, true);     // Catch: Throwable -> L33
        Binder.restoreCallingIdentity(origId);
        return;
    L40:
        if (this.mToken.okToAnimate() == false) goto L107;
        if (displayContent.inTransition() == false) goto L44;
    L46:
        boolean allowExitAnimation = false;
    L48:
        if (isVisible() == true) goto L50;
    L76:
        if (allowExitAnimation == true) goto L78;
    L82:
        boolean isAnimating = false;
    L84:
        if (startingWindow == true) goto L86;
    L90:
        boolean lastWindowIsStartingWindow = false;
    L92:
        if (this.mWinAnimator.getShown() == false) goto L107;
        if (lastWindowIsStartingWindow == true) goto L107;
        if (isAnimating == false) goto L107;
        this.mAnimatingExit = true;     // Catch: Throwable -> L33
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[1] == false) goto L99;
        String protoLogParam15 = String.valueOf(this);     // Catch: Throwable -> L33
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, -4143841388126586338L, 0, new Object[]{protoLogParam15});     // Catch: Throwable -> L33
    L99:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ANIM_enabled[1] == false) goto L101;
        String protoLogParam16 = String.valueOf(this);     // Catch: Throwable -> L33
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ANIM, 4419190702135590390L, 0, new Object[]{protoLogParam16});     // Catch: Throwable -> L33
    L101:
        setupWindowForRemoveOnExit();     // Catch: Throwable -> L33
        if (this.mActivityRecord == null) goto L104;
        this.mActivityRecord.updateReportedVisibilityLocked();     // Catch: Throwable -> L33
    L104:
        Binder.restoreCallingIdentity(origId);
        return;
    L86:
        if (this.mActivityRecord == null) goto L90;
        if (this.mActivityRecord.isLastWindow(this) == false) goto L90;
        lastWindowIsStartingWindow = true;
        goto L92
    L78:
        if (this.mAnimatingExit == false) goto L80;
    L81:
        isAnimating = true;
        goto L84
    L80:
        if (isAnimationRunningSelfOrParent() == false) goto L82;
    L50:
        if (isDisplayed() == false) goto L76;
        if (startingWindow == true) goto L53;
        int transit = 2;
    L54:
        if (allowExitAnimation == false) goto L74;
        if (this.mWinAnimator.applyAnimationLocked(transit, false) == false) goto L74;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ANIM_enabled[1] == false) goto L60;
        String protoLogParam17 = String.valueOf(this);     // Catch: Throwable -> L33
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ANIM, 7789778354950913237L, 0, new Object[]{protoLogParam17});     // Catch: Throwable -> L33
    L60:
        if (startingWindow == true) goto L62;
    L72:
        this.mAnimatingExit = true;     // Catch: Throwable -> L33
        setDisplayLayoutNeeded();     // Catch: Throwable -> L33
        this.mWmService.requestTraversal();     // Catch: Throwable -> L33
        goto L74
    L62:
        if (this.mSurfaceAnimator.hasLeash() == false) goto L72;
        getPendingTransaction().setLayer(this.mSurfaceAnimator.mLeash, Integer.MAX_VALUE);     // Catch: Throwable -> L33
        if (getDisplayContent().getImeContainer() == null) goto L72;
        if (getDisplayContent().shouldImeAttachedToApp() == false) goto L72;
        if (getDisplayContent().getImeContainer().getSurfaceControl() == null) goto L72;
        if (getDisplayContent().getImeContainer().getSurfaceControl().isValid() == false) goto L72;
        Slog.d(TAG, "re-assign the layer of ime");     // Catch: Throwable -> L33
        getPendingTransaction().setLayer(getDisplayContent().getImeContainer().getSurfaceControl(), 2147483646);     // Catch: Throwable -> L33
    L74:
        if (this.mWmService.mAccessibilityController.hasCallbacks() == false) goto L76;
        this.mWmService.mAccessibilityController.onWindowTransition(this, transit);     // Catch: Throwable -> L33
        goto L76
    L53:
        transit = 5;
        goto L54
    L44:
        if (inRelaunchingActivity() == true) goto L46;
        allowExitAnimation = true;
    L33:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    L18:
        if (this.mAttrs.type != 1) goto L23;
        if (isSelfAnimating(0, 128) == false) goto L23;
        cancelAnimation();
        goto L23
    L8:
        startingWindow = false;
        goto L9
    }

    private static /* synthetic */ boolean lambda$removeIfPossible$1(WindowState w) {
        if (w.isSelfAnimating(0, 128) == false) goto L6;
        Slog.d(TAG, "removeIfPossible cancelAnimation: " + w);
        w.cancelAnimation();
        return true;
    L6:
        return false;
    }

    private void setupWindowForRemoveOnExit() {
        this.mRemoveOnExit = true;
        setDisplayLayoutNeeded();
        getDisplayContent().getDisplayPolicy().removeWindowLw(this);
        boolean focusChanged = this.mWmService.updateFocusedWindowLocked(3, false);
        this.mWmService.mWindowPlacerLocked.performSurfacePlacement();
        if (focusChanged == false) goto L6;
        getDisplayContent().getInputMonitor().updateInputWindowsLw(false);
        return;
    }

    void setHasSurface(boolean hasSurface) {
        if (this.mHasSurface == hasSurface) goto L5;
        this.mWmService.getObricExt().notifyWindowVisibleChanged(this, hasSurface);
    L5:
        this.mHasSurface = hasSurface;
    }

    boolean canBeImeTarget() {
        if (this.mIsImWindow == false) goto L6;
        return false;
    L6:
        if (inPinnedWindowingMode() == false) goto L9;
        return false;
    L9:
        if (this.mAttrs.type != 2036) goto L12;
        return false;
    L12:
        if (this.mActivityRecord != null) goto L14;
    L17:
        boolean windowsAreFocusable = true;
    L18:
        if (windowsAreFocusable == true) goto L20;
        return false;
    L20:
        Task task = getTask();
        if (task == null) goto L26;
        if (task.isFocusable() == true) goto L26;
        return false;
    L26:
        if (this.mAttrs.type == 3) goto L32;
        int fl = this.mAttrs.flags & 131080;
        if (fl == 0) goto L32;
        if (fl == 131080) goto L32;
        return false;
    L32:
        if (task == null) goto L39;
        if (this.mActivityRecord == null) goto L39;
        if (this.mTransitionController.isTransientLaunch(this.mActivityRecord) == false) goto L39;
        return false;
    L39:
        if (WindowManagerDebugConfig.DEBUG_INPUT_METHOD == false) goto L54;
        StringBuilder r4 = new StringBuilder();
        r4.append("isVisibleRequestedOrAdding ");
        r4.append(this);
        r4.append(": ");
        r4.append(isVisibleRequestedOrAdding());
        r4.append(" isVisible: ");
        if (isVisible() == true) goto L43;
    L47:
        boolean r5 = false;
    L48:
        r4.append(r5);
        Slog.i(TAG, r4.toString());
        if (isVisibleRequestedOrAdding() == true) goto L54;
        Slog.i(TAG, "  mSurfaceControl=" + this.mWinAnimator.mSurfaceControl + " relayoutCalled=" + this.mRelayoutCalled + " viewVis=" + this.mViewVisibility + " policyVis=" + isVisibleByPolicy() + " policyVisAfterAnim=" + this.mLegacyPolicyVisibilityAfterAnim + " parentHidden=" + isParentWindowHidden() + " exiting=" + this.mAnimatingExit + " destroying=" + this.mDestroying);
        if (this.mActivityRecord == null) goto L54;
        Slog.i(TAG, "  mActivityRecord.visibleRequested=" + this.mActivityRecord.isVisibleRequested());
        goto L54
    L43:
        if (this.mActivityRecord == null) goto L47;
        if (this.mActivityRecord.isVisible() == false) goto L47;
        r5 = true;
    L54:
        if (isVisibleRequestedOrAdding() == true) goto L62;
        if (isVisible() == true) goto L58;
        return false;
    L58:
        if (this.mActivityRecord != null) goto L60;
        return false;
    L60:
        if (this.mActivityRecord.isVisible() == true) goto L62;
        return false;
    L62:
        return true;
    L14:
        if (this.mActivityRecord.windowsAreFocusable() == true) goto L17;
        windowsAreFocusable = false;
        goto L18
    }

    void openInputChannel(InputChannel outInputChannel) {
        if (this.mInputChannelToken != null) goto L7;
        String name = getName();
        InputChannel channel = this.mWmService.mInputManager.createInputChannel(name);
        this.mInputChannelToken = channel.getToken();
        this.mInputWindowHandle.setToken(this.mInputChannelToken);
        this.mWmService.mInputToWindowMap.put(this.mInputChannelToken, this);
        channel.copyTo(outInputChannel);
        channel.dispose();
        return;
    L7:
        throw new IllegalStateException("Window already has an input channel token.");
    }

    @Deprecated
    public boolean transferTouch() {
        return this.mWmService.mInputManager.transferTouch(this.mInputChannelToken, getDisplayId());
    }

    void disposeInputChannel() {
        if (this.mInputChannelToken == null) goto L5;
        this.mWmService.mInputManager.removeInputChannel(this.mInputChannelToken);
        this.mWmService.mKeyInterceptionInfoForToken.remove(this.mInputChannelToken);
        this.mWmService.mInputToWindowMap.remove(this.mInputChannelToken);
        this.mInputChannelToken = null;
    L5:
        this.mInputWindowHandle.setToken(null);
    }

    void setDisplayLayoutNeeded() {
        DisplayContent dc = getDisplayContent();
        if (dc == null) goto L6;
        dc.setLayoutNeeded();
        return;
    }

    @Override // com.android.server.wm.WindowContainer
    void switchUser(int userId) {
        super.switchUser(userId);
        if (showToCurrentUser() == false) goto L6;
        setPolicyVisibilityFlag(2);
        return;
    L6:
        if (WindowManagerDebugConfig.DEBUG_VISIBILITY == false) goto L8;
        Slog.w(TAG, "user changing, hiding " + this + ", attrs=" + this.mAttrs.type + ", belonging to " + this.mOwnerUid);
    L8:
        clearPolicyVisibilityFlag(2);
    }

    void getSurfaceTouchableRegion(Region region, WindowManager.LayoutParams attrs) {
        boolean modal = attrs.isModal();
        if (modal == true) goto L5;
        getTouchableRegion(region);
    L10:
        Rect frame = this.mWindowFrames.mFrame;
        if (frame.left == 0) goto L13;
    L14:
        region.translate(-frame.left, -frame.top);
    L15:
        if (modal == false) goto L20;
        if (this.mTouchableInsets != 3) goto L20;
        this.mTmpRegion.set(0, 0, frame.width(), frame.height());
        this.mTmpRegion.op(this.mGivenTouchableRegion, Region.Op.DIFFERENCE);
        region.op(this.mTmpRegion, Region.Op.DIFFERENCE);
    L20:
        if (this.mInvGlobalScale == 1.0f) goto L23;
        region.scale(this.mInvGlobalScale);
        return;
    L23:
        return;
    L13:
        if (frame.top == 0) goto L15;
    L5:
        if (this.mActivityRecord == null) goto L7;
        updateRegionForModalActivityWindow(region);
    L8:
        subtractTouchExcludeRegionIfNeeded(region);
        goto L10
    L7:
        getDisplayContent().getBounds(this.mTmpRect);
        int dw = this.mTmpRect.width();
        int dh = this.mTmpRect.height();
        region.set(-dw, -dh, dw + dw, dh + dh);
        goto L8
    }

    private void adjustRegionInFreeformWindowMode(Rect inOutRect) {
        if (inFreeformWindowingMode() == true) goto L5;
        return;
    L5:
        DisplayMetrics displayMetrics = getDisplayContent().getDisplayMetrics();
        int delta = WindowManagerService.dipToPixel(30, displayMetrics);
        inOutRect.inset(-delta, -delta);
    }

    private void updateRegionForModalActivityWindow(Region outRegion) {
        this.mActivityRecord.getLetterboxInnerBounds(this.mTmpRect);
        if (this.mTmpRect.isEmpty() == false) goto L10;
        Rect transformedBounds = this.mActivityRecord.getFixedRotationTransformDisplayBounds();
        if (transformedBounds == null) goto L7;
        this.mTmpRect.set(transformedBounds);
        goto L10
    L7:
        TaskFragment taskFragment = this.mActivityRecord.getTaskFragment();
        if (taskFragment == null) goto L10;
        taskFragment.getDimBounds(this.mTmpRect);
    L10:
        adjustRegionInFreeformWindowMode(this.mTmpRect);
        outRegion.set(this.mTmpRect);
        cropRegionToRootTaskBoundsIfNeeded(outRegion);
    }

    void checkPolicyVisibilityChange() {
        if (isLegacyPolicyVisibility() != this.mLegacyPolicyVisibilityAfterAnim) goto L5;
        return;
    L5:
        if (WindowManagerDebugConfig.DEBUG_VISIBILITY == false) goto L8;
        Slog.v(TAG, "Policy visibility changing after anim in " + this.mWinAnimator + ": " + this.mLegacyPolicyVisibilityAfterAnim);
    L8:
        if (this.mLegacyPolicyVisibilityAfterAnim == false) goto L10;
        setPolicyVisibilityFlag(1);
    L12:
        if (isVisibleByPolicy() == true) goto L25;
        this.mWinAnimator.hide(getPendingTransaction(), "checkPolicyVisibilityChange");
        if (this.mSurfaceControl == null) goto L17;
        getPendingTransaction().hide(this.mSurfaceControl);
    L17:
        if (isFocused() == true) goto L19;
    L22:
        setDisplayLayoutNeeded();
        this.mWmService.enableScreenIfNeededLocked();
        return;
    L19:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_LIGHT_enabled[2] == false) goto L21;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT, -6167820560758523840L, 0, null);
    L21:
        this.mWmService.mFocusMayChange = true;
        goto L22
    L25:
        return;
    L10:
        clearPolicyVisibilityFlag(1);
        goto L12
    }

    void setRequestedSize(int requestedWidth, int requestedHeight) {
        if (this.mRequestedWidth == requestedWidth) goto L5;
    L6:
        this.mLayoutNeeded = true;
        this.mRequestedWidth = requestedWidth;
        this.mRequestedHeight = requestedHeight;
        if ("com.ss.android.lark".equals(getOwningPackage()) == true) goto L9;
        return;
    L9:
        if (this.mAttrs.type == 1) goto L14;
        Slog.w(TAG, "setRequestedSize win: " + this + " requestedWidth: " + requestedWidth + " requestedHeight: " + requestedHeight);
        return;
    L14:
        return;
    L5:
        if (this.mRequestedHeight != requestedHeight) goto L6;
    }

    void prepareWindowToDisplayDuringRelayout(boolean wasVisible) {
        if ((this.mAttrs.flags & 2097152) == 0) goto L5;
    L10:
        boolean hasTurnScreenOnFlag = true;
    L12:
        if (hasTurnScreenOnFlag == true) goto L14;
    L42:
        if (wasVisible == false) goto L48;
        if (WindowManagerDebugConfig.DEBUG_VISIBILITY == false) goto L56;
        Slog.v(TAG, "Already visible and does not turn on screen, skip preparing: " + this);
        return;
    L56:
        return;
    L48:
        if ((this.mAttrs.softInputMode & FrameworkStatsLog.BOOT_TIME_EVENT_ELAPSED_TIME_REPORTED) != 16) goto L51;
        this.mLayoutNeeded = true;
    L51:
        if (isDrawn() == true) goto L53;
        return;
    L53:
        if (this.mToken.okToAnimate() == false) goto L58;
        this.mWinAnimator.applyEnterAnimationLocked();
        return;
    L58:
        return;
    L14:
        if (this.mWmService.mAllowTheaterModeWakeFromLayout == false) goto L16;
    L19:
        boolean allowTheaterMode = true;
    L21:
        if (this.mActivityRecord != null) goto L23;
    L26:
        boolean canTurnScreenOn = true;
    L27:
        if (allowTheaterMode == false) goto L40;
        if (canTurnScreenOn == false) goto L40;
        if (this.mWmService.mAtmService.isDreaming() == true) goto L34;
        if (this.mWmService.mPowerManager.isInteractive(getDisplayId()) == true) goto L40;
    L34:
        if (WindowManagerDebugConfig.DEBUG_VISIBILITY == false) goto L36;
    L37:
        Slog.v(TAG, "Relayout window turning screen on: " + this);
    L38:
        this.mWmService.mPowerManager.wakeUp(SystemClock.uptimeMillis(), 2, "android.server.wm:SCREEN_ON_FLAG", getDisplayId());
        goto L40
    L36:
        if (WindowManagerDebugConfig.DEBUG_POWER == false) goto L38;
    L40:
        if (this.mActivityRecord == null) goto L42;
        this.mActivityRecord.setCurrentLaunchCanTurnScreenOn(false);
        goto L42
    L23:
        if (this.mActivityRecord.currentLaunchCanTurnScreenOn() == true) goto L26;
        canTurnScreenOn = false;
        goto L27
    L16:
        if (Settings.Global.getInt(this.mWmService.mContext.getContentResolver(), "theater_mode_on", 0) == 0) goto L19;
        allowTheaterMode = false;
        goto L21
    L5:
        if (this.mActivityRecord != null) goto L7;
    L9:
        hasTurnScreenOnFlag = false;
        goto L12
    L7:
        if (this.mActivityRecord.canTurnScreenOn() == false) goto L9;
        goto L9
    }

    private Configuration getProcessGlobalConfiguration() {
        WindowState parentWindow = getParentWindow();
        if (parentWindow == null) goto L5;
        Session session = parentWindow.mSession;
    L7:
        if (session.mPid != WindowManagerService.MY_PID) goto L10;
        return this.mWmService.mRoot.getConfiguration();
    L10:
        return session.mProcess.getConfiguration();
    L5:
        session = this.mSession;
        goto L7
    }

    private Configuration getLastReportedConfiguration() {
        return this.mLastReportedConfiguration.getMergedConfiguration();
    }

    void adjustStartingWindowFlags() {
        boolean removeShowWhenLocked = true;
        if (this.mAttrs.type == 1) goto L5;
        return;
    L5:
        if (this.mActivityRecord != null) goto L7;
        return;
    L7:
        if (this.mActivityRecord.mStartingWindow == null) goto L23;
        WindowManager.LayoutParams sa = this.mActivityRecord.mStartingWindow.mAttrs;
        if ((sa.flags & 524288) == 0) goto L11;
        boolean wasShowWhenLocked = true;
    L13:
        if ((524288 & this.mAttrs.flags) == 0) goto L16;
        removeShowWhenLocked = false;
    L16:
        sa.flags = (sa.flags & (-4718594)) | (this.mAttrs.flags & 4718593);
        if (wasShowWhenLocked == false) goto L24;
        if (removeShowWhenLocked == false) goto L25;
        this.mActivityRecord.checkKeyguardFlagsChanged();
        this.mActivityRecord.deferStartingWindowRemovalForKeyguardUnoccluding();
        return;
    L25:
        return;
    L24:
        return;
    L11:
        wasShowWhenLocked = false;
        goto L13
    }

    void setWindowScale(int requestedWidth, int requestedHeight) {
        if ((this.mAttrs.flags & 16384) == 0) goto L5;
        boolean scaledWindow = true;
    L6:
        float r1 = 1.0f;
        if (scaledWindow == true) goto L9;
        this.mVScale = 1.0f;
        this.mHScale = 1.0f;
        return;
    L9:
        if (this.mAttrs.width == requestedWidth) goto L11;
        float r2 = this.mAttrs.width / requestedWidth;
    L12:
        this.mHScale = r2;
        if (this.mAttrs.height == requestedHeight) goto L16;
        r1 = this.mAttrs.height / requestedHeight;
    L16:
        this.mVScale = r1;
        return;
    L11:
        r2 = 1.0f;
        goto L12
    L5:
        scaledWindow = false;
        goto L6
    }

    boolean canReceiveKeys() {
        return canReceiveKeys(false);
    }

    public String canReceiveKeysReason(boolean fromUserTouch) {
        StringBuilder r0 = new StringBuilder();
        r0.append("fromTouch= ");
        r0.append(fromUserTouch);
        r0.append(" isVisibleRequestedOrAdding=");
        r0.append(isVisibleRequestedOrAdding());
        r0.append(" mViewVisibility=");
        r0.append(this.mViewVisibility);
        r0.append(" mRemoveOnExit=");
        r0.append(this.mRemoveOnExit);
        r0.append(" flags=");
        r0.append(this.mAttrs.flags);
        r0.append(" appWindowsAreFocusable=");
        boolean r2 = true;
        if (this.mActivityRecord != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        r0.append(r1);
        r0.append(" canReceiveTouchInput=");
        r0.append(canReceiveTouchInput());
        r0.append(" displayIsOnTop=");
        r0.append(getDisplayContent().isOnTop());
        r0.append(" displayIsTrusted=");
        r0.append(getDisplayContent().isTrusted());
        r0.append(" transitShouldKeepFocus=");
        if (this.mActivityRecord != null) goto L12;
    L14:
        r2 = false;
    L15:
        r0.append(r2);
        return r0.toString();
    L12:
        if (this.mTransitionController.shouldKeepFocus(this.mActivityRecord) == false) goto L14;
    L5:
        if (this.mActivityRecord.windowsAreFocusable(fromUserTouch) == true) goto L8;
        r1 = false;
        goto L9
    }

    public boolean canReceiveKeys(boolean fromUserTouch) {
        if (this.mActivityRecord == null) goto L8;
        if (this.mTransitionController.shouldKeepFocus(this.mActivityRecord) == false) goto L8;
        return true;
    L8:
        if (isVisibleRequestedOrAdding() == true) goto L10;
    L26:
        boolean canReceiveKeys = false;
    L28:
        if (canReceiveKeys == true) goto L30;
        return false;
    L30:
        if (fromUserTouch == false) goto L32;
        return true;
    L32:
        if (getDisplayContent().isOnTop() == false) goto L34;
        return true;
    L34:
        if (getDisplayContent().isTrusted() == false) goto L38;
        return true;
    L38:
        return false;
    L10:
        if (this.mViewVisibility != 0) goto L26;
        if (this.mRemoveOnExit == true) goto L26;
        if ((this.mAttrs.flags & 8) != 0) goto L26;
        if (this.mActivityRecord == null) goto L20;
        if (this.mActivityRecord.windowsAreFocusable(fromUserTouch) == false) goto L26;
    L20:
        if (this.mActivityRecord != null) goto L22;
    L25:
        canReceiveKeys = true;
        goto L28
    L22:
        if (this.mActivityRecord.getTask() == null) goto L25;
        if (this.mActivityRecord.getTask().getRootTask().shouldIgnoreInput() == true) goto L26;
        goto L25
    }

    @Override // com.android.server.policy.WindowManagerPolicy.WindowState
    public boolean canShowWhenLocked() {
        if (this.mActivityRecord == null) goto L7;
        return this.mActivityRecord.canShowWhenLocked();
    L7:
        if ((this.mAttrs.flags & 524288) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    void applySizeOverride(Configuration newParentConfig, Configuration resolvedConfig) {
        DisplayContent r0 = getDisplayContent();
        ApplicationInfo r1 = this.mSession.mProcess.mInfo;
        if ((this.mAttrs.privateFlags & 67108864) == 0) goto L6;
        boolean r2 = true;
    L7:
        ConfigurationContainer.applySizeOverrideIfNeeded(r0, r1, newParentConfig, resolvedConfig, r2, false, false, null);
        return;
    L6:
        r2 = false;
        goto L7
    }

    boolean canReceiveTouchInput() {
        if (this.mActivityRecord != null) goto L5;
    L20:
        return true;
    L5:
        if (this.mActivityRecord.getTask() == null) goto L20;
        if (this.mTransitionController.shouldKeepFocus(this.mActivityRecord) == false) goto L11;
        return true;
    L11:
        if (this.mWmService.mAtmService.mBackNavigationController.shouldPauseTouch(this.mActivityRecord) == false) goto L14;
        return false;
    L14:
        if (this.mActivityRecord.getTask().getRootTask().shouldIgnoreInput() == true) goto L19;
        if (this.mActivityRecord.isVisibleRequested() == false) goto L19;
        return true;
    L19:
        return false;
    }

    @Deprecated
    boolean hasDrawn() {
        if (this.mWinAnimator.mDrawState != 4) goto L5;
        return true;
    L5:
        return false;
    }

    boolean show(boolean doAnimation, boolean requestAnim) {
        if (isLegacyPolicyVisibility() == false) goto L8;
        if (this.mLegacyPolicyVisibilityAfterAnim == false) goto L8;
        return false;
    L8:
        if (showToCurrentUser() == true) goto L11;
        return false;
    L11:
        if (this.mAppOpVisibility == true) goto L14;
        return false;
    L14:
        if (this.mPermanentlyHidden == false) goto L17;
        return false;
    L17:
        if (this.mHiddenWhileSuspended == false) goto L20;
        return false;
    L20:
        if (this.mForceHideNonSystemOverlayWindow == false) goto L23;
        return false;
    L23:
        if (WindowManagerDebugConfig.DEBUG_VISIBILITY == false) goto L25;
        Slog.v(TAG, "Policy visibility true: " + this);
    L25:
        if (doAnimation == true) goto L27;
    L37:
        setPolicyVisibilityFlag(1);
        this.mLegacyPolicyVisibilityAfterAnim = true;
        if (this.mSurfaceControl == null) goto L40;
        getPendingTransaction().show(this.mSurfaceControl);
    L40:
        if (doAnimation == false) goto L42;
        this.mWinAnimator.applyAnimationLocked(1, true);
    L42:
        if (requestAnim == false) goto L45;
        this.mWmService.scheduleAnimationLocked();
    L45:
        if ((this.mAttrs.flags & 8) != 0) goto L47;
        this.mWmService.updateFocusedWindowLocked(0, false);
    L47:
        return true;
    L27:
        if (WindowManagerDebugConfig.DEBUG_VISIBILITY == false) goto L30;
        Slog.v(TAG, "doAnimation: mPolicyVisibility=" + isLegacyPolicyVisibility() + " animating=" + isAnimating(3));
    L30:
        if (this.mToken.okToAnimate() == true) goto L33;
        doAnimation = false;
        goto L37
    L33:
        if (isLegacyPolicyVisibility() == false) goto L37;
        if (isAnimating(3) == true) goto L37;
        doAnimation = false;
        goto L37
    }

    boolean hide(boolean doAnimation, boolean requestAnim) {
        if (doAnimation == true) goto L4;
    L20:
        if (doAnimation == false) goto L22;
        boolean current = this.mLegacyPolicyVisibilityAfterAnim;
    L24:
        if (current == true) goto L27;
        return false;
    L27:
        if (doAnimation == true) goto L29;
    L31:
        this.mLegacyPolicyVisibilityAfterAnim = false;
        boolean isFocused = isFocused();
        if (doAnimation == false) goto L34;
    L45:
        if (requestAnim == false) goto L47;
        this.mWmService.scheduleAnimationLocked();
    L47:
        if (isFocused == false) goto L49;
        this.mWmService.updateFocusedWindowLocked(0, false);
    L49:
        return true;
    L34:
        if (WindowManagerDebugConfig.DEBUG_VISIBILITY == false) goto L36;
        Slog.v(TAG, "Policy visibility false: " + this);
    L36:
        clearPolicyVisibilityFlag(1);
        this.mWmService.enableScreenIfNeededLocked();
        if (isFocused == false) goto L43;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_FOCUS_LIGHT_enabled[2] == false) goto L41;
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_FOCUS_LIGHT, -208079497999140637L, 0, null);
    L41:
        this.mWmService.mFocusMayChange = true;
    L43:
        if (this.mSurfaceControl == null) goto L45;
        getPendingTransaction().hide(this.mSurfaceControl);
        goto L45
    L29:
        if (this.mWinAnimator.applyAnimationLocked(2, false) == true) goto L31;
        doAnimation = false;
        goto L31
    L22:
        current = isLegacyPolicyVisibility();
        goto L24
    L4:
        if (this.mToken.okToAnimate() == true) goto L7;
        doAnimation = false;
    L7:
        if (this.mForceHideNonSystemOverlayWindow == true) goto L15;
        if (this.mHiddenWhileSuspended == true) goto L15;
        if (this.mAppOpVisibility == false) goto L15;
        if (this.mPermanentlyHidden == false) goto L20;
    L15:
        if (isAnimating() == false) goto L20;
        if (this.mAnimatingExit == false) goto L19;
        doAnimation = false;
    L19:
        cancelAnimation();
        goto L20
    }

    boolean isForceHiddenNonSystemOverlayWindow() {
        return this.mForceHideNonSystemOverlayWindow;
    }

    void setForceHideNonSystemOverlayWindowIfNeeded(boolean forceHide) {
        int baseType = getBaseType();
        if (this.mSession.mCanAddInternalSystemWindow == false) goto L5;
        return;
    L5:
        if (WindowManager.LayoutParams.isSystemAlertWindowType(baseType) == true) goto L10;
        if (baseType == 2005) goto L10;
        return;
    L10:
        if (baseType != 2038) goto L17;
        if (this.mAttrs.isSystemApplicationOverlay() == false) goto L17;
        if (this.mSession.mCanCreateSystemApplicationOverlay == false) goto L17;
        return;
    L17:
        if (this.mForceHideNonSystemOverlayWindow != forceHide) goto L19;
        return;
    L19:
        this.mForceHideNonSystemOverlayWindow = forceHide;
        if (forceHide == false) goto L22;
        hide(true, true);
        return;
    L22:
        show(true, true);
    }

    void setHiddenWhileSuspended(boolean hide) {
        if (this.mOwnerCanAddInternalSystemWindow == false) goto L5;
        return;
    L5:
        if (WindowManager.LayoutParams.isSystemAlertWindowType(this.mAttrs.type) == true) goto L10;
        if (this.mAttrs.type == 2005) goto L10;
        return;
    L10:
        if (this.mHiddenWhileSuspended != hide) goto L12;
        return;
    L12:
        this.mHiddenWhileSuspended = hide;
        if (hide == false) goto L15;
        hide(true, true);
        return;
    L15:
        show(true, true);
    }

    private void setAppOpVisibilityLw(boolean state) {
        if (this.mAppOpVisibility == state) goto L9;
        this.mAppOpVisibility = state;
        if (state == false) goto L7;
        show(true, true);
        return;
    L7:
        hide(true, true);
        return;
    }

    void initAppOpsState() {
        if (this.mAppOp != (-1)) goto L5;
        return;
    L5:
        if (this.mAppOpVisibility == false) goto L16;
        int mode = this.mWmService.mAppOps.startOpNoThrow(this.mAppOp, getOwningUid(), getOwningPackage(), true, null, "init-default-visibility");
        if (mode != 0) goto L10;
        return;
    L10:
        if (mode == 3) goto L15;
        setAppOpVisibilityLw(false);
        return;
    L15:
        return;
    }

    void resetAppOpsState() {
        if (this.mAppOp != (-1)) goto L5;
        return;
    L5:
        if (this.mAppOpVisibility == false) goto L9;
        this.mWmService.mAppOps.finishOp(this.mAppOp, getOwningUid(), getOwningPackage(), null);
        return;
    }

    void updateAppOpsState() {
        if (this.mAppOp != (-1)) goto L5;
        return;
    L5:
        int uid = getOwningUid();
        String packageName = getOwningPackage();
        if (this.mAppOpVisibility == false) goto L12;
        int mode = this.mWmService.mAppOps.checkOpNoThrow(this.mAppOp, uid, packageName);
        if (mode == 0) goto L19;
        if (mode == 3) goto L20;
        this.mWmService.mAppOps.finishOp(this.mAppOp, uid, packageName, null);
        setAppOpVisibilityLw(false);
        return;
    L20:
        return;
    L19:
        return;
    L12:
        int mode2 = this.mWmService.mAppOps.startOpNoThrow(this.mAppOp, uid, packageName, true, null, "attempt-to-be-visible");
        if (mode2 == 0) goto L15;
        if (mode2 == 3) goto L15;
        return;
    L15:
        setAppOpVisibilityLw(true);
    }

    public void hidePermanentlyLw() {
        if (this.mPermanentlyHidden == true) goto L6;
        this.mPermanentlyHidden = true;
        hide(true, true);
        return;
    }

    public void pokeDrawLockLw(long timeout) {
        if (isVisibleRequestedOrAdding() == false) goto L12;
        if (this.mDrawLock != null) goto L8;
        CharSequence tag = getWindowTag();
        this.mDrawLock = this.mWmService.mPowerManager.newWakeLock(128, "Window:" + tag);
        this.mDrawLock.setReferenceCounted(false);
        this.mDrawLock.setWorkSource(new WorkSource(this.mOwnerUid, this.mAttrs.packageName));
    L8:
        if (WindowManagerDebugConfig.DEBUG_POWER == false) goto L10;
        Slog.d(TAG, "pokeDrawLock: poking draw lock on behalf of visible window owned by " + this.mAttrs.packageName);
    L10:
        this.mDrawLock.acquire(timeout);
        return;
    L12:
        if (WindowManagerDebugConfig.DEBUG_POWER == false) goto L16;
        Slog.d(TAG, "pokeDrawLock: suppressed draw lock request for invisible window owned by " + this.mAttrs.packageName);
        return;
    }

    boolean isAlive() {
        return this.mClient.asBinder().isBinderAlive();
    }

    @Override // com.android.server.wm.WindowContainer
    void sendAppVisibilityToClients() {
        super.sendAppVisibilityToClients();
        boolean clientVisible = this.mToken.isClientVisible();
        if (this.mAttrs.type != 3) goto L25;
        if (clientVisible == true) goto L25;
        return;
    L25:
    L9:
        e = move-exception;
        Slog.w(TAG, "Exception thrown during dispatchAppVisibility " + this, e);
        if (Process.getUidForPid(this.mSession.mPid) == this.mSession.mUid) goto L16;
    L18:
        if (clientVisible == false) goto L20;
        return;
    L20:
        if (this.mActivityRecord != null) goto L22;
        return;
    L22:
        if (this.mWinAnimator.mDrawState != 4) goto L29;
        this.mWinAnimator.resetDrawState();
        forceReportingResized();
        return;
    L29:
        return;
    L16:
        if (Process.getThreadGroupLeader(this.mSession.mPid) != this.mSession.mPid) goto L18;
        Process.killProcess(this.mSession.mPid);
        goto L18
    L7:
        if (WindowManagerDebugConfig.DEBUG_VISIBILITY == false) goto L11;
        Slog.v(TAG, "Setting visibility of " + this + ": " + clientVisible);     // Catch: RemoteException -> L9
    L11:
        this.mClient.dispatchAppVisibility(clientVisible);     // Catch: RemoteException -> L9
        goto L18
    }

    boolean destroySurface(boolean cleanupOnResume, boolean appStopped) {
        boolean destroyedSomething = false;
        ArrayList<WindowState> childWindows = new ArrayList(this.mChildren);
        int i = childWindows.size() - 1;
    L3:
        if (i < 0) goto L6;
        WindowState c = childWindows.get(i);
        destroyedSomething = destroyedSomething | c.destroySurface(cleanupOnResume, appStopped);
        i = i - 1;
        goto L3
    L6:
        if (appStopped == true) goto L12;
        if (this.mWindowRemovalAllowed == true) goto L12;
        if (cleanupOnResume == true) goto L12;
        return destroyedSomething;
    L12:
        if (this.mDestroying == true) goto L14;
        return destroyedSomething;
    L14:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[4] == false) goto L16;
        String protoLogParam0 = String.valueOf(this);
        boolean protoLogParam2 = this.mWindowRemovalAllowed;
        boolean protoLogParam3 = this.mRemoveOnExit;
        ProtoLogImpl_798997914.e(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, -2964267636425934067L, AudioChannelMask.IN_6, new Object[]{protoLogParam0, Boolean.valueOf(appStopped), Boolean.valueOf(protoLogParam2), Boolean.valueOf(protoLogParam3)});
    L16:
        if (cleanupOnResume == true) goto L18;
    L19:
        destroySurfaceUnchecked();
    L21:
        if (this.mRemoveOnExit == false) goto L23;
        removeImmediately();
    L23:
        if (cleanupOnResume == false) goto L26;
        requestUpdateWallpaperIfNeeded();
    L26:
        if (this.mHasSurface == true) goto L31;
        this.mDestroying = false;
        return true;
    L31:
        return destroyedSomething;
    L18:
        if (this.mRemoveOnExit == false) goto L21;
        goto L19
    }

    void destroySurfaceUnchecked() {
        this.mWinAnimator.destroySurfaceLocked(this.mTmpTransaction);
        this.mTmpTransaction.apply();
        this.mAnimatingExit = false;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ANIM_enabled[0] == false) goto L6;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_ANIM, 7336961102428192483L, 0, new Object[]{protoLogParam0});
    L6:
        if (syncNextBuffer() == false) goto L9;
        immediatelyNotifyBlastSync();
        return;
    }

    void onSurfaceShownChanged(boolean shown) {
        if (this.mLastShownChangedReported != shown) goto L5;
        return;
    L5:
        this.mLastShownChangedReported = shown;
        if (shown == false) goto L8;
        initExclusionRestrictions();
    L10:
        if (this.mAttrs.type >= 2000) goto L12;
    L20:
        this.mObricExt.onSurfaceShownChanged(shown);
        if (this.mAttrs.type != 2011) goto L24;
        this.mExt.reportImeWindowShown(shown);
        return;
    L24:
        return;
    L12:
        if (this.mAttrs.type == 2005) goto L20;
        if (this.mAttrs.type == 2030) goto L20;
        if (this.mAttrs.type == 2037) goto L18;
    L19:
        this.mWmService.mAtmService.mActiveUids.onNonAppSurfaceVisibilityChanged(this.mOwnerUid, this.mAttrs.type, shown);
        goto L20
    L18:
        if (isOnVirtualDisplay() == true) goto L20;
    L8:
        logExclusionRestrictions(0);
        logExclusionRestrictions(1);
        getDisplayContent().removeImeSurfaceByTarget(this);
        goto L10
    }

    boolean isPresentation() {
        if (this.mAttrs.type != 2037) goto L5;
    L8:
        return true;
    L5:
        if (this.mAttrs.type == 2030) goto L8;
        return false;
    }

    private boolean isOnVirtualDisplay() {
        if (getDisplayContent().mDisplay.getType() != 5) goto L5;
        return true;
    L5:
        return false;
    }

    private void logExclusionRestrictions(int side) {
        if (DisplayContent.logsGestureExclusionRestrictions(this) == true) goto L5;
        return;
    L5:
        if (SystemClock.uptimeMillis() < (this.mLastExclusionLogUptimeMillis[side] + this.mWmService.mConstants.mSystemGestureExclusionLogDebounceTimeoutMillis)) goto L15;
        long now = SystemClock.uptimeMillis();
        long duration = now - this.mLastExclusionLogUptimeMillis[side];
        this.mLastExclusionLogUptimeMillis[side] = now;
        int requested = this.mLastRequestedExclusionHeight[side];
        int granted = this.mLastGrantedExclusionHeight[side];
        String r6 = this.mAttrs.packageName;
        int r8 = requested - granted;
        int r9 = side + 1;
        if (getConfiguration().orientation != 2) goto L11;
        boolean r5 = true;
    L12:
        FrameworkStatsLog.write(FrameworkStatsLog.EXCLUSION_RECT_STATE_CHANGED, r6, requested, r8, r9, r5, false, (int) duration);
        return;
    L11:
        r5 = false;
        goto L12
    }

    private void initExclusionRestrictions() {
        long now = SystemClock.uptimeMillis();
        this.mLastExclusionLogUptimeMillis[0] = now;
        this.mLastExclusionLogUptimeMillis[1] = now;
    }

    boolean showForAllUsers() {
        switch(this.mAttrs.type) {
            case 3: goto L9;
            case 2000: goto L9;
            case 2001: goto L9;
            case 2002: goto L9;
            case 2007: goto L9;
            case 2008: goto L9;
            case 2009: goto L9;
            case 2017: goto L9;
            case 2018: goto L9;
            case 2019: goto L9;
            case 2020: goto L9;
            case 2021: goto L9;
            case 2022: goto L9;
            case 2024: goto L9;
            case 2026: goto L9;
            case 2027: goto L9;
            case 2030: goto L9;
            case 2034: goto L9;
            case 2037: goto L9;
            case 2039: goto L9;
            case 2040: goto L9;
            case 2041: goto L9;
            default: goto L5;
        };
    L5:
        if ((this.mAttrs.privateFlags & 16) != 0) goto L9;
        return false;
    L9:
        return this.mOwnerCanAddInternalSystemWindow;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean showToCurrentUser() {
        WindowState win = getTopParentWindow();
        if (win.mAttrs.type >= 2000) goto L18;
        if (win.mActivityRecord == null) goto L18;
        if (win.mActivityRecord.mShowForAllUsers == false) goto L18;
        if (win.getFrame().left > win.getDisplayFrame().left) goto L18;
        if (win.getFrame().top > win.getDisplayFrame().top) goto L18;
        if (win.getFrame().right < win.getDisplayFrame().right) goto L18;
        if (win.getFrame().bottom < win.getDisplayFrame().bottom) goto L18;
        return true;
    L18:
        if (win.showForAllUsers() == false) goto L20;
        return true;
    L20:
        if (this.mWmService.isUserVisible(win.mShowUserId) == true) goto L26;
        return false;
    L26:
        return true;
    }

    private static void applyInsets(Region outRegion, Rect frame, Rect inset) {
        outRegion.set(frame.left + inset.left, frame.top + inset.top, frame.right - inset.right, frame.bottom - inset.bottom);
    }

    void getTouchableRegion(Region outRegion) {
        Rect frame = this.mWindowFrames.mFrame;
        switch(this.mTouchableInsets) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L5;
            default: goto L4;
        };
    L4:
        outRegion.set(frame);
    L12:
        cropRegionToRootTaskBoundsIfNeeded(outRegion);
        subtractTouchExcludeRegionIfNeeded(outRegion);
        return;
    L5:
        outRegion.set(this.mGivenTouchableRegion);
        if (frame.left == 0) goto L8;
    L9:
        outRegion.translate(frame.left, frame.top);
        goto L12
    L8:
        if (frame.top == 0) goto L12;
    L10:
        applyInsets(outRegion, frame, this.mGivenVisibleInsets);
        goto L12
    L11:
        applyInsets(outRegion, frame, this.mGivenContentInsets);
        goto L12
    }

    void getEffectiveTouchableRegion(Region outRegion) {
        DisplayContent dc = getDisplayContent();
        if (this.mAttrs.isModal() == false) goto L6;
        if (dc == null) goto L6;
        outRegion.set(dc.getBounds());
        cropRegionToRootTaskBoundsIfNeeded(outRegion);
        subtractTouchExcludeRegionIfNeeded(outRegion);
        return;
    L6:
        getTouchableRegion(outRegion);
    }

    private void cropRegionToRootTaskBoundsIfNeeded(Region region) {
        Task task = getTask();
        if (task != null) goto L5;
        return;
    L5:
        if (task.cropWindowsToRootTaskBounds() == false) goto L17;
        Task rootTask = task.getRootTask();
        if (rootTask != null) goto L10;
        return;
    L10:
        if (rootTask.mCreatedByOrganizer == true) goto L16;
        rootTask.getDimBounds(this.mTmpRect);
        adjustRegionInFreeformWindowMode(this.mTmpRect);
        region.op(this.mTmpRect, Region.Op.INTERSECT);
        return;
    L16:
        return;
    }

    private void subtractTouchExcludeRegionIfNeeded(Region touchableRegion) {
        if (this.mTapExcludeRegion.isEmpty() == false) goto L5;
        return;
    L5:
        Region touchExcludeRegion = Region.obtain();
        getTapExcludeRegion(touchExcludeRegion);
        if (touchExcludeRegion.isEmpty() == true) goto L8;
        touchableRegion.op(touchExcludeRegion, Region.Op.DIFFERENCE);
    L8:
        touchExcludeRegion.recycle();
    }

    void reportFocusChangedSerialized(boolean focused) {
        if (this.mFocusCallbacks == null) goto L22;
        int N = this.mFocusCallbacks.beginBroadcast();
        int i = 0;
    L5:
        if (i >= N) goto L14;
        IWindowFocusObserver obs = this.mFocusCallbacks.getBroadcastItem(i);
        if (focused == true) goto L16;
        obs.focusLost(this.mWindowId.asBinder());     // Catch: RemoteException -> L9
    L13:
        i = i + 1;
        goto L5
    L16:
        obs.focusGained(this.mWindowId.asBinder());     // Catch: RemoteException -> L9
        goto L13
    L14:
        this.mFocusCallbacks.finishBroadcast();
        return;
    }

    @Override // com.android.server.wm.ConfigurationContainer
    public Configuration getConfiguration() {
        if (registeredForDisplayAreaConfigChanges() == false) goto L5;
        this.mTempConfiguration.setTo(getProcessGlobalConfiguration());
        this.mTempConfiguration.updateFrom(getMergedOverrideConfiguration());
        return this.mTempConfiguration;
    L5:
        return super.getConfiguration();
    }

    private boolean registeredForDisplayAreaConfigChanges() {
        WindowState parentWindow = getParentWindow();
        if (parentWindow == null) goto L5;
        Session session = parentWindow.mSession;
    L7:
        if (session.mPid != WindowManagerService.MY_PID) goto L11;
        return false;
    L11:
        return session.mProcess.registeredForDisplayAreaConfigChanges();
    L5:
        session = this.mSession;
        goto L7
    }

    WindowProcessController getProcess() {
        return this.mSession.mProcess;
    }

    void fillClientWindowFramesAndConfiguration(ClientWindowFrames outFrames, MergedConfiguration outMergedConfiguration, ActivityWindowInfo outActivityWindowInfo, boolean useLatestConfig, boolean relayoutVisible) {
        outFrames.frame.set(this.mWindowFrames.mCompatFrame);
        outFrames.displayFrame.set(this.mWindowFrames.mDisplayFrame);
        if (this.mInvGlobalScale == 1.0f) goto L6;
        outFrames.displayFrame.scale(this.mInvGlobalScale);
    L6:
        if (this.mLayoutAttached == true) goto L8;
    L13:
        outFrames.compatScale = getCompatScaleForClient();
        outFrames.seq = SequenceUtils.getNextSeq(this.mLastReportedFrames.seq);
        if (this.mLastReportedFrames == outFrames) goto L16;
        this.mLastReportedFrames.setTo(outFrames);
    L16:
        if (useLatestConfig == true) goto L28;
        if (relayoutVisible == true) goto L19;
    L23:
        outMergedConfiguration.setTo(this.mLastReportedConfiguration);
        if (outActivityWindowInfo != null) goto L26;
    L36:
        this.mLastConfigReportedToClient = true;
        return;
    L26:
        if (this.mLastReportedActivityWindowInfo == null) goto L36;
        outActivityWindowInfo.set(this.mLastReportedActivityWindowInfo);
        goto L36
    L19:
        if (this.mActivityRecord == null) goto L28;
        if (this.mActivityRecord.isVisibleRequested() == false) goto L23;
    L28:
        Configuration globalConfig = getProcessGlobalConfiguration();
        Configuration overrideConfig = getMergedOverrideConfiguration();
        outMergedConfiguration.setConfiguration(globalConfig, overrideConfig);
        if (outMergedConfiguration == this.mLastReportedConfiguration) goto L31;
        this.mLastReportedConfiguration.setTo(outMergedConfiguration);
    L31:
        if (outActivityWindowInfo == null) goto L36;
        if (this.mLastReportedActivityWindowInfo == null) goto L36;
        outActivityWindowInfo.set(this.mActivityRecord.getActivityWindowInfo());
        this.mLastReportedActivityWindowInfo.set(outActivityWindowInfo);
        goto L36
    L8:
        if (outFrames.attachedFrame != null) goto L10;
        outFrames.attachedFrame = new Rect();
    L10:
        outFrames.attachedFrame.set(getParentWindow().getFrame());
        if (this.mInvGlobalScale == 1.0f) goto L13;
        outFrames.attachedFrame.scale(this.mInvGlobalScale);
        goto L13
    }

    void fillInsetsState(InsetsState outInsetsState, boolean copySources) {
        int lastSeq = this.mLastReportedInsetsState.getSeq();
        outInsetsState.set(getCompatInsetsState(), copySources);
        outInsetsState.setSeq(SequenceUtils.getNextSeq(lastSeq));
        if (outInsetsState == this.mLastReportedInsetsState) goto L6;
        this.mLastReportedInsetsState.set(outInsetsState, false);
        return;
    }

    void fillInsetsSourceControls(InsetsSourceControl.Array outArray, boolean copyControls) {
        int lastSeq = this.mLastReportedActiveControls.getSeq();
        InsetsSourceControl[] controls = getDisplayContent().getInsetsStateController().getControlsForDispatch(this);
        outArray.set(controls, copyControls);
        outArray.setSeq(SequenceUtils.getNextSeq(lastSeq));
        if (outArray == this.mLastReportedActiveControls) goto L6;
        this.mLastReportedActiveControls.setTo(outArray, false);
        return;
    }

    void reportResized() {
        if (inRelaunchingActivity() == false) goto L8;
        if (this.mAttrs.type == 3) goto L8;
        return;
    L8:
        if (shouldCheckTokenVisibleRequested() == false) goto L13;
        if (this.mToken.isVisibleRequested() == true) goto L13;
        return;
    L13:
        if (Trace.isTagEnabled(32) == false) goto L16;
        Trace.traceBegin(32, "wm.reportResized_" + getWindowTag());
    L16:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_RESIZE_enabled[1] == false) goto L19;
        String protoLogParam0 = String.valueOf(this);
        String protoLogParam1 = String.valueOf(this.mWindowFrames.mCompatFrame);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_RESIZE, -6920306331987525705L, 0, new Object[]{protoLogParam0, protoLogParam1});
    L19:
        if (this.mWinAnimator.mDrawState != 1) goto L21;
        boolean r1 = true;
    L22:
        boolean drawPending = r1;
        if (drawPending == true) goto L25;
    L27:
        this.mDragResizingChangeReported = true;
        this.mWindowFrames.clearReportResizeHints();
        int prevRotation = this.mLastReportedConfiguration.getMergedConfiguration().windowConfiguration.getRotation();
        fillClientWindowFramesAndConfiguration(this.mLastReportedFrames, this.mLastReportedConfiguration, this.mLastReportedActivityWindowInfo, true, false);
        fillInsetsState(this.mLastReportedInsetsState, false);
        boolean syncRedraw = shouldSendRedrawForSync();
        if (syncRedraw == true) goto L30;
    L32:
        boolean syncWithBuffers = false;
    L33:
        if (syncRedraw == true) goto L37;
        if (drawPending == true) goto L37;
        boolean r3 = false;
    L38:
        boolean reportDraw = r3;
        boolean isDragResizeChanged = isDragResizeChanged();
        if (syncWithBuffers == true) goto L43;
        if (isDragResizeChanged == true) goto L43;
        boolean forceRelayout = false;
    L44:
        DisplayContent displayContent = getDisplayContent();
        boolean alwaysConsumeSystemBars = displayContent.getDisplayPolicy().areSystemBarsForcedConsumedLw();
        int displayId = displayContent.getDisplayId();
        if (isDragResizeChanged == false) goto L47;
        setDragResizing();
    L47:
        boolean isDragResizing = isDragResizing();
        markRedrawForSyncReported();
        WindowProcessController r5 = getProcess();
        IWindow r13 = this.mClient;
        ClientWindowFrames r14 = this.mLastReportedFrames;
        MergedConfiguration r8 = this.mLastReportedConfiguration;
        InsetsState r9 = this.mLastReportedInsetsState;
        if (syncWithBuffers == false) goto L51;
        int r6 = this.mSyncSeqId;
    L52:
        r5.scheduleClientTransactionItem(new WindowStateResizeItem(r13, r14, reportDraw, r8, r9, forceRelayout, alwaysConsumeSystemBars, displayId, r6, isDragResizing, this.mLastReportedActivityWindowInfo));
        onResizePostDispatched(drawPending, prevRotation, displayId);
        Trace.traceEnd(32);
        return;
    L51:
        r6 = -1;
    L43:
        forceRelayout = true;
    L37:
        r3 = true;
        goto L38
    L30:
        if (shouldSyncWithBuffers() == false) goto L32;
        syncWithBuffers = true;
        goto L33
    L25:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[2] == false) goto L27;
        String protoLogParam2 = String.valueOf(this);
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_DEBUG_ORIENTATION, 2714651498627020992L, 0, new Object[]{protoLogParam2});
        goto L27
    L21:
        r1 = false;
        goto L22
    }

    private void onResizePostDispatched(boolean drawPending, int prevRotation, int displayId) {
        if (drawPending == false) goto L10;
        if (prevRotation < 0) goto L10;
        if (prevRotation == this.mLastReportedConfiguration.getMergedConfiguration().windowConfiguration.getRotation()) goto L10;
        this.mOrientationChangeRedrawRequestTime = SystemClock.elapsedRealtime();
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L10;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, -5755338358883139945L, 0, new Object[]{protoLogParam0});
    L10:
        if (this.mWmService.mAccessibilityController.hasCallbacks() == false) goto L13;
        this.mWmService.mAccessibilityController.onSomeWindowResizedOrMoved(new int[]{displayId});
        return;
    }

    boolean inRelaunchingActivity() {
        if (this.mActivityRecord != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mActivityRecord.isRelaunching() == false) goto L7;
        return true;
    }

    boolean isClientLocal() {
        return this.mClient instanceof IWindow.Stub;
    }

    private void consumeInsetsChange() {
        if (this.mWindowFrames.hasInsetsChanged() == false) goto L8;
        this.mWindowFrames.setInsetsChanged(false);
        this.mWmService.mWindowsInsetsChanged--;
        if (this.mWmService.mWindowsInsetsChanged != 0) goto L9;
        this.mWmService.mH.removeMessages(66);
        return;
    L9:
        return;
    }

    void notifyInsetsChanged() {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_INSETS_enabled[0] == false) goto L6;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_WINDOW_INSETS, -5211036212243647844L, 0, new Object[]{protoLogParam0});
    L6:
        if (this.mWindowFrames.hasInsetsChanged() == true) goto L8;
        this.mWindowFrames.setInsetsChanged(true);
        this.mWmService.mWindowsInsetsChanged++;
        this.mWmService.mH.removeMessages(66);
        this.mWmService.mH.sendEmptyMessage(66);
    L8:
        WindowContainer p = getParent();
        if (p == null) goto L12;
        p.updateOverlayInsetsState(this);
        return;
    }

    @Override // com.android.server.wm.InsetsControlTarget
    public void notifyInsetsControlChanged(int displayId) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_WINDOW_INSETS_enabled[0] == false) goto L6;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_WINDOW_INSETS, -3186229270467822891L, 0, new Object[]{protoLogParam0});
    L6:
        if (this.mRemoved == false) goto L8;
        return;
    L8:
        fillInsetsState(this.mLastReportedInsetsState, false);
        fillInsetsSourceControls(this.mLastReportedActiveControls, false);
        getProcess().scheduleClientTransactionItem(new WindowStateInsetsControlChangeItem(this.mClient, this.mLastReportedInsetsState, this.mLastReportedActiveControls));
    }

    @Override // com.android.server.wm.InsetsControlTarget
    public WindowState getWindow() {
        return this;
    }

    @Override // com.android.server.wm.InsetsControlTarget
    public void showInsets(int types, boolean fromIme, ImeTracker.Token statsToken) {
        SysOptBridge.getFactory().getDynamicRefreshRateService().onInsetAnimationShow(types);     // Catch: RemoteException -> L5
        ImeTracker.forLogging().onProgress(statsToken, 21);     // Catch: RemoteException -> L5
        this.mClient.showInsets(types, fromIme, statsToken);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Slog.w(TAG, "Failed to deliver showInsets", e);
        ImeTracker.forLogging().onFailed(statsToken, 21);
    }

    @Override // com.android.server.wm.InsetsControlTarget
    public void hideInsets(int types, boolean fromIme, ImeTracker.Token statsToken) {
        SysOptBridge.getFactory().getDynamicRefreshRateService().onInsetAnimationHide(types);     // Catch: RemoteException -> L5
        ImeTracker.forLogging().onProgress(statsToken, 22);     // Catch: RemoteException -> L5
        this.mClient.hideInsets(types, fromIme, statsToken);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Slog.w(TAG, "Failed to deliver hideInsets", e);
        ImeTracker.forLogging().onFailed(statsToken, 22);
    }

    @Override // com.android.server.wm.InsetsControlTarget
    public boolean canShowTransient() {
        if ((this.mAttrs.insetsFlags.behavior & 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean canBeHiddenByKeyguard() {
        if (this.mActivityRecord == null) goto L6;
        return false;
    L6:
        switch(this.mAttrs.type) {
            case 2000: goto L11;
            case 2013: goto L11;
            case 2019: goto L11;
            case 2040: goto L11;
            case 2997: goto L11;
            case 2998: goto L11;
            default: goto L8;
        };
    L11:
        return false;
    L8:
        if (this.mPolicy.getWindowLayerLw(this) >= this.mPolicy.getWindowLayerFromTypeLw(2040)) goto L12;
        return true;
    L12:
        return false;
    }

    public void registerFocusObserver(IWindowFocusObserver observer) {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mFocusCallbacks != null) goto L9;
        this.mFocusCallbacks = new RemoteCallbackList();     // Catch: Throwable -> L7
    L9:
        this.mFocusCallbacks.register(observer);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
    }

    public void unregisterFocusObserver(IWindowFocusObserver observer) {
        WindowManagerGlobalLock r0 = this.mWmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L7:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (this.mFocusCallbacks == null) goto L9;
        this.mFocusCallbacks.unregister(observer);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        WindowManagerService.resetPriorityAfterLockedSection();
    }

    boolean isFocused() {
        if (getDisplayContent().mCurrentFocus != this) goto L5;
        return true;
    L5:
        return false;
    }

    boolean areAppWindowBoundsLetterboxed() {
        if (this.mActivityRecord != null) goto L5;
    L13:
        return false;
    L5:
        if (isStartingWindowAssociatedToTask() == true) goto L13;
        if (this.mActivityRecord.areBoundsLetterboxed() == false) goto L9;
    L12:
        return true;
    L9:
        if (isLetterboxedForDisplayCutout() == true) goto L12;
        if (this.mActivityRecord.mAppCompatController.getSafeRegionPolicy().isLetterboxedForSafeRegionOnlyAllowed() == false) goto L13;
        goto L12
    }

    boolean isLetterboxedForDisplayCutout() {
        if (this.mActivityRecord != null) goto L6;
        return false;
    L6:
        if (this.mWindowFrames.parentFrameWasClippedByDisplayCutout() == true) goto L9;
        return false;
    L9:
        if (this.mAttrs.layoutInDisplayCutoutMode != 3) goto L12;
        return false;
    L12:
        if (this.mAttrs.isFullscreen() == true) goto L15;
        return false;
    L15:
        return !frameCoversEntireAppTokenBounds();
    }

    private boolean frameCoversEntireAppTokenBounds() {
        this.mTmpRect.set(this.mActivityRecord.getBounds());
        this.mTmpRect.intersectUnchecked(this.mWindowFrames.mFrame);
        return this.mActivityRecord.getBounds().equals(this.mTmpRect);
    }

    boolean isFullyTransparentBarAllowed(Rect frame) {
        if (this.mActivityRecord != null) goto L5;
    L8:
        return true;
    L5:
        if (this.mActivityRecord.isFullyTransparentBarAllowed(frame) == true) goto L8;
        return false;
    }

    boolean isDragResizeChanged() {
        if (this.mDragResizing == computeDragResizing()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.wm.WindowContainer
    void resetDragResizingChangeReported() {
        this.mDragResizingChangeReported = false;
        super.resetDragResizingChangeReported();
    }

    private boolean computeDragResizing() {
        Task task = getTask();
        if (task != null) goto L6;
        return false;
    L6:
        if (inFreeformWindowingMode() == true) goto L11;
        if (task.getRootTask().mCreatedByOrganizer == true) goto L11;
        return false;
    L11:
        if (task.getActivityType() != 2) goto L14;
        return false;
    L14:
        if (this.mAttrs.width == (-1)) goto L16;
    L23:
        return false;
    L16:
        if (this.mAttrs.height != (-1)) goto L23;
        if (task.isDragResizing() == false) goto L22;
        return true;
    L22:
        return false;
    }

    void setDragResizing() {
        boolean resizing = computeDragResizing();
        if (resizing != this.mDragResizing) goto L5;
        return;
    L5:
        this.mDragResizing = resizing;
    }

    boolean isDragResizing() {
        return this.mDragResizing;
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.ConfigurationContainer
    public void dumpDebug(ProtoOutputStream proto, long fieldId, int logLevel) {
        boolean isVisible = isVisible();
        if (logLevel != 2) goto L6;
        if (isVisible == true) goto L6;
        return;
    L6:
        long token = proto.start(fieldId);
        super.dumpDebug(proto, 1146756268033L, logLevel);
        proto.write(1120986464259L, getDisplayId());
        int rootTaskId = -1;
        Task task = getTask();
        if (task == null) goto L9;
        rootTaskId = task.getRootTaskId();
    L9:
        proto.write(1120986464260L, rootTaskId);
        this.mAttrs.dumpDebug(proto, 1146756268037L);
        this.mGivenContentInsets.dumpDebug(proto, 1146756268038L);
        this.mWindowFrames.dumpDebug(proto, 1146756268073L);
        this.mAttrs.surfaceInsets.dumpDebug(proto, 1146756268044L);
        GraphicsProtos.dumpPointProto(this.mSurfacePosition, proto, 1146756268048L);
        this.mWinAnimator.dumpDebug(proto, 1146756268045L);
        proto.write(1133871366158L, this.mAnimatingExit);
        proto.write(1120986464274L, this.mRequestedWidth);
        proto.write(1120986464275L, this.mRequestedHeight);
        proto.write(1120986464276L, this.mViewVisibility);
        proto.write(1133871366166L, this.mHasSurface);
        proto.write(1133871366167L, isReadyForDisplay());
        proto.write(1133871366178L, this.mRemoveOnExit);
        proto.write(1133871366179L, this.mDestroying);
        proto.write(1133871366180L, this.mRemoved);
        proto.write(1133871366181L, isOnScreen());
        proto.write(1133871366182L, isVisible);
        proto.write(1133871366186L, this.mForceSeamlesslyRotate);
        proto.write(1133871366187L, hasCompatScale());
        proto.write(1108101562412L, this.mGlobalScale);
        proto.write(1120986464304L, this.mRequestedVisibleTypes);
        Iterator<Rect> r5 = this.mKeepClearAreas.iterator();
    L11:
        if (r5.hasNext() == false) goto L13;
        Rect r = r5.next();
        r.dumpDebug(proto, 2246267895853L);
        goto L11
    L13:
        Iterator<Rect> r6 = this.mUnrestrictedKeepClearAreas.iterator();
    L15:
        if (r6.hasNext() == false) goto L18;
        Rect r2 = r6.next();
        r2.dumpDebug(proto, 2246267895854L);
        goto L15
    L18:
        if (this.mMergedLocalInsetsSources == null) goto L24;
        int i = 0;
    L21:
        if (i >= this.mMergedLocalInsetsSources.size()) goto L24;
        this.mMergedLocalInsetsSources.valueAt(i).dumpDebug(proto, 2246267895855L);
        i = i + 1;
    L24:
        if (getDimController() == null) goto L28;
        Rect dimBounds = getDimController().getDimBounds();
        if (dimBounds == null) goto L28;
        dimBounds.dumpDebug(proto, 1146756268081L);
    L28:
        proto.write(1120986464307L, this.mSyncSeqId);
        proto.write(1120986464306L, this.mPrepareSyncSeqId);
        proto.end(token);
    }

    @Override // com.android.server.wm.WindowContainer
    long getProtoFieldId() {
        return 1146756268040L;
    }

    @Override // com.android.server.wm.WindowContainer
    public void writeIdentifierToProto(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1120986464257L, System.identityHashCode(this));
        proto.write(1120986464258L, this.mShowUserId);
        CharSequence title = getWindowTag();
        if (title == null) goto L5;
        proto.write(1138166333443L, title.toString());
    L5:
        proto.end(token);
    }

    @Override // com.android.server.wm.WindowContainer
    @NeverCompile
    void dump(PrintWriter pw, String prefix, boolean dumpAll) {
        pw.print(prefix + "mDisplayId=" + getDisplayId());
        Task task = getTask();
        if (task == null) goto L5;
        pw.print(" taskId=" + task.mTaskId);
    L5:
        pw.println(" mSession=" + this.mSession + " mClient=" + this.mClient.asBinder());
        pw.println(prefix + "mOwnerUid=" + this.mOwnerUid + " showForAllUsers=" + showForAllUsers() + " package=" + this.mAttrs.packageName + " appop=" + AppOpsManager.opToName(this.mAppOp));
        StringBuilder r1 = new StringBuilder();
        r1.append(prefix);
        r1.append("mAttrs=");
        r1.append(this.mAttrs.toString(prefix));
        pw.println(r1.toString());
        pw.println(prefix + "Requested w=" + this.mRequestedWidth + " h=" + this.mRequestedHeight + " mLayoutSeq=" + this.mLayoutSeq);
        if (this.mRequestedWidth == this.mLastRequestedWidth) goto L8;
    L9:
        pw.println(prefix + "LastRequested w=" + this.mLastRequestedWidth + " h=" + this.mLastRequestedHeight);
    L11:
        if (this.mIsChildWindow == false) goto L13;
    L14:
        pw.println(prefix + "mParentWindow=" + getParentWindow() + " mLayoutAttached=" + this.mLayoutAttached);
    L16:
        if (this.mIsImWindow == false) goto L18;
    L21:
        pw.println(prefix + "mIsImWindow=" + this.mIsImWindow + " mIsWallpaper=" + this.mIsWallpaper + " mIsFloatingLayer=" + this.mIsFloatingLayer);
    L22:
        if (dumpAll == false) goto L24;
        pw.print(prefix);
        pw.print("mBaseLayer=");
        pw.print(this.mBaseLayer);
        pw.print(" mSubLayer=");
        pw.print(this.mSubLayer);
    L24:
        if (dumpAll == false) goto L32;
        pw.println(prefix + "mToken=" + this.mToken);
        if (this.mActivityRecord == null) goto L28;
        pw.println(prefix + "mActivityRecord=" + this.mActivityRecord);
        pw.print(prefix + "drawnStateEvaluated=" + getDrawnStateEvaluated());
        pw.println(prefix + "mightAffectAllDrawn=" + mightAffectAllDrawn());
    L28:
        pw.println(prefix + "mViewVisibility=0x" + Integer.toHexString(this.mViewVisibility) + " mHaveFrame=" + this.mHaveFrame + " mObscured=" + this.mObscured);
        if (this.mDisableFlags == 0) goto L32;
        pw.println(prefix + "mDisableFlags=" + ViewDebug.flagsToString(View.class, "mSystemUiVisibility", this.mDisableFlags));
    L32:
        if (isVisibleByPolicy() == true) goto L34;
    L45:
        pw.println(prefix + "mPolicyVisibility=" + isVisibleByPolicy() + " mLegacyPolicyVisibilityAfterAnim=" + this.mLegacyPolicyVisibilityAfterAnim + " mAppOpVisibility=" + this.mAppOpVisibility + " parentHidden=" + isParentWindowHidden() + " mPermanentlyHidden=" + this.mPermanentlyHidden + " mHiddenWhileSuspended=" + this.mHiddenWhileSuspended + " mForceHideNonSystemOverlayWindow=" + this.mForceHideNonSystemOverlayWindow);
    L47:
        if (this.mRelayoutCalled == true) goto L49;
    L50:
        pw.println(prefix + "mRelayoutCalled=" + this.mRelayoutCalled + " mLayoutNeeded=" + this.mLayoutNeeded);
    L51:
        if (dumpAll == false) goto L60;
        pw.println(prefix + "mGivenContentInsets=" + this.mGivenContentInsets.toShortString(sTmpSB) + " mGivenVisibleInsets=" + this.mGivenVisibleInsets.toShortString(sTmpSB));
        if (this.mTouchableInsets == 0) goto L55;
    L56:
        pw.println(prefix + "mTouchableInsets=" + this.mTouchableInsets + " mGivenInsetsPending=" + this.mGivenInsetsPending);
        Region region = new Region();
        getTouchableRegion(region);
        pw.println(prefix + "touchable region=" + region);
    L57:
        pw.println(prefix + "mFullConfiguration=" + getConfiguration());
        pw.println(prefix + "mLastReportedConfiguration=" + getLastReportedConfiguration());
        if (this.mLastReportedActivityWindowInfo == null) goto L60;
        pw.println(prefix + "mLastReportedActivityWindowInfo=" + this.mLastReportedActivityWindowInfo);
        goto L60
    L55:
        if (this.mGivenInsetsPending == false) goto L57;
    L60:
        pw.println(prefix + "mHasSurface=" + this.mHasSurface + " isReadyForDisplay()=" + isReadyForDisplay() + " mWindowRemovalAllowed=" + this.mWindowRemovalAllowed);
        if (this.mIsSurfacePositionPaused == false) goto L64;
        pw.println(prefix + "mIsSurfacePositionPaused=true");
    L64:
        if (this.mInvGlobalScale == 1.0f) goto L66;
        pw.println(prefix + "mCompatFrame=" + this.mWindowFrames.mCompatFrame.toShortString(sTmpSB));
    L66:
        if (dumpAll == false) goto L68;
        this.mWindowFrames.dump(pw, prefix);
        pw.println(prefix + " surface=" + this.mAttrs.surfaceInsets.toShortString(sTmpSB));
    L68:
        super.dump(pw, prefix, dumpAll);
        pw.println(prefix + this.mWinAnimator + ":");
        this.mWinAnimator.dump(pw, prefix + "  ", dumpAll);
        if (this.mAnimatingExit == false) goto L71;
    L76:
        pw.println(prefix + "mAnimatingExit=" + this.mAnimatingExit + " mRemoveOnExit=" + this.mRemoveOnExit + " mDestroying=" + this.mDestroying + " mRemoved=" + this.mRemoved);
    L78:
        if (this.mXOffset == 0) goto L80;
    L81:
        pw.println(prefix + "mXOffset=" + this.mXOffset + " mYOffset=" + this.mYOffset);
    L83:
        if (this.mHScale == 1.0f) goto L85;
    L86:
        pw.println(prefix + "mHScale=" + this.mHScale + " mVScale=" + this.mVScale);
    L88:
        if (this.mWallpaperX == (-1.0f)) goto L90;
    L91:
        pw.println(prefix + "mWallpaperX=" + this.mWallpaperX + " mWallpaperY=" + this.mWallpaperY);
    L93:
        if (this.mWallpaperXStep == (-1.0f)) goto L95;
    L96:
        pw.println(prefix + "mWallpaperXStep=" + this.mWallpaperXStep + " mWallpaperYStep=" + this.mWallpaperYStep);
    L98:
        if (this.mWallpaperZoomOut == (-1.0f)) goto L101;
        pw.println(prefix + "mWallpaperZoomOut=" + this.mWallpaperZoomOut);
    L101:
        if (this.mWallpaperDisplayOffsetX == Integer.MIN_VALUE) goto L103;
    L104:
        pw.println(prefix + "mWallpaperDisplayOffsetX=" + this.mWallpaperDisplayOffsetX + " mWallpaperDisplayOffsetY=" + this.mWallpaperDisplayOffsetY);
    L106:
        if (this.mDrawLock == null) goto L109;
        pw.println(prefix + "mDrawLock=" + this.mDrawLock);
    L109:
        if (isDragResizing() == false) goto L112;
        pw.println(prefix + "isDragResizing=" + isDragResizing());
    L112:
        if (computeDragResizing() == false) goto L115;
        pw.println(prefix + "computeDragResizing=" + computeDragResizing());
    L115:
        if (this.mImeInsetsConsumed == false) goto L117;
        pw.println(prefix + "mImeInsetsConsumed=true");
    L117:
        pw.println(prefix + "isOnScreen=" + isOnScreen());
        pw.println(prefix + "isVisible=" + isVisible());
        pw.println(prefix + "keepClearAreas: restricted=" + this.mKeepClearAreas + ", unrestricted=" + this.mUnrestrictedKeepClearAreas);
        if (dumpAll == true) goto L120;
    L122:
        pw.println(prefix + "mPrepareSyncSeqId=" + this.mPrepareSyncSeqId);
        return;
    L120:
        if (this.mRequestedVisibleTypes == WindowInsets.Type.defaultVisible()) goto L122;
        pw.println(prefix + "Requested non-default-visibility types: " + WindowInsets.Type.toString(this.mRequestedVisibleTypes ^ WindowInsets.Type.defaultVisible()));
        goto L122
    L103:
        if (this.mWallpaperDisplayOffsetY == Integer.MIN_VALUE) goto L106;
    L95:
        if (this.mWallpaperYStep == (-1.0f)) goto L98;
    L90:
        if (this.mWallpaperY == (-1.0f)) goto L93;
    L85:
        if (this.mVScale == 1.0f) goto L88;
    L80:
        if (this.mYOffset == 0) goto L83;
    L71:
        if (this.mRemoveOnExit == true) goto L76;
        if (this.mDestroying == true) goto L76;
        if (this.mRemoved == false) goto L78;
    L49:
        if (this.mLayoutNeeded == false) goto L51;
    L34:
        if (this.mLegacyPolicyVisibilityAfterAnim == false) goto L45;
        if (this.mAppOpVisibility == false) goto L45;
        if (isParentWindowHidden() == true) goto L45;
        if (this.mPermanentlyHidden == true) goto L45;
        if (this.mForceHideNonSystemOverlayWindow == true) goto L45;
        if (this.mHiddenWhileSuspended == false) goto L47;
    L18:
        if (this.mIsWallpaper == true) goto L21;
        if (this.mIsFloatingLayer == false) goto L22;
    L13:
        if (this.mLayoutAttached == false) goto L16;
    L8:
        if (this.mRequestedHeight == this.mLastRequestedHeight) goto L11;
        goto L9
    }

    @Override // com.android.server.wm.ConfigurationContainer
    String getName() {
        return Integer.toHexString(System.identityHashCode(this)) + " " + getWindowTag();
    }

    CharSequence getWindowTag() {
        CharSequence tag = this.mAttrs.getTitle();
        if (tag == null) goto L7;
        if (tag.length() <= 0) goto L7;
        return tag;
    L7:
        return this.mAttrs.packageName;
    }

    public String toString() {
        CharSequence title = getWindowTag();
        if (this.mStringNameCache != null) goto L5;
    L8:
        this.mLastTitle = title;
        this.mWasExiting = this.mAnimatingExit;
        StringBuilder r1 = new StringBuilder();
        r1.append("Window{");
        r1.append(Integer.toHexString(System.identityHashCode(this)));
        r1.append(" u");
        r1.append(this.mShowUserId);
        r1.append(" ");
        r1.append(this.mLastTitle);
        if (this.mAnimatingExit == false) goto L11;
        String r2 = " EXITING}";
    L12:
        r1.append(r2);
        this.mStringNameCache = r1.toString();
    L14:
        return this.mStringNameCache;
    L11:
        r2 = "}";
        goto L12
    L5:
        if (this.mLastTitle != title) goto L8;
        if (this.mWasExiting == this.mAnimatingExit) goto L14;
        goto L8
    }

    boolean isChildWindow() {
        return this.mIsChildWindow;
    }

    boolean hideNonSystemOverlayWindowsWhenVisible() {
        if ((this.mAttrs.privateFlags & 524288) != 0) goto L5;
    L7:
        return false;
    L5:
        if (this.mSession.mCanHideNonSystemOverlayWindows == false) goto L7;
        return true;
    }

    WindowState getParentWindow() {
        if (this.mIsChildWindow == true) goto L7;
        return null;
    L7:
        return (WindowState) super.getParent();
    }

    WindowState getTopParentWindow() {
        WindowState current = this;
        WindowState topParent = current;
    L3:
        if (current == null) goto L9;
        if (current.mIsChildWindow == false) goto L9;
        current = current.getParentWindow();
        if (current == null) goto L3;
        topParent = current;
    L9:
        return topParent;
    }

    boolean isParentWindowHidden() {
        WindowState parent = getParentWindow();
        if (parent != null) goto L5;
    L7:
        return false;
    L5:
        if (parent.mHidden == false) goto L7;
        return true;
    }

    private boolean isParentWindowGoneForLayout() {
        WindowState parent = getParentWindow();
        if (parent != null) goto L5;
    L7:
        return false;
    L5:
        if (parent.isGoneForLayout() == false) goto L7;
        return true;
    }

    void requestUpdateWallpaperIfNeeded() {
        DisplayContent dc = getDisplayContent();
        if (dc != null) goto L5;
    L11:
        int i = this.mChildren.size() - 1;
    L12:
        if (i < 0) goto L15;
        WindowState c = (WindowState) this.mChildren.get(i);
        c.requestUpdateWallpaperIfNeeded();
        i = i - 1;
        goto L12
    L15:
        return;
    L5:
        if (this.mIsWallpaper == false) goto L9;
        if (this.mLastConfigReportedToClient == true) goto L9;
    L10:
        dc.pendingLayoutChanges |= 4;
        dc.setLayoutNeeded();
        this.mWmService.mWindowPlacerLocked.requestTraversal();
    L9:
        if (hasWallpaper() == false) goto L11;
        goto L10
    }

    float translateToWindowX(float x) {
        float winX = x - this.mWindowFrames.mFrame.left;
        if (this.mGlobalScale != 1.0f) goto L5;
        return winX;
    L5:
        return winX * this.mInvGlobalScale;
    }

    float translateToWindowY(float y) {
        float winY = y - this.mWindowFrames.mFrame.top;
        if (this.mGlobalScale != 1.0f) goto L5;
        return winY;
    L5:
        return winY * this.mInvGlobalScale;
    }

    int getRotationAnimationHint() {
        if (this.mActivityRecord != null) goto L5;
        return -1;
    L5:
        return this.mActivityRecord.mRotationAnimationHint;
    }

    boolean commitFinishDrawing(SurfaceControl.Transaction t) {
        boolean committed = this.mWinAnimator.commitFinishDrawingLocked();
        if (committed == false) goto L5;
        this.mWinAnimator.prepareSurfaceLocked(t);
    L5:
        int i = this.mChildren.size() - 1;
    L6:
        if (i < 0) goto L9;
        committed = committed | ((WindowState) this.mChildren.get(i)).commitFinishDrawing(t);
        i = i - 1;
        goto L6
    L9:
        if (getAnimationLeash() == null) goto L11;
        t.merge(getSyncTransaction());
    L11:
        return committed;
    }

    boolean performShowLocked() {
        if (showToCurrentUser() == false) goto L5;
        logPerformShow("performShow on ");
        int drawState = this.mWinAnimator.mDrawState;
        if (drawState == 4) goto L13;
        if (drawState == 3) goto L13;
    L18:
        IExtWindowState r4 = getExt();
        StringBuilder r5 = new StringBuilder();
        r5.append(getName());
        r5.append(": mDrawState=");
        r5.append(this.mWinAnimator.drawStateToString());
        r5.append(" readyForDisplay=");
        r5.append(isReadyForDisplay());
        r5.append(" starting=");
        if (this.mAttrs.type != 3) goto L21;
        boolean r6 = true;
    L22:
        r5.append(r6);
        r5.append(" during animation: policyVis=");
        r5.append(isVisibleByPolicy());
        r5.append(" parentHidden=");
        r5.append(isParentWindowHidden());
        r5.append(" tok.visibleRequested=");
        r5.append(this.mToken.isVisibleRequested());
        r5.append(" tok.visible=");
        r5.append(this.mToken.isVisible());
        r5.append(" animating=");
        r5.append(isAnimating(3));
        r4.tracePerformShowLocked(r5.toString());
        if (this.mWinAnimator.mDrawState == 3) goto L25;
    L41:
        return false;
    L25:
        if (isReadyForDisplay() == false) goto L41;
        logPerformShow("Showing ");
        this.mWmService.enableScreenIfNeededLocked();
        this.mWinAnimator.applyEnterAnimationLocked();
        this.mWinAnimator.mLastAlpha = -1.0f;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ANIM_enabled[1] == false) goto L30;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ANIM, -7413136364930452718L, 0, new Object[]{protoLogParam0});
    L30:
        this.mWinAnimator.mDrawState = 4;
        this.mWmService.scheduleAnimationLocked();
        if (this.mHidden == false) goto L40;
        this.mHidden = false;
        DisplayContent displayContent = getDisplayContent();
        int i = this.mChildren.size() - 1;
    L33:
        if (i < 0) goto L40;
        WindowState c = (WindowState) this.mChildren.get(i);
        if (c.mWinAnimator.mSurfaceControl == null) goto L39;
        c.performShowLocked();
        if (displayContent == null) goto L39;
        displayContent.setLayoutNeeded();
    L39:
        i = i - 1;
    L40:
        return true;
    L21:
        r6 = false;
    L13:
        if (this.mActivityRecord == null) goto L18;
        if (this.mAttrs.type == 3) goto L17;
        this.mActivityRecord.onFirstWindowDrawn(this);
        goto L18
    L17:
        this.mActivityRecord.onStartingWindowDrawn();
        goto L18
    L5:
        if (WindowManagerDebugConfig.DEBUG_VISIBILITY == false) goto L7;
        Slog.w(TAG, "hiding " + this + ", belonging to " + this.mOwnerUid);
    L7:
        clearPolicyVisibilityFlag(2);
        return false;
    }

    private void logPerformShow(String prefix) {
        if (WindowManagerDebugConfig.DEBUG_VISIBILITY == false) goto L5;
    L8:
        StringBuilder r0 = new StringBuilder();
        r0.append(prefix);
        r0.append(this);
        r0.append(": mDrawState=");
        r0.append(this.mWinAnimator.drawStateToString());
        r0.append(" readyForDisplay=");
        r0.append(isReadyForDisplay());
        r0.append(" starting=");
        boolean r3 = false;
        if (this.mAttrs.type != 3) goto L11;
        boolean r2 = true;
    L12:
        r0.append(r2);
        r0.append(" during animation: policyVis=");
        r0.append(isVisibleByPolicy());
        r0.append(" parentHidden=");
        r0.append(isParentWindowHidden());
        r0.append(" tok.visibleRequested=");
        if (this.mActivityRecord != null) goto L15;
    L17:
        boolean r4 = false;
    L18:
        r0.append(r4);
        r0.append(" tok.visible=");
        if (this.mActivityRecord != null) goto L21;
    L23:
        boolean r5 = false;
    L24:
        r0.append(r5);
        r0.append(" animating=");
        r0.append(isAnimating(3));
        r0.append(" tok animating=");
        if (this.mActivityRecord != null) goto L27;
    L30:
        r0.append(r3);
        r0.append(" Callers=");
        r0.append(Debug.getCallers(4));
        Slog.v(TAG, r0.toString());
        return;
    L27:
        if (this.mActivityRecord.isAnimating(3) == false) goto L30;
        r3 = true;
        goto L30
    L21:
        if (this.mActivityRecord.isVisible() == false) goto L23;
        r5 = true;
        goto L24
    L15:
        if (this.mActivityRecord.isVisibleRequested() == false) goto L17;
        r4 = true;
        goto L18
    L11:
        r2 = false;
        goto L12
    L5:
        if (WindowManagerDebugConfig.DEBUG_STARTING_WINDOW_VERBOSE == true) goto L7;
        return;
    L7:
        if (this.mAttrs.type == 3) goto L8;
    }

    WindowInfo getWindowInfo() {
        WindowInfo windowInfo = WindowInfo.obtain();
        windowInfo.displayId = getDisplayId();
        windowInfo.type = this.mAttrs.type;
        windowInfo.layer = this.mLayer;
        windowInfo.token = this.mClient.asBinder();
        if (this.mActivityRecord == null) goto L5;
        windowInfo.activityToken = this.mActivityRecord.token;
    L5:
        windowInfo.accessibilityIdOfAnchor = this.mAttrs.accessibilityIdOfAnchor;
        windowInfo.focused = isFocused();
        Task task = getTask();
        boolean r2 = false;
        if (task != null) goto L8;
    L10:
        boolean r4 = false;
    L11:
        windowInfo.inPictureInPicture = r4;
        if (task != null) goto L14;
        int r5 = -1;
    L15:
        windowInfo.taskId = r5;
        if ((this.mAttrs.flags & 262144) == 0) goto L18;
        r2 = true;
    L18:
        windowInfo.hasFlagWatchOutsideTouch = r2;
        if (this.mIsChildWindow == false) goto L21;
        windowInfo.parentToken = getParentWindow().mClient.asBinder();
    L21:
        int childCount = this.mChildren.size();
        if (childCount > 0) goto L24;
    L29:
        return windowInfo;
    L24:
        if (windowInfo.childTokens != null) goto L26;
        windowInfo.childTokens = new ArrayList(childCount);
    L26:
        int j = 0;
    L27:
        if (j >= childCount) goto L29;
        WindowState child = (WindowState) this.mChildren.get(j);
        windowInfo.childTokens.add(child.mClient.asBinder());
        j = j + 1;
        goto L27
    L14:
        r5 = task.mTaskId;
        goto L15
    L8:
        if (task.inPinnedWindowingMode() == false) goto L10;
        r4 = true;
        goto L11
    }

    @Override // com.android.server.wm.WindowContainer
    boolean forAllWindows(ToBooleanFunction<WindowState> callback, boolean traverseTopToBottom) {
        if (this.mChildren.isEmpty() == true) goto L5;
        if (traverseTopToBottom == false) goto L10;
        return forAllWindowTopToBottom(callback);
    L10:
        return forAllWindowBottomToTop(callback);
    L5:
        return applyInOrderWithImeWindows(callback, traverseTopToBottom);
    }

    private boolean forAllWindowBottomToTop(ToBooleanFunction<WindowState> callback) {
        int i = 0;
        int count = this.mChildren.size();
        Object r2 = this.mChildren.get(0);
    L3:
        WindowState child = (WindowState) r2;
        if (i >= count) goto L15;
        if (child.mSubLayer >= 0) goto L15;
        if (child.applyInOrderWithImeWindows(callback, false) == true) goto L9;
        i = i + 1;
        if (i >= count) goto L15;
        r2 = this.mChildren.get(i);
        goto L3
    L9:
        return true;
    L15:
        if (applyInOrderWithImeWindows(callback, false) == false) goto L17;
        return true;
    L17:
        if (i >= count) goto L25;
        if (child.applyInOrderWithImeWindows(callback, false) == true) goto L20;
        i = i + 1;
        if (i >= count) goto L25;
        child = (WindowState) this.mChildren.get(i);
        goto L17
    L20:
        return true;
    L25:
        return false;
    }

    @Override // com.android.server.wm.WindowContainer
    void updateAboveInsetsState(final InsetsState aboveInsetsState, SparseArray<InsetsSource> localInsetsSourcesFromParent, final ArraySet<WindowState> insetsChangedWindows) {
        final SparseArray<InsetsSource> mergedLocalInsetsSources = WindowContainer.createMergedSparseArray(localInsetsSourcesFromParent, this.mLocalInsetsSources);
        forAllWindows(new WindowState$$ExternalSyntheticLambda1(aboveInsetsState, insetsChangedWindows, mergedLocalInsetsSources), true);
    }

    private static /* synthetic */ void lambda$updateAboveInsetsState$2(InsetsState aboveInsetsState, ArraySet insetsChangedWindows, SparseArray mergedLocalInsetsSources, WindowState w) {
        if (w.mAboveInsetsState.equals(aboveInsetsState) == true) goto L6;
        w.mAboveInsetsState.set(aboveInsetsState);
        insetsChangedWindows.add(w);
    L6:
        if (mergedLocalInsetsSources.contentEquals(w.mMergedLocalInsetsSources) == true) goto L8;
        w.mMergedLocalInsetsSources = mergedLocalInsetsSources;
        insetsChangedWindows.add(w);
    L8:
        SparseArray<InsetsSourceProvider> providers = w.mInsetsSourceProviders;
        if (providers == null) goto L13;
        int i = providers.size() - 1;
    L11:
        if (i < 0) goto L15;
        aboveInsetsState.addSource(providers.valueAt(i).getSource());
        i = i - 1;
        goto L11
    L15:
        return;
    }

    private boolean forAllWindowTopToBottom(ToBooleanFunction<WindowState> callback) {
        int i = this.mChildren.size() - 1;
        WindowState child = (WindowState) this.mChildren.get(i);
    L3:
        if (i < 0) goto L14;
        if (child.mSubLayer < 0) goto L14;
        if (child.applyInOrderWithImeWindows(callback, true) == true) goto L8;
        i = i - 1;
        if (i < 0) goto L14;
        child = (WindowState) this.mChildren.get(i);
        goto L3
    L8:
        return true;
    L14:
        if (applyInOrderWithImeWindows(callback, true) == false) goto L16;
        return true;
    L16:
        if (i < 0) goto L24;
        if (child.applyInOrderWithImeWindows(callback, true) == true) goto L19;
        i = i - 1;
        if (i < 0) goto L33;
        child = (WindowState) this.mChildren.get(i);
        goto L16
    L33:
        return false;
    L19:
        return true;
    L24:
        return false;
    }

    private boolean applyImeWindowsIfNeeded(ToBooleanFunction<WindowState> callback, boolean traverseTopToBottom) {
        if (isImeLayeringTarget() == true) goto L7;
        return false;
    L7:
        return this.mDisplayContent.forAllImeWindows(callback, traverseTopToBottom);
    }

    private boolean applyInOrderWithImeWindows(ToBooleanFunction<WindowState> callback, boolean traverseTopToBottom) {
        if (traverseTopToBottom == false) goto L10;
        if (applyImeWindowsIfNeeded(callback, traverseTopToBottom) == false) goto L7;
    L8:
        return true;
    L7:
        if (callback.apply(this) == true) goto L8;
        return false;
    L10:
        if (callback.apply(this) == false) goto L12;
    L16:
        return true;
    L12:
        if (applyImeWindowsIfNeeded(callback, traverseTopToBottom) == true) goto L16;
        return false;
    }

    @Override // com.android.server.wm.WindowContainer
    WindowState getWindow(Predicate<WindowState> callback) {
        if (this.mChildren.isEmpty() == true) goto L5;
        int i = this.mChildren.size() - 1;
        WindowState child = (WindowState) this.mChildren.get(i);
    L9:
        if (i < 0) goto L20;
        if (child.mSubLayer < 0) goto L20;
        if (callback.test(child) == true) goto L14;
        i = i - 1;
        if (i < 0) goto L20;
        child = (WindowState) this.mChildren.get(i);
        goto L9
    L14:
        return child;
    L20:
        if (callback.test(this) == false) goto L22;
        return this;
    L22:
        if (i < 0) goto L30;
        if (callback.test(child) == true) goto L25;
        i = i - 1;
        if (i < 0) goto L30;
        child = (WindowState) this.mChildren.get(i);
        goto L22
    L25:
        return child;
    L30:
        return null;
    L5:
        if (callback.test(this) == true) goto L7;
        return null;
    L7:
        return this;
    }

    boolean isSelfOrAncestorWindowAnimatingExit() {
        WindowState window = this;
    L4:
        if (window.mAnimatingExit == true) goto L5;
        window = window.getParentWindow();
        if (window != null) goto L4;
        return false;
    L5:
        return true;
    }

    boolean isAnimationRunningSelfOrParent() {
        if (inTransitionSelfOrParent() == false) goto L5;
    L6:
        return true;
    L5:
        if (isAnimating(0, 16) == true) goto L6;
        return false;
    }

    private boolean shouldFinishAnimatingExit() {
        if (inTransition() == false) goto L9;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_APP_TRANSITIONS_enabled[0] == false) goto L7;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_APP_TRANSITIONS, 7624470121297688739L, 0, new Object[]{protoLogParam0});
    L7:
        return false;
    L9:
        if (this.mDisplayContent.okToAnimate() == true) goto L12;
        return true;
    L12:
        if (isAnimationRunningSelfOrParent() == false) goto L18;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_APP_TRANSITIONS_enabled[0] == false) goto L16;
        String protoLogParam1 = String.valueOf(this);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_APP_TRANSITIONS, 810267895099109466L, 0, new Object[]{protoLogParam1});
    L16:
        return false;
    L18:
        if (this.mDisplayContent.mWallpaperController.isWallpaperTarget(this) == true) goto L20;
        return true;
    L20:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_APP_TRANSITIONS_enabled[0] == false) goto L22;
        String protoLogParam2 = String.valueOf(this);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_APP_TRANSITIONS, -1760879391350377377L, 0, new Object[]{protoLogParam2});
    L22:
        return false;
    }

    void cleanupAnimatingExitWindow() {
        if (this.mAnimatingExit == true) goto L5;
        return;
    L5:
        if (shouldFinishAnimatingExit() == true) goto L7;
        return;
    L7:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_APP_TRANSITIONS_enabled[3] == false) goto L9;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.w(WmProtoLogGroups.WM_DEBUG_APP_TRANSITIONS, 272960397873328729L, 0, new Object[]{protoLogParam0});
    L9:
        onExitAnimationDone();
    }

    void onExitAnimationDone() {
        if (ProtoLogImpl_798997914.isEnabled(WmProtoLogGroups.WM_DEBUG_ANIM, LogLevel.VERBOSE) == false) goto L11;
        AnimationAdapter animationAdapter = this.mSurfaceAnimator.getAnimation();
        StringWriter sw = new StringWriter();
        if (animationAdapter == null) goto L8;
        PrintWriter pw = new PrintWriter(sw);
        animationAdapter.dump(pw, "");
    L8:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ANIM_enabled[1] == false) goto L11;
        String protoLogParam0 = String.valueOf(this);
        boolean protoLogParam1 = this.mAnimatingExit;
        boolean protoLogParam2 = this.mRemoveOnExit;
        boolean protoLogParam3 = isAnimating();
        String protoLogParam4 = String.valueOf(sw);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ANIM, -1007526574020149845L, AudioChannelMask.IN_6, new Object[]{protoLogParam0, Boolean.valueOf(protoLogParam1), Boolean.valueOf(protoLogParam2), Boolean.valueOf(protoLogParam3), protoLogParam4});
    L11:
        if (this.mChildren.isEmpty() == true) goto L16;
        ArrayList<WindowState> childWindows = new ArrayList(this.mChildren);
        int i = childWindows.size() - 1;
    L13:
        if (i < 0) goto L16;
        childWindows.get(i).onExitAnimationDone();
        i = i - 1;
    L16:
        if (this.mWinAnimator.mEnteringAnimation == false) goto L23;
        this.mWinAnimator.mEnteringAnimation = false;
        this.mWmService.requestTraversal();
        if (this.mActivityRecord != null) goto L23;
        this.mClient.dispatchWindowShown();     // Catch: RemoteException -> L21
    L23:
        if (isAnimating() == false) goto L26;
        return;
    L26:
        if (isSelfOrAncestorWindowAnimatingExit() == true) goto L29;
        return;
    L29:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ADD_REMOVE_enabled[1] == false) goto L31;
        String protoLogParam5 = String.valueOf(this);
        boolean protoLogParam6 = this.mRemoveOnExit;
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ADD_REMOVE, 1738645946553610841L, 12, new Object[]{protoLogParam5, Boolean.valueOf(protoLogParam6)});
    L31:
        this.mDestroying = true;
        boolean hasSurface = this.mWinAnimator.hasSurface();
        this.mWinAnimator.hide(getPendingTransaction(), "onExitAnimationDone");
        if (this.mActivityRecord != null) goto L34;
        if (hasSurface == false) goto L39;
        this.mWmService.mDestroySurface.add(this);
    L39:
        this.mAnimatingExit = false;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ANIM_enabled[0] == false) goto L42;
        String protoLogParam7 = String.valueOf(this);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_ANIM, -7737516306844862315L, 0, new Object[]{protoLogParam7});
    L42:
        getDisplayContent().mWallpaperController.hideWallpapers(this);
        return;
    L34:
        if (this.mAttrs.type != 1) goto L36;
        this.mActivityRecord.destroySurfaces();
        goto L39
    L36:
        destroySurface(false, this.mActivityRecord.mAppStopped);
        goto L39
    }

    @Override // com.android.server.wm.WindowContainer
    boolean handleCompleteDeferredRemoval() {
        if (this.mRemoveOnExit == false) goto L8;
        if (isSelfAnimating(0, 16) == true) goto L8;
        this.mRemoveOnExit = false;
        removeImmediately();
    L8:
        return super.handleCompleteDeferredRemoval();
    }

    public boolean isRtl() {
        if (getConfiguration().getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    void updateReportedVisibility(UpdateReportedVisibilityResults results) {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L5;
        WindowState c = (WindowState) this.mChildren.get(i);
        c.updateReportedVisibility(results);
        i = i - 1;
        goto L3
    L5:
        int i2 = this.mViewVisibility;
        if (i2 == 0) goto L8;
        return;
    L8:
        if (this.mAttrs.type != 3) goto L10;
        return;
    L10:
        if (this.mDestroying == false) goto L13;
        return;
    L13:
        if (WindowManagerDebugConfig.DEBUG_VISIBILITY == false) goto L23;
        Slog.v(TAG, "Win " + this + ": isDrawn=" + isDrawn() + ", animating=" + isAnimating(3));
        if (isDrawn() == true) goto L23;
        StringBuilder r0 = new StringBuilder();
        r0.append("Not displayed: s=");
        r0.append(this.mWinAnimator.mSurfaceControl);
        r0.append(" pv=");
        r0.append(isVisibleByPolicy());
        r0.append(" mDrawState=");
        r0.append(this.mWinAnimator.mDrawState);
        r0.append(" ph=");
        r0.append(isParentWindowHidden());
        r0.append(" th=");
        if (this.mActivityRecord != null) goto L19;
    L21:
        boolean r5 = false;
    L22:
        r0.append(r5);
        r0.append(" a=");
        r0.append(isAnimating(3));
        Slog.v(TAG, r0.toString());
        goto L23
    L19:
        if (this.mActivityRecord.isVisibleRequested() == false) goto L21;
        r5 = true;
    L23:
        results.numInteresting++;
        if (isDrawn() == false) goto L30;
        results.numDrawn++;
        if (isAnimating(3) == true) goto L28;
        results.numVisible++;
    L28:
        results.nowGone = false;
        return;
    L30:
        if (isAnimating(3) == false) goto L36;
        results.nowGone = false;
        return;
    }

    boolean surfaceInsetsChanging() {
        return !this.mLastSurfaceInsets.equals(this.mAttrs.surfaceInsets);
    }

    int relayoutVisibleWindow(int result) {
        boolean wasVisible = isVisible();
        if (wasVisible == true) goto L5;
    L8:
        int r3 = 1;
    L9:
        int result2 = result | r3;
        if (this.mAnimatingExit == false) goto L18;
        Slog.d(TAG, "relayoutVisibleWindow: " + this + " mAnimatingExit=true, mRemoveOnExit=" + this.mRemoveOnExit + ", mDestroying=" + this.mDestroying);
        this.mAnimatingExit = false;
        if (isAnimating() == false) goto L15;
        cancelAnimation();
    L15:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ANIM_enabled[0] == false) goto L18;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_ANIM, -5202247309108694583L, 0, new Object[]{protoLogParam0});
    L18:
        if (this.mDestroying == false) goto L20;
        this.mDestroying = false;
        this.mWmService.mDestroySurface.remove(this);
    L20:
        if (wasVisible == true) goto L22;
        this.mWinAnimator.mEnterAnimationPending = true;
    L22:
        this.mWinAnimator.mEnteringAnimation = true;
        Trace.traceBegin(32, "prepareToDisplay");
        prepareWindowToDisplayDuringRelayout(wasVisible);     // Catch: Throwable -> L26
        Trace.traceEnd(32);
        return result2;
    L26:
        th = move-exception;
        Trace.traceEnd(32);
        throw th;
    L5:
        if (isDrawn() == false) goto L8;
        r3 = 0;
        goto L9
    }

    boolean isLaidOut() {
        if (this.mLayoutSeq == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    void updateLastFrames() {
        this.mWindowFrames.mLastFrame.set(this.mWindowFrames.mFrame);
        this.mWindowFrames.mLastRelFrame.set(this.mWindowFrames.mRelFrame);
    }

    void onResizeHandled() {
        this.mWindowFrames.onResizeHandled();
    }

    @Override // com.android.server.wm.WindowContainer
    protected boolean isSelfAnimating(int flags, int typesToCheck) {
        if (this.mControllableInsetProvider == null) goto L7;
        return false;
    L7:
        return super.isSelfAnimating(flags, typesToCheck);
    }

    void startAnimation(Animation anim) {
        if (this.mControllableInsetProvider == null) goto L5;
        return;
    L5:
        DisplayInfo displayInfo = getDisplayInfo();
        anim.initialize(this.mWindowFrames.mFrame.width(), this.mWindowFrames.mFrame.height(), displayInfo.appWidth, displayInfo.appHeight);
        anim.restrictDuration(JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY);
        anim.scaleCurrentDuration(this.mWmService.getWindowAnimationScaleLocked());
        Point position = new Point();
        transformFrameToSurfacePosition(this.mWindowFrames.mFrame.left, this.mWindowFrames.mFrame.top, position);
        AnimationAdapter adapter = new LocalAnimationAdapter(new WindowAnimationSpec(anim, position, false, 0.0f), this.mWmService.mSurfaceAnimationRunner);
        if (this.mActivityRecord == null) goto L8;
        SurfaceControl.Transaction t = getSyncTransaction();
    L9:
        startAnimation(t, adapter);
        commitPendingTransaction();
        return;
    L8:
        t = getPendingTransaction();
        goto L9
    }

    private void startMoveAnimation(int left, int top) {
        if (this.mControllableInsetProvider == null) goto L6;
        return;
    L6:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ANIM_enabled[1] == false) goto L8;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ANIM, 6291563604478341956L, 0, new Object[]{protoLogParam0});
    L8:
        Point oldPosition = new Point();
        Point newPosition = new Point();
        if (getExt().computeMoveAnimationOldPosition(oldPosition) == true) goto L11;
        transformFrameToSurfacePosition(this.mWindowFrames.mLastFrame.left, this.mWindowFrames.mLastFrame.top, oldPosition);
    L11:
        transformFrameToSurfacePosition(left, top, newPosition);
        AnimationAdapter adapter = new LocalAnimationAdapter(new MoveAnimationSpec(this, oldPosition.x, oldPosition.y, newPosition.x, newPosition.y, null), this.mWmService.mSurfaceAnimationRunner);
        startAnimation(getPendingTransaction(), adapter);
    }

    private void startAnimation(SurfaceControl.Transaction t, AnimationAdapter adapter) {
        startAnimation(t, adapter, this.mWinAnimator.mLastHidden, 16);
    }

    @Override // com.android.server.wm.WindowContainer
    protected void onAnimationFinished(int type, AnimationAdapter anim) {
        super.onAnimationFinished(type, anim);
        this.mWinAnimator.onAnimationFinished();
    }

    void getTransformationMatrix(float[] float9, Matrix outMatrix) {
        float9[0] = this.mGlobalScale;
        float9[3] = 0.0f;
        float9[1] = 0.0f;
        float9[4] = this.mGlobalScale;
        transformSurfaceInsetsPosition(this.mTmpPoint, this.mAttrs.surfaceInsets);
        int x = this.mSurfacePosition.x + this.mTmpPoint.x;
        int y = this.mSurfacePosition.y + this.mTmpPoint.y;
        WindowContainer parent = getParent();
        if (isChildWindow() == false) goto L6;
        WindowState parentWindow = getParentWindow();
        x = x + (parentWindow.mWindowFrames.mFrame.left - parentWindow.mAttrs.surfaceInsets.left);
        y = y + (parentWindow.mWindowFrames.mFrame.top - parentWindow.mAttrs.surfaceInsets.top);
    L8:
        float9[2] = x;
        float9[5] = y;
        float9[6] = 0.0f;
        float9[7] = 0.0f;
        float9[8] = 1.0f;
        outMatrix.setValues(float9);
        return;
    L6:
        if (parent == null) goto L8;
        Rect parentBounds = parent.getBounds();
        x = x + parentBounds.left;
        y = y + parentBounds.top;
        goto L8
    }

    @Override // com.android.server.wm.WindowContainer
    boolean shouldMagnify() {
        if (this.mAttrs.type != 2039) goto L5;
    L20:
        return false;
    L5:
        if (this.mAttrs.type == 2011) goto L20;
        if (this.mAttrs.type == 2012) goto L20;
        if (this.mAttrs.type == 2027) goto L20;
        if (this.mAttrs.type == 2019) goto L20;
        if (this.mAttrs.type == 2024) goto L20;
        if ((this.mAttrs.privateFlags & 4194304) == 0) goto L18;
        return false;
    L18:
        return true;
    }

    private boolean isStartingWindowAssociatedToTask() {
        if (this.mStartingData != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mStartingData.mAssociatedTask == null) goto L7;
        return true;
    }

    private void applyDims() {
        Task task = getTask();
        if ((this.mAttrs.flags & 2) != 0) goto L7;
        if (shouldDrawBlurBehind() == true) goto L7;
        return;
    L7:
        if (this.mWinAnimator.getShown() == true) goto L9;
        return;
    L9:
        if (this.mActivityRecord == null) goto L13;
        if (this.mActivityRecord.isSurfaceShowing() == true) goto L13;
        return;
    L13:
        if (this.mTransitionController.getExt().getTransitionModeInTransition(this) != 2) goto L15;
        return;
    L15:
        if (this.mHidden == false) goto L17;
        return;
    L17:
        if (this.mTransitionController.canApplyDim(task) == false) goto L43;
        this.mIsDimming = true;
        if ((this.mAttrs.flags & 2) == 0) goto L21;
        float dimAmount = this.mAttrs.dimAmount;
    L23:
        if (shouldDrawBlurBehind() == false) goto L25;
        int blurRadius = this.mAttrs.getBlurBehindRadius();
    L26:
        WindowContainer<?> geometryParent = getDimParent();
        Dimmer dimmer = getDimController();
        if (dimmer != null) goto L33;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_DIMMER_enabled[4] == false) goto L37;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.e(WmProtoLogGroups.WM_DEBUG_DIMMER, -3219193943298394827L, 0, new Object[]{protoLogParam0});
        return;
    L37:
        return;
    L33:
        if (isVisibleNow() == false) goto L35;
        dimmer.adjustAppearance(this, dimAmount, blurRadius);
    L35:
        dimmer.adjustPosition(geometryParent, this);
        return;
    L25:
        blurRadius = 0;
        goto L26
    L21:
        dimAmount = 0.0f;
        goto L23
    }

    private Dimmer getDimController() {
        Task task = getTask();
        if (task != null) goto L5;
        RootDisplayArea displayArea = getRootDisplayArea();
        if (displayArea != null) goto L9;
        return null;
    L9:
        return displayArea.getDimmer();
    L5:
        return task.mDimmer;
    }

    private WindowContainer<?> getDimParent() {
        Task task = getTask();
        if (task == null) goto L8;
        if (task.isSuitableForDimming() == false) goto L8;
        return task;
    L8:
        return getRootDisplayArea();
    }

    boolean shouldDrawBlurBehind() {
        if ((this.mAttrs.flags & 4) != 0) goto L5;
    L7:
        return false;
    L5:
        if (this.mWmService.mBlurController.getBlurEnabled() == false) goto L7;
        return true;
    }

    void updateFrameRateSelectionPriorityIfNeeded() {
        RefreshRatePolicy refreshRatePolicy = getDisplayContent().getDisplayPolicy().getRefreshRatePolicy();
        int priority = refreshRatePolicy.calculatePriority(this);
        if (this.mFrameRateSelectionPriority == priority) goto L5;
        this.mFrameRateSelectionPriority = priority;
        getPendingTransaction().setFrameRateSelectionPriority(this.mSurfaceControl, this.mFrameRateSelectionPriority);
    L5:
        boolean voteChanged = refreshRatePolicy.updateFrameRateVote(this);
        if (voteChanged == false) goto L9;
        getPendingTransaction().setFrameRate(this.mSurfaceControl, this.mFrameRateVote.mRefreshRate, this.mFrameRateVote.mCompatibility, 1).setFrameRateSelectionStrategy(this.mSurfaceControl, this.mFrameRateVote.mSelectionStrategy);
        return;
    }

    private void updateScaleIfNeeded() {
        if (isVisibleRequested() == false) goto L5;
    L9:
        float globalScale = this.mGlobalScale;
        WindowState parent = getParentWindow();
        if (parent == null) goto L12;
        globalScale = globalScale * parent.mInvGlobalScale;
    L12:
        float newHScale = (this.mHScale * globalScale) * this.mWallpaperScale;
        float newVScale = (this.mVScale * globalScale) * this.mWallpaperScale;
        if (this.mLastHScale == newHScale) goto L15;
    L16:
        getSyncTransaction().setMatrix(this.mSurfaceControl, newHScale, 0.0f, 0.0f, newVScale);
        this.mLastHScale = newHScale;
        this.mLastVScale = newVScale;
        return;
    L15:
        if (this.mLastVScale != newVScale) goto L16;
        return;
    L5:
        if (this.mIsWallpaper == true) goto L7;
        return;
    L7:
        if (this.mToken.isVisible() == true) goto L9;
    }

    @Override // com.android.server.wm.WindowContainer
    void prepareSurfaces() {
        this.mIsDimming = false;
        if (this.mHasSurface == false) goto L17;
        updateSurfacePositionNonOrganized();
        updateFrameRateSelectionPriorityIfNeeded();
        updateScaleIfNeeded();
        if (this.mAttrs.type == 3) goto L9;
        if (this.mAttrs.type == 1) goto L9;
    L15:
        this.mWinAnimator.prepareSurfaceLocked(getSyncTransaction());
    L16:
        applyDims();
    L9:
        if (this.mAttrs.isFullscreen() == false) goto L15;
        WindowStateAnimator r0 = this.mWinAnimator;
        if (this.mActivityRecord == null) goto L13;
        SurfaceControl.Transaction r1 = getPendingTransaction();
    L14:
        r0.prepareSurfaceLocked(r1);
        goto L16
    L13:
        r1 = getSyncTransaction();
    L17:
        super.prepareSurfaces();
    }

    @Override // com.android.server.wm.WindowContainer
    void adjustDims() {
        applyDims();
        super.adjustDims();
    }

    void updateSurfacePositionIfNeeded() {
        if (this.mWindowFrames.mRelFrame.top == this.mWindowFrames.mLastRelFrame.top) goto L5;
    L7:
        updateSurfacePosition(getSyncTransaction());
        return;
    L5:
        if (this.mWindowFrames.mRelFrame.left != this.mWindowFrames.mLastRelFrame.left) goto L7;
    }

    @Override // com.android.server.wm.WindowContainer
    void updateSurfacePosition(SurfaceControl.Transaction t) {
        if (this.mSurfaceControl != null) goto L5;
        return;
    L5:
        if (this.mIsSurfacePositionPaused == false) goto L8;
        return;
    L8:
        if (this.mActivityRecord == null) goto L13;
        if (this.mActivityRecord.isConfigurationDispatchPaused() == false) goto L13;
        return;
    L13:
        if (this.mWmService.mWindowPlacerLocked.isLayoutDeferred() == true) goto L17;
        if (isGoneForLayout() == true) goto L17;
    L19:
        boolean isLetterboxedAndRelaunching = false;
        this.mSurfacePlacementNeeded = false;
        transformFrameToSurfacePosition(this.mWindowFrames.mFrame.left, this.mWindowFrames.mFrame.top, this.mSurfacePosition);
        if (this.mWallpaperScale == 1.0f) goto L22;
        Rect bounds = getParentFrame();
        Matrix matrix = this.mTmpMatrix;
        matrix.setTranslate(this.mXOffset, this.mYOffset);
        matrix.postScale(this.mWallpaperScale, this.mWallpaperScale, bounds.exactCenterX(), bounds.exactCenterY());
        matrix.getValues(this.mTmpMatrixArray);
        this.mSurfacePosition.offset(Math.round(this.mTmpMatrixArray[2]), Math.round(this.mTmpMatrixArray[5]));
    L23:
        AsyncRotationController asyncRotationController = this.mDisplayContent.getAsyncRotationController();
        if (asyncRotationController == null) goto L29;
        if (asyncRotationController.hasSeamlessOperation(this.mToken) == false) goto L29;
        return;
    L29:
        if (this.mSurfaceAnimator.hasLeash() == false) goto L31;
        return;
    L31:
        if (this.mLastSurfacePosition.equals(this.mSurfacePosition) == true) goto L70;
        boolean frameSizeChanged = this.mWindowFrames.isFrameSizeChangeReported();
        boolean surfaceInsetsChanged = surfaceInsetsChanging();
        if (frameSizeChanged == true) goto L37;
        if (surfaceInsetsChanged == true) goto L37;
        boolean surfaceSizeChanged = false;
    L38:
        this.mLastSurfacePosition.set(this.mSurfacePosition.x, this.mSurfacePosition.y);
        if (surfaceInsetsChanged == false) goto L42;
        this.mLastSurfaceInsets.set(this.mAttrs.surfaceInsets);
    L42:
        if (surfaceSizeChanged == true) goto L44;
    L52:
        boolean surfaceResizedWithoutMoveAnimation = false;
    L53:
        ActivityRecord activityRecord = getActivityRecord();
        if (activityRecord != null) goto L56;
    L62:
        if (surfaceResizedWithoutMoveAnimation == true) goto L66;
        if (isLetterboxedAndRelaunching == true) goto L66;
        this.mSetSurfacePositionConsumer.accept(t);
        return;
    L66:
        applyWithNextDraw(this.mSetSurfacePositionConsumer);
        return;
    L56:
        if (activityRecord.areBoundsLetterboxed() == false) goto L62;
        if (activityRecord.mAppCompatController.getOrientationOverrides().getIsRelaunchingAfterRequestedOrientationChanged() == false) goto L62;
        isLetterboxedAndRelaunching = true;
        goto L62
    L44:
        if (this.mWinAnimator.getShown() == false) goto L52;
        if (canPlayMoveAnimation() == true) goto L52;
        if (okToDisplay() == false) goto L52;
        if (this.mSyncState != 0) goto L52;
        surfaceResizedWithoutMoveAnimation = true;
    L37:
        surfaceSizeChanged = true;
        goto L38
    L70:
        return;
    L22:
        this.mSurfacePosition.offset(this.mXOffset, this.mYOffset);
    L17:
        if (this.mSurfacePlacementNeeded == true) goto L19;
    }

    @Override // com.android.server.wm.WindowContainer
    void transformFrameToSurfacePosition(int left, int top, Point outPoint) {
        outPoint.set(left, top);
        WindowContainer parentWindowContainer = getParent();
        if (isChildWindow() == false) goto L9;
        WindowState parent = getParentWindow();
        outPoint.offset(-parent.mWindowFrames.mFrame.left, -parent.mWindowFrames.mFrame.top);
        if (this.mInvGlobalScale == 1.0f) goto L7;
        outPoint.x = (int) ((outPoint.x * this.mInvGlobalScale) + 0.5f);
        outPoint.y = (int) ((outPoint.y * this.mInvGlobalScale) + 0.5f);
    L7:
        transformSurfaceInsetsPosition(this.mTmpPoint, parent.mAttrs.surfaceInsets);
        outPoint.offset(this.mTmpPoint.x, this.mTmpPoint.y);
    L15:
        transformSurfaceInsetsPosition(this.mTmpPoint, this.mAttrs.surfaceInsets);
        outPoint.offset(-this.mTmpPoint.x, -this.mTmpPoint.y);
        outPoint.y += this.mSurfaceTranslationY;
        return;
    L9:
        if (parentWindowContainer == null) goto L15;
        if (isStartingWindowAssociatedToTask() == false) goto L13;
        Rect parentBounds = this.mStartingData.mAssociatedTask.getBounds();
    L14:
        outPoint.offset(-parentBounds.left, -parentBounds.top);
        goto L15
    L13:
        parentBounds = parentWindowContainer.getBounds();
        goto L14
    }

    private void transformSurfaceInsetsPosition(Point outPos, Rect surfaceInsets) {
        if (this.mGlobalScale != 1.0f) goto L5;
    L9:
        outPos.x = surfaceInsets.left;
        outPos.y = surfaceInsets.top;
        return;
    L5:
        if (this.mIsChildWindow == true) goto L9;
        outPos.x = (int) ((surfaceInsets.left * this.mGlobalScale) + 0.5f);
        outPos.y = (int) ((surfaceInsets.top * this.mGlobalScale) + 0.5f);
    }

    boolean needsRelativeLayeringToIme() {
        if (this.mDisplayContent.shouldImeAttachedToApp() == false) goto L6;
        return false;
    L6:
        if (getDisplayContent().getImeContainer().isVisible() == true) goto L9;
        return false;
    L9:
        if (isChildWindow() == false) goto L14;
        if (getParentWindow().isImeLayeringTarget() == false) goto L31;
        return true;
    L31:
        if ((this.mAttrs.flags & 131080) == 131072) goto L33;
    L46:
        return false;
    L33:
        if (isTrustedOverlay() == false) goto L46;
        if (canAddInternalSystemWindow() == false) goto L46;
        if (this.mExt.cannotRelativeToIme() == false) goto L39;
        return false;
    L39:
        WindowState imeTarget = getImeLayeringTarget();
        if (imeTarget == null) goto L53;
        if (imeTarget != this) goto L43;
        return false;
    L43:
        if (imeTarget.compareTo(this) <= 0) goto L45;
        return false;
    L45:
        return true;
    L53:
        return false;
    L14:
        if (this.mActivityRecord == null) goto L31;
        WindowState imeTarget2 = getImeLayeringTarget();
        if (imeTarget2 == null) goto L47;
        if (imeTarget2 != this) goto L19;
        return false;
    L19:
        if (imeTarget2.mToken == this.mToken) goto L21;
        return false;
    L21:
        if (this.mAttrs.type != 3) goto L23;
        return false;
    L23:
        if (getParent() != null) goto L25;
        return false;
    L25:
        if (imeTarget2.compareTo(this) <= 0) goto L29;
        return false;
    L29:
        return true;
    L47:
        return false;
    }

    @Override // com.android.server.wm.InputTarget
    public InsetsControlTarget getImeControlTarget() {
        return getDisplayContent().getImeHostOrFallback(this);
    }

    @Override // com.android.server.wm.WindowContainer
    void assignLayer(SurfaceControl.Transaction t, int layer) {
        if (this.mStartingData == null) goto L10;
        if (this.mSyncState == 0) goto L7;
        t = getSyncTransaction();
    L7:
        t.setLayer(this.mSurfaceControl, Integer.MAX_VALUE);
        return;
    L10:
        if (needsRelativeLayeringToIme() == false) goto L14;
        getDisplayContent().assignRelativeLayerForImeTargetChild(t, this);
        return;
    L14:
        if (this.mAttrs.type == 2998) goto L16;
    L27:
        super.assignLayer(t, layer);
        this.mExt.onAssignLayer(t);
        getObricExt().onAssignLayer(t);
        return;
    L16:
        if (this.mWmService.mPolicy.isKeyguardShowingAndNotOccluded() == false) goto L27;
        if (this.mSurfaceControl == null) goto L27;
        if (this.mDisplayContent == null) goto L27;
        if (this.mDisplayContent.getDisplayPolicy().getNotificationShade() == null) goto L27;
        if (this.mDisplayContent.getDisplayPolicy().getNotificationShade().getSurfaceControl() == null) goto L27;
        assignRelativeLayer(t, this.mDisplayContent.getDisplayPolicy().getNotificationShade().getSurfaceControl(), 1);
    }

    boolean isDimming() {
        return this.mIsDimming;
    }

    @Override // com.android.server.wm.WindowContainer
    protected void reparentSurfaceControl(SurfaceControl.Transaction t, SurfaceControl newParent) {
        if (isStartingWindowAssociatedToTask() == false) goto L5;
        return;
    L5:
        super.reparentSurfaceControl(t, newParent);
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public SurfaceControl getAnimationLeashParent() {
        if (this.mActivityRecord == null) goto L11;
        if (this.mActivityRecord.hasFixedRotationTransform() == true) goto L11;
        if (isStartingWindowAssociatedToTask() == false) goto L11;
        return this.mStartingData.mAssociatedTask.mSurfaceControl;
    L11:
        return super.getAnimationLeashParent();
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public void onAnimationLeashCreated(SurfaceControl.Transaction t, SurfaceControl leash) {
        super.onAnimationLeashCreated(t, leash);
        if (isStartingWindowAssociatedToTask() == false) goto L6;
        t.setLayer(leash, Integer.MAX_VALUE);
        return;
    }

    @Override // com.android.server.wm.WindowContainer
    public void assignChildLayers(SurfaceControl.Transaction t) {
        int layer = 2;
        int i = 0;
    L4:
        if (i >= this.mChildren.size()) goto L20;
        WindowState w = (WindowState) this.mChildren.get(i);
        if (w.mAttrs.type != 1001) goto L12;
        if (this.mWinAnimator.hasSurface() == false) goto L10;
        w.assignRelativeLayer(t, this.mWinAnimator.mSurfaceControl, -2);
    L18:
        w.assignChildLayers(t);
        layer = layer + 1;
        i = i + 1;
        goto L4
    L10:
        w.assignLayer(t, -2);
        goto L18
    L12:
        if (w.mAttrs.type == 1004) goto L14;
        w.assignLayer(t, layer);
        goto L18
    L14:
        if (this.mWinAnimator.hasSurface() == false) goto L16;
        w.assignRelativeLayer(t, this.mWinAnimator.mSurfaceControl, -1);
        goto L18
    L16:
        w.assignLayer(t, -1);
        goto L18
    }

    void updateTapExcludeRegion(Region region) {
        DisplayContent currentDisplay = getDisplayContent();
        if (currentDisplay == null) goto L13;
        if (region != null) goto L6;
    L9:
        this.mTapExcludeRegion.setEmpty();
    L10:
        currentDisplay.getInputMonitor().updateInputWindowsLw(true);
        return;
    L6:
        if (region.isEmpty() == true) goto L9;
        this.mTapExcludeRegion.set(region);
        goto L10
    L13:
        throw new IllegalStateException("Trying to update window not attached to any display.");
    }

    void getTapExcludeRegion(Region outRegion) {
        this.mTmpRect.set(this.mWindowFrames.mFrame);
        this.mTmpRect.offsetTo(0, 0);
        outRegion.set(this.mTapExcludeRegion);
        outRegion.op(this.mTmpRect, Region.Op.INTERSECT);
        outRegion.translate(this.mWindowFrames.mFrame.left, this.mWindowFrames.mFrame.top);
    }

    boolean isImeLayeringTarget() {
        if (getDisplayContent().getImeTarget(0) != this) goto L6;
        return true;
    L6:
        return false;
    }

    boolean isImeOverlayLayeringTarget() {
        if (isImeLayeringTarget() == true) goto L5;
    L7:
        return false;
    L5:
        if ((this.mAttrs.flags & 131080) == 0) goto L7;
        return true;
    }

    WindowState getImeLayeringTarget() {
        InsetsControlTarget target = getDisplayContent().getImeTarget(0);
        if (target != null) goto L7;
        return null;
    L7:
        return target.getWindow();
    }

    WindowState getImeInputTarget() {
        InputTarget target = this.mDisplayContent.getImeInputTarget();
        if (target != null) goto L7;
        return null;
    L7:
        return target.getWindowState();
    }

    void forceReportingResized() {
        this.mWindowFrames.forceReportingResized();
    }

    WindowFrames getWindowFrames() {
        return this.mWindowFrames;
    }

    void resetContentChanged() {
        this.mWindowFrames.setContentChanged(false);
    }

    KeyInterceptionInfo getKeyInterceptionInfo() {
        if (this.mKeyInterceptionInfo != null) goto L5;
    L12:
        this.mKeyInterceptionInfo = new KeyInterceptionInfo(this.mAttrs.type, this.mAttrs.privateFlags, getWindowTag().toString(), getOwningUid());
    L14:
        return this.mKeyInterceptionInfo;
    L5:
        if (this.mKeyInterceptionInfo.layoutParamsPrivateFlags != this.mAttrs.privateFlags) goto L12;
        if (this.mKeyInterceptionInfo.layoutParamsType != this.mAttrs.type) goto L12;
        if (this.mKeyInterceptionInfo.windowTitle != getWindowTag()) goto L12;
        if (this.mKeyInterceptionInfo.windowOwnerUid == getOwningUid()) goto L14;
        goto L12
    }

    @Override // com.android.server.wm.WindowContainer
    void getAnimationFrames(Rect outFrame, Rect outInsets, Rect outStableInsets, Rect outSurfaceInsets) {
        if (inFreeformWindowingMode() == false) goto L6;
        outFrame.set(getFrame());
    L12:
        outSurfaceInsets.set(this.mAttrs.surfaceInsets);
        InsetsState state = getInsetsStateWithVisibilityOverride();
        outInsets.set(state.calculateInsets(outFrame, WindowInsets.Type.systemBars(), false).toRect());
        outStableInsets.set(state.calculateInsets(outFrame, WindowInsets.Type.systemBars(), true).toRect());
        return;
    L6:
        if (areAppWindowBoundsLetterboxed() == false) goto L8;
    L11:
        outFrame.set(getTask().getBounds());
        goto L12
    L8:
        if (this.mToken.isFixedRotationTransforming() == true) goto L11;
        outFrame.set(getParentFrame());
        goto L12
    }

    void setViewVisibility(int viewVisibility) {
        this.mViewVisibility = viewVisibility;
    }

    SurfaceControl getClientViewRootSurface() {
        return this.mWinAnimator.mSurfaceControl;
    }

    private void dropBufferFrom(SurfaceControl.Transaction t) {
        SurfaceControl viewSurface = getClientViewRootSurface();
        if (viewSurface != null) goto L5;
        return;
    L5:
        t.unsetBuffer(viewSurface);
    }

    @Override // com.android.server.wm.WindowContainer
    protected boolean shouldUpdateSyncOnReparent() {
        if (this.mSyncState != 0) goto L5;
    L7:
        return false;
    L5:
        if (this.mLastConfigReportedToClient == true) goto L7;
        return true;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean prepareSync() {
        if (this.mDrawHandlers.isEmpty() == true) goto L6;
        Slog.w(TAG, "prepareSync with mDrawHandlers, " + this + ", " + Debug.getCallers(8));
    L6:
        if (super.prepareSync() == true) goto L9;
        return false;
    L9:
        if (this.mIsWallpaper == false) goto L12;
        return true;
    L12:
        if (this.mActivityRecord != null) goto L14;
    L20:
        this.mSyncState = 1;
        if (this.mPrepareSyncSeqId > 0) goto L23;
    L26:
        this.mSyncSeqId++;
        if (getSyncMethod() != 1) goto L30;
        this.mPrepareSyncSeqId = this.mSyncSeqId;
        requestRedrawForSync();
    L34:
        return true;
    L30:
        if (this.mHasSurface == false) goto L34;
        if (this.mWinAnimator.mDrawState == 1) goto L34;
        requestRedrawForSync();
        goto L34
    L23:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SYNC_ENGINE_enabled[0] == false) goto L25;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_SYNC_ENGINE, -5774445199273871848L, 0, new Object[]{protoLogParam0});
    L25:
        dropBufferFrom(this.mSyncTransaction);
        goto L26
    L14:
        if (this.mViewVisibility == 0) goto L20;
        if (this.mWinAnimator.mAttrType == 1) goto L20;
        if (this.mWinAnimator.mAttrType == 3) goto L20;
        return false;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean isSyncFinished(BLASTSyncEngine.SyncGroup group) {
        if (isVisibleRequested() == true) goto L5;
    L20:
        return true;
    L5:
        if (isFullyTransparent() == true) goto L20;
        if (this.mSyncState == 1) goto L10;
    L16:
        boolean syncFinished = super.isSyncFinished(group);
        if (syncFinished == true) goto L19;
        Slog.d(TAG, "Sync unFinished: " + this + " mSyncState: " + this.mSyncState + " mLastConfigReportedToClient: " + this.mLastConfigReportedToClient + " isDrawn: " + isDrawn());
    L19:
        return syncFinished;
    L10:
        if (this.mLastConfigReportedToClient == false) goto L16;
        if (isDrawn() == false) goto L16;
        if (this.mPrepareSyncSeqId > 0) goto L16;
        onSyncFinishedDrawing();
        goto L16
    }

    @Override // com.android.server.wm.WindowContainer
    void finishSync(SurfaceControl.Transaction outMergedTransaction, BLASTSyncEngine.SyncGroup group, boolean cancel) {
        if (isDifferentSyncGroup(group) == false) goto L5;
        return;
    L5:
        this.mPrepareSyncSeqId = 0;
        if (cancel == false) goto L8;
        dropBufferFrom(this.mSyncTransaction);
    L8:
        super.finishSync(outMergedTransaction, group, cancel);
    }

    boolean finishDrawing(SurfaceControl.Transaction postDrawTransaction, int syncSeqId) {
        SurfaceControl.Transaction postDrawTransaction2 = postDrawTransaction;
        if (this.mOrientationChangeRedrawRequestTime <= 0) goto L7;
        long duration = SystemClock.elapsedRealtime() - this.mOrientationChangeRedrawRequestTime;
        Slog.i(TAG, "finishDrawing of orientation change: " + this + " " + duration + "ms");
        this.mOrientationChangeRedrawRequestTime = 0;
    L14:
        if (this.mActivityRecord == null) goto L19;
        if (this.mAttrs.type != 3) goto L19;
        this.mWmService.mAtmService.mTaskSupervisor.getActivityMetricsLogger().notifyStartingWindowDrawn(this.mActivityRecord);
    L19:
        if (this.mPrepareSyncSeqId <= 0) goto L21;
        boolean syncActive = true;
    L22:
        if (syncActive == true) goto L24;
    L26:
        boolean syncStillPending = false;
    L27:
        if (syncStillPending == false) goto L34;
        if (postDrawTransaction2 == null) goto L34;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SYNC_ENGINE_enabled[0] == false) goto L33;
        long protoLogParam0 = syncSeqId;
        long protoLogParam1 = this.mPrepareSyncSeqId;
        String protoLogParam2 = String.valueOf(this);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_SYNC_ENGINE, 8097934579596343476L, 5, new Object[]{Long.valueOf(protoLogParam0), Long.valueOf(protoLogParam1), protoLogParam2});
    L33:
        dropBufferFrom(postDrawTransaction);
    L35:
        boolean hasSyncHandlers = executeDrawHandlers(postDrawTransaction, syncSeqId);
        boolean skipLayout = false;
        boolean layoutNeeded = false;
        AsyncRotationController asyncRotationController = this.mDisplayContent.getAsyncRotationController();
        if (asyncRotationController != null) goto L38;
    L40:
        if (syncActive == false) goto L46;
        if (syncStillPending == true) goto L43;
        layoutNeeded = onSyncFinishedDrawing();
    L43:
        if (postDrawTransaction2 == null) goto L48;
        this.mSyncTransaction.merge(postDrawTransaction2);
        postDrawTransaction2 = null;
    L48:
        boolean layoutNeeded2 = layoutNeeded | this.mWinAnimator.finishDrawingLocked(postDrawTransaction2);
        if (this.mWmService.getExt().isFreezingDisplayForSwitchResolution() == true) goto L51;
    L57:
        if (skipLayout == true) goto L62;
        if (hasSyncHandlers == true) goto L60;
        if (layoutNeeded2 == true) goto L60;
        return false;
    L60:
        return true;
    L62:
        return false;
    L51:
        if (isActivityTypeHome() == false) goto L57;
        if (getTask() == null) goto L57;
        if (getTask().getExtWindowContainer().isContainerWaitingForAllDrawn() == false) goto L57;
        Slog.d(TAG, "finish waiting for drawn for home");
        getTask().getExtWindowContainer().setContainerWaitingForAllDrawn(false);
        layoutNeeded2 = true;
        goto L57
    L46:
        if (syncNextBuffer() == false) goto L48;
        layoutNeeded = onSyncFinishedDrawing();
        goto L48
    L38:
        if (asyncRotationController.handleFinishDrawing(this, postDrawTransaction2) == false) goto L40;
        postDrawTransaction2 = null;
        skipLayout = true;
    L34:
        syncStillPending = syncStillPending;
        goto L35
    L24:
        if (this.mPrepareSyncSeqId <= syncSeqId) goto L26;
        syncStillPending = true;
        goto L27
    L21:
        syncActive = false;
        goto L22
    L7:
        if (this.mActivityRecord == null) goto L14;
        if (this.mActivityRecord.mRelaunchStartTime == 0) goto L14;
        if (this.mActivityRecord.findMainWindow(false) != this) goto L14;
        long duration2 = SystemClock.elapsedRealtime() - this.mActivityRecord.mRelaunchStartTime;
        Slog.i(TAG, "finishDrawing of relaunch: " + this + " " + duration2 + "ms");
        this.mActivityRecord.finishOrAbortReplacingWindow();
        goto L14
    }

    void immediatelyNotifyBlastSync() {
        finishDrawing(null, Integer.MAX_VALUE);
        this.mWmService.mH.removeMessages(64, this);
    }

    @Override // com.android.server.wm.WindowContainer
    boolean fillsParent() {
        if (this.mAttrs.type != 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean showWallpaper() {
        if (isVisibleRequested() == true) goto L5;
        return false;
    L5:
        if (inMultiWindowMode() == false) goto L8;
        return false;
    L8:
        return hasWallpaper();
    }

    @Override // com.android.server.wm.WindowContainer
    boolean hasWallpaper() {
        if (getExt().shouldForceShowWallpaper() == false) goto L6;
        return true;
    L6:
        if ((this.mAttrs.flags & 1048576) == 0) goto L8;
        return true;
    L8:
        if (hasWallpaperForLetterboxBackground() == true) goto L13;
        return false;
    L13:
        return true;
    }

    boolean hasWallpaperForLetterboxBackground() {
        if (this.mActivityRecord != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mActivityRecord.hasWallpaperBackgroundForLetterbox() == false) goto L7;
        return true;
    }

    private boolean shouldSendRedrawForSync() {
        if (this.mRedrawForSyncReported == false) goto L6;
        return false;
    L6:
        if (this.mInRelayout == false) goto L15;
        if (this.mPrepareSyncSeqId <= 0) goto L10;
    L13:
        return false;
    L10:
        if (this.mViewVisibility != 0) goto L15;
        if (this.mWinAnimator.mDrawState == 1) goto L13;
    L15:
        return syncNextBuffer();
    }

    int getSyncMethod() {
        BLASTSyncEngine.SyncGroup syncGroup = getSyncGroup();
        if (syncGroup != null) goto L7;
        return 0;
    L7:
        if (this.mSyncMethodOverride == (-1)) goto L11;
        return this.mSyncMethodOverride;
    L11:
        return syncGroup.mSyncMethod;
    }

    boolean shouldSyncWithBuffers() {
        if (this.mDrawHandlers.isEmpty() == true) goto L6;
        return true;
    L6:
        if (getSyncMethod() == 1) goto L10;
        return false;
    L10:
        return true;
    }

    void requestRedrawForSync() {
        this.mRedrawForSyncReported = false;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean syncNextBuffer() {
        if (super.syncNextBuffer() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mDrawHandlers.size() != 0) goto L8;
        return false;
    }

    void applyWithNextDraw(Consumer<SurfaceControl.Transaction> consumer) {
        if (this.mSyncState == 0) goto L5;
        Slog.w(TAG, "applyWithNextDraw with mSyncState=" + this.mSyncState + ", " + this + ", " + Debug.getCallers(8));
    L5:
        this.mSyncSeqId++;
        this.mDrawHandlers.add(new DrawHandler(this, this.mSyncSeqId, consumer));
        requestRedrawForSync();
        this.mWmService.mH.sendNewMessageDelayed(64, this, 5000);
    }

    boolean executeDrawHandlers(SurfaceControl.Transaction t, int seqId) {
        boolean hadHandlers = false;
        boolean applyHere = false;
        if (t != null) goto L5;
        t = this.mTmpTransaction;
        applyHere = true;
    L5:
        List<DrawHandler> handlersToRemove = new ArrayList();
        int i = 0;
    L7:
        if (i >= this.mDrawHandlers.size()) goto L12;
        DrawHandler h = this.mDrawHandlers.get(i);
        if (h.mSeqId > seqId) goto L11;
        h.mConsumer.accept(t);
        handlersToRemove.add(h);
        hadHandlers = true;
    L11:
        i = i + 1;
        goto L7
    L12:
        int i2 = 0;
    L14:
        if (i2 >= handlersToRemove.size()) goto L17;
        DrawHandler h2 = handlersToRemove.get(i2);
        this.mDrawHandlers.remove(h2);
        i2 = i2 + 1;
        goto L14
    L17:
        if (hadHandlers == false) goto L19;
        this.mWmService.mH.removeMessages(64, this);
    L19:
        if (applyHere == false) goto L21;
        t.apply();
    L21:
        return hadHandlers;
    }

    void setSurfaceTranslationY(int translationY) {
        this.mSurfaceTranslationY = translationY;
    }

    @Override // com.android.server.wm.WindowContainer
    int getWindowType() {
        return this.mAttrs.type;
    }

    void markRedrawForSyncReported() {
        this.mRedrawForSyncReported = true;
    }

    boolean setWallpaperOffset(int dx, int dy, float scale) {
        if (this.mXOffset == dx) goto L5;
    L10:
        this.mXOffset = dx;
        this.mYOffset = dy;
        this.mWallpaperScale = scale;
        scheduleAnimation();
        return true;
    L5:
        if (this.mYOffset != dy) goto L10;
        if (Float.compare(this.mWallpaperScale, scale) != 0) goto L10;
        return false;
    }

    boolean isTrustedOverlay() {
        WindowState parentWindow = getParentWindow();
        if (isWindowTrustedOverlay() == true) goto L9;
        if (parentWindow != null) goto L6;
    L8:
        return false;
    L6:
        if (parentWindow.isWindowTrustedOverlay() == false) goto L8;
    L9:
        return true;
    }

    @Override // com.android.server.wm.InputTarget
    public boolean receiveFocusFromTapOutside() {
        return canReceiveKeys(true);
    }

    @Override // com.android.server.wm.InputTarget
    public void handleTapOutsideFocusOutsideSelf() {
    }

    @Override // com.android.server.wm.InputTarget
    public void handleTapOutsideFocusInsideSelf() {
        this.mWmService.moveDisplayToTopInternal(getDisplayId());
        this.mWmService.handleTaskFocusChange(getTask(), this.mActivityRecord);
    }

    void clearClientTouchableRegion() {
        this.mTouchableInsets = 0;
        this.mGivenTouchableRegion.setEmpty();
    }

    @Override // com.android.server.wm.InputTarget
    public boolean shouldControlIme() {
        return !inMultiWindowMode();
    }

    @Override // com.android.server.wm.InputTarget
    public boolean canScreenshotIme() {
        return !isSecureLocked();
    }

    @Override // com.android.server.wm.InputTarget
    public ActivityRecord getActivityRecord() {
        return this.mActivityRecord;
    }

    @Override // com.android.server.wm.InputTarget
    public boolean isInputMethodClientFocus(int uid, int pid) {
        return getDisplayContent().isInputMethodClientFocus(uid, pid);
    }

    @Override // com.android.server.wm.InputTarget
    public void dumpProto(ProtoOutputStream proto, long fieldId, int logLevel) {
        dumpDebug(proto, fieldId, logLevel);
    }

    public boolean cancelAndRedraw() {
        if (this.mPrepareSyncSeqId <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isActivityWindow() {
        if (this.mActivityRecord == null) goto L5;
        return true;
    L5:
        return false;
    }

    void setSecureLocked(boolean isSecure) {
        if (ProtoLogImpl_798997914.Cache.WM_SHOW_TRANSACTIONS_enabled[2] == false) goto L6;
        String protoLogParam1 = String.valueOf(getName());
        ProtoLogImpl_798997914.i(WmProtoLogGroups.WM_SHOW_TRANSACTIONS, 8269653477215188641L, 3, new Object[]{Boolean.valueOf(isSecure), protoLogParam1});
    L6:
        if (this.mSurfaceControl != null) goto L8;
        return;
    L8:
        getPendingTransaction().setSecure(this.mSurfaceControl, isSecure);
        if (this.mDisplayContent == null) goto L11;
        this.mDisplayContent.refreshImeSecureFlag(getSyncTransaction());
        this.mDisplayContent.getObricExt().onWindowSecureChanged(isSecure);
    L11:
        this.mWmService.scheduleAnimationLocked();
    }

    boolean isInsetsAnimationRunning() {
        return this.mInsetsAnimationRunning;
    }

    public WindowStateSmtBase getWindowStateSysEx() {
        return (WindowStateSmtBase) getSmtEx();
    }

    public IExtWindowState getExt() {
        return this.mExt;
    }

    public IWindow getIWindow() {
        return this.mClient;
    }

    public IObricWindowState getObricExt() {
        return this.mObricExt;
    }
}
