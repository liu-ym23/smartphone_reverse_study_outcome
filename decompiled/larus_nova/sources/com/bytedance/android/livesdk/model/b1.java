package com.bytedance.android.livesdk.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f153929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f153930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f153931c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b1) == false) goto L12;
        b1 r101 = (b1) r100;
        if (Intrinsics.areEqual(this.f153929a, r101.f153929a) == true) goto L8;
        return false;
    L8:
        if (this.f153930b == r101.f153930b) goto L10;
        return false;
    L10:
        if (this.f153931c == r101.f153931c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f153929a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = ((r101 * 31) + this.f153930b) * 31;
        long r103 = this.f153931c;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "UserInfoSubTitleAnimEvent(content=" + this.f153929a + ", color=" + this.f153930b + ", durationInMs=" + this.f153931c + ")";
    }

    public b1(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.f153929a = r100;
        this.f153930b = r101;
        this.f153931c = 3000;
    }
}
