package androidx.compose.foundation.draganddrop;

import C7.r;
import S7.k;
import android.graphics.Picture;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@ExperimentalFoundationApi
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/draganddrop/CacheDrawScopeDragShadowCallback;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawScope", "LC7/r;", "drawDragShadow", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;)V", "Landroidx/compose/ui/draw/CacheDrawScope;", "scope", "Landroidx/compose/ui/draw/DrawResult;", "cachePicture", "(Landroidx/compose/ui/draw/CacheDrawScope;)Landroidx/compose/ui/draw/DrawResult;", "Landroid/graphics/Picture;", "cachedPicture", "Landroid/graphics/Picture;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class CacheDrawScopeDragShadowCallback {
    private Picture cachedPicture;

    public final DrawResult cachePicture(CacheDrawScope scope) {
        final Picture picture = new Picture();
        this.cachedPicture = picture;
        final int iM3964getWidthimpl = (int) Size.m3964getWidthimpl(scope.m3676getSizeNHjbRc());
        final int iM3961getHeightimpl = (int) Size.m3961getHeightimpl(scope.m3676getSizeNHjbRc());
        return scope.onDrawWithContent(new k() { // from class: androidx.compose.foundation.draganddrop.CacheDrawScopeDragShadowCallback$cachePicture$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return r.f317a;
            }

            public final void invoke(ContentDrawScope contentDrawScope) {
                Canvas Canvas = AndroidCanvas_androidKt.Canvas(picture.beginRecording(iM3964getWidthimpl, iM3961getHeightimpl));
                LayoutDirection layoutDirection = contentDrawScope.getLayoutDirection();
                long jMo4707getSizeNHjbRc = contentDrawScope.mo4707getSizeNHjbRc();
                Density density = contentDrawScope.getDrawContext().getDensity();
                LayoutDirection layoutDirection2 = contentDrawScope.getDrawContext().getLayoutDirection();
                Canvas canvas = contentDrawScope.getDrawContext().getCanvas();
                long jMo4628getSizeNHjbRc = contentDrawScope.getDrawContext().mo4628getSizeNHjbRc();
                GraphicsLayer graphicsLayer = contentDrawScope.getDrawContext().getGraphicsLayer();
                DrawContext drawContext = contentDrawScope.getDrawContext();
                drawContext.setDensity(contentDrawScope);
                drawContext.setLayoutDirection(layoutDirection);
                drawContext.setCanvas(Canvas);
                drawContext.mo4629setSizeuvyYCjk(jMo4707getSizeNHjbRc);
                drawContext.setGraphicsLayer(null);
                Canvas.save();
                try {
                    contentDrawScope.drawContent();
                    Canvas.restore();
                    DrawContext drawContext2 = contentDrawScope.getDrawContext();
                    drawContext2.setDensity(density);
                    drawContext2.setLayoutDirection(layoutDirection2);
                    drawContext2.setCanvas(canvas);
                    drawContext2.mo4629setSizeuvyYCjk(jMo4628getSizeNHjbRc);
                    drawContext2.setGraphicsLayer(graphicsLayer);
                    picture.endRecording();
                    AndroidCanvas_androidKt.getNativeCanvas(contentDrawScope.getDrawContext().getCanvas()).drawPicture(picture);
                } catch (Throwable th) {
                    Canvas.restore();
                    DrawContext drawContext3 = contentDrawScope.getDrawContext();
                    drawContext3.setDensity(density);
                    drawContext3.setLayoutDirection(layoutDirection2);
                    drawContext3.setCanvas(canvas);
                    drawContext3.mo4629setSizeuvyYCjk(jMo4628getSizeNHjbRc);
                    drawContext3.setGraphicsLayer(graphicsLayer);
                    throw th;
                }
            }
        });
    }

    public final void drawDragShadow(DrawScope drawScope) {
        Picture picture = this.cachedPicture;
        if (picture == null) {
            throw new IllegalArgumentException("No cached drag shadow. Check if Modifier.cacheDragShadow(painter) was called.");
        }
        AndroidCanvas_androidKt.getNativeCanvas(drawScope.getDrawContext().getCanvas()).drawPicture(picture);
    }
}
