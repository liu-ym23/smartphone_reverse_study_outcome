package com.android.ttcjpaysdk.integrated.counter.component.logger;

import android.app.Activity;
import com.alipay.sdk.m.k.b;
import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.ui.Utils.AssetLogUtils;
import com.android.ttcjpaysdk.base.ui.data.AssetInfoBean;
import com.android.ttcjpaysdk.base.ui.widget.PayComponentView;
import com.android.ttcjpaysdk.base.utils.CJPayBasicUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.base.utils.CJWalletCashierBtmUtils;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.android.ttcjpaysdk.integrated.counter.component.config.DYPayType;
import com.android.ttcjpaysdk.integrated.counter.component.config.IDYPayType;
import com.android.ttcjpaysdk.integrated.counter.component.config.IPayType;
import com.android.ttcjpaysdk.integrated.counter.component.config.IPayTypeConfig;
import com.android.ttcjpaysdk.integrated.counter.component.config.PayType;
import com.android.ttcjpaysdk.integrated.counter.component.lynx.IPayTypeChangeInfo;
import com.android.ttcjpaysdk.integrated.counter.component.view.IPayTypeParams;
import com.android.ttcjpaysdk.integrated.counter.component.view.SelectFrom;
import com.android.ttcjpaysdk.integrated.counter.data.Balance;
import com.android.ttcjpaysdk.integrated.counter.data.Card;
import com.android.ttcjpaysdk.integrated.counter.data.MerchantInfo;
import com.android.ttcjpaysdk.integrated.counter.data.PayComponentBean;
import com.android.ttcjpaysdk.integrated.counter.data.PayTypeData;
import com.android.ttcjpaysdk.integrated.counter.data.PayTypeInfo;
import com.android.ttcjpaysdk.integrated.counter.data.PayTypeItemInfo;
import com.android.ttcjpaysdk.integrated.counter.data.PromotionProcessInfo;
import com.android.ttcjpaysdk.integrated.counter.data.QuickPay;
import com.android.ttcjpaysdk.integrated.counter.data.SubPayTypeInfo;
import com.android.ttcjpaysdk.integrated.counter.data.SubPayTypeSumInfo;
import com.android.ttcjpaysdk.integrated.counter.data.TradeInfo;
import com.android.ttcjpaysdk.integrated.counter.data.TypeItems;
import com.android.ttcjpaysdk.integrated.counter.data.UserInfo;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0016H\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u0006\u0010\u001f\u001a\u00020 J\u001a\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%J\"\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u000e2\b\u0010*\u001a\u0004\u0018\u00010\u0010J\u001c\u0010+\u001a\u00020 2\b\u0010)\u001a\u0004\u0018\u00010\u000e2\b\u0010*\u001a\u0004\u0018\u00010\u0010H\u0002J$\u0010,\u001a\u00020 *\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010-2\u0006\u0010.\u001a\u00020\u0017H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/logger/PayComponentLogger;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/app/Activity;", "componentBean", "Lcom/android/ttcjpaysdk/integrated/counter/data/PayComponentBean;", "(Landroid/app/Activity;Lcom/android/ttcjpaysdk/integrated/counter/data/PayComponentBean;)V", "getComponentBean", "()Lcom/android/ttcjpaysdk/integrated/counter/data/PayComponentBean;", "setComponentBean", "(Lcom/android/ttcjpaysdk/integrated/counter/data/PayComponentBean;)V", "getContext", "()Landroid/app/Activity;", "curComponentView", "Lcom/android/ttcjpaysdk/base/ui/widget/PayComponentView$IComponentView;", "curPayTypeParams", "Lcom/android/ttcjpaysdk/integrated/counter/component/view/IPayTypeParams;", "hasGotoSelectPayTypePage", "", "preComponentView", "prePayTypeParams", "getBizCommonLogParams", "", "", "getDYPayItemInfo", "Lcom/android/ttcjpaysdk/integrated/counter/data/TypeItems;", "getResignAction", "it", "Lcom/android/ttcjpaysdk/base/ui/data/AssetInfoBean;", "getUserInfo", "Lcom/android/ttcjpaysdk/integrated/counter/data/UserInfo;", "gotoSelectPayTypePage", "", "payComponentClick", "selectFrom", "Lcom/android/ttcjpaysdk/integrated/counter/component/view/SelectFrom;", "invokeData", "Lorg/json/JSONObject;", "payComponentImp", "show", "Lcom/android/ttcjpaysdk/integrated/counter/component/logger/PayComponentLogger$ShowType;", "componentView", "payTypeParams", "setHelperInterface", "onEvent", "", "event", "Companion", "ShowType", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PayComponentLogger {
    public static final Companion Companion = null;
    public static final String WALLET_CASHIER_COMBINE_PANEL_CLICK = "wallet_cashier_combine_panel_click";
    public static final String WALLET_CASHIER_COMBINE_PANEL_IMP = "wallet_cashier_combine_panel_imp";
    private PayComponentBean componentBean;
    private final Activity context;
    private PayComponentView.IComponentView curComponentView;
    private IPayTypeParams curPayTypeParams;
    private boolean hasGotoSelectPayTypePage;
    private PayComponentView.IComponentView preComponentView;
    private IPayTypeParams prePayTypeParams;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/logger/PayComponentLogger$Companion;", "", "()V", "WALLET_CASHIER_COMBINE_PANEL_CLICK", "", "WALLET_CASHIER_COMBINE_PANEL_IMP", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/logger/PayComponentLogger$ShowType;", "", "logKey", "", SocialConstants.PARAM_APP_DESC, "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getLogKey", "SHOW_TYPE1", "SHOW_TYPE2", "SHOW_TYPE3", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum ShowType extends Enum<ShowType> {
        private static final /* synthetic */ ShowType[] $VALUES = null;
        public static final ShowType SHOW_TYPE1 = null;
        public static final ShowType SHOW_TYPE2 = null;
        public static final ShowType SHOW_TYPE3 = null;
        private final String desc;
        private final String logKey;

        private static final /* synthetic */ ShowType[] $values() {
            return new ShowType[]{SHOW_TYPE1, SHOW_TYPE2, SHOW_TYPE3};
        }

        public static ShowType valueOf(String r100) {
            return (ShowType) a.a(ShowType.class, r100);
        }

        public static ShowType[] values() {
            return (ShowType[]) $VALUES.clone();
        }

        static {
            SHOW_TYPE1 = new ShowType("SHOW_TYPE1", 0, "1", "首次拉起面板");
            SHOW_TYPE2 = new ShowType("SHOW_TYPE2", 1, "2", "进入切换支付方式页后回到面板");
            SHOW_TYPE3 = new ShowType("SHOW_TYPE3", 2, "3", "强推区点击后重新曝光");
            $VALUES = $values();
        }

        public final String getDesc() {
            return this.desc;
        }

        public final String getLogKey() {
            return this.logKey;
        }

        private ShowType(String r100, int r101, String r102, String r103) {
            super(r100, r101);
            this.logKey = r102;
            this.desc = r103;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final void gotoSelectPayTypePage() {
        this.hasGotoSelectPayTypePage = true;
    }

    private final Map<String, Object> getBizCommonLogParams() {
        LinkedHashMap r100 = new LinkedHashMap();
        UserInfo r101 = getUserInfo();
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.auth_status;
    L6:
        String r104 = "";
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        r100.put("identity_type", r103);
        TypeItems r105 = getDYPayItemInfo();
        if (r105 == null) goto L16;
        PayTypeItemInfo r106 = r105.paytype_item;
        if (r106 == null) goto L16;
        PromotionProcessInfo r107 = r106.promotion_process;
        if (r107 == null) goto L16;
        String r108 = r107.process_id;
    L17:
        if (r108 != null) goto L19;
        r108 = "";
    L19:
        r100.put(CrashHianalyticsData.PROCESS_ID, r108);
        PayComponentBean r109 = this.componentBean;
        if (r109 == null) goto L24;
        TradeInfo r110 = r109.trade_info;
        if (r110 == null) goto L24;
        String r111 = r110.trade_no;
    L25:
        if (r111 != null) goto L27;
        r111 = "";
    L27:
        r100.put(b.B0, r111);
        PayComponentBean r112 = this.componentBean;
        if (r112 == null) goto L30;
        String r113 = r112.trace_id;
    L31:
        if (r113 != null) goto L33;
        r113 = "";
    L33:
        r100.put(BindCardPayConfirmConstants.Key.TRACE_ID, r113);
        UserInfo r114 = getUserInfo();
        if (r114 == null) goto L36;
        Integer r115 = (Integer) KtSafeMethodExtensionKt.tf(r114.is_new_user, 1, 0);
    L37:
        r100.put("is_new_user", r115);
        PayComponentBean r116 = this.componentBean;
        if (r116 == null) goto L52;
        JSONObject r117 = r116.fe_metrics;
        if (r117 == null) goto L52;
        Iterator<String> r118 = r117.keys();
        if (r118 == null) goto L52;
    L44:
        if (r118.hasNext() == false) goto L52;
        String r119 = r118.next();
        PayComponentBean r120 = this.componentBean;
        if (r120 == null) goto L50;
        JSONObject r121 = r120.fe_metrics;
        if (r121 == null) goto L50;
        Object r122 = r121.get(r119);
    L51:
        r100.put(r119, r122);
    L50:
        r122 = null;
    L52:
        PayComponentView.IComponentView r123 = this.curComponentView;
        if (r123 == null) goto L59;
        AssetInfoBean r124 = r123.getSelectedAssetInfo();
        if (r124 == null) goto L59;
        AssetInfoBean.AssetMetaInfoBean r125 = r124.asset_meta_info;
        if (r125 == null) goto L59;
        String r126 = r125.asset_type;
    L60:
        r100.put(e.f25671s, r126);
        PayComponentBean r127 = this.componentBean;
        if (r127 == null) goto L65;
        IPayTypeConfig<? extends IPayType, ? extends IDYPayType, ? extends IPayTypeChangeInfo> r128 = r127.buildDefaultPayTypeConfig();
        if (r128 == null) goto L65;
        String r129 = r128.getLogMethod();
    L66:
        r100.put("default_method", r129);
        PayComponentBean r130 = this.componentBean;
        if (r130 == null) goto L69;
        Boolean r131 = Boolean.valueOf(r130.isAssetStd());
    L70:
        if (r131 == null) goto L72;
        boolean r132 = r131.booleanValue();
    L74:
        if (r132 == false) goto L97;
        TypeItems r133 = getDYPayItemInfo();
        if (r133 == null) goto L93;
        PayTypeItemInfo r134 = r133.paytype_item;
        if (r134 == null) goto L93;
        AssetInfoBean r135 = r134.getAssetInfo();
        if (r135 == null) goto L93;
        ArrayList<AssetInfoBean> r136 = r135.sub_asset_info_list;
        if (r136 == null) goto L93;
        if (r136.isEmpty() == false) goto L86;
    L85:
        boolean r137 = false;
    L92:
        String r138 = (String) KtSafeMethodExtensionKt.tf(r137, "1", "0");
    L94:
        if (r138 != null) goto L96;
        r138 = "";
    L96:
        r100.put("is_bankcard", r138);
    L127:
        TypeItems r139 = getDYPayItemInfo();
        if (r139 == null) goto L136;
        PayTypeItemInfo r140 = r139.paytype_item;
        if (r140 == null) goto L136;
        PayTypeInfo r141 = r140.paytype_info;
        if (r141 == null) goto L136;
        Balance r142 = r141.balance;
        if (r142 == null) goto L136;
        String r143 = r142.status;
    L137:
        r100.put("is_balavailable", KtSafeMethodExtensionKt.tf(Intrinsics.areEqual(r143, "1"), 1, 0));
        r100.put("is_have_balance", "");
        PayComponentBean r144 = this.componentBean;
        if (r144 == null) goto L142;
        TradeInfo r145 = r144.trade_info;
        if (r145 == null) goto L142;
        String r146 = r145.stat_info;
    L143:
        r100.put("dy_charge_scene", KtSafeMethodExtensionKt.safeCreate(KtSafeMethodExtensionKt.or(r146, SliceInitService.DEFAULT_SWITCH)).optString("scene"));
        PayComponentBean r147 = this.componentBean;
        if (r147 == null) goto L148;
        PayComponentBean.OrderInfo r148 = r147.order_info;
        if (r148 == null) goto L148;
        String r149 = r148.trade_amount;
    L149:
        if (r149 != null) goto L151;
        r149 = "";
    L151:
        r100.put("amount", r149);
        TypeItems r150 = getDYPayItemInfo();
        if (r150 == null) goto L173;
        PayTypeItemInfo r151 = r150.paytype_item;
        if (r151 == null) goto L173;
        PayTypeInfo r152 = r151.paytype_info;
        if (r152 == null) goto L173;
        SubPayTypeSumInfo r153 = r152.sub_pay_type_sum_info;
        if (r153 == null) goto L173;
        ArrayList<SubPayTypeInfo> r154 = r153.sub_pay_type_info_list;
        if (r154 == null) goto L173;
        Iterator<T> r155 = r154.iterator();
    L163:
        if (r155.hasNext() == false) goto L167;
        Object r156 = r155.next();
        if (Intrinsics.areEqual(((SubPayTypeInfo) r156).sub_pay_type, DYPayType.BALANCE.getType()) == false) goto L163;
    L168:
        SubPayTypeInfo r157 = (SubPayTypeInfo) r156;
        if (r157 == null) goto L173;
        PayTypeData r158 = r157.pay_type_data;
        if (r158 == null) goto L173;
        Boolean r159 = Boolean.valueOf(r158.show_combine_pay);
    L174:
        if (r159 == null) goto L176;
        boolean r160 = r159.booleanValue();
    L177:
        r100.put("is_comavailable", KtSafeMethodExtensionKt.tf(r160, 1, 0));
        r100.put("show_style", "8");
        r100.put("cashier_source", "0");
        TypeItems r161 = getDYPayItemInfo();
        if (r161 == null) goto L197;
        PayTypeItemInfo r162 = r161.paytype_item;
        if (r162 == null) goto L197;
        PayTypeInfo r163 = r162.paytype_info;
        if (r163 == null) goto L197;
        SubPayTypeSumInfo r164 = r163.sub_pay_type_sum_info;
        if (r164 == null) goto L197;
        ArrayList<SubPayTypeInfo> r165 = r164.sub_pay_type_info_list;
        if (r165 == null) goto L197;
        Iterator<T> r166 = r165.iterator();
    L189:
        if (r166.hasNext() == false) goto L193;
        Object r167 = r166.next();
        if (Intrinsics.areEqual(((SubPayTypeInfo) r167).sub_pay_type, DYPayType.INCOME.getType()) == false) goto L189;
    L194:
        SubPayTypeInfo r168 = (SubPayTypeInfo) r167;
        if (r168 == null) goto L197;
        String r169 = r168.status;
    L198:
        r100.put("is_incomeavailable", KtSafeMethodExtensionKt.tf(Intrinsics.areEqual(r169, "1"), 1, 0));
        TypeItems r170 = getDYPayItemInfo();
        if (r170 == null) goto L220;
        PayTypeItemInfo r171 = r170.paytype_item;
        if (r171 == null) goto L220;
        PayTypeInfo r172 = r171.paytype_info;
        if (r172 == null) goto L220;
        SubPayTypeSumInfo r173 = r172.sub_pay_type_sum_info;
        if (r173 == null) goto L220;
        ArrayList<SubPayTypeInfo> r174 = r173.sub_pay_type_info_list;
        if (r174 == null) goto L220;
        Iterator<T> r175 = r174.iterator();
    L210:
        if (r175.hasNext() == false) goto L214;
        Object r176 = r175.next();
        if (Intrinsics.areEqual(((SubPayTypeInfo) r176).sub_pay_type, DYPayType.INCOME.getType()) == false) goto L210;
    L215:
        SubPayTypeInfo r177 = (SubPayTypeInfo) r176;
        if (r177 == null) goto L220;
        PayTypeData r178 = r177.pay_type_data;
        if (r178 == null) goto L220;
        Boolean r179 = Boolean.valueOf(r178.show_combine_pay);
    L221:
        if (r179 == null) goto L223;
        boolean r180 = r179.booleanValue();
    L224:
        r100.put("is_comavailable_income", KtSafeMethodExtensionKt.tf(r180, 1, 0));
        TypeItems r181 = getDYPayItemInfo();
        if (r181 == null) goto L227;
        r102 = r181.tips_msg;
    L227:
        if (r102 == null) goto L230;
        r104 = r102;
    L230:
        r100.put("tips_msg", r104);
        if (CJPayBasicUtils.getAbsolutePhysicalWidthOfScreen(this.context) <= CJPayBasicUtils.getScreenHeight(this.context)) goto L233;
        boolean r182 = true;
    L234:
        r100.put("landscape", KtSafeMethodExtensionKt.tf(r182, 1, 0));
        return r100;
    L233:
        r182 = false;
        goto L234
    L223:
        r180 = false;
        goto L224
    L214:
        r176 = null;
    L220:
        r179 = null;
        goto L221
    L193:
        r167 = null;
    L197:
        r169 = null;
        goto L198
    L176:
        r160 = false;
        goto L177
    L167:
        r156 = null;
    L173:
        r159 = null;
    L148:
        r149 = null;
    L142:
        r146 = null;
    L136:
        r143 = null;
        goto L137
    L86:
        Iterator<T> r183 = r136.iterator();
    L88:
        if (r183.hasNext() == false) goto L85;
        if (Intrinsics.areEqual(((AssetInfoBean) r183.next()).asset_meta_info.asset_type, "BANKCARD") == false) goto L88;
        r137 = true;
    L93:
        r138 = null;
        goto L94
    L97:
        TypeItems r184 = getDYPayItemInfo();
        if (r184 == null) goto L123;
        PayTypeItemInfo r185 = r184.paytype_item;
        if (r185 == null) goto L123;
        PayTypeInfo r186 = r185.paytype_info;
        if (r186 == null) goto L123;
        QuickPay r187 = r186.quick_pay;
        if (r187 == null) goto L123;
        ArrayList<Card> r188 = r187.cards;
        if (r188 == null) goto L123;
        if (r188.isEmpty() == false) goto L110;
    L109:
        boolean r189 = false;
    L122:
        String r190 = (String) KtSafeMethodExtensionKt.tf(r189, "1", "0");
    L124:
        if (r190 != null) goto L126;
        r190 = "";
    L126:
        r100.put("is_bankcard", r190);
        goto L127
    L110:
        Iterator<T> r191 = r188.iterator();
    L112:
        if (r191.hasNext() == false) goto L109;
        String r192 = ((Card) r191.next()).bank_card_id;
        if (r192 == null) goto L116;
        Boolean r193 = Boolean.valueOf(!StringsKt.isBlank(r192));
    L117:
        if (r193 == null) goto L119;
        boolean r194 = r193.booleanValue();
    L120:
        if (r194 == false) goto L112;
        r189 = true;
        goto L122
    L119:
        r194 = false;
        goto L120
    L116:
        r193 = null;
    L123:
        r190 = null;
        goto L124
    L72:
        r132 = false;
        goto L74
    L69:
        r131 = null;
    L65:
        r129 = null;
    L59:
        r126 = null;
        goto L60
    L36:
        r115 = null;
        goto L37
    L30:
        r113 = null;
    L24:
        r111 = null;
    L16:
        r108 = null;
        goto L17
    L5:
        r103 = null;
        goto L6
    }

    private final TypeItems getDYPayItemInfo() {
        PayComponentBean r100 = this.componentBean;
        Object r101 = null;
        if (r100 == null) goto L17;
        ArrayList<TypeItems> r102 = r100.pay_type_items;
        if (r102 == null) goto L18;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L13;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((TypeItems) r104).ptcode, PayType.BYTEPAY.getPtcode()) == false) goto L8;
        r101 = r104;
    L13:
        return (TypeItems) r101;
    L18:
        return null;
    L17:
        return null;
    }

    private final UserInfo getUserInfo() {
        TypeItems r100 = getDYPayItemInfo();
        if (r100 == null) goto L7;
        PayTypeItemInfo r101 = r100.paytype_item;
        if (r101 == null) goto L7;
        return r101.user_info;
    L7:
        return null;
    }

    public final PayComponentBean getComponentBean() {
        return this.componentBean;
    }

    public final Activity getContext() {
        return this.context;
    }

    private final String getResignAction(AssetInfoBean r100) {
        AssetInfoBean.AssetExtensionShowInfo r101 = r100.asset_extension_show_info;
        if (r101.need_resign == false) goto L6;
        return "bank_resign";
    L6:
        return r101.jump_info.action;
    }

    public final void setComponentBean(PayComponentBean r100) {
        this.componentBean = r100;
    }

    public PayComponentLogger(Activity r100, PayComponentBean r101) {
        this.context = r100;
        this.componentBean = r101;
    }

    private final void onEvent(Map<String, ? extends Object> r100, String r101) {
        PayComponentBean r102 = this.componentBean;
        String r103 = null;
        if (r102 == null) goto L7;
        MerchantInfo r104 = r102.merchant_info;
        if (r104 == null) goto L7;
        String r105 = r104.merchant_id;
    L8:
        String r106 = "";
        if (r105 != null) goto L11;
        r105 = "";
    L11:
        if (r102 == null) goto L15;
        MerchantInfo r107 = r102.merchant_info;
        if (r107 == null) goto L15;
        r103 = r107.app_id;
    L15:
        if (r103 == null) goto L18;
        r106 = r103;
    L18:
        JSONObject r108 = CJPayParamsUtils.getCommonLogParams(r105, r106);
        if (r108 == null) goto L33;
        Iterator<Map.Entry<String, Object>> r109 = getBizCommonLogParams().entrySet().iterator();
    L22:
        if (r109.hasNext() == false) goto L24;
        Map.Entry<String, Object> r110 = r109.next();
        KtSafeMethodExtensionKt.safePut(r108, r110.getKey(), r110.getValue());
        goto L22
    L24:
        if (r100 == null) goto L29;
        Iterator<Map.Entry<String, ? extends Object>> r111 = r100.entrySet().iterator();
    L27:
        if (r111.hasNext() == false) goto L29;
        Map.Entry<String, ? extends Object> r112 = r111.next();
        KtSafeMethodExtensionKt.safePut(r108, r112.getKey(), r112.getValue());
    L29:
        CJPayCallBackCenter.getInstance().onEvent(r101, new JSONObject[]{r108});
        CJWalletCashierBtmUtils.INSTANCE.reportPayComponentBTM(this.context, r101, r108);
        return;
    L33:
        return;
    L7:
        r105 = null;
        goto L8
    }

    private final void setHelperInterface(PayComponentView.IComponentView r100, IPayTypeParams r101) {
        this.preComponentView = this.curComponentView;
        this.prePayTypeParams = this.curPayTypeParams;
        this.curComponentView = r100;
        this.curPayTypeParams = r101;
    }

    public final void payComponentClick(SelectFrom r110, JSONObject r111) {
        Intrinsics.checkNotNullParameter(r110, "selectFrom");
        IPayTypeParams r100 = this.curPayTypeParams;
        if (r100 == null) goto L20;
        PayComponentBean r101 = r100.fetchPayComponentBean();
        if (r101 == null) goto L20;
        ArrayList<TypeItems> r102 = r101.pay_type_items;
        if (r102 == null) goto L20;
        Iterator<T> r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L14;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(CJPayConstant.TT_CJ_PAY_KEY_FOR_BYTEPAY, ((TypeItems) r104).ptcode) == false) goto L10;
    L15:
        TypeItems r105 = (TypeItems) r104;
        if (r105 == null) goto L20;
        String r106 = r105.paytype_item_info;
        if (r106 == null) goto L20;
        JSONObject r107 = new JSONObject(r106);
    L21:
        if (r107 == null) goto L25;
        JSONObject r108 = JSONObjectProtectorUtils.getJSONObject(r107, "cashier_page_info");
        if (r108 == null) goto L25;
        JSONObject r109 = JSONObjectProtectorUtils.getJSONObject(r108, "asset_info");
    L26:
        if (r109 == null) goto L30;
        JSONObject r112 = JSONObjectProtectorUtils.getJSONObject(r109, "asset_primary_show_info");
        if (r112 == null) goto L30;
        Integer r113 = Integer.valueOf(JSONObjectProtectorUtils.getInt(r112, "home_page_show_num"));
    L31:
        AssetInfoBean r114 = (AssetInfoBean) CJPayJsonParser.fromJson(r109, AssetInfoBean.class);
        JSONArray r115 = new JSONArray();
        if (r114 == null) goto L47;
        ArrayList<AssetInfoBean> r116 = r114.sub_asset_info_list;
        if (r116 == null) goto L47;
        Iterator<T> r117 = r116.iterator();
    L37:
        if (r117.hasNext() == false) goto L47;
        AssetInfoBean r118 = (AssetInfoBean) r117.next();
        JSONObject r119 = AssetLogUtils.INSTANCE.parseAssetInfo(r118);
        KtSafeMethodExtensionKt.safePut(r119, "action", getResignAction(r118));
        if (r113 == null) goto L45;
        int r120 = r113.intValue();
        if (r120 > 0) goto L43;
        boolean r121 = true;
    L44:
        r113 = Integer.valueOf(r120 - 1);
        Boolean r122 = Boolean.valueOf(r121);
    L46:
        KtSafeMethodExtensionKt.safePut(r119, "is_default_fold", r122);
        r115.put(r119);
        goto L37
    L43:
        r121 = false;
        goto L44
    L45:
        r122 = null;
    L47:
        PayComponentView.IComponentView r123 = this.curComponentView;
        if (r123 == null) goto L50;
        AssetInfoBean r124 = r123.getSelectedAssetInfo();
    L51:
        AssetLogUtils r125 = AssetLogUtils.INSTANCE;
        JSONArray r126 = r125.getStdActivityInfo(r124, false);
        if (r114 == null) goto L54;
        ArrayList<AssetInfoBean> r127 = r114.sub_asset_info_list;
    L55:
        JSONArray r128 = r125.getStdCampaignInfo(r127);
        if (r114 == null) goto L58;
        ArrayList<AssetInfoBean> r129 = r114.sub_asset_info_list;
    L59:
        JSONArray r130 = r125.getMultipleDiscountCardsList(r129);
        if (r114 == null) goto L62;
        ArrayList<AssetInfoBean> r131 = r114.sub_asset_info_list;
    L63:
        JSONArray r132 = r125.getMultipleDiscountCampaignInfo(r131);
        String r133 = r125.getIsMultipleDiscountConfirm(r124);
        JSONArray r134 = r125.getMultipleDiscountActivityInfo(r124);
        Pair[] r135 = new Pair[15];
        r135[0] = TuplesKt.to("button_name", r110.getButtonName().getLogKey());
        r135[1] = TuplesKt.to("show_type", KtSafeMethodExtensionKt.tf(this.hasGotoSelectPayTypePage, ShowType.SHOW_TYPE2.getLogKey(), ShowType.SHOW_TYPE1.getLogKey()));
        PayComponentView.IComponentView r136 = this.preComponentView;
        if (r136 == null) goto L68;
        Pair<String, String> r137 = r136.getPayMethodDesc();
        if (r137 == null) goto L68;
        String r138 = r137.toString();
    L69:
        r135[2] = TuplesKt.to("prev_selected_title", r138);
        PayComponentView.IComponentView r139 = this.curComponentView;
        if (r139 == null) goto L74;
        Pair<String, String> r140 = r139.getPayMethodDesc();
        if (r140 == null) goto L74;
        String r141 = r140.toString();
    L75:
        r135[3] = TuplesKt.to("curr_selected_title", r141);
        if (r111 == null) goto L78;
        String r142 = r111.optString("trade_type");
    L79:
        r135[4] = TuplesKt.to("trade_type", r142);
        r135[5] = TuplesKt.to("byte_sub_pay_list", r115);
        r135[6] = TuplesKt.to("activity_info", r126);
        r135[7] = TuplesKt.to("campaign_info", r128);
        r135[8] = TuplesKt.to("is_duobijian_cards_list", r130);
        r135[9] = TuplesKt.to("duobijian_campaign_info", r132);
        r135[10] = TuplesKt.to("is_duobijian_confirm", r133);
        r135[11] = TuplesKt.to("duobijian_activity_info", r134);
        if (r124 == null) goto L84;
        AssetInfoBean.AssetMetaInfoBean r143 = r124.asset_meta_info;
        if (r143 == null) goto L84;
        String r144 = r143.asset_type;
    L85:
        r135[12] = TuplesKt.to("pre_method", r144);
        r135[13] = TuplesKt.to("first_bytepay_type", r115.optJSONObject(0));
        r135[14] = TuplesKt.to("second_bytepay_type", r115.optJSONObject(1));
        Map<String, ? extends Object> r145 = MapsKt.mutableMapOf(r135);
        PayComponentView.IComponentView r146 = this.curComponentView;
        if (r146 == null) goto L90;
        Map<String, Object> r147 = r146.getOnClickLogParams();
        if (r147 == null) goto L90;
        r145.putAll(r147);
    L90:
        onEvent(r145, WALLET_CASHIER_COMBINE_PANEL_CLICK);
        return;
    L84:
        r144 = null;
        goto L85
    L78:
        r142 = null;
    L74:
        r141 = null;
    L68:
        r138 = null;
        goto L69
    L62:
        r131 = null;
        goto L63
    L58:
        r129 = null;
        goto L59
    L54:
        r127 = null;
        goto L55
    L50:
        r124 = null;
    L30:
        r113 = null;
    L25:
        r109 = null;
        goto L26
    L14:
        r104 = null;
    L20:
        r107 = null;
        goto L21
    }

    public final void payComponentImp(ShowType r110, PayComponentView.IComponentView r111, IPayTypeParams r210) {
        Intrinsics.checkNotNullParameter(r110, "show");
        setHelperInterface(r111, r210);
        if (r210 == null) goto L20;
        PayComponentBean r100 = r210.fetchPayComponentBean();
        if (r100 == null) goto L20;
        ArrayList<TypeItems> r101 = r100.pay_type_items;
        if (r101 == null) goto L20;
        Iterator<T> r102 = r101.iterator();
    L10:
        if (r102.hasNext() == false) goto L14;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(CJPayConstant.TT_CJ_PAY_KEY_FOR_BYTEPAY, ((TypeItems) r103).ptcode) == false) goto L10;
    L15:
        TypeItems r104 = (TypeItems) r103;
        if (r104 == null) goto L20;
        String r105 = r104.paytype_item_info;
        if (r105 == null) goto L20;
        JSONObject r106 = new JSONObject(r105);
    L21:
        if (r106 == null) goto L25;
        JSONObject r107 = JSONObjectProtectorUtils.getJSONObject(r106, "cashier_page_info");
        if (r107 == null) goto L25;
        JSONObject r108 = JSONObjectProtectorUtils.getJSONObject(r107, "asset_info");
    L26:
        if (r108 == null) goto L30;
        JSONObject r109 = JSONObjectProtectorUtils.getJSONObject(r108, "asset_primary_show_info");
        if (r109 == null) goto L30;
        Integer r112 = Integer.valueOf(JSONObjectProtectorUtils.getInt(r109, "home_page_show_num"));
    L31:
        AssetInfoBean r113 = (AssetInfoBean) CJPayJsonParser.fromJson(r108, AssetInfoBean.class);
        JSONArray r114 = new JSONArray();
        if (r113 == null) goto L36;
        ArrayList<AssetInfoBean> r115 = r113.sub_asset_info_list;
        if (r115 == null) goto L36;
        Integer r116 = Integer.valueOf(r115.size());
    L38:
        if (r113 == null) goto L53;
        ArrayList<AssetInfoBean> r117 = r113.sub_asset_info_list;
        if (r117 == null) goto L53;
        Iterator<T> r118 = r117.iterator();
        Integer r119 = r112;
    L43:
        if (r118.hasNext() == false) goto L53;
        AssetInfoBean r120 = (AssetInfoBean) r118.next();
        JSONObject r121 = AssetLogUtils.INSTANCE.parseAssetInfo(r120);
        KtSafeMethodExtensionKt.safePut(r121, "action", getResignAction(r120));
        if (r119 == null) goto L51;
        int r122 = r119.intValue();
        if (r122 > 0) goto L49;
        boolean r123 = true;
    L50:
        r119 = Integer.valueOf(r122 - 1);
        Boolean r124 = Boolean.valueOf(r123);
    L52:
        KtSafeMethodExtensionKt.safePut(r121, "is_default_fold", r124);
        r114.put(r121);
        goto L43
    L49:
        r123 = false;
        goto L50
    L51:
        r124 = null;
    L53:
        PayComponentView.IComponentView r125 = this.curComponentView;
        if (r125 == null) goto L56;
        AssetInfoBean r126 = r125.getSelectedAssetInfo();
    L57:
        AssetLogUtils r127 = AssetLogUtils.INSTANCE;
        JSONArray r128 = r127.getStdActivityInfo(r126, false);
        if (r113 == null) goto L60;
        ArrayList<AssetInfoBean> r129 = r113.sub_asset_info_list;
    L61:
        JSONArray r130 = r127.getStdCampaignInfo(r129);
        if (r113 == null) goto L64;
        ArrayList<AssetInfoBean> r131 = r113.sub_asset_info_list;
    L65:
        JSONArray r132 = r127.getMultipleDiscountCardsList(r131);
        if (r113 == null) goto L68;
        ArrayList<AssetInfoBean> r133 = r113.sub_asset_info_list;
    L69:
        JSONArray r134 = r127.getMultipleDiscountCampaignInfo(r133);
        JSONArray r135 = r127.getMultipleDiscountActivityInfo(r126);
        Pair[] r136 = new Pair[16];
        if (r111 == null) goto L74;
        Pair<String, String> r137 = r111.getPayMethodDesc();
        if (r137 == null) goto L74;
        String r138 = r137.toString();
    L75:
        r136[0] = TuplesKt.to("pay_method", r138);
        if (r111 == null) goto L80;
        Pair<String, String> r139 = r111.getPromotionDesc();
        if (r139 == null) goto L80;
        String r140 = r139.getFirst();
    L81:
        String r141 = "";
        if (r140 != null) goto L84;
        r140 = "";
    L84:
        r136[1] = TuplesKt.to("discount_content", r140);
        if (r111 == null) goto L87;
        String r142 = r111.getRecommendDyDesc();
    L88:
        if (r142 == null) goto L91;
        r141 = r142;
    L91:
        r136[2] = TuplesKt.to("recommend_title", r141);
        r136[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_TYPE, "integral");
        StringBuilder r143 = new StringBuilder();
        if (r210 == null) goto L94;
        String r144 = r210.getBtnDesc();
    L95:
        r143.append(r144);
        if (r210 == null) goto L98;
        String r145 = r210.getPayAmount();
    L99:
        r143.append(r145);
        r136[4] = TuplesKt.to("button_content", r143.toString());
        r136[5] = TuplesKt.to("show_type", r110.getLogKey());
        r136[6] = TuplesKt.to("byte_sub_pay_list", r114);
        if (r112 == null) goto L104;
        int r146 = r112.intValue();
        if (r116 == null) goto L104;
        Integer r147 = Integer.valueOf(r116.intValue() - r146);
    L105:
        r136[7] = TuplesKt.to("byte_show_fold_method_icon_cnt", r147);
        r136[8] = TuplesKt.to("activity_info", r128);
        r136[9] = TuplesKt.to("campaign_info", r130);
        r136[10] = TuplesKt.to("is_duobijian_cards_list", r132);
        r136[11] = TuplesKt.to("duobijian_campaign_info", r134);
        r136[12] = TuplesKt.to("duobijian_activity_info", r135);
        if (r126 == null) goto L110;
        AssetInfoBean.AssetMetaInfoBean r148 = r126.asset_meta_info;
        if (r148 == null) goto L110;
        String r149 = r148.asset_type;
    L111:
        r136[13] = TuplesKt.to("pre_method", r149);
        r136[14] = TuplesKt.to("first_bytepay_type", r114.optJSONObject(0));
        r136[15] = TuplesKt.to("second_bytepay_type", r114.optJSONObject(1));
        onEvent(MapsKt.mapOf(r136), WALLET_CASHIER_COMBINE_PANEL_IMP);
        return;
    L110:
        r149 = null;
    L104:
        r147 = null;
        goto L105
    L98:
        r145 = null;
        goto L99
    L94:
        r144 = null;
        goto L95
    L87:
        r142 = null;
    L80:
        r140 = null;
    L74:
        r138 = null;
        goto L75
    L68:
        r133 = null;
        goto L69
    L64:
        r131 = null;
        goto L65
    L60:
        r129 = null;
        goto L61
    L56:
        r126 = null;
    L36:
        r116 = null;
    L30:
        r112 = null;
    L25:
        r108 = null;
        goto L26
    L14:
        r103 = null;
    L20:
        r106 = null;
        goto L21
    }

    public static /* synthetic */ void payComponentClick$default(PayComponentLogger r100, SelectFrom r101, JSONObject r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.payComponentClick(r101, r102);
    }
}
