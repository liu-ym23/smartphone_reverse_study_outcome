package com.bytedance.android.livesdk.interactivity.service.monitor;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f140936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f140937b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f140936a, r101.f140936a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f140937b, r101.f140937b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f140936a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f140937b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ConstantNode(nodeName=" + this.f140936a + ", nodeValue=" + this.f140937b + ")";
    }

    public b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "nodeName");
        Intrinsics.checkNotNullParameter(r101, "nodeValue");
        this.f140936a = r100;
        this.f140937b = r101;
    }
}
