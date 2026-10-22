package com.bytedance.android.live.browser.jsbridge.upload;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f64100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f64101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f64102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f64103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f64104e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f64105f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f64106g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f64107h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof z) == false) goto L22;
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.f64100a, r101.f64100a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f64101b, r101.f64101b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f64102c, r101.f64102c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f64103d, r101.f64103d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f64104e, r101.f64104e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f64105f, r101.f64105f) == true) goto L18;
        return false;
    L18:
        if (this.f64106g == r101.f64106g) goto L20;
        return false;
    L20:
        if (this.f64107h == r101.f64107h) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f64100a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f64101b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f64102c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f64103d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f64104e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f64105f;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return ((((r115 + r101) * 31) + this.f64106g) * 31) + this.f64107h;
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
        return "UploadImageXConfig(hostName=" + this.f64100a + ", accessKeyId=" + this.f64101b + ", secretAccessKey=" + this.f64102c + ", sessionToken=" + this.f64103d + ", serviceId=" + this.f64104e + ", traceId=" + this.f64105f + ", sliceSize=" + this.f64106g + ", socketNum=" + this.f64107h + ")";
    }

    public z(String r100, String r101, String r102, String r103, String r104, String r105, int r106, int r107) {
        Intrinsics.checkNotNullParameter(r100, "hostName");
        Intrinsics.checkNotNullParameter(r101, "accessKeyId");
        Intrinsics.checkNotNullParameter(r102, "secretAccessKey");
        Intrinsics.checkNotNullParameter(r103, "sessionToken");
        Intrinsics.checkNotNullParameter(r104, "serviceId");
        Intrinsics.checkNotNullParameter(r105, "traceId");
        this.f64100a = r100;
        this.f64101b = r101;
        this.f64102c = r102;
        this.f64103d = r103;
        this.f64104e = r104;
        this.f64105f = r105;
        this.f64106g = r106;
        this.f64107h = r107;
    }
}
