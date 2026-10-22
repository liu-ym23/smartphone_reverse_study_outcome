package aq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15980b;

    public g() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f15979a, r101.f15979a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f15980b, r101.f15980b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f15979a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f15980b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "UploadFileTypeMobParam(uploadType=" + this.f15979a + ", uploadFileSecType=" + this.f15980b + ')';
    }

    public g(String r100, String r101) {
        this.f15979a = r100;
        this.f15980b = r101;
    }
}
