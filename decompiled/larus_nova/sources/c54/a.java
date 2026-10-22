package c54;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f22481a;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (this.f22481a == ((a) r100).f22481a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f22481a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "AosFollowFeedConfig(isEnableFollowFeed=" + this.f22481a + ')';
    }

    public a(int r100) {
        this.f22481a = false;
    }
}
