package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0081\b\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ'\u0010+\u001a\u0004\u0018\u00010\"2\u0006\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H\u0000¢\u0006\u0002\b/J'\u00100\u001a\u0004\u0018\u0001012\u0006\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H\u0000¢\u0006\u0002\b2J3\u00103\u001a\u0002042\b\u0010\u001b\u001a\u0004\u0018\u0001052\b\u0010\u001f\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u00020&2\u0006\u00107\u001a\u000208H\u0000¢\u0006\u0004\b9\u0010:J3\u00103\u001a\u0002042\u0006\u0010;\u001a\u00020<2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\u0006\u00107\u001a\u000208H\u0000¢\u0006\u0004\b9\u0010=JY\u00103\u001a\u0002042\u0006\u0010;\u001a\u00020<2\u0006\u00107\u001a\u00020828\u0010$\u001a4\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(>\u0012\u0006\u0012\u0004\u0018\u00010\u001c0%H\u0000¢\u0006\u0004\b?\u0010@J\u000e\u0010A\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\bBJ\u000e\u0010C\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\bDJ\u000e\u0010E\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\bFJ'\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010H\u001a\u00020&2\b\u0010I\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010J\u001a\u00020\u0005HÖ\u0001J\t\u0010K\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u0017R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000RB\u0010$\u001a6\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(*\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "", "type", "Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "minLinesToShowCollapse", "", "minCrossAxisSizeToShowCollapse", "<init>", "(Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;II)V", "getType$foundation_layout", "()Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "getMinLinesToShowCollapse$foundation_layout", "()I", "getMinCrossAxisSizeToShowCollapse$foundation_layout", "shownItemCount", "getShownItemCount$foundation_layout", "shownItemLazyErrorMessage", "", "getShownItemLazyErrorMessage$foundation_layout", "()Ljava/lang/String;", "itemShown", "getItemShown$foundation_layout", "setItemShown$foundation_layout", "(I)V", "itemCount", "getItemCount$foundation_layout", "setItemCount$foundation_layout", "seeMoreMeasurable", "Landroidx/compose/ui/layout/Measurable;", "seeMorePlaceable", "Landroidx/compose/ui/layout/Placeable;", "collapseMeasurable", "collapsePlaceable", "seeMoreSize", "Landroidx/collection/IntIntPair;", "collapseSize", "getOverflowMeasurable", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isExpandable", "noOfItemsShown", "ellipsisSize", "hasNext", "lineIndex", "totalCrossAxisSize", "ellipsisSize-F35zm-w$foundation_layout", "ellipsisInfo", "Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapEllipsisInfo;", "ellipsisInfo$foundation_layout", "setOverflowMeasurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "isHorizontal", "constraints", "Landroidx/compose/ui/unit/Constraints;", "setOverflowMeasurables--hBUhpc$foundation_layout", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;Landroidx/compose/ui/layout/IntrinsicMeasurable;ZJ)V", "measurePolicy", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "(Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;Landroidx/compose/ui/layout/Measurable;Landroidx/compose/ui/layout/Measurable;J)V", "numberOfItemsShown", "setOverflowMeasurables-VKLhPVY$foundation_layout", "(Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;JLkotlin/jvm/functions/Function2;)V", "component1", "component1$foundation_layout", "component2", "component2$foundation_layout", "component3", "component3$foundation_layout", "copy", "equals", "other", "hashCode", "toString", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FlowLayoutOverflowState {
    public static final int $stable = 8;
    private Measurable collapseMeasurable;
    private Placeable collapsePlaceable;
    private IntIntPair collapseSize;
    private Function2<? super Boolean, ? super Integer, ? extends Measurable> getOverflowMeasurable;
    private int itemCount;
    private int itemShown;
    private final int minCrossAxisSizeToShowCollapse;
    private final int minLinesToShowCollapse;
    private Measurable seeMoreMeasurable;
    private Placeable seeMorePlaceable;
    private IntIntPair seeMoreSize;
    private final String shownItemLazyErrorMessage;
    private final FlowLayoutOverflow.OverflowType type;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[FlowLayoutOverflow.OverflowType.values().length];
            r100[FlowLayoutOverflow.OverflowType.Visible.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[FlowLayoutOverflow.OverflowType.Clip.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[FlowLayoutOverflow.OverflowType.ExpandIndicator.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public static /* synthetic */ Unit a(FlowLayoutOverflowState r100, FlowLineMeasurePolicy r101, Placeable r102) {
        return setOverflowMeasurables__hBUhpc$lambda$5$lambda$4(r100, r101, r102);
    }

    public static /* synthetic */ Unit b(FlowLayoutOverflowState r100, FlowLineMeasurePolicy r101, Placeable r102) {
        return setOverflowMeasurables__hBUhpc$lambda$9$lambda$8(r100, r101, r102);
    }

    public static /* synthetic */ FlowLayoutOverflowState copy$default(FlowLayoutOverflowState r100, FlowLayoutOverflow.OverflowType r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.minLinesToShowCollapse;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.minCrossAxisSizeToShowCollapse;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final FlowLayoutOverflow.OverflowType component1$foundation_layout() {
        return this.type;
    }

    public final int component2$foundation_layout() {
        return this.minLinesToShowCollapse;
    }

    public final int component3$foundation_layout() {
        return this.minCrossAxisSizeToShowCollapse;
    }

    public final FlowLayoutOverflowState copy(FlowLayoutOverflow.OverflowType r100, int r101, int r102) {
        return new FlowLayoutOverflowState(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FlowLayoutOverflowState) == true) goto L8;
        return false;
    L8:
        FlowLayoutOverflowState r101 = (FlowLayoutOverflowState) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (this.minLinesToShowCollapse == r101.minLinesToShowCollapse) goto L15;
        return false;
    L15:
        if (this.minCrossAxisSizeToShowCollapse == r101.minCrossAxisSizeToShowCollapse) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.minLinesToShowCollapse) * 31) + this.minCrossAxisSizeToShowCollapse;
    }

    public String toString() {
        return "FlowLayoutOverflowState(type=" + this.type + ", minLinesToShowCollapse=" + this.minLinesToShowCollapse + ", minCrossAxisSizeToShowCollapse=" + this.minCrossAxisSizeToShowCollapse + ')';
    }

    public final int getShownItemCount$foundation_layout() {
        int r100 = this.itemShown;
        if (r100 == (-1)) goto L6;
        return r100;
    L6:
        throw new IllegalStateException(this.shownItemLazyErrorMessage);
    }

    public final int getItemCount$foundation_layout() {
        return this.itemCount;
    }

    public final int getItemShown$foundation_layout() {
        return this.itemShown;
    }

    public final int getMinCrossAxisSizeToShowCollapse$foundation_layout() {
        return this.minCrossAxisSizeToShowCollapse;
    }

    public final int getMinLinesToShowCollapse$foundation_layout() {
        return this.minLinesToShowCollapse;
    }

    public final String getShownItemLazyErrorMessage$foundation_layout() {
        return this.shownItemLazyErrorMessage;
    }

    public final FlowLayoutOverflow.OverflowType getType$foundation_layout() {
        return this.type;
    }

    public final void setItemCount$foundation_layout(int r100) {
        this.itemCount = r100;
    }

    public final void setItemShown$foundation_layout(int r100) {
        this.itemShown = r100;
    }

    public FlowLayoutOverflowState(FlowLayoutOverflow.OverflowType r100, int r101, int r102) {
        this.type = r100;
        this.minLinesToShowCollapse = r101;
        this.minCrossAxisSizeToShowCollapse = r102;
        this.shownItemLazyErrorMessage = "Accessing shownItemCount before it is set. Are you calling this in the Composition phase, rather than in the draw phase? Consider our samples on how to use it during the draw phase or consider using ContextualFlowRow/ContextualFlowColumn which initializes this method in the composition phase.";
        this.itemShown = -1;
    }

    private static final Unit setOverflowMeasurables__hBUhpc$lambda$5$lambda$4(FlowLayoutOverflowState r100, FlowLineMeasurePolicy r101, Placeable r102) {
        if (r102 == null) goto L4;
        int r103 = r101.mainAxisSize(r102);
        int r104 = r101.crossAxisSize(r102);
    L5:
        r100.seeMoreSize = IntIntPair.m14boximpl(IntIntPair.m17constructorimpl(r103, r104));
        r100.seeMorePlaceable = r102;
        return Unit.INSTANCE;
    L4:
        r103 = 0;
        r104 = 0;
        goto L5
    }

    private static final Unit setOverflowMeasurables__hBUhpc$lambda$9$lambda$8(FlowLayoutOverflowState r100, FlowLineMeasurePolicy r101, Placeable r102) {
        if (r102 == null) goto L4;
        int r103 = r101.mainAxisSize(r102);
        int r104 = r101.crossAxisSize(r102);
    L5:
        r100.collapseSize = IntIntPair.m14boximpl(IntIntPair.m17constructorimpl(r103, r104));
        r100.collapsePlaceable = r102;
        return Unit.INSTANCE;
    L4:
        r103 = 0;
        r104 = 0;
        goto L5
    }

    public final FlowLayoutBuildingBlocks.WrapEllipsisInfo ellipsisInfo$foundation_layout(boolean r110, int r111, int r112) {
        int r100 = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
        if (r100 != 1) goto L5;
        return null;
    L5:
        if (r100 != 2) goto L7;
        return null;
    L7:
        if (r100 != 3) goto L9;
    L13:
        if (r110 == false) goto L23;
        Function2<? super Boolean, ? super Integer, ? extends Measurable> r113 = this.getOverflowMeasurable;
        if (r113 == null) goto L18;
        Measurable r114 = r113.invoke(Boolean.TRUE, Integer.valueOf(getShownItemCount$foundation_layout()));
        if (r114 == null) goto L18;
    L19:
        IntIntPair r115 = this.seeMoreSize;
        if (this.getOverflowMeasurable != null) goto L36;
        Placeable r116 = this.seeMorePlaceable;
    L35:
        Measurable r101 = r114;
        Placeable r102 = r116;
    L37:
        if (r101 != null) goto L39;
        return null;
    L39:
        Intrinsics.checkNotNull(r115);
        return new FlowLayoutBuildingBlocks.WrapEllipsisInfo(r101, r102, r115.m25unboximpl(), false, 8, null);
    L36:
        r101 = r114;
        r102 = null;
    L18:
        r114 = this.seeMoreMeasurable;
        goto L19
    L23:
        if (r111 >= (this.minLinesToShowCollapse - 1)) goto L25;
    L31:
        r114 = null;
    L32:
        r115 = this.collapseSize;
        if (this.getOverflowMeasurable != null) goto L36;
        r116 = this.collapsePlaceable;
        goto L35
    L25:
        if (r112 < this.minCrossAxisSizeToShowCollapse) goto L31;
        Function2<? super Boolean, ? super Integer, ? extends Measurable> r117 = this.getOverflowMeasurable;
        if (r117 == null) goto L30;
        r114 = r117.invoke(Boolean.FALSE, Integer.valueOf(getShownItemCount$foundation_layout()));
        if (r114 != null) goto L32;
    L30:
        r114 = this.collapseMeasurable;
        goto L32
    L9:
        if (r100 == 4) goto L13;
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: ellipsisSize-F35zm-w$foundation_layout, reason: not valid java name */
    public final IntIntPair m659ellipsisSizeF35zmw$foundation_layout(boolean r100, int r101, int r102) {
        FlowLayoutOverflow.OverflowType r103 = this.type;
        int r104 = WhenMappings.$EnumSwitchMapping$0[r103.ordinal()];
        if (r104 != 1) goto L5;
        return null;
    L5:
        if (r104 != 2) goto L7;
        return null;
    L7:
        if (r104 != 3) goto L9;
        if (r100 == true) goto L21;
        return null;
    L21:
        return this.seeMoreSize;
    L9:
        if (r104 != 4) goto L18;
        if (r100 == false) goto L13;
        return this.seeMoreSize;
    L13:
        if ((r101 + 1) >= this.minLinesToShowCollapse) goto L15;
        return null;
    L15:
        if (r102 >= this.minCrossAxisSizeToShowCollapse) goto L27;
        return null;
    L27:
        return this.collapseSize;
    L18:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: setOverflowMeasurables-VKLhPVY$foundation_layout, reason: not valid java name */
    public final void m662setOverflowMeasurablesVKLhPVY$foundation_layout(FlowLineMeasurePolicy r100, long r110, Function2<? super Boolean, ? super Integer, ? extends Measurable> r111) {
        this.itemShown = 0;
        this.getOverflowMeasurable = r111;
        m660setOverflowMeasurableshBUhpc$foundation_layout(r100, r111.invoke(Boolean.TRUE, 0), r111.invoke(Boolean.FALSE, 0), r110);
    }

    /* JADX INFO: renamed from: setOverflowMeasurables--hBUhpc$foundation_layout, reason: not valid java name */
    public final void m661setOverflowMeasurableshBUhpc$foundation_layout(IntrinsicMeasurable r100, IntrinsicMeasurable r101, boolean r102, long r103) {
        if (r102 == false) goto L4;
        LayoutOrientation r104 = LayoutOrientation.Horizontal;
    L5:
        long r105 = OrientationIndependentConstraints.m700constructorimpl(r103, r104);
        if (r100 == null) goto L12;
        int r106 = FlowLayoutKt.mainAxisMin(r100, r102, Constraints.m7486getMaxHeightimpl(r105));
        this.seeMoreSize = IntIntPair.m14boximpl(IntIntPair.m17constructorimpl(r106, FlowLayoutKt.crossAxisMin(r100, r102, r106)));
        if ((r100 instanceof Measurable) == false) goto L10;
        Measurable r107 = (Measurable) r100;
    L11:
        this.seeMoreMeasurable = r107;
        this.seeMorePlaceable = null;
        goto L12
    L10:
        r107 = null;
    L12:
        if (r101 == null) goto L19;
        int r108 = FlowLayoutKt.mainAxisMin(r101, r102, Constraints.m7486getMaxHeightimpl(r105));
        this.collapseSize = IntIntPair.m14boximpl(IntIntPair.m17constructorimpl(r108, FlowLayoutKt.crossAxisMin(r101, r102, r108)));
        if ((r101 instanceof Measurable) == false) goto L16;
        Measurable r109 = (Measurable) r101;
    L17:
        this.collapseMeasurable = r109;
        this.collapsePlaceable = null;
        return;
    L16:
        r109 = null;
        goto L17
    L19:
        return;
    L4:
        r104 = LayoutOrientation.Vertical;
        goto L5
    }

    /* JADX INFO: renamed from: setOverflowMeasurables--hBUhpc$foundation_layout, reason: not valid java name */
    public final void m660setOverflowMeasurableshBUhpc$foundation_layout(final FlowLineMeasurePolicy r110, Measurable r111, Measurable r112, long r113) {
        if (r110.isHorizontal() == false) goto L5;
        LayoutOrientation r100 = LayoutOrientation.Horizontal;
    L6:
        long r114 = OrientationIndependentConstraints.m713toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m702copyyUG9Ft0$default(OrientationIndependentConstraints.m700constructorimpl(r113, r100), 0, 0, 0, 0, 10, null), r100);
        if (r111 == null) goto L9;
        FlowLayoutKt.m657measureAndCacherqJ1uqs(r111, r110, r114, new r0(this, r110));
        this.seeMoreMeasurable = r111;
    L9:
        if (r112 == null) goto L12;
        FlowLayoutKt.m657measureAndCacherqJ1uqs(r112, r110, r114, new s0(this, r110));
        this.collapseMeasurable = r112;
        return;
    L12:
        return;
    L5:
        r100 = LayoutOrientation.Vertical;
        goto L6
    }
}
