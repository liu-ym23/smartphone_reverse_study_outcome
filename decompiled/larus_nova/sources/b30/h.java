package b30;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f17128e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f17129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f17130g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f17131h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f17132i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f17133j;

    public h() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L26;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f17124a, r101.f17124a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f17125b, r101.f17125b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f17126c, r101.f17126c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f17127d, r101.f17127d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f17128e, r101.f17128e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f17129f, r101.f17129f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f17130g, r101.f17130g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f17131h, r101.f17131h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f17132i, r101.f17132i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f17133j, r101.f17133j) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f17124a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f17125b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f17126c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f17127d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f17128e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f17129f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f17130g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f17131h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f17132i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f17133j;
        if (r128 == null) goto L42;
        r101 = r128.hashCode();
    L42:
        return r127 + r101;
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
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
        return "OpenCommentPanelAtUserParam(replyUserId=" + this.f17124a + ", replyUserName=" + this.f17125b + ", switchType=" + this.f17126c + ", preAtUserId=" + this.f17127d + ", preAtSecUserId=" + this.f17128e + ", preAtUserName=" + this.f17129f + ", commentId=" + this.f17130g + ", vsEventPage=" + this.f17131h + ", toCommentCategory=" + this.f17132i + ", vsReplyClickPosition=" + this.f17133j + ")";
    }

    public /* synthetic */ h(int r110) {
        this("-1", "", "unknown", "", "", "", "", "", "", "");
    }

    public h(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, String r110) {
        this.f17124a = r100;
        this.f17125b = r101;
        this.f17126c = r102;
        this.f17127d = r103;
        this.f17128e = r104;
        this.f17129f = r105;
        this.f17130g = r106;
        this.f17131h = r107;
        this.f17132i = r108;
        this.f17133j = r110;
    }
}
