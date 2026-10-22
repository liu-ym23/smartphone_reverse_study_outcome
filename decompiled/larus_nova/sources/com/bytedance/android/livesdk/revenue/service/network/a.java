package com.bytedance.android.livesdk.revenue.service.network;

import android.app.Activity;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.h;
import com.bytedance.android.live.base.model.i;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public interface a extends dy0.a {
    String M6(String r100);

    void Pf(Activity r100, int r101, String r102, b r103, String r104, String r105, String r106, RequestError r107, boolean r108);

    Observable<ExtraResponse<List<h>, i>> Z7(String r100, Map<String, String> r101, Map<String, String> r102, JsonObject r103);

    com.bytedance.android.livesdk.revenue.network.i di(int r100, String r101, Map r102) throws IOException;

    <T> am3.c<T> getProtoDecoder(Class<T> r100);

    <T> T getService(Class<T> r100);

    Observable<ExtraResponse<List<h>, i>> ik(String r100, Map<String, String> r101, Map<String, String> r102, Map<String, ? extends List<String>> r103, Map<String, String> r104, Map<String, ? extends List<String>> r105);

    Observable<ExtraResponse<List<h>, i>> t9(String r100, Map<String, String> r101, Map<String, String> r102, Map<String, ? extends List<String>> r103);

    void yf(String r100, int r101, RequestError r102, Extra r103);
}
