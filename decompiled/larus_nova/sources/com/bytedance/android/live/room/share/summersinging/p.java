package com.bytedance.android.live.room.share.summersinging;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f100364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap f100365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bitmap f100366c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L12;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f100364a, r101.f100364a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f100365b, r101.f100365b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f100366c, r101.f100366c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Bitmap r100 = this.f100364a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Bitmap r104 = this.f100365b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Bitmap r107 = this.f100366c;
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
        return "ImageBitmapStore(photo=" + this.f100364a + ", avatar=" + this.f100365b + ", qrCode=" + this.f100366c + ")";
    }

    public p(Bitmap r100, Bitmap r101, Bitmap r102) {
        this.f100364a = r100;
        this.f100365b = r101;
        this.f100366c = r102;
    }
}
