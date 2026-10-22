package com.bytedance.android.annie.card.web.resource;

import android.webkit.WebResourceResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f39220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f39221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f39222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f39223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WebResourceResponse f39224e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f39220a, r101.f39220a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f39221b, r101.f39221b) == true) goto L15;
        return false;
    L15:
        if (this.f39222c == r101.f39222c) goto L18;
        return false;
    L18:
        if (this.f39223d == r101.f39223d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f39224e, r101.f39224e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f39220a.hashCode() * 31) + this.f39221b.hashCode()) * 31;
        if (this.f39222c == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        long r103 = this.f39223d;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        WebResourceResponse r105 = this.f39224e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L11:
        return r104 + r106;
    L9:
        r106 = r105.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "WebResourceResponseInfo(resFrom=" + this.f39220a + ", resOriginFrom=" + this.f39221b + ", useForest=" + this.f39222c + ", geckoVersion=" + this.f39223d + ", response=" + this.f39224e + ')';
    }

    public b(String r100, String r101, boolean r102, long r103, WebResourceResponse r104) {
        Intrinsics.checkNotNullParameter(r100, "resFrom");
        Intrinsics.checkNotNullParameter(r101, "resOriginFrom");
        this.f39220a = r100;
        this.f39221b = r101;
        this.f39222c = r102;
        this.f39223d = r103;
        this.f39224e = r104;
    }

    public /* synthetic */ b(String r100, String r101, boolean r110, WebResourceResponse r111, int r112) {
        if ((r112 & 16) == 0) goto L5;
        r111 = null;
    L5:
        this(r100, r101, r110, 0, r111);
    }
}
