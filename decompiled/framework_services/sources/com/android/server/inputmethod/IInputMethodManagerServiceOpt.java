package com.android.server.inputmethod;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes2.dex */
public interface IInputMethodManagerServiceOpt {
    default void init(InputMethodManagerService methodManagerService) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void updateInputMethodClientUid(int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
