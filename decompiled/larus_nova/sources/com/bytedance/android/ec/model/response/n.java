package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/model/response/n;", "", "", "trackExtra", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "singleSkuId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName("single_sku_id")
    private final String singleSkuId;

    @SerializedName("track_extra")
    private final String trackExtra;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L10;
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.trackExtra, r101.trackExtra) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.singleSkuId, r101.singleSkuId) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.trackExtra;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.singleSkuId;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECAddCartParams(trackExtra=" + this.trackExtra + ", singleSkuId=" + this.singleSkuId + ")";
    }

    public n() {
        this.trackExtra = null;
        this.singleSkuId = null;
    }

    public final String a() {
        return this.singleSkuId;
    }

    public final String b() {
        return this.trackExtra;
    }
}
