package ch9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f23812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f23814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f23815e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f23816f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f23817g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f23818h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f23819i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f23820j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f23821k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f23822l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f23823m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f23824n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f23825o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f23826p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f23827q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f23828r;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f23811a, r101.f23811a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f23812b, r101.f23812b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f23813c, r101.f23813c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f23814d, r101.f23814d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f23815e, r101.f23815e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f23816f, r101.f23816f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f23817g, r101.f23817g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f23818h, r101.f23818h) == true) goto L33;
        return false;
    L33:
        if (this.f23819i == r101.f23819i) goto L36;
        return false;
    L36:
        if (this.f23820j == r101.f23820j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f23821k, r101.f23821k) == true) goto L42;
        return false;
    L42:
        if (this.f23822l == r101.f23822l) goto L45;
        return false;
    L45:
        if (this.f23823m == r101.f23823m) goto L48;
        return false;
    L48:
        if (this.f23824n == r101.f23824n) goto L51;
        return false;
    L51:
        if (this.f23825o == r101.f23825o) goto L54;
        return false;
    L54:
        if (this.f23826p == r101.f23826p) goto L57;
        return false;
    L57:
        if (this.f23827q == r101.f23827q) goto L60;
        return false;
    L60:
        if (this.f23828r == r101.f23828r) goto L62;
        return false;
    L62:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f23811a.hashCode() * 31) + this.f23812b.hashCode()) * 31;
        String r101 = this.f23813c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f23814d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f23815e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f23816f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f23817g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (((r113 + r115) * 31) + this.f23818h.hashCode()) * 31;
        int r117 = 1231;
        if (this.f23819i == false) goto L25;
        int r118 = 1231;
    L26:
        int r119 = (r116 + r118) * 31;
        if (this.f23820j == false) goto L29;
        int r120 = 1231;
    L30:
        int r121 = (r119 + r120) * 31;
        String r122 = this.f23821k;
        if (r122 == null) goto L34;
        r102 = r122.hashCode();
    L34:
        int r123 = (r121 + r102) * 31;
        if (this.f23822l == false) goto L37;
        int r124 = 1231;
    L38:
        int r125 = (r123 + r124) * 31;
        if (this.f23823m == false) goto L41;
        int r126 = 1231;
    L42:
        int r127 = (r125 + r126) * 31;
        if (this.f23824n == false) goto L45;
        int r128 = 1231;
    L46:
        int r129 = (r127 + r128) * 31;
        if (this.f23825o == false) goto L49;
        int r130 = 1231;
    L50:
        int r131 = (r129 + r130) * 31;
        if (this.f23826p == false) goto L53;
        int r132 = 1231;
    L54:
        int r133 = (r131 + r132) * 31;
        if (this.f23827q == false) goto L57;
        int r134 = 1231;
    L58:
        int r135 = (r133 + r134) * 31;
        if (this.f23828r == true) goto L63;
        r117 = 1237;
    L63:
        return r135 + r117;
    L57:
        r134 = 1237;
        goto L58
    L53:
        r132 = 1237;
        goto L54
    L49:
        r130 = 1237;
        goto L50
    L45:
        r128 = 1237;
        goto L46
    L41:
        r126 = 1237;
        goto L42
    L37:
        r124 = 1237;
        goto L38
    L29:
        r120 = 1237;
        goto L30
    L25:
        r118 = 1237;
        goto L26
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
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceActivityEntryPolicyInput(activityRoute=" + this.f23811a + ", defaultSource=" + this.f23812b + ", requestedSource=" + this.f23813c + ", botId=" + this.f23814d + ", conversationId=" + this.f23815e + ", languageCode=" + this.f23816f + ", selectedVoiceId=" + this.f23817g + ", trackParams=" + this.f23818h + ", isFromVoiceCloneScheme=" + this.f23819i + ", disableVoiceCloneDialogAnimation=" + this.f23820j + ", entryParity=" + this.f23821k + ", ugcVoiceCanPublic=" + this.f23822l + ", ugcVoiceRecommendEnabled=" + this.f23823m + ", voiceMultiTabEnabled=" + this.f23824n + ", newStyleEnabled=" + this.f23825o + ", singleVoiceMode=" + this.f23826p + ", allowDoubleTab=" + this.f23827q + ", shouldWriteDefaultEnterMethod=" + this.f23828r + ')';
    }

    public b(String r100, String r101, String r102, String r103, String r110, String r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117, boolean r118) {
        Intrinsics.checkNotNullParameter("//flow/single_tts_speaker_setting", "activityRoute");
        Intrinsics.checkNotNullParameter("single", "defaultSource");
        Intrinsics.checkNotNullParameter(r111, "trackParams");
        this.f23811a = "//flow/single_tts_speaker_setting";
        this.f23812b = "single";
        this.f23813c = r100;
        this.f23814d = r101;
        this.f23815e = r102;
        this.f23816f = r103;
        this.f23817g = r110;
        this.f23818h = r111;
        this.f23819i = r112;
        this.f23820j = r113;
        this.f23821k = null;
        this.f23822l = r114;
        this.f23823m = r115;
        this.f23824n = r116;
        this.f23825o = r117;
        this.f23826p = r118;
        this.f23827q = true;
        this.f23828r = false;
    }
}
