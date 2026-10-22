package com.bytedance.android.sdk.bdticketguard.key.attestation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.sdk.bdticketguard.data.a f163869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f163870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f163871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f163872d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f163873e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f163874f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L23:
        return true;
    L5:
        if ((r100 instanceof c) == false) goto L22;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f163869a, r101.f163869a) == false) goto L22;
        if (Intrinsics.areEqual(this.f163870b, r101.f163870b) == false) goto L22;
        if (Intrinsics.areEqual(this.f163871c, r101.f163871c) == false) goto L22;
        if (Intrinsics.areEqual(this.f163872d, r101.f163872d) == false) goto L22;
        if (Intrinsics.areEqual(this.f163873e, r101.f163873e) == false) goto L22;
        if (this.f163874f != r101.f163874f) goto L19;
        boolean r102 = true;
    L20:
        if (r102 == false) goto L22;
    L19:
        r102 = false;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        com.bytedance.android.sdk.bdticketguard.data.a r100 = this.f163869a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f163870b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f163871c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f163872d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        d r113 = this.f163873e;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        int r114 = (r112 + r101) * 31;
        boolean r115 = this.f163874f;
        ?? r116 = r115;
        if (r115 == false) goto L25;
        r116 = 1;
    L25:
        return r114 + r116;
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
        return "AttestationInfo(keyAttestationParams=" + this.f163869a + ", teePublicKey=" + this.f163870b + ", clientCert=" + this.f163871c + ", reePublicKey=" + this.f163872d + ", attestationAdapter=" + this.f163873e + ", regenerateKey=" + this.f163874f + ")";
    }

    public c(com.bytedance.android.sdk.bdticketguard.data.a r100, String r101, String r102, String r103, d r104, boolean r105) {
        this.f163869a = r100;
        this.f163870b = r101;
        this.f163871c = r102;
        this.f163872d = r103;
        this.f163873e = r104;
        this.f163874f = r105;
    }
}
