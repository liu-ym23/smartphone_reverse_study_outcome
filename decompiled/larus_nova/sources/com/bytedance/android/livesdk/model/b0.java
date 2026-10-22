package com.bytedance.android.livesdk.model;

/* JADX INFO: loaded from: classes11.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f153927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f153928b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b0) == false) goto L10;
        b0 r101 = (b0) r100;
        if (this.f153927a == r101.f153927a) goto L8;
        return false;
    L8:
        if (this.f153928b == r101.f153928b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f153927a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f153928b;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "LocalProgress(duration=" + this.f153927a + ", ts=" + this.f153928b + ")";
    }

    public b0(long r100, long r101) {
        this.f153927a = r100;
        this.f153928b = r101;
    }
}
