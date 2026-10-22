package com.bytedance.android.livesdk.ktvimpl.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f142392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f142393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f142394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f142395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f142396e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f142392a, r101.f142392a) == true) goto L8;
        return false;
    L8:
        if (this.f142393b == r101.f142393b) goto L10;
        return false;
    L10:
        if (this.f142394c == r101.f142394c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f142395d, r101.f142395d) == true) goto L14;
        return false;
    L14:
        if (this.f142396e == r101.f142396e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    public final int hashCode() {
        String r100 = this.f142392a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f142393b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        boolean r105 = this.f142394c;
        ?? r106 = r105;
        if (r105 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f142395d;
        if (r108 == null) goto L13;
        r101 = r108.hashCode();
    L13:
        return ((r107 + r101) * 31) + this.f142396e;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "KaraokeMusicParam(musicId=" + this.f142392a + ", singProgress=" + this.f142393b + ", isSinger=" + this.f142394c + ", lyricUrl=" + this.f142395d + ", lyricType=" + this.f142396e + ")";
    }

    public a(String r100, long r101, boolean r102, String r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        Intrinsics.checkNotNullParameter(r103, "lyricUrl");
        this.f142392a = r100;
        this.f142393b = r101;
        this.f142394c = r102;
        this.f142395d = r103;
        this.f142396e = r104;
    }
}
