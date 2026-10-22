package c37;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f22283a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L9;
        return false;
    L9:
        if (this.f22283a == ((b) r100).f22283a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f22283a;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public final String toString() {
        return "DeviceHeadingParams(rotationChangeInterval=" + this.f22283a + ")";
    }

    public b() {
        this(50);
    }

    public b(long r100) {
        this.f22283a = r100;
    }
}
