package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.liveinteract.plantform.model.MicPosTagInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class qd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f153685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f153686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f153687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f153688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f153689e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f153690f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f153691g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f153692h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MicPosTagInfo f153693i;

    public qd() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof qd) == false) goto L24;
        qd r101 = (qd) r100;
        if (this.f153685a == r101.f153685a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f153686b, r101.f153686b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f153687c, r101.f153687c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f153688d, r101.f153688d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f153689e, r101.f153689e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f153690f, r101.f153690f) == true) goto L18;
        return false;
    L18:
        if (this.f153691g == r101.f153691g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f153692h, r101.f153692h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f153693i, r101.f153693i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        boolean r100 = this.f153685a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        String r104 = this.f153686b;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        Integer r108 = this.f153687c;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f153688d;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.f153689e;
        if (r114 == null) goto L20;
        int r115 = r114.hashCode();
    L21:
        int r116 = (r113 + r115) * 31;
        Boolean r117 = this.f153690f;
        if (r117 == null) goto L24;
        int r118 = r117.hashCode();
    L25:
        int r119 = (r116 + r118) * 31;
        boolean r120 = this.f153691g;
        if (r120 == true) goto L29;
        r101 = r120;
    L29:
        int r121 = (r119 + r101) * 31;
        String r122 = this.f153692h;
        if (r122 == null) goto L32;
        int r123 = r122.hashCode();
    L33:
        int r124 = (r121 + r123) * 31;
        MicPosTagInfo r125 = this.f153693i;
        if (r125 == null) goto L37;
        r105 = r125.hashCode();
    L37:
        return r124 + r105;
    L32:
        r123 = 0;
        goto L33
    L24:
        r118 = 0;
        goto L25
    L20:
        r115 = 0;
        goto L21
    L16:
        r112 = 0;
        goto L17
    L12:
        r109 = 0;
        goto L13
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return "KtvMicLabelAnimData(hasDisplayLabel=" + this.f153685a + ", labelTag=" + this.f153686b + ", ktvLyricsText=" + this.f153687c + ", toUserIdString=" + this.f153688d + ", rank=" + this.f153689e + ", ktvStageLabelShow=" + this.f153690f + ", ktvVideoLabelShow=" + this.f153691g + ", highScoreSongCount=" + this.f153692h + ", micPosTagInfo=" + this.f153693i + ")";
    }

    public /* synthetic */ qd(int r110) {
        this(false, null, null, null, null, null, false, null, null);
    }

    public qd(boolean r100, String r101, Integer r102, String r103, Integer r104, Boolean r105, boolean r106, String r107, MicPosTagInfo r108) {
        this.f153685a = r100;
        this.f153686b = r101;
        this.f153687c = r102;
        this.f153688d = r103;
        this.f153689e = r104;
        this.f153690f = r105;
        this.f153691g = r106;
        this.f153692h = r107;
        this.f153693i = r108;
    }

    public static qd a(qd r110, boolean r111, String r112, Integer r113, String r114, Integer r115, Boolean r116, boolean r117, String r118, int r119) {
        if ((r119 & 1) == 0) goto L5;
        boolean r100 = r110.f153685a;
    L7:
        if ((r119 & 2) == 0) goto L9;
        String r101 = r110.f153686b;
    L11:
        if ((r119 & 4) == 0) goto L13;
        Integer r102 = r110.f153687c;
    L15:
        if ((r119 & 8) == 0) goto L17;
        String r103 = r110.f153688d;
    L19:
        if ((r119 & 16) == 0) goto L21;
        Integer r104 = r110.f153689e;
    L23:
        if ((r119 & 32) == 0) goto L25;
        Boolean r105 = r110.f153690f;
    L27:
        if ((r119 & 64) == 0) goto L29;
        boolean r106 = r110.f153691g;
    L31:
        if ((r119 & 128) == 0) goto L33;
        String r107 = r110.f153692h;
    L35:
        if ((r119 & 256) == 0) goto L37;
        MicPosTagInfo r108 = r110.f153693i;
    L38:
        r110.getClass();
        return new qd(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = null;
        goto L38
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
