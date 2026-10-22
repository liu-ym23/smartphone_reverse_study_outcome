package ab1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2468a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f2468a, ((h) r100).f2468a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f2468a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "QuickBackToTopEvent(tabName=" + this.f2468a + ")";
    }

    public h() {
        this("recommend");
    }

    public h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tabName");
        this.f2468a = r100;
    }
}
