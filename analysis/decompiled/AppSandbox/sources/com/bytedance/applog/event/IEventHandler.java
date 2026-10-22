package com.bytedance.applog.event;

import org.json.JSONObject;

/* loaded from: classes.dex */
public interface IEventHandler {
    int acceptType();

    EventPolicy onReceive(int i, String str, JSONObject jSONObject, EventBasicData eventBasicData);
}
