package com.android.server.am;

import android.content.Intent;
import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IColdStartTrim {
    default void tryColdStartTrim(Intent intent, String callingPackage) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void onMemoryPsiEvent(int newPressureState) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
