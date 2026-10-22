package androidx.compose.foundation.text.input.internal.selection;

import S7.a;
import S7.k;
import androidx.compose.foundation.b;
import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u0000 `2\u00020\u0001:\u0001`B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ \u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eH\u0086\b¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0000¢\u0006\u0004\b\u0016\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0000¢\u0006\u0004\b\u0017\u0010\u0015J\r\u0010\u0018\u001a\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0015J\r\u0010\u0019\u001a\u00020\u0000¢\u0006\u0004\b\u0019\u0010\u0015J\r\u0010\u001a\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u0015J!\u0010\u001d\u001a\u00020\u00002\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00110\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u001f\u001a\u00020\u00002\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00110\u001b¢\u0006\u0004\b\u001f\u0010\u001eJ\r\u0010!\u001a\u00020 ¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020 ¢\u0006\u0004\b#\u0010\"J\r\u0010$\u001a\u00020\u0000¢\u0006\u0004\b$\u0010\u0015J\r\u0010%\u001a\u00020\u0000¢\u0006\u0004\b%\u0010\u0015J\r\u0010&\u001a\u00020\u0000¢\u0006\u0004\b&\u0010\u0015J\r\u0010'\u001a\u00020\u0000¢\u0006\u0004\b'\u0010\u0015J\r\u0010(\u001a\u00020 ¢\u0006\u0004\b(\u0010\"J\r\u0010)\u001a\u00020 ¢\u0006\u0004\b)\u0010\"J\r\u0010*\u001a\u00020\u0000¢\u0006\u0004\b*\u0010\u0015J\r\u0010+\u001a\u00020\u0000¢\u0006\u0004\b+\u0010\u0015J\r\u0010,\u001a\u00020\u0000¢\u0006\u0004\b,\u0010\u0015J\r\u0010-\u001a\u00020\u0000¢\u0006\u0004\b-\u0010\u0015J\r\u0010.\u001a\u00020 ¢\u0006\u0004\b.\u0010\"J\r\u0010/\u001a\u00020\u0000¢\u0006\u0004\b/\u0010\u0015J\r\u00100\u001a\u00020 ¢\u0006\u0004\b0\u0010\"J\r\u00101\u001a\u00020\u0000¢\u0006\u0004\b1\u0010\u0015J\r\u00102\u001a\u00020\u0000¢\u0006\u0004\b2\u0010\u0015J\r\u00103\u001a\u00020\u0000¢\u0006\u0004\b3\u0010\u0015J\r\u00104\u001a\u00020\u0000¢\u0006\u0004\b4\u0010\u0015J\u0017\u00106\u001a\u00020 2\u0006\u00105\u001a\u00020 H\u0002¢\u0006\u0004\b6\u00107J.\u00109\u001a\u00020\u00002\b\b\u0002\u00108\u001a\u00020\u00062\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00110\u001bH\u0082\b¢\u0006\u0004\b9\u0010:J\u0017\u0010<\u001a\u00020\u00112\u0006\u0010;\u001a\u00020 H\u0002¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0000H\u0002¢\u0006\u0004\b>\u0010\u0015J\u000f\u0010?\u001a\u00020\u0000H\u0002¢\u0006\u0004\b?\u0010\u0015J\u000f\u0010@\u001a\u00020\u0000H\u0002¢\u0006\u0004\b@\u0010\u0015J\u000f\u0010A\u001a\u00020\u0000H\u0002¢\u0006\u0004\bA\u0010\u0015J\u000f\u0010B\u001a\u00020\u0006H\u0002¢\u0006\u0004\bB\u0010CJ\u001e\u0010E\u001a\u00020 *\u00020\u00042\b\b\u0002\u0010D\u001a\u00020 H\u0082\u0010¢\u0006\u0004\bE\u0010FJ\u001e\u0010G\u001a\u00020 *\u00020\u00042\b\b\u0002\u0010D\u001a\u00020 H\u0082\u0010¢\u0006\u0004\bG\u0010FJ\u001d\u0010H\u001a\u00020 *\u00020\u00042\b\b\u0002\u0010D\u001a\u00020 H\u0002¢\u0006\u0004\bH\u0010FJ\u001d\u0010I\u001a\u00020 *\u00020\u00042\b\b\u0002\u0010D\u001a\u00020 H\u0002¢\u0006\u0004\bI\u0010FJ\u001b\u0010K\u001a\u00020 *\u00020\u00042\u0006\u0010J\u001a\u00020 H\u0002¢\u0006\u0004\bK\u0010FJ\u0017\u0010L\u001a\u00020 2\u0006\u0010;\u001a\u00020 H\u0002¢\u0006\u0004\bL\u00107R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010MR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010NR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010OR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010PR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010QR\u0017\u0010S\u001a\u00020R8\u0006¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR(\u0010W\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u0014\u0010^\u001a\u00020]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006a"}, d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelection;", "", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "state", "Landroidx/compose/ui/text/TextLayoutResult;", "textLayoutResult", "", "isFromSoftKeyboard", "", "visibleTextLayoutHeight", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;", "textPreparedSelectionState", AppAgent.CONSTRUCT, "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/ui/text/TextLayoutResult;ZFLandroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;)V", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextRange;", "block", "LC7/r;", "deleteIfSelectedOr", "(LS7/a;)V", "moveCursorUpByPage", "()Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelection;", "moveCursorDownByPage", "selectAll", "deselect", "moveCursorLeft", "moveCursorRight", "Lkotlin/Function1;", "or", "collapseLeftOr", "(LS7/k;)Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelection;", "collapseRightOr", "", "getPrecedingCharacterIndex", "()I", "getNextCharacterIndex", "moveCursorToHome", "moveCursorToEnd", "moveCursorLeftByWord", "moveCursorRightByWord", "getNextWordOffset", "getPreviousWordOffset", "moveCursorPrevByParagraph", "moveCursorNextByParagraph", "moveCursorUpByLine", "moveCursorDownByLine", "getLineStartByOffset", "moveCursorToLineStart", "getLineEndByOffset", "moveCursorToLineEnd", "moveCursorToLineLeftSide", "moveCursorToLineRightSide", "selectMovement", "pagesAmount", "jumpByPagesOffset", "(I)I", "resetCachedX", "applyIfNotEmpty", "(ZLS7/k;)Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelection;", TypedValues.CycleType.S_WAVE_OFFSET, "setCursor", "(I)V", "moveCursorPrev", "moveCursorNext", "moveCursorNextByWord", "moveCursorPrevByWord", "isLtr", "()Z", "currentOffset", "getNextWordOffsetForLayout", "(Landroidx/compose/ui/text/TextLayoutResult;I)I", "getPrevWordOffsetForLayout", "getLineStartByOffsetForLayout", "getLineEndByOffsetForLayout", "linesAmount", "jumpByLinesOffset", "charOffset", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "Landroidx/compose/ui/text/TextLayoutResult;", "Z", "F", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldPreparedSelectionState;", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "initialValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "getInitialValue", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "selection", "J", "getSelection-d9O1mEE", "()J", "setSelection-5zc-tL8", "(J)V", "", "text", "Ljava/lang/String;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldPreparedSelection {
    public static final int NoCharacterFound = -1;
    private final TextFieldCharSequence initialValue;
    private final boolean isFromSoftKeyboard;
    private long selection;
    private final TransformedTextFieldState state;
    private final String text;
    private final TextLayoutResult textLayoutResult;
    private final TextFieldPreparedSelectionState textPreparedSelectionState;
    private final float visibleTextLayoutHeight;
    public static final int $stable = 8;

    public TextFieldPreparedSelection(TransformedTextFieldState transformedTextFieldState, TextLayoutResult textLayoutResult, boolean z10, float f, TextFieldPreparedSelectionState textFieldPreparedSelectionState) {
        this.state = transformedTextFieldState;
        this.textLayoutResult = textLayoutResult;
        this.isFromSoftKeyboard = z10;
        this.visibleTextLayoutHeight = f;
        this.textPreparedSelectionState = textFieldPreparedSelectionState;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        k readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            TextFieldCharSequence visualText = transformedTextFieldState.getVisualText();
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            this.initialValue = visualText;
            this.selection = visualText.getSelection();
            this.text = visualText.toString();
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    private final TextFieldPreparedSelection applyIfNotEmpty(boolean resetCachedX, k block) {
        if (resetCachedX) {
            this.textPreparedSelectionState.resetCachedX();
        }
        if (this.text.length() > 0) {
            block.invoke(this);
        }
        return this;
    }

    public static /* synthetic */ TextFieldPreparedSelection applyIfNotEmpty$default(TextFieldPreparedSelection textFieldPreparedSelection, boolean z10, k kVar, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = true;
        }
        if (z10) {
            textFieldPreparedSelection.textPreparedSelectionState.resetCachedX();
        }
        if (textFieldPreparedSelection.text.length() > 0) {
            kVar.invoke(textFieldPreparedSelection);
        }
        return textFieldPreparedSelection;
    }

    private final int charOffset(int offset) {
        int length = this.text.length() - 1;
        return offset > length ? length : offset;
    }

    private final int getLineEndByOffsetForLayout(TextLayoutResult textLayoutResult, int i) {
        return textLayoutResult.getLineEnd(textLayoutResult.getLineForOffset(i), true);
    }

    public static /* synthetic */ int getLineEndByOffsetForLayout$default(TextFieldPreparedSelection textFieldPreparedSelection, TextLayoutResult textLayoutResult, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = TextRange.m6308getMaximpl(textFieldPreparedSelection.selection);
        }
        return textFieldPreparedSelection.getLineEndByOffsetForLayout(textLayoutResult, i);
    }

    private final int getLineStartByOffsetForLayout(TextLayoutResult textLayoutResult, int i) {
        return textLayoutResult.getLineStart(textLayoutResult.getLineForOffset(i));
    }

    public static /* synthetic */ int getLineStartByOffsetForLayout$default(TextFieldPreparedSelection textFieldPreparedSelection, TextLayoutResult textLayoutResult, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = TextRange.m6309getMinimpl(textFieldPreparedSelection.selection);
        }
        return textFieldPreparedSelection.getLineStartByOffsetForLayout(textLayoutResult, i);
    }

    private final int getNextWordOffsetForLayout(TextLayoutResult textLayoutResult, int i) {
        while (i < this.initialValue.length()) {
            long jM6283getWordBoundaryjx7JFs = textLayoutResult.m6283getWordBoundaryjx7JFs(charOffset(i));
            if (TextRange.m6306getEndimpl(jM6283getWordBoundaryjx7JFs) > i) {
                return TextRange.m6306getEndimpl(jM6283getWordBoundaryjx7JFs);
            }
            i++;
        }
        return this.initialValue.length();
    }

    public static /* synthetic */ int getNextWordOffsetForLayout$default(TextFieldPreparedSelection textFieldPreparedSelection, TextLayoutResult textLayoutResult, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = TextRange.m6306getEndimpl(textFieldPreparedSelection.selection);
        }
        return textFieldPreparedSelection.getNextWordOffsetForLayout(textLayoutResult, i);
    }

    private final int getPrevWordOffsetForLayout(TextLayoutResult textLayoutResult, int i) {
        while (i > 0) {
            long jM6283getWordBoundaryjx7JFs = textLayoutResult.m6283getWordBoundaryjx7JFs(charOffset(i));
            if (TextRange.m6311getStartimpl(jM6283getWordBoundaryjx7JFs) < i) {
                return TextRange.m6311getStartimpl(jM6283getWordBoundaryjx7JFs);
            }
            i--;
        }
        return 0;
    }

    public static /* synthetic */ int getPrevWordOffsetForLayout$default(TextFieldPreparedSelection textFieldPreparedSelection, TextLayoutResult textLayoutResult, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = TextRange.m6306getEndimpl(textFieldPreparedSelection.selection);
        }
        return textFieldPreparedSelection.getPrevWordOffsetForLayout(textLayoutResult, i);
    }

    private final boolean isLtr() {
        ResolvedTextDirection paragraphDirection;
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        return textLayoutResult == null || (paragraphDirection = textLayoutResult.getParagraphDirection(TextRange.m6306getEndimpl(this.selection))) == null || paragraphDirection == ResolvedTextDirection.Ltr;
    }

    private final int jumpByLinesOffset(TextLayoutResult textLayoutResult, int i) {
        int iM6306getEndimpl = TextRange.m6306getEndimpl(this.selection);
        if (Float.isNaN(this.textPreparedSelectionState.getCachedX())) {
            this.textPreparedSelectionState.setCachedX(textLayoutResult.getCursorRect(iM6306getEndimpl).getLeft());
        }
        int lineForOffset = textLayoutResult.getLineForOffset(iM6306getEndimpl) + i;
        if (lineForOffset < 0) {
            return 0;
        }
        if (lineForOffset >= textLayoutResult.getLineCount()) {
            return this.text.length();
        }
        float lineBottom = textLayoutResult.getLineBottom(lineForOffset) - 1;
        float cachedX = this.textPreparedSelectionState.getCachedX();
        return ((!isLtr() || cachedX < textLayoutResult.getLineRight(lineForOffset)) && (isLtr() || cachedX > textLayoutResult.getLineLeft(lineForOffset))) ? textLayoutResult.m6281getOffsetForPositionk4lQ0M(OffsetKt.Offset(cachedX, lineBottom)) : textLayoutResult.getLineEnd(lineForOffset, true);
    }

    private final int jumpByPagesOffset(int pagesAmount) {
        int iM6306getEndimpl = TextRange.m6306getEndimpl(this.initialValue.getSelection());
        if (this.textLayoutResult == null || Float.isNaN(this.visibleTextLayoutHeight)) {
            return iM6306getEndimpl;
        }
        Rect rectTranslate = this.textLayoutResult.getCursorRect(iM6306getEndimpl).translate(0.0f, this.visibleTextLayoutHeight * pagesAmount);
        float lineBottom = this.textLayoutResult.getLineBottom(this.textLayoutResult.getLineForVerticalPosition(rectTranslate.getTop()));
        return Math.abs(rectTranslate.getTop() - lineBottom) > Math.abs(rectTranslate.getBottom() - lineBottom) ? this.textLayoutResult.m6281getOffsetForPositionk4lQ0M(rectTranslate.m3930getTopLeftF1C5BW0()) : this.textLayoutResult.m6281getOffsetForPositionk4lQ0M(rectTranslate.m3923getBottomLeftF1C5BW0());
    }

    private final TextFieldPreparedSelection moveCursorNext() {
        int iM6306getEndimpl;
        int iCalculateAdjacentCursorPosition;
        if (b.d(this, this) > 0 && (iCalculateAdjacentCursorPosition = TextPreparedSelectionKt.calculateAdjacentCursorPosition(this.text, (iM6306getEndimpl = TextRange.m6306getEndimpl(this.selection)), true, this.state)) != iM6306getEndimpl) {
            setCursor(iCalculateAdjacentCursorPosition);
        }
        return this;
    }

    private final TextFieldPreparedSelection moveCursorNextByWord() {
        if (b.d(this, this) > 0) {
            setCursor(getNextWordOffset());
        }
        return this;
    }

    private final TextFieldPreparedSelection moveCursorPrev() {
        int iM6306getEndimpl;
        int iCalculateAdjacentCursorPosition;
        if (b.d(this, this) > 0 && (iCalculateAdjacentCursorPosition = TextPreparedSelectionKt.calculateAdjacentCursorPosition(this.text, (iM6306getEndimpl = TextRange.m6306getEndimpl(this.selection)), false, this.state)) != iM6306getEndimpl) {
            setCursor(iCalculateAdjacentCursorPosition);
        }
        return this;
    }

    private final TextFieldPreparedSelection moveCursorPrevByWord() {
        if (b.d(this, this) > 0) {
            setCursor(getPreviousWordOffset());
        }
        return this;
    }

    private final void setCursor(int offset) {
        this.selection = TextRangeKt.TextRange(offset, offset);
    }

    public final TextFieldPreparedSelection collapseLeftOr(k or) {
        if (b.d(this, this) > 0) {
            if (TextRange.m6305getCollapsedimpl(this.selection)) {
                or.invoke(this);
                return this;
            }
            if (isLtr()) {
                setCursor(TextRange.m6309getMinimpl(this.selection));
                return this;
            }
            setCursor(TextRange.m6308getMaximpl(this.selection));
        }
        return this;
    }

    public final TextFieldPreparedSelection collapseRightOr(k or) {
        if (b.d(this, this) > 0) {
            if (TextRange.m6305getCollapsedimpl(this.selection)) {
                or.invoke(this);
                return this;
            }
            if (isLtr()) {
                setCursor(TextRange.m6308getMaximpl(this.selection));
                return this;
            }
            setCursor(TextRange.m6309getMinimpl(this.selection));
        }
        return this;
    }

    public final void deleteIfSelectedOr(a block) {
        if (!TextRange.m6305getCollapsedimpl(getSelection())) {
            TransformedTextFieldState.m1261replaceTextM8tDOmk$default(this.state, "", getSelection(), null, !this.isFromSoftKeyboard, 4, null);
            return;
        }
        TextRange textRange = (TextRange) block.invoke();
        if (textRange != null) {
            TransformedTextFieldState.m1261replaceTextM8tDOmk$default(this.state, "", textRange.getPackedValue(), null, !this.isFromSoftKeyboard, 4, null);
        }
    }

    public final TextFieldPreparedSelection deselect() {
        if (b.d(this, this) > 0) {
            setCursor(TextRange.m6306getEndimpl(this.selection));
        }
        return this;
    }

    public final TextFieldCharSequence getInitialValue() {
        return this.initialValue;
    }

    public final int getLineEndByOffset() {
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        return textLayoutResult != null ? getLineEndByOffsetForLayout$default(this, textLayoutResult, 0, 1, null) : this.text.length();
    }

    public final int getLineStartByOffset() {
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        if (textLayoutResult != null) {
            return getLineStartByOffsetForLayout$default(this, textLayoutResult, 0, 1, null);
        }
        return 0;
    }

    public final int getNextCharacterIndex() {
        return StringHelpers_androidKt.findFollowingBreak(this.text, TextRange.m6306getEndimpl(this.selection));
    }

    public final int getNextWordOffset() {
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        return textLayoutResult != null ? getNextWordOffsetForLayout$default(this, textLayoutResult, 0, 1, null) : this.text.length();
    }

    public final int getPrecedingCharacterIndex() {
        return StringHelpers_androidKt.findPrecedingBreak(this.text, TextRange.m6306getEndimpl(this.selection));
    }

    public final int getPreviousWordOffset() {
        TextLayoutResult textLayoutResult = this.textLayoutResult;
        if (textLayoutResult != null) {
            return getPrevWordOffsetForLayout$default(this, textLayoutResult, 0, 1, null);
        }
        return 0;
    }

    /* renamed from: getSelection-d9O1mEE, reason: not valid java name and from getter */
    public final long getSelection() {
        return this.selection;
    }

    public final TextFieldPreparedSelection moveCursorDownByLine() {
        if (this.textLayoutResult != null && this.text.length() > 0) {
            TextLayoutResult textLayoutResult = this.textLayoutResult;
            kotlin.jvm.internal.k.c(textLayoutResult);
            setCursor(jumpByLinesOffset(textLayoutResult, 1));
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorDownByPage() {
        if (this.text.length() > 0) {
            setCursor(jumpByPagesOffset(1));
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorLeft() {
        if (b.d(this, this) > 0) {
            if (isLtr()) {
                moveCursorPrev();
                return this;
            }
            moveCursorNext();
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorLeftByWord() {
        if (b.d(this, this) > 0) {
            if (isLtr()) {
                moveCursorPrevByWord();
                return this;
            }
            moveCursorNextByWord();
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorNextByParagraph() {
        if (b.d(this, this) > 0) {
            int iFindParagraphEnd = StringHelpersKt.findParagraphEnd(this.text, TextRange.m6308getMaximpl(this.selection));
            if (iFindParagraphEnd == TextRange.m6308getMaximpl(this.selection) && iFindParagraphEnd != this.text.length()) {
                iFindParagraphEnd = StringHelpersKt.findParagraphEnd(this.text, iFindParagraphEnd + 1);
            }
            setCursor(iFindParagraphEnd);
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorPrevByParagraph() {
        if (b.d(this, this) > 0) {
            int iFindParagraphStart = StringHelpersKt.findParagraphStart(this.text, TextRange.m6309getMinimpl(this.selection));
            if (iFindParagraphStart == TextRange.m6309getMinimpl(this.selection) && iFindParagraphStart != 0) {
                iFindParagraphStart = StringHelpersKt.findParagraphStart(this.text, iFindParagraphStart - 1);
            }
            setCursor(iFindParagraphStart);
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorRight() {
        if (b.d(this, this) > 0) {
            if (isLtr()) {
                moveCursorNext();
                return this;
            }
            moveCursorPrev();
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorRightByWord() {
        if (b.d(this, this) > 0) {
            if (isLtr()) {
                moveCursorNextByWord();
                return this;
            }
            moveCursorPrevByWord();
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorToEnd() {
        if (b.d(this, this) > 0) {
            setCursor(this.text.length());
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorToHome() {
        if (b.d(this, this) > 0) {
            setCursor(0);
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorToLineEnd() {
        if (b.d(this, this) > 0) {
            setCursor(getLineEndByOffset());
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorToLineLeftSide() {
        if (b.d(this, this) > 0) {
            if (isLtr()) {
                moveCursorToLineStart();
                return this;
            }
            moveCursorToLineEnd();
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorToLineRightSide() {
        if (b.d(this, this) > 0) {
            if (isLtr()) {
                moveCursorToLineEnd();
                return this;
            }
            moveCursorToLineStart();
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorToLineStart() {
        if (b.d(this, this) > 0) {
            setCursor(getLineStartByOffset());
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorUpByLine() {
        if (this.textLayoutResult != null && this.text.length() > 0) {
            TextLayoutResult textLayoutResult = this.textLayoutResult;
            kotlin.jvm.internal.k.c(textLayoutResult);
            setCursor(jumpByLinesOffset(textLayoutResult, -1));
        }
        return this;
    }

    public final TextFieldPreparedSelection moveCursorUpByPage() {
        if (this.text.length() > 0) {
            setCursor(jumpByPagesOffset(-1));
        }
        return this;
    }

    public final TextFieldPreparedSelection selectAll() {
        if (b.d(this, this) > 0) {
            this.selection = TextRangeKt.TextRange(0, this.text.length());
        }
        return this;
    }

    public final TextFieldPreparedSelection selectMovement() {
        if (this.text.length() > 0) {
            this.selection = TextRangeKt.TextRange(TextRange.m6311getStartimpl(this.initialValue.getSelection()), TextRange.m6306getEndimpl(this.selection));
        }
        return this;
    }

    /* renamed from: setSelection-5zc-tL8, reason: not valid java name */
    public final void m1290setSelection5zctL8(long j5) {
        this.selection = j5;
    }
}
