package com.bytedance.frameworks.baselib.network.http.storeregion;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface StoreRegionBridge {
    void onStoreIdcChanged(String r10, String r11, String r12);

    void sendFeedbackLog(String r10, String r11);

    void updateTncConfig(JSONObject r10, String r11, String r12, boolean r13);
}
