package androidx.compose.ui.text.input;

import androidx.compose.ui.text.JvmCharHelpers_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/text/input/BackspaceCommand;", "Landroidx/compose/ui/text/input/EditCommand;", "<init>", "()V", "applyTo", "", "buffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BackspaceCommand implements EditCommand {
    public static final int $stable = 0;

    public BackspaceCommand() {
    }

    public String toString() {
        return "BackspaceCommand()";
    }

    public int hashCode() {
        return Reflection.getOrCreateKotlinClass(BackspaceCommand.class).hashCode();
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public void applyTo(EditingBuffer r100) {
        if (r100.hasComposition$ui_text() == false) goto L7;
        r100.delete$ui_text(r100.getCompositionStart$ui_text(), r100.getCompositionEnd$ui_text());
        return;
    L7:
        if (r100.getCursor$ui_text() != (-1)) goto L11;
        int r101 = r100.getSelectionStart$ui_text();
        int r102 = r100.getSelectionEnd$ui_text();
        r100.setCursor$ui_text(r100.getSelectionStart$ui_text());
        r100.delete$ui_text(r101, r102);
        return;
    L11:
        if (r100.getCursor$ui_text() != 0) goto L13;
        return;
    L13:
        r100.delete$ui_text(JvmCharHelpers_androidKt.findPrecedingBreak(r100.toString(), r100.getCursor$ui_text()), r100.getCursor$ui_text());
    }

    public boolean equals(Object r100) {
        return r100 instanceof BackspaceCommand;
    }
}
