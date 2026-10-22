package com.android.server.wm;

import android.content.res.Configuration;
import android.graphics.Rect;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
class TransparentPolicy {
    private static final Predicate<ActivityRecord> FIRST_OPAQUE_NOT_FINISHING_ACTIVITY_PREDICATE = null;
    private static final String TAG = "ActivityTaskManager";
    private final ActivityRecord mActivityRecord;
    private final List<TransparentPolicy> mDestroyListeners;
    private final BooleanSupplier mIsTranslucentLetterboxingEnabledSupplier;
    private final TransparentPolicyState mTransparentPolicyState;

    static class TransparentPolicyState {
        private static final float UNDEFINED_ASPECT_RATIO = 0.0f;
        private final ActivityRecord mActivityRecord;
        private ActivityRecord mFirstOpaqueActivity;
        private AppCompatDisplayInsets mInheritedAppCompatDisplayInsets;
        private int mInheritedAppCompatState;
        private float mInheritedMaxAspectRatio;
        private float mInheritedMinAspectRatio;
        private int mInheritedOrientation;
        private WindowContainerListener mLetterboxConfigListener;

        /* JADX INFO: renamed from: $r8$lambda$SEP6O4-hPND0DFZooEDdxRo7q_8, reason: not valid java name */
        public static /* synthetic */ Configuration m10348$r8$lambda$SEP6O4hPND0DFZooEDdxRo7q_8(TransparentPolicyState r0, WindowContainer r1, Configuration r2, Configuration r3) {
            return r0.lambda$start$0(r1, r2, r3);
        }

        public static /* synthetic */ Boolean $r8$lambda$auIh4jw_IQJDhJwPerBOQv79P2Y(Consumer r0, ActivityRecord r1) {
            return lambda$applyOnOpaqueActivityBelow$1(r0, r1);
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmFirstOpaqueActivity, reason: not valid java name */
        static /* bridge */ /* synthetic */ ActivityRecord m10349$$Nest$fgetmFirstOpaqueActivity(TransparentPolicyState r0) {
            return r0.mFirstOpaqueActivity;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmInheritedAppCompatDisplayInsets, reason: not valid java name */
        static /* bridge */ /* synthetic */ AppCompatDisplayInsets m10350$$Nest$fgetmInheritedAppCompatDisplayInsets(TransparentPolicyState r0) {
            return r0.mInheritedAppCompatDisplayInsets;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmInheritedAppCompatState, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m10351$$Nest$fgetmInheritedAppCompatState(TransparentPolicyState r0) {
            return r0.mInheritedAppCompatState;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmInheritedMaxAspectRatio, reason: not valid java name */
        static /* bridge */ /* synthetic */ float m10352$$Nest$fgetmInheritedMaxAspectRatio(TransparentPolicyState r0) {
            return r0.mInheritedMaxAspectRatio;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmInheritedMinAspectRatio, reason: not valid java name */
        static /* bridge */ /* synthetic */ float m10353$$Nest$fgetmInheritedMinAspectRatio(TransparentPolicyState r0) {
            return r0.mInheritedMinAspectRatio;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmInheritedOrientation, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m10354$$Nest$fgetmInheritedOrientation(TransparentPolicyState r0) {
            return r0.mInheritedOrientation;
        }

        /* JADX INFO: renamed from: -$$Nest$mapplyOnOpaqueActivityBelow, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m10355$$Nest$mapplyOnOpaqueActivityBelow(TransparentPolicyState r0, Consumer r1) {
            return r0.applyOnOpaqueActivityBelow(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mclearInheritedAppCompatDisplayInsets, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10356$$Nest$mclearInheritedAppCompatDisplayInsets(TransparentPolicyState r0) {
            r0.clearInheritedAppCompatDisplayInsets();
        }

        /* JADX INFO: renamed from: -$$Nest$mfindOpaqueNotFinishingActivityBelow, reason: not valid java name */
        static /* bridge */ /* synthetic */ Optional m10357$$Nest$mfindOpaqueNotFinishingActivityBelow(TransparentPolicyState r0) {
            return r0.findOpaqueNotFinishingActivityBelow();
        }

        /* JADX INFO: renamed from: -$$Nest$misRunning, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m10358$$Nest$misRunning(TransparentPolicyState r0) {
            return r0.isRunning();
        }

        /* JADX INFO: renamed from: -$$Nest$mreset, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10359$$Nest$mreset(TransparentPolicyState r0) {
            r0.reset();
        }

        /* JADX INFO: renamed from: -$$Nest$mstart, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m10360$$Nest$mstart(TransparentPolicyState r0, ActivityRecord r1) {
            r0.start(r1);
        }

        TransparentPolicyState(ActivityRecord activityRecord) {
            this.mInheritedOrientation = 0;
            this.mInheritedMinAspectRatio = 0.0f;
            this.mInheritedMaxAspectRatio = 0.0f;
            this.mInheritedAppCompatState = 0;
            this.mActivityRecord = activityRecord;
        }

        private void start(ActivityRecord firstOpaqueActivity) {
            this.mFirstOpaqueActivity = firstOpaqueActivity;
            TransparentPolicy.m10346$$Nest$fgetmDestroyListeners(this.mFirstOpaqueActivity.mAppCompatController.getTransparentPolicy()).add(this.mActivityRecord.mAppCompatController.getTransparentPolicy());
            inheritFromOpaque(firstOpaqueActivity);
            final WindowContainer<?> parent = this.mActivityRecord.getParent();
            this.mLetterboxConfigListener = WindowContainer.overrideConfigurationPropagation(this.mActivityRecord, this.mFirstOpaqueActivity, new TransparentPolicy$TransparentPolicyState$$ExternalSyntheticLambda1(this, parent));
        }

        private /* synthetic */ Configuration lambda$start$0(WindowContainer parent, Configuration opaqueConfig, Configuration transparentOverrideConfig) {
            if (isPolicyEnabled() == true) goto L6;
            transparentOverrideConfig.unset();
            return transparentOverrideConfig;
        L6:
            TransparentPolicy.m10347$$Nest$smresetTranslucentOverrideConfig(transparentOverrideConfig);
            Rect parentBounds = parent.getWindowConfiguration().getBounds();
            Rect bounds = transparentOverrideConfig.windowConfiguration.getBounds();
            Rect letterboxBounds = opaqueConfig.windowConfiguration.getBounds();
            bounds.set(parentBounds.left, parentBounds.top, parentBounds.left + letterboxBounds.width(), parentBounds.top + letterboxBounds.height());
            transparentOverrideConfig.windowConfiguration.setAppBounds(new Rect());
            inheritFromOpaque(this.mFirstOpaqueActivity);
            return transparentOverrideConfig;
        }

        private void inheritFromOpaque(ActivityRecord opaqueActivity) {
            if (this.mActivityRecord.getMinAspectRatio() == 0.0f) goto L6;
            this.mInheritedMinAspectRatio = opaqueActivity.getMinAspectRatio();
        L6:
            if (this.mActivityRecord.getMaxAspectRatio() == 0.0f) goto L8;
            this.mInheritedMaxAspectRatio = opaqueActivity.getMaxAspectRatio();
        L8:
            this.mInheritedOrientation = opaqueActivity.getRequestedConfigurationOrientation();
            this.mInheritedAppCompatState = opaqueActivity.getAppCompatState();
            this.mInheritedAppCompatDisplayInsets = opaqueActivity.getAppCompatDisplayInsets();
        }

        private void reset() {
            if (this.mLetterboxConfigListener == null) goto L5;
            this.mLetterboxConfigListener.onRemoved();
        L5:
            this.mLetterboxConfigListener = null;
            this.mInheritedOrientation = 0;
            this.mInheritedMinAspectRatio = 0.0f;
            this.mInheritedMaxAspectRatio = 0.0f;
            this.mInheritedAppCompatState = 0;
            this.mInheritedAppCompatDisplayInsets = null;
            if (this.mFirstOpaqueActivity == null) goto L8;
            TransparentPolicy.m10346$$Nest$fgetmDestroyListeners(this.mFirstOpaqueActivity.mAppCompatController.getTransparentPolicy()).remove(this.mActivityRecord.mAppCompatController.getTransparentPolicy());
        L8:
            this.mFirstOpaqueActivity = null;
        }

        private boolean isRunning() {
            if (this.mLetterboxConfigListener != null) goto L5;
        L7:
            return false;
        L5:
            if (isPolicyEnabled() == false) goto L7;
            return true;
        }

        private boolean isPolicyEnabled() {
            Task task = this.mActivityRecord.getTask();
            if (task != null) goto L5;
        L16:
            return false;
        L5:
            if (task.getWindowingMode() == 5) goto L16;
            if (this.mActivityRecord.mWmService.mFlags.mRespectNonTopVisibleFixedOrientation == true) goto L10;
            return true;
        L10:
            int orientation = this.mActivityRecord.getOverrideOrientation();
            if (orientation == (-1)) goto L15;
            if (this.mActivityRecord.handlesOrientationChangeFromDescendant(orientation) == false) goto L15;
            return false;
        L15:
            return true;
        }

        private void clearInheritedAppCompatDisplayInsets() {
            this.mInheritedAppCompatDisplayInsets = null;
        }

        private Optional<ActivityRecord> findOpaqueNotFinishingActivityBelow() {
            if (isRunning() == false) goto L10;
            if (this.mActivityRecord.getTask() == null) goto L10;
            return Optional.ofNullable(this.mFirstOpaqueActivity);
        L10:
            return Optional.empty();
        }

        private boolean applyOnOpaqueActivityBelow(final Consumer<ActivityRecord> consumer) {
            return ((Boolean) findOpaqueNotFinishingActivityBelow().map(new TransparentPolicy$TransparentPolicyState$$ExternalSyntheticLambda0(consumer)).orElse(false)).booleanValue();
        }

        private static /* synthetic */ Boolean lambda$applyOnOpaqueActivityBelow$1(Consumer consumer, ActivityRecord activityRecord) {
            consumer.accept(activityRecord);
            return true;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDestroyListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m10346$$Nest$fgetmDestroyListeners(TransparentPolicy r0) {
        return r0.mDestroyListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$smresetTranslucentOverrideConfig, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m10347$$Nest$smresetTranslucentOverrideConfig(Configuration r0) {
        resetTranslucentOverrideConfig(r0);
    }

    static {
        FIRST_OPAQUE_NOT_FINISHING_ACTIVITY_PREDICATE = new RecentsAnimation$$ExternalSyntheticLambda1();
    }

    TransparentPolicy(ActivityRecord activityRecord, final AppCompatConfiguration appCompatConfiguration) {
        this.mDestroyListeners = new ArrayList();
        this.mActivityRecord = activityRecord;
        appCompatConfiguration.getClass();
        this.mIsTranslucentLetterboxingEnabledSupplier = new TransparentPolicy$$ExternalSyntheticLambda0(appCompatConfiguration);
        this.mTransparentPolicyState = new TransparentPolicyState(activityRecord);
    }

    void start() {
        if (this.mIsTranslucentLetterboxingEnabledSupplier.getAsBoolean() == true) goto L5;
        return;
    L5:
        WindowContainer<?> parent = this.mActivityRecord.getParent();
        if (parent != null) goto L8;
        return;
    L8:
        boolean wasStarted = TransparentPolicyState.m10358$$Nest$misRunning(this.mTransparentPolicyState);
        TransparentPolicyState.m10359$$Nest$mreset(this.mTransparentPolicyState);
        ActivityRecord firstOpaqueActivity = this.mActivityRecord.getTask().getActivity(FIRST_OPAQUE_NOT_FINISHING_ACTIVITY_PREDICATE, this.mActivityRecord, false, true);
        if (shouldSkipTransparentPolicy(firstOpaqueActivity) == false) goto L13;
        if (wasStarted == false) goto L15;
        this.mActivityRecord.recomputeConfiguration();
        return;
    L15:
        return;
    L13:
        TransparentPolicyState.m10360$$Nest$mstart(this.mTransparentPolicyState, firstOpaqueActivity);
    }

    void stop() {
        int i = this.mDestroyListeners.size() - 1;
    L3:
        if (i < 0) goto L5;
        this.mDestroyListeners.get(i).start();
        i = i - 1;
        goto L3
    L5:
        this.mDestroyListeners.clear();
        TransparentPolicyState.m10359$$Nest$mreset(this.mTransparentPolicyState);
    }

    boolean isRunning() {
        return TransparentPolicyState.m10358$$Nest$misRunning(this.mTransparentPolicyState);
    }

    boolean hasInheritedOrientation() {
        if (isRunning() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mActivityRecord.getOverrideOrientation() == (-1)) goto L7;
        return true;
    }

    float getInheritedMinAspectRatio() {
        return TransparentPolicyState.m10353$$Nest$fgetmInheritedMinAspectRatio(this.mTransparentPolicyState);
    }

    float getInheritedMaxAspectRatio() {
        return TransparentPolicyState.m10352$$Nest$fgetmInheritedMaxAspectRatio(this.mTransparentPolicyState);
    }

    int getInheritedAppCompatState() {
        return TransparentPolicyState.m10351$$Nest$fgetmInheritedAppCompatState(this.mTransparentPolicyState);
    }

    int getInheritedOrientation() {
        return TransparentPolicyState.m10354$$Nest$fgetmInheritedOrientation(this.mTransparentPolicyState);
    }

    AppCompatDisplayInsets getInheritedAppCompatDisplayInsets() {
        return TransparentPolicyState.m10350$$Nest$fgetmInheritedAppCompatDisplayInsets(this.mTransparentPolicyState);
    }

    void clearInheritedAppCompatDisplayInsets() {
        TransparentPolicyState.m10356$$Nest$mclearInheritedAppCompatDisplayInsets(this.mTransparentPolicyState);
    }

    boolean applyOnOpaqueActivityBelow(Consumer<ActivityRecord> consumer) {
        return TransparentPolicyState.m10355$$Nest$mapplyOnOpaqueActivityBelow(this.mTransparentPolicyState, consumer);
    }

    Optional<ActivityRecord> getFirstOpaqueActivity() {
        if (isRunning() == false) goto L6;
        return Optional.ofNullable(TransparentPolicyState.m10349$$Nest$fgetmFirstOpaqueActivity(this.mTransparentPolicyState));
    L6:
        return Optional.empty();
    }

    Optional<ActivityRecord> findOpaqueNotFinishingActivityBelow() {
        return TransparentPolicyState.m10357$$Nest$mfindOpaqueNotFinishingActivityBelow(this.mTransparentPolicyState);
    }

    void dump(PrintWriter pw, String prefix) {
        pw.println(prefix + "isTransparentPolicyRunning=" + isRunning());
    }

    private boolean shouldSkipTransparentPolicy(ActivityRecord opaqueActivity) {
        if (opaqueActivity != null) goto L5;
    L19:
        return true;
    L5:
        if (opaqueActivity.isEmbedded() == true) goto L19;
        if (opaqueActivity.areBoundsLetterboxed() == false) goto L19;
        AppCompatSizeCompatModePolicy scmPolicy = this.mActivityRecord.mAppCompatController.getSizeCompatModePolicy();
        if (this.mActivityRecord.getTask() != null) goto L12;
    L18:
        return true;
    L12:
        if (this.mActivityRecord.fillsParent() == true) goto L18;
        if (scmPolicy.hasAppCompatDisplayInsetsWithoutInheritance() == true) goto L18;
        return false;
    }

    private static void resetTranslucentOverrideConfig(Configuration config) {
        config.orientation = 0;
        config.compatScreenWidthDp = 0;
        config.screenWidthDp = 0;
        config.compatScreenHeightDp = 0;
        config.screenHeightDp = 0;
        config.compatSmallestScreenWidthDp = 0;
        config.smallestScreenWidthDp = 0;
    }
}
