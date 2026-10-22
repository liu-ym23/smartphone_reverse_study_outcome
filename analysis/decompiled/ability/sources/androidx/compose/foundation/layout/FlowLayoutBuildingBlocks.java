package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001:\u0002&'B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ?\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017JZ\u0010\"\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0004\b \u0010!R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010#R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010$R\u001a\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0007\u0010%R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010#R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010#R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010#\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks;", "", "", "maxItemsInMainAxis", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "overflow", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "constraints", "maxLines", "mainAxisSpacing", "crossAxisSpacing", AppAgent.CONSTRUCT, "(ILandroidx/compose/foundation/layout/FlowLayoutOverflowState;JIIILkotlin/jvm/internal/e;)V", "Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapInfo;", "wrapInfo", "", "hasNext", "lastContentLineIndex", "totalCrossAxisSize", "leftOverMainAxis", "nextIndexInLine", "Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapEllipsisInfo;", "getWrapEllipsisInfo", "(Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapInfo;ZIIII)Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapEllipsisInfo;", "nextItemHasNext", "Landroidx/collection/IntIntPair;", "leftOver", "nextSize", "lineIndex", "currentLineCrossAxisSize", "isWrappingRound", "isEllipsisWrap", "getWrapInfo-OpUlnko", "(ZIJLandroidx/collection/IntIntPair;IIIZZ)Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapInfo;", "getWrapInfo", "I", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "J", "WrapEllipsisInfo", "WrapInfo", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FlowLayoutBuildingBlocks {
    public static final int $stable = 8;
    private final long constraints;
    private final int crossAxisSpacing;
    private final int mainAxisSpacing;
    private final int maxItemsInMainAxis;
    private final int maxLines;
    private final FlowLayoutOverflowState overflow;

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0007\u001a\u00020\u00068\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapEllipsisInfo;", "", "Landroidx/compose/ui/layout/Measurable;", "ellipsis", "Landroidx/compose/ui/layout/Placeable;", "placeable", "Landroidx/collection/IntIntPair;", "ellipsisSize", "", "placeEllipsisOnLastContentLine", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/layout/Measurable;Landroidx/compose/ui/layout/Placeable;JZLkotlin/jvm/internal/e;)V", "Landroidx/compose/ui/layout/Measurable;", "getEllipsis", "()Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/Placeable;", "getPlaceable", "()Landroidx/compose/ui/layout/Placeable;", "J", "getEllipsisSize-OO21N7I", "()J", "Z", "getPlaceEllipsisOnLastContentLine", "()Z", "setPlaceEllipsisOnLastContentLine", "(Z)V", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class WrapEllipsisInfo {
        public static final int $stable = 8;
        private final Measurable ellipsis;
        private final long ellipsisSize;
        private boolean placeEllipsisOnLastContentLine;
        private final Placeable placeable;

        public /* synthetic */ WrapEllipsisInfo(Measurable measurable, Placeable placeable, long j5, boolean z10, e eVar) {
            this(measurable, placeable, j5, z10);
        }

        public final Measurable getEllipsis() {
            return this.ellipsis;
        }

        /* renamed from: getEllipsisSize-OO21N7I, reason: not valid java name and from getter */
        public final long getEllipsisSize() {
            return this.ellipsisSize;
        }

        public final boolean getPlaceEllipsisOnLastContentLine() {
            return this.placeEllipsisOnLastContentLine;
        }

        public final Placeable getPlaceable() {
            return this.placeable;
        }

        public final void setPlaceEllipsisOnLastContentLine(boolean z10) {
            this.placeEllipsisOnLastContentLine = z10;
        }

        private WrapEllipsisInfo(Measurable measurable, Placeable placeable, long j5, boolean z10) {
            this.ellipsis = measurable;
            this.placeable = placeable;
            this.ellipsisSize = j5;
            this.placeEllipsisOnLastContentLine = z10;
        }

        public /* synthetic */ WrapEllipsisInfo(Measurable measurable, Placeable placeable, long j5, boolean z10, int i, e eVar) {
            this(measurable, placeable, j5, (i & 8) != 0 ? true : z10, null);
        }
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/layout/FlowLayoutBuildingBlocks$WrapInfo;", "", "isLastItemInLine", "", "isLastItemInContainer", "(ZZ)V", "()Z", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class WrapInfo {
        public static final int $stable = 0;
        private final boolean isLastItemInContainer;
        private final boolean isLastItemInLine;

        /* JADX WARN: Illegal instructions before constructor call */
        public WrapInfo() {
            boolean z10 = false;
            this(z10, z10, 3, null);
        }

        /* renamed from: isLastItemInContainer, reason: from getter */
        public final boolean getIsLastItemInContainer() {
            return this.isLastItemInContainer;
        }

        /* renamed from: isLastItemInLine, reason: from getter */
        public final boolean getIsLastItemInLine() {
            return this.isLastItemInLine;
        }

        public WrapInfo(boolean z10, boolean z11) {
            this.isLastItemInLine = z10;
            this.isLastItemInContainer = z11;
        }

        public /* synthetic */ WrapInfo(boolean z10, boolean z11, int i, e eVar) {
            this((i & 1) != 0 ? false : z10, (i & 2) != 0 ? false : z11);
        }
    }

    public /* synthetic */ FlowLayoutBuildingBlocks(int i, FlowLayoutOverflowState flowLayoutOverflowState, long j5, int i6, int i10, int i11, e eVar) {
        this(i, flowLayoutOverflowState, j5, i6, i10, i11);
    }

    public final WrapEllipsisInfo getWrapEllipsisInfo(WrapInfo wrapInfo, boolean hasNext, int lastContentLineIndex, int totalCrossAxisSize, int leftOverMainAxis, int nextIndexInLine) {
        WrapEllipsisInfo wrapEllipsisInfoEllipsisInfo$foundation_layout_release;
        if (!wrapInfo.getIsLastItemInContainer() || (wrapEllipsisInfoEllipsisInfo$foundation_layout_release = this.overflow.ellipsisInfo$foundation_layout_release(hasNext, lastContentLineIndex, totalCrossAxisSize)) == null) {
            return null;
        }
        wrapEllipsisInfoEllipsisInfo$foundation_layout_release.setPlaceEllipsisOnLastContentLine(lastContentLineIndex >= 0 && (nextIndexInLine == 0 || (leftOverMainAxis - IntIntPair.m27getFirstimpl(wrapEllipsisInfoEllipsisInfo$foundation_layout_release.getEllipsisSize()) >= 0 && nextIndexInLine < this.maxItemsInMainAxis)));
        return wrapEllipsisInfoEllipsisInfo$foundation_layout_release;
    }

    /* renamed from: getWrapInfo-OpUlnko, reason: not valid java name */
    public final WrapInfo m623getWrapInfoOpUlnko(boolean nextItemHasNext, int nextIndexInLine, long leftOver, IntIntPair nextSize, int lineIndex, int totalCrossAxisSize, int currentLineCrossAxisSize, boolean isWrappingRound, boolean isEllipsisWrap) {
        int i = totalCrossAxisSize + currentLineCrossAxisSize;
        if (nextSize == null) {
            return new WrapInfo(true, true);
        }
        if (this.overflow.getType$foundation_layout_release() != FlowLayoutOverflow.OverflowType.Visible && (lineIndex >= this.maxLines || IntIntPair.m28getSecondimpl(leftOver) - IntIntPair.m28getSecondimpl(nextSize.getPackedValue()) < 0)) {
            return new WrapInfo(true, true);
        }
        if (nextIndexInLine != 0 && (nextIndexInLine >= this.maxItemsInMainAxis || IntIntPair.m27getFirstimpl(leftOver) - IntIntPair.m27getFirstimpl(nextSize.getPackedValue()) < 0)) {
            return isWrappingRound ? new WrapInfo(true, true) : new WrapInfo(true, m623getWrapInfoOpUlnko(nextItemHasNext, 0, IntIntPair.m23constructorimpl(Constraints.m6797getMaxWidthimpl(this.constraints), (IntIntPair.m28getSecondimpl(leftOver) - this.crossAxisSpacing) - currentLineCrossAxisSize), IntIntPair.m20boximpl(IntIntPair.m23constructorimpl(IntIntPair.m27getFirstimpl(nextSize.getPackedValue()) - this.mainAxisSpacing, IntIntPair.m28getSecondimpl(nextSize.getPackedValue()))), lineIndex + 1, i, 0, true, false).getIsLastItemInContainer());
        }
        int iMax = Math.max(currentLineCrossAxisSize, IntIntPair.m28getSecondimpl(nextSize.getPackedValue())) + totalCrossAxisSize;
        IntIntPair intIntPairM628ellipsisSizeF35zmw$foundation_layout_release = isEllipsisWrap ? null : this.overflow.m628ellipsisSizeF35zmw$foundation_layout_release(nextItemHasNext, lineIndex, iMax);
        if (intIntPairM628ellipsisSizeF35zmw$foundation_layout_release != null) {
            intIntPairM628ellipsisSizeF35zmw$foundation_layout_release.getPackedValue();
            if (nextIndexInLine + 1 >= this.maxItemsInMainAxis || ((IntIntPair.m27getFirstimpl(leftOver) - IntIntPair.m27getFirstimpl(nextSize.getPackedValue())) - this.mainAxisSpacing) - IntIntPair.m27getFirstimpl(intIntPairM628ellipsisSizeF35zmw$foundation_layout_release.getPackedValue()) < 0) {
                if (isEllipsisWrap) {
                    return new WrapInfo(true, true);
                }
                WrapInfo wrapInfoM623getWrapInfoOpUlnko = m623getWrapInfoOpUlnko(false, 0, IntIntPair.m23constructorimpl(Constraints.m6797getMaxWidthimpl(this.constraints), (IntIntPair.m28getSecondimpl(leftOver) - this.crossAxisSpacing) - Math.max(currentLineCrossAxisSize, IntIntPair.m28getSecondimpl(nextSize.getPackedValue()))), intIntPairM628ellipsisSizeF35zmw$foundation_layout_release, lineIndex + 1, iMax, 0, true, true);
                return new WrapInfo(wrapInfoM623getWrapInfoOpUlnko.getIsLastItemInContainer(), wrapInfoM623getWrapInfoOpUlnko.getIsLastItemInContainer());
            }
        }
        return new WrapInfo(false, false);
    }

    private FlowLayoutBuildingBlocks(int i, FlowLayoutOverflowState flowLayoutOverflowState, long j5, int i6, int i10, int i11) {
        this.maxItemsInMainAxis = i;
        this.overflow = flowLayoutOverflowState;
        this.constraints = j5;
        this.maxLines = i6;
        this.mainAxisSpacing = i10;
        this.crossAxisSpacing = i11;
    }
}
