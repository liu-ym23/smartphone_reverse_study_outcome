package com.bytedance.android.sdk.bdticketguard.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f163602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f163603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f163604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f163605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f163606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f163607f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L26:
        return true;
    L5:
        if ((r100 instanceof c) == false) goto L25;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f163602a, r101.f163602a) == false) goto L25;
        if (this.f163603b != r101.f163603b) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L25;
        if (this.f163604c != r101.f163604c) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == false) goto L25;
        if (Intrinsics.areEqual(this.f163605d, r101.f163605d) == false) goto L25;
        if (Intrinsics.areEqual(this.f163606e, r101.f163606e) == false) goto L25;
        if (Intrinsics.areEqual(this.f163607f, r101.f163607f) == false) goto L25;
    L16:
        r103 = false;
        goto L17
    L11:
        r102 = false;
    L25:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f163602a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f163603b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f163604c;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        String r107 = this.f163605d;
        if (r107 == null) goto L9;
        int r108 = r107.hashCode();
    L10:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f163606e;
        if (r110 == null) goto L13;
        int r111 = r110.hashCode();
    L14:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f163607f;
        if (r113 == null) goto L18;
        r101 = r113.hashCode();
    L18:
        return r112 + r101;
    L13:
        r111 = 0;
        goto L14
    L9:
        r108 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SecTsData(secTs=" + this.f163602a + ", serverTime=" + this.f163603b + ", systemTime=" + this.f163604c + ", path=" + this.f163605d + ", logId=" + this.f163606e + ", lastServerTime=" + this.f163607f + ")";
    }

    public /* synthetic */ c(String r110, long r111, long r112, String r113, String r114, int r115) {
        if ((r115 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r115 & 16) == 0) goto L9;
        String r101 = null;
    L10:
        this(r110, r111, r112, r100, r101, null);
        return;
    L9:
        r101 = r114;
        goto L10
    L5:
        r100 = r113;
        goto L7
    }

    public c(String r100, long r101, long r102, String r103, String r104, Long r105) {
        this.f163602a = r100;
        this.f163603b = r101;
        this.f163604c = r102;
        this.f163605d = r103;
        this.f163606e = r104;
        this.f163607f = r105;
    }
}
