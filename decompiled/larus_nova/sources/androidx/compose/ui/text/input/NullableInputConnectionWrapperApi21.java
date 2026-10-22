package androidx.compose.ui.text.input;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0012\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0006J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u001a\u0010\u001c\u001a\u00020\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0016J\u001a\u0010\u001f\u001a\u00020\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010 \u001a\u00020\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010\"\u001a\u00020\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010#H\u0016J\u0018\u0010$\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010'\u001a\u00020\u001aH\u0016J\b\u0010(\u001a\u00020\u001aH\u0016J\u0012\u0010)\u001a\u00020\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u001aH\u0016J\u001c\u0010-\u001a\u00020\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010.2\b\u0010\u0012\u001a\u0004\u0018\u00010/H\u0016J\u0010\u00100\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\n\u00101\u001a\u0004\u0018\u000102H\u0016J\"\u00103\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u0002042\u0006\u0010\u0012\u001a\u00020\u00112\b\u00105\u001a\u0004\u0018\u00010/H\u0016J\u0010\u00106\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H\u0014R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u00067"}, d2 = {"Landroidx/compose/ui/text/input/NullableInputConnectionWrapperApi21;", "Landroidx/compose/ui/text/input/NullableInputConnectionWrapper;", "delegate", "Landroid/view/inputmethod/InputConnection;", "onConnectionClosed", "Lkotlin/Function1;", "", "<init>", "(Landroid/view/inputmethod/InputConnection;Lkotlin/jvm/functions/Function1;)V", "value", "getDelegate", "()Landroid/view/inputmethod/InputConnection;", "disposeDelegate", "closeConnection", "getTextBeforeCursor", "", "p0", "", "p1", "getTextAfterCursor", "getSelectedText", "getCursorCapsMode", "getExtractedText", "Landroid/view/inputmethod/ExtractedText;", "Landroid/view/inputmethod/ExtractedTextRequest;", "deleteSurroundingText", "", "deleteSurroundingTextInCodePoints", "setComposingText", "setComposingRegion", "finishComposingText", "commitText", "commitCompletion", "Landroid/view/inputmethod/CompletionInfo;", "commitCorrection", "Landroid/view/inputmethod/CorrectionInfo;", "setSelection", "performEditorAction", "performContextMenuAction", "beginBatchEdit", "endBatchEdit", "sendKeyEvent", "Landroid/view/KeyEvent;", "clearMetaKeyStates", "reportFullscreenMode", "performPrivateCommand", "", "Landroid/os/Bundle;", "requestCursorUpdates", "getHandler", "Landroid/os/Handler;", "commitContent", "Landroid/view/inputmethod/InputContentInfo;", "p2", "closeDelegate", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
class NullableInputConnectionWrapperApi21 implements NullableInputConnectionWrapper {
    private InputConnection delegate;
    private final Function1<NullableInputConnectionWrapper, Unit> onConnectionClosed;

    public void closeDelegate(InputConnection r100) {
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo r100, int r101, Bundle r102) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int r100, int r101) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public Handler getHandler() {
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        InputConnection r100 = this.delegate;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.beginBatchEdit();
    }

    @Override // android.view.inputmethod.InputConnection
    public final void closeConnection() {
        if (this.delegate == null) goto L6;
        disposeDelegate();
        this.onConnectionClosed.invoke(this);
        return;
    }

    @Override // androidx.compose.ui.text.input.NullableInputConnectionWrapper
    public final void disposeDelegate() {
        InputConnection r100 = this.delegate;
        if (r100 == null) goto L6;
        closeDelegate(r100);
        this.delegate = null;
        return;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        InputConnection r100 = this.delegate;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.endBatchEdit();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        InputConnection r100 = this.delegate;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.finishComposingText();
    }

    public final InputConnection getDelegate() {
        return this.delegate;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int r100) {
        InputConnection r101 = this.delegate;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.clearMetaKeyStates(r100);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(CompletionInfo r100) {
        InputConnection r101 = this.delegate;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.commitCompletion(r100);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(CorrectionInfo r100) {
        InputConnection r101 = this.delegate;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.commitCorrection(r100);
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int r100) {
        InputConnection r101 = this.delegate;
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getCursorCapsMode(r100);
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getSelectedText(int r100) {
        InputConnection r101 = this.delegate;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getSelectedText(r100);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int r100) {
        InputConnection r101 = this.delegate;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.performContextMenuAction(r100);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int r100) {
        InputConnection r101 = this.delegate;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.performEditorAction(r100);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean r100) {
        InputConnection r101 = this.delegate;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.reportFullscreenMode(r100);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int r100) {
        InputConnection r101 = this.delegate;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.requestCursorUpdates(r100);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent r100) {
        InputConnection r101 = this.delegate;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.sendKeyEvent(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NullableInputConnectionWrapperApi21(InputConnection r100, Function1<? super NullableInputConnectionWrapper, Unit> r101) {
        this.onConnectionClosed = r101;
        this.delegate = r100;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence r100, int r101) {
        InputConnection r102 = this.delegate;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.commitText(r100, r101);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int r100, int r101) {
        InputConnection r102 = this.delegate;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.deleteSurroundingText(r100, r101);
    }

    @Override // android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest r100, int r101) {
        InputConnection r102 = this.delegate;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.getExtractedText(r100, r101);
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextAfterCursor(int r100, int r101) {
        InputConnection r102 = this.delegate;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.getTextAfterCursor(r100, r101);
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextBeforeCursor(int r100, int r101) {
        InputConnection r102 = this.delegate;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.getTextBeforeCursor(r100, r101);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String r100, Bundle r101) {
        InputConnection r102 = this.delegate;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.performPrivateCommand(r100, r101);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int r100, int r101) {
        InputConnection r102 = this.delegate;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.setComposingRegion(r100, r101);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence r100, int r101) {
        InputConnection r102 = this.delegate;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.setComposingText(r100, r101);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int r100, int r101) {
        InputConnection r102 = this.delegate;
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.setSelection(r100, r101);
    }
}
