package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 >2\u00020\u0001:\u0001>B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u0018\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u0019J\u0018\u0010 \u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0007J\u000e\u0010&\u001a\u00020'H\u0086@¢\u0006\u0002\u0010(J\u000e\u0010)\u001a\u00020'H\u0086@¢\u0006\u0002\u0010(J\u000e\u0010*\u001a\u00020'H\u0086@¢\u0006\u0002\u0010(J\"\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b.\u0010/J\u0018\u00100\u001a\u00020'2\u0006\u0010,\u001a\u00020\u0003H\u0080@¢\u0006\u0004\b1\u00102J\u0015\u0010\u0006\u001a\u00020\b2\u0006\u00103\u001a\u00020\u0003H\u0000¢\u0006\u0002\b4R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u001c\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u001f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u001a\u0010 \u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0017R\u0014\u00105\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u001dR\u0014\u00106\u001a\u000207X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006?"}, d2 = {"Landroidx/compose/material/BottomDrawerState;", "", "initialValue", "Landroidx/compose/material/BottomDrawerValue;", "density", "Landroidx/compose/ui/unit/Density;", "confirmStateChange", "Lkotlin/Function1;", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(Landroidx/compose/material/BottomDrawerValue;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;)V", "anchoredDraggableState", "Landroidx/compose/material/AnchoredDraggableState;", "getAnchoredDraggableState$material", "()Landroidx/compose/material/AnchoredDraggableState;", "targetValue", "getTargetValue", "()Landroidx/compose/material/BottomDrawerValue;", "offset", "getOffset", "()F", "requireOffset", "requireOffset$material", "currentValue", "getCurrentValue", "isOpen", "()Z", "isClosed", "isExpanded", "progress", "getProgress$annotations", "()V", "getProgress", "from", RemoteMessageConst.TO, "open", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", BitableAnalytic.LinkSceneClickType.EXPAND, "animateTo", PickerReporterConstants.KEY.TARGET, "velocity", "animateTo$material", "(Landroidx/compose/material/BottomDrawerValue;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "snapTo$material", "(Landroidx/compose/material/BottomDrawerValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "confirmStateChange$material", "isOpenEnabled", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getNestedScrollConnection$material", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getDensity$material", "()Landroidx/compose/ui/unit/Density;", "setDensity$material", "(Landroidx/compose/ui/unit/Density;)V", "Companion", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BottomDrawerState {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final AnchoredDraggableState<BottomDrawerValue> anchoredDraggableState;
    private Density density;
    private final NestedScrollConnection nestedScrollConnection;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¨\u0006\u0010"}, d2 = {"Landroidx/compose/material/BottomDrawerState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/BottomDrawerState;", "Landroidx/compose/material/BottomDrawerValue;", "density", "Landroidx/compose/ui/unit/Density;", "confirmStateChange", "Lkotlin/Function1;", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ BottomDrawerValue a(SaverScope r100, BottomDrawerState r101) {
            return Saver$lambda$0(r100, r101);
        }

        public static /* synthetic */ BottomDrawerState b(Density r100, Function1 r101, AnimationSpec r102, BottomDrawerValue r103) {
            return Saver$lambda$1(r100, r101, r102, r103);
        }

        private static final BottomDrawerValue Saver$lambda$0(SaverScope r100, BottomDrawerState r101) {
            return r101.getAnchoredDraggableState$material().getCurrentValue();
        }

        public final Saver<BottomDrawerState, BottomDrawerValue> Saver(final Density r100, final Function1<? super BottomDrawerValue, Boolean> r101, final AnimationSpec<Float> r102) {
            return SaverKt.Saver(new o1(), new p1(r100, r101, r102));
        }

        private static final BottomDrawerState Saver$lambda$1(Density r100, Function1 r101, AnimationSpec r102, BottomDrawerValue r103) {
            return new BottomDrawerState(r103, r100, r101, r102);
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    private static final boolean _init_$lambda$0(BottomDrawerValue r100) {
        return true;
    }

    public static /* synthetic */ float a(Density r100) {
        return anchoredDraggableState$lambda$4(r100);
    }

    public static /* synthetic */ boolean b(BottomDrawerValue r100) {
        return _init_$lambda$0(r100);
    }

    public static /* synthetic */ float c(Density r100, float r101) {
        return anchoredDraggableState$lambda$2(r100, r101);
    }

    @Deprecated(message = "Please use the progress function to query progress explicitly between targets.", replaceWith = @ReplaceWith(expression = "progress(from = , to = )", imports = {}))
    public static /* synthetic */ void getProgress$annotations() {
    }

    private final boolean isOpenEnabled() {
        return this.anchoredDraggableState.getAnchors().hasAnchorFor(BottomDrawerValue.Open);
    }

    public final BottomDrawerValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final float getOffset() {
        return this.anchoredDraggableState.getOffset();
    }

    public final float getProgress() {
        return this.anchoredDraggableState.getProgress();
    }

    public final BottomDrawerValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final boolean isClosed() {
        if (this.anchoredDraggableState.getCurrentValue() != BottomDrawerValue.Closed) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isExpanded() {
        if (this.anchoredDraggableState.getCurrentValue() != BottomDrawerValue.Expanded) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isOpen() {
        if (this.anchoredDraggableState.getCurrentValue() == BottomDrawerValue.Closed) goto L5;
        return true;
    L5:
        return false;
    }

    public final float requireOffset$material() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final AnchoredDraggableState<BottomDrawerValue> getAnchoredDraggableState$material() {
        return this.anchoredDraggableState;
    }

    public final Density getDensity$material() {
        return this.density;
    }

    public final NestedScrollConnection getNestedScrollConnection$material() {
        return this.nestedScrollConnection;
    }

    private static final float anchoredDraggableState$lambda$4(Density r100) {
        return r100.mo371toPx0680j_4(DrawerKt.access$getDrawerVelocityThreshold$p());
    }

    public final Object close(Continuation<? super Unit> r100) {
        Object r101 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, BottomDrawerValue.Closed, 0.0f, r100, 2, null);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    public final boolean confirmStateChange$material(BottomDrawerValue r100) {
        return this.anchoredDraggableState.getConfirmValueChange$material().invoke(r100).booleanValue();
    }

    public final Object expand(Continuation<? super Unit> r100) {
        Object r101 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, BottomDrawerValue.Expanded, 0.0f, r100, 2, null);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    public final Object open(Continuation<? super Unit> r100) {
        if (isOpenEnabled() == false) goto L5;
        BottomDrawerValue r101 = BottomDrawerValue.Open;
    L6:
        AnchoredDraggableState<BottomDrawerValue> r102 = this.anchoredDraggableState;
        Object r103 = AnchoredDraggableKt.animateTo$default(r102, r101, 0.0f, r100, 2, null);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r103;
    L10:
        return Unit.INSTANCE;
    L5:
        r101 = BottomDrawerValue.Expanded;
        goto L6
    }

    public final void setDensity$material(Density r100) {
        this.density = r100;
    }

    private static final float anchoredDraggableState$lambda$2(Density r100, float r101) {
        return r100.mo371toPx0680j_4(DrawerKt.access$getDrawerPositionalThreshold$p());
    }

    public final float progress(BottomDrawerValue r100, BottomDrawerValue r101) {
        float r102 = this.anchoredDraggableState.getAnchors().positionOf(r100);
        float r103 = this.anchoredDraggableState.getAnchors().positionOf(r101);
        float r104 = (RangesKt.coerceIn(this.anchoredDraggableState.getOffset(), Math.min(r102, r103), Math.max(r102, r103)) - r102) / (r103 - r102);
        if (Float.isNaN(r104) == false) goto L6;
        return 1.0f;
    L6:
        return Math.abs(r104);
    }

    public final Object snapTo$material(BottomDrawerValue r100, Continuation<? super Unit> r101) {
        Object r102 = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public final Object animateTo$material(BottomDrawerValue r100, float r101, Continuation<? super Unit> r102) {
        Object r103 = AnchoredDraggableKt.animateTo(this.anchoredDraggableState, r100, r101, r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    public BottomDrawerState(BottomDrawerValue r100, final Density r101, Function1<? super BottomDrawerValue, Boolean> r110, AnimationSpec<Float> r111) {
        AnchoredDraggableState<BottomDrawerValue> r102 = new AnchoredDraggableState(r100, new m1(r101), new n1(r101), r111, r110);
        this.anchoredDraggableState = r102;
        this.nestedScrollConnection = DrawerKt.access$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(r102);
    }

    public /* synthetic */ BottomDrawerState(BottomDrawerValue r100, Density r101, Function1 r102, AnimationSpec r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = new l1();
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = DrawerDefaults.INSTANCE.getAnimationSpec();
    L8:
        this(r100, r101, r102, r103);
    }

    public static /* synthetic */ Object animateTo$material$default(BottomDrawerState r100, BottomDrawerValue r101, float r102, Continuation r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = r100.anchoredDraggableState.getLastVelocity();
    L6:
        return r100.animateTo$material(r101, r102, r103);
    }
}
