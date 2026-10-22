package com.android.server.am;

import android.content.Context;
import android.os.DebugSmtEx;

/* JADX INFO: loaded from: classes.dex */
public interface IBatteryStatsServiceOptEx {
    default void init(Context context, BatteryStatsService service) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void syncStateIfNeed() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
