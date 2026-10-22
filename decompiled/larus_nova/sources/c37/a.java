package c37;

import e37.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f22278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f22281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final j f22282e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f22278a, r101.f22278a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f22279b, r101.f22279b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f22280c, r101.f22280c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f22281d, r101.f22281d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f22282e, r101.f22282e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f22278a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f22279b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f22280c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f22281d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        j r113 = this.f22282e;
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
        return "ContinuousLocationParams(interval=" + this.f22278a + ", businessTag=" + this.f22279b + ", navigationId=" + this.f22280c + ", routePlanType=" + this.f22281d + ", traceContext=" + this.f22282e + ")";
    }

    public a(Long r100, String r101, String r102, Integer r103, j r104) {
        this.f22278a = r100;
        this.f22279b = r101;
        this.f22280c = r102;
        this.f22281d = r103;
        this.f22282e = r104;
    }
}
