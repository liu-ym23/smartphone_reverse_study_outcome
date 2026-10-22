package com.bytedance.android.livesdk.chatroom.vsplayer.model;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f118397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f118398b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (this.f118397a == r101.f118397a) goto L8;
        return false;
    L8:
        if (this.f118398b == r101.f118398b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f118397a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f118398b;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "VSPlayTimeInfo(currentTime=" + this.f118397a + ", totalTime=" + this.f118398b + ")";
    }

    public b(long r100, long r101) {
        this.f118397a = r100;
        this.f118398b = r101;
    }
}
