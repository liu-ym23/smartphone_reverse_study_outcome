package androidx.compose.material3.carousel;

import androidx.compose.foundation.gestures.snapping.SnapPosition;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000¨\u0006\n"}, d2 = {"getSnapPositionOffset", "", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "Landroidx/compose/material3/carousel/Strategy;", "itemIndex", "itemCount", "KeylineSnapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageSize", "Landroidx/compose/material3/carousel/CarouselPageSize;", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class KeylineSnapPositionKt {
    public static final SnapPosition KeylineSnapPosition(final CarouselPageSize r100) {
        return new AnonymousClass1(r100);
    }

    public static final int getSnapPositionOffset(Strategy r100, int r101, int r102) {
        if (r100.isValid() == true) goto L5;
        return 0;
    L5:
        int r103 = MathKt.roundToInt(r100.getDefaultKeylines().getFirstFocal().getUnadjustedOffset() - (r100.getItemMainAxisSize() / 2.0f));
        if (r101 > CollectionsKt.getLastIndex(r100.getStartKeylineSteps())) goto L8;
        r103 = MathKt.roundToInt(((KeylineList) ListProtector.get(r100.getStartKeylineSteps(), RangesKt.coerceIn(CollectionsKt.getLastIndex(r100.getStartKeylineSteps()) - r101, 0, CollectionsKt.getLastIndex(r100.getStartKeylineSteps())))).getFirstFocal().getUnadjustedOffset() - (r100.getItemMainAxisSize() / 2.0f));
    L8:
        int r104 = r102 - 1;
        if (r101 >= (r104 - CollectionsKt.getLastIndex(r100.getEndKeylineSteps()))) goto L11;
        return r103;
    L11:
        if (r102 > r100.getDefaultKeylines().getFocalCount()) goto L13;
        return r103;
    L13:
        return MathKt.roundToInt(((KeylineList) ListProtector.get(r100.getEndKeylineSteps(), RangesKt.coerceIn(CollectionsKt.getLastIndex(r100.getEndKeylineSteps()) - (r104 - r101), 0, CollectionsKt.getLastIndex(r100.getEndKeylineSteps())))).getFirstFocal().getUnadjustedOffset() - (r100.getItemMainAxisSize() / 2.0f));
    }
}
