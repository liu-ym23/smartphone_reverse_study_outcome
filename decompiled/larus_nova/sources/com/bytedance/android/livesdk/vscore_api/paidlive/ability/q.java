package com.bytedance.android.livesdk.vscore_api.paidlive.ability;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.vscore_api.paidlive.n f159414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f159415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f159416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f159417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f159418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f159419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f159420g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f159421h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final k f159422i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f159423j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final m f159424k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == false) goto L28;
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f159414a, r101.f159414a) == true) goto L8;
        return false;
    L8:
        if (this.f159415b == r101.f159415b) goto L10;
        return false;
    L10:
        if (this.f159416c == r101.f159416c) goto L12;
        return false;
    L12:
        if (this.f159417d == r101.f159417d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f159418e, r101.f159418e) == true) goto L16;
        return false;
    L16:
        if (this.f159419f == r101.f159419f) goto L18;
        return false;
    L18:
        if (this.f159420g == r101.f159420g) goto L20;
        return false;
    L20:
        if (this.f159421h == r101.f159421h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f159422i, r101.f159422i) == true) goto L24;
        return false;
    L24:
        if (this.f159423j == r101.f159423j) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f159424k, r101.f159424k) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        com.bytedance.android.livesdk.vscore_api.paidlive.n r100 = this.f159414a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f159415b;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        boolean r108 = this.f159416c;
        ?? r109 = r108;
        if (r108 == false) goto L12;
        r109 = 1;
    L12:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.f159417d;
        ?? r112 = r111;
        if (r111 == false) goto L15;
        r112 = 1;
    L15:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f159418e;
        if (r114 == null) goto L18;
        int r115 = r114.hashCode();
    L19:
        long r116 = this.f159419f;
        int r117 = (((r113 + r115) * 31) + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        long r118 = this.f159420g;
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        boolean r120 = this.f159421h;
        ?? r121 = r120;
        if (r120 == false) goto L22;
        r121 = 1;
    L22:
        int r122 = (r119 + r121) * 31;
        k r123 = this.f159422i;
        if (r123 == null) goto L25;
        int r124 = r123.hashCode();
    L26:
        int r125 = (r122 + r124) * 31;
        boolean r126 = this.f159423j;
        if (r126 == true) goto L30;
        r105 = r126;
    L30:
        int r127 = (r125 + r105) * 31;
        m r128 = this.f159424k;
        if (r128 == null) goto L34;
        r101 = r128.hashCode();
    L34:
        return r127 + r101;
    L25:
        r124 = 0;
        goto L26
    L18:
        r115 = 0;
        goto L19
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PaidTempWatchConfig(sceneStateMachine=" + this.f159414a + ", needTimeCount=" + this.f159415b + ", needAdjustRemainDuration=" + this.f159416c + ", needTimeCountAfterFirstFrame=" + this.f159417d + ", tempTimeCountId=" + this.f159418e + ", maxDuration=" + this.f159419f + ", curWatchDuration=" + this.f159420g + ", loadTempWatchConversionCard=" + this.f159421h + ", conversionCard=" + this.f159422i + ", loadPlayerTempWatchTip=" + this.f159423j + ", playerTip=" + this.f159424k + ")";
    }

    public q(com.bytedance.android.livesdk.vscore_api.paidlive.n r110, boolean r111, boolean r112, boolean r210, String r211, long r212, long r213, k r214, boolean r215, m r216, int r217) {
        m r100 = null;
        if ((r217 & 1) == 0) goto L5;
        com.bytedance.android.livesdk.vscore_api.paidlive.n r101 = null;
    L7:
        if ((r217 & 2) == 0) goto L9;
        boolean r102 = true;
    L11:
        if ((r217 & 4) == 0) goto L13;
        boolean r103 = true;
    L14:
        boolean r104 = false;
        if ((r217 & 8) == 0) goto L17;
        boolean r105 = false;
    L19:
        if ((r217 & 32) == 0) goto L21;
        long r113 = -1;
    L23:
        if ((r217 & 64) == 0) goto L25;
        long r114 = 0;
    L27:
        if ((r217 & 256) == 0) goto L29;
        k r115 = null;
    L31:
        if ((r217 & 512) != 0) goto L35;
        r104 = r215;
    L35:
        if ((r217 & 1024) != 0) goto L38;
        r100 = r216;
    L38:
        Intrinsics.checkNotNullParameter(r211, "tempTimeCountId");
        this.f159414a = r101;
        this.f159415b = r102;
        this.f159416c = r103;
        this.f159417d = r105;
        this.f159418e = r211;
        this.f159419f = r113;
        this.f159420g = r114;
        this.f159421h = true;
        this.f159422i = r115;
        this.f159423j = r104;
        this.f159424k = r100;
        return;
    L29:
        r115 = r214;
        goto L31
    L25:
        r114 = r213;
        goto L27
    L21:
        r113 = r212;
        goto L23
    L17:
        r105 = r210;
        goto L19
    L13:
        r103 = r112;
        goto L14
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
