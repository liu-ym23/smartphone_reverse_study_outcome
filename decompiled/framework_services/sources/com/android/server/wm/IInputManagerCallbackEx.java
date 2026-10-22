package com.android.server.wm;

import android.os.DebugSmtEx;
import android.os.IBinder;
import android.view.InputApplicationHandle;
import java.util.OptionalInt;

/* JADX INFO: loaded from: classes3.dex */
public interface IInputManagerCallbackEx {
    default void monitorAnr(WindowManagerService service, InputApplicationHandle inputApplicationHandle, IBinder token, String reason) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void monitorAnr(IBinder token, OptionalInt pid, String reason) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
