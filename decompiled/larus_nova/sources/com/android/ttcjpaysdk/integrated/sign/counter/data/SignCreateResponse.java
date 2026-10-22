package com.android.ttcjpaysdk.integrated.sign.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/sign/counter/data/SignCreateResponse;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "code", "", "data", "Lcom/android/ttcjpaysdk/integrated/sign/counter/data/DataInfo;", "error", "Lcom/android/ttcjpaysdk/integrated/sign/counter/data/ErrorBean;", "process", "isResponseOk", "", "integrated-sign-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SignCreateResponse implements CJPayObject {
    public String code;
    public DataInfo data;
    public ErrorBean error;
    public String process;

    public final boolean isResponseOk() {
        return Intrinsics.areEqual("CA0000", this.code);
    }

    public SignCreateResponse() {
        this.code = "";
        this.error = new ErrorBean();
        this.process = "";
        this.data = new DataInfo();
    }
}
