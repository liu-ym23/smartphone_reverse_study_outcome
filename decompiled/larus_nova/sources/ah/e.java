package ah;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3393b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (this.f3392a == r101.f3392a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f3393b, r101.f3393b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f3392a * 31;
        String r101 = this.f3393b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "ECStoreHeightChangeEvent(height=" + this.f3392a + ", targetContainer=" + this.f3393b + ")";
    }

    public e(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "targetContainer");
        this.f3392a = r100;
        this.f3393b = r101;
    }
}
