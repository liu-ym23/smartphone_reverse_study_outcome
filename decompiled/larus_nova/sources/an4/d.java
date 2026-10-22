package an4;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f4498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f4499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f4500c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f4498a, r101.f4498a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f4499b, r101.f4499b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f4500c, r101.f4500c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f4498a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f4499b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f4500c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ToolbarIconDecoration(iconTint=" + this.f4498a + ", selectorBackgroundRes=" + this.f4499b + ", pressedBackgroundRes=" + this.f4500c + ')';
    }

    public d(Integer r100, Integer r101, Integer r102) {
        this.f4498a = r100;
        this.f4499b = r101;
        this.f4500c = r102;
    }
}
