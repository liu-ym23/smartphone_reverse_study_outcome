package com.bytedance.android.shopping.anchorv3.view;

import com.bytedance.android.ec.model.ECUrlModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECUrlModel f165570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f165571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f165572c;

    public z() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof z) == false) goto L12;
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.f165570a, r101.f165570a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f165571b, r101.f165571b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f165572c, r101.f165572c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r100 = this.f165570a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f165571b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f165572c;
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
        return "LiveStrandVO(avatar=" + this.f165570a + ", navLink=" + this.f165571b + ", nickName=" + this.f165572c + ")";
    }

    public z(ECUrlModel r100, String r101, String r102) {
        this.f165570a = r100;
        this.f165571b = r101;
        this.f165572c = r102;
    }
}
