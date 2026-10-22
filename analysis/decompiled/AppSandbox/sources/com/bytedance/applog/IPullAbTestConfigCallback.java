package com.bytedance.applog;

import org.json.JSONObject;

/* loaded from: classes.dex */
public interface IPullAbTestConfigCallback {
    void onRemoteConfig(JSONObject jSONObject);

    void onThrottle(long j);

    void onTimeoutError();
}
