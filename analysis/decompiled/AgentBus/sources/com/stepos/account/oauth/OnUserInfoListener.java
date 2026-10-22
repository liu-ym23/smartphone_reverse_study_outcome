package com.stepos.account.oauth;

import org.json.JSONObject;

/* loaded from: classes.dex */
public interface OnUserInfoListener {
    void onFailed(int i2, String str);

    void onSuccess(JSONObject jSONObject);
}
