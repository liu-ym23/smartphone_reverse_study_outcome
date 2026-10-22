package b30;

/* JADX INFO: loaded from: classes45.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f17134a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h0) == true) goto L6;
        return false;
    L6:
        if (this.f17134a == ((h0) r100).f17134a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f17134a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "ZhimaVerifyResultEvent(succeed=" + this.f17134a + ")";
    }

    public h0(boolean r100) {
        this.f17134a = r100;
    }
}
