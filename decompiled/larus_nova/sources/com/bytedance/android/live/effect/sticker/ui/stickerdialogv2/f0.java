package com.bytedance.android.live.effect.sticker.ui.stickerdialogv2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f68739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f68740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f68741c;

    public f0() {
        this(null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f0) == false) goto L12;
        f0 r101 = (f0) r100;
        if (Intrinsics.areEqual(this.f68739a, r101.f68739a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f68740b, r101.f68740b) == true) goto L10;
        return false;
    L10:
        if (this.f68741c == r101.f68741c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f68739a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f68740b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        long r106 = this.f68741c;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "StickerDialogPageStatus(tabKey=" + this.f68739a + ", secondaryTabKey=" + this.f68740b + ", stickerID=" + this.f68741c + ")";
    }

    public /* synthetic */ f0(String r100, int r101) {
        String r102 = "";
        if ((r101 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r101 & 2) != 0) goto L9;
        r102 = null;
    L9:
        this(r100, r102, 0);
    }

    public f0(String r100, String r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "tabKey");
        Intrinsics.checkNotNullParameter(r101, "secondaryTabKey");
        this.f68739a = r100;
        this.f68740b = r101;
        this.f68741c = r102;
    }
}
