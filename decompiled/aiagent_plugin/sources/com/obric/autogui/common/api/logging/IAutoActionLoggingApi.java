package com.obric.autogui.common.api.logging;

import android.content.Context;

/* JADX INFO: compiled from: IAutoActionLoggingApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionLoggingApi {
    void initLoggingModule(Context r1);

    ILogger provideLogger();

    void reEvaluateLogPrintingPolicy();

    void triggerLogFlush();
}
