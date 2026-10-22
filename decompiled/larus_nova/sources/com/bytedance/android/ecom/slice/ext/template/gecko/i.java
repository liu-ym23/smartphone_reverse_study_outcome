package com.bytedance.android.ecom.slice.ext.template.gecko;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SlcElement f51261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f51262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f51263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f51264d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f51265e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f51266f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f51267g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f51268h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L22;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f51261a, r101.f51261a) == true) goto L8;
        return false;
    L8:
        if (this.f51262b == r101.f51262b) goto L10;
        return false;
    L10:
        if (this.f51263c == r101.f51263c) goto L12;
        return false;
    L12:
        if (this.f51264d == r101.f51264d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f51265e, r101.f51265e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f51266f, r101.f51266f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f51267g, r101.f51267g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f51268h, r101.f51268h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    public final int hashCode() {
        SlcElement r100 = this.f51261a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f51262b;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f51263c;
        int r108 = (((r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31) + this.f51264d) * 31;
        String r109 = this.f51265e;
        if (r109 == null) goto L12;
        int r110 = r109.hashCode();
    L13:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f51266f;
        if (r112 == null) goto L16;
        int r113 = r112.hashCode();
    L17:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f51267g;
        if (r115 == null) goto L20;
        int r116 = r115.hashCode();
    L21:
        int r117 = (r114 + r116) * 31;
        String r118 = this.f51268h;
        if (r118 == null) goto L25;
        r101 = r118.hashCode();
    L25:
        return r117 + r101;
    L20:
        r116 = 0;
        goto L21
    L16:
        r113 = 0;
        goto L17
    L12:
        r110 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SlcTemplateLoadResult(rootElement=" + this.f51261a + ", isHitCache=" + this.f51262b + ", geckoVersion=" + this.f51263c + ", geckoErrorCode=" + this.f51264d + ", geckoErrorMsg=" + this.f51265e + ", loadFrom=" + this.f51266f + ", loadSeq=" + this.f51267g + ", templateJsonStr=" + this.f51268h + ")";
    }

    public static i a(i r110) {
        SlcElement r100 = r110.f51261a;
        long r101 = r110.f51263c;
        int r102 = r110.f51264d;
        String r103 = r110.f51265e;
        String r104 = r110.f51266f;
        String r105 = r110.f51267g;
        String r106 = r110.f51268h;
        r110.getClass();
        return new i(r100, true, r101, r102, r103, r104, r105, r106);
    }

    public /* synthetic */ i(SlcElement r110, long r111, int r112, String r113, String r114, String r115, String r116, int r210) {
        if ((r210 & 4) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r210 & 8) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r210 & 16) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r210 & 32) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r210 & 64) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r210 & 128) == 0) goto L25;
        String r117 = null;
    L26:
        this(r110, false, r100, r101, r102, r103, r104, r117);
        return;
    L25:
        r117 = r116;
        goto L26
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

    public i(SlcElement r100, boolean r101, long r102, int r103, String r104, String r105, String r106, String r107) {
        this.f51261a = r100;
        this.f51262b = r101;
        this.f51263c = r102;
        this.f51264d = r103;
        this.f51265e = r104;
        this.f51266f = r105;
        this.f51267g = r106;
        this.f51268h = r107;
    }
}
