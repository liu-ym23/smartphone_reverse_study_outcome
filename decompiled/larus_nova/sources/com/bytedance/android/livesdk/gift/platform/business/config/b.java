package com.bytedance.android.livesdk.gift.platform.business.config;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {
    public static final boolean a(a r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$inEnableDefaultSelectLockedCardTabs");
        return r100.l6().contains(Integer.valueOf(r101));
    }

    public static final boolean b(a r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$inEnableManualSelectLockedCardTabs");
        return r100.a5().contains(Integer.valueOf(r101));
    }

    public static final boolean c(a r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$isEnableDefaultSelectLockedCurrentTab");
        return r100.l6().contains(Integer.valueOf(r101));
    }
}
