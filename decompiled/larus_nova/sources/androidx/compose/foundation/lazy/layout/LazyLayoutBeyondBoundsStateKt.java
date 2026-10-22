package androidx.compose.foundation.lazy.layout;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¨\u0006\b"}, d2 = {"calculateLazyLayoutPinnedIndices", "", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "pinnedItemList", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutBeyondBoundsStateKt {
    public static final List<Integer> calculateLazyLayoutPinnedIndices(LazyLayoutItemProvider r100, LazyLayoutPinnedItemList r101, LazyLayoutBeyondBoundsInfo r110) {
        if (r110.hasIntervals() == false) goto L5;
    L8:
        ArrayList r102 = new ArrayList();
        if (r110.hasIntervals() == false) goto L11;
        IntRange r103 = new IntRange(r110.getStart(), Math.min(r110.getEnd(), r100.getItemCount() - 1));
    L12:
        int r111 = r101.size();
        int r104 = 0;
    L13:
        if (r104 >= r111) goto L28;
        LazyLayoutPinnedItemList.PinnedItem r105 = (LazyLayoutPinnedItemList.PinnedItem) ListProtector.get(r101, r104);
        int r106 = LazyLayoutItemProviderKt.findIndexByKey(r100, r105.getKey(), r105.getIndex());
        int r107 = r103.getFirst();
        if (r106 > r103.getLast()) goto L18;
        if (r107 > r106) goto L18;
        boolean r108 = true;
    L19:
        if (r108 == true) goto L27;
        if (r106 >= 0) goto L22;
    L24:
        boolean r109 = false;
    L25:
        if (r109 == false) goto L27;
        r102.add(Integer.valueOf(r106));
        goto L27
    L22:
        if (r106 >= r100.getItemCount()) goto L24;
        r109 = true;
    L27:
        r104 = r104 + 1;
    L18:
        r108 = false;
        goto L19
    L28:
        int r112 = r103.getFirst();
        int r113 = r103.getLast();
        if (r112 > r113) goto L33;
    L30:
        r102.add(Integer.valueOf(r112));
        if (r112 == r113) goto L33;
        r112 = r112 + 1;
    L33:
        return r102;
    L11:
        r103 = IntRange.Companion.getEMPTY();
        goto L12
    L5:
        if (r101.isEmpty() == false) goto L8;
        return CollectionsKt.emptyList();
    }
}
