package com.bytedance.android.live.revlink.impl.pk.service;

import com.bytedance.android.live.revlink.impl.jsb.f0;
import com.bytedance.android.livesdk.link.model.b0;
import com.bytedance.android.livesdk.link.model.j8;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f96859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f96860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f96861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f96862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b0 f96863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f41.a f96864f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f96865g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L20;
        j r101 = (j) r100;
        if (this.f96859a == r101.f96859a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f96860b, r101.f96860b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f96861c, r101.f96861c) == true) goto L12;
        return false;
    L12:
        if (this.f96862d == r101.f96862d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f96863e, r101.f96863e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f96864f, r101.f96864f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f96865g, r101.f96865g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f96859a * 31;
        String r101 = this.f96860b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f96861c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (((r104 + r106) * 31) + this.f96862d) * 31;
        b0 r108 = this.f96863e;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        f41.a r111 = this.f96864f;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f96865g;
        if (r114 == null) goto L22;
        r102 = r114.hashCode();
    L22:
        return r113 + r102;
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
        return "StartAutoMatchParams(matchType=" + this.f96859a + ", activityType=" + this.f96860b + ", source=" + this.f96861c + ", matchStyleType=" + this.f96862d + ", autoMatchInfo=" + this.f96863e + ", jsbInvitePkCallback=" + this.f96864f + ", gameAppId=" + this.f96865g + ")";
    }

    public j(int r100, String r101, String r102, int r103, j8 r104, f0 r105, String r106) {
        Intrinsics.checkNotNullParameter(r101, "activityType");
        Intrinsics.checkNotNullParameter(r102, "source");
        Intrinsics.checkNotNullParameter(r104, "autoMatchInfo");
        Intrinsics.checkNotNullParameter(r105, "jsbInvitePkCallback");
        Intrinsics.checkNotNullParameter(r106, "gameAppId");
        this.f96859a = r100;
        this.f96860b = r101;
        this.f96861c = r102;
        this.f96862d = r103;
        this.f96863e = r104;
        this.f96864f = r105;
        this.f96865g = r106;
    }
}
