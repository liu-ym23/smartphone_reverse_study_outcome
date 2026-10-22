package bs8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f20305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f20306b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f20305a, r101.f20305a) == true) goto L12;
        return false;
    L12:
        if (this.f20306b == r101.f20306b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        e r100 = this.f20305a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.f20306b == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PcDeviceLoadResult(devices=" + this.f20305a + ", refreshSucceeded=" + this.f20306b + ')';
    }

    public f(e r100, boolean r101) {
        this.f20305a = r100;
        this.f20306b = r101;
    }
}
