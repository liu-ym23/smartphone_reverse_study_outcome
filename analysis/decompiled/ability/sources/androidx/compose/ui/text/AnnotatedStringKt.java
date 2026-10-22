package androidx.compose.ui.text;

import D7.p;
import D7.v;
import H4.o;
import N9.j;
import S7.k;
import S7.n;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.exifinterface.media.ExifInterface;
import g1.AbstractC1451a;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;

@Metadata(d1 = {"\u0000~\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0013\u001aG\u0010\u0007\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0001\u0018\u00010\u00002\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u00002\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00010\u0000H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a'\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00010\u0000*\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a1\u0010\u0010\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0001\u0018\u00010\u0000*\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001aK\u0010\u0015\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0001\u0018\u00010\u0000*\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a#\u0010\u0017\u001a\u00020\t*\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001aJ\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0004\b\u0000\u0010\u0019*\u00020\t2\u0006\u0010\n\u001a\u00020\u00042 \b\u0004\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0001\u0012\u0004\u0012\u00028\u00000\u001aH\u0080\b¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001b\u0010 \u001a\u00020\t*\u00020\t2\b\b\u0002\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!\u001a\u001b\u0010\"\u001a\u00020\t*\u00020\t2\b\b\u0002\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\"\u0010!\u001a\u001b\u0010#\u001a\u00020\t*\u00020\t2\b\b\u0002\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b#\u0010!\u001a\u001b\u0010$\u001a\u00020\t*\u00020\t2\b\b\u0002\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b$\u0010!\u001a:\u0010)\u001a\u00028\u0000\"\b\b\u0000\u0010&*\u00020%*\u00020'2\u0006\u0010(\u001a\u00020\u00022\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00028\u00000\u0012H\u0086\b¢\u0006\u0004\b)\u0010*\u001a<\u0010)\u001a\u00028\u0000\"\b\b\u0000\u0010&*\u00020%*\u00020'2\u0006\u0010(\u001a\u00020\u00042\u0014\b\u0004\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00028\u00000\u0012H\u0086\b¢\u0006\u0004\b)\u0010+\u001aD\u0010/\u001a\u00028\u0000\"\b\b\u0000\u0010&*\u00020%*\u00020'2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,2\u0014\b\u0004\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00028\u00000\u0012H\u0086\b¢\u0006\u0004\b/\u00100\u001a<\u0010/\u001a\u00028\u0000\"\b\b\u0000\u0010&*\u00020%*\u00020'2\u0006\u00102\u001a\u0002012\u0014\b\u0004\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00028\u00000\u0012H\u0086\b¢\u0006\u0004\b/\u00103\u001a<\u0010/\u001a\u00028\u0000\"\b\b\u0000\u0010&*\u00020%*\u00020'2\u0006\u00105\u001a\u0002042\u0014\b\u0004\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00028\u00000\u0012H\u0087\b¢\u0006\u0004\b/\u00106\u001a:\u00109\u001a\u00028\u0000\"\b\b\u0000\u0010&*\u00020%*\u00020'2\u0006\u00108\u001a\u0002072\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00028\u00000\u0012H\u0086\b¢\u0006\u0004\b9\u0010:\u001aK\u0010<\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0018\u00010\u0000\"\u0004\b\u0000\u0010\u00192\u0016\u0010;\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0001\u0018\u00010\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002¢\u0006\u0004\b<\u0010=\u001a)\u0010A\u001a\u00020\t2\u0006\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020\u00022\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\bA\u0010B\u001a\u001d\u0010A\u001a\u00020\t2\u0006\u0010>\u001a\u00020,2\u0006\u0010@\u001a\u00020\u0004¢\u0006\u0004\bA\u0010C\u001a$\u0010F\u001a\u00020\t2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020D0\u0012H\u0086\b¢\u0006\u0004\bF\u0010G\u001a/\u0010L\u001a\u00020\u00132\u0006\u0010H\u001a\u00020\r2\u0006\u0010I\u001a\u00020\r2\u0006\u0010J\u001a\u00020\r2\u0006\u0010K\u001a\u00020\rH\u0000¢\u0006\u0004\bL\u0010M\u001a/\u0010R\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\r2\u0006\u0010O\u001a\u00020\r2\u0006\u0010P\u001a\u00020\r2\u0006\u0010Q\u001a\u00020\rH\u0000¢\u0006\u0004\bR\u0010M\u001a\u000f\u0010S\u001a\u00020\tH\u0000¢\u0006\u0004\bS\u0010T\"\u0014\u0010U\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006W"}, d2 = {"", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/SpanStyle;", "spanStyles", "Landroidx/compose/ui/text/ParagraphStyle;", "paragraphStyles", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "constructAnnotationsFromSpansAndParagraphs", "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "Landroidx/compose/ui/text/AnnotatedString;", "defaultParagraphStyle", "normalizedParagraphStyles", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/ParagraphStyle;)Ljava/util/List;", "", "start", "end", "getLocalParagraphStyles", "(Landroidx/compose/ui/text/AnnotatedString;II)Ljava/util/List;", "Lkotlin/Function1;", "", "predicate", "getLocalAnnotations", "(Landroidx/compose/ui/text/AnnotatedString;IILS7/k;)Ljava/util/List;", "substringWithoutParagraphStyles", "(Landroidx/compose/ui/text/AnnotatedString;II)Landroidx/compose/ui/text/AnnotatedString;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "block", "mapEachParagraphStyle", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/ParagraphStyle;LS7/n;)Ljava/util/List;", "Landroidx/compose/ui/text/intl/LocaleList;", "localeList", "toUpperCase", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/intl/LocaleList;)Landroidx/compose/ui/text/AnnotatedString;", "toLowerCase", "capitalize", "decapitalize", "", "R", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "style", "withStyle", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/SpanStyle;LS7/k;)Ljava/lang/Object;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/ParagraphStyle;LS7/k;)Ljava/lang/Object;", "", "tag", "annotation", "withAnnotation", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Ljava/lang/String;Ljava/lang/String;LS7/k;)Ljava/lang/Object;", "Landroidx/compose/ui/text/TtsAnnotation;", "ttsAnnotation", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/TtsAnnotation;LS7/k;)Ljava/lang/Object;", "Landroidx/compose/ui/text/UrlAnnotation;", "urlAnnotation", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/UrlAnnotation;LS7/k;)Ljava/lang/Object;", "Landroidx/compose/ui/text/LinkAnnotation;", "link", "withLink", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/LinkAnnotation;LS7/k;)Ljava/lang/Object;", "ranges", "filterRanges", "(Ljava/util/List;II)Ljava/util/List;", "text", "spanStyle", "paragraphStyle", "AnnotatedString", "(Ljava/lang/String;Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/ParagraphStyle;)Landroidx/compose/ui/text/AnnotatedString;", "(Ljava/lang/String;Landroidx/compose/ui/text/ParagraphStyle;)Landroidx/compose/ui/text/AnnotatedString;", "LC7/r;", "builder", "buildAnnotatedString", "(LS7/k;)Landroidx/compose/ui/text/AnnotatedString;", "baseStart", "baseEnd", "targetStart", "targetEnd", "contains", "(IIII)Z", "lStart", "lEnd", "rStart", "rEnd", "intersect", "emptyAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "EmptyAnnotatedString", "Landroidx/compose/ui/text/AnnotatedString;", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AnnotatedStringKt {
    private static final AnnotatedString EmptyAnnotatedString = new AnnotatedString("", null, 2, null);

    public static final AnnotatedString AnnotatedString(String str, SpanStyle spanStyle, ParagraphStyle paragraphStyle) {
        return new AnnotatedString(str, o.M(new AnnotatedString.Range(spanStyle, 0, str.length())), paragraphStyle == null ? EmptyList.f4893a : o.M(new AnnotatedString.Range(paragraphStyle, 0, str.length())));
    }

    public static /* synthetic */ AnnotatedString AnnotatedString$default(String str, SpanStyle spanStyle, ParagraphStyle paragraphStyle, int i, Object obj) {
        if ((i & 4) != 0) {
            paragraphStyle = null;
        }
        return AnnotatedString(str, spanStyle, paragraphStyle);
    }

    public static final AnnotatedString buildAnnotatedString(k kVar) {
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
        kVar.invoke(builder);
        return builder.toAnnotatedString();
    }

    public static final AnnotatedString capitalize(AnnotatedString annotatedString, LocaleList localeList) {
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new a(1, localeList));
    }

    public static /* synthetic */ AnnotatedString capitalize$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.INSTANCE.getCurrent();
        }
        return capitalize(annotatedString, localeList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String capitalize$lambda$14(LocaleList localeList, String str, int i, int i6) {
        if (i == 0) {
            String strSubstring = str.substring(i, i6);
            kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
            return StringKt.capitalize(strSubstring, localeList);
        }
        String strSubstring2 = str.substring(i, i6);
        kotlin.jvm.internal.k.e(strSubstring2, "substring(...)");
        return strSubstring2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<AnnotatedString.Range<? extends AnnotatedString.Annotation>> constructAnnotationsFromSpansAndParagraphs(List<AnnotatedString.Range<SpanStyle>> list, List<AnnotatedString.Range<ParagraphStyle>> list2) {
        if (list.isEmpty() && list2.isEmpty()) {
            return null;
        }
        if (list2.isEmpty()) {
            return list;
        }
        if (list.isEmpty()) {
            return list2;
        }
        ArrayList arrayList = new ArrayList(list2.size() + list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(list.get(i));
        }
        int size2 = list2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            arrayList.add(list2.get(i6));
        }
        return arrayList;
    }

    public static final boolean contains(int i, int i6, int i10, int i11) {
        if (i <= i10 && i11 <= i6) {
            if (i6 == i11) {
                if ((i10 == i11) == (i == i6)) {
                }
            }
            return true;
        }
        return false;
    }

    public static final AnnotatedString decapitalize(AnnotatedString annotatedString, LocaleList localeList) {
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new a(0, localeList));
    }

    public static /* synthetic */ AnnotatedString decapitalize$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.INSTANCE.getCurrent();
        }
        return decapitalize(annotatedString, localeList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String decapitalize$lambda$15(LocaleList localeList, String str, int i, int i6) {
        if (i == 0) {
            String strSubstring = str.substring(i, i6);
            kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
            return StringKt.decapitalize(strSubstring, localeList);
        }
        String strSubstring2 = str.substring(i, i6);
        kotlin.jvm.internal.k.e(strSubstring2, "substring(...)");
        return strSubstring2;
    }

    public static final AnnotatedString emptyAnnotatedString() {
        return EmptyAnnotatedString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> List<AnnotatedString.Range<T>> filterRanges(List<? extends AnnotatedString.Range<? extends T>> list, int i, int i6) {
        if (!(i <= i6)) {
            InlineClassHelperKt.throwIllegalArgumentException("start (" + i + ") should be less than or equal to end (" + i6 + ')');
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            AnnotatedString.Range<? extends T> range = list.get(i10);
            if (intersect(i, i6, range.getStart(), range.getEnd())) {
                arrayList.add(new AnnotatedString.Range(range.getItem(), Math.max(i, range.getStart()) - i, Math.min(i6, range.getEnd()) - i, range.getTag()));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    private static final List<AnnotatedString.Range<? extends AnnotatedString.Annotation>> getLocalAnnotations(AnnotatedString annotatedString, int i, int i6, k kVar) {
        List<AnnotatedString.Range<? extends AnnotatedString.Annotation>> annotations$ui_text;
        if (i == i6 || (annotations$ui_text = annotatedString.getAnnotations$ui_text()) == null) {
            return null;
        }
        if (i != 0 || i6 < annotatedString.getText().length()) {
            ArrayList arrayList = new ArrayList(annotations$ui_text.size());
            int size = annotations$ui_text.size();
            for (int i10 = 0; i10 < size; i10++) {
                AnnotatedString.Range<? extends AnnotatedString.Annotation> range = annotations$ui_text.get(i10);
                if ((kVar != null ? ((Boolean) kVar.invoke(range.getItem())).booleanValue() : true) && intersect(i, i6, range.getStart(), range.getEnd())) {
                    arrayList.add(new AnnotatedString.Range(range.getItem(), AbstractC1451a.u(range.getStart(), i, i6) - i, AbstractC1451a.u(range.getEnd(), i, i6) - i, range.getTag()));
                }
            }
            return arrayList;
        }
        if (kVar == null) {
            return annotations$ui_text;
        }
        ArrayList arrayList2 = new ArrayList(annotations$ui_text.size());
        int size2 = annotations$ui_text.size();
        for (int i11 = 0; i11 < size2; i11++) {
            AnnotatedString.Range<? extends AnnotatedString.Annotation> range2 = annotations$ui_text.get(i11);
            if (((Boolean) kVar.invoke(range2.getItem())).booleanValue()) {
                arrayList2.add(range2);
            }
        }
        return arrayList2;
    }

    public static /* synthetic */ List getLocalAnnotations$default(AnnotatedString annotatedString, int i, int i6, k kVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            kVar = null;
        }
        return getLocalAnnotations(annotatedString, i, i6, kVar);
    }

    private static final List<AnnotatedString.Range<ParagraphStyle>> getLocalParagraphStyles(AnnotatedString annotatedString, int i, int i6) {
        List<AnnotatedString.Range<ParagraphStyle>> paragraphStylesOrNull$ui_text;
        if (i == i6 || (paragraphStylesOrNull$ui_text = annotatedString.getParagraphStylesOrNull$ui_text()) == null) {
            return null;
        }
        if (i == 0 && i6 >= annotatedString.getText().length()) {
            return paragraphStylesOrNull$ui_text;
        }
        ArrayList arrayList = new ArrayList(paragraphStylesOrNull$ui_text.size());
        int size = paragraphStylesOrNull$ui_text.size();
        for (int i10 = 0; i10 < size; i10++) {
            AnnotatedString.Range<ParagraphStyle> range = paragraphStylesOrNull$ui_text.get(i10);
            if (intersect(i, i6, range.getStart(), range.getEnd())) {
                ParagraphStyle item = range.getItem();
                int start = range.getStart();
                if (start < i) {
                    start = i;
                }
                if (start > i6) {
                    start = i6;
                }
                int i11 = start - i;
                int end = range.getEnd();
                if (end < i) {
                    end = i;
                }
                if (end > i6) {
                    end = i6;
                }
                arrayList.add(new AnnotatedString.Range(item, i11, end - i));
            }
        }
        return arrayList;
    }

    public static final boolean intersect(int i, int i6, int i10, int i11) {
        return ((i < i11) & (i10 < i6)) | (((i == i6) | (i10 == i11)) & (i == i10));
    }

    public static final <T> List<T> mapEachParagraphStyle(AnnotatedString annotatedString, ParagraphStyle paragraphStyle, n nVar) {
        List<AnnotatedString.Range<ParagraphStyle>> listNormalizedParagraphStyles = normalizedParagraphStyles(annotatedString, paragraphStyle);
        ArrayList arrayList = new ArrayList(listNormalizedParagraphStyles.size());
        int size = listNormalizedParagraphStyles.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<ParagraphStyle> range = listNormalizedParagraphStyles.get(i);
            arrayList.add(nVar.invoke(substringWithoutParagraphStyles(annotatedString, range.getStart(), range.getEnd()), range));
        }
        return arrayList;
    }

    public static final List<AnnotatedString.Range<ParagraphStyle>> normalizedParagraphStyles(AnnotatedString annotatedString, ParagraphStyle paragraphStyle) {
        List listZ0;
        List<AnnotatedString.Range<ParagraphStyle>> paragraphStylesOrNull$ui_text = annotatedString.getParagraphStylesOrNull$ui_text();
        if (paragraphStylesOrNull$ui_text == null || (listZ0 = v.Z0(paragraphStylesOrNull$ui_text, new Comparator() { // from class: androidx.compose.ui.text.AnnotatedStringKt$normalizedParagraphStyles$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t9, T t10) {
                return j.m(Integer.valueOf(((AnnotatedString.Range) t9).getStart()), Integer.valueOf(((AnnotatedString.Range) t10).getStart()));
            }
        })) == null) {
            listZ0 = EmptyList.f4893a;
        }
        ArrayList arrayList = new ArrayList();
        p pVar = new p();
        int size = listZ0.size();
        int end = 0;
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range range = (AnnotatedString.Range) listZ0.get(i);
            AnnotatedString.Range rangeCopy$default = AnnotatedString.Range.copy$default(range, paragraphStyle.merge((ParagraphStyle) range.getItem()), 0, 0, null, 14, null);
            while (end < rangeCopy$default.getStart() && !pVar.isEmpty()) {
                AnnotatedString.Range range2 = (AnnotatedString.Range) pVar.last();
                if (rangeCopy$default.getStart() < range2.getEnd()) {
                    arrayList.add(new AnnotatedString.Range(range2.getItem(), end, rangeCopy$default.getStart()));
                    end = rangeCopy$default.getStart();
                } else {
                    arrayList.add(new AnnotatedString.Range(range2.getItem(), end, range2.getEnd()));
                    end = range2.getEnd();
                    while (!pVar.isEmpty() && end == ((AnnotatedString.Range) pVar.last()).getEnd()) {
                        pVar.removeLast();
                    }
                }
            }
            if (end < rangeCopy$default.getStart()) {
                arrayList.add(new AnnotatedString.Range(paragraphStyle, end, rangeCopy$default.getStart()));
                end = rangeCopy$default.getStart();
            }
            AnnotatedString.Range range3 = (AnnotatedString.Range) (pVar.isEmpty() ? null : pVar.b[pVar.j(o.H(pVar) + pVar.f403a)]);
            if (range3 == null) {
                pVar.addLast(new AnnotatedString.Range(rangeCopy$default.getItem(), rangeCopy$default.getStart(), rangeCopy$default.getEnd()));
            } else if (range3.getStart() == rangeCopy$default.getStart() && range3.getEnd() == rangeCopy$default.getEnd()) {
                pVar.removeLast();
                pVar.addLast(new AnnotatedString.Range(((ParagraphStyle) range3.getItem()).merge((ParagraphStyle) rangeCopy$default.getItem()), rangeCopy$default.getStart(), rangeCopy$default.getEnd()));
            } else if (range3.getStart() == range3.getEnd()) {
                arrayList.add(new AnnotatedString.Range(range3.getItem(), range3.getStart(), range3.getEnd()));
                pVar.removeLast();
                pVar.addLast(new AnnotatedString.Range(rangeCopy$default.getItem(), rangeCopy$default.getStart(), rangeCopy$default.getEnd()));
            } else {
                if (range3.getEnd() < rangeCopy$default.getEnd()) {
                    throw new IllegalArgumentException();
                }
                pVar.addLast(new AnnotatedString.Range(((ParagraphStyle) range3.getItem()).merge((ParagraphStyle) rangeCopy$default.getItem()), rangeCopy$default.getStart(), rangeCopy$default.getEnd()));
            }
        }
        while (end <= annotatedString.getText().length() && !pVar.isEmpty()) {
            AnnotatedString.Range range4 = (AnnotatedString.Range) pVar.last();
            arrayList.add(new AnnotatedString.Range(range4.getItem(), end, range4.getEnd()));
            end = range4.getEnd();
            while (!pVar.isEmpty() && end == ((AnnotatedString.Range) pVar.last()).getEnd()) {
                pVar.removeLast();
            }
        }
        if (end < annotatedString.getText().length()) {
            arrayList.add(new AnnotatedString.Range(paragraphStyle, end, annotatedString.getText().length()));
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new AnnotatedString.Range(paragraphStyle, 0, 0));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString substringWithoutParagraphStyles(AnnotatedString annotatedString, int i, int i6) {
        String strSubstring;
        if (i != i6) {
            strSubstring = annotatedString.getText().substring(i, i6);
            kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
        } else {
            strSubstring = "";
        }
        List localAnnotations = getLocalAnnotations(annotatedString, i, i6, new android.view.p(5));
        if (localAnnotations == null) {
            localAnnotations = EmptyList.f4893a;
        }
        return new AnnotatedString(strSubstring, (List<? extends AnnotatedString.Range<? extends AnnotatedString.Annotation>>) localAnnotations);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean substringWithoutParagraphStyles$lambda$10(AnnotatedString.Annotation annotation) {
        return !(annotation instanceof ParagraphStyle);
    }

    public static final AnnotatedString toLowerCase(AnnotatedString annotatedString, LocaleList localeList) {
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new a(3, localeList));
    }

    public static /* synthetic */ AnnotatedString toLowerCase$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.INSTANCE.getCurrent();
        }
        return toLowerCase(annotatedString, localeList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toLowerCase$lambda$13(LocaleList localeList, String str, int i, int i6) {
        String strSubstring = str.substring(i, i6);
        kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
        return StringKt.toLowerCase(strSubstring, localeList);
    }

    public static final AnnotatedString toUpperCase(AnnotatedString annotatedString, LocaleList localeList) {
        return JvmAnnotatedString_jvmKt.transform(annotatedString, new a(2, localeList));
    }

    public static /* synthetic */ AnnotatedString toUpperCase$default(AnnotatedString annotatedString, LocaleList localeList, int i, Object obj) {
        if ((i & 1) != 0) {
            localeList = LocaleList.INSTANCE.getCurrent();
        }
        return toUpperCase(annotatedString, localeList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toUpperCase$lambda$12(LocaleList localeList, String str, int i, int i6) {
        String strSubstring = str.substring(i, i6);
        kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
        return StringKt.toUpperCase(strSubstring, localeList);
    }

    public static final <R> R withAnnotation(AnnotatedString.Builder builder, String str, String str2, k kVar) {
        int iPushStringAnnotation = builder.pushStringAnnotation(str, str2);
        try {
            return (R) kVar.invoke(builder);
        } finally {
            builder.pop(iPushStringAnnotation);
        }
    }

    public static final <R> R withLink(AnnotatedString.Builder builder, LinkAnnotation linkAnnotation, k kVar) {
        int iPushLink = builder.pushLink(linkAnnotation);
        try {
            return (R) kVar.invoke(builder);
        } finally {
            builder.pop(iPushLink);
        }
    }

    public static final <R> R withStyle(AnnotatedString.Builder builder, SpanStyle spanStyle, k kVar) {
        int iPushStyle = builder.pushStyle(spanStyle);
        try {
            return (R) kVar.invoke(builder);
        } finally {
            builder.pop(iPushStyle);
        }
    }

    public static final <R> R withAnnotation(AnnotatedString.Builder builder, TtsAnnotation ttsAnnotation, k kVar) {
        int iPushTtsAnnotation = builder.pushTtsAnnotation(ttsAnnotation);
        try {
            return (R) kVar.invoke(builder);
        } finally {
            builder.pop(iPushTtsAnnotation);
        }
    }

    public static final <R> R withStyle(AnnotatedString.Builder builder, ParagraphStyle paragraphStyle, k kVar) {
        int iPushStyle = builder.pushStyle(paragraphStyle);
        try {
            return (R) kVar.invoke(builder);
        } finally {
            builder.pop(iPushStyle);
        }
    }

    public static final AnnotatedString AnnotatedString(String str, ParagraphStyle paragraphStyle) {
        return new AnnotatedString(str, EmptyList.f4893a, o.M(new AnnotatedString.Range(paragraphStyle, 0, str.length())));
    }

    @C7.c
    @ExperimentalTextApi
    public static final <R> R withAnnotation(AnnotatedString.Builder builder, UrlAnnotation urlAnnotation, k kVar) {
        int iPushUrlAnnotation = builder.pushUrlAnnotation(urlAnnotation);
        try {
            return (R) kVar.invoke(builder);
        } finally {
            builder.pop(iPushUrlAnnotation);
        }
    }
}
