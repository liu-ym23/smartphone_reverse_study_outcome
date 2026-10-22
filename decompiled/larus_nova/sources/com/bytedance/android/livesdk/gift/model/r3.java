package com.bytedance.android.livesdk.gift.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f126408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f126409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f126410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f126411d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r3) == false) goto L14;
        r3 r101 = (r3) r100;
        if (Intrinsics.areEqual(this.f126408a, r101.f126408a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f126409b, r101.f126409b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f126410c, r101.f126410c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f126411d, r101.f126411d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f126408a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f126409b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f126410c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f126411d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "TextAssetInfo(placeHolderKey=" + this.f126408a + ", content=" + this.f126409b + ", fontSize=" + this.f126410c + ", fontColor=" + this.f126411d + ")";
    }

    public r3(String r100, String r101, Long r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "placeHolderKey");
        Intrinsics.checkNotNullParameter(r101, "content");
        this.f126408a = r100;
        this.f126409b = r101;
        this.f126410c = r102;
        this.f126411d = r103;
    }
}
