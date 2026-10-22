package androidx.compose.foundation.text;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class AnnotatedStringResolveInlineContentKt$InlineChildren$1$2$1 implements MeasurePolicy {
    public static final AnnotatedStringResolveInlineContentKt$InlineChildren$1$2$1 INSTANCE = null;

    static {
        INSTANCE = new AnnotatedStringResolveInlineContentKt$InlineChildren$1$2$1();
    }

    public AnnotatedStringResolveInlineContentKt$InlineChildren$1$2$1() {
    }

    public static /* synthetic */ Unit a(List r100, Placeable.PlacementScope r101) {
        return measure_3p2s80s$lambda$2(r100, r101);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope r100, List r101, int r102) {
        return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, r100, r101, r102);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope r100, List r101, int r102) {
        return MeasurePolicy.CC.$default$maxIntrinsicWidth(this, r100, r101, r102);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope r100, List r101, int r102) {
        return MeasurePolicy.CC.$default$minIntrinsicHeight(this, r100, r101, r102);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope r100, List r101, int r102) {
        return MeasurePolicy.CC.$default$minIntrinsicWidth(this, r100, r101, r102);
    }

    private static final Unit measure_3p2s80s$lambda$2(List r110, Placeable.PlacementScope r111) {
        int r100 = r110.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L6;
        Placeable.PlacementScope.placeRelative$default(r111, (Placeable) ListProtector.get(r110, r101), 0, 0, 0.0f, 4, null);
        r101 = r101 + 1;
        goto L3
    L6:
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo33measure3p2s80s(MeasureScope r110, List<? extends Measurable> r111, long r112) {
        final ArrayList r100 = new ArrayList(r111.size());
        int r101 = r111.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L6;
        r100.add(((Measurable) ListProtector.get(r111, r102)).mo6256measureBRTryo0(r112));
        r102 = r102 + 1;
        goto L3
    L6:
        return MeasureScope.CC.layout$default(r110, Constraints.m7487getMaxWidthimpl(r112), Constraints.m7486getMaxHeightimpl(r112), null, new g(r100), 4, null);
    }
}
