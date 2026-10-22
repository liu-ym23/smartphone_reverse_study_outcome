package androidx.compose.ui.text.android.selection;

import androidx.compose.ui.text.android.CharSequenceCharacterIterator;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.emoji2.text.EmojiCompat;
import java.text.BreakIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 #2\u00020\u0001:\u0001#B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0005J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0017H\u0002J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0005H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/compose/ui/text/android/selection/WordIterator;", "", "charSequence", "", "start", "", "end", "locale", "Ljava/util/Locale;", "<init>", "(Ljava/lang/CharSequence;IILjava/util/Locale;)V", "getCharSequence", "()Ljava/lang/CharSequence;", "iterator", "Ljava/text/BreakIterator;", "nextBoundary", "offset", "prevBoundary", "getPrevWordBeginningOnTwoWordsBoundary", "getNextWordEndOnTwoWordBoundary", "getPunctuationBeginning", "getPunctuationEnd", "isAfterPunctuation", "", "isOnPunctuation", "getBeginning", "getEnd", "isPunctuationStartBoundary", "isPunctuationEndBoundary", "isAfterLetterOrDigitOrEmoji", "isOnLetterOrDigitOrEmoji", "checkOffsetIsValid", "", "isBoundary", "isHiraganaKatakanaBoundary", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WordIterator {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final int WINDOW_WIDTH = 50;
    private final CharSequence charSequence;
    private final int end;
    private final BreakIterator iterator;
    private final int start;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/compose/ui/text/android/selection/WordIterator$Companion;", "", "<init>", "()V", "WINDOW_WIDTH", "", "isPunctuation", "", "cp", "isPunctuation$ui_text", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final boolean isPunctuation$ui_text(int r100) {
            int r101 = Character.getType(r100);
            if (r101 != 23) goto L5;
        L18:
            return true;
        L5:
            if (r101 == 20) goto L18;
            if (r101 == 22) goto L18;
            if (r101 == 30) goto L18;
            if (r101 == 29) goto L18;
            if (r101 == 24) goto L18;
            if (r101 == 21) goto L18;
            return false;
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public final CharSequence getCharSequence() {
        return this.charSequence;
    }

    private final void checkOffsetIsValid(int r100) {
        int r101 = this.start;
        boolean r102 = false;
        if (r100 > this.end) goto L6;
        if (r101 > r100) goto L6;
        r102 = true;
    L6:
        if (r102 == true) goto L9;
        InlineClassHelperKt.throwIllegalArgumentException("Invalid offset: " + r100 + ". Valid range is [" + this.start + " , " + this.end + ']');
        return;
    }

    private final boolean isAfterLetterOrDigitOrEmoji(int r100) {
        int r101 = this.start + 1;
        if (r100 > this.end) goto L6;
        if (r101 > r100) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L9;
    L21:
        return false;
    L9:
        if (Character.isLetterOrDigit(Character.codePointBefore(this.charSequence, r100)) == false) goto L11;
        return true;
    L11:
        int r103 = r100 - 1;
        if (Character.isSurrogate(this.charSequence.charAt(r103)) == false) goto L15;
        return true;
    L15:
        if (EmojiCompat.isConfigured() == false) goto L21;
        EmojiCompat r104 = EmojiCompat.get();
        if (r104.getLoadState() != 1) goto L21;
        if (r104.getEmojiStart(this.charSequence, r103) == (-1)) goto L21;
        return true;
    L6:
        r102 = false;
        goto L7
    }

    private final boolean isBoundary(int r100) {
        checkOffsetIsValid(r100);
        if (this.iterator.isBoundary(r100) == true) goto L5;
    L19:
        return false;
    L5:
        if (isOnLetterOrDigitOrEmoji(r100) == false) goto L11;
        if (isOnLetterOrDigitOrEmoji(r100 - 1) == false) goto L11;
        if (isOnLetterOrDigitOrEmoji(r100 + 1) == true) goto L19;
    L11:
        if (r100 > 0) goto L13;
        return true;
    L13:
        if (r100 < (this.charSequence.length() - 1)) goto L15;
        return true;
    L15:
        if (isHiraganaKatakanaBoundary(r100) == true) goto L19;
        if (isHiraganaKatakanaBoundary(r100 + 1) == true) goto L19;
        return true;
    }

    private final boolean isHiraganaKatakanaBoundary(int r100) {
        int r101 = r100 - 1;
        if (Intrinsics.areEqual(Character.UnicodeBlock.of(this.charSequence.charAt(r101)), Character.UnicodeBlock.HIRAGANA) == false) goto L7;
        if (Intrinsics.areEqual(Character.UnicodeBlock.of(this.charSequence.charAt(r100)), Character.UnicodeBlock.KATAKANA) == false) goto L7;
    L10:
        return true;
    L7:
        if (Intrinsics.areEqual(Character.UnicodeBlock.of(this.charSequence.charAt(r100)), Character.UnicodeBlock.HIRAGANA) == true) goto L9;
    L11:
        return false;
    L9:
        if (Intrinsics.areEqual(Character.UnicodeBlock.of(this.charSequence.charAt(r101)), Character.UnicodeBlock.KATAKANA) == false) goto L11;
        goto L10
    }

    private final boolean isOnLetterOrDigitOrEmoji(int r100) {
        int r101 = this.start;
        if (r100 >= this.end) goto L6;
        if (r101 > r100) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L9;
    L21:
        return false;
    L9:
        if (Character.isLetterOrDigit(Character.codePointAt(this.charSequence, r100)) == false) goto L12;
        return true;
    L12:
        if (Character.isSurrogate(this.charSequence.charAt(r100)) == false) goto L15;
        return true;
    L15:
        if (EmojiCompat.isConfigured() == false) goto L21;
        EmojiCompat r103 = EmojiCompat.get();
        if (r103.getLoadState() != 1) goto L21;
        if (r103.getEmojiStart(this.charSequence, r100) == (-1)) goto L21;
        return true;
    L6:
        r102 = false;
        goto L7
    }

    private final boolean isPunctuationEndBoundary(int r100) {
        if (isOnPunctuation(r100) == false) goto L5;
    L7:
        return false;
    L5:
        if (isAfterPunctuation(r100) == false) goto L7;
        return true;
    }

    private final boolean isPunctuationStartBoundary(int r100) {
        if (isOnPunctuation(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (isAfterPunctuation(r100) == true) goto L7;
        return true;
    }

    public final int getNextWordEndOnTwoWordBoundary(int r100) {
        return getEnd(r100, true);
    }

    public final int getPrevWordBeginningOnTwoWordsBoundary(int r100) {
        return getBeginning(r100, true);
    }

    public final int getPunctuationBeginning(int r100) {
        checkOffsetIsValid(r100);
    L4:
        if (r100 == (-1)) goto L8;
        if (isPunctuationStartBoundary(r100) == true) goto L8;
        r100 = prevBoundary(r100);
    L8:
        return r100;
    }

    public final int getPunctuationEnd(int r100) {
        checkOffsetIsValid(r100);
    L4:
        if (r100 == (-1)) goto L8;
        if (isPunctuationEndBoundary(r100) == true) goto L8;
        r100 = nextBoundary(r100);
    L8:
        return r100;
    }

    public final boolean isAfterPunctuation(int r100) {
        boolean r101 = true;
        int r102 = this.start + 1;
        if (r100 > this.end) goto L6;
        if (r102 > r100) goto L6;
    L7:
        if (r101 == false) goto L10;
        int r103 = Character.codePointBefore(this.charSequence, r100);
        return Companion.isPunctuation$ui_text(r103);
    L10:
        return false;
    L6:
        r101 = false;
        goto L7
    }

    public final boolean isOnPunctuation(int r100) {
        int r101 = this.start;
        if (r100 >= this.end) goto L6;
        if (r101 > r100) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L10;
        int r103 = Character.codePointAt(this.charSequence, r100);
        return Companion.isPunctuation$ui_text(r103);
    L10:
        return false;
    L6:
        r102 = false;
        goto L7
    }

    public final int nextBoundary(int r100) {
        checkOffsetIsValid(r100);
        int r101 = this.iterator.following(r100);
        if (isOnLetterOrDigitOrEmoji(r101 - 1) == true) goto L5;
        return r101;
    L5:
        if (isOnLetterOrDigitOrEmoji(r101) == true) goto L7;
        return r101;
    L7:
        if (isHiraganaKatakanaBoundary(r101) == false) goto L9;
        return r101;
    L9:
        return nextBoundary(r101);
    }

    public final int prevBoundary(int r100) {
        checkOffsetIsValid(r100);
        int r101 = this.iterator.preceding(r100);
        if (isOnLetterOrDigitOrEmoji(r101) == true) goto L5;
        return r101;
    L5:
        if (isAfterLetterOrDigitOrEmoji(r101) == true) goto L7;
        return r101;
    L7:
        if (isHiraganaKatakanaBoundary(r101) == false) goto L9;
        return r101;
    L9:
        return prevBoundary(r101);
    }

    private final int getBeginning(int r100, boolean r101) {
        checkOffsetIsValid(r100);
        if (isOnLetterOrDigitOrEmoji(r100) == false) goto L13;
        if (isBoundary(r100) == false) goto L11;
        if (isAfterLetterOrDigitOrEmoji(r100) == false) goto L18;
        if (r101 == true) goto L11;
        return r100;
    L18:
        return r100;
    L11:
        return prevBoundary(r100);
    L13:
        if (isAfterLetterOrDigitOrEmoji(r100) == true) goto L15;
        return -1;
    L15:
        return prevBoundary(r100);
    }

    private final int getEnd(int r100, boolean r101) {
        checkOffsetIsValid(r100);
        if (isAfterLetterOrDigitOrEmoji(r100) == false) goto L13;
        if (isBoundary(r100) == false) goto L11;
        if (isOnLetterOrDigitOrEmoji(r100) == false) goto L18;
        if (r101 == true) goto L11;
        return r100;
    L18:
        return r100;
    L11:
        return nextBoundary(r100);
    L13:
        if (isOnLetterOrDigitOrEmoji(r100) == true) goto L15;
        return -1;
    L15:
        return nextBoundary(r100);
    }

    public WordIterator(CharSequence r100, int r101, int r102, Locale r103) {
        this.charSequence = r100;
        boolean r104 = true;
        if (r101 >= 0) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == true) goto L10;
        InlineClassHelperKt.throwIllegalArgumentException("input start index is outside the CharSequence");
    L10:
        if (r102 >= 0) goto L12;
    L14:
        r104 = false;
    L15:
        if (r104 == true) goto L17;
        InlineClassHelperKt.throwIllegalArgumentException("input end index is outside the CharSequence");
    L17:
        BreakIterator r106 = BreakIterator.getWordInstance(r103);
        this.iterator = r106;
        this.start = Math.max(0, r101 - 50);
        this.end = Math.min(r100.length(), r102 + 50);
        r106.setText(new CharSequenceCharacterIterator(r100, r101, r102));
        return;
    L12:
        if (r102 > r100.length()) goto L14;
    L5:
        if (r101 > r100.length()) goto L7;
        r105 = true;
        goto L8
    }
}
