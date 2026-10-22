package com.bytedance.android.livesdk.chatroom.resolution.tips.stall;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f110526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f110527b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.f110526a == r101.f110526a) goto L8;
        return false;
    L8:
        if (this.f110527b == r101.f110527b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f110526a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f110527b;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "AudienceStallInfo(stallStartTime=" + this.f110526a + ", stallEndTime=" + this.f110527b + ")";
    }

    public a(long r100, long r101) {
        this.f110526a = r100;
        this.f110527b = r101;
    }
}
