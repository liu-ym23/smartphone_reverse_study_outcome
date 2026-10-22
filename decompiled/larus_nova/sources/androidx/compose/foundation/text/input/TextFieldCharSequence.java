package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.input.internal.ToCharArray_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007\u0012\u001a\b\u0002\u0010\t\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\r\u0018\u00010\n\u0012\u001a\b\u0002\u0010\u000e\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\r\u0018\u00010\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0015H\u0096\u0002J\u0018\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015H\u0016J\b\u0010'\u001a\u00020(H\u0016J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0001J&\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u0015J\u0006\u00103\u001a\u00020*J\u0013\u00104\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u000105H\u0096\u0002J\b\u00106\u001a\u00020\u0015H\u0016R#\u0010\t\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\r\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R#\u0010\u000e\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\f0\u000bj\u0002`\r\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0003\u001a\u00020\u0004¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u00067"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "", "text", "selection", "Landroidx/compose/ui/text/TextRange;", "composition", "highlight", "Lkotlin/Pair;", "Landroidx/compose/foundation/text/input/TextHighlightType;", "composingAnnotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "Landroidx/compose/foundation/text/input/PlacedAnnotation;", "outputAnnotations", "<init>", "(Ljava/lang/CharSequence;JLandroidx/compose/ui/text/TextRange;Lkotlin/Pair;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getComposingAnnotations", "()Ljava/util/List;", "getOutputAnnotations", "length", "", "getLength", "()I", "getText", "()Ljava/lang/CharSequence;", "getSelection-d9O1mEE", "()J", "J", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "getHighlight", "()Lkotlin/Pair;", MonitorConstants.CONNECT_TYPE_GET, "", "index", "subSequence", "startIndex", "endIndex", "toString", "", "contentEquals", "", "other", "toCharArray", "", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "", "destinationOffset", "sourceStartIndex", "sourceEndIndex", "shouldShowSelection", "equals", "", "hashCode", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldCharSequence implements CharSequence {
    public static final int $stable = 8;
    private final List<AnnotatedString.Range<AnnotatedString.Annotation>> composingAnnotations;
    private final TextRange composition;
    private final Pair<TextHighlightType, TextRange> highlight;
    private final List<AnnotatedString.Range<AnnotatedString.Annotation>> outputAnnotations;
    private final long selection;
    private final CharSequence text;

    public /* synthetic */ TextFieldCharSequence(CharSequence r100, long r101, TextRange r102, Pair r103, List r104, List r105, DefaultConstructorMarker r106) {
        this(r100, r101, r102, r103, r104, r105);
    }

    public int getLength() {
        return this.text.length();
    }

    public int hashCode() {
        int r100 = ((this.text.hashCode() * 31) + TextRange.m6999hashCodeimpl(this.selection)) * 31;
        TextRange r101 = this.composition;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = TextRange.m6999hashCodeimpl(r101.m7002unboximpl());
    L6:
        int r104 = (r100 + r103) * 31;
        Pair<TextHighlightType, TextRange> r105 = this.highlight;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        List<AnnotatedString.Range<AnnotatedString.Annotation>> r108 = this.composingAnnotations;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        return r107 + r102;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final boolean shouldShowSelection() {
        if (this.highlight != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.text.toString();
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return getLength();
    }

    public final List<AnnotatedString.Range<AnnotatedString.Annotation>> getComposingAnnotations() {
        return this.composingAnnotations;
    }

    /* JADX INFO: renamed from: getComposition-MzsxiRA, reason: not valid java name */
    public final TextRange m1196getCompositionMzsxiRA() {
        return this.composition;
    }

    public final Pair<TextHighlightType, TextRange> getHighlight() {
        return this.highlight;
    }

    public final List<AnnotatedString.Range<AnnotatedString.Annotation>> getOutputAnnotations() {
        return this.outputAnnotations;
    }

    /* JADX INFO: renamed from: getSelection-d9O1mEE, reason: not valid java name */
    public final long m1197getSelectiond9O1mEE() {
        return this.selection;
    }

    public final CharSequence getText() {
        return this.text;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int r100) {
        return get(r100);
    }

    public final boolean contentEquals(CharSequence r100) {
        return StringsKt.contentEquals(this.text, r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (TextFieldCharSequence.class == r100.getClass()) goto L11;
        return false;
    L11:
        TextFieldCharSequence r101 = (TextFieldCharSequence) r100;
        if (TextRange.m6991equalsimpl0(this.selection, r101.selection) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.composition, r101.composition) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.highlight, r101.highlight) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.composingAnnotations, r101.composingAnnotations) == true) goto L24;
        return false;
    L24:
        if (contentEquals(r101.text) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public char get(int r100) {
        return this.text.charAt(r100);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int r100, int r101) {
        return this.text.subSequence(r100, r101);
    }

    public final void toCharArray(char[] r100, int r101, int r102, int r103) {
        ToCharArray_androidKt.toCharArray(this.text, r100, r101, r102, r103);
    }

    private TextFieldCharSequence(CharSequence r100, long r101, TextRange r102, Pair<TextHighlightType, TextRange> r103, List<AnnotatedString.Range<AnnotatedString.Annotation>> r104, List<AnnotatedString.Range<AnnotatedString.Annotation>> r105) {
        this.composingAnnotations = r104;
        this.outputAnnotations = r105;
        if ((r100 instanceof TextFieldCharSequence) == false) goto L5;
        CharSequence r106 = ((TextFieldCharSequence) r100).text;
    L6:
        this.text = r106;
        this.selection = TextRangeKt.m7004coerceIn8ffj60Q(r101, 0, r100.length());
        Pair<TextHighlightType, TextRange> r107 = null;
        if (r102 == null) goto L9;
        TextRange r108 = TextRange.m6986boximpl(TextRangeKt.m7004coerceIn8ffj60Q(r102.m7002unboximpl(), 0, r100.length()));
    L10:
        this.composition = r108;
        if (r103 == null) goto L13;
        r107 = Pair.copy$default(r103, null, TextRange.m6986boximpl(TextRangeKt.m7004coerceIn8ffj60Q(r103.getSecond().m7002unboximpl(), 0, r100.length())), 1, null);
    L13:
        this.highlight = r107;
        return;
    L9:
        r108 = null;
        goto L10
    L5:
        r106 = r100;
        goto L6
    }

    public /* synthetic */ TextFieldCharSequence(CharSequence r100, long r110, TextRange r111, Pair r112, List r113, List r114, int r115, DefaultConstructorMarker r116) {
        if ((r115 & 1) == 0) goto L5;
        CharSequence r101 = "";
    L7:
        if ((r115 & 2) == 0) goto L9;
        long r102 = TextRange.Companion.m7003getZerod9O1mEE();
    L10:
        List r103 = null;
        if ((r115 & 4) == 0) goto L13;
        TextRange r104 = null;
    L15:
        if ((r115 & 8) == 0) goto L17;
        Pair r105 = null;
    L19:
        if ((r115 & 16) == 0) goto L21;
        List r106 = null;
    L23:
        if ((r115 & 32) != 0) goto L26;
        r103 = r114;
    L26:
        this(r101, r102, r104, r105, r106, r103, null);
        return;
    L21:
        r106 = r113;
        goto L23
    L17:
        r105 = r112;
        goto L19
    L13:
        r104 = r111;
        goto L15
    L9:
        r102 = r110;
        goto L10
    L5:
        r101 = r100;
        goto L7
    }
}
