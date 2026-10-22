package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.Constraints;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b!\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007J9\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00072\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010&\u001a\u00020\u0007H&¢\u0006\u0002\u0010'R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006("}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "", "isVertical", "", "slots", "Landroidx/compose/foundation/lazy/grid/LazyGridSlots;", "gridItemsCount", "", "spaceBetweenLines", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "<init>", "(ZLandroidx/compose/foundation/lazy/grid/LazyGridSlots;IILandroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;)V", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "startSlot", "span", "childConstraints-JhjzzOo$foundation_release", "(II)J", "spanOf", "index", "getAndMeasure", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "lineIndex", "keepAround", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "createLine", "items", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "spans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "mainAxisSpacing", "(I[Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;Ljava/util/List;I)Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class LazyGridMeasuredLineProvider {
    public static final int $stable = 8;
    private final int gridItemsCount;
    private final boolean isVertical;
    private final LazyGridMeasuredItemProvider measuredItemProvider;
    private final LazyGridSlots slots;
    private final int spaceBetweenLines;
    private final LazyGridSpanLayoutProvider spanLayoutProvider;

    public abstract LazyGridMeasuredLine createLine(int r100, LazyGridMeasuredItem[] r101, List<GridItemSpan> r102, int r103);

    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.measuredItemProvider.getKeyIndexMap();
    }

    public final LazyGridMeasuredLine getAndMeasure(int r110) {
        LazyGridSpanLayoutProvider.LineConfiguration r100 = this.spanLayoutProvider.getLineConfiguration(r110);
        int r101 = r100.getSpans().size();
        int r102 = 0;
        if (r101 != 0) goto L5;
    L8:
        int r103 = 0;
    L9:
        LazyGridMeasuredItem[] r111 = new LazyGridMeasuredItem[r101];
        int r112 = 0;
    L10:
        if (r102 >= r101) goto L13;
        int r113 = GridItemSpan.m852getCurrentLineSpanimpl(((GridItemSpan) ListProtector.get(r100.getSpans(), r102)).m855unboximpl());
        long r104 = m869childConstraintsJhjzzOo$foundation_release(r112, r113);
        LazyGridMeasuredItem r105 = this.measuredItemProvider.m868getAndMeasurem8Kt_7k(r100.getFirstItemIndex() + r102, r104, r112, r113, r103);
        r112 = r112 + r113;
        Unit r106 = Unit.INSTANCE;
        r111[r102] = r105;
        r102 = r102 + 1;
        goto L10
    L13:
        return createLine(r110, r111, r100.getSpans(), r103);
    L5:
        if ((r100.getFirstItemIndex() + r101) == this.gridItemsCount) goto L8;
        r103 = this.spaceBetweenLines;
        goto L9
    }

    public final LazyGridMeasuredLine keepAround(int r100) {
        return getAndMeasure(r100);
    }

    public final int spanOf(int r100) {
        LazyGridSpanLayoutProvider r101 = this.spanLayoutProvider;
        return r101.spanOf(r100, r101.getSlotsPerLine());
    }

    /* JADX INFO: renamed from: childConstraints-JhjzzOo$foundation_release, reason: not valid java name */
    public final long m869childConstraintsJhjzzOo$foundation_release(int r100, int r101) {
        if (r101 != 1) goto L5;
        int r102 = this.slots.getSizes()[r100];
    L6:
        int r103 = RangesKt.coerceAtLeast(r102, 0);
        if (this.isVertical == false) goto L10;
        return Constraints.Companion.m7499fixedWidthOenEA2s(r103);
    L10:
        return Constraints.Companion.m7498fixedHeightOenEA2s(r103);
    L5:
        int r104 = (r101 + r100) - 1;
        r102 = (this.slots.getPositions()[r104] + this.slots.getSizes()[r104]) - this.slots.getPositions()[r100];
        goto L6
    }

    public LazyGridMeasuredLineProvider(boolean r100, LazyGridSlots r101, int r102, int r103, LazyGridMeasuredItemProvider r104, LazyGridSpanLayoutProvider r105) {
        this.isVertical = r100;
        this.slots = r101;
        this.gridItemsCount = r102;
        this.spaceBetweenLines = r103;
        this.measuredItemProvider = r104;
        this.spanLayoutProvider = r105;
    }
}
