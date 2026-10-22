package b30;

/* JADX INFO: loaded from: classes45.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17114a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a0) == true) goto L6;
        return false;
    L6:
        if (this.f17114a == ((a0) r100).f17114a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f17114a;
    }

    public final String toString() {
        return "SetPullDownHeightEvent(pullDownHeight=" + this.f17114a + ")";
    }

    public a0(int r100) {
        this.f17114a = r100;
    }
}
