package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import androidx.core.util.Pair;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayRealNameAuthCallback;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayRealNameAuthService extends ICJPayService {
    void setEventExtParams(Pair<? extends String, Object>[] r100);

    void startCJPayRealNameAuthActivity(Context r100, String r101, String r102, TTCJPayRealNameAuthCallback r103, JSONObject r104);

    void startCJPayRealNameByInfo(Context r100, String r101, TTCJPayRealNameAuthCallback r102, JSONObject r103, JSONArray r104, boolean r105);
}
