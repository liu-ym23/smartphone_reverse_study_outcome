package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationResult;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.IntOffset;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0001\u0018\u0000 N2\u00020\u0001:\u0001NB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010B\u001a\u00020\bJ\u001d\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\u00132\u0006\u0010H\u001a\u00020\u001a¢\u0006\u0004\bI\u0010JJ\u0006\u0010K\u001a\u00020\bJ\u0006\u0010L\u001a\u00020\bJ\u0006\u0010M\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R\u001e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR+\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\u001e\u0010\u001c\"\u0004\b\u001f\u0010 R+\u0010#\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\"\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010 R+\u0010&\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010\"\u001a\u0004\b&\u0010\u001c\"\u0004\b'\u0010 R+\u0010)\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\"\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010 R\u001c\u0010,\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00102\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b3\u0010.\"\u0004\b4\u00100R\"\u00106\u001a\u0004\u0018\u0001052\b\u0010\u0019\u001a\u0004\u0018\u000105@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001a\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020;0:X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020=0:X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010>\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00138F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bA\u0010\"\u001a\u0004\b?\u0010.\"\u0004\b@\u00100R\u001c\u0010C\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\bD\u0010.\"\u0004\bE\u00100¨\u0006O"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation;", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "onLayerPropertyChanged", "Lkotlin/Function0;", "", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/functions/Function0;)V", "fadeInSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "getFadeInSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setFadeInSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "placementSpec", "Landroidx/compose/ui/unit/IntOffset;", "getPlacementSpec", "setPlacementSpec", "fadeOutSpec", "getFadeOutSpec", "setFadeOutSpec", "value", "", "isRunningMovingAwayAnimation", "()Z", "<set-?>", "isPlacementAnimationInProgress", "setPlacementAnimationInProgress", "(Z)V", "isPlacementAnimationInProgress$delegate", "Landroidx/compose/runtime/MutableState;", "isAppearanceAnimationInProgress", "setAppearanceAnimationInProgress", "isAppearanceAnimationInProgress$delegate", "isDisappearanceAnimationInProgress", "setDisappearanceAnimationInProgress", "isDisappearanceAnimationInProgress$delegate", "isDisappearanceAnimationFinished", "setDisappearanceAnimationFinished", "isDisappearanceAnimationFinished$delegate", "rawOffset", "getRawOffset-nOcc-ac", "()J", "setRawOffset--gyyYBs", "(J)V", "J", "finalOffset", "getFinalOffset-nOcc-ac", "setFinalOffset--gyyYBs", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", GXTemplateKey.GAIAX_LAYER, "getLayer", "()Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "placementDeltaAnimation", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector2D;", "visibilityAnimation", "Landroidx/compose/animation/core/AnimationVector1D;", "placementDelta", "getPlacementDelta-nOcc-ac", "setPlacementDelta--gyyYBs", "placementDelta$delegate", "cancelPlacementAnimation", "lookaheadOffset", "getLookaheadOffset-nOcc-ac", "setLookaheadOffset--gyyYBs", "animatePlacementDelta", "delta", "isMovingAway", "animatePlacementDelta-ar5cAso", "(JZ)V", "animateAppearance", "animateDisappearance", "release", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutItemAnimation {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final long NotInitialized = 0;
    private final CoroutineScope coroutineScope;
    private FiniteAnimationSpec<Float> fadeInSpec;
    private FiniteAnimationSpec<Float> fadeOutSpec;
    private long finalOffset;
    private final GraphicsContext graphicsContext;
    private final MutableState isAppearanceAnimationInProgress$delegate;
    private final MutableState isDisappearanceAnimationFinished$delegate;
    private final MutableState isDisappearanceAnimationInProgress$delegate;
    private final MutableState isPlacementAnimationInProgress$delegate;
    private boolean isRunningMovingAwayAnimation;
    private GraphicsLayer layer;
    private long lookaheadOffset;
    private final Function0<Unit> onLayerPropertyChanged;
    private final MutableState placementDelta$delegate;
    private final Animatable<IntOffset, AnimationVector2D> placementDeltaAnimation;
    private FiniteAnimationSpec<IntOffset> placementSpec;
    private long rawOffset;
    private final Animatable<Float, AnimationVector1D> visibilityAnimation;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimation$Companion;", "", "<init>", "()V", "NotInitialized", "Landroidx/compose/ui/unit/IntOffset;", "getNotInitialized-nOcc-ac", "()J", "J", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        /* JADX INFO: renamed from: getNotInitialized-nOcc-ac, reason: not valid java name */
        public final long m892getNotInitializednOccac() {
            return LazyLayoutItemAnimation.access$getNotInitialized$cp();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$1", f = "LazyLayoutItemAnimation.kt", i = {}, l = {171}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LazyLayoutItemAnimation this$0;

        public AnonymousClass1(LazyLayoutItemAnimation r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            Animatable r103 = LazyLayoutItemAnimation.access$getVisibilityAnimation$p(this.this$0);
            Float r104 = Boxing.boxFloat(1.0f);
            this.label = 1;
            if (r103.snapTo(r104, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2", f = "LazyLayoutItemAnimation.kt", i = {}, l = {183, 185}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GraphicsLayer $layer;
        final /* synthetic */ boolean $shouldResetValue;
        final /* synthetic */ FiniteAnimationSpec<Float> $spec;
        int label;
        final /* synthetic */ LazyLayoutItemAnimation this$0;

        public AnonymousClass2(boolean r100, LazyLayoutItemAnimation r101, FiniteAnimationSpec<Float> r102, GraphicsLayer r103, Continuation<? super AnonymousClass2> r104) {
            this.$shouldResetValue = r100;
            this.this$0 = r101;
            this.$spec = r102;
            this.$layer = r103;
            super(2, r104);
        }

        public static /* synthetic */ Unit a(GraphicsLayer r100, LazyLayoutItemAnimation r101, Animatable r102) {
            return invokeSuspend$lambda$0(r100, r101, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.$shouldResetValue, this.this$0, this.$spec, this.$layer, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L14;
            if (r101 == 1) goto L10;
            if (r101 != 2) goto L9;
            ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L12
        L23:
            AnimationResult r111 = (AnimationResult) r110;     // Catch: Throwable -> L12
            LazyLayoutItemAnimation.access$setAppearanceAnimationInProgress(this.this$0, false);
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L12
        L20:
            Animatable r102 = LazyLayoutItemAnimation.access$getVisibilityAnimation$p(this.this$0);     // Catch: Throwable -> L12
            Float r103 = Boxing.boxFloat(1.0f);     // Catch: Throwable -> L12
            FiniteAnimationSpec<Float> r104 = this.$spec;     // Catch: Throwable -> L12
            final GraphicsLayer r112 = this.$layer;     // Catch: Throwable -> L12
            final LazyLayoutItemAnimation r105 = this.this$0;     // Catch: Throwable -> L12
            Function1 r106 = new f(r112, r105);     // Catch: Throwable -> L12
            this.label = 2;     // Catch: Throwable -> L12
            r110 = Animatable.animateTo$default(r102, r103, r104, null, r106, this, 4, null);     // Catch: Throwable -> L12
            if (r110 != r100) goto L23;
            return r100;
        L14:
            ResultKt.throwOnFailure(r110);
            if (this.$shouldResetValue == false) goto L20;
            Animatable r113 = LazyLayoutItemAnimation.access$getVisibilityAnimation$p(this.this$0);     // Catch: Throwable -> L12
            Float r107 = Boxing.boxFloat(0.0f);     // Catch: Throwable -> L12
            this.label = 1;     // Catch: Throwable -> L12
            if (r113.snapTo(r107, this) != r100) goto L20;
            return r100;
        L12:
            th = move-exception;
            LazyLayoutItemAnimation.access$setAppearanceAnimationInProgress(this.this$0, false);
            throw th;
        }

        private static final Unit invokeSuspend$lambda$0(GraphicsLayer r100, LazyLayoutItemAnimation r101, Animatable r102) {
            r100.setAlpha(((Number) r102.getValue()).floatValue());
            LazyLayoutItemAnimation.access$getOnLayerPropertyChanged$p(r101).invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateDisappearance$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateDisappearance$1", f = "LazyLayoutItemAnimation.kt", i = {}, l = {204}, m = "invokeSuspend", n = {}, s = {})
    public static final class C86271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GraphicsLayer $layer;
        final /* synthetic */ FiniteAnimationSpec<Float> $spec;
        int label;
        final /* synthetic */ LazyLayoutItemAnimation this$0;

        public C86271(LazyLayoutItemAnimation r100, FiniteAnimationSpec<Float> r101, GraphicsLayer r102, Continuation<? super C86271> r103) {
            this.this$0 = r100;
            this.$spec = r101;
            this.$layer = r102;
            super(2, r103);
        }

        public static /* synthetic */ Unit a(GraphicsLayer r100, LazyLayoutItemAnimation r101, Animatable r102) {
            return invokeSuspend$lambda$0(r100, r101, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C86271(this.this$0, this.$spec, this.$layer, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C86271) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L11;
            if (r101 != 1) goto L10;
            ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L7
        L15:
            LazyLayoutItemAnimation.access$setDisappearanceAnimationFinished(this.this$0, true);     // Catch: Throwable -> L7
            LazyLayoutItemAnimation.access$setDisappearanceAnimationInProgress(this.this$0, false);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r110);
            Animatable r102 = LazyLayoutItemAnimation.access$getVisibilityAnimation$p(this.this$0);     // Catch: Throwable -> L7
            Float r103 = Boxing.boxFloat(0.0f);     // Catch: Throwable -> L7
            FiniteAnimationSpec<Float> r104 = this.$spec;     // Catch: Throwable -> L7
            final GraphicsLayer r111 = this.$layer;     // Catch: Throwable -> L7
            final LazyLayoutItemAnimation r105 = this.this$0;     // Catch: Throwable -> L7
            Function1 r106 = new g(r111, r105);     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            if (Animatable.animateTo$default(r102, r103, r104, null, r106, this, 4, null) != r100) goto L15;
            return r100;
        L7:
            th = move-exception;
            LazyLayoutItemAnimation.access$setDisappearanceAnimationInProgress(this.this$0, false);
            throw th;
        }

        private static final Unit invokeSuspend$lambda$0(GraphicsLayer r100, LazyLayoutItemAnimation r101, Animatable r102) {
            r100.setAlpha(((Number) r102.getValue()).floatValue());
            LazyLayoutItemAnimation.access$getOnLayerPropertyChanged$p(r101).invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$cancelPlacementAnimation$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$cancelPlacementAnimation$1", f = "LazyLayoutItemAnimation.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
    public static final class C86281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LazyLayoutItemAnimation this$0;

        public C86281(LazyLayoutItemAnimation r100, Continuation<? super C86281> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C86281(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C86281) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            LazyLayoutItemAnimation.m882access$setPlacementDeltagyyYBs(this.this$0, IntOffset.Companion.m7687getZeronOccac());
            LazyLayoutItemAnimation.access$setPlacementAnimationInProgress(this.this$0, false);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            Animatable r103 = LazyLayoutItemAnimation.access$getPlacementDeltaAnimation$p(this.this$0);
            IntOffset r104 = IntOffset.m7667boximpl(IntOffset.Companion.m7687getZeronOccac());
            this.label = 1;
            if (r103.snapTo(r104, this) != r101) goto L11;
            return r101;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$release$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$release$1", f = "LazyLayoutItemAnimation.kt", i = {}, l = {218}, m = "invokeSuspend", n = {}, s = {})
    public static final class C86291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LazyLayoutItemAnimation this$0;

        public C86291(LazyLayoutItemAnimation r100, Continuation<? super C86291> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C86291(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C86291) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            Animatable r103 = LazyLayoutItemAnimation.access$getPlacementDeltaAnimation$p(this.this$0);
            this.label = 1;
            if (r103.stop(this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$release$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$release$2", f = "LazyLayoutItemAnimation.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {})
    public static final class C86302 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LazyLayoutItemAnimation this$0;

        public C86302(LazyLayoutItemAnimation r100, Continuation<? super C86302> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C86302(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C86302) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            Animatable r103 = LazyLayoutItemAnimation.access$getVisibilityAnimation$p(this.this$0);
            this.label = 1;
            if (r103.stop(this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$release$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$release$3", f = "LazyLayoutItemAnimation.kt", i = {}, l = {226}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LazyLayoutItemAnimation this$0;

        public AnonymousClass3(LazyLayoutItemAnimation r100, Continuation<? super AnonymousClass3> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass3(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            Animatable r103 = LazyLayoutItemAnimation.access$getVisibilityAnimation$p(this.this$0);
            this.label = 1;
            if (r103.stop(this) != r101) goto L12;
            return r101;
        }
    }

    public static /* synthetic */ Unit a() {
        return _init_$lambda$0();
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        long r100 = Integer.MAX_VALUE;
        NotInitialized = IntOffset.m7670constructorimpl((r100 & BodyPartID.bodyIdMax) | (r100 << 32));
    }

    public final void animateAppearance() {
        GraphicsLayer r100 = this.layer;
        FiniteAnimationSpec<Float> r101 = this.fadeInSpec;
        if (isAppearanceAnimationInProgress() == true) goto L13;
        if (r101 == null) goto L13;
        if (r100 == null) goto L13;
        setAppearanceAnimationInProgress(true);
        boolean r102 = !isDisappearanceAnimationInProgress();
        if (r102 == false) goto L10;
        r100.setAlpha(0.0f);
    L10:
        BuildersKt.launch$default(this.coroutineScope, null, null, new AnonymousClass2(r102, this, r101, r100, null), 3, null);
        return;
    L13:
        if (isDisappearanceAnimationInProgress() == false) goto L18;
        if (r100 == null) goto L16;
        r100.setAlpha(1.0f);
    L16:
        BuildersKt.launch$default(this.coroutineScope, null, null, new AnonymousClass1(this, null), 3, null);
        return;
    }

    public final void animateDisappearance() {
        GraphicsLayer r100 = this.layer;
        FiniteAnimationSpec<Float> r101 = this.fadeOutSpec;
        if (r100 != null) goto L5;
        return;
    L5:
        if (isDisappearanceAnimationInProgress() == true) goto L11;
        if (r101 == null) goto L12;
        setDisappearanceAnimationInProgress(true);
        BuildersKt.launch$default(this.coroutineScope, null, null, new C86271(this, r101, r100, null), 3, null);
        return;
    L12:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getPlacementDelta-nOcc-ac, reason: not valid java name */
    public final long m887getPlacementDeltanOccac() {
        return ((IntOffset) this.placementDelta$delegate.getValue()).m7685unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isAppearanceAnimationInProgress() {
        return ((Boolean) this.isAppearanceAnimationInProgress$delegate.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isDisappearanceAnimationFinished() {
        return ((Boolean) this.isDisappearanceAnimationFinished$delegate.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isDisappearanceAnimationInProgress() {
        return ((Boolean) this.isDisappearanceAnimationInProgress$delegate.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isPlacementAnimationInProgress() {
        return ((Boolean) this.isPlacementAnimationInProgress$delegate.getValue()).booleanValue();
    }

    public final void cancelPlacementAnimation() {
        if (isPlacementAnimationInProgress() == false) goto L6;
        BuildersKt.launch$default(this.coroutineScope, null, null, new C86281(this, null), 3, null);
        return;
    }

    public final void release() {
        if (isPlacementAnimationInProgress() == false) goto L6;
        setPlacementAnimationInProgress(false);
        BuildersKt.launch$default(this.coroutineScope, null, null, new C86291(this, null), 3, null);
    L6:
        if (isAppearanceAnimationInProgress() == false) goto L9;
        setAppearanceAnimationInProgress(false);
        BuildersKt.launch$default(this.coroutineScope, null, null, new C86302(this, null), 3, null);
    L9:
        if (isDisappearanceAnimationInProgress() == false) goto L11;
        setDisappearanceAnimationInProgress(false);
        BuildersKt.launch$default(this.coroutineScope, null, null, new AnonymousClass3(this, null), 3, null);
    L11:
        this.isRunningMovingAwayAnimation = false;
        m883setPlacementDeltagyyYBs(IntOffset.Companion.m7687getZeronOccac());
        this.rawOffset = NotInitialized;
        GraphicsLayer r100 = this.layer;
        if (r100 == null) goto L16;
        GraphicsContext r101 = this.graphicsContext;
        if (r101 == null) goto L16;
        r101.releaseGraphicsLayer(r100);
    L16:
        this.layer = null;
        this.fadeInSpec = null;
        this.fadeOutSpec = null;
        this.placementSpec = null;
    }

    private static final Unit _init_$lambda$0() {
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ long access$getNotInitialized$cp() {
        return NotInitialized;
    }

    public final FiniteAnimationSpec<Float> getFadeInSpec() {
        return this.fadeInSpec;
    }

    public final FiniteAnimationSpec<Float> getFadeOutSpec() {
        return this.fadeOutSpec;
    }

    /* JADX INFO: renamed from: getFinalOffset-nOcc-ac, reason: not valid java name */
    public final long m885getFinalOffsetnOccac() {
        return this.finalOffset;
    }

    public final GraphicsLayer getLayer() {
        return this.layer;
    }

    /* JADX INFO: renamed from: getLookaheadOffset-nOcc-ac, reason: not valid java name */
    public final long m886getLookaheadOffsetnOccac() {
        return this.lookaheadOffset;
    }

    public final FiniteAnimationSpec<IntOffset> getPlacementSpec() {
        return this.placementSpec;
    }

    /* JADX INFO: renamed from: getRawOffset-nOcc-ac, reason: not valid java name */
    public final long m888getRawOffsetnOccac() {
        return this.rawOffset;
    }

    public final boolean isRunningMovingAwayAnimation() {
        return this.isRunningMovingAwayAnimation;
    }

    public static final /* synthetic */ Function0 access$getOnLayerPropertyChanged$p(LazyLayoutItemAnimation r100) {
        return r100.onLayerPropertyChanged;
    }

    public static final /* synthetic */ Animatable access$getPlacementDeltaAnimation$p(LazyLayoutItemAnimation r100) {
        return r100.placementDeltaAnimation;
    }

    public static final /* synthetic */ Animatable access$getVisibilityAnimation$p(LazyLayoutItemAnimation r100) {
        return r100.visibilityAnimation;
    }

    private final void setAppearanceAnimationInProgress(boolean r100) {
        this.isAppearanceAnimationInProgress$delegate.setValue(Boolean.valueOf(r100));
    }

    private final void setDisappearanceAnimationFinished(boolean r100) {
        this.isDisappearanceAnimationFinished$delegate.setValue(Boolean.valueOf(r100));
    }

    private final void setDisappearanceAnimationInProgress(boolean r100) {
        this.isDisappearanceAnimationInProgress$delegate.setValue(Boolean.valueOf(r100));
    }

    private final void setPlacementAnimationInProgress(boolean r100) {
        this.isPlacementAnimationInProgress$delegate.setValue(Boolean.valueOf(r100));
    }

    /* JADX INFO: renamed from: setPlacementDelta--gyyYBs, reason: not valid java name */
    private final void m883setPlacementDeltagyyYBs(long r100) {
        this.placementDelta$delegate.setValue(IntOffset.m7667boximpl(r100));
    }

    public final void setFadeInSpec(FiniteAnimationSpec<Float> r100) {
        this.fadeInSpec = r100;
    }

    public final void setFadeOutSpec(FiniteAnimationSpec<Float> r100) {
        this.fadeOutSpec = r100;
    }

    /* JADX INFO: renamed from: setFinalOffset--gyyYBs, reason: not valid java name */
    public final void m889setFinalOffsetgyyYBs(long r100) {
        this.finalOffset = r100;
    }

    /* JADX INFO: renamed from: setLookaheadOffset--gyyYBs, reason: not valid java name */
    public final void m890setLookaheadOffsetgyyYBs(long r100) {
        this.lookaheadOffset = r100;
    }

    public final void setPlacementSpec(FiniteAnimationSpec<IntOffset> r100) {
        this.placementSpec = r100;
    }

    /* JADX INFO: renamed from: setRawOffset--gyyYBs, reason: not valid java name */
    public final void m891setRawOffsetgyyYBs(long r100) {
        this.rawOffset = r100;
    }

    public static final /* synthetic */ void access$setAppearanceAnimationInProgress(LazyLayoutItemAnimation r100, boolean r101) {
        r100.setAppearanceAnimationInProgress(r101);
    }

    public static final /* synthetic */ void access$setDisappearanceAnimationFinished(LazyLayoutItemAnimation r100, boolean r101) {
        r100.setDisappearanceAnimationFinished(r101);
    }

    public static final /* synthetic */ void access$setDisappearanceAnimationInProgress(LazyLayoutItemAnimation r100, boolean r101) {
        r100.setDisappearanceAnimationInProgress(r101);
    }

    public static final /* synthetic */ void access$setPlacementAnimationInProgress(LazyLayoutItemAnimation r100, boolean r101) {
        r100.setPlacementAnimationInProgress(r101);
    }

    /* JADX INFO: renamed from: access$setPlacementDelta--gyyYBs, reason: not valid java name */
    public static final /* synthetic */ void m882access$setPlacementDeltagyyYBs(LazyLayoutItemAnimation r100, long r101) {
        r100.m883setPlacementDeltagyyYBs(r101);
    }

    public static final /* synthetic */ void access$setRunningMovingAwayAnimation$p(LazyLayoutItemAnimation r100, boolean r101) {
        r100.isRunningMovingAwayAnimation = r101;
    }

    /* JADX INFO: renamed from: animatePlacementDelta-ar5cAso, reason: not valid java name */
    public final void m884animatePlacementDeltaar5cAso(long r110, boolean r111) {
        FiniteAnimationSpec<IntOffset> r100 = this.placementSpec;
        if (r100 != null) goto L5;
        return;
    L5:
        long r101 = IntOffset.m7679minusqkQi6aY(m887getPlacementDeltanOccac(), r110);
        m883setPlacementDeltagyyYBs(r101);
        setPlacementAnimationInProgress(true);
        this.isRunningMovingAwayAnimation = r111;
        BuildersKt.launch$default(this.coroutineScope, null, null, new LazyLayoutItemAnimation$animatePlacementDelta$1(this, r100, r101, null), 3, null);
    }

    public LazyLayoutItemAnimation(CoroutineScope r210, GraphicsContext r211, Function0<Unit> r212) {
        this.coroutineScope = r210;
        this.graphicsContext = r211;
        this.onLayerPropertyChanged = r212;
        Boolean r100 = Boolean.FALSE;
        this.isPlacementAnimationInProgress$delegate = SnapshotStateKt.mutableStateOf$default(r100, null, 2, null);
        this.isAppearanceAnimationInProgress$delegate = SnapshotStateKt.mutableStateOf$default(r100, null, 2, null);
        this.isDisappearanceAnimationInProgress$delegate = SnapshotStateKt.mutableStateOf$default(r100, null, 2, null);
        this.isDisappearanceAnimationFinished$delegate = SnapshotStateKt.mutableStateOf$default(r100, null, 2, null);
        long r101 = NotInitialized;
        this.rawOffset = r101;
        IntOffset.Companion r102 = IntOffset.Companion;
        this.finalOffset = r102.m7687getZeronOccac();
        if (r211 == null) goto L5;
        GraphicsLayer r103 = r211.createGraphicsLayer();
    L6:
        this.layer = r103;
        this.placementDeltaAnimation = new Animatable(IntOffset.m7667boximpl(r102.m7687getZeronOccac()), VectorConvertersKt.getVectorConverter(r102), null, null, 12, null);
        this.visibilityAnimation = new Animatable(Float.valueOf(1.0f), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), null, null, 12, null);
        this.placementDelta$delegate = SnapshotStateKt.mutableStateOf$default(IntOffset.m7667boximpl(r102.m7687getZeronOccac()), null, 2, null);
        this.lookaheadOffset = r101;
        return;
    L5:
        r103 = null;
        goto L6
    }

    public /* synthetic */ LazyLayoutItemAnimation(CoroutineScope r100, GraphicsContext r101, Function0 r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = new e();
    L8:
        this(r100, r101, r102);
    }
}
