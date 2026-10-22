package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt;
import androidx.compose.foundation.lazy.layout.CacheWindowScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010)\u001a\u00020\u00112\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020,0+H\u0016J\u0010\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0011H\u0016J\u0010\u00101\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0011H\u0016J\u0010\u00105\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0011H\u0016J\b\u00106\u001a\u00020\u0011H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013R\u0014\u0010\u001e\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013R\u0014\u0010 \u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0013R\u0016\u0010\"\u001a\u0004\u0018\u00010#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010-\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0013R\u0015\u0010)\u001a\u00020\u0011*\u0002028F¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00067"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridCacheWindowScope;", "Landroidx/compose/foundation/lazy/layout/CacheWindowScope;", "<init>", "()V", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "setLayoutInfo", "(Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;)V", "prefetchScope", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchScope;", "getPrefetchScope", "()Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchScope;", "setPrefetchScope", "(Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchScope;)V", "totalItemsCount", "", "getTotalItemsCount", "()I", "hasVisibleItems", "", "getHasVisibleItems", "()Z", "mainAxisExtraSpaceStart", "getMainAxisExtraSpaceStart", "mainAxisExtraSpaceEnd", "getMainAxisExtraSpaceEnd", "firstVisibleLineIndex", "getFirstVisibleLineIndex", "lastVisibleLineIndex", "getLastVisibleLineIndex", "mainAxisViewportSize", "getMainAxisViewportSize", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "schedulePrefetch", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "lineIndex", "onItemPrefetched", "Lkotlin/Function2;", "", "visibleLineCount", "getVisibleLineCount", "getVisibleItemSize", "indexInVisibleLines", "getVisibleItemLine", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "getLineIndex", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;)I", "getLastIndexInLine", "getLastLineIndex", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class LazyGridCacheWindowScope implements CacheWindowScope {
    public LazyGridLayoutInfo layoutInfo;
    public LazyGridPrefetchScope prefetchScope;

    public LazyGridCacheWindowScope() {
    }

    public static /* synthetic */ Unit a(Function2 r100, int r101, LazyGridPrefetchResultScope r102) {
        return schedulePrefetch$lambda$1(r100, r101, r102);
    }

    public final LazyGridLayoutInfo getLayoutInfo() {
        LazyGridLayoutInfo r100 = this.layoutInfo;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("layoutInfo");
        return null;
    }

    public final LazyGridPrefetchScope getPrefetchScope() {
        LazyGridPrefetchScope r100 = this.prefetchScope;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("prefetchScope");
        return null;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public Density getDensity() {
        LazyGridLayoutInfo r100 = getLayoutInfo();
        if ((r100 instanceof LazyGridMeasureResult) == false) goto L5;
        LazyGridMeasureResult r101 = (LazyGridMeasureResult) r100;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.getDensity();
    L5:
        r101 = null;
        goto L6
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getFirstVisibleLineIndex() {
        return getLineIndex((LazyGridItemInfo) CollectionsKt.first(getLayoutInfo().getVisibleItemsInfo()));
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public boolean getHasVisibleItems() {
        return !getLayoutInfo().getVisibleItemsInfo().isEmpty();
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getLastLineIndex() {
        LazyGridLayoutInfo r100 = getLayoutInfo();
        if ((r100 instanceof LazyGridMeasureResult) == false) goto L5;
        LazyGridMeasureResult r101 = (LazyGridMeasureResult) r100;
    L7:
        if (r101 != null) goto L10;
        return -1;
    L10:
        if (getTotalItemsCount() != 0) goto L13;
        return -1;
    L13:
        return r101.getLineIndexProvider().invoke(Integer.valueOf(getTotalItemsCount() - 1)).intValue();
    L5:
        r101 = null;
        goto L7
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getLastVisibleLineIndex() {
        return getLineIndex((LazyGridItemInfo) CollectionsKt.last(getLayoutInfo().getVisibleItemsInfo()));
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getMainAxisExtraSpaceEnd() {
        LazyGridItemInfo r100 = (LazyGridItemInfo) CollectionsKt.last(getLayoutInfo().getVisibleItemsInfo());
        return Math.abs(((LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(r100, getLayoutInfo().getOrientation()) + LazyGridSnapLayoutInfoProviderKt.sizeOnMainAxis(r100, getLayoutInfo().getOrientation())) + getLayoutInfo().getMainAxisItemSpacing()) - getLayoutInfo().getViewportEndOffset());
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getMainAxisExtraSpaceStart() {
        return Math.abs(RangesKt.coerceAtMost(LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis((LazyGridItemInfo) CollectionsKt.first(getLayoutInfo().getVisibleItemsInfo()), getLayoutInfo().getOrientation()) + getLayoutInfo().getBeforeContentPadding(), 0));
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getMainAxisViewportSize() {
        return LazyGridLayoutInfoKt.getSingleAxisViewportSize(getLayoutInfo());
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getTotalItemsCount() {
        return getLayoutInfo().getTotalItemsCount();
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getVisibleLineCount() {
        return (getLastVisibleLineIndex() - getFirstVisibleLineIndex()) + 1;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getLastIndexInLine(int r100) {
        LazyGridLayoutInfo r101 = getLayoutInfo();
        if ((r101 instanceof LazyGridMeasureResult) == false) goto L5;
        LazyGridMeasureResult r102 = (LazyGridMeasureResult) r101;
    L7:
        if (r102 != null) goto L9;
        return -1;
    L9:
        List<Pair<Integer, Constraints>> r103 = r102.getPrefetchInfoRetriever().invoke(Integer.valueOf(r100));
        if (r103.isEmpty() == false) goto L13;
        return -1;
    L13:
        return (((Number) ((Pair) CollectionsKt.first(r103)).getFirst()).intValue() + r103.size()) - 1;
    L5:
        r102 = null;
        goto L7
    }

    public final int getLineIndex(LazyGridItemInfo r100) {
        return LazyGridItemInfoKt.lineIndex(r100, getLayoutInfo().getOrientation());
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getVisibleItemLine(int r100) {
        return getFirstVisibleLineIndex() + r100;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getVisibleItemSize(int r100) {
        int r101 = r100 + getFirstVisibleLineIndex();
        List<LazyGridItemInfo> r102 = getLayoutInfo().getVisibleItemsInfo();
        ArrayList r103 = new ArrayList(r102.size());
        int r104 = r102.size();
        int r105 = 0;
        int r106 = 0;
    L3:
        if (r106 >= r104) goto L11;
        Object r107 = ListProtector.get(r102, r106);
        if (getLineIndex((LazyGridItemInfo) r107) != r101) goto L7;
        boolean r108 = true;
    L8:
        if (r108 == false) goto L10;
        r103.add(r107);
    L10:
        r106 = r106 + 1;
        goto L3
    L7:
        r108 = false;
        goto L8
    L11:
        int r109 = r103.size();
        int r110 = 0;
    L12:
        if (r105 >= r109) goto L14;
        r110 = Math.max(LazyGridSnapLayoutInfoProviderKt.sizeOnMainAxis((LazyGridItemInfo) ListProtector.get(r103, r105), getLayoutInfo().getOrientation()), r110);
        r105 = r105 + 1;
        goto L12
    L14:
        return r110;
    }

    public final void setLayoutInfo(LazyGridLayoutInfo r100) {
        this.layoutInfo = r100;
    }

    public final void setPrefetchScope(LazyGridPrefetchScope r100) {
        this.prefetchScope = r100;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public List<LazyLayoutPrefetchState.PrefetchHandle> schedulePrefetch(final int r100, final Function2<? super Integer, ? super Integer, Unit> r101) {
        return getPrefetchScope().scheduleLinePrefetch(r100, new a(r101, r100));
    }

    private static final Unit schedulePrefetch$lambda$1(Function2 r100, int r101, LazyGridPrefetchResultScope r102) {
        int r103 = r102.getLineItemCount();
        int r104 = 0;
        int r105 = Integer.MIN_VALUE;
    L3:
        if (r104 >= r103) goto L5;
        r105 = ComparisonsKt.maxOf(r102.getMainAxisSize(r104), new int[0]);
        r104 = r104 + 1;
        goto L3
    L5:
        if (r105 == Integer.MIN_VALUE) goto L8;
        r100.invoke(Integer.valueOf(r101), Integer.valueOf(r105));
    L8:
        return Unit.INSTANCE;
    }
}
