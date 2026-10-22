package androidx.compose.animation.core;

import C7.c;
import C7.f;
import C7.r;
import S7.k;
import S7.n;
import S7.o;
import androidx.annotation.RestrictTo;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.Transition.DeferredAnimation;
import androidx.compose.animation.core.Transition.TransitionAnimationState;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.exifinterface.media.ExifInterface;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.i;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a/\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a5\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\t\u0010\n\u001a5\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\f\u001ac\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0012R\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0000\"\b\b\u0002\u0010\u000f*\u00020\u000e*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00102\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001aO\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0015¢\u0006\u0002\b\u0016H\u0087\b¢\u0006\u0004\b\u0018\u0010\u0019\u001aC\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u001a\u001a\u00028\u00012\u0006\u0010\u0001\u001a\u00028\u00012\u0006\u0010\u001b\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0094\u0001\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\"\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0000\"\b\b\u0002\u0010\u000f*\u00020\u000e*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00102%\b\n\u0010 \u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001f0\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0015¢\u0006\u0002\b\u0016H\u0087\b¢\u0006\u0004\b#\u0010$\u001ao\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010\"\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0000\"\b\b\u0002\u0010\u000f*\u00020\u000e*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010%\u001a\u00028\u00012\u0006\u0010&\u001a\u00028\u00012\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010\u001f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b(\u0010)\u001ap\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\"\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u00042%\b\n\u0010 \u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u001f0\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020*0\u0015¢\u0006\u0002\b\u0016H\u0087\b¢\u0006\u0004\b+\u0010,\u001ap\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\"\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u00042%\b\n\u0010 \u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0\u001f0\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020-0\u0015¢\u0006\u0002\b\u0016H\u0087\b¢\u0006\u0004\b.\u0010,\u001ap\u00100\u001a\b\u0012\u0004\u0012\u00020/0\"\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u00042%\b\n\u0010 \u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\u001f0\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020/0\u0015¢\u0006\u0002\b\u0016H\u0087\b¢\u0006\u0004\b0\u0010,\u001ap\u00102\u001a\b\u0012\u0004\u0012\u0002010\"\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u00042%\b\n\u0010 \u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u001f0\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002010\u0015¢\u0006\u0002\b\u0016H\u0087\b¢\u0006\u0004\b2\u0010,\u001ap\u00104\u001a\b\u0012\u0004\u0012\u0002030\"\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u00042%\b\n\u0010 \u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u001f0\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002030\u0015¢\u0006\u0002\b\u0016H\u0087\b¢\u0006\u0004\b4\u0010,\u001ap\u00106\u001a\b\u0012\u0004\u0012\u0002050\"\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u00042%\b\n\u0010 \u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050\u001f0\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002050\u0015¢\u0006\u0002\b\u0016H\u0087\b¢\u0006\u0004\b6\u0010,\u001ap\u00108\u001a\b\u0012\u0004\u0012\u0002070\"\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u00042%\b\n\u0010 \u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002070\u001f0\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002070\u0015¢\u0006\u0002\b\u0016H\u0087\b¢\u0006\u0004\b8\u0010,\u001ap\u0010:\u001a\b\u0012\u0004\u0012\u0002090\"\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u00042%\b\n\u0010 \u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u001f0\u0015¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002090\u0015¢\u0006\u0002\b\u0016H\u0087\b¢\u0006\u0004\b:\u0010,\"\u0014\u0010;\u001a\u0002058\u0000X\u0080T¢\u0006\u0006\n\u0004\b;\u0010<\"$\u0010?\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030=\u0012\u0004\u0012\u00020>0\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@\"\u001b\u0010F\u001a\u00020A8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0014\u0010G\u001a\u00020*8\u0002X\u0082T¢\u0006\u0006\n\u0004\bG\u0010H\"\u0014\u0010I\u001a\u00020*8\u0002X\u0082T¢\u0006\u0006\n\u0004\bI\u0010H\"\u0014\u0010J\u001a\u00020*8\u0002X\u0082T¢\u0006\u0006\n\u0004\bJ\u0010H\"\u0014\u0010K\u001a\u00020*8\u0002X\u0082T¢\u0006\u0006\n\u0004\bK\u0010H\"\u0014\u0010L\u001a\u00020*8\u0002X\u0082T¢\u0006\u0006\n\u0004\bL\u0010H¨\u0006M"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "targetState", "", "label", "Landroidx/compose/animation/core/Transition;", "updateTransition", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/core/TransitionState;", "transitionState", "rememberTransition", "(Landroidx/compose/animation/core/TransitionState;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", ExifInterface.LATITUDE_SOUTH, "Landroidx/compose/animation/core/AnimationVector;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/TwoWayConverter;", "typeConverter", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "createDeferredAnimation", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition$DeferredAnimation;", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "transformToChildState", "createChildTransition", "(Landroidx/compose/animation/core/Transition;Ljava/lang/String;LS7/o;Landroidx/compose/runtime/Composer;II)Landroidx/compose/animation/core/Transition;", "initialState", "childLabel", "createChildTransitionInternal", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/Transition;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "transitionSpec", "targetValueByState", "Landroidx/compose/runtime/State;", "animateValue", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;LS7/o;Ljava/lang/String;LS7/o;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "initialValue", "targetValue", "animationSpec", "createTransitionAnimation", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "", "animateFloat", "(Landroidx/compose/animation/core/Transition;LS7/o;Ljava/lang/String;LS7/o;Landroidx/compose/runtime/Composer;II)Landroidx/compose/runtime/State;", "Landroidx/compose/ui/unit/Dp;", "animateDp", "Landroidx/compose/ui/geometry/Offset;", "animateOffset", "Landroidx/compose/ui/geometry/Size;", "animateSize", "Landroidx/compose/ui/unit/IntOffset;", "animateIntOffset", "", "animateInt", "Landroidx/compose/ui/unit/IntSize;", "animateIntSize", "Landroidx/compose/ui/geometry/Rect;", "animateRect", "AnimationDebugDurationScale", "I", "Landroidx/compose/animation/core/SeekableTransitionState;", "LC7/r;", "SeekableTransitionStateTotalDurationChanged", "LS7/k;", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "SeekableStateObserver$delegate", "LC7/f;", "getSeekableStateObserver", "()Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "SeekableStateObserver", "NoReset", "F", "ResetNoSnap", "ResetAnimationSnap", "ResetAnimationSnapCurrent", "ResetAnimationSnapTarget", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TransitionKt {
    public static final int AnimationDebugDurationScale = 1;
    private static final float NoReset = -1.0f;
    private static final float ResetAnimationSnap = -3.0f;
    private static final float ResetAnimationSnapCurrent = -4.0f;
    private static final float ResetAnimationSnapTarget = -5.0f;
    private static final float ResetNoSnap = -2.0f;
    private static final k SeekableTransitionStateTotalDurationChanged = new k() { // from class: androidx.compose.animation.core.TransitionKt$SeekableTransitionStateTotalDurationChanged$1
        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((SeekableTransitionState<?>) obj);
            return r.f317a;
        }

        public final void invoke(SeekableTransitionState<?> seekableTransitionState) {
            seekableTransitionState.onTotalDurationChanged$animation_core_release();
        }
    };
    private static final f SeekableStateObserver$delegate = kotlin.a.b(LazyThreadSafetyMode.c, new S7.a() { // from class: androidx.compose.animation.core.TransitionKt$SeekableStateObserver$2
        @Override // S7.a
        public final SnapshotStateObserver invoke() {
            SnapshotStateObserver snapshotStateObserver = new SnapshotStateObserver(new k() { // from class: androidx.compose.animation.core.TransitionKt$SeekableStateObserver$2.1
                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((S7.a) obj);
                    return r.f317a;
                }

                public final void invoke(S7.a aVar) {
                    aVar.invoke();
                }
            });
            snapshotStateObserver.start();
            return snapshotStateObserver;
        }
    });

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final <S> State<Dp> animateDp(Transition<S> transition, o oVar, String str, o oVar2, Composer composer, int i, int i6) {
        if ((i6 & 1) != 0) {
            oVar = new o() { // from class: androidx.compose.animation.core.TransitionKt.animateDp.1
                @Override // S7.o
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
                }

                @Composable
                public final SpringSpec<Dp> invoke(Transition.Segment<S> segment, Composer composer2, int i10) {
                    composer2.startReplaceGroup(-575880366);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-575880366, i10, -1, "androidx.compose.animation.core.animateDp.<anonymous> (Transition.kt:1992)");
                    }
                    SpringSpec<Dp> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, Dp.m6842boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Dp.INSTANCE)), 3, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return springSpecSpring$default;
                }
            };
        }
        if ((i6 & 2) != 0) {
            str = "DpAnimation";
        }
        String str2 = str;
        int i10 = i & 14;
        int i11 = i << 3;
        int i12 = i10 | (i11 & 896) | (i11 & 7168) | (i11 & 57344);
        int i13 = (i12 >> 9) & 112;
        return createTransitionAnimation(transition, oVar2.invoke(transition.getCurrentState(), composer, Integer.valueOf(i13)), oVar2.invoke(transition.getTargetState(), composer, Integer.valueOf(i13)), (FiniteAnimationSpec) oVar.invoke(transition.getSegment(), composer, Integer.valueOf((i12 >> 3) & 112)), VectorConvertersKt.getVectorConverter(Dp.INSTANCE), str2, composer, (i12 & 14) | ((i12 << 6) & 458752));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final <S> State<Float> animateFloat(Transition<S> transition, o oVar, String str, o oVar2, Composer composer, int i, int i6) {
        if ((i6 & 1) != 0) {
            oVar = new o() { // from class: androidx.compose.animation.core.TransitionKt.animateFloat.1
                @Composable
                public final SpringSpec<Float> invoke(Transition.Segment<S> segment, Composer composer2, int i10) {
                    composer2.startReplaceGroup(-522164544);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-522164544, i10, -1, "androidx.compose.animation.core.animateFloat.<anonymous> (Transition.kt:1962)");
                    }
                    SpringSpec<Float> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return springSpecSpring$default;
                }

                @Override // S7.o
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
                }
            };
        }
        if ((i6 & 2) != 0) {
            str = "FloatAnimation";
        }
        String str2 = str;
        int i10 = i & 14;
        int i11 = i << 3;
        int i12 = i10 | (i11 & 896) | (i11 & 7168) | (i11 & 57344);
        int i13 = (i12 >> 9) & 112;
        return createTransitionAnimation(transition, oVar2.invoke(transition.getCurrentState(), composer, Integer.valueOf(i13)), oVar2.invoke(transition.getTargetState(), composer, Integer.valueOf(i13)), (FiniteAnimationSpec) oVar.invoke(transition.getSegment(), composer, Integer.valueOf((i12 >> 3) & 112)), VectorConvertersKt.getVectorConverter(kotlin.jvm.internal.f.f4924a), str2, composer, (i12 & 14) | ((i12 << 6) & 458752));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final <S> State<Integer> animateInt(Transition<S> transition, o oVar, String str, o oVar2, Composer composer, int i, int i6) {
        if ((i6 & 1) != 0) {
            oVar = new o() { // from class: androidx.compose.animation.core.TransitionKt.animateInt.1
                @Override // S7.o
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
                }

                @Composable
                public final SpringSpec<Integer> invoke(Transition.Segment<S> segment, Composer composer2, int i10) {
                    composer2.startReplaceGroup(-785273069);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-785273069, i10, -1, "androidx.compose.animation.core.animateInt.<anonymous> (Transition.kt:2116)");
                    }
                    SpringSpec<Integer> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, 1, 3, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return springSpecSpring$default;
                }
            };
        }
        if ((i6 & 2) != 0) {
            str = "IntAnimation";
        }
        String str2 = str;
        int i10 = i & 14;
        int i11 = i << 3;
        int i12 = i10 | (i11 & 896) | (i11 & 7168) | (i11 & 57344);
        int i13 = (i12 >> 9) & 112;
        return createTransitionAnimation(transition, oVar2.invoke(transition.getCurrentState(), composer, Integer.valueOf(i13)), oVar2.invoke(transition.getTargetState(), composer, Integer.valueOf(i13)), (FiniteAnimationSpec) oVar.invoke(transition.getSegment(), composer, Integer.valueOf((i12 >> 3) & 112)), VectorConvertersKt.getVectorConverter(i.f4925a), str2, composer, (i12 & 14) | ((i12 << 6) & 458752));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final <S> State<IntOffset> animateIntOffset(Transition<S> transition, o oVar, String str, o oVar2, Composer composer, int i, int i6) {
        if ((i6 & 1) != 0) {
            oVar = new o() { // from class: androidx.compose.animation.core.TransitionKt.animateIntOffset.1
                @Composable
                public final SpringSpec<IntOffset> invoke(Transition.Segment<S> segment, Composer composer2, int i10) {
                    composer2.startReplaceGroup(-1953479610);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1953479610, i10, -1, "androidx.compose.animation.core.animateIntOffset.<anonymous> (Transition.kt:2086)");
                    }
                    SpringSpec<IntOffset> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, IntOffset.m6963boximpl(IntOffsetKt.IntOffset(1, 1)), 3, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return springSpecSpring$default;
                }

                @Override // S7.o
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
                }
            };
        }
        if ((i6 & 2) != 0) {
            str = "IntOffsetAnimation";
        }
        String str2 = str;
        int i10 = i & 14;
        int i11 = i << 3;
        int i12 = i10 | (i11 & 896) | (i11 & 7168) | (i11 & 57344);
        int i13 = (i12 >> 9) & 112;
        return createTransitionAnimation(transition, oVar2.invoke(transition.getCurrentState(), composer, Integer.valueOf(i13)), oVar2.invoke(transition.getTargetState(), composer, Integer.valueOf(i13)), (FiniteAnimationSpec) oVar.invoke(transition.getSegment(), composer, Integer.valueOf((i12 >> 3) & 112)), VectorConvertersKt.getVectorConverter(IntOffset.INSTANCE), str2, composer, (i12 & 14) | ((i12 << 6) & 458752));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final <S> State<IntSize> animateIntSize(Transition<S> transition, o oVar, String str, o oVar2, Composer composer, int i, int i6) {
        if ((i6 & 1) != 0) {
            oVar = new o() { // from class: androidx.compose.animation.core.TransitionKt.animateIntSize.1
                @Composable
                public final SpringSpec<IntSize> invoke(Transition.Segment<S> segment, Composer composer2, int i10) {
                    composer2.startReplaceGroup(967893300);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(967893300, i10, -1, "androidx.compose.animation.core.animateIntSize.<anonymous> (Transition.kt:2147)");
                    }
                    SpringSpec<IntSize> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, IntSize.m7007boximpl(IntSizeKt.IntSize(1, 1)), 3, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return springSpecSpring$default;
                }

                @Override // S7.o
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
                }
            };
        }
        if ((i6 & 2) != 0) {
            str = "IntSizeAnimation";
        }
        String str2 = str;
        int i10 = i & 14;
        int i11 = i << 3;
        int i12 = i10 | (i11 & 896) | (i11 & 7168) | (i11 & 57344);
        int i13 = (i12 >> 9) & 112;
        return createTransitionAnimation(transition, oVar2.invoke(transition.getCurrentState(), composer, Integer.valueOf(i13)), oVar2.invoke(transition.getTargetState(), composer, Integer.valueOf(i13)), (FiniteAnimationSpec) oVar.invoke(transition.getSegment(), composer, Integer.valueOf((i12 >> 3) & 112)), VectorConvertersKt.getVectorConverter(IntSize.INSTANCE), str2, composer, (i12 & 14) | ((i12 << 6) & 458752));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final <S> State<Offset> animateOffset(Transition<S> transition, o oVar, String str, o oVar2, Composer composer, int i, int i6) {
        if ((i6 & 1) != 0) {
            oVar = new o() { // from class: androidx.compose.animation.core.TransitionKt.animateOffset.1
                @Override // S7.o
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
                }

                @Composable
                public final SpringSpec<Offset> invoke(Transition.Segment<S> segment, Composer composer2, int i10) {
                    composer2.startReplaceGroup(1623385561);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1623385561, i10, -1, "androidx.compose.animation.core.animateOffset.<anonymous> (Transition.kt:2023)");
                    }
                    SpringSpec<Offset> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, Offset.m3884boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Offset.INSTANCE)), 3, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return springSpecSpring$default;
                }
            };
        }
        if ((i6 & 2) != 0) {
            str = "OffsetAnimation";
        }
        String str2 = str;
        int i10 = i & 14;
        int i11 = i << 3;
        int i12 = i10 | (i11 & 896) | (i11 & 7168) | (i11 & 57344);
        int i13 = (i12 >> 9) & 112;
        return createTransitionAnimation(transition, oVar2.invoke(transition.getCurrentState(), composer, Integer.valueOf(i13)), oVar2.invoke(transition.getTargetState(), composer, Integer.valueOf(i13)), (FiniteAnimationSpec) oVar.invoke(transition.getSegment(), composer, Integer.valueOf((i12 >> 3) & 112)), VectorConvertersKt.getVectorConverter(Offset.INSTANCE), str2, composer, (i12 & 14) | ((i12 << 6) & 458752));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final <S> State<Rect> animateRect(Transition<S> transition, o oVar, String str, o oVar2, Composer composer, int i, int i6) {
        if ((i6 & 1) != 0) {
            oVar = new o() { // from class: androidx.compose.animation.core.TransitionKt.animateRect.1
                @Composable
                public final SpringSpec<Rect> invoke(Transition.Segment<S> segment, Composer composer2, int i10) {
                    composer2.startReplaceGroup(691336298);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(691336298, i10, -1, "androidx.compose.animation.core.animateRect.<anonymous> (Transition.kt:2177)");
                    }
                    SpringSpec<Rect> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, VisibilityThresholdsKt.getVisibilityThreshold(Rect.INSTANCE), 3, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return springSpecSpring$default;
                }

                @Override // S7.o
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
                }
            };
        }
        if ((i6 & 2) != 0) {
            str = "RectAnimation";
        }
        String str2 = str;
        int i10 = i & 14;
        int i11 = i << 3;
        int i12 = i10 | (i11 & 896) | (i11 & 7168) | (i11 & 57344);
        int i13 = (i12 >> 9) & 112;
        return createTransitionAnimation(transition, oVar2.invoke(transition.getCurrentState(), composer, Integer.valueOf(i13)), oVar2.invoke(transition.getTargetState(), composer, Integer.valueOf(i13)), (FiniteAnimationSpec) oVar.invoke(transition.getSegment(), composer, Integer.valueOf((i12 >> 3) & 112)), VectorConvertersKt.getVectorConverter(Rect.INSTANCE), str2, composer, (i12 & 14) | ((i12 << 6) & 458752));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final <S> State<Size> animateSize(Transition<S> transition, o oVar, String str, o oVar2, Composer composer, int i, int i6) {
        if ((i6 & 1) != 0) {
            oVar = new o() { // from class: androidx.compose.animation.core.TransitionKt.animateSize.1
                @Override // S7.o
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
                }

                @Composable
                public final SpringSpec<Size> invoke(Transition.Segment<S> segment, Composer composer2, int i10) {
                    composer2.startReplaceGroup(-1607152761);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1607152761, i10, -1, "androidx.compose.animation.core.animateSize.<anonymous> (Transition.kt:2054)");
                    }
                    SpringSpec<Size> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, Size.m3952boximpl(VisibilityThresholdsKt.getVisibilityThreshold(Size.INSTANCE)), 3, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return springSpecSpring$default;
                }
            };
        }
        if ((i6 & 2) != 0) {
            str = "SizeAnimation";
        }
        String str2 = str;
        int i10 = i & 14;
        int i11 = i << 3;
        int i12 = i10 | (i11 & 896) | (i11 & 7168) | (i11 & 57344);
        int i13 = (i12 >> 9) & 112;
        return createTransitionAnimation(transition, oVar2.invoke(transition.getCurrentState(), composer, Integer.valueOf(i13)), oVar2.invoke(transition.getTargetState(), composer, Integer.valueOf(i13)), (FiniteAnimationSpec) oVar.invoke(transition.getSegment(), composer, Integer.valueOf((i12 >> 3) & 112)), VectorConvertersKt.getVectorConverter(Size.INSTANCE), str2, composer, (i12 & 14) | ((i12 << 6) & 458752));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final <S, T, V extends AnimationVector> State<T> animateValue(Transition<S> transition, TwoWayConverter<T, V> twoWayConverter, o oVar, String str, o oVar2, Composer composer, int i, int i6) {
        if ((i6 & 2) != 0) {
            oVar = new o() { // from class: androidx.compose.animation.core.TransitionKt.animateValue.1
                @Composable
                public final SpringSpec<T> invoke(Transition.Segment<S> segment, Composer composer2, int i10) {
                    composer2.startReplaceGroup(-895531546);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-895531546, i10, -1, "androidx.compose.animation.core.animateValue.<anonymous> (Transition.kt:1878)");
                    }
                    SpringSpec<T> springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2.endReplaceGroup();
                    return springSpecSpring$default;
                }

                @Override // S7.o
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
                }
            };
        }
        if ((i6 & 4) != 0) {
            str = "ValueAnimation";
        }
        int i10 = (i >> 9) & 112;
        return createTransitionAnimation(transition, oVar2.invoke(transition.getCurrentState(), composer, Integer.valueOf(i10)), oVar2.invoke(transition.getTargetState(), composer, Integer.valueOf(i10)), (FiniteAnimationSpec) oVar.invoke(transition.getSegment(), composer, Integer.valueOf((i >> 3) & 112)), twoWayConverter, str, composer, (i & 14) | (57344 & (i << 9)) | ((i << 6) & 458752));
    }

    @ExperimentalTransitionApi
    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <S, T> Transition<T> createChildTransition(Transition<S> transition, String str, o oVar, Composer composer, int i, int i6) {
        boolean z10 = true;
        if ((i6 & 1) != 0) {
            str = "ChildTransition";
        }
        String str2 = str;
        int i10 = i & 14;
        if (((i10 ^ 6) <= 4 || !composer.changed(transition)) && (i & 6) != 4) {
            z10 = false;
        }
        Object objRememberedValue = composer.rememberedValue();
        if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = transition.getCurrentState();
            composer.updateRememberedValue(objRememberedValue);
        }
        if (transition.isSeeking()) {
            objRememberedValue = transition.getCurrentState();
        }
        int i11 = (i >> 3) & 112;
        return createChildTransitionInternal(transition, oVar.invoke(objRememberedValue, composer, Integer.valueOf(i11)), oVar.invoke(transition.getTargetState(), composer, Integer.valueOf(i11)), str2, composer, i10 | ((i << 6) & 7168));
    }

    @Composable
    public static final <S, T> Transition<T> createChildTransitionInternal(final Transition<S> transition, T t9, T t10, String str, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-198307638, i, -1, "androidx.compose.animation.core.createChildTransitionInternal (Transition.kt:1823)");
        }
        int i6 = (i & 14) ^ 6;
        boolean z10 = true;
        boolean z11 = (i6 > 4 && composer.changed(transition)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Transition(new MutableTransitionState(t9), transition, transition.getLabel() + " > " + str);
            composer.updateRememberedValue(objRememberedValue);
        }
        final Transition<T> transition2 = (Transition) objRememberedValue;
        if ((i6 <= 4 || !composer.changed(transition)) && (i & 6) != 4) {
            z10 = false;
        }
        boolean zChanged = composer.changed(transition2) | z10;
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new k() { // from class: androidx.compose.animation.core.TransitionKt$createChildTransitionInternal$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    transition.addTransition$animation_core_release(transition2);
                    final Transition<S> transition3 = transition;
                    final Transition<T> transition4 = transition2;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createChildTransitionInternal$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            transition3.removeTransition$animation_core_release(transition4);
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        EffectsKt.DisposableEffect(transition2, (k) objRememberedValue2, composer, 0);
        if (transition.isSeeking()) {
            transition2.seek(t9, t10, transition.getLastSeekedTimeNanos());
        } else {
            transition2.updateTarget$animation_core_release(t10);
            transition2.setSeeking$animation_core_release(false);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return transition2;
    }

    @Composable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final <S, T, V extends AnimationVector> Transition<S>.DeferredAnimation<T, V> createDeferredAnimation(final Transition<S> transition, TwoWayConverter<T, V> twoWayConverter, String str, Composer composer, int i, int i6) {
        if ((i6 & 2) != 0) {
            str = "DeferredAnimation";
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1714122528, i, -1, "androidx.compose.animation.core.createDeferredAnimation (Transition.kt:1777)");
        }
        int i10 = (i & 14) ^ 6;
        boolean z10 = true;
        boolean z11 = (i10 > 4 && composer.changed(transition)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = transition.new DeferredAnimation(twoWayConverter, str);
            composer.updateRememberedValue(objRememberedValue);
        }
        final Transition<S>.DeferredAnimation<T, V> deferredAnimation = (Transition.DeferredAnimation) objRememberedValue;
        if ((i10 <= 4 || !composer.changed(transition)) && (i & 6) != 4) {
            z10 = false;
        }
        boolean zChangedInstance = composer.changedInstance(deferredAnimation) | z10;
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new k() { // from class: androidx.compose.animation.core.TransitionKt$createDeferredAnimation$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    final Transition<S> transition2 = transition;
                    final Transition<S>.DeferredAnimation<T, V> deferredAnimation2 = deferredAnimation;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createDeferredAnimation$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            transition2.removeAnimation$animation_core_release(deferredAnimation2);
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        EffectsKt.DisposableEffect(deferredAnimation, (k) objRememberedValue2, composer, 0);
        if (transition.isSeeking()) {
            deferredAnimation.setupSeeking$animation_core_release();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return deferredAnimation;
    }

    @Composable
    public static final <S, T, V extends AnimationVector> State<T> createTransitionAnimation(final Transition<S> transition, T t9, T t10, FiniteAnimationSpec<T> finiteAnimationSpec, TwoWayConverter<T, V> twoWayConverter, String str, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-304821198, i, -1, "androidx.compose.animation.core.createTransitionAnimation (Transition.kt:1898)");
        }
        int i6 = (i & 14) ^ 6;
        boolean z10 = true;
        boolean z11 = (i6 > 4 && composer.changed(transition)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            Object transitionAnimationState = transition.new TransitionAnimationState(t9, AnimationStateKt.createZeroVectorFrom(twoWayConverter, t10), twoWayConverter, str);
            composer.updateRememberedValue(transitionAnimationState);
            objRememberedValue = transitionAnimationState;
        }
        final Transition.TransitionAnimationState transitionAnimationState2 = (Transition.TransitionAnimationState) objRememberedValue;
        if (transition.isSeeking()) {
            transitionAnimationState2.updateInitialAndTargetValue$animation_core_release(t9, t10, finiteAnimationSpec);
        } else {
            transitionAnimationState2.updateTargetValue$animation_core_release(t10, finiteAnimationSpec);
        }
        if ((i6 <= 4 || !composer.changed(transition)) && (i & 6) != 4) {
            z10 = false;
        }
        boolean zChanged = composer.changed(transitionAnimationState2) | z10;
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new k() { // from class: androidx.compose.animation.core.TransitionKt$createTransitionAnimation$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    transition.addAnimation$animation_core_release(transitionAnimationState2);
                    final Transition<S> transition2 = transition;
                    final Transition<S>.TransitionAnimationState<T, V> transitionAnimationState3 = transitionAnimationState2;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createTransitionAnimation$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            transition2.removeAnimation$animation_core_release(transitionAnimationState3);
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        EffectsKt.DisposableEffect(transitionAnimationState2, (k) objRememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return transitionAnimationState2;
    }

    public static final SnapshotStateObserver getSeekableStateObserver() {
        return (SnapshotStateObserver) SeekableStateObserver$delegate.getF4884a();
    }

    @Composable
    public static final <T> Transition<T> rememberTransition(TransitionState<T> transitionState, String str, Composer composer, int i, int i6) {
        if ((i6 & 2) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1643203617, i, -1, "androidx.compose.animation.core.rememberTransition (Transition.kt:818)");
        }
        int i10 = (i & 14) ^ 6;
        boolean z10 = true;
        boolean z11 = (i10 > 4 && composer.changed(transitionState)) || (i & 6) == 4;
        Object objRememberedValue = composer.rememberedValue();
        if (z11 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Transition((TransitionState) transitionState, str);
            composer.updateRememberedValue(objRememberedValue);
        }
        final Transition<T> transition = (Transition) objRememberedValue;
        if (transitionState instanceof SeekableTransitionState) {
            composer.startReplaceGroup(1030282692);
            T currentState = transitionState.getCurrentState();
            T targetState = transitionState.getTargetState();
            if ((i10 <= 4 || !composer.changed(transitionState)) && (i & 6) != 4) {
                z10 = false;
            }
            Object objRememberedValue2 = composer.rememberedValue();
            if (z10 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new TransitionKt$rememberTransition$1$1(transitionState, null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.LaunchedEffect(currentState, targetState, (n) objRememberedValue2, composer, 0);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1030744251);
            transition.animateTo$animation_core_release(transitionState.getTargetState(), composer, 0);
            composer.endReplaceGroup();
        }
        boolean zChanged = composer.changed(transition);
        Object objRememberedValue3 = composer.rememberedValue();
        if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new k() { // from class: androidx.compose.animation.core.TransitionKt$rememberTransition$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    final Transition<T> transition2 = transition;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$rememberTransition$2$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            transition2.onDisposed$animation_core_release();
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        EffectsKt.DisposableEffect(transition, (k) objRememberedValue3, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return transition;
    }

    @Composable
    public static final <T> Transition<T> updateTransition(T t9, String str, Composer composer, int i, int i6) {
        if ((i6 & 2) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2029166765, i, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:89)");
        }
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.INSTANCE;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = new Transition(t9, str);
            composer.updateRememberedValue(objRememberedValue);
        }
        final Transition<T> transition = (Transition) objRememberedValue;
        transition.animateTo$animation_core_release(t9, composer, (i & 8) | 48 | (i & 14));
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new k() { // from class: androidx.compose.animation.core.TransitionKt$updateTransition$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    final Transition<T> transition2 = transition;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$updateTransition$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            transition2.onDisposed$animation_core_release();
                        }
                    };
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        EffectsKt.DisposableEffect(transition, (k) objRememberedValue2, composer, 54);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return transition;
    }

    @c
    @Composable
    public static final <T> Transition<T> updateTransition(MutableTransitionState<T> mutableTransitionState, String str, Composer composer, int i, int i6) {
        if ((i6 & 2) != 0) {
            str = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(882913843, i, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:871)");
        }
        Transition<T> transitionRememberTransition = rememberTransition(mutableTransitionState, str, composer, i & 126, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return transitionRememberTransition;
    }
}
