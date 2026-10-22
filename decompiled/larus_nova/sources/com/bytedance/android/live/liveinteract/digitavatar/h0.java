package com.bytedance.android.live.liveinteract.digitavatar;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AvatarGender f72638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f72639b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h0) == false) goto L10;
        h0 r101 = (h0) r100;
        if (Intrinsics.areEqual(this.f72638a, r101.f72638a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f72639b, r101.f72639b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        AvatarGender r100 = this.f72638a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f72639b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "UpdateAvatarParams(gender=" + this.f72638a + ", avatarModel=" + this.f72639b + ")";
    }

    public h0(AvatarGender r100) {
        Intrinsics.checkNotNullParameter(r100, "gender");
        Intrinsics.checkNotNullParameter("", "avatarModel");
        this.f72638a = r100;
        this.f72639b = "";
    }
}
