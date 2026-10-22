package com.bytedance.android.shopping.feed.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f175465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f175466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f175467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f175468d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s) == false) goto L14;
        s r101 = (s) r100;
        if (this.f175465a == r101.f175465a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f175466b, r101.f175466b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f175467c, r101.f175467c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f175468d, r101.f175468d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f175465a * 31;
        String r101 = this.f175466b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f175467c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f175468d;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        return r107 + r102;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "MemberShipData(status=" + this.f175465a + ", buttonText=" + this.f175466b + ", joinUrl=" + this.f175467c + ", defaultButtonText=" + this.f175468d + ")";
    }

    public s(int r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "buttonText");
        Intrinsics.checkNotNullParameter(r102, "joinUrl");
        Intrinsics.checkNotNullParameter(r103, "defaultButtonText");
        this.f175465a = r100;
        this.f175466b = r101;
        this.f175467c = r102;
        this.f175468d = r103;
    }
}
