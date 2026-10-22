package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u001a\u0015\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\n\u001ae\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u00122!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0014H\u0082@¢\u0006\u0002\u0010\u0019\u001a(\u0010\u001a\u001a\u0002H\u001b\"\u000e\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u001c*\b\u0012\u0004\u0012\u0002H\u001b0\u001dH\u0082\u0002¢\u0006\u0002\u0010\u001e\u001a(\u0010\u001f\u001a\u0002H\u001b\"\u000e\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u001b0\u001c*\b\u0012\u0004\u0012\u0002H\u001b0\u001dH\u0082\u0002¢\u0006\u0002\u0010\u001e\u001ak\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f*\u00020\u000e2\u0006\u0010!\u001a\u00020\u00062\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0#2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0014H\u0082@¢\u0006\u0002\u0010$\u001as\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\f*\u00020\u000e2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0#2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\b2!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0014H\u0082@¢\u0006\u0002\u0010(\u001a\u0014\u0010)\u001a\u00020\u0006*\u00020\u00062\u0006\u0010*\u001a\u00020\u0006H\u0002\u001a'\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0006H\u0000¢\u0006\u0004\b7\u00108\u001a\u0017\u0010;\u001a\u00020\u00182\f\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=H\u0082\b\"\u0016\u0010+\u001a\u00020,X\u0080\u0004¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.\"\u000e\u00100\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u00101\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u00109\u001a\u00020:X\u0082T¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"snapFlingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "snapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "rememberSnapFlingBehavior", "(Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "approach", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialTargetOffset", "initialVelocity", GXTemplateKey.GAIAX_ANIMATION, "Landroidx/compose/foundation/gestures/snapping/ApproachAnimation;", "onAnimationStep", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "delta", "", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLandroidx/compose/foundation/gestures/snapping/ApproachAnimation;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/ranges/ClosedFloatingPointRange;", "(Lkotlin/ranges/ClosedFloatingPointRange;)Ljava/lang/Comparable;", "component2", "animateDecay", "targetOffset", "animationState", "Landroidx/compose/animation/core/AnimationState;", "(Landroidx/compose/foundation/gestures/ScrollScope;FLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateWithTarget", "cancelOffset", "animationSpec", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLandroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coerceToTarget", PickerReporterConstants.KEY.TARGET, "MinFlingVelocityDp", "Landroidx/compose/ui/unit/Dp;", "getMinFlingVelocityDp", "()F", FaceService.girlLabel, "NoDistance", "NoVelocity", "calculateFinalOffset", "snappingOffset", "Landroidx/compose/foundation/gestures/snapping/FinalSnappingItem;", "lowerBound", "upperBound", "calculateFinalOffset-Fhqu1e0", "(IFF)F", "DEBUG", "", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SnapFlingBehaviorKt {
    private static final boolean DEBUG = false;
    private static final float MinFlingVelocityDp = 0.0f;
    public static final float NoDistance = 0.0f;
    public static final float NoVelocity = 0.0f;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt", f = "SnapFlingBehavior.kt", i = {0, 0, 0}, l = {308}, m = "animateDecay", n = {"animationState", "previousValue", "targetOffset"}, s = {"L$0", "L$1", "F$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r100) {
            super(r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return SnapFlingBehaviorKt.access$animateDecay(null, 0.0f, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateWithTarget$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt", f = "SnapFlingBehavior.kt", i = {0, 0, 0, 0}, l = {349}, m = "animateWithTarget", n = {"animationState", "consumedUpToNow", "targetOffset", "initialVelocity"}, s = {"L$0", "L$1", "F$0", "F$1"})
    public static final class C86011 extends ContinuationImpl {
        float F$0;
        float F$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C86011(Continuation<? super C86011> r100) {
            super(r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return SnapFlingBehaviorKt.access$animateWithTarget(null, 0.0f, 0.0f, null, null, null, this);
        }
    }

    public static /* synthetic */ Unit a(float r100, Ref.FloatRef r101, ScrollScope r102, Function1 r103, AnimationScope r104) {
        return animateWithTarget$lambda$3(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ Unit b(float r100, Ref.FloatRef r101, ScrollScope r102, Function1 r103, AnimationScope r104) {
        return animateDecay$lambda$1(r100, r101, r102, r103, r104);
    }

    private static final boolean calculateFinalOffset_Fhqu1e0$isValidDistance(float r100) {
        if (r100 != Float.POSITIVE_INFINITY) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
    L13:
        return false;
    L8:
        if (r100 != Float.NEGATIVE_INFINITY) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L13;
        return true;
    L10:
        r102 = false;
        goto L11
    L5:
        r101 = false;
        goto L6
    }

    private static final void debugLog(Function0<String> r100) {
    }

    static {
        MinFlingVelocityDp = Dp.m7544constructorimpl(400);
    }

    public static final float getMinFlingVelocityDp() {
        return MinFlingVelocityDp;
    }

    private static final <T extends Comparable<? super T>> T component1(ClosedFloatingPointRange<T> r100) {
        return r100.getStart();
    }

    private static final <T extends Comparable<? super T>> T component2(ClosedFloatingPointRange<T> r100) {
        return r100.getEndInclusive();
    }

    private static final float coerceToTarget(float r100, float r101) {
        if (r101 != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return 0.0f;
    L9:
        if (r101 <= 0.0f) goto L12;
        return RangesKt.coerceAtMost(r100, r101);
    L12:
        return RangesKt.coerceAtLeast(r100, r101);
    L5:
        r102 = false;
        goto L6
    }

    /* JADX INFO: renamed from: calculateFinalOffset-Fhqu1e0, reason: not valid java name */
    public static final float m551calculateFinalOffsetFhqu1e0(int r100, float r101, float r102) {
        FinalSnappingItem.Companion r103 = FinalSnappingItem.Companion;
        if (FinalSnappingItem.m544equalsimpl0(r100, r103.m548getClosestItembbeMdSM()) == false) goto L8;
        if (Math.abs(r102) > Math.abs(r101)) goto L15;
    L9:
        r101 = r102;
    L15:
        if (calculateFinalOffset_Fhqu1e0$isValidDistance(r101) == true) goto L17;
        return 0.0f;
    L17:
        return r101;
    L8:
        if (FinalSnappingItem.m544equalsimpl0(r100, r103.m549getNextItembbeMdSM()) == true) goto L9;
        if (FinalSnappingItem.m544equalsimpl0(r100, r103.m550getPreviousItembbeMdSM()) == true) goto L15;
        r101 = 0.0f;
        goto L15
    }

    public static final TargetedFlingBehavior rememberSnapFlingBehavior(SnapLayoutInfoProvider r100, Composer r101, int r102) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1921733134, r102, -1, "androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior (SnapFlingBehavior.kt:230)");
    L5:
        Object r103 = (Density) r101.consume(CompositionLocalsKt.getLocalDensity());
        boolean r104 = false;
        DecayAnimationSpec r105 = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(r101, 0);
        if (((r102 & 14) ^ 6) <= 4) goto L10;
        if (r101.changed(r100) == false) goto L10;
    L11:
        r104 = true;
    L12:
        boolean r106 = (r101.changed(r105) | r104) | r101.changed(r103);
        Object r107 = r101.rememberedValue();
        if (r106 == false) goto L15;
    L16:
        r107 = snapFlingBehavior(r100, r105, AnimationSpecKt.spring$default(0.0f, 400.0f, null, 5, null));
        r101.updateRememberedValue(r107);
    L17:
        TargetedFlingBehavior r108 = (TargetedFlingBehavior) r107;
        if (ComposerKt.isTraceInProgress() == false) goto L20;
        ComposerKt.traceEventEnd();
    L20:
        return r108;
    L15:
        if (r107 != Composer.Companion.getEmpty()) goto L17;
    L10:
        if ((r102 & 6) != 4) goto L12;
        goto L11
    }

    public static final TargetedFlingBehavior snapFlingBehavior(SnapLayoutInfoProvider r100, DecayAnimationSpec<Float> r101, AnimationSpec<Float> r102) {
        return new SnapFlingBehavior(r100, r101, r102);
    }

    private static final void animateDecay$consumeDelta(AnimationScope<Float, AnimationVector1D> r100, ScrollScope r101, Function1<? super Float, Unit> r102, float r103) {
        float r104 = r101.scrollBy(r103);     // Catch: CancellationException -> L4
    L5:
        r102.invoke(Float.valueOf(r104));
        if (Math.abs(r103 - r104) <= 0.5f) goto L11;
        r100.cancelAnimation();
        return;
    L11:
        return;
    L4:
        r100.cancelAnimation();
        r104 = 0.0f;
        goto L5
    }

    private static final Unit animateDecay$lambda$1(float r100, Ref.FloatRef r101, ScrollScope r102, Function1 r103, AnimationScope r104) {
        if (Math.abs(((Number) r104.getValue()).floatValue()) < Math.abs(r100)) goto L5;
        float r105 = coerceToTarget(((Number) r104.getValue()).floatValue(), r100);
        animateDecay$consumeDelta(r104, r102, r103, r105 - r101.element);
        r104.cancelAnimation();
        r101.element = r105;
    L7:
        return Unit.INSTANCE;
    L5:
        animateDecay$consumeDelta(r104, r102, r103, ((Number) r104.getValue()).floatValue() - r101.element);
        r101.element = ((Number) r104.getValue()).floatValue();
        goto L7
    }

    private static final Unit animateWithTarget$lambda$3(float r100, Ref.FloatRef r101, ScrollScope r102, Function1 r103, AnimationScope r104) {
        float r105 = coerceToTarget(((Number) r104.getValue()).floatValue(), r100);
        float r106 = r105 - r101.element;
        float r107 = r102.scrollBy(r106);     // Catch: CancellationException -> L5
    L6:
        r103.invoke(Float.valueOf(r107));
        if (Math.abs(r106 - r107) <= 0.5f) goto L9;
    L13:
        r104.cancelAnimation();
    L14:
        r101.element += r107;
        return Unit.INSTANCE;
    L9:
        if (r105 != ((Number) r104.getValue()).floatValue()) goto L11;
        boolean r108 = true;
    L12:
        if (r108 == true) goto L14;
    L11:
        r108 = false;
    L5:
        r104.cancelAnimation();
        r107 = 0.0f;
        goto L6
    }

    public static final /* synthetic */ Object access$animateDecay(ScrollScope r100, float r101, AnimationState r102, DecayAnimationSpec r103, Function1 r104, Continuation r105) {
        return animateDecay(r100, r101, r102, r103, r104, r105);
    }

    public static final /* synthetic */ Object access$approach(ScrollScope r100, float r101, float r102, ApproachAnimation r103, Function1 r104, Continuation r105) {
        return approach(r100, r101, r102, r103, r104, r105);
    }

    private static final Object animateDecay(final ScrollScope r100, final float r101, AnimationState<Float, AnimationVector1D> r102, DecayAnimationSpec<Float> r103, final Function1<? super Float, Unit> r104, Continuation<? super AnimationResult<Float, AnimationVector1D>> r110) {
        if ((r110 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r105 = (AnonymousClass1) r110;
        int r106 = r105.label;
        if ((r106 & Integer.MIN_VALUE) == 0) goto L7;
        r105.label = r106 - Integer.MIN_VALUE;
    L8:
        Object r111 = r105.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r105.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        r101 = r105.F$0;
        Ref.FloatRef r109 = (Ref.FloatRef) r105.L$1;
        r102 = (AnimationState) r105.L$0;
        ResultKt.throwOnFailure(r111);
    L23:
        return new AnimationResult(Boxing.boxFloat(r101 - r109.element), r102);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        final Ref.FloatRef r112 = new Ref.FloatRef();
        if (r102.getVelocity().floatValue() != 0.0f) goto L17;
        boolean r113 = true;
    L18:
        Function1 r114 = new c(r101, r112, r100, r104);
        r105.L$0 = r102;
        r105.L$1 = r112;
        r105.F$0 = r101;
        r105.label = 1;
        if (SuspendAnimationKt.animateDecay(r102, r103, !r113, r114, r105) != r107) goto L21;
        return r107;
    L21:
        r109 = r112;
        goto L23
    L17:
        r113 = false;
    L7:
        r105 = new AnonymousClass1(r110);
        goto L8
    }

    private static final Object approach(ScrollScope r100, float r101, float r102, ApproachAnimation<Float, AnimationVector1D> r103, Function1<? super Float, Unit> r110, Continuation<? super AnimationResult<Float, AnimationVector1D>> r111) {
        return r103.approachAnimation(r100, Boxing.boxFloat(r101), Boxing.boxFloat(r102), r110, r111);
    }

    public static final /* synthetic */ Object access$animateWithTarget(ScrollScope r100, float r101, float r102, AnimationState r103, AnimationSpec r104, Function1 r105, Continuation r106) {
        return animateWithTarget(r100, r101, r102, r103, r104, r105, r106);
    }

    private static final Object animateWithTarget(final ScrollScope r110, float r111, final float r112, AnimationState<Float, AnimationVector1D> r113, AnimationSpec<Float> r114, final Function1<? super Float, Unit> r115, Continuation<? super AnimationResult<Float, AnimationVector1D>> r116) {
        if ((r116 instanceof C86011) == false) goto L7;
        C86011 r100 = (C86011) r116;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        C86011 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        float r106 = r102.F$1;
        float r107 = r102.F$0;
        Ref.FloatRef r108 = (Ref.FloatRef) r102.L$1;
        AnimationState<Float, AnimationVector1D> r109 = (AnimationState) r102.L$0;
        ResultKt.throwOnFailure(r103);
        float r117 = r107;
        AnimationState<Float, AnimationVector1D> r118 = r109;
    L23:
        return new AnimationResult(Boxing.boxFloat(r117 - r108.element), AnimationStateKt.copy$default(r118, 0.0f, coerceToTarget(r118.getVelocity().floatValue(), r106), 0, 0, false, 29, null));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        final Ref.FloatRef r119 = new Ref.FloatRef();
        float r120 = r113.getVelocity().floatValue();
        Float r121 = Boxing.boxFloat(r111);
        if (r113.getVelocity().floatValue() != 0.0f) goto L17;
        boolean r122 = true;
    L18:
        Function1 r123 = new d(r112, r119, r110, r115);
        r102.L$0 = r113;
        r102.L$1 = r119;
        r117 = r111;
        r102.F$0 = r117;
        r102.F$1 = r120;
        r102.label = 1;
        if (SuspendAnimationKt.animateTo(r113, r121, r114, !r122, r123, r102) != r104) goto L21;
        return r104;
    L21:
        r108 = r119;
        r106 = r120;
        r118 = r113;
        goto L23
    L17:
        r122 = false;
    L7:
        r100 = new C86011(r116);
        goto L8
    }
}
