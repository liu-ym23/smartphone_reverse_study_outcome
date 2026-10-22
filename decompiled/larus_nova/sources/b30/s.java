package b30;

/* JADX INFO: loaded from: classes45.dex */
public final class s {
    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s) == false) goto L6;
        ((s) r100).getClass();
        return true;
    L6:
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "OpenVerifyResultEvent(code=0)";
    }
}
