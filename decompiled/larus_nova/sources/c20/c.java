package c20;

import f10.f;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<List<f>> f22129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f22130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a> f22131c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<d> f22132d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f22133e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f22134f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f22129a, r101.f22129a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f22130b, r101.f22130b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f22131c, r101.f22131c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f22132d, r101.f22132d) == true) goto L14;
        return false;
    L14:
        if (this.f22133e == r101.f22133e) goto L16;
        return false;
    L16:
        if (this.f22134f == r101.f22134f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        List<List<f>> r100 = this.f22129a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.f22130b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<a> r107 = this.f22131c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<d> r110 = this.f22132d;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        int r111 = (r109 + r101) * 31;
        long r112 = this.f22133e;
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        boolean r114 = this.f22134f;
        ?? r115 = r114;
        if (r114 == false) goto L21;
        r115 = 1;
    L21:
        return r113 + r115;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TabListData(groupIconList=" + this.f22129a + ", groupNameList=" + this.f22130b + ", tabIconList=" + this.f22131c + ", tabNameList=" + this.f22132d + ", selectedGroupId=" + this.f22133e + ", isFromCache=" + this.f22134f + ")";
    }

    public c(List<List<f>> r100, List<String> r101, List<a> r102, List<d> r103, long r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "groupIconList");
        Intrinsics.checkNotNullParameter(r101, "groupNameList");
        Intrinsics.checkNotNullParameter(r102, "tabIconList");
        Intrinsics.checkNotNullParameter(r103, "tabNameList");
        this.f22129a = r100;
        this.f22130b = r101;
        this.f22131c = r102;
        this.f22132d = r103;
        this.f22133e = r104;
        this.f22134f = r105;
    }
}
