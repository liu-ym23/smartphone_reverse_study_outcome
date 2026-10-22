package com.bytedance.android.marketing.sdk.api;

import android.content.Context;
import android.view.View;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/marketing/sdk/api/IMarketingBridgeService;", "", "ec-biz-marketing-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMarketingBridgeService {
    void a(JSONObject r100, View r101, Context r102, Function2<? super Integer, ? super JSONObject, Unit> r103);

    void b(String r100, Map<String, ? extends Object> r101, View r102, Context r103, Function3<? super Integer, ? super String, ? super JSONObject, Unit> r104);
}
