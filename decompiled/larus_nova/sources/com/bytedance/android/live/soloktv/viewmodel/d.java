package com.bytedance.android.live.soloktv.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f101877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f101878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f101879c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f101877a, r101.f101877a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f101878b, r101.f101878b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f101879c, r101.f101879c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f101877a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f101878b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f101879c;
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
        return "PracticeMusicUIState(name=" + this.f101877a + ", duration=" + this.f101878b + ", authorName=" + this.f101879c + ")";
    }

    public d(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "duration");
        Intrinsics.checkNotNullParameter(r102, "authorName");
        this.f101877a = r100;
        this.f101878b = r101;
        this.f101879c = r102;
    }
}
