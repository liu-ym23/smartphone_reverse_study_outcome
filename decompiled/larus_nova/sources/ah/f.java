package ah;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f3396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f3398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f3399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final JSONObject f3400g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L20;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f3394a, r101.f3394a) == true) goto L8;
        return false;
    L8:
        if (this.f3395b == r101.f3395b) goto L10;
        return false;
    L10:
        if (this.f3396c == r101.f3396c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f3397d, r101.f3397d) == true) goto L14;
        return false;
    L14:
        if (this.f3398e == r101.f3398e) goto L16;
        return false;
    L16:
        if (this.f3399f == r101.f3399f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f3400g, r101.f3400g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f3394a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f3395b) * 31;
        boolean r104 = this.f3396c;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f3397d;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.f3398e;
        ?? r112 = r111;
        if (r111 == false) goto L16;
        r112 = 1;
    L16:
        int r113 = (r110 + r112) * 31;
        boolean r114 = this.f3399f;
        if (r114 == true) goto L20;
        r105 = r114;
    L20:
        int r115 = (r113 + r105) * 31;
        JSONObject r116 = this.f3400g;
        if (r116 == null) goto L24;
        r101 = r116.hashCode();
    L24:
        return r115 + r101;
    L12:
        r109 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "NotifyCouponStateEvent(state=" + this.f3394a + ", num=" + this.f3395b + ", isSpecialRoom=" + this.f3396c + ", couponShowType=" + this.f3397d + ", animate=" + this.f3398e + ", useNative=" + this.f3399f + ", logData=" + this.f3400g + ")";
    }

    public f() {
        this("HIDE", 0, false, "auto", false, false, null);
    }

    public f(String r100, int r101, boolean r102, String r103, boolean r104, boolean r105, JSONObject r106) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r103, "couponShowType");
        this.f3394a = r100;
        this.f3395b = r101;
        this.f3396c = r102;
        this.f3397d = r103;
        this.f3398e = r104;
        this.f3399f = r105;
        this.f3400g = r106;
    }
}
