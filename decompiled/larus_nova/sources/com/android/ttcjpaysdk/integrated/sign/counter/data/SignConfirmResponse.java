package com.android.ttcjpaysdk.integrated.sign.counter.data;

import android.text.TextUtils;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\f\rB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/data/SignConfirmResponse;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "code", "", "data", "Lcom/android/ttcjpaysdk/integrated/sign/counter/data/SignConfirmResponse$Data;", "error", "Lcom/android/ttcjpaysdk/integrated/sign/counter/data/ErrorBean;", "process", "isResponseOk", "", "Data", "PayParams", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SignConfirmResponse implements CJPayObject {
    public String code;
    public Data data;
    public ErrorBean error;
    public String process;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/data/SignConfirmResponse$Data;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "pay_params", "Lcom/android/ttcjpaysdk/integrated/sign/counter/data/SignConfirmResponse$PayParams;", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Data implements CJPayObject {
        public PayParams pay_params;

        public Data() {
            this.pay_params = new PayParams();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/data/SignConfirmResponse$PayParams;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "data", "", "ptcode", "trade_type", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PayParams implements CJPayObject {
        public String data;
        public String ptcode;
        public String trade_type;

        public PayParams() {
            this.data = "";
            this.ptcode = "";
            this.trade_type = "";
        }
    }

    public final boolean isResponseOk() {
        if (TextUtils.isEmpty(this.code) == false) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual("CA0000", this.code) == false) goto L7;
        return true;
    }

    public SignConfirmResponse() {
        this.code = "";
        this.error = new ErrorBean();
        this.process = "";
        this.data = new Data();
    }
}
