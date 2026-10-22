package androidx.compose.animation.core;

import C7.r;
import D7.q;
import J7.c;
import S7.k;
import S7.n;
import Y7.f;
import androidx.annotation.FloatRange;
import androidx.collection.MutableObjectList;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import m9.AbstractC1683A;
import m9.InterfaceC1717j;
import m9.InterfaceC1733z;
import w9.InterfaceC2108a;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 f*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0002fgB\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0086@¢\u0006\u0004\b\b\u0010\tJ$\u0010\f\u001a\u00020\u00072\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00028\u0000H\u0086@¢\u0006\u0004\b\f\u0010\rJ,\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00028\u00002\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000eH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0016\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0019\u001a\u00020\u0007H\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u001a\u0010\u0018J\u000f\u0010\u001d\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u001c\u0010\u0018J\u000f\u0010\u001e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\u0018J\u0010\u0010\u001f\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b!\u0010 J\u0010\u0010\"\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\"\u0010 J\u001f\u0010'\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b)\u0010 J\u0010\u0010*\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b*\u0010 J\u000f\u0010+\u001a\u00020\u0007H\u0002¢\u0006\u0004\b+\u0010\u0018J\u000f\u0010,\u001a\u00020\u0007H\u0002¢\u0006\u0004\b,\u0010\u0018R+\u0010\u0006\u001a\u00028\u00002\u0006\u0010-\u001a\u00028\u00008V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u0010\u0005R+\u00106\u001a\u00028\u00002\u0006\u0010-\u001a\u00028\u00008V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b3\u0010/\u001a\u0004\b4\u00101\"\u0004\b5\u0010\u0005R\"\u00107\u001a\u00028\u00008\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u00101\"\u0004\b:\u0010\u0005R\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010;R\"\u0010<\u001a\u00020%8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00070B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR+\u0010\u000b\u001a\u00020\n2\u0006\u0010-\u001a\u00020\n8G@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR*\u0010L\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010K8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010S\u001a\u00020R8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010Z\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010=R\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020#0[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010^\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R \u0010a\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00070`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010c\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR \u0010e\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00070`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010b¨\u0006h"}, d2 = {"Landroidx/compose/animation/core/SeekableTransitionState;", ExifInterface.LATITUDE_SOUTH, "Landroidx/compose/animation/core/TransitionState;", "initialState", AppAgent.CONSTRUCT, "(Ljava/lang/Object;)V", "targetState", "LC7/r;", "snapTo", "(Ljava/lang/Object;LH7/c;)Ljava/lang/Object;", "", "fraction", "seekTo", "(FLjava/lang/Object;LH7/c;)Ljava/lang/Object;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "animationSpec", "animateTo", "(Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;LH7/c;)Ljava/lang/Object;", "Landroidx/compose/animation/core/Transition;", "transition", "transitionConfigured$animation_core_release", "(Landroidx/compose/animation/core/Transition;)V", "transitionConfigured", "transitionRemoved$animation_core_release", "()V", "transitionRemoved", "observeTotalDuration$animation_core_release", "observeTotalDuration", "onTotalDurationChanged$animation_core_release", "onTotalDurationChanged", "endAllAnimations", "runAnimations", "(LH7/c;)Ljava/lang/Object;", "doOneFrame", "animateOneFrame", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "animation", "", "deltaPlayTimeNanos", "recalculateAnimationValue", "(Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;J)V", "waitForCompositionAfterTargetStateChange", "waitForComposition", "moveAnimationToInitialState", "seekToFraction", "<set-?>", "targetState$delegate", "Landroidx/compose/runtime/MutableState;", "getTargetState", "()Ljava/lang/Object;", "setTargetState$animation_core_release", "currentState$delegate", "getCurrentState", "setCurrentState$animation_core_release", "currentState", "composedTargetState", "Ljava/lang/Object;", "getComposedTargetState$animation_core_release", "setComposedTargetState$animation_core_release", "Landroidx/compose/animation/core/Transition;", "totalDurationNanos", "J", "getTotalDurationNanos$animation_core_release", "()J", "setTotalDurationNanos$animation_core_release", "(J)V", "Lkotlin/Function0;", "recalculateTotalDurationNanos", "LS7/a;", "fraction$delegate", "Landroidx/compose/runtime/MutableFloatState;", "getFraction", "()F", "setFraction", "(F)V", "Lm9/j;", "compositionContinuation", "Lm9/j;", "getCompositionContinuation$animation_core_release", "()Lm9/j;", "setCompositionContinuation$animation_core_release", "(Lm9/j;)V", "Lw9/a;", "compositionContinuationMutex", "Lw9/a;", "getCompositionContinuationMutex$animation_core_release", "()Lw9/a;", "Landroidx/compose/animation/core/MutatorMutex;", "mutatorMutex", "Landroidx/compose/animation/core/MutatorMutex;", "lastFrameTimeNanos", "Landroidx/collection/MutableObjectList;", "initialValueAnimations", "Landroidx/collection/MutableObjectList;", "currentAnimation", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "Lkotlin/Function1;", "firstFrameLambda", "LS7/k;", "durationScale", "F", "animateOneFrameLambda", "Companion", "SeekingAnimationState", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SeekableTransitionState<S> extends TransitionState<S> {
    private final k animateOneFrameLambda;
    private S composedTargetState;
    private InterfaceC1717j compositionContinuation;
    private final InterfaceC2108a compositionContinuationMutex;
    private SeekingAnimationState currentAnimation;

    /* renamed from: currentState$delegate, reason: from kotlin metadata */
    private final MutableState currentState;
    private float durationScale;
    private final k firstFrameLambda;

    /* renamed from: fraction$delegate, reason: from kotlin metadata */
    private final MutableFloatState fraction;
    private final MutableObjectList<SeekingAnimationState> initialValueAnimations;
    private long lastFrameTimeNanos;
    private final MutatorMutex mutatorMutex;
    private final S7.a recalculateTotalDurationNanos;

    /* renamed from: targetState$delegate, reason: from kotlin metadata */
    private final MutableState targetState;
    private long totalDurationNanos;
    private Transition<S> transition;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final AnimationVector1D ZeroVelocity = new AnimationVector1D(0.0f);
    private static final AnimationVector1D Target1 = new AnimationVector1D(1.0f);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/compose/animation/core/SeekableTransitionState$Companion;", "", "()V", "Target1", "Landroidx/compose/animation/core/AnimationVector1D;", "getTarget1", "()Landroidx/compose/animation/core/AnimationVector1D;", "ZeroVelocity", "getZeroVelocity", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final AnimationVector1D getTarget1() {
            return SeekableTransitionState.Target1;
        }

        public final AnimationVector1D getZeroVelocity() {
            return SeekableTransitionState.ZeroVelocity;
        }

        private Companion() {
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010)\u001a\u00020*H\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR\u001a\u0010 \u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0015\"\u0004\b\"\u0010\u0017R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006+"}, d2 = {"Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "", "()V", "animationSpec", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "Landroidx/compose/animation/core/AnimationVector1D;", "getAnimationSpec", "()Landroidx/compose/animation/core/VectorizedAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;)V", "animationSpecDuration", "", "getAnimationSpecDuration", "()J", "setAnimationSpecDuration", "(J)V", "durationNanos", "getDurationNanos", "setDurationNanos", "initialVelocity", "getInitialVelocity", "()Landroidx/compose/animation/core/AnimationVector1D;", "setInitialVelocity", "(Landroidx/compose/animation/core/AnimationVector1D;)V", "isComplete", "", "()Z", "setComplete", "(Z)V", "progressNanos", "getProgressNanos", "setProgressNanos", "start", "getStart", "setStart", "value", "", "getValue", "()F", "setValue", "(F)V", "toString", "", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SeekingAnimationState {
        public static final int $stable = 8;
        private VectorizedAnimationSpec<AnimationVector1D> animationSpec;
        private long animationSpecDuration;
        private long durationNanos;
        private AnimationVector1D initialVelocity;
        private boolean isComplete;
        private long progressNanos;
        private AnimationVector1D start = new AnimationVector1D(0.0f);
        private float value;

        public final VectorizedAnimationSpec<AnimationVector1D> getAnimationSpec() {
            return this.animationSpec;
        }

        public final long getAnimationSpecDuration() {
            return this.animationSpecDuration;
        }

        public final long getDurationNanos() {
            return this.durationNanos;
        }

        public final AnimationVector1D getInitialVelocity() {
            return this.initialVelocity;
        }

        public final long getProgressNanos() {
            return this.progressNanos;
        }

        public final AnimationVector1D getStart() {
            return this.start;
        }

        public final float getValue() {
            return this.value;
        }

        /* renamed from: isComplete, reason: from getter */
        public final boolean getIsComplete() {
            return this.isComplete;
        }

        public final void setAnimationSpec(VectorizedAnimationSpec<AnimationVector1D> vectorizedAnimationSpec) {
            this.animationSpec = vectorizedAnimationSpec;
        }

        public final void setAnimationSpecDuration(long j5) {
            this.animationSpecDuration = j5;
        }

        public final void setComplete(boolean z10) {
            this.isComplete = z10;
        }

        public final void setDurationNanos(long j5) {
            this.durationNanos = j5;
        }

        public final void setInitialVelocity(AnimationVector1D animationVector1D) {
            this.initialVelocity = animationVector1D;
        }

        public final void setProgressNanos(long j5) {
            this.progressNanos = j5;
        }

        public final void setStart(AnimationVector1D animationVector1D) {
            this.start = animationVector1D;
        }

        public final void setValue(float f) {
            this.value = f;
        }

        public String toString() {
            return "progress nanos: " + this.progressNanos + ", animationSpec: " + this.animationSpec + ", isComplete: " + this.isComplete + ", value: " + this.value + ", start: " + this.start + ", initialVelocity: " + this.initialVelocity + ", durationNanos: " + this.durationNanos + ", animationSpecDuration: " + this.animationSpecDuration;
        }
    }

    @c(c = "androidx.compose.animation.core.SeekableTransitionState$animateTo$2", f = "Transition.kt", l = {621}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.LATITUDE_SOUTH, "LC7/r;", "<anonymous>", "()V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.animation.core.SeekableTransitionState$animateTo$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements k {
        final /* synthetic */ FiniteAnimationSpec<Float> $animationSpec;
        final /* synthetic */ S $targetState;
        final /* synthetic */ Transition<S> $transition;
        int label;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        @c(c = "androidx.compose.animation.core.SeekableTransitionState$animateTo$2$1", f = "Transition.kt", l = {2189, 634, 636, 688, 690}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.LATITUDE_SOUTH, "Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.animation.core.SeekableTransitionState$animateTo$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements n {
            final /* synthetic */ FiniteAnimationSpec<Float> $animationSpec;
            final /* synthetic */ S $targetState;
            final /* synthetic */ Transition<S> $transition;
            Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SeekableTransitionState<S> seekableTransitionState, S s5, Transition<S> transition, FiniteAnimationSpec<Float> finiteAnimationSpec, H7.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.this$0 = seekableTransitionState;
                this.$targetState = s5;
                this.$transition = transition;
                this.$animationSpec = finiteAnimationSpec;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new AnonymousClass1(this.this$0, this.$targetState, this.$transition, this.$animationSpec, cVar);
            }

            /* JADX WARN: Code restructure failed: missing block: B:74:0x01e6, code lost:
            
                if (r2.waitForComposition(r18) != r1) goto L76;
             */
            /* JADX WARN: Removed duplicated region for block: B:32:0x00b9  */
            /* JADX WARN: Removed duplicated region for block: B:34:0x00c7  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r19) {
                /*
                    Method dump skipped, instructions count: 502
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SeekableTransitionState.AnonymousClass2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Transition<S> transition, SeekableTransitionState<S> seekableTransitionState, S s5, FiniteAnimationSpec<Float> finiteAnimationSpec, H7.c<? super AnonymousClass2> cVar) {
            super(1, cVar);
            this.$transition = transition;
            this.this$0 = seekableTransitionState;
            this.$targetState = s5;
            this.$animationSpec = finiteAnimationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(H7.c<?> cVar) {
            return new AnonymousClass2(this.$transition, this.this$0, this.$targetState, this.$animationSpec, cVar);
        }

        @Override // S7.k
        public final Object invoke(H7.c<? super r> cVar) {
            return ((AnonymousClass2) create(cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$targetState, this.$transition, this.$animationSpec, null);
                this.label = 1;
                if (AbstractC1683A.f(anonymousClass1, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            this.$transition.onTransitionEnd$animation_core_release();
            return r.f317a;
        }
    }

    @c(c = "androidx.compose.animation.core.SeekableTransitionState", f = "Transition.kt", l = {368, 371}, m = "runAnimations")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.animation.core.SeekableTransitionState$runAnimations$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SeekableTransitionState<S> seekableTransitionState, H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
            this.this$0 = seekableTransitionState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.runAnimations(this);
        }
    }

    @c(c = "androidx.compose.animation.core.SeekableTransitionState$seekTo$3", f = "Transition.kt", l = {TypedValues.PositionType.TYPE_PERCENT_Y}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.LATITUDE_SOUTH, "LC7/r;", "<anonymous>", "()V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.animation.core.SeekableTransitionState$seekTo$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements k {
        final /* synthetic */ float $fraction;
        final /* synthetic */ S $oldTargetState;
        final /* synthetic */ S $targetState;
        final /* synthetic */ Transition<S> $transition;
        int label;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        @c(c = "androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1", f = "Transition.kt", l = {529}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.LATITUDE_SOUTH, "Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements n {
            final /* synthetic */ float $fraction;
            final /* synthetic */ S $oldTargetState;
            final /* synthetic */ S $targetState;
            final /* synthetic */ Transition<S> $transition;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ SeekableTransitionState<S> this$0;

            @c(c = "androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1$1", f = "Transition.kt", l = {525}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.LATITUDE_SOUTH, "Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
            /* renamed from: androidx.compose.animation.core.SeekableTransitionState$seekTo$3$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C00011 extends SuspendLambda implements n {
                int label;
                final /* synthetic */ SeekableTransitionState<S> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00011(SeekableTransitionState<S> seekableTransitionState, H7.c<? super C00011> cVar) {
                    super(2, cVar);
                    this.this$0 = seekableTransitionState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                    return new C00011(this.this$0, cVar);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                    int i = this.label;
                    if (i == 0) {
                        b.b(obj);
                        SeekableTransitionState<S> seekableTransitionState = this.this$0;
                        this.label = 1;
                        if (seekableTransitionState.runAnimations(this) == coroutineSingletons) {
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
                public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                    return ((C00011) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(S s5, S s10, SeekableTransitionState<S> seekableTransitionState, Transition<S> transition, float f, H7.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.$targetState = s5;
                this.$oldTargetState = s10;
                this.this$0 = seekableTransitionState;
                this.$transition = transition;
                this.$fraction = f;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$targetState, this.$oldTargetState, this.this$0, this.$transition, this.$fraction, cVar);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                r rVar = r.f317a;
                if (i == 0) {
                    b.b(obj);
                    InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.L$0;
                    if (kotlin.jvm.internal.k.b(this.$targetState, this.$oldTargetState)) {
                        ((SeekableTransitionState) this.this$0).currentAnimation = null;
                        if (kotlin.jvm.internal.k.b(this.this$0.getCurrentState(), this.$targetState)) {
                            return rVar;
                        }
                    } else {
                        this.this$0.moveAnimationToInitialState();
                    }
                    if (!kotlin.jvm.internal.k.b(this.$targetState, this.$oldTargetState)) {
                        this.$transition.updateTarget$animation_core_release(this.$targetState);
                        this.$transition.setPlayTimeNanos(0L);
                        this.this$0.setTargetState$animation_core_release(this.$targetState);
                        this.$transition.resetAnimationFraction$animation_core_release(this.$fraction);
                    }
                    this.this$0.setFraction(this.$fraction);
                    if (((SeekableTransitionState) this.this$0).initialValueAnimations.isNotEmpty()) {
                        AbstractC1683A.n(interfaceC1733z, null, new C00011(this.this$0, null), 3);
                    } else {
                        ((SeekableTransitionState) this.this$0).lastFrameTimeNanos = Long.MIN_VALUE;
                    }
                    SeekableTransitionState<S> seekableTransitionState = this.this$0;
                    this.label = 1;
                    if (seekableTransitionState.waitForCompositionAfterTargetStateChange(this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b.b(obj);
                }
                this.this$0.seekToFraction();
                return rVar;
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(S s5, S s10, SeekableTransitionState<S> seekableTransitionState, Transition<S> transition, float f, H7.c<? super AnonymousClass3> cVar) {
            super(1, cVar);
            this.$targetState = s5;
            this.$oldTargetState = s10;
            this.this$0 = seekableTransitionState;
            this.$transition = transition;
            this.$fraction = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(H7.c<?> cVar) {
            return new AnonymousClass3(this.$targetState, this.$oldTargetState, this.this$0, this.$transition, this.$fraction, cVar);
        }

        @Override // S7.k
        public final Object invoke(H7.c<? super r> cVar) {
            return ((AnonymousClass3) create(cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$targetState, this.$oldTargetState, this.this$0, this.$transition, this.$fraction, null);
                this.label = 1;
                if (AbstractC1683A.f(anonymousClass1, this) == coroutineSingletons) {
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

    @c(c = "androidx.compose.animation.core.SeekableTransitionState$snapTo$2", f = "Transition.kt", l = {475}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.LATITUDE_SOUTH, "LC7/r;", "<anonymous>", "()V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.animation.core.SeekableTransitionState$snapTo$2, reason: invalid class name and case insensitive filesystem */
    public static final class C03602 extends SuspendLambda implements k {
        final /* synthetic */ S $targetState;
        final /* synthetic */ Transition<S> $transition;
        int label;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03602(SeekableTransitionState<S> seekableTransitionState, S s5, Transition<S> transition, H7.c<? super C03602> cVar) {
            super(1, cVar);
            this.this$0 = seekableTransitionState;
            this.$targetState = s5;
            this.$transition = transition;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(H7.c<?> cVar) {
            return new C03602(this.this$0, this.$targetState, this.$transition, cVar);
        }

        @Override // S7.k
        public final Object invoke(H7.c<? super r> cVar) {
            return ((C03602) create(cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                this.this$0.endAllAnimations();
                ((SeekableTransitionState) this.this$0).lastFrameTimeNanos = Long.MIN_VALUE;
                this.this$0.setFraction(0.0f);
                S s5 = this.$targetState;
                float f = kotlin.jvm.internal.k.b(s5, this.this$0.getCurrentState()) ? -4.0f : kotlin.jvm.internal.k.b(s5, this.this$0.getTargetState()) ? -5.0f : -3.0f;
                this.$transition.updateTarget$animation_core_release(this.$targetState);
                this.$transition.setPlayTimeNanos(0L);
                this.this$0.setTargetState$animation_core_release(this.$targetState);
                this.this$0.setFraction(0.0f);
                this.this$0.setCurrentState$animation_core_release(this.$targetState);
                this.$transition.resetAnimationFraction$animation_core_release(f);
                if (f == -3.0f) {
                    SeekableTransitionState<S> seekableTransitionState = this.this$0;
                    this.label = 1;
                    if (seekableTransitionState.waitForCompositionAfterTargetStateChange(this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            this.$transition.onTransitionEnd$animation_core_release();
            return r.f317a;
        }
    }

    @c(c = "androidx.compose.animation.core.SeekableTransitionState", f = "Transition.kt", l = {564, 2184}, m = "waitForComposition")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.animation.core.SeekableTransitionState$waitForComposition$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03611 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03611(SeekableTransitionState<S> seekableTransitionState, H7.c<? super C03611> cVar) {
            super(cVar);
            this.this$0 = seekableTransitionState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.waitForComposition(this);
        }
    }

    @c(c = "androidx.compose.animation.core.SeekableTransitionState", f = "Transition.kt", l = {540, 2184}, m = "waitForCompositionAfterTargetStateChange")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.animation.core.SeekableTransitionState$waitForCompositionAfterTargetStateChange$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03621 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SeekableTransitionState<S> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03621(SeekableTransitionState<S> seekableTransitionState, H7.c<? super C03621> cVar) {
            super(cVar);
            this.this$0 = seekableTransitionState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.waitForCompositionAfterTargetStateChange(this);
        }
    }

    public SeekableTransitionState(S s5) {
        super(null);
        this.targetState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(s5, null, 2, null);
        this.currentState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(s5, null, 2, null);
        this.composedTargetState = s5;
        this.recalculateTotalDurationNanos = new S7.a(this) { // from class: androidx.compose.animation.core.SeekableTransitionState$recalculateTotalDurationNanos$1
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // S7.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m170invoke();
                return r.f317a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m170invoke() {
                SeekableTransitionState<S> seekableTransitionState = this.this$0;
                Transition transition = ((SeekableTransitionState) seekableTransitionState).transition;
                seekableTransitionState.setTotalDurationNanos$animation_core_release(transition != null ? transition.getTotalDurationNanos() : 0L);
            }
        };
        this.fraction = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.compositionContinuationMutex = new kotlinx.coroutines.sync.a();
        this.mutatorMutex = new MutatorMutex();
        this.lastFrameTimeNanos = Long.MIN_VALUE;
        this.initialValueAnimations = new MutableObjectList<>(0, 1, null);
        this.firstFrameLambda = new k(this) { // from class: androidx.compose.animation.core.SeekableTransitionState$firstFrameLambda$1
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return r.f317a;
            }

            public final void invoke(long j5) {
                ((SeekableTransitionState) this.this$0).lastFrameTimeNanos = j5;
            }
        };
        this.animateOneFrameLambda = new k(this) { // from class: androidx.compose.animation.core.SeekableTransitionState$animateOneFrameLambda$1
            final /* synthetic */ SeekableTransitionState<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).longValue());
                return r.f317a;
            }

            public final void invoke(long j5) {
                long j6 = j5 - ((SeekableTransitionState) this.this$0).lastFrameTimeNanos;
                ((SeekableTransitionState) this.this$0).lastFrameTimeNanos = j5;
                long jV = U7.a.V(j6 / ((SeekableTransitionState) this.this$0).durationScale);
                if (((SeekableTransitionState) this.this$0).initialValueAnimations.isNotEmpty()) {
                    MutableObjectList mutableObjectList = ((SeekableTransitionState) this.this$0).initialValueAnimations;
                    SeekableTransitionState<S> seekableTransitionState = this.this$0;
                    Object[] objArr = mutableObjectList.content;
                    int i = mutableObjectList._size;
                    int i6 = 0;
                    for (int i10 = 0; i10 < i; i10++) {
                        SeekableTransitionState.SeekingAnimationState seekingAnimationState = (SeekableTransitionState.SeekingAnimationState) objArr[i10];
                        seekableTransitionState.recalculateAnimationValue(seekingAnimationState, jV);
                        seekingAnimationState.setComplete(true);
                    }
                    Transition transition = ((SeekableTransitionState) this.this$0).transition;
                    if (transition != null) {
                        transition.updateInitialValues$animation_core_release();
                    }
                    MutableObjectList mutableObjectList2 = ((SeekableTransitionState) this.this$0).initialValueAnimations;
                    int i11 = mutableObjectList2._size;
                    Object[] objArr2 = mutableObjectList2.content;
                    f fVarX = AbstractC1451a.X(0, i11);
                    int i12 = fVarX.f1569a;
                    int i13 = fVarX.b;
                    if (i12 <= i13) {
                        while (true) {
                            objArr2[i12 - i6] = objArr2[i12];
                            if (((SeekableTransitionState.SeekingAnimationState) objArr2[i12]).getIsComplete()) {
                                i6++;
                            }
                            if (i12 == i13) {
                                break;
                            } else {
                                i12++;
                            }
                        }
                    }
                    q.f0(null, i11 - i6, objArr2, i11);
                    mutableObjectList2._size -= i6;
                }
                SeekableTransitionState.SeekingAnimationState seekingAnimationState2 = ((SeekableTransitionState) this.this$0).currentAnimation;
                if (seekingAnimationState2 != null) {
                    seekingAnimationState2.setDurationNanos(this.this$0.getTotalDurationNanos());
                    this.this$0.recalculateAnimationValue(seekingAnimationState2, jV);
                    this.this$0.setFraction(seekingAnimationState2.getValue());
                    if (seekingAnimationState2.getValue() == 1.0f) {
                        ((SeekableTransitionState) this.this$0).currentAnimation = null;
                    }
                    this.this$0.seekToFraction();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object animateOneFrame(H7.c<? super r> cVar) {
        float durationScale = SuspendAnimationKt.getDurationScale(cVar.getContext());
        r rVar = r.f317a;
        if (durationScale <= 0.0f) {
            endAllAnimations();
            return rVar;
        }
        this.durationScale = durationScale;
        Object objWithFrameNanos = MonotonicFrameClockKt.withFrameNanos(this.animateOneFrameLambda, cVar);
        return objWithFrameNanos == CoroutineSingletons.f4909a ? objWithFrameNanos : rVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTo$default(SeekableTransitionState seekableTransitionState, Object obj, FiniteAnimationSpec finiteAnimationSpec, H7.c cVar, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = seekableTransitionState.getTargetState();
        }
        if ((i & 2) != 0) {
            finiteAnimationSpec = null;
        }
        return seekableTransitionState.animateTo(obj, finiteAnimationSpec, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object doOneFrame(H7.c<? super r> cVar) {
        long j5 = this.lastFrameTimeNanos;
        r rVar = r.f317a;
        if (j5 == Long.MIN_VALUE) {
            Object objWithFrameNanos = MonotonicFrameClockKt.withFrameNanos(this.firstFrameLambda, cVar);
            return objWithFrameNanos == CoroutineSingletons.f4909a ? objWithFrameNanos : rVar;
        }
        Object objAnimateOneFrame = animateOneFrame(cVar);
        return objAnimateOneFrame == CoroutineSingletons.f4909a ? objAnimateOneFrame : rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void endAllAnimations() {
        Transition<S> transition = this.transition;
        if (transition != null) {
            transition.clearInitialAnimations$animation_core_release();
        }
        this.initialValueAnimations.clear();
        if (this.currentAnimation != null) {
            this.currentAnimation = null;
            setFraction(1.0f);
            seekToFraction();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void moveAnimationToInitialState() {
        Transition<S> transition = this.transition;
        if (transition == null) {
            return;
        }
        SeekingAnimationState seekingAnimationState = this.currentAnimation;
        if (seekingAnimationState == null) {
            if (this.totalDurationNanos <= 0 || getFraction() == 1.0f || kotlin.jvm.internal.k.b(getCurrentState(), getTargetState())) {
                seekingAnimationState = null;
            } else {
                seekingAnimationState = new SeekingAnimationState();
                seekingAnimationState.setValue(getFraction());
                long j5 = this.totalDurationNanos;
                seekingAnimationState.setDurationNanos(j5);
                seekingAnimationState.setAnimationSpecDuration(U7.a.V((1.0d - getFraction()) * j5));
                seekingAnimationState.getStart().set$animation_core_release(0, getFraction());
            }
        }
        if (seekingAnimationState != null) {
            seekingAnimationState.setDurationNanos(this.totalDurationNanos);
            this.initialValueAnimations.add(seekingAnimationState);
            transition.setInitialAnimations$animation_core_release(seekingAnimationState);
        }
        this.currentAnimation = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recalculateAnimationValue(SeekingAnimationState animation, long deltaPlayTimeNanos) {
        long progressNanos = animation.getProgressNanos() + deltaPlayTimeNanos;
        animation.setProgressNanos(progressNanos);
        long animationSpecDuration = animation.getAnimationSpecDuration();
        if (progressNanos >= animationSpecDuration) {
            animation.setValue(1.0f);
            return;
        }
        VectorizedAnimationSpec<AnimationVector1D> animationSpec = animation.getAnimationSpec();
        if (animationSpec == null) {
            animation.setValue(VectorConvertersKt.lerp(animation.getStart().get$animation_core_release(0), 1.0f, progressNanos / animationSpecDuration));
            return;
        }
        AnimationVector1D start = animation.getStart();
        AnimationVector1D animationVector1D = Target1;
        AnimationVector1D initialVelocity = animation.getInitialVelocity();
        if (initialVelocity == null) {
            initialVelocity = ZeroVelocity;
        }
        animation.setValue(AbstractC1451a.t(((AnimationVector1D) animationSpec.getValueFromNanos(progressNanos, start, animationVector1D, initialVelocity)).get$animation_core_release(0), 0.0f, 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object runAnimations(H7.c<? super C7.r> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof androidx.compose.animation.core.SeekableTransitionState.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r11
            androidx.compose.animation.core.SeekableTransitionState$runAnimations$1 r0 = (androidx.compose.animation.core.SeekableTransitionState.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.animation.core.SeekableTransitionState$runAnimations$1 r0 = new androidx.compose.animation.core.SeekableTransitionState$runAnimations$1
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = -9223372036854775808
            C7.r r7 = C7.r.f317a
            if (r2 == 0) goto L3b
            if (r2 == r4) goto L33
            if (r2 != r3) goto L2b
            goto L33
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L33:
            java.lang.Object r10 = r0.L$0
            androidx.compose.animation.core.SeekableTransitionState r10 = (androidx.compose.animation.core.SeekableTransitionState) r10
            kotlin.b.b(r11)
            goto L71
        L3b:
            kotlin.b.b(r11)
            androidx.collection.MutableObjectList<androidx.compose.animation.core.SeekableTransitionState$SeekingAnimationState> r11 = r10.initialValueAnimations
            boolean r11 = r11.isEmpty()
            if (r11 == 0) goto L4b
            androidx.compose.animation.core.SeekableTransitionState$SeekingAnimationState r11 = r10.currentAnimation
            if (r11 != 0) goto L4b
            return r7
        L4b:
            H7.h r11 = r0.getContext()
            float r11 = androidx.compose.animation.core.SuspendAnimationKt.getDurationScale(r11)
            r2 = 0
            int r11 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r11 != 0) goto L5e
            r10.endAllAnimations()
            r10.lastFrameTimeNanos = r5
            return r7
        L5e:
            long r8 = r10.lastFrameTimeNanos
            int r11 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r11 != 0) goto L71
            S7.k r11 = r10.firstFrameLambda
            r0.L$0 = r10
            r0.label = r4
            java.lang.Object r11 = androidx.compose.runtime.MonotonicFrameClockKt.withFrameNanos(r11, r0)
            if (r11 != r1) goto L71
            goto L8b
        L71:
            androidx.collection.MutableObjectList<androidx.compose.animation.core.SeekableTransitionState$SeekingAnimationState> r11 = r10.initialValueAnimations
            boolean r11 = r11.isNotEmpty()
            if (r11 != 0) goto L81
            androidx.compose.animation.core.SeekableTransitionState$SeekingAnimationState r11 = r10.currentAnimation
            if (r11 == 0) goto L7e
            goto L81
        L7e:
            r10.lastFrameTimeNanos = r5
            return r7
        L81:
            r0.L$0 = r10
            r0.label = r3
            java.lang.Object r11 = r10.animateOneFrame(r0)
            if (r11 != r1) goto L71
        L8b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SeekableTransitionState.runAnimations(H7.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object seekTo$default(SeekableTransitionState seekableTransitionState, float f, Object obj, H7.c cVar, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = seekableTransitionState.getTargetState();
        }
        return seekableTransitionState.seekTo(f, obj, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void seekToFraction() {
        Transition<S> transition = this.transition;
        if (transition == null) {
            return;
        }
        transition.seekAnimations$animation_core_release(U7.a.V(getFraction() * transition.getTotalDurationNanos()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setFraction(float f) {
        this.fraction.setFloatValue(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object waitForComposition(H7.c<? super C7.r> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.compose.animation.core.SeekableTransitionState.C03611
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.animation.core.SeekableTransitionState$waitForComposition$1 r0 = (androidx.compose.animation.core.SeekableTransitionState.C03611) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.animation.core.SeekableTransitionState$waitForComposition$1 r0 = new androidx.compose.animation.core.SeekableTransitionState$waitForComposition$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L45
            if (r2 == r5) goto L39
            if (r2 != r4) goto L31
            java.lang.Object r7 = r0.L$1
            java.lang.Object r0 = r0.L$0
            androidx.compose.animation.core.SeekableTransitionState r0 = (androidx.compose.animation.core.SeekableTransitionState) r0
            kotlin.b.b(r8)
            goto L82
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            java.lang.Object r7 = r0.L$1
            java.lang.Object r2 = r0.L$0
            androidx.compose.animation.core.SeekableTransitionState r2 = (androidx.compose.animation.core.SeekableTransitionState) r2
            kotlin.b.b(r8)
            r8 = r7
            r7 = r2
            goto L5b
        L45:
            kotlin.b.b(r8)
            java.lang.Object r8 = r7.getTargetState()
            w9.a r2 = r7.compositionContinuationMutex
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r5
            java.lang.Object r2 = r2.lock(r3, r0)
            if (r2 != r1) goto L5b
            goto L7d
        L5b:
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            m9.k r2 = new m9.k
            H7.c r0 = U7.a.I(r0)
            r2.<init>(r5, r0)
            r2.y()
            r7.setCompositionContinuation$animation_core_release(r2)
            w9.a r0 = r7.getCompositionContinuationMutex()
            r0.unlock(r3)
            java.lang.Object r0 = r2.x()
            if (r0 != r1) goto L7e
        L7d:
            return r1
        L7e:
            r6 = r0
            r0 = r7
            r7 = r8
            r8 = r6
        L82:
            boolean r7 = kotlin.jvm.internal.k.b(r8, r7)
            if (r7 == 0) goto L8b
            C7.r r7 = C7.r.f317a
            return r7
        L8b:
            r7 = -9223372036854775808
            r0.lastFrameTimeNanos = r7
            java.util.concurrent.CancellationException r7 = new java.util.concurrent.CancellationException
            java.lang.String r8 = "targetState while waiting for composition"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SeekableTransitionState.waitForComposition(H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object waitForCompositionAfterTargetStateChange(H7.c<? super C7.r> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.compose.animation.core.SeekableTransitionState.C03621
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.animation.core.SeekableTransitionState$waitForCompositionAfterTargetStateChange$1 r0 = (androidx.compose.animation.core.SeekableTransitionState.C03621) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.animation.core.SeekableTransitionState$waitForCompositionAfterTargetStateChange$1 r0 = new androidx.compose.animation.core.SeekableTransitionState$waitForCompositionAfterTargetStateChange$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L43
            if (r2 == r5) goto L39
            if (r2 != r4) goto L31
            java.lang.Object r6 = r0.L$1
            java.lang.Object r0 = r0.L$0
            androidx.compose.animation.core.SeekableTransitionState r0 = (androidx.compose.animation.core.SeekableTransitionState) r0
            kotlin.b.b(r7)
            goto L8d
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            java.lang.Object r6 = r0.L$1
            java.lang.Object r2 = r0.L$0
            androidx.compose.animation.core.SeekableTransitionState r2 = (androidx.compose.animation.core.SeekableTransitionState) r2
            kotlin.b.b(r7)
            goto L5b
        L43:
            kotlin.b.b(r7)
            java.lang.Object r7 = r6.getTargetState()
            w9.a r2 = r6.compositionContinuationMutex
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r5
            java.lang.Object r2 = r2.lock(r3, r0)
            if (r2 != r1) goto L59
            goto L8b
        L59:
            r2 = r6
            r6 = r7
        L5b:
            S r7 = r2.composedTargetState
            boolean r7 = kotlin.jvm.internal.k.b(r6, r7)
            if (r7 == 0) goto L69
            w9.a r6 = r2.compositionContinuationMutex
            r6.unlock(r3)
            goto L93
        L69:
            r0.L$0 = r2
            r0.L$1 = r6
            r0.label = r4
            m9.k r7 = new m9.k
            H7.c r0 = U7.a.I(r0)
            r7.<init>(r5, r0)
            r7.y()
            r2.setCompositionContinuation$animation_core_release(r7)
            w9.a r0 = r2.getCompositionContinuationMutex()
            r0.unlock(r3)
            java.lang.Object r7 = r7.x()
            if (r7 != r1) goto L8c
        L8b:
            return r1
        L8c:
            r0 = r2
        L8d:
            boolean r1 = kotlin.jvm.internal.k.b(r7, r6)
            if (r1 == 0) goto L96
        L93:
            C7.r r6 = C7.r.f317a
            return r6
        L96:
            r1 = -9223372036854775808
            r0.lastFrameTimeNanos = r1
            java.util.concurrent.CancellationException r0 = new java.util.concurrent.CancellationException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "snapTo() was canceled because state was changed to "
            r1.<init>(r2)
            r1.append(r7)
            java.lang.String r7 = " instead of "
            r1.append(r7)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SeekableTransitionState.waitForCompositionAfterTargetStateChange(H7.c):java.lang.Object");
    }

    public final Object animateTo(S s5, FiniteAnimationSpec<Float> finiteAnimationSpec, H7.c<? super r> cVar) {
        Object objMutate$default;
        Transition<S> transition = this.transition;
        r rVar = r.f317a;
        return (transition != null && (objMutate$default = MutatorMutex.mutate$default(this.mutatorMutex, null, new AnonymousClass2(transition, this, s5, finiteAnimationSpec, null), cVar, 1, null)) == CoroutineSingletons.f4909a) ? objMutate$default : rVar;
    }

    public final S getComposedTargetState$animation_core_release() {
        return this.composedTargetState;
    }

    /* renamed from: getCompositionContinuation$animation_core_release, reason: from getter */
    public final InterfaceC1717j getCompositionContinuation() {
        return this.compositionContinuation;
    }

    /* renamed from: getCompositionContinuationMutex$animation_core_release, reason: from getter */
    public final InterfaceC2108a getCompositionContinuationMutex() {
        return this.compositionContinuationMutex;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public S getCurrentState() {
        return (S) this.currentState.getValue();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public final float getFraction() {
        return this.fraction.getFloatValue();
    }

    @Override // androidx.compose.animation.core.TransitionState
    public S getTargetState() {
        return (S) this.targetState.getValue();
    }

    /* renamed from: getTotalDurationNanos$animation_core_release, reason: from getter */
    public final long getTotalDurationNanos() {
        return this.totalDurationNanos;
    }

    public final void observeTotalDuration$animation_core_release() {
        TransitionKt.getSeekableStateObserver().observeReads(this, TransitionKt.SeekableTransitionStateTotalDurationChanged, this.recalculateTotalDurationNanos);
    }

    public final void onTotalDurationChanged$animation_core_release() {
        long j5 = this.totalDurationNanos;
        observeTotalDuration$animation_core_release();
        long j6 = this.totalDurationNanos;
        if (j5 != j6) {
            SeekingAnimationState seekingAnimationState = this.currentAnimation;
            if (seekingAnimationState == null) {
                seekToFraction();
                return;
            }
            seekingAnimationState.setDurationNanos(j6);
            if (seekingAnimationState.getAnimationSpec() == null) {
                seekingAnimationState.setAnimationSpecDuration(U7.a.V((1.0d - seekingAnimationState.getStart().get$animation_core_release(0)) * this.totalDurationNanos));
            }
        }
    }

    public final Object seekTo(@FloatRange(from = 0.0d, to = 1.0d) float f, S s5, H7.c<? super r> cVar) {
        boolean z10 = false;
        if (0.0f <= f && f <= 1.0f) {
            z10 = true;
        }
        if (!z10) {
            PreconditionsKt.throwIllegalArgumentException("Expecting fraction between 0 and 1. Got " + f);
        }
        Transition<S> transition = this.transition;
        r rVar = r.f317a;
        if (transition == null) {
            return rVar;
        }
        Object objMutate$default = MutatorMutex.mutate$default(this.mutatorMutex, null, new AnonymousClass3(s5, getTargetState(), this, transition, f, null), cVar, 1, null);
        return objMutate$default == CoroutineSingletons.f4909a ? objMutate$default : rVar;
    }

    public final void setComposedTargetState$animation_core_release(S s5) {
        this.composedTargetState = s5;
    }

    public final void setCompositionContinuation$animation_core_release(InterfaceC1717j interfaceC1717j) {
        this.compositionContinuation = interfaceC1717j;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void setCurrentState$animation_core_release(S s5) {
        this.currentState.setValue(s5);
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void setTargetState$animation_core_release(S s5) {
        this.targetState.setValue(s5);
    }

    public final void setTotalDurationNanos$animation_core_release(long j5) {
        this.totalDurationNanos = j5;
    }

    public final Object snapTo(S s5, H7.c<? super r> cVar) {
        Object objMutate$default;
        Transition<S> transition = this.transition;
        r rVar = r.f317a;
        return transition == null ? rVar : (!(kotlin.jvm.internal.k.b(getCurrentState(), s5) && kotlin.jvm.internal.k.b(getTargetState(), s5)) && (objMutate$default = MutatorMutex.mutate$default(this.mutatorMutex, null, new C03602(this, s5, transition, null), cVar, 1, null)) == CoroutineSingletons.f4909a) ? objMutate$default : rVar;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void transitionConfigured$animation_core_release(Transition<S> transition) {
        Transition<S> transition2 = this.transition;
        if (!(transition2 == null || kotlin.jvm.internal.k.b(transition, transition2))) {
            PreconditionsKt.throwIllegalStateException("An instance of SeekableTransitionState has been used in different Transitions. Previous instance: " + this.transition + ", new instance: " + transition);
        }
        this.transition = transition;
    }

    @Override // androidx.compose.animation.core.TransitionState
    public void transitionRemoved$animation_core_release() {
        this.transition = null;
        TransitionKt.getSeekableStateObserver().clear(this);
    }
}
