package com.android.ttcjpaysdk.fastpay.data.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0004j\b\u0012\u0004\u0012\u00020\f`\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/fastpay/data/bean/FastPayTradeQueryInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "pay_info", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/fastpay/data/bean/PayInfo;", "Lkotlin/collections/ArrayList;", "result_page_show_conf", "Lcom/android/ttcjpaysdk/fastpay/data/bean/ResultPageShowConf;", "trade_info", "Lcom/android/ttcjpaysdk/fastpay/data/bean/FastPayTradeInfo;", "voucher_details", "Lcom/android/ttcjpaysdk/fastpay/data/bean/VoucherDetails;", "fastpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FastPayTradeQueryInfo implements CJPayObject {
    public ArrayList<PayInfo> pay_info;
    public ResultPageShowConf result_page_show_conf;
    public FastPayTradeInfo trade_info;
    public ArrayList<VoucherDetails> voucher_details;

    public FastPayTradeQueryInfo() {
        this.pay_info = new ArrayList();
        this.voucher_details = new ArrayList();
        this.trade_info = new FastPayTradeInfo();
        this.result_page_show_conf = new ResultPageShowConf();
    }
}
