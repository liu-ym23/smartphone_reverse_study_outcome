package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.t2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBaseUser f128474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t2 f128475b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L10;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f128474a, r101.f128474a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f128475b, r101.f128475b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        IBaseUser r100 = this.f128474a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        t2 r104 = this.f128475b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GiftPanelUserInfo(user=" + this.f128474a + ", groupMemberInfo=" + this.f128475b + ")";
    }

    public h(IBaseUser r100, t2 r101) {
        Intrinsics.checkNotNullParameter(r100, "user");
        this.f128474a = r100;
        this.f128475b = r101;
    }
}
