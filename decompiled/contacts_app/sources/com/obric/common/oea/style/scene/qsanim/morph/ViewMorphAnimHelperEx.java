package com.obric.common.oea.style.scene.qsanim.morph;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.obric.common.oea.foundation.animation.engine.DynamicAnimation;
import com.obric.common.oea.foundation.animation.engine.SpringAnimation;
import com.obric.common.oea.foundation.util.OEALogger;
import com.obric.common.oea.style.scene.qsanim.common.AnimViewParams;
import com.obric.common.oea.style.scene.qsanim.common.KtExt;
import com.obric.common.oea.style.scene.qsanim.common.SpringAnimUtils;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.sheet.v2.OSheetBaseKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: ViewMorphAnimHelperEx.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 f2\u00020\u0001:\u0002efB_\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJ\b\u0010/\u001a\u000200H\u0002J4\u00101\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b022\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0005H\u0014J\u001f\u00107\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u00109J\u001f\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u00109J\u0006\u0010<\u001a\u000200J\b\u0010=\u001a\u000200H\u0002J\b\u0010>\u001a\u000200H\u0002J\u0006\u0010?\u001a\u000200J\u0016\u0010@\u001a\u0002002\u0006\u00108\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0005J\u0006\u0010A\u001a\u000200J\u0012\u0010B\u001a\u00020\u00052\b\b\u0002\u0010C\u001a\u00020\rH\u0002J\u0012\u0010D\u001a\u00020\u00052\b\b\u0002\u0010C\u001a\u00020\rH\u0002J\u0012\u0010E\u001a\u00020\u00052\b\b\u0002\u0010C\u001a\u00020\rH\u0002J\r\u0010F\u001a\u00020GH\u0000¢\u0006\u0002\bHJ\u0012\u0010I\u001a\u00020\u00052\b\b\u0002\u0010C\u001a\u00020\rH\u0002J\u0006\u0010J\u001a\u000200J\b\u0010K\u001a\u00020\rH\u0002J\b\u0010L\u001a\u00020\rH\u0002J\u0018\u0010M\u001a\u0002002\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0005H\u0002J\u0006\u0010N\u001a\u000200J\u0006\u0010O\u001a\u000200J\u001e\u0010P\u001a\u0002002\u0006\u0010Q\u001a\u00020\u00052\u0006\u0010R\u001a\u00020\u00052\u0006\u0010S\u001a\u00020TJ\u000e\u0010U\u001a\u0002002\u0006\u0010V\u001a\u00020\u0011J\u0015\u0010W\u001a\u0002002\u0006\u0010X\u001a\u00020GH\u0000¢\u0006\u0002\bYJ\u0016\u0010Z\u001a\u0002002\u0006\u0010[\u001a\u00020\u00052\u0006\u0010\\\u001a\u00020\u0005J\u0016\u0010]\u001a\u0002002\u0006\u00108\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0005J\u0016\u0010^\u001a\u0002002\u0006\u0010Q\u001a\u00020\u00052\u0006\u0010R\u001a\u00020\u0005J\b\u0010_\u001a\u00020\rH\u0002JF\u0010`\u001a\u000200*\u00020\u00032\u0006\u0010P\u001a\u00020\r2\u0006\u0010Q\u001a\u00020\u00052\u0006\u0010R\u001a\u00020\u00052\u0006\u0010a\u001a\u00020\u00052\u0006\u0010b\u001a\u00020\u00052\u0006\u0010S\u001a\u00020T2\b\b\u0002\u0010c\u001a\u00020dH\u0002R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010+R\u0012\u0010,\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010+R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u0006g"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/morph/ViewMorphAnimHelperEx;", "", "view", "Landroid/view/View;", "morphFactorX", "", "morphFactorY", "leftMorphStartForce", "", "rightMorphStartForce", "upMorphStartForce", "downMorphStartForce", "invertYDirection", "", "invertXDirection", "(Landroid/view/View;FFIIIIZZ)V", "animationListener", "Lcom/obric/common/oea/style/scene/qsanim/morph/MorphAnimationListener;", "currentResetAnim", "Lcom/obric/common/oea/foundation/animation/engine/DynamicAnimation;", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "initialDownPoint", "Landroid/graphics/PointF;", "initialViewX", "initialViewXOffset", "initialViewY", "initialViewYOffset", "originalHeight", "originalHeightOffset", "originalWidth", "originalWidthOffset", "pResetAnimEndListener", "Lcom/obric/common/oea/foundation/animation/engine/DynamicAnimation$OnAnimationEndListener;", "pResetAnimListener", "Lcom/obric/common/oea/foundation/animation/engine/DynamicAnimation$OnAnimationUpdateListener;", "pSpring", "Lcom/obric/common/oea/style/scene/qsanim/common/SpringAnimUtils$CommonFloatProperty;", "resetAnimViewProp", "Lcom/obric/common/oea/style/scene/qsanim/morph/ViewMorphAnimHelperEx$AnimViewProp;", "scaleAnim", "Landroid/animation/AnimatorSet;", "skippedForceX", "Ljava/lang/Float;", "skippedForceY", "getView", "()Landroid/view/View;", "animResetView", "", "calculateNewSize", "Lkotlin/Pair;", MaterialConfigFormatNames.X, MaterialConfigFormatNames.Y, "dx", "dy", "calculateRealForceX", "forceX", "(FLjava/lang/Float;)F", "calculateRealForceY", "forceY", "cancelAnim", "cancelResetAnim", "cancelScaleAnim", "cancelScaleUp", "dragContinue", "dragEnd", "getInitialViewX", "includeOffset", "getInitialViewY", "getOriginalHeight", "getOriginalViewParams", "Lcom/obric/common/oea/style/scene/qsanim/common/AnimViewParams;", "getOriginalViewParams$style_standardRelease", "getOriginalWidth", "init", "isResetAnimRunning", "isScaleAnimRunning", "performViewMorph", "release", "resetOriginalViewSizeOffset", "scaleUp", "targetWidth", "targetHeight", "duration", "", "setAnimListener", "listener", "setOriginalViewParams", "viewParams", "setOriginalViewParams$style_standardRelease", "setOriginalViewSize", MaterialConfigFormatNames.WIDTH, MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "startDrag", "updateOriginalViewSizeOffset", "updateViewSize", "doScaleAnimation", "targetX", "targetY", "interpolator", "Landroid/view/animation/Interpolator;", "AnimViewProp", "Companion", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public class ViewMorphAnimHelperEx {
    public static final Companion Companion = null;
    private static final String TAG = "ViewMorphAnimHelper";
    private static int instanceNumber;
    private MorphAnimationListener animationListener;
    private DynamicAnimation<?> currentResetAnim;
    private final int downMorphStartForce;
    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private PointF initialDownPoint;
    private float initialViewX;
    private float initialViewXOffset;
    private float initialViewY;
    private float initialViewYOffset;
    private final boolean invertXDirection;
    private final boolean invertYDirection;
    private final int leftMorphStartForce;
    private final float morphFactorX;
    private final float morphFactorY;
    private float originalHeight;
    private float originalHeightOffset;
    private float originalWidth;
    private float originalWidthOffset;
    private final DynamicAnimation.OnAnimationEndListener pResetAnimEndListener;
    private final DynamicAnimation.OnAnimationUpdateListener pResetAnimListener;
    private SpringAnimUtils.CommonFloatProperty pSpring;
    private AnimViewProp resetAnimViewProp;
    private final int rightMorphStartForce;
    private AnimatorSet scaleAnim;
    private Float skippedForceX;
    private Float skippedForceY;
    private final int upMorphStartForce;
    private final View view;

    /* JADX INFO: compiled from: ViewMorphAnimHelperEx.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JL\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006\""}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/morph/ViewMorphAnimHelperEx$AnimViewProp;", "", "startW", "", "startH", "startX", "startY", "layoutGravity", "", "initPValue", "(FFFFLjava/lang/Integer;F)V", "getInitPValue", "()F", "getLayoutGravity", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStartH", "getStartW", "getStartX", "getStartY", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(FFFFLjava/lang/Integer;F)Lcom/obric/common/oea/style/scene/qsanim/morph/ViewMorphAnimHelperEx$AnimViewProp;", "equals", "", "other", "hashCode", "toString", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    private static final class AnimViewProp {
        private final float initPValue;
        private final Integer layoutGravity;
        private final float startH;
        private final float startW;
        private final float startX;
        private final float startY;

        public static /* synthetic */ AnimViewProp copy$default(AnimViewProp r4, float r5, float r6, float r7, float r8, Integer r9, float r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = r4.startW;
        L6:
            if ((r11 & 2) == 0) goto L8;
            r6 = r4.startH;
        L8:
            float r13 = r6;
            if ((r11 & 4) == 0) goto L11;
            r7 = r4.startX;
        L11:
            float r0 = r7;
            if ((r11 & 8) == 0) goto L14;
            r8 = r4.startY;
        L14:
            float r1 = r8;
            if ((r11 & 16) == 0) goto L17;
            r9 = r4.layoutGravity;
        L17:
            Integer r2 = r9;
            if ((r11 & 32) == 0) goto L20;
            r10 = r4.initPValue;
        L20:
            float r14 = r5;
            return r4.copy(r14, r13, r0, r1, r2, r10);
        }

        public final float component1() {
            return this.startW;
        }

        public final float component2() {
            return this.startH;
        }

        public final float component3() {
            return this.startX;
        }

        public final float component4() {
            return this.startY;
        }

        public final Integer component5() {
            return this.layoutGravity;
        }

        public final float component6() {
            return this.initPValue;
        }

        public final AnimViewProp copy(float r8, float r9, float r10, float r11, Integer r12, float r13) {
            return new AnimViewProp(r8, r9, r10, r11, r12, r13);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof AnimViewProp) == false) goto L18;
            AnimViewProp r4 = (AnimViewProp) r3;
            if (Float.compare(this.startW, r4.startW) == 0) goto L8;
            return false;
        L8:
            if (Float.compare(this.startH, r4.startH) == 0) goto L10;
            return false;
        L10:
            if (Float.compare(this.startX, r4.startX) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.startY, r4.startY) == 0) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.layoutGravity, r4.layoutGravity) == true) goto L16;
            return false;
        L16:
            if (Float.compare(this.initPValue, r4.initPValue) == 0) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public int hashCode() {
            int r0 = ((((((Float.hashCode(this.startW) * 31) + Float.hashCode(this.startH)) * 31) + Float.hashCode(this.startX)) * 31) + Float.hashCode(this.startY)) * 31;
            Integer r1 = this.layoutGravity;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return ((r0 + r2) * 31) + Float.hashCode(this.initPValue);
        L5:
            r2 = 0;
            goto L7
        }

        public String toString() {
            return "AnimViewProp(startW=" + this.startW + ", startH=" + this.startH + ", startX=" + this.startX + ", startY=" + this.startY + ", layoutGravity=" + this.layoutGravity + ", initPValue=" + this.initPValue + ")";
        }

        public AnimViewProp(float r1, float r2, float r3, float r4, Integer r5, float r6) {
            this.startW = r1;
            this.startH = r2;
            this.startX = r3;
            this.startY = r4;
            this.layoutGravity = r5;
            this.initPValue = r6;
        }

        public final float getStartW() {
            return this.startW;
        }

        public final float getStartH() {
            return this.startH;
        }

        public final float getStartX() {
            return this.startX;
        }

        public final float getStartY() {
            return this.startY;
        }

        public final Integer getLayoutGravity() {
            return this.layoutGravity;
        }

        public final float getInitPValue() {
            return this.initPValue;
        }
    }

    /* JADX INFO: compiled from: ViewMorphAnimHelperEx.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J?\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2%\b\u0002\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/morph/ViewMorphAnimHelperEx$Companion;", "", "()V", "TAG", "", "instanceNumber", "", "getFloatAnimator", "Landroid/animation/Animator;", "startValue", "", "targetValue", "updateAction", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static final /* synthetic */ Animator access$getFloatAnimator(Companion r0, float r1, float r2, Function1 r3) {
            return r0.getFloatAnimator(r1, r2, r3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        static /* synthetic */ Animator getFloatAnimator$default(Companion r0, float r1, float r2, Function1 r3, int r4, Object r5) {
            if ((r4 & 4) == 0) goto L6;
            r3 = null;
            Function1 r6 = (Function1) null;
        L6:
            return r0.getFloatAnimator(r1, r2, r3);
        }

        private final Animator getFloatAnimator(float r2, float r3, final Function1<? super Float, Unit> r4) {
            ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{r2, r3});
            r1.addUpdateListener(new ViewMorphAnimHelperEx$Companion$getFloatAnimator$$inlined$apply$lambda$1(r4));
            Intrinsics.checkNotNullExpressionValue(r1, "ValueAnimator.ofFloat(st…)\n            }\n        }");
            return r1;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ViewMorphAnimHelperEx(View r13) {
        this(r13, 0.0f, 0.0f, 0, 0, 0, 0, false, false, 510, null);
    }

    public ViewMorphAnimHelperEx(View r13, float r14) {
        this(r13, r14, 0.0f, 0, 0, 0, 0, false, false, 508, null);
    }

    public ViewMorphAnimHelperEx(View r13, float r14, float r15) {
        this(r13, r14, r15, 0, 0, 0, 0, false, false, 504, null);
    }

    public ViewMorphAnimHelperEx(View r13, float r14, float r15, int r16) {
        this(r13, r14, r15, r16, 0, 0, 0, false, false, 496, null);
    }

    public ViewMorphAnimHelperEx(View r13, float r14, float r15, int r16, int r17) {
        this(r13, r14, r15, r16, r17, 0, 0, false, false, OSheetBaseKt.SHEET_LANDSCAPE_MAX_WIDTH, null);
    }

    public ViewMorphAnimHelperEx(View r13, float r14, float r15, int r16, int r17, int r18) {
        this(r13, r14, r15, r16, r17, r18, 0, false, false, 448, null);
    }

    public ViewMorphAnimHelperEx(View r13, float r14, float r15, int r16, int r17, int r18, int r19) {
        this(r13, r14, r15, r16, r17, r18, r19, false, false, 384, null);
    }

    public ViewMorphAnimHelperEx(View r13, float r14, float r15, int r16, int r17, int r18, int r19, boolean r20) {
        this(r13, r14, r15, r16, r17, r18, r19, r20, false, 256, null);
    }

    public ViewMorphAnimHelperEx(View r2, float r3, float r4, int r5, int r6, int r7, int r8, boolean r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.view = r2;
        this.morphFactorX = r3;
        this.morphFactorY = r4;
        this.leftMorphStartForce = r5;
        this.rightMorphStartForce = r6;
        this.upMorphStartForce = r7;
        this.downMorphStartForce = r8;
        this.invertYDirection = r9;
        this.invertXDirection = r10;
        this.globalLayoutListener = new ViewMorphAnimHelperEx$globalLayoutListener$1(this);
        boolean r11 = false;
        float r12 = 0;
        if (r3 >= r12) goto L5;
    L7:
        boolean r13 = false;
    L8:
        if (r13 == false) goto L29;
        if (r4 >= r12) goto L12;
    L14:
        boolean r14 = false;
    L15:
        if (r14 == false) goto L27;
        if (r3 != 0.0f) goto L19;
    L20:
        r11 = true;
    L21:
        if (r11 == false) goto L25;
        instanceNumber++;
        this.pSpring = new SpringAnimUtils.CommonFloatProperty(0.0f);
        this.initialDownPoint = new PointF();
        this.resetAnimViewProp = new AnimViewProp(0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f);
        this.pResetAnimListener = new ViewMorphAnimHelperEx$pResetAnimListener$1(this);
        this.pResetAnimEndListener = new ViewMorphAnimHelperEx$pResetAnimEndListener$1(this);
        return;
    L25:
        throw new IllegalArgumentException("morphFactorX and morphFactorY can't be both non-zero".toString());
    L19:
        if (r4 != 0.0f) goto L21;
    L27:
        throw new IllegalArgumentException("morphFactorY must be in the range [0, 1]".toString());
    L12:
        if (r3 > 1.0f) goto L14;
        r14 = true;
        goto L15
    L29:
        throw new IllegalArgumentException("morphFactorX must be in the range [0, 1]".toString());
    L5:
        if (r3 > 1.0f) goto L7;
        r13 = true;
        goto L8
    }

    public static final /* synthetic */ MorphAnimationListener access$getAnimationListener$p(ViewMorphAnimHelperEx r0) {
        return r0.animationListener;
    }

    public static final /* synthetic */ float access$getInitialViewX(ViewMorphAnimHelperEx r0, boolean r1) {
        return r0.getInitialViewX(r1);
    }

    public static final /* synthetic */ float access$getInitialViewY(ViewMorphAnimHelperEx r0, boolean r1) {
        return r0.getInitialViewY(r1);
    }

    public static final /* synthetic */ AnimViewProp access$getResetAnimViewProp$p(ViewMorphAnimHelperEx r0) {
        return r0.resetAnimViewProp;
    }

    public static final /* synthetic */ void access$setAnimationListener$p(ViewMorphAnimHelperEx r0, MorphAnimationListener r1) {
        r0.animationListener = r1;
    }

    public static final /* synthetic */ void access$setResetAnimViewProp$p(ViewMorphAnimHelperEx r0, AnimViewProp r1) {
        r0.resetAnimViewProp = r1;
    }

    public static final /* synthetic */ boolean access$updateViewSize(ViewMorphAnimHelperEx r0) {
        return r0.updateViewSize();
    }

    public final View getView() {
        return this.view;
    }

    public /* synthetic */ ViewMorphAnimHelperEx(View r10, float r11, float r12, int r13, int r14, int r15, int r16, boolean r17, boolean r18, int r19, DefaultConstructorMarker r20) {
        float r2 = 0.0f;
        if ((r19 & 2) == 0) goto L5;
        float r1 = 0.0f;
    L7:
        if ((r19 & 4) != 0) goto L10;
        r2 = r12;
    L10:
        int r4 = Integer.MAX_VALUE;
        if ((r19 & 8) == 0) goto L13;
        int r3 = Integer.MAX_VALUE;
    L15:
        if ((r19 & 16) == 0) goto L17;
        int r5 = Integer.MAX_VALUE;
    L19:
        if ((r19 & 32) == 0) goto L21;
        int r6 = Integer.MAX_VALUE;
    L23:
        if ((r19 & 64) != 0) goto L26;
        r4 = r16;
    L26:
        boolean r8 = false;
        if ((r19 & 128) == 0) goto L29;
        boolean r7 = false;
    L31:
        if ((r19 & 256) != 0) goto L34;
        r8 = r18;
    L34:
        this(r10, r1, r2, r3, r5, r6, r4, r7, r8);
        return;
    L29:
        r7 = r17;
        goto L31
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r3 = r13;
        goto L15
    L5:
        r1 = r11;
        goto L7
    }

    public final void init() {
        if (this.originalWidth != 0.0f) goto L5;
    L6:
        this.view.getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
        OEALogger.INSTANCE.i(TAG, "init[" + instanceNumber + "], morphFactorX: " + this.morphFactorX + ", morphFactorY: " + this.morphFactorY + ", leftMorphStart: " + this.leftMorphStartForce + ", rightMorphStart: " + this.rightMorphStartForce + ", topMorphStart: " + this.upMorphStartForce + ", bottomMorphStart: " + this.downMorphStartForce);
        return;
    L5:
        if (this.originalHeight == 0.0f) goto L6;
    }

    public final void setAnimListener(MorphAnimationListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.animationListener = r2;
    }

    public final void release() {
        this.view.getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
    }

    public final void scaleUp(float r13, float r14, long r15) {
        float r5 = this.initialViewX + ((this.originalWidth - r13) / 2.0f);
        float r6 = this.initialViewY + ((this.originalHeight - r14) / 2.0f);
        doScaleAnimation$default(this, this.view, true, r13, r14, r5, r6, r15, null, 64, null);
    }

    public final void cancelScaleUp() {
        cancelScaleAnim();
    }

    public final void startDrag(float r7, float r8) {
        if (isResetAnimRunning() == true) goto L5;
        this.initialDownPoint = new PointF(r7, r8);
        Float r3 = (Float) null;
        this.skippedForceX = null;
        this.skippedForceY = null;
        OEALogger.INSTANCE.i(TAG, "startDrag, x: " + r7 + ", y: " + r8);
        return;
    L5:
        OEALogger.e$default(OEALogger.INSTANCE, TAG, "startDrag, x: " + r7 + ", y: " + r8 + ", anim running, skip!", null, 4, null);
    }

    public final void dragContinue(float r7, float r8) {
        if (isResetAnimRunning() == false) goto L5;
    L7:
        OEALogger.e$default(OEALogger.INSTANCE, TAG, "dragContinue, x: " + r7 + ", y: " + r8 + ", anim running, skip!", null, 4, null);
        this.skippedForceX = Float.valueOf(r7);
        this.skippedForceY = Float.valueOf(r8);
        return;
    L5:
        if (isScaleAnimRunning() == true) goto L7;
        performViewMorph(calculateRealForceX(r7, this.skippedForceX), calculateRealForceY(r8, this.skippedForceY));
    }

    public final void dragEnd() {
        if (isScaleAnimRunning() == false) goto L6;
        cancelScaleAnim();
    L6:
        if (isResetAnimRunning() == false) goto L9;
        cancelResetAnim();
    L9:
        if (isResetAnimRunning() == true) goto L11;
        OEALogger.INSTANCE.i(TAG, "dragEnd");
        animResetView();
        return;
    L11:
        OEALogger.e$default(OEALogger.INSTANCE, TAG, "dragEnd, anim running, skip!", null, 4, null);
    }

    public final void cancelAnim() {
        cancelScaleAnim();
        cancelResetAnim();
        MorphAnimationListener r1 = (MorphAnimationListener) null;
        this.animationListener = null;
    }

    private final float calculateRealForceX(float r4, Float r5) {
        if (this.invertXDirection == false) goto L12;
        if (r5 == null) goto L24;
        float r0 = r5.floatValue();
        int r1 = this.leftMorphStartForce;
        if (r0 <= r1) goto L9;
        float r3 = r1;
        float r6 = r5.floatValue();
    L22:
        return (r4 - r6) + r3;
    L9:
        float r2 = r5.floatValue();
        int r7 = this.rightMorphStartForce;
        if (r2 >= r7) goto L21;
        r3 = r7;
        r6 = r5.floatValue();
        goto L22
    L21:
        return r4;
    L24:
        return r4;
    L12:
        if (r5 == null) goto L25;
        float r8 = r5.floatValue();
        int r9 = this.rightMorphStartForce;
        if (r8 <= r9) goto L18;
        r3 = r9;
        r6 = r5.floatValue();
        goto L22
    L18:
        float r10 = r5.floatValue();
        int r11 = this.leftMorphStartForce;
        if (r10 >= r11) goto L23;
        r3 = r11;
        r6 = r5.floatValue();
        goto L22
    L23:
        return r4;
    L25:
        return r4;
    }

    private final float calculateRealForceY(float r4, Float r5) {
        if (this.invertYDirection == false) goto L12;
        if (r5 == null) goto L24;
        float r0 = r5.floatValue();
        int r1 = this.upMorphStartForce;
        if (r0 <= r1) goto L9;
        float r3 = r1;
        float r6 = r5.floatValue();
    L22:
        return (r4 - r6) + r3;
    L9:
        float r2 = r5.floatValue();
        int r7 = this.downMorphStartForce;
        if (r2 >= r7) goto L21;
        r3 = r7;
        r6 = r5.floatValue();
        goto L22
    L21:
        return r4;
    L24:
        return r4;
    L12:
        if (r5 == null) goto L25;
        float r8 = r5.floatValue();
        int r9 = this.downMorphStartForce;
        if (r8 <= r9) goto L18;
        r3 = r9;
        r6 = r5.floatValue();
        goto L22
    L18:
        float r10 = r5.floatValue();
        int r11 = this.upMorphStartForce;
        if (r10 >= r11) goto L23;
        r3 = r11;
        r6 = r5.floatValue();
        goto L22
    L23:
        return r4;
    L25:
        return r4;
    }

    public final void setOriginalViewSize(float r4, float r5) {
        this.originalWidth = r4;
        this.originalHeight = r5;
        OEALogger.INSTANCE.i(TAG, "setOriginalViewSize, width: " + r4 + ", height: " + r5 + ", initialViewX: " + this.initialViewX + ", initialViewY: " + this.initialViewY);
    }

    public final AnimViewParams getOriginalViewParams$style_standardRelease() {
        return new AnimViewParams(getOriginalWidth$default(this, false, 1, null), getOriginalHeight$default(this, false, 1, null), this.initialViewX, this.initialViewY);
    }

    public final void setOriginalViewParams$style_standardRelease(AnimViewParams r7) {
        Intrinsics.checkNotNullParameter(r7, "viewParams");
        if (r7.getViewWidth() != 0.0f) goto L5;
    L7:
        OEALogger.e$default(OEALogger.INSTANCE, TAG, "setOriginalViewParams, invalid viewParams: " + r7, null, 4, null);
        return;
    L5:
        if (r7.getViewHeight() == 0.0f) goto L7;
        this.originalWidth = r7.getViewWidth();
        this.originalHeight = r7.getViewHeight();
        this.initialViewX = r7.getViewX();
        this.initialViewY = r7.getViewY();
    }

    private final boolean updateViewSize() {
        float r0 = this.view.getWidth();
        float r1 = this.view.getHeight();
        if (r0 != 0.0f) goto L5;
    L8:
        OEALogger.e$default(OEALogger.INSTANCE, TAG, "updateViewSize: width or height is zero", null, 4, null);
        return false;
    L5:
        if (r1 == 0.0f) goto L8;
        this.originalWidth = r0;
        this.originalHeight = r1;
        this.initialViewY = this.view.getY();
        this.initialViewX = this.view.getX();
        SpringAnimUtils.INSTANCE.clearAnimCache();
        OEALogger.INSTANCE.i(TAG, "instance: " + instanceNumber + ", updateViewSize, originalWidth: " + getOriginalWidth$default(this, false, 1, null) + ", originalHeight: " + getOriginalHeight$default(this, false, 1, null) + ", initialViewX: " + this.initialViewX + ", initialViewY: " + this.initialViewY);
        return true;
    }

    private final void performViewMorph(float r8, float r9) {
        if (this.morphFactorX == 0.0f) goto L5;
    L8:
        float r0 = r8 - this.initialDownPoint.x;
        int r3 = -1;
        if (this.invertXDirection == false) goto L11;
        int r2 = -1;
    L12:
        float r1 = r0 * r2;
        float r4 = r9 - this.initialDownPoint.y;
        if (this.invertYDirection == true) goto L16;
        r3 = 1;
    L16:
        float r5 = r4 * r3;
        Pair<Integer, Integer> r10 = calculateNewSize(r8, r9, r1, r5);
        if (r10.getSecond().intValue() != getOriginalHeight(true)) goto L21;
        if (r10.getFirst().intValue() != getOriginalWidth(true)) goto L21;
        return;
    L21:
        if (this.morphFactorX == 0.0f) goto L28;
        if (r1 >= 0) goto L25;
        float r11 = getInitialViewX$default(this, false, 1, null) - (r10.getFirst().floatValue() - getOriginalWidth(true));
    L26:
        this.view.setX(r11);
        goto L28
    L25:
        r11 = getInitialViewX$default(this, false, 1, null);
    L28:
        if (this.morphFactorY != 0.0f) goto L30;
    L34:
        ViewGroup.LayoutParams r12 = this.view.getLayoutParams();
        r12.width = r10.getFirst().intValue();
        r12.height = r10.getSecond().intValue();
        this.view.requestLayout();
        return;
    L30:
        if (r5 >= 0) goto L32;
        float r13 = getInitialViewY$default(this, false, 1, null) - (r10.getSecond().floatValue() - getOriginalHeight(true));
    L33:
        this.view.setY(r13);
        goto L34
    L32:
        r13 = getInitialViewY$default(this, false, 1, null);
        goto L33
    L11:
        r2 = 1;
        goto L12
    L5:
        if (this.morphFactorY != 0.0f) goto L8;
        OEALogger.INSTANCE.i(TAG, "performViewMorph: morphFactorX and morphFactorY are both zero, skip");
    }

    protected Pair<Integer, Integer> calculateNewSize(float r12, float r13, float r14, float r15) {
        float r0 = 0;
        if (r14 <= r0) goto L5;
        float r1 = RangesKt.coerceAtLeast(r12 - this.rightMorphStartForce, 0.0f);
    L7:
        if (r15 <= r0) goto L9;
        float r2 = RangesKt.coerceAtMost(r13 - this.downMorphStartForce, 0.0f);
    L10:
        float r10 = KtExt.dampedClamp$default(KtExt.INSTANCE, r1, this.morphFactorX * getOriginalWidth(true), 0.0f, 4, null);
        float r3 = KtExt.dampedClamp$default(KtExt.INSTANCE, r2, this.morphFactorY * getOriginalHeight(true), 0.0f, 4, null);
        float r4 = this.view.getWidth();
        float r5 = this.view.getHeight();
        float r6 = ((r4 * r3) * (-1.0f)) / r5;
        float r7 = ((r5 * r10) * (-1.0f)) / r4;
        Pair<Integer, Integer> r8 = new Pair(Integer.valueOf(MathKt.roundToInt((getOriginalWidth(true) + r10) + r6)), Integer.valueOf(MathKt.roundToInt((getOriginalHeight(true) + r3) + r7)));
        if (this.morphFactorX == 0.0f) goto L14;
        OEALogger.INSTANCE.d(TAG, "calculateNewSize, newWidth: " + r8.getFirst().intValue() + ", newHeight: " + r8.getSecond().intValue() + ", x: " + r12 + ", dx: " + r14 + ", coercedDx: " + r1 + ", leftStart: " + this.leftMorphStartForce + ", rightStart: " + this.rightMorphStartForce);
    L14:
        if (this.morphFactorY == 0.0f) goto L16;
        OEALogger.INSTANCE.d(TAG, "calculateNewSize, newWidth: " + r8.getFirst().intValue() + ", newHeight: " + r8.getSecond().intValue() + ", y: " + r13 + ", dy: " + r15 + ", coercedDy: " + r2 + ", upStart: " + this.upMorphStartForce + ", downStart: " + this.downMorphStartForce);
    L16:
        return r8;
    L9:
        r2 = RangesKt.coerceAtLeast(r13 - this.upMorphStartForce, 0.0f);
        goto L10
    L5:
        r1 = RangesKt.coerceAtMost(r12 - this.leftMorphStartForce, 0.0f);
        goto L7
    }

    public final void updateOriginalViewSizeOffset(float r5, float r6) {
        if (this.originalWidthOffset == 0.0f) goto L5;
        return;
    L5:
        if (this.originalHeightOffset == 0.0f) goto L7;
        return;
    L7:
        if (this.initialViewXOffset == 0.0f) goto L9;
        return;
    L9:
        if (this.initialViewYOffset != 0.0f) goto L15;
        this.originalWidthOffset = r5 - getOriginalWidth$default(this, false, 1, null);
        float r7 = r6 - getOriginalHeight$default(this, false, 1, null);
        this.originalHeightOffset = r7;
        this.initialViewXOffset = (-this.originalWidthOffset) / 2.0f;
        this.initialViewYOffset = (-r7) / 2.0f;
        OEALogger.INSTANCE.i(TAG, "updateOriginalViewSizeOffset, initialViewWidthOffset: " + this.originalWidthOffset + ", initialViewHeightOffset: " + this.originalHeightOffset + ", initialViewXOffset: " + this.initialViewXOffset + ", initialViewYOffset: " + this.initialViewYOffset);
        OEALogger.INSTANCE.i(TAG, "updateOriginalViewSizeOffset, currentViewWidth: " + this.view.getWidth() + ", currentViewHeight: " + this.view.getHeight() + ", currentViewX: " + this.view.getX() + ", currentViewY: " + this.view.getY());
        return;
    }

    public final void resetOriginalViewSizeOffset() {
        this.originalWidthOffset = 0.0f;
        this.originalHeightOffset = 0.0f;
        this.initialViewXOffset = 0.0f;
        this.initialViewYOffset = 0.0f;
        OEALogger.INSTANCE.i(TAG, "resetOriginalViewSizeOffset");
    }

    private final float getInitialViewX(boolean r1) {
        if (r1 == false) goto L5;
        return this.initialViewX + this.initialViewXOffset;
    L5:
        return this.initialViewX;
    }

    static /* synthetic */ float getInitialViewX$default(ViewMorphAnimHelperEx r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = true;
    L7:
        return r0.getInitialViewX(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInitialViewX");
    }

    private final float getInitialViewY(boolean r1) {
        if (r1 == false) goto L5;
        return this.initialViewY + this.initialViewYOffset;
    L5:
        return this.initialViewY;
    }

    static /* synthetic */ float getInitialViewY$default(ViewMorphAnimHelperEx r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = true;
    L7:
        return r0.getInitialViewY(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getInitialViewY");
    }

    private final float getOriginalWidth(boolean r1) {
        if (r1 == false) goto L5;
        return this.originalWidth + this.originalWidthOffset;
    L5:
        return this.originalWidth;
    }

    static /* synthetic */ float getOriginalWidth$default(ViewMorphAnimHelperEx r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = false;
    L7:
        return r0.getOriginalWidth(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOriginalWidth");
    }

    private final float getOriginalHeight(boolean r1) {
        if (r1 == false) goto L5;
        return this.originalHeight + this.originalHeightOffset;
    L5:
        return this.originalHeight;
    }

    static /* synthetic */ float getOriginalHeight$default(ViewMorphAnimHelperEx r0, boolean r1, int r2, Object r3) {
        if (r3 != null) goto L9;
        if ((r2 & 1) == 0) goto L7;
        r1 = false;
    L7:
        return r0.getOriginalHeight(r1);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOriginalHeight");
    }

    private final boolean isResetAnimRunning() {
        DynamicAnimation<?> r1 = this.currentResetAnim;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.isRunning() != true) goto L7;
        return true;
    }

    private final boolean isScaleAnimRunning() {
        AnimatorSet r1 = this.scaleAnim;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.isRunning() != true) goto L7;
        return true;
    }

    private final void cancelScaleAnim() {
        AnimatorSet r0 = this.scaleAnim;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        AnimatorSet r1 = (AnimatorSet) null;
        this.scaleAnim = null;
    }

    private final void cancelResetAnim() {
        DynamicAnimation<?> r0 = this.currentResetAnim;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        DynamicAnimation<?> r1 = this.currentResetAnim;
        if (r1 == null) goto L8;
        r1.removeUpdateListener(this.pResetAnimListener);
    L8:
        DynamicAnimation<?> r2 = this.currentResetAnim;
        if (r2 == null) goto L11;
        r2.removeEndListener(this.pResetAnimEndListener);
    L11:
        SpringAnimUtils.INSTANCE.cancelSpring(this.pSpring, SpringAnimUtils.INSTANCE.getPROPERTY_FLOAT());
    }

    private final void animResetView() {
        float r3 = this.view.getWidth();
        float r4 = this.view.getHeight();
        float r5 = this.view.getX();
        float r6 = this.view.getY();
        KtExt r1 = KtExt.INSTANCE;
        ViewGroup.LayoutParams r2 = this.view.getLayoutParams();
        if (r2 != null) goto L6;
    L4:
        r2 = null;
    L7:
        FrameLayout.LayoutParams r7 = (FrameLayout.LayoutParams) r2;
        if (r7 == null) goto L10;
        Integer r8 = Integer.valueOf(r7.gravity);
    L11:
        OEALogger.INSTANCE.i(TAG, "animResetView, startW: " + r3 + ", startH: " + r4 + ", startX: " + r5 + ", startY: " + r6);
        float r9 = ((r4 - getOriginalHeight$default(this, false, 1, null)) / getOriginalHeight$default(this, false, 1, null)) * 500.0f;
        this.resetAnimViewProp = new AnimViewProp(r3, r4, r5, r6, r8, r9);
        SpringAnimUtils r10 = SpringAnimUtils.INSTANCE;
        SpringAnimUtils.CommonFloatProperty r11 = this.pSpring;
        r11.setValue(r9);
        Unit r12 = Unit.INSTANCE;
        SpringAnimation r13 = SpringAnimUtils.springTo$default(r10, r11, SpringAnimUtils.INSTANCE.getPROPERTY_FLOAT(), 0.0f, 0.0f, 0.0f, this.pResetAnimListener, this.pResetAnimEndListener, 12, null);
        this.currentResetAnim = r13;
        if (r13 == null) goto L17;
        MorphAnimationListener r0 = this.animationListener;
        if (r0 == null) goto L18;
        r0.onAnimationStart(MorphAnimType.SCALE_DOWN);
        return;
    L18:
        return;
    L17:
        return;
    L10:
        r8 = null;
        goto L11
    L6:
        if ((r2 instanceof FrameLayout.LayoutParams) == false) goto L4;
        goto L4
    }

    static /* synthetic */ void doScaleAnimation$default(ViewMorphAnimHelperEx r11, View r12, boolean r13, float r14, float r15, float r16, float r17, long r18, Interpolator r20, int r21, Object r22) {
        if (r22 != null) goto L10;
        if ((r21 & 64) == 0) goto L6;
        Interpolator r10 = new DecelerateInterpolator(1.5f);
    L7:
        r11.doScaleAnimation(r12, r13, r14, r15, r16, r17, r18, r10);
        return;
    L6:
        r10 = r20;
        goto L7
    L10:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doScaleAnimation");
    }

    private final void doScaleAnimation(final View r23, final boolean r24, final float r25, final float r26, final float r27, final float r28, final long r29, final Interpolator r31) {
        AnimatorSet r1 = this.scaleAnim;
        final Integer r2 = null;
        if (r1 != null) goto L5;
    L10:
        if (r24 == false) goto L12;
        MorphAnimType r3 = MorphAnimType.SCALE_UP;
    L13:
        final MorphAnimType r9 = r3;
        float r4 = r23.getWidth();
        float r5 = r23.getHeight();
        float r6 = r23.getX();
        float r7 = r23.getY();
        KtExt r8 = KtExt.INSTANCE;
        ViewGroup.LayoutParams r10 = r23.getLayoutParams();
        if (r10 != null) goto L17;
    L15:
        r10 = null;
    L18:
        FrameLayout.LayoutParams r11 = (FrameLayout.LayoutParams) r10;
        if (r11 == null) goto L21;
        r2 = Integer.valueOf(r11.gravity);
    L21:
        Companion r12 = Companion;
        final Animator r16 = Companion.access$getFloatAnimator(r12, r6, r27, new ViewMorphAnimHelperEx$doScaleAnimation$xAnimator$1(r23, r2));
        final Animator r17 = Companion.access$getFloatAnimator(r12, r7, r28, new ViewMorphAnimHelperEx$doScaleAnimation$yAnimator$1(r23, r2));
        final Animator r18 = Companion.access$getFloatAnimator(r12, r4, r25, new ViewMorphAnimHelperEx$doScaleAnimation$widthAnimator$1(r23));
        final Animator r19 = Companion.access$getFloatAnimator(r12, r5, r26, new ViewMorphAnimHelperEx$doScaleAnimation$heightAnimator$1(r23));
        AnimatorSet r13 = new AnimatorSet();
        r13.addListener(new ViewMorphAnimHelperEx$doScaleAnimation$$inlined$apply$lambda$1(this, r24, r25, r26, r27, r28, r29, r9, r31, r16, r17, r18, r19));
        r13.setInterpolator(r31);
        r13.setDuration(r29);
        r13.playTogether(new Animator[]{r16, r17, r18, r19});
        Unit r0 = Unit.INSTANCE;
        this.scaleAnim = r13;
        r13.start();
        return;
    L17:
        if ((r10 instanceof FrameLayout.LayoutParams) == false) goto L15;
    L12:
        r3 = MorphAnimType.SCALE_DOWN;
        goto L13
    L5:
        if (r1.isRunning() != true) goto L10;
        AnimatorSet r14 = this.scaleAnim;
        if (r14 == null) goto L9;
        r14.cancel();
    L9:
        AnimatorSet r15 = (AnimatorSet) null;
        this.scaleAnim = null;
        goto L10
    }
}
