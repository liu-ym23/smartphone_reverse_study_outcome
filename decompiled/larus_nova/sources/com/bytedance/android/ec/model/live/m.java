package com.bytedance.android.ec.model.live;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/model/live/m;", "", "", "productId", "J", "b", "()J", "", "index", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class m {

    @SerializedName("product_index")
    private final int index;

    @SerializedName("product_id")
    private final long productId;

    public m() {
        this(0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L10;
        m r101 = (m) r100;
        if (this.productId == r101.productId) goto L8;
        return false;
    L8:
        if (this.index == r101.index) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.productId;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.index;
    }

    public final String toString() {
        return "ECInteractionCheckParam(productId=" + this.productId + ", index=" + this.index + ")";
    }

    public final int a() {
        return this.index;
    }

    public final long b() {
        return this.productId;
    }

    public m(long r100, int r101) {
        this.productId = r100;
        this.index = r101;
    }
}
