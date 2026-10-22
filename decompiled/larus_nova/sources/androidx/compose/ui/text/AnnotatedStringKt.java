package androidx.compose.ui.text;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\r\u001a@\u0010\u0000\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0018\u00010\u00012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00020\u0001H\u0002\u001a \u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00020\u0001*\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0000\u001a*\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0002\u0018\u00010\u0001*\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002\u001aD\u0010\u000f\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u0018\u00010\u0001*\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002\u001a\u001c\u0010\u0013\u001a\u00020\t*\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002\u001aa\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0001\"\u0004\b\u0000\u0010\u0015*\u00020\t2\u0006\u0010\n\u001a\u00020\u00072>\b\u0004\u0010\u0016\u001a8\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0002¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002H\u00150\u0017H\u0080\b\u001a\u0014\u0010\u001c\u001a\u00020\t*\u00020\t2\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u001a\u0014\u0010\u001f\u001a\u00020\t*\u00020\t2\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u001a\u0014\u0010 \u001a\u00020\t*\u00020\t2\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u001a\u0014\u0010!\u001a\u00020\t*\u00020\t2\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u001a=\u0010\"\u001a\u0002H#\"\b\b\u0000\u0010#*\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u00052\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u0002H#0\u0011¢\u0006\u0002\b'H\u0086\b¢\u0006\u0002\u0010(\u001a?\u0010\"\u001a\u0002H#\"\b\b\u0000\u0010#*\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u00072\u0019\b\u0004\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u0002H#0\u0011¢\u0006\u0002\b'H\u0086\b¢\u0006\u0002\u0010)\u001aG\u0010*\u001a\u0002H#\"\b\b\u0000\u0010#*\u00020$*\u00020%2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\u0019\b\u0004\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u0002H#0\u0011¢\u0006\u0002\b'H\u0086\b¢\u0006\u0002\u0010.\u001a?\u0010*\u001a\u0002H#\"\b\b\u0000\u0010#*\u00020$*\u00020%2\u0006\u0010/\u001a\u0002002\u0019\b\u0004\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u0002H#0\u0011¢\u0006\u0002\b'H\u0086\b¢\u0006\u0002\u00101\u001a?\u0010*\u001a\u0002H#\"\b\b\u0000\u0010#*\u00020$*\u00020%2\u0006\u00102\u001a\u0002032\u0019\b\u0004\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u0002H#0\u0011¢\u0006\u0002\b'H\u0087\b¢\u0006\u0002\u00104\u001a=\u00105\u001a\u0002H#\"\b\b\u0000\u0010#*\u00020$*\u00020%2\u0006\u00106\u001a\u0002072\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u0002H#0\u0011¢\u0006\u0002\b'H\u0086\b¢\u0006\u0002\u00108\u001aD\u00109\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00152\u0016\u0010:\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00150\u0002\u0018\u00010\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002\u001a\"\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020,2\u0006\u0010=\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u001a\u0016\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020,2\u0006\u0010\u001b\u001a\u00020\u0007\u001a\"\u0010>\u001a\u00020\t2\u0017\u0010?\u001a\u0013\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020@0\u0011¢\u0006\u0002\b'H\u0086\b\u001a(\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020\r2\u0006\u0010C\u001a\u00020\r2\u0006\u0010D\u001a\u00020\r2\u0006\u0010E\u001a\u00020\rH\u0000\u001a(\u0010F\u001a\u00020\u00122\u0006\u0010G\u001a\u00020\r2\u0006\u0010H\u001a\u00020\r2\u0006\u0010I\u001a\u00020\r2\u0006\u0010J\u001a\u00020\rH\u0000\u001a\b\u0010L\u001a\u00020\tH\u0000\"\u000e\u0010K\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"constructAnnotationsFromSpansAndParagraphs", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "spanStyles", "Landroidx/compose/ui/text/SpanStyle;", "paragraphStyles", "Landroidx/compose/ui/text/ParagraphStyle;", "normalizedParagraphStyles", "Landroidx/compose/ui/text/AnnotatedString;", "defaultParagraphStyle", "getLocalParagraphStyles", "start", "", "end", "getLocalAnnotations", "predicate", "Lkotlin/Function1;", "", "substringWithoutParagraphStyles", "mapEachParagraphStyle", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "annotatedString", "paragraphStyle", "toUpperCase", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "toLowerCase", "capitalize", "decapitalize", "withStyle", "R", "", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "style", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/SpanStyle;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/ParagraphStyle;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withAnnotation", "tag", "", "annotation", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ttsAnnotation", "Landroidx/compose/ui/text/TtsAnnotation;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/TtsAnnotation;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "urlAnnotation", "Landroidx/compose/ui/text/UrlAnnotation;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/UrlAnnotation;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withLink", "link", "Landroidx/compose/ui/text/LinkAnnotation;", "(Landroidx/compose/ui/text/AnnotatedString$Builder;Landroidx/compose/ui/text/LinkAnnotation;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "filterRanges", "ranges", "AnnotatedString", "text", "spanStyle", "buildAnnotatedString", "builder", "", "contains", "baseStart", "baseEnd", "targetStart", "targetEnd", "intersect", "lStart", "lEnd", "rStart", "rEnd", "EmptyAnnotatedString", "emptyAnnotatedString", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AnnotatedStringKt {
    private static final AnnotatedString EmptyAnnotatedString = null;

    public static /* synthetic */ String a(LocaleList r100, String r101, int r102, int r103) {
        return toUpperCase$lambda$12(r100, r101, r102, r103);
    }

    public static /* synthetic */ String b(LocaleList r100, String r101, int r102, int r103) {
        return capitalize$lambda$14(r100, r101, r102, r103);
    }

    public static /* synthetic */ boolean c(AnnotatedString.Annotation r100) {
        return substringWithoutParagraphStyles$lambda$10(r100);
    }

    public static final boolean contains(int r100, int r101, int r102, int r103) {
        if (r100 > r102) goto L16;
        if (r103 <= r101) goto L6;
        return false;
    L6:
        if (r101 != r103) goto L14;
        if (r102 != r103) goto L9;
        boolean r104 = true;
    L10:
        if (r100 != r101) goto L12;
        boolean r105 = true;
    L13:
        if (r104 == r105) goto L14;
        return false;
    L12:
        r105 = false;
        goto L13
    L9:
        r104 = false;
    L14:
        return true;
    L16:
        return false;
    }

    public static /* synthetic */ String d(LocaleList r100, String r101, int r102, int r103) {
        return toLowerCase$lambda$13(r100, r101, r102, r103);
    }

    public static /* synthetic */ String e(LocaleList r100, String r101, int r102, int r103) {
        return decapitalize$lambda$15(r100, r101, r102, r103);
    }

    public static final boolean intersect(int r100, int r101, int r102, int r103) {
        boolean r104 = true;
        if (r100 != r101) goto L5;
        boolean r105 = true;
    L6:
        if (r102 != r103) goto L8;
        boolean r106 = true;
    L9:
        boolean r107 = r105 | r106;
        if (r100 != r102) goto L12;
        boolean r108 = true;
    L13:
        boolean r109 = r107 & r108;
        if (r100 >= r103) goto L16;
        boolean r110 = true;
    L17:
        if (r102 < r101) goto L21;
        r104 = false;
    L21:
        return (r110 & r104) | r109;
    L16:
        r110 = false;
        goto L17
    L12:
        r108 = false;
        goto L13
    L8:
        r106 = false;
        goto L9
    L5:
        r105 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        String r100 = "";
        EmptyAnnotatedString = new AnnotatedString(r100, null, 2, 0 == true ? 1 : 0);
    }

    public static final AnnotatedString emptyAnnotatedString() {
        return EmptyAnnotatedString;
    }

    public static final AnnotatedString buildAnnotatedString(Function1<? super AnnotatedString.Builder, Unit> r100) {
        int r101 = 0;
        AnnotatedString.Builder r102 = new AnnotatedString.Builder(r101, 1, null);
        r100.invoke(r102);
        return r102.toAnnotatedString();
    }

    private static final boolean substringWithoutParagraphStyles$lambda$10(AnnotatedString.Annotation r100) {
        return !(r100 instanceof ParagraphStyle);
    }

    public static final AnnotatedString AnnotatedString(String r100, ParagraphStyle r101) {
        return new AnnotatedString(r100, CollectionsKt.emptyList(), CollectionsKt.listOf(new AnnotatedString.Range(r101, 0, r100.length())));
    }

    public static final /* synthetic */ List access$constructAnnotationsFromSpansAndParagraphs(List r100, List r101) {
        return constructAnnotationsFromSpansAndParagraphs(r100, r101);
    }

    public static final AnnotatedString capitalize(AnnotatedString r100, final LocaleList r101) {
        return JvmAnnotatedString_jvmKt.transform(r100, new c(r101));
    }

    private static final List<AnnotatedString.Range<? extends AnnotatedString.Annotation>> constructAnnotationsFromSpansAndParagraphs(List<AnnotatedString.Range<SpanStyle>> r100, List<AnnotatedString.Range<ParagraphStyle>> r101) {
        if (r100.isEmpty() == false) goto L8;
        if (r101.isEmpty() == false) goto L8;
        return null;
    L8:
        if (r101.isEmpty() == false) goto L11;
        return r100;
    L11:
        if (r100.isEmpty() == true) goto L24;
        ArrayList r102 = new ArrayList(r100.size() + r101.size());
        int r103 = r100.size();
        int r104 = 0;
        int r105 = 0;
    L14:
        if (r105 >= r103) goto L16;
        r102.add((AnnotatedString.Range) ListProtector.get(r100, r105));
        r105 = r105 + 1;
        goto L14
    L16:
        int r106 = r101.size();
    L17:
        if (r104 >= r106) goto L20;
        r102.add((AnnotatedString.Range) ListProtector.get(r101, r104));
        r104 = r104 + 1;
        goto L17
    L20:
        return r102;
    L24:
        return r101;
    }

    public static final AnnotatedString decapitalize(AnnotatedString r100, final LocaleList r101) {
        return JvmAnnotatedString_jvmKt.transform(r100, new d(r101));
    }

    public static final List<AnnotatedString.Range<ParagraphStyle>> normalizedParagraphStyles(AnnotatedString r110, ParagraphStyle r111) {
        List<AnnotatedString.Range<ParagraphStyle>> r100 = r110.getParagraphStylesOrNull$ui_text();
        if (r100 == null) goto L6;
        List r101 = CollectionsKt.sortedWith(r100, new AnnotatedStringKt$normalizedParagraphStyles$$inlined$sortedBy$1());
        if (r101 == null) goto L6;
    L7:
        ArrayList r102 = new ArrayList();
        ArrayDeque r103 = new ArrayDeque();
        int r104 = r101.size();
        int r105 = 0;
        int r106 = 0;
    L8:
        if (r105 >= r104) goto L44;
        AnnotatedString.Range r107 = (AnnotatedString.Range) ListProtector.get(r101, r105);
        AnnotatedString.Range r108 = AnnotatedString.Range.copy$default(r107, r111.merge((ParagraphStyle) r107.getItem()), 0, 0, null, 14, null);
    L11:
        if (r106 >= r108.getStart()) goto L24;
        if ((!r103.isEmpty()) == false) goto L24;
        AnnotatedString.Range r109 = (AnnotatedString.Range) r103.last();
        if (r108.getStart() < r109.getEnd()) goto L16;
        r102.add(new AnnotatedString.Range(r109.getItem(), r106, r109.getEnd()));
        r106 = r109.getEnd();
    L19:
        if ((!r103.isEmpty()) == false) goto L11;
        if (r106 != ((AnnotatedString.Range) r103.last()).getEnd()) goto L11;
        r103.removeLast();
        goto L19
    L16:
        r102.add(new AnnotatedString.Range(r109.getItem(), r106, r108.getStart()));
        r106 = r108.getStart();
    L24:
        if (r106 >= r108.getStart()) goto L26;
        r102.add(new AnnotatedString.Range(r111, r106, r108.getStart()));
        r106 = r108.getStart();
    L26:
        AnnotatedString.Range r112 = (AnnotatedString.Range) r103.lastOrNull();
        if (r112 != null) goto L29;
        r103.add(new AnnotatedString.Range(r108.getItem(), r108.getStart(), r108.getEnd()));
    L42:
        r105 = r105 + 1;
        goto L8
    L29:
        if (r112.getStart() != r108.getStart()) goto L34;
        if (r112.getEnd() != r108.getEnd()) goto L34;
        r103.removeLast();
        r103.add(new AnnotatedString.Range(((ParagraphStyle) r112.getItem()).merge((ParagraphStyle) r108.getItem()), r108.getStart(), r108.getEnd()));
    L34:
        if (r112.getStart() != r112.getEnd()) goto L37;
        r102.add(new AnnotatedString.Range(r112.getItem(), r112.getStart(), r112.getEnd()));
        r103.removeLast();
        r103.add(new AnnotatedString.Range(r108.getItem(), r108.getStart(), r108.getEnd()));
        goto L42
    L37:
        if (r112.getEnd() < r108.getEnd()) goto L40;
        r103.add(new AnnotatedString.Range(((ParagraphStyle) r112.getItem()).merge((ParagraphStyle) r108.getItem()), r108.getStart(), r108.getEnd()));
        goto L42
    L40:
        throw new IllegalArgumentException();
    L44:
        if (r106 > r110.getText().length()) goto L54;
        if ((!r103.isEmpty()) == false) goto L54;
        AnnotatedString.Range r113 = (AnnotatedString.Range) r103.last();
        r102.add(new AnnotatedString.Range(r113.getItem(), r106, r113.getEnd()));
        r106 = r113.getEnd();
    L49:
        if ((!r103.isEmpty()) == false) goto L44;
        if (r106 != ((AnnotatedString.Range) r103.last()).getEnd()) goto L44;
        r103.removeLast();
    L54:
        if (r106 >= r110.getText().length()) goto L57;
        r102.add(new AnnotatedString.Range(r111, r106, r110.getText().length()));
    L57:
        if (r102.isEmpty() == false) goto L59;
        r102.add(new AnnotatedString.Range(r111, 0, 0));
    L59:
        return r102;
    L6:
        r101 = CollectionsKt.emptyList();
        goto L7
    }

    public static final AnnotatedString toLowerCase(AnnotatedString r100, final LocaleList r101) {
        return JvmAnnotatedString_jvmKt.transform(r100, new e(r101));
    }

    public static final AnnotatedString toUpperCase(AnnotatedString r100, final LocaleList r101) {
        return JvmAnnotatedString_jvmKt.transform(r100, new f(r101));
    }

    public static final AnnotatedString AnnotatedString(String r100, SpanStyle r101, ParagraphStyle r102) {
        List r103 = CollectionsKt.listOf(new AnnotatedString.Range(r101, 0, r100.length()));
        if (r102 != null) goto L5;
        List r104 = CollectionsKt.emptyList();
    L7:
        return new AnnotatedString(r100, r103, r104);
    L5:
        r104 = CollectionsKt.listOf(new AnnotatedString.Range(r102, 0, r100.length()));
        goto L7
    }

    public static final /* synthetic */ List access$filterRanges(List r100, int r101, int r102) {
        return filterRanges(r100, r101, r102);
    }

    public static final /* synthetic */ AnnotatedString access$substringWithoutParagraphStyles(AnnotatedString r100, int r101, int r102) {
        return substringWithoutParagraphStyles(r100, r101, r102);
    }

    private static final <T> List<AnnotatedString.Range<T>> filterRanges(List<? extends AnnotatedString.Range<? extends T>> r100, int r110, int r111) {
        int r101 = 0;
        if (r110 > r111) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        InlineClassHelperKt.throwIllegalArgumentException("start (" + r110 + ") should be less than or equal to end (" + r111 + ')');
    L9:
        if (r100 != null) goto L11;
        return null;
    L11:
        ArrayList r103 = new ArrayList(r100.size());
        int r104 = r100.size();
    L12:
        if (r101 >= r104) goto L18;
        AnnotatedString.Range r105 = (AnnotatedString.Range) ListProtector.get(r100, r101);
        if (intersect(r110, r111, r105.getStart(), r105.getEnd()) == false) goto L16;
        r103.add(new AnnotatedString.Range(r105.getItem(), Math.max(r110, r105.getStart()) - r110, Math.min(r111, r105.getEnd()) - r110, r105.getTag()));
    L16:
        r101 = r101 + 1;
        goto L12
    L18:
        if (r103.isEmpty() == false) goto L21;
        return null;
    L21:
        return r103;
    L5:
        r102 = false;
        goto L6
    }

    private static final List<AnnotatedString.Range<ParagraphStyle>> getLocalParagraphStyles(AnnotatedString r100, int r101, int r102) {
        if (r101 != r102) goto L5;
        return null;
    L5:
        List<AnnotatedString.Range<ParagraphStyle>> r103 = r100.getParagraphStylesOrNull$ui_text();
        if (r103 != null) goto L8;
        return null;
    L8:
        if (r101 == 0) goto L10;
    L12:
        ArrayList r104 = new ArrayList(r103.size());
        int r105 = r103.size();
        int r106 = 0;
    L13:
        if (r106 >= r105) goto L28;
        AnnotatedString.Range r107 = (AnnotatedString.Range) ListProtector.get(r103, r106);
        if (intersect(r101, r102, r107.getStart(), r107.getEnd()) == false) goto L27;
        Object r108 = r107.getItem();
        int r109 = r107.getStart();
        if (r109 >= r101) goto L19;
        r109 = r101;
    L19:
        if (r109 <= r102) goto L21;
        r109 = r102;
    L21:
        int r110 = r109 - r101;
        int r111 = r107.getEnd();
        if (r111 >= r101) goto L24;
        r111 = r101;
    L24:
        if (r111 <= r102) goto L26;
        r111 = r102;
    L26:
        r104.add(new AnnotatedString.Range(r108, r110, r111 - r101));
    L27:
        r106 = r106 + 1;
        goto L13
    L28:
        return r104;
    L10:
        if (r102 < r100.getText().length()) goto L12;
        return r103;
    }

    public static final <T> List<T> mapEachParagraphStyle(AnnotatedString r100, ParagraphStyle r101, Function2<? super AnnotatedString, ? super AnnotatedString.Range<ParagraphStyle>, ? extends T> r102) {
        List<AnnotatedString.Range<ParagraphStyle>> r103 = normalizedParagraphStyles(r100, r101);
        ArrayList r104 = new ArrayList(r103.size());
        int r105 = r103.size();
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L5;
        AnnotatedString.Range r107 = (AnnotatedString.Range) ListProtector.get(r103, r106);
        r104.add(r102.invoke(access$substringWithoutParagraphStyles(r100, r107.getStart(), r107.getEnd()), r107));
        r106 = r106 + 1;
        goto L3
    L5:
        return r104;
    }

    private static final AnnotatedString substringWithoutParagraphStyles(AnnotatedString r100, int r101, int r102) {
        if (r101 == r102) goto L5;
        String r103 = r100.getText().substring(r101, r102);
    L6:
        List<AnnotatedString.Range<? extends AnnotatedString.Annotation>> r104 = getLocalAnnotations(r100, r101, r102, new b());
        if (r104 != null) goto L10;
        r104 = CollectionsKt.emptyList();
    L10:
        return new AnnotatedString(r103, r104);
    L5:
        r103 = "";
        goto L6
    }

    public static final <R> R withAnnotation(AnnotatedString.Builder r100, TtsAnnotation r101, Function1<? super AnnotatedString.Builder, ? extends R> r102) {
        int r103 = r100.pushTtsAnnotation(r101);
        R r104 = r102.invoke(r100);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r100.pop(r103);
        InlineMarker.finallyEnd(1);
        return r104;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.pop(r103);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final <R> R withLink(AnnotatedString.Builder r100, LinkAnnotation r101, Function1<? super AnnotatedString.Builder, ? extends R> r102) {
        int r103 = r100.pushLink(r101);
        R r104 = r102.invoke(r100);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r100.pop(r103);
        InlineMarker.finallyEnd(1);
        return r104;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.pop(r103);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final <R> R withStyle(AnnotatedString.Builder r100, ParagraphStyle r101, Function1<? super AnnotatedString.Builder, ? extends R> r102) {
        int r103 = r100.pushStyle(r101);
        R r104 = r102.invoke(r100);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r100.pop(r103);
        InlineMarker.finallyEnd(1);
        return r104;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.pop(r103);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    @Deprecated(message = "Use LinkAnnotation API for links instead", replaceWith = @ReplaceWith(expression = "withLink(, block)", imports = {}))
    public static final <R> R withAnnotation(AnnotatedString.Builder r100, UrlAnnotation r101, Function1<? super AnnotatedString.Builder, ? extends R> r102) {
        int r103 = r100.pushUrlAnnotation(r101);
        R r104 = r102.invoke(r100);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r100.pop(r103);
        InlineMarker.finallyEnd(1);
        return r104;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.pop(r103);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final <R> R withStyle(AnnotatedString.Builder r100, SpanStyle r101, Function1<? super AnnotatedString.Builder, ? extends R> r102) {
        int r103 = r100.pushStyle(r101);
        R r104 = r102.invoke(r100);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r100.pop(r103);
        InlineMarker.finallyEnd(1);
        return r104;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.pop(r103);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static /* synthetic */ AnnotatedString capitalize$default(AnnotatedString r100, LocaleList r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = LocaleList.Companion.getCurrent();
    L6:
        return capitalize(r100, r101);
    }

    private static final String capitalize$lambda$14(LocaleList r100, String r101, int r102, int r103) {
        if (r102 != 0) goto L5;
        return StringKt.capitalize(r101.substring(r102, r103), r100);
    L5:
        return r101.substring(r102, r103);
    }

    public static /* synthetic */ AnnotatedString decapitalize$default(AnnotatedString r100, LocaleList r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = LocaleList.Companion.getCurrent();
    L6:
        return decapitalize(r100, r101);
    }

    private static final String decapitalize$lambda$15(LocaleList r100, String r101, int r102, int r103) {
        if (r102 != 0) goto L5;
        return StringKt.decapitalize(r101.substring(r102, r103), r100);
    L5:
        return r101.substring(r102, r103);
    }

    private static final List<AnnotatedString.Range<? extends AnnotatedString.Annotation>> getLocalAnnotations(AnnotatedString r100, int r110, int r111, Function1<? super AnnotatedString.Annotation, Boolean> r112) {
        if (r110 != r111) goto L5;
        return null;
    L5:
        List<AnnotatedString.Range<? extends AnnotatedString.Annotation>> r101 = r100.getAnnotations$ui_text();
        if (r101 != null) goto L8;
        return null;
    L8:
        int r102 = 0;
        if (r110 == 0) goto L11;
    L22:
        ArrayList r103 = new ArrayList(r101.size());
        int r104 = r101.size();
        int r105 = 0;
    L23:
        if (r105 >= r104) goto L36;
        AnnotatedString.Range r106 = (AnnotatedString.Range) ListProtector.get(r101, r105);
        boolean r107 = true;
        if (r112 == null) goto L27;
        boolean r108 = r112.invoke(r106.getItem()).booleanValue();
    L28:
        if (r108 == true) goto L30;
    L32:
        r107 = false;
    L33:
        if (r107 == false) goto L35;
        String r109 = r106.getTag();
        r103.add(new AnnotatedString.Range((AnnotatedString.Annotation) r106.getItem(), RangesKt.coerceIn(r106.getStart(), r110, r111) - r110, RangesKt.coerceIn(r106.getEnd(), r110, r111) - r110, r109));
    L35:
        r105 = r105 + 1;
        goto L23
    L30:
        if (intersect(r110, r111, r106.getStart(), r106.getEnd()) == false) goto L32;
    L27:
        r108 = true;
        goto L28
    L36:
        return r103;
    L11:
        if (r111 < r100.getText().length()) goto L22;
        if (r112 == null) goto L43;
        ArrayList r113 = new ArrayList(r101.size());
        int r114 = r101.size();
    L15:
        if (r102 >= r114) goto L21;
        Object r115 = ListProtector.get(r101, r102);
        if (r112.invoke(((AnnotatedString.Range) r115).getItem()).booleanValue() == false) goto L19;
        r113.add(r115);
    L19:
        r102 = r102 + 1;
        goto L15
    L21:
        return r113;
    L43:
        return r101;
    }

    public static /* synthetic */ AnnotatedString toLowerCase$default(AnnotatedString r100, LocaleList r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = LocaleList.Companion.getCurrent();
    L6:
        return toLowerCase(r100, r101);
    }

    private static final String toLowerCase$lambda$13(LocaleList r100, String r101, int r102, int r103) {
        return StringKt.toLowerCase(r101.substring(r102, r103), r100);
    }

    public static /* synthetic */ AnnotatedString toUpperCase$default(AnnotatedString r100, LocaleList r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = LocaleList.Companion.getCurrent();
    L6:
        return toUpperCase(r100, r101);
    }

    private static final String toUpperCase$lambda$12(LocaleList r100, String r101, int r102, int r103) {
        return StringKt.toUpperCase(r101.substring(r102, r103), r100);
    }

    public static final <R> R withAnnotation(AnnotatedString.Builder r100, String r101, String r102, Function1<? super AnnotatedString.Builder, ? extends R> r103) {
        int r104 = r100.pushStringAnnotation(r101, r102);
        R r105 = r103.invoke(r100);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r100.pop(r104);
        InlineMarker.finallyEnd(1);
        return r105;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r100.pop(r104);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static /* synthetic */ AnnotatedString AnnotatedString$default(String r100, SpanStyle r101, ParagraphStyle r102, int r103, Object r104) {
        if ((r103 & 4) == 0) goto L6;
        r102 = null;
    L6:
        return AnnotatedString(r100, r101, r102);
    }

    public static /* synthetic */ List getLocalAnnotations$default(AnnotatedString r100, int r101, int r102, Function1 r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = null;
    L6:
        return getLocalAnnotations(r100, r101, r102, r103);
    }
}
