package com.bytedance.applog;

import org.json.JSONObject;

/* loaded from: classes.dex */
public interface IPickerCallback {
    void failed(String str);

    void success(JSONObject jSONObject);
}
