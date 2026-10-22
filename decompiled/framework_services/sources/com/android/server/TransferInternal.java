package com.android.server;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface TransferInternal {
    default void notifyPropChanged(int flag, long timeout) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
