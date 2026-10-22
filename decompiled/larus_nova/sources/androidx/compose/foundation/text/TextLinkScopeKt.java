package androidx.compose.foundation.text;

import androidx.compose.ui.text.TextLinkStyles;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0003\u001a\u00020\u0004*\u0004\u0018\u00010\u0005H\u0002*\u0018\b\u0000\u0010\u0000\"\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0006"}, d2 = {"LinkRange", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/LinkAnnotation;", "isNullOrEmpty", "", "Landroidx/compose/ui/text/TextLinkStyles;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextLinkScopeKt {
    public static final /* synthetic */ boolean access$isNullOrEmpty(TextLinkStyles r100) {
        return isNullOrEmpty(r100);
    }

    private static final boolean isNullOrEmpty(TextLinkStyles r100) {
        if (r100 != null) goto L4;
    L13:
        return true;
    L4:
        if (r100.getStyle() == null) goto L6;
    L12:
        return false;
    L6:
        if (r100.getFocusedStyle() != null) goto L12;
        if (r100.getHoveredStyle() != null) goto L12;
        if (r100.getPressedStyle() != null) goto L12;
        goto L12
    }
}
