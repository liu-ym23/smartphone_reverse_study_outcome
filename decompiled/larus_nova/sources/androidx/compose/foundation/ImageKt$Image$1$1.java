package androidx.compose.foundation;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ImageKt$Image$1$1 implements MeasurePolicy {
    public static final ImageKt$Image$1$1 INSTANCE = null;

    static {
        INSTANCE = new ImageKt$Image$1$1();
    }

    public ImageKt$Image$1$1() {
    }

    public static /* synthetic */ Unit a(Placeable.PlacementScope r100) {
        return measure_3p2s80s$lambda$0(r100);
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

    private static final Unit measure_3p2s80s$lambda$0(Placeable.PlacementScope r100) {
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo33measure3p2s80s(MeasureScope r100, List<? extends Measurable> r101, long r110) {
        return MeasureScope.CC.layout$default(r100, Constraints.m7489getMinWidthimpl(r110), Constraints.m7488getMinHeightimpl(r110), null, new q0(), 4, null);
    }
}
