package androidx.compose.foundation.lazy.grid;

import D7.q;
import S7.k;
import Y7.f;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import g1.AbstractC1451a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\u001a¤\u0002\u00100\u001a\u00020-2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001c\u001a\u00020\u00002\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00000\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2$\u0010'\u001a \u0012\u0004\u0012\u00020\u0000\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000e0&0\u001d0%2*\u0010,\u001a&\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0%\u0012\u0004\u0012\u00020+0(H\u0000ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001aH\u00102\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00000\u001d2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00100%H\u0083\b¢\u0006\u0004\b2\u00103\u001a\u0093\u0001\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001a0=2\f\u00105\u001a\b\u0012\u0004\u0012\u0002040\u001d2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001d2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001d2\u0006\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b>\u0010?\u001a-\u0010C\u001a\u00020*\"\u0004\b\u0000\u0010@*\b\u0012\u0004\u0012\u00028\u00000=2\f\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000AH\u0002¢\u0006\u0004\bC\u0010D\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006E"}, d2 = {"", "itemsCount", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "measuredItemProvider", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenLines", "firstVisibleLineIndex", "firstVisibleLineScrollOffset", "", "scrollToBeConsumed", "Landroidx/compose/ui/unit/Constraints;", "constraints", "", "isVertical", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "horizontalArrangement", "reverseLayout", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "itemAnimator", "slotsPerLine", "", "pinnedItems", "Lm9/z;", "coroutineScope", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "placementScopeInvalidator", "Landroidx/compose/ui/graphics/GraphicsContext;", "graphicsContext", "Lkotlin/Function1;", "Lkotlin/Pair;", "prefetchInfoRetriever", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "LC7/r;", "Landroidx/compose/ui/layout/MeasureResult;", "layout", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "measureLazyGrid-OZKpZRA", "(ILandroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;Lm9/z;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;LS7/k;LS7/o;)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "measureLazyGrid", "filter", "calculateExtraItems", "(Ljava/util/List;Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;LS7/k;)Ljava/util/List;", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "lines", "itemsBefore", "itemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "firstLineScrollOffset", "", "calculateItemsOffsets", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;IIIIIZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;)Ljava/util/List;", ExifInterface.GPS_DIRECTION_TRUE, "", "arr", "addAllFromArray", "(Ljava/util/List;[Ljava/lang/Object;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridMeasureKt {
    private static final <T> void addAllFromArray(List<T> list, T[] tArr) {
        for (T t9 : tArr) {
            list.add(t9);
        }
    }

    @ExperimentalFoundationApi
    private static final List<LazyGridMeasuredItem> calculateExtraItems(List<Integer> list, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider, k kVar) {
        LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider2;
        int size = list.size();
        ArrayList arrayList = null;
        int i = 0;
        while (i < size) {
            int iIntValue = list.get(i).intValue();
            if (((Boolean) kVar.invoke(Integer.valueOf(iIntValue))).booleanValue()) {
                int iSpanOf = lazyGridMeasuredLineProvider.spanOf(iIntValue);
                lazyGridMeasuredItemProvider2 = lazyGridMeasuredItemProvider;
                LazyGridMeasuredItem lazyGridMeasuredItemMo814getAndMeasurehBUhpc = lazyGridMeasuredItemProvider2.mo814getAndMeasurehBUhpc(iIntValue, 0, iSpanOf, lazyGridMeasuredLineProvider.m845childConstraintsJhjzzOo$foundation_release(0, iSpanOf));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(lazyGridMeasuredItemMo814getAndMeasurehBUhpc);
            } else {
                lazyGridMeasuredItemProvider2 = lazyGridMeasuredItemProvider;
            }
            i++;
            lazyGridMeasuredItemProvider = lazyGridMeasuredItemProvider2;
        }
        return arrayList == null ? EmptyList.f4893a : arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15, types: [Y7.d] */
    private static final List<LazyGridMeasuredItem> calculateItemsOffsets(List<LazyGridMeasuredLine> list, List<LazyGridMeasuredItem> list2, List<LazyGridMeasuredItem> list3, int i, int i6, int i10, int i11, int i12, boolean z10, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z11, Density density) {
        int i13 = z10 ? i6 : i;
        boolean z12 = i10 < Math.min(i13, i11);
        if (z12 && i12 != 0) {
            throw new IllegalStateException("non-zero firstLineScrollOffset");
        }
        int size = list.size();
        int length = 0;
        for (int i14 = 0; i14 < size; i14++) {
            length += list.get(i14).getItems().length;
        }
        ArrayList arrayList = new ArrayList(length);
        if (!z12) {
            int size2 = list2.size() - 1;
            if (size2 >= 0) {
                int mainAxisSizeWithSpacings = i12;
                while (true) {
                    int i15 = size2 - 1;
                    LazyGridMeasuredItem lazyGridMeasuredItem = list2.get(size2);
                    mainAxisSizeWithSpacings -= lazyGridMeasuredItem.getMainAxisSizeWithSpacings();
                    lazyGridMeasuredItem.position(mainAxisSizeWithSpacings, 0, i, i6);
                    arrayList.add(lazyGridMeasuredItem);
                    if (i15 < 0) {
                        break;
                    }
                    size2 = i15;
                }
            }
            int size3 = list.size();
            int mainAxisSizeWithSpacings2 = i12;
            for (int i16 = 0; i16 < size3; i16++) {
                LazyGridMeasuredLine lazyGridMeasuredLine = list.get(i16);
                addAllFromArray(arrayList, lazyGridMeasuredLine.position(mainAxisSizeWithSpacings2, i, i6));
                mainAxisSizeWithSpacings2 += lazyGridMeasuredLine.getMainAxisSizeWithSpacings();
            }
            int size4 = list3.size();
            for (int i17 = 0; i17 < size4; i17++) {
                LazyGridMeasuredItem lazyGridMeasuredItem2 = list3.get(i17);
                lazyGridMeasuredItem2.position(mainAxisSizeWithSpacings2, 0, i, i6);
                arrayList.add(lazyGridMeasuredItem2);
                mainAxisSizeWithSpacings2 += lazyGridMeasuredItem2.getMainAxisSizeWithSpacings();
            }
        } else {
            if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("no items");
            }
            int size5 = list.size();
            int[] iArr = new int[size5];
            for (int i18 = 0; i18 < size5; i18++) {
                iArr[i18] = list.get(calculateItemsOffsets$reverseAware(i18, z11, size5)).getMainAxisSize();
            }
            int[] iArr2 = new int[size5];
            for (int i19 = 0; i19 < size5; i19++) {
                iArr2[i19] = 0;
            }
            if (z10) {
                if (vertical == null) {
                    throw new IllegalArgumentException("null verticalArrangement");
                }
                vertical.arrange(density, i13, iArr, iArr2);
            } else {
                if (horizontal == null) {
                    throw new IllegalArgumentException("null horizontalArrangement");
                }
                horizontal.arrange(density, i13, iArr, LayoutDirection.Ltr, iArr2);
            }
            f fVarO0 = q.o0(iArr2);
            f fVarS = fVarO0;
            if (z11) {
                fVarS = AbstractC1451a.S(fVarO0);
            }
            int i20 = fVarS.f1569a;
            int i21 = fVarS.b;
            int i22 = fVarS.c;
            if ((i22 > 0 && i20 <= i21) || (i22 < 0 && i21 <= i20)) {
                while (true) {
                    int mainAxisSize = iArr2[i20];
                    LazyGridMeasuredLine lazyGridMeasuredLine2 = list.get(calculateItemsOffsets$reverseAware(i20, z11, size5));
                    if (z11) {
                        mainAxisSize = (i13 - mainAxisSize) - lazyGridMeasuredLine2.getMainAxisSize();
                    }
                    addAllFromArray(arrayList, lazyGridMeasuredLine2.position(mainAxisSize, i, i6));
                    if (i20 == i21) {
                        break;
                    }
                    i20 += i22;
                }
            }
        }
        return arrayList;
    }

    private static final int calculateItemsOffsets$reverseAware(int i, boolean z10, int i6) {
        return !z10 ? i : (i6 - i) - 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:95:0x0208  */
    /* renamed from: measureLazyGrid-OZKpZRA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.foundation.lazy.grid.LazyGridMeasureResult m841measureLazyGridOZKpZRA(int r40, androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider r41, androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider r42, int r43, int r44, int r45, int r46, int r47, int r48, float r49, long r50, boolean r52, androidx.compose.foundation.layout.Arrangement.Vertical r53, androidx.compose.foundation.layout.Arrangement.Horizontal r54, boolean r55, androidx.compose.ui.unit.Density r56, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator<androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem> r57, int r58, java.util.List<java.lang.Integer> r59, m9.InterfaceC1733z r60, final androidx.compose.runtime.MutableState<C7.r> r61, androidx.compose.ui.graphics.GraphicsContext r62, S7.k r63, S7.o r64) {
        /*
            Method dump skipped, instructions count: 1110
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt.m841measureLazyGridOZKpZRA(int, androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider, androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider, int, int, int, int, int, int, float, long, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, boolean, androidx.compose.ui.unit.Density, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator, int, java.util.List, m9.z, androidx.compose.runtime.MutableState, androidx.compose.ui.graphics.GraphicsContext, S7.k, S7.o):androidx.compose.foundation.lazy.grid.LazyGridMeasureResult");
    }
}
