package com.android.server.am;

import android.content.Intent;
import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IKernelTrigger {
    default void init(ActivityManagerService ams) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void notifyActivityStart(Intent intent, String callingPackage) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
