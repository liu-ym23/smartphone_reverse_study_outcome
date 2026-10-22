package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Density;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 L2\u00020\u0001:\u0001LBU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eBC\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u0011J\u0006\u0010\u001e\u001a\u00020\u0006J\u000e\u0010#\u001a\u00020$H\u0086@¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020$H\u0086@¢\u0006\u0002\u0010%J\u000e\u0010'\u001a\u00020$H\u0086@¢\u0006\u0002\u0010%J\u000e\u0010(\u001a\u00020$H\u0086@¢\u0006\u0002\u0010%J0\u0010)\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020\t2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060+2\b\b\u0002\u0010,\u001a\u00020\u0006H\u0080@¢\u0006\u0004\b-\u0010.J\u0018\u0010/\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020\tH\u0080@¢\u0006\u0004\b0\u00101J\u0018\u00102\u001a\u00020$2\u0006\u0010,\u001a\u00020\u0006H\u0080@¢\u0006\u0004\b3\u00104R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\f\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0017\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\u001d\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u001f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b \u0010\u0013R\u0011\u0010!\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0013R \u00105\u001a\b\u0012\u0004\u0012\u00020\u000606X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R \u0010;\u001a\b\u0012\u0004\u0012\u00020\t0<X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0014\u0010A\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR \u0010D\u001a\b\u0012\u0004\u0012\u00020\u00060+X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR \u0010I\u001a\b\u0012\u0004\u0012\u00020\u00060+X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010F\"\u0004\bK\u0010H¨\u0006M"}, d2 = {"Landroidx/compose/material3/SheetState;", "", "skipPartiallyExpanded", "", "positionalThreshold", "Lkotlin/Function0;", "", "velocityThreshold", "initialValue", "Landroidx/compose/material3/SheetValue;", "confirmValueChange", "Lkotlin/Function1;", "skipHiddenState", "<init>", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;Z)V", "density", "Landroidx/compose/ui/unit/Density;", "(ZLandroidx/compose/ui/unit/Density;Landroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;Z)V", "getSkipPartiallyExpanded$material3", "()Z", "getConfirmValueChange$material3", "()Lkotlin/jvm/functions/Function1;", "getSkipHiddenState$material3", "currentValue", "getCurrentValue", "()Landroidx/compose/material3/SheetValue;", "targetValue", "getTargetValue", "isVisible", "isAnimationRunning", "requireOffset", "hasExpandedState", "getHasExpandedState", "hasPartiallyExpandedState", "getHasPartiallyExpandedState", BitableAnalytic.LinkSceneClickType.EXPAND, "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "partialExpand", "show", "hide", "animateTo", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "velocity", "animateTo$material3", "(Landroidx/compose/material3/SheetValue;Landroidx/compose/animation/core/FiniteAnimationSpec;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "snapTo$material3", "(Landroidx/compose/material3/SheetValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "settle", "settle$material3", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anchoredDraggableMotionSpec", "Landroidx/compose/animation/core/AnimationSpec;", "getAnchoredDraggableMotionSpec$material3", "()Landroidx/compose/animation/core/AnimationSpec;", "setAnchoredDraggableMotionSpec$material3", "(Landroidx/compose/animation/core/AnimationSpec;)V", "anchoredDraggableState", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "getAnchoredDraggableState$material3", "()Landroidx/compose/material3/internal/AnchoredDraggableState;", "setAnchoredDraggableState$material3", "(Landroidx/compose/material3/internal/AnchoredDraggableState;)V", "offset", "getOffset$material3", "()F", "showMotionSpec", "getShowMotionSpec$material3", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setShowMotionSpec$material3", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "hideMotionSpec", "getHideMotionSpec$material3", "setHideMotionSpec$material3", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SheetState {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private AnimationSpec<Float> anchoredDraggableMotionSpec;
    private AnchoredDraggableState<SheetValue> anchoredDraggableState;
    private final Function1<SheetValue, Boolean> confirmValueChange;
    private FiniteAnimationSpec<Float> hideMotionSpec;
    private FiniteAnimationSpec<Float> showMotionSpec;
    private final boolean skipHiddenState;
    private final boolean skipPartiallyExpanded;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JR\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0010\u001a\u00020\tJ@\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\tH\u0007¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/SheetState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/SheetState;", "Landroidx/compose/material3/SheetValue;", "skipPartiallyExpanded", "", "positionalThreshold", "Lkotlin/Function0;", "", "velocityThreshold", "confirmValueChange", "Lkotlin/Function1;", "skipHiddenState", "density", "Landroidx/compose/ui/unit/Density;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ float a(Density r100) {
            return Saver$lambda$3(r100);
        }

        public static /* synthetic */ SheetState b(boolean r100, Function0 r101, Function0 r102, Function1 r103, boolean r104, SheetValue r105) {
            return Saver$lambda$1(r100, r101, r102, r103, r104, r105);
        }

        public static /* synthetic */ SheetValue c(SaverScope r100, SheetState r101) {
            return Saver$lambda$0(r100, r101);
        }

        public static /* synthetic */ float d(Density r100) {
            return Saver$lambda$5(r100);
        }

        private static final float Saver$lambda$3(Density r100) {
            return r100.mo371toPx0680j_4(BottomSheetDefaults.INSTANCE.m1888getPositionalThresholdD9Ej5fM$material3());
        }

        private static final float Saver$lambda$5(Density r100) {
            return r100.mo371toPx0680j_4(BottomSheetDefaults.INSTANCE.m1891getVelocityThresholdD9Ej5fM$material3());
        }

        private static final SheetValue Saver$lambda$0(SaverScope r100, SheetState r101) {
            return r101.getCurrentValue();
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility.")
        public final /* synthetic */ Saver Saver(boolean r100, Function1 r101, final Density r102, boolean r110) {
            return Saver(r100, new fo(r102), new go(r102), r101, r110);
        }

        public final Saver<SheetState, SheetValue> Saver(final boolean r100, final Function0<Float> r110, final Function0<Float> r111, final Function1<? super SheetValue, Boolean> r112, final boolean r113) {
            return SaverKt.Saver(new ho(), new io(r100, r110, r111, r112, r113));
        }

        private static final SheetState Saver$lambda$1(boolean r100, Function0 r101, Function0 r110, Function1 r111, boolean r112, SheetValue r113) {
            return new SheetState(r100, r101, r110, r113, r111, r112);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private static final boolean _init_$lambda$0(SheetValue r100) {
        return true;
    }

    private static final boolean _init_$lambda$7(SheetValue r100) {
        return true;
    }

    public static /* synthetic */ float a(Density r100) {
        return _init_$lambda$9(r100);
    }

    public static /* synthetic */ boolean b(SheetValue r100) {
        return _init_$lambda$0(r100);
    }

    public static /* synthetic */ AnimationSpec c(SheetState r100) {
        return anchoredDraggableState$lambda$6(r100);
    }

    public static /* synthetic */ float d(Density r100) {
        return _init_$lambda$11(r100);
    }

    public static /* synthetic */ boolean e(SheetValue r100) {
        return _init_$lambda$7(r100);
    }

    public static /* synthetic */ float f(Function0 r100, float r101) {
        return anchoredDraggableState$lambda$5(r100, r101);
    }

    public final SheetValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final boolean getHasExpandedState() {
        return this.anchoredDraggableState.getAnchors().hasAnchorFor(SheetValue.Expanded);
    }

    public final boolean getHasPartiallyExpandedState() {
        return this.anchoredDraggableState.getAnchors().hasAnchorFor(SheetValue.PartiallyExpanded);
    }

    public final float getOffset$material3() {
        return this.anchoredDraggableState.getOffset();
    }

    public final SheetValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final boolean isAnimationRunning() {
        return this.anchoredDraggableState.isAnimationRunning();
    }

    public final boolean isVisible() {
        if (this.anchoredDraggableState.getCurrentValue() == SheetValue.Hidden) goto L5;
        return true;
    L5:
        return false;
    }

    public final float requireOffset() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final AnimationSpec<Float> getAnchoredDraggableMotionSpec$material3() {
        return this.anchoredDraggableMotionSpec;
    }

    public final AnchoredDraggableState<SheetValue> getAnchoredDraggableState$material3() {
        return this.anchoredDraggableState;
    }

    public final Function1<SheetValue, Boolean> getConfirmValueChange$material3() {
        return this.confirmValueChange;
    }

    public final FiniteAnimationSpec<Float> getHideMotionSpec$material3() {
        return this.hideMotionSpec;
    }

    public final FiniteAnimationSpec<Float> getShowMotionSpec$material3() {
        return this.showMotionSpec;
    }

    public final boolean getSkipHiddenState$material3() {
        return this.skipHiddenState;
    }

    public final boolean getSkipPartiallyExpanded$material3() {
        return this.skipPartiallyExpanded;
    }

    private static final float _init_$lambda$11(Density r100) {
        return r100.mo371toPx0680j_4(BottomSheetDefaults.INSTANCE.m1891getVelocityThresholdD9Ej5fM$material3());
    }

    private static final float _init_$lambda$9(Density r100) {
        return r100.mo371toPx0680j_4(BottomSheetDefaults.INSTANCE.m1888getPositionalThresholdD9Ej5fM$material3());
    }

    private static final AnimationSpec anchoredDraggableState$lambda$6(SheetState r100) {
        return r100.anchoredDraggableMotionSpec;
    }

    public final Object expand(Continuation<? super Unit> r100) {
        Function1<SheetValue, Boolean> r101 = this.confirmValueChange;
        SheetValue r102 = SheetValue.Expanded;
        if (r101.invoke(r102).booleanValue() == false) goto L10;
        Object r103 = animateTo$material3$default(this, r102, this.showMotionSpec, 0.0f, r100, 4, null);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r103;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    public final Object hide(Continuation<? super Unit> r100) {
        if ((!this.skipHiddenState) == false) goto L14;
        Function1<SheetValue, Boolean> r101 = this.confirmValueChange;
        SheetValue r102 = SheetValue.Hidden;
        if (r101.invoke(r102).booleanValue() == false) goto L12;
        Object r103 = animateTo$material3$default(this, r102, this.hideMotionSpec, 0.0f, r100, 4, null);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r103;
    L10:
        return Unit.INSTANCE;
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("Attempted to animate to hidden when skipHiddenState was enabled. Set skipHiddenState to false to use this function.".toString());
    }

    public final Object partialExpand(Continuation<? super Unit> r100) {
        if ((!this.skipPartiallyExpanded) == false) goto L14;
        Function1<SheetValue, Boolean> r101 = this.confirmValueChange;
        SheetValue r102 = SheetValue.PartiallyExpanded;
        if (r101.invoke(r102).booleanValue() == false) goto L12;
        Object r103 = animateTo$material3$default(this, r102, this.hideMotionSpec, 0.0f, r100, 4, null);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r103;
    L10:
        return Unit.INSTANCE;
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("Attempted to animate to partial expanded when skipPartiallyExpanded was enabled. Set skipPartiallyExpanded to false to use this function.".toString());
    }

    public final void setAnchoredDraggableMotionSpec$material3(AnimationSpec<Float> r100) {
        this.anchoredDraggableMotionSpec = r100;
    }

    public final void setAnchoredDraggableState$material3(AnchoredDraggableState<SheetValue> r100) {
        this.anchoredDraggableState = r100;
    }

    public final void setHideMotionSpec$material3(FiniteAnimationSpec<Float> r100) {
        this.hideMotionSpec = r100;
    }

    public final void setShowMotionSpec$material3(FiniteAnimationSpec<Float> r100) {
        this.showMotionSpec = r100;
    }

    public final Object show(Continuation<? super Unit> r100) {
        if (getHasPartiallyExpandedState() == false) goto L5;
        SheetValue r101 = SheetValue.PartiallyExpanded;
    L6:
        SheetValue r102 = r101;
        if (this.confirmValueChange.invoke(r102).booleanValue() == false) goto L14;
        Object r103 = animateTo$material3$default(this, r102, this.showMotionSpec, 0.0f, r100, 4, null);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L12;
        return r103;
    L12:
        return Unit.INSTANCE;
    L14:
        return Unit.INSTANCE;
    L5:
        r101 = SheetValue.Expanded;
        goto L6
    }

    private static final float anchoredDraggableState$lambda$5(Function0 r100, float r101) {
        return ((Number) r100.invoke()).floatValue();
    }

    public final Object settle$material3(float r100, Continuation<? super Unit> r101) {
        Object r102 = this.anchoredDraggableState.settle(r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public final Object snapTo$material3(SheetValue r100, Continuation<? super Unit> r101) {
        Object r102 = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public final Object animateTo$material3(SheetValue r100, FiniteAnimationSpec<Float> r101, float r110, Continuation<? super Unit> r111) {
        Object r102 = AnchoredDraggableState.anchoredDrag$default(this.anchoredDraggableState, r100, null, new SheetState$animateTo$2(this, r110, r101, null), r111, 2, null);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility.")
    public /* synthetic */ SheetState(boolean r100, final Density r101, SheetValue r110, Function1 r111, boolean r112) {
        this(r100, new zn(r101), new ao(r101), r110, r111, r112);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SheetState(boolean r100, final Function0<Float> r110, Function0<Float> r111, SheetValue r112, Function1<? super SheetValue, Boolean> r113, boolean r114) {
        this.skipPartiallyExpanded = r100;
        this.confirmValueChange = r113;
        this.skipHiddenState = r114;
        if (r100 == true) goto L5;
    L12:
        if (r114 == true) goto L14;
    L21:
        this.anchoredDraggableMotionSpec = SheetDefaultsKt.access$getBottomSheetAnimationSpec$p();
        this.anchoredDraggableState = new AnchoredDraggableState(r112, new co(r110), r111, new Cdo(this), r113);
        this.showMotionSpec = AnimationSpecKt.snap$default(0, 1, null);
        this.hideMotionSpec = AnimationSpecKt.snap$default(0, 1, null);
        return;
    L14:
        if (r112 == SheetValue.Hidden) goto L16;
        boolean r101 = true;
    L17:
        if (r101 == true) goto L21;
        throw new IllegalArgumentException("The initial value must not be set to Hidden if skipHiddenState is set to true.".toString());
    L16:
        r101 = false;
        goto L17
    L5:
        if (r112 == SheetValue.PartiallyExpanded) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L12;
        throw new IllegalArgumentException("The initial value must not be set to PartiallyExpanded if skipPartiallyExpanded is set to true.".toString());
    L7:
        r102 = false;
        goto L8
    }

    public /* synthetic */ SheetState(boolean r100, Density r101, SheetValue r102, Function1 r110, boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 4) == 0) goto L5;
        r102 = SheetValue.Hidden;
    L5:
        SheetValue r103 = r102;
        if ((r112 & 8) == 0) goto L8;
        r110 = new eo();
    L8:
        Function1 r104 = r110;
        if ((r112 & 16) == 0) goto L11;
        boolean r105 = false;
    L12:
        this(r100, r101, r103, r104, r105);
        return;
    L11:
        r105 = r111;
        goto L12
    }

    public static /* synthetic */ Object animateTo$material3$default(SheetState r100, SheetValue r101, FiniteAnimationSpec r102, float r103, Continuation r104, int r105, Object r106) {
        if ((r105 & 4) == 0) goto L6;
        r103 = r100.anchoredDraggableState.getLastVelocity();
    L6:
        return r100.animateTo$material3(r101, r102, r103, r104);
    }

    public /* synthetic */ SheetState(boolean r100, Function0 r101, Function0 r110, SheetValue r111, Function1 r112, boolean r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 8) == 0) goto L5;
        r111 = SheetValue.Hidden;
    L5:
        SheetValue r102 = r111;
        if ((r114 & 16) == 0) goto L8;
        r112 = new bo();
    L8:
        Function1 r103 = r112;
        if ((r114 & 32) == 0) goto L11;
        boolean r104 = false;
    L12:
        this(r100, r101, r110, r102, r103, r104);
        return;
    L11:
        r104 = r113;
        goto L12
    }
}
