package com.bytedance.android.livesdk.wgamex.gameinvite;

/* JADX INFO: loaded from: classes11.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f160739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f160740b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L10;
        j r101 = (j) r100;
        if (this.f160739a == r101.f160739a) goto L8;
        return false;
    L8:
        if (this.f160740b == r101.f160740b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f160739a;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f160740b;
    }

    public final String toString() {
        return "ProfileInviteState(userId=" + this.f160739a + ", status=" + this.f160740b + ")";
    }

    public j(long r100, int r101) {
        this.f160739a = r100;
        this.f160740b = r101;
    }
}
