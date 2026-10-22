package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¨\u0006\u0006"}, d2 = {"calculateCellsCrossAxisSizeImpl", "", "gridSize", "", "slotCount", "spacing", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyStaggeredGridCellsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int[] calculateCellsCrossAxisSizeImpl(int i, int i6, int i10) {
        int i11;
        int i12 = i - ((i6 - 1) * i10);
        int i13 = i12 / i6;
        int i14 = i12 % i6;
        int[] iArr = new int[i6];
        int i15 = 0;
        while (i15 < i6) {
            if (i13 < 0) {
                i11 = 0;
            } else {
                i11 = (i15 < i14 ? 1 : 0) + i13;
            }
            iArr[i15] = i11;
            i15++;
        }
        return iArr;
    }
}
