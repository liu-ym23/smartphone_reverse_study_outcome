package androidx.compose.material3;

import C7.r;
import S7.k;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"Landroidx/compose/material3/CenteredContentMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class CenteredContentMeasurePolicy implements MeasurePolicy {
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo37measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
        final ArrayList arrayList;
        int iM6797getMaxWidthimpl = Constraints.m6797getMaxWidthimpl(j5);
        int iM6798getMinHeightimpl = Constraints.m6798getMinHeightimpl(j5);
        int size = list.size();
        if (size < 1) {
            return MeasureScope.layout$default(measureScope, iM6797getMaxWidthimpl, iM6798getMinHeightimpl, null, new k() { // from class: androidx.compose.material3.CenteredContentMeasurePolicy$measure$1
                public final void invoke(Placeable.PlacementScope placementScope) {
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return r.f317a;
                }
            }, 4, null);
        }
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        int i = 0;
        if (Constraints.m6793getHasBoundedWidthimpl(j5)) {
            int i6 = iM6797getMaxWidthimpl / size;
            int iCalculateCenteredContentHorizontalPadding = ExpressiveNavigationBarKt.calculateCenteredContentHorizontalPadding(size, iM6797getMaxWidthimpl);
            ref$IntRef.f4918a = iCalculateCenteredContentHorizontalPadding;
            int i10 = (iM6797getMaxWidthimpl - (iCalculateCenteredContentHorizontalPadding * 2)) / size;
            int size2 = list.size();
            for (int i11 = 0; i11 < size2; i11++) {
                int iMaxIntrinsicHeight = list.get(i11).maxIntrinsicHeight(i10);
                if (iM6798getMinHeightimpl < iMaxIntrinsicHeight) {
                    int iM6796getMaxHeightimpl = Constraints.m6796getMaxHeightimpl(j5);
                    if (iMaxIntrinsicHeight > iM6796getMaxHeightimpl) {
                        iMaxIntrinsicHeight = iM6796getMaxHeightimpl;
                    }
                    iM6798getMinHeightimpl = iMaxIntrinsicHeight;
                }
            }
            arrayList = new ArrayList(list.size());
            int size3 = list.size();
            while (i < size3) {
                Measurable measurable = list.get(i);
                int iMaxIntrinsicWidth = measurable.maxIntrinsicWidth(Constraints.m6798getMinHeightimpl(j5));
                if (i10 < iMaxIntrinsicWidth) {
                    if (iMaxIntrinsicWidth > i6) {
                        iMaxIntrinsicWidth = i6;
                    }
                    ref$IntRef.f4918a -= (iMaxIntrinsicWidth - i10) / 2;
                } else {
                    iMaxIntrinsicWidth = i10;
                }
                arrayList.add(measurable.mo5549measureBRTryo0(ConstraintsKt.m6812constrainN9IONVI(j5, Constraints.INSTANCE.m6807fixedJhjzzOo(iMaxIntrinsicWidth, iM6798getMinHeightimpl))));
                i++;
            }
        } else {
            arrayList = new ArrayList(list.size());
            int size4 = list.size();
            while (i < size4) {
                arrayList.add(list.get(i).mo5549measureBRTryo0(ConstraintsKt.m6812constrainN9IONVI(j5, Constraints.INSTANCE.m6808fixedHeightOenEA2s(iM6798getMinHeightimpl))));
                i++;
            }
        }
        return MeasureScope.layout$default(measureScope, iM6797getMaxWidthimpl, iM6798getMinHeightimpl, null, new k() { // from class: androidx.compose.material3.CenteredContentMeasurePolicy$measure$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return r.f317a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                int i12 = ref$IntRef.f4918a;
                List<Placeable> list2 = arrayList;
                int size5 = list2.size();
                int i13 = 0;
                int width = i12;
                while (i13 < size5) {
                    Placeable placeable = list2.get(i13);
                    Placeable.PlacementScope placementScope2 = placementScope;
                    Placeable.PlacementScope.placeRelative$default(placementScope2, placeable, width, 0, 0.0f, 4, null);
                    width += placeable.getWidth();
                    i13++;
                    placementScope = placementScope2;
                }
            }
        }, 4, null);
    }
}
