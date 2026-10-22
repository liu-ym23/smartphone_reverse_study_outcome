package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u000f\u001a\u00020\u0010R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCommonRecommendInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "recommend_desc", "", "recommend_ext", "Lcom/android/ttcjpaysdk/thirdparty/data/CommonRecommendExt;", "recommend_ext_pb", "", "getRecommend_ext_pb", "()Ljava/util/Map;", "setRecommend_ext_pb", "(Ljava/util/Map;)V", a.KEY_RECOMMEND_TYPE, "afterProtoDecode", "", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayCommonRecommendInfo implements CJPayObject, Serializable {
    public String recommend_desc;
    public CommonRecommendExt recommend_ext;
    private Map<String, String> recommend_ext_pb;
    public String recommend_type;

    public final void afterProtoDecode() {
        Map<String, String> r100 = this.recommend_ext_pb;
        if (r100 == null) goto L33;
        CommonRecommendExt r101 = new CommonRecommendExt();
        String r102 = r100.get("recommend_label");
        String r103 = "";
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        r101.recommend_label = r102;
        r101.title = r100.get("title");
        String r104 = r100.get(BdpAppEventConstant.PARAMS_SUB_TITLE);
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        r101.sub_title = r104;
        String r105 = r100.get("choose");
        if (r105 != null) goto L13;
        r105 = "0";
    L13:
        r101.choose = r105;
        String r106 = r100.get("show_rules");
        if (r106 == null) goto L17;
        r103 = r106;
    L17:
        r101.show_rules = r103;
        r101.protocol_group_names_map_by_fund_bill_index = r100.get("protocol_group_names_map_by_fund_bill_index");
        r101.protocol_list_map_by_fund_bill_index = r100.get("protocol_list_map_by_fund_bill_index");
        r101.protocol_group_names = r100.get("protocol_group_names");
        r101.protocol_list = r100.get("protocol_list");
        String r107 = r100.get("specific_agreement_first_deduct_meta_info");
        if (r107 != null) goto L20;
    L25:
        AssetInfoBean.AssetMetaInfoBean r108 = null;
    L26:
        r101.specific_agreement_first_deduct_meta_info = r108;
        String r109 = r100.get("icon_info");
        if (r109 == null) goto L29;
        IconInfo r110 = (IconInfo) CJPayJsonParser.fromJson(r109, IconInfo.class);
    L30:
        if (r110 != null) goto L32;
        r110 = new IconInfo();
    L32:
        r101.icon_info = r110;
    L34:
        this.recommend_ext = r101;
        this.recommend_ext_pb = null;
        return;
    L29:
        r110 = null;
        goto L30
    L20:
        if (Boolean.valueOf(!StringsKt.isBlank(r107)).booleanValue() == true) goto L23;
        r107 = null;
    L23:
        if (r107 == null) goto L25;
        r108 = (AssetInfoBean.AssetMetaInfoBean) CJPayJsonParser.fromJson(r107, AssetInfoBean.AssetMetaInfoBean.class);
        goto L26
    L33:
        r101 = new CommonRecommendExt();
        goto L34
    }

    public CJPayCommonRecommendInfo() {
        this.recommend_type = "";
        this.recommend_desc = "";
        this.recommend_ext = new CommonRecommendExt();
    }

    public final Map<String, String> getRecommend_ext_pb() {
        return this.recommend_ext_pb;
    }

    public final void setRecommend_ext_pb(Map<String, String> r100) {
        this.recommend_ext_pb = r100;
    }
}
