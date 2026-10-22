package com.bytedance.android.live.recharge.platform.business.model.diamond;

import com.bytedance.android.livesdkapi.depend.model.IChargeDeal;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/model/diamond/h;", "", "", "Lcom/bytedance/android/livesdkapi/depend/model/IChargeDeal;", "data", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "d", "(Ljava/util/List;)V", "Lcom/bytedance/android/live/recharge/model/diamond/a;", "extra", "Lcom/bytedance/android/live/recharge/model/diamond/a;", "b", "()Lcom/bytedance/android/live/recharge/model/diamond/a;", "setExtra", "(Lcom/bytedance/android/live/recharge/model/diamond/a;)V", "", "timestamp", "J", "c", "()J", "setTimestamp", "(J)V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class h {

    @SerializedName("data")
    private List<IChargeDeal> data;

    @SerializedName("extra")
    private com.bytedance.android.live.recharge.model.diamond.a extra;

    @SerializedName("timestamp")
    private long timestamp;

    public h() {
        this(null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L12;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L10;
        return false;
    L10:
        if (this.timestamp == r101.timestamp) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<IChargeDeal> r100 = this.data;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        com.bytedance.android.live.recharge.model.diamond.a r104 = this.extra;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        long r106 = this.timestamp;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LocalDealSetCache(data=" + this.data + ", extra=" + this.extra + ", timestamp=" + this.timestamp + ")";
    }

    public final List<IChargeDeal> a() {
        return this.data;
    }

    public final com.bytedance.android.live.recharge.model.diamond.a b() {
        return this.extra;
    }

    public final long c() {
        return this.timestamp;
    }

    public final void d(List<IChargeDeal> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.data = r100;
    }

    public h(List r100, com.bytedance.android.live.recharge.model.diamond.a r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = new ArrayList();
    L6:
        if ((r102 & 2) == 0) goto L9;
        r101 = new com.bytedance.android.live.recharge.model.diamond.a();
    L9:
        if ((r102 & 4) == 0) goto L11;
        long r103 = System.currentTimeMillis();
    L12:
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "extra");
        this.data = r100;
        this.extra = r101;
        this.timestamp = r103;
        return;
    L11:
        r103 = 0;
        goto L12
    }
}
