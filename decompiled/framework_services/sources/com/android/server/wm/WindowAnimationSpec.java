package com.android.server.wm;

import android.graphics.Insets;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.SystemClock;
import android.pico.utils.ExtImplFactory;
import android.util.proto.ProtoOutputStream;
import android.view.SurfaceControl;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public class WindowAnimationSpec implements LocalAnimationAdapter.AnimationSpec {
    private Animation mAnimation;
    private final boolean mCanSkipFirstFrame;
    private IExtWindowAnimationSpec mExt;
    private final boolean mIsAppAnimation;
    private final Point mPosition;
    private final Rect mRootTaskBounds;
    private int mRootTaskClipMode;
    private final ThreadLocal<TmpValues> mThreadLocalTmps;
    private final Rect mTmpRect;
    private final float mWindowCornerRadius;

    private static class TmpValues {
        final float[] floats;
        final Transformation transformation;

        /* synthetic */ TmpValues(WindowAnimationSpecIA r1) {
            this();
        }

        private TmpValues() {
            this.transformation = new Transformation();
            this.floats = new float[9];
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$O4wc4-tRjiP9nCMbsYU_dS1zsf4, reason: not valid java name */
    public static /* synthetic */ TmpValues m10376$r8$lambda$O4wc4tRjiP9nCMbsYU_dS1zsf4() {
        return new TmpValues(null);
    }

    public IExtWindowAnimationSpec getExt() {
        return this.mExt;
    }

    public WindowAnimationSpec(Animation animation, Point position, boolean canSkipFirstFrame, float windowCornerRadius) {
        this(animation, position, null, canSkipFirstFrame, 1, false, windowCornerRadius);
    }

    public WindowAnimationSpec(Animation animation, Point position, Rect rootTaskBounds, boolean canSkipFirstFrame, int rootTaskClipMode, boolean isAppAnimation, float windowCornerRadius) {
        this.mPosition = new Point();
        this.mExt = (IExtWindowAnimationSpec) ExtImplFactory.getImpl(IExtWindowAnimationSpec.class, new Object[]{this});
        this.mThreadLocalTmps = ThreadLocal.withInitial(new WindowAnimationSpec$$ExternalSyntheticLambda0());
        this.mRootTaskBounds = new Rect();
        this.mTmpRect = new Rect();
        this.mAnimation = animation;
        if (position == null) goto L5;
        this.mPosition.set(position.x, position.y);
    L5:
        this.mWindowCornerRadius = windowCornerRadius;
        this.mCanSkipFirstFrame = canSkipFirstFrame;
        this.mIsAppAnimation = isAppAnimation;
        this.mRootTaskClipMode = rootTaskClipMode;
        if (rootTaskBounds == null) goto L9;
        this.mRootTaskBounds.set(rootTaskBounds);
        return;
    }

    @Override // com.android.server.wm.LocalAnimationAdapter.AnimationSpec
    public WindowAnimationSpec asWindowAnimationSpec() {
        return this;
    }

    @Override // com.android.server.wm.LocalAnimationAdapter.AnimationSpec
    public boolean getShowWallpaper() {
        return this.mAnimation.getShowWallpaper();
    }

    @Override // com.android.server.wm.LocalAnimationAdapter.AnimationSpec
    public boolean getShowBackground() {
        return this.mAnimation.getShowBackdrop();
    }

    @Override // com.android.server.wm.LocalAnimationAdapter.AnimationSpec
    public int getBackgroundColor() {
        return this.mAnimation.getBackdropColor();
    }

    public boolean hasExtension() {
        if (this.mAnimation.getExtensionEdges() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.server.wm.LocalAnimationAdapter.AnimationSpec
    public long getDuration() {
        return this.mAnimation.computeDurationHint();
    }

    public Rect getRootTaskBounds() {
        return this.mRootTaskBounds;
    }

    public Animation getAnimation() {
        return this.mAnimation;
    }

    @Override // com.android.server.wm.LocalAnimationAdapter.AnimationSpec
    public void apply(SurfaceControl.Transaction t, SurfaceControl leash, long currentPlayTime) {
        TmpValues tmp = this.mThreadLocalTmps.get();
        tmp.transformation.clear();
        this.mAnimation.getTransformation(currentPlayTime, tmp.transformation);
        tmp.transformation.getMatrix().postTranslate(this.mPosition.x, this.mPosition.y);
        getExt().onApply(tmp.transformation, tmp.floats);
        t.setMatrix(leash, tmp.transformation.getMatrix(), tmp.floats);
        t.setAlpha(leash, tmp.transformation.getAlpha());
        boolean cropSet = false;
        if (this.mRootTaskClipMode == 1) goto L5;
        this.mTmpRect.set(this.mRootTaskBounds);
        if (tmp.transformation.hasClipRect() == false) goto L10;
        this.mTmpRect.intersect(tmp.transformation.getClipRect());
    L10:
        accountForExtension(tmp.transformation, this.mTmpRect);
        t.setWindowCrop(leash, this.mTmpRect);
        cropSet = true;
    L11:
        if (cropSet == true) goto L13;
        return;
    L13:
        if (this.mAnimation.hasRoundedCorners() == true) goto L15;
        return;
    L15:
        if (this.mWindowCornerRadius <= 0.0f) goto L20;
        t.setCornerRadius(leash, this.mWindowCornerRadius);
        return;
    L20:
        return;
    L5:
        if (tmp.transformation.hasClipRect() == false) goto L11;
        Rect clipRect = tmp.transformation.getClipRect();
        accountForExtension(tmp.transformation, clipRect);
        t.setWindowCrop(leash, clipRect);
        cropSet = true;
        goto L11
    }

    private void accountForExtension(Transformation transformation, Rect clipRect) {
        Insets extensionInsets = Insets.min(transformation.getInsets(), Insets.NONE);
        if (extensionInsets.equals(Insets.NONE) == true) goto L6;
        clipRect.inset(extensionInsets);
        return;
    }

    @Override // com.android.server.wm.LocalAnimationAdapter.AnimationSpec
    public long calculateStatusBarTransitionStartTime() {
        TranslateAnimation openTranslateAnimation = findTranslateAnimation(this.mAnimation);
        if (openTranslateAnimation == null) goto L13;
        if (openTranslateAnimation.isXAxisTransition() == true) goto L7;
    L10:
        float t = findAlmostThereFraction(openTranslateAnimation.getInterpolator());
        return ((SystemClock.uptimeMillis() + openTranslateAnimation.getStartOffset()) + ((long) (openTranslateAnimation.getDuration() * t))) - 120;
    L7:
        if (openTranslateAnimation.isFullWidthTranslate() == false) goto L10;
        float t2 = findMiddleOfTranslationFraction(openTranslateAnimation.getInterpolator());
        return ((SystemClock.uptimeMillis() + openTranslateAnimation.getStartOffset()) + ((long) (openTranslateAnimation.getDuration() * t2))) - 60;
    L13:
        return SystemClock.uptimeMillis();
    }

    @Override // com.android.server.wm.LocalAnimationAdapter.AnimationSpec
    public boolean canSkipFirstFrame() {
        return this.mCanSkipFirstFrame;
    }

    @Override // com.android.server.wm.LocalAnimationAdapter.AnimationSpec
    public Point getLeashPosition() {
        return getExt().getCurrentPosition();
    }

    @Override // com.android.server.wm.LocalAnimationAdapter.AnimationSpec
    public boolean needsEarlyWakeup() {
        return this.mIsAppAnimation;
    }

    @Override // com.android.server.wm.LocalAnimationAdapter.AnimationSpec
    public void dump(PrintWriter pw, String prefix) {
        pw.print(prefix);
        pw.println(this.mAnimation);
    }

    @Override // com.android.server.wm.LocalAnimationAdapter.AnimationSpec
    public void dumpDebugInner(ProtoOutputStream proto) {
        long token = proto.start(1146756268033L);
        proto.write(1138166333441L, this.mAnimation.toString());
        proto.end(token);
    }

    private static TranslateAnimation findTranslateAnimation(Animation animation) {
        if ((animation instanceof TranslateAnimation) == false) goto L7;
        return (TranslateAnimation) animation;
    L7:
        if ((animation instanceof AnimationSet) == false) goto L16;
        AnimationSet set = (AnimationSet) animation;
        int i = 0;
    L10:
        if (i >= set.getAnimations().size()) goto L20;
        Animation a = set.getAnimations().get(i);
        if ((a instanceof TranslateAnimation) == true) goto L14;
        i = i + 1;
        goto L10
    L14:
        return (TranslateAnimation) a;
    L20:
        return null;
    L16:
        return null;
    }

    private static float findAlmostThereFraction(Interpolator interpolator) {
        return findInterpolationAdjustedTargetFraction(interpolator, 0.99f, 0.01f);
    }

    private float findMiddleOfTranslationFraction(Interpolator interpolator) {
        return findInterpolationAdjustedTargetFraction(interpolator, 0.5f, 0.01f);
    }

    private static float findInterpolationAdjustedTargetFraction(Interpolator interpolator, float target, float epsilon) {
        float val = 0.5f;
        float adj = 0.25f;
    L4:
        if (adj < epsilon) goto L10;
        if (interpolator.getInterpolation(val) >= target) goto L8;
        val = val + adj;
    L9:
        adj = adj / 2.0f;
        goto L4
    L8:
        val = val - adj;
        goto L9
    L10:
        return val;
    }
}
