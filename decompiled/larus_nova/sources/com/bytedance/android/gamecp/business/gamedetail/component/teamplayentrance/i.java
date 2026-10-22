package com.bytedance.android.gamecp.business.gamedetail.component.teamplayentrance;

import com.bytedance.ies.sve_core.s;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class i implements s {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f55123j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f55125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f55126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f55127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f55128e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f55129f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Boolean f55130g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f55131h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Boolean f55132i;

    public static final class a {
    }

    static {
    }

    public i() {
        this(null, null, null, null, null, null, null, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L24;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f55124a, r101.f55124a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f55125b, r101.f55125b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f55126c, r101.f55126c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f55127d, r101.f55127d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f55128e, r101.f55128e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f55129f, r101.f55129f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f55130g, r101.f55130g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f55131h, r101.f55131h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f55132i, r101.f55132i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f55124a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f55125b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f55126c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f55127d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f55128e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f55129f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.f55130g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f55131h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.f55132i;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
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
        return "TeamPlayEntranceState(icon=" + this.f55124a + ", subIcon=" + this.f55125b + ", title=" + this.f55126c + ", subTitle=" + this.f55127d + ", buttonText=" + this.f55128e + ", schema=" + this.f55129f + ", layerVisible=" + this.f55130g + ", extra=" + this.f55131h + ", needRepeatExposure=" + this.f55132i + ")";
    }

    public /* synthetic */ i(String r110, String r111, String r112, String r113, String r114, String r115, Boolean r210, String r211, int r212) {
        Boolean r100 = null;
        if ((r212 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        Boolean r116 = Boolean.TRUE;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r117 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        r100 = Boolean.FALSE;
    L37:
        this(r101, r102, r103, r104, r105, r106, r116, r117, r100);
        return;
    L33:
        r117 = r211;
        goto L35
    L29:
        r116 = r210;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public i(String r100, String r101, String r102, String r103, String r104, String r105, Boolean r106, String r107, Boolean r108) {
        this.f55124a = r100;
        this.f55125b = r101;
        this.f55126c = r102;
        this.f55127d = r103;
        this.f55128e = r104;
        this.f55129f = r105;
        this.f55130g = r106;
        this.f55131h = r107;
        this.f55132i = r108;
    }
}
