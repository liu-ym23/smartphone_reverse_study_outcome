package cd8;

import jc8.l;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23412b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f23411a == r101.f23411a) goto L12;
        return false;
    L12:
        if (this.f23412b == r101.f23412b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f23411a * 31) + this.f23412b;
    }

    public final String toString() {
        return "MaxWidthDataWrapper(maxContentWidth=" + this.f23411a + ", maxBoxWidth=" + this.f23412b + ')';
    }

    public a(int r100, int r101) {
        this.f23411a = r100;
        this.f23412b = r101;
    }
}
