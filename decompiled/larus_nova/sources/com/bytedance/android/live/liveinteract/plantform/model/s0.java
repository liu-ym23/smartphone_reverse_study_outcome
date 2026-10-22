package com.bytedance.android.live.liveinteract.plantform.model;

import android.graphics.Bitmap;
import android.view.View;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f77239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f77240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f77241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f77242d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bitmap f77243e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f77244f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f77245g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f77246h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f77247i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f77248j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Boolean f77249k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f77250l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Integer f77251m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f77252n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Integer f77253o;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s0) == false) goto L36;
        s0 r101 = (s0) r100;
        if (Float.compare(this.f77239a, r101.f77239a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f77240b, r101.f77240b) == 0) goto L10;
        return false;
    L10:
        if (this.f77241c == r101.f77241c) goto L12;
        return false;
    L12:
        if (this.f77242d == r101.f77242d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f77243e, r101.f77243e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f77244f, r101.f77244f) == true) goto L18;
        return false;
    L18:
        if (Float.compare(this.f77245g, r101.f77245g) == 0) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f77246h, r101.f77246h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f77247i, r101.f77247i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f77248j, r101.f77248j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f77249k, r101.f77249k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f77250l, r101.f77250l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f77251m, r101.f77251m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f77252n, r101.f77252n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f77253o, r101.f77253o) == true) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    public final int hashCode() {
        int r100 = ((((((Float.floatToIntBits(this.f77239a) * 31) + Float.floatToIntBits(this.f77240b)) * 31) + this.f77241c) * 31) + this.f77242d) * 31;
        Bitmap r101 = this.f77243e;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        View r105 = this.f77244f;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (((r104 + r106) * 31) + Float.floatToIntBits(this.f77245g)) * 31;
        View r108 = this.f77246h;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f77247i;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f77248j;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        Boolean r117 = this.f77249k;
        if (r117 == null) goto L25;
        int r118 = r117.hashCode();
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f77250l;
        if (r120 == null) goto L29;
        int r121 = r120.hashCode();
    L30:
        int r122 = (r119 + r121) * 31;
        Integer r123 = this.f77251m;
        if (r123 == null) goto L33;
        int r124 = r123.hashCode();
    L34:
        int r125 = (r122 + r124) * 31;
        String r126 = this.f77252n;
        if (r126 == null) goto L37;
        int r127 = r126.hashCode();
    L38:
        int r128 = (r125 + r127) * 31;
        Integer r129 = this.f77253o;
        if (r129 == null) goto L42;
        r102 = r129.hashCode();
    L42:
        return r128 + r102;
    L37:
        r127 = 0;
        goto L38
    L33:
        r124 = 0;
        goto L34
    L29:
        r121 = 0;
        goto L30
    L25:
        r118 = 0;
        goto L26
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("{LinkerHeadRenderInfo--uid:");
        r100.append(this.f77247i);
        r100.append(", x:");
        r100.append(this.f77239a);
        r100.append(", y:");
        r100.append(this.f77240b);
        r100.append(", width:");
        r100.append(this.f77241c);
        r100.append(", height:");
        r100.append(this.f77242d);
        r100.append(", bimap:");
        Bitmap r101 = this.f77243e;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L6:
        r100.append(r102);
        r100.append('}');
        return r100.toString();
    L5:
        r102 = 0;
        goto L6
    }

    public /* synthetic */ s0(float r110, float r111, int r112, int r210, float r211, String r212, Boolean r213, int r214) {
        if ((r214 & 512) == 0) goto L5;
        String r113 = "";
    L7:
        if ((r214 & 1024) == 0) goto L9;
        Boolean r114 = null;
    L11:
        if ((r214 & 2048) == 0) goto L13;
        String r115 = SVGRenderEngine.CIRCLE;
    L15:
        if ((r214 & 4096) == 0) goto L17;
        Integer r116 = 0;
    L19:
        if ((r214 & 8192) == 0) goto L21;
        String r117 = "";
    L23:
        if ((r214 & 16384) == 0) goto L25;
        Integer r118 = -1;
    L26:
        this(r110, r111, r112, r210, null, null, r211, null, r212, r113, r114, r115, r116, r117, r118);
        return;
    L25:
        r118 = null;
        goto L26
    L21:
        r117 = null;
        goto L23
    L17:
        r116 = null;
        goto L19
    L13:
        r115 = null;
        goto L15
    L9:
        r114 = r213;
        goto L11
    L5:
        r113 = null;
        goto L7
    }

    public s0(float r100, float r101, int r102, int r103, Bitmap r104, View r110, float r111, View r112, String r113, String r114, Boolean r115, String r116, Integer r117, String r118, Integer r119) {
        Intrinsics.checkNotNullParameter(r114, "url");
        Intrinsics.checkNotNullParameter(r118, "linkType");
        this.f77239a = r100;
        this.f77240b = r101;
        this.f77241c = r102;
        this.f77242d = r103;
        this.f77243e = r104;
        this.f77244f = r110;
        this.f77245g = r111;
        this.f77246h = r112;
        this.f77247i = r113;
        this.f77248j = r114;
        this.f77249k = r115;
        this.f77250l = r116;
        this.f77251m = r117;
        this.f77252n = r118;
        this.f77253o = r119;
    }
}
