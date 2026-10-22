package androidx.compose.foundation.contextmenu;

import androidx.annotation.VisibleForTesting;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a*\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001\u001a \u0010\b\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a \u0010\t\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a \u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a(\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a(\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\r"}, d2 = {"alignEndEdges", "", "popupLength", "windowLength", "closeAffinity", "", "alignPopupAxis", "position", "alignPopupEndEdgeToPosition", "alignPopupStartEdgeToPosition", "alignStartEdges", "popupFitsBetweenPositionAndEndEdge", "popupFitsBetweenPositionAndStartEdge", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ContextMenuPopupPositionProvider_androidKt {
    private static final int alignEndEdges(int i, int i6, boolean z10) {
        return alignStartEdges(i, i6, !z10);
    }

    @VisibleForTesting
    public static final int alignPopupAxis(int i, int i6, int i10, boolean z10) {
        return i6 >= i10 ? alignStartEdges(i6, i10, z10) : popupFitsBetweenPositionAndEndEdge(i, i6, i10, z10) ? alignPopupStartEdgeToPosition(i, i6, z10) : popupFitsBetweenPositionAndStartEdge(i, i6, i10, z10) ? alignPopupEndEdgeToPosition(i, i6, z10) : alignEndEdges(i6, i10, z10);
    }

    public static /* synthetic */ int alignPopupAxis$default(int i, int i6, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z10 = true;
        }
        return alignPopupAxis(i, i6, i10, z10);
    }

    private static final int alignPopupEndEdgeToPosition(int i, int i6, boolean z10) {
        return alignPopupStartEdgeToPosition(i, i6, !z10);
    }

    private static final int alignPopupStartEdgeToPosition(int i, int i6, boolean z10) {
        return z10 ? i : i - i6;
    }

    private static final int alignStartEdges(int i, int i6, boolean z10) {
        if (z10) {
            return 0;
        }
        return i6 - i;
    }

    private static final boolean popupFitsBetweenPositionAndEndEdge(int i, int i6, int i10, boolean z10) {
        return popupFitsBetweenPositionAndStartEdge(i, i6, i10, !z10);
    }

    private static final boolean popupFitsBetweenPositionAndStartEdge(int i, int i6, int i10, boolean z10) {
        return z10 ? i6 <= i : i10 - i6 > i;
    }
}
