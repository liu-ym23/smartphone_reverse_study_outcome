package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.android.live.base.model.message.a5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f88424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a5 f88425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f88426c;

    public c() {
        this(0, null, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (this.f88424a == r101.f88424a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f88425b, r101.f88425b) == true) goto L10;
        return false;
    L10:
        if (this.f88426c == r101.f88426c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f88424a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        a5 r102 = this.f88425b;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L6:
        long r104 = this.f88426c;
        return ((r101 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "DynamicInfoData(showAfterTimeMs=" + this.f88424a + ", text=" + this.f88425b + ", durationMs=" + this.f88426c + ")";
    }

    public c(long r100, a5 r101, long r102) {
        this.f88424a = r100;
        this.f88425b = r101;
        this.f88426c = r102;
    }
}
