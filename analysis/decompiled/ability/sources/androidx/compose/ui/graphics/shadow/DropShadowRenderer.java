package androidx.compose.ui.graphics.shadow;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.CompositeShaderBrush;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.ShaderKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.SingleFileBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ/\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ-\u0010!\u001a\u00020\u001e*\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u001f\u0010 JQ\u0010)\u001a\u00020\u001e*\u00020\u001d2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\"\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010&\u001a\u00020%H\u0014¢\u0006\u0004\b'\u0010(R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u00100R\u0018\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103¨\u00064"}, d2 = {"Landroidx/compose/ui/graphics/shadow/DropShadowRenderer;", "Landroidx/compose/ui/graphics/shadow/ShadowRenderer;", "Landroidx/compose/ui/graphics/shadow/Shadow;", "shadow", "Landroidx/compose/ui/graphics/Outline;", "outline", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/graphics/shadow/Shadow;Landroidx/compose/ui/graphics/Outline;)V", "Landroidx/compose/ui/graphics/ImageBitmap;", "shadowBitmap", "Landroidx/compose/ui/graphics/Brush;", "brush", "obtainCompositeBrush", "(Landroidx/compose/ui/graphics/ImageBitmap;Landroidx/compose/ui/graphics/Brush;)Landroidx/compose/ui/graphics/Brush;", "Landroidx/compose/ui/geometry/Size;", "size", "Landroidx/compose/ui/graphics/Path;", SingleFileBundle.KEY_PATH, "", "radius", "spread", "createOuterShadowBitmap-Cqks5Fs", "(JLandroidx/compose/ui/graphics/Path;FF)Landroidx/compose/ui/graphics/ImageBitmap;", "createOuterShadowBitmap", "shadowRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "cornerRadius", "createOuterShadowBitmap-D_oqF2M", "(JFFJ)Landroidx/compose/ui/graphics/ImageBitmap;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "LC7/r;", "buildShadow-_SMYjrA", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJLandroidx/compose/ui/graphics/Path;)V", "buildShadow", "alpha", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "onDrawShadow-MLmccfk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJLandroidx/compose/ui/graphics/Path;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/ui/graphics/Brush;I)V", "onDrawShadow", "Landroidx/compose/ui/graphics/shadow/Shadow;", "getShadow", "()Landroidx/compose/ui/graphics/shadow/Shadow;", "Landroidx/compose/ui/graphics/Paint;", "paint", "Landroidx/compose/ui/graphics/Paint;", "Landroidx/compose/ui/graphics/ImageBitmap;", "Landroidx/compose/ui/graphics/CompositeShaderBrush;", "compositeShader", "Landroidx/compose/ui/graphics/CompositeShaderBrush;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DropShadowRenderer extends ShadowRenderer {
    private CompositeShaderBrush compositeShader;
    private final Paint paint;
    private final Shadow shadow;
    private ImageBitmap shadowBitmap;

    public DropShadowRenderer(Shadow shadow, Outline outline) {
        super(outline);
        this.shadow = shadow;
        this.paint = AndroidPaint_androidKt.Paint();
    }

    /* renamed from: createOuterShadowBitmap-Cqks5Fs, reason: not valid java name */
    private final ImageBitmap m4843createOuterShadowBitmapCqks5Fs(long size, Path path, float radius, float spread) {
        float f = 2;
        float f7 = (f * spread) + (radius * f);
        ImageBitmap imageBitmapM4375ImageBitmapx__hDU$default = ImageBitmapKt.m4375ImageBitmapx__hDU$default((int) Math.ceil(Float.intBitsToFloat((int) (size >> 32)) + f7), (int) Math.ceil(Float.intBitsToFloat((int) (size & 4294967295L)) + f7), ImageBitmapConfig.INSTANCE.m4369getAlpha8_sVssgQ(), false, null, 24, null);
        Canvas Canvas = CanvasKt.Canvas(imageBitmapM4375ImageBitmapx__hDU$default);
        if (spread <= 0.0f) {
            BlurKt.m4842configureShadowFoewPVk$default(this.paint, 0L, 0, radius > 0.0f ? Blur_androidKt.BlurFilter(radius) : null, 0, 11, null);
            Canvas.translate(radius, radius);
            Canvas.drawPath(path, this.paint);
            return imageBitmapM4375ImageBitmapx__hDU$default;
        }
        float f9 = radius + spread;
        Canvas.translate(f9, f9);
        Canvas.drawPath(path, this.paint);
        Paint paintM4842configureShadowFoewPVk$default = BlurKt.m4842configureShadowFoewPVk$default(this.paint, 0L, 0, radius > 0.0f ? Blur_androidKt.BlurFilter(radius) : null, PaintingStyle.INSTANCE.m4418getStrokeTiuSbCo(), 3, null);
        paintM4842configureShadowFoewPVk$default.setStrokeWidth(2.0f * spread);
        Canvas.drawPath(path, paintM4842configureShadowFoewPVk$default);
        return imageBitmapM4375ImageBitmapx__hDU$default;
    }

    /* renamed from: createOuterShadowBitmap-D_oqF2M, reason: not valid java name */
    private final ImageBitmap m4844createOuterShadowBitmapD_oqF2M(long size, float shadowRadius, float spread, long cornerRadius) {
        float f = 2;
        float f7 = (f * spread) + (shadowRadius * f);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (size >> 32)) + f7;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (size & 4294967295L)) + f7;
        ImageBitmap imageBitmapM4375ImageBitmapx__hDU$default = ImageBitmapKt.m4375ImageBitmapx__hDU$default((int) Math.ceil(fIntBitsToFloat), (int) Math.ceil(fIntBitsToFloat2), ImageBitmapConfig.INSTANCE.m4369getAlpha8_sVssgQ(), false, null, 24, null);
        CanvasKt.Canvas(imageBitmapM4375ImageBitmapx__hDU$default).drawRoundRect(shadowRadius, shadowRadius, fIntBitsToFloat - shadowRadius, fIntBitsToFloat2 - shadowRadius, Float.intBitsToFloat((int) (cornerRadius >> 32)), Float.intBitsToFloat((int) (cornerRadius & 4294967295L)), BlurKt.m4842configureShadowFoewPVk$default(this.paint, 0L, 0, shadowRadius > 0.0f ? Blur_androidKt.BlurFilter(shadowRadius) : null, 0, 11, null));
        return imageBitmapM4375ImageBitmapx__hDU$default;
    }

    private final Brush obtainCompositeBrush(ImageBitmap shadowBitmap, Brush brush) {
        CompositeShaderBrush compositeShaderBrush = this.compositeShader;
        if (compositeShaderBrush != null && k.b(compositeShaderBrush.getSrcBrush(), brush)) {
            return compositeShaderBrush;
        }
        Brush.Companion companion = Brush.INSTANCE;
        ShaderBrush ShaderBrush = BrushKt.ShaderBrush(ShaderKt.m4467ImageShaderF49vj9s$default(shadowBitmap, 0, 0, 6, null));
        if (brush instanceof ShaderBrush) {
            float width = shadowBitmap.getWidth();
            float height = shadowBitmap.getHeight();
            brush = BrushKt.ShaderBrush(((ShaderBrush) brush).mo4108createShaderuvyYCjk(Size.m3955constructorimpl((Float.floatToRawIntBits(width) << 32) | (Float.floatToRawIntBits(height) & 4294967295L))));
        }
        Brush brushM4097composite7EN7VTw = companion.m4097composite7EN7VTw(ShaderBrush, brush, BlendMode.INSTANCE.m4078getSrcIn0nO6VwU());
        k.d(brushM4097composite7EN7VTw, "null cannot be cast to non-null type androidx.compose.ui.graphics.CompositeShaderBrush");
        CompositeShaderBrush compositeShaderBrush2 = (CompositeShaderBrush) brushM4097composite7EN7VTw;
        this.compositeShader = compositeShaderBrush2;
        return compositeShaderBrush2;
    }

    @Override // androidx.compose.ui.graphics.shadow.ShadowRenderer
    /* renamed from: buildShadow-_SMYjrA, reason: not valid java name */
    public void mo4845buildShadow_SMYjrA(DrawScope drawScope, long j5, long j6, Path path) {
        DropShadowRenderer dropShadowRenderer;
        ImageBitmap imageBitmapM4844createOuterShadowBitmapD_oqF2M;
        float fMo381toPx0680j_4 = drawScope.mo381toPx0680j_4(this.shadow.getRadius());
        float fMo381toPx0680j_42 = drawScope.mo381toPx0680j_4(this.shadow.getSpread());
        if (path != null) {
            dropShadowRenderer = this;
            imageBitmapM4844createOuterShadowBitmapD_oqF2M = dropShadowRenderer.m4843createOuterShadowBitmapCqks5Fs(j5, path, fMo381toPx0680j_4, fMo381toPx0680j_42);
        } else {
            dropShadowRenderer = this;
            imageBitmapM4844createOuterShadowBitmapD_oqF2M = m4844createOuterShadowBitmapD_oqF2M(j5, fMo381toPx0680j_4, fMo381toPx0680j_42, j6);
        }
        dropShadowRenderer.shadowBitmap = imageBitmapM4844createOuterShadowBitmapD_oqF2M;
    }

    public final Shadow getShadow() {
        return this.shadow;
    }

    @Override // androidx.compose.ui.graphics.shadow.ShadowRenderer
    /* renamed from: onDrawShadow-MLmccfk, reason: not valid java name */
    public void mo4846onDrawShadowMLmccfk(DrawScope drawScope, long j5, long j6, Path path, float f, ColorFilter colorFilter, Brush brush, int i) {
        ImageBitmap imageBitmap = this.shadowBitmap;
        if (imageBitmap != null) {
            float f7 = -(drawScope.mo381toPx0680j_4(this.shadow.getSpread()) + drawScope.mo381toPx0680j_4(this.shadow.getRadius()));
            if (brush == null || colorFilter != null) {
                DrawScope.m4691drawImagegbVJVH8$default(drawScope, imageBitmap, Offset.m3887constructorimpl((Float.floatToRawIntBits(f7) << 32) | (4294967295L & Float.floatToRawIntBits(f7))), f, null, colorFilter, i, 8, null);
                return;
            }
            Brush brushObtainCompositeBrush = obtainCompositeBrush(imageBitmap, brush);
            drawScope.getDrawContext().getTransform().translate(f7, f7);
            try {
                float width = imageBitmap.getWidth();
                float height = imageBitmap.getHeight();
                DrawScope.m4700drawRectAsUm42w$default(drawScope, brushObtainCompositeBrush, 0L, Size.m3955constructorimpl((Float.floatToRawIntBits(height) & 4294967295L) | (Float.floatToRawIntBits(width) << 32)), f, null, null, i, 50, null);
            } finally {
                float f9 = -f7;
                drawScope.getDrawContext().getTransform().translate(f9, f9);
            }
        }
    }
}
