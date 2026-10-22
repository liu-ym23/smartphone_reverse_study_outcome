package androidx.compose.foundation.gestures;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import S7.o;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$LongRef;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0006\u001a\u00020\u00052\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a/\u0010\b\u001a\u00020\u00052\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0000H\u0007¢\u0006\u0004\b\b\u0010\t\u001a,\u0010\r\u001a\u00020\u0003*\u00020\u00052\u0006\u0010\n\u001a\u00020\u00012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0086@¢\u0006\u0004\b\r\u0010\u000e\u001a,\u0010\u0010\u001a\u00020\u0003*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0086@¢\u0006\u0004\b\u0010\u0010\u000e\u001a/\u0010\u0014\u001a\u00020\u0003*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001c\u0010\u0015\u001a\u00020\u0003*\u00020\u00052\u0006\u0010\n\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001c\u0010\u0017\u001a\u00020\u0003*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0017\u0010\u0016\u001a\u001f\u0010\u001a\u001a\u00020\u0003*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001e\u0010\u001d\u001a\u00020\u0003*\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u001bH\u0086@¢\u0006\u0004\b\u001d\u0010\u001e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"Lkotlin/Function3;", "", "Landroidx/compose/ui/geometry/Offset;", "LC7/r;", "onTransformation", "Landroidx/compose/foundation/gestures/TransformableState;", "TransformableState", "(LS7/o;)Landroidx/compose/foundation/gestures/TransformableState;", "rememberTransformableState", "(LS7/o;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/TransformableState;", "zoomFactor", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpec", "animateZoomBy", "(Landroidx/compose/foundation/gestures/TransformableState;FLandroidx/compose/animation/core/AnimationSpec;LH7/c;)Ljava/lang/Object;", "degrees", "animateRotateBy", TypedValues.CycleType.S_WAVE_OFFSET, "animatePanBy-ubNVwUQ", "(Landroidx/compose/foundation/gestures/TransformableState;JLandroidx/compose/animation/core/AnimationSpec;LH7/c;)Ljava/lang/Object;", "animatePanBy", "zoomBy", "(Landroidx/compose/foundation/gestures/TransformableState;FLH7/c;)Ljava/lang/Object;", "rotateBy", "panBy-d-4ec7I", "(Landroidx/compose/foundation/gestures/TransformableState;JLH7/c;)Ljava/lang/Object;", "panBy", "Landroidx/compose/foundation/MutatePriority;", "terminationPriority", "stopTransformation", "(Landroidx/compose/foundation/gestures/TransformableState;Landroidx/compose/foundation/MutatePriority;LH7/c;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TransformableStateKt {

    @c(c = "androidx.compose.foundation.gestures.TransformableStateKt$animateRotateBy$2", f = "TransformableState.kt", l = {158}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/TransformScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/foundation/gestures/TransformScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.gestures.TransformableStateKt$animateRotateBy$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ float $degrees;
        final /* synthetic */ Ref$FloatRef $previous;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Ref$FloatRef ref$FloatRef, float f, AnimationSpec<Float> animationSpec, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$previous = ref$FloatRef;
            this.$degrees = f;
            this.$animationSpec = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$previous, this.$degrees, this.$animationSpec, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // S7.n
        public final Object invoke(TransformScope transformScope, H7.c<? super r> cVar) {
            return ((AnonymousClass2) create(transformScope, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                final TransformScope transformScope = (TransformScope) this.L$0;
                AnimationState animationStateAnimationState$default = AnimationStateKt.AnimationState$default(this.$previous.f4917a, 0.0f, 0L, 0L, false, 30, null);
                Float f = new Float(this.$degrees);
                AnimationSpec<Float> animationSpec = this.$animationSpec;
                final Ref$FloatRef ref$FloatRef = this.$previous;
                k kVar = new k() { // from class: androidx.compose.foundation.gestures.TransformableStateKt.animateRotateBy.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((AnimationScope<Float, AnimationVector1D>) obj2);
                        return r.f317a;
                    }

                    public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                        TransformScope.m528transformByd4ec7I$default(transformScope, 0.0f, 0L, animationScope.getValue().floatValue() - ref$FloatRef.f4917a, 3, null);
                        ref$FloatRef.f4917a = animationScope.getValue().floatValue();
                    }
                };
                this.label = 1;
                if (SuspendAnimationKt.animateTo$default(animationStateAnimationState$default, f, animationSpec, false, kVar, this, 4, null) == coroutineSingletons) {
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

    @c(c = "androidx.compose.foundation.gestures.TransformableStateKt$animateZoomBy$3", f = "TransformableState.kt", l = {138}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/TransformScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/foundation/gestures/TransformScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.gestures.TransformableStateKt$animateZoomBy$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements n {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ Ref$FloatRef $previous;
        final /* synthetic */ float $zoomFactor;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Ref$FloatRef ref$FloatRef, float f, AnimationSpec<Float> animationSpec, H7.c<? super AnonymousClass3> cVar) {
            super(2, cVar);
            this.$previous = ref$FloatRef;
            this.$zoomFactor = f;
            this.$animationSpec = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$previous, this.$zoomFactor, this.$animationSpec, cVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // S7.n
        public final Object invoke(TransformScope transformScope, H7.c<? super r> cVar) {
            return ((AnonymousClass3) create(transformScope, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                final TransformScope transformScope = (TransformScope) this.L$0;
                AnimationState animationStateAnimationState$default = AnimationStateKt.AnimationState$default(this.$previous.f4917a, 0.0f, 0L, 0L, false, 30, null);
                Float f = new Float(this.$zoomFactor);
                AnimationSpec<Float> animationSpec = this.$animationSpec;
                final Ref$FloatRef ref$FloatRef = this.$previous;
                k kVar = new k() { // from class: androidx.compose.foundation.gestures.TransformableStateKt.animateZoomBy.3.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke((AnimationScope<Float, AnimationVector1D>) obj2);
                        return r.f317a;
                    }

                    public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                        TransformScope.m528transformByd4ec7I$default(transformScope, ref$FloatRef.f4917a == 0.0f ? 1.0f : animationScope.getValue().floatValue() / ref$FloatRef.f4917a, 0L, 0.0f, 6, null);
                        ref$FloatRef.f4917a = animationScope.getValue().floatValue();
                    }
                };
                this.label = 1;
                if (SuspendAnimationKt.animateTo$default(animationStateAnimationState$default, f, animationSpec, false, kVar, this, 4, null) == coroutineSingletons) {
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

    @c(c = "androidx.compose.foundation.gestures.TransformableStateKt$rotateBy$2", f = "TransformableState.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/TransformScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/foundation/gestures/TransformScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.gestures.TransformableStateKt$rotateBy$2, reason: invalid class name and case insensitive filesystem */
    public static final class C04222 extends SuspendLambda implements n {
        final /* synthetic */ float $degrees;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04222(float f, H7.c<? super C04222> cVar) {
            super(2, cVar);
            this.$degrees = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C04222 c04222 = new C04222(this.$degrees, cVar);
            c04222.L$0 = obj;
            return c04222;
        }

        @Override // S7.n
        public final Object invoke(TransformScope transformScope, H7.c<? super r> cVar) {
            return ((C04222) create(transformScope, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            ((TransformScope) this.L$0).mo413transformByd4ec7I(1.0f, Offset.INSTANCE.m3911getZeroF1C5BW0(), this.$degrees);
            return r.f317a;
        }
    }

    @c(c = "androidx.compose.foundation.gestures.TransformableStateKt$stopTransformation$2", f = "TransformableState.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/TransformScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/foundation/gestures/TransformScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.gestures.TransformableStateKt$stopTransformation$2, reason: invalid class name and case insensitive filesystem */
    public static final class C04232 extends SuspendLambda implements n {
        int label;

        public C04232(H7.c<? super C04232> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C04232(cVar);
        }

        @Override // S7.n
        public final Object invoke(TransformScope transformScope, H7.c<? super r> cVar) {
            return ((C04232) create(transformScope, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            return r.f317a;
        }
    }

    @c(c = "androidx.compose.foundation.gestures.TransformableStateKt$zoomBy$2", f = "TransformableState.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/TransformScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/foundation/gestures/TransformScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.gestures.TransformableStateKt$zoomBy$2, reason: invalid class name and case insensitive filesystem */
    public static final class C04242 extends SuspendLambda implements n {
        final /* synthetic */ float $zoomFactor;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04242(float f, H7.c<? super C04242> cVar) {
            super(2, cVar);
            this.$zoomFactor = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C04242 c04242 = new C04242(this.$zoomFactor, cVar);
            c04242.L$0 = obj;
            return c04242;
        }

        @Override // S7.n
        public final Object invoke(TransformScope transformScope, H7.c<? super r> cVar) {
            return ((C04242) create(transformScope, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            ((TransformScope) this.L$0).mo413transformByd4ec7I(this.$zoomFactor, Offset.INSTANCE.m3911getZeroF1C5BW0(), 0.0f);
            return r.f317a;
        }
    }

    public static final TransformableState TransformableState(o oVar) {
        return new DefaultTransformableState(oVar);
    }

    /* renamed from: animatePanBy-ubNVwUQ, reason: not valid java name */
    public static final Object m532animatePanByubNVwUQ(TransformableState transformableState, long j5, AnimationSpec<Offset> animationSpec, H7.c<? super r> cVar) {
        Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.f4919a = Offset.INSTANCE.m3911getZeroF1C5BW0();
        Object objTransform$default = TransformableState.transform$default(transformableState, null, new TransformableStateKt$animatePanBy$2(ref$LongRef, j5, animationSpec, null), cVar, 1, null);
        return objTransform$default == CoroutineSingletons.f4909a ? objTransform$default : r.f317a;
    }

    /* renamed from: animatePanBy-ubNVwUQ$default, reason: not valid java name */
    public static /* synthetic */ Object m533animatePanByubNVwUQ$default(TransformableState transformableState, long j5, AnimationSpec animationSpec, H7.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        return m532animatePanByubNVwUQ(transformableState, j5, animationSpec, cVar);
    }

    public static final Object animateRotateBy(TransformableState transformableState, float f, AnimationSpec<Float> animationSpec, H7.c<? super r> cVar) {
        Object objTransform$default = TransformableState.transform$default(transformableState, null, new AnonymousClass2(new Ref$FloatRef(), f, animationSpec, null), cVar, 1, null);
        return objTransform$default == CoroutineSingletons.f4909a ? objTransform$default : r.f317a;
    }

    public static /* synthetic */ Object animateRotateBy$default(TransformableState transformableState, float f, AnimationSpec animationSpec, H7.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        return animateRotateBy(transformableState, f, animationSpec, cVar);
    }

    public static final Object animateZoomBy(TransformableState transformableState, float f, AnimationSpec<Float> animationSpec, H7.c<? super r> cVar) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("zoom value should be greater than 0");
        }
        Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
        ref$FloatRef.f4917a = 1.0f;
        Object objTransform$default = TransformableState.transform$default(transformableState, null, new AnonymousClass3(ref$FloatRef, f, animationSpec, null), cVar, 1, null);
        return objTransform$default == CoroutineSingletons.f4909a ? objTransform$default : r.f317a;
    }

    public static /* synthetic */ Object animateZoomBy$default(TransformableState transformableState, float f, AnimationSpec animationSpec, H7.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = new SpringSpec(0.0f, 200.0f, null, 5, null);
        }
        return animateZoomBy(transformableState, f, animationSpec, cVar);
    }

    /* renamed from: panBy-d-4ec7I, reason: not valid java name */
    public static final Object m534panByd4ec7I(TransformableState transformableState, long j5, H7.c<? super r> cVar) {
        Object objTransform$default = TransformableState.transform$default(transformableState, null, new TransformableStateKt$panBy$2(j5, null), cVar, 1, null);
        return objTransform$default == CoroutineSingletons.f4909a ? objTransform$default : r.f317a;
    }

    @Composable
    public static final TransformableState rememberTransformableState(o oVar, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1681419281, i, -1, "androidx.compose.foundation.gestures.rememberTransformableState (TransformableState.kt:116)");
        }
        final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(oVar, composer, i & 14);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = TransformableState(new o() { // from class: androidx.compose.foundation.gestures.TransformableStateKt$rememberTransformableState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // S7.o
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    m535invoked4ec7I(((Number) obj).floatValue(), ((Offset) obj2).m3905unboximpl(), ((Number) obj3).floatValue());
                    return r.f317a;
                }

                /* renamed from: invoke-d-4ec7I, reason: not valid java name */
                public final void m535invoked4ec7I(float f, long j5, float f7) {
                    stateRememberUpdatedState.getValue().invoke(Float.valueOf(f), Offset.m3884boximpl(j5), Float.valueOf(f7));
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        TransformableState transformableState = (TransformableState) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return transformableState;
    }

    public static final Object rotateBy(TransformableState transformableState, float f, H7.c<? super r> cVar) {
        Object objTransform$default = TransformableState.transform$default(transformableState, null, new C04222(f, null), cVar, 1, null);
        return objTransform$default == CoroutineSingletons.f4909a ? objTransform$default : r.f317a;
    }

    public static final Object stopTransformation(TransformableState transformableState, MutatePriority mutatePriority, H7.c<? super r> cVar) {
        Object objTransform = transformableState.transform(mutatePriority, new C04232(null), cVar);
        return objTransform == CoroutineSingletons.f4909a ? objTransform : r.f317a;
    }

    public static /* synthetic */ Object stopTransformation$default(TransformableState transformableState, MutatePriority mutatePriority, H7.c cVar, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return stopTransformation(transformableState, mutatePriority, cVar);
    }

    public static final Object zoomBy(TransformableState transformableState, float f, H7.c<? super r> cVar) {
        Object objTransform$default = TransformableState.transform$default(transformableState, null, new C04242(f, null), cVar, 1, null);
        return objTransform$default == CoroutineSingletons.f4909a ? objTransform$default : r.f317a;
    }
}
