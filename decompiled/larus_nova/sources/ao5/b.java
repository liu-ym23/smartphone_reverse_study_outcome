package ao5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f15791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15793c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f15791a == r101.f15791a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f15792b, r101.f15792b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f15793c, r101.f15793c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f15791a;
        return (((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f15792b.hashCode()) * 31) + this.f15793c.hashCode();
    }

    public final String toString() {
        return "CategoryBean(categoryId=" + this.f15791a + ", description=" + this.f15792b + ", name=" + this.f15793c + ')';
    }

    public b() {
        this(-1, "", "");
    }

    public b(long r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "description");
        Intrinsics.checkNotNullParameter(r102, "name");
        this.f15791a = r100;
        this.f15792b = r101;
        this.f15793c = r102;
    }
}
