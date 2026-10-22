package b30;

/* JADX INFO: loaded from: classes45.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17166a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof z) == true) goto L6;
        return false;
    L6:
        if (this.f17166a == ((z) r100).f17166a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f17166a;
    }

    public final String toString() {
        return "SetPullDownCloseEvent(pullDownClose=" + this.f17166a + ")";
    }

    public z(int r100) {
        this.f17166a = r100;
    }
}
