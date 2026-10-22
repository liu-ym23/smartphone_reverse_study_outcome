package androidx.compose.ui.graphics.shadow;

import android.graphics.BlurMaskFilter;
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
import com.alibaba.gaiax.render.view.GXViewKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002JQ\u0010\u001e\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010#\u001a\u00020$H\u0014¢\u0006\u0004\b%\u0010&J/\u0010'\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020 H\u0002¢\u0006\u0004\b*\u0010+J/\u0010'\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010,\u001a\u00020 2\u0006\u0010)\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002¢\u0006\u0004\b-\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Landroidx/compose/ui/graphics/shadow/DropShadowRenderer;", "Landroidx/compose/ui/graphics/shadow/ShadowRenderer;", GXViewKey.VIEW_TYPE_SHADOW_LAYOUT, "Landroidx/compose/ui/graphics/shadow/Shadow;", "outline", "Landroidx/compose/ui/graphics/Outline;", "<init>", "(Landroidx/compose/ui/graphics/shadow/Shadow;Landroidx/compose/ui/graphics/Outline;)V", "getShadow", "()Landroidx/compose/ui/graphics/shadow/Shadow;", "paint", "Landroidx/compose/ui/graphics/Paint;", "shadowBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "compositeShader", "Landroidx/compose/ui/graphics/CompositeShaderBrush;", "buildShadow", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "size", "Landroidx/compose/ui/geometry/Size;", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "path", "Landroidx/compose/ui/graphics/Path;", "buildShadow-_SMYjrA", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJLandroidx/compose/ui/graphics/Path;)V", "obtainCompositeBrush", "Landroidx/compose/ui/graphics/Brush;", "brush", "onDrawShadow", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "onDrawShadow-MLmccfk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJLandroidx/compose/ui/graphics/Path;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/ui/graphics/Brush;I)V", "createOuterShadowBitmap", "radius", "spread", "createOuterShadowBitmap-Cqks5Fs", "(JLandroidx/compose/ui/graphics/Path;FF)Landroidx/compose/ui/graphics/ImageBitmap;", "shadowRadius", "createOuterShadowBitmap-D_oqF2M", "(JFFJ)Landroidx/compose/ui/graphics/ImageBitmap;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DropShadowRenderer extends ShadowRenderer {
    private CompositeShaderBrush compositeShader;
    private final Paint paint;
    private final Shadow shadow;
    private ImageBitmap shadowBitmap;

    public final Shadow getShadow() {
        return this.shadow;
    }

    public DropShadowRenderer(Shadow r100, Outline r101) {
        super(r101);
        this.shadow = r100;
        this.paint = AndroidPaint_androidKt.Paint();
    }

    private final Brush obtainCompositeBrush(ImageBitmap r100, Brush r110) {
        CompositeShaderBrush r101 = this.compositeShader;
        if (r101 != null) goto L5;
    L6:
        Brush.Companion r102 = Brush.Companion;
        ShaderBrush r103 = BrushKt.ShaderBrush(ShaderKt.m5165ImageShaderF49vj9s$default(r100, 0, 0, 6, null));
        if ((r110 instanceof ShaderBrush) == false) goto L9;
        float r104 = r100.getWidth();
        float r105 = r100.getHeight();
        r110 = BrushKt.ShaderBrush(((ShaderBrush) r110).mo4796createShaderuvyYCjk(Size.m4642constructorimpl((Float.floatToRawIntBits(r104) << 32) | (((long) Float.floatToRawIntBits(r105)) & BodyPartID.bodyIdMax))));
    L9:
        Brush r106 = r102.m4785composite7EN7VTw(r103, r110, BlendMode.Companion.m4766getSrcIn0nO6VwU());
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type androidx.compose.ui.graphics.CompositeShaderBrush");
        CompositeShaderBrush r107 = (CompositeShaderBrush) r106;
        this.compositeShader = r107;
        return r107;
    L5:
        if (Intrinsics.areEqual(r101.getSrcBrush(), r110) == false) goto L6;
        return r101;
    }

    /* JADX INFO: renamed from: createOuterShadowBitmap-Cqks5Fs, reason: not valid java name */
    private final ImageBitmap m5546createOuterShadowBitmapCqks5Fs(long r110, Path r111, float r210, float r211) {
        float r100 = 2;
        float r101 = (r210 * r100) + (r100 * r211);
        ImageBitmap r102 = ImageBitmapKt.m5072ImageBitmapx__hDU$default((int) Math.ceil(Float.intBitsToFloat((int) (r110 >> 32)) + r101), (int) Math.ceil(Float.intBitsToFloat((int) (r110 & BodyPartID.bodyIdMax)) + r101), ImageBitmapConfig.Companion.m5066getAlpha8_sVssgQ(), false, null, 24, null);
        Canvas r103 = CanvasKt.Canvas(r102);
        BlurMaskFilter r104 = null;
        if (r211 <= 0.0f) goto L8;
        float r105 = r210 + r211;
        r103.translate(r105, r105);
        r103.drawPath(r111, this.paint);
        Paint r106 = this.paint;
        int r112 = PaintingStyle.Companion.m5115getStrokeTiuSbCo();
        if (r210 <= 0.0f) goto L7;
        r104 = Blur_androidKt.BlurFilter(r210);
    L7:
        Paint r107 = BlurKt.m5545configureShadowFoewPVk$default(r106, 0, 0, r104, r112, 3, null);
        r107.setStrokeWidth(2.0f * r211);
        Unit r108 = Unit.INSTANCE;
        r103.drawPath(r111, r107);
    L12:
        return r102;
    L8:
        Paint r109 = this.paint;
        if (r210 <= 0.0f) goto L11;
        r104 = Blur_androidKt.BlurFilter(r210);
    L11:
        BlurKt.m5545configureShadowFoewPVk$default(r109, 0, 0, r104, 0, 11, null);
        r103.translate(r210, r210);
        r103.drawPath(r111, this.paint);
        goto L12
    }

    /* JADX INFO: renamed from: createOuterShadowBitmap-D_oqF2M, reason: not valid java name */
    private final ImageBitmap m5547createOuterShadowBitmapD_oqF2M(long r210, float r211, float r212, long r213) {
        float r100 = 2;
        float r101 = (r211 * r100) + (r100 * r212);
        float r102 = Float.intBitsToFloat((int) (r210 >> 32)) + r101;
        float r103 = Float.intBitsToFloat((int) (r210 & BodyPartID.bodyIdMax)) + r101;
        ImageBitmap r104 = ImageBitmapKt.m5072ImageBitmapx__hDU$default((int) Math.ceil(r102), (int) Math.ceil(r103), ImageBitmapConfig.Companion.m5066getAlpha8_sVssgQ(), false, null, 24, null);
        Canvas r105 = CanvasKt.Canvas(r104);
        float r106 = r102 - r211;
        float r107 = r103 - r211;
        float r108 = Float.intBitsToFloat((int) (r213 >> 32));
        float r109 = Float.intBitsToFloat((int) (r213 & BodyPartID.bodyIdMax));
        Paint r110 = this.paint;
        if (r211 <= 0.0f) goto L5;
        BlurMaskFilter r111 = Blur_androidKt.BlurFilter(r211);
    L6:
        r105.drawRoundRect(r211, r211, r106, r107, r108, r109, BlurKt.m5545configureShadowFoewPVk$default(r110, 0, 0, r111, 0, 11, null));
        return r104;
    L5:
        r111 = null;
        goto L6
    }

    @Override // androidx.compose.ui.graphics.shadow.ShadowRenderer
    /* JADX INFO: renamed from: buildShadow-_SMYjrA, reason: not valid java name */
    public void mo5548buildShadow_SMYjrA(DrawScope r100, long r110, long r111, Path r112) {
        float r101 = r100.mo371toPx0680j_4(this.shadow.m5556getRadiusD9Ej5fM());
        float r102 = r100.mo371toPx0680j_4(this.shadow.m5557getSpreadD9Ej5fM());
        if (r112 == null) goto L5;
        ImageBitmap r103 = m5546createOuterShadowBitmapCqks5Fs(r110, r112, r101, r102);
    L6:
        this.shadowBitmap = r103;
        return;
    L5:
        r103 = m5547createOuterShadowBitmapD_oqF2M(r110, r101, r102, r111);
        goto L6
    }

    @Override // androidx.compose.ui.graphics.shadow.ShadowRenderer
    /* JADX INFO: renamed from: onDrawShadow-MLmccfk, reason: not valid java name */
    public void mo5549onDrawShadowMLmccfk(DrawScope r110, long r111, long r210, Path r211, float r212, ColorFilter r213, Brush r214, int r215) {
        ImageBitmap r100 = this.shadowBitmap;
        if (r100 == null) goto L17;
        float r112 = -(r110.mo371toPx0680j_4(this.shadow.m5556getRadiusD9Ej5fM()) + r110.mo371toPx0680j_4(this.shadow.m5557getSpreadD9Ej5fM()));
        if (r214 == null) goto L13;
        if (r213 != null) goto L13;
        Brush r101 = obtainCompositeBrush(r100, r214);
        r110.getDrawContext().getTransform().translate(r112, r112);
        float r102 = r100.getWidth();     // Catch: Throwable -> L10
        float r103 = r100.getHeight();     // Catch: Throwable -> L10
        DrawScope.CC.m5406drawRectAsUm42w$default(r110, r101, 0, Size.m4642constructorimpl((Float.floatToRawIntBits(r102) << 32) | (BodyPartID.bodyIdMax & ((long) Float.floatToRawIntBits(r103)))), r212, null, null, r215, 50, null);     // Catch: Throwable -> L10
        float r104 = -r112;
        r110.getDrawContext().getTransform().translate(r104, r104);
        return;
    L10:
        th = move-exception;
        float r105 = -r112;
        r110.getDrawContext().getTransform().translate(r105, r105);
        throw th;
    L13:
        long r106 = Float.floatToRawIntBits(r112);
        DrawScope.CC.m5397drawImagegbVJVH8$default(r110, r100, Offset.m4574constructorimpl((BodyPartID.bodyIdMax & ((long) Float.floatToRawIntBits(r112))) | (r106 << 32)), r212, null, r213, r215, 8, null);
        return;
    }
}
