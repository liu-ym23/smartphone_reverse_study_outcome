package com.bytedance.android.gamecp.business.gamedetail.page.root;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f55609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f55610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f55611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final JSONObject f55612e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f55613f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof z) == false) goto L18;
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.f55608a, r101.f55608a) == true) goto L8;
        return false;
    L8:
        if (this.f55609b == r101.f55609b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f55610c, r101.f55610c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f55611d, r101.f55611d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f55612e, r101.f55612e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f55613f, r101.f55613f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f55608a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f55609b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        String r105 = this.f55610c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f55611d;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        JSONObject r111 = this.f55612e;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f55613f;
        if (r114 == null) goto L22;
        r101 = r114.hashCode();
    L22:
        return r113 + r101;
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GameDetailPreRequestCacheData(rawData=" + this.f55608a + ", cacheTime=" + this.f55609b + ", videoId=" + this.f55610c + ", roomId=" + this.f55611d + ", data=" + this.f55612e + ", dataFrom=" + this.f55613f + ")";
    }

    public z(String r100, long r101, String r102, String r103, JSONObject r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "rawData");
        this.f55608a = r100;
        this.f55609b = r101;
        this.f55610c = r102;
        this.f55611d = r103;
        this.f55612e = r104;
        this.f55613f = r105;
    }
}
