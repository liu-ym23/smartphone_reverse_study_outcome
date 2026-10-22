package com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.multiscene.a f78201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f78202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f78203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f78204d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L14;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f78201a, r101.f78201a) == true) goto L8;
        return false;
    L8:
        if (this.f78202b == r101.f78202b) goto L10;
        return false;
    L10:
        if (this.f78203c == r101.f78203c) goto L12;
        return false;
    L12:
        if (this.f78204d == r101.f78204d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.live.liveinteract.multiscene.a r100 = this.f78201a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((((r101 * 31) + this.f78202b) * 31) + this.f78203c) * 31) + this.f78204d;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "LastTeamFightDynamicInfo(teamFightInfo=" + this.f78201a + ", enterFrom=" + this.f78202b + ", preStatus=" + this.f78203c + ", status=" + this.f78204d + ")";
    }

    public e(com.bytedance.android.live.liveinteract.multiscene.a r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "teamFightInfo");
        this.f78201a = r100;
        this.f78202b = r101;
        this.f78203c = r102;
        this.f78204d = r103;
    }
}
