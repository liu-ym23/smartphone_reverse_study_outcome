package com.android.ttcjpaysdk.thirdparty.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayUIComponent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u00105\u001a\u000206J\u0006\u00107\u001a\u00020(J\u0006\u00108\u001a\u00020(J\u0006\u00109\u001a\u00020(J\u0006\u0010:\u001a\u00020(J\u0006\u0010;\u001a\u00020(R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R:\u0010\n\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R&\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001` 8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010'\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010+\u001a\u00020,8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0012\u00102\u001a\u0002038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00104\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CheckoutCounterCashDeskShowConf;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "bio_open_guide", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayBioOpenGuide;", "business_desc", "", "component_show_position_map", "Lcom/android/ttcjpaysdk/thirdparty/data/CashDeskShowConf$UnifyComponentShowPosition;", "component_show_position_map_pb", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getComponent_show_position_map_pb", "()Ljava/util/HashMap;", "setComponent_show_position_map_pb", "(Ljava/util/HashMap;)V", "confirm_btn_desc", "home_page_action", "", "home_page_background", "home_page_bg_show_logo", "home_page_bg_style", "home_page_notice", "home_page_style", "home_page_title", "home_page_update_version", "left_time", "", "page_info_title", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayUIComponent;", "Lkotlin/collections/ArrayList;", "page_pay_mode", "pwd_page_title", "query_result_time_s", "retain_show_style", "show_forget_pwd_button", "show_style", "show_trade_name", "", "show_user_avatar", "skip_confirm_show_verify_page", "theme", "Lcom/android/ttcjpaysdk/thirdparty/data/Theme;", "theme_pb", "getTheme_pb", "()Ljava/lang/String;", "setTheme_pb", "(Ljava/lang/String;)V", "user_agreement", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayUserAgreement;", "whether_show_left_time", "afterProtoDecode", "", "isConfirmHomepage", "isFrontHomepage", "isNoMaskBg", "isShowDarkBg", "shouldShowHomePageBgLogo", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutCounterCashDeskShowConf implements CJPayObject, Serializable {
    public CJPayBioOpenGuide bio_open_guide;
    public String business_desc;
    public CashDeskShowConf.UnifyComponentShowPosition component_show_position_map;
    private HashMap<String, String> component_show_position_map_pb;
    public String confirm_btn_desc;
    public int home_page_action;
    public String home_page_background;
    public String home_page_bg_show_logo;
    public String home_page_bg_style;
    public String home_page_notice;
    public int home_page_style;
    public String home_page_title;
    public String home_page_update_version;
    public long left_time;
    public ArrayList<CJPayUIComponent> page_info_title;
    public String page_pay_mode;
    public String pwd_page_title;
    public int query_result_time_s;
    public int retain_show_style;
    public String show_forget_pwd_button;
    public int show_style;
    public boolean show_trade_name;
    public boolean show_user_avatar;
    public String skip_confirm_show_verify_page;
    public Theme theme;
    private String theme_pb;
    public CJPayUserAgreement user_agreement;
    public boolean whether_show_left_time;

    public final void afterProtoDecode() {
        if (TextUtils.isEmpty(this.theme_pb) == true) goto L5;
        this.theme = (Theme) CJPayJsonParser.fromJson(this.theme_pb, Theme.class);
    L5:
        HashMap<String, String> r100 = this.component_show_position_map_pb;
        if (r100 == null) goto L11;
        CashDeskShowConf.UnifyComponentShowPosition r101 = new CashDeskShowConf.UnifyComponentShowPosition();
        String r102 = r100.get("pay_and_x");
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        r101.pay_and_x = r102;
    L12:
        this.component_show_position_map = r101;
        this.theme_pb = null;
        this.component_show_position_map_pb = null;
        return;
    L11:
        r101 = new CashDeskShowConf.UnifyComponentShowPosition();
        goto L12
    }

    public final boolean isConfirmHomepage() {
        return Intrinsics.areEqual("2", this.page_pay_mode);
    }

    public final boolean isFrontHomepage() {
        return Intrinsics.areEqual("1", this.page_pay_mode);
    }

    public final boolean isNoMaskBg() {
        return Intrinsics.areEqual(this.home_page_bg_style, "no_mask");
    }

    public final boolean isShowDarkBg() {
        return Intrinsics.areEqual(this.home_page_bg_style, "dark");
    }

    public final boolean shouldShowHomePageBgLogo() {
        return TextUtils.equals(this.home_page_bg_show_logo, "douying_pay");
    }

    public CheckoutCounterCashDeskShowConf() {
        this.user_agreement = new CJPayUserAgreement();
        this.theme = new Theme();
        this.home_page_title = "";
        this.home_page_background = "";
        this.home_page_notice = "";
        this.bio_open_guide = new CJPayBioOpenGuide();
        this.skip_confirm_show_verify_page = "0";
        this.home_page_update_version = "";
        this.pwd_page_title = "";
        this.home_page_bg_style = "";
        this.home_page_bg_show_logo = "";
        this.component_show_position_map = new CashDeskShowConf.UnifyComponentShowPosition();
        this.page_pay_mode = "";
        this.business_desc = "";
        this.show_forget_pwd_button = "";
    }

    public final HashMap<String, String> getComponent_show_position_map_pb() {
        return this.component_show_position_map_pb;
    }

    public final String getTheme_pb() {
        return this.theme_pb;
    }

    public final void setComponent_show_position_map_pb(HashMap<String, String> r100) {
        this.component_show_position_map_pb = r100;
    }

    public final void setTheme_pb(String r100) {
        this.theme_pb = r100;
    }
}
