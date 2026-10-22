package com.android.server.am;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IKillingStats {
    default void reportKillingEvent(String killEvent) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void flush(boolean writeProto) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
