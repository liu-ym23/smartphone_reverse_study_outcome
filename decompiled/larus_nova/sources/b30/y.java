package b30;

/* JADX INFO: loaded from: classes45.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17165a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof y) == true) goto L6;
        return false;
    L6:
        if (this.f17165a == ((y) r100).f17165a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f17165a;
    }

    public final String toString() {
        return "RefreshActivityBannerNumberEvent(bannerNumber=" + this.f17165a + ")";
    }

    public y(int r100) {
        this.f17165a = r100;
    }
}
