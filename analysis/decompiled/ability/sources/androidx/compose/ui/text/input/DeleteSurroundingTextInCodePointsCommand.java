package androidx.compose.ui.text.input;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\u0012¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/text/input/DeleteSurroundingTextInCodePointsCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "", "lengthBeforeCursor", "lengthAfterCursor", AppAgent.CONSTRUCT, "(II)V", "Landroidx/compose/ui/text/input/EditingBuffer;", "buffer", "LC7/r;", "applyTo", "(Landroidx/compose/ui/text/input/EditingBuffer;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "I", "getLengthBeforeCursor", "getLengthAfterCursor", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DeleteSurroundingTextInCodePointsCommand implements EditCommand {
    public static final int $stable = 0;
    private final int lengthAfterCursor;
    private final int lengthBeforeCursor;

    public DeleteSurroundingTextInCodePointsCommand(int i, int i6) {
        this.lengthBeforeCursor = i;
        this.lengthAfterCursor = i6;
        if (i >= 0 && i6 >= 0) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i + " and " + i6 + " respectively.");
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void applyTo(EditingBuffer buffer) {
        int i = this.lengthBeforeCursor;
        int i6 = 0;
        int i10 = 0;
        int selectionStart = 0;
        while (true) {
            if (i10 < i) {
                int i11 = selectionStart + 1;
                if (buffer.getSelectionStart() <= i11) {
                    selectionStart = buffer.getSelectionStart();
                    break;
                } else {
                    selectionStart = EditCommandKt.isSurrogatePair(buffer.get$ui_text((buffer.getSelectionStart() - i11) + (-1)), buffer.get$ui_text(buffer.getSelectionStart() - i11)) ? selectionStart + 2 : i11;
                    i10++;
                }
            } else {
                break;
            }
        }
        int i12 = this.lengthAfterCursor;
        int length$ui_text = 0;
        while (true) {
            if (i6 >= i12) {
                break;
            }
            int i13 = length$ui_text + 1;
            if (buffer.getSelectionEnd() + i13 >= buffer.getLength$ui_text()) {
                length$ui_text = buffer.getLength$ui_text() - buffer.getSelectionEnd();
                break;
            } else {
                length$ui_text = EditCommandKt.isSurrogatePair(buffer.get$ui_text((buffer.getSelectionEnd() + i13) + (-1)), buffer.get$ui_text(buffer.getSelectionEnd() + i13)) ? length$ui_text + 2 : i13;
                i6++;
            }
        }
        buffer.delete$ui_text(buffer.getSelectionEnd(), buffer.getSelectionEnd() + length$ui_text);
        buffer.delete$ui_text(buffer.getSelectionStart() - selectionStart, buffer.getSelectionStart());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeleteSurroundingTextInCodePointsCommand)) {
            return false;
        }
        DeleteSurroundingTextInCodePointsCommand deleteSurroundingTextInCodePointsCommand = (DeleteSurroundingTextInCodePointsCommand) other;
        return this.lengthBeforeCursor == deleteSurroundingTextInCodePointsCommand.lengthBeforeCursor && this.lengthAfterCursor == deleteSurroundingTextInCodePointsCommand.lengthAfterCursor;
    }

    public final int getLengthAfterCursor() {
        return this.lengthAfterCursor;
    }

    public final int getLengthBeforeCursor() {
        return this.lengthBeforeCursor;
    }

    public int hashCode() {
        return (this.lengthBeforeCursor * 31) + this.lengthAfterCursor;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DeleteSurroundingTextInCodePointsCommand(lengthBeforeCursor=");
        sb.append(this.lengthBeforeCursor);
        sb.append(", lengthAfterCursor=");
        return B7.a.o(sb, this.lengthAfterCursor, ')');
    }
}
