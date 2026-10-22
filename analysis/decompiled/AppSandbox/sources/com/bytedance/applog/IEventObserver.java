package com.bytedance.applog;

import org.json.JSONObject;

/* loaded from: classes.dex */
public interface IEventObserver {
    void onEvent(String str, String str2, String str3, long j, long j2, String str4);

    void onEventV3(String str, JSONObject jSONObject);
}
