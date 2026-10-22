package com.bytedance.android.shopping.deepfeed.slice.view.video;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f173662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f173663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f173664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f173665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f173666e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f173667f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f173662a, r101.f173662a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f173663b, r101.f173663b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f173664c, r101.f173664c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f173665d, r101.f173665d) == true) goto L14;
        return false;
    L14:
        if (this.f173666e == r101.f173666e) goto L16;
        return false;
    L16:
        if (this.f173667f == r101.f173667f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f173662a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f173663b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f173664c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f173665d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return ((((r109 + r101) * 31) + this.f173666e) * 31) + this.f173667f;
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
        return "DeepFeedSliceVideoWarmMeta(warmKey=" + this.f173662a + ", vid=" + this.f173663b + ", src=" + this.f173664c + ", cover=" + this.f173665d + ", width=" + this.f173666e + ", height=" + this.f173667f + ")";
    }

    public c(String r100, String r101, String r102, String r103, int r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "warmKey");
        Intrinsics.checkNotNullParameter(r101, "vid");
        Intrinsics.checkNotNullParameter(r102, "src");
        this.f173662a = r100;
        this.f173663b = r101;
        this.f173664c = r102;
        this.f173665d = r103;
        this.f173666e = r104;
        this.f173667f = r105;
    }
}
