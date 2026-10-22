package com.bytedance.android.ec.hybrid.list.entity;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class j implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Double f47117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Double f47118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Double f47119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Double f47120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Double f47121e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Double f47122f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f47123g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f47124h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f47125i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f47126j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f47127k;

    public j() {
    }

    public final j a() {
        j r100 = new j();
        r100.f47117a = this.f47117a;
        r100.f47118b = this.f47118b;
        r100.f47119c = this.f47119c;
        r100.f47120d = this.f47120d;
        r100.f47121e = this.f47121e;
        r100.f47122f = this.f47122f;
        r100.f47123g = this.f47123g;
        r100.f47124h = this.f47124h;
        r100.f47125i = this.f47125i;
        r100.f47126j = this.f47126j;
        r100.f47127k = this.f47127k;
        return r100;
    }

    public final int hashCode() {
        Double r100 = this.f47117a;
        int r101 = 0;
        if (r100 == null) goto L5;
        long r102 = Double.doubleToLongBits(r100.doubleValue());
        int r103 = (int) (r102 ^ (r102 >>> 32));
    L6:
        int r104 = r103 * 31;
        Double r105 = this.f47118b;
        if (r105 == null) goto L9;
        long r106 = Double.doubleToLongBits(r105.doubleValue());
        int r107 = (int) (r106 ^ (r106 >>> 32));
    L10:
        int r108 = (r104 + r107) * 31;
        Double r109 = this.f47119c;
        if (r109 == null) goto L13;
        long r110 = Double.doubleToLongBits(r109.doubleValue());
        int r111 = (int) (r110 ^ (r110 >>> 32));
    L14:
        int r112 = (r108 + r111) * 31;
        Double r113 = this.f47120d;
        if (r113 == null) goto L17;
        long r114 = Double.doubleToLongBits(r113.doubleValue());
        int r115 = (int) (r114 ^ (r114 >>> 32));
    L18:
        int r116 = (r112 + r115) * 31;
        Double r117 = this.f47121e;
        if (r117 == null) goto L21;
        long r118 = Double.doubleToLongBits(r117.doubleValue());
        int r119 = (int) (r118 ^ (r118 >>> 32));
    L22:
        int r120 = (r116 + r119) * 31;
        Double r121 = this.f47122f;
        if (r121 == null) goto L25;
        long r122 = Double.doubleToLongBits(r121.doubleValue());
        int r123 = (int) (r122 ^ (r122 >>> 32));
    L26:
        int r124 = (r120 + r123) * 31;
        String r125 = this.f47124h;
        if (r125 == null) goto L29;
        int r126 = r125.hashCode();
    L30:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f47125i;
        if (r128 == null) goto L33;
        int r129 = r128.hashCode();
    L34:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f47126j;
        if (r131 == null) goto L37;
        int r132 = r131.hashCode();
    L38:
        int r133 = (r130 + r132) * 31;
        String r134 = this.f47127k;
        if (r134 == null) goto L42;
        r101 = r134.hashCode();
    L42:
        return r133 + r101;
    L37:
        r132 = 0;
        goto L38
    L33:
        r129 = 0;
        goto L34
    L29:
        r126 = 0;
        goto L30
    L25:
        r123 = 0;
        goto L26
    L21:
        r119 = 0;
        goto L22
    L17:
        r115 = 0;
        goto L18
    L13:
        r111 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        return a();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof j) == false) goto L26;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f47117a, r101.f47117a) == true) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(this.f47118b, r101.f47118b) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f47119c, r101.f47119c) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.f47120d, r101.f47120d) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.f47125i, r101.f47125i) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f47124h, r101.f47124h) == true) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(this.f47127k, r101.f47127k) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.f47126j, r101.f47126j) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f47121e, r101.f47121e) == true) goto L23;
        return false;
    L23:
        if (Intrinsics.areEqual(this.f47122f, r101.f47122f) == false) goto L36;
        return true;
    L36:
        return false;
    L26:
        return false;
    }
}
