package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayWXIndependentSignService extends ICJPayService {
    void independentAppSign(Context r100, String r101, String r102);

    void independentSign(Context r100, String r101, String r102, JSONObject r103);
}
