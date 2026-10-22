package androidx.compose.ui.text.input;

import D7.v;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u000b\u001a\u00020\b*\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\r2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\r¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0017R$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u001b8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Landroidx/compose/ui/text/input/EditProcessor;", "", AppAgent.CONSTRUCT, "()V", "", "Landroidx/compose/ui/text/input/EditCommand;", "editCommands", "failedCommand", "", "generateBatchErrorMessage", "(Ljava/util/List;Landroidx/compose/ui/text/input/EditCommand;)Ljava/lang/String;", "toStringForLog", "(Landroidx/compose/ui/text/input/EditCommand;)Ljava/lang/String;", "Landroidx/compose/ui/text/input/TextFieldValue;", "value", "Landroidx/compose/ui/text/input/TextInputSession;", "textInputSession", "LC7/r;", "reset", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/TextInputSession;)V", "apply", "(Ljava/util/List;)Landroidx/compose/ui/text/input/TextFieldValue;", "toTextFieldValue", "()Landroidx/compose/ui/text/input/TextFieldValue;", "mBufferState", "Landroidx/compose/ui/text/input/TextFieldValue;", "getMBufferState$ui_text", "Landroidx/compose/ui/text/input/EditingBuffer;", "mBuffer", "Landroidx/compose/ui/text/input/EditingBuffer;", "getMBuffer$ui_text", "()Landroidx/compose/ui/text/input/EditingBuffer;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EditProcessor {
    public static final int $stable = 8;
    private TextFieldValue mBufferState = new TextFieldValue(AnnotatedStringKt.emptyAnnotatedString(), TextRange.INSTANCE.m6316getZerod9O1mEE(), (TextRange) null, (e) null);
    private EditingBuffer mBuffer = new EditingBuffer(this.mBufferState.getAnnotatedString(), this.mBufferState.getSelection(), (e) (0 == true ? 1 : 0));

    private final String generateBatchErrorMessage(List<? extends EditCommand> editCommands, EditCommand failedCommand) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("Error while applying EditCommand batch to buffer (length=" + this.mBuffer.getLength$ui_text() + ", composition=" + this.mBuffer.m6471getCompositionMzsxiRA$ui_text() + ", selection=" + ((Object) TextRange.m6314toStringimpl(this.mBuffer.m6472getSelectiond9O1mEE$ui_text())) + "):");
        sb.append('\n');
        v.H0(editCommands, sb, "\n", null, null, new R3.b(17, failedCommand, this), 60);
        String string = sb.toString();
        k.e(string, "toString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence generateBatchErrorMessage$lambda$4$lambda$3(EditCommand editCommand, EditProcessor editProcessor, EditCommand editCommand2) {
        StringBuilder sbV = androidx.compose.foundation.b.v(editCommand == editCommand2 ? " > " : "   ");
        sbV.append(editProcessor.toStringForLog(editCommand2));
        return sbV.toString();
    }

    private final String toStringForLog(EditCommand editCommand) {
        if (editCommand instanceof CommitTextCommand) {
            StringBuilder sb = new StringBuilder("CommitTextCommand(text.length=");
            CommitTextCommand commitTextCommand = (CommitTextCommand) editCommand;
            sb.append(commitTextCommand.getText().length());
            sb.append(", newCursorPosition=");
            sb.append(commitTextCommand.getNewCursorPosition());
            sb.append(')');
            return sb.toString();
        }
        if (editCommand instanceof SetComposingTextCommand) {
            StringBuilder sb2 = new StringBuilder("SetComposingTextCommand(text.length=");
            SetComposingTextCommand setComposingTextCommand = (SetComposingTextCommand) editCommand;
            sb2.append(setComposingTextCommand.getText().length());
            sb2.append(", newCursorPosition=");
            sb2.append(setComposingTextCommand.getNewCursorPosition());
            sb2.append(')');
            return sb2.toString();
        }
        if (editCommand instanceof SetComposingRegionCommand) {
            return ((SetComposingRegionCommand) editCommand).toString();
        }
        if (editCommand instanceof DeleteSurroundingTextCommand) {
            return ((DeleteSurroundingTextCommand) editCommand).toString();
        }
        if (editCommand instanceof DeleteSurroundingTextInCodePointsCommand) {
            return ((DeleteSurroundingTextInCodePointsCommand) editCommand).toString();
        }
        if (editCommand instanceof SetSelectionCommand) {
            return ((SetSelectionCommand) editCommand).toString();
        }
        if (editCommand instanceof FinishComposingTextCommand) {
            return ((FinishComposingTextCommand) editCommand).toString();
        }
        if (editCommand instanceof BackspaceCommand) {
            return ((BackspaceCommand) editCommand).toString();
        }
        if (editCommand instanceof MoveCursorCommand) {
            return ((MoveCursorCommand) editCommand).toString();
        }
        if (editCommand instanceof DeleteAllCommand) {
            return ((DeleteAllCommand) editCommand).toString();
        }
        String strM = m.f4928a.b(editCommand.getClass()).m();
        if (strM == null) {
            strM = "{anonymous EditCommand}";
        }
        return "Unknown EditCommand: ".concat(strM);
    }

    public final TextFieldValue apply(List<? extends EditCommand> editCommands) {
        EditCommand editCommand;
        EditCommand editCommand2 = null;
        try {
            int size = editCommands.size();
            int i = 0;
            EditCommand editCommand3 = null;
            while (i < size) {
                try {
                    editCommand = editCommands.get(i);
                } catch (Exception e) {
                    e = e;
                    editCommand2 = editCommand3;
                }
                try {
                    editCommand.applyTo(this.mBuffer);
                    i++;
                    editCommand3 = editCommand;
                } catch (Exception e6) {
                    e = e6;
                    editCommand2 = editCommand;
                    throw new RuntimeException(generateBatchErrorMessage(editCommands, editCommand2), e);
                }
            }
            AnnotatedString annotatedString$ui_text = this.mBuffer.toAnnotatedString$ui_text();
            long jM6472getSelectiond9O1mEE$ui_text = this.mBuffer.m6472getSelectiond9O1mEE$ui_text();
            TextRange textRangeM6299boximpl = TextRange.m6299boximpl(jM6472getSelectiond9O1mEE$ui_text);
            textRangeM6299boximpl.getPackedValue();
            TextRange textRange = TextRange.m6310getReversedimpl(this.mBufferState.getSelection()) ? null : textRangeM6299boximpl;
            TextFieldValue textFieldValue = new TextFieldValue(annotatedString$ui_text, textRange != null ? textRange.getPackedValue() : TextRangeKt.TextRange(TextRange.m6308getMaximpl(jM6472getSelectiond9O1mEE$ui_text), TextRange.m6309getMinimpl(jM6472getSelectiond9O1mEE$ui_text)), this.mBuffer.m6471getCompositionMzsxiRA$ui_text(), (e) null);
            this.mBufferState = textFieldValue;
            return textFieldValue;
        } catch (Exception e9) {
            e = e9;
        }
    }

    /* renamed from: getMBuffer$ui_text, reason: from getter */
    public final EditingBuffer getMBuffer() {
        return this.mBuffer;
    }

    /* renamed from: getMBufferState$ui_text, reason: from getter */
    public final TextFieldValue getMBufferState() {
        return this.mBufferState;
    }

    public final void reset(TextFieldValue value, TextInputSession textInputSession) {
        boolean zB = k.b(value.getComposition(), this.mBuffer.m6471getCompositionMzsxiRA$ui_text());
        boolean z10 = true;
        boolean z11 = false;
        if (!k.b(this.mBufferState.getAnnotatedString().getText(), value.getAnnotatedString().getText())) {
            this.mBuffer = new EditingBuffer(value.getAnnotatedString(), value.getSelection(), (e) null);
        } else if (TextRange.m6304equalsimpl0(this.mBufferState.getSelection(), value.getSelection())) {
            z10 = false;
        } else {
            this.mBuffer.setSelection$ui_text(TextRange.m6309getMinimpl(value.getSelection()), TextRange.m6308getMaximpl(value.getSelection()));
            z11 = true;
            z10 = false;
        }
        if (value.getComposition() == null) {
            this.mBuffer.commitComposition$ui_text();
        } else if (!TextRange.m6305getCollapsedimpl(value.getComposition().getPackedValue())) {
            this.mBuffer.setComposition$ui_text(TextRange.m6309getMinimpl(value.getComposition().getPackedValue()), TextRange.m6308getMaximpl(value.getComposition().getPackedValue()));
        }
        if (z10 || (!z11 && !zB)) {
            this.mBuffer.commitComposition$ui_text();
            value = TextFieldValue.m6554copy3r_uNRQ$default(value, (AnnotatedString) null, 0L, (TextRange) null, 3, (Object) null);
        }
        TextFieldValue textFieldValue = this.mBufferState;
        this.mBufferState = value;
        if (textInputSession != null) {
            textInputSession.updateState(textFieldValue, value);
        }
    }

    public final TextFieldValue toTextFieldValue() {
        return this.mBufferState;
    }
}
