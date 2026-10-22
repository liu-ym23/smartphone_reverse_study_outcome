package androidx.compose.foundation.text;

import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.input.ImeAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/text/KeyboardActionRunner;", "Landroidx/compose/foundation/text/KeyboardActionScope;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "<init>", "(Landroidx/compose/ui/platform/SoftwareKeyboardController;)V", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "getKeyboardActions", "()Landroidx/compose/foundation/text/KeyboardActions;", "setKeyboardActions", "(Landroidx/compose/foundation/text/KeyboardActions;)V", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "getFocusManager", "()Landroidx/compose/ui/focus/FocusManager;", "setFocusManager", "(Landroidx/compose/ui/focus/FocusManager;)V", "runAction", "", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "runAction-KlQnJC8", "(I)Z", "defaultKeyboardActionWithResult", "defaultKeyboardActionWithResult-KlQnJC8", "defaultKeyboardAction", "", "defaultKeyboardAction-KlQnJC8", "(I)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class KeyboardActionRunner implements KeyboardActionScope {
    public static final int $stable = 8;
    public FocusManager focusManager;
    public KeyboardActions keyboardActions;
    private final SoftwareKeyboardController keyboardController;

    public final FocusManager getFocusManager() {
        FocusManager r100 = this.focusManager;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("focusManager");
        return null;
    }

    public final KeyboardActions getKeyboardActions() {
        KeyboardActions r100 = this.keyboardActions;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("keyboardActions");
        return null;
    }

    public KeyboardActionRunner(SoftwareKeyboardController r100) {
        this.keyboardController = r100;
    }

    /* JADX INFO: renamed from: defaultKeyboardActionWithResult-KlQnJC8, reason: not valid java name */
    private final boolean m1053defaultKeyboardActionWithResultKlQnJC8(int r100) {
        ImeAction.Companion r101 = ImeAction.Companion;
        if (ImeAction.m7167equalsimpl0(r100, r101.m7183getNexteUduSuo()) == false) goto L6;
        getFocusManager().mo4475moveFocus3ESFkO8(FocusDirection.Companion.m4469getNextdhqQ8s());
        return true;
    L6:
        if (ImeAction.m7167equalsimpl0(r100, r101.m7185getPreviouseUduSuo()) == false) goto L9;
        getFocusManager().mo4475moveFocus3ESFkO8(FocusDirection.Companion.m4470getPreviousdhqQ8s());
        return true;
    L9:
        if (ImeAction.m7167equalsimpl0(r100, r101.m7181getDoneeUduSuo()) == false) goto L13;
        SoftwareKeyboardController r102 = this.keyboardController;
        if (r102 == null) goto L13;
        r102.hide();
        return true;
    L13:
        return false;
    }

    @Override // androidx.compose.foundation.text.KeyboardActionScope
    /* JADX INFO: renamed from: defaultKeyboardAction-KlQnJC8, reason: not valid java name */
    public void mo1054defaultKeyboardActionKlQnJC8(int r100) {
        m1053defaultKeyboardActionWithResultKlQnJC8(r100);
    }

    /* JADX INFO: renamed from: runAction-KlQnJC8, reason: not valid java name */
    public final boolean m1055runActionKlQnJC8(int r100) {
        ImeAction.Companion r101 = ImeAction.Companion;
        if (ImeAction.m7167equalsimpl0(r100, r101.m7181getDoneeUduSuo()) == false) goto L6;
        Function1<KeyboardActionScope, Unit> r102 = getKeyboardActions().getOnDone();
    L28:
        if (r102 == null) goto L32;
        r102.invoke(this);
        return true;
    L32:
        return m1053defaultKeyboardActionWithResultKlQnJC8(r100);
    L6:
        if (ImeAction.m7167equalsimpl0(r100, r101.m7182getGoeUduSuo()) == false) goto L9;
        r102 = getKeyboardActions().getOnGo();
        goto L28
    L9:
        if (ImeAction.m7167equalsimpl0(r100, r101.m7183getNexteUduSuo()) == false) goto L12;
        r102 = getKeyboardActions().getOnNext();
        goto L28
    L12:
        if (ImeAction.m7167equalsimpl0(r100, r101.m7185getPreviouseUduSuo()) == false) goto L15;
        r102 = getKeyboardActions().getOnPrevious();
        goto L28
    L15:
        if (ImeAction.m7167equalsimpl0(r100, r101.m7186getSearcheUduSuo()) == false) goto L18;
        r102 = getKeyboardActions().getOnSearch();
        goto L28
    L18:
        if (ImeAction.m7167equalsimpl0(r100, r101.m7187getSendeUduSuo()) == false) goto L21;
        r102 = getKeyboardActions().getOnSend();
        goto L28
    L21:
        if (ImeAction.m7167equalsimpl0(r100, r101.m7180getDefaulteUduSuo()) == false) goto L23;
    L27:
        r102 = null;
        goto L28
    L23:
        if (ImeAction.m7167equalsimpl0(r100, r101.m7184getNoneeUduSuo()) == true) goto L27;
        throw new IllegalStateException("invalid ImeAction".toString());
    }

    public final void setFocusManager(FocusManager r100) {
        this.focusManager = r100;
    }

    public final void setKeyboardActions(KeyboardActions r100) {
        this.keyboardActions = r100;
    }
}
