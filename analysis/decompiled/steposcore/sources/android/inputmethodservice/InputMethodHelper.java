package android.inputmethodservice;

import android.view.inputmethod.InputConnection;
import com.android.internal.inputmethod.CancellationGroup;
import com.android.internal.inputmethod.IRemoteInputConnection;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class InputMethodHelper {
    private InputMethodHelper() {
    }

    public static InputConnection createRemoteInputConnection(InputMethodService ims, IRemoteInputConnection remote, CancellationGroup group) {
        InputMethodServiceInternal internal = ims != null ? ims.peekInputMethodServiceInternal() : null;
        return new RemoteInputConnection(new WeakReference(internal), remote, group);
    }

    public static IRemoteInputConnection getInputConnection(InputConnection connection) {
        if (connection instanceof RemoteInputConnection) {
            return ((RemoteInputConnection) connection).getRemoteInputConnectionHolder();
        }
        return null;
    }
}
