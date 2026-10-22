package aq2;

/* JADX INFO: loaded from: classes11.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15889b;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (this.f15888a == r101.f15888a) goto L8;
        return false;
    L8:
        if (this.f15889b == r101.f15889b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f15888a * 31) + this.f15889b;
    }

    public final String toString() {
        return "RevCardSize(width=" + this.f15888a + ", height=" + this.f15889b + ")";
    }

    public c(int r100) {
        this.f15888a = -1;
        this.f15889b = -1;
    }
}
