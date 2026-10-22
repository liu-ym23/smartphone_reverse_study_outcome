package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.ui.unit.IntOffset;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001aD\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0000\"\u0018\u0010\t\u001a\u00020\u0005*\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\rj\b\u0012\u0004\u0012\u00020\u0003`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"updatedVisibleItems", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "firstVisibleIndex", "", "lastVisibleIndex", "positionedItems", "stickingItems", "mainAxisOffset", "getMainAxisOffset", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "LazyLayoutMeasuredItemIndexComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyLayoutMeasuredItemKt {
    private static final Comparator<LazyLayoutMeasuredItem> LazyLayoutMeasuredItemIndexComparator = null;

    public static /* synthetic */ int a(LazyLayoutMeasuredItem r100, LazyLayoutMeasuredItem r101) {
        return LazyLayoutMeasuredItemIndexComparator$lambda$2(r100, r101);
    }

    static {
        LazyLayoutMeasuredItemIndexComparator = new t();
    }

    private static final int getMainAxisOffset(LazyLayoutMeasuredItem r100) {
        long r101 = r100.mo841getOffsetBjo55l4(0);
        if (r100.isVertical() == false) goto L6;
        return IntOffset.m7677getYimpl(r101);
    L6:
        return IntOffset.m7676getXimpl(r101);
    }

    private static final int LazyLayoutMeasuredItemIndexComparator$lambda$2(LazyLayoutMeasuredItem r100, LazyLayoutMeasuredItem r101) {
        return Intrinsics.compare(r100.getIndex(), r101.getIndex());
    }

    public static final <T extends LazyLayoutMeasuredItem> List<T> updatedVisibleItems(int r100, int r101, List<? extends T> r102, List<? extends T> r103) {
        if (r102.isEmpty() == true) goto L5;
        PersistentList r104 = (List<T>) CollectionsKt.toMutableList(r103);
        int r105 = r102.size();
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L16;
        LazyLayoutMeasuredItem r107 = (LazyLayoutMeasuredItem) ListProtector.get(r102, r106);
        int r108 = r107.getIndex();
        if (r100 > r108) goto L12;
        if (r108 > r101) goto L12;
        boolean r109 = true;
    L13:
        if (r109 == false) goto L15;
        r104.add(r107);
    L15:
        r106 = r106 + 1;
    L12:
        r109 = false;
        goto L13
    L16:
        CollectionsKt.sortWith(r104, LazyLayoutMeasuredItemIndexComparator);
        return r104;
    L5:
        return CollectionsKt.emptyList();
    }
}
