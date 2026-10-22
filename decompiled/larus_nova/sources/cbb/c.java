package cbb;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f23120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f23121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f23122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f23123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f23124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f23125f;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f23120a == r101.f23120a) goto L12;
        return false;
    L12:
        if (this.f23121b == r101.f23121b) goto L15;
        return false;
    L15:
        if (this.f23122c == r101.f23122c) goto L18;
        return false;
    L18:
        if (this.f23123d == r101.f23123d) goto L21;
        return false;
    L21:
        if (this.f23124e == r101.f23124e) goto L24;
        return false;
    L24:
        if (this.f23125f == r101.f23125f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f23120a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f23121b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f23122c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f23123d;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f23124e;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.f23125f;
        return r109 + ((int) (r110 ^ (r110 >>> 32)));
    }

    public final String toString() {
        return "GlobalConfig(cleanInterval=" + this.f23120a + ", idleDelay=" + this.f23121b + ", sdkTaskCostLimit=" + this.f23122c + ", taskCostLimit=" + this.f23123d + ", cacheTimeLimit=" + this.f23124e + ", autoCleanMaxTimes=" + this.f23125f + ')';
    }

    public c(int r100) {
        this.f23120a = 86400;
        this.f23121b = 30;
        this.f23122c = 30;
        this.f23123d = 60;
        this.f23124e = 604800;
        this.f23125f = 5;
    }
}
