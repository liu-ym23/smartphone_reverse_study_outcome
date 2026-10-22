package androidx.compose.foundation.text.input.internal.undo;

import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.EditingBuffer;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0005¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/text/input/TextFieldState;", "Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;", "op", "LC7/r;", "undo", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/foundation/text/input/internal/undo/TextUndoOperation;)V", "redo", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextUndoOperationKt {
    public static final void redo(TextFieldState textFieldState, TextUndoOperation textUndoOperation) {
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer = textFieldState.getMainBuffer();
        mainBuffer.replace(textUndoOperation.getIndex(), textUndoOperation.getPreText().length() + textUndoOperation.getIndex(), textUndoOperation.getPostText());
        mainBuffer.setSelection(TextRange.m6311getStartimpl(textUndoOperation.getPostSelection()), TextRange.m6306getEndimpl(textUndoOperation.getPostSelection()));
        textFieldState.updateValueAndNotifyListeners(textFieldState.getValue$foundation_release(), new TextFieldCharSequence(textFieldState.getMainBuffer().toString(), textFieldState.getMainBuffer().m1173getSelectiond9O1mEE(), textFieldState.getMainBuffer().m1172getCompositionMzsxiRA(), null, 8, null), true);
    }

    public static final void undo(TextFieldState textFieldState, TextUndoOperation textUndoOperation) {
        textFieldState.getMainBuffer().getChangeTracker().clearChanges();
        EditingBuffer mainBuffer = textFieldState.getMainBuffer();
        mainBuffer.replace(textUndoOperation.getIndex(), textUndoOperation.getPostText().length() + textUndoOperation.getIndex(), textUndoOperation.getPreText());
        mainBuffer.setSelection(TextRange.m6311getStartimpl(textUndoOperation.getPreSelection()), TextRange.m6306getEndimpl(textUndoOperation.getPreSelection()));
        textFieldState.updateValueAndNotifyListeners(textFieldState.getValue$foundation_release(), new TextFieldCharSequence(textFieldState.getMainBuffer().toString(), textFieldState.getMainBuffer().m1173getSelectiond9O1mEE(), textFieldState.getMainBuffer().m1172getCompositionMzsxiRA(), null, 8, null), true);
    }
}
