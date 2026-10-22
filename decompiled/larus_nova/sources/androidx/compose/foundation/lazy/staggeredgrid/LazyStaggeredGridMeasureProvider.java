package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b!\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJO\u0010!\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010#2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010\u001a\u001a\u00020\u000eH&¢\u0006\u0004\b(\u0010)R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006*"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItemProvider;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "isVertical", "", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "measureScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "<init>", "(ZLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;)V", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "slot", "", "span", "childConstraints-JhjzzOo", "(II)J", "getAndMeasure", "index", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "getAndMeasure-jy6DScQ", "(IJ)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "lane", "constraints", "getAndMeasure--hBUhpc", "(IIIJ)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "createItem", "key", "", "contentType", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "createItem-pitSLOA", "(IIILjava/lang/Object;Ljava/lang/Object;Ljava/util/List;J)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class LazyStaggeredGridMeasureProvider extends LazyLayoutMeasuredItemProvider<LazyStaggeredGridMeasuredItem> {
    public static final int $stable = 8;
    private final boolean isVertical;
    private final LazyStaggeredGridItemProvider itemProvider;
    private final LazyLayoutMeasureScope measureScope;
    private final LazyStaggeredGridSlots resolvedSlots;

    /* JADX INFO: renamed from: createItem-pitSLOA */
    public abstract LazyStaggeredGridMeasuredItem mo944createItempitSLOA(int r100, int r101, int r102, Object r103, Object r104, List<? extends Placeable> r105, long r106);

    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.itemProvider.getKeyIndexMap();
    }

    /* JADX INFO: renamed from: childConstraints-JhjzzOo, reason: not valid java name */
    private final long m949childConstraintsJhjzzOo(int r100, int r101) {
        if (r101 != 1) goto L5;
        int r102 = this.resolvedSlots.getSizes()[r100];
    L7:
        if (this.isVertical == false) goto L10;
        return Constraints.Companion.m7499fixedWidthOenEA2s(r102);
    L10:
        return Constraints.Companion.m7498fixedHeightOenEA2s(r102);
    L5:
        int r103 = this.resolvedSlots.getPositions()[r100];
        int r104 = (r100 + r101) - 1;
        r102 = (this.resolvedSlots.getPositions()[r104] + this.resolvedSlots.getSizes()[r104]) - r103;
        goto L7
    }

    /* JADX INFO: renamed from: getAndMeasure-jy6DScQ, reason: not valid java name */
    public final LazyStaggeredGridMeasuredItem m950getAndMeasurejy6DScQ(int r110, long r111) {
        Object r100 = this.itemProvider.getKey(r110);
        Object r101 = this.itemProvider.getContentType(r110);
        int r102 = this.resolvedSlots.getSizes().length;
        int r103 = (int) (r111 >> 32);
        int r104 = RangesKt.coerceAtMost(r103, r102 - 1);
        int r105 = RangesKt.coerceAtMost(((int) (r111 & BodyPartID.bodyIdMax)) - r103, r102 - r104);
        long r106 = m949childConstraintsJhjzzOo(r104, r105);
        return mo944createItempitSLOA(r110, r104, r105, r100, r101, m899getPlaceables3p2s80s(this.measureScope, r110, r106), r106);
    }

    public LazyStaggeredGridMeasureProvider(boolean r100, LazyStaggeredGridItemProvider r101, LazyLayoutMeasureScope r102, LazyStaggeredGridSlots r103) {
        this.isVertical = r100;
        this.itemProvider = r101;
        this.measureScope = r102;
        this.resolvedSlots = r103;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider
    /* JADX INFO: renamed from: getAndMeasure--hBUhpc */
    public LazyStaggeredGridMeasuredItem mo843getAndMeasurehBUhpc(int r110, int r111, int r112, long r113) {
        return mo944createItempitSLOA(r110, r111, r112, this.itemProvider.getKey(r110), this.itemProvider.getContentType(r110), m899getPlaceables3p2s80s(this.measureScope, r110, r113), r113);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider
    /* JADX INFO: renamed from: getAndMeasure--hBUhpc */
    public /* bridge */ /* synthetic */ LazyLayoutMeasuredItem mo843getAndMeasurehBUhpc(int r100, int r101, int r102, long r103) {
        return mo843getAndMeasurehBUhpc(r100, r101, r102, r103);
    }
}
