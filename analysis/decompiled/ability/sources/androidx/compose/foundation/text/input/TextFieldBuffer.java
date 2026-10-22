package androidx.compose.foundation.text.input;

import B7.a;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.b;
import androidx.compose.foundation.text.input.internal.ChangeTracker;
import androidx.compose.foundation.text.input.internal.OffsetMappingCalculator;
import androidx.compose.foundation.text.input.internal.PartialGapBuffer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001dB3\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J;\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001c\u001a\u00060\u0001j\u0002`\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010\u001c\u001a\u00060\u0001j\u0002`\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001c\u0010\u001eJ\u001b\u0010\u001c\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b\u001c\u0010!J\u0015\u0010#\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\f¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\u000f¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\u0011¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\f¢\u0006\u0004\b,\u0010-J\u0015\u0010.\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\f¢\u0006\u0004\b.\u0010-J(\u00104\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020/2\n\b\u0002\u00101\u001a\u0004\u0018\u00010/H\u0000ø\u0001\u0000¢\u0006\u0004\b2\u00103J'\u00108\u001a\u00020\u00112\u0006\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\f2\u0006\u00107\u001a\u00020\fH\u0002¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u0011H\u0002¢\u0006\u0004\b:\u0010+J'\u0010>\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\f2\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020;H\u0002¢\u0006\u0004\b>\u0010?J\u001a\u0010C\u001a\u00020\u00112\u0006\u0010@\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\bA\u0010BR\u001a\u0010\u0007\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010D\u001a\u0004\bE\u0010FR\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010GR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010K\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u001c\u0010M\u001a\u00020/8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\bM\u0010NR\u0011\u0010Q\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0011\u0010S\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\bR\u0010)R\u0017\u0010V\u001a\u00020/8Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bT\u0010UR\u001a\u0010[\u001a\u00020W8FX\u0087\u0004¢\u0006\f\u0012\u0004\bZ\u0010+\u001a\u0004\bX\u0010YR\u0011\u0010\\\u001a\u00020;8G¢\u0006\u0006\u001a\u0004\b\\\u0010]R*\u00100\u001a\u00020/2\u0006\u0010^\u001a\u00020/8F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b_\u0010U\"\u0004\b`\u0010BR\u0014\u0010c\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\ba\u0010b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006e"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldBuffer;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "initialValue", "Landroidx/compose/foundation/text/input/internal/ChangeTracker;", "initialChanges", "originalValue", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "offsetMappingCalculator", AppAgent.CONSTRUCT, "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/internal/ChangeTracker;Landroidx/compose/foundation/text/input/TextFieldCharSequence;Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;)V", "", "start", "end", "", "text", "LC7/r;", "replace", "(IILjava/lang/CharSequence;)V", "textStart", "textEnd", "replace$foundation_release", "(IILjava/lang/CharSequence;II)V", "newText", "setTextIfChanged$foundation_release", "(Ljava/lang/CharSequence;)V", "setTextIfChanged", "append", "(Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "(Ljava/lang/CharSequence;II)Ljava/lang/Appendable;", "", "char", "(C)Ljava/lang/Appendable;", "index", "charAt", "(I)C", "", "toString", "()Ljava/lang/String;", "asCharSequence", "()Ljava/lang/CharSequence;", "revertAllChanges", "()V", "placeCursorBeforeCharAt", "(I)V", "placeCursorAfterCharAt", "Landroidx/compose/ui/text/TextRange;", "selection", "composition", "toTextFieldCharSequence-udt6zUU$foundation_release", "(JLandroidx/compose/ui/text/TextRange;)Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "toTextFieldCharSequence", "replaceStart", "replaceEnd", "newLength", "onTextWillChange", "(III)V", "clearChangeList", "", "startExclusive", "endExclusive", "requireValidIndex", "(IZZ)V", "range", "requireValidRange-5zc-tL8", "(J)V", "requireValidRange", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getOriginalValue$foundation_release", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "Landroidx/compose/foundation/text/input/internal/OffsetMappingCalculator;", "Landroidx/compose/foundation/text/input/internal/PartialGapBuffer;", "buffer", "Landroidx/compose/foundation/text/input/internal/PartialGapBuffer;", "backingChangeTracker", "Landroidx/compose/foundation/text/input/internal/ChangeTracker;", "selectionInChars", "J", "getLength", "()I", "length", "getOriginalText", "originalText", "getOriginalSelection-d9O1mEE", "()J", "originalSelection", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "getChanges", "()Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "getChanges$annotations", "changes", "hasSelection", "()Z", "value", "getSelection-d9O1mEE", "setSelection-5zc-tL8", "getChangeTracker", "()Landroidx/compose/foundation/text/input/internal/ChangeTracker;", "changeTracker", "ChangeList", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldBuffer implements Appendable {
    public static final int $stable = 8;
    private ChangeTracker backingChangeTracker;
    private final PartialGapBuffer buffer;
    private final OffsetMappingCalculator offsetMappingCalculator;
    private final TextFieldCharSequence originalValue;
    private long selectionInChars;

    @ExperimentalFoundationApi
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\nR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0002\u0082\u0002\u0011\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "", "changeCount", "", "getChangeCount", "()I", "getOriginalRange", "Landroidx/compose/ui/text/TextRange;", "changeIndex", "getOriginalRange--jx7JFs", "(I)J", "getRange", "getRange--jx7JFs", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ChangeList {
        int getChangeCount();

        /* renamed from: getOriginalRange--jx7JFs, reason: not valid java name */
        long mo1139getOriginalRangejx7JFs(int changeIndex);

        /* renamed from: getRange--jx7JFs, reason: not valid java name */
        long mo1140getRangejx7JFs(int changeIndex);
    }

    public TextFieldBuffer(TextFieldCharSequence textFieldCharSequence, ChangeTracker changeTracker, TextFieldCharSequence textFieldCharSequence2, OffsetMappingCalculator offsetMappingCalculator) {
        this.originalValue = textFieldCharSequence2;
        this.offsetMappingCalculator = offsetMappingCalculator;
        this.buffer = new PartialGapBuffer(textFieldCharSequence);
        this.backingChangeTracker = changeTracker != null ? new ChangeTracker(changeTracker) : null;
        this.selectionInChars = textFieldCharSequence.getSelection();
    }

    private final void clearChangeList() {
        getChangeTracker().clearChanges();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ChangeTracker getChangeTracker() {
        ChangeTracker changeTracker = this.backingChangeTracker;
        if (changeTracker != null) {
            return changeTracker;
        }
        ChangeTracker changeTracker2 = new ChangeTracker(null, 1, 0 == true ? 1 : 0);
        this.backingChangeTracker = changeTracker2;
        return changeTracker2;
    }

    @ExperimentalFoundationApi
    public static /* synthetic */ void getChanges$annotations() {
    }

    private final void onTextWillChange(int replaceStart, int replaceEnd, int newLength) {
        int i;
        getChangeTracker().trackChange(replaceStart, replaceEnd, newLength);
        OffsetMappingCalculator offsetMappingCalculator = this.offsetMappingCalculator;
        if (offsetMappingCalculator != null) {
            offsetMappingCalculator.recordEditOperation(replaceStart, replaceEnd, newLength);
        }
        int iMin = Math.min(replaceStart, replaceEnd);
        int iMax = Math.max(replaceStart, replaceEnd);
        int iM6309getMinimpl = TextRange.m6309getMinimpl(getSelectionInChars());
        int iM6308getMaximpl = TextRange.m6308getMaximpl(getSelectionInChars());
        if (iM6308getMaximpl < iMin) {
            return;
        }
        if (iM6309getMinimpl <= iMin && iMax <= iM6308getMaximpl) {
            i = newLength - (iMax - iMin);
            if (iM6309getMinimpl == iM6308getMaximpl) {
            }
            iMin = iM6308getMaximpl + i;
            this.selectionInChars = TextRangeKt.TextRange(iM6309getMinimpl, iMin);
        }
        if (iM6309getMinimpl > iMin && iM6308getMaximpl < iMax) {
            iMin += newLength;
            iM6309getMinimpl = iMin;
        } else if (iM6309getMinimpl >= iMax) {
            i = newLength - (iMax - iMin);
        } else if (iMin < iM6309getMinimpl) {
            iM6309getMinimpl = iMin + newLength;
            iMin = (newLength - (iMax - iMin)) + iM6308getMaximpl;
        }
        this.selectionInChars = TextRangeKt.TextRange(iM6309getMinimpl, iMin);
        iM6309getMinimpl += i;
        iMin = iM6308getMaximpl + i;
        this.selectionInChars = TextRangeKt.TextRange(iM6309getMinimpl, iMin);
    }

    public static /* synthetic */ void replace$foundation_release$default(TextFieldBuffer textFieldBuffer, int i, int i6, CharSequence charSequence, int i10, int i11, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            i10 = 0;
        }
        int i13 = i10;
        if ((i12 & 16) != 0) {
            i11 = charSequence.length();
        }
        textFieldBuffer.replace$foundation_release(i, i6, charSequence, i13, i11);
    }

    private final void requireValidIndex(int index, boolean startExclusive, boolean endExclusive) {
        int i = startExclusive ? 0 : -1;
        int length = getLength();
        if (!endExclusive) {
            length++;
        }
        if (i > index || index >= length) {
            throw new IllegalArgumentException(a.o(androidx.appfunctions.metadata.a.s(index, "Expected ", i, " to be in [", ", "), length, ')').toString());
        }
    }

    /* renamed from: requireValidRange-5zc-tL8, reason: not valid java name */
    private final void m1133requireValidRange5zctL8(long range) {
        long jTextRange = TextRangeKt.TextRange(0, getLength());
        if (TextRange.m6301contains5zctL8(jTextRange, range)) {
            return;
        }
        throw new IllegalArgumentException(("Expected " + ((Object) TextRange.m6314toStringimpl(range)) + " to be in " + ((Object) TextRange.m6314toStringimpl(jTextRange))).toString());
    }

    /* renamed from: toTextFieldCharSequence-udt6zUU$foundation_release$default, reason: not valid java name */
    public static /* synthetic */ TextFieldCharSequence m1134toTextFieldCharSequenceudt6zUU$foundation_release$default(TextFieldBuffer textFieldBuffer, long j5, TextRange textRange, int i, Object obj) {
        if ((i & 1) != 0) {
            j5 = textFieldBuffer.getSelectionInChars();
        }
        if ((i & 2) != 0) {
            textRange = null;
        }
        return textFieldBuffer.m1138toTextFieldCharSequenceudt6zUU$foundation_release(j5, textRange);
    }

    @Override // java.lang.Appendable
    public Appendable append(CharSequence text) {
        if (text != null) {
            onTextWillChange(getLength(), getLength(), text.length());
            PartialGapBuffer partialGapBuffer = this.buffer;
            PartialGapBuffer.replace$default(partialGapBuffer, partialGapBuffer.length(), this.buffer.length(), text, 0, 0, 24, null);
        }
        return this;
    }

    public final CharSequence asCharSequence() {
        return this.buffer;
    }

    public final char charAt(int index) {
        return this.buffer.charAt(index);
    }

    public final ChangeList getChanges() {
        return getChangeTracker();
    }

    public final int getLength() {
        return this.buffer.length();
    }

    /* renamed from: getOriginalSelection-d9O1mEE, reason: not valid java name */
    public final long m1135getOriginalSelectiond9O1mEE() {
        return this.originalValue.getSelection();
    }

    public final CharSequence getOriginalText() {
        return this.originalValue.getText();
    }

    /* renamed from: getOriginalValue$foundation_release, reason: from getter */
    public final TextFieldCharSequence getOriginalValue() {
        return this.originalValue;
    }

    /* renamed from: getSelection-d9O1mEE, reason: not valid java name and from getter */
    public final long getSelectionInChars() {
        return this.selectionInChars;
    }

    public final boolean hasSelection() {
        return !TextRange.m6305getCollapsedimpl(getSelectionInChars());
    }

    public final void placeCursorAfterCharAt(int index) {
        requireValidIndex(index, false, true);
        int i = index + 1;
        int length = getLength();
        if (i > length) {
            i = length;
        }
        this.selectionInChars = TextRangeKt.TextRange(i);
    }

    public final void placeCursorBeforeCharAt(int index) {
        requireValidIndex(index, true, false);
        this.selectionInChars = TextRangeKt.TextRange(index);
    }

    public final void replace(int start, int end, CharSequence text) {
        replace$foundation_release(start, end, text, 0, text.length());
    }

    public final void replace$foundation_release(int start, int end, CharSequence text, int textStart, int textEnd) {
        if (start > end) {
            throw new IllegalArgumentException(b.n(start, end, "Expected start=", " <= end=").toString());
        }
        if (textStart > textEnd) {
            throw new IllegalArgumentException(b.n(textStart, textEnd, "Expected textStart=", " <= textEnd=").toString());
        }
        onTextWillChange(start, end, textEnd - textStart);
        this.buffer.replace(start, end, text, textStart, textEnd);
    }

    public final void revertAllChanges() {
        replace(0, getLength(), this.originalValue.toString());
        m1137setSelection5zctL8(this.originalValue.getSelection());
        clearChangeList();
    }

    /* renamed from: setSelection-5zc-tL8, reason: not valid java name */
    public final void m1137setSelection5zctL8(long j5) {
        m1133requireValidRange5zctL8(j5);
        this.selectionInChars = j5;
    }

    public final void setTextIfChanged$foundation_release(CharSequence newText) {
        int i;
        int i6;
        PartialGapBuffer partialGapBuffer = this.buffer;
        int length = partialGapBuffer.length();
        int length2 = newText.length();
        boolean z10 = false;
        if (partialGapBuffer.length() <= 0 || newText.length() <= 0) {
            i = 0;
            i6 = 0;
        } else {
            int i10 = 0;
            int i11 = 0;
            boolean z11 = false;
            while (true) {
                if (!z10) {
                    if (partialGapBuffer.charAt(i10) == newText.charAt(i11)) {
                        i10++;
                        i11++;
                    } else {
                        z10 = true;
                    }
                }
                if (!z11) {
                    if (partialGapBuffer.charAt(length - 1) == newText.charAt(length2 - 1)) {
                        length--;
                        length2--;
                    } else {
                        z11 = true;
                    }
                }
                if (i10 >= length || i11 >= length2 || (z10 && z11)) {
                    break;
                }
            }
            i = i10;
            i6 = i11;
        }
        int i12 = length;
        int i13 = length2;
        if (i < i12 || i6 < i13) {
            replace$foundation_release(i, i12, newText, i6, i13);
        }
    }

    public String toString() {
        return this.buffer.toString();
    }

    /* renamed from: toTextFieldCharSequence-udt6zUU$foundation_release, reason: not valid java name */
    public final TextFieldCharSequence m1138toTextFieldCharSequenceudt6zUU$foundation_release(long selection, TextRange composition) {
        return new TextFieldCharSequence(this.buffer.toString(), selection, composition, null, 8, null);
    }

    @Override // java.lang.Appendable
    public Appendable append(CharSequence text, int start, int end) {
        if (text != null) {
            onTextWillChange(getLength(), getLength(), end - start);
            PartialGapBuffer partialGapBuffer = this.buffer;
            PartialGapBuffer.replace$default(partialGapBuffer, partialGapBuffer.length(), this.buffer.length(), text.subSequence(start, end), 0, 0, 24, null);
        }
        return this;
    }

    @Override // java.lang.Appendable
    public Appendable append(char c) {
        onTextWillChange(getLength(), getLength(), 1);
        PartialGapBuffer partialGapBuffer = this.buffer;
        PartialGapBuffer.replace$default(partialGapBuffer, partialGapBuffer.length(), this.buffer.length(), String.valueOf(c), 0, 0, 24, null);
        return this;
    }

    public /* synthetic */ TextFieldBuffer(TextFieldCharSequence textFieldCharSequence, ChangeTracker changeTracker, TextFieldCharSequence textFieldCharSequence2, OffsetMappingCalculator offsetMappingCalculator, int i, e eVar) {
        this(textFieldCharSequence, (i & 2) != 0 ? null : changeTracker, (i & 4) != 0 ? textFieldCharSequence : textFieldCharSequence2, (i & 8) != 0 ? null : offsetMappingCalculator);
    }
}
