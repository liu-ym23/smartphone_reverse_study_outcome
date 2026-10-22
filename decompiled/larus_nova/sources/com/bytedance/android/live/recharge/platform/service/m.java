package com.bytedance.android.live.recharge.platform.service;

import com.android.ttcjpaysdk.base.service.IHostApi;
import com.android.ttcjpaysdk.base.service.IPayLifecycle;
import com.android.ttcjpaysdk.base.service.ITTCJPayComponent;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public interface m extends com.bytedance.android.live.recharge.core.c {
    JSONObject I(String r100);

    ITTCJPayComponent L(IPayLifecycle r100, IHostApi r101);

    void X0(String r100, JSONObject r101);

    void a(String r100);

    ITTCJPayComponent f(String r100);

    JSONObject f0();

    void s1(String r100, ITTCJPayComponent r101);

    boolean w(JSONObject r100);
}
