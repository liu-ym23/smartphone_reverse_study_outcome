package com.bytedance.android.live.user.api;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.user.api.event.UpdateUserReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f102506c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final User f102507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UpdateUserReason f102508b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f102507a, r101.f102507a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f102508b, r101.f102508b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        User r100 = this.f102507a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        UpdateUserReason r104 = this.f102508b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "UserData(user=" + this.f102507a + ", updateUserReason=" + this.f102508b + ")";
    }

    public c(User r100, UpdateUserReason r101) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r101, "updateUserReason");
        this.f102507a = r100;
        this.f102508b = r101;
    }
}
