package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.SpanStyleKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a'\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\u000b\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\t\u0010\n\u001a!\u0010\u000e\u001a\u00020\u0003*\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/style/TextForegroundStyle;", "start", "stop", "", "fraction", "lerp", "(Landroidx/compose/ui/text/style/TextForegroundStyle;Landroidx/compose/ui/text/style/TextForegroundStyle;F)Landroidx/compose/ui/text/style/TextForegroundStyle;", "Landroidx/compose/ui/graphics/Color;", "alpha", "modulate-DxMtmZc", "(JF)J", "modulate", "Lkotlin/Function0;", "block", "takeOrElse", "(FLS7/a;)F", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextDrawStyleKt {
    public static final TextForegroundStyle lerp(TextForegroundStyle textForegroundStyle, TextForegroundStyle textForegroundStyle2, float f) {
        boolean z10 = textForegroundStyle instanceof BrushStyle;
        if (!z10 && !(textForegroundStyle2 instanceof BrushStyle)) {
            return TextForegroundStyle.INSTANCE.m6749from8_81llA(ColorKt.m4190lerpjxsXWHM(textForegroundStyle.mo6614getColor0d7_KjU(), textForegroundStyle2.mo6614getColor0d7_KjU(), f));
        }
        if (!z10 || !(textForegroundStyle2 instanceof BrushStyle)) {
            return (TextForegroundStyle) SpanStyleKt.lerpDiscrete(textForegroundStyle, textForegroundStyle2, f);
        }
        BrushStyle brushStyle = (BrushStyle) textForegroundStyle;
        BrushStyle brushStyle2 = (BrushStyle) textForegroundStyle2;
        return TextForegroundStyle.INSTANCE.from((Brush) SpanStyleKt.lerpDiscrete(brushStyle.getBrush(), brushStyle2.getBrush(), f), MathHelpersKt.lerp(brushStyle.getAlpha(), brushStyle2.getAlpha(), f));
    }

    /* renamed from: modulate-DxMtmZc, reason: not valid java name */
    public static final long m6748modulateDxMtmZc(long j5, float f) {
        return (Float.isNaN(f) || f >= 1.0f) ? j5 : Color.m4138copywmQWz5c$default(j5, Color.m4141getAlphaimpl(j5) * f, 0.0f, 0.0f, 0.0f, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float takeOrElse(float f, S7.a aVar) {
        return Float.isNaN(f) ? ((Number) aVar.invoke()).floatValue() : f;
    }
}
