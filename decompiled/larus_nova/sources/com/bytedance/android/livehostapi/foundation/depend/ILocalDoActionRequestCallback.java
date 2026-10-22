package com.bytedance.android.livehostapi.foundation.depend;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public interface ILocalDoActionRequestCallback {
    void onFailed(int r100, String r101);

    void onSuccess(JSONObject r100);
}
