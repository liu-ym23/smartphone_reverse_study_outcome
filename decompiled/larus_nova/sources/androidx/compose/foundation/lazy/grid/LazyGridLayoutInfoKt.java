package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\"\u0018\u0010\u0003\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"visibleLinesAverageMainAxisSize", "", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "singleAxisViewportSize", "getSingleAxisViewportSize", "(Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;)I", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyGridLayoutInfoKt {
    public static final int getSingleAxisViewportSize(LazyGridLayoutInfo r100) {
        if (r100.getOrientation() != Orientation.Vertical) goto L5;
        long r101 = r100.mo864getViewportSizeYbymL2g() & BodyPartID.bodyIdMax;
    L7:
        return (int) r101;
    L5:
        r101 = r100.mo864getViewportSizeYbymL2g() >> 32;
        goto L7
    }

    public static final int visibleLinesAverageMainAxisSize(LazyGridLayoutInfo r110) {
        if (r110.getOrientation() != Orientation.Vertical) goto L5;
        boolean r100 = true;
    L6:
        List<LazyGridItemInfo> r101 = r110.getVisibleItemsInfo();
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
    L8:
        if (r102 >= r101.size()) goto L23;
        int r105 = visibleLinesAverageMainAxisSize$lineOf(r100, r110, r102);
        if (r105 == (-1)) goto L11;
        int r106 = 0;
    L14:
        if (r102 >= r101.size()) goto L21;
        if (visibleLinesAverageMainAxisSize$lineOf(r100, r110, r102) != r105) goto L21;
        if (r100 == false) goto L19;
        long r107 = ((LazyGridItemInfo) ListProtector.get(r101, r102)).mo862getSizeYbymL2g() & BodyPartID.bodyIdMax;
    L20:
        r106 = Math.max(r106, (int) r107);
        r102 = r102 + 1;
        goto L14
    L19:
        r107 = ((LazyGridItemInfo) ListProtector.get(r101, r102)).mo862getSizeYbymL2g() >> 32;
    L21:
        r103 = r103 + r106;
        r104 = r104 + 1;
        goto L8
    L11:
        r102 = r102 + 1;
        goto L8
    L23:
        return (r103 / r104) + r110.getMainAxisItemSpacing();
    L5:
        r100 = false;
        goto L6
    }

    private static final int visibleLinesAverageMainAxisSize$lineOf(boolean r100, LazyGridLayoutInfo r101, int r102) {
        if (r100 == false) goto L5;
        return ((LazyGridItemInfo) ListProtector.get(r101.getVisibleItemsInfo(), r102)).getRow();
    L5:
        return ((LazyGridItemInfo) ListProtector.get(r101.getVisibleItemsInfo(), r102)).getColumn();
    }
}
