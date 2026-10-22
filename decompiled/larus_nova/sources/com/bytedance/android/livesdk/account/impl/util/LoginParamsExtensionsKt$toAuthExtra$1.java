package com.bytedance.android.livesdk.account.impl.util;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"broadcastExtras", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class LoginParamsExtensionsKt$toAuthExtra$1 extends Lambda implements Function0<String> {
    public static final LoginParamsExtensionsKt$toAuthExtra$1 INSTANCE = null;

    static {
        INSTANCE = new LoginParamsExtensionsKt$toAuthExtra$1();
    }

    public LoginParamsExtensionsKt$toAuthExtra$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        JSONObject r100 = new JSONObject();
        r100.put("content", "已阅读并同意用户授权协议以及抖音主播入驻协议");     // Catch: JSONException -> L5
        JSONArray r101 = new JSONArray();     // Catch: JSONException -> L5
        r100.put("parts", r101);     // Catch: JSONException -> L5
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L5
        r102.put("start", 6);     // Catch: JSONException -> L5
        r102.put("end", 12);     // Catch: JSONException -> L5
        r102.put("url", "https://lf1-webcastcdn-tos.douyinstatic.com/obj/ies-fe-bee/bee_prod/biz_167/bee_prod_167_bee_publish_915.html");     // Catch: JSONException -> L5
        r101.put(r102);     // Catch: JSONException -> L5
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L5
        r103.put("start", 14);     // Catch: JSONException -> L5
        r103.put("end", 22);     // Catch: JSONException -> L5
        r103.put("url", "https://webcast.amemv.com/falcon/webcast_douyin/page/anchor_agreement/index.html?type=fullscreen&title=&hide_more=0&hide_status_bar=0&status_bar_color=white&status_bar_bg_color=%2300000000&__live_platform__=webcast");     // Catch: JSONException -> L5
        r101.put(r103);     // Catch: JSONException -> L5
    L8:
        return r100.toString();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }
}
