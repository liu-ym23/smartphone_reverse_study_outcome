package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayFrontMyBankCardService extends ICJPayService {
    void startFrontMyBankCard(Context r100, JSONObject r101);

    void startFrontMyBankCardWithSchema(Context r100, String r101, JSONObject r102);
}
