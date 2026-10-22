package a54;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f1844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f1845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f1846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f1847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f1848h;

    public a() {
        this(false, false, false, null, false, false, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f1841a == r101.f1841a) goto L12;
        return false;
    L12:
        if (this.f1842b == r101.f1842b) goto L15;
        return false;
    L15:
        if (this.f1843c == r101.f1843c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f1844d, r101.f1844d) == true) goto L21;
        return false;
    L21:
        if (this.f1845e == r101.f1845e) goto L24;
        return false;
    L24:
        if (this.f1846f == r101.f1846f) goto L27;
        return false;
    L27:
        if (this.f1847g == r101.f1847g) goto L30;
        return false;
    L30:
        if (this.f1848h == r101.f1848h) goto L32;
        return false;
    L32:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    public final int hashCode() {
        boolean r100 = this.f1841a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f1842b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f1843c;
        ?? r108 = r107;
        if (r107 == false) goto L11;
        r108 = 1;
    L11:
        int r109 = (((r106 + r108) * 31) + this.f1844d.hashCode()) * 31;
        boolean r110 = this.f1845e;
        ?? r111 = r110;
        if (r110 == false) goto L14;
        r111 = 1;
    L14:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.f1846f;
        ?? r114 = r113;
        if (r113 == false) goto L17;
        r114 = 1;
    L17:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.f1847g;
        ?? r117 = r116;
        if (r116 == false) goto L20;
        r117 = 1;
    L20:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.f1848h;
        if (r119 == true) goto L25;
        r101 = r119;
    L25:
        return r118 + r101;
    }

    public final String toString() {
        return "AosCommentConfig(isEnableComment=" + this.f1841a + ", isEnableCommentReport=" + this.f1842b + ", isEnableWriteComment=" + this.f1843c + ", writeCommentHint=" + this.f1844d + ", expandCommentClickArea=" + this.f1845e + ", allowReplyComment=" + this.f1846f + ", enableDiggBury=" + this.f1847g + ", enableAvatarClick=" + this.f1848h + ')';
    }

    public /* synthetic */ a(boolean r110, boolean r111, boolean r112, String r113, boolean r114, boolean r115, int r116) {
        if ((r116 & 1) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r116 & 2) == 0) goto L9;
        boolean r101 = true;
    L11:
        if ((r116 & 4) == 0) goto L13;
        boolean r102 = true;
    L15:
        if ((r116 & 8) == 0) goto L17;
        String r103 = "善语结善缘，恶言伤人心";
    L19:
        if ((r116 & 16) == 0) goto L21;
        boolean r104 = true;
    L23:
        if ((r116 & 32) == 0) goto L25;
        boolean r105 = false;
    L27:
        if ((r116 & 64) == 0) goto L29;
        boolean r117 = true;
    L31:
        if ((r116 & 128) == 0) goto L33;
        boolean r118 = true;
    L34:
        this(r100, r101, r102, r103, r104, r105, r117, r118);
        return;
    L33:
        r118 = false;
        goto L34
    L29:
        r117 = false;
        goto L31
    L25:
        r105 = r115;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public a(boolean r100, boolean r101, boolean r102, String r103, boolean r104, boolean r105, boolean r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r103, "writeCommentHint");
        this.f1841a = r100;
        this.f1842b = r101;
        this.f1843c = r102;
        this.f1844d = r103;
        this.f1845e = r104;
        this.f1846f = r105;
        this.f1847g = r106;
        this.f1848h = r107;
    }
}
