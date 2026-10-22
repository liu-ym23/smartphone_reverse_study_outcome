package com.android.ttcjpaysdk.integrated.counter.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayCardProtocolBean;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B©\u0001\u0012$\b\u0002\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005¢\u0006\u0002\u0010\u0018J\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\bj\b\u0012\u0004\u0012\u00020\u001a`\n2\u0006\u0010\u001b\u001a\u00020\u0005R\u0012\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/data/QuerySignInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "protocol_group_names", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "protocol_info", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayCardProtocolBean;", "Lkotlin/collections/ArrayList;", "is_set_pwd", "", "next_deduct_date", "deduct_method_desc", "promotion_amount", "", "real_trade_amount", "trade_amount", "user_account", "deduct_order_url", "sign_template_info", "Lcom/android/ttcjpaysdk/integrated/counter/data/SignTemplateInfo;", "promotion_desc", "(Ljava/util/HashMap;Ljava/util/ArrayList;ZLjava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Lcom/android/ttcjpaysdk/integrated/counter/data/SignTemplateInfo;Ljava/lang/String;)V", "getProtocolJsonListByGroup", "Lorg/json/JSONObject;", "groupName", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QuerySignInfo implements CJPayObject, Serializable {
    public String deduct_method_desc;
    public String deduct_order_url;
    public boolean is_set_pwd;
    public String next_deduct_date;
    public int promotion_amount;
    public String promotion_desc;
    public HashMap<String, String> protocol_group_names;
    public ArrayList<CJPayCardProtocolBean> protocol_info;
    public int real_trade_amount;
    public SignTemplateInfo sign_template_info;
    public int trade_amount;
    public String user_account;

    public QuerySignInfo() {
        this(null, null, false, null, null, 0, 0, 0, null, null, null, null, UnixStat.PERM_MASK, null);
    }

    public final ArrayList<JSONObject> getProtocolJsonListByGroup(String r100) {
        Intrinsics.checkNotNullParameter(r100, "groupName");
        ArrayList<JSONObject> r101 = new ArrayList();
        Iterator<CJPayCardProtocolBean> r102 = this.protocol_info.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        CJPayCardProtocolBean r103 = r102.next();
        if (TextUtils.equals(r100, r103.group) == false) goto L4;
        JSONObject r104 = CJPayJsonParser.toJsonObject(r103);
        if (r104 == null) goto L4;
        r101.add(r104);
        goto L4
    L10:
        return r101;
    }

    public QuerySignInfo(HashMap<String, String> r100, ArrayList<CJPayCardProtocolBean> r101, boolean r102, String r103, String r104, int r105, int r106, int r107, String r110, String r111, SignTemplateInfo r112, String r113) {
        Intrinsics.checkNotNullParameter(r100, "protocol_group_names");
        Intrinsics.checkNotNullParameter(r101, "protocol_info");
        Intrinsics.checkNotNullParameter(r103, "next_deduct_date");
        Intrinsics.checkNotNullParameter(r104, "deduct_method_desc");
        Intrinsics.checkNotNullParameter(r110, "user_account");
        Intrinsics.checkNotNullParameter(r111, "deduct_order_url");
        Intrinsics.checkNotNullParameter(r112, "sign_template_info");
        Intrinsics.checkNotNullParameter(r113, "promotion_desc");
        this.protocol_group_names = r100;
        this.protocol_info = r101;
        this.is_set_pwd = r102;
        this.next_deduct_date = r103;
        this.deduct_method_desc = r104;
        this.promotion_amount = r105;
        this.real_trade_amount = r106;
        this.trade_amount = r107;
        this.user_account = r110;
        this.deduct_order_url = r111;
        this.sign_template_info = r112;
        this.promotion_desc = r113;
    }

    public /* synthetic */ QuerySignInfo(HashMap r210, ArrayList r211, boolean r212, String r310, String r311, int r312, int r313, int r314, String r315, String r316, SignTemplateInfo r317, String r318, int r319, DefaultConstructorMarker r410) {
        if ((r319 & 1) == 0) goto L5;
        HashMap r100 = new HashMap();
    L7:
        if ((r319 & 2) == 0) goto L9;
        ArrayList r101 = new ArrayList();
    L10:
        int r102 = 0;
        if ((r319 & 4) == 0) goto L13;
        boolean r103 = false;
    L14:
        String r104 = "";
        if ((r319 & 8) == 0) goto L17;
        String r105 = "";
    L19:
        if ((r319 & 16) == 0) goto L21;
        String r106 = "";
    L23:
        if ((r319 & 32) == 0) goto L25;
        int r107 = 0;
    L27:
        if ((r319 & 64) == 0) goto L29;
        int r108 = 0;
    L31:
        if ((r319 & 128) != 0) goto L35;
        r102 = r314;
    L35:
        if ((r319 & 256) == 0) goto L37;
        String r110 = "";
    L39:
        if ((r319 & 512) == 0) goto L41;
        String r111 = "";
    L43:
        if ((r319 & 1024) == 0) goto L45;
        SignTemplateInfo r112 = new SignTemplateInfo(null, null, null, null, null, null, null, null, null, null, 1023, null);
    L47:
        if ((r319 & 2048) != 0) goto L50;
        r104 = r318;
    L50:
        this(r100, r101, r103, r105, r106, r107, r108, r102, r110, r111, r112, r104);
        return;
    L45:
        r112 = r317;
        goto L47
    L41:
        r111 = r316;
        goto L43
    L37:
        r110 = r315;
        goto L39
    L29:
        r108 = r313;
        goto L31
    L25:
        r107 = r312;
        goto L27
    L21:
        r106 = r311;
        goto L23
    L17:
        r105 = r310;
        goto L19
    L13:
        r103 = r212;
        goto L14
    L9:
        r101 = r211;
        goto L10
    L5:
        r100 = r210;
        goto L7
    }
}
