package com.bytedance.apm.core;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IDynamicParams {
    Map<String, String> getCommonParams();

    String getSessionId();

    long getUid();
}
