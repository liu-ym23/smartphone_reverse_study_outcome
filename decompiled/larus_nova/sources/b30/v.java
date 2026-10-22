package b30;

/* JADX INFO: loaded from: classes45.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f17164a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v) == true) goto L6;
        return false;
    L6:
        if (this.f17164a == ((v) r100).f17164a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f17164a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "PixStartRandomLinkEvent(isPixActivity=" + this.f17164a + ")";
    }

    public v(boolean r100) {
        this.f17164a = r100;
    }
}
