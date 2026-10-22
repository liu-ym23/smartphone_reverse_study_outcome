package com.byted.mgl.merge.service.api.aweme;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public interface RequestLynxPaymentCallback {
    JSONObject getMiniGameEventCommonParams();

    void onFailed();

    void onSuccess(int r100, String r101);
}
