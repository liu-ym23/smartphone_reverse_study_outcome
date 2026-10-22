package com.android.ttcjpaysdk.thirdparty.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.integrated.counter.data.PopUpInfo;
import com.bytedance.android.shopping.slice.action.entity.SendClosePdpEventParam;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0003456B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020\u0005J\u0006\u00101\u001a\u00020\u0005J\u0006\u00102\u001a\u00020\u0005J\u0006\u00103\u001a\u00020\u0007R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u00020'8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010(\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0012\u0010-\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CashDeskShowConf;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "auto_confirm", "", "business_desc", "", "callback_type", "compliance_btn_change_tag", "component_show_position_map", "Lcom/android/ttcjpaysdk/thirdparty/data/CashDeskShowConf$UnifyComponentShowPosition;", "confirm_btn_desc", "half_screen_upper_msg", "help_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CashDeskShowConf$HelpInfo;", "home_page_bg_style", "home_page_title", "is_show_discount_price", "jh_result_page_style", "left_time_s", "", "lynx_render_timeout", SendClosePdpEventParam.KEY_LYNX_URL, "popup_info", "Lcom/android/ttcjpaysdk/integrated/counter/data/PopUpInfo;", "pwd_page_title", "query_result_time_s", "", "remain_time_s", "result_page_show_style", "show_control", "Lcom/android/ttcjpaysdk/thirdparty/data/CashDeskShowConf$SdkShowControl;", "show_style", "show_trade_name", "show_user_avatar", "std_switch", "switch_show_type", "theme", "Lcom/android/ttcjpaysdk/thirdparty/data/Theme;", "theme_pb", "getTheme_pb", "()Ljava/lang/String;", "setTheme_pb", "(Ljava/lang/String;)V", "whether_show_left_time", "afterProtoDecode", "", "isAdapterButtonDesc", "isAfterQuery", "isStyle2", "needResultPage", "HelpInfo", "SdkShowControl", "UnifyComponentShowPosition", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CashDeskShowConf implements CJPayObject, Serializable {
    public boolean auto_confirm;
    public String business_desc;
    public String callback_type;
    public String compliance_btn_change_tag;
    public UnifyComponentShowPosition component_show_position_map;
    public String confirm_btn_desc;
    public String half_screen_upper_msg;
    public HelpInfo help_info;
    public String home_page_bg_style;
    public String home_page_title;
    public boolean is_show_discount_price;
    public String jh_result_page_style;
    public long left_time_s;
    public long lynx_render_timeout;
    public String lynx_url;
    public PopUpInfo popup_info;
    public String pwd_page_title;
    public int query_result_time_s;
    public long remain_time_s;
    public int result_page_show_style;
    public SdkShowControl show_control;
    public int show_style;
    public boolean show_trade_name;
    public boolean show_user_avatar;
    public String std_switch;
    public String switch_show_type;
    public Theme theme;
    private String theme_pb;
    public boolean whether_show_left_time;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CashDeskShowConf$HelpInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "content", "", "qq", "show_help", "", "tel", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class HelpInfo implements CJPayObject, Serializable {
        public String content;

        /* JADX INFO: renamed from: qq, reason: collision with root package name */
        public String f29844qq;
        public boolean show_help;
        public String tel;

        public HelpInfo() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CashDeskShowConf$SdkShowControl;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "ban_home_and_zg_retain", "", "open_sel_card_need_re_pre_consult", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SdkShowControl implements CJPayObject, Serializable {
        public boolean ban_home_and_zg_retain;
        public boolean open_sel_card_need_re_pre_consult;

        public SdkShowControl() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CashDeskShowConf$UnifyComponentShowPosition;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "pay_and_x", "", "Companion", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class UnifyComponentShowPosition implements CJPayObject {
        public static final Companion Companion = null;
        public static final String SHOW_BOTTOM = "bottom";
        public static final String SHOW_TOP = "top";
        public String pay_and_x;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CashDeskShowConf$UnifyComponentShowPosition$Companion;", "", "()V", "SHOW_BOTTOM", "", "SHOW_TOP", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

        public UnifyComponentShowPosition() {
            this.pay_and_x = "";
        }
    }

    public final boolean isStyle2() {
        if (2 != this.show_style) goto L5;
        return true;
    L5:
        return false;
    }

    public final void afterProtoDecode() {
        if (TextUtils.isEmpty(this.theme_pb) == true) goto L5;
        this.theme = (Theme) CJPayJsonParser.fromJson(this.theme_pb, Theme.class);
    L5:
        this.theme_pb = null;
    }

    public final boolean isAdapterButtonDesc() {
        return Intrinsics.areEqual("1", this.compliance_btn_change_tag);
    }

    public final boolean isAfterQuery() {
        return Intrinsics.areEqual("after_query", this.callback_type);
    }

    public final String needResultPage() {
        if (TextUtils.equals(this.jh_result_page_style, "1") == false) goto L6;
        return "0";
    L6:
        return "1";
    }

    public CashDeskShowConf() {
        this.theme = new Theme();
        this.popup_info = new PopUpInfo();
        this.help_info = new HelpInfo();
        this.jh_result_page_style = "0";
        this.callback_type = "";
        this.lynx_url = "";
        this.compliance_btn_change_tag = "0";
        this.switch_show_type = "";
        this.show_control = new SdkShowControl();
        this.std_switch = "";
        this.business_desc = "";
        this.home_page_title = "";
        this.pwd_page_title = "";
        this.home_page_bg_style = "";
        this.component_show_position_map = new UnifyComponentShowPosition();
    }

    public final String getTheme_pb() {
        return this.theme_pb;
    }

    public final void setTheme_pb(String r100) {
        this.theme_pb = r100;
    }
}
