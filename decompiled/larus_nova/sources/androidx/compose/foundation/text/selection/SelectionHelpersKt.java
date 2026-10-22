package androidx.compose.foundation.text.selection;

import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0007"}, d2 = {"getTextDirectionForOffset", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "Landroidx/compose/ui/text/TextLayoutResult;", "offset", "", "isOffsetAnEmptyLine", "", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SelectionHelpersKt {
    public static final ResolvedTextDirection getTextDirectionForOffset(TextLayoutResult r100, int r101) {
        if (isOffsetAnEmptyLine(r100, r101) == false) goto L6;
        return r100.getParagraphDirection(r101);
    L6:
        return r100.getBidiRunDirection(r101);
    }

    private static final boolean isOffsetAnEmptyLine(TextLayoutResult r100, int r101) {
        if (r100.getLayoutInput().getText().length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L19;
        int r103 = r100.getLineForOffset(r101);
        if (r101 == 0) goto L12;
        if (r103 != r100.getLineForOffset(r101 - 1)) goto L12;
    L16:
        boolean r104 = false;
    L18:
        if (r104 == true) goto L19;
        return false;
    L12:
        if (r101 != r100.getLayoutInput().getText().length()) goto L14;
    L17:
        r104 = true;
        goto L18
    L14:
        if (r103 == r100.getLineForOffset(r101 + 1)) goto L16;
    L19:
        return true;
    L5:
        r102 = false;
        goto L6
    }
}
