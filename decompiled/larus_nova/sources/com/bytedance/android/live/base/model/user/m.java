package com.bytedance.android.live.base.model.user;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class m {
    public static final String a(IBaseUser r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$idStringExt");
        return String.valueOf(r100.getUserId());
    }
}
