package com.bytedance.android.livesdk.revenue.service.interactivity;

/* JADX INFO: loaded from: classes11.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f157362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f157363b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (this.f157362a == r101.f157362a) goto L8;
        return false;
    L8:
        if (this.f157363b == r101.f157363b) goto L16;
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
        boolean r100 = this.f157362a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        long r102 = this.f157363b;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "RevIntercomStatus(isInIntercom=" + this.f157362a + ", closeReason=" + this.f157363b + ")";
    }

    public e(boolean r100, long r101) {
        this.f157362a = r100;
        this.f157363b = r101;
    }
}
