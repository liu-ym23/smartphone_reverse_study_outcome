package androidx.compose.ui.text.input;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0007\u0018\u0000 G2\u00020\u0001:\u0001GB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\b\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\tJ\u000f\u0010\r\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0080\u0002¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0017\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u001e\u0010\u001cJ\u001f\u0010!\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0000¢\u0006\u0004\b \u0010\u001cJ\u000f\u0010$\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\"\u0010#J\u000f\u0010&\u001a\u00020\u0016H\u0000¢\u0006\u0004\b%\u0010#J\u000f\u0010'\u001a\u00020\bH\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010+\u001a\u00020\u0002H\u0000¢\u0006\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R*\u00100\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000e8\u0000@BX\u0080\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R*\u00106\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000e8\u0000@BX\u0080\u000e¢\u0006\u0012\n\u0004\b6\u00101\u001a\u0004\b7\u00103\"\u0004\b8\u00105R$\u00109\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000e8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b9\u00101\u001a\u0004\b:\u00103R$\u0010;\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000e8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b;\u00101\u001a\u0004\b<\u00103R\u0016\u0010?\u001a\u0004\u0018\u00010\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010\u0005\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR$\u0010B\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u000e8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\bC\u00103\"\u0004\bD\u00105R\u0014\u0010F\u001a\u00020\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bE\u00103¨\u0006H"}, d2 = {"Landroidx/compose/ui/text/input/EditingBuffer;", "", "Landroidx/compose/ui/text/AnnotatedString;", "text", "Landroidx/compose/ui/text/TextRange;", "selection", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/text/AnnotatedString;JLkotlin/jvm/internal/e;)V", "", "(Ljava/lang/String;JLkotlin/jvm/internal/e;)V", "", "hasComposition$ui_text", "()Z", "hasComposition", "", "index", "", "get$ui_text", "(I)C", "get", "start", "end", "LC7/r;", "replace$ui_text", "(IILandroidx/compose/ui/text/AnnotatedString;)V", "replace", "(IILjava/lang/String;)V", "delete$ui_text", "(II)V", "delete", "setSelection$ui_text", "setSelection", "setComposition$ui_text", "setComposition", "cancelComposition$ui_text", "()V", "cancelComposition", "commitComposition$ui_text", "commitComposition", "toString", "()Ljava/lang/String;", "toAnnotatedString$ui_text", "()Landroidx/compose/ui/text/AnnotatedString;", "toAnnotatedString", "Landroidx/compose/ui/text/input/PartialGapBuffer;", "gapBuffer", "Landroidx/compose/ui/text/input/PartialGapBuffer;", "value", "selectionStart", "I", "getSelectionStart$ui_text", "()I", "setSelectionStart", "(I)V", "selectionEnd", "getSelectionEnd$ui_text", "setSelectionEnd", "compositionStart", "getCompositionStart$ui_text", "compositionEnd", "getCompositionEnd$ui_text", "getComposition-MzsxiRA$ui_text", "()Landroidx/compose/ui/text/TextRange;", "composition", "getSelection-d9O1mEE$ui_text", "()J", "cursor", "getCursor$ui_text", "setCursor$ui_text", "getLength$ui_text", "length", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EditingBuffer {
    public static final int NOWHERE = -1;
    private int compositionEnd;
    private int compositionStart;
    private final PartialGapBuffer gapBuffer;
    private int selectionEnd;
    private int selectionStart;
    public static final int $stable = 8;

    public /* synthetic */ EditingBuffer(AnnotatedString annotatedString, long j5, e eVar) {
        this(annotatedString, j5);
    }

    private final void setSelectionEnd(int i) {
        if (!(i >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot set selectionEnd to a negative value: " + i);
        }
        this.selectionEnd = i;
    }

    private final void setSelectionStart(int i) {
        if (!(i >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot set selectionStart to a negative value: " + i);
        }
        this.selectionStart = i;
    }

    public final void cancelComposition$ui_text() {
        replace$ui_text(this.compositionStart, this.compositionEnd, "");
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public final void commitComposition$ui_text() {
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public final void delete$ui_text(int start, int end) {
        long jTextRange = TextRangeKt.TextRange(start, end);
        this.gapBuffer.replace(start, end, "");
        long jM6473updateRangeAfterDeletepWDy79M = EditingBufferKt.m6473updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.selectionStart, this.selectionEnd), jTextRange);
        setSelectionStart(TextRange.m6309getMinimpl(jM6473updateRangeAfterDeletepWDy79M));
        setSelectionEnd(TextRange.m6308getMaximpl(jM6473updateRangeAfterDeletepWDy79M));
        if (hasComposition$ui_text()) {
            long jM6473updateRangeAfterDeletepWDy79M2 = EditingBufferKt.m6473updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd), jTextRange);
            if (TextRange.m6305getCollapsedimpl(jM6473updateRangeAfterDeletepWDy79M2)) {
                commitComposition$ui_text();
            } else {
                this.compositionStart = TextRange.m6309getMinimpl(jM6473updateRangeAfterDeletepWDy79M2);
                this.compositionEnd = TextRange.m6308getMaximpl(jM6473updateRangeAfterDeletepWDy79M2);
            }
        }
    }

    public final char get$ui_text(int index) {
        return this.gapBuffer.get(index);
    }

    /* renamed from: getComposition-MzsxiRA$ui_text, reason: not valid java name */
    public final TextRange m6471getCompositionMzsxiRA$ui_text() {
        if (hasComposition$ui_text()) {
            return TextRange.m6299boximpl(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd));
        }
        return null;
    }

    /* renamed from: getCompositionEnd$ui_text, reason: from getter */
    public final int getCompositionEnd() {
        return this.compositionEnd;
    }

    /* renamed from: getCompositionStart$ui_text, reason: from getter */
    public final int getCompositionStart() {
        return this.compositionStart;
    }

    public final int getCursor$ui_text() {
        int i = this.selectionStart;
        int i6 = this.selectionEnd;
        if (i == i6) {
            return i6;
        }
        return -1;
    }

    public final int getLength$ui_text() {
        return this.gapBuffer.getLength();
    }

    /* renamed from: getSelection-d9O1mEE$ui_text, reason: not valid java name */
    public final long m6472getSelectiond9O1mEE$ui_text() {
        return TextRangeKt.TextRange(this.selectionStart, this.selectionEnd);
    }

    /* renamed from: getSelectionEnd$ui_text, reason: from getter */
    public final int getSelectionEnd() {
        return this.selectionEnd;
    }

    /* renamed from: getSelectionStart$ui_text, reason: from getter */
    public final int getSelectionStart() {
        return this.selectionStart;
    }

    public final boolean hasComposition$ui_text() {
        return this.compositionStart != -1;
    }

    public final void replace$ui_text(int start, int end, AnnotatedString text) {
        replace$ui_text(start, end, text.getText());
    }

    public final void setComposition$ui_text(int start, int end) {
        if (start < 0 || start > this.gapBuffer.getLength()) {
            StringBuilder sbU = B7.a.u(start, "start (", ") offset is outside of text region ");
            sbU.append(this.gapBuffer.getLength());
            throw new IndexOutOfBoundsException(sbU.toString());
        }
        if (end < 0 || end > this.gapBuffer.getLength()) {
            StringBuilder sbU2 = B7.a.u(end, "end (", ") offset is outside of text region ");
            sbU2.append(this.gapBuffer.getLength());
            throw new IndexOutOfBoundsException(sbU2.toString());
        }
        if (start >= end) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.n(start, end, "Do not set reversed or empty range: ", " > "));
        }
        this.compositionStart = start;
        this.compositionEnd = end;
    }

    public final void setCursor$ui_text(int i) {
        setSelection$ui_text(i, i);
    }

    public final void setSelection$ui_text(int start, int end) {
        if (start < 0 || start > this.gapBuffer.getLength()) {
            StringBuilder sbU = B7.a.u(start, "start (", ") offset is outside of text region ");
            sbU.append(this.gapBuffer.getLength());
            throw new IndexOutOfBoundsException(sbU.toString());
        }
        if (end < 0 || end > this.gapBuffer.getLength()) {
            StringBuilder sbU2 = B7.a.u(end, "end (", ") offset is outside of text region ");
            sbU2.append(this.gapBuffer.getLength());
            throw new IndexOutOfBoundsException(sbU2.toString());
        }
        if (start > end) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.n(start, end, "Do not set reversed range: ", " > "));
        }
        setSelectionStart(start);
        setSelectionEnd(end);
    }

    public final AnnotatedString toAnnotatedString$ui_text() {
        return new AnnotatedString(toString(), null, 2, null);
    }

    public String toString() {
        return this.gapBuffer.toString();
    }

    public /* synthetic */ EditingBuffer(String str, long j5, e eVar) {
        this(str, j5);
    }

    public final void replace$ui_text(int start, int end, String text) {
        if (start < 0 || start > this.gapBuffer.getLength()) {
            StringBuilder sbU = B7.a.u(start, "start (", ") offset is outside of text region ");
            sbU.append(this.gapBuffer.getLength());
            throw new IndexOutOfBoundsException(sbU.toString());
        }
        if (end < 0 || end > this.gapBuffer.getLength()) {
            StringBuilder sbU2 = B7.a.u(end, "end (", ") offset is outside of text region ");
            sbU2.append(this.gapBuffer.getLength());
            throw new IndexOutOfBoundsException(sbU2.toString());
        }
        if (start > end) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.n(start, end, "Do not set reversed range: ", " > "));
        }
        this.gapBuffer.replace(start, end, text);
        setSelectionStart(text.length() + start);
        setSelectionEnd(text.length() + start);
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    private EditingBuffer(AnnotatedString annotatedString, long j5) {
        this.gapBuffer = new PartialGapBuffer(annotatedString.getText());
        this.selectionStart = TextRange.m6309getMinimpl(j5);
        this.selectionEnd = TextRange.m6308getMaximpl(j5);
        this.compositionStart = -1;
        this.compositionEnd = -1;
        int iM6309getMinimpl = TextRange.m6309getMinimpl(j5);
        int iM6308getMaximpl = TextRange.m6308getMaximpl(j5);
        if (iM6309getMinimpl >= 0 && iM6309getMinimpl <= annotatedString.length()) {
            if (iM6308getMaximpl < 0 || iM6308getMaximpl > annotatedString.length()) {
                StringBuilder sbU = B7.a.u(iM6308getMaximpl, "end (", ") offset is outside of text region ");
                sbU.append(annotatedString.length());
                throw new IndexOutOfBoundsException(sbU.toString());
            }
            if (iM6309getMinimpl > iM6308getMaximpl) {
                throw new IllegalArgumentException(androidx.compose.foundation.b.n(iM6309getMinimpl, iM6308getMaximpl, "Do not set reversed range: ", " > "));
            }
            return;
        }
        StringBuilder sbU2 = B7.a.u(iM6309getMinimpl, "start (", ") offset is outside of text region ");
        sbU2.append(annotatedString.length());
        throw new IndexOutOfBoundsException(sbU2.toString());
    }

    private EditingBuffer(String str, long j5) {
        this(new AnnotatedString(str, null, 2, null), j5, (e) null);
    }
}
