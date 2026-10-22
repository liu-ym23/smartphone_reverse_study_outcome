package com.android.server.am;

import android.os.DebugSmtEx;
import android.util.ArraySet;

/* JADX INFO: loaded from: classes.dex */
public interface IPrimaryProfCollecter {
    default void uploadProfIfNeeded(ArraySet<String> pkgs) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
