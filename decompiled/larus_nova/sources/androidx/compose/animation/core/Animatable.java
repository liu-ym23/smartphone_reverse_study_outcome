package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B;\b\u0007\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fB1\b\u0017\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u000b\u0010\rJ#\u0010>\u001a\u00020?2\n\b\u0002\u0010,\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010.\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010@Je\u0010A\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010B2\u0006\u0010'\u001a\u00028\u00002\u000e\b\u0002\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000D2\b\b\u0002\u0010E\u001a\u00028\u00002'\b\u0002\u0010F\u001a!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00020?\u0018\u00010G¢\u0006\u0002\bHH\u0086@¢\u0006\u0002\u0010IJY\u0010J\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010B2\u0006\u0010E\u001a\u00028\u00002\f\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000K2'\b\u0002\u0010F\u001a!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00020?\u0018\u00010G¢\u0006\u0002\bHH\u0086@¢\u0006\u0002\u0010LJ]\u0010M\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010B2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010O2\u0006\u0010E\u001a\u00028\u00002%\u0010F\u001a!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\u0012\u0004\u0012\u00020?\u0018\u00010G¢\u0006\u0002\bHH\u0082@¢\u0006\u0002\u0010PJ\u0015\u0010Q\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010RJ\b\u0010S\u001a\u00020?H\u0002J\u0016\u0010T\u001a\u00020?2\u0006\u0010'\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010UJ\u000e\u0010V\u001a\u00020?H\u0086@¢\u0006\u0002\u0010WJ\f\u0010X\u001a\b\u0012\u0004\u0012\u00028\u00000YR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\b\u001a\u0004\u0018\u00018\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00028\u00018F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0019R+\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R+\u0010'\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010&\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010*R$\u0010,\u001a\u0004\u0018\u00018\u00002\b\u0010\u0017\u001a\u0004\u0018\u00018\u0000@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b-\u0010\u0019R$\u0010.\u001a\u0004\u0018\u00018\u00002\b\u0010\u0017\u001a\u0004\u0018\u00018\u0000@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b/\u0010\u0019R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00028\u000003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0016\u00106\u001a\u00028\u0001X\u0082\u0004¢\u0006\n\n\u0002\u00109\u0012\u0004\b7\u00108R\u0016\u0010:\u001a\u00028\u0001X\u0082\u0004¢\u0006\n\n\u0002\u00109\u0012\u0004\b;\u00108R\u0010\u0010<\u001a\u00028\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u00109R\u0010\u0010=\u001a\u00028\u0001X\u0082\u000e¢\u0006\u0004\n\u0002\u00109¨\u0006Z"}, d2 = {"Landroidx/compose/animation/core/Animatable;", ExifInterface.GPS_DIRECTION_TRUE, "V", "Landroidx/compose/animation/core/AnimationVector;", "", "initialValue", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "visibilityThreshold", "label", "", "<init>", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/String;)V", "(Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;)V", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "Ljava/lang/Object;", "getLabel", "()Ljava/lang/String;", "internalState", "Landroidx/compose/animation/core/AnimationState;", "getInternalState$animation_core", "()Landroidx/compose/animation/core/AnimationState;", "value", "getValue", "()Ljava/lang/Object;", "velocityVector", "getVelocityVector", "()Landroidx/compose/animation/core/AnimationVector;", "velocity", "getVelocity", "<set-?>", "", "isRunning", "()Z", "setRunning", "(Z)V", "isRunning$delegate", "Landroidx/compose/runtime/MutableState;", "targetValue", "getTargetValue", "setTargetValue", "(Ljava/lang/Object;)V", "targetValue$delegate", "lowerBound", "getLowerBound", "upperBound", "getUpperBound", "mutatorMutex", "Landroidx/compose/animation/core/MutatorMutex;", "defaultSpringSpec", "Landroidx/compose/animation/core/SpringSpec;", "getDefaultSpringSpec$animation_core", "()Landroidx/compose/animation/core/SpringSpec;", "negativeInfinityBounds", "getNegativeInfinityBounds$annotations", "()V", "Landroidx/compose/animation/core/AnimationVector;", "positiveInfinityBounds", "getPositiveInfinityBounds$annotations", "lowerBoundVector", "upperBoundVector", "updateBounds", "", "(Ljava/lang/Object;Ljava/lang/Object;)V", "animateTo", "Landroidx/compose/animation/core/AnimationResult;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "initialVelocity", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateDecay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Ljava/lang/Object;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runAnimation", GXTemplateKey.GAIAX_ANIMATION, "Landroidx/compose/animation/core/Animation;", "(Landroidx/compose/animation/core/Animation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clampToBounds", "(Ljava/lang/Object;)Ljava/lang/Object;", "endAnimation", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asState", "Landroidx/compose/runtime/State;", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Animatable<T, V extends AnimationVector> {
    public static final int $stable = 8;
    private final SpringSpec<T> defaultSpringSpec;
    private final AnimationState<T, V> internalState;
    private final MutableState isRunning$delegate;
    private final String label;
    private T lowerBound;
    private V lowerBoundVector;
    private final MutatorMutex mutatorMutex;
    private final V negativeInfinityBounds;
    private final V positiveInfinityBounds;
    private final MutableState targetValue$delegate;
    private final TwoWayConverter<T, V> typeConverter;
    private T upperBound;
    private V upperBoundVector;
    private final T visibilityThreshold;

    /* JADX INFO: renamed from: androidx.compose.animation.core.Animatable$runAnimation$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/AnimationResult;", ExifInterface.GPS_DIRECTION_TRUE, "V", "Landroidx/compose/animation/core/AnimationVector;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.Animatable$runAnimation$2", f = "Animatable.kt", i = {0, 0}, l = {308}, m = "invokeSuspend", n = {"endState", "clampingNeeded"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super AnimationResult<T, V>>, Object> {
        final /* synthetic */ Animation<T, V> $animation;
        final /* synthetic */ Function1<Animatable<T, V>, Unit> $block;
        final /* synthetic */ T $initialVelocity;
        final /* synthetic */ long $startTime;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ Animatable<T, V> this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Animatable<T, V> r100, T r101, Animation<T, V> r102, long r103, Function1<? super Animatable<T, V>, Unit> r104, Continuation<? super AnonymousClass2> r105) {
            this.this$0 = r100;
            this.$initialVelocity = r101;
            this.$animation = r102;
            this.$startTime = r103;
            this.$block = r104;
            super(1, r105);
        }

        public static /* synthetic */ Unit a(Animatable r100, AnimationState r101, Function1 r102, Ref.BooleanRef r103, AnimationScope r104) {
            return invokeSuspend$lambda$0(r100, r101, r102, r103, r104);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r110) {
            return new AnonymousClass2(this.this$0, this.$initialVelocity, this.$animation, this.$startTime, this.$block, r110);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object r100) {
            return invoke((Continuation) r100);
        }

        public final Object invoke(Continuation<? super AnimationResult<T, V>> r100) {
            return ((AnonymousClass2) create(r100)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L10;
            if (r101 != 1) goto L9;
            Ref.BooleanRef r102 = (Ref.BooleanRef) this.L$1;
            AnimationState r103 = (AnimationState) this.L$0;
            ResultKt.throwOnFailure(r110);     // Catch: CancellationException -> L21
        L16:
            if (r102.element == false) goto L18;
            AnimationEndReason r104 = AnimationEndReason.BoundReached;     // Catch: CancellationException -> L21
        L19:
            Animatable.access$endAnimation(this.this$0);     // Catch: CancellationException -> L21
            return new AnimationResult(r103, r104);
        L18:
            r104 = AnimationEndReason.Finished;     // Catch: CancellationException -> L21
            goto L19
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r110);
            this.this$0.getInternalState$animation_core().setVelocityVector$animation_core(this.this$0.getTypeConverter().getConvertToVector().invoke(this.$initialVelocity));     // Catch: CancellationException -> L21
            Animatable.access$setTargetValue(this.this$0, this.$animation.getTargetValue());     // Catch: CancellationException -> L21
            Animatable.access$setRunning(this.this$0, true);     // Catch: CancellationException -> L21
            final AnimationState r105 = AnimationStateKt.copy$default(this.this$0.getInternalState$animation_core(), null, null, 0, Long.MIN_VALUE, false, 23, null);     // Catch: CancellationException -> L21
            final Ref.BooleanRef r106 = new Ref.BooleanRef();     // Catch: CancellationException -> L21
            Animation<T, V> r107 = this.$animation;     // Catch: CancellationException -> L21
            long r108 = this.$startTime;     // Catch: CancellationException -> L21
            final Animatable<T, V> r109 = this.this$0;     // Catch: CancellationException -> L21
            final Function1<Animatable<T, V>, Unit> r111 = this.$block;     // Catch: CancellationException -> L21
            Function1 r112 = new a(r109, r105, r111, r106);     // Catch: CancellationException -> L21
            this.L$0 = r105;     // Catch: CancellationException -> L21
            this.L$1 = r106;     // Catch: CancellationException -> L21
            this.label = 1;     // Catch: CancellationException -> L21
            if (SuspendAnimationKt.animate(r105, r107, r108, r112, this) != r100) goto L14;
            return r100;
        L14:
            r103 = r105;
            r102 = r106;
        L21:
            e = move-exception;
            Animatable.access$endAnimation(this.this$0);
            throw e;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static final Unit invokeSuspend$lambda$0(Animatable r100, AnimationState r101, Function1 r102, Ref.BooleanRef r103, AnimationScope r104) {
            SuspendAnimationKt.updateState(r104, r100.getInternalState$animation_core());
            Object r105 = Animatable.access$clampToBounds(r100, r104.getValue());
            if (Intrinsics.areEqual(r105, r104.getValue()) == true) goto L8;
            r100.getInternalState$animation_core().setValue$animation_core(r105);
            r101.setValue$animation_core(r105);
            if (r102 == null) goto L7;
            r102.invoke(r100);
        L7:
            r104.cancelAnimation();
            r103.element = true;
        L11:
            return Unit.INSTANCE;
        L8:
            if (r102 == null) goto L11;
            r102.invoke(r100);
            goto L11
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.Animatable$snapTo$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.Animatable$snapTo$2", f = "Animatable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C85422 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ T $targetValue;
        int label;
        final /* synthetic */ Animatable<T, V> this$0;

        public C85422(Animatable<T, V> r100, T r101, Continuation<? super C85422> r102) {
            this.this$0 = r100;
            this.$targetValue = r101;
            super(1, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new C85422(this.this$0, this.$targetValue, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r100) {
            return ((C85422) create(r100)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            Animatable.access$endAnimation(this.this$0);
            Object r101 = Animatable.access$clampToBounds(this.this$0, this.$targetValue);
            this.this$0.getInternalState$animation_core().setValue$animation_core(r101);
            Animatable.access$setTargetValue(this.this$0, r101);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.core.Animatable$stop$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.animation.core.Animatable$stop$2", f = "Animatable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C85432 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ Animatable<T, V> this$0;

        public C85432(Animatable<T, V> r100, Continuation<? super C85432> r101) {
            this.this$0 = r100;
            super(1, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new C85432(this.this$0, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r100) {
            return ((C85432) create(r100)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            Animatable.access$endAnimation(this.this$0);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private static /* synthetic */ void getNegativeInfinityBounds$annotations() {
    }

    private static /* synthetic */ void getPositiveInfinityBounds$annotations() {
    }

    private final void endAnimation() {
        AnimationState<T, V> r100 = this.internalState;
        r100.getVelocityVector().reset$animation_core();
        r100.setLastFrameTimeNanos$animation_core(Long.MIN_VALUE);
        setRunning(false);
    }

    public final T getTargetValue() {
        return this.targetValue$delegate.getValue();
    }

    public final T getValue() {
        return this.internalState.getValue();
    }

    public final T getVelocity() {
        return (T) this.typeConverter.getConvertFromVector().invoke(getVelocityVector());
    }

    public final V getVelocityVector() {
        return (V) this.internalState.getVelocityVector();
    }

    public final boolean isRunning() {
        return ((Boolean) this.isRunning$delegate.getValue()).booleanValue();
    }

    public final State<T> asState() {
        return this.internalState;
    }

    public final SpringSpec<T> getDefaultSpringSpec$animation_core() {
        return this.defaultSpringSpec;
    }

    public final AnimationState<T, V> getInternalState$animation_core() {
        return this.internalState;
    }

    public final String getLabel() {
        return this.label;
    }

    public final T getLowerBound() {
        return this.lowerBound;
    }

    public final TwoWayConverter<T, V> getTypeConverter() {
        return this.typeConverter;
    }

    public final T getUpperBound() {
        return this.upperBound;
    }

    public static final /* synthetic */ void access$endAnimation(Animatable r100) {
        r100.endAnimation();
    }

    private final T clampToBounds(T r100) {
        if (Intrinsics.areEqual(this.lowerBoundVector, this.negativeInfinityBounds) == true) goto L5;
    L7:
        V r101 = this.typeConverter.getConvertToVector().invoke(r100);
        int r102 = r101.getSize$animation_core();
        int r103 = 0;
        boolean r104 = false;
    L8:
        if (r103 >= r102) goto L15;
        if (r101.get$animation_core(r103) >= this.lowerBoundVector.get$animation_core(r103)) goto L12;
    L13:
        r101.set$animation_core(r103, RangesKt.coerceIn(r101.get$animation_core(r103), this.lowerBoundVector.get$animation_core(r103), this.upperBoundVector.get$animation_core(r103)));
        r104 = true;
    L14:
        r103 = r103 + 1;
        goto L8
    L12:
        if (r101.get$animation_core(r103) <= this.upperBoundVector.get$animation_core(r103)) goto L14;
    L15:
        if (r104 == true) goto L17;
        return r100;
    L17:
        return this.typeConverter.getConvertFromVector().invoke(r101);
    L5:
        if (Intrinsics.areEqual(this.upperBoundVector, this.positiveInfinityBounds) == false) goto L7;
        return r100;
    }

    private final void setRunning(boolean r100) {
        this.isRunning$delegate.setValue(Boolean.valueOf(r100));
    }

    private final void setTargetValue(T r100) {
        this.targetValue$delegate.setValue(r100);
    }

    public final Object stop(Continuation<? super Unit> r100) {
        Object r101 = MutatorMutex.mutate$default(this.mutatorMutex, null, new C85432(this, null), r100, 1, null);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$clampToBounds(Animatable r100, Object r101) {
        return r100.clampToBounds(r101);
    }

    public static final /* synthetic */ void access$setRunning(Animatable r100, boolean r101) {
        r100.setRunning(r101);
    }

    public static final /* synthetic */ void access$setTargetValue(Animatable r100, Object r101) {
        r100.setTargetValue(r101);
    }

    public final Object snapTo(T r100, Continuation<? super Unit> r101) {
        Object r102 = MutatorMutex.mutate$default(this.mutatorMutex, null, new C85422(this, r100, null), r101, 1, null);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public final void updateBounds(T r100, T r101) {
        if (r100 == null) goto L5;
        V r102 = this.typeConverter.getConvertToVector().invoke(r100);
        if (r102 == null) goto L5;
    L6:
        if (r101 == null) goto L9;
        V r103 = this.typeConverter.getConvertToVector().invoke(r101);
        if (r103 == null) goto L9;
    L10:
        int r104 = r102.getSize$animation_core();
        int r105 = 0;
    L11:
        if (r105 >= r104) goto L19;
        if (r102.get$animation_core(r105) > r103.get$animation_core(r105)) goto L15;
        boolean r106 = true;
    L16:
        if (r106 == true) goto L18;
        PreconditionsKt.throwIllegalStateException("Lower bound must be no greater than upper bound on *all* dimensions. The provided lower bound: " + r102 + " is greater than upper bound " + r103 + " on index " + r105);
    L18:
        r105 = r105 + 1;
        goto L11
    L15:
        r106 = false;
        goto L16
    L19:
        this.lowerBoundVector = r102;
        this.upperBoundVector = r103;
        this.upperBound = r101;
        this.lowerBound = r100;
        if (isRunning() == true) goto L28;
        T r107 = clampToBounds(getValue());
        if (Intrinsics.areEqual(r107, getValue()) == true) goto L29;
        this.internalState.setValue$animation_core(r107);
        return;
    L29:
        return;
    L28:
        return;
    L9:
        r103 = this.positiveInfinityBounds;
    L5:
        r102 = this.negativeInfinityBounds;
        goto L6
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility", replaceWith = @ReplaceWith(expression = "Animatable(initialValue, typeConverter, visibilityThreshold, \"Animatable\")", imports = {}))
    public /* synthetic */ Animatable(Object r100, TwoWayConverter r101, Object r102) {
        this(r100, r101, r102, "Animatable");
    }

    public Animatable(T r110, TwoWayConverter<T, V> r111, T r112, String r113) {
        this.typeConverter = r111;
        this.visibilityThreshold = r112;
        this.label = r113;
        this.internalState = new AnimationState(r111, r110, null, 0, 0, false, 60, null);
        this.isRunning$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.targetValue$delegate = SnapshotStateKt.mutableStateOf$default(r110, null, 2, null);
        this.mutatorMutex = new MutatorMutex();
        this.defaultSpringSpec = new SpringSpec(0.0f, 0.0f, r112, 3, null);
        AnimationVector r114 = getVelocityVector();
        if ((r114 instanceof AnimationVector1D) == false) goto L6;
        V r115 = AnimatableKt.access$getNegativeInfinityBounds1D$p();
    L12:
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type V of androidx.compose.animation.core.Animatable");
        this.negativeInfinityBounds = r115;
        AnimationVector r116 = getVelocityVector();
        if ((r116 instanceof AnimationVector1D) == false) goto L16;
        V r117 = AnimatableKt.access$getPositiveInfinityBounds1D$p();
    L22:
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type V of androidx.compose.animation.core.Animatable");
        this.positiveInfinityBounds = r117;
        this.lowerBoundVector = r115;
        this.upperBoundVector = r117;
        return;
    L16:
        if ((r116 instanceof AnimationVector2D) == false) goto L19;
        r117 = AnimatableKt.access$getPositiveInfinityBounds2D$p();
        goto L22
    L19:
        if ((r116 instanceof AnimationVector3D) == false) goto L21;
        r117 = AnimatableKt.access$getPositiveInfinityBounds3D$p();
        goto L22
    L21:
        r117 = AnimatableKt.access$getPositiveInfinityBounds4D$p();
        goto L22
    L6:
        if ((r114 instanceof AnimationVector2D) == false) goto L9;
        r115 = AnimatableKt.access$getNegativeInfinityBounds2D$p();
        goto L12
    L9:
        if ((r114 instanceof AnimationVector3D) == false) goto L11;
        r115 = AnimatableKt.access$getNegativeInfinityBounds3D$p();
        goto L12
    L11:
        r115 = AnimatableKt.access$getNegativeInfinityBounds4D$p();
        goto L12
    }

    private final Object runAnimation(Animation<T, V> r110, T r111, Function1<? super Animatable<T, V>, Unit> r112, Continuation<? super AnimationResult<T, V>> r113) {
        long r100 = this.internalState.getLastFrameTimeNanos();
        return MutatorMutex.mutate$default(this.mutatorMutex, null, new AnonymousClass2(this, r111, r110, r100, r112, null), r113, 1, null);
    }

    public final Object animateDecay(T r100, DecayAnimationSpec<T> r101, Function1<? super Animatable<T, V>, Unit> r102, Continuation<? super AnimationResult<T, V>> r103) {
        T r104 = getValue();
        V r105 = this.typeConverter.getConvertToVector().invoke(r100);
        return runAnimation(new DecayAnimation(r101, this.typeConverter, r104, r105), r100, r102, r103);
    }

    public /* synthetic */ Animatable(Object r100, TwoWayConverter r101, Object r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }

    public static final /* synthetic */ Object access$runAnimation(Animatable r100, Animation r101, Object r102, Function1 r103, Continuation r104) {
        return r100.runAnimation(r101, r102, r103, r104);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateBounds$default(Animatable r100, Object r101, Object r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.lowerBound;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = r100.upperBound;
    L8:
        r100.updateBounds(r101, r102);
    }

    public final Object animateTo(T r100, AnimationSpec<T> r101, T r102, Function1<? super Animatable<T, V>, Unit> r103, Continuation<? super AnimationResult<T, V>> r104) {
        T r105 = getValue();
        return runAnimation(AnimationKt.TargetBasedAnimation(r101, this.typeConverter, r105, r100, r102), r102, r103, r104);
    }

    public /* synthetic */ Animatable(Object r100, TwoWayConverter r101, Object r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = "Animatable";
    L8:
        this(r100, r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateDecay$default(Animatable r100, Object r101, DecayAnimationSpec r102, Function1 r103, Continuation r104, int r105, Object r106) {
        if ((r105 & 4) == 0) goto L6;
        r103 = null;
    L6:
        return r100.animateDecay(r101, r102, r103, r104);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTo$default(Animatable r100, Object r101, AnimationSpec r102, Object r103, Function1 r110, Continuation r111, int r112, Object r113) {
        if ((r112 & 2) == 0) goto L5;
        r102 = r100.defaultSpringSpec;
    L5:
        AnimationSpec r104 = r102;
        if ((r112 & 4) == 0) goto L8;
        r103 = r100.getVelocity();
    L8:
        Object r105 = r103;
        if ((r112 & 8) == 0) goto L12;
        r110 = null;
    L12:
        return r100.animateTo(r101, r104, r105, r110, r111);
    }
}
