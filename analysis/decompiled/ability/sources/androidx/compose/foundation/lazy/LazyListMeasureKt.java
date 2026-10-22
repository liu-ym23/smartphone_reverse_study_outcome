package androidx.compose.foundation.lazy;

import D7.q;
import D7.v;
import Y7.f;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import g1.AbstractC1451a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0013\u001a\u009e\u0002\u00101\u001a\u00020.2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001c\u001a\u00020\u00002\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00000\u00102\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2*\u0010-\u001a&\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)\u0012\u0004\u0012\u00020,0(H\u0000ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001ac\u00106\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00102\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001a022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00002\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00000\u00102\u0006\u00104\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u000e2\b\u00105\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b6\u00107\u001a;\u00109\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00102\u0006\u00108\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00002\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00000\u0010H\u0002¢\u0006\u0004\b9\u0010:\u001a\u0093\u0001\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001a022\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00102\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00102\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00102\u0006\u0010>\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\bC\u0010D\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006E"}, d2 = {"", "itemsCount", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "measuredItemProvider", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenItems", "firstVisibleItemIndex", "firstVisibleItemScrollOffset", "", "scrollToBeConsumed", "Landroidx/compose/ui/unit/Constraints;", "constraints", "", "isVertical", "", "headerIndexes", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "horizontalArrangement", "reverseLayout", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "itemAnimator", "beyondBoundsItemCount", "pinnedItems", "hasLookaheadPassOccurred", "isLookingAhead", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "postLookaheadLayoutInfo", "Lm9/z;", "coroutineScope", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "placementScopeInvalidator", "Landroidx/compose/ui/graphics/GraphicsContext;", "graphicsContext", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "LC7/r;", "Landroidx/compose/ui/layout/MeasureResult;", "layout", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "measureLazyList-x0Ok8Vo", "(ILandroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;IIIIIIFJZLjava/util/List;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;ZZLandroidx/compose/foundation/lazy/LazyListLayoutInfo;Lm9/z;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;LS7/o;)Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "measureLazyList", "", "visibleItems", "consumedScroll", "lastPostLookaheadLayoutInfo", "createItemsAfterList", "(Ljava/util/List;Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;IILjava/util/List;FZLandroidx/compose/foundation/lazy/LazyListLayoutInfo;)Ljava/util/List;", "currentFirstItemIndex", "createItemsBeforeList", "(ILandroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;ILjava/util/List;)Ljava/util/List;", "items", "extraItemsBefore", "extraItemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "itemsScrollOffset", "calculateItemsOffsets", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;IIIIIZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;)Ljava/util/List;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyListMeasureKt {
    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(Unknown Source)
    	at java.base/java.util.ArrayList$Itr.next(Unknown Source)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:118)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [Y7.d] */
    private static final List<LazyListMeasuredItem> calculateItemsOffsets(List<LazyListMeasuredItem> list, List<LazyListMeasuredItem> list2, List<LazyListMeasuredItem> list3, int i, int i6, int i10, int i11, int i12, boolean z10, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z11, Density density) {
        int i13 = z10 ? i6 : i;
        boolean z12 = i10 < Math.min(i13, i11);
        if (z12 && i12 != 0) {
            throw new IllegalStateException("non-zero itemsScrollOffset");
        }
        ArrayList arrayList = new ArrayList(list3.size() + list2.size() + list.size());
        if (!z12) {
            int size = list2.size();
            int mainAxisSizeWithSpacings = i12;
            for (int i14 = 0; i14 < size; i14++) {
                LazyListMeasuredItem lazyListMeasuredItem = list2.get(i14);
                mainAxisSizeWithSpacings -= lazyListMeasuredItem.getMainAxisSizeWithSpacings();
                lazyListMeasuredItem.position(mainAxisSizeWithSpacings, i, i6);
                arrayList.add(lazyListMeasuredItem);
            }
            int size2 = list.size();
            int mainAxisSizeWithSpacings2 = i12;
            for (int i15 = 0; i15 < size2; i15++) {
                LazyListMeasuredItem lazyListMeasuredItem2 = list.get(i15);
                lazyListMeasuredItem2.position(mainAxisSizeWithSpacings2, i, i6);
                arrayList.add(lazyListMeasuredItem2);
                mainAxisSizeWithSpacings2 += lazyListMeasuredItem2.getMainAxisSizeWithSpacings();
            }
            int size3 = list3.size();
            for (int i16 = 0; i16 < size3; i16++) {
                LazyListMeasuredItem lazyListMeasuredItem3 = list3.get(i16);
                lazyListMeasuredItem3.position(mainAxisSizeWithSpacings2, i, i6);
                arrayList.add(lazyListMeasuredItem3);
                mainAxisSizeWithSpacings2 += lazyListMeasuredItem3.getMainAxisSizeWithSpacings();
            }
        } else {
            if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("no extra items");
            }
            int size4 = list.size();
            int[] iArr = new int[size4];
            for (int i17 = 0; i17 < size4; i17++) {
                iArr[i17] = list.get(calculateItemsOffsets$reverseAware(i17, z11, size4)).getSize();
            }
            int[] iArr2 = new int[size4];
            for (int i18 = 0; i18 < size4; i18++) {
                iArr2[i18] = 0;
            }
            if (z10) {
                if (vertical == null) {
                    throw new IllegalArgumentException("null verticalArrangement when isVertical == true");
                }
                vertical.arrange(density, i13, iArr, iArr2);
            } else {
                if (horizontal == null) {
                    throw new IllegalArgumentException("null horizontalArrangement when isVertical == false");
                }
                horizontal.arrange(density, i13, iArr, LayoutDirection.Ltr, iArr2);
            }
            f fVarO0 = q.o0(iArr2);
            f fVarS = fVarO0;
            if (z11) {
                fVarS = AbstractC1451a.S(fVarO0);
            }
            int i19 = fVarS.f1569a;
            int i20 = fVarS.b;
            int i21 = fVarS.c;
            if ((i21 > 0 && i19 <= i20) || (i21 < 0 && i20 <= i19)) {
                while (true) {
                    int size5 = iArr2[i19];
                    LazyListMeasuredItem lazyListMeasuredItem4 = list.get(calculateItemsOffsets$reverseAware(i19, z11, size4));
                    if (z11) {
                        size5 = (i13 - size5) - lazyListMeasuredItem4.getSize();
                    }
                    lazyListMeasuredItem4.position(size5, i, i6);
                    arrayList.add(lazyListMeasuredItem4);
                    if (i19 == i20) {
                        break;
                    }
                    i19 += i21;
                }
            }
        }
        return arrayList;
    }

    private static final int calculateItemsOffsets$reverseAware(int i, boolean z10, int i6) {
        return !z10 ? i : (i6 - i) - 1;
    }

    private static final List<LazyListMeasuredItem> createItemsAfterList(List<LazyListMeasuredItem> list, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i, int i6, List<Integer> list2, float f, boolean z10, LazyListLayoutInfo lazyListLayoutInfo) {
        ArrayList arrayList;
        LazyListItemInfo lazyListItemInfo;
        LazyListMeasuredItem lazyListMeasuredItem;
        LazyListMeasuredItem lazyListMeasuredItem2;
        int mainAxisSizeWithSpacings;
        LazyListMeasuredItem lazyListMeasuredItem3;
        int index;
        int iMin;
        LazyListMeasuredItem lazyListMeasuredItem4;
        LazyListMeasuredItem lazyListMeasuredItem5;
        int i10 = i - 1;
        int iMin2 = Math.min(((LazyListMeasuredItem) v.K0(list)).getIndex() + i6, i10);
        int index2 = ((LazyListMeasuredItem) v.K0(list)).getIndex() + 1;
        if (index2 <= iMin2) {
            int i11 = index2;
            arrayList = null;
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(LazyListMeasuredItemProvider.m813getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i11, 0L, 2, null));
                if (i11 == iMin2) {
                    break;
                }
                i11++;
            }
        } else {
            arrayList = null;
        }
        if (z10 && lazyListLayoutInfo != null && !lazyListLayoutInfo.getVisibleItemsInfo().isEmpty()) {
            List<LazyListItemInfo> visibleItemsInfo = lazyListLayoutInfo.getVisibleItemsInfo();
            int size = visibleItemsInfo.size();
            while (true) {
                size--;
                if (-1 >= size) {
                    lazyListItemInfo = null;
                    break;
                }
                if (visibleItemsInfo.get(size).getIndex() > iMin2 && (size == 0 || visibleItemsInfo.get(size - 1).getIndex() <= iMin2)) {
                    break;
                }
            }
            lazyListItemInfo = visibleItemsInfo.get(size);
            LazyListItemInfo lazyListItemInfo2 = (LazyListItemInfo) v.K0(lazyListLayoutInfo.getVisibleItemsInfo());
            if (lazyListItemInfo != null && (index = lazyListItemInfo.getIndex()) <= (iMin = Math.min(lazyListItemInfo2.getIndex(), i10))) {
                int i12 = index;
                while (true) {
                    if (arrayList != null) {
                        int size2 = arrayList.size();
                        int i13 = 0;
                        while (true) {
                            if (i13 >= size2) {
                                lazyListMeasuredItem5 = null;
                                break;
                            }
                            lazyListMeasuredItem5 = arrayList.get(i13);
                            if (lazyListMeasuredItem5.getIndex() == i12) {
                                break;
                            }
                            i13++;
                        }
                        lazyListMeasuredItem4 = lazyListMeasuredItem5;
                    } else {
                        lazyListMeasuredItem4 = null;
                    }
                    if (lazyListMeasuredItem4 == null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(LazyListMeasuredItemProvider.m813getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i12, 0L, 2, null));
                    }
                    if (i12 == iMin) {
                        break;
                    }
                    i12++;
                }
            }
            float viewportEndOffset = ((lazyListLayoutInfo.getViewportEndOffset() - lazyListItemInfo2.getOffset()) - lazyListItemInfo2.getSize()) - f;
            if (viewportEndOffset > 0.0f) {
                int index3 = lazyListItemInfo2.getIndex() + 1;
                int i14 = 0;
                while (index3 < i && i14 < viewportEndOffset) {
                    if (index3 <= iMin2) {
                        int size3 = list.size();
                        int i15 = 0;
                        while (true) {
                            if (i15 >= size3) {
                                lazyListMeasuredItem3 = null;
                                break;
                            }
                            lazyListMeasuredItem3 = list.get(i15);
                            if (lazyListMeasuredItem3.getIndex() == index3) {
                                break;
                            }
                            i15++;
                        }
                        lazyListMeasuredItem = lazyListMeasuredItem3;
                    } else if (arrayList != null) {
                        int size4 = arrayList.size();
                        int i16 = 0;
                        while (true) {
                            if (i16 >= size4) {
                                lazyListMeasuredItem2 = null;
                                break;
                            }
                            lazyListMeasuredItem2 = arrayList.get(i16);
                            if (lazyListMeasuredItem2.getIndex() == index3) {
                                break;
                            }
                            i16++;
                        }
                        lazyListMeasuredItem = lazyListMeasuredItem2;
                    } else {
                        lazyListMeasuredItem = null;
                    }
                    if (lazyListMeasuredItem != null) {
                        index3++;
                        mainAxisSizeWithSpacings = lazyListMeasuredItem.getMainAxisSizeWithSpacings();
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(LazyListMeasuredItemProvider.m813getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, index3, 0L, 2, null));
                        index3++;
                        mainAxisSizeWithSpacings = ((LazyListMeasuredItem) v.K0(arrayList)).getMainAxisSizeWithSpacings();
                    }
                    i14 += mainAxisSizeWithSpacings;
                }
            }
        }
        if (arrayList != null && ((LazyListMeasuredItem) v.K0(arrayList)).getIndex() > iMin2) {
            iMin2 = ((LazyListMeasuredItem) v.K0(arrayList)).getIndex();
        }
        int size5 = list2.size();
        for (int i17 = 0; i17 < size5; i17++) {
            int iIntValue = list2.get(i17).intValue();
            if (iIntValue > iMin2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(LazyListMeasuredItemProvider.m813getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, iIntValue, 0L, 2, null));
            }
        }
        return arrayList == null ? EmptyList.f4893a : arrayList;
    }

    private static final List<LazyListMeasuredItem> createItemsBeforeList(int i, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i6, List<Integer> list) {
        LazyListMeasuredItemProvider lazyListMeasuredItemProvider2;
        int iMax = Math.max(0, i - i6);
        int i10 = i - 1;
        ArrayList arrayList = null;
        if (iMax <= i10) {
            int i11 = i10;
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
                arrayList.add(LazyListMeasuredItemProvider.m813getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider2, i11, 0L, 2, null));
                if (i11 == iMax) {
                    break;
                }
                i11--;
                lazyListMeasuredItemProvider = lazyListMeasuredItemProvider2;
            }
        } else {
            lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
        }
        int size = list.size() - 1;
        if (size >= 0) {
            while (true) {
                int i12 = size - 1;
                int iIntValue = list.get(size).intValue();
                if (iIntValue < iMax) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(LazyListMeasuredItemProvider.m813getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider2, iIntValue, 0L, 2, null));
                }
                if (i12 < 0) {
                    break;
                }
                size = i12;
            }
        }
        return arrayList == null ? EmptyList.f4893a : arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x0370  */
    /* renamed from: measureLazyList-x0Ok8Vo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.foundation.lazy.LazyListMeasureResult m807measureLazyListx0Ok8Vo(int r39, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider r40, int r41, int r42, int r43, int r44, int r45, int r46, float r47, long r48, boolean r50, java.util.List<java.lang.Integer> r51, androidx.compose.foundation.layout.Arrangement.Vertical r52, androidx.compose.foundation.layout.Arrangement.Horizontal r53, boolean r54, androidx.compose.ui.unit.Density r55, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator<androidx.compose.foundation.lazy.LazyListMeasuredItem> r56, int r57, java.util.List<java.lang.Integer> r58, boolean r59, final boolean r60, androidx.compose.foundation.lazy.LazyListLayoutInfo r61, m9.InterfaceC1733z r62, final androidx.compose.runtime.MutableState<C7.r> r63, androidx.compose.ui.graphics.GraphicsContext r64, S7.o r65) {
        /*
            Method dump skipped, instructions count: 1077
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListMeasureKt.m807measureLazyListx0Ok8Vo(int, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider, int, int, int, int, int, int, float, long, boolean, java.util.List, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, boolean, androidx.compose.ui.unit.Density, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator, int, java.util.List, boolean, boolean, androidx.compose.foundation.lazy.LazyListLayoutInfo, m9.z, androidx.compose.runtime.MutableState, androidx.compose.ui.graphics.GraphicsContext, S7.o):androidx.compose.foundation.lazy.LazyListMeasureResult");
    }
}
