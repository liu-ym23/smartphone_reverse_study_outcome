package com.bytedance.android.livesdk.viewmodel;

/* JADX INFO: loaded from: classes11.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f159323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f159324b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L10;
        g r101 = (g) r100;
        if (this.f159323a == r101.f159323a) goto L8;
        return false;
    L8:
        if (this.f159324b == r101.f159324b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f159323a * 31;
        long r101 = this.f159324b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "PostionAndRoomId(position=" + this.f159323a + ", roomId=" + this.f159324b + ")";
    }

    public g(int r100, long r101) {
        this.f159323a = r100;
        this.f159324b = r101;
    }
}
