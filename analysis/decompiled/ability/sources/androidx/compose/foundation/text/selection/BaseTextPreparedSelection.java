package androidx.compose.foundation.text.selection;

import S7.k;
import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.selection.BaseTextPreparedSelection;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\bO\n\u0002\u0010\u000e\n\u0002\b\u0005\b \u0018\u0000 k*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0002:\u0001kB1\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ8\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0001\u0010\u000f*\u00028\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00130\u0012H\u0084\b¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0017H\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0017H\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00028\u0000¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00028\u0000¢\u0006\u0004\b!\u0010 J\r\u0010\"\u001a\u00028\u0000¢\u0006\u0004\b\"\u0010 J\r\u0010#\u001a\u00028\u0000¢\u0006\u0004\b#\u0010 J!\u0010%\u001a\u00028\u00002\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b%\u0010&J!\u0010'\u001a\u00028\u00002\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b'\u0010&J\r\u0010(\u001a\u00020\u0017¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\u0017¢\u0006\u0004\b*\u0010)J\r\u0010+\u001a\u00028\u0000¢\u0006\u0004\b+\u0010 J\r\u0010,\u001a\u00028\u0000¢\u0006\u0004\b,\u0010 J\r\u0010-\u001a\u00028\u0000¢\u0006\u0004\b-\u0010 J\r\u0010.\u001a\u00028\u0000¢\u0006\u0004\b.\u0010 J\u000f\u0010/\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b1\u00100J\r\u00102\u001a\u00028\u0000¢\u0006\u0004\b2\u0010 J\r\u00103\u001a\u00028\u0000¢\u0006\u0004\b3\u0010 J\r\u00104\u001a\u00028\u0000¢\u0006\u0004\b4\u0010 J\r\u00105\u001a\u00028\u0000¢\u0006\u0004\b5\u0010 J\u000f\u00106\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b6\u00100J\r\u00107\u001a\u00028\u0000¢\u0006\u0004\b7\u0010 J\u000f\u00108\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b8\u00100J\r\u00109\u001a\u00028\u0000¢\u0006\u0004\b9\u0010 J\r\u0010:\u001a\u00028\u0000¢\u0006\u0004\b:\u0010 J\r\u0010;\u001a\u00028\u0000¢\u0006\u0004\b;\u0010 J\r\u0010<\u001a\u00028\u0000¢\u0006\u0004\b<\u0010 J\u000f\u0010=\u001a\u00028\u0000H\u0002¢\u0006\u0004\b=\u0010 J\u000f\u0010>\u001a\u00028\u0000H\u0002¢\u0006\u0004\b>\u0010 J\u000f\u0010?\u001a\u00028\u0000H\u0002¢\u0006\u0004\b?\u0010 J\u000f\u0010@\u001a\u00028\u0000H\u0002¢\u0006\u0004\b@\u0010 J\u000f\u0010A\u001a\u00020\u0010H\u0002¢\u0006\u0004\bA\u0010BJ\u001e\u0010D\u001a\u00020\u0017*\u00020\u00072\b\b\u0002\u0010C\u001a\u00020\u0017H\u0082\u0010¢\u0006\u0004\bD\u0010EJ\u001e\u0010F\u001a\u00020\u0017*\u00020\u00072\b\b\u0002\u0010C\u001a\u00020\u0017H\u0082\u0010¢\u0006\u0004\bF\u0010EJ\u001d\u0010G\u001a\u00020\u0017*\u00020\u00072\b\b\u0002\u0010C\u001a\u00020\u0017H\u0002¢\u0006\u0004\bG\u0010EJ\u001d\u0010H\u001a\u00020\u0017*\u00020\u00072\b\b\u0002\u0010C\u001a\u00020\u0017H\u0002¢\u0006\u0004\bH\u0010EJ\u001b\u0010J\u001a\u00020\u0017*\u00020\u00072\u0006\u0010I\u001a\u00020\u0017H\u0002¢\u0006\u0004\bJ\u0010EJ\u000f\u0010K\u001a\u00020\u0017H\u0002¢\u0006\u0004\bK\u0010)J\u000f\u0010L\u001a\u00020\u0017H\u0002¢\u0006\u0004\bL\u0010)J\u000f\u0010M\u001a\u00020\u0017H\u0002¢\u0006\u0004\bM\u0010)J\u0017\u0010N\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\bN\u0010OR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010P\u001a\u0004\bQ\u0010RR\u001d\u0010\u0006\u001a\u00020\u00058\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0006\u0010S\u001a\u0004\bT\u0010UR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010V\u001a\u0004\bW\u0010XR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010Y\u001a\u0004\bZ\u0010[R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\\\u001a\u0004\b]\u0010^R(\u0010_\u001a\u00020\u00058\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b_\u0010S\u001a\u0004\b`\u0010U\"\u0004\ba\u0010bR\"\u0010c\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bc\u0010P\u001a\u0004\bd\u0010R\"\u0004\be\u0010fR\u0014\u0010j\u001a\u00020g8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bh\u0010i\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006l"}, d2 = {"Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/compose/ui/text/AnnotatedString;", "originalText", "Landroidx/compose/ui/text/TextRange;", "originalSelection", "Landroidx/compose/ui/text/TextLayoutResult;", "layoutResult", "Landroidx/compose/ui/text/input/OffsetMapping;", "offsetMapping", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "state", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;Lkotlin/jvm/internal/e;)V", "U", "", "resetCachedX", "Lkotlin/Function1;", "LC7/r;", "block", "apply", "(Ljava/lang/Object;ZLS7/k;)Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "", TypedValues.CycleType.S_WAVE_OFFSET, "setCursor", "(I)V", "start", "end", "setSelection", "(II)V", "selectAll", "()Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "deselect", "moveCursorLeft", "moveCursorRight", "or", "collapseLeftOr", "(LS7/k;)Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "collapseRightOr", "getPrecedingCharacterIndex", "()I", "getNextCharacterIndex", "moveCursorToHome", "moveCursorToEnd", "moveCursorLeftByWord", "moveCursorRightByWord", "getNextWordOffset", "()Ljava/lang/Integer;", "getPreviousWordOffset", "moveCursorPrevByParagraph", "moveCursorNextByParagraph", "moveCursorUpByLine", "moveCursorDownByLine", "getLineStartByOffset", "moveCursorToLineStart", "getLineEndByOffset", "moveCursorToLineEnd", "moveCursorToLineLeftSide", "moveCursorToLineRightSide", "selectMovement", "moveCursorPrev", "moveCursorNext", "moveCursorNextByWord", "moveCursorPrevByWord", "isLtr", "()Z", "currentOffset", "getNextWordOffsetForLayout", "(Landroidx/compose/ui/text/TextLayoutResult;I)I", "getPrevWordOffset", "getLineStartByOffsetForLayout", "getLineEndByOffsetForLayout", "linesAmount", "jumpByLinesOffset", "transformedEndOffset", "transformedMinOffset", "transformedMaxOffset", "charOffset", "(I)I", "Landroidx/compose/ui/text/AnnotatedString;", "getOriginalText", "()Landroidx/compose/ui/text/AnnotatedString;", "J", "getOriginalSelection-d9O1mEE", "()J", "Landroidx/compose/ui/text/TextLayoutResult;", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "Landroidx/compose/ui/text/input/OffsetMapping;", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "getState", "()Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "selection", "getSelection-d9O1mEE", "setSelection-5zc-tL8", "(J)V", "annotatedString", "getAnnotatedString", "setAnnotatedString", "(Landroidx/compose/ui/text/AnnotatedString;)V", "", "getText$foundation_release", "()Ljava/lang/String;", "text", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class BaseTextPreparedSelection<T extends BaseTextPreparedSelection<T>> {
    public static final int NoCharacterFound = -1;
    private AnnotatedString annotatedString;
    private final TextLayoutResult layoutResult;
    private final OffsetMapping offsetMapping;
    private final long originalSelection;
    private final AnnotatedString originalText;
    private long selection;
    private final TextPreparedSelectionState state;
    public static final int $stable = 8;

    public /* synthetic */ BaseTextPreparedSelection(AnnotatedString annotatedString, long j5, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, TextPreparedSelectionState textPreparedSelectionState, e eVar) {
        this(annotatedString, j5, textLayoutResult, offsetMapping, textPreparedSelectionState);
    }

    public static /* synthetic */ BaseTextPreparedSelection apply$default(BaseTextPreparedSelection baseTextPreparedSelection, Object obj, boolean z10, k kVar, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: apply");
        }
        if ((i & 1) != 0) {
            z10 = true;
        }
        if (z10) {
            baseTextPreparedSelection.getState().resetCachedX();
        }
        if (baseTextPreparedSelection.getText$foundation_release().length() > 0) {
            kVar.invoke(obj);
        }
        kotlin.jvm.internal.k.d(obj, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection) obj;
    }

    private final int charOffset(int offset) {
        int length = getText$foundation_release().length() - 1;
        return offset > length ? length : offset;
    }

    private final int getLineEndByOffsetForLayout(TextLayoutResult textLayoutResult, int i) {
        return this.offsetMapping.transformedToOriginal(textLayoutResult.getLineEnd(textLayoutResult.getLineForOffset(i), true));
    }

    public static /* synthetic */ int getLineEndByOffsetForLayout$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineEndByOffsetForLayout");
        }
        if ((i6 & 1) != 0) {
            i = baseTextPreparedSelection.transformedMaxOffset();
        }
        return baseTextPreparedSelection.getLineEndByOffsetForLayout(textLayoutResult, i);
    }

    private final int getLineStartByOffsetForLayout(TextLayoutResult textLayoutResult, int i) {
        return this.offsetMapping.transformedToOriginal(textLayoutResult.getLineStart(textLayoutResult.getLineForOffset(i)));
    }

    public static /* synthetic */ int getLineStartByOffsetForLayout$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineStartByOffsetForLayout");
        }
        if ((i6 & 1) != 0) {
            i = baseTextPreparedSelection.transformedMinOffset();
        }
        return baseTextPreparedSelection.getLineStartByOffsetForLayout(textLayoutResult, i);
    }

    private final int getNextWordOffsetForLayout(TextLayoutResult textLayoutResult, int i) {
        while (i < this.originalText.length()) {
            long jM6283getWordBoundaryjx7JFs = textLayoutResult.m6283getWordBoundaryjx7JFs(charOffset(i));
            if (TextRange.m6306getEndimpl(jM6283getWordBoundaryjx7JFs) > i) {
                return this.offsetMapping.transformedToOriginal(TextRange.m6306getEndimpl(jM6283getWordBoundaryjx7JFs));
            }
            i++;
        }
        return this.originalText.length();
    }

    public static /* synthetic */ int getNextWordOffsetForLayout$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNextWordOffsetForLayout");
        }
        if ((i6 & 1) != 0) {
            i = baseTextPreparedSelection.transformedEndOffset();
        }
        return baseTextPreparedSelection.getNextWordOffsetForLayout(textLayoutResult, i);
    }

    private final int getPrevWordOffset(TextLayoutResult textLayoutResult, int i) {
        while (i > 0) {
            long jM6283getWordBoundaryjx7JFs = textLayoutResult.m6283getWordBoundaryjx7JFs(charOffset(i));
            if (TextRange.m6311getStartimpl(jM6283getWordBoundaryjx7JFs) < i) {
                return this.offsetMapping.transformedToOriginal(TextRange.m6311getStartimpl(jM6283getWordBoundaryjx7JFs));
            }
            i--;
        }
        return 0;
    }

    public static /* synthetic */ int getPrevWordOffset$default(BaseTextPreparedSelection baseTextPreparedSelection, TextLayoutResult textLayoutResult, int i, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPrevWordOffset");
        }
        if ((i6 & 1) != 0) {
            i = baseTextPreparedSelection.transformedEndOffset();
        }
        return baseTextPreparedSelection.getPrevWordOffset(textLayoutResult, i);
    }

    private final boolean isLtr() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        return (textLayoutResult != null ? textLayoutResult.getParagraphDirection(transformedEndOffset()) : null) != ResolvedTextDirection.Rtl;
    }

    private final int jumpByLinesOffset(TextLayoutResult textLayoutResult, int i) {
        int iTransformedEndOffset = transformedEndOffset();
        if (this.state.getCachedX() == null) {
            this.state.setCachedX(Float.valueOf(textLayoutResult.getCursorRect(iTransformedEndOffset).getLeft()));
        }
        int lineForOffset = textLayoutResult.getLineForOffset(iTransformedEndOffset) + i;
        if (lineForOffset < 0) {
            return 0;
        }
        if (lineForOffset >= textLayoutResult.getLineCount()) {
            return getText$foundation_release().length();
        }
        float lineBottom = textLayoutResult.getLineBottom(lineForOffset) - 1;
        Float cachedX = this.state.getCachedX();
        kotlin.jvm.internal.k.c(cachedX);
        float fFloatValue = cachedX.floatValue();
        if ((isLtr() && fFloatValue >= textLayoutResult.getLineRight(lineForOffset)) || (!isLtr() && fFloatValue <= textLayoutResult.getLineLeft(lineForOffset))) {
            return textLayoutResult.getLineEnd(lineForOffset, true);
        }
        return this.offsetMapping.transformedToOriginal(textLayoutResult.m6281getOffsetForPositionk4lQ0M(OffsetKt.Offset(cachedX.floatValue(), lineBottom)));
    }

    private final T moveCursorNext() {
        int nextCharacterIndex;
        if (androidx.compose.foundation.b.e(this) > 0 && (nextCharacterIndex = getNextCharacterIndex()) != -1) {
            setCursor(nextCharacterIndex);
        }
        return this;
    }

    private final T moveCursorNextByWord() {
        Integer nextWordOffset;
        if (androidx.compose.foundation.b.e(this) > 0 && (nextWordOffset = getNextWordOffset()) != null) {
            setCursor(nextWordOffset.intValue());
        }
        return this;
    }

    private final T moveCursorPrev() {
        int precedingCharacterIndex;
        if (androidx.compose.foundation.b.e(this) > 0 && (precedingCharacterIndex = getPrecedingCharacterIndex()) != -1) {
            setCursor(precedingCharacterIndex);
        }
        return this;
    }

    private final T moveCursorPrevByWord() {
        Integer previousWordOffset;
        if (androidx.compose.foundation.b.e(this) > 0 && (previousWordOffset = getPreviousWordOffset()) != null) {
            setCursor(previousWordOffset.intValue());
        }
        return this;
    }

    private final int transformedEndOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m6306getEndimpl(this.selection));
    }

    private final int transformedMaxOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m6308getMaximpl(this.selection));
    }

    private final int transformedMinOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m6309getMinimpl(this.selection));
    }

    public final <U> T apply(U u, boolean z10, k kVar) {
        if (z10) {
            getState().resetCachedX();
        }
        if (getText$foundation_release().length() > 0) {
            kVar.invoke(u);
        }
        kotlin.jvm.internal.k.d(u, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (T) u;
    }

    public final T collapseLeftOr(k or) {
        if (androidx.compose.foundation.b.e(this) > 0) {
            if (TextRange.m6305getCollapsedimpl(this.selection)) {
                or.invoke(this);
            } else if (isLtr()) {
                setCursor(TextRange.m6309getMinimpl(this.selection));
            } else {
                setCursor(TextRange.m6308getMaximpl(this.selection));
            }
        }
        return this;
    }

    public final T collapseRightOr(k or) {
        if (androidx.compose.foundation.b.e(this) > 0) {
            if (TextRange.m6305getCollapsedimpl(this.selection)) {
                or.invoke(this);
            } else if (isLtr()) {
                setCursor(TextRange.m6308getMaximpl(this.selection));
            } else {
                setCursor(TextRange.m6309getMinimpl(this.selection));
            }
        }
        return this;
    }

    public final T deselect() {
        if (androidx.compose.foundation.b.e(this) > 0) {
            setCursor(TextRange.m6306getEndimpl(this.selection));
        }
        return this;
    }

    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    public final TextLayoutResult getLayoutResult() {
        return this.layoutResult;
    }

    public final Integer getLineEndByOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(getLineEndByOffsetForLayout$default(this, textLayoutResult, 0, 1, null));
        }
        return null;
    }

    public final Integer getLineStartByOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(getLineStartByOffsetForLayout$default(this, textLayoutResult, 0, 1, null));
        }
        return null;
    }

    public final int getNextCharacterIndex() {
        return StringHelpers_androidKt.findFollowingBreak(this.annotatedString.getText(), TextRange.m6306getEndimpl(this.selection));
    }

    public final Integer getNextWordOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(getNextWordOffsetForLayout$default(this, textLayoutResult, 0, 1, null));
        }
        return null;
    }

    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    /* renamed from: getOriginalSelection-d9O1mEE, reason: not valid java name and from getter */
    public final long getOriginalSelection() {
        return this.originalSelection;
    }

    public final AnnotatedString getOriginalText() {
        return this.originalText;
    }

    public final int getPrecedingCharacterIndex() {
        return StringHelpers_androidKt.findPrecedingBreak(this.annotatedString.getText(), TextRange.m6306getEndimpl(this.selection));
    }

    public final Integer getPreviousWordOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            return Integer.valueOf(getPrevWordOffset$default(this, textLayoutResult, 0, 1, null));
        }
        return null;
    }

    /* renamed from: getSelection-d9O1mEE, reason: not valid java name and from getter */
    public final long getSelection() {
        return this.selection;
    }

    public final TextPreparedSelectionState getState() {
        return this.state;
    }

    public final String getText$foundation_release() {
        return this.annotatedString.getText();
    }

    public final T moveCursorDownByLine() {
        TextLayoutResult textLayoutResult;
        if (getText$foundation_release().length() > 0 && (textLayoutResult = this.layoutResult) != null) {
            setCursor(jumpByLinesOffset(textLayoutResult, 1));
        }
        return this;
    }

    public final T moveCursorLeft() {
        if (androidx.compose.foundation.b.e(this) > 0) {
            if (isLtr()) {
                moveCursorPrev();
            } else {
                moveCursorNext();
            }
        }
        return this;
    }

    public final T moveCursorLeftByWord() {
        if (androidx.compose.foundation.b.e(this) > 0) {
            if (isLtr()) {
                moveCursorPrevByWord();
            } else {
                moveCursorNextByWord();
            }
        }
        return this;
    }

    public final T moveCursorNextByParagraph() {
        if (androidx.compose.foundation.b.e(this) > 0) {
            int iFindParagraphEnd = StringHelpersKt.findParagraphEnd(getText$foundation_release(), TextRange.m6308getMaximpl(this.selection));
            if (iFindParagraphEnd == TextRange.m6308getMaximpl(this.selection) && iFindParagraphEnd != getText$foundation_release().length()) {
                iFindParagraphEnd = StringHelpersKt.findParagraphEnd(getText$foundation_release(), iFindParagraphEnd + 1);
            }
            setCursor(iFindParagraphEnd);
        }
        return this;
    }

    public final T moveCursorPrevByParagraph() {
        if (androidx.compose.foundation.b.e(this) > 0) {
            int iFindParagraphStart = StringHelpersKt.findParagraphStart(getText$foundation_release(), TextRange.m6309getMinimpl(this.selection));
            if (iFindParagraphStart == TextRange.m6309getMinimpl(this.selection) && iFindParagraphStart != 0) {
                iFindParagraphStart = StringHelpersKt.findParagraphStart(getText$foundation_release(), iFindParagraphStart - 1);
            }
            setCursor(iFindParagraphStart);
        }
        return this;
    }

    public final T moveCursorRight() {
        if (androidx.compose.foundation.b.e(this) > 0) {
            if (isLtr()) {
                moveCursorNext();
            } else {
                moveCursorPrev();
            }
        }
        return this;
    }

    public final T moveCursorRightByWord() {
        if (androidx.compose.foundation.b.e(this) > 0) {
            if (isLtr()) {
                moveCursorNextByWord();
            } else {
                moveCursorPrevByWord();
            }
        }
        return this;
    }

    public final T moveCursorToEnd() {
        if (androidx.compose.foundation.b.e(this) > 0) {
            setCursor(getText$foundation_release().length());
        }
        return this;
    }

    public final T moveCursorToHome() {
        if (androidx.compose.foundation.b.e(this) > 0) {
            setCursor(0);
        }
        return this;
    }

    public final T moveCursorToLineEnd() {
        Integer lineEndByOffset;
        if (androidx.compose.foundation.b.e(this) > 0 && (lineEndByOffset = getLineEndByOffset()) != null) {
            setCursor(lineEndByOffset.intValue());
        }
        return this;
    }

    public final T moveCursorToLineLeftSide() {
        if (androidx.compose.foundation.b.e(this) > 0) {
            if (isLtr()) {
                moveCursorToLineStart();
            } else {
                moveCursorToLineEnd();
            }
        }
        return this;
    }

    public final T moveCursorToLineRightSide() {
        if (androidx.compose.foundation.b.e(this) > 0) {
            if (isLtr()) {
                moveCursorToLineEnd();
            } else {
                moveCursorToLineStart();
            }
        }
        return this;
    }

    public final T moveCursorToLineStart() {
        Integer lineStartByOffset;
        if (androidx.compose.foundation.b.e(this) > 0 && (lineStartByOffset = getLineStartByOffset()) != null) {
            setCursor(lineStartByOffset.intValue());
        }
        return this;
    }

    public final T moveCursorUpByLine() {
        TextLayoutResult textLayoutResult;
        if (getText$foundation_release().length() > 0 && (textLayoutResult = this.layoutResult) != null) {
            setCursor(jumpByLinesOffset(textLayoutResult, -1));
        }
        return this;
    }

    public final T selectAll() {
        if (androidx.compose.foundation.b.e(this) > 0) {
            setSelection(0, getText$foundation_release().length());
        }
        return this;
    }

    public final T selectMovement() {
        if (getText$foundation_release().length() > 0) {
            this.selection = TextRangeKt.TextRange(TextRange.m6311getStartimpl(this.originalSelection), TextRange.m6306getEndimpl(this.selection));
        }
        return this;
    }

    public final void setAnnotatedString(AnnotatedString annotatedString) {
        this.annotatedString = annotatedString;
    }

    public final void setCursor(int offset) {
        setSelection(offset, offset);
    }

    public final void setSelection(int start, int end) {
        this.selection = TextRangeKt.TextRange(start, end);
    }

    /* renamed from: setSelection-5zc-tL8, reason: not valid java name */
    public final void m1375setSelection5zctL8(long j5) {
        this.selection = j5;
    }

    private BaseTextPreparedSelection(AnnotatedString annotatedString, long j5, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, TextPreparedSelectionState textPreparedSelectionState) {
        this.originalText = annotatedString;
        this.originalSelection = j5;
        this.layoutResult = textLayoutResult;
        this.offsetMapping = offsetMapping;
        this.state = textPreparedSelectionState;
        this.selection = j5;
        this.annotatedString = annotatedString;
    }
}
