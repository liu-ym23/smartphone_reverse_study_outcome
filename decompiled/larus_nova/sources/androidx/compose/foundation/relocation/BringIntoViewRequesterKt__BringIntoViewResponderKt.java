package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a!\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"bringIntoViewResponder", "Landroidx/compose/ui/Modifier;", "responder", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "localRectOf", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "sourceCoordinates", SVGRenderEngine.RECT, "localRectOf$BringIntoViewRequesterKt__BringIntoViewResponderKt", "foundation_release"}, k = 5, mv = {2, 0, 0}, xi = 48, xs = "androidx/compose/foundation/relocation/BringIntoViewRequesterKt")
final /* synthetic */ class BringIntoViewRequesterKt__BringIntoViewResponderKt {
    @Deprecated(message = "Use BringIntoViewModifierNode instead")
    public static final Modifier bringIntoViewResponder(Modifier r100, BringIntoViewResponder r101) {
        return r100.then(new BringIntoViewResponderElement(r101));
    }

    public static final /* synthetic */ Rect access$localRectOf(LayoutCoordinates r100, LayoutCoordinates r101, Rect r102) {
        return localRectOf$BringIntoViewRequesterKt__BringIntoViewResponderKt(r100, r101, r102);
    }

    private static final Rect localRectOf$BringIntoViewRequesterKt__BringIntoViewResponderKt(LayoutCoordinates r100, LayoutCoordinates r101, Rect r102) {
        return r102.m4619translatek4lQ0M(r100.localBoundingBoxOf(r101, false).m4617getTopLeftF1C5BW0());
    }
}
