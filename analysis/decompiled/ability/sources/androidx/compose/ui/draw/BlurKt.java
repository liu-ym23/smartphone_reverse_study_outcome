package androidx.compose.ui.draw;

import C7.r;
import S7.k;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.RenderEffectKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"blur", "Landroidx/compose/ui/Modifier;", "radiusX", "Landroidx/compose/ui/unit/Dp;", "radiusY", "edgeTreatment", "Landroidx/compose/ui/draw/BlurredEdgeTreatment;", "blur-1fqS-gw", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "radius", "blur-F8QBwvs", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BlurKt {
    @Stable
    /* renamed from: blur-1fqS-gw, reason: not valid java name */
    public static final Modifier m3660blur1fqSgw(Modifier modifier, final float f, final float f7, final Shape shape) {
        int iM4529getDecal3opZhB0;
        final boolean z10;
        if (shape != null) {
            iM4529getDecal3opZhB0 = TileMode.INSTANCE.m4528getClamp3opZhB0();
            z10 = true;
        } else {
            iM4529getDecal3opZhB0 = TileMode.INSTANCE.m4529getDecal3opZhB0();
            z10 = false;
        }
        final int i = iM4529getDecal3opZhB0;
        float f9 = 0;
        return ((Dp.m6843compareTo0680j_4(f, Dp.m6844constructorimpl(f9)) <= 0 || Dp.m6843compareTo0680j_4(f7, Dp.m6844constructorimpl(f9)) <= 0) && !z10) ? modifier : GraphicsLayerModifierKt.graphicsLayer(modifier, new k() { // from class: androidx.compose.ui.draw.BlurKt$blur$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GraphicsLayerScope) obj);
                return r.f317a;
            }

            public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                float fMo381toPx0680j_4 = graphicsLayerScope.mo381toPx0680j_4(f);
                float fMo381toPx0680j_42 = graphicsLayerScope.mo381toPx0680j_4(f7);
                graphicsLayerScope.setRenderEffect((fMo381toPx0680j_4 <= 0.0f || fMo381toPx0680j_42 <= 0.0f) ? null : RenderEffectKt.m4458BlurEffect3YTHUZs(fMo381toPx0680j_4, fMo381toPx0680j_42, i));
                Shape rectangleShape = shape;
                if (rectangleShape == null) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                graphicsLayerScope.setShape(rectangleShape);
                graphicsLayerScope.setClip(z10);
            }
        });
    }

    /* renamed from: blur-1fqS-gw$default, reason: not valid java name */
    public static /* synthetic */ Modifier m3661blur1fqSgw$default(Modifier modifier, float f, float f7, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 4) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m3664boximpl(BlurredEdgeTreatment.INSTANCE.m3671getRectangleGoahg());
        }
        return m3660blur1fqSgw(modifier, f, f7, blurredEdgeTreatment.m3670unboximpl());
    }

    @Stable
    /* renamed from: blur-F8QBwvs, reason: not valid java name */
    public static final Modifier m3662blurF8QBwvs(Modifier modifier, float f, Shape shape) {
        return m3660blur1fqSgw(modifier, f, f, shape);
    }

    /* renamed from: blur-F8QBwvs$default, reason: not valid java name */
    public static /* synthetic */ Modifier m3663blurF8QBwvs$default(Modifier modifier, float f, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 2) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m3664boximpl(BlurredEdgeTreatment.INSTANCE.m3671getRectangleGoahg());
        }
        return m3662blurF8QBwvs(modifier, f, blurredEdgeTreatment.m3670unboximpl());
    }
}
