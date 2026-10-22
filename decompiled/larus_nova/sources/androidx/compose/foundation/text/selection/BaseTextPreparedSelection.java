package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpersKt;
import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.selection.BaseTextPreparedSelection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.exifinterface.media.ExifInterface;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b3\b!\u0018\u0000 c*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002:\u0001cB1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ;\u0010&\u001a\u00028\u0000\"\u0004\b\u0001\u0010'*\u0002H'2\b\b\u0002\u0010(\u001a\u00020)2\u0017\u0010*\u001a\u0013\u0012\u0004\u0012\u0002H'\u0012\u0004\u0012\u00020,0+¢\u0006\u0002\b-H\u0084\b¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020,2\u0006\u00100\u001a\u000201H\u0004J\u0018\u00102\u001a\u00020,2\u0006\u00103\u001a\u0002012\u0006\u00104\u001a\u000201H\u0004J\u000b\u00105\u001a\u00028\u0000¢\u0006\u0002\u00106J\u000b\u00107\u001a\u00028\u0000¢\u0006\u0002\u00106J\u000b\u00108\u001a\u00028\u0000¢\u0006\u0002\u00106J\u000b\u00109\u001a\u00028\u0000¢\u0006\u0002\u00106J$\u0010:\u001a\u00028\u00002\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020,0+¢\u0006\u0002\b-¢\u0006\u0002\u0010<J$\u0010=\u001a\u00028\u00002\u0017\u0010;\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020,0+¢\u0006\u0002\b-¢\u0006\u0002\u0010<J\u0006\u0010>\u001a\u000201J\u0006\u0010?\u001a\u000201J\u0006\u0010@\u001a\u000201J\r\u0010A\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00106J\r\u0010B\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00106J\u000b\u0010C\u001a\u00028\u0000¢\u0006\u0002\u00106J\u000b\u0010D\u001a\u00028\u0000¢\u0006\u0002\u00106J\u000b\u0010E\u001a\u00028\u0000¢\u0006\u0002\u00106J\u000b\u0010F\u001a\u00028\u0000¢\u0006\u0002\u00106J\r\u0010G\u001a\u0004\u0018\u000101¢\u0006\u0002\u0010HJ\r\u0010I\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00106J\r\u0010J\u001a\u0004\u0018\u000101¢\u0006\u0002\u0010HJ\r\u0010K\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00106J\u000b\u0010L\u001a\u00028\u0000¢\u0006\u0002\u00106J\u000b\u0010M\u001a\u00028\u0000¢\u0006\u0002\u00106J\u000b\u0010N\u001a\u00028\u0000¢\u0006\u0002\u00106J\u000b\u0010O\u001a\u00028\u0000¢\u0006\u0002\u00106J\r\u0010P\u001a\u0004\u0018\u000101¢\u0006\u0002\u0010HJ\u000b\u0010Q\u001a\u00028\u0000¢\u0006\u0002\u00106J\r\u0010R\u001a\u0004\u0018\u000101¢\u0006\u0002\u0010HJ\u000b\u0010S\u001a\u00028\u0000¢\u0006\u0002\u00106J\u000b\u0010T\u001a\u00028\u0000¢\u0006\u0002\u00106J\u000b\u0010U\u001a\u00028\u0000¢\u0006\u0002\u00106J\u000b\u0010V\u001a\u00028\u0000¢\u0006\u0002\u00106J\b\u0010W\u001a\u00020)H\u0002J\u0017\u0010X\u001a\u000201*\u00020\b2\b\b\u0002\u0010Y\u001a\u000201H\u0082\u0010J\u0017\u0010Z\u001a\u000201*\u00020\b2\b\b\u0002\u0010Y\u001a\u000201H\u0082\u0010J\u0016\u0010[\u001a\u000201*\u00020\b2\b\b\u0002\u0010Y\u001a\u000201H\u0002J\u0016\u0010\\\u001a\u000201*\u00020\b2\b\b\u0002\u0010Y\u001a\u000201H\u0002J\u0014\u0010]\u001a\u000201*\u00020\b2\u0006\u0010^\u001a\u000201H\u0002J\b\u0010_\u001a\u000201H\u0002J\b\u0010`\u001a\u000201H\u0002J\b\u0010a\u001a\u000201H\u0002J\u0010\u0010b\u001a\u0002012\u0006\u00100\u001a\u000201H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0005\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u00020\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006d"}, d2 = {"Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", ExifInterface.GPS_DIRECTION_TRUE, "", "originalText", "Landroidx/compose/ui/text/AnnotatedString;", "originalSelection", "Landroidx/compose/ui/text/TextRange;", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "state", "Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "<init>", "(Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getOriginalText", "()Landroidx/compose/ui/text/AnnotatedString;", "getOriginalSelection-d9O1mEE", "()J", "J", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "getOffsetMapping", "()Landroidx/compose/ui/text/input/OffsetMapping;", "getState", "()Landroidx/compose/foundation/text/selection/TextPreparedSelectionState;", "selection", "getSelection-d9O1mEE", "setSelection-5zc-tL8", "(J)V", "annotatedString", "getAnnotatedString", "setAnnotatedString", "(Landroidx/compose/ui/text/AnnotatedString;)V", "text", "", "getText$foundation_release", "()Ljava/lang/String;", com.bytedance.android.livesdk.chatroom.model.interact.e1.REPLY_ACTION_APPLY, "U", "resetCachedX", "", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;ZLkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "setCursor", "offset", "", "setSelection", "start", "end", "selectAll", "()Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "deselect", "moveCursorLeft", "moveCursorRight", "collapseLeftOr", SRStrategy.KEY_ORIGIN_RESOLUTION, "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection;", "collapseRightOr", "getPrecedingCodePointOrEmojiStartIndex", "getPrecedingCharacterIndex", "getNextCharacterIndex", "moveCursorPrev", "moveCursorNext", "moveCursorToHome", "moveCursorToEnd", "moveCursorLeftByWord", "moveCursorRightByWord", "getNextWordOffset", "()Ljava/lang/Integer;", "moveCursorNextByWord", "getPreviousWordOffset", "moveCursorPrevByWord", "moveCursorPrevByParagraph", "moveCursorNextByParagraph", "moveCursorUpByLine", "moveCursorDownByLine", "getLineStartByOffset", "moveCursorToLineStart", "getLineEndByOffset", "moveCursorToLineEnd", "moveCursorToLineLeftSide", "moveCursorToLineRightSide", "selectMovement", "isLtr", "getNextWordOffsetForLayout", "currentOffset", "getPrevWordOffset", "getLineStartByOffsetForLayout", "getLineEndByOffsetForLayout", "jumpByLinesOffset", "linesAmount", "transformedEndOffset", "transformedMinOffset", "transformedMaxOffset", "charOffset", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class BaseTextPreparedSelection<T extends BaseTextPreparedSelection<T>> {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final int NoCharacterFound = -1;
    private AnnotatedString annotatedString;
    private final TextLayoutResult layoutResult;
    private final OffsetMapping offsetMapping;
    private final long originalSelection;
    private final AnnotatedString originalText;
    private long selection;
    private final TextPreparedSelectionState state;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/compose/foundation/text/selection/BaseTextPreparedSelection$Companion;", "", "<init>", "()V", "NoCharacterFound", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public /* synthetic */ BaseTextPreparedSelection(AnnotatedString r100, long r101, TextLayoutResult r102, OffsetMapping r103, TextPreparedSelectionState r104, DefaultConstructorMarker r105) {
        this(r100, r101, r102, r103, r104);
    }

    private final boolean isLtr() {
        TextLayoutResult r100 = this.layoutResult;
        if (r100 == null) goto L5;
        ResolvedTextDirection r101 = r100.getParagraphDirection(transformedEndOffset());
    L7:
        if (r101 == ResolvedTextDirection.Rtl) goto L9;
        return true;
    L9:
        return false;
    L5:
        r101 = null;
        goto L7
    }

    private final int transformedEndOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m6993getEndimpl(this.selection));
    }

    private final int transformedMaxOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m6995getMaximpl(this.selection));
    }

    private final int transformedMinOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m6996getMinimpl(this.selection));
    }

    public final Integer getLineEndByOffset() {
        TextLayoutResult r100 = this.layoutResult;
        if (r100 != null) goto L5;
        return null;
    L5:
        return Integer.valueOf(getLineEndByOffsetForLayout$default(this, r100, 0, 1, null));
    }

    public final Integer getLineStartByOffset() {
        TextLayoutResult r100 = this.layoutResult;
        if (r100 != null) goto L5;
        return null;
    L5:
        return Integer.valueOf(getLineStartByOffsetForLayout$default(this, r100, 0, 1, null));
    }

    public final int getNextCharacterIndex() {
        return StringHelpers_androidKt.findFollowingBreak(this.annotatedString.getText(), TextRange.m6993getEndimpl(this.selection));
    }

    public final Integer getNextWordOffset() {
        TextLayoutResult r100 = this.layoutResult;
        if (r100 != null) goto L5;
        return null;
    L5:
        return Integer.valueOf(getNextWordOffsetForLayout$default(this, r100, 0, 1, null));
    }

    public final int getPrecedingCharacterIndex() {
        return StringHelpers_androidKt.findPrecedingBreak(this.annotatedString.getText(), TextRange.m6993getEndimpl(this.selection));
    }

    public final int getPrecedingCodePointOrEmojiStartIndex() {
        return StringHelpers_androidKt.findCodePointOrEmojiStartBefore(this.annotatedString.getText(), TextRange.m6993getEndimpl(this.selection), -1);
    }

    public final Integer getPreviousWordOffset() {
        TextLayoutResult r100 = this.layoutResult;
        if (r100 != null) goto L5;
        return null;
    L5:
        return Integer.valueOf(getPrevWordOffset$default(this, r100, 0, 1, null));
    }

    public final String getText$foundation_release() {
        return this.annotatedString.getText();
    }

    private final T moveCursorNext() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L10;
        int r101 = getNextCharacterIndex();
        if (r101 == (-1)) goto L10;
        setCursor(r101);
    L10:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r100 = false;
        goto L6
    }

    private final T moveCursorNextByWord() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L10;
        Integer r101 = getNextWordOffset();
        if (r101 == null) goto L10;
        setCursor(r101.intValue());
    L10:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r100 = false;
        goto L6
    }

    private final T moveCursorPrev() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L10;
        int r101 = getPrecedingCharacterIndex();
        if (r101 == (-1)) goto L10;
        setCursor(r101);
    L10:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r100 = false;
        goto L6
    }

    private final T moveCursorPrevByWord() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L10;
        Integer r101 = getPreviousWordOffset();
        if (r101 == null) goto L10;
        setCursor(r101.intValue());
    L10:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r100 = false;
        goto L6
    }

    public final T deselect() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        setCursor(TextRange.m6993getEndimpl(this.selection));
    L8:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r100 = false;
        goto L6
    }

    public final T moveCursorDownByLine() {
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L10;
        TextLayoutResult r101 = this.layoutResult;
        if (r101 == null) goto L10;
        setCursor(jumpByLinesOffset(r101, 1));
    L10:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r100 = false;
        goto L6
    }

    public final T moveCursorLeft() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
    L11:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L8:
        if (isLtr() == false) goto L10;
        moveCursorPrev();
        goto L11
    L10:
        moveCursorNext();
        goto L11
    L5:
        r100 = false;
        goto L6
    }

    public final T moveCursorLeftByWord() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
    L11:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L8:
        if (isLtr() == false) goto L10;
        moveCursorPrevByWord();
        goto L11
    L10:
        moveCursorNextByWord();
        goto L11
    L5:
        r100 = false;
        goto L6
    }

    public final T moveCursorNextByParagraph() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L13;
        int r101 = StringHelpersKt.findParagraphEnd(getText$foundation_release(), TextRange.m6995getMaximpl(this.selection));
        if (r101 == TextRange.m6995getMaximpl(this.selection)) goto L10;
    L12:
        setCursor(r101);
        goto L13
    L10:
        if (r101 == getText$foundation_release().length()) goto L12;
        r101 = StringHelpersKt.findParagraphEnd(getText$foundation_release(), r101 + 1);
    L13:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r100 = false;
        goto L6
    }

    public final T moveCursorPrevByParagraph() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L12;
        int r101 = StringHelpersKt.findParagraphStart(getText$foundation_release(), TextRange.m6996getMinimpl(this.selection));
        if (r101 != TextRange.m6996getMinimpl(this.selection)) goto L11;
        if (r101 == 0) goto L11;
        r101 = StringHelpersKt.findParagraphStart(getText$foundation_release(), r101 - 1);
    L11:
        setCursor(r101);
    L12:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r100 = false;
        goto L6
    }

    public final T moveCursorRight() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
    L11:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L8:
        if (isLtr() == false) goto L10;
        moveCursorNext();
        goto L11
    L10:
        moveCursorPrev();
        goto L11
    L5:
        r100 = false;
        goto L6
    }

    public final T moveCursorRightByWord() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
    L11:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L8:
        if (isLtr() == false) goto L10;
        moveCursorNextByWord();
        goto L11
    L10:
        moveCursorPrevByWord();
        goto L11
    L5:
        r100 = false;
        goto L6
    }

    public final T moveCursorToEnd() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        setCursor(getText$foundation_release().length());
    L8:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r100 = false;
        goto L6
    }

    public final T moveCursorToHome() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        setCursor(0);
    L8:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r100 = false;
        goto L6
    }

    public final T moveCursorToLineEnd() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L10;
        Integer r101 = getLineEndByOffset();
        if (r101 == null) goto L10;
        setCursor(r101.intValue());
    L10:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r100 = false;
        goto L6
    }

    public final T moveCursorToLineLeftSide() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
    L11:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L8:
        if (isLtr() == false) goto L10;
        moveCursorToLineStart();
        goto L11
    L10:
        moveCursorToLineEnd();
        goto L11
    L5:
        r100 = false;
        goto L6
    }

    public final T moveCursorToLineRightSide() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
    L11:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L8:
        if (isLtr() == false) goto L10;
        moveCursorToLineEnd();
        goto L11
    L10:
        moveCursorToLineStart();
        goto L11
    L5:
        r100 = false;
        goto L6
    }

    public final T moveCursorToLineStart() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L10;
        Integer r101 = getLineStartByOffset();
        if (r101 == null) goto L10;
        setCursor(r101.intValue());
    L10:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r100 = false;
        goto L6
    }

    public final T moveCursorUpByLine() {
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L10;
        TextLayoutResult r101 = this.layoutResult;
        if (r101 == null) goto L10;
        setCursor(jumpByLinesOffset(r101, -1));
    L10:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r100 = false;
        goto L6
    }

    public final T selectAll() {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        setSelection(0, getText$foundation_release().length());
    L8:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r100 = false;
        goto L6
    }

    public final T selectMovement() {
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        this.selection = TextRangeKt.TextRange(TextRange.m6998getStartimpl(this.originalSelection), TextRange.m6993getEndimpl(this.selection));
    L8:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L5:
        r100 = false;
        goto L6
    }

    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    public final TextLayoutResult getLayoutResult() {
        return this.layoutResult;
    }

    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    /* JADX INFO: renamed from: getOriginalSelection-d9O1mEE, reason: not valid java name */
    public final long m1436getOriginalSelectiond9O1mEE() {
        return this.originalSelection;
    }

    public final AnnotatedString getOriginalText() {
        return this.originalText;
    }

    /* JADX INFO: renamed from: getSelection-d9O1mEE, reason: not valid java name */
    public final long m1437getSelectiond9O1mEE() {
        return this.selection;
    }

    public final TextPreparedSelectionState getState() {
        return this.state;
    }

    private final int charOffset(int r100) {
        return RangesKt.coerceAtMost(r100, getText$foundation_release().length() - 1);
    }

    public final T collapseLeftOr(Function1<? super T, Unit> r100) {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L9;
    L15:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L9:
        if (TextRange.m6992getCollapsedimpl(this.selection) == false) goto L12;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        r100.invoke(this);
        goto L15
    L12:
        if (isLtr() == false) goto L14;
        setCursor(TextRange.m6996getMinimpl(this.selection));
        goto L15
    L14:
        setCursor(TextRange.m6995getMaximpl(this.selection));
        goto L15
    L5:
        r101 = false;
        goto L7
    }

    public final T collapseRightOr(Function1<? super T, Unit> r100) {
        getState().resetCachedX();
        if (getText$foundation_release().length() <= 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L9;
    L15:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return this;
    L9:
        if (TextRange.m6992getCollapsedimpl(this.selection) == false) goto L12;
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        r100.invoke(this);
        goto L15
    L12:
        if (isLtr() == false) goto L14;
        setCursor(TextRange.m6995getMaximpl(this.selection));
        goto L15
    L14:
        setCursor(TextRange.m6996getMinimpl(this.selection));
        goto L15
    L5:
        r101 = false;
        goto L7
    }

    public final void setAnnotatedString(AnnotatedString r100) {
        this.annotatedString = r100;
    }

    public final void setCursor(int r100) {
        setSelection(r100, r100);
    }

    /* JADX INFO: renamed from: setSelection-5zc-tL8, reason: not valid java name */
    public final void m1438setSelection5zctL8(long r100) {
        this.selection = r100;
    }

    private final int getLineEndByOffsetForLayout(TextLayoutResult r100, int r101) {
        int r102 = r100.getLineForOffset(r101);
        return this.offsetMapping.transformedToOriginal(r100.getLineEnd(r102, true));
    }

    private final int getLineStartByOffsetForLayout(TextLayoutResult r100, int r101) {
        int r102 = r100.getLineForOffset(r101);
        return this.offsetMapping.transformedToOriginal(r100.getLineStart(r102));
    }

    private final int getNextWordOffsetForLayout(TextLayoutResult r100, int r101) {
    L3:
        if (r101 >= this.originalText.length()) goto L5;
        long r102 = r100.m6970getWordBoundaryjx7JFs(charOffset(r101));
        if (TextRange.m6993getEndimpl(r102) > r101) goto L10;
        r101 = r101 + 1;
        goto L3
    L10:
        return this.offsetMapping.transformedToOriginal(TextRange.m6993getEndimpl(r102));
    L5:
        return this.originalText.length();
    }

    private final int getPrevWordOffset(TextLayoutResult r100, int r101) {
    L2:
        if (r101 <= 0) goto L3;
        long r102 = r100.m6970getWordBoundaryjx7JFs(charOffset(r101));
        if (TextRange.m6998getStartimpl(r102) < r101) goto L9;
        r101 = r101 - 1;
        goto L2
    L9:
        return this.offsetMapping.transformedToOriginal(TextRange.m6998getStartimpl(r102));
    L3:
        return 0;
    }

    private final int jumpByLinesOffset(TextLayoutResult r100, int r101) {
        int r102 = transformedEndOffset();
        if (this.state.getCachedX() != null) goto L5;
        this.state.setCachedX(Float.valueOf(r100.getCursorRect(r102).getLeft()));
    L5:
        int r103 = r100.getLineForOffset(r102) + r101;
        if (r103 >= 0) goto L10;
        return 0;
    L10:
        if (r103 >= r100.getLineCount()) goto L12;
        float r104 = r100.getLineBottom(r103) - 1;
        Float r105 = this.state.getCachedX();
        Intrinsics.checkNotNull(r105);
        float r106 = r105.floatValue();
        if (isLtr() == false) goto L18;
        if (r106 < r100.getLineRight(r103)) goto L18;
    L22:
        return r100.getLineEnd(r103, true);
    L18:
        if (isLtr() == true) goto L24;
        if (r106 <= r100.getLineLeft(r103)) goto L22;
    L24:
        return this.offsetMapping.transformedToOriginal(r100.m6968getOffsetForPositionk4lQ0M(Offset.m4574constructorimpl((Float.floatToRawIntBits(r105.floatValue()) << 32) | (((long) Float.floatToRawIntBits(r104)) & BodyPartID.bodyIdMax))));
    L12:
        return getText$foundation_release().length();
    }

    public final void setSelection(int r100, int r101) {
        this.selection = TextRangeKt.TextRange(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <U> T apply(U r100, boolean r101, Function1<? super U, Unit> r102) {
        if (r101 == false) goto L5;
        getState().resetCachedX();
    L5:
        if (getText$foundation_release().length() <= 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L10;
        r102.invoke(r100);
    L10:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (T) r100;
    L7:
        r103 = false;
        goto L8
    }

    private BaseTextPreparedSelection(AnnotatedString r100, long r101, TextLayoutResult r102, OffsetMapping r103, TextPreparedSelectionState r104) {
        this.originalText = r100;
        this.originalSelection = r101;
        this.layoutResult = r102;
        this.offsetMapping = r103;
        this.state = r104;
        this.selection = r101;
        this.annotatedString = r100;
    }

    public static /* synthetic */ int getLineEndByOffsetForLayout$default(BaseTextPreparedSelection r100, TextLayoutResult r101, int r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L7;
        r102 = r100.transformedMaxOffset();
    L7:
        return r100.getLineEndByOffsetForLayout(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineEndByOffsetForLayout");
    }

    public static /* synthetic */ int getLineStartByOffsetForLayout$default(BaseTextPreparedSelection r100, TextLayoutResult r101, int r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L7;
        r102 = r100.transformedMinOffset();
    L7:
        return r100.getLineStartByOffsetForLayout(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLineStartByOffsetForLayout");
    }

    public static /* synthetic */ int getNextWordOffsetForLayout$default(BaseTextPreparedSelection r100, TextLayoutResult r101, int r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L7;
        r102 = r100.transformedEndOffset();
    L7:
        return r100.getNextWordOffsetForLayout(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getNextWordOffsetForLayout");
    }

    public static /* synthetic */ int getPrevWordOffset$default(BaseTextPreparedSelection r100, TextLayoutResult r101, int r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 1) == 0) goto L7;
        r102 = r100.transformedEndOffset();
    L7:
        return r100.getPrevWordOffset(r101, r102);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPrevWordOffset");
    }

    public static /* synthetic */ BaseTextPreparedSelection apply$default(BaseTextPreparedSelection r100, Object r101, boolean r102, Function1 r103, int r104, Object r105) {
        if (r105 != null) goto L17;
        boolean r106 = true;
        if ((r104 & 1) == 0) goto L6;
        r102 = true;
    L6:
        if (r102 == false) goto L9;
        r100.getState().resetCachedX();
    L9:
        if (r100.getText$foundation_release().length() > 0) goto L12;
        r106 = false;
    L12:
        if (r106 == false) goto L14;
        r103.invoke(r101);
    L14:
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type T of androidx.compose.foundation.text.selection.BaseTextPreparedSelection");
        return (BaseTextPreparedSelection) r101;
    L17:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: apply");
    }
}
