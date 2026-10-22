package androidx.compose.foundation.text;

import C7.r;
import S7.k;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00050\u0002¢\u0006\u0004\b\b\u0010\tJ,\u0010\u0012\u001a\u00020\u000f*\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0013R$\u0010\u0007\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00050\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/text/TextMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "Lkotlin/Function0;", "", "shouldMeasureLinks", "", "Landroidx/compose/ui/geometry/Rect;", "placements", AppAgent.CONSTRUCT, "(LS7/a;LS7/a;)V", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurables", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "LS7/a;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class TextMeasurePolicy implements MeasurePolicy {
    private final S7.a placements;
    private final S7.a shouldMeasureLinks;

    public TextMeasurePolicy(S7.a aVar, S7.a aVar2) {
        this.shouldMeasureLinks = aVar;
        this.placements = aVar2;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo37measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Measurable measurable = list.get(i);
            if (!(measurable.getParentData() instanceof TextRangeLayoutModifier)) {
                arrayList.add(measurable);
            }
        }
        List list2 = (List) this.placements.invoke();
        final ArrayList arrayList2 = null;
        if (list2 != null) {
            ArrayList arrayList3 = new ArrayList(list2.size());
            int size2 = list2.size();
            for (int i6 = 0; i6 < size2; i6++) {
                Rect rect = (Rect) list2.get(i6);
                Pair pair = rect != null ? new Pair(((Measurable) arrayList.get(i6)).mo5549measureBRTryo0(ConstraintsKt.Constraints$default(0, (int) Math.floor(rect.getWidth()), 0, (int) Math.floor(rect.getHeight()), 5, null)), IntOffset.m6963boximpl(IntOffsetKt.IntOffset(Math.round(rect.getLeft()), Math.round(rect.getTop())))) : null;
                if (pair != null) {
                    arrayList3.add(pair);
                }
            }
            arrayList2 = arrayList3;
        }
        ArrayList arrayList4 = new ArrayList(list.size());
        int size3 = list.size();
        for (int i10 = 0; i10 < size3; i10++) {
            Measurable measurable2 = list.get(i10);
            if (measurable2.getParentData() instanceof TextRangeLayoutModifier) {
                arrayList4.add(measurable2);
            }
        }
        final List listMeasureWithTextRangeMeasureConstraints = BasicTextKt.measureWithTextRangeMeasureConstraints(arrayList4, this.shouldMeasureLinks);
        return MeasureScope.layout$default(measureScope, Constraints.m6797getMaxWidthimpl(j5), Constraints.m6796getMaxHeightimpl(j5), null, new k() { // from class: androidx.compose.foundation.text.TextMeasurePolicy$measure$1
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
                List<Pair<Placeable, IntOffset>> list3 = arrayList2;
                if (list3 != null) {
                    int size4 = list3.size();
                    for (int i11 = 0; i11 < size4; i11++) {
                        Pair<Placeable, IntOffset> pair2 = list3.get(i11);
                        Placeable.PlacementScope.m5617place70tqf50$default(placementScope, (Placeable) pair2.f4886a, ((IntOffset) pair2.b).m6981unboximpl(), 0.0f, 2, null);
                    }
                }
                List<Pair<Placeable, S7.a>> list4 = listMeasureWithTextRangeMeasureConstraints;
                if (list4 != null) {
                    int size5 = list4.size();
                    for (int i12 = 0; i12 < size5; i12++) {
                        Pair<Placeable, S7.a> pair3 = list4.get(i12);
                        Placeable placeable = (Placeable) pair3.f4886a;
                        S7.a aVar = (S7.a) pair3.b;
                        Placeable.PlacementScope.m5617place70tqf50$default(placementScope, placeable, aVar != null ? ((IntOffset) aVar.invoke()).m6981unboximpl() : IntOffset.INSTANCE.m6983getZeronOccac(), 0.0f, 2, null);
                    }
                }
            }
        }, 4, null);
    }
}
