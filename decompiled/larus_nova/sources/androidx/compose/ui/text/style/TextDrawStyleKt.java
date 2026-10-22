package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.SpanStyleKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u001b\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001a\u0010\u000b\u001a\u00020\u0005*\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0002¨\u0006\u000e"}, d2 = {"lerp", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "start", "stop", "fraction", "", "modulate", "Landroidx/compose/ui/graphics/Color;", "alpha", "modulate-DxMtmZc", "(JF)J", "takeOrElse", "block", "Lkotlin/Function0;", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextDrawStyleKt {
    public static final /* synthetic */ float access$takeOrElse(float r100, Function0 r101) {
        return takeOrElse(r100, r101);
    }

    /* JADX INFO: renamed from: modulate-DxMtmZc, reason: not valid java name */
    public static final long m7438modulateDxMtmZc(long r100, float r110) {
        if (Float.isNaN(r110) == false) goto L5;
        return r100;
    L5:
        if (r110 < 1.0f) goto L8;
        return r100;
    L8:
        return Color.m4826copywmQWz5c$default(r100, Color.m4829getAlphaimpl(r100) * r110, 0.0f, 0.0f, 0.0f, 14, null);
    }

    private static final float takeOrElse(float r100, Function0<Float> r101) {
        if (Float.isNaN(r100) == true) goto L5;
        return r100;
    L5:
        return r101.invoke().floatValue();
    }

    public static final TextForegroundStyle lerp(TextForegroundStyle r100, TextForegroundStyle r101, float r102) {
        boolean r103 = r100 instanceof BrushStyle;
        if (r103 == false) goto L5;
    L7:
        if (r103 == false) goto L12;
        if ((r101 instanceof BrushStyle) == false) goto L12;
        BrushStyle r104 = (BrushStyle) r100;
        BrushStyle r105 = (BrushStyle) r101;
        return TextForegroundStyle.Companion.from((Brush) SpanStyleKt.lerpDiscrete(r104.getBrush(), r105.getBrush(), r102), MathHelpersKt.lerp(r104.getAlpha(), r105.getAlpha(), r102));
    L12:
        return (TextForegroundStyle) SpanStyleKt.lerpDiscrete(r100, r101, r102);
    L5:
        if ((r101 instanceof BrushStyle) == true) goto L7;
        return TextForegroundStyle.Companion.m7439from8_81llA(ColorKt.m4878lerpjxsXWHM(r100.mo7304getColor0d7_KjU(), r101.mo7304getColor0d7_KjU(), r102));
    }
}
