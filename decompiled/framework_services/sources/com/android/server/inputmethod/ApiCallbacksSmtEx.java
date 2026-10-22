package com.android.server.inputmethod;

import android.os.ResultReceiver;
import com.android.internal.view.IInputMethodManagerSmtEx;

/* JADX INFO: loaded from: classes2.dex */
public class ApiCallbacksSmtEx extends IInputMethodManagerSmtEx.Stub {
    public ApiCallbacksSmtEx() {
    }

    public boolean hideCurrentSoft(int flags, ResultReceiver resultReceiver) {
        return false;
    }
}
