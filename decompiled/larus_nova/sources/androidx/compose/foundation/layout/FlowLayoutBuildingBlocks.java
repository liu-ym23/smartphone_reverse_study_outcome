package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001:\u0002#$B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ8\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003JW\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0013¢\u0006\u0004\b!\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks;", "", "maxItemsInMainAxis", "", "overflow", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "constraints", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "maxLines", "mainAxisSpacing", "crossAxisSpacing", "<init>", "(ILandroidx/compose/foundation/layout/FlowLayoutOverflowState;JIIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "getWrapEllipsisInfo", "Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapEllipsisInfo;", "wrapInfo", "Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapInfo;", "hasNext", "", "lastContentLineIndex", "totalCrossAxisSize", "leftOverMainAxis", "nextIndexInLine", "getWrapInfo", "nextItemHasNext", "leftOver", "Landroidx/collection/IntIntPair;", "nextSize", "lineIndex", "currentLineCrossAxisSize", "isWrappingRound", "isEllipsisWrap", "getWrapInfo-OpUlnko", "(ZIJLandroidx/collection/IntIntPair;IIIZZ)Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapInfo;", "WrapInfo", "WrapEllipsisInfo", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FlowLayoutBuildingBlocks {
    public static final int $stable = 8;
    private final long constraints;
    private final int crossAxisSpacing;
    private final int mainAxisSpacing;
    private final int maxItemsInMainAxis;
    private final int maxLines;
    private final FlowLayoutOverflowState overflow;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapEllipsisInfo;", "", "ellipsis", "Landroidx/compose/ui/layout/Measurable;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "ellipsisSize", "Landroidx/collection/IntIntPair;", "placeEllipsisOnLastContentLine", "", "<init>", "(Landroidx/compose/ui/layout/Measurable;Landroidx/compose/ui/layout/Placeable;JZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEllipsis", "()Landroidx/compose/ui/layout/Measurable;", "getPlaceable", "()Landroidx/compose/ui/layout/Placeable;", "getEllipsisSize-OO21N7I", "()J", "J", "getPlaceEllipsisOnLastContentLine", "()Z", "setPlaceEllipsisOnLastContentLine", "(Z)V", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class WrapEllipsisInfo {
        public static final int $stable = 8;
        private final Measurable ellipsis;
        private final long ellipsisSize;
        private boolean placeEllipsisOnLastContentLine;
        private final Placeable placeable;

        public /* synthetic */ WrapEllipsisInfo(Measurable r100, Placeable r101, long r102, boolean r103, DefaultConstructorMarker r104) {
            this(r100, r101, r102, r103);
        }

        public final Measurable getEllipsis() {
            return this.ellipsis;
        }

        /* JADX INFO: renamed from: getEllipsisSize-OO21N7I, reason: not valid java name */
        public final long m655getEllipsisSizeOO21N7I() {
            return this.ellipsisSize;
        }

        public final boolean getPlaceEllipsisOnLastContentLine() {
            return this.placeEllipsisOnLastContentLine;
        }

        public final Placeable getPlaceable() {
            return this.placeable;
        }

        public final void setPlaceEllipsisOnLastContentLine(boolean r100) {
            this.placeEllipsisOnLastContentLine = r100;
        }

        private WrapEllipsisInfo(Measurable r100, Placeable r101, long r102, boolean r103) {
            this.ellipsis = r100;
            this.placeable = r101;
            this.ellipsisSize = r102;
            this.placeEllipsisOnLastContentLine = r103;
        }

        public /* synthetic */ WrapEllipsisInfo(Measurable r100, Placeable r101, long r110, boolean r111, int r112, DefaultConstructorMarker r113) {
            if ((r112 & 8) == 0) goto L5;
            boolean r102 = true;
        L6:
            this(r100, r101, r110, r102, null);
            return;
        L5:
            r102 = r111;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapInfo;", "", "isLastItemInLine", "", "isLastItemInContainer", "<init>", "(ZZ)V", "()Z", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class WrapInfo {
        public static final int $stable = 0;
        private final boolean isLastItemInContainer;
        private final boolean isLastItemInLine;

        public WrapInfo() {
            boolean r100 = false;
            this(r100, r100, 3, null);
        }

        public final boolean isLastItemInContainer() {
            return this.isLastItemInContainer;
        }

        public final boolean isLastItemInLine() {
            return this.isLastItemInLine;
        }

        public WrapInfo(boolean r100, boolean r101) {
            this.isLastItemInLine = r100;
            this.isLastItemInContainer = r101;
        }

        public /* synthetic */ WrapInfo(boolean r100, boolean r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = false;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = false;
        L8:
            this(r100, r101);
        }
    }

    public /* synthetic */ FlowLayoutBuildingBlocks(int r100, FlowLayoutOverflowState r101, long r102, int r103, int r104, int r105, DefaultConstructorMarker r106) {
        this(r100, r101, r102, r103, r104, r105);
    }

    private FlowLayoutBuildingBlocks(int r100, FlowLayoutOverflowState r101, long r102, int r103, int r104, int r105) {
        this.maxItemsInMainAxis = r100;
        this.overflow = r101;
        this.constraints = r102;
        this.maxLines = r103;
        this.mainAxisSpacing = r104;
        this.crossAxisSpacing = r105;
    }

    public final WrapEllipsisInfo getWrapEllipsisInfo(WrapInfo r100, boolean r101, int r102, int r103, int r104, int r105) {
        if (r100.isLastItemInContainer() == true) goto L5;
        return null;
    L5:
        WrapEllipsisInfo r106 = this.overflow.ellipsisInfo$foundation_layout(r101, r102, r103);
        if (r106 != null) goto L8;
        return null;
    L8:
        if (r102 < 0) goto L15;
        if (r105 != 0) goto L11;
    L14:
        boolean r107 = true;
    L16:
        r106.setPlaceEllipsisOnLastContentLine(r107);
        return r106;
    L11:
        if ((r104 - IntIntPair.m21getFirstimpl(r106.m655getEllipsisSizeOO21N7I())) < 0) goto L15;
        if (r105 < this.maxItemsInMainAxis) goto L14;
    L15:
        r107 = false;
        goto L16
    }

    /* JADX INFO: renamed from: getWrapInfo-OpUlnko, reason: not valid java name */
    public final WrapInfo m654getWrapInfoOpUlnko(boolean r110, int r111, long r112, IntIntPair r210, int r211, int r212, int r213, boolean r214, boolean r215) {
        int r100 = r212 + r213;
        if (r210 != null) goto L7;
        return new WrapInfo(true, true);
    L7:
        if (this.overflow.getType$foundation_layout() != FlowLayoutOverflow.OverflowType.Visible) goto L10;
    L8:
        boolean r101 = false;
    L15:
        if (r101 == true) goto L17;
        if (r111 != 0) goto L21;
    L19:
        boolean r102 = false;
    L26:
        if (r102 == false) goto L32;
        if (r214 == false) goto L31;
        return new WrapInfo(true, true);
    L31:
        return new WrapInfo(true, m654getWrapInfoOpUlnko(r110, 0, IntIntPair.m17constructorimpl(Constraints.m7487getMaxWidthimpl(this.constraints), (IntIntPair.m22getSecondimpl(r112) - this.crossAxisSpacing) - r213), IntIntPair.m14boximpl(IntIntPair.m17constructorimpl(IntIntPair.m21getFirstimpl(r210.m25unboximpl()) - this.mainAxisSpacing, IntIntPair.m22getSecondimpl(r210.m25unboximpl()))), r211 + 1, r100, 0, true, false).isLastItemInContainer());
    L32:
        int r103 = r212 + Math.max(r213, IntIntPair.m22getSecondimpl(r210.m25unboximpl()));
        if (r215 == false) goto L35;
        IntIntPair r104 = null;
    L36:
        IntIntPair r105 = r104;
        if (r105 == null) goto L44;
        r105.m25unboximpl();
        if ((r111 + 1) < this.maxItemsInMainAxis) goto L42;
    L40:
        boolean r106 = true;
    L45:
        if (r106 == false) goto L52;
        if (r215 == true) goto L48;
        WrapInfo r107 = m654getWrapInfoOpUlnko(false, 0, IntIntPair.m17constructorimpl(Constraints.m7487getMaxWidthimpl(this.constraints), (IntIntPair.m22getSecondimpl(r112) - this.crossAxisSpacing) - Math.max(r213, IntIntPair.m22getSecondimpl(r210.m25unboximpl()))), r105, r211 + 1, r103, 0, true, true);
        return new WrapInfo(r107.isLastItemInContainer(), r107.isLastItemInContainer());
    L48:
        return new WrapInfo(true, true);
    L52:
        return new WrapInfo(false, false);
    L42:
        if ((((IntIntPair.m21getFirstimpl(r112) - IntIntPair.m21getFirstimpl(r210.m25unboximpl())) - this.mainAxisSpacing) - IntIntPair.m21getFirstimpl(r105.m25unboximpl())) < 0) goto L40;
    L44:
        r106 = false;
        goto L45
    L35:
        r104 = this.overflow.m659ellipsisSizeF35zmw$foundation_layout(r110, r211, r103);
        goto L36
    L21:
        if (r111 < this.maxItemsInMainAxis) goto L24;
    L22:
        r102 = true;
        goto L26
    L24:
        if ((IntIntPair.m21getFirstimpl(r112) - IntIntPair.m21getFirstimpl(r210.m25unboximpl())) >= 0) goto L19;
    L17:
        return new WrapInfo(true, true);
    L10:
        if (r211 < this.maxLines) goto L13;
    L11:
        r101 = true;
        goto L15
    L13:
        if ((IntIntPair.m22getSecondimpl(r112) - IntIntPair.m22getSecondimpl(r210.m25unboximpl())) >= 0) goto L8;
        goto L8
    }
}
