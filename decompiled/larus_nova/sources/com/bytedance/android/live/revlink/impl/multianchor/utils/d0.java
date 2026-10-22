package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.livesdk.link.model.o9;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f94899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f94900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f94901c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f94902d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f94903e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f94904f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f94905g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o9 f94906h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f94907i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f94908j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f94909k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d0) == false) goto L30;
        d0 r101 = (d0) r100;
        if (this.f94899a == r101.f94899a) goto L8;
        return false;
    L8:
        if (this.f94900b == r101.f94900b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f94901c, r101.f94901c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f94902d, r101.f94902d) == true) goto L14;
        return false;
    L14:
        if (this.f94903e == r101.f94903e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f94904f, r101.f94904f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f94905g, r101.f94905g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f94906h, r101.f94906h) == true) goto L22;
        return false;
    L22:
        if (this.f94907i == r101.f94907i) goto L24;
        return false;
    L24:
        if (this.f94908j == r101.f94908j) goto L26;
        return false;
    L26:
        if (this.f94909k == r101.f94909k) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(null, null) == true) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20, types: [int] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    public final int hashCode() {
        long r100 = this.f94899a;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f94900b) * 31;
        String r102 = this.f94901c;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L6:
        int r104 = (r101 + r103) * 31;
        String r105 = this.f94902d;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (((r104 + r106) * 31) + this.f94903e) * 31;
        String r108 = this.f94904f;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f94905g;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        o9 r114 = this.f94906h;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        boolean r117 = this.f94907i;
        ?? r118 = 1;
        ?? r119 = r117;
        if (r117 == false) goto L25;
        r119 = 1;
    L25:
        long r120 = this.f94908j;
        int r121 = (((r116 + r119) * 31) + ((int) (r120 ^ (r120 >>> 32)))) * 31;
        boolean r122 = this.f94909k;
        if (r122 == true) goto L30;
        r118 = r122;
    L30:
        return ((r121 + r118) * 31) + 0;
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
        return "PkToMultiLinkParams(channelID=" + this.f94899a + ", matchType=" + this.f94900b + ", linkerID=" + this.f94901c + ", guestLinkMicId=" + this.f94902d + ", inviteType=" + this.f94903e + ", linkConnectionType=" + this.f94904f + ", rtcInfo=" + this.f94905g + ", switchSceneData=" + this.f94906h + ", isRealOrgnizer=" + this.f94907i + ", linkStartTime=" + this.f94908j + ", linkFromPkMultiInvite=" + this.f94909k + ", linkPunishInfo=null)";
    }

    public d0(long r100, int r101, String r102, String r103, int r104, String r105, String r106, o9 r110, boolean r111, long r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r102, "linkerID");
        Intrinsics.checkNotNullParameter(r103, "guestLinkMicId");
        Intrinsics.checkNotNullParameter(r105, "linkConnectionType");
        Intrinsics.checkNotNullParameter(r110, "switchSceneData");
        this.f94899a = r100;
        this.f94900b = r101;
        this.f94901c = r102;
        this.f94902d = r103;
        this.f94903e = r104;
        this.f94904f = r105;
        this.f94905g = r106;
        this.f94906h = r110;
        this.f94907i = r111;
        this.f94908j = r112;
        this.f94909k = r113;
    }
}
