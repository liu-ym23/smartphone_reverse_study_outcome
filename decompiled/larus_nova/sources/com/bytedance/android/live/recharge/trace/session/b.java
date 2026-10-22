package com.bytedance.android.live.recharge.trace.session;

import com.bytedance.android.live.revenue.common.u0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f90397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f90398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u0 f90399c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f90397a, r101.f90397a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f90398b, r101.f90398b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f90399c, r101.f90399c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f90397a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f90398b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        u0 r107 = this.f90399c;
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
        return "SessionEvent(group=" + this.f90397a + ", name=" + this.f90398b + ", time=" + this.f90399c + ")";
    }

    public b(String r100, String r101, u0 r102) {
        Intrinsics.checkNotNullParameter(r100, "group");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "time");
        this.f90397a = r100;
        this.f90398b = r101;
        this.f90399c = r102;
    }
}
