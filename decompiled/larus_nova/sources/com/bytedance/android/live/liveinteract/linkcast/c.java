package com.bytedance.android.live.liveinteract.linkcast;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f74320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f74321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f74322c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f74320a, r101.f74320a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f74321b, r101.f74321b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f74322c, r101.f74322c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f74320a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f74321b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f74322c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LinkCastEntranceInfo(appId=" + this.f74320a + ", iconUrl=" + this.f74321b + ", name=" + this.f74322c + ")";
    }

    public c(String r100, String r101, String r102) {
        this.f74320a = r100;
        this.f74321b = r101;
        this.f74322c = r102;
    }
}
