package com.android.ttcjpaysdk.bindcard.unionpay.bean;

import com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayBindCardBaseBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tR\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/bean/UnionPayCreateOrderBean;", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayBindCardBaseBean;", "button_info", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayButtonInfo;", "member_biz_order_no", "", "union_pay_sign_info", "Lcom/android/ttcjpaysdk/bindcard/unionpay/bean/UnionPaySignInfo;", "bind_card_union_icon_url", "(Lcom/android/ttcjpaysdk/base/ui/data/CJPayButtonInfo;Ljava/lang/String;Lcom/android/ttcjpaysdk/bindcard/unionpay/bean/UnionPaySignInfo;Ljava/lang/String;)V", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnionPayCreateOrderBean extends CJPayBindCardBaseBean {
    public String bind_card_union_icon_url;
    public CJPayButtonInfo button_info;
    public String member_biz_order_no;
    public UnionPaySignInfo union_pay_sign_info;

    public UnionPayCreateOrderBean() {
        this(null, null, null, null, 15, null);
    }

    public UnionPayCreateOrderBean(CJPayButtonInfo r100, String r101, UnionPaySignInfo r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "button_info");
        Intrinsics.checkNotNullParameter(r101, "member_biz_order_no");
        Intrinsics.checkNotNullParameter(r102, "union_pay_sign_info");
        Intrinsics.checkNotNullParameter(r103, "bind_card_union_icon_url");
        this.button_info = r100;
        this.member_biz_order_no = r101;
        this.union_pay_sign_info = r102;
        this.bind_card_union_icon_url = r103;
    }

    public /* synthetic */ UnionPayCreateOrderBean(CJPayButtonInfo r110, String r111, UnionPaySignInfo r112, String r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 1) == 0) goto L5;
        CJPayButtonInfo r100 = new CJPayButtonInfo();
    L6:
        String r101 = "";
        if ((r211 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r211 & 4) == 0) goto L13;
        UnionPaySignInfo r103 = new UnionPaySignInfo(null, null, null, null, null, null, null, null, null, 511, null);
    L15:
        if ((r211 & 8) != 0) goto L18;
        r101 = r210;
    L18:
        this(r100, r102, r103, r101);
        return;
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
