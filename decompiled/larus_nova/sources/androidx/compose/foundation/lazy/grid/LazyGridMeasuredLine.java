package androidx.compose.foundation.lazy.grid;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0001\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u001a\u001a\u00020\rJ)\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003¢\u0006\u0002\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012¨\u0006 "}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "", "index", "", "items", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "slots", "Landroidx/compose/foundation/lazy/grid/LazyGridSlots;", "spans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "isVertical", "", "mainAxisSpacing", "<init>", "(I[Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;Landroidx/compose/foundation/lazy/grid/LazyGridSlots;Ljava/util/List;ZI)V", "getIndex", "()I", "getItems", "()[Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "[Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "isEmpty", "position", "offset", "layoutWidth", "layoutHeight", "(III)[Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyGridMeasuredLine {
    public static final int $stable = 8;
    private final int index;
    private final boolean isVertical;
    private final LazyGridMeasuredItem[] items;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private final int mainAxisSpacing;
    private final LazyGridSlots slots;
    private final List<GridItemSpan> spans;

    public final boolean isEmpty() {
        if (this.items.length != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getIndex() {
        return this.index;
    }

    public final LazyGridMeasuredItem[] getItems() {
        return this.items;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    public final LazyGridMeasuredItem[] position(int r110, int r111, int r112) {
        LazyGridMeasuredItem[] r100 = this.items;
        int r101 = r100.length;
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r102 >= r101) goto L13;
        LazyGridMeasuredItem r105 = r100[r102];
        int r113 = r103 + 1;
        int r106 = GridItemSpan.m852getCurrentLineSpanimpl(((GridItemSpan) ListProtector.get(this.spans, r103)).m855unboximpl());
        int r107 = this.slots.getPositions()[r104];
        boolean r108 = this.isVertical;
        if (r108 == false) goto L7;
        int r114 = this.index;
    L8:
        if (r108 == false) goto L10;
        int r115 = r104;
    L11:
        r105.position(r110, r107, r111, r112, r114, r115);
        Unit r109 = Unit.INSTANCE;
        r104 = r104 + r106;
        r102 = r102 + 1;
        r103 = r113;
        goto L3
    L10:
        r115 = this.index;
        goto L11
    L7:
        r114 = r104;
        goto L8
    L13:
        return this.items;
    }

    public LazyGridMeasuredLine(int r100, LazyGridMeasuredItem[] r101, LazyGridSlots r102, List<GridItemSpan> r103, boolean r104, int r105) {
        this.index = r100;
        this.items = r101;
        this.slots = r102;
        this.spans = r103;
        this.isVertical = r104;
        this.mainAxisSpacing = r105;
        int r106 = r101.length;
        int r107 = 0;
        int r108 = 0;
    L3:
        if (r107 >= r106) goto L5;
        r108 = Math.max(r108, r101[r107].getMainAxisSize());
        r107 = r107 + 1;
        goto L3
    L5:
        this.mainAxisSize = r108;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(r108 + this.mainAxisSpacing, 0);
    }
}
