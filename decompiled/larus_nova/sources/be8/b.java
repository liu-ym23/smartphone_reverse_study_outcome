package be8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f18744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f18747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f18748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f18749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f18750g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f18751h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f18752i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Long f18753j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f18754k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Integer f18755l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Integer f18756m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f18744a, r101.f18744a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f18745b, r101.f18745b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f18746c, r101.f18746c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f18747d, r101.f18747d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f18748e, r101.f18748e) == true) goto L24;
        return false;
    L24:
        if (this.f18749f == r101.f18749f) goto L27;
        return false;
    L27:
        if (this.f18750g == r101.f18750g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f18751h, r101.f18751h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f18752i, r101.f18752i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f18753j, r101.f18753j) == true) goto L39;
        return false;
    L39:
        if (this.f18754k == r101.f18754k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f18755l, r101.f18755l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f18756m, r101.f18756m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f18744a.hashCode() * 31) + this.f18745b.hashCode()) * 31;
        String r101 = this.f18746c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((r100 + r103) * 31) + this.f18747d.hashCode()) * 31) + this.f18748e.hashCode()) * 31;
        int r105 = 1231;
        if (this.f18749f == false) goto L9;
        int r106 = 1231;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f18750g) * 31;
        String r108 = this.f18751h;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f18752i;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Long r114 = this.f18753j;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        if (this.f18754k == true) goto L26;
        r105 = 1237;
    L26:
        int r117 = (r116 + r105) * 31;
        Integer r118 = this.f18755l;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        Integer r121 = this.f18756m;
        if (r121 == null) goto L35;
        r102 = r121.hashCode();
    L35:
        return r120 + r102;
    L29:
        r119 = r118.hashCode();
        goto L30
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "SkillAbilitySkill(skillId=" + this.f18744a + ", name=" + this.f18745b + ", externalSkillId=" + this.f18746c + ", description=" + this.f18747d + ", iconUrl=" + this.f18748e + ", recommend=" + this.f18749f + ", type=" + this.f18750g + ", path=" + this.f18751h + ", categoryName=" + this.f18752i + ", lastUsedAtMs=" + this.f18753j + ", isSuggestionRecommended=" + this.f18754k + ", suggestionPosition=" + this.f18755l + ", suggestionSkillsLimit=" + this.f18756m + ')';
    }

    public final int getType() {
        return this.f18750g;
    }

    public b(String r100, String r101, String r102, String r103, String r104, boolean r105, int r106, String r107, String r110, Long r111, boolean r112, Integer r113, Integer r114) {
        Intrinsics.checkNotNullParameter(r100, "skillId");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r103, "description");
        Intrinsics.checkNotNullParameter(r104, "iconUrl");
        this.f18744a = r100;
        this.f18745b = r101;
        this.f18746c = r102;
        this.f18747d = r103;
        this.f18748e = r104;
        this.f18749f = r105;
        this.f18750g = r106;
        this.f18751h = r107;
        this.f18752i = r110;
        this.f18753j = r111;
        this.f18754k = r112;
        this.f18755l = r113;
        this.f18756m = r114;
    }
}
