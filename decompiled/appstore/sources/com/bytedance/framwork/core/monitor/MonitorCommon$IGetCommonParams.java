package com.bytedance.framwork.core.monitor;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface MonitorCommon$IGetCommonParams {
    Map<String, String> getCommonParams();

    String getSessionId();

    long getUid();
}
