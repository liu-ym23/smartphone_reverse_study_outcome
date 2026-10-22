package com.bytedance.android.live.base.model.message.guestlink;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class l {
    public static final boolean a(k r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isGuestBefore");
        if (r100.getUserRoleBefore() != LinkmicGuestLinkUserRoleBefore.LinkmicGuestLinkUserRoleBefore_Guest.getValue()) goto L5;
        return true;
    L5:
        return false;
    }
}
