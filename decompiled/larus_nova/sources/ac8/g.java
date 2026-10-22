package ac8;

import com.larus.bmhome.chat.ab.InputRowCollapseStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f2767d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InputRowCollapseStyle f2769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2770c;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f2768a == r101.f2768a) goto L12;
        return false;
    L12:
        if (this.f2769b == r101.f2769b) goto L15;
        return false;
    L15:
        if (this.f2770c == r101.f2770c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f2768a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f2769b.hashCode()) * 31;
        if (this.f2770c == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "InputRowLayoutResolution(doubleRowEnabled=" + this.f2768a + ", collapseStyle=" + this.f2769b + ", sugIndexHideEnabled=" + this.f2770c + ')';
    }

    static {
        f2767d = new g(false, InputRowCollapseStyle.NONE, false);
    }

    public g(boolean r100, InputRowCollapseStyle r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "collapseStyle");
        this.f2768a = r100;
        this.f2769b = r101;
        this.f2770c = r102;
    }
}
