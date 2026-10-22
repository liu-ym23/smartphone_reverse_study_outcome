package ad6;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<c> f3029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3030c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L12;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f3028a, r101.f3028a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f3029b, r101.f3029b) == true) goto L10;
        return false;
    L10:
        if (this.f3030c == r101.f3030c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f3028a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<c> r104 = this.f3029b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((r103 + r101) * 31) + this.f3030c;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SlotChangeEvent(sendTogetherId=" + this.f3028a + ", slotList=" + this.f3029b + ", currentCount=" + this.f3030c + ")";
    }

    public b() {
        this.f3028a = null;
        this.f3029b = null;
        this.f3030c = 0;
    }
}
