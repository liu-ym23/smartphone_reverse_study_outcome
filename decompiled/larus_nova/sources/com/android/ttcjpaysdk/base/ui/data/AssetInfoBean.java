package com.android.ttcjpaysdk.base.ui.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.json.CJPayObjectExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJStringExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.ui.component.dialog.bean.CJPayAgreementBean;
import com.android.ttcjpaysdk.base.ui.component.tag.CJVoucherTagBean;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.bdpay.paymentmethod.ShareData;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b9\u0018\u0000 b2\u00020\u00012\u00020\u0002:!XYZ[\\]^_`abcdefghijklmnopqrstuvwxB\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u0000J\u0006\u0010\u001e\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u001cJ\u0006\u0010 \u001a\u00020\u0000J\u0006\u0010!\u001a\u00020\u0012J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00002\b\u0010#\u001a\u0004\u0018\u00010\u0012J\b\u0010$\u001a\u0004\u0018\u00010%J\u0017\u0010&\u001a\u0004\u0018\u00010\u00002\b\u0010'\u001a\u0004\u0018\u00010(¢\u0006\u0002\u0010)J\u0006\u0010*\u001a\u00020\u0012J\b\u0010+\u001a\u0004\u0018\u00010\u0000J\b\u0010,\u001a\u0004\u0018\u00010\u0012J\b\u0010-\u001a\u0004\u0018\u00010\u0000J\u0006\u0010.\u001a\u00020\u0012J\u0006\u0010/\u001a\u00020(J\u0006\u00100\u001a\u00020\u0012J\u0006\u00101\u001a\u00020\u0012J\u0006\u00102\u001a\u00020\u0012J\u0006\u00103\u001a\u00020\u0012J\u0006\u00104\u001a\u00020\u0012J\u001e\u00105\u001a\u0012\u0012\u0004\u0012\u0002060\u0019j\b\u0012\u0004\u0012\u000206`\u001a2\u0006\u00107\u001a\u00020\u0012J\u0006\u00108\u001a\u00020\u0000J\u0006\u00109\u001a\u00020\u0012J\u001a\u0010:\u001a\u0016\u0012\u0004\u0012\u00020;\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020;\u0018\u0001`\u001aJ\u0006\u0010<\u001a\u00020\u0012J\u0016\u0010=\u001a\u0012\u0012\u0004\u0012\u00020>0\u0019j\b\u0012\u0004\u0012\u00020>`\u001aJ\u0006\u0010?\u001a\u00020@J\u0006\u0010A\u001a\u00020@J\u0006\u0010B\u001a\u00020@J\u0006\u0010C\u001a\u00020@J\u0006\u0010D\u001a\u00020@J\u0006\u0010E\u001a\u00020@J\u0006\u0010F\u001a\u00020@J\u0006\u0010G\u001a\u00020@J\u0006\u0010H\u001a\u00020@J\u0006\u0010I\u001a\u00020@J\u0006\u0010J\u001a\u00020@J\u0006\u0010K\u001a\u00020@J\u0006\u0010L\u001a\u00020@J\u0006\u0010M\u001a\u00020@J\u0006\u0010N\u001a\u00020@J\b\u0010O\u001a\u00020@H\u0002J\u0010\u0010P\u001a\u00020@2\b\u0010Q\u001a\u0004\u0018\u00010\u0000J\u0006\u0010R\u001a\u00020\u0012J\u0006\u0010S\u001a\u00020\u0012J\u0006\u0010T\u001a\u00020@J\u0016\u0010U\u001a\u0012\u0012\u0004\u0012\u00020\u00000\u0019j\b\u0012\u0004\u0012\u00020\u0000`\u001aJ\u000e\u0010V\u001a\u00020\u001c2\u0006\u0010W\u001a\u00020\u0012R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R:\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00000\u0019j\b\u0012\u0004\u0012\u00020\u0000`\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006y"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "asset_basic_show_info", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetBasicShowInfoBean;", "asset_combine_pay_info", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetCombinePayInfoBean;", "asset_extension_show_info", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetExtensionShowInfo;", "asset_meta_info", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetMetaInfoBean;", "asset_primary_show_info", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetPrimaryShowInfoBean;", "ext_info", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$ExtInfo;", "ext_info_pb", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getExt_info_pb", "()Ljava/util/HashMap;", "setExt_info_pb", "(Ljava/util/HashMap;)V", "sub_asset_info_list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "afterProtoDecode", "", "clearCombineList", "clearStandardRecAmount", "clearStandardRecDesc", "cp", "defaultUniID", "findAssetInfo", "uniqueSymbol", "findDefaultCombineInfo", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetToCombineAssetInfoBean;", "findSubAssetInfo", "index", "", "(Ljava/lang/Integer;)Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "getAssetType", "getChoosedSubAssetInfo", "getCombineSelectPageTitle", "getDefaultChosenSubAssetInfo", "getFunctionGuideMaterialKey", "getIndex", "getOptionMktAssetDefaultStatues", "getOptionMktAssetSignStatues", "getOptionMktAssetType", "getPaymentSelectionMaterialKey", "getPromotionScene", "getProtocolJsonListByGroup", "Lorg/json/JSONObject;", "groupName", "getSelectedAsset", "getSubTitle", "getTipsMsgInfo", "Lcom/android/ttcjpaysdk/base/ui/data/UIComponent;", "getTitle", "groupInfoList", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetSelectPageGroupInfoBean;", "isBindCardPay", "", "isDirectBank", "isEnable", "isForeignCard", "isFunctionGuideChecked", "isHasJumpInfo", "isLimitAsset", "isNeedCombine", "isNeedJump", "isNeedJumpCombinePay", "isPaymentSelectionChecked", "isRealDirectBank", "isShowFunctionGuide", "isShowPaymentSelectionMaterial", "isThirdPayment", "isValidCombineAssetInfo", "match", "other", "parseStandardRecAmount", "parseStandardRecDesc", "showMoreDiscount", "subPayTypeInfoList", "updatePromotionScene", "promotionScene", "AssetBasicShowInfoBean", "AssetCombinePayInfoBean", "AssetExtensionShowInfo", "AssetHomePageBanner", "AssetHomePageGroupInfo", "AssetMetaInfoBean", "AssetPrimaryShowInfoBean", "AssetSelectPageGroupInfoBean", "AssetToCombineAssetInfoBean", "CardStyleShowInfo", "Companion", "ExtInfo", "FoldStyleDisplayInfo", "FunctionGuidanceMaterial", "GroupEnhanceInfo", "GroupEnhanceJumpInfo", "GroupInfoLabel", "HomePageGuideInfo", "HomePageVoucher", "PaymentSelectionMaterial", "PromotionSceneMapping", "PromotionShowPriority", "SelectPageShowInfoBean", "SubGroupInfoBean", "TipMsgInfoItem", "VoucherLabel", "VoucherMsgBean", "VoucherMsgInfo", "VoucherMsgInfoBeanList", "VoucherRetainInfoMap", "VoucherTagBean", "VoucherTagBeanList", "YfFeeComplianceShowInfo", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AssetInfoBean implements CJPayObject, Serializable {
    public static final String CJ_PAY_DEFAULT_KEY = "default";
    public static final String CJ_PAY_RETAIN_KEY = "retain";
    public static final Companion Companion = null;
    public AssetBasicShowInfoBean asset_basic_show_info;
    public AssetCombinePayInfoBean asset_combine_pay_info;
    public AssetExtensionShowInfo asset_extension_show_info;
    public AssetMetaInfoBean asset_meta_info;
    public AssetPrimaryShowInfoBean asset_primary_show_info;
    public ExtInfo ext_info;
    private HashMap<String, String> ext_info_pb;
    public ArrayList<AssetInfoBean> sub_asset_info_list;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u001a\u001a\u00020\u0007R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0012j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0012j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetBasicShowInfoBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "choose", "", "desc_title", "", "icon_url", "index", "", "over_all_sub_title", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayUIComponent;", "Lkotlin/collections/ArrayList;", "partition_asset_title", "primary_category", "scene_sub_title_map", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "scene_title_map", "status", "sub_desc_title", BdpAppEventConstant.PARAMS_SUB_TITLE, "sub_title_color", "title", "subPayType", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AssetBasicShowInfoBean implements CJPayObject, Serializable {
        public boolean choose;
        public String desc_title;
        public String icon_url;
        public int index;
        public ArrayList<CJPayUIComponent> over_all_sub_title;
        public String partition_asset_title;
        public String primary_category;
        public HashMap<String, String> scene_sub_title_map;
        public HashMap<String, String> scene_title_map;
        public String status;
        public String sub_desc_title;
        public String sub_title;
        public String sub_title_color;
        public String title;

        public final String subPayType() {
            return "";
        }

        public AssetBasicShowInfoBean() {
            this.index = -1;
            this.status = "";
            this.icon_url = "";
            this.title = "";
            this.sub_title = "";
            this.over_all_sub_title = new ArrayList();
            this.desc_title = "";
            this.sub_desc_title = "";
            this.sub_title_color = "";
            this.scene_title_map = new HashMap();
            this.scene_sub_title_map = new HashMap();
            this.partition_asset_title = "";
            this.primary_category = "";
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fR\"\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetCombinePayInfoBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "asset_to_combine_asset_info_list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetToCombineAssetInfoBean;", "Lkotlin/collections/ArrayList;", "combine_fund_type", "", "default_combine_asset_index", "", "select_page_title", "top_right_button_text", "isChoice", "", "isLimit", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AssetCombinePayInfoBean implements CJPayObject, Serializable {
        public ArrayList<AssetToCombineAssetInfoBean> asset_to_combine_asset_info_list;
        public String combine_fund_type;
        public int default_combine_asset_index;
        public String select_page_title;
        public String top_right_button_text;

        public final boolean isChoice() {
            return Intrinsics.areEqual("choice", this.combine_fund_type);
        }

        public final boolean isLimit() {
            return Intrinsics.areEqual(VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, this.combine_fund_type);
        }

        public AssetCombinePayInfoBean() {
            this.asset_to_combine_asset_info_list = new ArrayList();
            this.combine_fund_type = "";
            this.select_page_title = "";
            this.default_combine_asset_index = -1;
            this.top_right_button_text = "";
        }
    }

    @Metadata(d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010]\u001a\u00020^R\"\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R:\u0010\f\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\rj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\rj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R:\u0010$\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020%\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020%\u0018\u0001`\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013R\u0012\u0010(\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010-\u001a\u0012\u0012\u0004\u0012\u00020.0\u0005j\b\u0012\u0004\u0012\u00020.`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010/\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00100\u001a\u0002018\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00102\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00103\u001a\u0002048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u00105\u001a\u0012\u0012\u0004\u0012\u0002060\u0005j\b\u0012\u0004\u0012\u000206`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R2\u00107\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u0001`\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R:\u00108\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u000209\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u000209\u0018\u0001`\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0011\"\u0004\b;\u0010\u0013R\u0012\u0010<\u001a\u00020=8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010>\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\u0004\u0018\u00010@8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010A\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010B\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\rj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010C\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010D\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\rj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010E\u001a\u0012\u0012\u0004\u0012\u00020F0\u0005j\b\u0012\u0004\u0012\u00020F`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010G\u001a\u00020H8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010I\u001a\u00020J8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010K\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010L\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\rj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R:\u0010M\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020N\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020N\u0018\u0001`\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0011\"\u0004\bP\u0010\u0013R\u0012\u0010Q\u001a\u00020R8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R:\u0010S\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020T\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020T\u0018\u0001`\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0011\"\u0004\bV\u0010\u0013R\u0014\u0010W\u001a\u0004\u0018\u00010X8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R:\u0010Y\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020Z\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020Z\u0018\u0001`\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0011\"\u0004\b\\\u0010\u0013¨\u0006_"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetExtensionShowInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "amount_area_list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo$AmountAreaInfo;", "Lkotlin/collections/ArrayList;", "background", "", "bubble_info_map", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayBubbleInfo;", "bubble_info_map_pb", "Ljava/util/HashMap;", "Lcom/android/ttcjpaysdk/base/ui/data/ButtonInfoLabel;", "Lkotlin/collections/HashMap;", "getBubble_info_map_pb", "()Ljava/util/HashMap;", "setBubble_info_map_pb", "(Ljava/util/HashMap;)V", "complete_title", "crossed_price", "crossed_price_map", "default_expand_confirm_btn_label", "ext_show_info", "fold_voucher_info", "Lcom/android/ttcjpaysdk/base/ui/data/FrontPayTypeData$HomePageFoldVoucherInfo;", "function_guidance_material", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$FunctionGuidanceMaterial;", "hit_tips_sub_type", "icon_tips", "Lcom/android/ttcjpaysdk/base/ui/data/IconTips;", "jump_info", "Lcom/android/ttcjpaysdk/base/ui/data/JumpInfoBean;", "loading_show_info_map", "Lcom/android/ttcjpaysdk/base/ui/data/CJPaySecurityLoadingStyleInfo;", "loading_show_info_map_pb", "Lcom/android/ttcjpaysdk/base/ui/data/CJPaySecurityLoadingStyleInfo$CJPaySecurityItemShowInfo;", "getLoading_show_info_map_pb", "setLoading_show_info_map_pb", "need_resign", "", "option_show_info_list", "", "Lcom/android/ttcjpaysdk/base/ui/data/CJOptionShowInfo;", "pay_addi_item_list", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayAddiItemInfo;", "pay_and_x_confirm_btn_label", "payment_selection_material", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$PaymentSelectionMaterial;", "promotion_scene", "promotion_show_priority", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$PromotionShowPriority;", "rec_header_title", "Lcom/android/ttcjpaysdk/base/ui/data/UIComponent;", "recommend_voucher_info", "recommend_voucher_info_pb", "Lcom/android/ttcjpaysdk/base/ui/data/UIComponentList;", "getRecommend_voucher_info_pb", "setRecommend_voucher_info_pb", "select_page_show_info", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$SelectPageShowInfoBean;", "show_pay_verify_pre_loading", "standard_rec_button_info", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayCheckoutCounterButtonInfo;", "standard_rec_desc", "standard_rec_desc_map", "standard_show_amount", "standard_show_amount_map", "toast_msg_info", "Lcom/android/ttcjpaysdk/base/ui/data/ToastMsgInfo;", "trade_area_voucher", "Lcom/android/ttcjpaysdk/base/ui/data/TradeAreaVoucher;", "trade_confirm_auxiliary_button_info", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayTopRightBtnInfo;", "trade_confirm_button_label", "voucher_msg_info_map", "voucher_msg_info_map_pb", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherMsgInfoBeanList;", "getVoucher_msg_info_map_pb", "setVoucher_msg_info_map_pb", "voucher_msg_map", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherMsgBean;", "voucher_msg_map_pb", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherTagBeanList;", "getVoucher_msg_map_pb", "setVoucher_msg_map_pb", "voucher_retain_info_map", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherRetainInfoMap;", "voucher_retain_info_map_pb", "Lcom/android/ttcjpaysdk/base/ui/data/VoucherRetainInfo;", "getVoucher_retain_info_map_pb", "setVoucher_retain_info_map_pb", "afterProtoDecode", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AssetExtensionShowInfo implements CJPayObject, Serializable {
        public ArrayList<CJPayPayInfo.AmountAreaInfo> amount_area_list;
        public String background;
        public CJPayBubbleInfo bubble_info_map;
        private HashMap<String, ButtonInfoLabel> bubble_info_map_pb;
        public String complete_title;
        public String crossed_price;
        public HashMap<String, String> crossed_price_map;
        public String default_expand_confirm_btn_label;
        public HashMap<String, String> ext_show_info;
        public FrontPayTypeData.HomePageFoldVoucherInfo fold_voucher_info;
        public FunctionGuidanceMaterial function_guidance_material;
        public String hit_tips_sub_type;
        public IconTips icon_tips;
        public JumpInfoBean jump_info;
        public CJPaySecurityLoadingStyleInfo loading_show_info_map;
        private HashMap<String, CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo> loading_show_info_map_pb;
        public boolean need_resign;
        public List<CJOptionShowInfo> option_show_info_list;
        public ArrayList<CJPayAddiItemInfo> pay_addi_item_list;
        public String pay_and_x_confirm_btn_label;
        public PaymentSelectionMaterial payment_selection_material;
        public String promotion_scene;
        public PromotionShowPriority promotion_show_priority;
        public ArrayList<UIComponent> rec_header_title;
        public HashMap<String, String> recommend_voucher_info;
        private HashMap<String, UIComponentList> recommend_voucher_info_pb;
        public SelectPageShowInfoBean select_page_show_info;
        public boolean show_pay_verify_pre_loading;
        public CJPayCheckoutCounterButtonInfo standard_rec_button_info;
        public String standard_rec_desc;
        public HashMap<String, String> standard_rec_desc_map;
        public String standard_show_amount;
        public HashMap<String, String> standard_show_amount_map;
        public ArrayList<ToastMsgInfo> toast_msg_info;
        public TradeAreaVoucher trade_area_voucher;
        public CJPayTopRightBtnInfo trade_confirm_auxiliary_button_info;
        public String trade_confirm_button_label;
        public HashMap<String, String> voucher_msg_info_map;
        private HashMap<String, VoucherMsgInfoBeanList> voucher_msg_info_map_pb;
        public VoucherMsgBean voucher_msg_map;
        private HashMap<String, VoucherTagBeanList> voucher_msg_map_pb;
        public VoucherRetainInfoMap voucher_retain_info_map;
        private HashMap<String, VoucherRetainInfo> voucher_retain_info_map_pb;

        public final void afterProtoDecode() {
            this.voucher_msg_map = AssetInfoBeanKt.transVoucherMsgBean(this.voucher_msg_map_pb);
            HashMap<String, ButtonInfoLabel> r100 = this.bubble_info_map_pb;
            if (r100 != null) goto L5;
        L10:
            CJPayBubbleInfo r101 = null;
        L11:
            this.bubble_info_map = r101;
            HashMap<String, VoucherRetainInfo> r102 = this.voucher_retain_info_map_pb;
            if (r102 != null) goto L14;
        L19:
            VoucherRetainInfoMap r103 = null;
        L20:
            this.voucher_retain_info_map = r103;
            this.voucher_msg_info_map = AssetInfoBeanKt.access$transVoucherMsgInfoBeanList(this.voucher_msg_info_map_pb);
            this.recommend_voucher_info = AssetInfoBeanKt.access$transUIComponentList(this.recommend_voucher_info_pb);
            HashMap<String, CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo> r104 = this.loading_show_info_map_pb;
            if (r104 != null) goto L23;
        L52:
            CJPaySecurityLoadingStyleInfo r105 = null;
        L53:
            this.loading_show_info_map = r105;
            this.voucher_msg_map_pb = null;
            this.bubble_info_map_pb = null;
            this.voucher_retain_info_map_pb = null;
            this.voucher_msg_info_map_pb = null;
            this.recommend_voucher_info_pb = null;
            this.loading_show_info_map_pb = null;
            return;
        L23:
            if ((!r104.isEmpty()) == true) goto L26;
            r104 = null;
        L26:
            if (r104 == null) goto L52;
            r105 = new CJPaySecurityLoadingStyleInfo();
            CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo r106 = r104.get("bind_card_complete_show_info");
            if (r106 != null) goto L30;
            r106 = new CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo();
        L30:
            r105.bind_card_complete_show_info = r106;
            CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo r107 = r104.get("bind_card_confirm_pre_show_info");
            if (r107 != null) goto L33;
            r107 = new CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo();
        L33:
            r105.bind_card_confirm_pre_show_info = r107;
            CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo r108 = r104.get("bind_card_confirm_paying_show_info");
            if (r108 != null) goto L36;
            r108 = new CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo();
        L36:
            r105.bind_card_confirm_paying_show_info = r108;
            CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo r109 = r104.get("trade_confirm_pre_show_info");
            if (r109 != null) goto L39;
            r109 = new CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo();
        L39:
            r105.trade_confirm_pre_show_info = r109;
            CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo r110 = r104.get("trade_confirm_paying_show_info");
            if (r110 != null) goto L42;
            r110 = new CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo();
        L42:
            r105.trade_confirm_paying_show_info = r110;
            CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo r111 = r104.get("nopwd_combine_pre_show_info");
            if (r111 != null) goto L45;
            r111 = new CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo();
        L45:
            r105.nopwd_combine_pre_show_info = r111;
            CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo r112 = r104.get("nopwd_combine_paying_show_info");
            if (r112 != null) goto L48;
            r112 = new CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo();
        L48:
            r105.nopwd_combine_paying_show_info = r112;
            CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo r113 = r104.get("pay_verify_pre_show_info");
            if (r113 != null) goto L51;
            r113 = new CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo();
        L51:
            r105.pay_verify_pre_show_info = r113;
            goto L53
        L14:
            if ((!r102.isEmpty()) == true) goto L17;
            r102 = null;
        L17:
            if (r102 == null) goto L19;
            r103 = new VoucherRetainInfoMap();
            r103.superposed_list = r102.get("superposed_list");
            goto L20
        L5:
            if ((!r100.isEmpty()) == true) goto L8;
            r100 = null;
        L8:
            if (r100 == null) goto L10;
            r101 = new CJPayBubbleInfo();
            r101.button = r100.get("button");
            r101.paytype = r100.get("paytype");
            goto L11
        }

        public AssetExtensionShowInfo() {
            this.select_page_show_info = new SelectPageShowInfoBean();
            this.jump_info = new JumpInfoBean();
            this.standard_rec_desc = "";
            this.standard_show_amount = "";
            this.crossed_price = "";
            this.standard_rec_desc_map = new HashMap();
            this.standard_show_amount_map = new HashMap();
            this.amount_area_list = new ArrayList();
            this.voucher_msg_map = new VoucherMsgBean();
            this.trade_confirm_button_label = "";
            this.trade_area_voucher = new TradeAreaVoucher();
            this.icon_tips = new IconTips();
            this.payment_selection_material = new PaymentSelectionMaterial();
            this.function_guidance_material = new FunctionGuidanceMaterial();
            this.background = "";
            this.crossed_price_map = new HashMap();
            this.pay_addi_item_list = new ArrayList();
            this.fold_voucher_info = new FrontPayTypeData.HomePageFoldVoucherInfo();
            this.promotion_scene = "";
            this.promotion_show_priority = new PromotionShowPriority();
            this.voucher_msg_info_map = new HashMap();
            this.default_expand_confirm_btn_label = "";
            this.pay_and_x_confirm_btn_label = "";
            this.toast_msg_info = new ArrayList();
            this.complete_title = "";
            this.ext_show_info = new HashMap();
            this.hit_tips_sub_type = "";
            this.rec_header_title = new ArrayList();
            this.trade_confirm_auxiliary_button_info = new CJPayTopRightBtnInfo();
        }

        public final HashMap<String, ButtonInfoLabel> getBubble_info_map_pb() {
            return this.bubble_info_map_pb;
        }

        public final HashMap<String, CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo> getLoading_show_info_map_pb() {
            return this.loading_show_info_map_pb;
        }

        public final HashMap<String, UIComponentList> getRecommend_voucher_info_pb() {
            return this.recommend_voucher_info_pb;
        }

        public final HashMap<String, VoucherMsgInfoBeanList> getVoucher_msg_info_map_pb() {
            return this.voucher_msg_info_map_pb;
        }

        public final HashMap<String, VoucherTagBeanList> getVoucher_msg_map_pb() {
            return this.voucher_msg_map_pb;
        }

        public final HashMap<String, VoucherRetainInfo> getVoucher_retain_info_map_pb() {
            return this.voucher_retain_info_map_pb;
        }

        public final void setBubble_info_map_pb(HashMap<String, ButtonInfoLabel> r100) {
            this.bubble_info_map_pb = r100;
        }

        public final void setLoading_show_info_map_pb(HashMap<String, CJPaySecurityLoadingStyleInfo.CJPaySecurityItemShowInfo> r100) {
            this.loading_show_info_map_pb = r100;
        }

        public final void setRecommend_voucher_info_pb(HashMap<String, UIComponentList> r100) {
            this.recommend_voucher_info_pb = r100;
        }

        public final void setVoucher_msg_info_map_pb(HashMap<String, VoucherMsgInfoBeanList> r100) {
            this.voucher_msg_info_map_pb = r100;
        }

        public final void setVoucher_msg_map_pb(HashMap<String, VoucherTagBeanList> r100) {
            this.voucher_msg_map_pb = r100;
        }

        public final void setVoucher_retain_info_map_pb(HashMap<String, VoucherRetainInfo> r100) {
            this.voucher_retain_info_map_pb = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetHomePageBanner;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "banner_text", "", "btn_jump_info", "Lcom/android/ttcjpaysdk/base/ui/data/JumpInfoBean;", "btn_text", "icon_url", a.KEY_RECOMMEND_TYPE, "theme_color", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AssetHomePageBanner implements CJPayObject, Serializable {
        public String banner_text;
        public JumpInfoBean btn_jump_info;
        public String btn_text;
        public String icon_url;
        public String recommend_type;
        public String theme_color;

        public AssetHomePageBanner() {
            this.banner_text = "";
            this.btn_text = "";
            this.theme_color = "";
            this.icon_url = "";
            this.recommend_type = "";
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetHomePageGroupInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "display_count", "", "fold_describe", "", "fold_style_display_info", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$FoldStyleDisplayInfo;", "home_page_group_info_list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetSelectPageGroupInfoBean;", "Lkotlin/collections/ArrayList;", "isNotEmpty", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AssetHomePageGroupInfo implements CJPayObject, Serializable {
        public int display_count;
        public String fold_describe;
        public FoldStyleDisplayInfo fold_style_display_info;
        public ArrayList<AssetSelectPageGroupInfoBean> home_page_group_info_list;

        public final boolean isNotEmpty() {
            if (this.fold_describe.length() <= 0) goto L5;
            boolean r100 = true;
        L6:
            if (r100 == false) goto L8;
        L9:
            return true;
        L8:
            if ((!this.home_page_group_info_list.isEmpty()) == true) goto L9;
            return false;
        L5:
            r100 = false;
            goto L6
        }

        public AssetHomePageGroupInfo() {
            this.home_page_group_info_list = new ArrayList();
            this.fold_describe = "";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u000fR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetMetaInfoBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "asset_id", "", "asset_type", "asset_type_code", "ext", "fund_bill_index", "instid", "getExt", "Lorg/json/JSONObject;", "getUniqueSymbol", "isValidMetaInfo", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static class AssetMetaInfoBean implements CJPayObject, Serializable {
        public String asset_id;
        public String asset_type;
        public String asset_type_code;
        public String ext;
        public String fund_bill_index;
        public String instid;

        public final JSONObject getExt() {
            return KtSafeMethodExtensionKt.safeCreate(this.ext);
        }

        public final String getUniqueSymbol() {
            return this.asset_id + '_' + this.asset_type + '_' + this.asset_type_code + '_' + this.instid;
        }

        public final boolean isValidMetaInfo() {
            if (this.asset_id.length() <= 0) goto L5;
            boolean r100 = true;
        L6:
            if (r100 == true) goto L8;
        L23:
            return false;
        L8:
            if (this.asset_type.length() <= 0) goto L10;
            boolean r101 = true;
        L11:
            if (r101 == false) goto L23;
            if (this.asset_type_code.length() <= 0) goto L15;
            boolean r102 = true;
        L16:
            if (r102 == false) goto L23;
            if (this.instid.length() <= 0) goto L20;
            boolean r103 = true;
        L21:
            if (r103 == false) goto L23;
            return true;
        L20:
            r103 = false;
            goto L21
        L15:
            r102 = false;
            goto L16
        L10:
            r101 = false;
            goto L11
        L5:
            r100 = false;
            goto L6
        }

        public AssetMetaInfoBean() {
            this.fund_bill_index = "";
            this.asset_id = "";
            this.asset_type = "";
            this.asset_type_code = "";
            this.instid = "";
            this.ext = "";
        }
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\tj\b\u0012\u0004\u0012\u00020\u001a`\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetPrimaryShowInfoBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "asset_home_page_banner", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetHomePageBanner;", "asset_home_page_group_info", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetHomePageGroupInfo;", "asset_select_page_group_info_list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetSelectPageGroupInfoBean;", "Lkotlin/collections/ArrayList;", "background", "", "card_style_show_info", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$CardStyleShowInfo;", "home_page_guide_info", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$HomePageGuideInfo;", "home_page_picture_url", "home_page_show_num", "", "Ljava/lang/Integer;", "home_page_show_style", "home_page_voucher", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$HomePageVoucher;", "tips_msg_info_list", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$TipMsgInfoItem;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AssetPrimaryShowInfoBean implements CJPayObject, Serializable {
        public AssetHomePageBanner asset_home_page_banner;
        public AssetHomePageGroupInfo asset_home_page_group_info;
        public ArrayList<AssetSelectPageGroupInfoBean> asset_select_page_group_info_list;
        public String background;
        public CardStyleShowInfo card_style_show_info;
        public HomePageGuideInfo home_page_guide_info;
        public String home_page_picture_url;
        public Integer home_page_show_num;
        public String home_page_show_style;
        public HomePageVoucher home_page_voucher;
        public ArrayList<TipMsgInfoItem> tips_msg_info_list;

        public AssetPrimaryShowInfoBean() {
            this.asset_select_page_group_info_list = new ArrayList();
            this.home_page_show_style = "";
            this.home_page_picture_url = "";
            this.asset_home_page_group_info = new AssetHomePageGroupInfo();
            this.tips_msg_info_list = new ArrayList();
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\"\u001a\u00020\u0018J\u0006\u0010#\u001a\u00020\u0000R\"\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u0005j\b\u0012\u0004\u0012\u00020\u001b`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020 0\u0005j\b\u0012\u0004\u0012\u00020 `\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u0005j\b\u0012\u0004\u0012\u00020\u001d`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetSelectPageGroupInfoBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "asset_index_list", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "can_display_icon_asset_index_list", "display_count", "display_index_list", "fold_cell_index", "fold_desc", "", "group_bg_image", "group_desc", "group_enhance_info", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$GroupEnhanceInfo;", "group_icon", "group_style", "group_title", "group_title_image", "group_type", "hide_group_tile", "", "is_folded", "label_list", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$GroupInfoLabel;", "shouldShowRightTipsItem", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$TipMsgInfoItem;", "show_group_title_split_line", "sub_group_list", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$SubGroupInfoBean;", "tips_msg_info_list", "checkCombineGroup", "copy", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AssetSelectPageGroupInfoBean implements CJPayObject, Serializable {
        public ArrayList<Integer> asset_index_list;
        public ArrayList<Integer> can_display_icon_asset_index_list;
        public int display_count;
        public ArrayList<Integer> display_index_list;
        public int fold_cell_index;
        public String fold_desc;
        public String group_bg_image;
        public String group_desc;
        public GroupEnhanceInfo group_enhance_info;
        public String group_icon;
        public String group_style;
        public String group_title;
        public String group_title_image;
        public String group_type;
        public boolean hide_group_tile;
        public boolean is_folded;
        public ArrayList<GroupInfoLabel> label_list;
        public TipMsgInfoItem shouldShowRightTipsItem;
        public boolean show_group_title_split_line;
        public ArrayList<SubGroupInfoBean> sub_group_list;
        public ArrayList<TipMsgInfoItem> tips_msg_info_list;

        public final boolean checkCombineGroup() {
            return StringsKt.endsWith$default(this.group_type, "_combine", false, 2, null);
        }

        public final AssetSelectPageGroupInfoBean copy() {
            AssetSelectPageGroupInfoBean r100 = new AssetSelectPageGroupInfoBean();
            r100.group_type = this.group_type;
            r100.group_title = this.group_title;
            Object r101 = this.asset_index_list.clone();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.Int> }");
            r100.asset_index_list = (ArrayList) r101;
            r100.group_desc = this.group_desc;
            r100.display_count = this.display_count;
            r100.fold_desc = this.fold_desc;
            r100.hide_group_tile = this.hide_group_tile;
            r100.show_group_title_split_line = this.show_group_title_split_line;
            r100.group_enhance_info = this.group_enhance_info;
            Object r102 = this.sub_group_list.clone();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type java.util.ArrayList<com.android.ttcjpaysdk.base.ui.data.AssetInfoBean.SubGroupInfoBean>{ kotlin.collections.TypeAliasesKt.ArrayList<com.android.ttcjpaysdk.base.ui.data.AssetInfoBean.SubGroupInfoBean> }");
            r100.sub_group_list = (ArrayList) r102;
            Object r103 = this.display_index_list.clone();
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Int>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.Int> }");
            r100.display_index_list = (ArrayList) r103;
            r100.fold_cell_index = this.fold_cell_index;
            return r100;
        }

        public AssetSelectPageGroupInfoBean() {
            this.group_type = "";
            this.group_title = "";
            this.group_icon = "";
            this.group_title_image = "";
            this.group_bg_image = "";
            this.asset_index_list = new ArrayList();
            this.group_desc = "";
            this.fold_desc = "";
            this.tips_msg_info_list = new ArrayList();
            this.group_style = "";
            this.label_list = new ArrayList();
            this.sub_group_list = new ArrayList();
            this.can_display_icon_asset_index_list = new ArrayList();
            this.display_index_list = new ArrayList();
        }
    }

    @Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010O\u001a\u00020PJ\u0006\u0010Q\u001a\u00020\nJ\u0006\u0010R\u001a\u00020\fJ\u0006\u0010S\u001a\u00020\fJ\u0006\u0010T\u001a\u00020\fR\u001a\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010&\u001a\u0012\u0012\u0004\u0012\u00020'0\u0005j\b\u0012\u0004\u0012\u00020'`(8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010+\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010-\u001a\u00020.8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R2\u0010/\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R:\u00100\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u000201\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u000201\u0018\u0001`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0012\u00106\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u00107\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u00109\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010:\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010;\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010<\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010=\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010>\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000fj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010?\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010@\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010A\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010B\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010C\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R2\u0010D\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R:\u0010E\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020F\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020F\u0018\u0001`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u00103\"\u0004\bH\u00105R\u0012\u0010I\u001a\u00020J8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R:\u0010K\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020L\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020L\u0018\u0001`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u00103\"\u0004\bN\u00105¨\u0006U"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetToCombineAssetInfoBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "amount_area_list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo$AmountAreaInfo;", "asset_meta_info", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$AssetMetaInfoBean;", "banner_text", "", "btn_is_checked", "", "crossed_price", "crossed_price_map", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "default_expand_confirm_btn_label", "default_show", "ext_show_info", "fold_voucher_info", "Lcom/android/ttcjpaysdk/base/ui/data/FrontPayTypeData$HomePageFoldVoucherInfo;", "function_guidance_material", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$FunctionGuidanceMaterial;", "jump_info", "Lcom/android/ttcjpaysdk/base/ui/data/JumpInfoBean;", "need_resign", "option_show_info_list", "", "Lcom/android/ttcjpaysdk/base/ui/data/CJOptionShowInfo;", "origin_asset_amount", "", "origin_asset_amount_desc", "origin_asset_amount_desc_map", "origin_asset_desc", "origin_asset_desc_map", "origin_asset_icon", "origin_asset_prefix_desc", "pay_addi_item_list", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayAddiItemInfo;", "Lkotlin/collections/ArrayList;", "pay_again_button_top_desc", "pay_and_x_confirm_btn_label", "payment_selection_material", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$PaymentSelectionMaterial;", "promotion_show_priority", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$PromotionShowPriority;", "recommend_voucher_info", "recommend_voucher_info_pb", "Lcom/android/ttcjpaysdk/base/ui/data/UIComponentList;", "getRecommend_voucher_info_pb", "()Ljava/util/HashMap;", "setRecommend_voucher_info_pb", "(Ljava/util/HashMap;)V", "standard_rec_desc", "standard_rec_desc_map", "standard_show_amount", "standard_show_amount_map", "to_combine_asset_amount", "to_combine_asset_amount_desc", "to_combine_asset_amount_desc_map", "to_combine_asset_desc", "to_combine_asset_desc_map", "to_combine_asset_icon", "to_combine_asset_index", "to_combine_asset_prefix_desc", "to_combine_asset_short_desc", "trade_confirm_button_label", "voucher_msg_info_map", "voucher_msg_info_map_pb", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherMsgInfoBeanList;", "getVoucher_msg_info_map_pb", "setVoucher_msg_info_map_pb", "voucher_msg_map", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherMsgBean;", "voucher_msg_map_pb", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherTagBeanList;", "getVoucher_msg_map_pb", "setVoucher_msg_map_pb", "afterProtoDecode", "", "getPaymentSelectionMaterialKey", "isPaymentSelectionChecked", "isShowFunctionGuide", "isShowPaymentSelectionMaterial", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AssetToCombineAssetInfoBean implements CJPayObject, Serializable {
        public ArrayList<CJPayPayInfo.AmountAreaInfo> amount_area_list;
        public AssetMetaInfoBean asset_meta_info;
        public String banner_text;
        public boolean btn_is_checked;
        public String crossed_price;
        public HashMap<String, String> crossed_price_map;
        public String default_expand_confirm_btn_label;
        public boolean default_show;
        public HashMap<String, String> ext_show_info;
        public FrontPayTypeData.HomePageFoldVoucherInfo fold_voucher_info;
        public FunctionGuidanceMaterial function_guidance_material;
        public JumpInfoBean jump_info;
        public boolean need_resign;
        public List<CJOptionShowInfo> option_show_info_list;
        public int origin_asset_amount;
        public String origin_asset_amount_desc;
        public HashMap<String, String> origin_asset_amount_desc_map;
        public String origin_asset_desc;
        public HashMap<String, String> origin_asset_desc_map;
        public String origin_asset_icon;
        public String origin_asset_prefix_desc;
        public ArrayList<CJPayAddiItemInfo> pay_addi_item_list;
        public String pay_again_button_top_desc;
        public String pay_and_x_confirm_btn_label;
        public PaymentSelectionMaterial payment_selection_material;
        public PromotionShowPriority promotion_show_priority;
        public HashMap<String, String> recommend_voucher_info;
        private HashMap<String, UIComponentList> recommend_voucher_info_pb;
        public String standard_rec_desc;
        public HashMap<String, String> standard_rec_desc_map;
        public String standard_show_amount;
        public HashMap<String, String> standard_show_amount_map;
        public int to_combine_asset_amount;
        public String to_combine_asset_amount_desc;
        public HashMap<String, String> to_combine_asset_amount_desc_map;
        public String to_combine_asset_desc;
        public HashMap<String, String> to_combine_asset_desc_map;
        public String to_combine_asset_icon;
        public int to_combine_asset_index;
        public String to_combine_asset_prefix_desc;
        public String to_combine_asset_short_desc;
        public String trade_confirm_button_label;
        public HashMap<String, String> voucher_msg_info_map;
        private HashMap<String, VoucherMsgInfoBeanList> voucher_msg_info_map_pb;
        public VoucherMsgBean voucher_msg_map;
        private HashMap<String, VoucherTagBeanList> voucher_msg_map_pb;

        public final void afterProtoDecode() {
            this.voucher_msg_info_map = AssetInfoBeanKt.access$transVoucherMsgInfoBeanList(this.voucher_msg_info_map_pb);
            this.voucher_msg_map = AssetInfoBeanKt.transVoucherMsgBean(this.voucher_msg_map_pb);
            this.recommend_voucher_info = AssetInfoBeanKt.access$transUIComponentList(this.recommend_voucher_info_pb);
            this.voucher_msg_info_map_pb = null;
            this.voucher_msg_map_pb = null;
            this.recommend_voucher_info_pb = null;
        }

        public final String getPaymentSelectionMaterialKey() {
            return this.payment_selection_material.key;
        }

        public final boolean isPaymentSelectionChecked() {
            return this.payment_selection_material.is_checked;
        }

        public final boolean isShowFunctionGuide() {
            FunctionGuidanceMaterial r100 = this.function_guidance_material;
            if (r100 == null) goto L5;
            String r101 = r100.key;
        L7:
            return CJStringExtensionKt.isNotNullOrEmpty(r101);
        L5:
            r101 = null;
            goto L7
        }

        public final boolean isShowPaymentSelectionMaterial() {
            if (this.payment_selection_material.key.length() <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        public AssetToCombineAssetInfoBean() {
            this.asset_meta_info = new AssetMetaInfoBean();
            this.jump_info = new JumpInfoBean();
            this.origin_asset_amount_desc = "";
            this.to_combine_asset_amount_desc = "";
            this.to_combine_asset_desc = "";
            this.to_combine_asset_short_desc = "";
            this.origin_asset_desc = "";
            this.standard_rec_desc_map = new HashMap();
            this.standard_show_amount_map = new HashMap();
            this.payment_selection_material = new PaymentSelectionMaterial();
            this.trade_confirm_button_label = "";
            this.pay_and_x_confirm_btn_label = "";
            this.banner_text = "";
            this.standard_rec_desc = "";
            this.standard_show_amount = "";
            this.crossed_price = "";
            this.origin_asset_amount_desc_map = new HashMap();
            this.to_combine_asset_amount_desc_map = new HashMap();
            this.origin_asset_prefix_desc = "";
            this.to_combine_asset_prefix_desc = "";
            this.to_combine_asset_icon = "";
            this.origin_asset_icon = "";
            this.origin_asset_desc_map = new HashMap();
            this.to_combine_asset_desc_map = new HashMap();
            this.pay_again_button_top_desc = "";
            this.crossed_price_map = new HashMap();
            this.pay_addi_item_list = new ArrayList();
            this.fold_voucher_info = new FrontPayTypeData.HomePageFoldVoucherInfo();
            this.promotion_show_priority = new PromotionShowPriority();
            this.voucher_msg_info_map = new HashMap();
            this.voucher_msg_map = new VoucherMsgBean();
            this.default_expand_confirm_btn_label = "";
            this.ext_show_info = new HashMap();
        }

        public final HashMap<String, UIComponentList> getRecommend_voucher_info_pb() {
            return this.recommend_voucher_info_pb;
        }

        public final HashMap<String, VoucherMsgInfoBeanList> getVoucher_msg_info_map_pb() {
            return this.voucher_msg_info_map_pb;
        }

        public final HashMap<String, VoucherTagBeanList> getVoucher_msg_map_pb() {
            return this.voucher_msg_map_pb;
        }

        public final void setRecommend_voucher_info_pb(HashMap<String, UIComponentList> r100) {
            this.recommend_voucher_info_pb = r100;
        }

        public final void setVoucher_msg_info_map_pb(HashMap<String, VoucherMsgInfoBeanList> r100) {
            this.voucher_msg_info_map_pb = r100;
        }

        public final void setVoucher_msg_map_pb(HashMap<String, VoucherTagBeanList> r100) {
            this.voucher_msg_map_pb = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$CardStyleShowInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "card_style_index_list", "", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CardStyleShowInfo implements CJPayObject, Serializable {
        public List<Integer> card_style_index_list;

        public CardStyleShowInfo() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$Companion;", "", "()V", "CJ_PAY_DEFAULT_KEY", "", "CJ_PAY_RETAIN_KEY", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u001b\u001a\u00020\u001cR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$ExtInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "bank_card_id", "", "bank_code", "bank_name", "bankcard_type_2512", a.KEY_CARD_TYPE, "combine_voucher_info", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayVoucherInfo;", "direct_bank_campaign_info", "fee", a.KEY_INSTALLMENT_INFO, "is_foreign_card", "last_pay_fail", "optional_voucher_open_status", "pwd_check_way", "regular_account_info", "remaining_credit", "sweep_light_times", "tips_title", "track_data", "voucher_info", "yf_fee_compliance_show_info", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$YfFeeComplianceShowInfo;", "hasYfFeeComplianceShowInfo", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ExtInfo implements CJPayObject, Serializable {
        public String bank_card_id;
        public String bank_code;
        public String bank_name;
        public String bankcard_type_2512;
        public String card_type;
        public CJPayVoucherInfo combine_voucher_info;
        public String direct_bank_campaign_info;
        public String fee;
        public String installment;
        public String is_foreign_card;
        public String last_pay_fail;
        public String optional_voucher_open_status;
        public String pwd_check_way;
        public String regular_account_info;
        public String remaining_credit;
        public String sweep_light_times;
        public String tips_title;
        public String track_data;
        public CJPayVoucherInfo voucher_info;
        public YfFeeComplianceShowInfo yf_fee_compliance_show_info;

        public final boolean hasYfFeeComplianceShowInfo() {
            if (this.yf_fee_compliance_show_info.yf_fee_compliance_desc.length() <= 0) goto L5;
            boolean r100 = true;
        L6:
            if (r100 == false) goto L8;
            return true;
        L8:
            if (this.yf_fee_compliance_show_info.yf_fee_compliance_url.length() <= 0) goto L10;
            boolean r101 = true;
        L11:
            if (r101 == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            r101 = false;
            goto L11
        L5:
            r100 = false;
            goto L6
        }

        public ExtInfo() {
            this.fee = "";
            this.installment = "";
            this.bank_code = "";
            this.bank_name = "";
            this.card_type = "";
            this.voucher_info = new CJPayVoucherInfo();
            this.combine_voucher_info = new CJPayVoucherInfo();
            this.remaining_credit = "";
            this.is_foreign_card = "";
            this.bank_card_id = "";
            this.last_pay_fail = "";
            this.tips_title = "";
            this.pwd_check_way = "";
            this.direct_bank_campaign_info = "";
            this.optional_voucher_open_status = "";
            this.bankcard_type_2512 = "";
            this.sweep_light_times = "";
            this.regular_account_info = "";
            this.yf_fee_compliance_show_info = new YfFeeComplianceShowInfo();
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\u0000J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rR\"\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$FoldStyleDisplayInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "display_index_list", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "expand_more_button_style", "", "is_show_multiple_assets", "copy", "isArrowDownForeMoreAsset", "", "isShowMultiple", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FoldStyleDisplayInfo implements CJPayObject, Serializable {
        public ArrayList<Integer> display_index_list;
        public String expand_more_button_style;
        public String is_show_multiple_assets;

        public final FoldStyleDisplayInfo copy() {
            FoldStyleDisplayInfo r100 = new FoldStyleDisplayInfo();
            r100.is_show_multiple_assets = this.is_show_multiple_assets;
            r100.display_index_list = new ArrayList(this.display_index_list);
            r100.expand_more_button_style = this.expand_more_button_style;
            return r100;
        }

        public final boolean isArrowDownForeMoreAsset() {
            return Intrinsics.areEqual(this.expand_more_button_style, "1");
        }

        public final boolean isShowMultiple() {
            return Intrinsics.areEqual(this.is_show_multiple_assets, "1");
        }

        public FoldStyleDisplayInfo() {
            this.is_show_multiple_assets = "";
            this.display_index_list = new ArrayList();
            this.expand_more_button_style = "";
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\fj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$FunctionGuidanceMaterial;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "guide_desc", "", "is_checked", "", "key", "off_button_text", "on_button_text", "protocol_group_names", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "protocol_list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayCardProtocolBean;", "Lkotlin/collections/ArrayList;", "style", "suffix_message", "toCJPayAgreementBean", "Lcom/android/ttcjpaysdk/base/ui/component/dialog/bean/CJPayAgreementBean;", "panelHeightDp", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FunctionGuidanceMaterial implements CJPayObject, Serializable {
        public String guide_desc;
        public boolean is_checked;
        public String key;
        public String off_button_text;
        public String on_button_text;
        public HashMap<String, String> protocol_group_names;
        public ArrayList<CJPayCardProtocolBean> protocol_list;
        public String style;
        public String suffix_message;

        public FunctionGuidanceMaterial() {
            this.guide_desc = "";
            this.protocol_group_names = new HashMap();
            this.protocol_list = new ArrayList();
            this.on_button_text = "";
            this.off_button_text = "";
            this.style = "SWITCH";
            this.key = "";
            this.suffix_message = "";
        }

        public final CJPayAgreementBean toCJPayAgreementBean(int r100) {
            CJPayAgreementBean r101 = new CJPayAgreementBean();
            r101.panelHeightDp = r100;
            r101.guide_desc = this.guide_desc;
            r101.protocol_group_names = this.protocol_group_names;
            ArrayList<CJPayCardProtocolBean> r102 = this.protocol_list;
            ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
            Iterator<T> r104 = r102.iterator();
        L4:
            if (r104.hasNext() == false) goto L6;
            CJPayCardProtocolBean r105 = (CJPayCardProtocolBean) r104.next();
            CJPayAgreementBean.ProtocolBean r106 = new CJPayAgreementBean.ProtocolBean();
            r106.name = r105.name;
            r106.template_url = r105.template_url;
            r106.group = r105.group;
            r103.add(r106);
            goto L4
        L6:
            r101.protocol_list = new ArrayList(r103);
            r101.style = this.style;
            r101.is_checked = this.is_checked;
            r101.suffix_message = this.suffix_message;
            return r101;
        }

        public static /* synthetic */ CJPayAgreementBean toCJPayAgreementBean$default(FunctionGuidanceMaterial r100, int r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = 470;
        L6:
            return r100.toCJPayAgreementBean(r101);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$GroupEnhanceInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "enhance_bg_color_end", "", "enhance_bg_color_gradient_angle", "", "enhance_bg_color_start", "enhance_icon", "enhance_jump_info", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$GroupEnhanceJumpInfo;", "enhance_title_icon", "enhance_type", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class GroupEnhanceInfo implements CJPayObject, Serializable {
        public String enhance_bg_color_end;
        public int enhance_bg_color_gradient_angle;
        public String enhance_bg_color_start;
        public String enhance_icon;
        public GroupEnhanceJumpInfo enhance_jump_info;
        public String enhance_title_icon;
        public String enhance_type;

        public GroupEnhanceInfo() {
            this.enhance_type = "";
            this.enhance_icon = "";
            this.enhance_title_icon = "";
            this.enhance_bg_color_gradient_angle = 270;
            this.enhance_bg_color_start = "";
            this.enhance_bg_color_end = "";
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$GroupEnhanceJumpInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "action", "", "icon", "url", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class GroupEnhanceJumpInfo implements CJPayObject, Serializable {
        public String action;
        public String icon;
        public String url;

        public GroupEnhanceJumpInfo() {
            this.action = "";
            this.icon = "";
            this.url = "";
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$GroupInfoLabel;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "type", "", "url", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class GroupInfoLabel implements CJPayObject, Serializable {
        public String type;
        public String url;

        public GroupInfoLabel() {
            this.type = "";
            this.url = "";
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$HomePageGuideInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "home_page_guide_jump_info", "Lcom/android/ttcjpaysdk/base/ui/data/JumpInfoBean;", "home_page_guide_text", "", "home_page_red_dot", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class HomePageGuideInfo implements CJPayObject, Serializable {
        public JumpInfoBean home_page_guide_jump_info;
        public String home_page_guide_text;
        public boolean home_page_red_dot;

        public HomePageGuideInfo() {
            this.home_page_guide_text = "";
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$HomePageVoucher;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "more_discount_voucher_text", "", "show_more_discount", "", "voucher_text", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class HomePageVoucher implements CJPayObject, Serializable {
        public String more_discount_voucher_text;
        public boolean show_more_discount;
        public String voucher_text;

        public HomePageVoucher() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$PaymentSelectionMaterial;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "is_checked", "", "key", "", "left_title", "right_title", "style", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PaymentSelectionMaterial implements CJPayObject, Serializable {
        public boolean is_checked;
        public String key;
        public String left_title;
        public String right_title;
        public String style;

        public PaymentSelectionMaterial() {
            this.style = "SWITCH";
            this.left_title = "";
            this.right_title = "";
            this.key = "";
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nR.\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$PromotionSceneMapping;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "operate_scene", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "promotion_scene", "selectRetain", "", "triggerPayAndX", "triggerRetain", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PromotionSceneMapping implements CJPayObject, Serializable {
        public HashMap<String, String> operate_scene;
        public String promotion_scene;

        public final boolean selectRetain() {
            String r100 = this.operate_scene.get("select_retain");
            if (r100 != null) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual("true", r100);
        }

        public final boolean triggerPayAndX() {
            String r100 = this.operate_scene.get("trigger_pay_and_x");
            if (r100 != null) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual("true", r100);
        }

        public final boolean triggerRetain() {
            String r100 = this.operate_scene.get("trigger_retain");
            if (r100 != null) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual("true", r100);
        }

        public PromotionSceneMapping() {
            this.promotion_scene = "";
            this.operate_scene = new HashMap();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$PromotionShowPriority;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "default_x_promotion_scene", "", "first_promotion_scene", "promotion_scene_mapping_list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$PromotionSceneMapping;", "Lkotlin/collections/ArrayList;", "second_promotion_scene", "third_promotion_scene", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PromotionShowPriority implements CJPayObject, Serializable {
        public String default_x_promotion_scene;
        public String first_promotion_scene;
        public ArrayList<PromotionSceneMapping> promotion_scene_mapping_list;
        public String second_promotion_scene;
        public String third_promotion_scene;

        public PromotionShowPriority() {
            this.first_promotion_scene = "";
            this.second_promotion_scene = "";
            this.third_promotion_scene = "";
            this.default_x_promotion_scene = "";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$SelectPageShowInfoBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "select_page_guide_choice_text", "", "select_page_guide_text", "select_page_priority_sub_title", "select_page_priority_title", "select_page_scene_sub_title_map", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "select_page_scene_title_map", "select_page_select_type", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SelectPageShowInfoBean implements CJPayObject, Serializable {
        public String select_page_guide_choice_text;
        public String select_page_guide_text;
        public String select_page_priority_sub_title;
        public String select_page_priority_title;
        public HashMap<String, String> select_page_scene_sub_title_map;
        public HashMap<String, String> select_page_scene_title_map;
        public String select_page_select_type;

        public SelectPageShowInfoBean() {
            this.select_page_priority_title = "";
            this.select_page_priority_sub_title = "";
            this.select_page_guide_text = "";
            this.select_page_guide_choice_text = "";
            this.select_page_select_type = "";
            this.select_page_scene_title_map = new HashMap();
            this.select_page_scene_sub_title_map = new HashMap();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$SubGroupInfoBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "asset_index_list", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "display_count", "fold_desc", "", "sub_group_type", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SubGroupInfoBean implements CJPayObject, Serializable {
        public ArrayList<Integer> asset_index_list;
        public int display_count;
        public String fold_desc;
        public String sub_group_type;

        public SubGroupInfoBean() {
            this.asset_index_list = new ArrayList();
            this.fold_desc = "";
            this.sub_group_type = "default";
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$TipMsgInfoItem;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "display_option", "", "payment", "tips_info_list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayUIComponent;", "Lkotlin/collections/ArrayList;", "tips_msg", "tips_sub_type", "tips_type", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TipMsgInfoItem implements CJPayObject, Serializable {
        public String display_option;
        public String payment;
        public ArrayList<CJPayUIComponent> tips_info_list;
        public String tips_msg;
        public String tips_sub_type;
        public String tips_type;

        public TipMsgInfoItem() {
            this.tips_msg = "";
            this.tips_type = "";
            this.payment = "";
            this.tips_sub_type = "";
            this.display_option = "";
            this.tips_info_list = new ArrayList();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherLabel;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "icon_url", "", "text", "type", "width", "", "isPictureType", "", "isTextType", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class VoucherLabel implements CJPayObject, Serializable {
        public String icon_url;
        public String text;
        public String type;
        public int width;

        public final boolean isPictureType() {
            return TextUtils.equals(this.type, "picture");
        }

        public final boolean isTextType() {
            return TextUtils.equals(this.type, "text");
        }

        public VoucherLabel() {
            this.text = "";
            this.type = "";
            this.icon_url = "";
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u0010H\u0002J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u0010H\u0002J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010R\"\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherMsgBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "premium_feel_tag", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherTagBean;", "Lkotlin/collections/ArrayList;", "recommend_tag", "tag12", "tag34", "tag56", "getCombineVoucherMsgV2OfCardList", "", "", "isVoucherExpanded", "", "getStdUICombineVoucherMsgV2OfCardList", "Lcom/android/ttcjpaysdk/base/ui/component/tag/CJVoucherTagBean;", "getStdUIVoucherMsgV2", "voucherTag", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherMsgBean$VoucherV2Tag;", ShareData.ISCOMBINEPAY, "isExpanded", "getStdUIVoucherMsgV2OfCardList", "getStdUIVoucherMsgV2OfPremiumFeelTag", "getVoucherMsgV2", "getVoucherMsgV2OfCardList", "VoucherEventType", "VoucherV2Tag", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class VoucherMsgBean implements CJPayObject, Serializable {
        public ArrayList<VoucherTagBean> premium_feel_tag;
        public ArrayList<VoucherTagBean> recommend_tag;
        public ArrayList<VoucherTagBean> tag12;
        public ArrayList<VoucherTagBean> tag34;
        public ArrayList<VoucherTagBean> tag56;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherMsgBean$VoucherEventType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DEFAULT", "COMBINE_PAY", "RETAIN", "RETAIN_COMBINE_PAY", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final enum VoucherEventType extends Enum<VoucherEventType> {
            private static final /* synthetic */ VoucherEventType[] $VALUES = null;
            public static final VoucherEventType COMBINE_PAY = null;
            public static final VoucherEventType DEFAULT = null;
            public static final VoucherEventType RETAIN = null;
            public static final VoucherEventType RETAIN_COMBINE_PAY = null;
            private final String value;

            private static final /* synthetic */ VoucherEventType[] $values() {
                return new VoucherEventType[]{DEFAULT, COMBINE_PAY, RETAIN, RETAIN_COMBINE_PAY};
            }

            public static VoucherEventType valueOf(String r100) {
                return (VoucherEventType) r27.a.a(VoucherEventType.class, r100);
            }

            public static VoucherEventType[] values() {
                return (VoucherEventType[]) $VALUES.clone();
            }

            static {
                DEFAULT = new VoucherEventType("DEFAULT", 0, "default");
                COMBINE_PAY = new VoucherEventType("COMBINE_PAY", 1, "combine_pay");
                RETAIN = new VoucherEventType("RETAIN", 2, "retain");
                RETAIN_COMBINE_PAY = new VoucherEventType("RETAIN_COMBINE_PAY", 3, "retain_combine_pay");
                $VALUES = $values();
            }

            public final String getValue() {
                return this.value;
            }

            private VoucherEventType(String r100, int r101, String r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherMsgBean$VoucherV2Tag;", "", "(Ljava/lang/String;I)V", "TAG12", "TAG34", "TAG56", "PremiumFeelTag", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final enum VoucherV2Tag extends Enum<VoucherV2Tag> {
            private static final /* synthetic */ VoucherV2Tag[] $VALUES = null;
            public static final VoucherV2Tag PremiumFeelTag = null;
            public static final VoucherV2Tag TAG12 = null;
            public static final VoucherV2Tag TAG34 = null;
            public static final VoucherV2Tag TAG56 = null;

            private static final /* synthetic */ VoucherV2Tag[] $values() {
                return new VoucherV2Tag[]{TAG12, TAG34, TAG56, PremiumFeelTag};
            }

            public static VoucherV2Tag valueOf(String r100) {
                return (VoucherV2Tag) r27.a.a(VoucherV2Tag.class, r100);
            }

            public static VoucherV2Tag[] values() {
                return (VoucherV2Tag[]) $VALUES.clone();
            }

            static {
                TAG12 = new VoucherV2Tag("TAG12", 0);
                TAG34 = new VoucherV2Tag("TAG34", 1);
                TAG56 = new VoucherV2Tag("TAG56", 2);
                PremiumFeelTag = new VoucherV2Tag("PremiumFeelTag", 3);
                $VALUES = $values();
            }

            private VoucherV2Tag(String r100, int r101) {
                super(r100, r101);
            }
        }

        public VoucherMsgBean() {
            this.tag12 = new ArrayList();
            this.tag34 = new ArrayList();
            this.tag56 = new ArrayList();
            this.recommend_tag = new ArrayList();
            this.premium_feel_tag = new ArrayList();
        }

        public final List<String> getCombineVoucherMsgV2OfCardList(boolean r100) {
            return getVoucherMsgV2(VoucherV2Tag.TAG56, true, r100);
        }

        public final List<CJVoucherTagBean> getStdUICombineVoucherMsgV2OfCardList(boolean r100) {
            return getStdUIVoucherMsgV2(VoucherV2Tag.TAG56, true, r100);
        }

        public final List<CJVoucherTagBean> getStdUIVoucherMsgV2OfCardList(boolean r100) {
            return getStdUIVoucherMsgV2(VoucherV2Tag.TAG56, false, r100);
        }

        public final List<CJVoucherTagBean> getStdUIVoucherMsgV2OfPremiumFeelTag(boolean r100) {
            return getStdUIVoucherMsgV2(VoucherV2Tag.PremiumFeelTag, false, r100);
        }

        public final List<String> getVoucherMsgV2OfCardList(boolean r100) {
            return getVoucherMsgV2(VoucherV2Tag.TAG56, false, r100);
        }

        private final List<CJVoucherTagBean> getStdUIVoucherMsgV2(VoucherV2Tag r100, boolean r101, boolean r102) {
            ArrayList r103 = new ArrayList();
            ArrayList<VoucherTagBean> r104 = new ArrayList();
            if (VoucherV2Tag.TAG12 != r100) goto L6;
            r104 = this.tag12;
        L14:
            if (r101 == false) goto L17;
            if (r102 == false) goto L17;
            VoucherEventType r105 = VoucherEventType.RETAIN_COMBINE_PAY;
        L22:
            int r106 = r104.size();
            int r107 = 0;
        L23:
            if (r107 >= r106) goto L30;
            VoucherTagBean r108 = (VoucherTagBean) ListProtector.get(r104, r107);
            if (Intrinsics.areEqual(r105.getValue(), r108.event_type) == false) goto L29;
            CJVoucherTagBean r109 = (CJVoucherTagBean) CJPayJsonParser.fromJson(CJPayObjectExtensionKt.toJson(r108), CJVoucherTagBean.class);
            if (r109 == null) goto L29;
            r103.add(r109);
        L29:
            r107 = r107 + 1;
            goto L23
        L30:
            return r103;
        L17:
            if (r101 == false) goto L19;
            r105 = VoucherEventType.COMBINE_PAY;
            goto L22
        L19:
            if (r102 == false) goto L21;
            r105 = VoucherEventType.RETAIN;
            goto L22
        L21:
            r105 = VoucherEventType.DEFAULT;
            goto L22
        L6:
            if (VoucherV2Tag.TAG34 != r100) goto L9;
            r104 = this.tag34;
            goto L14
        L9:
            if (VoucherV2Tag.TAG56 != r100) goto L12;
            r104 = this.tag56;
            goto L14
        L12:
            if (VoucherV2Tag.PremiumFeelTag != r100) goto L14;
            r104 = this.premium_feel_tag;
            goto L14
        }

        private final List<String> getVoucherMsgV2(VoucherV2Tag r100, boolean r110, boolean r111) {
            ArrayList r101 = new ArrayList();
            ArrayList<VoucherTagBean> r102 = new ArrayList();
            if (VoucherV2Tag.TAG12 != r100) goto L6;
            r102 = this.tag12;
        L11:
            if (r110 == false) goto L14;
            if (r111 == false) goto L14;
            VoucherEventType r103 = VoucherEventType.RETAIN_COMBINE_PAY;
        L19:
            int r112 = r102.size();
            int r104 = 0;
        L20:
            if (r104 >= r112) goto L32;
            VoucherTagBean r105 = (VoucherTagBean) ListProtector.get(r102, r104);
            if (Intrinsics.areEqual(r103.getValue(), r105.event_type) == false) goto L31;
            int r106 = r105.label.size();
            int r107 = 0;
        L24:
            if (r107 >= r106) goto L31;
            if (Intrinsics.areEqual("text", ((VoucherLabel) ListProtector.get(r105.label, r107)).type) == true) goto L28;
            r107 = r107 + 1;
            goto L24
        L28:
            if (TextUtils.isEmpty(((VoucherLabel) ListProtector.get(r105.label, r107)).text) == true) goto L31;
            r101.add(((VoucherLabel) ListProtector.get(r105.label, r107)).text);
        L31:
            r104 = r104 + 1;
            goto L20
        L32:
            return r101;
        L14:
            if (r110 == false) goto L16;
            r103 = VoucherEventType.COMBINE_PAY;
            goto L19
        L16:
            if (r111 == false) goto L18;
            r103 = VoucherEventType.RETAIN;
            goto L19
        L18:
            r103 = VoucherEventType.DEFAULT;
            goto L19
        L6:
            if (VoucherV2Tag.TAG34 != r100) goto L9;
            r102 = this.tag34;
            goto L11
        L9:
            if (VoucherV2Tag.TAG56 != r100) goto L11;
            r102 = this.tag56;
            goto L11
        }

        public static /* synthetic */ List getCombineVoucherMsgV2OfCardList$default(VoucherMsgBean r100, boolean r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = false;
        L6:
            return r100.getCombineVoucherMsgV2OfCardList(r101);
        }

        public static /* synthetic */ List getStdUICombineVoucherMsgV2OfCardList$default(VoucherMsgBean r100, boolean r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = false;
        L6:
            return r100.getStdUICombineVoucherMsgV2OfCardList(r101);
        }

        public static /* synthetic */ List getStdUIVoucherMsgV2OfCardList$default(VoucherMsgBean r100, boolean r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = false;
        L6:
            return r100.getStdUIVoucherMsgV2OfCardList(r101);
        }

        public static /* synthetic */ List getStdUIVoucherMsgV2OfPremiumFeelTag$default(VoucherMsgBean r100, boolean r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = false;
        L6:
            return r100.getStdUIVoucherMsgV2OfPremiumFeelTag(r101);
        }

        public static /* synthetic */ List getVoucherMsgV2OfCardList$default(VoucherMsgBean r100, boolean r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = false;
        L6:
            return r100.getVoucherMsgV2OfCardList(r101);
        }

        public static /* synthetic */ List getStdUIVoucherMsgV2$default(VoucherMsgBean r100, VoucherV2Tag r101, boolean r102, boolean r103, int r104, Object r105) {
            if ((r104 & 4) == 0) goto L6;
            r103 = false;
        L6:
            return r100.getStdUIVoucherMsgV2(r101, r102, r103);
        }

        public static /* synthetic */ List getVoucherMsgV2$default(VoucherMsgBean r100, VoucherV2Tag r101, boolean r102, boolean r103, int r104, Object r105) {
            if ((r104 & 4) == 0) goto L6;
            r103 = false;
        L6:
            return r100.getVoucherMsgV2(r101, r102, r103);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherMsgInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "left_msg", "", "right_msg", "tag_show_type", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class VoucherMsgInfo implements CJPayObject, Serializable {
        public String left_msg;
        public String right_msg;
        public String tag_show_type;

        public VoucherMsgInfo() {
            this.left_msg = "";
            this.right_msg = "";
            this.tag_show_type = "";
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherMsgInfoBeanList;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherMsgInfo;", "Lkotlin/collections/ArrayList;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class VoucherMsgInfoBeanList implements CJPayObject, Serializable {
        public ArrayList<VoucherMsgInfo> list;

        public VoucherMsgInfoBeanList() {
            this.list = new ArrayList();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherRetainInfoMap;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "superposed_list", "Lcom/android/ttcjpaysdk/base/ui/data/VoucherRetainInfo;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class VoucherRetainInfoMap implements CJPayObject, Serializable {
        public VoucherRetainInfo superposed_list;

        public VoucherRetainInfoMap() {
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherTagBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "actual_show_amount", "", "actual_show_amount_max", "event_type", "label", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherLabel;", "Lkotlin/collections/ArrayList;", "need_wrap", MapMonitorConst.STYLE_TYPE, "sub_pay_type_desc", "tag_border_color", "tag_fill_color", "tag_text_color", "voucher_id", "voucher_msg_sub_type", "voucher_msg_type", "voucher_pos", "isCombineType", "", "isDefaultType", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class VoucherTagBean implements CJPayObject, Serializable {
        public String actual_show_amount;
        public String actual_show_amount_max;
        public String event_type;
        public ArrayList<VoucherLabel> label;
        public String need_wrap;
        public String style_type;
        public String sub_pay_type_desc;
        public String tag_border_color;
        public String tag_fill_color;
        public String tag_text_color;
        public String voucher_id;
        public String voucher_msg_sub_type;
        public String voucher_msg_type;
        public String voucher_pos;

        public final boolean isCombineType() {
            return TextUtils.equals(this.event_type, "combine_pay");
        }

        public final boolean isDefaultType() {
            return TextUtils.equals(this.event_type, "default");
        }

        public VoucherTagBean() {
            this.actual_show_amount = "";
            this.actual_show_amount_max = "";
            this.event_type = "";
            this.label = new ArrayList();
            this.need_wrap = "";
            this.sub_pay_type_desc = "";
            this.voucher_id = "";
            this.voucher_msg_sub_type = "";
            this.voucher_msg_type = "";
            this.voucher_pos = "";
            this.style_type = "";
            this.tag_border_color = "";
            this.tag_fill_color = "";
            this.tag_text_color = "";
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherTagBeanList;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$VoucherTagBean;", "Lkotlin/collections/ArrayList;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class VoucherTagBeanList implements CJPayObject, Serializable {
        public ArrayList<VoucherTagBean> list;

        public VoucherTagBeanList() {
            this.list = new ArrayList();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean$YfFeeComplianceShowInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "yf_fee_compliance_desc", "", "yf_fee_compliance_url", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class YfFeeComplianceShowInfo implements CJPayObject, Serializable {
        public String yf_fee_compliance_desc;
        public String yf_fee_compliance_url;

        public YfFeeComplianceShowInfo() {
            this.yf_fee_compliance_desc = "";
            this.yf_fee_compliance_url = "";
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final void afterProtoDecode() {
        ExtInfo r100 = new ExtInfo();
        HashMap<String, String> r101 = this.ext_info_pb;
        if (r101 == null) goto L101;
        boolean r102 = true;
        if ((!r101.isEmpty()) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L101;
        String r103 = r101.get("fee");
        String r104 = "";
        if (r103 != null) goto L12;
        r103 = "";
    L12:
        r100.fee = r103;
        String r105 = r101.get(a.KEY_INSTALLMENT_INFO);
        if (r105 != null) goto L15;
        r105 = "";
    L15:
        r100.installment = r105;
        String r106 = r101.get("bank_code");
        if (r106 != null) goto L18;
        r106 = "";
    L18:
        r100.bank_code = r106;
        String r107 = r101.get("bank_name");
        if (r107 != null) goto L21;
        r107 = "";
    L21:
        r100.bank_name = r107;
        String r108 = r101.get(a.KEY_CARD_TYPE);
        if (r108 != null) goto L24;
        r108 = "";
    L24:
        r100.card_type = r108;
        r100.track_data = r101.get("track_data");
        String r109 = r101.get("voucher_info");
        if (r109 != null) goto L27;
    L36:
        CJPayVoucherInfo r110 = null;
    L37:
        if (r110 != null) goto L39;
        r110 = new CJPayVoucherInfo();
    L39:
        r100.voucher_info = r110;
        String r111 = r101.get("combine_voucher_info");
        if (r111 != null) goto L42;
    L51:
        CJPayVoucherInfo r112 = null;
    L52:
        if (r112 != null) goto L54;
        r112 = new CJPayVoucherInfo();
    L54:
        r100.combine_voucher_info = r112;
        String r113 = r101.get("remaining_credit");
        if (r113 != null) goto L57;
        r113 = "";
    L57:
        r100.remaining_credit = r113;
        String r114 = r101.get("is_foreign_card");
        if (r114 != null) goto L60;
        r114 = "";
    L60:
        r100.is_foreign_card = r114;
        String r115 = r101.get("bank_card_id");
        if (r115 != null) goto L63;
        r115 = "";
    L63:
        r100.bank_card_id = r115;
        String r116 = r101.get("last_pay_fail");
        if (r116 != null) goto L66;
        r116 = "";
    L66:
        r100.last_pay_fail = r116;
        String r117 = r101.get("tips_title");
        if (r117 != null) goto L69;
        r117 = "";
    L69:
        r100.tips_title = r117;
        String r118 = r101.get("pwd_check_way");
        if (r118 != null) goto L72;
        r118 = "";
    L72:
        r100.pwd_check_way = r118;
        String r119 = r101.get("direct_bank_campaign_info");
        if (r119 != null) goto L75;
        r119 = "";
    L75:
        r100.direct_bank_campaign_info = r119;
        String r120 = r101.get("optional_voucher_open_status");
        if (r120 != null) goto L78;
        r120 = "";
    L78:
        r100.optional_voucher_open_status = r120;
        String r121 = r101.get("sweep_light_times");
        if (r121 != null) goto L81;
        r121 = "";
    L81:
        r100.sweep_light_times = r121;
        String r122 = r101.get("regular_account_info");
        if (r122 == null) goto L85;
        r104 = r122;
    L85:
        r100.regular_account_info = r104;
        String r123 = r101.get("yf_fee_compliance_show_info");
        if (r123 != null) goto L88;
    L97:
        YfFeeComplianceShowInfo r124 = null;
    L98:
        if (r124 != null) goto L100;
        r124 = new YfFeeComplianceShowInfo();
    L100:
        r100.yf_fee_compliance_show_info = r124;
        goto L101
    L88:
        if (r123.length() > 0) goto L92;
        r102 = false;
    L92:
        if (Boolean.valueOf(r102).booleanValue() == true) goto L95;
        r123 = null;
    L95:
        if (r123 == null) goto L97;
        r124 = (YfFeeComplianceShowInfo) CJPayJsonParser.fromJson(r123, YfFeeComplianceShowInfo.class);
        goto L98
    L42:
        if (r111.length() <= 0) goto L44;
        boolean r125 = true;
    L46:
        if (Boolean.valueOf(r125).booleanValue() == true) goto L49;
        r111 = null;
    L49:
        if (r111 == null) goto L51;
        new CJPayVoucherInfo();
        r112 = (CJPayVoucherInfo) CJPayJsonParser.fromJson(r111, CJPayVoucherInfo.class);
        goto L52
    L44:
        r125 = false;
        goto L46
    L27:
        if (r109.length() <= 0) goto L29;
        boolean r126 = true;
    L31:
        if (Boolean.valueOf(r126).booleanValue() == true) goto L34;
        r109 = null;
    L34:
        if (r109 == null) goto L36;
        new CJPayVoucherInfo();
        r110 = (CJPayVoucherInfo) CJPayJsonParser.fromJson(r109, CJPayVoucherInfo.class);
        goto L37
    L29:
        r126 = false;
    L101:
        this.ext_info_pb = null;
        this.ext_info = r100;
    }

    public final AssetInfoBean clearCombineList() {
        this.asset_combine_pay_info.asset_to_combine_asset_info_list.clear();
        return this;
    }

    public final String defaultUniID() {
        return this.asset_meta_info.getUniqueSymbol();
    }

    public final AssetToCombineAssetInfoBean findDefaultCombineInfo() {
        ArrayList<AssetToCombineAssetInfoBean> r100 = this.asset_combine_pay_info.asset_to_combine_asset_info_list;
        if ((!r100.isEmpty()) == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L8;
        return null;
    L8:
        return (AssetToCombineAssetInfoBean) ListProtector.get(r100, 0);
    }

    public final String getAssetType() {
        return this.asset_meta_info.asset_type;
    }

    public final AssetInfoBean getChoosedSubAssetInfo() {
        Iterator<T> r100 = this.sub_asset_info_list.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Object r101 = r100.next();
        if (((AssetInfoBean) r101).asset_basic_show_info.choose == false) goto L4;
    L10:
        return (AssetInfoBean) r101;
    L8:
        r101 = null;
        goto L10
    }

    public final AssetInfoBean getDefaultChosenSubAssetInfo() {
        Iterator<T> r100 = this.sub_asset_info_list.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Object r101 = r100.next();
        if (((AssetInfoBean) r101).asset_basic_show_info.choose == false) goto L4;
    L9:
        AssetInfoBean r102 = (AssetInfoBean) r101;
        if (r102 == null) goto L12;
        return r102;
    L12:
        return (AssetInfoBean) CollectionsKt.firstOrNull(this.sub_asset_info_list);
    L8:
        r101 = null;
        goto L9
    }

    public final String getFunctionGuideMaterialKey() {
        return this.asset_extension_show_info.function_guidance_material.key;
    }

    public final int getIndex() {
        return this.asset_basic_show_info.index;
    }

    public final String getPaymentSelectionMaterialKey() {
        return this.asset_extension_show_info.payment_selection_material.key;
    }

    public final String getPromotionScene() {
        return this.asset_extension_show_info.promotion_scene;
    }

    public final AssetInfoBean getSelectedAsset() {
        ArrayList<AssetInfoBean> r100 = this.sub_asset_info_list;
        Object r101 = null;
        if ((!r100.isEmpty()) == true) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L18;
        Iterator<T> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        Object r103 = r102.next();
        if (((AssetInfoBean) r103).asset_basic_show_info.choose == false) goto L9;
        r101 = r103;
    L13:
        AssetInfoBean r104 = (AssetInfoBean) r101;
        if (r104 != null) goto L16;
        r104 = (AssetInfoBean) CollectionsKt.firstOrNull(r100);
    L16:
        if (r104 == null) goto L18;
        return r104;
    L18:
        return this;
    }

    public final String getSubTitle() {
        return KtSafeMethodExtensionKt.or(this.asset_extension_show_info.select_page_show_info.select_page_priority_sub_title, this.asset_basic_show_info.sub_title);
    }

    public final ArrayList<UIComponent> getTipsMsgInfo() {
        ArrayList<TipMsgInfoItem> r100 = this.asset_primary_show_info.tips_msg_info_list;
        if (r100.isEmpty() == false) goto L6;
        return null;
    L6:
        if (this.sub_asset_info_list.size() <= 0) goto L23;
        Iterator<T> r101 = this.sub_asset_info_list.iterator();
    L9:
        if (r101.hasNext() == false) goto L13;
        Object r102 = r101.next();
        if (((AssetInfoBean) r102).asset_basic_show_info.choose == false) goto L9;
    L14:
        AssetInfoBean r103 = (AssetInfoBean) r102;
        if (r103 != null) goto L17;
        r103 = (AssetInfoBean) CollectionsKt.getOrNull(this.sub_asset_info_list, 0);
    L17:
        if (r103 == null) goto L22;
        AssetExtensionShowInfo r104 = r103.asset_extension_show_info;
        if (r104 == null) goto L22;
        String r105 = r104.hit_tips_sub_type;
        if (r105 == null) goto L22;
    L25:
        if (r105.length() != 0) goto L27;
        boolean r106 = true;
    L28:
        if (r106 == false) goto L31;
        return null;
    L31:
        if (this.asset_basic_show_info.choose == false) goto L63;
        Iterator<T> r107 = r100.iterator();
    L34:
        if (r107.hasNext() == false) goto L45;
        Object r108 = r107.next();
        TipMsgInfoItem r109 = (TipMsgInfoItem) r108;
        if (Intrinsics.areEqual(r109.tips_sub_type, r105) == true) goto L40;
        if (Intrinsics.areEqual(r105, "any") == true) goto L40;
    L42:
        boolean r110 = false;
    L43:
        if (r110 == false) goto L34;
    L46:
        TipMsgInfoItem r111 = (TipMsgInfoItem) r108;
        if (r111 != null) goto L78;
        Iterator<T> r112 = r100.iterator();
    L50:
        if (r112.hasNext() == false) goto L61;
        Object r113 = r112.next();
        TipMsgInfoItem r114 = (TipMsgInfoItem) r113;
        if (Intrinsics.areEqual(r114.tips_sub_type, r105) == true) goto L56;
        if (Intrinsics.areEqual(r105, "any") == true) goto L56;
    L58:
        boolean r115 = false;
    L59:
        if (r115 == false) goto L50;
    L62:
        r111 = (TipMsgInfoItem) r113;
    L56:
        if (Intrinsics.areEqual(r114.display_option, "show_by_default") == false) goto L58;
        r115 = true;
        goto L59
    L61:
        r113 = null;
    L78:
        if (r111 != null) goto L80;
        return null;
    L80:
        ArrayList<CJPayUIComponent> r116 = r111.tips_info_list;
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator<T> r118 = r116.iterator();
    L82:
        if (r118.hasNext() == false) goto L85;
        r117.add(((CJPayUIComponent) r118.next()).toUIComponent());
        goto L82
    L85:
        return new ArrayList(r117);
    L40:
        if (Intrinsics.areEqual(r109.display_option, "show_on_click") == false) goto L42;
        r110 = true;
        goto L43
    L45:
        r108 = null;
        goto L46
    L63:
        Iterator<T> r119 = r100.iterator();
    L65:
        if (r119.hasNext() == false) goto L76;
        Object r120 = r119.next();
        TipMsgInfoItem r121 = (TipMsgInfoItem) r120;
        if (Intrinsics.areEqual(r121.tips_sub_type, r105) == true) goto L71;
        if (Intrinsics.areEqual(r105, "any") == true) goto L71;
    L73:
        boolean r122 = false;
    L74:
        if (r122 == false) goto L65;
    L77:
        r111 = (TipMsgInfoItem) r120;
    L71:
        if (Intrinsics.areEqual(r121.display_option, "show_by_default") == false) goto L73;
        r122 = true;
        goto L74
    L76:
        r120 = null;
        goto L77
    L27:
        r106 = false;
    L22:
        r105 = "";
        goto L25
    L13:
        r102 = null;
        goto L14
    L23:
        r105 = "any";
        goto L25
    }

    public final String getTitle() {
        return KtSafeMethodExtensionKt.or(this.asset_extension_show_info.select_page_show_info.select_page_priority_title, this.asset_basic_show_info.title);
    }

    public final ArrayList<AssetSelectPageGroupInfoBean> groupInfoList() {
        return this.asset_primary_show_info.asset_select_page_group_info_list;
    }

    public final boolean isBindCardPay() {
        if (this.asset_extension_show_info.jump_info.action == JumpInfoBean.Action.BindCard.getValue()) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual("1", this.asset_extension_show_info.jump_info.ext_map.need_pay) == false) goto L7;
        return true;
    }

    public final boolean isDirectBank() {
        AssetExtensionShowInfo r100 = this.asset_extension_show_info;
        if (r100 == null) goto L7;
        JumpInfoBean r101 = r100.jump_info;
        if (r101 == null) goto L7;
        String r102 = r101.action;
    L9:
        return Intrinsics.areEqual(r102, JumpInfoBean.Action.DirectBank.getValue());
    L7:
        r102 = null;
        goto L9
    }

    public final boolean isEnable() {
        return Intrinsics.areEqual("1", this.asset_basic_show_info.status);
    }

    public final boolean isForeignCard() {
        if (Intrinsics.areEqual(this.asset_basic_show_info.status, "1") == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.ext_info.is_foreign_card, "1") == false) goto L7;
        return true;
    }

    public final boolean isFunctionGuideChecked() {
        return this.asset_extension_show_info.function_guidance_material.is_checked;
    }

    public final boolean isHasJumpInfo() {
        if (this.asset_extension_show_info.jump_info.action.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isLimitAsset() {
        return Intrinsics.areEqual(this.asset_combine_pay_info.combine_fund_type, VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT);
    }

    public final boolean isNeedCombine() {
        if (Intrinsics.areEqual(this.asset_combine_pay_info.combine_fund_type, VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT) == true) goto L5;
    L7:
        return false;
    L5:
        if ((!this.asset_combine_pay_info.asset_to_combine_asset_info_list.isEmpty()) == false) goto L7;
        return true;
    }

    public final boolean isNeedJump() {
        return Intrinsics.areEqual(Notice.CLICK_TYPE_JUMP, this.asset_extension_show_info.select_page_show_info.select_page_select_type);
    }

    public final boolean isPaymentSelectionChecked() {
        return this.asset_extension_show_info.payment_selection_material.is_checked;
    }

    public final boolean isShowFunctionGuide() {
        if (this.asset_extension_show_info.function_guidance_material.key.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isShowPaymentSelectionMaterial() {
        if (this.asset_extension_show_info.payment_selection_material.key.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean showMoreDiscount() {
        HomePageVoucher r100 = this.asset_primary_show_info.home_page_voucher;
        if (r100 == null) goto L5;
        Boolean r101 = Boolean.valueOf(r100.show_more_discount);
    L6:
        if (r101 != null) goto L10;
        return false;
    L10:
        return r101.booleanValue();
    L5:
        r101 = null;
        goto L6
    }

    public AssetInfoBean() {
        this.asset_meta_info = new AssetMetaInfoBean();
        this.asset_basic_show_info = new AssetBasicShowInfoBean();
        this.asset_primary_show_info = new AssetPrimaryShowInfoBean();
        this.asset_extension_show_info = new AssetExtensionShowInfo();
        this.sub_asset_info_list = new ArrayList();
        this.asset_combine_pay_info = new AssetCombinePayInfoBean();
        this.ext_info = new ExtInfo();
    }

    private final boolean isValidCombineAssetInfo() {
        if (isNeedCombine() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.asset_combine_pay_info.asset_to_combine_asset_info_list.size() <= 0) goto L7;
        return true;
    }

    public final void clearStandardRecAmount() {
        if (isValidCombineAssetInfo() == false) goto L5;
        ((AssetToCombineAssetInfoBean) ListProtector.get(this.asset_combine_pay_info.asset_to_combine_asset_info_list, 0)).standard_show_amount = "";
        ((AssetToCombineAssetInfoBean) ListProtector.get(this.asset_combine_pay_info.asset_to_combine_asset_info_list, 0)).standard_show_amount_map.clear();
        return;
    L5:
        AssetExtensionShowInfo r100 = this.asset_extension_show_info;
        r100.standard_show_amount = "";
        r100.standard_show_amount_map.clear();
    }

    public final void clearStandardRecDesc() {
        if (isValidCombineAssetInfo() == false) goto L5;
        ((AssetToCombineAssetInfoBean) ListProtector.get(this.asset_combine_pay_info.asset_to_combine_asset_info_list, 0)).standard_rec_desc = "";
        ((AssetToCombineAssetInfoBean) ListProtector.get(this.asset_combine_pay_info.asset_to_combine_asset_info_list, 0)).standard_rec_desc_map.clear();
        return;
    L5:
        AssetExtensionShowInfo r100 = this.asset_extension_show_info;
        r100.standard_rec_desc = "";
        r100.standard_rec_desc_map.clear();
    }

    public final AssetInfoBean cp() {
        AssetInfoBean r100 = (AssetInfoBean) CJPayJsonParser.fromJson(CJPayJsonParser.toJsonObject(this), AssetInfoBean.class);
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new AssetInfoBean();
    }

    public final String getCombineSelectPageTitle() {
        if (isNeedCombine() == true) goto L5;
        return null;
    L5:
        return this.asset_combine_pay_info.select_page_title;
    }

    public final String getOptionMktAssetDefaultStatues() {
        if (isShowFunctionGuide() == false) goto L10;
        if (isFunctionGuideChecked() == false) goto L8;
        return "1";
    L8:
        return "0";
    L10:
        if (isShowPaymentSelectionMaterial() == true) goto L12;
        return "";
    L12:
        if (isPaymentSelectionChecked() == false) goto L15;
        return "1";
    L15:
        return "0";
    }

    public final String getOptionMktAssetSignStatues() {
        if (isShowFunctionGuide() == false) goto L7;
        return "0";
    L7:
        if (isShowPaymentSelectionMaterial() == false) goto L10;
        return "1";
    L10:
        return "";
    }

    public final String getOptionMktAssetType() {
        if (isShowFunctionGuide() == false) goto L7;
        return getFunctionGuideMaterialKey();
    L7:
        if (isShowPaymentSelectionMaterial() == true) goto L9;
        return "";
    L9:
        return getPaymentSelectionMaterialKey();
    }

    public final boolean isNeedJumpCombinePay() {
        if (isNeedJump() == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.asset_extension_show_info.jump_info.action, JumpInfoBean.Action.SwitchCombinePay.getValue()) == false) goto L7;
        return true;
    }

    public final boolean isRealDirectBank() {
        if (CJPaySettingsManager.getInstance().isDegradeRealDirectBank() == false) goto L7;
        return isDirectBank();
    L7:
        if (this.asset_meta_info.getExt().optBoolean("IsDirectBankCard", false) != true) goto L10;
        return true;
    L10:
        return false;
    }

    public final boolean isThirdPayment() {
        return CollectionsKt.mutableListOf(new String[]{"wx", "alipay"}).contains(this.asset_basic_show_info.primary_category);
    }

    public final String parseStandardRecAmount() {
        if (isValidCombineAssetInfo() == false) goto L6;
        return ((AssetToCombineAssetInfoBean) ListProtector.get(this.asset_combine_pay_info.asset_to_combine_asset_info_list, 0)).standard_show_amount;
    L6:
        return this.asset_extension_show_info.standard_show_amount;
    }

    public final String parseStandardRecDesc() {
        if (isValidCombineAssetInfo() == false) goto L6;
        return ((AssetToCombineAssetInfoBean) ListProtector.get(this.asset_combine_pay_info.asset_to_combine_asset_info_list, 0)).standard_rec_desc;
    L6:
        return this.asset_extension_show_info.standard_rec_desc;
    }

    public final HashMap<String, String> getExt_info_pb() {
        return this.ext_info_pb;
    }

    public final ArrayList<AssetInfoBean> subPayTypeInfoList() {
        return this.sub_asset_info_list;
    }

    public final AssetInfoBean findAssetInfo(String r100) {
        Iterator<T> r101 = this.sub_asset_info_list.iterator();
    L3:
        Object r102 = null;
        if (r101.hasNext() == false) goto L20;
        AssetInfoBean r103 = (AssetInfoBean) r101.next();
        if ((!r103.sub_asset_info_list.isEmpty()) == false) goto L18;
        Iterator<T> r104 = r103.sub_asset_info_list.iterator();
    L9:
        if (r104.hasNext() == false) goto L13;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((AssetInfoBean) r105).asset_meta_info.getUniqueSymbol(), r100) == false) goto L9;
        r102 = r105;
    L13:
        AssetInfoBean r106 = (AssetInfoBean) r102;
        if (r106 == null) goto L18;
        r106.asset_basic_show_info.choose = true;
        return r103;
    L18:
        if (Intrinsics.areEqual(r103.asset_meta_info.getUniqueSymbol(), r100) == false) goto L3;
        return r103;
    L20:
        return null;
    }

    public final AssetInfoBean findSubAssetInfo(Integer r100) {
        Iterator<T> r101 = this.sub_asset_info_list.iterator();
    L4:
        if (r101.hasNext() == false) goto L14;
        Object r102 = r101.next();
        int r103 = ((AssetInfoBean) r102).asset_basic_show_info.index;
        if (r100 != null) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == false) goto L4;
    L16:
        return (AssetInfoBean) r102;
    L9:
        if (r103 != r100.intValue()) goto L11;
        r104 = true;
        goto L12
    L14:
        r102 = null;
        goto L16
    }

    public final ArrayList<JSONObject> getProtocolJsonListByGroup(String r100) {
        Intrinsics.checkNotNullParameter(r100, "groupName");
        ArrayList<JSONObject> r101 = new ArrayList();
    L11:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("AssetInfoBean#getProtocolJsonListByGroup", e);
        CJBasicCommonUtils.logCatch("CJCatch", "AssetInfoBean#getProtocolJsonListByGroup", e);
    L13:
        return r101;
    L4:
        if (this.asset_extension_show_info.function_guidance_material.protocol_list.size() <= 0) goto L13;
        int r102 = this.asset_extension_show_info.function_guidance_material.protocol_list.size();     // Catch: Exception -> L11
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L13;
        if (Intrinsics.areEqual(r100, ((CJPayCardProtocolBean) ListProtector.get(this.asset_extension_show_info.function_guidance_material.protocol_list, r103)).group) == false) goto L10;
        r101.add(CJPayJsonParser.toJsonObject((CJPayObject) ListProtector.get(this.asset_extension_show_info.function_guidance_material.protocol_list, r103)));     // Catch: Exception -> L11
    L10:
        r103 = r103 + 1;
        goto L6
    }

    public final boolean match(AssetInfoBean r100) {
        String r101 = this.asset_meta_info.getUniqueSymbol();
        if (r100 == null) goto L7;
        AssetMetaInfoBean r102 = r100.asset_meta_info;
        if (r102 == null) goto L7;
        String r103 = r102.getUniqueSymbol();
    L9:
        return Intrinsics.areEqual(r101, r103);
    L7:
        r103 = null;
        goto L9
    }

    public final void setExt_info_pb(HashMap<String, String> r100) {
        this.ext_info_pb = r100;
    }

    public final void updatePromotionScene(String r100) {
        Intrinsics.checkNotNullParameter(r100, "promotionScene");
        this.asset_extension_show_info.promotion_scene = r100;
    }
}
