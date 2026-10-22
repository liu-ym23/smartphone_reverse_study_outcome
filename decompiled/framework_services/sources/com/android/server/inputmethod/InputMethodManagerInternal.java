package com.android.server.inputmethod;

import android.os.IBinder;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodSubtype;
import com.android.internal.inputmethod.IAccessibilityInputMethodSession;
import com.android.internal.inputmethod.InlineSuggestionsRequestCallback;
import com.android.internal.inputmethod.InlineSuggestionsRequestInfo;
import com.android.server.LocalServices;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class InputMethodManagerInternal {
    private static final InputMethodManagerInternal NOP = null;

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ImfLockFree {
    }

    public interface InputMethodListListener {
        void onInputMethodListUpdated(List<InputMethodInfo> r1, int r2);
    }

    public abstract List<InputMethodInfo> getEnabledInputMethodListAsUser(int r1);

    public abstract List<InputMethodSubtype> getEnabledInputMethodSubtypeListAsUser(String r1, boolean r2, int r3);

    public abstract List<InputMethodInfo> getInputMethodListAsUser(int r1);

    public abstract void hideInputMethod(int r1, int r2);

    public abstract void maybeFinishStylusHandwriting();

    public abstract void onCreateInlineSuggestionsRequest(int r1, InlineSuggestionsRequestInfo r2, InlineSuggestionsRequestCallback r3);

    public abstract void onImeInputTargetVisibilityChanged(IBinder r1, boolean r2, int r3);

    public abstract void onImeParentChanged(int r1);

    public abstract void onSessionForAccessibilityCreated(int r1, IAccessibilityInputMethodSession r2, int r3);

    public abstract void onSwitchKeyboardLayoutShortcut(int r1, int r2, IBinder r3);

    public abstract void registerInputMethodListListener(InputMethodListListener r1);

    public abstract void removeImeSurface(int r1);

    public abstract void reportImeControl(IBinder r1);

    public abstract void setHasVisibleImeLayeringOverlay(boolean r1, int r2);

    public abstract boolean setInputMethodEnabled(String r1, boolean r2, int r3);

    public abstract void setInteractive(boolean r1);

    public abstract void setVirtualDeviceInputMethodForAllUsers(int r1, String r2);

    public abstract boolean switchToInputMethod(String r1, int r2, int r3);

    public abstract boolean transferTouchFocusToImeWindow(IBinder r1, int r2, int r3);

    public abstract void unbindAccessibilityFromCurrentClient(int r1, int r2);

    public abstract void updateImeWindowStatus(boolean r1, int r2);

    public abstract void updateShouldShowImeSwitcher(int r1, int r2);

    public InputMethodManagerInternal() {
    }

    public boolean switchToInputMethod(String imeId, int userId) {
        return switchToInputMethod(imeId, -1, userId);
    }

    public boolean isAiPanelShow() {
        return false;
    }

    static {
        NOP = new AnonymousClass1();
    }

    public static InputMethodManagerInternal get() {
        InputMethodManagerInternal instance = (InputMethodManagerInternal) LocalServices.getService(InputMethodManagerInternal.class);
        if (instance == null) goto L6;
        return instance;
    L6:
        return NOP;
    }

    public IExtInputMethodManagerService getExt() {
        return null;
    }
}
