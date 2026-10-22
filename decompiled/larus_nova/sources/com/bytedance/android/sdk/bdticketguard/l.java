package com.bytedance.android.sdk.bdticketguard;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f163941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f163942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f163943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f163944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f163945e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L16;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f163941a, r101.f163941a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f163942b, r101.f163942b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f163943c, r101.f163943c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f163944d, r101.f163944d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f163945e, r101.f163945e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f163941a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f163942b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f163943c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f163944d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f163945e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "ConsumerResponseExtra(remoteAttestVerifyError=" + this.f163941a + ", teeError=" + this.f163942b + ", signResPassType=" + this.f163943c + ", remoteStaticSignError=" + this.f163944d + ", remoteStaticTsSignError=" + this.f163945e + ")";
    }

    public l() {
        this("", "", "", null, null);
    }

    public l(String r100, String r101, String r102, String r103, String r104) {
        this.f163941a = r100;
        this.f163942b = r101;
        this.f163943c = r102;
        this.f163944d = r103;
        this.f163945e = r104;
    }
}
