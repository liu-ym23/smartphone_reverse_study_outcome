package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measured;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@LayoutScopeMarker
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u0003*\u00020\u00032\b\b\u0001\u0010\u0002\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H'J\u0014\u0010\u0007\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\b\u001a\u00020\tH'J\u0014\u0010\n\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH'J\f\u0010\r\u001a\u00020\u0003*\u00020\u0003H'J \u0010\n\u001a\u00020\u0003*\u00020\u00032\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/RowScope;", "", "weight", "Landroidx/compose/ui/Modifier;", "", LynxVideoManagerLite.FILL, "", "align", "alignment", "Landroidx/compose/ui/Alignment$Vertical;", "alignBy", "alignmentLine", "Landroidx/compose/ui/layout/HorizontalAlignmentLine;", "alignByBaseline", "alignmentLineBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface RowScope {

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.RowScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Modifier weight$default(RowScope r100, Modifier r101, float r102, boolean r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 2) == 0) goto L7;
            r103 = true;
        L7:
            return r100.weight(r101, r102, r103);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: weight");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Modifier weight$default(RowScope r100, Modifier r101, float r102, boolean r103, int r104, Object r105) {
            return CC.weight$default(r100, r101, r102, r103, r104, r105);
        }
    }

    Modifier align(Modifier r100, Alignment.Vertical r101);

    Modifier alignBy(Modifier r100, HorizontalAlignmentLine r101);

    Modifier alignBy(Modifier r100, Function1<? super Measured, Integer> r101);

    Modifier alignByBaseline(Modifier r100);

    Modifier weight(Modifier r100, float r101, boolean r102);
}
