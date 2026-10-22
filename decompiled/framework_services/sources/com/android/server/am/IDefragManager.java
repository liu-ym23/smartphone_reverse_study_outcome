package com.android.server.am;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IDefragManager {
    default void init(ActivityManagerService ams) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
