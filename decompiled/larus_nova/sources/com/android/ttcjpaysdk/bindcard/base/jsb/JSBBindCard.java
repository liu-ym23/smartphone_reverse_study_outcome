package com.android.ttcjpaysdk.bindcard.base.jsb;

import android.app.Activity;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.eventbus.EventManager;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.android.ttcjpaysdk.base.h5.utils.CJPayXBridgeUtils;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPayNormalBindCardService;
import com.android.ttcjpaysdk.base.service.IUnionPayBindCardService;
import com.android.ttcjpaysdk.base.service.bean.NormalBindCardBean;
import com.android.ttcjpaysdk.base.ui.Utils.CJPayDyBrandLoadingUtils;
import com.android.ttcjpaysdk.bindcard.base.jsb.abs.AbsJsbBindCard;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J$\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\"\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0011H\u0014J0\u0010\u0019\u001a\u00020\u000f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u001b\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/jsb/JSBBindCard;", "Lcom/android/ttcjpaysdk/bindcard/base/jsb/abs/AbsJsbBindCard;", "()V", "hostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "callbackStruct", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod$CallbackStruct;", "getCheckInputParamsRuleMap", "", "", "Lkotlin/Function0;", "", "input", "Lcom/android/ttcjpaysdk/bindcard/base/jsb/abs/AbsJsbBindCard$BindCardInput;", "gotoCardBinPage", "", "callback", "Lcom/android/ttcjpaysdk/bindcard/base/jsb/abs/AbsJsbBindCard$BindCardOutput;", "gotoQuickBindCard", "cardInfo", "Lorg/json/JSONObject;", "realHandle", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", BdpAppEventConstant.PARAMS_OUTPUT, "unionPayBindCard", "createOrderData", "needLoading", "delayFinishMillis", "", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JSBBindCard extends AbsJsbBindCard {
    private final CJPayHostInfo hostInfo;

    public JSBBindCard() {
        this.hostInfo = new CJPayHostInfo();
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public AbsJSBMethod.CallbackStruct callbackStruct() {
        return AbsJSBMethod.CallbackStruct.ORIGINAL_WITH_WRAP_CJDATA;
    }

    private final void gotoCardBinPage(final AbsJsbBindCard.BindCardOutput r100) {
        ICJPayNormalBindCardService r101 = (ICJPayNormalBindCardService) CJPayServiceManager.getInstance().getIService(ICJPayNormalBindCardService.class);
        if (r101 != null) goto L5;
        return;
    L5:
        NormalBindCardBean r102 = new NormalBindCardBean();
        r102.setNeedAuthGuide(Boolean.FALSE);
        r102.setSource("wallet_bcard_manage");
        r102.setBizOrderType("card_sign");
        r102.setBindSourceType(4);
        r102.setCardBinAutoFocus(Boolean.TRUE);
        r102.setHostInfoJSON(CJPayHostInfo.Companion.toJson$default(CJPayHostInfo.Companion, this.hostInfo, null, 2, null));
        r102.setFront(true);
        r102.setType(ICJPayNormalBindCardService.SourceType.MyBindCard);
        Context r103 = this.hostInfo.getContext();
        if (r103 == null) goto L11;
        Activity r104 = CJPayBasicExtensionKt.toActivity(r103);
        if (r104 == null) goto L12;
        r101.startBindCardProcess(r104, ICJPayNormalBindCardService.BindCardType.TYPE_MY_BANK_CARD, r102, new JSBBindCard$gotoCardBinPage$1$1(r100));
        return;
    L12:
        return;
    }

    public Map<String, Function0<Boolean>> getCheckInputParamsRuleMap(AbsJsbBindCard.BindCardInput r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return MapsKt.emptyMap();
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ Map getCheckInputParamsRuleMap(IJSBParams r100) {
        return getCheckInputParamsRuleMap((AbsJsbBindCard.BindCardInput) r100);
    }

    private final void gotoQuickBindCard(JSONObject r100, final AbsJsbBindCard.BindCardOutput r101) {
        ICJPayNormalBindCardService r102 = (ICJPayNormalBindCardService) CJPayServiceManager.getInstance().getIService(ICJPayNormalBindCardService.class);
        if (r102 != null) goto L5;
        return;
    L5:
        NormalBindCardBean r103 = new NormalBindCardBean();
        r103.setBankItemInfo(r100);
        r103.setNeedAuthGuide(Boolean.FALSE);
        r103.setSource("wallet_bcard_manage");
        r103.setBizOrderType("card_sign");
        r103.setBindSourceType(5);
        r103.setHostInfoJSON(CJPayHostInfo.Companion.toJson$default(CJPayHostInfo.Companion, this.hostInfo, null, 2, null));
        r103.setFront(true);
        r103.setType(ICJPayNormalBindCardService.SourceType.MyBindCard);
        Context r104 = this.hostInfo.getContext();
        if (r104 == null) goto L11;
        Activity r105 = CJPayBasicExtensionKt.toActivity(r104);
        if (r105 == null) goto L12;
        r102.startBindCardProcess(r105, ICJPayNormalBindCardService.BindCardType.TYPE_QUICK_BIND_CARD_LIST, r103, new JSBBindCard$gotoQuickBindCard$1$1(r101));
        return;
    L12:
        return;
    }

    public void realHandle(Context r100, AbsJsbBindCard.BindCardInput r101, AbsJsbBindCard.BindCardOutput r110) {
        Intrinsics.checkNotNullParameter(r101, "input");
        Intrinsics.checkNotNullParameter(r110, BdpAppEventConstant.PARAMS_OUTPUT);
        HashMap<String, String> r102 = CJPayXBridgeUtils.convertJsonToMap(r101.riskInfoParams);
        this.hostInfo.setContext(r100);
        this.hostInfo.setRiskInfoParams(r102);
        CJPayHostInfo r103 = this.hostInfo;
        r103.appId = r101.app_id;
        r103.merchantId = r101.merchant_id;
        if (r100 == null) goto L30;
        Activity r104 = CJPayBasicExtensionKt.toActivity(r100);
        if (r104 != null) goto L7;
        return;
    L7:
        if ((r104 instanceof AppCompatActivity) == true) goto L10;
        r104 = null;
    L10:
        if (r104 == null) goto L32;
        String r105 = r101.bind_type;
        switch(r105.hashCode()) {
            case -1968768518: goto L26;
            case -589407473: goto L22;
            case 1975785499: goto L19;
            case 2021974886: goto L15;
            default: goto L37;
        };
    L37:
        return;
    L15:
        if (r105.equals("unionPayBindCard") == false) goto L38;
        unionPayBindCard$default(this, null, null, 0, r110, 7, null);
        return;
    L38:
        return;
    L19:
        if (r105.equals("bindCardHomePage") == false) goto L34;
        gotoCardBinPage(r110);
        return;
    L34:
        return;
    L22:
        if (r105.equals("unionPayBindCardFromFirstPage") == false) goto L39;
        unionPayBindCard(r101.create_order_data, r101.need_loading, r101.delay_on_success, r110);
        return;
    L39:
        return;
    L26:
        if (r105.equals("quickBindCard") == false) goto L40;
        gotoQuickBindCard(r101.card_info, r110);
        return;
    L40:
        return;
    L32:
        return;
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod
    public /* bridge */ /* synthetic */ void realHandle(Context r100, IJSBParams r101, JSBBaseOutput r102) {
        realHandle(r100, (AbsJsbBindCard.BindCardInput) r101, (AbsJsbBindCard.BindCardOutput) r102);
    }

    private final void unionPayBindCard(JSONObject r110, String r111, int r112, final AbsJsbBindCard.BindCardOutput r113) {
        IUnionPayBindCardService r100 = (IUnionPayBindCardService) CJPayServiceManager.getInstance().getIService(IUnionPayBindCardService.class);
        if (r100 == null) goto L18;
        Context r101 = this.hostInfo.getContext();
        if (r101 == null) goto L19;
        final Activity r102 = CJPayBasicExtensionKt.toActivity(r101);
        if (r102 == null) goto L20;
        EventManager r103 = EventManager.INSTANCE;
        r103.register(new JSBBindCard$unionPayBindCard$1$1$1(r102));
        r103.register(new JSBBindCard$unionPayBindCard$1$1$2(r113));
        if (r110 != null) goto L11;
        r100.createUnionPaySignOrderForBindCard(r102, new JSBBindCard$unionPayBindCard$1$1$3(r113), CJPayHostInfo.Companion.toJson$default(CJPayHostInfo.Companion, this.hostInfo, null, 2, null));
        return;
    L11:
        JSONObject r104 = r110.optJSONObject("sign_card_map");
        JSONObject r114 = r110.optJSONObject("busi_authorize_info");
        JSONObject r105 = r110.optJSONObject("union_pay_voucher");
        if (Intrinsics.areEqual(r111, "1") == false) goto L16;
        CJPayDyBrandLoadingUtils r106 = CJPayDyBrandLoadingUtils.INSTANCE;
        if (CJPayDyBrandLoadingUtils.showLoading$default(r106, r102, null, 2, null) == true) goto L16;
        CJPayDyBrandLoadingUtils.showOldLoading$default(r106, r102, false, null, null, 14, null);
    L16:
        r100.createUnionPaySignOrder(r102, r104, r114, r105, r112, JSBBindCard$unionPayBindCard$1$1$4.INSTANCE, CJPayHostInfo.Companion.toJson$default(CJPayHostInfo.Companion, this.hostInfo, null, 2, null));
        return;
    L20:
        return;
    L19:
        return;
    }

    public static /* synthetic */ void unionPayBindCard$default(JSBBindCard r100, JSONObject r101, String r102, int r103, AbsJsbBindCard.BindCardOutput r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = "0";
    L9:
        if ((r105 & 4) == 0) goto L11;
        r103 = 0;
    L11:
        r100.unionPayBindCard(r101, r102, r103, r104);
    }
}
