package com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean;

import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"parseJsonToCJPayRetainPiyataResponse", "Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainPiyataResponse;", "jsonObject", "Lorg/json/JSONObject;", "bdpay-base_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CJPayRetainPiyataResponseKt {
    public static final CJPayRetainPiyataResponse parseJsonToCJPayRetainPiyataResponse(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        String r101 = r100.optString("sub_type");     // Catch: Exception -> L8
        String r102 = r100.optString("rule_id");     // Catch: Exception -> L8
        String r103 = r100.optString("is_client_decision");     // Catch: Exception -> L8
        String r104 = r100.optString("contact_retain_info");     // Catch: Exception -> L8
        JSONObject r105 = r100.optJSONObject("growth_view_model");     // Catch: Exception -> L8
        if (r105 != null) goto L6;
        r105 = new JSONObject();     // Catch: Exception -> L8
    L6:
        return new CJPayRetainPiyataResponse(r101, r102, r105, r104, r103, r100.optString("prior_lynx_schema"), r100.optString("material"));
    L8:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayRetainPiyataResponse#parseJsonToCJPayRetainPiyataResponse", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayRetainPiyataResponse#parseJsonToCJPayRetainPiyataResponse", e);
        e.printStackTrace();
        return null;
    }
}
