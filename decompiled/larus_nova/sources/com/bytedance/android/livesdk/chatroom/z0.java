package com.bytedance.android.livesdk.chatroom;

/* JADX INFO: loaded from: classes7.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f119328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f119329b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof z0) == false) goto L10;
        z0 r101 = (z0) r100;
        if (this.f119328a == r101.f119328a) goto L8;
        return false;
    L8:
        if (this.f119329b == r101.f119329b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f119328a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f119329b;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "SeiTimePair(seiTimeInMilliseconds=" + this.f119328a + ", receiveSeiTimeInMilliseconds=" + this.f119329b + ")";
    }

    public z0(long r100, long r101) {
        this.f119328a = r100;
        this.f119329b = r101;
    }
}
