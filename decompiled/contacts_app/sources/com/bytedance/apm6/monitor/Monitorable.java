package com.bytedance.apm6.monitor;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface Monitorable {
    String getLogType();

    boolean isValid();

    JSONObject toJsonObject();
}
