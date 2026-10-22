package com.bytedance.android.livesdk.network.predict;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f154026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f154027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f154028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f154029d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (this.f154027b == r101.f154027b) goto L8;
        return false;
    L8:
        if (this.f154028c == r101.f154028c) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f154029d, r101.f154029d) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.f154027b * 31) + this.f154028c) * 31;
        String r101 = this.f154029d;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "StreamInfo(type=" + this.f154027b + ", detail=" + this.f154028c + ", msg=" + this.f154029d + ")";
    }

    public final int getType() {
        return this.f154027b;
    }

    public d(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f154027b = 0;
        this.f154028c = r100;
        this.f154029d = r101;
        this.f154026a = System.currentTimeMillis();
    }
}
