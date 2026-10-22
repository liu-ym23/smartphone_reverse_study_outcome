package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.key.Key_androidKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u001b\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"interceptDPadAndMoveFocus", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "isKeyCode", "", "Landroidx/compose/ui/input/key/KeyEvent;", "keyCode", "", "isKeyCode-YhN2O0w", "(Landroid/view/KeyEvent;I)Z", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldFocusModifier_androidKt {
    /* JADX INFO: renamed from: access$isKeyCode-YhN2O0w, reason: not valid java name */
    public static final /* synthetic */ boolean m1142access$isKeyCodeYhN2O0w(KeyEvent r100, int r101) {
        return m1143isKeyCodeYhN2O0w(r100, r101);
    }

    /* JADX INFO: renamed from: isKeyCode-YhN2O0w, reason: not valid java name */
    private static final boolean m1143isKeyCodeYhN2O0w(KeyEvent r100, int r101) {
        if (Key_androidKt.m5984getNativeKeyCodeYVgTNJs(KeyEvent_androidKt.m5977getKeyZmokQxo(r100)) != r101) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Modifier interceptDPadAndMoveFocus(Modifier r100, final LegacyTextFieldState r101, final FocusManager r102) {
        return KeyInputModifierKt.onPreviewKeyEvent(r100, new AnonymousClass1(r102, r101));
    }
}
