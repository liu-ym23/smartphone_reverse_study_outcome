package com.android.server.wm;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.Slog;
import android.util.SparseArray;
import android.util.proto.ProtoOutputStream;
import android.view.SurfaceControl;
import android.window.DisplayAreaInfo;
import android.window.IDisplayAreaOrganizer;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import com.android.internal.util.Preconditions;
import com.android.server.policy.WindowManagerPolicy;
import com.android.server.wm.WindowContainer;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
public class DisplayArea<T extends WindowContainer> extends WindowContainer<T> {
    boolean mDisplayAreaAppearedSent;
    final int mFeatureId;
    private final String mName;
    IDisplayAreaOrganizer mOrganizer;
    private final DisplayAreaOrganizerController mOrganizerController;
    protected boolean mSetIgnoreOrientationRequest;
    private final Configuration mTmpConfiguration;
    protected final Type mType;

    static class Dimmable extends DisplayArea<DisplayArea> {
        private final Dimmer mDimmer;

        /* JADX INFO: renamed from: $r8$lambda$ewKAhLF3xnwcZneP-cgTtyNykBo, reason: not valid java name */
        public static /* synthetic */ boolean m9868$r8$lambda$ewKAhLF3xnwcZnePcgTtyNykBo(Task r0) {
            return lambda$prepareSurfaces$0(r0);
        }

        Dimmable(WindowManagerService wms, Type type, String name, int featureId) {
            super(wms, type, name, featureId);
            this.mDimmer = new Dimmer(this);
        }

        @Override // com.android.server.wm.WindowContainer
        Dimmer getDimmer() {
            return this.mDimmer;
        }

        @Override // com.android.server.wm.WindowContainer
        void prepareSurfaces() {
            this.mDimmer.resetDimStates();
            super.prepareSurfaces();
            if (this.mTransitionController.isShellTransitionsEnabled() == true) goto L8;
            if (forAllTasks(new DisplayArea$Dimmable$$ExternalSyntheticLambda0()) == false) goto L8;
            this.mDimmer.resetDimStates();
        L8:
            if (this.mDimmer.hasDimState() == true) goto L10;
            return;
        L10:
            if (this.mDimmer.updateDims(getSyncTransaction()) == false) goto L14;
            scheduleAnimation();
            return;
        }

        private static /* synthetic */ boolean lambda$prepareSurfaces$0(Task task) {
            return !task.canAffectSystemUiFlags();
        }
    }

    public static class Tokens extends DisplayArea<WindowToken> {
        private final Predicate<WindowState> mGetOrientingWindow;
        int mLastKeyguardForcedOrientation;
        private final Comparator<WindowToken> mWindowComparator;

        public static /* synthetic */ boolean $r8$lambda$2Q0eZgOlf9COHBhGcrk7N74DbDw(Tokens r0, WindowState r1) {
            return r0.lambda$new$0(r1);
        }

        @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
        public /* bridge */ /* synthetic */ void commitPendingTransaction() {
            super.commitPendingTransaction();
        }

        @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer
        public /* bridge */ /* synthetic */ int compareTo(WindowContainer r1) {
            return super.compareTo(r1);
        }

        @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
        public /* bridge */ /* synthetic */ SurfaceControl getAnimationLeash() {
            return super.getAnimationLeash();
        }

        @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
        public /* bridge */ /* synthetic */ SurfaceControl getAnimationLeashParent() {
            return super.getAnimationLeashParent();
        }

        @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer
        public /* bridge */ /* synthetic */ IExtWindowContainer getExtWindowContainer() {
            return super.getExtWindowContainer();
        }

        @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer
        public /* bridge */ /* synthetic */ SparseArray getInsetsSourceProviders() {
            return super.getInsetsSourceProviders();
        }

        @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer
        public /* bridge */ /* synthetic */ IObricWindowContainer getObricExtWindowContainer() {
            return super.getObricExtWindowContainer();
        }

        @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
        public /* bridge */ /* synthetic */ SurfaceControl getParentSurfaceControl() {
            return super.getParentSurfaceControl();
        }

        @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
        public /* bridge */ /* synthetic */ SurfaceControl.Transaction getPendingTransaction() {
            return super.getPendingTransaction();
        }

        @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
        public /* bridge */ /* synthetic */ SurfaceControl getSurfaceControl() {
            return super.getSurfaceControl();
        }

        @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
        public /* bridge */ /* synthetic */ int getSurfaceHeight() {
            return super.getSurfaceHeight();
        }

        @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
        public /* bridge */ /* synthetic */ int getSurfaceWidth() {
            return super.getSurfaceWidth();
        }

        @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
        public /* bridge */ /* synthetic */ SurfaceControl.Transaction getSyncTransaction() {
            return super.getSyncTransaction();
        }

        @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer
        public /* bridge */ /* synthetic */ WindowContainerSysEx getWindowContainerSysEx() {
            return super.getWindowContainerSysEx();
        }

        @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer
        public /* bridge */ /* synthetic */ boolean hasInsetsSourceProvider() {
            return super.hasInsetsSourceProvider();
        }

        @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
        public /* bridge */ /* synthetic */ SurfaceControl.Builder makeAnimationLeash() {
            return super.makeAnimationLeash();
        }

        @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
        public /* bridge */ /* synthetic */ void onAnimationLeashCreated(SurfaceControl.Transaction r1, SurfaceControl r2) {
            super.onAnimationLeashCreated(r1, r2);
        }

        @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
        public /* bridge */ /* synthetic */ void onAnimationLeashLost(SurfaceControl.Transaction r1) {
            super.onAnimationLeashLost(r1);
        }

        @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer, com.android.server.wm.ConfigurationContainer
        public /* bridge */ /* synthetic */ void onRequestedOverrideConfigurationChanged(Configuration r1) {
            super.onRequestedOverrideConfigurationChanged(r1);
        }

        private /* synthetic */ boolean lambda$new$0(WindowState w) {
            if (w.isVisible() == true) goto L5;
        L28:
            return false;
        L5:
            if (w.mLegacyPolicyVisibilityAfterAnim == false) goto L28;
            WindowManagerPolicy policy = this.mWmService.mPolicy;
            if (policy.isKeyguardHostWindow(w.mAttrs) == true) goto L10;
        L19:
            int req = w.mAttrs.screenOrientation;
            if (req != (-1)) goto L22;
        L27:
            return false;
        L22:
            if (req == 3) goto L27;
            if (req == (-2)) goto L27;
            return true;
        L10:
            if (this.mDisplayContent.isKeyguardLocked() == true) goto L17;
            if (this.mDisplayContent.getDisplayPolicy().isAwake() == false) goto L17;
            if (policy.okToAnimate(true) == false) goto L17;
            return false;
        L17:
            if (policy.isKeyguardShowingAndNotOccluded() == false) goto L19;
            return true;
        }

        Tokens(WindowManagerService wms, Type type, String name) {
            this(wms, type, name, 2);
        }

        Tokens(WindowManagerService wms, Type type, String name, int featureId) {
            super(wms, type, name, featureId);
            this.mLastKeyguardForcedOrientation = -1;
            this.mWindowComparator = Comparator.comparingInt(new DisplayArea$Tokens$$ExternalSyntheticLambda0());
            this.mGetOrientingWindow = new DisplayArea$Tokens$$ExternalSyntheticLambda1(this);
        }

        void addChild(WindowToken token) {
            addChild(token, this.mWindowComparator);
        }

        @Override // com.android.server.wm.DisplayArea, com.android.server.wm.WindowContainer
        int getOrientation(int candidate) {
            this.mLastOrientationSource = null;
            WindowState win = getWindow(this.mGetOrientingWindow);
            if (win != null) goto L5;
            return candidate;
        L5:
            int req = win.mAttrs.screenOrientation;
            if (ProtoLogImpl_798997914.Cache.WM_DEBUG_ORIENTATION_enabled[1] == false) goto L9;
            String protoLogParam0 = String.valueOf(win);
            long protoLogParam1 = req;
            long protoLogParam2 = this.mDisplayContent.getDisplayId();
            ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_ORIENTATION, 2230151187668089583L, 20, new Object[]{protoLogParam0, Long.valueOf(protoLogParam1), Long.valueOf(protoLogParam2)});
        L9:
            if (this.mWmService.mPolicy.isKeyguardHostWindow(win.mAttrs) == true) goto L11;
        L16:
            this.mLastOrientationSource = win;
            return req;
        L11:
            if (req != (-2)) goto L13;
        L15:
            req = this.mLastKeyguardForcedOrientation;
            goto L16
        L13:
            if (req == (-1)) goto L15;
            this.mLastKeyguardForcedOrientation = req;
            goto L16
        }

        @Override // com.android.server.wm.DisplayArea
        final Tokens asTokens() {
            return this;
        }
    }

    static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type ABOVE_TASKS = null;
        public static final Type ANY = null;
        public static final Type BELOW_TASKS = null;

        private static /* synthetic */ Type[] $values() {
            return new Type[]{ABOVE_TASKS, BELOW_TASKS, ANY};
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        public static Type valueOf(String name) {
            return (Type) Enum.valueOf(Type.class, name);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        static {
            ABOVE_TASKS = new Type("ABOVE_TASKS", 0);
            BELOW_TASKS = new Type("BELOW_TASKS", 1);
            ANY = new Type("ANY", 2);
            $VALUES = $values();
        }

        static void checkSiblings(Type bottom, Type top) {
            boolean r1 = true;
            if (bottom != BELOW_TASKS) goto L5;
        L8:
            boolean r0 = true;
        L9:
            Preconditions.checkState(r0, bottom + " must be above BELOW_TASKS");
            if (bottom == ABOVE_TASKS) goto L12;
        L15:
            Preconditions.checkState(r1, top + " must be below ABOVE_TASKS");
            return;
        L12:
            if (top == ABOVE_TASKS) goto L15;
            r1 = false;
            goto L15
        L5:
            if (top != BELOW_TASKS) goto L8;
            r0 = false;
            goto L9
        }

        static void checkChild(Type parent, Type child) {
            boolean r1 = false;
            switch(parent.ordinal()) {
                case 0: goto L10;
                case 1: goto L6;
                default: goto L15;
            };
        L15:
            return;
        L6:
            if (child != BELOW_TASKS) goto L8;
            r1 = true;
        L8:
            Preconditions.checkState(r1, "BELOW_TASKS can only contain BELOW_TASKS");
            return;
        L10:
            if (child != ABOVE_TASKS) goto L12;
            r1 = true;
        L12:
            Preconditions.checkState(r1, "ABOVE_TASKS can only contain ABOVE_TASKS");
        }

        static Type typeOf(WindowContainer c) {
            if (c.asDisplayArea() == null) goto L7;
            return ((DisplayArea) c).mType;
        L7:
            if ((c instanceof WindowToken) == false) goto L13;
            if ((c instanceof ActivityRecord) == true) goto L13;
            return typeOf((WindowToken) c);
        L13:
            if ((c instanceof Task) == false) goto L17;
            return ANY;
        L17:
            throw new IllegalArgumentException("Unknown container: " + c);
        }

        private static Type typeOf(WindowToken c) {
            if (c.getWindowLayerFromType() >= 2) goto L6;
            return BELOW_TASKS;
        L6:
            return ABOVE_TASKS;
        }
    }

    public static /* synthetic */ boolean $r8$lambda$VaANppv_pTtKrWHRQCT0JfO4Djw(ActivityRecord r0) {
        return lambda$shouldRespectOrientationRequestDueToPerAppOverride$0(r0);
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

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public /* bridge */ /* synthetic */ SurfaceControl getAnimationLeashParent() {
        return super.getAnimationLeashParent();
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
    public /* bridge */ /* synthetic */ void onAnimationLeashCreated(SurfaceControl.Transaction r1, SurfaceControl r2) {
        super.onAnimationLeashCreated(r1, r2);
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.SurfaceAnimator.Animatable
    public /* bridge */ /* synthetic */ void onAnimationLeashLost(SurfaceControl.Transaction r1) {
        super.onAnimationLeashLost(r1);
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.ConfigurationContainer
    public /* bridge */ /* synthetic */ void onRequestedOverrideConfigurationChanged(Configuration r1) {
        super.onRequestedOverrideConfigurationChanged(r1);
    }

    DisplayArea(WindowManagerService wms, Type type, String name) {
        this(wms, type, name, -1);
    }

    DisplayArea(WindowManagerService wms, Type type, String name, int featureId) {
        super(wms);
        this.mTmpConfiguration = new Configuration();
        this.mType = type;
        this.mName = name;
        this.mFeatureId = featureId;
        this.mRemoteToken = new WindowContainer.RemoteToken(this);
        this.mOrganizerController = wms.mAtmService.mWindowOrganizerController.mDisplayAreaOrganizerController;
    }

    @Override // com.android.server.wm.WindowContainer
    void onChildPositionChanged(WindowContainer child) {
        super.onChildPositionChanged(child);
        Type.checkChild(this.mType, Type.typeOf(child));
        if ((child instanceof Task) == false) goto L5;
        return;
    L5:
        int i = 1;
    L7:
        if (i >= getChildCount()) goto L14;
        WindowContainer top = getChildAt(i - 1);
        WindowContainer bottom = getChildAt(i);
        if (child == top) goto L11;
        if (child == bottom) goto L11;
    L12:
        i = i + 1;
    L11:
        Type.checkSiblings(Type.typeOf(top), Type.typeOf(bottom));
        goto L12
    }

    @Override // com.android.server.wm.WindowContainer
    void positionChildAt(int position, T child, boolean includingParents) {
        if (child.asDisplayArea() != null) goto L6;
        super.positionChildAt(position, child, includingParents);
        return;
    L6:
        int targetPosition = findPositionForChildDisplayArea(position, child.asDisplayArea());
        super.positionChildAt(targetPosition, child, false);
        WindowContainer parent = getParent();
        if (includingParents == false) goto L22;
        if (parent != null) goto L10;
        return;
    L10:
        if (position != Integer.MAX_VALUE) goto L12;
    L13:
        if (position == Integer.MAX_VALUE) goto L15;
    L20:
        parent.positionChildAt(position, this, true);
        return;
    L15:
        if ((this instanceof DisplayContent) == false) goto L20;
        if ("PREFETCH_APP".equals(((DisplayContent) this).getDisplay().getName()) == false) goto L20;
        Slog.i("DisplayArea", "skip move display to top for prefetch display " + ((DisplayContent) this).getDisplay().getDisplayId());
        return;
    L12:
        if (position == Integer.MIN_VALUE) goto L13;
        return;
    }

    @Override // com.android.server.wm.WindowContainer
    int getOrientation(int candidate) {
        int orientation = super.getOrientation(candidate);
        if (shouldIgnoreOrientationRequest(orientation) == false) goto L6;
        this.mLastOrientationSource = null;
        return -2;
    L6:
        return orientation;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean handlesOrientationChangeFromDescendant(int orientation) {
        if (shouldIgnoreOrientationRequest(orientation) == false) goto L5;
    L7:
        return false;
    L5:
        if (super.handlesOrientationChangeFromDescendant(orientation) == false) goto L7;
        return true;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean onDescendantOrientationChanged(WindowContainer requestingContainer) {
        if (requestingContainer == null) goto L4;
        int orientation = requestingContainer.getOverrideOrientation();
    L6:
        if (shouldIgnoreOrientationRequest(orientation) == false) goto L8;
    L10:
        return false;
    L8:
        if (super.onDescendantOrientationChanged(requestingContainer) == false) goto L10;
        return true;
    L4:
        orientation = -2;
        goto L6
    }

    boolean setIgnoreOrientationRequest(boolean ignoreOrientationRequest) {
        if (this.mSetIgnoreOrientationRequest != ignoreOrientationRequest) goto L5;
        return false;
    L5:
        this.mSetIgnoreOrientationRequest = ignoreOrientationRequest;
        if (this.mDisplayContent != null) goto L9;
        return false;
    L9:
        if (this.mDisplayContent.mFocusedApp == null) goto L11;
        this.mDisplayContent.onLastFocusedTaskDisplayAreaChanged(this.mDisplayContent.mFocusedApp.getDisplayArea());
    L11:
        if (ignoreOrientationRequest == false) goto L13;
        int lastOrientation = this.mDisplayContent.getLastOrientation();
        WindowContainer<?> r2 = this.mDisplayContent.getLastOrientationSource();
        if (lastOrientation != (-2)) goto L17;
    L26:
        return false;
    L17:
        if (lastOrientation == (-1)) goto L26;
        if (r2 == null) goto L25;
        if (r2.isDescendantOf(this) == true) goto L25;
        return false;
    L25:
        return this.mDisplayContent.updateOrientation();
    L13:
        return this.mDisplayContent.updateOrientation();
    }

    @Override // com.android.server.wm.ConfigurationContainer
    public void setAlwaysOnTop(boolean alwaysOnTop) {
        if (isAlwaysOnTop() != alwaysOnTop) goto L5;
        return;
    L5:
        super.setAlwaysOnTop(alwaysOnTop);
        if (getParent().asDisplayArea() == null) goto L9;
        getParent().asDisplayArea().positionChildAt(Integer.MAX_VALUE, this, false);
        return;
    }

    boolean shouldIgnoreOrientationRequest(int orientation) {
        if (orientation != 14) goto L5;
    L14:
        return false;
    L5:
        if (orientation == 5) goto L14;
        if (getIgnoreOrientationRequest() == true) goto L10;
        return false;
    L10:
        if (shouldRespectOrientationRequestDueToPerAppOverride() == true) goto L16;
        return true;
    L16:
        return false;
    }

    private boolean shouldRespectOrientationRequestDueToPerAppOverride() {
        if (this.mDisplayContent != null) goto L5;
        return false;
    L5:
        ActivityRecord activity = this.mDisplayContent.getActivity(new DisplayArea$$ExternalSyntheticLambda0());
        if (activity == null) goto L9;
        return true;
    L9:
        return false;
    }

    private static /* synthetic */ boolean lambda$shouldRespectOrientationRequestDueToPerAppOverride$0(ActivityRecord r) {
        return r.mAppCompatController.getOrientationOverrides().shouldRespectRequestedOrientationDueToOverride();
    }

    boolean getIgnoreOrientationRequest() {
        if (this.mSetIgnoreOrientationRequest == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mWmService.isIgnoreOrientationRequestDisabled() == true) goto L7;
        return true;
    }

    private int findPositionForChildDisplayArea(int requestPosition, DisplayArea child) {
        if (child.getParent() != this) goto L17;
        int maxPosition = findMaxPositionForChildDisplayArea(child);
        int minPosition = findMinPositionForChildDisplayArea(child);
        int alwaysOnTopCount = 0;
        int i = minPosition;
    L5:
        if (i > maxPosition) goto L11;
        if (((WindowContainer) this.mChildren.get(i)).isAlwaysOnTop() == false) goto L9;
        alwaysOnTopCount = alwaysOnTopCount + 1;
    L9:
        i = i + 1;
        goto L5
    L11:
        if (child.isAlwaysOnTop() == false) goto L13;
        minPosition = (maxPosition - alwaysOnTopCount) + 1;
    L15:
        return Math.max(Math.min(requestPosition, maxPosition), minPosition);
    L13:
        maxPosition = maxPosition - alwaysOnTopCount;
        goto L15
    L17:
        throw new IllegalArgumentException("positionChildAt: container=" + child.getName() + " is not a child of container=" + getName() + " current parent=" + child.getParent());
    }

    private int findMaxPositionForChildDisplayArea(DisplayArea child) {
        Type childType = Type.typeOf(child);
        int i = this.mChildren.size() - 1;
    L3:
        if (i <= 0) goto L8;
        if (Type.typeOf(getChildAt(i)) == childType) goto L6;
        i = i - 1;
        goto L3
    L6:
        return i;
    L8:
        return 0;
    }

    private int findMinPositionForChildDisplayArea(DisplayArea child) {
        Type childType = Type.typeOf(child);
        int i = 0;
    L4:
        if (i >= this.mChildren.size()) goto L10;
        if (Type.typeOf(getChildAt(i)) == childType) goto L7;
        i = i + 1;
        goto L4
    L7:
        return i;
    L10:
        return this.mChildren.size() - 1;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean fillsParent() {
        return true;
    }

    @Override // com.android.server.wm.ConfigurationContainer
    String getName() {
        return this.mName;
    }

    public String toString() {
        return this.mName + "@" + System.identityHashCode(this);
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.ConfigurationContainer
    public void dumpDebug(ProtoOutputStream proto, long fieldId, int logLevel) {
        if (logLevel == 2) goto L5;
    L7:
        long token = proto.start(fieldId);
        super.dumpDebug(proto, 1146756268033L, logLevel);
        proto.write(1138166333442L, this.mName);
        proto.write(1133871366148L, isTaskDisplayArea());
        if (asRootDisplayArea() == null) goto L10;
        boolean r2 = true;
    L11:
        proto.write(1133871366149L, r2);
        proto.write(1120986464262L, this.mFeatureId);
        proto.write(1133871366151L, isOrganized());
        proto.write(1133871366152L, getIgnoreOrientationRequest());
        proto.end(token);
        return;
    L10:
        r2 = false;
        goto L11
    L5:
        if (isVisible() == true) goto L7;
    }

    @Override // com.android.server.wm.WindowContainer
    void dump(PrintWriter pw, String prefix, boolean dumpAll) {
        super.dump(pw, prefix, dumpAll);
        if (this.mSetIgnoreOrientationRequest == false) goto L6;
        pw.println(prefix + "mSetIgnoreOrientationRequest=true");
    L6:
        if (hasRequestedOverrideConfiguration() == false) goto L9;
        pw.println(prefix + "overrideConfig=" + getRequestedOverrideConfiguration());
        return;
    }

    void dumpChildDisplayArea(PrintWriter pw, String prefix, boolean dumpAll) {
        String doublePrefix = prefix + "  ";
        int i = getChildCount() - 1;
    L3:
        if (i < 0) goto L16;
        DisplayArea<?> childArea = getChildAt(i).asDisplayArea();
        if (childArea == null) goto L14;
        pw.print(prefix + "* " + childArea.getName());
        if (childArea.isOrganized() == false) goto L10;
        pw.print(" (organized)");
    L10:
        pw.println();
        if (childArea.isTaskDisplayArea() == true) goto L14;
        childArea.dump(pw, doublePrefix, dumpAll);
        childArea.dumpChildDisplayArea(pw, doublePrefix, dumpAll);
    L14:
        i = i - 1;
        goto L3
    }

    @Override // com.android.server.wm.WindowContainer
    long getProtoFieldId() {
        return 1146756268036L;
    }

    @Override // com.android.server.wm.WindowContainer
    final DisplayArea asDisplayArea() {
        return this;
    }

    Tokens asTokens() {
        return null;
    }

    @Override // com.android.server.wm.WindowContainer
    ActivityRecord getActivity(Predicate<ActivityRecord> callback, boolean traverseTopToBottom, ActivityRecord boundary) {
        if (this.mType != Type.ABOVE_TASKS) goto L7;
        return null;
    L7:
        return super.getActivity(callback, traverseTopToBottom, boundary);
    }

    @Override // com.android.server.wm.WindowContainer
    Task getTask(Predicate<Task> callback, boolean traverseTopToBottom) {
        if (this.mType != Type.ABOVE_TASKS) goto L7;
        return null;
    L7:
        return super.getTask(callback, traverseTopToBottom);
    }

    @Override // com.android.server.wm.WindowContainer
    Task getRootTask(Predicate<Task> callback, boolean traverseTopToBottom) {
        if (this.mType != Type.ABOVE_TASKS) goto L7;
        return null;
    L7:
        return super.getRootTask(callback, traverseTopToBottom);
    }

    @Override // com.android.server.wm.WindowContainer
    boolean forAllActivities(Predicate<ActivityRecord> callback, boolean traverseTopToBottom) {
        if (this.mType != Type.ABOVE_TASKS) goto L7;
        return false;
    L7:
        return super.forAllActivities(callback, traverseTopToBottom);
    }

    @Override // com.android.server.wm.WindowContainer
    void forAllActivities(Consumer<ActivityRecord> callback, boolean traverseTopToBottom) {
        if (this.mType != Type.ABOVE_TASKS) goto L5;
        return;
    L5:
        super.forAllActivities(callback, traverseTopToBottom);
    }

    @Override // com.android.server.wm.WindowContainer
    boolean forAllRootTasks(Predicate<Task> callback, boolean traverseTopToBottom) {
        if (this.mType != Type.ABOVE_TASKS) goto L7;
        return false;
    L7:
        return super.forAllRootTasks(callback, traverseTopToBottom);
    }

    @Override // com.android.server.wm.WindowContainer
    boolean forAllTasks(Predicate<Task> callback) {
        if (this.mType != Type.ABOVE_TASKS) goto L7;
        return false;
    L7:
        return super.forAllTasks(callback);
    }

    @Override // com.android.server.wm.WindowContainer
    boolean forAllLeafTasks(Predicate<Task> callback) {
        if (this.mType != Type.ABOVE_TASKS) goto L7;
        return false;
    L7:
        return super.forAllLeafTasks(callback);
    }

    @Override // com.android.server.wm.WindowContainer
    void forAllLeafTasks(Consumer<Task> callback, boolean traverseTopToBottom) {
        if (this.mType != Type.ABOVE_TASKS) goto L5;
        return;
    L5:
        super.forAllLeafTasks(callback, traverseTopToBottom);
    }

    @Override // com.android.server.wm.WindowContainer
    boolean forAllLeafTaskFragments(Predicate<TaskFragment> callback) {
        if (this.mType != Type.ABOVE_TASKS) goto L7;
        return false;
    L7:
        return super.forAllLeafTaskFragments(callback);
    }

    @Override // com.android.server.wm.WindowContainer
    void forAllDisplayAreas(Consumer<DisplayArea> callback) {
        super.forAllDisplayAreas(callback);
        callback.accept(this);
    }

    @Override // com.android.server.wm.WindowContainer
    boolean forAllTaskDisplayAreas(Predicate<TaskDisplayArea> callback, boolean traverseTopToBottom) {
        if (this.mType == Type.ANY) goto L5;
        return false;
    L5:
        int childCount = this.mChildren.size();
        if (traverseTopToBottom == false) goto L8;
        int i = childCount - 1;
    L9:
        if (i < 0) goto L19;
        if (i >= childCount) goto L19;
        WindowContainer r3 = (WindowContainer) this.mChildren.get(i);
        int r5 = 1;
        if (r3.asDisplayArea() != null) goto L14;
    L16:
        if (traverseTopToBottom == false) goto L18;
        r5 = -1;
    L18:
        i = i + r5;
        goto L9
    L14:
        if (r3.asDisplayArea().forAllTaskDisplayAreas(callback, traverseTopToBottom) == false) goto L16;
        return true;
    L19:
        return false;
    L8:
        i = 0;
        goto L9
    }

    @Override // com.android.server.wm.WindowContainer
    void forAllTaskDisplayAreas(Consumer<TaskDisplayArea> callback, boolean traverseTopToBottom) {
        if (this.mType == Type.ANY) goto L5;
        return;
    L5:
        int childCount = this.mChildren.size();
        if (traverseTopToBottom == false) goto L8;
        int i = childCount - 1;
    L9:
        if (i < 0) goto L18;
        if (i >= childCount) goto L24;
        WindowContainer r2 = (WindowContainer) this.mChildren.get(i);
        if (r2.asDisplayArea() == null) goto L14;
        r2.asDisplayArea().forAllTaskDisplayAreas(callback, traverseTopToBottom);
    L14:
        if (traverseTopToBottom == false) goto L16;
        int r3 = -1;
    L17:
        i = i + r3;
        goto L9
    L16:
        r3 = 1;
        goto L17
    L24:
        return;
    L18:
        return;
    L8:
        i = 0;
        goto L9
    }

    @Override // com.android.server.wm.WindowContainer
    <R> R reduceOnAllTaskDisplayAreas(BiFunction<TaskDisplayArea, R, R> r6, R r7, boolean r8) {
        if (this.mType == Type.ANY) goto L5;
        return r7;
    L5:
        int r0 = this.mChildren.size();
        if (r8 == false) goto L8;
        int r1 = r0 - 1;
    L9:
        R r2 = r7;
    L10:
        if (r1 < 0) goto L19;
        if (r1 >= r0) goto L19;
        WindowContainer r3 = (WindowContainer) this.mChildren.get(r1);
        if (r3.asDisplayArea() == null) goto L15;
        r2 = (R) r3.asDisplayArea().reduceOnAllTaskDisplayAreas(r6, r2, r8);
    L15:
        if (r8 == false) goto L17;
        int r4 = -1;
    L18:
        r1 = r1 + r4;
        goto L10
    L17:
        r4 = 1;
    L19:
        return r2;
    L8:
        r1 = 0;
        goto L9
    }

    @Override // com.android.server.wm.WindowContainer
    <R> R getItemFromDisplayAreas(Function<DisplayArea, R> r3) {
        R r0 = (R) super.getItemFromDisplayAreas(r3);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return r3.apply(this);
    }

    @Override // com.android.server.wm.WindowContainer
    <R> R getItemFromTaskDisplayAreas(Function<TaskDisplayArea, R> r6, boolean r7) {
        if (this.mType == Type.ANY) goto L5;
        return null;
    L5:
        int r0 = this.mChildren.size();
        if (r7 == false) goto L8;
        int r1 = r0 - 1;
    L9:
        if (r1 < 0) goto L20;
        if (r1 >= r0) goto L20;
        WindowContainer r3 = (WindowContainer) this.mChildren.get(r1);
        if (r3.asDisplayArea() == null) goto L16;
        R r4 = (R) r3.asDisplayArea().getItemFromTaskDisplayAreas(r6, r7);
        if (r4 == null) goto L16;
        return r4;
    L16:
        if (r7 == false) goto L18;
        int r5 = -1;
    L19:
        r1 = r1 + r5;
        goto L9
    L18:
        r5 = 1;
    L20:
        return null;
    L8:
        r1 = 0;
        goto L9
    }

    void setOrganizer(IDisplayAreaOrganizer organizer) {
        setOrganizer(organizer, false);
    }

    void setOrganizer(IDisplayAreaOrganizer organizer, boolean skipDisplayAreaAppeared) {
        if (this.mOrganizer != organizer) goto L6;
        return;
    L6:
        if (this.mDisplayContent == null) goto L16;
        if (this.mDisplayContent.isTrusted() == false) goto L16;
        IDisplayAreaOrganizer lastOrganizer = this.mOrganizer;
        this.mOrganizer = organizer;
        sendDisplayAreaVanished(lastOrganizer);
        if (skipDisplayAreaAppeared == true) goto L12;
        sendDisplayAreaAppeared();
        return;
    L12:
        if (organizer == null) goto L18;
        this.mDisplayAreaAppearedSent = true;
        return;
    L18:
        return;
    L16:
        throw new IllegalStateException("Don't organize or trigger events for unavailable or untrusted display.");
    }

    void sendDisplayAreaAppeared() {
        if (this.mOrganizer != null) goto L5;
        return;
    L5:
        if (this.mDisplayAreaAppearedSent == true) goto L10;
        this.mOrganizerController.onDisplayAreaAppeared(this.mOrganizer, this);
        this.mDisplayAreaAppearedSent = true;
        return;
    }

    void sendDisplayAreaInfoChanged() {
        if (this.mOrganizer != null) goto L5;
        return;
    L5:
        if (this.mDisplayAreaAppearedSent == false) goto L10;
        this.mOrganizerController.onDisplayAreaInfoChanged(this.mOrganizer, this);
        return;
    }

    void sendDisplayAreaVanished(IDisplayAreaOrganizer organizer) {
        if (organizer != null) goto L4;
        return;
    L4:
        if (this.mDisplayAreaAppearedSent == false) goto L9;
        migrateToNewSurfaceControl(getSyncTransaction());
        this.mOrganizerController.onDisplayAreaVanished(organizer, this);
        this.mDisplayAreaAppearedSent = false;
        return;
    }

    @Override // com.android.server.wm.WindowContainer, com.android.server.wm.ConfigurationContainer
    public void onConfigurationChanged(Configuration newParentConfig) {
        this.mTransitionController.collectForDisplayAreaChange(this);
        this.mTmpConfiguration.setTo(getConfiguration());
        super.onConfigurationChanged(newParentConfig);
        if (this.mOrganizer != null) goto L5;
        return;
    L5:
        if (getConfiguration().diff(this.mTmpConfiguration) == 0) goto L9;
        sendDisplayAreaInfoChanged();
        return;
    }

    @Override // com.android.server.wm.ConfigurationContainer
    void resolveOverrideConfiguration(Configuration newParentConfiguration) {
        super.resolveOverrideConfiguration(newParentConfiguration);
        Configuration resolvedConfig = getResolvedOverrideConfiguration();
        Rect overrideBounds = resolvedConfig.windowConfiguration.getBounds();
        Rect overrideAppBounds = resolvedConfig.windowConfiguration.getAppBounds();
        Rect parentAppBounds = newParentConfiguration.windowConfiguration.getAppBounds();
        if (overrideBounds.isEmpty() == true) goto L12;
        if (overrideAppBounds != null) goto L6;
    L7:
        if (parentAppBounds != null) goto L9;
        return;
    L9:
        if (parentAppBounds.isEmpty() == true) goto L15;
        Rect appBounds = new Rect(overrideBounds);
        appBounds.intersect(parentAppBounds);
        resolvedConfig.windowConfiguration.setAppBounds(appBounds);
        return;
    L15:
        return;
    L6:
        if (overrideAppBounds.isEmpty() == true) goto L7;
        return;
    }

    @Override // com.android.server.wm.WindowContainer
    boolean isOrganized() {
        if (this.mOrganizer == null) goto L5;
        return true;
    L5:
        return false;
    }

    DisplayAreaInfo getDisplayAreaInfo() {
        DisplayAreaInfo info = new DisplayAreaInfo(this.mRemoteToken.toWindowContainerToken(), getDisplayContent().getDisplayId(), this.mFeatureId);
        RootDisplayArea root = getRootDisplayArea();
        if (root != null) goto L5;
        int r2 = getDisplayContent().mFeatureId;
    L6:
        info.rootDisplayAreaId = r2;
        info.configuration.setTo(getConfiguration());
        return info;
    L5:
        r2 = root.mFeatureId;
        goto L6
    }

    void getStableRect(Rect out) {
        if (this.mDisplayContent != null) goto L6;
        getBounds(out);
        return;
    L6:
        this.mDisplayContent.getStableRect(out);
        out.intersect(getBounds());
    }

    @Override // com.android.server.wm.ConfigurationContainer
    public boolean providesMaxBounds() {
        return true;
    }

    boolean isTaskDisplayArea() {
        return false;
    }

    @Override // com.android.server.wm.WindowContainer
    void removeImmediately() {
        setOrganizer(null);
        super.removeImmediately();
    }

    @Override // com.android.server.wm.WindowContainer
    DisplayArea getDisplayArea() {
        return this;
    }
}
