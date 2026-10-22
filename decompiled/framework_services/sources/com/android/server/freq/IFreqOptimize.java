package com.android.server.freq;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes2.dex */
public interface IFreqOptimize {
    default void systemReady() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
