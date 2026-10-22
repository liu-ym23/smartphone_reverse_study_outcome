package com.android.ttcjpaysdk.integrated.sign.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.util.ArrayList;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/data/DataInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "cashdesk_show_conf", "Lcom/android/ttcjpaysdk/integrated/sign/counter/data/CashDeskShowConf;", "default_ptcode", "", "fe_metrics", "Lorg/json/JSONObject;", "merchant_info", "Lcom/android/ttcjpaysdk/integrated/sign/counter/data/MerchantInfo;", "pay_source", "paytype_items", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/integrated/sign/counter/data/TypeItems;", "show_num", "", "sorted_ptcodes", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DataInfo implements CJPayObject {
    public CashDeskShowConf cashdesk_show_conf;
    public String default_ptcode;
    public JSONObject fe_metrics;
    public MerchantInfo merchant_info;
    public String pay_source;
    public ArrayList<TypeItems> paytype_items;
    public int show_num;
    public ArrayList<String> sorted_ptcodes;

    public DataInfo() {
        this.default_ptcode = "";
        this.sorted_ptcodes = new ArrayList();
        this.cashdesk_show_conf = new CashDeskShowConf();
        this.paytype_items = new ArrayList();
        this.merchant_info = new MerchantInfo();
        this.fe_metrics = new JSONObject();
        this.show_num = 3;
    }
}
