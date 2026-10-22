package com.android.ttcjpaysdk.bdpay.paymentmethod.bean;

import android.text.TextUtils;
import com.alipay.sdk.m.x.d;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.ui.data.CJPayAddiItemInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayCreditPayMethods;
import com.android.ttcjpaysdk.base.ui.data.CJPayVoucherInfo;
import com.android.ttcjpaysdk.base.ui.data.FrontPayTypeData;
import com.android.ttcjpaysdk.base.ui.data.PayTypeVoucherMsgV2;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.vm.UnifyPreVerifySmsVM;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002¤\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0007\u0010¡\u0001\u001a\u00020%J\u0007\u0010¢\u0001\u001a\u00020%J\u0007\u0010£\u0001\u001a\u00020%R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R*\u0010*\u001a\u0012\u0012\u0004\u0012\u00020,0+j\b\u0012\u0004\u0012\u00020,`-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR\u001a\u00105\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010'\"\u0004\b7\u0010)R\u001a\u00108\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR\u001a\u0010;\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0015\"\u0004\b=\u0010\u0017R\u001a\u0010>\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010'\"\u0004\b?\u0010)R\u001a\u0010@\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010'\"\u0004\bA\u0010)R\u001a\u0010B\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010'\"\u0004\bC\u0010)R\u001a\u0010D\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0006\"\u0004\bF\u0010\bR\u001a\u0010G\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0006\"\u0004\bI\u0010\bR\u001a\u0010J\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0006\"\u0004\bL\u0010\bR\u001a\u0010M\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0006\"\u0004\bO\u0010\bR*\u0010P\u001a\u0012\u0012\u0004\u0012\u00020Q0+j\b\u0012\u0004\u0012\u00020Q`-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010/\"\u0004\bS\u00101R\u001a\u0010T\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0006\"\u0004\bV\u0010\bR\u001a\u0010W\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0006\"\u0004\bY\u0010\bR\u001a\u0010Z\u001a\u00020[X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001a\u0010`\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u0006\"\u0004\bb\u0010\bR\u001a\u0010c\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u0006\"\u0004\be\u0010\bR\u001a\u0010f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u0006\"\u0004\bh\u0010\bR\u001a\u0010i\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010'\"\u0004\bk\u0010)R\u001a\u0010l\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\u0006\"\u0004\bn\u0010\bR\u001a\u0010o\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\u0006\"\u0004\bq\u0010\bR\u001a\u0010r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u0006\"\u0004\bt\u0010\bR\u001a\u0010u\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\u0006\"\u0004\bw\u0010\bR\u001a\u0010x\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\u0006\"\u0004\bz\u0010\bR\u001a\u0010{\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010\u0015\"\u0004\b}\u0010\u0017R\u001b\u0010~\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010\u0006\"\u0005\b\u0080\u0001\u0010\bR\u001d\u0010\u0081\u0001\u001a\u00020%X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010'\"\u0005\b\u0083\u0001\u0010)R \u0010\u0084\u0001\u001a\u00030\u0085\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R \u0010\u008a\u0001\u001a\u00030\u008b\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R \u0010\u0090\u0001\u001a\u00030\u0091\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0006\b\u0094\u0001\u0010\u0095\u0001R-\u0010\u0096\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00040+j\b\u0012\u0004\u0012\u00020\u0004`-X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010/\"\u0005\b\u0098\u0001\u00101R?\u0010\u0099\u0001\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0005\u0012\u00030\u009b\u00010\u009a\u0001j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0005\u0012\u00030\u009b\u0001`\u009c\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010 \u0001¨\u0006¥\u0001"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/paymentmethod/bean/MethodPayTypeInfo;", "", "()V", "bank_card_id", "", "getBank_card_id", "()Ljava/lang/String;", "setBank_card_id", "(Ljava/lang/String;)V", "bank_code", "getBank_code", "setBank_code", "bank_name", "getBank_name", "setBank_name", "card_add_ext", "getCard_add_ext", "setCard_add_ext", "card_level", "", "getCard_level", "()I", "setCard_level", "(I)V", "card_no", "getCard_no", "setCard_no", "card_no_mask", "getCard_no_mask", "setCard_no_mask", "card_show_name", "getCard_show_name", "setCard_show_name", a.KEY_CARD_TYPE, "getCard_type", "setCard_type", "choose", "", "getChoose", "()Z", "setChoose", "(Z)V", "credit_pay_methods", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayCreditPayMethods;", "Lkotlin/collections/ArrayList;", "getCredit_pay_methods", "()Ljava/util/ArrayList;", "setCredit_pay_methods", "(Ljava/util/ArrayList;)V", "desc_title", "getDesc_title", "setDesc_title", "hasRetainRewardChanged", "getHasRetainRewardChanged", "setHasRetainRewardChanged", "icon_url", "getIcon_url", "setIcon_url", "index", "getIndex", "setIndex", "isShowLoading", "setShowLoading", "isUseAddiVoucher", "setUseAddiVoucher", "is_credit_activate", "set_credit_activate", UnifyPreVerifySmsVM.KEY_MOBILE_MASK, "getMobile_mask", "setMobile_mask", "msg", "getMsg", "setMsg", "new_bank_card_fold_desc", "getNew_bank_card_fold_desc", "setNew_bank_card_fold_desc", "origin_paymentType", "getOrigin_paymentType", "setOrigin_paymentType", "pay_addi_item_list", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayAddiItemInfo;", "getPay_addi_item_list", "setPay_addi_item_list", "paymentType", "getPaymentType", "setPaymentType", "perpay_limit", "getPerpay_limit", "setPerpay_limit", "promotion_show_priority", "Lcom/android/ttcjpaysdk/base/ui/data/FrontPayTypeData$PromotionShowPriority;", "getPromotion_show_priority", "()Lcom/android/ttcjpaysdk/base/ui/data/FrontPayTypeData$PromotionShowPriority;", "setPromotion_show_priority", "(Lcom/android/ttcjpaysdk/base/ui/data/FrontPayTypeData$PromotionShowPriority;)V", "select_page_guide_text", "getSelect_page_guide_text", "setSelect_page_guide_text", "share_asset_code", "getShare_asset_code", "setShare_asset_code", "share_asset_id", "getShare_asset_id", "setShare_asset_id", "show_combine_pay", "getShow_combine_pay", "setShow_combine_pay", "sign_no", "getSign_no", "setSign_no", "standardRecDesc", "getStandardRecDesc", "setStandardRecDesc", "standardShowAmount", "getStandardShowAmount", "setStandardShowAmount", "status", "getStatus", "setStatus", BdpAppEventConstant.PARAMS_SUB_TITLE, "getSub_title", "setSub_title", "tagBgColor", "getTagBgColor", "setTagBgColor", "title", "getTitle", d.f25925o, "useRetainReward", "getUseRetainReward", "setUseRetainReward", BytedCertConstant.IntentKey.VIEW_TYPE, "Lcom/android/ttcjpaysdk/bdpay/paymentmethod/bean/MethodPayTypeInfo$ViewType;", "getView_type", "()Lcom/android/ttcjpaysdk/bdpay/paymentmethod/bean/MethodPayTypeInfo$ViewType;", "setView_type", "(Lcom/android/ttcjpaysdk/bdpay/paymentmethod/bean/MethodPayTypeInfo$ViewType;)V", "voucherMsgV2", "Lcom/android/ttcjpaysdk/base/ui/data/PayTypeVoucherMsgV2;", "getVoucherMsgV2", "()Lcom/android/ttcjpaysdk/base/ui/data/PayTypeVoucherMsgV2;", "setVoucherMsgV2", "(Lcom/android/ttcjpaysdk/base/ui/data/PayTypeVoucherMsgV2;)V", "voucher_info", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayVoucherInfo;", "getVoucher_info", "()Lcom/android/ttcjpaysdk/base/ui/data/CJPayVoucherInfo;", "setVoucher_info", "(Lcom/android/ttcjpaysdk/base/ui/data/CJPayVoucherInfo;)V", "voucher_msg_list", "getVoucher_msg_list", "setVoucher_msg_list", "voucher_show_info", "Ljava/util/HashMap;", "Lcom/android/ttcjpaysdk/base/ui/data/FrontPayTypeData$VoucherShowInfo;", "Lkotlin/collections/HashMap;", "getVoucher_show_info", "()Ljava/util/HashMap;", "setVoucher_show_info", "(Ljava/util/HashMap;)V", "isCardInactive", "isEnable", "isNotNewBankCardShare", "ViewType", "bdpay-paymentmethod_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MethodPayTypeInfo {
    private String bank_card_id;
    private String bank_code;
    private String bank_name;
    private String card_add_ext;
    private int card_level;
    private String card_no;
    private String card_no_mask;
    private String card_show_name;
    private String card_type;
    private boolean choose;
    private ArrayList<CJPayCreditPayMethods> credit_pay_methods;
    private String desc_title;
    private boolean hasRetainRewardChanged;
    private String icon_url;
    private int index;
    private boolean isShowLoading;
    private boolean isUseAddiVoucher;
    private boolean is_credit_activate;
    private String mobile_mask;
    private String msg;
    private String new_bank_card_fold_desc;
    private String origin_paymentType;
    private ArrayList<CJPayAddiItemInfo> pay_addi_item_list;
    private String paymentType;
    private String perpay_limit;
    private FrontPayTypeData.PromotionShowPriority promotion_show_priority;
    private String select_page_guide_text;
    private String share_asset_code;
    private String share_asset_id;
    private boolean show_combine_pay;
    private String sign_no;
    private String standardRecDesc;
    private String standardShowAmount;
    private String status;
    private String sub_title;
    private int tagBgColor;
    private String title;
    private boolean useRetainReward;
    private ViewType view_type;
    private PayTypeVoucherMsgV2 voucherMsgV2;
    private CJPayVoucherInfo voucher_info;
    private ArrayList<String> voucher_msg_list;
    private HashMap<String, FrontPayTypeData.VoucherShowInfo> voucher_show_info;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/paymentmethod/bean/MethodPayTypeInfo$ViewType;", "", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "SPLIT_LINE", "FOLD_AREA", "bdpay-paymentmethod_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ViewType extends Enum<ViewType> {
        private static final /* synthetic */ ViewType[] $VALUES = null;
        public static final ViewType FOLD_AREA = null;
        public static final ViewType NORMAL = null;
        public static final ViewType SPLIT_LINE = null;

        private static final /* synthetic */ ViewType[] $values() {
            return new ViewType[]{NORMAL, SPLIT_LINE, FOLD_AREA};
        }

        public static ViewType valueOf(String r100) {
            return (ViewType) r27.a.a(ViewType.class, r100);
        }

        public static ViewType[] values() {
            return (ViewType[]) $VALUES.clone();
        }

        static {
            NORMAL = new ViewType(EffectConstants.NORMAL, 0);
            SPLIT_LINE = new ViewType("SPLIT_LINE", 1);
            FOLD_AREA = new ViewType("FOLD_AREA", 2);
            $VALUES = $values();
        }

        private ViewType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean isCardInactive() {
        if (this.card_level != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isEnable() {
        return Intrinsics.areEqual(this.status, "1");
    }

    public final boolean isNotNewBankCardShare() {
        if (TextUtils.equals(this.paymentType, "share_pay") == true) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(this.share_asset_code, CJPayConstant.CJ_PAY_SHARE_ASSET_CODE_NEW_BANK_CARD) == true) goto L7;
        return true;
    }

    public MethodPayTypeInfo() {
        this.icon_url = "";
        this.status = "";
        this.title = "";
        this.sub_title = "";
        this.msg = "";
        this.desc_title = "";
        this.bank_code = "";
        this.bank_card_id = "";
        this.card_type = "";
        this.card_add_ext = "";
        this.paymentType = "";
        this.origin_paymentType = "";
        this.voucher_msg_list = new ArrayList();
        this.voucher_info = new CJPayVoucherInfo();
        this.select_page_guide_text = "";
        this.view_type = ViewType.NORMAL;
        this.credit_pay_methods = new ArrayList();
        this.card_level = -1;
        this.new_bank_card_fold_desc = "";
        this.card_no = "";
        this.card_no_mask = "";
        this.card_show_name = "";
        this.perpay_limit = "";
        this.sign_no = "";
        this.standardRecDesc = "";
        this.standardShowAmount = "";
        this.mobile_mask = "";
        this.bank_name = "";
        this.voucherMsgV2 = new PayTypeVoucherMsgV2();
        this.share_asset_code = "";
        this.share_asset_id = "";
        this.pay_addi_item_list = new ArrayList();
        this.tagBgColor = -1;
        this.voucher_show_info = new HashMap();
        this.promotion_show_priority = new FrontPayTypeData.PromotionShowPriority();
    }

    public final String getBank_card_id() {
        return this.bank_card_id;
    }

    public final String getBank_code() {
        return this.bank_code;
    }

    public final String getBank_name() {
        return this.bank_name;
    }

    public final String getCard_add_ext() {
        return this.card_add_ext;
    }

    public final int getCard_level() {
        return this.card_level;
    }

    public final String getCard_no() {
        return this.card_no;
    }

    public final String getCard_no_mask() {
        return this.card_no_mask;
    }

    public final String getCard_show_name() {
        return this.card_show_name;
    }

    public final String getCard_type() {
        return this.card_type;
    }

    public final boolean getChoose() {
        return this.choose;
    }

    public final ArrayList<CJPayCreditPayMethods> getCredit_pay_methods() {
        return this.credit_pay_methods;
    }

    public final String getDesc_title() {
        return this.desc_title;
    }

    public final boolean getHasRetainRewardChanged() {
        return this.hasRetainRewardChanged;
    }

    public final String getIcon_url() {
        return this.icon_url;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getMobile_mask() {
        return this.mobile_mask;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getNew_bank_card_fold_desc() {
        return this.new_bank_card_fold_desc;
    }

    public final String getOrigin_paymentType() {
        return this.origin_paymentType;
    }

    public final ArrayList<CJPayAddiItemInfo> getPay_addi_item_list() {
        return this.pay_addi_item_list;
    }

    public final String getPaymentType() {
        return this.paymentType;
    }

    public final String getPerpay_limit() {
        return this.perpay_limit;
    }

    public final FrontPayTypeData.PromotionShowPriority getPromotion_show_priority() {
        return this.promotion_show_priority;
    }

    public final String getSelect_page_guide_text() {
        return this.select_page_guide_text;
    }

    public final String getShare_asset_code() {
        return this.share_asset_code;
    }

    public final String getShare_asset_id() {
        return this.share_asset_id;
    }

    public final boolean getShow_combine_pay() {
        return this.show_combine_pay;
    }

    public final String getSign_no() {
        return this.sign_no;
    }

    public final String getStandardRecDesc() {
        return this.standardRecDesc;
    }

    public final String getStandardShowAmount() {
        return this.standardShowAmount;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getSub_title() {
        return this.sub_title;
    }

    public final int getTagBgColor() {
        return this.tagBgColor;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean getUseRetainReward() {
        return this.useRetainReward;
    }

    public final ViewType getView_type() {
        return this.view_type;
    }

    public final PayTypeVoucherMsgV2 getVoucherMsgV2() {
        return this.voucherMsgV2;
    }

    public final CJPayVoucherInfo getVoucher_info() {
        return this.voucher_info;
    }

    public final ArrayList<String> getVoucher_msg_list() {
        return this.voucher_msg_list;
    }

    public final HashMap<String, FrontPayTypeData.VoucherShowInfo> getVoucher_show_info() {
        return this.voucher_show_info;
    }

    public final boolean isShowLoading() {
        return this.isShowLoading;
    }

    public final boolean isUseAddiVoucher() {
        return this.isUseAddiVoucher;
    }

    public final boolean is_credit_activate() {
        return this.is_credit_activate;
    }

    public final void setBank_card_id(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bank_card_id = r100;
    }

    public final void setBank_code(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bank_code = r100;
    }

    public final void setBank_name(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bank_name = r100;
    }

    public final void setCard_add_ext(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.card_add_ext = r100;
    }

    public final void setCard_level(int r100) {
        this.card_level = r100;
    }

    public final void setCard_no(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.card_no = r100;
    }

    public final void setCard_no_mask(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.card_no_mask = r100;
    }

    public final void setCard_show_name(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.card_show_name = r100;
    }

    public final void setCard_type(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.card_type = r100;
    }

    public final void setChoose(boolean r100) {
        this.choose = r100;
    }

    public final void setCredit_pay_methods(ArrayList<CJPayCreditPayMethods> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.credit_pay_methods = r100;
    }

    public final void setDesc_title(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.desc_title = r100;
    }

    public final void setHasRetainRewardChanged(boolean r100) {
        this.hasRetainRewardChanged = r100;
    }

    public final void setIcon_url(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.icon_url = r100;
    }

    public final void setIndex(int r100) {
        this.index = r100;
    }

    public final void setMobile_mask(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mobile_mask = r100;
    }

    public final void setMsg(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.msg = r100;
    }

    public final void setNew_bank_card_fold_desc(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.new_bank_card_fold_desc = r100;
    }

    public final void setOrigin_paymentType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.origin_paymentType = r100;
    }

    public final void setPay_addi_item_list(ArrayList<CJPayAddiItemInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pay_addi_item_list = r100;
    }

    public final void setPaymentType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.paymentType = r100;
    }

    public final void setPerpay_limit(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.perpay_limit = r100;
    }

    public final void setPromotion_show_priority(FrontPayTypeData.PromotionShowPriority r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.promotion_show_priority = r100;
    }

    public final void setSelect_page_guide_text(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.select_page_guide_text = r100;
    }

    public final void setShare_asset_code(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.share_asset_code = r100;
    }

    public final void setShare_asset_id(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.share_asset_id = r100;
    }

    public final void setShowLoading(boolean r100) {
        this.isShowLoading = r100;
    }

    public final void setShow_combine_pay(boolean r100) {
        this.show_combine_pay = r100;
    }

    public final void setSign_no(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.sign_no = r100;
    }

    public final void setStandardRecDesc(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.standardRecDesc = r100;
    }

    public final void setStandardShowAmount(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.standardShowAmount = r100;
    }

    public final void setStatus(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.status = r100;
    }

    public final void setSub_title(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.sub_title = r100;
    }

    public final void setTagBgColor(int r100) {
        this.tagBgColor = r100;
    }

    public final void setTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.title = r100;
    }

    public final void setUseAddiVoucher(boolean r100) {
        this.isUseAddiVoucher = r100;
    }

    public final void setUseRetainReward(boolean r100) {
        this.useRetainReward = r100;
    }

    public final void setView_type(ViewType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.view_type = r100;
    }

    public final void setVoucherMsgV2(PayTypeVoucherMsgV2 r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.voucherMsgV2 = r100;
    }

    public final void setVoucher_info(CJPayVoucherInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.voucher_info = r100;
    }

    public final void setVoucher_msg_list(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.voucher_msg_list = r100;
    }

    public final void setVoucher_show_info(HashMap<String, FrontPayTypeData.VoucherShowInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.voucher_show_info = r100;
    }

    public final void set_credit_activate(boolean r100) {
        this.is_credit_activate = r100;
    }
}
