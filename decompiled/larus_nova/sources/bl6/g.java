package bl6;

/* JADX INFO: loaded from: classes20.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19491b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L10;
        g r101 = (g) r100;
        if (this.f19490a == r101.f19490a) goto L8;
        return false;
    L8:
        if (this.f19491b == r101.f19491b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f19490a * 31) + this.f19491b;
    }

    public final String toString() {
        return "MidiToneRange(minTone=" + this.f19490a + ", maxTone=" + this.f19491b + ")";
    }

    public g(int r100, int r101) {
        this.f19490a = r100;
        this.f19491b = r101;
    }
}
