package com.bytedance.android.livesdk.gift.platform.core.preview;

import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f130976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f130977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f130978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f130979d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k f130980e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f130981f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L18;
        b r101 = (b) r100;
        if (this.f130976a == r101.f130976a) goto L8;
        return false;
    L8:
        if (this.f130977b == r101.f130977b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f130978c, r101.f130978c) == true) goto L12;
        return false;
    L12:
        if (this.f130979d == r101.f130979d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f130980e, r101.f130980e) == true) goto L16;
        return false;
    L16:
        if (this.f130981f == r101.f130981f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    public final int hashCode() {
        long r100 = this.f130976a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f130977b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        String r104 = this.f130978c;
        int r105 = 0;
        if (r104 == null) goto L5;
        int r106 = r104.hashCode();
    L6:
        int r107 = (((r103 + r106) * 31) + this.f130979d) * 31;
        k r108 = this.f130980e;
        if (r108 == null) goto L9;
        r105 = r108.hashCode();
    L9:
        int r109 = (r107 + r105) * 31;
        boolean r110 = this.f130981f;
        ?? r111 = r110;
        if (r110 == false) goto L13;
        r111 = 1;
    L13:
        return r109 + r111;
    L5:
        r106 = 0;
        goto L6
    }

    public final String toString() {
        return "GiftStruct(id=" + this.f130976a + ", primaryEffectId=" + this.f130977b + ", name=" + this.f130978c + ", diamondCount=" + this.f130979d + ", image=" + this.f130980e + ", selected=" + this.f130981f + ")";
    }

    public b(long r100, long r101, String r102, int r103, k r104) {
        Intrinsics.checkNotNullParameter(r102, "name");
        this.f130976a = r100;
        this.f130977b = r101;
        this.f130978c = r102;
        this.f130979d = r103;
        this.f130980e = r104;
        this.f130981f = false;
    }
}
