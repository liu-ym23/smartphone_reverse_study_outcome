package c25;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f22194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f22195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f22196e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f22197f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f22192a, r101.f22192a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f22193b, r101.f22193b) == true) goto L15;
        return false;
    L15:
        if (this.f22194c == r101.f22194c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f22195d, r101.f22195d) == true) goto L21;
        return false;
    L21:
        if (this.f22196e == r101.f22196e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f22197f, r101.f22197f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f22192a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f22193b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (((((r103 + r101) * 31) + this.f22194c) * 31) + this.f22195d.hashCode()) * 31;
        if (this.f22196e == false) goto L13;
        int r106 = 1231;
    L15:
        return ((r105 + r106) * 31) + this.f22197f.hashCode();
    L13:
        r106 = 1237;
        goto L15
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ItemData(url=" + this.f22192a + ", appId=" + this.f22193b + ", type=" + this.f22194c + ", subType=" + this.f22195d + ", isWiki=" + this.f22196e + ", title=" + this.f22197f + ')';
    }

    public final int getType() {
        return this.f22194c;
    }

    public c(String r100, String r101, int r102, String r103, boolean r104, String r105) {
        Intrinsics.checkNotNullParameter(r103, "subType");
        Intrinsics.checkNotNullParameter(r105, "title");
        this.f22192a = r100;
        this.f22193b = r101;
        this.f22194c = r102;
        this.f22195d = r103;
        this.f22196e = r104;
        this.f22197f = r105;
    }
}
