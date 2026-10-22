package androidx.compose.ui.text.input;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/text/input/DeleteSurroundingTextInCodePointsCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "lengthBeforeCursor", "", "lengthAfterCursor", "<init>", "(II)V", "getLengthBeforeCursor", "()I", "getLengthAfterCursor", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DeleteSurroundingTextInCodePointsCommand implements EditCommand {
    public static final int $stable = 0;
    private final int lengthAfterCursor;
    private final int lengthBeforeCursor;

    public int hashCode() {
        return (this.lengthBeforeCursor * 31) + this.lengthAfterCursor;
    }

    public String toString() {
        return "DeleteSurroundingTextInCodePointsCommand(lengthBeforeCursor=" + this.lengthBeforeCursor + ", lengthAfterCursor=" + this.lengthAfterCursor + ')';
    }

    public final int getLengthAfterCursor() {
        return this.lengthAfterCursor;
    }

    public final int getLengthBeforeCursor() {
        return this.lengthBeforeCursor;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void applyTo(EditingBuffer r100) {
        int r101 = this.lengthBeforeCursor;
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r103 >= r101) goto L11;
        r104 = r104 + 1;
        if (r100.getSelectionStart$ui_text() <= r104) goto L10;
        if (EditCommandKt.access$isSurrogatePair(r100.get$ui_text((r100.getSelectionStart$ui_text() - r104) - 1), r100.get$ui_text(r100.getSelectionStart$ui_text() - r104)) == false) goto L9;
        r104 = r104 + 1;
    L9:
        r103 = r103 + 1;
        goto L3
    L10:
        r104 = r100.getSelectionStart$ui_text();
    L11:
        int r105 = this.lengthAfterCursor;
        int r106 = 0;
    L12:
        if (r102 >= r105) goto L20;
        r106 = r106 + 1;
        if ((r100.getSelectionEnd$ui_text() + r106) >= r100.getLength$ui_text()) goto L19;
        if (EditCommandKt.access$isSurrogatePair(r100.get$ui_text((r100.getSelectionEnd$ui_text() + r106) - 1), r100.get$ui_text(r100.getSelectionEnd$ui_text() + r106)) == false) goto L18;
        r106 = r106 + 1;
    L18:
        r102 = r102 + 1;
        goto L12
    L19:
        r106 = r100.getLength$ui_text() - r100.getSelectionEnd$ui_text();
    L20:
        r100.delete$ui_text(r100.getSelectionEnd$ui_text(), r100.getSelectionEnd$ui_text() + r106);
        r100.delete$ui_text(r100.getSelectionStart$ui_text() - r104, r100.getSelectionStart$ui_text());
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DeleteSurroundingTextInCodePointsCommand) == true) goto L8;
        return false;
    L8:
        DeleteSurroundingTextInCodePointsCommand r101 = (DeleteSurroundingTextInCodePointsCommand) r100;
        if (this.lengthBeforeCursor == r101.lengthBeforeCursor) goto L12;
        return false;
    L12:
        if (this.lengthAfterCursor == r101.lengthAfterCursor) goto L14;
        return false;
    L14:
        return true;
    }

    public DeleteSurroundingTextInCodePointsCommand(int r100, int r101) {
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
