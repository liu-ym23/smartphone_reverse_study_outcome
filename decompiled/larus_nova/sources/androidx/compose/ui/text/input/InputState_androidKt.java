package androidx.compose.ui.text.input;

import android.view.inputmethod.ExtractedText;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toExtractedText", "Landroid/view/inputmethod/ExtractedText;", "Landroidx/compose/ui/text/input/TextFieldValue;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class InputState_androidKt {
    public static final ExtractedText toExtractedText(TextFieldValue r100) {
        ExtractedText r101 = new ExtractedText();
        r101.text = r100.getText();
        r101.startOffset = 0;
        r101.partialEndOffset = r100.getText().length();
        r101.partialStartOffset = -1;
        r101.selectionStart = TextRange.m6996getMinimpl(r100.m7249getSelectiond9O1mEE());
        r101.selectionEnd = TextRange.m6995getMaximpl(r100.m7249getSelectiond9O1mEE());
        r101.flags = !StringsKt.contains$default(r100.getText(), '\n', false, 2, null) ? 1 : 0;
        return r101;
    }
}
