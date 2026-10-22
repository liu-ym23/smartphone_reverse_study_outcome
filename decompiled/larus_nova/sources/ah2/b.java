package ah2;

/* JADX INFO: loaded from: classes10.dex */
public final class b {
    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L6;
        ((b) r100).getClass();
        return true;
    L6:
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "PromotionListSmartServiceResult(shouldPreloadData=false, shouldPreloadLayout=false)";
    }
}
