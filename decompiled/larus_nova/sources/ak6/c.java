package ak6;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f4070b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (this.f4069a == r101.f4069a) goto L8;
        return false;
    L8:
        if (this.f4070b == r101.f4070b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f4069a * 31) + this.f4070b;
    }

    public final String toString() {
        return "IndexInfo(beginIndex=" + this.f4069a + ", endIndex=" + this.f4070b + ")";
    }

    public c(int r100, int r101) {
        this.f4069a = r100;
        this.f4070b = r101;
    }
}
