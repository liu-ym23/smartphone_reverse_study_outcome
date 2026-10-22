package cc2;

import cc2.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f<T extends o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f23160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f23161b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L10;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f23160a, r101.f23160a) == true) goto L8;
        return false;
    L8:
        if (this.f23161b == r101.f23161b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        T r100 = this.f23160a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f23161b;
        ?? r104 = r103;
        if (r103 == false) goto L10;
        r104 = 1;
    L10:
        return r102 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "ChangedFactorStatus(factor=" + this.f23160a + ", status=" + this.f23161b + ")";
    }

    public f(T r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "factor");
        this.f23160a = r100;
        this.f23161b = r101;
    }
}
