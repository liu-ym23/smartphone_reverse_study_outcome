package b48;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f17593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f17597e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f17598f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f17599g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f17600h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f17593a == r101.f17593a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f17594b, r101.f17594b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f17595c, r101.f17595c) == true) goto L18;
        return false;
    L18:
        if (this.f17596d == r101.f17596d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f17597e, r101.f17597e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f17598f, r101.f17598f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f17599g, r101.f17599g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f17600h, r101.f17600h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    public final int hashCode() {
        boolean r100 = this.f17593a;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return (((((((((((((r101 * 31) + this.f17594b.hashCode()) * 31) + this.f17595c.hashCode()) * 31) + this.f17596d) * 31) + this.f17597e.hashCode()) * 31) + this.f17598f.hashCode()) * 31) + this.f17599g.hashCode()) * 31) + this.f17600h.hashCode();
    }

    public final String toString() {
        return "AccountBaseInfo(isLogin=" + this.f17593a + ", userId=" + this.f17594b + ", secUserId=" + this.f17595c + ", odinUserType=" + this.f17596d + ", userMobile=" + this.f17597e + ", userName=" + this.f17598f + ", screeName=" + this.f17599g + ", avatarUrl=" + this.f17600h + ')';
    }

    public b(boolean r100, String r101, String r102, int r103, String r104, String r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r101, "userId");
        Intrinsics.checkNotNullParameter(r102, "secUserId");
        Intrinsics.checkNotNullParameter(r104, "userMobile");
        Intrinsics.checkNotNullParameter(r105, "userName");
        Intrinsics.checkNotNullParameter(r106, "screeName");
        Intrinsics.checkNotNullParameter(r107, "avatarUrl");
        this.f17593a = r100;
        this.f17594b = r101;
        this.f17595c = r102;
        this.f17596d = r103;
        this.f17597e = r104;
        this.f17598f = r105;
        this.f17599g = r106;
        this.f17600h = r107;
    }
}
