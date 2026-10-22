package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/ec/model/response/l;", "", "", CloudControlInf.ROUTE, "Ljava/lang/String;", "getRoute", "()Ljava/lang/String;", "", "reqParam", "Ljava/util/Map;", "getReqParam", "()Ljava/util/Map;", "", "deferTime", "J", "getDeferTime", "()J", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class l {

    @SerializedName("defer_time")
    private final long deferTime;

    @SerializedName("req_param")
    private final Map<String, String> reqParam;

    @SerializedName(CloudControlInf.ROUTE)
    private final String route;

    public final String a() {
        return this.route;
    }

    public final Map<String, String> b() {
        return this.reqParam;
    }

    public final long c() {
        return this.deferTime;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L12;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.route, r101.route) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.reqParam, r101.reqParam) == true) goto L10;
        return false;
    L10:
        if (this.deferTime == r101.deferTime) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.route;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.reqParam;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        long r106 = this.deferTime;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DeferActionMeta(route=" + this.route + ", reqParam=" + this.reqParam + ", deferTime=" + this.deferTime + ")";
    }

    public l() {
        this.route = null;
        this.reqParam = null;
        this.deferTime = 0;
    }
}
