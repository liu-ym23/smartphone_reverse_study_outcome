package com.android.ttcjpaysdk.base.ui.data;

import androidx.compose.ui.spatial.RectListKt;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B¹\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0010\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u0012\b\b\u0002\u0010!\u001a\u00020\u0004¢\u0006\u0002\u0010\"J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010%\u001a\u00020\u0010HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0013\u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\t\u00101\u001a\u00020\u0010HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u00103\u001a\u00020\u0010HÆ\u0003J\t\u00104\u001a\u00020\u0004HÆ\u0003J\t\u00105\u001a\u00020\u0004HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010<\u001a\u00020\rHÆ\u0003J½\u0002\u0010=\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00102\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u00102\b\b\u0002\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\u0004HÆ\u0001J\u0013\u0010>\u001a\u00020\u00102\b\u0010?\u001a\u0004\u0018\u00010@HÖ\u0003J\t\u0010A\u001a\u00020\rHÖ\u0001J\t\u0010B\u001a\u00020\u0004HÖ\u0001R\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/RetainMsg;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "left_msg", "", "left_msg_type", "left_msg_desc", "right_msg", "right_msg_desc", "right_msg_desc_prefix", "tag_msg", "tag_position", "voucher_type", "", "icon_url", "choose", "", "standard_show_amount", "standard_voucher_label", "voucher_no_list", "", "prize_desc", "crossed_price", "multiple_voucher_msg", "pay_addi_info_type", "voucher_show_style", "voucher_left_desc", "fold_voucher_info", "Lcom/android/ttcjpaysdk/base/ui/data/FrontPayTypeData$HomePageFoldVoucherInfo;", "need_show_voucher_enhance", "trade_confirm_voucher_enhance_msg", "is_support_native_retain_type", "voucher_bg_type", "promotion_scene", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/android/ttcjpaysdk/base/ui/data/FrontPayTypeData$HomePageFoldVoucherInfo;ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RetainMsg implements CJPayObject, Serializable {
    public boolean choose;
    public String crossed_price;
    public FrontPayTypeData.HomePageFoldVoucherInfo fold_voucher_info;
    public String icon_url;
    public boolean is_support_native_retain_type;
    public String left_msg;
    public String left_msg_desc;
    public String left_msg_type;
    public String multiple_voucher_msg;
    public boolean need_show_voucher_enhance;
    public String pay_addi_info_type;
    public String prize_desc;
    public String promotion_scene;
    public String right_msg;
    public String right_msg_desc;
    public String right_msg_desc_prefix;
    public String standard_show_amount;
    public String standard_voucher_label;
    public String tag_msg;
    public String tag_position;
    public String trade_confirm_voucher_enhance_msg;
    public String voucher_bg_type;
    public String voucher_left_desc;
    public List<String> voucher_no_list;
    public String voucher_show_style;
    public int voucher_type;

    public RetainMsg() {
        this(null, null, null, null, null, null, null, null, 0, null, false, null, null, null, null, null, null, null, null, null, null, false, null, false, null, null, RectListKt.Lower26Bits, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RetainMsg copy$default(RetainMsg r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, int r216, String r217, boolean r218, String r219, String r310, List r311, String r312, String r313, String r314, String r315, String r316, String r317, FrontPayTypeData.HomePageFoldVoucherInfo r318, boolean r319, String r410, boolean r411, String r412, String r413, int r414, Object r415) {
        if ((r414 & 1) == 0) goto L5;
        String r100 = r110.left_msg;
    L7:
        if ((r414 & 2) == 0) goto L9;
        String r101 = r110.left_msg_type;
    L11:
        if ((r414 & 4) == 0) goto L13;
        String r102 = r110.left_msg_desc;
    L15:
        if ((r414 & 8) == 0) goto L17;
        String r103 = r110.right_msg;
    L19:
        if ((r414 & 16) == 0) goto L21;
        String r104 = r110.right_msg_desc;
    L23:
        if ((r414 & 32) == 0) goto L25;
        String r105 = r110.right_msg_desc_prefix;
    L27:
        if ((r414 & 64) == 0) goto L29;
        String r106 = r110.tag_msg;
    L31:
        if ((r414 & 128) == 0) goto L33;
        String r107 = r110.tag_position;
    L35:
        if ((r414 & 256) == 0) goto L37;
        int r113 = r110.voucher_type;
    L39:
        if ((r414 & 512) == 0) goto L41;
        String r114 = r110.icon_url;
    L43:
        if ((r414 & 1024) == 0) goto L45;
        boolean r115 = r110.choose;
    L47:
        if ((r414 & 2048) == 0) goto L49;
        String r116 = r110.standard_show_amount;
    L51:
        if ((r414 & 4096) == 0) goto L53;
        String r117 = r110.standard_voucher_label;
    L55:
        if ((r414 & 8192) == 0) goto L57;
        List r118 = r110.voucher_no_list;
    L58:
        List r320 = r118;
        if ((r414 & 16384) == 0) goto L61;
        String r119 = r110.prize_desc;
    L62:
        String r321 = r119;
        if ((r414 & 32768) == 0) goto L65;
        String r120 = r110.crossed_price;
    L66:
        String r322 = r120;
        if ((r414 & 65536) == 0) goto L69;
        String r121 = r110.multiple_voucher_msg;
    L70:
        String r323 = r121;
        if ((r414 & 131072) == 0) goto L73;
        String r122 = r110.pay_addi_info_type;
    L74:
        String r324 = r122;
        if ((r414 & 262144) == 0) goto L77;
        String r123 = r110.voucher_show_style;
    L78:
        String r325 = r123;
        if ((r414 & 524288) == 0) goto L81;
        String r124 = r110.voucher_left_desc;
    L82:
        String r326 = r124;
        if ((r414 & 1048576) == 0) goto L85;
        FrontPayTypeData.HomePageFoldVoucherInfo r125 = r110.fold_voucher_info;
    L86:
        FrontPayTypeData.HomePageFoldVoucherInfo r327 = r125;
        if ((r414 & 2097152) == 0) goto L89;
        boolean r126 = r110.need_show_voucher_enhance;
    L90:
        boolean r328 = r126;
        if ((r414 & 4194304) == 0) goto L93;
        String r127 = r110.trade_confirm_voucher_enhance_msg;
    L94:
        String r416 = r127;
        if ((r414 & 8388608) == 0) goto L97;
        boolean r128 = r110.is_support_native_retain_type;
    L98:
        boolean r417 = r128;
        if ((r414 & 16777216) == 0) goto L101;
        String r129 = r110.voucher_bg_type;
    L103:
        if ((r414 & 33554432) == 0) goto L105;
        String r108 = r110.promotion_scene;
    L107:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r416, r417, r129, r108);
    L105:
        r108 = r413;
        goto L107
    L101:
        r129 = r412;
        goto L103
    L97:
        r128 = r411;
        goto L98
    L93:
        r127 = r410;
        goto L94
    L89:
        r126 = r319;
        goto L90
    L85:
        r125 = r318;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
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

    public final String component1() {
        return this.left_msg;
    }

    public final String component10() {
        return this.icon_url;
    }

    public final boolean component11() {
        return this.choose;
    }

    public final String component12() {
        return this.standard_show_amount;
    }

    public final String component13() {
        return this.standard_voucher_label;
    }

    public final List<String> component14() {
        return this.voucher_no_list;
    }

    public final String component15() {
        return this.prize_desc;
    }

    public final String component16() {
        return this.crossed_price;
    }

    public final String component17() {
        return this.multiple_voucher_msg;
    }

    public final String component18() {
        return this.pay_addi_info_type;
    }

    public final String component19() {
        return this.voucher_show_style;
    }

    public final String component2() {
        return this.left_msg_type;
    }

    public final String component20() {
        return this.voucher_left_desc;
    }

    public final FrontPayTypeData.HomePageFoldVoucherInfo component21() {
        return this.fold_voucher_info;
    }

    public final boolean component22() {
        return this.need_show_voucher_enhance;
    }

    public final String component23() {
        return this.trade_confirm_voucher_enhance_msg;
    }

    public final boolean component24() {
        return this.is_support_native_retain_type;
    }

    public final String component25() {
        return this.voucher_bg_type;
    }

    public final String component26() {
        return this.promotion_scene;
    }

    public final String component3() {
        return this.left_msg_desc;
    }

    public final String component4() {
        return this.right_msg;
    }

    public final String component5() {
        return this.right_msg_desc;
    }

    public final String component6() {
        return this.right_msg_desc_prefix;
    }

    public final String component7() {
        return this.tag_msg;
    }

    public final String component8() {
        return this.tag_position;
    }

    public final int component9() {
        return this.voucher_type;
    }

    public final RetainMsg copy(String r210, String r310, String r311, String r312, String r313, String r314, String r315, String r316, int r317, String r318, boolean r319, String r410, String r411, List<String> r412, String r413, String r414, String r415, String r416, String r417, String r418, FrontPayTypeData.HomePageFoldVoucherInfo r419, boolean r510, String r511, boolean r512, String r513, String r514) {
        Intrinsics.checkNotNullParameter(r513, "voucher_bg_type");
        Intrinsics.checkNotNullParameter(r514, "promotion_scene");
        return new RetainMsg(r210, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RetainMsg) == true) goto L8;
        return false;
    L8:
        RetainMsg r101 = (RetainMsg) r100;
        if (Intrinsics.areEqual(this.left_msg, r101.left_msg) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.left_msg_type, r101.left_msg_type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.left_msg_desc, r101.left_msg_desc) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.right_msg, r101.right_msg) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.right_msg_desc, r101.right_msg_desc) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.right_msg_desc_prefix, r101.right_msg_desc_prefix) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.tag_msg, r101.tag_msg) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.tag_position, r101.tag_position) == true) goto L33;
        return false;
    L33:
        if (this.voucher_type == r101.voucher_type) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.icon_url, r101.icon_url) == true) goto L39;
        return false;
    L39:
        if (this.choose == r101.choose) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.standard_show_amount, r101.standard_show_amount) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.standard_voucher_label, r101.standard_voucher_label) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.voucher_no_list, r101.voucher_no_list) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.prize_desc, r101.prize_desc) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.crossed_price, r101.crossed_price) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.multiple_voucher_msg, r101.multiple_voucher_msg) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.pay_addi_info_type, r101.pay_addi_info_type) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.voucher_show_style, r101.voucher_show_style) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.voucher_left_desc, r101.voucher_left_desc) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.fold_voucher_info, r101.fold_voucher_info) == true) goto L72;
        return false;
    L72:
        if (this.need_show_voucher_enhance == r101.need_show_voucher_enhance) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.trade_confirm_voucher_enhance_msg, r101.trade_confirm_voucher_enhance_msg) == true) goto L78;
        return false;
    L78:
        if (this.is_support_native_retain_type == r101.is_support_native_retain_type) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.voucher_bg_type, r101.voucher_bg_type) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.promotion_scene, r101.promotion_scene) == true) goto L86;
        return false;
    L86:
        return true;
    }

    public int hashCode() {
        String r100 = this.left_msg;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.left_msg_type;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.left_msg_desc;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.right_msg;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.right_msg_desc;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.right_msg_desc_prefix;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.tag_msg;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.tag_position;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (((r121 + r123) * 31) + this.voucher_type) * 31;
        String r125 = this.icon_url;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        int r128 = 1231;
        if (this.choose == false) goto L41;
        int r129 = 1231;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.standard_show_amount;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.standard_voucher_label;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        List<String> r137 = this.voucher_no_list;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.prize_desc;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.crossed_price;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.multiple_voucher_msg;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.pay_addi_info_type;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.voucher_show_style;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        String r155 = this.voucher_left_desc;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        FrontPayTypeData.HomePageFoldVoucherInfo r158 = this.fold_voucher_info;
        if (r158 != null) goto L81;
        int r159 = 0;
    L82:
        int r160 = (r157 + r159) * 31;
        if (this.need_show_voucher_enhance == false) goto L85;
        int r161 = 1231;
    L86:
        int r162 = (r160 + r161) * 31;
        String r163 = this.trade_confirm_voucher_enhance_msg;
        if (r163 == null) goto L90;
        r101 = r163.hashCode();
    L90:
        int r164 = (r162 + r101) * 31;
        if (this.is_support_native_retain_type == true) goto L95;
        r128 = 1237;
    L95:
        return ((((r164 + r128) * 31) + this.voucher_bg_type.hashCode()) * 31) + this.promotion_scene.hashCode();
    L85:
        r161 = 1237;
        goto L86
    L81:
        r159 = r158.hashCode();
        goto L82
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = 1237;
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "RetainMsg(left_msg=" + this.left_msg + ", left_msg_type=" + this.left_msg_type + ", left_msg_desc=" + this.left_msg_desc + ", right_msg=" + this.right_msg + ", right_msg_desc=" + this.right_msg_desc + ", right_msg_desc_prefix=" + this.right_msg_desc_prefix + ", tag_msg=" + this.tag_msg + ", tag_position=" + this.tag_position + ", voucher_type=" + this.voucher_type + ", icon_url=" + this.icon_url + ", choose=" + this.choose + ", standard_show_amount=" + this.standard_show_amount + ", standard_voucher_label=" + this.standard_voucher_label + ", voucher_no_list=" + this.voucher_no_list + ", prize_desc=" + this.prize_desc + ", crossed_price=" + this.crossed_price + ", multiple_voucher_msg=" + this.multiple_voucher_msg + ", pay_addi_info_type=" + this.pay_addi_info_type + ", voucher_show_style=" + this.voucher_show_style + ", voucher_left_desc=" + this.voucher_left_desc + ", fold_voucher_info=" + this.fold_voucher_info + ", need_show_voucher_enhance=" + this.need_show_voucher_enhance + ", trade_confirm_voucher_enhance_msg=" + this.trade_confirm_voucher_enhance_msg + ", is_support_native_retain_type=" + this.is_support_native_retain_type + ", voucher_bg_type=" + this.voucher_bg_type + ", promotion_scene=" + this.promotion_scene + ')';
    }

    public RetainMsg(String r100, String r101, String r102, String r103, String r104, String r110, String r111, String r112, int r113, String r114, boolean r115, String r116, String r117, List<String> r118, String r119, String r210, String r211, String r212, String r213, String r214, FrontPayTypeData.HomePageFoldVoucherInfo r215, boolean r216, String r217, boolean r218, String r219, String r310) {
        Intrinsics.checkNotNullParameter(r219, "voucher_bg_type");
        Intrinsics.checkNotNullParameter(r310, "promotion_scene");
        this.left_msg = r100;
        this.left_msg_type = r101;
        this.left_msg_desc = r102;
        this.right_msg = r103;
        this.right_msg_desc = r104;
        this.right_msg_desc_prefix = r110;
        this.tag_msg = r111;
        this.tag_position = r112;
        this.voucher_type = r113;
        this.icon_url = r114;
        this.choose = r115;
        this.standard_show_amount = r116;
        this.standard_voucher_label = r117;
        this.voucher_no_list = r118;
        this.prize_desc = r119;
        this.crossed_price = r210;
        this.multiple_voucher_msg = r211;
        this.pay_addi_info_type = r212;
        this.voucher_show_style = r213;
        this.voucher_left_desc = r214;
        this.fold_voucher_info = r215;
        this.need_show_voucher_enhance = r216;
        this.trade_confirm_voucher_enhance_msg = r217;
        this.is_support_native_retain_type = r218;
        this.voucher_bg_type = r219;
        this.promotion_scene = r310;
    }

    public /* synthetic */ RetainMsg(String r210, String r310, String r311, String r312, String r313, String r314, String r315, String r316, int r317, String r318, boolean r319, String r410, String r411, List r412, String r413, String r414, String r415, String r416, String r417, String r418, FrontPayTypeData.HomePageFoldVoucherInfo r419, boolean r510, String r511, boolean r512, String r513, String r514, int r515, DefaultConstructorMarker r516) {
        if ((r515 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r515 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r515 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r515 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r515 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r515 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r515 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r515 & 128) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r515 & 256) == 0) goto L37;
        int r110 = -1;
    L39:
        if ((r515 & 512) == 0) goto L41;
        String r111 = null;
    L43:
        if ((r515 & 1024) == 0) goto L45;
        boolean r112 = false;
    L47:
        if ((r515 & 2048) == 0) goto L49;
        String r113 = null;
    L51:
        if ((r515 & 4096) == 0) goto L53;
        String r114 = null;
    L55:
        if ((r515 & 8192) == 0) goto L57;
        List r108 = null;
    L59:
        if ((r515 & 16384) == 0) goto L61;
        String r115 = null;
    L63:
        if ((r515 & 32768) == 0) goto L65;
        String r116 = null;
    L67:
        if ((r515 & 65536) == 0) goto L69;
        String r117 = null;
    L71:
        if ((r515 & 131072) == 0) goto L73;
        String r118 = null;
    L75:
        if ((r515 & 262144) == 0) goto L77;
        String r119 = null;
    L79:
        if ((r515 & 524288) == 0) goto L81;
        String r211 = null;
    L83:
        if ((r515 & 1048576) == 0) goto L85;
        FrontPayTypeData.HomePageFoldVoucherInfo r212 = null;
    L87:
        if ((r515 & 2097152) == 0) goto L89;
        boolean r213 = false;
    L90:
        String r214 = "";
        if ((r515 & 4194304) == 0) goto L93;
        String r215 = "";
    L95:
        if ((r515 & 8388608) == 0) goto L97;
        boolean r216 = false;
    L99:
        if ((r515 & 16777216) == 0) goto L101;
        String r217 = "";
    L103:
        if ((r515 & 33554432) != 0) goto L106;
        r214 = r514;
    L106:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r108, r115, r116, r117, r118, r119, r211, r212, r213, r215, r216, r217, r214);
        return;
    L101:
        r217 = r513;
        goto L103
    L97:
        r216 = r512;
        goto L99
    L93:
        r215 = r511;
        goto L95
    L89:
        r213 = r510;
        goto L90
    L85:
        r212 = r419;
        goto L87
    L81:
        r211 = r418;
        goto L83
    L77:
        r119 = r417;
        goto L79
    L73:
        r118 = r416;
        goto L75
    L69:
        r117 = r415;
        goto L71
    L65:
        r116 = r414;
        goto L67
    L61:
        r115 = r413;
        goto L63
    L57:
        r108 = r412;
        goto L59
    L53:
        r114 = r411;
        goto L55
    L49:
        r113 = r410;
        goto L51
    L45:
        r112 = r319;
        goto L47
    L41:
        r111 = r318;
        goto L43
    L37:
        r110 = r317;
        goto L39
    L33:
        r107 = r316;
        goto L35
    L29:
        r106 = r315;
        goto L31
    L25:
        r105 = r314;
        goto L27
    L21:
        r104 = r313;
        goto L23
    L17:
        r103 = r312;
        goto L19
    L13:
        r102 = r311;
        goto L15
    L9:
        r101 = r310;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
