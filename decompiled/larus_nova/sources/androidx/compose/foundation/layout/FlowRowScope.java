package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@LayoutScopeMarker
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/layout/FlowRowScope;", "Landroidx/compose/foundation/layout/RowScope;", "fillMaxRowHeight", "Landroidx/compose/ui/Modifier;", "fraction", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface FlowRowScope extends RowScope {

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.FlowRowScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Modifier fillMaxRowHeight$default(FlowRowScope r100, Modifier r101, float r102, int r103, Object r104) {
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
}
