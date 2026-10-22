package androidx.compose.ui.graphics.shadow;

import android.graphics.BlurMaskFilter;
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
import com.alibaba.gaiax.render.view.GXViewKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u0011\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!H\u0002JQ\u0010\"\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010'\u001a\u00020(H\u0014¢\u0006\u0004\b)\u0010*J?\u0010+\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020$H\u0002¢\u0006\u0004\b0\u00101J?\u00102\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0004\b3\u00104R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010¨\u00065"}, d2 = {"Landroidx/compose/ui/graphics/shadow/InnerShadowRenderer;", "Landroidx/compose/ui/graphics/shadow/ShadowRenderer;", GXViewKey.VIEW_TYPE_SHADOW_LAYOUT, "Landroidx/compose/ui/graphics/shadow/Shadow;", "outline", "Landroidx/compose/ui/graphics/Outline;", "<init>", "(Landroidx/compose/ui/graphics/shadow/Shadow;Landroidx/compose/ui/graphics/Outline;)V", "paint", "Landroidx/compose/ui/graphics/Paint;", "shadowMask", "Landroidx/compose/ui/graphics/ShaderBrush;", "compositeShader", "Landroidx/compose/ui/graphics/CompositeShaderBrush;", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "obtainMatrix", "obtainMatrix-sQKQjiQ", "()[F", "buildShadow", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "size", "Landroidx/compose/ui/geometry/Size;", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "path", "Landroidx/compose/ui/graphics/Path;", "buildShadow-_SMYjrA", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJLandroidx/compose/ui/graphics/Path;)V", "obtainCompositeBrush", "brush", "Landroidx/compose/ui/graphics/Brush;", "onDrawShadow", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "onDrawShadow-MLmccfk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJLandroidx/compose/ui/graphics/Path;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/ui/graphics/Brush;I)V", "createInnerPathShadowBrush", "radius", "spread", "offsetX", "offsetY", "createInnerPathShadowBrush-LjSzlW0", "(JLandroidx/compose/ui/graphics/Path;FFFF)Landroidx/compose/ui/graphics/ShaderBrush;", "createInnerShadowBrush", "createInnerShadowBrush-u1Psq-8", "(JFFFFJ)Landroidx/compose/ui/graphics/ShaderBrush;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InnerShadowRenderer extends ShadowRenderer {
    private CompositeShaderBrush compositeShader;
    private float[] matrix;
    private final Paint paint;
    private final Shadow shadow;
    private ShaderBrush shadowMask;

    /* JADX INFO: renamed from: obtainMatrix-sQKQjiQ, reason: not valid java name */
    private final float[] m5552obtainMatrixsQKQjiQ() {
        float[] r100 = this.matrix;
        if (r100 != null) goto L6;
        float[] r101 = Matrix.m5077constructorimpl$default(null, 1, null);
        this.matrix = r101;
        return r101;
    L6:
        return r100;
    }

    public InnerShadowRenderer(Shadow r100, Outline r101) {
        super(r101);
        this.shadow = r100;
        this.paint = AndroidPaint_androidKt.Paint();
    }

    private final CompositeShaderBrush obtainCompositeBrush(ShaderBrush r100, Brush r101) {
        CompositeShaderBrush r102 = this.compositeShader;
        if (r102 != null) goto L5;
    L6:
        CompositeShaderBrush r103 = new CompositeShaderBrush(BrushKt.toShaderBrush(r100), BrushKt.toShaderBrush(r101), BlendMode.Companion.m4766getSrcIn0nO6VwU(), null);
        this.compositeShader = r103;
        return r103;
    L5:
        if (Intrinsics.areEqual(r102.getSrcBrush(), r101) == false) goto L6;
        return r102;
    }

    @Override // androidx.compose.ui.graphics.shadow.ShadowRenderer
    /* JADX INFO: renamed from: buildShadow-_SMYjrA */
    public void mo5548buildShadow_SMYjrA(DrawScope r110, long r111, long r112, Path r113) {
        float r100 = r110.mo371toPx0680j_4(this.shadow.m5556getRadiusD9Ej5fM());
        float r101 = r110.mo371toPx0680j_4(this.shadow.m5557getSpreadD9Ej5fM());
        float r102 = r110.mo371toPx0680j_4(DpOffset.m7605getXD9Ej5fM(this.shadow.m5555getOffsetRKDOV3M()));
        float r103 = r110.mo371toPx0680j_4(DpOffset.m7607getYD9Ej5fM(this.shadow.m5555getOffsetRKDOV3M()));
        if (r113 == null) goto L5;
        ShaderBrush r104 = m5550createInnerPathShadowBrushLjSzlW0(r111, r113, r100, r101, r102, r103);
    L6:
        this.shadowMask = r104;
        return;
    L5:
        r104 = m5551createInnerShadowBrushu1Psq8(r111, r100, r101, r102, r103, r112);
        goto L6
    }

    /* JADX INFO: renamed from: createInnerPathShadowBrush-LjSzlW0, reason: not valid java name */
    private final ShaderBrush m5550createInnerPathShadowBrushLjSzlW0(long r310, Path r311, float r312, float r313, float r314, float r315) {
        int r100 = (int) Math.ceil(Float.intBitsToFloat((int) (r310 >> 32)));
        int r101 = (int) Math.ceil(Float.intBitsToFloat((int) (r310 & BodyPartID.bodyIdMax)));
        if (r313 <= 0.0f) goto L5;
        Rect r110 = r311.getBounds();
        float r111 = r110.getRight() - r110.getLeft();
        float r112 = r110.getBottom() - r110.getTop();
        ImageBitmap r113 = ImageBitmapKt.m5072ImageBitmapx__hDU$default((int) Math.ceil(r111), (int) Math.ceil(r112), ImageBitmapConfig.Companion.m5066getAlpha8_sVssgQ(), false, null, 24, null);
        Canvas r114 = CanvasKt.Canvas(r113);
        r114.drawPath(r311, this.paint);
        Canvas.CC.m4800clipRectN_I0leg$default(r114, 0.0f, 0.0f, r111, r112, 0, 16, null);
        Paint r115 = BlurKt.m5545configureShadowFoewPVk$default(this.paint, 0, BlendMode.Companion.m4741getClear0nO6VwU(), null, PaintingStyle.Companion.m5115getStrokeTiuSbCo(), 5, null);
        r115.setStrokeWidth(2.0f * r313);
        Unit r116 = Unit.INSTANCE;
        r114.drawPath(r311, r115);
    L6:
        int r102 = ((int) Math.ceil(r312)) * 2;
        ImageBitmap r103 = ImageBitmapKt.m5072ImageBitmapx__hDU$default(r100 + r102, r101 + r102, ImageBitmapConfig.Companion.m5066getAlpha8_sVssgQ(), false, null, 24, null);
        Canvas r104 = CanvasKt.Canvas(r103);
        if (r113 == null) goto L14;
        r104.drawRect(0.0f, 0.0f, r103.getWidth(), r103.getHeight(), BlurKt.m5545configureShadowFoewPVk$default(this.paint, 0, 0, null, 0, 15, null));
        long r117 = Float.floatToRawIntBits(r314);
        long r105 = Offset.m4574constructorimpl((BodyPartID.bodyIdMax & ((long) Float.floatToRawIntBits(r315))) | (r117 << 32));
        Paint r106 = this.paint;
        if (r312 <= 0.0f) goto L11;
        BlurMaskFilter r210 = Blur_androidKt.BlurFilter(r312);
    L12:
        r104.mo4681drawImaged4ec7I(r113, r105, BlurKt.m5545configureShadowFoewPVk$default(r106, 0, BlendMode.Companion.m4769getXor0nO6VwU(), r210, 0, 9, null));
        return BrushKt.ShaderBrush(ShaderKt.m5165ImageShaderF49vj9s$default(r103, 0, 0, 6, null));
    L11:
        r210 = null;
        goto L12
    L14:
        r104.save();
        r104.translate(r314, r315);
        Paint r107 = this.paint;
        if (r312 <= 0.0f) goto L17;
        BlurMaskFilter r211 = Blur_androidKt.BlurFilter(r312);
    L18:
        r104.drawPath(r311, BlurKt.m5545configureShadowFoewPVk$default(r107, 0, 0, r211, 0, 11, null));
        r104.restore();
        r104.drawRect(0.0f, 0.0f, r103.getWidth(), r103.getHeight(), BlurKt.m5545configureShadowFoewPVk$default(this.paint, 0, BlendMode.Companion.m4769getXor0nO6VwU(), null, 0, 13, null));
        return BrushKt.ShaderBrush(ShaderKt.m5165ImageShaderF49vj9s$default(r103, 0, 0, 6, null));
    L17:
        r211 = null;
        goto L18
    L5:
        r113 = null;
        goto L6
    }

    /* JADX INFO: renamed from: createInnerShadowBrush-u1Psq-8, reason: not valid java name */
    private final ShaderBrush m5551createInnerShadowBrushu1Psq8(long r110, float r210, float r211, float r212, float r213, long r214) {
        int r100 = (int) (r110 >> 32);
        int r101 = (int) Math.ceil(Float.intBitsToFloat(r100));
        int r102 = (int) (r110 & BodyPartID.bodyIdMax);
        ImageBitmap r103 = ImageBitmapKt.m5072ImageBitmapx__hDU$default(r101, (int) Math.ceil(Float.intBitsToFloat(r102)), ImageBitmapConfig.Companion.m5066getAlpha8_sVssgQ(), false, null, 24, null);
        Canvas r104 = CanvasKt.Canvas(r103);
        float r105 = r212 + r211;
        float r106 = r213 + r211;
        float r107 = Math.max(r105, (r212 + Float.intBitsToFloat(r100)) - r211);
        float r108 = Math.max(r106, (r213 + Float.intBitsToFloat(r102)) - r211);
        float r109 = Float.intBitsToFloat((int) (r214 >> 32));
        float r111 = Float.intBitsToFloat((int) (r214 & BodyPartID.bodyIdMax));
        Paint r112 = this.paint;
        if (r210 <= 0.0f) goto L5;
        BlurMaskFilter r113 = Blur_androidKt.BlurFilter(r210);
    L6:
        r104.drawRoundRect(r105, r106, r107, r108, r109, r111, BlurKt.m5545configureShadowFoewPVk$default(r112, 0, 0, r113, 0, 11, null));
        r104.drawRect(0.0f, 0.0f, r103.getWidth(), r103.getHeight(), BlurKt.m5545configureShadowFoewPVk$default(this.paint, 0, BlendMode.Companion.m4769getXor0nO6VwU(), null, 0, 13, null));
        return BrushKt.ShaderBrush(ShaderKt.m5165ImageShaderF49vj9s$default(r103, 0, 0, 6, null));
    L5:
        r113 = null;
        goto L6
    }

    @Override // androidx.compose.ui.graphics.shadow.ShadowRenderer
    /* JADX INFO: renamed from: onDrawShadow-MLmccfk */
    public void mo5549onDrawShadowMLmccfk(DrawScope r110, long r111, long r210, Path r211, float r212, ColorFilter r213, Brush r214, int r215) {
        ShaderBrush r100 = this.shadowMask;
        if (r100 != null) goto L5;
        return;
    L5:
        if ((this.shadow.getBrush() instanceof ShaderBrush) == false) goto L7;
        r100 = obtainCompositeBrush(r100, this.shadow.getBrush());
    L7:
        if (r211 == null) goto L10;
        DrawScope.CC.m5402drawPathGBMwjPU$default(r110, r211, r100, r212, null, r213, r215, 8, null);
        return;
    L10:
        if (CornerRadius.m4541equalsimpl0(r210, CornerRadius.Companion.m4554getZerokKHJgLs()) == false) goto L12;
        DrawScope.CC.m5406drawRectAsUm42w$default(r110, r100, 0, 0, r212, null, r213, r215, 22, null);
        return;
    L12:
        ShaderBrush r101 = r100;
        DrawScope.CC.m5408drawRoundRectZuiqVtQ$default(r110, r101, 0, 0, r210, r212, null, r213, this.shadow.m5553getBlendMode0nO6VwU(), 38, null);
    }
}
