package ch0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f23729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f23730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f23731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f23732e;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L16;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f23728a, r101.f23728a) == true) goto L8;
        return false;
    L8:
        if (this.f23729b == r101.f23729b) goto L10;
        return false;
    L10:
        if (this.f23730c == r101.f23730c) goto L12;
        return false;
    L12:
        if (this.f23731d == r101.f23731d) goto L14;
        return false;
    L14:
        if (this.f23732e == r101.f23732e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f23728a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((((((r101 * 31) + this.f23729b) * 31) + this.f23730c) * 31) + this.f23731d) * 31) + this.f23732e;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "RtcLocalUserInfo(interactId=" + this.f23728a + ", videoCaptureStatus=" + this.f23729b + ", audioCaptureStatus=" + this.f23730c + ", videoPublishStatus=" + this.f23731d + ", audioPublishStatus=" + this.f23732e + ")";
    }

    public static g a(g r100) {
        String r101 = r100.f23728a;
        int r102 = r100.f23729b;
        int r103 = r100.f23730c;
        int r104 = r100.f23731d;
        int r105 = r100.f23732e;
        Intrinsics.checkNotNullParameter(r101, "interactId");
        return new g(r101, r102, r103, r104, r105);
    }

    public g(String r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        this.f23728a = r100;
        this.f23729b = r101;
        this.f23730c = r102;
        this.f23731d = r103;
        this.f23732e = r104;
    }
}
