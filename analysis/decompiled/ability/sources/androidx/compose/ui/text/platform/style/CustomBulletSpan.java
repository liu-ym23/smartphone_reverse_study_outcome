package androidx.compose.ui.text.platform.style;

import C7.r;
import U7.a;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.platform.style.CustomBulletSpan;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016Jw\u0010'\u001a\u00020&2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b'\u0010(R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010)R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010*R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010*R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010+R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010*R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010,R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010-R\u0014\u0010.\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010/¨\u00061"}, d2 = {"Landroidx/compose/ui/text/platform/style/CustomBulletSpan;", "Landroid/text/style/LeadingMarginSpan;", "Landroidx/compose/ui/graphics/Shape;", "shape", "", "bulletWidthPx", "bulletHeightPx", "gapWidthPx", "Landroidx/compose/ui/graphics/Brush;", "brush", "alpha", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "drawStyle", "Landroidx/compose/ui/unit/Density;", "density", "textIndentPx", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/graphics/Shape;FFFLandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/unit/Density;F)V", "", "first", "", "getLeadingMargin", "(Z)I", "Landroid/graphics/Canvas;", "c", "Landroid/graphics/Paint;", "p", "x", "dir", "top", "baseline", "bottom", "", "text", "start", "end", "Landroid/text/Layout;", "layout", "LC7/r;", "drawLeadingMargin", "(Landroid/graphics/Canvas;Landroid/graphics/Paint;IIIIILjava/lang/CharSequence;IIZLandroid/text/Layout;)V", "Landroidx/compose/ui/graphics/Shape;", "F", "Landroidx/compose/ui/graphics/Brush;", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "Landroidx/compose/ui/unit/Density;", "minimumRequiredIndent", "I", "diff", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CustomBulletSpan implements LeadingMarginSpan {
    public static final int $stable = 8;
    private final float alpha;
    private final Brush brush;
    private final float bulletHeightPx;
    private final float bulletWidthPx;
    private final Density density;
    private final int diff;
    private final DrawStyle drawStyle;
    private final int minimumRequiredIndent;
    private final Shape shape;

    public CustomBulletSpan(Shape shape, float f, float f7, float f9, Brush brush, float f10, DrawStyle drawStyle, Density density, float f11) {
        this.shape = shape;
        this.bulletWidthPx = f;
        this.bulletHeightPx = f7;
        this.brush = brush;
        this.alpha = f10;
        this.drawStyle = drawStyle;
        this.density = density;
        int iU = a.U(f + f9);
        this.minimumRequiredIndent = iU;
        this.diff = a.U(f11) - iU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r drawLeadingMargin$lambda$1$lambda$0(CustomBulletSpan customBulletSpan, long j5, int i, Canvas canvas, Paint paint, int i6, float f) {
        BulletSpan_androidKt.draw(customBulletSpan.shape.mo289createOutlinePq9zytI(j5, i > 0 ? LayoutDirection.Ltr : LayoutDirection.Rtl, customBulletSpan.density), canvas, paint, i6, f, i);
        return r.f317a;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(final Canvas c, final Paint p, int x10, final int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, Layout layout) {
        if (c == null) {
            return;
        }
        final float f = (top + bottom) / 2.0f;
        int i = x10 - this.minimumRequiredIndent;
        if (i < 0) {
            i = 0;
        }
        final int i6 = i;
        k.d(text, "null cannot be cast to non-null type android.text.Spanned");
        if (((Spanned) text).getSpanStart(this) != start || p == null) {
            return;
        }
        Paint.Style style = p.getStyle();
        BulletSpan_androidKt.setDrawStyle(p, this.drawStyle);
        float f7 = this.bulletWidthPx;
        float f9 = this.bulletHeightPx;
        final long jM3955constructorimpl = Size.m3955constructorimpl((Float.floatToRawIntBits(f9) & 4294967295L) | (Float.floatToRawIntBits(f7) << 32));
        BulletSpan_androidKt.m6595setBrushAndDrawyzxVdVo(p, this.brush, this.alpha, jM3955constructorimpl, new S7.a() { // from class: j.a
            @Override // S7.a
            public final Object invoke() {
                return CustomBulletSpan.drawLeadingMargin$lambda$1$lambda$0(this.f4750a, jM3955constructorimpl, dir, c, p, i6, f);
            }
        });
        p.setStyle(style);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean first) {
        int i = this.diff;
        if (i >= 0) {
            return 0;
        }
        return Math.abs(i);
    }
}
