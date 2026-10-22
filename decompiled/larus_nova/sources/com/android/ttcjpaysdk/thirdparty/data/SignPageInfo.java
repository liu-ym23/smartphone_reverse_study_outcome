package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayCardProtocolBean;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u00012\u00020\u0002BÝ\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012$\b\u0002\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000fj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0010\u0012\u0018\b\u0002\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u0012\b\b\u0002\u0010 \u001a\u00020\u0006\u0012\b\b\u0002\u0010!\u001a\u00020\u0006\u0012\b\b\u0002\u0010\"\u001a\u00020\u0006\u0012\b\b\u0002\u0010#\u001a\u00020\u0006\u0012\b\b\u0002\u0010$\u001a\u00020\u0006\u0012\b\b\u0002\u0010%\u001a\u00020\u0006\u0012\b\b\u0002\u0010&\u001a\u00020\u0006\u0012\b\b\u0002\u0010'\u001a\u00020\u0006¢\u0006\u0002\u0010(R\u0012\u0010!\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\"\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010'\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000fj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/SignPageInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "trade_amount", "", "merchant_name", "", "real_trade_amount", "icon", "promotion_desc", "deduct_date_desc", "only_pay_flag", "only_pay_desc", "deduct_method_desc", "protocol_group_names", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "protocol_info", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayCardProtocolBean;", "Lkotlin/collections/ArrayList;", "button_action", "button_desc", "service_desc", "service_name", ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, "page_title", "deduct_method_sub_desc", "sign_page_url", "next_deduct_date", "pay_sign_switch", "pay_sign_switch_info", "show_style", "activity_info_desc", "activity_info_desc_prefix", "supply_promotion_desc", "upper_icon", "upper_desc", "supply_promotion_label", "origin_trade_amount_show", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SignPageInfo implements CJPayObject, Serializable {
    public String activity_info_desc;
    public String activity_info_desc_prefix;
    public String button_action;
    public String button_desc;
    public String deduct_date_desc;
    public String deduct_method_desc;
    public String deduct_method_sub_desc;
    public String icon;
    public String merchant_name;
    public String next_deduct_date;
    public String only_pay_desc;
    public String only_pay_flag;
    public String origin_trade_amount_show;
    public String page_title;
    public String pay_sign_switch;
    public String pay_sign_switch_info;
    public String promotion_desc;
    public HashMap<String, String> protocol_group_names;
    public ArrayList<CJPayCardProtocolBean> protocol_info;
    public int real_trade_amount;
    public String service_desc;
    public String service_name;
    public String show_style;
    public String sign_page_url;
    public String supply_promotion_desc;
    public String supply_promotion_label;
    public String template_id;
    public int trade_amount;
    public String upper_desc;
    public String upper_icon;

    public SignPageInfo() {
        this(0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1073741823, null);
    }

    public SignPageInfo(int r110, String r111, int r112, String r210, String r211, String r212, String r213, String r214, String r215, HashMap<String, String> r216, ArrayList<CJPayCardProtocolBean> r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, String r318, String r319, String r410, String r411, String r412, String r413, String r414, String r415, String r416) {
        Intrinsics.checkNotNullParameter(r111, "merchant_name");
        Intrinsics.checkNotNullParameter(r210, "icon");
        Intrinsics.checkNotNullParameter(r211, "promotion_desc");
        Intrinsics.checkNotNullParameter(r212, "deduct_date_desc");
        Intrinsics.checkNotNullParameter(r213, "only_pay_flag");
        Intrinsics.checkNotNullParameter(r214, "only_pay_desc");
        Intrinsics.checkNotNullParameter(r215, "deduct_method_desc");
        Intrinsics.checkNotNullParameter(r216, "protocol_group_names");
        Intrinsics.checkNotNullParameter(r217, "protocol_info");
        Intrinsics.checkNotNullParameter(r218, "button_action");
        Intrinsics.checkNotNullParameter(r219, "button_desc");
        Intrinsics.checkNotNullParameter(r310, "service_desc");
        Intrinsics.checkNotNullParameter(r311, "service_name");
        Intrinsics.checkNotNullParameter(r312, ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID);
        Intrinsics.checkNotNullParameter(r313, "page_title");
        Intrinsics.checkNotNullParameter(r314, "deduct_method_sub_desc");
        Intrinsics.checkNotNullParameter(r315, "sign_page_url");
        Intrinsics.checkNotNullParameter(r316, "next_deduct_date");
        Intrinsics.checkNotNullParameter(r317, "pay_sign_switch");
        Intrinsics.checkNotNullParameter(r318, "pay_sign_switch_info");
        Intrinsics.checkNotNullParameter(r319, "show_style");
        Intrinsics.checkNotNullParameter(r410, "activity_info_desc");
        Intrinsics.checkNotNullParameter(r411, "activity_info_desc_prefix");
        Intrinsics.checkNotNullParameter(r412, "supply_promotion_desc");
        Intrinsics.checkNotNullParameter(r413, "upper_icon");
        Intrinsics.checkNotNullParameter(r414, "upper_desc");
        Intrinsics.checkNotNullParameter(r415, "supply_promotion_label");
        Intrinsics.checkNotNullParameter(r416, "origin_trade_amount_show");
        this.trade_amount = r110;
        this.merchant_name = r111;
        this.real_trade_amount = r112;
        this.icon = r210;
        this.promotion_desc = r211;
        this.deduct_date_desc = r212;
        this.only_pay_flag = r213;
        this.only_pay_desc = r214;
        this.deduct_method_desc = r215;
        this.protocol_group_names = r216;
        this.protocol_info = r217;
        this.button_action = r218;
        this.button_desc = r219;
        this.service_desc = r310;
        this.service_name = r311;
        this.template_id = r312;
        this.page_title = r313;
        this.deduct_method_sub_desc = r314;
        this.sign_page_url = r315;
        this.next_deduct_date = r316;
        this.pay_sign_switch = r317;
        this.pay_sign_switch_info = r318;
        this.show_style = r319;
        this.activity_info_desc = r410;
        this.activity_info_desc_prefix = r411;
        this.supply_promotion_desc = r412;
        this.upper_icon = r413;
        this.upper_desc = r414;
        this.supply_promotion_label = r415;
        this.origin_trade_amount_show = r416;
    }

    public /* synthetic */ SignPageInfo(int r310, String r311, int r312, String r313, String r314, String r315, String r316, String r317, String r410, HashMap r411, ArrayList r412, String r413, String r414, String r415, String r416, String r417, String r418, String r419, String r510, String r511, String r512, String r513, String r514, String r515, String r516, String r517, String r518, String r519, String r610, String r611, int r612, DefaultConstructorMarker r613) {
        int r100 = 0;
        if ((r612 & 1) == 0) goto L5;
        int r101 = 0;
    L7:
        if ((r612 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r612 & 4) != 0) goto L15;
        r100 = r312;
    L15:
        if ((r612 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r612 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r612 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r612 & 64) == 0) goto L29;
        String r106 = "";
    L31:
        if ((r612 & 128) == 0) goto L33;
        String r107 = "";
    L35:
        if ((r612 & 256) == 0) goto L37;
        String r110 = "";
    L39:
        if ((r612 & 512) == 0) goto L41;
        HashMap r111 = new HashMap();
    L43:
        if ((r612 & 1024) == 0) goto L45;
        ArrayList r112 = new ArrayList();
    L47:
        if ((r612 & 2048) == 0) goto L49;
        String r113 = "";
    L51:
        if ((r612 & 4096) == 0) goto L53;
        String r114 = "";
    L55:
        if ((r612 & 8192) == 0) goto L57;
        String r115 = "";
    L59:
        if ((r612 & 16384) == 0) goto L61;
        String r108 = "";
    L63:
        if ((r612 & 32768) == 0) goto L65;
        String r116 = "";
    L67:
        if ((r612 & 65536) == 0) goto L69;
        String r117 = "";
    L71:
        if ((r612 & 131072) == 0) goto L73;
        String r118 = "";
    L75:
        if ((r612 & 262144) == 0) goto L77;
        String r119 = "";
    L79:
        if ((r612 & 524288) == 0) goto L81;
        String r210 = "";
    L83:
        if ((r612 & 1048576) == 0) goto L85;
        String r211 = "";
    L87:
        if ((r612 & 2097152) == 0) goto L89;
        String r212 = "";
    L91:
        if ((r612 & 4194304) == 0) goto L93;
        String r213 = "";
    L95:
        if ((r612 & 8388608) == 0) goto L97;
        String r214 = "";
    L99:
        if ((r612 & 16777216) == 0) goto L101;
        String r215 = "";
    L103:
        if ((r612 & 33554432) == 0) goto L105;
        String r216 = "";
    L107:
        if ((r612 & 67108864) == 0) goto L109;
        String r217 = "";
    L111:
        if ((r612 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        String r218 = "";
    L115:
        if ((r612 & 268435456) == 0) goto L117;
        String r219 = "";
    L119:
        if ((r612 & 536870912) == 0) goto L121;
        String r109 = "";
    L122:
        this(r101, r102, r100, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r109);
        return;
    L121:
        r109 = r611;
        goto L122
    L117:
        r219 = r610;
        goto L119
    L113:
        r218 = r519;
        goto L115
    L109:
        r217 = r518;
        goto L111
    L105:
        r216 = r517;
        goto L107
    L101:
        r215 = r516;
        goto L103
    L97:
        r214 = r515;
        goto L99
    L93:
        r213 = r514;
        goto L95
    L89:
        r212 = r513;
        goto L91
    L85:
        r211 = r512;
        goto L87
    L81:
        r210 = r511;
        goto L83
    L77:
        r119 = r510;
        goto L79
    L73:
        r118 = r419;
        goto L75
    L69:
        r117 = r418;
        goto L71
    L65:
        r116 = r417;
        goto L67
    L61:
        r108 = r416;
        goto L63
    L57:
        r115 = r415;
        goto L59
    L53:
        r114 = r414;
        goto L55
    L49:
        r113 = r413;
        goto L51
    L45:
        r112 = r412;
        goto L47
    L41:
        r111 = r411;
        goto L43
    L37:
        r110 = r410;
        goto L39
    L33:
        r107 = r317;
        goto L35
    L29:
        r106 = r316;
        goto L31
    L25:
        r105 = r315;
        goto L27
    L21:
        r104 = r314;
        goto L23
    L17:
        r103 = r313;
        goto L19
    L9:
        r102 = r311;
        goto L11
    L5:
        r101 = r310;
        goto L7
    }
}
