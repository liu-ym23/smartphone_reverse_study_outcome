package com.android.server.am;

import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface ILowMemDetectorOptEx {
    default boolean dispatch(int newPressureState) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }
}
