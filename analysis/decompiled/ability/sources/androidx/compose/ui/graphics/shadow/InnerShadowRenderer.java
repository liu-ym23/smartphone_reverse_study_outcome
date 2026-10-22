package androidx.compose.ui.graphics.shadow;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
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
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.ShaderKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.DpOffset;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.SingleFileBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J?\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ?\u0010#\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J-\u0010(\u001a\u00020%*\u00020$2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014¢\u0006\u0004\b&\u0010'JQ\u00100\u001a\u00020%*\u00020$2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010)\u001a\u00020\u00172\b\u0010+\u001a\u0004\u0018\u00010*2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010-\u001a\u00020,H\u0014¢\u0006\u0004\b.\u0010/R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u00105R\u0018\u00106\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00108\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109¨\u0006:"}, d2 = {"Landroidx/compose/ui/graphics/shadow/InnerShadowRenderer;", "Landroidx/compose/ui/graphics/shadow/ShadowRenderer;", "Landroidx/compose/ui/graphics/shadow/Shadow;", "shadow", "Landroidx/compose/ui/graphics/Outline;", "outline", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/graphics/shadow/Shadow;Landroidx/compose/ui/graphics/Outline;)V", "Landroidx/compose/ui/graphics/Matrix;", "obtainMatrix-sQKQjiQ", "()[F", "obtainMatrix", "Landroidx/compose/ui/graphics/ShaderBrush;", "shadowMask", "Landroidx/compose/ui/graphics/Brush;", "brush", "Landroidx/compose/ui/graphics/CompositeShaderBrush;", "obtainCompositeBrush", "(Landroidx/compose/ui/graphics/ShaderBrush;Landroidx/compose/ui/graphics/Brush;)Landroidx/compose/ui/graphics/CompositeShaderBrush;", "Landroidx/compose/ui/geometry/Size;", "size", "Landroidx/compose/ui/graphics/Path;", SingleFileBundle.KEY_PATH, "", "radius", "spread", "offsetX", "offsetY", "createInnerPathShadowBrush-LjSzlW0", "(JLandroidx/compose/ui/graphics/Path;FFFF)Landroidx/compose/ui/graphics/ShaderBrush;", "createInnerPathShadowBrush", "Landroidx/compose/ui/geometry/CornerRadius;", "cornerRadius", "createInnerShadowBrush-u1Psq-8", "(JFFFFJ)Landroidx/compose/ui/graphics/ShaderBrush;", "createInnerShadowBrush", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "LC7/r;", "buildShadow-_SMYjrA", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJLandroidx/compose/ui/graphics/Path;)V", "buildShadow", "alpha", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "onDrawShadow-MLmccfk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJLandroidx/compose/ui/graphics/Path;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/ui/graphics/Brush;I)V", "onDrawShadow", "Landroidx/compose/ui/graphics/shadow/Shadow;", "Landroidx/compose/ui/graphics/Paint;", "paint", "Landroidx/compose/ui/graphics/Paint;", "Landroidx/compose/ui/graphics/ShaderBrush;", "compositeShader", "Landroidx/compose/ui/graphics/CompositeShaderBrush;", "matrix", "[F", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class InnerShadowRenderer extends ShadowRenderer {
    private CompositeShaderBrush compositeShader;
    private float[] matrix;
    private final Paint paint;
    private final Shadow shadow;
    private ShaderBrush shadowMask;

    public InnerShadowRenderer(Shadow shadow, Outline outline) {
        super(outline);
        this.shadow = shadow;
        this.paint = AndroidPaint_androidKt.Paint();
    }

    /* renamed from: createInnerPathShadowBrush-LjSzlW0, reason: not valid java name */
    private final ShaderBrush m4847createInnerPathShadowBrushLjSzlW0(long size, Path path, float radius, float spread, float offsetX, float offsetY) {
        ImageBitmap imageBitmapM4375ImageBitmapx__hDU$default;
        int iCeil = (int) Math.ceil(Float.intBitsToFloat((int) (size >> 32)));
        int iCeil2 = (int) Math.ceil(Float.intBitsToFloat((int) (size & 4294967295L)));
        if (spread > 0.0f) {
            Rect bounds = path.getBounds();
            float right = bounds.getRight() - bounds.getLeft();
            float bottom = bounds.getBottom() - bounds.getTop();
            imageBitmapM4375ImageBitmapx__hDU$default = ImageBitmapKt.m4375ImageBitmapx__hDU$default((int) Math.ceil(right), (int) Math.ceil(bottom), ImageBitmapConfig.INSTANCE.m4369getAlpha8_sVssgQ(), false, null, 24, null);
            Canvas Canvas = CanvasKt.Canvas(imageBitmapM4375ImageBitmapx__hDU$default);
            Canvas.drawPath(path, this.paint);
            Canvas.m4111clipRectN_I0leg$default(Canvas, 0.0f, 0.0f, right, bottom, 0, 16, null);
            Paint paintM4842configureShadowFoewPVk$default = BlurKt.m4842configureShadowFoewPVk$default(this.paint, 0L, BlendMode.INSTANCE.m4053getClear0nO6VwU(), null, PaintingStyle.INSTANCE.m4418getStrokeTiuSbCo(), 5, null);
            paintM4842configureShadowFoewPVk$default.setStrokeWidth(2.0f * spread);
            Canvas.drawPath(path, paintM4842configureShadowFoewPVk$default);
        } else {
            imageBitmapM4375ImageBitmapx__hDU$default = null;
        }
        int iCeil3 = ((int) Math.ceil(radius)) * 2;
        ImageBitmap imageBitmapM4375ImageBitmapx__hDU$default2 = ImageBitmapKt.m4375ImageBitmapx__hDU$default(iCeil + iCeil3, iCeil2 + iCeil3, ImageBitmapConfig.INSTANCE.m4369getAlpha8_sVssgQ(), false, null, 24, null);
        Canvas Canvas2 = CanvasKt.Canvas(imageBitmapM4375ImageBitmapx__hDU$default2);
        if (imageBitmapM4375ImageBitmapx__hDU$default != null) {
            Canvas2.drawRect(0.0f, 0.0f, imageBitmapM4375ImageBitmapx__hDU$default2.getWidth(), imageBitmapM4375ImageBitmapx__hDU$default2.getHeight(), BlurKt.m4842configureShadowFoewPVk$default(this.paint, 0L, 0, null, 0, 15, null));
            Canvas2.mo3993drawImaged4ec7I(imageBitmapM4375ImageBitmapx__hDU$default, Offset.m3887constructorimpl((4294967295L & Float.floatToRawIntBits(offsetY)) | (Float.floatToRawIntBits(offsetX) << 32)), BlurKt.m4842configureShadowFoewPVk$default(this.paint, 0L, BlendMode.INSTANCE.m4081getXor0nO6VwU(), radius > 0.0f ? Blur_androidKt.BlurFilter(radius) : null, 0, 9, null));
            return BrushKt.ShaderBrush(ShaderKt.m4467ImageShaderF49vj9s$default(imageBitmapM4375ImageBitmapx__hDU$default2, 0, 0, 6, null));
        }
        Canvas2.save();
        Canvas2.translate(offsetX, offsetY);
        Canvas2.drawPath(path, BlurKt.m4842configureShadowFoewPVk$default(this.paint, 0L, 0, radius > 0.0f ? Blur_androidKt.BlurFilter(radius) : null, 0, 11, null));
        Canvas2.restore();
        Canvas2.drawRect(0.0f, 0.0f, imageBitmapM4375ImageBitmapx__hDU$default2.getWidth(), imageBitmapM4375ImageBitmapx__hDU$default2.getHeight(), BlurKt.m4842configureShadowFoewPVk$default(this.paint, 0L, BlendMode.INSTANCE.m4081getXor0nO6VwU(), null, 0, 13, null));
        return BrushKt.ShaderBrush(ShaderKt.m4467ImageShaderF49vj9s$default(imageBitmapM4375ImageBitmapx__hDU$default2, 0, 0, 6, null));
    }

    /* renamed from: createInnerShadowBrush-u1Psq-8, reason: not valid java name */
    private final ShaderBrush m4848createInnerShadowBrushu1Psq8(long size, float radius, float spread, float offsetX, float offsetY, long cornerRadius) {
        int i = (int) (size >> 32);
        int i6 = (int) (size & 4294967295L);
        ImageBitmap imageBitmapM4375ImageBitmapx__hDU$default = ImageBitmapKt.m4375ImageBitmapx__hDU$default((int) Math.ceil(Float.intBitsToFloat(i)), (int) Math.ceil(Float.intBitsToFloat(i6)), ImageBitmapConfig.INSTANCE.m4369getAlpha8_sVssgQ(), false, null, 24, null);
        Canvas Canvas = CanvasKt.Canvas(imageBitmapM4375ImageBitmapx__hDU$default);
        float f = offsetX + spread;
        float f7 = offsetY + spread;
        Canvas.drawRoundRect(f, f7, Math.max(f, (Float.intBitsToFloat(i) + offsetX) - spread), Math.max(f7, (Float.intBitsToFloat(i6) + offsetY) - spread), Float.intBitsToFloat((int) (cornerRadius >> 32)), Float.intBitsToFloat((int) (cornerRadius & 4294967295L)), BlurKt.m4842configureShadowFoewPVk$default(this.paint, 0L, 0, radius > 0.0f ? Blur_androidKt.BlurFilter(radius) : null, 0, 11, null));
        Canvas.drawRect(0.0f, 0.0f, imageBitmapM4375ImageBitmapx__hDU$default.getWidth(), imageBitmapM4375ImageBitmapx__hDU$default.getHeight(), BlurKt.m4842configureShadowFoewPVk$default(this.paint, 0L, BlendMode.INSTANCE.m4081getXor0nO6VwU(), null, 0, 13, null));
        return BrushKt.ShaderBrush(ShaderKt.m4467ImageShaderF49vj9s$default(imageBitmapM4375ImageBitmapx__hDU$default, 0, 0, 6, null));
    }

    private final CompositeShaderBrush obtainCompositeBrush(ShaderBrush shadowMask, Brush brush) {
        CompositeShaderBrush compositeShaderBrush = this.compositeShader;
        if (compositeShaderBrush != null && k.b(compositeShaderBrush.getSrcBrush(), brush)) {
            return compositeShaderBrush;
        }
        CompositeShaderBrush compositeShaderBrush2 = new CompositeShaderBrush(BrushKt.toShaderBrush(shadowMask), BrushKt.toShaderBrush(brush), BlendMode.INSTANCE.m4078getSrcIn0nO6VwU(), null);
        this.compositeShader = compositeShaderBrush2;
        return compositeShaderBrush2;
    }

    /* renamed from: obtainMatrix-sQKQjiQ, reason: not valid java name */
    private final float[] m4849obtainMatrixsQKQjiQ() {
        float[] fArr = this.matrix;
        if (fArr != null) {
            return fArr;
        }
        float[] fArrM4380constructorimpl$default = Matrix.m4380constructorimpl$default(null, 1, null);
        this.matrix = fArrM4380constructorimpl$default;
        return fArrM4380constructorimpl$default;
    }

    @Override // androidx.compose.ui.graphics.shadow.ShadowRenderer
    /* renamed from: buildShadow-_SMYjrA */
    public void mo4845buildShadow_SMYjrA(DrawScope drawScope, long j5, long j6, Path path) {
        float fMo381toPx0680j_4 = drawScope.mo381toPx0680j_4(this.shadow.getRadius());
        float fMo381toPx0680j_42 = drawScope.mo381toPx0680j_4(this.shadow.getSpread());
        float fMo381toPx0680j_43 = drawScope.mo381toPx0680j_4(DpOffset.m6905getXD9Ej5fM(this.shadow.getOffset()));
        float fMo381toPx0680j_44 = drawScope.mo381toPx0680j_4(DpOffset.m6907getYD9Ej5fM(this.shadow.getOffset()));
        this.shadowMask = path != null ? m4847createInnerPathShadowBrushLjSzlW0(j5, path, fMo381toPx0680j_4, fMo381toPx0680j_42, fMo381toPx0680j_43, fMo381toPx0680j_44) : m4848createInnerShadowBrushu1Psq8(j5, fMo381toPx0680j_4, fMo381toPx0680j_42, fMo381toPx0680j_43, fMo381toPx0680j_44, j6);
    }

    @Override // androidx.compose.ui.graphics.shadow.ShadowRenderer
    /* renamed from: onDrawShadow-MLmccfk */
    public void mo4846onDrawShadowMLmccfk(DrawScope drawScope, long j5, long j6, Path path, float f, ColorFilter colorFilter, Brush brush, int i) {
        ShaderBrush shaderBrushObtainCompositeBrush = this.shadowMask;
        if (shaderBrushObtainCompositeBrush != null) {
            if (this.shadow.getBrush() instanceof ShaderBrush) {
                shaderBrushObtainCompositeBrush = obtainCompositeBrush(shaderBrushObtainCompositeBrush, this.shadow.getBrush());
            }
            ShaderBrush shaderBrush = shaderBrushObtainCompositeBrush;
            if (path != null) {
                DrawScope.m4696drawPathGBMwjPU$default(drawScope, path, shaderBrush, f, null, colorFilter, i, 8, null);
            } else if (CornerRadius.m3854equalsimpl0(j6, CornerRadius.INSTANCE.m3867getZerokKHJgLs())) {
                DrawScope.m4700drawRectAsUm42w$default(drawScope, shaderBrush, 0L, 0L, f, null, colorFilter, i, 22, null);
            } else {
                DrawScope.m4702drawRoundRectZuiqVtQ$default(drawScope, shaderBrush, 0L, 0L, j6, f, null, colorFilter, this.shadow.getBlendMode(), 38, null);
            }
        }
    }
}
