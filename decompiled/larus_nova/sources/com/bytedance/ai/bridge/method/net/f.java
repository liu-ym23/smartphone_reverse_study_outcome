package com.bytedance.ai.bridge.method.net;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f35753b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f35752a, r101.f35752a) == true) goto L12;
        return false;
    L12:
        if (this.f35753b == r101.f35753b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f35752a.hashCode() * 31;
        if (this.f35753b == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "NetworkStatusSnapshot(networkType=" + this.f35752a + ", isConnected=" + this.f35753b + ')';
    }

    public f(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "networkType");
        this.f35752a = r100;
        this.f35753b = r101;
    }
}
