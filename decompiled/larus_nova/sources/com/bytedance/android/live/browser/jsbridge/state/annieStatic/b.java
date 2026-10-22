package com.bytedance.android.live.browser.jsbridge.state.annieStatic;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/state/annieStatic/b;", "", "", "cacheData", "Ljava/lang/String;", "getCacheData", "()Ljava/lang/String;", "", "statusCode", "I", "getStatusCode", "()I", "", WiseOpenHianalyticsData.UNION_COSTTIME, "J", "getCostTime", "()J", "failReason", "getFailReason", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("cacheData")
    private final String cacheData;

    @SerializedName(WiseOpenHianalyticsData.UNION_COSTTIME)
    private final long costTime;

    @SerializedName("failReason")
    private final String failReason;

    @SerializedName("statusCode")
    private final int statusCode;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.cacheData, r101.cacheData) == true) goto L8;
        return false;
    L8:
        if (this.statusCode == r101.statusCode) goto L10;
        return false;
    L10:
        if (this.costTime == r101.costTime) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.failReason, r101.failReason) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.cacheData;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.statusCode) * 31;
        long r104 = this.costTime;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        String r106 = this.failReason;
        if (r106 == null) goto L10;
        r101 = r106.hashCode();
    L10:
        return r105 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CacheResponse(cacheData=" + this.cacheData + ", statusCode=" + this.statusCode + ", costTime=" + this.costTime + ", failReason=" + this.failReason + ")";
    }

    public b(String r100, int r101, long r102, String r103) {
        this.cacheData = r100;
        this.statusCode = r101;
        this.costTime = r102;
        this.failReason = r103;
    }
}
