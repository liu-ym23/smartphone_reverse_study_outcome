package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u008d\u0002\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001a\u0012\u0012\b\u0002\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e¢\u0006\u0002\u0010\u001fJ\u0006\u0010$\u001a\u00020%J\t\u0010&\u001a\u00020\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001aHÆ\u0003J\u0013\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001aHÆ\u0003J\t\u0010/\u001a\u00020\u001eHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003J)\u00102\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000bHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0013\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000eHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0091\u0002\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001a2\u0012\b\u0002\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001eHÆ\u0001J\u0013\u00109\u001a\u00020\u00042\b\u0010:\u001a\u0004\u0018\u00010;HÖ\u0003J\t\u0010<\u001a\u00020\u001eHÖ\u0001J\t\u0010=\u001a\u00020\u0006HÖ\u0001R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R:\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/VoucherRetainInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "no_close_icon", "", "bottom_retain_button_text", "", "info_for_monitor", "Lcom/android/ttcjpaysdk/base/ui/data/InfoForMonitor;", "info_for_monitor_pb", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "is_discount", "retain_msg_list", "", "Lcom/android/ttcjpaysdk/base/ui/data/RetainMsg;", "retain_plan", "retain_type", "style", "title", BdpAppEventConstant.PARAMS_SUB_TITLE, "top_retain_button_text", "top_right_text", "choice_pwd_check_way", "choice_pwd_check_way_title", "goods_label_list", "", "retain_questionnaire", "Lcom/android/ttcjpaysdk/base/ui/data/UIComponent;", "countdown", "", "(ZLjava/lang/String;Lcom/android/ttcjpaysdk/base/ui/data/InfoForMonitor;Ljava/util/HashMap;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;I)V", "getInfo_for_monitor_pb", "()Ljava/util/HashMap;", "setInfo_for_monitor_pb", "(Ljava/util/HashMap;)V", "afterProtoDecode", "", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherRetainInfo implements CJPayObject, Serializable {
    public String bottom_retain_button_text;
    public String choice_pwd_check_way;
    public String choice_pwd_check_way_title;
    public int countdown;
    public List<String> goods_label_list;
    public InfoForMonitor info_for_monitor;
    private HashMap<String, String> info_for_monitor_pb;
    public String is_discount;
    public boolean no_close_icon;
    public List<RetainMsg> retain_msg_list;
    public String retain_plan;
    public List<UIComponent> retain_questionnaire;
    public String retain_type;
    public String style;
    public String sub_title;
    public String title;
    public String top_retain_button_text;
    public String top_right_text;

    public VoucherRetainInfo() {
        this(false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 262143, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VoucherRetainInfo copy$default(VoucherRetainInfo r110, boolean r111, String r112, InfoForMonitor r210, HashMap r211, String r212, List r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, List r313, List r314, int r315, int r316, Object r317) {
        if ((r316 & 1) == 0) goto L5;
        boolean r100 = r110.no_close_icon;
    L7:
        if ((r316 & 2) == 0) goto L9;
        String r101 = r110.bottom_retain_button_text;
    L11:
        if ((r316 & 4) == 0) goto L13;
        InfoForMonitor r102 = r110.info_for_monitor;
    L15:
        if ((r316 & 8) == 0) goto L17;
        HashMap r103 = r110.info_for_monitor_pb;
    L19:
        if ((r316 & 16) == 0) goto L21;
        String r104 = r110.is_discount;
    L23:
        if ((r316 & 32) == 0) goto L25;
        List r105 = r110.retain_msg_list;
    L27:
        if ((r316 & 64) == 0) goto L29;
        String r106 = r110.retain_plan;
    L31:
        if ((r316 & 128) == 0) goto L33;
        String r107 = r110.retain_type;
    L35:
        if ((r316 & 256) == 0) goto L37;
        String r113 = r110.style;
    L39:
        if ((r316 & 512) == 0) goto L41;
        String r114 = r110.title;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        String r115 = r110.sub_title;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        String r116 = r110.top_retain_button_text;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        String r117 = r110.top_right_text;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        String r118 = r110.choice_pwd_check_way;
    L58:
        String r318 = r118;
        if ((r316 & 16384) == 0) goto L61;
        String r119 = r110.choice_pwd_check_way_title;
    L62:
        String r319 = r119;
        if ((r316 & 32768) == 0) goto L65;
        List r120 = r110.goods_label_list;
    L66:
        List r320 = r120;
        if ((r316 & 65536) == 0) goto L69;
        List r121 = r110.retain_questionnaire;
    L71:
        if ((r316 & 131072) == 0) goto L73;
        int r108 = r110.countdown;
    L75:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r318, r319, r320, r121, r108);
    L73:
        r108 = r315;
        goto L75
    L69:
        r121 = r314;
        goto L71
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final boolean component1() {
        return this.no_close_icon;
    }

    public final String component10() {
        return this.title;
    }

    public final String component11() {
        return this.sub_title;
    }

    public final String component12() {
        return this.top_retain_button_text;
    }

    public final String component13() {
        return this.top_right_text;
    }

    public final String component14() {
        return this.choice_pwd_check_way;
    }

    public final String component15() {
        return this.choice_pwd_check_way_title;
    }

    public final List<String> component16() {
        return this.goods_label_list;
    }

    public final List<UIComponent> component17() {
        return this.retain_questionnaire;
    }

    public final int component18() {
        return this.countdown;
    }

    public final String component2() {
        return this.bottom_retain_button_text;
    }

    public final InfoForMonitor component3() {
        return this.info_for_monitor;
    }

    public final HashMap<String, String> component4() {
        return this.info_for_monitor_pb;
    }

    public final String component5() {
        return this.is_discount;
    }

    public final List<RetainMsg> component6() {
        return this.retain_msg_list;
    }

    public final String component7() {
        return this.retain_plan;
    }

    public final String component8() {
        return this.retain_type;
    }

    public final String component9() {
        return this.style;
    }

    public final VoucherRetainInfo copy(boolean r210, String r211, InfoForMonitor r212, HashMap<String, String> r213, String r214, List<RetainMsg> r215, String r216, String r217, String r218, String r310, String r311, String r312, String r313, String r314, String r315, List<String> r316, List<UIComponent> r317, int r318) {
        return new VoucherRetainInfo(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r318);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VoucherRetainInfo) == true) goto L8;
        return false;
    L8:
        VoucherRetainInfo r101 = (VoucherRetainInfo) r100;
        if (this.no_close_icon == r101.no_close_icon) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bottom_retain_button_text, r101.bottom_retain_button_text) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.info_for_monitor, r101.info_for_monitor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.info_for_monitor_pb, r101.info_for_monitor_pb) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.is_discount, r101.is_discount) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.retain_msg_list, r101.retain_msg_list) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.retain_plan, r101.retain_plan) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.retain_type, r101.retain_type) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.style, r101.style) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.sub_title, r101.sub_title) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.top_retain_button_text, r101.top_retain_button_text) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.top_right_text, r101.top_right_text) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.choice_pwd_check_way, r101.choice_pwd_check_way) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.choice_pwd_check_way_title, r101.choice_pwd_check_way_title) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.goods_label_list, r101.goods_label_list) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.retain_questionnaire, r101.retain_questionnaire) == true) goto L60;
        return false;
    L60:
        if (this.countdown == r101.countdown) goto L62;
        return false;
    L62:
        return true;
    }

    public int hashCode() {
        if (this.no_close_icon == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.bottom_retain_button_text;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        InfoForMonitor r106 = this.info_for_monitor;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        HashMap<String, String> r109 = this.info_for_monitor_pb;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        String r112 = this.is_discount;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        List<RetainMsg> r115 = this.retain_msg_list;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        String r118 = this.retain_plan;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        String r121 = this.retain_type;
        if (r121 != null) goto L33;
        int r122 = 0;
    L34:
        int r123 = (r120 + r122) * 31;
        String r124 = this.style;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        String r127 = this.title;
        if (r127 != null) goto L41;
        int r128 = 0;
    L42:
        int r129 = (r126 + r128) * 31;
        String r130 = this.sub_title;
        if (r130 != null) goto L45;
        int r131 = 0;
    L46:
        int r132 = (r129 + r131) * 31;
        String r133 = this.top_retain_button_text;
        if (r133 != null) goto L49;
        int r134 = 0;
    L50:
        int r135 = (r132 + r134) * 31;
        String r136 = this.top_right_text;
        if (r136 != null) goto L53;
        int r137 = 0;
    L54:
        int r138 = (r135 + r137) * 31;
        String r139 = this.choice_pwd_check_way;
        if (r139 != null) goto L57;
        int r140 = 0;
    L58:
        int r141 = (r138 + r140) * 31;
        String r142 = this.choice_pwd_check_way_title;
        if (r142 != null) goto L61;
        int r143 = 0;
    L62:
        int r144 = (r141 + r143) * 31;
        List<String> r145 = this.goods_label_list;
        if (r145 != null) goto L65;
        int r146 = 0;
    L66:
        int r147 = (r144 + r146) * 31;
        List<UIComponent> r148 = this.retain_questionnaire;
        if (r148 == null) goto L71;
        r103 = r148.hashCode();
    L71:
        return ((r147 + r103) * 31) + this.countdown;
    L65:
        r146 = r145.hashCode();
        goto L66
    L61:
        r143 = r142.hashCode();
        goto L62
    L57:
        r140 = r139.hashCode();
        goto L58
    L53:
        r137 = r136.hashCode();
        goto L54
    L49:
        r134 = r133.hashCode();
        goto L50
    L45:
        r131 = r130.hashCode();
        goto L46
    L41:
        r128 = r127.hashCode();
        goto L42
    L37:
        r125 = r124.hashCode();
        goto L38
    L33:
        r122 = r121.hashCode();
        goto L34
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "VoucherRetainInfo(no_close_icon=" + this.no_close_icon + ", bottom_retain_button_text=" + this.bottom_retain_button_text + ", info_for_monitor=" + this.info_for_monitor + ", info_for_monitor_pb=" + this.info_for_monitor_pb + ", is_discount=" + this.is_discount + ", retain_msg_list=" + this.retain_msg_list + ", retain_plan=" + this.retain_plan + ", retain_type=" + this.retain_type + ", style=" + this.style + ", title=" + this.title + ", sub_title=" + this.sub_title + ", top_retain_button_text=" + this.top_retain_button_text + ", top_right_text=" + this.top_right_text + ", choice_pwd_check_way=" + this.choice_pwd_check_way + ", choice_pwd_check_way_title=" + this.choice_pwd_check_way_title + ", goods_label_list=" + this.goods_label_list + ", retain_questionnaire=" + this.retain_questionnaire + ", countdown=" + this.countdown + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void afterProtoDecode() {
        HashMap<String, String> r100 = this.info_for_monitor_pb;
        String r101 = null;
        Object[] r102 = 0;
        Object[] r103 = 0;
        if (r100 != null) goto L5;
    L10:
        InfoForMonitor r104 = null;
    L11:
        this.info_for_monitor = r104;
        this.info_for_monitor_pb = null;
        return;
    L5:
        if ((!r100.isEmpty()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        r104 = new InfoForMonitor(r101, r103 == true ? 1 : 0, 3, r102 == true ? 1 : 0);
        r104.keep_pop_type = r100.get("keep_pop_type");
        r104.retain_voucher_msg = r100.get("retain_voucher_msg");
        goto L11
    }

    public final HashMap<String, String> getInfo_for_monitor_pb() {
        return this.info_for_monitor_pb;
    }

    public final void setInfo_for_monitor_pb(HashMap<String, String> r100) {
        this.info_for_monitor_pb = r100;
    }

    public VoucherRetainInfo(boolean r100, String r101, InfoForMonitor r102, HashMap<String, String> r103, String r104, List<RetainMsg> r105, String r106, String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, List<String> r118, List<UIComponent> r119, int r210) {
        this.no_close_icon = r100;
        this.bottom_retain_button_text = r101;
        this.info_for_monitor = r102;
        this.info_for_monitor_pb = r103;
        this.is_discount = r104;
        this.retain_msg_list = r105;
        this.retain_plan = r106;
        this.retain_type = r110;
        this.style = r111;
        this.title = r112;
        this.sub_title = r113;
        this.top_retain_button_text = r114;
        this.top_right_text = r115;
        this.choice_pwd_check_way = r116;
        this.choice_pwd_check_way_title = r117;
        this.goods_label_list = r118;
        this.retain_questionnaire = r119;
        this.countdown = r210;
    }

    public /* synthetic */ VoucherRetainInfo(boolean r210, String r211, InfoForMonitor r212, HashMap r213, String r214, List r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, String r314, List r315, List r316, int r317, int r318, DefaultConstructorMarker r319) {
        if ((r318 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r318 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r318 & 4) == 0) goto L13;
        InfoForMonitor r102 = null;
    L15:
        if ((r318 & 8) == 0) goto L17;
        HashMap r103 = null;
    L19:
        if ((r318 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r318 & 32) == 0) goto L25;
        List r105 = null;
    L27:
        if ((r318 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r318 & 128) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r318 & 256) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r318 & 512) == 0) goto L41;
        String r111 = null;
    L43:
        if ((r318 & 1024) == 0) goto L45;
        String r112 = null;
    L47:
        if ((r318 & 2048) == 0) goto L49;
        String r113 = null;
    L51:
        if ((r318 & 4096) == 0) goto L53;
        String r114 = null;
    L55:
        if ((r318 & 8192) == 0) goto L57;
        String r115 = null;
    L59:
        if ((r318 & 16384) == 0) goto L61;
        String r108 = null;
    L63:
        if ((r318 & 32768) == 0) goto L65;
        List r116 = null;
    L67:
        if ((r318 & 65536) == 0) goto L69;
        List r117 = null;
    L71:
        if ((r318 & 131072) == 0) goto L73;
        int r109 = 60;
    L74:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r109);
        return;
    L73:
        r109 = r317;
        goto L74
    L69:
        r117 = r316;
        goto L71
    L65:
        r116 = r315;
        goto L67
    L61:
        r108 = r314;
        goto L63
    L57:
        r115 = r313;
        goto L59
    L53:
        r114 = r312;
        goto L55
    L49:
        r113 = r311;
        goto L51
    L45:
        r112 = r310;
        goto L47
    L41:
        r111 = r219;
        goto L43
    L37:
        r110 = r218;
        goto L39
    L33:
        r107 = r217;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
