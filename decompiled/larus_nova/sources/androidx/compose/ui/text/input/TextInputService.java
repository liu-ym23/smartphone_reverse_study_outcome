package androidx.compose.ui.text.input;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Deprecated(message = "Use PlatformTextInputModifierNode instead.")
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JF\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0018\u0010\u0013\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0004\u0012\u00020\u00170\u00142\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170\u0014H\u0016J\b\u0010\u000e\u001a\u00020\u0017H\u0007J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\bH\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0007J\b\u0010\u001c\u001a\u00020\u0017H\u0007J\b\u0010\u001d\u001a\u00020\u0017H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007j\n\u0012\u0006\u0012\u0004\u0018\u00010\b`\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/text/input/TextInputService;", "", "platformTextInputService", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "<init>", "(Landroidx/compose/ui/text/input/PlatformTextInputService;)V", "_currentInputSession", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/ui/text/input/TextInputSession;", "Landroidx/compose/ui/text/AtomicReference;", "Ljava/util/concurrent/atomic/AtomicReference;", "currentInputSession", "getCurrentInputSession$ui_text", "()Landroidx/compose/ui/text/input/TextInputSession;", "startInput", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "onEditCommand", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/input/EditCommand;", "", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "stopInput", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "showSoftwareKeyboard", "hideSoftwareKeyboard", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class TextInputService {
    public static final int $stable = 8;
    private final AtomicReference<TextInputSession> _currentInputSession;
    private final PlatformTextInputService platformTextInputService;

    public final TextInputSession getCurrentInputSession$ui_text() {
        return this._currentInputSession.get();
    }

    @Deprecated(message = "Use SoftwareKeyboardController.hide or TextInputSession.hideSoftwareKeyboard instead.", replaceWith = @ReplaceWith(expression = "textInputSession.hideSoftwareKeyboard()", imports = {}))
    public final void hideSoftwareKeyboard() {
        this.platformTextInputService.hideSoftwareKeyboard();
    }

    public final void startInput() {
        this.platformTextInputService.startInput();
        TextInputSession r100 = new TextInputSession(this, this.platformTextInputService);
        this._currentInputSession.set(r100);
    }

    public final void stopInput() {
        this._currentInputSession.set(null);
        this.platformTextInputService.stopInput();
    }

    @Deprecated(message = "Use SoftwareKeyboardController.show or TextInputSession.showSoftwareKeyboard instead.", replaceWith = @ReplaceWith(expression = "textInputSession.showSoftwareKeyboard()", imports = {}))
    public final void showSoftwareKeyboard() {
        if (getCurrentInputSession$ui_text() == null) goto L6;
        this.platformTextInputService.showSoftwareKeyboard();
        return;
    }

    public TextInputService(PlatformTextInputService r100) {
        this.platformTextInputService = r100;
        this._currentInputSession = new AtomicReference(null);
    }

    public void stopInput(TextInputSession r100) {
        AtomicReference<TextInputSession> r101 = this._currentInputSession;
    L4:
        if (r101.compareAndSet(r100, null) == true) goto L5;
        if (r101.get() == r100) goto L4;
        boolean r102 = false;
    L9:
        if (r102 == false) goto L15;
        this.platformTextInputService.stopInput();
        return;
    L15:
        return;
    L5:
        r102 = true;
        goto L9
    }

    public TextInputSession startInput(TextFieldValue r100, ImeOptions r101, Function1<? super List<? extends EditCommand>, Unit> r102, Function1<? super ImeAction, Unit> r103) {
        this.platformTextInputService.startInput(r100, r101, r102, r103);
        TextInputSession r104 = new TextInputSession(this, this.platformTextInputService);
        this._currentInputSession.set(r104);
        return r104;
    }
}
