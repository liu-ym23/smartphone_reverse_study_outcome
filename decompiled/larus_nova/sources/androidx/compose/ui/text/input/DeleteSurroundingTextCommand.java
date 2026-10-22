package androidx.compose.ui.text.input;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/text/input/DeleteSurroundingTextCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "lengthBeforeCursor", "", "lengthAfterCursor", "<init>", "(II)V", "getLengthBeforeCursor", "()I", "getLengthAfterCursor", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DeleteSurroundingTextCommand implements EditCommand {
    public static final int $stable = 0;
    private final int lengthAfterCursor;
    private final int lengthBeforeCursor;

    public int hashCode() {
        return (this.lengthBeforeCursor * 31) + this.lengthAfterCursor;
    }

    public String toString() {
        return "DeleteSurroundingTextCommand(lengthBeforeCursor=" + this.lengthBeforeCursor + ", lengthAfterCursor=" + this.lengthAfterCursor + ')';
    }

    public final int getLengthAfterCursor() {
        return this.lengthAfterCursor;
    }

    public final int getLengthBeforeCursor() {
        return this.lengthBeforeCursor;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void applyTo(EditingBuffer r100) {
        int r101 = r100.getSelectionEnd$ui_text();
        int r102 = this.lengthAfterCursor;
        int r103 = r101 + r102;
        if (((r101 ^ r103) & (r102 ^ r103)) >= 0) goto L5;
        r103 = r100.getLength$ui_text();
    L5:
        r100.delete$ui_text(r100.getSelectionEnd$ui_text(), Math.min(r103, r100.getLength$ui_text()));
        int r104 = r100.getSelectionStart$ui_text();
        int r105 = this.lengthBeforeCursor;
        int r106 = r104 - r105;
        int r107 = r105 ^ r104;
        if (((r104 ^ r106) & r107) >= 0) goto L8;
        r106 = 0;
    L8:
        r100.delete$ui_text(Math.max(0, r106), r100.getSelectionStart$ui_text());
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DeleteSurroundingTextCommand) == true) goto L8;
        return false;
    L8:
        DeleteSurroundingTextCommand r101 = (DeleteSurroundingTextCommand) r100;
        if (this.lengthBeforeCursor == r101.lengthBeforeCursor) goto L12;
        return false;
    L12:
        if (this.lengthAfterCursor == r101.lengthAfterCursor) goto L14;
        return false;
    L14:
        return true;
    }

    public DeleteSurroundingTextCommand(int r100, int r101) {
        this.lengthBeforeCursor = r100;
        this.lengthAfterCursor = r101;
        if (r100 < 0) goto L6;
        if (r101 < 0) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == true) goto L10;
        InlineClassHelperKt.throwIllegalArgumentException("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + r100 + " and " + r101 + " respectively.");
        return;
    L10:
        return;
    L6:
        r102 = false;
        goto L7
    }
}
