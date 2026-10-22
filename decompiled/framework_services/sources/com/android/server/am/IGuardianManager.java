package com.android.server.am;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IGuardianManager {
    default void init(ActivityManagerService ams) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
