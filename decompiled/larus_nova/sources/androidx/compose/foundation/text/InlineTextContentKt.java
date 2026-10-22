package androidx.compose.foundation.text;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"INLINE_CONTENT_TAG", "", "REPLACEMENT_CHAR", "appendInlineContent", "", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "id", "alternateText", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class InlineTextContentKt {
    public static final String INLINE_CONTENT_TAG = "androidx.compose.foundation.text.inlineContent";
    private static final String REPLACEMENT_CHAR = "�";

    public static final void appendInlineContent(AnnotatedString.Builder r100, String r101, String r102) {
        if (r102.length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("alternateText can't be an empty string.");
    L8:
        r100.pushStringAnnotation(INLINE_CONTENT_TAG, r101);
        r100.append(r102);
        r100.pop();
        return;
    L5:
        r103 = false;
        goto L6
    }

    public static /* synthetic */ void appendInlineContent$default(AnnotatedString.Builder r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = REPLACEMENT_CHAR;
    L5:
        appendInlineContent(r100, r101, r102);
    }
}
