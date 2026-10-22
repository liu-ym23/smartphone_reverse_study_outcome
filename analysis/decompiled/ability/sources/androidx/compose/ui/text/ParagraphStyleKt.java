package androidx.compose.ui.text;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextIndentKt;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a&\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001ac\u0010\u000f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0004\b \u0010!\u001a\u0018\u0010\"\u001a\u0004\u0018\u00010\n*\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\nH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006$"}, d2 = {"DefaultLineHeight", "Landroidx/compose/ui/unit/TextUnit;", "J", "lerp", "Landroidx/compose/ui/text/ParagraphStyle;", "start", "stop", "fraction", "", "lerpPlatformStyle", "Landroidx/compose/ui/text/PlatformParagraphStyle;", "resolveParagraphStyleDefaults", "style", "direction", "Landroidx/compose/ui/unit/LayoutDirection;", "fastMerge", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "platformStyle", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "textMotion", "Landroidx/compose/ui/text/style/TextMotion;", "fastMerge-j5T8yCg", "(Landroidx/compose/ui/text/ParagraphStyle;IIJLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformParagraphStyle;Landroidx/compose/ui/text/style/LineHeightStyle;IILandroidx/compose/ui/text/style/TextMotion;)Landroidx/compose/ui/text/ParagraphStyle;", "mergePlatformStyle", "other", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ParagraphStyleKt {
    private static final long DefaultLineHeight = TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE();

    /* renamed from: fastMerge-j5T8yCg, reason: not valid java name */
    public static final ParagraphStyle m6219fastMergej5T8yCg(ParagraphStyle paragraphStyle, int i, int i6, long j5, TextIndent textIndent, PlatformParagraphStyle platformParagraphStyle, LineHeightStyle lineHeightStyle, int i10, int i11, TextMotion textMotion) {
        long j6;
        long j10;
        int textAlign = i;
        TextIndent textIndent2 = textIndent;
        TextAlign.Companion companion = TextAlign.INSTANCE;
        if (TextAlign.m6724equalsimpl0(textAlign, companion.m6734getUnspecifiede0LSkKk()) || TextAlign.m6724equalsimpl0(textAlign, paragraphStyle.getTextAlign())) {
            if (TextUnit.m7036getRawTypeimpl(j5) == 0) {
                j6 = 0;
                j10 = j5;
            } else {
                j6 = 0;
                j10 = j5;
                if (TextUnit.m7035equalsimpl0(j10, paragraphStyle.getLineHeight())) {
                }
            }
            if ((textIndent2 == null || textIndent2.equals(paragraphStyle.getTextIndent())) && ((TextDirection.m6738equalsimpl0(i6, TextDirection.INSTANCE.m6747getUnspecifieds_7Xco()) || TextDirection.m6738equalsimpl0(i6, paragraphStyle.getTextDirection())) && ((platformParagraphStyle == null || platformParagraphStyle.equals(paragraphStyle.getPlatformStyle())) && ((lineHeightStyle == null || lineHeightStyle.equals(paragraphStyle.getLineHeightStyle())) && ((LineBreak.m6635equalsimpl0(i10, LineBreak.INSTANCE.m6649getUnspecifiedrAG3T2k()) || LineBreak.m6635equalsimpl0(i10, paragraphStyle.getLineBreak())) && ((Hyphens.m6622equalsimpl0(i11, Hyphens.INSTANCE.m6628getUnspecifiedvmbZdU8()) || Hyphens.m6622equalsimpl0(i11, paragraphStyle.getHyphens())) && (textMotion == null || textMotion.equals(paragraphStyle.getTextMotion())))))))) {
                return paragraphStyle;
            }
        } else {
            j6 = 0;
            j10 = j5;
        }
        long lineHeight = TextUnit.m7036getRawTypeimpl(j10) == j6 ? paragraphStyle.getLineHeight() : j10;
        if (textIndent2 == null) {
            textIndent2 = paragraphStyle.getTextIndent();
        }
        TextIndent textIndent3 = textIndent2;
        if (TextAlign.m6724equalsimpl0(textAlign, companion.m6734getUnspecifiede0LSkKk())) {
            textAlign = paragraphStyle.getTextAlign();
        }
        return new ParagraphStyle(textAlign, !TextDirection.m6738equalsimpl0(i6, TextDirection.INSTANCE.m6747getUnspecifieds_7Xco()) ? i6 : paragraphStyle.getTextDirection(), lineHeight, textIndent3, mergePlatformStyle(paragraphStyle, platformParagraphStyle), lineHeightStyle == null ? paragraphStyle.getLineHeightStyle() : lineHeightStyle, !LineBreak.m6635equalsimpl0(i10, LineBreak.INSTANCE.m6649getUnspecifiedrAG3T2k()) ? i10 : paragraphStyle.getLineBreak(), !Hyphens.m6622equalsimpl0(i11, Hyphens.INSTANCE.m6628getUnspecifiedvmbZdU8()) ? i11 : paragraphStyle.getHyphens(), textMotion == null ? paragraphStyle.getTextMotion() : textMotion, (e) null);
    }

    @Stable
    public static final ParagraphStyle lerp(ParagraphStyle paragraphStyle, ParagraphStyle paragraphStyle2, float f) {
        int value = ((TextAlign) SpanStyleKt.lerpDiscrete(TextAlign.m6721boximpl(paragraphStyle.getTextAlign()), TextAlign.m6721boximpl(paragraphStyle2.getTextAlign()), f)).getValue();
        int value2 = ((TextDirection) SpanStyleKt.lerpDiscrete(TextDirection.m6735boximpl(paragraphStyle.getTextDirection()), TextDirection.m6735boximpl(paragraphStyle2.getTextDirection()), f)).getValue();
        long jM6258lerpTextUnitInheritableC3pnCVY = SpanStyleKt.m6258lerpTextUnitInheritableC3pnCVY(paragraphStyle.getLineHeight(), paragraphStyle2.getLineHeight(), f);
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.INSTANCE.getNone();
        }
        TextIndent textIndent2 = paragraphStyle2.getTextIndent();
        if (textIndent2 == null) {
            textIndent2 = TextIndent.INSTANCE.getNone();
        }
        return new ParagraphStyle(value, value2, jM6258lerpTextUnitInheritableC3pnCVY, TextIndentKt.lerp(textIndent, textIndent2, f), lerpPlatformStyle(paragraphStyle.getPlatformStyle(), paragraphStyle2.getPlatformStyle(), f), (LineHeightStyle) SpanStyleKt.lerpDiscrete(paragraphStyle.getLineHeightStyle(), paragraphStyle2.getLineHeightStyle(), f), ((LineBreak) SpanStyleKt.lerpDiscrete(LineBreak.m6629boximpl(paragraphStyle.getLineBreak()), LineBreak.m6629boximpl(paragraphStyle2.getLineBreak()), f)).getMask(), ((Hyphens) SpanStyleKt.lerpDiscrete(Hyphens.m6619boximpl(paragraphStyle.getHyphens()), Hyphens.m6619boximpl(paragraphStyle2.getHyphens()), f)).getValue(), (TextMotion) SpanStyleKt.lerpDiscrete(paragraphStyle.getTextMotion(), paragraphStyle2.getTextMotion(), f), (e) null);
    }

    private static final PlatformParagraphStyle lerpPlatformStyle(PlatformParagraphStyle platformParagraphStyle, PlatformParagraphStyle platformParagraphStyle2, float f) {
        if (platformParagraphStyle == null && platformParagraphStyle2 == null) {
            return null;
        }
        if (platformParagraphStyle == null) {
            platformParagraphStyle = PlatformParagraphStyle.INSTANCE.getDefault();
        }
        if (platformParagraphStyle2 == null) {
            platformParagraphStyle2 = PlatformParagraphStyle.INSTANCE.getDefault();
        }
        return AndroidTextStyle_androidKt.lerp(platformParagraphStyle, platformParagraphStyle2, f);
    }

    private static final PlatformParagraphStyle mergePlatformStyle(ParagraphStyle paragraphStyle, PlatformParagraphStyle platformParagraphStyle) {
        return paragraphStyle.getPlatformStyle() == null ? platformParagraphStyle : platformParagraphStyle == null ? paragraphStyle.getPlatformStyle() : paragraphStyle.getPlatformStyle().merge(platformParagraphStyle);
    }

    public static final ParagraphStyle resolveParagraphStyleDefaults(ParagraphStyle paragraphStyle, LayoutDirection layoutDirection) {
        int textAlign = paragraphStyle.getTextAlign();
        TextAlign.Companion companion = TextAlign.INSTANCE;
        int iM6733getStarte0LSkKk = TextAlign.m6724equalsimpl0(textAlign, companion.m6734getUnspecifiede0LSkKk()) ? companion.m6733getStarte0LSkKk() : paragraphStyle.getTextAlign();
        int iM6357resolveTextDirectionIhaHGbI = TextStyleKt.m6357resolveTextDirectionIhaHGbI(layoutDirection, paragraphStyle.getTextDirection());
        long lineHeight = TextUnit.m7036getRawTypeimpl(paragraphStyle.getLineHeight()) == 0 ? DefaultLineHeight : paragraphStyle.getLineHeight();
        TextIndent textIndent = paragraphStyle.getTextIndent();
        if (textIndent == null) {
            textIndent = TextIndent.INSTANCE.getNone();
        }
        TextIndent textIndent2 = textIndent;
        PlatformParagraphStyle platformStyle = paragraphStyle.getPlatformStyle();
        LineHeightStyle lineHeightStyle = paragraphStyle.getLineHeightStyle();
        int lineBreak = paragraphStyle.getLineBreak();
        LineBreak.Companion companion2 = LineBreak.INSTANCE;
        int iM6648getSimplerAG3T2k = LineBreak.m6635equalsimpl0(lineBreak, companion2.m6649getUnspecifiedrAG3T2k()) ? companion2.m6648getSimplerAG3T2k() : paragraphStyle.getLineBreak();
        int hyphens = paragraphStyle.getHyphens();
        Hyphens.Companion companion3 = Hyphens.INSTANCE;
        int iM6627getNonevmbZdU8 = Hyphens.m6622equalsimpl0(hyphens, companion3.m6628getUnspecifiedvmbZdU8()) ? companion3.m6627getNonevmbZdU8() : paragraphStyle.getHyphens();
        TextMotion textMotion = paragraphStyle.getTextMotion();
        if (textMotion == null) {
            textMotion = TextMotion.INSTANCE.getStatic();
        }
        return new ParagraphStyle(iM6733getStarte0LSkKk, iM6357resolveTextDirectionIhaHGbI, lineHeight, textIndent2, platformStyle, lineHeightStyle, iM6648getSimplerAG3T2k, iM6627getNonevmbZdU8, textMotion, (e) null);
    }
}
