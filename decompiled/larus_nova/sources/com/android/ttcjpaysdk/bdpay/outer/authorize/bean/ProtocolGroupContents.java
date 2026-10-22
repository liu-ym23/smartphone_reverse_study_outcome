package com.android.ttcjpaysdk.bdpay.outer.authorize.bean;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayCardProtocolBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002Bc\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\b\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00100\nj\b\u0012\u0004\u0012\u00020\u0010`\f2\u0006\u0010\u0011\u001a\u00020\u0004R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/outer/authorize/bean/ProtocolGroupContents;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "guide_message", "", "protocol_check_box", "protocol_group_names", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "protocol_list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayCardProtocolBean;", "Lkotlin/collections/ArrayList;", "tail_guide_message", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Ljava/util/ArrayList;Ljava/lang/String;)V", "getProtocolJsonListByGroup", "Lorg/json/JSONObject;", "groupName", "bdpay-outer-authorize_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProtocolGroupContents implements CJPayObject, Serializable {
    public String guide_message;
    public String protocol_check_box;
    public HashMap<String, String> protocol_group_names;
    public ArrayList<CJPayCardProtocolBean> protocol_list;
    public String tail_guide_message;

    public ProtocolGroupContents() {
        this(null, null, null, null, null, 31, null);
    }

    public final ArrayList<JSONObject> getProtocolJsonListByGroup(String r100) {
        Intrinsics.checkNotNullParameter(r100, "groupName");
        ArrayList<JSONObject> r101 = new ArrayList();
        Iterator<CJPayCardProtocolBean> r102 = this.protocol_list.iterator();
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

    public ProtocolGroupContents(String r100, String r101, HashMap<String, String> r102, ArrayList<CJPayCardProtocolBean> r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "guide_message");
        Intrinsics.checkNotNullParameter(r101, "protocol_check_box");
        Intrinsics.checkNotNullParameter(r102, "protocol_group_names");
        Intrinsics.checkNotNullParameter(r103, "protocol_list");
        Intrinsics.checkNotNullParameter(r104, "tail_guide_message");
        this.guide_message = r100;
        this.protocol_check_box = r101;
        this.protocol_group_names = r102;
        this.protocol_list = r103;
        this.tail_guide_message = r104;
    }

    public /* synthetic */ ProtocolGroupContents(String r100, String r101, HashMap r102, ArrayList r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = "";
    L7:
        if ((r110 & 2) == 0) goto L9;
        r101 = "0";
    L9:
        String r105 = r101;
        if ((r110 & 4) == 0) goto L12;
        r102 = new HashMap();
    L12:
        HashMap r106 = r102;
        if ((r110 & 8) == 0) goto L15;
        r103 = new ArrayList();
    L15:
        ArrayList r107 = r103;
        if ((r110 & 16) == 0) goto L18;
        String r113 = "";
    L19:
        this(r112, r105, r106, r107, r113);
        return;
    L18:
        r113 = r104;
        goto L19
    L5:
        r112 = r100;
        goto L7
    }
}
