package c19;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f22105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f22107c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Float.compare(this.f22105a, r101.f22105a) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f22106b, r101.f22106b) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.f22107c, r101.f22107c) == 0) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((Float.floatToIntBits(this.f22105a) * 31) + this.f22106b.hashCode()) * 31) + Float.floatToIntBits(this.f22107c);
    }

    public final String toString() {
        return "DbxStop(o=" + this.f22105a + ", hex=" + this.f22106b + ", a=" + this.f22107c + ')';
    }

    public j(float r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "hex");
        this.f22105a = r100;
        this.f22106b = r101;
        this.f22107c = 1.0f;
    }
}
