package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import com.bytedance.android.livesdk.gift.model.l1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l1 f127471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final py.k f127472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final py.k f127473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f127474d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o0) == false) goto L14;
        o0 r101 = (o0) r100;
        if (Intrinsics.areEqual(this.f127471a, r101.f127471a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f127472b, r101.f127472b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f127473c, r101.f127473c) == true) goto L12;
        return false;
    L12:
        if (this.f127474d == r101.f127474d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        l1 r100 = this.f127471a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        py.k r104 = this.f127472b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        py.k r107 = this.f127473c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        long r109 = this.f127474d;
        return r108 + ((int) (r109 ^ (r109 >>> 32)));
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "VMBuffInfo(buffInfo=" + this.f127471a + ", showImg=" + this.f127472b + ", dynamicShowImg=" + this.f127473c + ", originId=" + this.f127474d + ")";
    }

    public final l1 a() {
        return this.f127471a;
    }

    public final py.k b() {
        return this.f127473c;
    }

    public final long c() {
        return this.f127474d;
    }

    public final py.k d() {
        return this.f127472b;
    }

    public o0(l1 r100, py.k r101, py.k r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "buffInfo");
        Intrinsics.checkNotNullParameter(r101, "showImg");
        this.f127471a = r100;
        this.f127472b = r101;
        this.f127473c = r102;
        this.f127474d = r103;
    }
}
