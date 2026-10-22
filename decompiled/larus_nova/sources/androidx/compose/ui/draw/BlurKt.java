package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"blur", "Landroidx/compose/ui/Modifier;", "radiusX", "Landroidx/compose/ui/unit/Dp;", "radiusY", "edgeTreatment", "Landroidx/compose/ui/draw/BlurredEdgeTreatment;", "blur-1fqS-gw", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "radius", "blur-F8QBwvs", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BlurKt {
    /* JADX INFO: renamed from: blur-F8QBwvs, reason: not valid java name */
    public static final Modifier m4353blurF8QBwvs(Modifier r100, float r101, Shape r102) {
        return m4351blur1fqSgw(r100, r101, r101, r102);
    }

    /* JADX INFO: renamed from: blur-1fqS-gw, reason: not valid java name */
    public static final Modifier m4351blur1fqSgw(Modifier r100, final float r101, final float r110, final Shape r111) {
        if (r111 == null) goto L5;
        final int r102 = TileMode.Companion.m5226getClamp3opZhB0();
        final boolean r103 = true;
    L6:
        float r104 = 0;
        if (Dp.m7543compareTo0680j_4(r101, Dp.m7544constructorimpl(r104)) > 0) goto L9;
    L10:
        if (r103 == true) goto L12;
        return r100;
    L12:
        return GraphicsLayerModifierKt.graphicsLayer(r100, new BlurKt$blur$1(r101, r110, r102, r111, r103));
    L9:
        if (Dp.m7543compareTo0680j_4(r110, Dp.m7544constructorimpl(r104)) > 0) goto L12;
    L5:
        r102 = TileMode.Companion.m5227getDecal3opZhB0();
        r103 = false;
        goto L6
    }

    /* JADX INFO: renamed from: blur-F8QBwvs$default, reason: not valid java name */
    public static /* synthetic */ Modifier m4354blurF8QBwvs$default(Modifier r100, float r101, BlurredEdgeTreatment r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = BlurredEdgeTreatment.m4355boximpl(BlurredEdgeTreatment.Companion.m4362getRectangleGoahg());
    L6:
        return m4353blurF8QBwvs(r100, r101, r102.m4361unboximpl());
    }

    /* JADX INFO: renamed from: blur-1fqS-gw$default, reason: not valid java name */
    public static /* synthetic */ Modifier m4352blur1fqSgw$default(Modifier r100, float r101, float r102, BlurredEdgeTreatment r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = BlurredEdgeTreatment.m4355boximpl(BlurredEdgeTreatment.Companion.m4362getRectangleGoahg());
    L6:
        return m4351blur1fqSgw(r100, r101, r102, r103.m4361unboximpl());
    }
}
