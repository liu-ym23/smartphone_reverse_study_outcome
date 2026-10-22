package com.android.ttcjpaysdk.thirdparty.data.unifypay;

import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayCircularCarouselRegionConfig;
import com.android.ttcjpaysdk.base.ui.data.CJPayForgetPwdBtnInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayForgetPwdBtnInfoV2;
import com.android.ttcjpaysdk.base.ui.data.CJPayPayInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayTopRightBtnInfo;
import com.android.ttcjpaysdk.base.ui.data.PayNewCardReconfirmInfo;
import com.android.ttcjpaysdk.base.ui.data.PrePayDoubleConfirmInfo;
import com.android.ttcjpaysdk.base.ui.data.RetainInfo;
import com.android.ttcjpaysdk.integrated.counter.data.ProcessInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayBioOpenAndPayInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCommonRecommendInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayMerchantInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayMerchantInfo2;
import com.android.ttcjpaysdk.thirdparty.data.CJPayPayAndXShowParams;
import com.android.ttcjpaysdk.thirdparty.data.CJPayRecommendPopup;
import com.android.ttcjpaysdk.thirdparty.data.CJPayResultPageShowConf;
import com.android.ttcjpaysdk.thirdparty.data.CJPayTradeInfo;
import com.android.ttcjpaysdk.thirdparty.data.CJPayUserInfo;
import com.android.ttcjpaysdk.thirdparty.data.CheckoutCounterCashDeskShowConf;
import com.android.ttcjpaysdk.thirdparty.data.LoadingStyleInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0005[\\]^_B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010Y\u001a\u00020ZR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R(\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010&\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010'\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0014\u0010/\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00100\u001a\u0002018\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00102\u001a\u0002038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u000409j\b\u0012\u0004\u0012\u00020\u0004`:8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010;\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010<\u001a\u0004\u0018\u00010=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0014\u0010B\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010D\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010F\u001a\u00020G8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010H\u001a\u00020I8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010J\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010K\u001a\u00020L8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010M\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010N\u001a\u0004\u0018\u00010O8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010P\u001a\u0004\u0018\u00010Q8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010R\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010S\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010U\u001a\u00020V8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010W\u001a\u0004\u0018\u00010X8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "asset_info", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "auto_confirm_pay", "", "back_top_right_btn_info", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayTopRightBtnInfo;", "bio_open_and_pay_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayBioOpenAndPayInfo;", "cashdesk_show_conf", "Lcom/android/ttcjpaysdk/thirdparty/data/CheckoutCounterCashDeskShowConf;", "circular_carousel_region", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayCircularCarouselRegionConfig;", "collected_asset_ext_map", "Lorg/json/JSONObject;", "collected_asset_ext_map_pb", "Ljava/util/HashMap;", "getCollected_asset_ext_map_pb", "()Ljava/util/HashMap;", "setCollected_asset_ext_map_pb", "(Ljava/util/HashMap;)V", "common_recommend_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCommonRecommendInfo;", "ext_info", "ext_info_pb", "getExt_info_pb", "setExt_info_pb", "ext_param", "forget_pwd_btn_info", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayForgetPwdBtnInfo;", "forget_pwd_btn_info_pb", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayForgetPwdBtnInfoV2;", "getForget_pwd_btn_info_pb", "()Lcom/android/ttcjpaysdk/base/ui/data/CJPayForgetPwdBtnInfoV2;", "setForget_pwd_btn_info_pb", "(Lcom/android/ttcjpaysdk/base/ui/data/CJPayForgetPwdBtnInfoV2;)V", "initial_show_style", "merchant_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayMerchantInfo;", "merchant_info_v2", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayMerchantInfo2;", "getMerchant_info_v2", "()Lcom/android/ttcjpaysdk/thirdparty/data/CJPayMerchantInfo2;", "setMerchant_info_v2", "(Lcom/android/ttcjpaysdk/thirdparty/data/CJPayMerchantInfo2;)V", "next_page", "pay_again_display_info", "Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo$UnifyPayAgainDisplayInfo;", "pay_and_x_show_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayPayAndXShowParams;", "pay_new_card_reconfirm_info", "Lcom/android/ttcjpaysdk/base/ui/data/PayNewCardReconfirmInfo;", "pre_pay_double_confirm_info", "Lcom/android/ttcjpaysdk/base/ui/data/PrePayDoubleConfirmInfo;", "priority_pay_list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "process_info", "process_info_pb", "Lcom/android/ttcjpaysdk/integrated/counter/data/ProcessInfo;", "getProcess_info_pb", "()Lcom/android/ttcjpaysdk/integrated/counter/data/ProcessInfo;", "setProcess_info_pb", "(Lcom/android/ttcjpaysdk/integrated/counter/data/ProcessInfo;)V", "recommend_asset", "Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo$UnifyPayRecommendAsset;", "recommend_popup", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayRecommendPopup;", "result_page_show_conf", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayResultPageShowConf;", "retain_info", "Lcom/android/ttcjpaysdk/base/ui/data/RetainInfo;", "retain_info_v2", "sdk_show_info", "Lcom/android/ttcjpaysdk/thirdparty/data/LoadingStyleInfo;", "smart_info", "standard_verify_info", "Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo$StandardVerifyInfo;", "toast_info", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo$ToastInfo;", "top_right_btn_info", "trade_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayTradeInfo;", "user_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayUserInfo;", "verify_desc_region_info", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo$VerifyDescRegionInfo;", "afterProtoDecode", "", "MemberVerifyInfo", "StandardVerifyInfo", "StandardVerifyItem", "UnifyPayAgainDisplayInfo", "UnifyPayRecommendAsset", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnifyCashierRenderInfo implements CJPayObject {
    public AssetInfoBean asset_info;
    public String auto_confirm_pay;
    public CJPayTopRightBtnInfo back_top_right_btn_info;
    public CJPayBioOpenAndPayInfo bio_open_and_pay_info;
    public CheckoutCounterCashDeskShowConf cashdesk_show_conf;
    public CJPayCircularCarouselRegionConfig circular_carousel_region;
    public JSONObject collected_asset_ext_map;
    private HashMap<String, String> collected_asset_ext_map_pb;
    public CJPayCommonRecommendInfo common_recommend_info;
    public JSONObject ext_info;
    private HashMap<String, String> ext_info_pb;
    public String ext_param;
    public CJPayForgetPwdBtnInfo forget_pwd_btn_info;
    private CJPayForgetPwdBtnInfoV2 forget_pwd_btn_info_pb;
    public String initial_show_style;
    public CJPayMerchantInfo merchant_info;
    private CJPayMerchantInfo2 merchant_info_v2;
    public String next_page;
    public UnifyPayAgainDisplayInfo pay_again_display_info;
    public CJPayPayAndXShowParams pay_and_x_show_info;
    public PayNewCardReconfirmInfo pay_new_card_reconfirm_info;
    public PrePayDoubleConfirmInfo pre_pay_double_confirm_info;
    public ArrayList<AssetInfoBean> priority_pay_list;
    public JSONObject process_info;
    private ProcessInfo process_info_pb;
    public UnifyPayRecommendAsset recommend_asset;
    public CJPayRecommendPopup recommend_popup;
    public CJPayResultPageShowConf result_page_show_conf;
    public RetainInfo retain_info;
    public JSONObject retain_info_v2;
    public LoadingStyleInfo sdk_show_info;
    public HashMap<String, String> smart_info;
    public StandardVerifyInfo standard_verify_info;
    public CJPayPayInfo.ToastInfo toast_info;
    public CJPayTopRightBtnInfo top_right_btn_info;
    public CJPayTradeInfo trade_info;
    public CJPayUserInfo user_info;
    public CJPayPayInfo.VerifyDescRegionInfo verify_desc_region_info;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo$MemberVerifyInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "schema", "", "verify_id", "verify_token", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class MemberVerifyInfo implements CJPayObject {
        public String schema;
        public String verify_id;
        public String verify_token;

        public MemberVerifyInfo() {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u0004\u0018\u00010\nJ\u0012\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo$StandardVerifyInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "cashdesk_verify_id", "", "default_verify_item_id", "exts", "Ljava/util/HashMap;", "standard_verify_item_list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo$StandardVerifyItem;", "Lkotlin/collections/ArrayList;", "getCarrierVerifyItem", "getVerifyItem", "action", "Companion", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class StandardVerifyInfo implements CJPayObject {
        public static final String ACTION_CARRIER = "on_sim_mobile_verify";
        public static final Companion Companion = null;
        public String cashdesk_verify_id;
        public String default_verify_item_id;
        public HashMap<String, String> exts;
        public ArrayList<StandardVerifyItem> standard_verify_item_list;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo$StandardVerifyInfo$Companion;", "", "()V", "ACTION_CARRIER", "", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public final StandardVerifyItem getCarrierVerifyItem() {
            return getVerifyItem(ACTION_CARRIER);
        }

        public StandardVerifyInfo() {
            this.standard_verify_item_list = new ArrayList();
        }

        public final StandardVerifyItem getVerifyItem(String r100) {
            Object r101 = null;
            if (r100 != null) goto L5;
            return null;
        L5:
            if ((!StringsKt.isBlank(r100)) == true) goto L8;
            r100 = null;
        L8:
            if (r100 == null) goto L22;
            Iterator<T> r102 = this.standard_verify_item_list.iterator();
        L12:
            if (r102.hasNext() == false) goto L17;
            Object r103 = r102.next();
            if (Intrinsics.areEqual(((StandardVerifyItem) r103).action, r100) == false) goto L12;
            r101 = r103;
        L17:
            return (StandardVerifyItem) r101;
        L22:
            return null;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo$StandardVerifyItem;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "action", "", "exts", "Ljava/util/HashMap;", "member_verify_info", "Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo$MemberVerifyInfo;", "verify_item_id", "verify_type", "VerifyTypeNum", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class StandardVerifyItem implements CJPayObject {
        public String action;
        public HashMap<String, String> exts;
        public MemberVerifyInfo member_verify_info;
        public String verify_item_id;
        public String verify_type;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo$StandardVerifyItem$VerifyTypeNum;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "VOICE_TYPE", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final enum VerifyTypeNum extends Enum<VerifyTypeNum> {
            private static final /* synthetic */ VerifyTypeNum[] $VALUES = null;
            public static final VerifyTypeNum VOICE_TYPE = null;
            private final String value;

            private static final /* synthetic */ VerifyTypeNum[] $values() {
                return new VerifyTypeNum[]{VOICE_TYPE};
            }

            public static VerifyTypeNum valueOf(String r100) {
                return (VerifyTypeNum) a.a(VerifyTypeNum.class, r100);
            }

            public static VerifyTypeNum[] values() {
                return (VerifyTypeNum[]) $VALUES.clone();
            }

            static {
                VOICE_TYPE = new VerifyTypeNum("VOICE_TYPE", 0, "voice");
                $VALUES = $values();
            }

            public final String getValue() {
                return this.value;
            }

            private VerifyTypeNum(String r100, int r101, String r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        public StandardVerifyItem() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo$UnifyPayAgainDisplayInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", DownloadSettingKeys.AhPlans.KEY_SHOW_TIPS, "", "tips", "tips_url", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class UnifyPayAgainDisplayInfo implements CJPayObject {
        public String show_tips;
        public String tips;
        public String tips_url;

        public UnifyPayAgainDisplayInfo() {
            this.tips = "";
            this.tips_url = "";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/unifypay/UnifyCashierRenderInfo$UnifyPayRecommendAsset;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "asset_meta_info", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetMetaInfoBean;", "button_label", "", "change_limit_asset_list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "label", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class UnifyPayRecommendAsset implements CJPayObject {
        public AssetInfoBean.AssetMetaInfoBean asset_meta_info;
        public String button_label;
        public ArrayList<AssetInfoBean.AssetMetaInfoBean> change_limit_asset_list;
        public String label;

        public UnifyPayRecommendAsset() {
            this.label = "";
            this.button_label = "";
            this.change_limit_asset_list = new ArrayList();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UnifyCashierRenderInfo() {
        this.top_right_btn_info = new CJPayTopRightBtnInfo();
        this.back_top_right_btn_info = new CJPayTopRightBtnInfo();
        this.cashdesk_show_conf = new CheckoutCounterCashDeskShowConf();
        String r100 = null;
        String r101 = null;
        String r102 = null;
        String r103 = null;
        this.forget_pwd_btn_info = new CJPayForgetPwdBtnInfo(r100, r101, r102, r103, null, 31, null);
        this.sdk_show_info = new LoadingStyleInfo();
        Object[] r104 = 0 == true ? 1 : 0;
        this.retain_info = new RetainInfo(r100, r101, r102, r103, false, null, r104, null, false, null, null, null, null, null, false, null, null, 131071, null);
        this.initial_show_style = "";
        this.process_info = new JSONObject();
        this.user_info = new CJPayUserInfo();
        this.merchant_info = new CJPayMerchantInfo();
        this.pay_again_display_info = new UnifyPayAgainDisplayInfo();
        this.collected_asset_ext_map = new JSONObject();
        this.ext_param = "";
        this.ext_info = new JSONObject();
        this.trade_info = new CJPayTradeInfo();
        this.bio_open_and_pay_info = new CJPayBioOpenAndPayInfo();
        this.pay_and_x_show_info = new CJPayPayAndXShowParams();
        this.circular_carousel_region = new CJPayCircularCarouselRegionConfig();
        this.auto_confirm_pay = "";
        this.result_page_show_conf = new CJPayResultPageShowConf();
        this.priority_pay_list = new ArrayList();
    }

    public final void afterProtoDecode() {
        CJPayForgetPwdBtnInfoV2 r100 = this.forget_pwd_btn_info_pb;
        if (r100 == null) goto L5;
        CJPayForgetPwdBtnInfo r101 = this.forget_pwd_btn_info;
        r101.icon_url = r100.icon_url;
        r101.action = r100.action;
        r101.schema = r100.schema;
        r101.lynx_schema = r100.lynx_schema;
        r101.originalJson = CJPayJsonParser.toJsonObject(r100);
    L5:
        ProcessInfo r102 = this.process_info_pb;
        if (r102 == null) goto L8;
        this.process_info = r102.toJson();
    L8:
        CJPayMerchantInfo2 r103 = this.merchant_info_v2;
        if (r103 == null) goto L11;
        this.merchant_info = r103.toOriMerchantInfo();
    L11:
        HashMap<String, String> r104 = this.collected_asset_ext_map_pb;
        if (r104 == null) goto L14;
        this.collected_asset_ext_map = new JSONObject(r104);
    L14:
        HashMap<String, String> r105 = this.ext_info_pb;
        if (r105 == null) goto L17;
        this.ext_info = new JSONObject(r105);
    L17:
        this.forget_pwd_btn_info_pb = null;
        this.process_info_pb = null;
        this.merchant_info_v2 = null;
        this.collected_asset_ext_map_pb = null;
        this.ext_info_pb = null;
    }

    public final HashMap<String, String> getCollected_asset_ext_map_pb() {
        return this.collected_asset_ext_map_pb;
    }

    public final HashMap<String, String> getExt_info_pb() {
        return this.ext_info_pb;
    }

    public final CJPayForgetPwdBtnInfoV2 getForget_pwd_btn_info_pb() {
        return this.forget_pwd_btn_info_pb;
    }

    public final CJPayMerchantInfo2 getMerchant_info_v2() {
        return this.merchant_info_v2;
    }

    public final ProcessInfo getProcess_info_pb() {
        return this.process_info_pb;
    }

    public final void setCollected_asset_ext_map_pb(HashMap<String, String> r100) {
        this.collected_asset_ext_map_pb = r100;
    }

    public final void setExt_info_pb(HashMap<String, String> r100) {
        this.ext_info_pb = r100;
    }

    public final void setForget_pwd_btn_info_pb(CJPayForgetPwdBtnInfoV2 r100) {
        this.forget_pwd_btn_info_pb = r100;
    }

    public final void setMerchant_info_v2(CJPayMerchantInfo2 r100) {
        this.merchant_info_v2 = r100;
    }

    public final void setProcess_info_pb(ProcessInfo r100) {
        this.process_info_pb = r100;
    }
}
