package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ec/model/response/g1;", "", "Lcom/bytedance/android/ec/model/response/m1;", "button", "Lcom/bytedance/android/ec/model/response/m1;", "b", "()Lcom/bytedance/android/ec/model/response/m1;", "setButton", "(Lcom/bytedance/android/ec/model/response/m1;)V", "Lcom/bytedance/android/ec/model/response/l1;", "addCart", "Lcom/bytedance/android/ec/model/response/l1;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/model/response/l1;", "setAddCart", "(Lcom/bytedance/android/ec/model/response/l1;)V", "Lcom/bytedance/android/ec/model/response/v;", "stepper", "Lcom/bytedance/android/ec/model/response/v;", "c", "()Lcom/bytedance/android/ec/model/response/v;", "setStepper", "(Lcom/bytedance/android/ec/model/response/v;)V", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class g1 {

    @SerializedName("add_cart")
    private l1 addCart;

    @SerializedName("button")
    private m1 button;

    @SerializedName("stepper")
    private v stepper;

    public g1() {
    }

    public final l1 a() {
        return this.addCart;
    }

    public final m1 b() {
        return this.button;
    }

    public final v c() {
        return this.stepper;
    }
}
