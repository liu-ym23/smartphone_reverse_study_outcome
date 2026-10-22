package aw3;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f16494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f16497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f16498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f16499f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Double f16500g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Double f16501h;

    public s0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s0) == true) goto L8;
        return false;
    L8:
        s0 r101 = (s0) r100;
        if (Intrinsics.areEqual(this.f16494a, r101.f16494a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f16495b, r101.f16495b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f16496c, r101.f16496c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f16497d, r101.f16497d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f16498e, r101.f16498e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f16499f, r101.f16499f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f16500g, r101.f16500g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f16501h, r101.f16501h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f16494a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f16495b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f16496c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f16497d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f16498e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f16499f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Double r119 = this.f16500g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Double r122 = this.f16501h;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
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
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BackgroundAudioStateUpdate(src=" + this.f16494a + ", title=" + this.f16495b + ", epname=" + this.f16496c + ", singer=" + this.f16497d + ", coverImgUrl=" + this.f16498e + ", webUrl=" + this.f16499f + ", startTime=" + this.f16500g + ", playbackRate=" + this.f16501h + ')';
    }

    public final String a() {
        String[] r100 = new String[8];
        StringBuilder r101 = new StringBuilder("src: ");
        boolean r102 = true;
        if (this.f16494a == null) goto L5;
        boolean r103 = true;
    L6:
        r101.append(r103);
        r100[0] = r101.toString();
        StringBuilder r104 = new StringBuilder("title: ");
        if (this.f16495b == null) goto L9;
        boolean r105 = true;
    L10:
        r104.append(r105);
        r100[1] = r104.toString();
        StringBuilder r106 = new StringBuilder("epname: ");
        if (this.f16496c == null) goto L13;
        boolean r107 = true;
    L14:
        r106.append(r107);
        r100[2] = r106.toString();
        StringBuilder r108 = new StringBuilder("singer: ");
        if (this.f16497d == null) goto L17;
        boolean r109 = true;
    L18:
        r108.append(r109);
        r100[3] = r108.toString();
        StringBuilder r110 = new StringBuilder("cover: ");
        if (this.f16498e == null) goto L21;
        boolean r111 = true;
    L22:
        r110.append(r111);
        r100[4] = r110.toString();
        StringBuilder r112 = new StringBuilder("webUrl: ");
        if (this.f16499f != null) goto L26;
        r102 = false;
    L26:
        r112.append(r102);
        r100[5] = r112.toString();
        Double r113 = this.f16500g;
        String r114 = "null";
        if (r113 == null) goto L30;
        String r115 = r0.a(r113.doubleValue());
        if (r115 == null) goto L30;
    L31:
        r100[6] = "startTime: ".concat(r115);
        Double r116 = this.f16501h;
        if (r116 == null) goto L37;
        String r117 = r0.a(r116.doubleValue());
        if (r117 == null) goto L37;
        r114 = r117;
    L37:
        r100[7] = "playbackRate: ".concat(r114);
        return CollectionsKt.joinToString$default(CollectionsKt.listOf(r100), ", ", null, null, 0, null, null, 62, null);
    L30:
        r115 = "null";
        goto L31
    L21:
        r111 = false;
        goto L22
    L17:
        r109 = false;
        goto L18
    L13:
        r107 = false;
        goto L14
    L9:
        r105 = false;
        goto L10
    L5:
        r103 = false;
        goto L6
    }

    public /* synthetic */ s0(int r110) {
        this(null, null, null, null, null, null, null, null);
    }

    public s0(String r100, String r101, String r102, String r103, String r104, String r105, Double r106, Double r107) {
        this.f16494a = r100;
        this.f16495b = r101;
        this.f16496c = r102;
        this.f16497d = r103;
        this.f16498e = r104;
        this.f16499f = r105;
        this.f16500g = r106;
        this.f16501h = r107;
    }
}
