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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003H\u0007J\u000e\u0010!\u001a\u00020\"H\u0086@¢\u0006\u0002\u0010#J\u000e\u0010$\u001a\u00020\"H\u0086@¢\u0006\u0002\u0010#J\u0006\u0010%\u001a\u00020\bJ\"\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\bH\u0080@¢\u0006\u0004\b)\u0010*J\u0018\u0010+\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u0003H\u0080@¢\u0006\u0004\b,\u0010-R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\b8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Landroidx/compose/material/BottomSheetState;", "", "initialValue", "Landroidx/compose/material/BottomSheetValue;", "density", "Landroidx/compose/ui/unit/Density;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "<init>", "(Landroidx/compose/material/BottomSheetValue;Landroidx/compose/ui/unit/Density;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "anchoredDraggableState", "Landroidx/compose/material/AnchoredDraggableState;", "getAnchoredDraggableState$material", "()Landroidx/compose/material/AnchoredDraggableState;", "currentValue", "getCurrentValue", "()Landroidx/compose/material/BottomSheetValue;", "targetValue", "getTargetValue", "isExpanded", "()Z", "isCollapsed", "progress", "getProgress$annotations", "()V", "getProgress", "()F", "from", RemoteMessageConst.TO, BitableAnalytic.LinkSceneClickType.EXPAND, "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collapse", "requireOffset", "animateTo", PickerReporterConstants.KEY.TARGET, "velocity", "animateTo$material", "(Landroidx/compose/material/BottomSheetValue;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "snapTo$material", "(Landroidx/compose/material/BottomSheetValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BottomSheetState {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final AnchoredDraggableState<BottomSheetValue> anchoredDraggableState;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/material/BottomSheetState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/BottomSheetState;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Landroidx/compose/material/BottomSheetValue;", "", "density", "Landroidx/compose/ui/unit/Density;", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ BottomSheetValue a(SaverScope r100, BottomSheetState r101) {
            return Saver$lambda$0(r100, r101);
        }

        public static /* synthetic */ BottomSheetState b(Density r100, AnimationSpec r101, Function1 r102, BottomSheetValue r103) {
            return Saver$lambda$1(r100, r101, r102, r103);
        }

        private static final BottomSheetValue Saver$lambda$0(SaverScope r100, BottomSheetState r101) {
            return r101.getAnchoredDraggableState$material().getCurrentValue();
        }

        public final Saver<BottomSheetState, ?> Saver(final AnimationSpec<Float> r100, final Function1<? super BottomSheetValue, Boolean> r101, final Density r102) {
            return SaverKt.Saver(new m2(), new n2(r102, r100, r101));
        }

        private static final BottomSheetState Saver$lambda$1(Density r100, AnimationSpec r101, Function1 r102, BottomSheetValue r103) {
            return new BottomSheetState(r103, r100, r101, r102);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private static final boolean _init_$lambda$0(BottomSheetValue r100) {
        return true;
    }

    public static /* synthetic */ boolean a(BottomSheetValue r100) {
        return _init_$lambda$0(r100);
    }

    public static /* synthetic */ float b(Density r100, float r101) {
        return anchoredDraggableState$lambda$2(r100, r101);
    }

    public static /* synthetic */ float c(Density r100) {
        return anchoredDraggableState$lambda$4(r100);
    }

    @Deprecated(message = "Please use the progress function to query progress explicitly between targets.", replaceWith = @ReplaceWith(expression = "progress(from = , to = )", imports = {}))
    public static /* synthetic */ void getProgress$annotations() {
    }

    public final BottomSheetValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final float getProgress() {
        return this.anchoredDraggableState.getProgress();
    }

    public final BottomSheetValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final boolean isCollapsed() {
        if (this.anchoredDraggableState.getCurrentValue() != BottomSheetValue.Collapsed) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isExpanded() {
        if (this.anchoredDraggableState.getCurrentValue() != BottomSheetValue.Expanded) goto L5;
        return true;
    L5:
        return false;
    }

    public final float requireOffset() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final AnchoredDraggableState<BottomSheetValue> getAnchoredDraggableState$material() {
        return this.anchoredDraggableState;
    }

    private static final float anchoredDraggableState$lambda$4(Density r100) {
        return r100.mo371toPx0680j_4(BottomSheetScaffoldKt.access$getBottomSheetScaffoldVelocityThreshold$p());
    }

    public final Object collapse(Continuation<? super Unit> r100) {
        Object r101 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, BottomSheetValue.Collapsed, 0.0f, r100, 2, null);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    public final Object expand(Continuation<? super Unit> r100) {
        DraggableAnchors<BottomSheetValue> r101 = this.anchoredDraggableState.getAnchors();
        BottomSheetValue r102 = BottomSheetValue.Expanded;
        if (r101.hasAnchorFor(r102) == true) goto L6;
        r102 = BottomSheetValue.Collapsed;
    L6:
        AnchoredDraggableState<BottomSheetValue> r103 = this.anchoredDraggableState;
        Object r104 = AnchoredDraggableKt.animateTo$default(r103, r102, 0.0f, r100, 2, null);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r104;
    L10:
        return Unit.INSTANCE;
    }

    private static final float anchoredDraggableState$lambda$2(Density r100, float r101) {
        return r100.mo371toPx0680j_4(BottomSheetScaffoldKt.access$getBottomSheetScaffoldPositionalThreshold$p());
    }

    public final float progress(BottomSheetValue r100, BottomSheetValue r101) {
        float r102 = this.anchoredDraggableState.getAnchors().positionOf(r100);
        float r103 = this.anchoredDraggableState.getAnchors().positionOf(r101);
        float r104 = (RangesKt.coerceIn(this.anchoredDraggableState.getOffset(), Math.min(r102, r103), Math.max(r102, r103)) - r102) / (r103 - r102);
        if (Float.isNaN(r104) == false) goto L6;
        return 1.0f;
    L6:
        return Math.abs(r104);
    }

    public final Object snapTo$material(BottomSheetValue r100, Continuation<? super Unit> r101) {
        Object r102 = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, r100, r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public final Object animateTo$material(BottomSheetValue r100, float r101, Continuation<? super Unit> r102) {
        Object r103 = AnchoredDraggableKt.animateTo(this.anchoredDraggableState, r100, r101, r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    public BottomSheetState(BottomSheetValue r100, final Density r101, AnimationSpec<Float> r110, Function1<? super BottomSheetValue, Boolean> r111) {
        this.anchoredDraggableState = new AnchoredDraggableState(r100, new k2(r101), new l2(r101), r110, r111);
    }

    public /* synthetic */ BottomSheetState(BottomSheetValue r100, Density r101, AnimationSpec r102, Function1 r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L6;
        r102 = BottomSheetScaffoldDefaults.INSTANCE.getAnimationSpec();
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = new j2();
    L8:
        this(r100, r101, r102, r103);
    }

    public static /* synthetic */ Object animateTo$material$default(BottomSheetState r100, BottomSheetValue r101, float r102, Continuation r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = r100.anchoredDraggableState.getLastVelocity();
    L6:
        return r100.animateTo$material(r101, r102, r103);
    }
}
