package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@LayoutScopeMarker
@Deprecated(message = "ContextualFlowLayouts are no longer maintained")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005H'R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/layout/ContextualFlowRowScope;", "Landroidx/compose/foundation/layout/RowScope;", "fillMaxRowHeight", "Landroidx/compose/ui/Modifier;", "fraction", "", "lineIndex", "", "getLineIndex", "()I", "indexInLine", "getIndexInLine", "maxWidthInLine", "Landroidx/compose/ui/unit/Dp;", "getMaxWidthInLine-D9Ej5fM", "()F", "maxHeight", "getMaxHeight-D9Ej5fM", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ContextualFlowRowScope extends RowScope {

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.ContextualFlowRowScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Modifier fillMaxRowHeight$default(ContextualFlowRowScope r100, Modifier r101, float r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 1) == 0) goto L7;
            r102 = 1.0f;
        L7:
            return r100.fillMaxRowHeight(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillMaxRowHeight");
        }
    }

    Modifier fillMaxRowHeight(Modifier r100, float r101);

    int getIndexInLine();

    int getLineIndex();

    /* JADX INFO: renamed from: getMaxHeight-D9Ej5fM, reason: not valid java name */
    float mo650getMaxHeightD9Ej5fM();

    /* JADX INFO: renamed from: getMaxWidthInLine-D9Ej5fM, reason: not valid java name */
    float mo651getMaxWidthInLineD9Ej5fM();
}
