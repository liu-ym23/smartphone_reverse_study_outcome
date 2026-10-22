package bba;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long[] f18553e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f18554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f18555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f18556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f18557d;

    /* JADX INFO: renamed from: bba.a$a, reason: collision with other inner class name */
    public static final class C0288a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f18554a == r101.f18554a) goto L12;
        return false;
    L12:
        if (this.f18555b == r101.f18555b) goto L15;
        return false;
    L15:
        if (this.f18556c == r101.f18556c) goto L18;
        return false;
    L18:
        if (this.f18557d == r101.f18557d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f18554a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f18555b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f18556c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f18557d;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    }

    public final String toString() {
        return "ObricAiKeyGestureConfig(pressStartTimeoutMillis=" + this.f18554a + ", tapTimeoutMillis=" + this.f18555b + ", longAfterPressStartMillis=" + this.f18556c + ", gestureTimeoutMillis=" + this.f18557d + ')';
    }

    static {
        f18553e = new long[]{300, 600, 1000};
    }

    public a(long r100, long r101) {
        this.f18554a = r100;
        this.f18555b = 300;
        this.f18556c = 700;
        this.f18557d = r101;
    }
}
