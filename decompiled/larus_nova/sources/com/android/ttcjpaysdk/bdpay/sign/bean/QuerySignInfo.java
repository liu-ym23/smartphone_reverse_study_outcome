package com.android.ttcjpaysdk.bdpay.sign.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayCardProtocolBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002Bå\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012$\b\u0002\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\t\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004¢\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020\u000fR\u0012\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/sign/bean/QuerySignInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "code", "", "msg", "status", "protocol_group_names", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "protocol_info", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayCardProtocolBean;", "Lkotlin/collections/ArrayList;", "is_set_pwd", "", "next_deduct_date", "deduct_method_desc", "promotion_amount", "", "real_trade_amount", "trade_amount", "user_account", "deduct_order_url", "verify_type", "first_pay_type_item", "Lcom/android/ttcjpaysdk/bdpay/sign/bean/PayTypeItem;", "sign_template_info", "Lcom/android/ttcjpaysdk/bdpay/sign/bean/SignTemplateInfo;", "bind_card_url", "jump_type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Ljava/util/ArrayList;ZLjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/android/ttcjpaysdk/bdpay/sign/bean/PayTypeItem;Lcom/android/ttcjpaysdk/bdpay/sign/bean/SignTemplateInfo;Ljava/lang/String;Ljava/lang/String;)V", "isJumpSpecificBind", "bdpay-sign_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QuerySignInfo implements CJPayObject, Serializable {
    public String bind_card_url;
    public String code;
    public String deduct_method_desc;
    public String deduct_order_url;
    public PayTypeItem first_pay_type_item;
    public boolean is_set_pwd;
    public String jump_type;
    public String msg;
    public String next_deduct_date;
    public int promotion_amount;
    public HashMap<String, String> protocol_group_names;
    public ArrayList<CJPayCardProtocolBean> protocol_info;
    public int real_trade_amount;
    public SignTemplateInfo sign_template_info;
    public String status;
    public int trade_amount;
    public String user_account;
    public String verify_type;

    public QuerySignInfo() {
        this(null, null, null, null, null, false, null, null, 0, 0, 0, null, null, null, null, null, null, null, 262143, null);
    }

    public final boolean isJumpSpecificBind() {
        return Intrinsics.areEqual(this.jump_type, "bind_card");
    }

    public QuerySignInfo(String r110, String r111, String r112, HashMap<String, String> r210, ArrayList<CJPayCardProtocolBean> r211, boolean r212, String r213, String r214, int r215, int r216, int r217, String r218, String r219, String r310, PayTypeItem r311, SignTemplateInfo r312, String r313, String r314) {
        Intrinsics.checkNotNullParameter(r110, "code");
        Intrinsics.checkNotNullParameter(r111, "msg");
        Intrinsics.checkNotNullParameter(r112, "status");
        Intrinsics.checkNotNullParameter(r210, "protocol_group_names");
        Intrinsics.checkNotNullParameter(r211, "protocol_info");
        Intrinsics.checkNotNullParameter(r213, "next_deduct_date");
        Intrinsics.checkNotNullParameter(r214, "deduct_method_desc");
        Intrinsics.checkNotNullParameter(r218, "user_account");
        Intrinsics.checkNotNullParameter(r219, "deduct_order_url");
        Intrinsics.checkNotNullParameter(r310, "verify_type");
        Intrinsics.checkNotNullParameter(r311, "first_pay_type_item");
        Intrinsics.checkNotNullParameter(r312, "sign_template_info");
        Intrinsics.checkNotNullParameter(r313, "bind_card_url");
        Intrinsics.checkNotNullParameter(r314, "jump_type");
        this.code = r110;
        this.msg = r111;
        this.status = r112;
        this.protocol_group_names = r210;
        this.protocol_info = r211;
        this.is_set_pwd = r212;
        this.next_deduct_date = r213;
        this.deduct_method_desc = r214;
        this.promotion_amount = r215;
        this.real_trade_amount = r216;
        this.trade_amount = r217;
        this.user_account = r218;
        this.deduct_order_url = r219;
        this.verify_type = r310;
        this.first_pay_type_item = r311;
        this.sign_template_info = r312;
        this.bind_card_url = r313;
        this.jump_type = r314;
    }

    public /* synthetic */ QuerySignInfo(String r310, String r311, String r312, HashMap r313, ArrayList r314, boolean r315, String r316, String r317, int r318, int r319, int r410, String r411, String r412, String r413, PayTypeItem r414, SignTemplateInfo r415, String r416, String r417, int r418, DefaultConstructorMarker r419) {
        if ((r418 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r418 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r418 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r418 & 8) == 0) goto L17;
        HashMap r103 = new HashMap();
    L19:
        if ((r418 & 16) == 0) goto L21;
        ArrayList r104 = new ArrayList();
    L22:
        int r105 = 0;
        if ((r418 & 32) == 0) goto L25;
        boolean r106 = false;
    L27:
        if ((r418 & 64) == 0) goto L29;
        String r107 = "";
    L31:
        if ((r418 & 128) == 0) goto L33;
        String r110 = "";
    L35:
        if ((r418 & 256) == 0) goto L37;
        int r111 = 0;
    L39:
        if ((r418 & 512) == 0) goto L41;
        int r112 = 0;
    L43:
        if ((r418 & 1024) != 0) goto L47;
        r105 = r410;
    L47:
        if ((r418 & 2048) == 0) goto L49;
        String r113 = "";
    L51:
        if ((r418 & 4096) == 0) goto L53;
        String r114 = "";
    L55:
        if ((r418 & 8192) == 0) goto L57;
        String r115 = "";
    L59:
        if ((r418 & 16384) == 0) goto L61;
        PayTypeItem r108 = new PayTypeItem(null, null, null, null, null, null, null, null, null, null, 1023, null);
    L63:
        if ((r418 & 32768) == 0) goto L65;
        SignTemplateInfo r116 = new SignTemplateInfo(null, null, null, null, null, null, null, null, null, null, 1023, null);
    L67:
        if ((r418 & 65536) == 0) goto L69;
        String r117 = "";
    L71:
        if ((r418 & 131072) == 0) goto L73;
        String r109 = "";
    L74:
        this(r100, r101, r102, r103, r104, r106, r107, r110, r111, r112, r105, r113, r114, r115, r108, r116, r117, r109);
        return;
    L73:
        r109 = r417;
        goto L74
    L69:
        r117 = r416;
        goto L71
    L65:
        r116 = r415;
        goto L67
    L61:
        r108 = r414;
        goto L63
    L57:
        r115 = r413;
        goto L59
    L53:
        r114 = r412;
        goto L55
    L49:
        r113 = r411;
        goto L51
    L41:
        r112 = r319;
        goto L43
    L37:
        r111 = r318;
        goto L39
    L33:
        r110 = r317;
        goto L35
    L29:
        r107 = r316;
        goto L31
    L25:
        r106 = r315;
        goto L27
    L21:
        r104 = r314;
        goto L22
    L17:
        r103 = r313;
        goto L19
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
