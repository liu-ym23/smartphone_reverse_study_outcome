package com.bytedance.android.gamecp.business.dynamiccommon.widget;

import com.bytedance.ies.sve_core.p;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f53153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f53154b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.f53153a == r101.f53153a) goto L8;
        return false;
    L8:
        if (this.f53154b == r101.f53154b) goto L16;
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
        boolean r100 = this.f53153a;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return (r101 * 31) + this.f53154b;
    }

    public final String toString() {
        return "LoadingProps(showLoading=" + this.f53153a + ", errorCode=" + this.f53154b + ")";
    }

    public a(boolean r100, int r101) {
        this.f53153a = r100;
        this.f53154b = r101;
    }
}
