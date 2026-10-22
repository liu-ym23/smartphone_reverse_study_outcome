package com.bytedance.android.livesdk.chatroom.roommanage.admin.binder;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f111259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f111260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f111261c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (this.f111259a == r101.f111259a) goto L8;
        return false;
    L8:
        if (this.f111260b == r101.f111260b) goto L10;
        return false;
    L10:
        if (this.f111261c == r101.f111261c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final int hashCode() {
        int r100 = ((this.f111259a * 31) + this.f111260b) * 31;
        boolean r101 = this.f111261c;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return r100 + r102;
    }

    public final String toString() {
        return "AdminPromptHeadlineData(currentCount=" + this.f111259a + ", quantity=" + this.f111260b + ", shouldShowSubtitle=" + this.f111261c + ")";
    }

    public a(int r100, int r101, boolean r102) {
        this.f111259a = r100;
        this.f111260b = r101;
        this.f111261c = r102;
    }
}
