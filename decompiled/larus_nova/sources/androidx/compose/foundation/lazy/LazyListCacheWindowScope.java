package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt;
import androidx.compose.foundation.lazy.layout.CacheWindowScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.ui.unit.Density;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010)\u001a\u00020\u00112\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020,0+H\u0016J\u0010\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0011H\u0016J\u0010\u00101\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0011H\u0016J\u0010\u00102\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0011H\u0016J\b\u00103\u001a\u00020\u0011H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013R\u0014\u0010\u001e\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013R\u0014\u0010 \u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0013R\u0016\u0010\"\u001a\u0004\u0018\u00010#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010-\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0013¨\u00064"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListCacheWindowScope;", "Landroidx/compose/foundation/lazy/layout/CacheWindowScope;", "<init>", "()V", "layoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "setLayoutInfo", "(Landroidx/compose/foundation/lazy/LazyListLayoutInfo;)V", "prefetchScope", "Landroidx/compose/foundation/lazy/LazyListPrefetchScope;", "getPrefetchScope", "()Landroidx/compose/foundation/lazy/LazyListPrefetchScope;", "setPrefetchScope", "(Landroidx/compose/foundation/lazy/LazyListPrefetchScope;)V", "totalItemsCount", "", "getTotalItemsCount", "()I", "hasVisibleItems", "", "getHasVisibleItems", "()Z", "mainAxisExtraSpaceStart", "getMainAxisExtraSpaceStart", "mainAxisExtraSpaceEnd", "getMainAxisExtraSpaceEnd", "firstVisibleLineIndex", "getFirstVisibleLineIndex", "lastVisibleLineIndex", "getLastVisibleLineIndex", "mainAxisViewportSize", "getMainAxisViewportSize", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "schedulePrefetch", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "lineIndex", "onItemPrefetched", "Lkotlin/Function2;", "", "visibleLineCount", "getVisibleLineCount", "getVisibleItemSize", "indexInVisibleLines", "getVisibleItemLine", "getLastIndexInLine", "getLastLineIndex", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyListCacheWindowScope implements CacheWindowScope {
    public static final int $stable = 8;
    public LazyListLayoutInfo layoutInfo;
    public LazyListPrefetchScope prefetchScope;

    public LazyListCacheWindowScope() {
    }

    public static /* synthetic */ Unit a(Function2 r100, LazyListPrefetchResultScope r101) {
        return schedulePrefetch$lambda$0(r100, r101);
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getLastIndexInLine(int r100) {
        return r100;
    }

    public final LazyListLayoutInfo getLayoutInfo() {
        LazyListLayoutInfo r100 = this.layoutInfo;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("layoutInfo");
        return null;
    }

    public final LazyListPrefetchScope getPrefetchScope() {
        LazyListPrefetchScope r100 = this.prefetchScope;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("prefetchScope");
        return null;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public Density getDensity() {
        LazyListLayoutInfo r100 = getLayoutInfo();
        if ((r100 instanceof LazyListMeasureResult) == false) goto L5;
        LazyListMeasureResult r101 = (LazyListMeasureResult) r100;
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
        return ((LazyListItemInfo) CollectionsKt.first(getLayoutInfo().getVisibleItemsInfo())).getIndex();
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public boolean getHasVisibleItems() {
        return !getLayoutInfo().getVisibleItemsInfo().isEmpty();
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getLastLineIndex() {
        if (getTotalItemsCount() != 0) goto L7;
        return -1;
    L7:
        return getTotalItemsCount() - 1;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getLastVisibleLineIndex() {
        return ((LazyListItemInfo) CollectionsKt.last(getLayoutInfo().getVisibleItemsInfo())).getIndex();
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getMainAxisExtraSpaceEnd() {
        LazyListItemInfo r100 = (LazyListItemInfo) CollectionsKt.last(getLayoutInfo().getVisibleItemsInfo());
        return Math.abs(((r100.getOffset() + r100.getSize()) + getLayoutInfo().getMainAxisItemSpacing()) - getLayoutInfo().getViewportEndOffset());
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getMainAxisExtraSpaceStart() {
        return Math.abs(RangesKt.coerceAtMost(((LazyListItemInfo) CollectionsKt.first(getLayoutInfo().getVisibleItemsInfo())).getOffset() + getLayoutInfo().getBeforeContentPadding(), 0));
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getMainAxisViewportSize() {
        return LazyListSnapLayoutInfoProviderKt.getSingleAxisViewportSize(getLayoutInfo());
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getTotalItemsCount() {
        return getLayoutInfo().getTotalItemsCount();
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getVisibleLineCount() {
        return getLayoutInfo().getVisibleItemsInfo().size();
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getVisibleItemLine(int r100) {
        return ((LazyListItemInfo) ListProtector.get(getLayoutInfo().getVisibleItemsInfo(), r100)).getIndex();
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public int getVisibleItemSize(int r100) {
        return ((LazyListItemInfo) ListProtector.get(getLayoutInfo().getVisibleItemsInfo(), r100)).getSize();
    }

    public final void setLayoutInfo(LazyListLayoutInfo r100) {
        this.layoutInfo = r100;
    }

    public final void setPrefetchScope(LazyListPrefetchScope r100) {
        this.prefetchScope = r100;
    }

    private static final Unit schedulePrefetch$lambda$0(Function2 r100, LazyListPrefetchResultScope r101) {
        r100.invoke(Integer.valueOf(r101.getIndex()), Integer.valueOf(r101.getMainAxisSize()));
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.lazy.layout.CacheWindowScope
    public List<LazyLayoutPrefetchState.PrefetchHandle> schedulePrefetch(int r100, final Function2<? super Integer, ? super Integer, Unit> r101) {
        return CollectionsKt.listOf(getPrefetchScope().schedulePrefetch(r100, new g(r101)));
    }
}
