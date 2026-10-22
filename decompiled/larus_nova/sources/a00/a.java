package a00;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1243d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f1240a, r101.f1240a) == true) goto L8;
        return false;
    L8:
        if (this.f1241b == r101.f1241b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f1242c, r101.f1242c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f1243d, r101.f1243d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f1240a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f1241b) * 31;
        String r104 = this.f1242c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f1243d;
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
        return "InteractToolsMobInfo(name=" + this.f1240a + ", interactID=" + this.f1241b + ", eventPage=" + this.f1242c + ", extras=" + this.f1243d + ")";
    }

    public a(String r100, int r101, String r102, String r103) {
        this.f1240a = r100;
        this.f1241b = r101;
        this.f1242c = r102;
        this.f1243d = r103;
    }
}
