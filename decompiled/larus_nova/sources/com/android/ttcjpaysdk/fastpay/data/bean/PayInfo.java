package com.android.ttcjpaysdk.fastpay.data.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/fastpay/data/bean/PayInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "amount", "", "half_screen_desc", "", "pay_type_show_name", "type_mark", "fastpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PayInfo implements CJPayObject {
    public long amount;
    public String half_screen_desc;
    public String pay_type_show_name;
    public String type_mark;

    public PayInfo() {
        this.pay_type_show_name = "";
        this.half_screen_desc = "";
        this.type_mark = "";
    }
}
