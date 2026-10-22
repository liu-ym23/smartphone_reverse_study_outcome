package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayMultiProcessService extends ICJPayService {
    void pay(Context r100, JSONObject r101, String r102, int r103, String r104, String r105, String r106);

    void stop(Context r100);
}
