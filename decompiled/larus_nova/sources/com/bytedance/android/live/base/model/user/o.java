package com.bytedance.android.live.base.model.user;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class o {
    public static final String a(IBaseUser r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$secUidExt");
        return r100.getCastSecUid();
    }

    public static final boolean b(IBaseUser r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isAdminExt");
        py.t r101 = r100.getUserAttr();
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isAdmin();
    }

    public static final void c(IBaseUser r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$secUidExt");
        r100.setCastSecUid(r101);
    }
}
