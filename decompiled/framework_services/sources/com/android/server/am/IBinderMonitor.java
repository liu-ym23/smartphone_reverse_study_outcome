package com.android.server.am;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IBinderMonitor {
    default void crashOrAnrOccurs() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
