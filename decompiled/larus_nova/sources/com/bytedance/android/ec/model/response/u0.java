package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/ec/model/response/u0;", "", "Lcom/bytedance/android/ec/model/response/k;", "countDown", "Lcom/bytedance/android/ec/model/response/k;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/model/response/k;", "setCountDown", "(Lcom/bytedance/android/ec/model/response/k;)V", "", "fallback", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setFallback", "(Ljava/lang/String;)V", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class u0 {

    @SerializedName("count_down")
    private k countDown;

    @SerializedName("fallback")
    private String fallback;

    public u0() {
    }

    public final k a() {
        return this.countDown;
    }

    public final String b() {
        return this.fallback;
    }
}
