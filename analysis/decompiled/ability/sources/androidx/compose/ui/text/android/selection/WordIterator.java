package androidx.compose.ui.text.android.selection;

import B7.a;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.android.CharSequenceCharacterIterator;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.emoji2.text.EmojiCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.lang.Character;
import java.text.BreakIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 *2\u00020\u0001:\u0001*B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0013J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0013J\u0017\u0010\u001b\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u0013J\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u001e\u0010\u001dJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u001dJ\u0015\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u001f\u0010\u001dJ\u0015\u0010 \u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b \u0010\u001dJ\u0015\u0010!\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b!\u0010\u0013J\u0015\u0010\"\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010%R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010&R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006+"}, d2 = {"Landroidx/compose/ui/text/android/selection/WordIterator;", "", "", "charSequence", "", "start", "end", "Ljava/util/Locale;", "locale", AppAgent.CONSTRUCT, "(Ljava/lang/CharSequence;IILjava/util/Locale;)V", TypedValues.CycleType.S_WAVE_OFFSET, "", "getPrevWordBeginningOnTwoWordsBoundary", "getBeginning", "(IZ)I", "getNextWordEndOnTwoWordBoundary", "getEnd", "isPunctuationStartBoundary", "(I)Z", "isPunctuationEndBoundary", "isAfterLetterOrDigitOrEmoji", "isOnLetterOrDigitOrEmoji", "LC7/r;", "checkOffsetIsValid", "(I)V", "isBoundary", "isHiraganaKatakanaBoundary", "nextBoundary", "(I)I", "prevBoundary", "getPunctuationBeginning", "getPunctuationEnd", "isAfterPunctuation", "isOnPunctuation", "Ljava/lang/CharSequence;", "getCharSequence", "()Ljava/lang/CharSequence;", "I", "Ljava/text/BreakIterator;", "iterator", "Ljava/text/BreakIterator;", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WordIterator {
    private static final int WINDOW_WIDTH = 50;
    private final CharSequence charSequence;
    private final int end;
    private final BreakIterator iterator;
    private final int start;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/compose/ui/text/android/selection/WordIterator$Companion;", "", AppAgent.CONSTRUCT, "()V", "WINDOW_WIDTH", "", "isPunctuation", "", "cp", "isPunctuation$ui_text", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final boolean isPunctuation$ui_text(int cp) {
            int type = Character.getType(cp);
            return type == 23 || type == 20 || type == 22 || type == 30 || type == 29 || type == 24 || type == 21;
        }

        private Companion() {
        }
    }

    public WordIterator(CharSequence charSequence, int i, int i6, Locale locale) {
        this.charSequence = charSequence;
        if (!(i >= 0 && i <= charSequence.length())) {
            InlineClassHelperKt.throwIllegalArgumentException("input start index is outside the CharSequence");
        }
        if (!(i6 >= 0 && i6 <= charSequence.length())) {
            InlineClassHelperKt.throwIllegalArgumentException("input end index is outside the CharSequence");
        }
        BreakIterator wordInstance = BreakIterator.getWordInstance(locale);
        this.iterator = wordInstance;
        this.start = Math.max(0, i - 50);
        this.end = Math.min(charSequence.length(), i6 + 50);
        wordInstance.setText(new CharSequenceCharacterIterator(charSequence, i, i6));
    }

    private final void checkOffsetIsValid(int offset) {
        int i = this.start;
        boolean z10 = false;
        if (offset <= this.end && i <= offset) {
            z10 = true;
        }
        if (z10) {
            return;
        }
        StringBuilder sbU = a.u(offset, "Invalid offset: ", ". Valid range is [");
        sbU.append(this.start);
        sbU.append(" , ");
        sbU.append(this.end);
        sbU.append(']');
        InlineClassHelperKt.throwIllegalArgumentException(sbU.toString());
    }

    private final int getBeginning(int offset, boolean getPrevWordBeginningOnTwoWordsBoundary) {
        checkOffsetIsValid(offset);
        if (isOnLetterOrDigitOrEmoji(offset)) {
            return (!isBoundary(offset) || (isAfterLetterOrDigitOrEmoji(offset) && getPrevWordBeginningOnTwoWordsBoundary)) ? prevBoundary(offset) : offset;
        }
        if (isAfterLetterOrDigitOrEmoji(offset)) {
            return prevBoundary(offset);
        }
        return -1;
    }

    private final int getEnd(int offset, boolean getNextWordEndOnTwoWordBoundary) {
        checkOffsetIsValid(offset);
        if (isAfterLetterOrDigitOrEmoji(offset)) {
            return (!isBoundary(offset) || (isOnLetterOrDigitOrEmoji(offset) && getNextWordEndOnTwoWordBoundary)) ? nextBoundary(offset) : offset;
        }
        if (isOnLetterOrDigitOrEmoji(offset)) {
            return nextBoundary(offset);
        }
        return -1;
    }

    private final boolean isAfterLetterOrDigitOrEmoji(int offset) {
        int i = this.start + 1;
        if (offset > this.end || i > offset) {
            return false;
        }
        if (Character.isLetterOrDigit(Character.codePointBefore(this.charSequence, offset))) {
            return true;
        }
        int i6 = offset - 1;
        if (Character.isSurrogate(this.charSequence.charAt(i6))) {
            return true;
        }
        if (!EmojiCompat.isConfigured()) {
            return false;
        }
        EmojiCompat emojiCompat = EmojiCompat.get();
        return emojiCompat.getLoadState() == 1 && emojiCompat.getEmojiStart(this.charSequence, i6) != -1;
    }

    private final boolean isBoundary(int offset) {
        checkOffsetIsValid(offset);
        if (!this.iterator.isBoundary(offset)) {
            return false;
        }
        if (isOnLetterOrDigitOrEmoji(offset) && isOnLetterOrDigitOrEmoji(offset - 1) && isOnLetterOrDigitOrEmoji(offset + 1)) {
            return false;
        }
        return offset <= 0 || offset >= this.charSequence.length() - 1 || !(isHiraganaKatakanaBoundary(offset) || isHiraganaKatakanaBoundary(offset + 1));
    }

    private final boolean isHiraganaKatakanaBoundary(int offset) {
        int i = offset - 1;
        Character.UnicodeBlock unicodeBlockOf = Character.UnicodeBlock.of(this.charSequence.charAt(i));
        Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.HIRAGANA;
        if (k.b(unicodeBlockOf, unicodeBlock) && k.b(Character.UnicodeBlock.of(this.charSequence.charAt(offset)), Character.UnicodeBlock.KATAKANA)) {
            return true;
        }
        return k.b(Character.UnicodeBlock.of(this.charSequence.charAt(offset)), unicodeBlock) && k.b(Character.UnicodeBlock.of(this.charSequence.charAt(i)), Character.UnicodeBlock.KATAKANA);
    }

    private final boolean isOnLetterOrDigitOrEmoji(int offset) {
        int i = this.start;
        if (offset >= this.end || i > offset) {
            return false;
        }
        if (Character.isLetterOrDigit(Character.codePointAt(this.charSequence, offset)) || Character.isSurrogate(this.charSequence.charAt(offset))) {
            return true;
        }
        if (!EmojiCompat.isConfigured()) {
            return false;
        }
        EmojiCompat emojiCompat = EmojiCompat.get();
        return emojiCompat.getLoadState() == 1 && emojiCompat.getEmojiStart(this.charSequence, offset) != -1;
    }

    private final boolean isPunctuationEndBoundary(int offset) {
        return !isOnPunctuation(offset) && isAfterPunctuation(offset);
    }

    private final boolean isPunctuationStartBoundary(int offset) {
        return isOnPunctuation(offset) && !isAfterPunctuation(offset);
    }

    public final CharSequence getCharSequence() {
        return this.charSequence;
    }

    public final int getNextWordEndOnTwoWordBoundary(int offset) {
        return getEnd(offset, true);
    }

    public final int getPrevWordBeginningOnTwoWordsBoundary(int offset) {
        return getBeginning(offset, true);
    }

    public final int getPunctuationBeginning(int offset) {
        checkOffsetIsValid(offset);
        while (offset != -1 && !isPunctuationStartBoundary(offset)) {
            offset = prevBoundary(offset);
        }
        return offset;
    }

    public final int getPunctuationEnd(int offset) {
        checkOffsetIsValid(offset);
        while (offset != -1 && !isPunctuationEndBoundary(offset)) {
            offset = nextBoundary(offset);
        }
        return offset;
    }

    public final boolean isAfterPunctuation(int offset) {
        int i = this.start + 1;
        if (offset > this.end || i > offset) {
            return false;
        }
        return INSTANCE.isPunctuation$ui_text(Character.codePointBefore(this.charSequence, offset));
    }

    public final boolean isOnPunctuation(int offset) {
        int i = this.start;
        if (offset >= this.end || i > offset) {
            return false;
        }
        return INSTANCE.isPunctuation$ui_text(Character.codePointAt(this.charSequence, offset));
    }

    public final int nextBoundary(int offset) {
        checkOffsetIsValid(offset);
        int iFollowing = this.iterator.following(offset);
        return (isOnLetterOrDigitOrEmoji(iFollowing + (-1)) && isOnLetterOrDigitOrEmoji(iFollowing) && !isHiraganaKatakanaBoundary(iFollowing)) ? nextBoundary(iFollowing) : iFollowing;
    }

    public final int prevBoundary(int offset) {
        checkOffsetIsValid(offset);
        int iPreceding = this.iterator.preceding(offset);
        return (isOnLetterOrDigitOrEmoji(iPreceding) && isAfterLetterOrDigitOrEmoji(iPreceding) && !isHiraganaKatakanaBoundary(iPreceding)) ? prevBoundary(iPreceding) : iPreceding;
    }
}
