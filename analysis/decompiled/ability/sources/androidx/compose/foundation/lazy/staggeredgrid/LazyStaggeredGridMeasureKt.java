package androidx.compose.foundation.lazy.staggeredgrid;

import D7.p;
import S7.a;
import S7.k;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b \u001a2\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0083\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u000b\u001a\u00020\n*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u001e\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0082\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u008c\u0001\u0010-\u001a\u00020**\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00152\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(H\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a3\u00104\u001a\u00020**\u00020.2\u0006\u0010/\u001a\u00020\u00152\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u0002002\u0006\u00103\u001a\u00020\u001dH\u0003¢\u0006\u0004\b4\u00105\u001a=\u00109\u001a\b\u0012\u0004\u0012\u00020\t0\u0014*\u00020.2\u0012\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u00107\u001a\u0002002\u0006\u00108\u001a\u00020\u0015H\u0002¢\u0006\u0004\b9\u0010:\u001aJ\u0010>\u001a\b\u0012\u0004\u0012\u00020\t0\u0014*\u00020.2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f0\u00032\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001d0\u00032\u0006\u0010=\u001a\u00020\u001dH\u0083\b¢\u0006\u0004\b>\u0010?\u001a>\u0010B\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00142\b\b\u0002\u0010@\u001a\u00020\u001d2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u0003H\u0082\b¢\u0006\u0004\bB\u0010C\u001a+\u0010G\u001a\u00020\u000f*\u00020D2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000f0\u0003H\u0082\bø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a\u001b\u0010I\u001a\u00020\u000f*\u0002002\u0006\u0010H\u001a\u00020\u0015H\u0002¢\u0006\u0004\bI\u0010J\u001a\u001e\u0010N\u001a\u00020\u0015*\u0002002\u0006\u0010K\u001a\u00020DH\u0002ø\u0001\u0000¢\u0006\u0004\bL\u0010M\u001a\u001d\u0010P\u001a\u00020\u0015*\u0002002\b\b\u0002\u0010O\u001a\u00020\u0015H\u0000¢\u0006\u0004\bP\u0010Q\u001a4\u0010R\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u0003H\u0082\b¢\u0006\u0004\bR\u0010S\u001a\u0013\u0010T\u001a\u00020\u0015*\u000200H\u0002¢\u0006\u0004\bT\u0010U\u001a(\u0010V\u001a\u000200*\u0002002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0003H\u0082\b¢\u0006\u0004\bV\u0010W\u001a#\u0010Z\u001a\u00020\u000f*\u00020.2\u0006\u0010X\u001a\u0002002\u0006\u0010Y\u001a\u00020\u0015H\u0002¢\u0006\u0004\bZ\u0010[\u001a#\u0010^\u001a\u00020\u0015*\u00020.2\u0006\u0010\\\u001a\u00020\u00152\u0006\u0010]\u001a\u00020\u0015H\u0002¢\u0006\u0004\b^\u0010_\"\u0014\u0010`\u001a\u00020\u001d8\u0002X\u0082T¢\u0006\u0006\n\u0004\b`\u0010a\"\u0014\u0010b\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\bb\u0010c\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006d"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "scope", "Lkotlin/Function1;", "block", "withDebugLogging", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;LS7/k;)Ljava/lang/Object;", "", "LD7/p;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "", "debugRender", "([LD7/p;)Ljava/lang/String;", "Lkotlin/Function0;", "message", "LC7/r;", "debugLog", "(LS7/a;)V", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "state", "", "", "pinnedItems", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "resolvedSlots", "Landroidx/compose/ui/unit/Constraints;", "constraints", "", "isVertical", "reverseLayout", "Landroidx/compose/ui/unit/IntOffset;", "contentOffset", "mainAxisAvailableSize", "mainAxisSpacing", "beforeContentPadding", "afterContentPadding", "Lm9/z;", "coroutineScope", "Landroidx/compose/ui/graphics/GraphicsContext;", "graphicsContext", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "measureStaggeredGrid-XtK8cYQ", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Ljava/util/List;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;JZZJIIIILm9/z;Landroidx/compose/ui/graphics/GraphicsContext;)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "measureStaggeredGrid", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "initialScrollDelta", "", "initialItemIndices", "initialItemOffsets", "canRestartMeasure", "measure", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;I[I[IZ)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "measuredItems", "itemScrollOffsets", "mainAxisLayoutSize", "calculateVisibleItems", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;[LD7/p;[II)Ljava/util/List;", "position", "filter", "beforeVisibleBounds", "calculateExtraItems", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;LS7/k;LS7/k;Z)Ljava/util/List;", "reverse", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "fastForEach", "(Ljava/util/List;ZLS7/k;)V", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "forEach-nIS5qE8", "(JLS7/k;)V", "forEach", "delta", "offsetBy", "([II)V", "indexRange", "maxInRange-jy6DScQ", "([IJ)I", "maxInRange", "minBound", "indexOfMinValue", "([II)I", "indexOfMinBy", "([Ljava/lang/Object;LS7/k;)I", "indexOfMaxValue", "([I)I", "transform", "([ILS7/k;)[I", "indices", "itemCount", "ensureIndicesInRange", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;[II)V", "item", "lane", "findPreviousItemIndex", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;II)I", "DebugLoggingEnabled", "Z", "Unset", "I", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyStaggeredGridMeasureKt {
    private static final boolean DebugLoggingEnabled = false;
    private static final int Unset = Integer.MIN_VALUE;

    @ExperimentalFoundationApi
    private static final List<LazyStaggeredGridMeasuredItem> calculateExtraItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, k kVar, k kVar2, boolean z10) {
        List<Integer> pinnedItems = lazyStaggeredGridMeasureContext.getPinnedItems();
        ArrayList arrayList = null;
        if (z10) {
            int size = pinnedItems.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    int iIntValue = pinnedItems.get(size).intValue();
                    if (((Boolean) kVar2.invoke(Integer.valueOf(iIntValue))).booleanValue()) {
                        long jM908getSpanRangelOCCd4c = lazyStaggeredGridMeasureContext.m908getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), iIntValue, 0);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM917getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m917getAndMeasurejy6DScQ(iIntValue, jM908getSpanRangelOCCd4c);
                        kVar.invoke(lazyStaggeredGridMeasuredItemM917getAndMeasurejy6DScQ);
                        arrayList.add(lazyStaggeredGridMeasuredItemM917getAndMeasurejy6DScQ);
                    }
                    if (i < 0) {
                        break;
                    }
                    size = i;
                }
            }
        } else {
            int size2 = pinnedItems.size();
            for (int i6 = 0; i6 < size2; i6++) {
                int iIntValue2 = pinnedItems.get(i6).intValue();
                if (((Boolean) kVar2.invoke(Integer.valueOf(iIntValue2))).booleanValue()) {
                    long jM908getSpanRangelOCCd4c2 = lazyStaggeredGridMeasureContext.m908getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), iIntValue2, 0);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItemM917getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m917getAndMeasurejy6DScQ(iIntValue2, jM908getSpanRangelOCCd4c2);
                    kVar.invoke(lazyStaggeredGridMeasuredItemM917getAndMeasurejy6DScQ2);
                    arrayList.add(lazyStaggeredGridMeasuredItemM917getAndMeasurejy6DScQ2);
                }
            }
        }
        return arrayList == null ? EmptyList.f4893a : arrayList;
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateVisibleItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, p[] pVarArr, int[] iArr, int i) {
        int size = 0;
        for (p pVar : pVarArr) {
            size += pVar.size();
        }
        ArrayList arrayList = new ArrayList(size);
        while (true) {
            for (p pVar2 : pVarArr) {
                if (!pVar2.isEmpty()) {
                    int length = pVarArr.length;
                    int i6 = -1;
                    int i10 = Integer.MAX_VALUE;
                    for (int i11 = 0; i11 < length; i11++) {
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = (LazyStaggeredGridMeasuredItem) pVarArr[i11].f();
                        int index = lazyStaggeredGridMeasuredItem != null ? lazyStaggeredGridMeasuredItem.getIndex() : Integer.MAX_VALUE;
                        if (i10 > index) {
                            i6 = i11;
                            i10 = index;
                        }
                    }
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem2 = (LazyStaggeredGridMeasuredItem) pVarArr[i6].removeFirst();
                    if (lazyStaggeredGridMeasuredItem2.getLane() == i6) {
                        long jM923constructorimpl = SpanRange.m923constructorimpl(lazyStaggeredGridMeasuredItem2.getLane(), lazyStaggeredGridMeasuredItem2.getSpan());
                        int iM912maxInRangejy6DScQ = m912maxInRangejy6DScQ(iArr, jM923constructorimpl);
                        lazyStaggeredGridMeasuredItem2.position(iM912maxInRangejy6DScQ, lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions()[i6], i);
                        arrayList.add(lazyStaggeredGridMeasuredItem2);
                        int i12 = (int) (jM923constructorimpl & 4294967295L);
                        for (int i13 = (int) (jM923constructorimpl >> 32); i13 < i12; i13++) {
                            iArr[i13] = lazyStaggeredGridMeasuredItem2.getMainAxisSizeWithSpacings() + iM912maxInRangejy6DScQ;
                        }
                    }
                }
            }
            return arrayList;
        }
    }

    private static final void debugLog(a aVar) {
    }

    private static final String debugRender(p[] pVarArr) {
        return "";
    }

    private static final void ensureIndicesInRange(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr, int i) {
        int length = iArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i6 = length - 1;
            while (true) {
                if (iArr[length] < i && lazyStaggeredGridMeasureContext.getLaneInfo().assignedToLane(iArr[length], length)) {
                    break;
                } else {
                    iArr[length] = findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[length], length);
                }
            }
            if (iArr[length] >= 0 && !lazyStaggeredGridMeasureContext.isFullSpan(lazyStaggeredGridMeasureContext.getItemProvider(), iArr[length])) {
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr[length], length);
            }
            if (i6 < 0) {
                return;
            } else {
                length = i6;
            }
        }
    }

    private static final <T> void fastForEach(List<? extends T> list, boolean z10, k kVar) {
        if (!z10) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                kVar.invoke(list.get(i));
            }
            return;
        }
        int size2 = list.size() - 1;
        if (size2 < 0) {
            return;
        }
        while (true) {
            int i6 = size2 - 1;
            kVar.invoke(list.get(size2));
            if (i6 < 0) {
                return;
            } else {
                size2 = i6;
            }
        }
    }

    public static /* synthetic */ void fastForEach$default(List list, boolean z10, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = false;
        }
        if (!z10) {
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                kVar.invoke(list.get(i6));
            }
            return;
        }
        int size2 = list.size() - 1;
        if (size2 < 0) {
            return;
        }
        while (true) {
            int i10 = size2 - 1;
            kVar.invoke(list.get(size2));
            if (i10 < 0) {
                return;
            } else {
                size2 = i10;
            }
        }
    }

    private static final int findPreviousItemIndex(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int i6) {
        return lazyStaggeredGridMeasureContext.getLaneInfo().findPreviousItemIndex(i, i6);
    }

    /* renamed from: forEach-nIS5qE8, reason: not valid java name */
    private static final void m911forEachnIS5qE8(long j5, k kVar) {
        int i = (int) (j5 & 4294967295L);
        for (int i6 = (int) (j5 >> 32); i6 < i; i6++) {
            kVar.invoke(Integer.valueOf(i6));
        }
    }

    private static final int indexOfMaxValue(int[] iArr) {
        int length = iArr.length;
        int i = -1;
        int i6 = Integer.MIN_VALUE;
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = iArr[i10];
            if (i6 < i11) {
                i = i10;
                i6 = i11;
            }
        }
        return i;
    }

    private static final <T> int indexOfMinBy(T[] tArr, k kVar) {
        int length = tArr.length;
        int i = -1;
        int i6 = Integer.MAX_VALUE;
        for (int i10 = 0; i10 < length; i10++) {
            int iIntValue = ((Number) kVar.invoke(tArr[i10])).intValue();
            if (i6 > iIntValue) {
                i = i10;
                i6 = iIntValue;
            }
        }
        return i;
    }

    public static final int indexOfMinValue(int[] iArr, int i) {
        int length = iArr.length;
        int i6 = -1;
        int i10 = Integer.MAX_VALUE;
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = i + 1;
            int i13 = iArr[i11];
            if (i12 <= i13 && i13 < i10) {
                i6 = i11;
                i10 = i13;
            }
        }
        return i6;
    }

    public static /* synthetic */ int indexOfMinValue$default(int[] iArr, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = Integer.MIN_VALUE;
        }
        return indexOfMinValue(iArr, i);
    }

    /* renamed from: maxInRange-jy6DScQ, reason: not valid java name */
    private static final int m912maxInRangejy6DScQ(int[] iArr, long j5) {
        int i = (int) (j5 & 4294967295L);
        int iMax = Integer.MIN_VALUE;
        for (int i6 = (int) (j5 >> 32); i6 < i; i6++) {
            iMax = Math.max(iMax, iArr[i6]);
        }
        return iMax;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0222, code lost:
    
        r15 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0236, code lost:
    
        r1 = indexOfMinValue$default(r13, 0, 1, null);
        r0 = D7.q.z0(r7) + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x023f, code lost:
    
        if (r0 < r11) goto L362;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02ee, code lost:
    
        r3 = indexOfMinValue$default(r8, 0, 1, null);
        r4 = indexOfMaxValue(r29);
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x02f9, code lost:
    
        if (r3 == r4) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x02ff, code lost:
    
        if (r8[r3] != r8[r4]) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0301, code lost:
    
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0303, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0304, code lost:
    
        r4 = r29[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0307, code lost:
    
        if (r4 != (-1)) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0309, code lost:
    
        r4 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x030a, code lost:
    
        r15 = r46;
        r4 = findPreviousItemIndex(r15, r4, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0310, code lost:
    
        if (r4 >= 0) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0312, code lost:
    
        r9 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0314, code lost:
    
        if (r0 != false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x031a, code lost:
    
        if (measure$lambda$38$misalignedStart(r9, r15, r8, r3) == false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x031d, code lost:
    
        r6 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0320, code lost:
    
        if (r50 == false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0322, code lost:
    
        r15.getLaneInfo().reset();
        r0 = r9.length;
        r1 = new int[r0];
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x032d, code lost:
    
        if (r2 >= r0) goto L464;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x032f, code lost:
    
        r1[r2] = -1;
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0336, code lost:
    
        r0 = r8.length;
        r2 = new int[r0];
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x033a, code lost:
    
        if (r4 >= r0) goto L465;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x033c, code lost:
    
        r2[r4] = r8[r3];
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x034a, code lost:
    
        return measure(r15, r28, r1, r2, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x034b, code lost:
    
        r48 = r1;
        r29 = r2;
        r25 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0355, code lost:
    
        r6 = r28;
        r9 = r29;
        r14 = r0;
        r48 = r1;
        r0 = r15.m908getSpanRangelOCCd4c(r15.getItemProvider(), r4, r3);
        r3 = r15.getLaneInfo();
        r25 = r11;
        r10 = (int) (r0 & 4294967295L);
        r28 = r12;
        r11 = (int) (r0 >> 32);
        r12 = r10 - r11;
        r29 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0377, code lost:
    
        if (r12 == 1) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0379, code lost:
    
        r2 = -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x037b, code lost:
    
        r2 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x037c, code lost:
    
        r3.setLane(r4, r2);
        r2 = r15.getMeasuredItemProvider().m917getAndMeasurejy6DScQ(r4, r0);
        r0 = m912maxInRangejy6DScQ(r8, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x038c, code lost:
    
        if (r12 == 1) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x038e, code lost:
    
        r3 = r15.getLaneInfo().getGaps(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0397, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0398, code lost:
    
        if (r11 >= r10) goto L460;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x039c, code lost:
    
        if (r8[r11] == r0) goto L188;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x039e, code lost:
    
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x039f, code lost:
    
        r27[r11].addFirst(r2);
        r9[r11] = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x03a6, code lost:
    
        if (r3 != null) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x03a8, code lost:
    
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x03aa, code lost:
    
        r1 = r3[r11];
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x03ac, code lost:
    
        r8[r11] = (r2.getMainAxisSizeWithSpacings() + r0) + r1;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x0793, code lost:
    
        r9 = r2;
        r8 = r12;
        r10 = r26;
        r12 = r47;
        r2 = r49;
        r1 = r46.m908getSpanRangelOCCd4c(r46.getItemProvider(), r0, r1);
        r3 = r46.getLaneInfo();
        r25 = r5;
        r4 = (int) (r1 & 4294967295L);
        r5 = (int) (r1 >> 32);
        r6 = r4 - r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x07bc, code lost:
    
        if (r6 == 1) goto L365;
     */
    /* JADX WARN: Code restructure failed: missing block: B:364:0x07be, code lost:
    
        r23 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x07c1, code lost:
    
        r23 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x07c3, code lost:
    
        if (r23 == false) goto L368;
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:0x07c5, code lost:
    
        r5 = -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x07c7, code lost:
    
        r5 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x07c9, code lost:
    
        r3.setLane(r0, r5);
        r3 = r46.getMeasuredItemProvider().m917getAndMeasurejy6DScQ(r0, r1);
        r1 = m912maxInRangejy6DScQ(r13, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x07d9, code lost:
    
        if (r6 == 1) goto L372;
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x07db, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:372:0x07dd, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x07de, code lost:
    
        if (r5 == false) goto L377;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x07e0, code lost:
    
        r5 = r46.getLaneInfo().getGaps(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x07e8, code lost:
    
        if (r5 != null) goto L378;
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x07ea, code lost:
    
        r5 = new int[r46.getLaneCount()];
     */
    /* JADX WARN: Code restructure failed: missing block: B:377:0x07f1, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x07f2, code lost:
    
        r6 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:379:0x07f4, code lost:
    
        if (r6 >= r4) goto L423;
     */
    /* JADX WARN: Code restructure failed: missing block: B:380:0x07f6, code lost:
    
        if (r5 == null) goto L425;
     */
    /* JADX WARN: Code restructure failed: missing block: B:381:0x07f8, code lost:
    
        r5[r6] = r1 - r13[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x07fe, code lost:
    
        r7[r6] = r0;
        r13[r6] = r3.getMainAxisSizeWithSpacings() + r1;
        r27[r6].addLast(r3);
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:383:0x0811, code lost:
    
        r46.getLaneInfo().setGaps(r0, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:0x0818, code lost:
    
        if (r1 >= r14) goto L418;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x081c, code lost:
    
        if (r13[r5] > r14) goto L419;
     */
    /* JADX WARN: Code restructure failed: missing block: B:387:0x081e, code lost:
    
        r3.setVisible(false);
     */
    /* JADX WARN: Removed duplicated region for block: B:298:0x05ee  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x061d  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0740  */
    @androidx.compose.foundation.ExperimentalFoundationApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult measure(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext r46, int r47, int[] r48, int[] r49, boolean r50) {
        /*
            Method dump skipped, instructions count: 2314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt.measure(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext, int, int[], int[], boolean):androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult");
    }

    private static final boolean measure$lambda$38$hasSpaceBeforeFirst(int[] iArr, int[] iArr2, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            int i6 = iArr[i];
            if (iArr2[i] < Math.max(-lazyStaggeredGridMeasureContext.getMainAxisSpacing(), 0) && i6 > 0) {
                return true;
            }
        }
        return false;
    }

    private static final boolean measure$lambda$38$misalignedStart(int[] iArr, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr2, int i) {
        int length = iArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i6], i6) == -1 && iArr2[i6] != iArr2[i]) {
                return true;
            }
        }
        int length2 = iArr.length;
        for (int i10 = 0; i10 < length2; i10++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i10], i10) != -1 && iArr2[i10] >= iArr2[i]) {
                return true;
            }
        }
        int lane = lazyStaggeredGridMeasureContext.getLaneInfo().getLane(0);
        return (lane == 0 || lane == -1 || lane == -2) ? false : true;
    }

    @ExperimentalFoundationApi
    /* renamed from: measureStaggeredGrid-XtK8cYQ, reason: not valid java name */
    public static final LazyStaggeredGridMeasureResult m913measureStaggeredGridXtK8cYQ(LazyLayoutMeasureScope lazyLayoutMeasureScope, LazyStaggeredGridState lazyStaggeredGridState, List<Integer> list, LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, LazyStaggeredGridSlots lazyStaggeredGridSlots, long j5, boolean z10, boolean z11, long j6, int i, int i6, int i10, int i11, InterfaceC1733z interfaceC1733z, GraphicsContext graphicsContext) {
        int iM912maxInRangejy6DScQ;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext = new LazyStaggeredGridMeasureContext(lazyStaggeredGridState, list, lazyStaggeredGridItemProvider, lazyStaggeredGridSlots, j5, z10, lazyLayoutMeasureScope, i, j6, i10, i11, z11, i6, interfaceC1733z, graphicsContext, null);
        int[] iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyStaggeredGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyStaggeredGridItemProvider, lazyStaggeredGridState.getScrollPosition().getIndices());
        int[] scrollOffsets = lazyStaggeredGridState.getScrollPosition().getScrollOffsets();
        if (iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release.length != lazyStaggeredGridMeasureContext.getLaneCount()) {
            lazyStaggeredGridMeasureContext.getLaneInfo().reset();
            int laneCount = lazyStaggeredGridMeasureContext.getLaneCount();
            int[] iArr = new int[laneCount];
            int i12 = 0;
            while (i12 < laneCount) {
                if (i12 >= iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release.length || (iM912maxInRangejy6DScQ = iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release[i12]) == -1) {
                    iM912maxInRangejy6DScQ = i12 == 0 ? 0 : m912maxInRangejy6DScQ(iArr, SpanRange.m923constructorimpl(0, i12)) + 1;
                }
                iArr[i12] = iM912maxInRangejy6DScQ;
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr[i12], i12);
                i12++;
            }
            iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release = iArr;
        }
        if (scrollOffsets.length != lazyStaggeredGridMeasureContext.getLaneCount()) {
            int laneCount2 = lazyStaggeredGridMeasureContext.getLaneCount();
            int[] iArr2 = new int[laneCount2];
            int i13 = 0;
            while (i13 < laneCount2) {
                iArr2[i13] = i13 < scrollOffsets.length ? scrollOffsets[i13] : i13 == 0 ? 0 : iArr2[i13 - 1];
                i13++;
            }
            scrollOffsets = iArr2;
        }
        return measure(lazyStaggeredGridMeasureContext, Math.round(lazyStaggeredGridState.getScrollToBeConsumed()), iArrUpdateScrollPositionIfTheFirstItemWasMoved$foundation_release, scrollOffsets, true);
    }

    private static final void offsetBy(int[] iArr, int i) {
        int length = iArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            iArr[i6] = iArr[i6] + i;
        }
    }

    private static final int[] transform(int[] iArr, k kVar) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = ((Number) kVar.invoke(Integer.valueOf(iArr[i]))).intValue();
        }
        return iArr;
    }

    @ExperimentalFoundationApi
    private static final <T> T withDebugLogging(LazyLayoutMeasureScope lazyLayoutMeasureScope, k kVar) {
        return (T) kVar.invoke(lazyLayoutMeasureScope);
    }
}
