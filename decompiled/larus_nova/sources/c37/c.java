package c37;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f22287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f22288e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f22289f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f22290g;

    public c() {
        this(0, 0, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f22284a == r101.f22284a) goto L12;
        return false;
    L12:
        if (this.f22285b == r101.f22285b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f22286c, r101.f22286c) == true) goto L18;
        return false;
    L18:
        if (this.f22287d == r101.f22287d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f22288e, r101.f22288e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f22289f, r101.f22289f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f22290g, r101.f22290g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f22284a * 31) + this.f22285b) * 31;
        String r101 = this.f22286c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f22287d) * 31;
        String r105 = this.f22288e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f22289f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f22290g;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ForegroundServiceParams(smallIcon=" + this.f22284a + ", largeIcon=" + this.f22285b + ", contentTitle=" + this.f22286c + ", notificationId=" + this.f22287d + ", channelId=" + this.f22288e + ", channelName=" + this.f22289f + ", contentText=" + this.f22290g + ")";
    }

    public c(int r100, int r101, String r102, int r103) {
        int r104 = 0;
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        String r105 = null;
        if ((r103 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r103 & 8) == 0) goto L15;
        r104 = 102420483;
    L15:
        if ((r103 & 16) == 0) goto L17;
        String r106 = "lightnavi.foreground";
    L19:
        if ((r103 & 32) == 0) goto L21;
        String r107 = "LightNavigation";
    L23:
        if ((r103 & 64) == 0) goto L25;
        r105 = "正在导航";
    L25:
        this.f22284a = r100;
        this.f22285b = r101;
        this.f22286c = r102;
        this.f22287d = r104;
        this.f22288e = r106;
        this.f22289f = r107;
        this.f22290g = r105;
        return;
    L21:
        r107 = null;
        goto L23
    L17:
        r106 = null;
        goto L19
    }
}
