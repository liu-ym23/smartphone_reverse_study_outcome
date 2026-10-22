package androidx.compose.ui.text.android.selection;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0005"}, d2 = {"getWordStart", "", "Landroidx/compose/ui/text/android/selection/WordIterator;", "offset", "getWordEnd", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WordBoundary_androidKt {
    public static final int getWordEnd(WordIterator r100, int r101) {
        if (r100.isAfterPunctuation(r100.nextBoundary(r101)) == false) goto L5;
        int r102 = r100.getPunctuationEnd(r101);
    L7:
        if (r102 != (-1)) goto L10;
        return r101;
    L10:
        return r102;
    L5:
        r102 = r100.getNextWordEndOnTwoWordBoundary(r101);
        goto L7
    }

    public static final int getWordStart(WordIterator r100, int r101) {
        if (r100.isOnPunctuation(r100.prevBoundary(r101)) == false) goto L5;
        int r102 = r100.getPunctuationBeginning(r101);
    L7:
        if (r102 != (-1)) goto L10;
        return r101;
    L10:
        return r102;
    L5:
        r102 = r100.getPrevWordBeginningOnTwoWordsBoundary(r101);
        goto L7
    }
}
