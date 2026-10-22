package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001a\u0013\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"cancelsTextSelection", "", "Landroidx/compose/ui/input/key/KeyEvent;", "cancelsTextSelection-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "showCharacterPalette", "", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class KeyEventHelpers_androidKt {
    public static final void showCharacterPalette() {
    }

    /* JADX INFO: renamed from: cancelsTextSelection-ZmokQxo, reason: not valid java name */
    public static final boolean m1051cancelsTextSelectionZmokQxo(KeyEvent r100) {
        if (r100.getKeyCode() == 4) goto L5;
    L7:
        return false;
    L5:
        if (KeyEventType.m5970equalsimpl0(KeyEvent_androidKt.m5978getTypeZmokQxo(r100), KeyEventType.Companion.m5975getKeyUpCS__XNY()) == false) goto L7;
        return true;
    }
}
