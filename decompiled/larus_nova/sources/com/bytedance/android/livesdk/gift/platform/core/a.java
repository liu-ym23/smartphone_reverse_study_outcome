package com.bytedance.android.livesdk.gift.platform.core;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f130451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f130452b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.f130451a == r101.f130451a) goto L8;
        return false;
    L8:
        if (this.f130452b == r101.f130452b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f130451a * 31;
        long r101 = this.f130452b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "AssetFrequentStruct(times=" + this.f130451a + ", lastFetchTimeStamp=" + this.f130452b + ")";
    }

    public a(int r100, long r101) {
        this.f130451a = r100;
        this.f130452b = r101;
    }
}
