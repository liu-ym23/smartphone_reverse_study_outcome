package com.android.server.wm;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Debug;
import android.os.IBinder;
import android.os.RemoteException;
import android.pico.utils.ExtImplFactory;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Pools;
import android.util.RotationUtils;
import android.util.Slog;
import android.util.SparseArray;
import android.util.proto.ProtoOutputStream;
import android.view.DisplayInfo;
import android.view.InsetsFrameProvider;
import android.view.InsetsSource;
import android.view.InsetsState;
import android.view.MagnificationSpec;
import android.view.RemoteAnimationDefinition;
import android.view.SurfaceControl;
import android.view.SurfaceControlViewHost;
import android.window.DesktopModeFlags;
import android.window.IWindowContainerToken;
import android.window.WindowContainerToken;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.util.ToBooleanFunction;
import com.android.server.am.ProcessList;
import com.android.server.wm.WindowContainer;
import com.android.server.wm.utils.AlwaysTruePredicate;
import com.obric.utils.ObricImplFactory;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
class WindowContainer<E extends WindowContainer> extends ConfigurationContainer<E> implements Comparable<WindowContainer>, SurfaceAnimator.Animatable, InsetsControlTarget {
    static final int POSITION_BOTTOM = Integer.MIN_VALUE;
    static final int POSITION_TOP = Integer.MAX_VALUE;
    public static final int SYNC_STATE_NONE = 0;
    public static final int SYNC_STATE_READY = 2;
    public static final int SYNC_STATE_WAITING_FOR_DRAW = 1;
    private static final String TAG = "WindowManager";
    private SurfaceControl mAnimationLeash;
    protected final ArrayList<E> mChildren;
    private final Pools.SynchronizedPool<WindowContainer<E>.ForAllWindowsConsumerWrapper> mConsumerWrapperPool;
    protected InsetsSourceProvider mControllableInsetProvider;
    protected DisplayContent mDisplayContent;
    private int mExcludeInsetsTypes;
    private IExtWindowContainer mExt;
    private ArrayMap<IBinder, WindowContainer<E>.DeathRecipient> mInsetsOwnerDeathRecipientMap;
    protected SparseArray<InsetsSourceProvider> mInsetsSourceProviders;
    private boolean mIsFocusable;
    protected int mLastDeltaRotation;
    private int mLastLayer;
    private MagnificationSpec mLastMagnificationSpec;
    protected WindowContainer mLastOrientationSource;
    private SurfaceControl mLastRelativeToLayer;
    protected final Point mLastSurfacePosition;
    boolean mLaunchTaskBehind;
    private final List<WindowContainerListener> mListeners;
    SparseArray<InsetsSource> mLocalInsetsSources;
    protected int mMergedExcludeInsetsTypes;
    private IObricWindowContainer mObricExt;
    protected TrustedOverlayHost mOverlayHost;
    private int mOverrideOrientation;
    private WindowContainer<WindowContainer> mParent;
    private SurfaceControl.Transaction mPendingTransaction;
    RemoteToken mRemoteToken;
    boolean mReparenting;
    private Rect mSafeRegionBounds;
    protected final SurfaceAnimator mSurfaceAnimator;
    protected SurfaceControl mSurfaceControl;
    BLASTSyncEngine.SyncGroup mSyncGroup;
    int mSyncMethodOverride;
    int mSyncState;
    final SurfaceControl.Transaction mSyncTransaction;
    private int mSyncTransactionCommitCallbackDepth;
    private final LinkedList<WindowContainer> mTmpChain1;
    private final LinkedList<WindowContainer> mTmpChain2;
    private final Point mTmpPos;
    final Rect mTmpPrevBounds;
    protected final Rect mTmpRect;
    int mTransit;
    int mTransitFlags;
    final TransitionController mTransitionController;
    private int mTreeWeight;
    protected boolean mVisibleRequested;
    final ArrayList<WindowState> mWaitingForDrawn;
    protected final WindowManagerService mWmService;

    public interface AnimationFlags {
        public static final int CHILDREN = 4;
        public static final int PARENTS = 2;
        public static final int TRANSITION = 1;
    }

    @FunctionalInterface
    interface ConfigurationMerger {
        Configuration merge(Configuration r1, Configuration r2);
    }

    private class DeathRecipient implements IBinder.DeathRecipient {
        private final IBinder mOwner;
        private final ArraySet<Integer> mSourceIds;
        final /* synthetic */ WindowContainer this$0;

        DeathRecipient(WindowContainer r1, IBinder owner) {
            this.this$0 = r1;
            this.mSourceIds = new ArraySet();
            this.mOwner = owner;
        }

        void addSourceId(int id) {
            this.mSourceIds.add(Integer.valueOf(id));
        }

        void removeSourceId(int id) {
            this.mSourceIds.remove(Integer.valueOf(id));
        }

        boolean hasSource() {
            return !this.mSourceIds.isEmpty();
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            WindowManagerGlobalLock r0 = this.this$0.mWmService.mGlobalLock;
            WindowManagerService.boostPriorityForLockedSection();
            monitor-enter(r0);
            boolean changed = false;
            int i = this.mSourceIds.size() - 1;     // Catch: Throwable -> L8
        L6:
            if (i < 0) goto L10;
            changed = changed | WindowContainer.m10393$$Nest$mremoveLocalInsetsSource(this.this$0, this.mSourceIds.valueAt(i).intValue());     // Catch: Throwable -> L8
            i = i - 1;     // Catch: Throwable -> L8
            goto L6
        L10:
            this.mSourceIds.clear();     // Catch: Throwable -> L8
            this.mOwner.unlinkToDeath(this, 0);     // Catch: Throwable -> L8
            WindowContainer.m10392$$Nest$fgetmInsetsOwnerDeathRecipientMap(this.this$0).remove(this.mOwner);     // Catch: Throwable -> L8
            if (changed == true) goto L13;
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L8
            WindowManagerService.resetPriorityAfterLockedSection();
            return;
        L13:
            if (this.this$0.mDisplayContent == null) goto L15;
            this.this$0.mDisplayContent.getInsetsStateController().updateAboveInsetsState(true);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            WindowManagerService.resetPriorityAfterLockedSection();
            throw th;
        }
    }

    private final class ForAllWindowsConsumerWrapper implements ToBooleanFunction<WindowState> {
        private Consumer<WindowState> mConsumer;
        final /* synthetic */ WindowContainer this$0;

        /* synthetic */ ForAllWindowsConsumerWrapper(WindowContainer r1, WindowContainerIA r2) {
            this(r1);
        }

        private ForAllWindowsConsumerWrapper(WindowContainer r1) {
            this.this$0 = r1;
        }

        public /* bridge */ /* synthetic */ boolean apply(Object r1) {
            return apply((WindowState) r1);
        }

        void setConsumer(Consumer<WindowState> consumer) {
            this.mConsumer = consumer;
        }

        public boolean apply(WindowState w) {
            this.mConsumer.accept(w);
            return false;
        }

        void release() {
            this.mConsumer = null;
            WindowContainer.m10391$$Nest$fgetmConsumerWrapperPool(this.this$0).release(this);
        }
    }

    private interface IAnimationStarter {
        void startAnimation(SurfaceControl.Transaction r1, AnimationAdapter r2, boolean r3, int r4, AnimationAdapter r5);
    }

    static class RemoteToken extends IWindowContainerToken.Stub {
        final WeakReference<WindowContainer> mWeakRef;
        private WindowContainerToken mWindowContainerToken;

        RemoteToken(WindowContainer container) {
            this.mWeakRef = new WeakReference(container);
        }

        WindowContainer getContainer() {
            return this.mWeakRef.get();
        }

        /* JADX WARN: Multi-variable type inference failed */
        static RemoteToken fromBinder(IBinder r1) {
            return (RemoteToken) r1;
        }

        WindowContainerToken toWindowContainerToken() {
            if (this.mWindowContainerToken != null) goto L6;
            this.mWindowContainerToken = new WindowContainerToken(this);
        L6:
            return this.mWindowContainerToken;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("RemoteToken{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(' ');
            sb.append(this.mWeakRef.get());
            sb.append('}');
            return sb.toString();
        }
    }

    @interface SyncState {
    }

    public static /* synthetic */ void $r8$lambda$4KFnmi1Zahd4tGoSRGL9TEilh5I(WindowContainer r0, WindowState r1) {
        r0.lambda$waitForAllWindowsDrawn$7(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$HpiOjpdobBnkrM-2B2eUH2osE-0, reason: not valid java name */
    public static /* synthetic */ boolean m10388$r8$lambda$HpiOjpdobBnkrM2B2eUH2osE0(ActivityRecord r0) {
        return lambda$getTopActivity$6(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$P9uMBneLM2Si1UANWoV5uQ4DSY8(ActivityRecord r0) {
        return lambda$isAppTransitioning$0(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$RoefaS-QXOxL_us2KJwSbjfnrw8, reason: not valid java name */
    public static /* synthetic */ boolean m10389$r8$lambda$RoefaSQXOxL_us2KJwSbjfnrw8(ActivityRecord r0) {
        return lambda$getTopActivity$4(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$VL7COjP22BDfQbmQDxM40Y0HjIc(ActivityRecord r0) {
        return lambda$getTopActivity$5(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$c-8IPA9z9heU9Ef7rKdnbyxsCl4, reason: not valid java name */
    public static /* synthetic */ boolean m10390$r8$lambda$c8IPA9z9heU9Ef7rKdnbyxsCl4(ActivityRecord r0) {
        return lambda$getTopNonFinishingActivity$1(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$lddL3MzWJtL_ZLO4FjlXcGg9Wy4(ActivityRecord r0) {
        return lambda$getTopMostFreeformActivity$2(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$tzBgTOab6P1amfdBBfXflRncSU8(ActivityRecord r0) {
        return lambda$getTopMostVisibleFreeformActivity$3(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmConsumerWrapperPool, reason: not valid java name */
    static /* bridge */ /* synthetic */ Pools.SynchronizedPool m10391$$Nest$fgetmConsumerWrapperPool(WindowContainer r0) {
        return r0.mConsumerWrapperPool;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInsetsOwnerDeathRecipientMap, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayMap m10392$$Nest$fgetmInsetsOwnerDeathRecipientMap(WindowContainer r0) {
        return r0.mInsetsOwnerDeathRecipientMap;
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveLocalInsetsSource, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m10393$$Nest$mremoveLocalInsetsSource(WindowContainer r0, int r1) {
        return r0.removeLocalInsetsSource(r1);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(WindowContainer r1) {
        return compareTo(r1);
    }

    @Override // com.android.server.wm.ConfigurationContainer
    protected /* bridge */ /* synthetic */ ConfigurationContainer getChildAt(int r1) {
        return getChildAt(r1);
    }

    @Override // com.android.server.wm.ConfigurationContainer
    protected /* bridge */ /* synthetic */ ConfigurationContainer getParent() {
        return getParent();
    }

    WindowContainer(WindowManagerService wms) {
        this.mParent = null;
        this.mLocalInsetsSources = null;
        this.mInsetsSourceProviders = null;
        this.mMergedExcludeInsetsTypes = 0;
        this.mExcludeInsetsTypes = 0;
        this.mChildren = new ArrayList();
        this.mOverrideOrientation = -2;
        this.mConsumerWrapperPool = new Pools.SynchronizedPool(3);
        this.mLastLayer = 0;
        this.mLastRelativeToLayer = null;
        this.mWaitingForDrawn = new ArrayList();
        this.mTmpPos = new Point();
        this.mLastSurfacePosition = new Point();
        this.mLastDeltaRotation = 0;
        this.mTreeWeight = 1;
        this.mSyncTransactionCommitCallbackDepth = 0;
        this.mTmpRect = new Rect();
        this.mTmpPrevBounds = new Rect();
        this.mIsFocusable = true;
        this.mRemoteToken = null;
        this.mSyncGroup = null;
        this.mSyncState = 0;
        this.mSyncMethodOverride = -1;
        this.mListeners = new ArrayList();
        this.mObricExt = (IObricWindowContainer) ObricImplFactory.getImpl(IObricWindowContainer.class, new Object[]{this});
        this.mTmpChain1 = new LinkedList();
        this.mTmpChain2 = new LinkedList();
        this.mExt = (IExtWindowContainer) ExtImplFactory.getImpl(IExtWindowContainer.class, new Object[]{this});
        this.mWmService = wms;
        this.mTransitionController = this.mWmService.mAtmService.getTransitionController();
        this.mSyncTransaction = wms.mTransactionFactory.get();
        this.mSurfaceAnimator = new SurfaceAnimator(this, new WindowContainer$$ExternalSyntheticLambda8(this), wms);
    }

    void updateAboveInsetsState(InsetsState aboveInsetsState, SparseArray<InsetsSource> localInsetsSourcesFromParent, ArraySet<WindowState> insetsChangedWindows) {
        SparseArray<InsetsSource> mergedLocalInsetsSources = createMergedSparseArray(localInsetsSourcesFromParent, this.mLocalInsetsSources);
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L6;
        this.mChildren.get(i).updateAboveInsetsState(aboveInsetsState, mergedLocalInsetsSources, insetsChangedWindows);
        i = i - 1;
        goto L3
    }

    static <T> SparseArray<T> createMergedSparseArray(SparseArray<T> sa1, SparseArray<T> sa2) {
        int size2 = 0;
        if (sa1 == null) goto L5;
        int size1 = sa1.size();
    L6:
        if (sa2 == null) goto L8;
        size2 = sa2.size();
    L8:
        SparseArray<T> mergedArray = new SparseArray(size1 + size2);
        if (size1 <= 0) goto L13;
        int i = 0;
    L11:
        if (i >= size1) goto L13;
        mergedArray.append(sa1.keyAt(i), sa1.valueAt(i));
        i = i + 1;
    L13:
        if (size2 <= 0) goto L17;
        int i2 = 0;
    L15:
        if (i2 >= size2) goto L17;
        mergedArray.put(sa2.keyAt(i2), sa2.valueAt(i2));
        i2 = i2 + 1;
    L17:
        return mergedArray;
    L5:
        size1 = 0;
        goto L6
    }

    void addLocalInsetsFrameProvider(InsetsFrameProvider provider, IBinder owner) {
        if (provider == null) goto L33;
        if (owner == null) goto L33;
        if (this.mDisplayContent != null) goto L9;
        Slog.w(TAG, "Can't add insets frame provider when detached. " + this);
        return;
    L9:
        if (this.mInsetsOwnerDeathRecipientMap != null) goto L11;
        this.mInsetsOwnerDeathRecipientMap = new ArrayMap();
    L11:
        WindowContainer<E>.DeathRecipient r0 = this.mInsetsOwnerDeathRecipientMap.get(owner);
        if (r0 != null) goto L19;
        r0 = new DeathRecipient(this, owner);
        owner.linkToDeath(r0, 0);     // Catch: RemoteException -> L16
        this.mInsetsOwnerDeathRecipientMap.put(owner, r0);
    L17:
        Slog.w(TAG, "Failed to add source for " + provider + " since the owner has died.");
        return;
    L19:
        int id = provider.getId();
        r0.addSourceId(id);
        if (this.mLocalInsetsSources != null) goto L23;
        this.mLocalInsetsSources = new SparseArray();
    L23:
        if (this.mLocalInsetsSources.get(id) != null) goto L25;
    L27:
        InsetsSource source = new InsetsSource(id, provider.getType());
        source.setFrame(provider.getArbitraryRectangle()).updateSideHint(getBounds()).setBoundingRects(provider.getBoundingRects());
        if (DesktopModeFlags.ENABLE_CAPTION_COMPAT_INSET_FORCE_CONSUMPTION.isTrue() == false) goto L30;
        source.setFlags(provider.getFlags());
    L30:
        this.mLocalInsetsSources.put(id, source);
        this.mDisplayContent.getInsetsStateController().updateAboveInsetsState(true);
        return;
    L25:
        if (WindowManagerDebugConfig.DEBUG == false) goto L27;
        Slog.d(TAG, "The local insets source for this " + provider + " already exists. Overwriting.");
    L33:
        throw new IllegalArgumentException("Insets provider or owner not specified.");
    }

    void removeLocalInsetsFrameProvider(InsetsFrameProvider provider, IBinder owner) {
        if (provider == null) goto L20;
        if (owner == null) goto L20;
        int id = provider.getId();
        if (removeLocalInsetsSource(id) == false) goto L10;
        if (this.mDisplayContent == null) goto L10;
        this.mDisplayContent.getInsetsStateController().updateAboveInsetsState(true);
    L10:
        if (this.mInsetsOwnerDeathRecipientMap != null) goto L12;
        return;
    L12:
        WindowContainer<E>.DeathRecipient deathRecipient = this.mInsetsOwnerDeathRecipientMap.get(owner);
        if (deathRecipient != null) goto L15;
        return;
    L15:
        deathRecipient.removeSourceId(id);
        if (deathRecipient.hasSource() == true) goto L21;
        owner.unlinkToDeath(deathRecipient, 0);
        this.mInsetsOwnerDeathRecipientMap.remove(owner);
        return;
    L21:
        return;
    L20:
        throw new IllegalArgumentException("Insets provider or owner not specified.");
    }

    private boolean removeLocalInsetsSource(int id) {
        if (this.mLocalInsetsSources != null) goto L6;
        return false;
    L6:
        if (this.mLocalInsetsSources.removeReturnOld(id) == null) goto L8;
        return true;
    L8:
        if (WindowManagerDebugConfig.DEBUG == false) goto L10;
        Slog.d(TAG, "Given id " + Integer.toHexString(id) + " doesn't exist.");
    L10:
        return false;
    }

    void setControllableInsetProvider(InsetsSourceProvider insetProvider) {
        this.mControllableInsetProvider = insetProvider;
    }

    InsetsSourceProvider getControllableInsetProvider() {
        return this.mControllableInsetProvider;
    }

    void setExcludeInsetsTypes(int excludeInsetsTypes) {
        if (excludeInsetsTypes != this.mExcludeInsetsTypes) goto L5;
        return;
    L5:
        this.mExcludeInsetsTypes = excludeInsetsTypes;
        if (this.mParent == null) goto L8;
        int r0 = this.mParent.mMergedExcludeInsetsTypes;
    L9:
        mergeExcludeInsetsTypesAndNotifyInsetsChanged(r0);
        return;
    L8:
        r0 = 0;
        goto L9
    }

    Rect getSafeRegionBounds() {
        if (this.mSafeRegionBounds == null) goto L7;
        return this.mSafeRegionBounds;
    L7:
        if (this.mParent != null) goto L11;
        return null;
    L11:
        return this.mParent.getSafeRegionBounds();
    }

    void setSafeRegionBounds(Rect safeRegionBounds) {
        Slog.i(TAG, "Feature safe region letterboxing is not available");
    }

    private void mergeExcludeInsetsTypesAndNotifyInsetsChanged(int excludeInsetsTypesFromParent) {
        ArraySet<WindowState> changedWindows = new ArraySet();
        updateMergedExcludeInsetsTypes(excludeInsetsTypesFromParent, changedWindows);
        if (getDisplayContent() == null) goto L6;
        getDisplayContent().getInsetsStateController().notifyInsetsChanged(changedWindows);
        return;
    }

    private void updateMergedExcludeInsetsTypes(int excludeInsetsTypesFromParent, ArraySet<WindowState> changedWindows) {
        int newMergedExcludeInsetsTypes = this.mExcludeInsetsTypes | excludeInsetsTypesFromParent;
        if (newMergedExcludeInsetsTypes != this.mMergedExcludeInsetsTypes) goto L5;
        return;
    L5:
        this.mMergedExcludeInsetsTypes = newMergedExcludeInsetsTypes;
        WindowState win = asWindowState();
        if (win == null) goto L8;
        changedWindows.add(win);
    L8:
        int i = this.mChildren.size() - 1;
    L9:
        if (i < 0) goto L12;
        WindowContainer<?> child = this.mChildren.get(i);
        child.updateMergedExcludeInsetsTypes(this.mMergedExcludeInsetsTypes, changedWindows);
        i = i - 1;
        goto L9
    }

    @Override // com.android.server.wm.ConfigurationContainer
    protected final WindowContainer getParent() {
        return this.mParent;
    }

    @Override // com.android.server.wm.ConfigurationContainer
    protected int getChildCount() {
        return this.mChildren.size();
    }

    @Override // com.android.server.wm.ConfigurationContainer
    protected E getChildAt(int index) {
        return this.mChildren.get(index);
    }

    @Override // com.android.server.wm.ConfigurationContainer
    public void onConfigurationChanged(Configuration newParentConfig) {
        super.onConfigurationChanged(newParentConfig);
        if (this.mParent != null) goto L5;
        return;
    L5:
        updateSurfacePositionNonOrganized();
        scheduleAnimation();
        if (this.mOverlayHost == null) goto L9;
        this.mOverlayHost.dispatchConfigurationChanged(getConfiguration());
        return;
    }

    void reparent(WindowContainer newParent, int position) {
        if (newParent == null) goto L16;
        if (newParent == this) goto L14;
        WindowContainer<WindowContainer> r0 = this.mParent;
        if (this.mParent == newParent) goto L12;
        this.mTransitionController.collectReparentChange(this, newParent);
        DisplayContent prevDc = r0.getDisplayContent();
        DisplayContent dc = newParent.getDisplayContent();
        this.mReparenting = true;
        r0.removeChild(this);
        newParent.addChild(this, position);
        this.mReparenting = false;
        dc.setLayoutNeeded();
        if (prevDc == dc) goto L9;
        Slog.d(TAG, "onDisplayChanged: dc=" + dc + " wc: " + this + " prevDc: " + prevDc);
        onDisplayChanged(dc);
        prevDc.setLayoutNeeded();
    L9:
        onParentChanged(newParent, r0);
        onSyncReparent(r0, newParent);
        return;
    L12:
        throw new IllegalArgumentException("WC=" + this + " already child of " + this.mParent);
    L14:
        throw new IllegalArgumentException("Can not reparent to itself " + this);
    L16:
        throw new IllegalArgumentException("reparent: can't reparent to null " + this);
    }

    protected final void setParent(WindowContainer<WindowContainer> parent) {
        WindowContainer<WindowContainer> r0 = this.mParent;
        this.mParent = parent;
        if (this.mParent == null) goto L6;
        this.mParent.onChildAdded(this);
    L9:
        if (this.mReparenting == true) goto L19;
        onSyncReparent(r0, this.mParent);
        if (this.mParent != null) goto L13;
    L17:
        onParentChanged(this.mParent, r0);
        return;
    L13:
        if (this.mParent.mDisplayContent == null) goto L17;
        if (this.mDisplayContent == this.mParent.mDisplayContent) goto L17;
        onDisplayChanged(this.mParent.mDisplayContent);
        goto L17
    L19:
        return;
    L6:
        if (this.mSurfaceAnimator.hasLeash() == false) goto L9;
        this.mSurfaceAnimator.cancelAnimation();
        goto L9
    }

    @Override // com.android.server.wm.ConfigurationContainer
    void onParentChanged(ConfigurationContainer newParent, ConfigurationContainer oldParent) {
        super.onParentChanged(newParent, oldParent);
        if (this.mParent != null) goto L7;
        mergeExcludeInsetsTypesAndNotifyInsetsChanged(0);
        return;
    L7:
        if (this.mSurfaceControl != null) goto L9;
        createSurfaceControl(false);
    L10:
        mergeExcludeInsetsTypesAndNotifyInsetsChanged(this.mParent.mMergedExcludeInsetsTypes);
        this.mParent.assignChildLayers();
        return;
    L9:
        reparentSurfaceControl(getSyncTransaction(), this.mParent.mSurfaceControl);
        goto L10
    }

    void createSurfaceControl(boolean force) {
        setInitialSurfaceControlProperties(makeSurface());
    }

    void setInitialSurfaceControlProperties(SurfaceControl.Builder b) {
        setSurfaceControl(b.setCallsite("WindowContainer.setInitialSurfaceControlProperties").build());
        if (showSurfaceOnCreation() == false) goto L5;
        getSyncTransaction().show(this.mSurfaceControl);
    L5:
        updateSurfacePositionNonOrganized();
        if (this.mLastMagnificationSpec == null) goto L9;
        applyMagnificationSpec(getSyncTransaction(), this.mLastMagnificationSpec);
        return;
    }

    void migrateToNewSurfaceControl(SurfaceControl.Transaction t) {
        t.remove(this.mSurfaceControl);
        this.mLastSurfacePosition.set(0, 0);
        this.mLastDeltaRotation = 0;
        SurfaceControl.Builder b = this.mWmService.makeSurfaceBuilder().setContainerLayer().setName(getName());
        setInitialSurfaceControlProperties(b);
        SurfaceControl r1 = this.mSurfaceControl;
        if (this.mParent != null) goto L5;
        SurfaceControl r2 = null;
    L6:
        t.reparent(r1, r2);
        if (this.mLastRelativeToLayer == null) goto L9;
        t.setRelativeLayer(this.mSurfaceControl, this.mLastRelativeToLayer, this.mLastLayer);
    L10:
        int i = 0;
    L12:
        if (i >= this.mChildren.size()) goto L18;
        SurfaceControl sc = this.mChildren.get(i).getSurfaceControl();
        if (sc == null) goto L16;
        t.reparent(sc, this.mSurfaceControl);
    L16:
        i = i + 1;
        goto L12
    L18:
        if (this.mOverlayHost == null) goto L20;
        this.mOverlayHost.setParent(t, this.mSurfaceControl);
    L20:
        scheduleAnimation();
        return;
    L9:
        t.setLayer(this.mSurfaceControl, this.mLastLayer);
        goto L10
    L5:
        r2 = this.mParent.mSurfaceControl;
        goto L6
    }

    protected void addChild(E child, Comparator<E> comparator) {
        if (child.mReparenting == false) goto L5;
    L9:
        int positionToAdd = -1;
        if (comparator == null) goto L18;
        int count = this.mChildren.size();
        int i = 0;
    L12:
        if (i >= count) goto L18;
        if (comparator.compare(child, this.mChildren.get(i)) < 0) goto L15;
        i = i + 1;
        goto L12
    L15:
        positionToAdd = i;
    L18:
        if (positionToAdd != (-1)) goto L20;
        this.mChildren.add(child);
    L21:
        child.setParent(this);
        return;
    L20:
        this.mChildren.add(positionToAdd, child);
        goto L21
    L5:
        if (child.getParent() == null) goto L9;
        throw new IllegalArgumentException("addChild: container=" + child.getName() + " is already a child of container=" + child.getParent().getName() + " can't add to container=" + getName());
    }

    void addChild(E child, int index) {
        if (child.mReparenting == true) goto L10;
        if (child.getParent() == null) goto L10;
        throw new IllegalArgumentException("addChild: container=" + child.getName() + " is already a child of container=" + child.getParent().getName() + " can't add to container=" + getName() + "\n callers=" + Debug.getCallers(15, "\n"));
    L10:
        if (index >= 0) goto L13;
        if (index == Integer.MIN_VALUE) goto L13;
    L17:
        throw new IllegalArgumentException("addChild: invalid position=" + index + ", children number=" + this.mChildren.size());
    L13:
        if (index <= this.mChildren.size()) goto L18;
        if (index != Integer.MAX_VALUE) goto L17;
    L18:
        if (index != Integer.MAX_VALUE) goto L20;
        index = this.mChildren.size();
    L22:
        this.mChildren.add(index, child);
        child.setParent(this);
        return;
    L20:
        if (index != Integer.MIN_VALUE) goto L22;
        index = 0;
        goto L22
    }

    private void onChildAdded(WindowContainer child) {
        this.mTreeWeight += child.mTreeWeight;
        WindowContainer parent = getParent();
    L3:
        if (parent == null) goto L5;
        parent.mTreeWeight += child.mTreeWeight;
        parent = parent.getParent();
        goto L3
    L5:
        onChildVisibleRequestedChanged(child);
        onChildPositionChanged(child);
    }

    void removeChild(E child) {
        if (this.mChildren.remove(child) == false) goto L9;
        onChildRemoved(child);
        if (child.mReparenting == true) goto L10;
        child.setParent(null);
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("removeChild: container=" + child.getName() + " is not a child of container=" + getName());
    }

    private void onChildRemoved(WindowContainer child) {
        this.mTreeWeight -= child.mTreeWeight;
        WindowContainer parent = getParent();
    L3:
        if (parent == null) goto L5;
        parent.mTreeWeight -= child.mTreeWeight;
        parent = parent.getParent();
        goto L3
    L5:
        onChildVisibleRequestedChanged(null);
        onChildPositionChanged(child);
    }

    void removeImmediately() {
    L3:
        if (this.mChildren.isEmpty() == true) goto L9;
        WindowContainer r0 = (WindowContainer) this.mChildren.getLast();
        r0.removeImmediately();
        if (this.mChildren.remove(r0) == false) goto L3;
        onChildRemoved(r0);
        goto L3
    L9:
        if (this.mSurfaceControl == null) goto L12;
        getSyncTransaction().remove(this.mSurfaceControl);
        setSurfaceControl(null);
        this.mLastSurfacePosition.set(0, 0);
        this.mLastDeltaRotation = 0;
        scheduleAnimation();
    L12:
        if (this.mOverlayHost == null) goto L15;
        this.mOverlayHost.release();
        this.mOverlayHost = null;
    L15:
        if (this.mParent == null) goto L17;
        this.mParent.removeChild(this);
    L17:
        int i = this.mListeners.size() - 1;
    L18:
        if (i < 0) goto L21;
        this.mListeners.get(i).onRemoved();
        i = i - 1;
        goto L18
    }

    int getTreeWeight() {
        return this.mTreeWeight;
    }

    int getPrefixOrderIndex() {
        if (this.mParent != null) goto L7;
        return 0;
    L7:
        return this.mParent.getPrefixOrderIndex(this);
    }

    private int getPrefixOrderIndex(WindowContainer child) {
        int order = 0;
        int i = 0;
    L4:
        if (i >= this.mChildren.size()) goto L10;
        WindowContainer childI = this.mChildren.get(i);
        if (child == childI) goto L10;
        order = order + childI.mTreeWeight;
        i = i + 1;
    L10:
        if (this.mParent == null) goto L13;
        order = order + this.mParent.getPrefixOrderIndex(this);
    L13:
        return order + 1;
    }

    void removeIfPossible() {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L6;
        WindowContainer wc = this.mChildren.get(i);
        wc.removeIfPossible();
        i = i - 1;
        goto L3
    }

    boolean hasChild(E child) {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L11;
        E current = this.mChildren.get(i);
        if (current == child) goto L10;
        if (current.hasChild(child) == true) goto L10;
        i = i - 1;
    L10:
        return true;
    L11:
        return false;
    }

    boolean isDescendantOf(WindowContainer ancestor) {
        WindowContainer parent = getParent();
        if (parent != ancestor) goto L5;
        return true;
    L5:
        if (parent != null) goto L7;
    L9:
        return false;
    L7:
        if (parent.isDescendantOf(ancestor) == false) goto L9;
        return true;
    }

    void positionChildAt(int position, E child, boolean includingParents) {
        if (child.getParent() != this) goto L29;
        if (position < (this.mChildren.size() - 1)) goto L7;
        position = Integer.MAX_VALUE;
    L9:
        switch(position) {
            case -2147483648: goto L21;
            case 2147483647: goto L14;
            default: goto L11;
        };
    L11:
        if (this.mChildren.indexOf(child) == position) goto L30;
        this.mChildren.remove(child);
        this.mChildren.add(position, child);
        onChildPositionChanged(child);
        return;
    L30:
        return;
    L14:
        if (getTopChild() == child) goto L16;
        this.mChildren.remove(child);
        this.mChildren.add(child);
        onChildPositionChanged(child);
    L16:
        if (includingParents == true) goto L18;
        return;
    L18:
        if (getParent() == null) goto L33;
        getParent().positionChildAt(Integer.MAX_VALUE, this, true);
        return;
    L33:
        return;
    L21:
        if (getBottomChild() == child) goto L23;
        this.mChildren.remove(child);
        this.mChildren.addFirst(child);
        onChildPositionChanged(child);
    L23:
        if (includingParents == true) goto L25;
        return;
    L25:
        if (getParent() == null) goto L36;
        getParent().positionChildAt(Integer.MIN_VALUE, this, true);
        return;
    L36:
        return;
    L7:
        if (position > 0) goto L9;
        position = Integer.MIN_VALUE;
        goto L9
    L29:
        throw new IllegalArgumentException("positionChildAt: container=" + child.getName() + " is not a child of container=" + getName() + " current parent=" + child.getParent());
    }

    void onChildPositionChanged(WindowContainer child) {
    }

    @Override // com.android.server.wm.ConfigurationContainer
    public void onRequestedOverrideConfigurationChanged(Configuration overrideConfiguration) {
        int diff = diffRequestedOverrideBounds(overrideConfiguration.windowConfiguration.getBounds());
        super.onRequestedOverrideConfigurationChanged(overrideConfiguration);
        if (this.mParent == null) goto L5;
        this.mParent.onDescendantOverrideConfigurationChanged();
    L5:
        if (diff != 0) goto L8;
        return;
    L8:
        if ((diff & 2) != 2) goto L10;
        onResize();
        return;
    L10:
        onMovedByResize();
    }

    void onDescendantOverrideConfigurationChanged() {
        if (this.mParent == null) goto L6;
        this.mParent.onDescendantOverrideConfigurationChanged();
        return;
    }

    void onDisplayChanged(DisplayContent dc) {
        if (this.mDisplayContent != null) goto L5;
    L9:
        this.mDisplayContent = dc;
        if (dc == null) goto L15;
        if (dc == this) goto L15;
        if (this.mPendingTransaction == null) goto L15;
        dc.getPendingTransaction().merge(this.mPendingTransaction);
        this.mPendingTransaction = null;
    L15:
        int i = this.mChildren.size() - 1;
    L16:
        if (i < 0) goto L18;
        WindowContainer child = this.mChildren.get(i);
        child.onDisplayChanged(dc);
        i = i - 1;
        goto L16
    L18:
        int i2 = this.mListeners.size() - 1;
    L19:
        if (i2 < 0) goto L22;
        this.mListeners.get(i2).onDisplayChanged(dc);
        i2 = i2 - 1;
        goto L19
    L22:
        return;
    L5:
        if (this.mDisplayContent == dc) goto L9;
        if (asWindowState() != null) goto L9;
        this.mTransitionController.collect(this);
        goto L9
    }

    public boolean hasInsetsSourceProvider() {
        if (this.mInsetsSourceProviders == null) goto L5;
        return true;
    L5:
        return false;
    }

    public SparseArray<InsetsSourceProvider> getInsetsSourceProviders() {
        if (this.mInsetsSourceProviders != null) goto L6;
        this.mInsetsSourceProviders = new SparseArray();
    L6:
        return this.mInsetsSourceProviders;
    }

    public final DisplayContent getDisplayContent() {
        return this.mDisplayContent;
    }

    DisplayArea getDisplayArea() {
        WindowContainer parent = getParent();
        if (parent != null) goto L7;
        return null;
    L7:
        return parent.getDisplayArea();
    }

    RootDisplayArea getRootDisplayArea() {
        WindowContainer parent = getParent();
        if (parent != null) goto L7;
        return null;
    L7:
        return parent.getRootDisplayArea();
    }

    TaskDisplayArea getTaskDisplayArea() {
        WindowContainer parent = getParent();
        if (parent != null) goto L7;
        return null;
    L7:
        return parent.getTaskDisplayArea();
    }

    boolean isAttached() {
        WindowContainer parent = getParent();
        if (parent != null) goto L5;
    L7:
        return false;
    L5:
        if (parent.isAttached() == false) goto L7;
        return true;
    }

    void onResize() {
        if (this.mControllableInsetProvider == null) goto L5;
        this.mControllableInsetProvider.onWindowContainerBoundsChanged();
    L5:
        int i = this.mChildren.size() - 1;
    L6:
        if (i < 0) goto L9;
        WindowContainer wc = this.mChildren.get(i);
        wc.onParentResize();
        i = i - 1;
        goto L6
    }

    void onParentResize() {
        if (hasOverrideBounds() == false) goto L5;
        return;
    L5:
        onResize();
    }

    void onMovedByResize() {
        if (this.mControllableInsetProvider == null) goto L5;
        this.mControllableInsetProvider.onWindowContainerBoundsChanged();
    L5:
        int i = this.mChildren.size() - 1;
    L6:
        if (i < 0) goto L9;
        WindowContainer wc = this.mChildren.get(i);
        wc.onMovedByResize();
        i = i - 1;
        goto L6
    }

    void resetDragResizingChangeReported() {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L6;
        WindowContainer wc = this.mChildren.get(i);
        wc.resetDragResizingChangeReported();
        i = i - 1;
        goto L3
    }

    boolean canCustomizeAppTransition() {
        return false;
    }

    final boolean isAnimating(int flags, int typesToCheck) {
        if (getAnimatingContainer(flags, typesToCheck) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Deprecated
    final boolean isAnimating(int flags) {
        return isAnimating(flags, -1);
    }

    private static /* synthetic */ boolean lambda$isAppTransitioning$0(ActivityRecord app) {
        return app.isAnimating(3);
    }

    boolean isAppTransitioning() {
        if (getActivity(new WindowContainer$$ExternalSyntheticLambda6()) == null) goto L5;
        return true;
    L5:
        return false;
    }

    boolean inTransitionSelfOrParent() {
        if (this.mTransitionController.isShellTransitionsEnabled() == true) goto L7;
        return isAnimating(3, 1);
    L7:
        return inTransition();
    }

    final boolean isAnimating() {
        return isAnimating(0);
    }

    boolean inTransition() {
        return this.mTransitionController.inTransition(this);
    }

    boolean isExitAnimationRunningSelfOrChild() {
        if (this.mTransitionController.isShellTransitionsEnabled() == true) goto L7;
        return isAnimating(5, 17);
    L7:
        if (this.mChildren.isEmpty() == true) goto L9;
    L11:
        int i = this.mChildren.size() - 1;
    L12:
        if (i < 0) goto L17;
        WindowContainer child = this.mChildren.get(i);
        if (child.isExitAnimationRunningSelfOrChild() == true) goto L15;
        i = i - 1;
        goto L12
    L15:
        return true;
    L17:
        return false;
    L9:
        if (inTransition() == false) goto L11;
        return true;
    }

    void sendAppVisibilityToClients() {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L6;
        WindowContainer wc = this.mChildren.get(i);
        wc.sendAppVisibilityToClients();
        i = i - 1;
        goto L3
    }

    boolean isVisible() {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L8;
        WindowContainer wc = this.mChildren.get(i);
        if (wc.isVisible() == true) goto L6;
        i = i - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    boolean isVisibleRequested() {
        return this.mVisibleRequested;
    }

    boolean setVisibleRequested(boolean visible) {
        if (this.mVisibleRequested != visible) goto L6;
        return false;
    L6:
        this.mVisibleRequested = visible;
        WindowContainer parent = getParent();
        if (parent == null) goto L9;
        parent.onChildVisibleRequestedChanged(this);
    L9:
        int i = this.mListeners.size() - 1;
    L10:
        if (i < 0) goto L13;
        this.mListeners.get(i).onVisibleRequestedChanged(this.mVisibleRequested);
        i = i - 1;
        goto L10
    L13:
        return true;
    }

    protected boolean onChildVisibleRequestedChanged(WindowContainer child) {
        if (child != null) goto L5;
    L7:
        boolean childVisReq = false;
    L8:
        boolean newVisReq = this.mVisibleRequested;
        if (childVisReq == true) goto L11;
    L13:
        if (childVisReq == false) goto L15;
    L25:
        return setVisibleRequested(newVisReq);
    L15:
        if (this.mVisibleRequested == false) goto L25;
        newVisReq = false;
        int i = this.mChildren.size() - 1;
    L17:
        if (i < 0) goto L25;
        WindowContainer wc = this.mChildren.get(i);
        if (wc == child) goto L23;
        if (wc.isVisibleRequested() == false) goto L23;
        newVisReq = true;
    L23:
        i = i - 1;
        goto L17
    L11:
        if (this.mVisibleRequested == true) goto L13;
        newVisReq = true;
        goto L25
    L5:
        if (child.isVisibleRequested() == false) goto L7;
        childVisReq = true;
        goto L8
    }

    void writeIdentifierToProto(ProtoOutputStream proto, long fieldId) {
        long token = proto.start(fieldId);
        proto.write(1120986464257L, System.identityHashCode(this));
        proto.write(1120986464258L, ProcessList.INVALID_ADJ);
        proto.write(1138166333443L, "WindowContainer");
        proto.end(token);
    }

    boolean isFocusable() {
        WindowContainer parent = getParent();
        if (parent == null) goto L7;
        if (parent.isFocusable() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.mIsFocusable == false) goto L9;
        return true;
    }

    boolean setFocusable(boolean focusable) {
        if (this.mIsFocusable != focusable) goto L6;
        return false;
    L6:
        this.mIsFocusable = focusable;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean isOnTop() {
        WindowContainer r0 = getParent();
        if (r0 != 0) goto L5;
    L9:
        return false;
    L5:
        if (r0.getTopChild() != this) goto L9;
        if (r0.isOnTop() == false) goto L9;
        return true;
    }

    E getTopChild() {
        int n = this.mChildren.size();
        if (n != 0) goto L6;
        return null;
    L6:
        return this.mChildren.get(n - 1);
    }

    E getBottomChild() {
        int n = this.mChildren.size();
        if (n != 0) goto L6;
        return null;
    L6:
        return this.mChildren.get(0);
    }

    boolean handleCompleteDeferredRemoval() {
        boolean stillDeferringRemoval = false;
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L10;
        WindowContainer wc = this.mChildren.get(i);
        stillDeferringRemoval = stillDeferringRemoval | wc.handleCompleteDeferredRemoval();
        if (hasChild() == false) goto L6;
        i = i - 1;
        goto L3
    L6:
        return false;
    L10:
        return stillDeferringRemoval;
    }

    boolean onDescendantOrientationChanged(WindowContainer requestingContainer) {
        WindowContainer parent = getParent();
        if (parent != null) goto L7;
        return false;
    L7:
        return parent.onDescendantOrientationChanged(requestingContainer);
    }

    boolean handlesOrientationChangeFromDescendant(int orientation) {
        WindowContainer parent = getParent();
        if (parent != null) goto L5;
    L7:
        return false;
    L5:
        if (parent.handlesOrientationChangeFromDescendant(orientation) == false) goto L7;
        return true;
    }

    int getRequestedConfigurationOrientation() {
        return getRequestedConfigurationOrientation(false);
    }

    int getRequestedConfigurationOrientation(boolean forDisplay) {
        return getRequestedConfigurationOrientation(forDisplay, getOverrideOrientation());
    }

    int getRequestedConfigurationOrientation(boolean forDisplay, int requestedOrientation) {
        RootDisplayArea root = getRootDisplayArea();
        if (forDisplay == false) goto L9;
        if (root == null) goto L9;
        if (root.isOrientationDifferentFromDisplay() == false) goto L9;
        requestedOrientation = ActivityInfo.reverseOrientation(requestedOrientation);
    L9:
        if (requestedOrientation != 5) goto L15;
        if (this.mDisplayContent != null) goto L13;
        return 0;
    L13:
        return this.mDisplayContent.getNaturalConfigurationOrientation();
    L15:
        if (requestedOrientation != 14) goto L19;
        return getConfiguration().orientation;
    L19:
        if (ActivityInfo.isFixedOrientationLandscape(requestedOrientation) == false) goto L23;
        return 2;
    L23:
        if (ActivityInfo.isFixedOrientationPortrait(requestedOrientation) == false) goto L28;
        return 1;
    L28:
        return 0;
    }

    ActivityRecord getActivityBelowForDefiningOrientation(ActivityRecord from) {
        return getActivity(new WindowContainer$$ExternalSyntheticLambda2(), from, false, true);
    }

    protected void setOrientation(int orientation) {
        setOrientation(orientation, null);
    }

    int setOrientation(int requestedOrientation, WindowContainer requestingContainer) {
        if (getOverrideOrientation() != requestedOrientation) goto L5;
        return requestedOrientation;
    L5:
        setOverrideOrientation(requestedOrientation);
        WindowContainer parent = getParent();
        if (parent != null) goto L8;
        return requestedOrientation;
    L8:
        int actualOverrideOrientation = getOverrideOrientation();
        if (getConfiguration().orientation != getRequestedConfigurationOrientation(false, actualOverrideOrientation)) goto L11;
    L15:
        onDescendantOrientationChanged(requestingContainer);
        return actualOverrideOrientation;
    L11:
        if (inMultiWindowMode() == false) goto L13;
    L14:
        onConfigurationChanged(parent.getConfiguration());
        goto L15
    L13:
        if (handlesOrientationChangeFromDescendant(requestedOrientation) == true) goto L15;
        goto L14
    }

    int getOrientation() {
        return getOrientation(getOverrideOrientation());
    }

    int getOrientation(int candidate) {
        this.mLastOrientationSource = null;
        if (providesOrientation() == true) goto L6;
        return -2;
    L6:
        if (getOverrideOrientation() != (-2)) goto L8;
    L11:
        int i = this.mChildren.size() - 1;
    L12:
        if (i < 0) goto L33;
        WindowContainer wc = this.mChildren.get(i);
        if (candidate != 3) goto L16;
        int r6 = 3;
    L17:
        int orientation = wc.getOrientation(r6);
        if (orientation != 3) goto L20;
        candidate = orientation;
        this.mLastOrientationSource = wc;
    L26:
        i = i - 1;
        goto L12
    L20:
        if (orientation == (-2)) goto L26;
        if (orientation != (-1)) goto L28;
        if (wc.providesOrientation() == false) goto L26;
    L28:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L30;
        String protoLogParam0 = String.valueOf(wc.toString());
        long protoLogParam1 = orientation;
        String protoLogParam2 = String.valueOf(ActivityInfo.screenOrientationToString(orientation));
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, -5231580410559054259L, 4, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1), protoLogParam2});
    L30:
        this.mLastOrientationSource = wc;
        return orientation;
    L16:
        r6 = -2;
        goto L17
    L33:
        return candidate;
    L8:
        if (getOverrideOrientation() == (-1)) goto L11;
        this.mLastOrientationSource = this;
        return getOverrideOrientation();
    }

    protected int getOverrideOrientation() {
        return this.mOverrideOrientation;
    }

    protected void setOverrideOrientation(int orientation) {
        this.mOverrideOrientation = orientation;
    }

    final WindowContainer<?> getLastOrientationSource() {
        if (this.mLastOrientationSource != null) goto L6;
        return null;
    L6:
        WindowContainer r0 = this;
    L8:
        if (r0 == r0.mLastOrientationSource) goto L12;
        if (r0.mLastOrientationSource == null) goto L12;
        r0 = r0.mLastOrientationSource;
    L12:
        return r0;
    }

    boolean providesOrientation() {
        return fillsParent();
    }

    boolean fillsParent() {
        return false;
    }

    static int computeScreenLayout(int sourceScreenLayout, int screenWidthDp, int screenHeightDp) {
        int longSize = Math.max(screenWidthDp, screenHeightDp);
        int shortSize = Math.min(screenWidthDp, screenHeightDp);
        return Configuration.reduceScreenLayout(sourceScreenLayout & 63, longSize, shortSize);
    }

    void switchUser(int userId) {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L6;
        this.mChildren.get(i).switchUser(userId);
        i = i - 1;
        goto L3
    }

    boolean showToCurrentUser() {
        return true;
    }

    void forAllWindowContainers(Consumer<WindowContainer> callback) {
        callback.accept(this);
        int count = this.mChildren.size();
        int i = 0;
    L3:
        if (i >= count) goto L6;
        this.mChildren.get(i).forAllWindowContainers(callback);
        i = i + 1;
        goto L3
    }

    boolean forAllWindows(ToBooleanFunction<WindowState> callback, boolean traverseTopToBottom) {
        if (traverseTopToBottom == false) goto L11;
        int i = this.mChildren.size() - 1;
    L5:
        if (i < 0) goto L17;
        if (this.mChildren.get(i).forAllWindows(callback, traverseTopToBottom) == true) goto L8;
        i = i - 1;
        goto L5
    L8:
        return true;
    L17:
        return false;
    L11:
        int count = this.mChildren.size();
        int i2 = 0;
    L12:
        if (i2 >= count) goto L23;
        if (this.mChildren.get(i2).forAllWindows(callback, traverseTopToBottom) == true) goto L15;
        i2 = i2 + 1;
        goto L12
    L15:
        return true;
    L23:
        return false;
    }

    void forAllWindows(Consumer<WindowState> callback, boolean traverseTopToBottom) {
        WindowContainer<E>.ForAllWindowsConsumerWrapper wrapper = obtainConsumerWrapper(callback);
        forAllWindows(wrapper, traverseTopToBottom);
        wrapper.release();
    }

    boolean forAllActivities(Predicate<ActivityRecord> callback) {
        return forAllActivities(callback, true);
    }

    boolean forAllActivities(Predicate<ActivityRecord> callback, boolean traverseTopToBottom) {
        if (traverseTopToBottom == false) goto L11;
        int i = this.mChildren.size() - 1;
    L5:
        if (i < 0) goto L17;
        if (this.mChildren.get(i).forAllActivities(callback, traverseTopToBottom) == true) goto L8;
        i = i - 1;
        goto L5
    L8:
        return true;
    L17:
        return false;
    L11:
        int count = this.mChildren.size();
        int i2 = 0;
    L12:
        if (i2 >= count) goto L23;
        if (this.mChildren.get(i2).forAllActivities(callback, traverseTopToBottom) == true) goto L15;
        i2 = i2 + 1;
        goto L12
    L15:
        return true;
    L23:
        return false;
    }

    void forAllActivities(Consumer<ActivityRecord> callback) {
        forAllActivities(callback, true);
    }

    void forAllActivities(Consumer<ActivityRecord> callback, boolean traverseTopToBottom) {
        if (traverseTopToBottom == false) goto L7;
        int i = this.mChildren.size() - 1;
    L4:
        if (i < 0) goto L10;
        this.mChildren.get(i).forAllActivities(callback, traverseTopToBottom);
        i = i - 1;
        goto L4
    L10:
        return;
    L7:
        int count = this.mChildren.size();
        int i2 = 0;
    L8:
        if (i2 >= count) goto L13;
        this.mChildren.get(i2).forAllActivities(callback, traverseTopToBottom);
        i2 = i2 + 1;
        goto L8
    }

    final boolean forAllActivities(Predicate<ActivityRecord> callback, WindowContainer boundary, boolean includeBoundary, boolean traverseTopToBottom) {
        return forAllActivities(callback, boundary, includeBoundary, traverseTopToBottom, new boolean[1]);
    }

    private boolean forAllActivities(Predicate<ActivityRecord> callback, WindowContainer boundary, boolean includeBoundary, boolean traverseTopToBottom, boolean[] boundaryFound) {
        if (traverseTopToBottom == false) goto L11;
        int i = this.mChildren.size() - 1;
    L5:
        if (i < 0) goto L17;
        Predicate<ActivityRecord> callback2 = callback;
        WindowContainer boundary2 = boundary;
        boolean includeBoundary2 = includeBoundary;
        boolean traverseTopToBottom2 = traverseTopToBottom;
        boolean[] boundaryFound2 = boundaryFound;
        if (processForAllActivitiesWithBoundary(callback2, boundary2, includeBoundary2, traverseTopToBottom2, boundaryFound2, this.mChildren.get(i)) == true) goto L8;
        i = i - 1;
        callback = callback2;
        boundary = boundary2;
        includeBoundary = includeBoundary2;
        traverseTopToBottom = traverseTopToBottom2;
        boundaryFound = boundaryFound2;
        goto L5
    L8:
        return true;
    L17:
        return false;
    L11:
        WindowContainer<E> r2 = this;
        int count = r2.mChildren.size();
        int i2 = 0;
    L12:
        if (i2 >= count) goto L23;
        if (r2.processForAllActivitiesWithBoundary(callback, boundary, includeBoundary, traverseTopToBottom, boundaryFound, r2.mChildren.get(i2)) == true) goto L15;
        i2 = i2 + 1;
        r2 = this;
        goto L12
    L15:
        return true;
    L23:
        return false;
    }

    private boolean processForAllActivitiesWithBoundary(Predicate<ActivityRecord> callback, WindowContainer boundary, boolean includeBoundary, boolean traverseTopToBottom, boolean[] boundaryFound, WindowContainer wc) {
        if (wc != boundary) goto L8;
        boundaryFound[0] = true;
        if (includeBoundary == true) goto L8;
        return false;
    L8:
        if (boundaryFound[0] == false) goto L12;
        return wc.forAllActivities(callback, traverseTopToBottom);
    L12:
        return wc.forAllActivities(callback, boundary, includeBoundary, traverseTopToBottom, boundaryFound);
    }

    boolean hasActivity() {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L8;
        if (this.mChildren.get(i).hasActivity() == true) goto L6;
        i = i - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    ActivityRecord getActivity(Predicate<ActivityRecord> callback) {
        return getActivity(callback, true);
    }

    ActivityRecord getActivity(Predicate<ActivityRecord> callback, boolean traverseTopToBottom) {
        return getActivity(callback, traverseTopToBottom, null);
    }

    ActivityRecord getActivity(Predicate<ActivityRecord> callback, boolean traverseTopToBottom, ActivityRecord boundary) {
        if (traverseTopToBottom == false) goto L13;
        int i = this.mChildren.size() - 1;
    L4:
        if (i < 0) goto L22;
        WindowContainer wc = this.mChildren.get(i);
        if (wc == boundary) goto L7;
        ActivityRecord r = wc.getActivity(callback, traverseTopToBottom, boundary);
        if (r != null) goto L10;
        i = i - 1;
        goto L4
    L10:
        return r;
    L7:
        return boundary;
    L22:
        return null;
    L13:
        int count = this.mChildren.size();
        int i2 = 0;
    L14:
        if (i2 >= count) goto L30;
        WindowContainer wc2 = this.mChildren.get(i2);
        if (wc2 == boundary) goto L17;
        ActivityRecord r2 = wc2.getActivity(callback, traverseTopToBottom, boundary);
        if (r2 != null) goto L20;
        i2 = i2 + 1;
        goto L14
    L20:
        return r2;
    L17:
        return boundary;
    L30:
        return null;
    }

    final ActivityRecord getActivity(Predicate<ActivityRecord> callback, WindowContainer boundary, boolean includeBoundary, boolean traverseTopToBottom) {
        return getActivity(callback, boundary, includeBoundary, traverseTopToBottom, new boolean[1]);
    }

    private ActivityRecord getActivity(Predicate<ActivityRecord> callback, WindowContainer boundary, boolean includeBoundary, boolean traverseTopToBottom, boolean[] boundaryFound) {
        if (traverseTopToBottom == false) goto L10;
        int i = this.mChildren.size() - 1;
    L4:
        if (i < 0) goto L16;
        Predicate<ActivityRecord> callback2 = callback;
        WindowContainer boundary2 = boundary;
        boolean includeBoundary2 = includeBoundary;
        boolean traverseTopToBottom2 = traverseTopToBottom;
        boolean[] boundaryFound2 = boundaryFound;
        ActivityRecord r = processGetActivityWithBoundary(callback2, boundary2, includeBoundary2, traverseTopToBottom2, boundaryFound2, this.mChildren.get(i));
        if (r != null) goto L7;
        i = i - 1;
        callback = callback2;
        boundary = boundary2;
        includeBoundary = includeBoundary2;
        traverseTopToBottom = traverseTopToBottom2;
        boundaryFound = boundaryFound2;
        goto L4
    L7:
        return r;
    L16:
        return null;
    L10:
        WindowContainer<E> r1 = this;
        int count = r1.mChildren.size();
        int i2 = 0;
    L11:
        if (i2 >= count) goto L22;
        ActivityRecord r2 = r1.processGetActivityWithBoundary(callback, boundary, includeBoundary, traverseTopToBottom, boundaryFound, r1.mChildren.get(i2));
        if (r2 != null) goto L14;
        i2 = i2 + 1;
        r1 = this;
        goto L11
    L14:
        return r2;
    L22:
        return null;
    }

    int getDistanceFromTop(WindowContainer child) {
        int idx = this.mChildren.indexOf(child);
        if (idx >= 0) goto L6;
        return -1;
    L6:
        return (this.mChildren.size() - 1) - idx;
    }

    private ActivityRecord processGetActivityWithBoundary(Predicate<ActivityRecord> callback, WindowContainer boundary, boolean includeBoundary, boolean traverseTopToBottom, boolean[] boundaryFound, WindowContainer wc) {
        if (wc == boundary) goto L5;
        if (boundary == null) goto L5;
    L10:
        if (boundaryFound[0] == false) goto L14;
        return wc.getActivity(callback, traverseTopToBottom);
    L14:
        return wc.getActivity(callback, boundary, includeBoundary, traverseTopToBottom, boundaryFound);
    L5:
        boundaryFound[0] = true;
        if (includeBoundary == true) goto L10;
        return null;
    }

    static <T> Predicate<T> alwaysTruePredicate() {
        return AlwaysTruePredicate.INSTANCE;
    }

    ActivityRecord getActivityAbove(ActivityRecord r) {
        return getActivity(alwaysTruePredicate(), r, false, false);
    }

    ActivityRecord getActivityBelow(ActivityRecord r) {
        return getActivity(alwaysTruePredicate(), r, false, true);
    }

    ActivityRecord getBottomMostActivity() {
        return getActivity(alwaysTruePredicate(), false);
    }

    ActivityRecord getTopMostActivity() {
        return getActivity(alwaysTruePredicate(), true);
    }

    private static /* synthetic */ boolean lambda$getTopNonFinishingActivity$1(ActivityRecord r) {
        return !r.finishing;
    }

    ActivityRecord getTopNonFinishingActivity() {
        return getActivity(new WindowContainer$$ExternalSyntheticLambda1(), true);
    }

    private static /* synthetic */ boolean lambda$getTopMostFreeformActivity$2(ActivityRecord r) {
        if (r.isVisibleRequested() == true) goto L5;
    L7:
        return false;
    L5:
        if (r.inFreeformWindowingMode() == false) goto L7;
        return true;
    }

    ActivityRecord getTopMostFreeformActivity() {
        return getActivity(new WindowContainer$$ExternalSyntheticLambda9(), true);
    }

    private static /* synthetic */ boolean lambda$getTopMostVisibleFreeformActivity$3(ActivityRecord r) {
        if (r.isVisible() == true) goto L5;
    L7:
        return false;
    L5:
        if (r.inFreeformWindowingMode() == false) goto L7;
        return true;
    }

    ActivityRecord getTopMostVisibleFreeformActivity() {
        return getActivity(new WindowContainer$$ExternalSyntheticLambda0(), true);
    }

    ActivityRecord getTopActivity(boolean includeFinishing, boolean includeOverlays) {
        if (includeFinishing == false) goto L8;
        if (includeOverlays == false) goto L7;
        return getActivity(alwaysTruePredicate());
    L7:
        return getActivity(new WindowContainer$$ExternalSyntheticLambda3());
    L8:
        if (includeOverlays == false) goto L12;
        return getActivity(new WindowContainer$$ExternalSyntheticLambda4());
    L12:
        return getActivity(new WindowContainer$$ExternalSyntheticLambda5());
    }

    private static /* synthetic */ boolean lambda$getTopActivity$4(ActivityRecord r) {
        return !r.isTaskOverlay();
    }

    private static /* synthetic */ boolean lambda$getTopActivity$5(ActivityRecord r) {
        return !r.finishing;
    }

    private static /* synthetic */ boolean lambda$getTopActivity$6(ActivityRecord r) {
        if (r.finishing == false) goto L5;
    L7:
        return false;
    L5:
        if (r.isTaskOverlay() == true) goto L7;
        return true;
    }

    boolean forAllTasks(Predicate<Task> callback) {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L8;
        if (this.mChildren.get(i).forAllTasks(callback) == true) goto L6;
        i = i - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    boolean forAllLeafTasks(Predicate<Task> callback) {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L8;
        if (this.mChildren.get(i).forAllLeafTasks(callback) == true) goto L6;
        i = i - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    boolean forAllLeafTaskFragments(Predicate<TaskFragment> callback) {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L8;
        if (this.mChildren.get(i).forAllLeafTaskFragments(callback) == true) goto L6;
        i = i - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    boolean forAllRootTasks(Predicate<Task> callback) {
        return forAllRootTasks(callback, true);
    }

    boolean forAllRootTasks(Predicate<Task> callback, boolean traverseTopToBottom) {
        int count = this.mChildren.size();
        if (traverseTopToBottom == false) goto L11;
        int i = count - 1;
    L5:
        if (i < 0) goto L17;
        if (this.mChildren.get(i).forAllRootTasks(callback, traverseTopToBottom) == true) goto L8;
        i = i - 1;
        goto L5
    L8:
        return true;
    L17:
        return false;
    L11:
        int i2 = 0;
    L12:
        if (i2 >= count) goto L23;
        if (this.mChildren.get(i2).forAllRootTasks(callback, traverseTopToBottom) == true) goto L15;
        int newCount = this.mChildren.size();
        int i3 = i2 - (count - newCount);
        count = newCount;
        i2 = i3 + 1;
        goto L12
    L15:
        return true;
    L23:
        return false;
    }

    void forAllTasks(Consumer<Task> callback) {
        forAllTasks(callback, true);
    }

    void forAllTasks(Consumer<Task> callback, boolean traverseTopToBottom) {
        int count = this.mChildren.size();
        if (traverseTopToBottom == false) goto L8;
        int i = count - 1;
    L5:
        if (i < 0) goto L11;
        this.mChildren.get(i).forAllTasks(callback, traverseTopToBottom);
        i = i - 1;
        goto L5
    L11:
        return;
    L8:
        int i2 = 0;
    L9:
        if (i2 >= count) goto L14;
        this.mChildren.get(i2).forAllTasks(callback, traverseTopToBottom);
        i2 = i2 + 1;
        goto L9
    }

    void forAllTaskFragments(Consumer<TaskFragment> callback) {
        forAllTaskFragments(callback, true);
    }

    void forAllTaskFragments(Consumer<TaskFragment> callback, boolean traverseTopToBottom) {
        int count = this.mChildren.size();
        if (traverseTopToBottom == false) goto L8;
        int i = count - 1;
    L5:
        if (i < 0) goto L11;
        this.mChildren.get(i).forAllTaskFragments(callback, traverseTopToBottom);
        i = i - 1;
        goto L5
    L11:
        return;
    L8:
        int i2 = 0;
    L9:
        if (i2 >= count) goto L14;
        this.mChildren.get(i2).forAllTaskFragments(callback, traverseTopToBottom);
        i2 = i2 + 1;
        goto L9
    }

    void forAllLeafTasks(Consumer<Task> callback, boolean traverseTopToBottom) {
        int count = this.mChildren.size();
        if (traverseTopToBottom == false) goto L8;
        int i = count - 1;
    L5:
        if (i < 0) goto L11;
        this.mChildren.get(i).forAllLeafTasks(callback, traverseTopToBottom);
        i = i - 1;
        goto L5
    L11:
        return;
    L8:
        int i2 = 0;
    L9:
        if (i2 >= count) goto L14;
        this.mChildren.get(i2).forAllLeafTasks(callback, traverseTopToBottom);
        i2 = i2 + 1;
        goto L9
    }

    void forAllLeafTaskFragments(Consumer<TaskFragment> callback, boolean traverseTopToBottom) {
        int count = this.mChildren.size();
        if (traverseTopToBottom == false) goto L8;
        int i = count - 1;
    L5:
        if (i < 0) goto L11;
        this.mChildren.get(i).forAllLeafTaskFragments(callback, traverseTopToBottom);
        i = i - 1;
        goto L5
    L11:
        return;
    L8:
        int i2 = 0;
    L9:
        if (i2 >= count) goto L14;
        this.mChildren.get(i2).forAllLeafTaskFragments(callback, traverseTopToBottom);
        i2 = i2 + 1;
        goto L9
    }

    void forAllRootTasks(Consumer<Task> callback) {
        forAllRootTasks(callback, true);
    }

    void forAllRootTasks(Consumer<Task> callback, boolean traverseTopToBottom) {
        int count = this.mChildren.size();
        if (traverseTopToBottom == false) goto L8;
        int i = count - 1;
    L5:
        if (i < 0) goto L11;
        this.mChildren.get(i).forAllRootTasks(callback, traverseTopToBottom);
        i = i - 1;
        goto L5
    L11:
        return;
    L8:
        int i2 = 0;
    L9:
        if (i2 >= count) goto L14;
        this.mChildren.get(i2).forAllRootTasks(callback, traverseTopToBottom);
        int newCount = this.mChildren.size();
        int i3 = i2 - (count - newCount);
        count = newCount;
        i2 = i3 + 1;
        goto L9
    }

    Task getTaskBelow(Task t) {
        return getTask(alwaysTruePredicate(), t, false, true);
    }

    Task getBottomMostTask() {
        return getTask(alwaysTruePredicate(), false);
    }

    Task getTopMostTask() {
        return getTask(alwaysTruePredicate(), true);
    }

    Task getTask(Predicate<Task> callback) {
        return getTask(callback, true);
    }

    Task getTask(Predicate<Task> callback, boolean traverseTopToBottom) {
        if (traverseTopToBottom == false) goto L10;
        int i = this.mChildren.size() - 1;
    L4:
        if (i < 0) goto L16;
        Task t = this.mChildren.get(i).getTask(callback, traverseTopToBottom);
        if (t != null) goto L7;
        i = i - 1;
        goto L4
    L7:
        return t;
    L16:
        return null;
    L10:
        int count = this.mChildren.size();
        int i2 = 0;
    L11:
        if (i2 >= count) goto L22;
        Task t2 = this.mChildren.get(i2).getTask(callback, traverseTopToBottom);
        if (t2 != null) goto L14;
        i2 = i2 + 1;
        goto L11
    L14:
        return t2;
    L22:
        return null;
    }

    final Task getTask(Predicate<Task> callback, WindowContainer boundary, boolean includeBoundary, boolean traverseTopToBottom) {
        return getTask(callback, boundary, includeBoundary, traverseTopToBottom, new boolean[1]);
    }

    private Task getTask(Predicate<Task> callback, WindowContainer boundary, boolean includeBoundary, boolean traverseTopToBottom, boolean[] boundaryFound) {
        if (traverseTopToBottom == false) goto L10;
        int i = this.mChildren.size() - 1;
    L4:
        if (i < 0) goto L16;
        Predicate<Task> callback2 = callback;
        WindowContainer boundary2 = boundary;
        boolean includeBoundary2 = includeBoundary;
        boolean traverseTopToBottom2 = traverseTopToBottom;
        boolean[] boundaryFound2 = boundaryFound;
        Task t = processGetTaskWithBoundary(callback2, boundary2, includeBoundary2, traverseTopToBottom2, boundaryFound2, this.mChildren.get(i));
        if (t != null) goto L7;
        i = i - 1;
        callback = callback2;
        boundary = boundary2;
        includeBoundary = includeBoundary2;
        traverseTopToBottom = traverseTopToBottom2;
        boundaryFound = boundaryFound2;
        goto L4
    L7:
        return t;
    L16:
        return null;
    L10:
        WindowContainer<E> r1 = this;
        int count = r1.mChildren.size();
        int i2 = 0;
    L11:
        if (i2 >= count) goto L22;
        Task t2 = r1.processGetTaskWithBoundary(callback, boundary, includeBoundary, traverseTopToBottom, boundaryFound, r1.mChildren.get(i2));
        if (t2 != null) goto L14;
        i2 = i2 + 1;
        r1 = this;
        goto L11
    L14:
        return t2;
    L22:
        return null;
    }

    Task getRootTask(Predicate<Task> callback) {
        return getRootTask(callback, true);
    }

    Task getRootTask(Predicate<Task> callback, boolean traverseTopToBottom) {
        int count = this.mChildren.size();
        if (traverseTopToBottom == false) goto L11;
        int i = count - 1;
    L5:
        if (i < 0) goto L17;
        Task t = this.mChildren.get(i).getRootTask(callback, traverseTopToBottom);
        if (t != null) goto L8;
        i = i - 1;
        goto L5
    L8:
        return t;
    L17:
        return null;
    L11:
        int i2 = 0;
    L12:
        if (i2 >= count) goto L23;
        Task t2 = this.mChildren.get(i2).getRootTask(callback, traverseTopToBottom);
        if (t2 != null) goto L15;
        int newCount = this.mChildren.size();
        int i3 = i2 - (count - newCount);
        count = newCount;
        i2 = i3 + 1;
        goto L12
    L15:
        return t2;
    L23:
        return null;
    }

    private Task processGetTaskWithBoundary(Predicate<Task> callback, WindowContainer boundary, boolean includeBoundary, boolean traverseTopToBottom, boolean[] boundaryFound, WindowContainer wc) {
        if (wc == boundary) goto L5;
        if (boundary == null) goto L5;
    L10:
        if (boundaryFound[0] == false) goto L14;
        return wc.getTask(callback, traverseTopToBottom);
    L14:
        return wc.getTask(callback, boundary, includeBoundary, traverseTopToBottom, boundaryFound);
    L5:
        boundaryFound[0] = true;
        if (includeBoundary == true) goto L10;
        return null;
    }

    TaskFragment getTaskFragment(Predicate<TaskFragment> callback) {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L8;
        TaskFragment tf = this.mChildren.get(i).getTaskFragment(callback);
        if (tf != null) goto L6;
        i = i - 1;
        goto L3
    L6:
        return tf;
    L8:
        return null;
    }

    WindowState getWindow(Predicate<WindowState> callback) {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L8;
        WindowState w = this.mChildren.get(i).getWindow(callback);
        if (w != null) goto L6;
        i = i - 1;
        goto L3
    L6:
        return w;
    L8:
        return null;
    }

    void forAllDisplayAreas(Consumer<DisplayArea> callback) {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L6;
        this.mChildren.get(i).forAllDisplayAreas(callback);
        i = i - 1;
        goto L3
    }

    boolean forAllTaskDisplayAreas(Predicate<TaskDisplayArea> callback, boolean traverseTopToBottom) {
        int childCount = this.mChildren.size();
        if (traverseTopToBottom == false) goto L5;
        int i = childCount - 1;
    L6:
        if (i < 0) goto L14;
        if (i >= childCount) goto L14;
        int r4 = 1;
        if (this.mChildren.get(i).forAllTaskDisplayAreas(callback, traverseTopToBottom) == true) goto L10;
        if (traverseTopToBottom == false) goto L13;
        r4 = -1;
    L13:
        i = i + r4;
        goto L6
    L10:
        return true;
    L14:
        return false;
    L5:
        i = 0;
        goto L6
    }

    boolean forAllTaskDisplayAreas(Predicate<TaskDisplayArea> callback) {
        return forAllTaskDisplayAreas(callback, true);
    }

    void forAllTaskDisplayAreas(Consumer<TaskDisplayArea> callback, boolean traverseTopToBottom) {
        int childCount = this.mChildren.size();
        if (traverseTopToBottom == false) goto L5;
        int i = childCount - 1;
    L6:
        if (i < 0) goto L13;
        if (i >= childCount) goto L19;
        this.mChildren.get(i).forAllTaskDisplayAreas(callback, traverseTopToBottom);
        if (traverseTopToBottom == false) goto L11;
        int r2 = -1;
    L12:
        i = i + r2;
        goto L6
    L11:
        r2 = 1;
        goto L12
    L19:
        return;
    L13:
        return;
    L5:
        i = 0;
        goto L6
    }

    void forAllTaskDisplayAreas(Consumer<TaskDisplayArea> callback) {
        forAllTaskDisplayAreas(callback, true);
    }

    <R> R reduceOnAllTaskDisplayAreas(BiFunction<TaskDisplayArea, R, R> r5, R r6, boolean r7) {
        int r0 = this.mChildren.size();
        if (r7 == false) goto L5;
        int r1 = r0 - 1;
    L6:
        R r2 = r6;
    L7:
        if (r1 < 0) goto L14;
        if (r1 >= r0) goto L14;
        r2 = (R) this.mChildren.get(r1).reduceOnAllTaskDisplayAreas(r5, r2, r7);
        if (r7 == false) goto L12;
        int r3 = -1;
    L13:
        r1 = r1 + r3;
        goto L7
    L12:
        r3 = 1;
    L14:
        return r2;
    L5:
        r1 = 0;
        goto L6
    }

    <R> R reduceOnAllTaskDisplayAreas(BiFunction<TaskDisplayArea, R, R> r2, R r3) {
        return (R) reduceOnAllTaskDisplayAreas(r2, r3, true);
    }

    <R> R getItemFromDisplayAreas(Function<DisplayArea, R> r3) {
        int r0 = this.mChildren.size() - 1;
    L3:
        if (r0 < 0) goto L8;
        R r1 = (R) this.mChildren.get(r0).getItemFromDisplayAreas(r3);
        if (r1 != null) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        return r1;
    L8:
        return null;
    }

    <R> R getItemFromTaskDisplayAreas(Function<TaskDisplayArea, R> r5, boolean r6) {
        int r0 = this.mChildren.size();
        if (r6 == false) goto L5;
        int r1 = r0 - 1;
    L6:
        if (r1 < 0) goto L15;
        if (r1 >= r0) goto L23;
        R r2 = (R) this.mChildren.get(r1).getItemFromTaskDisplayAreas(r5, r6);
        if (r2 != null) goto L10;
        if (r6 == false) goto L13;
        int r3 = -1;
    L14:
        r1 = r1 + r3;
        goto L6
    L13:
        r3 = 1;
        goto L14
    L10:
        return r2;
    L23:
        return null;
    L15:
        return null;
    L5:
        r1 = 0;
        goto L6
    }

    <R> R getItemFromTaskDisplayAreas(Function<TaskDisplayArea, R> r2) {
        return (R) getItemFromTaskDisplayAreas(r2, true);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    public int compareTo(WindowContainer other) {
        if (this != other) goto L5;
        return 0;
    L5:
        int r1 = -1;
        if (this.mParent != null) goto L8;
    L13:
        LinkedList<WindowContainer> thisParentChain = this.mTmpChain1;
        LinkedList<WindowContainer> otherParentChain = this.mTmpChain2;
        getParents(thisParentChain);     // Catch: Throwable -> L19
        other.getParents(otherParentChain);     // Catch: Throwable -> L19
        WindowContainer commonAncestor = null;
        WindowContainer thisTop = thisParentChain.peekLast();     // Catch: Throwable -> L19
        WindowContainer otherTop = otherParentChain.peekLast();     // Catch: Throwable -> L19
    L15:
        if (thisTop == null) goto L21;
        if (otherTop == null) goto L21;
        if (thisTop != otherTop) goto L21;
        commonAncestor = thisParentChain.removeLast();     // Catch: Throwable -> L19
        otherParentChain.removeLast();     // Catch: Throwable -> L19
        thisTop = thisParentChain.peekLast();     // Catch: Throwable -> L19
        otherTop = otherParentChain.peekLast();     // Catch: Throwable -> L19
    L21:
        if (commonAncestor != null) goto L25;
        int thisZ = getPrefixOrderIndex();     // Catch: Throwable -> L19
        int otherZ = other.getPrefixOrderIndex();     // Catch: Throwable -> L19
        Slog.w(TAG, "Compare not in the same hierarchy this=" + thisParentChain + " thisZ=" + thisZ + " other=" + otherParentChain + " otherZ=" + otherZ);     // Catch: Throwable -> L19
        int r7 = Integer.compare(thisZ, otherZ);     // Catch: Throwable -> L19
        this.mTmpChain1.clear();
        this.mTmpChain2.clear();
        return r7;
    L25:
        if (commonAncestor != this) goto L28;
        this.mTmpChain1.clear();
        this.mTmpChain2.clear();
        return -1;
    L28:
        if (commonAncestor != other) goto L31;
        this.mTmpChain1.clear();
        this.mTmpChain2.clear();
        return 1;
    L31:
        ArrayList<WindowContainer> list = commonAncestor.mChildren;     // Catch: Throwable -> L19
        if (list.indexOf(thisParentChain.peekLast()) <= list.indexOf(otherParentChain.peekLast())) goto L35;
        r1 = 1;
    L35:
        this.mTmpChain1.clear();
        this.mTmpChain2.clear();
        return r1;
    L19:
        th = move-exception;
        this.mTmpChain1.clear();
        this.mTmpChain2.clear();
        throw th;
    L8:
        if (this.mParent != other.mParent) goto L13;
        ArrayList<WindowContainer> list2 = this.mParent.mChildren;
        if (list2.indexOf(this) > list2.indexOf(other)) goto L12;
        return -1;
    L12:
        return 1;
    }

    private void getParents(LinkedList<WindowContainer> parents) {
        parents.clear();
        WindowContainer<WindowContainer> r0 = this;
    L3:
        parents.addLast(r0);
        r0 = r0.mParent;
        if (r0 != null) goto L3;
    }

    SurfaceControl.Builder makeSurface() {
        WindowContainer p = getParent();
        return p.makeChildSurface(this);
    }

    SurfaceControl.Builder makeChildSurface(WindowContainer child) {
        WindowContainer p = getParent();
        return p.makeChildSurface(child).setParent(this.mSurfaceControl);
    }

    public SurfaceControl getParentSurfaceControl() {
        WindowContainer parent = getParent();
        if (parent != null) goto L7;
        return null;
    L7:
        return parent.getSurfaceControl();
    }

    boolean shouldMagnify() {
        if (this.mSurfaceControl != null) goto L5;
        return false;
    L5:
        int i = 0;
    L7:
        if (i >= this.mChildren.size()) goto L12;
        if (this.mChildren.get(i).shouldMagnify() == false) goto L10;
        i = i + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    void assignLayer(SurfaceControl.Transaction t, int layer) {
        if (this.mTransitionController.canAssignLayers(this) == true) goto L6;
        return;
    L6:
        if (layer == this.mLastLayer) goto L8;
    L11:
        boolean changed = true;
    L13:
        if (this.mSurfaceControl == null) goto L20;
        if (changed == true) goto L16;
        return;
    L16:
        if (this.mSyncState == 0) goto L18;
        t = getSyncTransaction();
    L18:
        setLayer(t, layer);
        this.mLastLayer = layer;
        this.mLastRelativeToLayer = null;
        return;
    L20:
        return;
    L8:
        if (this.mLastRelativeToLayer != null) goto L11;
        changed = false;
        goto L13
    }

    void assignRelativeLayer(SurfaceControl.Transaction t, SurfaceControl relativeTo, int layer, boolean forceUpdate) {
        if (layer == this.mLastLayer) goto L5;
    L8:
        boolean changed = true;
    L10:
        if (this.mSurfaceControl == null) goto L18;
        if (changed == true) goto L14;
        if (forceUpdate == true) goto L14;
        return;
    L14:
        if (this.mSyncState == 0) goto L16;
        t = getSyncTransaction();
    L16:
        setRelativeLayer(t, relativeTo, layer);
        this.mLastLayer = layer;
        this.mLastRelativeToLayer = relativeTo;
        return;
    L18:
        return;
    L5:
        if (this.mLastRelativeToLayer != relativeTo) goto L8;
        changed = false;
        goto L10
    }

    void assignRelativeLayer(SurfaceControl.Transaction t, SurfaceControl relativeTo, int layer) {
        assignRelativeLayer(t, relativeTo, layer, false);
    }

    protected void setLayer(SurfaceControl.Transaction t, int layer) {
        this.mSurfaceAnimator.setLayer(t, layer);
    }

    int getLastLayer() {
        return this.mLastLayer;
    }

    SurfaceControl getLastRelativeLayer() {
        return this.mLastRelativeToLayer;
    }

    protected void setRelativeLayer(SurfaceControl.Transaction t, SurfaceControl relativeTo, int layer) {
        this.mSurfaceAnimator.setRelativeLayer(t, relativeTo, layer);
    }

    protected void reparentSurfaceControl(SurfaceControl.Transaction t, SurfaceControl newParent) {
        if (this.mSurfaceAnimator.hasLeash() == false) goto L5;
        return;
    L5:
        t.reparent(getSurfaceControl(), newParent);
    }

    void assignChildLayers(SurfaceControl.Transaction t) {
        int layer = 0;
        int j = 0;
    L4:
        if (j >= this.mChildren.size()) goto L7;
        WindowContainer wc = this.mChildren.get(j);
        wc.assignChildLayers(t);
        wc.assignLayer(t, layer);
        j = j + 1;
        layer = layer + 1;
        goto L4
    L7:
        if (this.mOverlayHost == null) goto L11;
        int r2 = layer + 1;
        this.mOverlayHost.setLayer(t, layer);
        return;
    }

    void assignChildLayers() {
        assignChildLayers(getSyncTransaction());
        scheduleAnimation();
    }

    @Override // com.android.server.wm.ConfigurationContainer
    public void dumpDebug(ProtoOutputStream proto, long fieldId, int logLevel) {
        boolean isVisible = isVisible();
        if (logLevel != 2) goto L6;
        if (isVisible == true) goto L6;
        return;
    L6:
        long token = proto.start(fieldId);
        super.dumpDebug(proto, 1146756268033L, logLevel);
        proto.write(1120986464258L, this.mOverrideOrientation);
        proto.write(1133871366147L, isVisible);
        writeIdentifierToProto(proto, 1146756268038L);
        if (this.mSurfaceAnimator.isAnimating() == false) goto L10;
        this.mSurfaceAnimator.dumpDebug(proto, 1146756268036L);
    L10:
        if (this.mSurfaceControl == null) goto L12;
        this.mSurfaceControl.dumpDebug(proto, 1146756268039L);
    L12:
        int i = 0;
    L14:
        if (i >= getChildCount()) goto L16;
        long childToken = proto.start(2246267895813L);
        WindowContainer r6 = getChildAt(i);
        r6.dumpDebug(proto, r6.getProtoFieldId(), logLevel);
        proto.end(childToken);
        i = i + 1;
        goto L14
    L16:
        proto.end(token);
    }

    long getProtoFieldId() {
        return 1146756268034L;
    }

    private WindowContainer<E>.ForAllWindowsConsumerWrapper obtainConsumerWrapper(Consumer<WindowState> consumer) {
        WindowContainer<E>.ForAllWindowsConsumerWrapper wrapper = (ForAllWindowsConsumerWrapper) this.mConsumerWrapperPool.acquire();
        if (wrapper != null) goto L5;
        wrapper = new ForAllWindowsConsumerWrapper(this, null);
    L5:
        wrapper.setConsumer(consumer);
        return wrapper;
    }

    void applyMagnificationSpec(SurfaceControl.Transaction t, MagnificationSpec spec) {
        if (shouldMagnify() == false) goto L5;
        t.setMatrix(this.mSurfaceControl, spec.scale, 0.0f, 0.0f, spec.scale).setPosition(this.mSurfaceControl, spec.offsetX + this.mLastSurfacePosition.x, spec.offsetY + this.mLastSurfacePosition.y);
        this.mLastMagnificationSpec = spec;
        return;
    L5:
        clearMagnificationSpec(t);
        int i = 0;
    L7:
        if (i >= this.mChildren.size()) goto L11;
        this.mChildren.get(i).applyMagnificationSpec(t, spec);
        i = i + 1;
        goto L7
    }

    void clearMagnificationSpec(SurfaceControl.Transaction t) {
        if (this.mLastMagnificationSpec == null) goto L5;
        SurfaceControl.Transaction t2 = t;
        t2.setMatrix(this.mSurfaceControl, 1.0f, 0.0f, 0.0f, 1.0f).setPosition(this.mSurfaceControl, this.mLastSurfacePosition.x, this.mLastSurfacePosition.y);
    L6:
        this.mLastMagnificationSpec = null;
        int i = 0;
    L8:
        if (i >= this.mChildren.size()) goto L11;
        this.mChildren.get(i).clearMagnificationSpec(t2);
        i = i + 1;
        goto L8
    L11:
        return;
    L5:
        t2 = t;
        goto L6
    }

    void prepareSurfaces() {
        int i = 0;
    L4:
        if (i >= this.mChildren.size()) goto L7;
        this.mChildren.get(i).prepareSurfaces();
        i = i + 1;
        goto L4
    }

    void adjustDims() {
        int i = 0;
    L4:
        if (i >= this.mChildren.size()) goto L7;
        this.mChildren.get(i).adjustDims();
        i = i + 1;
        goto L4
    }

    void scheduleAnimation() {
        this.mWmService.scheduleAnimationLocked();
    }

    public SurfaceControl getSurfaceControl() {
        return this.mSurfaceControl;
    }

    public SurfaceControl.Transaction getSyncTransaction() {
        if (this.mSyncTransactionCommitCallbackDepth <= 0) goto L7;
        return this.mSyncTransaction;
    L7:
        if (this.mSyncState == 0) goto L11;
        return this.mSyncTransaction;
    L11:
        return getPendingTransaction();
    }

    public SurfaceControl.Transaction getPendingTransaction() {
        WindowContainer<?> dc = this.mDisplayContent;
        if (dc == null) goto L9;
        if (dc.mPendingTransaction == null) goto L9;
        return dc.mPendingTransaction;
    L9:
        if (this.mPendingTransaction != null) goto L12;
        this.mPendingTransaction = this.mWmService.mTransactionFactory.get();
    L12:
        return this.mPendingTransaction;
    }

    void startAnimation(SurfaceControl.Transaction t, AnimationAdapter anim, boolean hidden, int type, SurfaceAnimator.OnAnimationFinishedCallback animationFinishedCallback, Runnable animationCancelledCallback, AnimationAdapter snapshotAnim) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ANIM_enabled[1] == false) goto L5;
        String protoLogParam0 = String.valueOf(this);
        long protoLogParam1 = type;
        String protoLogParam2 = String.valueOf(anim);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ANIM, 6949303417875346627L, 4, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1), protoLogParam2});
    L5:
        this.mSurfaceAnimator.startAnimation(t, anim, hidden, type, animationFinishedCallback, animationCancelledCallback, snapshotAnim);
    }

    void startAnimation(SurfaceControl.Transaction t, AnimationAdapter anim, boolean hidden, int type, SurfaceAnimator.OnAnimationFinishedCallback animationFinishedCallback) {
        startAnimation(t, anim, hidden, type, animationFinishedCallback, null, null);
    }

    void startAnimation(SurfaceControl.Transaction t, AnimationAdapter anim, boolean hidden, int type) {
        startAnimation(t, anim, hidden, type, null);
    }

    void transferAnimation(WindowContainer from) {
        this.mSurfaceAnimator.transferAnimation(from.mSurfaceAnimator);
    }

    void cancelAnimation() {
        this.mSurfaceAnimator.cancelAnimation();
    }

    boolean canStartChangeTransition() {
        if (this.mWmService.mDisableTransitionAnimation == false) goto L5;
    L26:
        return false;
    L5:
        if (okToAnimate() == false) goto L26;
        if (this.mDisplayContent != null) goto L10;
    L25:
        return false;
    L10:
        if (getSurfaceControl() == null) goto L25;
        if (isVisible() == false) goto L25;
        if (isVisibleRequested() == false) goto L25;
        if (this.mDisplayContent.inTransition() == false) goto L20;
        return false;
    L20:
        if (ActivityTaskManagerService.isPip2ExperimentEnabled() == false) goto L22;
    L23:
        return true;
    L22:
        if (isPipChange() == false) goto L23;
        return false;
    }

    private boolean isPipChange() {
        if (asTaskFragment() != null) goto L5;
    L9:
        boolean isExitingPip = false;
    L11:
        if (isExitingPip == true) goto L19;
        if (inPinnedWindowingMode() == true) goto L19;
        if (getParent() != null) goto L17;
        return false;
    L17:
        if (getParent().inPinnedWindowingMode() == true) goto L19;
        return false;
    L19:
        return true;
    L5:
        if (this.mTransitionController.getWindowingModeAtStart(this) != 2) goto L9;
        if (inPinnedWindowingMode() == true) goto L9;
        isExitingPip = true;
        goto L11
    }

    public SurfaceControl.Builder makeAnimationLeash() {
        return makeSurface().setContainerLayer();
    }

    public SurfaceControl getAnimationLeashParent() {
        return getParentSurfaceControl();
    }

    Rect getAnimationBounds(int appRootTaskClipMode) {
        return getBounds();
    }

    void getAnimationPosition(Point outPosition) {
        getRelativePosition(outPosition);
    }

    final SurfaceAnimationRunner getSurfaceAnimationRunner() {
        return this.mWmService.mSurfaceAnimationRunner;
    }

    boolean canCreateRemoteAnimationTarget() {
        return false;
    }

    boolean okToDisplay() {
        DisplayContent dc = getDisplayContent();
        if (dc != null) goto L5;
    L7:
        return false;
    L5:
        if (dc.okToDisplay() == false) goto L7;
        return true;
    }

    boolean okToAnimate() {
        return okToAnimate(false, false);
    }

    boolean okToAnimate(boolean ignoreFrozen, boolean ignoreScreenOn) {
        DisplayContent dc = getDisplayContent();
        if (dc != null) goto L5;
    L7:
        return false;
    L5:
        if (dc.okToAnimate(ignoreFrozen, ignoreScreenOn) == false) goto L7;
        return true;
    }

    public void commitPendingTransaction() {
        scheduleAnimation();
    }

    void transformFrameToSurfacePosition(int left, int top, Point outPoint) {
        outPoint.set(left, top);
        WindowContainer parentWindowContainer = getParent();
        if (parentWindowContainer != null) goto L5;
        return;
    L5:
        Rect parentBounds = parentWindowContainer.getBounds();
        outPoint.offset(-parentBounds.left, -parentBounds.top);
    }

    void reassignLayer(SurfaceControl.Transaction t) {
        WindowContainer parent = getParent();
        if (parent == null) goto L6;
        parent.assignChildLayers(t);
        return;
    }

    void resetSurfacePositionForAnimationLeash(SurfaceControl.Transaction t) {
        t.setPosition(this.mSurfaceControl, 0.0f, 0.0f);
        SurfaceControl.Transaction syncTransaction = getSyncTransaction();
        if (t == syncTransaction) goto L5;
        syncTransaction.setPosition(this.mSurfaceControl, 0.0f, 0.0f);
    L5:
        this.mLastSurfacePosition.set(0, 0);
    }

    public void onAnimationLeashCreated(SurfaceControl.Transaction t, SurfaceControl leash) {
        this.mLastLayer = -1;
        this.mAnimationLeash = leash;
        reassignLayer(t);
        resetSurfacePositionForAnimationLeash(t);
    }

    public void onAnimationLeashLost(SurfaceControl.Transaction t) {
        this.mLastLayer = -1;
        this.mAnimationLeash = null;
        reassignLayer(t);
        updateSurfacePosition(t);
    }

    public SurfaceControl getAnimationLeash() {
        return this.mAnimationLeash;
    }

    protected void onAnimationFinished(int type, AnimationAdapter anim) {
        this.mWmService.onAnimationFinished();
    }

    AnimationAdapter getAnimation() {
        return this.mSurfaceAnimator.getAnimation();
    }

    WindowContainer getAnimatingContainer(int flags, int typesToCheck) {
        if (isSelfAnimating(flags, typesToCheck) == false) goto L6;
        return this;
    L6:
        if ((flags & 2) == 0) goto L14;
        WindowContainer parent = getParent();
    L8:
        if (parent == null) goto L14;
        if (parent.isSelfAnimating(flags, typesToCheck) == true) goto L11;
        parent = parent.getParent();
        goto L8
    L11:
        return parent;
    L14:
        if ((flags & 4) == 0) goto L22;
        int i = 0;
    L17:
        if (i >= this.mChildren.size()) goto L28;
        WindowContainer wc = this.mChildren.get(i).getAnimatingContainer(flags & (-3), typesToCheck);
        if (wc != null) goto L20;
        i = i + 1;
        goto L17
    L20:
        return wc;
    L28:
        return null;
    L22:
        return null;
    }

    protected boolean isSelfAnimating(int flags, int typesToCheck) {
        if (this.mSurfaceAnimator.isAnimating() == true) goto L5;
        return false;
    L5:
        if ((this.mSurfaceAnimator.getAnimationType() & typesToCheck) <= 0) goto L10;
        return true;
    L10:
        return false;
    }

    @Deprecated
    final WindowContainer getAnimatingContainer() {
        return getAnimatingContainer(2, -1);
    }

    public int getSurfaceWidth() {
        return this.mSurfaceControl.getWidth();
    }

    public int getSurfaceHeight() {
        return this.mSurfaceControl.getHeight();
    }

    static void enforceSurfaceVisible(WindowContainer<?> wc) {
        if (wc.mSurfaceControl != null) goto L5;
        return;
    L5:
        wc.getSyncTransaction().show(wc.mSurfaceControl);
        ActivityRecord ar = wc.asActivityRecord();
        if (ar == null) goto L8;
        ar.mLastSurfaceShowing = true;
    L8:
        WindowContainer<?> p = wc.getParent();
    L9:
        if (p == null) goto L18;
        if (p == wc.mDisplayContent) goto L18;
        if (p.mSurfaceControl == null) goto L17;
        p.getSyncTransaction().show(p.mSurfaceControl);
        Task task = p.asTask();
        if (task == null) goto L17;
        task.mLastSurfaceShowing = true;
    L17:
        p = p.getParent();
    L18:
        wc.scheduleAnimation();
    }

    void dump(PrintWriter pw, String prefix, boolean dumpAll) {
        if (this.mSurfaceAnimator.isAnimating() == false) goto L6;
        pw.print(prefix);
        pw.println("ContainerAnimator:");
        this.mSurfaceAnimator.dump(pw, prefix + "  ");
    L6:
        if (this.mLastOrientationSource == null) goto L11;
        if (this != this.mDisplayContent) goto L11;
        pw.println(prefix + "mLastOrientationSource=" + this.mLastOrientationSource);
        pw.println(prefix + "deepestLastOrientationSource=" + getLastOrientationSource());
    L11:
        if (this.mLocalInsetsSources == null) goto L19;
        if (this.mLocalInsetsSources.size() == 0) goto L19;
        pw.println(prefix + this.mLocalInsetsSources.size() + " LocalInsetsSources");
        StringBuilder r0 = new StringBuilder();
        r0.append(prefix);
        r0.append("  ");
        String childPrefix = r0.toString();
        int i = 0;
    L16:
        if (i >= this.mLocalInsetsSources.size()) goto L19;
        this.mLocalInsetsSources.valueAt(i).dump(childPrefix, pw);
        i = i + 1;
    L19:
        if (this.mSafeRegionBounds == null) goto L23;
        pw.println(prefix + "mSafeRegionBounds=" + this.mSafeRegionBounds);
        return;
    }

    final void updateSurfacePositionNonOrganized() {
        if (isOrganized() == false) goto L5;
        return;
    L5:
        updateSurfacePosition(getSyncTransaction());
    }

    void updateSurfacePosition(SurfaceControl.Transaction t) {
        if (this.mSurfaceControl == null) goto L29;
        if (this.mSurfaceControl.isValid() == false) goto L29;
        if (this.mSurfaceAnimator.hasLeash() == true) goto L30;
        getRelativePosition(this.mTmpPos);
        int deltaRotation = getRelativeDisplayRotation();
        if (this.mTmpPos.equals(this.mLastSurfacePosition) == true) goto L12;
    L14:
        t.setPosition(this.mSurfaceControl, this.mTmpPos.x, this.mTmpPos.y);
        this.mLastSurfacePosition.set(this.mTmpPos.x, this.mTmpPos.y);
        if (this.mTransitionController.isShellTransitionsEnabled() == false) goto L26;
        if (this.mTransitionController.useShellTransitionsRotation() == true) goto L26;
        if (deltaRotation == 0) goto L21;
        updateSurfaceRotation(t, deltaRotation, null);
        this.mDisplayContent.setFixedTransformHint(getPendingTransaction(), this.mSurfaceControl, getWindowConfiguration().getDisplayRotation());
        goto L26
    L21:
        if (deltaRotation == this.mLastDeltaRotation) goto L26;
        t.setMatrix(this.mSurfaceControl, 1.0f, 0.0f, 0.0f, 1.0f);
        getPendingTransaction().unsetFixedTransformHint(this.mSurfaceControl);
    L26:
        this.mLastDeltaRotation = deltaRotation;
        return;
    L12:
        if (deltaRotation != this.mLastDeltaRotation) goto L14;
        return;
    L30:
        return;
    }

    protected void updateSurfaceRotation(SurfaceControl.Transaction t, int deltaRotation, SurfaceControl positionLeash) {
        RotationUtils.rotateSurface(t, this.mSurfaceControl, deltaRotation);
        this.mTmpPos.set(this.mLastSurfacePosition.x, this.mLastSurfacePosition.y);
        Rect parentBounds = getParent().getBounds();
        if ((deltaRotation % 2) == 0) goto L5;
        boolean flipped = true;
    L6:
        Point r2 = this.mTmpPos;
        if (flipped == false) goto L9;
        int r3 = parentBounds.height();
    L10:
        if (flipped == false) goto L12;
        int r4 = parentBounds.width();
    L13:
        RotationUtils.rotatePoint(r2, deltaRotation, r3, r4);
        if (positionLeash == null) goto L16;
        SurfaceControl r5 = positionLeash;
    L17:
        t.setPosition(r5, this.mTmpPos.x, this.mTmpPos.y);
        return;
    L16:
        r5 = this.mSurfaceControl;
        goto L17
    L12:
        r4 = parentBounds.height();
        goto L13
    L9:
        r3 = parentBounds.width();
        goto L10
    L5:
        flipped = false;
        goto L6
    }

    Point getLastSurfacePosition() {
        return this.mLastSurfacePosition;
    }

    void getAnimationFrames(Rect outFrame, Rect outInsets, Rect outStableInsets, Rect outSurfaceInsets) {
        DisplayInfo displayInfo = getDisplayContent().getDisplayInfo();
        outFrame.set(0, 0, displayInfo.appWidth, displayInfo.appHeight);
        outInsets.setEmpty();
        outStableInsets.setEmpty();
        outSurfaceInsets.setEmpty();
    }

    void getRelativePosition(Point outPos) {
        getRelativePosition(getBounds(), outPos);
    }

    void getRelativePosition(Rect curBounds, Point outPos) {
        outPos.set(curBounds.left, curBounds.top);
        WindowContainer parent = getParent();
        if (parent == null) goto L6;
        Rect parentBounds = parent.getBounds();
        outPos.offset(-parentBounds.left, -parentBounds.top);
        return;
    }

    int getRelativeDisplayRotation() {
        WindowContainer parent = getParent();
        if (parent != null) goto L6;
        return 0;
    L6:
        int rotation = getWindowConfiguration().getDisplayRotation();
        int parentRotation = parent.getWindowConfiguration().getDisplayRotation();
        return RotationUtils.deltaRotation(rotation, parentRotation);
    }

    void waitForAllWindowsDrawn() {
        forAllWindows(new WindowContainer$$ExternalSyntheticLambda7(this), true);
    }

    private /* synthetic */ void lambda$waitForAllWindowsDrawn$7(WindowState w) {
        w.requestDrawIfNeeded(this.mWaitingForDrawn);
    }

    @Deprecated
    Dimmer getDimmer() {
        if (this.mParent != null) goto L7;
        return null;
    L7:
        return this.mParent.getDimmer();
    }

    void setSurfaceControl(SurfaceControl sc) {
        this.mSurfaceControl = sc;
    }

    RemoteAnimationDefinition getRemoteAnimationDefinition() {
        return null;
    }

    Task asTask() {
        return null;
    }

    TaskFragment asTaskFragment() {
        return null;
    }

    WindowToken asWindowToken() {
        return null;
    }

    WindowState asWindowState() {
        return null;
    }

    ActivityRecord asActivityRecord() {
        return null;
    }

    WallpaperWindowToken asWallpaperToken() {
        return null;
    }

    DisplayArea asDisplayArea() {
        return null;
    }

    RootDisplayArea asRootDisplayArea() {
        return null;
    }

    TaskDisplayArea asTaskDisplayArea() {
        return null;
    }

    DisplayContent asDisplayContent() {
        return null;
    }

    boolean isOrganized() {
        return false;
    }

    boolean isEmbedded() {
        return false;
    }

    boolean showSurfaceOnCreation() {
        return true;
    }

    boolean showWallpaper() {
        if (isVisibleRequested() == true) goto L5;
    L15:
        return false;
    L5:
        if (inMultiWindowMode() == true) goto L15;
        int i = this.mChildren.size() - 1;
    L8:
        if (i < 0) goto L14;
        WindowContainer child = this.mChildren.get(i);
        if (child.showWallpaper() == true) goto L11;
        i = i - 1;
        goto L8
    L11:
        return true;
    L14:
        return false;
    }

    boolean hasWallpaper() {
        int i = this.mChildren.size() - 1;
    L3:
        if (i < 0) goto L8;
        WindowContainer child = this.mChildren.get(i);
        if (child.hasWallpaper() == true) goto L6;
        i = i - 1;
        goto L3
    L6:
        return true;
    L8:
        return false;
    }

    static WindowContainer fromBinder(IBinder binder) {
        return RemoteToken.fromBinder(binder).getContainer();
    }

    boolean onSyncFinishedDrawing() {
        if (this.mSyncState != 0) goto L5;
        return false;
    L5:
        this.mSyncState = 2;
        this.mSyncMethodOverride = -1;
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SYNC_ENGINE_enabled[1] == false) goto L8;
        String protoLogParam0 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_SYNC_ENGINE, 5272307326252759722L, 0, new Object[]{protoLogParam0});
    L8:
        return true;
    }

    void setSyncGroup(BLASTSyncEngine.SyncGroup group) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SYNC_ENGINE_enabled[1] == false) goto L6;
        long protoLogParam0 = group.mSyncId;
        String protoLogParam1 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_SYNC_ENGINE, -8311909671193661340L, 1, new Object[]{Long.valueOf(protoLogParam0), protoLogParam1});
    L6:
        if (this.mSyncGroup != null) goto L8;
    L12:
        this.mSyncGroup = group;
        return;
    L8:
        if (this.mSyncGroup == group) goto L12;
        throw new IllegalStateException("Can't sync on 2 groups simultaneously currentSyncId=" + this.mSyncGroup.mSyncId + " newSyncId=" + group.mSyncId + " wc=" + this);
    }

    BLASTSyncEngine.SyncGroup getSyncGroup() {
        if (this.mSyncGroup != null) goto L5;
        WindowContainer<?> parent = this.mParent;
    L7:
        if (parent == null) goto L13;
        if (parent.mSyncGroup != null) goto L11;
        parent = parent.mParent;
        goto L7
    L11:
        return parent.mSyncGroup;
    L13:
        return null;
    L5:
        return this.mSyncGroup;
    }

    boolean prepareSync() {
        if (this.mSyncState == 0) goto L6;
        return false;
    L6:
        int i = getChildCount() - 1;
    L7:
        if (i < 0) goto L9;
        WindowContainer child = getChildAt(i);
        child.prepareSync();
        i = i - 1;
        goto L7
    L9:
        this.mSyncState = 2;
        return true;
    }

    boolean syncNextBuffer() {
        if (this.mSyncState == 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean isDifferentSyncGroup(BLASTSyncEngine.SyncGroup group) {
        if (group != null) goto L5;
        return false;
    L5:
        BLASTSyncEngine.SyncGroup thisGroup = getSyncGroup();
        if (thisGroup == null) goto L11;
        if (group == thisGroup) goto L11;
        Slog.d(TAG, this + " uses a different SyncGroup, current=" + thisGroup.mSyncId + " given=" + group.mSyncId);
        return true;
    L11:
        return false;
    }

    void finishSync(SurfaceControl.Transaction outMergedTransaction, BLASTSyncEngine.SyncGroup group, boolean cancel) {
        if (this.mSyncState != 0) goto L9;
        if (this.mSyncGroup == null) goto L25;
        Slog.e(TAG, "finishSync: stale group " + this.mSyncGroup.mSyncId + " of " + this);
        this.mSyncGroup = null;
        return;
    L25:
        return;
    L9:
        if (isDifferentSyncGroup(group) == false) goto L12;
        return;
    L12:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SYNC_ENGINE_enabled[1] == false) goto L14;
        String protoLogParam1 = String.valueOf(this);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_SYNC_ENGINE, -3871009616397322067L, 3, new Object[]{Boolean.valueOf(cancel), protoLogParam1});
    L14:
        outMergedTransaction.merge(this.mSyncTransaction);
        int i = this.mChildren.size() - 1;
    L15:
        if (i < 0) goto L18;
        this.mChildren.get(i).finishSync(outMergedTransaction, group, cancel);
        i = i - 1;
        goto L15
    L18:
        if (cancel == true) goto L20;
    L22:
        this.mSyncState = 0;
        this.mSyncMethodOverride = -1;
        this.mSyncGroup = null;
        return;
    L20:
        if (this.mSyncGroup == null) goto L22;
        this.mSyncGroup.onCancelSync(this);
        goto L22
    }

    boolean isSyncFinished(BLASTSyncEngine.SyncGroup group) {
        if (isVisibleRequested() == true) goto L6;
        return true;
    L6:
        if (this.mSyncState != 0) goto L11;
        if (getSyncGroup() == null) goto L11;
        Slog.i(TAG, "prepareSync in isSyncFinished: " + this);
        prepareSync();
    L11:
        if (this.mSyncState != 1) goto L13;
        return false;
    L13:
        int i = this.mChildren.size() - 1;
    L14:
        if (i < 0) goto L35;
        WindowContainer child = this.mChildren.get(i);
        if (group.isIgnoring(child) == false) goto L18;
    L21:
        boolean childFinished = true;
    L22:
        if (childFinished == true) goto L24;
    L28:
        if (childFinished == false) goto L30;
        i = i - 1;
        goto L14
    L30:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_SYNC_ENGINE_enabled[0] == false) goto L32;
        String protoLogParam0 = String.valueOf(this);
        String protoLogParam1 = String.valueOf(child);
        long protoLogParam2 = child.mSyncState;
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_SYNC_ENGINE, 6623039782895368025L, 16, new Object[]{protoLogParam0, protoLogParam1, Long.valueOf(protoLogParam2)});
    L32:
        return false;
    L24:
        if (child.isVisibleRequested() == false) goto L28;
        if (child.fillsParent() == false) goto L28;
        return true;
    L18:
        if (child.isSyncFinished(group) == true) goto L21;
        childFinished = false;
        goto L22
    L35:
        return true;
    }

    boolean allSyncFinished() {
        if (isVisibleRequested() == true) goto L6;
        return true;
    L6:
        if (this.mSyncState == 2) goto L8;
        return false;
    L8:
        int i = this.mChildren.size() - 1;
    L9:
        if (i < 0) goto L15;
        WindowContainer child = this.mChildren.get(i);
        if (child.allSyncFinished() == false) goto L12;
        i = i - 1;
        goto L9
    L12:
        return false;
    L15:
        return true;
    }

    private void onSyncReparent(WindowContainer oldParent, WindowContainer newParent) {
        if (this.mSyncState == 0) goto L13;
        if (oldParent == null) goto L13;
        if (newParent == null) goto L13;
        if (oldParent.getDisplayContent() == null) goto L13;
        if (newParent.getDisplayContent() == null) goto L13;
        if (oldParent.getDisplayContent() == newParent.getDisplayContent()) goto L13;
        this.mTransitionController.setReady(oldParent.getDisplayContent());
    L13:
        if (newParent == null) goto L17;
        if (newParent.mSyncState == 0) goto L17;
    L32:
        if (oldParent == null) goto L38;
        if (newParent == null) goto L38;
        if (shouldUpdateSyncOnReparent() == true) goto L38;
        return;
    L38:
        if (this.mTransitionController.isShellTransitionsEnabled() == false) goto L40;
        this.mSyncState = 0;
        this.mSyncMethodOverride = -1;
    L40:
        prepareSync();
        return;
    L17:
        if (this.mSyncState != 0) goto L20;
        return;
    L20:
        if (newParent != null) goto L29;
        BLASTSyncEngine.SyncGroup syncGroup = getSyncGroup();
        if (oldParent.mSyncState == 0) goto L24;
        finishSync(oldParent.mSyncTransaction, syncGroup, true);
        return;
    L24:
        if (syncGroup == null) goto L26;
        finishSync(syncGroup.getOrphanTransaction(), syncGroup, true);
        return;
    L26:
        Slog.wtf(TAG, this + " is in sync mode without a sync group");
        finishSync(getPendingTransaction(), null, true);
        return;
    L29:
        if (this.mSyncGroup != null) goto L32;
        finishSync(getPendingTransaction(), getSyncGroup(), true);
    }

    protected boolean shouldUpdateSyncOnReparent() {
        return true;
    }

    void registerWindowContainerListener(WindowContainerListener listener) {
        registerWindowContainerListener(listener, true);
    }

    void registerWindowContainerListener(WindowContainerListener listener, boolean shouldDispatchConfig) {
        if (this.mListeners.contains(listener) == false) goto L5;
        return;
    L5:
        this.mListeners.add(listener);
        registerConfigurationChangeListener(listener, shouldDispatchConfig);
        if (shouldDispatchConfig == false) goto L9;
        listener.onDisplayChanged(getDisplayContent());
        return;
    }

    void unregisterWindowContainerListener(WindowContainerListener listener) {
        this.mListeners.remove(listener);
        unregisterConfigurationChangeListener(listener);
    }

    static void overrideConfigurationPropagation(WindowContainer<?> receiver, WindowContainer<?> supplier) {
        overrideConfigurationPropagation(receiver, supplier, null);
    }

    static WindowContainerListener overrideConfigurationPropagation(final WindowContainer<?> receiver, final WindowContainer<?> supplier, final ConfigurationMerger configurationMerger) {
        final ConfigurationContainerListener listener = new AnonymousClass1(configurationMerger, receiver, supplier);
        supplier.registerConfigurationChangeListener(listener);
        WindowContainerListener wcListener = new AnonymousClass2(receiver, supplier, listener);
        receiver.registerWindowContainerListener(wcListener);
        return wcListener;
    }

    int getWindowType() {
        return -1;
    }

    boolean setCanScreenshot(SurfaceControl.Transaction t, boolean canScreenshot) {
        if (this.mSurfaceControl != null) goto L6;
        return false;
    L6:
        t.setSecure(this.mSurfaceControl, !canScreenshot);
        return true;
    }

    void addTrustedOverlay(SurfaceControlViewHost.SurfacePackage overlay, WindowState initialWindowState) {
        if (this.mOverlayHost != null) goto L5;
        this.mOverlayHost = new TrustedOverlayHost(this.mWmService);
    L5:
        this.mOverlayHost.addOverlay(overlay, this.mSurfaceControl);
        overlay.getRemoteInterface().onConfigurationChanged(getConfiguration());     // Catch: Exception -> L8
    L13:
        if (initialWindowState == null) goto L27;
        InsetsState insetsState = initialWindowState.getInsetsState();
        Rect dispBounds = getBounds();
        overlay.getRemoteInterface().onInsetsChanged(insetsState, dispBounds);     // Catch: Exception -> L17
        return;
    L19:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ANIM_enabled[4] == false) goto L21;
        ProtoLogImpl_798997914.e(WmProtoLogGroups.WM_DEBUG_ANIM, 5179630990780610966L, 0, null);
    L21:
        removeTrustedOverlay(overlay);
        return;
    L27:
        return;
    L10:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ANIM_enabled[4] == false) goto L12;
        ProtoLogImpl_798997914.e(WmProtoLogGroups.WM_DEBUG_ANIM, -4267530270533009730L, 0, null);
    L12:
        removeTrustedOverlay(overlay);
        goto L13
    }

    void removeTrustedOverlay(SurfaceControlViewHost.SurfacePackage overlay) {
        if (this.mOverlayHost != null) goto L5;
        return;
    L5:
        if (this.mOverlayHost.removeOverlay(overlay) == true) goto L9;
        this.mOverlayHost.release();
        this.mOverlayHost = null;
        return;
    }

    void updateOverlayInsetsState(WindowState originalChange) {
        WindowContainer p = getParent();
        if (p == null) goto L6;
        p.updateOverlayInsetsState(originalChange);
        return;
    }

    void waitForSyncTransactionCommit(ArraySet<WindowContainer> wcAwaitingCommit) {
        if (wcAwaitingCommit.contains(this) == false) goto L5;
        return;
    L5:
        this.mSyncTransactionCommitCallbackDepth++;
        wcAwaitingCommit.add(this);
        int i = this.mChildren.size() - 1;
    L6:
        if (i < 0) goto L9;
        this.mChildren.get(i).waitForSyncTransactionCommit(wcAwaitingCommit);
        i = i - 1;
        goto L6
    }

    void onSyncTransactionCommitted(SurfaceControl.Transaction t) {
        this.mSyncTransactionCommitCallbackDepth--;
        if (this.mSyncTransactionCommitCallbackDepth <= 0) goto L6;
        return;
    L6:
        if (this.mSyncState == 0) goto L8;
        return;
    L8:
        t.merge(this.mSyncTransaction);
    }

    int getSyncTransactionCommitCallbackDepth() {
        return this.mSyncTransactionCommitCallbackDepth;
    }

    public WindowContainerSysEx getWindowContainerSysEx() {
        return (WindowContainerSysEx) getSmtEx();
    }

    public IExtWindowContainer getExtWindowContainer() {
        return this.mExt;
    }

    public IObricWindowContainer getObricExtWindowContainer() {
        return this.mObricExt;
    }
}
