package com.android.ttcjpaysdk.bindcard.unionpay.bean;

import com.android.ttcjpaysdk.base.ui.data.CJPayCardProtocolBean;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayBindCardBaseBean;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayButtonInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/bean/UnionPayBindCardBean;", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayBindCardBaseBean;", "bank_card_list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayCardProtocolBean;", "button_info", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayButtonInfo;", "is_set_pwd", "", "(Ljava/util/ArrayList;Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayButtonInfo;Ljava/lang/String;)V", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnionPayBindCardBean extends CJPayBindCardBaseBean {
    public ArrayList<CJPayCardProtocolBean> bank_card_list;
    public CJPayButtonInfo button_info;
    public String is_set_pwd;

    public UnionPayBindCardBean() {
        this(null, null, null, 7, null);
    }

    public UnionPayBindCardBean(ArrayList<CJPayCardProtocolBean> r100, CJPayButtonInfo r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "bank_card_list");
        Intrinsics.checkNotNullParameter(r101, "button_info");
        Intrinsics.checkNotNullParameter(r102, "is_set_pwd");
        this.bank_card_list = r100;
        this.button_info = r101;
        this.is_set_pwd = r102;
    }

    public /* synthetic */ UnionPayBindCardBean(ArrayList r100, CJPayButtonInfo r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = new ArrayList();
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = new CJPayButtonInfo();
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}
