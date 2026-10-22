package com.bytedance.android.live.revlink.impl.control;

/* JADX INFO: loaded from: classes47.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f92452a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == true) goto L6;
        return false;
    L6:
        if (this.f92452a == ((r) r100).f92452a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f92452a;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public final String toString() {
        return "MultiInfo(channelId=" + this.f92452a + ")";
    }

    public r(long r100) {
        this.f92452a = r100;
    }
}
