package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayCardProtocolBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayUIComponent;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0013j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019J\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u0017j\b\u0012\u0004\u0012\u00020\u001b`\u0019J\u0018\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001e0\u001dR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CommonRecommendExt;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "choose", "", "icon_info", "Lcom/android/ttcjpaysdk/thirdparty/data/IconInfo;", "protocol_group_names", "protocol_group_names_map_by_fund_bill_index", "protocol_list", "protocol_list_map_by_fund_bill_index", "recommend_label", "show_rules", "specific_agreement_first_deduct_meta_info", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetMetaInfoBean;", BdpAppEventConstant.PARAMS_SUB_TITLE, "title", "getJsonStringToHashMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "jsonString", "getProtocolList", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayCardProtocolBean;", "Lkotlin/collections/ArrayList;", "getTitleList", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayUIComponent;", "parseShowRules", "", "", "ShowRulesType", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CommonRecommendExt implements CJPayObject, Serializable {
    public String choose;
    public IconInfo icon_info;
    public String protocol_group_names;
    public String protocol_group_names_map_by_fund_bill_index;
    public String protocol_list;
    public String protocol_list_map_by_fund_bill_index;
    public String recommend_label;
    public String show_rules;
    public AssetInfoBean.AssetMetaInfoBean specific_agreement_first_deduct_meta_info;
    public String sub_title;
    public String title;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CommonRecommendExt$ShowRulesType;", "", "()V", "FUND_LIST_INDEX_WHITELIST", "", "HOMEPAGE_STATE_SHOW_LIST", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowRulesType {
        public static final String FUND_LIST_INDEX_WHITELIST = "fund_list_index_whitelist";
        public static final String HOMEPAGE_STATE_SHOW_LIST = "homepage_state_show_list";
        public static final ShowRulesType INSTANCE = null;

        static {
            INSTANCE = new ShowRulesType();
        }

        private ShowRulesType() {
        }
    }

    public final ArrayList<CJPayCardProtocolBean> getProtocolList() {
        final ArrayList<CJPayCardProtocolBean> r100 = new ArrayList();
        String r101 = this.protocol_list;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L16;
        return r100;
    L16:
        KtSafeMethodExtensionKt.forEach(new JSONArray(r101), new AnonymousClass1(r100));     // Catch: Exception -> L13
    L15:
        return r100;
    L13:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCommonRecommendInfo#getProtocolList", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCommonRecommendInfo#getProtocolList", e);
        goto L15
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r102 = false;
        goto L9
    }

    public final ArrayList<CJPayUIComponent> getTitleList() {
        final ArrayList<CJPayUIComponent> r100 = new ArrayList();
        KtSafeMethodExtensionKt.forEach(new JSONArray(this.title), new C93611(r100));     // Catch: Exception -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCommonRecommendInfo#getTitleList", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCommonRecommendInfo#getTitleList", e);
        goto L7
    }

    public final Map<String, List<String>> parseShowRules() {
        LinkedHashMap r100 = new LinkedHashMap();
        JSONObject r101 = new JSONObject(this.show_rules);     // Catch: Exception -> L13
        Iterator<String> r102 = r101.keys();     // Catch: Exception -> L13
    L4:
        if (r102.hasNext() == false) goto L15;
        String r103 = r102.next();     // Catch: Exception -> L13
        JSONArray r104 = r101.optJSONArray(r103);     // Catch: Exception -> L13
        if (r104 == null) goto L4;
        ArrayList r105 = new ArrayList();     // Catch: Exception -> L13
        int r106 = r104.length();     // Catch: Exception -> L13
        int r107 = 0;
    L9:
        if (r107 >= r106) goto L11;
        r105.add(JSONArrayProtectorUtils.getString(r104, r107));     // Catch: Exception -> L13
        r107 = r107 + 1;     // Catch: Exception -> L13
        goto L9
    L11:
        r100.put(r103, r105);     // Catch: Exception -> L13
    L15:
        return r100;
    L13:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCommonRecommendInfo#parseShowRules", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCommonRecommendInfo#parseShowRules", e);
        goto L15
    }

    public CommonRecommendExt() {
        this.recommend_label = "";
        this.sub_title = "";
        this.choose = "0";
        this.show_rules = "";
        this.icon_info = new IconInfo();
    }

    public final HashMap<String, String> getJsonStringToHashMap(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == true) goto L10;
        Map<String, String> r102 = KtSafeMethodExtensionKt.toMap(new JSONObject(r100));     // Catch: Exception -> L18
        if ((r102 instanceof HashMap) == false) goto L14;
        HashMap<String, String> r103 = (HashMap) r102;     // Catch: Exception -> L18
    L15:
        if (r103 != null) goto L23;
        return new HashMap();
    L23:
        return r103;
    L14:
        r103 = null;
    L18:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayCommonRecommendInfo#getJsonStringToHashMap", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayCommonRecommendInfo#getJsonStringToHashMap", e);
        return new HashMap();
    L10:
        return new HashMap();
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L8
    }
}
