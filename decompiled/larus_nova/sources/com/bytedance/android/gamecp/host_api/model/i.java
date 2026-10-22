package com.bytedance.android.gamecp.host_api.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f57370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f57371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f57372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f57373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f57374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f57375f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L18;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f57370a, r101.f57370a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f57371b, r101.f57371b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f57372c, r101.f57372c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f57373d, r101.f57373d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f57374e, r101.f57374e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f57375f, r101.f57375f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f57370a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f57371b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f57372c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f57373d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f57374e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f57375f;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
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
        return "PushInfo(title=" + this.f57370a + ", content=" + this.f57371b + ", buttonText=" + this.f57372c + ", iconUrl=" + this.f57373d + ", gameId=" + this.f57374e + ", gameName=" + this.f57375f + ")";
    }

    public i() {
        this("", "", "立即前往", "", "", "");
    }

    public i(String r100, String r101, String r102, String r103, String r104, String r105) {
        this.f57370a = r100;
        this.f57371b = r101;
        this.f57372c = r102;
        this.f57373d = r103;
        this.f57374e = r104;
        this.f57375f = r105;
    }
}
