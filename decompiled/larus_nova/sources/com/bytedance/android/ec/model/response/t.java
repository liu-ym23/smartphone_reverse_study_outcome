package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/model/response/t;", "", "", "coverUrl", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "minPrice", "J", "b", "()J", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class t {

    @SerializedName("cover_url")
    private final String coverUrl;

    @SerializedName("min_price")
    private final long minPrice;

    public t() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t) == false) goto L10;
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.coverUrl, r101.coverUrl) == true) goto L8;
        return false;
    L8:
        if (this.minPrice == r101.minPrice) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.coverUrl;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.minPrice;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "ECProductBottomItem(coverUrl=" + this.coverUrl + ", minPrice=" + this.minPrice + ")";
    }

    public final String a() {
        return this.coverUrl;
    }

    public final long b() {
        return this.minPrice;
    }

    public /* synthetic */ t(String r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, 0);
    }

    public t(String r100, long r101) {
        this.coverUrl = r100;
        this.minPrice = r101;
    }
}
