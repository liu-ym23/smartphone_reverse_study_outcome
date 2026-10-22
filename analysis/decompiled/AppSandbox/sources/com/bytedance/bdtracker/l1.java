package com.bytedance.bdtracker;

import com.bytedance.applog.ILogger;
import com.bytedance.applog.log.ILogProcessor;
import com.bytedance.applog.log.LogInfo;

/* loaded from: classes.dex */
public class l1 implements ILogProcessor {
    public final ILogger a;

    public l1(ILogger iLogger) {
        this.a = iLogger;
    }

    @Override // com.bytedance.applog.log.ILogProcessor
    public void onLog(LogInfo logInfo) {
        ILogger iLogger = this.a;
        if (iLogger != null) {
            iLogger.log(logInfo.getMessage(), logInfo.getThrowable());
        }
    }
}
