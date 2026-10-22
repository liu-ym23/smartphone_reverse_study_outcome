package bl6;

/* JADX INFO: loaded from: classes20.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f19495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f19496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f19497e;

    public j() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L16;
        j r101 = (j) r100;
        if (this.f19493a == r101.f19493a) goto L8;
        return false;
    L8:
        if (this.f19494b == r101.f19494b) goto L10;
        return false;
    L10:
        if (this.f19495c == r101.f19495c) goto L12;
        return false;
    L12:
        if (this.f19496d == r101.f19496d) goto L14;
        return false;
    L14:
        if (this.f19497e == r101.f19497e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        return (((((((this.f19493a * 31) + this.f19494b) * 31) + this.f19495c) * 31) + this.f19496d) * 31) + this.f19497e;
    }

    public final String toString() {
        return "ScoreStats(perfectCount=" + this.f19493a + ", greatCount=" + this.f19494b + ", goodCount=" + this.f19495c + ", perfectComboCount=" + this.f19496d + ", perfectAdvancedComboCount=" + this.f19497e + ")";
    }

    public /* synthetic */ j(int r100) {
        this(0, 0, 0, 0, 0);
    }

    public j(int r100, int r101, int r102, int r103, int r104) {
        this.f19493a = r100;
        this.f19494b = r101;
        this.f19495c = r102;
        this.f19496d = r103;
        this.f19497e = r104;
    }

    public static j a(j r100, int r101, int r102, int r103, int r110, int r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.f19493a;
    L5:
        int r104 = r101;
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.f19494b;
    L8:
        int r105 = r102;
        if ((r112 & 4) == 0) goto L11;
        r103 = r100.f19495c;
    L11:
        int r106 = r103;
        if ((r112 & 8) == 0) goto L14;
        r110 = r100.f19496d;
    L14:
        int r107 = r110;
        if ((r112 & 16) == 0) goto L17;
        r111 = r100.f19497e;
    L17:
        r100.getClass();
        return new j(r104, r105, r106, r107, r111);
    }
}
