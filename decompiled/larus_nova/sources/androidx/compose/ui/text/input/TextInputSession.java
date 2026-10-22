package androidx.compose.ui.text.input;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.text.TextLayoutResult;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Deprecated(message = "Use PlatformTextInputModifierNode instead.")
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u000b\u001a\u00020\fJ\u0017\u0010\r\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000fH\u0082\bJ\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012JB\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\f0\u001b2\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012J\u0018\u0010\u001f\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u00152\u0006\u0010!\u001a\u00020\u0015J\u0006\u0010\"\u001a\u00020\tJ\u0006\u0010#\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006$"}, d2 = {"Landroidx/compose/ui/text/input/TextInputSession;", "", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "platformTextInputService", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "<init>", "(Landroidx/compose/ui/text/input/TextInputService;Landroidx/compose/ui/text/input/PlatformTextInputService;)V", "isOpen", "", "()Z", "dispose", "", "ensureOpenSession", "block", "Lkotlin/Function0;", "notifyFocusedRect", SVGRenderEngine.RECT, "Landroidx/compose/ui/geometry/Rect;", "updateTextLayoutResult", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "textFieldToRootTransform", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Matrix;", "innerTextFieldBounds", "decorationBoxBounds", "updateState", "oldValue", "newValue", "showSoftwareKeyboard", "hideSoftwareKeyboard", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextInputSession {
    public static final int $stable = 8;
    private final PlatformTextInputService platformTextInputService;
    private final TextInputService textInputService;

    public final void dispose() {
        this.textInputService.stopInput(this);
    }

    public final boolean isOpen() {
        return Intrinsics.areEqual(this.textInputService.getCurrentInputSession$ui_text(), this);
    }

    public final boolean hideSoftwareKeyboard() {
        boolean r100 = isOpen();
        if (r100 == false) goto L5;
        this.platformTextInputService.hideSoftwareKeyboard();
    L5:
        return r100;
    }

    public final boolean showSoftwareKeyboard() {
        boolean r100 = isOpen();
        if (r100 == false) goto L5;
        this.platformTextInputService.showSoftwareKeyboard();
    L5:
        return r100;
    }

    private final boolean ensureOpenSession(Function0<Unit> r100) {
        boolean r101 = isOpen();
        if (r101 == false) goto L5;
        r100.invoke();
    L5:
        return r101;
    }

    public final boolean notifyFocusedRect(Rect r100) {
        boolean r101 = isOpen();
        if (r101 == false) goto L5;
        this.platformTextInputService.notifyFocusedRect(r100);
    L5:
        return r101;
    }

    public TextInputSession(TextInputService r100, PlatformTextInputService r101) {
        this.textInputService = r100;
        this.platformTextInputService = r101;
    }

    public final boolean updateState(TextFieldValue r100, TextFieldValue r101) {
        boolean r102 = isOpen();
        if (r102 == false) goto L5;
        this.platformTextInputService.updateState(r100, r101);
    L5:
        return r102;
    }

    public final boolean updateTextLayoutResult(TextFieldValue r100, OffsetMapping r110, TextLayoutResult r111, Function1<? super Matrix, Unit> r112, Rect r113, Rect r114) {
        boolean r101 = isOpen();
        if (r101 == false) goto L5;
        this.platformTextInputService.updateTextLayoutResult(r100, r110, r111, r112, r113, r114);
    L5:
        return r101;
    }
}
