package com.android.ttcjpaysdk.bdpay.counter.outer.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.utils.CJUnifyPayEventUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020$J\u0006\u0010&\u001a\u00020$J\u0006\u0010'\u001a\u00020$J\u0006\u0010(\u001a\u00020$J\u0006\u0010)\u001a\u00020$J\u0006\u0010*\u001a\u00020$J\u0006\u0010+\u001a\u00020$R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0016j\b\u0012\u0004\u0012\u00020\r`\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0016j\b\u0012\u0004\u0012\u00020\u000b`\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPaySignInformation;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "active_tick", "", "background_style", "button_action", "deduct_method_sub_desc", "deduct_method_title", "first_asset_info", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/AssetInfo;", "first_pay_type_info", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/PayTypeItem;", "half_page_main_title", "logo_url", "merchant_name", "merchant_name_title", "multi_sign_info", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJPayMultiSignInfo;", "open_user_title", CJUnifyPayEventUtils.PARAM_KEY_PAY_TYPE_LIST, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "popup", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/Popup;", "screen_style", "service_describe", "service_describe_title", "service_name", "service_short_desc", "sign_page_desc_img", "sign_title_url", "specified_sort_asset_infos", ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, "hasBankCard", "", "isBindCard", "isFullScreen", "isNoMaskBg", "isSetPwd", "isShowDarkBg", "isSimpleHalfScreen", "isStandardHalfScreen", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPaySignInformation implements CJPayObject, Serializable {
    public String active_tick;
    public String background_style;
    public String button_action;
    public String deduct_method_sub_desc;
    public String deduct_method_title;
    public AssetInfo first_asset_info;
    public PayTypeItem first_pay_type_info;
    public String half_page_main_title;
    public String logo_url;
    public String merchant_name;
    public String merchant_name_title;
    public CJPayMultiSignInfo multi_sign_info;
    public String open_user_title;
    public ArrayList<PayTypeItem> pay_type_list;
    public Popup popup;
    public String screen_style;
    public String service_describe;
    public String service_describe_title;
    public String service_name;
    public String service_short_desc;
    public String sign_page_desc_img;
    public String sign_title_url;
    public ArrayList<AssetInfo> specified_sort_asset_infos;
    public String template_id;

    public final boolean hasBankCard() {
        Iterator<T> r100 = this.pay_type_list.iterator();
    L4:
        if (r100.hasNext() == false) goto L14;
        Object r101 = r100.next();
        PayTypeItem r102 = (PayTypeItem) r101;
        if (Intrinsics.areEqual(r102.card_type, "DEBIT") == false) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L4;
    L15:
        if (r101 == null) goto L23;
        return true;
    L23:
        return false;
    L8:
        if (Intrinsics.areEqual(r102.card_type, "CREDIT") == true) goto L11;
        r103 = false;
        goto L12
    L14:
        r101 = null;
        goto L15
    }

    public final boolean isBindCard() {
        return Intrinsics.areEqual("bind", this.button_action);
    }

    public final boolean isFullScreen() {
        return Intrinsics.areEqual("full_screen", this.screen_style);
    }

    public final boolean isNoMaskBg() {
        return Intrinsics.areEqual(this.background_style, "no_mask");
    }

    public final boolean isSetPwd() {
        return Intrinsics.areEqual("set_pwd", this.button_action);
    }

    public final boolean isShowDarkBg() {
        return Intrinsics.areEqual(this.background_style, "dark");
    }

    public final boolean isSimpleHalfScreen() {
        return Intrinsics.areEqual("simple_half_screen", this.screen_style);
    }

    public final boolean isStandardHalfScreen() {
        return Intrinsics.areEqual("standard_half_screen", this.screen_style);
    }

    public CJPaySignInformation() {
        this.logo_url = "";
        this.sign_title_url = "";
        this.service_name = "";
        this.merchant_name = "";
        this.merchant_name_title = "";
        this.service_describe_title = "";
        this.service_describe = "";
        this.deduct_method_title = "";
        this.deduct_method_sub_desc = "";
        this.pay_type_list = new ArrayList();
        this.specified_sort_asset_infos = new ArrayList();
        this.button_action = "";
        this.template_id = "";
        this.open_user_title = "";
        this.active_tick = "";
        this.service_short_desc = "";
        this.sign_page_desc_img = "";
        this.half_page_main_title = "";
        this.screen_style = "";
        this.background_style = "";
    }
}
