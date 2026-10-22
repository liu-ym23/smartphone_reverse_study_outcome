package com.bytedance.android.shopping.deepfeed.data.repo;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f173248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f173249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f173250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f173251d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f173252e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f173253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f173254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f173255h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L22;
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f173248a, r101.f173248a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f173249b, r101.f173249b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f173250c, r101.f173250c) == true) goto L12;
        return false;
    L12:
        if (this.f173251d == r101.f173251d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f173252e, r101.f173252e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f173253f, r101.f173253f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f173254g, r101.f173254g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f173255h, r101.f173255h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    public final int hashCode() {
        String r100 = this.f173248a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.f173249b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f173250c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f173251d;
        ?? r111 = r110;
        if (r110 == false) goto L17;
        r111 = 1;
    L17:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f173252e;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f173253f;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f173254g;
        if (r119 == null) goto L28;
        int r120 = r119.hashCode();
    L29:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f173255h;
        if (r122 == null) goto L33;
        r101 = r122.hashCode();
    L33:
        return r121 + r101;
    L28:
        r120 = 0;
        goto L29
    L24:
        r117 = 0;
        goto L25
    L20:
        r114 = 0;
        goto L21
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
        return "DeepFeedRequestExtra(aiText=" + this.f173248a + ", aiFeatures=" + this.f173249b + ", insertPosition=" + this.f173250c + ", isFullScreen=" + this.f173251d + ", updatePosition=" + this.f173252e + ", curCardPageNum=" + this.f173253f + ", uuid=" + this.f173254g + ", productId=" + this.f173255h + ")";
    }

    public n(String r100, List<String> r101, Integer r102, boolean r103, Integer r104, Integer r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, "aiText");
        Intrinsics.checkNotNullParameter(r106, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r107, "productId");
        this.f173248a = r100;
        this.f173249b = r101;
        this.f173250c = r102;
        this.f173251d = r103;
        this.f173252e = r104;
        this.f173253f = r105;
        this.f173254g = r106;
        this.f173255h = r107;
    }
}
