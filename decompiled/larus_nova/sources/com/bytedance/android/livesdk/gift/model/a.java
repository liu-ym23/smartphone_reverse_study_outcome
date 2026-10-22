package com.bytedance.android.livesdk.gift.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<q2> f126376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<r3> f126377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t3 f126378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s3 f126379d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f126376a, r101.f126376a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f126377b, r101.f126377b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f126378c, r101.f126378c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f126379d, r101.f126379d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        List<q2> r100 = this.f126376a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<r3> r104 = this.f126377b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        t3 r107 = this.f126378c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        s3 r110 = this.f126379d;
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
        return "AssetEffectMessageInfo(imageInfoList=" + this.f126376a + ", textInfoList=" + this.f126377b + ", textPrivilegeInfo=" + this.f126378c + ", textPrivilegeDressInfo=" + this.f126379d + ")";
    }

    public a(List<q2> r100, List<r3> r101, t3 r102, s3 r103) {
        Intrinsics.checkNotNullParameter(r100, "imageInfoList");
        Intrinsics.checkNotNullParameter(r101, "textInfoList");
        this.f126376a = r100;
        this.f126377b = r101;
        this.f126378c = r102;
        this.f126379d = r103;
    }
}
