package com.android.ttcjpaysdk.bindcard.unionpay.bean;

import com.android.ttcjpaysdk.bindcard.base.bean.CJPayBindCardBaseBean;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/bean/UnionPayGetBankListResponseBean;", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayBindCardBaseBean;", "()V", "has_bindable_card", "", "unbindable_copywriting_info", "Lcom/android/ttcjpaysdk/bindcard/unionpay/bean/CopywritingInfo;", "union_pay_banks", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/bindcard/unionpay/bean/UnionPayBankBean;", "Lkotlin/collections/ArrayList;", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnionPayGetBankListResponseBean extends CJPayBindCardBaseBean {
    public String has_bindable_card;
    public CopywritingInfo unbindable_copywriting_info;
    public ArrayList<UnionPayBankBean> union_pay_banks;

    public UnionPayGetBankListResponseBean() {
        this.union_pay_banks = new ArrayList();
        this.has_bindable_card = "";
        this.unbindable_copywriting_info = new CopywritingInfo();
    }
}
