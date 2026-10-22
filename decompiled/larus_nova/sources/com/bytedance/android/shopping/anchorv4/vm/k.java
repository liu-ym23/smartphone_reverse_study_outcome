package com.bytedance.android.shopping.anchorv4.vm;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f167771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f167772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f167773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Integer f167774d;

    public k() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L14;
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f167771a, r101.f167771a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f167772b, r101.f167772b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f167773c, r101.f167773c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f167774d, r101.f167774d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f167771a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f167772b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f167773c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f167774d;
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
        return "ShareParams(userAddrId=" + this.f167771a + ", packLogId=" + this.f167772b + ", addrType=" + this.f167773c + ", shopRecTabIndex=" + this.f167774d + ")";
    }

    public k(int r100) {
        this.f167771a = null;
        this.f167772b = null;
        this.f167773c = null;
        this.f167774d = null;
    }
}
