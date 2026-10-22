package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface Ok3TncBridge {
    JSONObject getTNCInfo();

    void onOk3Response(Request r10, Response r11);

    void onOk3Timeout(Request r10, Exception r11);
}
