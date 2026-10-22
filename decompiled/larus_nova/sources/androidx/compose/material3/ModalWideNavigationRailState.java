package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.material3.internal.AnchoredDragScope;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.material3.internal.DraggableAnchors;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001d\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u001fJ\u0018\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u0007H\u0080@¢\u0006\u0004\b\"\u0010#J0\u0010'\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010!\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010(R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0011\u0010$\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006)"}, d2 = {"Landroidx/compose/material3/ModalWideNavigationRailState;", "Landroidx/compose/material3/WideNavigationRailState;", "state", "density", "Landroidx/compose/ui/unit/Density;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(Landroidx/compose/material3/WideNavigationRailState;Landroidx/compose/ui/unit/Density;Landroidx/compose/animation/core/AnimationSpec;)V", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "anchoredDraggableState", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "Landroidx/compose/material3/WideNavigationRailValue;", "getAnchoredDraggableState$material3", "()Landroidx/compose/material3/internal/AnchoredDraggableState;", "currentValue", "getCurrentValue", "()Landroidx/compose/material3/WideNavigationRailValue;", "targetValue", "getTargetValue", "isAnimating", "", "()Z", BitableAnalytic.LinkSceneClickType.EXPAND, "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collapse", "toggle", "snapTo", "(Landroidx/compose/material3/WideNavigationRailValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "settle", "velocity", "settle$material3", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentOffset", "getCurrentOffset", "()F", "animateTo", "(Landroidx/compose/material3/WideNavigationRailValue;Landroidx/compose/animation/core/AnimationSpec;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ModalWideNavigationRailState implements WideNavigationRailState {
    public static final int $stable = 8;
    private final /* synthetic */ WideNavigationRailState $$delegate_0;
    private final AnchoredDraggableState<WideNavigationRailValue> anchoredDraggableState;
    private final AnimationSpec<Float> animationSpec;

    /* JADX INFO: renamed from: androidx.compose.material3.ModalWideNavigationRailState$animateTo$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/material3/internal/AnchoredDragScope;", "anchors", "Landroidx/compose/material3/internal/DraggableAnchors;", "Landroidx/compose/material3/WideNavigationRailValue;", "latestTarget"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.ModalWideNavigationRailState$animateTo$2", f = "WideNavigationRailState.kt", i = {}, l = {240}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<WideNavigationRailValue>, WideNavigationRailValue, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;
        final /* synthetic */ ModalWideNavigationRailState this$0;

        public AnonymousClass2(ModalWideNavigationRailState r100, float r101, AnimationSpec<Float> r102, Continuation<? super AnonymousClass2> r103) {
            this.this$0 = r100;
            this.$velocity = r101;
            this.$animationSpec = r102;
            super(4, r103);
        }

        public static /* synthetic */ Unit a(AnchoredDragScope r100, Ref.FloatRef r101, float r102, float r103) {
            return invokeSuspend$lambda$0(r100, r101, r102, r103);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(AnchoredDragScope r100, DraggableAnchors<WideNavigationRailValue> r101, WideNavigationRailValue r102, Continuation<? super Unit> r103) {
            AnonymousClass2 r104 = new AnonymousClass2(this.this$0, this.$velocity, this.$animationSpec, r103);
            r104.L$0 = r100;
            r104.L$1 = r101;
            r104.L$2 = r102;
            return r104.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(AnchoredDragScope r100, DraggableAnchors<WideNavigationRailValue> r101, WideNavigationRailValue r102, Continuation<? super Unit> r103) {
            return invoke2(r100, r101, r102, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
        L18:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            final AnchoredDragScope r111 = (AnchoredDragScope) this.L$0;
            float r102 = ((DraggableAnchors) this.L$1).positionOf((WideNavigationRailValue) this.L$2);
            if (Float.isNaN(r102) == true) goto L18;
            final Ref.FloatRef r103 = new Ref.FloatRef();
            if (Float.isNaN(this.this$0.getCurrentOffset()) == false) goto L13;
            float r104 = 0.0f;
        L14:
            r103.element = r104;
            float r105 = this.$velocity;
            AnimationSpec<Float> r106 = this.$animationSpec;
            Function2 r107 = new mf(r111, r103);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 1;
            if (SuspendAnimationKt.animate(r104, r102, r105, r106, r107, this) != r100) goto L18;
            return r100;
        L13:
            r104 = this.this$0.getCurrentOffset();
            goto L14
        }

        private static final Unit invokeSuspend$lambda$0(AnchoredDragScope r100, Ref.FloatRef r101, float r102, float r103) {
            r100.dragTo(r102, r103);
            r101.element = r102;
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ float a(float r100) {
        return anchoredDraggableState$lambda$0(r100);
    }

    private static final float anchoredDraggableState$lambda$0(float r100) {
        return r100 * 0.5f;
    }

    public static /* synthetic */ AnimationSpec b(ModalWideNavigationRailState r100) {
        return anchoredDraggableState$lambda$3(r100);
    }

    public static /* synthetic */ float c(Density r100) {
        return anchoredDraggableState$lambda$2(r100);
    }

    public final float getCurrentOffset() {
        return this.anchoredDraggableState.getOffset();
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public WideNavigationRailValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public WideNavigationRailValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public boolean isAnimating() {
        return this.anchoredDraggableState.isAnimationRunning();
    }

    public final AnchoredDraggableState<WideNavigationRailValue> getAnchoredDraggableState$material3() {
        return this.anchoredDraggableState;
    }

    public final AnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    private static final float anchoredDraggableState$lambda$2(Density r100) {
        return r100.mo371toPx0680j_4(Dp.m7544constructorimpl(400));
    }

    private static final AnimationSpec anchoredDraggableState$lambda$3(ModalWideNavigationRailState r100) {
        return r100.animationSpec;
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public Object collapse(Continuation<? super Unit> r100) {
        Object r101 = animateTo$default(this, WideNavigationRailValue.Collapsed, null, 0.0f, r100, 6, null);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public Object expand(Continuation<? super Unit> r100) {
        Object r101 = animateTo$default(this, WideNavigationRailValue.Expanded, null, 0.0f, r100, 6, null);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public Object toggle(Continuation<? super Unit> r100) {
        Object r101 = animateTo$default(this, WideNavigationRailStateKt.not(getTargetValue()), null, 0.0f, r100, 6, null);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    public final Object settle$material3(float r100, Continuation<? super Unit> r101) {
        Object r102 = this.anchoredDraggableState.settle(r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public Object snapTo(WideNavigationRailValue r100, Continuation<? super Unit> r101) {
        Object r102 = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public ModalWideNavigationRailState(WideNavigationRailState r100, final Density r110, AnimationSpec<Float> r111) {
        this.$$delegate_0 = r100;
        this.animationSpec = r111;
        this.anchoredDraggableState = new AnchoredDraggableState(r100.getTargetValue(), new jf(), new kf(r110), new lf(this), null, 16, null);
    }

    private final Object animateTo(WideNavigationRailValue r100, AnimationSpec<Float> r101, float r110, Continuation<? super Unit> r111) {
        Object r102 = AnchoredDraggableState.anchoredDrag$default(this.anchoredDraggableState, r100, null, new AnonymousClass2(this, r110, r101, null), r111, 2, null);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$animateTo(ModalWideNavigationRailState r100, WideNavigationRailValue r101, AnimationSpec r102, float r103, Continuation r104) {
        return r100.animateTo(r101, r102, r103, r104);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTo$default(ModalWideNavigationRailState r100, WideNavigationRailValue r101, AnimationSpec r102, float r103, Continuation r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = r100.animationSpec;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = r100.anchoredDraggableState.getLastVelocity();
    L9:
        return r100.animateTo(r101, r102, r103, r104);
    }
}
