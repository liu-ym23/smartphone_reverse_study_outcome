package com.bytedance.android.live.profit.privilege.model.touch;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f88429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final py.k f88430b;

    public i() {
        this(false, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L10;
        i r101 = (i) r100;
        if (this.f88429a == r101.f88429a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f88430b, r101.f88430b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.f88429a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        py.k r103 = this.f88430b;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "LightInfoData(isOn=" + this.f88429a + ", image=" + this.f88430b + ")";
    }

    public i(boolean r100, py.k r101) {
        this.f88429a = r100;
        this.f88430b = r101;
    }
}
