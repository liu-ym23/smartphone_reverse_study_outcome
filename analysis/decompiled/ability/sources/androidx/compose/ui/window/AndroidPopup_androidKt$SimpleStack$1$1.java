package androidx.compose.ui.window;

import C7.r;
import H4.o;
import S7.k;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AndroidPopup_androidKt$SimpleStack$1$1 implements MeasurePolicy {
    public static final AndroidPopup_androidKt$SimpleStack$1$1 INSTANCE = new AndroidPopup_androidKt$SimpleStack$1$1();

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo37measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
        int size = list.size();
        if (size == 0) {
            return MeasureScope.layout$default(measureScope, 0, 0, null, new k() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1$1.1
                public final void invoke(Placeable.PlacementScope placementScope) {
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return r.f317a;
                }
            }, 4, null);
        }
        if (size == 1) {
            final Placeable placeableMo5549measureBRTryo0 = list.get(0).mo5549measureBRTryo0(j5);
            return MeasureScope.layout$default(measureScope, placeableMo5549measureBRTryo0.getWidth(), placeableMo5549measureBRTryo0.getHeight(), null, new k() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1$1.2
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return r.f317a;
                }

                public final void invoke(Placeable.PlacementScope placementScope) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo5549measureBRTryo0, 0, 0, 0.0f, 4, null);
                }
            }, 4, null);
        }
        final ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        int iMax = 0;
        int iMax2 = 0;
        for (int i = 0; i < size2; i++) {
            Placeable placeableMo5549measureBRTryo02 = list.get(i).mo5549measureBRTryo0(j5);
            iMax = Math.max(iMax, placeableMo5549measureBRTryo02.getWidth());
            iMax2 = Math.max(iMax2, placeableMo5549measureBRTryo02.getHeight());
            arrayList.add(placeableMo5549measureBRTryo02);
        }
        return MeasureScope.layout$default(measureScope, iMax, iMax2, null, new k() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$SimpleStack$1$1.3
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
                int iH = o.H(arrayList);
                if (iH < 0) {
                    return;
                }
                int i6 = 0;
                while (true) {
                    Placeable.PlacementScope placementScope2 = placementScope;
                    Placeable.PlacementScope.placeRelative$default(placementScope2, arrayList.get(i6), 0, 0, 0.0f, 4, null);
                    if (i6 == iH) {
                        return;
                    }
                    i6++;
                    placementScope = placementScope2;
                }
            }
        }, 4, null);
    }
}
