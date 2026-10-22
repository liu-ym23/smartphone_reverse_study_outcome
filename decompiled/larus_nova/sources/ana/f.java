package ana;

import com.obric.oui.window.bean.WindowSizeClass;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowSizeClass f4571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f4572b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f4571a == r101.f4571a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f4572b, r101.f4572b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f4571a.hashCode() * 31) + this.f4572b.hashCode();
    }

    public final String toString() {
        return "WindowSizeWithPageSize(windowSizeClass=" + this.f4571a + ", pageSize=" + this.f4572b + ')';
    }

    public f(WindowSizeClass r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "windowSizeClass");
        Intrinsics.checkNotNullParameter(r101, "pageSize");
        this.f4571a = r100;
        this.f4572b = r101;
    }
}
