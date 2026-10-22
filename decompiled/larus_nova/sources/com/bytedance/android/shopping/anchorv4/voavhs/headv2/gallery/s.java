package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f169386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f169387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f169388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f169389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f169390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f169391f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s) == false) goto L18;
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f169386a, r101.f169386a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f169387b, r101.f169387b) == true) goto L10;
        return false;
    L10:
        if (this.f169388c == r101.f169388c) goto L12;
        return false;
    L12:
        if (this.f169389d == r101.f169389d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f169390e, r101.f169390e) == true) goto L16;
        return false;
    L16:
        if (this.f169391f == r101.f169391f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f169386a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f169387b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f169388c) * 31;
        boolean r107 = this.f169389d;
        ?? r108 = 1;
        ?? r109 = r107;
        if (r107 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r106 + r109) * 31;
        String r111 = this.f169390e;
        if (r111 == null) goto L16;
        r101 = r111.hashCode();
    L16:
        int r112 = (r110 + r101) * 31;
        boolean r113 = this.f169391f;
        if (r113 == true) goto L21;
        r108 = r113;
    L21:
        return r112 + r108;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GalleryMoreVideoItem(label=" + this.f169386a + ", cover=" + this.f169387b + ", mappedPosition=" + this.f169388c + ", isVideo=" + this.f169389d + ", originLabel=" + this.f169390e + ", isSelected=" + this.f169391f + ")";
    }

    public s(String r100, String r101, int r102, boolean r103, String r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "label");
        Intrinsics.checkNotNullParameter(r104, "originLabel");
        this.f169386a = r100;
        this.f169387b = r101;
        this.f169388c = r102;
        this.f169389d = r103;
        this.f169390e = r104;
        this.f169391f = r105;
    }
}
