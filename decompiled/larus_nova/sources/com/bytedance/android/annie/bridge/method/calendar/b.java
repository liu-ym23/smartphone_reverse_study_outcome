package com.bytedance.android.annie.bridge.method.calendar;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f38581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f38582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f38583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f38584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f38585e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f38586f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f38587g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f38588h;

    public b() {
        this(0, null, null, null, null, 0, null, 255, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f38581a == r101.f38581a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f38582b, r101.f38582b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f38583c, r101.f38583c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f38584d, r101.f38584d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f38585e, r101.f38585e) == true) goto L24;
        return false;
    L24:
        if (this.f38586f == r101.f38586f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f38587g, r101.f38587g) == true) goto L30;
        return false;
    L30:
        if (this.f38588h == r101.f38588h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f38581a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f38582b;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f38583c;
        if (r106 != null) goto L9;
        int r107 = 0;
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f38584d;
        if (r109 != null) goto L13;
        int r110 = 0;
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f38585e;
        if (r112 != null) goto L17;
        int r113 = 0;
    L18:
        int r114 = (((r111 + r113) * 31) + this.f38586f) * 31;
        String r115 = this.f38587g;
        if (r115 == null) goto L23;
        r103 = r115.hashCode();
    L23:
        return ((r114 + r103) * 31) + this.f38588h;
    L17:
        r113 = r112.hashCode();
        goto L18
    L13:
        r110 = r109.hashCode();
        goto L14
    L9:
        r107 = r106.hashCode();
        goto L10
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public final String toString() {
        return "CalendarModel(id=" + this.f38581a + ", name=" + this.f38582b + ", displayName=" + this.f38583c + ", accountType=" + this.f38584d + ", accountName=" + this.f38585e + ", visible=" + this.f38586f + ", ownerAccount=" + this.f38587g + ", accessLevel=" + this.f38588h + ')';
    }

    public b(long r100, String r101, String r102, String r103, String r104, int r105, String r106, int r107) {
        this.f38581a = r100;
        this.f38582b = r101;
        this.f38583c = r102;
        this.f38584d = r103;
        this.f38585e = r104;
        this.f38586f = r105;
        this.f38587g = r106;
        this.f38588h = r107;
    }

    public /* synthetic */ b(long r110, String r111, String r112, String r113, String r114, int r115, String r116, int r210, int r211) {
        if ((r210 & 1) == 0) goto L5;
        long r100 = 0;
    L6:
        String r101 = null;
        if ((r210 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r105 = null;
    L22:
        int r106 = 0;
        if ((r210 & 32) == 0) goto L25;
        int r107 = 0;
    L27:
        if ((r210 & 64) != 0) goto L31;
        r101 = r116;
    L31:
        if ((r210 & 128) == 0) goto L33;
        r106 = -1;
    L33:
        this(r100, r102, r103, r104, r105, r107, r101, r106);
        return;
    L25:
        r107 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L22
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L6
    }
}
