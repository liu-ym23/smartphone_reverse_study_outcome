package be8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f18775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f18776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f18777e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f18778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f18779g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f18780h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f18773a, r101.f18773a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f18774b, r101.f18774b) == true) goto L15;
        return false;
    L15:
        if (this.f18775c == r101.f18775c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f18776d, r101.f18776d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f18777e, r101.f18777e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f18778f, r101.f18778f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f18779g, r101.f18779g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f18780h, r101.f18780h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f18773a.hashCode() * 31) + this.f18774b.hashCode()) * 31;
        if (this.f18775c == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        String r103 = this.f18776d;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f18777e;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f18778f;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f18779g;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f18780h;
        if (r116 == null) goto L27;
        r104 = r116.hashCode();
    L27:
        return r115 + r104;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "TaskProjectSelection(projectId=" + this.f18773a + ", name=" + this.f18774b + ", isCloudProject=" + this.f18775c + ", folderName=" + this.f18776d + ", workspace=" + this.f18777e + ", deviceId=" + this.f18778f + ", deviceName=" + this.f18779g + ", deviceType=" + this.f18780h + ')';
    }

    public /* synthetic */ f(String r110, String r111, boolean r112, String r113, String r114, String r115, String r116, int r117) {
        if ((r117 & 8) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r117 & 16) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r117 & 32) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r117 & 64) == 0) goto L17;
        String r103 = null;
    L18:
        this(r110, r111, r112, r100, r101, r102, r103, null);
        return;
    L17:
        r103 = r116;
        goto L18
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }

    public f(String r100, String r101, boolean r102, String r103, String r104, String r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, "projectId");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f18773a = r100;
        this.f18774b = r101;
        this.f18775c = r102;
        this.f18776d = r103;
        this.f18777e = r104;
        this.f18778f = r105;
        this.f18779g = r106;
        this.f18780h = r107;
    }
}
