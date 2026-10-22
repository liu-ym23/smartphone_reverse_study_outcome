package cg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f23586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f23587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f23588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f23589e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L16;
        j r101 = (j) r100;
        if (this.f23585a == r101.f23585a) goto L8;
        return false;
    L8:
        if (Float.compare(this.f23586b, r101.f23586b) == 0) goto L10;
        return false;
    L10:
        if (this.f23587c == r101.f23587c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f23588d, r101.f23588d) == true) goto L14;
        return false;
    L14:
        if (this.f23589e == r101.f23589e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r100 = ((this.f23585a * 31) + Float.floatToIntBits(this.f23586b)) * 31;
        boolean r101 = this.f23587c;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f23588d;
        if (r105 == null) goto L8;
        int r106 = r105.hashCode();
    L9:
        int r107 = (r104 + r106) * 31;
        boolean r108 = this.f23589e;
        if (r108 == true) goto L14;
        r102 = r108;
    L14:
        return r107 + r102;
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return "SpecTitleVO(groupTitleColor=" + this.f23585a + ", groupTitleTextSize=" + this.f23586b + ", isBold=" + this.f23587c + ", specTitle=" + this.f23588d + ", needMargin=" + this.f23589e + ")";
    }

    public j(int r100, float r101, boolean r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r103, "specTitle");
        this.f23585a = r100;
        this.f23586b = r101;
        this.f23587c = r102;
        this.f23588d = r103;
        this.f23589e = r104;
    }
}
