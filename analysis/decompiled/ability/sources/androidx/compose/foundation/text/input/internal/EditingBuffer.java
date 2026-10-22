package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.TextHighlightType;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.Pair;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0000\u0018\u0000 P2\u00020\u0001:\u0001PB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\b\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b\u001a\u0010\u0019J(\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u0015¢\u0006\u0004\b \u0010!J\u001d\u0010\"\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b\"\u0010\u0019J\r\u0010#\u001a\u00020\u0015¢\u0006\u0004\b#\u0010!J\u000f\u0010$\u001a\u00020\bH\u0016¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'J\u001f\u0010(\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0002¢\u0006\u0004\b(\u0010\u0019R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0017\u0010-\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R*\u00102\u001a\u00020\r2\u0006\u00101\u001a\u00020\r8\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R*\u00108\u001a\u00020\r2\u0006\u00101\u001a\u00020\r8\u0006@BX\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00103\u001a\u0004\b9\u00105\"\u0004\b:\u00107R0\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b\u001f\u0010@R$\u0010B\u001a\u00020\r2\u0006\u0010A\u001a\u00020\r8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bB\u00103\u001a\u0004\bC\u00105R$\u0010D\u001a\u00020\r2\u0006\u0010A\u001a\u00020\r8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bD\u00103\u001a\u0004\bE\u00105R\u0019\u0010H\u001a\u0004\u0018\u00010\u00048Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0017\u0010\u0005\u001a\u00020\u00048Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bI\u0010JR$\u0010K\u001a\u00020\r2\u0006\u0010K\u001a\u00020\r8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bL\u00105\"\u0004\bM\u00107R\u0011\u0010O\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\bN\u00105\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Q"}, d2 = {"Landroidx/compose/foundation/text/input/internal/EditingBuffer;", "", "Landroidx/compose/ui/text/AnnotatedString;", "text", "Landroidx/compose/ui/text/TextRange;", "selection", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/text/AnnotatedString;JLkotlin/jvm/internal/e;)V", "", "(Ljava/lang/String;JLkotlin/jvm/internal/e;)V", "", "hasComposition", "()Z", "", "index", "", "get", "(I)C", "start", "end", "", "LC7/r;", "replace", "(IILjava/lang/CharSequence;)V", "delete", "(II)V", "setSelection", "Landroidx/compose/foundation/text/input/TextHighlightType;", "type", "setHighlight-K7f2yys", "(III)V", "setHighlight", "clearHighlight", "()V", "setComposition", "commitComposition", "toString", "()Ljava/lang/String;", "toAnnotatedString", "()Landroidx/compose/ui/text/AnnotatedString;", "checkRange", "Landroidx/compose/foundation/text/input/internal/PartialGapBuffer;", "gapBuffer", "Landroidx/compose/foundation/text/input/internal/PartialGapBuffer;", "Landroidx/compose/foundation/text/input/internal/ChangeTracker;", "changeTracker", "Landroidx/compose/foundation/text/input/internal/ChangeTracker;", "getChangeTracker", "()Landroidx/compose/foundation/text/input/internal/ChangeTracker;", "value", "selectionStart", "I", "getSelectionStart", "()I", "setSelectionStart", "(I)V", "selectionEnd", "getSelectionEnd", "setSelectionEnd", "Lkotlin/Pair;", "highlight", "Lkotlin/Pair;", "getHighlight", "()Lkotlin/Pair;", "(Lkotlin/Pair;)V", "<set-?>", "compositionStart", "getCompositionStart", "compositionEnd", "getCompositionEnd", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "composition", "getSelection-d9O1mEE", "()J", "cursor", "getCursor", "setCursor", "getLength", "length", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EditingBuffer {
    public static final int NOWHERE = -1;
    private final ChangeTracker changeTracker;
    private int compositionEnd;
    private int compositionStart;
    private final PartialGapBuffer gapBuffer;
    private Pair<TextHighlightType, TextRange> highlight;
    private int selectionEnd;
    private int selectionStart;
    public static final int $stable = 8;

    public /* synthetic */ EditingBuffer(AnnotatedString annotatedString, long j5, kotlin.jvm.internal.e eVar) {
        this(annotatedString, j5);
    }

    private final void checkRange(int start, int end) {
        if (start < 0 || start > this.gapBuffer.length()) {
            StringBuilder sbU = B7.a.u(start, "start (", ") offset is outside of text region ");
            sbU.append(this.gapBuffer.length());
            throw new IndexOutOfBoundsException(sbU.toString());
        }
        if (end < 0 || end > this.gapBuffer.length()) {
            StringBuilder sbU2 = B7.a.u(end, "end (", ") offset is outside of text region ");
            sbU2.append(this.gapBuffer.length());
            throw new IndexOutOfBoundsException(sbU2.toString());
        }
    }

    private final void setSelectionEnd(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(B7.a.h(i, "Cannot set selectionEnd to a negative value: ").toString());
        }
        this.selectionEnd = i;
        this.highlight = null;
    }

    private final void setSelectionStart(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(B7.a.h(i, "Cannot set selectionStart to a negative value: ").toString());
        }
        this.selectionStart = i;
        this.highlight = null;
    }

    public final void clearHighlight() {
        this.highlight = null;
    }

    public final void commitComposition() {
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public final void delete(int start, int end) {
        checkRange(start, end);
        long jTextRange = TextRangeKt.TextRange(start, end);
        this.changeTracker.trackChange(start, end, 0);
        PartialGapBuffer.replace$default(this.gapBuffer, TextRange.m6309getMinimpl(jTextRange), TextRange.m6308getMaximpl(jTextRange), "", 0, 0, 24, null);
        long jM1175updateRangeAfterDeletepWDy79M = EditingBufferKt.m1175updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.selectionStart, this.selectionEnd), jTextRange);
        setSelectionStart(TextRange.m6311getStartimpl(jM1175updateRangeAfterDeletepWDy79M));
        setSelectionEnd(TextRange.m6306getEndimpl(jM1175updateRangeAfterDeletepWDy79M));
        if (hasComposition()) {
            long jM1175updateRangeAfterDeletepWDy79M2 = EditingBufferKt.m1175updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd), jTextRange);
            if (TextRange.m6305getCollapsedimpl(jM1175updateRangeAfterDeletepWDy79M2)) {
                commitComposition();
            } else {
                this.compositionStart = TextRange.m6309getMinimpl(jM1175updateRangeAfterDeletepWDy79M2);
                this.compositionEnd = TextRange.m6308getMaximpl(jM1175updateRangeAfterDeletepWDy79M2);
            }
        }
        this.highlight = null;
    }

    public final char get(int index) {
        return this.gapBuffer.charAt(index);
    }

    public final ChangeTracker getChangeTracker() {
        return this.changeTracker;
    }

    /* renamed from: getComposition-MzsxiRA, reason: not valid java name */
    public final TextRange m1172getCompositionMzsxiRA() {
        if (hasComposition()) {
            return TextRange.m6299boximpl(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd));
        }
        return null;
    }

    public final int getCompositionEnd() {
        return this.compositionEnd;
    }

    public final int getCompositionStart() {
        return this.compositionStart;
    }

    public final int getCursor() {
        int i = this.selectionStart;
        int i6 = this.selectionEnd;
        if (i == i6) {
            return i6;
        }
        return -1;
    }

    public final Pair<TextHighlightType, TextRange> getHighlight() {
        return this.highlight;
    }

    public final int getLength() {
        return this.gapBuffer.length();
    }

    /* renamed from: getSelection-d9O1mEE, reason: not valid java name */
    public final long m1173getSelectiond9O1mEE() {
        return TextRangeKt.TextRange(this.selectionStart, this.selectionEnd);
    }

    public final int getSelectionEnd() {
        return this.selectionEnd;
    }

    public final int getSelectionStart() {
        return this.selectionStart;
    }

    public final boolean hasComposition() {
        return this.compositionStart != -1;
    }

    public final void replace(int start, int end, CharSequence text) {
        checkRange(start, end);
        int iMin = Math.min(start, end);
        int iMax = Math.max(start, end);
        int i = 0;
        int i6 = iMin;
        while (i6 < iMax && i < text.length() && text.charAt(i) == this.gapBuffer.charAt(i6)) {
            i++;
            i6++;
        }
        int length = text.length();
        int i10 = iMax;
        while (i10 > iMin && length > i && text.charAt(length - 1) == this.gapBuffer.charAt(i10 - 1)) {
            length--;
            i10--;
        }
        this.changeTracker.trackChange(i6, i10, length - i);
        PartialGapBuffer.replace$default(this.gapBuffer, iMin, iMax, text, 0, 0, 24, null);
        setSelectionStart(text.length() + iMin);
        setSelectionEnd(text.length() + iMin);
        this.compositionStart = -1;
        this.compositionEnd = -1;
        this.highlight = null;
    }

    public final void setComposition(int start, int end) {
        if (start < 0 || start > this.gapBuffer.length()) {
            StringBuilder sbU = B7.a.u(start, "start (", ") offset is outside of text region ");
            sbU.append(this.gapBuffer.length());
            throw new IndexOutOfBoundsException(sbU.toString());
        }
        if (end < 0 || end > this.gapBuffer.length()) {
            StringBuilder sbU2 = B7.a.u(end, "end (", ") offset is outside of text region ");
            sbU2.append(this.gapBuffer.length());
            throw new IndexOutOfBoundsException(sbU2.toString());
        }
        if (start >= end) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.n(start, end, "Do not set reversed or empty range: ", " > "));
        }
        this.compositionStart = start;
        this.compositionEnd = end;
    }

    public final void setCursor(int i) {
        setSelection(i, i);
    }

    public final void setHighlight(Pair<TextHighlightType, TextRange> pair) {
        this.highlight = pair;
    }

    /* renamed from: setHighlight-K7f2yys, reason: not valid java name */
    public final void m1174setHighlightK7f2yys(int type, int start, int end) {
        if (start >= end) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.n(start, end, "Do not set reversed or empty range: ", " > "));
        }
        this.highlight = new Pair<>(TextHighlightType.m1147boximpl(type), TextRange.m6299boximpl(TextRangeKt.TextRange(AbstractC1451a.u(start, 0, getLength()), AbstractC1451a.u(end, 0, getLength()))));
    }

    public final void setSelection(int start, int end) {
        int iU = AbstractC1451a.u(start, 0, getLength());
        int iU2 = AbstractC1451a.u(end, 0, getLength());
        setSelectionStart(iU);
        setSelectionEnd(iU2);
    }

    public final AnnotatedString toAnnotatedString() {
        return new AnnotatedString(toString(), null, null, 6, null);
    }

    public String toString() {
        return this.gapBuffer.toString();
    }

    public /* synthetic */ EditingBuffer(String str, long j5, kotlin.jvm.internal.e eVar) {
        this(str, j5);
    }

    private EditingBuffer(AnnotatedString annotatedString, long j5) {
        this.gapBuffer = new PartialGapBuffer(annotatedString.getText());
        this.changeTracker = new ChangeTracker(null, 1, null);
        this.selectionStart = TextRange.m6311getStartimpl(j5);
        this.selectionEnd = TextRange.m6306getEndimpl(j5);
        this.compositionStart = -1;
        this.compositionEnd = -1;
        checkRange(TextRange.m6311getStartimpl(j5), TextRange.m6306getEndimpl(j5));
    }

    private EditingBuffer(String str, long j5) {
        this(new AnnotatedString(str, null, null, 6, null), j5, (kotlin.jvm.internal.e) null);
    }
}
