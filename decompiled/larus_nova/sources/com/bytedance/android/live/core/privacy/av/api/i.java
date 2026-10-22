package com.bytedance.android.live.core.privacy.av.api;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f65137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f65138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f65139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f65140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f65141e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f65142f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f65143g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f65144h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L22;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f65137a, r101.f65137a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f65138b, r101.f65138b) == true) goto L10;
        return false;
    L10:
        if (this.f65139c == r101.f65139c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f65140d, r101.f65140d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f65141e, r101.f65141e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f65142f, r101.f65142f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f65143g, r101.f65143g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f65144h, r101.f65144h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f65137a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f65138b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f65139c) * 31;
        String r107 = this.f65140d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f65141e;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f65142f;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f65143g;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Map<String, String> r119 = this.f65144h;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
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
        return "PrivacyRemoteData(eventType=" + this.f65137a + ", step=" + this.f65138b + ", statusCode=" + this.f65139c + ", statusMsg=" + this.f65140d + ", biz=" + this.f65141e + ", sense=" + this.f65142f + ", type=" + this.f65143g + ", params=" + this.f65144h + ")";
    }

    public final String getType() {
        return this.f65143g;
    }

    public i(String r100, String r101, int r102, String r103, String r104, String r105, String r106, Map<String, String> r107) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r101, "step");
        Intrinsics.checkNotNullParameter(r103, com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG);
        Intrinsics.checkNotNullParameter(r104, "biz");
        Intrinsics.checkNotNullParameter(r105, "sense");
        Intrinsics.checkNotNullParameter(r106, "type");
        Intrinsics.checkNotNullParameter(r107, "params");
        this.f65137a = r100;
        this.f65138b = r101;
        this.f65139c = r102;
        this.f65140d = r103;
        this.f65141e = r104;
        this.f65142f = r105;
        this.f65143g = r106;
        this.f65144h = r107;
    }
}
