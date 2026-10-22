package com.android.server.am;

import android.os.DebugSmtEx;
import com.android.server.wm.ActivityRecord;

/* JADX INFO: loaded from: classes.dex */
public interface IIntelliScene {
    default boolean isReady() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default void onActivityStartEventSync(ActivityRecord r, int startType, boolean prefetchAffected) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
