package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.data.req;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.integrated.counter.data.PromotionProcessInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010R\u001a\u0010&\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u000e\"\u0004\b(\u0010\u0010R\u001a\u0010)\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u000e\"\u0004\b+\u0010\u0010R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u000e\"\u0004\b4\u0010\u0010R\u001a\u00105\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u000e\"\u0004\b7\u0010\u0010R\u001a\u00108\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u000e\"\u0004\b:\u0010\u0010¨\u0006;"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/data/req/CJUnifyPayPTCodeInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "asset_meta_info_list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetMetaInfoBean;", "Lkotlin/collections/ArrayList;", "getAsset_meta_info_list", "()Ljava/util/ArrayList;", "setAsset_meta_info_list", "(Ljava/util/ArrayList;)V", "bank_card_id", "", "getBank_card_id", "()Ljava/lang/String;", "setBank_card_id", "(Ljava/lang/String;)V", "business_scene", "getBusiness_scene", "setBusiness_scene", "combine_type", "getCombine_type", "setCombine_type", "credit_pay_installment", "getCredit_pay_installment", "setCredit_pay_installment", "ext_param", "getExt_param", "setExt_param", "jh_confirm_exts", "Lorg/json/JSONObject;", "getJh_confirm_exts", "()Lorg/json/JSONObject;", "setJh_confirm_exts", "(Lorg/json/JSONObject;)V", "jh_sign_token", "getJh_sign_token", "setJh_sign_token", "lynx_ext_param", "getLynx_ext_param", "setLynx_ext_param", "primary_pay_type", "getPrimary_pay_type", "setPrimary_pay_type", "promotion_process", "Lcom/android/ttcjpaysdk/integrated/counter/data/PromotionProcessInfo;", "getPromotion_process", "()Lcom/android/ttcjpaysdk/integrated/counter/data/PromotionProcessInfo;", "setPromotion_process", "(Lcom/android/ttcjpaysdk/integrated/counter/data/PromotionProcessInfo;)V", "share_asset_code", "getShare_asset_code", "setShare_asset_code", "share_asset_id", "getShare_asset_id", "setShare_asset_id", "sub_ext", "getSub_ext", "setSub_ext", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPayPTCodeInfo implements CJPayObject {
    private ArrayList<AssetInfoBean.AssetMetaInfoBean> asset_meta_info_list;
    private String bank_card_id;
    private String business_scene;
    private String combine_type;
    private String credit_pay_installment;
    private String ext_param;
    private JSONObject jh_confirm_exts;
    private String jh_sign_token;
    private String lynx_ext_param;
    private String primary_pay_type;
    private PromotionProcessInfo promotion_process;
    private String share_asset_code;
    private String share_asset_id;
    private String sub_ext;

    public CJUnifyPayPTCodeInfo() {
        this.bank_card_id = "";
        this.business_scene = "";
        this.combine_type = "";
        this.credit_pay_installment = "";
        this.ext_param = "";
        this.lynx_ext_param = "";
        this.sub_ext = "";
        this.primary_pay_type = "";
        this.share_asset_code = "";
        this.share_asset_id = "";
        this.asset_meta_info_list = new ArrayList();
        this.jh_sign_token = "";
    }

    public final ArrayList<AssetInfoBean.AssetMetaInfoBean> getAsset_meta_info_list() {
        return this.asset_meta_info_list;
    }

    public final String getBank_card_id() {
        return this.bank_card_id;
    }

    public final String getBusiness_scene() {
        return this.business_scene;
    }

    public final String getCombine_type() {
        return this.combine_type;
    }

    public final String getCredit_pay_installment() {
        return this.credit_pay_installment;
    }

    public final String getExt_param() {
        return this.ext_param;
    }

    public final JSONObject getJh_confirm_exts() {
        return this.jh_confirm_exts;
    }

    public final String getJh_sign_token() {
        return this.jh_sign_token;
    }

    public final String getLynx_ext_param() {
        return this.lynx_ext_param;
    }

    public final String getPrimary_pay_type() {
        return this.primary_pay_type;
    }

    public final PromotionProcessInfo getPromotion_process() {
        return this.promotion_process;
    }

    public final String getShare_asset_code() {
        return this.share_asset_code;
    }

    public final String getShare_asset_id() {
        return this.share_asset_id;
    }

    public final String getSub_ext() {
        return this.sub_ext;
    }

    public final void setAsset_meta_info_list(ArrayList<AssetInfoBean.AssetMetaInfoBean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.asset_meta_info_list = r100;
    }

    public final void setBank_card_id(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bank_card_id = r100;
    }

    public final void setBusiness_scene(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.business_scene = r100;
    }

    public final void setCombine_type(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.combine_type = r100;
    }

    public final void setCredit_pay_installment(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.credit_pay_installment = r100;
    }

    public final void setExt_param(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ext_param = r100;
    }

    public final void setJh_confirm_exts(JSONObject r100) {
        this.jh_confirm_exts = r100;
    }

    public final void setJh_sign_token(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.jh_sign_token = r100;
    }

    public final void setLynx_ext_param(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lynx_ext_param = r100;
    }

    public final void setPrimary_pay_type(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.primary_pay_type = r100;
    }

    public final void setPromotion_process(PromotionProcessInfo r100) {
        this.promotion_process = r100;
    }

    public final void setShare_asset_code(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.share_asset_code = r100;
    }

    public final void setShare_asset_id(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.share_asset_id = r100;
    }

    public final void setSub_ext(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.sub_ext = r100;
    }
}
