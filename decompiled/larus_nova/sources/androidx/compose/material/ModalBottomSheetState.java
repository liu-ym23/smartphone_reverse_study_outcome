package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Density;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 82\u00020\u0001:\u00018BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003H\u0007J\u000e\u0010&\u001a\u00020'H\u0086@¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020'H\u0080@¢\u0006\u0004\b*\u0010(J\u000e\u0010+\u001a\u00020'H\u0086@¢\u0006\u0002\u0010(J\u0010\u0010,\u001a\u00020'H\u0080@¢\u0006\u0004\b-\u0010(J\"\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b1\u00102J\u0018\u00103\u001a\u00020'2\u0006\u0010/\u001a\u00020\u0003H\u0080@¢\u0006\u0004\b4\u00105J\r\u00106\u001a\u00020\u000bH\u0000¢\u0006\u0002\b7R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\f\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\u001c\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0011\u0010#\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b#\u0010\u0012R\u0014\u0010$\u001a\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0012¨\u00069"}, d2 = {"Landroidx/compose/material/ModalBottomSheetState;", "", "initialValue", "Landroidx/compose/material/ModalBottomSheetValue;", "density", "Landroidx/compose/ui/unit/Density;", "confirmValueChange", "Lkotlin/Function1;", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "isSkipHalfExpanded", "<init>", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;Z)V", "getAnimationSpec$material", "()Landroidx/compose/animation/core/AnimationSpec;", "isSkipHalfExpanded$material", "()Z", "anchoredDraggableState", "Landroidx/compose/material/AnchoredDraggableState;", "getAnchoredDraggableState$material", "()Landroidx/compose/material/AnchoredDraggableState;", "currentValue", "getCurrentValue", "()Landroidx/compose/material/ModalBottomSheetValue;", "targetValue", "getTargetValue", "progress", "getProgress$annotations", "()V", "getProgress", "()F", "from", RemoteMessageConst.TO, "isVisible", "hasHalfExpandedState", "getHasHalfExpandedState$material", "show", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "halfExpand", "halfExpand$material", "hide", BitableAnalytic.LinkSceneClickType.EXPAND, "expand$material", "animateTo", PickerReporterConstants.KEY.TARGET, "velocity", "animateTo$material", "(Landroidx/compose/material/ModalBottomSheetValue;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "snapTo$material", "(Landroidx/compose/material/ModalBottomSheetValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireOffset", "requireOffset$material", "Companion", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ModalBottomSheetState {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final AnchoredDraggableState<ModalBottomSheetValue> anchoredDraggableState;
    private final AnimationSpec<Float> animationSpec;
    private final boolean isSkipHalfExpanded;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/material/ModalBottomSheetState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/ModalBottomSheetState;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "Landroidx/compose/material/ModalBottomSheetValue;", "", "skipHalfExpanded", "density", "Landroidx/compose/ui/unit/Density;", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ ModalBottomSheetState a(Density r100, Function1 r101, AnimationSpec r102, boolean r103, ModalBottomSheetValue r104) {
            return Saver$lambda$1(r100, r101, r102, r103, r104);
        }

        public static /* synthetic */ ModalBottomSheetValue b(SaverScope r100, ModalBottomSheetState r101) {
            return Saver$lambda$0(r100, r101);
        }

        private static final ModalBottomSheetValue Saver$lambda$0(SaverScope r100, ModalBottomSheetState r101) {
            return r101.getCurrentValue();
        }

        public final Saver<ModalBottomSheetState, ?> Saver(final AnimationSpec<Float> r100, final Function1<? super ModalBottomSheetValue, Boolean> r101, final boolean r102, final Density r103) {
            return SaverKt.Saver(new w6(), new x6(r103, r101, r100, r102));
        }

        private static final ModalBottomSheetState Saver$lambda$1(Density r100, Function1 r101, AnimationSpec r102, boolean r110, ModalBottomSheetValue r111) {
            return new ModalBottomSheetState(r111, r100, r101, r102, r110);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[ModalBottomSheetValue.values().length];
            r100[ModalBottomSheetValue.Hidden.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    private static final boolean _init_$lambda$0(ModalBottomSheetValue r100) {
        return true;
    }

    public static /* synthetic */ float a(Density r100) {
        return anchoredDraggableState$lambda$4(r100);
    }

    public static /* synthetic */ boolean b(ModalBottomSheetValue r100) {
        return _init_$lambda$0(r100);
    }

    public static /* synthetic */ float c(Density r100, float r101) {
        return anchoredDraggableState$lambda$2(r100, r101);
    }

    @Deprecated(message = "Please use the progress function to query progress explicitly between targets.", replaceWith = @ReplaceWith(expression = "progress(from = , to = )", imports = {}))
    public static /* synthetic */ void getProgress$annotations() {
    }

    public final ModalBottomSheetValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final boolean getHasHalfExpandedState$material() {
        return this.anchoredDraggableState.getAnchors().hasAnchorFor(ModalBottomSheetValue.HalfExpanded);
    }

    public final float getProgress() {
        return this.anchoredDraggableState.getProgress();
    }

    public final ModalBottomSheetValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final boolean isVisible() {
        if (this.anchoredDraggableState.getCurrentValue() == ModalBottomSheetValue.Hidden) goto L5;
        return true;
    L5:
        return false;
    }

    public final float requireOffset$material() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final AnchoredDraggableState<ModalBottomSheetValue> getAnchoredDraggableState$material() {
        return this.anchoredDraggableState;
    }

    public final AnimationSpec<Float> getAnimationSpec$material() {
        return this.animationSpec;
    }

    public final boolean isSkipHalfExpanded$material() {
        return this.isSkipHalfExpanded;
    }

    private static final float anchoredDraggableState$lambda$4(Density r100) {
        return r100.mo371toPx0680j_4(ModalBottomSheetKt.access$getModalBottomSheetVelocityThreshold$p());
    }

    public final Object expand$material(Continuation<? super Unit> r100) {
        DraggableAnchors<ModalBottomSheetValue> r101 = this.anchoredDraggableState.getAnchors();
        ModalBottomSheetValue r102 = ModalBottomSheetValue.Expanded;
        if (r101.hasAnchorFor(r102) == false) goto L5;
        Object r103 = animateTo$material$default(this, r102, 0.0f, r100, 2, null);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r103;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    public final Object halfExpand$material(Continuation<? super Unit> r100) {
        if (getHasHalfExpandedState$material() == false) goto L5;
        Object r101 = animateTo$material$default(this, ModalBottomSheetValue.HalfExpanded, 0.0f, r100, 2, null);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r101;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    public final Object hide(Continuation<? super Unit> r100) {
        Object r101 = animateTo$material$default(this, ModalBottomSheetValue.Hidden, 0.0f, r100, 2, null);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    public final Object show(Continuation<? super Unit> r100) {
        DraggableAnchors<ModalBottomSheetValue> r101 = this.anchoredDraggableState.getAnchors();
        ModalBottomSheetValue r102 = ModalBottomSheetValue.Expanded;
        boolean r103 = r101.hasAnchorFor(r102);
        ModalBottomSheetValue r104 = getCurrentValue();
        if (WhenMappings.$EnumSwitchMapping$0[r104.ordinal()] == 1) goto L5;
        if (r103 == true) goto L10;
        r102 = ModalBottomSheetValue.Hidden;
    L10:
        Object r105 = animateTo$material$default(this, r102, 0.0f, r100, 2, null);
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        return r105;
    L14:
        return Unit.INSTANCE;
    L5:
        if (getHasHalfExpandedState$material() == false) goto L10;
        r102 = ModalBottomSheetValue.HalfExpanded;
        goto L10
    }

    private static final float anchoredDraggableState$lambda$2(Density r100, float r101) {
        return r100.mo371toPx0680j_4(ModalBottomSheetKt.access$getModalBottomSheetPositionalThreshold$p());
    }

    public final float progress(ModalBottomSheetValue r100, ModalBottomSheetValue r101) {
        float r102 = this.anchoredDraggableState.getAnchors().positionOf(r100);
        float r103 = this.anchoredDraggableState.getAnchors().positionOf(r101);
        float r104 = (RangesKt.coerceIn(this.anchoredDraggableState.getOffset(), Math.min(r102, r103), Math.max(r102, r103)) - r102) / (r103 - r102);
        if (Float.isNaN(r104) == false) goto L6;
        return 1.0f;
    L6:
        return Math.abs(r104);
    }

    public final Object snapTo$material(ModalBottomSheetValue r100, Continuation<? super Unit> r101) {
        Object r102 = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public final Object animateTo$material(ModalBottomSheetValue r100, float r101, Continuation<? super Unit> r102) {
        Object r103 = AnchoredDraggableKt.animateTo(this.anchoredDraggableState, r100, r101, r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    public ModalBottomSheetState(ModalBottomSheetValue r100, final Density r101, Function1<? super ModalBottomSheetValue, Boolean> r110, AnimationSpec<Float> r111, boolean r112) {
        this.animationSpec = r111;
        this.isSkipHalfExpanded = r112;
        this.anchoredDraggableState = new AnchoredDraggableState(r100, new t6(r101), new u6(r101), r111, r110);
        if (r112 == true) goto L5;
        return;
    L5:
        if (r100 == ModalBottomSheetValue.HalfExpanded) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L11;
        return;
    L11:
        throw new IllegalArgumentException("The initial value must not be set to HalfExpanded if skipHalfExpanded is set to true.".toString());
    L7:
        r102 = false;
        goto L8
    }

    public static /* synthetic */ Object animateTo$material$default(ModalBottomSheetState r100, ModalBottomSheetValue r101, float r102, Continuation r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = r100.anchoredDraggableState.getLastVelocity();
    L6:
        return r100.animateTo$material(r101, r102, r103);
    }

    public /* synthetic */ ModalBottomSheetState(ModalBottomSheetValue r100, Density r101, Function1 r102, AnimationSpec r110, boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 4) == 0) goto L5;
        r102 = new v6();
    L5:
        Function1 r103 = r102;
        if ((r112 & 8) == 0) goto L8;
        r110 = ModalBottomSheetDefaults.INSTANCE.getAnimationSpec();
    L8:
        AnimationSpec r104 = r110;
        if ((r112 & 16) == 0) goto L11;
        boolean r105 = false;
    L12:
        this(r100, r101, r103, r104, r105);
        return;
    L11:
        r105 = r111;
        goto L12
    }
}
