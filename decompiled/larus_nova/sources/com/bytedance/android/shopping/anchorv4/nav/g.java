package com.bytedance.android.shopping.anchorv4.nav;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f167174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f167175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f167176c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L12;
        g r101 = (g) r100;
        if (this.f167174a == r101.f167174a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f167175b, r101.f167175b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f167176c, r101.f167176c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f167174a * 31;
        String r101 = this.f167175b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f167176c;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "TabInfo(index=" + this.f167174a + ", id=" + this.f167175b + ", logName=" + this.f167176c + ")";
    }

    public g(int r100, String r101, String r102) {
        this.f167174a = r100;
        this.f167175b = r101;
        this.f167176c = r102;
    }
}
