package ac8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f2763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f2764d;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f2761a == r101.f2761a) goto L12;
        return false;
    L12:
        if (this.f2762b == r101.f2762b) goto L15;
        return false;
    L15:
        if (this.f2763c == r101.f2763c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f2764d, r101.f2764d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f2761a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f2762b) * 31;
        if (this.f2763c == true) goto L11;
        r100 = 1237;
    L11:
        return ((r102 + r100) * 31) + this.f2764d.hashCode();
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "InputMultilineConfig(doubleLineEnabled=" + this.f2761a + ", shrinkType=" + this.f2762b + ", hideSugIndexWithText=" + this.f2763c + ", blockedScenes=" + this.f2764d + ')';
    }

    public d(boolean r100, int r101, boolean r102, List<String> r103) {
        Intrinsics.checkNotNullParameter(r103, "blockedScenes");
        this.f2761a = r100;
        this.f2762b = r101;
        this.f2763c = r102;
        this.f2764d = r103;
    }
}
