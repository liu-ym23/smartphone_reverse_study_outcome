package com.bytedance.android.livesdk.interactivity.service.monitor;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f140940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f140941b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L10;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f140940a, r101.f140940a) == true) goto L8;
        return false;
    L8:
        if (this.f140941b == r101.f140941b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f140940a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.f140941b;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "ValueNode(nodeName=" + this.f140940a + ", nodeValue=" + this.f140941b + ")";
    }

    public h(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "nodeName");
        this.f140940a = r100;
        this.f140941b = r101;
    }
}
