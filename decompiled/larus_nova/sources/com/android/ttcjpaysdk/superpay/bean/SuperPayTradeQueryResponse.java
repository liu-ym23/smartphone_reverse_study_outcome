package com.android.ttcjpaysdk.superpay.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/superpay/bean/SuperPayTradeQueryResponse;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "code", "", "data", "Lcom/android/ttcjpaysdk/superpay/bean/SuperPayTradeQueryInfo;", "msg", "fastpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SuperPayTradeQueryResponse implements CJPayObject {
    public String code;
    public SuperPayTradeQueryInfo data;
    public String msg;

    public SuperPayTradeQueryResponse() {
        this.code = "";
        this.msg = "";
        this.data = new SuperPayTradeQueryInfo();
    }
}
