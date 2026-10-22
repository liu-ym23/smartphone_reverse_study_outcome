package com.bytedance.android.livesdk.chatroom.ui;

/* JADX INFO: loaded from: classes8.dex */
public final class c8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f112664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f112665b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c8) == false) goto L10;
        c8 r101 = (c8) r100;
        if (this.f112664a == r101.f112664a) goto L8;
        return false;
    L8:
        if (this.f112665b == r101.f112665b) goto L16;
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
        boolean r100 = this.f112664a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f112665b;
        if (r104 == true) goto L10;
        r101 = r104;
    L10:
        return r103 + r101;
    }

    public final String toString() {
        return "PaidInfo(isPaid=" + this.f112664a + ", paidFreeTagIgnore=" + this.f112665b + ")";
    }

    public c8(boolean r100, boolean r101) {
        this.f112664a = r100;
        this.f112665b = r101;
    }
}
