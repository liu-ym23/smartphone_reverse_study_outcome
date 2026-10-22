package b48;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f17642e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f17643f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f17644g;

    public l() {
        this(0, null, null, null, null, false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f17638a == r101.f17638a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f17639b, r101.f17639b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f17640c, r101.f17640c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f17641d, r101.f17641d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f17642e, r101.f17642e) == true) goto L24;
        return false;
    L24:
        if (this.f17643f == r101.f17643f) goto L27;
        return false;
    L27:
        if (this.f17644g == r101.f17644g) goto L29;
        return false;
    L29:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        int r100 = this.f17638a * 31;
        String r101 = this.f17639b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f17640c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f17641d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        j r111 = this.f17642e;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        int r112 = (r110 + r102) * 31;
        boolean r113 = this.f17643f;
        ?? r114 = 1;
        ?? r115 = r113;
        if (r113 == false) goto L21;
        r115 = 1;
    L21:
        int r116 = (r112 + r115) * 31;
        boolean r117 = this.f17644g;
        if (r117 == true) goto L26;
        r114 = r117;
    L26:
        return r116 + r114;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "UserInfo(userType=" + this.f17638a + ", userId=" + this.f17639b + ", nickName=" + this.f17640c + ", userName=" + this.f17641d + ", avatar=" + this.f17642e + ", isNicknameDefault=" + this.f17643f + ", isAvatarDefault=" + this.f17644g + ')';
    }

    public l(int r100, String r101, String r102, String r103, j r104, boolean r105, boolean r106) {
        this.f17638a = r100;
        this.f17639b = r101;
        this.f17640c = r102;
        this.f17641d = r103;
        this.f17642e = r104;
        this.f17643f = r105;
        this.f17644g = r106;
    }
}
