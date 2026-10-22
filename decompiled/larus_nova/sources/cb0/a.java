package cb0;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f22988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f22989b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.f22988a == r101.f22988a) goto L8;
        return false;
    L8:
        if (this.f22989b == r101.f22989b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f22988a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f22989b;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "DurationModel(startTime=" + this.f22988a + ", endTime=" + this.f22989b + ")";
    }

    public a(long r100, long r101) {
        this.f22988a = r100;
        this.f22989b = r101;
    }
}
