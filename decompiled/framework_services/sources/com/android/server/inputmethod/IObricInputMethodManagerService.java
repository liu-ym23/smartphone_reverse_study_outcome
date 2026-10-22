package com.android.server.inputmethod;

import android.os.IBinder;
import android.view.inputmethod.EditorInfo;
import com.android.internal.inputmethod.IInputMethodClient;
import com.android.internal.inputmethod.IRemoteInputConnection;
import com.android.internal.inputmethod.InputBindResult;
import com.android.internal.view.IObricInputMethodManager;
import com.obric.utils.IObricBase;

/* JADX INFO: loaded from: classes2.dex */
public interface IObricInputMethodManagerService extends IObricBase {
    IObricInputMethodManager getIObricExt();

    default void setFakeInputConnection(IRemoteInputConnection connection, int start, int end, CharSequence text, String packageName) {
    }

    default InputBindResult getInputBindResult(IBinder windowToken, int startInputFlags, EditorInfo editorInfo, IRemoteInputConnection inputConnection, ClientState cs) {
        return InputBindResult.DISPLAY_ID_MISMATCH;
    }

    default boolean canShowAutoInputMethodPicker(IInputMethodClient client) {
        return false;
    }

    default int getAutoInputMethodPickerDisplayId(IInputMethodClient client, int fallbackDisplayId) {
        return fallbackDisplayId;
    }
}
