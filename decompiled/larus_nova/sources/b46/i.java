package b46;

/* JADX INFO: loaded from: classes19.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17541b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f17540a == r101.f17540a) goto L12;
        return false;
    L12:
        if (this.f17541b == r101.f17541b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f17540a * 31) + this.f17541b;
    }

    public final String toString() {
        return "ScreenInfo(width=" + this.f17540a + ", height=" + this.f17541b + ')';
    }

    public i(int r100, int r101) {
        this.f17540a = r100;
        this.f17541b = r101;
    }
}
