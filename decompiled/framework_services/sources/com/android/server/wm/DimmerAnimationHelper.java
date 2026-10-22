package com.android.server.wm;

import android.graphics.Rect;
import android.pico.utils.ExtImplFactory;
import android.util.Log;
import android.util.proto.ProtoOutputStream;
import android.view.SurfaceControl;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.internal.protolog.WmProtoLogGroups;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public class DimmerAnimationHelper {
    private static final int DEFAULT_DIM_ANIM_DURATION_MS = 200;
    private static final String TAG = "WindowManager";
    private AnimationSpec mAlphaAnimationSpec;
    private final AnimationAdapterFactory mAnimationAdapterFactory;
    private final Change mCurrentProperties;
    private IExtDimmerAnimationHelper mExt;
    private AnimationAdapter mLocalAnimationAdapter;
    private final Change mRequestedProperties;
    private final SurfaceAnimationRunner mSurfaceAnimationRunner;

    static class AnimationAdapterFactory {
        AnimationAdapterFactory() {
        }

        public AnimationAdapter get(LocalAnimationAdapter.AnimationSpec alphaAnimationSpec, SurfaceAnimationRunner runner) {
            return new LocalAnimationAdapter(alphaAnimationSpec, runner);
        }
    }

    static class AnimationSpec implements LocalAnimationAdapter.AnimationSpec {
        private static final String TAG = "WindowManager";
        private final AnimationExtremes<Float> mAlpha;
        private final AnimationExtremes<Integer> mBlur;
        float mCurrentAlpha;
        int mCurrentBlur;
        private final long mDuration;
        boolean mStarted;

        static class AnimationExtremes<T> {
            final T mFinishValue;
            final T mStartValue;

            AnimationExtremes(T fromValue, T toValue) {
                this.mStartValue = fromValue;
                this.mFinishValue = toValue;
            }

            public String toString() {
                return "[" + this.mStartValue + "->" + this.mFinishValue + "]";
            }
        }

        AnimationSpec(AnimationExtremes<Float> alpha, AnimationExtremes<Integer> blur, long duration) {
            this.mCurrentAlpha = 0.0f;
            this.mCurrentBlur = 0;
            this.mStarted = false;
            this.mAlpha = alpha;
            this.mBlur = blur;
            this.mDuration = duration;
        }

        @Override // com.android.server.wm.LocalAnimationAdapter.AnimationSpec
        public long getDuration() {
            return this.mDuration;
        }

        @Override // com.android.server.wm.LocalAnimationAdapter.AnimationSpec
        public void apply(SurfaceControl.Transaction t, SurfaceControl sc, long currentPlayTime) {
            if (this.mStarted == true) goto L6;
            this.mStarted = true;
            return;
        L6:
            float fraction = getFraction(currentPlayTime);
            this.mCurrentAlpha = ((this.mAlpha.mFinishValue.floatValue() - this.mAlpha.mStartValue.floatValue()) * fraction) + this.mAlpha.mStartValue.floatValue();
            this.mCurrentBlur = (((int) fraction) * (this.mBlur.mFinishValue.intValue() - this.mBlur.mStartValue.intValue())) + this.mBlur.mStartValue.intValue();
            if (sc.isValid() == false) goto L12;
            t.setAlpha(sc, this.mCurrentAlpha);     // Catch: Throwable -> L10
            t.setBackgroundBlurRadius(sc, this.mCurrentBlur);     // Catch: Throwable -> L10
        L16:
            return;
        L12:
            Log.w(TAG, "Dimmer#AnimationSpec tried to access " + sc + " after release");     // Catch: Throwable -> L10
        L14:
            Log.w(TAG, "Dimmer#AnimationSpec tried to access " + sc + " after release");
        }

        public String toString() {
            return "Animation spec: alpha=" + this.mAlpha + ", blur=" + this.mBlur;
        }

        @Override // com.android.server.wm.LocalAnimationAdapter.AnimationSpec
        public void dump(PrintWriter pw, String prefix) {
            pw.print(prefix);
            pw.print("from_alpha=");
            pw.print(this.mAlpha.mStartValue);
            pw.print(" to_alpha=");
            pw.print(this.mAlpha.mFinishValue);
            pw.print(prefix);
            pw.print("from_blur=");
            pw.print(this.mBlur.mStartValue);
            pw.print(" to_blur=");
            pw.print(this.mBlur.mFinishValue);
            pw.print(" duration=");
            pw.println(this.mDuration);
        }

        @Override // com.android.server.wm.LocalAnimationAdapter.AnimationSpec
        public void dumpDebugInner(ProtoOutputStream proto) {
            long token = proto.start(1146756268035L);
            proto.write(1108101562369L, this.mAlpha.mStartValue.floatValue());
            proto.write(1108101562370L, this.mAlpha.mFinishValue.floatValue());
            proto.write(1112396529667L, this.mDuration);
            proto.end(token);
        }
    }

    static class Change {
        private static final float EPSILON = 1.0E-4f;
        private float mAlpha;
        private int mBlurRadius;
        private WindowState mDimmingContainer;
        private WindowContainer<?> mGeometryParent;

        /* JADX INFO: renamed from: -$$Nest$fgetmAlpha, reason: not valid java name */
        static /* bridge */ /* synthetic */ float m9860$$Nest$fgetmAlpha(Change r0) {
            return r0.mAlpha;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmBlurRadius, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m9861$$Nest$fgetmBlurRadius(Change r0) {
            return r0.mBlurRadius;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDimmingContainer, reason: not valid java name */
        static /* bridge */ /* synthetic */ WindowState m9862$$Nest$fgetmDimmingContainer(Change r0) {
            return r0.mDimmingContainer;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmGeometryParent, reason: not valid java name */
        static /* bridge */ /* synthetic */ WindowContainer m9863$$Nest$fgetmGeometryParent(Change r0) {
            return r0.mGeometryParent;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmAlpha, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9864$$Nest$fputmAlpha(Change r0, float r1) {
            r0.mAlpha = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmBlurRadius, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9865$$Nest$fputmBlurRadius(Change r0, int r1) {
            r0.mBlurRadius = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmDimmingContainer, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9866$$Nest$fputmDimmingContainer(Change r0, WindowState r1) {
            r0.mDimmingContainer = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmGeometryParent, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m9867$$Nest$fputmGeometryParent(Change r0, WindowContainer r1) {
            r0.mGeometryParent = r1;
        }

        Change() {
            this.mAlpha = -1.0f;
            this.mBlurRadius = -1;
            this.mDimmingContainer = null;
            this.mGeometryParent = null;
        }

        Change(Change other) {
            this.mAlpha = -1.0f;
            this.mBlurRadius = -1;
            this.mDimmingContainer = null;
            this.mGeometryParent = null;
            copyFrom(other);
        }

        void copyFrom(Change other) {
            this.mAlpha = other.mAlpha;
            this.mBlurRadius = other.mBlurRadius;
            this.mDimmingContainer = other.mDimmingContainer;
            this.mGeometryParent = other.mGeometryParent;
        }

        boolean hasSameVisualProperties(Change other) {
            if (Math.abs(this.mAlpha - other.mAlpha) < EPSILON) goto L5;
        L7:
            return false;
        L5:
            if (this.mBlurRadius != other.mBlurRadius) goto L7;
            return true;
        }

        boolean hasSameDimmingContainer(Change other) {
            if (this.mDimmingContainer != null) goto L5;
        L7:
            return false;
        L5:
            if (this.mDimmingContainer != other.mDimmingContainer) goto L7;
            return true;
        }

        void inheritPropertiesFromAnimation(AnimationSpec anim) {
            if (anim == null) goto L5;
            this.mAlpha = anim.mCurrentAlpha;
            this.mBlurRadius = anim.mCurrentBlur;
            return;
        }

        public String toString() {
            return "Dim state: alpha=" + this.mAlpha + ", blur=" + this.mBlurRadius + ", container=" + this.mDimmingContainer + ", geometryParent " + this.mGeometryParent;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-4RXDsMsps1xuQdh2yjXk8VxS7M, reason: not valid java name */
    public static /* synthetic */ void m9859$r8$lambda$4RXDsMsps1xuQdh2yjXk8VxS7M(DimmerAnimationHelper r0, Dimmer.DimState r1, float r2, int r3, AnimationAdapter r4) {
        r0.lambda$startAnimation$0(r1, r2, r3, r4);
    }

    DimmerAnimationHelper(WindowContainer<?> host, AnimationAdapterFactory animationFactory) {
        this.mCurrentProperties = new Change();
        this.mRequestedProperties = new Change();
        this.mExt = (IExtDimmerAnimationHelper) ExtImplFactory.getImpl(IExtDimmerAnimationHelper.class, new Object[]{this});
        this.mAnimationAdapterFactory = animationFactory;
        this.mSurfaceAnimationRunner = host.mWmService.mSurfaceAnimationRunner;
    }

    void setExitParameters() {
        setRequestedRelativeParent(Change.m9862$$Nest$fgetmDimmingContainer(this.mRequestedProperties));
        setRequestedAppearance(0.0f, 0);
    }

    void setRequestedRelativeParent(WindowState relativeParent) {
        Change.m9866$$Nest$fputmDimmingContainer(this.mRequestedProperties, relativeParent);
    }

    void setRequestedGeometryParent(WindowContainer<?> geometryParent) {
        if (geometryParent == null) goto L5;
        Change.m9867$$Nest$fputmGeometryParent(this.mRequestedProperties, geometryParent);
        return;
    }

    void setRequestedAppearance(float alpha, int blurRadius) {
        Change.m9864$$Nest$fputmAlpha(this.mRequestedProperties, alpha);
        Change.m9865$$Nest$fputmBlurRadius(this.mRequestedProperties, blurRadius);
    }

    void applyChanges(SurfaceControl.Transaction t, Dimmer.DimState dim) {
        Change startProperties = new Change(this.mCurrentProperties);
        this.mCurrentProperties.copyFrom(this.mRequestedProperties);
        if (Change.m9862$$Nest$fgetmDimmingContainer(this.mRequestedProperties) != null) goto L7;
        Log.e(TAG, this + " does not have a dimming container. Have you forgotten to call adjustRelativeLayer?");
        return;
    L7:
        if (Change.m9862$$Nest$fgetmDimmingContainer(this.mRequestedProperties).getSurfaceControl() != null) goto L11;
        Log.w(TAG, "container " + Change.m9862$$Nest$fgetmDimmingContainer(this.mRequestedProperties) + "does not have a surface");
        dim.remove(t);
        return;
    L11:
        if (dim.mDimSurface.isValid() == true) goto L14;
        Log.e(TAG, "Dimming surface " + dim.mDimSurface + " has already been released! Can not apply changes.");
        return;
    L14:
        dim.ensureVisible(t);
        IExtDimmerAnimationHelper r3 = this.mExt;
        WindowState r4 = null;
        if (Change.m9863$$Nest$fgetmGeometryParent(startProperties) == Change.m9863$$Nest$fgetmGeometryParent(this.mRequestedProperties)) goto L17;
        SurfaceControl r5 = Change.m9863$$Nest$fgetmGeometryParent(this.mRequestedProperties).getSurfaceControl();
    L19:
        if (Change.m9862$$Nest$fgetmDimmingContainer(this.mRequestedProperties) == Change.m9862$$Nest$fgetmDimmingContainer(startProperties)) goto L23;
        r4 = Change.m9862$$Nest$fgetmDimmingContainer(this.mRequestedProperties);
    L23:
        r3.reparent(dim, r5, r4, Change.m9862$$Nest$fgetmDimmingContainer(startProperties), t);
        setBounds(dim, Change.m9862$$Nest$fgetmDimmingContainer(this.mCurrentProperties), t);
        if (startProperties.hasSameVisualProperties(this.mRequestedProperties) == true) goto L38;
        EventLogTags.writeWmDimCancelAnim(dim.mDimSurface.getLayerId(), "new target values");
        stopCurrentAnimation(dim.mDimSurface);
        if (dim.mSkipAnimation == true) goto L34;
        if (startProperties.hasSameDimmingContainer(this.mRequestedProperties) == true) goto L30;
    L32:
        startAnimation(t, dim, startProperties, this.mRequestedProperties);
        return;
    L30:
        if (dim.isDimming() == false) goto L32;
    L34:
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_DIMMER_enabled[0] == false) goto L36;
        String protoLogParam0 = String.valueOf(dim);
        double protoLogParam1 = Change.m9860$$Nest$fgetmAlpha(startProperties);
        long protoLogParam2 = Change.m9861$$Nest$fgetmBlurRadius(this.mRequestedProperties);
        ProtoLogImpl_798997914.d(WmProtoLogGroups.WM_DEBUG_DIMMER, 3778139410556664218L, 24, new Object[]{protoLogParam0, Double.valueOf(protoLogParam1), Long.valueOf(protoLogParam2)});
    L36:
        setCurrentAlphaBlur(dim, t);
        dim.mSkipAnimation = false;
        return;
    L38:
        if (dim.isDimming() == true) goto L43;
        dim.remove(t);
        return;
    L43:
        return;
    L17:
        r5 = null;
        goto L19
    }

    private void startAnimation(SurfaceControl.Transaction t, final Dimmer.DimState dim, Change from, Change to) {
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_DIMMER_enabled[1] == false) goto L5;
        String protoLogParam0 = String.valueOf(dim);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_DIMMER, -6357087772993832060L, 0, new Object[]{protoLogParam0});
    L5:
        this.mAlphaAnimationSpec = getRequestedAnimationSpec(from, to);
        this.mLocalAnimationAdapter = this.mAnimationAdapterFactory.get(this.mAlphaAnimationSpec, this.mSurfaceAnimationRunner);
        final float targetAlpha = Change.m9860$$Nest$fgetmAlpha(to);
        EventLogTags.writeWmDimAnimate(dim.mDimSurface.getLayerId(), targetAlpha, Change.m9861$$Nest$fgetmBlurRadius(to));
        this.mLocalAnimationAdapter.startAnimation(dim.mDimSurface, t, 4, new DimmerAnimationHelper$$ExternalSyntheticLambda0(this, dim, targetAlpha));
    }

    private /* synthetic */ void lambda$startAnimation$0(Dimmer.DimState dim, float targetAlpha, int type, AnimationAdapter animator) {
        WindowManagerGlobalLock r0 = dim.mHostContainer.mWmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        EventLogTags.writeWmDimFinishAnim(dim.mDimSurface.getLayerId());     // Catch: Throwable -> L9
        SurfaceControl.Transaction finishTransaction = dim.mHostContainer.getSyncTransaction();     // Catch: Throwable -> L9
        setCurrentAlphaBlur(dim, finishTransaction);     // Catch: Throwable -> L9
        if (targetAlpha == 0.0f) goto L7;
    L11:
        this.mLocalAnimationAdapter = null;     // Catch: Throwable -> L9
        this.mAlphaAnimationSpec = null;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L7:
        if (dim.isDimming() == true) goto L11;
        dim.remove(finishTransaction);     // Catch: Throwable -> L9
        dim.mHostContainer.scheduleAnimation();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void stopCurrentAnimation(SurfaceControl surface) {
        this.mCurrentProperties.inheritPropertiesFromAnimation(this.mAlphaAnimationSpec);
        this.mSurfaceAnimationRunner.onAnimationCancelled(surface);
        this.mLocalAnimationAdapter = null;
        this.mAlphaAnimationSpec = null;
    }

    private static AnimationSpec getRequestedAnimationSpec(Change from, Change to) {
        float startAlpha = Math.max(Change.m9860$$Nest$fgetmAlpha(from), 0.0f);
        int startBlur = Math.max(Change.m9861$$Nest$fgetmBlurRadius(from), 0);
        long duration = (long) (getDimDuration(Change.m9862$$Nest$fgetmDimmingContainer(to)) * Math.abs(Change.m9860$$Nest$fgetmAlpha(to) - startAlpha));
        AnimationSpec spec = new AnimationSpec(new AnimationSpec.AnimationExtremes(Float.valueOf(startAlpha), Float.valueOf(Change.m9860$$Nest$fgetmAlpha(to))), new AnimationSpec.AnimationExtremes(Integer.valueOf(startBlur), Integer.valueOf(Change.m9861$$Nest$fgetmBlurRadius(to))), duration);
        if (ProtoLogImpl_798997914.Cache.WM_DEBUG_DIMMER_enabled[1] == false) goto L5;
        String protoLogParam0 = String.valueOf(spec);
        ProtoLogImpl_798997914.v(WmProtoLogGroups.WM_DEBUG_DIMMER, -1187783168730646350L, 0, new Object[]{protoLogParam0});
    L5:
        return spec;
    }

    void reparent(Dimmer.DimState dim, SurfaceControl newGeometryParent, SurfaceControl newRelativeParent, SurfaceControl.Transaction t) {
        SurfaceControl dimLayer = dim.mDimSurface;
        if (newGeometryParent != null) goto L13;
    L7:
        if (newRelativeParent == null) goto L15;
        t.setRelativeLayer(dimLayer, newRelativeParent, -1);     // Catch: NullPointerException -> L5
        return;
    L5:
        e = move-exception;
        Log.w(TAG, "Tried to change parent of dim " + dimLayer + " after remove", e);
        return;
    L15:
        return;
    L13:
        t.reparent(dimLayer, newGeometryParent);     // Catch: NullPointerException -> L5
        goto L7
    }

    static void setBounds(Dimmer.DimState dim, WindowState relativeParent, SurfaceControl.Transaction t) {
        TaskFragment taskFragment = relativeParent.getTaskFragment();
        Rect taskBounds = null;
        if (taskFragment == null) goto L5;
        Rect taskFragmentBounds = taskFragment.getBounds();
    L6:
        Task task = relativeParent.getTask();
        if (task == null) goto L9;
        taskBounds = task.getBounds();
    L9:
        Rect hostBounds = dim.mHostContainer.getBounds();
        if (taskFragment != null) goto L12;
    L14:
        boolean isEmbedded = false;
    L15:
        Rect relativeBounds = new Rect();
        if (isEmbedded == false) goto L22;
        Rect r5 = dim.mDimBounds;
        if (taskFragment.isDimmingOnParentTask() == false) goto L20;
        Rect r8 = taskBounds;
    L21:
        r5.set(r8);
        relativeBounds.set(dim.mDimBounds);
        relativeBounds.offset(-taskBounds.left, -taskBounds.top);
    L23:
        t.setWindowCrop(dim.mDimSurface, relativeBounds.width(), relativeBounds.height());
        t.setPosition(dim.mDimSurface, relativeBounds.left, relativeBounds.top);
        return;
    L20:
        r8 = taskFragmentBounds;
        goto L21
    L22:
        dim.mDimBounds.set(hostBounds);
        relativeBounds.set(dim.mDimBounds);
        relativeBounds.offsetTo(0, 0);
        goto L23
    L12:
        if (taskFragment.isEmbedded() == false) goto L14;
        isEmbedded = true;
        goto L15
    L5:
        taskFragmentBounds = null;
        goto L6
    }

    void setCurrentAlphaBlur(Dimmer.DimState dim, SurfaceControl.Transaction t) {
        SurfaceControl sc = dim.mDimSurface;
        t.setAlpha(sc, Change.m9860$$Nest$fgetmAlpha(this.mCurrentProperties));     // Catch: NullPointerException -> L5
        t.setBackgroundBlurRadius(sc, Change.m9861$$Nest$fgetmBlurRadius(this.mCurrentProperties));     // Catch: NullPointerException -> L5
        return;
    L5:
        e = move-exception;
        Log.w(TAG, "Tried to change look of dim " + sc + " after remove", e);
    }

    private static long getDimDuration(WindowContainer<?> container) {
        if (container.mSurfaceAnimator == null) goto L9;
        AnimationAdapter animationAdapter = container.mSurfaceAnimator.getAnimation();
        float durationScale = container.mWmService.getTransitionAnimationScaleLocked();
        if (animationAdapter != null) goto L8;
        return (long) (200.0f * durationScale);
    L8:
        return animationAdapter.getDurationHint();
    L9:
        return 0;
    }

    public IExtDimmerAnimationHelper getExt() {
        return this.mExt;
    }
}
