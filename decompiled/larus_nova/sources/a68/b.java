package a68;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1963b;

    public b() {
        this(false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f1962a == r101.f1962a) goto L12;
        return false;
    L12:
        if (this.f1963b == r101.f1963b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f1962a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f1963b == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "AudioDebugAutoDumpConfig(realtimeAutoDumpEnable=" + this.f1962a + ", doraAutoDumpEnable=" + this.f1963b + ')';
    }

    public b(boolean r100, boolean r101) {
        this.f1962a = r100;
        this.f1963b = r101;
    }
}
