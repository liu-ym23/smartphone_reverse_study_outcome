package ch0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f23745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f23746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f23747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f23748e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L16;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f23744a, r101.f23744a) == true) goto L8;
        return false;
    L8:
        if (this.f23745b == r101.f23745b) goto L10;
        return false;
    L10:
        if (this.f23746c == r101.f23746c) goto L12;
        return false;
    L12:
        if (this.f23747d == r101.f23747d) goto L14;
        return false;
    L14:
        if (this.f23748e == r101.f23748e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        String r100 = this.f23744a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f23745b;
        ?? r104 = 1;
        ?? r105 = r103;
        if (r103 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (((((r102 + r105) * 31) + this.f23746c) * 31) + this.f23747d) * 31;
        boolean r107 = this.f23748e;
        if (r107 == true) goto L14;
        r104 = r107;
    L14:
        return r106 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "SeiLinkerInfo(interactId=" + this.f23744a + ", isTalking=" + this.f23745b + ", mediaType=" + this.f23746c + ", positionOnSei=" + this.f23747d + ", isVisible=" + this.f23748e + ")";
    }

    public j(String r100, boolean r101, int r102, int r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        this.f23744a = r100;
        this.f23745b = r101;
        this.f23746c = r102;
        this.f23747d = r103;
        this.f23748e = r104;
    }

    public static j a(j r100, boolean r101, int r102, int r103, boolean r104, int r110) {
        if ((r110 & 1) == 0) goto L5;
        String r105 = r100.f23744a;
    L7:
        if ((r110 & 2) == 0) goto L9;
        r101 = r100.f23745b;
    L9:
        boolean r106 = r101;
        if ((r110 & 4) == 0) goto L12;
        r102 = r100.f23746c;
    L12:
        int r107 = r102;
        if ((r110 & 8) == 0) goto L15;
        r103 = r100.f23747d;
    L15:
        int r108 = r103;
        if ((r110 & 16) == 0) goto L18;
        r104 = r100.f23748e;
    L18:
        Intrinsics.checkNotNullParameter(r105, "interactId");
        String r109 = r105;
        return new j(r109, r106, r107, r108, r104);
    L5:
        r105 = null;
        goto L7
    }
}
