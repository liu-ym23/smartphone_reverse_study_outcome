package ad6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3031a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        r101.getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L8;
        return false;
    L8:
        if (this.f3031a == r101.f3031a) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return 0 + this.f3031a;
    }

    public final String toString() {
        return "SlotInfo(assetIdList=null, count=" + this.f3031a + ")";
    }
}
