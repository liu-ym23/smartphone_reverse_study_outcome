package com.android.server.am;

import android.os.Bundle;
import android.os.DebugSmtEx;
import android.util.Slog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public interface IBytedanceBrainBridge {
    default void downloadAppInfoIfNeeded(Bundle pkgInfo) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default int bindBytedanceBrain() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return 0;
    }

    default void deletePackage(String pkgName) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default ArrayList<String> getSmatisanBrainRecommend() {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return null;
    }

    default void getAppLaunchInfo(int uid, long duration) {
        Slog.e("SYS_DEFAULT_LOG", getClass().getName() + "|" + Thread.currentThread().getStackTrace()[1].getMethodName() + "|SYS_DEFAULT_FUN_CONTENT");
    }
}
