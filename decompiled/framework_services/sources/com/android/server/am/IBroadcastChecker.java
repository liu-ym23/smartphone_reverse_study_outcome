package com.android.server.am;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IBroadcastChecker {
    default void init(Context context) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean isFilteredBroadcast(ProcessRecord r, String intentAction) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean checkBroadcastIsPackageCanStart(ResolveInfo info, BroadcastRecord r) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return true;
    }
}
