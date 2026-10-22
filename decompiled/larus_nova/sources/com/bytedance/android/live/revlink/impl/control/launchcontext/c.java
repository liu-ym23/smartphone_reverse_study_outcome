package com.bytedance.android.live.revlink.impl.control.launchcontext;

import com.bytedance.android.livesdk.link.model.m;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.v3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c implements sc0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f92439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f92440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PkAnchorLaunchType f92441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v3 f92442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final p0 f92443e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m f92444f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f92445g;

    public final int hashCode() {
        long r100 = this.f92439a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f92440b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        PkAnchorLaunchType r106 = this.f92441c;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        v3 r109 = this.f92442d;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        p0 r112 = this.f92443e;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        m r115 = this.f92444f;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        int r117 = (r114 + r116) * 31;
        String r118 = this.f92445g;
        if (r118 == null) goto L26;
        r103 = r118.hashCode();
    L26:
        return r117 + r103;
    L21:
        r116 = 0;
        goto L22
    L17:
        r113 = 0;
        goto L18
    L13:
        r110 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "PkAnchorLaunchContext(channelID=" + this.f92439a + ", guestUid=" + this.f92440b + ", launchType=" + this.f92441c + ", clientAttachedInfo=" + this.f92442d + ", battleAttachedInfo=" + this.f92443e + ", layoutInfo=" + this.f92444f + ", eventTrackingInfo=" + this.f92445g + ")";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L20;
        c r101 = (c) r100;
        if (this.f92439a == r101.f92439a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f92440b, r101.f92440b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f92441c, r101.f92441c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f92442d, r101.f92442d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f92443e, r101.f92443e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f92444f, r101.f92444f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f92445g, r101.f92445g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public c(long r100, String r101, PkAnchorLaunchType r102, p0 r103, m r104, String r105) {
        this.f92439a = r100;
        this.f92440b = r101;
        this.f92441c = r102;
        this.f92442d = null;
        this.f92443e = r103;
        this.f92444f = r104;
        this.f92445g = r105;
    }
}
