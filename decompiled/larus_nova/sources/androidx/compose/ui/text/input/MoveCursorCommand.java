package androidx.compose.ui.text.input;

import androidx.compose.ui.text.JvmCharHelpers_androidKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/text/input/MoveCursorCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "amount", "", "<init>", "(I)V", "getAmount", "()I", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "toString", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MoveCursorCommand implements EditCommand {
    public static final int $stable = 0;
    private final int amount;

    public String toString() {
        return "MoveCursorCommand(amount=" + this.amount + ')';
    }

    public final int getAmount() {
        return this.amount;
    }

    public int hashCode() {
        return this.amount;
    }

    public MoveCursorCommand(int r100) {
        this.amount = r100;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void applyTo(EditingBuffer r100) {
        if (r100.getCursor$ui_text() != (-1)) goto L5;
        r100.setCursor$ui_text(r100.getSelectionStart$ui_text());
    L5:
        int r101 = r100.getSelectionStart$ui_text();
        String r102 = r100.toString();
        int r103 = this.amount;
        int r104 = 0;
        if (r103 <= 0) goto L11;
    L7:
        if (r104 >= r103) goto L16;
        int r105 = JvmCharHelpers_androidKt.findFollowingBreak(r102, r101);
        if (r105 == (-1)) goto L16;
        r104 = r104 + 1;
        r101 = r105;
    L16:
        r100.setCursor$ui_text(r101);
        return;
    L11:
        int r106 = -r103;
    L12:
        if (r104 >= r106) goto L16;
        int r107 = JvmCharHelpers_androidKt.findPrecedingBreak(r102, r101);
        if (r107 == (-1)) goto L16;
        r104 = r104 + 1;
        r101 = r107;
        goto L12
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MoveCursorCommand) == true) goto L9;
        return false;
    L9:
        if (this.amount == ((MoveCursorCommand) r100).amount) goto L11;
        return false;
    L11:
        return true;
    }
}
