package b49;

/* JADX INFO: loaded from: classes27.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17679c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (this.f17677a == r101.f17677a) goto L12;
        return false;
    L12:
        if (this.f17678b == r101.f17678b) goto L15;
        return false;
    L15:
        if (this.f17679c == r101.f17679c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f17677a * 31) + this.f17678b) * 31) + this.f17679c;
    }

    public final String toString() {
        return "FlowDoraLongHeadDownDurationConfig(currentMinutes=" + this.f17677a + ", lowerBoundMinutes=" + this.f17678b + ", upperBoundMinutes=" + this.f17679c + ')';
    }

    public i(int r100, int r101, int r102) {
        this.f17677a = r100;
        this.f17678b = r101;
        this.f17679c = r102;
    }
}
