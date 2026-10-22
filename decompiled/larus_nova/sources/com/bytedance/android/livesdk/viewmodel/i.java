package com.bytedance.android.livesdk.viewmodel;

/* JADX INFO: loaded from: classes11.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f159328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f159329b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L10;
        i r101 = (i) r100;
        if (this.f159328a == r101.f159328a) goto L8;
        return false;
    L8:
        if (this.f159329b == r101.f159329b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    public final int hashCode() {
        long r100 = this.f159328a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        boolean r102 = this.f159329b;
        ?? r103 = r102;
        if (r102 == false) goto L6;
        r103 = 1;
    L6:
        return r101 + r103;
    }

    public final String toString() {
        return "ShowLoading(tabId=" + this.f159328a + ", isChangeTab=" + this.f159329b + ")";
    }

    public i(long r100) {
        this.f159328a = r100;
        this.f159329b = true;
    }
}
