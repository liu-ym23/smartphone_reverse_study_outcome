package cd9;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f23417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f23418b;

    public b() {
        this(null, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f23417a, r101.f23417a) == true) goto L12;
        return false;
    L12:
        if (this.f23418b == r101.f23418b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<a> r100 = this.f23417a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.f23418b == false) goto L9;
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
        return "SelectProjectListResponse(projectList=" + this.f23417a + ", hasMore=" + this.f23418b + ')';
    }

    public b(List<a> r100, boolean r101) {
        this.f23417a = r100;
        this.f23418b = r101;
    }
}
