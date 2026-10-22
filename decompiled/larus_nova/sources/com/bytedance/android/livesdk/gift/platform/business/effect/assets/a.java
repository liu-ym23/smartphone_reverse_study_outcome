package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f129077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f129078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f129079c;

    public a() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f129077a, r101.f129077a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f129078b, r101.f129078b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f129079c, r101.f129079c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f129077a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f129078b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f129079c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AssetMD5Model(md5=" + this.f129077a + ", h265Md5=" + this.f129078b + ", superH265Md5=" + this.f129079c + ")";
    }

    public a(String r100, String r101, String r102) {
        this.f129077a = r100;
        this.f129078b = r101;
        this.f129079c = r102;
    }
}
