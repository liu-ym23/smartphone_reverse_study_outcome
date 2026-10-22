package androidx.compose.foundation.lazy;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"visibleItemsAverageSize", "", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyListLayoutInfoKt {
    public static final int visibleItemsAverageSize(LazyListLayoutInfo r100) {
        List<LazyListItemInfo> r101 = r100.getVisibleItemsInfo();
        int r102 = r101.size();
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r102) goto L6;
        r104 = r104 + ((LazyListItemInfo) ListProtector.get(r101, r103)).getSize();
        r103 = r103 + 1;
        goto L3
    L6:
        return (r104 / r101.size()) + r100.getMainAxisItemSpacing();
    }
}
