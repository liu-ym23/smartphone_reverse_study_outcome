package com.android.server.audio;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface ISmtMediaMonitorService {
    default void updateInfo(String info, boolean upload) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
