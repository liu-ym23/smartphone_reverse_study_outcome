package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.StringHelpers_androidKt;
import g1.AbstractC1451a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a#\u0010\n\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a#\u0010\f\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\f\u0010\u0007\u001a#\u0010\u000f\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u000f\u0010\u000b\u001a#\u0010\u0010\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0010\u0010\u000b\u001a\u0013\u0010\u0011\u001a\u00020\u0005*\u00020\u0000H\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0013\u0010\u0013\u001a\u00020\u0005*\u00020\u0000H\u0000¢\u0006\u0004\b\u0013\u0010\u0012\u001a\u001b\u0010\u0015\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0013\u0010\u0017\u001a\u00020\u0005*\u00020\u0000H\u0000¢\u0006\u0004\b\u0017\u0010\u0012\u001a\u001f\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/text/input/internal/EditingBuffer;", "", "text", "", "newCursorPosition", "LC7/r;", "commitText", "(Landroidx/compose/foundation/text/input/internal/EditingBuffer;Ljava/lang/String;I)V", "start", "end", "setComposingRegion", "(Landroidx/compose/foundation/text/input/internal/EditingBuffer;II)V", "setComposingText", "lengthBeforeCursor", "lengthAfterCursor", "deleteSurroundingText", "deleteSurroundingTextInCodePoints", "finishComposingText", "(Landroidx/compose/foundation/text/input/internal/EditingBuffer;)V", "backspace", "amount", "moveCursor", "(Landroidx/compose/foundation/text/input/internal/EditingBuffer;I)V", "deleteAll", "", "high", "low", "", "isSurrogatePair", "(CC)Z", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EditCommandKt {
    public static final void backspace(EditingBuffer editingBuffer) {
        if (editingBuffer.hasComposition()) {
            editingBuffer.delete(editingBuffer.getCompositionStart(), editingBuffer.getCompositionEnd());
            return;
        }
        if (editingBuffer.getCursor() != -1) {
            if (editingBuffer.getCursor() != 0) {
                editingBuffer.delete(StringHelpers_androidKt.findPrecedingBreak(editingBuffer.toString(), editingBuffer.getCursor()), editingBuffer.getCursor());
            }
        } else {
            int selectionStart = editingBuffer.getSelectionStart();
            int selectionEnd = editingBuffer.getSelectionEnd();
            editingBuffer.setCursor(editingBuffer.getSelectionStart());
            editingBuffer.delete(selectionStart, selectionEnd);
        }
    }

    public static final void commitText(EditingBuffer editingBuffer, String str, int i) {
        if (editingBuffer.hasComposition()) {
            editingBuffer.replace(editingBuffer.getCompositionStart(), editingBuffer.getCompositionEnd(), str);
        } else {
            editingBuffer.replace(editingBuffer.getSelectionStart(), editingBuffer.getSelectionEnd(), str);
        }
        editingBuffer.setCursor(AbstractC1451a.u(i > 0 ? (r0 + i) - 1 : (editingBuffer.getCursor() + i) - str.length(), 0, editingBuffer.getLength()));
    }

    public static final void deleteAll(EditingBuffer editingBuffer) {
        editingBuffer.replace(0, editingBuffer.getLength(), "");
    }

    public static final void deleteSurroundingText(EditingBuffer editingBuffer, int i, int i6) {
        if (i < 0 || i6 < 0) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.o(i, "Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were ", i6, " and ", " respectively.").toString());
        }
        int selectionEnd = editingBuffer.getSelectionEnd();
        int length = selectionEnd + i6;
        if (((i6 ^ length) & (selectionEnd ^ length)) < 0) {
            length = editingBuffer.getLength();
        }
        editingBuffer.delete(editingBuffer.getSelectionEnd(), Math.min(length, editingBuffer.getLength()));
        int selectionStart = editingBuffer.getSelectionStart();
        int i10 = selectionStart - i;
        if (((i ^ selectionStart) & (selectionStart ^ i10)) < 0) {
            i10 = 0;
        }
        editingBuffer.delete(Math.max(0, i10), editingBuffer.getSelectionStart());
    }

    public static final void deleteSurroundingTextInCodePoints(EditingBuffer editingBuffer, int i, int i6) {
        if (i < 0 || i6 < 0) {
            throw new IllegalArgumentException(androidx.compose.foundation.b.o(i, "Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were ", i6, " and ", " respectively.").toString());
        }
        int i10 = 0;
        int i11 = 0;
        int selectionStart = 0;
        while (true) {
            if (i11 < i) {
                int i12 = selectionStart + 1;
                if (editingBuffer.getSelectionStart() <= i12) {
                    selectionStart = editingBuffer.getSelectionStart();
                    break;
                } else {
                    selectionStart = isSurrogatePair(editingBuffer.get((editingBuffer.getSelectionStart() - i12) + (-1)), editingBuffer.get(editingBuffer.getSelectionStart() - i12)) ? selectionStart + 2 : i12;
                    i11++;
                }
            } else {
                break;
            }
        }
        int length = 0;
        while (true) {
            if (i10 >= i6) {
                break;
            }
            int i13 = length + 1;
            if (editingBuffer.getSelectionEnd() + i13 >= editingBuffer.getLength()) {
                length = editingBuffer.getLength() - editingBuffer.getSelectionEnd();
                break;
            } else {
                length = isSurrogatePair(editingBuffer.get((editingBuffer.getSelectionEnd() + i13) + (-1)), editingBuffer.get(editingBuffer.getSelectionEnd() + i13)) ? length + 2 : i13;
                i10++;
            }
        }
        editingBuffer.delete(editingBuffer.getSelectionEnd(), editingBuffer.getSelectionEnd() + length);
        editingBuffer.delete(editingBuffer.getSelectionStart() - selectionStart, editingBuffer.getSelectionStart());
    }

    public static final void finishComposingText(EditingBuffer editingBuffer) {
        editingBuffer.commitComposition();
    }

    private static final boolean isSurrogatePair(char c, char c2) {
        return Character.isHighSurrogate(c) && Character.isLowSurrogate(c2);
    }

    public static final void moveCursor(EditingBuffer editingBuffer, int i) {
        if (editingBuffer.getCursor() == -1) {
            editingBuffer.setCursor(editingBuffer.getSelectionStart());
        }
        int selectionStart = editingBuffer.getSelectionStart();
        String string = editingBuffer.toString();
        int i6 = 0;
        if (i <= 0) {
            int i10 = -i;
            while (i6 < i10) {
                int iFindPrecedingBreak = StringHelpers_androidKt.findPrecedingBreak(string, selectionStart);
                if (iFindPrecedingBreak == -1) {
                    break;
                }
                i6++;
                selectionStart = iFindPrecedingBreak;
            }
        } else {
            while (i6 < i) {
                int iFindFollowingBreak = StringHelpers_androidKt.findFollowingBreak(string, selectionStart);
                if (iFindFollowingBreak == -1) {
                    break;
                }
                i6++;
                selectionStart = iFindFollowingBreak;
            }
        }
        editingBuffer.setCursor(selectionStart);
    }

    public static final void setComposingRegion(EditingBuffer editingBuffer, int i, int i6) {
        if (editingBuffer.hasComposition()) {
            editingBuffer.commitComposition();
        }
        int iU = AbstractC1451a.u(i, 0, editingBuffer.getLength());
        int iU2 = AbstractC1451a.u(i6, 0, editingBuffer.getLength());
        if (iU != iU2) {
            if (iU < iU2) {
                editingBuffer.setComposition(iU, iU2);
            } else {
                editingBuffer.setComposition(iU2, iU);
            }
        }
    }

    public static final void setComposingText(EditingBuffer editingBuffer, String str, int i) {
        if (editingBuffer.hasComposition()) {
            int compositionStart = editingBuffer.getCompositionStart();
            editingBuffer.replace(compositionStart, editingBuffer.getCompositionEnd(), str);
            if (str.length() > 0) {
                editingBuffer.setComposition(compositionStart, str.length() + compositionStart);
            }
        } else {
            int selectionStart = editingBuffer.getSelectionStart();
            editingBuffer.replace(selectionStart, editingBuffer.getSelectionEnd(), str);
            if (str.length() > 0) {
                editingBuffer.setComposition(selectionStart, str.length() + selectionStart);
            }
        }
        editingBuffer.setCursor(AbstractC1451a.u(i > 0 ? (r0 + i) - 1 : (editingBuffer.getCursor() + i) - str.length(), 0, editingBuffer.getLength()));
    }
}
