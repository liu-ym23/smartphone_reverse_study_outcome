package com.bytedance.android.sdk.bdticketguard;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.sdk.bdticketguard.data.a f163553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f163554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f163555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f163556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f163557e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h0 f163558f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f163559g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L25:
        return true;
    L5:
        if ((r100 instanceof b) == false) goto L24;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f163553a, r101.f163553a) == false) goto L24;
        if (Intrinsics.areEqual(this.f163554b, r101.f163554b) == false) goto L24;
        if (Intrinsics.areEqual(this.f163555c, r101.f163555c) == false) goto L24;
        if (Intrinsics.areEqual(this.f163556d, r101.f163556d) == false) goto L24;
        if (Intrinsics.areEqual(this.f163557e, r101.f163557e) == false) goto L24;
        if (Intrinsics.areEqual(this.f163558f, r101.f163558f) == false) goto L24;
        if (this.f163559g != r101.f163559g) goto L21;
        boolean r102 = true;
    L22:
        if (r102 == false) goto L24;
    L21:
        r102 = false;
    L24:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.sdk.bdticketguard.data.a r100 = this.f163553a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f163554b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f163555c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f163556d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f163557e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        h0 r116 = this.f163558f;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return ((r115 + r101) * 31) + this.f163559g;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
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
        return "AttestationRequest(keyAttestationParams=" + this.f163553a + ", teePublicKey=" + this.f163554b + ", reePublicKey=" + this.f163555c + ", clientCert=" + this.f163556d + ", certChain=" + this.f163557e + ", alternateParams=" + this.f163558f + ", attestType=" + this.f163559g + ")";
    }

    public b(com.bytedance.android.sdk.bdticketguard.data.a r100, String r101, String r102, String r103, String r104, h0 r105, int r106) {
        this.f163553a = r100;
        this.f163554b = r101;
        this.f163555c = r102;
        this.f163556d = r103;
        this.f163557e = r104;
        this.f163558f = r105;
        this.f163559g = r106;
    }
}
