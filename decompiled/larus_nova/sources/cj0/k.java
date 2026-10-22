package cj0;

/* JADX INFO: loaded from: classes46.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f23919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f23920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f23921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f23922d;

    public k() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L14;
        k r101 = (k) r100;
        if (this.f23919a == r101.f23919a) goto L8;
        return false;
    L8:
        if (this.f23920b == r101.f23920b) goto L10;
        return false;
    L10:
        if (this.f23921c == r101.f23921c) goto L12;
        return false;
    L12:
        if (this.f23922d == r101.f23922d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r100 = this.f23919a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        long r103 = this.f23920b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f23921c;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        boolean r107 = this.f23922d;
        if (r107 == true) goto L10;
        r101 = r107;
    L10:
        return r106 + r101;
    }

    public final String toString() {
        return "PaidLinkMicState(isPaidLinkMicOn=" + this.f23919a + ", paidCount=" + this.f23920b + ", linkTime=" + this.f23921c + ", showProfileCard=" + this.f23922d + ")";
    }

    public /* synthetic */ k(int r100) {
        this(false, 0, 0, false);
    }

    public static k a(k r110, int r111) {
        boolean r100 = false;
        if ((r111 & 1) == 0) goto L5;
        boolean r101 = r110.f23919a;
    L6:
        long r102 = 0;
        if ((r111 & 2) == 0) goto L9;
        long r103 = r110.f23920b;
    L11:
        if ((r111 & 4) == 0) goto L13;
        r102 = r110.f23921c;
    L13:
        long r104 = r102;
        if ((r111 & 8) == 0) goto L17;
        r100 = r110.f23922d;
    L17:
        return new k(r101, r103, r104, r100);
    L9:
        r103 = 0;
        goto L11
    L5:
        r101 = false;
        goto L6
    }

    public k(boolean r100, long r101, long r102, boolean r103) {
        this.f23919a = r100;
        this.f23920b = r101;
        this.f23921c = r102;
        this.f23922d = r103;
    }
}
