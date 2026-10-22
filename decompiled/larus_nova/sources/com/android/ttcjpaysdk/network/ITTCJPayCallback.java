package com.android.ttcjpaysdk.network;

import org.json.JSONObject;
import te4.b;

/* JADX INFO: loaded from: classes39.dex */
public interface ITTCJPayCallback {

    /* JADX INFO: renamed from: com.android.ttcjpaysdk.network.ITTCJPayCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onResponse(ITTCJPayCallback r100, b r101, String r102, String r103) {
        }
    }

    void onFailure(JSONObject r100);

    void onResponse(JSONObject r100, String r101);

    void onResponse(b r100, String r101, String r102);
}
