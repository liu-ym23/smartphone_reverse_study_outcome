package com.android.ttcjpaysdk.base.network;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface ICJPayCallback {
    void onFailure(JSONObject r100);

    void onResponse(JSONObject r100);
}
