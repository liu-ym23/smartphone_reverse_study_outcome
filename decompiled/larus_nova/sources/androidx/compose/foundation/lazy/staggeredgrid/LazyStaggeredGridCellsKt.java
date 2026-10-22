package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¨\u0006\u0006"}, d2 = {"calculateCellsCrossAxisSizeImpl", "", "gridSize", "", "slotCount", "spacing", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyStaggeredGridCellsKt {
    public static final /* synthetic */ int[] access$calculateCellsCrossAxisSizeImpl(int r100, int r101, int r102) {
        return calculateCellsCrossAxisSizeImpl(r100, r101, r102);
    }

    private static final int[] calculateCellsCrossAxisSizeImpl(int r100, int r101, int r102) {
        int r103 = r100 - (r102 * (r101 - 1));
        int r104 = r103 / r101;
        int r105 = r103 % r101;
        int[] r106 = new int[r101];
        int r107 = 0;
    L3:
        if (r107 >= r101) goto L11;
        if (r104 >= 0) goto L6;
        int r108 = 0;
    L10:
        r106[r107] = r108;
        r107 = r107 + 1;
        goto L3
    L6:
        if (r107 >= r105) goto L8;
        int r109 = 1;
    L9:
        r108 = r109 + r104;
        goto L10
    L8:
        r109 = 0;
        goto L9
    L11:
        return r106;
    }
}
