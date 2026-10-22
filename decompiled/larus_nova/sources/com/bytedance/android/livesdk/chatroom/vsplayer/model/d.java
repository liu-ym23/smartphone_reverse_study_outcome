package com.bytedance.android.livesdk.chatroom.vsplayer.model;

/* JADX INFO: loaded from: classes8.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f118414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f118415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f118416c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (this.f118414a == r101.f118414a) goto L8;
        return false;
    L8:
        if (this.f118415b == r101.f118415b) goto L10;
        return false;
    L10:
        if (this.f118416c == r101.f118416c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f118414a * 31;
        long r101 = this.f118415b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f118416c;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    }

    public final String toString() {
        return "VSProgressGestureEvent(actionType=" + this.f118414a + ", mSeekToTime=" + this.f118415b + ", mTotalTime=" + this.f118416c + ")";
    }

    public /* synthetic */ d(int r100) {
        this(r100, 0, 0);
    }

    public d(int r100, long r101, long r102) {
        this.f118414a = r100;
        this.f118415b = r101;
        this.f118416c = r102;
    }
}
