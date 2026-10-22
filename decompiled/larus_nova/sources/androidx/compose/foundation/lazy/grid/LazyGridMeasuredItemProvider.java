package androidx.compose.foundation.lazy.grid;

import androidx.collection.IntList;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b!\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ/\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J5\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J_\u0010\u001e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH&¢\u0006\u0004\b&\u0010'R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006("}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItemProvider;", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "measureScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "defaultMainAxisSpacing", "", "<init>", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;I)V", "getAndMeasure", "index", "lane", "span", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getAndMeasure--hBUhpc", "(IIIJ)Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "mainAxisSpacing", "getAndMeasure-m8Kt_7k", "(IJIII)Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "getKeyIndexMap", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "headerIndices", "Landroidx/collection/IntList;", "getHeaderIndices", "()Landroidx/collection/IntList;", "createItem", "key", "", "contentType", "crossAxisSize", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "createItem-O3s9Psw", "(ILjava/lang/Object;Ljava/lang/Object;IILjava/util/List;JII)Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class LazyGridMeasuredItemProvider extends LazyLayoutMeasuredItemProvider<LazyGridMeasuredItem> {
    public static final int $stable = 8;
    private final int defaultMainAxisSpacing;
    private final LazyGridItemProvider itemProvider;
    private final LazyLayoutMeasureScope measureScope;

    /* JADX INFO: renamed from: createItem-O3s9Psw */
    public abstract LazyGridMeasuredItem mo863createItemO3s9Psw(int r100, Object r101, Object r102, int r103, int r104, List<? extends Placeable> r105, long r106, int r107, int r110);

    public final IntList getHeaderIndices() {
        return this.itemProvider.getHeaderIndexes();
    }

    public final LazyLayoutKeyIndexMap getKeyIndexMap() {
        return this.itemProvider.getKeyIndexMap();
    }

    public LazyGridMeasuredItemProvider(LazyGridItemProvider r100, LazyLayoutMeasureScope r101, int r102) {
        this.itemProvider = r100;
        this.measureScope = r101;
        this.defaultMainAxisSpacing = r102;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider
    /* JADX INFO: renamed from: getAndMeasure--hBUhpc */
    public LazyGridMeasuredItem mo843getAndMeasurehBUhpc(int r100, int r101, int r110, long r111) {
        return m868getAndMeasurem8Kt_7k(r100, r111, r101, r110, this.defaultMainAxisSpacing);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemProvider
    /* JADX INFO: renamed from: getAndMeasure--hBUhpc */
    public /* bridge */ /* synthetic */ LazyLayoutMeasuredItem mo843getAndMeasurehBUhpc(int r100, int r101, int r102, long r103) {
        return mo843getAndMeasurehBUhpc(r100, r101, r102, r103);
    }

    /* JADX INFO: renamed from: getAndMeasure-m8Kt_7k, reason: not valid java name */
    public final LazyGridMeasuredItem m868getAndMeasurem8Kt_7k(int r110, long r111, int r112, int r113, int r114) {
        Object r100 = this.itemProvider.getKey(r110);
        Object r101 = this.itemProvider.getContentType(r110);
        List<Placeable> r102 = m899getPlaceables3p2s80s(this.measureScope, r110, r111);
        if (Constraints.m7485getHasFixedWidthimpl(r111) == false) goto L7;
        int r103 = Constraints.m7489getMinWidthimpl(r111);
    L11:
        return mo863createItemO3s9Psw(r110, r100, r101, r103, r114, r102, r111, r112, r113);
    L7:
        if (Constraints.m7484getHasFixedHeightimpl(r111) == true) goto L9;
        InlineClassHelperKt.throwIllegalArgumentException("does not have fixed height");
    L9:
        r103 = Constraints.m7488getMinHeightimpl(r111);
        goto L11
    }
}
