package androidx.compose.foundation.text.input;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.input.internal.ChangeTracker;
import androidx.compose.foundation.text.input.internal.OffsetMappingCalculator;
import androidx.compose.foundation.text.input.internal.PartialGapBuffer;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002\u0086\u0001B3\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010;\u001a\u00020'H\u0000¢\u0006\u0002\b<J\r\u0010=\u001a\u00020>H\u0000¢\u0006\u0002\b?J9\u0010@\u001a\u00020>2\u0006\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u00152\u001a\b\u0002\u0010C\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020706j\u0002`E\u0018\u00010DH\u0000¢\u0006\u0002\bFJ'\u0010L\u001a\u00020>2\u0006\u0010M\u001a\u00020H2\u0006\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u0015H\u0000¢\u0006\u0004\bN\u0010OJ\r\u0010P\u001a\u00020>H\u0000¢\u0006\u0002\bQJ\u001e\u0010R\u001a\u00020>2\u0006\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u00152\u0006\u0010S\u001a\u00020\u0019J9\u0010R\u001a\u00020>2\u0006\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u00152\u0006\u0010S\u001a\u00020\u00192\b\b\u0002\u0010T\u001a\u00020\u00152\b\b\u0002\u0010U\u001a\u00020\u0015H\u0000¢\u0006\u0002\bVJ\u0015\u0010W\u001a\u00020>2\u0006\u0010X\u001a\u00020\u0019H\u0000¢\u0006\u0002\bYJ\u0016\u0010Z\u001a\u00060\u0001j\u0002`\u00022\b\u0010S\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010Z\u001a\u00060\u0001j\u0002`\u00022\b\u0010S\u001a\u0004\u0018\u00010\u00192\u0006\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u0015H\u0016J\u0014\u0010Z\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010[\u001a\u00020\\H\u0016J \u0010]\u001a\u00020>2\u0006\u0010^\u001a\u00020\u00152\u0006\u0010_\u001a\u00020\u00152\u0006\u0010`\u001a\u00020\u0015H\u0002J\u000e\u0010a\u001a\u00020\\2\u0006\u0010b\u001a\u00020\u0015J\b\u0010c\u001a\u00020dH\u0016J\u0006\u0010e\u001a\u00020\u0019J\b\u0010f\u001a\u00020>H\u0002J\u0006\u0010g\u001a\u00020>J\u000e\u0010h\u001a\u00020>2\u0006\u0010b\u001a\u00020\u0015J\u000e\u0010i\u001a\u00020>2\u0006\u0010b\u001a\u00020\u0015J]\u0010j\u001a\u00020\u00042\b\b\u0002\u0010,\u001a\u00020\u001d2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u001d2\u001a\b\u0002\u00108\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020706j\u0002`E\u0018\u00010D2\u001a\b\u0002\u0010k\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020706j\u0002`E\u0018\u00010DH\u0000¢\u0006\u0004\bl\u0010mJ \u0010n\u001a\u00020>2\u0006\u0010b\u001a\u00020\u00152\u0006\u0010o\u001a\u00020'2\u0006\u0010p\u001a\u00020'H\u0002J\u0017\u0010q\u001a\u00020>2\u0006\u0010r\u001a\u00020\u001dH\u0002¢\u0006\u0004\bs\u0010/J&\u0010~\u001a\u00020>2\u0006\u0010\u007f\u001a\u0002072\u0006\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u0015H\u0000¢\u0006\u0003\b\u0080\u0001J!\u0010\u0081\u0001\u001a\u00020>2\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0006\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u0015J!\u0010\u0081\u0001\u001a\u00020>2\b\u0010\u0084\u0001\u001a\u00030\u0085\u00012\u0006\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u0015R\u0014\u0010\u0007\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0011\u0010&\u001a\u00020'8G¢\u0006\u0006\u001a\u0004\b&\u0010(R\u0010\u0010)\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0004\n\u0002\u0010*R$\u0010,\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010\u001f\"\u0004\b.\u0010/R(\u00100\u001a\u0004\u0018\u00010\u001d2\b\u0010+\u001a\u0004\u0018\u00010\u001d@BX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R:\u00108\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020706\u0018\u0001052\u0014\u0010+\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020706\u0018\u000105@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R:\u0010I\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u001d\u0018\u00010G2\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u001d\u0018\u00010G@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u001a\u0010t\u001a\u00020'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010(\"\u0004\bv\u0010wR,\u0010x\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020706j\u0002`E\u0018\u00010yX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}¨\u0006\u0087\u0001"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldBuffer;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "initialValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "initialChanges", "Landroidx/compose/foundation/text/input/internal/ChangeTracker;", "originalValue", "offsetMappingCalculator", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "<init>", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/internal/ChangeTracker;Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;)V", "getOriginalValue$foundation_release", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "buffer", "Landroidx/compose/foundation/text/input/internal/PartialGapBuffer;", "backingChangeTracker", "changeTracker", "getChangeTracker$foundation_release", "()Landroidx/compose/foundation/text/input/internal/ChangeTracker;", "length", "", "getLength", "()I", "originalText", "", "getOriginalText", "()Ljava/lang/CharSequence;", "originalSelection", "Landroidx/compose/ui/text/TextRange;", "getOriginalSelection-d9O1mEE", "()J", "changes", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "getChanges$annotations", "()V", "getChanges", "()Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "hasSelection", "", "()Z", "selectionInChars", "J", "value", "selection", "getSelection-d9O1mEE", "setSelection-5zc-tL8", "(J)V", "composition", "getComposition-MzsxiRA$foundation_release", "()Landroidx/compose/ui/text/TextRange;", "setComposition-OEnZFl4", "(Landroidx/compose/ui/text/TextRange;)V", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "composingAnnotations", "getComposingAnnotations$foundation_release", "()Landroidx/compose/runtime/collection/MutableVector;", "hasComposition", "hasComposition$foundation_release", "commitComposition", "", "commitComposition$foundation_release", "setComposition", "start", "end", "annotations", "", "Landroidx/compose/foundation/text/input/PlacedAnnotation;", "setComposition$foundation_release", "Lkotlin/Pair;", "Landroidx/compose/foundation/text/input/TextHighlightType;", "highlight", "getHighlight$foundation_release", "()Lkotlin/Pair;", "setHighlight", "type", "setHighlight-K7f2yys$foundation_release", "(III)V", "clearHighlight", "clearHighlight$foundation_release", "replace", "text", "textStart", "textEnd", "replace$foundation_release", "setTextIfChanged", "newText", "setTextIfChanged$foundation_release", "append", "char", "", "onTextWillChange", "replaceStart", "replaceEnd", "newLength", "charAt", "index", "toString", "", "asCharSequence", "clearChangeList", "revertAllChanges", "placeCursorBeforeCharAt", "placeCursorAfterCharAt", "toTextFieldCharSequence", "outputAnnotations", "toTextFieldCharSequence-wFTz33Y$foundation_release", "(JLandroidx/compose/ui/text/TextRange;Ljava/util/List;Ljava/util/List;)Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "requireValidIndex", "startExclusive", "endExclusive", "requireValidRange", FilterData.FilterOptionItem.Type.RANGE, "requireValidRange-5zc-tL8", "canCallAddStyle", "getCanCallAddStyle$foundation_release", "setCanCallAddStyle$foundation_release", "(Z)V", "outputTransformationAnnotations", "", "getOutputTransformationAnnotations$foundation_release", "()Ljava/util/List;", "setOutputTransformationAnnotations$foundation_release", "(Ljava/util/List;)V", "addAnnotation", "annotation", "addAnnotation$foundation_release", "addStyle", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "paragraphStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "ChangeList", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldBuffer implements Appendable {
    public static final int $stable = 8;
    private ChangeTracker backingChangeTracker;
    private final PartialGapBuffer buffer;
    private boolean canCallAddStyle;
    private MutableVector<AnnotatedString.Range<AnnotatedString.Annotation>> composingAnnotations;
    private TextRange composition;
    private Pair<TextHighlightType, TextRange> highlight;
    private final OffsetMappingCalculator offsetMappingCalculator;
    private final TextFieldCharSequence originalValue;
    private List<AnnotatedString.Range<AnnotatedString.Annotation>> outputTransformationAnnotations;
    private long selectionInChars;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&¢\u0006\u0004\b\f\u0010\nR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "", "changeCount", "", "getChangeCount", "()I", "getRange", "Landroidx/compose/ui/text/TextRange;", "changeIndex", "getRange--jx7JFs", "(I)J", "getOriginalRange", "getOriginalRange--jx7JFs", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface ChangeList {
        int getChangeCount();

        /* JADX INFO: renamed from: getOriginalRange--jx7JFs, reason: not valid java name */
        long mo1193getOriginalRangejx7JFs(int r100);

        /* JADX INFO: renamed from: getRange--jx7JFs, reason: not valid java name */
        long mo1194getRangejx7JFs(int r100);
    }

    public static /* synthetic */ AnnotatedString.Range a(TextFieldCharSequence r100, int r101) {
        return composingAnnotations$lambda$2(r100, r101);
    }

    public static /* synthetic */ void getChanges$annotations() {
    }

    public final void clearHighlight$foundation_release() {
        this.highlight = null;
    }

    public final void commitComposition$foundation_release() {
        m1185setCompositionOEnZFl4(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ChangeTracker getChangeTracker$foundation_release() {
        ChangeTracker r100 = this.backingChangeTracker;
        if (r100 != null) goto L6;
        ChangeTracker r101 = null;
        ChangeTracker r102 = new ChangeTracker(r101, 1, 0 == true ? 1 : 0);
        this.backingChangeTracker = r102;
        return r102;
    L6:
        return r100;
    }

    public final int getLength() {
        return this.buffer.length();
    }

    /* JADX INFO: renamed from: getOriginalSelection-d9O1mEE, reason: not valid java name */
    public final long m1188getOriginalSelectiond9O1mEE() {
        return this.originalValue.m1197getSelectiond9O1mEE();
    }

    public final CharSequence getOriginalText() {
        return this.originalValue.getText();
    }

    public final boolean hasComposition$foundation_release() {
        if (this.composition == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return this.buffer.toString();
    }

    private final void clearChangeList() {
        getChangeTracker$foundation_release().clearChanges();
    }

    public final ChangeList getChanges() {
        return getChangeTracker$foundation_release();
    }

    public final boolean hasSelection() {
        return !TextRange.m6992getCollapsedimpl(m1189getSelectiond9O1mEE());
    }

    public final void revertAllChanges() {
        replace(0, getLength(), this.originalValue.toString());
        m1191setSelection5zctL8(this.originalValue.m1197getSelectiond9O1mEE());
        clearChangeList();
    }

    public final CharSequence asCharSequence() {
        return this.buffer;
    }

    public final boolean getCanCallAddStyle$foundation_release() {
        return this.canCallAddStyle;
    }

    public final MutableVector<AnnotatedString.Range<AnnotatedString.Annotation>> getComposingAnnotations$foundation_release() {
        return this.composingAnnotations;
    }

    /* JADX INFO: renamed from: getComposition-MzsxiRA$foundation_release, reason: not valid java name */
    public final TextRange m1187getCompositionMzsxiRA$foundation_release() {
        return this.composition;
    }

    public final Pair<TextHighlightType, TextRange> getHighlight$foundation_release() {
        return this.highlight;
    }

    public final TextFieldCharSequence getOriginalValue$foundation_release() {
        return this.originalValue;
    }

    public final List<AnnotatedString.Range<AnnotatedString.Annotation>> getOutputTransformationAnnotations$foundation_release() {
        return this.outputTransformationAnnotations;
    }

    /* JADX INFO: renamed from: getSelection-d9O1mEE, reason: not valid java name */
    public final long m1189getSelectiond9O1mEE() {
        return this.selectionInChars;
    }

    /* JADX INFO: renamed from: requireValidRange-5zc-tL8, reason: not valid java name */
    private final void m1184requireValidRange5zctL8(long r100) {
        long r101 = TextRangeKt.TextRange(0, getLength());
        if (TextRange.m6988contains5zctL8(r101, r100) == true) goto L6;
        InlineClassHelperKt.throwIllegalArgumentException("Expected " + TextRange.m7001toStringimpl(r100) + " to be in " + TextRange.m7001toStringimpl(r101));
        return;
    }

    /* JADX INFO: renamed from: setComposition-OEnZFl4, reason: not valid java name */
    private final void m1185setCompositionOEnZFl4(TextRange r100) {
        if (r100 != null) goto L4;
    L7:
        this.composition = null;
        MutableVector<AnnotatedString.Range<AnnotatedString.Annotation>> r101 = this.composingAnnotations;
        if (r101 == null) goto L12;
        r101.clear();
        return;
    L12:
        return;
    L4:
        if (TextRange.m6992getCollapsedimpl(r100.m7002unboximpl()) == true) goto L7;
        this.composition = r100;
    }

    @Override // java.lang.Appendable
    public Appendable append(CharSequence r110) {
        if (r110 == null) goto L4;
        onTextWillChange(getLength(), getLength(), r110.length());
        PartialGapBuffer r100 = this.buffer;
        PartialGapBuffer.replace$default(r100, r100.length(), this.buffer.length(), r110, 0, 0, 24, null);
    L4:
        return this;
    }

    public final char charAt(int r100) {
        return this.buffer.charAt(r100);
    }

    public final void placeCursorAfterCharAt(int r100) {
        requireValidIndex(r100, false, true);
        this.selectionInChars = TextRangeKt.TextRange(RangesKt.coerceAtMost(r100 + 1, getLength()));
    }

    public final void placeCursorBeforeCharAt(int r100) {
        requireValidIndex(r100, true, false);
        this.selectionInChars = TextRangeKt.TextRange(r100);
    }

    public final void setCanCallAddStyle$foundation_release(boolean r100) {
        this.canCallAddStyle = r100;
    }

    public final void setOutputTransformationAnnotations$foundation_release(List<AnnotatedString.Range<AnnotatedString.Annotation>> r100) {
        this.outputTransformationAnnotations = r100;
    }

    /* JADX INFO: renamed from: setSelection-5zc-tL8, reason: not valid java name */
    public final void m1191setSelection5zctL8(long r100) {
        m1184requireValidRange5zctL8(r100);
        this.selectionInChars = r100;
        this.highlight = null;
    }

    public final void setTextIfChanged$foundation_release(CharSequence r110) {
        PartialGapBuffer r100 = this.buffer;
        int r101 = r100.length();
        int r102 = r110.length();
        boolean r103 = false;
        if (r100.length() <= 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L8;
    L28:
        int r111 = r101;
        int r112 = r102;
        int r105 = 0;
        int r113 = 0;
    L29:
        if (r105 < r111) goto L32;
        if (r113 < r112) goto L32;
        return;
    L32:
        replace$foundation_release(r105, r111, r110, r113, r112);
        return;
    L8:
        if (r110.length() <= 0) goto L10;
        boolean r106 = true;
    L11:
        if (r106 == false) goto L28;
        int r107 = 0;
        int r108 = 0;
        boolean r109 = false;
    L13:
        if (r103 == false) goto L15;
    L18:
        if (r109 == false) goto L20;
    L23:
        if (r107 >= r101) goto L27;
        if (r108 >= r102) goto L27;
        if (r103 == false) goto L13;
        if (r109 == false) goto L13;
    L27:
        r111 = r101;
        r112 = r102;
        r105 = r107;
        r113 = r108;
        goto L29
    L20:
        if (r100.charAt(r101 - 1) != r110.charAt(r102 - 1)) goto L22;
        r101 = r101 - 1;
        r102 = r102 - 1;
        goto L23
    L22:
        r109 = true;
        goto L23
    L15:
        if (r100.charAt(r107) != r110.charAt(r108)) goto L17;
        r107 = r107 + 1;
        r108 = r108 + 1;
        goto L18
    L17:
        r103 = true;
        goto L18
    L10:
        r106 = false;
        goto L11
    L5:
        r104 = false;
        goto L6
    }

    @Override // java.lang.Appendable
    public Appendable append(char r110) {
        onTextWillChange(getLength(), getLength(), 1);
        PartialGapBuffer r100 = this.buffer;
        PartialGapBuffer.replace$default(r100, r100.length(), this.buffer.length(), String.valueOf(r110), 0, 0, 24, null);
        return this;
    }

    private static final AnnotatedString.Range composingAnnotations$lambda$2(TextFieldCharSequence r100, int r101) {
        return (AnnotatedString.Range) ListProtector.get(r100.getComposingAnnotations(), r101);
    }

    private final void onTextWillChange(int r100, int r101, int r102) {
        getChangeTracker$foundation_release().trackChange(r100, r101, r102);
        OffsetMappingCalculator r103 = this.offsetMappingCalculator;
        if (r103 == null) goto L5;
        r103.recordEditOperation(r100, r101, r102);
    L5:
        this.selectionInChars = TextFieldBufferKt.m1195adjustTextRangevJH6DeI(m1189getSelectiond9O1mEE(), r100, r101, r102);
    }

    private final void requireValidIndex(int r100, boolean r101, boolean r102) {
        boolean r103 = false;
        if (r101 == false) goto L5;
        int r104 = 0;
    L7:
        if (r102 == false) goto L9;
        int r105 = getLength();
    L10:
        if (r104 > r100) goto L13;
        if (r100 >= r105) goto L13;
        r103 = true;
    L13:
        if (r103 == true) goto L16;
        InlineClassHelperKt.throwIllegalArgumentException("Expected " + r100 + " to be in [" + r104 + ", " + r105 + ')');
        return;
    L16:
        return;
    L9:
        r105 = getLength() + 1;
        goto L10
    L5:
        r104 = -1;
        goto L7
    }

    public final void addAnnotation$foundation_release(AnnotatedString.Annotation r100, int r101, int r102) {
        if (this.canCallAddStyle == true) goto L6;
        InlineClassHelperKt.throwIllegalStateException("You can add styling to a [TextFieldBuffer] only from an [OutputTransformation].");
    L6:
        if (this.outputTransformationAnnotations != null) goto L8;
        this.outputTransformationAnnotations = new ArrayList();
    L8:
        List<AnnotatedString.Range<AnnotatedString.Annotation>> r103 = this.outputTransformationAnnotations;
        if (r103 == null) goto L12;
        r103.add(new AnnotatedString.Range(r100, r101, r102));
        return;
    }

    public final void addStyle(ParagraphStyle r100, int r101, int r102) {
        addAnnotation$foundation_release(r100, r101, r102);
    }

    @Override // java.lang.Appendable
    public Appendable append(CharSequence r110, int r111, int r112) {
        if (r110 == null) goto L4;
        onTextWillChange(getLength(), getLength(), r112 - r111);
        PartialGapBuffer r100 = this.buffer;
        PartialGapBuffer.replace$default(r100, r100.length(), this.buffer.length(), r110.subSequence(r111, r112), 0, 0, 24, null);
    L4:
        return this;
    }

    public final void replace(int r100, int r101, CharSequence r102) {
        replace$foundation_release(r100, r101, r102, 0, r102.length());
    }

    public final void setComposition$foundation_release(int r110, int r111, List<AnnotatedString.Range<AnnotatedString.Annotation>> r112) {
        if (r110 < 0) goto L36;
        if (r110 > this.buffer.length()) goto L36;
        if (r111 < 0) goto L34;
        if (r111 > this.buffer.length()) goto L34;
        if (r110 >= r111) goto L32;
        m1185setCompositionOEnZFl4(TextRange.m6986boximpl(TextRangeKt.TextRange(r110, r111)));
        MutableVector<AnnotatedString.Range<AnnotatedString.Annotation>> r113 = this.composingAnnotations;
        if (r113 == null) goto L13;
        r113.clear();
    L13:
        List<AnnotatedString.Range<AnnotatedString.Annotation>> r114 = r112;
        int r100 = 0;
        if (r114 != null) goto L16;
    L19:
        boolean r101 = true;
    L20:
        if (r101 == false) goto L22;
        return;
    L22:
        if (this.composingAnnotations != null) goto L24;
        this.composingAnnotations = new MutableVector(new AnnotatedString.Range[16], 0);
    L24:
        int r115 = r114.size();
    L25:
        if (r100 >= r115) goto L40;
        AnnotatedString.Range r102 = (AnnotatedString.Range) ListProtector.get(r112, r100);
        MutableVector<AnnotatedString.Range<AnnotatedString.Annotation>> r103 = this.composingAnnotations;
        if (r103 == null) goto L29;
        r103.add(AnnotatedString.Range.copy$default(r102, null, r102.getStart() + r110, r102.getEnd() + r110, null, 9, null));
    L29:
        r100 = r100 + 1;
        goto L25
    L40:
        return;
    L16:
        if (r114.isEmpty() == true) goto L19;
        r101 = false;
        goto L20
    L32:
        throw new IllegalArgumentException("Do not set reversed or empty range: " + r110 + " > " + r111);
    L34:
        throw new IndexOutOfBoundsException("end (" + r111 + ") offset is outside of text region " + this.buffer.length());
    L36:
        throw new IndexOutOfBoundsException("start (" + r110 + ") offset is outside of text region " + this.buffer.length());
    }

    /* JADX INFO: renamed from: setHighlight-K7f2yys$foundation_release, reason: not valid java name */
    public final void m1190setHighlightK7f2yys$foundation_release(int r100, int r101, int r102) {
        if (r101 >= r102) goto L6;
        this.highlight = new Pair(TextHighlightType.m1203boximpl(r100), TextRange.m6986boximpl(TextRangeKt.TextRange(RangesKt.coerceIn(r101, 0, getLength()), RangesKt.coerceIn(r102, 0, getLength()))));
        return;
    L6:
        throw new IllegalArgumentException("Do not set reversed or empty range: " + r101 + " > " + r102);
    }

    public final void addStyle(SpanStyle r100, int r101, int r102) {
        addAnnotation$foundation_release(r100, r101, r102);
    }

    public TextFieldBuffer(TextFieldCharSequence r100, ChangeTracker r101, TextFieldCharSequence r102, OffsetMappingCalculator r103) {
        this.originalValue = r102;
        this.offsetMappingCalculator = r103;
        this.buffer = new PartialGapBuffer(r100);
        MutableVector<AnnotatedString.Range<AnnotatedString.Annotation>> r104 = null;
        if (r101 == null) goto L5;
        ChangeTracker r105 = new ChangeTracker(r101);
    L6:
        this.backingChangeTracker = r105;
        this.selectionInChars = r100.m1197getSelectiond9O1mEE();
        this.composition = r100.m1196getCompositionMzsxiRA();
        List<AnnotatedString.Range<AnnotatedString.Annotation>> r106 = r100.getComposingAnnotations();
        boolean r107 = true;
        if (r106 != null) goto L9;
    L12:
        boolean r108 = true;
    L13:
        if (r108 == true) goto L18;
        int r109 = r100.getComposingAnnotations().size();
        AnnotatedString.Range[] r110 = new AnnotatedString.Range[r109];
        int r111 = 0;
    L15:
        if (r111 >= r109) goto L17;
        r110[r111] = a(r100, Integer.valueOf(r111).intValue());
        r111 = r111 + 1;
        goto L15
    L17:
        r104 = new MutableVector(r110, r109);
    L18:
        this.composingAnnotations = r104;
        if (this.offsetMappingCalculator != null) goto L22;
        r107 = false;
    L22:
        this.canCallAddStyle = r107;
        return;
    L9:
        if (r106.isEmpty() == true) goto L12;
        r108 = false;
        goto L13
    L5:
        r105 = null;
        goto L6
    }

    /* JADX INFO: renamed from: toTextFieldCharSequence-wFTz33Y$foundation_release, reason: not valid java name */
    public final TextFieldCharSequence m1192toTextFieldCharSequencewFTz33Y$foundation_release(long r110, TextRange r111, List<AnnotatedString.Range<AnnotatedString.Annotation>> r112, List<AnnotatedString.Range<AnnotatedString.Annotation>> r113) {
        return new TextFieldCharSequence(this.buffer.toString(), r110, r111, null, r112, r113, 8, null);
    }

    public final void replace$foundation_release(int r100, int r101, CharSequence r110, int r111, int r112) {
        boolean r102 = true;
        if (r100 > r101) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("Expected start=" + r100 + " <= end=" + r101);
    L8:
        if (r111 <= r112) goto L11;
        r102 = false;
    L11:
        if (r102 == true) goto L13;
        InlineClassHelperKt.throwIllegalArgumentException("Expected textStart=" + r111 + " <= textEnd=" + r112);
    L13:
        onTextWillChange(r100, r101, r112 - r111);
        this.buffer.replace(r100, r101, r110, r111, r112);
        commitComposition$foundation_release();
        clearHighlight$foundation_release();
        return;
    L5:
        r103 = false;
        goto L6
    }

    public /* synthetic */ TextFieldBuffer(TextFieldCharSequence r100, ChangeTracker r101, TextFieldCharSequence r102, OffsetMappingCalculator r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = r100;
    L9:
        if ((r104 & 8) == 0) goto L11;
        r103 = null;
    L11:
        this(r100, r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setComposition$foundation_release$default(TextFieldBuffer r100, int r101, int r102, List r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = null;
    L5:
        r100.setComposition$foundation_release(r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: toTextFieldCharSequence-wFTz33Y$foundation_release$default, reason: not valid java name */
    public static /* synthetic */ TextFieldCharSequence m1186toTextFieldCharSequencewFTz33Y$foundation_release$default(TextFieldBuffer r100, long r101, TextRange r102, List r110, List r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.m1189getSelectiond9O1mEE();
    L5:
        long r103 = r101;
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.composition;
    L8:
        TextRange r104 = r102;
        if ((r112 & 4) == 0) goto L18;
        MutableVector<AnnotatedString.Range<AnnotatedString.Annotation>> r105 = r100.composingAnnotations;
        if (r105 == null) goto L17;
        List<AnnotatedString.Range<AnnotatedString.Annotation>> r106 = r105.asMutableList();
        if (r106 == null) goto L17;
        if ((!r106.isEmpty()) == false) goto L17;
        r110 = r106;
    L17:
        r110 = null;
    L18:
        List r107 = r110;
        if ((r112 & 8) == 0) goto L21;
        List r108 = null;
    L23:
        return r100.m1192toTextFieldCharSequencewFTz33Y$foundation_release(r103, r104, r107, r108);
    L21:
        r108 = r111;
        goto L23
    }

    public static /* synthetic */ void replace$foundation_release$default(TextFieldBuffer r100, int r101, int r102, CharSequence r103, int r110, int r111, int r112, Object r113) {
        if ((r112 & 8) == 0) goto L5;
        int r104 = 0;
    L7:
        if ((r112 & 16) == 0) goto L9;
        r111 = r103.length();
    L9:
        r100.replace$foundation_release(r101, r102, r103, r104, r111);
        return;
    L5:
        r104 = r110;
        goto L7
    }
}
