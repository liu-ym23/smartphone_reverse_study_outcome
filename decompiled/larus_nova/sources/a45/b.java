package a45;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1765a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (this.f1765a == ((b) r100).f1765a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f1765a;
    }

    public final String toString() {
        return "TipsItem(count=" + this.f1765a + ')';
    }

    @Override // a45.a
    public final int type() {
        return 1;
    }
}
