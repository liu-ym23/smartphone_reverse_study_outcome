package androidx.compose.ui.text.platform;

import android.graphics.Shader;
import android.text.TextPaint;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import com.alibaba.gaiax.render.view.GXViewKey;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u00104\u001a\u0002052\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u00106\u001a\u0002052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0015\u00107\u001a\u0002052\u0006\u00108\u001a\u00020\u001b¢\u0006\u0004\b9\u0010:J)\u0010;\u001a\u0002052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010<\u001a\u00020,2\b\b\u0002\u0010=\u001a\u00020\u0005¢\u0006\u0004\b>\u0010?J\u0010\u0010@\u001a\u0002052\b\u00102\u001a\u0004\u0018\u000103J\b\u0010G\u001a\u000205H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R$\u0010\u0012\u001a\u00020\u00138\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R*\u0010#\u001a\u0012\u0012\f\u0012\n\u0018\u00010%j\u0004\u0018\u0001`&\u0018\u00010$X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R&\u0010+\u001a\u0004\u0018\u00010,8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010\u0015\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010B\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006H"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidTextPaint;", "Landroid/text/TextPaint;", "flags", "", "density", "", "<init>", "(IF)V", "backingComposePaint", "Landroidx/compose/ui/graphics/Paint;", "composePaint", "getComposePaint", "()Landroidx/compose/ui/graphics/Paint;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "backingBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "I", GXViewKey.VIEW_TYPE_SHADOW_LAYOUT, "Landroidx/compose/ui/graphics/Shadow;", "getShadow$ui_text$annotations", "()V", "getShadow$ui_text", "()Landroidx/compose/ui/graphics/Shadow;", "setShadow$ui_text", "(Landroidx/compose/ui/graphics/Shadow;)V", "lastColor", "Landroidx/compose/ui/graphics/Color;", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush$ui_text$annotations", "getBrush$ui_text", "()Landroidx/compose/ui/graphics/Brush;", "setBrush$ui_text", "(Landroidx/compose/ui/graphics/Brush;)V", "shaderState", "Landroidx/compose/runtime/State;", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "getShaderState$ui_text", "()Landroidx/compose/runtime/State;", "setShaderState$ui_text", "(Landroidx/compose/runtime/State;)V", "brushSize", "Landroidx/compose/ui/geometry/Size;", "getBrushSize-VsRJwc0$ui_text$annotations", "getBrushSize-VsRJwc0$ui_text", "()Landroidx/compose/ui/geometry/Size;", "setBrushSize-iaC8Vc4$ui_text", "(Landroidx/compose/ui/geometry/Size;)V", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "setTextDecoration", "", "setShadow", "setColor", "color", "setColor-8_81llA", "(J)V", "setBrush", "size", "alpha", "setBrush-12SF9DM", "(Landroidx/compose/ui/graphics/Brush;JF)V", "setDrawStyle", "value", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "clearShader", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AndroidTextPaint extends TextPaint {
    public static final int $stable = 8;
    private int backingBlendMode;
    private Paint backingComposePaint;
    private Brush brush;
    private Size brushSize;
    private DrawStyle drawStyle;
    private Color lastColor;
    private State<? extends Shader> shaderState;
    private Shadow shadow;
    private TextDecoration textDecoration;

    public static /* synthetic */ Shader a(Brush r100, long r101) {
        return setBrush_12SF9DM$lambda$1(r100, r101);
    }

    private final void clearShader() {
        this.shaderState = null;
        this.brush = null;
        this.brushSize = null;
        setShader(null);
    }

    public static /* synthetic */ void getBrush$ui_text$annotations() {
    }

    /* JADX INFO: renamed from: getBrushSize-VsRJwc0$ui_text$annotations, reason: not valid java name */
    public static /* synthetic */ void m7261getBrushSizeVsRJwc0$ui_text$annotations() {
    }

    public static /* synthetic */ void getShadow$ui_text$annotations() {
    }

    private final Paint getComposePaint() {
        Paint r100 = this.backingComposePaint;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Paint r101 = AndroidPaint_androidKt.asComposePaint(this);
        this.backingComposePaint = r101;
        return r101;
    }

    /* JADX INFO: renamed from: getBlendMode-0nO6VwU, reason: not valid java name */
    public final int m7263getBlendMode0nO6VwU() {
        return this.backingBlendMode;
    }

    public final Brush getBrush$ui_text() {
        return this.brush;
    }

    /* JADX INFO: renamed from: getBrushSize-VsRJwc0$ui_text, reason: not valid java name */
    public final Size m7264getBrushSizeVsRJwc0$ui_text() {
        return this.brushSize;
    }

    public final State<Shader> getShaderState$ui_text() {
        return this.shaderState;
    }

    public final Shadow getShadow$ui_text() {
        return this.shadow;
    }

    /* JADX INFO: renamed from: setBlendMode-s9anfk8, reason: not valid java name */
    public final void m7265setBlendModes9anfk8(int r100) {
        if (BlendMode.m4737equalsimpl0(r100, this.backingBlendMode) == false) goto L5;
        return;
    L5:
        getComposePaint().mo4703setBlendModes9anfk8(r100);
        this.backingBlendMode = r100;
    }

    public final void setBrush$ui_text(Brush r100) {
        this.brush = r100;
    }

    /* JADX INFO: renamed from: setBrushSize-iaC8Vc4$ui_text, reason: not valid java name */
    public final void m7267setBrushSizeiaC8Vc4$ui_text(Size r100) {
        this.brushSize = r100;
    }

    /* JADX INFO: renamed from: setColor-8_81llA, reason: not valid java name */
    public final void m7268setColor8_81llA(long r100) {
        Color r101 = this.lastColor;
        boolean r102 = false;
        if (r101 != null) goto L5;
        boolean r103 = false;
    L6:
        if (r103 == false) goto L8;
        return;
    L8:
        if (r100 == 16) goto L10;
        r102 = true;
    L10:
        if (r102 == false) goto L14;
        this.lastColor = Color.m4817boximpl(r100);
        setColor(ColorKt.m4881toArgb8_81llA(r100));
        clearShader();
        return;
    L14:
        return;
    L5:
        r103 = Color.m4828equalsimpl0(r101.m4837unboximpl(), r100);
        goto L6
    }

    public final void setDrawStyle(DrawStyle r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.drawStyle, r100) == true) goto L14;
        this.drawStyle = r100;
        if (Intrinsics.areEqual(r100, Fill.INSTANCE) == false) goto L10;
        setStyle(android.graphics.Paint.Style.FILL);
        return;
    L10:
        if ((r100 instanceof Stroke) == false) goto L13;
        getComposePaint().mo4708setStylek9PVt8s(PaintingStyle.Companion.m5115getStrokeTiuSbCo());
        Stroke r101 = (Stroke) r100;
        getComposePaint().setStrokeWidth(r101.getWidth());
        getComposePaint().setStrokeMiterLimit(r101.getMiter());
        getComposePaint().mo4707setStrokeJoinWw9F2mQ(r101.m5480getJoinLxFBmk8());
        getComposePaint().mo4706setStrokeCapBeK7IIE(r101.m5479getCapKaPHkGw());
        getComposePaint().setPathEffect(r101.getPathEffect());
        return;
    L13:
        throw new NoWhenBranchMatchedException();
    }

    public final void setShaderState$ui_text(State<? extends Shader> r100) {
        this.shaderState = r100;
    }

    public final void setShadow(Shadow r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.shadow, r100) == true) goto L11;
        this.shadow = r100;
        if (Intrinsics.areEqual(r100, Shadow.Companion.getNone()) == false) goto L9;
        clearShadowLayer();
        return;
    L9:
        setShadowLayer(TextPaintExtensions_androidKt.correctBlurRadius(this.shadow.getBlurRadius()), Float.intBitsToFloat((int) (this.shadow.m5177getOffsetF1C5BW0() >> 32)), Float.intBitsToFloat((int) (this.shadow.m5177getOffsetF1C5BW0() & BodyPartID.bodyIdMax)), ColorKt.m4881toArgb8_81llA(this.shadow.m5176getColor0d7_KjU()));
        return;
    }

    public final void setShadow$ui_text(Shadow r100) {
        this.shadow = r100;
    }

    public final void setTextDecoration(TextDecoration r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.textDecoration, r100) == true) goto L8;
        this.textDecoration = r100;
        TextDecoration.Companion r101 = TextDecoration.Companion;
        setUnderlineText(r100.contains(r101.getUnderline()));
        setStrikeThruText(this.textDecoration.contains(r101.getLineThrough()));
        return;
    }

    public AndroidTextPaint(int r100, float r101) {
        super(r100);
        ((TextPaint) this).density = r101;
        this.textDecoration = TextDecoration.Companion.getNone();
        this.backingBlendMode = DrawScope.Companion.m5411getDefaultBlendMode0nO6VwU();
        this.shadow = Shadow.Companion.getNone();
    }

    private static final Shader setBrush_12SF9DM$lambda$1(Brush r100, long r101) {
        return ((ShaderBrush) r100).mo4796createShaderuvyYCjk(r101);
    }

    /* JADX INFO: renamed from: setBrush-12SF9DM, reason: not valid java name */
    public final void m7266setBrush12SF9DM(final Brush r100, final long r101, float r102) {
        if (r100 != null) goto L5;
        clearShader();
        return;
    L5:
        if ((r100 instanceof SolidColor) == false) goto L8;
        m7268setColor8_81llA(TextDrawStyleKt.m7438modulateDxMtmZc(((SolidColor) r100).m5188getValue0d7_KjU(), r102));
        return;
    L8:
        if ((r100 instanceof ShaderBrush) == false) goto L28;
        boolean r103 = false;
        if (Intrinsics.areEqual(this.brush, r100) == false) goto L17;
        Size r104 = this.brushSize;
        if (r104 != null) goto L14;
        boolean r105 = false;
    L15:
        if (r105 == false) goto L17;
    L21:
        Paint r106 = getComposePaint();
        State<? extends Shader> r107 = this.shaderState;
        if (r107 == null) goto L24;
        Shader r108 = r107.getValue();
    L25:
        r106.setShader(r108);
        this.lastColor = null;
        AndroidTextPaint_androidKt.setAlpha(this, r102);
        return;
    L24:
        r108 = null;
        goto L25
    L14:
        r105 = Size.m4647equalsimpl0(r104.m4656unboximpl(), r101);
    L17:
        if (r101 == InlineClassHelperKt.UnspecifiedPackedFloats) goto L19;
        r103 = true;
    L19:
        if (r103 == false) goto L21;
        this.brush = r100;
        this.brushSize = Size.m4639boximpl(r101);
        this.shaderState = SnapshotStateKt.derivedStateOf(new b(r100, r101));
        goto L21
    L28:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: setBrush-12SF9DM$default, reason: not valid java name */
    public static /* synthetic */ void m7262setBrush12SF9DM$default(AndroidTextPaint r100, Brush r101, long r102, float r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = Float.NaN;
    L5:
        r100.m7266setBrush12SF9DM(r101, r102, r103);
    }
}
