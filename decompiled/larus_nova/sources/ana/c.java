package ana;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f4568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f4569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f4570d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f4567a, r101.f4567a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f4568b, r101.f4568b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f4569c, r101.f4569c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f4570d, r101.f4570d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f4567a.hashCode() * 31) + this.f4568b.hashCode()) * 31) + this.f4569c.hashCode()) * 31) + this.f4570d.hashCode();
    }

    public final String toString() {
        return "PageGridConfig(gridMode=" + this.f4567a + ", pageColumns=" + this.f4568b + ", pageGutter=" + this.f4569c + ", pageMargin=" + this.f4570d + ')';
    }

    public c(String r100, b r101, d r102, e r103) {
        Intrinsics.checkNotNullParameter(r100, "gridMode");
        Intrinsics.checkNotNullParameter(r101, "pageColumns");
        Intrinsics.checkNotNullParameter(r102, "pageGutter");
        Intrinsics.checkNotNullParameter(r103, "pageMargin");
        this.f4567a = r100;
        this.f4568b = r101;
        this.f4569c = r102;
        this.f4570d = r103;
    }
}
