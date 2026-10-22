package com.bytedance.android.live.recharge.nopassword;

import com.bytedance.android.live.recharge.model.NoPasswordFansConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f90044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f90045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f90046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f90047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f90048e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final NoPasswordFansConfig f90049f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (this.f90044a == r101.f90044a) goto L8;
        return false;
    L8:
        if (this.f90045b == r101.f90045b) goto L10;
        return false;
    L10:
        if (this.f90046c == r101.f90046c) goto L12;
        return false;
    L12:
        if (this.f90047d == r101.f90047d) goto L14;
        return false;
    L14:
        if (this.f90048e == r101.f90048e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f90049f, r101.f90049f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        boolean r100 = this.f90044a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        long r103 = this.f90045b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f90046c;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        boolean r107 = this.f90047d;
        if (r107 == true) goto L9;
        r101 = r107;
    L9:
        int r108 = (r106 + r101) * 31;
        long r109 = this.f90048e;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        NoPasswordFansConfig r111 = this.f90049f;
        if (r111 == null) goto L12;
        int r112 = r111.hashCode();
    L14:
        return r110 + r112;
    L12:
        r112 = 0;
        goto L14
    }

    public final String toString() {
        return "NoPasswordConfig(enable=" + this.f90044a + ", minDiamond=" + this.f90045b + ", maxDiamond=" + this.f90046c + ", sendNoticeMessageEnable=" + this.f90047d + ", sendNoticeMessageDelay=" + this.f90048e + ", fansClubConfig=" + this.f90049f + ")";
    }

    public c(boolean r100, long r101, long r102, boolean r103, long r104, NoPasswordFansConfig r110) {
        Intrinsics.checkNotNullParameter(r110, "fansClubConfig");
        this.f90044a = r100;
        this.f90045b = r101;
        this.f90046c = r102;
        this.f90047d = r103;
        this.f90048e = r104;
        this.f90049f = r110;
    }
}
