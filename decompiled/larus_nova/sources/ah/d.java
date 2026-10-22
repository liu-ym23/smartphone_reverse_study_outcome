package ah;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f3389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f3390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f3391f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L18;
        d r101 = (d) r100;
        if (this.f3386a == r101.f3386a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f3387b, r101.f3387b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f3388c, r101.f3388c) == true) goto L12;
        return false;
    L12:
        if (this.f3389d == r101.f3389d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f3390e, r101.f3390e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f3391f, r101.f3391f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    public final int hashCode() {
        int r100 = this.f3386a * 31;
        String r101 = this.f3387b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f3388c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        boolean r108 = this.f3389d;
        ?? r109 = r108;
        if (r108 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f3390e;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f3391f;
        if (r114 == null) goto L21;
        r102 = r114.hashCode();
    L21:
        return r113 + r102;
    L16:
        r112 = 0;
        goto L17
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "ECOpenShopEvent(tab=" + this.f3386a + ", productTabParams=" + this.f3387b + ", productTabPassThroughApi=" + this.f3388c + ", smoothScroll=" + this.f3389d + ", toastMsg=" + this.f3390e + ", scene=" + this.f3391f + ")";
    }

    public /* synthetic */ d(int r100, String r101) {
        this(r100, r101, null, true, null, null);
    }

    public d(int r100, String r101, String r102, boolean r103, String r104, String r105) {
        this.f3386a = r100;
        this.f3387b = r101;
        this.f3388c = r102;
        this.f3389d = r103;
        this.f3390e = r104;
        this.f3391f = r105;
    }
}
