package com.bytedance.android.livesdk;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/k;", "", "", "data", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "Lcom/bytedance/android/livesdk/i;", "extra", "Lcom/bytedance/android/livesdk/i;", "getExtra", "()Lcom/bytedance/android/livesdk/i;", "statusCode", "getStatusCode", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k {

    @SerializedName("data")
    private final int data;

    @SerializedName("extra")
    private final i extra;

    @SerializedName("status_code")
    private final int statusCode;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L12;
        k r101 = (k) r100;
        if (this.data == r101.data) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L10;
        return false;
    L10:
        if (this.statusCode == r101.statusCode) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = this.data * 31;
        i r101 = this.extra;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return ((r100 + r102) * 31) + this.statusCode;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "HistoryResponse(data=" + this.data + ", extra=" + this.extra + ", statusCode=" + this.statusCode + ")";
    }

    public final int a() {
        return this.data;
    }
}
