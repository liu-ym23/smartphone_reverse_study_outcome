package com.android.server.input;

import android.content.Context;
import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes2.dex */
public interface IInputInfoTransService {
    default void startService(Context context) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void notifyInputInfoTrans(int displayId) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
