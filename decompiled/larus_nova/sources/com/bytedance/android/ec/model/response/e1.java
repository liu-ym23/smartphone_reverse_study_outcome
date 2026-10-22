package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/bytedance/android/ec/model/response/e1;", "", "Lcom/bytedance/android/ec/model/response/PriceDescriptionType;", "descriptionType", "Lcom/bytedance/android/ec/model/response/PriceDescriptionType;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/model/response/PriceDescriptionType;", "setDescriptionType", "(Lcom/bytedance/android/ec/model/response/PriceDescriptionType;)V", "Lcom/bytedance/android/ec/model/response/n0;", "text", "Lcom/bytedance/android/ec/model/response/n0;", "d", "()Lcom/bytedance/android/ec/model/response/n0;", "setText", "(Lcom/bytedance/android/ec/model/response/n0;)V", "Lcom/bytedance/android/ec/model/response/m;", "regularPrice", "Lcom/bytedance/android/ec/model/response/m;", "c", "()Lcom/bytedance/android/ec/model/response/m;", "setRegularPrice", "(Lcom/bytedance/android/ec/model/response/m;)V", "Lcom/bytedance/android/ec/model/response/m0;", "exclusive", "Lcom/bytedance/android/ec/model/response/m0;", "b", "()Lcom/bytedance/android/ec/model/response/m0;", "setExclusive", "(Lcom/bytedance/android/ec/model/response/m0;)V", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class e1 {

    @SerializedName("description_type")
    private PriceDescriptionType descriptionType;

    @SerializedName("exclusive")
    private m0 exclusive;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_REGULAR_PRICE)
    private m regularPrice;

    @SerializedName("text")
    private n0 text;

    public e1() {
    }

    public final PriceDescriptionType a() {
        return this.descriptionType;
    }

    public final m0 b() {
        return this.exclusive;
    }

    public final m c() {
        return this.regularPrice;
    }

    public final n0 d() {
        return this.text;
    }
}
