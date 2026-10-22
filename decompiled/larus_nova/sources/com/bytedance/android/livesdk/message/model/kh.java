package com.bytedance.android.livesdk.message.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class kh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MusicPanel f153660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f153661b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof kh) == false) goto L10;
        kh r101 = (kh) r100;
        if (Intrinsics.areEqual(this.f153660a, r101.f153660a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f153661b, r101.f153661b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        MusicPanel r100 = this.f153660a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f153661b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenKSongEvent(musicPanel=" + this.f153660a + ", source=" + this.f153661b + ")";
    }

    public kh(MusicPanel r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "musicPanel");
        this.f153660a = r100;
        this.f153661b = r101;
    }
}
