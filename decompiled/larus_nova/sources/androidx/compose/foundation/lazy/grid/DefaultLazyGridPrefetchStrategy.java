package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.foundation.lazy.layout.PrefetchScheduler;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010\u0015\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010\u0016\u001a\u00020\u0010*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\u001c\u0010\u0019\u001a\u00020\u0010*\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\u0014\u0010\u001c\u001a\u00020\u0003*\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\u0014\u0010\u001d\u001a\u00020\u0003*\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/lazy/grid/DefaultLazyGridPrefetchStrategy;", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;", "initialNestedPrefetchItemCount", "", "<init>", "(I)V", "lineToPrefetch", "currentLinePrefetchHandles", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "wasScrollingForward", "", "previousPassItemCount", "previousPassDelta", "", "onScroll", "", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchScope;", "delta", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "onVisibleItemsUpdated", "onNestedPrefetch", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "firstVisibleItemIndex", "evaluatePrefetchForCancellation", "currentPrefetchingLineIndex", "scrollingForward", "calculateLineIndexToPrefetch", "calculateClosestNextItemToPrefetch", "resetPrefetchState", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DefaultLazyGridPrefetchStrategy implements LazyGridPrefetchStrategy {
    private final MutableVector<LazyLayoutPrefetchState.PrefetchHandle> currentLinePrefetchHandles;
    private final int initialNestedPrefetchItemCount;
    private int lineToPrefetch;
    private float previousPassDelta;
    private int previousPassItemCount;
    private boolean wasScrollingForward;

    public DefaultLazyGridPrefetchStrategy() {
        int r100 = 0;
        this(r100, 1, null);
    }

    private final void resetPrefetchState() {
        this.lineToPrefetch = -1;
        MutableVector<LazyLayoutPrefetchState.PrefetchHandle> r100 = this.currentLinePrefetchHandles;
        LazyLayoutPrefetchState.PrefetchHandle[] r101 = r100.content;
        int r102 = r100.getSize();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        r101[r103].cancel();
        r103 = r103 + 1;
        goto L3
    L5:
        this.currentLinePrefetchHandles.clear();
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy
    public final /* synthetic */ PrefetchScheduler getPrefetchScheduler() {
        return LazyGridPrefetchStrategy.CC.$default$getPrefetchScheduler(this);
    }

    public DefaultLazyGridPrefetchStrategy(int r100) {
        this.initialNestedPrefetchItemCount = r100;
        this.lineToPrefetch = -1;
        this.currentLinePrefetchHandles = new MutableVector(new LazyLayoutPrefetchState.PrefetchHandle[16], 0);
        this.previousPassItemCount = -1;
    }

    private final int calculateClosestNextItemToPrefetch(LazyGridLayoutInfo r100, boolean r101) {
        if (r101 == false) goto L5;
        return ((LazyGridItemInfo) CollectionsKt.last(r100.getVisibleItemsInfo())).getIndex() + 1;
    L5:
        return ((LazyGridItemInfo) CollectionsKt.first(r100.getVisibleItemsInfo())).getIndex() - 1;
    }

    private final int calculateLineIndexToPrefetch(LazyGridLayoutInfo r100, boolean r101) {
        if (r101 == false) goto L8;
        LazyGridItemInfo r102 = (LazyGridItemInfo) CollectionsKt.last(r100.getVisibleItemsInfo());
        if (r100.getOrientation() != Orientation.Vertical) goto L6;
        int r103 = r102.getRow();
    L14:
        return r103 + 1;
    L6:
        r103 = r102.getColumn();
        goto L14
    L8:
        LazyGridItemInfo r104 = (LazyGridItemInfo) CollectionsKt.first(r100.getVisibleItemsInfo());
        if (r100.getOrientation() != Orientation.Vertical) goto L11;
        int r105 = r104.getRow();
    L13:
        return r105 - 1;
    L11:
        r105 = r104.getColumn();
        goto L13
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy
    public void onNestedPrefetch(NestedPrefetchScope r100, int r101) {
        if (r100.getNestedPrefetchItemCount() != (-1)) goto L5;
        int r102 = this.initialNestedPrefetchItemCount;
    L6:
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L9;
        r100.schedulePrecomposition(r101 + r103);
        r103 = r103 + 1;
        goto L7
    L9:
        return;
    L5:
        r102 = r100.getNestedPrefetchItemCount();
        goto L6
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy
    public void onVisibleItemsUpdated(LazyGridPrefetchScope r100, LazyGridLayoutInfo r101) {
        evaluatePrefetchForCancellation(r101, this.lineToPrefetch, this.wasScrollingForward);
        int r102 = r101.getTotalItemsCount();
        int r103 = this.previousPassItemCount;
        if (r103 == (-1)) goto L31;
        boolean r104 = true;
        if (this.previousPassDelta != 0.0f) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L31;
        if (r103 == r102) goto L31;
        if ((!r101.getVisibleItemsInfo().isEmpty()) == false) goto L31;
        if (this.previousPassDelta >= 0.0f) goto L15;
        boolean r106 = true;
    L16:
        int r107 = calculateLineIndexToPrefetch(r101, r106);
        if (this.previousPassDelta >= 0.0f) goto L19;
        boolean r108 = true;
    L20:
        int r109 = calculateClosestNextItemToPrefetch(r101, r108);
        if (r109 >= 0) goto L23;
    L25:
        r104 = false;
    L26:
        if (r104 == false) goto L31;
        if (r107 == this.lineToPrefetch) goto L31;
        if (r107 < 0) goto L31;
        this.lineToPrefetch = r107;
        this.currentLinePrefetchHandles.clear();
        MutableVector<LazyLayoutPrefetchState.PrefetchHandle> r110 = this.currentLinePrefetchHandles;
        r110.addAll(r110.getSize(), r100.scheduleLinePrefetch(r107));
        goto L31
    L23:
        if (r109 >= r101.getTotalItemsCount()) goto L25;
    L19:
        r108 = false;
        goto L20
    L15:
        r106 = false;
        goto L16
    L7:
        r105 = false;
    L31:
        this.previousPassItemCount = r102;
    }

    public /* synthetic */ DefaultLazyGridPrefetchStrategy(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 2;
    L5:
        this(r100);
    }

    private final void evaluatePrefetchForCancellation(LazyGridLayoutInfo r100, int r101, boolean r102) {
        if (r101 != (-1)) goto L5;
        return;
    L5:
        if ((!r100.getVisibleItemsInfo().isEmpty()) == true) goto L7;
        return;
    L7:
        if (r101 == calculateLineIndexToPrefetch(r100, r102)) goto L12;
        resetPrefetchState();
        return;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy
    public void onScroll(LazyGridPrefetchScope r100, float r101, LazyGridLayoutInfo r110) {
        boolean r102 = true;
        if ((!r110.getVisibleItemsInfo().isEmpty()) == false) goto L35;
        int r103 = 0;
        if (r101 >= 0.0f) goto L7;
        boolean r104 = true;
    L8:
        int r105 = calculateLineIndexToPrefetch(r110, r104);
        int r106 = calculateClosestNextItemToPrefetch(r110, r104);
        if (r106 >= 0) goto L11;
    L13:
        r102 = false;
    L14:
        if (r102 == false) goto L35;
        if (r105 == this.lineToPrefetch) goto L24;
        if (r105 < 0) goto L24;
        if (this.wasScrollingForward == r104) goto L23;
        MutableVector<LazyLayoutPrefetchState.PrefetchHandle> r107 = this.currentLinePrefetchHandles;
        LazyLayoutPrefetchState.PrefetchHandle[] r108 = r107.content;
        int r109 = r107.getSize();
        int r111 = 0;
    L21:
        if (r111 >= r109) goto L23;
        r108[r111].cancel();
        r111 = r111 + 1;
    L23:
        this.wasScrollingForward = r104;
        this.lineToPrefetch = r105;
        this.currentLinePrefetchHandles.clear();
        MutableVector<LazyLayoutPrefetchState.PrefetchHandle> r112 = this.currentLinePrefetchHandles;
        r112.addAll(r112.getSize(), r100.scheduleLinePrefetch(r105));
    L24:
        if (r104 == false) goto L31;
        LazyGridItemInfo r113 = (LazyGridItemInfo) CollectionsKt.last(r110.getVisibleItemsInfo());
        int r114 = LazyGridSnapLayoutInfoProviderKt.sizeOnMainAxis(r113, r110.getOrientation());
        if ((((LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(r113, r110.getOrientation()) + r114) + r110.getMainAxisItemSpacing()) - r110.getViewportEndOffset()) >= (-r101)) goto L35;
        MutableVector<LazyLayoutPrefetchState.PrefetchHandle> r115 = this.currentLinePrefetchHandles;
        LazyLayoutPrefetchState.PrefetchHandle[] r116 = r115.content;
        int r117 = r115.getSize();
    L28:
        if (r103 >= r117) goto L35;
        r116[r103].markAsUrgent();
        r103 = r103 + 1;
        goto L28
    L31:
        if ((r110.getViewportStartOffset() - LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis((LazyGridItemInfo) CollectionsKt.first(r110.getVisibleItemsInfo()), r110.getOrientation())) >= r101) goto L35;
        MutableVector<LazyLayoutPrefetchState.PrefetchHandle> r118 = this.currentLinePrefetchHandles;
        LazyLayoutPrefetchState.PrefetchHandle[] r119 = r118.content;
        int r120 = r118.getSize();
    L33:
        if (r103 >= r120) goto L35;
        r119[r103].markAsUrgent();
        r103 = r103 + 1;
        goto L33
    L11:
        if (r106 >= r110.getTotalItemsCount()) goto L13;
    L7:
        r104 = false;
    L35:
        this.previousPassDelta = r101;
    }
}
