package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.utils;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f140044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap f140045b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f140044a, r101.f140044a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f140045b, r101.f140045b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Bitmap r100 = this.f140044a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Bitmap r104 = this.f140045b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ImageSet(image=" + this.f140044a + ", qrCode=" + this.f140045b + ")";
    }

    public a(Bitmap r100, Bitmap r101) {
        this.f140044a = r100;
        this.f140045b = r101;
    }
}
