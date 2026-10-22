package com.bytedance.android.live.broadcastgame.api.model;

/* JADX INFO: loaded from: classes45.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f59362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f59363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f59364c;

    public n() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L12;
        n r101 = (n) r100;
        if (this.f59362a == r101.f59362a) goto L8;
        return false;
    L8:
        if (this.f59363b == r101.f59363b) goto L10;
        return false;
    L10:
        if (this.f59364c == r101.f59364c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r100 = this.f59362a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = ((r102 * 31) + this.f59363b) * 31;
        boolean r104 = this.f59364c;
        if (r104 == true) goto L10;
        r101 = r104;
    L10:
        return r103 + r101;
    }

    public final String toString() {
        return "InteractEntranceCellLocalExtra(isDebug=" + this.f59362a + ", enterFrom=" + this.f59363b + ", isInLive=" + this.f59364c + ")";
    }

    public n(int r100) {
        this.f59362a = false;
        this.f59363b = 1;
        this.f59364c = true;
    }
}
