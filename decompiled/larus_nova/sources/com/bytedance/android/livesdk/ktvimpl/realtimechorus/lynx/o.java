package com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f146731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f146732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f146733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f146734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f146735e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f146736f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f146737g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f146738h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f146739i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f146740j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L26;
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f146731a, r101.f146731a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f146732b, r101.f146732b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f146733c, r101.f146733c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f146734d, r101.f146734d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f146735e, r101.f146735e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f146736f, r101.f146736f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f146737g, r101.f146737g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f146738h, r101.f146738h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f146739i, r101.f146739i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f146740j, r101.f146740j) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f146731a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f146732b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f146733c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f146734d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f146735e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f146736f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f146737g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f146738h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f146739i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f146740j;
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
        return "TuningPanelParams(tabName=" + this.f146731a + ", totalTime=" + this.f146732b + ", currentTime=" + this.f146733c + ", originalSongChecked=" + this.f146734d + ", headphoneMonitorChecked=" + this.f146735e + ", isSupportEarMonitor=" + this.f146736f + ", showNetworkImprovement=" + this.f146737g + ", showOppoHeadphoneGuide=" + this.f146738h + ", networkImprovementChecked=" + this.f146739i + ", showPlaybackControls=" + this.f146740j + ")";
    }

    public o() {
        this("", "", "", "0", "0", "0", "0", "0", "0", "0");
    }

    public o(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "tabName");
        Intrinsics.checkNotNullParameter(r101, "totalTime");
        Intrinsics.checkNotNullParameter(r102, "currentTime");
        Intrinsics.checkNotNullParameter(r103, "originalSongChecked");
        Intrinsics.checkNotNullParameter(r104, "headphoneMonitorChecked");
        Intrinsics.checkNotNullParameter(r105, "isSupportEarMonitor");
        Intrinsics.checkNotNullParameter(r106, "showNetworkImprovement");
        Intrinsics.checkNotNullParameter(r107, "showOppoHeadphoneGuide");
        Intrinsics.checkNotNullParameter(r110, "networkImprovementChecked");
        Intrinsics.checkNotNullParameter(r111, "showPlaybackControls");
        this.f146731a = r100;
        this.f146732b = r101;
        this.f146733c = r102;
        this.f146734d = r103;
        this.f146735e = r104;
        this.f146736f = r105;
        this.f146737g = r106;
        this.f146738h = r107;
        this.f146739i = r110;
        this.f146740j = r111;
    }
}
