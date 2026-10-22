package com.android.ttcjpaysdk.base.service;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayVerifyResultCallBack {
    void onFailed(JSONObject r100, JSONObject r101);

    void onLoginFailed();

    void onSuccess(Map<String, String> r100, JSONObject r101);

    void toConfirm();
}
