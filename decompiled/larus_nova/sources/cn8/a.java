package cn8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f24560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f24561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f24562e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f24563f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f24564g;

    public a() {
        this(null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f24558a, r101.f24558a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f24559b, r101.f24559b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f24560c, r101.f24560c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f24561d, r101.f24561d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f24562e, r101.f24562e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f24563f, r101.f24563f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f24564g, r101.f24564g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f24558a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f24559b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f24560c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f24561d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f24562e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.f24563f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.f24564g;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
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
        return "ReplyTextLoadingVMData(text=" + this.f24558a + ", messageId=" + this.f24559b + ", cardPosition=" + this.f24560c + ", lightIcon=" + this.f24561d + ", darkIcon=" + this.f24562e + ", needShimmer=" + this.f24563f + ", needThreeLoading=" + this.f24564g + ')';
    }

    public a(String r100, String r101, Integer r102, String r103, String r104, Boolean r105, Boolean r106) {
        this.f24558a = r100;
        this.f24559b = r101;
        this.f24560c = r102;
        this.f24561d = r103;
        this.f24562e = r104;
        this.f24563f = r105;
        this.f24564g = r106;
    }
}
