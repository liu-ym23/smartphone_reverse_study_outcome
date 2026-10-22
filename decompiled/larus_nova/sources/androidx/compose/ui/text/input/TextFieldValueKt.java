package androidx.compose.ui.text.input;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0007"}, d2 = {"getTextBeforeSelection", "Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/text/input/TextFieldValue;", "maxChars", "", "getTextAfterSelection", "getSelectedText", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldValueKt {
    public static final AnnotatedString getSelectedText(TextFieldValue r100) {
        return r100.getAnnotatedString().m6833subSequence5zctL8(r100.m7249getSelectiond9O1mEE());
    }

    public static final AnnotatedString getTextAfterSelection(TextFieldValue r100, int r101) {
        return r100.getAnnotatedString().subSequence(TextRange.m6995getMaximpl(r100.m7249getSelectiond9O1mEE()), Math.min(TextRange.m6995getMaximpl(r100.m7249getSelectiond9O1mEE()) + r101, r100.getText().length()));
    }

    public static final AnnotatedString getTextBeforeSelection(TextFieldValue r100, int r101) {
        return r100.getAnnotatedString().subSequence(Math.max(0, TextRange.m6996getMinimpl(r100.m7249getSelectiond9O1mEE()) - r101), TextRange.m6996getMinimpl(r100.m7249getSelectiond9O1mEE()));
    }
}
