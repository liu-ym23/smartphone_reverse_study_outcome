package androidx.compose.material3.internal;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import S7.o;
import S7.p;
import androidx.annotation.FloatRange;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DraggableState;
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

@Stable
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b,\b\u0001\u0018\u0000 l*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001lBU\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0004\b\r\u0010\u000eBe\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0004\b\r\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0017\u001a\u00020\u00162\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\b\b\u0002\u0010\u0015\u001a\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0005H\u0086@¢\u0006\u0004\b\u001a\u0010\u001bJJ\u0010\"\u001a\u00020\u00162\b\b\u0002\u0010\u001d\u001a\u00020\u001c2.\u0010!\u001a*\b\u0001\u0012\u0004\u0012\u00020\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160 \u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001eH\u0086@¢\u0006\u0004\b\"\u0010#JX\u0010\"\u001a\u00020\u00162\u0006\u0010$\u001a\u00028\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u001c24\u0010!\u001a0\b\u0001\u0012\u0004\u0012\u00020\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160 \u0012\u0006\u0012\u0004\u0018\u00010\u00020%H\u0086@¢\u0006\u0004\b\"\u0010&J\u0017\u0010*\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005H\u0000¢\u0006\u0004\b(\u0010)J\u0015\u0010+\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005¢\u0006\u0004\b+\u0010)J'\u0010.\u001a\u00028\u00002\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u0005H\u0002¢\u0006\u0004\b.\u0010/J\u001f\u00100\u001a\u00028\u00002\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00028\u0000H\u0002¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u000b2\u0006\u0010$\u001a\u00028\u0000H\u0002¢\u0006\u0004\b2\u00103R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u00104\u001a\u0004\b5\u00106R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u00107\u001a\u0004\b8\u00109R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0006¢\u0006\f\n\u0004\b\n\u0010:\u001a\u0004\b;\u0010<R&\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u00104\u001a\u0004\b=\u00106R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001a\u0010B\u001a\u00020A8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER+\u0010-\u001a\u00028\u00002\u0006\u0010F\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001b\u0010$\u001a\u00028\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010JR\u001b\u0010R\u001a\u00028\u00008@X\u0080\u0084\u0002¢\u0006\f\n\u0004\bP\u0010N\u001a\u0004\bQ\u0010JR+\u0010,\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010\u0013\"\u0004\bV\u0010WR\u001b\u0010Z\u001a\u00020\u00058GX\u0086\u0084\u0002¢\u0006\f\n\u0004\bX\u0010N\u001a\u0004\bY\u0010\u0013R+\u0010^\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u00058F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b[\u0010T\u001a\u0004\b\\\u0010\u0013\"\u0004\b]\u0010WR/\u0010b\u001a\u0004\u0018\u00018\u00002\b\u0010F\u001a\u0004\u0018\u00018\u00008B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b_\u0010H\u001a\u0004\b`\u0010J\"\u0004\ba\u0010LR7\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\f\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bc\u0010H\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0014\u0010h\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0011\u0010j\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\bj\u0010k¨\u0006m"}, d2 = {"Landroidx/compose/material3/internal/AnchoredDraggableState;", ExifInterface.GPS_DIRECTION_TRUE, "", "initialValue", "Lkotlin/Function1;", "", "positionalThreshold", "Lkotlin/Function0;", "velocityThreshold", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpec", "", "confirmValueChange", AppAgent.CONSTRUCT, "(Ljava/lang/Object;LS7/k;LS7/a;Landroidx/compose/animation/core/AnimationSpec;LS7/k;)V", "Landroidx/compose/material3/internal/DraggableAnchors;", "anchors", "(Ljava/lang/Object;Landroidx/compose/material3/internal/DraggableAnchors;LS7/k;LS7/a;Landroidx/compose/animation/core/AnimationSpec;LS7/k;)V", "requireOffset", "()F", "newAnchors", "newTarget", "LC7/r;", "updateAnchors", "(Landroidx/compose/material3/internal/DraggableAnchors;Ljava/lang/Object;)V", "velocity", "settle", "(FLH7/c;)Ljava/lang/Object;", "Landroidx/compose/foundation/MutatePriority;", "dragPriority", "Lkotlin/Function3;", "Landroidx/compose/material3/internal/AnchoredDragScope;", "LH7/c;", "block", "anchoredDrag", "(Landroidx/compose/foundation/MutatePriority;LS7/o;LH7/c;)Ljava/lang/Object;", "targetValue", "Lkotlin/Function4;", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;LS7/p;LH7/c;)Ljava/lang/Object;", "delta", "newOffsetForDelta$material3_release", "(F)F", "newOffsetForDelta", "dispatchRawDelta", TypedValues.CycleType.S_WAVE_OFFSET, "currentValue", "computeTarget", "(FLjava/lang/Object;F)Ljava/lang/Object;", "computeTargetWithoutThresholds", "(FLjava/lang/Object;)Ljava/lang/Object;", "trySnapTo", "(Ljava/lang/Object;)Z", "LS7/k;", "getPositionalThreshold$material3_release", "()LS7/k;", "LS7/a;", "getVelocityThreshold$material3_release", "()LS7/a;", "Landroidx/compose/animation/core/AnimationSpec;", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "getConfirmValueChange$material3_release", "Landroidx/compose/material3/internal/InternalMutatorMutex;", "dragMutex", "Landroidx/compose/material3/internal/InternalMutatorMutex;", "Landroidx/compose/foundation/gestures/DraggableState;", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getDraggableState$material3_release", "()Landroidx/compose/foundation/gestures/DraggableState;", "<set-?>", "currentValue$delegate", "Landroidx/compose/runtime/MutableState;", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "(Ljava/lang/Object;)V", "targetValue$delegate", "Landroidx/compose/runtime/State;", "getTargetValue", "closestValue$delegate", "getClosestValue$material3_release", "closestValue", "offset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "getOffset", "setOffset", "(F)V", "progress$delegate", "getProgress", "progress", "lastVelocity$delegate", "getLastVelocity", "setLastVelocity", "lastVelocity", "dragTarget$delegate", "getDragTarget", "setDragTarget", "dragTarget", "anchors$delegate", "getAnchors", "()Landroidx/compose/material3/internal/DraggableAnchors;", "setAnchors", "(Landroidx/compose/material3/internal/DraggableAnchors;)V", "anchoredDragScope", "Landroidx/compose/material3/internal/AnchoredDragScope;", "isAnimationRunning", "()Z", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnchoredDraggableState<T> {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AnchoredDragScope anchoredDragScope;

    /* renamed from: anchors$delegate, reason: from kotlin metadata */
    private final MutableState anchors;
    private final AnimationSpec<Float> animationSpec;

    /* renamed from: closestValue$delegate, reason: from kotlin metadata */
    private final State closestValue;
    private final k confirmValueChange;

    /* renamed from: currentValue$delegate, reason: from kotlin metadata */
    private final MutableState currentValue;
    private final InternalMutatorMutex dragMutex;

    /* renamed from: dragTarget$delegate, reason: from kotlin metadata */
    private final MutableState dragTarget;
    private final DraggableState draggableState;

    /* renamed from: lastVelocity$delegate, reason: from kotlin metadata */
    private final MutableFloatState lastVelocity;

    /* renamed from: offset$delegate, reason: from kotlin metadata */
    private final MutableFloatState offset;
    private final k positionalThreshold;

    /* renamed from: progress$delegate, reason: from kotlin metadata */
    private final State progress;

    /* renamed from: targetValue$delegate, reason: from kotlin metadata */
    private final State targetValue;
    private final S7.a velocityThreshold;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jm\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000f\u0012\u0004\u0012\u00028\u00010\u000e\"\b\b\u0001\u0010\u0004*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/internal/AnchoredDraggableState$Companion;", "", AppAgent.CONSTRUCT, "()V", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/animation/core/AnimationSpec;", "", "animationSpec", "Lkotlin/Function1;", "", "confirmValueChange", "positionalThreshold", "Lkotlin/Function0;", "velocityThreshold", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "Saver", "(Landroidx/compose/animation/core/AnimationSpec;LS7/k;LS7/k;LS7/a;)Landroidx/compose/runtime/saveable/Saver;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final <T> Saver<AnchoredDraggableState<T>, T> Saver(final AnimationSpec<Float> animationSpec, final k confirmValueChange, final k positionalThreshold, final S7.a velocityThreshold) {
            return SaverKt.Saver(new n() { // from class: androidx.compose.material3.internal.AnchoredDraggableState$Companion$Saver$1
                /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
                @Override // S7.n
                public final T invoke(SaverScope saverScope, AnchoredDraggableState<T> anchoredDraggableState) {
                    return anchoredDraggableState.getCurrentValue();
                }
            }, new k() { // from class: androidx.compose.material3.internal.AnchoredDraggableState$Companion$Saver$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((AnchoredDraggableState$Companion$Saver$2) obj);
                }

                @Override // S7.k
                public final AnchoredDraggableState<T> invoke(T t9) {
                    return new AnchoredDraggableState<>(t9, positionalThreshold, velocityThreshold, animationSpec, confirmValueChange);
                }
            });
        }

        private Companion() {
        }
    }

    @c(c = "androidx.compose.material3.internal.AnchoredDraggableState", f = "AnchoredDraggable.kt", l = {520}, m = "anchoredDrag")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.material3.internal.AnchoredDraggableState$anchoredDrag$1, reason: invalid class name and case insensitive filesystem */
    public static final class C06711 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AnchoredDraggableState<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C06711(AnchoredDraggableState<T> anchoredDraggableState, H7.c<? super C06711> cVar) {
            super(cVar);
            this.this$0 = anchoredDraggableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.anchoredDrag(null, null, this);
        }
    }

    @c(c = "androidx.compose.material3.internal.AnchoredDraggableState$anchoredDrag$2", f = "AnchoredDraggable.kt", l = {521}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LC7/r;", "<anonymous>", "()V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.material3.internal.AnchoredDraggableState$anchoredDrag$2, reason: invalid class name and case insensitive filesystem */
    public static final class C06722 extends SuspendLambda implements k {
        final /* synthetic */ o $block;
        int label;
        final /* synthetic */ AnchoredDraggableState<T> this$0;

        @c(c = "androidx.compose.material3.internal.AnchoredDraggableState$anchoredDrag$2$2", f = "AnchoredDraggable.kt", l = {522}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/material3/internal/DraggableAnchors;", "latestAnchors", "LC7/r;", "<anonymous>", "(Landroidx/compose/material3/internal/DraggableAnchors;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.material3.internal.AnchoredDraggableState$anchoredDrag$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C01042 extends SuspendLambda implements n {
            final /* synthetic */ o $block;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01042(o oVar, AnchoredDraggableState<T> anchoredDraggableState, H7.c<? super C01042> cVar) {
                super(2, cVar);
                this.$block = oVar;
                this.this$0 = anchoredDraggableState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                C01042 c01042 = new C01042(this.$block, this.this$0, cVar);
                c01042.L$0 = obj;
                return c01042;
            }

            @Override // S7.n
            public final Object invoke(DraggableAnchors<T> draggableAnchors, H7.c<? super r> cVar) {
                return ((C01042) create(draggableAnchors, cVar)).invokeSuspend(r.f317a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    b.b(obj);
                    DraggableAnchors draggableAnchors = (DraggableAnchors) this.L$0;
                    o oVar = this.$block;
                    AnchoredDragScope anchoredDragScope = ((AnchoredDraggableState) this.this$0).anchoredDragScope;
                    this.label = 1;
                    if (oVar.invoke(anchoredDragScope, draggableAnchors, this) == coroutineSingletons) {
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
        public C06722(AnchoredDraggableState<T> anchoredDraggableState, o oVar, H7.c<? super C06722> cVar) {
            super(1, cVar);
            this.this$0 = anchoredDraggableState;
            this.$block = oVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(H7.c<?> cVar) {
            return new C06722(this.this$0, this.$block, cVar);
        }

        @Override // S7.k
        public final Object invoke(H7.c<? super r> cVar) {
            return ((C06722) create(cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                final AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
                S7.a aVar = new S7.a() { // from class: androidx.compose.material3.internal.AnchoredDraggableState.anchoredDrag.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public final DraggableAnchors<T> invoke() {
                        return anchoredDraggableState.getAnchors();
                    }
                };
                C01042 c01042 = new C01042(this.$block, this.this$0, null);
                this.label = 1;
                if (AnchoredDraggableKt.restartable(aVar, c01042, this) == coroutineSingletons) {
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

    @c(c = "androidx.compose.material3.internal.AnchoredDraggableState", f = "AnchoredDraggable.kt", l = {567}, m = "anchoredDrag")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.material3.internal.AnchoredDraggableState$anchoredDrag$3, reason: invalid class name */
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

    @c(c = "androidx.compose.material3.internal.AnchoredDraggableState$anchoredDrag$4", f = "AnchoredDraggable.kt", l = {569}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "LC7/r;", "<anonymous>", "()V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.material3.internal.AnchoredDraggableState$anchoredDrag$4, reason: invalid class name */
    public static final class AnonymousClass4 extends SuspendLambda implements k {
        final /* synthetic */ p $block;
        final /* synthetic */ T $targetValue;
        int label;
        final /* synthetic */ AnchoredDraggableState<T> this$0;

        @c(c = "androidx.compose.material3.internal.AnchoredDraggableState$anchoredDrag$4$2", f = "AnchoredDraggable.kt", l = {571}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u0018\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Pair;", "Landroidx/compose/material3/internal/DraggableAnchors;", "<name for destructuring parameter 0>", "LC7/r;", "<anonymous>", "(Lkotlin/Pair;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.material3.internal.AnchoredDraggableState$anchoredDrag$4$2, reason: invalid class name */
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
                    AnchoredDragScope anchoredDragScope = ((AnchoredDraggableState) this.this$0).anchoredDragScope;
                    this.label = 1;
                    if (pVar.invoke(anchoredDragScope, draggableAnchors, obj2, this) == coroutineSingletons) {
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
                S7.a aVar = new S7.a() { // from class: androidx.compose.material3.internal.AnchoredDraggableState.anchoredDrag.4.1
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
            return r.f317a;
        }
    }

    public AnchoredDraggableState(T t9, k kVar, S7.a aVar, AnimationSpec<Float> animationSpec, k kVar2) {
        this.positionalThreshold = kVar;
        this.velocityThreshold = aVar;
        this.animationSpec = animationSpec;
        this.confirmValueChange = kVar2;
        this.dragMutex = new InternalMutatorMutex();
        this.draggableState = new AnchoredDraggableState$draggableState$1(this);
        this.currentValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t9, null, 2, null);
        this.targetValue = SnapshotStateKt.derivedStateOf(new S7.a(this) { // from class: androidx.compose.material3.internal.AnchoredDraggableState$targetValue$2
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r3v3, types: [T, java.lang.Object] */
            @Override // S7.a
            public final T invoke() {
                ?? dragTarget = this.this$0.getDragTarget();
                if (dragTarget != 0) {
                    return dragTarget;
                }
                AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
                float offset = anchoredDraggableState.getOffset();
                return !Float.isNaN(offset) ? anchoredDraggableState.computeTarget(offset, anchoredDraggableState.getCurrentValue(), 0.0f) : anchoredDraggableState.getCurrentValue();
            }
        });
        this.closestValue = SnapshotStateKt.derivedStateOf(new S7.a(this) { // from class: androidx.compose.material3.internal.AnchoredDraggableState$closestValue$2
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Object] */
            /* JADX WARN: Type inference failed for: r2v3, types: [T, java.lang.Object] */
            @Override // S7.a
            public final T invoke() {
                ?? dragTarget = this.this$0.getDragTarget();
                if (dragTarget != 0) {
                    return dragTarget;
                }
                AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
                float offset = anchoredDraggableState.getOffset();
                return !Float.isNaN(offset) ? anchoredDraggableState.computeTargetWithoutThresholds(offset, anchoredDraggableState.getCurrentValue()) : anchoredDraggableState.getCurrentValue();
            }
        });
        this.offset = PrimitiveSnapshotStateKt.mutableFloatStateOf(Float.NaN);
        this.progress = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new S7.a(this) { // from class: androidx.compose.material3.internal.AnchoredDraggableState$progress$2
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // S7.a
            public final Float invoke() {
                float fPositionOf = this.this$0.getAnchors().positionOf(this.this$0.getCurrentValue());
                float fPositionOf2 = this.this$0.getAnchors().positionOf(this.this$0.getClosestValue$material3_release()) - fPositionOf;
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
        this.anchoredDragScope = new AnchoredDragScope(this) { // from class: androidx.compose.material3.internal.AnchoredDraggableState$anchoredDragScope$1
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            {
                this.this$0 = this;
            }

            @Override // androidx.compose.material3.internal.AnchoredDragScope
            public void dragTo(float newOffset, float lastKnownVelocity) {
                this.this$0.setOffset(newOffset);
                this.this$0.setLastVelocity(lastKnownVelocity);
            }
        };
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState anchoredDraggableState, MutatePriority mutatePriority, o oVar, H7.c cVar, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(mutatePriority, oVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T computeTarget(float offset, T currentValue, float velocity) {
        DraggableAnchors<T> anchors = getAnchors();
        float fPositionOf = anchors.positionOf(currentValue);
        float fFloatValue = ((Number) this.velocityThreshold.invoke()).floatValue();
        if (fPositionOf != offset && !Float.isNaN(fPositionOf)) {
            if (fPositionOf < offset) {
                if (velocity >= fFloatValue) {
                    T tClosestAnchor = anchors.closestAnchor(offset, true);
                    kotlin.jvm.internal.k.c(tClosestAnchor);
                    return tClosestAnchor;
                }
                T tClosestAnchor2 = anchors.closestAnchor(offset, true);
                kotlin.jvm.internal.k.c(tClosestAnchor2);
                if (offset >= Math.abs(Math.abs(((Number) this.positionalThreshold.invoke(Float.valueOf(Math.abs(anchors.positionOf(tClosestAnchor2) - fPositionOf)))).floatValue()) + fPositionOf)) {
                    return tClosestAnchor2;
                }
            } else {
                if (velocity <= (-fFloatValue)) {
                    T tClosestAnchor3 = anchors.closestAnchor(offset, false);
                    kotlin.jvm.internal.k.c(tClosestAnchor3);
                    return tClosestAnchor3;
                }
                T tClosestAnchor4 = anchors.closestAnchor(offset, false);
                kotlin.jvm.internal.k.c(tClosestAnchor4);
                float fAbs = Math.abs(fPositionOf - Math.abs(((Number) this.positionalThreshold.invoke(Float.valueOf(Math.abs(fPositionOf - anchors.positionOf(tClosestAnchor4))))).floatValue()));
                if (offset >= 0.0f ? offset <= fAbs : Math.abs(offset) >= fAbs) {
                    return tClosestAnchor4;
                }
            }
        }
        return currentValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T computeTargetWithoutThresholds(float offset, T currentValue) {
        DraggableAnchors<T> anchors = getAnchors();
        float fPositionOf = anchors.positionOf(currentValue);
        if (fPositionOf != offset && !Float.isNaN(fPositionOf)) {
            if (fPositionOf < offset) {
                T tClosestAnchor = anchors.closestAnchor(offset, true);
                if (tClosestAnchor != null) {
                    return tClosestAnchor;
                }
            } else {
                T tClosestAnchor2 = anchors.closestAnchor(offset, false);
                if (tClosestAnchor2 != null) {
                    return tClosestAnchor2;
                }
            }
        }
        return currentValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T getDragTarget() {
        return this.dragTarget.getValue();
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

    private final boolean trySnapTo(final T targetValue) {
        return this.dragMutex.tryMutate(new S7.a(this) { // from class: androidx.compose.material3.internal.AnchoredDraggableState.trySnapTo.1
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // S7.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m2668invoke();
                return r.f317a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2668invoke() {
                AnchoredDragScope anchoredDragScope = ((AnchoredDraggableState) this.this$0).anchoredDragScope;
                AnchoredDraggableState<T> anchoredDraggableState = this.this$0;
                T t9 = targetValue;
                float fPositionOf = anchoredDraggableState.getAnchors().positionOf(t9);
                if (!Float.isNaN(fPositionOf)) {
                    AnchoredDragScope.dragTo$default(anchoredDragScope, fPositionOf, 0.0f, 2, null);
                    anchoredDraggableState.setDragTarget(null);
                }
                anchoredDraggableState.setCurrentValue(t9);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateAnchors$default(AnchoredDraggableState anchoredDraggableState, DraggableAnchors draggableAnchors, Object obj, int i, Object obj2) {
        if ((i & 2) != 0 && (Float.isNaN(anchoredDraggableState.getOffset()) || (obj = draggableAnchors.closestAnchor(anchoredDraggableState.getOffset())) == null)) {
            obj = anchoredDraggableState.getTargetValue();
        }
        anchoredDraggableState.updateAnchors(draggableAnchors, obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object anchoredDrag(androidx.compose.foundation.MutatePriority r7, S7.o r8, H7.c<? super C7.r> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.compose.material3.internal.AnchoredDraggableState.C06711
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.material3.internal.AnchoredDraggableState$anchoredDrag$1 r0 = (androidx.compose.material3.internal.AnchoredDraggableState.C06711) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.material3.internal.AnchoredDraggableState$anchoredDrag$1 r0 = new androidx.compose.material3.internal.AnchoredDraggableState$anchoredDrag$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1056964608(0x3f000000, float:0.5)
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            java.lang.Object r6 = r0.L$0
            androidx.compose.material3.internal.AnchoredDraggableState r6 = (androidx.compose.material3.internal.AnchoredDraggableState) r6
            kotlin.b.b(r9)     // Catch: java.lang.Throwable -> L2d
            goto L4d
        L2d:
            r7 = move-exception
            goto L84
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            kotlin.b.b(r9)
            androidx.compose.material3.internal.InternalMutatorMutex r9 = r6.dragMutex     // Catch: java.lang.Throwable -> L2d
            androidx.compose.material3.internal.AnchoredDraggableState$anchoredDrag$2 r2 = new androidx.compose.material3.internal.AnchoredDraggableState$anchoredDrag$2     // Catch: java.lang.Throwable -> L2d
            r5 = 0
            r2.<init>(r6, r8, r5)     // Catch: java.lang.Throwable -> L2d
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L2d
            r0.label = r4     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r7 = r9.mutate(r7, r2, r0)     // Catch: java.lang.Throwable -> L2d
            if (r7 != r1) goto L4d
            return r1
        L4d:
            androidx.compose.material3.internal.DraggableAnchors r7 = r6.getAnchors()
            float r8 = r6.getOffset()
            java.lang.Object r7 = r7.closestAnchor(r8)
            if (r7 == 0) goto L81
            float r8 = r6.getOffset()
            androidx.compose.material3.internal.DraggableAnchors r9 = r6.getAnchors()
            float r9 = r9.positionOf(r7)
            float r8 = r8 - r9
            float r8 = java.lang.Math.abs(r8)
            int r8 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r8 > 0) goto L81
            S7.k r8 = r6.confirmValueChange
            java.lang.Object r8 = r8.invoke(r7)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L81
            r6.setCurrentValue(r7)
        L81:
            C7.r r6 = C7.r.f317a
            return r6
        L84:
            androidx.compose.material3.internal.DraggableAnchors r8 = r6.getAnchors()
            float r9 = r6.getOffset()
            java.lang.Object r8 = r8.closestAnchor(r9)
            if (r8 == 0) goto Lb8
            float r9 = r6.getOffset()
            androidx.compose.material3.internal.DraggableAnchors r0 = r6.getAnchors()
            float r0 = r0.positionOf(r8)
            float r9 = r9 - r0
            float r9 = java.lang.Math.abs(r9)
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 > 0) goto Lb8
            S7.k r9 = r6.confirmValueChange
            java.lang.Object r9 = r9.invoke(r8)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto Lb8
            r6.setCurrentValue(r8)
        Lb8:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.AnchoredDraggableState.anchoredDrag(androidx.compose.foundation.MutatePriority, S7.o, H7.c):java.lang.Object");
    }

    public final float dispatchRawDelta(float delta) {
        float fNewOffsetForDelta$material3_release = newOffsetForDelta$material3_release(delta);
        float offset = Float.isNaN(getOffset()) ? 0.0f : getOffset();
        setOffset(fNewOffsetForDelta$material3_release);
        return fNewOffsetForDelta$material3_release - offset;
    }

    public final DraggableAnchors<T> getAnchors() {
        return (DraggableAnchors) this.anchors.getValue();
    }

    public final AnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    public final T getClosestValue$material3_release() {
        return (T) this.closestValue.getValue();
    }

    /* renamed from: getConfirmValueChange$material3_release, reason: from getter */
    public final k getConfirmValueChange() {
        return this.confirmValueChange;
    }

    public final T getCurrentValue() {
        return this.currentValue.getValue();
    }

    /* renamed from: getDraggableState$material3_release, reason: from getter */
    public final DraggableState getDraggableState() {
        return this.draggableState;
    }

    public final float getLastVelocity() {
        return this.lastVelocity.getFloatValue();
    }

    public final float getOffset() {
        return this.offset.getFloatValue();
    }

    /* renamed from: getPositionalThreshold$material3_release, reason: from getter */
    public final k getPositionalThreshold() {
        return this.positionalThreshold;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public final float getProgress() {
        return ((Number) this.progress.getValue()).floatValue();
    }

    public final T getTargetValue() {
        return (T) this.targetValue.getValue();
    }

    /* renamed from: getVelocityThreshold$material3_release, reason: from getter */
    public final S7.a getVelocityThreshold() {
        return this.velocityThreshold;
    }

    public final boolean isAnimationRunning() {
        return getDragTarget() != null;
    }

    public final float newOffsetForDelta$material3_release(float delta) {
        return AbstractC1451a.t((Float.isNaN(getOffset()) ? 0.0f : getOffset()) + delta, getAnchors().minAnchor(), getAnchors().maxAnchor());
    }

    public final float requireOffset() {
        if (Float.isNaN(getOffset())) {
            throw new IllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?");
        }
        return getOffset();
    }

    public final Object settle(float f, H7.c<? super r> cVar) {
        T currentValue = getCurrentValue();
        T tComputeTarget = computeTarget(requireOffset(), currentValue, f);
        boolean zBooleanValue = ((Boolean) this.confirmValueChange.invoke(tComputeTarget)).booleanValue();
        r rVar = r.f317a;
        if (zBooleanValue) {
            Object objAnimateTo = AnchoredDraggableKt.animateTo(this, tComputeTarget, f, cVar);
            return objAnimateTo == CoroutineSingletons.f4909a ? objAnimateTo : rVar;
        }
        Object objAnimateTo2 = AnchoredDraggableKt.animateTo(this, currentValue, f, cVar);
        return objAnimateTo2 == CoroutineSingletons.f4909a ? objAnimateTo2 : rVar;
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

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState anchoredDraggableState, Object obj, MutatePriority mutatePriority, p pVar, H7.c cVar, int i, Object obj2) {
        if ((i & 2) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return anchoredDraggableState.anchoredDrag(obj, mutatePriority, pVar, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object anchoredDrag(T r7, androidx.compose.foundation.MutatePriority r8, S7.p r9, H7.c<? super C7.r> r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof androidx.compose.material3.internal.AnchoredDraggableState.AnonymousClass3
            if (r0 == 0) goto L13
            r0 = r10
            androidx.compose.material3.internal.AnchoredDraggableState$anchoredDrag$3 r0 = (androidx.compose.material3.internal.AnchoredDraggableState.AnonymousClass3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.material3.internal.AnchoredDraggableState$anchoredDrag$3 r0 = new androidx.compose.material3.internal.AnchoredDraggableState$anchoredDrag$3
            r0.<init>(r6, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1056964608(0x3f000000, float:0.5)
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            java.lang.Object r6 = r0.L$0
            androidx.compose.material3.internal.AnchoredDraggableState r6 = (androidx.compose.material3.internal.AnchoredDraggableState) r6
            kotlin.b.b(r10)     // Catch: java.lang.Throwable -> L2e
            goto L57
        L2e:
            r7 = move-exception
            goto L8f
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            kotlin.b.b(r10)
            androidx.compose.material3.internal.DraggableAnchors r10 = r6.getAnchors()
            boolean r10 = r10.hasAnchorFor(r7)
            if (r10 == 0) goto Lc7
            androidx.compose.material3.internal.InternalMutatorMutex r10 = r6.dragMutex     // Catch: java.lang.Throwable -> L2e
            androidx.compose.material3.internal.AnchoredDraggableState$anchoredDrag$4 r2 = new androidx.compose.material3.internal.AnchoredDraggableState$anchoredDrag$4     // Catch: java.lang.Throwable -> L2e
            r2.<init>(r6, r7, r9, r5)     // Catch: java.lang.Throwable -> L2e
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L2e
            r0.label = r4     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r7 = r10.mutate(r8, r2, r0)     // Catch: java.lang.Throwable -> L2e
            if (r7 != r1) goto L57
            return r1
        L57:
            r6.setDragTarget(r5)
            androidx.compose.material3.internal.DraggableAnchors r7 = r6.getAnchors()
            float r8 = r6.getOffset()
            java.lang.Object r7 = r7.closestAnchor(r8)
            if (r7 == 0) goto Lca
            float r8 = r6.getOffset()
            androidx.compose.material3.internal.DraggableAnchors r9 = r6.getAnchors()
            float r9 = r9.positionOf(r7)
            float r8 = r8 - r9
            float r8 = java.lang.Math.abs(r8)
            int r8 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r8 > 0) goto Lca
            S7.k r8 = r6.confirmValueChange
            java.lang.Object r8 = r8.invoke(r7)
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto Lca
            r6.setCurrentValue(r7)
            goto Lca
        L8f:
            r6.setDragTarget(r5)
            androidx.compose.material3.internal.DraggableAnchors r8 = r6.getAnchors()
            float r9 = r6.getOffset()
            java.lang.Object r8 = r8.closestAnchor(r9)
            if (r8 == 0) goto Lc6
            float r9 = r6.getOffset()
            androidx.compose.material3.internal.DraggableAnchors r10 = r6.getAnchors()
            float r10 = r10.positionOf(r8)
            float r9 = r9 - r10
            float r9 = java.lang.Math.abs(r9)
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 > 0) goto Lc6
            S7.k r9 = r6.confirmValueChange
            java.lang.Object r9 = r9.invoke(r8)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto Lc6
            r6.setCurrentValue(r8)
        Lc6:
            throw r7
        Lc7:
            r6.setCurrentValue(r7)
        Lca:
            C7.r r6 = C7.r.f317a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.AnchoredDraggableState.anchoredDrag(java.lang.Object, androidx.compose.foundation.MutatePriority, S7.p, H7.c):java.lang.Object");
    }

    public /* synthetic */ AnchoredDraggableState(Object obj, k kVar, S7.a aVar, AnimationSpec animationSpec, k kVar2, int i, e eVar) {
        this(obj, kVar, aVar, animationSpec, (i & 16) != 0 ? new k() { // from class: androidx.compose.material3.internal.AnchoredDraggableState.1
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

    public /* synthetic */ AnchoredDraggableState(Object obj, DraggableAnchors draggableAnchors, k kVar, S7.a aVar, AnimationSpec animationSpec, k kVar2, int i, e eVar) {
        this(obj, draggableAnchors, kVar, aVar, animationSpec, (i & 32) != 0 ? new k() { // from class: androidx.compose.material3.internal.AnchoredDraggableState.2
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

    public AnchoredDraggableState(T t9, DraggableAnchors<T> draggableAnchors, k kVar, S7.a aVar, AnimationSpec<Float> animationSpec, k kVar2) {
        this(t9, kVar, aVar, animationSpec, kVar2);
        setAnchors(draggableAnchors);
        trySnapTo(t9);
    }
}
