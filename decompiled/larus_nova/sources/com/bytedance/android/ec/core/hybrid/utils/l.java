package com.bytedance.android.ec.core.hybrid.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f44315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f44316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f44317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f44318d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L14;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f44315a, r101.f44315a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f44316b, r101.f44316b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f44317c, r101.f44317c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f44318d, r101.f44318d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f44315a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f44316b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f44317c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f44318d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "OrderDetailStruct(type=" + this.f44315a + ", from=" + this.f44316b + ", key=" + this.f44317c + ", defaultVal=" + this.f44318d + ")";
    }

    public final String getType() {
        return this.f44315a;
    }

    public l(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "from");
        Intrinsics.checkNotNullParameter(r102, "key");
        Intrinsics.checkNotNullParameter(r103, "defaultVal");
        this.f44315a = r100;
        this.f44316b = r101;
        this.f44317c = r102;
        this.f44318d = r103;
    }
}
