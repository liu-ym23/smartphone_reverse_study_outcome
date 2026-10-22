package com.bytedance.android.shopping.commentv3.uitree.p008float;

import com.bytedance.android.shopping.commentv3.base.b;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f172813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f172814b;

    public c() {
        this(false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (this.f172813a == r101.f172813a) goto L8;
        return false;
    L8:
        if (this.f172814b == r101.f172814b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r100 = this.f172813a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f172814b;
        if (r104 == true) goto L10;
        r101 = r104;
    L10:
        return r103 + r101;
    }

    public final String toString() {
        return "FloatWindowState(isMultiPicMode=" + this.f172813a + ", showModeSwitchIcon=" + this.f172814b + ")";
    }

    public c(boolean r100, boolean r101) {
        this.f172813a = r100;
        this.f172814b = r101;
    }
}
