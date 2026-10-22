package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ec/model/response/h1;", "", "Lcom/bytedance/android/ec/model/response/c1;", "minPrice", "Lcom/bytedance/android/ec/model/response/c1;", "b", "()Lcom/bytedance/android/ec/model/response/c1;", "setMinPrice", "(Lcom/bytedance/android/ec/model/response/c1;)V", "", "Lcom/bytedance/android/ec/model/response/e1;", "descriptions", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setDescriptions", "(Ljava/util/List;)V", "<init>", "()V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class h1 {

    @SerializedName("descriptions")
    private List<e1> descriptions;

    @SerializedName("min_price")
    private c1 minPrice;

    public h1() {
    }

    public final List<e1> a() {
        return this.descriptions;
    }

    public final c1 b() {
        return this.minPrice;
    }
}
