package com.android.server.am;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IMemInfoReaderOptEx {
    default long getFreeSizeFastKb() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default void readMemInfoFast() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default long getCachedSizeFastKb() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default long getRCAMFreeFastKb() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default long getCMAFreeFastKb() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }
}
