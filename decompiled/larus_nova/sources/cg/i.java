package cg;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23584b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L10;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f23583a, r101.f23583a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f23584b, r101.f23584b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f23583a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f23584b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SpecTitleOptimizeVO(specTitle=" + this.f23583a + ", specTitleExtra=" + this.f23584b + ")";
    }

    public i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "specTitle");
        this.f23583a = r100;
        this.f23584b = r101;
    }
}
