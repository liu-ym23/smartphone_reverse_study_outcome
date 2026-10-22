package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001=B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\tJ\r\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001cJ\u0016\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\rH\u0080\u0002¢\u0006\u0002\b(J%\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\b/J%\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\bH\u0000¢\u0006\u0002\b/J\u001d\u00100\u001a\u00020,2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\rH\u0000¢\u0006\u0002\b1J\u001d\u00102\u001a\u00020,2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\rH\u0000¢\u0006\u0002\b3J\u001d\u00104\u001a\u00020,2\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\rH\u0000¢\u0006\u0002\b5J\r\u00106\u001a\u00020,H\u0000¢\u0006\u0002\b7J\r\u00108\u001a\u00020,H\u0000¢\u0006\u0002\b9J\b\u0010:\u001a\u00020\bH\u0016J\r\u0010;\u001a\u00020\u0003H\u0000¢\u0006\u0002\b<R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001e\u0010\u0016\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u001e\u0010\u0018\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0004\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R$\u0010\"\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\r8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u0014\u0010)\u001a\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0010¨\u0006>"}, d2 = {"Landroidx/compose/ui/text/input/EditingBuffer;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "selection", "Landroidx/compose/ui/text/TextRange;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "gapBuffer", "Landroidx/compose/ui/text/input/PartialGapBuffer;", "value", "", "selectionStart", "getSelectionStart$ui_text", "()I", "setSelectionStart", "(I)V", "selectionEnd", "getSelectionEnd$ui_text", "setSelectionEnd", "compositionStart", "getCompositionStart$ui_text", "compositionEnd", "getCompositionEnd$ui_text", "hasComposition", "", "hasComposition$ui_text", "composition", "getComposition-MzsxiRA$ui_text", "()Landroidx/compose/ui/text/TextRange;", "getSelection-d9O1mEE$ui_text", "()J", EffectConfiguration.KEY_CURSOR, "getCursor$ui_text", "setCursor$ui_text", MonitorConstants.CONNECT_TYPE_GET, "", "index", "get$ui_text", "length", "getLength$ui_text", "replace", "", "start", "end", "replace$ui_text", "delete", "delete$ui_text", "setSelection", "setSelection$ui_text", "setComposition", "setComposition$ui_text", "cancelComposition", "cancelComposition$ui_text", "commitComposition", "commitComposition$ui_text", "toString", "toAnnotatedString", "toAnnotatedString$ui_text", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EditingBuffer {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final int NOWHERE = -1;
    private int compositionEnd;
    private int compositionStart;
    private final PartialGapBuffer gapBuffer;
    private int selectionEnd;
    private int selectionStart;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/text/input/EditingBuffer$Companion;", "", "<init>", "()V", "NOWHERE", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public /* synthetic */ EditingBuffer(AnnotatedString r100, long r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    public /* synthetic */ EditingBuffer(String r100, long r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    public final void commitComposition$ui_text() {
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public final void cancelComposition$ui_text() {
        replace$ui_text(this.compositionStart, this.compositionEnd, "");
        this.compositionStart = -1;
        this.compositionEnd = -1;
    }

    public final int getCursor$ui_text() {
        int r100 = this.selectionStart;
        int r101 = this.selectionEnd;
        if (r100 == r101) goto L7;
        return -1;
    L7:
        return r101;
    }

    public final int getLength$ui_text() {
        return this.gapBuffer.getLength();
    }

    /* JADX INFO: renamed from: getSelection-d9O1mEE$ui_text, reason: not valid java name */
    public final long m7162getSelectiond9O1mEE$ui_text() {
        return TextRangeKt.TextRange(this.selectionStart, this.selectionEnd);
    }

    public final boolean hasComposition$ui_text() {
        if (this.compositionStart == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final AnnotatedString toAnnotatedString$ui_text() {
        return new AnnotatedString(toString(), null, 2, 0 == true ? 1 : 0);
    }

    public String toString() {
        return this.gapBuffer.toString();
    }

    /* JADX INFO: renamed from: getComposition-MzsxiRA$ui_text, reason: not valid java name */
    public final TextRange m7161getCompositionMzsxiRA$ui_text() {
        if (hasComposition$ui_text() == true) goto L7;
        return null;
    L7:
        return TextRange.m6986boximpl(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd));
    }

    public final int getCompositionEnd$ui_text() {
        return this.compositionEnd;
    }

    public final int getCompositionStart$ui_text() {
        return this.compositionStart;
    }

    public final int getSelectionEnd$ui_text() {
        return this.selectionEnd;
    }

    public final int getSelectionStart$ui_text() {
        return this.selectionStart;
    }

    private final void setSelectionEnd(int r100) {
        if (r100 < 0) goto L4;
        boolean r101 = true;
    L5:
        if (r101 == true) goto L7;
        InlineClassHelperKt.throwIllegalArgumentException("Cannot set selectionEnd to a negative value: " + r100);
    L7:
        this.selectionEnd = r100;
        return;
    L4:
        r101 = false;
        goto L5
    }

    private final void setSelectionStart(int r100) {
        if (r100 < 0) goto L4;
        boolean r101 = true;
    L5:
        if (r101 == true) goto L7;
        InlineClassHelperKt.throwIllegalArgumentException("Cannot set selectionStart to a negative value: " + r100);
    L7:
        this.selectionStart = r100;
        return;
    L4:
        r101 = false;
        goto L5
    }

    public final char get$ui_text(int r100) {
        return this.gapBuffer.get(r100);
    }

    public final void setCursor$ui_text(int r100) {
        setSelection$ui_text(r100, r100);
    }

    private EditingBuffer(AnnotatedString r100, long r101) {
        this.gapBuffer = new PartialGapBuffer(r100.getText());
        this.selectionStart = TextRange.m6996getMinimpl(r101);
        this.selectionEnd = TextRange.m6995getMaximpl(r101);
        this.compositionStart = -1;
        this.compositionEnd = -1;
        int r102 = TextRange.m6996getMinimpl(r101);
        int r103 = TextRange.m6995getMaximpl(r101);
        if (r102 < 0) goto L16;
        if (r102 > r100.length()) goto L16;
        if (r103 < 0) goto L14;
        if (r103 > r100.length()) goto L14;
        if (r102 > r103) goto L12;
        return;
    L12:
        throw new IllegalArgumentException("Do not set reversed range: " + r102 + " > " + r103);
    L14:
        throw new IndexOutOfBoundsException("end (" + r103 + ") offset is outside of text region " + r100.length());
    L16:
        throw new IndexOutOfBoundsException("start (" + r102 + ") offset is outside of text region " + r100.length());
    }

    public final void delete$ui_text(int r100, int r101) {
        long r102 = TextRangeKt.TextRange(r100, r101);
        this.gapBuffer.replace(r100, r101, "");
        long r103 = EditingBufferKt.m7163updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.selectionStart, this.selectionEnd), r102);
        setSelectionStart(TextRange.m6996getMinimpl(r103));
        setSelectionEnd(TextRange.m6995getMaximpl(r103));
        if (hasComposition$ui_text() == false) goto L9;
        long r104 = EditingBufferKt.m7163updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.compositionStart, this.compositionEnd), r102);
        if (TextRange.m6992getCollapsedimpl(r104) == false) goto L7;
        commitComposition$ui_text();
        return;
    L7:
        this.compositionStart = TextRange.m6996getMinimpl(r104);
        this.compositionEnd = TextRange.m6995getMaximpl(r104);
        return;
    }

    public final void setComposition$ui_text(int r100, int r101) {
        if (r100 < 0) goto L17;
        if (r100 > this.gapBuffer.getLength()) goto L17;
        if (r101 < 0) goto L15;
        if (r101 > this.gapBuffer.getLength()) goto L15;
        if (r100 >= r101) goto L13;
        this.compositionStart = r100;
        this.compositionEnd = r101;
        return;
    L13:
        throw new IllegalArgumentException("Do not set reversed or empty range: " + r100 + " > " + r101);
    L15:
        throw new IndexOutOfBoundsException("end (" + r101 + ") offset is outside of text region " + this.gapBuffer.getLength());
    L17:
        throw new IndexOutOfBoundsException("start (" + r100 + ") offset is outside of text region " + this.gapBuffer.getLength());
    }

    public final void setSelection$ui_text(int r100, int r101) {
        if (r100 < 0) goto L17;
        if (r100 > this.gapBuffer.getLength()) goto L17;
        if (r101 < 0) goto L15;
        if (r101 > this.gapBuffer.getLength()) goto L15;
        if (r100 > r101) goto L13;
        setSelectionStart(r100);
        setSelectionEnd(r101);
        return;
    L13:
        throw new IllegalArgumentException("Do not set reversed range: " + r100 + " > " + r101);
    L15:
        throw new IndexOutOfBoundsException("end (" + r101 + ") offset is outside of text region " + this.gapBuffer.getLength());
    L17:
        throw new IndexOutOfBoundsException("start (" + r100 + ") offset is outside of text region " + this.gapBuffer.getLength());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private EditingBuffer(String r100, long r101) {
        List r102 = null;
        this(new AnnotatedString(r100, r102, 2, 0 == true ? 1 : 0), r101, 0 == true ? 1 : 0);
    }

    public final void replace$ui_text(int r100, int r101, String r102) {
        if (r100 < 0) goto L17;
        if (r100 > this.gapBuffer.getLength()) goto L17;
        if (r101 < 0) goto L15;
        if (r101 > this.gapBuffer.getLength()) goto L15;
        if (r100 > r101) goto L13;
        this.gapBuffer.replace(r100, r101, r102);
        setSelectionStart(r102.length() + r100);
        setSelectionEnd(r100 + r102.length());
        this.compositionStart = -1;
        this.compositionEnd = -1;
        return;
    L13:
        throw new IllegalArgumentException("Do not set reversed range: " + r100 + " > " + r101);
    L15:
        throw new IndexOutOfBoundsException("end (" + r101 + ") offset is outside of text region " + this.gapBuffer.getLength());
    L17:
        throw new IndexOutOfBoundsException("start (" + r100 + ") offset is outside of text region " + this.gapBuffer.getLength());
    }

    public final void replace$ui_text(int r100, int r101, AnnotatedString r102) {
        replace$ui_text(r100, r101, r102.getText());
    }
}
