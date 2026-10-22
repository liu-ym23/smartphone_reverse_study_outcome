package com.bytedance.android.live.revlink.impl.multianchor.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f94947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f94948b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L10;
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f94947a, r101.f94947a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f94948b, r101.f94948b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f94947a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f94948b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "InviteeLogParams(inviteeID=" + this.f94947a + ", inviteeList=" + this.f94948b + ")";
    }

    public m(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "inviteeList");
        this.f94947a = r100;
        this.f94948b = r101;
    }
}
