package bd3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f18654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final double f18655e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L16;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f18651a, r101.f18651a) == true) goto L8;
        return false;
    L8:
        if (this.f18652b == r101.f18652b) goto L10;
        return false;
    L10:
        if (this.f18653c == r101.f18653c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f18654d, r101.f18654d) == true) goto L14;
        return false;
    L14:
        if (Double.compare(this.f18655e, r101.f18655e) == 0) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f18651a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 * 31) + this.f18652b) * 31) + this.f18653c) * 31;
        String r104 = this.f18654d;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        long r106 = Double.doubleToLongBits(this.f18655e);
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SlcIndicatorProps(type=" + this.f18651a + ", totalDuration=" + this.f18652b + ", count=" + this.f18653c + ", videoTag=" + this.f18654d + ", lineWidth=" + this.f18655e + ")";
    }

    public final String getType() {
        return this.f18651a;
    }

    public c(String r100, int r101, int r102, String r103, double r104) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r103, "videoTag");
        this.f18651a = r100;
        this.f18652b = r101;
        this.f18653c = r102;
        this.f18654d = r103;
        this.f18655e = r104;
    }
}
