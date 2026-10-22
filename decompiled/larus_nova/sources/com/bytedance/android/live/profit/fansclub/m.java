package com.bytedance.android.live.profit.fansclub;

import com.bytedance.ee.bear.middleground.comment.aibot.model.AiBotPollingAuthResult;

/* JADX INFO: loaded from: classes47.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f87327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f87328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f87329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f87330d;

    public m() {
        int r100 = 0;
        this(r100, 0, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L14;
        m r101 = (m) r100;
        if (this.f87327a == r101.f87327a) goto L8;
        return false;
    L8:
        if (this.f87328b == r101.f87328b) goto L10;
        return false;
    L10:
        if (this.f87329c == r101.f87329c) goto L12;
        return false;
    L12:
        if (this.f87330d == r101.f87330d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f87327a * 31;
        long r101 = this.f87328b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f87329c;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f87330d;
        return r104 + ((int) (r105 ^ (r105 >>> 32)));
    }

    public final String toString() {
        return "GuardInfo(guardStatus=" + this.f87327a + ", activeGuardDay=" + this.f87328b + ", totalGuardDay=" + this.f87329c + ", expireTime=" + this.f87330d + ")";
    }

    public final String a() {
        int r100 = this.f87327a;
        if (r100 != GuardStatus.NotParticipateGuard.getValue()) goto L6;
        return "nonactivated";
    L6:
        if (r100 != GuardStatus.ActiveGuard.getValue()) goto L9;
        return "activated";
    L9:
        if (r100 != GuardStatus.InactiveGuard.getValue()) goto L13;
        return AiBotPollingAuthResult.STATUS_EXPIRED;
    L13:
        return "nonactivated";
    }

    public /* synthetic */ m(int r110, long r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        r110 = GuardStatus.NoGuard.getValue();
    L5:
        int r100 = r110;
        if ((r112 & 2) == 0) goto L8;
        long r101 = -1;
    L10:
        if ((r112 & 4) == 0) goto L12;
        long r102 = -1;
    L14:
        if ((r112 & 8) == 0) goto L16;
        r111 = -1;
    L16:
        this(r100, r101, r102, r111);
        return;
    L12:
        r102 = 0;
        goto L14
    L8:
        r101 = 0;
        goto L10
    }

    public m(int r100, long r101, long r102, long r103) {
        this.f87327a = r100;
        this.f87328b = r101;
        this.f87329c = r102;
        this.f87330d = r103;
    }
}
