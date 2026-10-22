package androidx.compose.foundation.lazy;

import D7.v;
import H4.o;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\u001aF\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0000¨\u0006\f"}, d2 = {"findOrComposeLazyListHeader", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "composedVisibleItems", "", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "headerIndexes", "", "", "beforeContentPadding", "layoutWidth", "layoutHeight", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyListHeadersKt {
    public static final LazyListMeasuredItem findOrComposeLazyListHeader(List<LazyListMeasuredItem> list, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, List<Integer> list2, int i, int i6, int i10) {
        int index = ((LazyListMeasuredItem) v.A0(list)).getIndex();
        int size = list2.size();
        int iIntValue = -1;
        int iIntValue2 = -1;
        int i11 = 0;
        while (i11 < size && list2.get(i11).intValue() <= index) {
            iIntValue2 = list2.get(i11).intValue();
            i11++;
            iIntValue = ((i11 < 0 || i11 > o.H(list2)) ? -1 : list2.get(i11)).intValue();
        }
        int size2 = list.size();
        int offset = Integer.MIN_VALUE;
        int offset2 = Integer.MIN_VALUE;
        int i12 = -1;
        for (int i13 = 0; i13 < size2; i13++) {
            LazyListMeasuredItem lazyListMeasuredItem = list.get(i13);
            if (lazyListMeasuredItem.getIndex() == iIntValue2) {
                offset = lazyListMeasuredItem.getOffset();
                i12 = i13;
            } else if (lazyListMeasuredItem.getIndex() == iIntValue) {
                offset2 = lazyListMeasuredItem.getOffset();
            }
        }
        if (iIntValue2 == -1) {
            return null;
        }
        LazyListMeasuredItem lazyListMeasuredItemM813getAndMeasure0kLqBqw$default = LazyListMeasuredItemProvider.m813getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, iIntValue2, 0L, 2, null);
        lazyListMeasuredItemM813getAndMeasure0kLqBqw$default.setNonScrollableItem(true);
        int iMax = offset != Integer.MIN_VALUE ? Math.max(-i, offset) : -i;
        if (offset2 != Integer.MIN_VALUE) {
            iMax = Math.min(iMax, offset2 - lazyListMeasuredItemM813getAndMeasure0kLqBqw$default.getSize());
        }
        lazyListMeasuredItemM813getAndMeasure0kLqBqw$default.position(iMax, i6, i10);
        if (i12 != -1) {
            list.set(i12, lazyListMeasuredItemM813getAndMeasure0kLqBqw$default);
            return lazyListMeasuredItemM813getAndMeasure0kLqBqw$default;
        }
        list.add(0, lazyListMeasuredItemM813getAndMeasure0kLqBqw$default);
        return lazyListMeasuredItemM813getAndMeasure0kLqBqw$default;
    }
}
