package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.amap.api.col.s.ce;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/openapi/n;", "", "", "path", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "envId", "b", "serviceId", "f", "", "header", "Ljava/util/Map;", "c", "()Ljava/util/Map;", com.alipay.sdk.m.p.e.f25671s, "d", ContainerPosition.BODY, "Ljava/lang/Object;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Object;", "", "timeout", "J", ce.f26391f, "()J", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName(ContainerPosition.BODY)
    private final Object body;

    @SerializedName("envID")
    private final String envId;

    @SerializedName("header")
    private final Map<String, String> header;

    @SerializedName(com.alipay.sdk.m.p.e.f25671s)
    private final String method;

    @SerializedName("path")
    private final String path;

    @SerializedName("serviceID")
    private final String serviceId;

    @SerializedName("timeout")
    private final long timeout;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L20;
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.path, r101.path) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.envId, r101.envId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.serviceId, r101.serviceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.header, r101.header) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.method, r101.method) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.body, r101.body) == true) goto L18;
        return false;
    L18:
        if (this.timeout == r101.timeout) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.path;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.envId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.serviceId;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.header;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.method;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Object r116 = this.body;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        int r117 = (r115 + r101) * 31;
        long r118 = this.timeout;
        return r117 + ((int) (r118 ^ (r118 >>> 32)));
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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
        return "CloudRequestParam(path=" + this.path + ", envId=" + this.envId + ", serviceId=" + this.serviceId + ", header=" + this.header + ", method=" + this.method + ", body=" + this.body + ", timeout=" + this.timeout + ")";
    }

    public final Object a() {
        return this.body;
    }

    public final String b() {
        return this.envId;
    }

    public final Map<String, String> c() {
        return this.header;
    }

    public final String d() {
        return this.method;
    }

    public final String e() {
        return this.path;
    }

    public final String f() {
        return this.serviceId;
    }

    public final long g() {
        return this.timeout;
    }
}
