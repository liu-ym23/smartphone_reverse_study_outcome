package com.android.ttcjpaysdk.base.service;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface ICJPayFingerprintEnableCallback {
    void onEnableFailed(String r100, String r101, JSONObject r102);

    void onEnableSucceeded();
}
