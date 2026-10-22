package bp3;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19973a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == true) goto L6;
        return false;
    L6:
        if (this.f19973a == ((b) r100).f19973a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f19973a;
    }

    public final String toString() {
        return "FollowStatusChangeEvent(status=" + this.f19973a + ")";
    }

    public b(int r100) {
        this.f19973a = r100;
    }
}
