package com.android.server;

import android.app.IApplicationThread;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public interface ISceneMetricsAnalyzer {
    default void init(Context context) {
    }

    default void dispatchSceneConfigs(IApplicationThread thread, String callerPackage) {
    }
}
