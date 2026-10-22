package ah;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f3402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3404c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L12;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f3402a, r101.f3402a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f3403b, r101.f3403b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f3404c, r101.f3404c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.f3402a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f3403b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f3404c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ShopRefreshProductEvent(tabId=" + this.f3402a + ", productTabParams=" + this.f3403b + ", productTabPassThroughApi=" + this.f3404c + ")";
    }

    public h(Integer r100, String r101, String r102) {
        this.f3402a = r100;
        this.f3403b = r101;
        this.f3404c = r102;
    }
}
