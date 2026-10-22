package a49;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f1810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f1812e;

    public j() {
        this(null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f1808a, r101.f1808a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f1809b, r101.f1809b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f1810c, r101.f1810c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f1811d, r101.f1811d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f1812e, r101.f1812e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f1808a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f1809b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f1810c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f1811d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f1812e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "QuickNoteCardContent(title=" + this.f1808a + ", subtitle=" + this.f1809b + ", content=" + this.f1810c + ", url=" + this.f1811d + ", thumbnail=" + this.f1812e + ')';
    }

    public j(String r100, String r101, String r102, String r103, String r104) {
        this.f1808a = r100;
        this.f1809b = r101;
        this.f1810c = r102;
        this.f1811d = r103;
        this.f1812e = r104;
    }
}
