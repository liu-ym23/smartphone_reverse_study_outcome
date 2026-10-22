package com.android.ttcjpaysdk.bindcard.unionpay.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayCardProtocolBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayProtocolGroupContentsBean;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.vm.UnifyPreVerifySmsVM;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002Bw\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012$\b\u0002\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R.\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/bean/UnionPayAuthBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "authorization_icon_url", "", "name_mask", "id_code_mask", UnifyPreVerifySmsVM.KEY_MOBILE_MASK, "protocol_list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayCardProtocolBean;", "protocol_group_names", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "guide_message", "protocol_bean", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayProtocolGroupContentsBean;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/HashMap;Ljava/lang/String;Lcom/android/ttcjpaysdk/base/ui/data/CJPayProtocolGroupContentsBean;)V", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnionPayAuthBean implements CJPayObject, Serializable {
    public String authorization_icon_url;
    public String guide_message;
    public String id_code_mask;
    public String mobile_mask;
    public String name_mask;
    public CJPayProtocolGroupContentsBean protocol_bean;
    public HashMap<String, String> protocol_group_names;
    public ArrayList<CJPayCardProtocolBean> protocol_list;

    public UnionPayAuthBean() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public UnionPayAuthBean(String r100, String r101, String r102, String r103, ArrayList<CJPayCardProtocolBean> r104, HashMap<String, String> r105, String r106, CJPayProtocolGroupContentsBean r107) {
        Intrinsics.checkNotNullParameter(r100, "authorization_icon_url");
        Intrinsics.checkNotNullParameter(r101, "name_mask");
        Intrinsics.checkNotNullParameter(r102, "id_code_mask");
        Intrinsics.checkNotNullParameter(r103, UnifyPreVerifySmsVM.KEY_MOBILE_MASK);
        Intrinsics.checkNotNullParameter(r104, "protocol_list");
        Intrinsics.checkNotNullParameter(r105, "protocol_group_names");
        Intrinsics.checkNotNullParameter(r106, "guide_message");
        Intrinsics.checkNotNullParameter(r107, "protocol_bean");
        this.authorization_icon_url = r100;
        this.name_mask = r101;
        this.id_code_mask = r102;
        this.mobile_mask = r103;
        this.protocol_list = r104;
        this.protocol_group_names = r105;
        this.guide_message = r106;
        this.protocol_bean = r107;
    }

    public /* synthetic */ UnionPayAuthBean(String r110, String r111, String r112, String r113, ArrayList r114, HashMap r115, String r116, CJPayProtocolGroupContentsBean r117, int r118, DefaultConstructorMarker r119) {
        String r100 = "";
        if ((r118 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r118 & 16) == 0) goto L21;
        ArrayList r105 = new ArrayList();
    L23:
        if ((r118 & 32) == 0) goto L25;
        HashMap r106 = new HashMap();
    L27:
        if ((r118 & 64) != 0) goto L31;
        r100 = r116;
    L31:
        if ((r118 & 128) == 0) goto L33;
        CJPayProtocolGroupContentsBean r107 = new CJPayProtocolGroupContentsBean();
    L34:
        this(r101, r102, r103, r104, r105, r106, r100, r107);
        return;
    L33:
        r107 = r117;
        goto L34
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
