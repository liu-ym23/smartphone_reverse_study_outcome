package com.bytedance.android.live.network.impl.interceptor;

import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.network.response.RequestError;

/* JADX INFO: loaded from: classes46.dex */
public interface q {
    boolean a(String r100, int r101, BaseResponse<?, ?> r102, String r103, RequestError r104);

    boolean b(int r100, com.bytedance.android.live.network.response.c r101, RequestError r102);

    void c(String r100, ExtraResponse r101);
}
