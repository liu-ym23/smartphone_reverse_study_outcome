package a0a;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f1330b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f1329a, r101.f1329a) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.f1330b, r101.f1330b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f1329a.hashCode() * 31) + Float.floatToIntBits(this.f1330b);
    }

    public final String toString() {
        return "GradientStop(color=" + this.f1329a + ", position=" + this.f1330b + ')';
    }

    public a(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "color");
        this.f1329a = r100;
        this.f1330b = r101;
    }
}
