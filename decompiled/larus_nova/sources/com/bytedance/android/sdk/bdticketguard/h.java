package com.bytedance.android.sdk.bdticketguard;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f163722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f163723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f163724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f163725d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f163726e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f163727f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f163728g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f163729h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f163730i;

    public h() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L41:
        return true;
    L5:
        if ((r100 instanceof h) == false) goto L40;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f163722a, r101.f163722a) == false) goto L40;
        if (Intrinsics.areEqual(this.f163723b, r101.f163723b) == false) goto L40;
        if (this.f163724c != r101.f163724c) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == false) goto L40;
        if (this.f163725d != r101.f163725d) goto L18;
        boolean r103 = true;
    L19:
        if (r103 == false) goto L40;
        if (Intrinsics.areEqual(this.f163726e, r101.f163726e) == false) goto L40;
        if (this.f163727f != r101.f163727f) goto L25;
        boolean r104 = true;
    L26:
        if (r104 == false) goto L40;
        if (Intrinsics.areEqual(this.f163728g, r101.f163728g) == false) goto L40;
        if (this.f163729h != r101.f163729h) goto L32;
        boolean r105 = true;
    L33:
        if (r105 == false) goto L40;
        if (this.f163730i != r101.f163730i) goto L37;
        boolean r106 = true;
    L38:
        if (r106 == false) goto L40;
    L37:
        r106 = false;
        goto L38
    L32:
        r105 = false;
        goto L33
    L25:
        r104 = false;
        goto L26
    L18:
        r103 = false;
        goto L19
    L13:
        r102 = false;
    L40:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        String r100 = this.f163722a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f163723b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((((r103 + r105) * 31) + this.f163724c) * 31) + this.f163725d) * 31;
        String r107 = this.f163726e;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + this.f163727f) * 31;
        String r110 = this.f163728g;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        int r111 = (((r109 + r101) * 31) + this.f163729h) * 31;
        boolean r112 = this.f163730i;
        ?? r113 = r112;
        if (r112 == false) goto L21;
        r113 = 1;
    L21:
        return r111 + r113;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ConsumerRequestExtra(teePub=" + this.f163722a + ", reePub=" + this.f163723b + ", attestSignErrorCode=" + this.f163724c + ", attestSignCreateErrorCode=" + this.f163725d + ", attestSignErrorDesc=" + this.f163726e + ", teeStaticSignErrorCode=" + this.f163727f + ", teeStaticSignErrorMsg=" + this.f163728g + ", teeCreateErrorCode=" + this.f163729h + ", isAppBootFinish=" + this.f163730i + ")";
    }

    public /* synthetic */ h(int r110) {
        this("", "", 0, 0, "", 0, "", 0, true);
    }

    public h(String r100, String r101, int r102, int r103, String r104, int r105, String r106, int r107, boolean r108) {
        this.f163722a = r100;
        this.f163723b = r101;
        this.f163724c = r102;
        this.f163725d = r103;
        this.f163726e = r104;
        this.f163727f = r105;
        this.f163728g = r106;
        this.f163729h = r107;
        this.f163730i = r108;
    }
}
