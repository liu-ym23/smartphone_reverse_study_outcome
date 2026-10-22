package androidx.compose.foundation.pager;

import B7.a;
import C7.r;
import D7.p;
import D7.q;
import H4.o;
import S7.k;
import Y7.f;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.gestures.snapping.SnapPositionKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import g1.AbstractC1451a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\u001aì\u0001\u0010*\u001a\u00020'*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2*\u0010&\u001a&\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"\u0012\u0004\u0012\u00020%0!H\u0000ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001aO\u0010/\u001a\b\u0012\u0004\u0012\u00020-0\u00192\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00192\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020-0\"H\u0002¢\u0006\u0004\b/\u00100\u001aG\u00102\u001a\b\u0012\u0004\u0012\u00020-0\u00192\u0006\u00101\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00192\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020-0\"H\u0002¢\u0006\u0004\b2\u00103\u001aO\u00107\u001a\u0004\u0018\u00010-2\u0006\u00104\u001a\u00020\u00012\f\u00105\u001a\b\u0012\u0004\u0012\u00020-0\u00192\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b7\u00108\u001aj\u0010.\u001a\u00020-*\u00020\u00002\u0006\u00109\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010<\u001a\u00020;2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a\u0093\u0001\u0010J\u001a\b\u0012\u0004\u0012\u00020-0I*\u00020\u00002\f\u0010?\u001a\b\u0012\u0004\u0012\u00020-0\u00192\f\u0010@\u001a\b\u0012\u0004\u0012\u00020-0\u00192\f\u0010A\u001a\b\u0012\u0004\u0012\u00020-0\u00192\u0006\u0010B\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\u00012\u0006\u0010D\u001a\u00020\u00012\u0006\u0010E\u001a\u00020\u00012\u0006\u0010F\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010H\u001a\u00020G2\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0002¢\u0006\u0004\bJ\u0010K\u001a\u001e\u0010O\u001a\u00020$2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020M0LH\u0082\b¢\u0006\u0004\bO\u0010P\"\u0014\u0010R\u001a\u00020Q8\u0000X\u0080T¢\u0006\u0006\n\u0004\bR\u0010S\"\u0014\u0010T\u001a\u00020Q8\u0000X\u0080T¢\u0006\u0006\n\u0004\bT\u0010S\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006U"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "", "pageCount", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "pagerItemProvider", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenPages", "currentPage", "currentPageOffset", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "Landroidx/compose/ui/Alignment$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "horizontalAlignment", "", "reverseLayout", "Landroidx/compose/ui/unit/IntOffset;", "visualPageOffset", "pageAvailableSize", "beyondViewportPageCount", "", "pinnedPages", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "snapPosition", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "placementScopeInvalidator", "Lm9/z;", "coroutineScope", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "LC7/r;", "Landroidx/compose/ui/layout/MeasureResult;", "layout", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "measurePager-bmk8ZPk", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;ILandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;IIIIIIJLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Horizontal;ZJIILjava/util/List;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/runtime/MutableState;Lm9/z;LS7/o;)Landroidx/compose/foundation/pager/PagerMeasureResult;", "measurePager", "currentLastPage", "pagesCount", "Landroidx/compose/foundation/pager/MeasuredPage;", "getAndMeasure", "createPagesAfterList", "(IIILjava/util/List;LS7/k;)Ljava/util/List;", "currentFirstPage", "createPagesBeforeList", "(IILjava/util/List;LS7/k;)Ljava/util/List;", "viewportSize", "visiblePagesInfo", "itemSize", "calculateNewCurrentPage", "(ILjava/util/List;IIILandroidx/compose/foundation/gestures/snapping/SnapPosition;I)Landroidx/compose/foundation/pager/MeasuredPage;", "index", "childConstraints", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getAndMeasure-SGf7dI0", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJLandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;JLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZI)Landroidx/compose/foundation/pager/MeasuredPage;", "pages", "extraPagesBefore", "extraPagesAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "pagesScrollOffset", "Landroidx/compose/ui/unit/Density;", "density", "", "calculatePagesOffsets", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Ljava/util/List;Ljava/util/List;Ljava/util/List;IIIIILandroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/unit/Density;II)Ljava/util/List;", "Lkotlin/Function0;", "", "generateMsg", "debugLog", "(LS7/a;)V", "", "MinPageOffset", "F", "MaxPageOffset", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PagerMeasureKt {
    public static final float MaxPageOffset = 0.5f;
    public static final float MinPageOffset = -0.5f;

    private static final MeasuredPage calculateNewCurrentPage(int i, List<MeasuredPage> list, int i6, int i10, int i11, SnapPosition snapPosition, int i12) {
        MeasuredPage measuredPage;
        if (list.isEmpty()) {
            measuredPage = null;
        } else {
            MeasuredPage measuredPage2 = list.get(0);
            MeasuredPage measuredPage3 = measuredPage2;
            float f = -Math.abs(SnapPositionKt.calculateDistanceToDesiredSnapPosition(i, i6, i10, i11, measuredPage3.getOffset(), measuredPage3.getIndex(), snapPosition, i12));
            int iH = o.H(list);
            if (1 <= iH) {
                int i13 = 1;
                while (true) {
                    MeasuredPage measuredPage4 = list.get(i13);
                    MeasuredPage measuredPage5 = measuredPage4;
                    float f7 = -Math.abs(SnapPositionKt.calculateDistanceToDesiredSnapPosition(i, i6, i10, i11, measuredPage5.getOffset(), measuredPage5.getIndex(), snapPosition, i12));
                    if (Float.compare(f, f7) < 0) {
                        f = f7;
                        measuredPage2 = measuredPage4;
                    }
                    if (i13 == iH) {
                        break;
                    }
                    i13++;
                }
            }
            measuredPage = measuredPage2;
        }
        return measuredPage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v10, types: [Y7.d] */
    private static final List<MeasuredPage> calculatePagesOffsets(LazyLayoutMeasureScope lazyLayoutMeasureScope, List<MeasuredPage> list, List<MeasuredPage> list2, List<MeasuredPage> list3, int i, int i6, int i10, int i11, int i12, Orientation orientation, boolean z10, Density density, int i13, int i14) {
        int i15 = i12;
        int i16 = i14 + i13;
        int i17 = orientation == Orientation.Vertical ? i6 : i;
        boolean z11 = i10 < Math.min(i17, i11);
        if (z11 && i15 != 0) {
            throw new IllegalStateException(a.h(i15, "non-zero pagesScrollOffset=").toString());
        }
        ArrayList arrayList = new ArrayList(list3.size() + list2.size() + list.size());
        if (!z11) {
            int size = list2.size();
            int i18 = i15;
            for (int i19 = 0; i19 < size; i19++) {
                MeasuredPage measuredPage = list2.get(i19);
                i18 -= i16;
                measuredPage.position(i18, i, i6);
                arrayList.add(measuredPage);
            }
            int size2 = list.size();
            for (int i20 = 0; i20 < size2; i20++) {
                MeasuredPage measuredPage2 = list.get(i20);
                measuredPage2.position(i15, i, i6);
                arrayList.add(measuredPage2);
                i15 += i16;
            }
            int size3 = list3.size();
            for (int i21 = 0; i21 < size3; i21++) {
                MeasuredPage measuredPage3 = list3.get(i21);
                measuredPage3.position(i15, i, i6);
                arrayList.add(measuredPage3);
                i15 += i16;
            }
        } else {
            if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("No extra pages");
            }
            int size4 = list.size();
            int[] iArr = new int[size4];
            for (int i22 = 0; i22 < size4; i22++) {
                iArr[i22] = i14;
            }
            int[] iArr2 = new int[size4];
            for (int i23 = 0; i23 < size4; i23++) {
                iArr2[i23] = 0;
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalM583spacedBy0680j_4 = Arrangement.Absolute.INSTANCE.m583spacedBy0680j_4(lazyLayoutMeasureScope.mo378toDpu2uoSUM(i13));
            if (orientation == Orientation.Vertical) {
                horizontalOrVerticalM583spacedBy0680j_4.arrange(density, i17, iArr, iArr2);
            } else {
                horizontalOrVerticalM583spacedBy0680j_4.arrange(density, i17, iArr, LayoutDirection.Ltr, iArr2);
            }
            f fVarO0 = q.o0(iArr2);
            f fVarS = fVarO0;
            if (z10) {
                fVarS = AbstractC1451a.S(fVarO0);
            }
            int i24 = fVarS.f1569a;
            int i25 = fVarS.b;
            int i26 = fVarS.c;
            if ((i26 > 0 && i24 <= i25) || (i26 < 0 && i25 <= i24)) {
                while (true) {
                    int size5 = iArr2[i24];
                    MeasuredPage measuredPage4 = list.get(calculatePagesOffsets$reverseAware(i24, z10, size4));
                    if (z10) {
                        size5 = (i17 - size5) - measuredPage4.getSize();
                    }
                    measuredPage4.position(size5, i, i6);
                    arrayList.add(measuredPage4);
                    if (i24 == i25) {
                        break;
                    }
                    i24 += i26;
                }
            }
        }
        return arrayList;
    }

    private static final int calculatePagesOffsets$reverseAware(int i, boolean z10, int i6) {
        return !z10 ? i : (i6 - i) - 1;
    }

    private static final List<MeasuredPage> createPagesAfterList(int i, int i6, int i10, List<Integer> list, k kVar) {
        int iMin = Math.min(i10 + i, i6 - 1);
        int i11 = i + 1;
        ArrayList arrayList = null;
        if (i11 <= iMin) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(kVar.invoke(Integer.valueOf(i11)));
                if (i11 == iMin) {
                    break;
                }
                i11++;
            }
        }
        int size = list.size();
        for (int i12 = 0; i12 < size; i12++) {
            int iIntValue = list.get(i12).intValue();
            if (iMin + 1 <= iIntValue && iIntValue < i6) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(kVar.invoke(Integer.valueOf(iIntValue)));
            }
        }
        return arrayList == null ? EmptyList.f4893a : arrayList;
    }

    private static final List<MeasuredPage> createPagesBeforeList(int i, int i6, List<Integer> list, k kVar) {
        int iMax = Math.max(0, i - i6);
        int i10 = i - 1;
        ArrayList arrayList = null;
        if (iMax <= i10) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(kVar.invoke(Integer.valueOf(i10)));
                if (i10 == iMax) {
                    break;
                }
                i10--;
            }
        }
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            int iIntValue = list.get(i11).intValue();
            if (iIntValue < iMax) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(kVar.invoke(Integer.valueOf(iIntValue)));
            }
        }
        return arrayList == null ? EmptyList.f4893a : arrayList;
    }

    private static final void debugLog(S7.a aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAndMeasure-SGf7dI0, reason: not valid java name */
    public static final MeasuredPage m943getAndMeasureSGf7dI0(LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, long j5, PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, long j6, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z10, int i6) {
        return new MeasuredPage(i, i6, lazyLayoutMeasureScope.mo873measure0kLqBqw(i, j5), j6, pagerLazyLayoutItemProvider.getKey(i), orientation, horizontal, vertical, layoutDirection, z10, null);
    }

    /* renamed from: measurePager-bmk8ZPk, reason: not valid java name */
    public static final PagerMeasureResult m944measurePagerbmk8ZPk(final LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, final PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, int i6, int i10, int i11, int i12, int i13, int i14, long j5, final Orientation orientation, final Alignment.Vertical vertical, final Alignment.Horizontal horizontal, final boolean z10, final long j6, final int i15, int i16, List<Integer> list, SnapPosition snapPosition, final MutableState<r> mutableState, InterfaceC1733z interfaceC1733z, S7.o oVar) {
        int i17;
        int iMax;
        int i18;
        int i19;
        int i20;
        List<MeasuredPage> arrayList;
        List arrayList2;
        List arrayList3;
        int i21;
        if (i10 < 0) {
            throw new IllegalArgumentException("negative beforeContentPadding");
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("negative afterContentPadding");
        }
        int i22 = i15 + i12;
        if (i22 < 0) {
            i22 = 0;
        }
        if (i <= 0) {
            return new PagerMeasureResult(EmptyList.f4893a, i15, i12, i11, orientation, -i10, i6 + i11, false, i16, null, null, 0.0f, 0, false, snapPosition, (MeasureResult) oVar.invoke(Integer.valueOf(Constraints.m6799getMinWidthimpl(j5)), Integer.valueOf(Constraints.m6798getMinHeightimpl(j5)), new k() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$4
                public final void invoke(Placeable.PlacementScope placementScope) {
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return r.f317a;
                }
            }), false, null, null, interfaceC1733z, 393216, null);
        }
        Orientation orientation2 = orientation;
        Orientation orientation3 = Orientation.Vertical;
        final long jConstraints$default = ConstraintsKt.Constraints$default(0, orientation2 == orientation3 ? Constraints.m6797getMaxWidthimpl(j5) : i15, 0, orientation2 != orientation3 ? Constraints.m6796getMaxHeightimpl(j5) : i15, 5, null);
        int i23 = i13;
        int i24 = i14;
        while (i23 > 0 && i24 > 0) {
            i23--;
            i24 -= i22;
        }
        int i25 = i24 * (-1);
        if (i23 >= i) {
            i23 = i - 1;
            i25 = 0;
        }
        p pVar = new p();
        int i26 = -i10;
        int i27 = (i12 < 0 ? i12 : 0) + i26;
        int i28 = i25 + i27;
        int iMax2 = 0;
        while (i28 < 0 && i23 > 0) {
            int i29 = i23 - 1;
            MeasuredPage measuredPageM943getAndMeasureSGf7dI0 = m943getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i29, jConstraints$default, pagerLazyLayoutItemProvider, j6, orientation2, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z10, i15);
            pVar.add(0, measuredPageM943getAndMeasureSGf7dI0);
            iMax2 = Math.max(iMax2, measuredPageM943getAndMeasureSGf7dI0.getCrossAxisSize());
            i28 += i22;
            i27 = i27;
            i23 = i29;
            orientation2 = orientation;
        }
        int i30 = i27;
        int i31 = iMax2;
        if (i28 < i30) {
            i28 = i30;
        }
        int i32 = i28 - i30;
        int i33 = i6 + i11;
        int i34 = i33 >= 0 ? i33 : 0;
        int i35 = -i32;
        int i36 = i23;
        int i37 = i36;
        int i38 = 0;
        boolean z11 = false;
        while (i38 < pVar.size()) {
            if (i35 >= i34) {
                pVar.remove(i38);
                z11 = true;
            } else {
                i37++;
                i35 += i22;
                i38++;
            }
        }
        int i39 = i32;
        int iMax3 = i31;
        int i40 = i37;
        boolean z12 = z11;
        while (i40 < i && (i35 < i34 || i35 <= 0 || pVar.isEmpty())) {
            int i41 = i34;
            int i42 = i40;
            MeasuredPage measuredPageM943getAndMeasureSGf7dI02 = m943getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i42, jConstraints$default, pagerLazyLayoutItemProvider, j6, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z10, i15);
            int i43 = i39;
            int i44 = i - 1;
            i35 += i42 == i44 ? i15 : i22;
            if (i35 > i30 || i42 == i44) {
                iMax3 = Math.max(iMax3, measuredPageM943getAndMeasureSGf7dI02.getCrossAxisSize());
                pVar.addLast(measuredPageM943getAndMeasureSGf7dI02);
                i21 = i36;
                i39 = i43;
            } else {
                i21 = i42 + 1;
                i39 = i43 - i22;
                z12 = true;
            }
            i40 = i42 + 1;
            i36 = i21;
            i34 = i41;
        }
        int i45 = i39;
        if (i35 < i6) {
            int i46 = i6 - i35;
            i18 = i45 - i46;
            i35 += i46;
            iMax = iMax3;
            i19 = i36;
            while (i18 < i10 && i19 > 0) {
                int i47 = i19 - 1;
                MeasuredPage measuredPageM943getAndMeasureSGf7dI03 = m943getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i47, jConstraints$default, pagerLazyLayoutItemProvider, j6, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z10, i15);
                pVar.add(0, measuredPageM943getAndMeasureSGf7dI03);
                iMax = Math.max(iMax, measuredPageM943getAndMeasureSGf7dI03.getCrossAxisSize());
                i18 += i22;
                i40 = i40;
                i19 = i47;
            }
            i17 = i40;
            if (i18 < 0) {
                i35 += i18;
                i18 = 0;
            }
        } else {
            i17 = i40;
            iMax = iMax3;
            i18 = i45;
            i19 = i36;
        }
        if (i18 < 0) {
            throw new IllegalArgumentException("invalid currentFirstPageScrollOffset");
        }
        int i48 = iMax;
        int i49 = -i18;
        MeasuredPage measuredPage = (MeasuredPage) pVar.first();
        if (i10 > 0 || i12 < 0) {
            int size = pVar.size();
            i20 = i49;
            int i50 = 0;
            while (i50 < size && i18 != 0 && i22 <= i18 && i50 != o.H(pVar)) {
                i18 -= i22;
                i50++;
                measuredPage = (MeasuredPage) pVar.get(i50);
            }
        } else {
            i20 = i49;
        }
        int i51 = i18;
        MeasuredPage measuredPage2 = measuredPage;
        List<MeasuredPage> listCreatePagesBeforeList = createPagesBeforeList(i19, i16, list, new k() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesBefore$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final MeasuredPage invoke(int i52) {
                LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                return PagerMeasureKt.m943getAndMeasureSGf7dI0(lazyLayoutMeasureScope2, i52, jConstraints$default, pagerLazyLayoutItemProvider, j6, orientation, horizontal, vertical, lazyLayoutMeasureScope2.getLayoutDirection(), z10, i15);
            }
        });
        int size2 = listCreatePagesBeforeList.size();
        int iMax4 = i48;
        int i52 = 0;
        while (i52 < size2) {
            iMax4 = Math.max(iMax4, listCreatePagesBeforeList.get(i52).getCrossAxisSize());
            i52++;
            listCreatePagesBeforeList = listCreatePagesBeforeList;
        }
        List<MeasuredPage> list2 = listCreatePagesBeforeList;
        List<MeasuredPage> listCreatePagesAfterList = createPagesAfterList(((MeasuredPage) pVar.last()).getIndex(), i, i16, list, new k() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesAfter$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final MeasuredPage invoke(int i53) {
                LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                return PagerMeasureKt.m943getAndMeasureSGf7dI0(lazyLayoutMeasureScope2, i53, jConstraints$default, pagerLazyLayoutItemProvider, j6, orientation, horizontal, vertical, lazyLayoutMeasureScope2.getLayoutDirection(), z10, i15);
            }
        });
        int size3 = listCreatePagesAfterList.size();
        for (int i53 = 0; i53 < size3; i53++) {
            iMax4 = Math.max(iMax4, listCreatePagesAfterList.get(i53).getCrossAxisSize());
        }
        boolean z13 = kotlin.jvm.internal.k.b(measuredPage2, pVar.first()) && list2.isEmpty() && listCreatePagesAfterList.isEmpty();
        Orientation orientation4 = Orientation.Vertical;
        int iM6814constrainWidthK40F9xA = ConstraintsKt.m6814constrainWidthK40F9xA(j5, orientation == orientation4 ? iMax4 : i35);
        if (orientation == orientation4) {
            iMax4 = i35;
        }
        int iM6813constrainHeightK40F9xA = ConstraintsKt.m6813constrainHeightK40F9xA(j5, iMax4);
        int i54 = i35;
        int i55 = i17;
        final List<MeasuredPage> listCalculatePagesOffsets = calculatePagesOffsets(lazyLayoutMeasureScope, pVar, list2, listCreatePagesAfterList, iM6814constrainWidthK40F9xA, iM6813constrainHeightK40F9xA, i54, i6, i20, orientation, z10, lazyLayoutMeasureScope, i12, i15);
        if (z13) {
            arrayList = listCalculatePagesOffsets;
        } else {
            arrayList = new ArrayList<>(listCalculatePagesOffsets.size());
            int size4 = listCalculatePagesOffsets.size();
            int i56 = 0;
            while (i56 < size4) {
                MeasuredPage measuredPage3 = listCalculatePagesOffsets.get(i56);
                MeasuredPage measuredPage4 = measuredPage3;
                MeasuredPage measuredPage5 = measuredPage2;
                int i57 = i55;
                if (measuredPage4.getIndex() >= ((MeasuredPage) pVar.first()).getIndex() && measuredPage4.getIndex() <= ((MeasuredPage) pVar.last()).getIndex()) {
                    arrayList.add(measuredPage3);
                }
                i56++;
                i55 = i57;
                measuredPage2 = measuredPage5;
            }
        }
        MeasuredPage measuredPage6 = measuredPage2;
        int i58 = i55;
        if (list2.isEmpty()) {
            arrayList2 = EmptyList.f4893a;
        } else {
            arrayList2 = new ArrayList(listCalculatePagesOffsets.size());
            int size5 = listCalculatePagesOffsets.size();
            for (int i59 = 0; i59 < size5; i59++) {
                MeasuredPage measuredPage7 = listCalculatePagesOffsets.get(i59);
                if (measuredPage7.getIndex() < ((MeasuredPage) pVar.first()).getIndex()) {
                    arrayList2.add(measuredPage7);
                }
            }
        }
        List list3 = arrayList2;
        if (listCreatePagesAfterList.isEmpty()) {
            arrayList3 = EmptyList.f4893a;
        } else {
            arrayList3 = new ArrayList(listCalculatePagesOffsets.size());
            int size6 = listCalculatePagesOffsets.size();
            for (int i60 = 0; i60 < size6; i60++) {
                MeasuredPage measuredPage8 = listCalculatePagesOffsets.get(i60);
                if (measuredPage8.getIndex() > ((MeasuredPage) pVar.last()).getIndex()) {
                    arrayList3.add(measuredPage8);
                }
            }
        }
        List list4 = arrayList3;
        int i61 = i22;
        MeasuredPage measuredPageCalculateNewCurrentPage = calculateNewCurrentPage(orientation == Orientation.Vertical ? iM6813constrainHeightK40F9xA : iM6814constrainWidthK40F9xA, arrayList, i10, i11, i61, snapPosition, i);
        return new PagerMeasureResult(arrayList, i15, i12, i11, orientation, i26, i33, z10, i16, measuredPage6, measuredPageCalculateNewCurrentPage, i61 == 0 ? 0.0f : AbstractC1451a.t((snapPosition.position(i6, i15, i10, i11, measuredPageCalculateNewCurrentPage != null ? measuredPageCalculateNewCurrentPage.getIndex() : 0, i) - (measuredPageCalculateNewCurrentPage != null ? measuredPageCalculateNewCurrentPage.getOffset() : 0)) / i61, -0.5f, 0.5f), i51, i58 < i || i54 > i6, snapPosition, (MeasureResult) oVar.invoke(Integer.valueOf(iM6814constrainWidthK40F9xA), Integer.valueOf(iM6813constrainHeightK40F9xA), new k() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$14
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return r.f317a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                List<MeasuredPage> list5 = listCalculatePagesOffsets;
                int size7 = list5.size();
                for (int i62 = 0; i62 < size7; i62++) {
                    list5.get(i62).place(placementScope);
                }
                ObservableScopeInvalidator.m876attachToScopeimpl(mutableState);
            }
        }), z12, list3, list4, interfaceC1733z);
    }
}
