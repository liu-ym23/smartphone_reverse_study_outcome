package H7;

import C7.r;
import S7.n;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.ParagraphStyle;
import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.SaversKt;
import androidx.compose.ui.text.Savers_androidKt;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.UrlAnnotation;
import androidx.compose.ui.text.VerbatimTtsAnnotation;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import java.util.List;
import kotlin.coroutines.CombinedContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f757a;

    public /* synthetic */ b(int i) {
        this.f757a = i;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        CombinedContext combinedContext;
        switch (this.f757a) {
            case 0:
                String acc = (String) obj;
                f element = (f) obj2;
                k.f(acc, "acc");
                k.f(element, "element");
                if (acc.length() == 0) {
                    return element.toString();
                }
                return acc + ", " + element;
            case 1:
                h acc2 = (h) obj;
                f element2 = (f) obj2;
                k.f(acc2, "acc");
                k.f(element2, "element");
                h hVarMinusKey = acc2.minusKey(element2.getKey());
                EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f4908a;
                if (hVarMinusKey == emptyCoroutineContext) {
                    return element2;
                }
                d dVar = d.f758a;
                e eVar = (e) hVarMinusKey.get(dVar);
                if (eVar == null) {
                    combinedContext = new CombinedContext(element2, hVarMinusKey);
                } else {
                    h hVarMinusKey2 = hVarMinusKey.minusKey(dVar);
                    if (hVarMinusKey2 == emptyCoroutineContext) {
                        return new CombinedContext(eVar, element2);
                    }
                    combinedContext = new CombinedContext(eVar, new CombinedContext(element2, hVarMinusKey2));
                }
                return combinedContext;
            case 2:
                k.f((String) obj, "<unused var>");
                k.f((float[]) obj2, "<unused var>");
                return r.f317a;
            case 3:
                return SaversKt.AnnotatedStringSaver$lambda$5((SaverScope) obj, (AnnotatedString) obj2);
            case 4:
                return SaversKt.TextDecorationSaver$lambda$27((SaverScope) obj, (TextDecoration) obj2);
            case 5:
                return SaversKt.TextGeometricTransformSaver$lambda$29((SaverScope) obj, (TextGeometricTransform) obj2);
            case 6:
                return SaversKt.TextIndentSaver$lambda$31((SaverScope) obj, (TextIndent) obj2);
            case 7:
                return SaversKt.FontWeightSaver$lambda$33((SaverScope) obj, (FontWeight) obj2);
            case 8:
                return SaversKt.LinkSaver$lambda$17((SaverScope) obj, (LinkAnnotation.Url) obj2);
            case 9:
                return SaversKt.BaselineShiftSaver$lambda$35((SaverScope) obj, (BaselineShift) obj2);
            case 10:
                return SaversKt.AnnotationRangeListSaver$lambda$8((SaverScope) obj, (List) obj2);
            case 11:
                return SaversKt.TextRangeSaver$lambda$37((SaverScope) obj, (TextRange) obj2);
            case 12:
                return SaversKt.ShadowSaver$lambda$39((SaverScope) obj, (Shadow) obj2);
            case 13:
                return SaversKt.TextUnitSaver$lambda$41((SaverScope) obj, (TextUnit) obj2);
            case 14:
                return SaversKt.OffsetSaver$lambda$43((SaverScope) obj, (Offset) obj2);
            case 15:
                return SaversKt.LocaleListSaver$lambda$46((SaverScope) obj, (LocaleList) obj2);
            case 16:
                return SaversKt.LocaleSaver$lambda$49((SaverScope) obj, (Locale) obj2);
            case 17:
                return SaversKt.LineHeightStyleSaver$lambda$51((SaverScope) obj, (LineHeightStyle) obj2);
            case 18:
                return SaversKt.AnnotationRangeSaver$lambda$11((SaverScope) obj, (AnnotatedString.Range) obj2);
            case 19:
                return SaversKt.ClickableSaver$lambda$19((SaverScope) obj, (LinkAnnotation.Clickable) obj2);
            case 20:
                return SaversKt.VerbatimTtsAnnotationSaver$lambda$13((SaverScope) obj, (VerbatimTtsAnnotation) obj2);
            case 21:
                return SaversKt.UrlAnnotationSaver$lambda$15((SaverScope) obj, (UrlAnnotation) obj2);
            case 22:
                return SaversKt.ParagraphStyleSaver$lambda$21((SaverScope) obj, (ParagraphStyle) obj2);
            case 23:
                return SaversKt.SpanStyleSaver$lambda$23((SaverScope) obj, (SpanStyle) obj2);
            case 24:
                return SaversKt.TextLinkStylesSaver$lambda$25((SaverScope) obj, (TextLinkStyles) obj2);
            case 25:
                return Savers_androidKt.PlatformParagraphStyleSaver$lambda$0((SaverScope) obj, (PlatformParagraphStyle) obj2);
            case 26:
                return Savers_androidKt.LineBreakSaver$lambda$2((SaverScope) obj, (LineBreak) obj2);
            case 27:
                return Savers_androidKt.TextMotionSaver$lambda$4((SaverScope) obj, (TextMotion) obj2);
            case 28:
                return TextFieldValue.Saver$lambda$0((SaverScope) obj, (TextFieldValue) obj2);
            default:
                k.f((String) obj, "<unused var>");
                k.f((String) obj2, "<unused var>");
                return r.f317a;
        }
    }
}
