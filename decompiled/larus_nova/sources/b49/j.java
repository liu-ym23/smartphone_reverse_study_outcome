package b49;

/* JADX INFO: loaded from: classes27.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17682c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (this.f17680a == r101.f17680a) goto L12;
        return false;
    L12:
        if (this.f17681b == r101.f17681b) goto L15;
        return false;
    L15:
        if (this.f17682c == r101.f17682c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f17680a * 31) + this.f17681b) * 31) + this.f17682c;
    }

    public final String toString() {
        return "FlowDoraSedentaryDurationConfig(currentMinutes=" + this.f17680a + ", lowerBoundMinutes=" + this.f17681b + ", upperBoundMinutes=" + this.f17682c + ')';
    }

    public j(int r100, int r101, int r102) {
        this.f17680a = r100;
        this.f17681b = r101;
        this.f17682c = r102;
    }
}
