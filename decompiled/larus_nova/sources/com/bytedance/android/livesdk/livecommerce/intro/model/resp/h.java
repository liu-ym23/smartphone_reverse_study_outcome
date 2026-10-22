package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ec.model.response.PrefetchOrder;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/h;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "detailCover", "Lcom/bytedance/android/ec/model/ECUrlModel;", "c", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Lcom/bytedance/android/ec/model/response/PrefetchOrder;", "prefetchOrder", "Lcom/bytedance/android/ec/model/response/PrefetchOrder;", "d", "()Lcom/bytedance/android/ec/model/response/PrefetchOrder;", "", "checkCallback", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "Lcom/bytedance/android/ec/model/response/ECHotAtmosphere;", "detailAtmosphere", "Lcom/bytedance/android/ec/model/response/ECHotAtmosphere;", "b", "()Lcom/bytedance/android/ec/model/response/ECHotAtmosphere;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("check_callback")
    private final String checkCallback;

    @SerializedName("detail_atmosphere")
    private final ECHotAtmosphere detailAtmosphere;

    @SerializedName("detail_cover")
    private final ECUrlModel detailCover;

    @SerializedName("prefetch_order")
    private final PrefetchOrder prefetchOrder;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L14;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.detailCover, r101.detailCover) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.prefetchOrder, r101.prefetchOrder) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.checkCallback, r101.checkCallback) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.detailAtmosphere, r101.detailAtmosphere) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r100 = this.detailCover;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        PrefetchOrder r104 = this.prefetchOrder;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.checkCallback;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ECHotAtmosphere r110 = this.detailAtmosphere;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroBizExtendParam(detailCover=" + this.detailCover + ", prefetchOrder=" + this.prefetchOrder + ", checkCallback=" + this.checkCallback + ", detailAtmosphere=" + this.detailAtmosphere + ")";
    }

    public h() {
        this.detailCover = null;
        this.prefetchOrder = null;
        this.checkCallback = null;
        this.detailAtmosphere = null;
    }

    public final String a() {
        return this.checkCallback;
    }

    public final ECHotAtmosphere b() {
        return this.detailAtmosphere;
    }

    public final ECUrlModel c() {
        return this.detailCover;
    }

    public final PrefetchOrder d() {
        return this.prefetchOrder;
    }
}
