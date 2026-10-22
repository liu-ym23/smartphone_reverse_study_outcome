package androidx.compose.material3;

import D7.v;
import S7.n;
import androidx.compose.material3.ListItemType;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JI\u0010\f\u001a\u00020\b*\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00052\u0006\u0010\t\u001a\u00020\b2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nH\u0002¢\u0006\u0004\b\f\u0010\rJI\u0010\u000f\u001a\u00020\b*\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nH\u0002¢\u0006\u0004\b\u000f\u0010\rJ2\u0010\u0017\u001a\u00020\u0014*\u00020\u00102\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00050\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u0018\u001a\u00020\b*\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00052\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u001a\u001a\u00020\b*\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u0019J/\u0010\u001b\u001a\u00020\b*\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00052\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001b\u0010\u0019J/\u0010\u001c\u001a\u00020\b*\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u0019\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/ListItemMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "measurables", "", "height", "Lkotlin/Function2;", "intrinsicMeasure", "calculateIntrinsicWidth", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Ljava/util/List;ILS7/n;)I", "width", "calculateIntrinsicHeight", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "maxIntrinsicHeight", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Ljava/util/List;I)I", "maxIntrinsicWidth", "minIntrinsicHeight", "minIntrinsicWidth", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class ListItemMeasurePolicy implements MultiContentMeasurePolicy {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.material3.ListItemMeasurePolicy$maxIntrinsicHeight$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements n {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2, IntrinsicMeasurable.class, "maxIntrinsicHeight", "maxIntrinsicHeight(I)I", 0);
        }

        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i) {
            return Integer.valueOf(intrinsicMeasurable.maxIntrinsicHeight(i));
        }

        @Override // S7.n
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.material3.ListItemMeasurePolicy$maxIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    public /* synthetic */ class C06111 extends FunctionReferenceImpl implements n {
        public static final C06111 INSTANCE = new C06111();

        public C06111() {
            super(2, IntrinsicMeasurable.class, "maxIntrinsicWidth", "maxIntrinsicWidth(I)I", 0);
        }

        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i) {
            return Integer.valueOf(intrinsicMeasurable.maxIntrinsicWidth(i));
        }

        @Override // S7.n
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.material3.ListItemMeasurePolicy$minIntrinsicHeight$1, reason: invalid class name and case insensitive filesystem */
    public /* synthetic */ class C06121 extends FunctionReferenceImpl implements n {
        public static final C06121 INSTANCE = new C06121();

        public C06121() {
            super(2, IntrinsicMeasurable.class, "minIntrinsicHeight", "minIntrinsicHeight(I)I", 0);
        }

        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i) {
            return Integer.valueOf(intrinsicMeasurable.minIntrinsicHeight(i));
        }

        @Override // S7.n
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.material3.ListItemMeasurePolicy$minIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    public /* synthetic */ class C06131 extends FunctionReferenceImpl implements n {
        public static final C06131 INSTANCE = new C06131();

        public C06131() {
            super(2, IntrinsicMeasurable.class, "minIntrinsicWidth", "minIntrinsicWidth(I)I", 0);
        }

        public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i) {
            return Integer.valueOf(intrinsicMeasurable.minIntrinsicWidth(i));
        }

        @Override // S7.n
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
        }
    }

    private final int calculateIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i, n nVar) {
        int iIntValue;
        int iIntValue2;
        List<? extends IntrinsicMeasurable> list2 = list.get(0);
        List<? extends IntrinsicMeasurable> list3 = list.get(1);
        List<? extends IntrinsicMeasurable> list4 = list.get(2);
        List<? extends IntrinsicMeasurable> list5 = list.get(3);
        List<? extends IntrinsicMeasurable> list6 = list.get(4);
        int iSubtractConstraintSafely = ListItemKt.subtractConstraintSafely(i, intrinsicMeasureScope.mo375roundToPx0680j_4(Dp.m6844constructorimpl(ListItemKt.getListItemEndPadding() + ListItemKt.getListItemStartPadding())));
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) v.C0(list5);
        if (intrinsicMeasurable != null) {
            iIntValue = ((Number) nVar.invoke(intrinsicMeasurable, Integer.valueOf(iSubtractConstraintSafely))).intValue();
            iSubtractConstraintSafely = ListItemKt.subtractConstraintSafely(iSubtractConstraintSafely, intrinsicMeasurable.maxIntrinsicWidth(Integer.MAX_VALUE));
        } else {
            iIntValue = 0;
        }
        IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) v.C0(list6);
        if (intrinsicMeasurable2 != null) {
            iIntValue2 = ((Number) nVar.invoke(intrinsicMeasurable2, Integer.valueOf(iSubtractConstraintSafely))).intValue();
            iSubtractConstraintSafely = ListItemKt.subtractConstraintSafely(iSubtractConstraintSafely, intrinsicMeasurable2.maxIntrinsicWidth(Integer.MAX_VALUE));
        } else {
            iIntValue2 = 0;
        }
        Object obj = (IntrinsicMeasurable) v.C0(list3);
        int iIntValue3 = obj != null ? ((Number) nVar.invoke(obj, Integer.valueOf(iSubtractConstraintSafely))).intValue() : 0;
        Object obj2 = (IntrinsicMeasurable) v.C0(list4);
        int iIntValue4 = obj2 != null ? ((Number) nVar.invoke(obj2, Integer.valueOf(iSubtractConstraintSafely))).intValue() : 0;
        int iM1975invokeZLSjz4$material3_release = ListItemType.INSTANCE.m1975invokeZLSjz4$material3_release(iIntValue3 > 0, iIntValue4 > 0, ListItemKt.isSupportingMultilineHeuristic(intrinsicMeasureScope, iIntValue4));
        Object obj3 = (IntrinsicMeasurable) v.C0(list2);
        return ListItemKt.m1960calculateHeightN4Jib3Y(intrinsicMeasureScope, iIntValue, iIntValue2, obj3 != null ? ((Number) nVar.invoke(obj3, Integer.valueOf(i))).intValue() : 0, iIntValue3, iIntValue4, iM1975invokeZLSjz4$material3_release, intrinsicMeasureScope.mo375roundToPx0680j_4(Dp.m6844constructorimpl(ListItemKt.m1962verticalPaddingyh95HIg(iM1975invokeZLSjz4$material3_release) * 2)), ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null));
    }

    private final int calculateIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i, n nVar) {
        List<? extends IntrinsicMeasurable> list2 = list.get(0);
        List<? extends IntrinsicMeasurable> list3 = list.get(1);
        List<? extends IntrinsicMeasurable> list4 = list.get(2);
        List<? extends IntrinsicMeasurable> list5 = list.get(3);
        List<? extends IntrinsicMeasurable> list6 = list.get(4);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) v.C0(list5);
        int iIntValue = intrinsicMeasurable != null ? ((Number) nVar.invoke(intrinsicMeasurable, Integer.valueOf(i))).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) v.C0(list6);
        int iIntValue2 = intrinsicMeasurable2 != null ? ((Number) nVar.invoke(intrinsicMeasurable2, Integer.valueOf(i))).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) v.C0(list2);
        int iIntValue3 = intrinsicMeasurable3 != null ? ((Number) nVar.invoke(intrinsicMeasurable3, Integer.valueOf(i))).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) v.C0(list3);
        int iIntValue4 = intrinsicMeasurable4 != null ? ((Number) nVar.invoke(intrinsicMeasurable4, Integer.valueOf(i))).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable5 = (IntrinsicMeasurable) v.C0(list4);
        return ListItemKt.m1961calculateWidthyeHjK3Y(intrinsicMeasureScope, iIntValue, iIntValue2, iIntValue3, iIntValue4, intrinsicMeasurable5 != null ? ((Number) nVar.invoke(intrinsicMeasurable5, Integer.valueOf(i))).intValue() : 0, intrinsicMeasureScope.mo375roundToPx0680j_4(Dp.m6844constructorimpl(ListItemKt.getListItemEndPadding() + ListItemKt.getListItemStartPadding())), ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null));
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        return calculateIntrinsicHeight(intrinsicMeasureScope, list, i, AnonymousClass1.INSTANCE);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        return calculateIntrinsicWidth(intrinsicMeasureScope, list, i, C06111.INSTANCE);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo648measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j5) {
        long j6;
        Placeable placeableMo5549measureBRTryo0;
        float f;
        List<? extends Measurable> list2;
        long j10;
        Placeable placeableMo5549measureBRTryo02;
        float f7;
        Placeable placeableMo5549measureBRTryo03;
        List<? extends Measurable> list3 = list.get(0);
        List<? extends Measurable> list4 = list.get(1);
        List<? extends Measurable> list5 = list.get(2);
        List<? extends Measurable> list6 = list.get(3);
        List<? extends Measurable> list7 = list.get(4);
        long jM6787copyZbe2FdA$default = Constraints.m6787copyZbe2FdA$default(j5, 0, 0, 0, 0, 10, null);
        float listItemStartPadding = ListItemKt.getListItemStartPadding();
        float listItemEndPadding = ListItemKt.getListItemEndPadding();
        int iMo375roundToPx0680j_4 = measureScope.mo375roundToPx0680j_4(Dp.m6844constructorimpl(listItemStartPadding + listItemEndPadding));
        Measurable measurable = (Measurable) v.C0(list6);
        int iMinIntrinsicWidth = measurable != null ? measurable.minIntrinsicWidth(Constraints.m6796getMaxHeightimpl(j5)) : 0;
        Measurable measurable2 = (Measurable) v.C0(list7);
        int iSubtractConstraintSafely = ListItemKt.subtractConstraintSafely(Constraints.m6797getMaxWidthimpl(jM6787copyZbe2FdA$default), iMinIntrinsicWidth + (measurable2 != null ? measurable2.minIntrinsicWidth(Constraints.m6796getMaxHeightimpl(j5)) : 0) + iMo375roundToPx0680j_4);
        Measurable measurable3 = (Measurable) v.C0(list5);
        boolean zIsSupportingMultilineHeuristic = ListItemKt.isSupportingMultilineHeuristic(measureScope, measurable3 != null ? measurable3.minIntrinsicHeight(iSubtractConstraintSafely) : 0);
        ListItemType.Companion companion = ListItemType.INSTANCE;
        float f9 = 2;
        long jM6816offsetNN6EwU = ConstraintsKt.m6816offsetNN6EwU(jM6787copyZbe2FdA$default, -iMo375roundToPx0680j_4, -measureScope.mo375roundToPx0680j_4(Dp.m6844constructorimpl(ListItemKt.m1962verticalPaddingyh95HIg(companion.m1975invokeZLSjz4$material3_release(v.C0(list4) != null, v.C0(list5) != null, zIsSupportingMultilineHeuristic)) * f9)));
        Measurable measurable4 = (Measurable) v.C0(list6);
        Placeable placeableMo5549measureBRTryo04 = measurable4 != null ? measurable4.mo5549measureBRTryo0(jM6816offsetNN6EwU) : null;
        int iWidthOrZero = TextFieldImplKt.widthOrZero(placeableMo5549measureBRTryo04);
        Measurable measurable5 = (Measurable) v.C0(list7);
        if (measurable5 != null) {
            j6 = jM6816offsetNN6EwU;
            placeableMo5549measureBRTryo0 = measurable5.mo5549measureBRTryo0(ConstraintsKt.m6817offsetNN6EwU$default(j6, -iWidthOrZero, 0, 2, null));
        } else {
            j6 = jM6816offsetNN6EwU;
            placeableMo5549measureBRTryo0 = null;
        }
        int iWidthOrZero2 = TextFieldImplKt.widthOrZero(placeableMo5549measureBRTryo0) + iWidthOrZero;
        Measurable measurable6 = (Measurable) v.C0(list3);
        if (measurable6 != null) {
            list2 = list5;
            f = f9;
            j10 = j6;
            placeableMo5549measureBRTryo02 = measurable6.mo5549measureBRTryo0(ConstraintsKt.m6817offsetNN6EwU$default(j6, -iWidthOrZero2, 0, 2, null));
        } else {
            f = f9;
            list2 = list5;
            j10 = j6;
            placeableMo5549measureBRTryo02 = null;
        }
        int iHeightOrZero = TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo02);
        Measurable measurable7 = (Measurable) v.C0(list2);
        if (measurable7 != null) {
            f7 = f;
            placeableMo5549measureBRTryo03 = measurable7.mo5549measureBRTryo0(ConstraintsKt.m6816offsetNN6EwU(j10, -iWidthOrZero2, -iHeightOrZero));
        } else {
            f7 = f;
            placeableMo5549measureBRTryo03 = null;
        }
        int iHeightOrZero2 = TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo03) + iHeightOrZero;
        boolean z10 = (placeableMo5549measureBRTryo03 == null || placeableMo5549measureBRTryo03.get(AlignmentLineKt.getFirstBaseline()) == placeableMo5549measureBRTryo03.get(AlignmentLineKt.getLastBaseline())) ? false : true;
        Measurable measurable8 = (Measurable) v.C0(list4);
        Placeable placeableMo5549measureBRTryo05 = measurable8 != null ? measurable8.mo5549measureBRTryo0(ConstraintsKt.m6816offsetNN6EwU(j10, -iWidthOrZero2, -iHeightOrZero2)) : null;
        int iM1975invokeZLSjz4$material3_release = companion.m1975invokeZLSjz4$material3_release(placeableMo5549measureBRTryo05 != null, placeableMo5549measureBRTryo03 != null, z10);
        float fM1962verticalPaddingyh95HIg = ListItemKt.m1962verticalPaddingyh95HIg(iM1975invokeZLSjz4$material3_release);
        return ListItemKt.place(measureScope, ListItemKt.m1961calculateWidthyeHjK3Y(measureScope, TextFieldImplKt.widthOrZero(placeableMo5549measureBRTryo04), TextFieldImplKt.widthOrZero(placeableMo5549measureBRTryo0), TextFieldImplKt.widthOrZero(placeableMo5549measureBRTryo02), TextFieldImplKt.widthOrZero(placeableMo5549measureBRTryo05), TextFieldImplKt.widthOrZero(placeableMo5549measureBRTryo03), iMo375roundToPx0680j_4, j5), ListItemKt.m1960calculateHeightN4Jib3Y(measureScope, TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo04), TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo0), TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo02), TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo05), TextFieldImplKt.heightOrZero(placeableMo5549measureBRTryo03), iM1975invokeZLSjz4$material3_release, measureScope.mo375roundToPx0680j_4(Dp.m6844constructorimpl(fM1962verticalPaddingyh95HIg * f7)), j5), placeableMo5549measureBRTryo04, placeableMo5549measureBRTryo0, placeableMo5549measureBRTryo02, placeableMo5549measureBRTryo05, placeableMo5549measureBRTryo03, ListItemType.m1967equalsimpl0(iM1975invokeZLSjz4$material3_release, companion.m1973getThreeLineAlXitO8()), measureScope.mo375roundToPx0680j_4(listItemStartPadding), measureScope.mo375roundToPx0680j_4(listItemEndPadding), measureScope.mo375roundToPx0680j_4(fM1962verticalPaddingyh95HIg));
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        return calculateIntrinsicHeight(intrinsicMeasureScope, list, i, C06121.INSTANCE);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        return calculateIntrinsicWidth(intrinsicMeasureScope, list, i, C06131.INSTANCE);
    }
}
