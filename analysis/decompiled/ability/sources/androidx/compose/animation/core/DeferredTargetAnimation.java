package androidx.compose.animation.core;

import C7.r;
import J7.c;
import S7.n;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@StabilityInferred(parameters = 0)
@ExperimentalAnimatableApi
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0004B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u000e\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\n2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f¢\u0006\u0004\b\u000e\u0010\u000fR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0010R/\u0010\u0018\u001a\u0004\u0018\u00018\u00002\b\u0010\u0011\u001a\u0004\u0018\u00018\u00008B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\t\u001a\u0004\u0018\u00018\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0015R\u0013\u0010\u001e\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010 \u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Landroidx/compose/animation/core/DeferredTargetAnimation;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/animation/core/AnimationVector;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Landroidx/compose/animation/core/TwoWayConverter;", "vectorConverter", AppAgent.CONSTRUCT, "(Landroidx/compose/animation/core/TwoWayConverter;)V", TypedValues.AttributesType.S_TARGET, "Lm9/z;", "coroutineScope", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "animationSpec", "updateTarget", "(Ljava/lang/Object;Lm9/z;Landroidx/compose/animation/core/FiniteAnimationSpec;)Ljava/lang/Object;", "Landroidx/compose/animation/core/TwoWayConverter;", "<set-?>", "_pendingTarget$delegate", "Landroidx/compose/runtime/MutableState;", "get_pendingTarget", "()Ljava/lang/Object;", "set_pendingTarget", "(Ljava/lang/Object;)V", "_pendingTarget", "Landroidx/compose/animation/core/Animatable;", "animatable", "Landroidx/compose/animation/core/Animatable;", "getTarget", "getPendingTarget", "pendingTarget", "", "isIdle", "()Z", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DeferredTargetAnimation<T, V extends AnimationVector> {
    public static final int $stable = 8;

    /* renamed from: _pendingTarget$delegate, reason: from kotlin metadata */
    private final MutableState _pendingTarget = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    private Animatable<T, V> animatable;
    private final TwoWayConverter<T, V> vectorConverter;

    @c(c = "androidx.compose.animation.core.DeferredTargetAnimation$updateTarget$1", f = "DeferredTargetAnimation.kt", l = {77}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/animation/core/AnimationVector;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.animation.core.DeferredTargetAnimation$updateTarget$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ Animatable<T, V> $anim;
        final /* synthetic */ FiniteAnimationSpec<T> $animationSpec;
        final /* synthetic */ T $target;
        int label;
        final /* synthetic */ DeferredTargetAnimation<T, V> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Animatable<T, V> animatable, DeferredTargetAnimation<T, V> deferredTargetAnimation, T t9, FiniteAnimationSpec<T> finiteAnimationSpec, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$anim = animatable;
            this.this$0 = deferredTargetAnimation;
            this.$target = t9;
            this.$animationSpec = finiteAnimationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass1(this.$anim, this.this$0, this.$target, this.$animationSpec, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                if (!k.b(this.$anim.getTargetValue(), this.this$0.get_pendingTarget())) {
                    Animatable<T, V> animatable = this.$anim;
                    T t9 = this.$target;
                    FiniteAnimationSpec<T> finiteAnimationSpec = this.$animationSpec;
                    this.label = 1;
                    if (Animatable.animateTo$default(animatable, t9, finiteAnimationSpec, null, null, this, 12, null) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
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
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public DeferredTargetAnimation(TwoWayConverter<T, V> twoWayConverter) {
        this.vectorConverter = twoWayConverter;
    }

    private final T getTarget() {
        Animatable<T, V> animatable = this.animatable;
        if (animatable != null) {
            return animatable.getTargetValue();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T get_pendingTarget() {
        return this._pendingTarget.getValue();
    }

    private final void set_pendingTarget(T t9) {
        this._pendingTarget.setValue(t9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object updateTarget$default(DeferredTargetAnimation deferredTargetAnimation, Object obj, InterfaceC1733z interfaceC1733z, FiniteAnimationSpec finiteAnimationSpec, int i, Object obj2) {
        if ((i & 4) != 0) {
            finiteAnimationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        return deferredTargetAnimation.updateTarget(obj, interfaceC1733z, finiteAnimationSpec);
    }

    public final T getPendingTarget() {
        return get_pendingTarget();
    }

    public final boolean isIdle() {
        if (!k.b(get_pendingTarget(), getTarget())) {
            return false;
        }
        Animatable<T, V> animatable = this.animatable;
        return animatable == null || !animatable.isRunning();
    }

    public final T updateTarget(T target, InterfaceC1733z coroutineScope, FiniteAnimationSpec<T> animationSpec) {
        T t9;
        Animatable<T, V> animatable;
        set_pendingTarget(target);
        Animatable<T, V> animatable2 = this.animatable;
        if (animatable2 == null) {
            Animatable<T, V> animatable3 = new Animatable<>(target, this.vectorConverter, null, null, 12, null);
            this.animatable = animatable3;
            animatable = animatable3;
            t9 = target;
        } else {
            t9 = target;
            animatable = animatable2;
        }
        AbstractC1683A.n(coroutineScope, null, new AnonymousClass1(animatable, this, t9, animationSpec, null), 3);
        return animatable.getValue();
    }
}
