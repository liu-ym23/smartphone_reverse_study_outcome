package androidx.compose.ui.text.platform.style;

import S7.a;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPathEffect_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a;\u0010\u000f\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a;\u0010\u0019\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Landroid/graphics/Paint;", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "value", "LC7/r;", "setDrawStyle", "(Landroid/graphics/Paint;Landroidx/compose/ui/graphics/drawscope/DrawStyle;)V", "Landroidx/compose/ui/graphics/Outline;", "Landroid/graphics/Canvas;", "canvas", "paint", "", "xStart", "yCenter", "", "dir", "draw", "(Landroidx/compose/ui/graphics/Outline;Landroid/graphics/Canvas;Landroid/graphics/Paint;FFI)V", "Landroidx/compose/ui/graphics/Brush;", "brush", "alpha", "Landroidx/compose/ui/geometry/Size;", "size", "Lkotlin/Function0;", "setBrushAndDraw-yzxVdVo", "(Landroid/graphics/Paint;Landroidx/compose/ui/graphics/Brush;FJLS7/a;)V", "setBrushAndDraw", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BulletSpan_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void draw(Outline outline, Canvas canvas, Paint paint, float f, float f7, int i) {
        if (outline instanceof Outline.Generic) {
            canvas.save();
            Outline.Generic generic = (Outline.Generic) outline;
            Rect rect = generic.getRect();
            canvas.translate(f, f7 - ((rect.getBottom() - rect.getTop()) / 2.0f));
            Path path = generic.getPath();
            if (!(path instanceof AndroidPath)) {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
            canvas.drawPath(((AndroidPath) path).getInternalPath(), paint);
            canvas.restore();
            return;
        }
        if (!(outline instanceof Outline.Rounded)) {
            if (!(outline instanceof Outline.Rectangle)) {
                throw new NoWhenBranchMatchedException();
            }
            Outline.Rectangle rectangle = (Outline.Rectangle) outline;
            Rect rect2 = rectangle.getRect();
            float bottom = f7 - ((rect2.getBottom() - rect2.getTop()) / 2.0f);
            Rect rect3 = rectangle.getRect();
            float right = rect3.getRight() - rect3.getLeft();
            Rect rect4 = rectangle.getRect();
            canvas.drawRect(f, bottom, (right * i) + f, ((rect4.getBottom() - rect4.getTop()) / 2.0f) + f7, paint);
            return;
        }
        Outline.Rounded rounded = (Outline.Rounded) outline;
        if (RoundRectKt.isSimple(rounded.getRoundRect())) {
            float fIntBitsToFloat = Float.intBitsToFloat((int) (rounded.getRoundRect().m3945getTopLeftCornerRadiuskKHJgLs() >> 32));
            canvas.drawRoundRect(f, f7 - (rounded.getRoundRect().getHeight() / 2.0f), (rounded.getRoundRect().getWidth() * i) + f, (rounded.getRoundRect().getHeight() / 2.0f) + f7, fIntBitsToFloat, fIntBitsToFloat, paint);
            return;
        }
        Path Path = AndroidPath_androidKt.Path();
        Path.addRoundRect$default(Path, rounded.getRoundRect(), null, 2, null);
        canvas.save();
        canvas.translate(f, f7 - (rounded.getRoundRect().getHeight() / 2.0f));
        if (!(Path instanceof AndroidPath)) {
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        canvas.drawPath(((AndroidPath) Path).getInternalPath(), paint);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setBrushAndDraw-yzxVdVo, reason: not valid java name */
    public static final void m6595setBrushAndDrawyzxVdVo(Paint paint, Brush brush, float f, long j5, a aVar) {
        Integer numValueOf = null;
        if (brush == null) {
            if (!Float.isNaN(f)) {
                numValueOf = Integer.valueOf(paint.getAlpha());
                paint.setAlpha((int) Math.rint(f * 255.0f));
            }
            aVar.invoke();
            if (numValueOf != null) {
                paint.setAlpha(numValueOf.intValue());
                return;
            }
            return;
        }
        if (brush instanceof SolidColor) {
            int color = paint.getColor();
            if (!Float.isNaN(f)) {
                numValueOf = Integer.valueOf(paint.getAlpha());
                paint.setAlpha((int) Math.rint(f * 255.0f));
            }
            paint.setColor(ColorKt.m4193toArgb8_81llA(((SolidColor) brush).getValue()));
            aVar.invoke();
            paint.setColor(color);
            if (numValueOf != null) {
                paint.setAlpha(numValueOf.intValue());
                return;
            }
            return;
        }
        if (!(brush instanceof ShaderBrush)) {
            throw new NoWhenBranchMatchedException();
        }
        Shader shader = paint.getShader();
        if (!Float.isNaN(f)) {
            numValueOf = Integer.valueOf(paint.getAlpha());
            paint.setAlpha((int) Math.rint(f * 255.0f));
        }
        paint.setShader(((ShaderBrush) brush).mo4108createShaderuvyYCjk(j5));
        aVar.invoke();
        paint.setShader(shader);
        if (numValueOf != null) {
            paint.setAlpha(numValueOf.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDrawStyle(Paint paint, DrawStyle drawStyle) {
        if (k.b(drawStyle, Fill.INSTANCE)) {
            paint.setStyle(Paint.Style.FILL);
            return;
        }
        if (!(drawStyle instanceof Stroke)) {
            throw new NoWhenBranchMatchedException();
        }
        paint.setStyle(Paint.Style.STROKE);
        Stroke stroke = (Stroke) drawStyle;
        paint.setStrokeWidth(stroke.getWidth());
        paint.setStrokeMiter(stroke.getMiter());
        paint.setStrokeCap(DrawStyleSpan_androidKt.m6596toAndroidCapBeK7IIE(stroke.getCap()));
        paint.setStrokeJoin(DrawStyleSpan_androidKt.m6597toAndroidJoinWw9F2mQ(stroke.getJoin()));
        PathEffect pathEffect = stroke.getPathEffect();
        paint.setPathEffect(pathEffect != null ? AndroidPathEffect_androidKt.asAndroidPathEffect(pathEffect) : null);
    }
}
