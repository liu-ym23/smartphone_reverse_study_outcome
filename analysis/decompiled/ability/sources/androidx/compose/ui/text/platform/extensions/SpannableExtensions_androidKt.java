package androidx.compose.ui.text.platform.extensions;

import C7.r;
import S7.o;
import S7.p;
import U7.a;
import W3.c;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.Bullet;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.style.BaselineShiftSpan;
import androidx.compose.ui.text.android.style.FontFeatureSpan;
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import androidx.compose.ui.text.android.style.LineHeightSpan;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import androidx.compose.ui.text.android.style.ShadowSpan;
import androidx.compose.ui.text.android.style.SkewXSpan;
import androidx.compose.ui.text.android.style.TextDecorationSpan;
import androidx.compose.ui.text.android.style.TypefaceSpan;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.style.CustomBulletSpan;
import androidx.compose.ui.text.platform.style.DrawStyleSpan;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import j9.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u001a+\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a-\u0010\u000f\u001a\u00020\u0006*\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aC\u0010\u0015\u001a\u00020\u0006*\u00020\u00002\u0014\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00120\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a'\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a3\u0010!\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001dH\u0000¢\u0006\u0004\b\u001f\u0010 \u001a+\u0010!\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\"\u0010#\u001a'\u0010%\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b$\u0010\u001a\u001a\u0017\u0010'\u001a\u00020&2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b'\u0010(\u001aa\u00102\u001a\u00020\u0006*\u00020\u00002\u0006\u0010*\u001a\u00020)2\u0014\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00120\u00112\u0006\u0010\u000e\u001a\u00020\r2&\u00101\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000+H\u0000¢\u0006\u0004\b2\u00103\u001a3\u00106\u001a\u00020\u0006*\u00020\u00002\u0006\u00105\u001a\u0002042\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b6\u00107\u001aY\u00108\u001a\u00020\u0006*\u00020\u00002\u0006\u0010*\u001a\u00020)2\u0014\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00120\u00112&\u00101\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000+H\u0002¢\u0006\u0004\b8\u00109\u001aM\u0010>\u001a\u00020\u00062\b\u0010:\u001a\u0004\u0018\u0001042\u0012\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u00120\u00112\u001e\u0010=\u001a\u001a\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060<H\u0000¢\u0006\u0004\b>\u0010?\u001a!\u0010D\u001a\u0004\u0018\u00010A2\u0006\u0010@\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\bB\u0010C\u001a-\u0010G\u001a\u00020\u0006*\u00020\u00002\b\u0010F\u001a\u0004\u0018\u00010E2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\bG\u0010H\u001a-\u0010K\u001a\u00020\u0006*\u00020\u00002\b\u0010J\u001a\u0004\u0018\u00010I2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\bK\u0010L\u001a+\u0010Q\u001a\u00020\u0006*\u00020\u00002\u0006\u0010N\u001a\u00020M2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000¢\u0006\u0004\bO\u0010P\u001a-\u0010T\u001a\u00020\u0006*\u00020\u00002\b\u0010S\u001a\u0004\u0018\u00010R2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000¢\u0006\u0004\bT\u0010U\u001a-\u0010X\u001a\u00020\u0006*\u00020\u00002\b\u0010W\u001a\u0004\u0018\u00010V2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\bX\u0010Y\u001a-\u0010\\\u001a\u00020\u0006*\u00020\u00002\b\u0010[\u001a\u0004\u0018\u00010Z2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\\\u0010]\u001a3\u0010a\u001a\u00020\u0006*\u00020\u00002\u0006\u0010^\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000¢\u0006\u0004\b_\u0010`\u001a-\u0010d\u001a\u00020\u0006*\u00020\u00002\b\u0010c\u001a\u0004\u0018\u00010b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000¢\u0006\u0004\bd\u0010e\u001a+\u0010g\u001a\u00020\u0006*\u00020\u00002\u0006\u0010N\u001a\u00020M2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000¢\u0006\u0004\bf\u0010P\u001a-\u0010l\u001a\u00020\u0006*\u00020\u00002\b\u0010i\u001a\u0004\u0018\u00010h2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\bj\u0010k\u001a5\u0010p\u001a\u00020\u0006*\u00020\u00002\b\u0010n\u001a\u0004\u0018\u00010m2\u0006\u0010o\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\bp\u0010q\u001a\u0013\u0010r\u001a\u00020&*\u00020)H\u0002¢\u0006\u0004\br\u0010s\u001a\u001d\u0010u\u001a\u000204*\u0004\u0018\u0001042\u0006\u0010t\u001a\u000204H\u0002¢\u0006\u0004\bu\u0010v\"\u0018\u0010y\u001a\u00020&*\u0002048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bw\u0010x¨\u0006z"}, d2 = {"Landroid/text/Spannable;", "", "span", "", "start", "end", "LC7/r;", "setSpan", "(Landroid/text/Spannable;Ljava/lang/Object;II)V", "Landroidx/compose/ui/text/style/TextIndent;", "textIndent", "", "contextFontSize", "Landroidx/compose/ui/unit/Density;", "density", "setTextIndent", "(Landroid/text/Spannable;Landroidx/compose/ui/text/style/TextIndent;FLandroidx/compose/ui/unit/Density;)V", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "annotations", "setBulletSpans", "(Landroid/text/Spannable;Ljava/util/List;FLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/style/TextIndent;)V", "Landroidx/compose/ui/unit/TextUnit;", "size", "resolveBulletTextUnitToPx-o2QH7mI", "(JFLandroidx/compose/ui/unit/Density;)F", "resolveBulletTextUnitToPx", "lineHeight", "Landroidx/compose/ui/text/style/LineHeightStyle;", "lineHeightStyle", "setLineHeight-KmRG4DE", "(Landroid/text/Spannable;JFLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/style/LineHeightStyle;)V", "setLineHeight", "setLineHeight-r9BaKPg", "(Landroid/text/Spannable;JFLandroidx/compose/ui/unit/Density;)V", "resolveLineHeightInPx-o2QH7mI", "resolveLineHeightInPx", "", "isNonLinearFontScalingActive", "(Landroidx/compose/ui/unit/Density;)Z", "Landroidx/compose/ui/text/TextStyle;", "contextTextStyle", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "resolveTypeface", "setSpanStyles", "(Landroid/text/Spannable;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;Landroidx/compose/ui/unit/Density;LS7/p;)V", "Landroidx/compose/ui/text/SpanStyle;", "style", "setSpanStyle", "(Landroid/text/Spannable;Landroidx/compose/ui/text/SpanStyle;IILandroidx/compose/ui/unit/Density;)V", "setFontAttributes", "(Landroid/text/Spannable;Landroidx/compose/ui/text/TextStyle;Ljava/util/List;LS7/p;)V", "contextFontSpanStyle", "spanStyles", "Lkotlin/Function3;", "block", "flattenFontStylesAndApply", "(Landroidx/compose/ui/text/SpanStyle;Ljava/util/List;LS7/o;)V", "letterSpacing", "Landroid/text/style/MetricAffectingSpan;", "createLetterSpacingSpan-eAf_CNQ", "(JLandroidx/compose/ui/unit/Density;)Landroid/text/style/MetricAffectingSpan;", "createLetterSpacingSpan", "Landroidx/compose/ui/graphics/Shadow;", "shadow", "setShadow", "(Landroid/text/Spannable;Landroidx/compose/ui/graphics/Shadow;II)V", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "drawStyle", "setDrawStyle", "(Landroid/text/Spannable;Landroidx/compose/ui/graphics/drawscope/DrawStyle;II)V", "Landroidx/compose/ui/graphics/Color;", TypedValues.Custom.S_COLOR, "setBackground-RPmYEkk", "(Landroid/text/Spannable;JII)V", "setBackground", "Landroidx/compose/ui/text/intl/LocaleList;", "localeList", "setLocaleList", "(Landroid/text/Spannable;Landroidx/compose/ui/text/intl/LocaleList;II)V", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "textGeometricTransform", "setGeometricTransform", "(Landroid/text/Spannable;Landroidx/compose/ui/text/style/TextGeometricTransform;II)V", "", "fontFeatureSettings", "setFontFeatureSettings", "(Landroid/text/Spannable;Ljava/lang/String;II)V", "fontSize", "setFontSize-KmRG4DE", "(Landroid/text/Spannable;JLandroidx/compose/ui/unit/Density;II)V", "setFontSize", "Landroidx/compose/ui/text/style/TextDecoration;", "textDecoration", "setTextDecoration", "(Landroid/text/Spannable;Landroidx/compose/ui/text/style/TextDecoration;II)V", "setColor-RPmYEkk", "setColor", "Landroidx/compose/ui/text/style/BaselineShift;", "baselineShift", "setBaselineShift-0ocSgnM", "(Landroid/text/Spannable;Landroidx/compose/ui/text/style/BaselineShift;II)V", "setBaselineShift", "Landroidx/compose/ui/graphics/Brush;", "brush", "alpha", "setBrush", "(Landroid/text/Spannable;Landroidx/compose/ui/graphics/Brush;FII)V", "hasFontAttributes", "(Landroidx/compose/ui/text/TextStyle;)Z", "spanStyle", "merge", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/SpanStyle;)Landroidx/compose/ui/text/SpanStyle;", "getNeedsLetterSpacingSpan", "(Landroidx/compose/ui/text/SpanStyle;)Z", "needsLetterSpacingSpan", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SpannableExtensions_androidKt {
    /* renamed from: createLetterSpacingSpan-eAf_CNQ, reason: not valid java name */
    private static final MetricAffectingSpan m6584createLetterSpacingSpaneAf_CNQ(long j5, Density density) {
        long jM7037getTypeUIouoOA = TextUnit.m7037getTypeUIouoOA(j5);
        TextUnitType.Companion companion = TextUnitType.INSTANCE;
        if (TextUnitType.m7066equalsimpl0(jM7037getTypeUIouoOA, companion.m7071getSpUIouoOA())) {
            return new LetterSpacingSpanPx(density.mo380toPxR2X_6o(j5));
        }
        if (TextUnitType.m7066equalsimpl0(jM7037getTypeUIouoOA, companion.m7070getEmUIouoOA())) {
            return new LetterSpacingSpanEm(TextUnit.m7038getValueimpl(j5));
        }
        return null;
    }

    public static final void flattenFontStylesAndApply(SpanStyle spanStyle, List<AnnotatedString.Range<SpanStyle>> list, o oVar) {
        if (list.size() <= 1) {
            if (list.isEmpty()) {
                return;
            }
            oVar.invoke(merge(spanStyle, list.get(0).getItem()), Integer.valueOf(list.get(0).getStart()), Integer.valueOf(list.get(0).getEnd()));
            return;
        }
        int size = list.size();
        int i = size * 2;
        int[] iArr = new int[i];
        List<AnnotatedString.Range<SpanStyle>> list2 = list;
        int size2 = list2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            AnnotatedString.Range<SpanStyle> range = list.get(i6);
            iArr[i6] = range.getStart();
            iArr[i6 + size] = range.getEnd();
        }
        if (i > 1) {
            Arrays.sort(iArr);
        }
        if (i == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        int i10 = iArr[0];
        for (int i11 = 0; i11 < i; i11++) {
            int i12 = iArr[i11];
            if (i12 != i10) {
                int size3 = list2.size();
                SpanStyle spanStyleMerge = spanStyle;
                for (int i13 = 0; i13 < size3; i13++) {
                    AnnotatedString.Range<SpanStyle> range2 = list.get(i13);
                    if (range2.getStart() != range2.getEnd() && AnnotatedStringKt.intersect(i10, i12, range2.getStart(), range2.getEnd())) {
                        spanStyleMerge = merge(spanStyleMerge, range2.getItem());
                    }
                }
                if (spanStyleMerge != null) {
                    oVar.invoke(spanStyleMerge, Integer.valueOf(i10), Integer.valueOf(i12));
                }
                i10 = i12;
            }
        }
    }

    private static final boolean getNeedsLetterSpacingSpan(SpanStyle spanStyle) {
        long jM7037getTypeUIouoOA = TextUnit.m7037getTypeUIouoOA(spanStyle.getLetterSpacing());
        TextUnitType.Companion companion = TextUnitType.INSTANCE;
        return TextUnitType.m7066equalsimpl0(jM7037getTypeUIouoOA, companion.m7071getSpUIouoOA()) || TextUnitType.m7066equalsimpl0(TextUnit.m7037getTypeUIouoOA(spanStyle.getLetterSpacing()), companion.m7070getEmUIouoOA());
    }

    private static final boolean hasFontAttributes(TextStyle textStyle) {
        return TextPaintExtensions_androidKt.hasFontAttributes(textStyle.toSpanStyle()) || textStyle.m6344getFontSynthesisZQGJjVo() != null;
    }

    private static final boolean isNonLinearFontScalingActive(Density density) {
        return ((double) density.getFontScale()) > 1.05d;
    }

    private static final SpanStyle merge(SpanStyle spanStyle, SpanStyle spanStyle2) {
        return spanStyle == null ? spanStyle2 : spanStyle.merge(spanStyle2);
    }

    /* renamed from: resolveBulletTextUnitToPx-o2QH7mI, reason: not valid java name */
    private static final float m6585resolveBulletTextUnitToPxo2QH7mI(long j5, float f, Density density) {
        if (TextUnit.m7035equalsimpl0(j5, TextUnit.INSTANCE.m7049getUnspecifiedXSAIIZE())) {
            return f;
        }
        long jM7037getTypeUIouoOA = TextUnit.m7037getTypeUIouoOA(j5);
        TextUnitType.Companion companion = TextUnitType.INSTANCE;
        if (TextUnitType.m7066equalsimpl0(jM7037getTypeUIouoOA, companion.m7071getSpUIouoOA())) {
            return density.mo380toPxR2X_6o(j5);
        }
        if (TextUnitType.m7066equalsimpl0(jM7037getTypeUIouoOA, companion.m7070getEmUIouoOA())) {
            return TextUnit.m7038getValueimpl(j5) * f;
        }
        return Float.NaN;
    }

    /* renamed from: resolveLineHeightInPx-o2QH7mI, reason: not valid java name */
    private static final float m6586resolveLineHeightInPxo2QH7mI(long j5, float f, Density density) {
        float fM7038getValueimpl;
        long jM7037getTypeUIouoOA = TextUnit.m7037getTypeUIouoOA(j5);
        TextUnitType.Companion companion = TextUnitType.INSTANCE;
        if (TextUnitType.m7066equalsimpl0(jM7037getTypeUIouoOA, companion.m7071getSpUIouoOA())) {
            if (!isNonLinearFontScalingActive(density)) {
                return density.mo380toPxR2X_6o(j5);
            }
            fM7038getValueimpl = TextUnit.m7038getValueimpl(j5) / TextUnit.m7038getValueimpl(density.mo384toSpkPz2Gy4(f));
        } else {
            if (!TextUnitType.m7066equalsimpl0(jM7037getTypeUIouoOA, companion.m7070getEmUIouoOA())) {
                return Float.NaN;
            }
            fM7038getValueimpl = TextUnit.m7038getValueimpl(j5);
        }
        return fM7038getValueimpl * f;
    }

    /* renamed from: setBackground-RPmYEkk, reason: not valid java name */
    public static final void m6587setBackgroundRPmYEkk(Spannable spannable, long j5, int i, int i6) {
        if (j5 != 16) {
            setSpan(spannable, new BackgroundColorSpan(ColorKt.m4193toArgb8_81llA(j5)), i, i6);
        }
    }

    /* renamed from: setBaselineShift-0ocSgnM, reason: not valid java name */
    private static final void m6588setBaselineShift0ocSgnM(Spannable spannable, BaselineShift baselineShift, int i, int i6) {
        if (baselineShift != null) {
            setSpan(spannable, new BaselineShiftSpan(baselineShift.m6606unboximpl()), i, i6);
        }
    }

    private static final void setBrush(Spannable spannable, Brush brush, float f, int i, int i6) {
        if (brush != null) {
            if (brush instanceof SolidColor) {
                m6589setColorRPmYEkk(spannable, ((SolidColor) brush).getValue(), i, i6);
            } else {
                if (!(brush instanceof ShaderBrush)) {
                    throw new NoWhenBranchMatchedException();
                }
                setSpan(spannable, new ShaderBrushSpan((ShaderBrush) brush, f), i, i6);
            }
        }
    }

    public static final void setBulletSpans(Spannable spannable, List<? extends AnnotatedString.Range<? extends AnnotatedString.Annotation>> list, float f, Density density, TextIndent textIndent) {
        Density density2 = density;
        float fM7038getValueimpl = 0.0f;
        if (textIndent != null) {
            long jM7037getTypeUIouoOA = TextUnit.m7037getTypeUIouoOA(textIndent.getFirstLine());
            TextUnitType.Companion companion = TextUnitType.INSTANCE;
            if (TextUnitType.m7066equalsimpl0(jM7037getTypeUIouoOA, companion.m7071getSpUIouoOA())) {
                fM7038getValueimpl = density2.mo380toPxR2X_6o(textIndent.getFirstLine());
            } else if (TextUnitType.m7066equalsimpl0(jM7037getTypeUIouoOA, companion.m7070getEmUIouoOA())) {
                fM7038getValueimpl = TextUnit.m7038getValueimpl(textIndent.getFirstLine()) * f;
            }
        }
        float f7 = fM7038getValueimpl;
        int size = list.size();
        int i = 0;
        while (i < size) {
            AnnotatedString.Range<? extends AnnotatedString.Annotation> range = list.get(i);
            AnnotatedString.Annotation item = range.getItem();
            Bullet bullet = item instanceof Bullet ? (Bullet) item : null;
            if (bullet != null) {
                float fM6585resolveBulletTextUnitToPxo2QH7mI = m6585resolveBulletTextUnitToPxo2QH7mI(bullet.getWidth(), f, density2);
                float fM6585resolveBulletTextUnitToPxo2QH7mI2 = m6585resolveBulletTextUnitToPxo2QH7mI(bullet.getHeight(), f, density2);
                float fM6585resolveBulletTextUnitToPxo2QH7mI3 = m6585resolveBulletTextUnitToPxo2QH7mI(bullet.getPadding(), f, density2);
                if (!Float.isNaN(fM6585resolveBulletTextUnitToPxo2QH7mI) && !Float.isNaN(fM6585resolveBulletTextUnitToPxo2QH7mI2) && !Float.isNaN(fM6585resolveBulletTextUnitToPxo2QH7mI3)) {
                    setSpan(spannable, new CustomBulletSpan(bullet.getShape(), fM6585resolveBulletTextUnitToPxo2QH7mI, fM6585resolveBulletTextUnitToPxo2QH7mI2, fM6585resolveBulletTextUnitToPxo2QH7mI3, bullet.getBrush(), bullet.getAlpha(), bullet.getDrawStyle(), density2, f7), range.getStart(), range.getEnd());
                }
            }
            i++;
            density2 = density;
        }
    }

    /* renamed from: setColor-RPmYEkk, reason: not valid java name */
    public static final void m6589setColorRPmYEkk(Spannable spannable, long j5, int i, int i6) {
        if (j5 != 16) {
            setSpan(spannable, new ForegroundColorSpan(ColorKt.m4193toArgb8_81llA(j5)), i, i6);
        }
    }

    private static final void setDrawStyle(Spannable spannable, DrawStyle drawStyle, int i, int i6) {
        if (drawStyle != null) {
            setSpan(spannable, new DrawStyleSpan(drawStyle), i, i6);
        }
    }

    private static final void setFontAttributes(Spannable spannable, TextStyle textStyle, List<? extends AnnotatedString.Range<? extends AnnotatedString.Annotation>> list, p pVar) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<? extends AnnotatedString.Annotation> range = list.get(i);
            if ((range.getItem() instanceof SpanStyle) && (TextPaintExtensions_androidKt.hasFontAttributes((SpanStyle) range.getItem()) || ((SpanStyle) range.getItem()).getFontSynthesis() != null)) {
                arrayList.add(range);
            }
        }
        flattenFontStylesAndApply(hasFontAttributes(textStyle) ? new SpanStyle(0L, 0L, textStyle.getFontWeight(), textStyle.m6343getFontStyle4Lr2A7w(), textStyle.m6344getFontSynthesisZQGJjVo(), textStyle.getFontFamily(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65475, (e) null) : null, arrayList, new c(1, spannable, pVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r setFontAttributes$lambda$12(Spannable spannable, p pVar, SpanStyle spanStyle, int i, int i6) {
        FontFamily fontFamily = spanStyle.getFontFamily();
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        FontStyle fontStyle = spanStyle.getFontStyle();
        FontStyle fontStyleM6419boximpl = FontStyle.m6419boximpl(fontStyle != null ? fontStyle.m6425unboximpl() : FontStyle.INSTANCE.m6429getNormal_LCdwA());
        FontSynthesis fontSynthesis = spanStyle.getFontSynthesis();
        spannable.setSpan(new TypefaceSpan((Typeface) pVar.invoke(fontFamily, fontWeight, fontStyleM6419boximpl, FontSynthesis.m6430boximpl(fontSynthesis != null ? fontSynthesis.getValue() : FontSynthesis.INSTANCE.m6439getAllGVVA2EU()))), i, i6, 33);
        return r.f317a;
    }

    private static final void setFontFeatureSettings(Spannable spannable, String str, int i, int i6) {
        if (str != null) {
            setSpan(spannable, new FontFeatureSpan(str), i, i6);
        }
    }

    /* renamed from: setFontSize-KmRG4DE, reason: not valid java name */
    public static final void m6590setFontSizeKmRG4DE(Spannable spannable, long j5, Density density, int i, int i6) {
        long jM7037getTypeUIouoOA = TextUnit.m7037getTypeUIouoOA(j5);
        TextUnitType.Companion companion = TextUnitType.INSTANCE;
        if (TextUnitType.m7066equalsimpl0(jM7037getTypeUIouoOA, companion.m7071getSpUIouoOA())) {
            setSpan(spannable, new AbsoluteSizeSpan(a.U(density.mo380toPxR2X_6o(j5)), false), i, i6);
        } else if (TextUnitType.m7066equalsimpl0(jM7037getTypeUIouoOA, companion.m7070getEmUIouoOA())) {
            setSpan(spannable, new RelativeSizeSpan(TextUnit.m7038getValueimpl(j5)), i, i6);
        }
    }

    private static final void setGeometricTransform(Spannable spannable, TextGeometricTransform textGeometricTransform, int i, int i6) {
        if (textGeometricTransform != null) {
            setSpan(spannable, new ScaleXSpan(textGeometricTransform.getScaleX()), i, i6);
            setSpan(spannable, new SkewXSpan(textGeometricTransform.getSkewX()), i, i6);
        }
    }

    /* renamed from: setLineHeight-KmRG4DE, reason: not valid java name */
    public static final void m6591setLineHeightKmRG4DE(Spannable spannable, long j5, float f, Density density, LineHeightStyle lineHeightStyle) {
        float fM6586resolveLineHeightInPxo2QH7mI = m6586resolveLineHeightInPxo2QH7mI(j5, f, density);
        if (Float.isNaN(fM6586resolveLineHeightInPxo2QH7mI)) {
            return;
        }
        setSpan(spannable, new LineHeightStyleSpan(fM6586resolveLineHeightInPxo2QH7mI, 0, (spannable.length() == 0 || m.t0(spannable) == '\n') ? spannable.length() + 1 : spannable.length(), LineHeightStyle.Trim.m6713isTrimFirstLineTopimpl$ui_text(lineHeightStyle.getTrim()), LineHeightStyle.Trim.m6714isTrimLastLineBottomimpl$ui_text(lineHeightStyle.getTrim()), lineHeightStyle.getAlignment(), LineHeightStyle.Mode.m6702equalsimpl0(lineHeightStyle.getMode(), LineHeightStyle.Mode.INSTANCE.m6707getMinimumlzQqcRY())), 0, spannable.length());
    }

    /* renamed from: setLineHeight-r9BaKPg, reason: not valid java name */
    public static final void m6592setLineHeightr9BaKPg(Spannable spannable, long j5, float f, Density density) {
        float fM6586resolveLineHeightInPxo2QH7mI = m6586resolveLineHeightInPxo2QH7mI(j5, f, density);
        if (Float.isNaN(fM6586resolveLineHeightInPxo2QH7mI)) {
            return;
        }
        setSpan(spannable, new LineHeightSpan(fM6586resolveLineHeightInPxo2QH7mI), 0, spannable.length());
    }

    public static final void setLocaleList(Spannable spannable, LocaleList localeList, int i, int i6) {
        if (localeList != null) {
            setSpan(spannable, LocaleListHelperMethods.INSTANCE.localeSpan(localeList), i, i6);
        }
    }

    private static final void setShadow(Spannable spannable, Shadow shadow, int i, int i6) {
        if (shadow != null) {
            setSpan(spannable, new ShadowSpan(ColorKt.m4193toArgb8_81llA(shadow.getColor()), Float.intBitsToFloat((int) (shadow.getOffset() >> 32)), Float.intBitsToFloat((int) (shadow.getOffset() & 4294967295L)), TextPaintExtensions_androidKt.correctBlurRadius(shadow.getBlurRadius())), i, i6);
        }
    }

    public static final void setSpan(Spannable spannable, Object obj, int i, int i6) {
        spannable.setSpan(obj, i, i6, 33);
    }

    private static final void setSpanStyle(Spannable spannable, SpanStyle spanStyle, int i, int i6, Density density) {
        m6588setBaselineShift0ocSgnM(spannable, spanStyle.getBaselineShift(), i, i6);
        m6589setColorRPmYEkk(spannable, spanStyle.m6252getColor0d7_KjU(), i, i6);
        setBrush(spannable, spanStyle.getBrush(), spanStyle.getAlpha(), i, i6);
        setTextDecoration(spannable, spanStyle.getBackground(), i, i6);
        m6590setFontSizeKmRG4DE(spannable, spanStyle.getFontSize(), density, i, i6);
        setFontFeatureSettings(spannable, spanStyle.getFontFeatureSettings(), i, i6);
        setGeometricTransform(spannable, spanStyle.getTextGeometricTransform(), i, i6);
        setLocaleList(spannable, spanStyle.getLocaleList(), i, i6);
        m6587setBackgroundRPmYEkk(spannable, spanStyle.getBackground(), i, i6);
        setShadow(spannable, spanStyle.getShadow(), i, i6);
        setDrawStyle(spannable, spanStyle.getDrawStyle(), i, i6);
    }

    public static final void setSpanStyles(Spannable spannable, TextStyle textStyle, List<? extends AnnotatedString.Range<? extends AnnotatedString.Annotation>> list, Density density, p pVar) {
        MetricAffectingSpan metricAffectingSpanM6584createLetterSpacingSpaneAf_CNQ;
        setFontAttributes(spannable, textStyle, list, pVar);
        List<? extends AnnotatedString.Range<? extends AnnotatedString.Annotation>> list2 = list;
        int size = list2.size();
        boolean z10 = false;
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<? extends AnnotatedString.Annotation> range = list.get(i);
            if (range.getItem() instanceof SpanStyle) {
                int start = range.getStart();
                int end = range.getEnd();
                if (start >= 0 && start < spannable.length() && end > start && end <= spannable.length()) {
                    setSpanStyle(spannable, (SpanStyle) range.getItem(), start, end, density);
                    if (getNeedsLetterSpacingSpan((SpanStyle) range.getItem())) {
                        z10 = true;
                    }
                }
            }
        }
        if (z10) {
            int size2 = list2.size();
            for (int i6 = 0; i6 < size2; i6++) {
                AnnotatedString.Range<? extends AnnotatedString.Annotation> range2 = list.get(i6);
                AnnotatedString.Annotation item = range2.getItem();
                if (item instanceof SpanStyle) {
                    int start2 = range2.getStart();
                    int end2 = range2.getEnd();
                    if (start2 >= 0 && start2 < spannable.length() && end2 > start2 && end2 <= spannable.length() && (metricAffectingSpanM6584createLetterSpacingSpaneAf_CNQ = m6584createLetterSpacingSpaneAf_CNQ(((SpanStyle) item).getLetterSpacing(), density)) != null) {
                        setSpan(spannable, metricAffectingSpanM6584createLetterSpacingSpaneAf_CNQ, start2, end2);
                    }
                }
            }
        }
    }

    public static final void setTextDecoration(Spannable spannable, TextDecoration textDecoration, int i, int i6) {
        if (textDecoration != null) {
            TextDecoration.Companion companion = TextDecoration.INSTANCE;
            setSpan(spannable, new TextDecorationSpan(textDecoration.contains(companion.getUnderline()), textDecoration.contains(companion.getLineThrough())), i, i6);
        }
    }

    public static final void setTextIndent(Spannable spannable, TextIndent textIndent, float f, Density density) {
        if (textIndent != null) {
            if ((TextUnit.m7035equalsimpl0(textIndent.getFirstLine(), TextUnitKt.getSp(0)) && TextUnit.m7035equalsimpl0(textIndent.getRestLine(), TextUnitKt.getSp(0))) || TextUnit.m7036getRawTypeimpl(textIndent.getFirstLine()) == 0 || TextUnit.m7036getRawTypeimpl(textIndent.getRestLine()) == 0) {
                return;
            }
            long jM7037getTypeUIouoOA = TextUnit.m7037getTypeUIouoOA(textIndent.getFirstLine());
            TextUnitType.Companion companion = TextUnitType.INSTANCE;
            float fM7038getValueimpl = 0.0f;
            float fMo380toPxR2X_6o = TextUnitType.m7066equalsimpl0(jM7037getTypeUIouoOA, companion.m7071getSpUIouoOA()) ? density.mo380toPxR2X_6o(textIndent.getFirstLine()) : TextUnitType.m7066equalsimpl0(jM7037getTypeUIouoOA, companion.m7070getEmUIouoOA()) ? TextUnit.m7038getValueimpl(textIndent.getFirstLine()) * f : 0.0f;
            long jM7037getTypeUIouoOA2 = TextUnit.m7037getTypeUIouoOA(textIndent.getRestLine());
            if (TextUnitType.m7066equalsimpl0(jM7037getTypeUIouoOA2, companion.m7071getSpUIouoOA())) {
                fM7038getValueimpl = density.mo380toPxR2X_6o(textIndent.getRestLine());
            } else if (TextUnitType.m7066equalsimpl0(jM7037getTypeUIouoOA2, companion.m7070getEmUIouoOA())) {
                fM7038getValueimpl = TextUnit.m7038getValueimpl(textIndent.getRestLine()) * f;
            }
            setSpan(spannable, new LeadingMarginSpan.Standard((int) Math.ceil(fMo380toPxR2X_6o), (int) Math.ceil(fM7038getValueimpl)), 0, spannable.length());
        }
    }
}
