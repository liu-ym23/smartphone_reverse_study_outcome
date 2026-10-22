package androidx.compose.ui.text.platform.extensions;

import S7.p;
import android.graphics.Typeface;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\u001aW\u0010\u000e\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012&\u0010\t\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a3\u0010\u0018\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001d\u0010\u001c\u001a\u00020\u001b*\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0013\u0010\u001e\u001a\u00020\f*\u00020\u0001H\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0017\u0010\"\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0000¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidTextPaint;", "Landroidx/compose/ui/text/SpanStyle;", "style", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "resolveTypeface", "Landroidx/compose/ui/unit/Density;", "density", "", "requiresLetterSpacing", "applySpanStyle", "(Landroidx/compose/ui/text/platform/AndroidTextPaint;Landroidx/compose/ui/text/SpanStyle;LS7/p;Landroidx/compose/ui/unit/Density;Z)Landroidx/compose/ui/text/SpanStyle;", "Landroidx/compose/ui/unit/TextUnit;", "letterSpacing", "Landroidx/compose/ui/graphics/Color;", "background", "Landroidx/compose/ui/text/style/BaselineShift;", "baselineShift", "generateFallbackSpanStyle-62GTOB8", "(JZJLandroidx/compose/ui/text/style/BaselineShift;)Landroidx/compose/ui/text/SpanStyle;", "generateFallbackSpanStyle", "Landroidx/compose/ui/text/style/TextMotion;", "textMotion", "LC7/r;", "setTextMotion", "(Landroidx/compose/ui/text/platform/AndroidTextPaint;Landroidx/compose/ui/text/style/TextMotion;)V", "hasFontAttributes", "(Landroidx/compose/ui/text/SpanStyle;)Z", "", "blurRadius", "correctBlurRadius", "(F)F", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextPaintExtensions_androidKt {
    public static final SpanStyle applySpanStyle(AndroidTextPaint androidTextPaint, SpanStyle spanStyle, p pVar, Density density, boolean z10) {
        long jM7037getTypeUIouoOA = TextUnit.m7037getTypeUIouoOA(spanStyle.getFontSize());
        TextUnitType.Companion companion = TextUnitType.INSTANCE;
        if (TextUnitType.m7066equalsimpl0(jM7037getTypeUIouoOA, companion.m7071getSpUIouoOA())) {
            androidTextPaint.setTextSize(density.mo380toPxR2X_6o(spanStyle.getFontSize()));
        } else if (TextUnitType.m7066equalsimpl0(jM7037getTypeUIouoOA, companion.m7070getEmUIouoOA())) {
            androidTextPaint.setTextSize(TextUnit.m7038getValueimpl(spanStyle.getFontSize()) * androidTextPaint.getTextSize());
        }
        if (hasFontAttributes(spanStyle)) {
            FontFamily fontFamily = spanStyle.getFontFamily();
            FontWeight fontWeight = spanStyle.getFontWeight();
            if (fontWeight == null) {
                fontWeight = FontWeight.INSTANCE.getNormal();
            }
            FontStyle fontStyle = spanStyle.getFontStyle();
            FontStyle fontStyleM6419boximpl = FontStyle.m6419boximpl(fontStyle != null ? fontStyle.m6425unboximpl() : FontStyle.INSTANCE.m6429getNormal_LCdwA());
            FontSynthesis fontSynthesis = spanStyle.getFontSynthesis();
            androidTextPaint.setTypeface((Typeface) pVar.invoke(fontFamily, fontWeight, fontStyleM6419boximpl, FontSynthesis.m6430boximpl(fontSynthesis != null ? fontSynthesis.getValue() : FontSynthesis.INSTANCE.m6439getAllGVVA2EU())));
        }
        if (spanStyle.getLocaleList() != null && !k.b(spanStyle.getLocaleList(), LocaleList.INSTANCE.getCurrent())) {
            LocaleListHelperMethods.INSTANCE.setTextLocales(androidTextPaint, spanStyle.getLocaleList());
        }
        if (spanStyle.getFontFeatureSettings() != null && !k.b(spanStyle.getFontFeatureSettings(), "")) {
            androidTextPaint.setFontFeatureSettings(spanStyle.getFontFeatureSettings());
        }
        if (spanStyle.getTextGeometricTransform() != null && !k.b(spanStyle.getTextGeometricTransform(), TextGeometricTransform.INSTANCE.getNone$ui_text())) {
            androidTextPaint.setTextScaleX(spanStyle.getTextGeometricTransform().getScaleX() * androidTextPaint.getTextScaleX());
            androidTextPaint.setTextSkewX(spanStyle.getTextGeometricTransform().getSkewX() + androidTextPaint.getTextSkewX());
        }
        androidTextPaint.m6578setColor8_81llA(spanStyle.m6252getColor0d7_KjU());
        androidTextPaint.m6576setBrush12SF9DM(spanStyle.getBrush(), Size.INSTANCE.m3972getUnspecifiedNHjbRc(), spanStyle.getAlpha());
        androidTextPaint.setShadow(spanStyle.getShadow());
        androidTextPaint.setTextDecoration(spanStyle.getBackground());
        androidTextPaint.setDrawStyle(spanStyle.getDrawStyle());
        if (TextUnitType.m7066equalsimpl0(TextUnit.m7037getTypeUIouoOA(spanStyle.getLetterSpacing()), companion.m7071getSpUIouoOA()) && TextUnit.m7038getValueimpl(spanStyle.getLetterSpacing()) != 0.0f) {
            float textScaleX = androidTextPaint.getTextScaleX() * androidTextPaint.getTextSize();
            float fMo380toPxR2X_6o = density.mo380toPxR2X_6o(spanStyle.getLetterSpacing());
            if (textScaleX != 0.0f) {
                androidTextPaint.setLetterSpacing(fMo380toPxR2X_6o / textScaleX);
            }
        } else if (TextUnitType.m7066equalsimpl0(TextUnit.m7037getTypeUIouoOA(spanStyle.getLetterSpacing()), companion.m7070getEmUIouoOA())) {
            androidTextPaint.setLetterSpacing(TextUnit.m7038getValueimpl(spanStyle.getLetterSpacing()));
        }
        return m6593generateFallbackSpanStyle62GTOB8(spanStyle.getLetterSpacing(), z10, spanStyle.getBackground(), spanStyle.getBaselineShift());
    }

    public static /* synthetic */ SpanStyle applySpanStyle$default(AndroidTextPaint androidTextPaint, SpanStyle spanStyle, p pVar, Density density, boolean z10, int i, Object obj) {
        if ((i & 8) != 0) {
            z10 = false;
        }
        return applySpanStyle(androidTextPaint, spanStyle, pVar, density, z10);
    }

    public static final float correctBlurRadius(float f) {
        if (f == 0.0f) {
            return Float.MIN_VALUE;
        }
        return f;
    }

    /* renamed from: generateFallbackSpanStyle-62GTOB8, reason: not valid java name */
    private static final SpanStyle m6593generateFallbackSpanStyle62GTOB8(long j5, boolean z10, long j6, BaselineShift baselineShift) {
        long jM4175getUnspecified0d7_KjU = j6;
        boolean z11 = false;
        boolean z12 = z10 && TextUnitType.m7066equalsimpl0(TextUnit.m7037getTypeUIouoOA(j5), TextUnitType.INSTANCE.m7071getSpUIouoOA()) && TextUnit.m7038getValueimpl(j5) != 0.0f;
        Color.Companion companion = Color.INSTANCE;
        boolean z13 = (Color.m4140equalsimpl0(jM4175getUnspecified0d7_KjU, companion.m4175getUnspecified0d7_KjU()) || Color.m4140equalsimpl0(jM4175getUnspecified0d7_KjU, companion.m4174getTransparent0d7_KjU())) ? false : true;
        if (baselineShift != null) {
            if (!BaselineShift.m6603equalsimpl0(baselineShift.m6606unboximpl(), BaselineShift.INSTANCE.m6610getNoney9eOQZs())) {
                z11 = true;
            }
        }
        if (!z12 && !z13 && !z11) {
            return null;
        }
        long jM7049getUnspecifiedXSAIIZE = z12 ? j5 : TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE();
        if (!z13) {
            jM4175getUnspecified0d7_KjU = companion.m4175getUnspecified0d7_KjU();
        }
        return new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, jM7049getUnspecifiedXSAIIZE, z11 ? baselineShift : null, (TextGeometricTransform) null, (LocaleList) null, jM4175getUnspecified0d7_KjU, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 63103, (e) null);
    }

    public static final boolean hasFontAttributes(SpanStyle spanStyle) {
        return (spanStyle.getFontFamily() == null && spanStyle.getFontStyle() == null && spanStyle.getFontWeight() == null) ? false : true;
    }

    public static final void setTextMotion(AndroidTextPaint androidTextPaint, TextMotion textMotion) {
        if (textMotion == null) {
            textMotion = TextMotion.INSTANCE.getStatic();
        }
        androidTextPaint.setFlags(textMotion.getSubpixelTextPositioning() ? androidTextPaint.getFlags() | 128 : androidTextPaint.getFlags() & (-129));
        int linearity = textMotion.getLinearity();
        TextMotion.Linearity.Companion companion = TextMotion.Linearity.INSTANCE;
        if (TextMotion.Linearity.m6760equalsimpl0(linearity, companion.m6765getLinear4e0Vf04())) {
            androidTextPaint.setFlags(androidTextPaint.getFlags() | 64);
            androidTextPaint.setHinting(0);
        } else if (TextMotion.Linearity.m6760equalsimpl0(linearity, companion.m6764getFontHinting4e0Vf04())) {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(1);
        } else if (!TextMotion.Linearity.m6760equalsimpl0(linearity, companion.m6766getNone4e0Vf04())) {
            androidTextPaint.getFlags();
        } else {
            androidTextPaint.getFlags();
            androidTextPaint.setHinting(0);
        }
    }
}
