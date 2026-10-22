package com.android.ttcjpaysdk.base.settings.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/settings/bean/CJPayFaceCompareInCertConfig;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "asynchronous_invoke_result", "", "compare_in_cert_has_src", "compare_in_cert_not_src", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayFaceCompareInCertConfig implements CJPayObject, Serializable {
    public String asynchronous_invoke_result;
    public String compare_in_cert_has_src;
    public String compare_in_cert_not_src;

    public CJPayFaceCompareInCertConfig() {
        this.compare_in_cert_not_src = "1";
        this.compare_in_cert_has_src = "1";
        this.asynchronous_invoke_result = "1";
    }
}
