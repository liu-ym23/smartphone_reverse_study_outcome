package com.bytedance.android.livesdk.chatroom.widget;

/* JADX INFO: loaded from: classes8.dex */
public final class h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f118816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f118817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f118818c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h2) == false) goto L12;
        h2 r101 = (h2) r100;
        if (this.f118816a == r101.f118816a) goto L8;
        return false;
    L8:
        if (this.f118817b == r101.f118817b) goto L10;
        return false;
    L10:
        if (this.f118818c == r101.f118818c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f118816a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f118817b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f118818c;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    }

    public final String toString() {
        return "RevenuePreloadInfo(roomID=" + this.f118816a + ", channelID=" + this.f118817b + ", version=" + this.f118818c + ")";
    }

    public h2(long r100, long r101, long r102) {
        this.f118816a = r100;
        this.f118817b = r101;
        this.f118818c = r102;
    }
}
