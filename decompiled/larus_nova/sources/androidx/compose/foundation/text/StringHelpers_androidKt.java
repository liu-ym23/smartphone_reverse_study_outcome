package androidx.compose.foundation.text;

import androidx.emoji2.text.EmojiCompat;
import java.text.BreakIterator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0002\u001a\u001c\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¨\u0006\u000b"}, d2 = {"findPrecedingBreak", "", "", "index", "findFollowingBreak", "findCodePointBefore", "", "ifNotFound", "findCodePointOrEmojiStartBefore", "getEmojiCompatIfLoaded", "Landroidx/emoji2/text/EmojiCompat;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class StringHelpers_androidKt {
    private static final EmojiCompat getEmojiCompatIfLoaded() {
        if (EmojiCompat.isConfigured() == false) goto L11;
        EmojiCompat r100 = EmojiCompat.get();
        boolean r101 = true;
        if (r100.getLoadState() == 1) goto L8;
        r101 = false;
    L8:
        if (r101 == true) goto L10;
        return null;
    L10:
        return r100;
    L11:
        return null;
    }

    public static final int findFollowingBreak(String r100, int r101) {
        EmojiCompat r102 = getEmojiCompatIfLoaded();
        Integer r103 = null;
        if (r102 == null) goto L10;
        Integer r104 = Integer.valueOf(r102.getEmojiEnd(r100, r101));
        if (r104.intValue() != (-1)) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L10;
        r103 = r104;
        goto L10
    L7:
        r105 = false;
    L10:
        if (r103 != null) goto L12;
        BreakIterator r106 = BreakIterator.getCharacterInstance();
        r106.setText(r100);
        return r106.following(r101);
    L12:
        return r103.intValue();
    }

    public static final int findPrecedingBreak(String r100, int r101) {
        EmojiCompat r102 = getEmojiCompatIfLoaded();
        Integer r103 = null;
        if (r102 == null) goto L9;
        boolean r104 = false;
        Integer r105 = Integer.valueOf(r102.getEmojiStart(r100, Math.max(0, r101 - 1)));
        if (r105.intValue() != (-1)) goto L7;
        r104 = true;
    L7:
        if (r104 == true) goto L9;
        r103 = r105;
    L9:
        if (r103 != null) goto L11;
        BreakIterator r106 = BreakIterator.getCharacterInstance();
        r106.setText(r100);
        return r106.preceding(r101);
    L11:
        return r103.intValue();
    }

    private static final int findCodePointBefore(CharSequence r100, int r101, int r102) {
        if (r101 > 0) goto L5;
        return r102;
    L5:
        return Character.offsetByCodePoints(r100, r101, -1);
    }

    public static final int findCodePointOrEmojiStartBefore(String r100, int r101, int r102) {
        if (r101 > 0) goto L4;
        return r102;
    L4:
        EmojiCompat r103 = getEmojiCompatIfLoaded();
        if (r103 == null) goto L7;
        int r104 = r103.getEmojiStart(r100, r101 - 1);
        if (r104 < 0) goto L11;
        return r104;
    L11:
        return findCodePointBefore(r100, r101, r102);
    L7:
        return findCodePointBefore(r100, r101, r102);
    }
}
