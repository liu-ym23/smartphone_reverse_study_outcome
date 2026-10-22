package com.stepos.account.oauth;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface OnUserInfoListener {
    void onFailed(int i, String str);

    void onSuccess(JSONObject jSONObject);
}
