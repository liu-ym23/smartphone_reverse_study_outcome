package a7b;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f2122b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f2123c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f2124d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2125a;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (this.f2125a == ((b) r100).f2125a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f2125a;
    }

    public final String toString() {
        return "DraftResourceSource(value=" + this.f2125a + ')';
    }

    static {
        f2122b = new b(0);
        f2123c = new b(1);
        f2124d = new b(2);
    }

    public b(int r100) {
        this.f2125a = r100;
    }
}
