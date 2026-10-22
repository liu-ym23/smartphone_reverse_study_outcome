package com.bytedance.android.live.base.model.user;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class n {
    public static final long a(IBaseUser r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$liveRoomIdExt");
        Intrinsics.checkNotNullParameter(r100, "$this$ownRoomExt");
        py.o r101 = r100.getOwnRoom();
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getId();
    }
}
