package androidx.compose.ui.text;

import java.text.BreakIterator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0005"}, d2 = {"findPrecedingBreak", "", "", "index", "findFollowingBreak", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class JvmCharHelpers_androidKt {
    public static final int findFollowingBreak(String r100, int r101) {
        BreakIterator r102 = BreakIterator.getCharacterInstance();
        r102.setText(r100);
        return r102.following(r101);
    }

    public static final int findPrecedingBreak(String r100, int r101) {
        BreakIterator r102 = BreakIterator.getCharacterInstance();
        r102.setText(r100);
        return r102.preceding(r101);
    }
}
