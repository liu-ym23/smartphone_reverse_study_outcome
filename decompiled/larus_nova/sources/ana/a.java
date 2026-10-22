package ana;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f4564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f4565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4566c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(Float.valueOf(this.f4564a), Float.valueOf(r101.f4564a)) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(Float.valueOf(this.f4565b), Float.valueOf(r101.f4565b)) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f4564a) * 31) + Float.floatToIntBits(this.f4565b);
    }

    public final String toString() {
        return "AvailableWindowSize(width=" + this.f4564a + ", height=" + this.f4565b + ')';
    }

    public a(float r100, float r101) {
        this.f4564a = r100;
        this.f4565b = r101;
        this.f4566c = (int) r100;
    }
}
