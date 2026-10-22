package com.android.server.location;

import android.os.DebugSmtEx;
import com.android.server.location.injector.AppForegroundHelper;

/* JADX INFO: loaded from: classes2.dex */
public interface IAppForegroundHelperOptEx {
    default void onSystemReady() {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void init(AppForegroundHelper helper) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }
}
