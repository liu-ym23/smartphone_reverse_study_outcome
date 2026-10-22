package androidx.compose.foundation.gestures;

import C7.r;
import J7.c;
import S7.a;
import S7.k;
import S7.n;
import S7.o;
import S7.p;
import androidx.annotation.FloatRange;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\b\u0007*\u0001l\b\u0007\u0018\u0000 q*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001qBc\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\u0004\b\u000f\u0010\u0010Bs\b\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\u0004\b\u000f\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001d\u001a\u00020\u001c2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\b\b\u0002\u0010\u001b\u001a\u00028\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0086@¢\u0006\u0004\b \u0010!JJ\u0010(\u001a\u00020\u001c2\b\b\u0002\u0010#\u001a\u00020\"2.\u0010'\u001a*\b\u0001\u0012\u0004\u0012\u00020%\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0&\u0012\u0006\u0012\u0004\u0018\u00010\u00020$H\u0086@¢\u0006\u0004\b(\u0010)JX\u0010(\u001a\u00020\u001c2\u0006\u0010*\u001a\u00028\u00002\b\b\u0002\u0010#\u001a\u00020\"24\u0010'\u001a0\b\u0001\u0012\u0004\u0012\u00020%\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0011\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0&\u0012\u0006\u0012\u0004\u0018\u00010\u00020+H\u0086@¢\u0006\u0004\b(\u0010,J\u0017\u00100\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0000¢\u0006\u0004\b.\u0010/J\u0015\u00101\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005¢\u0006\u0004\b1\u0010/J'\u00104\u001a\u00028\u00002\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\r2\u0006\u0010*\u001a\u00028\u0000H\u0002¢\u0006\u0004\b6\u00107R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u00108\u001a\u0004\b9\u0010:R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010;\u001a\u0004\b<\u0010=R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0006¢\u0006\f\n\u0004\b\n\u0010>\u001a\u0004\b?\u0010@R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010A\u001a\u0004\bB\u0010CR&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000e\u00108\u001a\u0004\bD\u0010:R\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR+\u00103\u001a\u00028\u00002\u0006\u0010H\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR+\u0010R\u001a\u00028\u00002\u0006\u0010H\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bO\u0010J\u001a\u0004\bP\u0010L\"\u0004\bQ\u0010NR\u001b\u0010*\u001a\u00028\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010LR+\u00102\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010\u0015\"\u0004\bY\u0010ZR!\u0010\u0018\u001a\u00020\u00058GX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b[\u0010T\u0012\u0004\b]\u0010^\u001a\u0004\b\\\u0010\u0015R+\u0010b\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b_\u0010W\u001a\u0004\b`\u0010\u0015\"\u0004\ba\u0010ZR/\u0010f\u001a\u0004\u0018\u00018\u00002\b\u0010H\u001a\u0004\u0018\u00018\u00008B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bc\u0010J\u001a\u0004\bd\u0010L\"\u0004\be\u0010NR7\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\f\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u00118F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bg\u0010J\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u001a\u0010m\u001a\b\u0012\u0004\u0012\u00028\u00000l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0011\u0010o\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bo\u0010p¨\u0006r"}, d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableState;", ExifInterface.GPS_DIRECTION_TRUE, "", "initialValue", "Lkotlin/Function1;", "", "positionalThreshold", "Lkotlin/Function0;", "velocityThreshold", "Landroidx/compose/animation/core/AnimationSpec;", "snapAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "decayAnimationSpec", "", "confirmValueChange", AppAgent.CONSTRUCT, "(Ljava/lang/Object;LS7/k;LS7/a;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;LS7/k;)V", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "anchors", "(Ljava/lang/Object;Landroidx/compose/foundation/gestures/DraggableAnchors;LS7/k;LS7/a;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;LS7/k;)V", "requireOffset", "()F", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "progress", "(Ljava/lang/Object;Ljava/lang/Object;)F", "newAnchors", "newTarget", "LC7/r;", "updateAnchors", "(Landroidx/compose/foundation/gestures/DraggableAnchors;Ljava/lang/Object;)V", "velocity", "settle", "(FLH7/c;)Ljava/lang/Object;", "Landroidx/compose/foundation/MutatePriority;", "dragPriority", "Lkotlin/Function3;", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "LH7/c;", "block", "anchoredDrag", "(Landroidx/compose/foundation/MutatePriority;LS7/o;LH7/c;)Ljava/lang/Object;", "targetValue", "Lkotlin/Function4;", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;LS7/p;LH7/c;)Ljava/lang/Object;", "delta", "newOffsetForDelta$foundation_release", "(F)F", "newOffsetForDelta", "dispatchRawDelta", TypedValues.CycleType.S_WAVE_OFFSET, "currentValue", "computeTarget", "(FLjava/lang/Object;F)Ljava/lang/Object;", "trySnapTo", "(Ljava/lang/Object;)Z", "LS7/k;", "getPositionalThreshold$foundation_release", "()LS7/k;", "LS7/a;", "getVelocityThreshold$foundation_release", "()LS7/a;", "Landroidx/compose/animation/core/AnimationSpec;", "getSnapAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "Landroidx/compose/animation/core/DecayAnimationSpec;", "getDecayAnimationSpec", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "getConfirmValueChange$foundation_release", "Landroidx/compose/foundation/MutatorMutex;", "dragMutex", "Landroidx/compose/foundation/MutatorMutex;", "<set-?>", "currentValue$delegate", "Landroidx/compose/runtime/MutableState;", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "(Ljava/lang/Object;)V", "settledValue$delegate", "getSettledValue", "setSettledValue", "settledValue", "targetValue$delegate", "Landroidx/compose/runtime/State;", "getTargetValue", "offset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "getOffset", "setOffset", "(F)V", "progress$delegate", "getProgress", "getProgress$annotations", "()V", "lastVelocity$delegate", "getLastVelocity", "setLastVelocity", "lastVelocity", "dragTarget$delegate", "getDragTarget", "setDragTarget", "dragTarget", "anchors$delegate", "getAnchors", "()Landroidx/compose/foundation/gestures/DraggableAnchors;", "setAnchors", "(Landroidx/compose/foundation/gestures/DraggableAnchors;)V", "androidx/compose/foundation/gestures/AnchoredDraggableState$anchoredDragScope$1", "anchoredDragScope", "Landroidx/compose/foundation/gestures/AnchoredDraggableState$anchoredDragScope$1;", "isAnimationRunning", "()Z", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Stable
@ExperimentalFoundationApi
/* loaded from: classes.dex */
public final class AnchoredDraggableState<T> {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AnchoredDraggableState$anchoredDragScope$1 anchoredDragScope;

    /* renamed from: anchors$delegate, reason: from kotlin metadata */
    private final MutableState anchors;
    private final k confirmValueChange;

    /* renamed from: currentValue$delegate, reason: from kotlin metadata */
    private final MutableState currentValue;
    private final DecayAnimationSpec<Float> decayAnimationSpec;
    private final MutatorMutex dragMutex;

    /* renamed from: dragTarget$delegate, reason: from kotlin metadata */
    private final MutableState dragTarget;

    /* renamed from: lastVelocity$delegate, reason: from kotlin metadata */
    private final MutableFloatState lastVelocity;

    /* renamed from: offset$delegate, reason: from kotlin metadata */
    private final MutableFloatState offset;
    private final k positionalThreshold;

    /* renamed from: progress$delegate, reason: from kotlin metadata */
    private final State progress;

    /* renamed from: settledValue$delegate, reason: from kotlin metadata */
    private final MutableState settledValue;
    private final AnimationSpec<Float> snapAnimationSpec;

    /* renamed from: targetValue$delegate, reason: from kotlin metadata */
    private final State targetValue;
    private final a velocityThreshold;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u007f\u0010\u0012\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0011\u0012\u0004\u0012\u00028\u00010\u0010\"\b\b\u0001\u0010\u0004*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000e0\nH\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableState$Companion;", "", AppAgent.CONSTRUCT, "()V", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/animation/core/AnimationSpec;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "decayAnimationSpec", "Lkotlin/Function1;", "positionalThreshold", "Lkotlin/Function0;", "velocityThreshold", "", "confirmValueChange", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "Saver", "(Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;LS7/k;LS7/a;LS7/k;)Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public static /* synthetic */ Saver Saver$default(Companion companion, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, k kVar, a aVar, k kVar2, int i, Object obj) {
            if ((i & 16) != 0) {
                kVar2 = new k() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$Companion$Saver$1
                    @Override // S7.k
                    public final Boolean invoke(T t9) {
                        return Boolean.TRUE;
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        return invoke((AnchoredDraggableState$Companion$Saver$1) obj2);
                    }
                };
            }
            return companion.Saver(animationSpec, decayAnimationSpec, kVar, aVar, kVar2);
        }

        @ExperimentalFoundationApi
        public final <T> Saver<AnchoredDraggableState<T>, T> Saver(final AnimationSpec<Float> snapAnimationSpec, final DecayAnimationSpec<Float> decayAnimationSpec, final k positionalThreshold, final a velocityThreshold, final k confirmValueChange) {
            return SaverKt.Saver(new n() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$Companion$Saver$2
                /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
                @Override // S7.n
                public final T invoke(SaverScope saverScope, AnchoredDraggableState<T> anchoredDraggableState) {
                    return anchoredDraggableState.getCurrentValue();
                }
            }, new k() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$Companion$Saver$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((AnchoredDraggableState$Companion$Saver$3) obj);
                }

                @Override // S7.k
                public final AnchoredDraggableState<T> invoke(T t9) {
                    return new AnchoredDraggableState<>(t9, positionalThreshold, velocityThreshold, snapAnimationSpec, decayAnimationSpec, confirmValueChange);
                }
            });
        }

        private Companion() {
        }
    }

    @c(c = "androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2", f = "AnchoredDraggable.kt", l = {835}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LC7/r;", "<anonymous>", "()V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2, reason: invalid class name and case insensitive filesystem */
    public static final class C03912 extends SuspendLambda implements k {
        final /* synthetic */ o $block;
        int label;
        final /* synthetic */ AnchoredDraggableState<T> this$0;

        @c(c = "androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2$2", f = "AnchoredDraggable.kt", l = {836}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/DraggableAnchors;", "latestAnchors", "LC7/r;", "<anonymous>", "(Landroidx/compose/foundation/gestures/DraggableAnchors;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C00172 extends SuspendLambda implements n {
            final /* synthetic */ o $block;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00172(o oVar, AnchoredDraggableState<T> anchoredDraggableState, H7.c<? super C00172> cVar) {
                super(2, cVar);
                this.$block = oVar;
                this.this$0 = anchoredDraggableState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                C00172 c00172 = new C00172(this.$block, this.this$0, cVar);
                c00172.L$0 = obj;
                return c00172;
            }

            @Override // S7.n
            public final Object invoke(DraggableAnchors<T> draggableAnchors, H7.c<? super r> cVar) {
                return ((C00172) create(draggableAnchors, cVar)).invokeSuspend(r.f317a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    b.b(obj);
                    DraggableAnchors draggableAnchors = (DraggableAnchors) this.L$0;
                    o oVar = this.$block;
                    AnchoredDraggableState$anchoredDragScope$1 anchoredDraggableState$anchoredDragScope$1 = ((AnchoredDraggableState) this.this$0).anchoredDragScope;
                    this.label = 1;
                    if (oVar.invoke(anchoredDraggableState$anchoredDragScope$1, draggableAnchors, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b.b(obj);
                }
                return r.f317a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03912(AnchoredDraggableState<T> anchoredDraggableState, o oVar, H7.c<? super C03912> cVar) {
            super(1, cVar);
            this.this$0 = anchoredDraggableState;
            this.$block = oVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(H7.c<?> cVar) {
            return new C03912(this.this$0, this.$block, cVar);
        }

        @Override // S7.k
        public final Object invoke(H7.c<? super r> cVar) {
            return ((C03912) create(cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                final AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
                a aVar = new a() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState.anchoredDrag.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public final DraggableAnchors<T> invoke() {
                        return anchoredDraggableState.getAnchors();
                    }
                };
                C00172 c00172 = new C00172(this.$block, this.this$0, null);
                this.label = 1;
                if (AnchoredDraggableKt.restartable(aVar, c00172, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            T tClosestAnchor = this.this$0.getAnchors().closestAnchor(this.this$0.getOffset());
            if (tClosestAnchor != null) {
                if (Math.abs(this.this$0.getOffset() - this.this$0.getAnchors().positionOf(tClosestAnchor)) < 0.5f && ((Boolean) this.this$0.getConfirmValueChange().invoke(tClosestAnchor)).booleanValue()) {
                    this.this$0.setSettledValue(tClosestAnchor);
                    this.this$0.setCurrentValue(tClosestAnchor);
                }
            }
            return r.f317a;
        }
    }

    @c(c = "androidx.compose.foundation.gestures.AnchoredDraggableState", f = "AnchoredDraggable.kt", l = {880}, m = "anchoredDrag")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3, reason: invalid class name */
    public static final class AnonymousClass3 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AnchoredDraggableState<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AnchoredDraggableState<T> anchoredDraggableState, H7.c<? super AnonymousClass3> cVar) {
            super(cVar);
            this.this$0 = anchoredDraggableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.anchoredDrag(null, null, null, this);
        }
    }

    @c(c = "androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4", f = "AnchoredDraggable.kt", l = {882}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LC7/r;", "<anonymous>", "()V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements k {
        final /* synthetic */ p $block;
        final /* synthetic */ T $targetValue;
        int label;
        final /* synthetic */ AnchoredDraggableState<T> this$0;

        @c(c = "androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4$2", f = "AnchoredDraggable.kt", l = {885}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u0018\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Pair;", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "<name for destructuring parameter 0>", "LC7/r;", "<anonymous>", "(Lkotlin/Pair;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4$2, reason: invalid class name */
        public static final class AnonymousClass2 extends SuspendLambda implements n {
            final /* synthetic */ p $block;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(p pVar, AnchoredDraggableState<T> anchoredDraggableState, H7.c<? super AnonymousClass2> cVar) {
                super(2, cVar);
                this.$block = pVar;
                this.this$0 = anchoredDraggableState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$block, this.this$0, cVar);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    b.b(obj);
                    Pair pair = (Pair) this.L$0;
                    DraggableAnchors draggableAnchors = (DraggableAnchors) pair.f4886a;
                    Object obj2 = pair.b;
                    p pVar = this.$block;
                    AnchoredDraggableState$anchoredDragScope$1 anchoredDraggableState$anchoredDragScope$1 = ((AnchoredDraggableState) this.this$0).anchoredDragScope;
                    this.label = 1;
                    if (pVar.invoke(anchoredDraggableState$anchoredDragScope$1, draggableAnchors, obj2, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b.b(obj);
                }
                return r.f317a;
            }

            @Override // S7.n
            public final Object invoke(Pair<? extends DraggableAnchors<T>, ? extends T> pair, H7.c<? super r> cVar) {
                return ((AnonymousClass2) create(pair, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(AnchoredDraggableState<T> anchoredDraggableState, T t9, p pVar, H7.c<? super AnonymousClass4> cVar) {
            super(1, cVar);
            this.this$0 = anchoredDraggableState;
            this.$targetValue = t9;
            this.$block = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(H7.c<?> cVar) {
            return new AnonymousClass4(this.this$0, this.$targetValue, this.$block, cVar);
        }

        @Override // S7.k
        public final Object invoke(H7.c<? super r> cVar) {
            return ((AnonymousClass4) create(cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                this.this$0.setDragTarget(this.$targetValue);
                final AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
                a aVar = new a() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState.anchoredDrag.4.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public final Pair<DraggableAnchors<T>, T> invoke() {
                        return new Pair<>(anchoredDraggableState.getAnchors(), anchoredDraggableState.getTargetValue());
                    }
                };
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$block, this.this$0, null);
                this.label = 1;
                if (AnchoredDraggableKt.restartable(aVar, anonymousClass2, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            if (((Boolean) this.this$0.getConfirmValueChange().invoke(this.$targetValue)).booleanValue()) {
                ((AnchoredDraggableState) this.this$0).anchoredDragScope.dragTo(this.this$0.getAnchors().positionOf(this.$targetValue), this.this$0.getLastVelocity());
                this.this$0.setSettledValue(this.$targetValue);
                this.this$0.setCurrentValue(this.$targetValue);
            }
            return r.f317a;
        }
    }

    public AnchoredDraggableState(T t9, k kVar, a aVar, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, k kVar2) {
        this.positionalThreshold = kVar;
        this.velocityThreshold = aVar;
        this.snapAnimationSpec = animationSpec;
        this.decayAnimationSpec = decayAnimationSpec;
        this.confirmValueChange = kVar2;
        this.dragMutex = new MutatorMutex();
        this.currentValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t9, null, 2, null);
        this.settledValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t9, null, 2, null);
        this.targetValue = SnapshotStateKt.derivedStateOf(new a(this) { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState$targetValue$2
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [T, java.lang.Object] */
            @Override // S7.a
            public final T invoke() {
                ?? ClosestAnchor;
                ?? dragTarget = this.this$0.getDragTarget();
                if (dragTarget != 0) {
                    return dragTarget;
                }
                AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
                return (Float.isNaN(anchoredDraggableState.getOffset()) || (ClosestAnchor = anchoredDraggableState.getAnchors().closestAnchor(anchoredDraggableState.getOffset())) == 0) ? anchoredDraggableState.getCurrentValue() : ClosestAnchor;
            }
        });
        this.offset = PrimitiveSnapshotStateKt.mutableFloatStateOf(Float.NaN);
        this.progress = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new a(this) { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState.progress.2
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // S7.a
            public final Float invoke() {
                float fPositionOf = this.this$0.getAnchors().positionOf(this.this$0.getSettledValue());
                float fPositionOf2 = this.this$0.getAnchors().positionOf(this.this$0.getTargetValue()) - fPositionOf;
                float fAbs = Math.abs(fPositionOf2);
                float f = 1.0f;
                if (!Float.isNaN(fAbs) && fAbs > 1.0E-6f) {
                    float fRequireOffset = (this.this$0.requireOffset() - fPositionOf) / fPositionOf2;
                    if (fRequireOffset < 1.0E-6f) {
                        f = 0.0f;
                    } else if (fRequireOffset <= 0.999999f) {
                        f = fRequireOffset;
                    }
                }
                return Float.valueOf(f);
            }
        });
        this.lastVelocity = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.dragTarget = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.anchors = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AnchoredDraggableKt.emptyDraggableAnchors(), null, 2, null);
        this.anchoredDragScope = new AnchoredDraggableState$anchoredDragScope$1(this);
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState anchoredDraggableState, MutatePriority mutatePriority, o oVar, H7.c cVar, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(mutatePriority, oVar, cVar);
    }

    private final T computeTarget(float offset, T currentValue, float velocity) {
        DraggableAnchors<T> anchors = getAnchors();
        float fPositionOf = anchors.positionOf(currentValue);
        float fFloatValue = ((Number) this.velocityThreshold.invoke()).floatValue();
        if (fPositionOf != offset && !Float.isNaN(fPositionOf)) {
            if (Math.abs(velocity) >= Math.abs(fFloatValue)) {
                T tClosestAnchor = anchors.closestAnchor(offset, Math.signum(velocity) > 0.0f);
                kotlin.jvm.internal.k.c(tClosestAnchor);
                return tClosestAnchor;
            }
            T tClosestAnchor2 = anchors.closestAnchor(offset, offset - fPositionOf > 0.0f);
            kotlin.jvm.internal.k.c(tClosestAnchor2);
            if (Math.abs(fPositionOf - offset) > Math.abs(((Number) this.positionalThreshold.invoke(Float.valueOf(Math.abs(fPositionOf - anchors.positionOf(tClosestAnchor2))))).floatValue())) {
                return tClosestAnchor2;
            }
        }
        return currentValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T getDragTarget() {
        return this.dragTarget.getValue();
    }

    @C7.c
    public static /* synthetic */ void getProgress$annotations() {
    }

    private final void setAnchors(DraggableAnchors<T> draggableAnchors) {
        this.anchors.setValue(draggableAnchors);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentValue(T t9) {
        this.currentValue.setValue(t9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDragTarget(T t9) {
        this.dragTarget.setValue(t9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLastVelocity(float f) {
        this.lastVelocity.setFloatValue(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setOffset(float f) {
        this.offset.setFloatValue(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSettledValue(T t9) {
        this.settledValue.setValue(t9);
    }

    private final boolean trySnapTo(T targetValue) {
        MutatorMutex mutatorMutex = this.dragMutex;
        boolean zTryLock = mutatorMutex.tryLock();
        if (!zTryLock) {
            return zTryLock;
        }
        try {
            AnchoredDraggableState$anchoredDragScope$1 anchoredDraggableState$anchoredDragScope$1 = this.anchoredDragScope;
            float fPositionOf = getAnchors().positionOf(targetValue);
            if (!Float.isNaN(fPositionOf)) {
                AnchoredDragScope.dragTo$default(anchoredDraggableState$anchoredDragScope$1, fPositionOf, 0.0f, 2, null);
                setDragTarget(null);
            }
            setCurrentValue(targetValue);
            setSettledValue(targetValue);
            mutatorMutex.unlock();
            return zTryLock;
        } catch (Throwable th) {
            mutatorMutex.unlock();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateAnchors$default(AnchoredDraggableState anchoredDraggableState, DraggableAnchors draggableAnchors, Object obj, int i, Object obj2) {
        if ((i & 2) != 0 && (Float.isNaN(anchoredDraggableState.getOffset()) || (obj = draggableAnchors.closestAnchor(anchoredDraggableState.getOffset())) == null)) {
            obj = anchoredDraggableState.getTargetValue();
        }
        anchoredDraggableState.updateAnchors(draggableAnchors, obj);
    }

    public final Object anchoredDrag(MutatePriority mutatePriority, o oVar, H7.c<? super r> cVar) {
        Object objMutate = this.dragMutex.mutate(mutatePriority, new C03912(this, oVar, null), cVar);
        return objMutate == CoroutineSingletons.f4909a ? objMutate : r.f317a;
    }

    public final float dispatchRawDelta(float delta) {
        float fNewOffsetForDelta$foundation_release = newOffsetForDelta$foundation_release(delta);
        float offset = Float.isNaN(getOffset()) ? 0.0f : getOffset();
        setOffset(fNewOffsetForDelta$foundation_release);
        return fNewOffsetForDelta$foundation_release - offset;
    }

    public final DraggableAnchors<T> getAnchors() {
        return (DraggableAnchors) this.anchors.getValue();
    }

    /* renamed from: getConfirmValueChange$foundation_release, reason: from getter */
    public final k getConfirmValueChange() {
        return this.confirmValueChange;
    }

    public final T getCurrentValue() {
        return this.currentValue.getValue();
    }

    public final DecayAnimationSpec<Float> getDecayAnimationSpec() {
        return this.decayAnimationSpec;
    }

    public final float getLastVelocity() {
        return this.lastVelocity.getFloatValue();
    }

    public final float getOffset() {
        return this.offset.getFloatValue();
    }

    /* renamed from: getPositionalThreshold$foundation_release, reason: from getter */
    public final k getPositionalThreshold() {
        return this.positionalThreshold;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public final float getProgress() {
        return ((Number) this.progress.getValue()).floatValue();
    }

    public final T getSettledValue() {
        return this.settledValue.getValue();
    }

    public final AnimationSpec<Float> getSnapAnimationSpec() {
        return this.snapAnimationSpec;
    }

    public final T getTargetValue() {
        return (T) this.targetValue.getValue();
    }

    /* renamed from: getVelocityThreshold$foundation_release, reason: from getter */
    public final a getVelocityThreshold() {
        return this.velocityThreshold;
    }

    public final boolean isAnimationRunning() {
        return getDragTarget() != null;
    }

    public final float newOffsetForDelta$foundation_release(float delta) {
        return AbstractC1451a.t((Float.isNaN(getOffset()) ? 0.0f : getOffset()) + delta, getAnchors().minAnchor(), getAnchors().maxAnchor());
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public final float progress(T from, T to) {
        float fPositionOf = getAnchors().positionOf(from);
        float fPositionOf2 = getAnchors().positionOf(to);
        float fT = (AbstractC1451a.t(getOffset(), Math.min(fPositionOf, fPositionOf2), Math.max(fPositionOf, fPositionOf2)) - fPositionOf) / (fPositionOf2 - fPositionOf);
        if (Float.isNaN(fT)) {
            return 1.0f;
        }
        if (fT < 1.0E-6f) {
            return 0.0f;
        }
        if (fT > 0.999999f) {
            return 1.0f;
        }
        return Math.abs(fT);
    }

    public final float requireOffset() {
        if (Float.isNaN(getOffset())) {
            throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?");
        }
        return getOffset();
    }

    public final Object settle(float f, H7.c<? super Float> cVar) {
        T currentValue = getCurrentValue();
        T tComputeTarget = computeTarget(requireOffset(), currentValue, f);
        return ((Boolean) this.confirmValueChange.invoke(tComputeTarget)).booleanValue() ? AnchoredDraggableKt.animateToWithDecay(this, tComputeTarget, f, cVar) : AnchoredDraggableKt.animateToWithDecay(this, currentValue, f, cVar);
    }

    public final void updateAnchors(DraggableAnchors<T> newAnchors, T newTarget) {
        if (kotlin.jvm.internal.k.b(getAnchors(), newAnchors)) {
            return;
        }
        setAnchors(newAnchors);
        if (trySnapTo(newTarget)) {
            return;
        }
        setDragTarget(newTarget);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object anchoredDrag(T r6, androidx.compose.foundation.MutatePriority r7, S7.p r8, H7.c<? super C7.r> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.AnchoredDraggableState.AnonymousClass3
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3 r0 = (androidx.compose.foundation.gestures.AnchoredDraggableState.AnonymousClass3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3 r0 = new androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            androidx.compose.foundation.gestures.AnchoredDraggableState r5 = (androidx.compose.foundation.gestures.AnchoredDraggableState) r5
            kotlin.b.b(r9)     // Catch: java.lang.Throwable -> L2c
            goto L55
        L2c:
            r6 = move-exception
            goto L59
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.b.b(r9)
            androidx.compose.foundation.gestures.DraggableAnchors r9 = r5.getAnchors()
            boolean r9 = r9.hasAnchorFor(r6)
            if (r9 == 0) goto L5d
            androidx.compose.foundation.MutatorMutex r9 = r5.dragMutex     // Catch: java.lang.Throwable -> L2c
            androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4 r2 = new androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4     // Catch: java.lang.Throwable -> L2c
            r2.<init>(r5, r6, r8, r4)     // Catch: java.lang.Throwable -> L2c
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L2c
            r0.label = r3     // Catch: java.lang.Throwable -> L2c
            java.lang.Object r6 = r9.mutate(r7, r2, r0)     // Catch: java.lang.Throwable -> L2c
            if (r6 != r1) goto L55
            return r1
        L55:
            r5.setDragTarget(r4)
            goto L71
        L59:
            r5.setDragTarget(r4)
            throw r6
        L5d:
            S7.k r7 = r5.confirmValueChange
            java.lang.Object r7 = r7.invoke(r6)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L71
            r5.setSettledValue(r6)
            r5.setCurrentValue(r6)
        L71:
            C7.r r5 = C7.r.f317a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableState.anchoredDrag(java.lang.Object, androidx.compose.foundation.MutatePriority, S7.p, H7.c):java.lang.Object");
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState anchoredDraggableState, Object obj, MutatePriority mutatePriority, p pVar, H7.c cVar, int i, Object obj2) {
        if ((i & 2) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(obj, mutatePriority, pVar, cVar);
    }

    public /* synthetic */ AnchoredDraggableState(Object obj, k kVar, a aVar, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, k kVar2, int i, e eVar) {
        this(obj, kVar, aVar, animationSpec, decayAnimationSpec, (i & 32) != 0 ? new k() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState.1
            @Override // S7.k
            public final Boolean invoke(T t9) {
                return Boolean.TRUE;
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                return invoke((AnonymousClass1) obj2);
            }
        } : kVar2);
    }

    public /* synthetic */ AnchoredDraggableState(Object obj, DraggableAnchors draggableAnchors, k kVar, a aVar, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, k kVar2, int i, e eVar) {
        this(obj, draggableAnchors, kVar, aVar, animationSpec, decayAnimationSpec, (i & 64) != 0 ? new k() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableState.2
            @Override // S7.k
            public final Boolean invoke(T t9) {
                return Boolean.TRUE;
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                return invoke((AnonymousClass2) obj2);
            }
        } : kVar2);
    }

    @ExperimentalFoundationApi
    public AnchoredDraggableState(T t9, DraggableAnchors<T> draggableAnchors, k kVar, a aVar, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec, k kVar2) {
        this(t9, kVar, aVar, animationSpec, decayAnimationSpec, kVar2);
        setAnchors(draggableAnchors);
        trySnapTo(t9);
    }
}
