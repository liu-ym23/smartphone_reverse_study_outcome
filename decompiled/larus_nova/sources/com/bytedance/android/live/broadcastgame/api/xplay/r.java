package com.bytedance.android.live.broadcastgame.api.xplay;

import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f59516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f59517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f59518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f59519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f59520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f59521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f59522g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f59523h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f59524i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f59525j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f59526k;

    public r() {
        this(0);
    }

    public final String toString() {
        return "XplayRTCEngineConfig(rtcExtInfo=" + this.f59516a + ", appId=" + this.f59517b + ", vendor=" + this.f59518c + ", vendorName=" + this.f59519d + ", appSignature=" + Arrays.toString(this.f59520e) + ", channelId=" + this.f59521f + ", token=" + this.f59522g + ", userId=" + this.f59523h + ", interactId=" + this.f59524i + ", interactIdMode=" + this.f59525j + ", businessId=" + this.f59526k + ")";
    }

    public final int hashCode() {
        int r100 = ((((((this.f59516a.hashCode() * 31) + this.f59517b.hashCode()) * 31) + this.f59518c) * 31) + this.f59519d.hashCode()) * 31;
        byte[] r101 = this.f59520e;
        if (r101 == null) goto L5;
        int r102 = Arrays.hashCode(r101);
    L7:
        return ((((((((((((r100 + r102) * 31) + this.f59521f.hashCode()) * 31) + this.f59522g.hashCode()) * 31) + this.f59523h.hashCode()) * 31) + this.f59524i.hashCode()) * 31) + this.f59525j) * 31) + this.f59526k.hashCode();
    L5:
        r102 = 0;
        goto L7
    }

    public r(int r100) {
        Intrinsics.checkNotNullParameter("", "rtcExtInfo");
        Intrinsics.checkNotNullParameter("", "appId");
        Intrinsics.checkNotNullParameter("", "vendorName");
        Intrinsics.checkNotNullParameter("", RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter("", "token");
        Intrinsics.checkNotNullParameter("", "userId");
        Intrinsics.checkNotNullParameter("", "interactId");
        Intrinsics.checkNotNullParameter("", "businessId");
        this.f59516a = "";
        this.f59517b = "";
        this.f59518c = 0;
        this.f59519d = "";
        this.f59520e = null;
        this.f59521f = "";
        this.f59522g = "";
        this.f59523h = "";
        this.f59524i = "";
        this.f59525j = 0;
        this.f59526k = "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(r.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L56;
        r r102 = (r) r100;
        if ((!Intrinsics.areEqual(this.f59516a, r102.f59516a)) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(this.f59517b, r102.f59517b)) == false) goto L20;
        return false;
    L20:
        if (this.f59518c == r102.f59518c) goto L23;
        return false;
    L23:
        if ((!Intrinsics.areEqual(this.f59519d, r102.f59519d)) == false) goto L25;
        return false;
    L25:
        byte[] r103 = this.f59520e;
        if (r103 == null) goto L34;
        byte[] r104 = r102.f59520e;
        if (r104 != null) goto L31;
        return false;
    L31:
        if (Arrays.equals(r103, r104) == true) goto L37;
        return false;
    L37:
        if ((!Intrinsics.areEqual(this.f59521f, r102.f59521f)) == false) goto L40;
        return false;
    L40:
        if ((!Intrinsics.areEqual(this.f59522g, r102.f59522g)) == false) goto L43;
        return false;
    L43:
        if ((!Intrinsics.areEqual(this.f59523h, r102.f59523h)) == false) goto L46;
        return false;
    L46:
        if ((!Intrinsics.areEqual(this.f59524i, r102.f59524i)) == false) goto L49;
        return false;
    L49:
        if (this.f59525j == r102.f59525j) goto L52;
        return false;
    L52:
        if ((!Intrinsics.areEqual(this.f59526k, r102.f59526k)) == false) goto L54;
        return false;
    L54:
        return true;
    L34:
        if (r102.f59520e == null) goto L37;
        return false;
    L56:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.api.xplay.XplayRTCEngineConfig");
    L8:
        r101 = null;
        goto L10
    }
}
