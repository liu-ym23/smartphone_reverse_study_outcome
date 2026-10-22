package androidx.compose.foundation.contextmenu;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0001\u001a(\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a(\u0010\b\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a \u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a \u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a \u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a \u0010\f\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\r"}, d2 = {"alignPopupAxis", "", "position", "popupLength", "windowLength", "closeAffinity", "", "popupFitsBetweenPositionAndStartEdge", "popupFitsBetweenPositionAndEndEdge", "alignPopupStartEdgeToPosition", "alignPopupEndEdgeToPosition", "alignStartEdges", "alignEndEdges", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ContextMenuPopupPositionProviderKt {
    private static final int alignPopupStartEdgeToPosition(int r100, int r101, boolean r102) {
        if (r102 == false) goto L5;
        return r100;
    L5:
        return r100 - r101;
    }

    private static final int alignStartEdges(int r100, int r101, boolean r102) {
        if (r102 == false) goto L5;
        return 0;
    L5:
        return r101 - r100;
    }

    private static final boolean popupFitsBetweenPositionAndStartEdge(int r100, int r101, int r102, boolean r103) {
        if (r103 == false) goto L7;
        if (r101 <= r100) goto L11;
    L9:
        return false;
    L11:
        return true;
    L7:
        if ((r102 - r101) <= r100) goto L9;
        return true;
    }

    private static final int alignEndEdges(int r100, int r101, boolean r102) {
        return alignStartEdges(r100, r101, !r102);
    }

    private static final int alignPopupEndEdgeToPosition(int r100, int r101, boolean r102) {
        return alignPopupStartEdgeToPosition(r100, r101, !r102);
    }

    public static final int alignPopupAxis(int r100, int r101, int r102, boolean r103) {
        if (r101 < r102) goto L5;
        return alignStartEdges(r101, r102, r103);
    L5:
        if (popupFitsBetweenPositionAndEndEdge(r100, r101, r102, r103) == false) goto L8;
        return alignPopupStartEdgeToPosition(r100, r101, r103);
    L8:
        if (popupFitsBetweenPositionAndStartEdge(r100, r101, r102, r103) == false) goto L11;
        return alignPopupEndEdgeToPosition(r100, r101, r103);
    L11:
        return alignEndEdges(r101, r102, r103);
    }

    private static final boolean popupFitsBetweenPositionAndEndEdge(int r100, int r101, int r102, boolean r103) {
        return popupFitsBetweenPositionAndStartEdge(r100, r101, r102, !r103);
    }

    public static /* synthetic */ int alignPopupAxis$default(int r100, int r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 8) == 0) goto L6;
        r103 = true;
    L6:
        return alignPopupAxis(r100, r101, r102, r103);
    }
}
