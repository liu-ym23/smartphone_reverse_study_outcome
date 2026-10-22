package com.bytedance.android.livesdk.gift.platform.core.model;

/* JADX INFO: loaded from: classes9.dex */
public final class k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f130905f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f130906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f130907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f130908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f130909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f130910e;

    public static final class a {
        public static k a(k r100) {
            if (r100 != null) goto L6;
            return null;
        L6:
            return new k(r100.f130906a, r100.f130907b, r100.f130908c, r100.f130909d, r100.f130910e);
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L16;
        k r101 = (k) r100;
        if (this.f130906a == r101.f130906a) goto L8;
        return false;
    L8:
        if (this.f130907b == r101.f130907b) goto L10;
        return false;
    L10:
        if (this.f130908c == r101.f130908c) goto L12;
        return false;
    L12:
        if (this.f130909d == r101.f130909d) goto L14;
        return false;
    L14:
        if (this.f130910e == r101.f130910e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        int r100 = ((((this.f130906a * 31) + this.f130907b) * 31) + this.f130908c) * 31;
        long r101 = this.f130909d;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        boolean r103 = this.f130910e;
        ?? r104 = r103;
        if (r103 == false) goto L6;
        r104 = 1;
    L6:
        return r102 + r104;
    }

    public final String toString() {
        return "GiftPanelLocationInfo(giftAbsolutePos=" + this.f130906a + ", giftPanelTab=" + this.f130907b + ", pageTotalCount=" + this.f130908c + ", giftId=" + this.f130909d + ", forceInsertByAi=" + this.f130910e + ")";
    }

    public k(int r100, int r101, int r102, long r103, boolean r104) {
        this.f130906a = r100;
        this.f130907b = r101;
        this.f130908c = r102;
        this.f130909d = r103;
        this.f130910e = r104;
    }
}
