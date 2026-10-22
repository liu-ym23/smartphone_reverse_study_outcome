package com.bytedance.applog;

import org.json.JSONObject;

@Deprecated
/* loaded from: classes.dex */
public interface IPresetEventObserver {
    void onLaunch(JSONObject jSONObject);

    void onPageEnter(JSONObject jSONObject);

    void onPageLeave(JSONObject jSONObject);
}
