package com.android.ttcjpaysdk.thirdparty.utils.retaindialog.bean;

import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.hihonor.honorid.core.data.UserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"parseJsonToCJPayQueryGrowthDecisionResponse", "Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayQueryGrowthDecisionResponse;", "jsonObject", "Lorg/json/JSONObject;", "getGrowthModelView", "Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayGrowthModelView;", "contactInfo", "Lcom/android/ttcjpaysdk/thirdparty/utils/retaindialog/bean/CJPayRetainContactInfo;", "bdpay-base_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CJPayQueryGrowthDecisionResponseKt {
    public static final CJPayQueryGrowthDecisionResponse parseJsonToCJPayQueryGrowthDecisionResponse(JSONObject r110) {
        Intrinsics.checkNotNullParameter(r110, "jsonObject");
        String r100 = r110.optString("code");
        String r101 = r110.optString("msg");
        String r102 = r110.optString("status");
        String r103 = r110.optString("growth_model_views");
        if (Intrinsics.areEqual(r100, "CD000000") == false) goto L47;
        if (Intrinsics.areEqual(r102, "SUCCESS") == false) goto L47;
        int r104 = 0;
        if (r103.length() <= 0) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L28;
        JSONArray r106 = KtSafeMethodExtensionKt.safeCreateJsonArray(r103);
        if (r106.length() <= 0) goto L28;
        ArrayList r107 = new ArrayList();
        int r108 = r106.length();
    L15:
        if (r104 >= r108) goto L27;
        JSONObject r109 = JSONArrayProtectorUtils.getJSONObject(r106, r104);
        String r111 = r109.optString("growth_type");
        JSONObject r112 = r109.optJSONObject(DocCallbackImpl.KEY_CONTACT_INFO);
        if (r112 == null) goto L19;
        CJPayRetainContactInfo r113 = new CJPayRetainContactInfo(CJPayProcess.Companion.fromString(r112.optString("process")), CJPayFunction.Companion.fromString(r112.optString("function")), CJPayBehavior.Companion.fromString(r112.optString("behavior")), new CJPayUserState(r112.optString(UserInfo.USERSTATE)));
    L20:
        if (r113 == null) goto L26;
        JSONArray r114 = r109.optJSONArray("view_model_list");
        if (r114 != null) goto L25;
        r114 = new JSONArray();
    L25:
        r107.add(new CJPayGrowthModelView(r111, r113, r114));
    L26:
        r104 = r104 + 1;
        goto L15
    L19:
        r113 = null;
        goto L20
    L27:
        ArrayList r115 = r107;
    L29:
        JSONObject r116 = r110.optJSONObject("exts");
        if (r116 == null) goto L35;
        Iterator<String> r117 = r116.keys();
        Map r118 = new LinkedHashMap();
    L33:
        if (r117.hasNext() == false) goto L36;
        String r119 = r117.next();
        r118.put(r119, JSONObjectProtectorUtils.getString(r116, r119));
    L36:
        JSONObject r120 = r110.optJSONObject("common_params");
        if (r120 == null) goto L43;
        Iterator<String> r121 = r120.keys();
        LinkedHashMap r122 = new LinkedHashMap();
    L40:
        if (r121.hasNext() == false) goto L42;
        String r123 = r121.next();
        r122.put(r123, JSONObjectProtectorUtils.getString(r120, r123));
        goto L40
    L42:
        Map r124 = r122;
    L45:
        return new CJPayQueryGrowthDecisionResponse(r100, r101, r115, r118, r124);
    L43:
        r124 = MapsKt.emptyMap();
        goto L45
    L35:
        r118 = MapsKt.emptyMap();
    L28:
        r115 = null;
        goto L29
    L10:
        r105 = false;
    L47:
        return new CJPayQueryGrowthDecisionResponse(r100, r101, null, MapsKt.emptyMap(), MapsKt.emptyMap());
    }

    public static final CJPayGrowthModelView getGrowthModelView(CJPayQueryGrowthDecisionResponse r100, CJPayRetainContactInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "contactInfo");
        List<CJPayGrowthModelView> r102 = r100.getGrowthModelViewList();
        Object r103 = null;
        if (r102 == null) goto L15;
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L11;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((CJPayGrowthModelView) r105).getContactInfo(), r101) == false) goto L6;
        r103 = r105;
    L11:
        return (CJPayGrowthModelView) r103;
    L15:
        return null;
    }
}
