package androidx.compose.foundation.text.input.internal;

import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.PreviewableHandwritingGesture;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextInCodePointsCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.SetComposingRegionCommand;
import androidx.compose.ui.text.input.SetComposingTextCommand;
import androidx.compose.ui.text.input.SetSelectionCommand;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValueKt;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010(\u001a\u00020\u00072\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0082\bJ\u0016\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/J\u0010\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020&H\u0002J\b\u00102\u001a\u00020\u0007H\u0016J\b\u00103\u001a\u00020\u0007H\u0002J\b\u00104\u001a\u00020\u0007H\u0016J\b\u00105\u001a\u00020\u0007H\u0002J\b\u00106\u001a\u00020+H\u0016J\u001a\u00107\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\u001bH\u0016J\u0018\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u001bH\u0016J\u001a\u0010>\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\u001bH\u0016J\u0018\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020\u001bH\u0016J\u0018\u0010B\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u001b2\u0006\u0010A\u001a\u00020\u001bH\u0016J\u0018\u0010C\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u001bH\u0016J\b\u0010D\u001a\u00020\u0007H\u0016J\u0010\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020GH\u0016J\u0018\u0010H\u001a\u0002092\u0006\u0010I\u001a\u00020\u001b2\u0006\u0010J\u001a\u00020\u001bH\u0016J\u0018\u0010K\u001a\u0002092\u0006\u0010I\u001a\u00020\u001b2\u0006\u0010J\u001a\u00020\u001bH\u0016J\u0012\u0010L\u001a\u0004\u0018\u0001092\u0006\u0010J\u001a\u00020\u001bH\u0016J\u0010\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u001bH\u0016J\u001a\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010J\u001a\u00020\u001bH\u0016J\u0010\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u001bH\u0016J\u0010\u0010U\u001a\u00020+2\u0006\u0010V\u001a\u00020\u001bH\u0002J\u0010\u0010W\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u001bH\u0016J$\u0010Y\u001a\u00020+2\u0006\u0010Z\u001a\u00020[2\b\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010^\u001a\u0004\u0018\u00010_H\u0016J\u001a\u0010`\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020a2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J\u0012\u0010d\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u00010eH\u0016J\u0012\u0010f\u001a\u00020\u00072\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\n\u0010i\u001a\u0004\u0018\u00010jH\u0016J\u0010\u0010k\u001a\u00020\u00072\u0006\u0010l\u001a\u00020\u001bH\u0016J\u0010\u0010m\u001a\u00020\u00072\u0006\u0010n\u001a\u00020\u0007H\u0016J\u0010\u0010o\u001a\u00020\u001b2\u0006\u0010p\u001a\u00020\u001bH\u0016J\u001c\u0010q\u001a\u00020\u00072\b\u0010r\u001a\u0004\u0018\u00010s2\b\u0010t\u001a\u0004\u0018\u00010uH\u0016J\"\u0010v\u001a\u00020\u00072\u0006\u0010w\u001a\u00020x2\u0006\u0010J\u001a\u00020\u001b2\b\u0010y\u001a\u0004\u0018\u00010uH\u0016J\u0010\u0010z\u001a\u00020+2\u0006\u0010{\u001a\u00020sH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006|"}, d2 = {"Landroidx/compose/foundation/text/input/internal/RecordingInputConnection;", "Landroid/view/inputmethod/InputConnection;", "initState", "Landroidx/compose/ui/text/input/TextFieldValue;", "eventCallback", "Landroidx/compose/foundation/text/input/internal/InputEventCallback2;", "autoCorrect", "", "legacyTextFieldState", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "textFieldSelectionManager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "<init>", "(Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/input/internal/InputEventCallback2;ZLandroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/ui/platform/ViewConfiguration;)V", "getEventCallback", "()Landroidx/compose/foundation/text/input/internal/InputEventCallback2;", "getAutoCorrect", "()Z", "getLegacyTextFieldState", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "getTextFieldSelectionManager", "()Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "batchDepth", "", "value", "textFieldValue", "getTextFieldValue$foundation_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setTextFieldValue$foundation_release", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "currentExtractedTextRequestToken", "extractedTextMonitorMode", "editCommands", "", "Landroidx/compose/ui/text/input/EditCommand;", "isActive", "ensureActive", "block", "Lkotlin/Function0;", "", "updateInputState", "state", "inputMethodManager", "Landroidx/compose/foundation/text/input/internal/InputMethodManager;", "addEditCommandWithBatch", "editCommand", "beginBatchEdit", "beginBatchEditInternal", "endBatchEdit", "endBatchEditInternal", "closeConnection", "commitText", "text", "", "newCursorPosition", "setComposingRegion", "start", "end", "setComposingText", "deleteSurroundingTextInCodePoints", "beforeLength", "afterLength", "deleteSurroundingText", "setSelection", "finishComposingText", "sendKeyEvent", "event", "Landroid/view/KeyEvent;", "getTextBeforeCursor", "maxChars", "flags", "getTextAfterCursor", "getSelectedText", "requestCursorUpdates", "cursorUpdateMode", "getExtractedText", "Landroid/view/inputmethod/ExtractedText;", "request", "Landroid/view/inputmethod/ExtractedTextRequest;", "performContextMenuAction", "id", "sendSynthesizedKeyEvent", "code", "performEditorAction", "editorAction", "performHandwritingGesture", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "executor", "Ljava/util/concurrent/Executor;", "consumer", "Ljava/util/function/IntConsumer;", "previewHandwritingGesture", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "commitCompletion", "Landroid/view/inputmethod/CompletionInfo;", "commitCorrection", "correctionInfo", "Landroid/view/inputmethod/CorrectionInfo;", "getHandler", "Landroid/os/Handler;", "clearMetaKeyStates", "states", "reportFullscreenMode", "enabled", "getCursorCapsMode", "reqModes", "performPrivateCommand", "action", "", "data", "Landroid/os/Bundle;", "commitContent", "inputContentInfo", "Landroid/view/inputmethod/InputContentInfo;", "opts", "logDebug", "message", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RecordingInputConnection implements InputConnection {
    public static final int $stable = 8;
    private final boolean autoCorrect;
    private int batchDepth;
    private int currentExtractedTextRequestToken;
    private final List<EditCommand> editCommands;
    private final InputEventCallback2 eventCallback;
    private boolean extractedTextMonitorMode;
    private boolean isActive;
    private final LegacyTextFieldState legacyTextFieldState;
    private final TextFieldSelectionManager textFieldSelectionManager;
    private TextFieldValue textFieldValue;
    private final ViewConfiguration viewConfiguration;

    public static /* synthetic */ Unit a(RecordingInputConnection r100, EditCommand r101) {
        return performHandwritingGesture$lambda$14(r100, r101);
    }

    private final void logDebug(String r100) {
    }

    @Override // android.view.inputmethod.InputConnection
    public Handler getHandler() {
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean r100) {
        return false;
    }

    private final boolean beginBatchEditInternal() {
        this.batchDepth++;
        return true;
    }

    private final boolean endBatchEditInternal() {
        int r100 = this.batchDepth - 1;
        this.batchDepth = r100;
        if (r100 != 0) goto L8;
        if ((!this.editCommands.isEmpty()) == false) goto L8;
        this.eventCallback.onEditCommands(CollectionsKt.toMutableList(this.editCommands));
        this.editCommands.clear();
    L8:
        if (this.batchDepth > 0) goto L12;
        return false;
    L12:
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        boolean r100 = this.isActive;
        if (r100 == true) goto L5;
        return r100;
    L5:
        return beginBatchEditInternal();
    }

    @Override // android.view.inputmethod.InputConnection
    public void closeConnection() {
        this.editCommands.clear();
        this.batchDepth = 0;
        this.isActive = false;
        this.eventCallback.onConnectionClosed(this);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        boolean r100 = this.isActive;
        if (r100 == false) goto L6;
        addEditCommandWithBatch(new FinishComposingTextCommand());
        return true;
    L6:
        return r100;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        return endBatchEditInternal();
    }

    public final boolean getAutoCorrect() {
        return this.autoCorrect;
    }

    public final InputEventCallback2 getEventCallback() {
        return this.eventCallback;
    }

    public final LegacyTextFieldState getLegacyTextFieldState() {
        return this.legacyTextFieldState;
    }

    public final TextFieldSelectionManager getTextFieldSelectionManager() {
        return this.textFieldSelectionManager;
    }

    public final TextFieldValue getTextFieldValue$foundation_release() {
        return this.textFieldValue;
    }

    public final ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    private final void addEditCommandWithBatch(EditCommand r100) {
        beginBatchEditInternal();
        this.editCommands.add(r100);     // Catch: Throwable -> L6
        endBatchEditInternal();
        return;
    L6:
        th = move-exception;
        endBatchEditInternal();
        throw th;
    }

    private final boolean ensureActive(Function0<Unit> r100) {
        boolean r101 = this.isActive;
        if (r101 == false) goto L5;
        r100.invoke();
    L5:
        return r101;
    }

    private final void sendSynthesizedKeyEvent(int r100) {
        sendKeyEvent(new KeyEvent(0, r100));
        sendKeyEvent(new KeyEvent(1, r100));
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int r100) {
        boolean r101 = this.isActive;
        if (r101 == false) goto L6;
        return false;
    L6:
        return r101;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(CompletionInfo r100) {
        boolean r101 = this.isActive;
        if (r101 == false) goto L6;
        return false;
    L6:
        return r101;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(CorrectionInfo r100) {
        boolean r101 = this.isActive;
        if (r101 == true) goto L5;
        return r101;
    L5:
        return this.autoCorrect;
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int r100) {
        return TextUtils.getCapsMode(this.textFieldValue.getText(), TextRange.m6996getMinimpl(this.textFieldValue.m7249getSelectiond9O1mEE()), r100);
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getSelectedText(int r100) {
        if (TextRange.m6992getCollapsedimpl(this.textFieldValue.m7249getSelectiond9O1mEE()) == false) goto L6;
        return null;
    L6:
        return TextFieldValueKt.getSelectedText(this.textFieldValue).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int r100) {
        boolean r101 = this.isActive;
        if (r101 == false) goto L11;
        r101 = false;
        switch(r100) {
            case 16908319: goto L10;
            case 16908320: goto L9;
            case 16908321: goto L8;
            case 16908322: goto L7;
            default: goto L11;
        };
    L7:
        sendSynthesizedKeyEvent(MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS);
        goto L11
    L8:
        sendSynthesizedKeyEvent(MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC);
        goto L11
    L9:
        sendSynthesizedKeyEvent(MediaPlayer.MEDIA_PLAYER_OPTION_READ_MODE);
        goto L11
    L10:
        addEditCommandWithBatch(new SetSelectionCommand(0, this.textFieldValue.getText().length()));
    L11:
        return r101;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int r100) {
        boolean r101 = this.isActive;
        if (r101 == false) goto L16;
        if (r100 == 0) goto L13;
        switch(r100) {
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L6:
        int r102 = ImeAction.Companion.m7180getDefaulteUduSuo();
    L14:
        this.eventCallback.mo1264onImeActionKlQnJC8(r102);
        return true;
    L7:
        r102 = ImeAction.Companion.m7185getPreviouseUduSuo();
        goto L14
    L8:
        r102 = ImeAction.Companion.m7181getDoneeUduSuo();
        goto L14
    L9:
        r102 = ImeAction.Companion.m7183getNexteUduSuo();
        goto L14
    L10:
        r102 = ImeAction.Companion.m7187getSendeUduSuo();
        goto L14
    L11:
        r102 = ImeAction.Companion.m7186getSearcheUduSuo();
        goto L14
    L12:
        r102 = ImeAction.Companion.m7182getGoeUduSuo();
        goto L14
    L13:
        r102 = ImeAction.Companion.m7180getDefaulteUduSuo();
        goto L14
    L16:
        return r101;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int r110) {
        boolean r100 = this.isActive;
        if (r100 == false) goto L42;
        boolean r101 = false;
        if ((r110 & 1) == 0) goto L7;
        boolean r102 = true;
    L9:
        if ((r110 & 2) == 0) goto L11;
        boolean r103 = true;
    L12:
        int r104 = Build.VERSION.SDK_INT;
        if (r104 >= 33) goto L15;
        boolean r105 = true;
        boolean r106 = true;
        boolean r107 = false;
        boolean r108 = false;
    L40:
        this.eventCallback.onRequestCursorAnchorInfo(r102, r103, r105, r106, r107, r108);
        return true;
    L15:
        if ((r110 & 16) == 0) goto L17;
        boolean r109 = true;
    L19:
        if ((r110 & 8) == 0) goto L21;
        boolean r111 = true;
    L23:
        if ((r110 & 4) == 0) goto L25;
        boolean r112 = true;
    L27:
        if (r104 >= 34) goto L29;
    L31:
        if (r109 == true) goto L38;
        if (r111 == true) goto L38;
        if (r112 == true) goto L38;
        if (r101 == true) goto L38;
        if (r104 < 34) goto L37;
        r105 = true;
        r106 = true;
        r107 = true;
        r108 = true;
        goto L40
    L37:
        r108 = r101;
        r105 = true;
        r106 = true;
        r107 = true;
    L38:
        r108 = r101;
        r107 = r112;
        r106 = r111;
        r105 = r109;
        goto L40
    L29:
        if ((r110 & 32) == 0) goto L31;
        r101 = true;
        goto L31
    L25:
        r112 = false;
        goto L27
    L21:
        r111 = false;
        goto L23
    L17:
        r109 = false;
        goto L19
    L11:
        r103 = false;
        goto L12
    L7:
        r102 = false;
        goto L9
    L42:
        return r100;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent r100) {
        boolean r101 = this.isActive;
        if (r101 == false) goto L6;
        this.eventCallback.onKeyEvent(r100);
        return true;
    L6:
        return r101;
    }

    public final void setTextFieldValue$foundation_release(TextFieldValue r100) {
        this.textFieldValue = r100;
    }

    private static final Unit performHandwritingGesture$lambda$14(RecordingInputConnection r100, EditCommand r101) {
        r100.addEditCommandWithBatch(r101);
        return Unit.INSTANCE;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence r100, int r101) {
        boolean r102 = this.isActive;
        if (r102 == false) goto L5;
        addEditCommandWithBatch(new CommitTextCommand(String.valueOf(r100), r101));
    L5:
        return r102;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int r100, int r101) {
        boolean r102 = this.isActive;
        if (r102 == false) goto L6;
        addEditCommandWithBatch(new DeleteSurroundingTextCommand(r100, r101));
        return true;
    L6:
        return r102;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int r100, int r101) {
        boolean r102 = this.isActive;
        if (r102 == false) goto L6;
        addEditCommandWithBatch(new DeleteSurroundingTextInCodePointsCommand(r100, r101));
        return true;
    L6:
        return r102;
    }

    @Override // android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest r100, int r101) {
        boolean r102 = true;
        int r103 = 0;
        if ((r101 & 1) != 0) goto L6;
        r102 = false;
    L6:
        this.extractedTextMonitorMode = r102;
        if (r102 == false) goto L12;
        if (r100 == null) goto L10;
        r103 = r100.token;
    L10:
        this.currentExtractedTextRequestToken = r103;
    L12:
        return RecordingInputConnection_androidKt.access$toExtractedText(this.textFieldValue);
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextAfterCursor(int r100, int r101) {
        return TextFieldValueKt.getTextAfterSelection(this.textFieldValue, r100).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextBeforeCursor(int r100, int r101) {
        return TextFieldValueKt.getTextBeforeSelection(this.textFieldValue, r100).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String r100, Bundle r101) {
        boolean r102 = this.isActive;
        if (r102 == false) goto L6;
        return true;
    L6:
        return r102;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean previewHandwritingGesture(PreviewableHandwritingGesture r100, CancellationSignal r101) {
        if (Build.VERSION.SDK_INT >= 34) goto L5;
        return false;
    L5:
        return Api34LegacyPerformHandwritingGestureImpl.INSTANCE.previewHandwritingGesture(this.legacyTextFieldState, this.textFieldSelectionManager, r100, r101);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int r100, int r101) {
        boolean r102 = this.isActive;
        if (r102 == false) goto L5;
        addEditCommandWithBatch(new SetComposingRegionCommand(r100, r101));
    L5:
        return r102;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence r100, int r101) {
        boolean r102 = this.isActive;
        if (r102 == false) goto L5;
        addEditCommandWithBatch(new SetComposingTextCommand(String.valueOf(r100), r101));
    L5:
        return r102;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int r100, int r101) {
        boolean r102 = this.isActive;
        if (r102 == false) goto L6;
        addEditCommandWithBatch(new SetSelectionCommand(r100, r101));
        return true;
    L6:
        return r102;
    }

    public final void updateInputState(TextFieldValue r100, InputMethodManager r101) {
        if (this.isActive == true) goto L5;
        return;
    L5:
        setTextFieldValue$foundation_release(r100);
        if (this.extractedTextMonitorMode == false) goto L8;
        r101.updateExtractedText(this.currentExtractedTextRequestToken, RecordingInputConnection_androidKt.access$toExtractedText(r100));
    L8:
        TextRange r102 = r100.m7248getCompositionMzsxiRA();
        int r103 = -1;
        if (r102 == null) goto L11;
        int r104 = TextRange.m6996getMinimpl(r102.m7002unboximpl());
    L12:
        TextRange r105 = r100.m7248getCompositionMzsxiRA();
        if (r105 == null) goto L15;
        r103 = TextRange.m6995getMaximpl(r105.m7002unboximpl());
    L15:
        r101.updateSelection(TextRange.m6996getMinimpl(r100.m7249getSelectiond9O1mEE()), TextRange.m6995getMaximpl(r100.m7249getSelectiond9O1mEE()), r104, r103);
        return;
    L11:
        r104 = -1;
        goto L12
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo r100, int r101, Bundle r102) {
        boolean r103 = this.isActive;
        if (r103 == false) goto L6;
        return false;
    L6:
        return r103;
    }

    @Override // android.view.inputmethod.InputConnection
    public void performHandwritingGesture(HandwritingGesture r110, Executor r111, IntConsumer r112) {
        if (Build.VERSION.SDK_INT < 34) goto L6;
        Api34LegacyPerformHandwritingGestureImpl.INSTANCE.performHandwritingGesture(this.legacyTextFieldState, this.textFieldSelectionManager, r110, this.viewConfiguration, r111, r112, new m0(this));
        return;
    }

    public RecordingInputConnection(TextFieldValue r100, InputEventCallback2 r101, boolean r102, LegacyTextFieldState r103, TextFieldSelectionManager r104, ViewConfiguration r105) {
        this.eventCallback = r101;
        this.autoCorrect = r102;
        this.legacyTextFieldState = r103;
        this.textFieldSelectionManager = r104;
        this.viewConfiguration = r105;
        this.textFieldValue = r100;
        this.editCommands = new ArrayList();
        this.isActive = true;
    }

    public /* synthetic */ RecordingInputConnection(TextFieldValue r110, InputEventCallback2 r111, boolean r112, LegacyTextFieldState r113, TextFieldSelectionManager r114, ViewConfiguration r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 8) == 0) goto L5;
        LegacyTextFieldState r100 = null;
    L7:
        if ((r116 & 16) == 0) goto L9;
        TextFieldSelectionManager r101 = null;
    L11:
        if ((r116 & 32) == 0) goto L13;
        ViewConfiguration r102 = null;
    L14:
        this(r110, r111, r112, r100, r101, r102);
        return;
    L13:
        r102 = r115;
        goto L14
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
