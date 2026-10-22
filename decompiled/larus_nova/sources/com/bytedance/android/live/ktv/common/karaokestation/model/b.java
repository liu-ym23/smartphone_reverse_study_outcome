package com.bytedance.android.live.ktv.common.karaokestation.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f69497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f69498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f69499c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (this.f69497a == r101.f69497a) goto L8;
        return false;
    L8:
        if (this.f69498b == r101.f69498b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f69499c, r101.f69499c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.f69497a * 31) + this.f69498b) * 31;
        String r101 = this.f69499c;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "DefaultTabData(tabMode=" + this.f69497a + ", defaultFirstLevelTabSer=" + this.f69498b + ", defaultTabSer=" + this.f69499c + ")";
    }

    public b(int r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "defaultTabSer");
        this.f69497a = r100;
        this.f69498b = r101;
        this.f69499c = r102;
    }
}
