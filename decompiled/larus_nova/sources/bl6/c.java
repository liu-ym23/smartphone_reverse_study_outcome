package bl6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class c implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f19459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f19460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f19461e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f19462f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f19463g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f19464h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f19465i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f19466j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f19467k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f19468l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f19469m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Double f19470n;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L34;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f19457a, r101.f19457a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f19458b, r101.f19458b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f19459c, r101.f19459c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f19460d, r101.f19460d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f19461e, r101.f19461e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f19462f, r101.f19462f) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.f19463g, r101.f19463g) == 0) goto L20;
        return false;
    L20:
        if (this.f19464h == r101.f19464h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f19465i, r101.f19465i) == true) goto L24;
        return false;
    L24:
        if (this.f19466j == r101.f19466j) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f19467k, r101.f19467k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f19468l, r101.f19468l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f19469m, r101.f19469m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f19470n, r101.f19470n) == true) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f19457a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f19458b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f19459c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f19460d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f19461e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f19462f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (((r115 + r117) * 31) + Float.floatToIntBits(this.f19463g)) * 31;
        boolean r119 = this.f19464h;
        ?? r120 = 1;
        ?? r121 = r119;
        if (r119 == false) goto L29;
        r121 = 1;
    L29:
        int r122 = (r118 + r121) * 31;
        String r123 = this.f19465i;
        if (r123 == null) goto L32;
        int r124 = r123.hashCode();
    L33:
        int r125 = (r122 + r124) * 31;
        boolean r126 = this.f19466j;
        if (r126 == true) goto L37;
        r120 = r126;
    L37:
        int r127 = (r125 + r120) * 31;
        String r128 = this.f19467k;
        if (r128 == null) goto L40;
        int r129 = r128.hashCode();
    L41:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f19468l;
        if (r131 == null) goto L44;
        int r132 = r131.hashCode();
    L45:
        int r133 = (r130 + r132) * 31;
        String r134 = this.f19469m;
        if (r134 == null) goto L48;
        int r135 = r134.hashCode();
    L49:
        int r136 = (r133 + r135) * 31;
        Double r137 = this.f19470n;
        if (r137 == null) goto L53;
        r101 = r137.hashCode();
    L53:
        return r136 + r101;
    L48:
        r135 = 0;
        goto L49
    L44:
        r132 = 0;
        goto L45
    L40:
        r129 = 0;
        goto L41
    L32:
        r124 = 0;
        goto L33
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MidiFeedbackSeiPayload(avatar_thumb=" + this.f19457a + ", user_id=" + this.f19458b + ", sec_uid=" + this.f19459c + ", nick_name=" + this.f19460d + ", percentage=" + this.f19461e + ", song_title=" + this.f19462f + ", score=" + this.f19463g + ", is_high_score=" + this.f19464h + ", midi_tips=" + this.f19465i + ", hit_record_ab=" + this.f19466j + ", song_id=" + this.f19467k + ", anchor_id=" + this.f19468l + ", sender_user_id=" + this.f19469m + ", threshold=" + this.f19470n + ")";
    }

    public c(String r100, String r101, String r102, String r103, Long r104, float r105, boolean r106, String r107, String r110, Double r111) {
        Intrinsics.checkNotNullParameter(r110, "song_id");
        this.f19457a = r100;
        this.f19458b = r101;
        this.f19459c = r102;
        this.f19460d = r103;
        this.f19461e = r104;
        this.f19462f = null;
        this.f19463g = r105;
        this.f19464h = r106;
        this.f19465i = r107;
        this.f19466j = false;
        this.f19467k = r110;
        this.f19468l = null;
        this.f19469m = null;
        this.f19470n = r111;
    }
}
